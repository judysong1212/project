package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2150BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public static final String ATTR_BUSNTYPOCCUCIFICD = "busnTypOccuCifiCd";

    /** set 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public static final String ATTR_BUSNTYPOCCUCIFISMLRCD = "busnTypOccuCifiSmlrCd";

    /** set 사업직종분류유사명 : busnTypOccuCifiSmlrNm */
    public static final String ATTR_BUSNTYPOCCUCIFISMLRNM = "busnTypOccuCifiSmlrNm";

    /** set 사업직종분류유사사용여부 : busnTypOccuCifiSmlrYn */
    public static final String ATTR_BUSNTYPOCCUCIFISMLRYN = "busnTypOccuCifiSmlrYn";

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
     public Bass2150BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2150BM(
    		 String  dpobCd 
    		, String  busnTypOccuCifiCd 
    		, String  busnTypOccuCifiSmlrCd 
    		, String  busnTypOccuCifiSmlrNm 
    		, String  busnTypOccuCifiSmlrYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSNTYPOCCUCIFICD,busnTypOccuCifiCd);
     	values.put(ATTR_BUSNTYPOCCUCIFISMLRCD,busnTypOccuCifiSmlrCd);
     	values.put(ATTR_BUSNTYPOCCUCIFISMLRNM,busnTypOccuCifiSmlrNm);
     	values.put(ATTR_BUSNTYPOCCUCIFISMLRYN,busnTypOccuCifiSmlrYn);
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

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public void setBusnTypOccuCifiCd(String  busnTypOccuCifiCd) { set( ATTR_BUSNTYPOCCUCIFICD ,busnTypOccuCifiCd);}
    /** get 사업직종분류코드 : busnTypOccuCifiCd */
    public String  getBusnTypOccuCifiCd() { return (String )get( ATTR_BUSNTYPOCCUCIFICD );}

    /** set 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public void setBusnTypOccuCifiSmlrCd(String  busnTypOccuCifiSmlrCd) { set( ATTR_BUSNTYPOCCUCIFISMLRCD ,busnTypOccuCifiSmlrCd);}
    /** get 사업직종분류유사코드 : busnTypOccuCifiSmlrCd */
    public String  getBusnTypOccuCifiSmlrCd() { return (String )get( ATTR_BUSNTYPOCCUCIFISMLRCD );}

    /** set 사업직종분류유사명 : busnTypOccuCifiSmlrNm */
    public void setBusnTypOccuCifiSmlrNm(String  busnTypOccuCifiSmlrNm) { set( ATTR_BUSNTYPOCCUCIFISMLRNM ,busnTypOccuCifiSmlrNm);}
    /** get 사업직종분류유사명 : busnTypOccuCifiSmlrNm */
    public String  getBusnTypOccuCifiSmlrNm() { return (String )get( ATTR_BUSNTYPOCCUCIFISMLRNM );}

    /** set 사업직종분류유사사용여부 : busnTypOccuCifiSmlrYn */
    public void setBusnTypOccuCifiSmlrYn(String  busnTypOccuCifiSmlrYn) { set( ATTR_BUSNTYPOCCUCIFISMLRYN ,busnTypOccuCifiSmlrYn);}
    /** get 사업직종분류유사사용여부 : busnTypOccuCifiSmlrYn */
    public String  getBusnTypOccuCifiSmlrYn() { return (String )get( ATTR_BUSNTYPOCCUCIFISMLRYN );}

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
