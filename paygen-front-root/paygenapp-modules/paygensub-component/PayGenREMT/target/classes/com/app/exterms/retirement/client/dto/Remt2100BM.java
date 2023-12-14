package com.app.exterms.retirement.client.dto;



import java.math.BigDecimal;

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
public class Remt2100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public static final String ATTR_SEVEPAYDTLPATRNUM = "sevePayDtlPatrNum";

    /** set 급여지급시작일자 : payPymtBgnnDt */
    public static final String ATTR_PAYPYMTBGNNDT = "payPymtBgnnDt";

    /** set 급여지급종료일자 : payPymtEndDt */
    public static final String ATTR_PAYPYMTENDDT = "payPymtEndDt";

    /** set 지급일수 : pymtNumDys */
    public static final String ATTR_PYMTNUMDYS = "pymtNumDys";

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
     public Remt2100BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt2100BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  calcSevePayPsnDivCd 
    		, String  clutYrMnth 
    		, BigDecimal  sevePayDtlPatrNum 
    		, String  payPymtBgnnDt 
    		, String  payPymtEndDt 
    		, BigDecimal  pymtNumDys 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
     	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
     	values.put(ATTR_SEVEPAYDTLPATRNUM,sevePayDtlPatrNum);
     	values.put(ATTR_PAYPYMTBGNNDT,payPymtBgnnDt);
     	values.put(ATTR_PAYPYMTENDDT,payPymtEndDt);
     	values.put(ATTR_PYMTNUMDYS,pymtNumDys);
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

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public void setSevePayDtlPatrNum(BigDecimal  sevePayDtlPatrNum) { set( ATTR_SEVEPAYDTLPATRNUM ,sevePayDtlPatrNum);}
    /** get 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public BigDecimal  getSevePayDtlPatrNum() { return (BigDecimal )get( ATTR_SEVEPAYDTLPATRNUM );}

    /** set 급여지급시작일자 : payPymtBgnnDt */
    public void setPayPymtBgnnDt(String  payPymtBgnnDt) { set( ATTR_PAYPYMTBGNNDT ,payPymtBgnnDt);}
    /** get 급여지급시작일자 : payPymtBgnnDt */
    public String  getPayPymtBgnnDt() { return (String )get( ATTR_PAYPYMTBGNNDT );}

    /** set 급여지급종료일자 : payPymtEndDt */
    public void setPayPymtEndDt(String  payPymtEndDt) { set( ATTR_PAYPYMTENDDT ,payPymtEndDt);}
    /** get 급여지급종료일자 : payPymtEndDt */
    public String  getPayPymtEndDt() { return (String )get( ATTR_PAYPYMTENDDT );}

    /** set 지급일수 : pymtNumDys */
    public void setPymtNumDys(BigDecimal  pymtNumDys) { set( ATTR_PYMTNUMDYS ,pymtNumDys);}
    /** get 지급일수 : pymtNumDys */
    public BigDecimal  getPymtNumDys() { return (BigDecimal )get( ATTR_PYMTNUMDYS );}

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
