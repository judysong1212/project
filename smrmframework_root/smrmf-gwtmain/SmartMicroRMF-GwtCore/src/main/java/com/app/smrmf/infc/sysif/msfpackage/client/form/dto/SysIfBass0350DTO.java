package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Bass0350VO.java
 * @Description : Bass0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfBass0350DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세명 : dtilOccuClsNm */
    private java.lang.String dtilOccuClsNm;

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    private java.lang.String dtilOccuJbfmlDivCd;

    /** set 직종세사용여부 : dtilOccuClsUseYn */
    private java.lang.String dtilOccuClsUseYn;

    /** set 전환대상여부 : chngTgtYn */
    private java.lang.String chngTgtYn;

    /** set 직종세내용 : dtilOccuClsCtnt */
    private java.lang.String dtilOccuClsCtnt;

    /** set 정렬순서 : dtilOccuClsOrd */
    private Long dtilOccuClsOrd;

    /** set 최대근속년수코드 : bggLogSvcYrNumCd */
    private java.lang.String bggLogSvcYrNumCd;

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
    
    
    //부서코드
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    //관리부서코드 
    /** set 단위기관코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;
     
  
     
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값 직종세 개별 
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값  직종세 통합 사용시 사용 
    
    
     
     
    /** 일자 구분  Y : 년도 / YM :년월 / YMD 일자    */
    private String YmdGb;
    
    /** 일자구분에 따른 넘김값   */
    private String strDate;  
    
 
   /** 부서코드 - DEPT_CD */
   private List<String> rtnDeptCdArr;
   /** TYP_OCCU_CD */
   private List<String> rtnTypOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값 
    
   private List<String> rtnDtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
   
   

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
private java.lang.String dtilOcclsApptnUcstCd;

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
private java.math.BigDecimal dtilOcclsApptnUcstSum;


 
     
    
//    /** TYP_OCCU_CD */
//    private java.lang.String arrTypOccuCd;  //스트링 값에 여러건을 넘기기의한 값
//    
//    /** pyspGrdeCd */
//    private java.lang.String arrPyspGrdeCd; //스트링 값에 여러건을 넘기기의한 값
   
     

    /**
 * Comment : 
 * @fn java.lang.String getDtilOcclsApptnUcstCd()
 * @brief date:2016 2016. 12. 13. user:atres-pc
 * @return the dtilOcclsApptnUcstCd get
 */
public java.lang.String getDtilOcclsApptnUcstCd() {
	return dtilOcclsApptnUcstCd;
}

/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2017 2017. 6. 3. user:atres
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2017 2017. 6. 3. user:atres
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

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
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2017 2017. 1. 20. user:atres-pc
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2017 2017. 1. 20. user:atres-pc
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
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
 *@fn void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd)
 *@brief date:2016 2016. 12. 13. user:atres-pc
 *@param dtilOcclsApptnUcstCd the dtilOcclsApptnUcstCd to set
 */
public void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd) {
	this.dtilOcclsApptnUcstCd = dtilOcclsApptnUcstCd;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getDtilOcclsApptnUcstSum()
 * @brief date:2016 2016. 12. 13. user:atres-pc
 * @return the dtilOcclsApptnUcstSum get
 */
public java.math.BigDecimal getDtilOcclsApptnUcstSum() {
	return dtilOcclsApptnUcstSum;
}

/**
 * Comment : 
 *@fn void setDtilOcclsApptnUcstSum(java.math.BigDecimal dtilOcclsApptnUcstSum)
 *@brief date:2016 2016. 12. 13. user:atres-pc
 *@param dtilOcclsApptnUcstSum the dtilOcclsApptnUcstSum to set
 */
public void setDtilOcclsApptnUcstSum(java.math.BigDecimal dtilOcclsApptnUcstSum) {
	this.dtilOcclsApptnUcstSum = dtilOcclsApptnUcstSum;
}

 

	public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDtilOccuJbfmlDivCd() {
		return dtilOccuJbfmlDivCd;
	}

	public void setDtilOccuJbfmlDivCd(java.lang.String dtilOccuJbfmlDivCd) {
		this.dtilOccuJbfmlDivCd = dtilOccuJbfmlDivCd;
	}

	public java.lang.String getChngTgtYn() {
		return chngTgtYn;
	}

	public void setChngTgtYn(java.lang.String chngTgtYn) {
		this.chngTgtYn = chngTgtYn;
	}

	public java.lang.String getBggLogSvcYrNumCd() {
		return bggLogSvcYrNumCd;
	}

	public void setBggLogSvcYrNumCd(java.lang.String bggLogSvcYrNumCd) {
		this.bggLogSvcYrNumCd = bggLogSvcYrNumCd;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public Long getDtilOccuClsOrd() {
        return dtilOccuClsOrd;
    }

    public void setDtilOccuClsOrd(Long dtilOccuClsOrd) {
        this.dtilOccuClsOrd = dtilOccuClsOrd;
    }

    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }

    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }

    public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getDtilOccuClsNm() {
        return this.dtilOccuClsNm;
    }
    
    public void setDtilOccuClsNm(java.lang.String dtilOccuClsNm) {
        this.dtilOccuClsNm = dtilOccuClsNm;
    }
    
    public java.lang.String getDtilOccuClsCtnt() {
        return this.dtilOccuClsCtnt;
    }
    
    public void setDtilOccuClsCtnt(java.lang.String dtilOccuClsCtnt) {
        this.dtilOccuClsCtnt = dtilOccuClsCtnt;
    }
    
    public java.lang.String getDtilOccuClsUseYn() {
        return this.dtilOccuClsUseYn;
    }
    
    public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
        this.dtilOccuClsUseYn = dtilOccuClsUseYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
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
    
    
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
