package com.app.exterms.personal.server.vo;

import java.util.HashMap;
import java.util.List;


/**
 * @Class Name : Psnl0110VO.java
 * @Description : Psnl0110 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0110VO extends Psnl0110DefaultVO {
	
	
	
	private List<HashMap<String, String>> exlDatList;
	
	public List<HashMap<String, String>> getExlDatList() {
		return exlDatList;
	}

	public void setExlDatList(List<HashMap<String, String>> exlDatList) {
		this.exlDatList = exlDatList;
	}

	/** set 단위기관코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;
    

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	private java.lang.String dataList;
    
    
    public java.lang.String getDataList() {
		return dataList;
	}

	public void setDataList(java.lang.String dataList) {
		this.dataList = dataList;
	}
	
	private java.lang.String rnum;
    
	
    public java.lang.String getRnum() {
		return rnum;
	}

	public void setRnum(java.lang.String rnum) {
		this.rnum = rnum;
	}

	/** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** set 한문성명 : chinCharNm */
    private java.lang.String chinCharNm;
    
    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;
    
    
	
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
	
    public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	private static final long serialVersionUID = 1L;
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptNm;
    
    
    
   
    public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	/** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

//    /** set SYSTEMKEY : systemkey */
//    private java.lang.String systemkey;

    /** set 고용일련번호 : emymtSeilNum */
    private java.math.BigDecimal emymtSeilNum;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 고용유형코드 : emymtTypCd */
    private java.lang.String emymtTypCd;
    
    /** set 고용유형코드 : emymtTypCd */
    private java.lang.String emymtNewTypCd;
    
    
    
    

    public java.lang.String getEmymtNewTypCd() {
		return emymtNewTypCd;
	}

	public void setEmymtNewTypCd(java.lang.String emymtNewTypCd) {
		this.emymtNewTypCd = emymtNewTypCd;
	}


    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 현근무지명 : currPaeWorkNm */
    private java.lang.String currPaeWorkNm;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 사업코드 : businCd */
    private java.lang.String businNm;
    
    
    
    private java.lang.String businApptnYr;
    
    
    public java.lang.String getBusinApptnYr() {
		return businApptnYr;
	}

	public void setBusinApptnYr(java.lang.String businApptnYr) {
		this.businApptnYr = businApptnYr;
	}

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
    
    /** set 바뀐 직종세 : tempDtilOccuInttnCd */
    private java.lang.String tempDtilOccuInttnCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 급여지급구분코드 : payPymtDivCd */
    private java.lang.String payPymtDivCd;

    /** set 고용금액 : emymtSum */
    private java.math.BigDecimal emymtSum;

    /** set 고용사유내용 : emymtReasCtnt */
    private java.lang.String emymtReasCtnt;

    /** set 증번호 : certNumHuhd */
    private java.lang.String certNumHuhd;

    /** set 경감시작일자 : rducBgnnDt */
    private java.lang.String rducBgnnDt;

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

    /** set 경감종료일자 : rducEndDt */
    private java.lang.String rducEndDt;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    
    //---- payr0500
    /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    private java.lang.String addIncmTxApptnRtoCd;
    

	//-- 근속년수 비교를 위해 추가
	/** 근속년수비교 year */
    private java.lang.String year;
    
  	/** 근속년수비교 month */
    private java.lang.String month;

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

