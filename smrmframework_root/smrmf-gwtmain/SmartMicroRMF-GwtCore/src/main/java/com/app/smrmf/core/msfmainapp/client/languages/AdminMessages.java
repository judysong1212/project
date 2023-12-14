/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.languages;

import com.google.gwt.i18n.client.Messages;

public interface AdminMessages extends Messages {	

	String aggiornatoCode(String codice);
	String UserNonAbbilitato(String prg);
	String ExceptionMessageService(String msg);
	String SaveUserException();
	String LoginDots();
	String RicordaLogin();
    String ExceptionCreatingWindow(String windowClassName);
}
