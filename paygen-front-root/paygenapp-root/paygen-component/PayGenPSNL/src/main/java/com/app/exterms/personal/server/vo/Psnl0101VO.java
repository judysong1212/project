package com.app.exterms.personal.server.vo;

/**
 * @Class Name : Psnl0124VO.java
 * @Description : Psnl0124 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0101VO extends Psnl0101SrhVO	{ 
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 통계기준일련번호 : psnlBseSeilNum */
    private java.math.BigDecimal psnlBseSeilNum;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 최초고용일자 : frstBseEmymtDt */
    private java.lang.String frstBseEmymtDt;

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
    
    /** set 고용유형코드 : emymtTypCd */
    private java.lang.String emymtTypCd;
    
    
    // 지자체별구분자
    private java.lang.String mncpts;
    

	public java.lang.String getEmymtTypCd() {
		return emymtTypCd;
	}

	public void setEmymtTypCd(java.lang.String emymtTypCd) {
		this.emymtTypCd = emymtTypCd;
	}

	public java.lang.String getMncpts() {
		return mncpts;
	}

	public void setMncpts(java.lang.String mncpts) {
		this.mncpts = mncpts;
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

	public java.math.BigDecimal getPsnlBseSeilNum() {
		return psnlBseSeilNum;
	}

	public void setPsnlBseSeilNum(java.math.BigDecimal psnlBseSeilNum) {
		this.psnlBseSeilNum = psnlBseSeilNum;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getFrstBseEmymtDt() {
		return frstBseEmymtDt;
	}

	public void setFrstBseEmymtDt(java.lang.String frstBseEmymtDt) {
		this.frstBseEmymtDt = frstBseEmymtDt;
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
