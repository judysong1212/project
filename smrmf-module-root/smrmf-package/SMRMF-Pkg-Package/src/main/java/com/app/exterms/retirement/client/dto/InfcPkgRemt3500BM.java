package com.app.exterms.retirement.client.dto; 



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
public class InfcPkgRemt3500BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public static final String ATTR_CALCSEVEPAYPSNBLGGYR = "calcSevePayPsnBlggYr";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";
    
    /** set 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public static final String ATTR_CALCSEVEPAYPSNDIVNM = "calcSevePayPsnDivNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 부서코드 : evntCode */
    public static final String ATTR_EVNTCODE = "evntCode";

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
     public InfcPkgRemt3500BM() { super(); } 

    /** 일괄등록 처리   */
     public InfcPkgRemt3500BM(
             String  dpobCd 
            , String  calcSevePayPsnBlggYr 
            , String  calcSevePayPsnDivCd 
            , String  systemkey 
            , String  emymtDivCd 
            , String  evntCode 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_CALCSEVEPAYPSNBLGGYR,calcSevePayPsnBlggYr);
        values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_EMYMTDIVCD,emymtDivCd);
        values.put(ATTR_EVNTCODE,evntCode);
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

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public void setCalcSevePayPsnBlggYr(String  calcSevePayPsnBlggYr) { set( ATTR_CALCSEVEPAYPSNBLGGYR ,calcSevePayPsnBlggYr);}
    /** get 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    public String  getCalcSevePayPsnBlggYr() { return (String )get( ATTR_CALCSEVEPAYPSNBLGGYR );}

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}
     

    /** set 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public void setCalcSevePayPsnDivNm(String  calcSevePayPsnDivNm) { set( ATTR_CALCSEVEPAYPSNDIVNM ,calcSevePayPsnDivNm);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public String  getCalcSevePayPsnDivNm() { return (String )get( ATTR_CALCSEVEPAYPSNDIVNM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 부서코드 : evntCode */
    public void setEvntCode(String  evntCode) { set( ATTR_EVNTCODE ,evntCode);}
    /** get 부서코드 : evntCode */
    public String  getEvntCode() { return (String )get( ATTR_EVNTCODE );}

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
