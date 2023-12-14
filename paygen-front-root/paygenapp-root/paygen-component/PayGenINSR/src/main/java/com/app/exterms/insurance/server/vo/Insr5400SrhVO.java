package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : Insr4200DefaultVO.java
 * @Description : Insr4200 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5400SrhVO implements Serializable {

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
    
    
    
    
    /** 사업장코드 - DPOB_CD */
    private java.lang.String dpobCd;

    /** 고용시작일(귀속년도) srhHlthInsrYr */
    public java.lang.String srhHlthInsrYr;

    /** SYSTEMKEY */
    private java.lang.String systemkey;

    /** 부서 - DEPT_NM */
    private java.lang.String deptNm;

    /** 성명 - ACNT_HODR_NM */
    private java.lang.String acntHodrNm;

    /** 주민등록번호 - RESN_REGN_NUM */
    private java.lang.String resnRegnNum;

    /** 보험료부과구분 - PRMM_IPOS_DIV_CD */
    private java.lang.String prmmIposDivCd;

    /** 산재보험사업장코드 - IDTL_DPOB_CD */
    private java.lang.String idtlDpobCd;

    /** 산재보험정산년도 - IDTL_ACCDT_INSUR_CLUT_YR */
    private java.lang.String idtlAccdtInsurClutYr;

    /** 산재보험시스템키 - IDTL_SYSTEMKEY */
    private java.lang.String idtlSystemkey;

    /** 산재보험고용일련번호 - EMYMT_SEIL_NUM1 */
    private java.lang.String emymtSeilNum1;

    /** 산재취득일자 - IDTL_ACCDT_INSUR_AQTN_DT */
    private java.lang.String idtlAccdtInsurAqtnDt;

    /** 산재상실일자 - IDTL_ACCDT_INSUR_LSS_DT */
    private java.lang.String idtlAccdtInsurLssDt;

    /** 산재보수총액 - IDTL_ACCDT_PAY_TOT_AMNT */
    private java.lang.String idtlAccdtPayTotAmnt;

    /** 고용보험사업장코드 - UMYT_DPOB_CD */
    private java.lang.String umytDpobCd;

    /** 고용보험정산년도 - UMYT_INSR_CLUT_YR */
    private java.lang.String umytInsrClutYr;

    /** 고용보험시스템키 - UMYT_SYSTEMKEY */
    private java.lang.String umytSystemkey;

    /** 고용보험고용일련번호 - EMYMT_SEIL_NUM2 */
    private java.lang.String emymtSeilNum2;

    /** 고용보험취득일자 - UMYT_INSR_AQTN_DT */
    private java.lang.String umytInsrAqtnDt;

    /** 고용보험상실일자 - UMYT_INSR_LSS_DT */
    private java.lang.String umytInsrLssDt;

    /** 고용보험보수총액 - UMYT_INSR_PAY_TOT_AMNT */
    private java.lang.String umytInsrPayTotAmnt;

    /** 직종구분코드 - TYP_OCCU_CD*/
    private java.lang.String typOccuCd;

    /** 직종명 - TYP_OCCU_NM*/
    private java.lang.String typOccuNm;

    /** 직종세 - DTIL_OCCU_CLS_DIV_CD*/
    private java.lang.String dtilOccuClsDivCd;






















    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;

    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 

        /** COMM_CD_NM */
    private java.lang.String commCdNm;

    /** ABBR_NM */
    private java.lang.String abbrNm;

    /** 관리부서코드 - mangeDeptCd */
    private java.lang.String mangeDeptCd;

    private java.lang.String   payrMangeDeptCd;

    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    private List<String> systemKeyArr;

    /** HAN_NM */
    private java.lang.String hanNm;

    /** BUSIN_APPTN_YR 사업년도 */
    private java.lang.String businApptnYr;

    /** 호봉등급코드 */
    private java.lang.String pyspGrdeCd;



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

    /** 지급년월 PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth;

    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;  

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

    /** 급여구분코드 srhPayCd */
    //public java.lang.String srhPayCd;
    public java.lang.String payCd;

   









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





	/** set 산재보험사업장코드 : idtlDpobCd */
	public java.lang.String getIdtlDpobCd() {
		return idtlDpobCd;
	}

	public void setIdtlDpobCd(java.lang.String idtlDpobCd) {
		this.idtlDpobCd = idtlDpobCd;
	}

	/** set 산재보험정산년도 : idtlAccdtInsurClutYr */
	public java.lang.String getIdtlAccdtInsurClutYr() {
		return idtlAccdtInsurClutYr;
	}

	public void setIdtlAccdtInsurClutYr(java.lang.String idtlAccdtInsurClutYr) {
		this.idtlAccdtInsurClutYr = idtlAccdtInsurClutYr;
	}

	/** set 산재보험시스템키 : idtlSystemkey */
	public java.lang.String getIdtlSystemkey() {
		return idtlSystemkey;
	}

	public void setIdtlSystemkey(java.lang.String idtlSystemkey) {
		this.idtlSystemkey = idtlSystemkey;
	}

	/** set 산재보험고용일련번호 : emymtSeilNum1 */
	public java.lang.String getEmymtSeilNum1() {
		return emymtSeilNum1;
	}

	public void setEmymtSeilNum1(java.lang.String emymtSeilNum1) {
		this.emymtSeilNum1 = emymtSeilNum1;
	}

	/** set 산재취득일자 : idtlAccdtInsurAqtnDt */
	public java.lang.String getIdtlAccdtInsurAqtnDt() {
		return idtlAccdtInsurAqtnDt;
	}

	public void setIdtlAccdtInsurAqtnDt(java.lang.String idtlAccdtInsurAqtnDt) {
		this.idtlAccdtInsurAqtnDt = idtlAccdtInsurAqtnDt;
	}

	/** set 산재상실일자 : idtlAccdtInsurLssDt */
	public java.lang.String getIdtlAccdtInsurLssDt() {
		return idtlAccdtInsurLssDt;
	}

	public void setIdtlAccdtInsurLssDt(java.lang.String idtlAccdtInsurLssDt) {
		this.idtlAccdtInsurLssDt = idtlAccdtInsurLssDt;
	}

	/** set 산재보수총액 : idtlAccdtPayTotAmnt */
	public java.lang.String getIdtlAccdtPayTotAmnt() {
		return idtlAccdtPayTotAmnt;
	}

	public void setIdtlAccdtPayTotAmnt(java.lang.String idtlAccdtPayTotAmnt) {
		this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
	}

	/** set 고용보험사업장코드 : umytDpobCd */
	public java.lang.String getUmytDpobCd() {
		return umytDpobCd;
	}

	public void setUmytDpobCd(java.lang.String umytDpobCd) {
		this.umytDpobCd = umytDpobCd;
	}

	/** set 고용보험정산년도 : umytInsrClutYr */
	public java.lang.String getUmytInsrClutYr() {
		return umytInsrClutYr;
	}

	public void setUmytInsrClutYr(java.lang.String umytInsrClutYr) {
		this.umytInsrClutYr = umytInsrClutYr;
	}

	/** set 고용보험시스템키 : umytSystemkey */
	public java.lang.String getUmytSystemkey() {
		return umytSystemkey;
	}

	public void setUmytSystemkey(java.lang.String umytSystemkey) {
		this.umytSystemkey = umytSystemkey;
	}

	/** set 고용보험고용일련번호 : emymtSeilNum2 */
	public java.lang.String getEmymtSeilNum2() {
		return emymtSeilNum2;
	}

	public void setEmymtSeilNum2(java.lang.String emymtSeilNum2) {
		this.emymtSeilNum2 = emymtSeilNum2;
	}

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public java.lang.String getUmytInsrAqtnDt() {
		return umytInsrAqtnDt;
	}

	public void setUmytInsrAqtnDt(java.lang.String umytInsrAqtnDt) {
		this.umytInsrAqtnDt = umytInsrAqtnDt;
	}

	/** set 고용보험상실일자 : umytInsrLssDt */
	public java.lang.String getUmytInsrLssDt() {
		return umytInsrLssDt;
	}

	public void setUmytInsrLssDt(java.lang.String umytInsrLssDt) {
		this.umytInsrLssDt = umytInsrLssDt;
	}

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public java.lang.String getUmytInsrPayTotAmnt() {
		return umytInsrPayTotAmnt;
	}

	public void setUmytInsrPayTotAmnt(java.lang.String umytInsrPayTotAmnt) {
		this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
	}

	/** set 직종코드 : typOccuCd */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/** set 직종명 : typOccuNm */
	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	/** set 직종세 : dtilOccuClsDivCd */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/** set 성명 : acntHodrNm */
	public java.lang.String getAcntHodrNm() {
		return acntHodrNm;
	}

	public void setAcntHodrNm(java.lang.String acntHodrNm) {
		this.acntHodrNm = acntHodrNm;
	}

	/** set 보험료부과구분 : prmmIposDivCd */
	public java.lang.String getPrmmIposDivCd() {
		return prmmIposDivCd;
	}

	public void setPrmmIposDivCd(java.lang.String prmmIposDivCd) {
		this.prmmIposDivCd = prmmIposDivCd;
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

	public List<String> getSystemKeyArr() {
		return systemKeyArr;
	}

	public void setSystemKeyArr(List<String> systemKeyArr) {
		this.systemKeyArr = systemKeyArr;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
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

	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
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

	public java.lang.String getPayCd() {
		//return srhPayCd;
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		//this.srhPayCd = payCd;
		this.payCd = payCd;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public void setSrhHlthInsrYr(java.lang.String srhHlthInsrYr) {
		this.srhHlthInsrYr = srhHlthInsrYr;
	}

	public String getSrhHlthInsrYr() {
		return this.srhHlthInsrYr;
	}
	private java.lang.String repbtyBusinDivCd;

	public java.lang.String getRepbtyBusinDivCd() {
	    return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
	    this.repbtyBusinDivCd = repbtyBusinDivCd;
	}
}
