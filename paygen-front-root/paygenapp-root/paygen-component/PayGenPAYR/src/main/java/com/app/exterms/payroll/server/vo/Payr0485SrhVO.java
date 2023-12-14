package com.app.exterms.payroll.server.vo;

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
public class Payr0485SrhVO implements Serializable {

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

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;
    
    /** set 지급공제그룹구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;
    
    /** set 지급공제그룹구분코드 : pymtDducDivCd */
    private List<String> pymtDducDivCdArr; 
    
    
    public List<String> getPymtDducDivCdArr() {
		return pymtDducDivCdArr;
	}

	public void setPymtDducDivCdArr(List<String> pymtDducDivCdArr) {
		this.pymtDducDivCdArr = pymtDducDivCdArr;
	}

	/** set 지급공제구분코드 : payDducGrpCd */
    private java.lang.String payDducGrpCd;
    
    /** set 지급공제구분코드 : payDducGrpNm */
    private java.lang.String payDducGrpNm;
    
    /** set 수당그룹구분코드 : payExtpyGrpCd */
    private java.lang.String dtilPayExtpyGrpCd;
    
    /** set 수당그룹구분코드 : payExtpyGrpCd _ 엑셀사용*/
    private java.lang.String payExtpyGrpCd;
    
    /** set 수당그룹구분코드 : payExtpyGrpNm */
    private java.lang.String payExtpyGrpNm;
    
    /** set 수당그룹구분코드 : dtilPayExtpyGrpCdArr */
    private List<String> dtilPayExtpyGrpCdArr;	
    
    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;
    
    /** set 급여항목 : payExtpyNm */
    private java.lang.String payExtpyNm;

    /** set 회계계정코드 : accAccCd */
    private java.lang.String accAccCd;
    
    /** set 회계계정 : accAccNm */
    private java.lang.String accAccNm;

    /** set 퇴직적용여부 : sevePayYn */
    private java.lang.String sevePayYn;

    /** set 연말정산_기부금코드 : yrtxDotnCd */
    private java.lang.String yrtxDotnCd;
    
    /** set 연말정산_기부금명 : yrtxDotnNm */
    private java.lang.String yrtxDotnNm;

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    private java.lang.String yrtxFreeDtyReduCd;
    
    /** set 연말정산_비과세감면 : yrtxFreeDtyReduNm */
    private java.lang.String yrtxFreeDtyReduNm;

    /** set 기간제수당사용여부 : payrTermUseYn */
    private java.lang.String payrTermUseYn;

    /** set 수당공제출력여부 : extptDducDspyYn */
    private java.lang.String extptDducDspyYn;

    /** set 수당공제사용여부 : extptDducUseYn */
    private java.lang.String extptDducUseYn;

    /** set 수당공제정렬순서 : extptDducRngeOrd */
    private java.math.BigDecimal extptDducRngeOrd;

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

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}
	
	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}
	
	public java.lang.String getPayDducGrpCd() {
		return payDducGrpCd;
	}

	public void setPayDducGrpCd(java.lang.String payDducGrpCd) {
		this.payDducGrpCd = payDducGrpCd;
	}

	public java.lang.String getPayDducGrpNm() {
		return payDducGrpNm;
	}

	public void setPayDducGrpNm(java.lang.String payDducGrpNm) {
		this.payDducGrpNm = payDducGrpNm;
	}

	public java.lang.String getPayExtpyGrpNm() {
		return payExtpyGrpNm;
	}

	public void setPayExtpyGrpNm(java.lang.String payExtpyGrpNm) {
		this.payExtpyGrpNm = payExtpyGrpNm;
	}

	public java.lang.String getDtilPayExtpyGrpCd() {
		return dtilPayExtpyGrpCd;
	}

	public void setDtilPayExtpyGrpCd(java.lang.String dtilPayExtpyGrpCd) {
		this.dtilPayExtpyGrpCd = dtilPayExtpyGrpCd;
	}
	
	public java.lang.String getPayExtpyGrpCd() {
		return payExtpyGrpCd;
	}

	public void setPayExtpyGrpCd(java.lang.String payExtpyGrpCd) {
		this.payExtpyGrpCd = payExtpyGrpCd;
	}

	public List<String> getDtilPayExtpyGrpCdArr() {
		return dtilPayExtpyGrpCdArr;
	}

	public void setDtilPayExtpyGrpCdArr(List<String> dtilPayExtpyGrpCdArr) {
		this.dtilPayExtpyGrpCdArr = dtilPayExtpyGrpCdArr;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}
	
	public java.lang.String getPayExtpyNm() {
		return payExtpyNm;
	}

	public void setPayExtpyNm(java.lang.String payExtpyNm) {
		this.payExtpyNm = payExtpyNm;
	}

	public java.lang.String getAccAccCd() {
		return accAccCd;
	}

	public void setAccAccCd(java.lang.String accAccCd) {
		this.accAccCd = accAccCd;
	}
	
	public java.lang.String getAccAccNm() {
		return accAccNm;
	}

	public void setAccAccNm(java.lang.String accAccNm) {
		this.accAccNm = accAccNm;
	}

	public java.lang.String getSevePayYn() {
		return sevePayYn;
	}

	public void setSevePayYn(java.lang.String sevePayYn) {
		this.sevePayYn = sevePayYn;
	}

	public java.lang.String getYrtxDotnCd() {
		return yrtxDotnCd;
	}

	public void setYrtxDotnCd(java.lang.String yrtxDotnCd) {
		this.yrtxDotnCd = yrtxDotnCd;
	}
	
	public java.lang.String getYrtxDotnNm() {
		return yrtxDotnNm;
	}

	public void setYrtxDotnNm(java.lang.String yrtxDotnNm) {
		this.yrtxDotnNm = yrtxDotnNm;
	}

	public java.lang.String getYrtxFreeDtyReduCd() {
		return yrtxFreeDtyReduCd;
	}

	public void setYrtxFreeDtyReduCd(java.lang.String yrtxFreeDtyReduCd) {
		this.yrtxFreeDtyReduCd = yrtxFreeDtyReduCd;
	}
	
	public java.lang.String getYrtxFreeDtyReduNm() {
		return yrtxFreeDtyReduNm;
	}

	public void setYrtxFreeDtyReduNm(java.lang.String yrtxFreeDtyReduNm) {
		this.yrtxFreeDtyReduNm = yrtxFreeDtyReduNm;
	}

	public java.lang.String getPayrTermUseYn() {
		return payrTermUseYn;
	}

	public void setPayrTermUseYn(java.lang.String payrTermUseYn) {
		this.payrTermUseYn = payrTermUseYn;
	}

	public java.lang.String getExtptDducDspyYn() {
		return extptDducDspyYn;
	}

	public void setExtptDducDspyYn(java.lang.String extptDducDspyYn) {
		this.extptDducDspyYn = extptDducDspyYn;
	}

	public java.lang.String getExtptDducUseYn() {
		return extptDducUseYn;
	}

	public void setExtptDducUseYn(java.lang.String extptDducUseYn) {
		this.extptDducUseYn = extptDducUseYn;
	}

	public java.math.BigDecimal getExtptDducRngeOrd() {
		return extptDducRngeOrd;
	}

	public void setExtptDducRngeOrd(java.math.BigDecimal extptDducRngeOrd) {
		this.extptDducRngeOrd = extptDducRngeOrd;
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
    
    

}