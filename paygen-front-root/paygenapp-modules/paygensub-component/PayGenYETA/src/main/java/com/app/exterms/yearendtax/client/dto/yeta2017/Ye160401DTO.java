package com.app.exterms.yearendtax.client.dto.yeta2017;

import java.io.Serializable;


/**
 * @Class Name : Ye160401DTO.java
 * @since : 2017. 12. 11. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye160401DTO  implements Serializable {
	
    private static final long serialVersionUID = 1L;
   
    /** set 지급년월 : elctYymm */
    private java.lang.String elctYymm;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set 급여지급일자 : elctDate */
    private java.lang.String elctDate;

    /** set 급여지급금액총액 : payPymtSumTotAmnt */
    private Long payPymtSumTotAmnt;

    /** set 급여지급금액_비과세 : payPymtFreeDtySum */
    private Long payPymtFreeDtySum;

    /** set 급여지급금액_과세 : suprTxam */
    private Long suprTxam;

    /** set 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
    private Long currWorkFreeDtusAmnt;

    /** set 현근무지상여금_과세 : buamTxam */
    private Long buamTxam;

    /** set 현근무지인정상여금액 : inbsAmnt */
    private Long inbsAmnt;

    /** set 현근무지주식매수선택권행사이익금액 : stckInam */
    private Long stckInam;

    /** set 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
    private Long currWorkEmptkWdrwSum;

    /** set 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
    private Long currWorkEcteRetceSum;

    /** set 외국인소득금액_과세 : ecinTxam */
    private Long ecinTxam;

    /** set 외국인소득금액_비과세 : taxmEcin */
    private Long taxmEcin;

    /** set 현근무지건강보험료금액 : spciHlth */
    private Long spciHlth;

    /** set 현근무지요양보험료금액 : currWorkRcpInsurSum */
    private Long currWorkRcpInsurSum;

    /** set 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
    private Long currWorkRcpAggrSum;

    /** set 현근무지고용보험료금액 : spciEmpf */
    private Long spciEmpf;

    /** set 현근무지국민연금금액 : natnPsnf */
    private Long natnPsnf;

    /** set 현근무지소득세 : earnTaxn */
    private Long earnTaxn;

    /** set 현근무지지방소득세 : ihtxTaxn */
    private Long ihtxTaxn;

    /** set 현근무지농특세금액 : nnksSsum */
    private Long nnksSsum;

    /** set 현근무지기타금액_과세 : etccTxam */
    private Long etccTxam;

    /** set 현근무지기타금액_비과세 : etccEtam */
    private Long etccEtam;

    /** set 현근무지과세합계금액 : spbmTxam */
    private Long spbmTxam;

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
    

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 당시_고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 당시_부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 당시_직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 당시_직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 당시_사업코드 : businCd */
    private java.lang.String businCd;

	public java.lang.String getElctYymm() {
		return elctYymm;
	}

	public void setElctYymm(java.lang.String elctYymm) {
		this.elctYymm = elctYymm;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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

	public java.lang.String getElctDate() {
		return elctDate;
	}

	public void setElctDate(java.lang.String elctDate) {
		this.elctDate = elctDate;
	}

	public Long getPayPymtSumTotAmnt() {
		return payPymtSumTotAmnt;
	}

	public void setPayPymtSumTotAmnt(Long payPymtSumTotAmnt) {
		this.payPymtSumTotAmnt = payPymtSumTotAmnt;
	}

	public Long getPayPymtFreeDtySum() {
		return payPymtFreeDtySum;
	}

	public void setPayPymtFreeDtySum(Long payPymtFreeDtySum) {
		this.payPymtFreeDtySum = payPymtFreeDtySum;
	}

	public Long getSuprTxam() {
		return suprTxam;
	}

	public void setSuprTxam(Long suprTxam) {
		this.suprTxam = suprTxam;
	}

	public Long getCurrWorkFreeDtusAmnt() {
		return currWorkFreeDtusAmnt;
	}

	public void setCurrWorkFreeDtusAmnt(Long currWorkFreeDtusAmnt) {
		this.currWorkFreeDtusAmnt = currWorkFreeDtusAmnt;
	}

	public Long getBuamTxam() {
		return buamTxam;
	}

	public void setBuamTxam(Long buamTxam) {
		this.buamTxam = buamTxam;
	}

	public Long getInbsAmnt() {
		return inbsAmnt;
	}

	public void setInbsAmnt(Long inbsAmnt) {
		this.inbsAmnt = inbsAmnt;
	}

	public Long getStckInam() {
		return stckInam;
	}

	public void setStckInam(Long stckInam) {
		this.stckInam = stckInam;
	}

	public Long getCurrWorkEmptkWdrwSum() {
		return currWorkEmptkWdrwSum;
	}

	public void setCurrWorkEmptkWdrwSum(Long currWorkEmptkWdrwSum) {
		this.currWorkEmptkWdrwSum = currWorkEmptkWdrwSum;
	}

	public Long getCurrWorkEcteRetceSum() {
		return currWorkEcteRetceSum;
	}

	public void setCurrWorkEcteRetceSum(Long currWorkEcteRetceSum) {
		this.currWorkEcteRetceSum = currWorkEcteRetceSum;
	}

	public Long getEcinTxam() {
		return ecinTxam;
	}

	public void setEcinTxam(Long ecinTxam) {
		this.ecinTxam = ecinTxam;
	}

	public Long getTaxmEcin() {
		return taxmEcin;
	}

	public void setTaxmEcin(Long taxmEcin) {
		this.taxmEcin = taxmEcin;
	}

	public Long getSpciHlth() {
		return spciHlth;
	}

	public void setSpciHlth(Long spciHlth) {
		this.spciHlth = spciHlth;
	}

	public Long getCurrWorkRcpInsurSum() {
		return currWorkRcpInsurSum;
	}

	public void setCurrWorkRcpInsurSum(Long currWorkRcpInsurSum) {
		this.currWorkRcpInsurSum = currWorkRcpInsurSum;
	}

	public Long getCurrWorkRcpAggrSum() {
		return currWorkRcpAggrSum;
	}

	public void setCurrWorkRcpAggrSum(Long currWorkRcpAggrSum) {
		this.currWorkRcpAggrSum = currWorkRcpAggrSum;
	}

	public Long getSpciEmpf() {
		return spciEmpf;
	}

	public void setSpciEmpf(Long spciEmpf) {
		this.spciEmpf = spciEmpf;
	}

	public Long getNatnPsnf() {
		return natnPsnf;
	}

	public void setNatnPsnf(Long natnPsnf) {
		this.natnPsnf = natnPsnf;
	}

	public Long getEarnTaxn() {
		return earnTaxn;
	}

	public void setEarnTaxn(Long earnTaxn) {
		this.earnTaxn = earnTaxn;
	}

	public Long getIhtxTaxn() {
		return ihtxTaxn;
	}

	public void setIhtxTaxn(Long ihtxTaxn) {
		this.ihtxTaxn = ihtxTaxn;
	}

	public Long getNnksSsum() {
		return nnksSsum;
	}

	public void setNnksSsum(Long nnksSsum) {
		this.nnksSsum = nnksSsum;
	}

	public Long getEtccTxam() {
		return etccTxam;
	}

	public void setEtccTxam(Long etccTxam) {
		this.etccTxam = etccTxam;
	}

	public Long getEtccEtam() {
		return etccEtam;
	}

	public void setEtccEtam(Long etccEtam) {
		this.etccEtam = etccEtam;
	}

	public Long getSpbmTxam() {
		return spbmTxam;
	}

	public void setSpbmTxam(Long spbmTxam) {
		this.spbmTxam = spbmTxam;
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

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

    
}
