package com.app.exterms.personal.client.dto;



import java.math.BigDecimal;

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
public class Psnl0120BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 교육일련번호 : eduSeilNum */
    public static final String ATTR_EDUSEILNUM = "eduSeilNum";

    /** set 교육시작일자 : eduBgnnDt */
    public static final String ATTR_EDUBGNNDT = "eduBgnnDt";

    /** set 교육종료일자 : eduEndDt */
    public static final String ATTR_EDUENDDT = "eduEndDt";

    /** set 교육이수시간 : eduCmpteTm */
    public static final String ATTR_EDUCMPTETM = "eduCmpteTm";

    /** set 교육종류명 : eduKndNm */
    public static final String ATTR_EDUKNDNM = "eduKndNm";

    /** set 교육기관명 : eduIstutNm */
    public static final String ATTR_EDUISTUTNM = "eduIstutNm";

    /** set 교육비고내용 : eduNoteCtnt */
    public static final String ATTR_EDUNOTECTNT = "eduNoteCtnt";

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
     public Psnl0120BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0120BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  eduSeilNum 
    		, String  eduBgnnDt 
    		, String  eduEndDt 
    		, String  eduCmpteTm 
    		, String  eduKndNm 
    		, String  eduIstutNm 
    		, String  eduNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_EDUSEILNUM,eduSeilNum);
     	values.put(ATTR_EDUBGNNDT,eduBgnnDt);
     	values.put(ATTR_EDUENDDT,eduEndDt);
     	values.put(ATTR_EDUCMPTETM,eduCmpteTm);
     	values.put(ATTR_EDUKNDNM,eduKndNm);
     	values.put(ATTR_EDUISTUTNM,eduIstutNm);
     	values.put(ATTR_EDUNOTECTNT,eduNoteCtnt);
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
    /** set 교육일련번호 : eduSeilNum */
    public void setEduSeilNum(BigDecimal  eduSeilNum) { set( ATTR_EDUSEILNUM ,eduSeilNum);}
    /** get 교육일련번호 : eduSeilNum */
    public BigDecimal  getEduSeilNum() { return (BigDecimal )get( ATTR_EDUSEILNUM );}
    /** set 교육시작일자 : eduBgnnDt */
    public void setEduBgnnDt(String  eduBgnnDt) { set( ATTR_EDUBGNNDT ,eduBgnnDt);}
    /** get 교육시작일자 : eduBgnnDt */
    public String  getEduBgnnDt() { return (String )get( ATTR_EDUBGNNDT );}
    /** set 교육종료일자 : eduEndDt */
    public void setEduEndDt(String  eduEndDt) { set( ATTR_EDUENDDT ,eduEndDt);}
    /** get 교육종료일자 : eduEndDt */
    public String  getEduEndDt() { return (String )get( ATTR_EDUENDDT );}
    /** set 교육이수시간 : eduCmpteTm */
    public void setEduCmpteTm(String  eduCmpteTm) { set( ATTR_EDUCMPTETM ,eduCmpteTm);}
    /** get 교육이수시간 : eduCmpteTm */
    public String  getEduCmpteTm() { return (String )get( ATTR_EDUCMPTETM );}
    /** set 교육종류명 : eduKndNm */
    public void setEduKndNm(String  eduKndNm) { set( ATTR_EDUKNDNM ,eduKndNm);}
    /** get 교육종류명 : eduKndNm */
    public String  getEduKndNm() { return (String )get( ATTR_EDUKNDNM );}
    /** set 교육기관명 : eduIstutNm */
    public void setEduIstutNm(String  eduIstutNm) { set( ATTR_EDUISTUTNM ,eduIstutNm);}
    /** get 교육기관명 : eduIstutNm */
    public String  getEduIstutNm() { return (String )get( ATTR_EDUISTUTNM );}
    /** set 교육비고내용 : eduNoteCtnt */
    public void setEduNoteCtnt(String  eduNoteCtnt) { set( ATTR_EDUNOTECTNT ,eduNoteCtnt);}
    /** get 교육비고내용 : eduNoteCtnt */
    public String  getEduNoteCtnt() { return (String )get( ATTR_EDUNOTECTNT );}
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
