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
public class Bass2530BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 교대근무구분코드 : rotaDutyDivCd */
    public static final String ATTR_ROTADUTYDIVCD = "rotaDutyDivCd";

    /** set 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
    public static final String ATTR_WKDYNORDUTYEXTPYMGFTN = "wkdyNorDutyExtpyMgftn";

    /** set 평일정상근무수당금액 : wkdyNorDutyExtpySum */
    public static final String ATTR_WKDYNORDUTYEXTPYSUM = "wkdyNorDutyExtpySum";

    /** set 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
    public static final String ATTR_WKDYEXTNNEXTPYMGFTN = "wkdyExtnnExtpyMgftn";

    /** set 평일연장근무수당금액 : wkdyExtnnExtpySum */
    public static final String ATTR_WKDYEXTNNEXTPYSUM = "wkdyExtnnExtpySum";

    /** set 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
    public static final String ATTR_WKDYNGTEXTPYMGFTN = "wkdyNgtExtpyMgftn";

    /** set 평일야간근무수당금액 : wkdyNgtExtpySum */
    public static final String ATTR_WKDYNGTEXTPYSUM = "wkdyNgtExtpySum";

    /** set 휴일정상근무배율 : pubcHodyNorDutyMgftn */
    public static final String ATTR_PUBCHODYNORDUTYMGFTN = "pubcHodyNorDutyMgftn";

    /** set 휴일정상근무금액 : pubcHodyNorDutySum */
    public static final String ATTR_PUBCHODYNORDUTYSUM = "pubcHodyNorDutySum";

    /** set 휴일연장근무배율 : pubcHodyExtnnMgftn */
    public static final String ATTR_PUBCHODYEXTNNMGFTN = "pubcHodyExtnnMgftn";

    /** set 휴일연장근무금액 : pubcHodyExtnnSum */
    public static final String ATTR_PUBCHODYEXTNNSUM = "pubcHodyExtnnSum";

    /** set 휴일근무급여수당분리적용여부 : pubcHodyPaySprnApptnYn */
    public static final String ATTR_PUBCHODYPAYSPRNAPPTNYN = "pubcHodyPaySprnApptnYn";

    /** set 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
    public static final String ATTR_PAYDUTYTMCALCSEILNUM = "payDutyTmCalcSeilNum";

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
     public Bass2530BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2530BM(
    		 String  dpobCd 
    		, String  stpInttnSeptVal 
    		, String  rotaDutyDivCd 
    		, Double  wkdyNorDutyExtpyMgftn 
    		, Double  wkdyNorDutyExtpySum 
    		, Double  wkdyExtnnExtpyMgftn 
    		, Double  wkdyExtnnExtpySum 
    		, Double  wkdyNgtExtpyMgftn 
    		, Double  wkdyNgtExtpySum 
    		, Double  pubcHodyNorDutyMgftn 
    		, Double  pubcHodyNorDutySum 
    		, Double  pubcHodyExtnnMgftn 
    		, Double  pubcHodyExtnnSum 
    		, String  pubcHodyPaySprnApptnYn 
    		, Long  payDutyTmCalcSeilNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_ROTADUTYDIVCD,rotaDutyDivCd);
     	values.put(ATTR_WKDYNORDUTYEXTPYMGFTN,wkdyNorDutyExtpyMgftn);
     	values.put(ATTR_WKDYNORDUTYEXTPYSUM,wkdyNorDutyExtpySum);
     	values.put(ATTR_WKDYEXTNNEXTPYMGFTN,wkdyExtnnExtpyMgftn);
     	values.put(ATTR_WKDYEXTNNEXTPYSUM,wkdyExtnnExtpySum);
     	values.put(ATTR_WKDYNGTEXTPYMGFTN,wkdyNgtExtpyMgftn);
     	values.put(ATTR_WKDYNGTEXTPYSUM,wkdyNgtExtpySum);
     	values.put(ATTR_PUBCHODYNORDUTYMGFTN,pubcHodyNorDutyMgftn);
     	values.put(ATTR_PUBCHODYNORDUTYSUM,pubcHodyNorDutySum);
     	values.put(ATTR_PUBCHODYEXTNNMGFTN,pubcHodyExtnnMgftn);
     	values.put(ATTR_PUBCHODYEXTNNSUM,pubcHodyExtnnSum);
     	values.put(ATTR_PUBCHODYPAYSPRNAPPTNYN,pubcHodyPaySprnApptnYn);
     	values.put(ATTR_PAYDUTYTMCALCSEILNUM,payDutyTmCalcSeilNum);
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

    /** set 설정통합구분값 : stpInttnSeptVal */
    public void setStpInttnSeptVal(String  stpInttnSeptVal) { set( ATTR_STPINTTNSEPTVAL ,stpInttnSeptVal);}
    /** get 설정통합구분값 : stpInttnSeptVal */
    public String  getStpInttnSeptVal() { return (String )get( ATTR_STPINTTNSEPTVAL );}

    /** set 교대근무구분코드 : rotaDutyDivCd */
    public void setRotaDutyDivCd(String  rotaDutyDivCd) { set( ATTR_ROTADUTYDIVCD ,rotaDutyDivCd);}
    /** get 교대근무구분코드 : rotaDutyDivCd */
    public String  getRotaDutyDivCd() { return (String )get( ATTR_ROTADUTYDIVCD );}

    /** set 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
    public void setWkdyNorDutyExtpyMgftn(Double  wkdyNorDutyExtpyMgftn) { set( ATTR_WKDYNORDUTYEXTPYMGFTN ,wkdyNorDutyExtpyMgftn);}
    /** get 평일정상근무수당배율 : wkdyNorDutyExtpyMgftn */
    public Double  getWkdyNorDutyExtpyMgftn() { return (Double )get( ATTR_WKDYNORDUTYEXTPYMGFTN );}

    /** set 평일정상근무수당금액 : wkdyNorDutyExtpySum */
    public void setWkdyNorDutyExtpySum(Double  wkdyNorDutyExtpySum) { set( ATTR_WKDYNORDUTYEXTPYSUM ,wkdyNorDutyExtpySum);}
    /** get 평일정상근무수당금액 : wkdyNorDutyExtpySum */
    public Double  getWkdyNorDutyExtpySum() { return (Double )get( ATTR_WKDYNORDUTYEXTPYSUM );}

    /** set 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
    public void setWkdyExtnnExtpyMgftn(Double  wkdyExtnnExtpyMgftn) { set( ATTR_WKDYEXTNNEXTPYMGFTN ,wkdyExtnnExtpyMgftn);}
    /** get 평일연장근무수당배율 : wkdyExtnnExtpyMgftn */
    public Double  getWkdyExtnnExtpyMgftn() { return (Double )get( ATTR_WKDYEXTNNEXTPYMGFTN );}

    /** set 평일연장근무수당금액 : wkdyExtnnExtpySum */
    public void setWkdyExtnnExtpySum(Double  wkdyExtnnExtpySum) { set( ATTR_WKDYEXTNNEXTPYSUM ,wkdyExtnnExtpySum);}
    /** get 평일연장근무수당금액 : wkdyExtnnExtpySum */
    public Double  getWkdyExtnnExtpySum() { return (Double )get( ATTR_WKDYEXTNNEXTPYSUM );}

    /** set 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
    public void setWkdyNgtExtpyMgftn(Double  wkdyNgtExtpyMgftn) { set( ATTR_WKDYNGTEXTPYMGFTN ,wkdyNgtExtpyMgftn);}
    /** get 평일야간근무수당배율 : wkdyNgtExtpyMgftn */
    public Double  getWkdyNgtExtpyMgftn() { return (Double )get( ATTR_WKDYNGTEXTPYMGFTN );}

    /** set 평일야간근무수당금액 : wkdyNgtExtpySum */
    public void setWkdyNgtExtpySum(Double  wkdyNgtExtpySum) { set( ATTR_WKDYNGTEXTPYSUM ,wkdyNgtExtpySum);}
    /** get 평일야간근무수당금액 : wkdyNgtExtpySum */
    public Double  getWkdyNgtExtpySum() { return (Double )get( ATTR_WKDYNGTEXTPYSUM );}

    /** set 휴일정상근무배율 : pubcHodyNorDutyMgftn */
    public void setPubcHodyNorDutyMgftn(Double  pubcHodyNorDutyMgftn) { set( ATTR_PUBCHODYNORDUTYMGFTN ,pubcHodyNorDutyMgftn);}
    /** get 휴일정상근무배율 : pubcHodyNorDutyMgftn */
    public Double  getPubcHodyNorDutyMgftn() { return (Double )get( ATTR_PUBCHODYNORDUTYMGFTN );}

    /** set 휴일정상근무금액 : pubcHodyNorDutySum */
    public void setPubcHodyNorDutySum(Double  pubcHodyNorDutySum) { set( ATTR_PUBCHODYNORDUTYSUM ,pubcHodyNorDutySum);}
    /** get 휴일정상근무금액 : pubcHodyNorDutySum */
    public Double  getPubcHodyNorDutySum() { return (Double )get( ATTR_PUBCHODYNORDUTYSUM );}

    /** set 휴일연장근무배율 : pubcHodyExtnnMgftn */
    public void setPubcHodyExtnnMgftn(Double  pubcHodyExtnnMgftn) { set( ATTR_PUBCHODYEXTNNMGFTN ,pubcHodyExtnnMgftn);}
    /** get 휴일연장근무배율 : pubcHodyExtnnMgftn */
    public Double  getPubcHodyExtnnMgftn() { return (Double )get( ATTR_PUBCHODYEXTNNMGFTN );}

    /** set 휴일연장근무금액 : pubcHodyExtnnSum */
    public void setPubcHodyExtnnSum(Double  pubcHodyExtnnSum) { set( ATTR_PUBCHODYEXTNNSUM ,pubcHodyExtnnSum);}
    /** get 휴일연장근무금액 : pubcHodyExtnnSum */
    public Double  getPubcHodyExtnnSum() { return (Double )get( ATTR_PUBCHODYEXTNNSUM );}

    /** set 휴일근무급여수당분리적용여부 : pubcHodyPaySprnApptnYn */
    public void setPubcHodyPaySprnApptnYn(String  pubcHodyPaySprnApptnYn) { set( ATTR_PUBCHODYPAYSPRNAPPTNYN ,pubcHodyPaySprnApptnYn);}
    /** get 휴일근무급여수당분리적용여부 : pubcHodyPaySprnApptnYn */
    public String  getPubcHodyPaySprnApptnYn() { return (String )get( ATTR_PUBCHODYPAYSPRNAPPTNYN );}

    /** set 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
    public void setPayDutyTmCalcSeilNum(Long  payDutyTmCalcSeilNum) { set( ATTR_PAYDUTYTMCALCSEILNUM ,payDutyTmCalcSeilNum);}
    /** get 급여근무시간계산일련번호 : payDutyTmCalcSeilNum */
    public Long  getPayDutyTmCalcSeilNum() { return (Long )get( ATTR_PAYDUTYTMCALCSEILNUM );}

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