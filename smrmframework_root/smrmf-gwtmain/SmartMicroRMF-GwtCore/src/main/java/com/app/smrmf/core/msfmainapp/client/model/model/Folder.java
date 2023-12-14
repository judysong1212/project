/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.model.model;

import java.io.Serializable;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;

import com.extjs.gxt.ui.client.data.BaseTreeModel;

public class Folder extends BaseTreeModel implements Serializable {

    private static int ID = 0;

    public Folder() {
        set(MSFMainApp.ATTR_ID, ID++);
    }

    public Folder(String name) {
        set(MSFMainApp.ATTR_ID, ID++);
        set(MSFMainApp.ATTR_NAME, name); 
    }

    public Folder(String name, BaseTreeModel[] children) {
        this(name);
        for (int i = 0; i < children.length; i++) {
            add(children[i]);
        }
    }

    public Integer getId() {
        return (Integer) get(MSFMainApp.ATTR_ID);
    }

    public String getName() {
        return (String) get(MSFMainApp.ATTR_NAME);
    }

    public String toString() {
        return getName();
    }

}
