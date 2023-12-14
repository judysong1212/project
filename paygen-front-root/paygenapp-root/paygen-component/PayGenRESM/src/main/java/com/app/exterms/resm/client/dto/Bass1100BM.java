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
public class Bass1100BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 설정통합구분값 : stpInttnSeptVal */
    public static final String ATTR_STPINTTNSEPTVAL = "stpInttnSeptVal";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 평일정상근무시간수 : wkdyNorDutyTmNum */
    public static final String ATTR_WKDYNORDUTYTMNUM = "wkdyNorDutyTmNum";

    /** set 평일근무주근무시간수 : wkdyMnDutyTmNum */
    public static final String ATTR_WKDYMNDUTYTMNUM = "wkdyMnDutyTmNum";

    /** set 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
    public static final String ATTR_WKDYMNTHSTDTMNUM = "wkdyMnthStdTmNum";

    /** set 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
    public static final String ATTR_WKDYEXTNNBUDTMNUM = "wkdyExtnnBudTmNum";

    /** set 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
    public static final String ATTR_PUBCHODYNORDUTYTMNUM = "pubcHodyNorDutyTmNum";

    /** set 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
    public static final String ATTR_PUBCHODYDAYSTDTMNUM = "pubcHodyDayStdTmNum";

    /** set 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
    public static final String ATTR_PUBCHODYMNTHBUDNUMDYS = "pubcHodyMnthBudNumDys";

    /** set 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
    public static final String ATTR_PUBCHODYMNTHBUDTMNUM = "pubcHodyMnthBudTmNum";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set null : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
    public static final String ATTR_SERVCDUTYTMSTPSEILNUM = "servcDutyTmStpSeilNum";

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
     public Bass1100BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass1100BM(
    		 String  dpobCd 
    		, String  stpInttnSeptVal 
    		, String  emymtDivCd 
    		, Double  wkdyNorDutyTmNum 
    		, Double  wkdyMnDutyTmNum 
    		, Double  wkdyMnthStdTmNum 
    		, Double  wkdyExtnnBudTmNum 
    		, Double  pubcHodyNorDutyTmNum 
    		, Double  pubcHodyDayStdTmNum 
    		, Double  pubcHodyMnthBudNumDys 
    		, Double  pubcHodyMnthBudTmNum 
    		, String  businCd 
    		, String  deptCd 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, Long  servcDutyTmStpSeilNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_STPINTTNSEPTVAL,stpInttnSeptVal);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_WKDYNORDUTYTMNUM,wkdyNorDutyTmNum);
     	values.put(ATTR_WKDYMNDUTYTMNUM,wkdyMnDutyTmNum);
     	values.put(ATTR_WKDYMNTHSTDTMNUM,wkdyMnthStdTmNum);
     	values.put(ATTR_WKDYEXTNNBUDTMNUM,wkdyExtnnBudTmNum);
     	values.put(ATTR_PUBCHODYNORDUTYTMNUM,pubcHodyNorDutyTmNum);
     	values.put(ATTR_PUBCHODYDAYSTDTMNUM,pubcHodyDayStdTmNum);
     	values.put(ATTR_PUBCHODYMNTHBUDNUMDYS,pubcHodyMnthBudNumDys);
     	values.put(ATTR_PUBCHODYMNTHBUDTMNUM,pubcHodyMnthBudTmNum);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_SERVCDUTYTMSTPSEILNUM,servcDutyTmStpSeilNum);
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

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 평일정상근무시간수 : wkdyNorDutyTmNum */
    public void setWkdyNorDutyTmNum(Double  wkdyNorDutyTmNum) { set( ATTR_WKDYNORDUTYTMNUM ,wkdyNorDutyTmNum);}
    /** get 평일정상근무시간수 : wkdyNorDutyTmNum */
    public Double  getWkdyNorDutyTmNum() { return (Double )get( ATTR_WKDYNORDUTYTMNUM );}

    /** set 평일근무주근무시간수 : wkdyMnDutyTmNum */
    public void setWkdyMnDutyTmNum(Double  wkdyMnDutyTmNum) { set( ATTR_WKDYMNDUTYTMNUM ,wkdyMnDutyTmNum);}
    /** get 평일근무주근무시간수 : wkdyMnDutyTmNum */
    public Double  getWkdyMnDutyTmNum() { return (Double )get( ATTR_WKDYMNDUTYTMNUM );}

    /** set 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
    public void setWkdyMnthStdTmNum(Double  wkdyMnthStdTmNum) { set( ATTR_WKDYMNTHSTDTMNUM ,wkdyMnthStdTmNum);}
    /** get 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
    public Double  getWkdyMnthStdTmNum() { return (Double )get( ATTR_WKDYMNTHSTDTMNUM );}

    /** set 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
    public void setWkdyExtnnBudTmNum(Double  wkdyExtnnBudTmNum) { set( ATTR_WKDYEXTNNBUDTMNUM ,wkdyExtnnBudTmNum);}
    /** get 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
    public Double  getWkdyExtnnBudTmNum() { return (Double )get( ATTR_WKDYEXTNNBUDTMNUM );}

    /** set 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
    public void setPubcHodyNorDutyTmNum(Double  pubcHodyNorDutyTmNum) { set( ATTR_PUBCHODYNORDUTYTMNUM ,pubcHodyNorDutyTmNum);}
    /** get 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
    public Double  getPubcHodyNorDutyTmNum() { return (Double )get( ATTR_PUBCHODYNORDUTYTMNUM );}

    /** set 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
    public void setPubcHodyDayStdTmNum(Double  pubcHodyDayStdTmNum) { set( ATTR_PUBCHODYDAYSTDTMNUM ,pubcHodyDayStdTmNum);}
    /** get 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
    public Double  getPubcHodyDayStdTmNum() { return (Double )get( ATTR_PUBCHODYDAYSTDTMNUM );}

    /** set 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
    public void setPubcHodyMnthBudNumDys(Double  pubcHodyMnthBudNumDys) { set( ATTR_PUBCHODYMNTHBUDNUMDYS ,pubcHodyMnthBudNumDys);}
    /** get 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
    public Double  getPubcHodyMnthBudNumDys() { return (Double )get( ATTR_PUBCHODYMNTHBUDNUMDYS );}

    /** set 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
    public void setPubcHodyMnthBudTmNum(Double  pubcHodyMnthBudTmNum) { set( ATTR_PUBCHODYMNTHBUDTMNUM ,pubcHodyMnthBudTmNum);}
    /** get 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
    public Double  getPubcHodyMnthBudTmNum() { return (Double )get( ATTR_PUBCHODYMNTHBUDTMNUM );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set null : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get null : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
    public void setServcDutyTmStpSeilNum(Long  servcDutyTmStpSeilNum) { set( ATTR_SERVCDUTYTMSTPSEILNUM ,servcDutyTmStpSeilNum);}
    /** get 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
    public Long  getServcDutyTmStpSeilNum() { return (Long )get( ATTR_SERVCDUTYTMSTPSEILNUM );}

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
