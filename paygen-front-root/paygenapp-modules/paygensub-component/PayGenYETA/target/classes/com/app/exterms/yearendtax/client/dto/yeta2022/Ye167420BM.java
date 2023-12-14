package com.app.exterms.yearendtax.client.dto.yeta2022;



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
public class Ye167420BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 기부금일련번호 : cnbtSeilNum */
    public static final String ATTR_CNBTSEILNUM = "cnbtSeilNum";

    /** set 기부유형 : conbCd */
    public static final String ATTR_CONBCD = "conbCd";

    /** set 기부코드 : conbNm */
    public static final String ATTR_CONBNM = "conbNm";

    /** set 기부자료구분코드 : yrsMateClCd */
    public static final String ATTR_YRSMATECLCD = "yrsMateClCd";

    /** set 기부내용 : dntcntn */
    public static final String ATTR_DNTCNTN = "dntcntn";

    /** set 기부처_상호명 : coplNm */
    public static final String ATTR_COPLNM = "coplNm";

    /** set 기부처_사업자등록번호 : bsnoEncCntn */
    public static final String ATTR_BSNOENCCNTN = "bsnoEncCntn";

    /** set 기부자관계코드 : cnbtRltClCd */
    public static final String ATTR_CNBTRLTCLCD = "cnbtRltClCd";

    /** set 기부자성명 : cnbtFnm */
    public static final String ATTR_CNBTFNM = "cnbtFnm";

    /** set 기부자_주민등록번호 : resnoEncCntn */
    public static final String ATTR_RESNOENCCNTN = "resnoEncCntn";

    /** set 기부명세건수 : dntScnt */
    public static final String ATTR_DNTSCNT = "dntScnt";

    /** set 기부명세합계금액 : useSumAmt */
    public static final String ATTR_USESUMAMT = "useSumAmt";

    /** set 공제대상기부금액 : ddcTrgtConbAmt */
    public static final String ATTR_DDCTRGTCONBAMT = "ddcTrgtConbAmt";

    /** set 기부장려금신청금 : conbSumAmt */
    public static final String ATTR_CONBSUMAMT = "conbSumAmt";

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
     public Ye167420BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167420BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  cnbtSeilNum 
    		, String  conbCd 
    		, String  conbNm 
    		, String  yrsMateClCd 
    		, String  dntcntn 
    		, String  coplNm 
    		, String  bsnoEncCntn 
    		, String  cnbtRltClCd 
    		, String  cnbtFnm 
    		, String  resnoEncCntn 
    		, Long  dntScnt 
    		, Long  useSumAmt 
    		, Long  ddcTrgtConbAmt 
    		, Long  conbSumAmt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_CNBTSEILNUM,cnbtSeilNum);
     	values.put(ATTR_CONBCD,conbCd);
     	values.put(ATTR_CONBNM,conbNm);
     	values.put(ATTR_YRSMATECLCD,yrsMateClCd);
     	values.put(ATTR_DNTCNTN,dntcntn);
     	values.put(ATTR_COPLNM,coplNm);
     	values.put(ATTR_BSNOENCCNTN,bsnoEncCntn);
     	values.put(ATTR_CNBTRLTCLCD,cnbtRltClCd);
     	values.put(ATTR_CNBTFNM,cnbtFnm);
     	values.put(ATTR_RESNOENCCNTN,resnoEncCntn);
     	values.put(ATTR_DNTSCNT,dntScnt);
     	values.put(ATTR_USESUMAMT,useSumAmt);
     	values.put(ATTR_DDCTRGTCONBAMT,ddcTrgtConbAmt);
     	values.put(ATTR_CONBSUMAMT,conbSumAmt);
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

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 기부금일련번호 : cnbtSeilNum */
    public void setCnbtSeilNum(Long  cnbtSeilNum) { set( ATTR_CNBTSEILNUM ,cnbtSeilNum);}
    /** get 기부금일련번호 : cnbtSeilNum */
    public Long  getCnbtSeilNum() { return (Long )get( ATTR_CNBTSEILNUM );}

    /** set 기부유형 : conbCd */
    public void setConbCd(String  conbCd) { set( ATTR_CONBCD ,conbCd);}
    /** get 기부유형 : conbCd */
    public String  getConbCd() { return (String )get( ATTR_CONBCD );}

    /** set 기부코드 : conbNm */
    public void setConbNm(String  conbNm) { set( ATTR_CONBNM ,conbNm);}
    /** get 기부코드 : conbNm */
    public String  getConbNm() { return (String )get( ATTR_CONBNM );}

    /** set 기부자료구분코드 : yrsMateClCd */
    public void setYrsMateClCd(String  yrsMateClCd) { set( ATTR_YRSMATECLCD ,yrsMateClCd);}
    /** get 기부자료구분코드 : yrsMateClCd */
    public String  getYrsMateClCd() { return (String )get( ATTR_YRSMATECLCD );}

    /** set 기부내용 : dntcntn */
    public void setDntcntn(String  dntcntn) { set( ATTR_DNTCNTN ,dntcntn);}
    /** get 기부내용 : dntcntn */
    public String  getDntcntn() { return (String )get( ATTR_DNTCNTN );}

    /** set 기부처_상호명 : coplNm */
    public void setCoplNm(String  coplNm) { set( ATTR_COPLNM ,coplNm);}
    /** get 기부처_상호명 : coplNm */
    public String  getCoplNm() { return (String )get( ATTR_COPLNM );}

    /** set 기부처_사업자등록번호 : bsnoEncCntn */
    public void setBsnoEncCntn(String  bsnoEncCntn) { set( ATTR_BSNOENCCNTN ,bsnoEncCntn);}
    /** get 기부처_사업자등록번호 : bsnoEncCntn */
    public String  getBsnoEncCntn() { return (String )get( ATTR_BSNOENCCNTN );}

    /** set 기부자관계코드 : cnbtRltClCd */
    public void setCnbtRltClCd(String  cnbtRltClCd) { set( ATTR_CNBTRLTCLCD ,cnbtRltClCd);}
    /** get 기부자관계코드 : cnbtRltClCd */
    public String  getCnbtRltClCd() { return (String )get( ATTR_CNBTRLTCLCD );}

    /** set 기부자성명 : cnbtFnm */
    public void setCnbtFnm(String  cnbtFnm) { set( ATTR_CNBTFNM ,cnbtFnm);}
    /** get 기부자성명 : cnbtFnm */
    public String  getCnbtFnm() { return (String )get( ATTR_CNBTFNM );}

    /** set 기부자_주민등록번호 : resnoEncCntn */
    public void setResnoEncCntn(String  resnoEncCntn) { set( ATTR_RESNOENCCNTN ,resnoEncCntn);}
    /** get 기부자_주민등록번호 : resnoEncCntn */
    public String  getResnoEncCntn() { return (String )get( ATTR_RESNOENCCNTN );}

    /** set 기부명세건수 : dntScnt */
    public void setDntScnt(Long  dntScnt) { set( ATTR_DNTSCNT ,dntScnt);}
    /** get 기부명세건수 : dntScnt */
    public Long  getDntScnt() { return (Long )get( ATTR_DNTSCNT );}

    /** set 기부명세합계금액 : useSumAmt */
    public void setUseSumAmt(Long  useSumAmt) { set( ATTR_USESUMAMT ,useSumAmt);}
    /** get 기부명세합계금액 : useSumAmt */
    public Long  getUseSumAmt() { return (Long )get( ATTR_USESUMAMT );}

    /** set 공제대상기부금액 : ddcTrgtConbAmt */
    public void setDdcTrgtConbAmt(Long  ddcTrgtConbAmt) { set( ATTR_DDCTRGTCONBAMT ,ddcTrgtConbAmt);}
    /** get 공제대상기부금액 : ddcTrgtConbAmt */
    public Long  getDdcTrgtConbAmt() { return (Long )get( ATTR_DDCTRGTCONBAMT );}

    /** set 기부장려금신청금 : conbSumAmt */
    public void setConbSumAmt(Long  conbSumAmt) { set( ATTR_CONBSUMAMT ,conbSumAmt);}
    /** get 기부장려금신청금 : conbSumAmt */
    public Long  getConbSumAmt() { return (Long )get( ATTR_CONBSUMAMT );}

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
