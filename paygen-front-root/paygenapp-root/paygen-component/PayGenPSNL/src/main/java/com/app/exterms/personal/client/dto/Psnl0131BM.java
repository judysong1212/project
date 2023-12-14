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
public class Psnl0131BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 관련근거일련번호 : refeSeilNum */
    public static final String ATTR_REFESEILNUM = "refeSeilNum";

    /** set 관련근거등록일자 : refeIndt */
    public static final String ATTR_REFEINDT = "refeIndt";

    /** set 관련근거담당자명 : refePrchNm */
    public static final String ATTR_REFEPRCHNM = "refePrchNm";

    /** set 관련근거담당전화번호 : refePrchTel */
    public static final String ATTR_REFEPRCHTEL = "refePrchTel";

    /** set 관련근거구분코드 : refeDivCd */
    public static final String ATTR_REFEDIVCD = "refeDivCd";

    /** set 관련근거제목 : refeTitl */
    public static final String ATTR_REFETITL = "refeTitl";

    /** set 관련근거내용 : refeCtnt */
    public static final String ATTR_REFECTNT = "refeCtnt";

    /** set null : refeDelFg */
    public static final String ATTR_REFEDELFG = "refeDelFg";

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
     public Psnl0131BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0131BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, Long  refeSeilNum 
    		, String  refeIndt 
    		, String  refePrchNm 
    		, String  refePrchTel 
    		, String  refeDivCd 
    		, String  refeTitl 
    		, String  refeCtnt 
    		, String  refeDelFg 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_REFESEILNUM,refeSeilNum);
     	values.put(ATTR_REFEINDT,refeIndt);
     	values.put(ATTR_REFEPRCHNM,refePrchNm);
     	values.put(ATTR_REFEPRCHTEL,refePrchTel);
     	values.put(ATTR_REFEDIVCD,refeDivCd);
     	values.put(ATTR_REFETITL,refeTitl);
     	values.put(ATTR_REFECTNT,refeCtnt);
     	values.put(ATTR_REFEDELFG,refeDelFg);
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
    /** set 관련근거일련번호 : refeSeilNum */
    public void setRefeSeilNum(Long  refeSeilNum) { set( ATTR_REFESEILNUM ,refeSeilNum);}
    /** get 관련근거일련번호 : refeSeilNum */
    public Long  getRefeSeilNum() { return (Long )get( ATTR_REFESEILNUM );}
    /** set 관련근거등록일자 : refeIndt */
    public void setRefeIndt(String  refeIndt) { set( ATTR_REFEINDT ,refeIndt);}
    /** get 관련근거등록일자 : refeIndt */
    public String  getRefeIndt() { return (String )get( ATTR_REFEINDT );}
    /** set 관련근거담당자명 : refePrchNm */
    public void setRefePrchNm(String  refePrchNm) { set( ATTR_REFEPRCHNM ,refePrchNm);}
    /** get 관련근거담당자명 : refePrchNm */
    public String  getRefePrchNm() { return (String )get( ATTR_REFEPRCHNM );}
    /** set 관련근거담당전화번호 : refePrchTel */
    public void setRefePrchTel(String  refePrchTel) { set( ATTR_REFEPRCHTEL ,refePrchTel);}
    /** get 관련근거담당전화번호 : refePrchTel */
    public String  getRefePrchTel() { return (String )get( ATTR_REFEPRCHTEL );}
    /** set 관련근거구분코드 : refeDivCd */
    public void setRefeDivCd(String  refeDivCd) { set( ATTR_REFEDIVCD ,refeDivCd);}
    /** get 관련근거구분코드 : refeDivCd */
    public String  getRefeDivCd() { return (String )get( ATTR_REFEDIVCD );}
    /** set 관련근거제목 : refeTitl */
    public void setRefeTitl(String  refeTitl) { set( ATTR_REFETITL ,refeTitl);}
    /** get 관련근거제목 : refeTitl */
    public String  getRefeTitl() { return (String )get( ATTR_REFETITL );}
    /** set 관련근거내용 : refeCtnt */
    public void setRefeCtnt(String  refeCtnt) { set( ATTR_REFECTNT ,refeCtnt);}
    /** get 관련근거내용 : refeCtnt */
    public String  getRefeCtnt() { return (String )get( ATTR_REFECTNT );}
    /** set null : refeDelFg */
    public void setRefeDelFg(String  refeDelFg) { set( ATTR_REFEDELFG ,refeDelFg);}
    /** get null : refeDelFg */
    public String  getRefeDelFg() { return (String )get( ATTR_REFEDELFG );}
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
