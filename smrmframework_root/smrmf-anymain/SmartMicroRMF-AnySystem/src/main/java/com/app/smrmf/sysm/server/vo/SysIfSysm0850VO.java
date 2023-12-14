package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysm0850VO.java
 * @Description : Sysm0850 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0850VO  implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;

    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;

    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 사용자권한구분 : usrDivNm */
    private java.lang.String usrDivNm;
    
    /** set 메뉴코드 : mnuCd */
    private java.lang.String mnuCd;

    /** set 메뉴코드 : mnuNm */
    private java.lang.String mnuNm;
    
    /** set 메뉴권한그룹화면조회여부 : mnuAuthGrpScnInqyYn */
    private Boolean mnuAuthGrpScnInqyYn;

    /** set 메뉴권한그룹화면입력여부 : mnuAuthGrpScnInptYn */
    private Boolean mnuAuthGrpScnInptYn;

    /** set 메뉴권한그룹화면수정여부 : mnuAuthGrpScnRevnYn */
    private Boolean mnuAuthGrpScnRevnYn;

    /** set 메뉴권한그룹화면삭제여부 : mnuAuthGrpScnDelYn */
    private Boolean mnuAuthGrpScnDelYn;

    /** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrpScnPrtYn */
    private Boolean mnuAuthGrpScnPrtYn;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;

    
    
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
	 * @fn java.lang.String getMnuNm()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuNm get
	 */
	public java.lang.String getMnuNm() {
		return mnuNm;
	}

	/**
	 * Comment : 
	 *@fn void setMnuNm(java.lang.String mnuNm)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuNm the mnuNm to set
	 */
	public void setMnuNm(java.lang.String mnuNm) {
		this.mnuNm = mnuNm;
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
	 * @fn java.lang.String getMnuCd()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuCd get
	 */
	public java.lang.String getMnuCd() {
		return mnuCd;
	}

	/**
	 * Comment : 
	 *@fn void setMnuCd(java.lang.String mnuCd)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuCd the mnuCd to set
	 */
	public void setMnuCd(java.lang.String mnuCd) {
		this.mnuCd = mnuCd;
	}

	/**
	 * Comment : 
	 * @fn Boolean getMnuAuthGrpScnInqyYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuAuthGrpScnInqyYn get
	 */
	public Boolean getMnuAuthGrpScnInqyYn() {
		return mnuAuthGrpScnInqyYn;
	}

	/**
	 * Comment : 
	 *@fn void setMnuAuthGrpScnInqyYn(Boolean mnuAuthGrpScnInqyYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuAuthGrpScnInqyYn the mnuAuthGrpScnInqyYn to set
	 */
	public void setMnuAuthGrpScnInqyYn(Boolean mnuAuthGrpScnInqyYn) {
		this.mnuAuthGrpScnInqyYn = mnuAuthGrpScnInqyYn;
	}

	/**
	 * Comment : 
	 * @fn Boolean getMnuAuthGrpScnInptYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuAuthGrpScnInptYn get
	 */
	public Boolean getMnuAuthGrpScnInptYn() {
		return mnuAuthGrpScnInptYn;
	}

	/**
	 * Comment : 
	 *@fn void setMnuAuthGrpScnInptYn(Boolean mnuAuthGrpScnInptYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuAuthGrpScnInptYn the mnuAuthGrpScnInptYn to set
	 */
	public void setMnuAuthGrpScnInptYn(Boolean mnuAuthGrpScnInptYn) {
		this.mnuAuthGrpScnInptYn = mnuAuthGrpScnInptYn;
	}

	/**
	 * Comment : 
	 * @fn Boolean getMnuAuthGrpScnRevnYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuAuthGrpScnRevnYn get
	 */
	public Boolean getMnuAuthGrpScnRevnYn() {
		return mnuAuthGrpScnRevnYn;
	}

	/**
	 * Comment : 
	 *@fn void setMnuAuthGrpScnRevnYn(Boolean mnuAuthGrpScnRevnYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuAuthGrpScnRevnYn the mnuAuthGrpScnRevnYn to set
	 */
	public void setMnuAuthGrpScnRevnYn(Boolean mnuAuthGrpScnRevnYn) {
		this.mnuAuthGrpScnRevnYn = mnuAuthGrpScnRevnYn;
	}

	/**
	 * Comment : 
	 * @fn Boolean getMnuAuthGrpScnDelYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuAuthGrpScnDelYn get
	 */
	public Boolean getMnuAuthGrpScnDelYn() {
		return mnuAuthGrpScnDelYn;
	}

	/**
	 * Comment : 
	 *@fn void setMnuAuthGrpScnDelYn(Boolean mnuAuthGrpScnDelYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuAuthGrpScnDelYn the mnuAuthGrpScnDelYn to set
	 */
	public void setMnuAuthGrpScnDelYn(Boolean mnuAuthGrpScnDelYn) {
		this.mnuAuthGrpScnDelYn = mnuAuthGrpScnDelYn;
	}

	/**
	 * Comment : 
	 * @fn Boolean getMnuAuthGrpScnPrtYn()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the mnuAuthGrpScnPrtYn get
	 */
	public Boolean getMnuAuthGrpScnPrtYn() {
		return mnuAuthGrpScnPrtYn;
	}

	/**
	 * Comment : 
	 *@fn void setMnuAuthGrpScnPrtYn(Boolean mnuAuthGrpScnPrtYn)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param mnuAuthGrpScnPrtYn the mnuAuthGrpScnPrtYn to set
	 */
	public void setMnuAuthGrpScnPrtYn(Boolean mnuAuthGrpScnPrtYn) {
		this.mnuAuthGrpScnPrtYn = mnuAuthGrpScnPrtYn;
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

     
     
    
}
