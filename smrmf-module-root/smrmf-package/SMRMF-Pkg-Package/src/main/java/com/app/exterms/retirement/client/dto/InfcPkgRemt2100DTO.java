package com.app.exterms.retirement.client.dto; 

import java.io.Serializable;

/**
 * @Class Name : Remt2100VO.java
 * @Description : Remt2100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgRemt2100DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    private java.math.BigDecimal sevePayDtlPatrNum;

    /** set 급여지급시작일자 : payPymtBgnnDt */
    private java.lang.String payPymtBgnnDt;

    /** set 급여지급종료일자 : payPymtEndDt */
    private java.lang.String payPymtEndDt;

    /** set 지급일수 : pymtNumDys */
    private java.math.BigDecimal pymtNumDys;

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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getCalcSevePayPsnDivCd() {
		return calcSevePayPsnDivCd;
	}

	public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
		this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
	}

	public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
	}

	public java.math.BigDecimal getSevePayDtlPatrNum() {
		return sevePayDtlPatrNum;
	}

	public void setSevePayDtlPatrNum(java.math.BigDecimal sevePayDtlPatrNum) {
		this.sevePayDtlPatrNum = sevePayDtlPatrNum;
	}

	public java.lang.String getPayPymtBgnnDt() {
		return payPymtBgnnDt;
	}

	public void setPayPymtBgnnDt(java.lang.String payPymtBgnnDt) {
		this.payPymtBgnnDt = payPymtBgnnDt;
	}

	public java.lang.String getPayPymtEndDt() {
		return payPymtEndDt;
	}

	public void setPayPymtEndDt(java.lang.String payPymtEndDt) {
		this.payPymtEndDt = payPymtEndDt;
	}

	public java.math.BigDecimal getPymtNumDys() {
		return pymtNumDys;
	}

	public void setPymtNumDys(java.math.BigDecimal pymtNumDys) {
		this.pymtNumDys = pymtNumDys;
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
