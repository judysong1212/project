package com.app.exterms.payroll.client.dto;

 

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0500VO.java
 * @Description : Payr0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0500BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    
    
    /**  column 노조가입여부 : unnMbspSttYn */
    public static final String ATTR_UNNMBSPSTTYN = "unnMbspSttYn";
    
    /** set 노조가입여부  : befIncmTxApptnRtoCd */
    public void setUnnMbspSttYn(String  unnMbspSttYn) { set( ATTR_UNNMBSPSTTYN ,unnMbspSttYn);}
    /** get 노조가입여부  : befIncmTxApptnRtoCd */
    public String  getUnnMbspSttYn() { return (String )get( ATTR_UNNMBSPSTTYN );}
    
    /**  column 호봉 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";
    
    /**  column 호봉 : pyspNm */
    public static final String ATTR_PYSPNM = "pyspNm";
    
    /** set 호봉  : pyspCd */
    public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
    /** get 호봉  : pyspCd */
    public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}
    
    /** set 호봉  : pyspNm */
    public void setPyspNm(String  pyspNm) { set( ATTR_PYSPNM ,pyspNm);}
    /** get 호봉  : pyspCd */
    public String  getPyspNm() { return (String )get( ATTR_PYSPNM );}
    
    

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 근속기준일자 : logSvcStdDt */
    public static final String ATTR_LOGSVCSTDDT = "logSvcStdDt";

    /** set 부녀자여부 : wmnYn */
    public static final String ATTR_WMNYN = "wmnYn";

    /** set 퇴직정산여부 : retryClutYn */
    public static final String ATTR_RETRYCLUTYN = "retryClutYn";

    /** set 급여대상자여부 : payRcptYn */
    public static final String ATTR_PAYRCPTYN = "payRcptYn";

    /** set 배우자유무 : spueYn */
    public static final String ATTR_SPUEYN = "spueYn";

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    public static final String ATTR_HLTHINSRAPPTNYN = "hlthInsrApptnYn";

    /** set 국민연금적용여부 : natPennApptnYn */
    public static final String ATTR_NATPENNAPPTNYN = "natPennApptnYn";

    /** set 고용보험적용여부 : umytInsrApptnYn */
    public static final String ATTR_UMYTINSRAPPTNYN = "umytInsrApptnYn";

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public static final String ATTR_IDTLACCDTINSURAPPTNYN = "idtlAccdtInsurApptnYn";

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public static final String ATTR_SUPRTFAMYNUMTWENCHDN = "suprtFamyNumTwenChDn";

    /** set 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
    public static final String ATTR_SUPRTFAMYNUMTREOVRCHDNYN = "suprtFamyNumTreOvrChdnYn";

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    public static final String ATTR_SUPRTFAMYNUMETC = "suprtFamyNumEtc";

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public static final String ATTR_CHDNSCHLEXPNADMCLYN = "chdnSchlExpnAdmclYn";

    /** set 근속수당적용여부 : logSvcExtpyApptnYn */
    public static final String ATTR_LOGSVCEXTPYAPPTNYN = "logSvcExtpyApptnYn";

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

    /** set 월급여일당금액 : mnthPayDlywagSum */
    public static final String ATTR_MNTHPAYDLYWAGSUM = "mnthPayDlywagSum";


    /** set 사업장코드 : dpobNm */
    public static final String ATTR_DPOBNM = "dpobNm";
 

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
 

    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";
   
    /** set 일용직구분 : dayWorkYn */
    public static final String ATTR_DAYWORKYN = "dayWorkYn";
    
    /** set 급여소득세제외여부  : payrIncmExceYn */
   public static final String ATTR_PAYRINCMEXCEYN = "payrIncmExceYn"; 
  
    
	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	public static final String ATTR_ADDINCMTXAPPTNRTOCD = "addIncmTxApptnRtoCd";
	
	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoNm */
	public static final String ATTR_ADDINCMTXAPPTNRTONM = "addIncmTxApptnRtoNm";
	
	/** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
	public static final String ATTR_ADDINCMTXAPPTNYRMNTH = "addIncmTxApptnYrMnth";
	
	/** set 추가소득세적용여부 : addIncmTxApptnYn */
	public static final String ATTR_ADDINCMTXAPPTNYN = "addIncmTxApptnYn";

	
	 
    /** set 이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
	public static final String ATTR_BEFINCMTXAPPTNRTOCD = "befIncmTxApptnRtoCd";

    /** set 이전 추가소득세적용년월 : befIncmTxApptnYrMnth */
	public static final String ATTR_BEFINCMTXAPPTNYRMNTH = "befIncmTxApptnYrMnth";

    /** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
	public static final String ATTR_BEFINCMTXAPPTNYN = "befIncmTxApptnYn";
     
    /** set 해당년도 추가소득세적용갯수 : addIncmTxApptnCnt */
	public static final String ATTR_ADDINCMTXAPPTNCNT = "addIncmTxApptnCnt";
    
    
    /** 생성자 */
     public Payr0500BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0500BM(
             String  dpobCd 
            , String  systemkey 
            , String  payrMangDeptCd 
            , String  emymtDivCd 
            , String  logSvcStdDt 
            , String  wmnYn 
            , String  retryClutYn 
            , String  payRcptYn 
            , String  spueYn 
            , String  hlthInsrApptnYn 
            , String  natPennApptnYn 
            , String  umytInsrApptnYn 
            , String  idtlAccdtInsurApptnYn 
            , Long  suprtFamyNumTwenChDn 
            , String  suprtFamyNumTreOvrChdnYn 
            , Long  suprtFamyNumEtc 
            , String  chdnSchlExpnAdmclYn 
            , String  logSvcExtpyApptnYn 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr 
            , Long  mnthPayDlywagSum ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
        values.put(ATTR_EMYMTDIVCD,emymtDivCd);
        values.put(ATTR_LOGSVCSTDDT,logSvcStdDt);
        values.put(ATTR_WMNYN,wmnYn);
        values.put(ATTR_RETRYCLUTYN,retryClutYn);
        values.put(ATTR_PAYRCPTYN,payRcptYn);
        values.put(ATTR_SPUEYN,spueYn);
        values.put(ATTR_HLTHINSRAPPTNYN,hlthInsrApptnYn);
        values.put(ATTR_NATPENNAPPTNYN,natPennApptnYn);
        values.put(ATTR_UMYTINSRAPPTNYN,umytInsrApptnYn);
        values.put(ATTR_IDTLACCDTINSURAPPTNYN,idtlAccdtInsurApptnYn);
        values.put(ATTR_SUPRTFAMYNUMTWENCHDN,suprtFamyNumTwenChDn);
        values.put(ATTR_SUPRTFAMYNUMTREOVRCHDNYN,suprtFamyNumTreOvrChdnYn);
        values.put(ATTR_SUPRTFAMYNUMETC,suprtFamyNumEtc);
        values.put(ATTR_CHDNSCHLEXPNADMCLYN,chdnSchlExpnAdmclYn);
        values.put(ATTR_LOGSVCEXTPYAPPTNYN,logSvcExtpyApptnYn);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_MNTHPAYDLYWAGSUM,mnthPayDlywagSum); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 근속기준일자 : logSvcStdDt */
    public void setLogSvcStdDt(String  logSvcStdDt) { set( ATTR_LOGSVCSTDDT ,logSvcStdDt);}
    /** get 근속기준일자 : logSvcStdDt */
    public String  getLogSvcStdDt() { return (String )get( ATTR_LOGSVCSTDDT );}

    /** set 부녀자여부 : wmnYn */
    public void setWmnYn(String  wmnYn) { set( ATTR_WMNYN ,wmnYn);}
    /** get 부녀자여부 : wmnYn */
    public String  getWmnYn() { return (String )get( ATTR_WMNYN );}

    /** set 퇴직정산여부 : retryClutYn */
    public void setRetryClutYn(String  retryClutYn) { set( ATTR_RETRYCLUTYN ,retryClutYn);}
    /** get 퇴직정산여부 : retryClutYn */
    public String  getRetryClutYn() { return (String )get( ATTR_RETRYCLUTYN );}

    /** set 급여대상자여부 : payRcptYn */
    public void setPayRcptYn(String  payRcptYn) { set( ATTR_PAYRCPTYN ,payRcptYn);}
    /** get 급여대상자여부 : payRcptYn */
    public String  getPayRcptYn() { return (String )get( ATTR_PAYRCPTYN );}

    /** set 배우자유무 : spueYn */
    public void setSpueYn(String  spueYn) { set( ATTR_SPUEYN ,spueYn);}
    /** get 배우자유무 : spueYn */
    public String  getSpueYn() { return (String )get( ATTR_SPUEYN );}

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    public void setHlthInsrApptnYn(String  hlthInsrApptnYn) { set( ATTR_HLTHINSRAPPTNYN ,hlthInsrApptnYn);}
    /** get 건강보험적용여부 : hlthInsrApptnYn */
    public String  getHlthInsrApptnYn() { return (String )get( ATTR_HLTHINSRAPPTNYN );}

    /** set 국민연금적용여부 : natPennApptnYn */
    public void setNatPennApptnYn(String  natPennApptnYn) { set( ATTR_NATPENNAPPTNYN ,natPennApptnYn);}
    /** get 국민연금적용여부 : natPennApptnYn */
    public String  getNatPennApptnYn() { return (String )get( ATTR_NATPENNAPPTNYN );}

    /** set 고용보험적용여부 : umytInsrApptnYn */
    public void setUmytInsrApptnYn(String  umytInsrApptnYn) { set( ATTR_UMYTINSRAPPTNYN ,umytInsrApptnYn);}
    /** get 고용보험적용여부 : umytInsrApptnYn */
    public String  getUmytInsrApptnYn() { return (String )get( ATTR_UMYTINSRAPPTNYN );}

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public void setIdtlAccdtInsurApptnYn(String  idtlAccdtInsurApptnYn) { set( ATTR_IDTLACCDTINSURAPPTNYN ,idtlAccdtInsurApptnYn);}
    /** get 산재보험적용여부 : idtlAccdtInsurApptnYn */
    public String  getIdtlAccdtInsurApptnYn() { return (String )get( ATTR_IDTLACCDTINSURAPPTNYN );}

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public void setSuprtFamyNumTwenChDn(Long  suprtFamyNumTwenChDn) { set( ATTR_SUPRTFAMYNUMTWENCHDN ,suprtFamyNumTwenChDn);}
    /** get 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    public Long  getSuprtFamyNumTwenChDn() { return (Long )get( ATTR_SUPRTFAMYNUMTWENCHDN );}

    /** set 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
    public void setSuprtFamyNumTreOvrChdnYn(String  suprtFamyNumTreOvrChdnYn) { set( ATTR_SUPRTFAMYNUMTREOVRCHDNYN ,suprtFamyNumTreOvrChdnYn);}
    /** get 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
    public String  getSuprtFamyNumTreOvrChdnYn() { return (String )get( ATTR_SUPRTFAMYNUMTREOVRCHDNYN );}

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    public void setSuprtFamyNumEtc(Long  suprtFamyNumEtc) { set( ATTR_SUPRTFAMYNUMETC ,suprtFamyNumEtc);}
    /** get 부양가족수_기타 : suprtFamyNumEtc */
    public Long  getSuprtFamyNumEtc() { return (Long )get( ATTR_SUPRTFAMYNUMETC );}

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public void setChdnSchlExpnAdmclYn(String  chdnSchlExpnAdmclYn) { set( ATTR_CHDNSCHLEXPNADMCLYN ,chdnSchlExpnAdmclYn);}
    /** get 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    public String  getChdnSchlExpnAdmclYn() { return (String )get( ATTR_CHDNSCHLEXPNADMCLYN );}

    /** set 근속수당적용여부 : logSvcExtpyApptnYn */
    public void setLogSvcExtpyApptnYn(String  logSvcExtpyApptnYn) { set( ATTR_LOGSVCEXTPYAPPTNYN ,logSvcExtpyApptnYn);}
    /** get 근속수당적용여부 : logSvcExtpyApptnYn */
    public String  getLogSvcExtpyApptnYn() { return (String )get( ATTR_LOGSVCEXTPYAPPTNYN );}

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

    /** set 월급여일당금액 : mnthPayDlywagSum */
    public void setMnthPayDlywagSum(Long  mnthPayDlywagSum) { set( ATTR_MNTHPAYDLYWAGSUM ,mnthPayDlywagSum);}
    /** get 월급여일당금액 : mnthPayDlywagSum */
    public Long  getMnthPayDlywagSum() { return (Long )get( ATTR_MNTHPAYDLYWAGSUM );}
  
    /** set 일용직구분 : dayWorkYn */
    public void setDayWorkYn(String  dayWorkYn) { set( ATTR_DAYWORKYN ,dayWorkYn);}
    /** set 일용직구분 : dayWorkYn */
    public String  getDayWorkYn() { return (String )get( ATTR_DAYWORKYN );}

    /** set 일용직구분 : payrIncmExceYn */
    public void setPayrIncmExceYn(String  payrIncmExceYn) { set( ATTR_PAYRINCMEXCEYN ,payrIncmExceYn);}
    /** set 일용직구분 : payrIncmExceYn */
    public String  getPayrIncmExceYn() { return (String )get( ATTR_PAYRINCMEXCEYN );}
 
    
