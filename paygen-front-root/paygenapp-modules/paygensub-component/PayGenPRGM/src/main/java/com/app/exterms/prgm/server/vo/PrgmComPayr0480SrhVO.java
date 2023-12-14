package com.app.exterms.prgm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0480DefaultVO.java
 * @Description : Payr0480 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.09.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComPayr0480SrhVO implements Serializable {
	 
    
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
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** 지급공제구분코드  */
    private java.lang.String pymtDducDivCd; 
    
    /** 지급공제명  */
    private java.lang.String payExtpyNm; 
    
    /** 기간제콤보여부  PAYR_TERM_USE_YN */
    private java.lang.String payrTermUseYn; 
    
    /** set 급여수당사용여부 : payExtpyUseYn */
    private java.lang.String payExtpyUseYn; 
    
    
	/**
	 * Comment : 
	 * @fn java.lang.String getPayExtpyUseYn()
	 * @brief date:2016 Feb 29, 2016 user:leeheuisung
	 * @return the payExtpyUseYn get
	 */
	public java.lang.String getPayExtpyUseYn() {
		return payExtpyUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayExtpyUseYn(java.lang.String payExtpyUseYn)
	 *@brief date:2016 Feb 29, 2016 user:leeheuisung
	 *@param payExtpyUseYn the payExtpyUseYn to set
	 */
	public void setPayExtpyUseYn(java.lang.String payExtpyUseYn) {
		this.payExtpyUseYn = payExtpyUseYn;
	}

	public java.lang.String getPayrTermUseYn() {
        return payrTermUseYn;
    }

    public void setPayrTermUseYn(java.lang.String payrTermUseYn) {
        this.payrTermUseYn = payrTermUseYn;
    }

    public java.lang.String getPayExtpyNm() {
        return payExtpyNm;
    }

    public void setPayExtpyNm(java.lang.String payExtpyNm) {
        this.payExtpyNm = payExtpyNm;
    }

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
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
 
    
}
