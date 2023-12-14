/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

public class ColumnLovDef extends ColumnDef{
    private String attributeQuery;
    private String attributeForm;
    private int width;

    public ColumnLovDef(
            String title, 
            String attributeQuery, 
            String attributeForm,
            int type,
            int width) {
        super(
                title, 
                attributeQuery, 
                type, 
                width, 
                false, 
                width>0?true:false, 
                false);
        this.attributeForm  = GWTUtils.adjustsColumnDefName(attributeForm);
        this.attributeQuery = GWTUtils.adjustsColumnDefName(attributeQuery);
    }

    public void setAttributeQuery(String attributeQuery) {
        this.attributeQuery = attributeQuery;
    }

    public String getAttributeQuery() {
        return attributeQuery;
    }

    public void setAttributeForm(String attributeForm) {
        this.attributeForm = attributeForm;
    }

    public String getAttributeForm() {
        return attributeForm;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

}
