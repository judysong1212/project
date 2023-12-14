package com.app.exterms.diligence.server.vo;

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
public class Dlgn0200SrhVO implements Serializable {
	
	 
    
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
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    private java.lang.String dilnlazExceDutyYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;
    
    /** hdofcCodtnCd */
    private List<String> hdofcCodtnCdArr;  		//스트링 값에 여러건을 넘기기의한 값(재직)

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  		//스트링 값에 여러건을 넘기기의한 값(직종)

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
    
    private java.lang.String usrId;				/** set usrId : usrId */
    private java.lang.String payrMangDeptYn ;	//단위기관담당자여부 처리를 위한 부분 
    private java.lang.String payrMangDeptCd; 	//단위기관 담당자 여부
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
	private List<String> dtilOccuInttnCdArr;	//스트링 값에 여러건을 넘기기의한 값(직종세통합)
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;
    	
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    private java.lang.String repbtyBusinDivCd; /** set 호봉제구분코드 : REPBTY_BUSIN_DIV_CD */
    
    
	/** set 복무통합구분값 : typOccuBusinVal */
    private java.lang.String typOccuBusinVal;

	 public java.lang.String getTypOccuBusinVal() {
		return typOccuBusinVal;
	}

	public void setTypOccuBusinVal(java.lang.String typOccuBusinVal) {
		this.typOccuBusinVal = typOccuBusinVal;
	}

     
    
	public java.lang.String getHanNm() {
		return hanNm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRepbtyBusinDivCd()
	 * @brief date:2016 2016. 5. 18. user:Administrator
	 * @return the repbtyBusinDivCd get
	 */
	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd)
	 *@brief date:2016 2016. 5. 18. user:Administrator
	 *@param repbtyBusinDivCd the repbtyBusinDivCd to set
	 */
	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
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

	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
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

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
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
