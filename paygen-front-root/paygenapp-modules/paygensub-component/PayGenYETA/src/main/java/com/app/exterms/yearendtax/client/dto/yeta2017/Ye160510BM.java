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
public class Ye160510BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public static final String ATTR_WHDGDEBRBUSOPRRGSTNUM = "whdgDebrBusoprRgstnum";

    /** set 비과세감면구분코드 : freeDtyReduDivCd */
    public static final String ATTR_FREEDTYREDUDIVCD = "freeDtyReduDivCd";

    /** set 비과세감면합계금액 : freeDtyReduAggrSum */
    public static final String ATTR_FREEDTYREDUAGGRSUM = "freeDtyReduAggrSum";

    /** set 현근무지기지급금액 : currPaeWorkPayrfgSum */
    public static final String ATTR_CURRPAEWORKPAYRFGSUM = "currPaeWorkPayrfgSum";

    /** set 종전근무지기지급금액 : prcspPayrfgSum */
    public static final String ATTR_PRCSPPAYRFGSUM = "prcspPayrfgSum";

    /** set 비과세감면_과세전환금액 : freetyReduTxChngSum */
    public static final String ATTR_FREETYREDUTXCHNGSUM = "freetyReduTxChngSum";

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
     public Ye160510BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye160510BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  whdgDebrBusoprRgstnum 
    		, String  freeDtyReduDivCd 
    		, Long  freeDtyReduAggrSum 
    		, Long  currPaeWorkPayrfgSum 
    		, Long  prcspPayrfgSum 
    		, Long  freetyReduTxChngSum 
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
     	values.put(ATTR_WHDGDEBRBUSOPRRGSTNUM,whdgDebrBusoprRgstnum);
     	values.put(ATTR_FREEDTYREDUDIVCD,freeDtyReduDivCd);
     	values.put(ATTR_FREEDTYREDUAGGRSUM,freeDtyReduAggrSum);
     	values.put(ATTR_CURRPAEWORKPAYRFGSUM,currPaeWorkPayrfgSum);
     	values.put(ATTR_PRCSPPAYRFGSUM,prcspPayrfgSum);
     	values.put(ATTR_FREETYREDUTXCHNGSUM,freetyReduTxChngSum);
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

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public void setWhdgDebrBusoprRgstnum(String  whdgDebrBusoprRgstnum) { set( ATTR_WHDGDEBRBUSOPRRGSTNUM ,whdgDebrBusoprRgstnum);}
    /** get 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    public String  getWhdgDebrBusoprRgstnum() { return (String )get( ATTR_WHDGDEBRBUSOPRRGSTNUM );}

    /** set 비과세감면구분코드 : freeDtyReduDivCd */
    public void setFreeDtyReduDivCd(String  freeDtyReduDivCd) { set( ATTR_FREEDTYREDUDIVCD ,freeDtyReduDivCd);}
    /** get 비과세감면구분코드 : freeDtyReduDivCd */
    public String  getFreeDtyReduDivCd() { return (String )get( ATTR_FREEDTYREDUDIVCD );}

    /** set 비과세감면합계금액 : freeDtyReduAggrSum */
    public void setFreeDtyReduAggrSum(Long  freeDtyReduAggrSum) { set( ATTR_FREEDTYREDUAGGRSUM ,freeDtyReduAggrSum);}
    /** get 비과세감면합계금액 : freeDtyReduAggrSum */
    public Long  getFreeDtyReduAggrSum() { return (Long )get( ATTR_FREEDTYREDUAGGRSUM );}

    /** set 현근무지기지급금액 : currPaeWorkPayrfgSum */
    public void setCurrPaeWorkPayrfgSum(Long  currPaeWorkPayrfgSum) { set( ATTR_CURRPAEWORKPAYRFGSUM ,currPaeWorkPayrfgSum);}
    /** get 현근무지기지급금액 : currPaeWorkPayrfgSum */
    public Long  getCurrPaeWorkPayrfgSum() { return (Long )get( ATTR_CURRPAEWORKPAYRFGSUM );}

    /** set 종전근무지기지급금액 : prcspPayrfgSum */
    public void setPrcspPayrfgSum(Long  prcspPayrfgSum) { set( ATTR_PRCSPPAYRFGSUM ,prcspPayrfgSum);}
    /** get 종전근무지기지급금액 : prcspPayrfgSum */
    public Long  getPrcspPayrfgSum() { return (Long )get( ATTR_PRCSPPAYRFGSUM );}

    /** set 비과세감면_과세전환금액 : freetyReduTxChngSum */
    public void setFreetyReduTxChngSum(Long  freetyReduTxChngSum) { set( ATTR_FREETYREDUTXCHNGSUM ,freetyReduTxChngSum);}
    /** get 비과세감면_과세전환금액 : freetyReduTxChngSum */
    public Long  getFreetyReduTxChngSum() { return (Long )get( ATTR_FREETYREDUTXCHNGSUM );}

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
