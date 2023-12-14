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
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GenericService.gwt")
public interface GenericService extends RemoteService {

    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
        private static GenericServiceAsync instance;
        public static GenericServiceAsync getInstance(){
            if (instance == null) {
                instance = GWT.create(GenericService.class);
            }
            return instance;
        }
    }

//    public List<BaseModel> getListGenericObjects(
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter filters, 
//            List<ColumnOrder> columnOrders) throws MSFException;

    public ServiceParameters activityOnGenericObject(
            ServiceParameters serviceParameters
//            String className, 
//            BaseModel genericObject, 
//            ActionDatabase actionDatabase
    ) throws MSFException;

    public PagingLoadResult<BaseModel> getListGenericObjects(
            ServiceParameters serviceParameters
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter columnFilters, 
//            List<ColumnOrder> columnOrders, 
//            PagingLoadConfig pagingLoadConfig
    ) throws MSFException;

    public BaseModel readGenericObject(
            ServiceParameters serviceParameters
//            String className, 
//            BaseModel genericObject, 
//            ColumnAttribute[] tableAttributes, 
//            String associationAttrName
    ) throws MSFException;

    public String exportXLSGenericObjects(
            ServiceParameters serviceParameters
//            String sheetName, 
//            String className, 
//            ColumnAttribute[] tableAttributes, 
//            IColumnFilter filters, 
//            List<ColumnOrder> columnOrders
    ) throws MSFException;

    public List<BaseModel> getSampleValues(
            String            paramString, 
            BaseModel         paramBaseModel, 
            ColumnAttribute[] paramColumnAttribute, 
            IColumnFilter     paramColumnFilter, 
            List<ColumnOrder> paramColumnOrder,
            PagingLoadConfig  paramPagingLoadConfig,
            ActionDatabase    paramActionDatabase);
}
