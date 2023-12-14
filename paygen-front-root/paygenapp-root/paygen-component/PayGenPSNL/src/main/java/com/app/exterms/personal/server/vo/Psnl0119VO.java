package com.app.exterms.personal.server.vo;

/**
 * @Class Name : Psnl0119VO.java
 * @Description : Psnl0119 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0119VO extends Psnl0119DefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 경력사항일련번호 : carrRsptSeilNum */
    private java.math.BigDecimal carrRsptSeilNum;

    /** set 경력시작일자 : carrBgnnDt */
    private java.lang.String carrBgnnDt;

    /** set 경력종료일자 : carrEndDt */
    private java.lang.String carrEndDt;

    /** set 근무처명 : paeWorkNm */
    private java.lang.String paeWorkNm;

    /** set 경력구분코드 : carrDivCd */
    private java.lang.String carrDivCd;

    /** set 근무부서명 : dutyDeptNm */
    private java.lang.String dutyDeptNm;

    /** set 담당업무명 : repbtyBusinNm */
    private java.lang.String repbtyBusinNm;

    /** set 직책명 : odtyNm */
    private java.lang.String odtyNm;

    /** set 임금일당금액 : amntDlywagSum */
    private java.math.BigDecimal amntDlywagSum;

    /** set 경력비고내용 : carrNoteCtnt */
    private java.lang.String carrNoteCtnt;

    /** set 근무년수 : dutyYrNum */
    private java.math.BigDecimal dutyYrNum;

    /** set 근무월수 : dutyMnthIcm */
    private java.math.BigDecimal dutyMnthIcm;

    /** set 환산비율 : cvsnRto */
    private java.lang.String cvsnRto;

    /** set 가감월수 : ajmtMnthNum */
    private java.math.BigDecimal ajmtMnthNum;

    /** set 인정월수 : rcgtnMnthNum */
    private java.math.BigDecimal rcgtnMnthNum;

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
    
    /** set 환산비율구분코드 : cvsnRtoDivCd */
    private java.lang.String cvsnRtoDivCd;

    private String calMode;
    
    private double yearDay;
    
    private double monthDay;
    
    
    
    
    
	public String getCalMode() {
		return calMode;
	}

	public void setCalMode(String calMode) {
		this.calMode = calMode;
	}

	public double getYearDay() {
		return yearDay;
	}

	public void setYearDay(double yearDay) {
		this.yearDay = yearDay;
	}

	public double getMonthDay() {
		return monthDay;
	}

	public void setMonthDay(double monthDay) {
		this.monthDay = monthDay;
	}

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

	public java.math.BigDecimal getCarrRsptSeilNum() {
		return carrRsptSeilNum;
	}

	public void setCarrRsptSeilNum(java.math.BigDecimal carrRsptSeilNum) {
		this.carrRsptSeilNum = carrRsptSeilNum;
	}

	public java.lang.String getCarrBgnnDt() {
		return carrBgnnDt;
	}

	public void setCarrBgnnDt(java.lang.String carrBgnnDt) {
		this.carrBgnnDt = carrBgnnDt;
	}

	public java.lang.String getCarrEndDt() {
		return carrEndDt;
	}

	public void setCarrEndDt(java.lang.String carrEndDt) {
		this.carrEndDt = carrEndDt;
	}

	public java.lang.String getPaeWorkNm() {
		return paeWorkNm;
	}

	public void setPaeWorkNm(java.lang.String paeWorkNm) {
		this.paeWorkNm = paeWorkNm;
	}

	public java.lang.String getCarrDivCd() {
		return carrDivCd;
	}

	public void setCarrDivCd(java.lang.String carrDivCd) {
		this.carrDivCd = carrDivCd;
	}

	public java.lang.String getDutyDeptNm() {
		return dutyDeptNm;
	}

	public void setDutyDeptNm(java.lang.String dutyDeptNm) {
		this.dutyDeptNm = dutyDeptNm;
	}

	public java.lang.String getRepbtyBusinNm() {
		return repbtyBusinNm;
	}

	public void setRepbtyBusinNm(java.lang.String repbtyBusinNm) {
		this.repbtyBusinNm = repbtyBusinNm;
	}

	public java.lang.String getOdtyNm() {
		return odtyNm;
	}

	public void setOdtyNm(java.lang.String odtyNm) {
		this.odtyNm = odtyNm;
	}

	public java.math.BigDecimal getAmntDlywagSum() {
		return amntDlywagSum;
	}

	public void setAmntDlywagSum(java.math.BigDecimal amntDlywagSum) {
		this.amntDlywagSum = amntDlywagSum;
	}

	public java.lang.String getCarrNoteCtnt() {
		return carrNoteCtnt;
	}

	public void setCarrNoteCtnt(java.lang.String carrNoteCtnt) {
		this.carrNoteCtnt = carrNoteCtnt;
	}

	public java.math.BigDecimal getDutyYrNum() {
		return dutyYrNum;
	}

	public void setDutyYrNum(java.math.BigDecimal dutyYrNum) {
		this.dutyYrNum = dutyYrNum;
	}

	public java.math.BigDecimal getDutyMnthIcm() {
		return dutyMnthIcm;
	}

	public void setDutyMnthIcm(java.math.BigDecimal dutyMnthIcm) {
		this.dutyMnthIcm = dutyMnthIcm;
	}

	public java.lang.String getCvsnRto() {
		return cvsnRto;
	}

	public void setCvsnRto(java.lang.String cvsnRto) {
		this.cvsnRto = cvsnRto;
	}

	public java.math.BigDecimal getAjmtMnthNum() {
		return ajmtMnthNum;
	}

	public void setAjmtMnthNum(java.math.BigDecimal ajmtMnthNum) {
		this.ajmtMnthNum = ajmtMnthNum;
	}

	public java.math.BigDecimal getRcgtnMnthNum() {
		return rcgtnMnthNum;
	}

	public void setRcgtnMnthNum(java.math.BigDecimal rcgtnMnthNum) {
		this.rcgtnMnthNum = rcgtnMnthNum;
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

	public java.lang.String getCvsnRtoDivCd() {
		return cvsnRtoDivCd;
	}

	public void setCvsnRtoDivCd(java.lang.String cvsnRtoDivCd) {
		this.cvsnRtoDivCd = cvsnRtoDivCd;
	}
    
	
}