//	public java.lang.String getSystemkey() {
//		return systemkey;
//	}
//
//	public void setSystemkey(java.lang.String systemkey) {
//		this.systemkey = systemkey;
//	}

	public java.math.BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	public void setEmymtSeilNum(java.math.BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getEmymtTypCd() {
		return emymtTypCd;
	}

	public void setEmymtTypCd(java.lang.String emymtTypCd) {
		this.emymtTypCd = emymtTypCd;
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

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getCurrPaeWorkNm() {
		return currPaeWorkNm;
	}

	public void setCurrPaeWorkNm(java.lang.String currPaeWorkNm) {
		this.currPaeWorkNm = currPaeWorkNm;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	public java.lang.String getPayPymtDivCd() {
		return payPymtDivCd;
	}

	public void setPayPymtDivCd(java.lang.String payPymtDivCd) {
		this.payPymtDivCd = payPymtDivCd;
	}

	public java.math.BigDecimal getEmymtSum() {
		return emymtSum;
	}

	public void setEmymtSum(java.math.BigDecimal emymtSum) {
		this.emymtSum = emymtSum;
	}

	public java.lang.String getEmymtReasCtnt() {
		return emymtReasCtnt;
	}

	public void setEmymtReasCtnt(java.lang.String emymtReasCtnt) {
		this.emymtReasCtnt = emymtReasCtnt;
	}

	public java.lang.String getCertNumHuhd() {
		return certNumHuhd;
	}

	public void setCertNumHuhd(java.lang.String certNumHuhd) {
		this.certNumHuhd = certNumHuhd;
	}

	public java.lang.String getRducBgnnDt() {
		return rducBgnnDt;
	}

	public void setRducBgnnDt(java.lang.String rducBgnnDt) {
		this.rducBgnnDt = rducBgnnDt;
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

	public java.lang.String getRducEndDt() {
		return rducEndDt;
	}

	public void setRducEndDt(java.lang.String rducEndDt) {
		this.rducEndDt = rducEndDt;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getAddIncmTxApptnRtoCd() {
		return addIncmTxApptnRtoCd;
	}

	public void setAddIncmTxApptnRtoCd(java.lang.String addIncmTxApptnRtoCd) {
		this.addIncmTxApptnRtoCd = addIncmTxApptnRtoCd;
	}

	public java.lang.String getYear() {
		return year;
	}

	public void setYear(java.lang.String year) {
		this.year = year;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	public java.lang.String getTempDtilOccuInttnCd() {
		return tempDtilOccuInttnCd;
	}

	public void setTempDtilOccuInttnCd(java.lang.String tempDtilOccuInttnCd) {
		this.tempDtilOccuInttnCd = tempDtilOccuInttnCd;
	}
	
	
    
    
//    /** DPOB_CD */
//    private java.lang.String dpobCd;
//    
//    /** SYSTEMKEY */
//    private java.lang.String systemkey;
//    
//    /** EMYMT_SEIL_NUM */
//    private java.math.BigDecimal emymtSeilNum;
//    
//    /** EMYMT_DIV_CD */
//    private java.lang.String emymtDivCd;
//    
//    /** EMYMT_TYP_CD */
//    private java.lang.String emymtTypCd;
//    
//    /** EMYMT_BGNN_DT */
//    private java.lang.String emymtBgnnDt;
//    
//    /** EMYMT_END_DT */
//    private java.lang.String emymtEndDt;
//    
//    /** DEPT_CD */
//    private java.lang.String deptCd;
//    
//    /** CURR_PAE_WORK_NM */
//    private java.lang.String currPaeWorkNm;
//    
//    /** BUSIN_CD */
//    private java.lang.String businCd;
//    
//    /** TYP_OCCU_CD */
//    private java.lang.String typOccuCd;
//    
//    /** TYP_OCCU_CD */
//    private java.lang.String typComboOccuCd;
//    
//    /** DTIL_OCCU_CLS_DIV_CD */
//    private java.lang.String dtilOccuClsDivCd;
//    
//    /** ODTY_CD */
//    private java.lang.String odtyCd;
//    
//    /** PAY_PYMT_DIV_CD */
//    private java.lang.String payPymtDivCd;
//    
//    /** EMYMT_SUM */
//    private java.math.BigDecimal emymtSum;
//    
//    /** EMYMT_REAS_CTNT */
//    private java.lang.String emymtReasCtnt;
//    
//    /** CERT_NUM_HUHD */
//    private java.lang.String certNumHuhd;
//    
//    /** RDUC_BGNN_DT */
//    private java.lang.String rducBgnnDt;
//    
//    /** KYBDR */
//    private java.lang.String kybdr;
//    
//    /** INPT_DT */
//    private java.lang.String inptDt;
//    
//    /** INPT_ADDR */
//    private java.lang.String inptAddr;
//    
//    /** ISMT */
//    private java.lang.String ismt;
//    
//    /** REVN_DT */
//    private java.lang.String revnDt;
//    
//    /** REVN_ADDR */
//    private java.lang.String revnAddr;
//    
//    /** RDUC_END_DT */
//    private java.lang.String rducEndDt;
//    
//	/** 직종세통합코드 dtilOccuInttnCd */
//    private java.lang.String dtilOccuInttnCd;
	
	
	
    
	private java.lang.String dataChk;
	private java.lang.String emymtNewTypNm;
	
	private java.lang.String emymtTypNm;
	private java.lang.String mangeDeptCd;	
	private java.lang.String mangeDeptNm;


	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getChinCharNm() {
		return chinCharNm;
	}

	public void setChinCharNm(java.lang.String chinCharNm) {
		this.chinCharNm = chinCharNm;
	}

	public java.lang.String getCurrAffnDeptNm() {
		return currAffnDeptNm;
	}

	public void setCurrAffnDeptNm(java.lang.String currAffnDeptNm) {
		this.currAffnDeptNm = currAffnDeptNm;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getDataChk() {
		return dataChk;
	}

	public void setDataChk(java.lang.String dataChk) {
		this.dataChk = dataChk;
	}

	public java.lang.String getEmymtNewTypNm() {
		return emymtNewTypNm;
	}

	public void setEmymtNewTypNm(java.lang.String emymtNewTypNm) {
		this.emymtNewTypNm = emymtNewTypNm;
	}

	public java.lang.String getEmymtTypNm() {
		return emymtTypNm;
	}

	public void setEmymtTypNm(java.lang.String emymtTypNm) {
		this.emymtTypNm = emymtTypNm;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	public java.lang.String getMangeDeptNm() {
		return mangeDeptNm;
	}

	public void setMangeDeptNm(java.lang.String mangeDeptNm) {
		this.mangeDeptNm = mangeDeptNm;
	}
	
	/** set 퇴직사유내용 : retryReasCtnt */
	private java.lang.String retryReasCtnt;

	/** set 퇴직이직사유구분코드 : retryDivCd */
	private java.lang.String retryDivCd;
    
	public java.lang.String getRetryReasCtnt() {
		return retryReasCtnt;
	}

	public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
		this.retryReasCtnt = retryReasCtnt;
	}

	public java.lang.String getRetryDivCd() {
		return retryDivCd;
	}

	public void setRetryDivCd(java.lang.String retryDivCd) {
		this.retryDivCd = retryDivCd;
	}
	
	
	/** set 환산비율구분코드 : cvsnRtoDivCd */
	private java.lang.String cvsnRtoDivCd;

	/** set 근속년수 : dutyYrNum */
	private java.math.BigDecimal dutyYrNum;

	/** set 근속월수 : dutyMnthIcm */
	private java.math.BigDecimal dutyMnthIcm;

	/** set 근속일수 : dutyDayNum */
	private java.math.BigDecimal dutyDayNum;

	/** set 근속전체일수 : dutyTotDayNum */
	private java.math.BigDecimal dutyTotDayNum;


	public java.lang.String getCvsnRtoDivCd() {
		return cvsnRtoDivCd;
	}

	public void setCvsnRtoDivCd(java.lang.String cvsnRtoDivCd) {
		this.cvsnRtoDivCd = cvsnRtoDivCd;
	}

	public java.math.BigDecimal getDutyYrNum() {
		return dutyYrNum;
	}

	public void setDutyYrNum(java.math.BigDecimal dutyYrNum) {
		this.dutyYrNum = dutyYrNum;
	}

	public java.math.BigDecimal getDutyMnthIcm() {
		return dutyMnthIcm;
	}

	public void setDutyMnthIcm(java.math.BigDecimal dutyMnthIcm) {
		this.dutyMnthIcm = dutyMnthIcm;
	}

	public java.math.BigDecimal getDutyDayNum() {
		return dutyDayNum;
	}

	public void setDutyDayNum(java.math.BigDecimal dutyDayNum) {
		this.dutyDayNum = dutyDayNum;
	}

	public java.math.BigDecimal getDutyTotDayNum() {
		return dutyTotDayNum;
	}

	public void setDutyTotDayNum(java.math.BigDecimal dutyTotDayNum) {
		this.dutyTotDayNum = dutyTotDayNum;
	}
	
	// psnl0111
    /** HUS_ROAD_NM_ZPCD */
    private java.lang.String husRoadNmZpcd;
    
    /** HUS_ROAD_NM_FNDTN_ADDR */
    private java.lang.String husRoadNmFndtnAddr;
    
    /** HUS_ROAD_NM_DTL_PATR_ADDR */
    private java.lang.String husRoadNmDtlPatrAddr;
    
    /** HUS_PHN_NUM */
    private java.lang.String husPhnNum;
    
    /** CELL_PHNE_NUM */
    private java.lang.String cellPhneNum;


	public java.lang.String getHusRoadNmZpcd() {
		return husRoadNmZpcd;
	}

	public void setHusRoadNmZpcd(java.lang.String husRoadNmZpcd) {
		this.husRoadNmZpcd = husRoadNmZpcd;
	}

	public java.lang.String getHusRoadNmFndtnAddr() {
		return husRoadNmFndtnAddr;
	}

	public void setHusRoadNmFndtnAddr(java.lang.String husRoadNmFndtnAddr) {
		this.husRoadNmFndtnAddr = husRoadNmFndtnAddr;
	}

	public java.lang.String getHusRoadNmDtlPatrAddr() {
		return husRoadNmDtlPatrAddr;
	}

	public void setHusRoadNmDtlPatrAddr(java.lang.String husRoadNmDtlPatrAddr) {
		this.husRoadNmDtlPatrAddr = husRoadNmDtlPatrAddr;
	}

	public java.lang.String getHusPhnNum() {
		return husPhnNum;
	}

	public void setHusPhnNum(java.lang.String husPhnNum) {
		this.husPhnNum = husPhnNum;
	}

	public java.lang.String getCellPhneNum() {
		return cellPhneNum;
	}

	public void setCellPhneNum(java.lang.String cellPhneNum) {
		this.cellPhneNum = cellPhneNum;
	}

    // psnl0113
    /** DABTY_DIV_CD */
    private java.lang.String dabtyDivCd;
    
    /** DABTY_GRDE_CD */
    private java.lang.String dabtyGrdeCd;
    
    /** DABTY_AJMT_DT */
    private java.lang.String dabtyAjmtDt;

	public java.lang.String getDabtyDivCd() {
		return dabtyDivCd;
	}

	public void setDabtyDivCd(java.lang.String dabtyDivCd) {
		this.dabtyDivCd = dabtyDivCd;
	}

	public java.lang.String getDabtyGrdeCd() {
		return dabtyGrdeCd;
	}

	public void setDabtyGrdeCd(java.lang.String dabtyGrdeCd) {
		this.dabtyGrdeCd = dabtyGrdeCd;
	}

	public java.lang.String getDabtyAjmtDt() {
		return dabtyAjmtDt;
	}

	public void setDabtyAjmtDt(java.lang.String dabtyAjmtDt) {
		this.dabtyAjmtDt = dabtyAjmtDt;
	}
	

    /** set 사업코드 : businCd */
    private java.lang.String workHourStandard;

	public java.lang.String getWorkHourStandard() {
		return workHourStandard;
	}

	public void setWorkHourStandard(java.lang.String workHourStandard) {
		this.workHourStandard = workHourStandard;
	}
    
	
}
