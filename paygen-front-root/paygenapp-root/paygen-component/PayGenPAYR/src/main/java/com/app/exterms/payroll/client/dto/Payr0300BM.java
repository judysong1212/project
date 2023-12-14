package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0300BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 급여일련번호 : payrSeilNum */
    public static final String ATTR_PAYRSEILNUM = "payrSeilNum";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여지급일자 : payPymtDt */
    public static final String ATTR_PAYPYMTDT = "payPymtDt";

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

    /** set 급여마스터비고내용 : payMstrNoteCtnt */
    public static final String ATTR_PAYMSTRNOTECTNT = "payMstrNoteCtnt";

    /** 생성자 */
     public Payr0300BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0300BM(
    		 String  payrMangDeptCd 
    		, String  pymtYrMnth 
    		, String  payCd 
    		, BigDecimal  payrSeilNum 
    		, String  dpobCd 
    		, String  payPymtDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  payMstrNoteCtnt ) { 
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_PAYRSEILNUM,payrSeilNum);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYPYMTDT,payPymtDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_PAYMSTRNOTECTNT,payMstrNoteCtnt); } 

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 지급년월 : pymtYrMnth */
    public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
    /** get 지급년월 : pymtYrMnth */
    public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 급여일련번호 : payrSeilNum */
    public void setPayrSeilNum(BigDecimal  payrSeilNum) { set( ATTR_PAYRSEILNUM ,payrSeilNum);}
    /** get 급여일련번호 : payrSeilNum */
    public BigDecimal  getPayrSeilNum() { return (BigDecimal )get( ATTR_PAYRSEILNUM );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 급여지급일자 : payPymtDt */
    public void setPayPymtDt(String  payPymtDt) { set( ATTR_PAYPYMTDT ,payPymtDt);}
    /** get 급여지급일자 : payPymtDt */
    public String  getPayPymtDt() { return (String )get( ATTR_PAYPYMTDT );}

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

    /** set 급여마스터비고내용 : payMstrNoteCtnt */
    public void setPayMstrNoteCtnt(String  payMstrNoteCtnt) { set( ATTR_PAYMSTRNOTECTNT ,payMstrNoteCtnt);}
    /** get 급여마스터비고내용 : payMstrNoteCtnt */
    public String  getPayMstrNoteCtnt() { return (String )get( ATTR_PAYMSTRNOTECTNT );}

}
