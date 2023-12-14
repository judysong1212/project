/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;

import com.app.smrmf.core.msfmainapp.client.AppEvents;

import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;

public class AppController extends Controller {

  private  AppView appView; 

  public AppController() {
	  
      appView = new AppView(this);
      registerEventTypes(AppEvents.Init);
      registerEventTypes(AppEvents.LogOut);  
  }

  public void handleEvent(AppEvent event) {
      forwardToView(appView, event);


  }

}
