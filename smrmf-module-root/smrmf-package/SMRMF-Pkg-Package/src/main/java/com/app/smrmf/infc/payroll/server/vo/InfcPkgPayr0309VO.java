package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0309VO.java
 * @Description : Payr0309 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.07.02
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0309VO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여일련번호 : payrSeilNum */
    private java.math.BigDecimal payrSeilNum;

    /** set 건강보험변동일자 : hlthInsurFlucDt */
    private java.lang.String hlthInsurFlucDt;

    /** set 건강보험보수총액 : hlthInsrPayTotAmnt */
    private java.math.BigDecimal hlthInsrPayTotAmnt;

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    private java.math.BigDecimal hlthInsrMnthRuntnAmnt;

    /** set 건강보험등급 : hlthInsrGrde */
    private java.lang.String hlthInsrGrde;

    /** set 건강보험증번호 : hlthInsrCertNum */
    private java.lang.String hlthInsrCertNum;

    /** set 국민연금변동일자 : natPennInsurFlucDt */
    private java.lang.String natPennInsurFlucDt;

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    private java.math.BigDecimal natPennStdIncmMnthAmnt;

    /** set 국민연금등급 : natPennGrde */
    private java.lang.String natPennGrde;

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    private java.lang.String hlthInsrApptnYn;

    /** set 국민연금적용여부 : natPennApptnYn */
    private java.lang.String natPennApptnYn;

    /** set 고용보험적용여부 : umytInsrApptnYn */
    private java.lang.String umytInsrApptnYn;

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    private java.lang.String idtlAccdtInsurApptnYn;

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

    /** set 고용보험변동일자 : umytInsrFlucDt */
    private java.lang.String umytInsrFlucDt;

    /** set 고용보험보수총액 : umytInsrPayTotAmnt */
    private java.math.BigDecimal umytInsrPayTotAmnt;

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    private java.math.BigDecimal umytInsrPayMnthAmnt;

    /** set 산재보험변동일자 : idtlAccdtFlucDt */
    private java.lang.String idtlAccdtFlucDt;

    /** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
    private java.math.BigDecimal idtlAccdtPayTotAmnt;

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    private java.math.BigDecimal idtlAccdtPayMnthAmnt;

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

	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.math.BigDecimal getPayrSeilNum() {
		return payrSeilNum;
	}

	public void setPayrSeilNum(java.math.BigDecimal payrSeilNum) {
		this.payrSeilNum = payrSeilNum;
	}

	public java.lang.String getHlthInsurFlucDt() {
		return hlthInsurFlucDt;
	}

	public void setHlthInsurFlucDt(java.lang.String hlthInsurFlucDt) {
		this.hlthInsurFlucDt = hlthInsurFlucDt;
	}

	public java.math.BigDecimal getHlthInsrPayTotAmnt() {
		return hlthInsrPayTotAmnt;
	}

	public void setHlthInsrPayTotAmnt(java.math.BigDecimal hlthInsrPayTotAmnt) {
		this.hlthInsrPayTotAmnt = hlthInsrPayTotAmnt;
	}

	public java.math.BigDecimal getHlthInsrMnthRuntnAmnt() {
		return hlthInsrMnthRuntnAmnt;
	}

	public void setHlthInsrMnthRuntnAmnt(java.math.BigDecimal hlthInsrMnthRuntnAmnt) {
		this.hlthInsrMnthRuntnAmnt = hlthInsrMnthRuntnAmnt;
	}

	public java.lang.String getHlthInsrGrde() {
		return hlthInsrGrde;
	}

	public void setHlthInsrGrde(java.lang.String hlthInsrGrde) {
		this.hlthInsrGrde = hlthInsrGrde;
	}

	public java.lang.String getHlthInsrCertNum() {
		return hlthInsrCertNum;
	}

	public void setHlthInsrCertNum(java.lang.String hlthInsrCertNum) {
		this.hlthInsrCertNum = hlthInsrCertNum;
	}

	public java.lang.String getNatPennInsurFlucDt() {
		return natPennInsurFlucDt;
	}

	public void setNatPennInsurFlucDt(java.lang.String natPennInsurFlucDt) {
		this.natPennInsurFlucDt = natPennInsurFlucDt;
	}

	public java.math.BigDecimal getNatPennStdIncmMnthAmnt() {
		return natPennStdIncmMnthAmnt;
	}

	public void setNatPennStdIncmMnthAmnt(
			java.math.BigDecimal natPennStdIncmMnthAmnt) {
		this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
	}

	public java.lang.String getNatPennGrde() {
		return natPennGrde;
	}

	public void setNatPennGrde(java.lang.String natPennGrde) {
		this.natPennGrde = natPennGrde;
	}

	public java.lang.String getHlthInsrApptnYn() {
		return hlthInsrApptnYn;
	}

	public void setHlthInsrApptnYn(java.lang.String hlthInsrApptnYn) {
		this.hlthInsrApptnYn = hlthInsrApptnYn;
	}

	public java.lang.String getNatPennApptnYn() {
		return natPennApptnYn;
	}

	public void setNatPennApptnYn(java.lang.String natPennApptnYn) {
		this.natPennApptnYn = natPennApptnYn;
	}

	public java.lang.String getUmytInsrApptnYn() {
		return umytInsrApptnYn;
	}

	public void setUmytInsrApptnYn(java.lang.String umytInsrApptnYn) {
		this.umytInsrApptnYn = umytInsrApptnYn;
	}

	public java.lang.String getIdtlAccdtInsurApptnYn() {
		return idtlAccdtInsurApptnYn;
	}

	public void setIdtlAccdtInsurApptnYn(java.lang.String idtlAccdtInsurApptnYn) {
		this.idtlAccdtInsurApptnYn = idtlAccdtInsurApptnYn;
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

	public java.lang.String getUmytInsrFlucDt() {
		return umytInsrFlucDt;
	}

	public void setUmytInsrFlucDt(java.lang.String umytInsrFlucDt) {
		this.umytInsrFlucDt = umytInsrFlucDt;
	}

	public java.math.BigDecimal getUmytInsrPayTotAmnt() {
		return umytInsrPayTotAmnt;
	}

	public void setUmytInsrPayTotAmnt(java.math.BigDecimal umytInsrPayTotAmnt) {
		this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
	}

	public java.math.BigDecimal getUmytInsrPayMnthAmnt() {
		return umytInsrPayMnthAmnt;
	}

	public void setUmytInsrPayMnthAmnt(java.math.BigDecimal umytInsrPayMnthAmnt) {
		this.umytInsrPayMnthAmnt = umytInsrPayMnthAmnt;
	}

	public java.lang.String getIdtlAccdtFlucDt() {
		return idtlAccdtFlucDt;
	}

	public void setIdtlAccdtFlucDt(java.lang.String idtlAccdtFlucDt) {
		this.idtlAccdtFlucDt = idtlAccdtFlucDt;
	}

	public java.math.BigDecimal getIdtlAccdtPayTotAmnt() {
		return idtlAccdtPayTotAmnt;
	}

	public void setIdtlAccdtPayTotAmnt(java.math.BigDecimal idtlAccdtPayTotAmnt) {
		this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
	}

	public java.math.BigDecimal getIdtlAccdtPayMnthAmnt() {
		return idtlAccdtPayMnthAmnt;
	}

	public void setIdtlAccdtPayMnthAmnt(java.math.BigDecimal idtlAccdtPayMnthAmnt) {
		this.idtlAccdtPayMnthAmnt = idtlAccdtPayMnthAmnt;
	}
 
    
}
