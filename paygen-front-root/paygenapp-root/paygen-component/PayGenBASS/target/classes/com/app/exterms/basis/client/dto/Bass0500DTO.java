package com.app.exterms.basis.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Bass0500VO.java
 * @Description : Bass0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0500DTO  extends BaseModel {
    private static final long serialVersionUID = 1L;
    
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
    
    
    
    /** set 사업이전년도 : businApptnYr */
    public void setBusinBfrApptnYr(String businBfrApptnYr) { set("businBfrApptnYr",businBfrApptnYr);}
    /** get 사업이전년도 : businApptnYr */
    public String getBusinBfrApptnYr() { return (String)get("businBfrApptnYr");}
    
    
    /** set 사업생성년도 : businApptnYr */
    public void setBusinCreApptnYr(String businCreApptnYr) { set("businCreApptnYr",businCreApptnYr);}
    /** get 사업생성년도 : businApptnYr */
    public String getBusinCreApptnYr() { return (String)get("businCreApptnYr");}
    
    
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get("dpobCd");}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
    /** get 부서코드 : deptCd */
    public String getDeptCd() { return (String)get("deptCd");}
    
    /** set 부서코드 : brfDeptCd */
    public void setBrfDeptCd(String brfDeptCd) { set("brfDeptCd",brfDeptCd);}
    /** get 부서코드 : brfDeptCd */
    public String getBrfDeptCd() { return (String)get("brfDeptCd");}
    
    /** set 부서코드 : creDeptCd */
    public void setCreDeptCd(String creDeptCd) { set("creDeptCd",creDeptCd);}
    /** get 부서코드 : creDeptCd */
    public String getCreDeptCd() { return (String)get("creDeptCd");}
    
    
    
    /** set 사업적용년도 : businApptnYr */
    public void setBusinApptnYr(String businApptnYr) { set("businApptnYr",businApptnYr);}
    /** get 사업적용년도 : businApptnYr */
    public String getBusinApptnYr() { return (String)get("businApptnYr");}
    /** set 사업코드 : businCd */
    public void setBusinCd(String businCd) { set("businCd",businCd);}
    /** get 사업코드 : businCd */
    public String getBusinCd() { return (String)get("businCd");}
    /** set 사업명 : businNm */
    public void setBusinNm(String businNm) { set("businNm",businNm);}
    /** get 사업명 : businNm */
    public String getBusinNm() { return (String)get("businNm");}
    /** set 사업고용직종코드 : businEmymtTypOccuCd */
    public void setBusinEmymtTypOccuCd(String businEmymtTypOccuCd) { set("businEmymtTypOccuCd",businEmymtTypOccuCd);}
    /** get 사업고용직종코드 : businEmymtTypOccuCd */
    public String getBusinEmymtTypOccuCd() { return (String)get("businEmymtTypOccuCd");}
    /** set 사업담당직원번호 : businRepbtyEmpNum */
    public void setBusinRepbtyEmpNum(String businRepbtyEmpNum) { set("businRepbtyEmpNum",businRepbtyEmpNum);}
    /** get 사업담당직원번호 : businRepbtyEmpNum */
    public String getBusinRepbtyEmpNum() { return (String)get("businRepbtyEmpNum");}
    /** set 산재보험요율 : idtlAccdtInsurApmrt */
    public void setIdtlAccdtInsurApmrt(String idtlAccdtInsurApmrt) { set("idtlAccdtInsurApmrt",idtlAccdtInsurApmrt);}
    /** get 산재보험요율 : idtlAccdtInsurApmrt */
    public String getIdtlAccdtInsurApmrt() { return (String)get("idtlAccdtInsurApmrt");}
    /** set 특기사항내용 : spityCtnt */
    public void setSpityCtnt(String spityCtnt) { set("spityCtnt",spityCtnt);}
    /** get 특기사항내용 : spityCtnt */
    public String getSpityCtnt() { return (String)get("spityCtnt");}
    /** set 국민연금기호 : natPennSym */
    public void setNatPennSym(String natPennSym) { set("natPennSym",natPennSym);}
    /** get 국민연금기호 : natPennSym */
    public String getNatPennSym() { return (String)get("natPennSym");}
    /** set 건강보험기호 : hlthInsrSym */
    public void setHlthInsrSym(String hlthInsrSym) { set("hlthInsrSym",hlthInsrSym);}
    /** get 건강보험기호 : hlthInsrSym */
    public String getHlthInsrSym() { return (String)get("hlthInsrSym");}
    /** set 고용보험기호 : umytInsrSym */
    public void setUmytInsrSym(String umytInsrSym) { set("umytInsrSym",umytInsrSym);}
    /** get 고용보험기호 : umytInsrSym */
    public String getUmytInsrSym() { return (String)get("umytInsrSym");}
    /** set 건강보험영업소기호 : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String hlthInsrOfceSym) { set("hlthInsrOfceSym",hlthInsrOfceSym);}
	/** get 건강보험영업소기호 : hlthInsrOfceSym */
	public String getHlthInsrOfceSym() { return (String)get("hlthInsrOfceSym");}
    /** set 산재보험기호 : idtlAccdtInsurSym */
    public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) { set("idtlAccdtInsurSym",idtlAccdtInsurSym);}
    /** get 산재보험기호 : idtlAccdtInsurSym */
    public String getIdtlAccdtInsurSym() { return (String)get("idtlAccdtInsurSym");}
    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set("kybdr",kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get("kybdr");}
    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set("inptDt",inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get("inptDt");}
    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get("inptAddr");}
    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set("ismt",ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get("ismt");}
    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get("revnDt");}
    /** set 수정자주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
    /** get 수정자주소 : revnAddr */
    public String getRevnAddr() { return (String)get("revnAddr");}
    
    /** set 근무일수 : businDutyNumDys */
    public void setBusinDutyNumDys(String businDutyNumDys) { set("businDutyNumDys",businDutyNumDys);}
    /** get 근무일수 : businDutyNumDys */
    public String getBusinDutyNumDys() { return (String)get("businDutyNumDys");}
    
    //개발_시간외근무 최대 인정시간_20201026
   //** set 근무인정시간 */
    public void setDilnlazTmRstDutyTm(String dilnlazTmRstDutyTm) { set("dilnlazTmRstDutyTm",dilnlazTmRstDutyTm);}
    //** get 근무인정시간 *//
    public String getDilnlazTmRstDutyTm() { return (String)get("dilnlazTmRstDutyTm");}
    
    
    
    public void setBusinStdt(String businStdt) { set("businStdt",businStdt);}
    public String getBusinStdt() { return (String)get("businStdt");}
    
    public void setBusinEddt(String businEddt) { set("businEddt",businEddt);}
    public String getBusinEddt() { return (String)get("businEddt");}
    
    
    
    
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @return the pageUnit
	 */
	public int getPageUnit() {
		return pageUnit;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}
	/**
	 * @return the lastIndex
	 */
	public int getLastIndex() {
		return lastIndex;
	}
	/**
	 * @return the recordCountPerPage
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @param pageUnit the pageUnit to set
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	/**
	 * @param lastIndex the lastIndex to set
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	/**
	 * @param recordCountPerPage the recordCountPerPage to set
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}
    
}
