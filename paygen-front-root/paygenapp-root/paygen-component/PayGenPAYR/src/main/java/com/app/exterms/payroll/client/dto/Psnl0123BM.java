package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0130VO.java
 * @Description : Psnl0130 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0123BM   extends MSFSimpleBaseModel implements IsSerializable  {
	
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 휴직일련번호 : levfAbncSeilNum */
    public static final String ATTR_LEVFABNCSEILNUM = "levfAbncSeilNum";

    /** set 휴직구분코드 : levfAbncDivCd */
    public static final String ATTR_LEVFABNCDIVCD = "levfAbncDivCd";

    /** set 휴직시작일자 : levfAbncBgnnDt */
    public static final String ATTR_LEVFABNCBGNNDT = "levfAbncBgnnDt";

    /** set 휴직종료일자 : levfAbncEndDt */
    public static final String ATTR_LEVFABNCENDDT = "levfAbncEndDt";

    /** set 실제복직일자 : turtyRntmntDt */
    public static final String ATTR_TURTYRNTMNTDT = "turtyRntmntDt";

    /** set 휴직비고내용 : levfAbncNoteCtnt */
    public static final String ATTR_LEVFABNCNOTECTNT = "levfAbncNoteCtnt";

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
     public Psnl0123BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0123BM(
             String  dpobCd 
            , String  systemkey 
            , Long  levfAbncSeilNum 
            , String  levfAbncDivCd 
            , String  levfAbncBgnnDt 
            , String  levfAbncEndDt 
            , String  turtyRntmntDt 
            , String  levfAbncNoteCtnt 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_LEVFABNCSEILNUM,levfAbncSeilNum);
        values.put(ATTR_LEVFABNCDIVCD,levfAbncDivCd);
        values.put(ATTR_LEVFABNCBGNNDT,levfAbncBgnnDt);
        values.put(ATTR_LEVFABNCENDDT,levfAbncEndDt);
        values.put(ATTR_TURTYRNTMNTDT,turtyRntmntDt);
        values.put(ATTR_LEVFABNCNOTECTNT,levfAbncNoteCtnt);
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

    /** set 휴직일련번호 : levfAbncSeilNum */
    public void setLevfAbncSeilNum(Long  levfAbncSeilNum) { set( ATTR_LEVFABNCSEILNUM ,levfAbncSeilNum);}
    /** get 휴직일련번호 : levfAbncSeilNum */
    public Long  getLevfAbncSeilNum() { return (Long )get( ATTR_LEVFABNCSEILNUM );}

    /** set 휴직구분코드 : levfAbncDivCd */
    public void setLevfAbncDivCd(String  levfAbncDivCd) { set( ATTR_LEVFABNCDIVCD ,levfAbncDivCd);}
    /** get 휴직구분코드 : levfAbncDivCd */
    public String  getLevfAbncDivCd() { return (String )get( ATTR_LEVFABNCDIVCD );}

    /** set 휴직시작일자 : levfAbncBgnnDt */
    public void setLevfAbncBgnnDt(String  levfAbncBgnnDt) { set( ATTR_LEVFABNCBGNNDT ,levfAbncBgnnDt);}
    /** get 휴직시작일자 : levfAbncBgnnDt */
    public String  getLevfAbncBgnnDt() { return (String )get( ATTR_LEVFABNCBGNNDT );}

    /** set 휴직종료일자 : levfAbncEndDt */
    public void setLevfAbncEndDt(String  levfAbncEndDt) { set( ATTR_LEVFABNCENDDT ,levfAbncEndDt);}
    /** get 휴직종료일자 : levfAbncEndDt */
    public String  getLevfAbncEndDt() { return (String )get( ATTR_LEVFABNCENDDT );}

    /** set 실제복직일자 : turtyRntmntDt */
    public void setTurtyRntmntDt(String  turtyRntmntDt) { set( ATTR_TURTYRNTMNTDT ,turtyRntmntDt);}
    /** get 실제복직일자 : turtyRntmntDt */
    public String  getTurtyRntmntDt() { return (String )get( ATTR_TURTYRNTMNTDT );}

    /** set 휴직비고내용 : levfAbncNoteCtnt */
    public void setLevfAbncNoteCtnt(String  levfAbncNoteCtnt) { set( ATTR_LEVFABNCNOTECTNT ,levfAbncNoteCtnt);}
    /** get 휴직비고내용 : levfAbncNoteCtnt */
    public String  getLevfAbncNoteCtnt() { return (String )get( ATTR_LEVFABNCNOTECTNT );}

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
