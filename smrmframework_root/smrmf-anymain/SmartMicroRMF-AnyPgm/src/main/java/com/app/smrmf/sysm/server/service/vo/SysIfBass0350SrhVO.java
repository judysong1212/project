package com.app.smrmf.sysm.server.service.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0350DefaultVO.java
 * @Description : Bass0350 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0350SrhVO implements Serializable {

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
    private java.lang.String payMangeDeptNm;
    
	/** 직종세명 */
    private java.lang.String dtilOccuClsNm;   
    
    /** : 부서명 단축 */
    private java.lang.String payrMangDeptCd;
    

  	/** set 사용자아이디 : usrId */
  	private java.lang.String usrId;

 
    /** : 부서명 단축 */
    private java.lang.String deptNmRtchnt;
    
	 
    
    /** 선택버튼 */
    private java.lang.String select; 
    
    
        
	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsUseYn()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the dtilOccuClsUseYn get
	 */
	public java.lang.String getDtilOccuClsUseYn() {
		return dtilOccuClsUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param dtilOccuClsUseYn the dtilOccuClsUseYn to set
	 */
	public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
		this.dtilOccuClsUseYn = dtilOccuClsUseYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuNm()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the typOccuNm get
	 */
	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuNm(java.lang.String typOccuNm)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param typOccuNm the typOccuNm to set
	 */
	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayMangeDeptNm()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the payMangeDeptNm get
	 */
	public java.lang.String getPayMangeDeptNm() {
		return payMangeDeptNm;
	}

	/**
	 * Comment : 
	 *@fn void setPayMangeDeptNm(java.lang.String payMangeDeptNm)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param payMangeDeptNm the payMangeDeptNm to set
	 */
	public void setPayMangeDeptNm(java.lang.String payMangeDeptNm) {
		this.payMangeDeptNm = payMangeDeptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsNm()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the dtilOccuClsNm get
	 */
	public java.lang.String getDtilOccuClsNm() {
		return dtilOccuClsNm;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsNm(java.lang.String dtilOccuClsNm)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param dtilOccuClsNm the dtilOccuClsNm to set
	 */
	public void setDtilOccuClsNm(java.lang.String dtilOccuClsNm) {
		this.dtilOccuClsNm = dtilOccuClsNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptNmRtchnt()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the deptNmRtchnt get
	 */
	public java.lang.String getDeptNmRtchnt() {
		return deptNmRtchnt;
	}

	/**
	 * Comment : 
	 *@fn void setDeptNmRtchnt(java.lang.String deptNmRtchnt)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param deptNmRtchnt the deptNmRtchnt to set
	 */
	public void setDeptNmRtchnt(java.lang.String deptNmRtchnt) {
		this.deptNmRtchnt = deptNmRtchnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSelect()
	 * @brief date:2016 2016. 12. 18. user:atres-pc
	 * @return the select get
	 */
	public java.lang.String getSelect() {
		return select;
	}

	/**
	 * Comment : 
	 *@fn void setSelect(java.lang.String select)
	 *@brief date:2016 2016. 12. 18. user:atres-pc
	 *@param select the select to set
	 */
	public void setSelect(java.lang.String select) {
		this.select = select;
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
 
}
