package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3100DefaultVO.java
 * @Description : Insr3100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr3100SrhVO implements Serializable {

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
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** NOFCT_YR_MNTH_NUM */
    private java.lang.String nofctYrMnthNum;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DSPTY */
    private java.lang.String dspty;
    
    /** HLTH_INSR_SEIL_NUM */
   // private java.math.BigDecimal hlthInsrSeilNum;
    
    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;
    
	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 2016. 4. 18. user:Administrator
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 2016. 4. 18. user:Administrator
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNofctYrMnthNum()
	 * @brief date:2016 2016. 4. 18. user:Administrator
	 * @return the nofctYrMnthNum get
	 */
	public java.lang.String getNofctYrMnthNum() {
		return nofctYrMnthNum;
	}

	/**
	 * Comment : 
	 *@fn void setNofctYrMnthNum(java.lang.String nofctYrMnthNum)
	 *@brief date:2016 2016. 4. 18. user:Administrator
	 *@param nofctYrMnthNum the nofctYrMnthNum to set
	 */
	public void setNofctYrMnthNum(java.lang.String nofctYrMnthNum) {
		this.nofctYrMnthNum = nofctYrMnthNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2016 2016. 4. 18. user:Administrator
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2016 2016. 4. 18. user:Administrator
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDspty()
	 * @brief date:2016 2016. 4. 18. user:Administrator
	 * @return the dspty get
	 */
	public java.lang.String getDspty() {
		return dspty;
	}

	/**
	 * Comment : 
	 *@fn void setDspty(java.lang.String dspty)
	 *@brief date:2016 2016. 4. 18. user:Administrator
	 *@param dspty the dspty to set
	 */
	public void setDspty(java.lang.String dspty) {
		this.dspty = dspty;
	}

//	/**
//	 * Comment : 
//	 * @fn java.math.BigDecimal getHlthInsrSeilNum()
//	 * @brief date:2016 2016. 4. 18. user:Administrator
//	 * @return the hlthInsrSeilNum get
//	 */
//	public java.math.BigDecimal getHlthInsrSeilNum() {
//		return hlthInsrSeilNum;
//	}
//
//	/**
//	 * Comment : 
//	 *@fn void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum)
//	 *@brief date:2016 2016. 4. 18. user:Administrator
//	 *@param hlthInsrSeilNum the hlthInsrSeilNum to set
//	 */
//	public void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum) {
//		this.hlthInsrSeilNum = hlthInsrSeilNum;
//	}
	
	

	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
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

   
}
