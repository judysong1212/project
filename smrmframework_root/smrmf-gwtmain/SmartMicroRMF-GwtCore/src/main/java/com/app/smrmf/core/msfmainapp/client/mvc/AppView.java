/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;


import com.app.smrmf.core.msfmainapp.client.AppEvents;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.login.ToolbarApp;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public final class AppView extends View {
	
	  public static final String CENTER_PANEL = "centerPanel";
	    public static final String WEST_PANEL = "westPanel";
	    public static final String NORTH_PANEL = "northPanel";
	    public static final String VIEWPORT = "viewPort";

	    private Viewport     viewport;
	    private ContentPanel centerPanel;
	    private ContentPanel northPanel;
	    private ContentPanel westPanel;

	    public AppView(Controller controller) {
	        super(controller);
	    }

	    protected void handleEvent(AppEvent event) {
	        EventType type = event.getType();
	        if (type == AppEvents.LogOut) {
	            MessageBox.confirm("종료",MSFMainApp.MSFCONSTANTS.MessaggioUscita(), new Listener<MessageBoxEvent>(){
	                //@Override
	                public void handleEvent(MessageBoxEvent be) {
	                    if (be.getButtonClicked().getItemId().equalsIgnoreCase("yes")){
	                        MSFMainApp.get().logout();;
	                    }
	                }
	            });

	        }

	    }

	    protected void initialize() {
	        viewport = new Viewport();
	        viewport.setLayout(new BorderLayout());
	        Registry.register(VIEWPORT, viewport);
	        createNorth();
	        createWest();
	        createCenter();
	        RootPanel.get().clear();
	        RootPanel.get().add(viewport);
	    }

	    private void createCenter() {
	        centerPanel = new ContentPanel();
	        centerPanel.setBorders(false);
	        centerPanel.setHeaderVisible(false);
	        centerPanel.setLayout(new FitLayout());
	        BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);
	        data.setMargins(new Margins(5, 5, 5, 0));
	        viewport.add(centerPanel, data);
	        Registry.register(CENTER_PANEL, centerPanel);
	    }

	    private void createWest() {
	        BorderLayoutData data = new BorderLayoutData(LayoutRegion.WEST, 220, 150, 320);
	        data.setMargins(new Margins(5, 5, 5, 5));
	        data.setCollapsible(true);
	        westPanel = new ContentPanel();
	        ToolBar toolBar = new ToolBar();
	        westPanel.setTopComponent(toolBar);
	        viewport.add(westPanel, data);
	        Registry.register(WEST_PANEL, westPanel);
	    }

	    private void createNorth() {
	        

			BorderLayoutData data = new BorderLayoutData(LayoutRegion.NORTH,50);  //25
		    data.setMargins(new Margins(0, 0, 2, 0));
		    data.setCollapsible(false); 
		      
	        northPanel = new ContentPanel(new ColumnLayout());  
	        northPanel.setHeaderVisible(false);  
	        northPanel.setWidth("100%");
	        northPanel.setBodyStyle("background: url('" + GWT.getHostPageBaseURL() + "images/top_bg.jpg')  top left ; background-repeat:repeat-x;"); 
	        northPanel.layout(true);
	        northPanel.setId("toolbarPanel"); 
	        

	        ToolbarApp toolBarApp = new ToolbarApp(); 
	        toolBarApp.setHeight(50);
	        toolBarApp.setWidth("100%"); 
	        toolBarApp.setUsername(MSFMainApp.get().getUser().getUsrNm());	 
	        toolBarApp.setAlignment(HorizontalAlignment.RIGHT); 
	       // northPanel.setTopComponent(toolBarApp);
	        
	        ContentPanel northSbLeftPanel = new ContentPanel(new FitLayout());
			northSbLeftPanel.setHeaderVisible(false); 
			northSbLeftPanel.setBorders(false);
			northSbLeftPanel.setBodyBorder(false);
			northSbLeftPanel.setWidth(224);
			northSbLeftPanel.setHeight(50);
			 
			northSbLeftPanel.setBodyStyle("background: url('" + GWT.getHostPageBaseURL() + "images/top_logo_buss.png') no-repeat top left; padding:3px 0px 0px 0px;");
			northSbLeftPanel.setSize("224", "50"); 


	         
			final VerticalPanel vpNorthSbRightPanel = new VerticalPanel(); 

			vpNorthSbRightPanel.add(toolBarApp); 
			vpNorthSbRightPanel.setSpacing(1);
			vpNorthSbRightPanel.setCellVerticalAlignment(toolBarApp, HasVerticalAlignment.ALIGN_MIDDLE);
			vpNorthSbRightPanel.setCellHorizontalAlignment(toolBarApp,HasHorizontalAlignment.ALIGN_RIGHT); 
			vpNorthSbRightPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
			vpNorthSbRightPanel.setSize("100%", "50"); 
			
			ContentPanel northSbRightPanel = new ContentPanel();
			northSbRightPanel.setHeaderVisible(false); 
			northSbRightPanel.setBorders(false);
			northSbRightPanel.setBodyBorder(false);
		 	northSbRightPanel.setBodyStyle("background: transparent repeat-x ;"); 
			northSbRightPanel.add(vpNorthSbRightPanel);
			//northSbRightPanel.setSize("100%", "50");
		 	//northSbRightPanel.add(toolBarApp);
			 
	 	 //   LayoutContainer layoutContainer_1 = new LayoutContainer(new ColumnLayout());
		    
		  //  LayoutContainer layoutContainer_1_1 = new LayoutContainer();
		  //  layoutContainer_1_1.setBorders(true);
		  //  LabelField labelfld_1_1 = new LabelField(""); 
		  //  layoutContainer_1_1.add(labelfld_1_1 ); 
		  //  labelfld_1_1.setBorders(false);
		    
		   // ContentPanel cpToolBarApp = new ContentPanel( );
		   // cpToolBarApp.setHeaderVisible(false); 
		   // cpToolBarApp.setBorders(false);
		   // cpToolBarApp.setBodyBorder(false);
		   /// cpToolBarApp.setSize("250", "50");
		   // cpToolBarApp.add(toolBarApp);
			
		   // LayoutContainer layoutContainer_1_2 = new LayoutContainer();
		    //layoutContainer_1_2.setBorders(true);   
		    //layoutContainer_1_2.add(cpToolBarApp );  
		    
		     
		   // layoutContainer_1.add(layoutContainer_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7)); 
		   // layoutContainer_1.add(layoutContainer_1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));	 
		    
		   // northSbRightPanel.add(layoutContainer_1);
		 	
			northPanel.add(northSbLeftPanel,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
 			northPanel.add(northSbRightPanel ,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));  
			
 			//northPanel.add(northSbLeftPanel ); 
 			//northPanel.add(northSbRightPanel );  
 			
	        viewport.add(northPanel, data);
	        Registry.register(NORTH_PANEL, northPanel);
	    }
	  
}
