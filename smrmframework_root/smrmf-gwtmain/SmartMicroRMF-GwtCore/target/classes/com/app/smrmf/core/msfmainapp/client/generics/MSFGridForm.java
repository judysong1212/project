/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Element;

public class MSFGridForm extends LayoutContainer {
    private MSFCustomForm       customForm;
    private MSFPanelCustomForm  MSFPanelCustomForm;
    private MSFGridPanel        msfGridPanel;
    private BaseModel           lastRecordSelected = null;
    private TableDef            tableDef;
    private Grid<BaseModel>     grid;
    private int                 h = 0; 
    private BorderLayoutData    northData;
    private BorderLayoutData    eastData;
    private BorderLayoutData    centerData;
    private Orientation         orientation;

    public MSFGridForm(TableDef tableDef) {
        this(tableDef, 0, 500, Orientation.HORIZONTAL);
    }

    @Deprecated
    public MSFGridForm(TableDef tableDef, int height) {
        this(tableDef, height, 500, Orientation.VERTICAL);
    }

    @Deprecated
    public MSFGridForm(TableDef tableDef, int height, int width) {
        this(tableDef, height, 500, Orientation.HORIZONTAL);
    }

    @Deprecated
    public MSFGridForm(TableDef tableDef, int height, int width, int widthForm) {
        this(tableDef, height, widthForm, Orientation.HORIZONTAL);
    }

