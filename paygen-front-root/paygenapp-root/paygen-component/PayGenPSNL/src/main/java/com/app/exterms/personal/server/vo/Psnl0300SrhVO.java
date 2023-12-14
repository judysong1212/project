package com.app.exterms.personal.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Psnl0126DefaultVO.java
 * @Description : Psnl0126 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0300SrhVO implements Serializable {
	
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

	public java.lang.String getAppmtDivCd() {
		return appmtDivCd;
	}

	public void setAppmtDivCd(java.lang.String appmtDivCd) {
		this.appmtDivCd = appmtDivCd;
	}

	public java.lang.String getAppmtFixYn() {
		return appmtFixYn;
	}

	public void setAppmtFixYn(java.lang.String appmtFixYn) {
		this.appmtFixYn = appmtFixYn;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getAppmtDt() {
		return appmtDt;
	}

	public void setAppmtDt(java.lang.String appmtDt) {
		this.appmtDt = appmtDt;
	}

	public java.lang.String getAppmtDtS() {
		return appmtDtS;
	}

	public void setAppmtDtS(java.lang.String appmtDtS) {
		this.appmtDtS = appmtDtS;
	}

	public java.lang.String getAppmtDtE() {
		return appmtDtE;
	}

	public void setAppmtDtE(java.lang.String appmtDtE) {
		this.appmtDtE = appmtDtE;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	/** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    
    /** APPMT_DIV_CD */
    private java.lang.String appmtDivCd;
    
    /** APPMT_FIX_YN */
    private java.lang.String appmtFixYn;
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** APPMT_DT */
    private java.lang.String appmtDt;
    
    /** APPMT_DT */
    private java.lang.String appmtDtS;
    
    /** APPMT_DT */
    private java.lang.String appmtDtE;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    private java.lang.String mangeDeptCd;

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}
 
}
