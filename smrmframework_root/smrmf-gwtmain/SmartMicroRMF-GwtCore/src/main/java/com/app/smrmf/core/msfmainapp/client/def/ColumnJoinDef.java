/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

public class ColumnJoinDef {
    private String attributeMasterTable;
    private String attributeDetailTable;

    public ColumnJoinDef(
            String attributeMasterTable, 
            String attributeDetailTable) {
        this.setAttributeMasterTable(GWTUtils.adjustsColumnDefName(attributeMasterTable)); 
        this.setAttributeDetailTable(GWTUtils.adjustsColumnDefName(attributeDetailTable));
    }

    public void setAttributeMasterTable(String attributeMasterTable) {
        this.attributeMasterTable = attributeMasterTable;
    }

    public String getAttributeMasterTable() {
        return attributeMasterTable;
    }

    public void setAttributeDetailTable(String attributeDetailTable) {
        this.attributeDetailTable = attributeDetailTable;
    }

    public String getAttributeDetailTable() {
        return attributeDetailTable;
    }

}
