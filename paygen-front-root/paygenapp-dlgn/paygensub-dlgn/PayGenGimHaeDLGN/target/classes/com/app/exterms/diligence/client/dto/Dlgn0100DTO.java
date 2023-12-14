package com.app.exterms.diligence.client.dto;

import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Dlgn0100DTO extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	public Dlgn0100DTO(){}
	
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
	/** set 근태년월 : dilnlazYrMnth */
	public void setDilnlazYrMnth(String dilnlazYrMnth) { set("dilnlazYrMnth",dilnlazYrMnth);}
	/** get 근태년월 : dilnlazYrMnth */
	public String getDilnlazYrMnth() { return (String)get("dilnlazYrMnth");}
	/** set 급여구분코드 : payCd */
	public void setPayCd(String payCd) { set("payCd",payCd);}
	/** get 급여구분코드 : payCd */
	public String getPayCd() { return (String)get("payCd");}
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String emymtDivCd) { set("emymtDivCd",emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String getEmymtDivCd() { return (String)get("emymtDivCd");}
	/** set 재직상태코드 : hdofcCodtnCd */
	public void setHdofcCodtnCd(String hdofcCodtnCd) { set("hdofcCodtnCd",hdofcCodtnCd);}
	/** get 재직상태코드 : hdofcCodtnCd */
	public String getHdofcCodtnCd() { return (String)get("hdofcCodtnCd");}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
	/** get 부서코드 : deptCd */
	public String getDeptCd() { return (String)get("deptCd");}
	/** set 사업코드 : businCd */
	public void setBusinCd(String businCd) { set("businCd",businCd);}
	/** get 사업코드 : businCd */
	public String getBusinCd() { return (String)get("businCd");}
	/** set 직종명 : typOccuCd */
	public void setTypOccuNm(String typOccuNm) { set("typOccuNm",typOccuNm);}
	/** get 직종명 : typOccuCd */
	public String getTypOccuNm() { return (String)get("typOccuNm");}
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String typOccuCd) { set("typOccuCd",typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String getTypOccuCd() { return (String)get("typOccuCd");}
	
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) { set("dtilOccuClsDivCd",dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String getDtilOccuClsDivCd() { return (String)get("dtilOccuClsDivCd");}
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String dtilOccuInttnCd) { set("dtilOccuInttnCd",dtilOccuInttnCd);}
	/** get 직종세통코드 : dtilOccuInttnCd */
	public String getDtilOccuInttnCd() { return (String)get("dtilOccuInttnCd");}
	
	/** set 직종세통합코드명 : dtilOccuInttnCd */
	public void setDtilOccuInttnNm(String dtilOccuInttnNm) { set("dtilOccuInttnNm",dtilOccuInttnNm);}
	/** get 직종세통합코드명 : dtilOccuInttnCd */
	public String getDtilOccuInttnNm() { return (String)get("dtilOccuInttnNm");}
	
	/** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
	public void setDilnlazDutyBgnnDt(String dilnlazDutyBgnnDt) { set("dilnlazDutyBgnnDt",dilnlazDutyBgnnDt);}
	/** get 근태_근무시작일자 : dilnlazDutyBgnnDt */
	public String getDilnlazDutyBgnnDt() { return (String)get("dilnlazDutyBgnnDt");}
	/** set 근태_근무종료일자 : dilnlazDutyEndDt */
	public void setDilnlazDutyEndDt(String dilnlazDutyEndDt) { set("dilnlazDutyEndDt",dilnlazDutyEndDt);}
	/** get 근태_근무종료일자 : dilnlazDutyEndDt */
	public String getDilnlazDutyEndDt() { return (String)get("dilnlazDutyEndDt");}
	/** set 근태_근무일수 : dilnlazDutyNumDys */
	public void setDilnlazDutyNumDys(String dilnlazDutyNumDys) { set("dilnlazDutyNumDys",dilnlazDutyNumDys);}
	/** get 근태_근무일수 : dilnlazDutyNumDys */
	public String getDilnlazDutyNumDys() { return (String)get("dilnlazDutyNumDys");}
	/** set 근태_연가일수 : dilnlazLvsgNumDys */
	public void setDilnlazLvsgNumDys(String dilnlazLvsgNumDys) { set("dilnlazLvsgNumDys",dilnlazLvsgNumDys);}
	/** get 근태_연가일수 : dilnlazLvsgNumDys */
	public String getDilnlazLvsgNumDys() { return (String)get("dilnlazLvsgNumDys");}
	/** set 근태_결근일수 : dilnlazAbnceNumDys */
	public void setDilnlazAbnceNumDys(String dilnlazAbnceNumDys) { set("dilnlazAbnceNumDys",dilnlazAbnceNumDys);}
	/** get 근태_결근일수 : dilnlazAbnceNumDys */
	public String getDilnlazAbnceNumDys() { return (String)get("dilnlazAbnceNumDys");}
	/** set 근태_병가일수 : dilnlazSckleaNumDys */
	public void setDilnlazSckleaNumDys(String dilnlazSckleaNumDys) { set("dilnlazSckleaNumDys",dilnlazSckleaNumDys);}
	/** get 근태_병가일수 : dilnlazSckleaNumDys */
	public String getDilnlazSckleaNumDys() { return (String)get("dilnlazSckleaNumDys");}
	/** set 근태_공가일수 : dilnlazOffvaNumDys */
	public void setDilnlazOffvaNumDys(String dilnlazOffvaNumDys) { set("dilnlazOffvaNumDys",dilnlazOffvaNumDys);}
	/** get 근태_공가일수 : dilnlazOffvaNumDys */
	public String getDilnlazOffvaNumDys() { return (String)get("dilnlazOffvaNumDys");}
	/** set 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	public void setDilnlazFmlyEvntNumDys(String dilnlazFmlyEvntNumDys) { set("dilnlazFmlyEvntNumDys",dilnlazFmlyEvntNumDys);}
	/** get 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	public String getDilnlazFmlyEvntNumDys() { return (String)get("dilnlazFmlyEvntNumDys");}
	/** set 근태_보건일수 : dilnlazHlthCreNumDys */
	public void setDilnlazHlthCreNumDys(String dilnlazHlthCreNumDys) { set("dilnlazHlthCreNumDys",dilnlazHlthCreNumDys);}
	/** get 근태_보건일수 : dilnlazHlthCreNumDys */
	public String getDilnlazHlthCreNumDys() { return (String)get("dilnlazHlthCreNumDys");}
	/** set 근태_총근무일수 : dilnlazTotDutyNumDys */
	public void setDilnlazTotDutyNumDys(String dilnlazTotDutyNumDys) { set("dilnlazTotDutyNumDys",dilnlazTotDutyNumDys);}
	/** get 근태_총근무일수 : dilnlazTotDutyNumDys */
	public String getDilnlazTotDutyNumDys() { return (String)get("dilnlazTotDutyNumDys");}
	/** set 근태_주휴일수 : dilnlazWklyHldyNumDys */
	public void setDilnlazWklyHldyNumDys(String dilnlazWklyHldyNumDys) { set("dilnlazWklyHldyNumDys",dilnlazWklyHldyNumDys);}
	/** get 근태_주휴일수 : dilnlazWklyHldyNumDys */
	public String getDilnlazWklyHldyNumDys() { return (String)get("dilnlazWklyHldyNumDys");}
	/** set 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	public void setDilnlazPaidPubcHodyNum(String dilnlazPaidPubcHodyNum) { set("dilnlazPaidPubcHodyNum",dilnlazPaidPubcHodyNum);}
	/** get 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	public String getDilnlazPaidPubcHodyNum() { return (String)get("dilnlazPaidPubcHodyNum");}
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
	
	/** set 주휴일수 : inptDilnlazWklyHldyNumDys */
	public void setInptDilnlazWklyHldyNumDys(String inptDilnlazWklyHldyNumDys) { set("inptDilnlazWklyHldyNumDys",inptDilnlazWklyHldyNumDys);}
	/** get 근태_주휴일수 : inptDilnlazWklyHldyNumDys */
	public String getInptDilnlazWklyHldyNumDys() { return (String)get("inptDilnlazWklyHldyNumDys");}
	
        /** set 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
        public void setDilnlazSpclHodyNumDys(String  dilnlazSpclHodyNumDys) { set( "dilnlazSpclHodyNumDys" ,dilnlazSpclHodyNumDys);}
        /** get 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
        public String  getDilnlazSpclHodyNumDys() { return (String )get( "dilnlazSpclHodyNumDys" );}
        
        /** set 총토요근무일수 : dilnlazSatDutyNumDys */
        public void setDilnlazSatDutyNumDys(String  dilnlazSatDutyNumDys) { set( "dilnlazSatDutyNumDys" ,dilnlazSatDutyNumDys);}
        /** get 총토요근무일수 : dilnlazSatDutyNumDys */
        public String  getDilnlazSatDutyNumDys() { return (String )get( "dilnlazSatDutyNumDys" );}
        
//        /** set 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//        public void setDilnlazPubcHodyDutyNumDys(String  dilnlazPubcHodyDutyNumDys) { set( "dilnlazPubcHodyDutyNumDys" ,dilnlazPubcHodyDutyNumDys);}
//        /** get 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//        public String  getDilnlazPubcHodyDutyNumDys() { return (String )get( "dilnlazPubcHodyDutyNumDys" );}
        
        
      /** set 휴일일수 : dilnlazHodyDutyNumDys */
      public void setDilnlazHodyDutyNumDys(String  dilnlazHodyDutyNumDys) { set( "dilnlazHodyDutyNumDys" ,dilnlazHodyDutyNumDys);}
      /** get 휴일일수 : dilnlazHodyDutyNumDys */
      public String  getDilnlazHodyDutyNumDys() { return (String )get( "dilnlazHodyDutyNumDys" );}      
        
        
        
        /** set 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
        public void setDilnlazAbnceDutyRcgtnDys(String  dilnlazAbnceDutyRcgtnDys) { set( "dilnlazAbnceDutyRcgtnDys" ,dilnlazAbnceDutyRcgtnDys);}
        /** get 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
        public String  getDilnlazAbnceDutyRcgtnDys() { return (String )get( "dilnlazAbnceDutyRcgtnDys" );}
        
        /** set 호봉등급코드 : pyspGrdeCd */
        public void setPyspGrdeCd(String  pyspGrdeCd) { set( "pyspGrdeCd" ,pyspGrdeCd);}
        /** get 호봉등급코드 : pyspGrdeCd */
        public String  getPyspGrdeCd() { return (String )get( "pyspGrdeCd" );}
        
        /** set 근태_총근무시간 : dilnlazTotDutyTm */
        public void setDilnlazTotDutyTm(String  dilnlazTotDutyTm) { set( "dilnlazTotDutyTm" ,dilnlazTotDutyTm);}
        /** get 근태_총근무시간 : dilnlazTotDutyTm */
        public String  getDilnlazTotDutyTm() { return (String )get( "dilnlazTotDutyTm" );}
        
        /** set 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
        public void setDilnlazPaidHodyNumDys(String  dilnlazPaidHodyNumDys) { set( "dilnlazPaidHodyNumDys" ,dilnlazPaidHodyNumDys);}
        /** get 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
        public String  getDilnlazPaidHodyNumDys() { return (String )get( "dilnlazPaidHodyNumDys" );}
        
        /** set 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
        public void setDilnlazTfcAssCstNumDys(String  dilnlazTfcAssCstNumDys) { set( "dilnlazTfcAssCstNumDys" ,dilnlazTfcAssCstNumDys);}
        /** get 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
        public String  getDilnlazTfcAssCstNumDys() { return (String )get( "dilnlazTfcAssCstNumDys" );}
 
        /** set 근태_급식비일수 : dilnlazLnchDys */
        public void setDilnlazLnchDys(String  dilnlazLnchDys) { set( "dilnlazLnchDys" ,dilnlazLnchDys);}
        /** set 근태_급식비일수 : dilnlazLnchDys */
        public String  getDilnlazLnchDys() { return (String )get( "dilnlazLnchDys" );}
        
        
	/** set 근태_적용일자 : dilnlazApptnDt */
	public void setDilnlazApptnDt(String dilnlazApptnDt) { set("dilnlazApptnDt",dilnlazApptnDt);}
	/** get 근태_적용일자 : dilnlazApptnDt */
	public String getDilnlazApptnDt() { return (String)get("dilnlazApptnDt");}
	/** set 근태_근무시간 : dilnlazDutyTm */
	public void setDilnlazDutyTm(String dilnlazDutyTm) { set("dilnlazDutyTm",dilnlazDutyTm);}
	/** get 근태_근무시간 : dilnlazDutyTm */
	public String getDilnlazDutyTm() { return String.valueOf(get("dilnlazDutyTm"));}
	/** set 근태_근무여부 : dilnlazDutyYn */
	public void setDilnlazDutyYn(String dilnlazDutyYn) { set("dilnlazDutyYn",dilnlazDutyYn);}
	/** get 근태_근무여부 : dilnlazDutyYn */
	public String getDilnlazDutyYn() { return (String)get("dilnlazDutyYn");}
	
	
	
	/** set 근태_결근여부 : dilnlazAbnceYn */
	public void setDilnlazAbnceYn(String dilnlazAbnceYn) { set("dilnlazAbnceYn",dilnlazAbnceYn);}
	/** get 근태_결근여부 : dilnlazAbnceYn */
	public String getDilnlazAbnceYn() { return (String)get("dilnlazAbnceYn");}
	/** set 근태_연가여부 : dilnlazLvsgYn */
	public void setDilnlazLvsgYn(String dilnlazLvsgYn) { set("dilnlazLvsgYn",dilnlazLvsgYn);}
	/** get 근태_연가여부 : dilnlazLvsgYn */
	public String getDilnlazLvsgYn() { return (String)get("dilnlazLvsgYn");}
	/** set 근태_병가여부 : dilnlazSckleaYn */
	public void setDilnlazSckleaYn(String dilnlazSckleaYn) { set("dilnlazSckleaYn",dilnlazSckleaYn);}
	/** get 근태_병가여부 : dilnlazSckleaYn */
	public String getDilnlazSckleaYn() { return (String)get("dilnlazSckleaYn");}
	/** set 근태_공가여부 : dilnlazOffvaYn */
	public void setDilnlazOffvaYn(String dilnlazOffvaYn) { set("dilnlazOffvaYn",dilnlazOffvaYn);}
	/** get 근태_공가여부 : dilnlazOffvaYn */
	public String getDilnlazOffvaYn() { return (String)get("dilnlazOffvaYn");}
	/** set 근태_경조사여부 : dilnlazFmlyEvntYn */
	public void setDilnlazFmlyEvntYn(String dilnlazFmlyEvntYn) { set("dilnlazFmlyEvntYn",dilnlazFmlyEvntYn);}
	/** get 근태_경조사여부 : dilnlazFmlyEvntYn */
	public String getDilnlazFmlyEvntYn() { return (String)get("dilnlazFmlyEvntYn");}
	/** set 근태_보건여부 : dilnlazHlthCreYn */
	public void setDilnlazHlthCreYn(String dilnlazHlthCreYn) { set("dilnlazHlthCreYn",dilnlazHlthCreYn);}
	/** get 근태_보건여부 : dilnlazHlthCreYn */
	public String getDilnlazHlthCreYn() { return (String)get("dilnlazHlthCreYn");}
	
    /** set 평일근무일수 : dilnlazWkdDutyNumDys */
    public void setDilnlazWkdDutyNumDys(String  dilnlazWkdDutyNumDys) { set( "dilnlazWkdDutyNumDys" ,dilnlazWkdDutyNumDys);}
    /** get 평일근무일수 : dilnlazWkdDutyNumDys */
    public String  getDilnlazWkdDutyNumDys() { return (String )get( "dilnlazWkdDutyNumDys" );}      
	
	//특별휴가 추가
	public String getDilnlazSpclHodyYn(){ return (String)get("dilnlazSpclHodyYn");}
	public void setDilnlazSpclHodyYn(String dilnlazSpclHodyYn){set("dilnlazSpclHodyYn", dilnlazSpclHodyYn);}
	
	
	/** set 근태_교통비보조 여부 : dilnlazTfcAssCstYn */
	public void setDilnlazTfcAssCstYn(String dilnlazTfcAssCstYn) { set("dilnlazTfcAssCstYn",dilnlazTfcAssCstYn);}
	/** get 근태_교통비보조 여부 : dilnlazTfcAssCstYn */
	public String getDilnlazTfcAssCstYn() { return (String)get("dilnlazTfcAssCstYn");}
	
	/** set 근태_급식비 여부 : dilnlazLnchYn */
	public void setDilnlazLnchYn(String dilnlazLnchYn) { set("dilnlazLnchYn",dilnlazLnchYn);}
	/** get 근태_급식비 여부 : dilnlazLnchYn */
	public String getDilnlazLnchYn() { return (String)get("dilnlazLnchYn");}

	/** set 복무기타구분코드 : dilnlazEtcDivCd */
	public void setDilnlazEtcDivCd(String dilnlazEtcDivCd) { set("dilnlazEtcDivCd",dilnlazEtcDivCd);}
	/** get 복무기타구분코드 : dilnlazEtcDivCd */
	public String getDilnlazEtcDivCd() { return (String)get("dilnlazEtcDivCd");}
	
	/** set 복무기타구분명 : dilnlazEtcDivNm */
	public void setDilnlazEtcDivNm(String dilnlazEtcDivNm) { set("dilnlazEtcDivNm",dilnlazEtcDivNm);}
	/** get 복무기타구분명 : dilnlazEtcDivNm */
	public String getDilnlazEtcDivNm() { return (String)get("dilnlazEtcDivNm");}
	
	/** set 근태_휴일근무 여부 : dilnlazHodyYn */
	public void setDilnlazHodyYn(String dilnlazHodyYn) { set("dilnlazHodyYn",dilnlazHodyYn);}
	/** get 근태_휴일근무 여부 : dilnlazHodyYn */
	public String getDilnlazHodyYn() { return (String)get("dilnlazHodyYn");}
	
	
	/** set 근태_출장여부 : dilnlazButpYn */
	public void setDilnlazButpYn(String dilnlazButpYn) { set("dilnlazButpYn",dilnlazButpYn);}
	/** get 근태_출장여부 : dilnlazButpYn */
	public String getDilnlazButpYn() { return (String)get("dilnlazButpYn");}

	
	//////체크 박스용 시작
	
	/** set 근태_결근여부 : dilnlazAbnceYnboolean */
	public void setDilnlazAbnceYnboolean(boolean dilnlazAbnceYnboolean) { set("dilnlazAbnceYnboolean",dilnlazAbnceYnboolean);}
	/** get 근태_결근여부 : dilnlazAbnceYnboolean */
	public boolean getDilnlazAbnceYnboolean() { return (Boolean)get("dilnlazAbnceYnboolean");}
	/** set 근태_연가여부 : dilnlazLvsgYnboolean */
	public void setDilnlazLvsgYnboolean(boolean dilnlazLvsgYnboolean) { set("dilnlazLvsgYnboolean",dilnlazLvsgYnboolean);}
	/** get 근태_연가여부 : dilnlazLvsgYnboolean */
	public boolean getDilnlazLvsgYnboolean() { return (Boolean)get("dilnlazLvsgYnboolean");}
	/** set 근태_병가여부 : dilnlazSckleaYnboolean */
	public void setDilnlazSckleaYnboolean(boolean dilnlazSckleaYnboolean) { set("dilnlazSckleaYnboolean",dilnlazSckleaYnboolean);}
	/** get 근태_병가여부 : dilnlazSckleaYnboolean */
	public boolean getDilnlazSckleaYnboolean() { return (Boolean)get("dilnlazSckleaYnboolean");}
	/** set 근태_공가여부 : dilnlazOffvaYnboolean */
	public void setDilnlazOffvaYnboolean(boolean dilnlazOffvaYnboolean) { set("dilnlazOffvaYnboolean",dilnlazOffvaYnboolean);}
	/** get 근태_공가여부 : dilnlazOffvaYnboolean */
	public boolean getDilnlazOffvaYnboolean() { return (Boolean)get("dilnlazOffvaYnboolean");}
	/** set 근태_경조사여부 : dilnlazFmlyEvntYnboolean */
	public void setDilnlazFmlyEvntYnboolean(boolean dilnlazFmlyEvntYnboolean) { set("dilnlazFmlyEvntYnboolean",dilnlazFmlyEvntYnboolean);}
	/** get 근태_경조사여부 : dilnlazFmlyEvntYnboolean */
	public boolean getDilnlazFmlyEvntYnboolean() { return (Boolean)get("dilnlazFmlyEvntYnboolean");}
	/** set 근태_보건여부 : dilnlazHlthCreYnboolean */
	public void setDilnlazHlthCreYnboolean(boolean dilnlazHlthCreYnboolean) { set("dilnlazHlthCreYnboolean",dilnlazHlthCreYnboolean);}
	/** get 근태_보건여부 : dilnlazHlthCreYnboolean */
	public boolean getDilnlazHlthCreYnboolean() { return (Boolean)get("dilnlazHlthCreYnboolean");}
	
	/** set 근태_교통보조비여부 : dilnlazTfcAssCstYnBoolean */
	public void setDilnlazTfcAssCstYnBoolean(boolean dilnlazTfcAssCstYnBoolean) { set("dilnlazTfcAssCstYnBoolean",dilnlazTfcAssCstYnBoolean);}
	/** get 근태_보건여부 : dilnlazTfcAssCstYnBoolean */
	public boolean getDilnlazTfcAssCstYnBoolean() { return (Boolean)get("dilnlazTfcAssCstYnBoolean");}
	
	/** set 근태_급식비여부 : dilnlazLnchYnBoolean */
	public void setDilnlazLnchYnBoolean(boolean dilnlazLnchYnBoolean) { set("dilnlazLnchYnBoolean",dilnlazLnchYnBoolean);}
	/** get 근태_보건여부 : dilnlazLnchYnBoolean */
	public boolean getDilnlazLnchYnBoolean() { return (Boolean)get("dilnlazLnchYnBoolean");}
	
	/** set 근태_휴일근무 여부 : dilnlazHodyYnboolean */
	public void setDilnlazHodyYnboolean(boolean dilnlazHodyYnboolean) { set("dilnlazHodyYnboolean",dilnlazHodyYnboolean);}
	/** get 근태_휴일근무 여부 : dilnlazHodyYnboolean */
	public boolean getDilnlazHodyYnboolean() { return (Boolean)get("dilnlazHodyYnboolean");}
	
	
	/** set 근태_근무여부 : dilnlazDutyYnBoolean */
	public void setDilnlazDutyYnBoolean(boolean dilnlazDutyYnBoolean) { set("dilnlazDutyYnBoolean",dilnlazDutyYnBoolean);}
	/** get 근태_근무여부 : dilnlazDutyYnBoolean */
	public boolean getDilnlazDutyYnBoolean() { return (Boolean)get("dilnlazDutyYnBoolean");}
	
	public void setDilnlazAbnceDutyRcgtnYnboolean(boolean dilnlazAbnceDutyRcgtnYnboolean) { set("dilnlazAbnceDutyRcgtnYnboolean",dilnlazAbnceDutyRcgtnYnboolean);}
	public boolean getDilnlazAbnceDutyRcgtnYnboolean() { return (Boolean)get("dilnlazAbnceDutyRcgtnYnboolean");}
	public void setDilnlazSpclHodyYnboolean(boolean dilnlazSpclHodyYnboolean){set("dilnlazSpclHodyYnboolean", dilnlazSpclHodyYnboolean);}
	public boolean getDilnlazSpclHodyYnboolean(){ return (Boolean)get("dilnlazSpclHodyYnboolean");}
	
	
	//////체크 박스용 끝
	
	/** set  : offdayKubn */
	public void setOffdayKubn(String offdayKubn) { set("offdayKubn",offdayKubn);}
	/** get  : offdayKubn */
	public String getOffdayKubn() { return (String)get("offdayKubn");}
	
	
	 
	
	
	
	/** set 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
	public void setDilnlazAbnceDutyRcgtnYn(String dilnlazAbnceDutyRcgtnYn) { set("dilnlazAbnceDutyRcgtnYn",dilnlazAbnceDutyRcgtnYn);}
	/** get 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
	public String getDilnlazAbnceDutyRcgtnYn() { return (String)get("dilnlazAbnceDutyRcgtnYn");}
	
	/** set 고용시작일자 : emymtBgnnDt */
	public void setEmymtBgnnDt(String emymtBgnnDt) { set("emymtBgnnDt",emymtBgnnDt);}
	/** get 고용시작일자 : emymtBgnnDt */
	public String getEmymtBgnnDt() { return (String)get("emymtBgnnDt");}
	/** set 고용종료일자 : emymtEndDt */
	public void setEmymtEndDt(String emymtEndDt) { set("emymtEndDt",emymtEndDt);}
	/** get 고용종료일자 : emymtEndDt */
	public String getEmymtEndDt() { return (String)get("emymtEndDt");}
	
	
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
	
	/** set 부서코드 : payrMangDeptCd */
	public void setPayrMangDeptCd(String payrMangDeptCd) { set("payrMangDeptCd",payrMangDeptCd);}
	/** get 부서코드 : payrMangDeptCd */
	public String getPayrMangDeptCd() { return (String)get("payrMangDeptCd");}
	
	
	
	
	
	private java.lang.String repbtyBusinDivCd; /** set 호봉제구분코드 : REPBTY_BUSIN_DIV_CD */
	
    private java.lang.String usrId; /** set 사용자아이디 : usrId */

    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    private List<String> deptCdArr; /** 부서코드 - DEPT_CD */

    private List<String> typOccuCdArr; /** 직종 - typOccuCdArr */
    
    
    private List<String> dtilOccuInttnCdArr; /** 직종 - dtilOccuInttnCdArr */
     
    
    private java.lang.String deptCdAuth; 
    
    
    public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}
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





	/** 부서코드 - DEPT_CD */
    
    private java.lang.String dtilOccuInttnCdAuth;  /** 직종세통합코드 dtilOccuInttnCd */  
    
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
	public List<String> getDeptCdArr() {
		return deptCdArr;
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
	
	
	
	
	
	
}
