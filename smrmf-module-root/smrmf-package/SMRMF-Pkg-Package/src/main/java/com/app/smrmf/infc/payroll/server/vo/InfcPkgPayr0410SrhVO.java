package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0410DefaultVO.java
 * @Description : Payr0410 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0410SrhVO implements Serializable {
	
	 
    
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

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */
    private java.lang.String typOccuGrdeMppgCtnt;

    /** set 직종_등급맵핑삭제여부 : typOccuGrdeMppgDelYn */
    private java.lang.String typOccuGrdeMppgDelYn;

    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
 

   /** set 급여항목일련번호 : payrItemSeilNum */
   private java.math.BigDecimal payrItemSeilNum;
   
   /** PAYR_YEAR */
   private java.lang.String payYr;
    
   
   private java.lang.String pymtDducDivCd = "";
   

   /** set 급여관리부서코드 : payrMangDeptCd */
   private java.lang.String payrMangDeptCd; 
   
   

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

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPayrItemSeilNum()
	 * @brief date:2016 2016. 5. 13. user:Administrator
	 * @return the payrItemSeilNum get
	 */
	public java.math.BigDecimal getPayrItemSeilNum() {
		return payrItemSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum)
	 *@brief date:2016 2016. 5. 13. user:Administrator
	 *@param payrItemSeilNum the payrItemSeilNum to set
	 */
	public void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum) {
		this.payrItemSeilNum = payrItemSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayYr()
	 * @brief date:2016 2016. 5. 13. user:Administrator
	 * @return the payYr get
	 */
	public java.lang.String getPayYr() {
		return payYr;
	}

	/**
	 * Comment : 
	 *@fn void setPayYr(java.lang.String payYr)
	 *@brief date:2016 2016. 5. 13. user:Administrator
	 *@param payYr the payYr to set
	 */
	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPymtDducDivCd()
	 * @brief date:2016 2016. 5. 13. user:Administrator
	 * @return the pymtDducDivCd get
	 */
	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setPymtDducDivCd(java.lang.String pymtDducDivCd)
	 *@brief date:2016 2016. 5. 13. user:Administrator
	 *@param pymtDducDivCd the pymtDducDivCd to set
	 */
	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2016 2016. 5. 13. user:Administrator
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2016 2016. 5. 13. user:Administrator
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getTypOccuGrdeMppgCtnt() {
		return typOccuGrdeMppgCtnt;
	}

	public void setTypOccuGrdeMppgCtnt(java.lang.String typOccuGrdeMppgCtnt) {
		this.typOccuGrdeMppgCtnt = typOccuGrdeMppgCtnt;
	}

	public java.lang.String getTypOccuGrdeMppgDelYn() {
		return typOccuGrdeMppgDelYn;
	}

	public void setTypOccuGrdeMppgDelYn(java.lang.String typOccuGrdeMppgDelYn) {
		this.typOccuGrdeMppgDelYn = typOccuGrdeMppgDelYn;
	}
 

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}
    
    

}
