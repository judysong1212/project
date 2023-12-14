/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.widget.ButtonGrid;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class MSFPanelCustomForm extends ContentPanel{
    private MSFCustomForm customForm;
    private Button searchButton;
   // private Button formSchButton;
    private Button saveButton;
    private Button cancel;
    private ToolBar topToolBar;
    private ToolBar bottomToolbar;
    private Lov lov;
    private LovLiveGeneric lovWindow;

    public MSFPanelCustomForm(TableDef tableDef, int width){
        this(tableDef, width, 100);
    }

    public MSFPanelCustomForm(TableDef tableDef, int width, int labelWidth){
        this(tableDef, width, labelWidth, false);
    }

    public MSFPanelCustomForm(TableDef tableDef, int width, int labelWidth, boolean showLabelBorders){
        this(tableDef, width, labelWidth, showLabelBorders, true);
    }

    public MSFPanelCustomForm(TableDef tableDef,  int width, int labelWidth, boolean showLabelBorders, boolean alignRightFields){
        super();
        setBodyBorder(true);
        setBorders(false);
        setHeadingText(tableDef.getTitle());  //setHeading(tableDef.getTitle());  
        setWidth(width);
        setLayout(new FitLayout());  

        customForm = new MSFCustomForm(tableDef, width, labelWidth, false, showLabelBorders, alignRightFields);
        customForm.setFrame(false);
        customForm.setBodyBorder(false);
        customForm.setBorders(false);
        customForm.setHeaderVisible(false);

        add(customForm);

        // TODO ATTENZIONE potrebbe essere anche in insert
        if (!tableDef.isReadOnly()) {
            ToolBar bottomToolbar = getBottomToolbar();
            bottomToolbar.add(new FillToolItem());
            customForm.setActionDatabase(ActionDatabase.UPDATE);
            saveButton = new ButtonGrid(ActionDatabase.UPDATE, myButtonListener);
            saveButton.setText(MSFMainApp.MSFCONSTANTS.BtSave());
            bottomToolbar.add(saveButton);
            bottomToolbar.add(new SeparatorToolItem());
            cancel = new Button(MSFMainApp.MSFCONSTANTS.BtDelete(), myButtonListener);
            cancel.setIcon(MSFMainApp.ICONS.cancel());
            bottomToolbar.add(cancel);
            setBottomComponent(bottomToolbar);
        }
    }

    private SelectionListener<ButtonEvent> myButtonListener = new SelectionListener<ButtonEvent>() {
        public void componentSelected(ButtonEvent ce) {
            if (ce.getButton() instanceof ButtonGrid) {
                if (customForm.isDirty()) {
                    customForm.mask(MSFMainApp.MSFMESSAGES.SavingData());
                    customForm.save();
                } else {
                    MessageBox.info(MSFMainApp.MSFCONSTANTS.Alert(), MSFMainApp.MSFMESSAGES.NothingToSave(), null);
                }
            } else if (ce.getButton() == cancel) {
                MessageBox.confirm(MSFMainApp.MSFCONSTANTS.Alert(), MSFMainApp.MSFMESSAGES.CancelChanges(), new Listener<MessageBoxEvent>() {
                    //@Override
                    public void handleEvent(MessageBoxEvent be) {
                        if ("yes".equals(be.getButtonClicked().getItemId())){
                            customForm.cancelChangeFields();
                        }
                    }
                });
            }
        }
    };

    public void showSearchButton(boolean b){
        if (b) {
            if (topToolBar == null) {
                topToolBar = new ToolBar();
            }
            topToolBar.add(getSearchButton());
            setTopComponent(topToolBar);
        } else {
            if (topToolBar != null && searchButton != null) {
                topToolBar.remove(searchButton);
                if (topToolBar.getItemCount() == 0) {
                    remove(topToolBar);
                }
            }
        }
    }

    public Button getSearchButton(){
        if (searchButton == null) {
        	searchButton = new Button(MSFMainApp.MSFCONSTANTS.BtnSearch());
        	searchButton.setIcon(MSFMainApp.ICONS.search());
        	searchButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent ce) {
                    if (lovWindow != null) {
                        lovWindow.show();
                    } else {
                        if (lov != null) {
                            lovWindow = new LovLiveGeneric(lov.getLovDef());
                            lovWindow.setInitialForm(customForm);
                            lovWindow.showButtonNew(lov.showButtonNew);
                            lovWindow.setSize(lov.width, lov.height);
                            lovWindow.show();
                            lov.fixAttributeFormNames();
                        }
                    }
                }
            });
        }
        return searchButton;
    }
    
    
//    public Button getFormButton(){
//        if (searchButton == null) {
//            searchButton = new Button(MSFMainApp.MSFCONSTANTS.BtnSearch());
//            searchButton.setIcon(MSFMainApp.ICONS.search());
//            searchButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
//                public void componentSelected(ButtonEvent ce) {
//                    if (lovWindow != null) {
//                        lovWindow.show();
//                    } else {
//                        if (lov != null) {
//                            lovWindow = new LovLiveGeneric(lov.getLovDef());
//                            lovWindow.setInitialForm(customForm);
//                            lovWindow.showButtonNew(lov.showButtonNew);
//                            lovWindow.setSize(lov.width, lov.height);
//                            lovWindow.show();
//                            lov.fixAttributeFormNames();
//                        }
//                    }
//                }
//            });
//        }
//        return searchButton;
//    }

    protected void returnValueFromLov(BaseModel item) {
        FormBinding binding = customForm.getFormBinding();
        lov.getLovDef().updateBaseModelForm(item, binding);
    }

    public MSFCustomForm getCustomForm() {
        return customForm;
    }

    public void setLov(Lov lov){
        this.lov = lov;
    }

    public Lov getLov(){
        return lov;
    }
    
    public void setMargin(int top, int bottom, int left, int right){
        if (top    != 0) setStyleAttribute("paddingTop"   , top+"px");
        if (bottom != 0) setStyleAttribute("paddingBottom", bottom+"px");
        if (left   != 0) setStyleAttribute("paddingLeft"  , left+"px");
        if (right  != 0) setStyleAttribute("paddingRight" , right+"px");
    }
    
    public ToolBar getBottomToolbar(){
        if (this.bottomToolbar == null) {
            this.bottomToolbar = new ToolBar();
        }
        return this.bottomToolbar;
    }
}
