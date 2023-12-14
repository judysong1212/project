package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0302VO.java
 * @Description : Payr0302 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0302BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 급여일련번호 : payrSeilNum */
    public static final String ATTR_PAYRSEILNUM = "payrSeilNum";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 급여항목일련번호 : payItemSeilNum */
    public static final String ATTR_PAYITEMSEILNUM = "payItemSeilNum";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    public static final String ATTR_PYMTDDUCFREEDTYSUM = "pymtDducFreeDtySum";

    /** set 지급공제금액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    public static final String ATTR_PAYPYMTDDUCPRCSFLAG = "payPymtDducPrcsFlag";

    /** set 급여지급공제소급조정값 : payReattyAdmntVal */
    public static final String ATTR_PAYREATTYADMNTVAL = "payReattyAdmntVal";

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

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    public static final String ATTR_PYMTDDUCTXTNAMNT = "pymtDducTxtnAmnt";

    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    public static final String ATTR_PYYTYRTXDOTNCD = "pyytYrtxDotnCd";

    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    public static final String ATTR_PYYTYTFEDTYREDUCD = "pyytYtfeDtyReduCd";

    /** set 급여지급공제변경여부 : pymtDducChgYn */
    public static final String ATTR_PYMTDDUCCHGYN = "pymtDducChgYn";


    /** 생성자 */
     public Payr0302BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0302BM(
             String  dpobCd 
            , String  pymtYrMnth 
            , String  payCd 
            , BigDecimal  payrSeilNum 
            , String  systemkey 
            , String  payItemCd 
            , BigDecimal  payItemSeilNum 
            , String  pymtDducDivCd 
            , BigDecimal  pymtDducFreeDtySum 
            , BigDecimal  pymtDducSum 
            , String  payPymtDducPrcsFlag 
            , String  payReattyAdmntVal 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr 
            , BigDecimal  pymtDducTxtnAmnt ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
        values.put(ATTR_PAYCD,payCd);
        values.put(ATTR_PAYRSEILNUM,payrSeilNum);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_PAYITEMCD,payItemCd);
        values.put(ATTR_PAYITEMSEILNUM,payItemSeilNum);
        values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
        values.put(ATTR_PYMTDDUCFREEDTYSUM,pymtDducFreeDtySum);
        values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
        values.put(ATTR_PAYPYMTDDUCPRCSFLAG,payPymtDducPrcsFlag);
        values.put(ATTR_PAYREATTYADMNTVAL,payReattyAdmntVal);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_PYMTDDUCTXTNAMNT,pymtDducTxtnAmnt); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

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

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

    /** set 급여항목일련번호 : payItemSeilNum */
    public void setPayItemSeilNum(BigDecimal  payItemSeilNum) { set( ATTR_PAYITEMSEILNUM ,payItemSeilNum);}
    /** get 급여항목일련번호 : payItemSeilNum */
    public BigDecimal  getPayItemSeilNum() { return (BigDecimal )get( ATTR_PAYITEMSEILNUM );}

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    public void setPymtDducFreeDtySum(BigDecimal  pymtDducFreeDtySum) { set( ATTR_PYMTDDUCFREEDTYSUM ,pymtDducFreeDtySum);}
    /** get 지급공제비과세금액 : pymtDducFreeDtySum */
    public BigDecimal  getPymtDducFreeDtySum() { return (BigDecimal )get( ATTR_PYMTDDUCFREEDTYSUM );}

    /** set 지급공제금액 : pymtDducSum */
    public void setPymtDducSum(BigDecimal  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지급공제금액 : pymtDducSum */
    public BigDecimal  getPymtDducSum() { return (BigDecimal )get( ATTR_PYMTDDUCSUM );}

    /** set 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    public void setPayPymtDducPrcsFlag(String  payPymtDducPrcsFlag) { set( ATTR_PAYPYMTDDUCPRCSFLAG ,payPymtDducPrcsFlag);}
    /** get 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    public String  getPayPymtDducPrcsFlag() { return (String )get( ATTR_PAYPYMTDDUCPRCSFLAG );}

    /** set 급여지급공제소급조정값 : payReattyAdmntVal */
    public void setPayReattyAdmntVal(String  payReattyAdmntVal) { set( ATTR_PAYREATTYADMNTVAL ,payReattyAdmntVal);}
    /** get 급여지급공제소급조정값 : payReattyAdmntVal */
    public String  getPayReattyAdmntVal() { return (String )get( ATTR_PAYREATTYADMNTVAL );}

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

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    public void setPymtDducTxtnAmnt(BigDecimal  pymtDducTxtnAmnt) { set( ATTR_PYMTDDUCTXTNAMNT ,pymtDducTxtnAmnt);}
    /** get 지급공제과세금액 : pymtDducTxtnAmnt */
    public BigDecimal  getPymtDducTxtnAmnt() { return (BigDecimal )get( ATTR_PYMTDDUCTXTNAMNT );}

     

    /** set 급여항목코드 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";
 
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
 

    /** set 지급공제구분 : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";
      

     /** set 지급공제구분 : pymtDducDivNm */
     public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
     /** get 지급공제구분 : pymtDducDivNm */
     public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}
      
    
    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목코드 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
 
    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

/** set 연말정산_기부금코드 : pyytYrtxDotnCd */
public void setPyytYrtxDotnCd(String  pyytYrtxDotnCd) { set( ATTR_PYYTYRTXDOTNCD ,pyytYrtxDotnCd);}
/** get 연말정산_기부금코드 : pyytYrtxDotnCd */
public String  getPyytYrtxDotnCd() { return (String )get( ATTR_PYYTYRTXDOTNCD );}

/** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
public void setPyytYtfeDtyReduCd(String  pyytYtfeDtyReduCd) { set( ATTR_PYYTYTFEDTYREDUCD ,pyytYtfeDtyReduCd);}
/** get 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
public String  getPyytYtfeDtyReduCd() { return (String )get( ATTR_PYYTYTFEDTYREDUCD );}


/** set 급여지급공제변경여부 : pymtDducChgYn */
public void setPymtDducChgYn(String  pymtDducChgYn) { set( ATTR_PYMTDDUCCHGYN ,pymtDducChgYn);}
/** get 급여지급공제변경여부 : pymtDducChgYn */
public String  getPymtDducChgYn() { return (String )get( ATTR_PYMTDDUCCHGYN );}
    
}
