package com.app.exterms.yearendtax.client.dto.yeta2020;



import java.math.BigDecimal;

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
public class Payr0485BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 회계계정코드 : accAccCd */
    public static final String ATTR_ACCACCCD = "accAccCd";

    /** set 퇴직적용여부 : sevePayYn */
    public static final String ATTR_SEVEPAYYN = "sevePayYn";

    /** set 연말정산_기부금코드 : yrtxDotnCd */
    public static final String ATTR_YRTXDOTNCD = "yrtxDotnCd";

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public static final String ATTR_YRTXFREEDTYREDUCD = "yrtxFreeDtyReduCd";

    /** set 기간제수당사용여부 : payrTermUseYn */
    public static final String ATTR_PAYRTERMUSEYN = "payrTermUseYn";

    /** set 수당공제출력여부 : extptDducDspyYn */
    public static final String ATTR_EXTPTDDUCDSPYYN = "extptDducDspyYn";

    /** set 수당공제사용여부 : extptDducUseYn */
    public static final String ATTR_EXTPTDDUCUSEYN = "extptDducUseYn";

    /** set 수당공제정렬순서 : extptDducRngeOrd */
    public static final String ATTR_EXTPTDDUCRNGEORD = "extptDducRngeOrd";

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
     public Payr0485BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0485BM(
    		 String  dpobCd 
    		, String  emymtDivCd 
    		, String  payItemCd 
    		, String  accAccCd 
    		, String  sevePayYn 
    		, String  yrtxDotnCd 
    		, String  yrtxFreeDtyReduCd 
    		, String  payrTermUseYn 
    		, String  extptDducDspyYn 
    		, String  extptDducUseYn 
    		, BigDecimal  extptDducRngeOrd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_ACCACCCD,accAccCd);
     	values.put(ATTR_SEVEPAYYN,sevePayYn);
     	values.put(ATTR_YRTXDOTNCD,yrtxDotnCd);
     	values.put(ATTR_YRTXFREEDTYREDUCD,yrtxFreeDtyReduCd);
     	values.put(ATTR_PAYRTERMUSEYN,payrTermUseYn);
     	values.put(ATTR_EXTPTDDUCDSPYYN,extptDducDspyYn);
     	values.put(ATTR_EXTPTDDUCUSEYN,extptDducUseYn);
     	values.put(ATTR_EXTPTDDUCRNGEORD,extptDducRngeOrd);
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
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
    /** set 회계계정코드 : accAccCd */
    public void setAccAccCd(String  accAccCd) { set( ATTR_ACCACCCD ,accAccCd);}
    /** get 회계계정코드 : accAccCd */
    public String  getAccAccCd() { return (String )get( ATTR_ACCACCCD );}
    /** set 퇴직적용여부 : sevePayYn */
    public void setSevePayYn(String  sevePayYn) { set( ATTR_SEVEPAYYN ,sevePayYn);}
    /** get 퇴직적용여부 : sevePayYn */
    public String  getSevePayYn() { return (String )get( ATTR_SEVEPAYYN );}
    /** set 연말정산_기부금코드 : yrtxDotnCd */
    public void setYrtxDotnCd(String  yrtxDotnCd) { set( ATTR_YRTXDOTNCD ,yrtxDotnCd);}
    /** get 연말정산_기부금코드 : yrtxDotnCd */
    public String  getYrtxDotnCd() { return (String )get( ATTR_YRTXDOTNCD );}
    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public void setYrtxFreeDtyReduCd(String  yrtxFreeDtyReduCd) { set( ATTR_YRTXFREEDTYREDUCD ,yrtxFreeDtyReduCd);}
    /** get 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    public String  getYrtxFreeDtyReduCd() { return (String )get( ATTR_YRTXFREEDTYREDUCD );}
    /** set 기간제수당사용여부 : payrTermUseYn */
    public void setPayrTermUseYn(String  payrTermUseYn) { set( ATTR_PAYRTERMUSEYN ,payrTermUseYn);}
    /** get 기간제수당사용여부 : payrTermUseYn */
    public String  getPayrTermUseYn() { return (String )get( ATTR_PAYRTERMUSEYN );}
    /** set 수당공제출력여부 : extptDducDspyYn */
    public void setExtptDducDspyYn(String  extptDducDspyYn) { set( ATTR_EXTPTDDUCDSPYYN ,extptDducDspyYn);}
    /** get 수당공제출력여부 : extptDducDspyYn */
    public String  getExtptDducDspyYn() { return (String )get( ATTR_EXTPTDDUCDSPYYN );}
    /** set 수당공제사용여부 : extptDducUseYn */
    public void setExtptDducUseYn(String  extptDducUseYn) { set( ATTR_EXTPTDDUCUSEYN ,extptDducUseYn);}
    /** get 수당공제사용여부 : extptDducUseYn */
    public String  getExtptDducUseYn() { return (String )get( ATTR_EXTPTDDUCUSEYN );}
    /** set 수당공제정렬순서 : extptDducRngeOrd */
    public void setExtptDducRngeOrd(BigDecimal  extptDducRngeOrd) { set( ATTR_EXTPTDDUCRNGEORD ,extptDducRngeOrd);}
    /** get 수당공제정렬순서 : extptDducRngeOrd */
    public BigDecimal  getExtptDducRngeOrd() { return (BigDecimal )get( ATTR_EXTPTDDUCRNGEORD );}
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
