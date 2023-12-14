package com.app.exterms.insurance.server.vo;

import java.io.Serializable;


/**
 * @Class Name : Insr5200VO.java
 * @Description : Insr5200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 납부년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 고용일련번호 : emymtSeilNum */
    private Long emymtSeilNum;

    /** set 부과년월 : iposYrMnth */
    private java.lang.String iposYrMnth;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 고용시작일자 : umytInsrBgnnDt */
    private java.lang.String umytInsrBgnnDt;

    /** set 고용종료일자 : umytInsrEndDt */
    private java.lang.String umytInsrEndDt;

    /** set 월평균보수월액 : mnthAvgPayMnthAmnt */
    private Long mnthAvgPayMnthAmnt;

    /** set 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
    private Long cmpttnWkppUneplrtSum;

    /** set 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
    private Long cmpttnEplrUneplrtSum;

    /** set 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
    private Long cmpttnEplrFncdsnInsurSum;

    /** set 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
    private Long recpttnWkppUneplrtSum;

    /** set 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
    private Long recpttnEplrUneplrtSum;

    /** set 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
    private Long recpttnEplrFncdsnSum;

    /** set 정산보수총액 : clutPayTotAmnt */
    private Long clutPayTotAmnt;

    /** set 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
    private Long clutWkppUneplrtSum;

    /** set 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
    private Long clutEplrUneplrtSum;

    /** set 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
    private Long clutEplrFncdsnSum;

    /** set 고용보험요율 : umytInsrApmrt */
    private Long umytInsrApmrt;

    /** set 급여산출고용보험금액 : payCalcEmymtInsurSum */
    private Long payCalcEmymtInsurSum;

    /** set 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
    private Long indvUneplrtPymtAggrSum;

    /** set 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
    private Long eplrUneplrtPymtAggrSum;

    /** set 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
    private Long eplrFncdsnAggrSum;

    /** set 고용보험급여공제년월 : umytPayrDducYrMnth */
    private java.lang.String umytPayrDducYrMnth;

    /** set 고용보험처리일자 : umytInsrPrcsDt */
    private java.lang.String umytInsrPrcsDt;

    /** set 고용보험처리여부 : umytInsrPrcsYn */
    private java.lang.String umytInsrPrcsYn;

    /** set 개인실업급여고용보험차액 : umytInsrPrmmSrd */
    private Long umytInsrPrmmSrd;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private Long divdPymt;

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

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDducYrMnth() {
		return dducYrMnth;
	}

	public void setDducYrMnth(java.lang.String dducYrMnth) {
		this.dducYrMnth = dducYrMnth;
	}

	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	public void setEmymtSeilNum(Long emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public java.lang.String getIposYrMnth() {
		return iposYrMnth;
	}

	public void setIposYrMnth(java.lang.String iposYrMnth) {
		this.iposYrMnth = iposYrMnth;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getUmytInsrBgnnDt() {
		return umytInsrBgnnDt;
	}

	public void setUmytInsrBgnnDt(java.lang.String umytInsrBgnnDt) {
		this.umytInsrBgnnDt = umytInsrBgnnDt;
	}

	public java.lang.String getUmytInsrEndDt() {
		return umytInsrEndDt;
	}

	public void setUmytInsrEndDt(java.lang.String umytInsrEndDt) {
		this.umytInsrEndDt = umytInsrEndDt;
	}

	public Long getMnthAvgPayMnthAmnt() {
		return mnthAvgPayMnthAmnt;
	}

	public void setMnthAvgPayMnthAmnt(Long mnthAvgPayMnthAmnt) {
		this.mnthAvgPayMnthAmnt = mnthAvgPayMnthAmnt;
	}

	public Long getCmpttnWkppUneplrtSum() {
		return cmpttnWkppUneplrtSum;
	}

	public void setCmpttnWkppUneplrtSum(Long cmpttnWkppUneplrtSum) {
		this.cmpttnWkppUneplrtSum = cmpttnWkppUneplrtSum;
	}

	public Long getCmpttnEplrUneplrtSum() {
		return cmpttnEplrUneplrtSum;
	}

	public void setCmpttnEplrUneplrtSum(Long cmpttnEplrUneplrtSum) {
		this.cmpttnEplrUneplrtSum = cmpttnEplrUneplrtSum;
	}

	public Long getCmpttnEplrFncdsnInsurSum() {
		return cmpttnEplrFncdsnInsurSum;
	}

	public void setCmpttnEplrFncdsnInsurSum(Long cmpttnEplrFncdsnInsurSum) {
		this.cmpttnEplrFncdsnInsurSum = cmpttnEplrFncdsnInsurSum;
	}

	public Long getRecpttnWkppUneplrtSum() {
		return recpttnWkppUneplrtSum;
	}

	public void setRecpttnWkppUneplrtSum(Long recpttnWkppUneplrtSum) {
		this.recpttnWkppUneplrtSum = recpttnWkppUneplrtSum;
	}

	public Long getRecpttnEplrUneplrtSum() {
		return recpttnEplrUneplrtSum;
	}

	public void setRecpttnEplrUneplrtSum(Long recpttnEplrUneplrtSum) {
		this.recpttnEplrUneplrtSum = recpttnEplrUneplrtSum;
	}

	public Long getRecpttnEplrFncdsnSum() {
		return recpttnEplrFncdsnSum;
	}

	public void setRecpttnEplrFncdsnSum(Long recpttnEplrFncdsnSum) {
		this.recpttnEplrFncdsnSum = recpttnEplrFncdsnSum;
	}

	public Long getClutPayTotAmnt() {
		return clutPayTotAmnt;
	}

	public void setClutPayTotAmnt(Long clutPayTotAmnt) {
		this.clutPayTotAmnt = clutPayTotAmnt;
	}

	public Long getClutWkppUneplrtSum() {
		return clutWkppUneplrtSum;
	}

	public void setClutWkppUneplrtSum(Long clutWkppUneplrtSum) {
		this.clutWkppUneplrtSum = clutWkppUneplrtSum;
	}

	public Long getClutEplrUneplrtSum() {
		return clutEplrUneplrtSum;
	}

	public void setClutEplrUneplrtSum(Long clutEplrUneplrtSum) {
		this.clutEplrUneplrtSum = clutEplrUneplrtSum;
	}

	public Long getClutEplrFncdsnSum() {
		return clutEplrFncdsnSum;
	}

	public void setClutEplrFncdsnSum(Long clutEplrFncdsnSum) {
		this.clutEplrFncdsnSum = clutEplrFncdsnSum;
	}

	public Long getUmytInsrApmrt() {
		return umytInsrApmrt;
	}

	public void setUmytInsrApmrt(Long umytInsrApmrt) {
		this.umytInsrApmrt = umytInsrApmrt;
	}

	public Long getPayCalcEmymtInsurSum() {
		return payCalcEmymtInsurSum;
	}

	public void setPayCalcEmymtInsurSum(Long payCalcEmymtInsurSum) {
		this.payCalcEmymtInsurSum = payCalcEmymtInsurSum;
	}

	public Long getIndvUneplrtPymtAggrSum() {
		return indvUneplrtPymtAggrSum;
	}

	public void setIndvUneplrtPymtAggrSum(Long indvUneplrtPymtAggrSum) {
		this.indvUneplrtPymtAggrSum = indvUneplrtPymtAggrSum;
	}

	public Long getEplrUneplrtPymtAggrSum() {
		return eplrUneplrtPymtAggrSum;
	}

	public void setEplrUneplrtPymtAggrSum(Long eplrUneplrtPymtAggrSum) {
		this.eplrUneplrtPymtAggrSum = eplrUneplrtPymtAggrSum;
	}

	public Long getEplrFncdsnAggrSum() {
		return eplrFncdsnAggrSum;
	}

	public void setEplrFncdsnAggrSum(Long eplrFncdsnAggrSum) {
		this.eplrFncdsnAggrSum = eplrFncdsnAggrSum;
	}

	public java.lang.String getUmytPayrDducYrMnth() {
		return umytPayrDducYrMnth;
	}

	public void setUmytPayrDducYrMnth(java.lang.String umytPayrDducYrMnth) {
		this.umytPayrDducYrMnth = umytPayrDducYrMnth;
	}

	public java.lang.String getUmytInsrPrcsDt() {
		return umytInsrPrcsDt;
	}

	public void setUmytInsrPrcsDt(java.lang.String umytInsrPrcsDt) {
		this.umytInsrPrcsDt = umytInsrPrcsDt;
	}

	public java.lang.String getUmytInsrPrcsYn() {
		return umytInsrPrcsYn;
	}

	public void setUmytInsrPrcsYn(java.lang.String umytInsrPrcsYn) {
		this.umytInsrPrcsYn = umytInsrPrcsYn;
	}

	public Long getUmytInsrPrmmSrd() {
		return umytInsrPrmmSrd;
	}

	public void setUmytInsrPrmmSrd(Long umytInsrPrmmSrd) {
		this.umytInsrPrmmSrd = umytInsrPrmmSrd;
	}

	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	public Long getDivdPymt() {
		return divdPymt;
	}

	public void setDivdPymt(Long divdPymt) {
		this.divdPymt = divdPymt;
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
