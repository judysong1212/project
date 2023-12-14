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
public class Remt2200BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public static final String ATTR_SEVEPAYDTLPATRNUM = "sevePayDtlPatrNum";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 수당그룹코드 : extpyGrpCd */
    public static final String ATTR_EXTPYGRPCD = "extpyGrpCd";

    /** set 퇴직금산정시간 : sevePayCmpttnTm */
    public static final String ATTR_SEVEPAYCMPTTNTM = "sevePayCmpttnTm";

    /** set 지급금액 : pymtSum */
    public static final String ATTR_PYMTSUM = "pymtSum";

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
     public Remt2200BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt2200BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  clutYrMnth 
    		, String  calcSevePayPsnDivCd 
    		, BigDecimal  sevePayDtlPatrNum 
    		, String  payItemCd 
    		, String  extpyGrpCd 
    		, String  sevePayCmpttnTm 
    		, BigDecimal  pymtSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
     	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
     	values.put(ATTR_SEVEPAYDTLPATRNUM,sevePayDtlPatrNum);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_EXTPYGRPCD,extpyGrpCd);
     	values.put(ATTR_SEVEPAYCMPTTNTM,sevePayCmpttnTm);
     	values.put(ATTR_PYMTSUM,pymtSum);
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

    /** set 정산년월 : clutYrMnth */
    public void setClutYrMnth(String  clutYrMnth) { set( ATTR_CLUTYRMNTH ,clutYrMnth);}
    /** get 정산년월 : clutYrMnth */
    public String  getClutYrMnth() { return (String )get( ATTR_CLUTYRMNTH );}

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public void setSevePayDtlPatrNum(BigDecimal  sevePayDtlPatrNum) { set( ATTR_SEVEPAYDTLPATRNUM ,sevePayDtlPatrNum);}
    /** get 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    public BigDecimal  getSevePayDtlPatrNum() { return (BigDecimal )get( ATTR_SEVEPAYDTLPATRNUM );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

    /** set 수당그룹코드 : extpyGrpCd */
    public void setExtpyGrpCd(String  extpyGrpCd) { set( ATTR_EXTPYGRPCD ,extpyGrpCd);}
    /** get 수당그룹코드 : extpyGrpCd */
    public String  getExtpyGrpCd() { return (String )get( ATTR_EXTPYGRPCD );}

    /** set 퇴직금산정시간 : sevePayCmpttnTm */
    public void setSevePayCmpttnTm(String  sevePayCmpttnTm) { set( ATTR_SEVEPAYCMPTTNTM ,sevePayCmpttnTm);}
    /** get 퇴직금산정시간 : sevePayCmpttnTm */
    public String  getSevePayCmpttnTm() { return (String )get( ATTR_SEVEPAYCMPTTNTM );}

    /** set 지급금액 : pymtSum */
    public void setPymtSum(BigDecimal  pymtSum) { set( ATTR_PYMTSUM ,pymtSum);}
    /** get 지급금액 : pymtSum */
    public BigDecimal  getPymtSum() { return (BigDecimal )get( ATTR_PYMTSUM );}

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
