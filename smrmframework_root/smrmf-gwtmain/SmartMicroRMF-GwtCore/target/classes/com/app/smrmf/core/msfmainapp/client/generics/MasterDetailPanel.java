/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTabItem;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTabPanel;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;

public class MasterDetailPanel extends LayoutContainer {

    protected TableDef masterTable;
    protected MSFGridPanel masterMSFGrid;
    protected MSFTabPanel tabPanel;
    protected BorderLayoutData northData;
    protected BorderLayoutData centerData;

    public MasterDetailPanel(TableDef masterTable, List<MSFTabItem> listDetailTabs) {
        this(masterTable, listDetailTabs, true, true, true);
    }

    public MasterDetailPanel(TableDef masterTable, List<MSFTabItem> listDetailTabs, boolean seInsert, boolean seUpdate, boolean seDelete) {
        this.masterTable = masterTable;
        //masterMSFGrid = new MSFGridPanel(masterTable, seInsert, seUpdate, seDelete);

        BorderLayout borderLayout = new BorderLayout();
        this.setStyleAttribute("backgroundColor", "#FFFFFF");
        this.setLayout(borderLayout);
        northData  = new BorderLayoutData(LayoutRegion.NORTH, 300);
        centerData = new BorderLayoutData(LayoutRegion.CENTER);
        masterMSFGrid = new MSFGridPanel(masterTable, seInsert, seUpdate, seDelete);

        this.add(masterMSFGrid, northData);
        masterMSFGrid.setMargin(0, 10, 0, 0);
        //masterMSFGrid.setSize(600, 300); 
        //add(masterMSFGrid);
//        Grid<BaseModel> masterGrid = masterMSFGrid.getGrid();
//        masterGrid.addListener(Events.CellClick, new Listener<BaseEvent>() {
//            public void handleEvent(BaseEvent be) {
//                MSFTabItem detailTabItem = tabPanel.getTabItemSelected();
//                tabPanel.setLastTabItemSelected(detailTabItem);
//                if (detailTabItem != null) {
//                	getMasterTable().synchronizeGridDetail(
//                			masterMSFGrid.getCurrentlySelectedItem(), 
//                            detailTabItem.getDetailGridPanel());
//                }
//            }
//        });

        tabPanel = new MSFTabPanel();
        //tabPanel.setSize(600, 250);  
        
        for (MSFTabItem tabItem : listDetailTabs) {
            tabPanel.add(tabItem);
        }
        tabPanel.addListener(Events.Select, new Listener<TabPanelEvent>() {
            public void handleEvent(TabPanelEvent be) {
                MSFTabItem detailTabItem= tabPanel.getTabItemSelected();
                if (tabPanel.getLastTabItemSelected() != detailTabItem) {
                    if (detailTabItem != null) {
                    	getMasterTable().synchronizeGridDetail(
                        		masterMSFGrid.getCurrentlySelectedItem(),
                                detailTabItem.getDetailGridPanel());
                    	tabPanel.setLastTabItemSelected(detailTabItem);
                    }
                }
            }
        });
        this.add(tabPanel, centerData);
        //add(tabPanel);
    }

	public TableDef getMasterTable() {
		return masterTable;
	}

    public MSFFormPanel getMSFFormPanel() {
        return masterMSFGrid!=null ? masterMSFGrid.getMSFFormPanel() : null;
    }

    public MSFGridPanel getMSFGridPanel() {
        return masterMSFGrid;
    }

	public void setHeightMaster(int height){
        //masterMSFGrid.setHeight(height);
        northData.setSize(height);
    }
}