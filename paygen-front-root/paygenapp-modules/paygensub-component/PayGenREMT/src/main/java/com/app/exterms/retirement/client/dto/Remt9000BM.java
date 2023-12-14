package com.app.exterms.retirement.client.dto;



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
public class Remt9000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    

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

    /** set 현소속부서코드 : currAffnDeptCd */
    public static final String ATTR_CURRAFFNDEPTCD = "currAffnDeptCd";


    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";


    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";


    /** CURR_AFFN_DEPT_NM */
    public static final String ATTR_CURRAFFNDEPTNM = "currAffnDeptNm";
     
    /** TYP_OCCU_NM */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
     
    /** EMYMT_DIV_NM */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    public static final String ATTR_SEVEPAYCLUTMANGENUM = "sevePayClutMangeNum";

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public static final String ATTR_CALCSEVEPAYPSNBLGGYR = "calcSevePayPsnBlggYr";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set 입사일자 : icncDt */
    public static final String ATTR_ICNCDT = "icncDt";

    /** set 기산일자 : rkfcdDt */
    public static final String ATTR_RKFCDDT = "rkfcdDt";

    /** set 퇴사일자 : rsgtnDt */
    public static final String ATTR_RSGTNDT = "rsgtnDt";

    /** set 지급일자 : pymtDt */
    public static final String ATTR_PYMTDT = "pymtDt";

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    public static final String ATTR_EEPNMNTHICM2012BFR = "eepnMnthIcm2012Bfr";

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    public static final String ATTR_EEPNMNTHICM2013AFT = "eepnMnthIcm2013Aft";

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    public static final String ATTR_ADDMNTHICM2012BFR = "addMnthIcm2012Bfr";

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    public static final String ATTR_ADDMNTHICM2013AFT = "addMnthIcm2013Aft";

    /** set 퇴직급여액 : retryPayQnty */
    public static final String ATTR_RETRYPAYQNTY = "retryPayQnty";

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public static final String ATTR_FREEDTYRETRYPAYQNTY = "freeDtyRetryPayQnty";

    /** set 기납부세액 : alpayTxAmnt */
    public static final String ATTR_ALPAYTXAMNT = "alpayTxAmnt";

    /** set 지방소득세 : locIncmTxAmt */
    public static final String ATTR_LOCINCMTXAMT = "locIncmTxAmt";

    /** set 차인지급액 : pernPymtSum */
    public static final String ATTR_PERNPYMTSUM = "pernPymtSum";


    /** set 퇴직금가산율 : sevePayAddRate */
    public static final String ATTR_SEVEPAYADDRATE = "sevePayAddRate";

    
    /** set 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
    public static final String ATTR_SEVEPAYCTRCLUTNOTECTNT = "sevePayCtrClutNoteCtnt";

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
    
    

    /** set 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public static final String ATTR_CALCSEVEPAYPSNDIVNM = "calcSevePayPsnDivNm";
    

/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";


    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
               
    /** 생성자 */
     public Remt9000BM() { super(); } 


     /** 일괄등록 처리   */
      public Remt9000BM(
     		 String  dpobCd 
     		, String  systemkey 
     		, String  sevePayClutMangeNum 
     		, String  calcSevePayPsnBlggYr 
     		, String  calcSevePayPsnDivCd 
     		, String  icncDt 
     		, String  rkfcdDt 
     		, String  rsgtnDt 
     		, String  pymtDt 
     		, Long  eepnMnthIcm2012Bfr 
     		, Long  eepnMnthIcm2013Aft 
     		, Long  addMnthIcm2012Bfr 
     		, Long  addMnthIcm2013Aft 
     		, Long  retryPayQnty 
     		, Long  freeDtyRetryPayQnty 
     		, Long  alpayTxAmnt 
     		, Long  locIncmTxAmt 
     		, Long  pernPymtSum 
     		, String  sevePayCtrClutNoteCtnt 
     		, String  kybdr 
     		, String  inptDt 
     		, String  inptAddr 
     		, String  ismt 
     		, String  revnDt 
     		, String  revnAddr ) { 
      	values.put(ATTR_DPOBCD,dpobCd);
      	values.put(ATTR_SYSTEMKEY,systemkey);
      	values.put(ATTR_SEVEPAYCLUTMANGENUM,sevePayClutMangeNum);
      	values.put(ATTR_CALCSEVEPAYPSNBLGGYR,calcSevePayPsnBlggYr);
      	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
      	values.put(ATTR_ICNCDT,icncDt);
      	values.put(ATTR_RKFCDDT,rkfcdDt);
      	values.put(ATTR_RSGTNDT,rsgtnDt);
      	values.put(ATTR_PYMTDT,pymtDt);
      	values.put(ATTR_EEPNMNTHICM2012BFR,eepnMnthIcm2012Bfr);
      	values.put(ATTR_EEPNMNTHICM2013AFT,eepnMnthIcm2013Aft);
      	values.put(ATTR_ADDMNTHICM2012BFR,addMnthIcm2012Bfr);
      	values.put(ATTR_ADDMNTHICM2013AFT,addMnthIcm2013Aft);
      	values.put(ATTR_RETRYPAYQNTY,retryPayQnty);
      	values.put(ATTR_FREEDTYRETRYPAYQNTY,freeDtyRetryPayQnty);
      	values.put(ATTR_ALPAYTXAMNT,alpayTxAmnt);
      	values.put(ATTR_LOCINCMTXAMT,locIncmTxAmt);
      	values.put(ATTR_PERNPYMTSUM,pernPymtSum);
      	values.put(ATTR_SEVEPAYCTRCLUTNOTECTNT,sevePayCtrClutNoteCtnt);
      	values.put(ATTR_KYBDR,kybdr);
      	values.put(ATTR_INPTDT,inptDt);
      	values.put(ATTR_INPTADDR,inptAddr);
      	values.put(ATTR_ISMT,ismt);
      	values.put(ATTR_REVNDT,revnDt);
      	values.put(ATTR_REVNADDR,revnAddr); } 

        
      /** set 퇴직정산구분 : calcSevePayPsnDivNm */
      public void setCalcSevePayPsnDivNm(String  calcSevePayPsnDivNm) { set( ATTR_CALCSEVEPAYPSNDIVNM ,calcSevePayPsnDivNm);}
      /** get 퇴직정산구분 : calcSevePayPsnDivNm */
      public String  getCalcSevePayPsnDivNm() { return (String )get( ATTR_CALCSEVEPAYPSNDIVNM );}
    
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    public void setSevePayClutMangeNum(String  sevePayClutMangeNum) { set( ATTR_SEVEPAYCLUTMANGENUM ,sevePayClutMangeNum);}
    /** get 퇴직금정산관리번호 : sevePayClutMangeNum */
    public String  getSevePayClutMangeNum() { return (String )get( ATTR_SEVEPAYCLUTMANGENUM );}

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public void setCalcSevePayPsnBlggYr(String  calcSevePayPsnBlggYr) { set( ATTR_CALCSEVEPAYPSNBLGGYR ,calcSevePayPsnBlggYr);}
    /** get 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public String  getCalcSevePayPsnBlggYr() { return (String )get( ATTR_CALCSEVEPAYPSNBLGGYR );}

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}

    /** set 입사일자 : icncDt */
    public void setIcncDt(String  icncDt) { set( ATTR_ICNCDT ,icncDt);}
    /** get 입사일자 : icncDt */
    public String  getIcncDt() { return (String )get( ATTR_ICNCDT );}

    /** set 기산일자 : rkfcdDt */
    public void setRkfcdDt(String  rkfcdDt) { set( ATTR_RKFCDDT ,rkfcdDt);}
    /** get 기산일자 : rkfcdDt */
    public String  getRkfcdDt() { return (String )get( ATTR_RKFCDDT );}

    /** set 퇴사일자 : rsgtnDt */
    public void setRsgtnDt(String  rsgtnDt) { set( ATTR_RSGTNDT ,rsgtnDt);}
    /** get 퇴사일자 : rsgtnDt */
    public String  getRsgtnDt() { return (String )get( ATTR_RSGTNDT );}

    /** set 지급일자 : pymtDt */
    public void setPymtDt(String  pymtDt) { set( ATTR_PYMTDT ,pymtDt);}
    /** get 지급일자 : pymtDt */
    public String  getPymtDt() { return (String )get( ATTR_PYMTDT );}

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    public void setEepnMnthIcm2012Bfr(Long  eepnMnthIcm2012Bfr) { set( ATTR_EEPNMNTHICM2012BFR ,eepnMnthIcm2012Bfr);}
    /** get 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    public Long  getEepnMnthIcm2012Bfr() { return (Long )get( ATTR_EEPNMNTHICM2012BFR );}

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    public void setEepnMnthIcm2013Aft(Long  eepnMnthIcm2013Aft) { set( ATTR_EEPNMNTHICM2013AFT ,eepnMnthIcm2013Aft);}
    /** get 제외월수_2013이후 : eepnMnthIcm2013Aft */
    public Long  getEepnMnthIcm2013Aft() { return (Long )get( ATTR_EEPNMNTHICM2013AFT );}

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    public void setAddMnthIcm2012Bfr(Long  addMnthIcm2012Bfr) { set( ATTR_ADDMNTHICM2012BFR ,addMnthIcm2012Bfr);}
    /** get 가산월수_2012이전 : addMnthIcm2012Bfr */
    public Long  getAddMnthIcm2012Bfr() { return (Long )get( ATTR_ADDMNTHICM2012BFR );}

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    public void setAddMnthIcm2013Aft(Long  addMnthIcm2013Aft) { set( ATTR_ADDMNTHICM2013AFT ,addMnthIcm2013Aft);}
    /** get 가산월수_2013이후 : addMnthIcm2013Aft */
    public Long  getAddMnthIcm2013Aft() { return (Long )get( ATTR_ADDMNTHICM2013AFT );}

    /** set 퇴직급여액 : retryPayQnty */
    public void setRetryPayQnty(Long  retryPayQnty) { set( ATTR_RETRYPAYQNTY ,retryPayQnty);}
    /** get 퇴직급여액 : retryPayQnty */
    public Long  getRetryPayQnty() { return (Long )get( ATTR_RETRYPAYQNTY );}

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public void setFreeDtyRetryPayQnty(Long  freeDtyRetryPayQnty) { set( ATTR_FREEDTYRETRYPAYQNTY ,freeDtyRetryPayQnty);}
    /** get 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public Long  getFreeDtyRetryPayQnty() { return (Long )get( ATTR_FREEDTYRETRYPAYQNTY );}

    /** set 기납부세액 : alpayTxAmnt */
    public void setAlpayTxAmnt(Long  alpayTxAmnt) { set( ATTR_ALPAYTXAMNT ,alpayTxAmnt);}
    /** get 기납부세액 : alpayTxAmnt */
    public Long  getAlpayTxAmnt() { return (Long )get( ATTR_ALPAYTXAMNT );}

    /** set 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
    public void setSevePayCtrClutNoteCtnt(String  sevePayCtrClutNoteCtnt) { set( ATTR_SEVEPAYCTRCLUTNOTECTNT ,sevePayCtrClutNoteCtnt);}
    /** get 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
    public String  getSevePayCtrClutNoteCtnt() { return (String )get( ATTR_SEVEPAYCTRCLUTNOTECTNT );}

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
 
    /** set 현소속부서코드 : currAffnDeptCd */
    public void setCurrAffnDeptCd(String  currAffnDeptCd) { set( ATTR_CURRAFFNDEPTCD ,currAffnDeptCd);}
    /** get 현소속부서코드 : currAffnDeptCd */
    public String  getCurrAffnDeptCd() { return (String )get( ATTR_CURRAFFNDEPTCD );}
 
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
 
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
  
    /** set 지방소득세 : locIncmTxAmt */
    public void setLocIncmTxAmt(Long  locIncmTxAmt) { set( ATTR_LOCINCMTXAMT ,locIncmTxAmt);}
    /** get 지방소득세 : locIncmTxAmt */
    public Long  getLocIncmTxAmt() { return (Long )get( ATTR_LOCINCMTXAMT );}

    /** set 차인지급액 : pernPymtSum */
    public void setPernPymtSum(Long  pernPymtSum) { set( ATTR_PERNPYMTSUM ,pernPymtSum);}
    /** get 차인지급액 : pernPymtSum */
    public Long  getPernPymtSum() { return (Long )get( ATTR_PERNPYMTSUM );}



    /** set 퇴직금가산율 : sevePayAddRate */
    public void setSevePayAddRate(String  sevePayAddRate) { set( ATTR_SEVEPAYADDRATE ,sevePayAddRate);}
    /** get 퇴직금가산율 : sevePayAddRate */
    public String  getSevePayAddRate() { return (String )get( ATTR_SEVEPAYADDRATE );}
   
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


/** set 직종세 : dtilOccuClsDivNm */
public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
/** get 직종세 : dtilOccuClsDivNm */
public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}


 
}
