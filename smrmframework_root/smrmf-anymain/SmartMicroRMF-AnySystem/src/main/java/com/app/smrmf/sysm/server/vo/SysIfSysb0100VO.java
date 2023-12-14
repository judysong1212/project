package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysb0100VO.java
 * @Description : Sysb0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysb0100VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;

    /** set 사용자정보변경일시 : usrInfoChngDtntm */
    private java.lang.String usrInfoChngDtntm;

    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;

    /** set 권한부여아이디 : authId */
    private java.lang.String authId;

    /** set 사용자등록구분플래그 : usrRgstnSeptFlag */
    private java.lang.String usrRgstnSeptFlag;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사용자성명 : usrNm */
    private java.lang.String usrNm;

    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 이메일 : email */
    private java.lang.String email;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 전화번호 : phnNum */
    private java.lang.String phnNum;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 권한적용시작일자 : authApptnBgnnDt */
    private java.lang.String authApptnBgnnDt;

    /** set 권한적용종료일자 : authApptnEndDt */
    private java.lang.String authApptnEndDt;

    /** set 사용자말소일자 : usrEaueDt */
    private java.lang.String usrEaueDt;

    /** set 사용자사용여부 : usrUseYn */
    private java.lang.String usrUseYn;

    /** set 사용자권한제외여부x : usrAuthEepnYn */
    private java.lang.String usrAuthEepnYn;

    /** set 호봉제포함여부x : pyspInsnYn */
    private java.lang.String pyspInsnYn;

    /** set 비호봉제포함여부x : notPyspInsnYn */
    private java.lang.String notPyspInsnYn;

    /** set 기간제포함여부x : shttmInsnYn */
    private java.lang.String shttmInsnYn;

    /** set 복무입력처리여부 : servcInptPrcsYn */
    private java.lang.String servcInptPrcsYn;

    /** set 연말정산입력처리여부 : yrtxInptPrcsYn */
    private java.lang.String yrtxInptPrcsYn;

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
	 * @fn java.lang.String getUsrId()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrInfoChngDtntm()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrInfoChngDtntm get
	 */
	public java.lang.String getUsrInfoChngDtntm() {
		return usrInfoChngDtntm;
	}

	/**
	 * Comment : 
	 *@fn void setUsrInfoChngDtntm(java.lang.String usrInfoChngDtntm)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrInfoChngDtntm the usrInfoChngDtntm to set
	 */
	public void setUsrInfoChngDtntm(java.lang.String usrInfoChngDtntm) {
		this.usrInfoChngDtntm = usrInfoChngDtntm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the sysDivCd get
	 */
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivCd(java.lang.String sysDivCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param sysDivCd the sysDivCd to set
	 */
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthId()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the authId get
	 */
	public java.lang.String getAuthId() {
		return authId;
	}

	/**
	 * Comment : 
	 *@fn void setAuthId(java.lang.String authId)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param authId the authId to set
	 */
	public void setAuthId(java.lang.String authId) {
		this.authId = authId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrRgstnSeptFlag()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrRgstnSeptFlag get
	 */
	public java.lang.String getUsrRgstnSeptFlag() {
		return usrRgstnSeptFlag;
	}

	/**
	 * Comment : 
	 *@fn void setUsrRgstnSeptFlag(java.lang.String usrRgstnSeptFlag)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrRgstnSeptFlag the usrRgstnSeptFlag to set
	 */
	public void setUsrRgstnSeptFlag(java.lang.String usrRgstnSeptFlag) {
		this.usrRgstnSeptFlag = usrRgstnSeptFlag;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrNm()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrNm get
	 */
	public java.lang.String getUsrNm() {
		return usrNm;
	}

	/**
	 * Comment : 
	 *@fn void setUsrNm(java.lang.String usrNm)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrNm the usrNm to set
	 */
	public void setUsrNm(java.lang.String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmail()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the email get
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * Comment : 
	 *@fn void setEmail(java.lang.String email)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param email the email to set
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPhnNum()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the phnNum get
	 */
	public java.lang.String getPhnNum() {
		return phnNum;
	}

	/**
	 * Comment : 
	 *@fn void setPhnNum(java.lang.String phnNum)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param phnNum the phnNum to set
	 */
	public void setPhnNum(java.lang.String phnNum) {
		this.phnNum = phnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthApptnBgnnDt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the authApptnBgnnDt get
	 */
	public java.lang.String getAuthApptnBgnnDt() {
		return authApptnBgnnDt;
	}

	/**
	 * Comment : 
	 *@fn void setAuthApptnBgnnDt(java.lang.String authApptnBgnnDt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param authApptnBgnnDt the authApptnBgnnDt to set
	 */
	public void setAuthApptnBgnnDt(java.lang.String authApptnBgnnDt) {
		this.authApptnBgnnDt = authApptnBgnnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthApptnEndDt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the authApptnEndDt get
	 */
	public java.lang.String getAuthApptnEndDt() {
		return authApptnEndDt;
	}

	/**
	 * Comment : 
	 *@fn void setAuthApptnEndDt(java.lang.String authApptnEndDt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param authApptnEndDt the authApptnEndDt to set
	 */
	public void setAuthApptnEndDt(java.lang.String authApptnEndDt) {
		this.authApptnEndDt = authApptnEndDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrEaueDt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrEaueDt get
	 */
	public java.lang.String getUsrEaueDt() {
		return usrEaueDt;
	}

	/**
	 * Comment : 
	 *@fn void setUsrEaueDt(java.lang.String usrEaueDt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrEaueDt the usrEaueDt to set
	 */
	public void setUsrEaueDt(java.lang.String usrEaueDt) {
		this.usrEaueDt = usrEaueDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrUseYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrUseYn get
	 */
	public java.lang.String getUsrUseYn() {
		return usrUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setUsrUseYn(java.lang.String usrUseYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrUseYn the usrUseYn to set
	 */
	public void setUsrUseYn(java.lang.String usrUseYn) {
		this.usrUseYn = usrUseYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrAuthEepnYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the usrAuthEepnYn get
	 */
	public java.lang.String getUsrAuthEepnYn() {
		return usrAuthEepnYn;
	}

	/**
	 * Comment : 
	 *@fn void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param usrAuthEepnYn the usrAuthEepnYn to set
	 */
	public void setUsrAuthEepnYn(java.lang.String usrAuthEepnYn) {
		this.usrAuthEepnYn = usrAuthEepnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspInsnYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the pyspInsnYn get
	 */
	public java.lang.String getPyspInsnYn() {
		return pyspInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setPyspInsnYn(java.lang.String pyspInsnYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param pyspInsnYn the pyspInsnYn to set
	 */
	public void setPyspInsnYn(java.lang.String pyspInsnYn) {
		this.pyspInsnYn = pyspInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNotPyspInsnYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the notPyspInsnYn get
	 */
	public java.lang.String getNotPyspInsnYn() {
		return notPyspInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setNotPyspInsnYn(java.lang.String notPyspInsnYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param notPyspInsnYn the notPyspInsnYn to set
	 */
	public void setNotPyspInsnYn(java.lang.String notPyspInsnYn) {
		this.notPyspInsnYn = notPyspInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getShttmInsnYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the shttmInsnYn get
	 */
	public java.lang.String getShttmInsnYn() {
		return shttmInsnYn;
	}

	/**
	 * Comment : 
	 *@fn void setShttmInsnYn(java.lang.String shttmInsnYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param shttmInsnYn the shttmInsnYn to set
	 */
	public void setShttmInsnYn(java.lang.String shttmInsnYn) {
		this.shttmInsnYn = shttmInsnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getServcInptPrcsYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the servcInptPrcsYn get
	 */
	public java.lang.String getServcInptPrcsYn() {
		return servcInptPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setServcInptPrcsYn(java.lang.String servcInptPrcsYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param servcInptPrcsYn the servcInptPrcsYn to set
	 */
	public void setServcInptPrcsYn(java.lang.String servcInptPrcsYn) {
		this.servcInptPrcsYn = servcInptPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxInptPrcsYn()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the yrtxInptPrcsYn get
	 */
	public java.lang.String getYrtxInptPrcsYn() {
		return yrtxInptPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param yrtxInptPrcsYn the yrtxInptPrcsYn to set
	 */
	public void setYrtxInptPrcsYn(java.lang.String yrtxInptPrcsYn) {
		this.yrtxInptPrcsYn = yrtxInptPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getKybdr()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the kybdr get
	 */
	public java.lang.String getKybdr() {
		return kybdr;
	}

	/**
	 * Comment : 
	 *@fn void setKybdr(java.lang.String kybdr)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param kybdr the kybdr to set
	 */
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}

	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptAddr()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the inptAddr get
	 */
	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	/**
	 * Comment : 
	 *@fn void setInptAddr(java.lang.String inptAddr)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param inptAddr the inptAddr to set
	 */
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}

	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 11. 28. user:atres
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 11. 28. user:atres
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

     
    
}
