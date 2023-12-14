package com.app.smrmf.pkg.proc.remt.retirement.payr;

import java.io.Serializable;
 
/**
 * @Class Name : Payr0500VO.java
 * @Description : Payr0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtLogSvcDysVO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    //PSNL0100
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;
 

    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;

  
	//remt2000
 
    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;
    

    /** set 기산일자 : rkfcdDt */
    private java.lang.String rkfcdDt;
 

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    
    /** set 근속년수 : logSvcYrNum */
    private java.math.BigDecimal logSvcYrNum;

    /** set 근속월수 : logSvcMnthIcm */
    private java.math.BigDecimal logSvcMnthIcm;

    /** set 군경력근속년수 : amcrrLogSvcYrNum */
    private java.math.BigDecimal amcrrLogSvcYrNum;

    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
    private java.math.BigDecimal amcrrLogSvcMnthIcm;
    

   /** set 실근무년수 : turtyDutyYrNum */
    private java.math.BigDecimal turtyDutyYrNum;

    /** set 실근무개월수 : turtyDutyMnthNum */
    private java.math.BigDecimal turtyDutyMnthNum;

   /** set 실근무일수 : turtyDutyNumDys */
    private java.math.BigDecimal turtyDutyNumDys;
 
    /** set 근속일수 : logSvcNumDys */
    private java.math.BigDecimal logSvcNumDys;
    
   
    /** set 군경력근무일수 : amcrrLogSvcNumDys */
    private java.math.BigDecimal amcrrLogSvcNumDys;

    /** set 급여산정시작일자 : payCmpttnBgnnDt */
    private java.lang.String payCmpttnBgnnDt;

    /** set 급여산정종료일자 : payCmpttnEndDt */
    private java.lang.String payCmpttnEndDt;

   
    /** set 총근무일수 : totLogSvcNumDys */
    private java.math.BigDecimal totLogSvcNumDys;


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


	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}


	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}


	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}


	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}


	public java.lang.String getIcncDt() {
		return icncDt;
	}


	public void setIcncDt(java.lang.String icncDt) {
		this.icncDt = icncDt;
	}


	public java.lang.String getRkfcdDt() {
		return rkfcdDt;
	}


	public void setRkfcdDt(java.lang.String rkfcdDt) {
		this.rkfcdDt = rkfcdDt;
	}


	public java.lang.String getRetryDt() {
		return retryDt;
	}


	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}


	public java.math.BigDecimal getLogSvcYrNum() {
		return logSvcYrNum;
	}


	public void setLogSvcYrNum(java.math.BigDecimal logSvcYrNum) {
		this.logSvcYrNum = logSvcYrNum;
	}


	public java.math.BigDecimal getLogSvcMnthIcm() {
		return logSvcMnthIcm;
	}


	public void setLogSvcMnthIcm(java.math.BigDecimal logSvcMnthIcm) {
		this.logSvcMnthIcm = logSvcMnthIcm;
	}


	public java.math.BigDecimal getAmcrrLogSvcYrNum() {
		return amcrrLogSvcYrNum;
	}


	public void setAmcrrLogSvcYrNum(java.math.BigDecimal amcrrLogSvcYrNum) {
		this.amcrrLogSvcYrNum = amcrrLogSvcYrNum;
	}


	public java.math.BigDecimal getAmcrrLogSvcMnthIcm() {
		return amcrrLogSvcMnthIcm;
	}


	public void setAmcrrLogSvcMnthIcm(java.math.BigDecimal amcrrLogSvcMnthIcm) {
		this.amcrrLogSvcMnthIcm = amcrrLogSvcMnthIcm;
	}


	public java.math.BigDecimal getTurtyDutyYrNum() {
		return turtyDutyYrNum;
	}


	public void setTurtyDutyYrNum(java.math.BigDecimal turtyDutyYrNum) {
		this.turtyDutyYrNum = turtyDutyYrNum;
	}


	public java.math.BigDecimal getTurtyDutyMnthNum() {
		return turtyDutyMnthNum;
	}


	public void setTurtyDutyMnthNum(java.math.BigDecimal turtyDutyMnthNum) {
		this.turtyDutyMnthNum = turtyDutyMnthNum;
	}


	public java.math.BigDecimal getTurtyDutyNumDys() {
		return turtyDutyNumDys;
	}


	public void setTurtyDutyNumDys(java.math.BigDecimal turtyDutyNumDys) {
		this.turtyDutyNumDys = turtyDutyNumDys;
	}


	public java.math.BigDecimal getLogSvcNumDys() {
		return logSvcNumDys;
	}


	public void setLogSvcNumDys(java.math.BigDecimal logSvcNumDys) {
		this.logSvcNumDys = logSvcNumDys;
	}


	public java.math.BigDecimal getAmcrrLogSvcNumDys() {
		return amcrrLogSvcNumDys;
	}


	public void setAmcrrLogSvcNumDys(java.math.BigDecimal amcrrLogSvcNumDys) {
		this.amcrrLogSvcNumDys = amcrrLogSvcNumDys;
	}


	public java.lang.String getPayCmpttnBgnnDt() {
		return payCmpttnBgnnDt;
	}


	public void setPayCmpttnBgnnDt(java.lang.String payCmpttnBgnnDt) {
		this.payCmpttnBgnnDt = payCmpttnBgnnDt;
	}


	public java.lang.String getPayCmpttnEndDt() {
		return payCmpttnEndDt;
	}


	public void setPayCmpttnEndDt(java.lang.String payCmpttnEndDt) {
		this.payCmpttnEndDt = payCmpttnEndDt;
	}


	public java.math.BigDecimal getTotLogSvcNumDys() {
		return totLogSvcNumDys;
	}


	public void setTotLogSvcNumDys(java.math.BigDecimal totLogSvcNumDys) {
		this.totLogSvcNumDys = totLogSvcNumDys;
	}
  
    
    
	 
    
}
