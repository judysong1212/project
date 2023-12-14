/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;
 
 
 
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.model.model.Entry;
import com.app.smrmf.core.msfmainapp.client.utils.MSFMultiTabPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;

public class Page extends TabPanel {

    protected Entry entry;

    public LayoutContainer getContent() {
        return entry.getWindow();
    }

    public Page(final Entry entry) {
        this.entry = entry;

        setTabPosition(TabPosition.BOTTOM);
        setBorderStyle(false);
        setBodyBorder(false);

        addListener(Events.Adopt, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                if(getParent() != null && getParent() instanceof TabItem) {
                    TabItem t = (TabItem) getParent();
                    t.setHideMode(entry.getHideMode());
                }
            }
        });

//        addListener(Events.Select, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//                
//                if (be instanceof TabPanelEvent) {
//                    TabItem item = ((TabPanelEvent)be).getItem();
//                    Widget w = item.getWidget(0);
//                    if (w instanceof MSFPanel) {
//                        ((MSFPanel)w).fireEvent(Events.Render);
//                    }
//                }
//                
//            }
//        });

        //Get the specific window and pass the Page
        LayoutContainer window = entry.getWindow();
        
        List<TabItem> tabItems = null;
        int tabSelected = 0;
        if (window instanceof MSFMultiTabPanel) {
            tabItems = ((MSFMultiTabPanel)window).getTabItems();
            tabSelected = ((MSFMultiTabPanel)window).getIndexTabSelected();
        } 
        
        if (tabItems != null && tabItems.size() > 0)  {
            for (TabItem tab : tabItems) {
                tab.setScrollMode(Scroll.AUTO);
                if (entry.isFill()) {
                    tab.setLayout(new FitLayout());
                    tab.setScrollMode(Scroll.AUTO);
                }
                tab.setHideMode(entry.getHideMode());
//                tab.add(window);
                add(tab);
            }
            setSelection(getItem(tabSelected));
        } else {
            TabItem tabItem = new TabItem();
            tabItem.setScrollMode(Scroll.AUTO);
            if (entry.isFill()) {
                tabItem.setLayout(new FitLayout());
                tabItem.setScrollMode(Scroll.AUTO);
            }
            tabItem.setHideMode(entry.getHideMode());
            tabItem.setText("프로그램");
            tabItem.add(window);
            add(tabItem);
        }

        try {
            ((IMSFWindow) window).setPage(this);
        } catch (Exception ex) {
            GWT.log("EXCEPTION setting page on window: "+ex);
        }

        String sourceHTML = entry.getSourceUrl();
        if (entry.isClosable() && MSFSharedUtils.paramNotNull(sourceHTML)) {
            TabItem source = new TabItem();
            source.setText("도움말");
            source.setUrl(sourceHTML);
            add(source);
        }
    }

}
