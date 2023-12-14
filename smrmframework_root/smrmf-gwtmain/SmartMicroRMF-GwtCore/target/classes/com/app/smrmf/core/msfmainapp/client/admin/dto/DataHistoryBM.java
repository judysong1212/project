/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.util.Date;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DataHistoryBM extends BaseModel implements IsSerializable{

    private static final long serialVersionUID = 1L;

    public DataHistoryBM() {
    }

    public DataHistoryBM(
            Long id,
            MSFSysm0100BM user,
            Date datetime,
            String activityOnDb,
            String tableName,
            String clsName,
            Object dataStored,
            String primaryKey) {
        set("id",           id);
        set("user",         user);
        set("datetime",     datetime);
        set("activityOnDb", activityOnDb);
        set("tableName",    tableName);
        set("clsName",     clsName);
        set("dataStored",   dataStored);
        set("primaryKey",   primaryKey);
    }

    public String getCognomeNome() {
        return get("cognomeNome");
    }

    public Long getId() {
        return get("id");
    }

    public void setId(Long id) {
        set("id", id);
    }

    public String getUsername() {
        return get("username");
    }

    public String getPassword() {
        return get("pwd");
    }

    public String getEmail() {
        return get("email");
    }

    public String getCognome() {
        return get("cognome");
    }

    public String getNome() {
        return get("nome");
    }

    public String getTitolo() {
        return get("titolo");
    }

}
