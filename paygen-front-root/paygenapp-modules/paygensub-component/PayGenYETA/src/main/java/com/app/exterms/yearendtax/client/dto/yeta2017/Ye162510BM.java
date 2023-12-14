package com.app.exterms.yearendtax.client.dto.yeta2017;




import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye162510BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162510BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 월세액소득공제일련번호 : mnthRntQntySeilNum */
    public static final String ATTR_MNTHRNTQNTYSEILNUM = "mnthRntQntySeilNum";

    /** set G7_월세액_임대인성명 : mnthRnttyLehdrNm */
    public static final String ATTR_MNTHRNTTYLEHDRNM = "mnthRnttyLehdrNm";

    /** set G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
    public static final String ATTR_MNTHRNTTYBURRGSUM = "mnthRnttyBurRgsum";

    /** set G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
    public static final String ATTR_MNTHRNTTYHUSFRMCD = "mnthRnttyHusFrmCd";

    /** set G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
    public static final String ATTR_MNTHRNTTYHUSCNTTAREA = "mnthRnttyHusCnttArea";

    /** set G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
    public static final String ATTR_MNTHRNTTYRNTLADDR = "mnthRnttyRntlAddr";

    /** set G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
    public static final String ATTR_MNTHRNTTYRNTLBGNNDT = "mnthRnttyRntlBgnnDt";

    /** set G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
    public static final String ATTR_MNTHRNTTYRNTLENDDT = "mnthRnttyRntlEndDt";

    /** set G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
    public static final String ATTR_MNTHRNTTYYRLYMNTHSUM = "mnthRnttyYrlyMnthSum";

    /** set G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
    public static final String ATTR_MNTHRNTTYTXDDUCSUM = "mnthRnttyTxDducSum";

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
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNCD = "taxVvalKrnCd";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNNM = "taxVvalKrnNm";


    /** 생성자 */
     public Ye162510BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye162510BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, Long  mnthRntQntySeilNum 
    		, String  mnthRnttyLehdrNm 
    		, String  mnthRnttyBurRgsum 
    		, String  mnthRnttyHusFrmCd 
    		, Long  mnthRnttyHusCnttArea 
    		, String  mnthRnttyRntlAddr 
    		, String  mnthRnttyRntlBgnnDt 
    		, String  mnthRnttyRntlEndDt 
    		, Long  mnthRnttyYrlyMnthSum 
    		, Long  mnthRnttyTxDducSum 
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
     	values.put(ATTR_MNTHRNTQNTYSEILNUM,mnthRntQntySeilNum);
     	values.put(ATTR_MNTHRNTTYLEHDRNM,mnthRnttyLehdrNm);
     	values.put(ATTR_MNTHRNTTYBURRGSUM,mnthRnttyBurRgsum);
     	values.put(ATTR_MNTHRNTTYHUSFRMCD,mnthRnttyHusFrmCd);
     	values.put(ATTR_MNTHRNTTYHUSCNTTAREA,mnthRnttyHusCnttArea);
     	values.put(ATTR_MNTHRNTTYRNTLADDR,mnthRnttyRntlAddr);
     	values.put(ATTR_MNTHRNTTYRNTLBGNNDT,mnthRnttyRntlBgnnDt);
     	values.put(ATTR_MNTHRNTTYRNTLENDDT,mnthRnttyRntlEndDt);
     	values.put(ATTR_MNTHRNTTYYRLYMNTHSUM,mnthRnttyYrlyMnthSum);
     	values.put(ATTR_MNTHRNTTYTXDDUCSUM,mnthRnttyTxDducSum);
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
    /** set 월세액소득공제일련번호 : mnthRntQntySeilNum */
    public void setMnthRntQntySeilNum(Long  mnthRntQntySeilNum) { set( ATTR_MNTHRNTQNTYSEILNUM ,mnthRntQntySeilNum);}
    /** get 월세액소득공제일련번호 : mnthRntQntySeilNum */
    public Long  getMnthRntQntySeilNum() { return (Long )get( ATTR_MNTHRNTQNTYSEILNUM );}
    /** set G7_월세액_임대인성명 : mnthRnttyLehdrNm */
    public void setMnthRnttyLehdrNm(String  mnthRnttyLehdrNm) { set( ATTR_MNTHRNTTYLEHDRNM ,mnthRnttyLehdrNm);}
    /** get G7_월세액_임대인성명 : mnthRnttyLehdrNm */
    public String  getMnthRnttyLehdrNm() { return (String )get( ATTR_MNTHRNTTYLEHDRNM );}
    /** set G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
    public void setMnthRnttyBurRgsum(String  mnthRnttyBurRgsum) { set( ATTR_MNTHRNTTYBURRGSUM ,mnthRnttyBurRgsum);}
    /** get G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
    public String  getMnthRnttyBurRgsum() { return (String )get( ATTR_MNTHRNTTYBURRGSUM );}
    /** set G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
    public void setMnthRnttyHusFrmCd(String  mnthRnttyHusFrmCd) { set( ATTR_MNTHRNTTYHUSFRMCD ,mnthRnttyHusFrmCd);}
    /** get G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
    public String  getMnthRnttyHusFrmCd() { return (String )get( ATTR_MNTHRNTTYHUSFRMCD );}
    /** set G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
    public void setMnthRnttyHusCnttArea(Long  mnthRnttyHusCnttArea) { set( ATTR_MNTHRNTTYHUSCNTTAREA ,mnthRnttyHusCnttArea);}
    /** get G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
    public Long  getMnthRnttyHusCnttArea() { return (Long )get( ATTR_MNTHRNTTYHUSCNTTAREA );}
    /** set G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
    public void setMnthRnttyRntlAddr(String  mnthRnttyRntlAddr) { set( ATTR_MNTHRNTTYRNTLADDR ,mnthRnttyRntlAddr);}
    /** get G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
    public String  getMnthRnttyRntlAddr() { return (String )get( ATTR_MNTHRNTTYRNTLADDR );}
    /** set G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
    public void setMnthRnttyRntlBgnnDt(String  mnthRnttyRntlBgnnDt) { set( ATTR_MNTHRNTTYRNTLBGNNDT ,mnthRnttyRntlBgnnDt);}
    /** get G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
    public String  getMnthRnttyRntlBgnnDt() { return (String )get( ATTR_MNTHRNTTYRNTLBGNNDT );}
    /** set G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
    public void setMnthRnttyRntlEndDt(String  mnthRnttyRntlEndDt) { set( ATTR_MNTHRNTTYRNTLENDDT ,mnthRnttyRntlEndDt);}
    /** get G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
    public String  getMnthRnttyRntlEndDt() { return (String )get( ATTR_MNTHRNTTYRNTLENDDT );}
    /** set G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
    public void setMnthRnttyYrlyMnthSum(Long  mnthRnttyYrlyMnthSum) { set( ATTR_MNTHRNTTYYRLYMNTHSUM ,mnthRnttyYrlyMnthSum);}
    /** get G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
    public Long  getMnthRnttyYrlyMnthSum() { return (Long )get( ATTR_MNTHRNTTYYRLYMNTHSUM );}
    /** set G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
    public void setMnthRnttyTxDducSum(Long  mnthRnttyTxDducSum) { set( ATTR_MNTHRNTTYTXDDUCSUM ,mnthRnttyTxDducSum);}
    /** get G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
    public Long  getMnthRnttyTxDducSum() { return (Long )get( ATTR_MNTHRNTTYTXDDUCSUM );}
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
