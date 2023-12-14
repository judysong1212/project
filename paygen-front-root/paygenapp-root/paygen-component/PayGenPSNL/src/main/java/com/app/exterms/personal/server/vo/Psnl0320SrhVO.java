package com.app.exterms.personal.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Psnl0320DefaultVO.java
 * @Description : Psnl0320 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0320SrhVO implements Serializable {
	
	/**
	 * 
	 */
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
    
    /** rowCount */
    private String rowCount = "";
    
    /** currEntPage */
    private String currEntPage = "";
    
    
        
	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public String getCurrEntPage() {
		return currEntPage;
	}

	public void setCurrEntPage(String currEntPage) {
		this.currEntPage = currEntPage;
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
    
    
    
    //-------- PSNL0320
    
    /** DPOB_CD */
    private java.lang.String dpobCd; 

    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    private java.lang.String  payrMangDeptCd; // 단위기관 담당자 여부
     
    /** 성명 HAN_NM */
    private java.lang.String hanNm;
    
    /** 주민번호 RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    

    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
      
    /** 사업코드 BUSIN_CD  */
    private java.lang.String businCd;
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** 부서코드 DEPT_CD */
    private java.lang.String deptCd;
    

	/** 직종코드 TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** 호봉등급코드 PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** 직종세코드 DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  		//스트링 값에 여러건을 넘기기의한 값(직종)
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; 		//스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuInttnCdArr;	//스트링 값에 여러건을 넘기기의한 값(직종세통합)
    
    private List<String> dtilOccuClsDivCdArr; 	//스트링 값에 여러건을 넘기기의한 값
    
    /** hdofcCodtnCd */
    private List<String> hdofcCodtnCdArr;  		//스트링 값에 여러건을 넘기기의한 값(재직)
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;	
    
    /** set 현_호봉발령일자 : currPyspAppmtDt */
    private java.lang.String currPyspAppmtDt;

    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;
    
    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumNm;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmNm;
    
    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;  
    
    private java.lang.String mangeDeptCd;  


     /**
     * Comment : 
     * @fn java.lang.String getDeptCdAuth()
     * @brief date:2015 Dec 22, 2015 user:leeheuisung
     * @return the deptCdAuth get
     */
    public java.lang.String getDeptCdAuth() {
    	return deptCdAuth;
    }

    /**
     * Comment : 
     *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
     *@brief date:2015 Dec 22, 2015 user:leeheuisung
     *@param deptCdAuth the deptCdAuth to set
     */
    public void setDeptCdAuth(java.lang.String deptCdAuth) {
    	this.deptCdAuth = deptCdAuth;
    }

    /**
     * Comment : 
     * @fn java.lang.String getDtilOccuInttnCdAuth()
     * @brief date:2015 Dec 22, 2015 user:leeheuisung
     * @return the dtilOccuInttnCdAuth get
     */
    public java.lang.String getDtilOccuInttnCdAuth() {
    	return dtilOccuInttnCdAuth;
    }

    /**
     * Comment : 
     *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
     *@brief date:2015 Dec 22, 2015 user:leeheuisung
     *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
     */
    public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
    	this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
    }
    

	public List<String> getHdofcCodtnCdArr() {
		return hdofcCodtnCdArr;
	}

	public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
		this.hdofcCodtnCdArr = hdofcCodtnCdArr;
	}
	
	
	private java.lang.String srhLogStdDt;
	private List<String> systemKeyArr;
    
	
	
	
    public java.lang.String getSrhLogStdDt() {
		return srhLogStdDt;
	}

	public void setSrhLogStdDt(java.lang.String srhLogStdDt) {
		this.srhLogStdDt = srhLogStdDt;
	}

	public List<String> getSystemKeyArr() {
		return systemKeyArr;
	}

	public void setSystemKeyArr(List<String> systemKeyArr) {
		this.systemKeyArr = systemKeyArr;
	}



	/** set 성별구분코드 : sxDivCd */
    private java.lang.String sxDivCd;
    
    /** set usrId : usrId */
    private java.lang.String usrId;   
    
    
    
    
    
    public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}
    
    public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getCurrPyspAppmtDt() {
		return currPyspAppmtDt;
	}

	public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
		this.currPyspAppmtDt = currPyspAppmtDt;
	}

	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}

	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
	}

	public java.lang.String getLogSvcYrNumNm() {
		return logSvcYrNumNm;
	}

	public void setLogSvcYrNumNm(java.lang.String logSvcYrNumNm) {
		this.logSvcYrNumNm = logSvcYrNumNm;
	}

	public java.lang.String getLogSvcMnthIcmNm() {
		return logSvcMnthIcmNm;
	}

	public void setLogSvcMnthIcmNm(java.lang.String logSvcMnthIcmNm) {
		this.logSvcMnthIcmNm = logSvcMnthIcmNm;
	}

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getSxDivCd() {
		return sxDivCd;
	}

	public void setSxDivCd(java.lang.String sxDivCd) {
		this.sxDivCd = sxDivCd;
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

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
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

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}
	
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	public List<String> getPyspGrdeCdArr() {
		return pyspGrdeCdArr;
	}

	public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
		this.pyspGrdeCdArr = pyspGrdeCdArr;
	}

	public List<String> getDtilOccuClsDivCdArr() {
		return dtilOccuClsDivCdArr;
	}

	public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
		this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
	}
	
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}


	private java.lang.String repbtyBusinDivCd;
	
	public java.lang.String getRepbtyBusinDivCd() {
	    return repbtyBusinDivCd;
	}
	
	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
	    this.repbtyBusinDivCd = repbtyBusinDivCd;
	}
}
