package com.app.exterms.basis.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0400DefaultVO.java
 * @Description : Bass0400 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0400SrhVO implements Serializable {
	

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
    

    
    public java.lang.String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}
	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}
	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
	}   

	public java.lang.String getDeptNmHan() {
		return deptNmHan;
	}
	public void setDeptNmHan(java.lang.String deptNmHan) {
		this.deptNmHan = deptNmHan;
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
