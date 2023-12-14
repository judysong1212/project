package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0250DefaultVO.java
 * @Description : Payr0250 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0250SrhVO implements Serializable {
	 
    
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
   
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
     
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
     

    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
     
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    /** BUSIN_CD */
    private java.lang.String businCd;
     
    /**  작업년월 JOB_YR_MNTH */
    private java.lang.String jobYrMnth;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM */
    private java.lang.String hanNm;
    
    private java.lang.String  dtilOccuClsDivCd; //직종세 
 
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
     
	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    

    /** set 사용자구분코드 : usrDivCd */
    private java.lang.String usrDivCd;
    
       private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값

    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
      
    
	/** 부서코드 - DEPT_CD */
	private java.lang.String deptCdAuth;
	
	 /** 직종세통합코드 dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCdAuth;  
	
	/** 관리부서코드  mangeDeptCd */
	private java.lang.String  mangeDeptCd;
 
	 
	/** 호봉제구분코드  srhRepbtyBusinDivCd */
	private java.lang.String  repbtyBusinDivCd;
	 
	  
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
 * Comment : 호봉제구분코드
 * @fn java.lang.String getRepbtyBusinDivCd()
 * @brief date:2018 2018. 3. 15. user:atres
 * @return the repbtyBusinDivCd get
 */
public java.lang.String getRepbtyBusinDivCd() {
	return repbtyBusinDivCd;
}

/**
 * Comment : 
 *@fn void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd)
 *@brief date:2018 2018. 3. 15. user:atres
 *@param repbtyBusinDivCd the repbtyBusinDivCd to set
 */
public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
	this.repbtyBusinDivCd = repbtyBusinDivCd;
}

	/**
	 * Comment : 호봉제구분코드
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

	/**
	 * Comment : 사용자아이디
	 * @fn java.lang.String getUsrId()
	 * @brief date:2015 Dec 1, 2015 user:leeheuisung
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 사용자아이디
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2015 Dec 1, 2015 user:leeheuisung
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 사용자구분코드
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2015 Dec 1, 2015 user:leeheuisung
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 사용자구분코드
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2015 Dec 1, 2015 user:leeheuisung
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 1, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 1, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Dec 1, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Dec 1, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
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

    public List<String> getDeptCdArr() {
        return deptCdArr;
    }

    public void setDeptCdArr(List<String> deptCdArr) {
        this.deptCdArr = deptCdArr;
    }

    public java.lang.String getPayrMangDeptYn() {
        return payrMangDeptYn;
    }

    public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
        this.payrMangDeptYn = payrMangDeptYn;
    }

    public java.lang.String getDtilOccuClsDivCd() {
        return dtilOccuClsDivCd;
    }

    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
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

    public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getJobYrMnth() {
		return jobYrMnth;
	}

	public void setJobYrMnth(java.lang.String jobYrMnth) {
		this.jobYrMnth = jobYrMnth;
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
