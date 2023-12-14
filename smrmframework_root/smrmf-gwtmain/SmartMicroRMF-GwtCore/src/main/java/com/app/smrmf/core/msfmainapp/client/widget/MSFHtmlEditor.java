/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;

import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.google.gwt.event.dom.client.BlurEvent;


public class MSFHtmlEditor   extends HtmlEditor{

    protected ColumnDef columnDef;

    public MSFHtmlEditor() {
        super();
        handler = new EventHandler(){
            public void onBlur(BlurEvent envet) {
                String oldValue = (String)getOriginalValue();
                String curValue = (String)getValue();
                fireChangeEvent(oldValue, curValue);
            };  
        };
   }

    public ColumnDef getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

}
