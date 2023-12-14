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
public class Bass2350BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public static final String ATTR_BUSNDTLTYPOCCUCD = "busnDtlTypOccuCd";

    /** set 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public static final String ATTR_BUSNSMLRDTLTYPOCCUCD = "busnSmlrDtlTypOccuCd";

    /** set 사업유사세부직종명 : busnSmlrDtlTypOccuNm */
    public static final String ATTR_BUSNSMLRDTLTYPOCCUNM = "busnSmlrDtlTypOccuNm";

    /** set 사업유사세불직종시작일자 : busnSmlrTypOccuBgnnDt */
    public static final String ATTR_BUSNSMLRTYPOCCUBGNNDT = "busnSmlrTypOccuBgnnDt";

    /** set 사업유사세부직종종료일자 : busnSmlrTypOccuEndDt */
    public static final String ATTR_BUSNSMLRTYPOCCUENDDT = "busnSmlrTypOccuEndDt";

    /** set 사업유사세부직종사용여부 : busnSmlrTypOccuUseYn */
    public static final String ATTR_BUSNSMLRTYPOCCUUSEYN = "busnSmlrTypOccuUseYn";

    /** set 사업유사세부직종내용 : busnSmlrDtlTypOccuCtnt */
    public static final String ATTR_BUSNSMLRDTLTYPOCCUCTNT = "busnSmlrDtlTypOccuCtnt";

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
     public Bass2350BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2350BM(
    		 String  dpobCd 
    		, String  busnDtlTypOccuCd 
    		, String  busnSmlrDtlTypOccuCd 
    		, String  busnSmlrDtlTypOccuNm 
    		, String  busnSmlrTypOccuBgnnDt 
    		, String  busnSmlrTypOccuEndDt 
    		, String  busnSmlrTypOccuUseYn 
    		, String  busnSmlrDtlTypOccuCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSNDTLTYPOCCUCD,busnDtlTypOccuCd);
     	values.put(ATTR_BUSNSMLRDTLTYPOCCUCD,busnSmlrDtlTypOccuCd);
     	values.put(ATTR_BUSNSMLRDTLTYPOCCUNM,busnSmlrDtlTypOccuNm);
     	values.put(ATTR_BUSNSMLRTYPOCCUBGNNDT,busnSmlrTypOccuBgnnDt);
     	values.put(ATTR_BUSNSMLRTYPOCCUENDDT,busnSmlrTypOccuEndDt);
     	values.put(ATTR_BUSNSMLRTYPOCCUUSEYN,busnSmlrTypOccuUseYn);
     	values.put(ATTR_BUSNSMLRDTLTYPOCCUCTNT,busnSmlrDtlTypOccuCtnt);
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

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public void setBusnDtlTypOccuCd(String  busnDtlTypOccuCd) { set( ATTR_BUSNDTLTYPOCCUCD ,busnDtlTypOccuCd);}
    /** get 사업_세부직종코드 : busnDtlTypOccuCd */
    public String  getBusnDtlTypOccuCd() { return (String )get( ATTR_BUSNDTLTYPOCCUCD );}

    /** set 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public void setBusnSmlrDtlTypOccuCd(String  busnSmlrDtlTypOccuCd) { set( ATTR_BUSNSMLRDTLTYPOCCUCD ,busnSmlrDtlTypOccuCd);}
    /** get 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public String  getBusnSmlrDtlTypOccuCd() { return (String )get( ATTR_BUSNSMLRDTLTYPOCCUCD );}

    /** set 사업유사세부직종명 : busnSmlrDtlTypOccuNm */
    public void setBusnSmlrDtlTypOccuNm(String  busnSmlrDtlTypOccuNm) { set( ATTR_BUSNSMLRDTLTYPOCCUNM ,busnSmlrDtlTypOccuNm);}
    /** get 사업유사세부직종명 : busnSmlrDtlTypOccuNm */
    public String  getBusnSmlrDtlTypOccuNm() { return (String )get( ATTR_BUSNSMLRDTLTYPOCCUNM );}

    /** set 사업유사세불직종시작일자 : busnSmlrTypOccuBgnnDt */
    public void setBusnSmlrTypOccuBgnnDt(String  busnSmlrTypOccuBgnnDt) { set( ATTR_BUSNSMLRTYPOCCUBGNNDT ,busnSmlrTypOccuBgnnDt);}
    /** get 사업유사세불직종시작일자 : busnSmlrTypOccuBgnnDt */
    public String  getBusnSmlrTypOccuBgnnDt() { return (String )get( ATTR_BUSNSMLRTYPOCCUBGNNDT );}

    /** set 사업유사세부직종종료일자 : busnSmlrTypOccuEndDt */
    public void setBusnSmlrTypOccuEndDt(String  busnSmlrTypOccuEndDt) { set( ATTR_BUSNSMLRTYPOCCUENDDT ,busnSmlrTypOccuEndDt);}
    /** get 사업유사세부직종종료일자 : busnSmlrTypOccuEndDt */
    public String  getBusnSmlrTypOccuEndDt() { return (String )get( ATTR_BUSNSMLRTYPOCCUENDDT );}

    /** set 사업유사세부직종사용여부 : busnSmlrTypOccuUseYn */
    public void setBusnSmlrTypOccuUseYn(String  busnSmlrTypOccuUseYn) { set( ATTR_BUSNSMLRTYPOCCUUSEYN ,busnSmlrTypOccuUseYn);}
    /** get 사업유사세부직종사용여부 : busnSmlrTypOccuUseYn */
    public String  getBusnSmlrTypOccuUseYn() { return (String )get( ATTR_BUSNSMLRTYPOCCUUSEYN );}

    /** set 사업유사세부직종내용 : busnSmlrDtlTypOccuCtnt */
    public void setBusnSmlrDtlTypOccuCtnt(String  busnSmlrDtlTypOccuCtnt) { set( ATTR_BUSNSMLRDTLTYPOCCUCTNT ,busnSmlrDtlTypOccuCtnt);}
    /** get 사업유사세부직종내용 : busnSmlrDtlTypOccuCtnt */
    public String  getBusnSmlrDtlTypOccuCtnt() { return (String )get( ATTR_BUSNSMLRDTLTYPOCCUCTNT );}

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
