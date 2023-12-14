package com.app.smrmf.infc.yearendtax.server.vo.yeta2020;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Yeta3900VO.java
 * @Description : Yeta3900VO class
 * @Modification Information
 *
 * @author HyunMin
 * @since 2016.01.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */


public class InfcPkgYe161010_2020_VO   implements Serializable {
	private static final long serialVersionUID = 1L;
	

	/** set null : divdPymt */
	private java.lang.String divdPymt;

	/** set null : divdPymtAmnt */
	private java.math.BigDecimal divdPymtAmnt;

	/** set null : divdPymtDivCd */
	private java.lang.String divdPymtDivCd;

	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;
	/**  단위사업장코드 : utDpobCd */
	private String utDpobCd;

	/** set 귀속연도 : yrtxBlggYr */
	private java.lang.String yrtxBlggYr;

	/** set 연말정산구분코드 : clutSeptCd */
	private java.lang.String clutSeptCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

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

	/** set 생성직원번호 : pernChrgEmpIdenNum */
	private java.lang.String pernChrgEmpIdenNum;

	/** set 마감여부 : closFlag */
	private java.lang.String closFlag;

	/** set 마감건수 : closCont */
	private java.math.BigDecimal closCont;

	/** set 마감일자 : closDate */
	private java.lang.String closDate;

	/** set 연말정산제출일자 : edacPrdt */
	private java.lang.String edacPrdt;

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
	
	/** set 주민등록번호 : resnRegnNum */
	private java.lang.String resnRegnNum;
	
	/** set 검증여부 : creOriginYn */
	private java.lang.String creOriginYn;

	/** set PDF 패스워드 : crePasswd */
	private java.lang.String crePasswd;
	
	/** set 검증여부 : ddcCreOriginYn */
	private java.lang.String ddcCreOriginYn;
	
	/** set PDF 패스워드 : ddcCrePasswd */
	private java.lang.String ddcCrePasswd;
	
	/** set 정산반영여부 : stlRflSttChkYn */
	private java.lang.String stlRflSttChkYn;
	
	/** set 소득공제신고서연말정산반영여부 : ddcStlRflSttChkYn */
	private java.lang.String ddcStlRflSttChkYn;
	
	/** set 간소화폼구분코드 : formCd */
	
	private java.lang.String xmlFormCd;
	
	private java.lang.String spciDdctCheck;
	
	
	/***********************************************
	 *  검색조건값을 넘김  등 기타조건등 처리를 위한 값.
	 ***********************************************/
	/** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String srhPayrMangDeptCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String srhEmymtDivCd;
    
    /** set 부서코드 : deptCd */
    private java.lang.String srhDeptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String srhTypOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String srhDtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String srhPyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String srhDtilOccuInttnCd;

    /** set 사업코드 : businCd */
    private java.lang.String srhBusinCd;
     
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    
    private java.lang.String addCheck;
    
    private java.lang.String creFile; 
    

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    

    /** 사업코드 BUSIN_CD  */
    private List<String> businCdArr; 
    
   
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     

    /** set 원천징수의무부서코드 : yetaDpcd */
   // private java.lang.String yetaDpcd;
    private java.lang.String whdgTxRegrstDeptCd;  
    private java.lang.String busoprRgstnum;  
    
    /*************************************************
     * 검색조건값을 넘김  등 기타조건등 처리를 위한 값.
     *************************************************/
    

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;

    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** set 재직구분코드 : hdofcDivCd */
    private java.lang.String hdofcDivCd;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 연말정산적용년월 : yrtxApptnYrMnth */
    private java.lang.String yrtxApptnYrMnth;

    /** set 연말정산처리일자 : yrtxPrcsDt */
    private java.lang.String yrtxPrcsDt;

    /** set 연말정산처리여부 : yrtxPrcsYn */
    private  java.lang.String yrtxPrcsYn;
    
