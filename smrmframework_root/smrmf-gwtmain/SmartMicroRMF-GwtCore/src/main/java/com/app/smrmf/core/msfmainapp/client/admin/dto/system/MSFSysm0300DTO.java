/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto.system;


import com.google.gwt.user.client.rpc.IsSerializable;


public class MSFSysm0300DTO implements IsSerializable {

	  /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** AUTH_GRP_SEIL_NUM */
    private Long authGrpSeilNum;
    
    /** BUSIN_DIV_CD */
    private java.lang.String businDivCd;
    
    /** AUTH_GRP_NM */
    private java.lang.String authGrpNm;
    
    /** GRDE */
    private java.lang.String grde;
    
    /** AUTH_GRP_USE_YN */
    private java.lang.String authGrpUseYn;
    
    /** GRP_EPLN */
    private java.lang.String grpEpln;

    public MSFSysm0300DTO() {
    	
    }

    public MSFSysm0300DTO(
                String sysDivCd
              , Long authGrpSeilNum
    		  , String businDivCd
	          , String authGrpNm
	          , String grde
	          , String authGrpUseYn
	          , String grpEpln) {
        this.sysDivCd = sysDivCd;
    	this.authGrpSeilNum = authGrpSeilNum;
		this.businDivCd = businDivCd;
		this.authGrpNm = authGrpNm;
		this.grde = grde;
		this.authGrpUseYn = authGrpUseYn;
		this.grpEpln = grpEpln; 
    }

    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public Long getAuthGrpSeilNum() {
        return this.authGrpSeilNum;
    }
    
    public void setAuthGrpSeilNum(Long authGrpSeilNum) {
        this.authGrpSeilNum = authGrpSeilNum;
    }
    
    public java.lang.String getBusinDivCd() {
        return this.businDivCd;
    }
    
    public void setBusinDivCd(java.lang.String businDivCd) {
        this.businDivCd = businDivCd;
    }
    
    public java.lang.String getAuthGrpNm() {
        return this.authGrpNm;
    }
    
    public void setAuthGrpNm(java.lang.String authGrpNm) {
        this.authGrpNm = authGrpNm;
    }
    
    public java.lang.String getGrde() {
        return this.grde;
    }
    
    public void setGrde(java.lang.String grde) {
        this.grde = grde;
    }
    
    public java.lang.String getAuthGrpUseYn() {
        return this.authGrpUseYn;
    }
    
    public void setAuthGrpUseYn(java.lang.String authGrpUseYn) {
        this.authGrpUseYn = authGrpUseYn;
    }
    
    public java.lang.String getGrpEpln() {
        return this.grpEpln;
    }
    
    public void setGrpEpln(java.lang.String grpEpln) {
        this.grpEpln = grpEpln;
    }
    

}