/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
public void setAddIncmTxApptnRtoCd(String  addIncmTxApptnRtoCd) { set( ATTR_ADDINCMTXAPPTNRTOCD ,addIncmTxApptnRtoCd);}
/** get 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
public String  getAddIncmTxApptnRtoCd() { return (String )get( ATTR_ADDINCMTXAPPTNRTOCD );}


/** set 추가소득세적용비율 : addIncmTxApptnRtoNm */
public void setAddIncmTxApptnRtoNm(String  addIncmTxApptnRtoNm) { set( ATTR_ADDINCMTXAPPTNRTONM ,addIncmTxApptnRtoNm);}
/** get 추가소득세적용비율 : addIncmTxApptnRtoNm */
public String  getAddIncmTxApptnRtoNm() { return (String )get( ATTR_ADDINCMTXAPPTNRTONM );}


/** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
public void setAddIncmTxApptnYrMnth(String  addIncmTxApptnYrMnth) { set( ATTR_ADDINCMTXAPPTNYRMNTH ,addIncmTxApptnYrMnth);}
/** get 추가소득세적용년월 : addIncmTxApptnYrMnth */
public String  getAddIncmTxApptnYrMnth() { return (String )get( ATTR_ADDINCMTXAPPTNYRMNTH );}

/** set 추가소득세적용여부 : addIncmTxApptnYn */
public void setAddIncmTxApptnYn(String  addIncmTxApptnYn) { set( ATTR_ADDINCMTXAPPTNYN ,addIncmTxApptnYn);}
/** get 추가소득세적용여부 : addIncmTxApptnYn */
public String  getAddIncmTxApptnYn() { return (String )get( ATTR_ADDINCMTXAPPTNYN );}
   

