/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysauth.systemmtr.client.languages;

import com.google.gwt.core.client.GWT;

public interface SysmMtrConstants extends SysmMtrComConstants {
    
    public static  SysmMtrConstants INSTANCE = (SysmMtrConstants) GWT.create(SysmMtrConstants.class);

    //Window titles
    String title_Sysm0100();
    String title_SysmMtr0200(); 
    String title_SysmMtr0300(); 
    
    String title_Sysm0400();
    String title_Sysm0500(); 
    
    String title_Cmmn0310();
    String title_Cmmn0320();
    
   
     
    //Labels
   // String lbl_Id();
   
}
