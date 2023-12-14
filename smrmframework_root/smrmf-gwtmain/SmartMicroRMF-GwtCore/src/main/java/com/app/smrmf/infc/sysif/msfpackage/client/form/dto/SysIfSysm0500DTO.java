package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;

/**
 * @Class Name : Sysm0500VO.java
 * @Description : Sysm0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0500DTO  implements Serializable { 

    private static final long serialVersionUID = 1L;
    
    
    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;


    /** set AUTH_GRP_SEIL_NUM */
    private Long authGrpSeilNum;
    

    /** set 권한그룹명 : authGrpNm */
    private java.lang.String authGrpNm;
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
 
    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;
    
    /** set 사용자권한구분 : usrDivNm */
    private java.lang.String usrDivNm;

    /** set 사용자권한사용여부 : usrAuthUseYn */
    private Boolean usrAuthUseYn;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr; 
    
    /** USR_NM */
    private java.lang.String usrNm;
     
    public SysIfSysm0500DTO() {
    	
    }

    
    public SysIfSysm0500DTO(
    	    	 String  sysDivCd  
    			, Long  authGrpSeilNum 
    			, String  authGrpNm
    			, String  usrId 
    			, String  usrNm 
    			, Boolean  usrAuthUseYn  
   		   ) { 
    	this.sysDivCd = sysDivCd; 
    	this.authGrpSeilNum = authGrpSeilNum;
    	this.authGrpNm = authGrpNm; 
    	this.usrId = usrId;
    	this.usrNm = usrNm;
    	this.usrAuthUseYn = usrAuthUseYn;
    	}


  

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthGrpNm()
	 * @brief date:2017 2017. 12. 18. user:atres
	 * @return the authGrpNm get
	 */
	public java.lang.String getAuthGrpNm() {
		return authGrpNm;
	}


	/**
	 * Comment : 
	 *@fn void setAuthGrpNm(java.lang.String authGrpNm)
	 *@brief date:2017 2017. 12. 18. user:atres
	 *@param authGrpNm the authGrpNm to set
	 */
	public void setAuthGrpNm(java.lang.String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}


	/**
	 * @return the sysDivCd
	 * @alais <한글명>
	 */
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}


	/**
	 * @param sysDivCd the sysDivCd to set
	 * @alais <한글명>
	 */
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}


	/**
	 * @return the authGrpSeilNum
	 * @alais <한글명>
	 */
	public Long getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}


	/**
	 * @param authGrpSeilNum the authGrpSeilNum to set
	 * @alais <한글명>
	 */
	public void setAuthGrpSeilNum(Long authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}


	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}


	/**
	 * Comment : 
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getUsrDivNm()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrDivNm get
	 */
	public java.lang.String getUsrDivNm() {
		return usrDivNm;
	}


	/**
	 * Comment : 
	 *@fn void setUsrDivNm(java.lang.String usrDivNm)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrDivNm the usrDivNm to set
	 */
	public void setUsrDivNm(java.lang.String usrDivNm) {
		this.usrDivNm = usrDivNm;
	}


	/**
	 * Comment : 
	 * @fn Boolean getUsrAuthUseYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrAuthUseYn get
	 */
	public Boolean getUsrAuthUseYn() {
		return usrAuthUseYn;
	}


	/**
	 * Comment : 
	 *@fn void setUsrAuthUseYn(Boolean usrAuthUseYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrAuthUseYn the usrAuthUseYn to set
	 */
	public void setUsrAuthUseYn(Boolean usrAuthUseYn) {
		this.usrAuthUseYn = usrAuthUseYn;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getKybdr()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the kybdr get
	 */
	public java.lang.String getKybdr() {
		return kybdr;
	}


	/**
	 * Comment : 
	 *@fn void setKybdr(java.lang.String kybdr)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param kybdr the kybdr to set
	 */
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}


	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}


	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}


	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}


	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getInptAddr()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the inptAddr get
	 */
	public java.lang.String getInptAddr() {
		return inptAddr;
	}


	/**
	 * Comment : 
	 *@fn void setInptAddr(java.lang.String inptAddr)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param inptAddr the inptAddr to set
	 */
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getUsrNm()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrNm get
	 */
	public java.lang.String getUsrNm() {
		return usrNm;
	}


	/**
	 * Comment : 
	 *@fn void setUsrNm(java.lang.String usrNm)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrNm the usrNm to set
	 */
	public void setUsrNm(java.lang.String usrNm) {
		this.usrNm = usrNm;
	} 
    
    
	  
    
}
