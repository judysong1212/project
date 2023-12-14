package com.app.smrmf.pkg.insr.insurance.service;

import java.io.Serializable;
import java.math.BigDecimal;
 
/**
 * 
* <pre>
* 4대 보험 처리에 따른 값을 가지고 있는 VO
* 1. 패키지명 : com.app.smrmf.pkg.insr.insurance.service
* 2. 타입명 : PkgInsrWorkVO.java
* 3. 작성일 : 2016. 12. 26. 오후 9:39:37
* 4. 작성자 : atres-pc
* 5. 설명 :
* </pre>
 */
public class PkgInsrAmntVO implements Serializable {
  
	private static final long serialVersionUID = 1L;
      

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 고지년월 : nofctYrMnth */
    private java.lang.String nofctYrMnth;

    /** set 고지차수 : nofctDspty */
    private BigDecimal nofctDspty;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** RESN_REGN_NUM 주민등록번호*/
    private java.lang.String resnRegnNum;

	/** set 고용일련번호 : emymtSeilNum */
    private BigDecimal  emymtSeilNum;

    /** set 공제년월 : hlthDducYrMnth */
    private java.lang.String hlthDducYrMnth;

    /** set 건강보험처리일자 : hlthInsrPrcsDt */
    private java.lang.String hlthInsrPrcsDt;

    /** set 건강보험처리여부 : hlthInsrPrcsYn */
    private java.lang.String hlthInsrPrcsYn;

    /** set 건강보험보험료차액 : hlthInsrPrmmSrd */
    private BigDecimal hlthInsrPrmmSrd;

    /** set 장기요양보험차액 : lgtmRcptnInsurSrd */
    private BigDecimal lgtmRcptnInsurSrd;

    /** set 건강보험정산보험료 : yrtxPrmm */
    private BigDecimal yrtxPrmm;

    /** set 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
    private BigDecimal lgtmRcptnYrtxPrmm;

    /** set 건강보험환급금이자 : hlthInsrRefdItrt */
    private BigDecimal hlthInsrRefdItrt;

    /** set 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
    private BigDecimal lgtmRcptnInsurRefdItrt;

    /** set 차액합계 : srdAggrSum */
    private BigDecimal srdAggrSum;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private BigDecimal divdPymt;
  
    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;
     

    /** set 국민 공제년월 : dducYrMnth */
    private java.lang.String natDducYrMnth;

    
    /** set 신고소득총액 : regrstIncmTotAmnt */
    private BigDecimal regrstIncmTotAmnt;

    /** set 결정기준소득월액 : deinStdIncmMnthAmnt */
    private BigDecimal deinStdIncmMnthAmnt;

    /** set 결정월보험료 : deinMnthPrmm */
    private BigDecimal deinMnthPrmm;

    /** set 본인부담액 : indvBrdnSum */
    private BigDecimal indvBrdnSum;

    /** set 본인소급보험료 : reattyQnty */
    private BigDecimal reattyQnty;

    /** set 본인정산보험료 : hmlfClutPrmm */
    private BigDecimal hmlfClutPrmm;

    /** set 본인보험료계 : hmlfPrmmAggr */
    private BigDecimal hmlfPrmmAggr;

    /** set 사업장부담액 : dpobBrdnSum */
    private BigDecimal dpobBrdnSum;

    /** set 사업자정산보험료 : busoprClutPrmm */
    private BigDecimal busoprClutPrmm;

    /** set 사업자소급보험료 : busoprReattyPrmm */
    private BigDecimal busoprReattyPrmm;

    /** set 사업자보험료계 : busoprPrmmAggr */
    private BigDecimal busoprPrmmAggr;

    /** set 본인납부보험료계 : aggr */
    private BigDecimal aggr;

    /** set 변동구분 : fluc */
    private java.lang.String fluc;

    /** set 취득월납부여부 : aqtnMnthPymtYn */
    private java.lang.String aqtnMnthPymtYn;

    /** set 변동일자 : flucDt */
    private java.lang.String flucDt;

    /** set 변동사유내용 : flucReasCtnt */
    private java.lang.String flucReasCtnt;

    /** set 공단직권결정여부 : pbcorpOautyDeinYn */
    private java.lang.String pbcorpOautyDeinYn; 

    /** set 국민연금급여공제년월 : natPayrDducYrMnth */
    private java.lang.String natPayrDducYrMnth;

    /** set 국민연금처리일자 : natInsrPrcsDt */
    private java.lang.String natInsrPrcsDt;

    /** set 국민연금처리여부 : natInsrPrcsYn */
    private java.lang.String natInsrPrcsYn;

