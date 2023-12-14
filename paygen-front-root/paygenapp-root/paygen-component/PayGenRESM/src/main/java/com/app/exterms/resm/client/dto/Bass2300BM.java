package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2300BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public static final String ATTR_BUSNDTLTYPOCCUCD = "busnDtlTypOccuCd";

    /** set 사업세부직종명 : busnDtlTypOccuNm */
    public static final String ATTR_BUSNDTLTYPOCCUNM = "busnDtlTypOccuNm";

    /** set 사업세부직종일근무시간 : busnDtlTypOccuDayDys */
    public static final String ATTR_BUSNDTLTYPOCCUDAYDYS = "busnDtlTypOccuDayDys";

    /** set 사업세부직종주근무시간 : busnDtlTypOccuMnDys */
    public static final String ATTR_BUSNDTLTYPOCCUMNDYS = "busnDtlTypOccuMnDys";

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

    /** set 사업세부직종단가금액 : busnDtlTypOccuUcstSum */
    public static final String ATTR_BUSNDTLTYPOCCUUCSTSUM = "busnDtlTypOccuUcstSum";

    /** set 사업세부직종시작일자 : busnDtlTypOccuBgnnDt */
    public static final String ATTR_BUSNDTLTYPOCCUBGNNDT = "busnDtlTypOccuBgnnDt";

    /** set 사업세부직종종료일자 : busnDtlTypOccuEndDt */
    public static final String ATTR_BUSNDTLTYPOCCUENDDT = "busnDtlTypOccuEndDt";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 사업세부직종직군구분코드 : busnDtlTypOccuJbfmlCd */
    public static final String ATTR_BUSNDTLTYPOCCUJBFMLCD = "busnDtlTypOccuJbfmlCd";

    /** set 사업세부직종구분비고내용 : busnDtlTypOccuSeptCtnt */
    public static final String ATTR_BUSNDTLTYPOCCUSEPTCTNT = "busnDtlTypOccuSeptCtnt";

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public static final String ATTR_BUSNTYPOCCUCIFICD = "busnTypOccuCifiCd";

    /** set 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public static final String ATTR_BUSNTYPOCCUCIFISMLRCD = "busnTypOccuCifiSmlrCd";

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
     public Bass2300BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2300BM(
    		 String  dpobCd 
    		, String  busnDtlTypOccuCd 
    		, String  busnDtlTypOccuNm 
    		, Double  busnDtlTypOccuDayDys 
    		, Double  busnDtlTypOccuMnDys 
    		, String  dtilOcclsApptnUcstCd 
    		, Double  busnDtlTypOccuUcstSum 
    		, String  busnDtlTypOccuBgnnDt 
    		, String  busnDtlTypOccuEndDt 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, String  busnDtlTypOccuJbfmlCd 
    		, String  busnDtlTypOccuSeptCtnt 
    		, String  busnTypOccuCifiCd 
    		, String  busnTypOccuCifiSmlrCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSNDTLTYPOCCUCD,busnDtlTypOccuCd);
     	values.put(ATTR_BUSNDTLTYPOCCUNM,busnDtlTypOccuNm);
     	values.put(ATTR_BUSNDTLTYPOCCUDAYDYS,busnDtlTypOccuDayDys);
     	values.put(ATTR_BUSNDTLTYPOCCUMNDYS,busnDtlTypOccuMnDys);
     	values.put(ATTR_DTILOCCLSAPPTNUCSTCD,dtilOcclsApptnUcstCd);
     	values.put(ATTR_BUSNDTLTYPOCCUUCSTSUM,busnDtlTypOccuUcstSum);
     	values.put(ATTR_BUSNDTLTYPOCCUBGNNDT,busnDtlTypOccuBgnnDt);
     	values.put(ATTR_BUSNDTLTYPOCCUENDDT,busnDtlTypOccuEndDt);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_BUSNDTLTYPOCCUJBFMLCD,busnDtlTypOccuJbfmlCd);
     	values.put(ATTR_BUSNDTLTYPOCCUSEPTCTNT,busnDtlTypOccuSeptCtnt);
     	values.put(ATTR_BUSNTYPOCCUCIFICD,busnTypOccuCifiCd);
     	values.put(ATTR_BUSNTYPOCCUCIFISMLRCD,busnTypOccuCifiSmlrCd);
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

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public void setBusnDtlTypOccuCd(String  busnDtlTypOccuCd) { set( ATTR_BUSNDTLTYPOCCUCD ,busnDtlTypOccuCd);}
    /** get 사업_세부직종코드 : busnDtlTypOccuCd */
    public String  getBusnDtlTypOccuCd() { return (String )get( ATTR_BUSNDTLTYPOCCUCD );}

    /** set 사업세부직종명 : busnDtlTypOccuNm */
    public void setBusnDtlTypOccuNm(String  busnDtlTypOccuNm) { set( ATTR_BUSNDTLTYPOCCUNM ,busnDtlTypOccuNm);}
    /** get 사업세부직종명 : busnDtlTypOccuNm */
    public String  getBusnDtlTypOccuNm() { return (String )get( ATTR_BUSNDTLTYPOCCUNM );}

    /** set 사업세부직종일근무시간 : busnDtlTypOccuDayDys */
    public void setBusnDtlTypOccuDayDys(Double  busnDtlTypOccuDayDys) { set( ATTR_BUSNDTLTYPOCCUDAYDYS ,busnDtlTypOccuDayDys);}
    /** get 사업세부직종일근무시간 : busnDtlTypOccuDayDys */
    public Double  getBusnDtlTypOccuDayDys() { return (Double )get( ATTR_BUSNDTLTYPOCCUDAYDYS );}

    /** set 사업세부직종주근무시간 : busnDtlTypOccuMnDys */
    public void setBusnDtlTypOccuMnDys(Double  busnDtlTypOccuMnDys) { set( ATTR_BUSNDTLTYPOCCUMNDYS ,busnDtlTypOccuMnDys);}
    /** get 사업세부직종주근무시간 : busnDtlTypOccuMnDys */
    public Double  getBusnDtlTypOccuMnDys() { return (Double )get( ATTR_BUSNDTLTYPOCCUMNDYS );}

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
    /** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

    /** set 사업세부직종단가금액 : busnDtlTypOccuUcstSum */
    public void setBusnDtlTypOccuUcstSum(Double  busnDtlTypOccuUcstSum) { set( ATTR_BUSNDTLTYPOCCUUCSTSUM ,busnDtlTypOccuUcstSum);}
    /** get 사업세부직종단가금액 : busnDtlTypOccuUcstSum */
    public Double  getBusnDtlTypOccuUcstSum() { return (Double )get( ATTR_BUSNDTLTYPOCCUUCSTSUM );}

    /** set 사업세부직종시작일자 : busnDtlTypOccuBgnnDt */
    public void setBusnDtlTypOccuBgnnDt(String  busnDtlTypOccuBgnnDt) { set( ATTR_BUSNDTLTYPOCCUBGNNDT ,busnDtlTypOccuBgnnDt);}
    /** get 사업세부직종시작일자 : busnDtlTypOccuBgnnDt */
    public String  getBusnDtlTypOccuBgnnDt() { return (String )get( ATTR_BUSNDTLTYPOCCUBGNNDT );}

    /** set 사업세부직종종료일자 : busnDtlTypOccuEndDt */
    public void setBusnDtlTypOccuEndDt(String  busnDtlTypOccuEndDt) { set( ATTR_BUSNDTLTYPOCCUENDDT ,busnDtlTypOccuEndDt);}
    /** get 사업세부직종종료일자 : busnDtlTypOccuEndDt */
    public String  getBusnDtlTypOccuEndDt() { return (String )get( ATTR_BUSNDTLTYPOCCUENDDT );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 사업세부직종직군구분코드 : busnDtlTypOccuJbfmlCd */
    public void setBusnDtlTypOccuJbfmlCd(String  busnDtlTypOccuJbfmlCd) { set( ATTR_BUSNDTLTYPOCCUJBFMLCD ,busnDtlTypOccuJbfmlCd);}
    /** get 사업세부직종직군구분코드 : busnDtlTypOccuJbfmlCd */
    public String  getBusnDtlTypOccuJbfmlCd() { return (String )get( ATTR_BUSNDTLTYPOCCUJBFMLCD );}

    /** set 사업세부직종구분비고내용 : busnDtlTypOccuSeptCtnt */
    public void setBusnDtlTypOccuSeptCtnt(String  busnDtlTypOccuSeptCtnt) { set( ATTR_BUSNDTLTYPOCCUSEPTCTNT ,busnDtlTypOccuSeptCtnt);}
    /** get 사업세부직종구분비고내용 : busnDtlTypOccuSeptCtnt */
    public String  getBusnDtlTypOccuSeptCtnt() { return (String )get( ATTR_BUSNDTLTYPOCCUSEPTCTNT );}

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public void setBusnTypOccuCifiCd(String  busnTypOccuCifiCd) { set( ATTR_BUSNTYPOCCUCIFICD ,busnTypOccuCifiCd);}
    /** get 사업직종분류코드 : busnTypOccuCifiCd */
    public String  getBusnTypOccuCifiCd() { return (String )get( ATTR_BUSNTYPOCCUCIFICD );}

    /** set 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public void setBusnTypOccuCifiSmlrCd(String  busnTypOccuCifiSmlrCd) { set( ATTR_BUSNTYPOCCUCIFISMLRCD ,busnTypOccuCifiSmlrCd);}
    /** get 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public String  getBusnTypOccuCifiSmlrCd() { return (String )get( ATTR_BUSNTYPOCCUCIFISMLRCD );}

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
