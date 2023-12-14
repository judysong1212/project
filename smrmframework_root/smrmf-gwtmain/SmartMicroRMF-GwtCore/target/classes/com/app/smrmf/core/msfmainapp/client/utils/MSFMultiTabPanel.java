/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.form.IMSFWindow;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.google.gwt.user.client.ui.Widget;
import com.msfgwt.reflection.client.Reflectable;

@Reflectable
public class MSFMultiTabPanel extends MSFPanel implements IMSFWindow {

    protected int indexTabSelected = 0;
    protected List<TabItem> tabItems = new ArrayList<TabItem>();
    
    public void addTabItem(Widget widget, String title) {
        TabItem tabItem = new TabItem(title);
        tabItem.add(widget);
        tabItem.setScrollMode(Scroll.AUTO);
        this.tabItems.add(tabItem);
    }
    
    public List<TabItem> getTabItems() {
        return this.tabItems;
    }
    
    public int getIndexTabSelected(){
        return this.indexTabSelected;
    }

    @Override
    public void setGrant(boolean seInsert, boolean seUpdate, boolean seDelete) {
        super.setGrant(seInsert, seUpdate, seDelete);

        //set grants also to all my children
        for ( int i=0 ; tabItems!=null && i<tabItems.size() ; i++ ) {
            TabItem tabItem = tabItems.get(i);
            Component widget = tabItem.getItemCount()>0 ? tabItem.getItem(0) : null;
            if ( widget!=null ) {
                if (        widget instanceof MSFPanel ) {
                    ((MSFPanel) widget).setGrant(seInsert, seUpdate, seDelete);
                } else if ( widget instanceof MSFGridPanel ) {
                    ((MSFGridPanel) widget).setGrant(seInsert, seUpdate, seDelete);
                }
            }
        }
    }

}