    /**
     * Permette di creare un oggetto con griglia e form di dettaglio del record selezionato.
     * I due blocchi dell'oggetto grafico � possibile orientarli in VERTICALE o ORIZZONTALE.
     * 
     * @param tableDef    � la definizione della tabella
     * @param heightGrid  nel caso di Orientation.VERTICAL, questo parametro definisce l'altezza 
     * della griglia, mentre la form occuper� tutto il rimanente spazio 
     * (default: 1000 se verticale, 500 se orizzontale) 
     * @param widthForm   nel caso di Orientation.HORIZONTAL, questo parametro definisce la 
     * larghezza della form, mentre la griglia occuper� tutto il rimanente spazio a SX
     * (default: 200 se verticale)
     * @param orientation indica orientamento dell'oggetto grafico, utilizzando le constanti 
     * Orientation.VERTICAL o HORIZONTAL 
     */
    public MSFGridForm(TableDef tableDef, int heightGrid, int widthForm, Orientation orientation) {
        this.tableDef    = tableDef;
        this.orientation = orientation;
        if (widthForm == 0) {
            if (orientation.equals(Orientation.VERTICAL)) {
                widthForm = 1000;
            } else {
                widthForm = 500;
            }
        }
        if (heightGrid == 0) {
            if (orientation.equals(Orientation.VERTICAL)) {
                heightGrid = 200;
            }
        }

        BorderLayout borderLayout = new BorderLayout();
        this.setStyleAttribute("backgroundColor", "#FFFFFF");
        this.setLayout(borderLayout);
        if (this.orientation.equals(Orientation.HORIZONTAL)) {
            eastData   = new BorderLayoutData(LayoutRegion.EAST, widthForm);
        } else {
            northData  = new BorderLayoutData(LayoutRegion.NORTH, heightGrid);
        }
        centerData = new BorderLayoutData(LayoutRegion.CENTER);
        /**
         * Create the left grid, with only the columns defined in tableDef (isShowInGrid=true)
         */
        msfGridPanel = new MSFGridPanel(tableDef, true, false, true){
            @Override
            protected void goToForm(ActionDatabase actionDatabase) {
                workFormPanel=msfGridPanel.getMSFFormPanel();
                workFormPanel.setMSFGridPanel(this);
                workFormPanel.setActionDatabase(actionDatabase);
                switch (actionDatabase) {
                case INSERT:
                    List<Listener<? extends BaseEvent>> listenersOnSuccessSave = workFormPanel.getListeners(MSFCustomForm.OnSuccessSave);
                    if ( listenersOnSuccessSave==null || listenersOnSuccessSave.size()==0 ) {
                        workFormPanel.addListener(MSFCustomForm.OnSuccessSave, new Listener<BaseEvent>() {
                            public void handleEvent(BaseEvent be) {
                                fireEvent(MSFCustomForm.OnSuccessSave, be);
                            }
                        });
                    }
                    List<Listener<? extends BaseEvent>> listenersBind = workFormPanel.getFormBinding().getListeners(Events.Bind);
                    if ( listenersBind==null || listenersBind.size()==0 ) {
                        workFormPanel.getFormBinding().addListener(Events.Bind, new Listener<BaseEvent>() {
                            public void handleEvent(BaseEvent be) {
                                if ( ActionDatabase.INSERT.equals(workFormPanel.getActionDatabase()) ) {
                                    workFormPanel.enable();
                                    workFormPanel.clearStateFields();
                                }
                                msfGridPanel.fireEvent(MSFEvents.dataBindedIntoForm, new BaseEvent(workFormPanel));
                            }
                        });
                    }
                    workFormPanel.setActionDatabase(actionDatabase);
                    BaseModel bm = tableDef.getDefaultValues();
                    if (bm != null || workFormPanel.getFormBinding().getModel() != null) {
                        workFormPanel.disable();
                        workFormPanel.clear();
                        workFormPanel.bind(bm);
                    }
                    break;
                case DELETE:
                    MessageBox.confirm(MSFMainApp.MSFCONSTANTS.Alert(), MSFMainApp.MSFMESSAGES.msgDeleteRecords(1), new Listener<MessageBoxEvent>() {
                        //@Override
                        public void handleEvent(MessageBoxEvent be) {
                            if ("yes".equals(be.getButtonClicked().getItemId())){
                                customForm.setActionDatabase(ActionDatabase.DELETE);
                                customForm.save();
                            }
                        }
                    });
                    break;
                default:
                    super.goToForm(actionDatabase);
                    break;
                }
            }

        };

        if (this.orientation.equals(Orientation.HORIZONTAL)) {
            this.add(msfGridPanel, centerData);
            /**
             * This only a space between grid and form 
             */
            msfGridPanel.setStyleAttribute("paddingRight", "10px");

        } else {
            /**
             * This only a space between grid and form 
             */
            msfGridPanel.setStyleAttribute("paddingBottom", "10px");
            this.add(msfGridPanel, northData);
        }
        /**
         * Override the CellClickListener. It binds the currently selected grid item into the form
         */
        grid = msfGridPanel.getGrid();
        grid.getSelectionModel().addListener(Events.SelectionChange,new Listener<SelectionChangedEvent<BaseModel>>() {  
            public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                if (customForm.isDirty()) {
                    msfGridPanel.getMsfGrid().setCurrentlySelectedItem(lastRecordSelected);
                    grid.getSelectionModel().setFiresEvents(false);
                    grid.getSelectionModel().select(lastRecordSelected, false);
                    grid.getSelectionModel().setFiresEvents(true);
                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), MSFMainApp.MSFMESSAGES.SomethingToSave(), null);
                } else {
                    lastRecordSelected = grid.getSelectionModel().getSelectedItem();
                    if (!MSFGridForm.this.tableDef.isReadOnly()) {
                        customForm.enable();
                    }
                    customForm.bind(lastRecordSelected);
                }
            }
        });

        /**
         * Create the custom form with the field's position and width defined into tableDef
         * See: AttributeCustomForm 
         */
        MSFPanelCustomForm = new MSFPanelCustomForm(tableDef, widthForm, 90){
            @Override
            protected void onRender(Element parent, int pos) {
                super.onRender(parent, pos);
            }
        };
        MSFPanelCustomForm.setHeaderVisible(false);

        customForm = MSFPanelCustomForm.getCustomForm();
        msfGridPanel.setMSFFormPanel(customForm);
        customForm.setFrame(false);
        customForm.addListener(MSFCustomForm.OnSuccessSave, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                if (ActionDatabase.DELETE.equals(customForm.getActionDatabase()) || ActionDatabase.INSERT.equals(customForm.getActionDatabase()) ){
                    msfGridPanel.reload(); 
                }
                customForm.setActionDatabase(ActionDatabase.UPDATE);
            }
        });
        customForm.addListener(MSFCustomForm.OnClearState, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                customForm.setActionDatabase(ActionDatabase.UPDATE);
                if (msfGridPanel.getCurrentlySelectedItem() != null) {
                    customForm.bind(msfGridPanel.getCurrentlySelectedItem());
                }
            }
        });
        customForm.disable();
        /**
         * The next code shows as change the horizontal alignment of field's label.
         * Default, without this code, it's LEFT   
         */
        customForm.setLabelAlign(LabelAlign.RIGHT);


        if (this.orientation.equals(Orientation.HORIZONTAL)) {
            this.add(MSFPanelCustomForm, eastData);
        } else {
            this.add(MSFPanelCustomForm, centerData);
        }
    }

    public TableDef getTableDef() {
        return tableDef;
    }

    public void setHeightMSFGrid(int height){
        this.h = height;
        if (this.h > 0) {
            this.setHeight(this.h);
        }
    }

    public void setWidthGrid(int width){
        msfGridPanel.setWidth(width);
    }

    public BaseModel getLastRecordSelected() {
        return lastRecordSelected;
    }

    public Grid<BaseModel> getGrid() {
        return grid;
    }

    public void setMargin(int top, int bottom, int left, int right){
        if (top    != 0) setStyleAttribute("paddingTop"   , top+"px");
        if (bottom != 0) setStyleAttribute("paddingBottom", bottom+"px");
        if (left   != 0) setStyleAttribute("paddingLeft"  , left+"px");
        if (right  != 0) setStyleAttribute("paddingRight" , right+"px");
    }

    public int getHeight() {
        return this.h;
    }

    public MSFGridPanel getMsfGridPanel() {
        return msfGridPanel;
    }

    public void setMsfGridPanel(MSFGridPanel msfGridPanel) {
        this.msfGridPanel = msfGridPanel;
    }

    public MSFCustomForm getMsfCustomForm() {
        return customForm;
    }

}
