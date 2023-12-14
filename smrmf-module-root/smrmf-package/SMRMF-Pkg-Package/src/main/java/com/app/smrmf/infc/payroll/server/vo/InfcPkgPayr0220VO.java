package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0220VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 가압류일련번호 : provAthmSeilNum */
    private java.math.BigDecimal provAthmSeilNum;

    /** set 사건번호 : icntNum */
    private java.lang.String icntNum;

    /** set 사건명 : icntNm */
    private java.lang.String icntNm;

    /** set 채권자명 : cdtrNm */
    private java.lang.String cdtrNm;

    /** set 채권기관 : bondIstut */
    private java.lang.String bondIstut;

    /** set 은행코드 : bnkCd */
    private java.lang.String bnkCd;

    /** set 은행계좌번호 : bnkAccuNum */
    private java.lang.String bnkAccuNum;

    /** set 예금주명 : acntHodrNm */
    private java.lang.String acntHodrNm;

    /** set 접수일자 : rcptDt */
    private java.lang.String rcptDt;

    /** set 송달일자 : dlvyDt */
    private java.lang.String dlvyDt;

    /** set 공제기간시작일자 : dducPridBgnnDt */
    private java.lang.String dducPridBgnnDt;

    /** set 공제기간종료일자 : dducPridEndDt */
    private java.lang.String dducPridEndDt;

    /** set 채권압류종료여부 : bondFrclrEndYn */
    private java.lang.String bondFrclrEndYn;

    /** set 급여공제여부 : payDducYn */
    private java.lang.String payDducYn;

    /** set 청구금액 : clmSum */
    private java.math.BigDecimal clmSum;

    /** set 청구잔액 : clmBaln */
    private java.math.BigDecimal clmBaln;

    /** set 채권압류제한금액 : bondFrclrLmtSum */
    private java.math.BigDecimal bondFrclrLmtSum;

    /** set 누적공제금액 : acmlteDducSum */
    private java.math.BigDecimal acmlteDducSum;

    /** set 공제금액 : dducSum */
    private java.math.BigDecimal dducSum;

    /** set 공제비율 : dducRto */
    private java.math.BigDecimal dducRto;

    /** set 가압류비고내용 : provAthmNoteCtnt */
    private java.lang.String provAthmNoteCtnt;

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
    
    public BigDecimal getProvAthmSeilNum() {
        return this.provAthmSeilNum;
    }
    
    public void setProvAthmSeilNum(BigDecimal provAthmSeilNum) {
        this.provAthmSeilNum = provAthmSeilNum;
    }
    
    public java.lang.String getIcntNum() {
        return this.icntNum;
    }
    
    public void setIcntNum(java.lang.String icntNum) {
        this.icntNum = icntNum;
    }
    
    public java.lang.String getIcntNm() {
        return this.icntNm;
    }
    
    public void setIcntNm(java.lang.String icntNm) {
        this.icntNm = icntNm;
    }
    
    public java.lang.String getCdtrNm() {
        return this.cdtrNm;
    }
    
    public void setCdtrNm(java.lang.String cdtrNm) {
        this.cdtrNm = cdtrNm;
    }
    
    public java.lang.String getBondIstut() {
        return this.bondIstut;
    }
    
    public void setBondIstut(java.lang.String bondIstut) {
        this.bondIstut = bondIstut;
    }
    
    public java.lang.String getBnkCd() {
        return this.bnkCd;
    }
    
    public void setBnkCd(java.lang.String bnkCd) {
        this.bnkCd = bnkCd;
    }
    
    public java.lang.String getBnkAccuNum() {
        return this.bnkAccuNum;
    }
    
    public void setBnkAccuNum(java.lang.String bnkAccuNum) {
        this.bnkAccuNum = bnkAccuNum;
    }
    
    public java.lang.String getAcntHodrNm() {
        return this.acntHodrNm;
    }
    
    public void setAcntHodrNm(java.lang.String acntHodrNm) {
        this.acntHodrNm = acntHodrNm;
    }
    
    public java.lang.String getRcptDt() {
        return this.rcptDt;
    }
    
    public void setRcptDt(java.lang.String rcptDt) {
        this.rcptDt = rcptDt;
    }
    
    public java.lang.String getDlvyDt() {
        return this.dlvyDt;
    }
    
    public void setDlvyDt(java.lang.String dlvyDt) {
        this.dlvyDt = dlvyDt;
    }
    
    public java.lang.String getDducPridBgnnDt() {
        return this.dducPridBgnnDt;
    }
    
    public void setDducPridBgnnDt(java.lang.String dducPridBgnnDt) {
        this.dducPridBgnnDt = dducPridBgnnDt;
    }
    
    public java.lang.String getDducPridEndDt() {
        return this.dducPridEndDt;
    }
    
    public void setDducPridEndDt(java.lang.String dducPridEndDt) {
        this.dducPridEndDt = dducPridEndDt;
    }
    
    public java.lang.String getBondFrclrEndYn() {
        return this.bondFrclrEndYn;
    }
    
    public void setBondFrclrEndYn(java.lang.String bondFrclrEndYn) {
        this.bondFrclrEndYn = bondFrclrEndYn;
    }
    
    public java.lang.String getPayDducYn() {
        return this.payDducYn;
    }
    
    public void setPayDducYn(java.lang.String payDducYn) {
        this.payDducYn = payDducYn;
    }
    
    public BigDecimal getClmSum() {
        return this.clmSum;
    }
    
    public void setClmSum(BigDecimal clmSum) {
        this.clmSum = clmSum;
    }
    
    public BigDecimal getClmBaln() {
        return this.clmBaln;
    }
    
    public void setClmBaln(BigDecimal clmBaln) {
        this.clmBaln = clmBaln;
    }
    
    public BigDecimal getBondFrclrLmtSum() {
        return this.bondFrclrLmtSum;
    }
    
    public void setBondFrclrLmtSum(BigDecimal bondFrclrLmtSum) {
        this.bondFrclrLmtSum = bondFrclrLmtSum;
    }
    
    public BigDecimal getAcmlteDducSum() {
        return this.acmlteDducSum;
    }
    
    public void setAcmlteDducSum(BigDecimal acmlteDducSum) {
        this.acmlteDducSum = acmlteDducSum;
    }
    
    public BigDecimal getDducSum() {
        return this.dducSum;
    }
    
    public void setDducSum(BigDecimal dducSum) {
        this.dducSum = dducSum;
    }
    
    public BigDecimal getDducRto() {
        return this.dducRto;
    }
    
    public void setDducRto(BigDecimal dducRto) {
        this.dducRto = dducRto;
    }
    
    public java.lang.String getProvAthmNoteCtnt() {
        return this.provAthmNoteCtnt;
    }
    
    public void setProvAthmNoteCtnt(java.lang.String provAthmNoteCtnt) {
        this.provAthmNoteCtnt = provAthmNoteCtnt;
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
