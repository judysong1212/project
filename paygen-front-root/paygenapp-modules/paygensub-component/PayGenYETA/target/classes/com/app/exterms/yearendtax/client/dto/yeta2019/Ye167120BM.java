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
public class Ye167120BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 퇴직연금구분 : rtpnAccRtpnCl */
    public static final String ATTR_RTPNACCRTPNCL = "rtpnAccRtpnCl";

    /** set 퇴직연금금융기관코드 : rtpnFnnOrgnCd */
    public static final String ATTR_RTPNFNNORGNCD = "rtpnFnnOrgnCd";

    /** set 금융회사등명 : rtpnAccFnnCmp */
    public static final String ATTR_RTPNACCFNNCMP = "rtpnAccFnnCmp";

    /** set 계죄번호_증권번호 : rtpnAccAccno */
    public static final String ATTR_RTPNACCACCNO = "rtpnAccAccno";

    /** set 퇴직연금납입금액 : rtpnAccPymAmt */
    public static final String ATTR_RTPNACCPYMAMT = "rtpnAccPymAmt";

    /** set 퇴직연금세액공제금액 : rtpnAccTxamtDdcAmt */
    public static final String ATTR_RTPNACCTXAMTDDCAMT = "rtpnAccTxamtDdcAmt";

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
     public Ye167120BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167120BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  rtpnAccRtpnCl 
    		, String  rtpnFnnOrgnCd 
    		, String  rtpnAccFnnCmp 
    		, String  rtpnAccAccno 
    		, Long  rtpnAccPymAmt 
    		, Long  rtpnAccTxamtDdcAmt 
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
     	values.put(ATTR_RTPNACCRTPNCL,rtpnAccRtpnCl);
     	values.put(ATTR_RTPNFNNORGNCD,rtpnFnnOrgnCd);
     	values.put(ATTR_RTPNACCFNNCMP,rtpnAccFnnCmp);
     	values.put(ATTR_RTPNACCACCNO,rtpnAccAccno);
     	values.put(ATTR_RTPNACCPYMAMT,rtpnAccPymAmt);
     	values.put(ATTR_RTPNACCTXAMTDDCAMT,rtpnAccTxamtDdcAmt);
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

    /** set 퇴직연금구분 : rtpnAccRtpnCl */
    public void setRtpnAccRtpnCl(String  rtpnAccRtpnCl) { set( ATTR_RTPNACCRTPNCL ,rtpnAccRtpnCl);}
    /** get 퇴직연금구분 : rtpnAccRtpnCl */
    public String  getRtpnAccRtpnCl() { return (String )get( ATTR_RTPNACCRTPNCL );}

    /** set 퇴직연금금융기관코드 : rtpnFnnOrgnCd */
    public void setRtpnFnnOrgnCd(String  rtpnFnnOrgnCd) { set( ATTR_RTPNFNNORGNCD ,rtpnFnnOrgnCd);}
    /** get 퇴직연금금융기관코드 : rtpnFnnOrgnCd */
    public String  getRtpnFnnOrgnCd() { return (String )get( ATTR_RTPNFNNORGNCD );}

    /** set 금융회사등명 : rtpnAccFnnCmp */
    public void setRtpnAccFnnCmp(String  rtpnAccFnnCmp) { set( ATTR_RTPNACCFNNCMP ,rtpnAccFnnCmp);}
    /** get 금융회사등명 : rtpnAccFnnCmp */
    public String  getRtpnAccFnnCmp() { return (String )get( ATTR_RTPNACCFNNCMP );}

    /** set 계죄번호_증권번호 : rtpnAccAccno */
    public void setRtpnAccAccno(String  rtpnAccAccno) { set( ATTR_RTPNACCACCNO ,rtpnAccAccno);}
    /** get 계죄번호_증권번호 : rtpnAccAccno */
    public String  getRtpnAccAccno() { return (String )get( ATTR_RTPNACCACCNO );}

    /** set 퇴직연금납입금액 : rtpnAccPymAmt */
    public void setRtpnAccPymAmt(Long  rtpnAccPymAmt) { set( ATTR_RTPNACCPYMAMT ,rtpnAccPymAmt);}
    /** get 퇴직연금납입금액 : rtpnAccPymAmt */
    public Long  getRtpnAccPymAmt() { return (Long )get( ATTR_RTPNACCPYMAMT );}

    /** set 퇴직연금세액공제금액 : rtpnAccTxamtDdcAmt */
    public void setRtpnAccTxamtDdcAmt(Long  rtpnAccTxamtDdcAmt) { set( ATTR_RTPNACCTXAMTDDCAMT ,rtpnAccTxamtDdcAmt);}
    /** get 퇴직연금세액공제금액 : rtpnAccTxamtDdcAmt */
    public Long  getRtpnAccTxamtDdcAmt() { return (Long )get( ATTR_RTPNACCTXAMTDDCAMT );}

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
