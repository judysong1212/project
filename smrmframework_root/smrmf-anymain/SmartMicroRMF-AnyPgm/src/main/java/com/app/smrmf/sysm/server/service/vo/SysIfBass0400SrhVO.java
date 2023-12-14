package com.app.smrmf.sysm.server.service.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0150DefaultVO.java
 * @Description : Bass0150 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0400SrhVO implements Serializable {

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
    
	/** DEPT_NM_HAN : 부서명 한글*/ 
    private java.lang.String deptNmHan;    

	/** DPOB_CD : 부서코드 */
    private java.lang.String dpobCd;
    
    /** DPOB_CD : 부서코드 */
    private java.lang.String deptCd;
    

	/** 부서한글명*/
    private java.lang.String deptNmRtchnt;   
    

    
        
	/**
	 * Comment : 
	 * @fn java.lang.String getDeptNmHan()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the deptNmHan get
	 */
	public java.lang.String getDeptNmHan() {
		return deptNmHan;
	}

	/**
	 * Comment : 
	 *@fn void setDeptNmHan(java.lang.String deptNmHan)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param deptNmHan the deptNmHan to set
	 */
	public void setDeptNmHan(java.lang.String deptNmHan) {
		this.deptNmHan = deptNmHan;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptNmRtchnt()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the deptNmRtchnt get
	 */
	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}

	/**
	 * Comment : 
	 *@fn void setDeptNmRtchnt(java.lang.String deptNmRtchnt)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param deptNmRtchnt the deptNmRtchnt to set
	 */
	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
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
 
}
