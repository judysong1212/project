package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Insr1550DefaultVO.java
 * @Description : Insr1550 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1550SrhVO implements Serializable {

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

   
  
	private java.lang.String dpobCd;   
    private java.lang.String systemkey;   
    private List<String> systemKeyArr;   
    private java.lang.String famyAqtnLssDt;   
    private java.lang.String famyAqtnDivCd;
	private java.lang.String famyQuftDivCd;
    private Long famyAqtnLssNum;
    private java.lang.String usrId;
    private java.lang.String deptCd;
    private List<String> deptCdArr;
    private java.lang.String payrMangDeptYn;
    private java.lang.String payrMangDeptCd;
	private java.lang.String payrMangeDeptCd;
    private java.lang.String deptCdAuth;
    private java.lang.String dtilOccuInttnCdAuth;
    private java.lang.String dtilOccuInttnCd;

   	private java.lang.String soctyInsurCmptnDt01;
   	private java.lang.String soctyInsurCmptnDt02;
   	private java.lang.String hdofcCodtnCd;
   	private List<String> hdofcCodtnCdArr;
   	private java.lang.String emymtDivCd;
   	private java.lang.String typOccuCd;
   	private List<String> typOccuCdArr;
   	private List<String> dtilOccuInttnCdArr;
	private java.lang.String businCd;
	private java.lang.String hanNm;
	private java.lang.String resnRegnNum;
	private java.lang.String applyAqtnLssYn;
	private java.lang.String applyAqtnYn;
	private java.lang.String applyLssYn;
	
   	private java.lang.String famyQuftDivCdAqtn;  
   	private java.lang.String famyQuftDivCdLss;
	    
	    
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
	public java.lang.String getSystemkey() {
		return systemkey;
	}
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}
	public List<String> getSystemKeyArr() {
		return systemKeyArr;
	}
	public void setSystemKeyArr(List<String> systemKeyArr) {
		this.systemKeyArr = systemKeyArr;
	}
	public java.lang.String getFamyAqtnLssDt() {
		return famyAqtnLssDt;
	}
	public void setFamyAqtnLssDt(java.lang.String famyAqtnLssDt) {
		this.famyAqtnLssDt = famyAqtnLssDt;
	}
	public java.lang.String getFamyAqtnDivCd() {
		return famyAqtnDivCd;
	}
	public void setFamyAqtnDivCd(java.lang.String famyAqtnDivCd) {
		this.famyAqtnDivCd = famyAqtnDivCd;
	}
	public java.lang.String getFamyQuftDivCd() {
		return famyQuftDivCd;
	}
	public void setFamyQuftDivCd(java.lang.String famyQuftDivCd) {
		this.famyQuftDivCd = famyQuftDivCd;
	}
	public Long getFamyAqtnLssNum() {
		return famyAqtnLssNum;
	}
	public void setFamyAqtnLssNum(Long famyAqtnLssNum) {
		this.famyAqtnLssNum = famyAqtnLssNum;
	}
	public java.lang.String getUsrId() {
		return usrId;
	}
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
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
	public java.lang.String getPayrMangeDeptCd() {
		return payrMangeDeptCd;
	}
	public void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd) {
		this.payrMangeDeptCd = payrMangeDeptCd;
	}
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}
	public java.lang.String getFamyQuftDivCdAqtn() {
		return famyQuftDivCdAqtn;
	}
	public void setFamyQuftDivCdAqtn(java.lang.String famyQuftDivCdAqtn) {
		this.famyQuftDivCdAqtn = famyQuftDivCdAqtn;
	}
	public java.lang.String getFamyQuftDivCdLss() {
		return famyQuftDivCdLss;
	}
	public void setFamyQuftDivCdLss(java.lang.String famyQuftDivCdLss) {
		this.famyQuftDivCdLss = famyQuftDivCdLss;
	}
	public java.lang.String getSoctyInsurCmptnDt01() {
		return soctyInsurCmptnDt01;
	}
	public void setSoctyInsurCmptnDt01(java.lang.String soctyInsurCmptnDt01) {
		this.soctyInsurCmptnDt01 = soctyInsurCmptnDt01;
	}
	public java.lang.String getSoctyInsurCmptnDt02() {
		return soctyInsurCmptnDt02;
	}
	public void setSoctyInsurCmptnDt02(java.lang.String soctyInsurCmptnDt02) {
		this.soctyInsurCmptnDt02 = soctyInsurCmptnDt02;
	}
	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}
	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}
	public List<String> getHdofcCodtnCdArr() {
		return hdofcCodtnCdArr;
	}
	public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
		this.hdofcCodtnCdArr = hdofcCodtnCdArr;
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
	public java.lang.String getBusinCd() {
		return businCd;
	}
	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
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
	public java.lang.String getApplyAqtnLssYn() {
		return applyAqtnLssYn;
	}
	public void setApplyAqtnLssYn(java.lang.String applyAqtnLssYn) {
		this.applyAqtnLssYn = applyAqtnLssYn;
	}
	public java.lang.String getApplyAqtnYn() {
		return applyAqtnYn;
	}
	public void setApplyAqtnYn(java.lang.String applyAqtnYn) {
		this.applyAqtnYn = applyAqtnYn;
	}
	public java.lang.String getApplyLssYn() {
		return applyLssYn;
	}
	public void setApplyLssYn(java.lang.String applyLssYn) {
		this.applyLssYn = applyLssYn;
	}
    
	
	
	
	
  
}