    /** set 국민연금차액 : natInsrPrmmSrd */
    private BigDecimal natInsrPrmmSrd;
 
    /** set 국민연금기호번호 : natPennSymNum */
    private java.lang.String natPennSymNum;

	/** set 연금급여산출보험금액 : natPennPayCalcSum */
    private BigDecimal natPennPayCalcSum;

    /** set 고용 납부년월 : dducYrMnth */
    private java.lang.String wrkDducYrMnth; 
 
    /** set 월평균보수월액 : mnthAvgPayMnthAmnt */
    private BigDecimal mnthAvgPayMnthAmnt;

    /** set 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
    private BigDecimal cmpttnWkppUneplrtSum;

    /** set 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
    private BigDecimal cmpttnEplrUneplrtSum;

    /** set 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
    private BigDecimal cmpttnEplrFncdsnInsurSum;

    /** set 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
    private BigDecimal recpttnWkppUneplrtSum;

    /** set 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
    private BigDecimal recpttnEplrUneplrtSum;

    /** set 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
    private BigDecimal recpttnEplrFncdsnSum;

    /** set 정산보수총액 : clutPayTotAmnt */
    private BigDecimal clutPayTotAmnt;

    /** set 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
    private BigDecimal clutWkppUneplrtSum;

    /** set 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
    private BigDecimal clutEplrUneplrtSum;

    /** set 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
    private BigDecimal clutEplrFncdsnSum;

    /** set 고용보험요율 : umytInsrApmrt */
    private BigDecimal umytInsrApmrt;

    /** set 급여산출고용보험금액 : payCalcEmymtInsurSum */
    private BigDecimal payCalcEmymtInsurSum;

    /** set 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
    private BigDecimal indvUneplrtPymtAggrSum;

    /** set 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
    private BigDecimal eplrUneplrtPymtAggrSum;

    /** set 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
    private BigDecimal eplrFncdsnAggrSum;

    /** set 고용보험급여공제년월 : umytPayrDducYrMnth */
    private java.lang.String umytPayrDducYrMnth;

    /** set 고용보험처리일자 : umytInsrPrcsDt */
    private java.lang.String umytInsrPrcsDt;

    /** set 고용보험처리여부 : umytInsrPrcsYn */
    private java.lang.String umytInsrPrcsYn;

    /** set 개인실업급여고용보험차액 : umytInsrPrmmSrd */
    private BigDecimal umytInsrPrmmSrd;
    
    
    private BigDecimal hlthDducCnt;
    private BigDecimal   natPayrDducCnt;
    private BigDecimal  umytPayrDducCnt;
    
    

	/**
	 * Comment : 
	 * @fn BigDecimal getHlthDducCnt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the hlthDducCnt get
	 */
	public BigDecimal getHlthDducCnt() {
		return hlthDducCnt;
	}

