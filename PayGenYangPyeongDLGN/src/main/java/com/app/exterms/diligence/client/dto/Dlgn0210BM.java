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
public class Dlgn0210BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public static final String ATTR_DILNLAZEXCEDUTYYRMNTH = "dilnlazExceDutyYrMnth";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 근태_적용일자 : dilnlazApptnDt */
    public static final String ATTR_DILNLAZAPPTNDT = "dilnlazApptnDt";

    /** set 근태_초과근무여부 : dilnlazDutyYn */
    public static final String ATTR_DILNLAZDUTYYN = "dilnlazDutyYn";

    /** set 근태_초과근무시간 : dilnlazDutyTm */
    public static final String ATTR_DILNLAZDUTYTM = "dilnlazDutyTm";

    /** set 근태_야근여부 : dilnlazNtotYn */
    public static final String ATTR_DILNLAZNTOTYN = "dilnlazNtotYn";

    /** set 근태_야근시간 : dilnlazNtotTm */
    public static final String ATTR_DILNLAZNTOTTM = "dilnlazNtotTm";

    /** set 근태_시간외근무여부 : dilnlazTmRstDutyYn */
    public static final String ATTR_DILNLAZTMRSTDUTYYN = "dilnlazTmRstDutyYn";

    /** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public static final String ATTR_DILNLAZTMRSTDUTYTM = "dilnlazTmRstDutyTm";

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

    /** set 근태_휴일근무여부 : dilnlazHodyDutyYn */
    public static final String ATTR_DILNLAZHODYDUTYYN = "dilnlazHodyDutyYn";

    /** set 근태_휴일근무시간 : dilnlazHodyDutyTm */
    public static final String ATTR_DILNLAZHODYDUTYTM = "dilnlazHodyDutyTm";
    
    //2017.04.06 : kim ji eun
    
    /** set 근태_시작시간 : dilnlazDutyStTm */
    public static final String ATTR_DILNLAZDUTYSTTM = "dilnlazDutyStTm";

    /** set 근태_종료시간 : dilnlazDutyEdTm */
    public static final String ATTR_DILNLAZDUTYEDTM = "dilnlazDutyEdTm";
    
    /** set 근태_퇴근시간 : dilnlazTmOffWorkTm */
    public static final String ATTR_DILNLAZTMOFFWORKTM = "dilnlazTmOffWorkTm";
    
    /** set 근태_휴무여부: offdayKubn */
    public static final String ATTR_OFFDAYKUBN = "offdayKubn";
    
    /** set 근태_시간외퇴근시간 : dilnlazDutyEdTmRst */
    public static final String ATTR_DILNLAZDUTYEDTMRST = "dilnlazDutyEdTmRst";
    
    /** set 근태_야근퇴근시간 : dilnlazDutyEdTmDuty */
    public static final String ATTR_DILNLAZDUTYEDTMDUTY = "dilnlazDutyEdTmDuty";
    
    /** set 근태_휴일근무퇴근시간 : dilnlazDutyEdTmHodyDuty */
    public static final String ATTR_DILNLAZDUTYEDTMHODYDUTY = "dilnlazDutyEdTmHodyDuty";
    
    /** set 근태_휴일근무연장퇴근시간 : dilnlazDutyEdTmHodyNtot */
    public static final String ATTR_DILNLAZDUTYEDTMHODYNTOT = "dilnlazDutyEdTmHodyNtot";
    
    /** set 근태_휴일연장근무여부 : dilnlazHodyDutyRstYn */
    public static final String ATTR_DILNLAZHODYDUTYRSTYN = "dilnlazHodyDutyRstYn";

    /** set 근태_휴일연장근무시간 : dilnlazHodyNtotTm */
    public static final String ATTR_DILNLAZHODYNTOTTM = "dilnlazHodyNtotTm";
    
    /** set 복무통합구분값 : typOccuBusinVal */
    public static final String ATTR_TYPOCCUBUSINVAL = "typOccuBusinVal";

    /** 생성자 */
     public Dlgn0210BM() { super(); } 

    /** 일괄등록 처리   */
     public Dlgn0210BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  dilnlazExceDutyYrMnth 
    		, String  payCd 
    		, String  dilnlazApptnDt 
    		, String  dilnlazDutyYn 
    		, String  dilnlazDutyTm 
    		, String  dilnlazNtotYn 
    		, String  dilnlazNtotTm 
    		, String  dilnlazTmRstDutyYn 
    		, String  dilnlazTmRstDutyTm 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  dilnlazHodyDutyYn 
    		, String  dilnlazHodyDutyTm
    		, String  offdayKubn 
    		, String  dilnlazDutyStTm
    		, String  dilnlazDutyEdTm
    		, String  dilnlazTmOffWorkTm 
    		, String  dilnlazDutyEdTmRst
    		, String  dilnlazDutyEdTmDuty
    		, String  dilnlazDutyEdTmHodyDuty
    		, String  dilnlazDutyEdTmHodyNtot
    		, String  dilnlazHodyDutyRstYn 
    		, String  dilnlazHodyNtotTm ) {  
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DILNLAZEXCEDUTYYRMNTH,dilnlazExceDutyYrMnth);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_DILNLAZAPPTNDT,dilnlazApptnDt);
     	values.put(ATTR_DILNLAZDUTYYN,dilnlazDutyYn);
     	values.put(ATTR_DILNLAZDUTYTM,dilnlazDutyTm);
     	values.put(ATTR_DILNLAZNTOTYN,dilnlazNtotYn);
     	values.put(ATTR_DILNLAZNTOTTM,dilnlazNtotTm);
     	values.put(ATTR_DILNLAZTMRSTDUTYYN,dilnlazTmRstDutyYn);
     	values.put(ATTR_DILNLAZTMRSTDUTYTM,dilnlazTmRstDutyTm);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_DILNLAZHODYDUTYYN,dilnlazHodyDutyYn);
     	values.put(ATTR_DILNLAZHODYDUTYTM,dilnlazHodyDutyTm); 
     	values.put(ATTR_OFFDAYKUBN,offdayKubn); 
     	values.put(ATTR_DILNLAZDUTYSTTM,dilnlazDutyStTm);
     	values.put(ATTR_DILNLAZDUTYEDTM,dilnlazDutyEdTm);
     	values.put(ATTR_DILNLAZTMOFFWORKTM,dilnlazTmOffWorkTm); 
     	values.put(ATTR_DILNLAZDUTYEDTMRST,dilnlazDutyEdTmRst);
     	values.put(ATTR_DILNLAZDUTYEDTMDUTY,dilnlazDutyEdTmDuty);
     	values.put(ATTR_DILNLAZDUTYEDTMHODYDUTY,dilnlazDutyEdTmHodyDuty);
     	values.put(ATTR_DILNLAZDUTYEDTMHODYNTOT,dilnlazDutyEdTmHodyNtot);
     	values.put(ATTR_DILNLAZHODYDUTYRSTYN,dilnlazHodyDutyRstYn);
     	values.put(ATTR_DILNLAZHODYNTOTTM,dilnlazHodyNtotTm);
     	} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public void setDilnlazExceDutyYrMnth(String  dilnlazExceDutyYrMnth) { set( ATTR_DILNLAZEXCEDUTYYRMNTH ,dilnlazExceDutyYrMnth);}
    /** get 근태초과근무년월 : dilnlazExceDutyYrMnth */
    public String  getDilnlazExceDutyYrMnth() { return (String )get( ATTR_DILNLAZEXCEDUTYYRMNTH );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 근태_적용일자 : dilnlazApptnDt */
    public void setDilnlazApptnDt(String  dilnlazApptnDt) { set( ATTR_DILNLAZAPPTNDT ,dilnlazApptnDt);}
    /** get 근태_적용일자 : dilnlazApptnDt */
    public String  getDilnlazApptnDt() { return (String )get( ATTR_DILNLAZAPPTNDT );}

    /** set 근태_초과근무여부 : dilnlazDutyYn */
    public void setDilnlazDutyYn(String  dilnlazDutyYn) { set( ATTR_DILNLAZDUTYYN ,dilnlazDutyYn);}
    /** get 근태_초과근무여부 : dilnlazDutyYn */
    public String  getDilnlazDutyYn() { return (String )get( ATTR_DILNLAZDUTYYN );}

    /** set 근태_초과근무시간 : dilnlazDutyTm */
    public void setDilnlazDutyTm(String  dilnlazDutyTm) { set( ATTR_DILNLAZDUTYTM ,dilnlazDutyTm);}
    /** get 근태_초과근무시간 : dilnlazDutyTm */
    public String  getDilnlazDutyTm() { return (String )get( ATTR_DILNLAZDUTYTM );}

    /** set 근태_야근여부 : dilnlazNtotYn */
    public void setDilnlazNtotYn(String  dilnlazNtotYn) { set( ATTR_DILNLAZNTOTYN ,dilnlazNtotYn);}
    /** get 근태_야근여부 : dilnlazNtotYn */
    public String  getDilnlazNtotYn() { return (String )get( ATTR_DILNLAZNTOTYN );}

    /** set 근태_야근시간 : dilnlazNtotTm */
    public void setDilnlazNtotTm(String  dilnlazNtotTm) { set( ATTR_DILNLAZNTOTTM ,dilnlazNtotTm);}
    /** get 근태_야근시간 : dilnlazNtotTm */
    public String  getDilnlazNtotTm() { return (String )get( ATTR_DILNLAZNTOTTM );}

    /** set 근태_시간외근무여부 : dilnlazTmRstDutyYn */
    public void setDilnlazTmRstDutyYn(String  dilnlazTmRstDutyYn) { set( ATTR_DILNLAZTMRSTDUTYYN ,dilnlazTmRstDutyYn);}
    /** get 근태_시간외근무여부 : dilnlazTmRstDutyYn */
    public String  getDilnlazTmRstDutyYn() { return (String )get( ATTR_DILNLAZTMRSTDUTYYN );}

    /** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public void setDilnlazTmRstDutyTm(String  dilnlazTmRstDutyTm) { set( ATTR_DILNLAZTMRSTDUTYTM ,dilnlazTmRstDutyTm);}
    /** get 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    public String  getDilnlazTmRstDutyTm() { return (String )get( ATTR_DILNLAZTMRSTDUTYTM );}

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

    /** set 근태_휴일근무여부 : dilnlazHodyDutyYn */
    public void setDilnlazHodyDutyYn(String  dilnlazHodyDutyYn) { set( ATTR_DILNLAZHODYDUTYYN ,dilnlazHodyDutyYn);}
    /** get 근태_휴일근무여부 : dilnlazHodyDutyYn */
    public String  getDilnlazHodyDutyYn() { return (String )get( ATTR_DILNLAZHODYDUTYYN );}

    /** set 근태_휴일근무시간 : dilnlazHodyDutyTm */
    public void setDilnlazHodyDutyTm(String  dilnlazHodyDutyTm) { set( ATTR_DILNLAZHODYDUTYTM ,dilnlazHodyDutyTm);}
    /** get 근태_휴일근무시간 : dilnlazHodyDutyTm */
    public String  getDilnlazHodyDutyTm() { return (String )get( ATTR_DILNLAZHODYDUTYTM );}
    
    /** set 근태_휴무여부 : offdayKubn */
    public void setOffdayKubn(String  offdayKubn) { set( ATTR_OFFDAYKUBN ,offdayKubn);}
    /** get 근태_휴무여부 : offdayKubn */
    public String  getsetOffdayKubn() { return (String )get( ATTR_OFFDAYKUBN );}
    
    /** set 근태_시작시간 : dilnlazDutyStTm */
    public void setDilnlazDutyStTm(String  dilnlazDutyStTm) { set( ATTR_DILNLAZDUTYSTTM ,dilnlazDutyStTm);}
    /** get 근태_시작시간 : dilnlazDutyStTm */
    public String getDilnlazDutyStTm() { return (String )get( ATTR_DILNLAZDUTYSTTM );}
    
    /** set 근태_종료시간 : dilnlazDutyEdTm */
    public void setDilnlazDutyEdTm(String  dilnlazDutyEdTm) { set( ATTR_DILNLAZDUTYEDTM ,dilnlazDutyEdTm);}
    /** get 근태_종료시간 : dilnlazDutyEdTm */
    public String  getDilnlazDutyEdTm() { return (String )get( ATTR_DILNLAZDUTYEDTM );}
    
    /** set 근태_퇴근시간 : dilnlazTmOffWorkTm */
    public void setDilnlazTmOffWorkTm(String  dilnlazTmOffWorkTm) { set( ATTR_DILNLAZTMOFFWORKTM ,dilnlazTmOffWorkTm);}
    /** get 근태_퇴근시간 : dilnlazTmOffWorkTm */
    public String  getDilnlazTmOffWorkTm() { return (String )get( ATTR_DILNLAZTMOFFWORKTM );}
    
    /** set 근태_시간외근무퇴근시간 : dilnlazDutyEdTmRst */
    public void setDilnlazDutyEdTmRst(String  dilnlazDutyEdTmRst) { set( ATTR_DILNLAZDUTYEDTMRST ,dilnlazDutyEdTmRst);}
    /** get 근태_시간외근무퇴근시간 : dilnlazDutyEdTmRst */
    public String  getDilnlazDutyEdTmRst() { return (String )get( ATTR_DILNLAZDUTYEDTMRST );}
    
    /** set 근태_야근근무퇴근시간 : dilnlazDutyEdTmDuty */
    public void setDilnlazDutyEdTmDuty(String  dilnlazDutyEdTmDuty) { set( ATTR_DILNLAZDUTYEDTMDUTY ,dilnlazDutyEdTmDuty);}
    /** get 근태_야근근무퇴근시간 : dilnlazDutyEdTmDuty */
    public String  getDilnlazDutyEdTmDuty() { return (String )get( ATTR_DILNLAZDUTYEDTMDUTY );}
    
    /** set 근태_휴일근무퇴근시간 : dilnlazDutyEdTmHodyDuty */
    public void setDilnlazDutyEdTmHodyDuty(String  dilnlazDutyEdTmHodyDuty) { set( ATTR_DILNLAZDUTYEDTMHODYDUTY ,dilnlazDutyEdTmHodyDuty);}
    /** get 근태_휴일근무퇴근시간 : dilnlazDutyEdTmHodyDuty */
    public String  getDilnlazDutyEdTmHodyDuty() { return (String )get( ATTR_DILNLAZDUTYEDTMHODYDUTY );}
    
    /** set 근태_휴일근무연장퇴근시간 : dilnlazDutyEdTmHodyNtot */
    public void setDilnlazDutyEdTmHodyNtot(String  dilnlazDutyEdTmHodyNtot) { set( ATTR_DILNLAZDUTYEDTMHODYNTOT ,dilnlazDutyEdTmHodyNtot);}
    /** get 근태_휴일근무연장퇴근시간 : dilnlazDutyEdTmHodyNtot */
    public String  getDilnlazDutyEdTmHodyNtot() { return (String )get( ATTR_DILNLAZDUTYEDTMHODYNTOT );}
    
    /** set 근태_휴일연장근무여부 : dilnlazHodyDutyRstYn */
    public void setDilnlazHodyDutyRstYn(String  dilnlazHodyDutyRstYn) { set( ATTR_DILNLAZHODYDUTYRSTYN ,dilnlazHodyDutyRstYn);}
    /** get 근태_휴일연장근무여부 : dilnlazHodyDutyRstYn */
    public String  getDilnlazHodyDutyRstYn() { return (String )get( ATTR_DILNLAZHODYDUTYRSTYN );}

    /** set 근태_휴일연장근무시간 : dilnlazHodyNtotTm */
    public void setDilnlazHodyNtotTm(String  dilnlazHodyNtotTm) { set( ATTR_DILNLAZHODYNTOTTM ,dilnlazHodyNtotTm);}
    /** get 근태_휴일연장근무시간 : dilnlazHodyNtotTm */
    public String getDilnlazHodyNtotTm() { return (String )get( ATTR_DILNLAZHODYNTOTTM );}
    
    /** set 복무통합구분값 : typOccuBusinVal */
    public void setTypOccuBusinVal(String  typOccuBusinVal) { set( ATTR_TYPOCCUBUSINVAL ,typOccuBusinVal);}
    /** get 복무통합구분값 : typOccuBusinVal */
    public String  getTypOccuBusinVal() { return (String )get( ATTR_TYPOCCUBUSINVAL );}

}
