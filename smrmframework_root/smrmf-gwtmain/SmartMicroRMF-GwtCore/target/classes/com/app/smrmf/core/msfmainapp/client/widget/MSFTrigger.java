/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListener;

import com.extjs.gxt.ui.client.event.EventType;

public class MSFTrigger {
    private EventType eventType;
    private ColumnDefListener listener;

    public MSFTrigger(EventType eventType, ColumnDefListener listener) {
        this.eventType = eventType;
        this.listener = listener;
    }

    public EventType getEventType() {
        return eventType;
    }

    public ColumnDefListener getListener() {
        return listener;
    }

    
}
