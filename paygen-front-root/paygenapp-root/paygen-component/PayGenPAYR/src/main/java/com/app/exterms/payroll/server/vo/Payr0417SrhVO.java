package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : Payr0417DefaultVO.java
 * @Description : Payr0417 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.12.13
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class Payr0417SrhVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** �??��조건 */
	private String searchCondition = "";

	/** �??��Keyword */
	private String searchKeyword = "";

	/** �??��?��?��?���? */
	private String searchUseYn = "";

	/** ?��?��?��?���? */
	private int pageIndex = 1;

	/** ?��?���?�??�� */
	private int pageUnit = 10;

	/** ?��?���??��?���? */
	private int pageSize = 10;

	/** firstIndex */
	private int firstIndex = 1;

	/** lastIndex */
	private int lastIndex = 1;

	/** recordCountPerPage */
	private int recordCountPerPage = 10;

	/** DPOB_CD */
	private java.lang.String dpobCd = "";

	/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
	private java.math.BigDecimal typOccuGrdeMppgSeilNum;

	/** column 직종 : typOccuCd */
	private java.lang.String typOccuCd = "";

	/** column 직종세코드 : dtilOccuClsDivCd */
	private java.lang.String dtilOccuClsDivCd = "";

	/** column 호봉등급코드 : pyspGrdeCd */
	private java.lang.String pyspGrdeCd = "";

	/** column 지급공제구분코드 : pymtDducDivCd */
	private java.lang.String pymtDducDivCd = "";

	/** set 급여관리부서코드 : payrMangDeptCd */
	private java.lang.String payrMangDeptCd;

	/** PAY_YR */
	private java.lang.String payYr;
	
	private java.lang.String payCd;

	/** 직종세통합코드 dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;

	private List<String> dtilOccuInttnCdArr; // 스트링 값에 여러건을 넘기기의한 값

	private java.lang.String createYr;
	
	
    /** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
    private java.math.BigDecimal dtilOccuDlySeilNum;
    

	public java.math.BigDecimal getDtilOccuDlySeilNum() {
		return dtilOccuDlySeilNum;
	}

	public void setDtilOccuDlySeilNum(java.math.BigDecimal dtilOccuDlySeilNum) {
		this.dtilOccuDlySeilNum = dtilOccuDlySeilNum;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
		return typOccuGrdeMppgSeilNum;
	}

	public void setTypOccuGrdeMppgSeilNum(
			java.math.BigDecimal typOccuGrdeMppgSeilNum) {
		this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
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

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getPayYr() {
		return payYr;
	}

	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getCreateYr() {
		return createYr;
	}

	public void setCreateYr(java.lang.String createYr) {
		this.createYr = createYr;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

}
