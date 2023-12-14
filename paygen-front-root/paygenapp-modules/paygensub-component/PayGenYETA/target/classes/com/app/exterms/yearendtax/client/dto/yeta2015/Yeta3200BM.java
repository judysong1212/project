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
public class Yeta3200BM    extends MSFSimpleBaseModel implements IsSerializable   {
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

    /** set 비과세소득_A01 : taxmEa01 */
    public static final String ATTR_TAXMEA01 = "taxmEa01";

    /** set 비과세소득_B01 : taxmEb01 */
    public static final String ATTR_TAXMEB01 = "taxmEb01";

    /** set 비과세소득_C01 : taxmEc01 */
    public static final String ATTR_TAXMEC01 = "taxmEc01";

    /** set 비과세소득_D01 : taxmEd01 */
    public static final String ATTR_TAXMED01 = "taxmEd01";

    /** set 비과세소득_E01 : taxmEe01 */
    public static final String ATTR_TAXMEE01 = "taxmEe01";

    /** set 비과세소득_E02 : taxmEe02 */
    public static final String ATTR_TAXMEE02 = "taxmEe02";

    /** set 비과세소득_E10 : taxmEe10 */
    public static final String ATTR_TAXMEE10 = "taxmEe10";

    /** set 비과세소득_F01 : taxmEf01 */
    public static final String ATTR_TAXMEF01 = "taxmEf01";

    /** set 비과세소득_G01 : taxmEg01 */
    public static final String ATTR_TAXMEG01 = "taxmEg01";

    /** set 비과세소득_H01 : taxmEh01 */
    public static final String ATTR_TAXMEH01 = "taxmEh01";

    /** set 비과세소득_H02 : taxmEh02 */
    public static final String ATTR_TAXMEH02 = "taxmEh02";

    /** set 비과세소득_H03 : taxmEh03 */
    public static final String ATTR_TAXMEH03 = "taxmEh03";

    /** set 비과세소득_H04 : taxmEh04 */
    public static final String ATTR_TAXMEH04 = "taxmEh04";

    /** set 비과세소득_H05 : taxmEh05 */
    public static final String ATTR_TAXMEH05 = "taxmEh05";

    /** set 비과세소득_H06 : taxmEh06 */
    public static final String ATTR_TAXMEH06 = "taxmEh06";

    /** set 비과세소득_H07 : taxmEh07 */
    public static final String ATTR_TAXMEH07 = "taxmEh07";

    /** set 비과세소득_H08 : taxmEh08 */
    public static final String ATTR_TAXMEH08 = "taxmEh08";

    /** set 비과세소득_H09 : taxmEh09 */
    public static final String ATTR_TAXMEH09 = "taxmEh09";

    /** set 비과세소득_H10 : taxmEh10 */
    public static final String ATTR_TAXMEH10 = "taxmEh10";

    /** set 비과세소득_H14 : taxmEh14 */
    public static final String ATTR_TAXMEH14 = "taxmEh14";

    /** set 비과세소득_H15 : taxmEh15 */
    public static final String ATTR_TAXMEH15 = "taxmEh15";

    /** set 비과세소득_H11 : taxmEh11 */
    public static final String ATTR_TAXMEH11 = "taxmEh11";

    /** set 비과세소득_H12 : taxmEh12 */
    public static final String ATTR_TAXMEH12 = "taxmEh12";

    /** set 비과세소득_H13 : taxmEh13 */
    public static final String ATTR_TAXMEH13 = "taxmEh13";

    /** set 비과세소득_H16 : taxmEh16 */
    public static final String ATTR_TAXMEH16 = "taxmEh16";

    /** set 비과세소득_I01 : taxmEi01 */
    public static final String ATTR_TAXMEI01 = "taxmEi01";

    /** set 비과세소득_J01 : taxmEj01 */
    public static final String ATTR_TAXMEJ01 = "taxmEj01";

    /** set 비과세소득_J10 : taxmEj10 */
    public static final String ATTR_TAXMEJ10 = "taxmEj10";

    /** set 비과세소득_K01 : taxmEk01 */
    public static final String ATTR_TAXMEK01 = "taxmEk01";

    /** set 비과세소득_L01 : taxmEl01 */
    public static final String ATTR_TAXMEL01 = "taxmEl01";