	/**
	 * Comment : 
	 *@fn void setHlthDducCnt(BigDecimal hlthDducCnt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param hlthDducCnt the hlthDducCnt to set
	 */
	public void setHlthDducCnt(BigDecimal hlthDducCnt) {
		this.hlthDducCnt = hlthDducCnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getNatPayrDducCnt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the natPayrDducCnt get
	 */
	public BigDecimal getNatPayrDducCnt() {
		return natPayrDducCnt;
	}

	/**
	 * Comment : 
	 *@fn void setNatPayrDducCnt(BigDecimal natPayrDducCnt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param natPayrDducCnt the natPayrDducCnt to set
	 */
	public void setNatPayrDducCnt(BigDecimal natPayrDducCnt) {
		this.natPayrDducCnt = natPayrDducCnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getUmytPayrDducCnt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytPayrDducCnt get
	 */
	public BigDecimal getUmytPayrDducCnt() {
		return umytPayrDducCnt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytPayrDducCnt(BigDecimal umytPayrDducCnt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytPayrDducCnt the umytPayrDducCnt to set
	 */
	public void setUmytPayrDducCnt(BigDecimal umytPayrDducCnt) {
		this.umytPayrDducCnt = umytPayrDducCnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNofctYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the nofctYrMnth get
	 */
	public java.lang.String getNofctYrMnth() {
		return nofctYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setNofctYrMnth(java.lang.String nofctYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param nofctYrMnth the nofctYrMnth to set
	 */
	public void setNofctYrMnth(java.lang.String nofctYrMnth) {
		this.nofctYrMnth = nofctYrMnth;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getNofctDspty()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the nofctDspty get
	 */
	public BigDecimal getNofctDspty() {
		return nofctDspty;
	}

	/**
	 * Comment : 
	 *@fn void setNofctDspty(BigDecimal nofctDspty)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param nofctDspty the nofctDspty to set
	 */
	public void setNofctDspty(BigDecimal nofctDspty) {
		this.nofctDspty = nofctDspty;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getResnRegnNum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the resnRegnNum get
	 */
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param resnRegnNum the resnRegnNum to set
	 */
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHlthDducYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hlthDducYrMnth get
	 */
	public java.lang.String getHlthDducYrMnth() {
		return hlthDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setHlthDducYrMnth(java.lang.String hlthDducYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hlthDducYrMnth the hlthDducYrMnth to set
	 */
	public void setHlthDducYrMnth(java.lang.String hlthDducYrMnth) {
		this.hlthDducYrMnth = hlthDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHlthInsrPrcsDt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hlthInsrPrcsDt get
	 */
	public java.lang.String getHlthInsrPrcsDt() {
		return hlthInsrPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setHlthInsrPrcsDt(java.lang.String hlthInsrPrcsDt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hlthInsrPrcsDt the hlthInsrPrcsDt to set
	 */
	public void setHlthInsrPrcsDt(java.lang.String hlthInsrPrcsDt) {
		this.hlthInsrPrcsDt = hlthInsrPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHlthInsrPrcsYn()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hlthInsrPrcsYn get
	 */
	public java.lang.String getHlthInsrPrcsYn() {
		return hlthInsrPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setHlthInsrPrcsYn(java.lang.String hlthInsrPrcsYn)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hlthInsrPrcsYn the hlthInsrPrcsYn to set
	 */
	public void setHlthInsrPrcsYn(java.lang.String hlthInsrPrcsYn) {
		this.hlthInsrPrcsYn = hlthInsrPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getHlthInsrPrmmSrd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hlthInsrPrmmSrd get
	 */
	public BigDecimal getHlthInsrPrmmSrd() {
		return hlthInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 *@fn void setHlthInsrPrmmSrd(BigDecimal hlthInsrPrmmSrd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hlthInsrPrmmSrd the hlthInsrPrmmSrd to set
	 */
	public void setHlthInsrPrmmSrd(BigDecimal hlthInsrPrmmSrd) {
		this.hlthInsrPrmmSrd = hlthInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getLgtmRcptnInsurSrd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the lgtmRcptnInsurSrd get
	 */
	public BigDecimal getLgtmRcptnInsurSrd() {
		return lgtmRcptnInsurSrd;
	}

	/**
	 * Comment : 
	 *@fn void setLgtmRcptnInsurSrd(BigDecimal lgtmRcptnInsurSrd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param lgtmRcptnInsurSrd the lgtmRcptnInsurSrd to set
	 */
	public void setLgtmRcptnInsurSrd(BigDecimal lgtmRcptnInsurSrd) {
		this.lgtmRcptnInsurSrd = lgtmRcptnInsurSrd;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getYrtxPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the yrtxPrmm get
	 */
	public BigDecimal getYrtxPrmm() {
		return yrtxPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrmm(BigDecimal yrtxPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param yrtxPrmm the yrtxPrmm to set
	 */
	public void setYrtxPrmm(BigDecimal yrtxPrmm) {
		this.yrtxPrmm = yrtxPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getLgtmRcptnYrtxPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the lgtmRcptnYrtxPrmm get
	 */
	public BigDecimal getLgtmRcptnYrtxPrmm() {
		return lgtmRcptnYrtxPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setLgtmRcptnYrtxPrmm(BigDecimal lgtmRcptnYrtxPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param lgtmRcptnYrtxPrmm the lgtmRcptnYrtxPrmm to set
	 */
	public void setLgtmRcptnYrtxPrmm(BigDecimal lgtmRcptnYrtxPrmm) {
		this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getHlthInsrRefdItrt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hlthInsrRefdItrt get
	 */
	public BigDecimal getHlthInsrRefdItrt() {
		return hlthInsrRefdItrt;
	}

	/**
	 * Comment : 
	 *@fn void setHlthInsrRefdItrt(BigDecimal hlthInsrRefdItrt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hlthInsrRefdItrt the hlthInsrRefdItrt to set
	 */
	public void setHlthInsrRefdItrt(BigDecimal hlthInsrRefdItrt) {
		this.hlthInsrRefdItrt = hlthInsrRefdItrt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getLgtmRcptnInsurRefdItrt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the lgtmRcptnInsurRefdItrt get
	 */
	public BigDecimal getLgtmRcptnInsurRefdItrt() {
		return lgtmRcptnInsurRefdItrt;
	}

	/**
	 * Comment : 
	 *@fn void setLgtmRcptnInsurRefdItrt(BigDecimal lgtmRcptnInsurRefdItrt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param lgtmRcptnInsurRefdItrt the lgtmRcptnInsurRefdItrt to set
	 */
	public void setLgtmRcptnInsurRefdItrt(BigDecimal lgtmRcptnInsurRefdItrt) {
		this.lgtmRcptnInsurRefdItrt = lgtmRcptnInsurRefdItrt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getSrdAggrSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the srdAggrSum get
	 */
	public BigDecimal getSrdAggrSum() {
		return srdAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setSrdAggrSum(BigDecimal srdAggrSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param srdAggrSum the srdAggrSum to set
	 */
	public void setSrdAggrSum(BigDecimal srdAggrSum) {
		this.srdAggrSum = srdAggrSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymtDivCd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the divdPymtDivCd get
	 */
	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtDivCd(java.lang.String divdPymtDivCd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param divdPymtDivCd the divdPymtDivCd to set
	 */
	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getDivdPymt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the divdPymt get
	 */
	public BigDecimal getDivdPymt() {
		return divdPymt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymt(BigDecimal divdPymt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param divdPymt the divdPymt to set
	 */
	public void setDivdPymt(BigDecimal divdPymt) {
		this.divdPymt = divdPymt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}

	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatDducYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natDducYrMnth get
	 */
	public java.lang.String getNatDducYrMnth() {
		return natDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setNatDducYrMnth(java.lang.String natDducYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natDducYrMnth the natDducYrMnth to set
	 */
	public void setNatDducYrMnth(java.lang.String natDducYrMnth) {
		this.natDducYrMnth = natDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getRegrstIncmTotAmnt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the regrstIncmTotAmnt get
	 */
	public BigDecimal getRegrstIncmTotAmnt() {
		return regrstIncmTotAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setRegrstIncmTotAmnt(BigDecimal regrstIncmTotAmnt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param regrstIncmTotAmnt the regrstIncmTotAmnt to set
	 */
	public void setRegrstIncmTotAmnt(BigDecimal regrstIncmTotAmnt) {
		this.regrstIncmTotAmnt = regrstIncmTotAmnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getDeinStdIncmMnthAmnt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the deinStdIncmMnthAmnt get
	 */
	public BigDecimal getDeinStdIncmMnthAmnt() {
		return deinStdIncmMnthAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setDeinStdIncmMnthAmnt(BigDecimal deinStdIncmMnthAmnt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param deinStdIncmMnthAmnt the deinStdIncmMnthAmnt to set
	 */
	public void setDeinStdIncmMnthAmnt(BigDecimal deinStdIncmMnthAmnt) {
		this.deinStdIncmMnthAmnt = deinStdIncmMnthAmnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getDeinMnthPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the deinMnthPrmm get
	 */
	public BigDecimal getDeinMnthPrmm() {
		return deinMnthPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setDeinMnthPrmm(BigDecimal deinMnthPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param deinMnthPrmm the deinMnthPrmm to set
	 */
	public void setDeinMnthPrmm(BigDecimal deinMnthPrmm) {
		this.deinMnthPrmm = deinMnthPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getIndvBrdnSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the indvBrdnSum get
	 */
	public BigDecimal getIndvBrdnSum() {
		return indvBrdnSum;
	}

	/**
	 * Comment : 
	 *@fn void setIndvBrdnSum(BigDecimal indvBrdnSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param indvBrdnSum the indvBrdnSum to set
	 */
	public void setIndvBrdnSum(BigDecimal indvBrdnSum) {
		this.indvBrdnSum = indvBrdnSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getReattyQnty()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the reattyQnty get
	 */
	public BigDecimal getReattyQnty() {
		return reattyQnty;
	}

	/**
	 * Comment : 
	 *@fn void setReattyQnty(BigDecimal reattyQnty)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param reattyQnty the reattyQnty to set
	 */
	public void setReattyQnty(BigDecimal reattyQnty) {
		this.reattyQnty = reattyQnty;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getHmlfClutPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hmlfClutPrmm get
	 */
	public BigDecimal getHmlfClutPrmm() {
		return hmlfClutPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setHmlfClutPrmm(BigDecimal hmlfClutPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hmlfClutPrmm the hmlfClutPrmm to set
	 */
	public void setHmlfClutPrmm(BigDecimal hmlfClutPrmm) {
		this.hmlfClutPrmm = hmlfClutPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getHmlfPrmmAggr()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the hmlfPrmmAggr get
	 */
	public BigDecimal getHmlfPrmmAggr() {
		return hmlfPrmmAggr;
	}

	/**
	 * Comment : 
	 *@fn void setHmlfPrmmAggr(BigDecimal hmlfPrmmAggr)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param hmlfPrmmAggr the hmlfPrmmAggr to set
	 */
	public void setHmlfPrmmAggr(BigDecimal hmlfPrmmAggr) {
		this.hmlfPrmmAggr = hmlfPrmmAggr;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getDpobBrdnSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the dpobBrdnSum get
	 */
	public BigDecimal getDpobBrdnSum() {
		return dpobBrdnSum;
	}

	/**
	 * Comment : 
	 *@fn void setDpobBrdnSum(BigDecimal dpobBrdnSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param dpobBrdnSum the dpobBrdnSum to set
	 */
	public void setDpobBrdnSum(BigDecimal dpobBrdnSum) {
		this.dpobBrdnSum = dpobBrdnSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getBusoprClutPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the busoprClutPrmm get
	 */
	public BigDecimal getBusoprClutPrmm() {
		return busoprClutPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprClutPrmm(BigDecimal busoprClutPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param busoprClutPrmm the busoprClutPrmm to set
	 */
	public void setBusoprClutPrmm(BigDecimal busoprClutPrmm) {
		this.busoprClutPrmm = busoprClutPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getBusoprReattyPrmm()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the busoprReattyPrmm get
	 */
	public BigDecimal getBusoprReattyPrmm() {
		return busoprReattyPrmm;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprReattyPrmm(BigDecimal busoprReattyPrmm)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param busoprReattyPrmm the busoprReattyPrmm to set
	 */
	public void setBusoprReattyPrmm(BigDecimal busoprReattyPrmm) {
		this.busoprReattyPrmm = busoprReattyPrmm;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getBusoprPrmmAggr()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the busoprPrmmAggr get
	 */
	public BigDecimal getBusoprPrmmAggr() {
		return busoprPrmmAggr;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprPrmmAggr(BigDecimal busoprPrmmAggr)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param busoprPrmmAggr the busoprPrmmAggr to set
	 */
	public void setBusoprPrmmAggr(BigDecimal busoprPrmmAggr) {
		this.busoprPrmmAggr = busoprPrmmAggr;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getAggr()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the aggr get
	 */
	public BigDecimal getAggr() {
		return aggr;
	}

	/**
	 * Comment : 
	 *@fn void setAggr(BigDecimal aggr)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param aggr the aggr to set
	 */
	public void setAggr(BigDecimal aggr) {
		this.aggr = aggr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFluc()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the fluc get
	 */
	public java.lang.String getFluc() {
		return fluc;
	}

	/**
	 * Comment : 
	 *@fn void setFluc(java.lang.String fluc)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param fluc the fluc to set
	 */
	public void setFluc(java.lang.String fluc) {
		this.fluc = fluc;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAqtnMnthPymtYn()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the aqtnMnthPymtYn get
	 */
	public java.lang.String getAqtnMnthPymtYn() {
		return aqtnMnthPymtYn;
	}

	/**
	 * Comment : 
	 *@fn void setAqtnMnthPymtYn(java.lang.String aqtnMnthPymtYn)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param aqtnMnthPymtYn the aqtnMnthPymtYn to set
	 */
	public void setAqtnMnthPymtYn(java.lang.String aqtnMnthPymtYn) {
		this.aqtnMnthPymtYn = aqtnMnthPymtYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFlucDt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the flucDt get
	 */
	public java.lang.String getFlucDt() {
		return flucDt;
	}

	/**
	 * Comment : 
	 *@fn void setFlucDt(java.lang.String flucDt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param flucDt the flucDt to set
	 */
	public void setFlucDt(java.lang.String flucDt) {
		this.flucDt = flucDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFlucReasCtnt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the flucReasCtnt get
	 */
	public java.lang.String getFlucReasCtnt() {
		return flucReasCtnt;
	}

	/**
	 * Comment : 
	 *@fn void setFlucReasCtnt(java.lang.String flucReasCtnt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param flucReasCtnt the flucReasCtnt to set
	 */
	public void setFlucReasCtnt(java.lang.String flucReasCtnt) {
		this.flucReasCtnt = flucReasCtnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPbcorpOautyDeinYn()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the pbcorpOautyDeinYn get
	 */
	public java.lang.String getPbcorpOautyDeinYn() {
		return pbcorpOautyDeinYn;
	}

	/**
	 * Comment : 
	 *@fn void setPbcorpOautyDeinYn(java.lang.String pbcorpOautyDeinYn)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param pbcorpOautyDeinYn the pbcorpOautyDeinYn to set
	 */
	public void setPbcorpOautyDeinYn(java.lang.String pbcorpOautyDeinYn) {
		this.pbcorpOautyDeinYn = pbcorpOautyDeinYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatPayrDducYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natPayrDducYrMnth get
	 */
	public java.lang.String getNatPayrDducYrMnth() {
		return natPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setNatPayrDducYrMnth(java.lang.String natPayrDducYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natPayrDducYrMnth the natPayrDducYrMnth to set
	 */
	public void setNatPayrDducYrMnth(java.lang.String natPayrDducYrMnth) {
		this.natPayrDducYrMnth = natPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatInsrPrcsDt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natInsrPrcsDt get
	 */
	public java.lang.String getNatInsrPrcsDt() {
		return natInsrPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrcsDt(java.lang.String natInsrPrcsDt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natInsrPrcsDt the natInsrPrcsDt to set
	 */
	public void setNatInsrPrcsDt(java.lang.String natInsrPrcsDt) {
		this.natInsrPrcsDt = natInsrPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatInsrPrcsYn()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natInsrPrcsYn get
	 */
	public java.lang.String getNatInsrPrcsYn() {
		return natInsrPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrcsYn(java.lang.String natInsrPrcsYn)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natInsrPrcsYn the natInsrPrcsYn to set
	 */
	public void setNatInsrPrcsYn(java.lang.String natInsrPrcsYn) {
		this.natInsrPrcsYn = natInsrPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getNatInsrPrmmSrd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natInsrPrmmSrd get
	 */
	public BigDecimal getNatInsrPrmmSrd() {
		return natInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrmmSrd(BigDecimal natInsrPrmmSrd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natInsrPrmmSrd the natInsrPrmmSrd to set
	 */
	public void setNatInsrPrmmSrd(BigDecimal natInsrPrmmSrd) {
		this.natInsrPrmmSrd = natInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatPennSymNum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natPennSymNum get
	 */
	public java.lang.String getNatPennSymNum() {
		return natPennSymNum;
	}

	/**
	 * Comment : 
	 *@fn void setNatPennSymNum(java.lang.String natPennSymNum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natPennSymNum the natPennSymNum to set
	 */
	public void setNatPennSymNum(java.lang.String natPennSymNum) {
		this.natPennSymNum = natPennSymNum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getNatPennPayCalcSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the natPennPayCalcSum get
	 */
	public BigDecimal getNatPennPayCalcSum() {
		return natPennPayCalcSum;
	}

	/**
	 * Comment : 
	 *@fn void setNatPennPayCalcSum(BigDecimal natPennPayCalcSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param natPennPayCalcSum the natPennPayCalcSum to set
	 */
	public void setNatPennPayCalcSum(BigDecimal natPennPayCalcSum) {
		this.natPennPayCalcSum = natPennPayCalcSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWrkDducYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the wrkDducYrMnth get
	 */
	public java.lang.String getWrkDducYrMnth() {
		return wrkDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setWrkDducYrMnth(java.lang.String wrkDducYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param wrkDducYrMnth the wrkDducYrMnth to set
	 */
	public void setWrkDducYrMnth(java.lang.String wrkDducYrMnth) {
		this.wrkDducYrMnth = wrkDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getMnthAvgPayMnthAmnt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the mnthAvgPayMnthAmnt get
	 */
	public BigDecimal getMnthAvgPayMnthAmnt() {
		return mnthAvgPayMnthAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setMnthAvgPayMnthAmnt(BigDecimal mnthAvgPayMnthAmnt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param mnthAvgPayMnthAmnt the mnthAvgPayMnthAmnt to set
	 */
	public void setMnthAvgPayMnthAmnt(BigDecimal mnthAvgPayMnthAmnt) {
		this.mnthAvgPayMnthAmnt = mnthAvgPayMnthAmnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getCmpttnWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the cmpttnWkppUneplrtSum get
	 */
	public BigDecimal getCmpttnWkppUneplrtSum() {
		return cmpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnWkppUneplrtSum(BigDecimal cmpttnWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param cmpttnWkppUneplrtSum the cmpttnWkppUneplrtSum to set
	 */
	public void setCmpttnWkppUneplrtSum(BigDecimal cmpttnWkppUneplrtSum) {
		this.cmpttnWkppUneplrtSum = cmpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getCmpttnEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the cmpttnEplrUneplrtSum get
	 */
	public BigDecimal getCmpttnEplrUneplrtSum() {
		return cmpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnEplrUneplrtSum(BigDecimal cmpttnEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param cmpttnEplrUneplrtSum the cmpttnEplrUneplrtSum to set
	 */
	public void setCmpttnEplrUneplrtSum(BigDecimal cmpttnEplrUneplrtSum) {
		this.cmpttnEplrUneplrtSum = cmpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getCmpttnEplrFncdsnInsurSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the cmpttnEplrFncdsnInsurSum get
	 */
	public BigDecimal getCmpttnEplrFncdsnInsurSum() {
		return cmpttnEplrFncdsnInsurSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnEplrFncdsnInsurSum(BigDecimal cmpttnEplrFncdsnInsurSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param cmpttnEplrFncdsnInsurSum the cmpttnEplrFncdsnInsurSum to set
	 */
	public void setCmpttnEplrFncdsnInsurSum(BigDecimal cmpttnEplrFncdsnInsurSum) {
		this.cmpttnEplrFncdsnInsurSum = cmpttnEplrFncdsnInsurSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getRecpttnWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the recpttnWkppUneplrtSum get
	 */
	public BigDecimal getRecpttnWkppUneplrtSum() {
		return recpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnWkppUneplrtSum(BigDecimal recpttnWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param recpttnWkppUneplrtSum the recpttnWkppUneplrtSum to set
	 */
	public void setRecpttnWkppUneplrtSum(BigDecimal recpttnWkppUneplrtSum) {
		this.recpttnWkppUneplrtSum = recpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getRecpttnEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the recpttnEplrUneplrtSum get
	 */
	public BigDecimal getRecpttnEplrUneplrtSum() {
		return recpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnEplrUneplrtSum(BigDecimal recpttnEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param recpttnEplrUneplrtSum the recpttnEplrUneplrtSum to set
	 */
	public void setRecpttnEplrUneplrtSum(BigDecimal recpttnEplrUneplrtSum) {
		this.recpttnEplrUneplrtSum = recpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getRecpttnEplrFncdsnSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the recpttnEplrFncdsnSum get
	 */
	public BigDecimal getRecpttnEplrFncdsnSum() {
		return recpttnEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnEplrFncdsnSum(BigDecimal recpttnEplrFncdsnSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param recpttnEplrFncdsnSum the recpttnEplrFncdsnSum to set
	 */
	public void setRecpttnEplrFncdsnSum(BigDecimal recpttnEplrFncdsnSum) {
		this.recpttnEplrFncdsnSum = recpttnEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getClutPayTotAmnt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the clutPayTotAmnt get
	 */
	public BigDecimal getClutPayTotAmnt() {
		return clutPayTotAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setClutPayTotAmnt(BigDecimal clutPayTotAmnt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param clutPayTotAmnt the clutPayTotAmnt to set
	 */
	public void setClutPayTotAmnt(BigDecimal clutPayTotAmnt) {
		this.clutPayTotAmnt = clutPayTotAmnt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getClutWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the clutWkppUneplrtSum get
	 */
	public BigDecimal getClutWkppUneplrtSum() {
		return clutWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutWkppUneplrtSum(BigDecimal clutWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param clutWkppUneplrtSum the clutWkppUneplrtSum to set
	 */
	public void setClutWkppUneplrtSum(BigDecimal clutWkppUneplrtSum) {
		this.clutWkppUneplrtSum = clutWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getClutEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the clutEplrUneplrtSum get
	 */
	public BigDecimal getClutEplrUneplrtSum() {
		return clutEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutEplrUneplrtSum(BigDecimal clutEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param clutEplrUneplrtSum the clutEplrUneplrtSum to set
	 */
	public void setClutEplrUneplrtSum(BigDecimal clutEplrUneplrtSum) {
		this.clutEplrUneplrtSum = clutEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getClutEplrFncdsnSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the clutEplrFncdsnSum get
	 */
	public BigDecimal getClutEplrFncdsnSum() {
		return clutEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutEplrFncdsnSum(BigDecimal clutEplrFncdsnSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param clutEplrFncdsnSum the clutEplrFncdsnSum to set
	 */
	public void setClutEplrFncdsnSum(BigDecimal clutEplrFncdsnSum) {
		this.clutEplrFncdsnSum = clutEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getUmytInsrApmrt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the umytInsrApmrt get
	 */
	public BigDecimal getUmytInsrApmrt() {
		return umytInsrApmrt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrApmrt(BigDecimal umytInsrApmrt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param umytInsrApmrt the umytInsrApmrt to set
	 */
	public void setUmytInsrApmrt(BigDecimal umytInsrApmrt) {
		this.umytInsrApmrt = umytInsrApmrt;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getPayCalcEmymtInsurSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the payCalcEmymtInsurSum get
	 */
	public BigDecimal getPayCalcEmymtInsurSum() {
		return payCalcEmymtInsurSum;
	}

	/**
	 * Comment : 
	 *@fn void setPayCalcEmymtInsurSum(BigDecimal payCalcEmymtInsurSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param payCalcEmymtInsurSum the payCalcEmymtInsurSum to set
	 */
	public void setPayCalcEmymtInsurSum(BigDecimal payCalcEmymtInsurSum) {
		this.payCalcEmymtInsurSum = payCalcEmymtInsurSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getIndvUneplrtPymtAggrSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the indvUneplrtPymtAggrSum get
	 */
	public BigDecimal getIndvUneplrtPymtAggrSum() {
		return indvUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setIndvUneplrtPymtAggrSum(BigDecimal indvUneplrtPymtAggrSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param indvUneplrtPymtAggrSum the indvUneplrtPymtAggrSum to set
	 */
	public void setIndvUneplrtPymtAggrSum(BigDecimal indvUneplrtPymtAggrSum) {
		this.indvUneplrtPymtAggrSum = indvUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getEplrUneplrtPymtAggrSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the eplrUneplrtPymtAggrSum get
	 */
	public BigDecimal getEplrUneplrtPymtAggrSum() {
		return eplrUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setEplrUneplrtPymtAggrSum(BigDecimal eplrUneplrtPymtAggrSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param eplrUneplrtPymtAggrSum the eplrUneplrtPymtAggrSum to set
	 */
	public void setEplrUneplrtPymtAggrSum(BigDecimal eplrUneplrtPymtAggrSum) {
		this.eplrUneplrtPymtAggrSum = eplrUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getEplrFncdsnAggrSum()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the eplrFncdsnAggrSum get
	 */
	public BigDecimal getEplrFncdsnAggrSum() {
		return eplrFncdsnAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setEplrFncdsnAggrSum(BigDecimal eplrFncdsnAggrSum)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param eplrFncdsnAggrSum the eplrFncdsnAggrSum to set
	 */
	public void setEplrFncdsnAggrSum(BigDecimal eplrFncdsnAggrSum) {
		this.eplrFncdsnAggrSum = eplrFncdsnAggrSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytPayrDducYrMnth()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the umytPayrDducYrMnth get
	 */
	public java.lang.String getUmytPayrDducYrMnth() {
		return umytPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setUmytPayrDducYrMnth(java.lang.String umytPayrDducYrMnth)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param umytPayrDducYrMnth the umytPayrDducYrMnth to set
	 */
	public void setUmytPayrDducYrMnth(java.lang.String umytPayrDducYrMnth) {
		this.umytPayrDducYrMnth = umytPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrPrcsDt()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the umytInsrPrcsDt get
	 */
	public java.lang.String getUmytInsrPrcsDt() {
		return umytInsrPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrcsDt(java.lang.String umytInsrPrcsDt)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param umytInsrPrcsDt the umytInsrPrcsDt to set
	 */
	public void setUmytInsrPrcsDt(java.lang.String umytInsrPrcsDt) {
		this.umytInsrPrcsDt = umytInsrPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrPrcsYn()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the umytInsrPrcsYn get
	 */
	public java.lang.String getUmytInsrPrcsYn() {
		return umytInsrPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrcsYn(java.lang.String umytInsrPrcsYn)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param umytInsrPrcsYn the umytInsrPrcsYn to set
	 */
	public void setUmytInsrPrcsYn(java.lang.String umytInsrPrcsYn) {
		this.umytInsrPrcsYn = umytInsrPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getUmytInsrPrmmSrd()
	 * @brief date:2017 2017. 4. 6. user:paygen
	 * @return the umytInsrPrmmSrd get
	 */
	public BigDecimal getUmytInsrPrmmSrd() {
		return umytInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrmmSrd(BigDecimal umytInsrPrmmSrd)
	 *@brief date:2017 2017. 4. 6. user:paygen
	 *@param umytInsrPrmmSrd the umytInsrPrmmSrd to set
	 */
	public void setUmytInsrPrmmSrd(BigDecimal umytInsrPrmmSrd) {
		this.umytInsrPrmmSrd = umytInsrPrmmSrd;
	}
 
    
  

}
