package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0100DefaultVO.java
 * @Description : Sysm0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0100SrhVO implements Serializable {


    /** 검색Keyword */
    private String searchKeyword = "";
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
    
 
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** MNU_CD */
    private java.lang.String mnuCd;
    
    
    /** AUTH_GRP_SEIL_NUM */
    private Long authGrpSeilNum; 
    
    /** MNU_CD */
    private java.lang.String idCategory; 
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    

	/** set 부서코드 : deptCd */
	private java.lang.String deptCd;
    
    /** SYS_DIV_CD */
    private java.lang.String usrNm;
    
    /** dpobCd */
    private java.lang.String dpobCd;
     
    private java.lang.String usrDivCd;   
    
    
    
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(java.lang.String usrNm) {
		this.usrNm = usrNm;
	}

	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
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

	/**
	 * @return the usrId
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * @param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * @return the mnuCd
	 */
	public java.lang.String getMnuCd() {
		return mnuCd;
	}

	/**
	 * @param mnuCd the mnuCd to set
	 */
	public void setMnuCd(java.lang.String mnuCd) {
		this.mnuCd = mnuCd;
	}

	/**
	 * @return the authGrpSeilNum
	 */
	public Long getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	/**
	 * @param authGrpSeilNum the authGrpSeilNum to set
	 */
	public void setAuthGrpSeilNum(Long authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	/**
	 * @return the idCategory
	 */
	public java.lang.String getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(java.lang.String idCategory) {
		this.idCategory = idCategory;
	}

    
    
}
