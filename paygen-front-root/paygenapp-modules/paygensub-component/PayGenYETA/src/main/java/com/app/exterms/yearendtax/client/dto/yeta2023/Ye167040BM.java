package com.app.exterms.yearendtax.client.dto.yeta2023;



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
public class Ye167040BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
    public static final String ATTR_NPHTHRWAINFEEAMT = "npHthrWaInfeeAmt";

    /** set 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
    public static final String ATTR_NPHTHRWAINFEEDDCAMT = "npHthrWaInfeeDdcAmt";

    /** set 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
    public static final String ATTR_NPHTHRMCURWKARINFEEAMT = "npHthrMcurWkarInfeeAmt";

    /** set 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
    public static final String ATTR_NPHTHRMCURWKARDDCAMT = "npHthrMcurWkarDdcAmt";

    /** set 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
    public static final String ATTR_HTHRPBLCPNSNINFEEAMT = "hthrPblcPnsnInfeeAmt";

    /** set 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
    public static final String ATTR_HTHRPBLCPNSNINFEEDDCAMT = "hthrPblcPnsnInfeeDdcAmt";

    /** set 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
    public static final String ATTR_MCURPBLCPNSNINFEEAMT = "mcurPblcPnsnInfeeAmt";

    /** set 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
    public static final String ATTR_MCURPBLCPNSNINFEEDDCAMT = "mcurPblcPnsnInfeeDdcAmt";

    /** set 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
    public static final String ATTR_PNSNINFEEUSEAMTSUM = "pnsnInfeeUseAmtSum";

    /** set 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
    public static final String ATTR_PNSNINFEEDDCAMTSUM = "pnsnInfeeDdcAmtSum";

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
     public Ye167040BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167040BM(
    		 String  systemkey 
    		, String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, Long  npHthrWaInfeeAmt 
    		, Long  npHthrWaInfeeDdcAmt 
    		, Long  npHthrMcurWkarInfeeAmt 
    		, Long  npHthrMcurWkarDdcAmt 
    		, Long  hthrPblcPnsnInfeeAmt 
    		, Long  hthrPblcPnsnInfeeDdcAmt 
    		, Long  mcurPblcPnsnInfeeAmt 
    		, Long  mcurPblcPnsnInfeeDdcAmt 
    		, Long  pnsnInfeeUseAmtSum 
    		, Long  pnsnInfeeDdcAmtSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_NPHTHRWAINFEEAMT,npHthrWaInfeeAmt);
     	values.put(ATTR_NPHTHRWAINFEEDDCAMT,npHthrWaInfeeDdcAmt);
     	values.put(ATTR_NPHTHRMCURWKARINFEEAMT,npHthrMcurWkarInfeeAmt);
     	values.put(ATTR_NPHTHRMCURWKARDDCAMT,npHthrMcurWkarDdcAmt);
     	values.put(ATTR_HTHRPBLCPNSNINFEEAMT,hthrPblcPnsnInfeeAmt);
     	values.put(ATTR_HTHRPBLCPNSNINFEEDDCAMT,hthrPblcPnsnInfeeDdcAmt);
     	values.put(ATTR_MCURPBLCPNSNINFEEAMT,mcurPblcPnsnInfeeAmt);
     	values.put(ATTR_MCURPBLCPNSNINFEEDDCAMT,mcurPblcPnsnInfeeDdcAmt);
     	values.put(ATTR_PNSNINFEEUSEAMTSUM,pnsnInfeeUseAmtSum);
     	values.put(ATTR_PNSNINFEEDDCAMTSUM,pnsnInfeeDdcAmtSum);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
    public void setNpHthrWaInfeeAmt(Long  npHthrWaInfeeAmt) { set( ATTR_NPHTHRWAINFEEAMT ,npHthrWaInfeeAmt);}
    /** get 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
    public Long  getNpHthrWaInfeeAmt() { return (Long )get( ATTR_NPHTHRWAINFEEAMT );}

    /** set 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
    public void setNpHthrWaInfeeDdcAmt(Long  npHthrWaInfeeDdcAmt) { set( ATTR_NPHTHRWAINFEEDDCAMT ,npHthrWaInfeeDdcAmt);}
    /** get 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
    public Long  getNpHthrWaInfeeDdcAmt() { return (Long )get( ATTR_NPHTHRWAINFEEDDCAMT );}

    /** set 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
    public void setNpHthrMcurWkarInfeeAmt(Long  npHthrMcurWkarInfeeAmt) { set( ATTR_NPHTHRMCURWKARINFEEAMT ,npHthrMcurWkarInfeeAmt);}
    /** get 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
    public Long  getNpHthrMcurWkarInfeeAmt() { return (Long )get( ATTR_NPHTHRMCURWKARINFEEAMT );}

    /** set 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
    public void setNpHthrMcurWkarDdcAmt(Long  npHthrMcurWkarDdcAmt) { set( ATTR_NPHTHRMCURWKARDDCAMT ,npHthrMcurWkarDdcAmt);}
    /** get 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
    public Long  getNpHthrMcurWkarDdcAmt() { return (Long )get( ATTR_NPHTHRMCURWKARDDCAMT );}

    /** set 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
    public void setHthrPblcPnsnInfeeAmt(Long  hthrPblcPnsnInfeeAmt) { set( ATTR_HTHRPBLCPNSNINFEEAMT ,hthrPblcPnsnInfeeAmt);}
    /** get 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
    public Long  getHthrPblcPnsnInfeeAmt() { return (Long )get( ATTR_HTHRPBLCPNSNINFEEAMT );}

    /** set 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
    public void setHthrPblcPnsnInfeeDdcAmt(Long  hthrPblcPnsnInfeeDdcAmt) { set( ATTR_HTHRPBLCPNSNINFEEDDCAMT ,hthrPblcPnsnInfeeDdcAmt);}
    /** get 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
    public Long  getHthrPblcPnsnInfeeDdcAmt() { return (Long )get( ATTR_HTHRPBLCPNSNINFEEDDCAMT );}

    /** set 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
    public void setMcurPblcPnsnInfeeAmt(Long  mcurPblcPnsnInfeeAmt) { set( ATTR_MCURPBLCPNSNINFEEAMT ,mcurPblcPnsnInfeeAmt);}
    /** get 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
    public Long  getMcurPblcPnsnInfeeAmt() { return (Long )get( ATTR_MCURPBLCPNSNINFEEAMT );}

    /** set 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
    public void setMcurPblcPnsnInfeeDdcAmt(Long  mcurPblcPnsnInfeeDdcAmt) { set( ATTR_MCURPBLCPNSNINFEEDDCAMT ,mcurPblcPnsnInfeeDdcAmt);}
    /** get 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
    public Long  getMcurPblcPnsnInfeeDdcAmt() { return (Long )get( ATTR_MCURPBLCPNSNINFEEDDCAMT );}

    /** set 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
    public void setPnsnInfeeUseAmtSum(Long  pnsnInfeeUseAmtSum) { set( ATTR_PNSNINFEEUSEAMTSUM ,pnsnInfeeUseAmtSum);}
    /** get 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
    public Long  getPnsnInfeeUseAmtSum() { return (Long )get( ATTR_PNSNINFEEUSEAMTSUM );}

    /** set 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
    public void setPnsnInfeeDdcAmtSum(Long  pnsnInfeeDdcAmtSum) { set( ATTR_PNSNINFEEDDCAMTSUM ,pnsnInfeeDdcAmtSum);}
    /** get 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
    public Long  getPnsnInfeeDdcAmtSum() { return (Long )get( ATTR_PNSNINFEEDDCAMTSUM );}

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
