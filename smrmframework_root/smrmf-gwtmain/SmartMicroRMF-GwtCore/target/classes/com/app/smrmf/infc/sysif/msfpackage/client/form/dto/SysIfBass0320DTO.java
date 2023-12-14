package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Bass0320VO.java
 * @Description : Bass0320 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0320DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종명 : typOccuNm */
    private java.lang.String typOccuNm;

    /** set 직종사용여부 : typOccuUseYn */
    private java.lang.String typOccuUseYn;

    /** set 직종내용 : typOccuCtnt */
    private java.lang.String typOccuCtnt;

    /** set 정렬순서 : typOccuOrd */
    private java.math.BigDecimal typOccuOrd;

    /** set 직종직군구분코드 : typOccuJbfmlDivCd */
    private java.lang.String typOccuJbfmlDivCd;

    /** set null : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;
    
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 단위기관코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
     
    /** 일자 구분  Y : 년도 / YM :년월 / YMD 일자    */
    private String YmdGb;
    
    /** 일자구분에 따른 넘김값   */
    private String strDate;  
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
      
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
   private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
       
   
   /** 부서코드 - DEPT_CD */
   private List<String> rtnDeptCdArr;
   /** TYP_OCCU_CD */
   private List<String> rtnTypOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값 
    
   private List<String> rtnDtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
   
   
    
	/**
 * Comment : 
 * @fn List<String> getRtnDeptCdArr()
 * @brief date:2017 2017. 1. 25. user:atres-pc
 * @return the rtnDeptCdArr get
 */
public List<String> getRtnDeptCdArr() {
	return rtnDeptCdArr;
}

/**
 * Comment : 
 *@fn void setRtnDeptCdArr(List<String> rtnDeptCdArr)
 *@brief date:2017 2017. 1. 25. user:atres-pc
 *@param rtnDeptCdArr the rtnDeptCdArr to set
 */
public void setRtnDeptCdArr(List<String> rtnDeptCdArr) {
	this.rtnDeptCdArr = rtnDeptCdArr;
}

/**
 * Comment : 
 * @fn List<String> getRtnTypOccuCdArr()
 * @brief date:2017 2017. 1. 25. user:atres-pc
 * @return the rtnTypOccuCdArr get
 */
public List<String> getRtnTypOccuCdArr() {
	return rtnTypOccuCdArr;
}

/**
 * Comment : 
 *@fn void setRtnTypOccuCdArr(List<String> rtnTypOccuCdArr)
 *@brief date:2017 2017. 1. 25. user:atres-pc
 *@param rtnTypOccuCdArr the rtnTypOccuCdArr to set
 */
public void setRtnTypOccuCdArr(List<String> rtnTypOccuCdArr) {
	this.rtnTypOccuCdArr = rtnTypOccuCdArr;
}

/**
 * Comment : 
 * @fn List<String> getRtnDtilOccuInttnCdArr()
 * @brief date:2017 2017. 1. 25. user:atres-pc
 * @return the rtnDtilOccuInttnCdArr get
 */
public List<String> getRtnDtilOccuInttnCdArr() {
	return rtnDtilOccuInttnCdArr;
}

/**
 * Comment : 
 *@fn void setRtnDtilOccuInttnCdArr(List<String> rtnDtilOccuInttnCdArr)
 *@brief date:2017 2017. 1. 25. user:atres-pc
 *@param rtnDtilOccuInttnCdArr the rtnDtilOccuInttnCdArr to set
 */
public void setRtnDtilOccuInttnCdArr(List<String> rtnDtilOccuInttnCdArr) {
	this.rtnDtilOccuInttnCdArr = rtnDtilOccuInttnCdArr;
}

	/**
 * Comment : 
 * @fn String getYmdGb()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the ymdGb get
 */
public String getYmdGb() {
	return YmdGb;
}

/**
 * Comment : 
 *@fn void setYmdGb(String YmdGb)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param ymdGb the ymdGb to set
 */
public void setYmdGb(String ymdGb) {
	YmdGb = ymdGb;
}

/**
 * Comment : 
 * @fn String getStrDate()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the strDate get
 */
public String getStrDate() {
	return strDate;
}

/**
 * Comment : 
 *@fn void setStrDate(String strDate)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param strDate the strDate to set
 */
public void setStrDate(String strDate) {
	this.strDate = strDate;
}

/**
 * Comment : 
 * @fn List<String> getTypOccuCdArr()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the typOccuCdArr get
 */
public List<String> getTypOccuCdArr() {
	return typOccuCdArr;
}

/**
 * Comment : 
 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param typOccuCdArr the typOccuCdArr to set
 */
public void setTypOccuCdArr(List<String> typOccuCdArr) {
	this.typOccuCdArr = typOccuCdArr;
}

/**
 * Comment : 
 * @fn List<String> getPyspGrdeCdArr()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the pyspGrdeCdArr get
 */
public List<String> getPyspGrdeCdArr() {
	return pyspGrdeCdArr;
}

/**
 * Comment : 
 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
 */
public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
	this.pyspGrdeCdArr = pyspGrdeCdArr;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuClsDivCdArr()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the dtilOccuClsDivCdArr get
 */
public List<String> getDtilOccuClsDivCdArr() {
	return dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
 */
public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
	this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getDtilOccuInttnCd()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the dtilOccuInttnCd get
 */
public java.lang.String getDtilOccuInttnCd() {
	return dtilOccuInttnCd;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
 */
public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
	this.dtilOccuInttnCd = dtilOccuInttnCd;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuInttnCdArr()
 * @brief date:2017 2017. 1. 20. user:atres-pc
 * @return the dtilOccuInttnCdArr get
 */
public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
 *@brief date:2017 2017. 1. 20. user:atres-pc
 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
 */
public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getTypOccuJbfmlDivCd() {
		return typOccuJbfmlDivCd;
	}

	public void setTypOccuJbfmlDivCd(java.lang.String typOccuJbfmlDivCd) {
		this.typOccuJbfmlDivCd = typOccuJbfmlDivCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	} 
    
    
}
