package com.app.exterms.yearendtax.client.dto.yeta2021;

import java.io.Serializable;

/**
 * @Class Name : PdfC101mVO.java
 * @Description : PdfC101m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfC101mDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 교육비일련번호 : ediSeilNum */
    private java.math.BigDecimal ediSeilNum;

    /** set 교육비납입월 : ediAmtMn */
    private java.lang.String ediAmtMn;

    /** set 교육비월별납입금액 : ediMmAmt */
    private java.math.BigDecimal ediMmAmt;

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
    
    public java.lang.String getYrtxBlggYr() {
        return this.yrtxBlggYr;
    }
    
    public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
        this.yrtxBlggYr = yrtxBlggYr;
    }
    
    public java.lang.String getClutSeptCd() {
        return this.clutSeptCd;
    }
    
    public void setClutSeptCd(java.lang.String clutSeptCd) {
        this.clutSeptCd = clutSeptCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.math.BigDecimal getEdiSeilNum() {
        return this.ediSeilNum;
    }
    
    public void setEdiSeilNum(java.math.BigDecimal ediSeilNum) {
        this.ediSeilNum = ediSeilNum;
    }
    
    public java.lang.String getEdiAmtMn() {
        return this.ediAmtMn;
    }
    
    public void setEdiAmtMn(java.lang.String ediAmtMn) {
        this.ediAmtMn = ediAmtMn;
    }
    
    
    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getEdiMmAmt()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the ediMmAmt get
	 */
	public java.math.BigDecimal getEdiMmAmt() {
		return ediMmAmt;
	}

	/**
	 * Comment : 
	 *@fn void setEdiMmAmt(java.math.BigDecimal ediMmAmt)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param ediMmAmt the ediMmAmt to set
	 */
	public void setEdiMmAmt(java.math.BigDecimal ediMmAmt) {
		this.ediMmAmt = ediMmAmt;
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
