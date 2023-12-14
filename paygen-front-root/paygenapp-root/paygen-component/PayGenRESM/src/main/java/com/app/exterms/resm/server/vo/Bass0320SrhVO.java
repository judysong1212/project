package com.app.exterms.resm.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Bass0320DefaultVO.java
 * @Description : Bass0320 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0320SrhVO implements Serializable {

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

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

	/** set 직종명 : typOccuNm */
    private java.lang.String typOccuNm;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    private List<String> deptCdArr;
    
    private java.lang.String payrMangDeptCd;
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
        
    private java.lang.String usrId;
    
    /** set 직종사용여부 : typOccuUseYn */
    private java.lang.String typOccuUseYn;

    /** set 직종내용 : typOccuCtnt */
    private java.lang.String typOccuCtnt;

    /** set 정렬순서 : typOccuOrd */
    private java.math.BigDecimal typOccuOrd;
    
    /** set 이전직종코드 : chngTypOccuCd */
    private java.lang.String chngTypOccuCd;

    /** set 직종시작일자 : typOccuStdt */
    private java.lang.String typOccuStdt;

    /** set 직종종료일자 : typOccuEddt */
    private java.lang.String typOccuEddt;
    
	public java.lang.String getTypOccuUseYn() {
		return typOccuUseYn;
	}

	public void setTypOccuUseYn(java.lang.String typOccuUseYn) {
		this.typOccuUseYn = typOccuUseYn;
	}

	public java.lang.String getTypOccuCtnt() {
		return typOccuCtnt;
	}

	public void setTypOccuCtnt(java.lang.String typOccuCtnt) {
		this.typOccuCtnt = typOccuCtnt;
	}

	public java.math.BigDecimal getTypOccuOrd() {
		return typOccuOrd;
	}

	public void setTypOccuOrd(java.math.BigDecimal typOccuOrd) {
		this.typOccuOrd = typOccuOrd;
	}

	public java.lang.String getChngTypOccuCd() {
		return chngTypOccuCd;
	}

	public void setChngTypOccuCd(java.lang.String chngTypOccuCd) {
		this.chngTypOccuCd = chngTypOccuCd;
	}

	public java.lang.String getTypOccuStdt() {
		return typOccuStdt;
	}

	public void setTypOccuStdt(java.lang.String typOccuStdt) {
		this.typOccuStdt = typOccuStdt;
	}

	public java.lang.String getTypOccuEddt() {
		return typOccuEddt;
	}

	public void setTypOccuEddt(java.lang.String typOccuEddt) {
		this.typOccuEddt = typOccuEddt;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
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

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

    public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}
    
}
