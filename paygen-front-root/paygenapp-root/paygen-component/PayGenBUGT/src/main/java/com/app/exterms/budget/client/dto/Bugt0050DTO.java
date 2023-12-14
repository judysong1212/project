package com.app.exterms.budget.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bugt0050VO.java
 * @Description : Bugt0050 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bugt0050DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** ACC_UNT_CD */
    private java.lang.String accUntCd;
    
    /** ACC_YR */
    private java.lang.String accYr;
    
    /** ACC_UNT_TX_ITEM_CD */
    private java.lang.String accUntTxItemCd;
    
    /** ACC_UNT_TX_ITEM_NM */
    private java.lang.String accUntTxItemNm;
    
    /** ACC_UNT_TX_ITEM_BUGT_SUM */
    private java.math.BigDecimal accUntTxItemBugtSum;
    
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
    
    /** default constructor */
    public Bugt0050DTO() {
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
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
    
    public java.lang.String getAccUntTxItemNm() {
        return this.accUntTxItemNm;
    }
    
    public void setAccUntTxItemNm(java.lang.String accUntTxItemNm) {
        this.accUntTxItemNm = accUntTxItemNm;
    }
    
    public java.math.BigDecimal getAccUntTxItemBugtSum() {
        return this.accUntTxItemBugtSum;
    }
    
    public void setAccUntTxItemBugtSum(java.math.BigDecimal accUntTxItemBugtSum) {
        this.accUntTxItemBugtSum = accUntTxItemBugtSum;
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
