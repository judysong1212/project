package com.app.exterms.yearendtax.client.dto.yeta2021;



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
public class Ye167440BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 기부금조정일련번호 : conbSeilNum */
    public static final String ATTR_CONBSEILNUM = "conbSeilNum";

    /** set 기부년도 : attrYr */
    public static final String ATTR_ATTRYR = "attrYr";

    /** set 기부금코드 : conbCddl */
    public static final String ATTR_CONBCDDL = "conbCddl";

    /** set 기부금액 : useAmt */
    public static final String ATTR_USEAMT = "useAmt";

    /** set 전년도공제된금액 : pyrDdcAmt */
    public static final String ATTR_PYRDDCAMT = "pyrDdcAmt";

    /** set 기부금공제대상금액 : ddcTrgtAmt */
    public static final String ATTR_DDCTRGTAMT = "ddcTrgtAmt";

    /** set 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
    public static final String ATTR_THCYRDDCAMTNDXPS = "thcYrDdcAmtNdXps";

    /** set 해당연도공제금액세액공제금액 : thcYrDdcAmt */
    public static final String ATTR_THCYRDDCAMT = "thcYrDdcAmt";

    /** set 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
    public static final String ATTR_THCYRNDUCEXTNAMT = "thcYrNducExtnAmt";

    /** set 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
    public static final String ATTR_THCYRNDUCCRFWAMT = "thcYrNducCrfwAmt";

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
     public Ye167440BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167440BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  conbSeilNum 
    		, String  attrYr 
    		, String  conbCddl 
    		, Long  useAmt 
    		, Long  pyrDdcAmt 
    		, Long  ddcTrgtAmt 
    		, Long  thcYrDdcAmtNdXps 
    		, Long  thcYrDdcAmt 
    		, Long  thcYrNducExtnAmt 
    		, Long  thcYrNducCrfwAmt 
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
     	values.put(ATTR_ATTRYR,attrYr);
     	values.put(ATTR_CONBCDDL,conbCddl);
     	values.put(ATTR_USEAMT,useAmt);
     	values.put(ATTR_PYRDDCAMT,pyrDdcAmt);
     	values.put(ATTR_DDCTRGTAMT,ddcTrgtAmt);
     	values.put(ATTR_THCYRDDCAMTNDXPS,thcYrDdcAmtNdXps);
     	values.put(ATTR_THCYRDDCAMT,thcYrDdcAmt);
     	values.put(ATTR_THCYRNDUCEXTNAMT,thcYrNducExtnAmt);
     	values.put(ATTR_THCYRNDUCCRFWAMT,thcYrNducCrfwAmt);
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

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 기부금조정일련번호 : conbSeilNum */
    public void setConbSeilNum(Long  conbSeilNum) { set( ATTR_CONBSEILNUM ,conbSeilNum);}
    /** get 기부금조정일련번호 : conbSeilNum */
    public Long  getConbSeilNum() { return (Long )get( ATTR_CONBSEILNUM );}

    /** set 기부년도 : attrYr */
    public void setAttrYr(String  attrYr) { set( ATTR_ATTRYR ,attrYr);}
    /** get 기부년도 : attrYr */
    public String  getAttrYr() { return (String )get( ATTR_ATTRYR );}

    /** set 기부금코드 : conbCddl */
    public void setConbCddl(String  conbCddl) { set( ATTR_CONBCDDL ,conbCddl);}
    /** get 기부금코드 : conbCddl */
    public String  getConbCddl() { return (String )get( ATTR_CONBCDDL );}

    /** set 기부금액 : useAmt */
    public void setUseAmt(Long  useAmt) { set( ATTR_USEAMT ,useAmt);}
    /** get 기부금액 : useAmt */
    public Long  getUseAmt() { return (Long )get( ATTR_USEAMT );}

    /** set 전년도공제된금액 : pyrDdcAmt */
    public void setPyrDdcAmt(Long  pyrDdcAmt) { set( ATTR_PYRDDCAMT ,pyrDdcAmt);}
    /** get 전년도공제된금액 : pyrDdcAmt */
    public Long  getPyrDdcAmt() { return (Long )get( ATTR_PYRDDCAMT );}

    /** set 기부금공제대상금액 : ddcTrgtAmt */
    public void setDdcTrgtAmt(Long  ddcTrgtAmt) { set( ATTR_DDCTRGTAMT ,ddcTrgtAmt);}
    /** get 기부금공제대상금액 : ddcTrgtAmt */
    public Long  getDdcTrgtAmt() { return (Long )get( ATTR_DDCTRGTAMT );}

    /** set 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
    public void setThcYrDdcAmtNdXps(Long  thcYrDdcAmtNdXps) { set( ATTR_THCYRDDCAMTNDXPS ,thcYrDdcAmtNdXps);}
    /** get 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
    public Long  getThcYrDdcAmtNdXps() { return (Long )get( ATTR_THCYRDDCAMTNDXPS );}

    /** set 해당연도공제금액세액공제금액 : thcYrDdcAmt */
    public void setThcYrDdcAmt(Long  thcYrDdcAmt) { set( ATTR_THCYRDDCAMT ,thcYrDdcAmt);}
    /** get 해당연도공제금액세액공제금액 : thcYrDdcAmt */
    public Long  getThcYrDdcAmt() { return (Long )get( ATTR_THCYRDDCAMT );}

    /** set 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
    public void setThcYrNducExtnAmt(Long  thcYrNducExtnAmt) { set( ATTR_THCYRNDUCEXTNAMT ,thcYrNducExtnAmt);}
    /** get 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
    public Long  getThcYrNducExtnAmt() { return (Long )get( ATTR_THCYRNDUCEXTNAMT );}

    /** set 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
    public void setThcYrNducCrfwAmt(Long  thcYrNducCrfwAmt) { set( ATTR_THCYRNDUCCRFWAMT ,thcYrNducCrfwAmt);}
    /** get 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
    public Long  getThcYrNducCrfwAmt() { return (Long )get( ATTR_THCYRNDUCCRFWAMT );}

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
