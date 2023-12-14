package com.app.exterms.payroll.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0200DefaultVO.java
 * @Description : Payr0200 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0200SrhVO implements Serializable {
	 
    
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
   
    /** 제외여부 포함 (현재일자기준,종료포함) */
    private java.lang.String dataStatus; 
     
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    /** 관리부서코드 - mangeDeptCd */
    private java.lang.String mangeDeptCd;
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM */
    private java.lang.String hanNm;

    /** 직종구분코드 */
    private java.lang.String typOccuCd;
    
    /** BUSIN_APPTN_YR 사업년도 */
    private java.lang.String businApptnYr;
    
    /** 호봉등급코드 */
    private java.lang.String pyspGrdeCd;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** SEC_REGN_NUM */
    private java.lang.String secRegnNum;
    
    /** BUSIN_CD 사업코드 */
    private java.lang.String businCd;
    
    /** PYMT_DT 지급일자  */
    private java.lang.String pymtDt;
     

	/**공제코드  DDUC_DIV_CD */
   private java.lang.String dducDivCd;
	

    
	 public java.lang.String getPymtDt() {
		return pymtDt;
	}

	public void setPymtDt(java.lang.String pymtDt) {
		this.pymtDt = pymtDt;
	}

	public java.lang.String getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(java.lang.String dataStatus) {
		this.dataStatus = dataStatus;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getBusinApptnYr() {
		return businApptnYr;
	}

	public void setBusinApptnYr(java.lang.String businApptnYr) {
		this.businApptnYr = businApptnYr;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
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

	public java.lang.String getDducDivCd() {
		return dducDivCd;
	}

	public void setDducDivCd(java.lang.String dducDivCd) {
		this.dducDivCd = dducDivCd;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecRegnNum()
	 * @brief date:2016 2016. 6. 26. user:Administrator
	 * @return the secRegnNum get
	 */
	public java.lang.String getSecRegnNum() {
		return secRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecRegnNum(java.lang.String secRegnNum)
	 *@brief date:2016 2016. 6. 26. user:Administrator
	 *@param secRegnNum the secRegnNum to set
	 */
	public void setSecRegnNum(java.lang.String secRegnNum) {
		this.secRegnNum = secRegnNum;
	}

}
