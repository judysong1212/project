package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0445DefaultVO.java
 * @Description : Payr0445 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0445SrhVO implements Serializable {
	 
    
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

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    private java.lang.String pyspLogSvcYrNumCd;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.lang.String payrItemSeilNum;

    /** set 직종세별급여생성일자 : occuClssPayCmpttnStd */
    private java.lang.String occuClssPayCmpttnStd;
 
    
    
    
	public java.lang.String getPayrItemSeilNum() {
        return payrItemSeilNum;
    }



    public void setPayrItemSeilNum(java.lang.String payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }



    public java.lang.String getPayYr() {
        return payYr;
    }



    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
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

    public void setTypOccuGrdeMppgSeilNum(java.math.BigDecimal typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }

    public java.lang.String getPyspLogSvcYrNumCd() {
        return pyspLogSvcYrNumCd;
    }

    public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
        this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
    }

    
    public java.lang.String getOccuClssPayCmpttnStd() {
        return occuClssPayCmpttnStd;
    }

    public void setOccuClssPayCmpttnStd(java.lang.String occuClssPayCmpttnStd) {
        this.occuClssPayCmpttnStd = occuClssPayCmpttnStd;
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
