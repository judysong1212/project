package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Insr3150DefaultVO.java
 * @Description : Insr3150 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.03.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3150SrhVO implements Serializable {

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

    /** 사업장코드 - DPOB_CD */
    private java.lang.String dpobCd;
 
    /** 검색 공제년도 */
    private java.lang.String srhDeductYr;

	/** 검색 공제월 */
    private java.lang.String srhDeductMnth;

    /** set 건간보험정산귀속년도 : hlthInsrYr */
    private java.lang.String hlthInsrYr;
 
    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 

    private java.lang.String  dtilOccuClsDivCd; //직종세
    /** 부서 - DEPT_NM */
    private java.lang.String deptNm;
    
    /** COMM_CD_NM */
    private java.lang.String commCdNm;
    
    /** ABBR_NM */
    private java.lang.String abbrNm;
    
    /** 관리부서코드 - mangeDeptCd */
    private java.lang.String mangeDeptCd;
    
    private java.lang.String   payrMangeDeptCd;
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM */
    private java.lang.String hanNm;

    /** 직종구분코드 */
    private java.lang.String typOccuCd;
    
   
    
    /** 호봉등급코드 */
    private java.lang.String pyspGrdeCd;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    /** BUSIN_CD 사업코드 */
    private java.lang.String businCd;
    
    /** BUSIN_NM 사업 */
    private java.lang.String businNm;
    
    /** BUSIN_CD 단위기관코드 */
    private java.lang.String payrMangDeptCd;
    

	private List<String> arrRpsttvCd = new ArrayList<String>();
       
    /** EMYMT_TYP_OCCU_CD */
    private java.lang.String businEmymtTypOccuCd;
    
    /** 인사현재부서 CURR_AFFN_DEPT_CD */
    private java.lang.String currAffnDeptCd;
     
    /** deptDspyYn */
    private java.lang.String deptDspyYn = "";
     
    
    /** 재직상태 HDOFC_CODTN_CD */
    public java.lang.String hdofcCodtnCd;
    
    /** 재직상태 HDOFC_CODTN_CD */
    public List<String> hdofcCodtnCdArr;
     
    
  /** TYP_OCCU_CD */
  private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
  
  /** pyspGrdeCd */
  private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
  
  private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
    
	
	 /** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCd;


private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값

/** set 사용자아이디 : usrId */
private java.lang.String usrId;


/** 부서코드 - DEPT_CD */
private java.lang.String deptCdAuth;

/** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCdAuth;

private java.lang.String repbtyBusinDivCd;

        
	/**
 * Comment : 
 * @fn java.lang.String getHlthInsrYr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the hlthInsrYr get
 */
public java.lang.String getHlthInsrYr() {
	return hlthInsrYr;
}

/**
 * Comment : 
 *@fn void setHlthInsrYr(java.lang.String hlthInsrYr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param hlthInsrYr the hlthInsrYr to set
 */
public void setHlthInsrYr(java.lang.String hlthInsrYr) {
	this.hlthInsrYr = hlthInsrYr;
}

 

	/**
 * Comment : 
 * @fn BigDecimal getEmymtSeilNum()
 * @brief date:2016 2016. 4. 26. user:Administrator
 * @return the emymtSeilNum get
 */
public BigDecimal getEmymtSeilNum() {
	return emymtSeilNum;
}

/**
 * Comment : 
 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
 *@brief date:2016 2016. 4. 26. user:Administrator
 *@param emymtSeilNum the emymtSeilNum to set
 */
public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
	this.emymtSeilNum = emymtSeilNum;
}

	/**
 * Comment : 
 * @fn java.lang.String getDpobCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dpobCd get
 */
public java.lang.String getDpobCd() {
	return dpobCd;
}

/**
 * Comment : 
 *@fn void setDpobCd(java.lang.String dpobCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dpobCd the dpobCd to set
 */
public void setDpobCd(java.lang.String dpobCd) {
	this.dpobCd = dpobCd;
}

/**
 * Comment : 
 * @fn java.lang.String getDeptCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the deptCd get
 */
public java.lang.String getDeptCd() {
	return deptCd;
}

/**
 * Comment : 
 *@fn void setDeptCd(java.lang.String deptCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param deptCd the deptCd to set
 */
