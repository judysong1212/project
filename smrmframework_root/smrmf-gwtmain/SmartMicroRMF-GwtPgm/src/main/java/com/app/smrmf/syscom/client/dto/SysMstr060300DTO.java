package com.app.smrmf.syscom.client.dto;

import java.io.Serializable;

/**
 * @Class Name : SysMstr060300VO.java
 * @Description : SysMstr060300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysMstr060300DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** LEVF_ABNC_DIV_CD */
    private java.lang.String levfAbncDivCd;
    
    /** LEVF_ABNC_PAY_PYMT_MNTH */
    private java.lang.String levfAbncPayPymtMnth;
    
    /** PAY_ITEM_GRP_CD */
    private java.lang.String payItemGrpCd;
    
    /** LEVF_ABNC_PAY_PYMT_RATE */
    private java.math.BigDecimal levfAbncPayPymtRate;
    
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
    
    public java.lang.String getLevfAbncDivCd() {
        return this.levfAbncDivCd;
    }
    
    public void setLevfAbncDivCd(java.lang.String levfAbncDivCd) {
        this.levfAbncDivCd = levfAbncDivCd;
    }
    
    public java.lang.String getLevfAbncPayPymtMnth() {
        return this.levfAbncPayPymtMnth;
    }
    
    public void setLevfAbncPayPymtMnth(java.lang.String levfAbncPayPymtMnth) {
        this.levfAbncPayPymtMnth = levfAbncPayPymtMnth;
    }
    
    public java.lang.String getPayItemGrpCd() {
        return this.payItemGrpCd;
    }
    
    public void setPayItemGrpCd(java.lang.String payItemGrpCd) {
        this.payItemGrpCd = payItemGrpCd;
    }
    
    public java.math.BigDecimal getLevfAbncPayPymtRate() {
        return this.levfAbncPayPymtRate;
    }
    
    public void setLevfAbncPayPymtRate(java.math.BigDecimal levfAbncPayPymtRate) {
        this.levfAbncPayPymtRate = levfAbncPayPymtRate;
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
