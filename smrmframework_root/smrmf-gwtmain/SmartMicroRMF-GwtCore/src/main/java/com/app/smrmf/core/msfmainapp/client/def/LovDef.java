/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;

public class LovDef extends TableDef {
    private List<ColumnLovDef> columnsDefinition = null;
    
    public LovDef() {
        super();
    }

    /**
     * This method sets the private parameter List<ColumnLovDef> and creates and 
     * set the parameter List<ColumnDef> into super class.
     *  
     * @param columnsDefinition List of columns Lov definition
     */
    public void setListColumns(List<ColumnLovDef> columnsDefinition) {
        this.columnsDefinition = columnsDefinition;
        setTableDefColumnDefinition();
    }
    
    private void setTableDefColumnDefinition(){
        List<ColumnDef> columnDefs = new ArrayList<ColumnDef>();
        for (ColumnLovDef columnLovDef : columnsDefinition) {
            //columnDefs.add(columnLovDef.getColumnDef());
            columnDefs.add(columnLovDef);
        }
        super.setColumnsDefinition(columnDefs);
    }

    public void fixAttributeFormNames(String associationAttributeName) {
        String assocAttrName = 
            MSFSharedUtils.paramNotNull(associationAttributeName) ? associationAttributeName+"." : "";
        for (ColumnLovDef columnLovDef : columnsDefinition) {
            String attributeForm  = columnLovDef.getAttributeForm();
            if ( MSFSharedUtils.paramNull(attributeForm) ) {
                String attributeQuery = columnLovDef.getAttributeQuery();
                attributeForm = GWTUtils.adjustsColumnDefName(assocAttrName + attributeQuery);
                columnLovDef.setAttributeForm(attributeForm);
            }
        }
    }

    public List<ColumnLovDef> getListColumns() {
        return columnsDefinition;
    }
    
    /**
     * This method convert the basemodel in input with attributes from query, 
     * in a equal basemodel but whit form attributes.
     * If the attribute form is null or empty, don't put into return basemodel.
     * 
     * @param bmGrid Base model with attributes name from query/database table
     * @return a Base model with equal 
     */
    public BaseModel getBaseModelForm(BaseModel bmGrid){
        BaseModel result = new BaseModel();
        Map<String, Object> map = bmGrid.getProperties();
        Iterator<ColumnLovDef> iter = columnsDefinition.iterator();
        while (iter.hasNext()) {
            ColumnLovDef columnLovDef = (ColumnLovDef) iter.next();
            String key = columnLovDef.getAttributeQuery();
            Object obj = map.get(key);
            String attrForm = columnLovDef.getAttributeForm();
            map.remove(key);
            if (MSFSharedUtils.paramNotNull(attrForm)) {
                map.put(attrForm, obj);
            }
        }
        result.setProperties(map);
        return result;
    }

    public void updateBaseModelForm(BaseModel bmGrid, FormBinding formBinding){
        if ( formBinding==null || 
                //CM: formBinding.getModel()==null || 
             bmGrid==null || bmGrid.getProperties()==null || bmGrid.getProperties().keySet()==null ||
             columnsDefinition==null || columnsDefinition.iterator()==null ) {
            return;
        }
        //Iterator<String> iter = bmGrid.getProperties().keySet().iterator();
        //ModelData formModel = formBinding.getModel();
        //while (iter.hasNext()) {
        //    String lovKey  = iter.next();
        //    String formKey = lovId + lovKey;
        //    Object obj = bmGrid.get(lovKey);
        //    formModel.set(formKey, obj);
        //}
        //boolean modelIsNull = false;
        ModelData formModel = formBinding.getModel();
        if (formModel == null) {
            //modelIsNull = true;
            formModel = new BaseModel();
        }
        Iterator<ColumnLovDef> iter = columnsDefinition.iterator();
        while (iter.hasNext()) {
            ColumnLovDef columnLovDef = (ColumnLovDef) iter.next();
            String key = columnLovDef.getAttributeQuery();
            Object obj = bmGrid.get(key);
            String attrForm = columnLovDef.getAttributeForm();
            if (MSFSharedUtils.paramNotNull(attrForm)) {
                formModel.set(attrForm, obj);
            }
        }
        //if (modelIsNull) {
        formBinding.bind(formModel);
        //}
    }

    public void addHiddenColumn(List<ColumnDef> columnsHiddenDefinition) {
        int oldCount = columnsDefinition.size();
        for (final ColumnDef c: columnsHiddenDefinition) {
            if (c instanceof ColumnListDef) {
                addHiddenColumn(c.getAttributeName(), ((ColumnListDef) c).getColumnsDefinitionLKP());
            } else {
                ColumnLovDef columnLovDef = returnColumnLov(c.getAttributeName());
                if (columnLovDef == null) {
                    columnLovDef = new ColumnLovDef(c.getTitle(), c.getAttributeName(), null, c.getType(), 0);
                    columnLovDef.setIsVisibleInGrid(false);
                    columnLovDef.setIsFakeAttribute(c.isFakeAttribute());
                    columnsDefinition.add(columnLovDef);
                }
            }
        }
        if (columnsDefinition.size() != oldCount) {
            setTableDefColumnDefinition();
        }
    }
    
    public void addHiddenColumn(String alias, List<ColumnDef> columnsHiddenDefinition) {
        int oldCount = columnsDefinition.size();
        for (final ColumnDef c: columnsHiddenDefinition) {
            if (c instanceof ColumnListDef) {
                addHiddenColumn(c.getAttributeName(), ((ColumnListDef) c).getColumnsDefinitionLKP());
            } else {
                String name = alias + TableDef.SEPARATOR_CLIENT + c.getAttributeName();
                ColumnLovDef columnLovDef = returnColumnLov(name);
                if (columnLovDef == null) {
                    columnLovDef = new ColumnLovDef(c.getTitle(), name, name, c.getType(), 0){
                        {
                            setIsVisibleInGrid(false);
                            setIsFakeAttribute(c.isFakeAttribute());
                        }
                    };
                    columnsDefinition.add(columnLovDef);
                }
            }
        }
        if (columnsDefinition.size() != oldCount) {
            setTableDefColumnDefinition();
        }
    }
    private ColumnLovDef returnColumnLov(String attribute){
        for (ColumnLovDef c : columnsDefinition) {
            if (attribute.equals(c.getAttributeName())) {
                return c;
            }
        }
        return null;
    }
    
    
    
}
