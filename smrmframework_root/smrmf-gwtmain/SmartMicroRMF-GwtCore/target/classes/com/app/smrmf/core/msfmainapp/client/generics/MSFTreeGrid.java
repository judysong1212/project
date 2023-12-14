/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.model.model.Folder;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.widget.IconButtonGrid;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTreeGridBase;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridSelectionModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @author Carlo
 *
 */
public class MSFTreeGrid extends MSFGrid {

    private MSFTreeGridBase<ModelData> treeGrid;
    private TreeStore<ModelData>       treeStore;
    private String                     attributeTreeGridCellRenderer;
    private String                     attributeSorter;

    public MSFTreeGrid(TableDef tableDef, String attributeTreeGridCellRenderer) {
        super(tableDef, false);
        this.attributeTreeGridCellRenderer = attributeTreeGridCellRenderer;
    }

    public void initialize(){
        treeStore = new TreeStore<ModelData>();
        List<ColumnConfig> columns = columnModel.getColumns();
        for (ColumnConfig columnConfig : columns) {
            if (columnConfig.getId().equals(this.attributeTreeGridCellRenderer)) {
                columnConfig.setRenderer(new TreeGridCellRenderer<ModelData>());
                break;
            }
        }

        treeGrid = new MSFTreeGridBase<ModelData>(treeStore, columnModel);
        treeGrid.setStripeRows(true);
        treeGrid.setBorders(false);
        treeGrid.setAutoExpandColumn(this.attributeTreeGridCellRenderer);  
        if (autoLoadData) {
            readData();
        }

        final TreeGridSelectionModel<ModelData> sm = new TreeGridSelectionModel<ModelData>();
        treeGrid.setSelectionModel(sm);
        treeGrid.getSelectionModel().addListener(Events.SelectionChange, 
                new Listener<SelectionChangedEvent<BaseModel>>() {  
            public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                // TODO Auto-generated method stub
                currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                GWT.log("msfGrid.SelectionChange.handleEvent("+be+"), currentlySelectedItem=" + 
                        (currentlySelectedItem!=null ? currentlySelectedItem.get("description") : ""));
            }
        });
        treeGrid.addListener(Events.OnDoubleClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                listener.onDoubleClickOnRecord(currentlySelectedItem);
            }
        });
        treeGrid.addListener(Events.OnKeyPress,  new Listener<ComponentEvent>() {
            @SuppressWarnings("unchecked")
            public void handleEvent(ComponentEvent be) {
                if (be.getKeyCode() == 13) {
                    currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                    listener.onDoubleClickOnRecord(currentlySelectedItem);
                }
            }
        });
        StoreFilterField<ModelData> field = new StoreFilterField<ModelData>() {
            protected boolean doSelect(Store<ModelData> store, ModelData parent, ModelData record, String property, String filter) {
                Iterator<ColumnConfig> list = getTableDef().getColumnModel().getColumns().iterator();
                while (list.hasNext()) {
                    ColumnConfig columnConfig = (ColumnConfig) list.next();
                    if (MSFSharedUtils.allowNulls(record.get(columnConfig.getId())).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                        return true;  
                    }
                }
                return false;
            }
        };
        field.bind(treeStore);
        fieldFilter = field;
        if (this.autoLoadData) {
            readData();
        }
        if (fieldFilter != null) {
            fieldFilter.setWidth(150);  
        }
    }
