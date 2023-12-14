/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.io.Serializable;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.DynamicFilterValue;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FormPanel;

public class Lov {

    protected int width  = 500;
    protected int height = 500;
    protected boolean showButtonNew = true;
    protected String associationAttributeName = null;
    protected String filterAttributeName = null;
    //protected String readCustomMethodName = null;

    protected LovDef lovDef;
    protected LovLiveGeneric lovWindow;
    protected TableDef editLovDef;

    public Lov(int width, int height, boolean showButtonNew) {
        this();
        this.width  = width;
        this.height = height;
        this.showButtonNew = showButtonNew;
    }

    public Lov(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public Lov() {
    }

    public boolean inizialize() {
        if (lovWindow == null) {
            //lovDef.fixAttributeFormNames(associationAttributeName);
            lovWindow = new LovLiveGeneric(lovDef, editLovDef);
            lovWindow.showButtonNew(showButtonNew);
            lovWindow.setSize(width, height);
            return true;
        }
        return false;
    }

    public void setLovDef(LovDef lovDef) {
        this.lovDef = lovDef;
    }
    public LovDef getLovDef() {
        return lovDef;
    }

    public void setLovWindow(LovLiveGeneric lovWindow) {
        this.lovWindow = lovWindow;
    }
    public LovLiveGeneric getLovWindow() {
        return lovWindow;
    }

    public TableDef getEditLovDef() {
        return editLovDef;
    }
    public void setEditLovDef(TableDef editLovDef) {
        this.editLovDef = editLovDef;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isShowButtonNew() {
        return showButtonNew;
    }
    public void setShowButtonNew(boolean showButtonNew) {
        this.showButtonNew = showButtonNew;
    }

    public String getAssociationAttributeName() {
        return associationAttributeName;
    }
    public void setAssociationAttributeName(String associationAttributeName) {
        this.associationAttributeName = associationAttributeName;
    }

    public String getFilterAttributeName() {
        return filterAttributeName;
    }
    public void setFilterAttributeName(String filterAttributeName) {
        this.filterAttributeName = filterAttributeName;
    }

//    public String getReadCustomMethodName() {
//        return readCustomMethodName;
//    }
//    public void setReadCustomMethodName(String readCustomMethodName) {
//        this.readCustomMethodName = readCustomMethodName;
//    }

    public void checkDymanicFilter(FormPanel formPanel) {
        IColumnFilter iColumnFilter = lovDef.getTableColumnFilters();
        if (formPanel != null && iColumnFilter != null) {
            setDynamicFilterValues(iColumnFilter, formPanel);
        }
    }

    private void setDynamicFilterValues(IColumnFilter filter, FormPanel formPanel) {
        //Filter is a SimpleFilter
        if (       filter instanceof SimpleColumnFilter && MSFSharedUtils.paramNotNull(((SimpleColumnFilter)filter).getAttribute()) ) {
            SimpleColumnFilter scf = (SimpleColumnFilter) filter;
            Object value = scf.get(SimpleColumnFilter.ATTR_VALUE);
            if (value instanceof DynamicFilterValue && MSFSharedUtils.paramNotNull(value)) {
                DynamicFilterValue dfv = (DynamicFilterValue)value;
                String attribute = GWTUtils.adjustsColumnDefName(dfv.getAttributeName());
                if (dfv.getAttributeType() == DynamicFilterValue.SIMPLE_FIELD &&
                        MSFSharedUtils.paramNotNull(attribute)) {
                    dfv.setValue((Serializable) GWTUtils.findField(formPanel, attribute).getValue());
                } else if (dfv.getAttributeType() == DynamicFilterValue.COMBO_FIELD && 
                    MSFSharedUtils.paramNotNull(dfv.getAttributeSubName())) {
                    Field comboField = GWTUtils.findField(formPanel, attribute);
                    BaseModel item = (BaseModel)comboField.getValue();
                    Object attributeComboValue = (Object)item.get(dfv.getAttributeSubName());
                    dfv.setValue((Serializable) attributeComboValue);
                }
            }
        //Filter is a ListFilter
        } else if (filter instanceof ListColumnFilter && ((ListColumnFilter)filter).getFilterList()!=null) {
            ListColumnFilter lcf = (ListColumnFilter) filter;
            List<IColumnFilter> filterList = lcf.getFilterList();
            if ( filterList!=null && filterList.size()>0 ) {
                IColumnFilter childFilter = filterList.get(0);
                setDynamicFilterValues(childFilter, formPanel);
            }
        }
    }
    
    public void fixAttributeFormNames() {
        if ( lovDef != null ) {
            lovDef.fixAttributeFormNames(associationAttributeName);
        }
    }
    
}
