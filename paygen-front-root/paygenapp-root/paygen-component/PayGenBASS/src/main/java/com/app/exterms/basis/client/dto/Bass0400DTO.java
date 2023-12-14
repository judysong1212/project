package com.app.exterms.basis.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Bass0400VO.java
 * @Description : Bass0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0400DTO  extends BaseModel {
    
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
    
    
    private String deptCd;
    

/** set 부서생성일자 : deptCreDt */
private java.lang.String deptCreDt;

/** set 부서폐지일자 : deptEndDt */
private java.lang.String deptEndDt;

/** set 개편전부서코드 : befDeptCd */
private java.lang.String befDeptCd;

/** set 개편전부서코드02 : befDeptCd02 */
private java.lang.String befDeptCd02;


	public Bass0400DTO(String deptCd) { 
		System.out.println("400DTO의 값에 " + deptCd);
      	this.deptCd = deptCd;
      	} 
    
    
    public Bass0400DTO(){}
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get("dpobCd");}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
    /** get 부서코드 : deptCd */
    public String getDeptCd() { return (String)get("deptCd");}
    /** set 부서명_한글 : deptNmHan */
    public void setDeptNmHan(String deptNmHan) { set("deptNmHan",deptNmHan);}
    /** get 부서명_한글 : deptNmHan */
    public String getDeptNmHan() { return (String)get("deptNmHan");}
    /** set 부서명_단축 : deptNmRtchnt */
    public void setDeptNmRtchnt(String deptNmRtchnt) { set("deptNmRtchnt",deptNmRtchnt);}
    /** get 부서명_단축 : deptNmRtchnt */
    public String getDeptNmRtchnt() { return (String)get("deptNmRtchnt");}
    /** set 부서명_영문 : deptNmEng */
    public void setDeptNmEng(String deptNmEng) { set("deptNmEng",deptNmEng);}
    /** get 부서명_영문 : deptNmEng */
    public String getDeptNmEng() { return (String)get("deptNmEng");}
    /** set 최상위부서코드 : tplvlDeptCd */
    public void setTplvlDeptCd(String tplvlDeptCd) { set("tplvlDeptCd",tplvlDeptCd);}
    /** get 최상위부서코드 : tplvlDeptCd */
    public String getTplvlDeptCd() { return (String)get("tplvlDeptCd");}
    /** set 상위부서코드 : hhrkDeptCd */
    public void setHhrkDeptCd(String hhrkDeptCd) { set("hhrkDeptCd",hhrkDeptCd);}
    /** get 상위부서코드 : hhrkDeptCd */
    public String getHhrkDeptCd() { return (String)get("hhrkDeptCd");}
    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String payrMangDeptCd) { set("payrMangDeptCd",payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String getPayrMangDeptCd() { return (String)get("payrMangDeptCd");}
    /** set 부서사용여부 : deptUseYn */
    public void setDeptUseYn(String deptUseYn) { set("deptUseYn",deptUseYn);}
    /** get 부서사용여부 : deptUseYn */
    public String getDeptUseYn() { return (String)get("deptUseYn");}
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
    /** set 산재보험기호 : idtlAccdtInsurSym */
    public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) { set("idtlAccdtInsurSym",idtlAccdtInsurSym);}
    /** get 산재보험기호 : idtlAccdtInsurSym */
    public String getIdtlAccdtInsurSym() { return (String)get("idtlAccdtInsurSym");}
    /** set 부서비고내용 : deptNoteCtnt */
    public void setDeptNoteCtnt(String deptNoteCtnt) { set("deptNoteCtnt",deptNoteCtnt);}
    /** get 부서비고내용 : deptNoteCtnt */
    public String getDeptNoteCtnt() { return (String)get("deptNoteCtnt");}
    /** set 부서출력여부 : deptDspyYn */
    public void setDeptDspyYn(String deptDspyYn) { set("deptDspyYn",deptDspyYn);}
    /** get 부서출력여부 : deptDspyYn */
    public String getDeptDspyYn() { return (String)get("deptDspyYn");}
    /** set 관리부서코드 : mangeDeptCd */
    public void setMangeDeptCd(String mangeDeptCd) { set("mangeDeptCd",mangeDeptCd);}
    /** get 관리부서코드 : mangeDeptCd */
    public String getMangeDeptCd() { return (String)get("mangeDeptCd");}
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


	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCreDt()
	 * @brief date:2017 2017. 1. 22. user:atres-pc
	 * @return the deptCreDt get
	 */
	public java.lang.String getDeptCreDt() {
		return deptCreDt;
	}


	/**
	 * Comment : 
	 *@fn void setDeptCreDt(java.lang.String deptCreDt)
	 *@brief date:2017 2017. 1. 22. user:atres-pc
	 *@param deptCreDt the deptCreDt to set
	 */
	public void setDeptCreDt(java.lang.String deptCreDt) {
		this.deptCreDt = deptCreDt;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getDeptEndDt()
	 * @brief date:2017 2017. 1. 22. user:atres-pc
	 * @return the deptEndDt get
	 */
	public java.lang.String getDeptEndDt() {
		return deptEndDt;
	}


	/**
	 * Comment : 
	 *@fn void setDeptEndDt(java.lang.String deptEndDt)
	 *@brief date:2017 2017. 1. 22. user:atres-pc
	 *@param deptEndDt the deptEndDt to set
	 */
	public void setDeptEndDt(java.lang.String deptEndDt) {
		this.deptEndDt = deptEndDt;
	}
	
	/**
	 * Comment : 
	 * @fn java.lang.String getBefDeptCd()
	 * @brief date:2017 2017. 5. 17. user:kyumin.jang
	 * @return the befDeptCd get
	 */
	public java.lang.String getBefDeptCd() {
		return befDeptCd;
	}


	/**
	 * Comment : 
	 *@fn void setBefDeptCd(java.lang.String befDeptCd)
	 *@brief date:2017 2017. 1. 22. user:kyumin.jang
	 *@param befDeptCd the befDeptCd to set
	 */
	public void setBefDeptCd(java.lang.String befDeptCd) {
		this.befDeptCd = befDeptCd;
	}
	
	/**
	 * Comment : 
	 * @fn java.lang.String getBefDeptCd02()
	 * @brief date:2017 2017. 5. 17. user:kyumin.jang
	 * @return the befDeptCd02 get
	 */
	public java.lang.String getBefDeptCd02() {
		return befDeptCd02;
	}


	/**
	 * Comment : 
	 *@fn void setBefDeptCd(java.lang.String befDeptCd02)
	 *@brief date:2017 2017. 1. 22. user:kyumin.jang
	 *@param befDeptCd02 the befDeptCd02 to set
	 */
	public void setBefDeptCd02(java.lang.String befDeptCd02) {
		this.befDeptCd02 = befDeptCd02;
	}

}
