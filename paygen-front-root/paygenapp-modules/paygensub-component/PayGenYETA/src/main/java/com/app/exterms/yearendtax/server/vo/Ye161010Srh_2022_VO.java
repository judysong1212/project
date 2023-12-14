package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Class Name : Yeta1000DefaultVO.java
 * @Description : Yeta1000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye161010Srh_2022_VO implements Serializable {

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

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 당시_고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 당시_부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 당시_직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 당시_직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 당시_사업코드 : businCd */
    private java.lang.String businCd;

    /** set 생성직원번호 : pernChrgEmpIdenNum */
    private java.lang.String pernChrgEmpIdenNum;

    /** set 마감여부 : closFlag */
    private java.lang.String closFlag;

    /** set 마감건수 : closCont */
    private java.math.BigDecimal closCont;

    /** set 마감일자 : closDate */
    private java.lang.String closDate;

    /** set 연말정산제출일자 : edacPrdt */
    private java.lang.String edacPrdt;

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
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
     
    private java.lang.String  utDpobChk;
    /** 성명 HAN_NM */
    private java.lang.String hanNm;
    
    /** 주민번호 RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    private java.lang.String busoprRgstnum;    
    
	/** secResnNum : 주민등록번호 원본 */
	private java.lang.String secResnNum;
	
	 /** 관리부서코드  mangeDeptCd 05.04 수정 */
    private java.lang.String  mangeDeptCd; 
      
    
    /** 호봉등급코드 PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** 직종세코드 DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
    

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  		//스트링 값에 여러건을 넘기기의한 값(직종)
    
    /** pyspGrdeCd */
    private List<String> pyspGrdeCdArr; 		//스트링 값에 여러건을 넘기기의한 값
    
    private List<String> dtilOccuInttnCdArr;	//스트링 값에 여러건을 넘기기의한 값(직종세통합)
    
    private List<String> dtilOccuClsDivCdArr; 	//스트링 값에 여러건을 넘기기의한 값
    
    /** hdofcCodtnCd */
    private List<String> hdofcCodtnCdArr;  		//스트링 값에 여러건을 넘기기의한 값(재직)
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;	
    
    /** set 현_호봉발령일자 : currPyspAppmtDt */
    private java.lang.String currPyspAppmtDt;

    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;
    
    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumNm;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmNm;
    
    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;  

    
    /** set usrId : usrId */
    private java.lang.String usrId;   
    
    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;
    
    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** 금액(환급차액) - iTem14 */
    private java.lang.String item14;
    
    // 희주 수정
    
    /** 지급년 PAY_YR */
    private java.lang.String payYr;
    
    /** 지급년월 PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth01;
    
    /** 지급년월 PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth02;
    
    
    /** SEC_REGN_NUM */
    private java.lang.String secRegnNum;
      
      
    /** 일련번호 PAYR_SEIL_NUM */
    private BigDecimal payrSeilNum;
    
    /** 지급일자 PAY_PYMT_DT */
    private java.lang.String payPymtDt;
      

    /** set 호봉제구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;
    
    // 끝
    
     
    
    private List<String> businCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    
	/** set 소득자성명 : fnm */
	private java.lang.String fnm;
	
	/** set 단위사업장코드 : utDpobCd */
	private java.lang.String utDpobCd;
	
	
	
	/**
	 * Comment : 
	 * @fn java.lang.String getItem14()
	 * @brief date:2018 2018. 2. 22. user:atres
	 * @return the item14 get
	 */
	public java.lang.String getItem14() {
		return item14;
	}


	/**
	 * Comment : 
	 *@fn void setItem14(java.lang.String item14)
	 *@brief date:2018 2018. 2. 22. user:atres
	 *@param item14 the item14 to set
	 */
	public void setItem14(java.lang.String item14) {
		this.item14 = item14;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getBusoprRgstnum()
	 * @brief date:2018 2018. 2. 12. user:atres
	 * @return the busoprRgstnum get
	 */
	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}


	/**
	 * Comment : 
	 *@fn void setBusoprRgstnum(java.lang.String busoprRgstnum)
	 *@brief date:2018 2018. 2. 12. user:atres
	 *@param busoprRgstnum the busoprRgstnum to set
	 */
	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

 
	/**
	 * Comment : 
	 * @fn List<String> getBusinCdArr()
	 * @brief date:2018 2018. 1. 17. user:atres
	 * @return the businCdArr get
	 */
	public List<String> getBusinCdArr() {
		return businCdArr;
	}


	/**
	 * Comment : 
	 *@fn void setBusinCdArr(List<String> businCdArr)
	 *@brief date:2018 2018. 1. 17. user:atres
	 *@param businCdArr the businCdArr to set
	 */
	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
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


	public java.lang.String getDpobCd() {
		return dpobCd;
	}


	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}


	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}


	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}


	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}


	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}


	public java.lang.String getSystemkey() {
		return systemkey;
	}


	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}


	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}


	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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


	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}


	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}


	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}


	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}


	public java.lang.String getBusinCd() {
		return businCd;
	}


	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}


	public java.lang.String getPernChrgEmpIdenNum() {
		return pernChrgEmpIdenNum;
	}


	public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
		this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
	}


	public java.lang.String getClosFlag() {
		return closFlag;
	}


	public void setClosFlag(java.lang.String closFlag) {
		this.closFlag = closFlag;
	}


	public java.math.BigDecimal getClosCont() {
		return closCont;
	}


	public void setClosCont(java.math.BigDecimal closCont) {
		this.closCont = closCont;
	}


	public java.lang.String getClosDate() {
		return closDate;
	}


	public void setClosDate(java.lang.String closDate) {
		this.closDate = closDate;
	}


	public java.lang.String getEdacPrdt() {
		return edacPrdt;
	}


	public void setEdacPrdt(java.lang.String edacPrdt) {
		this.edacPrdt = edacPrdt;
	}


	public java.lang.String getKybdr() {
		return kybdr;
	}


	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}


	public java.lang.String getInptDt() {
		return inptDt;
	}


	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}


	public java.lang.String getInptAddr() {
		return inptAddr;
	}


	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}


	public java.lang.String getIsmt() {
		return ismt;
	}


	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}


	public java.lang.String getRevnDt() {
		return revnDt;
	}


	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}


	public java.lang.String getRevnAddr() {
		return revnAddr;
	}


	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}


	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}


	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
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


	public List<String> getPyspGrdeCdArr() {
		return pyspGrdeCdArr;
	}


	public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
		this.pyspGrdeCdArr = pyspGrdeCdArr;
	}


	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}


	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}


	public List<String> getDtilOccuClsDivCdArr() {
		return dtilOccuClsDivCdArr;
	}


	public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
		this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
	}


	public List<String> getHdofcCodtnCdArr() {
		return hdofcCodtnCdArr;
	}


	public void setHdofcCodtnCdArr(List<String> hdofcCodtnCdArr) {
		this.hdofcCodtnCdArr = hdofcCodtnCdArr;
	}


	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}


	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}


	public java.lang.String getCurrPyspAppmtDt() {
		return currPyspAppmtDt;
	}


	public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
		this.currPyspAppmtDt = currPyspAppmtDt;
	}


	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}


	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
	}


	public java.lang.String getLogSvcYrNumNm() {
		return logSvcYrNumNm;
	}


	public void setLogSvcYrNumNm(java.lang.String logSvcYrNumNm) {
		this.logSvcYrNumNm = logSvcYrNumNm;
	}


	public java.lang.String getLogSvcMnthIcmNm() {
		return logSvcMnthIcmNm;
	}


	public void setLogSvcMnthIcmNm(java.lang.String logSvcMnthIcmNm) {
		this.logSvcMnthIcmNm = logSvcMnthIcmNm;
	}


	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}


	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
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


	public java.lang.String getUsrId() {
		return usrId;
	}


	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}


	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}


	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}


	public java.lang.String getEmymtBgnnDt() {
		return emymtBgnnDt;
	}


	public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
		this.emymtBgnnDt = emymtBgnnDt;
	}


	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}


	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}


	public java.lang.String getFnm() {
		return fnm;
	}


	public void setFnm(java.lang.String fnm) {
		this.fnm = fnm;
	}


	public java.lang.String getUtDpobCd() {
		return utDpobCd;
	}


	public void setUtDpobCd(java.lang.String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getUtDpobChk()
	 * @brief date:2018 2018. 1. 29. user:atres
	 * @return the utDpobChk get
	 */
	public java.lang.String getUtDpobChk() {
		return utDpobChk;
	}


	/**
	 * Comment : 
	 *@fn void setUtDpobChk(java.lang.String utDpobChk)
	 *@brief date:2018 2018. 1. 29. user:atres
	 *@param utDpobChk the utDpobChk to set
	 */
	public void setUtDpobChk(java.lang.String utDpobChk) {
		this.utDpobChk = utDpobChk;
	}


	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}


	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}


	// 희주 수정
	
	public java.lang.String getPayYr() {
		return payYr;
	}


	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}


	public java.lang.String getPymtYrMnth01() {
		return pymtYrMnth01;
	}


	public void setPymtYrMnth01(java.lang.String pymtYrMnth01) {
		this.pymtYrMnth01 = pymtYrMnth01;
	}


	public java.lang.String getPymtYrMnth02() {
		return pymtYrMnth02;
	}


	public void setPymtYrMnth02(java.lang.String pymtYrMnth02) {
		this.pymtYrMnth02 = pymtYrMnth02;
	}


	public java.lang.String getSecRegnNum() {
		return secRegnNum;
	}


	public void setSecRegnNum(java.lang.String secRegnNum) {
		this.secRegnNum = secRegnNum;
	}


	public BigDecimal getPayrSeilNum() {
		return payrSeilNum;
	}


	public void setPayrSeilNum(BigDecimal payrSeilNum) {
		this.payrSeilNum = payrSeilNum;
	}


	public java.lang.String getPayPymtDt() {
		return payPymtDt;
	}


	public void setPayPymtDt(java.lang.String payPymtDt) {
		this.payPymtDt = payPymtDt;
	}


	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}


	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}
    
    // 끝

}
