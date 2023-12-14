package com.app.exterms.yearendtax.client.dto.yeta2017;

import java.io.Serializable;


/**
 * @Class Name : Ye162510DTO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162510DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 월세액소득공제일련번호 : mnthRntQntySeilNum */
    private Long mnthRntQntySeilNum;
    

	/** set 국세청자료구분코드 : taxVvalKrnCd */
	private java.lang.String taxVvalKrnCd;

    /** set G7_월세액_임대인성명 : mnthRnttyLehdrNm */
    private java.lang.String mnthRnttyLehdrNm;

    /** set G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
    private java.lang.String mnthRnttyBurRgsum;

    /** set G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
    private java.lang.String mnthRnttyHusFrmCd;

    /** set G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
    private Long mnthRnttyHusCnttArea;

    /** set G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
    private java.lang.String mnthRnttyRntlAddr;

    /** set G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
    private java.lang.String mnthRnttyRntlBgnnDt;

    /** set G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
    private java.lang.String mnthRnttyRntlEndDt;

    /** set G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
    private Long mnthRnttyYrlyMnthSum;

    /** set G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
    private Long mnthRnttyTxDducSum;

    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    private java.lang.String ectnFlTrnrCtlYn;

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
    
    

	public java.lang.String getTaxVvalKrnCd() {
		return taxVvalKrnCd;
	}

	public void setTaxVvalKrnCd(java.lang.String taxVvalKrnCd) {
		this.taxVvalKrnCd = taxVvalKrnCd;
	}

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

	public Long getMnthRntQntySeilNum() {
		return mnthRntQntySeilNum;
	}

	public void setMnthRntQntySeilNum(Long mnthRntQntySeilNum) {
		this.mnthRntQntySeilNum = mnthRntQntySeilNum;
	}

	public java.lang.String getMnthRnttyLehdrNm() {
		return mnthRnttyLehdrNm;
	}

	public void setMnthRnttyLehdrNm(java.lang.String mnthRnttyLehdrNm) {
		this.mnthRnttyLehdrNm = mnthRnttyLehdrNm;
	}

	public java.lang.String getMnthRnttyBurRgsum() {
		return mnthRnttyBurRgsum;
	}

	public void setMnthRnttyBurRgsum(java.lang.String mnthRnttyBurRgsum) {
		this.mnthRnttyBurRgsum = mnthRnttyBurRgsum;
	}

	public java.lang.String getMnthRnttyHusFrmCd() {
		return mnthRnttyHusFrmCd;
	}

	public void setMnthRnttyHusFrmCd(java.lang.String mnthRnttyHusFrmCd) {
		this.mnthRnttyHusFrmCd = mnthRnttyHusFrmCd;
	}

	public Long getMnthRnttyHusCnttArea() {
		return mnthRnttyHusCnttArea;
	}

	public void setMnthRnttyHusCnttArea(Long mnthRnttyHusCnttArea) {
		this.mnthRnttyHusCnttArea = mnthRnttyHusCnttArea;
	}

	public java.lang.String getMnthRnttyRntlAddr() {
		return mnthRnttyRntlAddr;
	}

	public void setMnthRnttyRntlAddr(java.lang.String mnthRnttyRntlAddr) {
		this.mnthRnttyRntlAddr = mnthRnttyRntlAddr;
	}

	public java.lang.String getMnthRnttyRntlBgnnDt() {
		return mnthRnttyRntlBgnnDt;
	}

	public void setMnthRnttyRntlBgnnDt(java.lang.String mnthRnttyRntlBgnnDt) {
		this.mnthRnttyRntlBgnnDt = mnthRnttyRntlBgnnDt;
	}

	public java.lang.String getMnthRnttyRntlEndDt() {
		return mnthRnttyRntlEndDt;
	}

	public void setMnthRnttyRntlEndDt(java.lang.String mnthRnttyRntlEndDt) {
		this.mnthRnttyRntlEndDt = mnthRnttyRntlEndDt;
	}

	public Long getMnthRnttyYrlyMnthSum() {
		return mnthRnttyYrlyMnthSum;
	}

	public void setMnthRnttyYrlyMnthSum(Long mnthRnttyYrlyMnthSum) {
		this.mnthRnttyYrlyMnthSum = mnthRnttyYrlyMnthSum;
	}

	public Long getMnthRnttyTxDducSum() {
		return mnthRnttyTxDducSum;
	}

	public void setMnthRnttyTxDducSum(Long mnthRnttyTxDducSum) {
		this.mnthRnttyTxDducSum = mnthRnttyTxDducSum;
	}

	public java.lang.String getEctnFlTrnrCtlYn() {
		return ectnFlTrnrCtlYn;
	}

	public void setEctnFlTrnrCtlYn(java.lang.String ectnFlTrnrCtlYn) {
		this.ectnFlTrnrCtlYn = ectnFlTrnrCtlYn;
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
