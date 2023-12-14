/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.extjs.gxt.ui.client.event.EventType;

public class MSFEventType extends EventType {

    private static final long serialVersionUID = 1L;

    protected String eventName;

    public MSFEventType(String eventName, int eventCode) {
        super(eventCode);
        this.eventName = eventName;
    }

    public MSFEventType(String eventName) {
        super();
        this.eventName = eventName;
    }

    public String toString() {
        return this.eventName;
    }
}
