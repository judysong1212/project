/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;

public class MSFSimpleTrigger {
    private EventType eventType;
    private Listener<BaseEvent> listener;

    public MSFSimpleTrigger(EventType eventType, Listener<BaseEvent> listener) {
        this.eventType = eventType;
        this.listener = listener;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Listener<BaseEvent> getListener() {
        return listener;
    }

    
}
