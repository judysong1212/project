package com.app.exterms.budget.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bugt0100VO.java
 * @Description : Bugt0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bugt0100VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** ACC_UNT_CD */
    private java.lang.String accUntCd;
    
    /** ACC_YR */
    private java.lang.String accYr;
    
    /** ACC_UNT_TX_ITEM_CD */
    private java.lang.String accUntTxItemCd;
    
    /** DEPT_BUGT_SUM */
    private java.math.BigDecimal deptBugtSum;
    
    /** DEPT_BALN */
    private java.math.BigDecimal deptBaln;
    
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
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getAccUntCd() {
        return this.accUntCd;
    }
    
    public void setAccUntCd(java.lang.String accUntCd) {
        this.accUntCd = accUntCd;
    }
    
    public java.lang.String getAccYr() {
        return this.accYr;
    }
    
    public void setAccYr(java.lang.String accYr) {
        this.accYr = accYr;
    }
    
    public java.lang.String getAccUntTxItemCd() {
        return this.accUntTxItemCd;
    }
    
    public void setAccUntTxItemCd(java.lang.String accUntTxItemCd) {
        this.accUntTxItemCd = accUntTxItemCd;
    }
    
    public java.math.BigDecimal getDeptBugtSum() {
        return this.deptBugtSum;
    }
    
    public void setDeptBugtSum(java.math.BigDecimal deptBugtSum) {
        this.deptBugtSum = deptBugtSum;
    }
    
    public java.math.BigDecimal getDeptBaln() {
        return this.deptBaln;
    }
    
    public void setDeptBaln(java.math.BigDecimal deptBaln) {
        this.deptBaln = deptBaln;
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