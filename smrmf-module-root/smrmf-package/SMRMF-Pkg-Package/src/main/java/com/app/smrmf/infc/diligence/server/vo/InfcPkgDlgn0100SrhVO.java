package com.app.smrmf.infc.diligence.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Dlgn0100DefaultVO.java
 * @Description : Dlgn0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgDlgn0100SrhVO implements Serializable {
 
    
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
    
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd = "";

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey = "";

    /** set 근태년월 : dilnlazYrMnth */
    private java.lang.String dilnlazYrMnth = "";

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd = "";

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd = "";

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd = "";

    /** set 사업코드 : businCd */
    private java.lang.String businCd = "";

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd = "";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd = "";
        

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    
    /** 관리부서코드  mangeDeptCd */
    private java.lang.String  mangeDeptCd;
    
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
	/** set 복무통합구분값 : typOccuBusinVal */
    private java.lang.String typOccuBusinVal;

	 public java.lang.String getTypOccuBusinVal() {
		return typOccuBusinVal;
	}

	public void setTypOccuBusinVal(java.lang.String typOccuBusinVal) {
		this.typOccuBusinVal = typOccuBusinVal;
	}
    
	
	/**
	 * Comment : 관리부서코드 
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 13. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 관리부서코드
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2018 2018. 3. 13. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    public java.lang.String getDilnlazYrMnth() {
        return dilnlazYrMnth;
    }

    public void setDilnlazYrMnth(java.lang.String dilnlazYrMnth) {
        this.dilnlazYrMnth = dilnlazYrMnth;
    }

    public java.lang.String getPayCd() {
        return payCd;
    }

    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }

    public java.lang.String getEmymtDivCd() {
        return emymtDivCd;
    }

    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }

    public java.lang.String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }

    public java.lang.String getBusinCd() {
        return businCd;
    }

    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }

    public java.lang.String getTypOccuCd() {
        return typOccuCd;
    }

    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }

    public java.lang.String getDtilOccuClsDivCd() {
        return dtilOccuClsDivCd;
    }

    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
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
