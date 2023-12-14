package com.app.exterms.yearendtax.client.dto.yeta2017;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * @Class Name : Ye162010BM.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162010BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";
    

    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNCD = "taxVvalKrnCd";
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
    public static final String ATTR_TAXVVALKRNNM = "taxVvalKrnNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 계좌번호_증권번호 : pnsnSvngAccAccno */
    public static final String ATTR_PNSNSVNGACCACCNO = "pnsnSvngAccAccno";

    /** set 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
    public static final String ATTR_PNSNSVNGACCPNSNSVNGCL = "pnsnSvngAccPnsnSvngCl";

    /** set 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
    public static final String ATTR_PNSNSVNGFNNORGNCD = "pnsnSvngFnnOrgnCd";

    /** set 굼융회사등명 : pnsnSvngAccFnnCmp */
    public static final String ATTR_PNSNSVNGACCFNNCMP = "pnsnSvngAccFnnCmp";

    /** set 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
    public static final String ATTR_PNSNSVNGACCPYMAMT = "pnsnSvngAccPymAmt";

    /** set 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
    public static final String ATTR_IPNSNSVNGACCDDCAMT = "ipnsnSvngAccddcAmt";

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
     public Ye162010BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye162010BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  pnsnSvngAccAccno 
    		, String  pnsnSvngAccPnsnSvngCl 
    		, String  pnsnSvngFnnOrgnCd 
    		, String  pnsnSvngAccFnnCmp 
    		, Long  pnsnSvngAccPymAmt 
    		, Long  ipnsnSvngAccddcAmt 
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
     	values.put(ATTR_PNSNSVNGACCACCNO,pnsnSvngAccAccno);
     	values.put(ATTR_PNSNSVNGACCPNSNSVNGCL,pnsnSvngAccPnsnSvngCl);
     	values.put(ATTR_PNSNSVNGFNNORGNCD,pnsnSvngFnnOrgnCd);
     	values.put(ATTR_PNSNSVNGACCFNNCMP,pnsnSvngAccFnnCmp);
     	values.put(ATTR_PNSNSVNGACCPYMAMT,pnsnSvngAccPymAmt);
     	values.put(ATTR_IPNSNSVNGACCDDCAMT,ipnsnSvngAccddcAmt);
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
    /** set 계좌번호_증권번호 : pnsnSvngAccAccno */
    public void setPnsnSvngAccAccno(String  pnsnSvngAccAccno) { set( ATTR_PNSNSVNGACCACCNO ,pnsnSvngAccAccno);}
    /** get 계좌번호_증권번호 : pnsnSvngAccAccno */
    public String  getPnsnSvngAccAccno() { return (String )get( ATTR_PNSNSVNGACCACCNO );}
    /** set 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
    public void setPnsnSvngAccPnsnSvngCl(String  pnsnSvngAccPnsnSvngCl) { set( ATTR_PNSNSVNGACCPNSNSVNGCL ,pnsnSvngAccPnsnSvngCl);}
    /** get 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
    public String  getPnsnSvngAccPnsnSvngCl() { return (String )get( ATTR_PNSNSVNGACCPNSNSVNGCL );}
    /** set 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
    public void setPnsnSvngFnnOrgnCd(String  pnsnSvngFnnOrgnCd) { set( ATTR_PNSNSVNGFNNORGNCD ,pnsnSvngFnnOrgnCd);}
    /** get 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
    public String  getPnsnSvngFnnOrgnCd() { return (String )get( ATTR_PNSNSVNGFNNORGNCD );}
    /** set 굼융회사등명 : pnsnSvngAccFnnCmp */
    public void setPnsnSvngAccFnnCmp(String  pnsnSvngAccFnnCmp) { set( ATTR_PNSNSVNGACCFNNCMP ,pnsnSvngAccFnnCmp);}
    /** get 굼융회사등명 : pnsnSvngAccFnnCmp */
    public String  getPnsnSvngAccFnnCmp() { return (String )get( ATTR_PNSNSVNGACCFNNCMP );}
    /** set 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
    public void setPnsnSvngAccPymAmt(Long  pnsnSvngAccPymAmt) { set( ATTR_PNSNSVNGACCPYMAMT ,pnsnSvngAccPymAmt);}
    /** get 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
    public Long  getPnsnSvngAccPymAmt() { return (Long )get( ATTR_PNSNSVNGACCPYMAMT );}
    /** set 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
    public void setIpnsnSvngAccddcAmt(Long  ipnsnSvngAccddcAmt) { set( ATTR_IPNSNSVNGACCDDCAMT ,ipnsnSvngAccddcAmt);}
    /** get 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
    public Long  getIpnsnSvngAccddcAmt() { return (Long )get( ATTR_IPNSNSVNGACCDDCAMT );}
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
    
    /** set 국세청자료구분코드 : taxVvalKrnCd */
	public void setTaxVvalKrnCd(String  taxVvalKrnCd) { set( ATTR_TAXVVALKRNCD ,taxVvalKrnCd);}
	/** get 국세청자료구분코드 : taxVvalKrnCd */
	public String  getTaxVvalKrnCd() { return (String )get( ATTR_TAXVVALKRNCD );}
	
	/** set 국세청자료구분코드 : taxVvalKrnNm */
	public void setTaxVvalKrnNm(String  taxVvalKrnNm) { set( ATTR_TAXVVALKRNNM ,taxVvalKrnNm);}
	/** get 국세청자료구분코드 : taxVvalKrnNm */
	public String  getTaxVvalKrnNm() { return (String )get( ATTR_TAXVVALKRNNM );}

  

}
