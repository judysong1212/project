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
public class Ye167430BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

    /** set 가족관계구분코드 : famRltClCd */
    public static final String ATTR_FAMRLTCLCD = "famRltClCd";

    /** set 기부금총합계 : amtSum */
    public static final String ATTR_AMTSUM = "amtSum";

    /** set 기부금_법정기부금_10 : amt10 */
    public static final String ATTR_AMT10 = "amt10";

    /** set 기부금_정치자금기부금_20 : amt20 */
    public static final String ATTR_AMT20 = "amt20";

    /** set 기부금_종교단체외지정기부금_40 : amt40 */
    public static final String ATTR_AMT40 = "amt40";

    /** set 기부금_종교단체지정기부금_41 : amt41 */
    public static final String ATTR_AMT41 = "amt41";

    /** set 기부금_우리사주조합기부금_42 : amt42 */
    public static final String ATTR_AMT42 = "amt42";

    /** set 기부금_공제제외기부금_50 : amt50 */
    public static final String ATTR_AMT50 = "amt50";

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
     public Ye167430BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye167430BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  famRltClCd 
    		, Long  amtSum 
    		, Long  amt10 
    		, Long  amt20 
    		, Long  amt40 
    		, Long  amt41 
    		, Long  amt42 
    		, Long  amt50 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_FAMRLTCLCD,famRltClCd);
     	values.put(ATTR_AMTSUM,amtSum);
     	values.put(ATTR_AMT10,amt10);
     	values.put(ATTR_AMT20,amt20);
     	values.put(ATTR_AMT40,amt40);
     	values.put(ATTR_AMT41,amt41);
     	values.put(ATTR_AMT42,amt42);
     	values.put(ATTR_AMT50,amt50);
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

    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}

    /** set 가족관계구분코드 : famRltClCd */
    public void setFamRltClCd(String  famRltClCd) { set( ATTR_FAMRLTCLCD ,famRltClCd);}
    /** get 가족관계구분코드 : famRltClCd */
    public String  getFamRltClCd() { return (String )get( ATTR_FAMRLTCLCD );}

    /** set 기부금총합계 : amtSum */
    public void setAmtSum(Long  amtSum) { set( ATTR_AMTSUM ,amtSum);}
    /** get 기부금총합계 : amtSum */
    public Long  getAmtSum() { return (Long )get( ATTR_AMTSUM );}

    /** set 기부금_법정기부금_10 : amt10 */
    public void setAmt10(Long  amt10) { set( ATTR_AMT10 ,amt10);}
    /** get 기부금_법정기부금_10 : amt10 */
    public Long  getAmt10() { return (Long )get( ATTR_AMT10 );}

    /** set 기부금_정치자금기부금_20 : amt20 */
    public void setAmt20(Long  amt20) { set( ATTR_AMT20 ,amt20);}
    /** get 기부금_정치자금기부금_20 : amt20 */
    public Long  getAmt20() { return (Long )get( ATTR_AMT20 );}

    /** set 기부금_종교단체외지정기부금_40 : amt40 */
    public void setAmt40(Long  amt40) { set( ATTR_AMT40 ,amt40);}
    /** get 기부금_종교단체외지정기부금_40 : amt40 */
    public Long  getAmt40() { return (Long )get( ATTR_AMT40 );}

    /** set 기부금_종교단체지정기부금_41 : amt41 */
    public void setAmt41(Long  amt41) { set( ATTR_AMT41 ,amt41);}
    /** get 기부금_종교단체지정기부금_41 : amt41 */
    public Long  getAmt41() { return (Long )get( ATTR_AMT41 );}

    /** set 기부금_우리사주조합기부금_42 : amt42 */
    public void setAmt42(Long  amt42) { set( ATTR_AMT42 ,amt42);}
    /** get 기부금_우리사주조합기부금_42 : amt42 */
    public Long  getAmt42() { return (Long )get( ATTR_AMT42 );}

    /** set 기부금_공제제외기부금_50 : amt50 */
    public void setAmt50(Long  amt50) { set( ATTR_AMT50 ,amt50);}
    /** get 기부금_공제제외기부금_50 : amt50 */
    public Long  getAmt50() { return (Long )get( ATTR_AMT50 );}

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
