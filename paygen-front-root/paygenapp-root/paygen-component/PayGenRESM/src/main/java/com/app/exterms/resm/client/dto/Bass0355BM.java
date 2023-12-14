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
public class Bass0355BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 직종세회계구분코드 : dtilOccuClsAccDivCd */
    public static final String ATTR_DTILOCCUCLSACCDIVCD = "dtilOccuClsAccDivCd";

    /** set 직종세적용단가일수 : dtilOccuClsApptnUcstDys */
    public static final String ATTR_DTILOCCUCLSAPPTNUCSTDYS = "dtilOccuClsApptnUcstDys";

    /** set 기간제사용여부 : fxtmUseYn */
    public static final String ATTR_FXTMUSEYN = "fxtmUseYn";

    /** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
    public static final String ATTR_DTILOCCLSAPPTNUCSTSUM = "dtilOcclsApptnUcstSum";

    /** set 교대근무적용여부 : rotaDutyApptnYn */
    public static final String ATTR_ROTADUTYAPPTNYN = "rotaDutyApptnYn";

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
     public Bass0355BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0355BM(
    		 String  dpobCd 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, String  dtilOccuClsAccDivCd 
    		, Double  dtilOccuClsApptnUcstDys 
    		, String  fxtmUseYn 
    		, Double  dtilOcclsApptnUcstSum 
    		, String  rotaDutyApptnYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_DTILOCCUCLSACCDIVCD,dtilOccuClsAccDivCd);
     	values.put(ATTR_DTILOCCUCLSAPPTNUCSTDYS,dtilOccuClsApptnUcstDys);
     	values.put(ATTR_FXTMUSEYN,fxtmUseYn);
     	values.put(ATTR_DTILOCCLSAPPTNUCSTSUM,dtilOcclsApptnUcstSum);
     	values.put(ATTR_ROTADUTYAPPTNYN,rotaDutyApptnYn);
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

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 직종세회계구분코드 : dtilOccuClsAccDivCd */
    public void setDtilOccuClsAccDivCd(String  dtilOccuClsAccDivCd) { set( ATTR_DTILOCCUCLSACCDIVCD ,dtilOccuClsAccDivCd);}
    /** get 직종세회계구분코드 : dtilOccuClsAccDivCd */
    public String  getDtilOccuClsAccDivCd() { return (String )get( ATTR_DTILOCCUCLSACCDIVCD );}

    /** set 직종세적용단가일수 : dtilOccuClsApptnUcstDys */
    public void setDtilOccuClsApptnUcstDys(Double  dtilOccuClsApptnUcstDys) { set( ATTR_DTILOCCUCLSAPPTNUCSTDYS ,dtilOccuClsApptnUcstDys);}
    /** get 직종세적용단가일수 : dtilOccuClsApptnUcstDys */
    public Double  getDtilOccuClsApptnUcstDys() { return (Double )get( ATTR_DTILOCCUCLSAPPTNUCSTDYS );}

    /** set 기간제사용여부 : fxtmUseYn */
    public void setFxtmUseYn(String  fxtmUseYn) { set( ATTR_FXTMUSEYN ,fxtmUseYn);}
    /** get 기간제사용여부 : fxtmUseYn */
    public String  getFxtmUseYn() { return (String )get( ATTR_FXTMUSEYN );}

    /** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
    public void setDtilOcclsApptnUcstSum(Double  dtilOcclsApptnUcstSum) { set( ATTR_DTILOCCLSAPPTNUCSTSUM ,dtilOcclsApptnUcstSum);}
    /** get 직종세적용단가금액 : dtilOcclsApptnUcstSum */
    public Double  getDtilOcclsApptnUcstSum() { return (Double )get( ATTR_DTILOCCLSAPPTNUCSTSUM );}

    /** set 교대근무적용여부 : rotaDutyApptnYn */
    public void setRotaDutyApptnYn(String  rotaDutyApptnYn) { set( ATTR_ROTADUTYAPPTNYN ,rotaDutyApptnYn);}
    /** get 교대근무적용여부 : rotaDutyApptnYn */
    public String  getRotaDutyApptnYn() { return (String )get( ATTR_ROTADUTYAPPTNYN );}

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
