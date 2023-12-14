/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;


public interface Login {

    public void addLoginListener(LoginListener loginListener);

    public LoginListener getLoginListener();

    public void hide();

}
