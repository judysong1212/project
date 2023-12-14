package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass0505VO.java
 * @Description : Bass0505 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0505DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set null : deptCd */
    private java.lang.String deptCd;

    /** set 기간제회계구분코드 : fxtmAccDivCd */
    private java.lang.String fxtmAccDivCd;

    /** set 기간제적용단가일수 : fxtmApptnUcstNumDys */
    private java.math.BigDecimal fxtmApptnUcstNumDys;

    /** set 기간제일급단가금액 : fxtmPdyUcstSum */
    private java.math.BigDecimal fxtmPdyUcstSum;

    /** set 교대근무적용여부 : rotaDutyApptnYn */
    private java.lang.String rotaDutyApptnYn;

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
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getFxtmAccDivCd() {
        return this.fxtmAccDivCd;
    }
    
    public void setFxtmAccDivCd(java.lang.String fxtmAccDivCd) {
        this.fxtmAccDivCd = fxtmAccDivCd;
    }
    
    public java.math.BigDecimal getFxtmApptnUcstNumDys() {
        return this.fxtmApptnUcstNumDys;
    }
    
    public void setFxtmApptnUcstNumDys(java.math.BigDecimal fxtmApptnUcstNumDys) {
        this.fxtmApptnUcstNumDys = fxtmApptnUcstNumDys;
    }
    
    public java.math.BigDecimal getFxtmPdyUcstSum() {
        return this.fxtmPdyUcstSum;
    }
    
    public void setFxtmPdyUcstSum(java.math.BigDecimal fxtmPdyUcstSum) {
        this.fxtmPdyUcstSum = fxtmPdyUcstSum;
    }
    
    public java.lang.String getRotaDutyApptnYn() {
        return this.rotaDutyApptnYn;
    }
    
    public void setRotaDutyApptnYn(java.lang.String rotaDutyApptnYn) {
        this.rotaDutyApptnYn = rotaDutyApptnYn;
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
