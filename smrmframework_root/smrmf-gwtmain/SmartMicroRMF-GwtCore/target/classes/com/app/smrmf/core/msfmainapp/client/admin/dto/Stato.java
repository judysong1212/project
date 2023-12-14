/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Stato implements IsSerializable{

    private Long id;
    private String description;
    private String icon;
    private String applicazione;

    public Stato() {

    }

    public Stato(Long id, String description, String icon,
            String applicazione) {
        this.id = id;
        this.description = description;
        this.icon = icon;
        this.applicazione = applicazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getApplicazione() {
        return applicazione;
    }

    public void setApplicazione(String applicazione) {
        this.applicazione = applicazione;
    }



}
