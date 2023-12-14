package com.app.exterms.yearendtax.client.dto.yeta2018;



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
public class PdfJ101mBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 주택임차차입금일련번호 : tradeSeilNum */
    public static final String ATTR_TRADESEILNUM = "tradeSeilNum";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 주택임차차입금상환월 : lsAmtMn */
    public static final String ATTR_LSAMTMN = "lsAmtMn";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주택임차차입금월별상환액 : lsMmAmt */
    public static final String ATTR_LSMMAMT = "lsMmAmt";

    /** set 주택임차차입금월별확정구분코드 : fixCd */
    public static final String ATTR_FIXCD = "fixCd";

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
     public PdfJ101mBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfJ101mBM(
    		 String  dpobCd 
    		, Long  tradeSeilNum 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  lsAmtMn 
    		, String  systemkey 
    		, Long  lsMmAmt 
    		, String  fixCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TRADESEILNUM,tradeSeilNum);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_LSAMTMN,lsAmtMn);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_LSMMAMT,lsMmAmt);
     	values.put(ATTR_FIXCD,fixCd);
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

    /** set 주택임차차입금일련번호 : tradeSeilNum */
    public void setTradeSeilNum(Long  tradeSeilNum) { set( ATTR_TRADESEILNUM ,tradeSeilNum);}
    /** get 주택임차차입금일련번호 : tradeSeilNum */
    public Long  getTradeSeilNum() { return (Long )get( ATTR_TRADESEILNUM );}

    /** set 귀속년도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속년도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 주택임차차입금상환월 : lsAmtMn */
    public void setLsAmtMn(String  lsAmtMn) { set( ATTR_LSAMTMN ,lsAmtMn);}
    /** get 주택임차차입금상환월 : lsAmtMn */
    public String  getLsAmtMn() { return (String )get( ATTR_LSAMTMN );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 주택임차차입금월별상환액 : lsMmAmt */
    public void setLsMmAmt(Long  lsMmAmt) { set( ATTR_LSMMAMT ,lsMmAmt);}
    /** get 주택임차차입금월별상환액 : lsMmAmt */
    public Long  getLsMmAmt() { return (Long )get( ATTR_LSMMAMT );}

    /** set 주택임차차입금월별확정구분코드 : fixCd */
    public void setFixCd(String  fixCd) { set( ATTR_FIXCD ,fixCd);}
    /** get 주택임차차입금월별확정구분코드 : fixCd */
    public String  getFixCd() { return (String )get( ATTR_FIXCD );}

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
