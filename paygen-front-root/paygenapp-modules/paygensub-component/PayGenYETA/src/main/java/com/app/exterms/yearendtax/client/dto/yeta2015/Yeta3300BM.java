package com.app.exterms.yearendtax.client.dto.yeta2015;



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
public class Yeta3300BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
      
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set 지급년월 : elctYymm */
    public static final String ATTR_ELCTYYMM = "elctYymm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    

    /** set 사업자등록번호 : siteNumb */
    public static final String ATTR_SITENUMB = "siteNumb";
    

    /** set 비과세소득_A01 : taxmSa01 */
    public static final String ATTR_TAXMSA01 = "taxmSa01";

    /** set 비과세소득_B01 : taxmSb01 */
    public static final String ATTR_TAXMSB01 = "taxmSb01";

    /** set 비과세소득_C01 : taxmSc01 */
    public static final String ATTR_TAXMSC01 = "taxmSc01";

    /** set 비과세소득_D01 : taxmSd01 */
    public static final String ATTR_TAXMSD01 = "taxmSd01";

    /** set 비과세소득_E01 : taxmSe01 */
    public static final String ATTR_TAXMSE01 = "taxmSe01";

    /** set 비과세소득_E02 : taxmSe02 */
    public static final String ATTR_TAXMSE02 = "taxmSe02";

    /** set 비과세소득_E10 : taxmSe10 */
    public static final String ATTR_TAXMSE10 = "taxmSe10";

    /** set 비과세소득_F01 : taxmSf01 */
    public static final String ATTR_TAXMSF01 = "taxmSf01";

    /** set 비과세소득_G01 : taxmSg01 */
    public static final String ATTR_TAXMSG01 = "taxmSg01";

    /** set 비과세소득_H01 : taxmSh01 */
    public static final String ATTR_TAXMSH01 = "taxmSh01";

    /** set 비과세소득_H02 : taxmSh02 */
    public static final String ATTR_TAXMSH02 = "taxmSh02";

    /** set 비과세소득_H03 : taxmSh03 */
    public static final String ATTR_TAXMSH03 = "taxmSh03";

    /** set 비과세소득_H04 : taxmSh04 */
    public static final String ATTR_TAXMSH04 = "taxmSh04";

    /** set 비과세소득_H05 : taxmSh05 */
    public static final String ATTR_TAXMSH05 = "taxmSh05";

    /** set 비과세소득_H06 : taxmSh06 */
    public static final String ATTR_TAXMSH06 = "taxmSh06";

    /** set 비과세소득_H07 : taxmSh07 */
    public static final String ATTR_TAXMSH07 = "taxmSh07";

    /** set 비과세소득_H08 : taxmSh08 */
    public static final String ATTR_TAXMSH08 = "taxmSh08";

    /** set 비과세소득_H09 : taxmSh09 */
    public static final String ATTR_TAXMSH09 = "taxmSh09";

    /** set 비과세소득_H10 : taxmSh10 */
    public static final String ATTR_TAXMSH10 = "taxmSh10";

    /** set 비과세소득_H14 : taxmSh14 */
    public static final String ATTR_TAXMSH14 = "taxmSh14";

    /** set 비과세소득_H15 : taxmSh15 */
    public static final String ATTR_TAXMSH15 = "taxmSh15";

    /** set 비과세소득_H11 : taxmSh11 */
    public static final String ATTR_TAXMSH11 = "taxmSh11";

    /** set 비과세소득_H12 : taxmSh12 */
    public static final String ATTR_TAXMSH12 = "taxmSh12";

    /** set 비과세소득_H13 : taxmSh13 */
    public static final String ATTR_TAXMSH13 = "taxmSh13";

    /** set 비과세소득_H16 : taxmSh16 */
    public static final String ATTR_TAXMSH16 = "taxmSh16";

    /** set 비과세소득_I01 : taxmSi01 */
    public static final String ATTR_TAXMSI01 = "taxmSi01";

    /** set 비과세소득_J01 : taxmSj01 */
    public static final String ATTR_TAXMSJ01 = "taxmSj01";

    /** set 비과세소득_J10 : taxmSj10 */
    public static final String ATTR_TAXMSJ10 = "taxmSj10";

    /** set 비과세소득_K01 : taxmSk01 */
    public static final String ATTR_TAXMSK01 = "taxmSk01";

    /** set 비과세소득_L01 : taxmSl01 */
    public static final String ATTR_TAXMSL01 = "taxmSl01";

    /** set 비과세소득_M01 : taxmSm01 */
    public static final String ATTR_TAXMSM01 = "taxmSm01";

    /** set 비과세소득_M02 : taxmSm02 */
    public static final String ATTR_TAXMSM02 = "taxmSm02";

    /** set 비과세소득_M03 : taxmSm03 */
    public static final String ATTR_TAXMSM03 = "taxmSm03";

    /** set 비과세소득_N01 : taxmSn01 */
    public static final String ATTR_TAXMSN01 = "taxmSn01";

    /** set 비과세소득_O01 : taxmSo01 */
    public static final String ATTR_TAXMSO01 = "taxmSo01";

    /** set 비과세소득_P01 : taxmSp01 */
    public static final String ATTR_TAXMSP01 = "taxmSp01";

    /** set 비과세소득_P02 : taxmSp02 */
    public static final String ATTR_TAXMSP02 = "taxmSp02";

    /** set 비과세소득_Q01 : taxmSq01 */
    public static final String ATTR_TAXMSQ01 = "taxmSq01";

    /** set 비과세소득_R01 : taxmSr01 */
    public static final String ATTR_TAXMSR01 = "taxmSr01";

    /** set 비과세소득_R10 : taxmSr10 */
    public static final String ATTR_TAXMSR10 = "taxmSr10";

    /** set 비과세소득_S01 : taxmSs01 */
    public static final String ATTR_TAXMSS01 = "taxmSs01";

    /** set 비과세소득_Y02 : taxmSy02 */
    public static final String ATTR_TAXMSY02 = "taxmSy02";

    /** set 비과세소득_Y03 : taxmSy03 */
    public static final String ATTR_TAXMSY03 = "taxmSy03";

    /** set 비과세소득_Y21 : taxmSy21 */
    public static final String ATTR_TAXMSY21 = "taxmSy21";

    /** set 비과세소득_Y22 : taxmSy22 */
    public static final String ATTR_TAXMSY22 = "taxmSy22";

    /** set 감면소득_T01 : taxmSt01 */
    public static final String ATTR_TAXMST01 = "taxmSt01";

    /** set 감면소득_T10 : taxmSt10 */
    public static final String ATTR_TAXMST10 = "taxmSt10";

    /** set 감면소득_T20 : taxmSt20 */
    public static final String ATTR_TAXMST20 = "taxmSt20";

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
     public Yeta3300BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3300BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  elctYymm 
    		, String  systemkey 
    		, BigDecimal  taxmSa01 
    		, BigDecimal  taxmSb01 
    		, BigDecimal  taxmSc01 
    		, BigDecimal  taxmSd01 
    		, BigDecimal  taxmSe01 
    		, BigDecimal  taxmSe02 
    		, BigDecimal  taxmSe10 
    		, BigDecimal  taxmSf01 
    		, BigDecimal  taxmSg01 
    		, BigDecimal  taxmSh01 
    		, BigDecimal  taxmSh02 
    		, BigDecimal  taxmSh03 
    		, BigDecimal  taxmSh04 
    		, BigDecimal  taxmSh05 
    		, BigDecimal  taxmSh06 
    		, BigDecimal  taxmSh07 
    		, BigDecimal  taxmSh08 
    		, BigDecimal  taxmSh09 
    		, BigDecimal  taxmSh10 
    		, BigDecimal  taxmSh14 
    		, BigDecimal  taxmSh15 
    		, BigDecimal  taxmSh11 
    		, BigDecimal  taxmSh12 
    		, BigDecimal  taxmSh13 
    		, BigDecimal  taxmSh16 
    		, BigDecimal  taxmSi01 
    		, BigDecimal  taxmSj01 
    		, BigDecimal  taxmSj10 
    		, BigDecimal  taxmSk01 
    		, BigDecimal  taxmSl01 
    		, BigDecimal  taxmSm01 
    		, BigDecimal  taxmSm02 
    		, BigDecimal  taxmSm03 
    		, BigDecimal  taxmSn01 
    		, BigDecimal  taxmSo01 
    		, BigDecimal  taxmSp01 
    		, BigDecimal  taxmSp02 
    		, BigDecimal  taxmSq01 
    		, BigDecimal  taxmSr01 
    		, BigDecimal  taxmSr10 
    		, BigDecimal  taxmSs01 
    		, BigDecimal  taxmSy02 
    		, BigDecimal  taxmSy03 
    		, BigDecimal  taxmSy21 
    		, BigDecimal  taxmSy22 
    		, BigDecimal  taxmSt01 
    		, BigDecimal  taxmSt10 
    		, BigDecimal  taxmSt20 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_ELCTYYMM,elctYymm);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_TAXMSA01,taxmSa01);
     	values.put(ATTR_TAXMSB01,taxmSb01);
     	values.put(ATTR_TAXMSC01,taxmSc01);
     	values.put(ATTR_TAXMSD01,taxmSd01);
     	values.put(ATTR_TAXMSE01,taxmSe01);
     	values.put(ATTR_TAXMSE02,taxmSe02);
     	values.put(ATTR_TAXMSE10,taxmSe10);
     	values.put(ATTR_TAXMSF01,taxmSf01);
     	values.put(ATTR_TAXMSG01,taxmSg01);
     	values.put(ATTR_TAXMSH01,taxmSh01);
     	values.put(ATTR_TAXMSH02,taxmSh02);
     	values.put(ATTR_TAXMSH03,taxmSh03);
     	values.put(ATTR_TAXMSH04,taxmSh04);
     	values.put(ATTR_TAXMSH05,taxmSh05);
     	values.put(ATTR_TAXMSH06,taxmSh06);
     	values.put(ATTR_TAXMSH07,taxmSh07);
     	values.put(ATTR_TAXMSH08,taxmSh08);
     	values.put(ATTR_TAXMSH09,taxmSh09);
     	values.put(ATTR_TAXMSH10,taxmSh10);
     	values.put(ATTR_TAXMSH14,taxmSh14);
     	values.put(ATTR_TAXMSH15,taxmSh15);
     	values.put(ATTR_TAXMSH11,taxmSh11);
     	values.put(ATTR_TAXMSH12,taxmSh12);
     	values.put(ATTR_TAXMSH13,taxmSh13);
     	values.put(ATTR_TAXMSH16,taxmSh16);
     	values.put(ATTR_TAXMSI01,taxmSi01);
     	values.put(ATTR_TAXMSJ01,taxmSj01);
     	values.put(ATTR_TAXMSJ10,taxmSj10);
     	values.put(ATTR_TAXMSK01,taxmSk01);
     	values.put(ATTR_TAXMSL01,taxmSl01);
     	values.put(ATTR_TAXMSM01,taxmSm01);
     	values.put(ATTR_TAXMSM02,taxmSm02);
     	values.put(ATTR_TAXMSM03,taxmSm03);
     	values.put(ATTR_TAXMSN01,taxmSn01);
     	values.put(ATTR_TAXMSO01,taxmSo01);
     	values.put(ATTR_TAXMSP01,taxmSp01);
     	values.put(ATTR_TAXMSP02,taxmSp02);
     	values.put(ATTR_TAXMSQ01,taxmSq01);
     	values.put(ATTR_TAXMSR01,taxmSr01);
     	values.put(ATTR_TAXMSR10,taxmSr10);
     	values.put(ATTR_TAXMSS01,taxmSs01);
     	values.put(ATTR_TAXMSY02,taxmSy02);
     	values.put(ATTR_TAXMSY03,taxmSy03);
     	values.put(ATTR_TAXMSY21,taxmSy21);
     	values.put(ATTR_TAXMSY22,taxmSy22);
     	values.put(ATTR_TAXMST01,taxmSt01);
     	values.put(ATTR_TAXMST10,taxmSt10);
     	values.put(ATTR_TAXMST20,taxmSt20);
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

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set 지급년월 : elctYymm */
    public void setElctYymm(String  elctYymm) { set( ATTR_ELCTYYMM ,elctYymm);}
    /** get 지급년월 : elctYymm */
    public String  getElctYymm() { return (String )get( ATTR_ELCTYYMM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 비과세소득_A01 : taxmSa01 */
    public void setTaxmSa01(BigDecimal  taxmSa01) { set( ATTR_TAXMSA01 ,taxmSa01);}
    /** get 비과세소득_A01 : taxmSa01 */
    public BigDecimal  getTaxmSa01() { return (BigDecimal )get( ATTR_TAXMSA01 );}

    /** set 비과세소득_B01 : taxmSb01 */
    public void setTaxmSb01(BigDecimal  taxmSb01) { set( ATTR_TAXMSB01 ,taxmSb01);}
    /** get 비과세소득_B01 : taxmSb01 */
    public BigDecimal  getTaxmSb01() { return (BigDecimal )get( ATTR_TAXMSB01 );}

    /** set 비과세소득_C01 : taxmSc01 */
    public void setTaxmSc01(BigDecimal  taxmSc01) { set( ATTR_TAXMSC01 ,taxmSc01);}
    /** get 비과세소득_C01 : taxmSc01 */
    public BigDecimal  getTaxmSc01() { return (BigDecimal )get( ATTR_TAXMSC01 );}

    /** set 비과세소득_D01 : taxmSd01 */
    public void setTaxmSd01(BigDecimal  taxmSd01) { set( ATTR_TAXMSD01 ,taxmSd01);}
    /** get 비과세소득_D01 : taxmSd01 */
    public BigDecimal  getTaxmSd01() { return (BigDecimal )get( ATTR_TAXMSD01 );}

    /** set 비과세소득_E01 : taxmSe01 */
    public void setTaxmSe01(BigDecimal  taxmSe01) { set( ATTR_TAXMSE01 ,taxmSe01);}
    /** get 비과세소득_E01 : taxmSe01 */
    public BigDecimal  getTaxmSe01() { return (BigDecimal )get( ATTR_TAXMSE01 );}

    /** set 비과세소득_E02 : taxmSe02 */
    public void setTaxmSe02(BigDecimal  taxmSe02) { set( ATTR_TAXMSE02 ,taxmSe02);}
    /** get 비과세소득_E02 : taxmSe02 */
    public BigDecimal  getTaxmSe02() { return (BigDecimal )get( ATTR_TAXMSE02 );}

    /** set 비과세소득_E10 : taxmSe10 */
    public void setTaxmSe10(BigDecimal  taxmSe10) { set( ATTR_TAXMSE10 ,taxmSe10);}
    /** get 비과세소득_E10 : taxmSe10 */
    public BigDecimal  getTaxmSe10() { return (BigDecimal )get( ATTR_TAXMSE10 );}

    /** set 비과세소득_F01 : taxmSf01 */
    public void setTaxmSf01(BigDecimal  taxmSf01) { set( ATTR_TAXMSF01 ,taxmSf01);}
    /** get 비과세소득_F01 : taxmSf01 */
    public BigDecimal  getTaxmSf01() { return (BigDecimal )get( ATTR_TAXMSF01 );}

    /** set 비과세소득_G01 : taxmSg01 */
    public void setTaxmSg01(BigDecimal  taxmSg01) { set( ATTR_TAXMSG01 ,taxmSg01);}
    /** get 비과세소득_G01 : taxmSg01 */
    public BigDecimal  getTaxmSg01() { return (BigDecimal )get( ATTR_TAXMSG01 );}

    /** set 비과세소득_H01 : taxmSh01 */
    public void setTaxmSh01(BigDecimal  taxmSh01) { set( ATTR_TAXMSH01 ,taxmSh01);}
    /** get 비과세소득_H01 : taxmSh01 */
    public BigDecimal  getTaxmSh01() { return (BigDecimal )get( ATTR_TAXMSH01 );}

    /** set 비과세소득_H02 : taxmSh02 */
    public void setTaxmSh02(BigDecimal  taxmSh02) { set( ATTR_TAXMSH02 ,taxmSh02);}
    /** get 비과세소득_H02 : taxmSh02 */
    public BigDecimal  getTaxmSh02() { return (BigDecimal )get( ATTR_TAXMSH02 );}

    /** set 비과세소득_H03 : taxmSh03 */
    public void setTaxmSh03(BigDecimal  taxmSh03) { set( ATTR_TAXMSH03 ,taxmSh03);}
    /** get 비과세소득_H03 : taxmSh03 */
    public BigDecimal  getTaxmSh03() { return (BigDecimal )get( ATTR_TAXMSH03 );}

    /** set 비과세소득_H04 : taxmSh04 */
    public void setTaxmSh04(BigDecimal  taxmSh04) { set( ATTR_TAXMSH04 ,taxmSh04);}
    /** get 비과세소득_H04 : taxmSh04 */
    public BigDecimal  getTaxmSh04() { return (BigDecimal )get( ATTR_TAXMSH04 );}

    /** set 비과세소득_H05 : taxmSh05 */
    public void setTaxmSh05(BigDecimal  taxmSh05) { set( ATTR_TAXMSH05 ,taxmSh05);}
    /** get 비과세소득_H05 : taxmSh05 */
    public BigDecimal  getTaxmSh05() { return (BigDecimal )get( ATTR_TAXMSH05 );}

    /** set 비과세소득_H06 : taxmSh06 */
    public void setTaxmSh06(BigDecimal  taxmSh06) { set( ATTR_TAXMSH06 ,taxmSh06);}
    /** get 비과세소득_H06 : taxmSh06 */
    public BigDecimal  getTaxmSh06() { return (BigDecimal )get( ATTR_TAXMSH06 );}

    /** set 비과세소득_H07 : taxmSh07 */
    public void setTaxmSh07(BigDecimal  taxmSh07) { set( ATTR_TAXMSH07 ,taxmSh07);}
    /** get 비과세소득_H07 : taxmSh07 */
    public BigDecimal  getTaxmSh07() { return (BigDecimal )get( ATTR_TAXMSH07 );}

    /** set 비과세소득_H08 : taxmSh08 */
    public void setTaxmSh08(BigDecimal  taxmSh08) { set( ATTR_TAXMSH08 ,taxmSh08);}
    /** get 비과세소득_H08 : taxmSh08 */
    public BigDecimal  getTaxmSh08() { return (BigDecimal )get( ATTR_TAXMSH08 );}

    /** set 비과세소득_H09 : taxmSh09 */
    public void setTaxmSh09(BigDecimal  taxmSh09) { set( ATTR_TAXMSH09 ,taxmSh09);}
    /** get 비과세소득_H09 : taxmSh09 */
    public BigDecimal  getTaxmSh09() { return (BigDecimal )get( ATTR_TAXMSH09 );}

    /** set 비과세소득_H10 : taxmSh10 */
    public void setTaxmSh10(BigDecimal  taxmSh10) { set( ATTR_TAXMSH10 ,taxmSh10);}
    /** get 비과세소득_H10 : taxmSh10 */
    public BigDecimal  getTaxmSh10() { return (BigDecimal )get( ATTR_TAXMSH10 );}

    /** set 비과세소득_H14 : taxmSh14 */
    public void setTaxmSh14(BigDecimal  taxmSh14) { set( ATTR_TAXMSH14 ,taxmSh14);}
    /** get 비과세소득_H14 : taxmSh14 */
    public BigDecimal  getTaxmSh14() { return (BigDecimal )get( ATTR_TAXMSH14 );}

    /** set 비과세소득_H15 : taxmSh15 */
    public void setTaxmSh15(BigDecimal  taxmSh15) { set( ATTR_TAXMSH15 ,taxmSh15);}
    /** get 비과세소득_H15 : taxmSh15 */
    public BigDecimal  getTaxmSh15() { return (BigDecimal )get( ATTR_TAXMSH15 );}

    /** set 비과세소득_H11 : taxmSh11 */
    public void setTaxmSh11(BigDecimal  taxmSh11) { set( ATTR_TAXMSH11 ,taxmSh11);}
    /** get 비과세소득_H11 : taxmSh11 */
    public BigDecimal  getTaxmSh11() { return (BigDecimal )get( ATTR_TAXMSH11 );}

    /** set 비과세소득_H12 : taxmSh12 */
    public void setTaxmSh12(BigDecimal  taxmSh12) { set( ATTR_TAXMSH12 ,taxmSh12);}
    /** get 비과세소득_H12 : taxmSh12 */
    public BigDecimal  getTaxmSh12() { return (BigDecimal )get( ATTR_TAXMSH12 );}

    /** set 비과세소득_H13 : taxmSh13 */
    public void setTaxmSh13(BigDecimal  taxmSh13) { set( ATTR_TAXMSH13 ,taxmSh13);}
    /** get 비과세소득_H13 : taxmSh13 */
    public BigDecimal  getTaxmSh13() { return (BigDecimal )get( ATTR_TAXMSH13 );}

    /** set 비과세소득_H16 : taxmSh16 */
    public void setTaxmSh16(BigDecimal  taxmSh16) { set( ATTR_TAXMSH16 ,taxmSh16);}
    /** get 비과세소득_H16 : taxmSh16 */
    public BigDecimal  getTaxmSh16() { return (BigDecimal )get( ATTR_TAXMSH16 );}

    /** set 비과세소득_I01 : taxmSi01 */
    public void setTaxmSi01(BigDecimal  taxmSi01) { set( ATTR_TAXMSI01 ,taxmSi01);}
    /** get 비과세소득_I01 : taxmSi01 */
    public BigDecimal  getTaxmSi01() { return (BigDecimal )get( ATTR_TAXMSI01 );}

    /** set 비과세소득_J01 : taxmSj01 */
    public void setTaxmSj01(BigDecimal  taxmSj01) { set( ATTR_TAXMSJ01 ,taxmSj01);}
    /** get 비과세소득_J01 : taxmSj01 */
    public BigDecimal  getTaxmSj01() { return (BigDecimal )get( ATTR_TAXMSJ01 );}

    /** set 비과세소득_J10 : taxmSj10 */
    public void setTaxmSj10(BigDecimal  taxmSj10) { set( ATTR_TAXMSJ10 ,taxmSj10);}
    /** get 비과세소득_J10 : taxmSj10 */
    public BigDecimal  getTaxmSj10() { return (BigDecimal )get( ATTR_TAXMSJ10 );}

    /** set 비과세소득_K01 : taxmSk01 */
    public void setTaxmSk01(BigDecimal  taxmSk01) { set( ATTR_TAXMSK01 ,taxmSk01);}
    /** get 비과세소득_K01 : taxmSk01 */
    public BigDecimal  getTaxmSk01() { return (BigDecimal )get( ATTR_TAXMSK01 );}

    /** set 비과세소득_L01 : taxmSl01 */
    public void setTaxmSl01(BigDecimal  taxmSl01) { set( ATTR_TAXMSL01 ,taxmSl01);}
    /** get 비과세소득_L01 : taxmSl01 */
    public BigDecimal  getTaxmSl01() { return (BigDecimal )get( ATTR_TAXMSL01 );}

    /** set 비과세소득_M01 : taxmSm01 */
    public void setTaxmSm01(BigDecimal  taxmSm01) { set( ATTR_TAXMSM01 ,taxmSm01);}
    /** get 비과세소득_M01 : taxmSm01 */
    public BigDecimal  getTaxmSm01() { return (BigDecimal )get( ATTR_TAXMSM01 );}

    /** set 비과세소득_M02 : taxmSm02 */
    public void setTaxmSm02(BigDecimal  taxmSm02) { set( ATTR_TAXMSM02 ,taxmSm02);}
    /** get 비과세소득_M02 : taxmSm02 */
    public BigDecimal  getTaxmSm02() { return (BigDecimal )get( ATTR_TAXMSM02 );}

    /** set 비과세소득_M03 : taxmSm03 */
    public void setTaxmSm03(BigDecimal  taxmSm03) { set( ATTR_TAXMSM03 ,taxmSm03);}
    /** get 비과세소득_M03 : taxmSm03 */
    public BigDecimal  getTaxmSm03() { return (BigDecimal )get( ATTR_TAXMSM03 );}

    /** set 비과세소득_N01 : taxmSn01 */
    public void setTaxmSn01(BigDecimal  taxmSn01) { set( ATTR_TAXMSN01 ,taxmSn01);}
    /** get 비과세소득_N01 : taxmSn01 */
    public BigDecimal  getTaxmSn01() { return (BigDecimal )get( ATTR_TAXMSN01 );}

    /** set 비과세소득_O01 : taxmSo01 */
    public void setTaxmSo01(BigDecimal  taxmSo01) { set( ATTR_TAXMSO01 ,taxmSo01);}
    /** get 비과세소득_O01 : taxmSo01 */
    public BigDecimal  getTaxmSo01() { return (BigDecimal )get( ATTR_TAXMSO01 );}

    /** set 비과세소득_P01 : taxmSp01 */
    public void setTaxmSp01(BigDecimal  taxmSp01) { set( ATTR_TAXMSP01 ,taxmSp01);}
    /** get 비과세소득_P01 : taxmSp01 */
    public BigDecimal  getTaxmSp01() { return (BigDecimal )get( ATTR_TAXMSP01 );}

    /** set 비과세소득_P02 : taxmSp02 */
    public void setTaxmSp02(BigDecimal  taxmSp02) { set( ATTR_TAXMSP02 ,taxmSp02);}
    /** get 비과세소득_P02 : taxmSp02 */
    public BigDecimal  getTaxmSp02() { return (BigDecimal )get( ATTR_TAXMSP02 );}

    /** set 비과세소득_Q01 : taxmSq01 */
    public void setTaxmSq01(BigDecimal  taxmSq01) { set( ATTR_TAXMSQ01 ,taxmSq01);}
    /** get 비과세소득_Q01 : taxmSq01 */
    public BigDecimal  getTaxmSq01() { return (BigDecimal )get( ATTR_TAXMSQ01 );}

    /** set 비과세소득_R01 : taxmSr01 */
    public void setTaxmSr01(BigDecimal  taxmSr01) { set( ATTR_TAXMSR01 ,taxmSr01);}
    /** get 비과세소득_R01 : taxmSr01 */
    public BigDecimal  getTaxmSr01() { return (BigDecimal )get( ATTR_TAXMSR01 );}

    /** set 비과세소득_R10 : taxmSr10 */
    public void setTaxmSr10(BigDecimal  taxmSr10) { set( ATTR_TAXMSR10 ,taxmSr10);}
    /** get 비과세소득_R10 : taxmSr10 */
    public BigDecimal  getTaxmSr10() { return (BigDecimal )get( ATTR_TAXMSR10 );}

    /** set 비과세소득_S01 : taxmSs01 */
    public void setTaxmSs01(BigDecimal  taxmSs01) { set( ATTR_TAXMSS01 ,taxmSs01);}
    /** get 비과세소득_S01 : taxmSs01 */
    public BigDecimal  getTaxmSs01() { return (BigDecimal )get( ATTR_TAXMSS01 );}

    /** set 비과세소득_Y02 : taxmSy02 */
    public void setTaxmSy02(BigDecimal  taxmSy02) { set( ATTR_TAXMSY02 ,taxmSy02);}
    /** get 비과세소득_Y02 : taxmSy02 */
    public BigDecimal  getTaxmSy02() { return (BigDecimal )get( ATTR_TAXMSY02 );}

    /** set 비과세소득_Y03 : taxmSy03 */
    public void setTaxmSy03(BigDecimal  taxmSy03) { set( ATTR_TAXMSY03 ,taxmSy03);}
    /** get 비과세소득_Y03 : taxmSy03 */
    public BigDecimal  getTaxmSy03() { return (BigDecimal )get( ATTR_TAXMSY03 );}

    /** set 비과세소득_Y21 : taxmSy21 */
    public void setTaxmSy21(BigDecimal  taxmSy21) { set( ATTR_TAXMSY21 ,taxmSy21);}
    /** get 비과세소득_Y21 : taxmSy21 */
    public BigDecimal  getTaxmSy21() { return (BigDecimal )get( ATTR_TAXMSY21 );}

    /** set 비과세소득_Y22 : taxmSy22 */
    public void setTaxmSy22(BigDecimal  taxmSy22) { set( ATTR_TAXMSY22 ,taxmSy22);}
    /** get 비과세소득_Y22 : taxmSy22 */
    public BigDecimal  getTaxmSy22() { return (BigDecimal )get( ATTR_TAXMSY22 );}

    /** set 감면소득_T01 : taxmSt01 */
    public void setTaxmSt01(BigDecimal  taxmSt01) { set( ATTR_TAXMST01 ,taxmSt01);}
    /** get 감면소득_T01 : taxmSt01 */
    public BigDecimal  getTaxmSt01() { return (BigDecimal )get( ATTR_TAXMST01 );}

    /** set 감면소득_T10 : taxmSt10 */
    public void setTaxmSt10(BigDecimal  taxmSt10) { set( ATTR_TAXMST10 ,taxmSt10);}
    /** get 감면소득_T10 : taxmSt10 */
    public BigDecimal  getTaxmSt10() { return (BigDecimal )get( ATTR_TAXMST10 );}

    /** set 감면소득_T20 : taxmSt20 */
    public void setTaxmSt20(BigDecimal  taxmSt20) { set( ATTR_TAXMST20 ,taxmSt20);}
    /** get 감면소득_T20 : taxmSt20 */
    public BigDecimal  getTaxmSt20() { return (BigDecimal )get( ATTR_TAXMST20 );}

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

    /** set 사업자등록번호 : siteNumb */
    public void setSiteNumb(String  siteNumb) { set( ATTR_SITENUMB ,siteNumb);}
    /** get 사업자등록번호 : siteNumb */
    public String  getSiteNumb() { return (String )get( ATTR_SITENUMB );}
}
