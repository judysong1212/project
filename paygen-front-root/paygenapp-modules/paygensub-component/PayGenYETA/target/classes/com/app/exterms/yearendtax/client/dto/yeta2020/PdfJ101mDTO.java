package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfJ101mVO.java
 * @Description : PdfJ101m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfJ101mDTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 주택임차차입금일련번호 : tradeSeilNum */
    private java.math.BigDecimal tradeSeilNum;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set 주택임차차입금상환월 : lsAmtMn */
    private java.lang.String lsAmtMn;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 주택임차차입금월별상환액 : lsMmAmt */
    private java.math.BigDecimal lsMmAmt;

    /** set 주택임차차입금월별확정구분코드 : fixCd */
    private java.lang.String fixCd;

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
	 * @fn java.math.BigDecimal getTradeSeilNum()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the tradeSeilNum get
	 */
	public java.math.BigDecimal getTradeSeilNum() {
		return tradeSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setTradeSeilNum(java.math.BigDecimal tradeSeilNum)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param tradeSeilNum the tradeSeilNum to set
	 */
	public void setTradeSeilNum(java.math.BigDecimal tradeSeilNum) {
		this.tradeSeilNum = tradeSeilNum;
	}

	public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getLsAmtMn() {
        return this.lsAmtMn;
    }
    
    public void setLsAmtMn(java.lang.String lsAmtMn) {
        this.lsAmtMn = lsAmtMn;
    }
    
    public java.math.BigDecimal getLsMmAmt() {
        return this.lsMmAmt;
    }
    
    public void setLsMmAmt(java.math.BigDecimal lsMmAmt) {
        this.lsMmAmt = lsMmAmt;
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
