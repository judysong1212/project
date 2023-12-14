package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass2530VO.java
 * @Description : Bass2530 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2530DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 교대근무구분코드 : rotaDutyDivCd */
    private java.lang.String rotaDutyDivCd;

    /** set 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
    private java.math.BigDecimal wkdyNorDutyExtpyMgftn;

    /** set 평일정상근무수당금액 : wkdyNorDutyExtpySum */
    private java.math.BigDecimal wkdyNorDutyExtpySum;

    /** set 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
    private java.math.BigDecimal wkdyExtnnExtpyMgftn;

    /** set 평일연장근무수당금액 : wkdyExtnnExtpySum */
    private java.math.BigDecimal wkdyExtnnExtpySum;

    /** set 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
    private java.math.BigDecimal wkdyNgtExtpyMgftn;

    /** set 평일야간근무수당금액 : wkdyNgtExtpySum */
    private java.math.BigDecimal wkdyNgtExtpySum;

    /** set 휴일정상근무배율 : pubcHodyNorDutyMgftn */
    private java.math.BigDecimal pubcHodyNorDutyMgftn;

    /** set 휴일정상근무금액 : pubcHodyNorDutySum */
    private java.math.BigDecimal pubcHodyNorDutySum;

    /** set 휴일연장근무배율 : pubcHodyExtnnMgftn */
    private java.math.BigDecimal pubcHodyExtnnMgftn;

    /** set 휴일연장근무금액 : pubcHodyExtnnSum */
    private java.math.BigDecimal pubcHodyExtnnSum;

    /** set 휴일근무급여수당분리적용여부 : pubcHodyPaySprnApptnYn */
    private java.lang.String pubcHodyPaySprnApptnYn;

    /** set 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
    private java.math.BigDecimal payDutyTmCalcSeilNum;

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
    
    public java.lang.String getStpInttnSeptVal() {
        return this.stpInttnSeptVal;
    }
    
    public void setStpInttnSeptVal(java.lang.String stpInttnSeptVal) {
        this.stpInttnSeptVal = stpInttnSeptVal;
    }
    
    public java.lang.String getRotaDutyDivCd() {
        return this.rotaDutyDivCd;
    }
    
    public void setRotaDutyDivCd(java.lang.String rotaDutyDivCd) {
        this.rotaDutyDivCd = rotaDutyDivCd;
    }
    
    public java.math.BigDecimal getWkdyNorDutyExtpyMgftn() {
        return this.wkdyNorDutyExtpyMgftn;
    }
    
    public void setWkdyNorDutyExtpyMgftn(java.math.BigDecimal wkdyNorDutyExtpyMgftn) {
        this.wkdyNorDutyExtpyMgftn = wkdyNorDutyExtpyMgftn;
    }
    
    public java.math.BigDecimal getWkdyNorDutyExtpySum() {
        return this.wkdyNorDutyExtpySum;
    }
    
    public void setWkdyNorDutyExtpySum(java.math.BigDecimal wkdyNorDutyExtpySum) {
        this.wkdyNorDutyExtpySum = wkdyNorDutyExtpySum;
    }
    
    public java.math.BigDecimal getWkdyExtnnExtpyMgftn() {
        return this.wkdyExtnnExtpyMgftn;
    }
    
    public void setWkdyExtnnExtpyMgftn(java.math.BigDecimal wkdyExtnnExtpyMgftn) {
        this.wkdyExtnnExtpyMgftn = wkdyExtnnExtpyMgftn;
    }
    
    public java.math.BigDecimal getWkdyExtnnExtpySum() {
        return this.wkdyExtnnExtpySum;
    }
    
    public void setWkdyExtnnExtpySum(java.math.BigDecimal wkdyExtnnExtpySum) {
        this.wkdyExtnnExtpySum = wkdyExtnnExtpySum;
    }
    
    public java.math.BigDecimal getWkdyNgtExtpyMgftn() {
        return this.wkdyNgtExtpyMgftn;
    }
    
    public void setWkdyNgtExtpyMgftn(java.math.BigDecimal wkdyNgtExtpyMgftn) {
        this.wkdyNgtExtpyMgftn = wkdyNgtExtpyMgftn;
    }
    
    public java.math.BigDecimal getWkdyNgtExtpySum() {
        return this.wkdyNgtExtpySum;
    }
    
    public void setWkdyNgtExtpySum(java.math.BigDecimal wkdyNgtExtpySum) {
        this.wkdyNgtExtpySum = wkdyNgtExtpySum;
    }
    
    public java.math.BigDecimal getPubcHodyNorDutyMgftn() {
        return this.pubcHodyNorDutyMgftn;
    }
    
    public void setPubcHodyNorDutyMgftn(java.math.BigDecimal pubcHodyNorDutyMgftn) {
        this.pubcHodyNorDutyMgftn = pubcHodyNorDutyMgftn;
    }
    
    public java.math.BigDecimal getPubcHodyNorDutySum() {
        return this.pubcHodyNorDutySum;
    }
    
    public void setPubcHodyNorDutySum(java.math.BigDecimal pubcHodyNorDutySum) {
        this.pubcHodyNorDutySum = pubcHodyNorDutySum;
    }
    
    public java.math.BigDecimal getPubcHodyExtnnMgftn() {
        return this.pubcHodyExtnnMgftn;
    }
    
    public void setPubcHodyExtnnMgftn(java.math.BigDecimal pubcHodyExtnnMgftn) {
        this.pubcHodyExtnnMgftn = pubcHodyExtnnMgftn;
    }
    
    public java.math.BigDecimal getPubcHodyExtnnSum() {
        return this.pubcHodyExtnnSum;
    }
    
    public void setPubcHodyExtnnSum(java.math.BigDecimal pubcHodyExtnnSum) {
        this.pubcHodyExtnnSum = pubcHodyExtnnSum;
    }
    
    public java.lang.String getPubcHodyPaySprnApptnYn() {
        return this.pubcHodyPaySprnApptnYn;
    }
    
    public void setPubcHodyPaySprnApptnYn(java.lang.String pubcHodyPaySprnApptnYn) {
        this.pubcHodyPaySprnApptnYn = pubcHodyPaySprnApptnYn;
    }
    
    public java.math.BigDecimal getPayDutyTmCalcSeilNum() {
        return this.payDutyTmCalcSeilNum;
    }
    
    public void setPayDutyTmCalcSeilNum(java.math.BigDecimal payDutyTmCalcSeilNum) {
        this.payDutyTmCalcSeilNum = payDutyTmCalcSeilNum;
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
