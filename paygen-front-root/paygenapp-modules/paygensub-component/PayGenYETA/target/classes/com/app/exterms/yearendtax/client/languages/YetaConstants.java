/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.yearendtax.client.languages;

import com.google.gwt.core.client.GWT;

public interface YetaConstants extends YetaComConstants {
    
    public static final YetaConstants INSTANCE = (YetaConstants) GWT.create(YetaConstants.class);

    //Window titles
    String title_Bugt0010();
    String title_Bugt0050();
    String title_Bugt0100();
    String title_Bugt0150();
    String title_Bugt0200();
    String title_Bugt0250();
    String title_Bugt0300(); 
    
    // 추가
    String title_Yeta7600YetaYr();
   
     
    //Labels
   // String lbl_Id();
   
}
