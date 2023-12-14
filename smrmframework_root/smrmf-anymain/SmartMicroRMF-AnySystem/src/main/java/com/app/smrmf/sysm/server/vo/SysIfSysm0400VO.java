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
 * AdmMenuProfiles -Sysm0400VO
 */
public class SysIfSysm0400VO implements java.io.Serializable { 
	
	
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** AUTH_GRP_SEIL_NUM */
    private Long authGrpSeilNum;
    
    /** MNU_CD */
    private java.lang.String mnuCd;
    
    private SysIfSysm0200VO admMenu;
    private SysIfSysm0300VO admProfiles; 
    
    
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
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
     
    
    public SysIfSysm0400VO() {
    }

    public SysIfSysm0400VO(SysIfSysm0200VO admMenu, SysIfSysm0300VO admProfiles, String mnuAuthGrPScnInptYn
    		             , String mnuAuthGrPScnRevnYn, String mnuAuthGrPScnDelYn, String mnuAuthGrPScnInqyYn, String mnuAuthGrPScnPrtYn) {
        this.admMenu = admMenu;
        this.admProfiles = admProfiles;
        this.mnuAuthGrPScnInptYn = mnuAuthGrPScnInptYn;
        this.mnuAuthGrPScnRevnYn = mnuAuthGrPScnRevnYn;
        this.mnuAuthGrPScnDelYn = mnuAuthGrPScnDelYn;
        this.mnuAuthGrPScnInqyYn = mnuAuthGrPScnInqyYn;
        this.mnuAuthGrPScnPrtYn = mnuAuthGrPScnPrtYn;
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
    
    public java.lang.String getMnuCd() {
        return this.mnuCd;
    }
    
    public void setMnuCd(java.lang.String mnuCd) {
        this.mnuCd = mnuCd;
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
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
     
   
    public SysIfSysm0200VO getAdmMenu() {
        return this.admMenu;
    }

    public void setAdmMenu(SysIfSysm0200VO admMenu) {
        this.admMenu = admMenu;
    }

    public SysIfSysm0300VO getAdmProfiles() {
        return this.admProfiles;
    }

    public void setAdmProfiles(SysIfSysm0300VO admProfiles) {
        this.admProfiles = admProfiles;
    }
  
}
