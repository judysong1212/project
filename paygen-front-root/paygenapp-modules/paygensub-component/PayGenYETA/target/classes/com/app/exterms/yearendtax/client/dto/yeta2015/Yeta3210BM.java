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
public class Yeta3210BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 정산구분 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm";

    /** set 지급년월 : elctYymm */
    public static final String ATTR_ELCTYYMM = "elctYymm";
    
    /** set 성명 : hanNm */
    public static final String ATTR_HANNM= "hanNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 급여지급일자 : elctDate */
    public static final String ATTR_ELCTDATE = "elctDate";

    /** set 급여지급금액_과세 : suprTxam */
    public static final String ATTR_SUPRTXAM = "suprTxam";

    /** set 상여금_과세 : buamTxam */
    public static final String ATTR_BUAMTXAM = "buamTxam";

    /** set 인정상여금액 : inbsAmnt */
    public static final String ATTR_INBSAMNT = "inbsAmnt";

    /** set 주식행사이익금액 : stckInam */
    public static final String ATTR_STCKINAM = "stckInam";

    /** set 급여_상여합계금액 : spbmTxam */
    public static final String ATTR_SPBMTXAM = "spbmTxam";

    /** set 외국인소득금액_과세 : ecinTxam */
    public static final String ATTR_ECINTXAM = "ecinTxam";

    /** set 외국인소득금액_비과세 : taxmEcin */
    public static final String ATTR_TAXMECIN = "taxmEcin";

    /** set 자가운전보조금_비과세 : taxmEarn */
    public static final String ATTR_TAXMEARN = "taxmEarn";

    /** set 정액급식비_비과세 : taxmEtam */
    public static final String ATTR_TAXMETAM = "taxmEtam";

    /** set 정액급식비_과세 : txetTxam */
    public static final String ATTR_TXETTXAM = "txetTxam";

    /** set 출산보육수당_비과세 : addrBhtx */
    public static final String ATTR_ADDRBHTX = "addrBhtx";

    /** set 건강보험료금액 : spciHlth */
    public static final String ATTR_SPCIHLTH = "spciHlth";

    /** set 고용보험료금액 : spciEmpf */
    public static final String ATTR_SPCIEMPF = "spciEmpf";

    /** set 국민연금금액 : natnPsnf */
    public static final String ATTR_NATNPSNF = "natnPsnf";

    /** set 소득세 : earnTaxn */
    public static final String ATTR_EARNTAXN = "earnTaxn";

    /** set 지방소득세 : ihtxTaxn */
    public static final String ATTR_IHTXTAXN = "ihtxTaxn";

    /** set 기타금액_과세 : etccTxam */
    public static final String ATTR_ETCCTXAM = "etccTxam";

    /** set 기타금액_비과세 : etccEtam */
    public static final String ATTR_ETCCETAM = "etccEtam";

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
     public Yeta3210BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3210BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  elctYymm 
    		, String  systemkey 
    		, String  elctDate 
    		, BigDecimal  suprTxam 
    		, BigDecimal  buamTxam 
    		, BigDecimal  inbsAmnt 
    		, BigDecimal  stckInam 
    		, BigDecimal  spbmTxam 
    		, BigDecimal  ecinTxam 
    		, BigDecimal  taxmEcin 
    		, BigDecimal  taxmEarn 
    		, BigDecimal  taxmEtam 
    		, BigDecimal  txetTxam 
    		, BigDecimal  addrBhtx 
    		, BigDecimal  spciHlth 
    		, BigDecimal  spciEmpf 
    		, BigDecimal  natnPsnf 
    		, BigDecimal  earnTaxn 
    		, BigDecimal  ihtxTaxn 
    		, BigDecimal  etccTxam 
    		, BigDecimal  etccEtam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_ELCTYYMM,elctYymm);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_ELCTDATE,elctDate);
     	values.put(ATTR_SUPRTXAM,suprTxam);
     	values.put(ATTR_BUAMTXAM,buamTxam);
     	values.put(ATTR_INBSAMNT,inbsAmnt);
     	values.put(ATTR_STCKINAM,stckInam);
     	values.put(ATTR_SPBMTXAM,spbmTxam);
     	values.put(ATTR_ECINTXAM,ecinTxam);
     	values.put(ATTR_TAXMECIN,taxmEcin);
     	values.put(ATTR_TAXMEARN,taxmEarn);
     	values.put(ATTR_TAXMETAM,taxmEtam);
     	values.put(ATTR_TXETTXAM,txetTxam);
     	values.put(ATTR_ADDRBHTX,addrBhtx);
     	values.put(ATTR_SPCIHLTH,spciHlth);
     	values.put(ATTR_SPCIEMPF,spciEmpf);
     	values.put(ATTR_NATNPSNF,natnPsnf);
     	values.put(ATTR_EARNTAXN,earnTaxn);
     	values.put(ATTR_IHTXTAXN,ihtxTaxn);
     	values.put(ATTR_ETCCTXAM,etccTxam);
     	values.put(ATTR_ETCCETAM,etccEtam);
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

    /** set 지급년월 : elctYymm */
    public void setElctYymm(String  elctYymm) { set( ATTR_ELCTYYMM ,elctYymm);}
    /** get 지급년월 : elctYymm */
    public String  getElctYymm() { return (String )get( ATTR_ELCTYYMM );}
    
    /** set 성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 급여지급일자 : elctDate */
    public void setElctDate(String  elctDate) { set( ATTR_ELCTDATE ,elctDate);}
    /** get 급여지급일자 : elctDate */
    public String  getElctDate() { return (String )get( ATTR_ELCTDATE );}

    /** set 급여지급금액_과세 : suprTxam */
    public void setSuprTxam(BigDecimal  suprTxam) { set( ATTR_SUPRTXAM ,suprTxam);}
    /** get 급여지급금액_과세 : suprTxam */
    public BigDecimal  getSuprTxam() { return (BigDecimal )get( ATTR_SUPRTXAM );}

    /** set 상여금_과세 : buamTxam */
    public void setBuamTxam(BigDecimal  buamTxam) { set( ATTR_BUAMTXAM ,buamTxam);}
    /** get 상여금_과세 : buamTxam */
    public BigDecimal  getBuamTxam() { return (BigDecimal )get( ATTR_BUAMTXAM );}

    /** set 인정상여금액 : inbsAmnt */
    public void setInbsAmnt(BigDecimal  inbsAmnt) { set( ATTR_INBSAMNT ,inbsAmnt);}
    /** get 인정상여금액 : inbsAmnt */
    public BigDecimal  getInbsAmnt() { return (BigDecimal )get( ATTR_INBSAMNT );}

    /** set 주식행사이익금액 : stckInam */
    public void setStckInam(BigDecimal  stckInam) { set( ATTR_STCKINAM ,stckInam);}
    /** get 주식행사이익금액 : stckInam */
    public BigDecimal  getStckInam() { return (BigDecimal )get( ATTR_STCKINAM );}

    /** set 급여_상여합계금액 : spbmTxam */
    public void setSpbmTxam(BigDecimal  spbmTxam) { set( ATTR_SPBMTXAM ,spbmTxam);}
    /** get 급여_상여합계금액 : spbmTxam */
    public BigDecimal  getSpbmTxam() { return (BigDecimal )get( ATTR_SPBMTXAM );}

    /** set 외국인소득금액_과세 : ecinTxam */
    public void setEcinTxam(BigDecimal  ecinTxam) { set( ATTR_ECINTXAM ,ecinTxam);}
    /** get 외국인소득금액_과세 : ecinTxam */
    public BigDecimal  getEcinTxam() { return (BigDecimal )get( ATTR_ECINTXAM );}

    /** set 외국인소득금액_비과세 : taxmEcin */
    public void setTaxmEcin(BigDecimal  taxmEcin) { set( ATTR_TAXMECIN ,taxmEcin);}
    /** get 외국인소득금액_비과세 : taxmEcin */
    public BigDecimal  getTaxmEcin() { return (BigDecimal )get( ATTR_TAXMECIN );}

    /** set 자가운전보조금_비과세 : taxmEarn */
    public void setTaxmEarn(BigDecimal  taxmEarn) { set( ATTR_TAXMEARN ,taxmEarn);}
    /** get 자가운전보조금_비과세 : taxmEarn */
    public BigDecimal  getTaxmEarn() { return (BigDecimal )get( ATTR_TAXMEARN );}

    /** set 정액급식비_비과세 : taxmEtam */
    public void setTaxmEtam(BigDecimal  taxmEtam) { set( ATTR_TAXMETAM ,taxmEtam);}
    /** get 정액급식비_비과세 : taxmEtam */
    public BigDecimal  getTaxmEtam() { return (BigDecimal )get( ATTR_TAXMETAM );}

    /** set 정액급식비_과세 : txetTxam */
    public void setTxetTxam(BigDecimal  txetTxam) { set( ATTR_TXETTXAM ,txetTxam);}
    /** get 정액급식비_과세 : txetTxam */
    public BigDecimal  getTxetTxam() { return (BigDecimal )get( ATTR_TXETTXAM );}

    /** set 출산보육수당_비과세 : addrBhtx */
    public void setAddrBhtx(BigDecimal  addrBhtx) { set( ATTR_ADDRBHTX ,addrBhtx);}
    /** get 출산보육수당_비과세 : addrBhtx */
    public BigDecimal  getAddrBhtx() { return (BigDecimal )get( ATTR_ADDRBHTX );}

    /** set 건강보험료금액 : spciHlth */
    public void setSpciHlth(BigDecimal  spciHlth) { set( ATTR_SPCIHLTH ,spciHlth);}
    /** get 건강보험료금액 : spciHlth */
    public BigDecimal  getSpciHlth() { return (BigDecimal )get( ATTR_SPCIHLTH );}

    /** set 고용보험료금액 : spciEmpf */
    public void setSpciEmpf(BigDecimal  spciEmpf) { set( ATTR_SPCIEMPF ,spciEmpf);}
    /** get 고용보험료금액 : spciEmpf */
    public BigDecimal  getSpciEmpf() { return (BigDecimal )get( ATTR_SPCIEMPF );}

    /** set 국민연금금액 : natnPsnf */
    public void setNatnPsnf(BigDecimal  natnPsnf) { set( ATTR_NATNPSNF ,natnPsnf);}
    /** get 국민연금금액 : natnPsnf */
    public BigDecimal  getNatnPsnf() { return (BigDecimal )get( ATTR_NATNPSNF );}

    /** set 소득세 : earnTaxn */
    public void setEarnTaxn(BigDecimal  earnTaxn) { set( ATTR_EARNTAXN ,earnTaxn);}
    /** get 소득세 : earnTaxn */
    public BigDecimal  getEarnTaxn() { return (BigDecimal )get( ATTR_EARNTAXN );}

    /** set 지방소득세 : ihtxTaxn */
    public void setIhtxTaxn(BigDecimal  ihtxTaxn) { set( ATTR_IHTXTAXN ,ihtxTaxn);}
    /** get 지방소득세 : ihtxTaxn */
    public BigDecimal  getIhtxTaxn() { return (BigDecimal )get( ATTR_IHTXTAXN );}

    /** set 기타금액_과세 : etccTxam */
    public void setEtccTxam(BigDecimal  etccTxam) { set( ATTR_ETCCTXAM ,etccTxam);}
    /** get 기타금액_과세 : etccTxam */
    public BigDecimal  getEtccTxam() { return (BigDecimal )get( ATTR_ETCCTXAM );}

    /** set 기타금액_비과세 : etccEtam */
    public void setEtccEtam(BigDecimal  etccEtam) { set( ATTR_ETCCETAM ,etccEtam);}
    /** get 기타금액_비과세 : etccEtam */
    public BigDecimal  getEtccEtam() { return (BigDecimal )get( ATTR_ETCCETAM );}

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
