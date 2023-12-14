/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.languages;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {

    String CodeApp();
    String MsgBenvenuto();
    String MsgLogin();

    @DefaultStringValue("&copy;2015 - PAYGEN APP. - ver. 1.0")
    String Copyright();

    @DefaultStringValue("kr,de,en,fr")
    String ShownLanguages();

}
