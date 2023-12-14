package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfL102dVO.java
 * @Description : PdfL102d VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfL102dDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set 기부금명세일련번호 : conbSeilNum */
    private java.math.BigDecimal conbSeilNum;

    /** set 기부금_기부일자 : conbDd */
    private java.lang.String conbDd;

    /** set 일별기부장려금신청금액 : conbApin */
    private java.math.BigDecimal conbApin;

    /** set 일별기부금액합계 : conbDaysAmtSum */
    private java.math.BigDecimal conbDaysAmtSum;

    /** set 일별기부금액_소득공제대상금액 : conbDdDdctSum */
    private java.math.BigDecimal conbDdDdctSum;

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
    
    public java.math.BigDecimal getConbSeilNum() {
        return this.conbSeilNum;
    }
    
    public void setConbSeilNum(java.math.BigDecimal conbSeilNum) {
        this.conbSeilNum = conbSeilNum;
    }
    
    public java.lang.String getConbDd() {
        return this.conbDd;
    }
    
    public void setConbDd(java.lang.String conbDd) {
        this.conbDd = conbDd;
    }
    
    public java.math.BigDecimal getConbApin() {
        return this.conbApin;
    }
    
    public void setConbApin(java.math.BigDecimal conbApin) {
        this.conbApin = conbApin;
    }
    
    public java.math.BigDecimal getConbDaysAmtSum() {
        return this.conbDaysAmtSum;
    }
    
    public void setConbDaysAmtSum(java.math.BigDecimal conbDaysAmtSum) {
        this.conbDaysAmtSum = conbDaysAmtSum;
    }
    
    public java.math.BigDecimal getConbDdDdctSum() {
        return this.conbDdDdctSum;
    }
    
    public void setConbDdDdctSum(java.math.BigDecimal conbDdDdctSum) {
        this.conbDdDdctSum = conbDdDdctSum;
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
