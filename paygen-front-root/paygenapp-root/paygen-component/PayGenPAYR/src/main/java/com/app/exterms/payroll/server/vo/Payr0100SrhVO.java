package com.app.exterms.payroll.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0100DefaultVO.java
 * @Description : Payr0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0100SrhVO implements Serializable {
	 
    
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
    

    /** APPTN_YR */
    private java.lang.String apptnYr;
     
    
    /** APPTN_STD_BGNN_DT */
    private java.lang.String apptnStdBgnnDt;
    
    /** APPTN_STD_BGNN_DT */
    private java.lang.String apptnStdEndDt;
    
    /** set null : eandIncmBaseDt */
    private java.lang.String eandIncmBaseDt;
   
    
       
	public java.lang.String getEandIncmBaseDt() {
		return eandIncmBaseDt;
	}

	public void setEandIncmBaseDt(java.lang.String eandIncmBaseDt) {
		this.eandIncmBaseDt = eandIncmBaseDt;
	}

	public java.lang.String getApptnStdEndDt() {
		return apptnStdEndDt;
	}

	public void setApptnStdEndDt(java.lang.String apptnStdEndDt) {
		this.apptnStdEndDt = apptnStdEndDt;
	}

	public java.lang.String getApptnYr() {
		return apptnYr;
	}

	public void setApptnYr(java.lang.String apptnYr) {
		this.apptnYr = apptnYr;
	}

	public java.lang.String getApptnStdBgnnDt() {
		return apptnStdBgnnDt;
	}

	public void setApptnStdBgnnDt(java.lang.String apptnStdBgnnDt) {
		this.apptnStdBgnnDt = apptnStdBgnnDt;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

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
