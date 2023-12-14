package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0300DefaultVO.java
 * @Description : Sysm0300 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0300SrhVO implements Serializable {
	
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
    
    
    /** dpobCd */
    private java.lang.String dpobCd;
     

    /** AUTH_GRP_NM */
    private java.lang.String authGrpNm;
        
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** AUTH_GRP_SEIL_NUM */
    private java.math.BigDecimal authGrpSeilNum;
     

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

  
    /** set 시스템구분 : sysDivNm */
    private java.lang.String sysDivNm;
    
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSysDivNm()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the sysDivNm get
	 */
	public java.lang.String getSysDivNm() {
		return sysDivNm;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivNm(java.lang.String sysDivNm)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param sysDivNm the sysDivNm to set
	 */
	public void setSysDivNm(java.lang.String sysDivNm) {
		this.sysDivNm = sysDivNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2015 Dec 16, 2015 user:leeheuisung
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2015 Dec 16, 2015 user:leeheuisung
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getAuthGrpNm() {
		return authGrpNm;
	}

	public void setAuthGrpNm(java.lang.String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

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

	/** recordCountPerPage */
    private int recordCountPerPage = 10;
    
        
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
