/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysm.server.vo;


// Generated 18-mag-2010 14.14.14 by Hibernate Tools 3.2.5.Beta

/**
 * AdmMenuUser generated by hbm2java
 */
public class SysIfSysm0250VO implements java.io.Serializable {

	private String SysDivCd;
 

	private String mnuCd;
    private SysIfSysm0200VO admMenu;
    private SysIfSysm0100VO admUser;
    /** MNU_AUTH_GR_P_SCN_INPT_YN */
    private java.lang.String mnuAuthGrPScnInptYn;
    
    /** MNU_AUTH_GR_P_SCN_REVN_YN */
    private java.lang.String mnuAuthGrPScnRevnYn;
    
    /** MNU_AUTH_GR_P_SCN_DEL_YN */
    private java.lang.String mnuAuthGrPScnDelYn;
    
    /** MNU_AUTH_GR_P_SCN_INQY_YN */
    private java.lang.String mnuAuthGrPScnInqyYn;
    
    /** MNU_AUTH_GR_P_SCN_PRT_YN */
    private java.lang.String mnuAuthGrPScnPrtYn;
    

    public SysIfSysm0250VO() {
    }

    public SysIfSysm0250VO(SysIfSysm0200VO admMenu, SysIfSysm0100VO admUser, String mnuAuthGrPScnInptYn
            , String mnuAuthGrPScnRevnYn, String mnuAuthGrPScnDelYn, String mnuAuthGrPScnInqyYn, String mnuAuthGrPScnPrtYn) {
        this.admMenu = admMenu;
        this.admUser = admUser;
        this.mnuAuthGrPScnInptYn = mnuAuthGrPScnInptYn;
        this.mnuAuthGrPScnRevnYn = mnuAuthGrPScnRevnYn;
        this.mnuAuthGrPScnDelYn = mnuAuthGrPScnDelYn;
        this.mnuAuthGrPScnInqyYn = mnuAuthGrPScnInqyYn;
        this.mnuAuthGrPScnPrtYn = mnuAuthGrPScnPrtYn;
    }
    
    public String getSysDivCd() {
 		return SysDivCd;
 	}

 	public void setSysDivCd(String sysDivCd) {
 		SysDivCd = sysDivCd;
 	}

    public String getMnuCd() {
        return this.mnuCd;
    }

    public void setMnuCd(String mnuCd) {
        this.mnuCd = mnuCd;
    }

    public SysIfSysm0200VO getAdmMenu() {
        return this.admMenu;
    }

    public void setAdmMenu(SysIfSysm0200VO admMenu) {
        this.admMenu = admMenu;
    }

    public SysIfSysm0100VO getAdmUser() {
        return this.admUser;
    }

    public void setAdmUser(SysIfSysm0100VO admUser) {
        this.admUser = admUser;
    }

    public java.lang.String getMnuAuthGrPScnInqyYn() {
        return this.mnuAuthGrPScnInqyYn;
    }
    
    public void setMnuAuthGrPScnInqyYn(java.lang.String mnuAuthGrPScnInqyYn) {
        this.mnuAuthGrPScnInqyYn = mnuAuthGrPScnInqyYn;
    }
    
    public java.lang.String getMnuAuthGrPScnInptYn() {
        return this.mnuAuthGrPScnInptYn;
    }
    
    public void setMnuAuthGrPScnInptYn(java.lang.String mnuAuthGrPScnInptYn) {
        this.mnuAuthGrPScnInptYn = mnuAuthGrPScnInptYn;
    }
    
    public java.lang.String getMnuAuthGrPScnRevnYn() {
        return this.mnuAuthGrPScnRevnYn;
    }
    
    public void setMnuAuthGrPScnRevnYn(java.lang.String mnuAuthGrPScnRevnYn) {
        this.mnuAuthGrPScnRevnYn = mnuAuthGrPScnRevnYn;
    }
    
    public java.lang.String getMnuAuthGrPScnDelYn() {
        return this.mnuAuthGrPScnDelYn;
    }
    
    public void setMnuAuthGrPScnDelYn(java.lang.String mnuAuthGrPScnDelYn) {
        this.mnuAuthGrPScnDelYn = mnuAuthGrPScnDelYn;
    }
    
    public java.lang.String getMnuAuthGrPScnPrtYn() {
        return this.mnuAuthGrPScnPrtYn;
    }
    
    public void setMnuAuthGrPScnPrtYn(java.lang.String mnuAuthGrPScnPrtYn) {
        this.mnuAuthGrPScnPrtYn = mnuAuthGrPScnPrtYn;
    }

}