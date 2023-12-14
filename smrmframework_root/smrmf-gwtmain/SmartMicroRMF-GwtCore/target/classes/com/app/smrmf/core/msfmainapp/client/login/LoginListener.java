/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;

import com.google.gwt.user.client.EventListener;

public interface LoginListener extends EventListener{

	void handleLoginEvent(String utente, String password, final boolean seRicorda);

	void handleToolbarEvent();

}