public void setDeptCd(java.lang.String deptCd) {
	this.deptCd = deptCd;
}

/**
 * Comment : 
 * @fn List<String> getDeptCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the deptCdArr get
 */
public List<String> getDeptCdArr() {
	return deptCdArr;
}

/**
 * Comment : 
 *@fn void setDeptCdArr(List<String> deptCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param deptCdArr the deptCdArr to set
 */
public void setDeptCdArr(List<String> deptCdArr) {
	this.deptCdArr = deptCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getPayrMangDeptYn()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the payrMangDeptYn get
 */
public java.lang.String getPayrMangDeptYn() {
	return payrMangDeptYn;
}

/**
 * Comment : 
 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param payrMangDeptYn the payrMangDeptYn to set
 */
public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
	this.payrMangDeptYn = payrMangDeptYn;
}

/**
 * Comment : 
 * @fn java.lang.String getDtilOccuClsDivCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dtilOccuClsDivCd get
 */
public java.lang.String getDtilOccuClsDivCd() {
	return dtilOccuClsDivCd;
}

/**
 * Comment : 
 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
 */
public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
	this.dtilOccuClsDivCd = dtilOccuClsDivCd;
}

/**
 * Comment : 
 * @fn java.lang.String getDeptNm()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the deptNm get
 */
public java.lang.String getDeptNm() {
	return deptNm;
}

/**
 * Comment : 
 *@fn void setDeptNm(java.lang.String deptNm)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param deptNm the deptNm to set
 */
public void setDeptNm(java.lang.String deptNm) {
	this.deptNm = deptNm;
}

/**
 * Comment : 
 * @fn java.lang.String getCommCdNm()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the commCdNm get
 */
public java.lang.String getCommCdNm() {
	return commCdNm;
}

/**
 * Comment : 
 *@fn void setCommCdNm(java.lang.String commCdNm)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param commCdNm the commCdNm to set
 */
public void setCommCdNm(java.lang.String commCdNm) {
	this.commCdNm = commCdNm;
}

/**
 * Comment : 
 * @fn java.lang.String getAbbrNm()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the abbrNm get
 */
public java.lang.String getAbbrNm() {
	return abbrNm;
}

/**
 * Comment : 
 *@fn void setAbbrNm(java.lang.String abbrNm)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param abbrNm the abbrNm to set
 */
public void setAbbrNm(java.lang.String abbrNm) {
	this.abbrNm = abbrNm;
}

/**
 * Comment : 
 * @fn java.lang.String getMangeDeptCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the mangeDeptCd get
 */
public java.lang.String getMangeDeptCd() {
	return mangeDeptCd;
}

/**
 * Comment : 
 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param mangeDeptCd the mangeDeptCd to set
 */
public void setMangeDeptCd(java.lang.String mangeDeptCd) {
	this.mangeDeptCd = mangeDeptCd;
}

/**
 * Comment : 
 * @fn java.lang.String getPayrMangeDeptCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the payrMangeDeptCd get
 */
public java.lang.String getPayrMangeDeptCd() {
	return payrMangeDeptCd;
}

/**
 * Comment : 
 *@fn void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param payrMangeDeptCd the payrMangeDeptCd to set
 */
public void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd) {
	this.payrMangeDeptCd = payrMangeDeptCd;
}

/**
 * Comment : 
 * @fn java.lang.String getEmymtDivCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the emymtDivCd get
 */
public java.lang.String getEmymtDivCd() {
	return emymtDivCd;
}

/**
 * Comment : 
 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param emymtDivCd the emymtDivCd to set
 */
public void setEmymtDivCd(java.lang.String emymtDivCd) {
	this.emymtDivCd = emymtDivCd;
}

/**
 * Comment : 
 * @fn java.lang.String getSystemkey()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the systemkey get
 */
public java.lang.String getSystemkey() {
	return systemkey;
}

/**
 * Comment : 
 *@fn void setSystemkey(java.lang.String systemkey)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param systemkey the systemkey to set
 */
public void setSystemkey(java.lang.String systemkey) {
	this.systemkey = systemkey;
}

/**
 * Comment : 
 * @fn java.lang.String getHanNm()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the hanNm get
 */
public java.lang.String getHanNm() {
	return hanNm;
}

/**
 * Comment : 
 *@fn void setHanNm(java.lang.String hanNm)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param hanNm the hanNm to set
 */
