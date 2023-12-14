package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr1300VO.java
 * @Description : Insr1300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1300VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사회보험작성일자 : soctyInsurCmptnDt */
    private java.lang.String soctyInsurCmptnDt;

    /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
    private java.math.BigDecimal socInsrAqtnEmymtNum;

    /** set 국민연금소득월액 : natPennIncmMnthAmnt */
    private java.math.BigDecimal natPennIncmMnthAmnt;

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    private java.math.BigDecimal hlthInsrMnthRuntnAmnt;

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    private java.math.BigDecimal umytInsrPayMnthAmnt;

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    private java.math.BigDecimal idtlAccdtPayMnthAmnt;

    /** set 비고 : note */
    private java.lang.String note;

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
    
    public java.lang.String getSoctyInsurCmptnDt() {
        return this.soctyInsurCmptnDt;
    }
    
    public void setSoctyInsurCmptnDt(java.lang.String soctyInsurCmptnDt) {
        this.soctyInsurCmptnDt = soctyInsurCmptnDt;
    }
    
    public java.math.BigDecimal getSocInsrAqtnEmymtNum() {
        return this.socInsrAqtnEmymtNum;
    }
    
    public void setSocInsrAqtnEmymtNum(java.math.BigDecimal socInsrAqtnEmymtNum) {
        this.socInsrAqtnEmymtNum = socInsrAqtnEmymtNum;
    }
    
    public java.math.BigDecimal getNatPennIncmMnthAmnt() {
        return this.natPennIncmMnthAmnt;
    }
    
    public void setNatPennIncmMnthAmnt(java.math.BigDecimal natPennIncmMnthAmnt) {
        this.natPennIncmMnthAmnt = natPennIncmMnthAmnt;
    }
    
    public java.math.BigDecimal getHlthInsrMnthRuntnAmnt() {
        return this.hlthInsrMnthRuntnAmnt;
    }
    
    public void setHlthInsrMnthRuntnAmnt(java.math.BigDecimal hlthInsrMnthRuntnAmnt) {
        this.hlthInsrMnthRuntnAmnt = hlthInsrMnthRuntnAmnt;
    }
    
    public java.math.BigDecimal getUmytInsrPayMnthAmnt() {
        return this.umytInsrPayMnthAmnt;
    }
    
    public void setUmytInsrPayMnthAmnt(java.math.BigDecimal umytInsrPayMnthAmnt) {
        this.umytInsrPayMnthAmnt = umytInsrPayMnthAmnt;
    }
    
    public java.math.BigDecimal getIdtlAccdtPayMnthAmnt() {
        return this.idtlAccdtPayMnthAmnt;
    }
    
    public void setIdtlAccdtPayMnthAmnt(java.math.BigDecimal idtlAccdtPayMnthAmnt) {
        this.idtlAccdtPayMnthAmnt = idtlAccdtPayMnthAmnt;
    }
    
    public java.lang.String getNote() {
        return this.note;
    }
    
    public void setNote(java.lang.String note) {
        this.note = note;
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
