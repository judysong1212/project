package com.app.smrmf.pkg.proc.remt.retirement.payr;

import java.io.Serializable;
 
/**
 * @Class Name : Payr0500VO.java
 * @Description : Payr0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtPsnl0100VO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    //PSNL0100
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 영문성명 : engNm */
    private java.lang.String engNm;

    /** set 한문성명 : chinCharNm */
    private java.lang.String chinCharNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;

    /** set 성별구분코드 : sxDivCd */
    private java.lang.String sxDivCd;

    /** set 생년월일 : yoobhMnthDay */
    private java.lang.String yoobhMnthDay;

    /** set 음양구분코드 : sclcDivCd */
    private java.lang.String sclcDivCd;

    /** set 국가코드 : natnCd */
    private java.lang.String natnCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;

    /** set 담당업무구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

 

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 퇴직사유내용 : retryReasCtnt */
    private java.lang.String retryReasCtnt;

    /** set 외국인구분코드 : frgnrDivCd */
    private java.lang.String frgnrDivCd;

    /** set 여권번호 : psptNum */
    private java.lang.String psptNum;

    /** set 체류시작일자 : styBgnnDt */
    private java.lang.String styBgnnDt;

    /** set 체류종료일자 : styEndDt */
    private java.lang.String styEndDt;

    /** set 최종학교 : endSchl */
    private java.lang.String endSchl;

    /** set 최종학위구분코드 : endDegrDivCd */
    private java.lang.String endDegrDivCd;

    /** set 승진예정일자 : pmtnScduDt */
    private java.lang.String pmtnScduDt;

    /** set 호봉승급예정일자 : pyspPrmtnScduDt */
    private java.lang.String pyspPrmtnScduDt;

    /** set 재고용예정일자 : reymnScduDt */
    private java.lang.String reymnScduDt;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 현_호봉발령일자 : currPyspAppmtDt */
    private java.lang.String currPyspAppmtDt;

    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;
    
    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String pernNoteCtnt;
     
	//PAYR0500
    /** 단위기관코드 PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
     
   
     
    
    //PSNL130

	/** set 급여구분코드 : payCd */
	private java.lang.String payCd;
	
	/** set 은행코드 : bnkCd */
	private java.lang.String bnkCd;
	
	/** set 은행계좌번호 : bnkAccuNum */
	private java.lang.String bnkAccuNum;
	
	/** set 예금주명 : acntHodrNm */
	private java.lang.String acntHodrNm;
	
	/** set 대표계좌여부 : rpsttvAccuYn */
	private java.lang.String rpsttvAccuYn;
	
	
	//remt2000
	 
    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;
 
    /** set 직위코드 : inbyCd */
    private java.lang.String inbyCd;

   
    /** set 성명 : nm */
    private java.lang.String nm;

    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;
    

/** set 기산일자 : rkfcdDt */
private java.lang.String rkfcdDt;
 
    /** set 근속년수 : logSvcYrNum */
    private java.math.BigDecimal logSvcYrNum;

    /** set 근속월수 : logSvcMnthIcm */
    private java.math.BigDecimal logSvcMnthIcm;

    /** set 군경력근속년수 : amcrrLogSvcYrNum */
    private java.math.BigDecimal amcrrLogSvcYrNum;

    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
    private java.math.BigDecimal amcrrLogSvcMnthIcm;
    

/** set 실근무년수 : turtyDutyYrNum */
private java.math.BigDecimal turtyDutyYrNum;

/** set 실근무개월수 : turtyDutyMnthNum */
private java.math.BigDecimal turtyDutyMnthNum;

