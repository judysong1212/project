package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr1500DefaultVO.java
 * @Description : Insr1500 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1500SrhVO implements Serializable {

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
    
    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
    /** set 사회보험작성일자 : famyAqtnLssDt */
    private java.lang.String famyAqtnLssDt;

    /** set 사회보험취득_고용_일련번호 : famyAqtnLssNum */
    private Long famyAqtnLssNum;
    
    /** set 피부양 자격구분 코드 : socInsrAqtnEmymtNum */
    private String famyQuftDivCd;
    

    




	public String getFamyQuftDivCd() {
		return famyQuftDivCd;
	}

	public void setFamyQuftDivCd(String famyQuftDivCd) {
		this.famyQuftDivCd = famyQuftDivCd;
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

	public java.lang.String getFamyAqtnLssDt() {
		return famyAqtnLssDt;
	}

	public void setFamyAqtnLssDt(java.lang.String famyAqtnLssDt) {
		this.famyAqtnLssDt = famyAqtnLssDt;
	}

	public Long getFamyAqtnLssNum() {
		return famyAqtnLssNum;
	}

	public void setFamyAqtnLssNum(Long famyAqtnLssNum) {
		this.famyAqtnLssNum = famyAqtnLssNum;
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