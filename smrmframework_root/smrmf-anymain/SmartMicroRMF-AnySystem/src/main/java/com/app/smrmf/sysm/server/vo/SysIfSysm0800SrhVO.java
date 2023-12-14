package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Sysm0800DefaultVO.java
 * @Description : Sysm0800 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0800SrhVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
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
    
    /** set 사용자권한구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;
    
    /** set 시스템구분 : sysDivNm */
    private java.lang.String sysDivNm;

    /** set 권한그룹일련번호 : authGrpSeilNum */
    private Long authGrpSeilNum;


    /** set 권한그룹명 : authGrpNm */
    private java.lang.String authGrpNm;
    
    /** set 사용자권한그룹사용여부 : usrAuthGrpUseYn */
    private String usrAuthGrpUseYn;
    
    
        
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
	 * @fn java.lang.String getSysDivCd()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the sysDivCd get
	 */
	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSysDivCd(java.lang.String sysDivCd)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param sysDivCd the sysDivCd to set
	 */
	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
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
	 * @fn Long getAuthGrpSeilNum()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the authGrpSeilNum get
	 */
	public Long getAuthGrpSeilNum() {
		return authGrpSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setAuthGrpSeilNum(Long authGrpSeilNum)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param authGrpSeilNum the authGrpSeilNum to set
	 */
	public void setAuthGrpSeilNum(Long authGrpSeilNum) {
		this.authGrpSeilNum = authGrpSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAuthGrpNm()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the authGrpNm get
	 */
	public java.lang.String getAuthGrpNm() {
		return authGrpNm;
	}

	/**
	 * Comment : 
	 *@fn void setAuthGrpNm(java.lang.String authGrpNm)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param authGrpNm the authGrpNm to set
	 */
	public void setAuthGrpNm(java.lang.String authGrpNm) {
		this.authGrpNm = authGrpNm;
	}

	/**
	 * Comment : 
	 * @fn String getUsrAuthGrpUseYn()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the usrAuthGrpUseYn get
	 */
	public String getUsrAuthGrpUseYn() {
		return usrAuthGrpUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setUsrAuthGrpUseYn(String usrAuthGrpUseYn)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param usrAuthGrpUseYn the usrAuthGrpUseYn to set
	 */
	public void setUsrAuthGrpUseYn(String usrAuthGrpUseYn) {
		this.usrAuthGrpUseYn = usrAuthGrpUseYn;
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

	public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
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
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

}
