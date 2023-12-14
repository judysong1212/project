package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0470VO.java
 * @Description : Payr0470 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0470VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** PAY_DDUC_CD */
    private java.lang.String payDducCd;
    
    /** PAY_DDUC_GRP_CD */
    private java.lang.String payDducGrpCd;
    
    /** PAY_DDUC_NM */
    private java.lang.String payDducNm;
    
    /** PAY_DDUC_USE_YN */
    private java.lang.String payDducUseYn;
    
    /** PAYR_TERM_DDUC_YN */
    private java.lang.String payrTermDducYn;
    
    
    public java.lang.String getPayrTermDducYn() {
		return payrTermDducYn;
	}

	public void setPayrTermDducYn(java.lang.String payrTermDducYn) {
		this.payrTermDducYn = payrTermDducYn;
	}

	/** PAY_DDUC_SUM */
    private BigDecimal payDducSum;
    
    /** PAY_DDUC_RTO */
    private BigDecimal payDducRto;
    
    /** YRTX_DDUC_DIV_CD */
    private java.lang.String yrtxDducDivCd;
    
    /** GRP_APPTN_DIV_CD */
    private java.lang.String grpApptnDivCd;
    
    /** PAY_DDUC_BGNN_DT */
    private java.lang.String payDducBgnnDt;
    
    /** PAY_DDUC_END_DT */
    private java.lang.String payDducEndDt;
    
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

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    
    
    
    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayDducCd() {
        return this.payDducCd;
    }
    
    public void setPayDducCd(java.lang.String payDducCd) {
        this.payDducCd = payDducCd;
    }
    
    public java.lang.String getPayDducGrpCd() {
        return this.payDducGrpCd;
    }
    
    public void setPayDducGrpCd(java.lang.String payDducGrpCd) {
        this.payDducGrpCd = payDducGrpCd;
    }
    
    public java.lang.String getPayDducNm() {
        return this.payDducNm;
    }
    
    public void setPayDducNm(java.lang.String payDducNm) {
        this.payDducNm = payDducNm;
    }
    
    public java.lang.String getPayDducUseYn() {
        return this.payDducUseYn;
    }
    
    public void setPayDducUseYn(java.lang.String payDducUseYn) {
        this.payDducUseYn = payDducUseYn;
    }
    
    public BigDecimal getPayDducSum() {
        return this.payDducSum;
    }
    
    public void setPayDducSum(BigDecimal payDducSum) {
        this.payDducSum = payDducSum;
    }
    
    public BigDecimal getPayDducRto() {
        return this.payDducRto;
    }
    
    public void setPayDducRto(BigDecimal payDducRto) {
        this.payDducRto = payDducRto;
    }
    
    public java.lang.String getYrtxDducDivCd() {
        return this.yrtxDducDivCd;
    }
    
    public void setYrtxDducDivCd(java.lang.String yrtxDducDivCd) {
        this.yrtxDducDivCd = yrtxDducDivCd;
    }
    
    public java.lang.String getGrpApptnDivCd() {
        return this.grpApptnDivCd;
    }
    
    public void setGrpApptnDivCd(java.lang.String grpApptnDivCd) {
        this.grpApptnDivCd = grpApptnDivCd;
    }
    
    public java.lang.String getPayDducBgnnDt() {
        return this.payDducBgnnDt;
    }
    
    public void setPayDducBgnnDt(java.lang.String payDducBgnnDt) {
        this.payDducBgnnDt = payDducBgnnDt;
    }
    
    public java.lang.String getPayDducEndDt() {
        return this.payDducEndDt;
    }
    
    public void setPayDducEndDt(java.lang.String payDducEndDt) {
        this.payDducEndDt = payDducEndDt;
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
