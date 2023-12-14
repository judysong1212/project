package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0500DefaultVO.java
 * @Description : Sysm0500 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0500SrhVO implements Serializable {
	
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
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** dpobCd */
    private java.lang.String dpobCd;
     
    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;
    
    
    
	/**
	 * Comment : 
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2017 2017. 11. 7. user:atres
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2017 2017. 11. 7. user:atres
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2015 Dec 28, 2015 user:leeheuisung
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2015 Dec 28, 2015 user:leeheuisung
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

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

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
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
