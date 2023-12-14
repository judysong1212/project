package com.app.smrmf.infc.retirement.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Remt2000VO.java
 * @Description : Remt2000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgRemt2000VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;
    
    /** set 퇴직정산구분 : calcSevePayPsnDivNm */
    private java.lang.String calcSevePayPsnDivNm;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직위코드 : inbyCd */
    private java.lang.String inbyCd;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 성명 : nm */
    private java.lang.String nm;

    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;

/** set 기산일자 : rkfcdDt */
private java.lang.String rkfcdDt;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 근속년수 : logSvcYrNum */
    private java.math.BigDecimal logSvcYrNum;

    /** set 근속월수 : logSvcMnthIcm */
    private java.math.BigDecimal logSvcMnthIcm;

    /** set 군경력근속년수 : amcrrLogSvcYrNum */
    private java.math.BigDecimal amcrrLogSvcYrNum;

    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
    private java.math.BigDecimal amcrrLogSvcMnthIcm;

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    private java.math.BigDecimal eepnMnthIcm2012Bfr;

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    private java.math.BigDecimal eepnMnthIcm2013Aft;

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    private java.math.BigDecimal addMnthIcm2012Bfr;

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    private java.math.BigDecimal addMnthIcm2013Aft;

    /** set 근속일수 : logSvcNumDys */
    private java.math.BigDecimal logSvcNumDys;
    

/** set 제외일수 : eepnDayIcmDys */
private java.math.BigDecimal eepnDayIcmDys;

    /** set 군경력근무일수 : amcrrLogSvcNumDys */
    private java.math.BigDecimal amcrrLogSvcNumDys;
    

/** set 실근무년수 : turtyDutyYrNum */
private java.math.BigDecimal turtyDutyYrNum;

/** set 실근무개월수 : turtyDutyMnthNum */
private java.math.BigDecimal turtyDutyMnthNum;

