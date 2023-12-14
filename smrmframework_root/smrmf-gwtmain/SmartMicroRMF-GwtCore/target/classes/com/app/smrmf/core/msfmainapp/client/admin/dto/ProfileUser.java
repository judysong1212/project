/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;
 
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ProfileUser implements IsSerializable{
    private BigDecimal id;
    private String usrId;
    private BigDecimal profileId;
    private String profile;
    private Boolean sino;

    public ProfileUser() {
    }

    public ProfileUser(BigDecimal id, String usrId, BigDecimal profileId, String profile,
            Boolean sino) {
        this.id = id;
        this.usrId = usrId;
        this.profileId = profileId;
        this.profile = profile;
        this.sino = sino;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public BigDecimal getProfileId() {
        return profileId;
    }

    public void setProfileId(BigDecimal profileId) {
        this.profileId = profileId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Boolean getSino() {
        return sino;
    }

    public void setSino(Boolean sino) {
        this.sino = sino;
    }



}
