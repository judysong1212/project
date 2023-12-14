/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This DTO holds useful data regarding a column that is usually managed by a BaseModel.
 *
 */
public class ColumnAttribute implements IsSerializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String selectName;
    private int type;
    private String formula;
    private int valueIdx;
    private boolean skipJoin;
    private boolean fakeAttribute;
    private boolean visibleInExport;
    private String label;

    public ColumnAttribute() {
        this(null, -1, null);
    }

    public ColumnAttribute(String name, int type) {
        this(name, null, type);
    }

    public ColumnAttribute(String name, String selectName, int type) {
        this.name = name;
        this.selectName = selectName;
        this.type = type;
    }

    public ColumnAttribute(String name, int type, String formula) {
//        this.name = name;
//        this.type = type;
//        this.formula = formula;
        this(name, type, formula, false);
    }

    public ColumnAttribute(String name, int type, String formula, boolean skipJoin) {
//        this.name = name;
//        this.type = type;
//        this.formula = formula;
//        this.skipJoin = skipJoin;
        this(name, type, formula, skipJoin, false);
    }

    public ColumnAttribute(String name, int type, String formula, boolean skipJoin, boolean fakeAttribute) {
//        this.name          = name;
//        this.type          = type;
//        this.formula       = formula;
//        this.skipJoin      = skipJoin;
//        this.setFakeAttribute(fakeAttribute);
        this(name, type, formula, skipJoin, fakeAttribute, true);
    }
    
    public ColumnAttribute(String name, int type, String formula, boolean skipJoin, boolean fakeAttribute, boolean visibleInExport) {
//        this.name          = name;
//        this.type          = type;
//        this.formula       = formula;
//        this.skipJoin      = skipJoin;
//        this.setFakeAttribute(fakeAttribute);
//        this.label         = label;
        this(name, type, formula, skipJoin, fakeAttribute, visibleInExport, null);
    }

    public ColumnAttribute(String name, int type, String formula, boolean skipJoin, boolean fakeAttribute, boolean visibleInExport, String label) {
        this.name            = name;
        this.type            = type;
        this.formula         = formula;
        this.skipJoin        = skipJoin;
        this.fakeAttribute   = fakeAttribute;
        this.visibleInExport = visibleInExport;
        this.label           = label;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSelectName() {
        return selectName;
    }
    public void setSelectName(String selectName) {
        this.selectName = selectName;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getFormula() {
        return formula;
    }
    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getValueIdx() {
        return valueIdx;
    }
    public void setValueIdx(int valueIdx) {
        this.valueIdx = valueIdx;
    }

    public boolean isSkipJoin() {
        return skipJoin;
    }
    public void setSkipJoin(boolean skipJoin) {
        this.skipJoin = skipJoin;
    }

    public void setFakeAttribute(boolean fakeAttribute) {
        this.fakeAttribute = fakeAttribute;
    }
    public boolean isFakeAttribute() {
        return fakeAttribute;
    }

    public boolean isVisibleInExport() {
        return visibleInExport;
    }
    public void setVisibleInExport(boolean visibleInExport) {
        this.visibleInExport = visibleInExport;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

}
