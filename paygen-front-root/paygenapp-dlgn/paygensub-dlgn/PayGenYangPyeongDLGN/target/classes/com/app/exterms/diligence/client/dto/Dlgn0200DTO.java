package com.app.exterms.diligence.client.dto;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Dlgn0200DTO   extends BaseModel{    //implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	

	
	/** set 개인/일괄 구분  : createFlag */
	public void setCreateFlag(String createFlag) { set("createFlag",createFlag);}
	/** get 개인/일괄 구분 : createFlag */
	public String getCreateFlag() { return (String)get("createFlag");}
	
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String)get("dpobCd");}
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String getSystemkey() { return (String)get("systemkey");}
	/** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
	public void setDilnlazExceDutyYrMnth(String dilnlazExceDutyYrMnth) { set("dilnlazExceDutyYrMnth",dilnlazExceDutyYrMnth);}
	/** get 근태초과근무년월 : dilnlazExceDutyYrMnth */
	public String getDilnlazExceDutyYrMnth() { return (String)get("dilnlazExceDutyYrMnth");}
	/** set 급여구분코드 : payCd */
	public void setPayCd(String payCd) { set("payCd",payCd);}
	/** get 급여구분코드 : payCd */
	public String getPayCd() { return (String)get("payCd");}
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String emymtDivCd) { set("emymtDivCd",emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String getEmymtDivCd() { return (String)get("emymtDivCd");}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
	/** get 부서코드 : deptCd */
	public String getDeptCd() { return (String)get("deptCd");}
	/** set 사업코드 : businCd */
	public void setBusinCd(String businCd) { set("businCd",businCd);}
	/** get 사업코드 : businCd */
	public String getBusinCd() { return (String)get("businCd");}
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String typOccuCd) { set("typOccuCd",typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String getTypOccuCd() { return (String)get("typOccuCd");}
	/** set 직종명 : typOccuCd */
	public void setTypOccuNm(String typOccuNm) { set("typOccuNm",typOccuNm);}
	/** get 직종명 : typOccuCd */
	public String getTypOccuNm() { return (String)get("typOccuNm");}
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) { set("dtilOccuClsDivCd",dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String getDtilOccuClsDivCd() { return (String)get("dtilOccuClsDivCd");}
	/** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
	public void setDilnlazExceDutyBgnnDt(String dilnlazExceDutyBgnnDt) { set("dilnlazExceDutyBgnnDt",dilnlazExceDutyBgnnDt);}
	/** get 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
	public String getDilnlazExceDutyBgnnDt() { return (String)get("dilnlazExceDutyBgnnDt");}
	/** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
	public void setDilnlazExceDutyEndDt(String dilnlazExceDutyEndDt) { set("dilnlazExceDutyEndDt",dilnlazExceDutyEndDt);}
	/** get 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
	public String getDilnlazExceDutyEndDt() { return (String)get("dilnlazExceDutyEndDt");}
	/** set 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
	public void setDilnlazPubcHodyDutyNumDys(String dilnlazPubcHodyDutyNumDys) { set("dilnlazPubcHodyDutyNumDys",dilnlazPubcHodyDutyNumDys);}
	/** get 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
	public String getDilnlazPubcHodyDutyNumDys() { return (String)get("dilnlazPubcHodyDutyNumDys");}
	
	/** set 근태_휴일총근무일수 : dilnlazPubcHodyDutyTm */
	public void setDilnlazPubcHodyDutyTm(String dilnlazPubcHodyDutyTm) { set("dilnlazPubcHodyDutyTm",dilnlazPubcHodyDutyTm);}
	/** get 근태_휴일총근무일수 : dilnlazPubcHodyDutyTm */
	public String getDilnlazPubcHodyDutyTm() { return (String)get("dilnlazPubcHodyDutyTm");}
	
	/** set 근태_토요근무일수 : dilnlazSatDutyNumDys */
	public void setDilnlazSatDutyNumDys(String dilnlazSatDutyNumDys) { set("dilnlazSatDutyNumDys",dilnlazSatDutyNumDys);}
	/** get 근태_토요근무일수 : dilnlazSatDutyNumDys */
	public String getDilnlazSatDutyNumDys() { return (String)get("dilnlazSatDutyNumDys");}
	/** set 근태_총야근일수 : dilnlazTotNtotNumDys */
	public void setDilnlazTotNtotNumDys(String dilnlazTotNtotNumDys) { set("dilnlazTotNtotNumDys",dilnlazTotNtotNumDys);}
	/** get 근태_총야근일수 : dilnlazTotNtotNumDys */
	public String getDilnlazTotNtotNumDys() { return (String)get("dilnlazTotNtotNumDys");}
	/** set 근태_총야근시간 : dilnlazTotNtotTm */
	public void setDilnlazTotNtotTm(String dilnlazTotNtotTm) { set("dilnlazTotNtotTm",dilnlazTotNtotTm);}
	/** get 근태_총야근시간 : dilnlazTotNtotTm */
	public String getDilnlazTotNtotTm() { return (String)get("dilnlazTotNtotTm");}
	/** set 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
	public void setDilnlazFndtnTmRstDutyTm(String dilnlazFndtnTmRstDutyTm) { set("dilnlazFndtnTmRstDutyTm",dilnlazFndtnTmRstDutyTm);}
	/** get 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
	public String getDilnlazFndtnTmRstDutyTm() { return (String)get("dilnlazFndtnTmRstDutyTm");}
	/** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
	public void setDilnlazTmRstDutyTm(String dilnlazTmRstDutyTm) { set("dilnlazTmRstDutyTm",dilnlazTmRstDutyTm);}
	/** get 근태_시간외근무시간 : dilnlazTmRstDutyTm */
	public String getDilnlazTmRstDutyTm() { return (String)get("dilnlazTmRstDutyTm");}
	 
	
	/** set 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
	public void setDilnlazTotTmRstDutyTm(String dilnlazTotTmRstDutyTm) { set("dilnlazTotTmRstDutyTm",dilnlazTotTmRstDutyTm);}
	/** get 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
	public String getDilnlazTotTmRstDutyTm() { return (String)get("dilnlazTotTmRstDutyTm");}
	/** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
	public void setDilnlazDdlnePrcsYn(String dilnlazDdlnePrcsYn) { set("dilnlazDdlnePrcsYn",dilnlazDdlnePrcsYn);}
	/** get 근태_마감처리여부 : dilnlazDdlnePrcsYn */
	public String getDilnlazDdlnePrcsYn() { return (String)get("dilnlazDdlnePrcsYn");}
	/** set 근태_비고내용 : dilnlazNoteCtnt */
	public void setDilnlazNoteCtnt(String dilnlazNoteCtnt) { set("dilnlazNoteCtnt",dilnlazNoteCtnt);}
	/** get 근태_비고내용 : dilnlazNoteCtnt */
	public String getDilnlazNoteCtnt() { return (String)get("dilnlazNoteCtnt");}
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
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String)get("revnAddr");}
	

	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String dtilOccuInttnCd) { set("dtilOccuInttnCd",dtilOccuInttnCd);}
	/** get 직종세통코드 : dtilOccuInttnCd */
	public String getDtilOccuInttnCd() { return (String)get("dtilOccuInttnCd");}
	
	/** set 직종세통합코드명 : dtilOccuInttnCd */
	public void setDtilOccuInttnNm(String dtilOccuInttnNm) { set("dtilOccuInttnNm",dtilOccuInttnNm);}
	/** get 직종세통합코드명 : dtilOccuInttnCd */
	public String getDtilOccuInttnNm() { return (String)get("dtilOccuInttnNm");}
	
	/** set 근태_적용일자 : dilnlazApptnDt */
	public void setDilnlazApptnDt(String dilnlazApptnDt) { set("dilnlazApptnDt",dilnlazApptnDt);}
	/** get 근태_적용일자 : dilnlazApptnDt */
	public String getDilnlazApptnDt() { return (String)get("dilnlazApptnDt");}
	/** set 근태_초과근무여부 : dilnlazDutyYn */
	public void setDilnlazDutyYn(String dilnlazDutyYn) { set("dilnlazDutyYn",dilnlazDutyYn);}
	/** get 근태_초과근무여부 : dilnlazDutyYn */
	public String getDilnlazDutyYn() { return (String)get("dilnlazDutyYn");}
	/** set 근태_초과근무시간 : dilnlazDutyTm */
	public void setDilnlazDutyTm(String dilnlazDutyTm) { set("dilnlazDutyTm",dilnlazDutyTm);}
	/** get 근태_초과근무시간 : dilnlazDutyTm */
	public String getDilnlazDutyTm() { return (String)get("dilnlazDutyTm");}
	/** set 근태_야근여부 : dilnlazNtotYn */
	public void setDilnlazNtotYn(String dilnlazNtotYn) { set("dilnlazNtotYn",dilnlazNtotYn);}
	/** get 근태_야근여부 : dilnlazNtotYn */
	public String getDilnlazNtotYn() { return (String)get("dilnlazNtotYn");}
	/** set 근태_야근시간 : dilnlazNtotTm */
	public void setDilnlazNtotTm(String dilnlazNtotTm) { set("dilnlazNtotTm",dilnlazNtotTm);}
	/** get 근태_야근시간 : dilnlazNtotTm */
	public String getDilnlazNtotTm() { return (String)get("dilnlazNtotTm");}
	/** set 근태_시간외근무여부 : dilnlazTmRstDutyYn */
	public void setDilnlazTmRstDutyYn(String dilnlazTmRstDutyYn) { set("dilnlazTmRstDutyYn",dilnlazTmRstDutyYn);}
	/** get 근태_시간외근무여부 : dilnlazTmRstDutyYn */
	public String getDilnlazTmRstDutyYn() { return (String)get("dilnlazTmRstDutyYn");}
	
	/** set 근태_휴일근무여부 : dilnlazHodyDutyYn */
	public void setDilnlazHodyDutyYn(String dilnlazHodyDutyYn) { set("dilnlazHodyDutyYn",dilnlazHodyDutyYn);}
	/** get 근태_휴일근무여부 : dilnlazHodyDutyYn */
	public String getDilnlazHodyDutyYn() { return (String)get("dilnlazHodyDutyYn");}
	
	/** set 근태_휴일근무시간 : dilnlazHodyDutyTm */
	public void setDilnlazHodyDutyTm(String dilnlazHodyDutyTm) { set("dilnlazHodyDutyTm",dilnlazHodyDutyTm);}
	/** get 근태_휴일근무시간 : dilnlazHodyDutyTm */
	public String getDilnlazHodyDutyTm() { return (String)get("dilnlazHodyDutyTm");}
	 
	 
	//////체크 박스용 시작
	
	/** set 근태_초과근무여부 : dilnlazDutyYnboolean */
	public void setDilnlazDutyYnboolean(boolean dilnlazDutyYnboolean) { set("dilnlazDutyYnboolean",dilnlazDutyYnboolean);}
	/** get 근태_초과근무여부 : dilnlazDutyYnboolean */
	public boolean getDilnlazDutyYnboolean() { return (Boolean)get("dilnlazDutyYnboolean");}
	/** set 근태_야근여부 : dilnlazNtotYnboolean */
	public void setDilnlazNtotYnboolean(boolean dilnlazNtotYnboolean) { set("dilnlazNtotYnboolean",dilnlazNtotYnboolean);}
	/** get 근태_야근여부 : dilnlazNtotYnboolean */
	public boolean getDilnlazNtotYnboolean() { return (Boolean)get("dilnlazNtotYnboolean");}
	/** set 근태_휴일근무여부 : dilnlazHodyDutyYnBoolean */
	public void setDilnlazHodyDutyYnBoolean(boolean dilnlazHodyDutyYnBoolean) { set("dilnlazHodyDutyYnBoolean",dilnlazHodyDutyYnBoolean);}
	/** get 근태_휴일근무여부 : dilnlazHodyDutyYnBoolean */
	public boolean getDilnlazHodyDutyYnBoolean() { return (Boolean)get("dilnlazHodyDutyYnBoolean");}
	//////체크 박스용 끝
	
	/** set  : offdayKubn */
	public void setOffdayKubn(String offdayKubn) { set("offdayKubn",offdayKubn);}
	/** get  : offdayKubn */
	public String getOffdayKubn() { return (String)get("offdayKubn");}
	
	/** set 고용시작일자 : emymtBgnnDt */
	public void setEmymtBgnnDt(String emymtBgnnDt) { set("emymtBgnnDt",emymtBgnnDt);}
	/** get 고용시작일자 : emymtBgnnDt */
	public String getEmymtBgnnDt() { return (String)get("emymtBgnnDt");}
	/** set 고용종료일자 : emymtEndDt */
	public void setEmymtEndDt(String emymtEndDt) { set("emymtEndDt",emymtEndDt);}
	/** get 고용종료일자 : emymtEndDt */
	public String getEmymtEndDt() { return (String)get("emymtEndDt");}
	
	/** set 재직상태코드 : hdofcCodtnCd */
	public void setHdofcCodtnCd(String hdofcCodtnCd) { set("hdofcCodtnCd",hdofcCodtnCd);}
	/** get 재직상태코드 : hdofcCodtnCd */
	public String getHdofcCodtnCd() { return (String)get("hdofcCodtnCd");}
	/** set 한글성명 : hanNm */
	public void setHanNm(String hanNm) { set("hanNm",hanNm);}
	/** get 한글성명 : hanNm */
	public String getHanNm() { return (String)get("hanNm");}
	/** set 영문성명 : engNm */
	public void setEngNm(String engNm) { set("engNm",engNm);}
	/** get 영문성명 : engNm */
	public String getEngNm() { return (String)get("engNm");}
	/** set 한문성명 : chinCharNm */
	public void setChinCharNm(String chinCharNm) { set("chinCharNm",chinCharNm);}
	/** get 한문성명 : chinCharNm */
	public String getChinCharNm() { return (String)get("chinCharNm");}
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	

	/** set 원본 주민등록번호 : secRegnNum */
	public void setSecRegnNum(String secRegnNum) { set("secRegnNum",secRegnNum);}
	/** get 원본 주민등록번호 : secRegnNum */
	public String getSecRegnNum() { return (String)get("secRegnNum");}
	 
	
	
	/** set 현소속부서코드 : currAffnDeptCd */
	public void setCurrAffnDeptCd(String currAffnDeptCd) { set("currAffnDeptCd",currAffnDeptCd);}
	/** get 현소속부서코드 : currAffnDeptCd */
	public String getCurrAffnDeptCd() { return (String)get("currAffnDeptCd");}
	
	/** set 사업코드 : businCdNm */
	public void setBusinCdNm(String businCdNm) { set("businCdNm",businCdNm);}
	/** get 사업코드 : businCdNm */
	public String getBusinCdNm() { return (String)get("businCdNm");}
	
	/** set 부서코드 : deptCdNm */
	public void setDeptCdNm(String deptCdNm) { set("deptCdNm",deptCdNm);}
	/** get 부서코드 : deptCdNm */
	public String getDeptCdNm() { return (String)get("deptCdNm");}
	
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( "pyspGrdeCd" ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( "pyspGrdeCd" );}
	
	/** set 관리부서코드 : mangeDeptCd */
	public void setMangeDeptCd(String mangeDeptCd) { set("mangeDeptCd",mangeDeptCd);}
	/** get 관리부서코드 : payrMangDeptCd */
	public String getMangeDeptCd() { return (String)get("mangeDeptCd");}
	
	/** set 복무통합구분값 : typOccuBusinVal */
	public void setTypOccuBusinVal(String typOccuBusinVal) { set("typOccuBusinVal",typOccuBusinVal);}
	/** get 복무통합구분값 : typOccuBusinVal */
	public String getTypOccuBusinVal() { return (String)get("typOccuBusinVal");}


	 	
	
	private java.lang.String usrId; /** set 사용자아이디 : usrId */

	private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
	
	 private List<String> typOccuCdArr; /** 직종 - typOccuCdArr */
	    
	    
	  private List<String> dtilOccuInttnCdArr; /** 직종 - dtilOccuInttnCdArr */
	     
	    
	    
	private List<String> deptCdArr; /** 부서코드 - DEPT_CD */
	private java.lang.String repbtyBusinDivCd; /** set 호봉제구분코드 : REPBTY_BUSIN_DIV_CD */
	/** set 부서코드 : payrMangDeptCd */
	public void setPayrMangDeptCd(String payrMangDeptCd) { set("payrMangDeptCd",payrMangDeptCd);}
	/** get 부서코드 : payrMangDeptCd */
	public String getPayrMangDeptCd() { return (String)get("payrMangDeptCd");}
	
	private java.lang.String deptCdAuth; /** 부서코드 - DEPT_CD */
	
	private java.lang.String dtilOccuInttnCdAuth;  /** 직종세통합코드 dtilOccuInttnCd */  

	public List<String> getDeptCdArr() {
		return deptCdArr;
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
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
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
	/**
	 * Comment : 호봉제구분코드 
	 * @fn java.lang.String getRepbtyBusinDivCd()
	 * @brief date:2016 2016. 5. 18. user:Administrator
	 * @return the repbtyBusinDivCd get
	 */
	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}
	/**
	 * Comment : 호봉제구분코드 
	 *@fn void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd)
	 *@brief date:2016 2016. 5. 18. user:Administrator
	 *@param repbtyBusinDivCd the repbtyBusinDivCd to set
	 */
	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}
	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2016 2016. 6. 23. user:Administrator
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}
	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2016 2016. 6. 23. user:Administrator
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}
	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2016 2016. 6. 23. user:Administrator
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}
	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2016 2016. 6. 23. user:Administrator
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}
	
 
	
}
