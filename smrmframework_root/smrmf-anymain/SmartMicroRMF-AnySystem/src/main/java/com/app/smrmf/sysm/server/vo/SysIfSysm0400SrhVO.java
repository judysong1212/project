package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0400DefaultVO.java
 * @Description : Sysm0400 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0400SrhVO implements Serializable {
	
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
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** AUTH_GRP_SEIL_NUM */
    private java.math.BigDecimal authGrpSeilNum;
    
    /** MNU_CD */
    private java.lang.String mnuCd;
    
    
        
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}

	public java.math.BigDecimal getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	public void setAuthGrpSeilNum(java.math.BigDecimal authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	public java.lang.String getMnuCd() {
		return mnuCd;
	}

	public void setMnuCd(java.lang.String mnuCd) {
		this.mnuCd = mnuCd;
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
