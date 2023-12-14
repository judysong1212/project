package com.app.exterms.yearendtax.client.dto.yeta2020;



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
public class Ye167080BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 교육비_초중고등학교_교육비공제대상구분코드 : scxpsStd */
    public static final String ATTR_SCXPSSTD = "scxpsStd";

    /** set 가족주민등록번호 : famResnoEncCntn */
    public static final String ATTR_FAMRESNOENCCNTN = "famResnoEncCntn";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 교육비지출금액 : scxpsUseAmt */
    public static final String ATTR_SCXPSUSEAMT = "scxpsUseAmt";

    /** set 교육비_초중고등학교_개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
    public static final String ATTR_SCXPSSTDDDCTRGTINDVAMT = "scxpsStdDdcTrgtIndvAmt";

    /** set 교육비_초중고등학교_생년월일 : bhdt */
    public static final String ATTR_BHDT = "bhdt";

    /** set 교육비_초중고등학교_성명 : suptFmlyFnm */
    public static final String ATTR_SUPTFMLYFNM = "suptFmlyFnm";

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
     public Ye167080BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167080BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  scxpsStd 
    		, String  famResnoEncCntn 
    		, String  clutSeptCd 
    		, Long  scxpsUseAmt 
    		, Long  scxpsStdDdcTrgtIndvAmt 
    		, String  bhdt 
    		, String  suptFmlyFnm 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_SCXPSSTD,scxpsStd);
     	values.put(ATTR_FAMRESNOENCCNTN,famResnoEncCntn);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SCXPSUSEAMT,scxpsUseAmt);
     	values.put(ATTR_SCXPSSTDDDCTRGTINDVAMT,scxpsStdDdcTrgtIndvAmt);
     	values.put(ATTR_BHDT,bhdt);
     	values.put(ATTR_SUPTFMLYFNM,suptFmlyFnm);
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

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}

    /** set 교육비_초중고등학교_교육비공제대상구분코드 : scxpsStd */
    public void setScxpsStd(String  scxpsStd) { set( ATTR_SCXPSSTD ,scxpsStd);}
    /** get 교육비_초중고등학교_교육비공제대상구분코드 : scxpsStd */
    public String  getScxpsStd() { return (String )get( ATTR_SCXPSSTD );}

    /** set 가족주민등록번호 : famResnoEncCntn */
    public void setFamResnoEncCntn(String  famResnoEncCntn) { set( ATTR_FAMRESNOENCCNTN ,famResnoEncCntn);}
    /** get 가족주민등록번호 : famResnoEncCntn */
    public String  getFamResnoEncCntn() { return (String )get( ATTR_FAMRESNOENCCNTN );}

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 교육비지출금액 : scxpsUseAmt */
    public void setScxpsUseAmt(Long  scxpsUseAmt) { set( ATTR_SCXPSUSEAMT ,scxpsUseAmt);}
    /** get 교육비지출금액 : scxpsUseAmt */
    public Long  getScxpsUseAmt() { return (Long )get( ATTR_SCXPSUSEAMT );}

    /** set 교육비_초중고등학교_개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
    public void setScxpsStdDdcTrgtIndvAmt(Long  scxpsStdDdcTrgtIndvAmt) { set( ATTR_SCXPSSTDDDCTRGTINDVAMT ,scxpsStdDdcTrgtIndvAmt);}
    /** get 교육비_초중고등학교_개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
    public Long  getScxpsStdDdcTrgtIndvAmt() { return (Long )get( ATTR_SCXPSSTDDDCTRGTINDVAMT );}

    /** set 교육비_초중고등학교_생년월일 : bhdt */
    public void setBhdt(String  bhdt) { set( ATTR_BHDT ,bhdt);}
    /** get 교육비_초중고등학교_생년월일 : bhdt */
    public String  getBhdt() { return (String )get( ATTR_BHDT );}

    /** set 교육비_초중고등학교_성명 : suptFmlyFnm */
    public void setSuptFmlyFnm(String  suptFmlyFnm) { set( ATTR_SUPTFMLYFNM ,suptFmlyFnm);}
    /** get 교육비_초중고등학교_성명 : suptFmlyFnm */
    public String  getSuptFmlyFnm() { return (String )get( ATTR_SUPTFMLYFNM );}

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
