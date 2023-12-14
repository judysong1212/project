/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.List;

public class RelationDef {
    private TableDef            detailTable;
    private boolean             autoQuery;
    private List<ColumnJoinDef> joinColumns; 
    private Object              linkedObject;

    public RelationDef(TableDef detailTable) {
        this(detailTable, true);
    }

    public RelationDef(TableDef detailTable, boolean autoQuery) {
        this.setDetailTable(detailTable);
        this.autoQuery = autoQuery;
        this.joinColumns = new ArrayList<ColumnJoinDef>();
    }

    public void addJoinDef(String attributeMasterTable, String attributeDetailTable) {
        this.joinColumns.add(new ColumnJoinDef(attributeMasterTable, attributeDetailTable));
    }

    public void addJoinDef(ColumnJoinDef columnJoinDef) {
        this.joinColumns.add(columnJoinDef);
    }

    public void setDetailTable(TableDef detailTable) {
        this.detailTable = detailTable;
    }

    public TableDef getDetailTable() {
        return detailTable;
    }

    public List<ColumnJoinDef> getJoinColumns() {
        return joinColumns;
    }

    public void setAutoQuery(boolean autoQuery) {
        this.autoQuery = autoQuery;
    }

    public boolean isAutoQuery() {
        return autoQuery;
    }

    public void setLinkedObject(Object linkedObject) {
        this.linkedObject = linkedObject;
    }

    public Object getLinkedObject() {
        return linkedObject;
    }

}
