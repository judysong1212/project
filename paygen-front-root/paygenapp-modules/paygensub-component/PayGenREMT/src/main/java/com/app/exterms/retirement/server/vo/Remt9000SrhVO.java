package com.app.exterms.retirement.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Remt9000DefaultVO.java
 * @Description : Remt9000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt9000SrhVO implements Serializable {
	 
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
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    private java.lang.String sevePayClutMangeNum;
     

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;
    
 
   /** EMYMT_DIV_CD */
   private java.lang.String emymtDivCd;
    

   /** TYP_OCCU_CD */
   private java.lang.String typOccuCd;
   
   /** PYSP_GRDE_CD */
   private java.lang.String pyspGrdeCd;
    
   /** DEPT_CD */
   private java.lang.String deptCd;
   
   /** BUSIN_CD */
   private java.lang.String businCd;
    
   /**  작업년 calcSevePayPsnBlggYr */
   private java.lang.String calcSevePayPsnBlggYr;
    
   
   /** HAN_NM */
   private java.lang.String hanNm;

   /** RESN_REGN_NUM */
   private java.lang.String resnRegnNum;

   /** secResnNum : 주민등록번호 원본*/
     private java.lang.String secResnNum;
	
	 /** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCd;


private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값


/** 재직상태 HDOFC_CODTN_CD */
public java.lang.String hdofcCodtnCd;

/** 재직상태 HDOFC_CODTN_CD */
public List<String> hdofcCodtnCdArr;

/** TYP_OCCU_CD */
private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값

/** pyspGrdeCd */
private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값

private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
  
  
 private java.lang.String usrId;
 
 /** BUSIN_CD 단위기관코드 */
 private java.lang.String payrMangDeptCd;
 
 /** 부서코드 - DEPT_CD */
 private List<String> deptCdArr;
 private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 

 
/** 부서코드 - DEPT_CD */
private java.lang.String deptCdAuth;

/** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCdAuth;
 
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
 * Comment : 
 * @fn java.lang.String getPayrMangDeptCd()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the payrMangDeptCd get
 */
public java.lang.String getPayrMangDeptCd() {
	return payrMangDeptCd;
}

/**
 * Comment : 
 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param payrMangDeptCd the payrMangDeptCd to set
 */
public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
	this.payrMangDeptCd = payrMangDeptCd;
}

/**
 * Comment : 
 * @fn List<String> getDeptCdArr()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the deptCdArr get
 */
public List<String> getDeptCdArr() {
	return deptCdArr;
}

/**
 * Comment : 
 *@fn void setDeptCdArr(List<String> deptCdArr)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param deptCdArr the deptCdArr to set
 */
public void setDeptCdArr(List<String> deptCdArr) {
	this.deptCdArr = deptCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getPayrMangDeptYn()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the payrMangDeptYn get
 */
public java.lang.String getPayrMangDeptYn() {
	return payrMangDeptYn;
}

/**
 * Comment : 
 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param payrMangDeptYn the payrMangDeptYn to set
 */
public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
	this.payrMangDeptYn = payrMangDeptYn;
}

	/**
 * Comment : 
 * @fn java.lang.String getHdofcCodtnCd()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the hdofcCodtnCd get
 */
public java.lang.String getHdofcCodtnCd() {
	return hdofcCodtnCd;
}

/**
 * Comment : 
 *@fn void setHdofcCodtnCd(java.lang.String hdofcCodtnCd)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param hdofcCodtnCd the hdofcCodtnCd to set
 */
public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
	this.hdofcCodtnCd = hdofcCodtnCd;
}

/**
 * Comment : 
 * @fn List<String> getHdofcCodtnCdArr()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the hdofcCodtnCdArr get
 */
public List<String> getHdofcCodtnCdArr() {
	return hdofcCodtnCdArr;
}

/**
 * Comment : 
 *@fn void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param hdofcCodtnCdArr the hdofcCodtnCdArr to set
 */
public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
	this.hdofcCodtnCdArr = hdofcCodtnCdArr;
}

/**
 * Comment : 
 * @fn List<String> getTypOccuCdArr()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the typOccuCdArr get
 */
public List<String> getTypOccuCdArr() {
	return typOccuCdArr;
}

/**
 * Comment : 
 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param typOccuCdArr the typOccuCdArr to set
 */
public void setTypOccuCdArr(List<String> typOccuCdArr) {
	this.typOccuCdArr = typOccuCdArr;
}

/**
 * Comment : 
 * @fn List<String> getPyspGrdeCdArr()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the pyspGrdeCdArr get
 */
public List<String> getPyspGrdeCdArr() {
	return pyspGrdeCdArr;
}

/**
 * Comment : 
 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
 */
public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
	this.pyspGrdeCdArr = pyspGrdeCdArr;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuClsDivCdArr()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the dtilOccuClsDivCdArr get
 */
public List<String> getDtilOccuClsDivCdArr() {
	return dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
 */
public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
	this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getUsrId()
 * @brief date:2015 Dec 11, 2015 user:leeheuisung
 * @return the usrId get
 */
public java.lang.String getUsrId() {
	return usrId;
}

/**
 * Comment : 
 *@fn void setUsrId(java.lang.String usrId)
 *@brief date:2015 Dec 11, 2015 user:leeheuisung
 *@param usrId the usrId to set
 */
public void setUsrId(java.lang.String usrId) {
	this.usrId = usrId;
}

	/**
 * Comment : 직종세통합코드
 * @fn java.lang.String getDtilOccuInttnCd()
 * @brief date:2015 Nov 24, 2015 user:leeheuisung
 * @return the dtilOccuInttnCd get
 */
public java.lang.String getDtilOccuInttnCd() {
	return dtilOccuInttnCd;
}

/**
 * Comment : 직종세통합코드
 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
 *@brief date:2015 Nov 24, 2015 user:leeheuisung
 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
 */
public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
	this.dtilOccuInttnCd = dtilOccuInttnCd;
}

/**
 * Comment : 직종세통합코드arr
 * @fn List<String> getDtilOccuInttnCdArr()
 * @brief date:2015 Nov 24, 2015 user:leeheuisung
 * @return the dtilOccuInttnCdArr get
 */
public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

/**
 * Comment : 직종세통합코드arr
 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
 *@brief date:2015 Nov 24, 2015 user:leeheuisung
 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
 */
public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
}

	public java.lang.String getCalcSevePayPsnDivCd() {
    return calcSevePayPsnDivCd;
}

public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
    this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
}

public java.lang.String getEmymtDivCd() {
    return emymtDivCd;
}

public void setEmymtDivCd(java.lang.String emymtDivCd) {
    this.emymtDivCd = emymtDivCd;
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

public java.lang.String getCalcSevePayPsnBlggYr() {
    return calcSevePayPsnBlggYr;
}

public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
    this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
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

    public java.lang.String getSevePayClutMangeNum() {
        return sevePayClutMangeNum;
    }

    public void setSevePayClutMangeNum(java.lang.String sevePayClutMangeNum) {
        this.sevePayClutMangeNum = sevePayClutMangeNum;
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

}
