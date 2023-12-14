package com.app.smrmf.infc.yearendtax.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Yeta1000VO.java
 * @Description : Yeta1000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYeta1000VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String srhPayrMangDeptCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String srhEmymtDivCd;
    
    
    /** set 부서코드 : deptCd */
    private java.lang.String srhDeptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String srhTypOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String srhDtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String srhPyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String srhDtilOccuInttnCd;

    /** set 사업코드 : businCd */
    private java.lang.String srhBusinCd;
    
    
    
    public java.lang.String getSrhPayrMangDeptCd() {
		return srhPayrMangDeptCd;
	}

	public void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd) {
		this.srhPayrMangDeptCd = srhPayrMangDeptCd;
	}

	public java.lang.String getSrhEmymtDivCd() {
		return srhEmymtDivCd;
	}

	public void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd) {
		this.srhEmymtDivCd = srhEmymtDivCd;
	}

	public java.lang.String getSrhDeptCd() {
		return srhDeptCd;
	}

	public void setSrhDeptCd(java.lang.String srhDeptCd) {
		this.srhDeptCd = srhDeptCd;
	}

	public java.lang.String getSrhTypOccuCd() {
		return srhTypOccuCd;
	}

	public void setSrhTypOccuCd(java.lang.String srhTypOccuCd) {
		this.srhTypOccuCd = srhTypOccuCd;
	}

	public java.lang.String getSrhDtilOccuClsDivCd() {
		return srhDtilOccuClsDivCd;
	}

	public void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd) {
		this.srhDtilOccuClsDivCd = srhDtilOccuClsDivCd;
	}

	public java.lang.String getSrhPyspGrdeCd() {
		return srhPyspGrdeCd;
	}

	public void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd) {
		this.srhPyspGrdeCd = srhPyspGrdeCd;
	}

	public java.lang.String getSrhDtilOccuInttnCd() {
		return srhDtilOccuInttnCd;
	}

	public void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd) {
		this.srhDtilOccuInttnCd = srhDtilOccuInttnCd;
	}

	public java.lang.String getSrhBusinCd() {
		return srhBusinCd;
	}

	public void setSrhBusinCd(java.lang.String srhBusinCd) {
		this.srhBusinCd = srhBusinCd;
	}
    
  
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 연말정산마감일련번호 : edacSeilNum */
    private java.math.BigDecimal edacSeilNum;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 생성직원번호 : pernChrgEmpIdenNum */
    private java.lang.String pernChrgEmpIdenNum;

    /** set 마감여부 : closFlag */
    private java.lang.String closFlag;

    /** set 마감건수 : closCont */
    private java.math.BigDecimal closCont;

    /** set 마감일자 : closDate */
    private java.lang.String closDate;

    /** set 연말정산제출일자 : edacPrdt */
    private java.lang.String edacPrdt;

    /** set 대표자성명 : reprName */
    private java.lang.String reprName;

    /** set 법인명_상호 : juriName */
    private java.lang.String juriName;

    /** set 사업자등록번호 : busiNumb */
    private java.lang.String busiNumb;

    /** set 주민등록번호 : resuNumb */
    private java.lang.String resuNumb;

    /** set 법인번호 : juriNumb */
    private java.lang.String juriNumb;

    /** set 소득신고의무자우편번호 : incmPost */
    private java.lang.String incmPost;

    /** set 소득신고의무자기본주소 : incmAddr */
    private java.lang.String incmAddr;

    /** set 소득신고의무자상세주소 : incmAdtl */
    private java.lang.String incmAdtl;

    /** set 관할세무서코드 : taxaCode */
    private java.lang.String taxaCode;

    /** set 제출자구분코드 : incmGbcd */
    private java.lang.String incmGbcd;

    /** set 세무대리인번호 : taxaDnum */
    private java.lang.String taxaDnum;

    /** set 홈텍스ID : homeTxid */
    private java.lang.String homeTxid;

    /** set 세무프로그램코드 : taxaPrcd */
    private java.lang.String taxaPrcd;

    /** set 담당자부서명 : charDept */
    private java.lang.String charDept;

    /** set 담당자성명 : charName */
    private java.lang.String charName;

    /** set 담당자전화번호 : charTele */
    private java.lang.String charTele;

    /** set FILE_PASS : filePass */
    private java.lang.String filePass;

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

 
    
    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    
    private java.lang.String addCheck;
    
    private java.lang.String creFile; 
    

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    

    /** 사업코드 BUSIN_CD  */
    private List<String> businCdArr; 
    
   
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     

    /** set 원천징수의무부서코드 : yetaDpcd */
    private java.lang.String yetaDpcd;
 
    private java.lang.String busoprRgstnum;  
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getBusoprRgstnum()
	 * @brief date:2017 2017. 2. 14. user:atres-pc
	 * @return the busoprRgstnum get
	 */
	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprRgstnum(java.lang.String busoprRgstnum)
	 *@brief date:2017 2017. 2. 14. user:atres-pc
	 *@param busoprRgstnum the busoprRgstnum to set
	 */
	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

	/**
 * Comment : 
 * @fn java.lang.String getYetaDpcd()
 * @brief date:2017 2017. 2. 14. user:atres-pc
 * @return the yetaDpcd get
 */
