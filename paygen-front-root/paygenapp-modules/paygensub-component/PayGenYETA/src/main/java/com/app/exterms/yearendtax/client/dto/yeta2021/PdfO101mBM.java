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
public class PdfO101mBM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 자료코드 : datCd */
    public static final String ATTR_DATCD = "datCd";

    /** set 건강보험납입월 : hlthAmtMn */
    public static final String ATTR_HLTHAMTMN = "hlthAmtMn";

    /** set 건강보험료_보수월액_고지금액 : hiNtf */
    public static final String ATTR_HINTF = "hiNtf";

    /** set 장기요양보험료_보수월액_고지금액 : ltrmNtf */
    public static final String ATTR_LTRMNTF = "ltrmNtf";

    /** set 건강보험료_소득월액_납부금액 : hiPmt */
    public static final String ATTR_HIPMT = "hiPmt";

    /** set 장기용양보험료_소득월액_납부금액 : ltrmPmt */
    public static final String ATTR_LTRMPMT = "ltrmPmt";

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
     public PdfO101mBM() { super(); } 

    /** 일괄등록 처리   */
     public PdfO101mBM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  datCd 
    		, String  hlthAmtMn 
    		, Long  hiNtf 
    		, Long  ltrmNtf 
    		, Long  hiPmt 
    		, Long  ltrmPmt 
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
     	values.put(ATTR_DATCD,datCd);
     	values.put(ATTR_HLTHAMTMN,hlthAmtMn);
     	values.put(ATTR_HINTF,hiNtf);
     	values.put(ATTR_LTRMNTF,ltrmNtf);
     	values.put(ATTR_HIPMT,hiPmt);
     	values.put(ATTR_LTRMPMT,ltrmPmt);
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

    /** set 자료코드 : datCd */
    public void setDatCd(String  datCd) { set( ATTR_DATCD ,datCd);}
    /** get 자료코드 : datCd */
    public String  getDatCd() { return (String )get( ATTR_DATCD );}

    /** set 건강보험납입월 : hlthAmtMn */
    public void setHlthAmtMn(String  hlthAmtMn) { set( ATTR_HLTHAMTMN ,hlthAmtMn);}
    /** get 건강보험납입월 : hlthAmtMn */
    public String  getHlthAmtMn() { return (String )get( ATTR_HLTHAMTMN );}

    /** set 건강보험료_보수월액_고지금액 : hiNtf */
    public void setHiNtf(Long  hiNtf) { set( ATTR_HINTF ,hiNtf);}
    /** get 건강보험료_보수월액_고지금액 : hiNtf */
    public Long  getHiNtf() { return (Long )get( ATTR_HINTF );}

    /** set 장기요양보험료_보수월액_고지금액 : ltrmNtf */
    public void setLtrmNtf(Long  ltrmNtf) { set( ATTR_LTRMNTF ,ltrmNtf);}
    /** get 장기요양보험료_보수월액_고지금액 : ltrmNtf */
    public Long  getLtrmNtf() { return (Long )get( ATTR_LTRMNTF );}

    /** set 건강보험료_소득월액_납부금액 : hiPmt */
    public void setHiPmt(Long  hiPmt) { set( ATTR_HIPMT ,hiPmt);}
    /** get 건강보험료_소득월액_납부금액 : hiPmt */
    public Long  getHiPmt() { return (Long )get( ATTR_HIPMT );}

    /** set 장기용양보험료_소득월액_납부금액 : ltrmPmt */
    public void setLtrmPmt(Long  ltrmPmt) { set( ATTR_LTRMPMT ,ltrmPmt);}
    /** get 장기용양보험료_소득월액_납부금액 : ltrmPmt */
    public Long  getLtrmPmt() { return (Long )get( ATTR_LTRMPMT );}

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
