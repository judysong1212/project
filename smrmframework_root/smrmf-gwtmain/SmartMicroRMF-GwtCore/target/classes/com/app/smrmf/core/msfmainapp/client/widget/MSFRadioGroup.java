/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;

import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;

public class MSFRadioGroup extends RadioGroup {

    protected ColumnDef columnDef;
    protected Radio lastValue = null;

    public MSFRadioGroup() {
        super();
    }

    public MSFRadioGroup(String name) {
        super(name);
    }

    @Override
    public void setValue(Radio value) {
        Radio oldValue = lastValue;
        if (value != null) {
            lastValue = value;
            super.setValue(value);
        } else {
            if (oldValue != null) {
                oldValue.setValue(false);
            }
        }
        if (this.isFireChangeEventOnSetValue()) {
            fireChangeEvent(oldValue, value);
        }
    }

    @Override
    protected void onRadioSelected(Radio radio) {
        Radio oldValue = lastValue;
        super.onRadioSelected(radio);
        fireChangeEvent(oldValue, radio);
    }

    public ColumnDef getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

}
