/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class MSFAsyncCallback<T> implements AsyncCallback<T> {

    protected MSFServiceFailureHandler failureHandler;

    public MSFAsyncCallback() {
        this(null, null);
    }
    public MSFAsyncCallback(LayoutContainer container) {
        this(container, null);
    }
    public MSFAsyncCallback(LayoutContainer container, String activity) {
        this(container, null, null);
    }
    public MSFAsyncCallback(LayoutContainer container, String activity, ActionDatabase actionDatabase) {
        failureHandler = new MSFServiceFailureHandler(container, activity, actionDatabase);
    }

    public void onFailure(Throwable caught) {
        failureHandler.handleServiceFailure(caught);
    }
}
