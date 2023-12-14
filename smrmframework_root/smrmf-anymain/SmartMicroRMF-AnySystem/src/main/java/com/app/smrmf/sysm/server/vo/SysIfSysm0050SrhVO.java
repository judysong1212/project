package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0050DefaultVO.java
 * @Description : Sysm0050 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0050SrhVO implements Serializable {

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
    
    /** set 시스템사업장코드 : sysDpobCd */
    private java.lang.String sysDpobCd;

    /** set 시스템사업장명 : sysDpobNm */
    private java.lang.String sysDpobNm;
    
    /** set 시스템사업장사용여부 : sysDpobUseYn */
    private java.lang.String sysDpobUseYn;


	public java.lang.String getSysDpobCd() {
		return sysDpobCd;
	}

	public void setSysDpobCd(java.lang.String sysDpobCd) {
		this.sysDpobCd = sysDpobCd;
	}

	public java.lang.String getSysDpobNm() {
		return sysDpobNm;
	}

	public void setSysDpobNm(java.lang.String sysDpobNm) {
		this.sysDpobNm = sysDpobNm;
	}

	public java.lang.String getSysDpobUseYn() {
		return sysDpobUseYn;
	}

	public void setSysDpobUseYn(java.lang.String sysDpobUseYn) {
		this.sysDpobUseYn = sysDpobUseYn;
	}
    

}
