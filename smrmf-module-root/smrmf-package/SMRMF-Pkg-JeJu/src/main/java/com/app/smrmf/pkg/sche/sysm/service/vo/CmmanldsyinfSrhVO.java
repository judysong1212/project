package com.app.smrmf.pkg.sche.sysm.service.vo;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : CmmanldsyinfDefaultVO.java
 * @Description : Cmmanldsyinf Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CmmanldsyinfSrhVO implements Serializable {

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
    
    
    /** LOG_DATE */
    private java.lang.String logDate;
    
    /** LOG_SEQ */
    private java.math.BigDecimal logSeq;    
    
    /** USER_GB */
    private java.lang.String userGb;
    
    
        
	/**
	 * Comment : USER_GB
	 * @fn java.lang.String getUserGb()
	 * @brief date:2018 2018. 4. 3. user:atres
	 * @return the userGb get
	 */
	public java.lang.String getUserGb() {
		return userGb;
	}

	/**
	 * Comment : USER_GB
	 *@fn void setUserGb(java.lang.String userGb)
	 *@brief date:2018 2018. 4. 3. user:atres
	 *@param userGb the userGb to set
	 */
	public void setUserGb(java.lang.String userGb) {
		this.userGb = userGb;
	}

	/**
	 * Comment : LOG_SEQ
	 * @fn java.math.BigDecimal getLogSeq()
	 * @brief date:2018 2018. 4. 2. user:atres
	 * @return the logSeq get
	 */
	public java.math.BigDecimal getLogSeq() {
		return logSeq;
	}

	/**
	 * Comment : LOG_SEQ
	 *@fn void setLogSeq(java.math.BigDecimal logSeq)
	 *@brief date:2018 2018. 4. 2. user:atres
	 *@param logSeq the logSeq to set
	 */
	public void setLogSeq(java.math.BigDecimal logSeq) {
		this.logSeq = logSeq;
	}

	/**
	 * Comment : LOG_DATE
	 * @fn java.lang.String getLogDate()
	 * @brief date:2018 2018. 4. 2. user:atres
	 * @return the logDate get
	 */
	public java.lang.String getLogDate() {
		return logDate;
	}

	/**
	 * Comment : LOG_DATE
	 *@fn void setLogDate(java.lang.String logDate)
	 *@brief date:2018 2018. 4. 2. user:atres
	 *@param logDate the logDate to set
	 */
	public void setLogDate(java.lang.String logDate) {
		this.logDate = logDate;
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