public void setHanNm(java.lang.String hanNm) {
	this.hanNm = hanNm;
}

/**
 * Comment : 
 * @fn java.lang.String getTypOccuCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the typOccuCd get
 */
public java.lang.String getTypOccuCd() {
	return typOccuCd;
}

/**
 * Comment : 
 *@fn void setTypOccuCd(java.lang.String typOccuCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param typOccuCd the typOccuCd to set
 */
public void setTypOccuCd(java.lang.String typOccuCd) {
	this.typOccuCd = typOccuCd;
} 

/**
 * Comment : 
 * @fn java.lang.String getPyspGrdeCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the pyspGrdeCd get
 */
public java.lang.String getPyspGrdeCd() {
	return pyspGrdeCd;
}

/**
 * Comment : 
 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param pyspGrdeCd the pyspGrdeCd to set
 */
public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
	this.pyspGrdeCd = pyspGrdeCd;
}

/**
 * Comment : 
 * @fn java.lang.String getResnRegnNum()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the resnRegnNum get
 */
public java.lang.String getResnRegnNum() {
	return resnRegnNum;
}

/**
 * Comment : 
 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param resnRegnNum the resnRegnNum to set
 */
public void setResnRegnNum(java.lang.String resnRegnNum) {
	this.resnRegnNum = resnRegnNum;
}

/**
 * Comment : 
 * @fn java.lang.String getBusinCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the businCd get
 */
public java.lang.String getBusinCd() {
	return businCd;
}

/**
 * Comment : 
 *@fn void setBusinCd(java.lang.String businCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param businCd the businCd to set
 */
public void setBusinCd(java.lang.String businCd) {
	this.businCd = businCd;
}

/**
 * Comment : 
 * @fn java.lang.String getBusinNm()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the businNm get
 */
public java.lang.String getBusinNm() {
	return businNm;
}

/**
 * Comment : 
 *@fn void setBusinNm(java.lang.String businNm)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param businNm the businNm to set
 */
public void setBusinNm(java.lang.String businNm) {
	this.businNm = businNm;
}

/**
 * Comment : 
 * @fn java.lang.String getPayrMangDeptCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the payrMangDeptCd get
 */
public java.lang.String getPayrMangDeptCd() {
	return payrMangDeptCd;
}

/**
 * Comment : 
 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param payrMangDeptCd the payrMangDeptCd to set
 */
public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
	this.payrMangDeptCd = payrMangDeptCd;
}

/**
 * Comment : 
 * @fn List<String> getArrRpsttvCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the arrRpsttvCd get
 */
public List<String> getArrRpsttvCd() {
	return arrRpsttvCd;
}

/**
 * Comment : 
 *@fn void setArrRpsttvCd(List<String> arrRpsttvCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param arrRpsttvCd the arrRpsttvCd to set
 */
public void setArrRpsttvCd(List<String> arrRpsttvCd) {
	this.arrRpsttvCd = arrRpsttvCd;
}

/**
 * Comment : 
 * @fn java.lang.String getBusinEmymtTypOccuCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the businEmymtTypOccuCd get
 */
public java.lang.String getBusinEmymtTypOccuCd() {
	return businEmymtTypOccuCd;
}

/**
 * Comment : 
 *@fn void setBusinEmymtTypOccuCd(java.lang.String businEmymtTypOccuCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param businEmymtTypOccuCd the businEmymtTypOccuCd to set
 */
public void setBusinEmymtTypOccuCd(java.lang.String businEmymtTypOccuCd) {
	this.businEmymtTypOccuCd = businEmymtTypOccuCd;
}

/**
 * Comment : 
 * @fn java.lang.String getCurrAffnDeptCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the currAffnDeptCd get
 */
public java.lang.String getCurrAffnDeptCd() {
	return currAffnDeptCd;
}

/**
 * Comment : 
 *@fn void setCurrAffnDeptCd(java.lang.String currAffnDeptCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param currAffnDeptCd the currAffnDeptCd to set
 */
public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
	this.currAffnDeptCd = currAffnDeptCd;
}

/**
 * Comment : 
 * @fn java.lang.String getDeptDspyYn()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the deptDspyYn get
 */
public java.lang.String getDeptDspyYn() {
	return deptDspyYn;
}

