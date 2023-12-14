package com.app.exterms.yearendtax.client.dto.yeta2015;



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
public class Yeta3110BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 정산구분 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm";
    
    /** set 성명 : hanNm */
    public static final String ATTR_HANNM= "hanNm";

    /** set 사업자등록번호 : siteNumb */
    public static final String ATTR_SITENUMB = "siteNumb";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속년월_FROM : jeymStdt */
    public static final String ATTR_JEYMSTDT = "jeymStdt";

    /** set 귀속년월_TO : jeymEddt */
    public static final String ATTR_JEYMEDDT = "jeymEddt";

    /** set 감면기간_TO : jutrEddt */
    public static final String ATTR_JUTREDDT = "jutrEddt";

    /** set 감면기간_FROM : jutrStdt */
    public static final String ATTR_JUTRSTDT = "jutrStdt";

    /** set 근무지명 : siteCtnt */
    public static final String ATTR_SITECTNT = "siteCtnt";

    /** set 급여합계금액 : payrTotl */
    public static final String ATTR_PAYRTOTL = "payrTotl";

    /** set 상여합계금액 : bonsAmnt */
    public static final String ATTR_BONSAMNT = "bonsAmnt";

    /** set 인정상여합계금액 : dtmnBtam */
    public static final String ATTR_DTMNBTAM = "dtmnBtam";

    /** set 주식행사이익 : stckPrft */
    public static final String ATTR_STCKPRFT = "stckPrft";

    /** set 우리사주조합인출금액 : unonAmnt */
    public static final String ATTR_UNONAMNT = "unonAmnt";

    /** set 임원퇴직소득금액한도초과액 : ofrrExli */
    public static final String ATTR_OFRREXLI = "ofrrExli";

    /** set 비과세합계금액 : taxeTotl */
    public static final String ATTR_TAXETOTL = "taxeTotl";

    /** set 연구보조비합계금액 : reseSmam */
    public static final String ATTR_RESESMAM = "reseSmam";

    /** set 소득세 : earnTaxn */
    public static final String ATTR_EARNTAXN = "earnTaxn";

    /** set 지방소득세 : ihtxTaxn */
    public static final String ATTR_IHTXTAXN = "ihtxTaxn";

    /** set 농특세 : farmTaxn */
    public static final String ATTR_FARMTAXN = "farmTaxn";

    /** set 국민연금보험료금액 : annuMuam */
    public static final String ATTR_ANNUMUAM = "annuMuam";

    /** set 국민연금보험료공제액 : annuDdam */
    public static final String ATTR_ANNUDDAM = "annuDdam";

    /** set 국민연금외공무원연금 : auetMuam */
    public static final String ATTR_AUETMUAM = "auetMuam";

    /** set 국민연금외군인연금 : auetSold */
    public static final String ATTR_AUETSOLD = "auetSold";

    /** set 국민연금외교직원연금 : auetTech */
    public static final String ATTR_AUETTECH = "auetTech";

    /** set 국민연금외별정우체국 : auetFect */
    public static final String ATTR_AUETFECT = "auetFect";

    /** set 국민연금외공무원연금공제액 : auetDdam */
    public static final String ATTR_AUETDDAM = "auetDdam";

    /** set 국민연금외군인연금공제액 : auetDold */
    public static final String ATTR_AUETDOLD = "auetDold";

    /** set 국민연금외교직원연금공제액 : auetDech */
    public static final String ATTR_AUETDECH = "auetDech";

    /** set 국민연금외별정우체국공제액 : auetDect */
    public static final String ATTR_AUETDECT = "auetDect";

    /** set 퇴직연금과학기술인금액 : rtreMuam */
    public static final String ATTR_RTREMUAM = "rtreMuam";

    /** set 퇴직연금근로자퇴직급여보장법 : rtrePsct */
    public static final String ATTR_RTREPSCT = "rtrePsct";

    /** set 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
    public static final String ATTR_RTREANSV = "rtreAnsv";

    /** set 퇴직연금과학기술인공제액 : rtreDdam */
    public static final String ATTR_RTREDDAM = "rtreDdam";

    /** set 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
    public static final String ATTR_RTREDSCT = "rtreDsct";

    /** set 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
    public static final String ATTR_RTREDNSV = "rtreDnsv";

    /** set 국민건강보험료금액 : hlthDbam */
    public static final String ATTR_HLTHDBAM = "hlthDbam";

    /** set 국민건강보험료공제액 : hlthMuam */
    public static final String ATTR_HLTHMUAM = "hlthMuam";

    /** set 고용보험금액 : upisJuam */
    public static final String ATTR_UPISJUAM = "upisJuam";

    /** set 고용보험공제액 : upisMuam */
    public static final String ATTR_UPISMUAM = "upisMuam";

    /** set 처리구분여부 : mangGbyn */
    public static final String ATTR_MANGGBYN = "mangGbyn";

    /** set 원천징수영수증제출여부 : wthdSbyn */
    public static final String ATTR_WTHDSBYN = "wthdSbyn";

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
     public Yeta3110BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3110BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  siteNumb 
    		, String  systemkey 
    		, String  jeymStdt 
    		, String  jeymEddt 
    		, String  jutrEddt 
    		, String  jutrStdt 
    		, String  siteCtnt 
    		, BigDecimal  payrTotl 
    		, BigDecimal  bonsAmnt 
    		, BigDecimal  dtmnBtam 
    		, BigDecimal  stckPrft 
    		, BigDecimal  unonAmnt 
    		, BigDecimal  ofrrExli 
    		, BigDecimal  taxeTotl 
    		, BigDecimal  reseSmam 
    		, BigDecimal  earnTaxn 
    		, BigDecimal  ihtxTaxn 
    		, BigDecimal  farmTaxn 
    		, BigDecimal  annuMuam 
    		, BigDecimal  annuDdam 
    		, BigDecimal  auetMuam 
    		, BigDecimal  auetSold 
    		, BigDecimal  auetTech 
    		, BigDecimal  auetFect 
    		, BigDecimal  auetDdam 
    		, BigDecimal  auetDold 
    		, BigDecimal  auetDech 
    		, BigDecimal  auetDect 
    		, BigDecimal  rtreMuam 
    		, BigDecimal  rtrePsct 
    		, BigDecimal  rtreAnsv 
    		, BigDecimal  rtreDdam 
    		, BigDecimal  rtreDsct 
    		, BigDecimal  rtreDnsv 
    		, BigDecimal  hlthDbam 
    		, BigDecimal  hlthMuam 
    		, BigDecimal  upisJuam 
    		, BigDecimal  upisMuam 
    		, String  mangGbyn 
    		, String  wthdSbyn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_SITENUMB,siteNumb);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_JEYMSTDT,jeymStdt);
     	values.put(ATTR_JEYMEDDT,jeymEddt);
     	values.put(ATTR_JUTREDDT,jutrEddt);
     	values.put(ATTR_JUTRSTDT,jutrStdt);
     	values.put(ATTR_SITECTNT,siteCtnt);
     	values.put(ATTR_PAYRTOTL,payrTotl);
     	values.put(ATTR_BONSAMNT,bonsAmnt);
     	values.put(ATTR_DTMNBTAM,dtmnBtam);
     	values.put(ATTR_STCKPRFT,stckPrft);
     	values.put(ATTR_UNONAMNT,unonAmnt);
     	values.put(ATTR_OFRREXLI,ofrrExli);
     	values.put(ATTR_TAXETOTL,taxeTotl);
     	values.put(ATTR_RESESMAM,reseSmam);
     	values.put(ATTR_EARNTAXN,earnTaxn);
     	values.put(ATTR_IHTXTAXN,ihtxTaxn);
     	values.put(ATTR_FARMTAXN,farmTaxn);
     	values.put(ATTR_ANNUMUAM,annuMuam);
     	values.put(ATTR_ANNUDDAM,annuDdam);
     	values.put(ATTR_AUETMUAM,auetMuam);
     	values.put(ATTR_AUETSOLD,auetSold);
     	values.put(ATTR_AUETTECH,auetTech);
     	values.put(ATTR_AUETFECT,auetFect);
     	values.put(ATTR_AUETDDAM,auetDdam);
     	values.put(ATTR_AUETDOLD,auetDold);
     	values.put(ATTR_AUETDECH,auetDech);
     	values.put(ATTR_AUETDECT,auetDect);
     	values.put(ATTR_RTREMUAM,rtreMuam);
     	values.put(ATTR_RTREPSCT,rtrePsct);
     	values.put(ATTR_RTREANSV,rtreAnsv);
     	values.put(ATTR_RTREDDAM,rtreDdam);
     	values.put(ATTR_RTREDSCT,rtreDsct);
     	values.put(ATTR_RTREDNSV,rtreDnsv);
     	values.put(ATTR_HLTHDBAM,hlthDbam);
     	values.put(ATTR_HLTHMUAM,hlthMuam);
     	values.put(ATTR_UPISJUAM,upisJuam);
     	values.put(ATTR_UPISMUAM,upisMuam);
     	values.put(ATTR_MANGGBYN,mangGbyn);
     	values.put(ATTR_WTHDSBYN,wthdSbyn);
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

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}
    
	 /** set 정산구분 : settGbnm */
    public void setSettGbnm(String  settGbnm) { set( ATTR_SETTGBNM ,settGbnm);}
    /** get 정산구분 : settGbnm */
    public String  getSettGbnm() { return (String )get( ATTR_SETTGBNM );}

    /** set 성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}
    
    /** set 사업자등록번호 : siteNumb */
    public void setSiteNumb(String  siteNumb) { set( ATTR_SITENUMB ,siteNumb);}
    /** get 사업자등록번호 : siteNumb */
    public String  getSiteNumb() { return (String )get( ATTR_SITENUMB );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 귀속년월_FROM : jeymStdt */
    public void setJeymStdt(String  jeymStdt) { set( ATTR_JEYMSTDT ,jeymStdt);}
    /** get 귀속년월_FROM : jeymStdt */
    public String  getJeymStdt() { return (String )get( ATTR_JEYMSTDT );}

    /** set 귀속년월_TO : jeymEddt */
    public void setJeymEddt(String  jeymEddt) { set( ATTR_JEYMEDDT ,jeymEddt);}
    /** get 귀속년월_TO : jeymEddt */
    public String  getJeymEddt() { return (String )get( ATTR_JEYMEDDT );}

    /** set 감면기간_TO : jutrEddt */
    public void setJutrEddt(String  jutrEddt) { set( ATTR_JUTREDDT ,jutrEddt);}
    /** get 감면기간_TO : jutrEddt */
    public String  getJutrEddt() { return (String )get( ATTR_JUTREDDT );}

    /** set 감면기간_FROM : jutrStdt */
    public void setJutrStdt(String  jutrStdt) { set( ATTR_JUTRSTDT ,jutrStdt);}
    /** get 감면기간_FROM : jutrStdt */
    public String  getJutrStdt() { return (String )get( ATTR_JUTRSTDT );}

    /** set 근무지명 : siteCtnt */
    public void setSiteCtnt(String  siteCtnt) { set( ATTR_SITECTNT ,siteCtnt);}
    /** get 근무지명 : siteCtnt */
    public String  getSiteCtnt() { return (String )get( ATTR_SITECTNT );}

    /** set 급여합계금액 : payrTotl */
    public void setPayrTotl(BigDecimal  payrTotl) { set( ATTR_PAYRTOTL ,payrTotl);}
    /** get 급여합계금액 : payrTotl */
    public BigDecimal  getPayrTotl() { return (BigDecimal )get( ATTR_PAYRTOTL );}

    /** set 상여합계금액 : bonsAmnt */
    public void setBonsAmnt(BigDecimal  bonsAmnt) { set( ATTR_BONSAMNT ,bonsAmnt);}
    /** get 상여합계금액 : bonsAmnt */
    public BigDecimal  getBonsAmnt() { return (BigDecimal )get( ATTR_BONSAMNT );}

    /** set 인정상여합계금액 : dtmnBtam */
    public void setDtmnBtam(BigDecimal  dtmnBtam) { set( ATTR_DTMNBTAM ,dtmnBtam);}
    /** get 인정상여합계금액 : dtmnBtam */
    public BigDecimal  getDtmnBtam() { return (BigDecimal )get( ATTR_DTMNBTAM );}

    /** set 주식행사이익 : stckPrft */
    public void setStckPrft(BigDecimal  stckPrft) { set( ATTR_STCKPRFT ,stckPrft);}
    /** get 주식행사이익 : stckPrft */
    public BigDecimal  getStckPrft() { return (BigDecimal )get( ATTR_STCKPRFT );}

    /** set 우리사주조합인출금액 : unonAmnt */
    public void setUnonAmnt(BigDecimal  unonAmnt) { set( ATTR_UNONAMNT ,unonAmnt);}
    /** get 우리사주조합인출금액 : unonAmnt */
    public BigDecimal  getUnonAmnt() { return (BigDecimal )get( ATTR_UNONAMNT );}

    /** set 임원퇴직소득금액한도초과액 : ofrrExli */
    public void setOfrrExli(BigDecimal  ofrrExli) { set( ATTR_OFRREXLI ,ofrrExli);}
    /** get 임원퇴직소득금액한도초과액 : ofrrExli */
    public BigDecimal  getOfrrExli() { return (BigDecimal )get( ATTR_OFRREXLI );}

    /** set 비과세합계금액 : taxeTotl */
    public void setTaxeTotl(BigDecimal  taxeTotl) { set( ATTR_TAXETOTL ,taxeTotl);}
    /** get 비과세합계금액 : taxeTotl */
    public BigDecimal  getTaxeTotl() { return (BigDecimal )get( ATTR_TAXETOTL );}

    /** set 연구보조비합계금액 : reseSmam */
    public void setReseSmam(BigDecimal  reseSmam) { set( ATTR_RESESMAM ,reseSmam);}
    /** get 연구보조비합계금액 : reseSmam */
    public BigDecimal  getReseSmam() { return (BigDecimal )get( ATTR_RESESMAM );}

    /** set 소득세 : earnTaxn */
    public void setEarnTaxn(BigDecimal  earnTaxn) { set( ATTR_EARNTAXN ,earnTaxn);}
    /** get 소득세 : earnTaxn */
    public BigDecimal  getEarnTaxn() { return (BigDecimal )get( ATTR_EARNTAXN );}

    /** set 지방소득세 : ihtxTaxn */
    public void setIhtxTaxn(BigDecimal  ihtxTaxn) { set( ATTR_IHTXTAXN ,ihtxTaxn);}
    /** get 지방소득세 : ihtxTaxn */
    public BigDecimal  getIhtxTaxn() { return (BigDecimal )get( ATTR_IHTXTAXN );}

    /** set 농특세 : farmTaxn */
    public void setFarmTaxn(BigDecimal  farmTaxn) { set( ATTR_FARMTAXN ,farmTaxn);}
    /** get 농특세 : farmTaxn */
    public BigDecimal  getFarmTaxn() { return (BigDecimal )get( ATTR_FARMTAXN );}

    /** set 국민연금보험료금액 : annuMuam */
    public void setAnnuMuam(BigDecimal  annuMuam) { set( ATTR_ANNUMUAM ,annuMuam);}
    /** get 국민연금보험료금액 : annuMuam */
    public BigDecimal  getAnnuMuam() { return (BigDecimal )get( ATTR_ANNUMUAM );}

    /** set 국민연금보험료공제액 : annuDdam */
    public void setAnnuDdam(BigDecimal  annuDdam) { set( ATTR_ANNUDDAM ,annuDdam);}
    /** get 국민연금보험료공제액 : annuDdam */
    public BigDecimal  getAnnuDdam() { return (BigDecimal )get( ATTR_ANNUDDAM );}

    /** set 국민연금외공무원연금 : auetMuam */
    public void setAuetMuam(BigDecimal  auetMuam) { set( ATTR_AUETMUAM ,auetMuam);}
    /** get 국민연금외공무원연금 : auetMuam */
    public BigDecimal  getAuetMuam() { return (BigDecimal )get( ATTR_AUETMUAM );}

    /** set 국민연금외군인연금 : auetSold */
    public void setAuetSold(BigDecimal  auetSold) { set( ATTR_AUETSOLD ,auetSold);}
    /** get 국민연금외군인연금 : auetSold */
    public BigDecimal  getAuetSold() { return (BigDecimal )get( ATTR_AUETSOLD );}

    /** set 국민연금외교직원연금 : auetTech */
    public void setAuetTech(BigDecimal  auetTech) { set( ATTR_AUETTECH ,auetTech);}
    /** get 국민연금외교직원연금 : auetTech */
    public BigDecimal  getAuetTech() { return (BigDecimal )get( ATTR_AUETTECH );}

    /** set 국민연금외별정우체국 : auetFect */
    public void setAuetFect(BigDecimal  auetFect) { set( ATTR_AUETFECT ,auetFect);}
    /** get 국민연금외별정우체국 : auetFect */
    public BigDecimal  getAuetFect() { return (BigDecimal )get( ATTR_AUETFECT );}

    /** set 국민연금외공무원연금공제액 : auetDdam */
    public void setAuetDdam(BigDecimal  auetDdam) { set( ATTR_AUETDDAM ,auetDdam);}
    /** get 국민연금외공무원연금공제액 : auetDdam */
    public BigDecimal  getAuetDdam() { return (BigDecimal )get( ATTR_AUETDDAM );}

    /** set 국민연금외군인연금공제액 : auetDold */
    public void setAuetDold(BigDecimal  auetDold) { set( ATTR_AUETDOLD ,auetDold);}
    /** get 국민연금외군인연금공제액 : auetDold */
    public BigDecimal  getAuetDold() { return (BigDecimal )get( ATTR_AUETDOLD );}

    /** set 국민연금외교직원연금공제액 : auetDech */
    public void setAuetDech(BigDecimal  auetDech) { set( ATTR_AUETDECH ,auetDech);}
    /** get 국민연금외교직원연금공제액 : auetDech */
    public BigDecimal  getAuetDech() { return (BigDecimal )get( ATTR_AUETDECH );}

    /** set 국민연금외별정우체국공제액 : auetDect */
    public void setAuetDect(BigDecimal  auetDect) { set( ATTR_AUETDECT ,auetDect);}
    /** get 국민연금외별정우체국공제액 : auetDect */
    public BigDecimal  getAuetDect() { return (BigDecimal )get( ATTR_AUETDECT );}

    /** set 퇴직연금과학기술인금액 : rtreMuam */
    public void setRtreMuam(BigDecimal  rtreMuam) { set( ATTR_RTREMUAM ,rtreMuam);}
    /** get 퇴직연금과학기술인금액 : rtreMuam */
    public BigDecimal  getRtreMuam() { return (BigDecimal )get( ATTR_RTREMUAM );}

    /** set 퇴직연금근로자퇴직급여보장법 : rtrePsct */
    public void setRtrePsct(BigDecimal  rtrePsct) { set( ATTR_RTREPSCT ,rtrePsct);}
    /** get 퇴직연금근로자퇴직급여보장법 : rtrePsct */
    public BigDecimal  getRtrePsct() { return (BigDecimal )get( ATTR_RTREPSCT );}

    /** set 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
    public void setRtreAnsv(BigDecimal  rtreAnsv) { set( ATTR_RTREANSV ,rtreAnsv);}
    /** get 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
    public BigDecimal  getRtreAnsv() { return (BigDecimal )get( ATTR_RTREANSV );}

    /** set 퇴직연금과학기술인공제액 : rtreDdam */
    public void setRtreDdam(BigDecimal  rtreDdam) { set( ATTR_RTREDDAM ,rtreDdam);}
    /** get 퇴직연금과학기술인공제액 : rtreDdam */
    public BigDecimal  getRtreDdam() { return (BigDecimal )get( ATTR_RTREDDAM );}

    /** set 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
    public void setRtreDsct(BigDecimal  rtreDsct) { set( ATTR_RTREDSCT ,rtreDsct);}
    /** get 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
    public BigDecimal  getRtreDsct() { return (BigDecimal )get( ATTR_RTREDSCT );}

    /** set 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
    public void setRtreDnsv(BigDecimal  rtreDnsv) { set( ATTR_RTREDNSV ,rtreDnsv);}
    /** get 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
    public BigDecimal  getRtreDnsv() { return (BigDecimal )get( ATTR_RTREDNSV );}

    /** set 국민건강보험료금액 : hlthDbam */
    public void setHlthDbam(BigDecimal  hlthDbam) { set( ATTR_HLTHDBAM ,hlthDbam);}
    /** get 국민건강보험료금액 : hlthDbam */
    public BigDecimal  getHlthDbam() { return (BigDecimal )get( ATTR_HLTHDBAM );}

    /** set 국민건강보험료공제액 : hlthMuam */
    public void setHlthMuam(BigDecimal  hlthMuam) { set( ATTR_HLTHMUAM ,hlthMuam);}
    /** get 국민건강보험료공제액 : hlthMuam */
    public BigDecimal  getHlthMuam() { return (BigDecimal )get( ATTR_HLTHMUAM );}

    /** set 고용보험금액 : upisJuam */
    public void setUpisJuam(BigDecimal  upisJuam) { set( ATTR_UPISJUAM ,upisJuam);}
    /** get 고용보험금액 : upisJuam */
    public BigDecimal  getUpisJuam() { return (BigDecimal )get( ATTR_UPISJUAM );}

    /** set 고용보험공제액 : upisMuam */
    public void setUpisMuam(BigDecimal  upisMuam) { set( ATTR_UPISMUAM ,upisMuam);}
    /** get 고용보험공제액 : upisMuam */
    public BigDecimal  getUpisMuam() { return (BigDecimal )get( ATTR_UPISMUAM );}

    /** set 처리구분여부 : mangGbyn */
    public void setMangGbyn(String  mangGbyn) { set( ATTR_MANGGBYN ,mangGbyn);}
    /** get 처리구분여부 : mangGbyn */
    public String  getMangGbyn() { return (String )get( ATTR_MANGGBYN );}

    /** set 원천징수영수증제출여부 : wthdSbyn */
    public void setWthdSbyn(String  wthdSbyn) { set( ATTR_WTHDSBYN ,wthdSbyn);}
    /** get 원천징수영수증제출여부 : wthdSbyn */
    public String  getWthdSbyn() { return (String )get( ATTR_WTHDSBYN );}

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
