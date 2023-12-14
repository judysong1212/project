/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

 

import com.google.gwt.user.client.rpc.IsSerializable;

public class ElementoMenu implements IsSerializable{
	
	 /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** MNU_CD */
    private java.lang.String mnuCd;
    
    /** HHRK_MNU_CD */
    private java.lang.String hhrkMnuCd;
    
    /** MNU_NM */
    private java.lang.String mnuNm;
    
    /** MNU_ICN */
    private java.lang.String mnuIcn;
    
    /** MNU_TMBL */
    private java.lang.String mnuTmbl;
    
    /** MNU_AUTH_FRM_CD */
    private java.lang.String mnuAuthFrmCd;
    
    /** MNU_TIP_NM */
    private java.lang.String mnuTipNm;
    
    /** MNU_SCN_FRM_PKG_NM */
    private java.lang.String mnuScnFrmPkgNm;
    
    /** MNU_PRNT_YN */
    private java.lang.String mnuPrntYn;
    
    /** MNU_PRNT_ORD */
    private Long mnuPrntOrd;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** MNU_EPLN */
    private java.lang.String mnuEpln;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr; 

    
    /** MNU_AUTH_GR_P_SCN_INQY_YN */
    private java.lang.Boolean mnuAuthGrPScnInqyYn;
    
    /** MNU_AUTH_GR_P_SCN_INPT_YN */
    private java.lang.Boolean mnuAuthGrPScnInptYn;
    
    /** MNU_AUTH_GR_P_SCN_REVN_YN */
    private java.lang.Boolean mnuAuthGrPScnRevnYn;
    
    /** MNU_AUTH_GR_P_SCN_DEL_YN */
    private java.lang.Boolean mnuAuthGrPScnDelYn;
    
    /** MNU_AUTH_GR_P_SCN_PRT_YN */
    private java.lang.Boolean mnuAuthGrPScnPrtYn;
    

    public ElementoMenu() {

    }
 
    		  
    public ElementoMenu(String sysDivCd
    		,String mnuCd
    		,String hhrkMnuCd 
    		,String mnuNm              
    		,String mnuIcn             
    		,String mnuTmbl            
    		,String mnuAuthFrmCd       
    		,String mnuTipNm           
    		,String mnuScnFrmPkgNm     
    		,String mnuPrntYn          
    		,Long mnuPrntOrd         
    		,String useYn              
    		,String mnuEpln  
    		,Boolean mnuAuthGrPScnInptYn 
    		,Boolean mnuAuthGrPScnRevnYn
    		,Boolean mnuAuthGrPScnDelYn 
    		,Boolean mnuAuthGrPScnInqyYn
    		,Boolean mnuAuthGrPScnPrtYn ) {
    	this.sysDivCd            =  sysDivCd;
    	this.mnuCd               =  mnuCd;
    	this.hhrkMnuCd           =  hhrkMnuCd;
    	this.mnuNm               =  mnuNm;                    
    	this.mnuIcn              =  mnuIcn;              
    	this.mnuTmbl             =  mnuTmbl;             
    	this.mnuAuthFrmCd        =  mnuAuthFrmCd;        
    	this.mnuTipNm            =  mnuTipNm;            
    	this.mnuScnFrmPkgNm      =  mnuScnFrmPkgNm;      
    	this.mnuPrntYn           =  mnuPrntYn;           
    	this.mnuPrntOrd          =  mnuPrntOrd;          
    	this.useYn               =  useYn;               
    	this.mnuEpln             =  mnuEpln;   
    	this.mnuAuthGrPScnInptYn =  mnuAuthGrPScnInptYn; 
    	this.mnuAuthGrPScnRevnYn =  mnuAuthGrPScnRevnYn; 
    	this.mnuAuthGrPScnDelYn  =  mnuAuthGrPScnDelYn;  
    	this.mnuAuthGrPScnInqyYn =  mnuAuthGrPScnInqyYn; 
    	this.mnuAuthGrPScnPrtYn  =  mnuAuthGrPScnPrtYn;  
    }
    
    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.lang.String getMnuCd() {
        return this.mnuCd;
    }
    
    public void setMnuCd(java.lang.String mnuCd) {
        this.mnuCd = mnuCd;
    }
    
    public java.lang.String getHhrkMnuCd() {
        return this.hhrkMnuCd;
    }
    
