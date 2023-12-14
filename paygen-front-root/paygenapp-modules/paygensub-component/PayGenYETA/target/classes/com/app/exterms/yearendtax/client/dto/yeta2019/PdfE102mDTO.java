package com.app.exterms.yearendtax.client.dto.yeta2019;

import java.io.Serializable;

/**
 * @Class Name : PdfE102mVO.java
 * @Description : PdfE102m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfE102mDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set 연금저축납입월 : pnsnAmtMn */
    private java.lang.String pnsnAmtMn;

    /** set 연금저축계좌번호 : pnsnSvSeilNum */
    private java.math.BigDecimal pnsnSvSeilNum;

    /** set 연금저축월별납입금액 : pnsnMmAmt */
    private java.math.BigDecimal pnsnMmAmt;

    /** set 연금저축월별확정구분코드 : fixCd */
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
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
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
	 * @fn java.lang.String getPnsnAmtMn()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the pnsnAmtMn get
	 */
	public java.lang.String getPnsnAmtMn() {
		return pnsnAmtMn;
	}

	/**
	 * Comment : 
	 *@fn void setPnsnAmtMn(java.lang.String pnsnAmtMn)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param pnsnAmtMn the pnsnAmtMn to set
	 */
	public void setPnsnAmtMn(java.lang.String pnsnAmtMn) {
		this.pnsnAmtMn = pnsnAmtMn;
	}

	public java.math.BigDecimal getPnsnSvSeilNum() {
        return this.pnsnSvSeilNum;
    }
    
    public void setPnsnSvSeilNum(java.math.BigDecimal pnsnSvSeilNum) {
        this.pnsnSvSeilNum = pnsnSvSeilNum;
    }
    
    public java.math.BigDecimal getPnsnMmAmt() {
        return this.pnsnMmAmt;
    }
    
    public void setPnsnMmAmt(java.math.BigDecimal pnsnMmAmt) {
        this.pnsnMmAmt = pnsnMmAmt;
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