public java.lang.String getYetaDpcd() {
	return yetaDpcd;
}

/**
 * Comment : 
 *@fn void setYetaDpcd(java.lang.String yetaDpcd)
 *@brief date:2017 2017. 2. 14. user:atres-pc
 *@param yetaDpcd the yetaDpcd to set
 */
public void setYetaDpcd(java.lang.String yetaDpcd) {
	this.yetaDpcd = yetaDpcd;
}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCdAuth()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the deptCdAuth get
	 */
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param deptCdAuth the deptCdAuth to set
	 */
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptYn()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the payrMangDeptYn get
	 */
	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param payrMangDeptYn the payrMangDeptYn to set
	 */
	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAddCheck()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the addCheck get
	 */
	public java.lang.String getAddCheck() {
		return addCheck;
	}

	/**
	 * Comment : 
	 *@fn void setAddCheck(java.lang.String addCheck)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param addCheck the addCheck to set
	 */
	public void setAddCheck(java.lang.String addCheck) {
		this.addCheck = addCheck;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCreFile()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the creFile get
	 */
	public java.lang.String getCreFile() {
		return creFile;
	}

	/**
	 * Comment : 
	 *@fn void setCreFile(java.lang.String creFile)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param creFile the creFile to set
	 */
	public void setCreFile(java.lang.String creFile) {
		this.creFile = creFile;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getBusinCdArr()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the businCdArr get
	 */
	public List<String> getBusinCdArr() {
		return businCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCdArr(List<String> businCdArr)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param businCdArr the businCdArr to set
	 */
	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2017 2017. 1. 15. user:atres-pc
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2017 2017. 1. 15. user:atres-pc
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEdacSeilNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the edacSeilNum get
	 */
	public java.math.BigDecimal getEdacSeilNum() {
		return edacSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEdacSeilNum(java.math.BigDecimal edacSeilNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param edacSeilNum the edacSeilNum to set
	 */
	public void setEdacSeilNum(java.math.BigDecimal edacSeilNum) {
		this.edacSeilNum = edacSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the businCd get
	 */
	public java.lang.String getBusinCd() {
		return businCd;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCd(java.lang.String businCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param businCd the businCd to set
	 */
	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPernChrgEmpIdenNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the pernChrgEmpIdenNum get
	 */
	public java.lang.String getPernChrgEmpIdenNum() {
		return pernChrgEmpIdenNum;
	}

	/**
	 * Comment : 
	 *@fn void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param pernChrgEmpIdenNum the pernChrgEmpIdenNum to set
	 */
	public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
		this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
	}

	public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getClosFlag() {
        return this.closFlag;
    }
    
    public void setClosFlag(java.lang.String closFlag) {
        this.closFlag = closFlag;
    }
    
    public java.math.BigDecimal getClosCont() {
        return this.closCont;
    }
    
    public void setClosCont(java.math.BigDecimal closCont) {
        this.closCont = closCont;
    }
    
    public java.lang.String getClosDate() {
        return this.closDate;
    }
    
    public void setClosDate(java.lang.String closDate) {
        this.closDate = closDate;
    }
    
    public java.lang.String getEdacPrdt() {
        return this.edacPrdt;
    }
    
    public void setEdacPrdt(java.lang.String edacPrdt) {
        this.edacPrdt = edacPrdt;
    }
    
    public java.lang.String getReprName() {
        return this.reprName;
    }
    
    public void setReprName(java.lang.String reprName) {
        this.reprName = reprName;
    }
    
    public java.lang.String getJuriName() {
        return this.juriName;
    }
    
    public void setJuriName(java.lang.String juriName) {
        this.juriName = juriName;
    }
    
    public java.lang.String getBusiNumb() {
        return this.busiNumb;
    }
    
    public void setBusiNumb(java.lang.String busiNumb) {
        this.busiNumb = busiNumb;
    }
    
    public java.lang.String getResuNumb() {
        return this.resuNumb;
    }
    
    public void setResuNumb(java.lang.String resuNumb) {
        this.resuNumb = resuNumb;
    }
    
    public java.lang.String getJuriNumb() {
        return this.juriNumb;
    }
    
    public void setJuriNumb(java.lang.String juriNumb) {
        this.juriNumb = juriNumb;
    }
    
    public java.lang.String getIncmPost() {
        return this.incmPost;
    }
    
    public void setIncmPost(java.lang.String incmPost) {
        this.incmPost = incmPost;
    }
    
    public java.lang.String getIncmAddr() {
        return this.incmAddr;
    }
    
    public void setIncmAddr(java.lang.String incmAddr) {
        this.incmAddr = incmAddr;
    }
    
    public java.lang.String getIncmAdtl() {
        return this.incmAdtl;
    }
    
    public void setIncmAdtl(java.lang.String incmAdtl) {
        this.incmAdtl = incmAdtl;
    }
    
    public java.lang.String getTaxaCode() {
        return this.taxaCode;
    }
    
    public void setTaxaCode(java.lang.String taxaCode) {
        this.taxaCode = taxaCode;
    }
    
    public java.lang.String getIncmGbcd() {
        return this.incmGbcd;
    }
    
    public void setIncmGbcd(java.lang.String incmGbcd) {
        this.incmGbcd = incmGbcd;
    }
    
    public java.lang.String getTaxaDnum() {
        return this.taxaDnum;
    }
    
    public void setTaxaDnum(java.lang.String taxaDnum) {
        this.taxaDnum = taxaDnum;
    }
    
    public java.lang.String getHomeTxid() {
        return this.homeTxid;
    }
    
    public void setHomeTxid(java.lang.String homeTxid) {
        this.homeTxid = homeTxid;
    }
    
    public java.lang.String getTaxaPrcd() {
        return this.taxaPrcd;
    }
    
    public void setTaxaPrcd(java.lang.String taxaPrcd) {
        this.taxaPrcd = taxaPrcd;
    }
    
    public java.lang.String getCharDept() {
        return this.charDept;
    }
    
    public void setCharDept(java.lang.String charDept) {
        this.charDept = charDept;
    }
    
    public java.lang.String getCharName() {
        return this.charName;
    }
    
    public void setCharName(java.lang.String charName) {
        this.charName = charName;
    }
    
    public java.lang.String getCharTele() {
        return this.charTele;
    }
    
    public void setCharTele(java.lang.String charTele) {
        this.charTele = charTele;
    }
    
    public java.lang.String getFilePass() {
        return this.filePass;
    }
    
    public void setFilePass(java.lang.String filePass) {
        this.filePass = filePass;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
