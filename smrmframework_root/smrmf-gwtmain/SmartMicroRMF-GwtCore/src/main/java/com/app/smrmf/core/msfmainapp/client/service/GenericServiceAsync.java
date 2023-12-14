/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GenericServiceAsync {

    

//    public List<BaseModel> getListGenericObjects(
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter filters, 
//            List<ColumnOrder> columnOrders) throws MSFException;

    public void activityOnGenericObject(
            ServiceParameters serviceParameters, AsyncCallback<ServiceParameters> callback
//            String className, 
//            BaseModel genericObject, 
//            ActionDatabase actionDatabase
    );

    public void getListGenericObjects(
            ServiceParameters serviceParameters, AsyncCallback<PagingLoadResult<BaseModel>> callback
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter columnFilters, 
//            List<ColumnOrder> columnOrders, 
//            PagingLoadConfig pagingLoadConfig
    );

    public void readGenericObject(
            ServiceParameters serviceParameters, AsyncCallback<BaseModel> callback
//            String className, 
//            BaseModel genericObject, 
//            ColumnAttribute[] tableAttributes, 
//            String associationAttrName
    );

    public void exportXLSGenericObjects(
            ServiceParameters serviceParameters, AsyncCallback<String> callback
//            String sheetName, 
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter filters, 
//            List<ColumnOrder> columnOrders
    );

    public void getSampleValues(
            String            paramString, 
            BaseModel         paramBaseModel, 
            ColumnAttribute[] paramColumnAttribute, 
            IColumnFilter     paramColumnFilter, 
            List<ColumnOrder> paramColumnOrder,
            PagingLoadConfig  paramPagingLoadConfig,
            ActionDatabase    paramActionDatabase, AsyncCallback<List<BaseModel>> callback);
}
