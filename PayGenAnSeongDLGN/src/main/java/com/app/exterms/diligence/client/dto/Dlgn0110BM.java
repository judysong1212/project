package com.app.exterms.diligence.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0100VO.java
 * @Description : Payr0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0110BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 근태년월 : dilnlazYrMnth */
    public static final String ATTR_DILNLAZYRMNTH = "dilnlazYrMnth";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 근태_적용일자 : dilnlazApptnDt */
    public static final String ATTR_DILNLAZAPPTNDT = "dilnlazApptnDt";

    /** set 근태_근무시간 : dilnlazDutyTm */
    public static final String ATTR_DILNLAZDUTYTM = "dilnlazDutyTm";

    /** set 근태_근무여부 : dilnlazDutyYn */
    public static final String ATTR_DILNLAZDUTYYN = "dilnlazDutyYn";

    /** set 근태_결근여부 : dilnlazAbnceYn */
    public static final String ATTR_DILNLAZABNCEYN = "dilnlazAbnceYn";

    /** set 근태_연가여부 : dilnlazLvsgYn */
    public static final String ATTR_DILNLAZLVSGYN = "dilnlazLvsgYn";

    /** set 근태_병가여부 : dilnlazSckleaYn */
    public static final String ATTR_DILNLAZSCKLEAYN = "dilnlazSckleaYn";

    /** set 근태_공가여부 : dilnlazOffvaYn */
    public static final String ATTR_DILNLAZOFFVAYN = "dilnlazOffvaYn";

    /** set 근태_경조사여부 : dilnlazFmlyEvntYn */
    public static final String ATTR_DILNLAZFMLYEVNTYN = "dilnlazFmlyEvntYn";

    /** set 근태_보건여부 : dilnlazHlthCreYn */
    public static final String ATTR_DILNLAZHLTHCREYN = "dilnlazHlthCreYn";
    
    /** set 근태_휴일여부 : offdayKubn */
    public static final String ATTR_OFFDAYKUBN = "offdayKubn";

    /** set 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
    public static final String ATTR_DILNLAZABNCEDUTYRCGTNYN = "dilnlazAbnceDutyRcgtnYn";

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

    /** set 근태_특별휴가여부 : dilnlazSpclHodyYn */
    public static final String ATTR_DILNLAZSPCLHODYYN = "dilnlazSpclHodyYn";

    /** set 근태_교통보조비여부 : dilnlazTfcAssCstYn */
    public static final String ATTR_DILNLAZTFCASSCSTYN = "dilnlazTfcAssCstYn";

    /** set 근태_급식비여부 : dilnlazLnchYn */
    public static final String ATTR_DILNLAZLNCHYN = "dilnlazLnchYn";

    /** set 근태_휴일근무여부 : dilnlazHodyYn */
    public static final String ATTR_DILNLAZHODYYN = "dilnlazHodyYn";

    /** set 복무기타구분코드 : dilnlazEtcDivCd */
    public static final String ATTR_DILNLAZETCDIVCD = "dilnlazEtcDivCd";

    /** set 근태_출장여부 : dilnlazButpYn */
    public static final String ATTR_DILNLAZBUTPYN = "dilnlazButpYn";
    /** set 근태_출장여부 : dilnlazButpYn */
    public void setDilnlazButpYn(String  dilnlazButpYn) { set( ATTR_DILNLAZBUTPYN ,dilnlazButpYn);}
    /** get 근태_출장여부 : dilnlazButpYn */
    public String  getDilnlazButpYn() { return (String )get( ATTR_DILNLAZBUTPYN );}
    
    /** 생성자 */
     public Dlgn0110BM() { super(); } 

    /** 일괄등록 처리   */
     public Dlgn0110BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  dilnlazYrMnth 
    		, String  payCd 
    		, String  dilnlazApptnDt 
    		, String  dilnlazDutyTm 
    		, String  dilnlazDutyYn 
    		, String  dilnlazAbnceYn 
    		, String  dilnlazLvsgYn 
    		, String  dilnlazSckleaYn 
    		, String  dilnlazOffvaYn 
    		, String  dilnlazFmlyEvntYn 
    		, String  dilnlazHlthCreYn 
    		, String  offdayKubn
    		, String  dilnlazAbnceDutyRcgtnYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  dilnlazSpclHodyYn 
    		, String  dilnlazTfcAssCstYn 
    		, String  dilnlazLnchYn 
    		, String  dilnlazHodyYn 
    		, String  dilnlazEtcDivCd ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DILNLAZYRMNTH,dilnlazYrMnth);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_DILNLAZAPPTNDT,dilnlazApptnDt);
     	values.put(ATTR_DILNLAZDUTYTM,dilnlazDutyTm);
     	values.put(ATTR_DILNLAZDUTYYN,dilnlazDutyYn);
     	values.put(ATTR_DILNLAZABNCEYN,dilnlazAbnceYn);
     	values.put(ATTR_DILNLAZLVSGYN,dilnlazLvsgYn);
     	values.put(ATTR_DILNLAZSCKLEAYN,dilnlazSckleaYn);
     	values.put(ATTR_DILNLAZOFFVAYN,dilnlazOffvaYn);
     	values.put(ATTR_DILNLAZFMLYEVNTYN,dilnlazFmlyEvntYn);
     	values.put(ATTR_DILNLAZHLTHCREYN,dilnlazHlthCreYn);
     	values.put(ATTR_OFFDAYKUBN,offdayKubn);
     	values.put(ATTR_DILNLAZABNCEDUTYRCGTNYN,dilnlazAbnceDutyRcgtnYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_DILNLAZSPCLHODYYN,dilnlazSpclHodyYn);
     	values.put(ATTR_DILNLAZTFCASSCSTYN,dilnlazTfcAssCstYn);
     	values.put(ATTR_DILNLAZLNCHYN,dilnlazLnchYn);
     	values.put(ATTR_DILNLAZHODYYN,dilnlazHodyYn);
     	values.put(ATTR_DILNLAZETCDIVCD,dilnlazEtcDivCd); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 근태년월 : dilnlazYrMnth */
    public void setDilnlazYrMnth(String  dilnlazYrMnth) { set( ATTR_DILNLAZYRMNTH ,dilnlazYrMnth);}
    /** get 근태년월 : dilnlazYrMnth */
    public String  getDilnlazYrMnth() { return (String )get( ATTR_DILNLAZYRMNTH );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 근태_적용일자 : dilnlazApptnDt */
    public void setDilnlazApptnDt(String  dilnlazApptnDt) { set( ATTR_DILNLAZAPPTNDT ,dilnlazApptnDt);}
    /** get 근태_적용일자 : dilnlazApptnDt */
    public String  getDilnlazApptnDt() { return (String )get( ATTR_DILNLAZAPPTNDT );}

    /** set 근태_근무시간 : dilnlazDutyTm */
    public void setDilnlazDutyTm(String  dilnlazDutyTm) { set( ATTR_DILNLAZDUTYTM ,dilnlazDutyTm);}
    /** get 근태_근무시간 : dilnlazDutyTm */
    public String  getDilnlazDutyTm() { return (String )get( ATTR_DILNLAZDUTYTM );}

    /** set 근태_근무여부 : dilnlazDutyYn */
    public void setDilnlazDutyYn(String  dilnlazDutyYn) { set( ATTR_DILNLAZDUTYYN ,dilnlazDutyYn);}
    /** get 근태_근무여부 : dilnlazDutyYn */
    public String  getDilnlazDutyYn() { return (String )get( ATTR_DILNLAZDUTYYN );}

    /** set 근태_결근여부 : dilnlazAbnceYn */
    public void setDilnlazAbnceYn(String  dilnlazAbnceYn) { set( ATTR_DILNLAZABNCEYN ,dilnlazAbnceYn);}
    /** get 근태_결근여부 : dilnlazAbnceYn */
    public String  getDilnlazAbnceYn() { return (String )get( ATTR_DILNLAZABNCEYN );}

    /** set 근태_연가여부 : dilnlazLvsgYn */
    public void setDilnlazLvsgYn(String  dilnlazLvsgYn) { set( ATTR_DILNLAZLVSGYN ,dilnlazLvsgYn);}
    /** get 근태_연가여부 : dilnlazLvsgYn */
    public String  getDilnlazLvsgYn() { return (String )get( ATTR_DILNLAZLVSGYN );}

    /** set 근태_병가여부 : dilnlazSckleaYn */
    public void setDilnlazSckleaYn(String  dilnlazSckleaYn) { set( ATTR_DILNLAZSCKLEAYN ,dilnlazSckleaYn);}
    /** get 근태_병가여부 : dilnlazSckleaYn */
    public String  getDilnlazSckleaYn() { return (String )get( ATTR_DILNLAZSCKLEAYN );}

    /** set 근태_공가여부 : dilnlazOffvaYn */
    public void setDilnlazOffvaYn(String  dilnlazOffvaYn) { set( ATTR_DILNLAZOFFVAYN ,dilnlazOffvaYn);}
    /** get 근태_공가여부 : dilnlazOffvaYn */
    public String  getDilnlazOffvaYn() { return (String )get( ATTR_DILNLAZOFFVAYN );}

    /** set 근태_경조사여부 : dilnlazFmlyEvntYn */
    public void setDilnlazFmlyEvntYn(String  dilnlazFmlyEvntYn) { set( ATTR_DILNLAZFMLYEVNTYN ,dilnlazFmlyEvntYn);}
    /** get 근태_경조사여부 : dilnlazFmlyEvntYn */
    public String  getDilnlazFmlyEvntYn() { return (String )get( ATTR_DILNLAZFMLYEVNTYN );}

    /** set 근태_보건여부 : dilnlazHlthCreYn */
    public void setDilnlazHlthCreYn(String  dilnlazHlthCreYn) { set( ATTR_DILNLAZHLTHCREYN ,dilnlazHlthCreYn);}
    /** get 근태_보건여부 : dilnlazHlthCreYn */
    public String  getDilnlazHlthCreYn() { return (String )get( ATTR_DILNLAZHLTHCREYN );}
    
    /** set 근태_휴일여부 : offdayKubn */
    public void setOffdayKubn(String  offdayKubn) { set( ATTR_OFFDAYKUBN ,offdayKubn);}
    /** get 근태_휴일여부 : offdayKubn */
    public String  getOffdayKubn() { return (String )get( ATTR_OFFDAYKUBN );}

    /** set 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
    public void setDilnlazAbnceDutyRcgtnYn(String  dilnlazAbnceDutyRcgtnYn) { set( ATTR_DILNLAZABNCEDUTYRCGTNYN ,dilnlazAbnceDutyRcgtnYn);}
    /** get 근태_결근근무인정여부 : dilnlazAbnceDutyRcgtnYn */
    public String  getDilnlazAbnceDutyRcgtnYn() { return (String )get( ATTR_DILNLAZABNCEDUTYRCGTNYN );}

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

    /** set 근태_특별휴가여부 : dilnlazSpclHodyYn */
    public void setDilnlazSpclHodyYn(String  dilnlazSpclHodyYn) { set( ATTR_DILNLAZSPCLHODYYN ,dilnlazSpclHodyYn);}
    /** get 근태_특별휴가여부 : dilnlazSpclHodyYn */
    public String  getDilnlazSpclHodyYn() { return (String )get( ATTR_DILNLAZSPCLHODYYN );}

    /** set 근태_교통보조비여부 : dilnlazTfcAssCstYn */
    public void setDilnlazTfcAssCstYn(String  dilnlazTfcAssCstYn) { set( ATTR_DILNLAZTFCASSCSTYN ,dilnlazTfcAssCstYn);}
    /** get 근태_교통보조비여부 : dilnlazTfcAssCstYn */
    public String  getDilnlazTfcAssCstYn() { return (String )get( ATTR_DILNLAZTFCASSCSTYN );}

    /** set 근태_급식비여부 : dilnlazLnchYn */
    public void setDilnlazLnchYn(String  dilnlazLnchYn) { set( ATTR_DILNLAZLNCHYN ,dilnlazLnchYn);}
    /** get 근태_급식비여부 : dilnlazLnchYn */
    public String  getDilnlazLnchYn() { return (String )get( ATTR_DILNLAZLNCHYN );}

    /** set 근태_휴일근무여부 : dilnlazHodyYn */
    public void setDilnlazHodyYn(String  dilnlazHodyYn) { set( ATTR_DILNLAZHODYYN ,dilnlazHodyYn);}
    /** get 근태_휴일근무여부 : dilnlazHodyYn */
    public String  getDilnlazHodyYn() { return (String )get( ATTR_DILNLAZHODYYN );}

    /** set 복무기타구분코드 : dilnlazEtcDivCd */
    public void setDilnlazEtcDivCd(String  dilnlazEtcDivCd) { set( ATTR_DILNLAZETCDIVCD ,dilnlazEtcDivCd);}
    /** get 복무기타구분코드 : dilnlazEtcDivCd */
    public String  getDilnlazEtcDivCd() { return (String )get( ATTR_DILNLAZETCDIVCD );}

}
