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
public class Yeta3130BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";

    /** set 월세일련번호 : mnrnSqno */
    public static final String ATTR_MNRNSQNO = "mnrnSqno";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 월세_임대인성명 : mnrnName */
    public static final String ATTR_MNRNNAME = "mnrnName";

    /** set 월세_주민번호 : mnrnRsno */
    public static final String ATTR_MNRNRSNO = "mnrnRsno";

    /** set 월세_주택유형코드 : mnrnTyhu */
    public static final String ATTR_MNRNTYHU = "mnrnTyhu";
    
    /** set 월세_주택유형코드명 : mnrnTyhuNm */
    public static final String ATTR_MNRNTYHUNM = "mnrnTyhuNm";

    /** set 월세주택계약면적 : mnrnArea */
    public static final String ATTR_MNRNAREA = "mnrnArea";

    /** set 월세_계약서상주소 : mnrnAddr */
    public static final String ATTR_MNRNADDR = "mnrnAddr";

    /** set 월세_임대차계약시작일자 : mnrnStdt */
    public static final String ATTR_MNRNSTDT = "mnrnStdt";

    /** set 월세_임대차계약종료일자 : mnrnEddt */
    public static final String ATTR_MNRNEDDT = "mnrnEddt";

    /** set 월세_연간월세금액 : mnrnAmnt */
    public static final String ATTR_MNRNAMNT = "mnrnAmnt";

    /** set 월세_월세세액공제금액 : mnrnDuam */
    public static final String ATTR_MNRNDUAM = "mnrnDuam";

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
     public Yeta3130BM() { super(); } 

    /** 일괄등록 처리   */
     public Yeta3130BM(
    		 String  edacRvyy 
    		, String  settGbcd 
    		, BigDecimal  mnrnSqno 
    		, String  dpobCd 
    		, String  systemkey 
    		, String  mnrnName 
    		, String  mnrnRsno 
    		, String  mnrnTyhu 
    		, String  mnrnArea 
    		, String  mnrnAddr 
    		, String  mnrnStdt 
    		, String  mnrnEddt 
    		, BigDecimal  mnrnAmnt 
    		, BigDecimal  mnrnDuam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_MNRNSQNO,mnrnSqno);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_MNRNNAME,mnrnName);
     	values.put(ATTR_MNRNRSNO,mnrnRsno);
     	values.put(ATTR_MNRNTYHU,mnrnTyhu);
     	values.put(ATTR_MNRNAREA,mnrnArea);
     	values.put(ATTR_MNRNADDR,mnrnAddr);
     	values.put(ATTR_MNRNSTDT,mnrnStdt);
     	values.put(ATTR_MNRNEDDT,mnrnEddt);
     	values.put(ATTR_MNRNAMNT,mnrnAmnt);
     	values.put(ATTR_MNRNDUAM,mnrnDuam);
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

    /** set 월세일련번호 : mnrnSqno */
    public void setMnrnSqno(BigDecimal  mnrnSqno) { set( ATTR_MNRNSQNO ,mnrnSqno);}
    /** get 월세일련번호 : mnrnSqno */
    public BigDecimal  getMnrnSqno() { return (BigDecimal )get( ATTR_MNRNSQNO );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 월세_임대인성명 : mnrnName */
    public void setMnrnName(String  mnrnName) { set( ATTR_MNRNNAME ,mnrnName);}
    /** get 월세_임대인성명 : mnrnName */
    public String  getMnrnName() { return (String )get( ATTR_MNRNNAME );}

    /** set 월세_주민번호 : mnrnRsno */
    public void setMnrnRsno(String  mnrnRsno) { set( ATTR_MNRNRSNO ,mnrnRsno);}
    /** get 월세_주민번호 : mnrnRsno */
    public String  getMnrnRsno() { return (String )get( ATTR_MNRNRSNO );}

    /** set 월세_주택유형코드 : mnrnTyhu */
    public void setMnrnTyhu(String  mnrnTyhu) { set( ATTR_MNRNTYHU ,mnrnTyhu);}
    /** get 월세_주택유형코드 : mnrnTyhu */
    public String  getMnrnTyhu() { return (String )get( ATTR_MNRNTYHU );}
    
    /** set 월세_주택유형코드명 : mnrnTyhuNm */
    public void setMnrnTyhuNm(String  mnrnTyhuNm) { set( ATTR_MNRNTYHUNM ,mnrnTyhuNm);}
    /** get 월세_주택유형코드명 : mnrnTyhuNm */
    public String  getMnrnTyhuNm() { return (String )get( ATTR_MNRNTYHUNM );}

    /** set 월세주택계약면적 : mnrnArea */
    public void setMnrnArea(String  mnrnArea) { set( ATTR_MNRNAREA ,mnrnArea);}
    /** get 월세주택계약면적 : mnrnArea */
    public String  getMnrnArea() { return (String )get( ATTR_MNRNAREA );}

    /** set 월세_계약서상주소 : mnrnAddr */
    public void setMnrnAddr(String  mnrnAddr) { set( ATTR_MNRNADDR ,mnrnAddr);}
    /** get 월세_계약서상주소 : mnrnAddr */
    public String  getMnrnAddr() { return (String )get( ATTR_MNRNADDR );}

    /** set 월세_임대차계약시작일자 : mnrnStdt */
    public void setMnrnStdt(String  mnrnStdt) { set( ATTR_MNRNSTDT ,mnrnStdt);}
    /** get 월세_임대차계약시작일자 : mnrnStdt */
    public String  getMnrnStdt() { return (String )get( ATTR_MNRNSTDT );}

    /** set 월세_임대차계약종료일자 : mnrnEddt */
    public void setMnrnEddt(String  mnrnEddt) { set( ATTR_MNRNEDDT ,mnrnEddt);}
    /** get 월세_임대차계약종료일자 : mnrnEddt */
    public String  getMnrnEddt() { return (String )get( ATTR_MNRNEDDT );}

    /** set 월세_연간월세금액 : mnrnAmnt */
    public void setMnrnAmnt(BigDecimal  mnrnAmnt) { set( ATTR_MNRNAMNT ,mnrnAmnt);}
    /** get 월세_연간월세금액 : mnrnAmnt */
    public BigDecimal  getMnrnAmnt() { return (BigDecimal )get( ATTR_MNRNAMNT );}

    /** set 월세_월세세액공제금액 : mnrnDuam */
    public void setMnrnDuam(BigDecimal  mnrnDuam) { set( ATTR_MNRNDUAM ,mnrnDuam);}
    /** get 월세_월세세액공제금액 : mnrnDuam */
    public BigDecimal  getMnrnDuam() { return (BigDecimal )get( ATTR_MNRNDUAM );}

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
