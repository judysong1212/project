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
public class Bass2600BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 조기출근집계여부 : eryGtwkTotYn */
    public static final String ATTR_ERYGTWKTOTYN = "eryGtwkTotYn";

    /** set 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
    public static final String ATTR_DILNLAZDDUCPAYSUBTNYN = "dilnlazDducPaySubtnYn";

    /** set 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
    public static final String ATTR_WKLYHLDYEXTPYPRCSYN = "wklyHldyExtpyPrcsYn";

    /** set 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
    public static final String ATTR_WKDYNORTMCTTGDIVCD = "wkdyNorTmCttgDivCd";

    /** set 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
    public static final String ATTR_WKDYEXTNNCTTGDIVCD = "wkdyExtnnCttgDivCd";

    /** set 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
    public static final String ATTR_WKDYNGTCTTGDIVCD = "wkdyNgtCttgDivCd";

    /** set 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
    public static final String ATTR_PUBCHODYNORTMCTTGCD = "pubcHodyNorTmCttgCd";

    /** set 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
    public static final String ATTR_PUBCHODYEXTNNTMCTTGCD = "pubcHodyExtnnTmCttgCd";

    /** set 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
    public static final String ATTR_WKDYNORDUTYMRKDIVCD = "wkdyNorDutyMrkDivCd";

    /** set 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
    public static final String ATTR_WKDYEXTNNMRKDIVCD = "wkdyExtnnMrkDivCd";

    /** set 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
    public static final String ATTR_WKDYNGTMRKDIVCD = "wkdyNgtMrkDivCd";

    /** set 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
    public static final String ATTR_PUBCHODYNORMRKDIVCD = "pubcHodyNorMrkDivCd";

    /** set 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
    public static final String ATTR_PUBCHODYEXTNNMRKCD = "pubcHodyExtnnMrkCd";

    /** set 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
    public static final String ATTR_PUBCHODYNGTMRKDIVCD = "pubcHodyNgtMrkDivCd";

    /** set 복무공통설정일련번호 : servcCommSeilNum */
    public static final String ATTR_SERVCCOMMSEILNUM = "servcCommSeilNum";

    /** set 근로사업번호 : workBusinNum */
    public static final String ATTR_WORKBUSINNUM = "workBusinNum";

    /** set 근로사업_단위사업번호 : workUntBusinNum */
    public static final String ATTR_WORKUNTBUSINNUM = "workUntBusinNum";

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public static final String ATTR_MANGEUNTBUSINNUM = "mangeUntBusinNum";

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
     public Bass2600BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2600BM(
    		 String  dpobCd 
    		, String  stpInttnSeptVal 
    		, String  eryGtwkTotYn 
    		, String  dilnlazDducPaySubtnYn 
    		, String  wklyHldyExtpyPrcsYn 
    		, String  wkdyNorTmCttgDivCd 
    		, String  wkdyExtnnCttgDivCd 
    		, String  wkdyNgtCttgDivCd 
    		, String  pubcHodyNorTmCttgCd 
    		, String  pubcHodyExtnnTmCttgCd 
    		, String  wkdyNorDutyMrkDivCd 
    		, String  wkdyExtnnMrkDivCd 
    		, String  wkdyNgtMrkDivCd 
    		, String  pubcHodyNorMrkDivCd 
    		, String  pubcHodyExtnnMrkCd 
    		, String  pubcHodyNgtMrkDivCd 
    		, Long  servcCommSeilNum 
    		, String  workBusinNum 
    		, String  workUntBusinNum 
    		, String  mangeUntBusinNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_ERYGTWKTOTYN,eryGtwkTotYn);
     	values.put(ATTR_DILNLAZDDUCPAYSUBTNYN,dilnlazDducPaySubtnYn);
     	values.put(ATTR_WKLYHLDYEXTPYPRCSYN,wklyHldyExtpyPrcsYn);
     	values.put(ATTR_WKDYNORTMCTTGDIVCD,wkdyNorTmCttgDivCd);
     	values.put(ATTR_WKDYEXTNNCTTGDIVCD,wkdyExtnnCttgDivCd);
     	values.put(ATTR_WKDYNGTCTTGDIVCD,wkdyNgtCttgDivCd);
     	values.put(ATTR_PUBCHODYNORTMCTTGCD,pubcHodyNorTmCttgCd);
     	values.put(ATTR_PUBCHODYEXTNNTMCTTGCD,pubcHodyExtnnTmCttgCd);
     	values.put(ATTR_WKDYNORDUTYMRKDIVCD,wkdyNorDutyMrkDivCd);
     	values.put(ATTR_WKDYEXTNNMRKDIVCD,wkdyExtnnMrkDivCd);
     	values.put(ATTR_WKDYNGTMRKDIVCD,wkdyNgtMrkDivCd);
     	values.put(ATTR_PUBCHODYNORMRKDIVCD,pubcHodyNorMrkDivCd);
     	values.put(ATTR_PUBCHODYEXTNNMRKCD,pubcHodyExtnnMrkCd);
     	values.put(ATTR_PUBCHODYNGTMRKDIVCD,pubcHodyNgtMrkDivCd);
     	values.put(ATTR_SERVCCOMMSEILNUM,servcCommSeilNum);
     	values.put(ATTR_WORKBUSINNUM,workBusinNum);
     	values.put(ATTR_WORKUNTBUSINNUM,workUntBusinNum);
     	values.put(ATTR_MANGEUNTBUSINNUM,mangeUntBusinNum);
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

    /** set 조기출근집계여부 : eryGtwkTotYn */
    public void setEryGtwkTotYn(String  eryGtwkTotYn) { set( ATTR_ERYGTWKTOTYN ,eryGtwkTotYn);}
    /** get 조기출근집계여부 : eryGtwkTotYn */
    public String  getEryGtwkTotYn() { return (String )get( ATTR_ERYGTWKTOTYN );}

    /** set 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
    public void setDilnlazDducPaySubtnYn(String  dilnlazDducPaySubtnYn) { set( ATTR_DILNLAZDDUCPAYSUBTNYN ,dilnlazDducPaySubtnYn);}
    /** get 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
    public String  getDilnlazDducPaySubtnYn() { return (String )get( ATTR_DILNLAZDDUCPAYSUBTNYN );}

    /** set 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
    public void setWklyHldyExtpyPrcsYn(String  wklyHldyExtpyPrcsYn) { set( ATTR_WKLYHLDYEXTPYPRCSYN ,wklyHldyExtpyPrcsYn);}
    /** get 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
    public String  getWklyHldyExtpyPrcsYn() { return (String )get( ATTR_WKLYHLDYEXTPYPRCSYN );}

    /** set 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
    public void setWkdyNorTmCttgDivCd(String  wkdyNorTmCttgDivCd) { set( ATTR_WKDYNORTMCTTGDIVCD ,wkdyNorTmCttgDivCd);}
    /** get 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
    public String  getWkdyNorTmCttgDivCd() { return (String )get( ATTR_WKDYNORTMCTTGDIVCD );}

    /** set 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
    public void setWkdyExtnnCttgDivCd(String  wkdyExtnnCttgDivCd) { set( ATTR_WKDYEXTNNCTTGDIVCD ,wkdyExtnnCttgDivCd);}
    /** get 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
    public String  getWkdyExtnnCttgDivCd() { return (String )get( ATTR_WKDYEXTNNCTTGDIVCD );}

    /** set 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
    public void setWkdyNgtCttgDivCd(String  wkdyNgtCttgDivCd) { set( ATTR_WKDYNGTCTTGDIVCD ,wkdyNgtCttgDivCd);}
    /** get 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
    public String  getWkdyNgtCttgDivCd() { return (String )get( ATTR_WKDYNGTCTTGDIVCD );}

    /** set 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
    public void setPubcHodyNorTmCttgCd(String  pubcHodyNorTmCttgCd) { set( ATTR_PUBCHODYNORTMCTTGCD ,pubcHodyNorTmCttgCd);}
    /** get 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
    public String  getPubcHodyNorTmCttgCd() { return (String )get( ATTR_PUBCHODYNORTMCTTGCD );}

    /** set 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
    public void setPubcHodyExtnnTmCttgCd(String  pubcHodyExtnnTmCttgCd) { set( ATTR_PUBCHODYEXTNNTMCTTGCD ,pubcHodyExtnnTmCttgCd);}
    /** get 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
    public String  getPubcHodyExtnnTmCttgCd() { return (String )get( ATTR_PUBCHODYEXTNNTMCTTGCD );}

    /** set 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
    public void setWkdyNorDutyMrkDivCd(String  wkdyNorDutyMrkDivCd) { set( ATTR_WKDYNORDUTYMRKDIVCD ,wkdyNorDutyMrkDivCd);}
    /** get 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
    public String  getWkdyNorDutyMrkDivCd() { return (String )get( ATTR_WKDYNORDUTYMRKDIVCD );}

    /** set 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
    public void setWkdyExtnnMrkDivCd(String  wkdyExtnnMrkDivCd) { set( ATTR_WKDYEXTNNMRKDIVCD ,wkdyExtnnMrkDivCd);}
    /** get 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
    public String  getWkdyExtnnMrkDivCd() { return (String )get( ATTR_WKDYEXTNNMRKDIVCD );}

    /** set 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
    public void setWkdyNgtMrkDivCd(String  wkdyNgtMrkDivCd) { set( ATTR_WKDYNGTMRKDIVCD ,wkdyNgtMrkDivCd);}
    /** get 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
    public String  getWkdyNgtMrkDivCd() { return (String )get( ATTR_WKDYNGTMRKDIVCD );}

    /** set 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
    public void setPubcHodyNorMrkDivCd(String  pubcHodyNorMrkDivCd) { set( ATTR_PUBCHODYNORMRKDIVCD ,pubcHodyNorMrkDivCd);}
    /** get 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
    public String  getPubcHodyNorMrkDivCd() { return (String )get( ATTR_PUBCHODYNORMRKDIVCD );}

    /** set 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
    public void setPubcHodyExtnnMrkCd(String  pubcHodyExtnnMrkCd) { set( ATTR_PUBCHODYEXTNNMRKCD ,pubcHodyExtnnMrkCd);}
    /** get 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
    public String  getPubcHodyExtnnMrkCd() { return (String )get( ATTR_PUBCHODYEXTNNMRKCD );}

    /** set 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
    public void setPubcHodyNgtMrkDivCd(String  pubcHodyNgtMrkDivCd) { set( ATTR_PUBCHODYNGTMRKDIVCD ,pubcHodyNgtMrkDivCd);}
    /** get 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
    public String  getPubcHodyNgtMrkDivCd() { return (String )get( ATTR_PUBCHODYNGTMRKDIVCD );}

    /** set 복무공통설정일련번호 : servcCommSeilNum */
    public void setServcCommSeilNum(Long  servcCommSeilNum) { set( ATTR_SERVCCOMMSEILNUM ,servcCommSeilNum);}
    /** get 복무공통설정일련번호 : servcCommSeilNum */
    public Long  getServcCommSeilNum() { return (Long )get( ATTR_SERVCCOMMSEILNUM );}

    /** set 근로사업번호 : workBusinNum */
    public void setWorkBusinNum(String  workBusinNum) { set( ATTR_WORKBUSINNUM ,workBusinNum);}
    /** get 근로사업번호 : workBusinNum */
    public String  getWorkBusinNum() { return (String )get( ATTR_WORKBUSINNUM );}

    /** set 근로사업_단위사업번호 : workUntBusinNum */
    public void setWorkUntBusinNum(String  workUntBusinNum) { set( ATTR_WORKUNTBUSINNUM ,workUntBusinNum);}
    /** get 근로사업_단위사업번호 : workUntBusinNum */
    public String  getWorkUntBusinNum() { return (String )get( ATTR_WORKUNTBUSINNUM );}

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public void setMangeUntBusinNum(String  mangeUntBusinNum) { set( ATTR_MANGEUNTBUSINNUM ,mangeUntBusinNum);}
    /** get 관리부서_단위사업번호 : mangeUntBusinNum */
    public String  getMangeUntBusinNum() { return (String )get( ATTR_MANGEUNTBUSINNUM );}

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
