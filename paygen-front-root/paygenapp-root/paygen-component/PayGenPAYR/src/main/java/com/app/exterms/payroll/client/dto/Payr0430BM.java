package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0430VO.java
 * @Description : Payr0430 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0430BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public static final String ATTR_TYPOCCUGRDEMPPGSEILNUM = "typOccuGrdeMppgSeilNum";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";


    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public static final String ATTR_PYSPLOGSVCYRNUMCD = "pyspLogSvcYrNumCd";
    
    /** set 호봉근속년수 : pyspLogSvcYrNumNm */
    public static final String ATTR_PYSPLOGSVCYRNUMNM = "pyspLogSvcYrNumNm";

    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 근속년수_이상 : logSvcYrNumOvr */
    public static final String ATTR_LOGSVCYRNUMOVR = "logSvcYrNumOvr";

    /** set 근속년수_미만 : logSvcYrNumUdr */
    public static final String ATTR_LOGSVCYRNUMUDR = "logSvcYrNumUdr";

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


	/** set 직종세통합코드 : dtilOccuInttnCd */
	public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
	
    /** 생성자 */
     public Payr0430BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0430BM(
    		 String  dpobCd 
    		 , Long  typOccuGrdeMppgSeilNum 
    		, String  typOccuCd 
    		, String  typOccuNm
    		, String  pyspGrdeCd 
    		, String  pyspLogSvcYrNumCd 
    		, String  pyspLogSvcYrNumNm
    		, String  dtilOccuClsDivCd 
    		, String  dtilOccuClsDivNm
    		, Long  logSvcYrNumOvr 
    		, Long  logSvcYrNumUdr 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUGRDEMPPGSEILNUM,typOccuGrdeMppgSeilNum);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_TYPOCCUNM,typOccuNm);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_PYSPLOGSVCYRNUMCD,pyspLogSvcYrNumCd);
     	values.put(ATTR_PYSPLOGSVCYRNUMNM,pyspLogSvcYrNumNm);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_DTILOCCUCLSDIVNM,dtilOccuClsDivNm);
     	values.put(ATTR_LOGSVCYRNUMOVR,logSvcYrNumOvr);
     	values.put(ATTR_LOGSVCYRNUMUDR,logSvcYrNumUdr);
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


/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public void setTypOccuGrdeMppgSeilNum(Long  typOccuGrdeMppgSeilNum) { set( ATTR_TYPOCCUGRDEMPPGSEILNUM ,typOccuGrdeMppgSeilNum);}
/** get 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public Long  getTypOccuGrdeMppgSeilNum() { return (Long )get( ATTR_TYPOCCUGRDEMPPGSEILNUM );}


    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public void setPyspLogSvcYrNumCd(String  pyspLogSvcYrNumCd) { set( ATTR_PYSPLOGSVCYRNUMCD ,pyspLogSvcYrNumCd);}
    /** get 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public String  getPyspLogSvcYrNumCd() { return (String )get( ATTR_PYSPLOGSVCYRNUMCD );}
    
    /** set 호봉근속년수 : pyspLogSvcYrNumNm */
    public void setPyspLogSvcYrNumNm(String  pyspLogSvcYrNumNm) { set( ATTR_PYSPLOGSVCYRNUMNM ,pyspLogSvcYrNumNm);}
    /** get 호봉근속년수 : pyspLogSvcYrNumNm */
    public String  getPyspLogSvcYrNumNm() { return (String )get( ATTR_PYSPLOGSVCYRNUMNM );}
    

    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}


    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
    
    
    /** set 근속년수_이상 : logSvcYrNumOvr */
    public void setLogSvcYrNumOvr(BigDecimal  logSvcYrNumOvr) { set( ATTR_LOGSVCYRNUMOVR ,logSvcYrNumOvr);}
    /** get 근속년수_이상 : logSvcYrNumOvr */
    public BigDecimal  getLogSvcYrNumOvr() { return (BigDecimal )get( ATTR_LOGSVCYRNUMOVR );}

    /** set 근속년수_미만 : logSvcYrNumUdr */
    public void setLogSvcYrNumUdr(BigDecimal  logSvcYrNumUdr) { set( ATTR_LOGSVCYRNUMUDR ,logSvcYrNumUdr);}
    /** get 근속년수_미만 : logSvcYrNumUdr */
    public BigDecimal  getLogSvcYrNumUdr() { return (BigDecimal )get( ATTR_LOGSVCYRNUMUDR );}

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


    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


}
