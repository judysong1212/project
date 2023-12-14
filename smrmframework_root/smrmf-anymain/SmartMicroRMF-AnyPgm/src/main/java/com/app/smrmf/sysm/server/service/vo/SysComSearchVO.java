package com.app.smrmf.sysm.server.service.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0100DefaultVO.java
 * @Description : Bass0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysComSearchVO implements Serializable {
	 
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
    
    /**
     * 공통코드 검색을 위한 조건  - 대표코드
     */
   
    private java.lang.String commKey;
    
    /** 대표코드 - RPSTTV_CD */
    private java.lang.String rpsttvCd;
    
    /** 사업장코드 - DPOB_CD */
    private java.lang.String dpobCd;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    private java.lang.String retryDt01;
    private java.lang.String retryDt02;
    private java.lang.String emymtBgnnDt01;
    private java.lang.String emymtBgnnDt02;
    
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
    
    /** BUSIN_APPTN_YR 사업년도 */
    private java.lang.String businApptnYr;
    
    /** 호봉등급코드 */
    private java.lang.String pyspGrdeCd;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** BUSIN_CD 사업코드 */
    private java.lang.String businCd;
    
    /** BUSIN_NM 사업 */
    private java.lang.String businNm;
    
    /** BUSIN_CD 단위기관코드 */
    private java.lang.String payrMangDeptCd;
    
    /** usrDivNm 사용자권한구분코드  */
    private java.lang.String usrDivNm;
    
    /** UT_DPOB_CD 단위사업장코드  */
    private java.lang.String utDpobCd;
    
    
	private List<String> arrRpsttvCd = new ArrayList<String>();
       
    /** EMYMT_TYP_OCCU_CD */
    private java.lang.String businEmymtTypOccuCd;
    
    /** 인사현재부서 CURR_AFFN_DEPT_CD */
    private java.lang.String currAffnDeptCd;
    
    /** MANGE_ITEM01 */
    private java.lang.String mangeItem01;
    
    /** MANGE_ITEM02 */
    private java.lang.String mangeItem02;
    
    /** MANGE_ITEM03 */
    private java.lang.String mangeItem03;
    
    /** MANGE_ITEM04 */
    private java.lang.String mangeItem04;
    
    /** MANGE_ITEM05 */
    private java.lang.String mangeItem05;
    
    /** MANGE_ITEM06 */
    private java.lang.String mangeItem06;
    
    /** MANGE_ITEM07 */
    private java.lang.String mangeItem07;
    
    /** MANGE_ITEM08 */
    private java.lang.String mangeItem08;
    
    /** MANGE_ITEM09 */
    private java.lang.String mangeItem09;
    
    /** MANGE_ITEM10 */
    private java.lang.String mangeItem10;
    
    /** MANGE_ITEM11 */
    private java.lang.String mangeItem11;
    
    /** MANGE_ITEM12 */
    private java.lang.String mangeItem12;
    
    /** MANGE_ITEM13 */
    private java.lang.String mangeItem13;
    
    /** MANGE_ITEM14 */
    private java.lang.String mangeItem14;
    
    /** MANGE_ITEM15 */
    private java.lang.String mangeItem15;
    
    /** MANGE_ITEM16 */
    private java.lang.String mangeItem16;
    
    /** MANGE_ITEM17 */
    private java.lang.String mangeItem17;
    
    /** MANGE_ITEM18 */
    private java.lang.String mangeItem18;
    
    /** MANGE_ITEM19 */
    private java.lang.String mangeItem19;
    
    /** MANGE_ITEM20 */
    private java.lang.String mangeItem20;
    
    /** deptDspyYn */
    private java.lang.String deptDspyYn = "";
    
    /** COMM_CD */
    private java.lang.String commCd;
    
    /** 재직상태 HDOFC_CODTN_CD */
    public java.lang.String hdofcCodtnCd;
    
    /** 재직상태 HDOFC_CODTN_CD */
    public List<String> hdofcCodtnCdArr;
    
  /** TYP_OCCU_CD */
  private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
  
  /** pyspGrdeCd */
  private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
  
  private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값

  
  /** 일자 구분  Y : 년도 / YM :년월 / YMD 일자    */
  private String YmdGb;
  
  /** 일자구분에 따른 넘김값   */
  private String strDate;  
    
  
    /** 급여구분코드 payCd */
    public java.lang.String payCd; 
      
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    

    /** set 사용자구분코드 : usrDivCd */
    private java.lang.String usrDivCd;
    
     
	 /** 직종세통합코드 dtilOccuInttnCd */
   private java.lang.String dtilOccuInttnCd;


   private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
        
    
   /** 부서코드 - DEPT_CD */
   private java.lang.String deptCdAuth;
	
	 /** 직종세통합코드 dtilOccuInttnCd */
  private java.lang.String dtilOccuInttnCdAuth;
  
  
  
    /**
	 * Comment : 
	 * @fn String getYmdGb()
	 * @brief date:2017 2017. 1. 23. user:atres-pc
	 * @return the ymdGb get
	 */
	public String getYmdGb() {
		return YmdGb;
	}

	/**
	 * Comment : 
	 *@fn void setYmdGb(String YmdGb)
	 *@brief date:2017 2017. 1. 23. user:atres-pc
	 *@param ymdGb the ymdGb to set
	 */
	public void setYmdGb(String ymdGb) {
		YmdGb = ymdGb;
	}

	/**
	 * Comment : 
	 * @fn String getStrDate()
	 * @brief date:2017 2017. 1. 23. user:atres-pc
	 * @return the strDate get
	 */
	public String getStrDate() {
		return strDate;
	}

	/**
	 * Comment : 
	 *@fn void setStrDate(String strDate)
	 *@brief date:2017 2017. 1. 23. user:atres-pc
	 *@param strDate the strDate to set
	 */
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2017 2017. 1. 23. user:atres-pc
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2017 2017. 1. 23. user:atres-pc
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
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
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 8, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 8, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 사용자구분코드
	 * @fn java.lang.String getUsrDivCd()
	 * @brief date:2015 Nov 30, 2015 user:leeheuisung
	 * @return the usrDivCd get
	 */
	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	/**
	 * Comment : 사용자구분코드
	 *@fn void setUsrDivCd(java.lang.String usrDivCd)
	 *@brief date:2015 Nov 30, 2015 user:leeheuisung
	 *@param usrDivCd the usrDivCd to set
	 */
	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	/**
	 * Comment : 유우저아이디 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2015 Nov 13, 2015 user:leeheuisung
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 유우저아이디
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2015 Nov 13, 2015 user:leeheuisung
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 공통코드
	 * @fn java.lang.String getCommCd()
	 * @brief date:2015 Nov 13, 2015 user:leeheuisung
	 * @return the commCd get
	 */
	public java.lang.String getCommCd() {
		return commCd;
	}

	/**
	 * Comment : 공통코드
	 *@fn void setCommCd(java.lang.String commCd)
	 *@brief date:2015 Nov 13, 2015 user:leeheuisung
	 *@param commCd the commCd to set
	 */
	public void setCommCd(java.lang.String commCd) {
		this.commCd = commCd;
	}

	public java.lang.String getRetryDt01() {
		return retryDt01;
	}

	public void setRetryDt01(java.lang.String retryDt01) {
		this.retryDt01 = retryDt01;
	}

	public java.lang.String getRetryDt02() {
		return retryDt02;
	}

	public void setRetryDt02(java.lang.String retryDt02) {
		this.retryDt02 = retryDt02;
	}

	public java.lang.String getEmymtBgnnDt01() {
		return emymtBgnnDt01;
	}

	public void setEmymtBgnnDt01(java.lang.String emymtBgnnDt01) {
		this.emymtBgnnDt01 = emymtBgnnDt01;
	}

	public java.lang.String getEmymtBgnnDt02() {
		return emymtBgnnDt02;
	}

	public void setEmymtBgnnDt02(java.lang.String emymtBgnnDt02) {
		this.emymtBgnnDt02 = emymtBgnnDt02;
	}

	public List<String> getDtilOccuClsDivCdArr() {
        return dtilOccuClsDivCdArr;
    }

    public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
        this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
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

    public List<String> getHdofcCodtnCdArr() {
        return hdofcCodtnCdArr;
    }

    public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
        this.hdofcCodtnCdArr = hdofcCodtnCdArr;
    }

    public java.lang.String getDtilOccuClsDivCd() {
        return dtilOccuClsDivCd;
    }

    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }

    public java.lang.String getDeptDspyYn() {
        return deptDspyYn;
    }

    public void setDeptDspyYn(java.lang.String deptDspyYn) {
        this.deptDspyYn = deptDspyYn;
    }

    public java.lang.String getPayrMangeDeptCd() {
        return payrMangeDeptCd;
    }

    public void setPayrMangeDeptCd(java.lang.String payrMangeDeptCd) {
        this.payrMangeDeptCd = payrMangeDeptCd;
    }

    public java.lang.String getCommKey() {
        return commKey;
    }

    public void setCommKey(java.lang.String commKey) {
        this.commKey = commKey;
    }

    public java.lang.String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(java.lang.String deptNm) {
        this.deptNm = deptNm;
    }

    public java.lang.String getPayCd() {
        return payCd;
    }

    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }

    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getBusinEmymtTypOccuCd() {
        return businEmymtTypOccuCd;
    }

    public void setBusinEmymtTypOccuCd(java.lang.String businEmymtTypOccuCd) {
        this.businEmymtTypOccuCd = businEmymtTypOccuCd;
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

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	
	
	public java.lang.String getBusinNm() {
        return businNm;
    }

    public void setBusinNm(java.lang.String businNm) {
        this.businNm = businNm;
    }

    public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
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

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getMangeItem01() {
		return mangeItem01;
	}

	public void setMangeItem01(java.lang.String mangeItem01) {
		this.mangeItem01 = mangeItem01;
	}

	public java.lang.String getMangeItem02() {
		return mangeItem02;
	}

	public void setMangeItem02(java.lang.String mangeItem02) {
		this.mangeItem02 = mangeItem02;
	}

	public java.lang.String getMangeItem03() {
		return mangeItem03;
	}

	public void setMangeItem03(java.lang.String mangeItem03) {
		this.mangeItem03 = mangeItem03;
	}

	public java.lang.String getMangeItem04() {
		return mangeItem04;
	}

	public void setMangeItem04(java.lang.String mangeItem04) {
		this.mangeItem04 = mangeItem04;
	}

	public java.lang.String getMangeItem05() {
		return mangeItem05;
	}

	public void setMangeItem05(java.lang.String mangeItem05) {
		this.mangeItem05 = mangeItem05;
	}

	public java.lang.String getMangeItem06() {
		return mangeItem06;
	}

	public void setMangeItem06(java.lang.String mangeItem06) {
		this.mangeItem06 = mangeItem06;
	}

	public java.lang.String getMangeItem07() {
		return mangeItem07;
	}

	public void setMangeItem07(java.lang.String mangeItem07) {
		this.mangeItem07 = mangeItem07;
	}

	public java.lang.String getMangeItem08() {
		return mangeItem08;
	}

	public void setMangeItem08(java.lang.String mangeItem08) {
		this.mangeItem08 = mangeItem08;
	}

	public java.lang.String getMangeItem09() {
		return mangeItem09;
	}

	public void setMangeItem09(java.lang.String mangeItem09) {
		this.mangeItem09 = mangeItem09;
	}

	public java.lang.String getMangeItem10() {
		return mangeItem10;
	}

	public void setMangeItem10(java.lang.String mangeItem10) {
		this.mangeItem10 = mangeItem10;
	}

	public java.lang.String getMangeItem11() {
		return mangeItem11;
	}

	public void setMangeItem11(java.lang.String mangeItem11) {
		this.mangeItem11 = mangeItem11;
	}

	public java.lang.String getMangeItem12() {
		return mangeItem12;
	}

	public void setMangeItem12(java.lang.String mangeItem12) {
		this.mangeItem12 = mangeItem12;
	}

	public java.lang.String getMangeItem13() {
		return mangeItem13;
	}

	public void setMangeItem13(java.lang.String mangeItem13) {
		this.mangeItem13 = mangeItem13;
	}

	public java.lang.String getMangeItem14() {
		return mangeItem14;
	}

	public void setMangeItem14(java.lang.String mangeItem14) {
		this.mangeItem14 = mangeItem14;
	}

	public java.lang.String getMangeItem15() {
		return mangeItem15;
	}

	public void setMangeItem15(java.lang.String mangeItem15) {
		this.mangeItem15 = mangeItem15;
	}

	public java.lang.String getMangeItem16() {
		return mangeItem16;
	}

	public void setMangeItem16(java.lang.String mangeItem16) {
		this.mangeItem16 = mangeItem16;
	}

	public java.lang.String getMangeItem17() {
		return mangeItem17;
	}

	public void setMangeItem17(java.lang.String mangeItem17) {
		this.mangeItem17 = mangeItem17;
	}

	public java.lang.String getMangeItem18() {
		return mangeItem18;
	}

	public void setMangeItem18(java.lang.String mangeItem18) {
		this.mangeItem18 = mangeItem18;
	}

	public java.lang.String getMangeItem19() {
		return mangeItem19;
	}

	public void setMangeItem19(java.lang.String mangeItem19) {
		this.mangeItem19 = mangeItem19;
	}

	public java.lang.String getMangeItem20() {
		return mangeItem20;
	}

	public void setMangeItem20(java.lang.String mangeItem20) {
		this.mangeItem20 = mangeItem20;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getBusinApptnYr() {
		return businApptnYr;
	}

	public void setBusinApptnYr(java.lang.String businApptnYr) {
		this.businApptnYr = businApptnYr;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}
    
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public List<String> getArrRpsttvCd() {
		return arrRpsttvCd;
	}

	public void setArrRpsttvCd(List<String> arrRpsttvCd) {
		this.arrRpsttvCd = arrRpsttvCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getRpsttvCd() {
		return rpsttvCd;
	}

	public void setRpsttvCd(java.lang.String rpsttvCd) {
		this.rpsttvCd = rpsttvCd;
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
	 * Comment : 사용자권한구분코드
	 * @fn java.lang.String getUsrDivNm()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the usrDivNm get
	 */
	public java.lang.String getUsrDivNm() {
		return usrDivNm;
	}

	/**
	 * Comment : 사용자권한구분코드
	 *@fn void setUsrDivNm(java.lang.String usrDivNm)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param usrDivNm the usrDivNm to set
	 */
	public void setUsrDivNm(java.lang.String usrDivNm) {
		this.usrDivNm = usrDivNm;
	}

	/**
	 * Comment : 단위사업장코드
	 * @fn java.lang.String getUtDpobCd()
	 * @brief date:2017 2017. 11. 9. user:atres
	 * @return the utDpobCd get
	 */
	public java.lang.String getUtDpobCd() {
		return utDpobCd;
	}

	/**
	 * Comment : 단위사업장코드
	 *@fn void setUtDpobCd(java.lang.String utDpobCd)
	 *@brief date:2017 2017. 11. 9. user:atres
	 *@param utDpobCd the utDpobCd to set
	 */
	public void setUtDpobCd(java.lang.String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}
    
    

}
