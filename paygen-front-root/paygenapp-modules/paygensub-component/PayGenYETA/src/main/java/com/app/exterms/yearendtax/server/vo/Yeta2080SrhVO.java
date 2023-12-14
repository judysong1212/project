package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

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
public class Yeta2080SrhVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
        
    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;   

	/** DPOB_CD : 최상위코드 */
    private java.lang.String dpobCd;    
    
    /** DEPT_CD : 부서코드 */
    private java.lang.String deptCd;  
    
    /** DTIL_OCCU_CLS_USE_YN : 직종세사용유무 */
    private java.lang.String dtilOccuClsUseYn;
    
    /** : 직종명 */
    private java.lang.String typOccuNm;
    
    /** : 직종코드 */
    private java.lang.String typOccuCd;
    
    /** : 부서명 단축 */
    private java.lang.String deptNmRtchnt;
    
	/** 직종세명 */
    private java.lang.String dtilOccuClsNm;  
    
    /** set 부서명_한글 : deptNmHan */
    private java.lang.String deptNmHan;

    
    /** 선택버튼 */
    private java.lang.String select; 
    

    public java.lang.String getDeptNmHan() {
		return deptNmHan;
	}
	public void setDeptNmHan(java.lang.String deptNmHan) {
		this.deptNmHan = deptNmHan;
	}
	public java.lang.String getSelect() {
		return select;
	}
	public void setSelect(java.lang.String select) {
		this.select = select;
	}
	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}
	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}
	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}
	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
	}    
	public java.lang.String getDtilOccuClsNm() {
		return dtilOccuClsNm;
	}
	public void setDtilOccuClsNm(java.lang.String dtilOccuClsNm) {
		this.dtilOccuClsNm = dtilOccuClsNm;
	}
	public java.lang.String getDtilOccuClsUseYn() {
		return dtilOccuClsUseYn;
	}
	public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
		this.dtilOccuClsUseYn = dtilOccuClsUseYn;
	}
	public java.lang.String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}
	public java.lang.String getDpobCd() {
		return dpobCd;
	}
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}
    
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
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
}
