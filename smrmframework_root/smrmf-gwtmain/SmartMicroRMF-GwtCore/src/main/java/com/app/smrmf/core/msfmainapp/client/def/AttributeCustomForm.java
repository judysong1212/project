/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.extjs.gxt.ui.client.data.BaseModel;

public class AttributeCustomForm extends BaseModel{

    /**
     * <code>AttributeCustomForm</code> is a model to define the attributes to create a custom form. 
     * @param column It's the number of the position on the row
     * @param row 
     * @param rowSpan It's the same of the html table 
     * @param width It's the width of the field, default is 0 (= default width form)
     * @param labelWidth It's the width of the field's label, default is 0 (= default width label form)
     */
    public AttributeCustomForm(int column, int row, int rowSpan, int width, int labelWidth) {
        set("column", column);
        set("row", row);
        set("rowSpan", rowSpan);
        set("width", width);
        set("labelWidth", labelWidth);
    }

    public AttributeCustomForm(int column, int row) {
        this(column, row, 1, 0, 0);
    }

    public AttributeCustomForm(int column, int row, int width) {
        this(column, row, 1, width, 0);
    }

    public AttributeCustomForm(int column, int row, int width, int labelWidth) {
        this(column, row, 1, width, labelWidth);
    }

    public int getColumn(){
        return Integer.parseInt(get("column").toString());
    }

    public void setColumn(int column){
        set("column", column);
    }

    public int getRow(){
        return Integer.parseInt(get("row").toString());
    }

    public int getColSpan(){
        return Integer.parseInt(get("colSpan").toString());
    }

    public int getRowSpan(){
        return Integer.parseInt(get("rowSpan").toString());
    }

    public int getWidth(){
        return Integer.parseInt(get("width").toString());
    }

    public int getLabelWidth(){
        return Integer.parseInt(get("labelWidth").toString());
    }

}
