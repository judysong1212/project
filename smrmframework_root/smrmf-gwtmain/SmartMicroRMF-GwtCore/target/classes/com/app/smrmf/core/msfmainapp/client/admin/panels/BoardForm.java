/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.panels;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.DatabaseObject;
import com.app.smrmf.core.msfmainapp.client.service.system.AdminService;
import com.app.smrmf.core.msfmainapp.client.service.system.AdminServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DualListField;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class BoardForm extends MSFPanel {
    private AdminServiceAsync adminService = AdminService.Util.getInstance();
    private Button saveButton;
    private Button cancelButton;
    private ListStore<DatabaseObject> fromStoreTables;
    private ListStore<DatabaseObject> toStoreTables;
    private ListStore<DatabaseObject> fromStoreViews;
    private ListStore<DatabaseObject> toStoreViews;
    private             StoreListener<DatabaseObject> listener = new StoreListener<DatabaseObject>(){
        public void storeAdd(StoreEvent<DatabaseObject> se) {
            DatabaseObject d = se.getModels().get(0);
            if (d != null) {
                super.storeAdd(se);
                saveData(d, ActionDatabase.INSERT);
            }
        }  
        public void storeRemove(StoreEvent<DatabaseObject> se) {
            DatabaseObject d = se.getModel();
            if (d != null) {
                super.storeRemove(se);
                saveData(d, ActionDatabase.DELETE);
            }
        }
    };


    public ContentPanel getViewPanel() {
        if (panel == null) {
            panel = new ContentPanel();
            panel.setLayout(new FitLayout());
            panel.setBodyBorder(false);
            panel.setBorders(false);
            panel.setHeaderVisible(false);
            //            panel.setHeading("Oggetti database");

            VerticalPanel verticalPanel = new VerticalPanel();
            verticalPanel.setLayout(new FitLayout());

            ContentPanel tablesPanel = new ContentPanel();
            tablesPanel.setStyleAttribute("paddingBottom", "10px");
            tablesPanel.setHeadingText("Tabelle");//.setHeading("Tabelle");
            tablesPanel.setLayout(new FitLayout());
            tablesPanel.setSize(600,300);
            final DualListField<DatabaseObject> listTables = new DualListField<DatabaseObject>();  
            listTables.setStyleAttribute("margin", "10px");
            ListField<DatabaseObject> fromTables = listTables.getFromList();  
            fromTables.setDisplayField("name");
            fromStoreTables = new ListStore<DatabaseObject>();  
            fromStoreTables.setStoreSorter(new StoreSorter<DatabaseObject>());  
            fromTables.setStore(fromStoreTables);  

            ListField<DatabaseObject> toTables = listTables.getToList();  
            toTables.setDisplayField("name");  
            toStoreTables = new ListStore<DatabaseObject>();  
            toStoreTables.setStoreSorter(new StoreSorter<DatabaseObject>());  
            toTables.setStore(toStoreTables);  
            tablesPanel.add(listTables);
            verticalPanel.add(tablesPanel);

            ContentPanel viewsPanel = new ContentPanel();
            viewsPanel.setHeadingText("Viste");  //.setHeading("Viste");
            viewsPanel.setLayout(new FitLayout());
            viewsPanel.setSize(600,300);
            final DualListField<DatabaseObject> listViews = new DualListField<DatabaseObject>();  
            listViews.setStyleAttribute("margin", "10px");
            ListField<DatabaseObject> fromViews = listViews.getFromList();  
            fromViews.setDisplayField("name");
            fromStoreViews = new ListStore<DatabaseObject>();  
            fromStoreViews.setStoreSorter(new StoreSorter<DatabaseObject>());  
            fromViews.setStore(fromStoreViews);  

            ListField<DatabaseObject> toViews = listViews.getToList();  
            toViews.setDisplayField("name");  
            toStoreViews = new ListStore<DatabaseObject>();  
            toStoreViews.setStoreSorter(new StoreSorter<DatabaseObject>());  
            toViews.setStore(toStoreViews);  
            viewsPanel.add(listViews);
            verticalPanel.add(viewsPanel);

            //            ToolBar bottomToolbar = new ToolBar();  
            //            bottomToolbar.add(new FillToolItem());
            //            saveButton = new Button(MSFMainApp.MSFCONSTANTS.BtSave());
            //            saveButton.setIcon(MSFMainApp.ICONS.save());
            //            saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            //                public void componentSelected(ButtonEvent ce) {  
            //                }  
            //            });
            //
            //            bottomToolbar.add(saveButton);
            //            bottomToolbar.add(new SeparatorMenuItem());
            //
            //            cancelButton = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
            //            cancelButton.setIcon(MSFMainApp.ICONS.cancel());
            //            cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
            //                public void componentSelected(ButtonEvent ce) {  
            //                }  
            //            });
            //
            //            bottomToolbar.add(cancelButton);
            //            panel.setBottomComponent(bottomToolbar);

            readData();
            panel.add(verticalPanel);

        }
        return panel;
    }

    private void saveData(DatabaseObject d, ActionDatabase actionDatabase) { 
        adminService.activityOnDBObject(d, actionDatabase, new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnDBObject(): "+caught), null);
            }
            public void onSuccess(Long result) {
                if (result.compareTo(new Long(0))==0) {
                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("in activityOnDBObject()"), null);
                }
            }
        });
    }

    private void readData(){
        toStoreTables.removeStoreListener(listener);
        toStoreViews.removeStoreListener(listener);

        panel.mask();
        adminService.getDatabaseObjects(new AsyncCallback<List<DatabaseObject>>(){
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getDatabaseObjects(): "+caught), null);
            }
            public void onSuccess(List<DatabaseObject> result) {
                readDataConsidered();
                populateLists(result);
            }
        });
    }

    private void readDataConsidered(){
        adminService.getDatabaseObjectsConsidered(new AsyncCallback<List<DatabaseObject>>(){
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getDatabaseObjectsConsidered(): "+caught), null);
            }
            public void onSuccess(List<DatabaseObject> result) {
                panel.unmask();
                populateListsConsidered(result);
                toStoreTables.addStoreListener(listener);
                toStoreViews.addStoreListener(listener);
            }
        });
    }

    private void populateLists(List<DatabaseObject> result) {
        fromStoreTables.removeAll();
        fromStoreViews.removeAll();
        for (DatabaseObject d : result) {
            if ("TABLE".equalsIgnoreCase(d.getType())) {
                fromStoreTables.add(d);
            } else {
                fromStoreViews.add(d);
            }
        }
    }

    private void populateListsConsidered(List<DatabaseObject> result) {
        toStoreTables.removeAll();
        toStoreViews.removeAll();
        for (DatabaseObject d : result) {
            if ("TABLE".equalsIgnoreCase(d.getType())) {
                toStoreTables.add(d);
            } else {
                toStoreViews.add(d);
            }
        }
    }

    public String getIntro() {
        return null;
    }

    @Override
    public void reload() {

    }

    private BoardForm getThis(){
        return this;
    }


}