//TODO 살리기 
//    public Grid getGrid() {
//        return treeGrid;
//    }

    public void refreshStore(Folder obj) {
        if (treeStore != null) {  
            treeStore.removeAll();  
            treeStore.add(obj, true);
            treeStore.commitChanges();
        }
    }

    /**
     * This method reads data from database and puts these into store then the grid is simple 
     * or uses a loader when the grid is live.
     */
    public void readData(){
        //Check if call must be skipped
        if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(tableDef.getCustomListMethod()) ) {
            return;
        }
        this.autoLoadData = true;
        GWTUtils.maskComponent(treeGrid);
        IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
        ServiceParameters params = ServiceParameters.getListParameters(
                tableDef.getTable(),
                ActionDatabase.LIST,
                tableDef.getTableAttributes(),
                filters,
                tableDef.getColumnOrders(),
                null,
                tableDef.getCustomListMethod());
        appService.getListGenericObjects(
                params,
                new AsyncCallback<PagingLoadResult<BaseModel>>(){
                    public void onFailure(Throwable caught) {
                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListGenericObjects(): "+caught),null);
                    }
                    public void onSuccess(PagingLoadResult<BaseModel> result) {
                        GWTUtils.unmaskComponent(treeGrid);
                        List<BaseModel> list = result.getData();
                        treeStore.removeAll();
                        if (list.size() >= 0) {
                            BaseModel bm = list.get(0);
                            if (bm instanceof Folder) {
                                Folder root = (Folder)bm;
                                treeStore.add(root, true);
                                treeGrid.setExpanded(root, true, true);
                            }
                        }
                    }
                });
        if ( this.currentlySelectedItem != null ) {
            this.currentlySelectedItemId = this.currentlySelectedItem.get(TableDef.ID_PROPERTY_NAME);
            this.currentlySelectedItem = null;
        }
    }

    /**
     * This is a override of a method of the selection listner. This is required because
     * when you click over buttons update/delete on the single rows, the focus or 
     * current selection item dosen't fired, and the attribute currentlySelectedItem isn't
     * set. Thus when the column buttons is rendered, every buttons has for attribute the relative 
     * basemodel, and when you click on buttons, the basemodel becomes the currentlySelectedItem.
     */
//    @Override
//    public void componentSelected(ButtonEvent ce) {
//        currentlySelectedItem = ((ButtonGrid)ce.getButton()).getRecord();
//        treeGrid.getSelectionModel().select(currentlySelectedItem, false);
//    }
    public void onClick(ClickEvent arg0) {
        final IconButtonGrid source = (IconButtonGrid) arg0.getSource();
        currentlySelectedItem = source.getRecord();
        treeGrid.getSelectionModel().select(currentlySelectedItem, false);
    }

    public void clearData(){
        treeStore.removeAll();
        treeStore.commitChanges();
        currentlySelectedItem = null;
    }

    public TreeStore<ModelData> getTreeStore() {
        return treeStore;
    }

    public void manualActionOnStore(BaseTreeModel record, ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT:
            putRecordIntoTree(record);
            break;
        case DELETE: 
            treeStore.remove(currentlySelectedItem);
            break;
        case UPDATE:
            {
                BaseTreeModel node = (BaseTreeModel) treeStore.findModel(currentlySelectedItem);
                node.setProperties(record.getProperties());
                treeStore.update(node);
//                treeGrid.refresh(node);
            }    
            break;
        }
    }
    
    public boolean putRecordIntoTree(BaseTreeModel record) {
        ModelData parent = currentlySelectedItem;
        if (parent == null) {
            parent = treeStore.findModel("root");
        }
        List<ModelData> children = treeStore.getChildren(parent);
        int index = getIndexBySort(record, children);
        treeStore.insert(parent, record, index, true);
        treeGrid.setExpanded(parent, true);
        return true;
    }
    
    private int getIndexBySort(BaseTreeModel record, List<ModelData> broders) {
        int i = 0;
        int sortRecord = ((Long)record.get(attributeSorter))==null?0:((Long)record.get(attributeSorter)).intValue();
        for (ModelData r : broders) {
            if (sortRecord < (((Long)r.get(attributeSorter))==null?0:((Long)r.get(attributeSorter)).intValue())) {
                return i;
            }
            i++;
        }
        return i;
    }

    public String getAttributeSorter() {
        return attributeSorter;
    }

    public void setAttributeSorter(String attributeSorter) {
        this.attributeSorter = attributeSorter;
    }
    
    
}
