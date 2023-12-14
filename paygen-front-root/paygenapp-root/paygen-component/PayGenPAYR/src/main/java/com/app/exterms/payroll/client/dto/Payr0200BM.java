package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0200VO.java
 * @Description : Payr0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0200BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 공제구분코드 : dducDivCd */
    public static final String ATTR_DDUCDIVCD = "dducDivCd";


    /** set 공제구분 : dducDivNm */
    public static final String ATTR_DDUCDIVNM = "dducDivNm";

    
    /** set null : dducSeilNum */
    public static final String ATTR_DDUCSEILNUM = "dducSeilNum";

    /** set 공제금액 : dducSum */
    public static final String ATTR_DDUCSUM = "dducSum";

    /** set 공제비율구분코드 : dducRtoDivCd */
    public static final String ATTR_DDUCRTODIVCD = "dducRtoDivCd";


    /** set 공제비율구분 : dducRtoDivNm */
    public static final String ATTR_DDUCRTODIVNM = "dducRtoDivNm";

    
    /** set 공제비율 : dducRto */
    public static final String ATTR_DDUCRTO = "dducRto";

    /** set 기타공제시작일자 : etcDducBgnnDt */
    public static final String ATTR_ETCDDUCBGNNDT = "etcDducBgnnDt";

    /** set 기타공제종료일자 : etcDducEndDt */
    public static final String ATTR_ETCDDUCENDDT = "etcDducEndDt";

    /** set 기타공제비고내용 : etcDducNoteCtnt */
    public static final String ATTR_ETCDDUCNOTECTNT = "etcDducNoteCtnt";

    /** set null : dducDelYn */
    public static final String ATTR_DDUCDELYN = "dducDelYn";

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

   /** 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";
    
    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";


/** set 직종세 : dtilOccuClsDivNm */
public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";

          
    /** 생성자 */
     public Payr0200BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0200BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  dducDivCd 
    		, BigDecimal  dducSeilNum 
    		, BigDecimal  dducSum 
    		, String  dducRtoDivCd 
    		, BigDecimal  dducRto 
    		, String  etcDducBgnnDt 
    		, String  etcDducEndDt 
    		, String  etcDducNoteCtnt 
    		, String  dducDelYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DDUCDIVCD,dducDivCd);
     	values.put(ATTR_DDUCSEILNUM,dducSeilNum);
     	values.put(ATTR_DDUCSUM,dducSum);
     	values.put(ATTR_DDUCRTODIVCD,dducRtoDivCd);
     	values.put(ATTR_DDUCRTO,dducRto);
     	values.put(ATTR_ETCDDUCBGNNDT,etcDducBgnnDt);
     	values.put(ATTR_ETCDDUCENDDT,etcDducEndDt);
     	values.put(ATTR_ETCDDUCNOTECTNT,etcDducNoteCtnt);
     	values.put(ATTR_DDUCDELYN,dducDelYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

     
     /** set 호봉등급 : pyspGrdeNm */
     public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
     /** get 호봉등급 : pyspGrdeNm */
     public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

     

     /** set 고용구분코드 : emymtDivCd */
     public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
     /** get 고용구분코드 : emymtDivCd */
     public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
     

     /** set 고용구분 : emymtDivNm */
     public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
     /** get 고용구분 : emymtDivNm */
     public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

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

     
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 공제구분코드 : dducDivCd */
    public void setDducDivCd(String  dducDivCd) { set( ATTR_DDUCDIVCD ,dducDivCd);}
    /** get 공제구분코드 : dducDivCd */
    public String  getDducDivCd() { return (String )get( ATTR_DDUCDIVCD );}

    /** set null : dducSeilNum */
    public void setDducSeilNum(BigDecimal  dducSeilNum) { set( ATTR_DDUCSEILNUM ,dducSeilNum);}
    /** get null : dducSeilNum */
    public BigDecimal  getDducSeilNum() { return (BigDecimal )get( ATTR_DDUCSEILNUM );}

    /** set 공제금액 : dducSum */
    public void setDducSum(BigDecimal  dducSum) { set( ATTR_DDUCSUM ,dducSum);}
    /** get 공제금액 : dducSum */
    public BigDecimal  getDducSum() { return (BigDecimal )get( ATTR_DDUCSUM );}

    /** set 공제비율구분코드 : dducRtoDivCd */
    public void setDducRtoDivCd(String  dducRtoDivCd) { set( ATTR_DDUCRTODIVCD ,dducRtoDivCd);}
    /** get 공제비율구분코드 : dducRtoDivCd */
    public String  getDducRtoDivCd() { return (String )get( ATTR_DDUCRTODIVCD );}
 
    /** set 공제비율구분 : dducRtoDivNm */
    public void setDducRtoDivNm(String  dducRtoDivNm) { set( ATTR_DDUCRTODIVNM ,dducRtoDivNm);}
    /** get 공제비율구분 : dducRtoDivNm */
    public String  getDducRtoDivNm() { return (String )get( ATTR_DDUCRTODIVNM );}

    
    
    /** set 공제비율 : dducRto */
    public void setDducRto(BigDecimal  dducRto) { set( ATTR_DDUCRTO ,dducRto);}
    /** get 공제비율 : dducRto */
    public BigDecimal  getDducRto() { return (BigDecimal )get( ATTR_DDUCRTO );}

    /** set 기타공제시작일자 : etcDducBgnnDt */
    public void setEtcDducBgnnDt(String  etcDducBgnnDt) { set( ATTR_ETCDDUCBGNNDT ,etcDducBgnnDt);}
    /** get 기타공제시작일자 : etcDducBgnnDt */
    public String  getEtcDducBgnnDt() { return (String )get( ATTR_ETCDDUCBGNNDT );}

    /** set 기타공제종료일자 : etcDducEndDt */
    public void setEtcDducEndDt(String  etcDducEndDt) { set( ATTR_ETCDDUCENDDT ,etcDducEndDt);}
    /** get 기타공제종료일자 : etcDducEndDt */
    public String  getEtcDducEndDt() { return (String )get( ATTR_ETCDDUCENDDT );}

    /** set 기타공제비고내용 : etcDducNoteCtnt */
    public void setEtcDducNoteCtnt(String  etcDducNoteCtnt) { set( ATTR_ETCDDUCNOTECTNT ,etcDducNoteCtnt);}
    /** get 기타공제비고내용 : etcDducNoteCtnt */
    public String  getEtcDducNoteCtnt() { return (String )get( ATTR_ETCDDUCNOTECTNT );}

    /** set null : dducDelYn */
    public void setDducDelYn(String  dducDelYn) { set( ATTR_DDUCDELYN ,dducDelYn);}
    /** get null : dducDelYn */
    public String  getDducDelYn() { return (String )get( ATTR_DDUCDELYN );}

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
    

    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


/** set 직종세 : dtilOccuClsDivNm */
public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
/** get 직종세 : dtilOccuClsDivNm */
public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}


}
