package com.app.smrmf.infc.diligence.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Dlgn0200DefaultVO.java
 * @Description : Dlgn0200 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgDlgn0250SrhVO implements Serializable {
	
	 
    
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

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    private java.lang.String dilnlazExceDutyYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    
    /**  작업년월 JOB_YR_MNTH */
    private java.lang.String jobYrMnth;
    
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
      
    /** 지급년월 PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth;
    
     
    /** HAN_NM */
    private java.lang.String hanNm;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;

    /** TYP_OCCU_CD */
    private java.lang.String typOccucdIn;
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCdIn;
     

    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    private java.lang.String dilnlazDutyBgnnDt;

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    private java.lang.String dilnlazDutyEndDt;
    
    

    public java.lang.String getDilnlazDutyBgnnDt() {
        return dilnlazDutyBgnnDt;
    }

    public void setDilnlazDutyBgnnDt(java.lang.String dilnlazDutyBgnnDt) {
        this.dilnlazDutyBgnnDt = dilnlazDutyBgnnDt;
    }

    public java.lang.String getDilnlazDutyEndDt() {
        return dilnlazDutyEndDt;
    }

    public void setDilnlazDutyEndDt(java.lang.String dilnlazDutyEndDt) {
        this.dilnlazDutyEndDt = dilnlazDutyEndDt;
    }

    public java.lang.String getPayrMangDeptYn() {
        return payrMangDeptYn;
    }

    public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
        this.payrMangDeptYn = payrMangDeptYn;
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

    /** RFLCTN_BGNN_DT */
    private java.lang.String rflctnBgnnDt;
    
    /** RFLCTN_END_DT */
    private java.lang.String rflctnEndDt; 
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    

    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
      
    
    
    
	public java.lang.String getJobYrMnth() {
        return jobYrMnth;
    }

    public void setJobYrMnth(java.lang.String jobYrMnth) {
        this.jobYrMnth = jobYrMnth;
    }

    public java.lang.String getTypOccucdIn() {
        return typOccucdIn;
    }

    public void setTypOccucdIn(java.lang.String typOccucdIn) {
        this.typOccucdIn = typOccucdIn;
    }

    public java.lang.String getPyspGrdeCdIn() {
        return pyspGrdeCdIn;
    }

    public void setPyspGrdeCdIn(java.lang.String pyspGrdeCdIn) {
        this.pyspGrdeCdIn = pyspGrdeCdIn;
    }

    public java.lang.String getRflctnBgnnDt() {
        return rflctnBgnnDt;
    }

    public void setRflctnBgnnDt(java.lang.String rflctnBgnnDt) {
        this.rflctnBgnnDt = rflctnBgnnDt;
    }

    public java.lang.String getRflctnEndDt() {
        return rflctnEndDt;
    }

    public void setRflctnEndDt(java.lang.String rflctnEndDt) {
        this.rflctnEndDt = rflctnEndDt;
    }

    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getPymtYrMnth() {
        return pymtYrMnth;
    }

    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
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

    public java.lang.String getDilnlazExceDutyYrMnth() {
        return dilnlazExceDutyYrMnth;
    }

    public void setDilnlazExceDutyYrMnth(java.lang.String dilnlazExceDutyYrMnth) {
        this.dilnlazExceDutyYrMnth = dilnlazExceDutyYrMnth;
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
	 * Comment : 원본 주민등록번호 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 원본 주민등록번호  
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

}
