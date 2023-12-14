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
public class Dlgn0250BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 근태년월 : dilnlazYrMnth */
    public static final String ATTR_DILNLAZYRMNTH = "dilnlazYrMnth";

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
    

/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";


    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    public static final String ATTR_DILNLAZDUTYBGNNDT = "dilnlazDutyBgnnDt";

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    public static final String ATTR_DILNLAZDUTYENDDT = "dilnlazDutyEndDt";

    /** set 근태_근무일수 : dilnlazDutyNumDys */
    public static final String ATTR_DILNLAZDUTYNUMDYS = "dilnlazDutyNumDys";

    /** set 근태_연가일수 : dilnlazLvsgNumDys */
    public static final String ATTR_DILNLAZLVSGNUMDYS = "dilnlazLvsgNumDys";

    /** set 근태_결근일수 : dilnlazAbnceNumDys */
    public static final String ATTR_DILNLAZABNCENUMDYS = "dilnlazAbnceNumDys";

    /** set 근태_병가일수 : dilnlazSckleaNumDys */
    public static final String ATTR_DILNLAZSCKLEANUMDYS = "dilnlazSckleaNumDys";

    /** set 근태_공가일수 : dilnlazOffvaNumDys */
    public static final String ATTR_DILNLAZOFFVANUMDYS = "dilnlazOffvaNumDys";

    /** set 근태_경조사일수 : dilnlazFmlyEvntNumDys */
    public static final String ATTR_DILNLAZFMLYEVNTNUMDYS = "dilnlazFmlyEvntNumDys";

    /** set 근태_보건일수 : dilnlazHlthCreNumDys */
    public static final String ATTR_DILNLAZHLTHCRENUMDYS = "dilnlazHlthCreNumDys";

    /** set 근태_총근무일수 : dilnlazTotDutyNumDys */
    public static final String ATTR_DILNLAZTOTDUTYNUMDYS = "dilnlazTotDutyNumDys";

    /** set 근태_주휴일수 : dilnlazWklyHldyNumDys */
    public static final String ATTR_DILNLAZWKLYHLDYNUMDYS = "dilnlazWklyHldyNumDys";

    /** set 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
    public static final String ATTR_DILNLAZPAIDPUBCHODYNUM = "dilnlazPaidPubcHodyNum";

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

    /** set 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
    public static final String ATTR_DILNLAZSPCLHODYNUMDYS = "dilnlazSpclHodyNumDys";

    /** set 총토요근무일수 : dilnlazSatDutyNumDys */
    public static final String ATTR_DILNLAZSATDUTYNUMDYS = "dilnlazSatDutyNumDys";
    
    /** set 휴일일수 : dilnlazHodyDutyNumDys */
    public static final String ATTR_DILNLAZHODYDUTYNUMDYS = "dilnlazHodyDutyNumDys";

    /** set 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public static final String ATTR_DILNLAZPUBCHODYDUTYNUMDYS = "dilnlazPubcHodyDutyNumDys";
    
    /** set 총휴일근무시간 : dilnlazPubcHodyDutyTm */
    public static final String ATTR_DILNLAZPUBCHODYDUTYTM = "dilnlazPubcHodyDutyTm";
    
    /** set 총휴일연장시간 : dilnlazHodyTotNtotTm */
    public static final String ATTR_DILNLAZHODYTOTNTOTTM = "dilnlazHodyTotNtotTm";

    /** set 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
    public static final String ATTR_DILNLAZABNCEDUTYRCGTNDYS = "dilnlazAbnceDutyRcgtnDys";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 근태_총근무시간 : dilnlazTotDutyTm */
    public static final String ATTR_DILNLAZTOTDUTYTM = "dilnlazTotDutyTm";

    /** set 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
    public static final String ATTR_DILNLAZPAIDHODYNUMDYS = "dilnlazPaidHodyNumDys";

    /** set 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
    public static final String ATTR_DILNLAZTFCASSCSTNUMDYS = "dilnlazTfcAssCstNumDys";

    /** set 근태_급식비일수 : dilnlazLnchDys */
    public static final String ATTR_DILNLAZLNCHDYS = "dilnlazLnchDys";


    /** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public static final String ATTR_DILNLAZEXCEDUTYBGNNDT = "dilnlazExceDutyBgnnDt";

    /** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public static final String ATTR_DILNLAZEXCEDUTYENDDT = "dilnlazExceDutyEndDt";
 

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
    
    

    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";

    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 직종세 : dtilOccuClsNm */
    public static final String ATTR_DTILOCCUCLSNM = "dtilOccuClsNm";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";

 
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
 
    
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
    /** set 평일근무일수 : dilnlazWkdDutyNumDys */
    public static final String ATTR_DILNLAZWKDDUTYNUMDYS = "dilnlazWkdDutyNumDys";
    
	/** set 복무통합구분값 : typOccuBusinVal */
    public static final String ATTR_TYPOCCUBUSINVAL = "typOccuBusinVal";
 
    /** set 근태_출장일수 : dilnlazButpDys */
    public static final String ATTR_DILNLAZBUTPDYS = "dilnlazButpDys";
    /** set 근태_출장일수 : dilnlazButpDys */
    public void setDilnlazButpDys(String  dilnlazButpDys) { set( ATTR_DILNLAZBUTPDYS ,dilnlazButpDys);}
    /** get 근태_출장일수 : dilnlazButpDys */
    public String  getDilnlazButpDys() { return (String )get( ATTR_DILNLAZBUTPDYS );}
    
    /** 생성자 */
     public Dlgn0250BM() { super(); } 

    /** 일괄등록 처리   */
     public Dlgn0250BM(
             String  dpobCd 
            , String  systemkey 
            , String  dilnlazYrMnth 
            , String  payCd 
            , String  emymtDivCd 
            , String  deptCd 
            , String  businCd 
            , String  typOccuCd 
            , String  dtilOccuClsDivCd 
            , String  dilnlazDutyBgnnDt 
            , String  dilnlazDutyEndDt 
            , String  dilnlazDutyNumDys 
            , String  dilnlazLvsgNumDys 
            , String  dilnlazAbnceNumDys 
            , String  dilnlazSckleaNumDys 
            , String  dilnlazOffvaNumDys 
            , String  dilnlazFmlyEvntNumDys 
            , String  dilnlazHlthCreNumDys 
            , String  dilnlazTotDutyNumDys 
            , String  dilnlazWklyHldyNumDys 
            , String  dilnlazPaidPubcHodyNum 
            , String  dilnlazDdlnePrcsYn 
            , String  dilnlazNoteCtnt 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr 
            , String  dilnlazSpclHodyNumDys 
            , String  dilnlazSatDutyNumDys 
            , String  dilnlazHodyDutyNumDys 
            , String  dilnlazPubcHodyDutyNumDys
            , String  dilnlazPubcHodyDutyTm
            , String  dilnlazHodyTotNtotTm
            , String  dilnlazAbnceDutyRcgtnDys 
            , String  pyspGrdeCd 
            , String  dilnlazTotDutyTm 
            , String  dilnlazPaidHodyNumDys 
            , String  dilnlazTfcAssCstNumDys 
            , String  dilnlazWkdDutyNumDys ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_DILNLAZYRMNTH,dilnlazYrMnth);
        values.put(ATTR_PAYCD,payCd);
        values.put(ATTR_EMYMTDIVCD,emymtDivCd);
        values.put(ATTR_DEPTCD,deptCd);
        values.put(ATTR_BUSINCD,businCd);
        values.put(ATTR_TYPOCCUCD,typOccuCd);
        values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
        values.put(ATTR_DILNLAZDUTYBGNNDT,dilnlazDutyBgnnDt);
        values.put(ATTR_DILNLAZDUTYENDDT,dilnlazDutyEndDt);
        values.put(ATTR_DILNLAZDUTYNUMDYS,dilnlazDutyNumDys);
        values.put(ATTR_DILNLAZLVSGNUMDYS,dilnlazLvsgNumDys);
        values.put(ATTR_DILNLAZABNCENUMDYS,dilnlazAbnceNumDys);
        values.put(ATTR_DILNLAZSCKLEANUMDYS,dilnlazSckleaNumDys);
        values.put(ATTR_DILNLAZOFFVANUMDYS,dilnlazOffvaNumDys);
        values.put(ATTR_DILNLAZFMLYEVNTNUMDYS,dilnlazFmlyEvntNumDys);
        values.put(ATTR_DILNLAZHLTHCRENUMDYS,dilnlazHlthCreNumDys);
        values.put(ATTR_DILNLAZTOTDUTYNUMDYS,dilnlazTotDutyNumDys);
        values.put(ATTR_DILNLAZWKLYHLDYNUMDYS,dilnlazWklyHldyNumDys);
        values.put(ATTR_DILNLAZPAIDPUBCHODYNUM,dilnlazPaidPubcHodyNum);
        values.put(ATTR_DILNLAZDDLNEPRCSYN,dilnlazDdlnePrcsYn);
        values.put(ATTR_DILNLAZNOTECTNT,dilnlazNoteCtnt);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_DILNLAZSPCLHODYNUMDYS,dilnlazSpclHodyNumDys);
        values.put(ATTR_DILNLAZSATDUTYNUMDYS,dilnlazSatDutyNumDys);
        values.put(ATTR_DILNLAZSATDUTYNUMDYS,dilnlazSatDutyNumDys);