    /** set 비과세소득_M01 : taxmEm01 */
    public static final String ATTR_TAXMEM01 = "taxmEm01";

    /** set 비과세소득_M02 : taxmEm02 */
    public static final String ATTR_TAXMEM02 = "taxmEm02";

    /** set 비과세소득_M03 : taxmEm03 */
    public static final String ATTR_TAXMEM03 = "taxmEm03";

    /** set 비과세소득_N01 : taxmEn01 */
    public static final String ATTR_TAXMEN01 = "taxmEn01";

    /** set 비과세소득_O01 : taxmEo01 */
    public static final String ATTR_TAXMEO01 = "taxmEo01";

    /** set 비과세소득_P01 : taxmEp01 */
    public static final String ATTR_TAXMEP01 = "taxmEp01";

    /** set 비과세소득_P02 : taxmEp02 */
    public static final String ATTR_TAXMEP02 = "taxmEp02";

    /** set 비과세소득_Q01 : taxmEq01 */
    public static final String ATTR_TAXMEQ01 = "taxmEq01";

    /** set 비과세소득_R01 : taxmEr01 */
    public static final String ATTR_TAXMER01 = "taxmEr01";

    /** set 비과세소득_R10 : taxmEr10 */
    public static final String ATTR_TAXMER10 = "taxmEr10";

    /** set 비과세소득_S01 : taxmEs01 */
    public static final String ATTR_TAXMES01 = "taxmEs01";

    /** set 비과세소득_Y02 : taxmEy02 */
    public static final String ATTR_TAXMEY02 = "taxmEy02";

    /** set 비과세소득_Y03 : taxmEy03 */
    public static final String ATTR_TAXMEY03 = "taxmEy03";

    /** set 비과세소득_Y21 : taxmEy21 */
    public static final String ATTR_TAXMEY21 = "taxmEy21";

    /** set 비과세소득_Y22 : taxmEy22 */
    public static final String ATTR_TAXMEY22 = "taxmEy22";

    /** set 감면소득_T01 : taxmEt01 */
    public static final String ATTR_TAXMET01 = "taxmEt01";

    /** set 감면소득_T10 : taxmEt10 */
    public static final String ATTR_TAXMET10 = "taxmEt10";

