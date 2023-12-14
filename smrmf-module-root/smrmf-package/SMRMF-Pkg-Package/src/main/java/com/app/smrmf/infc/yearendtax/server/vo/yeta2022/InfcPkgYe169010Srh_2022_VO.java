package com.app.smrmf.infc.yearendtax.server.vo.yeta2022;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Ye169010DefaultVO.java
 * @Description : Ye169010 Default VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe169010Srh_2022_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** �??��조건 */
    private String searchCondition = "";
    
    /** �??��Keyword */
    private String searchKeyword = "";
    
    /** �??��?��?��?���? */
    private String searchUseYn = "";
    
    /** ?��?��?��?���? */
    private int pageIndex = 1;
    
    /** ?��?���?�??�� */
    private int pageUnit = 10;
    
    /** ?��?���??��?���? */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
   private java.lang.String   c152StdTxDdcYn;
    
    private java.lang.String   yetaC152Check;
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    
    
	/**
	 * Comment : 
	 * @fn java.lang.String getC152StdTxDdcYn()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the c152StdTxDdcYn get
	 */
	public java.lang.String getC152StdTxDdcYn() {
		return c152StdTxDdcYn;
	}

	/**
	 * Comment : 
	 *@fn void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param c152StdTxDdcYn the c152StdTxDdcYn to set
	 */
	public void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn) {
		this.c152StdTxDdcYn = c152StdTxDdcYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYetaC152Check()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the yetaC152Check get
	 */
	public java.lang.String getYetaC152Check() {
		return yetaC152Check;
	}

	/**
	 * Comment : 
	 *@fn void setYetaC152Check(java.lang.String yetaC152Check)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param yetaC152Check the yetaC152Check to set
	 */
	public void setYetaC152Check(java.lang.String yetaC152Check) {
		this.yetaC152Check = yetaC152Check;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxBlggYr()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the yrtxBlggYr get
	 */
	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxBlggYr(java.lang.String yrtxBlggYr)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param yrtxBlggYr the yrtxBlggYr to set
	 */
	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getClutSeptCd()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the clutSeptCd get
	 */
	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setClutSeptCd(java.lang.String clutSeptCd)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param clutSeptCd the clutSeptCd to set
	 */
	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2022 2022. 2. 4. user:atres
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2022 2022. 2. 4. user:atres
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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

}
