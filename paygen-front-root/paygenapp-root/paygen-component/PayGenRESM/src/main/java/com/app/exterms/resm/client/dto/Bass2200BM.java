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
public class Bass2200BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 근무구분코드 : dutyDivCd */
    public static final String ATTR_DUTYDIVCD = "dutyDivCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 출근기준시간 : gtwkStdTm */
    public static final String ATTR_GTWKSTDTM = "gtwkStdTm";

    /** set 퇴근기준시간 : ofwkStdTm */
    public static final String ATTR_OFWKSTDTM = "ofwkStdTm";

    /** set 조기출근시작시간 : eryGtwkBgnnTm */
    public static final String ATTR_ERYGTWKBGNNTM = "eryGtwkBgnnTm";

    /** set 조기출근종료시간 : eryGtwkEndTm */
    public static final String ATTR_ERYGTWKENDTM = "eryGtwkEndTm";

    /** set 정상오전근무시작시간 : norMogDutyBgnnTm */
    public static final String ATTR_NORMOGDUTYBGNNTM = "norMogDutyBgnnTm";

    /** set 정상오전근무종료시간 : norMogDutyEndTm */
    public static final String ATTR_NORMOGDUTYENDTM = "norMogDutyEndTm";

    /** set 정상근무점심시작시간 : norDutyLuchBgnnTm */
    public static final String ATTR_NORDUTYLUCHBGNNTM = "norDutyLuchBgnnTm";

    /** set 정상근무점심종료시간 : norDutyLuchEndTm */
    public static final String ATTR_NORDUTYLUCHENDTM = "norDutyLuchEndTm";

    /** set 정상근무오후시작시간 : norDutyAftnBgnnTm */
    public static final String ATTR_NORDUTYAFTNBGNNTM = "norDutyAftnBgnnTm";

    /** set 정상근무오후종료시간 : norDutyAftnEndTm */
    public static final String ATTR_NORDUTYAFTNENDTM = "norDutyAftnEndTm";

    /** set 정상근무시간수 : norDutyTmNum */
    public static final String ATTR_NORDUTYTMNUM = "norDutyTmNum";

    /** set 연장저녁시작시간 : extnnEvngBgnnTm */
    public static final String ATTR_EXTNNEVNGBGNNTM = "extnnEvngBgnnTm";

    /** set 연장저녁종료시간 : extnnEvngEndTm */
    public static final String ATTR_EXTNNEVNGENDTM = "extnnEvngEndTm";

    /** set 연장근무시작시간 : extnnDutyBgnnTm */
    public static final String ATTR_EXTNNDUTYBGNNTM = "extnnDutyBgnnTm";

    /** set 연장근무종료시간 : extnnDutyEndTm */
    public static final String ATTR_EXTNNDUTYENDTM = "extnnDutyEndTm";

    /** set 연장저녁식사포함여부 : extnnEvngMealInsnYn */
    public static final String ATTR_EXTNNEVNGMEALINSNYN = "extnnEvngMealInsnYn";

    /** set 야간근무시작시간 : ngtDutyBgnnTm */
    public static final String ATTR_NGTDUTYBGNNTM = "ngtDutyBgnnTm";

    /** set 야간근무종료시간 : ngtDutyEndTm */
    public static final String ATTR_NGTDUTYENDTM = "ngtDutyEndTm";

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
     public Bass2200BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2200BM(
    		 String  dpobCd 
    		, String  dutyDivCd 
    		, String  stpInttnSeptVal 
    		, String  gtwkStdTm 
    		, String  ofwkStdTm 
    		, String  eryGtwkBgnnTm 
    		, String  eryGtwkEndTm 
    		, String  norMogDutyBgnnTm 
    		, String  norMogDutyEndTm 
    		, String  norDutyLuchBgnnTm 
    		, String  norDutyLuchEndTm 
    		, String  norDutyAftnBgnnTm 
    		, String  norDutyAftnEndTm 
    		, Long  norDutyTmNum 
    		, String  extnnEvngBgnnTm 
    		, String  extnnEvngEndTm 
    		, String  extnnDutyBgnnTm 
    		, String  extnnDutyEndTm 
    		, String  extnnEvngMealInsnYn 
    		, String  ngtDutyBgnnTm 
    		, String  ngtDutyEndTm 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DUTYDIVCD,dutyDivCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_GTWKSTDTM,gtwkStdTm);
     	values.put(ATTR_OFWKSTDTM,ofwkStdTm);
     	values.put(ATTR_ERYGTWKBGNNTM,eryGtwkBgnnTm);
     	values.put(ATTR_ERYGTWKENDTM,eryGtwkEndTm);
     	values.put(ATTR_NORMOGDUTYBGNNTM,norMogDutyBgnnTm);
     	values.put(ATTR_NORMOGDUTYENDTM,norMogDutyEndTm);
     	values.put(ATTR_NORDUTYLUCHBGNNTM,norDutyLuchBgnnTm);
     	values.put(ATTR_NORDUTYLUCHENDTM,norDutyLuchEndTm);
     	values.put(ATTR_NORDUTYAFTNBGNNTM,norDutyAftnBgnnTm);
     	values.put(ATTR_NORDUTYAFTNENDTM,norDutyAftnEndTm);
     	values.put(ATTR_NORDUTYTMNUM,norDutyTmNum);
     	values.put(ATTR_EXTNNEVNGBGNNTM,extnnEvngBgnnTm);
     	values.put(ATTR_EXTNNEVNGENDTM,extnnEvngEndTm);
     	values.put(ATTR_EXTNNDUTYBGNNTM,extnnDutyBgnnTm);
     	values.put(ATTR_EXTNNDUTYENDTM,extnnDutyEndTm);
     	values.put(ATTR_EXTNNEVNGMEALINSNYN,extnnEvngMealInsnYn);
     	values.put(ATTR_NGTDUTYBGNNTM,ngtDutyBgnnTm);
     	values.put(ATTR_NGTDUTYENDTM,ngtDutyEndTm);
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

    /** set 출근기준시간 : gtwkStdTm */
    public void setGtwkStdTm(String  gtwkStdTm) { set( ATTR_GTWKSTDTM ,gtwkStdTm);}
    /** get 출근기준시간 : gtwkStdTm */
    public String  getGtwkStdTm() { return (String )get( ATTR_GTWKSTDTM );}

    /** set 퇴근기준시간 : ofwkStdTm */
    public void setOfwkStdTm(String  ofwkStdTm) { set( ATTR_OFWKSTDTM ,ofwkStdTm);}
    /** get 퇴근기준시간 : ofwkStdTm */
    public String  getOfwkStdTm() { return (String )get( ATTR_OFWKSTDTM );}

    /** set 조기출근시작시간 : eryGtwkBgnnTm */
    public void setEryGtwkBgnnTm(String  eryGtwkBgnnTm) { set( ATTR_ERYGTWKBGNNTM ,eryGtwkBgnnTm);}
    /** get 조기출근시작시간 : eryGtwkBgnnTm */
    public String  getEryGtwkBgnnTm() { return (String )get( ATTR_ERYGTWKBGNNTM );}

    /** set 조기출근종료시간 : eryGtwkEndTm */
    public void setEryGtwkEndTm(String  eryGtwkEndTm) { set( ATTR_ERYGTWKENDTM ,eryGtwkEndTm);}
    /** get 조기출근종료시간 : eryGtwkEndTm */
    public String  getEryGtwkEndTm() { return (String )get( ATTR_ERYGTWKENDTM );}

    /** set 정상오전근무시작시간 : norMogDutyBgnnTm */
    public void setNorMogDutyBgnnTm(String  norMogDutyBgnnTm) { set( ATTR_NORMOGDUTYBGNNTM ,norMogDutyBgnnTm);}
    /** get 정상오전근무시작시간 : norMogDutyBgnnTm */
    public String  getNorMogDutyBgnnTm() { return (String )get( ATTR_NORMOGDUTYBGNNTM );}

    /** set 정상오전근무종료시간 : norMogDutyEndTm */
    public void setNorMogDutyEndTm(String  norMogDutyEndTm) { set( ATTR_NORMOGDUTYENDTM ,norMogDutyEndTm);}
    /** get 정상오전근무종료시간 : norMogDutyEndTm */
    public String  getNorMogDutyEndTm() { return (String )get( ATTR_NORMOGDUTYENDTM );}

    /** set 정상근무점심시작시간 : norDutyLuchBgnnTm */
    public void setNorDutyLuchBgnnTm(String  norDutyLuchBgnnTm) { set( ATTR_NORDUTYLUCHBGNNTM ,norDutyLuchBgnnTm);}
    /** get 정상근무점심시작시간 : norDutyLuchBgnnTm */
    public String  getNorDutyLuchBgnnTm() { return (String )get( ATTR_NORDUTYLUCHBGNNTM );}

    /** set 정상근무점심종료시간 : norDutyLuchEndTm */
    public void setNorDutyLuchEndTm(String  norDutyLuchEndTm) { set( ATTR_NORDUTYLUCHENDTM ,norDutyLuchEndTm);}
    /** get 정상근무점심종료시간 : norDutyLuchEndTm */
    public String  getNorDutyLuchEndTm() { return (String )get( ATTR_NORDUTYLUCHENDTM );}

    /** set 정상근무오후시작시간 : norDutyAftnBgnnTm */
    public void setNorDutyAftnBgnnTm(String  norDutyAftnBgnnTm) { set( ATTR_NORDUTYAFTNBGNNTM ,norDutyAftnBgnnTm);}
    /** get 정상근무오후시작시간 : norDutyAftnBgnnTm */
    public String  getNorDutyAftnBgnnTm() { return (String )get( ATTR_NORDUTYAFTNBGNNTM );}

    /** set 정상근무오후종료시간 : norDutyAftnEndTm */
    public void setNorDutyAftnEndTm(String  norDutyAftnEndTm) { set( ATTR_NORDUTYAFTNENDTM ,norDutyAftnEndTm);}
    /** get 정상근무오후종료시간 : norDutyAftnEndTm */
    public String  getNorDutyAftnEndTm() { return (String )get( ATTR_NORDUTYAFTNENDTM );}

    /** set 정상근무시간수 : norDutyTmNum */
    public void setNorDutyTmNum(Long  norDutyTmNum) { set( ATTR_NORDUTYTMNUM ,norDutyTmNum);}
    /** get 정상근무시간수 : norDutyTmNum */
    public Long  getNorDutyTmNum() { return (Long )get( ATTR_NORDUTYTMNUM );}

    /** set 연장저녁시작시간 : extnnEvngBgnnTm */
    public void setExtnnEvngBgnnTm(String  extnnEvngBgnnTm) { set( ATTR_EXTNNEVNGBGNNTM ,extnnEvngBgnnTm);}
    /** get 연장저녁시작시간 : extnnEvngBgnnTm */
    public String  getExtnnEvngBgnnTm() { return (String )get( ATTR_EXTNNEVNGBGNNTM );}

    /** set 연장저녁종료시간 : extnnEvngEndTm */
    public void setExtnnEvngEndTm(String  extnnEvngEndTm) { set( ATTR_EXTNNEVNGENDTM ,extnnEvngEndTm);}
    /** get 연장저녁종료시간 : extnnEvngEndTm */
    public String  getExtnnEvngEndTm() { return (String )get( ATTR_EXTNNEVNGENDTM );}

    /** set 연장근무시작시간 : extnnDutyBgnnTm */
    public void setExtnnDutyBgnnTm(String  extnnDutyBgnnTm) { set( ATTR_EXTNNDUTYBGNNTM ,extnnDutyBgnnTm);}
    /** get 연장근무시작시간 : extnnDutyBgnnTm */
    public String  getExtnnDutyBgnnTm() { return (String )get( ATTR_EXTNNDUTYBGNNTM );}

    /** set 연장근무종료시간 : extnnDutyEndTm */
    public void setExtnnDutyEndTm(String  extnnDutyEndTm) { set( ATTR_EXTNNDUTYENDTM ,extnnDutyEndTm);}
    /** get 연장근무종료시간 : extnnDutyEndTm */
    public String  getExtnnDutyEndTm() { return (String )get( ATTR_EXTNNDUTYENDTM );}

    /** set 연장저녁식사포함여부 : extnnEvngMealInsnYn */
    public void setExtnnEvngMealInsnYn(String  extnnEvngMealInsnYn) { set( ATTR_EXTNNEVNGMEALINSNYN ,extnnEvngMealInsnYn);}
    /** get 연장저녁식사포함여부 : extnnEvngMealInsnYn */
    public String  getExtnnEvngMealInsnYn() { return (String )get( ATTR_EXTNNEVNGMEALINSNYN );}

    /** set 야간근무시작시간 : ngtDutyBgnnTm */
    public void setNgtDutyBgnnTm(String  ngtDutyBgnnTm) { set( ATTR_NGTDUTYBGNNTM ,ngtDutyBgnnTm);}
    /** get 야간근무시작시간 : ngtDutyBgnnTm */
    public String  getNgtDutyBgnnTm() { return (String )get( ATTR_NGTDUTYBGNNTM );}

    /** set 야간근무종료시간 : ngtDutyEndTm */
    public void setNgtDutyEndTm(String  ngtDutyEndTm) { set( ATTR_NGTDUTYENDTM ,ngtDutyEndTm);}
    /** get 야간근무종료시간 : ngtDutyEndTm */
    public String  getNgtDutyEndTm() { return (String )get( ATTR_NGTDUTYENDTM );}

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
