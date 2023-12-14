/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.insurance.client.languages;

import com.google.gwt.core.client.GWT;

public interface InsrConstants extends InsrComConstants {
    
    public static final InsrConstants INSTANCE = (InsrConstants) GWT.create(InsrConstants.class);

    //Window titles
    String title_Bugt0010();
    String title_Bugt0050();
    String title_Bugt0100();
    String title_Bugt0150();
    String title_Bugt0200();
    String title_Bugt0250();
    String title_Bugt0300(); 
     
    //Labels
   // String lbl_Id();
   
}