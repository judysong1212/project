package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass2510VO.java
 * @Description : Bass2510 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2510DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 근무구분코드 : dutyDivCd */
    private java.lang.String dutyDivCd;

    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 교대근무구분코드 : rotaDutyDivCd */
    private java.lang.String rotaDutyDivCd;

    /** set 교대근무시작시간 : rotaDutyBgnnTm */
    private java.lang.String rotaDutyBgnnTm;

    /** set 교대근무종료시간 : rotaDutyEndTm */
    private java.lang.String rotaDutyEndTm;

    /** set 교대근무시간수 : rotaDutyTmNum */
    private java.math.BigDecimal rotaDutyTmNum;

    /** set 교대근무제외시간수 : rotaDutyEepnTmNum */
    private java.math.BigDecimal rotaDutyEepnTmNum;

    /** set 교대연장근무시작시간 : extnnDutyBgnnTm */
    private java.lang.String extnnDutyBgnnTm;

    /** set 교대연장근무종료시간 : extnnDutyEndTm */
    private java.lang.String extnnDutyEndTm;

    /** set 교대연장제외시간수 : rotaExtnnEepnTmNum */
    private java.math.BigDecimal rotaExtnnEepnTmNum;

    /** set 교대야간근무시작시간 : ngtDutyBgnnTm */
    private java.lang.String ngtDutyBgnnTm;

    /** set 교대야간근무종료시간 : ngtDutyEndTm */
    private java.lang.String ngtDutyEndTm;

    /** set 교대야간근무제외시간수 : rotaNgtEepnTmNum */
    private java.math.BigDecimal rotaNgtEepnTmNum;

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
    
    public java.lang.String getDutyDivCd() {
        return this.dutyDivCd;
    }
    
    public void setDutyDivCd(java.lang.String dutyDivCd) {
        this.dutyDivCd = dutyDivCd;
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
    
    public java.lang.String getRotaDutyBgnnTm() {
        return this.rotaDutyBgnnTm;
    }
    
    public void setRotaDutyBgnnTm(java.lang.String rotaDutyBgnnTm) {
        this.rotaDutyBgnnTm = rotaDutyBgnnTm;
    }
    
    public java.lang.String getRotaDutyEndTm() {
        return this.rotaDutyEndTm;
    }
    
    public void setRotaDutyEndTm(java.lang.String rotaDutyEndTm) {
        this.rotaDutyEndTm = rotaDutyEndTm;
    }
    
    public java.math.BigDecimal getRotaDutyTmNum() {
        return this.rotaDutyTmNum;
    }
    
    public void setRotaDutyTmNum(java.math.BigDecimal rotaDutyTmNum) {
        this.rotaDutyTmNum = rotaDutyTmNum;
    }
    
    public java.math.BigDecimal getRotaDutyEepnTmNum() {
        return this.rotaDutyEepnTmNum;
    }
    
    public void setRotaDutyEepnTmNum(java.math.BigDecimal rotaDutyEepnTmNum) {
        this.rotaDutyEepnTmNum = rotaDutyEepnTmNum;
    }
    
    public java.lang.String getExtnnDutyBgnnTm() {
        return this.extnnDutyBgnnTm;
    }
    
    public void setExtnnDutyBgnnTm(java.lang.String extnnDutyBgnnTm) {
        this.extnnDutyBgnnTm = extnnDutyBgnnTm;
    }
    
    public java.lang.String getExtnnDutyEndTm() {
        return this.extnnDutyEndTm;
    }
    
    public void setExtnnDutyEndTm(java.lang.String extnnDutyEndTm) {
        this.extnnDutyEndTm = extnnDutyEndTm;
    }
    
    public java.math.BigDecimal getRotaExtnnEepnTmNum() {
        return this.rotaExtnnEepnTmNum;
    }
    
    public void setRotaExtnnEepnTmNum(java.math.BigDecimal rotaExtnnEepnTmNum) {
        this.rotaExtnnEepnTmNum = rotaExtnnEepnTmNum;
    }
    
    public java.lang.String getNgtDutyBgnnTm() {
        return this.ngtDutyBgnnTm;
    }
    
    public void setNgtDutyBgnnTm(java.lang.String ngtDutyBgnnTm) {
        this.ngtDutyBgnnTm = ngtDutyBgnnTm;
    }
    
    public java.lang.String getNgtDutyEndTm() {
        return this.ngtDutyEndTm;
    }
    
    public void setNgtDutyEndTm(java.lang.String ngtDutyEndTm) {
        this.ngtDutyEndTm = ngtDutyEndTm;
    }
    
    public java.math.BigDecimal getRotaNgtEepnTmNum() {
        return this.rotaNgtEepnTmNum;
    }
    
    public void setRotaNgtEepnTmNum(java.math.BigDecimal rotaNgtEepnTmNum) {
        this.rotaNgtEepnTmNum = rotaNgtEepnTmNum;
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
