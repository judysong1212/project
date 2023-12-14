package com.app.exterms.yearendtax.client.dto.yeta2022;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0301VO.java
 * @Description : Payr0301 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0301BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";

    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    

    /** set 급여일련번호 : payrSeilNum */
    public static final String ATTR_PAYRSEILNUM = "payrSeilNum";


    /** set 수당총액 : extpyTotAmnt */
    public static final String ATTR_EXTPYTOTAMNT = "extpyTotAmnt";

    /** set 과세총액 : txtnTotAmnt */
    public static final String ATTR_TXTNTOTAMNT = "txtnTotAmnt";

    /** set 비과세총액 : freeDtyTotAmnt */
    public static final String ATTR_FREEDTYTOTAMNT = "freeDtyTotAmnt";

    /** set 공제총액 : dducTotAmnt */
    public static final String ATTR_DDUCTOTAMNT = "dducTotAmnt";

    /** set 세금총액 : txTotAmnt */
    public static final String ATTR_TXTOTAMNT = "txTotAmnt";
    
    /** set 지방소득세 : lcTxTotAmnt */
    public static final String ATTR_LCTXTOTAMNT = "lcTxTotAmnt"; 
    
    /** set 퇴직금지급여부 : sevePayPymtYn */
    public static final String ATTR_SEVEPAYPYMTYN = "sevePayPymtYn";

    /** set 차인지급액 : pernPymtSum */
    public static final String ATTR_PERNPYMTSUM = "pernPymtSum";
    
    /** set 지급금액 : pernPymtSum */
    public static final String ATTR_PYMTTOTAMNT = "pymtTotAmnt";

    /** set 소득세징수비율 : incmTxCllnRto */
    public static final String ATTR_INCMTXCLLNRTO = "incmTxCllnRto";

    /** set 은행코드 : bnkCd */
    public static final String ATTR_BNKCD = "bnkCd";
    /** set 은행 : bnkNm */
    public static final String ATTR_BNKNM = "bnkNm";

    /** set 은행계좌번호 : bnkAccuNum */
    public static final String ATTR_BNKACCUNUM = "bnkAccuNum";

    /** set 예금주명 : acntHodrNm */
    public static final String ATTR_ACNTHODRNM = "acntHodrNm";

    /** set 급여마감일자 : payDdlneDt */
    public static final String ATTR_PAYDDLNEDT = "payDdlneDt";

    /** set 급여마감여부 : payDdlneYn */
    public static final String ATTR_PAYDDLNEYN = "payDdlneYn";

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

    /** column 기본급 : pymtB10100Sum */
    public static final String ATTR_PYMTB10100SUM = "pymtB10100Sum";
    
    /** column 소득세 : pymtT10100Sum */
    public static final String ATTR_PYMTT10100SUM = "pymtT10100Sum";
      
    /** column 주민세  : pymtT20100Sum */
    public static final String ATTR_PYMTT20100SUM = "pymtT20100Sum";
    

    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";


    /** set 호봉코드 : pyspNm */
    public static final String ATTR_PYSPNM = "pyspNm";

    
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
 
    /** set 근속년수코드 : logSvcYrNumNm */
    public static final String ATTR_LOGSVCYRNUMNM = "logSvcYrNumNm";
 
    /** set 근속월수코드 : logSvcMnthIcmNm */
    public static final String ATTR_LOGSVCMNTHICMNM = "logSvcMnthIcmNm";

    /** set 재직구분코드 : hdofcDivNm */
    public static final String ATTR_HDOFCDIVNM = "hdofcDivNm"; 

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";



    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";

    /** set 최초고용일자 : frstEmymtDt */
    public static final String ATTR_FRSTEMYMTDT = "frstEmymtDt";

    /** set 고용시작일자 : emymtBgnnDt */
    public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

    /** set 고용종료일자 : emymtEndDt */
    public static final String ATTR_EMYMTENDDT = "emymtEndDt";

    /** set 재직구분코드 : hdofcDivCd */
    public static final String ATTR_HDOFCDIVCD = "hdofcDivCd";

    /** set 퇴직일자 : retryDt */
    public static final String ATTR_RETRYDT = "retryDt";

    /** set 근속기준일자 : logSvcStdDt */
    public static final String ATTR_LOGSVCSTDDT = "logSvcStdDt";

    /** set 배우자유무 : spueYn */
    public static final String ATTR_SPUEYN = "spueYn";

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public static final String ATTR_SUPRTFAMYNUMTWENCHDN = "suprtFamyNumTwenChDn";

    /** set 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
    public static final String ATTR_SUPRTFAMYNUMTREOVRCHDN = "suprtFamyNumTreOvrChdn";

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    public static final String ATTR_SUPRTFAMYNUMETC = "suprtFamyNumEtc";

    /** set 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
    public static final String ATTR_SUPRTFAMY3CHDNEXTPYSUM = "suprtFamy3ChdnExtpySum";

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public static final String ATTR_CHDNSCHLEXPNADMCLYN = "chdnSchlExpnAdmclYn";

    /** set 건강보험등급 : hlthInsrGrde */
    public static final String ATTR_HLTHINSRGRDE = "hlthInsrGrde";

    /** set 국민연금등급 : natPennGrde */
    public static final String ATTR_NATPENNGRDE = "natPennGrde";

    /** set 월급여일당금액 : mnthPayDlywagSum */
    public static final String ATTR_MNTHPAYDLYWAGSUM = "mnthPayDlywagSum";

    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    
    // 2017.12.13 안양시청 요청으로 건강보험 및 노인장기요양보험 항목 추가
    /** set 건강보험료금액 : hlthInsrTotAmnt */
    public static final String ATTR_HLTHINSRTOTAMNT = "hlthInsrTotAmnt";;
    											       
    /** set 노인장기요양보험료금액 : rcptnInsrTotAmnt */
    public static final String ATTR_RCPTNINSRTOTAMNT = "rcptnInsrTotAmnt";
    
    // 2018.01.08 용인시청 요청으로 고용보험 및 국민연금 항목 추가
    /** set 국민연금료 : natInsrTotAmnt */
    public static final String ATTR_NATINSRTOTAMNT = "natInsrTotAmnt";;
    											       
    /** set 고용모험료 : rcptnInsrTotAmnt */
    public static final String ATTR_UMYTINSRTOTAMNT = "umytInsrTotAmnt";
    
 
    /** 생성자 */
     public Payr0301BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0301BM(
             String dpobCd
    		, String  pymtYrMnth 
    		, String  systemkey 
    		, String  payCd 
    		, String  payNm 
    		, String  payrMangDeptCd 
    		, String  payrMangDeptNm
    		, BigDecimal  payrSeilNum 
    		, BigDecimal  pymtTotAmnt 
    		, BigDecimal  extpyTotAmnt 
    		, BigDecimal  txtnTotAmnt 
    		, BigDecimal  freeDtyTotAmnt 
    		, BigDecimal  dducTotAmnt 
    		, BigDecimal  txTotAmnt 
    		, String  sevePayPymtYn 
    		, BigDecimal  pernPymtSum 
    		, BigDecimal  incmTxCllnRto 
    		, String  bnkCd 
    		, String  bnkAccuNum 
    		, String  acntHodrNm 
    		, String  payDdlneDt 
    		, String  payDdlneYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
         values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_PAYNM,payNm);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_PAYRMANGDEPTNM,payrMangDeptNm);
     	values.put(ATTR_PAYRSEILNUM,payrSeilNum);
     	values.put(ATTR_PYMTTOTAMNT,pymtTotAmnt);
     	values.put(ATTR_EXTPYTOTAMNT,extpyTotAmnt);
     	values.put(ATTR_TXTNTOTAMNT,txtnTotAmnt);
     	values.put(ATTR_FREEDTYTOTAMNT,freeDtyTotAmnt);
     	values.put(ATTR_DDUCTOTAMNT,dducTotAmnt);
     	values.put(ATTR_TXTOTAMNT,txTotAmnt);
     	values.put(ATTR_SEVEPAYPYMTYN,sevePayPymtYn);
     	values.put(ATTR_PERNPYMTSUM,pernPymtSum);
     	values.put(ATTR_INCMTXCLLNRTO,incmTxCllnRto);
     	values.put(ATTR_BNKCD,bnkCd);
     	values.put(ATTR_BNKACCUNUM,bnkAccuNum);
     	values.put(ATTR_ACNTHODRNM,acntHodrNm);
     	values.put(ATTR_PAYDDLNEDT,payDdlneDt);
     	values.put(ATTR_PAYDDLNEYN,payDdlneYn);
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

     
     
     /** set 기본급 : pymtB10100Sum */
     public void setPymtB10100Sum(Long  pymtB10100Sum) { set( ATTR_PYMTB10100SUM ,pymtB10100Sum);}
     /** get 기본급 : pymtB10100Sum */
     public Long  getPymtB10100Sum() { return (Long )get( ATTR_PYMTB10100SUM );}
      
     /** set 소득세 : pymtT10100Sum */
     public void setPymtT10100Sum(Long  pymtT10100Sum) { set( ATTR_PYMTT10100SUM ,pymtT10100Sum);}
     /** get 소득세 : pymtT10100Sum */
     public Long  getPymtT10100Sum() { return (Long )get( ATTR_PYMTT10100SUM );}
      
     /** set 주민세 : pymtT20100Sum */
     public void setPymtT20100Sum(Long  pymtT20100Sum) { set( ATTR_PYMTT20100SUM ,pymtT20100Sum);}
     /** get 주민세 : pymtT20100Sum */
     public Long  getPymtT20100Sum() { return (Long )get( ATTR_PYMTT20100SUM );}
     
    /** set 지급년월 : pymtYrMnth */
    public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
    /** get 지급년월 : pymtYrMnth */
    public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    
    /** set 단위기관코드 : payrMangDeptNm */
    public void setPayrMangDeptNm(String  payrMangDeptNm) { set( ATTR_PAYRMANGDEPTNM ,payrMangDeptNm);}
    /** get 단위기관코드 : payrMangDeptNm */
    public String  getPayrMangDeptNm() { return (String )get( ATTR_PAYRMANGDEPTNM );}

    /** set 급여일련번호 : payrSeilNum */
    public void setPayrSeilNum(Long  payrSeilNum) { set( ATTR_PAYRSEILNUM ,payrSeilNum);}
    /** get 급여일련번호 : payrSeilNum */
    public Long  getPayrSeilNum() { return (Long )get( ATTR_PAYRSEILNUM );}

    /** set 지급총액 : pymtTotAmnt */
    public void setPymtTotAmnt(Long  pymtTotAmnt) { set( ATTR_PYMTTOTAMNT ,pymtTotAmnt);}
    /** get 지급총액 : pymtTotAmnt */
    public Long  getPymtTotAmnt() { return (Long )get( ATTR_PYMTTOTAMNT );}

    /** set 수당총액 : extpyTotAmnt */
    public void setExtpyTotAmnt(Long  extpyTotAmnt) { set( ATTR_EXTPYTOTAMNT ,extpyTotAmnt);}
    /** get 수당총액 : extpyTotAmnt */
    public Long  getExtpyTotAmnt() { return (Long )get( ATTR_EXTPYTOTAMNT );}

    /** set 과세총액 : txtnTotAmnt */
    public void setTxtnTotAmnt(Long  txtnTotAmnt) { set( ATTR_TXTNTOTAMNT ,txtnTotAmnt);}
    /** get 과세총액 : txtnTotAmnt */
    public Long  getTxtnTotAmnt() { return (Long )get( ATTR_TXTNTOTAMNT );}

    /** set 비과세총액 : freeDtyTotAmnt */
    public void setFreeDtyTotAmnt(Long  freeDtyTotAmnt) { set( ATTR_FREEDTYTOTAMNT ,freeDtyTotAmnt);}
    /** get 비과세총액 : freeDtyTotAmnt */
    public Long  getFreeDtyTotAmnt() { return (Long )get( ATTR_FREEDTYTOTAMNT );}

    /** set 공제총액 : dducTotAmnt */
    public void setDducTotAmnt(Long  dducTotAmnt) { set( ATTR_DDUCTOTAMNT ,dducTotAmnt);}
    /** get 공제총액 : dducTotAmnt */
    public Long  getDducTotAmnt() { return (Long )get( ATTR_DDUCTOTAMNT );}

    /** set 세금총액 : txTotAmnt */
    public void setTxTotAmnt(Long  txTotAmnt) { set( ATTR_TXTOTAMNT ,txTotAmnt);}
    /** get 세금총액 : txTotAmnt */
    public Long  getTxTotAmnt() { return (Long )get( ATTR_TXTOTAMNT );}
 

    /** set 지방소득세 : lcTxTotAmnt */
    public void setLcTxTotAmnt(Long  lcTxTotAmnt) { set( ATTR_LCTXTOTAMNT ,lcTxTotAmnt);}
    /** get 지방소득세 : txTotAmnt */
    public Long  getLcTxTotAmnt() { return (Long )get( ATTR_LCTXTOTAMNT );}
    
    
    /** set 퇴직금지급여부 : sevePayPymtYn */
    public void setSevePayPymtYn(String  sevePayPymtYn) { set( ATTR_SEVEPAYPYMTYN ,sevePayPymtYn);}
    /** get 퇴직금지급여부 : sevePayPymtYn */
    public String  getSevePayPymtYn() { return (String )get( ATTR_SEVEPAYPYMTYN );}

    /** set 차인지급액 : pernPymtSum */
    public void setPernPymtSum(String  pernPymtSum) { set( ATTR_PERNPYMTSUM ,pernPymtSum);}
    /** get 차인지급액 : pernPymtSum */
    public Long  getPernPymtSum() { return Long.parseLong((String)get( ATTR_PERNPYMTSUM ));}

    /** set 소득세징수비율 : incmTxCllnRto */
    public void setIncmTxCllnRto(Double  incmTxCllnRto) { set( ATTR_INCMTXCLLNRTO ,incmTxCllnRto);}
    /** get 소득세징수비율 : incmTxCllnRto */
    public Double  getIncmTxCllnRto() { return (Double )get( ATTR_INCMTXCLLNRTO );}

    /** set 은행코드 : bnkCd */
    public void setBnkCd(String  bnkCd) { set( ATTR_BNKCD ,bnkCd);}
    /** get 은행코드 : bnkCd */
    public String  getBnkCd() { return (String )get( ATTR_BNKCD );}
    

    /** set 은행코드 : bnkNm */
    public void setBnkNm(String  bnkNm) { set( ATTR_BNKNM ,bnkNm);}
    /** get 은행코드 : bnkNm */
    public String  getBnkNm() { return (String )get( ATTR_BNKNM );}


    /** set 은행계좌번호 : bnkAccuNum */
    public void setBnkAccuNum(String  bnkAccuNum) { set( ATTR_BNKACCUNUM ,bnkAccuNum);}
    /** get 은행계좌번호 : bnkAccuNum */
    public String  getBnkAccuNum() { return (String )get( ATTR_BNKACCUNUM );}

    /** set 예금주명 : acntHodrNm */
    public void setAcntHodrNm(String  acntHodrNm) { set( ATTR_ACNTHODRNM ,acntHodrNm);}
    /** get 예금주명 : acntHodrNm */
    public String  getAcntHodrNm() { return (String )get( ATTR_ACNTHODRNM );}

    /** set 급여마감일자 : payDdlneDt */
    public void setPayDdlneDt(String  payDdlneDt) { set( ATTR_PAYDDLNEDT ,payDdlneDt);}
    /** get 급여마감일자 : payDdlneDt */
    public String  getPayDdlneDt() { return (String )get( ATTR_PAYDDLNEDT );}

    /** set 급여마감여부 : payDdlneYn */
    public void setPayDdlneYn(String  payDdlneYn) { set( ATTR_PAYDDLNEYN ,payDdlneYn);}
    /** get 급여마감여부 : payDdlneYn */
    public String  getPayDdlneYn() { return (String )get( ATTR_PAYDDLNEYN );}

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
 
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}

    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}


    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}

    /** set 호봉코드 : pyspCd */
    public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
    /** get 호봉코드 : pyspCd */
    public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 근속년수코드 : logSvcYrNumCd */
    public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
    /** get 근속년수코드 : logSvcYrNumCd */
    public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOGSVCMNTHICMCD ,logSvcMnthIcmCd);}
    /** get 근속월수코드 : logSvcMnthIcmCd */
    public String  getLogSvcMnthIcmCd() { return (String )get( ATTR_LOGSVCMNTHICMCD );}

    /** set 최초고용일자 : frstEmymtDt */
    public void setFrstEmymtDt(String  frstEmymtDt) { set( ATTR_FRSTEMYMTDT ,frstEmymtDt);}
    /** get 최초고용일자 : frstEmymtDt */
    public String  getFrstEmymtDt() { return (String )get( ATTR_FRSTEMYMTDT );}

    /** set 고용시작일자 : emymtBgnnDt */
    public void setEmymtBgnnDt(String  emymtBgnnDt) { set( ATTR_EMYMTBGNNDT ,emymtBgnnDt);}
    /** get 고용시작일자 : emymtBgnnDt */
    public String  getEmymtBgnnDt() { return (String )get( ATTR_EMYMTBGNNDT );}

    /** set 고용종료일자 : emymtEndDt */
    public void setEmymtEndDt(String  emymtEndDt) { set( ATTR_EMYMTENDDT ,emymtEndDt);}
    /** get 고용종료일자 : emymtEndDt */
    public String  getEmymtEndDt() { return (String )get( ATTR_EMYMTENDDT );}

    /** set 재직구분코드 : hdofcDivCd */
    public void setHdofcDivCd(String  hdofcDivCd) { set( ATTR_HDOFCDIVCD ,hdofcDivCd);}
    /** get 재직구분코드 : hdofcDivCd */
    public String  getHdofcDivCd() { return (String )get( ATTR_HDOFCDIVCD );}

    /** set 퇴직일자 : retryDt */
    public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
    /** get 퇴직일자 : retryDt */
    public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}

    /** set 근속기준일자 : logSvcStdDt */
    public void setLogSvcStdDt(String  logSvcStdDt) { set( ATTR_LOGSVCSTDDT ,logSvcStdDt);}
    /** get 근속기준일자 : logSvcStdDt */
    public String  getLogSvcStdDt() { return (String )get( ATTR_LOGSVCSTDDT );}

    /** set 배우자유무 : spueYn */
    public void setSpueYn(String  spueYn) { set( ATTR_SPUEYN ,spueYn);}
    /** get 배우자유무 : spueYn */
    public String  getSpueYn() { return (String )get( ATTR_SPUEYN );}

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public void setSuprtFamyNumTwenChDn(Long  suprtFamyNumTwenChDn) { set( ATTR_SUPRTFAMYNUMTWENCHDN ,suprtFamyNumTwenChDn);}
    /** get 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public Long  getSuprtFamyNumTwenChDn() { return (Long )get( ATTR_SUPRTFAMYNUMTWENCHDN );}

    /** set 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
    public void setSuprtFamyNumTreOvrChdn(Long  suprtFamyNumTreOvrChdn) { set( ATTR_SUPRTFAMYNUMTREOVRCHDN ,suprtFamyNumTreOvrChdn);}
    /** get 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
    public Long  getSuprtFamyNumTreOvrChdn() { return (Long )get( ATTR_SUPRTFAMYNUMTREOVRCHDN );}

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    public void setSuprtFamyNumEtc(Long  suprtFamyNumEtc) { set( ATTR_SUPRTFAMYNUMETC ,suprtFamyNumEtc);}
    /** get 부양가족수_기타 : suprtFamyNumEtc */
    public Long  getSuprtFamyNumEtc() { return (Long )get( ATTR_SUPRTFAMYNUMETC );}

    /** set 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
    public void setSuprtFamy3ChdnExtpySum(Long  suprtFamy3ChdnExtpySum) { set( ATTR_SUPRTFAMY3CHDNEXTPYSUM ,suprtFamy3ChdnExtpySum);}
    /** get 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
    public Long  getSuprtFamy3ChdnExtpySum() { return (Long )get( ATTR_SUPRTFAMY3CHDNEXTPYSUM );}

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public void setChdnSchlExpnAdmclYn(String  chdnSchlExpnAdmclYn) { set( ATTR_CHDNSCHLEXPNADMCLYN ,chdnSchlExpnAdmclYn);}
    /** get 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public String  getChdnSchlExpnAdmclYn() { return (String )get( ATTR_CHDNSCHLEXPNADMCLYN );}

    /** set 건강보험등급 : hlthInsrGrde */
    public void setHlthInsrGrde(String  hlthInsrGrde) { set( ATTR_HLTHINSRGRDE ,hlthInsrGrde);}
    /** get 건강보험등급 : hlthInsrGrde */
    public String  getHlthInsrGrde() { return (String )get( ATTR_HLTHINSRGRDE );}

    /** set 국민연금등급 : natPennGrde */
    public void setNatPennGrde(String  natPennGrde) { set( ATTR_NATPENNGRDE ,natPennGrde);}
    /** get 국민연금등급 : natPennGrde */
    public String  getNatPennGrde() { return (String )get( ATTR_NATPENNGRDE );}
 
    /** set 고용구분 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

    
    /** set 부서 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서 : deptNm  */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

    /** set 사업 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}

    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}

    /** set 직책 : odtyNm */
    public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
    /** get 직책 : odtyNm */
    public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}

    /** set 호봉 : pyspNm */
    public void setPyspNm(String  pyspNm) { set( ATTR_PYSPNM ,pyspNm);}
    /** get 호봉 : pyspNm */
    public String  getPyspNm() { return (String )get( ATTR_PYSPNM );}

    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

    /** set 근속년수 : logSvcYrNumNm */
    public void setLogSvcYrNumNm(String  logSvcYrNumNm) { set( ATTR_LOGSVCYRNUMNM ,logSvcYrNumNm);}
    /** get 근속년수 : logSvcYrNumNm */
    public String  getLogSvcYrNumNm() { return (String )get( ATTR_LOGSVCYRNUMNM );}

    /** set 근속월수 : logSvcMnthIcmNm */
    public void setLogSvcMnthIcmNm(String  logSvcMnthIcmNm) { set( ATTR_LOGSVCMNTHICMNM ,logSvcMnthIcmNm);}
    /** get 근속월수 : logSvcMnthIcmNm */
    public String  getLogSvcMnthIcmNm() { return (String )get( ATTR_LOGSVCMNTHICMNM );}
    
    /** set 재직구분 : hdofcDivNm */
    public void setHdofcDivNM(String  hdofcDivNm) { set( ATTR_HDOFCDIVNM ,hdofcDivNm);}
    /** get 재직구분 : hdofcDivNm */
    public String  getHdofcDivNm() { return (String )get( ATTR_HDOFCDIVNM );}

    /** set 월급여일당금액 : mnthPayDlywagSum */
    public void setMnthPayDlywagSum(Long  mnthPayDlywagSum) { set( ATTR_MNTHPAYDLYWAGSUM ,mnthPayDlywagSum);}
    /** get 월급여일당금액 : mnthPayDlywagSum */
    public Long getMnthPayDlywagSum() { return (Long )get( ATTR_MNTHPAYDLYWAGSUM );}
    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
	
    
	/** set 건강보험료금액 : hlthInsrTotAmnt */
	public void setHlthInsrTotAmnt(Long  hlthInsrTotAmnt) { set( ATTR_HLTHINSRTOTAMNT ,hlthInsrTotAmnt);}
	/** get 건강보험료금액 : hlthInsrTotAmnt */
	public Long   getHlthInsrTotAmnt() { return (Long )get( ATTR_HLTHINSRTOTAMNT );}
	
	/** set 노인장기요양보험료금액 : rcptnInsrTotAmnt */
	public void setRcptnInsrTotAmnt(Long  rcptnInsrTotAmnt) { set( ATTR_RCPTNINSRTOTAMNT ,rcptnInsrTotAmnt);}
	/** get 노인장기요양보험료금액 : rcptnInsrTotAmnt */
	public Long   getRcptnInsrTotAmnt() { return (Long )get( ATTR_RCPTNINSRTOTAMNT );}
	
	/** set 국민연금료 : natInsrTotAmnt */
	public void setNatInsrTotAmnt(Long  natInsrTotAmnt) { set( ATTR_NATINSRTOTAMNT ,natInsrTotAmnt);}
	/** get 국민연금료 : natInsrTotAmnt */
	public Long   getNatInsrTotAmnt() { return (Long )get( ATTR_NATINSRTOTAMNT );}
	
	/** set 노인장기요양보험료금액 : umytInsrTotAmnt */
	public void setUmytInsrTotAmnt(Long  umytInsrTotAmnt) { set( ATTR_UMYTINSRTOTAMNT ,umytInsrTotAmnt);}
	/** get 노인장기요양보험료금액 : umytInsrTotAmnt */
	public Long   getUmytInsrTotAmnt() { return (Long )get( ATTR_UMYTINSRTOTAMNT );}
	
	
	


}
