package com.app.exterms.prgm.client.dto;

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
public class PrgmComBass0350DTO implements Serializable {
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
    
    
    
    /**
	 * Comment : 직종세통합코드리스트 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 직종세통합코드리스트 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
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
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getPyspGrdeCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the pyspGrdeCdArr get
	 */
	public List<String> getPyspGrdeCdArr() {
		return pyspGrdeCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCdArr(List<String> pyspGrdeCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param pyspGrdeCdArr the pyspGrdeCdArr to set
	 */
	public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
		this.pyspGrdeCdArr = pyspGrdeCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuClsDivCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the dtilOccuClsDivCdArr get
	 */
	public List<String> getDtilOccuClsDivCdArr() {
		return dtilOccuClsDivCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param dtilOccuClsDivCdArr the dtilOccuClsDivCdArr to set
	 */
	public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
		this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
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
	
	 

    public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuJbfmlDivCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the dtilOccuJbfmlDivCd get
	 */
	public java.lang.String getDtilOccuJbfmlDivCd() {
		return dtilOccuJbfmlDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuJbfmlDivCd(java.lang.String dtilOccuJbfmlDivCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param dtilOccuJbfmlDivCd the dtilOccuJbfmlDivCd to set
	 */
	public void setDtilOccuJbfmlDivCd(java.lang.String dtilOccuJbfmlDivCd) {
		this.dtilOccuJbfmlDivCd = dtilOccuJbfmlDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getChngTgtYn()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the chngTgtYn get
	 */
	public java.lang.String getChngTgtYn() {
		return chngTgtYn;
	}

	/**
	 * Comment : 
	 *@fn void setChngTgtYn(java.lang.String chngTgtYn)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param chngTgtYn the chngTgtYn to set
	 */
	public void setChngTgtYn(java.lang.String chngTgtYn) {
		this.chngTgtYn = chngTgtYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBggLogSvcYrNumCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the bggLogSvcYrNumCd get
	 */
	public java.lang.String getBggLogSvcYrNumCd() {
		return bggLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 *@fn void setBggLogSvcYrNumCd(java.lang.String bggLogSvcYrNumCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param bggLogSvcYrNumCd the bggLogSvcYrNumCd to set
	 */
	public void setBggLogSvcYrNumCd(java.lang.String bggLogSvcYrNumCd) {
		this.bggLogSvcYrNumCd = bggLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}
    
    
    
}