/** set 실근무일수 : turtyDutyNumDys */
private java.math.BigDecimal turtyDutyNumDys;


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
    
    /** set 군경력정산계산여부 : chkAmcrrClutInsnYn */
    private java.lang.String chkAmcrrClutInsnYn;
    

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
 

    /** set 총근무일수 : totLogSvcNumDys */
    private java.math.BigDecimal totLogSvcNumDys;

    /** set 퇴직금지급액 : sevePayPymtSum */
    private java.math.BigDecimal sevePayPymtSum;

    
    
	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getChkAmcrrClutInsnYn() {
		return chkAmcrrClutInsnYn;
	}

	public void setChkAmcrrClutInsnYn(java.lang.String chkAmcrrClutInsnYn) {
		this.chkAmcrrClutInsnYn = chkAmcrrClutInsnYn;
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

	public java.lang.String getInbyCd() {
		return inbyCd;
	}

	public void setInbyCd(java.lang.String inbyCd) {
		this.inbyCd = inbyCd;
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

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getEngNm() {
		return engNm;
	}

	public void setEngNm(java.lang.String engNm) {
		this.engNm = engNm;
	}

	public java.lang.String getChinCharNm() {
		return chinCharNm;
	}

	public void setChinCharNm(java.lang.String chinCharNm) {
		this.chinCharNm = chinCharNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getSxDivCd() {
		return sxDivCd;
	}

	public void setSxDivCd(java.lang.String sxDivCd) {
		this.sxDivCd = sxDivCd;
	}

	public java.lang.String getYoobhMnthDay() {
		return yoobhMnthDay;
	}

	public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
		this.yoobhMnthDay = yoobhMnthDay;
	}

	public java.lang.String getSclcDivCd() {
		return sclcDivCd;
	}

	public void setSclcDivCd(java.lang.String sclcDivCd) {
		this.sclcDivCd = sclcDivCd;
	}

	public java.lang.String getNatnCd() {
		return natnCd;
	}

	public void setNatnCd(java.lang.String natnCd) {
		this.natnCd = natnCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}

	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
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

	public java.lang.String getEmymtBgnnDt() {
		return emymtBgnnDt;
	}

	public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
		this.emymtBgnnDt = emymtBgnnDt;
	}

	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}

	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	public java.lang.String getRetryReasCtnt() {
		return retryReasCtnt;
	}

	public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
		this.retryReasCtnt = retryReasCtnt;
	}

	public java.lang.String getFrgnrDivCd() {
		return frgnrDivCd;
	}

	public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
		this.frgnrDivCd = frgnrDivCd;
	}

	public java.lang.String getPsptNum() {
		return psptNum;
	}

	public void setPsptNum(java.lang.String psptNum) {
		this.psptNum = psptNum;
	}

	public java.lang.String getStyBgnnDt() {
		return styBgnnDt;
	}

	public void setStyBgnnDt(java.lang.String styBgnnDt) {
		this.styBgnnDt = styBgnnDt;
	}

	public java.lang.String getStyEndDt() {
		return styEndDt;
	}

	public void setStyEndDt(java.lang.String styEndDt) {
		this.styEndDt = styEndDt;
	}

	public java.lang.String getEndSchl() {
		return endSchl;
	}

	public void setEndSchl(java.lang.String endSchl) {
		this.endSchl = endSchl;
	}

	public java.lang.String getEndDegrDivCd() {
		return endDegrDivCd;
	}

	public void setEndDegrDivCd(java.lang.String endDegrDivCd) {
		this.endDegrDivCd = endDegrDivCd;
	}

	public java.lang.String getPmtnScduDt() {
		return pmtnScduDt;
	}

	public void setPmtnScduDt(java.lang.String pmtnScduDt) {
		this.pmtnScduDt = pmtnScduDt;
	}

	public java.lang.String getPyspPrmtnScduDt() {
		return pyspPrmtnScduDt;
	}

	public void setPyspPrmtnScduDt(java.lang.String pyspPrmtnScduDt) {
		this.pyspPrmtnScduDt = pyspPrmtnScduDt;
	}

	public java.lang.String getReymnScduDt() {
		return reymnScduDt;
	}

	public void setReymnScduDt(java.lang.String reymnScduDt) {
		this.reymnScduDt = reymnScduDt;
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

	public java.lang.String getCurrPyspAppmtDt() {
		return currPyspAppmtDt;
	}

	public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
		this.currPyspAppmtDt = currPyspAppmtDt;
	}

	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}

	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
	}

	public java.lang.String getPernNoteCtnt() {
		return pernNoteCtnt;
	}

	public void setPernNoteCtnt(java.lang.String pernNoteCtnt) {
		this.pernNoteCtnt = pernNoteCtnt;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getBnkCd() {
		return bnkCd;
	}

	public void setBnkCd(java.lang.String bnkCd) {
		this.bnkCd = bnkCd;
	}

	public java.lang.String getBnkAccuNum() {
		return bnkAccuNum;
	}

	public void setBnkAccuNum(java.lang.String bnkAccuNum) {
		this.bnkAccuNum = bnkAccuNum;
	}

	public java.lang.String getAcntHodrNm() {
		return acntHodrNm;
	}

	public void setAcntHodrNm(java.lang.String acntHodrNm) {
		this.acntHodrNm = acntHodrNm;
	}

	public java.lang.String getRpsttvAccuYn() {
		return rpsttvAccuYn;
	}

	public void setRpsttvAccuYn(java.lang.String rpsttvAccuYn) {
		this.rpsttvAccuYn = rpsttvAccuYn;
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