/**
 * Comment : 
 *@fn void setDeptDspyYn(java.lang.String deptDspyYn)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param deptDspyYn the deptDspyYn to set
 */
public void setDeptDspyYn(java.lang.String deptDspyYn) {
	this.deptDspyYn = deptDspyYn;
}

/**
 * Comment : 
 * @fn java.lang.String getHdofcCodtnCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the hdofcCodtnCd get
 */
public java.lang.String getHdofcCodtnCd() {
	return hdofcCodtnCd;
}

/**
 * Comment : 
 *@fn void setHdofcCodtnCd(java.lang.String hdofcCodtnCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param hdofcCodtnCd the hdofcCodtnCd to set
 */
public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
	this.hdofcCodtnCd = hdofcCodtnCd;
}

/**
 * Comment : 
 * @fn List<String> getHdofcCodtnCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the hdofcCodtnCdArr get
 */
public List<String> getHdofcCodtnCdArr() {
	return hdofcCodtnCdArr;
}

/**
 * Comment : 
 *@fn void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param hdofcCodtnCdArr the hdofcCodtnCdArr to set
 */
public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
	this.hdofcCodtnCdArr = hdofcCodtnCdArr;
}
  

/**
 * Comment : 
 * @fn List<String> getTypOccuCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the typOccuCdArr get
 */
public List<String> getTypOccuCdArr() {
	return typOccuCdArr;
}

/**
 * Comment : 
 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param typOccuCdArr the typOccuCdArr to set
 */
public void setTypOccuCdArr(List<String> typOccuCdArr) {
	this.typOccuCdArr = typOccuCdArr;
}

/**
 * Comment : 
 * @fn List<String> getPyspGrdeCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the pyspGrdeCdArr get
 */
public List<String> getPyspGrdeCdArr() {
	return pyspGrdeCdArr;
}

/**
 * Comment : 
 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
 */
public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
	this.pyspGrdeCdArr = pyspGrdeCdArr;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuClsDivCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dtilOccuClsDivCdArr get
 */
public List<String> getDtilOccuClsDivCdArr() {
	return dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
 */
public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
	this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getDtilOccuInttnCd()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dtilOccuInttnCd get
 */
public java.lang.String getDtilOccuInttnCd() {
	return dtilOccuInttnCd;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
 */
public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
	this.dtilOccuInttnCd = dtilOccuInttnCd;
}

/**
 * Comment : 
 * @fn List<String> getDtilOccuInttnCdArr()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dtilOccuInttnCdArr get
 */
public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
 */
public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
}

/**
 * Comment : 
 * @fn java.lang.String getUsrId()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the usrId get
 */
public java.lang.String getUsrId() {
	return usrId;
}

/**
 * Comment : 
 *@fn void setUsrId(java.lang.String usrId)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param usrId the usrId to set
 */
public void setUsrId(java.lang.String usrId) {
	this.usrId = usrId;
}

/**
 * Comment : 
 * @fn java.lang.String getDeptCdAuth()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the deptCdAuth get
 */
public java.lang.String getDeptCdAuth() {
	return deptCdAuth;
}

/**
 * Comment : 
 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param deptCdAuth the deptCdAuth to set
 */
public void setDeptCdAuth(java.lang.String deptCdAuth) {
	this.deptCdAuth = deptCdAuth;
}

/**
 * Comment : 
 * @fn java.lang.String getDtilOccuInttnCdAuth()
 * @brief date:2016 Mar 9, 2016 user:leeheuisung
 * @return the dtilOccuInttnCdAuth get
 */
public java.lang.String getDtilOccuInttnCdAuth() {
	return dtilOccuInttnCdAuth;
}

/**
 * Comment : 
 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
 *@brief date:2016 Mar 9, 2016 user:leeheuisung
 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
 */
public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
	this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

    public java.lang.String getSrhDeductYr() {
		return srhDeductYr;
	}

	public void setSrhDeductYr(java.lang.String srhDeductYr) {
		this.srhDeductYr = srhDeductYr;
	}

	public java.lang.String getSrhDeductMnth() {
		return srhDeductMnth;
	}

	public void setSrhDeductMnth(java.lang.String srhDeductMnth) {
		this.srhDeductMnth = srhDeductMnth;
	}

	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}
	
}
