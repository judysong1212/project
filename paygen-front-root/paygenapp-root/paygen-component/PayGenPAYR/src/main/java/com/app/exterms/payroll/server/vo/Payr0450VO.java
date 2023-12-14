package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0450VO.java
 * @Description : Payr0450 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0450VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PAY_PYMT_ITEM_LIST_SEIL_NUM */
    private BigDecimal payPymtItemListSeilNum;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** PAY_YR */
    private java.lang.String payYr;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** ITEM_EXTPY_DIV_CD */
    private java.lang.String itemExtpyDivCd;
    
    /** STYR_NUM */
    private BigDecimal styrNum;
    
    /** EDYR_NUM */
    private BigDecimal edyrNum;
    
    /** PYMT_DDUC_RATE */
    private BigDecimal pymtDducRate;
    
    /** PYMT_DDUC_SUM */
    private BigDecimal pymtDducSum;
    
    /** ITEM_LIST_EXTPY_DEL_YN */
    private java.lang.String itemListExtpyDelYn;
    
    /** RMAK */
    private java.lang.String rmak;
    
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
    
    private BigDecimal addPymtDducSum;   //3째자녀 처리를 위해 추가함.
    
    
    public BigDecimal getAddPymtDducSum() {
        return addPymtDducSum;
    }

    public void setAddPymtDducSum(BigDecimal addPymtDducSum) {
        this.addPymtDducSum = addPymtDducSum;
    }

    public BigDecimal getPayPymtItemListSeilNum() {
        return this.payPymtItemListSeilNum;
    }
    
    public void setPayPymtItemListSeilNum(BigDecimal payPymtItemListSeilNum) {
        this.payPymtItemListSeilNum = payPymtItemListSeilNum;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getItemExtpyDivCd() {
        return this.itemExtpyDivCd;
    }
    
    public void setItemExtpyDivCd(java.lang.String itemExtpyDivCd) {
        this.itemExtpyDivCd = itemExtpyDivCd;
    }
    
    public BigDecimal getStyrNum() {
        return this.styrNum;
    }
    
    public void setStyrNum(BigDecimal styrNum) {
        this.styrNum = styrNum;
    }
    
    public BigDecimal getEdyrNum() {
        return this.edyrNum;
    }
    
    public void setEdyrNum(BigDecimal edyrNum) {
        this.edyrNum = edyrNum;
    }
    
    public BigDecimal getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(BigDecimal pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getItemListExtpyDelYn() {
        return this.itemListExtpyDelYn;
    }
    
    public void setItemListExtpyDelYn(java.lang.String itemListExtpyDelYn) {
        this.itemListExtpyDelYn = itemListExtpyDelYn;
    }
    
    public java.lang.String getRmak() {
        return this.rmak;
    }
    
    public void setRmak(java.lang.String rmak) {
        this.rmak = rmak;
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
