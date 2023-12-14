package com.app.smrmf.infc.yearendtax.server.vo.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : Yeta1000DefaultVO.java
 * @Description : Yeta1000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe161010Srh_2023_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

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

	
	
	/**
	 * Comment : 
	 * @fn java.lang.String getResnRegnNum()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the resnRegnNum get
	 */
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param resnRegnNum the resnRegnNum to set
	 */
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCreOriginYn()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the creOriginYn get
	 */
	public java.lang.String getCreOriginYn() {
		return creOriginYn;
	}

	/**
	 * Comment : 
	 *@fn void setCreOriginYn(java.lang.String creOriginYn)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param creOriginYn the creOriginYn to set
	 */
	public void setCreOriginYn(java.lang.String creOriginYn) {
		this.creOriginYn = creOriginYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCrePasswd()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the crePasswd get
	 */
	public java.lang.String getCrePasswd() {
		return crePasswd;
	}

	/**
	 * Comment : 
	 *@fn void setCrePasswd(java.lang.String crePasswd)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param crePasswd the crePasswd to set
	 */
	public void setCrePasswd(java.lang.String crePasswd) {
		this.crePasswd = crePasswd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDdcCreOriginYn()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the ddcCreOriginYn get
	 */
	public java.lang.String getDdcCreOriginYn() {
		return ddcCreOriginYn;
	}

	/**
	 * Comment : 
	 *@fn void setDdcCreOriginYn(java.lang.String ddcCreOriginYn)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param ddcCreOriginYn the ddcCreOriginYn to set
	 */
	public void setDdcCreOriginYn(java.lang.String ddcCreOriginYn) {
		this.ddcCreOriginYn = ddcCreOriginYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDdcCrePasswd()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the ddcCrePasswd get
	 */
	public java.lang.String getDdcCrePasswd() {
		return ddcCrePasswd;
	}

	/**
	 * Comment : 
	 *@fn void setDdcCrePasswd(java.lang.String ddcCrePasswd)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param ddcCrePasswd the ddcCrePasswd to set
	 */
	public void setDdcCrePasswd(java.lang.String ddcCrePasswd) {
		this.ddcCrePasswd = ddcCrePasswd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getStlRflSttChkYn()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the stlRflSttChkYn get
	 */
	public java.lang.String getStlRflSttChkYn() {
		return stlRflSttChkYn;
	}

	/**
	 * Comment : 
	 *@fn void setStlRflSttChkYn(java.lang.String stlRflSttChkYn)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param stlRflSttChkYn the stlRflSttChkYn to set
	 */
	public void setStlRflSttChkYn(java.lang.String stlRflSttChkYn) {
		this.stlRflSttChkYn = stlRflSttChkYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDdcStlRflSttChkYn()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the ddcStlRflSttChkYn get
	 */
	public java.lang.String getDdcStlRflSttChkYn() {
		return ddcStlRflSttChkYn;
	}

	/**
	 * Comment : 
	 *@fn void setDdcStlRflSttChkYn(java.lang.String ddcStlRflSttChkYn)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param ddcStlRflSttChkYn the ddcStlRflSttChkYn to set
	 */
	public void setDdcStlRflSttChkYn(java.lang.String ddcStlRflSttChkYn) {
		this.ddcStlRflSttChkYn = ddcStlRflSttChkYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getXmlFormCd()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the xmlFormCd get
	 */
	public java.lang.String getXmlFormCd() {
		return xmlFormCd;
	}

	/**
	 * Comment : 
	 *@fn void setXmlFormCd(java.lang.String xmlFormCd)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param xmlFormCd the xmlFormCd to set
	 */
	public void setXmlFormCd(java.lang.String xmlFormCd) {
		this.xmlFormCd = xmlFormCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSpciDdctCheck()
	 * @brief date:2023 2023. 1. 29. user:atres
	 * @return the spciDdctCheck get
	 */
	public java.lang.String getSpciDdctCheck() {
		return spciDdctCheck;
	}

	/**
	 * Comment : 
	 *@fn void setSpciDdctCheck(java.lang.String spciDdctCheck)
	 *@brief date:2023 2023. 1. 29. user:atres
	 *@param spciDdctCheck the spciDdctCheck to set
	 */
	public void setSpciDdctCheck(java.lang.String spciDdctCheck) {
		this.spciDdctCheck = spciDdctCheck;
	}

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

    

}
