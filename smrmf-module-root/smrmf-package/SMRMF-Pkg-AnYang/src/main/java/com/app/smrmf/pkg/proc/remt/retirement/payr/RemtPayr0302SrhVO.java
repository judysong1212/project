package com.app.smrmf.pkg.proc.remt.retirement.payr;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0500DefaultVO.java
 * @Description : Payr0500 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtPayr0302SrhVO implements Serializable {
	
 
    
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
   
	  /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
	  public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	/** set 급여지급시작일자 : payPymtBgnnDt */
    private java.lang.String payPymtBgnnDt;

    /** set 급여지급종료일자 : payPymtEndDt */
    private java.lang.String payPymtEndDt;
    
    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;  
    
    
    
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPayPymtBgnnDt() {
		return payPymtBgnnDt;
	}

	public void setPayPymtBgnnDt(java.lang.String payPymtBgnnDt) {
		this.payPymtBgnnDt = payPymtBgnnDt;
	}

	public java.lang.String getPayPymtEndDt() {
		return payPymtEndDt;
	}

	public void setPayPymtEndDt(java.lang.String payPymtEndDt) {
		this.payPymtEndDt = payPymtEndDt;
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
