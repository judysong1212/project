/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

public class DatabaseObject extends BaseModel{

    private static final long serialVersionUID = 1L;

    public DatabaseObject(){
    }

    public DatabaseObject(String name, String type){
        set("name", name);
        set("type", type);
        set("descr", name+" "+type+"");
    }
    
    public String getName() {
        return get("name");
    }
    
    public String getType() {
        return get("type");
    }
    
    public String getDescr() {
        return get("descr");
    }
}
