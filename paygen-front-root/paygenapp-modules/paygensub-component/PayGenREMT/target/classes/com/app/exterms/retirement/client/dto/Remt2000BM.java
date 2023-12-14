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
public class Remt2000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직위코드 : inbyCd */
    public static final String ATTR_INBYCD = "inbyCd";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";

    /** set 성명 : nm */
    public static final String ATTR_NM = "nm";

    /** set 입사일자 : icncDt */
    public static final String ATTR_ICNCDT = "icncDt";
    

/** set 기산일자 : rkfcdDt */
public static final String ATTR_RKFCDDT = "rkfcdDt";

    /** set 퇴직일자 : retryDt */
    public static final String ATTR_RETRYDT = "retryDt";

    /** set 근속년수 : logSvcYrNum */
    public static final String ATTR_LOGSVCYRNUM = "logSvcYrNum";

    /** set 근속월수 : logSvcMnthIcm */
    public static final String ATTR_LOGSVCMNTHICM = "logSvcMnthIcm";
    
    /** set 실근무년수 : turtyDutyYrNum */
    public static final String ATTR_TURTYDUTYYRNUM = "turtyDutyYrNum";

    /** set 실근무개월수 : turtyDutyMnthNum */
    public static final String ATTR_TURTYDUTYMNTHNUM = "turtyDutyMnthNum";

    /** set 실근무일수 : turtyDutyNumDys */
    public static final String ATTR_TURTYDUTYNUMDYS = "turtyDutyNumDys";

    /** set 군경력근속년수 : amcrrLogSvcYrNum */
    public static final String ATTR_AMCRRLOGSVCYRNUM = "amcrrLogSvcYrNum";

    /** set 군경력근속월수 : amcrrLogSvcMnthIcm */
    public static final String ATTR_AMCRRLOGSVCMNTHICM = "amcrrLogSvcMnthIcm";

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    public static final String ATTR_EEPNMNTHICM2012BFR = "eepnMnthIcm2012Bfr";

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    public static final String ATTR_EEPNMNTHICM2013AFT = "eepnMnthIcm2013Aft";

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    public static final String ATTR_ADDMNTHICM2012BFR = "addMnthIcm2012Bfr";

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    public static final String ATTR_ADDMNTHICM2013AFT = "addMnthIcm2013Aft";

    /** set 근속일수 : logSvcNumDys */
    public static final String ATTR_LOGSVCNUMDYS = "logSvcNumDys";
    
    /** set 제외일수 : eepnDayIcmDys */
    public static final String ATTR_EEPNDAYICMDYS = "eepnDayIcmDys";

    /** set 군경력근무일수 : amcrrLogSvcNumDys */
    public static final String ATTR_AMCRRLOGSVCNUMDYS = "amcrrLogSvcNumDys";

    /** set 급여산정시작일자 : payCmpttnBgnnDt */
    public static final String ATTR_PAYCMPTTNBGNNDT = "payCmpttnBgnnDt";

    /** set 급여산정종료일자 : payCmpttnEndDt */
    public static final String ATTR_PAYCMPTTNENDDT = "payCmpttnEndDt";

    /** set 기본급여합계금액 : fndtnPayAggrSumSum */
    public static final String ATTR_FNDTNPAYAGGRSUMSUM = "fndtnPayAggrSumSum";

    /** set 제수당합계금액 : snryAllwAggrSum */
    public static final String ATTR_SNRYALLWAGGRSUM = "snryAllwAggrSum";

    /** set 후생복지비합계금액 : welfWelfSpdgAggrSum */
    public static final String ATTR_WELFWELFSPDGAGGRSUM = "welfWelfSpdgAggrSum";

    /** set 3월간후생복지비 : marPubcWelfAmnt */
    public static final String ATTR_MARPUBCWELFAMNT = "marPubcWelfAmnt";

    /** set 3월간총임금액 : marTotAmntWag */
    public static final String ATTR_MARTOTAMNTWAG = "marTotAmntWag";

    /** set 1일평균임금액 : dayAvgAmntWag */
    public static final String ATTR_DAYAVGAMNTWAG = "dayAvgAmntWag";

    /** set 퇴직금산정금액 : sevePayCmpttnSum */
    public static final String ATTR_SEVEPAYCMPTTNSUM = "sevePayCmpttnSum";

    /** set 퇴직금가산금액 : sevePayAddSum */
    public static final String ATTR_SEVEPAYADDSUM = "sevePayAddSum";

    /** set 퇴직금가산율 : sevePayAddRate */
    public static final String ATTR_SEVEPAYADDRATE = "sevePayAddRate";

    /** set 퇴직금가산적용금액 : sevePayAddApptnSum */
    public static final String ATTR_SEVEPAYADDAPPTNSUM = "sevePayAddApptnSum";

    /** set 군경력정산포함여부 : amcrrClutInsnYn */
    public static final String ATTR_AMCRRCLUTINSNYN = "amcrrClutInsnYn";

    /** set 군경력가산적용금액 : amcrrAddApptnSum */
    public static final String ATTR_AMCRRADDAPPTNSUM = "amcrrAddApptnSum";

    /** set 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
    public static final String ATTR_SEVEPAYCMPTTNFREEDTYSUM = "sevePayCmpttnFreeDtySum";

    /** set 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
    public static final String ATTR_SEVEPAYCMPTTNTXTNSUM = "sevePayCmpttnTxtnSum";

    /** set 퇴직금지급공제금액 : sevePayPymtDducSum */
    public static final String ATTR_SEVEPAYPYMTDDUCSUM = "sevePayPymtDducSum";

    /** set 퇴직금실지급금액 : sevePayTurtyPymtSum */
    public static final String ATTR_SEVEPAYTURTYPYMTSUM = "sevePayTurtyPymtSum";

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    public static final String ATTR_SEVEPAYNOTECTNT = "sevePayNoteCtnt";

    /** set 퇴직금지급일자 : sevePayPymtDt */
    public static final String ATTR_SEVEPAYPYMTDT = "sevePayPymtDt";

    /** set 퇴직금지급여부 : sevePayPymtYn */
    public static final String ATTR_SEVEPAYPYMTYN = "sevePayPymtYn";

    /** set 마감여부 : ddlneYn */
    public static final String ATTR_DDLNEYN = "ddlneYn";

    /** set 마감일시 : ddlneDt */
    public static final String ATTR_DDLNEDT = "ddlneDt";

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

    /** set 총근무일수 : totLogSvcNumDys */
    public static final String ATTR_TOTLOGSVCNUMDYS = "totLogSvcNumDys";

    /** set 퇴직금지급액 : sevePayPymtSum */
    public static final String ATTR_SEVEPAYPYMTSUM = "sevePayPymtSum";
    
      

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    
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

 
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    /** set 퇴직정산구분 : calcSevePayPsnDivNm */
    public static final String ATTR_CALCSEVEPAYPSNDIVNM = "calcSevePayPsnDivNm";
    /** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
    public static final String ATTR_PYMTSUBTNINCMTXQNTY = "pymtSubtnIncmTxQnty";

    /** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
    public static final String ATTR_PYMTSUBTNRGONINCMTXQNTY = "pymtSubtnRgonIncmTxQnty";

    /** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
    public static final String ATTR_PYMTSUBTNFARVILSPCLQNTY = "pymtSubtnFarvilSpclQnty";
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
                                        
  
    /** 생성자 */
    public Remt2000BM() { super(); } 

   /** 일괄등록 처리   */
    public Remt2000BM(
   		 String  dpobCd 
   		, String  systemkey 
   		, String  calcSevePayPsnDivCd 
   		, String  clutYrMnth 
   		, String  emymtDivCd 
   		, String  deptCd 
   		, String  typOccuCd 
   		, String  pyspGrdeCd 
   		, String  dtilOccuClsDivCd 
   		, String  businCd 
   		, String  inbyCd 
   		, String  pyspCd 
   		, String  logSvcYrNumCd 
   		, String  logSvcMnthIcmCd 
   		, String  nm 
   		, String  icncDt 
   		, String  retryDt 
   		, Long  logSvcYrNum 
   		, Long  logSvcMnthIcm 
   		, Long  amcrrLogSvcYrNum 
   		, Long  amcrrLogSvcMnthIcm 
   		, Long  eepnMnthIcm2012Bfr 
   		, Long  eepnMnthIcm2013Aft 
   		, Long  addMnthIcm2012Bfr 
   		, Long  addMnthIcm2013Aft 
   		, Long  logSvcNumDys 
   		, Long  amcrrLogSvcNumDys 
   		, String  payCmpttnBgnnDt 
   		, String  payCmpttnEndDt 
   		, Long  fndtnPayAggrSumSum 
   		, Long  snryAllwAggrSum 
   		, Long  welfWelfSpdgAggrSum 
   		, Long  marPubcWelfAmnt 
   		, Long  marTotAmntWag 
   		, Long  dayAvgAmntWag 
   		, String  sevePayCmpttnSum 
   		, Long  sevePayAddSum 
   		, Long  sevePayAddRate 
   		, Long  sevePayAddApptnSum 
   		, String  amcrrClutInsnYn 
   		, Long  amcrrAddApptnSum 
   		, String  sevePayCmpttnFreeDtySum 
   		, String  sevePayCmpttnTxtnSum 
   		, Long  sevePayPymtDducSum 
   		, String  sevePayTurtyPymtSum 
   		, String  sevePayNoteCtnt 
   		, String  sevePayPymtDt 
   		, String  sevePayPymtYn 
   		, String  ddlneYn 
   		, String  ddlneDt 
   		, String  kybdr 
   		, String  inptDt 
   		, String  inptAddr 
   		, String  ismt 
   		, String  revnDt 
   		, String  revnAddr 
   		, Long  totLogSvcNumDys 
   		, Long  sevePayPymtSum ) { 
    	values.put(ATTR_DPOBCD,dpobCd);
    	values.put(ATTR_SYSTEMKEY,systemkey);
    	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
    	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
    	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
    	values.put(ATTR_DEPTCD,deptCd);
    	values.put(ATTR_TYPOCCUCD,typOccuCd);
    	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
    	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
    	values.put(ATTR_BUSINCD,businCd);
    	values.put(ATTR_INBYCD,inbyCd);
    	values.put(ATTR_PYSPCD,pyspCd);
    	values.put(ATTR_LOGSVCYRNUMCD,logSvcYrNumCd);
    	values.put(ATTR_LOGSVCMNTHICMCD,logSvcMnthIcmCd);
    	values.put(ATTR_NM,nm);
    	values.put(ATTR_ICNCDT,icncDt);
    	values.put(ATTR_RETRYDT,retryDt);
    	values.put(ATTR_LOGSVCYRNUM,logSvcYrNum);
    	values.put(ATTR_LOGSVCMNTHICM,logSvcMnthIcm);
    	values.put(ATTR_AMCRRLOGSVCYRNUM,amcrrLogSvcYrNum);
    	values.put(ATTR_AMCRRLOGSVCMNTHICM,amcrrLogSvcMnthIcm);
    	values.put(ATTR_EEPNMNTHICM2012BFR,eepnMnthIcm2012Bfr);
    	values.put(ATTR_EEPNMNTHICM2013AFT,eepnMnthIcm2013Aft);
    	values.put(ATTR_ADDMNTHICM2012BFR,addMnthIcm2012Bfr);
    	values.put(ATTR_ADDMNTHICM2013AFT,addMnthIcm2013Aft);
    	values.put(ATTR_LOGSVCNUMDYS,logSvcNumDys);
    	values.put(ATTR_AMCRRLOGSVCNUMDYS,amcrrLogSvcNumDys);
    	values.put(ATTR_PAYCMPTTNBGNNDT,payCmpttnBgnnDt);
    	values.put(ATTR_PAYCMPTTNENDDT,payCmpttnEndDt);
    	values.put(ATTR_FNDTNPAYAGGRSUMSUM,fndtnPayAggrSumSum);
    	values.put(ATTR_SNRYALLWAGGRSUM,snryAllwAggrSum);
    	values.put(ATTR_WELFWELFSPDGAGGRSUM,welfWelfSpdgAggrSum);
    	values.put(ATTR_MARPUBCWELFAMNT,marPubcWelfAmnt);
    	values.put(ATTR_MARTOTAMNTWAG,marTotAmntWag);
    	values.put(ATTR_DAYAVGAMNTWAG,dayAvgAmntWag);
    	values.put(ATTR_SEVEPAYCMPTTNSUM,sevePayCmpttnSum);
    	values.put(ATTR_SEVEPAYADDSUM,sevePayAddSum);
    	values.put(ATTR_SEVEPAYADDRATE,sevePayAddRate);
    	values.put(ATTR_SEVEPAYADDAPPTNSUM,sevePayAddApptnSum);
    	values.put(ATTR_AMCRRCLUTINSNYN,amcrrClutInsnYn);
    	values.put(ATTR_AMCRRADDAPPTNSUM,amcrrAddApptnSum);
    	values.put(ATTR_SEVEPAYCMPTTNFREEDTYSUM,sevePayCmpttnFreeDtySum);
    	values.put(ATTR_SEVEPAYCMPTTNTXTNSUM,sevePayCmpttnTxtnSum);
    	values.put(ATTR_SEVEPAYPYMTDDUCSUM,sevePayPymtDducSum);
    	values.put(ATTR_SEVEPAYTURTYPYMTSUM,sevePayTurtyPymtSum);
    	values.put(ATTR_SEVEPAYNOTECTNT,sevePayNoteCtnt);
    	values.put(ATTR_SEVEPAYPYMTDT,sevePayPymtDt);
    	values.put(ATTR_SEVEPAYPYMTYN,sevePayPymtYn);
    	values.put(ATTR_DDLNEYN,ddlneYn);
    	values.put(ATTR_DDLNEDT,ddlneDt);
    	values.put(ATTR_KYBDR,kybdr);
    	values.put(ATTR_INPTDT,inptDt);
    	values.put(ATTR_INPTADDR,inptAddr);
    	values.put(ATTR_ISMT,ismt);
    	values.put(ATTR_REVNDT,revnDt);
    	values.put(ATTR_REVNADDR,revnAddr);
    	values.put(ATTR_TOTLOGSVCNUMDYS,totLogSvcNumDys);
    	values.put(ATTR_SEVEPAYPYMTSUM,sevePayPymtSum); } 
 
	
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
	
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
	
	/** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
	public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
	/** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
	public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}
	
	/** set 정산년월 : clutYrMnth */
	public void setClutYrMnth(String  clutYrMnth) { set( ATTR_CLUTYRMNTH ,clutYrMnth);}
	/** get 정산년월 : clutYrMnth */
	public String  getClutYrMnth() { return (String )get( ATTR_CLUTYRMNTH );}
	
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
	
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
	
	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
	
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
	
	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
	
	/** set 직위코드 : inbyCd */
	public void setInbyCd(String  inbyCd) { set( ATTR_INBYCD ,inbyCd);}
	/** get 직위코드 : inbyCd */
	public String  getInbyCd() { return (String )get( ATTR_INBYCD );}
	
	/** set 호봉코드 : pyspCd */
	public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
	/** get 호봉코드 : pyspCd */
	public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}
	
	/** set 근속년수코드 : logSvcYrNumCd */
	public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
	/** get 근속년수코드 : logSvcYrNumCd */
	public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}
	
	/** set 근속월수코드 : logSvcMnthIcmCd */
	public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOGSVCMNTHICMCD ,logSvcMnthIcmCd);}
	/** get 근속월수코드 : logSvcMnthIcmCd */
	public String  getLogSvcMnthIcmCd() { return (String )get( ATTR_LOGSVCMNTHICMCD );}
	
	/** set 성명 : nm */
	public void setNm(String  nm) { set( ATTR_NM ,nm);}
	/** get 성명 : nm */
	public String  getNm() { return (String )get( ATTR_NM );}
	
	/** set 입사일자 : icncDt */
	public void setIcncDt(String  icncDt) { set( ATTR_ICNCDT ,icncDt);}
	/** get 입사일자 : icncDt */
	public String  getIcncDt() { return (String )get( ATTR_ICNCDT );}
	
	/** set 기산일자 : rkfcdDt */
	public void setRkfcdDt(String  rkfcdDt) { set( ATTR_RKFCDDT ,rkfcdDt);}
	/** get 기산일자 : rkfcdDt */
	public String  getRkfcdDt() { return (String )get( ATTR_RKFCDDT );}
	
	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
	/** get 퇴직일자 : retryDt */
	public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}
	
	/** set 근속년수 : logSvcYrNum */
	public void setLogSvcYrNum(Long  logSvcYrNum) { set( ATTR_LOGSVCYRNUM ,logSvcYrNum);}
	/** get 근속년수 : logSvcYrNum */
	public Long  getLogSvcYrNum() { return (Long )get( ATTR_LOGSVCYRNUM );}
	
	/** set 근속월수 : logSvcMnthIcm */
	public void setLogSvcMnthIcm(Long  logSvcMnthIcm) { set( ATTR_LOGSVCMNTHICM ,logSvcMnthIcm);}
	/** get 근속월수 : logSvcMnthIcm */
	public Long  getLogSvcMnthIcm() { return (Long )get( ATTR_LOGSVCMNTHICM );}
	
	/** set 군경력근속년수 : amcrrLogSvcYrNum */
	public void setAmcrrLogSvcYrNum(Long  amcrrLogSvcYrNum) { set( ATTR_AMCRRLOGSVCYRNUM ,amcrrLogSvcYrNum);}
	/** get 군경력근속년수 : amcrrLogSvcYrNum */
	public Long  getAmcrrLogSvcYrNum() { return (Long )get( ATTR_AMCRRLOGSVCYRNUM );}
	
	/** set 군경력근속월수 : amcrrLogSvcMnthIcm */
	public void setAmcrrLogSvcMnthIcm(Long  amcrrLogSvcMnthIcm) { set( ATTR_AMCRRLOGSVCMNTHICM ,amcrrLogSvcMnthIcm);}
	/** get 군경력근속월수 : amcrrLogSvcMnthIcm */
	public Long  getAmcrrLogSvcMnthIcm() { return (Long )get( ATTR_AMCRRLOGSVCMNTHICM );}
	
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
	
	/** set 근속일수 : logSvcNumDys */
	public void setLogSvcNumDys(Long  logSvcNumDys) { set( ATTR_LOGSVCNUMDYS ,logSvcNumDys);}
	/** get 근속일수 : logSvcNumDys */
	public Long  getLogSvcNumDys() { return (Long )get( ATTR_LOGSVCNUMDYS );}
	
	
	/** set 제외일수 : eepnDayIcmDys */
	public void setEepnDayIcmDys(Long  eepnDayIcmDys) { set( ATTR_EEPNDAYICMDYS ,eepnDayIcmDys);}
	/** get 제외일수 : eepnDayIcmDys */
	public Long  getEepnDayIcmDys() { return (Long )get( ATTR_EEPNDAYICMDYS );}
	
	/** set 군경력근무일수 : amcrrLogSvcNumDys */
	public void setAmcrrLogSvcNumDys(Long  amcrrLogSvcNumDys) { set( ATTR_AMCRRLOGSVCNUMDYS ,amcrrLogSvcNumDys);}
	/** get 군경력근무일수 : amcrrLogSvcNumDys */
	public Long  getAmcrrLogSvcNumDys() { return (Long )get( ATTR_AMCRRLOGSVCNUMDYS );}
	
	/** set 급여산정시작일자 : payCmpttnBgnnDt */
	public void setPayCmpttnBgnnDt(String  payCmpttnBgnnDt) { set( ATTR_PAYCMPTTNBGNNDT ,payCmpttnBgnnDt);}
	/** get 급여산정시작일자 : payCmpttnBgnnDt */
	public String  getPayCmpttnBgnnDt() { return (String )get( ATTR_PAYCMPTTNBGNNDT );}
	
	/** set 급여산정종료일자 : payCmpttnEndDt */
	public void setPayCmpttnEndDt(String  payCmpttnEndDt) { set( ATTR_PAYCMPTTNENDDT ,payCmpttnEndDt);}
	/** get 급여산정종료일자 : payCmpttnEndDt */
	public String  getPayCmpttnEndDt() { return (String )get( ATTR_PAYCMPTTNENDDT );}
	
	/** set 기본급여합계금액 : fndtnPayAggrSumSum */
	public void setFndtnPayAggrSumSum(Long  fndtnPayAggrSumSum) { set( ATTR_FNDTNPAYAGGRSUMSUM ,fndtnPayAggrSumSum);}
	/** get 기본급여합계금액 : fndtnPayAggrSumSum */
	public Long  getFndtnPayAggrSumSum() { return (Long )get( ATTR_FNDTNPAYAGGRSUMSUM );}
	
	/** set 제수당합계금액 : snryAllwAggrSum */
	public void setSnryAllwAggrSum(Long  snryAllwAggrSum) { set( ATTR_SNRYALLWAGGRSUM ,snryAllwAggrSum);}
	/** get 제수당합계금액 : snryAllwAggrSum */
	public Long  getSnryAllwAggrSum() { return (Long )get( ATTR_SNRYALLWAGGRSUM );}
	
	/** set 후생복지비합계금액 : welfWelfSpdgAggrSum */
	public void setWelfWelfSpdgAggrSum(Long  welfWelfSpdgAggrSum) { set( ATTR_WELFWELFSPDGAGGRSUM ,welfWelfSpdgAggrSum);}
	/** get 후생복지비합계금액 : welfWelfSpdgAggrSum */
	public Long  getWelfWelfSpdgAggrSum() { return (Long )get( ATTR_WELFWELFSPDGAGGRSUM );}
	
	/** set 3월간후생복지비 : marPubcWelfAmnt */
	public void setMarPubcWelfAmnt(Long  marPubcWelfAmnt) { set( ATTR_MARPUBCWELFAMNT ,marPubcWelfAmnt);}
	/** get 3월간후생복지비 : marPubcWelfAmnt */
	public Long  getMarPubcWelfAmnt() { return (Long )get( ATTR_MARPUBCWELFAMNT );}
	
	/** set 3월간총임금액 : marTotAmntWag */
	public void setMarTotAmntWag(Long  marTotAmntWag) { set( ATTR_MARTOTAMNTWAG ,marTotAmntWag);}
	/** get 3월간총임금액 : marTotAmntWag */
	public Long  getMarTotAmntWag() { return (Long )get( ATTR_MARTOTAMNTWAG );}
	
	/** set 1일평균임금액 : dayAvgAmntWag */
	public void setDayAvgAmntWag(Long  dayAvgAmntWag) { set( ATTR_DAYAVGAMNTWAG ,dayAvgAmntWag);}
	/** get 1일평균임금액 : dayAvgAmntWag */
	public Long  getDayAvgAmntWag() { return (Long )get( ATTR_DAYAVGAMNTWAG );}
	
	/** set 퇴직금산정금액 : sevePayCmpttnSum */
	public void setSevePayCmpttnSum(String  sevePayCmpttnSum) { set( ATTR_SEVEPAYCMPTTNSUM ,sevePayCmpttnSum);}
	/** get 퇴직금산정금액 : sevePayCmpttnSum */
	public String  getSevePayCmpttnSum() { return (String )get( ATTR_SEVEPAYCMPTTNSUM );}
	
	/** set 퇴직금가산금액 : sevePayAddSum */
	public void setSevePayAddSum(Long  sevePayAddSum) { set( ATTR_SEVEPAYADDSUM ,sevePayAddSum);}
	/** get 퇴직금가산금액 : sevePayAddSum */
	public Long  getSevePayAddSum() { return (Long )get( ATTR_SEVEPAYADDSUM );}
	
	/** set 퇴직금가산율 : sevePayAddRate */
	public void setSevePayAddRate(Long  sevePayAddRate) { set( ATTR_SEVEPAYADDRATE ,sevePayAddRate);}
	/** get 퇴직금가산율 : sevePayAddRate */
	public Long  getSevePayAddRate() { return (Long )get( ATTR_SEVEPAYADDRATE );}
	
	/** set 퇴직금가산적용금액 : sevePayAddApptnSum */
	public void setSevePayAddApptnSum(Long  sevePayAddApptnSum) { set( ATTR_SEVEPAYADDAPPTNSUM ,sevePayAddApptnSum);}
	/** get 퇴직금가산적용금액 : sevePayAddApptnSum */
	public Long  getSevePayAddApptnSum() { return (Long )get( ATTR_SEVEPAYADDAPPTNSUM );}
	
	/** set 군경력정산포함여부 : amcrrClutInsnYn */
	public void setAmcrrClutInsnYn(String  amcrrClutInsnYn) { set( ATTR_AMCRRCLUTINSNYN ,amcrrClutInsnYn);}
	/** get 군경력정산포함여부 : amcrrClutInsnYn */
	public String  getAmcrrClutInsnYn() { return (String )get( ATTR_AMCRRCLUTINSNYN );}
	
	/** set 군경력가산적용금액 : amcrrAddApptnSum */
	public void setAmcrrAddApptnSum(Long  amcrrAddApptnSum) { set( ATTR_AMCRRADDAPPTNSUM ,amcrrAddApptnSum);}
	/** get 군경력가산적용금액 : amcrrAddApptnSum */
	public Long  getAmcrrAddApptnSum() { return (Long )get( ATTR_AMCRRADDAPPTNSUM );}
	
	/** set 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
	public void setSevePayCmpttnFreeDtySum(String  sevePayCmpttnFreeDtySum) { set( ATTR_SEVEPAYCMPTTNFREEDTYSUM ,sevePayCmpttnFreeDtySum);}
	/** get 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
	public String  getSevePayCmpttnFreeDtySum() { return (String )get( ATTR_SEVEPAYCMPTTNFREEDTYSUM );}
	
	/** set 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
	public void setSevePayCmpttnTxtnSum(String  sevePayCmpttnTxtnSum) { set( ATTR_SEVEPAYCMPTTNTXTNSUM ,sevePayCmpttnTxtnSum);}
	/** get 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
	public String  getSevePayCmpttnTxtnSum() { return (String )get( ATTR_SEVEPAYCMPTTNTXTNSUM );}
	
	/** set 퇴직금지급공제금액 : sevePayPymtDducSum */
	public void setSevePayPymtDducSum(Long  sevePayPymtDducSum) { set( ATTR_SEVEPAYPYMTDDUCSUM ,sevePayPymtDducSum);}
	/** get 퇴직금지급공제금액 : sevePayPymtDducSum */
	public Long  getSevePayPymtDducSum() { return (Long )get( ATTR_SEVEPAYPYMTDDUCSUM );}
	
	/** set 퇴직금실지급금액 : sevePayTurtyPymtSum */
	public void setSevePayTurtyPymtSum(String  sevePayTurtyPymtSum) { set( ATTR_SEVEPAYTURTYPYMTSUM ,sevePayTurtyPymtSum);}
	/** get 퇴직금실지급금액 : sevePayTurtyPymtSum */
	public String  getSevePayTurtyPymtSum() { return (String )get( ATTR_SEVEPAYTURTYPYMTSUM );}
	
	/** set 퇴직금비고내용 : sevePayNoteCtnt */
	public void setSevePayNoteCtnt(String  sevePayNoteCtnt) { set( ATTR_SEVEPAYNOTECTNT ,sevePayNoteCtnt);}
	/** get 퇴직금비고내용 : sevePayNoteCtnt */
	public String  getSevePayNoteCtnt() { return (String )get( ATTR_SEVEPAYNOTECTNT );}
	
	/** set 퇴직금지급일자 : sevePayPymtDt */
	public void setSevePayPymtDt(String  sevePayPymtDt) { set( ATTR_SEVEPAYPYMTDT ,sevePayPymtDt);}
	/** get 퇴직금지급일자 : sevePayPymtDt */
	public String  getSevePayPymtDt() { return (String )get( ATTR_SEVEPAYPYMTDT );}
	
	/** set 퇴직금지급여부 : sevePayPymtYn */
	public void setSevePayPymtYn(String  sevePayPymtYn) { set( ATTR_SEVEPAYPYMTYN ,sevePayPymtYn);}
	/** get 퇴직금지급여부 : sevePayPymtYn */
	public String  getSevePayPymtYn() { return (String )get( ATTR_SEVEPAYPYMTYN );}
	
	/** set 마감여부 : ddlneYn */
	public void setDdlneYn(String  ddlneYn) { set( ATTR_DDLNEYN ,ddlneYn);}
	/** get 마감여부 : ddlneYn */
	public String  getDdlneYn() { return (String )get( ATTR_DDLNEYN );}
	
	/** set 마감일시 : ddlneDt */
	public void setDdlneDt(String  ddlneDt) { set( ATTR_DDLNEDT ,ddlneDt);}
	/** get 마감일시 : ddlneDt */
	public String  getDdlneDt() { return (String )get( ATTR_DDLNEDT );}
	
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
	
	/** set 총근무일수 : totLogSvcNumDys */
	public void setTotLogSvcNumDys(Long  totLogSvcNumDys) { set( ATTR_TOTLOGSVCNUMDYS ,totLogSvcNumDys);}
	/** get 총근무일수 : totLogSvcNumDys */
	public Long  getTotLogSvcNumDys() { return (Long )get( ATTR_TOTLOGSVCNUMDYS );}
	
	/** set 퇴직금지급액 : sevePayPymtSum */
	public void setSevePayPymtSum(Long  sevePayPymtSum) { set( ATTR_SEVEPAYPYMTSUM ,sevePayPymtSum);}
	/** get 퇴직금지급액 : sevePayPymtSum */
	public Long  getSevePayPymtSum() { return (Long )get( ATTR_SEVEPAYPYMTSUM );}
	
	
	
	
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
	
	
	/** set 호봉등급 : pyspGrdeNm */
	public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
	/** get 호봉등급 : pyspGrdeNm */
	public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
	
	
	/** set 퇴직정산구분 : calcSevePayPsnDivNm */
	public void setCalcSevePayPsnDivNm(String  calcSevePayPsnDivNm) { set( ATTR_CALCSEVEPAYPSNDIVNM ,calcSevePayPsnDivNm);}
	/** get 퇴직정산구분 : calcSevePayPsnDivNm */
	public String  getCalcSevePayPsnDivNm() { return (String )get( ATTR_CALCSEVEPAYPSNDIVNM );}


	/** set 실근무년수 : turtyDutyYrNum */
	public void setTurtyDutyYrNum(Long  turtyDutyYrNum) { set( ATTR_TURTYDUTYYRNUM ,turtyDutyYrNum);}
	/** get 실근무년수 : turtyDutyYrNum */
	public Long  getTurtyDutyYrNum() { return (Long )get( ATTR_TURTYDUTYYRNUM );}
	
	/** set 실근무개월수 : turtyDutyMnthNum */
	public void setTurtyDutyMnthNum(Long  turtyDutyMnthNum) { set( ATTR_TURTYDUTYMNTHNUM ,turtyDutyMnthNum);}
	/** get 실근무개월수 : turtyDutyMnthNum */
	public Long  getTurtyDutyMnthNum() { return (Long )get( ATTR_TURTYDUTYMNTHNUM );}
	
	/** set 실근무일수 : turtyDutyNumDys */
	public void setTurtyDutyNumDys(Long  turtyDutyNumDys) { set( ATTR_TURTYDUTYNUMDYS ,turtyDutyNumDys);}
	/** get 실근무일수 : turtyDutyNumDys */
	public Long  getTurtyDutyNumDys() { return (Long )get( ATTR_TURTYDUTYNUMDYS );}
  

/** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
public void setPymtSubtnIncmTxQnty(Long  pymtSubtnIncmTxQnty) { set( ATTR_PYMTSUBTNINCMTXQNTY ,pymtSubtnIncmTxQnty);}
/** get 납부차감_소득세액 : pymtSubtnIncmTxQnty */
public Long  getPymtSubtnIncmTxQnty() { return (Long )get( ATTR_PYMTSUBTNINCMTXQNTY );}

/** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
public void setPymtSubtnRgonIncmTxQnty(Long  pymtSubtnRgonIncmTxQnty) { set( ATTR_PYMTSUBTNRGONINCMTXQNTY ,pymtSubtnRgonIncmTxQnty);}
/** get 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
public Long  getPymtSubtnRgonIncmTxQnty() { return (Long )get( ATTR_PYMTSUBTNRGONINCMTXQNTY );}

/** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
public void setPymtSubtnFarvilSpclQnty(Long  pymtSubtnFarvilSpclQnty) { set( ATTR_PYMTSUBTNFARVILSPCLQNTY ,pymtSubtnFarvilSpclQnty);}
/** get 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
public Long  getPymtSubtnFarvilSpclQnty() { return (Long )get( ATTR_PYMTSUBTNFARVILSPCLQNTY );}

/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}




}

 


