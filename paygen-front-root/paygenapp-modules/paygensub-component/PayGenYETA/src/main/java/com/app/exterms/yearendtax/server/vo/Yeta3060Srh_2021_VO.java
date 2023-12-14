package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0100DefaultVO.java
 * @Description : Bass0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3060Srh_2021_VO implements Serializable {
	  
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
    
    private String dpobCd;
    
    private String utDpobNm;
    
    private String utDpobCd;
    
    private String degtrNm;
    
	/** set 주종사업장구분코드 : mtstBusinDivCd */
	private java.lang.String mtstBusinDivCd;
	
	
        
	public java.lang.String getMtstBusinDivCd() {
		return mtstBusinDivCd;
	}

	public void setMtstBusinDivCd(java.lang.String mtstBusinDivCd) {
		this.mtstBusinDivCd = mtstBusinDivCd;
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
	 * @return the dpobNm
	 */
	public String getUtDpobNm() {
		return utDpobNm;
	}

	/**
	 * @return the degtrNm
	 */
	public String getDegtrNm() {
		return degtrNm;
	}

	/**
	 * @param dpobNm the dpobNm to set
	 */
	public void setUtDpobNm(String utDpobNm) {
		this.utDpobNm = utDpobNm;
	}

	/**
	 * @param degtrNm the degtrNm to set
	 */
	public void setDegtrNm(String degtrNm) {
		this.degtrNm = degtrNm;
	}

	public String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public String getUtDpobCd() {
		return utDpobCd;
	}

	public void setUtDpobCd(String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}
	

}
