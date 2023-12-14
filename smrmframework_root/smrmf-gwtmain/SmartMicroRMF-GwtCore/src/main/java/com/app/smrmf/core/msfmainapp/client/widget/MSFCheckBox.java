/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.widget.form.CheckBox;


public class MSFCheckBox extends CheckBox {

    protected ColumnDef columnDef;

    public MSFCheckBox() {
        super();
    }

    @Override
    protected void onClick(ComponentEvent ce) {
        Boolean oldValue = this.value;
        super.onClick(ce);
        fireChangeEvent(oldValue, !oldValue);
    }

    public ColumnDef getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

}