/** set 실근무일수 : turtyDutyNumDys */
private java.math.BigDecimal turtyDutyNumDys;


    /** set 급여산정시작일자 : payCmpttnBgnnDt */
    private java.lang.String payCmpttnBgnnDt;

    /** set 급여산정종료일자 : payCmpttnEndDt */
    private java.lang.String payCmpttnEndDt;

    /** set 기본급여합계금액 : fndtnPayAggrSumSum */
    private java.math.BigDecimal fndtnPayAggrSumSum;

    /** set 제수당합계금액 : snryAllwAggrSum */
    private java.math.BigDecimal snryAllwAggrSum;

    /** set 후생복지비합계금액 : welfWelfSpdgAggrSum */
    private java.math.BigDecimal welfWelfSpdgAggrSum;

    /** set 3월간후생복지비 : marPubcWelfAmnt */
    private java.math.BigDecimal marPubcWelfAmnt;

    /** set 3월간총임금액 : marTotAmntWag */
    private java.math.BigDecimal marTotAmntWag;

    /** set 1일평균임금액 : dayAvgAmntWag */
    private java.math.BigDecimal dayAvgAmntWag;

    /** set 퇴직금산정금액 : sevePayCmpttnSum */
    private java.math.BigDecimal sevePayCmpttnSum;

    /** set 퇴직금가산금액 : sevePayAddSum */
    private java.math.BigDecimal sevePayAddSum;

    /** set 퇴직금가산율 : sevePayAddRate */
    private java.math.BigDecimal sevePayAddRate;

    /** set 퇴직금가산적용금액 : sevePayAddApptnSum */
    private java.math.BigDecimal sevePayAddApptnSum;

    /** set 군경력정산포함여부 : amcrrClutInsnYn */
    private java.lang.String amcrrClutInsnYn;

    /** set 군경력가산적용금액 : amcrrAddApptnSum */
    private java.math.BigDecimal amcrrAddApptnSum;

    /** set 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
    private java.math.BigDecimal sevePayCmpttnFreeDtySum;

    /** set 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
    private java.math.BigDecimal sevePayCmpttnTxtnSum;

    /** set 퇴직금지급공제금액 : sevePayPymtDducSum */
    private java.math.BigDecimal sevePayPymtDducSum;

    /** set 퇴직금실지급금액 : sevePayTurtyPymtSum */
    private java.math.BigDecimal sevePayTurtyPymtSum;

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    private java.lang.String sevePayNoteCtnt;

    /** set 퇴직금지급일자 : sevePayPymtDt */
    private java.lang.String sevePayPymtDt;

    /** set 퇴직금지급여부 : sevePayPymtYn */
    private java.lang.String sevePayPymtYn;

    /** set 마감여부 : ddlneYn */
    private java.lang.String ddlneYn;

    /** set 마감일시 : ddlneDt */
    private java.lang.String ddlneDt;

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

    /** set 총근무일수 : totLogSvcNumDys */
    private java.math.BigDecimal totLogSvcNumDys;

    /** set 퇴직금지급액 : sevePayPymtSum */
    private java.math.BigDecimal sevePayPymtSum;
      
    
    /** set 정산년 : clutYr */
    private java.lang.String clutYr;
    
    /** set 정산월 : clutMnth */
    private java.lang.String clutMnth;
 
    /** set 고용구분 : emymtDivNm */
    private java.lang.String emymtDivNm;
 
    /** set 부서코드 : deptNm */
    private java.lang.String deptNm;
 

    /** set 직종 : typOccuNm */
    private java.lang.String typOccuNm;
 
    /** set 호봉등급 : pyspGrdeNm */
    private java.lang.String pyspGrdeNm;

    
    /** set 직종세구분 : dtilOccuClsDivNm */
    private java.lang.String dtilOccuClsDivNm;
 
    /** set 사업 : businNm */
    private java.lang.String businNm;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

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

	public java.lang.String getCalcSevePayPsnDivCd() {
		return calcSevePayPsnDivCd;
	}

	public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
		this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
	}

	public java.lang.String getCalcSevePayPsnDivNm() {
		return calcSevePayPsnDivNm;
	}

	public void setCalcSevePayPsnDivNm(java.lang.String calcSevePayPsnDivNm) {
		this.calcSevePayPsnDivNm = calcSevePayPsnDivNm;
	}

	public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
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

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getInbyCd() {
		return inbyCd;
	}

	public void setInbyCd(java.lang.String inbyCd) {
		this.inbyCd = inbyCd;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}

	public java.lang.String getLogSvcMnthIcmCd() {
		return logSvcMnthIcmCd;
	}

	public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
		this.logSvcMnthIcmCd = logSvcMnthIcmCd;
	}

	public java.lang.String getNm() {
		return nm;
	}

	public void setNm(java.lang.String nm) {
		this.nm = nm;
	}

	public java.lang.String getIcncDt() {
		return icncDt;
	}

	public void setIcncDt(java.lang.String icncDt) {
		this.icncDt = icncDt;
	}

	public java.lang.String getRkfcdDt() {
		return rkfcdDt;
	}

	public void setRkfcdDt(java.lang.String rkfcdDt) {
		this.rkfcdDt = rkfcdDt;
	}

	public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	public java.math.BigDecimal getLogSvcYrNum() {
		return logSvcYrNum;
	}

	public void setLogSvcYrNum(java.math.BigDecimal logSvcYrNum) {
		this.logSvcYrNum = logSvcYrNum;
	}

	public java.math.BigDecimal getLogSvcMnthIcm() {
		return logSvcMnthIcm;
	}

	public void setLogSvcMnthIcm(java.math.BigDecimal logSvcMnthIcm) {
		this.logSvcMnthIcm = logSvcMnthIcm;
	}

	public java.math.BigDecimal getAmcrrLogSvcYrNum() {
		return amcrrLogSvcYrNum;
	}

	public void setAmcrrLogSvcYrNum(java.math.BigDecimal amcrrLogSvcYrNum) {
		this.amcrrLogSvcYrNum = amcrrLogSvcYrNum;
	}

	public java.math.BigDecimal getAmcrrLogSvcMnthIcm() {
		return amcrrLogSvcMnthIcm;
	}

	public void setAmcrrLogSvcMnthIcm(java.math.BigDecimal amcrrLogSvcMnthIcm) {
		this.amcrrLogSvcMnthIcm = amcrrLogSvcMnthIcm;
	}

	public java.math.BigDecimal getEepnMnthIcm2012Bfr() {
		return eepnMnthIcm2012Bfr;
	}

	public void setEepnMnthIcm2012Bfr(java.math.BigDecimal eepnMnthIcm2012Bfr) {
		this.eepnMnthIcm2012Bfr = eepnMnthIcm2012Bfr;
	}

	public java.math.BigDecimal getEepnMnthIcm2013Aft() {
		return eepnMnthIcm2013Aft;
	}

	public void setEepnMnthIcm2013Aft(java.math.BigDecimal eepnMnthIcm2013Aft) {
		this.eepnMnthIcm2013Aft = eepnMnthIcm2013Aft;
	}

	public java.math.BigDecimal getAddMnthIcm2012Bfr() {
		return addMnthIcm2012Bfr;
	}

	public void setAddMnthIcm2012Bfr(java.math.BigDecimal addMnthIcm2012Bfr) {
		this.addMnthIcm2012Bfr = addMnthIcm2012Bfr;
	}

	public java.math.BigDecimal getAddMnthIcm2013Aft() {
		return addMnthIcm2013Aft;
	}

	public void setAddMnthIcm2013Aft(java.math.BigDecimal addMnthIcm2013Aft) {
		this.addMnthIcm2013Aft = addMnthIcm2013Aft;
	}

	public java.math.BigDecimal getLogSvcNumDys() {
		return logSvcNumDys;
	}

	public void setLogSvcNumDys(java.math.BigDecimal logSvcNumDys) {
		this.logSvcNumDys = logSvcNumDys;
	}

	public java.math.BigDecimal getEepnDayIcmDys() {
		return eepnDayIcmDys;
	}

	public void setEepnDayIcmDys(java.math.BigDecimal eepnDayIcmDys) {
		this.eepnDayIcmDys = eepnDayIcmDys;
	}

	public java.math.BigDecimal getAmcrrLogSvcNumDys() {
		return amcrrLogSvcNumDys;
	}

	public void setAmcrrLogSvcNumDys(java.math.BigDecimal amcrrLogSvcNumDys) {
		this.amcrrLogSvcNumDys = amcrrLogSvcNumDys;
	}

	public java.math.BigDecimal getTurtyDutyYrNum() {
		return turtyDutyYrNum;
	}

	public void setTurtyDutyYrNum(java.math.BigDecimal turtyDutyYrNum) {
		this.turtyDutyYrNum = turtyDutyYrNum;
	}

	public java.math.BigDecimal getTurtyDutyMnthNum() {
		return turtyDutyMnthNum;
	}

	public void setTurtyDutyMnthNum(java.math.BigDecimal turtyDutyMnthNum) {
		this.turtyDutyMnthNum = turtyDutyMnthNum;
	}

	public java.math.BigDecimal getTurtyDutyNumDys() {
		return turtyDutyNumDys;
	}

	public void setTurtyDutyNumDys(java.math.BigDecimal turtyDutyNumDys) {
		this.turtyDutyNumDys = turtyDutyNumDys;
	}

	public java.lang.String getPayCmpttnBgnnDt() {
		return payCmpttnBgnnDt;
	}

	public void setPayCmpttnBgnnDt(java.lang.String payCmpttnBgnnDt) {
		this.payCmpttnBgnnDt = payCmpttnBgnnDt;
	}

	public java.lang.String getPayCmpttnEndDt() {
		return payCmpttnEndDt;
	}

	public void setPayCmpttnEndDt(java.lang.String payCmpttnEndDt) {
		this.payCmpttnEndDt = payCmpttnEndDt;
	}

	public java.math.BigDecimal getFndtnPayAggrSumSum() {
		return fndtnPayAggrSumSum;
	}

	public void setFndtnPayAggrSumSum(java.math.BigDecimal fndtnPayAggrSumSum) {
		this.fndtnPayAggrSumSum = fndtnPayAggrSumSum;
	}

	public java.math.BigDecimal getSnryAllwAggrSum() {
		return snryAllwAggrSum;
	}

	public void setSnryAllwAggrSum(java.math.BigDecimal snryAllwAggrSum) {
		this.snryAllwAggrSum = snryAllwAggrSum;
	}

	public java.math.BigDecimal getWelfWelfSpdgAggrSum() {
		return welfWelfSpdgAggrSum;
	}

	public void setWelfWelfSpdgAggrSum(java.math.BigDecimal welfWelfSpdgAggrSum) {
		this.welfWelfSpdgAggrSum = welfWelfSpdgAggrSum;
	}

	public java.math.BigDecimal getMarPubcWelfAmnt() {
		return marPubcWelfAmnt;
	}

	public void setMarPubcWelfAmnt(java.math.BigDecimal marPubcWelfAmnt) {
		this.marPubcWelfAmnt = marPubcWelfAmnt;
	}

	public java.math.BigDecimal getMarTotAmntWag() {
		return marTotAmntWag;
	}

	public void setMarTotAmntWag(java.math.BigDecimal marTotAmntWag) {
		this.marTotAmntWag = marTotAmntWag;
	}

	public java.math.BigDecimal getDayAvgAmntWag() {
		return dayAvgAmntWag;
	}

	public void setDayAvgAmntWag(java.math.BigDecimal dayAvgAmntWag) {
		this.dayAvgAmntWag = dayAvgAmntWag;
	}

	public java.math.BigDecimal getSevePayCmpttnSum() {
		return sevePayCmpttnSum;
	}

	public void setSevePayCmpttnSum(java.math.BigDecimal sevePayCmpttnSum) {
		this.sevePayCmpttnSum = sevePayCmpttnSum;
	}

	public java.math.BigDecimal getSevePayAddSum() {
		return sevePayAddSum;
	}

	public void setSevePayAddSum(java.math.BigDecimal sevePayAddSum) {
		this.sevePayAddSum = sevePayAddSum;
	}

	public java.math.BigDecimal getSevePayAddRate() {
		return sevePayAddRate;
	}

	public void setSevePayAddRate(java.math.BigDecimal sevePayAddRate) {
		this.sevePayAddRate = sevePayAddRate;
	}

	public java.math.BigDecimal getSevePayAddApptnSum() {
		return sevePayAddApptnSum;
	}

	public void setSevePayAddApptnSum(java.math.BigDecimal sevePayAddApptnSum) {
		this.sevePayAddApptnSum = sevePayAddApptnSum;
	}

	public java.lang.String getAmcrrClutInsnYn() {
		return amcrrClutInsnYn;
	}

	public void setAmcrrClutInsnYn(java.lang.String amcrrClutInsnYn) {
		this.amcrrClutInsnYn = amcrrClutInsnYn;
	}

	public java.math.BigDecimal getAmcrrAddApptnSum() {
		return amcrrAddApptnSum;
	}

	public void setAmcrrAddApptnSum(java.math.BigDecimal amcrrAddApptnSum) {
		this.amcrrAddApptnSum = amcrrAddApptnSum;
	}

	public java.math.BigDecimal getSevePayCmpttnFreeDtySum() {
		return sevePayCmpttnFreeDtySum;
	}

	public void setSevePayCmpttnFreeDtySum(
			java.math.BigDecimal sevePayCmpttnFreeDtySum) {
		this.sevePayCmpttnFreeDtySum = sevePayCmpttnFreeDtySum;
	}

	public java.math.BigDecimal getSevePayCmpttnTxtnSum() {
		return sevePayCmpttnTxtnSum;
	}

	public void setSevePayCmpttnTxtnSum(java.math.BigDecimal sevePayCmpttnTxtnSum) {
		this.sevePayCmpttnTxtnSum = sevePayCmpttnTxtnSum;
	}

	public java.math.BigDecimal getSevePayPymtDducSum() {
		return sevePayPymtDducSum;
	}

	public void setSevePayPymtDducSum(java.math.BigDecimal sevePayPymtDducSum) {
		this.sevePayPymtDducSum = sevePayPymtDducSum;
	}

	public java.math.BigDecimal getSevePayTurtyPymtSum() {
		return sevePayTurtyPymtSum;
	}

	public void setSevePayTurtyPymtSum(java.math.BigDecimal sevePayTurtyPymtSum) {
		this.sevePayTurtyPymtSum = sevePayTurtyPymtSum;
	}

	public java.lang.String getSevePayNoteCtnt() {
		return sevePayNoteCtnt;
	}

	public void setSevePayNoteCtnt(java.lang.String sevePayNoteCtnt) {
		this.sevePayNoteCtnt = sevePayNoteCtnt;
	}

	public java.lang.String getSevePayPymtDt() {
		return sevePayPymtDt;
	}

	public void setSevePayPymtDt(java.lang.String sevePayPymtDt) {
		this.sevePayPymtDt = sevePayPymtDt;
	}

	public java.lang.String getSevePayPymtYn() {
		return sevePayPymtYn;
	}

	public void setSevePayPymtYn(java.lang.String sevePayPymtYn) {
		this.sevePayPymtYn = sevePayPymtYn;
	}

	public java.lang.String getDdlneYn() {
		return ddlneYn;
	}

	public void setDdlneYn(java.lang.String ddlneYn) {
		this.ddlneYn = ddlneYn;
	}

	public java.lang.String getDdlneDt() {
		return ddlneDt;
	}

	public void setDdlneDt(java.lang.String ddlneDt) {
		this.ddlneDt = ddlneDt;
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

	public java.math.BigDecimal getTotLogSvcNumDys() {
		return totLogSvcNumDys;
	}

	public void setTotLogSvcNumDys(java.math.BigDecimal totLogSvcNumDys) {
		this.totLogSvcNumDys = totLogSvcNumDys;
	}

	public java.math.BigDecimal getSevePayPymtSum() {
		return sevePayPymtSum;
	}

	public void setSevePayPymtSum(java.math.BigDecimal sevePayPymtSum) {
		this.sevePayPymtSum = sevePayPymtSum;
	}

	public java.lang.String getClutYr() {
		return clutYr;
	}

	public void setClutYr(java.lang.String clutYr) {
		this.clutYr = clutYr;
	}

	public java.lang.String getClutMnth() {
		return clutMnth;
	}

	public void setClutMnth(java.lang.String clutMnth) {
		this.clutMnth = clutMnth;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
    
//    
//    /** set 사업장코드 : dpobCd */
//    private java.lang.String dpobCd;
//
//    /** set SYSTEMKEY : systemkey */
//    private java.lang.String systemkey;
//
//    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
//    private java.lang.String calcSevePayPsnDivCd;
//    
//    /** set 퇴직정산구분 : calcSevePayPsnDivNm */
//    private java.lang.String calcSevePayPsnDivNm;
//
//    /** set 정산년월 : clutYrMnth */
//    private java.lang.String clutYrMnth;
//
//    /** set 고용구분코드 : emymtDivCd */
//    private java.lang.String emymtDivCd;
//
//    /** set 부서코드 : deptCd */
//    private java.lang.String deptCd;
//
//    /** set 직종코드 : typOccuCd */
//    private java.lang.String typOccuCd;
//
//    /** set 호봉등급코드 : pyspGrdeCd */
//    private java.lang.String pyspGrdeCd;
//
//    /** set 직종세구분코드 : dtilOccuClsDivCd */
//    private java.lang.String dtilOccuClsDivCd;
//
//    /** set 사업코드 : businCd */
//    private java.lang.String businCd;
//
//    /** set 직위코드 : inbyCd */
//    private java.lang.String inbyCd;
//
//    /** set 호봉코드 : pyspCd */
//    private java.lang.String pyspCd;
//
//    /** set 근속년수코드 : logSvcYrNumCd */
//    private java.lang.String logSvcYrNumCd;
//
//    /** set 근속월수코드 : logSvcMnthIcmCd */
//    private java.lang.String logSvcMnthIcmCd;
//
//    /** set 성명 : nm */
//    private java.lang.String nm;
//
//    /** set 입사일자 : icncDt */
//    private java.lang.String icncDt;
//
///** set 기산일자 : rkfcdDt */
//private java.lang.String rkfcdDt;
//
//    /** set 퇴직일자 : retryDt */
//    private java.lang.String retryDt;
//
//    /** set 근속년수 : logSvcYrNum */
//    private java.math.BigDecimal logSvcYrNum;
//
//    /** set 근속월수 : logSvcMnthIcm */
//    private java.math.BigDecimal logSvcMnthIcm;
//
//    /** set 군경력근속년수 : amcrrLogSvcYrNum */
//    private java.math.BigDecimal amcrrLogSvcYrNum;
//
//    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
//    private java.math.BigDecimal amcrrLogSvcMnthIcm;
//
//    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//    private java.math.BigDecimal eepnMnthIcm2012Bfr;
//
//    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
//    private java.math.BigDecimal eepnMnthIcm2013Aft;
//
//    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
//    private java.math.BigDecimal addMnthIcm2012Bfr;
//
//    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
//    private java.math.BigDecimal addMnthIcm2013Aft;
//
//    /** set 근속일수 : logSvcNumDys */
//    private java.math.BigDecimal logSvcNumDys;
//    
//
///** set 제외일수 : eepnDayIcmDys */
//private java.math.BigDecimal eepnDayIcmDys;
//
//    /** set 군경력근무일수 : amcrrLogSvcNumDys */
//    private java.math.BigDecimal amcrrLogSvcNumDys;
//    
//
///** set 실근무년수 : turtyDutyYrNum */
//private java.math.BigDecimal turtyDutyYrNum;
//
///** set 실근무개월수 : turtyDutyMnthNum */
//private java.math.BigDecimal turtyDutyMnthNum;
//
///** set 실근무일수 : turtyDutyNumDys */
//private java.math.BigDecimal turtyDutyNumDys;
//
//
//    /** set 급여산정시작일자 : payCmpttnBgnnDt */
//    private java.lang.String payCmpttnBgnnDt;
//
//    /** set 급여산정종료일자 : payCmpttnEndDt */
//    private java.lang.String payCmpttnEndDt;
//
//    /** set 기본급여합계금액 : fndtnPayAggrSumSum */
//    private java.math.BigDecimal fndtnPayAggrSumSum;
//
//    /** set 제수당합계금액 : snryAllwAggrSum */
//    private java.math.BigDecimal snryAllwAggrSum;
//
//    /** set 후생복지비합계금액 : welfWelfSpdgAggrSum */
//    private java.math.BigDecimal welfWelfSpdgAggrSum;
//
//    /** set 3월간후생복지비 : marPubcWelfAmnt */
//    private java.math.BigDecimal marPubcWelfAmnt;
//
//    /** set 3월간총임금액 : marTotAmntWag */
//    private java.math.BigDecimal marTotAmntWag;
//
//    /** set 1일평균임금액 : dayAvgAmntWag */
//    private java.math.BigDecimal dayAvgAmntWag;
//
//    /** set 퇴직금산정금액 : sevePayCmpttnSum */
//    private java.math.BigDecimal sevePayCmpttnSum;
//
//    /** set 퇴직금가산금액 : sevePayAddSum */
//    private java.math.BigDecimal sevePayAddSum;
//
//    /** set 퇴직금가산율 : sevePayAddRate */
//    private java.math.BigDecimal sevePayAddRate;
//
//    /** set 퇴직금가산적용금액 : sevePayAddApptnSum */
//    private java.math.BigDecimal sevePayAddApptnSum;
//
//    /** set 군경력정산포함여부 : amcrrClutInsnYn */
//    private java.lang.String amcrrClutInsnYn;
//
//    /** set 군경력가산적용금액 : amcrrAddApptnSum */
//    private java.math.BigDecimal amcrrAddApptnSum;
//
//    /** set 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
//    private java.math.BigDecimal sevePayCmpttnFreeDtySum;
//
//    /** set 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
//    private java.math.BigDecimal sevePayCmpttnTxtnSum;
//
//    /** set 퇴직금지급공제금액 : sevePayPymtDducSum */
//    private java.math.BigDecimal sevePayPymtDducSum;
//
//    /** set 퇴직금실지급금액 : sevePayTurtyPymtSum */
//    private java.math.BigDecimal sevePayTurtyPymtSum;
//
//    /** set 퇴직금비고내용 : sevePayNoteCtnt */
//    private java.lang.String sevePayNoteCtnt;
//
//    /** set 퇴직금지급일자 : sevePayPymtDt */
//    private java.lang.String sevePayPymtDt;
//
//    /** set 퇴직금지급여부 : sevePayPymtYn */
//    private java.lang.String sevePayPymtYn;
//
//    /** set 마감여부 : ddlneYn */
//    private java.lang.String ddlneYn;
//
//    /** set 마감일시 : ddlneDt */
//    private java.lang.String ddlneDt;
//
//    /** set 입력자 : kybdr */
//    private java.lang.String kybdr;
//
//    /** set 입력일자 : inptDt */
//    private java.lang.String inptDt;
//
//    /** set 입력주소 : inptAddr */
//    private java.lang.String inptAddr;
//
//    /** set 수정자 : ismt */
//    private java.lang.String ismt;
//
//    /** set 수정일자 : revnDt */
//    private java.lang.String revnDt;
//
//    /** set 수정주소 : revnAddr */
//    private java.lang.String revnAddr;
//
//    /** set 총근무일수 : totLogSvcNumDys */
//    private java.math.BigDecimal totLogSvcNumDys;
//
//    /** set 퇴직금지급액 : sevePayPymtSum */
//    private java.math.BigDecimal sevePayPymtSum;
//      
//    
//    /** set 정산년 : clutYr */
//    private java.lang.String clutYr;
//    
//    /** set 정산월 : clutMnth */
//    private java.lang.String clutMnth;
// 
//    /** set 고용구분 : emymtDivNm */
//    private java.lang.String emymtDivNm;
// 
//    /** set 부서코드 : deptNm */
//    private java.lang.String deptNm;
// 
//
//    /** set 직종 : typOccuNm */
//    private java.lang.String typOccuNm;
// 
//    /** set 호봉등급 : pyspGrdeNm */
//    private java.lang.String pyspGrdeNm;
//
//    
//    /** set 직종세구분 : dtilOccuClsDivNm */
//    private java.lang.String dtilOccuClsDivNm;
// 
//    /** set 사업 : businNm */
//    private java.lang.String businNm;
//    
//    /** set 주민등록번호 : resnRegnNum */
//    private java.lang.String resnRegnNum;
//    
//	 /** 직종세통합코드 dtilOccuInttnCd */
//    private java.lang.String dtilOccuInttnCd;
//    
//    
//    
//    
//    /**
//	 * Comment : 직종세 통합코드 
//	 * @fn java.lang.String getDtilOccuInttnCd()
//	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
//	 * @return the dtilOccuInttnCd get
//	 */
//	public java.lang.String getDtilOccuInttnCd() {
//		return dtilOccuInttnCd;
//	}
//
//	/**
//	 * Comment : 직종세 통합코드 
//	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
//	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
//	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
//	 */
//	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
//		this.dtilOccuInttnCd = dtilOccuInttnCd;
//	}
//
//	public java.lang.String getCalcSevePayPsnDivNm() {
//		return calcSevePayPsnDivNm;
//	}
//
//	public void setCalcSevePayPsnDivNm(java.lang.String calcSevePayPsnDivNm) {
//		this.calcSevePayPsnDivNm = calcSevePayPsnDivNm;
//	}
//
//	public java.lang.String getResnRegnNum() {
//		return resnRegnNum;
//	}
//
//	public void setResnRegnNum(java.lang.String resnRegnNum) {
//		this.resnRegnNum = resnRegnNum;
//	}
//
//	public java.lang.String getClutYr() {
//		return clutYr;
//	}
//
//	public void setClutYr(java.lang.String clutYr) {
//		this.clutYr = clutYr;
//	}
//
//	public java.lang.String getClutMnth() {
//		return clutMnth;
//	}
//
//	public void setClutMnth(java.lang.String clutMnth) {
//		this.clutMnth = clutMnth;
//	}
//
//	public java.lang.String getEmymtDivNm() {
//		return emymtDivNm;
//	}
//
//	public void setEmymtDivNm(java.lang.String emymtDivNm) {
//		this.emymtDivNm = emymtDivNm;
//	}
//
//	public java.lang.String getDeptNm() {
//		return deptNm;
//	}
//
//	public void setDeptNm(java.lang.String deptNm) {
//		this.deptNm = deptNm;
//	}
//
//	public java.lang.String getTypOccuNm() {
//		return typOccuNm;
//	}
//
//	public void setTypOccuNm(java.lang.String typOccuNm) {
//		this.typOccuNm = typOccuNm;
//	}
//
//	public java.lang.String getPyspGrdeNm() {
//		return pyspGrdeNm;
//	}
//
//	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
//		this.pyspGrdeNm = pyspGrdeNm;
//	}
//
//	public java.lang.String getDtilOccuClsDivNm() {
//		return dtilOccuClsDivNm;
//	}
//
//	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
//		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
//	}
//
//	public java.lang.String getBusinNm() {
//		return businNm;
//	}
//
//	public void setBusinNm(java.lang.String businNm) {
//		this.businNm = businNm;
//	}
//
//	public java.math.BigDecimal getTurtyDutyYrNum() {
//		return turtyDutyYrNum;
//	}
//
//	public void setTurtyDutyYrNum(java.math.BigDecimal turtyDutyYrNum) {
//		this.turtyDutyYrNum = turtyDutyYrNum;
//	}
//
//	public java.math.BigDecimal getTurtyDutyMnthNum() {
//		return turtyDutyMnthNum;
//	}
//
//	public void setTurtyDutyMnthNum(java.math.BigDecimal turtyDutyMnthNum) {
//		this.turtyDutyMnthNum = turtyDutyMnthNum;
//	}
//
//	public java.math.BigDecimal getTurtyDutyNumDys() {
//		return turtyDutyNumDys;
//	}
//
//	public void setTurtyDutyNumDys(java.math.BigDecimal turtyDutyNumDys) {
//		this.turtyDutyNumDys = turtyDutyNumDys;
//	}
//
//	public java.math.BigDecimal getEepnDayIcmDys() {
//		return eepnDayIcmDys;
//	}
//
//	public void setEepnDayIcmDys(java.math.BigDecimal eepnDayIcmDys) {
//		this.eepnDayIcmDys = eepnDayIcmDys;
//	}
//
//	public java.lang.String getRkfcdDt() {
//		return rkfcdDt;
//	}
//
//	public void setRkfcdDt(java.lang.String rkfcdDt) {
//		this.rkfcdDt = rkfcdDt;
//	}
//
//	public java.lang.String getEmymtDivCd() {
//		return emymtDivCd;
//	}
//
//	public void setEmymtDivCd(java.lang.String emymtDivCd) {
//		this.emymtDivCd = emymtDivCd;
//	}
//
//	public java.lang.String getDtilOccuClsDivCd() {
//		return dtilOccuClsDivCd;
//	}
//
//	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
//		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
//	}
//
//	public java.lang.String getBusinCd() {
//		return businCd;
//	}
//
//	public void setBusinCd(java.lang.String businCd) {
//		this.businCd = businCd;
//	}
//
//	public java.math.BigDecimal getTotLogSvcNumDys() {
//		return totLogSvcNumDys;
//	}
//
//	public void setTotLogSvcNumDys(java.math.BigDecimal totLogSvcNumDys) {
//		this.totLogSvcNumDys = totLogSvcNumDys;
//	}
//
//	public java.math.BigDecimal getSevePayPymtSum() {
//		return sevePayPymtSum;
//	}
//
//	public void setSevePayPymtSum(java.math.BigDecimal sevePayPymtSum) {
//		this.sevePayPymtSum = sevePayPymtSum;
//	}
//
//	public java.math.BigDecimal getAmcrrLogSvcYrNum() {
//		return amcrrLogSvcYrNum;
//	}
//
//	public void setAmcrrLogSvcYrNum(java.math.BigDecimal amcrrLogSvcYrNum) {
//		this.amcrrLogSvcYrNum = amcrrLogSvcYrNum;
//	}
//
//	public java.math.BigDecimal getAmcrrLogSvcMnthIcm() {
//		return amcrrLogSvcMnthIcm;
//	}
//
//	public void setAmcrrLogSvcMnthIcm(java.math.BigDecimal amcrrLogSvcMnthIcm) {
//		this.amcrrLogSvcMnthIcm = amcrrLogSvcMnthIcm;
//	}
//
//	public java.math.BigDecimal getAmcrrLogSvcNumDys() {
//		return amcrrLogSvcNumDys;
//	}
//
//	public void setAmcrrLogSvcNumDys(java.math.BigDecimal amcrrLogSvcNumDys) {
//		this.amcrrLogSvcNumDys = amcrrLogSvcNumDys;
//	}
//
//	public java.lang.String getAmcrrClutInsnYn() {
//		return amcrrClutInsnYn;
//	}
//
//	public void setAmcrrClutInsnYn(java.lang.String amcrrClutInsnYn) {
//		this.amcrrClutInsnYn = amcrrClutInsnYn;
//	}
//
//	public java.math.BigDecimal getAmcrrAddApptnSum() {
//		return amcrrAddApptnSum;
//	}
//
//	public void setAmcrrAddApptnSum(java.math.BigDecimal amcrrAddApptnSum) {
//		this.amcrrAddApptnSum = amcrrAddApptnSum;
//	}
//
//	public java.math.BigDecimal getSevePayAddSum() {
//		return sevePayAddSum;
//	}
//
//	public void setSevePayAddSum(java.math.BigDecimal sevePayAddSum) {
//		this.sevePayAddSum = sevePayAddSum;
//	}
//
//	public java.math.BigDecimal getSevePayAddRate() {
//		return sevePayAddRate;
//	}
//
//	public void setSevePayAddRate(java.math.BigDecimal sevePayAddRate) {
//		this.sevePayAddRate = sevePayAddRate;
//	}
//
//	public java.math.BigDecimal getSevePayAddApptnSum() {
//		return sevePayAddApptnSum;
//	}
//
//	public void setSevePayAddApptnSum(java.math.BigDecimal sevePayAddApptnSum) {
//		this.sevePayAddApptnSum = sevePayAddApptnSum;
//	}
//
//	public java.lang.String getDpobCd() {
//        return this.dpobCd;
//    }
//    
//    public void setDpobCd(java.lang.String dpobCd) {
//        this.dpobCd = dpobCd;
//    }
//    
//    public java.lang.String getSystemkey() {
//        return this.systemkey;
//    }
//    
//    public void setSystemkey(java.lang.String systemkey) {
//        this.systemkey = systemkey;
//    }
//    
//    public java.lang.String getCalcSevePayPsnDivCd() {
//        return this.calcSevePayPsnDivCd;
//    }
//    
//    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
//        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
//    }
//    
//    public java.lang.String getClutYrMnth() {
//        return this.clutYrMnth;
//    }
//    
//    public void setClutYrMnth(java.lang.String clutYrMnth) {
//        this.clutYrMnth = clutYrMnth;
//    }
//    
//    public java.lang.String getDeptCd() {
//        return this.deptCd;
//    }
//    
//    public void setDeptCd(java.lang.String deptCd) {
//        this.deptCd = deptCd;
//    }
//    
//    public java.lang.String getTypOccuCd() {
//        return this.typOccuCd;
//    }
//    
//    public void setTypOccuCd(java.lang.String typOccuCd) {
//        this.typOccuCd = typOccuCd;
//    }
//    
//    public java.lang.String getPyspGrdeCd() {
//        return this.pyspGrdeCd;
//    }
//    
//    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
//        this.pyspGrdeCd = pyspGrdeCd;
//    }
//    
//    public java.lang.String getInbyCd() {
//        return this.inbyCd;
//    }
//    
//    public void setInbyCd(java.lang.String inbyCd) {
//        this.inbyCd = inbyCd;
//    }
//    
//    public java.lang.String getPyspCd() {
//        return this.pyspCd;
//    }
//    
//    public void setPyspCd(java.lang.String pyspCd) {
//        this.pyspCd = pyspCd;
//    }
//    
//    public java.lang.String getLogSvcYrNumCd() {
//        return this.logSvcYrNumCd;
//    }
//    
//    public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
//        this.logSvcYrNumCd = logSvcYrNumCd;
//    }
//    
//    public java.lang.String getLogSvcMnthIcmCd() {
//        return this.logSvcMnthIcmCd;
//    }
//    
//    public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
//        this.logSvcMnthIcmCd = logSvcMnthIcmCd;
//    }
//    
//    public java.lang.String getNm() {
//        return this.nm;
//    }
//    
//    public void setNm(java.lang.String nm) {
//        this.nm = nm;
//    }
//    
//    public java.lang.String getIcncDt() {
//        return this.icncDt;
//    }
//    
//    public void setIcncDt(java.lang.String icncDt) {
//        this.icncDt = icncDt;
//    }
//    
//    public java.lang.String getRetryDt() {
//        return this.retryDt;
//    }
//    
//    public void setRetryDt(java.lang.String retryDt) {
//        this.retryDt = retryDt;
//    }
//    
//    public java.math.BigDecimal getLogSvcYrNum() {
//        return this.logSvcYrNum;
//    }
//    
//    public void setLogSvcYrNum(java.math.BigDecimal logSvcYrNum) {
//        this.logSvcYrNum = logSvcYrNum;
//    }
//    
//    public java.math.BigDecimal getLogSvcMnthIcm() {
//        return this.logSvcMnthIcm;
//    }
//    
//    public void setLogSvcMnthIcm(java.math.BigDecimal logSvcMnthIcm) {
//        this.logSvcMnthIcm = logSvcMnthIcm;
//    }
//    
//    public java.math.BigDecimal getEepnMnthIcm2012Bfr() {
//        return this.eepnMnthIcm2012Bfr;
//    }
//    
//    public void setEepnMnthIcm2012Bfr(java.math.BigDecimal eepnMnthIcm2012Bfr) {
//        this.eepnMnthIcm2012Bfr = eepnMnthIcm2012Bfr;
//    }
//    
//    public java.math.BigDecimal getEepnMnthIcm2013Aft() {
//        return this.eepnMnthIcm2013Aft;
//    }
//    
//    public void setEepnMnthIcm2013Aft(java.math.BigDecimal eepnMnthIcm2013Aft) {
//        this.eepnMnthIcm2013Aft = eepnMnthIcm2013Aft;
//    }
//    
//    public java.math.BigDecimal getAddMnthIcm2012Bfr() {
//        return this.addMnthIcm2012Bfr;
//    }
//    
//    public void setAddMnthIcm2012Bfr(java.math.BigDecimal addMnthIcm2012Bfr) {
//        this.addMnthIcm2012Bfr = addMnthIcm2012Bfr;
//    }
//    
//    public java.math.BigDecimal getAddMnthIcm2013Aft() {
//        return this.addMnthIcm2013Aft;
//    }
//    
//    public void setAddMnthIcm2013Aft(java.math.BigDecimal addMnthIcm2013Aft) {
//        this.addMnthIcm2013Aft = addMnthIcm2013Aft;
//    }
//    
//    public java.math.BigDecimal getLogSvcNumDys() {
//        return this.logSvcNumDys;
//    }
//    
//    public void setLogSvcNumDys(java.math.BigDecimal logSvcNumDys) {
//        this.logSvcNumDys = logSvcNumDys;
//    }
//    
//    public java.lang.String getPayCmpttnBgnnDt() {
//        return this.payCmpttnBgnnDt;
//    }
//    
//    public void setPayCmpttnBgnnDt(java.lang.String payCmpttnBgnnDt) {
//        this.payCmpttnBgnnDt = payCmpttnBgnnDt;
//    }
//    
//    public java.lang.String getPayCmpttnEndDt() {
//        return this.payCmpttnEndDt;
//    }
//    
//    public void setPayCmpttnEndDt(java.lang.String payCmpttnEndDt) {
//        this.payCmpttnEndDt = payCmpttnEndDt;
//    }
//    
//    public java.math.BigDecimal getFndtnPayAggrSumSum() {
//        return this.fndtnPayAggrSumSum;
//    }
//    
//    public void setFndtnPayAggrSumSum(java.math.BigDecimal fndtnPayAggrSumSum) {
//        this.fndtnPayAggrSumSum = fndtnPayAggrSumSum;
//    }
//    
//    public java.math.BigDecimal getSnryAllwAggrSum() {
//        return this.snryAllwAggrSum;
//    }
//    
//    public void setSnryAllwAggrSum(java.math.BigDecimal snryAllwAggrSum) {
//        this.snryAllwAggrSum = snryAllwAggrSum;
//    }
//    
//    public java.math.BigDecimal getWelfWelfSpdgAggrSum() {
//        return this.welfWelfSpdgAggrSum;
//    }
//    
//    public void setWelfWelfSpdgAggrSum(java.math.BigDecimal welfWelfSpdgAggrSum) {
//        this.welfWelfSpdgAggrSum = welfWelfSpdgAggrSum;
//    }
//    
//    public java.math.BigDecimal getMarPubcWelfAmnt() {
//        return this.marPubcWelfAmnt;
//    }
//    
//    public void setMarPubcWelfAmnt(java.math.BigDecimal marPubcWelfAmnt) {
//        this.marPubcWelfAmnt = marPubcWelfAmnt;
//    }
//    
//    public java.math.BigDecimal getMarTotAmntWag() {
//        return this.marTotAmntWag;
//    }
//    
//    public void setMarTotAmntWag(java.math.BigDecimal marTotAmntWag) {
//        this.marTotAmntWag = marTotAmntWag;
//    }
//    
//    public java.math.BigDecimal getDayAvgAmntWag() {
//        return this.dayAvgAmntWag;
//    }
//    
//    public void setDayAvgAmntWag(java.math.BigDecimal dayAvgAmntWag) {
//        this.dayAvgAmntWag = dayAvgAmntWag;
//    }
//     
//    
//    public java.math.BigDecimal getSevePayPymtDducSum() {
//        return this.sevePayPymtDducSum;
//    }
//    
//    public void setSevePayPymtDducSum(java.math.BigDecimal sevePayPymtDducSum) {
//        this.sevePayPymtDducSum = sevePayPymtDducSum;
//    }
//    
//  
//    
//    public java.math.BigDecimal getSevePayCmpttnSum() {
//		return sevePayCmpttnSum;
//	}
//
//	public void setSevePayCmpttnSum(java.math.BigDecimal sevePayCmpttnSum) {
//		this.sevePayCmpttnSum = sevePayCmpttnSum;
//	}
//
//	public java.math.BigDecimal getSevePayCmpttnFreeDtySum() {
//		return sevePayCmpttnFreeDtySum;
//	}
//
//	public void setSevePayCmpttnFreeDtySum(
//			java.math.BigDecimal sevePayCmpttnFreeDtySum) {
//		this.sevePayCmpttnFreeDtySum = sevePayCmpttnFreeDtySum;
//	}
//
//	public java.math.BigDecimal getSevePayCmpttnTxtnSum() {
//		return sevePayCmpttnTxtnSum;
//	}
//
//	public void setSevePayCmpttnTxtnSum(java.math.BigDecimal sevePayCmpttnTxtnSum) {
//		this.sevePayCmpttnTxtnSum = sevePayCmpttnTxtnSum;
//	}
//
//	public java.math.BigDecimal getSevePayTurtyPymtSum() {
//		return sevePayTurtyPymtSum;
//	}
//
//	public void setSevePayTurtyPymtSum(java.math.BigDecimal sevePayTurtyPymtSum) {
//		this.sevePayTurtyPymtSum = sevePayTurtyPymtSum;
//	}
//
//	public java.lang.String getSevePayNoteCtnt() {
//        return this.sevePayNoteCtnt;
//    }
//    
//    public void setSevePayNoteCtnt(java.lang.String sevePayNoteCtnt) {
//        this.sevePayNoteCtnt = sevePayNoteCtnt;
//    }
//    
//    public java.lang.String getSevePayPymtDt() {
//        return this.sevePayPymtDt;
//    }
//    
//    public void setSevePayPymtDt(java.lang.String sevePayPymtDt) {
//        this.sevePayPymtDt = sevePayPymtDt;
//    }
//    
//    public java.lang.String getSevePayPymtYn() {
//        return this.sevePayPymtYn;
//    }
//    
//    public void setSevePayPymtYn(java.lang.String sevePayPymtYn) {
//        this.sevePayPymtYn = sevePayPymtYn;
//    }
//    
//    public java.lang.String getDdlneYn() {
//        return this.ddlneYn;
//    }
//    
//    public void setDdlneYn(java.lang.String ddlneYn) {
//        this.ddlneYn = ddlneYn;
//    }
//    
//    public java.lang.String getDdlneDt() {
//        return this.ddlneDt;
//    }
//    
//    public void setDdlneDt(java.lang.String ddlneDt) {
//        this.ddlneDt = ddlneDt;
//    }
//    
//    public java.lang.String getKybdr() {
//        return this.kybdr;
//    }
//    
//    public void setKybdr(java.lang.String kybdr) {
//        this.kybdr = kybdr;
//    }
//    
//    public java.lang.String getInptDt() {
//        return this.inptDt;
//    }
//    
//    public void setInptDt(java.lang.String inptDt) {
//        this.inptDt = inptDt;
//    }
//    
//    public java.lang.String getInptAddr() {
//        return this.inptAddr;
//    }
//    
//    public void setInptAddr(java.lang.String inptAddr) {
//        this.inptAddr = inptAddr;
//    }
//    
//    public java.lang.String getIsmt() {
//        return this.ismt;
//    }
//    
//    public void setIsmt(java.lang.String ismt) {
//        this.ismt = ismt;
//    }
//    
//    public java.lang.String getRevnDt() {
//        return this.revnDt;
//    }
//    
//    public void setRevnDt(java.lang.String revnDt) {
//        this.revnDt = revnDt;
//    }
//    
//    public java.lang.String getRevnAddr() {
//        return this.revnAddr;
//    }
//    
//    public void setRevnAddr(java.lang.String revnAddr) {
//        this.revnAddr = revnAddr;
//    }
    
}
