package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : Ye161005DefaultVO.java
 * @Description : Ye161005 Default VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye181005Srh_2021_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 private java.lang.String  UtDpobCd;
	
	/** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    /** 대상자타입 printType */
    private java.lang.String printType;
    
    private java.lang.String busoprRgstnum;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
 
	/** set 귀속연도 : yrtxBlggYr */
	private java.lang.String yrtxBlggYr;

	/** set 연말정산구분코드 : clutSeptCd */
	private java.lang.String clutSeptCd;

    
    /** 성명 HAN_NM */
    private java.lang.String hanNm;
    
    /** 주민번호 RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** 사업코드 BUSIN_CD  */
    private java.lang.String businCd;
    
    private List<String> businCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** 부서코드 DEPT_CD */
    private java.lang.String deptCd;
    
    // 단위기관 담당자 여부
    private java.lang.String  payrMangDeptCd;


	/** 직종코드 TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    
    /** 직종세코드 DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    
    
    public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
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

	public java.lang.String getPrintType() {
		return printType;
	}

	public void setPrintType(java.lang.String printType) {
		this.printType = printType;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}
 
	

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxBlggYr()
	 * @brief date:2018 2018. 1. 17. user:atres
	 * @return the yrtxBlggYr get
	 */
	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxBlggYr(java.lang.String yrtxBlggYr)
	 *@brief date:2018 2018. 1. 17. user:atres
	 *@param yrtxBlggYr the yrtxBlggYr to set
	 */
	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getClutSeptCd()
	 * @brief date:2018 2018. 1. 17. user:atres
	 * @return the clutSeptCd get
	 */
	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setClutSeptCd(java.lang.String clutSeptCd)
	 *@brief date:2018 2018. 1. 17. user:atres
	 *@param clutSeptCd the clutSeptCd to set
	 */
	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
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

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public List<String> getBusinCdArr() {
		return businCdArr;
	}

	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
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

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
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

	/** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 원천세신고부서코드 : whdgTxRegrstDeptCd */
    private java.lang.String whdgTxRegrstDeptCd;
    
	
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getWhdgTxRegrstDeptCd() {
		return whdgTxRegrstDeptCd;
	}

	public void setWhdgTxRegrstDeptCd(java.lang.String whdgTxRegrstDeptCd) {
		this.whdgTxRegrstDeptCd = whdgTxRegrstDeptCd;
	}

	/** �??��조건 */
    private String searchCondition = "";
    
    /** �??��Keyword */
    private String searchKeyword = "";
    
    /** �??��?��?��?���? */
    private String searchUseYn = "";
    
    /** ?��?��?��?���? */
    private int pageIndex = 1;
    
    /** ?��?���?�??�� */
    private int pageUnit = 10;
    
    /** ?��?���??��?���? */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
        
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
	 * @fn java.lang.String getUtDpobCd()
	 * @brief date:2018 2018. 2. 12. user:atres
	 * @return the utDpobCd get
	 */
	public java.lang.String getUtDpobCd() {
		return UtDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setUtDpobCd(java.lang.String UtDpobCd)
	 *@brief date:2018 2018. 2. 12. user:atres
	 *@param utDpobCd the utDpobCd to set
	 */
	public void setUtDpobCd(java.lang.String utDpobCd) {
		UtDpobCd = utDpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusoprRgstnum()
	 * @brief date:2018 2018. 2. 14. user:atres
	 * @return the busoprRgstnum get
	 */
	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprRgstnum(java.lang.String busoprRgstnum)
	 *@brief date:2018 2018. 2. 14. user:atres
	 *@param busoprRgstnum the busoprRgstnum to set
	 */
	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

}
