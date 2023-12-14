package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0470DefaultVO.java
 * @Description : Payr0470 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0470SrhVO implements Serializable {
	
	  
    
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

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;
    
	private List<String> pymtDducDivCdArr;	//스트링 값에 여러건을 넘기기의한 값(지급공제구분)
	
    
    public List<String> getPymtDducDivCdArr() {
		return pymtDducDivCdArr;
	}


	public void setPymtDducDivCdArr(List<String> pymtDducDivCdArr) {
		this.pymtDducDivCdArr = pymtDducDivCdArr;
	}

	/** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 수당그룹구분코드 : payExtpyGrpCd */
    private java.lang.String payExtpyGrpCd;
    
    
    /** set 수당그룹구분코드 : payExtpyGrpCd */
    private java.lang.String dtilPayExtpyGrpCd;
    
    
    public java.lang.String getDtilPayExtpyGrpCd() {
		return dtilPayExtpyGrpCd;
	}


	public void setDtilPayExtpyGrpCd(java.lang.String dtilPayExtpyGrpCd) {
		this.dtilPayExtpyGrpCd = dtilPayExtpyGrpCd;
	}

	private List<String> dtilPayExtpyGrpCdArr;	//스트링 값에 여러건을 넘기기의한 값(수당그룹)
    
    
    public List<String> getDtilPayExtpyGrpCdArr() {
		return dtilPayExtpyGrpCdArr;
	}


	public void setDtilPayExtpyGrpCdArr(List<String> dtilPayExtpyGrpCdArr) {
		this.dtilPayExtpyGrpCdArr = dtilPayExtpyGrpCdArr;
	}


	public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}


	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}


	public java.lang.String getPayExtpyGrpCd() {
		return payExtpyGrpCd;
	}


	public void setPayExtpyGrpCd(java.lang.String payExtpyGrpCd) {
		this.payExtpyGrpCd = payExtpyGrpCd;
	}


	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
	
    /** PAY_DDUC_GRP_CD */
    private java.lang.String payDducGrpCd;
    
    /** PAY_DDUC_NM */
    private java.lang.String payDducNm;
   
       
	public java.lang.String getPayDducGrpCd() {
		return payDducGrpCd;
	}

	public void setPayDducGrpCd(java.lang.String payDducGrpCd) {
		this.payDducGrpCd = payDducGrpCd;
	}

	public java.lang.String getPayDducNm() {
		return payDducNm;
	}

	public void setPayDducNm(java.lang.String payDducNm) {
		this.payDducNm = payDducNm;
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
