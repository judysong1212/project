package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0460VO.java
 * @Description : Payr0460 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0460VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직책_직종세코드 : odtyDtilOccuClsCd */
    private java.lang.String odtyDtilOccuClsCd;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 직책_직종세수당금액 : odtyDtilOccuClsSum */
    private java.math.BigDecimal odtyDtilOccuClsSum;

    /** set 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
    private java.lang.String odtyDtilOccuClsNoteCtnt;

    /** set 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
    private java.lang.String odtyDtilOccuClsDelYn;

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
	 * @fn java.lang.String getPayYr()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the payYr get
	 */
	public java.lang.String getPayYr() {
		return payYr;
	}

	/**
	 * Comment : 
	 *@fn void setPayYr(java.lang.String payYr)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param payYr the payYr to set
	 */
	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOdtyDtilOccuClsCd()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the odtyDtilOccuClsCd get
	 */
	public java.lang.String getOdtyDtilOccuClsCd() {
		return odtyDtilOccuClsCd;
	}

	/**
	 * Comment : 
	 *@fn void setOdtyDtilOccuClsCd(java.lang.String odtyDtilOccuClsCd)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param odtyDtilOccuClsCd the odtyDtilOccuClsCd to set
	 */
	public void setOdtyDtilOccuClsCd(java.lang.String odtyDtilOccuClsCd) {
		this.odtyDtilOccuClsCd = odtyDtilOccuClsCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayItemCd()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the payItemCd get
	 */
	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayItemCd(java.lang.String payItemCd)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param payItemCd the payItemCd to set
	 */
	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getOdtyDtilOccuClsSum()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the odtyDtilOccuClsSum get
	 */
	public java.math.BigDecimal getOdtyDtilOccuClsSum() {
		return odtyDtilOccuClsSum;
	}

	/**
	 * Comment : 
	 *@fn void setOdtyDtilOccuClsSum(java.math.BigDecimal odtyDtilOccuClsSum)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param odtyDtilOccuClsSum the odtyDtilOccuClsSum to set
	 */
	public void setOdtyDtilOccuClsSum(java.math.BigDecimal odtyDtilOccuClsSum) {
		this.odtyDtilOccuClsSum = odtyDtilOccuClsSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOdtyDtilOccuClsNoteCtnt()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the odtyDtilOccuClsNoteCtnt get
	 */
	public java.lang.String getOdtyDtilOccuClsNoteCtnt() {
		return odtyDtilOccuClsNoteCtnt;
	}

	/**
	 * Comment : 
	 *@fn void setOdtyDtilOccuClsNoteCtnt(java.lang.String odtyDtilOccuClsNoteCtnt)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param odtyDtilOccuClsNoteCtnt the odtyDtilOccuClsNoteCtnt to set
	 */
	public void setOdtyDtilOccuClsNoteCtnt(java.lang.String odtyDtilOccuClsNoteCtnt) {
		this.odtyDtilOccuClsNoteCtnt = odtyDtilOccuClsNoteCtnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOdtyDtilOccuClsDelYn()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the odtyDtilOccuClsDelYn get
	 */
	public java.lang.String getOdtyDtilOccuClsDelYn() {
		return odtyDtilOccuClsDelYn;
	}

	/**
	 * Comment : 
	 *@fn void setOdtyDtilOccuClsDelYn(java.lang.String odtyDtilOccuClsDelYn)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param odtyDtilOccuClsDelYn the odtyDtilOccuClsDelYn to set
	 */
	public void setOdtyDtilOccuClsDelYn(java.lang.String odtyDtilOccuClsDelYn) {
		this.odtyDtilOccuClsDelYn = odtyDtilOccuClsDelYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getKybdr()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the kybdr get
	 */
	public java.lang.String getKybdr() {
		return kybdr;
	}

	/**
	 * Comment : 
	 *@fn void setKybdr(java.lang.String kybdr)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param kybdr the kybdr to set
	 */
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}

	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptAddr()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the inptAddr get
	 */
	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	/**
	 * Comment : 
	 *@fn void setInptAddr(java.lang.String inptAddr)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param inptAddr the inptAddr to set
	 */
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}

	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 5. 18. user:atres
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 5. 18. user:atres
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

      
    
}