/** set 이전 추가소득세적용비율코드  : befIncmTxApptnRtoCd */
public void setBefIncmTxApptnRtoCd(String  befIncmTxApptnRtoCd) { set( ATTR_BEFINCMTXAPPTNRTOCD ,befIncmTxApptnRtoCd);}
/** get 이전 추가소득세적용비율코드  : befIncmTxApptnRtoCd */
public String  getBefIncmTxApptnRtoCd() { return (String )get( ATTR_BEFINCMTXAPPTNRTOCD );}


/** set 이전 추가소득세적용년월  : befIncmTxApptnYrMnth */
public void setBefIncmTxApptnYrMnth(String  befIncmTxApptnYrMnth) { set( ATTR_BEFINCMTXAPPTNYRMNTH ,befIncmTxApptnYrMnth);}
/** get 이전 추가소득세적용년월 : befIncmTxApptnYrMnth */
public String  getBefIncmTxApptnYrMnth() { return (String )get( ATTR_BEFINCMTXAPPTNYRMNTH );}
 
/** set 이전 추가소득세적용여부  : befIncmTxApptnYn */
public void setBefIncmTxApptnYn(String  befIncmTxApptnYn) { set( ATTR_BEFINCMTXAPPTNYN ,befIncmTxApptnYn);}
/** get 이전 추가소득세적용여부  : befIncmTxApptnYn */
public String  getBefIncmTxApptnYn() { return (String )get( ATTR_BEFINCMTXAPPTNYN );}
 
/** set 해당년도 추가소득세적용갯수 : addIncmTxApptnCnt */
public void setAddIncmTxApptnCnt(Long  addIncmTxApptnCnt) { set( ATTR_ADDINCMTXAPPTNCNT ,addIncmTxApptnCnt);}
/** get 해당년도 추가소득세적용갯수 : addIncmTxApptnCnt */
public Long  getAddIncmTxApptnCnt() { return (Long )get( ATTR_ADDINCMTXAPPTNCNT );}

}
