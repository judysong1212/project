/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.retirement.client.languages;

import com.google.gwt.core.client.GWT;

public interface RemtConstants extends RemtComConstants {
    
    public static final RemtConstants INSTANCE = (RemtConstants) GWT.create(RemtConstants.class);

    //Window titles
    String title_Remt0050(); 
    String title_Remt0100(); 
    String title_Remt0200(); 
    String title_Remt0300(); 
    String title_Remt0400(); 
     
    //Labels
   // String lbl_Id();
   
}
