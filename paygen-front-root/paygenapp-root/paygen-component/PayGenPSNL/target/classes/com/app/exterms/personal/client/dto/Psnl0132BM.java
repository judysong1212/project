package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0132BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 관련근거파일일련번호 : refeFlSeilNum */
    public static final String ATTR_REFEFLSEILNUM = "refeFlSeilNum";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 관련근거일련번호 : refeSeilNum */
    public static final String ATTR_REFESEILNUM = "refeSeilNum";

    /** set 관련근거파일명 : refeFlnm */
    public static final String ATTR_REFEFLNM = "refeFlnm";

    /** set 관련근거원본파일명 : refeOrgFlnm */
    public static final String ATTR_REFEORGFLNM = "refeOrgFlnm";

    /** set 관련근거파일경로 : refeFlcos */
    public static final String ATTR_REFEFLCOS = "refeFlcos";

    /** set 관련근거파일크기 : refeFlsz */
    public static final String ATTR_REFEFLSZ = "refeFlsz";

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
     public Psnl0132BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0132BM(
    		 String  refeFlSeilNum 
    		, String  dpobCd 
    		, String  systemkey 
    		, Long  refeSeilNum 
    		, String  refeFlnm 
    		, String  refeOrgFlnm 
    		, String  refeFlcos 
    		, String  refeFlsz 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_REFEFLSEILNUM,refeFlSeilNum);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_REFESEILNUM,refeSeilNum);
     	values.put(ATTR_REFEFLNM,refeFlnm);
     	values.put(ATTR_REFEORGFLNM,refeOrgFlnm);
     	values.put(ATTR_REFEFLCOS,refeFlcos);
     	values.put(ATTR_REFEFLSZ,refeFlsz);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 관련근거파일일련번호 : refeFlSeilNum */
    public void setRefeFlSeilNum(String  refeFlSeilNum) { set( ATTR_REFEFLSEILNUM ,refeFlSeilNum);}
    /** get 관련근거파일일련번호 : refeFlSeilNum */
    public String  getRefeFlSeilNum() { return (String )get( ATTR_REFEFLSEILNUM );}
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 관련근거일련번호 : refeSeilNum */
    public void setRefeSeilNum(Long  refeSeilNum) { set( ATTR_REFESEILNUM ,refeSeilNum);}
    /** get 관련근거일련번호 : refeSeilNum */
    public Long  getRefeSeilNum() { return (Long )get( ATTR_REFESEILNUM );}
    /** set 관련근거파일명 : refeFlnm */
    public void setRefeFlnm(String  refeFlnm) { set( ATTR_REFEFLNM ,refeFlnm);}
    /** get 관련근거파일명 : refeFlnm */
    public String  getRefeFlnm() { return (String )get( ATTR_REFEFLNM );}
    /** set 관련근거원본파일명 : refeOrgFlnm */
    public void setRefeOrgFlnm(String  refeOrgFlnm) { set( ATTR_REFEORGFLNM ,refeOrgFlnm);}
    /** get 관련근거원본파일명 : refeOrgFlnm */
    public String  getRefeOrgFlnm() { return (String )get( ATTR_REFEORGFLNM );}
    /** set 관련근거파일경로 : refeFlcos */
    public void setRefeFlcos(String  refeFlcos) { set( ATTR_REFEFLCOS ,refeFlcos);}
    /** get 관련근거파일경로 : refeFlcos */
    public String  getRefeFlcos() { return (String )get( ATTR_REFEFLCOS );}
    /** set 관련근거파일크기 : refeFlsz */
    public void setRefeFlsz(String  refeFlsz) { set( ATTR_REFEFLSZ ,refeFlsz);}
    /** get 관련근거파일크기 : refeFlsz */
    public String  getRefeFlsz() { return (String )get( ATTR_REFEFLSZ );}
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
