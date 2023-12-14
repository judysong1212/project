package com.app.smrmf.infc.yearendtax.server.vo.yeta2019;

import java.io.Serializable;
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
public class InfcPkgPyyt0302Srh_2019_VO extends InfcPkgPyyt0302_2019_VO implements Serializable {

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
    
    /** set 급여항목코드 : pyytItemCd */
    private java.lang.String pyytItemCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pyytYrMnth */
    private java.lang.String pyytYrMnth;

    /** set 지급공제구분코드 : pyytPymtDducCd */
    private java.lang.String pyytPymtDducCd;

    /** set 지급공제금액 : pyytPymtDducSum */
    private java.math.BigDecimal pyytPymtDducSum;

    /** set 지급공제과세금액 : pyytPyddTxtnAmnt */
    private java.math.BigDecimal pyytPyddTxtnAmnt;

    /** set 지급공제비과세금액 : pyytPyddFreeDtySum */
    private java.math.BigDecimal pyytPyddFreeDtySum;

    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    private java.lang.String pyytYrtxDotnCd;

    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    private java.lang.String pyytYtfeDtyReduCd;

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
    
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
 
    
    /** 성명 HAN_NM */
    private java.lang.String hanNm;
    
    /** 주민번호 RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    
    /** 사업코드 BUSIN_CD  */
    private java.lang.String businCd;
    
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
    

	/** DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    

    /** 사업코드 BUSIN_CD  */
    private List<String> businCdArr;


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


	public java.lang.String getPyytItemCd() {
		return pyytItemCd;
	}


	public void setPyytItemCd(java.lang.String pyytItemCd) {
		this.pyytItemCd = pyytItemCd;
	}


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


	public java.lang.String getPyytYrMnth() {
		return pyytYrMnth;
	}


	public void setPyytYrMnth(java.lang.String pyytYrMnth) {
		this.pyytYrMnth = pyytYrMnth;
	}


	public java.lang.String getPyytPymtDducCd() {
		return pyytPymtDducCd;
	}


	public void setPyytPymtDducCd(java.lang.String pyytPymtDducCd) {
		this.pyytPymtDducCd = pyytPymtDducCd;
	}


	public java.math.BigDecimal getPyytPymtDducSum() {
		return pyytPymtDducSum;
	}


	public void setPyytPymtDducSum(java.math.BigDecimal pyytPymtDducSum) {
		this.pyytPymtDducSum = pyytPymtDducSum;
	}


	public java.math.BigDecimal getPyytPyddTxtnAmnt() {
		return pyytPyddTxtnAmnt;
	}


	public void setPyytPyddTxtnAmnt(java.math.BigDecimal pyytPyddTxtnAmnt) {
		this.pyytPyddTxtnAmnt = pyytPyddTxtnAmnt;
	}


	public java.math.BigDecimal getPyytPyddFreeDtySum() {
		return pyytPyddFreeDtySum;
	}


	public void setPyytPyddFreeDtySum(java.math.BigDecimal pyytPyddFreeDtySum) {
		this.pyytPyddFreeDtySum = pyytPyddFreeDtySum;
	}


	public java.lang.String getPyytYrtxDotnCd() {
		return pyytYrtxDotnCd;
	}


	public void setPyytYrtxDotnCd(java.lang.String pyytYrtxDotnCd) {
		this.pyytYrtxDotnCd = pyytYrtxDotnCd;
	}


	public java.lang.String getPyytYtfeDtyReduCd() {
		return pyytYtfeDtyReduCd;
	}


	public void setPyytYtfeDtyReduCd(java.lang.String pyytYtfeDtyReduCd) {
		this.pyytYtfeDtyReduCd = pyytYtfeDtyReduCd;
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


	public java.lang.String getBusinCd() {
		return businCd;
	}


	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
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


	public List<String> getBusinCdArr() {
		return businCdArr;
	}


	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
	} 
    
    

}
