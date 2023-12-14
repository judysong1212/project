/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.Date;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.DateField;


public class MSFDateField extends DateField {

    protected ColumnDef columnDef;

    public MSFDateField() {
        super();
        addListener(Events.DoubleClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                if (isRendered()) {
                    setValue(new Date());
                }
            }
        });
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

}
