/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;


import com.app.smrmf.core.msfmainapp.client.AppEvents;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class NavigationController extends Controller {

	   private NavigationView view;

	    public NavigationController() {
	        registerEventTypes(AppEvents.Init);
	        registerEventTypes(AppEvents.HidePage);
	        registerEventTypes(AppEvents.TabChange);
	        registerEventTypes(AppEvents.LogOut);
	    }

	    public void initialize() {
	        view = new NavigationView(this);
	    }

	    public void handleEvent(AppEvent event) {
	        EventType t = event.getType();
	        if (t == AppEvents.Init ||
	            t == AppEvents.HidePage ||
	            t == AppEvents.TabChange ||
	            t == AppEvents.LogOut) {
	            forwardToView(view, event);
	        }
	    }

	    public NavigationView getNavigationView(){
	        return view;
	    }
	    
//  private NavigationView view;
//
//  public NavigationController() {
//    registerEventTypes(AppEvents.Init);
//    registerEventTypes(AppEvents.HidePage);
//    registerEventTypes(AppEvents.TabChange);
//  }
//
//  public void initialize() {
//    view = new NavigationView(this);
//  }
//
//  @Override
//  public void handleEvent(AppEvent event) {
//    EventType t = event.getType();
//    if (t == AppEvents.Init || t == AppEvents.HidePage || t == AppEvents.TabChange) {
//      forwardToView(view, event);
//    }
//  }

}
