package com.app.exterms.yearendtax.client.dto.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : PdfP101yVO.java
 * @Description : PdfP101y VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfP102yDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 국민연금_주민등록번호 : resid */
    private java.lang.String resid;

    /** set 국민연금_성명 : name */
    private java.lang.String name;

    /** set 국민연금_총합계금액 : natAmtSum */
    private java.math.BigDecimal natAmtSum;

    /** set 국민연금_직장가입자소급고지금액합계금액 : spNtt */
    private java.math.BigDecimal spNtt;

    /** set 국민연금_추납보험료납부금액 : spym */
    private java.math.BigDecimal spym;

    /** set 국민연금_실업크레딧납부금액 : jlc */
    private java.math.BigDecimal jlc;

    /** set 국민연금_직장가입자고지금액합계 : ntf */
    private java.math.BigDecimal ntf;

    /** set 국민연금_지역가입자등_납입금액합계 : pmt */
    private java.math.BigDecimal pmt;

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    private java.lang.String pdfDatAppYn;

    /** set PDF_소득공제적용일자 : pdfDatAppCmplDt */
    private java.lang.String pdfDatAppCmplDt;

    /** set PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
    private java.lang.String pdfDatAppExcCtnt;

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

	public java.lang.String getDatCd() {
		return datCd;
	}

	public void setDatCd(java.lang.String datCd) {
		this.datCd = datCd;
	}

	public java.lang.String getFormCd() {
		return formCd;
	}

	public void setFormCd(java.lang.String formCd) {
		this.formCd = formCd;
	}

	public java.lang.String getResid() {
		return resid;
	}

	public void setResid(java.lang.String resid) {
		this.resid = resid;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.math.BigDecimal getNatAmtSum() {
		return natAmtSum;
	}

	public void setNatAmtSum(java.math.BigDecimal natAmtSum) {
		this.natAmtSum = natAmtSum;
	}

	public java.math.BigDecimal getSpNtt() {
		return spNtt;
	}

	public void setSpNtt(java.math.BigDecimal spNtt) {
		this.spNtt = spNtt;
	}

	public java.math.BigDecimal getSpym() {
		return spym;
	}

	public void setSpym(java.math.BigDecimal spym) {
		this.spym = spym;
	}

	public java.math.BigDecimal getJlc() {
		return jlc;
	}

	public void setJlc(java.math.BigDecimal jlc) {
		this.jlc = jlc;
	}

	public java.math.BigDecimal getNtf() {
		return ntf;
	}

	public void setNtf(java.math.BigDecimal ntf) {
		this.ntf = ntf;
	}

	public java.math.BigDecimal getPmt() {
		return pmt;
	}

	public void setPmt(java.math.BigDecimal pmt) {
		this.pmt = pmt;
	}

	public java.lang.String getPdfDatAppYn() {
		return pdfDatAppYn;
	}

	public void setPdfDatAppYn(java.lang.String pdfDatAppYn) {
		this.pdfDatAppYn = pdfDatAppYn;
	}

	public java.lang.String getPdfDatAppCmplDt() {
		return pdfDatAppCmplDt;
	}

	public void setPdfDatAppCmplDt(java.lang.String pdfDatAppCmplDt) {
		this.pdfDatAppCmplDt = pdfDatAppCmplDt;
	}

	public java.lang.String getPdfDatAppExcCtnt() {
		return pdfDatAppExcCtnt;
	}

	public void setPdfDatAppExcCtnt(java.lang.String pdfDatAppExcCtnt) {
		this.pdfDatAppExcCtnt = pdfDatAppExcCtnt;
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
    
    
    
}
