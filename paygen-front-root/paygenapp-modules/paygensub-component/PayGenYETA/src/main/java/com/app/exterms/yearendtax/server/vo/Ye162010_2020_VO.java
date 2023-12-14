package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;


/**
 * @Class Name : Ye162010VO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162010_2020_VO implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 계좌번호_증권번호 : pnsnSvngAccAccno */
    private java.lang.String pnsnSvngAccAccno;
    

	/** set 국세청자료구분코드 : taxVvalKrnCd */
	private java.lang.String taxVvalKrnCd;

    /** set 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
    private java.lang.String pnsnSvngAccPnsnSvngCl;

    /** set 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
    private java.lang.String pnsnSvngFnnOrgnCd;

    /** set 굼융회사등명 : pnsnSvngAccFnnCmp */
    private java.lang.String pnsnSvngAccFnnCmp;

    /** set 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
    private java.math.BigDecimal pnsnSvngAccPymAmt;

    /** set 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
    private java.math.BigDecimal ipnsnSvngAccddcAmt;
    
    private java.math.BigDecimal pnsnSvngAccTgtAmt;

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
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPnsnSvngAccAccno() {
		return pnsnSvngAccAccno;
	}

	public void setPnsnSvngAccAccno(java.lang.String pnsnSvngAccAccno) {
		this.pnsnSvngAccAccno = pnsnSvngAccAccno;
	}

	public java.lang.String getPnsnSvngAccPnsnSvngCl() {
		return pnsnSvngAccPnsnSvngCl;
	}

	public void setPnsnSvngAccPnsnSvngCl(java.lang.String pnsnSvngAccPnsnSvngCl) {
		this.pnsnSvngAccPnsnSvngCl = pnsnSvngAccPnsnSvngCl;
	}

	public java.lang.String getPnsnSvngFnnOrgnCd() {
		return pnsnSvngFnnOrgnCd;
	}

	public void setPnsnSvngFnnOrgnCd(java.lang.String pnsnSvngFnnOrgnCd) {
		this.pnsnSvngFnnOrgnCd = pnsnSvngFnnOrgnCd;
	}

	public java.lang.String getPnsnSvngAccFnnCmp() {
		return pnsnSvngAccFnnCmp;
	}

	public void setPnsnSvngAccFnnCmp(java.lang.String pnsnSvngAccFnnCmp) {
		this.pnsnSvngAccFnnCmp = pnsnSvngAccFnnCmp;
	}

	public java.math.BigDecimal getPnsnSvngAccPymAmt() {
		return pnsnSvngAccPymAmt;
	}

	public void setPnsnSvngAccPymAmt(java.math.BigDecimal pnsnSvngAccPymAmt) {
		this.pnsnSvngAccPymAmt = pnsnSvngAccPymAmt;
	}

	public java.math.BigDecimal getIpnsnSvngAccddcAmt() {
		return ipnsnSvngAccddcAmt;
	}

	public void setIpnsnSvngAccddcAmt(java.math.BigDecimal ipnsnSvngAccddcAmt) {
		this.ipnsnSvngAccddcAmt = ipnsnSvngAccddcAmt;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public java.lang.String getTaxVvalKrnCd() {
		return taxVvalKrnCd;
	}

	public void setTaxVvalKrnCd(java.lang.String taxVvalKrnCd) {
		this.taxVvalKrnCd = taxVvalKrnCd;
	}

	public java.math.BigDecimal getPnsnSvngAccTgtAmt() {
		return pnsnSvngAccTgtAmt;
	}

	public void setPnsnSvngAccTgtAmt(java.math.BigDecimal pnsnSvngAccTgtAmt) {
		this.pnsnSvngAccTgtAmt = pnsnSvngAccTgtAmt;
	}
    
}