    /** set 감면소득_T20 : taxmEt20 */
    public static final String ATTR_TAXMET20 = "taxmEt20";

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
     public Yeta3200BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3200BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  elctYymm 
    		, String  systemkey 
    		, String  siteNumb 
    		, BigDecimal  taxmEa01 
    		, BigDecimal  taxmEb01 
    		, BigDecimal  taxmEc01 
    		, BigDecimal  taxmEd01 
    		, BigDecimal  taxmEe01 
    		, BigDecimal  taxmEe02 
    		, BigDecimal  taxmEe10 
    		, BigDecimal  taxmEf01 
    		, BigDecimal  taxmEg01 
    		, BigDecimal  taxmEh01 
    		, BigDecimal  taxmEh02 
    		, BigDecimal  taxmEh03 
    		, BigDecimal  taxmEh04 
    		, BigDecimal  taxmEh05 
    		, BigDecimal  taxmEh06 
    		, BigDecimal  taxmEh07 
    		, BigDecimal  taxmEh08 
    		, BigDecimal  taxmEh09 
    		, BigDecimal  taxmEh10 
    		, BigDecimal  taxmEh14 
    		, BigDecimal  taxmEh15 
    		, BigDecimal  taxmEh11 
    		, BigDecimal  taxmEh12 
    		, BigDecimal  taxmEh13 
    		, BigDecimal  taxmEh16 
    		, BigDecimal  taxmEi01 
    		, BigDecimal  taxmEj01 
    		, BigDecimal  taxmEj10 
    		, BigDecimal  taxmEk01 
    		, BigDecimal  taxmEl01 
    		, BigDecimal  taxmEm01 
    		, BigDecimal  taxmEm02 
    		, BigDecimal  taxmEm03 
    		, BigDecimal  taxmEn01 
    		, BigDecimal  taxmEo01 
    		, BigDecimal  taxmEp01 
    		, BigDecimal  taxmEp02 
    		, BigDecimal  taxmEq01 
    		, BigDecimal  taxmEr01 
    		, BigDecimal  taxmEr10 
    		, BigDecimal  taxmEs01 
    		, BigDecimal  taxmEy02 
    		, BigDecimal  taxmEy03 
    		, BigDecimal  taxmEy21 
    		, BigDecimal  taxmEy22 
    		, BigDecimal  taxmEt01 
    		, BigDecimal  taxmEt10 
    		, BigDecimal  taxmEt20 
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
     	values.put(ATTR_SITENUMB,siteNumb);
     	values.put(ATTR_TAXMEA01,taxmEa01);
     	values.put(ATTR_TAXMEB01,taxmEb01);
     	values.put(ATTR_TAXMEC01,taxmEc01);
     	values.put(ATTR_TAXMED01,taxmEd01);
     	values.put(ATTR_TAXMEE01,taxmEe01);
     	values.put(ATTR_TAXMEE02,taxmEe02);
     	values.put(ATTR_TAXMEE10,taxmEe10);
     	values.put(ATTR_TAXMEF01,taxmEf01);
     	values.put(ATTR_TAXMEG01,taxmEg01);
     	values.put(ATTR_TAXMEH01,taxmEh01);
     	values.put(ATTR_TAXMEH02,taxmEh02);
     	values.put(ATTR_TAXMEH03,taxmEh03);
     	values.put(ATTR_TAXMEH04,taxmEh04);
     	values.put(ATTR_TAXMEH05,taxmEh05);
     	values.put(ATTR_TAXMEH06,taxmEh06);
     	values.put(ATTR_TAXMEH07,taxmEh07);
     	values.put(ATTR_TAXMEH08,taxmEh08);
     	values.put(ATTR_TAXMEH09,taxmEh09);
     	values.put(ATTR_TAXMEH10,taxmEh10);
     	values.put(ATTR_TAXMEH14,taxmEh14);
     	values.put(ATTR_TAXMEH15,taxmEh15);
     	values.put(ATTR_TAXMEH11,taxmEh11);
     	values.put(ATTR_TAXMEH12,taxmEh12);
     	values.put(ATTR_TAXMEH13,taxmEh13);
     	values.put(ATTR_TAXMEH16,taxmEh16);
     	values.put(ATTR_TAXMEI01,taxmEi01);
     	values.put(ATTR_TAXMEJ01,taxmEj01);
     	values.put(ATTR_TAXMEJ10,taxmEj10);
     	values.put(ATTR_TAXMEK01,taxmEk01);
     	values.put(ATTR_TAXMEL01,taxmEl01);
     	values.put(ATTR_TAXMEM01,taxmEm01);
     	values.put(ATTR_TAXMEM02,taxmEm02);
     	values.put(ATTR_TAXMEM03,taxmEm03);
     	values.put(ATTR_TAXMEN01,taxmEn01);
     	values.put(ATTR_TAXMEO01,taxmEo01);
     	values.put(ATTR_TAXMEP01,taxmEp01);
     	values.put(ATTR_TAXMEP02,taxmEp02);
     	values.put(ATTR_TAXMEQ01,taxmEq01);
     	values.put(ATTR_TAXMER01,taxmEr01);
     	values.put(ATTR_TAXMER10,taxmEr10);
     	values.put(ATTR_TAXMES01,taxmEs01);
     	values.put(ATTR_TAXMEY02,taxmEy02);
     	values.put(ATTR_TAXMEY03,taxmEy03);
     	values.put(ATTR_TAXMEY21,taxmEy21);
     	values.put(ATTR_TAXMEY22,taxmEy22);
     	values.put(ATTR_TAXMET01,taxmEt01);
     	values.put(ATTR_TAXMET10,taxmEt10);
     	values.put(ATTR_TAXMET20,taxmEt20);
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

    /** set 사업자등록번호 : siteNumb */
    public void setSiteNumb(String  siteNumb) { set( ATTR_SITENUMB ,siteNumb);}
    /** get 사업자등록번호 : siteNumb */
    public String  getSiteNumb() { return (String )get( ATTR_SITENUMB );}

    /** set 비과세소득_A01 : taxmEa01 */
    public void setTaxmEa01(BigDecimal  taxmEa01) { set( ATTR_TAXMEA01 ,taxmEa01);}
    /** get 비과세소득_A01 : taxmEa01 */
    public BigDecimal  getTaxmEa01() { return (BigDecimal )get( ATTR_TAXMEA01 );}

