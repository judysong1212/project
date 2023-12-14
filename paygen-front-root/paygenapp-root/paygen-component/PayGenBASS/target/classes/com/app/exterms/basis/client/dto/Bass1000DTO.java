package com.app.exterms.basis.client.dto;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Yeta1000VO.java
 * @Description : Yeta1000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass1000DTO extends BaseModel {
    private static final long serialVersionUID = 1L;
  
    
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 연말정산마감일련번호 : edacSeilNum */
    private Long edacSeilNum;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 생성직원번호 : pernChrgEmpIdenNum */
    private java.lang.String pernChrgEmpIdenNum;

    /** set 마감여부 : closFlag */
    private java.lang.String closFlag;

    /** set 마감건수 : closCont */
    private Long closCont;

    /** set 마감일자 : closDate */
    private java.lang.String closDate;

    /** set 연말정산제출일자 : edacPrdt */
    private java.lang.String edacPrdt;

    /** set 대표자성명 : reprName */
    private java.lang.String reprName;

    /** set 법인명_상호 : juriName */
    private java.lang.String juriName;

    /** set 사업자등록번호 : busiNumb */
    private java.lang.String busiNumb;

    /** set 주민등록번호 : resuNumb */
    private java.lang.String resuNumb;

    /** set 법인번호 : juriNumb */
    private java.lang.String juriNumb;

    /** set 소득신고의무자우편번호 : incmPost */
    private java.lang.String incmPost;

    /** set 소득신고의무자기본주소 : incmAddr */
    private java.lang.String incmAddr;

    /** set 소득신고의무자상세주소 : incmAdtl */
    private java.lang.String incmAdtl;

    /** set 관할세무서코드 : taxaCode */
    private java.lang.String taxaCode;

    /** set 제출자구분코드 : incmGbcd */
    private java.lang.String incmGbcd;

    /** set 세무대리인번호 : taxaDnum */
    private java.lang.String taxaDnum;

    /** set 홈텍스ID : homeTxid */
    private java.lang.String homeTxid;

    /** set 세무프로그램코드 : taxaPrcd */
    private java.lang.String taxaPrcd;

    /** set 담당자부서명 : charDept */
    private java.lang.String charDept;

    /** set 담당자성명 : charName */
    private java.lang.String charName;

    /** set 담당자전화번호 : charTele */
    private java.lang.String charTele;

    /** set FILE_PASS : filePass */
    private java.lang.String filePass;

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

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth; 
    
    
    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 조기출근집계여부 : eryGtwkTotYn */
    private java.lang.String eryGtwkTotYn;

    /** set 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
    private java.lang.String dilnlazDducPaySubtnYn;

    /** set 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
    private java.lang.String wklyHldyExtpyPrcsYn;

    /** set 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
    private java.lang.String wkdyNorTmCttgDivCd;

    /** set 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
    private java.lang.String wkdyExtnnCttgDivCd;

    /** set 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
    private java.lang.String wkdyNgtCttgDivCd;

    /** set 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
    private java.lang.String pubcHodyNorTmCttgCd;

    /** set 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
    private java.lang.String pubcHodyExtnnTmCttgCd;

    /** set 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
    private java.lang.String wkdyNorDutyMrkDivCd;

    /** set 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
    private java.lang.String wkdyExtnnMrkDivCd;

    /** set 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
    private java.lang.String wkdyNgtMrkDivCd;

    /** set 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
    private java.lang.String pubcHodyNorMrkDivCd;

    /** set 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
    private java.lang.String pubcHodyExtnnMrkCd;

    /** set 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
    private java.lang.String pubcHodyNgtMrkDivCd;
 
    /** set 복무공통설정일련번호 : servcCommSeilNum */
    private java.math.BigDecimal servcCommSeilNum;
 
    /**
	 * Comment : 
	 * @fn java.lang.String getStpInttnSeptVal()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the stpInttnSeptVal get
	 */
	public java.lang.String getStpInttnSeptVal() {
		return stpInttnSeptVal;
	}

	/**
	 * Comment : 
	 *@fn void setStpInttnSeptVal(java.lang.String stpInttnSeptVal)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param stpInttnSeptVal the stpInttnSeptVal to set
	 */
	public void setStpInttnSeptVal(java.lang.String stpInttnSeptVal) {
		this.stpInttnSeptVal = stpInttnSeptVal;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEryGtwkTotYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the eryGtwkTotYn get
	 */
	public java.lang.String getEryGtwkTotYn() {
		return eryGtwkTotYn;
	}

	/**
	 * Comment : 
	 *@fn void setEryGtwkTotYn(java.lang.String eryGtwkTotYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param eryGtwkTotYn the eryGtwkTotYn to set
	 */
	public void setEryGtwkTotYn(java.lang.String eryGtwkTotYn) {
		this.eryGtwkTotYn = eryGtwkTotYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDilnlazDducPaySubtnYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the dilnlazDducPaySubtnYn get
	 */
	public java.lang.String getDilnlazDducPaySubtnYn() {
		return dilnlazDducPaySubtnYn;
	}

	/**
	 * Comment : 
	 *@fn void setDilnlazDducPaySubtnYn(java.lang.String dilnlazDducPaySubtnYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param dilnlazDducPaySubtnYn the dilnlazDducPaySubtnYn to set
	 */
	public void setDilnlazDducPaySubtnYn(java.lang.String dilnlazDducPaySubtnYn) {
		this.dilnlazDducPaySubtnYn = dilnlazDducPaySubtnYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWklyHldyExtpyPrcsYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wklyHldyExtpyPrcsYn get
	 */
	public java.lang.String getWklyHldyExtpyPrcsYn() {
		return wklyHldyExtpyPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setWklyHldyExtpyPrcsYn(java.lang.String wklyHldyExtpyPrcsYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wklyHldyExtpyPrcsYn the wklyHldyExtpyPrcsYn to set
	 */
	public void setWklyHldyExtpyPrcsYn(java.lang.String wklyHldyExtpyPrcsYn) {
		this.wklyHldyExtpyPrcsYn = wklyHldyExtpyPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyNorTmCttgDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyNorTmCttgDivCd get
	 */
	public java.lang.String getWkdyNorTmCttgDivCd() {
		return wkdyNorTmCttgDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyNorTmCttgDivCd(java.lang.String wkdyNorTmCttgDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyNorTmCttgDivCd the wkdyNorTmCttgDivCd to set
	 */
	public void setWkdyNorTmCttgDivCd(java.lang.String wkdyNorTmCttgDivCd) {
		this.wkdyNorTmCttgDivCd = wkdyNorTmCttgDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyExtnnCttgDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyExtnnCttgDivCd get
	 */
	public java.lang.String getWkdyExtnnCttgDivCd() {
		return wkdyExtnnCttgDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyExtnnCttgDivCd(java.lang.String wkdyExtnnCttgDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyExtnnCttgDivCd the wkdyExtnnCttgDivCd to set
	 */
	public void setWkdyExtnnCttgDivCd(java.lang.String wkdyExtnnCttgDivCd) {
		this.wkdyExtnnCttgDivCd = wkdyExtnnCttgDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyNgtCttgDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyNgtCttgDivCd get
	 */
	public java.lang.String getWkdyNgtCttgDivCd() {
		return wkdyNgtCttgDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyNgtCttgDivCd(java.lang.String wkdyNgtCttgDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyNgtCttgDivCd the wkdyNgtCttgDivCd to set
	 */
	public void setWkdyNgtCttgDivCd(java.lang.String wkdyNgtCttgDivCd) {
		this.wkdyNgtCttgDivCd = wkdyNgtCttgDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyNorTmCttgCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyNorTmCttgCd get
	 */
	public java.lang.String getPubcHodyNorTmCttgCd() {
		return pubcHodyNorTmCttgCd;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyNorTmCttgCd(java.lang.String pubcHodyNorTmCttgCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyNorTmCttgCd the pubcHodyNorTmCttgCd to set
	 */
	public void setPubcHodyNorTmCttgCd(java.lang.String pubcHodyNorTmCttgCd) {
		this.pubcHodyNorTmCttgCd = pubcHodyNorTmCttgCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyExtnnTmCttgCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyExtnnTmCttgCd get
	 */
	public java.lang.String getPubcHodyExtnnTmCttgCd() {
		return pubcHodyExtnnTmCttgCd;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyExtnnTmCttgCd(java.lang.String pubcHodyExtnnTmCttgCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyExtnnTmCttgCd the pubcHodyExtnnTmCttgCd to set
	 */
	public void setPubcHodyExtnnTmCttgCd(java.lang.String pubcHodyExtnnTmCttgCd) {
		this.pubcHodyExtnnTmCttgCd = pubcHodyExtnnTmCttgCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyNorDutyMrkDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyNorDutyMrkDivCd get
	 */
	public java.lang.String getWkdyNorDutyMrkDivCd() {
		return wkdyNorDutyMrkDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyNorDutyMrkDivCd(java.lang.String wkdyNorDutyMrkDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyNorDutyMrkDivCd the wkdyNorDutyMrkDivCd to set
	 */
	public void setWkdyNorDutyMrkDivCd(java.lang.String wkdyNorDutyMrkDivCd) {
		this.wkdyNorDutyMrkDivCd = wkdyNorDutyMrkDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyExtnnMrkDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyExtnnMrkDivCd get
	 */
	public java.lang.String getWkdyExtnnMrkDivCd() {
		return wkdyExtnnMrkDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyExtnnMrkDivCd(java.lang.String wkdyExtnnMrkDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyExtnnMrkDivCd the wkdyExtnnMrkDivCd to set
	 */
	public void setWkdyExtnnMrkDivCd(java.lang.String wkdyExtnnMrkDivCd) {
		this.wkdyExtnnMrkDivCd = wkdyExtnnMrkDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWkdyNgtMrkDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the wkdyNgtMrkDivCd get
	 */
	public java.lang.String getWkdyNgtMrkDivCd() {
		return wkdyNgtMrkDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWkdyNgtMrkDivCd(java.lang.String wkdyNgtMrkDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param wkdyNgtMrkDivCd the wkdyNgtMrkDivCd to set
	 */
	public void setWkdyNgtMrkDivCd(java.lang.String wkdyNgtMrkDivCd) {
		this.wkdyNgtMrkDivCd = wkdyNgtMrkDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyNorMrkDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyNorMrkDivCd get
	 */
	public java.lang.String getPubcHodyNorMrkDivCd() {
		return pubcHodyNorMrkDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyNorMrkDivCd(java.lang.String pubcHodyNorMrkDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyNorMrkDivCd the pubcHodyNorMrkDivCd to set
	 */
	public void setPubcHodyNorMrkDivCd(java.lang.String pubcHodyNorMrkDivCd) {
		this.pubcHodyNorMrkDivCd = pubcHodyNorMrkDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyExtnnMrkCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyExtnnMrkCd get
	 */
	public java.lang.String getPubcHodyExtnnMrkCd() {
		return pubcHodyExtnnMrkCd;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyExtnnMrkCd(java.lang.String pubcHodyExtnnMrkCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyExtnnMrkCd the pubcHodyExtnnMrkCd to set
	 */
	public void setPubcHodyExtnnMrkCd(java.lang.String pubcHodyExtnnMrkCd) {
		this.pubcHodyExtnnMrkCd = pubcHodyExtnnMrkCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyNgtMrkDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyNgtMrkDivCd get
	 */
	public java.lang.String getPubcHodyNgtMrkDivCd() {
		return pubcHodyNgtMrkDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyNgtMrkDivCd(java.lang.String pubcHodyNgtMrkDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyNgtMrkDivCd the pubcHodyNgtMrkDivCd to set
	 */
	public void setPubcHodyNgtMrkDivCd(java.lang.String pubcHodyNgtMrkDivCd) {
		this.pubcHodyNgtMrkDivCd = pubcHodyNgtMrkDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getServcCommSeilNum()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the servcCommSeilNum get
	 */
	public java.math.BigDecimal getServcCommSeilNum() {
		return servcCommSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setServcCommSeilNum(java.math.BigDecimal servcCommSeilNum)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param servcCommSeilNum the servcCommSeilNum to set
	 */
	public void setServcCommSeilNum(java.math.BigDecimal servcCommSeilNum) {
		this.servcCommSeilNum = servcCommSeilNum;
	}

	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2016 Jan 25, 2016 user:leeheuisung
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2016 Jan 25, 2016 user:leeheuisung
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn Long getEdacSeilNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the edacSeilNum get
	 */
	public Long getEdacSeilNum() {
		return edacSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEdacSeilNum(Long edacSeilNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param edacSeilNum the edacSeilNum to set
	 */
	public void setEdacSeilNum(Long edacSeilNum) {
		this.edacSeilNum = edacSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the businCd get
	 */
	public java.lang.String getBusinCd() {
		return businCd;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCd(java.lang.String businCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param businCd the businCd to set
	 */
	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPernChrgEmpIdenNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the pernChrgEmpIdenNum get
	 */
	public java.lang.String getPernChrgEmpIdenNum() {
		return pernChrgEmpIdenNum;
	}

	/**
	 * Comment : 
	 *@fn void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param pernChrgEmpIdenNum the pernChrgEmpIdenNum to set
	 */
	public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
		this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
	}

 
	public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getClosFlag() {
        return this.closFlag;
    }
    
    public void setClosFlag(java.lang.String closFlag) {
        this.closFlag = closFlag;
    }
    
    public Long getClosCont() {
        return this.closCont;
    }
    
    public void setClosCont(Long closCont) {
        this.closCont = closCont;
    }
    
    public java.lang.String getClosDate() {
        return this.closDate;
    }
    
    public void setClosDate(java.lang.String closDate) {
        this.closDate = closDate;
    }
    
    public java.lang.String getEdacPrdt() {
        return this.edacPrdt;
    }
    
    public void setEdacPrdt(java.lang.String edacPrdt) {
        this.edacPrdt = edacPrdt;
    }
    
    public java.lang.String getReprName() {
        return this.reprName;
    }
    
    public void setReprName(java.lang.String reprName) {
        this.reprName = reprName;
    }
    
    public java.lang.String getJuriName() {
        return this.juriName;
    }
    
    public void setJuriName(java.lang.String juriName) {
        this.juriName = juriName;
    }
    
    public java.lang.String getBusiNumb() {
        return this.busiNumb;
    }
    
    public void setBusiNumb(java.lang.String busiNumb) {
        this.busiNumb = busiNumb;
    }
    
    public java.lang.String getResuNumb() {
        return this.resuNumb;
    }
    
    public void setResuNumb(java.lang.String resuNumb) {
        this.resuNumb = resuNumb;
    }
    
    public java.lang.String getJuriNumb() {
        return this.juriNumb;
    }
    
    public void setJuriNumb(java.lang.String juriNumb) {
        this.juriNumb = juriNumb;
    }
    
    public java.lang.String getIncmPost() {
        return this.incmPost;
    }
    
    public void setIncmPost(java.lang.String incmPost) {
        this.incmPost = incmPost;
    }
    
    public java.lang.String getIncmAddr() {
        return this.incmAddr;
    }
    
    public void setIncmAddr(java.lang.String incmAddr) {
        this.incmAddr = incmAddr;
    }
    
    public java.lang.String getIncmAdtl() {
        return this.incmAdtl;
    }
    
    public void setIncmAdtl(java.lang.String incmAdtl) {
        this.incmAdtl = incmAdtl;
    }
    
    public java.lang.String getTaxaCode() {
        return this.taxaCode;
    }
    
    public void setTaxaCode(java.lang.String taxaCode) {
        this.taxaCode = taxaCode;
    }
    
    public java.lang.String getIncmGbcd() {
        return this.incmGbcd;
    }
    
    public void setIncmGbcd(java.lang.String incmGbcd) {
        this.incmGbcd = incmGbcd;
    }
    
    public java.lang.String getTaxaDnum() {
        return this.taxaDnum;
    }
    
    public void setTaxaDnum(java.lang.String taxaDnum) {
        this.taxaDnum = taxaDnum;
    }
    
    public java.lang.String getHomeTxid() {
        return this.homeTxid;
    }
    
    public void setHomeTxid(java.lang.String homeTxid) {
        this.homeTxid = homeTxid;
    }
    
    public java.lang.String getTaxaPrcd() {
        return this.taxaPrcd;
    }
    
    public void setTaxaPrcd(java.lang.String taxaPrcd) {
        this.taxaPrcd = taxaPrcd;
    }
    
    public java.lang.String getCharDept() {
        return this.charDept;
    }
    
    public void setCharDept(java.lang.String charDept) {
        this.charDept = charDept;
    }
    
    public java.lang.String getCharName() {
        return this.charName;
    }
    
    public void setCharName(java.lang.String charName) {
        this.charName = charName;
    }
    
    public java.lang.String getCharTele() {
        return this.charTele;
    }
    
    public void setCharTele(java.lang.String charTele) {
        this.charTele = charTele;
    }
    
    public java.lang.String getFilePass() {
        return this.filePass;
    }
    
    public void setFilePass(java.lang.String filePass) {
        this.filePass = filePass;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    
//	/** set SYSTEMKEY : systemkey */
//	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
//	/** get SYSTEMKEY : systemkey */
//	public String getSystemkey() { return (String)get("systemkey");}
//    
//    /** set null : dpobCd */
//    public void setDpobCd(String  dpobCd) { set( "dpobCd" ,dpobCd);}
//    /** get null : dpobCd */
//    public String  getDpobCd() { return (String )get("dpobCd" );}
//
//    /** set 연말정산귀속년도 : edacRvyy */
//    public void setEdacRvyy(String  edacRvyy) { set( "edacRvyy" ,edacRvyy);}
//    /** get 연말정산귀속년도 : edacRvyy */
//    public String  getEdacRvyy() { return (String )get("edacRvyy" );}
//
//    /** set 정산구분코드 : settGbcd */
//    public void setSettGbcd(String  settGbcd) { set( "settGbcd" ,settGbcd);}
//    /** get 정산구분코드 : settGbcd */
//    public String  getSettGbcd() { return (String )get("settGbcd" );}
//
//    /** set 연말정산마감일련번호 : edacSeilNum */
//    public void setEdacSeilNum(Long  edacSeilNum) { set( "edacSeilNum" ,edacSeilNum);}
//    /** get 연말정산마감일련번호 : edacSeilNum */
//    public Long  getEdacSeilNum() { return (Long )get("edacSeilNum" );}
//
//    /** set 급여관리부서코드 : payrMangDeptCd */
//    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( "payrMangDeptCd" ,payrMangDeptCd);}
//    /** get 급여관리부서코드 : payrMangDeptCd */
//    public String  getPayrMangDeptCd() { return (String )get("payrMangDeptCd" );}
//
//    /** set 부서코드 : deptCd */
//    public void setDeptCd(String  deptCd) { set( "deptCd" ,deptCd);}
//    /** get 부서코드 : deptCd */
//    public String  getDeptCd() { return (String )get("deptCd" );}
//
//    /** set 직종코드 : typOccuCd */
//    public void setTypOccuCd(String  typOccuCd) { set( "typOccuCd" ,typOccuCd);}
//    /** get 직종코드 : typOccuCd */
//    public String  getTypOccuCd() { return (String )get("typOccuCd" );}
//
//    /** set 직종세구분코드 : dtilOccuClsDivCd */
//    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( "dtilOccuClsDivCd" ,dtilOccuClsDivCd);}
//    /** get 직종세구분코드 : dtilOccuClsDivCd */
//    public String  getDtilOccuClsDivCd() { return (String )get("dtilOccuClsDivCd" );}
//
//    /** set 호봉등급코드 : pyspGrdeCd */
//    public void setPyspGrdeCd(String  pyspGrdeCd) { set( "pyspGrdeCd" ,pyspGrdeCd);}
//    /** get 호봉등급코드 : pyspGrdeCd */
//    public String  getPyspGrdeCd() { return (String )get("pyspGrdeCd" );}
//
//    /** set 직종세통합코드 : dtilOccuInttnCd */
//    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( "dtilOccuInttnCd" ,dtilOccuInttnCd);}
//    /** get 직종세통합코드 : dtilOccuInttnCd */
//    public String  getDtilOccuInttnCd() { return (String )get("dtilOccuInttnCd" );}
//
//    /** set 사업코드 : businCd */
//    public void setBusinCd(String  businCd) { set( "businCd" ,businCd);}
//    /** get 사업코드 : businCd */
//    public String  getBusinCd() { return (String )get("businCd" );}
//
//    /** set 고용구분코드 : emymtDivCd */
//    public void setEmymtDivCd(String  emymtDivCd) { set( "emymtDivCd" ,emymtDivCd);}
//    /** get 고용구분코드 : emymtDivCd */
//    public String  getEmymtDivCd() { return (String )get("emymtDivCd" );}
//
//    /** set 생성직원번호 : pernChrgEmpIdenNum */
//    public void setPernChrgEmpIdenNum(String  pernChrgEmpIdenNum) { set( "pernChrgEmpIdenNum" ,pernChrgEmpIdenNum);}
//    /** get 생성직원번호 : pernChrgEmpIdenNum */
//    public String  getPernChrgEmpIdenNum() { return (String )get("pernChrgEmpIdenNum" );}
//
//    /** set 마감여부 : closFlag */
//    public void setClosFlag(String  closFlag) { set( "closFlag" ,closFlag);}
//    /** get 마감여부 : closFlag */
//    public String  getClosFlag() { return (String )get("closFlag" );}
//
//    /** set 마감건수 : closCont */
//    public void setClosCont(Long  closCont) { set( "closCont" ,closCont);}
//    /** get 마감건수 : closCont */
//    public Long  getClosCont() { return (Long )get("closCont" );}
//
//    /** set 마감일자 : closDate */
//    public void setClosDate(String  closDate) { set( "closDate" ,closDate);}
//    /** get 마감일자 : closDate */
//    public String  getClosDate() { return (String )get("closDate" );}
//
//    /** set 연말정산제출일자 : edacPrdt */
//    public void setEdacPrdt(String  edacPrdt) { set( "edacPrdt" ,edacPrdt);}
//    /** get 연말정산제출일자 : edacPrdt */
//    public String  getEdacPrdt() { return (String )get("edacPrdt" );}
//
//    /** set 대표자성명 : reprName */
//    public void setReprName(String  reprName) { set( "reprName" ,reprName);}
//    /** get 대표자성명 : reprName */
//    public String  getReprName() { return (String )get("reprName" );}
//
//    /** set 법인명_상호 : juriName */
//    public void setJuriName(String  juriName) { set( "juriName" ,juriName);}
//    /** get 법인명_상호 : juriName */
//    public String  getJuriName() { return (String )get("juriName" );}
//
//    /** set 사업자등록번호 : busiNumb */
//    public void setBusiNumb(String  busiNumb) { set( "busiNumb" ,busiNumb);}
//    /** get 사업자등록번호 : busiNumb */
//    public String  getBusiNumb() { return (String )get("busiNumb" );}
//
//    /** set 주민등록번호 : resuNumb */
//    public void setResuNumb(String  resuNumb) { set( "resuNumb" ,resuNumb);}
//    /** get 주민등록번호 : resuNumb */
//    public String  getResuNumb() { return (String )get("resuNumb" );}
//
//    /** set 법인번호 : juriNumb */
//    public void setJuriNumb(String  juriNumb) { set( "juriNumb" ,juriNumb);}
//    /** get 법인번호 : juriNumb */
//    public String  getJuriNumb() { return (String )get("juriNumb" );}
//
//    /** set 소득신고의무자우편번호 : incmPost */
//    public void setIncmPost(String  incmPost) { set( "incmPost" ,incmPost);}
//    /** get 소득신고의무자우편번호 : incmPost */
//    public String  getIncmPost() { return (String )get("incmPost" );}
//
//    /** set 소득신고의무자기본주소 : incmAddr */
//    public void setIncmAddr(String  incmAddr) { set( "incmAddr" ,incmAddr);}
//    /** get 소득신고의무자기본주소 : incmAddr */
//    public String  getIncmAddr() { return (String )get("incmAddr" );}
//
//    /** set 소득신고의무자상세주소 : incmAdtl */
//    public void setIncmAdtl(String  incmAdtl) { set( "incmAdtl" ,incmAdtl);}
//    /** get 소득신고의무자상세주소 : incmAdtl */
//    public String  getIncmAdtl() { return (String )get("incmAdtl" );}
//
//    /** set 관할세무서코드 : taxaCode */
//    public void setTaxaCode(String  taxaCode) { set( "taxaCode" ,taxaCode);}
//    /** get 관할세무서코드 : taxaCode */
//    public String  getTaxaCode() { return (String )get("taxaCode" );}
//
//    /** set 제출자구분코드 : incmGbcd */
//    public void setIncmGbcd(String  incmGbcd) { set( "incmGbcd" ,incmGbcd);}
//    /** get 제출자구분코드 : incmGbcd */
//    public String  getIncmGbcd() { return (String )get("incmGbcd" );}
//
//    /** set 세무대리인번호 : taxaDnum */
//    public void setTaxaDnum(String  taxaDnum) { set( "taxaDnum" ,taxaDnum);}
//    /** get 세무대리인번호 : taxaDnum */
//    public String  getTaxaDnum() { return (String )get("taxaDnum" );}
//
//    /** set 홈텍스ID : homeTxid */
//    public void setHomeTxid(String  homeTxid) { set( "homeTxid" ,homeTxid);}
//    /** get 홈텍스ID : homeTxid */
//    public String  getHomeTxid() { return (String )get("homeTxid" );}
//
//    /** set 세무프로그램코드 : taxaPrcd */
//    public void setTaxaPrcd(String  taxaPrcd) { set( "taxaPrcd" ,taxaPrcd);}
//    /** get 세무프로그램코드 : taxaPrcd */
//    public String  getTaxaPrcd() { return (String )get("taxaPrcd" );}
//
//    /** set 담당자부서명 : charDept */
//    public void setCharDept(String  charDept) { set( "charDept" ,charDept);}
//    /** get 담당자부서명 : charDept */
//    public String  getCharDept() { return (String )get("charDept" );}
//
//    /** set 담당자성명 : charName */
//    public void setCharName(String  charName) { set( "charName" ,charName);}
//    /** get 담당자성명 : charName */
//    public String  getCharName() { return (String )get("charName" );}
//
//    /** set 담당자전화번호 : charTele */
//    public void setCharTele(String  charTele) { set( "charTele" ,charTele);}
//    /** get 담당자전화번호 : charTele */
//    public String  getCharTele() { return (String )get("charTele" );}
//
//    /** set FILE_PASS : filePass */
//    public void setFilePass(String  filePass) { set( "filePass" ,filePass);}
//    /** get FILE_PASS : filePass */
//    public String  getFilePass() { return (String )get("filePass" );}
//
//    /** set 입력자 : kybdr */
//    public void setKybdr(String  kybdr) { set( "kybdr" ,kybdr);}
//    /** get 입력자 : kybdr */
//    public String  getKybdr() { return (String )get("kybdr" );}
//
//    /** set 입력일자 : inptDt */
//    public void setInptDt(String  inptDt) { set( "inptDt" ,inptDt);}
//    /** get 입력일자 : inptDt */
//    public String  getInptDt() { return (String )get("inptDt" );}
//
//    /** set 입력주소 : inptAddr */
//    public void setInptAddr(String  inptAddr) { set( "inptAddr" ,inptAddr);}
//    /** get 입력주소 : inptAddr */
//    public String  getInptAddr() { return (String )get("inptAddr" );}
//
//    /** set 수정자 : ismt */
//    public void setIsmt(String  ismt) { set( "ismt" ,ismt);}
//    /** get 수정자 : ismt */
//    public String  getIsmt() { return (String )get("ismt" );}
//
//    /** set 수정일자 : revnDt */
//    public void setRevnDt(String  revnDt) { set( "revnDt" ,revnDt);}
//    /** get 수정일자 : revnDt */
//    public String  getRevnDt() { return (String )get("revnDt" );}
//
//    /** set 수정주소 : revnAddr */
//    public void setRevnAddr(String  revnAddr) { set( "revnAddr" ,revnAddr);}
//    /** get 수정주소 : revnAddr */
//    public String  getRevnAddr() { return (String )get("revnAddr" );}
//    
//    /** set 신고인원수 : declareCount */
//    public void setDeclareCount(String  declareCount) { set( "declareCount", declareCount);}
//    /** get 신고인원수 : declareCount */
//    public String  getDeclareCount() { return (String )get("declareCount" );}
//    
//    /** set 재직 : workCount */
//    public void setWorkCount(String  workCount) { set( "workCount", workCount);}
//    /** get 재직 : workCount */
//    public String  getWorkCount() { return (String )get("workCount" );}
//    
//    /** set 퇴직 : retireCount */
//    public void setRetireCount(String  retireCount) { set( "retireCount", retireCount);}
//    /** get 퇴직 : retireCount */
//    public String  getRetireCount() { return (String )get("retireCount" );}
    
}
