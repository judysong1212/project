package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0540VO.java
 * @Description : Payr0540 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0540VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 예외처리일련번호 : exptnPrcsSeilNum */
    private java.math.BigDecimal exptnPrcsSeilNum;

    /** set 예외구분코드 : exptnDivCd */
    private java.lang.String exptnDivCd;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 면제여부 : exmtnYn */
    private java.lang.String exmtnYn;

    /** set 예외처리공제금액 : exptnPrcsPymtSum */
    private java.math.BigDecimal exptnPrcsPymtSum;

    /** set 예외처리공제비율 : exptnPrcsPymtRto */
    private java.math.BigDecimal exptnPrcsPymtRto;

    /** set 예외처리시작일자 : exptnPrcsBgnnDt */
    private java.lang.String exptnPrcsBgnnDt;

    /** set 예외처리종료일자 : exptnPrcsEndDt */
    private java.lang.String exptnPrcsEndDt;

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

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 예외처리내용 : exptnPrcsNoteCtnt */
    private java.lang.String exptnPrcsNoteCtnt;

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    public java.math.BigDecimal getExptnPrcsSeilNum() {
        return exptnPrcsSeilNum;
    }

    public void setExptnPrcsSeilNum(java.math.BigDecimal exptnPrcsSeilNum) {
        this.exptnPrcsSeilNum = exptnPrcsSeilNum;
    }

    public java.lang.String getExptnDivCd() {
        return exptnDivCd;
    }

    public void setExptnDivCd(java.lang.String exptnDivCd) {
        this.exptnDivCd = exptnDivCd;
    }

    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

    public java.lang.String getExmtnYn() {
        return exmtnYn;
    }

    public void setExmtnYn(java.lang.String exmtnYn) {
        this.exmtnYn = exmtnYn;
    }

    public java.math.BigDecimal getExptnPrcsPymtSum() {
        return exptnPrcsPymtSum;
    }

    public void setExptnPrcsPymtSum(java.math.BigDecimal exptnPrcsPymtSum) {
        this.exptnPrcsPymtSum = exptnPrcsPymtSum;
    }

    public java.math.BigDecimal getExptnPrcsPymtRto() {
        return exptnPrcsPymtRto;
    }

    public void setExptnPrcsPymtRto(java.math.BigDecimal exptnPrcsPymtRto) {
        this.exptnPrcsPymtRto = exptnPrcsPymtRto;
    }

    public java.lang.String getExptnPrcsBgnnDt() {
        return exptnPrcsBgnnDt;
    }

    public void setExptnPrcsBgnnDt(java.lang.String exptnPrcsBgnnDt) {
        this.exptnPrcsBgnnDt = exptnPrcsBgnnDt;
    }

    public java.lang.String getExptnPrcsEndDt() {
        return exptnPrcsEndDt;
    }

    public void setExptnPrcsEndDt(java.lang.String exptnPrcsEndDt) {
        this.exptnPrcsEndDt = exptnPrcsEndDt;
    }

    public java.lang.String getKybdr() {
        return kybdr;
    }

    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }

    public java.lang.String getInptDt() {
        return inptDt;
    }

    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }

    public java.lang.String getInptAddr() {
        return inptAddr;
    }

    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }

    public java.lang.String getIsmt() {
        return ismt;
    }

    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }

    public java.lang.String getRevnDt() {
        return revnDt;
    }

    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }

    public java.lang.String getRevnAddr() {
        return revnAddr;
    }

    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }

    public java.lang.String getPayItemCd() {
        return payItemCd;
    }

    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }

    public java.lang.String getExptnPrcsNoteCtnt() {
        return exptnPrcsNoteCtnt;
    }

    public void setExptnPrcsNoteCtnt(java.lang.String exptnPrcsNoteCtnt) {
        this.exptnPrcsNoteCtnt = exptnPrcsNoteCtnt;
    }

     
}
