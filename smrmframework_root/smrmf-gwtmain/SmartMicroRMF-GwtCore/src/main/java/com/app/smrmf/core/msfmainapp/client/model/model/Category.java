/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.model.model;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.form.WindowFactory;

import com.extjs.gxt.ui.client.Style.HideMode;
import com.extjs.gxt.ui.client.data.BaseTreeModel;

public class Category extends BaseTreeModel {

    protected Category() {
    }

    public Category(String id, String name, String icon,String upid) {
        set(MSFMainApp.ATTR_ID,   id);
        set(MSFMainApp.ATTR_NAME, name);
        set(MSFMainApp.ATTR_ICON, icon);
        set(MSFMainApp.ATTR_UPID, upid);
    }

    public Category(String name, String icon,String upid) {
        set(MSFMainApp.ATTR_NAME, name);
        set(MSFMainApp.ATTR_ICON, icon);
        set(MSFMainApp.ATTR_UPID, upid);
    }

    public String getName() {
        return (String) get(MSFMainApp.ATTR_NAME);
    }
    

    public String getUpId() {
        return (String) get(MSFMainApp.ATTR_UPID);
    }

    public String getIcon() {
        return (String) get(MSFMainApp.ATTR_ICON);
    }

    public String toString() {
        return getName();
    }

    public void add(String id, String title, String upid, /*LayoutContainer window*/ WindowFactory windowFactory, String image, String icon) {
        add(new Entry(id, title, upid,windowFactory, image, icon));
    }

    public void add(String id, String title, String upid,/*LayoutContainer window*/ WindowFactory windowFactory, String image, String icon, boolean fill) {
        add(new Entry(id, title,  upid,windowFactory, image, icon, fill));
    }

    public void add(String id, String title,String upid, /*LayoutContainer window*/ WindowFactory windowFactory, String image, String icon, boolean fill, boolean closable,
            HideMode hideMode) {
        add(new Entry(id, title, upid,windowFactory, image, icon, fill, closable, hideMode));
    }
    
    
}
