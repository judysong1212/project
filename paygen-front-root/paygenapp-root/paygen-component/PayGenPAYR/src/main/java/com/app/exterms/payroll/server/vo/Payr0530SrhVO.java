package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0530DefaultVO.java
 * @Description : Payr0530 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0530SrhVO implements Serializable {
	 
    
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
    
    
//	 /** 엑셀쿼리여부 */
//    private java.lang.String excelYn; 
//    
//    
//	 public java.lang.String getExcelYn() {
//		return excelYn;
//	}
//
//	public void setExcelYn(java.lang.String excelYn) {
//		this.excelYn = excelYn;
//	}

	/** DPOB_CD */
    private java.lang.String dpobCd; 
   
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
 
   /** PAYR_MANG_DEPT_CD */
   private java.lang.String payrMangDeptCd;
    
   /** PAY_CD */
   private java.lang.String payCd;
   
   /** EMYMT_DIV_CD */
   private java.lang.String emymtDivCd;
    
   
   /** DEPT_CD */
   private java.lang.String deptCd;
   
   /** BUSIN_CD */
   private java.lang.String businCd;
   
   
   /** HAN_NM */
   private java.lang.String hanNm;

   /** RESN_REGN_NUM */
   private java.lang.String resnRegnNum;
   
   /** secResnNum : 주민등록번호 원본*/
   private java.lang.String secResnNum;

   /** 직종구분코드 */
   private java.lang.String typOccuCd;
    
   /** 호봉등급코드 */
   private java.lang.String pyspGrdeCd; 
   
   private java.lang.String hdofcCodtnCd; 
  
   
   /** 부서코드 - DEPT_CD */
   private List<String> deptCdArr;
   
   private java.lang.String payrMangDeptYn; //단위기관담당자여부 처리를 위한 부분 

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
   
   
   
   /** BUSIN_APPTN_YR 사업년도 */
   private java.lang.String businApptnYr;
   
   
   /** BUSIN_NM 사업 */
   private java.lang.String businNm;
   
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
   
       
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the payCd get
	 */
	public java.lang.String getPayCd() {
		return payCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayCd(java.lang.String payCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param payCd the payCd to set
	 */
	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the businCd get
	 */
	public java.lang.String getBusinCd() {
		return businCd;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCd(java.lang.String businCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param businCd the businCd to set
	 */
	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHanNm()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the hanNm get
	 */
	public java.lang.String getHanNm() {
		return hanNm;
	}

	/**
	 * Comment : 
	 *@fn void setHanNm(java.lang.String hanNm)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param hanNm the hanNm to set
	 */
	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getResnRegnNum()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the resnRegnNum get
	 */
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param resnRegnNum the resnRegnNum to set
	 */
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHdofcCodtnCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the hdofcCodtnCd get
	 */
	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	/**
	 * Comment : 
	 *@fn void setHdofcCodtnCd(java.lang.String hdofcCodtnCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param hdofcCodtnCd the hdofcCodtnCd to set
	 */
	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptYn()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the payrMangDeptYn get
	 */
	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param payrMangDeptYn the payrMangDeptYn to set
	 */
	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptNm()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the deptNm get
	 */
	public java.lang.String getDeptNm() {
		return deptNm;
	}

	/**
	 * Comment : 
	 *@fn void setDeptNm(java.lang.String deptNm)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param deptNm the deptNm to set
	 */
	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCommCdNm()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the commCdNm get
	 */
	public java.lang.String getCommCdNm() {
		return commCdNm;
	}

	/**
	 * Comment : 
	 *@fn void setCommCdNm(java.lang.String commCdNm)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param commCdNm the commCdNm to set
	 */
	public void setCommCdNm(java.lang.String commCdNm) {
		this.commCdNm = commCdNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAbbrNm()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the abbrNm get
	 */
	public java.lang.String getAbbrNm() {
		return abbrNm;
	}

	/**
	 * Comment : 
	 *@fn void setAbbrNm(java.lang.String abbrNm)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param abbrNm the abbrNm to set
	 */
	public void setAbbrNm(java.lang.String abbrNm) {
		this.abbrNm = abbrNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangeDeptCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the payrMangeDeptCd get
	 */
	public java.lang.String getPayrMangeDeptCd() {
		return payrMangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param payrMangeDeptCd the payrMangeDeptCd to set
	 */
	public void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd) {
		this.payrMangeDeptCd = payrMangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinApptnYr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the businApptnYr get
	 */
	public java.lang.String getBusinApptnYr() {
		return businApptnYr;
	}

	/**
	 * Comment : 
	 *@fn void setBusinApptnYr(java.lang.String businApptnYr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param businApptnYr the businApptnYr to set
	 */
	public void setBusinApptnYr(java.lang.String businApptnYr) {
		this.businApptnYr = businApptnYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinNm()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the businNm get
	 */
	public java.lang.String getBusinNm() {
		return businNm;
	}

	/**
	 * Comment : 
	 *@fn void setBusinNm(java.lang.String businNm)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param businNm the businNm to set
	 */
	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	/**
	 * Comment : 
	 * @fn List<String> getHdofcCodtnCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the hdofcCodtnCdArr get
	 */
	public List<String> getHdofcCodtnCdArr() {
		return hdofcCodtnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param hdofcCodtnCdArr the hdofcCodtnCdArr to set
	 */
	public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
		this.hdofcCodtnCdArr = hdofcCodtnCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getPyspGrdeCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the pyspGrdeCdArr get
	 */
	public List<String> getPyspGrdeCdArr() {
		return pyspGrdeCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
	 */
	public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
		this.pyspGrdeCdArr = pyspGrdeCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuClsDivCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the dtilOccuClsDivCdArr get
	 */
	public List<String> getDtilOccuClsDivCdArr() {
		return dtilOccuClsDivCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
	 */
	public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
		this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCdAuth()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the deptCdAuth get
	 */
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param deptCdAuth the deptCdAuth to set
	 */
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2016 2016. 12. 15. user:atres-pc
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2016 2016. 12. 15. user:atres-pc
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}
    
    

}
