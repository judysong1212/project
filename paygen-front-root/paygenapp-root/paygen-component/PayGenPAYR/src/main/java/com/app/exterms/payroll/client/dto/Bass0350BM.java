package com.app.exterms.payroll.client.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0350VO.java
 * @Description : Bass0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0350BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종명 : typOccuCd */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세명 : dtilOccuClsNm */
    public static final String ATTR_DTILOCCUCLSNM = "dtilOccuClsNm";

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public static final String ATTR_DTILOCCUJBFMLDIVCD = "dtilOccuJbfmlDivCd";
    
    /** set 직군명 : dtilOccuJbfmlDivNm */
    public static final String ATTR_DTILOCCUJBFMLDIVNM = "dtilOccuJbfmlDivNm";

    /** set 직종세사용여부 : dtilOccuClsUseYn */
    public static final String ATTR_DTILOCCUCLSUSEYN = "dtilOccuClsUseYn";

    /** set 전환대상여부 : chngTgtYn */
    public static final String ATTR_CHNGTGTYN = "chngTgtYn";

    /** set 직종세내용 : dtilOccuClsCtnt */
    public static final String ATTR_DTILOCCUCLSCTNT = "dtilOccuClsCtnt";

    /** set 정렬순서 : dtilOccuClsOrd */
    public static final String ATTR_DTILOCCUCLSORD = "dtilOccuClsOrd";

    /** set 최대근속년수코드 : bggLogSvcYrNumCd */
    public static final String ATTR_BGGLOGSVCYRNUMCD = "bggLogSvcYrNumCd";

    /** set 최대근속년수 : bggLogSvcYrNumNm */
    public static final String ATTR_BGGLOGSVCYRNUMNM = "bggLogSvcYrNumNm";
    

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public static final String ATTR_DTILOCCLSAPPTNUCSTSUM = "dtilOcclsApptnUcstSum";

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
     public Bass0350BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0350BM(
    		 String  dpobCd 
    		, String  dtilOccuInttnCd 
    		, String  typOccuCd 
    		, String  typOccuNm
    		, String  dtilOccuClsDivCd 
    		, String  pyspGrdeCd 
    		, String  dtilOccuClsNm 
    		, String  dtilOccuJbfmlDivCd 
    		, String  dtilOccuJbfmlDivNm 
    		, String  dtilOccuClsUseYn 
    		, String  chngTgtYn 
    		, String  dtilOccuClsCtnt 
    		, BigDecimal  dtilOccuClsOrd 
    		, String  bggLogSvcYrNumCd 
    		, String  bggLogSvcYrNumNm 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_TYPOCCUNM,typOccuNm);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUCLSNM,dtilOccuClsNm);
     	values.put(ATTR_DTILOCCUJBFMLDIVCD,dtilOccuJbfmlDivCd);
     	values.put(ATTR_DTILOCCUJBFMLDIVNM,dtilOccuJbfmlDivNm);
     	values.put(ATTR_DTILOCCUCLSUSEYN,dtilOccuClsUseYn);
     	values.put(ATTR_CHNGTGTYN,chngTgtYn);
     	values.put(ATTR_DTILOCCUCLSCTNT,dtilOccuClsCtnt);
     	values.put(ATTR_DTILOCCUCLSORD,dtilOccuClsOrd);
     	values.put(ATTR_BGGLOGSVCYRNUMCD,bggLogSvcYrNumCd);
     	
     	values.put(ATTR_BGGLOGSVCYRNUMNM,bggLogSvcYrNumNm);
     	
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
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    public void setTypOccuNm(String typOccuNm) { set (ATTR_TYPOCCUNM, typOccuNm); }
    public String getTypOccuNm(){ return (String) get(ATTR_TYPOCCUNM); }
    
    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
    /** set 직종세명 : dtilOccuClsNm */
    public void setDtilOccuClsNm(String  dtilOccuClsNm) { set( ATTR_DTILOCCUCLSNM ,dtilOccuClsNm);}
    /** get 직종세명 : dtilOccuClsNm */
    public String  getDtilOccuClsNm() { return (String )get( ATTR_DTILOCCUCLSNM );}
    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public void setDtilOccuJbfmlDivCd(String  dtilOccuJbfmlDivCd) { set( ATTR_DTILOCCUJBFMLDIVCD ,dtilOccuJbfmlDivCd);}
    /** get 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public String  getDtilOccuJbfmlDivCd() { return (String )get( ATTR_DTILOCCUJBFMLDIVCD );}
    
    
    /** set 직군 : dtilOccuJbfmlDivNm */
    public void setDtilOccuJbfmlDivNm(String  dtilOccuJbfmlDivNm) { set( ATTR_DTILOCCUJBFMLDIVNM ,dtilOccuJbfmlDivNm);}
    /** get 직군 : dtilOccuJbfmlDivNm */
    public String  getDtilOccuJbfmlDivNm() { return (String )get( ATTR_DTILOCCUJBFMLDIVNM );}
    
    
    /** set 직종세사용여부 : dtilOccuClsUseYn */
    public void setDtilOccuClsUseYn(String  dtilOccuClsUseYn) { set( ATTR_DTILOCCUCLSUSEYN ,dtilOccuClsUseYn);}
    /** get 직종세사용여부 : dtilOccuClsUseYn */
    public String  getDtilOccuClsUseYn() { return (String )get( ATTR_DTILOCCUCLSUSEYN );}
    /** set 전환대상여부 : chngTgtYn */
    public void setChngTgtYn(String  chngTgtYn) { set( ATTR_CHNGTGTYN ,chngTgtYn);}
    /** get 전환대상여부 : chngTgtYn */
    public String  getChngTgtYn() { return (String )get( ATTR_CHNGTGTYN );}
    /** set 직종세내용 : dtilOccuClsCtnt */
    public void setDtilOccuClsCtnt(String  dtilOccuClsCtnt) { set( ATTR_DTILOCCUCLSCTNT ,dtilOccuClsCtnt);}
    /** get 직종세내용 : dtilOccuClsCtnt */
    public String  getDtilOccuClsCtnt() { return (String )get( ATTR_DTILOCCUCLSCTNT );}
    /** set 정렬순서 : dtilOccuClsOrd */
    public void setDtilOccuClsOrd(BigDecimal  dtilOccuClsOrd) { set( ATTR_DTILOCCUCLSORD ,dtilOccuClsOrd);}
    /** get 정렬순서 : dtilOccuClsOrd */
    public BigDecimal  getDtilOccuClsOrd() { return (BigDecimal )get( ATTR_DTILOCCUCLSORD );}
    /** set 최대근속년수코드 : bggLogSvcYrNumCd */
    public void setBggLogSvcYrNumCd(String  bggLogSvcYrNumCd) { set( ATTR_BGGLOGSVCYRNUMCD ,bggLogSvcYrNumCd);}
    /** get 최대근속년수코드 : bggLogSvcYrNumCd */
    public String  getBggLogSvcYrNumCd() { return (String )get( ATTR_BGGLOGSVCYRNUMCD );}
    
    /** set 최대근속년수 : bggLogSvcYrNumNm */
    public void setBggLogSvcYrNumNm(String  bggLogSvcYrNumNm) { set( ATTR_BGGLOGSVCYRNUMNM ,bggLogSvcYrNumNm);}
    /** get 최대근속년수 : bggLogSvcYrNumNm */
    public String  getBggLogSvcYrNumNm() { return (String )get( ATTR_BGGLOGSVCYRNUMNM );}
    
    
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
    

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
/** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public void setDtilOcclsApptnUcstSum(Long  dtilOcclsApptnUcstSum) { set( ATTR_DTILOCCLSAPPTNUCSTSUM ,dtilOcclsApptnUcstSum);}
/** get 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public Long  getDtilOcclsApptnUcstSum() { return (Long )get( ATTR_DTILOCCLSAPPTNUCSTSUM );}

}
