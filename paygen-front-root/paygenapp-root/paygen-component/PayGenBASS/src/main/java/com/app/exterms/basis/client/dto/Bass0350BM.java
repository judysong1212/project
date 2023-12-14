package com.app.exterms.basis.client.dto;

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
    
    /** set 직종코드명 : typOccuCd */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    /** set 호봉등급명 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";

    /** set 직종세명 : dtilOccuClsNm */
    public static final String ATTR_DTILOCCUCLSNM = "dtilOccuClsNm";
    
    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public static final String ATTR_DTILOCCUJBFMLDIVCD = "dtilOccuJbfmlDivCd";
     
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


/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public static final String ATTR_DTILOCCLSAPPTNUCSTSUM = "dtilOcclsApptnUcstSum";

    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    /** set 급여관리부서명 : payMangeDeptNm */
    public static final String ATTR_PAYMANGEDEPTNM = "payMangeDeptNm";


    /** set 직종세직군구분 : dtilOccuJbfmlDivNm */
    public static final String ATTR_DTILOCCUJBFMLDIVNM = "dtilOccuJbfmlDivNm";
    

/** set 이전직종코드 : chngTypOccuCd */
public static final String ATTR_CHNGTYPOCCUCD = "chngTypOccuCd";

/** set 이전직종세코드 : chngDtilOccuInttnCd */
public static final String ATTR_CHNGDTILOCCUINTTNCD = "chngDtilOccuInttnCd";

/** set 직종세시작일자 : dtilOccuInttnStdt */
public static final String ATTR_DTILOCCUINTTNSTDT = "dtilOccuInttnStdt";

/** set 직종세종료일자 : dtilOccuInttnEddt */
public static final String ATTR_DTILOCCUINTTNEDDT = "dtilOccuInttnEddt";

/** set 직종세회계코드 : dtilOccuInttnAccCd */
public static final String ATTR_DTILOCCUINTTNACCCD = "dtilOccuInttnAccCd";

/** set 직종세회계명 : dtilOccuInttnAccNm */
public static final String ATTR_DTILOCCUINTTNACCNM = "dtilOccuInttnAccNm";

/** set 기간제사용여부 : dtilTermUseYn */
public static final String ATTR_DTILTERMUSEYN = "dtilTermUseYn";

/** set 직종세단가일수 : dtilOcclsApptnUcstDys */
public static final String ATTR_DTILOCCLSAPPTNUCSTDYS = "dtilOcclsApptnUcstDys"; 
   
    /** 생성자 */
     public Bass0350BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0350BM(
    		 String  dpobCd 
    		, String  typOccuCd 
    		, String  typOccuNm
    		, String  dtilOccuClsDivCd 
    		, String  dtilOccuClsNm 
    		, String  dtilOccuClsCtnt  
    		, BigDecimal  dtilOccuClsOrd
    		, String  dtilOccuClsUseYn 
    		, String  chngTgtYn   ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_TYPOCCUNM,typOccuNm);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_DTILOCCUCLSNM,dtilOccuClsNm);
     	values.put(ATTR_DTILOCCUCLSCTNT,dtilOccuClsCtnt);
     	values.put(ATTR_DTILOCCUCLSORD,dtilOccuClsOrd); 
     	values.put(ATTR_DTILOCCUCLSUSEYN,dtilOccuClsUseYn);
     	values.put(ATTR_CHNGTGTYN,chngTgtYn); 
     	} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    public void setTypOccuNm(String typOccuNm) { set (ATTR_TYPOCCUNM, typOccuNm); }
    public String getTypOccuNm(){ return (String) get(ATTR_TYPOCCUNM); }
    
    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 직종세명 : dtilOccuClsNm */
    public void setDtilOccuClsNm(String  dtilOccuClsNm) { set( ATTR_DTILOCCUCLSNM ,dtilOccuClsNm);}
    /** get 직종세명 : dtilOccuClsNm */
    public String  getDtilOccuClsNm() { return (String )get( ATTR_DTILOCCUCLSNM );}

    /** set 직종세내용 : dtilOccuClsCtnt */
    public void setDtilOccuClsCtnt(String  dtilOccuClsCtnt) { set( ATTR_DTILOCCUCLSCTNT ,dtilOccuClsCtnt);}
    /** get 직종세내용 : dtilOccuClsCtnt */
    public String  getDtilOccuClsCtnt() { return (String )get( ATTR_DTILOCCUCLSCTNT );}

    /** set 직종세사용여부 : dtilOccuClsUseYn */
    public void setDtilOccuClsUseYn(String  dtilOccuClsUseYn) { set( ATTR_DTILOCCUCLSUSEYN ,dtilOccuClsUseYn);}
    /** get 직종세사용여부 : dtilOccuClsUseYn */
    public String  getDtilOccuClsUseYn() { return (String )get( ATTR_DTILOCCUCLSUSEYN );}

    /** set 전환대상여부 : chngTgtYn */
    public void setChngTgtYn(String  chngTgtYn) { set( ATTR_CHNGTGTYN ,chngTgtYn);}
    /** get 전환대상여부 : chngTgtYn */
    public String  getChngTgtYn() { return (String )get( ATTR_CHNGTGTYN );}

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

    /** set 정렬순서 : dtilOccuClsOrd */
    public void setDtilOccuClsOrd(String  dtilOccuClsOrd) { set( ATTR_DTILOCCUCLSORD ,dtilOccuClsOrd);}
    /** get 정렬순서 : dtilOccuClsOrd */
    public String  getDtilOccuClsOrd() { return (String)get( ATTR_DTILOCCUCLSORD );}

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    /** set 급여관리부서명 : payMangeDeptNm */
    public void setPayMangeDeptNm(String  payMangeDeptNm) { set( ATTR_PAYMANGEDEPTNM ,payMangeDeptNm);}
    /** get 급여관리부서명 : payMangeDeptNm */
    public String  getPayMangeDeptNm() { return (String )get( ATTR_PAYMANGEDEPTNM );}
    
    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public void setDtilOccuJbfmlDivCd(String  dtilOccuJbfmlDivCd) { set( ATTR_DTILOCCUJBFMLDIVCD ,dtilOccuJbfmlDivCd);}
    /** get 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public String  getDtilOccuJbfmlDivCd() { return (String )get( ATTR_DTILOCCUJBFMLDIVCD );}

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivNm */
    public void setDtilOccuJbfmlDivNm(String  dtilOccuJbfmlDivNm) { set( ATTR_DTILOCCUJBFMLDIVNM ,dtilOccuJbfmlDivNm);}
    /** get 직종세직군구분코드 : dtilOccuJbfmlDivNm */
    public String  getDtilOccuJbfmlDivNm() { return (String )get( ATTR_DTILOCCUJBFMLDIVNM );}

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
/** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public void setDtilOcclsApptnUcstSum(Long  dtilOcclsApptnUcstSum) { set( ATTR_DTILOCCLSAPPTNUCSTSUM ,dtilOcclsApptnUcstSum);}
/** get 직종세적용단가금액 : dtilOcclsApptnUcstSum */
public Long  getDtilOcclsApptnUcstSum() { return (Long )get( ATTR_DTILOCCLSAPPTNUCSTSUM );}

