package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2630BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 근무구분코드 : dutyDivCd */
    public static final String ATTR_DUTYDIVCD = "dutyDivCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 월요일근무여부 : monDutyYn */
    public static final String ATTR_MONDUTYYN = "monDutyYn";

    /** set 화요일근무여부 : tueDutyYn */
    public static final String ATTR_TUEDUTYYN = "tueDutyYn";

    /** set 수요일근무여부 : wedDutyYn */
    public static final String ATTR_WEDDUTYYN = "wedDutyYn";

    /** set 목요일근무여부 : thurDutyYn */
    public static final String ATTR_THURDUTYYN = "thurDutyYn";

    /** set 금요일근무여부 : friDutyYn */
    public static final String ATTR_FRIDUTYYN = "friDutyYn";

    /** set 토요일근무여부 : satDutyYn */
    public static final String ATTR_SATDUTYYN = "satDutyYn";

    /** set 일요일근무여부 : sunDutyYn */
    public static final String ATTR_SUNDUTYYN = "sunDutyYn";

    /** set 정상근무휴일계산여부 : norPubcHodyCalcYn */
    public static final String ATTR_NORPUBCHODYCALCYN = "norPubcHodyCalcYn";

    /** set 복무근무요일일련번호 : servcDutyDotwSeilNum */
    public static final String ATTR_SERVCDUTYDOTWSEILNUM = "servcDutyDotwSeilNum";

    /** set 근로사업번호 : workBusinNum */
    public static final String ATTR_WORKBUSINNUM = "workBusinNum";

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public static final String ATTR_MANGEUNTBUSINNUM = "mangeUntBusinNum";

    /** set 근로사업_단위사업번호 : workUntBusinNum */
    public static final String ATTR_WORKUNTBUSINNUM = "workUntBusinNum";

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
     public Bass2630BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2630BM(
    		 String  dpobCd 
    		, String  dutyDivCd 
    		, String  stpInttnSeptVal 
    		, String  monDutyYn 
    		, String  tueDutyYn 
    		, String  wedDutyYn 
    		, String  thurDutyYn 
    		, String  friDutyYn 
    		, String  satDutyYn 
    		, String  sunDutyYn 
    		, String  norPubcHodyCalcYn 
    		, Long  servcDutyDotwSeilNum 
    		, String  workBusinNum 
    		, String  mangeUntBusinNum 
    		, String  workUntBusinNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DUTYDIVCD,dutyDivCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_MONDUTYYN,monDutyYn);
     	values.put(ATTR_TUEDUTYYN,tueDutyYn);
     	values.put(ATTR_WEDDUTYYN,wedDutyYn);
     	values.put(ATTR_THURDUTYYN,thurDutyYn);
     	values.put(ATTR_FRIDUTYYN,friDutyYn);
     	values.put(ATTR_SATDUTYYN,satDutyYn);
     	values.put(ATTR_SUNDUTYYN,sunDutyYn);
     	values.put(ATTR_NORPUBCHODYCALCYN,norPubcHodyCalcYn);
     	values.put(ATTR_SERVCDUTYDOTWSEILNUM,servcDutyDotwSeilNum);
     	values.put(ATTR_WORKBUSINNUM,workBusinNum);
     	values.put(ATTR_MANGEUNTBUSINNUM,mangeUntBusinNum);
     	values.put(ATTR_WORKUNTBUSINNUM,workUntBusinNum);
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

    /** set 근무구분코드 : dutyDivCd */
    public void setDutyDivCd(String  dutyDivCd) { set( ATTR_DUTYDIVCD ,dutyDivCd);}
    /** get 근무구분코드 : dutyDivCd */
    public String  getDutyDivCd() { return (String )get( ATTR_DUTYDIVCD );}

    /** set 설정통합구분값 : stpInttnSeptVal */
    public void setStpInttnSeptVal(String  stpInttnSeptVal) { set( ATTR_STPINTTNSEPTVAL ,stpInttnSeptVal);}
    /** get 설정통합구분값 : stpInttnSeptVal */
    public String  getStpInttnSeptVal() { return (String )get( ATTR_STPINTTNSEPTVAL );}

    /** set 월요일근무여부 : monDutyYn */
    public void setMonDutyYn(String  monDutyYn) { set( ATTR_MONDUTYYN ,monDutyYn);}
    /** get 월요일근무여부 : monDutyYn */
    public String  getMonDutyYn() { return (String )get( ATTR_MONDUTYYN );}

    /** set 화요일근무여부 : tueDutyYn */
    public void setTueDutyYn(String  tueDutyYn) { set( ATTR_TUEDUTYYN ,tueDutyYn);}
    /** get 화요일근무여부 : tueDutyYn */
    public String  getTueDutyYn() { return (String )get( ATTR_TUEDUTYYN );}

    /** set 수요일근무여부 : wedDutyYn */
    public void setWedDutyYn(String  wedDutyYn) { set( ATTR_WEDDUTYYN ,wedDutyYn);}
    /** get 수요일근무여부 : wedDutyYn */
    public String  getWedDutyYn() { return (String )get( ATTR_WEDDUTYYN );}

    /** set 목요일근무여부 : thurDutyYn */
    public void setThurDutyYn(String  thurDutyYn) { set( ATTR_THURDUTYYN ,thurDutyYn);}
    /** get 목요일근무여부 : thurDutyYn */
    public String  getThurDutyYn() { return (String )get( ATTR_THURDUTYYN );}

    /** set 금요일근무여부 : friDutyYn */
    public void setFriDutyYn(String  friDutyYn) { set( ATTR_FRIDUTYYN ,friDutyYn);}
    /** get 금요일근무여부 : friDutyYn */
    public String  getFriDutyYn() { return (String )get( ATTR_FRIDUTYYN );}

    /** set 토요일근무여부 : satDutyYn */
    public void setSatDutyYn(String  satDutyYn) { set( ATTR_SATDUTYYN ,satDutyYn);}
    /** get 토요일근무여부 : satDutyYn */
    public String  getSatDutyYn() { return (String )get( ATTR_SATDUTYYN );}

    /** set 일요일근무여부 : sunDutyYn */
    public void setSunDutyYn(String  sunDutyYn) { set( ATTR_SUNDUTYYN ,sunDutyYn);}
    /** get 일요일근무여부 : sunDutyYn */
    public String  getSunDutyYn() { return (String )get( ATTR_SUNDUTYYN );}

    /** set 정상근무휴일계산여부 : norPubcHodyCalcYn */
    public void setNorPubcHodyCalcYn(String  norPubcHodyCalcYn) { set( ATTR_NORPUBCHODYCALCYN ,norPubcHodyCalcYn);}
    /** get 정상근무휴일계산여부 : norPubcHodyCalcYn */
    public String  getNorPubcHodyCalcYn() { return (String )get( ATTR_NORPUBCHODYCALCYN );}

    /** set 복무근무요일일련번호 : servcDutyDotwSeilNum */
    public void setServcDutyDotwSeilNum(Long  servcDutyDotwSeilNum) { set( ATTR_SERVCDUTYDOTWSEILNUM ,servcDutyDotwSeilNum);}
    /** get 복무근무요일일련번호 : servcDutyDotwSeilNum */
    public Long  getServcDutyDotwSeilNum() { return (Long )get( ATTR_SERVCDUTYDOTWSEILNUM );}

    /** set 근로사업번호 : workBusinNum */
    public void setWorkBusinNum(String  workBusinNum) { set( ATTR_WORKBUSINNUM ,workBusinNum);}
    /** get 근로사업번호 : workBusinNum */
    public String  getWorkBusinNum() { return (String )get( ATTR_WORKBUSINNUM );}

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public void setMangeUntBusinNum(String  mangeUntBusinNum) { set( ATTR_MANGEUNTBUSINNUM ,mangeUntBusinNum);}
    /** get 관리부서_단위사업번호 : mangeUntBusinNum */
    public String  getMangeUntBusinNum() { return (String )get( ATTR_MANGEUNTBUSINNUM );}

    /** set 근로사업_단위사업번호 : workUntBusinNum */
    public void setWorkUntBusinNum(String  workUntBusinNum) { set( ATTR_WORKUNTBUSINNUM ,workUntBusinNum);}
    /** get 근로사업_단위사업번호 : workUntBusinNum */
    public String  getWorkUntBusinNum() { return (String )get( ATTR_WORKUNTBUSINNUM );}

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
