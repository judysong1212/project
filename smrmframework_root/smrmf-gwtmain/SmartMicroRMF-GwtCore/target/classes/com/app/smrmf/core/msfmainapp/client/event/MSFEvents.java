/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.event;

import com.extjs.gxt.ui.client.event.EventType;

/**
 * Defines the MicroSmartFramework event types.
 */
public class MSFEvents {

    public static final EventType ActivityOnGenericObjects = new EventType();
    
    public static final EventType BindLovRecord = new EventType();
    
    public static final EventType BindComboRecord = new EventType();
    
    /**
     * Questi eventi sono utilizzati in MSFGridPanel sui vari ActionButton
     */
    public static final EventType preClickOnInsertButton = new EventType();
    public static final EventType preClickOnUpdateButton = new EventType();
    public static final EventType preClickOnDeleteButton = new EventType();
    public static final EventType preClickOnCustomButton = new EventType();

    public static final EventType dataBindedIntoForm     = new EventType();

    public static final EventType dataReadInColumnDef    = new EventType();
    
    public static final EventType dataReadInLiveGrid     = new EventType();

}
