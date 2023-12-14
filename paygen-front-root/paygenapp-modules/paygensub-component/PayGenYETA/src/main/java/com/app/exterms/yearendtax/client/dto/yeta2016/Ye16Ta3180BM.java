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
public class Ye16Ta3180BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 정산구분 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 기부내역일련번호 : ctrbSeqn */
    public static final String ATTR_CTRBSEQN = "ctrbSeqn";

    /** set 기부유형구분코드 : ctrbDdcd */
    public static final String ATTR_CTRBDDCD = "ctrbDdcd";

    /** set 기부유형코드 : ctrbTycd */
    public static final String ATTR_CTRBTYCD = "ctrbTycd";

    /** set 기부내용 : ctrbCont */
    public static final String ATTR_CTRBCONT = "ctrbCont";

    /** set 기부연도 : ctrbYrmn */
    public static final String ATTR_CTRBYRMN = "ctrbYrmn";

    /** set 기부처명 : ctrbName */
    public static final String ATTR_CTRBNAME = "ctrbName";

    /** set 기부처사업자번호 : ctrbBsnu */
    public static final String ATTR_CTRBBSNU = "ctrbBsnu";

    /** set 기부금액 : ctrbAmnt */
    public static final String ATTR_CTRBAMNT = "ctrbAmnt";

    /** set 기부자관계구분코드 : crtbCncd */
    public static final String ATTR_CRTBCNCD = "crtbCncd";

    /** set 기부자내국인구분코드 : crnrFlag */
    public static final String ATTR_CRNRFLAG = "crnrFlag";

    /** set 기부자성명 : cbtgName */
    public static final String ATTR_CBTGNAME = "cbtgName";

    /** set 주민등록번호 : rsnoNumb */
    public static final String ATTR_RSNONUMB = "rsnoNumb";

    /** set 기부금유형콤보TEMP : ctrbCtnt */
    public static final String ATTR_CTRBCTNT = "ctrbCtnt";

    /** set 영수증유무 : receRati */
    public static final String ATTR_RECERATI = "receRati";

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


/** set 기부금건수 : ctrbNcnt */
public static final String ATTR_CTRBNCNT = "ctrbNcnt";

/** set 공제대상기부금액 : ctrbTgam */
public static final String ATTR_CTRBTGAM = "ctrbTgam";

