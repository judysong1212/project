package com.app.exterms.payroll.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0300DefaultVO.java
 * @Description : Payr0300 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0300SrhVO implements Serializable {
	 
    
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

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여일련번호 : payrSeilNum */
    private java.math.BigDecimal payrSeilNum;
    
    
    
   
       
	public java.lang.String getPymtYrMnth() {
        return pymtYrMnth;
    }

    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
    }

    public java.lang.String getPayCd() {
        return payCd;
    }

    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }

    public java.math.BigDecimal getPayrSeilNum() {
        return payrSeilNum;
    }

    public void setPayrSeilNum(java.math.BigDecimal payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
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