/** set 이전직종코드 : chngTypOccuCd */
public void setChngTypOccuCd(String  chngTypOccuCd) { set( ATTR_CHNGTYPOCCUCD ,chngTypOccuCd);}
/** get 이전직종코드 : chngTypOccuCd */
public String  getChngTypOccuCd() { return (String )get( ATTR_CHNGTYPOCCUCD );}

/** set 이전직종세코드 : chngDtilOccuInttnCd */
public void setChngDtilOccuInttnCd(String  chngDtilOccuInttnCd) { set( ATTR_CHNGDTILOCCUINTTNCD ,chngDtilOccuInttnCd);}
/** get 이전직종세코드 : chngDtilOccuInttnCd */
public String  getChngDtilOccuInttnCd() { return (String )get( ATTR_CHNGDTILOCCUINTTNCD );}

/** set 직종세시작일자 : dtilOccuInttnStdt */
public void setDtilOccuInttnStdt(String  dtilOccuInttnStdt) { set( ATTR_DTILOCCUINTTNSTDT ,dtilOccuInttnStdt);}
/** get 직종세시작일자 : dtilOccuInttnStdt */
public String  getDtilOccuInttnStdt() { return (String )get( ATTR_DTILOCCUINTTNSTDT );}

/** set 직종세종료일자 : dtilOccuInttnEddt */
public void setDtilOccuInttnEddt(String  dtilOccuInttnEddt) { set( ATTR_DTILOCCUINTTNEDDT ,dtilOccuInttnEddt);}
/** get 직종세종료일자 : dtilOccuInttnEddt */
public String  getDtilOccuInttnEddt() { return (String )get( ATTR_DTILOCCUINTTNEDDT );}

/** set 직종세회계코드 : dtilOccuInttnAccCd */
public void setDtilOccuInttnAccCd(String  dtilOccuInttnAccCd) { set( ATTR_DTILOCCUINTTNACCCD ,dtilOccuInttnAccCd);}
/** get 직종세회계코드 : dtilOccuInttnAccCd */
public String  getDtilOccuInttnAccCd() { return (String )get( ATTR_DTILOCCUINTTNACCCD );}

/** set 직종세회계명 : dtilOccuInttnAccNm */
public void setDtilOccuInttnAccNm(String  dtilOccuInttnAccNm) { set( ATTR_DTILOCCUINTTNACCNM ,dtilOccuInttnAccNm);}
/** get 직종세회계명 : dtilOccuInttnAccNm */
public String  getDtilOccuInttnAccNm() { return (String )get( ATTR_DTILOCCUINTTNACCNM );}

/** set 기간제사용여부 : dtilTermUseYn */
public void setDtilTermUseYn(String  dtilTermUseYn) { set( ATTR_DTILTERMUSEYN ,dtilTermUseYn);}
/** get 기간제사용여부 : dtilTermUseYn */
public String  getDtilTermUseYn() { return (String )get( ATTR_DTILTERMUSEYN );}

/** set 직종세단가일수 : dtilOcclsApptnUcstDys */
public void setDtilOcclsApptnUcstDys(String  dtilOcclsApptnUcstDys) { set( ATTR_DTILOCCLSAPPTNUCSTDYS ,dtilOcclsApptnUcstDys);}
/** get 직종세단가일수 : dtilOcclsApptnUcstDys */
public String  getDtilOcclsApptnUcstDys() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTDYS );}

}
