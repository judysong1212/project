package com.app.smrmf.infc.yearendtax.server.vo.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : Ye162010VO.java
 * @Description : Ye162010 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2016.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe162010_2023_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** PNSN_SVNG_ACC_ACCNO */
    private java.lang.String pnsnSvngAccAccno;
    
    /** PNSN_SVNG_ACC_PNSN_SVNG_CL */
    private java.lang.String pnsnSvngAccPnsnSvngCl;
    
    /** PNSN_SVNG_FNN_ORGN_CD */
    private java.lang.String pnsnSvngFnnOrgnCd;
    
    /** PNSN_SVNG_ACC_FNN_CMP */
    private java.lang.String pnsnSvngAccFnnCmp;
    

	/** PNSN_SVNG_ACC_PYM_AMT */
    private java.math.BigDecimal pnsnSvngAccPymAmt;
    
    /** IPNSN_SVNG_ACCDDC_AMT */
    private java.math.BigDecimal ipnsnSvngAccddcAmt;
    
    private java.math.BigDecimal pnsnSvngAccTgtAmt;
    
    
    
    /** PNSN_SVNG_ACC_ISA_AMT  */
    private java.math.BigDecimal pnsnSvngAccIsaAmt;
    
    /** IPNSN_SVNG_ACCDDC_ISA_AMT  */
    private java.math.BigDecimal ipnsnSvngAccddcIsaAmt;
    
    
    //2023연말정산_추가
    private java.math.BigDecimal pnsnSvngAccIsaTgtAmt;
    
    
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
    
    
    
    
    
    
    public java.math.BigDecimal getPnsnSvngAccIsaTgtAmt() {
		return pnsnSvngAccIsaTgtAmt;
	}

	public void setPnsnSvngAccIsaTgtAmt(java.math.BigDecimal pnsnSvngAccIsaTgtAmt) {
		this.pnsnSvngAccIsaTgtAmt = pnsnSvngAccIsaTgtAmt;
	}

	public java.math.BigDecimal getPnsnSvngAccIsaAmt() {
    	return pnsnSvngAccIsaAmt;
    }
    
    public void setPnsnSvngAccIsaAmt(java.math.BigDecimal pnsnSvngAccIsaAmt) {
    	this.pnsnSvngAccIsaAmt = pnsnSvngAccIsaAmt;
    }
    
    public java.math.BigDecimal getIpnsnSvngAccddcIsaAmt() {
    	return ipnsnSvngAccddcIsaAmt;
    }
    
    public void setIpnsnSvngAccddcIsaAmt(java.math.BigDecimal ipnsnSvngAccddcIsaAmt) {
    	this.ipnsnSvngAccddcIsaAmt = ipnsnSvngAccddcIsaAmt;
    }
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getYrtxBlggYr() {
        return this.yrtxBlggYr;
    }
    
    public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
        this.yrtxBlggYr = yrtxBlggYr;
    }
    
    public java.lang.String getClutSeptCd() {
        return this.clutSeptCd;
    }
    
    public void setClutSeptCd(java.lang.String clutSeptCd) {
        this.clutSeptCd = clutSeptCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPnsnSvngAccAccno() {
        return this.pnsnSvngAccAccno;
    }
    
    public void setPnsnSvngAccAccno(java.lang.String pnsnSvngAccAccno) {
        this.pnsnSvngAccAccno = pnsnSvngAccAccno;
    }
    
    public java.lang.String getPnsnSvngAccPnsnSvngCl() {
        return this.pnsnSvngAccPnsnSvngCl;
    }
    
    public void setPnsnSvngAccPnsnSvngCl(java.lang.String pnsnSvngAccPnsnSvngCl) {
        this.pnsnSvngAccPnsnSvngCl = pnsnSvngAccPnsnSvngCl;
    }
    
    public java.lang.String getPnsnSvngFnnOrgnCd() {
        return this.pnsnSvngFnnOrgnCd;
    }
    
    public void setPnsnSvngFnnOrgnCd(java.lang.String pnsnSvngFnnOrgnCd) {
        this.pnsnSvngFnnOrgnCd = pnsnSvngFnnOrgnCd;
    }
    
    public java.lang.String getPnsnSvngAccFnnCmp() {
        return this.pnsnSvngAccFnnCmp;
    }
    
    public void setPnsnSvngAccFnnCmp(java.lang.String pnsnSvngAccFnnCmp) {
        this.pnsnSvngAccFnnCmp = pnsnSvngAccFnnCmp;
    }
    
    public java.math.BigDecimal getPnsnSvngAccPymAmt() {
        return this.pnsnSvngAccPymAmt;
    }
    
    public void setPnsnSvngAccPymAmt(java.math.BigDecimal pnsnSvngAccPymAmt) {
        this.pnsnSvngAccPymAmt = pnsnSvngAccPymAmt;
    }
    
    public java.math.BigDecimal getIpnsnSvngAccddcAmt() {
        return this.ipnsnSvngAccddcAmt;
    }
    
    public void setIpnsnSvngAccddcAmt(java.math.BigDecimal ipnsnSvngAccddcAmt) {
        this.ipnsnSvngAccddcAmt = ipnsnSvngAccddcAmt;
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

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPnsnSvngAccTgtAmt()
	 * @brief date:2023 2023. 2. 10. user:atres
	 * @return the pnsnSvngAccTgtAmt get
	 */
	public java.math.BigDecimal getPnsnSvngAccTgtAmt() {
		return pnsnSvngAccTgtAmt;
	}

	/**
	 * Comment : 
	 *@fn void setPnsnSvngAccTgtAmt(java.math.BigDecimal pnsnSvngAccTgtAmt)
	 *@brief date:2023 2023. 2. 10. user:atres
	 *@param pnsnSvngAccTgtAmt the pnsnSvngAccTgtAmt to set
	 */
	public void setPnsnSvngAccTgtAmt(java.math.BigDecimal pnsnSvngAccTgtAmt) {
		this.pnsnSvngAccTgtAmt = pnsnSvngAccTgtAmt;
	}
    
}
