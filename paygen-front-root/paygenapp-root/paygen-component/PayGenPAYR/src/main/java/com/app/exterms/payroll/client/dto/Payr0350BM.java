package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0350VO.java
 * @Description : Payr0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0350BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 소급년도 : reattyYr */
    public static final String ATTR_REATTYYR = "reattyYr";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public static final String ATTR_REATTYSTPDSPTYNUM = "reattyStpDsptyNum";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 소급적용금액_1월 : reattyApptnSumJan */
    public static final String ATTR_REATTYAPPTNSUMJAN = "reattyApptnSumJan";

    /** set 소급적용금액_2월 : reattyApptnSumFeb */
    public static final String ATTR_REATTYAPPTNSUMFEB = "reattyApptnSumFeb";

    /** set 소급적용금액_3월 : reattyApptnSumMar */
    public static final String ATTR_REATTYAPPTNSUMMAR = "reattyApptnSumMar";

    /** set 소급적용금액_4월 : reattyApptnSumApr */
    public static final String ATTR_REATTYAPPTNSUMAPR = "reattyApptnSumApr";

    /** set 소급적용금액_5월 : reattyApptnSumMay */
    public static final String ATTR_REATTYAPPTNSUMMAY = "reattyApptnSumMay";

    /** set 소급적용금액_6월 : reattyApptnSumJun */
    public static final String ATTR_REATTYAPPTNSUMJUN = "reattyApptnSumJun";

    /** set 소급적용금액_7월 : reattyApptnSumJul */
    public static final String ATTR_REATTYAPPTNSUMJUL = "reattyApptnSumJul";

    /** set 소급적용금액_8월 : reattyApptnSumAug */
    public static final String ATTR_REATTYAPPTNSUMAUG = "reattyApptnSumAug";

    /** set 소급적용금액_9월 : reattyApptnSumSep */
    public static final String ATTR_REATTYAPPTNSUMSEP = "reattyApptnSumSep";

    /** set 소급적용금액_10월 : reattyApptnSumOct */
    public static final String ATTR_REATTYAPPTNSUMOCT = "reattyApptnSumOct";

    /** set 소급적용금액_11월 : reattyApptnSumNov */
    public static final String ATTR_REATTYAPPTNSUMNOV = "reattyApptnSumNov";

    /** set 소급적용금액_12월 : reattyApptnSumDec */
    public static final String ATTR_REATTYAPPTNSUMDEC = "reattyApptnSumDec";

    /** set 소급적용금액합계 : reattyApptnSumAggr */
    public static final String ATTR_REATTYAPPTNSUMAGGR = "reattyApptnSumAggr";

    /** set 소급항목비고내용 : reattyItemNoteCtnt */
    public static final String ATTR_REATTYITEMNOTECTNT = "reattyItemNoteCtnt";

    /** set 소급적용년월 : reattyPymtYrMnth */
    public static final String ATTR_REATTYPYMTYRMNTH = "reattyPymtYrMnth";

    /** set 소급지급처리여부 : reattyPymtPrcsYn */
    public static final String ATTR_REATTYPYMTPRCSYN = "reattyPymtPrcsYn";

    /** set 소급마감일자 : reattyDdlneDt */
    public static final String ATTR_REATTYDDLNEDT = "reattyDdlneDt";

    /** set 소급마감여부 : reattyDdlneYn */
    public static final String ATTR_REATTYDDLNEYN = "reattyDdlneYn";

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
    

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public static final String ATTR_DTILOCCLSAPPTNUCSTSUM = "dtilOcclsApptnUcstSum";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
    

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
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
    

    /** set 호봉코드 : pyspNm */
    public static final String ATTR_PYSPNM = "pyspNm";
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    /** set 지급구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";


/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

 

    /** 생성자 */
     public Payr0350BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0350BM(
    		 String  dpobCd 
    		, String  reattyYr 
    		, String  payCd 
    		, String  reattyStpDsptyNum 
    		, String  systemkey 
    		, Long  reattyApptnSumJan 
    		, Long  reattyApptnSumFeb 
    		, Long  reattyApptnSumMar 
    		, Long  reattyApptnSumApr 
    		, Long  reattyApptnSumMay 
    		, Long  reattyApptnSumJun 
    		, Long  reattyApptnSumJul 
    		, Long  reattyApptnSumAug 
    		, Long  reattyApptnSumSep 
    		, Long  reattyApptnSumOct 
    		, Long  reattyApptnSumNov 
    		, Long  reattyApptnSumDec 
    		, Long  reattyApptnSumAggr 
    		, String  reattyItemNoteCtnt 
    		, String  reattyPymtYrMnth 
    		, String  reattyPymtPrcsYn 
    		, String  reattyDdlneDt 
    		, String  reattyDdlneYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_REATTYYR,reattyYr);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_REATTYSTPDSPTYNUM,reattyStpDsptyNum);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_REATTYAPPTNSUMJAN,reattyApptnSumJan);
     	values.put(ATTR_REATTYAPPTNSUMFEB,reattyApptnSumFeb);
     	values.put(ATTR_REATTYAPPTNSUMMAR,reattyApptnSumMar);
     	values.put(ATTR_REATTYAPPTNSUMAPR,reattyApptnSumApr);
     	values.put(ATTR_REATTYAPPTNSUMMAY,reattyApptnSumMay);
     	values.put(ATTR_REATTYAPPTNSUMJUN,reattyApptnSumJun);
     	values.put(ATTR_REATTYAPPTNSUMJUL,reattyApptnSumJul);
     	values.put(ATTR_REATTYAPPTNSUMAUG,reattyApptnSumAug);
     	values.put(ATTR_REATTYAPPTNSUMSEP,reattyApptnSumSep);
     	values.put(ATTR_REATTYAPPTNSUMOCT,reattyApptnSumOct);
     	values.put(ATTR_REATTYAPPTNSUMNOV,reattyApptnSumNov);
     	values.put(ATTR_REATTYAPPTNSUMDEC,reattyApptnSumDec);
     	values.put(ATTR_REATTYAPPTNSUMAGGR,reattyApptnSumAggr);
     	values.put(ATTR_REATTYITEMNOTECTNT,reattyItemNoteCtnt);
     	values.put(ATTR_REATTYPYMTYRMNTH,reattyPymtYrMnth);
     	values.put(ATTR_REATTYPYMTPRCSYN,reattyPymtPrcsYn);
     	values.put(ATTR_REATTYDDLNEDT,reattyDdlneDt);
     	values.put(ATTR_REATTYDDLNEYN,reattyDdlneYn);
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

    /** set 소급년도 : reattyYr */
    public void setReattyYr(String  reattyYr) { set( ATTR_REATTYYR ,reattyYr);}
    /** get 소급년도 : reattyYr */
    public String  getReattyYr() { return (String )get( ATTR_REATTYYR );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public void setReattyStpDsptyNum(String  reattyStpDsptyNum) { set( ATTR_REATTYSTPDSPTYNUM ,reattyStpDsptyNum);}
    /** get 소급설정회차번호 : reattyStpDsptyNum */
    public String  getReattyStpDsptyNum() { return (String )get( ATTR_REATTYSTPDSPTYNUM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 소급적용금액_1월 : reattyApptnSumJan */
    public void setReattyApptnSumJan(Long  reattyApptnSumJan) { set( ATTR_REATTYAPPTNSUMJAN ,reattyApptnSumJan);}
    /** get 소급적용금액_1월 : reattyApptnSumJan */
    public Long  getReattyApptnSumJan() { return (Long )get( ATTR_REATTYAPPTNSUMJAN );}

    /** set 소급적용금액_2월 : reattyApptnSumFeb */
    public void setReattyApptnSumFeb(Long  reattyApptnSumFeb) { set( ATTR_REATTYAPPTNSUMFEB ,reattyApptnSumFeb);}
    /** get 소급적용금액_2월 : reattyApptnSumFeb */
    public Long  getReattyApptnSumFeb() { return (Long )get( ATTR_REATTYAPPTNSUMFEB );}

    /** set 소급적용금액_3월 : reattyApptnSumMar */
    public void setReattyApptnSumMar(Long  reattyApptnSumMar) { set( ATTR_REATTYAPPTNSUMMAR ,reattyApptnSumMar);}
    /** get 소급적용금액_3월 : reattyApptnSumMar */
    public Long  getReattyApptnSumMar() { return (Long )get( ATTR_REATTYAPPTNSUMMAR );}

    /** set 소급적용금액_4월 : reattyApptnSumApr */
    public void setReattyApptnSumApr(Long  reattyApptnSumApr) { set( ATTR_REATTYAPPTNSUMAPR ,reattyApptnSumApr);}
    /** get 소급적용금액_4월 : reattyApptnSumApr */
    public Long  getReattyApptnSumApr() { return (Long )get( ATTR_REATTYAPPTNSUMAPR );}

    /** set 소급적용금액_5월 : reattyApptnSumMay */
    public void setReattyApptnSumMay(Long  reattyApptnSumMay) { set( ATTR_REATTYAPPTNSUMMAY ,reattyApptnSumMay);}
    /** get 소급적용금액_5월 : reattyApptnSumMay */
    public Long  getReattyApptnSumMay() { return (Long )get( ATTR_REATTYAPPTNSUMMAY );}

    /** set 소급적용금액_6월 : reattyApptnSumJun */
    public void setReattyApptnSumJun(Long  reattyApptnSumJun) { set( ATTR_REATTYAPPTNSUMJUN ,reattyApptnSumJun);}
    /** get 소급적용금액_6월 : reattyApptnSumJun */
    public Long  getReattyApptnSumJun() { return (Long )get( ATTR_REATTYAPPTNSUMJUN );}

    /** set 소급적용금액_7월 : reattyApptnSumJul */
    public void setReattyApptnSumJul(Long  reattyApptnSumJul) { set( ATTR_REATTYAPPTNSUMJUL ,reattyApptnSumJul);}
    /** get 소급적용금액_7월 : reattyApptnSumJul */
    public Long  getReattyApptnSumJul() { return (Long )get( ATTR_REATTYAPPTNSUMJUL );}

    /** set 소급적용금액_8월 : reattyApptnSumAug */
    public void setReattyApptnSumAug(Long  reattyApptnSumAug) { set( ATTR_REATTYAPPTNSUMAUG ,reattyApptnSumAug);}
    /** get 소급적용금액_8월 : reattyApptnSumAug */
    public Long  getReattyApptnSumAug() { return (Long )get( ATTR_REATTYAPPTNSUMAUG );}

    /** set 소급적용금액_9월 : reattyApptnSumSep */
    public void setReattyApptnSumSep(Long  reattyApptnSumSep) { set( ATTR_REATTYAPPTNSUMSEP ,reattyApptnSumSep);}
    /** get 소급적용금액_9월 : reattyApptnSumSep */
    public Long  getReattyApptnSumSep() { return (Long )get( ATTR_REATTYAPPTNSUMSEP );}

    /** set 소급적용금액_10월 : reattyApptnSumOct */
    public void setReattyApptnSumOct(Long  reattyApptnSumOct) { set( ATTR_REATTYAPPTNSUMOCT ,reattyApptnSumOct);}
    /** get 소급적용금액_10월 : reattyApptnSumOct */
    public Long  getReattyApptnSumOct() { return (Long )get( ATTR_REATTYAPPTNSUMOCT );}

    /** set 소급적용금액_11월 : reattyApptnSumNov */
    public void setReattyApptnSumNov(Long  reattyApptnSumNov) { set( ATTR_REATTYAPPTNSUMNOV ,reattyApptnSumNov);}
    /** get 소급적용금액_11월 : reattyApptnSumNov */
    public Long  getReattyApptnSumNov() { return (Long )get( ATTR_REATTYAPPTNSUMNOV );}

    /** set 소급적용금액_12월 : reattyApptnSumDec */
    public void setReattyApptnSumDec(Long  reattyApptnSumDec) { set( ATTR_REATTYAPPTNSUMDEC ,reattyApptnSumDec);}
    /** get 소급적용금액_12월 : reattyApptnSumDec */
    public Long  getReattyApptnSumDec() { return (Long )get( ATTR_REATTYAPPTNSUMDEC );}

    /** set 소급적용금액합계 : reattyApptnSumAggr */
    public void setReattyApptnSumAggr(Long  reattyApptnSumAggr) { set( ATTR_REATTYAPPTNSUMAGGR ,reattyApptnSumAggr);}
    /** get 소급적용금액합계 : reattyApptnSumAggr */
    public Long  getReattyApptnSumAggr() { return (Long )get( ATTR_REATTYAPPTNSUMAGGR );}

    /** set 소급항목비고내용 : reattyItemNoteCtnt */
    public void setReattyItemNoteCtnt(String  reattyItemNoteCtnt) { set( ATTR_REATTYITEMNOTECTNT ,reattyItemNoteCtnt);}
    /** get 소급항목비고내용 : reattyItemNoteCtnt */
    public String  getReattyItemNoteCtnt() { return (String )get( ATTR_REATTYITEMNOTECTNT );}

    /** set 소급적용년월 : reattyPymtYrMnth */
    public void setReattyPymtYrMnth(String  reattyPymtYrMnth) { set( ATTR_REATTYPYMTYRMNTH ,reattyPymtYrMnth);}
    /** get 소급적용년월 : reattyPymtYrMnth */
    public String  getReattyPymtYrMnth() { return (String )get( ATTR_REATTYPYMTYRMNTH );}

    /** set 소급지급처리여부 : reattyPymtPrcsYn */
    public void setReattyPymtPrcsYn(String  reattyPymtPrcsYn) { set( ATTR_REATTYPYMTPRCSYN ,reattyPymtPrcsYn);}
    /** get 소급지급처리여부 : reattyPymtPrcsYn */
    public String  getReattyPymtPrcsYn() { return (String )get( ATTR_REATTYPYMTPRCSYN );}

    /** set 소급마감일자 : reattyDdlneDt */
    public void setReattyDdlneDt(String  reattyDdlneDt) { set( ATTR_REATTYDDLNEDT ,reattyDdlneDt);}
    /** get 소급마감일자 : reattyDdlneDt */
    public String  getReattyDdlneDt() { return (String )get( ATTR_REATTYDDLNEDT );}

    /** set 소급마감여부 : reattyDdlneYn */
    public void setReattyDdlneYn(String  reattyDdlneYn) { set( ATTR_REATTYDDLNEYN ,reattyDdlneYn);}
    /** get 소급마감여부 : reattyDdlneYn */
    public String  getReattyDdlneYn() { return (String )get( ATTR_REATTYDDLNEYN );}

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
 

    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}

    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    

/** set 주민등록번호 : secRegnNum */
public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
/** get 주민등록번호 : secRegnNum */
public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}


/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
/** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public void setDtilOcclsApptnUcstSum(Long  dtilOcclsApptnUcstSum) { set( ATTR_DTILOCCLSAPPTNUCSTSUM ,dtilOcclsApptnUcstSum);}
/** get 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public Long  getDtilOcclsApptnUcstSum() { return (Long )get( ATTR_DTILOCCLSAPPTNUCSTSUM );}

}
