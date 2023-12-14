package com.app.exterms.yearendtax.client.dto.yeta2021;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye162030BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162030BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 계좌번호_증권번호 : hsngPrptSvngAccNo */
    public static final String ATTR_HSNGPRPTSVNGACCNO = "hsngPrptSvngAccNo";

    /** set 주택마련저축소득공제구분코드 : hsngPrptSvngSvngCl */
    public static final String ATTR_HSNGPRPTSVNGSVNGCL = "hsngPrptSvngSvngCl";

    /** set 주택마련저축가입일자 : jnngDt */
    public static final String ATTR_JNNGDT = "jnngDt";

    /** set 주택마련저축금융기관코드 : hsngPrptSvngFnnOrgnCd */
    public static final String ATTR_HSNGPRPTSVNGFNNORGNCD = "hsngPrptSvngFnnOrgnCd";

    /** set 금융회사등명 : hsngPrptSvngFnnCmp */
    public static final String ATTR_HSNGPRPTSVNGFNNCMP = "hsngPrptSvngFnnCmp";

    /** set 주택마련저축납입금액 : hsngPrptSvngPymAmt */
    public static final String ATTR_HSNGPRPTSVNGPYMAMT = "hsngPrptSvngPymAmt";

    /** set 주택마련저축세액공제금액 : hsngPrptSvngIncDdcAmt */
    public static final String ATTR_HSNGPRPTSVNGINCDDCAMT = "hsngPrptSvngIncDdcAmt";

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
     public Ye162030BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye162030BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  hsngPrptSvngAccNo 
    		, String  hsngPrptSvngSvngCl 
    		, String  jnngDt 
    		, String  hsngPrptSvngFnnOrgnCd 
    		, String  hsngPrptSvngFnnCmp 
    		, Long  hsngPrptSvngPymAmt 
    		, Long  hsngPrptSvngIncDdcAmt 
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
     	values.put(ATTR_HSNGPRPTSVNGACCNO,hsngPrptSvngAccNo);
     	values.put(ATTR_HSNGPRPTSVNGSVNGCL,hsngPrptSvngSvngCl);
     	values.put(ATTR_JNNGDT,jnngDt);
     	values.put(ATTR_HSNGPRPTSVNGFNNORGNCD,hsngPrptSvngFnnOrgnCd);
     	values.put(ATTR_HSNGPRPTSVNGFNNCMP,hsngPrptSvngFnnCmp);
     	values.put(ATTR_HSNGPRPTSVNGPYMAMT,hsngPrptSvngPymAmt);
     	values.put(ATTR_HSNGPRPTSVNGINCDDCAMT,hsngPrptSvngIncDdcAmt);
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
    /** set 계좌번호_증권번호 : hsngPrptSvngAccNo */
    public void setHsngPrptSvngAccNo(String  hsngPrptSvngAccNo) { set( ATTR_HSNGPRPTSVNGACCNO ,hsngPrptSvngAccNo);}
    /** get 계좌번호_증권번호 : hsngPrptSvngAccNo */
    public String  getHsngPrptSvngAccNo() { return (String )get( ATTR_HSNGPRPTSVNGACCNO );}
    /** set 주택마련저축소득공제구분코드 : hsngPrptSvngSvngCl */
    public void setHsngPrptSvngSvngCl(String  hsngPrptSvngSvngCl) { set( ATTR_HSNGPRPTSVNGSVNGCL ,hsngPrptSvngSvngCl);}
    /** get 주택마련저축소득공제구분코드 : hsngPrptSvngSvngCl */
    public String  getHsngPrptSvngSvngCl() { return (String )get( ATTR_HSNGPRPTSVNGSVNGCL );}
    /** set 주택마련저축가입일자 : jnngDt */
    public void setJnngDt(String  jnngDt) { set( ATTR_JNNGDT ,jnngDt);}
    /** get 주택마련저축가입일자 : jnngDt */
    public String  getJnngDt() { return (String )get( ATTR_JNNGDT );}
    /** set 주택마련저축금융기관코드 : hsngPrptSvngFnnOrgnCd */
    public void setHsngPrptSvngFnnOrgnCd(String  hsngPrptSvngFnnOrgnCd) { set( ATTR_HSNGPRPTSVNGFNNORGNCD ,hsngPrptSvngFnnOrgnCd);}
    /** get 주택마련저축금융기관코드 : hsngPrptSvngFnnOrgnCd */
    public String  getHsngPrptSvngFnnOrgnCd() { return (String )get( ATTR_HSNGPRPTSVNGFNNORGNCD );}
    /** set 금융회사등명 : hsngPrptSvngFnnCmp */
    public void setHsngPrptSvngFnnCmp(String  hsngPrptSvngFnnCmp) { set( ATTR_HSNGPRPTSVNGFNNCMP ,hsngPrptSvngFnnCmp);}
    /** get 금융회사등명 : hsngPrptSvngFnnCmp */
    public String  getHsngPrptSvngFnnCmp() { return (String )get( ATTR_HSNGPRPTSVNGFNNCMP );}
    /** set 주택마련저축납입금액 : hsngPrptSvngPymAmt */
    public void setHsngPrptSvngPymAmt(Long  hsngPrptSvngPymAmt) { set( ATTR_HSNGPRPTSVNGPYMAMT ,hsngPrptSvngPymAmt);}
    /** get 주택마련저축납입금액 : hsngPrptSvngPymAmt */
    public Long  getHsngPrptSvngPymAmt() { return (Long )get( ATTR_HSNGPRPTSVNGPYMAMT );}
    /** set 주택마련저축세액공제금액 : hsngPrptSvngIncDdcAmt */
    public void setHsngPrptSvngIncDdcAmt(Long  hsngPrptSvngIncDdcAmt) { set( ATTR_HSNGPRPTSVNGINCDDCAMT ,hsngPrptSvngIncDdcAmt);}
    /** get 주택마련저축세액공제금액 : hsngPrptSvngIncDdcAmt */
    public Long  getHsngPrptSvngIncDdcAmt() { return (Long )get( ATTR_HSNGPRPTSVNGINCDDCAMT );}
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
