package com.app.exterms.retirement.client.dto;

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
public class Remt2000DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;
    
    /** set 정산년 : clutYr */
    private java.lang.String clutYr;
    
    /** set 정산월 : clutMnth */
    private java.lang.String clutMnth;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 고용구분 : emymtDivNm */
    private java.lang.String emymtDivNm;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 부서코드 : deptNm */
    private java.lang.String deptNm;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    

    /** set 직종 : typOccuNm */
    private java.lang.String typOccuNm;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;
    
    /** set 호봉등급 : pyspGrdeNm */
    private java.lang.String pyspGrdeNm;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
    
    /** set 직종세구분 : dtilOccuClsDivNm */
    private java.lang.String dtilOccuClsDivNm;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 사업 : businNm */
    private java.lang.String businNm;

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
    private Long logSvcYrNum;

    /** set 근속월수 : logSvcMnthIcm */
    private Long logSvcMnthIcm;

    /** set 군경력근속년수 : amcrrLogSvcYrNum */
    private Long amcrrLogSvcYrNum;

    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
    private Long amcrrLogSvcMnthIcm;

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    private Long eepnMnthIcm2012Bfr;

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    private Long eepnMnthIcm2013Aft;

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    private Long addMnthIcm2012Bfr;

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    private Long addMnthIcm2013Aft;

    /** set 근속일수 : logSvcNumDys */
    private Long logSvcNumDys;
    
    /** set 제외일수 : eepnDayIcmDys */
    private Long eepnDayIcmDys;

    /** set 군경력근무일수 : amcrrLogSvcNumDys */
    private Long amcrrLogSvcNumDys;


	/** set 실근무년수 : turtyDutyYrNum */
	private Long turtyDutyYrNum;
	
	/** set 실근무개월수 : turtyDutyMnthNum */
	private Long turtyDutyMnthNum;
	
	/** set 실근무일수 : turtyDutyNumDys */
	private Long turtyDutyNumDys;  

    /** set 급여산정시작일자 : payCmpttnBgnnDt */
    private java.lang.String payCmpttnBgnnDt;

    /** set 급여산정종료일자 : payCmpttnEndDt */
    private java.lang.String payCmpttnEndDt;

    /** set 기본급여합계금액 : fndtnPayAggrSumSum */
    private Long fndtnPayAggrSumSum;

    /** set 제수당합계금액 : snryAllwAggrSum */
    private Long snryAllwAggrSum;

    /** set 후생복지비합계금액 : welfWelfSpdgAggrSum */
    private Long welfWelfSpdgAggrSum;

    /** set 3월간후생복지비 : marPubcWelfAmnt */
    private Long marPubcWelfAmnt;

    /** set 3월간총임금액 : marTotAmntWag */
    private Long marTotAmntWag;

    /** set 1일평균임금액 : dayAvgAmntWag */
    private Long dayAvgAmntWag;

    /** set 퇴직금산정금액 : sevePayCmpttnSum */
    private Long sevePayCmpttnSum;

    /** set 퇴직금가산금액 : sevePayAddSum */
    private Long sevePayAddSum;

    /** set 퇴직금가산율 : sevePayAddRate */
    private Double sevePayAddRate;

    /** set 퇴직금가산적용금액 : sevePayAddApptnSum */
    private Long sevePayAddApptnSum;

    /** set 군경력정산포함여부 : amcrrClutInsnYn */
    private Boolean amcrrClutInsnYn;

    /** set 군경력가산적용금액 : amcrrAddApptnSum */
    private Long amcrrAddApptnSum;

    /** set 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
    private Long sevePayCmpttnFreeDtySum;

    /** set 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
    private Long sevePayCmpttnTxtnSum;

    /** set 퇴직금지급공제금액 : sevePayPymtDducSum */
    private Long sevePayPymtDducSum;

    /** set 퇴직금실지급금액 : sevePayTurtyPymtSum */
    private Long sevePayTurtyPymtSum;

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    private java.lang.String sevePayNoteCtnt;

    /** set 퇴직금지급일자 : sevePayPymtDt */
    private java.lang.String sevePayPymtDt;

    /** set 퇴직금지급여부 : sevePayPymtYn */
    private Boolean sevePayPymtYn;

    /** set 마감여부 : ddlneYn */
    private Boolean ddlneYn;

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
    private Long totLogSvcNumDys;

    /** set 퇴직금지급액 : sevePayPymtSum */
    private Long sevePayPymtSum;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 직종세통합코드 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

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

	public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
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

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
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

	public Long getLogSvcYrNum() {
		return logSvcYrNum;
	}

	public void setLogSvcYrNum(Long logSvcYrNum) {
		this.logSvcYrNum = logSvcYrNum;
	}

	public Long getLogSvcMnthIcm() {
		return logSvcMnthIcm;
	}

	public void setLogSvcMnthIcm(Long logSvcMnthIcm) {
		this.logSvcMnthIcm = logSvcMnthIcm;
	}

	public Long getAmcrrLogSvcYrNum() {
		return amcrrLogSvcYrNum;
	}

	public void setAmcrrLogSvcYrNum(Long amcrrLogSvcYrNum) {
		this.amcrrLogSvcYrNum = amcrrLogSvcYrNum;
	}

	public Long getAmcrrLogSvcMnthIcm() {
		return amcrrLogSvcMnthIcm;
	}

	public void setAmcrrLogSvcMnthIcm(Long amcrrLogSvcMnthIcm) {
		this.amcrrLogSvcMnthIcm = amcrrLogSvcMnthIcm;
	}

	public Long getEepnMnthIcm2012Bfr() {
		return eepnMnthIcm2012Bfr;
	}

	public void setEepnMnthIcm2012Bfr(Long eepnMnthIcm2012Bfr) {
		this.eepnMnthIcm2012Bfr = eepnMnthIcm2012Bfr;
	}

	public Long getEepnMnthIcm2013Aft() {
		return eepnMnthIcm2013Aft;
	}

	public void setEepnMnthIcm2013Aft(Long eepnMnthIcm2013Aft) {
		this.eepnMnthIcm2013Aft = eepnMnthIcm2013Aft;
	}

	public Long getAddMnthIcm2012Bfr() {
		return addMnthIcm2012Bfr;
	}

	public void setAddMnthIcm2012Bfr(Long addMnthIcm2012Bfr) {
		this.addMnthIcm2012Bfr = addMnthIcm2012Bfr;
	}

	public Long getAddMnthIcm2013Aft() {
		return addMnthIcm2013Aft;
	}

	public void setAddMnthIcm2013Aft(Long addMnthIcm2013Aft) {
		this.addMnthIcm2013Aft = addMnthIcm2013Aft;
	}

	public Long getLogSvcNumDys() {
		return logSvcNumDys;
	}

	public void setLogSvcNumDys(Long logSvcNumDys) {
		this.logSvcNumDys = logSvcNumDys;
	}

	public Long getEepnDayIcmDys() {
		return eepnDayIcmDys;
	}

	public void setEepnDayIcmDys(Long eepnDayIcmDys) {
		this.eepnDayIcmDys = eepnDayIcmDys;
	}

	public Long getAmcrrLogSvcNumDys() {
		return amcrrLogSvcNumDys;
	}

	public void setAmcrrLogSvcNumDys(Long amcrrLogSvcNumDys) {
		this.amcrrLogSvcNumDys = amcrrLogSvcNumDys;
	}

	public Long getTurtyDutyYrNum() {
		return turtyDutyYrNum;
	}

	public void setTurtyDutyYrNum(Long turtyDutyYrNum) {
		this.turtyDutyYrNum = turtyDutyYrNum;
	}

	public Long getTurtyDutyMnthNum() {
		return turtyDutyMnthNum;
	}

	public void setTurtyDutyMnthNum(Long turtyDutyMnthNum) {
		this.turtyDutyMnthNum = turtyDutyMnthNum;
	}

	public Long getTurtyDutyNumDys() {
		return turtyDutyNumDys;
	}

	public void setTurtyDutyNumDys(Long turtyDutyNumDys) {
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

	public Long getFndtnPayAggrSumSum() {
		return fndtnPayAggrSumSum;
	}

	public void setFndtnPayAggrSumSum(Long fndtnPayAggrSumSum) {
		this.fndtnPayAggrSumSum = fndtnPayAggrSumSum;
	}

	public Long getSnryAllwAggrSum() {
		return snryAllwAggrSum;
	}

	public void setSnryAllwAggrSum(Long snryAllwAggrSum) {
		this.snryAllwAggrSum = snryAllwAggrSum;
	}

	public Long getWelfWelfSpdgAggrSum() {
		return welfWelfSpdgAggrSum;
	}

	public void setWelfWelfSpdgAggrSum(Long welfWelfSpdgAggrSum) {
		this.welfWelfSpdgAggrSum = welfWelfSpdgAggrSum;
	}

	public Long getMarPubcWelfAmnt() {
		return marPubcWelfAmnt;
	}

	public void setMarPubcWelfAmnt(Long marPubcWelfAmnt) {
		this.marPubcWelfAmnt = marPubcWelfAmnt;
	}

	public Long getMarTotAmntWag() {
		return marTotAmntWag;
	}

	public void setMarTotAmntWag(Long marTotAmntWag) {
		this.marTotAmntWag = marTotAmntWag;
	}

	public Long getDayAvgAmntWag() {
		return dayAvgAmntWag;
	}

	public void setDayAvgAmntWag(Long dayAvgAmntWag) {
		this.dayAvgAmntWag = dayAvgAmntWag;
	}

	public Long getSevePayCmpttnSum() {
		return sevePayCmpttnSum;
	}

	public void setSevePayCmpttnSum(Long sevePayCmpttnSum) {
		this.sevePayCmpttnSum = sevePayCmpttnSum;
	}

	public Long getSevePayAddSum() {
		return sevePayAddSum;
	}

	public void setSevePayAddSum(Long sevePayAddSum) {
		this.sevePayAddSum = sevePayAddSum;
	}

	public Double getSevePayAddRate() {
		return sevePayAddRate;
	}

	public void setSevePayAddRate(Double sevePayAddRate) {
		this.sevePayAddRate = sevePayAddRate;
	}

	public Long getSevePayAddApptnSum() {
		return sevePayAddApptnSum;
	}

	public void setSevePayAddApptnSum(Long sevePayAddApptnSum) {
		this.sevePayAddApptnSum = sevePayAddApptnSum;
	}

	public Boolean getAmcrrClutInsnYn() {
		return amcrrClutInsnYn;
	}

	public void setAmcrrClutInsnYn(Boolean amcrrClutInsnYn) {
		this.amcrrClutInsnYn = amcrrClutInsnYn;
	}

	public Long getAmcrrAddApptnSum() {
		return amcrrAddApptnSum;
	}

	public void setAmcrrAddApptnSum(Long amcrrAddApptnSum) {
		this.amcrrAddApptnSum = amcrrAddApptnSum;
	}

	public Long getSevePayCmpttnFreeDtySum() {
		return sevePayCmpttnFreeDtySum;
	}

	public void setSevePayCmpttnFreeDtySum(Long sevePayCmpttnFreeDtySum) {
		this.sevePayCmpttnFreeDtySum = sevePayCmpttnFreeDtySum;
	}

	public Long getSevePayCmpttnTxtnSum() {
		return sevePayCmpttnTxtnSum;
	}

	public void setSevePayCmpttnTxtnSum(Long sevePayCmpttnTxtnSum) {
		this.sevePayCmpttnTxtnSum = sevePayCmpttnTxtnSum;
	}

	public Long getSevePayPymtDducSum() {
		return sevePayPymtDducSum;
	}

	public void setSevePayPymtDducSum(Long sevePayPymtDducSum) {
		this.sevePayPymtDducSum = sevePayPymtDducSum;
	}

	public Long getSevePayTurtyPymtSum() {
		return sevePayTurtyPymtSum;
	}

	public void setSevePayTurtyPymtSum(Long sevePayTurtyPymtSum) {
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

	public Boolean getSevePayPymtYn() {
		return sevePayPymtYn;
	}

	public void setSevePayPymtYn(Boolean sevePayPymtYn) {
		this.sevePayPymtYn = sevePayPymtYn;
	}

	public Boolean getDdlneYn() {
		return ddlneYn;
	}

	public void setDdlneYn(Boolean ddlneYn) {
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

	public Long getTotLogSvcNumDys() {
		return totLogSvcNumDys;
	}

	public void setTotLogSvcNumDys(Long totLogSvcNumDys) {
		this.totLogSvcNumDys = totLogSvcNumDys;
	}

	public Long getSevePayPymtSum() {
		return sevePayPymtSum;
	}

	public void setSevePayPymtSum(Long sevePayPymtSum) {
		this.sevePayPymtSum = sevePayPymtSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
       

     
    
}