    /** set 비과세소득_B01 : taxmEb01 */
    public void setTaxmEb01(BigDecimal  taxmEb01) { set( ATTR_TAXMEB01 ,taxmEb01);}
    /** get 비과세소득_B01 : taxmEb01 */
    public BigDecimal  getTaxmEb01() { return (BigDecimal )get( ATTR_TAXMEB01 );}

    /** set 비과세소득_C01 : taxmEc01 */
    public void setTaxmEc01(BigDecimal  taxmEc01) { set( ATTR_TAXMEC01 ,taxmEc01);}
    /** get 비과세소득_C01 : taxmEc01 */
    public BigDecimal  getTaxmEc01() { return (BigDecimal )get( ATTR_TAXMEC01 );}

    /** set 비과세소득_D01 : taxmEd01 */
    public void setTaxmEd01(BigDecimal  taxmEd01) { set( ATTR_TAXMED01 ,taxmEd01);}
    /** get 비과세소득_D01 : taxmEd01 */
    public BigDecimal  getTaxmEd01() { return (BigDecimal )get( ATTR_TAXMED01 );}

    /** set 비과세소득_E01 : taxmEe01 */
    public void setTaxmEe01(BigDecimal  taxmEe01) { set( ATTR_TAXMEE01 ,taxmEe01);}
    /** get 비과세소득_E01 : taxmEe01 */
    public BigDecimal  getTaxmEe01() { return (BigDecimal )get( ATTR_TAXMEE01 );}

    /** set 비과세소득_E02 : taxmEe02 */
    public void setTaxmEe02(BigDecimal  taxmEe02) { set( ATTR_TAXMEE02 ,taxmEe02);}
    /** get 비과세소득_E02 : taxmEe02 */
    public BigDecimal  getTaxmEe02() { return (BigDecimal )get( ATTR_TAXMEE02 );}

    /** set 비과세소득_E10 : taxmEe10 */
    public void setTaxmEe10(BigDecimal  taxmEe10) { set( ATTR_TAXMEE10 ,taxmEe10);}
    /** get 비과세소득_E10 : taxmEe10 */
    public BigDecimal  getTaxmEe10() { return (BigDecimal )get( ATTR_TAXMEE10 );}

    /** set 비과세소득_F01 : taxmEf01 */
    public void setTaxmEf01(BigDecimal  taxmEf01) { set( ATTR_TAXMEF01 ,taxmEf01);}
    /** get 비과세소득_F01 : taxmEf01 */
    public BigDecimal  getTaxmEf01() { return (BigDecimal )get( ATTR_TAXMEF01 );}

    /** set 비과세소득_G01 : taxmEg01 */
    public void setTaxmEg01(BigDecimal  taxmEg01) { set( ATTR_TAXMEG01 ,taxmEg01);}
    /** get 비과세소득_G01 : taxmEg01 */
    public BigDecimal  getTaxmEg01() { return (BigDecimal )get( ATTR_TAXMEG01 );}

    /** set 비과세소득_H01 : taxmEh01 */
    public void setTaxmEh01(BigDecimal  taxmEh01) { set( ATTR_TAXMEH01 ,taxmEh01);}
    /** get 비과세소득_H01 : taxmEh01 */
    public BigDecimal  getTaxmEh01() { return (BigDecimal )get( ATTR_TAXMEH01 );}

    /** set 비과세소득_H02 : taxmEh02 */
    public void setTaxmEh02(BigDecimal  taxmEh02) { set( ATTR_TAXMEH02 ,taxmEh02);}
    /** get 비과세소득_H02 : taxmEh02 */
    public BigDecimal  getTaxmEh02() { return (BigDecimal )get( ATTR_TAXMEH02 );}

    /** set 비과세소득_H03 : taxmEh03 */
    public void setTaxmEh03(BigDecimal  taxmEh03) { set( ATTR_TAXMEH03 ,taxmEh03);}
    /** get 비과세소득_H03 : taxmEh03 */
    public BigDecimal  getTaxmEh03() { return (BigDecimal )get( ATTR_TAXMEH03 );}

    /** set 비과세소득_H04 : taxmEh04 */
    public void setTaxmEh04(BigDecimal  taxmEh04) { set( ATTR_TAXMEH04 ,taxmEh04);}
    /** get 비과세소득_H04 : taxmEh04 */
    public BigDecimal  getTaxmEh04() { return (BigDecimal )get( ATTR_TAXMEH04 );}

