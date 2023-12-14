/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.app.smrmf.core.msfmainapp.client.form.IMSFWindow;
import com.app.smrmf.core.msfmainapp.client.form.Page;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;
import com.msfgwt.reflection.client.Reflectable;

@Reflectable
public class MSFPanel extends LayoutContainer implements IMSFWindow {

    public boolean seInsert;
    public boolean seUpdate; 
    public boolean seDelete;
    protected ContentPanel panel;
    protected Page page;
//    protected int indexTabSelected = 0;

    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        
        setLayout(new FillLayout()); 
        
        ContentPanel viewPanel = getViewPanel();
 
         viewPanel.setLayout(new FlowLayout()); 
  
        if (viewPanel instanceof Window) {
            ((Window) viewPanel).show();
        } else {
            add(viewPanel, new FillData(0)); 
        }
        
    }

    public ContentPanel getViewPanel() {
        return panel;
    }

    public void setViewPanel(ContentPanel contentPanel) {
        this.panel = contentPanel;
    }

    public void reload(){
        if (panel instanceof MSFGridPanel) {
            ((MSFGridPanel)panel).reload();
        }
    }

    public void setGrant(boolean seInsert, boolean seUpdate, boolean seDelete) {
        this.seInsert = seInsert;
        this.seUpdate = seUpdate;
        this.seDelete = seDelete;
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

//    public List<TabItem> getExtraTabItems() {
//        return null;
//    }
//    
//    public int getIndexTabSelected(){
//        return this.indexTabSelected;
//    }
}
