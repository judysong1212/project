package com.app.smrmf.sysm.server.service.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Cmmn0320DefaultVO.java
 * @Description : Cmmn0320 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Cmmn0320SrhVO implements Serializable {
	
	 
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
    private java.lang.String dpobCd;
    
    /** set 도로명시도 : roadNmCtapv */
    private java.lang.String roadNmCtapv;

    /** set 도로명시군구 : roadNmCtatgu */
    private java.lang.String roadNmCtatgu;
    
    /** set 도로명읍면 : roadNmTat */
    private java.lang.String roadNmTat;
    
    /** set 도로명리 : roadNmLi */
    private java.lang.String roadNmLi; 
 
    /** set 도로명지번본번 : roadNmLtnumBobn */
    private java.math.BigDecimal roadNmLtnumBobn;
    

    /** set 도로명지번부번 : roadNmLtnumBubn */
    private java.math.BigDecimal roadNmLtnumBubn;
    
    /** set 도로명 : roadNm */
    private java.lang.String roadNm;
 
    /** set 건물번호본번 : buildNumBobn */
    private java.lang.String buildNumBobn;

    /** set 건물번호부본 : buildNumBubn */
    private java.lang.String buildNumBubn; 
    
	/** set 건물명 : buildNm */
    private java.lang.String buildNm; 
    
    /** 통합검색 */
    private java.lang.String searchWord; 
    

    public java.lang.String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(java.lang.String searchWord) {
		this.searchWord = searchWord;
	}
 
	public java.lang.String getRoadNmLi() {
        return roadNmLi;
    }

    public void setRoadNmLi(java.lang.String roadNmLi) {
        this.roadNmLi = roadNmLi;
    }

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getBuildNm() {
        return buildNm;
    }

    public void setBuildNm(java.lang.String buildNm) {
        this.buildNm = buildNm;
    }

    public java.lang.String getRoadNm() {
        return roadNm;
    }

    public void setRoadNm(java.lang.String roadNm) {
        this.roadNm = roadNm;
    }

    public java.lang.String getBuildNumBobn() {
        return buildNumBobn;
    }

    public void setBuildNumBobn(java.lang.String buildNumBobn) {
        this.buildNumBobn = buildNumBobn;
    }

    public java.lang.String getBuildNumBubn() {
        return buildNumBubn;
    }

    public void setBuildNumBubn(java.lang.String buildNumBubn) {
        this.buildNumBubn = buildNumBubn;
    }

    public java.lang.String getRoadNmTat() {
        return roadNmTat;
    }

    public void setRoadNmTat(java.lang.String roadNmTat) {
        this.roadNmTat = roadNmTat;
    }

    public java.math.BigDecimal getRoadNmLtnumBobn() {
        return roadNmLtnumBobn;
    }

    public void setRoadNmLtnumBobn(java.math.BigDecimal roadNmLtnumBobn) {
        this.roadNmLtnumBobn = roadNmLtnumBobn;
    }

    public java.math.BigDecimal getRoadNmLtnumBubn() {
        return roadNmLtnumBubn;
    }

    public void setRoadNmLtnumBubn(java.math.BigDecimal roadNmLtnumBubn) {
        this.roadNmLtnumBubn = roadNmLtnumBubn;
    }

    public java.lang.String getRoadNmCtapv() {
        return roadNmCtapv;
    }

    public void setRoadNmCtapv(java.lang.String roadNmCtapv) {
        this.roadNmCtapv = roadNmCtapv;
    }

    public java.lang.String getRoadNmCtatgu() {
        return roadNmCtatgu;
    }

    public void setRoadNmCtatgu(java.lang.String roadNmCtatgu) {
        this.roadNmCtatgu = roadNmCtatgu;
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
