package com.app.smrmf.sysm.server.vo.system;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : SsoxUserDefaultVO.java
 * @Description : SsoxUser Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.08.28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SsoxUserSrhVO implements Serializable {
	 
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
    

    /** 사업장코드 - DPOB_CD */
    private java.lang.String dpobCd;
        
    /** USER_NAME */
    private java.lang.String userName;
      
    /** DEPT_ID */
    private java.lang.String deptId;
    
    
    
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getDeptId() {
		return deptId;
	}

	public void setDeptId(java.lang.String deptId) {
		this.deptId = deptId;
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
