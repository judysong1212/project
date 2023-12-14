package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0410DefaultVO.java
 * @Description : Payr0410 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0410SrhVO implements Serializable {
	
	 
    
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
    private java.lang.String dpobCd = ""; 
   

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.math.BigDecimal payrItemSeilNum;
    
    /** PAYR_YEAR */
    private java.lang.String payYr;
    
    /** column 직종 : typOccuCd */
    private java.lang.String typOccuCd = "";
    
    /** column 직종세코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd = "";
    
    /** column 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd = "";
    
    private java.lang.String pymtDducDivCd = "";
    

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd; 
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
     
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private java.lang.String payrImcd;
    
    private java.lang.String payCd;
    
    private java.lang.String itemNm;
    
    
    
    
	public java.lang.String getItemNm() {
		return itemNm;
	}

	public void setItemNm(java.lang.String itemNm) {
		this.itemNm = itemNm;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getPayrImcd() {
		return payrImcd;
	}

	public void setPayrImcd(java.lang.String payrImcd) {
		this.payrImcd = payrImcd;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Dec 12, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Dec 12, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	 

	public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
        return typOccuGrdeMppgSeilNum;
    }

    public void setTypOccuGrdeMppgSeilNum(java.math.BigDecimal typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }

    public java.math.BigDecimal getPayrItemSeilNum() {
        return payrItemSeilNum;
    }

    public void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }

    public java.lang.String getPayYr() {
        return payYr;
    }

    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
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
