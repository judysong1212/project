/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

 

import java.math.BigDecimal;

import com.extjs.gxt.ui.client.data.BaseModel;

public class VoceMenuProfile extends BaseModel {

    private static final long serialVersionUID = 1L;

    public VoceMenuProfile() {
    }

    public VoceMenuProfile(String mnuCd, String idMnu, BigDecimal idPrf, String title, String category,
            Boolean siNo, Boolean seInsert, Boolean seUpdate,
            Boolean seDelete) {
        set("mnuCd", mnuCd);
        set("idMnu", idMnu);
        set("idPrf", idPrf);
        set("name", title);
        set("category", category);
        set("siNo", siNo);
        set("seInsert", seInsert);
        set("seUpdate", seUpdate);
        set("seDelete", seDelete);
    }

    public String getMnuCd() {
        return get("mnuCd");
    }

    public void setMnuCd(String mnuCd) {
        set("mnuCd", mnuCd);
    }

    public String getIdMnu() {
        return get("idMnu");
    }

    public void setIdMnu(String idMnu) {
        set("idMnu", idMnu);
    }

    public String getTitle() {
        return get("name");
    }

    public void setTitle(String title) {
        set("name", title);
    }

    public String getCategory() {
        return get("category");
    }

    public void setCategory(String category) {
        set("category", category);
    }

    public Boolean getSiNo() {
        return get("siNo");
    }

    public void setSiNo(Boolean siNo) {
        set("siNo", siNo);
    }

    public Boolean getSeInsert() {
        return get("seInsert");
    }

    public void setSeInsert(Boolean seInsert) {
        set("seInsert", seInsert);
    }

    public Boolean getSeUpdate() {
        return get("seUpdate");
    }

    public void setSeUpdate(Boolean seUpdate) {
        set("seUpdate", seUpdate);
    }

    public Boolean getSeDelete() {
        return get("seDelete");
    }

    public void setSeDelete(Boolean seDelete) {
        set("seDelete", seDelete);
    }

    public BigDecimal getIdPrf() {
        return (BigDecimal)get("idPrf");
    }

    public void setIdPrf(BigDecimal idPrf) {
        set("idPrf", idPrf);
    }



}
