package com.app.smrmf.infc.basis.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0500DefaultVO.java
 * @Description : Bass0500 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgBass0500SrhVO implements Serializable {

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
    
    private java.lang.String deptCd;
    
    private java.lang.String untDpobCd;
    
    private java.lang.String businUseYn;
    
    private java.lang.String businApptnYr;
     
     
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2018 2018. 1. 9. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2018 2018. 1. 9. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
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
	
	/** set 단위사업장코드 : untDpobCd */
    public void setUntDpobCd(String  untDpobCd) { 
    	this.untDpobCd = untDpobCd;
    }
    /** get 단위사업장코드 : untDpobCd */
    public String  getUntDpobCd() { 
    	return untDpobCd;
    }
    
    /** set 사업사용여부 : businUseYn */
    public void setBusinUseYn(String  businUseYn) { 
    	this.businUseYn = businUseYn;
    }
    /** get 사업사용여부 : businUseYn */
    public String  getBusinUseYn() { 
    	return businUseYn;
    }
    
    /** set 사업적용년도 : businApptnYr */
    public void setBusinApptnYr(String businApptnYr) { 
    	this.businApptnYr = businApptnYr;
    }
    /** get 사업적용년도 : businApptnYr */
    public String getBusinApptnYr() { 
    	return businApptnYr;
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
