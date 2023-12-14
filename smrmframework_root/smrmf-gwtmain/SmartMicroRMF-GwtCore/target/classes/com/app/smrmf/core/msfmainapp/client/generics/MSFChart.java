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
import com.app.smrmf.core.msfmainapp.client.def.ChartDef;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.event.ChartEvent;
import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.grid.CellSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MSFChart extends ContentPanel{
    private GenericServiceAsync appService = GenericService.Util.getInstance();
    private ChartDef chartDef;
    private ListStore<BaseModel> store;
    private Chart chart;
    private Grid<BaseModel> linkedGrid;
    private ChartListener listener = null;

    public MSFChart(ChartDef chartDef, Grid<BaseModel> linkedGrid) {
        setHeadingText(chartDef.getTitle());//setHeading();
        setLayout(new FitLayout());
        
        this.chartDef   = chartDef;
        this.linkedGrid = linkedGrid;
        // chart
        String url = !GXT.isIE ? "../../" : "";    
        url += "resources/chart/open-flash-chart.swf";  
        chart = new Chart(url);  
        chart.setHeight(250);
        if (linkedGrid != null) {
            listener = new ChartListener() {  
                public void chartClick(ChartEvent ce) {  
                    int row = ce.getChartConfig().getValues().indexOf(ce.getDataType());  
                    int col = ce.getChartModel().getChartConfigs().indexOf(ce.getChartConfig()) + 1;  
//                    if (getLinkedGrid().getSelectionModel() instanceof CellSelectionModel) {
                        CellSelectionModel<BaseModel> csm = (CellSelectionModel<BaseModel>) getLinkedGrid().getSelectionModel();  
                        csm.selectCell(row, col);  
  //                  }
    //                    teamSalesGrid.startEditing(row, col);  
                }  
            };
            this.chartDef.setListener(listener);
        }

        if (listener != null) {
            chartDef.setListener(listener);
        }
        
        store = new ListStore<BaseModel>();
        
        populate();

        add(chart);
    }

    public ChartDef getChartDef() {
        return chartDef;
    }

    public ListStore<BaseModel> getStore() {
        return store;
    }

    public void populate() {
        //Check if call must be skipped
        if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(chartDef.getCustomListMethod()) ) {
            return;
        }
        ServiceParameters params = ServiceParameters.getListParameters(
                chartDef.getTable(),
                ActionDatabase.LIST,
                chartDef.getTableAttributes(),
                chartDef.getTableColumnFilters(),
                chartDef.getColumnOrders(),
                null,
                chartDef.getCustomListMethod());
        appService.getListGenericObjects(
                params,
                new AsyncCallback<PagingLoadResult<BaseModel>>(){
                    public void onFailure(Throwable caught) {
                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getListGenericObjects(): "+caught),null);
                    }
                    public void onSuccess(PagingLoadResult<BaseModel> result) {
                        List<BaseModel> list = result.getData();
                        store.removeAll();  
                        store.add(list);
                        store.commitChanges();
                        ChartModel chartModel = chartDef.getChartModel(store); 
                        chart.setChartModel(chartModel);
                        chart.refresh();
                    }
                });
    }
    
    public void setPadding(int top, int bottom, int left, int right){
        if (top    != 0) setStyleAttribute("paddingTop"   , top+"px");
        if (bottom != 0) setStyleAttribute("paddingBottom", bottom+"px");
        if (left   != 0) setStyleAttribute("paddingLeft"  , left+"px");
        if (right  != 0) setStyleAttribute("paddingRight" , right+"px");
    }

    public Grid<BaseModel> getLinkedGrid() {
        return linkedGrid;
    }

}
