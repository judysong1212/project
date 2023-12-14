package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0425VO.java
 * @Description : Payr0425 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0425VO  implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.math.BigDecimal payrItemSeilNum;

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    private java.lang.String pyspLogSvcYrNumCd;

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    private java.lang.String occuClssPayCmpttnStd;

    /** set 이전근속년수단가금액 : befSvcYrUcstSum */
    private java.math.BigDecimal befSvcYrUcstSum;

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
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
        return this.typOccuGrdeMppgSeilNum;
    }
    
    public void setTypOccuGrdeMppgSeilNum(java.math.BigDecimal typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }
    
    public java.math.BigDecimal getPayrItemSeilNum() {
        return this.payrItemSeilNum;
    }
    
    public void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }
    
    public java.lang.String getPyspLogSvcYrNumCd() {
        return this.pyspLogSvcYrNumCd;
    }
    
    public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
        this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
    }
    
    public java.lang.String getOccuClssPayCmpttnStd() {
        return this.occuClssPayCmpttnStd;
    }
    
    public void setOccuClssPayCmpttnStd(java.lang.String occuClssPayCmpttnStd) {
        this.occuClssPayCmpttnStd = occuClssPayCmpttnStd;
    }
    
    public java.math.BigDecimal getBefSvcYrUcstSum() {
        return this.befSvcYrUcstSum;
    }
    
    public void setBefSvcYrUcstSum(java.math.BigDecimal befSvcYrUcstSum) {
        this.befSvcYrUcstSum = befSvcYrUcstSum;
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