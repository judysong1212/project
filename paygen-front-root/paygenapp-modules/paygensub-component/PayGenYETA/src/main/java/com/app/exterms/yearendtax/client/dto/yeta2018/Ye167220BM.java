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
public class Ye167220BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호_사업자번호 : txprDscmNoEncCntn */
    public static final String ATTR_TXPRDSCMNOENCCNTN = "txprDscmNoEncCntn";

    /** set 계약서상임대차계약기간개시일자 : mmrCtrTermStrtDt */
    public static final String ATTR_MMRCTRTERMSTRTDT = "mmrCtrTermStrtDt";

    /** set 임대인성명_상호명 : lsorFnm */
    public static final String ATTR_LSORFNM = "lsorFnm";

    /** set 주택유형 : hsngTypeClCd */
    public static final String ATTR_HSNGTYPECLCD = "hsngTypeClCd";

    /** set 주택계약면적 : hsngCtrSfl */
    public static final String ATTR_HSNGCTRSFL = "hsngCtrSfl";

    /** set 임대차계약서상주소지 : mmrLsrnCtrpAdr */
    public static final String ATTR_MMRLSRNCTRPADR = "mmrLsrnCtrpAdr";

    /** set 계약서상임대차계약기간종료일자 : mmrCtrTermEndDt */
    public static final String ATTR_MMRCTRTERMENDDT = "mmrCtrTermEndDt";

    /** set 연간월세액 : useAmt */
    public static final String ATTR_USEAMT = "useAmt";

    /** set 월세액세액공제금액 : mmrDdcAmt */
    public static final String ATTR_MMRDDCAMT = "mmrDdcAmt";

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
     public Ye167220BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167220BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  txprDscmNoEncCntn 
    		, String  mmrCtrTermStrtDt 
    		, String  lsorFnm 
    		, String  hsngTypeClCd 
    		, Long  hsngCtrSfl 
    		, String  mmrLsrnCtrpAdr 
    		, String  mmrCtrTermEndDt 
    		, Long  useAmt 
    		, Long  mmrDdcAmt 
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
     	values.put(ATTR_TXPRDSCMNOENCCNTN,txprDscmNoEncCntn);
     	values.put(ATTR_MMRCTRTERMSTRTDT,mmrCtrTermStrtDt);
     	values.put(ATTR_LSORFNM,lsorFnm);
     	values.put(ATTR_HSNGTYPECLCD,hsngTypeClCd);
     	values.put(ATTR_HSNGCTRSFL,hsngCtrSfl);
     	values.put(ATTR_MMRLSRNCTRPADR,mmrLsrnCtrpAdr);
     	values.put(ATTR_MMRCTRTERMENDDT,mmrCtrTermEndDt);
     	values.put(ATTR_USEAMT,useAmt);
     	values.put(ATTR_MMRDDCAMT,mmrDdcAmt);
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

    /** set 주민등록번호_사업자번호 : txprDscmNoEncCntn */
    public void setTxprDscmNoEncCntn(String  txprDscmNoEncCntn) { set( ATTR_TXPRDSCMNOENCCNTN ,txprDscmNoEncCntn);}
    /** get 주민등록번호_사업자번호 : txprDscmNoEncCntn */
    public String  getTxprDscmNoEncCntn() { return (String )get( ATTR_TXPRDSCMNOENCCNTN );}

    /** set 계약서상임대차계약기간개시일자 : mmrCtrTermStrtDt */
    public void setMmrCtrTermStrtDt(String  mmrCtrTermStrtDt) { set( ATTR_MMRCTRTERMSTRTDT ,mmrCtrTermStrtDt);}
    /** get 계약서상임대차계약기간개시일자 : mmrCtrTermStrtDt */
    public String  getMmrCtrTermStrtDt() { return (String )get( ATTR_MMRCTRTERMSTRTDT );}

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

    /** set 임대차계약서상주소지 : mmrLsrnCtrpAdr */
    public void setMmrLsrnCtrpAdr(String  mmrLsrnCtrpAdr) { set( ATTR_MMRLSRNCTRPADR ,mmrLsrnCtrpAdr);}
    /** get 임대차계약서상주소지 : mmrLsrnCtrpAdr */
    public String  getMmrLsrnCtrpAdr() { return (String )get( ATTR_MMRLSRNCTRPADR );}

    /** set 계약서상임대차계약기간종료일자 : mmrCtrTermEndDt */
    public void setMmrCtrTermEndDt(String  mmrCtrTermEndDt) { set( ATTR_MMRCTRTERMENDDT ,mmrCtrTermEndDt);}
    /** get 계약서상임대차계약기간종료일자 : mmrCtrTermEndDt */
    public String  getMmrCtrTermEndDt() { return (String )get( ATTR_MMRCTRTERMENDDT );}

    /** set 연간월세액 : useAmt */
    public void setUseAmt(Long  useAmt) { set( ATTR_USEAMT ,useAmt);}
    /** get 연간월세액 : useAmt */
    public Long  getUseAmt() { return (Long )get( ATTR_USEAMT );}

    /** set 월세액세액공제금액 : mmrDdcAmt */
    public void setMmrDdcAmt(Long  mmrDdcAmt) { set( ATTR_MMRDDCAMT ,mmrDdcAmt);}
    /** get 월세액세액공제금액 : mmrDdcAmt */
    public Long  getMmrDdcAmt() { return (Long )get( ATTR_MMRDDCAMT );}

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
