/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client;
 

import com.app.smrmf.core.msfmainapp.client.utils.MSFEventType;

import com.extjs.gxt.ui.client.event.EventType;

public class AppEvents {
  
  public static final EventType Init      = new MSFEventType("Init");

  public static final EventType ShowPage  = new MSFEventType("ShowPage");

  public static final EventType HidePage  = new MSFEventType("HidePage");

  public static final EventType TabChange = new MSFEventType("TabChange");

  public static final EventType LogOut    = new MSFEventType("LogOut");
  
  public static final EventType RemovePage = new MSFEventType("RemovePage");
  

}

//public class AppEvents {
//
//  public static final EventType Init = new EventType();
//
//  public static final EventType ShowPage = new EventType();
//
//  public static final EventType HidePage = new EventType();
//
//  public static final EventType TabChange = new EventType();
//	 
//  public static final EventType ShowLoginForm = new EventType();
//  public static final EventType Login = new EventType();
//  public static final EventType Logout = new EventType();
//    
//  public static final EventType MainEvent = new EventType();
//	
//  public static final EventType SetPageData = new EventType(); 
//
//}