    /** set 비과세소득_H05 : taxmEh05 */
    public void setTaxmEh05(BigDecimal  taxmEh05) { set( ATTR_TAXMEH05 ,taxmEh05);}
    /** get 비과세소득_H05 : taxmEh05 */
    public BigDecimal  getTaxmEh05() { return (BigDecimal )get( ATTR_TAXMEH05 );}

    /** set 비과세소득_H06 : taxmEh06 */
    public void setTaxmEh06(BigDecimal  taxmEh06) { set( ATTR_TAXMEH06 ,taxmEh06);}
    /** get 비과세소득_H06 : taxmEh06 */
    public BigDecimal  getTaxmEh06() { return (BigDecimal )get( ATTR_TAXMEH06 );}

    /** set 비과세소득_H07 : taxmEh07 */
    public void setTaxmEh07(BigDecimal  taxmEh07) { set( ATTR_TAXMEH07 ,taxmEh07);}
    /** get 비과세소득_H07 : taxmEh07 */
    public BigDecimal  getTaxmEh07() { return (BigDecimal )get( ATTR_TAXMEH07 );}

    /** set 비과세소득_H08 : taxmEh08 */
    public void setTaxmEh08(BigDecimal  taxmEh08) { set( ATTR_TAXMEH08 ,taxmEh08);}
    /** get 비과세소득_H08 : taxmEh08 */
    public BigDecimal  getTaxmEh08() { return (BigDecimal )get( ATTR_TAXMEH08 );}

    /** set 비과세소득_H09 : taxmEh09 */
    public void setTaxmEh09(BigDecimal  taxmEh09) { set( ATTR_TAXMEH09 ,taxmEh09);}
    /** get 비과세소득_H09 : taxmEh09 */
    public BigDecimal  getTaxmEh09() { return (BigDecimal )get( ATTR_TAXMEH09 );}

    /** set 비과세소득_H10 : taxmEh10 */
    public void setTaxmEh10(BigDecimal  taxmEh10) { set( ATTR_TAXMEH10 ,taxmEh10);}
    /** get 비과세소득_H10 : taxmEh10 */
    public BigDecimal  getTaxmEh10() { return (BigDecimal )get( ATTR_TAXMEH10 );}

    /** set 비과세소득_H14 : taxmEh14 */
    public void setTaxmEh14(BigDecimal  taxmEh14) { set( ATTR_TAXMEH14 ,taxmEh14);}
    /** get 비과세소득_H14 : taxmEh14 */
    public BigDecimal  getTaxmEh14() { return (BigDecimal )get( ATTR_TAXMEH14 );}

    /** set 비과세소득_H15 : taxmEh15 */
    public void setTaxmEh15(BigDecimal  taxmEh15) { set( ATTR_TAXMEH15 ,taxmEh15);}
    /** get 비과세소득_H15 : taxmEh15 */
    public BigDecimal  getTaxmEh15() { return (BigDecimal )get( ATTR_TAXMEH15 );}

    /** set 비과세소득_H11 : taxmEh11 */
    public void setTaxmEh11(BigDecimal  taxmEh11) { set( ATTR_TAXMEH11 ,taxmEh11);}
    /** get 비과세소득_H11 : taxmEh11 */
    public BigDecimal  getTaxmEh11() { return (BigDecimal )get( ATTR_TAXMEH11 );}

    /** set 비과세소득_H12 : taxmEh12 */
    public void setTaxmEh12(BigDecimal  taxmEh12) { set( ATTR_TAXMEH12 ,taxmEh12);}
    /** get 비과세소득_H12 : taxmEh12 */
    public BigDecimal  getTaxmEh12() { return (BigDecimal )get( ATTR_TAXMEH12 );}

    /** set 비과세소득_H13 : taxmEh13 */
    public void setTaxmEh13(BigDecimal  taxmEh13) { set( ATTR_TAXMEH13 ,taxmEh13);}
    /** get 비과세소득_H13 : taxmEh13 */
    public BigDecimal  getTaxmEh13() { return (BigDecimal )get( ATTR_TAXMEH13 );}

    /** set 비과세소득_H16 : taxmEh16 */
    public void setTaxmEh16(BigDecimal  taxmEh16) { set( ATTR_TAXMEH16 ,taxmEh16);}
    /** get 비과세소득_H16 : taxmEh16 */
    public BigDecimal  getTaxmEh16() { return (BigDecimal )get( ATTR_TAXMEH16 );}

