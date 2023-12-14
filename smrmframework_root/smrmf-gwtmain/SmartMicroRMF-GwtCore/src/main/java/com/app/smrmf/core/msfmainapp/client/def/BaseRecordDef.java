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

import com.extjs.gxt.ui.client.data.BaseModel;


public class BaseRecordDef {
    public static String ID = "id";
    public static String DESCRIPTION = "description";

    private List<BaseModel> list;

    public BaseRecordDef(){
        list = new ArrayList<BaseModel>();
    }

    public void add(Object id, String description){
        BaseModel b = new BaseModel();
        b.set(ID, id);
        b.set(DESCRIPTION, description);
        list.add(b);
    }

    public List<BaseModel> getList() {
        return list;
    }
}
