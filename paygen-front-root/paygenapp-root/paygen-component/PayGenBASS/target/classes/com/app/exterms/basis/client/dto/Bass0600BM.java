package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0600VO.java
 * @Description : Bass0600 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0600BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 이관작업구분코드 : trnrCtlJobDivCd */
    public static final String ATTR_TRNRCTLJOBDIVCD = "trnrCtlJobDivCd";

    /** set 이관작업일련번호 : trnrCtlJobSeilNum */
    public static final String ATTR_TRNRCTLJOBSEILNUM = "trnrCtlJobSeilNum";

    /** set 이관작업일자 : trnrCtlJobDt */
    public static final String ATTR_TRNRCTLJOBDT = "trnrCtlJobDt";

    /** set 이관작업시작일시 : trnrCtlJobBgnnDtntm */
    public static final String ATTR_TRNRCTLJOBBGNNDTNTM = "trnrCtlJobBgnnDtntm";

    /** set 이관작업종료일시 : trnrCtlJobEndDtntm */
    public static final String ATTR_TRNRCTLJOBENDDTNTM = "trnrCtlJobEndDtntm";

    /** set 이관작업내용 : trnrCtlJobCtnt */
    public static final String ATTR_TRNRCTLJOBCTNT = "trnrCtlJobCtnt";

    /** set 이관작업완료여부 : trnrCtlJobCmpltnYn */
    public static final String ATTR_TRNRCTLJOBCMPLTNYN = "trnrCtlJobCmpltnYn";

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

    /** set 수정자주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** 생성자 */
     public Bass0600BM() { super(); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

    /** set 이관작업구분코드 : trnrCtlJobDivCd */
    public void setTrnrCtlJobDivCd(String trnrCtlJobDivCd) { set( ATTR_TRNRCTLJOBDIVCD ,trnrCtlJobDivCd);}
    /** get 이관작업구분코드 : trnrCtlJobDivCd */
    public String getTrnrCtlJobDivCd() { return (String)get( ATTR_TRNRCTLJOBDIVCD );}

    /** set 이관작업일련번호 : trnrCtlJobSeilNum */
    public void setTrnrCtlJobSeilNum(String trnrCtlJobSeilNum) { set( ATTR_TRNRCTLJOBSEILNUM ,trnrCtlJobSeilNum);}
    /** get 이관작업일련번호 : trnrCtlJobSeilNum */
    public String getTrnrCtlJobSeilNum() { return (String)get( ATTR_TRNRCTLJOBSEILNUM );}

    /** set 이관작업일자 : trnrCtlJobDt */
    public void setTrnrCtlJobDt(String trnrCtlJobDt) { set( ATTR_TRNRCTLJOBDT ,trnrCtlJobDt);}
    /** get 이관작업일자 : trnrCtlJobDt */
    public String getTrnrCtlJobDt() { return (String)get( ATTR_TRNRCTLJOBDT );}

    /** set 이관작업시작일시 : trnrCtlJobBgnnDtntm */
    public void setTrnrCtlJobBgnnDtntm(String trnrCtlJobBgnnDtntm) { set( ATTR_TRNRCTLJOBBGNNDTNTM ,trnrCtlJobBgnnDtntm);}
    /** get 이관작업시작일시 : trnrCtlJobBgnnDtntm */
    public String getTrnrCtlJobBgnnDtntm() { return (String)get( ATTR_TRNRCTLJOBBGNNDTNTM );}

    /** set 이관작업종료일시 : trnrCtlJobEndDtntm */
    public void setTrnrCtlJobEndDtntm(String trnrCtlJobEndDtntm) { set( ATTR_TRNRCTLJOBENDDTNTM ,trnrCtlJobEndDtntm);}
    /** get 이관작업종료일시 : trnrCtlJobEndDtntm */
    public String getTrnrCtlJobEndDtntm() { return (String)get( ATTR_TRNRCTLJOBENDDTNTM );}

    /** set 이관작업내용 : trnrCtlJobCtnt */
    public void setTrnrCtlJobCtnt(String trnrCtlJobCtnt) { set( ATTR_TRNRCTLJOBCTNT ,trnrCtlJobCtnt);}
    /** get 이관작업내용 : trnrCtlJobCtnt */
    public String getTrnrCtlJobCtnt() { return (String)get( ATTR_TRNRCTLJOBCTNT );}

    /** set 이관작업완료여부 : trnrCtlJobCmpltnYn */
    public void setTrnrCtlJobCmpltnYn(String trnrCtlJobCmpltnYn) { set( ATTR_TRNRCTLJOBCMPLTNYN ,trnrCtlJobCmpltnYn);}
    /** get 이관작업완료여부 : trnrCtlJobCmpltnYn */
    public String getTrnrCtlJobCmpltnYn() { return (String)get( ATTR_TRNRCTLJOBCMPLTNYN );}

    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get( ATTR_REVNDT );}

    /** set 수정자주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정자주소 : revnAddr */
    public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}



}
