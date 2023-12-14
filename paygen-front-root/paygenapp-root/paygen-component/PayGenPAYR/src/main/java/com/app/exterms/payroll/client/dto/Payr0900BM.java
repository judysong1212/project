package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0900VO.java
 * @Description : Payr0900 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0900BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 원천징수발급번호 : whdgTxIssNum */
    public static final String ATTR_WHDGTXISSNUM = "whdgTxIssNum";

    /** set 원천징수발급년도 : whdgTxIssYr */
    public static final String ATTR_WHDGTXISSYR = "whdgTxIssYr";

    /** set 증명서발급구분코드 : certcIssDivCd */
    public static final String ATTR_CERTCISSDIVCD = "certcIssDivCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 원천징수발급일자 : whdgTxIssDt */
    public static final String ATTR_WHDGTXISSDT = "whdgTxIssDt";

    /** set 원천징수발급부수 : whdgTxIssNumCpis */
    public static final String ATTR_WHDGTXISSNUMCPIS = "whdgTxIssNumCpis";

    /** set 원천징수발급용도내용 : whdgTxIssPrpseCtnt */
    public static final String ATTR_WHDGTXISSPRPSECTNT = "whdgTxIssPrpseCtnt";

    /** set 원천징수발급기관명 : whdgTxIssIstutNm */
    public static final String ATTR_WHDGTXISSISTUTNM = "whdgTxIssIstutNm";

    /** set 원천징수발급신청일자 : whdgTxIssAppyDt */
    public static final String ATTR_WHDGTXISSAPPYDT = "whdgTxIssAppyDt";

    /** set 원천징수발급승인일자 : whdgTxIssAppbnDt */
    public static final String ATTR_WHDGTXISSAPPBNDT = "whdgTxIssAppbnDt";

    /** set 원천징수발급상태구분코드 : whdgTxIssCodTNDivCd */
    public static final String ATTR_WHDGTXISSCODTNDIVCD = "whdgTxIssCodTNDivCd";

    /** set 원천징수발급여부 : whdgTxIssYn */
    public static final String ATTR_WHDGTXISSYN = "whdgTxIssYn";

    /** set 원천징수발급삭제여부 : whdgTxIssDelYn */
    public static final String ATTR_WHDGTXISSDELYN = "whdgTxIssDelYn";

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
     public Payr0900BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0900BM(
    		 String  dpobCd 
    		, String  whdgTxIssNum 
    		, String  whdgTxIssYr 
    		, String  certcIssDivCd 
    		, String  systemkey 
    		, String  whdgTxIssDt 
    		, BigDecimal  whdgTxIssNumCpis 
    		, String  whdgTxIssPrpseCtnt 
    		, String  whdgTxIssIstutNm 
    		, String  whdgTxIssAppyDt 
    		, String  whdgTxIssAppbnDt 
    		, String  whdgTxIssCodTNDivCd 
    		, String  whdgTxIssYn 
    		, String  whdgTxIssDelYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_WHDGTXISSNUM,whdgTxIssNum);
     	values.put(ATTR_WHDGTXISSYR,whdgTxIssYr);
     	values.put(ATTR_CERTCISSDIVCD,certcIssDivCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_WHDGTXISSDT,whdgTxIssDt);
     	values.put(ATTR_WHDGTXISSNUMCPIS,whdgTxIssNumCpis);
     	values.put(ATTR_WHDGTXISSPRPSECTNT,whdgTxIssPrpseCtnt);
     	values.put(ATTR_WHDGTXISSISTUTNM,whdgTxIssIstutNm);
     	values.put(ATTR_WHDGTXISSAPPYDT,whdgTxIssAppyDt);
     	values.put(ATTR_WHDGTXISSAPPBNDT,whdgTxIssAppbnDt);
     	values.put(ATTR_WHDGTXISSCODTNDIVCD,whdgTxIssCodTNDivCd);
     	values.put(ATTR_WHDGTXISSYN,whdgTxIssYn);
     	values.put(ATTR_WHDGTXISSDELYN,whdgTxIssDelYn);
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

    /** set 원천징수발급번호 : whdgTxIssNum */
    public void setWhdgTxIssNum(String  whdgTxIssNum) { set( ATTR_WHDGTXISSNUM ,whdgTxIssNum);}
    /** get 원천징수발급번호 : whdgTxIssNum */
    public String  getWhdgTxIssNum() { return (String )get( ATTR_WHDGTXISSNUM );}

    /** set 원천징수발급년도 : whdgTxIssYr */
    public void setWhdgTxIssYr(String  whdgTxIssYr) { set( ATTR_WHDGTXISSYR ,whdgTxIssYr);}
    /** get 원천징수발급년도 : whdgTxIssYr */
    public String  getWhdgTxIssYr() { return (String )get( ATTR_WHDGTXISSYR );}

    /** set 증명서발급구분코드 : certcIssDivCd */
    public void setCertcIssDivCd(String  certcIssDivCd) { set( ATTR_CERTCISSDIVCD ,certcIssDivCd);}
    /** get 증명서발급구분코드 : certcIssDivCd */
    public String  getCertcIssDivCd() { return (String )get( ATTR_CERTCISSDIVCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 원천징수발급일자 : whdgTxIssDt */
    public void setWhdgTxIssDt(String  whdgTxIssDt) { set( ATTR_WHDGTXISSDT ,whdgTxIssDt);}
    /** get 원천징수발급일자 : whdgTxIssDt */
    public String  getWhdgTxIssDt() { return (String )get( ATTR_WHDGTXISSDT );}

    /** set 원천징수발급부수 : whdgTxIssNumCpis */
    public void setWhdgTxIssNumCpis(BigDecimal  whdgTxIssNumCpis) { set( ATTR_WHDGTXISSNUMCPIS ,whdgTxIssNumCpis);}
    /** get 원천징수발급부수 : whdgTxIssNumCpis */
    public BigDecimal  getWhdgTxIssNumCpis() { return (BigDecimal )get( ATTR_WHDGTXISSNUMCPIS );}

    /** set 원천징수발급용도내용 : whdgTxIssPrpseCtnt */
    public void setWhdgTxIssPrpseCtnt(String  whdgTxIssPrpseCtnt) { set( ATTR_WHDGTXISSPRPSECTNT ,whdgTxIssPrpseCtnt);}
    /** get 원천징수발급용도내용 : whdgTxIssPrpseCtnt */
    public String  getWhdgTxIssPrpseCtnt() { return (String )get( ATTR_WHDGTXISSPRPSECTNT );}

    /** set 원천징수발급기관명 : whdgTxIssIstutNm */
    public void setWhdgTxIssIstutNm(String  whdgTxIssIstutNm) { set( ATTR_WHDGTXISSISTUTNM ,whdgTxIssIstutNm);}
    /** get 원천징수발급기관명 : whdgTxIssIstutNm */
    public String  getWhdgTxIssIstutNm() { return (String )get( ATTR_WHDGTXISSISTUTNM );}

    /** set 원천징수발급신청일자 : whdgTxIssAppyDt */
    public void setWhdgTxIssAppyDt(String  whdgTxIssAppyDt) { set( ATTR_WHDGTXISSAPPYDT ,whdgTxIssAppyDt);}
    /** get 원천징수발급신청일자 : whdgTxIssAppyDt */
    public String  getWhdgTxIssAppyDt() { return (String )get( ATTR_WHDGTXISSAPPYDT );}

    /** set 원천징수발급승인일자 : whdgTxIssAppbnDt */
    public void setWhdgTxIssAppbnDt(String  whdgTxIssAppbnDt) { set( ATTR_WHDGTXISSAPPBNDT ,whdgTxIssAppbnDt);}
    /** get 원천징수발급승인일자 : whdgTxIssAppbnDt */
    public String  getWhdgTxIssAppbnDt() { return (String )get( ATTR_WHDGTXISSAPPBNDT );}

    /** set 원천징수발급상태구분코드 : whdgTxIssCodTNDivCd */
    public void setWhdgTxIssCodTNDivCd(String  whdgTxIssCodTNDivCd) { set( ATTR_WHDGTXISSCODTNDIVCD ,whdgTxIssCodTNDivCd);}
    /** get 원천징수발급상태구분코드 : whdgTxIssCodTNDivCd */
    public String  getWhdgTxIssCodTNDivCd() { return (String )get( ATTR_WHDGTXISSCODTNDIVCD );}

    /** set 원천징수발급여부 : whdgTxIssYn */
    public void setWhdgTxIssYn(String  whdgTxIssYn) { set( ATTR_WHDGTXISSYN ,whdgTxIssYn);}
    /** get 원천징수발급여부 : whdgTxIssYn */
    public String  getWhdgTxIssYn() { return (String )get( ATTR_WHDGTXISSYN );}

    /** set 원천징수발급삭제여부 : whdgTxIssDelYn */
    public void setWhdgTxIssDelYn(String  whdgTxIssDelYn) { set( ATTR_WHDGTXISSDELYN ,whdgTxIssDelYn);}
    /** get 원천징수발급삭제여부 : whdgTxIssDelYn */
    public String  getWhdgTxIssDelYn() { return (String )get( ATTR_WHDGTXISSDELYN );}

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
