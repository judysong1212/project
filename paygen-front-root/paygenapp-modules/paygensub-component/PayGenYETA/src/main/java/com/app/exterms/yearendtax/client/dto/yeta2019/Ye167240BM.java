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
public class Ye167240BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호_사업자번호 : xprDscmNoEncCntn */
    public static final String ATTR_XPRDSCMNOENCCNTN = "xprDscmNoEncCntn";

    /** set 계약서상임대차계약기간개시일자 : ctrTermStrtDt */
    public static final String ATTR_CTRTERMSTRTDT = "ctrTermStrtDt";

    /** set 임대인성명_상호명 : lsorFnm */
    public static final String ATTR_LSORFNM = "lsorFnm";

    /** set 주택유형 : hsngTypeClCd */
    public static final String ATTR_HSNGTYPECLCD = "hsngTypeClCd";

    /** set 주택계약면적 : hsngCtrSfl */
    public static final String ATTR_HSNGCTRSFL = "hsngCtrSfl";

    /** set 임대차계약서상주소지 : lsrnCtrpAdr */
    public static final String ATTR_LSRNCTRPADR = "lsrnCtrpAdr";

    /** set 계약서상임대차계약기간종료일자 : ctrrTermEndDt */
    public static final String ATTR_CTRRTERMENDDT = "ctrrTermEndDt";

    /** set 임대차계약_전세보증금액 : lfhDpit */
    public static final String ATTR_LFHDPIT = "lfhDpit";

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
     public Ye167240BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167240BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  xprDscmNoEncCntn 
    		, String  ctrTermStrtDt 
    		, String  lsorFnm 
    		, String  hsngTypeClCd 
    		, Long  hsngCtrSfl 
    		, String  lsrnCtrpAdr 
    		, String  ctrrTermEndDt 
    		, Long  lfhDpit 
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
     	values.put(ATTR_XPRDSCMNOENCCNTN,xprDscmNoEncCntn);
     	values.put(ATTR_CTRTERMSTRTDT,ctrTermStrtDt);
     	values.put(ATTR_LSORFNM,lsorFnm);
     	values.put(ATTR_HSNGTYPECLCD,hsngTypeClCd);
     	values.put(ATTR_HSNGCTRSFL,hsngCtrSfl);
     	values.put(ATTR_LSRNCTRPADR,lsrnCtrpAdr);
     	values.put(ATTR_CTRRTERMENDDT,ctrrTermEndDt);
     	values.put(ATTR_LFHDPIT,lfhDpit);
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

    /** set 주민등록번호_사업자번호 : xprDscmNoEncCntn */
    public void setXprDscmNoEncCntn(String  xprDscmNoEncCntn) { set( ATTR_XPRDSCMNOENCCNTN ,xprDscmNoEncCntn);}
    /** get 주민등록번호_사업자번호 : xprDscmNoEncCntn */
    public String  getXprDscmNoEncCntn() { return (String )get( ATTR_XPRDSCMNOENCCNTN );}

    /** set 계약서상임대차계약기간개시일자 : ctrTermStrtDt */
    public void setCtrTermStrtDt(String  ctrTermStrtDt) { set( ATTR_CTRTERMSTRTDT ,ctrTermStrtDt);}
    /** get 계약서상임대차계약기간개시일자 : ctrTermStrtDt */
    public String  getCtrTermStrtDt() { return (String )get( ATTR_CTRTERMSTRTDT );}

    /** set 임대인성명_상호명 : lsorFnm */
    public void setLsorFnm(String  lsorFnm) { set( ATTR_LSORFNM ,lsorFnm);}
    /** get 임대인성명_상호명 : lsorFnm */
    public String  getLsorFnm() { return (String )get( ATTR_LSORFNM );}

    /** set 주택유형 : hsngTypeClCd */
    public void setHsngTypeClCd(String  hsngTypeClCd) { set( ATTR_HSNGTYPECLCD ,hsngTypeClCd);}
    /** get 주택유형 : hsngTypeClCd */
    public String  getHsngTypeClCd() { return (String )get( ATTR_HSNGTYPECLCD );}

    /** set 주택계약면적 : hsngCtrSfl */
    public void setHsngCtrSfl(Long  hsngCtrSfl) { set( ATTR_HSNGCTRSFL ,hsngCtrSfl);}
    /** get 주택계약면적 : hsngCtrSfl */
    public Long  getHsngCtrSfl() { return (Long )get( ATTR_HSNGCTRSFL );}

    /** set 임대차계약서상주소지 : lsrnCtrpAdr */
    public void setLsrnCtrpAdr(String  lsrnCtrpAdr) { set( ATTR_LSRNCTRPADR ,lsrnCtrpAdr);}
    /** get 임대차계약서상주소지 : lsrnCtrpAdr */
    public String  getLsrnCtrpAdr() { return (String )get( ATTR_LSRNCTRPADR );}

    /** set 계약서상임대차계약기간종료일자 : ctrrTermEndDt */
    public void setCtrrTermEndDt(String  ctrrTermEndDt) { set( ATTR_CTRRTERMENDDT ,ctrrTermEndDt);}
    /** get 계약서상임대차계약기간종료일자 : ctrrTermEndDt */
    public String  getCtrrTermEndDt() { return (String )get( ATTR_CTRRTERMENDDT );}

    /** set 임대차계약_전세보증금액 : lfhDpit */
    public void setLfhDpit(Long  lfhDpit) { set( ATTR_LFHDPIT ,lfhDpit);}
    /** get 임대차계약_전세보증금액 : lfhDpit */
    public Long  getLfhDpit() { return (Long )get( ATTR_LFHDPIT );}

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
