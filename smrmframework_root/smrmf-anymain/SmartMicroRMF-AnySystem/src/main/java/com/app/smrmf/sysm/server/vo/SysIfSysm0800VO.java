package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysm0800VO.java
 * @Description : Sysm0800 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0800VO  implements Serializable { 
	
    private static final long serialVersionUID = 1L;
    
    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;
    
    /** set 시스템구분 : sysDivNm */
    private java.lang.String sysDivNm;

    /** set 권한그룹일련번호 : authGrpSeilNum */
    private Long authGrpSeilNum;


    /** set 권한그룹명 : authGrpNm */
    private java.lang.String authGrpNm;
    
    /** set 사용자권한그룹사용여부 : usrAuthGrpUseYn */
    private String usrAuthGrpUseYn;

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

     
	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivNm()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the sysDivNm get
	 */
	public java.lang.String getSysDivNm() {
		return sysDivNm;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivNm(java.lang.String sysDivNm)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param sysDivNm the sysDivNm to set
	 */
	public void setSysDivNm(java.lang.String sysDivNm) {
		this.sysDivNm = sysDivNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthGrpNm()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the authGrpNm get
	 */
	public java.lang.String getAuthGrpNm() {
		return authGrpNm;
	}

	/**
	 * Comment : 
	 *@fn void setAuthGrpNm(java.lang.String authGrpNm)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param authGrpNm the authGrpNm to set
	 */
	public void setAuthGrpNm(java.lang.String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}

	/**
	 * Comment : 사용자권한구분코드
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 사용자권한구분코드
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivCd()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the sysDivCd get
	 */
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivCd(java.lang.String sysDivCd)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param sysDivCd the sysDivCd to set
	 */
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	/**
	 * Comment : 
	 * @fn Long getAuthGrpSeilNum()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the authGrpSeilNum get
	 */
	public Long getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setAuthGrpSeilNum(Long authGrpSeilNum)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param authGrpSeilNum the authGrpSeilNum to set
	 */
	public void setAuthGrpSeilNum(Long authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	/**
	 * Comment : 
	 * @fn Boolean getUsrAuthGrpUseYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrAuthGrpUseYn get
	 */
	public String getUsrAuthGrpUseYn() {
		return usrAuthGrpUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setUsrAuthGrpUseYn(Boolean usrAuthGrpUseYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrAuthGrpUseYn the usrAuthGrpUseYn to set
	 */
	public void setUsrAuthGrpUseYn(String usrAuthGrpUseYn) {
		this.usrAuthGrpUseYn = usrAuthGrpUseYn;
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

       
     
    
}
