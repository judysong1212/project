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

public class ContentController extends Controller {

  private ContentView view;

  public ContentController() {
    registerEventTypes(AppEvents.Init, AppEvents.ShowPage);//, AppEvents.SetPageData
  }

  public void initialize() {
    view = new ContentView(this);
  }

  public void handleEvent(AppEvent event) {
    forwardToView(view, event);
  }

}
