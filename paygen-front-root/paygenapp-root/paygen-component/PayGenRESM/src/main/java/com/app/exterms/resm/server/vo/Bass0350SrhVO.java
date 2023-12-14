package com.app.exterms.resm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0350DefaultVO.java
 * @Description : Bass0350 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0350SrhVO implements Serializable {

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
    
    
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** DTIL_OCCU_CLS_NM */
    private String dtilOccuClsNm;    
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;   

	/** DPOB_CD : 최상위코드 */
    private java.lang.String dpobCd;    
    
    /** DEPT_CD : 부서코드 */
    private java.lang.String deptCd;  
    
    private java.lang.String usrId;
    
    private java.lang.String dtilOccuClsUseYn;
    

    /** set 직종세코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;
 
    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    private java.lang.String dtilOccuJbfmlDivCd;
    
    /** set 직군명 : dtilOccuJbfmlDivNm */
    private java.lang.String dtilOccuJbfmlDivNm;
 

    /** set 전환대상여부 : chngTgtYn */
    private java.lang.String chngTgtYn;

    /** set 직종세내용 : dtilOccuClsCtnt */
    private java.lang.String dtilOccuClsCtnt;

    /** set 정렬순서 : dtilOccuClsOrd */
    private java.math.BigDecimal dtilOccuClsOrd;

    /** set 최대근속년수코드 : bggLogSvcYrNumCd */
    private java.lang.String bggLogSvcYrNumCd;

    
    
    
  
	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuJbfmlDivCd()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the dtilOccuJbfmlDivCd get
	 */
	public java.lang.String getDtilOccuJbfmlDivCd() {
		return dtilOccuJbfmlDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuJbfmlDivCd(java.lang.String dtilOccuJbfmlDivCd)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param dtilOccuJbfmlDivCd the dtilOccuJbfmlDivCd to set
	 */
	public void setDtilOccuJbfmlDivCd(java.lang.String dtilOccuJbfmlDivCd) {
		this.dtilOccuJbfmlDivCd = dtilOccuJbfmlDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuJbfmlDivNm()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the dtilOccuJbfmlDivNm get
	 */
	public java.lang.String getDtilOccuJbfmlDivNm() {
		return dtilOccuJbfmlDivNm;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuJbfmlDivNm(java.lang.String dtilOccuJbfmlDivNm)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param dtilOccuJbfmlDivNm the dtilOccuJbfmlDivNm to set
	 */
	public void setDtilOccuJbfmlDivNm(java.lang.String dtilOccuJbfmlDivNm) {
		this.dtilOccuJbfmlDivNm = dtilOccuJbfmlDivNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getChngTgtYn()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the chngTgtYn get
	 */
	public java.lang.String getChngTgtYn() {
		return chngTgtYn;
	}

	/**
	 * Comment : 
	 *@fn void setChngTgtYn(java.lang.String chngTgtYn)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param chngTgtYn the chngTgtYn to set
	 */
	public void setChngTgtYn(java.lang.String chngTgtYn) {
		this.chngTgtYn = chngTgtYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsCtnt()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the dtilOccuClsCtnt get
	 */
	public java.lang.String getDtilOccuClsCtnt() {
		return dtilOccuClsCtnt;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsCtnt(java.lang.String dtilOccuClsCtnt)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param dtilOccuClsCtnt the dtilOccuClsCtnt to set
	 */
	public void setDtilOccuClsCtnt(java.lang.String dtilOccuClsCtnt) {
		this.dtilOccuClsCtnt = dtilOccuClsCtnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getDtilOccuClsOrd()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the dtilOccuClsOrd get
	 */
	public java.math.BigDecimal getDtilOccuClsOrd() {
		return dtilOccuClsOrd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsOrd(java.math.BigDecimal dtilOccuClsOrd)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param dtilOccuClsOrd the dtilOccuClsOrd to set
	 */
	public void setDtilOccuClsOrd(java.math.BigDecimal dtilOccuClsOrd) {
		this.dtilOccuClsOrd = dtilOccuClsOrd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBggLogSvcYrNumCd()
	 * @brief date:2017 2017. 12. 6. user:atres
	 * @return the bggLogSvcYrNumCd get
	 */
	public java.lang.String getBggLogSvcYrNumCd() {
		return bggLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 *@fn void setBggLogSvcYrNumCd(java.lang.String bggLogSvcYrNumCd)
	 *@brief date:2017 2017. 12. 6. user:atres
	 *@param bggLogSvcYrNumCd the bggLogSvcYrNumCd to set
	 */
	public void setBggLogSvcYrNumCd(java.lang.String bggLogSvcYrNumCd) {
		this.bggLogSvcYrNumCd = bggLogSvcYrNumCd;
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
    

    

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public String getDtilOccuClsNm() {
		return dtilOccuClsNm;
	}

	public void setDtilOccuClsNm(String dtilOccuClsNm) {
		this.dtilOccuClsNm = dtilOccuClsNm;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getDtilOccuClsUseYn() {
		return dtilOccuClsUseYn;
	}

	public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
		this.dtilOccuClsUseYn = dtilOccuClsUseYn;
	}


}
