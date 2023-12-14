package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0480DefaultVO.java
 * @Description : Payr0480 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0480SrhVO implements Serializable {
	
	 
    
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
    private java.lang.String dpobCd= ""; 
    
    /** PAY_EXTPY_GRP_CD */
    private java.lang.String payExtpyGrpCd = "";
    
    /** PAY_EXTPY_NM */
    private java.lang.String payExtpyNm = "";
     
       
    /** column 급여수당코드 : payExtpyCd */
    private java.lang.String payExtpyCd = "";
    
    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    private ArrayList<String> arrPayExtpyCd; 
     

    public ArrayList<String> getArrPayExtpyCd() {
        return arrPayExtpyCd;
    }

    public void setArrPayExtpyCd(ArrayList<String> arrPayExtpyCd) {
        this.arrPayExtpyCd = arrPayExtpyCd;
    }

    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

    public java.lang.String getPayExtpyCd() {
        return payExtpyCd;
    }

    public void setPayExtpyCd(java.lang.String payExtpyCd) {
        this.payExtpyCd = payExtpyCd;
    }

    public java.lang.String getPayExtpyGrpCd() {
		return payExtpyGrpCd;
	}

	public void setPayExtpyGrpCd(java.lang.String payExtpyGrpCd) {
		this.payExtpyGrpCd = payExtpyGrpCd;
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
