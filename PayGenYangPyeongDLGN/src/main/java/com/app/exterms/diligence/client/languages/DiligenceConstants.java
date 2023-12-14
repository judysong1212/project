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
    
    @DefaultStringValue("")		// 신규 지자체로 따로 기준일자 두지 않음.	
    String dt_Bungi_Dlgn();

     
    //Labels
   // String lbl_Id();
   
}
