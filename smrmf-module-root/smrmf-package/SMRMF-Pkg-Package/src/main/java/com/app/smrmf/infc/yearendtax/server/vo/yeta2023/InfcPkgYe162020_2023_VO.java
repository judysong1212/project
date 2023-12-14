package com.app.smrmf.infc.yearendtax.server.vo.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : Ye162020VO.java
 * @Description : Ye162020 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 20178.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe162020_2023_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** RTPN_ACC_ACCNO */
    private java.lang.String rtpnAccAccno;
    
    /** RTPN_ACC_RTPN_CL */
    private java.lang.String rtpnAccRtpnCl;
    
    /** RTPN_FNN_ORGN_CD */
    private java.lang.String rtpnFnnOrgnCd;
    
    /** RTPN_ACC_FNN_CMP */
    private java.lang.String rtpnAccFnnCmp;
    
    /** RTPN_ACC_PYM_AMT */
    private java.math.BigDecimal rtpnAccPymAmt;
    
    /** RTPN_ACC_TXAMT_DDC_AMT */
    private java.math.BigDecimal rtpnAccTxamtDdcAmt;
    
    
    //2023연말정산_추가
    /** RTPN_ACC_ISA_AMT */
    private java.math.BigDecimal rtpnAccIsaAmt;
    
    /** RTPN_ACC_TXAMT_DDC_ISA_AMT */
    private java.math.BigDecimal rtpnAccTxamtDdcIsaAmt;
    
    private java.math.BigDecimal rtpnAccIsaTgtAmt;
  //2023연말정산_추가
    
    
    
    private java.math.BigDecimal rtpnAccTgtAmt;
    
    
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
    
    
    
    
   

	public java.math.BigDecimal getRtpnAccIsaTgtAmt() {
		return rtpnAccIsaTgtAmt;
	}

	public void setRtpnAccIsaTgtAmt(java.math.BigDecimal rtpnAccIsaTgtAmt) {
		this.rtpnAccIsaTgtAmt = rtpnAccIsaTgtAmt;
	}

	public java.math.BigDecimal getRtpnAccIsaAmt() {
		return rtpnAccIsaAmt;
	}

	public void setRtpnAccIsaAmt(java.math.BigDecimal rtpnAccIsaAmt) {
		this.rtpnAccIsaAmt = rtpnAccIsaAmt;
	}

	public java.math.BigDecimal getRtpnAccTxamtDdcIsaAmt() {
		return rtpnAccTxamtDdcIsaAmt;
	}

	public void setRtpnAccTxamtDdcIsaAmt(java.math.BigDecimal rtpnAccTxamtDdcIsaAmt) {
		this.rtpnAccTxamtDdcIsaAmt = rtpnAccTxamtDdcIsaAmt;
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
    
    public java.lang.String getRtpnAccAccno() {
        return this.rtpnAccAccno;
    }
    
    public void setRtpnAccAccno(java.lang.String rtpnAccAccno) {
        this.rtpnAccAccno = rtpnAccAccno;
    }
    
    public java.lang.String getRtpnAccRtpnCl() {
        return this.rtpnAccRtpnCl;
    }
    
    public void setRtpnAccRtpnCl(java.lang.String rtpnAccRtpnCl) {
        this.rtpnAccRtpnCl = rtpnAccRtpnCl;
    }
    
    public java.lang.String getRtpnFnnOrgnCd() {
        return this.rtpnFnnOrgnCd;
    }
    
    public void setRtpnFnnOrgnCd(java.lang.String rtpnFnnOrgnCd) {
        this.rtpnFnnOrgnCd = rtpnFnnOrgnCd;
    }
    
    public java.lang.String getRtpnAccFnnCmp() {
        return this.rtpnAccFnnCmp;
    }
    
    public void setRtpnAccFnnCmp(java.lang.String rtpnAccFnnCmp) {
        this.rtpnAccFnnCmp = rtpnAccFnnCmp;
    }
    
    public java.math.BigDecimal getRtpnAccPymAmt() {
        return this.rtpnAccPymAmt;
    }
    
    public void setRtpnAccPymAmt(java.math.BigDecimal rtpnAccPymAmt) {
        this.rtpnAccPymAmt = rtpnAccPymAmt;
    }
    
    public java.math.BigDecimal getRtpnAccTxamtDdcAmt() {
        return this.rtpnAccTxamtDdcAmt;
    }
    
    public void setRtpnAccTxamtDdcAmt(java.math.BigDecimal rtpnAccTxamtDdcAmt) {
        this.rtpnAccTxamtDdcAmt = rtpnAccTxamtDdcAmt;
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
	 * @fn java.math.BigDecimal getRtpnAccTgtAmt()
	 * @brief date:2023 2023. 2. 10. user:atres
	 * @return the rtpnAccTgtAmt get
	 */
	public java.math.BigDecimal getRtpnAccTgtAmt() {
		return rtpnAccTgtAmt;
	}

	/**
	 * Comment : 
	 *@fn void setRtpnAccTgtAmt(java.math.BigDecimal rtpnAccTgtAmt)
	 *@brief date:2023 2023. 2. 10. user:atres
	 *@param rtpnAccTgtAmt the rtpnAccTgtAmt to set
	 */
	public void setRtpnAccTgtAmt(java.math.BigDecimal rtpnAccTgtAmt) {
		this.rtpnAccTgtAmt = rtpnAccTgtAmt;
	}
    
    
}
