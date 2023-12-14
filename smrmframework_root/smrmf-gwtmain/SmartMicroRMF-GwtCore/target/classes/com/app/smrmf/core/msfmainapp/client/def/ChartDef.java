/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.charts.client.event.ChartListener;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.DataProvider;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.ScaleProvider;
import com.extjs.gxt.charts.client.model.axis.Label;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;

public class ChartDef extends TableDef{
    private HashMap<ChartConfig, DataProvider> chartConfigs;
    private String style;
    private String labelProperty;
    private String textLabelProperty;
    
    public ChartDef() {
        chartConfigs = new HashMap<ChartConfig, DataProvider>();
    }

    public void addSeries(List<ChartSeriesDef> chartSeriesDefs){
        List<ColumnDef> columnDefs = new ArrayList<ColumnDef>();
        if (MSFSharedUtils.paramNotNull(labelProperty)) {
            columnDefs.add(
                    new ColumnDef(
                            (textLabelProperty==null?labelProperty:textLabelProperty), 
                            labelProperty, 
                            ColumnDef.TYPE_STRING, 
                            100,
                            false, true, false));
        }    
        for (ChartSeriesDef chartSeriesDef : chartSeriesDefs) {
            chartConfigs.put(
                    chartSeriesDef.getChartConfig(), 
                    chartSeriesDef.getDataProvider());
            //columnDefs.add(chartSeriesDef.getColumnDef());
            columnDefs.add(chartSeriesDef);
        }
        super.setColumnsDefinition(columnDefs);
    }
    
    public void setListener(ChartListener listener) {
        if (listener != null) {
            for (ChartConfig chartConfig : chartConfigs.keySet()) {
                chartConfig.addChartListener(listener);
            }
        }
    }
    
    public ChartModel getChartModel(ListStore<BaseModel> store){
        ChartModel model = new ChartModel(title, style);
        model.setBackgroundColour("#fefefe");  
        model.setLegend(new Legend(Position.TOP, true));
        model.setScaleProvider(ScaleProvider.ROUNDED_NEAREST_SCALE_PROVIDER);

        for (ChartConfig chartConfig : chartConfigs.keySet()) {
            DataProvider dataProvider = chartConfigs.get(chartConfig);
            dataProvider.bind(store);
            model.addChartConfig(chartConfig);
        }
        
        XAxis xAxis = null;
        if (labelProperty != null) {
          xAxis = model.getXAxis();
          if (xAxis == null) {
            xAxis = new XAxis();
            model.setXAxis(xAxis);
          }
          xAxis.getLabels().getLabels().clear();
        }
        for (ModelData m : store.getModels()) {
             xAxis.addLabels(new Label((String) m.get(labelProperty), 45));
        }
        
        return model;
    }

    public void setLabelProperty(String textLabelProperty, String labelProperty) {
        this.labelProperty = labelProperty;
        this.textLabelProperty = textLabelProperty;
    }

    public String getLabelProperty() {
        return labelProperty;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    
    
}
