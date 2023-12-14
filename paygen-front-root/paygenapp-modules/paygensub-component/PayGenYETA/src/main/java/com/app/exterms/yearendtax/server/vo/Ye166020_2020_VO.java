package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;


/**
 * @Class Name : Ye166020VO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye166020_2020_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 공제대상자가족주민등록번호 : famResnoEncCntn */
    private java.lang.String famResnoEncCntn;

    /** set 소득공제자료명세구분코드 : dataCd */
    private java.lang.String dataCd;

    /** set 공제대상자내외국인구분코드 : nnfCl */
    private java.lang.String nnfCl;

    /** set 공제대상자부양관계코드 : suptFmlyRltCl */
    private java.lang.String suptFmlyRltCl;

    /** set 공제대상자성명 : suptFmlyFnm */
    private java.lang.String suptFmlyFnm;

    /** set 공제대상자생년월일 : suptFmlyBhdt */
    private java.lang.String suptFmlyBhdt;

    /** set 신용카드등사용금액소계 : crdcUseAmtSum */
    private java.math.BigDecimal crdcUseAmtSum;

    /** set 신용카드등사용금액_신용카드 : crdcUseAmt */
    private java.math.BigDecimal crdcUseAmt;

    /** set 신용카드등사용금액_현금영수증 : cshptUseAmt */
    private java.math.BigDecimal cshptUseAmt;

    /** set 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
    private java.math.BigDecimal drtpCardUseAmt;
    
    /** set 신용카드등사용금액_제로페이 : zrtdUseAmt */
    private java.math.BigDecimal zrtdUseAmt;

    /** set 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
    private java.math.BigDecimal tdmrUseAmt;

    /** set 신용카드등사용금액_대중교통이용분 : etcUseAmt */
    private java.math.BigDecimal etcUseAmt;

    /** set 신용카드등사용금액_도서이용분 : bookShowAmt */
    private java.math.BigDecimal bookShowAmt;

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

	public java.lang.String getFamResnoEncCntn() {
		return famResnoEncCntn;
	}

	public void setFamResnoEncCntn(java.lang.String famResnoEncCntn) {
		this.famResnoEncCntn = famResnoEncCntn;
	}

	public java.lang.String getDataCd() {
		return dataCd;
	}

	public void setDataCd(java.lang.String dataCd) {
		this.dataCd = dataCd;
	}

	public java.lang.String getNnfCl() {
		return nnfCl;
	}

	public void setNnfCl(java.lang.String nnfCl) {
		this.nnfCl = nnfCl;
	}

	public java.lang.String getSuptFmlyRltCl() {
		return suptFmlyRltCl;
	}

	public void setSuptFmlyRltCl(java.lang.String suptFmlyRltCl) {
		this.suptFmlyRltCl = suptFmlyRltCl;
	}

	public java.lang.String getSuptFmlyFnm() {
		return suptFmlyFnm;
	}

	public void setSuptFmlyFnm(java.lang.String suptFmlyFnm) {
		this.suptFmlyFnm = suptFmlyFnm;
	}

	public java.lang.String getSuptFmlyBhdt() {
		return suptFmlyBhdt;
	}

	public void setSuptFmlyBhdt(java.lang.String suptFmlyBhdt) {
		this.suptFmlyBhdt = suptFmlyBhdt;
	}

	public java.math.BigDecimal getCrdcUseAmtSum() {
		return crdcUseAmtSum;
	}

	public void setCrdcUseAmtSum(java.math.BigDecimal crdcUseAmtSum) {
		this.crdcUseAmtSum = crdcUseAmtSum;
	}

	public java.math.BigDecimal getCrdcUseAmt() {
		return crdcUseAmt;
	}

	public void setCrdcUseAmt(java.math.BigDecimal crdcUseAmt) {
		this.crdcUseAmt = crdcUseAmt;
	}

	public java.math.BigDecimal getCshptUseAmt() {
		return cshptUseAmt;
	}

	public void setCshptUseAmt(java.math.BigDecimal cshptUseAmt) {
		this.cshptUseAmt = cshptUseAmt;
	}

	public java.math.BigDecimal getDrtpCardUseAmt() {
		return drtpCardUseAmt;
	}

	public void setDrtpCardUseAmt(java.math.BigDecimal drtpCardUseAmt) {
		this.drtpCardUseAmt = drtpCardUseAmt;
	}

	public java.math.BigDecimal getZrtdUseAmt() {
		return zrtdUseAmt;
	}

	public void setZrtdUseAmt(java.math.BigDecimal zrtdUseAmt) {
		this.zrtdUseAmt = zrtdUseAmt;
	}
	public java.math.BigDecimal getTdmrUseAmt() {
		return tdmrUseAmt;
	}

	public void setTdmrUseAmt(java.math.BigDecimal tdmrUseAmt) {
		this.tdmrUseAmt = tdmrUseAmt;
	}

	public java.math.BigDecimal getEtcUseAmt() {
		return etcUseAmt;
	}

	public void setEtcUseAmt(java.math.BigDecimal etcUseAmt) {
		this.etcUseAmt = etcUseAmt;
	}

	public java.math.BigDecimal getBookShowAmt() {
		return bookShowAmt;
	}

	public void setBookShowAmt(java.math.BigDecimal bookShowAmt) {
		this.bookShowAmt = bookShowAmt;
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
