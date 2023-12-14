package com.app.exterms.payroll.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0300DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    /** PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** PAYR_SEIL_NUM */
    private BigDecimal payrSeilNum;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** PAY_PYMT_DT */
    private java.lang.String payPymtDt;
    
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
    
    /** PAY_MSTR_NOTE_CTNT */
    private java.lang.String payMstrNoteCtnt;
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getPymtYrMnth() {
        return this.pymtYrMnth;
    }
    
    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public BigDecimal getPayrSeilNum() {
        return this.payrSeilNum;
    }
    
    public void setPayrSeilNum(BigDecimal payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayPymtDt() {
        return this.payPymtDt;
    }
    
    public void setPayPymtDt(java.lang.String payPymtDt) {
        this.payPymtDt = payPymtDt;
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
    
    public java.lang.String getPayMstrNoteCtnt() {
        return this.payMstrNoteCtnt;
    }
    
    public void setPayMstrNoteCtnt(java.lang.String payMstrNoteCtnt) {
        this.payMstrNoteCtnt = payMstrNoteCtnt;
    }
    
}
