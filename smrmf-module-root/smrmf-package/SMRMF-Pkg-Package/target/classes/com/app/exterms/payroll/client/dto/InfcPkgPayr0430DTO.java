package com.app.exterms.payroll.client.dto;

import java.io.Serializable; 

/**
 * @Class Name : Payr0304VO.java
 * @Description : Payr0304 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0430DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    private java.lang.String pyspLogSvcYrNumCd;

    /** set 근속년수_이상 : logSvcYrNumOvr */
    private java.math.BigDecimal logSvcYrNumOvr;

    /** set 근속년수_미만 : logSvcYrNumUdr */
    private java.math.BigDecimal logSvcYrNumUdr;

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

	public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
		return typOccuGrdeMppgSeilNum;
	}

	public void setTypOccuGrdeMppgSeilNum(
			java.math.BigDecimal typOccuGrdeMppgSeilNum) {
		this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
	}

	public java.lang.String getPyspLogSvcYrNumCd() {
		return pyspLogSvcYrNumCd;
	}

	public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
		this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
	}

	public java.math.BigDecimal getLogSvcYrNumOvr() {
		return logSvcYrNumOvr;
	}

	public void setLogSvcYrNumOvr(java.math.BigDecimal logSvcYrNumOvr) {
		this.logSvcYrNumOvr = logSvcYrNumOvr;
	}

	public java.math.BigDecimal getLogSvcYrNumUdr() {
		return logSvcYrNumUdr;
	}

	public void setLogSvcYrNumUdr(java.math.BigDecimal logSvcYrNumUdr) {
		this.logSvcYrNumUdr = logSvcYrNumUdr;
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
