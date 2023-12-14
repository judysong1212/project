package com.app.exterms.yearendtax.client.dto.yeta2021;

import java.io.Serializable;

/**
 * @Class Name : PdfP101mVO.java
 * @Description : PdfP101m VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfP101mDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 국민연금_납입월 : natAmtMn */
    private java.lang.String natAmtMn;

    /** set 국민연금_직장가입자고지금액 : wrkpNtf */
    private java.math.BigDecimal wrkpNtf;

    /** set 국민연금_지역가입자등납입금액 : rgnPmt */
    private java.math.BigDecimal rgnPmt;

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
    
 
    /**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDatCd() {
        return this.datCd;
    }
    
    public void setDatCd(java.lang.String datCd) {
        this.datCd = datCd;
    }
    
    public java.lang.String getNatAmtMn() {
        return this.natAmtMn;
    }
    
    public void setNatAmtMn(java.lang.String natAmtMn) {
        this.natAmtMn = natAmtMn;
    }
    
    public java.math.BigDecimal getWrkpNtf() {
        return this.wrkpNtf;
    }
    
    public void setWrkpNtf(java.math.BigDecimal wrkpNtf) {
        this.wrkpNtf = wrkpNtf;
    }
    
    public java.math.BigDecimal getRgnPmt() {
        return this.rgnPmt;
    }
    
    public void setRgnPmt(java.math.BigDecimal rgnPmt) {
        this.rgnPmt = rgnPmt;
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
