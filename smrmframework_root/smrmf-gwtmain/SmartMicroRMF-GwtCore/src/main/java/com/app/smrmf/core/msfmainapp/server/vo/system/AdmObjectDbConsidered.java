/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.vo.system;

// Generated 18-mag-2010 14.14.14 by Hibernate Tools 3.2.5.Beta

/**
 * AdmObjectDbConsidered generated by hbm2java
 */
public class AdmObjectDbConsidered implements java.io.Serializable {

    private String objectName;
    private String objectType;

    public AdmObjectDbConsidered() {
    }

    public AdmObjectDbConsidered(String objectName, String objectType) {
        this.objectName = objectName;
        this.objectType = objectType;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

}
