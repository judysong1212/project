/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;

public class MSFTabPanel extends TabPanel{
    private MSFTabItem tabItemSelected;

    public MSFTabPanel() {
        setPlain(true);
        //setTabIndex(0);
        setAutoSelect(true);
    }

    public void setLastTabItemSelected(MSFTabItem tabItemSelected) {
        this.tabItemSelected = tabItemSelected;
    }

    public MSFTabItem getTabItemSelected() {
        return getDetailTabItemSelected(getSelectedItem());
    }

    private MSFTabItem getDetailTabItemSelected(TabItem tabItem){
        MSFTabItem detailTabItem = null;
        if (tabItem instanceof MSFTabItem) {
            detailTabItem = (MSFTabItem) tabItem;
        }
        return detailTabItem;
    }

    public MSFTabItem getLastTabItemSelected() {
        return tabItemSelected;
    }
}