    /** set 비과세소득_I01 : taxmEi01 */
    public void setTaxmEi01(BigDecimal  taxmEi01) { set( ATTR_TAXMEI01 ,taxmEi01);}
    /** get 비과세소득_I01 : taxmEi01 */
    public BigDecimal  getTaxmEi01() { return (BigDecimal )get( ATTR_TAXMEI01 );}

    /** set 비과세소득_J01 : taxmEj01 */
    public void setTaxmEj01(BigDecimal  taxmEj01) { set( ATTR_TAXMEJ01 ,taxmEj01);}
    /** get 비과세소득_J01 : taxmEj01 */
    public BigDecimal  getTaxmEj01() { return (BigDecimal )get( ATTR_TAXMEJ01 );}

    /** set 비과세소득_J10 : taxmEj10 */
    public void setTaxmEj10(BigDecimal  taxmEj10) { set( ATTR_TAXMEJ10 ,taxmEj10);}
    /** get 비과세소득_J10 : taxmEj10 */
    public BigDecimal  getTaxmEj10() { return (BigDecimal )get( ATTR_TAXMEJ10 );}

    /** set 비과세소득_K01 : taxmEk01 */
    public void setTaxmEk01(BigDecimal  taxmEk01) { set( ATTR_TAXMEK01 ,taxmEk01);}
    /** get 비과세소득_K01 : taxmEk01 */
    public BigDecimal  getTaxmEk01() { return (BigDecimal )get( ATTR_TAXMEK01 );}

    /** set 비과세소득_L01 : taxmEl01 */
    public void setTaxmEl01(BigDecimal  taxmEl01) { set( ATTR_TAXMEL01 ,taxmEl01);}
    /** get 비과세소득_L01 : taxmEl01 */
    public BigDecimal  getTaxmEl01() { return (BigDecimal )get( ATTR_TAXMEL01 );}

    /** set 비과세소득_M01 : taxmEm01 */
    public void setTaxmEm01(BigDecimal  taxmEm01) { set( ATTR_TAXMEM01 ,taxmEm01);}
    /** get 비과세소득_M01 : taxmEm01 */
    public BigDecimal  getTaxmEm01() { return (BigDecimal )get( ATTR_TAXMEM01 );}

    /** set 비과세소득_M02 : taxmEm02 */
    public void setTaxmEm02(BigDecimal  taxmEm02) { set( ATTR_TAXMEM02 ,taxmEm02);}
    /** get 비과세소득_M02 : taxmEm02 */
    public BigDecimal  getTaxmEm02() { return (BigDecimal )get( ATTR_TAXMEM02 );}

    /** set 비과세소득_M03 : taxmEm03 */
    public void setTaxmEm03(BigDecimal  taxmEm03) { set( ATTR_TAXMEM03 ,taxmEm03);}
    /** get 비과세소득_M03 : taxmEm03 */
    public BigDecimal  getTaxmEm03() { return (BigDecimal )get( ATTR_TAXMEM03 );}

    /** set 비과세소득_N01 : taxmEn01 */
    public void setTaxmEn01(BigDecimal  taxmEn01) { set( ATTR_TAXMEN01 ,taxmEn01);}
    /** get 비과세소득_N01 : taxmEn01 */
    public BigDecimal  getTaxmEn01() { return (BigDecimal )get( ATTR_TAXMEN01 );}

    /** set 비과세소득_O01 : taxmEo01 */
    public void setTaxmEo01(BigDecimal  taxmEo01) { set( ATTR_TAXMEO01 ,taxmEo01);}
    /** get 비과세소득_O01 : taxmEo01 */
    public BigDecimal  getTaxmEo01() { return (BigDecimal )get( ATTR_TAXMEO01 );}

    /** set 비과세소득_P01 : taxmEp01 */
    public void setTaxmEp01(BigDecimal  taxmEp01) { set( ATTR_TAXMEP01 ,taxmEp01);}
    /** get 비과세소득_P01 : taxmEp01 */
    public BigDecimal  getTaxmEp01() { return (BigDecimal )get( ATTR_TAXMEP01 );}

