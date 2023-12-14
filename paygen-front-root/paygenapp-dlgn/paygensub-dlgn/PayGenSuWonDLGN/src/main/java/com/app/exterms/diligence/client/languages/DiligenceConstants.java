/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.diligence.client.languages;

import com.google.gwt.core.client.GWT;

public interface DiligenceConstants extends DiligenceComConstants {
    
    public static final DiligenceConstants INSTANCE = (DiligenceConstants) GWT.create(DiligenceConstants.class);

    //Window titles 
    String title_Dlgn0250(); 
     
    //Labels
   // String lbl_Id();
   
}