    /** set 주민등록번호 : txprDscmNoCntn */
    private java.lang.String txprDscmNoCntn;

    

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymt()
	 * @brief date:2020 2020. 2. 25. user:atres
	 * @return the divdPymt get
	 */
	public java.lang.String getDivdPymt() {
		return divdPymt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymt(java.lang.String divdPymt)
	 *@brief date:2020 2020. 2. 25. user:atres
	 *@param divdPymt the divdPymt to set
	 */
	public void setDivdPymt(java.lang.String divdPymt) {
		this.divdPymt = divdPymt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getDivdPymtAmnt()
	 * @brief date:2020 2020. 2. 25. user:atres
	 * @return the divdPymtAmnt get
	 */
	public java.math.BigDecimal getDivdPymtAmnt() {
		return divdPymtAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtAmnt(java.math.BigDecimal divdPymtAmnt)
	 *@brief date:2020 2020. 2. 25. user:atres
	 *@param divdPymtAmnt the divdPymtAmnt to set
	 */
	public void setDivdPymtAmnt(java.math.BigDecimal divdPymtAmnt) {
		this.divdPymtAmnt = divdPymtAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymtDivCd()
	 * @brief date:2020 2020. 2. 25. user:atres
	 * @return the divdPymtDivCd get
	 */
	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtDivCd(java.lang.String divdPymtDivCd)
	 *@brief date:2020 2020. 2. 25. user:atres
	 *@param divdPymtDivCd the divdPymtDivCd to set
	 */
	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	public java.lang.String getTxprDscmNoCntn() {
		return txprDscmNoCntn;
	}

	public void setTxprDscmNoCntn(java.lang.String txprDscmNoCntn) {
		this.txprDscmNoCntn = txprDscmNoCntn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSpciDdctCheck()
	 * @brief date:2020 2020. 1. 27. user:atres
	 * @return the spciDdctCheck get
	 */
	public java.lang.String getSpciDdctCheck() {
		return spciDdctCheck;
	}

	/**
	 * Comment : 
	 *@fn void setSpciDdctCheck(java.lang.String spciDdctCheck)
	 *@brief date:2020 2020. 1. 27. user:atres
	 *@param spciDdctCheck the spciDdctCheck to set
	 */
	public void setSpciDdctCheck(java.lang.String spciDdctCheck) {
		this.spciDdctCheck = spciDdctCheck;
	}

	/**
	 * Comment : 폼구분코드
	 * @fn java.lang.String getXmlFormCd()
	 * @brief date:2020 2020. 1. 22. user:atres
	 * @return the xmlFormCd get
	 */
	public java.lang.String getXmlFormCd() {
		return xmlFormCd;
	}

	/**
	 * Comment : 폼구분코드
	 *@fn void setXmlFormCd(java.lang.String xmlFormCd)
	 *@brief date:2020 2020. 1. 22. user:atres
	 *@param xmlFormCd the xmlFormCd to set
	 */
	public void setXmlFormCd(java.lang.String xmlFormCd) {
		this.xmlFormCd = xmlFormCd;
	}

	/**
	 * Comment : 소득공제신고서연말정산반영여부
	 * @fn java.lang.String getDdcStlRflSttChkYn()
	 * @brief date:2020 2020. 1. 22. user:atres
	 * @return the ddcStlRflSttChkYn get
	 */
	public java.lang.String getDdcStlRflSttChkYn() {
		return ddcStlRflSttChkYn;
	}

	/**
	 * Comment : 소득공제신고서연말정산반영여부
	 *@fn void setDdcStlRflSttChkYn(java.lang.String ddcStlRflSttChkYn)
	 *@brief date:2020 2020. 1. 22. user:atres
	 *@param ddcStlRflSttChkYn the ddcStlRflSttChkYn to set
	 */
	public void setDdcStlRflSttChkYn(java.lang.String ddcStlRflSttChkYn) {
		this.ddcStlRflSttChkYn = ddcStlRflSttChkYn;
	}

	/**
	 * Comment : 정산반영여부
	 * @fn java.lang.String getStlRflSttChkYn()
	 * @brief date:2020 2020. 1. 22. user:atres
	 * @return the stlRflSttChkYn get
	 */
	public java.lang.String getStlRflSttChkYn() {
		return stlRflSttChkYn;
	}

	/**
	 * Comment : 정산반영여부
	 *@fn void setStlRflSttChkYn(java.lang.String stlRflSttChkYn)
	 *@brief date:2020 2020. 1. 22. user:atres
	 *@param stlRflSttChkYn the stlRflSttChkYn to set
	 */
	public void setStlRflSttChkYn(java.lang.String stlRflSttChkYn) {
		this.stlRflSttChkYn = stlRflSttChkYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOdtyCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the odtyCd get
	 */
	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	/**
	 * Comment : 
	 *@fn void setOdtyCd(java.lang.String odtyCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param odtyCd the odtyCd to set
	 */
	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the pyspCd get
	 */
	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspCd(java.lang.String pyspCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param pyspCd the pyspCd to set
	 */
	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getLogSvcYrNumCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the logSvcYrNumCd get
	 */
	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	/**
	 * Comment : 
	 *@fn void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param logSvcYrNumCd the logSvcYrNumCd to set
	 */
	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getLogSvcMnthIcmCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the logSvcMnthIcmCd get
	 */
	public java.lang.String getLogSvcMnthIcmCd() {
		return logSvcMnthIcmCd;
	}

	/**
	 * Comment : 
	 *@fn void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param logSvcMnthIcmCd the logSvcMnthIcmCd to set
	 */
	public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
		this.logSvcMnthIcmCd = logSvcMnthIcmCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFrstEmymtDt()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the frstEmymtDt get
	 */
	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}

	/**
	 * Comment : 
	 *@fn void setFrstEmymtDt(java.lang.String frstEmymtDt)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param frstEmymtDt the frstEmymtDt to set
	 */
	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtBgnnDt()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the emymtBgnnDt get
	 */
	public java.lang.String getEmymtBgnnDt() {
		return emymtBgnnDt;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtBgnnDt(java.lang.String emymtBgnnDt)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param emymtBgnnDt the emymtBgnnDt to set
	 */
	public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
		this.emymtBgnnDt = emymtBgnnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtEndDt()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the emymtEndDt get
	 */
	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtEndDt(java.lang.String emymtEndDt)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param emymtEndDt the emymtEndDt to set
	 */
	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHdofcDivCd()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the hdofcDivCd get
	 */
	public java.lang.String getHdofcDivCd() {
		return hdofcDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setHdofcDivCd(java.lang.String hdofcDivCd)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param hdofcDivCd the hdofcDivCd to set
	 */
	public void setHdofcDivCd(java.lang.String hdofcDivCd) {
		this.hdofcDivCd = hdofcDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRetryDt()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the retryDt get
	 */
	public java.lang.String getRetryDt() {
		return retryDt;
	}

	/**
	 * Comment : 
	 *@fn void setRetryDt(java.lang.String retryDt)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param retryDt the retryDt to set
	 */
	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxApptnYrMnth()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the yrtxApptnYrMnth get
	 */
	public java.lang.String getYrtxApptnYrMnth() {
		return yrtxApptnYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxApptnYrMnth(java.lang.String yrtxApptnYrMnth)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param yrtxApptnYrMnth the yrtxApptnYrMnth to set
	 */
	public void setYrtxApptnYrMnth(java.lang.String yrtxApptnYrMnth) {
		this.yrtxApptnYrMnth = yrtxApptnYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxPrcsDt()
	 * @brief date:2020 2020. 1. 16. user:atres
	 * @return the yrtxPrcsDt get
	 */
	public java.lang.String getYrtxPrcsDt() {
		return yrtxPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrcsDt(java.lang.String yrtxPrcsDt)
	 *@brief date:2020 2020. 1. 16. user:atres
	 *@param yrtxPrcsDt the yrtxPrcsDt to set
	 */
	public void setYrtxPrcsDt(java.lang.String yrtxPrcsDt) {
		this.yrtxPrcsDt = yrtxPrcsDt;
	}

 

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxPrcsYn()
	 * @brief date:2020 2020. 2. 26. user:atres
	 * @return the yrtxPrcsYn get
	 */
	public java.lang.String getYrtxPrcsYn() {
		return yrtxPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrcsYn(java.lang.String yrtxPrcsYn)
	 *@brief date:2020 2020. 2. 26. user:atres
	 *@param yrtxPrcsYn the yrtxPrcsYn to set
	 */
	public void setYrtxPrcsYn(java.lang.String yrtxPrcsYn) {
		this.yrtxPrcsYn = yrtxPrcsYn;
	}

	public java.lang.String getCreOriginYn() {
		return creOriginYn;
	}

	/**
	 * Comment : 
	 * @fn String getUtDpobCd()
	 * @brief date:2020 2020. 1. 15. user:atres
	 * @return the utDpobCd get
	 */
	public String getUtDpobCd() {
		return utDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setUtDpobCd(String utDpobCd)
	 *@brief date:2020 2020. 1. 15. user:atres
	 *@param utDpobCd the utDpobCd to set
	 */
	public void setUtDpobCd(String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPayrMangDeptCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhPayrMangDeptCd get
	 */
	public java.lang.String getSrhPayrMangDeptCd() {
		return srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhPayrMangDeptCd the srhPayrMangDeptCd to set
	 */
	public void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd) {
		this.srhPayrMangDeptCd = srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhEmymtDivCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhEmymtDivCd get
	 */
	public java.lang.String getSrhEmymtDivCd() {
		return srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhEmymtDivCd the srhEmymtDivCd to set
	 */
	public void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd) {
		this.srhEmymtDivCd = srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDeptCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhDeptCd get
	 */
	public java.lang.String getSrhDeptCd() {
		return srhDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDeptCd(java.lang.String srhDeptCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhDeptCd the srhDeptCd to set
	 */
	public void setSrhDeptCd(java.lang.String srhDeptCd) {
		this.srhDeptCd = srhDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhTypOccuCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhTypOccuCd get
	 */
	public java.lang.String getSrhTypOccuCd() {
		return srhTypOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhTypOccuCd(java.lang.String srhTypOccuCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhTypOccuCd the srhTypOccuCd to set
	 */
	public void setSrhTypOccuCd(java.lang.String srhTypOccuCd) {
		this.srhTypOccuCd = srhTypOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuClsDivCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhDtilOccuClsDivCd get
	 */
	public java.lang.String getSrhDtilOccuClsDivCd() {
		return srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhDtilOccuClsDivCd the srhDtilOccuClsDivCd to set
	 */
	public void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd) {
		this.srhDtilOccuClsDivCd = srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPyspGrdeCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhPyspGrdeCd get
	 */
	public java.lang.String getSrhPyspGrdeCd() {
		return srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhPyspGrdeCd the srhPyspGrdeCd to set
	 */
	public void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd) {
		this.srhPyspGrdeCd = srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuInttnCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhDtilOccuInttnCd get
	 */
	public java.lang.String getSrhDtilOccuInttnCd() {
		return srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhDtilOccuInttnCd the srhDtilOccuInttnCd to set
	 */
	public void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd) {
		this.srhDtilOccuInttnCd = srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhBusinCd()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the srhBusinCd get
	 */
	public java.lang.String getSrhBusinCd() {
		return srhBusinCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhBusinCd(java.lang.String srhBusinCd)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param srhBusinCd the srhBusinCd to set
	 */
	public void setSrhBusinCd(java.lang.String srhBusinCd) {
		this.srhBusinCd = srhBusinCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCdAuth()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the deptCdAuth get
	 */
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param deptCdAuth the deptCdAuth to set
	 */
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptYn()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the payrMangDeptYn get
	 */
	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param payrMangDeptYn the payrMangDeptYn to set
	 */
	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAddCheck()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the addCheck get
	 */
	public java.lang.String getAddCheck() {
		return addCheck;
	}

	/**
	 * Comment : 
	 *@fn void setAddCheck(java.lang.String addCheck)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param addCheck the addCheck to set
	 */
	public void setAddCheck(java.lang.String addCheck) {
		this.addCheck = addCheck;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCreFile()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the creFile get
	 */
	public java.lang.String getCreFile() {
		return creFile;
	}

	/**
	 * Comment : 
	 *@fn void setCreFile(java.lang.String creFile)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param creFile the creFile to set
	 */
	public void setCreFile(java.lang.String creFile) {
		this.creFile = creFile;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getBusinCdArr()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the businCdArr get
	 */
	public List<String> getBusinCdArr() {
		return businCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCdArr(List<String> businCdArr)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param businCdArr the businCdArr to set
	 */
	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

 

	/**
	 * Comment : 
	 * @fn java.lang.String getWhdgTxRegrstDeptCd()
	 * @brief date:2020 2020. 2. 14. user:atres
	 * @return the whdgTxRegrstDeptCd get
	 */
	public java.lang.String getWhdgTxRegrstDeptCd() {
		return whdgTxRegrstDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setWhdgTxRegrstDeptCd(java.lang.String whdgTxRegrstDeptCd)
	 *@brief date:2020 2020. 2. 14. user:atres
	 *@param whdgTxRegrstDeptCd the whdgTxRegrstDeptCd to set
	 */
	public void setWhdgTxRegrstDeptCd(java.lang.String whdgTxRegrstDeptCd) {
		this.whdgTxRegrstDeptCd = whdgTxRegrstDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusoprRgstnum()
	 * @brief date:2020 2020. 1. 8. user:atres
	 * @return the busoprRgstnum get
	 */
	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprRgstnum(java.lang.String busoprRgstnum)
	 *@brief date:2020 2020. 1. 8. user:atres
	 *@param busoprRgstnum the busoprRgstnum to set
	 */
	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

	public void setCreOriginYn(java.lang.String creOriginYn) {
		this.creOriginYn = creOriginYn;
	}

	public java.lang.String getCrePasswd() {
		return crePasswd;
	}

	public void setCrePasswd(java.lang.String crePasswd) {
		this.crePasswd = crePasswd;
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

	public java.lang.String getPernChrgEmpIdenNum() {
		return pernChrgEmpIdenNum;
	}

	public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
		this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
	}

	public java.lang.String getClosFlag() {
		return closFlag;
	}

	public void setClosFlag(java.lang.String closFlag) {
		this.closFlag = closFlag;
	}

	public java.math.BigDecimal getClosCont() {
		return closCont;
	}

	public void setClosCont(java.math.BigDecimal closCont) {
		this.closCont = closCont;
	}

	public java.lang.String getClosDate() {
		return closDate;
	}

	public void setClosDate(java.lang.String closDate) {
		this.closDate = closDate;
	}

	public java.lang.String getEdacPrdt() {
		return edacPrdt;
	}

	public void setEdacPrdt(java.lang.String edacPrdt) {
		this.edacPrdt = edacPrdt;
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

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}
	
	public java.lang.String getDdcCreOriginYn() {
		return ddcCreOriginYn;
	}

	public void setDdcCreOriginYn(java.lang.String ddcCreOriginYn) {
		this.ddcCreOriginYn = ddcCreOriginYn;
	}

	public java.lang.String getDdcCrePasswd() {
		return ddcCrePasswd;
	}

	public void setDdcCrePasswd(java.lang.String ddcCrePasswd) {
		this.ddcCrePasswd = ddcCrePasswd;
	}
	

}