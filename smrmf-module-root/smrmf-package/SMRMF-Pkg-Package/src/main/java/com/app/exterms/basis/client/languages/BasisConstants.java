/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.languages;

import com.google.gwt.core.client.GWT;

public interface BasisConstants extends BasisComConstants {
    
    public static final BasisConstants INSTANCE = (BasisConstants) GWT.create(BasisConstants.class);

    //Window titles
    String title_Bass0100();
    String title_Bass0120();
    String title_Bass0150();
    String title_Bass0200();
    String title_Bass0300();
    String title_Bass0350();
    String title_Bass0400();
    String title_Bass0500();
    String title_Bass0600();
     
    //Labels
    // String lbl_Id();

    String title_Bass5510();
    String title_Bass0440BassYr();
    String title_Bass0415BassYr();
   
    /*급여수당관리*/
    String title_Bass5530();
    
    /*급여공제관리*/
    String title_Bass5540();
}
