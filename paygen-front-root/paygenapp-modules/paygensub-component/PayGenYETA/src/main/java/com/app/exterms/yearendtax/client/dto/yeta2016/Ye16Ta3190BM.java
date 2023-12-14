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
public class Ye16Ta3190BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 기부조정명세일련번호 : ctrbSeqn */
    public static final String ATTR_CTRBSEQN = "ctrbSeqn";

    /** set 기부조정명세유형구분코드 : ctrbDdcd */
    public static final String ATTR_CTRBDDCD = "ctrbDdcd";

    /** set 기부조정명세유형코드 : ctrbTycd */
    public static final String ATTR_CTRBTYCD = "ctrbTycd";

    /** set 기부조정명세기부연도 : ctrbYrmn */
    public static final String ATTR_CTRBYRMN = "ctrbYrmn";

    /** set 기부조정명세기부금액 : ctrbAmnt */
    public static final String ATTR_CTRBAMNT = "ctrbAmnt";

    /** set 전년도_공제금액 : bfyrDeam */
    public static final String ATTR_BFYRDEAM = "bfyrDeam";

    /** set 공제대상금액 : detrAmnt */
    public static final String ATTR_DETRAMNT = "detrAmnt";

    /** set 해당연도공제금액 : dyyrDeam */
    public static final String ATTR_DYYRDEAM = "dyyrDeam";

    /** set 해당년도_미공제소멸금액 : dyyrOtam */
    public static final String ATTR_DYYROTAM = "dyyrOtam";

    /** set 해당년도_미공제이월금액 : ayyrNtam */
    public static final String ATTR_AYYRNTAM = "ayyrNtam";

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
     public Ye16Ta3190BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3190BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, BigDecimal  ctrbSeqn 
    		, String  ctrbDdcd 
    		, String  ctrbTycd 
    		, String  ctrbYrmn 
    		, BigDecimal  ctrbAmnt 
    		, BigDecimal  bfyrDeam 
    		, BigDecimal  detrAmnt 
    		, BigDecimal  dyyrDeam 
    		, BigDecimal  dyyrOtam 
    		, BigDecimal  ayyrNtam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_CTRBSEQN,ctrbSeqn);
     	values.put(ATTR_CTRBDDCD,ctrbDdcd);
     	values.put(ATTR_CTRBTYCD,ctrbTycd);
     	values.put(ATTR_CTRBYRMN,ctrbYrmn);
     	values.put(ATTR_CTRBAMNT,ctrbAmnt);
     	values.put(ATTR_BFYRDEAM,bfyrDeam);
     	values.put(ATTR_DETRAMNT,detrAmnt);
     	values.put(ATTR_DYYRDEAM,dyyrDeam);
     	values.put(ATTR_DYYROTAM,dyyrOtam);
     	values.put(ATTR_AYYRNTAM,ayyrNtam);
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

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 기부조정명세일련번호 : ctrbSeqn */
    public void setCtrbSeqn(BigDecimal  ctrbSeqn) { set( ATTR_CTRBSEQN ,ctrbSeqn);}
    /** get 기부조정명세일련번호 : ctrbSeqn */
    public BigDecimal  getCtrbSeqn() { return (BigDecimal )get( ATTR_CTRBSEQN );}

    /** set 기부조정명세유형구분코드 : ctrbDdcd */
    public void setCtrbDdcd(String  ctrbDdcd) { set( ATTR_CTRBDDCD ,ctrbDdcd);}
    /** get 기부조정명세유형구분코드 : ctrbDdcd */
    public String  getCtrbDdcd() { return (String )get( ATTR_CTRBDDCD );}

    /** set 기부조정명세유형코드 : ctrbTycd */
    public void setCtrbTycd(String  ctrbTycd) { set( ATTR_CTRBTYCD ,ctrbTycd);}
    /** get 기부조정명세유형코드 : ctrbTycd */
    public String  getCtrbTycd() { return (String )get( ATTR_CTRBTYCD );}

    /** set 기부조정명세기부연도 : ctrbYrmn */
    public void setCtrbYrmn(String  ctrbYrmn) { set( ATTR_CTRBYRMN ,ctrbYrmn);}
    /** get 기부조정명세기부연도 : ctrbYrmn */
    public String  getCtrbYrmn() { return (String )get( ATTR_CTRBYRMN );}

    /** set 기부조정명세기부금액 : ctrbAmnt */
    public void setCtrbAmnt(BigDecimal  ctrbAmnt) { set( ATTR_CTRBAMNT ,ctrbAmnt);}
    /** get 기부조정명세기부금액 : ctrbAmnt */
    public BigDecimal  getCtrbAmnt() { return (BigDecimal )get( ATTR_CTRBAMNT );}

    /** set 전년도_공제금액 : bfyrDeam */
    public void setBfyrDeam(BigDecimal  bfyrDeam) { set( ATTR_BFYRDEAM ,bfyrDeam);}
    /** get 전년도_공제금액 : bfyrDeam */
    public BigDecimal  getBfyrDeam() { return (BigDecimal )get( ATTR_BFYRDEAM );}

    /** set 공제대상금액 : detrAmnt */
    public void setDetrAmnt(BigDecimal  detrAmnt) { set( ATTR_DETRAMNT ,detrAmnt);}
    /** get 공제대상금액 : detrAmnt */
    public BigDecimal  getDetrAmnt() { return (BigDecimal )get( ATTR_DETRAMNT );}

    /** set 해당연도공제금액 : dyyrDeam */
    public void setDyyrDeam(BigDecimal  dyyrDeam) { set( ATTR_DYYRDEAM ,dyyrDeam);}
    /** get 해당연도공제금액 : dyyrDeam */
    public BigDecimal  getDyyrDeam() { return (BigDecimal )get( ATTR_DYYRDEAM );}

    /** set 해당년도_미공제소멸금액 : dyyrOtam */
    public void setDyyrOtam(BigDecimal  dyyrOtam) { set( ATTR_DYYROTAM ,dyyrOtam);}
    /** get 해당년도_미공제소멸금액 : dyyrOtam */
    public BigDecimal  getDyyrOtam() { return (BigDecimal )get( ATTR_DYYROTAM );}

    /** set 해당년도_미공제이월금액 : ayyrNtam */
    public void setAyyrNtam(BigDecimal  ayyrNtam) { set( ATTR_AYYRNTAM ,ayyrNtam);}
    /** get 해당년도_미공제이월금액 : ayyrNtam */
    public BigDecimal  getAyyrNtam() { return (BigDecimal )get( ATTR_AYYRNTAM );}

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
