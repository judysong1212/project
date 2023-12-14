/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ServiceParameters extends BaseModel implements IsSerializable {

    /**
     *  This attribute is only to serialization problem, 
     *  it's used into SimpleColumnFilter for the dymanic filters
     */
    private ActionDatabase actionDatabase;

    private static final long serialVersionUID = 1L;

    //Common attributes
    public static final String ATTR_CLS_NAME                = "clsName";
    public static final String ATTR_ACTION_DATABASE         = "actionDatabase";
    public static final String ATTR_CUSTOM_METHOD_NAME      = "customMethodName";
    //public static final String ATTR_USER                  = "user";

    //create/read/update/delete
    public static final String ATTR_DATA_OBJECTS          = "dataObjects";

    //read
    public static final String ATTR_ASSOCIATION_ATTR_NAME = "associationAttrName";
    public static final String ATTR_FILTER_ATTR_NAME      = "filterAttrName";

    //list/read
    public static final String ATTR_TABLE_ATTRIBUTES      = "tableAttributes";

    //list
    public static final String ATTR_COLUMN_FILTERS        = "columnFilters";
    public static final String ATTR_COLUMN_ORDERS         = "columnOrders";
    public static final String ATTR_PAGING_LOAD_CONFIG    = "pagingLoadConfig";

    //export
    public static final String ATTR_SHEET_NAME            = "sheetName";

    public static final String ATTR_RELOAD_DATA           = "reloadData";
    
    public static final String ATTR_NO_HISTORY            = "noHistory";
    
    public static final String ATTR_NO_PAGEDATA            = "noPageData";

    private ServiceParameters() {
        super();
        super.allowNestedValues = true;
    }

    public static ServiceParameters getCrtUpdDelParameters(
            String          className,
            BaseModel       dataObject,
            ColumnAttribute[] tableAttributes, 
            ActionDatabase  actionDatabase,
            String          customMethodName,
            Boolean         reloadData) {
        ServiceParameters retval = new ServiceParameters();
        retval.setClsName(className);
        retval.setDataObjects(dataObject);
        retval.setTableAttributes(tableAttributes);
        retval.setActionDatabase(actionDatabase);
        retval.setCustomMethodName(customMethodName);
        retval.setReloadData(reloadData);
        return retval;
    }
    
    

    public static ServiceParameters getDelParameters(
            String          className,
            List<BaseModel> dataObjects,
            ActionDatabase  actionDatabase,
            String          customMethodName) {
        ServiceParameters retval = new ServiceParameters();
        retval.setClsName(className);
        retval.setDataObjects(dataObjects);
        retval.setActionDatabase(actionDatabase);
        retval.setCustomMethodName(customMethodName);
        return retval;
    }

    public static ServiceParameters getReadParameters(
            String            className, 
            BaseModel         dataObject, 
            ActionDatabase    actionDatabase,
            ColumnAttribute[] tableAttributes, 
            String            associationAttrName,
            String            filterAttrName,
            String            customMethodName) {
        ServiceParameters retval = new ServiceParameters();
        retval.setClsName(className);
        retval.setDataObjects(dataObject);
        retval.setActionDatabase(actionDatabase);
        retval.setTableAttributes(tableAttributes);
        retval.setAssociationAttrName(associationAttrName);
        retval.setFilterAttrName(filterAttrName);
        retval.setCustomMethodName(customMethodName);
        return retval;
    }

    public static ServiceParameters getListParameters(
            String className, 
            ActionDatabase    actionDatabase,
            ColumnAttribute[] tableAttributes, 
            IColumnFilter     columnFilters, 
            List<ColumnOrder> columnOrders, 
            PagingLoadConfig  pagingLoadConfig,
            String            customMethodName) {
        ServiceParameters retval = new ServiceParameters();
        retval.setClsName(className);
        retval.setActionDatabase(actionDatabase);
        retval.setTableAttributes(tableAttributes);
        retval.setColumnFilters(columnFilters);
        retval.setColumnOrders(columnOrders);
        retval.setPagingLoadConfig(pagingLoadConfig);
        retval.setCustomMethodName(customMethodName);
        return retval;
    }

    public static ServiceParameters getExportParameters(
            String            className, 
            ActionDatabase    actionDatabase,
            String            sheetName, 
            ColumnAttribute[] tableAttributes, 
            IColumnFilter     columnFilters, 
            List<ColumnOrder> columnOrders,
            String            customMethodName) {
        ServiceParameters retval = new ServiceParameters();
        retval.setClsName(className);
        retval.setActionDatabase(actionDatabase);
        retval.setSheetName(sheetName);
        retval.setTableAttributes(tableAttributes);
        retval.setColumnFilters(columnFilters);
        retval.setColumnOrders(columnOrders);
        retval.setCustomMethodName(customMethodName);
        return retval;
    }

    public String getClsName() {
        return get(ATTR_CLS_NAME);
    }
    public void setClsName(String clsName) {
        set(ATTR_CLS_NAME, clsName);
    }

    public List<BaseModel> getDataObjects() {
        return get(ATTR_DATA_OBJECTS);
    }
    public void setDataObjects(List<BaseModel> dataObjects) {
        set(ATTR_DATA_OBJECTS, dataObjects);
    }
    public void setDataObjects(BaseModel dataObject) {
        List<BaseModel> list = new ArrayList<BaseModel>();
        list.add(dataObject);
        set(ATTR_DATA_OBJECTS, list);
    }

//    public Sysm0100VO getUser() {
//        return get(ATTR_USER);
//    }
//    public void setUser(Sysm0100VO user) {
//        set(ATTR_USER, user);
//    }

    public ActionDatabase getActionDatabase() {
        return get(ATTR_ACTION_DATABASE);
    }
    public void setActionDatabase(ActionDatabase actionDatabase) {
        set(ATTR_ACTION_DATABASE, actionDatabase);
    }

    public String getSheetName() {
        return get(ATTR_SHEET_NAME);
    }
    public void setSheetName(String sheetName) {
        set(ATTR_SHEET_NAME, sheetName);
    }


    public ColumnAttribute[] getTableAttributes() {
        return get(ATTR_TABLE_ATTRIBUTES);
    }
    public void setTableAttributes(ColumnAttribute[] tableAttributes) {
        set(ATTR_TABLE_ATTRIBUTES, tableAttributes);
    }

    public String getAssociationAttrName() {
        return get(ATTR_ASSOCIATION_ATTR_NAME);
    }
    public void setAssociationAttrName(String associationAttrName) {
        set(ATTR_ASSOCIATION_ATTR_NAME, associationAttrName);
    }

    public String getFilterAttrName() {
        return get(ATTR_FILTER_ATTR_NAME);
    }
    public void setFilterAttrName(String filterAttrName) {
        set(ATTR_FILTER_ATTR_NAME, filterAttrName);
    }

    public String getCustomMethodName() {
        return get(ATTR_CUSTOM_METHOD_NAME);
    }
    public void setCustomMethodName(String customMethodName) {
        set(ATTR_CUSTOM_METHOD_NAME, customMethodName);
    }

    public IColumnFilter getColumnFilters() {
        return get(ATTR_COLUMN_FILTERS);
    }
    public void setColumnFilters(IColumnFilter columnFilters) {
        set(ATTR_COLUMN_FILTERS, columnFilters);
    }

    public List<ColumnOrder> getColumnOrders() {
        return get(ATTR_COLUMN_ORDERS);
    }
    public void setColumnOrders(List<ColumnOrder> columnOrders) {
        set(ATTR_COLUMN_ORDERS, columnOrders);
    }

    public PagingLoadConfig getPagingLoadConfig() {
        return get(ATTR_PAGING_LOAD_CONFIG);
    }
    public void setPagingLoadConfig(PagingLoadConfig pagingLoadConfig) {
        set(ATTR_PAGING_LOAD_CONFIG, pagingLoadConfig);
    }

    public Boolean isReloadData() {
        return get(ATTR_RELOAD_DATA);
    }
    public void setReloadData(Boolean reloadData) {
        set(ATTR_RELOAD_DATA, reloadData);
    }

    public Boolean isNoHistory() {
        return get(ATTR_NO_HISTORY);
    }
    public void setNoHistory(Boolean noHistory) {
        set(ATTR_NO_HISTORY, noHistory);
    }
    
/** TODO NULL 넘어오면 노페이지 처리로 수정하여 사용안함...... */
    public Boolean isNoPageData() {
        return get(ATTR_NO_PAGEDATA);
    }
    public void setNoPageData(Boolean noPageData) {
        set(ATTR_NO_PAGEDATA, noPageData);
    }
    
    
 
}
