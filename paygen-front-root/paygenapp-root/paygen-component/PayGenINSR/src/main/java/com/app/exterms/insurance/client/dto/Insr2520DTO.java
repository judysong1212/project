package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr2520VO.java
 * @Description : Insr2520 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2520DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 작성년월 : retryYrMnth */
	private java.lang.String retryYrMnth;

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	private java.math.BigDecimal socInsrLssEmymtNum;

	/** set 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
	private java.math.BigDecimal cmpttnTgtPridSeilNum;

	/** set 산정대상시작일자 : cmpttnTgtBgnnDt */
	private java.lang.String cmpttnTgtBgnnDt;

	/** set 산정대상종료일자 : cmpttnTgtEndDt */
	private java.lang.String cmpttnTgtEndDt;

	/** set 임금지급기초일수 : amntPymtNumDys */
	private java.math.BigDecimal amntPymtNumDys;

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
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getRetryYrMnth() {
        return this.retryYrMnth;
    }
    
    public void setRetryYrMnth(java.lang.String retryYrMnth) {
        this.retryYrMnth = retryYrMnth;
    }
    
    public java.math.BigDecimal getSocInsrLssEmymtNum() {
        return this.socInsrLssEmymtNum;
    }
    
    public void setSocInsrLssEmymtNum(java.math.BigDecimal socInsrLssEmymtNum) {
        this.socInsrLssEmymtNum = socInsrLssEmymtNum;
    }
    
    public java.math.BigDecimal getCmpttnTgtPridSeilNum() {
        return this.cmpttnTgtPridSeilNum;
    }
    
    public void setCmpttnTgtPridSeilNum(java.math.BigDecimal cmpttnTgtPridSeilNum) {
        this.cmpttnTgtPridSeilNum = cmpttnTgtPridSeilNum;
    }
    
    public java.lang.String getCmpttnTgtBgnnDt() {
        return this.cmpttnTgtBgnnDt;
    }
    
    public void setCmpttnTgtBgnnDt(java.lang.String cmpttnTgtBgnnDt) {
        this.cmpttnTgtBgnnDt = cmpttnTgtBgnnDt;
    }
    
    public java.lang.String getCmpttnTgtEndDt() {
        return this.cmpttnTgtEndDt;
    }
    
    public void setCmpttnTgtEndDt(java.lang.String cmpttnTgtEndDt) {
        this.cmpttnTgtEndDt = cmpttnTgtEndDt;
    }
    
    public java.math.BigDecimal getAmntPymtNumDys() {
        return this.amntPymtNumDys;
    }
    
    public void setAmntPymtNumDys(java.math.BigDecimal amntPymtNumDys) {
        this.amntPymtNumDys = amntPymtNumDys;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
