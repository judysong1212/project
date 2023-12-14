package com.app.exterms.yearendtax.client.dto.yeta2017;





import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye162520BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162520BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 금전소비대차일련번호 : comrCalnSeilNum */
    public static final String ATTR_COMRCALNSEILNUM = "comrCalnSeilNum";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNCD = "taxVvalKrnCd";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNNM = "taxVvalKrnNm";

    /** set G16_금전소비대차_대주성명 : comrCdtrNm */
    public static final String ATTR_COMRCDTRNM = "comrCdtrNm";

    /** set G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
    public static final String ATTR_COMRCDTRRESNREGNNUM = "comrCdtrResnRegnNum";

    /** set G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
    public static final String ATTR_COMRCNTTPRIDBGNNDT = "comrCnttPridBgnnDt";

    /** set G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
    public static final String ATTR_COMRCNTTPRIDENDDT = "comrCnttPridEndDt";

    /** set G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
    public static final String ATTR_COMRLOANITRTRATE = "comrLoanItrtRate";

    /** set G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
    public static final String ATTR_COMRPCLTTAMTFTAGGR = "comrPclttAmtftAggr";

    /** set G22_금전소비대차_원금금액 : comrPrnilSum */
    public static final String ATTR_COMRPRNILSUM = "comrPrnilSum";

    /** set G23_금전소비대차_이자금액 : comrItrtSum */
    public static final String ATTR_COMRITRTSUM = "comrItrtSum";

    /** set G24_금전소비대차_공제금액 : comrDducSum */
    public static final String ATTR_COMRDDUCSUM = "comrDducSum";

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
     public Ye162520BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye162520BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, Long  comrCalnSeilNum 
    		, String  comrCdtrNm 
    		, String  comrCdtrResnRegnNum 
    		, String  comrCnttPridBgnnDt 
    		, String  comrCnttPridEndDt 
    		, Long  comrLoanItrtRate 
    		, Long  comrPclttAmtftAggr 
    		, Long  comrPrnilSum 
    		, Long  comrItrtSum 
    		, Long  comrDducSum 
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
     	values.put(ATTR_COMRCALNSEILNUM,comrCalnSeilNum);
     	values.put(ATTR_COMRCDTRNM,comrCdtrNm);
     	values.put(ATTR_COMRCDTRRESNREGNNUM,comrCdtrResnRegnNum);
     	values.put(ATTR_COMRCNTTPRIDBGNNDT,comrCnttPridBgnnDt);
     	values.put(ATTR_COMRCNTTPRIDENDDT,comrCnttPridEndDt);
     	values.put(ATTR_COMRLOANITRTRATE,comrLoanItrtRate);
     	values.put(ATTR_COMRPCLTTAMTFTAGGR,comrPclttAmtftAggr);
     	values.put(ATTR_COMRPRNILSUM,comrPrnilSum);
     	values.put(ATTR_COMRITRTSUM,comrItrtSum);
     	values.put(ATTR_COMRDDUCSUM,comrDducSum);
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
    /** set 금전소비대차일련번호 : comrCalnSeilNum */
    public void setComrCalnSeilNum(Long  comrCalnSeilNum) { set( ATTR_COMRCALNSEILNUM ,comrCalnSeilNum);}
    /** get 금전소비대차일련번호 : comrCalnSeilNum */
    public Long  getComrCalnSeilNum() { return (Long )get( ATTR_COMRCALNSEILNUM );}
    /** set G16_금전소비대차_대주성명 : comrCdtrNm */
    public void setComrCdtrNm(String  comrCdtrNm) { set( ATTR_COMRCDTRNM ,comrCdtrNm);}
    /** get G16_금전소비대차_대주성명 : comrCdtrNm */
    public String  getComrCdtrNm() { return (String )get( ATTR_COMRCDTRNM );}
    /** set G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
    public void setComrCdtrResnRegnNum(String  comrCdtrResnRegnNum) { set( ATTR_COMRCDTRRESNREGNNUM ,comrCdtrResnRegnNum);}
    /** get G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
    public String  getComrCdtrResnRegnNum() { return (String )get( ATTR_COMRCDTRRESNREGNNUM );}
    /** set G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
    public void setComrCnttPridBgnnDt(String  comrCnttPridBgnnDt) { set( ATTR_COMRCNTTPRIDBGNNDT ,comrCnttPridBgnnDt);}
    /** get G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
    public String  getComrCnttPridBgnnDt() { return (String )get( ATTR_COMRCNTTPRIDBGNNDT );}
    /** set G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
    public void setComrCnttPridEndDt(String  comrCnttPridEndDt) { set( ATTR_COMRCNTTPRIDENDDT ,comrCnttPridEndDt);}
    /** get G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
    public String  getComrCnttPridEndDt() { return (String )get( ATTR_COMRCNTTPRIDENDDT );}
    /** set G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
    public void setComrLoanItrtRate(Long  comrLoanItrtRate) { set( ATTR_COMRLOANITRTRATE ,comrLoanItrtRate);}
    /** get G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
    public Long  getComrLoanItrtRate() { return (Long )get( ATTR_COMRLOANITRTRATE );}
    /** set G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
    public void setComrPclttAmtftAggr(Long  comrPclttAmtftAggr) { set( ATTR_COMRPCLTTAMTFTAGGR ,comrPclttAmtftAggr);}
    /** get G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
    public Long  getComrPclttAmtftAggr() { return (Long )get( ATTR_COMRPCLTTAMTFTAGGR );}
    /** set G22_금전소비대차_원금금액 : comrPrnilSum */
    public void setComrPrnilSum(Long  comrPrnilSum) { set( ATTR_COMRPRNILSUM ,comrPrnilSum);}
    /** get G22_금전소비대차_원금금액 : comrPrnilSum */
    public Long  getComrPrnilSum() { return (Long )get( ATTR_COMRPRNILSUM );}
    /** set G23_금전소비대차_이자금액 : comrItrtSum */
    public void setComrItrtSum(Long  comrItrtSum) { set( ATTR_COMRITRTSUM ,comrItrtSum);}
    /** get G23_금전소비대차_이자금액 : comrItrtSum */
    public Long  getComrItrtSum() { return (Long )get( ATTR_COMRITRTSUM );}
    /** set G24_금전소비대차_공제금액 : comrDducSum */
    public void setComrDducSum(Long  comrDducSum) { set( ATTR_COMRDDUCSUM ,comrDducSum);}
    /** get G24_금전소비대차_공제금액 : comrDducSum */
    public Long  getComrDducSum() { return (Long )get( ATTR_COMRDDUCSUM );}
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
