package com.app.exterms.yearendtax.client.dto.yeta2017;

import java.io.Serializable;

/**
 * @Class Name : PdfK101mVO.java
 * @Description : PdfK101m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfK101mDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 소상공인공제부금계약_증서번호 : accNo */
    private java.lang.String accNo;

    /** set 소상공인공제부금납입월 : busnAmtNm */
    private java.lang.String busnAmtNm;

    /** set 소상공인공제부금월별납입금액 : busnMmAmt */
    private java.math.BigDecimal busnMmAmt;

    /** set 소상공인공제부금납입일자 : busnDate */
    private java.lang.String busnDate;

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
    
    public java.lang.String getAccNo() {
        return this.accNo;
    }
    
    public void setAccNo(java.lang.String accNo) {
        this.accNo = accNo;
    }
    
    public java.lang.String getBusnAmtNm() {
        return this.busnAmtNm;
    }
    
    public void setBusnAmtNm(java.lang.String busnAmtNm) {
        this.busnAmtNm = busnAmtNm;
    }
    
    public java.math.BigDecimal getBusnMmAmt() {
        return this.busnMmAmt;
    }
    
    public void setBusnMmAmt(java.math.BigDecimal busnMmAmt) {
        this.busnMmAmt = busnMmAmt;
    }
    
    public java.lang.String getBusnDate() {
        return this.busnDate;
    }
    
    public void setBusnDate(java.lang.String busnDate) {
        this.busnDate = busnDate;
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
