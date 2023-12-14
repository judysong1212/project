package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Payr0360DefaultVO.java
 * @Description : Payr0360 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0360SrhVO implements Serializable {

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

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 소급년도 : reattyYr */
    private java.lang.String reattyYr;

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    private java.lang.String reattyStpDsptyNum;

    /** set 소급년월 : reattyApptnYrMnth */
    private java.lang.String reattyApptnYrMnth;

    /** set 소급지급일자 : reattyPymtDt */
    private java.lang.String reattyPymtDt;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
    
 
/** 호봉등급코드 */
private java.lang.String pyspGrdeCd; 
  


/** SYSTEMKEY */
private java.lang.String systemkey;

/** HAN_NM */
private java.lang.String hanNm;

/** RESN_REGN_NUM */
private java.lang.String resnRegnNum;
   
/** secResnNum : 주민등록번호 원본*/
private java.lang.String secResnNum;

/** TYP_OCCU_CD */
private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값

/** pyspGrdeCd */
private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값

private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
 

/** 부서코드 - DEPT_CD */
private List<String> deptCdArr;
private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 

/** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCd;
 
private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
 
/** set 사용자아이디 : usrId */
private java.lang.String usrId;


/** 부서코드 - DEPT_CD */
private java.lang.String deptCdAuth;

/** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCdAuth;


/** set 호봉제구분코드 : repbtyBusinDivCd */
private java.lang.String repbtyBusinDivCd;

/** set 인사관리부서코드 : mangeDeptCd */
private java.lang.String mangeDeptCd;



public java.lang.String getRepbtyBusinDivCd() {
	return repbtyBusinDivCd;
}

public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
	this.repbtyBusinDivCd = repbtyBusinDivCd;
}

public java.lang.String getMangeDeptCd() {
	return mangeDeptCd;
}

public void setMangeDeptCd(java.lang.String mangeDeptCd) {
	this.mangeDeptCd = mangeDeptCd;
}

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

/**
 * Comment : 사용자아이디
 * @fn java.lang.String getUsrId()
 * @brief date:2015 Dec 12, 2015 user:leeheuisung
 * @return the usrId get
 */
public java.lang.String getUsrId() {
	return usrId;
}

/**
 * Comment : 사용자아이디
 *@fn void setUsrId(java.lang.String usrId)
 *@brief date:2015 Dec 12, 2015 user:leeheuisung
 *@param usrId the usrId to set
 */
public void setUsrId(java.lang.String usrId) {
	this.usrId = usrId;
}

/**
 * Comment : 직종세통합코드
 * @fn java.lang.String getDtilOccuInttnCd()
 * @brief date:2015 Dec 3, 2015 user:leeheuisung
 * @return the dtilOccuInttnCd get
 */
public java.lang.String getDtilOccuInttnCd() {
	return dtilOccuInttnCd;
}

/**
 * Comment : 직종세통합코드
 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
 *@brief date:2015 Dec 3, 2015 user:leeheuisung
 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
 */
public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
	this.dtilOccuInttnCd = dtilOccuInttnCd;
}

/**
 * Comment : 직종세통합코드arr
 * @fn List<String> getDtilOccuInttnCdArr()
 * @brief date:2015 Dec 3, 2015 user:leeheuisung
 * @return the dtilOccuInttnCdArr get
 */
public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

/**
 * Comment : 직종세통합코드arr
 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
 *@brief date:2015 Dec 3, 2015 user:leeheuisung
 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
 */
public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getReattyYr() {
		return reattyYr;
	}

	public void setReattyYr(java.lang.String reattyYr) {
		this.reattyYr = reattyYr;
	}

	public java.lang.String getReattyStpDsptyNum() {
		return reattyStpDsptyNum;
	}

	public void setReattyStpDsptyNum(java.lang.String reattyStpDsptyNum) {
		this.reattyStpDsptyNum = reattyStpDsptyNum;
	}

	 

	public java.lang.String getReattyApptnYrMnth() {
		return reattyApptnYrMnth;
	}

	public void setReattyApptnYrMnth(java.lang.String reattyApptnYrMnth) {
		this.reattyApptnYrMnth = reattyApptnYrMnth;
	}

	public java.lang.String getReattyPymtDt() {
		return reattyPymtDt;
	}

	public void setReattyPymtDt(java.lang.String reattyPymtDt) {
		this.reattyPymtDt = reattyPymtDt;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

}
