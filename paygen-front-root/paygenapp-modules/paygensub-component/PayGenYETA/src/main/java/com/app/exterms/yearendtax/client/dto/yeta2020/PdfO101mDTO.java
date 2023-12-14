package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfO101mVO.java
 * @Description : PdfO101m VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfO101mDTO   implements Serializable {
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

    /** set 건강보험납입월 : hlthAmtMn */
    private java.lang.String hlthAmtMn;

    /** set 건강보험료_보수월액_고지금액 : hiNtf */
    private java.math.BigDecimal hiNtf;

    /** set 장기요양보험료_보수월액_고지금액 : ltrmNtf */
    private java.math.BigDecimal ltrmNtf;

    /** set 건강보험료_소득월액_납부금액 : hiPmt */
    private java.math.BigDecimal hiPmt;

    /** set 장기용양보험료_소득월액_납부금액 : ltrmPmt */
    private java.math.BigDecimal ltrmPmt;

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
    
 
    
    public java.lang.String getDatCd() {
        return this.datCd;
    }
    
    public void setDatCd(java.lang.String datCd) {
        this.datCd = datCd;
    }
    
    public java.lang.String getHlthAmtMn() {
        return this.hlthAmtMn;
    }
    
    public void setHlthAmtMn(java.lang.String hlthAmtMn) {
        this.hlthAmtMn = hlthAmtMn;
    }
    
    public java.math.BigDecimal getHiNtf() {
        return this.hiNtf;
    }
    
    public void setHiNtf(java.math.BigDecimal hiNtf) {
        this.hiNtf = hiNtf;
    }
    
    public java.math.BigDecimal getLtrmNtf() {
        return this.ltrmNtf;
    }
    
    public void setLtrmNtf(java.math.BigDecimal ltrmNtf) {
        this.ltrmNtf = ltrmNtf;
    }
    
    public java.math.BigDecimal getHiPmt() {
        return this.hiPmt;
    }
    
    public void setHiPmt(java.math.BigDecimal hiPmt) {
        this.hiPmt = hiPmt;
    }
    
    public java.math.BigDecimal getLtrmPmt() {
        return this.ltrmPmt;
    }
    
    public void setLtrmPmt(java.math.BigDecimal ltrmPmt) {
        this.ltrmPmt = ltrmPmt;
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
