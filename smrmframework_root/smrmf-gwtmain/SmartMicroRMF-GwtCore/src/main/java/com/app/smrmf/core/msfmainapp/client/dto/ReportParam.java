/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

public class ReportParam extends BaseModel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public final static String RDA_ATTR_NAME = "rdaAttrName";
    public final static String MODEL_ATTR_NAME  = "modelAttrName";
    public final static String DEFAULT_VALUE    = "defaultValue";
    
    public ReportParam(String rdaAttrName, String modelAttrName) {
        set(RDA_ATTR_NAME, rdaAttrName);
        set(MODEL_ATTR_NAME,  modelAttrName);
    }
    
    public ReportParam(String rdaAttrName, String modelAttrName, String defaultValue) {
        set(RDA_ATTR_NAME, rdaAttrName);
        set(MODEL_ATTR_NAME,  modelAttrName);
        set(DEFAULT_VALUE,    defaultValue);
    }
    
    public String getModelAttrName(){
        return get(MODEL_ATTR_NAME);
    }

    public void setModelAttrName(String modelAttrName){
        set(MODEL_ATTR_NAME,  modelAttrName);
    }

    public String getRdaAttrName(){
        return get(RDA_ATTR_NAME);
    }
    
    public void setRdaAttrName(String rdaAttrName){
        set(RDA_ATTR_NAME,  rdaAttrName);
    }

    public String getDefaultValue(){
        return get(DEFAULT_VALUE);
    }
    
    public void setDefaultValue(String defaultValue){
        set(DEFAULT_VALUE,  defaultValue);
    }

}
