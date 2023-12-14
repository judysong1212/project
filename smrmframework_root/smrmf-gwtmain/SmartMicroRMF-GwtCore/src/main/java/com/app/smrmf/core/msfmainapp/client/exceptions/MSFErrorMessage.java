/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.exceptions;

import java.io.Serializable;

public class MSFErrorMessage implements Serializable {

    public static final int ERRCODE_EXCEPTION        = 0;
    public static final int ERRCODE_NULL             = 1;
    public static final int ERRCODE_TOO_LARGE        = 2;
    public static final int ERRCODE_WRONG_TYPE       = 3;
    public static final int ERRCODE_DUPLICATE_KEY    = 4;
    public static final int ERRCODE_NOT_FOUND        = 5;
    public static final int ERRCODE_ID_NULL          = 6;
    public static final int ERRCODE_CONSTR_VIOLATION = 7;
    public static final int ERRCODE_GENERIC_MSG      = 8;

    private static final long serialVersionUID = 1L;
  
    public String attributeName;
    public String attributeValue;
    public int errorCode;
    public String errorMessage;

    public MSFErrorMessage() {
    }

    public MSFErrorMessage(String attributeName, String attributeValue, int errorCode, String errorMessage) {
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return "("+attributeName+"|"+attributeValue+"|"+errorCode+"|"+errorMessage+")";
    }
}
