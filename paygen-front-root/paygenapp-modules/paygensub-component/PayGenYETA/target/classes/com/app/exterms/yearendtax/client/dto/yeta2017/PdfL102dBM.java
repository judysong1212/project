package com.app.exterms.yearendtax.client.dto.yeta2017;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfL102dBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 기부금명세일련번호 : conbSeilNum */
    public static final String ATTR_CONBSEILNUM = "conbSeilNum";

    /** set 기부금_기부일자 : conbDd */
    public static final String ATTR_CONBDD = "conbDd";

    /** set 일별기부장려금신청금액 : conbApin */
    public static final String ATTR_CONBAPIN = "conbApin";

    /** set 일별기부금액합계 : conbDaysAmtSum */
    public static final String ATTR_CONBDAYSAMTSUM = "conbDaysAmtSum";

    /** set 일별기부금액_소득공제대상금액 : conbDdDdctSum */
    public static final String ATTR_CONBDDDDCTSUM = "conbDdDdctSum";

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
     public PdfL102dBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfL102dBM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  conbSeilNum 
    		, String  conbDd 
    		, Long  conbApin 
    		, Long  conbDaysAmtSum 
    		, Long  conbDdDdctSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_CONBSEILNUM,conbSeilNum);
     	values.put(ATTR_CONBDD,conbDd);
     	values.put(ATTR_CONBAPIN,conbApin);
     	values.put(ATTR_CONBDAYSAMTSUM,conbDaysAmtSum);
     	values.put(ATTR_CONBDDDDCTSUM,conbDdDdctSum);
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

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 기부금명세일련번호 : conbSeilNum */
    public void setConbSeilNum(Long  conbSeilNum) { set( ATTR_CONBSEILNUM ,conbSeilNum);}
    /** get 기부금명세일련번호 : conbSeilNum */
    public Long  getConbSeilNum() { return (Long )get( ATTR_CONBSEILNUM );}

    /** set 기부금_기부일자 : conbDd */
    public void setConbDd(String  conbDd) { set( ATTR_CONBDD ,conbDd);}
    /** get 기부금_기부일자 : conbDd */
    public String  getConbDd() { return (String )get( ATTR_CONBDD );}

    /** set 일별기부장려금신청금액 : conbApin */
    public void setConbApin(Long  conbApin) { set( ATTR_CONBAPIN ,conbApin);}
    /** get 일별기부장려금신청금액 : conbApin */
    public Long  getConbApin() { return (Long )get( ATTR_CONBAPIN );}

    /** set 일별기부금액합계 : conbDaysAmtSum */
    public void setConbDaysAmtSum(Long  conbDaysAmtSum) { set( ATTR_CONBDAYSAMTSUM ,conbDaysAmtSum);}
    /** get 일별기부금액합계 : conbDaysAmtSum */
    public Long  getConbDaysAmtSum() { return (Long )get( ATTR_CONBDAYSAMTSUM );}

    /** set 일별기부금액_소득공제대상금액 : conbDdDdctSum */
    public void setConbDdDdctSum(Long  conbDdDdctSum) { set( ATTR_CONBDDDDCTSUM ,conbDdDdctSum);}
    /** get 일별기부금액_소득공제대상금액 : conbDdDdctSum */
    public Long  getConbDdDdctSum() { return (Long )get( ATTR_CONBDDDDCTSUM );}

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
