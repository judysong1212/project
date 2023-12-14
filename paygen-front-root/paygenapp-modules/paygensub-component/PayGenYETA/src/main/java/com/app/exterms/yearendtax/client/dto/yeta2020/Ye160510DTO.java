package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : Ye160510VO.java
 * @Description : Ye160510 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye160510DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    private java.lang.String whdgDebrBusoprRgstnum;

    /** set 비과세감면구분코드 : freeDtyReduDivCd */
    private java.lang.String freeDtyReduDivCd;

    /** set 비과세감면합계금액 : freeDtyReduAggrSum */
    private java.math.BigDecimal freeDtyReduAggrSum;

    /** set 현근무지기지급금액 : currPaeWorkPayrfgSum */
    private java.math.BigDecimal currPaeWorkPayrfgSum;

    /** set 종전근무지기지급금액 : prcspPayrfgSum */
    private java.math.BigDecimal prcspPayrfgSum;

    /** set 비과세감면_과세전환금액 : freetyReduTxChngSum */
    private java.math.BigDecimal freetyReduTxChngSum;

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
    
    public java.lang.String getWhdgDebrBusoprRgstnum() {
        return this.whdgDebrBusoprRgstnum;
    }
    
    public void setWhdgDebrBusoprRgstnum(java.lang.String whdgDebrBusoprRgstnum) {
        this.whdgDebrBusoprRgstnum = whdgDebrBusoprRgstnum;
    }
    
    public java.lang.String getFreeDtyReduDivCd() {
        return this.freeDtyReduDivCd;
    }
    
    public void setFreeDtyReduDivCd(java.lang.String freeDtyReduDivCd) {
        this.freeDtyReduDivCd = freeDtyReduDivCd;
    }
    
    public java.math.BigDecimal getFreeDtyReduAggrSum() {
        return this.freeDtyReduAggrSum;
    }
    
    public void setFreeDtyReduAggrSum(java.math.BigDecimal freeDtyReduAggrSum) {
        this.freeDtyReduAggrSum = freeDtyReduAggrSum;
    }
    
    public java.math.BigDecimal getCurrPaeWorkPayrfgSum() {
        return this.currPaeWorkPayrfgSum;
    }
    
    public void setCurrPaeWorkPayrfgSum(java.math.BigDecimal currPaeWorkPayrfgSum) {
        this.currPaeWorkPayrfgSum = currPaeWorkPayrfgSum;
    }
    
    public java.math.BigDecimal getPrcspPayrfgSum() {
        return this.prcspPayrfgSum;
    }
    
    public void setPrcspPayrfgSum(java.math.BigDecimal prcspPayrfgSum) {
        this.prcspPayrfgSum = prcspPayrfgSum;
    }
    
    public java.math.BigDecimal getFreetyReduTxChngSum() {
        return this.freetyReduTxChngSum;
    }
    
    public void setFreetyReduTxChngSum(java.math.BigDecimal freetyReduTxChngSum) {
        this.freetyReduTxChngSum = freetyReduTxChngSum;
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