/** set 기부장려신청금액 : ctjaCham */
public static final String ATTR_CTJACHAM = "ctjaCham";


    /** 생성자 */
     public Ye16Ta3180BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3180BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, BigDecimal  ctrbSeqn 
    		, String  ctrbDdcd 
    		, String  ctrbTycd 
    		, String  ctrbCont 
    		, String  ctrbYrmn 
    		, String  ctrbName 
    		, String  ctrbBsnu 
    		, BigDecimal  ctrbAmnt 
    		, String  crtbCncd 
    		, String  crnrFlag 
    		, String  cbtgName 
    		, String  rsnoNumb 
    		, String  ctrbCtnt 
    		, String  receRati 
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
     	values.put(ATTR_CTRBCONT,ctrbCont);
     	values.put(ATTR_CTRBYRMN,ctrbYrmn);
     	values.put(ATTR_CTRBNAME,ctrbName);
     	values.put(ATTR_CTRBBSNU,ctrbBsnu);
     	values.put(ATTR_CTRBAMNT,ctrbAmnt);
     	values.put(ATTR_CRTBCNCD,crtbCncd);
     	values.put(ATTR_CRNRFLAG,crnrFlag);
     	values.put(ATTR_CBTGNAME,cbtgName);
     	values.put(ATTR_RSNONUMB,rsnoNumb);
     	values.put(ATTR_CTRBCTNT,ctrbCtnt);
     	values.put(ATTR_RECERATI,receRati);
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
    
    /** set 정산구분 : settGbnm */
    public void setSettGbnm(String  settGbnm) { set( ATTR_SETTGBNM ,settGbnm);}
    /** get 정산구분 : settGbnm */
    public String  getSettGbnm() { return (String )get( ATTR_SETTGBNM );}
    
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 기부내역일련번호 : ctrbSeqn */
    public void setCtrbSeqn(BigDecimal  ctrbSeqn) { set( ATTR_CTRBSEQN ,ctrbSeqn);}
    /** get 기부내역일련번호 : ctrbSeqn */
    public BigDecimal  getCtrbSeqn() { return (BigDecimal )get( ATTR_CTRBSEQN );}

    /** set 기부유형구분코드 : ctrbDdcd */
    public void setCtrbDdcd(String  ctrbDdcd) { set( ATTR_CTRBDDCD ,ctrbDdcd);}
    /** get 기부유형구분코드 : ctrbDdcd */
    public String  getCtrbDdcd() { return (String )get( ATTR_CTRBDDCD );}

    /** set 기부유형코드 : ctrbTycd */
    public void setCtrbTycd(String  ctrbTycd) { set( ATTR_CTRBTYCD ,ctrbTycd);}
    /** get 기부유형코드 : ctrbTycd */
    public String  getCtrbTycd() { return (String )get( ATTR_CTRBTYCD );}

    /** set 기부내용 : ctrbCont */
    public void setCtrbCont(String  ctrbCont) { set( ATTR_CTRBCONT ,ctrbCont);}
    /** get 기부내용 : ctrbCont */
    public String  getCtrbCont() { return (String )get( ATTR_CTRBCONT );}

    /** set 기부연도 : ctrbYrmn */
    public void setCtrbYrmn(String  ctrbYrmn) { set( ATTR_CTRBYRMN ,ctrbYrmn);}
    /** get 기부연도 : ctrbYrmn */
    public String  getCtrbYrmn() { return (String )get( ATTR_CTRBYRMN );}

    /** set 기부처명 : ctrbName */
    public void setCtrbName(String  ctrbName) { set( ATTR_CTRBNAME ,ctrbName);}
    /** get 기부처명 : ctrbName */
    public String  getCtrbName() { return (String )get( ATTR_CTRBNAME );}

    /** set 기부처사업자번호 : ctrbBsnu */
    public void setCtrbBsnu(String  ctrbBsnu) { set( ATTR_CTRBBSNU ,ctrbBsnu);}
    /** get 기부처사업자번호 : ctrbBsnu */
    public String  getCtrbBsnu() { return (String )get( ATTR_CTRBBSNU );}

    /** set 기부금액 : ctrbAmnt */
    public void setCtrbAmnt(BigDecimal  ctrbAmnt) { set( ATTR_CTRBAMNT ,ctrbAmnt);}
    /** get 기부금액 : ctrbAmnt */
    public BigDecimal  getCtrbAmnt() { return (BigDecimal )get( ATTR_CTRBAMNT );}

    /** set 기부자관계구분코드 : crtbCncd */
    public void setCrtbCncd(String  crtbCncd) { set( ATTR_CRTBCNCD ,crtbCncd);}
    /** get 기부자관계구분코드 : crtbCncd */
    public String  getCrtbCncd() { return (String )get( ATTR_CRTBCNCD );}

    /** set 기부자내국인구분코드 : crnrFlag */
    public void setCrnrFlag(String  crnrFlag) { set( ATTR_CRNRFLAG ,crnrFlag);}
    /** get 기부자내국인구분코드 : crnrFlag */
    public String  getCrnrFlag() { return (String )get( ATTR_CRNRFLAG );}

    /** set 기부자성명 : cbtgName */
    public void setCbtgName(String  cbtgName) { set( ATTR_CBTGNAME ,cbtgName);}
    /** get 기부자성명 : cbtgName */
    public String  getCbtgName() { return (String )get( ATTR_CBTGNAME );}

    /** set 주민등록번호 : rsnoNumb */
    public void setRsnoNumb(String  rsnoNumb) { set( ATTR_RSNONUMB ,rsnoNumb);}
    /** get 주민등록번호 : rsnoNumb */
    public String  getRsnoNumb() { return (String )get( ATTR_RSNONUMB );}

    /** set 기부금유형콤보TEMP : ctrbCtnt */
    public void setCtrbCtnt(String  ctrbCtnt) { set( ATTR_CTRBCTNT ,ctrbCtnt);}
    /** get 기부금유형콤보TEMP : ctrbCtnt */
    public String  getCtrbCtnt() { return (String )get( ATTR_CTRBCTNT );}

    /** set 영수증유무 : receRati */
    public void setReceRati(String  receRati) { set( ATTR_RECERATI ,receRati);}
    /** get 영수증유무 : receRati */
    public String  getReceRati() { return (String )get( ATTR_RECERATI );}

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

/** set 기부금건수 : ctrbNcnt */
public void setCtrbNcnt(BigDecimal  ctrbNcnt) { set( ATTR_CTRBNCNT ,ctrbNcnt);}
/** get 기부금건수 : ctrbNcnt */
public BigDecimal  getCtrbNcnt() { return (BigDecimal )get( ATTR_CTRBNCNT );}

/** set 공제대상기부금액 : ctrbTgam */
public void setCtrbTgam(BigDecimal  ctrbTgam) { set( ATTR_CTRBTGAM ,ctrbTgam);}
/** get 공제대상기부금액 : ctrbTgam */
public BigDecimal  getCtrbTgam() { return (BigDecimal )get( ATTR_CTRBTGAM );}

/** set 기부장려신청금액 : ctjaCham */
public void setCtjaCham(BigDecimal  ctjaCham) { set( ATTR_CTJACHAM ,ctjaCham);}
/** get 기부장려신청금액 : ctjaCham */
public BigDecimal  getCtjaCham() { return (BigDecimal )get( ATTR_CTJACHAM );}

}
