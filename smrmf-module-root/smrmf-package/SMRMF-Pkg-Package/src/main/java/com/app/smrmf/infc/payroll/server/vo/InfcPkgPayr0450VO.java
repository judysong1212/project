package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0450VO.java
 * @Description : Payr0450 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0450VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 항목수당일련번호 : payPymtItemListSeilNum */
    private java.math.BigDecimal payPymtItemListSeilNum;

    /** set 항목수당구분코드 : itemExtpyDivCd */
    private java.lang.String itemExtpyDivCd;

    /** set 시작년수 : styrNum */
    private java.lang.String styrNum;

    /** set 종료년수 : edyrNum */
    private java.lang.String edyrNum;

    /** set 지급공제율 : pymtDducRate */
    private java.math.BigDecimal pymtDducRate;

    /** set 지급공제금액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 항목별수당삭제여부 : itemListExtpyDelYn */
    private java.lang.String itemListExtpyDelYn;

    /** set 항목별수당비고내용 : rmak */
    private java.lang.String rmak;

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

    /** set 추가가산금액 : addPymtDducSum */
    private java.math.BigDecimal addPymtDducSum;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

     
    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;


	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}


	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getPayYr()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the payYr get
	 */
	public java.lang.String getPayYr() {
		return payYr;
	}


	/**
	 * Comment : 
	 *@fn void setPayYr(java.lang.String payYr)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param payYr the payYr to set
	 */
	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getPayItemCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the payItemCd get
	 */
	public java.lang.String getPayItemCd() {
		return payItemCd;
	}


	/**
	 * Comment : 
	 *@fn void setPayItemCd(java.lang.String payItemCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param payItemCd the payItemCd to set
	 */
	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}


	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPayPymtItemListSeilNum()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the payPymtItemListSeilNum get
	 */
	public java.math.BigDecimal getPayPymtItemListSeilNum() {
		return payPymtItemListSeilNum;
	}


	/**
	 * Comment : 
	 *@fn void setPayPymtItemListSeilNum(java.math.BigDecimal payPymtItemListSeilNum)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param payPymtItemListSeilNum the payPymtItemListSeilNum to set
	 */
	public void setPayPymtItemListSeilNum(
			java.math.BigDecimal payPymtItemListSeilNum) {
		this.payPymtItemListSeilNum = payPymtItemListSeilNum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getItemExtpyDivCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the itemExtpyDivCd get
	 */
	public java.lang.String getItemExtpyDivCd() {
		return itemExtpyDivCd;
	}


	/**
	 * Comment : 
	 *@fn void setItemExtpyDivCd(java.lang.String itemExtpyDivCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param itemExtpyDivCd the itemExtpyDivCd to set
	 */
	public void setItemExtpyDivCd(java.lang.String itemExtpyDivCd) {
		this.itemExtpyDivCd = itemExtpyDivCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getStyrNum()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the styrNum get
	 */
	public java.lang.String getStyrNum() {
		return styrNum;
	}


	/**
	 * Comment : 
	 *@fn void setStyrNum(java.lang.String styrNum)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param styrNum the styrNum to set
	 */
	public void setStyrNum(java.lang.String styrNum) {
		this.styrNum = styrNum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getEdyrNum()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the edyrNum get
	 */
	public java.lang.String getEdyrNum() {
		return edyrNum;
	}


	/**
	 * Comment : 
	 *@fn void setEdyrNum(java.lang.String edyrNum)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param edyrNum the edyrNum to set
	 */
	public void setEdyrNum(java.lang.String edyrNum) {
		this.edyrNum = edyrNum;
	}


	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPymtDducRate()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the pymtDducRate get
	 */
	public java.math.BigDecimal getPymtDducRate() {
		return pymtDducRate;
	}


	/**
	 * Comment : 
	 *@fn void setPymtDducRate(java.math.BigDecimal pymtDducRate)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param pymtDducRate the pymtDducRate to set
	 */
	public void setPymtDducRate(java.math.BigDecimal pymtDducRate) {
		this.pymtDducRate = pymtDducRate;
	}


	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPymtDducSum()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the pymtDducSum get
	 */
	public java.math.BigDecimal getPymtDducSum() {
		return pymtDducSum;
	}


	/**
	 * Comment : 
	 *@fn void setPymtDducSum(java.math.BigDecimal pymtDducSum)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param pymtDducSum the pymtDducSum to set
	 */
	public void setPymtDducSum(java.math.BigDecimal pymtDducSum) {
		this.pymtDducSum = pymtDducSum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getItemListExtpyDelYn()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the itemListExtpyDelYn get
	 */
	public java.lang.String getItemListExtpyDelYn() {
		return itemListExtpyDelYn;
	}


	/**
	 * Comment : 
	 *@fn void setItemListExtpyDelYn(java.lang.String itemListExtpyDelYn)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param itemListExtpyDelYn the itemListExtpyDelYn to set
	 */
	public void setItemListExtpyDelYn(java.lang.String itemListExtpyDelYn) {
		this.itemListExtpyDelYn = itemListExtpyDelYn;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getRmak()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the rmak get
	 */
	public java.lang.String getRmak() {
		return rmak;
	}


	/**
	 * Comment : 
	 *@fn void setRmak(java.lang.String rmak)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param rmak the rmak to set
	 */
	public void setRmak(java.lang.String rmak) {
		this.rmak = rmak;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getKybdr()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the kybdr get
	 */
	public java.lang.String getKybdr() {
		return kybdr;
	}


	/**
	 * Comment : 
	 *@fn void setKybdr(java.lang.String kybdr)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param kybdr the kybdr to set
	 */
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}


	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getInptAddr()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the inptAddr get
	 */
	public java.lang.String getInptAddr() {
		return inptAddr;
	}


	/**
	 * Comment : 
	 *@fn void setInptAddr(java.lang.String inptAddr)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param inptAddr the inptAddr to set
	 */
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}


	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}


	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}


	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}


	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getAddPymtDducSum()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the addPymtDducSum get
	 */
	public java.math.BigDecimal getAddPymtDducSum() {
		return addPymtDducSum;
	}


	/**
	 * Comment : 
	 *@fn void setAddPymtDducSum(java.math.BigDecimal addPymtDducSum)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param addPymtDducSum the addPymtDducSum to set
	 */
	public void setAddPymtDducSum(java.math.BigDecimal addPymtDducSum) {
		this.addPymtDducSum = addPymtDducSum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}


	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}


	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getLogSvcYrNumCd()
	 * @brief date:2017 2017. 5. 19. user:atres
	 * @return the logSvcYrNumCd get
	 */
	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}


	/**
	 * Comment : 
	 *@fn void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd)
	 *@brief date:2017 2017. 5. 19. user:atres
	 *@param logSvcYrNumCd the logSvcYrNumCd to set
	 */
	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}
 
    
}
