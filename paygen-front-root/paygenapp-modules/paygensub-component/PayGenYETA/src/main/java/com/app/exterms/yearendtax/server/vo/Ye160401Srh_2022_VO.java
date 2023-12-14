package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta1000DefaultVO.java
 * @Description : Yeta1000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye160401Srh_2022_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 지급년월 : elctYymm */
    private java.lang.String elctYymm;

    /** set 급여지급일자 : elctDate */
    private java.lang.String elctDate;

    /** set 급여지급금액_과세 : suprTxam */
    private java.math.BigDecimal suprTxam;

    /** set 현근무지상여금_과세 : buamTxam */
    private java.math.BigDecimal buamTxam;

    /** set 현근무지인정상여금액 : inbsAmnt */
    private java.math.BigDecimal inbsAmnt;

    /** set 현근무지주식매수선택권행사이익금액 : stckInam */
    private java.math.BigDecimal stckInam;

    /** set 현근무지과세합계금액 : spbmTxam */
    private java.math.BigDecimal spbmTxam;

    /** set 외국인소득금액_과세 : ecinTxam */
    private java.math.BigDecimal ecinTxam;

    /** set 외국인소득금액_비과세 : taxmEcin */
    private java.math.BigDecimal taxmEcin;

    /** set 현근무지건강보험료금액 : spciHlth */
    private java.math.BigDecimal spciHlth;

    /** set 현근무지고용보험료금액 : spciEmpf */
    private java.math.BigDecimal spciEmpf;

    /** set 현근무지국민연금금액 : natnPsnf */
    private java.math.BigDecimal natnPsnf;

    /** set 현근무지소득세 : earnTaxn */
    private java.math.BigDecimal earnTaxn;

    /** set 현근무지지방소득세 : ihtxTaxn */
    private java.math.BigDecimal ihtxTaxn;

    /** set 현근무지기타금액_과세 : etccTxam */
    private java.math.BigDecimal etccTxam;

    /** set 현근무지기타금액_비과세 : etccEtam */
    private java.math.BigDecimal etccEtam;

    /** set 급여지급금액총액 : payPymtSumTotAmnt */
    private java.math.BigDecimal payPymtSumTotAmnt;

    /** set 급여지급금액_비과세 : payPymtFreeDtySum */
    private java.math.BigDecimal payPymtFreeDtySum;

    /** set 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
    private java.math.BigDecimal currWorkFreeDtusAmnt;

    /** set 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
    private java.math.BigDecimal currWorkEmptkWdrwSum;

    /** set 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
    private java.math.BigDecimal currWorkEcteRetceSum;

    /** set 현근무지요양보험료금액 : currWorkRcpInsurSum */
    private java.math.BigDecimal currWorkRcpInsurSum;

    /** set 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
    private java.math.BigDecimal currWorkRcpAggrSum;

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

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
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

	public java.lang.String getElctYymm() {
		return elctYymm;
	}

	public void setElctYymm(java.lang.String elctYymm) {
		this.elctYymm = elctYymm;
	}

	public java.lang.String getElctDate() {
		return elctDate;
	}

	public void setElctDate(java.lang.String elctDate) {
		this.elctDate = elctDate;
	}

	public java.math.BigDecimal getSuprTxam() {
		return suprTxam;
	}

	public void setSuprTxam(java.math.BigDecimal suprTxam) {
		this.suprTxam = suprTxam;
	}

	public java.math.BigDecimal getBuamTxam() {
		return buamTxam;
	}

	public void setBuamTxam(java.math.BigDecimal buamTxam) {
		this.buamTxam = buamTxam;
	}

	public java.math.BigDecimal getInbsAmnt() {
		return inbsAmnt;
	}

	public void setInbsAmnt(java.math.BigDecimal inbsAmnt) {
		this.inbsAmnt = inbsAmnt;
	}

	public java.math.BigDecimal getStckInam() {
		return stckInam;
	}

	public void setStckInam(java.math.BigDecimal stckInam) {
		this.stckInam = stckInam;
	}

	public java.math.BigDecimal getSpbmTxam() {
		return spbmTxam;
	}

	public void setSpbmTxam(java.math.BigDecimal spbmTxam) {
		this.spbmTxam = spbmTxam;
	}

	public java.math.BigDecimal getEcinTxam() {
		return ecinTxam;
	}

	public void setEcinTxam(java.math.BigDecimal ecinTxam) {
		this.ecinTxam = ecinTxam;
	}

	public java.math.BigDecimal getTaxmEcin() {
		return taxmEcin;
	}

	public void setTaxmEcin(java.math.BigDecimal taxmEcin) {
		this.taxmEcin = taxmEcin;
	}

	public java.math.BigDecimal getSpciHlth() {
		return spciHlth;
	}

	public void setSpciHlth(java.math.BigDecimal spciHlth) {
		this.spciHlth = spciHlth;
	}

	public java.math.BigDecimal getSpciEmpf() {
		return spciEmpf;
	}

	public void setSpciEmpf(java.math.BigDecimal spciEmpf) {
		this.spciEmpf = spciEmpf;
	}

	public java.math.BigDecimal getNatnPsnf() {
		return natnPsnf;
	}

	public void setNatnPsnf(java.math.BigDecimal natnPsnf) {
		this.natnPsnf = natnPsnf;
	}

	public java.math.BigDecimal getEarnTaxn() {
		return earnTaxn;
	}

	public void setEarnTaxn(java.math.BigDecimal earnTaxn) {
		this.earnTaxn = earnTaxn;
	}

	public java.math.BigDecimal getIhtxTaxn() {
		return ihtxTaxn;
	}

	public void setIhtxTaxn(java.math.BigDecimal ihtxTaxn) {
		this.ihtxTaxn = ihtxTaxn;
	}

	public java.math.BigDecimal getEtccTxam() {
		return etccTxam;
	}

	public void setEtccTxam(java.math.BigDecimal etccTxam) {
		this.etccTxam = etccTxam;
	}

	public java.math.BigDecimal getEtccEtam() {
		return etccEtam;
	}

	public void setEtccEtam(java.math.BigDecimal etccEtam) {
		this.etccEtam = etccEtam;
	}

	public java.math.BigDecimal getPayPymtSumTotAmnt() {
		return payPymtSumTotAmnt;
	}

	public void setPayPymtSumTotAmnt(java.math.BigDecimal payPymtSumTotAmnt) {
		this.payPymtSumTotAmnt = payPymtSumTotAmnt;
	}

	public java.math.BigDecimal getPayPymtFreeDtySum() {
		return payPymtFreeDtySum;
	}

	public void setPayPymtFreeDtySum(java.math.BigDecimal payPymtFreeDtySum) {
		this.payPymtFreeDtySum = payPymtFreeDtySum;
	}

	public java.math.BigDecimal getCurrWorkFreeDtusAmnt() {
		return currWorkFreeDtusAmnt;
	}

	public void setCurrWorkFreeDtusAmnt(java.math.BigDecimal currWorkFreeDtusAmnt) {
		this.currWorkFreeDtusAmnt = currWorkFreeDtusAmnt;
	}

	public java.math.BigDecimal getCurrWorkEmptkWdrwSum() {
		return currWorkEmptkWdrwSum;
	}

	public void setCurrWorkEmptkWdrwSum(java.math.BigDecimal currWorkEmptkWdrwSum) {
		this.currWorkEmptkWdrwSum = currWorkEmptkWdrwSum;
	}

	public java.math.BigDecimal getCurrWorkEcteRetceSum() {
		return currWorkEcteRetceSum;
	}

	public void setCurrWorkEcteRetceSum(java.math.BigDecimal currWorkEcteRetceSum) {
		this.currWorkEcteRetceSum = currWorkEcteRetceSum;
	}

	public java.math.BigDecimal getCurrWorkRcpInsurSum() {
		return currWorkRcpInsurSum;
	}

	public void setCurrWorkRcpInsurSum(java.math.BigDecimal currWorkRcpInsurSum) {
		this.currWorkRcpInsurSum = currWorkRcpInsurSum;
	}

	public java.math.BigDecimal getCurrWorkRcpAggrSum() {
		return currWorkRcpAggrSum;
	}

	public void setCurrWorkRcpAggrSum(java.math.BigDecimal currWorkRcpAggrSum) {
		this.currWorkRcpAggrSum = currWorkRcpAggrSum;
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
