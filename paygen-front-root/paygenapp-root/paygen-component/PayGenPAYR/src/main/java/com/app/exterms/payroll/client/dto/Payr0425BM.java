package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0420BM.java
 * @Description : Payr0420 BM class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0425BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    public static final String ATTR_TYPOCCUGRDEMPPGSEILNUM = "typOccuGrdeMppgSeilNum";

    /** set 급여항목일련번호 : payrItemSeilNum */
    public static final String ATTR_PAYRITEMSEILNUM = "payrItemSeilNum";

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public static final String ATTR_PYSPLOGSVCYRNUMCD = "pyspLogSvcYrNumCd";
 

    /** set 호봉근속년수 : pyspLogSvcYrNumNm */
    public static final String ATTR_PYSPLOGSVCYRNUMNM = "pyspLogSvcYrNumNm";
    
    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public static final String ATTR_OCCUCLSSPAYCMPTTNSTD = "occuClssPayCmpttnStd";

    /** set 이전근속년수단가금액 : befSvcYrUcstSum */
    public static final String ATTR_BEFSVCYRUCSTSUM = "befSvcYrUcstSum";

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
     public Payr0425BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0425BM(
             String  dpobCd 
            , String  payYr 
            , BigDecimal  typOccuGrdeMppgSeilNum 
            , BigDecimal  payrItemSeilNum 
            , String  pyspLogSvcYrNumCd 
            , String  occuClssPayCmpttnStd 
            , BigDecimal  befSvcYrUcstSum 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_PAYYR,payYr);
        values.put(ATTR_TYPOCCUGRDEMPPGSEILNUM,typOccuGrdeMppgSeilNum);
        values.put(ATTR_PAYRITEMSEILNUM,payrItemSeilNum);
        values.put(ATTR_PYSPLOGSVCYRNUMCD,pyspLogSvcYrNumCd);
        values.put(ATTR_OCCUCLSSPAYCMPTTNSTD,occuClssPayCmpttnStd);
        values.put(ATTR_BEFSVCYRUCSTSUM,befSvcYrUcstSum);
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

    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    public void setTypOccuGrdeMppgSeilNum(BigDecimal  typOccuGrdeMppgSeilNum) { set( ATTR_TYPOCCUGRDEMPPGSEILNUM ,typOccuGrdeMppgSeilNum);}
    /** get 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    public BigDecimal  getTypOccuGrdeMppgSeilNum() { return (BigDecimal )get( ATTR_TYPOCCUGRDEMPPGSEILNUM );}

    /** set 급여항목일련번호 : payrItemSeilNum */
    public void setPayrItemSeilNum(BigDecimal  payrItemSeilNum) { set( ATTR_PAYRITEMSEILNUM ,payrItemSeilNum);}
    /** get 급여항목일련번호 : payrItemSeilNum */
    public BigDecimal  getPayrItemSeilNum() { return (BigDecimal )get( ATTR_PAYRITEMSEILNUM );}

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public void setPyspLogSvcYrNumCd(String  pyspLogSvcYrNumCd) { set( ATTR_PYSPLOGSVCYRNUMCD ,pyspLogSvcYrNumCd);}
    /** get 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public String  getPyspLogSvcYrNumCd() { return (String )get( ATTR_PYSPLOGSVCYRNUMCD );}

    /** set 호봉근속년수코드 : pyspLogSvcYrNumNm */
    public void setPyspLogSvcYrNumNm(String  pyspLogSvcYrNumNm) { set( ATTR_PYSPLOGSVCYRNUMNM ,pyspLogSvcYrNumNm);}
    /** get 호봉근속년수코드 : pyspLogSvcYrNumNm */
    public String  getPyspLogSvcYrNumNm() { return (String )get( ATTR_PYSPLOGSVCYRNUMNM );}
 
    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public void setOccuClssPayCmpttnStd(String  occuClssPayCmpttnStd) { set( ATTR_OCCUCLSSPAYCMPTTNSTD ,occuClssPayCmpttnStd);}
    /** get 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public String  getOccuClssPayCmpttnStd() { return (String )get( ATTR_OCCUCLSSPAYCMPTTNSTD );}

    /** set 이전근속년수단가금액 : befSvcYrUcstSum */
    public void setBefSvcYrUcstSum(BigDecimal  befSvcYrUcstSum) { set( ATTR_BEFSVCYRUCSTSUM ,befSvcYrUcstSum);}
    /** get 이전근속년수단가금액 : befSvcYrUcstSum */
    public BigDecimal  getBefSvcYrUcstSum() { return (BigDecimal )get( ATTR_BEFSVCYRUCSTSUM );}

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