//        values.put(ATTR_DILNLAZPUBCHODYDUTYNUMDYS,dilnlazPubcHodyDutyNumDys);
        values.put(ATTR_DILNLAZPUBCHODYDUTYTM,dilnlazPubcHodyDutyTm);
        values.put(ATTR_DILNLAZHODYTOTNTOTTM,dilnlazHodyTotNtotTm);
        values.put(ATTR_DILNLAZABNCEDUTYRCGTNDYS,dilnlazAbnceDutyRcgtnDys);
        values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
        values.put(ATTR_DILNLAZTOTDUTYTM,dilnlazTotDutyTm);
        values.put(ATTR_DILNLAZPAIDHODYNUMDYS,dilnlazPaidHodyNumDys);
        values.put(ATTR_DILNLAZTFCASSCSTNUMDYS,dilnlazTfcAssCstNumDys); 
        values.put(ATTR_DILNLAZWKDDUTYNUMDYS,dilnlazWkdDutyNumDys); } 
     
     
//    /** 일괄등록 처리   */
//     public Dlgn0200BM(
//             String  dpobCd 
//            , String  systemkey 
//            , String  dilnlazExceDutyYrMnth 
//            , String  payCd 
//            , String  emymtDivCd 
//            , String  deptCd 
//            , String  businCd 
//            , String  typOccuCd 
//            , String  dtilOccuClsDivCd 
//            , String  dilnlazExceDutyBgnnDt 
//            , String  dilnlazExceDutyEndDt 
//            , String  dilnlazPubcHodyDutyNumDys 
//            , String  dilnlazSatDutyNumDys 
//            , String  dilnlazTotNtotNumDys 
//            , String  dilnlazTotNtotTm 
//            , String  dilnlazFndtnTmRstDutyTm 
//            , String  dilnlazTmRstDutyTm 
//            , String  dilnlazTotTmRstDutyTm 
//            , String  dilnlazDdlnePrcsYn 
//            , String  dilnlazNoteCtnt 
//            , String  kybdr 
//            , String  inptDt 
//            , String  inptAddr 
//            , String  ismt 
//            , String  revnDt 
//            , String  revnAddr 
//            , String  pyspGrdeCd ) { 
//        values.put(ATTR_DPOBCD,dpobCd);
//        values.put(ATTR_SYSTEMKEY,systemkey);
//        values.put(ATTR_DILNLAZEXCEDUTYYRMNTH,dilnlazExceDutyYrMnth);
//        values.put(ATTR_PAYCD,payCd);
//        values.put(ATTR_EMYMTDIVCD,emymtDivCd);
//        values.put(ATTR_DEPTCD,deptCd);
//        values.put(ATTR_BUSINCD,businCd);
//        values.put(ATTR_TYPOCCUCD,typOccuCd);
//        values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
//        values.put(ATTR_DILNLAZEXCEDUTYBGNNDT,dilnlazExceDutyBgnnDt);
//        values.put(ATTR_DILNLAZEXCEDUTYENDDT,dilnlazExceDutyEndDt);
//        values.put(ATTR_DILNLAZPUBCHODYDUTYNUMDYS,dilnlazPubcHodyDutyNumDys);
//        values.put(ATTR_DILNLAZSATDUTYNUMDYS,dilnlazSatDutyNumDys);
//        values.put(ATTR_DILNLAZTOTNTOTNUMDYS,dilnlazTotNtotNumDys);
//        values.put(ATTR_DILNLAZTOTNTOTTM,dilnlazTotNtotTm);
//        values.put(ATTR_DILNLAZFNDTNTMRSTDUTYTM,dilnlazFndtnTmRstDutyTm);
//        values.put(ATTR_DILNLAZTMRSTDUTYTM,dilnlazTmRstDutyTm);
//        values.put(ATTR_DILNLAZTOTTMRSTDUTYTM,dilnlazTotTmRstDutyTm);
//        values.put(ATTR_DILNLAZDDLNEPRCSYN,dilnlazDdlnePrcsYn);
//        values.put(ATTR_DILNLAZNOTECTNT,dilnlazNoteCtnt);
//        values.put(ATTR_KYBDR,kybdr);
//        values.put(ATTR_INPTDT,inptDt);
//        values.put(ATTR_INPTADDR,inptAddr);
//        values.put(ATTR_ISMT,ismt);
//        values.put(ATTR_REVNDT,revnDt);
//        values.put(ATTR_REVNADDR,revnAddr);
//        values.put(ATTR_PYSPGRDECD,pyspGrdeCd); } 
 


     /** set 고용구분 : emymtDivNm */
     public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
     /** get 고용구분 : emymtDivNm */
     public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

     
     /** set 부서 : deptNm */
     public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
     /** get 부서 : deptNm  */
     public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

     /** set 사업 : businNm */
     public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
     /** get 사업 : businNm */
     public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}

     /** set 직종 : typOccuNm */
     public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
     /** get 직종 : typOccuNm */
     public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

     /** set 직종세 : dtilOccuClsDivNm */
     public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
     /** get 직종세 : dtilOccuClsDivNm */
     public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}

     /** set 직종세 : dtilOccuClsNm */
     public void setDtilOccuClsNm(String  dtilOccuClsNm) { set( ATTR_DTILOCCUCLSNM ,dtilOccuClsNm);}
     /** get 직종세 : dtilOccuClsNm */
     public String  getDtilOccuClsNm() { return (String )get( ATTR_DTILOCCUCLSNM );}
     
     /** set 직책 : odtyNm */
     public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
     /** get 직책 : odtyNm */
     public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}

     
     /** set 호봉등급 : pyspGrdeNm */
     public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
     /** get 호봉등급 : pyspGrdeNm */
     public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
     
     /** set 한글성명 : hanNm */
     public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
     /** get 한글성명 : hanNm */
     public String  getHanNm() { return (String )get( ATTR_HANNM );}

     /** set 주민등록번호 : resnRegnNum */
     public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
     /** get 주민등록번호 : resnRegnNum */
     public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
     
     
     /** set 주민등록번호 : secRegnNum */
     public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
     /** get 주민등록번호 : secRegnNum */
     public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
     
      
     
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 근태년월 : dilnlazYrMnth */
    public void setDilnlazYrMnth(String  dilnlazYrMnth) { set( ATTR_DILNLAZYRMNTH ,dilnlazYrMnth);}
    /** get 근태년월 : dilnlazYrMnth */
    public String  getDilnlazYrMnth() { return (String )get( ATTR_DILNLAZYRMNTH );}

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

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    
    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    public void setDilnlazDutyBgnnDt(String  dilnlazDutyBgnnDt) { set( ATTR_DILNLAZDUTYBGNNDT ,dilnlazDutyBgnnDt);}
    /** get 근태_근무시작일자 : dilnlazDutyBgnnDt */
    public String  getDilnlazDutyBgnnDt() { return (String )get( ATTR_DILNLAZDUTYBGNNDT );}

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    public void setDilnlazDutyEndDt(String  dilnlazDutyEndDt) { set( ATTR_DILNLAZDUTYENDDT ,dilnlazDutyEndDt);}
    /** get 근태_근무종료일자 : dilnlazDutyEndDt */
    public String  getDilnlazDutyEndDt() { return (String )get( ATTR_DILNLAZDUTYENDDT );}

    /** set 근태_근무일수 : dilnlazDutyNumDys */
    public void setDilnlazDutyNumDys(String  dilnlazDutyNumDys) { set( ATTR_DILNLAZDUTYNUMDYS ,dilnlazDutyNumDys);}
    /** get 근태_근무일수 : dilnlazDutyNumDys */
    public String  getDilnlazDutyNumDys() { return (String )get( ATTR_DILNLAZDUTYNUMDYS );}

    /** set 근태_연가일수 : dilnlazLvsgNumDys */
    public void setDilnlazLvsgNumDys(String  dilnlazLvsgNumDys) { set( ATTR_DILNLAZLVSGNUMDYS ,dilnlazLvsgNumDys);}
    /** get 근태_연가일수 : dilnlazLvsgNumDys */
    public String  getDilnlazLvsgNumDys() { return (String )get( ATTR_DILNLAZLVSGNUMDYS );}

    /** set 근태_결근일수 : dilnlazAbnceNumDys */
    public void setDilnlazAbnceNumDys(String  dilnlazAbnceNumDys) { set( ATTR_DILNLAZABNCENUMDYS ,dilnlazAbnceNumDys);}
    /** get 근태_결근일수 : dilnlazAbnceNumDys */
    public String  getDilnlazAbnceNumDys() { return (String )get( ATTR_DILNLAZABNCENUMDYS );}

    /** set 근태_병가일수 : dilnlazSckleaNumDys */
    public void setDilnlazSckleaNumDys(String  dilnlazSckleaNumDys) { set( ATTR_DILNLAZSCKLEANUMDYS ,dilnlazSckleaNumDys);}
    /** get 근태_병가일수 : dilnlazSckleaNumDys */
    public String  getDilnlazSckleaNumDys() { return (String )get( ATTR_DILNLAZSCKLEANUMDYS );}

    /** set 근태_공가일수 : dilnlazOffvaNumDys */
    public void setDilnlazOffvaNumDys(String  dilnlazOffvaNumDys) { set( ATTR_DILNLAZOFFVANUMDYS ,dilnlazOffvaNumDys);}
    /** get 근태_공가일수 : dilnlazOffvaNumDys */
    public String  getDilnlazOffvaNumDys() { return (String )get( ATTR_DILNLAZOFFVANUMDYS );}

    /** set 근태_경조사일수 : dilnlazFmlyEvntNumDys */
    public void setDilnlazFmlyEvntNumDys(String  dilnlazFmlyEvntNumDys) { set( ATTR_DILNLAZFMLYEVNTNUMDYS ,dilnlazFmlyEvntNumDys);}
    /** get 근태_경조사일수 : dilnlazFmlyEvntNumDys */
    public String  getDilnlazFmlyEvntNumDys() { return (String )get( ATTR_DILNLAZFMLYEVNTNUMDYS );}

    /** set 근태_보건일수 : dilnlazHlthCreNumDys */
    public void setDilnlazHlthCreNumDys(String  dilnlazHlthCreNumDys) { set( ATTR_DILNLAZHLTHCRENUMDYS ,dilnlazHlthCreNumDys);}
    /** get 근태_보건일수 : dilnlazHlthCreNumDys */
    public String  getDilnlazHlthCreNumDys() { return (String )get( ATTR_DILNLAZHLTHCRENUMDYS );}

    /** set 근태_총근무일수 : dilnlazTotDutyNumDys */
    public void setDilnlazTotDutyNumDys(String  dilnlazTotDutyNumDys) { set( ATTR_DILNLAZTOTDUTYNUMDYS ,dilnlazTotDutyNumDys);}
    /** get 근태_총근무일수 : dilnlazTotDutyNumDys */
    public String  getDilnlazTotDutyNumDys() { return (String )get( ATTR_DILNLAZTOTDUTYNUMDYS );}

    /** set 근태_주휴일수 : dilnlazWklyHldyNumDys */
    public void setDilnlazWklyHldyNumDys(String  dilnlazWklyHldyNumDys) { set( ATTR_DILNLAZWKLYHLDYNUMDYS ,dilnlazWklyHldyNumDys);}
    /** get 근태_주휴일수 : dilnlazWklyHldyNumDys */
    public String  getDilnlazWklyHldyNumDys() { return (String )get( ATTR_DILNLAZWKLYHLDYNUMDYS );}

    /** set 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
    public void setDilnlazPaidPubcHodyNum(String  dilnlazPaidPubcHodyNum) { set( ATTR_DILNLAZPAIDPUBCHODYNUM ,dilnlazPaidPubcHodyNum);}
    /** get 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
    public String  getDilnlazPaidPubcHodyNum() { return (String )get( ATTR_DILNLAZPAIDPUBCHODYNUM );}

    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    public void setDilnlazDdlnePrcsYn(String  dilnlazDdlnePrcsYn) { set( ATTR_DILNLAZDDLNEPRCSYN ,dilnlazDdlnePrcsYn);}
    /** get 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    public String  getDilnlazDdlnePrcsYn() { return (String )get( ATTR_DILNLAZDDLNEPRCSYN );}

    /** set 근태_비고내용 : dilnlazNoteCtnt */
    public void setDilnlazNoteCtnt(String  dilnlazNoteCtnt) { set( ATTR_DILNLAZNOTECTNT ,dilnlazNoteCtnt);}
    /** get 근태_비고내용 : dilnlazNoteCtnt */
    public String  getDilnlazNoteCtnt() { return (String )get( ATTR_DILNLAZNOTECTNT );}

    

    /** set 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
    public void setDilnlazSpclHodyNumDys(String  dilnlazSpclHodyNumDys) { set( ATTR_DILNLAZSPCLHODYNUMDYS ,dilnlazSpclHodyNumDys);}
    /** get 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
    public String  getDilnlazSpclHodyNumDys() { return (String )get( ATTR_DILNLAZSPCLHODYNUMDYS );}

    /** set 총토요근무일수 : dilnlazSatDutyNumDys */
    public void setDilnlazSatDutyNumDys(String  dilnlazSatDutyNumDys) { set( ATTR_DILNLAZSATDUTYNUMDYS ,dilnlazSatDutyNumDys);}
    /** get 총토요근무일수 : dilnlazSatDutyNumDys */
    public String  getDilnlazSatDutyNumDys() { return (String )get( ATTR_DILNLAZSATDUTYNUMDYS );}
    
    /** set 휴일일수 : dilnlazHodyDutyNumDys */
    public void setDilnlazHodyDutyNumDys(String  dilnlazHodyDutyNumDys) { set( ATTR_DILNLAZHODYDUTYNUMDYS ,dilnlazHodyDutyNumDys);}
    /** get 휴일일수 : dilnlazHodyDutyNumDys */
    public String  getDilnlazHodyDutyNumDys() { return (String )get( ATTR_DILNLAZHODYDUTYNUMDYS );}

    /** set 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public void setDilnlazPubcHodyDutyNumDys(String  dilnlazPubcHodyDutyNumDys) { set( ATTR_DILNLAZPUBCHODYDUTYNUMDYS ,dilnlazPubcHodyDutyNumDys);}
    /** get 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    public String  getDilnlazPubcHodyDutyNumDys() { return (String )get( ATTR_DILNLAZPUBCHODYDUTYNUMDYS );}
    
    /** set 총휴일근무시간 : dilnlazPubcHodyDutyTm */
    public void setDilnlazPubcHodyDutyTm(String  dilnlazPubcHodyDutyTm) { set( ATTR_DILNLAZPUBCHODYDUTYTM ,dilnlazPubcHodyDutyTm);}
    /** get 총휴일근무시간 : dilnlazHodyDutyTm */
    public String  getDilnlazPubcHodyDutyTm() { return (String )get( ATTR_DILNLAZPUBCHODYDUTYTM );}
    
    /** set 총휴일연장시간 : dilnlazHodyTotNtotTm */
    public void setDilnlazHodyTotNtotTm(String  dilnlazHodyTotNtotTm) { set( ATTR_DILNLAZHODYTOTNTOTTM ,dilnlazHodyTotNtotTm);}
    /** get 총휴일연장시간 : dilnlazHodyTotNtotTm */
    public String  getDilnlazHodyTotNtotTm() { return (String )get( ATTR_DILNLAZHODYTOTNTOTTM );}

    /** set 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
    public void setDilnlazAbnceDutyRcgtnDys(String  dilnlazAbnceDutyRcgtnDys) { set( ATTR_DILNLAZABNCEDUTYRCGTNDYS ,dilnlazAbnceDutyRcgtnDys);}
    /** get 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
    public String  getDilnlazAbnceDutyRcgtnDys() { return (String )get( ATTR_DILNLAZABNCEDUTYRCGTNDYS );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 근태_총근무시간 : dilnlazTotDutyTm */
    public void setDilnlazTotDutyTm(String  dilnlazTotDutyTm) { set( ATTR_DILNLAZTOTDUTYTM ,dilnlazTotDutyTm);}
    /** get 근태_총근무시간 : dilnlazTotDutyTm */
    public String  getDilnlazTotDutyTm() { return (String )get( ATTR_DILNLAZTOTDUTYTM );}

    /** set 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
    public void setDilnlazPaidHodyNumDys(String  dilnlazPaidHodyNumDys) { set( ATTR_DILNLAZPAIDHODYNUMDYS ,dilnlazPaidHodyNumDys);}
    /** get 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
    public String  getDilnlazPaidHodyNumDys() { return (String )get( ATTR_DILNLAZPAIDHODYNUMDYS );}

    /** set 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
    public void setDilnlazTfcAssCstNumDys(String  dilnlazTfcAssCstNumDys) { set( ATTR_DILNLAZTFCASSCSTNUMDYS ,dilnlazTfcAssCstNumDys);}
    /** get 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
    public String  getDilnlazTfcAssCstNumDys() { return (String )get( ATTR_DILNLAZTFCASSCSTNUMDYS );}

    
 
    /** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public void setDilnlazExceDutyBgnnDt(String  dilnlazExceDutyBgnnDt) { set( ATTR_DILNLAZEXCEDUTYBGNNDT ,dilnlazExceDutyBgnnDt);}
    /** get 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    public String  getDilnlazExceDutyBgnnDt() { return (String )get( ATTR_DILNLAZEXCEDUTYBGNNDT );}

    /** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public void setDilnlazExceDutyEndDt(String  dilnlazExceDutyEndDt) { set( ATTR_DILNLAZEXCEDUTYENDDT ,dilnlazExceDutyEndDt);}
    /** get 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    public String  getDilnlazExceDutyEndDt() { return (String )get( ATTR_DILNLAZEXCEDUTYENDDT );}
 
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

    /** set 근태_급식비일수 : dilnlazLnchDys */
    public void setDilnlazLnchDys(String  dilnlazLnchDys) { set( ATTR_DILNLAZLNCHDYS ,dilnlazLnchDys);}
    /** get 근태_급식비일수 : dilnlazLnchDys */
    public String  getDilnlazLnchDys() { return (String )get( ATTR_DILNLAZLNCHDYS );}
    
    /** set 평일근무일수 : dilnlazWkdDutyNumDys */
    public void setDilnlazWkdDutyNumDys(String  dilnlazWkdDutyNumDys) { set( ATTR_DILNLAZWKDDUTYNUMDYS ,dilnlazWkdDutyNumDys);}
    /** get 평일근무일수 : dilnlazWkdDutyNumDys */
    public String  getDilnlazWkdDutyNumDys() { return (String )get( ATTR_DILNLAZWKDDUTYNUMDYS );}
    
	/** set 복무통합구분값 : typOccuBusinVal */
    public void setTypOccuBusinVal(String  typOccuBusinVal) { set( ATTR_TYPOCCUBUSINVAL ,typOccuBusinVal);}
    /** get 복무통합구분값 : typOccuBusinVal */
    public String  getTypOccuBusinVal() { return (String )get( ATTR_TYPOCCUBUSINVAL );}
}
