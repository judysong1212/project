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
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.widget.MSFLovField;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.LiveToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;

public class LovLiveGeneric extends Window {

    private Button btNew = null;
    private Button btOk = null;
    private Button btCancel = null;
    private LovDef lovDef;
    private TableDef editLovDef;
    private ToolBar toolBar;
    private boolean showBtnBar = true; 
    private MSFGrid msfGrid;
    private Grid<BaseModel> grid;
    private FormPanel initialForm;
    private LayoutContainer frmSearchLayer;
    private MSFLovField fieldCaller;
    
    private SelectionListener<ButtonEvent> buttonListener = new SelectionListener<ButtonEvent>() {  
        @Override  
        public void componentSelected(ButtonEvent ce) {  
            if (ce.getButton() == btNew) {
                // Close all the windows under and open new form to create new object
                MSFGridPanel initialGridPanel = null;
                TableDef initialTableDef = null;
                if (initialForm != null) {
                    if (initialForm instanceof MSFFormPanel) {
                        MSFFormPanel form = (MSFFormPanel)initialForm;
                        if (form != null) {
                            //Form per il caricamento dell'oggetto in lov, e non quello iniziale
                            //initialTableDef = form.getTableDef();
                            initialTableDef = editLovDef;
                            initialGridPanel = form.getMSFGridPanel();
                            MSFFormWindows w = form.getMSFWindows();
                            if (w != null && editLovDef!=null) {
                                w.hide();
                            }
                        }
                    }
                }

                //initialTableDef = lovDef;
                if (initialTableDef != null) {
                    MSFSimpleForm f = new MSFSimpleForm(
                            ActionDatabase.INSERT, 
                            initialTableDef);
                    f.setMSFGridPanel(initialGridPanel);
                    MSFFormWindows w = new MSFFormWindows(
                            initialTableDef.getTitle(), 
                            f, MSFMainApp.MSFCONSTANTS.BtSave(), MSFMainApp.MSFCONSTANTS.BtDelete());
                    w.show();
                    f.setMSFFormWindows(w);
                    FormBinding formBinding = f.getFormBinding();
                    if (formBinding != null) {
                        formBinding.bind(initialTableDef.getDefaultValues());
                    }
                }
                hide();
            } else if (ce.getButton() == btOk) {
               GWT.log("selectMode:" + msfGrid.getTableDef().isCheckBoxOnGridRows());
               if (msfGrid.getTableDef().isCheckBoxOnGridRows()) {
                   confirmMultiRecordSelected();
               } else {
                   confirmRecordSelected();
               }
               
            } else if (ce.getButton() == btCancel) {
                hide();
            }
        }  
    };
    
    private boolean lightBindRecord = false;

    private void confirmRecordSelected(){
        BaseModel item = msfGrid.getCurrentlySelectedItem();
        if (item != null) {
            // getForm called it, and binding values into fields.
            if (initialForm != null && initialForm instanceof MSFFormPanel) {
                MSFFormPanel form = (MSFFormPanel)initialForm;
                FormBinding binding = form.getFormBinding(); 
//                fieldCaller.setFireChangeEventOnSetValue(true); 
                lovDef.updateBaseModelForm(item, binding);  
              
                // Quanado trova che la lov � modificata forza l'evento change
                if (fieldCaller != null && fieldCaller.isDirty()){
                    //Normally the BaseEvent has no JS-Event attached. In this case we set it so that we can understand
                    //if change in the field has been done from the Lov window and then we can stop a subsequent lookup
                    Event e = DOM.eventGetCurrentEvent();//Event.getCurrentEvent();
                    BaseEvent fe = new FieldEvent(fieldCaller, e);
                    fieldCaller.fireEvent(Events.Change, fe); 
                }
                if (fieldCaller != null && binding != null) {
                    lightBindRecord = true;
                    binding.addListener(Events.Bind, new Listener<BaseEvent>() {
                        public void handleEvent(BaseEvent be) {
                            if (lightBindRecord) {
                                fieldCaller.fireEvent(MSFEvents.BindLovRecord);
                                lightBindRecord = false;
                            }
                        }
                    });
                } 
                
                binding.fireEvent(Events.Change,new BaseEvent(msfGrid.getCurrentlySelectedItem()));//,new BaseEvent((Object)DOM.eventGetCurrentEvent())
                //BaseModel bm = lovDef.getBaseModelForm(item);
                //if (bm != null && binding != null) {
                //    binding.bind(bm);
                //}
            }  else if (initialForm != null && initialForm instanceof FormPanel) { 
            	
            	 
            }
            hide();
        }
    }


    private void confirmMultiRecordSelected(){
        List<BaseModel> items = msfGrid.getGrid().getSelectionModel().getSelectedItems();
        if (items != null) {
            // getForm called it, and binding values into fields.
            if (initialForm != null && initialForm instanceof MSFFormPanel) {
                MSFFormPanel form = (MSFFormPanel)initialForm;
                FormBinding binding = form.getFormBinding();  
                
                binding.fireEvent(Events.Change,new BaseEvent(msfGrid.getGrid().getSelectionModel().getSelectedItems()));//,new BaseEvent((Object)DOM.eventGetCurrentEvent())
                
            }   
            hide();
        }
    }
    public LovLiveGeneric(LovDef lovDef) {
    	
        this(lovDef, null); 
    }

