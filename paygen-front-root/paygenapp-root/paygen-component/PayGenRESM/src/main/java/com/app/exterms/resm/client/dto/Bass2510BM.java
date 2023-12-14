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
public class Bass2510BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 근무구분코드 : dutyDivCd */
    public static final String ATTR_DUTYDIVCD = "dutyDivCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 교대근무구분코드 : rotaDutyDivCd */
    public static final String ATTR_ROTADUTYDIVCD = "rotaDutyDivCd";

    /** set 교대근무시작시간 : rotaDutyBgnnTm */
    public static final String ATTR_ROTADUTYBGNNTM = "rotaDutyBgnnTm";

    /** set 교대근무종료시간 : rotaDutyEndTm */
    public static final String ATTR_ROTADUTYENDTM = "rotaDutyEndTm";

    /** set 교대근무시간수 : rotaDutyTmNum */
    public static final String ATTR_ROTADUTYTMNUM = "rotaDutyTmNum";

    /** set 교대근무제외시간수 : rotaDutyEepnTmNum */
    public static final String ATTR_ROTADUTYEEPNTMNUM = "rotaDutyEepnTmNum";

    /** set 교대연장근무시작시간 : extnnDutyBgnnTm */
    public static final String ATTR_EXTNNDUTYBGNNTM = "extnnDutyBgnnTm";

    /** set 교대연장근무종료시간 : extnnDutyEndTm */
    public static final String ATTR_EXTNNDUTYENDTM = "extnnDutyEndTm";

    /** set 교대연장제외시간수 : rotaExtnnEepnTmNum */
    public static final String ATTR_ROTAEXTNNEEPNTMNUM = "rotaExtnnEepnTmNum";

    /** set 교대야간근무시작시간 : ngtDutyBgnnTm */
    public static final String ATTR_NGTDUTYBGNNTM = "ngtDutyBgnnTm";

    /** set 교대야간근무종료시간 : ngtDutyEndTm */
    public static final String ATTR_NGTDUTYENDTM = "ngtDutyEndTm";

    /** set 교대야간근무제외시간수 : rotaNgtEepnTmNum */
    public static final String ATTR_ROTANGTEEPNTMNUM = "rotaNgtEepnTmNum";

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
     public Bass2510BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2510BM(
    		 String  dpobCd 
    		, String  dutyDivCd 
    		, String  stpInttnSeptVal 
    		, String  rotaDutyDivCd 
    		, String  rotaDutyBgnnTm 
    		, String  rotaDutyEndTm 
    		, Double  rotaDutyTmNum 
    		, Double  rotaDutyEepnTmNum 
    		, String  extnnDutyBgnnTm 
    		, String  extnnDutyEndTm 
    		, Double  rotaExtnnEepnTmNum 
    		, String  ngtDutyBgnnTm 
    		, String  ngtDutyEndTm 
    		, Double  rotaNgtEepnTmNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DUTYDIVCD,dutyDivCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_ROTADUTYDIVCD,rotaDutyDivCd);
     	values.put(ATTR_ROTADUTYBGNNTM,rotaDutyBgnnTm);
     	values.put(ATTR_ROTADUTYENDTM,rotaDutyEndTm);
     	values.put(ATTR_ROTADUTYTMNUM,rotaDutyTmNum);
     	values.put(ATTR_ROTADUTYEEPNTMNUM,rotaDutyEepnTmNum);
     	values.put(ATTR_EXTNNDUTYBGNNTM,extnnDutyBgnnTm);
     	values.put(ATTR_EXTNNDUTYENDTM,extnnDutyEndTm);
     	values.put(ATTR_ROTAEXTNNEEPNTMNUM,rotaExtnnEepnTmNum);
     	values.put(ATTR_NGTDUTYBGNNTM,ngtDutyBgnnTm);
     	values.put(ATTR_NGTDUTYENDTM,ngtDutyEndTm);
     	values.put(ATTR_ROTANGTEEPNTMNUM,rotaNgtEepnTmNum);
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

    /** set 교대근무구분코드 : rotaDutyDivCd */
    public void setRotaDutyDivCd(String  rotaDutyDivCd) { set( ATTR_ROTADUTYDIVCD ,rotaDutyDivCd);}
    /** get 교대근무구분코드 : rotaDutyDivCd */
    public String  getRotaDutyDivCd() { return (String )get( ATTR_ROTADUTYDIVCD );}

    /** set 교대근무시작시간 : rotaDutyBgnnTm */
    public void setRotaDutyBgnnTm(String  rotaDutyBgnnTm) { set( ATTR_ROTADUTYBGNNTM ,rotaDutyBgnnTm);}
    /** get 교대근무시작시간 : rotaDutyBgnnTm */
    public String  getRotaDutyBgnnTm() { return (String )get( ATTR_ROTADUTYBGNNTM );}

    /** set 교대근무종료시간 : rotaDutyEndTm */
    public void setRotaDutyEndTm(String  rotaDutyEndTm) { set( ATTR_ROTADUTYENDTM ,rotaDutyEndTm);}
    /** get 교대근무종료시간 : rotaDutyEndTm */
    public String  getRotaDutyEndTm() { return (String )get( ATTR_ROTADUTYENDTM );}

    /** set 교대근무시간수 : rotaDutyTmNum */
    public void setRotaDutyTmNum(Double  rotaDutyTmNum) { set( ATTR_ROTADUTYTMNUM ,rotaDutyTmNum);}
    /** get 교대근무시간수 : rotaDutyTmNum */
    public Double  getRotaDutyTmNum() { return (Double )get( ATTR_ROTADUTYTMNUM );}

    /** set 교대근무제외시간수 : rotaDutyEepnTmNum */
    public void setRotaDutyEepnTmNum(Double  rotaDutyEepnTmNum) { set( ATTR_ROTADUTYEEPNTMNUM ,rotaDutyEepnTmNum);}
    /** get 교대근무제외시간수 : rotaDutyEepnTmNum */
    public Double  getRotaDutyEepnTmNum() { return (Double )get( ATTR_ROTADUTYEEPNTMNUM );}

    /** set 교대연장근무시작시간 : extnnDutyBgnnTm */
    public void setExtnnDutyBgnnTm(String  extnnDutyBgnnTm) { set( ATTR_EXTNNDUTYBGNNTM ,extnnDutyBgnnTm);}
    /** get 교대연장근무시작시간 : extnnDutyBgnnTm */
    public String  getExtnnDutyBgnnTm() { return (String )get( ATTR_EXTNNDUTYBGNNTM );}

    /** set 교대연장근무종료시간 : extnnDutyEndTm */
    public void setExtnnDutyEndTm(String  extnnDutyEndTm) { set( ATTR_EXTNNDUTYENDTM ,extnnDutyEndTm);}
    /** get 교대연장근무종료시간 : extnnDutyEndTm */
    public String  getExtnnDutyEndTm() { return (String )get( ATTR_EXTNNDUTYENDTM );}

    /** set 교대연장제외시간수 : rotaExtnnEepnTmNum */
    public void setRotaExtnnEepnTmNum(Double  rotaExtnnEepnTmNum) { set( ATTR_ROTAEXTNNEEPNTMNUM ,rotaExtnnEepnTmNum);}
    /** get 교대연장제외시간수 : rotaExtnnEepnTmNum */
    public Double  getRotaExtnnEepnTmNum() { return (Double )get( ATTR_ROTAEXTNNEEPNTMNUM );}

    /** set 교대야간근무시작시간 : ngtDutyBgnnTm */
    public void setNgtDutyBgnnTm(String  ngtDutyBgnnTm) { set( ATTR_NGTDUTYBGNNTM ,ngtDutyBgnnTm);}
    /** get 교대야간근무시작시간 : ngtDutyBgnnTm */
    public String  getNgtDutyBgnnTm() { return (String )get( ATTR_NGTDUTYBGNNTM );}

    /** set 교대야간근무종료시간 : ngtDutyEndTm */
    public void setNgtDutyEndTm(String  ngtDutyEndTm) { set( ATTR_NGTDUTYENDTM ,ngtDutyEndTm);}
    /** get 교대야간근무종료시간 : ngtDutyEndTm */
    public String  getNgtDutyEndTm() { return (String )get( ATTR_NGTDUTYENDTM );}

    /** set 교대야간근무제외시간수 : rotaNgtEepnTmNum */
    public void setRotaNgtEepnTmNum(Double  rotaNgtEepnTmNum) { set( ATTR_ROTANGTEEPNTMNUM ,rotaNgtEepnTmNum);}
    /** get 교대야간근무제외시간수 : rotaNgtEepnTmNum */
    public Double  getRotaNgtEepnTmNum() { return (Double )get( ATTR_ROTANGTEEPNTMNUM );}

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
