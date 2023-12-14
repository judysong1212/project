package com.app.exterms.diligence.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0100VO.java
 * @Description : Payr0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0200BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public static final String ATTR_DILNLAZEXCEDUTYYRMNTH = "dilnlazExceDutyYrMnth";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public static final String ATTR_DILNLAZEXCEDUTYBGNNDT = "dilnlazExceDutyBgnnDt";

    /** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public static final String ATTR_DILNLAZEXCEDUTYENDDT = "dilnlazExceDutyEndDt";

    /** set 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public static final String ATTR_DILNLAZPUBCHODYDUTYNUMDYS = "dilnlazPubcHodyDutyNumDys";

    /** set 근태_토요근무일수 : dilnlazSatDutyNumDys */
    public static final String ATTR_DILNLAZSATDUTYNUMDYS = "dilnlazSatDutyNumDys";

    /** set 근태_총야근일수 : dilnlazTotNtotNumDys */
    public static final String ATTR_DILNLAZTOTNTOTNUMDYS = "dilnlazTotNtotNumDys";

    /** set 근태_총야근시간 : dilnlazTotNtotTm */
    public static final String ATTR_DILNLAZTOTNTOTTM = "dilnlazTotNtotTm";

    /** set 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
    public static final String ATTR_DILNLAZFNDTNTMRSTDUTYTM = "dilnlazFndtnTmRstDutyTm";

    /** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public static final String ATTR_DILNLAZTMRSTDUTYTM = "dilnlazTmRstDutyTm";

    /** set 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
    public static final String ATTR_DILNLAZTOTTMRSTDUTYTM = "dilnlazTotTmRstDutyTm";

    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    public static final String ATTR_DILNLAZDDLNEPRCSYN = "dilnlazDdlnePrcsYn";

    /** set 근태_비고내용 : dilnlazNoteCtnt */
    public static final String ATTR_DILNLAZNOTECTNT = "dilnlazNoteCtnt";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
    public static final String ATTR_DILNLAZPUBCHODYDUTYTM = "dilnlazPubcHodyDutyTm";

    /** 생성자 */
     public Dlgn0200BM() { super(); } 

    /** 일괄등록 처리   */
     public Dlgn0200BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  dilnlazExceDutyYrMnth 
    		, String  payCd 
    		, String  emymtDivCd 
    		, String  deptCd 
    		, String  businCd 
    		, String  typOccuCd 
    		, String  dtilOccuClsDivCd 
    		, String  dilnlazExceDutyBgnnDt 
    		, String  dilnlazExceDutyEndDt 
    		, String  dilnlazPubcHodyDutyNumDys 
    		, String  dilnlazSatDutyNumDys 
    		, String  dilnlazTotNtotNumDys 
    		, String  dilnlazTotNtotTm 
    		, String  dilnlazFndtnTmRstDutyTm 
    		, String  dilnlazTmRstDutyTm 
    		, String  dilnlazTotTmRstDutyTm 
    		, String  dilnlazDdlnePrcsYn 
    		, String  dilnlazNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  pyspGrdeCd 
    		, String  dtilOccuInttnCd 
    		, String  dilnlazPubcHodyDutyTm ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DILNLAZEXCEDUTYYRMNTH,dilnlazExceDutyYrMnth);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_DILNLAZEXCEDUTYBGNNDT,dilnlazExceDutyBgnnDt);
     	values.put(ATTR_DILNLAZEXCEDUTYENDDT,dilnlazExceDutyEndDt);
     	values.put(ATTR_DILNLAZPUBCHODYDUTYNUMDYS,dilnlazPubcHodyDutyNumDys);
     	values.put(ATTR_DILNLAZSATDUTYNUMDYS,dilnlazSatDutyNumDys);
     	values.put(ATTR_DILNLAZTOTNTOTNUMDYS,dilnlazTotNtotNumDys);
     	values.put(ATTR_DILNLAZTOTNTOTTM,dilnlazTotNtotTm);
     	values.put(ATTR_DILNLAZFNDTNTMRSTDUTYTM,dilnlazFndtnTmRstDutyTm);
     	values.put(ATTR_DILNLAZTMRSTDUTYTM,dilnlazTmRstDutyTm);
     	values.put(ATTR_DILNLAZTOTTMRSTDUTYTM,dilnlazTotTmRstDutyTm);
     	values.put(ATTR_DILNLAZDDLNEPRCSYN,dilnlazDdlnePrcsYn);
     	values.put(ATTR_DILNLAZNOTECTNT,dilnlazNoteCtnt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_DILNLAZPUBCHODYDUTYTM,dilnlazPubcHodyDutyTm); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public void setDilnlazExceDutyYrMnth(String  dilnlazExceDutyYrMnth) { set( ATTR_DILNLAZEXCEDUTYYRMNTH ,dilnlazExceDutyYrMnth);}
    /** get 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public String  getDilnlazExceDutyYrMnth() { return (String )get( ATTR_DILNLAZEXCEDUTYYRMNTH );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public void setDilnlazExceDutyBgnnDt(String  dilnlazExceDutyBgnnDt) { set( ATTR_DILNLAZEXCEDUTYBGNNDT ,dilnlazExceDutyBgnnDt);}
    /** get 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public String  getDilnlazExceDutyBgnnDt() { return (String )get( ATTR_DILNLAZEXCEDUTYBGNNDT );}

    /** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public void setDilnlazExceDutyEndDt(String  dilnlazExceDutyEndDt) { set( ATTR_DILNLAZEXCEDUTYENDDT ,dilnlazExceDutyEndDt);}
    /** get 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public String  getDilnlazExceDutyEndDt() { return (String )get( ATTR_DILNLAZEXCEDUTYENDDT );}

    /** set 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public void setDilnlazPubcHodyDutyNumDys(String  dilnlazPubcHodyDutyNumDys) { set( ATTR_DILNLAZPUBCHODYDUTYNUMDYS ,dilnlazPubcHodyDutyNumDys);}
    /** get 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public String  getDilnlazPubcHodyDutyNumDys() { return (String )get( ATTR_DILNLAZPUBCHODYDUTYNUMDYS );}

    /** set 근태_토요근무일수 : dilnlazSatDutyNumDys */
    public void setDilnlazSatDutyNumDys(String  dilnlazSatDutyNumDys) { set( ATTR_DILNLAZSATDUTYNUMDYS ,dilnlazSatDutyNumDys);}
    /** get 근태_토요근무일수 : dilnlazSatDutyNumDys */
    public String  getDilnlazSatDutyNumDys() { return (String )get( ATTR_DILNLAZSATDUTYNUMDYS );}

    /** set 근태_총야근일수 : dilnlazTotNtotNumDys */
    public void setDilnlazTotNtotNumDys(String  dilnlazTotNtotNumDys) { set( ATTR_DILNLAZTOTNTOTNUMDYS ,dilnlazTotNtotNumDys);}
    /** get 근태_총야근일수 : dilnlazTotNtotNumDys */
    public String  getDilnlazTotNtotNumDys() { return (String )get( ATTR_DILNLAZTOTNTOTNUMDYS );}

    /** set 근태_총야근시간 : dilnlazTotNtotTm */
    public void setDilnlazTotNtotTm(String  dilnlazTotNtotTm) { set( ATTR_DILNLAZTOTNTOTTM ,dilnlazTotNtotTm);}
    /** get 근태_총야근시간 : dilnlazTotNtotTm */
    public String  getDilnlazTotNtotTm() { return (String )get( ATTR_DILNLAZTOTNTOTTM );}

    /** set 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
    public void setDilnlazFndtnTmRstDutyTm(String  dilnlazFndtnTmRstDutyTm) { set( ATTR_DILNLAZFNDTNTMRSTDUTYTM ,dilnlazFndtnTmRstDutyTm);}
    /** get 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
    public String  getDilnlazFndtnTmRstDutyTm() { return (String )get( ATTR_DILNLAZFNDTNTMRSTDUTYTM );}

    /** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public void setDilnlazTmRstDutyTm(String  dilnlazTmRstDutyTm) { set( ATTR_DILNLAZTMRSTDUTYTM ,dilnlazTmRstDutyTm);}
    /** get 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public String  getDilnlazTmRstDutyTm() { return (String )get( ATTR_DILNLAZTMRSTDUTYTM );}

    /** set 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
    public void setDilnlazTotTmRstDutyTm(String  dilnlazTotTmRstDutyTm) { set( ATTR_DILNLAZTOTTMRSTDUTYTM ,dilnlazTotTmRstDutyTm);}
    /** get 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
    public String  getDilnlazTotTmRstDutyTm() { return (String )get( ATTR_DILNLAZTOTTMRSTDUTYTM );}

    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    public void setDilnlazDdlnePrcsYn(String  dilnlazDdlnePrcsYn) { set( ATTR_DILNLAZDDLNEPRCSYN ,dilnlazDdlnePrcsYn);}
    /** get 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    public String  getDilnlazDdlnePrcsYn() { return (String )get( ATTR_DILNLAZDDLNEPRCSYN );}

    /** set 근태_비고내용 : dilnlazNoteCtnt */
    public void setDilnlazNoteCtnt(String  dilnlazNoteCtnt) { set( ATTR_DILNLAZNOTECTNT ,dilnlazNoteCtnt);}
    /** get 근태_비고내용 : dilnlazNoteCtnt */
    public String  getDilnlazNoteCtnt() { return (String )get( ATTR_DILNLAZNOTECTNT );}

    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}

    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
    public void setDilnlazPubcHodyDutyTm(String  dilnlazPubcHodyDutyTm) { set( ATTR_DILNLAZPUBCHODYDUTYTM ,dilnlazPubcHodyDutyTm);}
    /** get 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
    public String  getDilnlazPubcHodyDutyTm() { return (String )get( ATTR_DILNLAZPUBCHODYDUTYTM );}

}
