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
public class Ye167510BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속년도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 거주자성명 : fnm */
    public static final String ATTR_FNM = "fnm";

    /** set 생년월일 : resno */
    public static final String ATTR_RESNO = "resno";

    /** set 근무처명 : tnm */
    public static final String ATTR_TNM = "tnm";

    /** set 사업자등록번호 : bsnoEncCntn */
    public static final String ATTR_BSNOENCCNTN = "bsnoEncCntn";

    /** set 전통시장사용분공제금액 : tdmrDdcAmt */
    public static final String ATTR_TDMRDDCAMT = "tdmrDdcAmt";

    /** set 대중교통이용분공제금액 : pbtDdcAmt */
    public static final String ATTR_PBTDDCAMT = "pbtDdcAmt";

    /** set 직불카드등사용분공제금액 : drtpCardDdcAmt */
    public static final String ATTR_DRTPCARDDDCAMT = "drtpCardDdcAmt";
    
    /** set 제로페이사용분공제금액 : zrtdDdcAmt */
    public static final String ATTR_ZRTDDDCAMT = "zrtdDdcAmt";

    /** set 공제제외금액계산총급여액 : totaSnwAmt */
    public static final String ATTR_TOTASNWAMT = "totaSnwAmt";

    /** set 공제제외금액계산최저사용금액 : minmUseAmt */
    public static final String ATTR_MINMUSEAMT = "minmUseAmt";

    /** set 공제제외금액계산공제제외금액 : ddcExclAmt */
    public static final String ATTR_DDCEXCLAMT = "ddcExclAmt";

    /** set 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
    public static final String ATTR_ADDDDCRTDDCAMT = "addDdcrtDdcAmt";

    /** set 공제가능금액 : ddcPsbAmt */
    public static final String ATTR_DDCPSBAMT = "ddcPsbAmt";

    /** set 공제한도액 : ddcLmtAmt */
    public static final String ATTR_DDCLMTAMT = "ddcLmtAmt";

    /** set 일반공제금액 : gnrlDdcAmt */
    public static final String ATTR_GNRLDDCAMT = "gnrlDdcAmt";

    /** set 전통시장추가공제금액 : tdmrAddDdcAmt */
    public static final String ATTR_TDMRADDDDCAMT = "tdmrAddDdcAmt";

    /** set 대중교통추가공제금액 : pbtAddDdcAmt */
    public static final String ATTR_PBTADDDDCAMT = "pbtAddDdcAmt";

    /** set 최종공제금ㄴ액 : lstDdcAmt */
    public static final String ATTR_LSTDDCAMT = "lstDdcAmt";

    /** set 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
    public static final String ATTR_FTYRPRSCRDCUSEAMT = "ftyrPrsCrdcUseAmt";

    /** set 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
    public static final String ATTR_PYRPRSCRDCUSEAMT1 = "pyrPrsCrdcUseAmt1";

    /** set 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
    public static final String ATTR_FTYRPRSADDDDCRTAMT = "ftyrPrsAddDdcrtAmt";

    /** set 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
    public static final String ATTR_TYYRTFHYPRSADDDDCRTAMT = "tyYrTfhyPrsAddDdcrtAmt";

    /** set 신용카드사용분 공제금액 : crdcDdcAmt */
    public static final String ATTR_CRDCDDCAMT = "crdcDdcAmt";

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
     public Ye167510BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167510BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  formCd 
    		, String  fnm 
    		, String  resno 
    		, String  tnm 
    		, String  bsnoEncCntn 
    		, Long  tdmrDdcAmt 
    		, Long  pbtDdcAmt 
    		, Long  drtpCardDdcAmt
    		, Long	zrtdDdcAmt
    		, Long  totaSnwAmt 
    		, Long  minmUseAmt 
    		, Long  ddcExclAmt 
    		, Long  addDdcrtDdcAmt 
    		, Long  ddcPsbAmt 
    		, Long  ddcLmtAmt 
    		, Long  gnrlDdcAmt 
    		, Long  tdmrAddDdcAmt 
    		, Long  pbtAddDdcAmt 
    		, Long  lstDdcAmt 
    		, Long  ftyrPrsCrdcUseAmt 
    		, Long  pyrPrsCrdcUseAmt1 
    		, Long  ftyrPrsAddDdcrtAmt 
    		, Long  tyYrTfhyPrsAddDdcrtAmt 
    		, Long  crdcDdcAmt 
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
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_FNM,fnm);
     	values.put(ATTR_RESNO,resno);
     	values.put(ATTR_TNM,tnm);
     	values.put(ATTR_BSNOENCCNTN,bsnoEncCntn);
     	values.put(ATTR_TDMRDDCAMT,tdmrDdcAmt);
     	values.put(ATTR_PBTDDCAMT,pbtDdcAmt);
     	values.put(ATTR_DRTPCARDDDCAMT,drtpCardDdcAmt);
     	values.put(ATTR_ZRTDDDCAMT,zrtdDdcAmt);
     	values.put(ATTR_TOTASNWAMT,totaSnwAmt);
     	values.put(ATTR_MINMUSEAMT,minmUseAmt);
     	values.put(ATTR_DDCEXCLAMT,ddcExclAmt);
     	values.put(ATTR_ADDDDCRTDDCAMT,addDdcrtDdcAmt);
     	values.put(ATTR_DDCPSBAMT,ddcPsbAmt);
     	values.put(ATTR_DDCLMTAMT,ddcLmtAmt);
     	values.put(ATTR_GNRLDDCAMT,gnrlDdcAmt);
     	values.put(ATTR_TDMRADDDDCAMT,tdmrAddDdcAmt);
     	values.put(ATTR_PBTADDDDCAMT,pbtAddDdcAmt);
     	values.put(ATTR_LSTDDCAMT,lstDdcAmt);
     	values.put(ATTR_FTYRPRSCRDCUSEAMT,ftyrPrsCrdcUseAmt);
     	values.put(ATTR_PYRPRSCRDCUSEAMT1,pyrPrsCrdcUseAmt1);
     	values.put(ATTR_FTYRPRSADDDDCRTAMT,ftyrPrsAddDdcrtAmt);
     	values.put(ATTR_TYYRTFHYPRSADDDDCRTAMT,tyYrTfhyPrsAddDdcrtAmt);
     	values.put(ATTR_CRDCDDCAMT,crdcDdcAmt);
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

    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}

    /** set 거주자성명 : fnm */
    public void setFnm(String  fnm) { set( ATTR_FNM ,fnm);}
    /** get 거주자성명 : fnm */
    public String  getFnm() { return (String )get( ATTR_FNM );}

    /** set 생년월일 : resno */
    public void setResno(String  resno) { set( ATTR_RESNO ,resno);}
    /** get 생년월일 : resno */
    public String  getResno() { return (String )get( ATTR_RESNO );}

    /** set 근무처명 : tnm */
    public void setTnm(String  tnm) { set( ATTR_TNM ,tnm);}
    /** get 근무처명 : tnm */
    public String  getTnm() { return (String )get( ATTR_TNM );}

    /** set 사업자등록번호 : bsnoEncCntn */
    public void setBsnoEncCntn(String  bsnoEncCntn) { set( ATTR_BSNOENCCNTN ,bsnoEncCntn);}
    /** get 사업자등록번호 : bsnoEncCntn */
    public String  getBsnoEncCntn() { return (String )get( ATTR_BSNOENCCNTN );}

    /** set 전통시장사용분공제금액 : tdmrDdcAmt */
    public void setTdmrDdcAmt(Long  tdmrDdcAmt) { set( ATTR_TDMRDDCAMT ,tdmrDdcAmt);}
    /** get 전통시장사용분공제금액 : tdmrDdcAmt */
    public Long  getTdmrDdcAmt() { return (Long )get( ATTR_TDMRDDCAMT );}

    /** set 대중교통이용분공제금액 : pbtDdcAmt */
    public void setPbtDdcAmt(Long  pbtDdcAmt) { set( ATTR_PBTDDCAMT ,pbtDdcAmt);}
    /** get 대중교통이용분공제금액 : pbtDdcAmt */
    public Long  getPbtDdcAmt() { return (Long )get( ATTR_PBTDDCAMT );}

    /** set 직불카드등사용분공제금액 : drtpCardDdcAmt */
    public void setDrtpCardDdcAmt(Long  drtpCardDdcAmt) { set( ATTR_DRTPCARDDDCAMT ,drtpCardDdcAmt);}
    /** get 직불카드등사용분공제금액 : drtpCardDdcAmt */
    public Long  getDrtpCardDdcAmt() { return (Long )get( ATTR_DRTPCARDDDCAMT );}
    
    /** set 제로페이사용분공제금액 : zrtdDdcAmt */
    public void setZrtdDdcAmt(Long  zrtdDdcAmt) { set( ATTR_ZRTDDDCAMT ,zrtdDdcAmt);}
    /** get 제로페이사용분공제금액 : zrtdDdcAmt */
    public Long  getZrtdDdcAmt() { return (Long )get( ATTR_ZRTDDDCAMT );}

    /** set 공제제외금액계산총급여액 : totaSnwAmt */
    public void setTotaSnwAmt(Long  totaSnwAmt) { set( ATTR_TOTASNWAMT ,totaSnwAmt);}
    /** get 공제제외금액계산총급여액 : totaSnwAmt */
    public Long  getTotaSnwAmt() { return (Long )get( ATTR_TOTASNWAMT );}

    /** set 공제제외금액계산최저사용금액 : minmUseAmt */
    public void setMinmUseAmt(Long  minmUseAmt) { set( ATTR_MINMUSEAMT ,minmUseAmt);}
    /** get 공제제외금액계산최저사용금액 : minmUseAmt */
    public Long  getMinmUseAmt() { return (Long )get( ATTR_MINMUSEAMT );}

    /** set 공제제외금액계산공제제외금액 : ddcExclAmt */
    public void setDdcExclAmt(Long  ddcExclAmt) { set( ATTR_DDCEXCLAMT ,ddcExclAmt);}
    /** get 공제제외금액계산공제제외금액 : ddcExclAmt */
    public Long  getDdcExclAmt() { return (Long )get( ATTR_DDCEXCLAMT );}

    /** set 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
    public void setAddDdcrtDdcAmt(Long  addDdcrtDdcAmt) { set( ATTR_ADDDDCRTDDCAMT ,addDdcrtDdcAmt);}
    /** get 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
    public Long  getAddDdcrtDdcAmt() { return (Long )get( ATTR_ADDDDCRTDDCAMT );}

    /** set 공제가능금액 : ddcPsbAmt */
    public void setDdcPsbAmt(Long  ddcPsbAmt) { set( ATTR_DDCPSBAMT ,ddcPsbAmt);}
    /** get 공제가능금액 : ddcPsbAmt */
    public Long  getDdcPsbAmt() { return (Long )get( ATTR_DDCPSBAMT );}

    /** set 공제한도액 : ddcLmtAmt */
    public void setDdcLmtAmt(Long  ddcLmtAmt) { set( ATTR_DDCLMTAMT ,ddcLmtAmt);}
    /** get 공제한도액 : ddcLmtAmt */
    public Long  getDdcLmtAmt() { return (Long )get( ATTR_DDCLMTAMT );}

    /** set 일반공제금액 : gnrlDdcAmt */
    public void setGnrlDdcAmt(Long  gnrlDdcAmt) { set( ATTR_GNRLDDCAMT ,gnrlDdcAmt);}
    /** get 일반공제금액 : gnrlDdcAmt */
    public Long  getGnrlDdcAmt() { return (Long )get( ATTR_GNRLDDCAMT );}

    /** set 전통시장추가공제금액 : tdmrAddDdcAmt */
    public void setTdmrAddDdcAmt(Long  tdmrAddDdcAmt) { set( ATTR_TDMRADDDDCAMT ,tdmrAddDdcAmt);}
    /** get 전통시장추가공제금액 : tdmrAddDdcAmt */
    public Long  getTdmrAddDdcAmt() { return (Long )get( ATTR_TDMRADDDDCAMT );}

    /** set 대중교통추가공제금액 : pbtAddDdcAmt */
    public void setPbtAddDdcAmt(Long  pbtAddDdcAmt) { set( ATTR_PBTADDDDCAMT ,pbtAddDdcAmt);}
    /** get 대중교통추가공제금액 : pbtAddDdcAmt */
    public Long  getPbtAddDdcAmt() { return (Long )get( ATTR_PBTADDDDCAMT );}

    /** set 최종공제금ㄴ액 : lstDdcAmt */
    public void setLstDdcAmt(Long  lstDdcAmt) { set( ATTR_LSTDDCAMT ,lstDdcAmt);}
    /** get 최종공제금ㄴ액 : lstDdcAmt */
    public Long  getLstDdcAmt() { return (Long )get( ATTR_LSTDDCAMT );}

    /** set 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
    public void setFtyrPrsCrdcUseAmt(Long  ftyrPrsCrdcUseAmt) { set( ATTR_FTYRPRSCRDCUSEAMT ,ftyrPrsCrdcUseAmt);}
    /** get 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
    public Long  getFtyrPrsCrdcUseAmt() { return (Long )get( ATTR_FTYRPRSCRDCUSEAMT );}

    /** set 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
    public void setPyrPrsCrdcUseAmt1(Long  pyrPrsCrdcUseAmt1) { set( ATTR_PYRPRSCRDCUSEAMT1 ,pyrPrsCrdcUseAmt1);}
    /** get 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
    public Long  getPyrPrsCrdcUseAmt1() { return (Long )get( ATTR_PYRPRSCRDCUSEAMT1 );}

    /** set 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
    public void setFtyrPrsAddDdcrtAmt(Long  ftyrPrsAddDdcrtAmt) { set( ATTR_FTYRPRSADDDDCRTAMT ,ftyrPrsAddDdcrtAmt);}
    /** get 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
    public Long  getFtyrPrsAddDdcrtAmt() { return (Long )get( ATTR_FTYRPRSADDDDCRTAMT );}

    /** set 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
    public void setTyYrTfhyPrsAddDdcrtAmt(Long  tyYrTfhyPrsAddDdcrtAmt) { set( ATTR_TYYRTFHYPRSADDDDCRTAMT ,tyYrTfhyPrsAddDdcrtAmt);}
    /** get 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
    public Long  getTyYrTfhyPrsAddDdcrtAmt() { return (Long )get( ATTR_TYYRTFHYPRSADDDDCRTAMT );}

    /** set 신용카드사용분 공제금액 : crdcDdcAmt */
    public void setCrdcDdcAmt(Long  crdcDdcAmt) { set( ATTR_CRDCDDCAMT ,crdcDdcAmt);}
    /** get 신용카드사용분 공제금액 : crdcDdcAmt */
    public Long  getCrdcDdcAmt() { return (Long )get( ATTR_CRDCDDCAMT );}

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
