package com.app.exterms.yearendtax.client.dto.yeta2016;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye16Ta3150BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 교육비가족상세일련번호 : edacDtnu */
    public static final String ATTR_EDACDTNU = "edacDtnu";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 가족학력구분코드 : fmacGbcd */
    public static final String ATTR_FMACGBCD = "fmacGbcd";

    /** set 교육비지급금액 : edacOtam */
    public static final String ATTR_EDACOTAM = "edacOtam";
    
    
    /** set 성명 : kornName */
    public static final String ATTR_KORNNAME = "kornName";
    
    /** set 가족주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB = "rsnoNumb";
    
    /** set 가족주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB2 = "rsnoNumb2";
    /** set 국세청자료여부 : guksYeno */
    public static final String ATTR_GUKSYENO = "guksYeno";

    /** 생성자 */
     public Ye16Ta3150BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3150BM(
    		 BigDecimal  edacDtnu 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  dpobCd 
    		, String  systemkey 
    		, String  fmacGbcd 
    		, BigDecimal  edacOtam ) { 
     	values.put(ATTR_EDACDTNU,edacDtnu);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_FMACGBCD,fmacGbcd);
     	values.put(ATTR_EDACOTAM,edacOtam); } 

    /** set 교육비가족상세일련번호 : edacDtnu */
    public void setEdacDtnu(BigDecimal  edacDtnu) { set( ATTR_EDACDTNU ,edacDtnu);}
    /** get 교육비가족상세일련번호 : edacDtnu */
    public BigDecimal  getEdacDtnu() { return (BigDecimal )get( ATTR_EDACDTNU );}

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 가족학력구분코드 : fmacGbcd */
    public void setFmacGbcd(String  fmacGbcd) { set( ATTR_FMACGBCD ,fmacGbcd);}
    /** get 가족학력구분코드 : fmacGbcd */
    public String  getFmacGbcd() { return (String )get( ATTR_FMACGBCD );}

    /** set 교육비지급금액 : edacOtam */
    public void setEdacOtam(BigDecimal  edacOtam) { set( ATTR_EDACOTAM ,edacOtam);}
    /** get 교육비지급금액 : edacOtam */
    public BigDecimal  getEdacOtam() { return (BigDecimal )get( ATTR_EDACOTAM );}
    
	/** set 가족주민등록번호 : rsnoNumb */
	public void setRsnoNumb(String  rsnoNumb) { set( ATTR_RSNONUMB ,rsnoNumb);}
	/** get 가족주민등록번호 : rsnoNumb */
	public String  getRsnoNumb() { return (String )get( ATTR_RSNONUMB );}
	
	/** set 가족주민등록번호 : rsnoNumb */
	public void setRsnoNumb2(String  rsnoNumb2) { set( ATTR_RSNONUMB2 ,rsnoNumb2);}
	/** get 가족주민등록번호 : rsnoNumb */
	public String  getRsnoNumb2() { return (String )get( ATTR_RSNONUMB2 );}
	
    /** set 성명 : kornName */
    public void setKornName(String  kornName) { set( ATTR_KORNNAME ,kornName);}
    /** get 성명 : kornName */
    public String  getKornName() { return (String )get( ATTR_KORNNAME );}
	
    /** set 국세청자료여부 : guksYeno */
    public void setGuksYeno(Boolean  guksYeno) { set( ATTR_GUKSYENO ,guksYeno);}
    /** get 국세청자료여부 : guksYeno */
    public Boolean  getGuksYeno() { return (Boolean )get( ATTR_GUKSYENO );}


}
