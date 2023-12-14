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
public class Ye16Ta3120BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set 금전소비대차일련번호 : cnclSqno */
    public static final String ATTR_CNCLSQNO = "cnclSqno";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 금전소비대차_임대인성명 : cnclName */
    public static final String ATTR_CNCLNAME = "cnclName";

    /** set 금전소비대차_주민번호 : cnclRsno */
    public static final String ATTR_CNCLRSNO = "cnclRsno";

    /** set 금전소비대차_계약시작일자 : cnclStdt */
    public static final String ATTR_CNCLSTDT = "cnclStdt";

    /** set 금전소비대차_계약종료일자 : cnclEddt */
    public static final String ATTR_CNCLEDDT = "cnclEddt";

    /** set 금전소비대차_차입금이자율 : cnclItro */
    public static final String ATTR_CNCLITRO = "cnclItro";

    /** set 금전소비대차_원리금상환액계 : cnclRdmt */
    public static final String ATTR_CNCLRDMT = "cnclRdmt";

    /** set 금전소비대차_원리금 : cnclPrpl */
    public static final String ATTR_CNCLPRPL = "cnclPrpl";

    /** set 금전소비대차_이자 : cnclItrt */
    public static final String ATTR_CNCLITRT = "cnclItrt";

    /** set 금전소비대차_공제금액 : cnclDuam */
    public static final String ATTR_CNCLDUAM = "cnclDuam";

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
     public Ye16Ta3120BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3120BM(
    		 String  edacRvyy 
    		, String  settGbcd 
    		, BigDecimal  cnclSqno 
    		, String  dpobCd 
    		, String  systemkey 
    		, String  cnclName 
    		, String  cnclRsno 
    		, String  cnclStdt 
    		, String  cnclEddt 
    		, BigDecimal  cnclItro 
    		, BigDecimal  cnclRdmt 
    		, BigDecimal  cnclPrpl 
    		, BigDecimal  cnclItrt 
    		, BigDecimal  cnclDuam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_CNCLSQNO,cnclSqno);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_CNCLNAME,cnclName);
     	values.put(ATTR_CNCLRSNO,cnclRsno);
     	values.put(ATTR_CNCLSTDT,cnclStdt);
     	values.put(ATTR_CNCLEDDT,cnclEddt);
     	values.put(ATTR_CNCLITRO,cnclItro);
     	values.put(ATTR_CNCLRDMT,cnclRdmt);
     	values.put(ATTR_CNCLPRPL,cnclPrpl);
     	values.put(ATTR_CNCLITRT,cnclItrt);
     	values.put(ATTR_CNCLDUAM,cnclDuam);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}

    /** set 금전소비대차일련번호 : cnclSqno */
    public void setCnclSqno(BigDecimal  cnclSqno) { set( ATTR_CNCLSQNO ,cnclSqno);}
    /** get 금전소비대차일련번호 : cnclSqno */
    public BigDecimal  getCnclSqno() { return (BigDecimal )get( ATTR_CNCLSQNO );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 금전소비대차_임대인성명 : cnclName */
    public void setCnclName(String  cnclName) { set( ATTR_CNCLNAME ,cnclName);}
    /** get 금전소비대차_임대인성명 : cnclName */
    public String  getCnclName() { return (String )get( ATTR_CNCLNAME );}

    /** set 금전소비대차_주민번호 : cnclRsno */
    public void setCnclRsno(String  cnclRsno) { set( ATTR_CNCLRSNO ,cnclRsno);}
    /** get 금전소비대차_주민번호 : cnclRsno */
    public String  getCnclRsno() { return (String )get( ATTR_CNCLRSNO );}

    /** set 금전소비대차_계약시작일자 : cnclStdt */
    public void setCnclStdt(String  cnclStdt) { set( ATTR_CNCLSTDT ,cnclStdt);}
    /** get 금전소비대차_계약시작일자 : cnclStdt */
    public String  getCnclStdt() { return (String )get( ATTR_CNCLSTDT );}

    /** set 금전소비대차_계약종료일자 : cnclEddt */
    public void setCnclEddt(String  cnclEddt) { set( ATTR_CNCLEDDT ,cnclEddt);}
    /** get 금전소비대차_계약종료일자 : cnclEddt */
    public String  getCnclEddt() { return (String )get( ATTR_CNCLEDDT );}

    /** set 금전소비대차_차입금이자율 : cnclItro */
    public void setCnclItro(BigDecimal  cnclItro) { set( ATTR_CNCLITRO ,cnclItro);}
    /** get 금전소비대차_차입금이자율 : cnclItro */
    public BigDecimal  getCnclItro() { return (BigDecimal )get( ATTR_CNCLITRO );}

    /** set 금전소비대차_원리금상환액계 : cnclRdmt */
    public void setCnclRdmt(BigDecimal  cnclRdmt) { set( ATTR_CNCLRDMT ,cnclRdmt);}
    /** get 금전소비대차_원리금상환액계 : cnclRdmt */
    public BigDecimal  getCnclRdmt() { return (BigDecimal )get( ATTR_CNCLRDMT );}

    /** set 금전소비대차_원리금 : cnclPrpl */
    public void setCnclPrpl(BigDecimal  cnclPrpl) { set( ATTR_CNCLPRPL ,cnclPrpl);}
    /** get 금전소비대차_원리금 : cnclPrpl */
    public BigDecimal  getCnclPrpl() { return (BigDecimal )get( ATTR_CNCLPRPL );}

    /** set 금전소비대차_이자 : cnclItrt */
    public void setCnclItrt(BigDecimal  cnclItrt) { set( ATTR_CNCLITRT ,cnclItrt);}
    /** get 금전소비대차_이자 : cnclItrt */
    public BigDecimal  getCnclItrt() { return (BigDecimal )get( ATTR_CNCLITRT );}

    /** set 금전소비대차_공제금액 : cnclDuam */
    public void setCnclDuam(BigDecimal  cnclDuam) { set( ATTR_CNCLDUAM ,cnclDuam);}
    /** get 금전소비대차_공제금액 : cnclDuam */
    public BigDecimal  getCnclDuam() { return (BigDecimal )get( ATTR_CNCLDUAM );}

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
