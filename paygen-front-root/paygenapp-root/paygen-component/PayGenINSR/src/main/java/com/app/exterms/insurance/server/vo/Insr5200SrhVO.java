package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : Insr5200DefaultVO.java
 * @Description : Insr5200 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5200SrhVO implements Serializable {

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
    
    private String srhPayYr= "";

	private String srhPayMonth= "";

    public String getSrhPayYr() {
		return srhPayYr;
	}
    
	/** 사업장코드 - DPOB_CD */
	private java.lang.String dpobCd;

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

	/** NOFCT_YR_MNTH */
	private java.lang.String nofctYrMnth;

	

	/** NOFCT_DSPTY */
	private java.math.BigDecimal nofctDspty;

	/** HLTH_INSR_SEIL_NUM */
	//  private java.math.BigDecimal hlthInsrSeilNum;
	/** set 고용일련번호 : emymtSeilNum */
	private BigDecimal  emymtSeilNum;


	/** 직종세통합코드 dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;


	private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값

	/** set 사용자아이디 : usrId */
	private java.lang.String usrId;

	/** 부서코드 - DEPT_CD */
	private java.lang.String deptCdAuth;

	/** 직종세통합코드 dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCdAuth;  

	private java.lang.String pymtYrMnth;

	private List<String> systemKeyArr;

	/** 검색고지년 - srhNofctYr */
	private java.lang.String srhNofctYr;

	/** 검색고지월 - srhNofctMnth */
	private java.lang.String srhNofctMnth;
	
	/** 공제년월 - dducYrMnth */
	private java.lang.String dducYrMnth;
    
	/** 업로드구분  - uploadDivCd */
	private java.lang.String uploadDivCd;
	

	public java.lang.String getUploadDivCd() {
		return uploadDivCd;
	}

	public void setUploadDivCd(java.lang.String uploadDivCd) {
		this.uploadDivCd = uploadDivCd;
	}

	public java.lang.String getDducYrMnth() {
		return dducYrMnth;
	}

	public void setDducYrMnth(java.lang.String dducYrMnth) {
		this.dducYrMnth = dducYrMnth;
	}

	public void setSrhPayYr(String srhPayYr) {
		this.srhPayYr = srhPayYr;
	}

	public String getSrhPayMonth() {
		return srhPayMonth;
	}

	public void setSrhPayMonth(String srhPayMonth) {
		this.srhPayMonth = srhPayMonth;
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
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

	public java.lang.String getNofctYrMnth() {
		return nofctYrMnth;
	}

	public void setNofctYrMnth(java.lang.String nofctYrMnth) {
		this.nofctYrMnth = nofctYrMnth;
	}

	public java.math.BigDecimal getNofctDspty() {
		return nofctDspty;
	}

	public void setNofctDspty(java.math.BigDecimal nofctDspty) {
		this.nofctDspty = nofctDspty;
	}

	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

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

	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public List<String> getSystemKeyArr() {
		return systemKeyArr;
	}

	public void setSystemKeyArr(List<String> systemKeyArr) {
		this.systemKeyArr = systemKeyArr;
	}

	public java.lang.String getSrhNofctYr() {
		return srhNofctYr;
	}

	public void setSrhNofctYr(java.lang.String srhNofctYr) {
		this.srhNofctYr = srhNofctYr;
	}

	public java.lang.String getSrhNofctMnth() {
		return srhNofctMnth;
	}

	public void setSrhNofctMnth(java.lang.String srhNofctMnth) {
		this.srhNofctMnth = srhNofctMnth;
	}
    
	private java.lang.String repbtyBusinDivCd;

	public java.lang.String getRepbtyBusinDivCd() {
	    return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
	    this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

}