package com.app.exterms.retirement.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : Remt3100DefaultVO.java
 * @Description : Remt3100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3100SrhVO implements Serializable {

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

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    private java.lang.String sevePayClutMangeNum;

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    private java.lang.String calcSevePayPsnBlggYr;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;
     
    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
    private java.lang.String calcSevePsnBlggYrMnth;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;
 
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
     
    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth01;
    
    private java.lang.String clutYrMnth02;
    
    
    /** 관리부서코드 - mangeDeptCd */
    private java.lang.String mangeDeptCd;
    
    private java.lang.String   payrMangeDeptCd;
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
   
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
	 * Comment :직종세통합코드 
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

	public java.lang.String getClutYrMnth() {
	return clutYrMnth;
}

public void setClutYrMnth(java.lang.String clutYrMnth) {
	this.clutYrMnth = clutYrMnth;
}

	public java.lang.String getDeptCd() {
	return deptCd;
}

public void setDeptCd(java.lang.String deptCd) {
	this.deptCd = deptCd;
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

public java.lang.String getDeptNm() {
	return deptNm;
}

public void setDeptNm(java.lang.String deptNm) {
	this.deptNm = deptNm;
}

public java.lang.String getCommCdNm() {
	return commCdNm;
}

public void setCommCdNm(java.lang.String commCdNm) {
	this.commCdNm = commCdNm;
}

public java.lang.String getAbbrNm() {
	return abbrNm;
}

public void setAbbrNm(java.lang.String abbrNm) {
	this.abbrNm = abbrNm;
}

public java.lang.String getClutYrMnth01() {
	return clutYrMnth01;
}

public void setClutYrMnth01(java.lang.String clutYrMnth01) {
	this.clutYrMnth01 = clutYrMnth01;
}

public java.lang.String getClutYrMnth02() {
	return clutYrMnth02;
}

public void setClutYrMnth02(java.lang.String clutYrMnth02) {
	this.clutYrMnth02 = clutYrMnth02;
}

public java.lang.String getMangeDeptCd() {
	return mangeDeptCd;
}

public void setMangeDeptCd(java.lang.String mangeDeptCd) {
	this.mangeDeptCd = mangeDeptCd;
}

public java.lang.String getPayrMangeDeptCd() {
	return payrMangeDeptCd;
}

public void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd) {
	this.payrMangeDeptCd = payrMangeDeptCd;
}

public java.lang.String getEmymtDivCd() {
	return emymtDivCd;
}

public void setEmymtDivCd(java.lang.String emymtDivCd) {
	this.emymtDivCd = emymtDivCd;
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

public java.lang.String getBusinNm() {
	return businNm;
}

public void setBusinNm(java.lang.String businNm) {
	this.businNm = businNm;
}

public java.lang.String getPayrMangDeptCd() {
	return payrMangDeptCd;
}

public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
	this.payrMangDeptCd = payrMangDeptCd;
}

public List<String> getArrRpsttvCd() {
	return arrRpsttvCd;
}

public void setArrRpsttvCd(List<String> arrRpsttvCd) {
	this.arrRpsttvCd = arrRpsttvCd;
}

public java.lang.String getBusinEmymtTypOccuCd() {
	return businEmymtTypOccuCd;
}

public void setBusinEmymtTypOccuCd(java.lang.String businEmymtTypOccuCd) {
	this.businEmymtTypOccuCd = businEmymtTypOccuCd;
}

public java.lang.String getCurrAffnDeptCd() {
	return currAffnDeptCd;
}

public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
	this.currAffnDeptCd = currAffnDeptCd;
}

public java.lang.String getDeptDspyYn() {
	return deptDspyYn;
}

public void setDeptDspyYn(java.lang.String deptDspyYn) {
	this.deptDspyYn = deptDspyYn;
}

public java.lang.String getHdofcCodtnCd() {
	return hdofcCodtnCd;
}

public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
	this.hdofcCodtnCd = hdofcCodtnCd;
}

public List<String> getHdofcCodtnCdArr() {
	return hdofcCodtnCdArr;
}

public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
	this.hdofcCodtnCdArr = hdofcCodtnCdArr;
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

	public java.lang.String getCalcSevePsnBlggYrMnth() {
		return calcSevePsnBlggYrMnth;
	}

	public void setCalcSevePsnBlggYrMnth(java.lang.String calcSevePsnBlggYrMnth) {
		this.calcSevePsnBlggYrMnth = calcSevePsnBlggYrMnth;
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

	public java.lang.String getCalcSevePayPsnBlggYr() {
		return calcSevePayPsnBlggYr;
	}

	public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
		this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
	}

	public java.lang.String getCalcSevePayPsnDivCd() {
		return calcSevePayPsnDivCd;
	}

	public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
		this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
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
 
}
