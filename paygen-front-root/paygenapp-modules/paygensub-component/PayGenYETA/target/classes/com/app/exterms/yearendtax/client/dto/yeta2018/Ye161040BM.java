package com.app.exterms.yearendtax.client.dto.yeta2018;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @Class Name : Ye161040BM.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161040BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호 : txprDscmNoCntn */
    public static final String ATTR_TXPRDSCMNOCNTN = "txprDscmNoCntn";

    /** set 소득공제명세자료구분코드 : cdVvalKrnCd */
    public static final String ATTR_CDVVALKRNCD = "cdVvalKrnCd";

    /** set 건강등보험료 : hifeDdcTrgtAmt */
    public static final String ATTR_HIFEDDCTRGTAMT = "hifeDdcTrgtAmt";

    /** set 고용보험료 : mcurUiTrgtAmt */
    public static final String ATTR_MCURUITRGTAMT = "mcurUiTrgtAmt";

    /** set 보장성보험료 : cvrgInscDdcTrgtAmt */
    public static final String ATTR_CVRGINSCDDCTRGTAMT = "cvrgInscDdcTrgtAmt";

    /** set 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
    public static final String ATTR_DSBRDDCTRGTAMT = "dsbrDdcTrgtAmt";

    /** set 의료비금액 : mdxpsDdcTrgtAmt */
    public static final String ATTR_MDXPSDDCTRGTAMT = "mdxpsDdcTrgtAmt";

    /** set 교육비금액 : scxpsDdcTrgtAmt */
    public static final String ATTR_SCXPSDDCTRGTAMT = "scxpsDdcTrgtAmt";

    /** set 신용카드_전통대중도서제외금액 : crdcDdcTrgtAmt */
    public static final String ATTR_CRDCDDCTRGTAMT = "crdcDdcTrgtAmt";

    /** set 직불카드등_전통대중도서제외금액 : drtpCardDdcTrgtAmt */
    public static final String ATTR_DRTPCARDDDCTRGTAMT = "drtpCardDdcTrgtAmt";

    /** set 현금영수증_전통대중도서제외금액 : cshptDdcTrgtAmt */
    public static final String ATTR_CSHPTDDCTRGTAMT = "cshptDdcTrgtAmt";

    /** set 전통시작사용금액 : tdmrDdcTrgtAmt */
    public static final String ATTR_TDMRDDCTRGTAMT = "tdmrDdcTrgtAmt";

    /** set 대중교통이용금액 : pbtDdcTrgtAmt */
    public static final String ATTR_PBTDDCTRGTAMT = "pbtDdcTrgtAmt";

    /** set 도서이용금액 : bookShowAmt */
    public static final String ATTR_BOOKSHOWAMT = "bookShowAmt";
    
    /** set 기부금액 : conbDdcTrgtAmt */
    public static final String ATTR_CONBDDCTRGTAMT = "conbDdcTrgtAmt";

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

    /** 생성자 */
     public Ye161040BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161040BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  txprDscmNoCntn 
    		, String  cdVvalKrnCd 
    		, Long  hifeDdcTrgtAmt 
    		, Long  cvrgInscDdcTrgtAmt 
    		, Long  dsbrDdcTrgtAmt 
    		, Long  mdxpsDdcTrgtAmt 
    		, Long  scxpsDdcTrgtAmt 
    		, Long  crdcDdcTrgtAmt 
    		, Long  drtpCardDdcTrgtAmt 
    		, Long  cshptDdcTrgtAmt 
    		, Long  bookShowAmt
    		, Long  tdmrDdcTrgtAmt 
    		, Long  pbtDdcTrgtAmt 
    		, Long  conbDdcTrgtAmt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_TXPRDSCMNOCNTN,txprDscmNoCntn);
     	values.put(ATTR_CDVVALKRNCD,cdVvalKrnCd);
     	values.put(ATTR_HIFEDDCTRGTAMT,hifeDdcTrgtAmt);
     	values.put(ATTR_CVRGINSCDDCTRGTAMT,cvrgInscDdcTrgtAmt);
     	values.put(ATTR_DSBRDDCTRGTAMT,dsbrDdcTrgtAmt);
     	values.put(ATTR_MDXPSDDCTRGTAMT,mdxpsDdcTrgtAmt);
     	values.put(ATTR_SCXPSDDCTRGTAMT,scxpsDdcTrgtAmt);
     	values.put(ATTR_CRDCDDCTRGTAMT,crdcDdcTrgtAmt);
     	values.put(ATTR_DRTPCARDDDCTRGTAMT,drtpCardDdcTrgtAmt);
     	values.put(ATTR_CSHPTDDCTRGTAMT,cshptDdcTrgtAmt);
     	values.put(ATTR_BOOKSHOWAMT,bookShowAmt);
     	values.put(ATTR_TDMRDDCTRGTAMT,tdmrDdcTrgtAmt);
     	values.put(ATTR_PBTDDCTRGTAMT,pbtDdcTrgtAmt);
     	values.put(ATTR_CONBDDCTRGTAMT,conbDdcTrgtAmt);
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
    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 주민등록번호 : txprDscmNoCntn */
    public void setTxprDscmNoCntn(String  txprDscmNoCntn) { set( ATTR_TXPRDSCMNOCNTN ,txprDscmNoCntn);}
    /** get 주민등록번호 : txprDscmNoCntn */
    public String  getTxprDscmNoCntn() { return (String )get( ATTR_TXPRDSCMNOCNTN );}
    /** set 소득공제명세자료구분코드 : cdVvalKrnCd */
    public void setCdVvalKrnCd(String  cdVvalKrnCd) { set( ATTR_CDVVALKRNCD ,cdVvalKrnCd);}
    /** get 소득공제명세자료구분코드 : cdVvalKrnCd */
    public String  getCdVvalKrnCd() { return (String )get( ATTR_CDVVALKRNCD );}
    /** set 건강등보험료 : hifeDdcTrgtAmt */
    public void setHifeDdcTrgtAmt(Long  hifeDdcTrgtAmt) { set( ATTR_HIFEDDCTRGTAMT ,hifeDdcTrgtAmt);}
    /** get 건강등보험료 : hifeDdcTrgtAmt */
    public Long  getHifeDdcTrgtAmt() { return (Long )get( ATTR_HIFEDDCTRGTAMT );}
    /** set 고용보험료 : mcurUiTrgtAmt */
    public void setMcurUiTrgtAmt(Long  mcurUiTrgtAmt) { set( ATTR_MCURUITRGTAMT ,mcurUiTrgtAmt);}
    /** get 고용보험료 : mcurUiTrgtAmt */
    public Long  getMcurUiTrgtAmt() { return (Long )get( ATTR_MCURUITRGTAMT );}
    /** set 보장성보험료 : cvrgInscDdcTrgtAmt */
    public void setCvrgInscDdcTrgtAmt(Long  cvrgInscDdcTrgtAmt) { set( ATTR_CVRGINSCDDCTRGTAMT ,cvrgInscDdcTrgtAmt);}
    /** get 보장성보험료 : cvrgInscDdcTrgtAmt */
    public Long  getCvrgInscDdcTrgtAmt() { return (Long )get( ATTR_CVRGINSCDDCTRGTAMT );}
    /** set 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
    public void setDsbrDdcTrgtAmt(Long  dsbrDdcTrgtAmt) { set( ATTR_DSBRDDCTRGTAMT ,dsbrDdcTrgtAmt);}
    /** get 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
    public Long  getDsbrDdcTrgtAmt() { return (Long )get( ATTR_DSBRDDCTRGTAMT );}
    /** set 의료비금액 : mdxpsDdcTrgtAmt */
    public void setMdxpsDdcTrgtAmt(Long  mdxpsDdcTrgtAmt) { set( ATTR_MDXPSDDCTRGTAMT ,mdxpsDdcTrgtAmt);}
    /** get 의료비금액 : mdxpsDdcTrgtAmt */
    public Long  getMdxpsDdcTrgtAmt() { return (Long )get( ATTR_MDXPSDDCTRGTAMT );}
    /** set 교육비금액 : scxpsDdcTrgtAmt */
    public void setScxpsDdcTrgtAmt(Long  scxpsDdcTrgtAmt) { set( ATTR_SCXPSDDCTRGTAMT ,scxpsDdcTrgtAmt);}
    /** get 교육비금액 : scxpsDdcTrgtAmt */
    public Long  getScxpsDdcTrgtAmt() { return (Long )get( ATTR_SCXPSDDCTRGTAMT );}
    /** set 신용카드_전통대중도서제외금액 : crdcDdcTrgtAmt */
    public void setCrdcDdcTrgtAmt(Long  crdcDdcTrgtAmt) { set( ATTR_CRDCDDCTRGTAMT ,crdcDdcTrgtAmt);}
    /** get 신용카드_전통대중도서제외금액 : crdcDdcTrgtAmt */
    public Long  getCrdcDdcTrgtAmt() { return (Long )get( ATTR_CRDCDDCTRGTAMT );}
    /** set 직불카드등_전통대중도서제외금액 : drtpCardDdcTrgtAmt */
    public void setDrtpCardDdcTrgtAmt(Long  drtpCardDdcTrgtAmt) { set( ATTR_DRTPCARDDDCTRGTAMT ,drtpCardDdcTrgtAmt);}
    /** get 직불카드등_전통대중도서제외금액 : drtpCardDdcTrgtAmt */
    public Long  getDrtpCardDdcTrgtAmt() { return (Long )get( ATTR_DRTPCARDDDCTRGTAMT );}
    /** set 현금영수증_전통대중도서제외금액 : cshptDdcTrgtAmt */
    public void setCshptDdcTrgtAmt(Long  cshptDdcTrgtAmt) { set( ATTR_CSHPTDDCTRGTAMT ,cshptDdcTrgtAmt);}
    /** get 현금영수증_전통대중도서제외금액 : cshptDdcTrgtAmt */
    public Long  getCshptDdcTrgtAmt() { return (Long )get( ATTR_CSHPTDDCTRGTAMT );}
    /** set 전통시작사용금액 : tdmrDdcTrgtAmt */
    public void setTdmrDdcTrgtAmt(Long  tdmrDdcTrgtAmt) { set( ATTR_TDMRDDCTRGTAMT ,tdmrDdcTrgtAmt);}
    /** get 전통시작사용금액 : tdmrDdcTrgtAmt */
    public Long  getTdmrDdcTrgtAmt() { return (Long )get( ATTR_TDMRDDCTRGTAMT );}
    /** set 대중교통이용금액 : pbtDdcTrgtAmt */
    public void setPbtDdcTrgtAmt(Long  pbtDdcTrgtAmt) { set( ATTR_PBTDDCTRGTAMT ,pbtDdcTrgtAmt);}
    /** get 대중교통이용금액 : pbtDdcTrgtAmt */
    public Long  getPbtDdcTrgtAmt() { return (Long )get( ATTR_PBTDDCTRGTAMT );}
    /** set 도서이용금액 : bookShowAmt */
    public void setBookShowAmt(Long  bookShowAmt) { set( ATTR_BOOKSHOWAMT ,bookShowAmt);}
    /** get 도서이용금액 : bookShowAmt */
    public Long  getBookShowAmt() { return (Long )get( ATTR_BOOKSHOWAMT );}
    /** set 기부금액 : conbDdcTrgtAmt */
    public void setConbDdcTrgtAmt(Long  conbDdcTrgtAmt) { set( ATTR_CONBDDCTRGTAMT ,conbDdcTrgtAmt);}
    /** get 기부금액 : conbDdcTrgtAmt */
    public Long  getConbDdcTrgtAmt() { return (Long )get( ATTR_CONBDDCTRGTAMT );}
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

 
}
