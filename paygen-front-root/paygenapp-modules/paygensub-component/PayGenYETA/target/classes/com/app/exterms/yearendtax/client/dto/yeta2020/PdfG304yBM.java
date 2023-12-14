package com.app.exterms.yearendtax.client.dto.yeta2020;



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
public class PdfG304yBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 직불카드일련번호 : dirCardSeilNum */
    public static final String ATTR_DIRCARDSEILNUM = "dirCardSeilNum";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 직불카드주민등록번호 : resid */
    public static final String ATTR_RESID = "resid";

    /** set 직불카드성명 : name */
    public static final String ATTR_NAME = "name";

    /** set 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
    public static final String ATTR_FTYRTOTAMT = "ftyrTotAmt";

    /** set 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
    public static final String ATTR_FTYRMARKETTOTAMT = "ftyrMarketTotAmt";

    /** set 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
    public static final String ATTR_FTYRTMONEYTOTAMT = "ftyrTmoneyTotAmt";

    /** set 직불카드직전년도일반공제대상금액합계 : preTotAmt */
    public static final String ATTR_PRETOTAMT = "preTotAmt";

    /** set 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
    public static final String ATTR_PREMARKETTOTAMT = "preMarketTotAmt";

    /** set 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
    public static final String ATTR_PRETMONEYTOTAMT = "preTmoneyTotAmt";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 직불카드사업자등록번호 : busnid */
    public static final String ATTR_BUSNID = "busnid";

    /** set 직불카드상호명 : tradeNm */
    public static final String ATTR_TRADENM = "tradeNm";

    /** set 직불카드종류코드 : usePlaceCd */
    public static final String ATTR_USEPLACECD = "usePlaceCd";

    /** set 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
    public static final String ATTR_FIRSTTOTAMT = "firstTotAmt";

    /** set 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
    public static final String ATTR_SECONDTOTAMT = "secondTotAmt";

    /** set 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
    public static final String ATTR_FIRSTYEARTOTAMT = "firstYearTotAmt";

    /** set 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
    public static final String ATTR_SECONDYEARTOTAMT = "secondYearTotAmt";

    /** set 직불카드조회기간시작월 : inqrStrtMm */
    public static final String ATTR_INQRSTRTMM = "inqrStrtMm";

    /** set 직불카드조회기간종료월 : inqrEndMm */
    public static final String ATTR_INQRENDMM = "inqrEndMm";

    /** set 직불카드공제대상금액합계 : dirCardAmtSum */
    public static final String ATTR_DIRCARDAMTSUM = "dirCardAmtSum";

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";
    
    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public static final String ATTR_PDFDATAPPCMPLDT = "pdfDatAppCmplDt";
    
    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public static final String ATTR_PDFDATAPPEXCCTNT= "pdfDatAppExcCtnt";

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
     public PdfG304yBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfG304yBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, Long  dirCardSeilNum 
    		, String  formCd 
    		, String  resid 
    		, String  name 
    		, Long  ftyrTotAmt 
    		, Long  ftyrMarketTotAmt 
    		, Long  ftyrTmoneyTotAmt 
    		, Long  preTotAmt 
    		, Long  preMarketTotAmt 
    		, Long  preTmoneyTotAmt 
    		, String  datCd 
    		, String  busnid 
    		, String  tradeNm 
    		, String  usePlaceCd 
    		, Long  firstTotAmt 
    		, Long  secondTotAmt 
    		, Long  firstYearTotAmt 
    		, Long  secondYearTotAmt 
    		, String  inqrStrtMm 
    		, String  inqrEndMm 
    		, Long  dirCardAmtSum 
    		, String  pdfDatAppYn 
    		, String  pdfDatAppCmplDt
    		, String  pdfDatAppExcCtnt
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
     	values.put(ATTR_DIRCARDSEILNUM,dirCardSeilNum);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_RESID,resid);
     	values.put(ATTR_NAME,name);
     	values.put(ATTR_FTYRTOTAMT,ftyrTotAmt);
     	values.put(ATTR_FTYRMARKETTOTAMT,ftyrMarketTotAmt);
     	values.put(ATTR_FTYRTMONEYTOTAMT,ftyrTmoneyTotAmt);
     	values.put(ATTR_PRETOTAMT,preTotAmt);
     	values.put(ATTR_PREMARKETTOTAMT,preMarketTotAmt);
     	values.put(ATTR_PRETMONEYTOTAMT,preTmoneyTotAmt);
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_BUSNID,busnid);
     	values.put(ATTR_TRADENM,tradeNm);
     	values.put(ATTR_USEPLACECD,usePlaceCd);
     	values.put(ATTR_FIRSTTOTAMT,firstTotAmt);
     	values.put(ATTR_SECONDTOTAMT,secondTotAmt);
     	values.put(ATTR_FIRSTYEARTOTAMT,firstYearTotAmt);
     	values.put(ATTR_SECONDYEARTOTAMT,secondYearTotAmt);
     	values.put(ATTR_INQRSTRTMM,inqrStrtMm);
     	values.put(ATTR_INQRENDMM,inqrEndMm);
     	values.put(ATTR_DIRCARDAMTSUM,dirCardAmtSum);
     	values.put(ATTR_PDFDATAPPYN,pdfDatAppYn);
     	values.put(ATTR_PDFDATAPPCMPLDT,pdfDatAppCmplDt);
     	values.put(ATTR_PDFDATAPPEXCCTNT,pdfDatAppExcCtnt);
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

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 직불카드일련번호 : dirCardSeilNum */
    public void setDirCardSeilNum(Long  dirCardSeilNum) { set( ATTR_DIRCARDSEILNUM ,dirCardSeilNum);}
    /** get 직불카드일련번호 : dirCardSeilNum */
    public Long  getDirCardSeilNum() { return (Long )get( ATTR_DIRCARDSEILNUM );}

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 직불카드주민등록번호 : resid */
    public void setResid(String  resid) { set( ATTR_RESID ,resid);}
    /** get 직불카드주민등록번호 : resid */
    public String  getResid() { return (String )get( ATTR_RESID );}

    /** set 직불카드성명 : name */
    public void setName(String  name) { set( ATTR_NAME ,name);}
    /** get 직불카드성명 : name */
    public String  getName() { return (String )get( ATTR_NAME );}

    /** set 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
    public void setFtyrTotAmt(Long  ftyrTotAmt) { set( ATTR_FTYRTOTAMT ,ftyrTotAmt);}
    /** get 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
    public Long  getFtyrTotAmt() { return (Long )get( ATTR_FTYRTOTAMT );}

    /** set 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
    public void setFtyrMarketTotAmt(Long  ftyrMarketTotAmt) { set( ATTR_FTYRMARKETTOTAMT ,ftyrMarketTotAmt);}
    /** get 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
    public Long  getFtyrMarketTotAmt() { return (Long )get( ATTR_FTYRMARKETTOTAMT );}

    /** set 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
    public void setFtyrTmoneyTotAmt(Long  ftyrTmoneyTotAmt) { set( ATTR_FTYRTMONEYTOTAMT ,ftyrTmoneyTotAmt);}
    /** get 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
    public Long  getFtyrTmoneyTotAmt() { return (Long )get( ATTR_FTYRTMONEYTOTAMT );}

    /** set 직불카드직전년도일반공제대상금액합계 : preTotAmt */
    public void setPreTotAmt(Long  preTotAmt) { set( ATTR_PRETOTAMT ,preTotAmt);}
    /** get 직불카드직전년도일반공제대상금액합계 : preTotAmt */
    public Long  getPreTotAmt() { return (Long )get( ATTR_PRETOTAMT );}

    /** set 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
    public void setPreMarketTotAmt(Long  preMarketTotAmt) { set( ATTR_PREMARKETTOTAMT ,preMarketTotAmt);}
    /** get 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
    public Long  getPreMarketTotAmt() { return (Long )get( ATTR_PREMARKETTOTAMT );}

    /** set 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
    public void setPreTmoneyTotAmt(Long  preTmoneyTotAmt) { set( ATTR_PRETMONEYTOTAMT ,preTmoneyTotAmt);}
    /** get 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
    public Long  getPreTmoneyTotAmt() { return (Long )get( ATTR_PRETMONEYTOTAMT );}

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 직불카드사업자등록번호 : busnid */
    public void setBusnid(String  busnid) { set( ATTR_BUSNID ,busnid);}
    /** get 직불카드사업자등록번호 : busnid */
    public String  getBusnid() { return (String )get( ATTR_BUSNID );}

    /** set 직불카드상호명 : tradeNm */
    public void setTradeNm(String  tradeNm) { set( ATTR_TRADENM ,tradeNm);}
    /** get 직불카드상호명 : tradeNm */
    public String  getTradeNm() { return (String )get( ATTR_TRADENM );}

    /** set 직불카드종류코드 : usePlaceCd */
    public void setUsePlaceCd(String  usePlaceCd) { set( ATTR_USEPLACECD ,usePlaceCd);}
    /** get 직불카드종류코드 : usePlaceCd */
    public String  getUsePlaceCd() { return (String )get( ATTR_USEPLACECD );}

    /** set 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
    public void setFirstTotAmt(Long  firstTotAmt) { set( ATTR_FIRSTTOTAMT ,firstTotAmt);}
    /** get 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
    public Long  getFirstTotAmt() { return (Long )get( ATTR_FIRSTTOTAMT );}

    /** set 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
    public void setSecondTotAmt(Long  secondTotAmt) { set( ATTR_SECONDTOTAMT ,secondTotAmt);}
    /** get 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
    public Long  getSecondTotAmt() { return (Long )get( ATTR_SECONDTOTAMT );}

    /** set 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
    public void setFirstYearTotAmt(Long  firstYearTotAmt) { set( ATTR_FIRSTYEARTOTAMT ,firstYearTotAmt);}
    /** get 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
    public Long  getFirstYearTotAmt() { return (Long )get( ATTR_FIRSTYEARTOTAMT );}

    /** set 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
    public void setSecondYearTotAmt(Long  secondYearTotAmt) { set( ATTR_SECONDYEARTOTAMT ,secondYearTotAmt);}
    /** get 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
    public Long  getSecondYearTotAmt() { return (Long )get( ATTR_SECONDYEARTOTAMT );}

    /** set 직불카드조회기간시작월 : inqrStrtMm */
    public void setInqrStrtMm(String  inqrStrtMm) { set( ATTR_INQRSTRTMM ,inqrStrtMm);}
    /** get 직불카드조회기간시작월 : inqrStrtMm */
    public String  getInqrStrtMm() { return (String )get( ATTR_INQRSTRTMM );}

    /** set 직불카드조회기간종료월 : inqrEndMm */
    public void setInqrEndMm(String  inqrEndMm) { set( ATTR_INQRENDMM ,inqrEndMm);}
    /** get 직불카드조회기간종료월 : inqrEndMm */
    public String  getInqrEndMm() { return (String )get( ATTR_INQRENDMM );}

    /** set 직불카드공제대상금액합계 : dirCardAmtSum */
    public void setDirCardAmtSum(Long  dirCardAmtSum) { set( ATTR_DIRCARDAMTSUM ,dirCardAmtSum);}
    /** get 직불카드공제대상금액합계 : dirCardAmtSum */
    public Long  getDirCardAmtSum() { return (Long )get( ATTR_DIRCARDAMTSUM );}

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
    /** get pdf 소득공제자료적용여부 : pdfDatAppYn */
    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}
    
    /** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public void setPdfDatAppCmplDt(String  pdfDatAppCmplDt) { set( ATTR_PDFDATAPPCMPLDT ,pdfDatAppCmplDt);}
    /** get pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
    public String  getPdfDatAppCmplDt() { return (String )get( ATTR_PDFDATAPPCMPLDT );}
    
    /** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public void setPdfDatAppExcCtnt(String  pdfDatAppExcCtnt) { set( ATTR_PDFDATAPPEXCCTNT ,pdfDatAppExcCtnt);}
    /** get pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
    public String  getPdfDatAppExcCtnt() { return (String )get( ATTR_PDFDATAPPEXCCTNT );}

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
