/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.languages;

import com.google.gwt.i18n.client.Messages;

public interface MSFMessages extends Messages{

    String aggiornatoCode(String codice);
    String UserNonAbbilitato(String prg);
    String FormatoNonValido();
    String PayGenApplication();
    String NoRowsAvailable();

    // Message Mask
    String LoadingData();
    String SavingData();
    String NothingToSave();
    String SomethingToSave();
    String CancelChanges();
    String OpenNewSession();
    String NoEntry(String name);
    String msgNoRecordSelected();
    String msgDeleteRecords(int nr);

    //Validation messages, see codes in MSFErrorMessage and MSFException types
    String msgExceptionOccurred(String msg);
    String msgPropertyNull(String fieldName);
    String msgPropertyTooLarge(String fieldName);
    String msgPropertyWrongType(String fieldName);
    String msgDuplicateKey(String keyValue);
    String msgNoRecordFound(String keyValue);
    String msgIdNull();
    String msgDatabaseConstraintViolation(String constraintName);
    String msgUserExpired();
    String confStampa();
    
    //Upload file
    String msgFileTooBig();
    String msgFileNotValid();
    String msgFileWriteError();
}
