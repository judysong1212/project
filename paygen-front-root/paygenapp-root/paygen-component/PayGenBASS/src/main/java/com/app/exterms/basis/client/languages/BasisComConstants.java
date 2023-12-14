/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.languages;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.Constants.DefaultStringValue;

public interface BasisComConstants extends Constants {

//    public static final BasisComConstants INSTANCE = (BasisComConstants) GWT.create(BasisComConstants.class);

    /*
     * List of all titles
     */

    @DefaultStringValue("Countries")
    String titleCountries();
  
    @DefaultStringValue("근로소득간이세액표")   
	String titleBass5510();
    
    /*
     * List of all labels
     */
//    @DefaultStringValue("Employee Id")
//    String employeeId();
     
    @DefaultStringValue("급여수당")     
	String titleBass5530();	
    
    @DefaultStringValue("급여공제")    
	String titleBass5540();
}
