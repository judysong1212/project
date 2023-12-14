package com.app.exterms.personal.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Psnl0100DefaultVO.java
 * @Description : Psnl0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0600SrhVO implements Serializable {
	
	// 엑셀 통합출력을 위한 구분자
	private java.lang.String psnl0100Chk;	// 인사 기본
	private java.lang.String psnl0112Chk;	// 인사 병역
	private java.lang.String psnl0114Chk;	// 인사 단체
	private java.lang.String psnl0116Chk;	// 인사 학력
	private java.lang.String psnl0119Chk;	// 인사 경력
	private java.lang.String psnl0118Chk;	// 인사 자격
	private java.lang.String psnl0120Chk;	// 인사 교육
	private java.lang.String psnl0121Chk;	// 인사 포상
	private java.lang.String psnl0122Chk;	// 인사 징계
	private java.lang.String psnl0123Chk;	// 인사 휴직
	
	
	public java.lang.String getPsnl0100Chk() {
		return psnl0100Chk;
	}

	public void setPsnl0100Chk(java.lang.String psnl0100Chk) {
		this.psnl0100Chk = psnl0100Chk;
	}

	public java.lang.String getPsnl0112Chk() {
		return psnl0112Chk;
	}

	public void setPsnl0112Chk(java.lang.String psnl0112Chk) {
		this.psnl0112Chk = psnl0112Chk;
	}

	public java.lang.String getPsnl0114Chk() {
		return psnl0114Chk;
	}

	public void setPsnl0114Chk(java.lang.String psnl0114Chk) {
		this.psnl0114Chk = psnl0114Chk;
	}

	public java.lang.String getPsnl0116Chk() {
		return psnl0116Chk;
	}

	public void setPsnl0116Chk(java.lang.String psnl0116Chk) {
		this.psnl0116Chk = psnl0116Chk;
	}

	public java.lang.String getPsnl0119Chk() {
		return psnl0119Chk;
	}

	public void setPsnl0119Chk(java.lang.String psnl0119Chk) {
		this.psnl0119Chk = psnl0119Chk;
	}

	public java.lang.String getPsnl0118Chk() {
		return psnl0118Chk;
	}

	public void setPsnl0118Chk(java.lang.String psnl0118Chk) {
		this.psnl0118Chk = psnl0118Chk;
	}

	public java.lang.String getPsnl0120Chk() {
		return psnl0120Chk;
	}

	public void setPsnl0120Chk(java.lang.String psnl0120Chk) {
		this.psnl0120Chk = psnl0120Chk;
	}

	public java.lang.String getPsnl0121Chk() {
		return psnl0121Chk;
	}

	public void setPsnl0121Chk(java.lang.String psnl0121Chk) {
		this.psnl0121Chk = psnl0121Chk;
	}

	public java.lang.String getPsnl0122Chk() {
		return psnl0122Chk;
	}

	public void setPsnl0122Chk(java.lang.String psnl0122Chk) {
		this.psnl0122Chk = psnl0122Chk;
	}

	public java.lang.String getPsnl0123Chk() {
		return psnl0123Chk;
	}

	public void setPsnl0123Chk(java.lang.String psnl0123Chk) {
		this.psnl0123Chk = psnl0123Chk;
	}



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
    
    /** rowCount */
    private String rowCount = "";
    
    /** currEntPage */
    private String currEntPage = "";
    
   
    private java.lang.String usrId;				/** set usrId : usrId */
    private java.lang.String payrMangDeptYn ;	//단위기관담당자여부 처리를 위한 부분 
    private java.lang.String payrMangDeptCd; 	//단위기관 담당자 여부
    
    // -- PSNL0100
    /** DPOB_CD */
    private java.lang.String dpobCd; 

    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;
    
    /** set 현_부서발령일자(시작) : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDtS;
    
    /** set 현_부서발령일자(종료) : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDtE;
    
    
    /** set 최초고용일자구분 : frstTypEmymtDt */
    private java.lang.String frstTypEmymtDt;
    
    
    public java.lang.String getFrstTypEmymtDt() {
		return frstTypEmymtDt;
	}

	public void setFrstTypEmymtDt(java.lang.String frstTypEmymtDt) {
		this.frstTypEmymtDt = frstTypEmymtDt;
	}


	/** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;
    
    /** set 최초고용일자(시작) : frstEmymtDtS */
    private java.lang.String frstEmymtDtS;
   
    /** set 최초고용일자(종료) : frstEmymtDtE */
    private java.lang.String frstEmymtDtE;
    
    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;
    
    /** set 생년월일 : yoobhMnthDay */
    private java.lang.String yoobhMnthDay;
    
    /** set 생년월일(시작) : yoobhMnthDayS */
    private java.lang.String yoobhMnthDayS;
    
    /** set 생년월일(종료) : yoobhMnthDayE */
    private java.lang.String yoobhMnthDayE;
    
    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;
    
    /** hdofcCodtnCd */
    private List<String> hdofcCodtnCdArr;  		//스트링 값에 여러건을 넘기기의한 값(재직)
    
    /** set 성별구분코드 : sxDivCd */
    private java.lang.String sxDivCd;
    
    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;
    
    /** set 근속년수코드(시작) : logSvcYrNumCdS */
    private java.lang.String logSvcYrNumCdS;
    
    /** set 근속년수코드(종료) : logSvcYrNumCdE */
    private java.lang.String logSvcYrNumCdE;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 근속월수코드(시작) : logSvcMnthIcmCdS*/
    private java.lang.String logSvcMnthIcmCdS;
    
    /** set 근속월수코드(종료) : logSvcMnthIcmCdS*/
    private java.lang.String logSvcMnthIcmCdE;
    
    private List<String> dtilOccuInttnCdArr;	//스트링 값에 여러건을 넘기기의한 값(직종세통합)
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    
    // 조회 구분자
    private java.lang.String srhFlag;   


	public java.lang.String getSrhFlag() {
		return srhFlag;
	}

	public void setSrhFlag(java.lang.String srhFlag) {
		this.srhFlag = srhFlag;
	}

    
	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCdAuth()
	 * @brief date:2015 Dec 22, 2015 user:leeheuisung
	 * @return the deptCdAuth get
	 */
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
	 *@brief date:2015 Dec 22, 2015 user:leeheuisung
	 *@param deptCdAuth the deptCdAuth to set
	 */
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2015 Dec 22, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2015 Dec 22, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}
    
    
    
    // -- PSNL0112 (병역)
    /** 제대구분코드 : DSAGE_DIV_CD */
    private java.lang.String dsageDivCd;
    
    /** 제대일자 : DSAGE_DT */
    private java.lang.String dsageDt;
    
    /** 제대일자(시작) : DSAGE_DT */
    private java.lang.String dsageDtS;
    
    /** 제대일자(시작) : DSAGE_DT */
    private java.lang.String dsageDtE;
    
    /** 군별코드 : BAGGRP_CD */
    private java.lang.String baggrpCd;
    
    /** 병과코드 : ABOTS_CD */
    private java.lang.String abotsCd;
    
    /** 계급코드 : CLS_CD */
    private java.lang.String clsCd;
    
    
    
    // -- PSNL0114 (딘체)
    /** 가입단체명 : JN_OPZTN_NM */
    private java.lang.String jnOpztnNm;
    
    /** 가입일자 : JN_DT */
    private java.lang.String jnDt;
    
    /** 가입일자(시작) : JN_DT */
    private java.lang.String jnDtS;
    
    /** 가입일자(종료) : JN_DT */
    private java.lang.String jnDtE;
    
    
    // -- PSNL0116 (학력)
    /** 학력사항 일련번호 : ACAD_ABTY_DIV_CD */
    private java.lang.String acadAbtyDivCd;
    
    /** 학위구분코드 : DEGR_DIV_CD */
    private java.lang.String degrDivCd;
    
    /** 학과코드 : DEPR_MAJR_CD */
    private java.lang.String deprMajrCd;
    
    /** 학교코드 : SCHL_CD */
    private java.lang.String schlCd;
    
    
    // -- PSNL0119 (경력)
    /** 근무지명 : PAE_WORK_NM */
    private java.lang.String paeWorkNm;
    
    /** 경력시작일자 : CARR_BGNN_DT */
    private java.lang.String carrBgnnDt;
    
    /** 경력시작일자(시작) : CARR_BGNN_DT */
    private java.lang.String carrBgnnDtS;
    
    /** 경력시작일자(종료) : CARR_BGNN_DT */
    private java.lang.String carrBgnnDtE;
    
    
    // -- PSNL0118 (자격)
    /** 자격면허일련번호 : QFTNT_LICNS_NUM */
    private java.lang.String qftntLicnsNum;
    
    /** 취득일자 : AQTN_DT */
    private java.lang.String aqtnDt;
    
    /** 취득일자(시작) : AQTN_DT */
    private java.lang.String aqtnDtS;
    
    /** 취득일자(종료) : AQTN_DT */
    private java.lang.String aqtnDtE;
    
    /** set 자격면허분야내용 : qftntLicnsPovncCtnt */
    private java.lang.String qftntLicnsPovncCtnt;
    

    // -- PSNL0120 (교육)
    /** 교육종류명 : EDU_KND_NM */
    private java.lang.String eduKndNm;
    
    /** 교육시작일자 :EDU_BGNN_DT */
    private java.lang.String eduBgnnDt;
    
    /** 교육시작일자(시작) : EDU_BGNN_DT */
    private java.lang.String eduBgnnDtS;
    
    /** 교육시작일자(종료) : EDU_BGNN_DT */
    private java.lang.String eduBgnnDtE;
    
    // -- PSNL0121 (포상)
    
    // -- PSNL0122 (징계)
    /** 징계구분코드 : DSNY_ACT_DIV_CD */
    private java.lang.String dsnyActDivCd;
    
    /** 징계처분일자: DSNY_ACT_DSPL_DT */
    private java.lang.String dsnyActDsplDt;
    
    /** 징계처분일자(시작) : DSNY_ACT_DSPL_DT */
    private java.lang.String dsnyActDsplDtS;
    
    /**  징계처분일자(종료) : DSNY_ACT_DSPL_DT */
    private java.lang.String dsnyActDsplDtE;
    
    // -- PSNL0123 (휴직)
    /** 휴직구분코드 : LEVF_ABNC_DIV_CD */
    private java.lang.String levfAbncDivCd;
    
    /** 휴직시작일자 : LEVF_ABNC_BGNN_DT */
    private java.lang.String levfAbncBgnnDt;
    
    /** 휴직시작일자(시작) : LEVF_ABNC_BGNN_DT */
    private java.lang.String levfAbncBgnnDtS;
    
    /** 휴직시작일자(종료) : LEVF_ABNC_BGNN_DT */
    private java.lang.String levfAbncBgnnDtE;

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

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public String getCurrEntPage() {
		return currEntPage;
	}

	public void setCurrEntPage(String currEntPage) {
		this.currEntPage = currEntPage;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}
	
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
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
	
	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}

	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
	}

	public java.lang.String getCurrDeptAppmtDtS() {
		return currDeptAppmtDtS;
	}

	public void setCurrDeptAppmtDtS(java.lang.String currDeptAppmtDtS) {
		this.currDeptAppmtDtS = currDeptAppmtDtS;
	}

	public java.lang.String getCurrDeptAppmtDtE() {
		return currDeptAppmtDtE;
	}

	public void setCurrDeptAppmtDtE(java.lang.String currDeptAppmtDtE) {
		this.currDeptAppmtDtE = currDeptAppmtDtE;
	}

	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}

	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}

	public java.lang.String getFrstEmymtDtS() {
		return frstEmymtDtS;
	}

	public void setFrstEmymtDtS(java.lang.String frstEmymtDtS) {
		this.frstEmymtDtS = frstEmymtDtS;
	}

	public java.lang.String getFrstEmymtDtE() {
		return frstEmymtDtE;
	}

	public void setFrstEmymtDtE(java.lang.String frstEmymtDtE) {
		this.frstEmymtDtE = frstEmymtDtE;
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

	public java.lang.String getYoobhMnthDay() {
		return yoobhMnthDay;
	}

	public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
		this.yoobhMnthDay = yoobhMnthDay;
	}

	public java.lang.String getYoobhMnthDayS() {
		return yoobhMnthDayS;
	}

	public void setYoobhMnthDayS(java.lang.String yoobhMnthDayS) {
		this.yoobhMnthDayS = yoobhMnthDayS;
	}

	public java.lang.String getYoobhMnthDayE() {
		return yoobhMnthDayE;
	}

	public void setYoobhMnthDayE(java.lang.String yoobhMnthDayE) {
		this.yoobhMnthDayE = yoobhMnthDayE;
	}

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getSxDivCd() {
		return sxDivCd;
	}

	public void setSxDivCd(java.lang.String sxDivCd) {
		this.sxDivCd = sxDivCd;
	}

	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}

	public java.lang.String getLogSvcYrNumCdS() {
		return logSvcYrNumCdS;
	}

	public void setLogSvcYrNumCdS(java.lang.String logSvcYrNumCdS) {
		this.logSvcYrNumCdS = logSvcYrNumCdS;
	}

	public java.lang.String getLogSvcYrNumCdE() {
		return logSvcYrNumCdE;
	}

	public void setLogSvcYrNumCdE(java.lang.String logSvcYrNumCdE) {
		this.logSvcYrNumCdE = logSvcYrNumCdE;
	}

	public java.lang.String getLogSvcMnthIcmCd() {
		return logSvcMnthIcmCd;
	}

	public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
		this.logSvcMnthIcmCd = logSvcMnthIcmCd;
	}

	public java.lang.String getLogSvcMnthIcmCdS() {
		return logSvcMnthIcmCdS;
	}

	public void setLogSvcMnthIcmCdS(java.lang.String logSvcMnthIcmCdS) {
		this.logSvcMnthIcmCdS = logSvcMnthIcmCdS;
	}

	public java.lang.String getLogSvcMnthIcmCdE() {
		return logSvcMnthIcmCdE;
	}

	public void setLogSvcMnthIcmCdE(java.lang.String logSvcMnthIcmCdE) {
		this.logSvcMnthIcmCdE = logSvcMnthIcmCdE;
	}

	public java.lang.String getDsageDivCd() {
		return dsageDivCd;
	}

	public void setDsageDivCd(java.lang.String dsageDivCd) {
		this.dsageDivCd = dsageDivCd;
	}

	public java.lang.String getDsageDt() {
		return dsageDt;
	}

	public void setDsageDt(java.lang.String dsageDt) {
		this.dsageDt = dsageDt;
	}

	public java.lang.String getDsageDtS() {
		return dsageDtS;
	}

	public void setDsageDtS(java.lang.String dsageDtS) {
		this.dsageDtS = dsageDtS;
	}

	public java.lang.String getDsageDtE() {
		return dsageDtE;
	}

	public void setDsageDtE(java.lang.String dsageDtE) {
		this.dsageDtE = dsageDtE;
	}

	public java.lang.String getBaggrpCd() {
		return baggrpCd;
	}

	public void setBaggrpCd(java.lang.String baggrpCd) {
		this.baggrpCd = baggrpCd;
	}

	public java.lang.String getAbotsCd() {
		return abotsCd;
	}

	public void setAbotsCd(java.lang.String abotsCd) {
		this.abotsCd = abotsCd;
	}

	public java.lang.String getClsCd() {
		return clsCd;
	}

	public void setClsCd(java.lang.String clsCd) {
		this.clsCd = clsCd;
	}

	public java.lang.String getJnOpztnNm() {
		return jnOpztnNm;
	}

	public void setJnOpztnNm(java.lang.String jnOpztnNm) {
		this.jnOpztnNm = jnOpztnNm;
	}

	public java.lang.String getJnDt() {
		return jnDt;
	}

	public void setJnDt(java.lang.String jnDt) {
		this.jnDt = jnDt;
	}

	public java.lang.String getJnDtS() {
		return jnDtS;
	}

	public void setJnDtS(java.lang.String jnDtS) {
		this.jnDtS = jnDtS;
	}

	public java.lang.String getJnDtE() {
		return jnDtE;
	}

	public void setJnDtE(java.lang.String jnDtE) {
		this.jnDtE = jnDtE;
	}

	public java.lang.String getAcadAbtyDivCd() {
		return acadAbtyDivCd;
	}

	public void setAcadAbtyDivCd(java.lang.String acadAbtyDivCd) {
		this.acadAbtyDivCd = acadAbtyDivCd;
	}

	public java.lang.String getDegrDivCd() {
		return degrDivCd;
	}

	public void setDegrDivCd(java.lang.String degrDivCd) {
		this.degrDivCd = degrDivCd;
	}

	public java.lang.String getDeprMajrCd() {
		return deprMajrCd;
	}

	public void setDeprMajrCd(java.lang.String deprMajrCd) {
		this.deprMajrCd = deprMajrCd;
	}

	public java.lang.String getSchlCd() {
		return schlCd;
	}

	public void setSchlCd(java.lang.String schlCd) {
		this.schlCd = schlCd;
	}

	public java.lang.String getPaeWorkNm() {
		return paeWorkNm;
	}

	public void setPaeWorkNm(java.lang.String paeWorkNm) {
		this.paeWorkNm = paeWorkNm;
	}

	public java.lang.String getCarrBgnnDt() {
		return carrBgnnDt;
	}

	public void setCarrBgnnDt(java.lang.String carrBgnnDt) {
		this.carrBgnnDt = carrBgnnDt;
	}

	public java.lang.String getCarrBgnnDtS() {
		return carrBgnnDtS;
	}

	public void setCarrBgnnDtS(java.lang.String carrBgnnDtS) {
		this.carrBgnnDtS = carrBgnnDtS;
	}

	public java.lang.String getCarrBgnnDtE() {
		return carrBgnnDtE;
	}

	public void setCarrBgnnDtE(java.lang.String carrBgnnDtE) {
		this.carrBgnnDtE = carrBgnnDtE;
	}

	public java.lang.String getQftntLicnsNum() {
		return qftntLicnsNum;
	}

	public void setQftntLicnsNum(java.lang.String qftntLicnsNum) {
		this.qftntLicnsNum = qftntLicnsNum;
	}

	public java.lang.String getAqtnDt() {
		return aqtnDt;
	}

	public void setAqtnDt(java.lang.String aqtnDt) {
		this.aqtnDt = aqtnDt;
	}

	public java.lang.String getAqtnDtS() {
		return aqtnDtS;
	}

	public void setAqtnDtS(java.lang.String aqtnDtS) {
		this.aqtnDtS = aqtnDtS;
	}

	public java.lang.String getAqtnDtE() {
		return aqtnDtE;
	}

	public void setAqtnDtE(java.lang.String aqtnDtE) {
		this.aqtnDtE = aqtnDtE;
	}

	public java.lang.String getEduKndNm() {
		return eduKndNm;
	}

	public void setEduKndNm(java.lang.String eduKndNm) {
		this.eduKndNm = eduKndNm;
	}

	public java.lang.String getEduBgnnDt() {
		return eduBgnnDt;
	}

	public void setEduBgnnDt(java.lang.String eduBgnnDt) {
		this.eduBgnnDt = eduBgnnDt;
	}

	public java.lang.String getEduBgnnDtS() {
		return eduBgnnDtS;
	}

	public void setEduBgnnDtS(java.lang.String eduBgnnDtS) {
		this.eduBgnnDtS = eduBgnnDtS;
	}

	public java.lang.String getEduBgnnDtE() {
		return eduBgnnDtE;
	}

	public void setEduBgnnDtE(java.lang.String eduBgnnDtE) {
		this.eduBgnnDtE = eduBgnnDtE;
	}

	public java.lang.String getDsnyActDivCd() {
		return dsnyActDivCd;
	}

	public void setDsnyActDivCd(java.lang.String dsnyActDivCd) {
		this.dsnyActDivCd = dsnyActDivCd;
	}

	public java.lang.String getDsnyActDsplDt() {
		return dsnyActDsplDt;
	}

	public void setDsnyActDsplDt(java.lang.String dsnyActDsplDt) {
		this.dsnyActDsplDt = dsnyActDsplDt;
	}

	public java.lang.String getDsnyActDsplDtS() {
		return dsnyActDsplDtS;
	}

	public void setDsnyActDsplDtS(java.lang.String dsnyActDsplDtS) {
		this.dsnyActDsplDtS = dsnyActDsplDtS;
	}

	public java.lang.String getDsnyActDsplDtE() {
		return dsnyActDsplDtE;
	}

	public void setDsnyActDsplDtE(java.lang.String dsnyActDsplDtE) {
		this.dsnyActDsplDtE = dsnyActDsplDtE;
	}

	public java.lang.String getLevfAbncDivCd() {
		return levfAbncDivCd;
	}

	public void setLevfAbncDivCd(java.lang.String levfAbncDivCd) {
		this.levfAbncDivCd = levfAbncDivCd;
	}

	public java.lang.String getLevfAbncBgnnDt() {
		return levfAbncBgnnDt;
	}

	public void setLevfAbncBgnnDt(java.lang.String levfAbncBgnnDt) {
		this.levfAbncBgnnDt = levfAbncBgnnDt;
	}

	public java.lang.String getLevfAbncBgnnDtS() {
		return levfAbncBgnnDtS;
	}

	public void setLevfAbncBgnnDtS(java.lang.String levfAbncBgnnDtS) {
		this.levfAbncBgnnDtS = levfAbncBgnnDtS;
	}

	public java.lang.String getLevfAbncBgnnDtE() {
		return levfAbncBgnnDtE;
	}

	public void setLevfAbncBgnnDtE(java.lang.String levfAbncBgnnDtE) {
		this.levfAbncBgnnDtE = levfAbncBgnnDtE;
	}
    
	public List<String> getHdofcCodtnCdArr() {
		return hdofcCodtnCdArr;
	}

	public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
		this.hdofcCodtnCdArr = hdofcCodtnCdArr;
	}

	public java.lang.String getQftntLicnsPovncCtnt() {
		return qftntLicnsPovncCtnt;
	}

	public void setQftntLicnsPovncCtnt(java.lang.String qftntLicnsPovncCtnt) {
		this.qftntLicnsPovncCtnt = qftntLicnsPovncCtnt;
	}
    
}
