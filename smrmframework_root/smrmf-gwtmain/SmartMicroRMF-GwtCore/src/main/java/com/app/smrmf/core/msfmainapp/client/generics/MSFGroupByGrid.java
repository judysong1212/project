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
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.GridSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.GroupSummaryView;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * 
 * @author Carlo
 *
 */
public class MSFGroupByGrid extends MSFGrid {

    private EditorGrid<BaseModel>      grid;
    private GroupingStore<ModelData>   store;
    private String                     attributeGroupByColumn;

    public MSFGroupByGrid(TableDef tableDef, String attributeGroupByColumn) {
        super(tableDef, false);
        this.attributeGroupByColumn = attributeGroupByColumn;
    }

    public void initialize(){

        store = new GroupingStore<ModelData>();
        store.groupBy(GWTUtils.adjustsColumnDefName(attributeGroupByColumn));  

        GroupSummaryView summary = new GroupSummaryView();  
        summary.setForceFit(false);  // 그리드를 무조건 autofill 로할지.  
        summary.setShowGroupedColumn(false);  

        grid = new EditorGrid<BaseModel>(store, tableDef.getSummaryColumnModel());  
        grid.setBorders(false);  
        grid.setView(summary);  
        grid.getView().setShowDirtyCells(false);  

        final GridSelectionModel<BaseModel> sm = new GridSelectionModel<BaseModel>();
        grid.setSelectionModel(sm);
        grid.getSelectionModel().addListener(Events.SelectionChange, 
                new Listener<SelectionChangedEvent<BaseModel>>() {  
            public void handleEvent(SelectionChangedEvent<BaseModel> be) {
                // TODO Auto-generated method stub
                currentlySelectedItem = (BaseModel) sm.getSelectedItem();
            }
        });
        grid.addListener(Events.OnDoubleClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                currentlySelectedItem = (BaseModel) sm.getSelectedItem();
                listener.onDoubleClickOnRecord(currentlySelectedItem);
            }
        });
        grid.addListener(Events.OnKeyPress,  new Listener<ComponentEvent>() {
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
        field.bind(store);
        fieldFilter = field;
        if (this.autoLoadData) {
            readData();
        }
        if (fieldFilter != null) {
            fieldFilter.setWidth(150);  
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
        GWTUtils.maskComponent(grid);
        IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
        ServiceParameters params = ServiceParameters.getListParameters(
                getTableDef().getTable(),
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
                        GWTUtils.unmaskGrid(grid);
                        List<BaseModel> list = result.getData();
                        refreshStore(list);
                    }
                });
        if ( this.currentlySelectedItem != null ) {
            this.currentlySelectedItemId = this.currentlySelectedItem.get(TableDef.ID_PROPERTY_NAME);
            this.currentlySelectedItem = null;
        }
    }


    public EditorGrid getGrid() {
        return grid;
    }

    public void clearData(){
        store.removeAll();
        store.commitChanges();
        currentlySelectedItem = null;
    }

    public void refreshStore(List<BaseModel> obj) {
        if (store != null) {  
            store.removeAll();  
            store.add(obj);
            store.commitChanges();
        }
    }
}