    public void setHhrkMnuCd(java.lang.String hhrkMnuCd) {
        this.hhrkMnuCd = hhrkMnuCd;
    }
    
    public java.lang.String getMnuNm() {
        return this.mnuNm;
    }
    
    public void setMnuNm(java.lang.String mnuNm) {
        this.mnuNm = mnuNm;
    }
    
    public java.lang.String getMnuIcn() {
        return this.mnuIcn;
    }
    
    public void setMnuIcn(java.lang.String mnuIcn) {
        this.mnuIcn = mnuIcn;
    }
    
    public java.lang.String getMnuTmbl() {
        return this.mnuTmbl;
    }
    
    public void setMnuTmbl(java.lang.String mnuTmbl) {
        this.mnuTmbl = mnuTmbl;
    }
    
    public java.lang.String getMnuAuthFrmCd() {
        return this.mnuAuthFrmCd;
    }
    
    public void setMnuAuthFrmCd(java.lang.String mnuAuthFrmCd) {
        this.mnuAuthFrmCd = mnuAuthFrmCd;
    }
    
    public java.lang.String getMnuTipNm() {
        return this.mnuTipNm;
    }
    
    public void setMnuTipNm(java.lang.String mnuTipNm) {
        this.mnuTipNm = mnuTipNm;
    }
    
    public java.lang.String getMnuScnFrmPkgNm() {
        return this.mnuScnFrmPkgNm;
    }
    
    public void setMnuScnFrmPkgNm(java.lang.String mnuScnFrmPkgNm) {
        this.mnuScnFrmPkgNm = mnuScnFrmPkgNm;
    }
    
    public java.lang.String getMnuPrntYn() {
        return this.mnuPrntYn;
    }
    
    public void setMnuPrntYn(java.lang.String mnuPrntYn) {
        this.mnuPrntYn = mnuPrntYn;
    }
    
    public Long getMnuPrntOrd() {
        return this.mnuPrntOrd;
    }
    
    public void setMnuPrntOrd(Long mnuPrntOrd) {
        this.mnuPrntOrd = mnuPrntOrd;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    }
    
    public java.lang.String getMnuEpln() {
        return this.mnuEpln;
    }
    
    public void setMnuEpln(java.lang.String mnuEpln) {
        this.mnuEpln = mnuEpln;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.sql.Date getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.sql.Date inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.sql.Date getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.sql.Date revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    

    public java.lang.Boolean getMnuAuthGrPScnInqyYn() {
        return this.mnuAuthGrPScnInqyYn;
    }
    
    public void setMnuAuthGrPScnInqyYn(java.lang.Boolean mnuAuthGrPScnInqyYn) {
        this.mnuAuthGrPScnInqyYn = mnuAuthGrPScnInqyYn;
    }
    
    public java.lang.Boolean getMnuAuthGrPScnInptYn() {
        return this.mnuAuthGrPScnInptYn;
    }
    
    public void setMnuAuthGrPScnInptYn(java.lang.Boolean mnuAuthGrPScnInptYn) {
        this.mnuAuthGrPScnInptYn = mnuAuthGrPScnInptYn;
    }
    
    public java.lang.Boolean getMnuAuthGrPScnRevnYn() {
        return this.mnuAuthGrPScnRevnYn;
    }
    
    public void setMnuAuthGrPScnRevnYn(java.lang.Boolean mnuAuthGrPScnRevnYn) {
        this.mnuAuthGrPScnRevnYn = mnuAuthGrPScnRevnYn;
    }
    
    public java.lang.Boolean getMnuAuthGrPScnDelYn() {
        return this.mnuAuthGrPScnDelYn;
    }
    
    public void setMnuAuthGrPScnDelYn(java.lang.Boolean mnuAuthGrPScnDelYn) {
        this.mnuAuthGrPScnDelYn = mnuAuthGrPScnDelYn;
    }
    
    public java.lang.Boolean getMnuAuthGrPScnPrtYn() {
        return this.mnuAuthGrPScnPrtYn;
    }
    
    public void setMnuAuthGrPScnPrtYn(java.lang.Boolean mnuAuthGrPScnPrtYn) {
        this.mnuAuthGrPScnPrtYn = mnuAuthGrPScnPrtYn;
    }   

}
