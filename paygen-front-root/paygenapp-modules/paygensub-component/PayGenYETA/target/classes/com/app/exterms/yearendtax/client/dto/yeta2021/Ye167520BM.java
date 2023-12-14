package com.app.exterms.yearendtax.client.dto.yeta2021;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye167520BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 신용카드등소득공제상세일련번호 : crdcSeilNum */
    public static final String ATTR_CRDCSEILNUM = "crdcSeilNum";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 공제대상자내외국인 : nnfCl */
    public static final String ATTR_NNFCL = "nnfCl";

    /** set 공제대상자관계 : suptFmlyRltCl */
    public static final String ATTR_SUPTFMLYRLTCL = "suptFmlyRltCl";

    /** set 공제대상자성명 : suptFmlyFnm */
    public static final String ATTR_SUPTFMLYFNM = "suptFmlyFnm";

    /** set 공제대상자생년월일 : suptFmlyBhdt */
    public static final String ATTR_SUPTFMLYBHDT = "suptFmlyBhdt";

    /** set 공제대상자가족주민등록번호 : famResnoEncCntn */
    public static final String ATTR_FAMRESNOENCCNTN = "famResnoEncCntn";

    /** set 자료구분 : dataCd */
    public static final String ATTR_DATACD = "dataCd";

    /** set 신용카드등사용금액소계 : crdcUseAmtSum */
    public static final String ATTR_CRDCUSEAMTSUM = "crdcUseAmtSum";

    /** set 신용카드등사용금액_신용카드 : crdcUseAmt */
    public static final String ATTR_CRDCUSEAMT = "crdcUseAmt";

    /** set 신용카드등사용금액_현금영수증 : cshptUseAmt */
    public static final String ATTR_CSHPTUSEAMT = "cshptUseAmt";

    /** set 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
    public static final String ATTR_DRTPCARDUSEAMT = "drtpCardUseAmt";

    /** set 신용카드등사용금액_제로페이 : zrtdUseAmt */
    public static final String ATTR_ZRTDUSEAMT = "zrtdUseAmt";

    /** set 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
    public static final String ATTR_TDMRUSEAMT = "tdmrUseAmt";

    /** set 신용카드등사용금액_대중교통이용분 : etcUseAmt */
    public static final String ATTR_ETCUSEAMT = "etcUseAmt";

    /** set 신용카드등사용금액_도서이용분 : bookShowAmt */
    public static final String ATTR_BOOKSHOWAMT = "bookShowAmt";

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
     public Ye167520BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167520BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, Long  crdcSeilNum 
    		, String  clutSeptCd 
    		, String  nnfCl 
    		, String  suptFmlyRltCl 
    		, String  suptFmlyFnm 
    		, String  suptFmlyBhdt 
    		, String  famResnoEncCntn 
    		, String  dataCd 
    		, Long  crdcUseAmtSum 
    		, Long  crdcUseAmt 
    		, Long  cshptUseAmt 
    		, Long  drtpCardUseAmt 
    		, Long	zrtdUseAmt
		 , Long  bookShowAmt 
    		, Long  tdmrUseAmt 
    		, Long  etcUseAmt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CRDCSEILNUM,crdcSeilNum);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_NNFCL,nnfCl);
     	values.put(ATTR_SUPTFMLYRLTCL,suptFmlyRltCl);
     	values.put(ATTR_SUPTFMLYFNM,suptFmlyFnm);
     	values.put(ATTR_SUPTFMLYBHDT,suptFmlyBhdt);
     	values.put(ATTR_FAMRESNOENCCNTN,famResnoEncCntn);
     	values.put(ATTR_DATACD,dataCd);
     	values.put(ATTR_CRDCUSEAMTSUM,crdcUseAmtSum);
     	values.put(ATTR_CRDCUSEAMT,crdcUseAmt);
     	values.put(ATTR_CSHPTUSEAMT,cshptUseAmt);
     	values.put(ATTR_DRTPCARDUSEAMT,drtpCardUseAmt);
     	values.put(ATTR_ZRTDUSEAMT,zrtdUseAmt);
		values.put(ATTR_BOOKSHOWAMT,bookShowAmt);
     	values.put(ATTR_TDMRUSEAMT,tdmrUseAmt);
     	values.put(ATTR_ETCUSEAMT,etcUseAmt);
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

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 신용카드등소득공제상세일련번호 : crdcSeilNum */
    public void setCrdcSeilNum(Long  crdcSeilNum) { set( ATTR_CRDCSEILNUM ,crdcSeilNum);}
    /** get 신용카드등소득공제상세일련번호 : crdcSeilNum */
    public Long  getCrdcSeilNum() { return (Long )get( ATTR_CRDCSEILNUM );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 공제대상자내외국인 : nnfCl */
    public void setNnfCl(String  nnfCl) { set( ATTR_NNFCL ,nnfCl);}
    /** get 공제대상자내외국인 : nnfCl */
    public String  getNnfCl() { return (String )get( ATTR_NNFCL );}

    /** set 공제대상자관계 : suptFmlyRltCl */
    public void setSuptFmlyRltCl(String  suptFmlyRltCl) { set( ATTR_SUPTFMLYRLTCL ,suptFmlyRltCl);}
    /** get 공제대상자관계 : suptFmlyRltCl */
    public String  getSuptFmlyRltCl() { return (String )get( ATTR_SUPTFMLYRLTCL );}

    /** set 공제대상자성명 : suptFmlyFnm */
    public void setSuptFmlyFnm(String  suptFmlyFnm) { set( ATTR_SUPTFMLYFNM ,suptFmlyFnm);}
    /** get 공제대상자성명 : suptFmlyFnm */
    public String  getSuptFmlyFnm() { return (String )get( ATTR_SUPTFMLYFNM );}

    /** set 공제대상자생년월일 : suptFmlyBhdt */
    public void setSuptFmlyBhdt(String  suptFmlyBhdt) { set( ATTR_SUPTFMLYBHDT ,suptFmlyBhdt);}
    /** get 공제대상자생년월일 : suptFmlyBhdt */
    public String  getSuptFmlyBhdt() { return (String )get( ATTR_SUPTFMLYBHDT );}

    /** set 공제대상자가족주민등록번호 : famResnoEncCntn */
    public void setFamResnoEncCntn(String  famResnoEncCntn) { set( ATTR_FAMRESNOENCCNTN ,famResnoEncCntn);}
    /** get 공제대상자가족주민등록번호 : famResnoEncCntn */
    public String  getFamResnoEncCntn() { return (String )get( ATTR_FAMRESNOENCCNTN );}

    /** set 자료구분 : dataCd */
    public void setDataCd(String  dataCd) { set( ATTR_DATACD ,dataCd);}
    /** get 자료구분 : dataCd */
    public String  getDataCd() { return (String )get( ATTR_DATACD );}

    /** set 신용카드등사용금액소계 : crdcUseAmtSum */
    public void setCrdcUseAmtSum(Long  crdcUseAmtSum) { set( ATTR_CRDCUSEAMTSUM ,crdcUseAmtSum);}
    /** get 신용카드등사용금액소계 : crdcUseAmtSum */
    public Long  getCrdcUseAmtSum() { return (Long )get( ATTR_CRDCUSEAMTSUM );}

    /** set 신용카드등사용금액_신용카드 : crdcUseAmt */
    public void setCrdcUseAmt(Long  crdcUseAmt) { set( ATTR_CRDCUSEAMT ,crdcUseAmt);}
    /** get 신용카드등사용금액_신용카드 : crdcUseAmt */
    public Long  getCrdcUseAmt() { return (Long )get( ATTR_CRDCUSEAMT );}

    /** set 신용카드등사용금액_현금영수증 : cshptUseAmt */
    public void setCshptUseAmt(Long  cshptUseAmt) { set( ATTR_CSHPTUSEAMT ,cshptUseAmt);}
    /** get 신용카드등사용금액_현금영수증 : cshptUseAmt */
    public Long  getCshptUseAmt() { return (Long )get( ATTR_CSHPTUSEAMT );}

    /** set 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
    public void setDrtpCardUseAmt(Long  drtpCardUseAmt) { set( ATTR_DRTPCARDUSEAMT ,drtpCardUseAmt);}
    /** get 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
    public Long  getDrtpCardUseAmt() { return (Long )get( ATTR_DRTPCARDUSEAMT );}

    /** set 신용카드등사용금액_제로페이 : zrtdUseAmt */
    public void setZrtdUseAmt(Long  zrtdUseAmt) { set( ATTR_ZRTDUSEAMT ,zrtdUseAmt);}
    /** get 신용카드등사용금액_제로페이 : zrtdUseAmt */
    public Long  getZrtdUseAmt() { return (Long )get( ATTR_ZRTDUSEAMT );}

    /** set 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
    public void setTdmrUseAmt(Long  tdmrUseAmt) { set( ATTR_TDMRUSEAMT ,tdmrUseAmt);}
    /** get 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
    public Long  getTdmrUseAmt() { return (Long )get( ATTR_TDMRUSEAMT );}

    /** set 신용카드등사용금액_대중교통이용분 : etcUseAmt */
    public void setEtcUseAmt(Long  etcUseAmt) { set( ATTR_ETCUSEAMT ,etcUseAmt);}
    /** get 신용카드등사용금액_대중교통이용분 : etcUseAmt */
    public Long  getEtcUseAmt() { return (Long )get( ATTR_ETCUSEAMT );}

    /** set 도서이용금액 : bookShowAmt */
    public void setBookShowAmt(Long  bookShowAmt) { set( ATTR_BOOKSHOWAMT ,bookShowAmt);}
    /** get 도서이용금액 : bookShowAmt */
    public Long  getBookShowAmt() { return (Long )get( ATTR_BOOKSHOWAMT );}

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
