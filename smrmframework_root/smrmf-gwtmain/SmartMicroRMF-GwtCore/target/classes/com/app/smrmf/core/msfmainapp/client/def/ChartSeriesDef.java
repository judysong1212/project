/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.charts.client.model.BarDataProvider;
import com.extjs.gxt.charts.client.model.DataProvider;
import com.extjs.gxt.charts.client.model.LineDataProvider;
import com.extjs.gxt.charts.client.model.charts.BarChart;
import com.extjs.gxt.charts.client.model.charts.BarChart.BarStyle;
import com.extjs.gxt.charts.client.model.charts.ChartConfig;
import com.extjs.gxt.charts.client.model.charts.LineChart;

public class ChartSeriesDef extends ColumnDef{
    public static enum TypeSerie {
        BAR, LINE
    }
    
    private ChartConfig  chartConfig;
    private DataProvider dataProvider;

    public ChartSeriesDef(TypeSerie typeSerie, String textProperty, String valueProperty, String color) {
      this(typeSerie, textProperty, valueProperty, color, null);
    }
    
    public ChartSeriesDef(TypeSerie typeSerie, String textProperty, String valueProperty, String color, String attributeFormula) {
        super(
                (textProperty==null?valueProperty:textProperty), 
                valueProperty, 
                ColumnDef.TYPE_STRING, 
                100,
                false, true, false);
        if (MSFSharedUtils.paramNotNull(attributeFormula)) {
            setAttributeFormula(attributeFormula);
        }
        
        switch (typeSerie) {
        case BAR:
            chartConfig = new BarChart(BarStyle.GLASS);
            ((BarChart)chartConfig).setColour(color);  
            dataProvider = new BarDataProvider(valueProperty);
            ((BarChart)chartConfig).setDataProvider((BarDataProvider)dataProvider);
            break;
        case LINE:
            chartConfig = new LineChart();
            ((LineChart)chartConfig).setColour(color);  
            dataProvider = new LineDataProvider(valueProperty);
            ((LineChart)chartConfig).setDataProvider((LineDataProvider)dataProvider);
            break;
        }
        if (MSFSharedUtils.paramNotNull(textProperty)) {
            chartConfig.setText(textProperty);
        }        
    }

    public ChartConfig getChartConfig() {
        return chartConfig;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }

}
