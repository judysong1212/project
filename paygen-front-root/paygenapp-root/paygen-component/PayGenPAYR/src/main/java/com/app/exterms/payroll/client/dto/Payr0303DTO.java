package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0303VO.java
 * @Description : Payr0303 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0303DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 소급년도 : reattyYr */
    private java.lang.String reattyYr;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    private java.lang.String reattyStpDsptyNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 이전지급공제금액 : bfrPymtDducSum */
    private java.math.BigDecimal bfrPymtDducSum;

    /** set 근태일_시간수 : dilnlazDutyTmDys */
    private java.lang.String dilnlazDutyTmDys;

    /** set 지급공제금액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 소급지급공제차액 : reattyPymtDducSrd */
    private java.math.BigDecimal reattyPymtDducSrd;

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    private java.math.BigDecimal pymtDducTxtnAmnt;

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    private java.math.BigDecimal pymtDducFreeDtySum;

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

    
    
    
	public java.lang.String getDilnlazDutyTmDys() {
		return dilnlazDutyTmDys;
	}


	public void setDilnlazDutyTmDys(java.lang.String dilnlazDutyTmDys) {
		this.dilnlazDutyTmDys = dilnlazDutyTmDys;
	}


	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}


	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}


	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getReattyYr() {
		return reattyYr;
	}

	public void setReattyYr(java.lang.String reattyYr) {
		this.reattyYr = reattyYr;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getReattyStpDsptyNum() {
		return reattyStpDsptyNum;
	}

	public void setReattyStpDsptyNum(java.lang.String reattyStpDsptyNum) {
		this.reattyStpDsptyNum = reattyStpDsptyNum;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public java.math.BigDecimal getBfrPymtDducSum() {
		return bfrPymtDducSum;
	}

	public void setBfrPymtDducSum(java.math.BigDecimal bfrPymtDducSum) {
		this.bfrPymtDducSum = bfrPymtDducSum;
	}

	public java.math.BigDecimal getPymtDducSum() {
		return pymtDducSum;
	}

	public void setPymtDducSum(java.math.BigDecimal pymtDducSum) {
		this.pymtDducSum = pymtDducSum;
	}

	public java.math.BigDecimal getReattyPymtDducSrd() {
		return reattyPymtDducSrd;
	}

	public void setReattyPymtDducSrd(java.math.BigDecimal reattyPymtDducSrd) {
		this.reattyPymtDducSrd = reattyPymtDducSrd;
	}

	public java.math.BigDecimal getPymtDducTxtnAmnt() {
		return pymtDducTxtnAmnt;
	}

	public void setPymtDducTxtnAmnt(java.math.BigDecimal pymtDducTxtnAmnt) {
		this.pymtDducTxtnAmnt = pymtDducTxtnAmnt;
	}

	public java.math.BigDecimal getPymtDducFreeDtySum() {
		return pymtDducFreeDtySum;
	}

	public void setPymtDducFreeDtySum(java.math.BigDecimal pymtDducFreeDtySum) {
		this.pymtDducFreeDtySum = pymtDducFreeDtySum;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}
    
    
    
}