    public LovLiveGeneric(LovDef lovDef, TableDef editLovDef) {
        super();
        setPlain(true);  
        setModal(true);  
        setBlinkModal(true);  
        setLayout(new FitLayout());  
        setButtonAlign(HorizontalAlignment.CENTER);
        setHeadingText(lovDef.getTitle());//setHeading(lovDef.getTitle());
        this.lovDef = lovDef;
        setSearchForm(lovDef.getCustomLayoutContainer());
        this.editLovDef = editLovDef;
        
        
        msfGrid = new MSFGrid(lovDef, true){
            @Override
            public void onDoubleClickOnRecord() {
                super.onDoubleClickOnRecord();
                if (msfGrid.getTableDef().isCheckBoxOnGridRows()) {
                    return;
                   // confirmMultiRecordSelected();
                } else {
                    confirmRecordSelected();
                }
               
            }
        };
        msfGrid.initialize();
        grid = msfGrid.getGrid();
        grid.getView().setAutoFill(lovDef.isAutoFillGrid());

      

//        if (editLovDef!=null  && editLovDef.getFilterFormType()==TableDef.FILTER_FORM_MULTIPLE && msfGrid.isLive()) {//
//            LayoutContainer formPanel = editLovDef.getFilterForm(2);
//            formPanel.addListener(TableDef.clickSearchButton, new Listener<ComponentEvent>() {
//                //@Override
//                public void handleEvent(ComponentEvent be) {
//                	msfGrid.readData();
//                }
//            });
//            LayoutContainer container = new LayoutContainer();
//            BorderLayout borderLayout = new BorderLayout();
//            container.setLayout(borderLayout);
//            BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, editLovDef.getHeightSearchForm()+20);  
//            container.add(formPanel, northData);
//            BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);  
//            container.add(grid, centerData);
//            add(container);
//            //} else {
//        } else { //if (editLovDef!=null && editLovDef.getFilterFormType()==TableDef.FILTER_FORM_SINGLE) { 
        	
        //Show search field
        ToolBar bar = new ToolBar();  
       
       // TextField field = msfGrid.getFieldFilter();
//        if (field != null) { 
//        	 bar.add(new LabelToolItem(MSFMainApp.MSFCONSTANTS.Filtro()));  
//             bar.add(field);
//             setTopComponent(bar); 
//        }
//            add(grid);
//        }  
	    	
 	      if (frmSearchLayer != null) { 
	   	  //  bar.add(new LabelToolItem(MSFMainApp.MSFCONSTANTS.Filtro()));  
	       // bar.add(frmSearchLayer);
	        setTopComponent(frmSearchLayer);  
 	      } else  {
	    	  TextField field = msfGrid.getFieldFilter();
	          if (field != null) { 
	        	 bar.add(new LabelToolItem(MSFMainApp.MSFCONSTANTS.Filtro()));  
	             bar.add(field);
	             setTopComponent(bar); 
	          }   
 	      }
        
        add(grid);

        toolBar = new ToolBar();  

        LiveToolItem item = new LiveToolItem();  
        item.bindGrid(grid);  

        toolBar.add(item);  

        toolBar.add(new FillToolItem());  

        
        //New button is added only if corresponding TableDef for new record has been defined
        if ( editLovDef!=null ) {
            btNew = new Button(MSFMainApp.MSFCONSTANTS.BtNuovo(), buttonListener);
            btNew.setIcon(MSFMainApp.ICONS.add());
            toolBar.add(btNew);
        }
        
        
        if (showBtnBar) {
            btOk = new Button(MSFMainApp.MSFCONSTANTS.BtConferma(), buttonListener);
            btOk.setIcon(MSFMainApp.ICONS.confirm());
            toolBar.add(btOk);
    
            btCancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), buttonListener);
            btCancel.setIcon(MSFMainApp.ICONS.cancel());
            toolBar.add(btCancel);
        } 
        
        setBottomComponent(toolBar);  
            
    }

    /**
     * This method displays or not the button to create a new object shows in LOV
     * 
     * @param show true or false to show or hide the new object button 
     */
    public void showButtonNew(boolean show) {
        if ( editLovDef!=null ) {
            if (show) {
                btNew.show();
            } else {
                btNew.hide();
            }
        }
    }
  //멀티선택 처리를 위해 추가 
    public void showBtnBar(boolean showBtnBar) {
       this.showBtnBar = showBtnBar;
       
       if (!showBtnBar) { 
           
           toolBar = (ToolBar)getBottomComponent();
           toolBar.remove(btOk);
           toolBar.remove(btCancel); 
           
       }
    }

    public void setLovDef(LovDef lovDef) {
        this.lovDef = lovDef;
    }

    public LovDef getLovDef() {
        return lovDef;
    }

    public LayoutContainer getSearchForm() {
        return frmSearchLayer;
    }
 
    public void setSearchForm(LayoutContainer frmSearchLayer) {
        this.frmSearchLayer = frmSearchLayer;
    }
    
    public FormPanel getInitialForm() {
        return initialForm;
    }

    
    public void setInitialForm(FormPanel initialForm) {
        this.initialForm = initialForm;
    }
    
    public void readData(){
        msfGrid.readData();
    }

    public void setFieldCaller(MSFLovField fieldCaller) {
        this.fieldCaller = fieldCaller;
    }

    public MSFLovField getFieldCaller() {
          return fieldCaller;
    }
}
