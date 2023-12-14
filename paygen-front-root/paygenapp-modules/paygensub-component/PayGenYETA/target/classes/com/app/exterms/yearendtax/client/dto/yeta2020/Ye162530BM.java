package com.app.exterms.yearendtax.client.dto.yeta2020;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye162530BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162530BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 임대차계약 일련번호 : rntlCttSeilNum */
    public static final String ATTR_RNTLCTTSEILNUM = "rntlCttSeilNum";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNCD = "taxVvalKrnCd";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNNM = "taxVvalKrnNm";

    /** set G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
    public static final String ATTR_RNTLCTTLEHDRNM = "rntlCttLehdrNm";

    /** set G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
    public static final String ATTR_RNTLCTTBUSOPRRGSTNUM = "rntlCttBusoprRgstnum";

    /** set G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
    public static final String ATTR_RNTLCTTHUSFRMCD = "rntlCttHusFrmCd";

    /** set G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
    public static final String ATTR_RNTLCTTHUSCNTTAREA = "rntlCttHusCnttArea";

    /** set G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
    public static final String ATTR_RNTLCTTADDR = "rntlCttAddr";

    /** set G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
    public static final String ATTR_RNTLCTTPRIDBGNNDT = "rntlCttPridBgnnDt";

    /** set G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
    public static final String ATTR_RNTLCTTPRIDENDDT = "rntlCttPridEndDt";

    /** set G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
    public static final String ATTR_RNTLCTTCHRTRGRNTESUM = "rntlCttChrtrGrnteSum";

    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    public static final String ATTR_ECTNFLTRNRCTLYN = "ectnFlTrnrCtlYn";

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
     public Ye162530BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye162530BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, Long  rntlCttSeilNum 
    		, String  rntlCttLehdrNm 
    		, String  rntlCttBusoprRgstnum 
    		, String  rntlCttHusFrmCd 
    		, Long  rntlCttHusCnttArea 
    		, String  rntlCttAddr 
    		, String  rntlCttPridBgnnDt 
    		, String  rntlCttPridEndDt 
    		, Long  rntlCttChrtrGrnteSum 
    		, String  ectnFlTrnrCtlYn 
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
     	values.put(ATTR_RNTLCTTSEILNUM,rntlCttSeilNum);
     	values.put(ATTR_RNTLCTTLEHDRNM,rntlCttLehdrNm);
     	values.put(ATTR_RNTLCTTBUSOPRRGSTNUM,rntlCttBusoprRgstnum);
     	values.put(ATTR_RNTLCTTHUSFRMCD,rntlCttHusFrmCd);
     	values.put(ATTR_RNTLCTTHUSCNTTAREA,rntlCttHusCnttArea);
     	values.put(ATTR_RNTLCTTADDR,rntlCttAddr);
     	values.put(ATTR_RNTLCTTPRIDBGNNDT,rntlCttPridBgnnDt);
     	values.put(ATTR_RNTLCTTPRIDENDDT,rntlCttPridEndDt);
     	values.put(ATTR_RNTLCTTCHRTRGRNTESUM,rntlCttChrtrGrnteSum);
     	values.put(ATTR_ECTNFLTRNRCTLYN,ectnFlTrnrCtlYn);
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
    /** set 연말정산귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 연말정산귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 임대차계약 일련번호 : rntlCttSeilNum */
    public void setRntlCttSeilNum(Long  rntlCttSeilNum) { set( ATTR_RNTLCTTSEILNUM ,rntlCttSeilNum);}
    /** get 임대차계약 일련번호 : rntlCttSeilNum */
    public Long  getRntlCttSeilNum() { return (Long )get( ATTR_RNTLCTTSEILNUM );}
    /** set G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
    public void setRntlCttLehdrNm(String  rntlCttLehdrNm) { set( ATTR_RNTLCTTLEHDRNM ,rntlCttLehdrNm);}
    /** get G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
    public String  getRntlCttLehdrNm() { return (String )get( ATTR_RNTLCTTLEHDRNM );}
    /** set G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
    public void setRntlCttBusoprRgstnum(String  rntlCttBusoprRgstnum) { set( ATTR_RNTLCTTBUSOPRRGSTNUM ,rntlCttBusoprRgstnum);}
    /** get G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
    public String  getRntlCttBusoprRgstnum() { return (String )get( ATTR_RNTLCTTBUSOPRRGSTNUM );}
    /** set G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
    public void setRntlCttHusFrmCd(String  rntlCttHusFrmCd) { set( ATTR_RNTLCTTHUSFRMCD ,rntlCttHusFrmCd);}
    /** get G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
    public String  getRntlCttHusFrmCd() { return (String )get( ATTR_RNTLCTTHUSFRMCD );}
    /** set G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
    public void setRntlCttHusCnttArea(Long  rntlCttHusCnttArea) { set( ATTR_RNTLCTTHUSCNTTAREA ,rntlCttHusCnttArea);}
    /** get G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
    public Long  getRntlCttHusCnttArea() { return (Long )get( ATTR_RNTLCTTHUSCNTTAREA );}
    /** set G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
    public void setRntlCttAddr(String  rntlCttAddr) { set( ATTR_RNTLCTTADDR ,rntlCttAddr);}
    /** get G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
    public String  getRntlCttAddr() { return (String )get( ATTR_RNTLCTTADDR );}
    /** set G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
    public void setRntlCttPridBgnnDt(String  rntlCttPridBgnnDt) { set( ATTR_RNTLCTTPRIDBGNNDT ,rntlCttPridBgnnDt);}
    /** get G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
    public String  getRntlCttPridBgnnDt() { return (String )get( ATTR_RNTLCTTPRIDBGNNDT );}
    /** set G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
    public void setRntlCttPridEndDt(String  rntlCttPridEndDt) { set( ATTR_RNTLCTTPRIDENDDT ,rntlCttPridEndDt);}
    /** get G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
    public String  getRntlCttPridEndDt() { return (String )get( ATTR_RNTLCTTPRIDENDDT );}
    /** set G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
    public void setRntlCttChrtrGrnteSum(Long  rntlCttChrtrGrnteSum) { set( ATTR_RNTLCTTCHRTRGRNTESUM ,rntlCttChrtrGrnteSum);}
    /** get G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
    public Long  getRntlCttChrtrGrnteSum() { return (Long )get( ATTR_RNTLCTTCHRTRGRNTESUM );}
    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    public void setEctnFlTrnrCtlYn(String  ectnFlTrnrCtlYn) { set( ATTR_ECTNFLTRNRCTLYN ,ectnFlTrnrCtlYn);}
    /** get 전자파일이관여부 : ectnFlTrnrCtlYn */
    public String  getEctnFlTrnrCtlYn() { return (String )get( ATTR_ECTNFLTRNRCTLYN );}
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
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
	public void setTaxVvalKrnCd(String  taxVvalKrnCd) { set( ATTR_TAXVVALKRNCD ,taxVvalKrnCd);}
	/** get 국세청자료구분코드 : taxVvalKrnCd */
	public String  getTaxVvalKrnCd() { return (String )get( ATTR_TAXVVALKRNCD );}
	
	/** set 국세청자료구분코드 : taxVvalKrnNm */
	public void setTaxVvalKrnNm(String  taxVvalKrnNm) { set( ATTR_TAXVVALKRNNM ,taxVvalKrnNm);}
	/** get 국세청자료구분코드 : taxVvalKrnNm */
	public String  getTaxVvalKrnNm() { return (String )get( ATTR_TAXVVALKRNNM );}

}
