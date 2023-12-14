package com.app.exterms.yearendtax.client.dto.yeta2019;



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
public class Ye167150BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 장기집합투자증권저축금융기관코드 : ltrmCniSsfnnOrgnCd */
    public static final String ATTR_LTRMCNISSFNNORGNCD = "ltrmCniSsfnnOrgnCd";

    /** set 장기집합투자증권저축회사명 : ltrmCniSsFnnCmp */
    public static final String ATTR_LTRMCNISSFNNCMP = "ltrmCniSsFnnCmp";

    /** set 계좌번호_증권번호 : ltrmCniSsAccno */
    public static final String ATTR_LTRMCNISSACCNO = "ltrmCniSsAccno";

    /** set 장기집합투자증권저축납입금액 : ltrmCniSsPymAmt */
    public static final String ATTR_LTRMCNISSPYMAMT = "ltrmCniSsPymAmt";

    /** set 장기집합투자증권저축세액공제금액 : ltrmCniSsIncDdcAmt */
    public static final String ATTR_LTRMCNISSINCDDCAMT = "ltrmCniSsIncDdcAmt";

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
     public Ye167150BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167150BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  ltrmCniSsfnnOrgnCd 
    		, String  ltrmCniSsFnnCmp 
    		, String  ltrmCniSsAccno 
    		, Long  ltrmCniSsPymAmt 
    		, Long  ltrmCniSsIncDdcAmt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_LTRMCNISSFNNORGNCD,ltrmCniSsfnnOrgnCd);
     	values.put(ATTR_LTRMCNISSFNNCMP,ltrmCniSsFnnCmp);
     	values.put(ATTR_LTRMCNISSACCNO,ltrmCniSsAccno);
     	values.put(ATTR_LTRMCNISSPYMAMT,ltrmCniSsPymAmt);
     	values.put(ATTR_LTRMCNISSINCDDCAMT,ltrmCniSsIncDdcAmt);
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

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 장기집합투자증권저축금융기관코드 : ltrmCniSsfnnOrgnCd */
    public void setLtrmCniSsfnnOrgnCd(String  ltrmCniSsfnnOrgnCd) { set( ATTR_LTRMCNISSFNNORGNCD ,ltrmCniSsfnnOrgnCd);}
    /** get 장기집합투자증권저축금융기관코드 : ltrmCniSsfnnOrgnCd */
    public String  getLtrmCniSsfnnOrgnCd() { return (String )get( ATTR_LTRMCNISSFNNORGNCD );}

    /** set 장기집합투자증권저축회사명 : ltrmCniSsFnnCmp */
    public void setLtrmCniSsFnnCmp(String  ltrmCniSsFnnCmp) { set( ATTR_LTRMCNISSFNNCMP ,ltrmCniSsFnnCmp);}
    /** get 장기집합투자증권저축회사명 : ltrmCniSsFnnCmp */
    public String  getLtrmCniSsFnnCmp() { return (String )get( ATTR_LTRMCNISSFNNCMP );}

    /** set 계좌번호_증권번호 : ltrmCniSsAccno */
    public void setLtrmCniSsAccno(String  ltrmCniSsAccno) { set( ATTR_LTRMCNISSACCNO ,ltrmCniSsAccno);}
    /** get 계좌번호_증권번호 : ltrmCniSsAccno */
    public String  getLtrmCniSsAccno() { return (String )get( ATTR_LTRMCNISSACCNO );}

    /** set 장기집합투자증권저축납입금액 : ltrmCniSsPymAmt */
    public void setLtrmCniSsPymAmt(Long  ltrmCniSsPymAmt) { set( ATTR_LTRMCNISSPYMAMT ,ltrmCniSsPymAmt);}
    /** get 장기집합투자증권저축납입금액 : ltrmCniSsPymAmt */
    public Long  getLtrmCniSsPymAmt() { return (Long )get( ATTR_LTRMCNISSPYMAMT );}

    /** set 장기집합투자증권저축세액공제금액 : ltrmCniSsIncDdcAmt */
    public void setLtrmCniSsIncDdcAmt(Long  ltrmCniSsIncDdcAmt) { set( ATTR_LTRMCNISSINCDDCAMT ,ltrmCniSsIncDdcAmt);}
    /** get 장기집합투자증권저축세액공제금액 : ltrmCniSsIncDdcAmt */
    public Long  getLtrmCniSsIncDdcAmt() { return (Long )get( ATTR_LTRMCNISSINCDDCAMT );}

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
