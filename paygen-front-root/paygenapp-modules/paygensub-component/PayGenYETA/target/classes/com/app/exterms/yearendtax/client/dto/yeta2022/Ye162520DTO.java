package com.app.exterms.yearendtax.client.dto.yeta2022;

import java.io.Serializable;


/**
 * @Class Name : Ye162520DTO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162520DTO  implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 연말정산귀속년도 : yrtxBlggYr */
	private java.lang.String yrtxBlggYr;

	/** set 정산구분코드 : clutSeptCd */
	private java.lang.String clutSeptCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 금전소비대차일련번호 : comrCalnSeilNum */
	private Long comrCalnSeilNum;
	
	/** set 국세청자료구분코드 : taxVvalKrnCd */
	private java.lang.String taxVvalKrnCd;
	

	/** set G16_금전소비대차_대주성명 : comrCdtrNm */
	private java.lang.String comrCdtrNm;

	/** set G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
	private java.lang.String comrCdtrResnRegnNum;

	/** set G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
	private java.lang.String comrCnttPridBgnnDt;

	/** set G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
	private java.lang.String comrCnttPridEndDt;

	/** set G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
	private Double comrLoanItrtRate;

	/** set G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
	private Long comrPclttAmtftAggr;

	/** set G22_금전소비대차_원금금액 : comrPrnilSum */
	private Long comrPrnilSum;

	/** set G23_금전소비대차_이자금액 : comrItrtSum */
	private Long comrItrtSum;

	/** set G24_금전소비대차_공제금액 : comrDducSum */
	private Long comrDducSum;

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

	public Long getComrCalnSeilNum() {
		return comrCalnSeilNum;
	}

	public void setComrCalnSeilNum(Long comrCalnSeilNum) {
		this.comrCalnSeilNum = comrCalnSeilNum;
	}

	public java.lang.String getComrCdtrNm() {
		return comrCdtrNm;
	}

	public void setComrCdtrNm(java.lang.String comrCdtrNm) {
		this.comrCdtrNm = comrCdtrNm;
	}

	public java.lang.String getComrCdtrResnRegnNum() {
		return comrCdtrResnRegnNum;
	}

	public void setComrCdtrResnRegnNum(java.lang.String comrCdtrResnRegnNum) {
		this.comrCdtrResnRegnNum = comrCdtrResnRegnNum;
	}

	public java.lang.String getComrCnttPridBgnnDt() {
		return comrCnttPridBgnnDt;
	}

	public void setComrCnttPridBgnnDt(java.lang.String comrCnttPridBgnnDt) {
		this.comrCnttPridBgnnDt = comrCnttPridBgnnDt;
	}

	public java.lang.String getComrCnttPridEndDt() {
		return comrCnttPridEndDt;
	}

	public void setComrCnttPridEndDt(java.lang.String comrCnttPridEndDt) {
		this.comrCnttPridEndDt = comrCnttPridEndDt;
	}

	public Double getComrLoanItrtRate() {
		return comrLoanItrtRate;
	}

	public void setComrLoanItrtRate(Double comrLoanItrtRate) {
		this.comrLoanItrtRate = comrLoanItrtRate;
	}

	public Long getComrPclttAmtftAggr() {
		return comrPclttAmtftAggr;
	}

	public void setComrPclttAmtftAggr(Long comrPclttAmtftAggr) {
		this.comrPclttAmtftAggr = comrPclttAmtftAggr;
	}

	public Long getComrPrnilSum() {
		return comrPrnilSum;
	}

	public void setComrPrnilSum(Long comrPrnilSum) {
		this.comrPrnilSum = comrPrnilSum;
	}

	public Long getComrItrtSum() {
		return comrItrtSum;
	}

	public void setComrItrtSum(Long comrItrtSum) {
		this.comrItrtSum = comrItrtSum;
	}

	public Long getComrDducSum() {
		return comrDducSum;
	}

	public void setComrDducSum(Long comrDducSum) {
		this.comrDducSum = comrDducSum;
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
