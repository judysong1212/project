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
public class Ye16Ta3160BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set 임대차일련번호 : leasSqno */
    public static final String ATTR_LEASSQNO = "leasSqno";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 임대차_임대인성명 : leasName */
    public static final String ATTR_LEASNAME = "leasName";

    /** set 임대차_주민번호 : leasRsno */
    public static final String ATTR_LEASRSNO = "leasRsno";

    /** set 임대차_주택유형코드 : leasTyhu */
    public static final String ATTR_LEASTYHU = "leasTyhu";

    /** set 임대차_주책계약면적 : leasArea */
    public static final String ATTR_LEASAREA = "leasArea";

    /** set 임대차_계약서상주소 : leasAddr */
    public static final String ATTR_LEASADDR = "leasAddr";

    /** set 임대차_계약시작일자 : leasStdt */
    public static final String ATTR_LEASSTDT = "leasStdt";

    /** set 임대차_계약종료일자 : leasEddt */
    public static final String ATTR_LEASEDDT = "leasEddt";

    /** set 임대차_전세보증금액 : leasDpst */
    public static final String ATTR_LEASDPST = "leasDpst";

    /** 생성자 */
     public Ye16Ta3160BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3160BM(
    		 String  edacRvyy 
    		, String  settGbcd 
    		, BigDecimal  leasSqno 
    		, String  dpobCd 
    		, String  systemkey 
    		, String  leasName 
    		, String  leasRsno 
    		, String  leasTyhu 
    		, String  leasArea 
    		, String  leasAddr 
    		, String  leasStdt 
    		, String  leasEddt 
    		, BigDecimal  leasDpst ) { 
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_LEASSQNO,leasSqno);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_LEASNAME,leasName);
     	values.put(ATTR_LEASRSNO,leasRsno);
     	values.put(ATTR_LEASTYHU,leasTyhu);
     	values.put(ATTR_LEASAREA,leasArea);
     	values.put(ATTR_LEASADDR,leasAddr);
     	values.put(ATTR_LEASSTDT,leasStdt);
     	values.put(ATTR_LEASEDDT,leasEddt);
     	values.put(ATTR_LEASDPST,leasDpst); } 

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set 임대차일련번호 : leasSqno */
    public void setLeasSqno(BigDecimal  leasSqno) { set( ATTR_LEASSQNO ,leasSqno);}
    /** get 임대차일련번호 : leasSqno */
    public BigDecimal  getLeasSqno() { return (BigDecimal )get( ATTR_LEASSQNO );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 임대차_임대인성명 : leasName */
    public void setLeasName(String  leasName) { set( ATTR_LEASNAME ,leasName);}
    /** get 임대차_임대인성명 : leasName */
    public String  getLeasName() { return (String )get( ATTR_LEASNAME );}

    /** set 임대차_주민번호 : leasRsno */
    public void setLeasRsno(String  leasRsno) { set( ATTR_LEASRSNO ,leasRsno);}
    /** get 임대차_주민번호 : leasRsno */
    public String  getLeasRsno() { return (String )get( ATTR_LEASRSNO );}

    /** set 임대차_주택유형코드 : leasTyhu */
    public void setLeasTyhu(String  leasTyhu) { set( ATTR_LEASTYHU ,leasTyhu);}
    /** get 임대차_주택유형코드 : leasTyhu */
    public String  getLeasTyhu() { return (String )get( ATTR_LEASTYHU );}

    /** set 임대차_주책계약면적 : leasArea */
    public void setLeasArea(String  leasArea) { set( ATTR_LEASAREA ,leasArea);}
    /** get 임대차_주책계약면적 : leasArea */
    public String  getLeasArea() { return (String )get( ATTR_LEASAREA );}

    /** set 임대차_계약서상주소 : leasAddr */
    public void setLeasAddr(String  leasAddr) { set( ATTR_LEASADDR ,leasAddr);}
    /** get 임대차_계약서상주소 : leasAddr */
    public String  getLeasAddr() { return (String )get( ATTR_LEASADDR );}

    /** set 임대차_계약시작일자 : leasStdt */
    public void setLeasStdt(String  leasStdt) { set( ATTR_LEASSTDT ,leasStdt);}
    /** get 임대차_계약시작일자 : leasStdt */
    public String  getLeasStdt() { return (String )get( ATTR_LEASSTDT );}

    /** set 임대차_계약종료일자 : leasEddt */
    public void setLeasEddt(String  leasEddt) { set( ATTR_LEASEDDT ,leasEddt);}
    /** get 임대차_계약종료일자 : leasEddt */
    public String  getLeasEddt() { return (String )get( ATTR_LEASEDDT );}

    /** set 임대차_전세보증금액 : leasDpst */
    public void setLeasDpst(BigDecimal  leasDpst) { set( ATTR_LEASDPST ,leasDpst);}
    /** get 임대차_전세보증금액 : leasDpst */
    public BigDecimal  getLeasDpst() { return (BigDecimal )get( ATTR_LEASDPST );}

   
  
}
