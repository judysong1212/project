package com.app.exterms.yearendtax.client.dto.yeta2020;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Ye160401BM.java
 * @since : 2017. 12. 11. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye160401BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 지급년월 : elctYymm */
    public static final String ATTR_ELCTYYMM = "elctYymm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 급여지급일자 : elctDate */
    public static final String ATTR_ELCTDATE = "elctDate";

    /** set 급여지급금액총액 : payPymtSumTotAmnt */
    public static final String ATTR_PAYPYMTSUMTOTAMNT = "payPymtSumTotAmnt";

    /** set 급여지급금액_비과세 : payPymtFreeDtySum */
    public static final String ATTR_PAYPYMTFREEDTYSUM = "payPymtFreeDtySum";

    /** set 급여지급금액_과세 : suprTxam */
    public static final String ATTR_SUPRTXAM = "suprTxam";

    /** set 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
    public static final String ATTR_CURRWORKFREEDTUSAMNT = "currWorkFreeDtusAmnt";

    /** set 현근무지상여금_과세 : buamTxam */
    public static final String ATTR_BUAMTXAM = "buamTxam";

    /** set 현근무지인정상여금액 : inbsAmnt */
    public static final String ATTR_INBSAMNT = "inbsAmnt";

    /** set 현근무지주식매수선택권행사이익금액 : stckInam */
    public static final String ATTR_STCKINAM = "stckInam";

    /** set 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
    public static final String ATTR_CURRWORKEMPTKWDRWSUM = "currWorkEmptkWdrwSum";

    /** set 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
    public static final String ATTR_CURRWORKECTERETCESUM = "currWorkEcteRetceSum";

    /** set 외국인소득금액_과세 : ecinTxam */
    public static final String ATTR_ECINTXAM = "ecinTxam";

    /** set 외국인소득금액_비과세 : taxmEcin */
    public static final String ATTR_TAXMECIN = "taxmEcin";

    /** set 현근무지건강보험료금액 : spciHlth */
    public static final String ATTR_SPCIHLTH = "spciHlth";

    /** set 현근무지요양보험료금액 : currWorkRcpInsurSum */
    public static final String ATTR_CURRWORKRCPINSURSUM = "currWorkRcpInsurSum";

    /** set 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
    public static final String ATTR_CURRWORKRCPAGGRSUM = "currWorkRcpAggrSum";

    /** set 현근무지고용보험료금액 : spciEmpf */
    public static final String ATTR_SPCIEMPF = "spciEmpf";

    /** set 현근무지국민연금금액 : natnPsnf */
    public static final String ATTR_NATNPSNF = "natnPsnf";

    /** set 현근무지소득세 : earnTaxn */
    public static final String ATTR_EARNTAXN = "earnTaxn";

    /** set 현근무지지방소득세 : ihtxTaxn */
    public static final String ATTR_IHTXTAXN = "ihtxTaxn";

    /** set 현근무지농특세금액 : nnksSsum */
    public static final String ATTR_NNKSSSUM = "nnksSsum";

    /** set 현근무지기타금액_과세 : etccTxam */
    public static final String ATTR_ETCCTXAM = "etccTxam";

    /** set 현근무지기타금액_비과세 : etccEtam */
    public static final String ATTR_ETCCETAM = "etccEtam";

    /** set 현근무지과세합계금액 : spbmTxam */
    public static final String ATTR_SPBMTXAM = "spbmTxam";

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
     public Ye160401BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye160401BM(
    		 String  elctYymm 
    		, String  systemkey 
    		, String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  elctDate 
    		, Long  payPymtSumTotAmnt 
    		, Long  payPymtFreeDtySum 
    		, Long  suprTxam 
    		, Long  currWorkFreeDtusAmnt 
    		, Long  buamTxam 
    		, Long  inbsAmnt 
    		, Long  stckInam 
    		, Long  currWorkEmptkWdrwSum 
    		, Long  currWorkEcteRetceSum 
    		, Long  ecinTxam 
    		, Long  taxmEcin 
    		, Long  spciHlth 
    		, Long  currWorkRcpInsurSum 
    		, Long  currWorkRcpAggrSum 
    		, Long  spciEmpf 
    		, Long  natnPsnf 
    		, Long  earnTaxn 
    		, Long  ihtxTaxn 
    		, Long  nnksSsum 
    		, Long  etccTxam 
    		, Long  etccEtam 
    		, Long  spbmTxam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_ELCTYYMM,elctYymm);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_ELCTDATE,elctDate);
     	values.put(ATTR_PAYPYMTSUMTOTAMNT,payPymtSumTotAmnt);
     	values.put(ATTR_PAYPYMTFREEDTYSUM,payPymtFreeDtySum);
     	values.put(ATTR_SUPRTXAM,suprTxam);
     	values.put(ATTR_CURRWORKFREEDTUSAMNT,currWorkFreeDtusAmnt);
     	values.put(ATTR_BUAMTXAM,buamTxam);
     	values.put(ATTR_INBSAMNT,inbsAmnt);
     	values.put(ATTR_STCKINAM,stckInam);
     	values.put(ATTR_CURRWORKEMPTKWDRWSUM,currWorkEmptkWdrwSum);
     	values.put(ATTR_CURRWORKECTERETCESUM,currWorkEcteRetceSum);
     	values.put(ATTR_ECINTXAM,ecinTxam);
     	values.put(ATTR_TAXMECIN,taxmEcin);
     	values.put(ATTR_SPCIHLTH,spciHlth);
     	values.put(ATTR_CURRWORKRCPINSURSUM,currWorkRcpInsurSum);
     	values.put(ATTR_CURRWORKRCPAGGRSUM,currWorkRcpAggrSum);
     	values.put(ATTR_SPCIEMPF,spciEmpf);
     	values.put(ATTR_NATNPSNF,natnPsnf);
     	values.put(ATTR_EARNTAXN,earnTaxn);
     	values.put(ATTR_IHTXTAXN,ihtxTaxn);
     	values.put(ATTR_NNKSSSUM,nnksSsum);
     	values.put(ATTR_ETCCTXAM,etccTxam);
     	values.put(ATTR_ETCCETAM,etccEtam);
     	values.put(ATTR_SPBMTXAM,spbmTxam);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 지급년월 : elctYymm */
    public void setElctYymm(String  elctYymm) { set( ATTR_ELCTYYMM ,elctYymm);}
    /** get 지급년월 : elctYymm */
    public String  getElctYymm() { return (String )get( ATTR_ELCTYYMM );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
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
    /** set 급여지급일자 : elctDate */
    public void setElctDate(String  elctDate) { set( ATTR_ELCTDATE ,elctDate);}
    /** get 급여지급일자 : elctDate */
    public String  getElctDate() { return (String )get( ATTR_ELCTDATE );}
    /** set 급여지급금액총액 : payPymtSumTotAmnt */
    public void setPayPymtSumTotAmnt(Long  payPymtSumTotAmnt) { set( ATTR_PAYPYMTSUMTOTAMNT ,payPymtSumTotAmnt);}
    /** get 급여지급금액총액 : payPymtSumTotAmnt */
    public Long  getPayPymtSumTotAmnt() { return (Long )get( ATTR_PAYPYMTSUMTOTAMNT );}
    /** set 급여지급금액_비과세 : payPymtFreeDtySum */
    public void setPayPymtFreeDtySum(Long  payPymtFreeDtySum) { set( ATTR_PAYPYMTFREEDTYSUM ,payPymtFreeDtySum);}
    /** get 급여지급금액_비과세 : payPymtFreeDtySum */
    public Long  getPayPymtFreeDtySum() { return (Long )get( ATTR_PAYPYMTFREEDTYSUM );}
    /** set 급여지급금액_과세 : suprTxam */
    public void setSuprTxam(Long  suprTxam) { set( ATTR_SUPRTXAM ,suprTxam);}
    /** get 급여지급금액_과세 : suprTxam */
    public Long  getSuprTxam() { return (Long )get( ATTR_SUPRTXAM );}
    /** set 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
    public void setCurrWorkFreeDtusAmnt(Long  currWorkFreeDtusAmnt) { set( ATTR_CURRWORKFREEDTUSAMNT ,currWorkFreeDtusAmnt);}
    /** get 현근무지상여금_비과세 : currWorkFreeDtusAmnt */
    public Long  getCurrWorkFreeDtusAmnt() { return (Long )get( ATTR_CURRWORKFREEDTUSAMNT );}
    /** set 현근무지상여금_과세 : buamTxam */
    public void setBuamTxam(Long  buamTxam) { set( ATTR_BUAMTXAM ,buamTxam);}
    /** get 현근무지상여금_과세 : buamTxam */
    public Long  getBuamTxam() { return (Long )get( ATTR_BUAMTXAM );}
    /** set 현근무지인정상여금액 : inbsAmnt */
    public void setInbsAmnt(Long  inbsAmnt) { set( ATTR_INBSAMNT ,inbsAmnt);}
    /** get 현근무지인정상여금액 : inbsAmnt */
    public Long  getInbsAmnt() { return (Long )get( ATTR_INBSAMNT );}
    /** set 현근무지주식매수선택권행사이익금액 : stckInam */
    public void setStckInam(Long  stckInam) { set( ATTR_STCKINAM ,stckInam);}
    /** get 현근무지주식매수선택권행사이익금액 : stckInam */
    public Long  getStckInam() { return (Long )get( ATTR_STCKINAM );}
    /** set 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
    public void setCurrWorkEmptkWdrwSum(Long  currWorkEmptkWdrwSum) { set( ATTR_CURRWORKEMPTKWDRWSUM ,currWorkEmptkWdrwSum);}
    /** get 현근무지우리사주조합인출금액 : currWorkEmptkWdrwSum */
    public Long  getCurrWorkEmptkWdrwSum() { return (Long )get( ATTR_CURRWORKEMPTKWDRWSUM );}
    /** set 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
    public void setCurrWorkEcteRetceSum(Long  currWorkEcteRetceSum) { set( ATTR_CURRWORKECTERETCESUM ,currWorkEcteRetceSum);}
    /** get 현근무지임원퇴직소득금액한도초과금액 : currWorkEcteRetceSum */
    public Long  getCurrWorkEcteRetceSum() { return (Long )get( ATTR_CURRWORKECTERETCESUM );}
    /** set 외국인소득금액_과세 : ecinTxam */
    public void setEcinTxam(Long  ecinTxam) { set( ATTR_ECINTXAM ,ecinTxam);}
    /** get 외국인소득금액_과세 : ecinTxam */
    public Long  getEcinTxam() { return (Long )get( ATTR_ECINTXAM );}
    /** set 외국인소득금액_비과세 : taxmEcin */
    public void setTaxmEcin(Long  taxmEcin) { set( ATTR_TAXMECIN ,taxmEcin);}
    /** get 외국인소득금액_비과세 : taxmEcin */
    public Long  getTaxmEcin() { return (Long )get( ATTR_TAXMECIN );}
    /** set 현근무지건강보험료금액 : spciHlth */
    public void setSpciHlth(Long  spciHlth) { set( ATTR_SPCIHLTH ,spciHlth);}
    /** get 현근무지건강보험료금액 : spciHlth */
    public Long  getSpciHlth() { return (Long )get( ATTR_SPCIHLTH );}
    /** set 현근무지요양보험료금액 : currWorkRcpInsurSum */
    public void setCurrWorkRcpInsurSum(Long  currWorkRcpInsurSum) { set( ATTR_CURRWORKRCPINSURSUM ,currWorkRcpInsurSum);}
    /** get 현근무지요양보험료금액 : currWorkRcpInsurSum */
    public Long  getCurrWorkRcpInsurSum() { return (Long )get( ATTR_CURRWORKRCPINSURSUM );}
    /** set 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
    public void setCurrWorkRcpAggrSum(Long  currWorkRcpAggrSum) { set( ATTR_CURRWORKRCPAGGRSUM ,currWorkRcpAggrSum);}
    /** get 현근무지건강요양보험료합계금액 : currWorkRcpAggrSum */
    public Long  getCurrWorkRcpAggrSum() { return (Long )get( ATTR_CURRWORKRCPAGGRSUM );}
    /** set 현근무지고용보험료금액 : spciEmpf */
    public void setSpciEmpf(Long  spciEmpf) { set( ATTR_SPCIEMPF ,spciEmpf);}
    /** get 현근무지고용보험료금액 : spciEmpf */
    public Long  getSpciEmpf() { return (Long )get( ATTR_SPCIEMPF );}
    /** set 현근무지국민연금금액 : natnPsnf */
    public void setNatnPsnf(Long  natnPsnf) { set( ATTR_NATNPSNF ,natnPsnf);}
    /** get 현근무지국민연금금액 : natnPsnf */
    public Long  getNatnPsnf() { return (Long )get( ATTR_NATNPSNF );}
    /** set 현근무지소득세 : earnTaxn */
    public void setEarnTaxn(Long  earnTaxn) { set( ATTR_EARNTAXN ,earnTaxn);}
    /** get 현근무지소득세 : earnTaxn */
    public Long  getEarnTaxn() { return (Long )get( ATTR_EARNTAXN );}
    /** set 현근무지지방소득세 : ihtxTaxn */
    public void setIhtxTaxn(Long  ihtxTaxn) { set( ATTR_IHTXTAXN ,ihtxTaxn);}
    /** get 현근무지지방소득세 : ihtxTaxn */
    public Long  getIhtxTaxn() { return (Long )get( ATTR_IHTXTAXN );}
    /** set 현근무지농특세금액 : nnksSsum */
    public void setNnksSsum(Long  nnksSsum) { set( ATTR_NNKSSSUM ,nnksSsum);}
    /** get 현근무지농특세금액 : nnksSsum */
    public Long  getNnksSsum() { return (Long )get( ATTR_NNKSSSUM );}
    /** set 현근무지기타금액_과세 : etccTxam */
    public void setEtccTxam(Long  etccTxam) { set( ATTR_ETCCTXAM ,etccTxam);}
    /** get 현근무지기타금액_과세 : etccTxam */
    public Long  getEtccTxam() { return (Long )get( ATTR_ETCCTXAM );}
    /** set 현근무지기타금액_비과세 : etccEtam */
    public void setEtccEtam(Long  etccEtam) { set( ATTR_ETCCETAM ,etccEtam);}
    /** get 현근무지기타금액_비과세 : etccEtam */
    public Long  getEtccEtam() { return (Long )get( ATTR_ETCCETAM );}
    /** set 현근무지과세합계금액 : spbmTxam */
    public void setSpbmTxam(Long  spbmTxam) { set( ATTR_SPBMTXAM ,spbmTxam);}
    /** get 현근무지과세합계금액 : spbmTxam */
    public Long  getSpbmTxam() { return (Long )get( ATTR_SPBMTXAM );}
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
