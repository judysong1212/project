package com.app.smrmf.syscom.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : SysMstr050100VO.java
 * @Description : SysMstr050100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysMstr050100BM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 근태설정년도 : dilnlazOptYr */
    public static final String ATTR_DILNLAZOPTYR = "dilnlazOptYr";

    /** set 평일근무인정시간 : wkdyDutyRcgtnTm */
    public static final String ATTR_WKDYDUTYRCGTNTM = "wkdyDutyRcgtnTm";

    /** set 토요근무인정시간 : satDutyRcgtnTm */
    public static final String ATTR_SATDUTYRCGTNTM = "satDutyRcgtnTm";

    /** set 토요근무인정배수 : satDutyRcgtnMultpe */
    public static final String ATTR_SATDUTYRCGTNMULTPE = "satDutyRcgtnMultpe";

    /** set 휴일근무인정시간 : pubcHodyDutyRcgtnTm */
    public static final String ATTR_PUBCHODYDUTYRCGTNTM = "pubcHodyDutyRcgtnTm";

    /** set 휴일근무인정배수 : pubcHodyDutyRcgtnMultpe */
    public static final String ATTR_PUBCHODYDUTYRCGTNMULTPE = "pubcHodyDutyRcgtnMultpe";

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
     public SysMstr050100BM() { super(); } 

    /** 일괄등록 처리   */
     public SysMstr050100BM(
    		 String  dpobCd 
    		, String  dilnlazOptYr 
    		, String  wkdyDutyRcgtnTm 
    		, String  satDutyRcgtnTm 
    		, String  satDutyRcgtnMultpe 
    		, String  pubcHodyDutyRcgtnTm 
    		, String  pubcHodyDutyRcgtnMultpe 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DILNLAZOPTYR,dilnlazOptYr);
     	values.put(ATTR_WKDYDUTYRCGTNTM,wkdyDutyRcgtnTm);
     	values.put(ATTR_SATDUTYRCGTNTM,satDutyRcgtnTm);
     	values.put(ATTR_SATDUTYRCGTNMULTPE,satDutyRcgtnMultpe);
     	values.put(ATTR_PUBCHODYDUTYRCGTNTM,pubcHodyDutyRcgtnTm);
     	values.put(ATTR_PUBCHODYDUTYRCGTNMULTPE,pubcHodyDutyRcgtnMultpe);
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

    /** set 근태설정년도 : dilnlazOptYr */
    public void setDilnlazOptYr(String  dilnlazOptYr) { set( ATTR_DILNLAZOPTYR ,dilnlazOptYr);}
    /** get 근태설정년도 : dilnlazOptYr */
    public String  getDilnlazOptYr() { return (String )get( ATTR_DILNLAZOPTYR );}

    /** set 평일근무인정시간 : wkdyDutyRcgtnTm */
    public void setWkdyDutyRcgtnTm(String  wkdyDutyRcgtnTm) { set( ATTR_WKDYDUTYRCGTNTM ,wkdyDutyRcgtnTm);}
    /** get 평일근무인정시간 : wkdyDutyRcgtnTm */
    public String  getWkdyDutyRcgtnTm() { return (String )get( ATTR_WKDYDUTYRCGTNTM );}

    /** set 토요근무인정시간 : satDutyRcgtnTm */
    public void setSatDutyRcgtnTm(String  satDutyRcgtnTm) { set( ATTR_SATDUTYRCGTNTM ,satDutyRcgtnTm);}
    /** get 토요근무인정시간 : satDutyRcgtnTm */
    public String  getSatDutyRcgtnTm() { return (String )get( ATTR_SATDUTYRCGTNTM );}

    /** set 토요근무인정배수 : satDutyRcgtnMultpe */
    public void setSatDutyRcgtnMultpe(String  satDutyRcgtnMultpe) { set( ATTR_SATDUTYRCGTNMULTPE ,satDutyRcgtnMultpe);}
    /** get 토요근무인정배수 : satDutyRcgtnMultpe */
    public String  getSatDutyRcgtnMultpe() { return (String )get( ATTR_SATDUTYRCGTNMULTPE );}

    /** set 휴일근무인정시간 : pubcHodyDutyRcgtnTm */
    public void setPubcHodyDutyRcgtnTm(String  pubcHodyDutyRcgtnTm) { set( ATTR_PUBCHODYDUTYRCGTNTM ,pubcHodyDutyRcgtnTm);}
    /** get 휴일근무인정시간 : pubcHodyDutyRcgtnTm */
    public String  getPubcHodyDutyRcgtnTm() { return (String )get( ATTR_PUBCHODYDUTYRCGTNTM );}

    /** set 휴일근무인정배수 : pubcHodyDutyRcgtnMultpe */
    public void setPubcHodyDutyRcgtnMultpe(String  pubcHodyDutyRcgtnMultpe) { set( ATTR_PUBCHODYDUTYRCGTNMULTPE ,pubcHodyDutyRcgtnMultpe);}
    /** get 휴일근무인정배수 : pubcHodyDutyRcgtnMultpe */
    public String  getPubcHodyDutyRcgtnMultpe() { return (String )get( ATTR_PUBCHODYDUTYRCGTNMULTPE );}

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
