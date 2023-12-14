/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.service.system;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InitSysServiceAsync {
	
    public void getInitialization(AsyncCallback<String> callback);
    
}
