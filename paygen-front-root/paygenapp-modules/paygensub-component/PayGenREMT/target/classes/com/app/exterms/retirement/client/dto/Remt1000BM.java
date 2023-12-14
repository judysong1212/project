package com.app.exterms.retirement.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt1000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
    public static final String ATTR_SEVEPAYADDRATESEILNUM = "sevePayAddRateSeilNum";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTIL_OCCU_CLS_DIV_CD = "dtilOccuClsDivCd";

    /** set 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
    public static final String ATTR_SEVEPAYADDRATEFRMCD = "sevePayAddRateFrmCd";

    /** set 퇴직금가산이상 : sevePayAddOvr */
    public static final String ATTR_SEVEPAYADDOVR = "sevePayAddOvr";

    /** set 퇴직금가산미만 : sevePayAddUdr */
    public static final String ATTR_SEVEPAYADDUDR = "sevePayAddUdr";

    /** set 퇴직금가산금액 : sevePayAddSum */
    public static final String ATTR_SEVEPAYADDSUM = "sevePayAddSum";

    /** set 퇴직금가산율 : sevePayAddRate */
    public static final String ATTR_SEVEPAYADDRATE = "sevePayAddRate";

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    public static final String ATTR_SEVEPAYNOTECTNT = "sevePayNoteCtnt";

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
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";


/** set 직종세 : dtilOccuClsDivNm */
public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";

                      

/** set 퇴직금가산시작일자 : sevePayAddBgnnDt */
public static final String ATTR_SEVEPAYADDBGNNDT = "sevePayAddBgnnDt";

/** set 퇴직금가산종료일자 : sevePayAddEndDt */
public static final String ATTR_SEVEPAYADDENDDT = "sevePayAddEndDt";

/** set 퇴직금가산사용여부 : sevePayAddUseYn */
public static final String ATTR_SEVEPAYADDUSEYN = "sevePayAddUseYn";

    /** 생성자 */
     public Remt1000BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt1000BM(
             String  dpobCd 
            , BigDecimal  sevePayAddRateSeilNum 
            , String  typOccuCd 
            , String  pyspGrdeCd 
            , String  sevePayAddRateFrmCd 
            , String  sevePayAddOvr 
            , String  sevePayAddUdr 
            , BigDecimal  sevePayAddSum 
            , String  sevePayAddRate 
            , String  sevePayNoteCtnt 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SEVEPAYADDRATESEILNUM,sevePayAddRateSeilNum);
        values.put(ATTR_TYPOCCUCD,typOccuCd);
        values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
        values.put(ATTR_SEVEPAYADDRATEFRMCD,sevePayAddRateFrmCd);
        values.put(ATTR_SEVEPAYADDOVR,sevePayAddOvr);
        values.put(ATTR_SEVEPAYADDUDR,sevePayAddUdr);
        values.put(ATTR_SEVEPAYADDSUM,sevePayAddSum);
        values.put(ATTR_SEVEPAYADDRATE,sevePayAddRate);
        values.put(ATTR_SEVEPAYNOTECTNT,sevePayNoteCtnt);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
    public void setSevePayAddRateSeilNum(BigDecimal  sevePayAddRateSeilNum) { set( ATTR_SEVEPAYADDRATESEILNUM ,sevePayAddRateSeilNum);}
    /** get 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
    public BigDecimal  getSevePayAddRateSeilNum() { return (BigDecimal )get( ATTR_SEVEPAYADDRATESEILNUM );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
    public void setSevePayAddRateFrmCd(String  sevePayAddRateFrmCd) { set( ATTR_SEVEPAYADDRATEFRMCD ,sevePayAddRateFrmCd);}
    /** get 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
    public String  getSevePayAddRateFrmCd() { return (String )get( ATTR_SEVEPAYADDRATEFRMCD );}

    /** set 퇴직금가산이상 : sevePayAddOvr */
    public void setSevePayAddOvr(String  sevePayAddOvr) { set( ATTR_SEVEPAYADDOVR ,sevePayAddOvr);}
    /** get 퇴직금가산이상 : sevePayAddOvr */
    public String  getSevePayAddOvr() { return (String )get( ATTR_SEVEPAYADDOVR );}

    /** set 퇴직금가산미만 : sevePayAddUdr */
    public void setSevePayAddUdr(String  sevePayAddUdr) { set( ATTR_SEVEPAYADDUDR ,sevePayAddUdr);}
    /** get 퇴직금가산미만 : sevePayAddUdr */
    public String  getSevePayAddUdr() { return (String )get( ATTR_SEVEPAYADDUDR );}

    /** set 퇴직금가산금액 : sevePayAddSum */
    public void setSevePayAddSum(BigDecimal  sevePayAddSum) { set( ATTR_SEVEPAYADDSUM ,sevePayAddSum);}
    /** get 퇴직금가산금액 : sevePayAddSum */
    public BigDecimal  getSevePayAddSum() { return (BigDecimal )get( ATTR_SEVEPAYADDSUM );}

    /** set 퇴직금가산율 : sevePayAddRate */
    public void setSevePayAddRate(String  sevePayAddRate) { set( ATTR_SEVEPAYADDRATE ,sevePayAddRate);}
    /** get 퇴직금가산율 : sevePayAddRate */
    public String  getSevePayAddRate() { return (String )get( ATTR_SEVEPAYADDRATE );}

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    public void setSevePayNoteCtnt(String  sevePayNoteCtnt) { set( ATTR_SEVEPAYNOTECTNT ,sevePayNoteCtnt);}
    /** get 퇴직금비고내용 : sevePayNoteCtnt */
    public String  getSevePayNoteCtnt() { return (String )get( ATTR_SEVEPAYNOTECTNT );}

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


/** set 퇴직금가산시작일자 : sevePayAddBgnnDt */
public void setSevePayAddBgnnDt(String  sevePayAddBgnnDt) { set( ATTR_SEVEPAYADDBGNNDT ,sevePayAddBgnnDt);}
/** get 퇴직금가산시작일자 : sevePayAddBgnnDt */
public String  getSevePayAddBgnnDt() { return (String )get( ATTR_SEVEPAYADDBGNNDT );}

/** set 퇴직금가산종료일자 : sevePayAddEndDt */
public void setSevePayAddEndDt(String  sevePayAddEndDt) { set( ATTR_SEVEPAYADDENDDT ,sevePayAddEndDt);}
/** get 퇴직금가산종료일자 : sevePayAddEndDt */
public String  getSevePayAddEndDt() { return (String )get( ATTR_SEVEPAYADDENDDT );}

/** set 퇴직금가산사용여부 : sevePayAddUseYn */
public void setSevePayAddUseYn(Boolean  sevePayAddUseYn) { set( ATTR_SEVEPAYADDUSEYN ,sevePayAddUseYn);}
/** get 퇴직금가산사용여부 : sevePayAddUseYn */
public Boolean  getSevePayAddUseYn() { return (Boolean )get( ATTR_SEVEPAYADDUSEYN );}


/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

 
/** set 직종세 : dtilOccuClsDivNm */
public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
/** get 직종세 : dtilOccuClsDivNm */
public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}



}
