package com.app.exterms.diligence.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Dlgn0210DefaultVO.java
 * @Description : Dlgn0210 Default VO class
 * @Modification Information
 *
 * @author admin
 * @since 2016.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0210SrhVO implements Serializable {

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
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 근태 적용일자 : DILNLAZ_APPTN_DT */
    private java.lang.String dilnlazApptnDt;
    
    /** set 근태 근무년월 : DILNLAZ_EXCE_DUTY_YR_MNTH */
    private java.lang.String dilnlazExceDutyYrMnth;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
    /** 시작일자 detailEmymtBgnnDt */
    private java.lang.String detailEmymtBgnnDt;
    
    /** 종료일자 detailEmymtEndDt */
    private java.lang.String detailEmymtEndDt;
    
	/** set 복무통합구분값 : typOccuBusinVal */
    private java.lang.String typOccuBusinVal;

	 public java.lang.String getTypOccuBusinVal() {
		return typOccuBusinVal;
	}

	public void setTypOccuBusinVal(java.lang.String typOccuBusinVal) {
		this.typOccuBusinVal = typOccuBusinVal;
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getDilnlazApptnDt() {
		return dilnlazApptnDt;
	}

	public void setDilnlazApptnDt(java.lang.String dilnlazApptnDt) {
		this.dilnlazApptnDt = dilnlazApptnDt;
	}

	public java.lang.String getDilnlazExceDutyYrMnth() {
		return dilnlazExceDutyYrMnth;
	}

	public void setDilnlazExceDutyYrMnth(java.lang.String dilnlazExceDutyYrMnth) {
		this.dilnlazExceDutyYrMnth = dilnlazExceDutyYrMnth;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDetailEmymtBgnnDt() {
		return detailEmymtBgnnDt;
	}

	public void setDetailEmymtBgnnDt(java.lang.String detailEmymtBgnnDt) {
		this.detailEmymtBgnnDt = detailEmymtBgnnDt;
	}

	public java.lang.String getDetailEmymtEndDt() {
		return detailEmymtEndDt;
	}

	public void setDetailEmymtEndDt(java.lang.String detailEmymtEndDt) {
		this.detailEmymtEndDt = detailEmymtEndDt;
	}
    
    

}
