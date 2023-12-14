package com.app.exterms.yearendtax.client.dto.yeta2019;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @Class Name : Ye161030BM.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161030BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 주민등록번호 : txprDscmNoCntn */
    public static final String ATTR_TXPRDSCMNOCNTN = "txprDscmNoCntn";

    /** set 부양관계코드 : suptFmlyRltClCd */
    public static final String ATTR_SUPTFMLYRLTCLCD = "suptFmlyRltClCd";

    /** set 내외국인구분 : nnfClCd */
    public static final String ATTR_NNFCLCD = "nnfClCd";

    /** set 성명 : txprNm */
    public static final String ATTR_TXPRNM = "txprNm";

    /** set 기본공제여부 : bscDdcClCd */
    public static final String ATTR_BSCDDCCLCD = "bscDdcClCd";

    /** set 장애인여부 : dsbrDdcClCd */
    public static final String ATTR_DSBRDDCCLCD = "dsbrDdcClCd";

    /** set 부녀자여부 : wmnDdcClCd */
    public static final String ATTR_WMNDDCCLCD = "wmnDdcClCd";

    /** set 경로우대여부 : sccDdcClCd */
    public static final String ATTR_SCCDDCCLCD = "sccDdcClCd";

    /** set 한부모여부 : snprntFmlyDdcClCd */
    public static final String ATTR_SNPRNTFMLYDDCCLCD = "snprntFmlyDdcClCd";

    /** set 출산입양여부 : chbtAtprDdcClCd */
    public static final String ATTR_CHBTATPRDDCCLCD = "chbtAtprDdcClCd";

    /** set 6세이하여부 : age6Lt 
    public static final String ATTR_AGE6LT = "age6Lt";*/
    
    /** set 자녀취학여부 : schoolYn */
    public static final String ATTR_SCHOOLYN = "schoolYn";

    /** set 교육비공제구분 : eduDdcDvcd */
    public static final String ATTR_EDUDDCDVCD = "eduDdcDvcd";

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
    
    /** set 인사가족관계코드 : famyRelaDivCd */
    public static final String ATTR_FAMYRELADIVCD = "famyRelaDivCd";

    /** 생성자 */
     public Ye161030BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161030BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  txprDscmNoCntn 
    		, String  suptFmlyRltClCd 
    		, String  nnfClCd 
    		, String  txprNm 
    		, String  bscDdcClCd 
    		, String  dsbrDdcClCd 
    		, String  wmnDdcClCd 
    		, String  sccDdcClCd 
    		, String  snprntFmlyDdcClCd 
    		, String  chbtAtprDdcClCd 
    		/*, String  age6Lt */
    		, String  schoolYN
    		, String  eduDdcDvcd 
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
     	values.put(ATTR_TXPRDSCMNOCNTN,txprDscmNoCntn);
     	values.put(ATTR_SUPTFMLYRLTCLCD,suptFmlyRltClCd);
     	values.put(ATTR_NNFCLCD,nnfClCd);
     	values.put(ATTR_TXPRNM,txprNm);
     	values.put(ATTR_BSCDDCCLCD,bscDdcClCd);
     	values.put(ATTR_DSBRDDCCLCD,dsbrDdcClCd);
     	values.put(ATTR_WMNDDCCLCD,wmnDdcClCd);
     	values.put(ATTR_SCCDDCCLCD,sccDdcClCd);
     	values.put(ATTR_SNPRNTFMLYDDCCLCD,snprntFmlyDdcClCd);
     	values.put(ATTR_CHBTATPRDDCCLCD,chbtAtprDdcClCd);
     	/*values.put(ATTR_AGE6LT,age6Lt);*/
     	values.put(ATTR_SCHOOLYN,schoolYN);
     	values.put(ATTR_EDUDDCDVCD,eduDdcDvcd);
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
    /** set 주민등록번호 : txprDscmNoCntn */
    public void setTxprDscmNoCntn(String  txprDscmNoCntn) { set( ATTR_TXPRDSCMNOCNTN ,txprDscmNoCntn);}
    /** get 주민등록번호 : txprDscmNoCntn */
    public String  getTxprDscmNoCntn() { return (String )get( ATTR_TXPRDSCMNOCNTN );}
    /** set 부양관계코드 : suptFmlyRltClCd */
    public void setSuptFmlyRltClCd(String  suptFmlyRltClCd) { set( ATTR_SUPTFMLYRLTCLCD ,suptFmlyRltClCd);}
    /** get 부양관계코드 : suptFmlyRltClCd */
    public String  getSuptFmlyRltClCd() { return (String )get( ATTR_SUPTFMLYRLTCLCD );}
    /** set 내외국인구분 : nnfClCd */
    public void setNnfClCd(String  nnfClCd) { set( ATTR_NNFCLCD ,nnfClCd);}
    /** get 내외국인구분 : nnfClCd */
    public String  getNnfClCd() { return (String )get( ATTR_NNFCLCD );}
    /** set 성명 : txprNm */
    public void setTxprNm(String  txprNm) { set( ATTR_TXPRNM ,txprNm);}
    /** get 성명 : txprNm */
    public String  getTxprNm() { return (String )get( ATTR_TXPRNM );}
    /** set 기본공제여부 : bscDdcClCd */
    public void setBscDdcClCd(String  bscDdcClCd) { set( ATTR_BSCDDCCLCD ,bscDdcClCd);}
    /** get 기본공제여부 : bscDdcClCd */
    public String  getBscDdcClCd() { return (String )get( ATTR_BSCDDCCLCD );}
    /** set 장애인여부 : dsbrDdcClCd */
    public void setDsbrDdcClCd(String  dsbrDdcClCd) { set( ATTR_DSBRDDCCLCD ,dsbrDdcClCd);}
    /** get 장애인여부 : dsbrDdcClCd */
    public String  getDsbrDdcClCd() { return (String )get( ATTR_DSBRDDCCLCD );}
    /** set 부녀자여부 : wmnDdcClCd */
    public void setWmnDdcClCd(String  wmnDdcClCd) { set( ATTR_WMNDDCCLCD ,wmnDdcClCd);}
    /** get 부녀자여부 : wmnDdcClCd */
    public String  getWmnDdcClCd() { return (String )get( ATTR_WMNDDCCLCD );}
    /** set 경로우대여부 : sccDdcClCd */
    public void setSccDdcClCd(String  sccDdcClCd) { set( ATTR_SCCDDCCLCD ,sccDdcClCd);}
    /** get 경로우대여부 : sccDdcClCd */
    public String  getSccDdcClCd() { return (String )get( ATTR_SCCDDCCLCD );}
    /** set 한부모여부 : snprntFmlyDdcClCd */
    public void setSnprntFmlyDdcClCd(String  snprntFmlyDdcClCd) { set( ATTR_SNPRNTFMLYDDCCLCD ,snprntFmlyDdcClCd);}
    /** get 한부모여부 : snprntFmlyDdcClCd */
    public String  getSnprntFmlyDdcClCd() { return (String )get( ATTR_SNPRNTFMLYDDCCLCD );}
    /** set 출산입양여부 : chbtAtprDdcClCd */
    public void setChbtAtprDdcClCd(String  chbtAtprDdcClCd) { set( ATTR_CHBTATPRDDCCLCD ,chbtAtprDdcClCd);}
    /** get 출산입양여부 : chbtAtprDdcClCd */
    public String  getChbtAtprDdcClCd() { return (String )get( ATTR_CHBTATPRDDCCLCD );}
    /** set 6세이하여부 : age6Lt 
    public void setAge6Lt(String  age6Lt) { set( ATTR_AGE6LT ,age6Lt);}*/
    /** get 6세이하여부 : age6Lt 
    public String  getAge6Lt() { return (String )get( ATTR_AGE6LT );}*/
    /** set 취학여부 : schoolYN */
    public void setSchoolYN(String  schoolYN) { set( ATTR_SCHOOLYN ,schoolYN);}
    /** get 취학여부 : schoolYN */
    public String  getSchoolYN() { return (String )get( ATTR_SCHOOLYN );}
    /** set 교육비공제구분 : eduDdcDvcd */
    public void setEduDdcDvcd(String  eduDdcDvcd) { set( ATTR_EDUDDCDVCD ,eduDdcDvcd);}
    /** get 교육비공제구분 : eduDdcDvcd */
    public String  getEduDdcDvcd() { return (String )get( ATTR_EDUDDCDVCD );}
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
    /** set 인사가족관계코드 : famyRelaDivCd */
    public void setFamyRelaDivCd(String  famyRelaDivCd) { set( ATTR_FAMYRELADIVCD ,famyRelaDivCd);}
    /** get 인사가족관계코드 : famyRelaDivCd */
    public String  getFamyRelaDivCd() { return (String )get( ATTR_FAMYRELADIVCD );}
    

}
