package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0470VO.java
 * @Description : Payr0470 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0470BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 고용구분코드 : commCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 수당그룹코드 : payExtpyGrpCd */
    public static final String ATTR_PAYEXTPYGRPCD = "payExtpyGrpCd";
    
    /** set 급여공제코드 : payDducCd */
    public static final String ATTR_PAYDDUCCD = "payDducCd";

    /** set 급여공제그룹코드 : payDducGrpCd */
    public static final String ATTR_PAYDDUCGRPCD = "payDducGrpCd";
    
    /** set 급여공제그룹 : payDducGrpNm */
    public static final String ATTR_PAYDDUCGRPNM = "payDducGrpNm";

    /** set 급여공제명 : payDducNm */
    public static final String ATTR_PAYDDUCNM = "payDducNm";

    /** set 급여공제사용여부 : payDducUseYn */
    public static final String ATTR_PAYDDUCUSEYN = "payDducUseYn";

    /** set 급여공제금액 : payDducSum */
    public static final String ATTR_PAYDDUCSUM = "payDducSum";

    /** set 급여공제비율 : payDducRto */
    public static final String ATTR_PAYDDUCRTO = "payDducRto";

    /** set 연말정산_공제구분코드 : yrtxDducDivCd */
    public static final String ATTR_YRTXDDUCDIVCD = "yrtxDducDivCd";
    
    /** set 연말정산_공제구분 : yrtxDducDivNm */
    public static final String ATTR_YRTXDDUCDIVNM = "yrtxDducDivNm";
    
    
    
    
    
    /** set 퇴직적용여부 : sevePayYn */
    public static final String ATTR_SEVEPAYYN = "sevePayYn";

    /** set 회계계정코드 : accAccCd */
    public static final String ATTR_ACCACCCD = "accAccCd";
    
    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public static final String ATTR_YRTXFREEDTYREDUCD = "yrtxFreeDtyReduCd";
       
    
    
    /** set 그룹적용구분코드 : grpApptnDivCd */
    public static final String ATTR_GRPAPPTNDIVCD = "grpApptnDivCd";

    /** set 그룹적용구분 : grpApptnDivNm */
    public static final String ATTR_GRPAPPTNDIVNM = "grpApptnDivNm";

    /** set 급여공제시작일자 : payDducBgnnDt */
    public static final String ATTR_PAYDDUCBGNNDT = "payDducBgnnDt";

    /** set 급여공제종료일자 : payDducEndDt */
    public static final String ATTR_PAYDDUCENDDT = "payDducEndDt";

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
    
    /** set 지급공제구분코드  : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
    

    /** set 지급공제구분  : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";
    
    /** set 기간제공제사용여부 : payrTermDducYn */
    public static final String ATTR_PAYRTERMDDUCYN = "payrTermDducYn";
    
    /** set 기간제공제사용여부 : payrTermDducYn */
    public void setPayrTermDducYn(String  payrTermDducYn) { set( ATTR_PAYRTERMDDUCYN ,payrTermDducYn);}
    /** get 기간제공제사용여부 : payrTermDducYn */
    public String  getPayrTermDducYn() { return (String )get( ATTR_PAYRTERMDDUCYN );}
    
    /** set 지급수당구분  : pymtExtpyCd */
    public static final String ATTR_PYMTEXTPYCD = "payExtpyCd";
    
    /** set 지급수당구분  : pymtExtpyNm */
    public static final String ATTR_PYMTEXTPYNM = "payExtpyNm";
    

    /** 생성자 */
     public Payr0470BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0470BM(
    		 String  dpobCd 
    		, String  payDducCd 
    		, String  payDducGrpCd 
    		, String  payDducGrpNm 
    		, String  payDducNm 
    		, String  payDducUseYn 
    		, BigDecimal  payDducSum 
    		, BigDecimal  payDducRto 
    		, String  yrtxDducDivCd 
    		, String  yrtxDducDivNm
    		, String  sevePayYn
    		, String  accAccCd
    		, String  yrtxFreeDtyReduCd
    		, String  grpApptnDivCd 
    		, String  grpApptnDivNm
    		, String  payDducBgnnDt 
    		, String  payDducEndDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr
    		, String  pymtDducDivCd ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYDDUCCD,payDducCd);
     	values.put(ATTR_PAYDDUCGRPCD,payDducGrpCd);
     	values.put(ATTR_PAYDDUCGRPNM,payDducGrpNm);
     	values.put(ATTR_PAYDDUCNM,payDducNm);
     	values.put(ATTR_PAYDDUCUSEYN,payDducUseYn);
     	values.put(ATTR_PAYDDUCSUM,payDducSum);
     	values.put(ATTR_PAYDDUCRTO,payDducRto);
     	values.put(ATTR_YRTXDDUCDIVCD,yrtxDducDivCd);
     	values.put(ATTR_YRTXDDUCDIVNM,yrtxDducDivNm);
     	values.put(ATTR_SEVEPAYYN,sevePayYn);
     	values.put(ATTR_ACCACCCD,accAccCd);
     	values.put(ATTR_YRTXFREEDTYREDUCD,yrtxFreeDtyReduCd);
     	values.put(ATTR_GRPAPPTNDIVCD,grpApptnDivCd);
    	values.put(ATTR_GRPAPPTNDIVNM,grpApptnDivNm);
     	values.put(ATTR_PAYDDUCBGNNDT,payDducBgnnDt);
     	values.put(ATTR_PAYDDUCENDDT,payDducEndDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); 
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 급여공제코드 : payDducCd */
    public void setPayDducCd(String  payDducCd) { set( ATTR_PAYDDUCCD ,payDducCd);}
    /** get 급여공제코드 : payDducCd */
    public String  getPayDducCd() { return (String )get( ATTR_PAYDDUCCD );}

    /** set 급여공제그룹코드 : payDducGrpCd */
    public void setPayDducGrpCd(String  payDducGrpCd) { set( ATTR_PAYDDUCGRPCD ,payDducGrpCd);}
    /** get 급여공제그룹코드 : payDducGrpCd */
    public String  getPayDducGrpCd() { return (String )get( ATTR_PAYDDUCGRPCD );}
    
    /** set 급여공제그룹 : payDducGrpNm */
    public void setPayDducGrpNm(String  payDducGrpNm) { set( ATTR_PAYDDUCGRPNM ,payDducGrpNm);}
    /** get 급여공제그룹코드 : payDducGrpNm */
    public String  getPayDducGrpNm() { return (String )get( ATTR_PAYDDUCGRPNM );}

    /** set 급여공제명 : payDducNm */
    public void setPayDducNm(String  payDducNm) { set( ATTR_PAYDDUCNM ,payDducNm);}
    /** get 급여공제명 : payDducNm */
    public String  getPayDducNm() { return (String )get( ATTR_PAYDDUCNM );}

    /** set 급여공제사용여부 : payDducUseYn */
    public void setPayDducUseYn(String  payDducUseYn) { set( ATTR_PAYDDUCUSEYN ,payDducUseYn);}
    /** get 급여공제사용여부 : payDducUseYn */
    public String  getPayDducUseYn() { return (String )get( ATTR_PAYDDUCUSEYN );}

    /** set 급여공제금액 : payDducSum */
    public void setPayDducSum(BigDecimal  payDducSum) { set( ATTR_PAYDDUCSUM ,payDducSum);}
    /** get 급여공제금액 : payDducSum */
    public BigDecimal  getPayDducSum() { return (BigDecimal )get( ATTR_PAYDDUCSUM );}

    /** set 급여공제비율 : payDducRto */
    public void setPayDducRto(BigDecimal  payDducRto) { set( ATTR_PAYDDUCRTO ,payDducRto);}
    /** get 급여공제비율 : payDducRto */
    public BigDecimal  getPayDducRto() { return (BigDecimal )get( ATTR_PAYDDUCRTO );}

    /** set 연말정산_공제구분코드 : yrtxDducDivCd */
    public void setYrtxDducDivCd(String  yrtxDducDivCd) { set( ATTR_YRTXDDUCDIVCD ,yrtxDducDivCd);}
    /** get 연말정산_공제구분코드 : yrtxDducDivCd */
    public String  getYrtxDducDivCd() { return (String )get( ATTR_YRTXDDUCDIVCD );}
    
    /** set 연말정산_공제구분 : yrtxDducDivNm */
    public void setYrtxDducDivNm(String  yrtxDducDivNm) { set( ATTR_YRTXDDUCDIVNM ,yrtxDducDivNm);}
    /** get 연말정산_공제구분 : yrtxDducDivNm */
    public String  getYrtxDducDivNm() { return (String )get( ATTR_YRTXDDUCDIVNM );}
    
    /** set 퇴직적용여부 : sevePayYn */
    public void setSevePayYn(String  sevePayYn) { set( ATTR_SEVEPAYYN ,sevePayYn);}
    /** set 퇴직적용여부 : sevePayYn */
    public String  getSevePayYn() { return (String )get( ATTR_SEVEPAYYN );}
    
    /** set 회계계정코드 : accAccCd */
    public void setAccAccCd(String  accAccCd) { set( ATTR_ACCACCCD ,accAccCd);}
    /** set 회계계정코드 : accAccCd */
    public String  getAccAccCd() { return (String )get( ATTR_ACCACCCD );}
   
    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public void setYrtxFreeDtyReduCd(String  yrtxFreeDtyReduCd) { set( ATTR_YRTXFREEDTYREDUCD ,yrtxFreeDtyReduCd);}
    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public String  getYrtxFreeDtyReduCd() { return (String )get( ATTR_YRTXFREEDTYREDUCD );}
    
    /** set 그룹적용구분코드 : grpApptnDivCd */
    public void setGrpApptnDivCd(String  grpApptnDivCd) { set( ATTR_GRPAPPTNDIVCD ,grpApptnDivCd);}
    /** get 그룹적용구분코드 : grpApptnDivCd */
    public String  getGrpApptnDivCd() { return (String )get( ATTR_GRPAPPTNDIVCD );}
    
    /** set 그룹적용구분 : grpApptnDivNm */
    public void setGrpApptnDivNm(String  grpApptnDivNm) { set( ATTR_GRPAPPTNDIVNM ,grpApptnDivNm);}
    /** get 그룹적용구분 : grpApptnDivNm */
    public String  getGrpApptnDivNm() { return (String )get( ATTR_GRPAPPTNDIVNM );}

    /** set 급여공제시작일자 : payDducBgnnDt */
    public void setPayDducBgnnDt(String  payDducBgnnDt) { set( ATTR_PAYDDUCBGNNDT ,payDducBgnnDt);}
    /** get 급여공제시작일자 : payDducBgnnDt */
    public String  getPayDducBgnnDt() { return (String )get( ATTR_PAYDDUCBGNNDT );}

    /** set 급여공제종료일자 : payDducEndDt */
    public void setPayDducEndDt(String  payDducEndDt) { set( ATTR_PAYDDUCENDDT ,payDducEndDt);}
    /** get 급여공제종료일자 : payDducEndDt */
    public String  getPayDducEndDt() { return (String )get( ATTR_PAYDDUCENDDT );}

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

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}
 

    /** set 지급공제구분 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제구분 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}
    
    public void setPayExtpyCd(String  pymtExtpyCd) { set( ATTR_PYMTEXTPYCD ,pymtExtpyCd);}
    public String  getPayExtpyCd() { return (String )get( ATTR_PYMTEXTPYCD );}
    
    public void setPayExtpyNm(String  pymtExtpyNm) { set( ATTR_PYMTEXTPYNM ,pymtExtpyNm);}
    public String  getPayExtpyNm() { return (String )get( ATTR_PYMTEXTPYNM );}

    
}
