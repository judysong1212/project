package com.app.smrmf.infc.yearendtax.server.vo.yeta2017;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Ye162020DefaultVO.java
 * @Description : Ye162020 Default VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 20178.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe162020SrhVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** RTPN_ACC_ACCNO */
    private java.lang.String rtpnAccAccno;
    
    /** RTPN_ACC_RTPN_CL */
    private java.lang.String rtpnAccRtpnCl;
    
    
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
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxBlggYr()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the yrtxBlggYr get
	 */
	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxBlggYr(java.lang.String yrtxBlggYr)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param yrtxBlggYr the yrtxBlggYr to set
	 */
	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getClutSeptCd()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the clutSeptCd get
	 */
	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setClutSeptCd(java.lang.String clutSeptCd)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param clutSeptCd the clutSeptCd to set
	 */
	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRtpnAccAccno()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the rtpnAccAccno get
	 */
	public java.lang.String getRtpnAccAccno() {
		return rtpnAccAccno;
	}

	/**
	 * Comment : 
	 *@fn void setRtpnAccAccno(java.lang.String rtpnAccAccno)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param rtpnAccAccno the rtpnAccAccno to set
	 */
	public void setRtpnAccAccno(java.lang.String rtpnAccAccno) {
		this.rtpnAccAccno = rtpnAccAccno;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRtpnAccRtpnCl()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the rtpnAccRtpnCl get
	 */
	public java.lang.String getRtpnAccRtpnCl() {
		return rtpnAccRtpnCl;
	}

	/**
	 * Comment : 
	 *@fn void setRtpnAccRtpnCl(java.lang.String rtpnAccRtpnCl)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param rtpnAccRtpnCl the rtpnAccRtpnCl to set
	 */
	public void setRtpnAccRtpnCl(java.lang.String rtpnAccRtpnCl) {
		this.rtpnAccRtpnCl = rtpnAccRtpnCl;
	}

    
    
}
