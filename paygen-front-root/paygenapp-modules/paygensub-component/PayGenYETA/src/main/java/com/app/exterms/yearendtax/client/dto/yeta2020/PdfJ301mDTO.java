package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfJ301mVO.java
 * @Description : PdfJ301m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfJ301mDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 주택마련저축계좌번호 : homeSeilSum */
    private String homeSeilSum;

    /** set 투택마련저축납입월 : homeAmtMn */
    private java.lang.String homeAmtMn;

    /** set 주택마련저축월별납입금액 : homeMmAmt */
    private java.math.BigDecimal homeMmAmt;

    /** set 주택마련저축월별확정구분코드 : fixCd */
    private java.lang.String fixCd;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;


    
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
    
  
    
    /**
	 * Comment : 
	 * @fn String getHomeSeilSum()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the homeSeilSum get
	 */
	public String getHomeSeilSum() {
		return homeSeilSum;
	}

	/**
	 * Comment : 
	 *@fn void setHomeSeilSum(String homeSeilSum)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param homeSeilSum the homeSeilSum to set
	 */
	public void setHomeSeilSum(String homeSeilSum) {
		this.homeSeilSum = homeSeilSum;
	}

	public java.lang.String getHomeAmtMn() {
        return this.homeAmtMn;
    }
    
    public void setHomeAmtMn(java.lang.String homeAmtMn) {
        this.homeAmtMn = homeAmtMn;
    }
    
    public java.math.BigDecimal getHomeMmAmt() {
        return this.homeMmAmt;
    }
    
    public void setHomeMmAmt(java.math.BigDecimal homeMmAmt) {
        this.homeMmAmt = homeMmAmt;
    }
    
    public java.lang.String getFixCd() {
        return this.fixCd;
    }
    
    public void setFixCd(java.lang.String fixCd) {
        this.fixCd = fixCd;
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
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
}
