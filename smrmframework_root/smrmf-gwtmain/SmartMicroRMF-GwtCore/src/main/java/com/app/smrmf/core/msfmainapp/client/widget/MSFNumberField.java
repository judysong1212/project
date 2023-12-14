/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.widget.form.NumberField;


public class MSFNumberField extends NumberField {

    protected ColumnDef columnDef;
    protected int maxDecimals = 10;

    public MSFNumberField() {
        super();
    }

    @Override
    protected void onRender(com.google.gwt.user.client.Element target, int index) {
        super.onRender(target, index);
        GWTUtils.setCustomStyles(this);
    }

    public ColumnDef getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

    public int getMaxDecimals() {
        return maxDecimals;
    }
    public void setMaxDecimals(int maxDecimals) {
        this.maxDecimals = maxDecimals;
    }

}
