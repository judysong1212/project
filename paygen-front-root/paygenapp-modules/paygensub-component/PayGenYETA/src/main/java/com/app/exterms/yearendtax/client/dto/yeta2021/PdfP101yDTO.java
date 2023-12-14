package com.app.exterms.yearendtax.client.dto.yeta2021;

import java.io.Serializable;

/**
 * @Class Name : PdfP101yVO.java
 * @Description : PdfP101y VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfP101yDTO   implements Serializable {
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

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 국민연금_주민등록번호 : resid */
    private java.lang.String resid;

    /** set 국민연금_성명 : name */
    private java.lang.String name;

    /** set 국민연금_총합계금액 : natAmtSum */
    private java.math.BigDecimal natAmtSum;

    /** set 국민연금_추납보험료납부금액 : spym */
    private java.math.BigDecimal spym;

    /** set 국민연금_실업크레딧납부금액 : jlc */
    private java.math.BigDecimal jlc;

    /** set 국민연금_직장가입자고지금액합계 : ntf */
    private java.math.BigDecimal ntf;

    /** set 국민연금_지역가입자등_납입금액합계 : pmt */
    private java.math.BigDecimal pmt;

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    private java.lang.String pdfDatAppYn;

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
    
    public java.lang.String getFormCd() {
        return this.formCd;
    }
    
    public void setFormCd(java.lang.String formCd) {
        this.formCd = formCd;
    }
    
    public java.lang.String getResid() {
        return this.resid;
    }
    
    public void setResid(java.lang.String resid) {
        this.resid = resid;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.math.BigDecimal getNatAmtSum() {
        return this.natAmtSum;
    }
    
    public void setNatAmtSum(java.math.BigDecimal natAmtSum) {
        this.natAmtSum = natAmtSum;
    }
    
    public java.math.BigDecimal getSpym() {
        return this.spym;
    }
    
    public void setSpym(java.math.BigDecimal spym) {
        this.spym = spym;
    }
    
    public java.math.BigDecimal getJlc() {
        return this.jlc;
    }
    
    public void setJlc(java.math.BigDecimal jlc) {
        this.jlc = jlc;
    }
    
    public java.math.BigDecimal getNtf() {
        return this.ntf;
    }
    
    public void setNtf(java.math.BigDecimal ntf) {
        this.ntf = ntf;
    }
    
    public java.math.BigDecimal getPmt() {
        return this.pmt;
    }
    
    public void setPmt(java.math.BigDecimal pmt) {
        this.pmt = pmt;
    }
    
    public java.lang.String getPdfDatAppYn() {
        return this.pdfDatAppYn;
    }
    
    public void setPdfDatAppYn(java.lang.String pdfDatAppYn) {
        this.pdfDatAppYn = pdfDatAppYn;
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
