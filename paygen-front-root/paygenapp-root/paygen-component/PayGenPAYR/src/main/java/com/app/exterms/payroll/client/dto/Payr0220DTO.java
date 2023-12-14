package com.app.exterms.payroll.client.dto;

import java.io.Serializable; 

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
public class Payr0220DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** PROV_ATHM_SEIL_NUM */
    private Long provAthmSeilNum;
    
    /** ICNT_NUM */
    private java.lang.String icntNum;
    
    /** ICNT_NM */
    private java.lang.String icntNm;
    
    /** CDTR_NM */
    private java.lang.String cdtrNm;
    
    /** BOND_ISTUT */
    private java.lang.String bondIstut;
    
    /** BNK_CD */
    private java.lang.String bnkCd;
    
    /** BNK_ACCU_NUM */
    private java.lang.String bnkAccuNum;
    
    /** ACNT_HODR_NM */
    private java.lang.String acntHodrNm;
    
    /** RCPT_DT */
    private java.lang.String rcptDt;
    
    /** DLVY_DT */
    private java.lang.String dlvyDt;
    
    /** DDUC_PRID_BGNN_DT */
    private java.lang.String dducPridBgnnDt;
    
    /** DDUC_PRID_END_DT */
    private java.lang.String dducPridEndDt;
    
    /** BOND_FRCLR_END_YN */
    private Boolean bondFrclrEndYn;
    
    /** PAY_DDUC_YN */
    private Boolean payDducYn;
    
    /** CLM_SUM */
    private Long clmSum;
    
    /** CLM_BALN */
    private Long clmBaln;
    
    /** BOND_FRCLR_LMT_SUM */
    private Long bondFrclrLmtSum;
    
    /** ACMLTE_DDUC_SUM */
    private Long acmlteDducSum;
    
    /** DDUC_SUM */
    private Long dducSum;
    
    /** DDUC_RTO */
    private Double dducRto;
    
    /** PROV_ATHM_NOTE_CTNT */
    private java.lang.String provAthmNoteCtnt;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    
    
    
    public Long getProvAthmSeilNum() {
        return provAthmSeilNum;
    }

    public void setProvAthmSeilNum(Long provAthmSeilNum) {
        this.provAthmSeilNum = provAthmSeilNum;
    }

    public Boolean getBondFrclrEndYn() {
        return bondFrclrEndYn;
    }

    public void setBondFrclrEndYn(Boolean bondFrclrEndYn) {
        this.bondFrclrEndYn = bondFrclrEndYn;
    }

    public Boolean getPayDducYn() {
        return payDducYn;
    }

    public void setPayDducYn(Boolean payDducYn) {
        this.payDducYn = payDducYn;
    }

    public Long getClmSum() {
        return clmSum;
    }

    public void setClmSum(Long clmSum) {
        this.clmSum = clmSum;
    }

    public Long getClmBaln() {
        return clmBaln;
    }

    public void setClmBaln(Long clmBaln) {
        this.clmBaln = clmBaln;
    }

    public Long getBondFrclrLmtSum() {
        return bondFrclrLmtSum;
    }

    public void setBondFrclrLmtSum(Long bondFrclrLmtSum) {
        this.bondFrclrLmtSum = bondFrclrLmtSum;
    }

    public Long getAcmlteDducSum() {
        return acmlteDducSum;
    }

    public void setAcmlteDducSum(Long acmlteDducSum) {
        this.acmlteDducSum = acmlteDducSum;
    }

    public Long getDducSum() {
        return dducSum;
    }

    public void setDducSum(Long dducSum) {
        this.dducSum = dducSum;
    }

    public Double getDducRto() {
        return dducRto;
    }

    public void setDducRto(Double dducRto) {
        this.dducRto = dducRto;
    }

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