    /** set 비과세소득_P02 : taxmEp02 */
    public void setTaxmEp02(BigDecimal  taxmEp02) { set( ATTR_TAXMEP02 ,taxmEp02);}
    /** get 비과세소득_P02 : taxmEp02 */
    public BigDecimal  getTaxmEp02() { return (BigDecimal )get( ATTR_TAXMEP02 );}

    /** set 비과세소득_Q01 : taxmEq01 */
    public void setTaxmEq01(BigDecimal  taxmEq01) { set( ATTR_TAXMEQ01 ,taxmEq01);}
    /** get 비과세소득_Q01 : taxmEq01 */
    public BigDecimal  getTaxmEq01() { return (BigDecimal )get( ATTR_TAXMEQ01 );}

    /** set 비과세소득_R01 : taxmEr01 */
    public void setTaxmEr01(BigDecimal  taxmEr01) { set( ATTR_TAXMER01 ,taxmEr01);}
    /** get 비과세소득_R01 : taxmEr01 */
    public BigDecimal  getTaxmEr01() { return (BigDecimal )get( ATTR_TAXMER01 );}

    /** set 비과세소득_R10 : taxmEr10 */
    public void setTaxmEr10(BigDecimal  taxmEr10) { set( ATTR_TAXMER10 ,taxmEr10);}
    /** get 비과세소득_R10 : taxmEr10 */
    public BigDecimal  getTaxmEr10() { return (BigDecimal )get( ATTR_TAXMER10 );}

    /** set 비과세소득_S01 : taxmEs01 */
    public void setTaxmEs01(BigDecimal  taxmEs01) { set( ATTR_TAXMES01 ,taxmEs01);}
    /** get 비과세소득_S01 : taxmEs01 */
    public BigDecimal  getTaxmEs01() { return (BigDecimal )get( ATTR_TAXMES01 );}

    /** set 비과세소득_Y02 : taxmEy02 */
    public void setTaxmEy02(BigDecimal  taxmEy02) { set( ATTR_TAXMEY02 ,taxmEy02);}
    /** get 비과세소득_Y02 : taxmEy02 */
    public BigDecimal  getTaxmEy02() { return (BigDecimal )get( ATTR_TAXMEY02 );}

    /** set 비과세소득_Y03 : taxmEy03 */
    public void setTaxmEy03(BigDecimal  taxmEy03) { set( ATTR_TAXMEY03 ,taxmEy03);}
    /** get 비과세소득_Y03 : taxmEy03 */
    public BigDecimal  getTaxmEy03() { return (BigDecimal )get( ATTR_TAXMEY03 );}

    /** set 비과세소득_Y21 : taxmEy21 */
    public void setTaxmEy21(BigDecimal  taxmEy21) { set( ATTR_TAXMEY21 ,taxmEy21);}
    /** get 비과세소득_Y21 : taxmEy21 */
    public BigDecimal  getTaxmEy21() { return (BigDecimal )get( ATTR_TAXMEY21 );}

    /** set 비과세소득_Y22 : taxmEy22 */
    public void setTaxmEy22(BigDecimal  taxmEy22) { set( ATTR_TAXMEY22 ,taxmEy22);}
    /** get 비과세소득_Y22 : taxmEy22 */
    public BigDecimal  getTaxmEy22() { return (BigDecimal )get( ATTR_TAXMEY22 );}

    /** set 감면소득_T01 : taxmEt01 */
    public void setTaxmEt01(BigDecimal  taxmEt01) { set( ATTR_TAXMET01 ,taxmEt01);}
    /** get 감면소득_T01 : taxmEt01 */
    public BigDecimal  getTaxmEt01() { return (BigDecimal )get( ATTR_TAXMET01 );}

    /** set 감면소득_T10 : taxmEt10 */
    public void setTaxmEt10(BigDecimal  taxmEt10) { set( ATTR_TAXMET10 ,taxmEt10);}
    /** get 감면소득_T10 : taxmEt10 */
    public BigDecimal  getTaxmEt10() { return (BigDecimal )get( ATTR_TAXMET10 );}

    /** set 감면소득_T20 : taxmEt20 */
    public void setTaxmEt20(BigDecimal  taxmEt20) { set( ATTR_TAXMET20 ,taxmEt20);}
    /** get 감면소득_T20 : taxmEt20 */
    public BigDecimal  getTaxmEt20() { return (BigDecimal )get( ATTR_TAXMET20 );}

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
