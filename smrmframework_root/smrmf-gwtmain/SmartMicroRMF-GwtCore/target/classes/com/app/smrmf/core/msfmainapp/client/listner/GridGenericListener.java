/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.listner;

import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.EventListener;

public interface GridGenericListener extends EventListener{

	void handleButtonEvent(ActionDatabase actionDatabase);

    void onDoubleClickOnRecord(BaseModel record);

}
