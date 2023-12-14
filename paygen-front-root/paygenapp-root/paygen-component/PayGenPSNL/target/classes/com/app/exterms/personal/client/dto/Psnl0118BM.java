package com.app.exterms.personal.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0118BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 자격면허일련번호 : qftntLicnsSeilNum */
    public static final String ATTR_QFTNTLICNSSEILNUM = "qftntLicnsSeilNum";

    /** set 취득일자 : aqtnDt */
    public static final String ATTR_AQTNDT = "aqtnDt";

    /** set 자격면허코드 : qftntLicnsCd */
    public static final String ATTR_QFTNTLICNSCD = "qftntLicnsCd";

    /** set 자격면허분야내용 : qftntLicnsPovncCtnt */
    public static final String ATTR_QFTNTLICNSPOVNCCTNT = "qftntLicnsPovncCtnt";

    /** set 시행기관명 : efmnIstutNm */
    public static final String ATTR_EFMNISTUTNM = "efmnIstutNm";

    /** set 자격면허번호 : qftntLicnsNum */
    public static final String ATTR_QFTNTLICNSNUM = "qftntLicnsNum";

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
     public Psnl0118BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0118BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  qftntLicnsSeilNum 
    		, String  aqtnDt 
    		, String  qftntLicnsCd 
    		, String  qftntLicnsPovncCtnt 
    		, String  efmnIstutNm 
    		, String  qftntLicnsNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_QFTNTLICNSSEILNUM,qftntLicnsSeilNum);
     	values.put(ATTR_AQTNDT,aqtnDt);
     	values.put(ATTR_QFTNTLICNSCD,qftntLicnsCd);
     	values.put(ATTR_QFTNTLICNSPOVNCCTNT,qftntLicnsPovncCtnt);
     	values.put(ATTR_EFMNISTUTNM,efmnIstutNm);
     	values.put(ATTR_QFTNTLICNSNUM,qftntLicnsNum);
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
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 자격면허일련번호 : qftntLicnsSeilNum */
    public void setQftntLicnsSeilNum(BigDecimal  qftntLicnsSeilNum) { set( ATTR_QFTNTLICNSSEILNUM ,qftntLicnsSeilNum);}
    /** get 자격면허일련번호 : qftntLicnsSeilNum */
    public BigDecimal  getQftntLicnsSeilNum() { return (BigDecimal )get( ATTR_QFTNTLICNSSEILNUM );}
    /** set 취득일자 : aqtnDt */
    public void setAqtnDt(String  aqtnDt) { set( ATTR_AQTNDT ,aqtnDt);}
    /** get 취득일자 : aqtnDt */
    public String  getAqtnDt() { return (String )get( ATTR_AQTNDT );}
    /** set 자격면허코드 : qftntLicnsCd */
    public void setQftntLicnsCd(String  qftntLicnsCd) { set( ATTR_QFTNTLICNSCD ,qftntLicnsCd);}
    /** get 자격면허코드 : qftntLicnsCd */
    public String  getQftntLicnsCd() { return (String )get( ATTR_QFTNTLICNSCD );}
    /** set 자격면허분야내용 : qftntLicnsPovncCtnt */
    public void setQftntLicnsPovncCtnt(String  qftntLicnsPovncCtnt) { set( ATTR_QFTNTLICNSPOVNCCTNT ,qftntLicnsPovncCtnt);}
    /** get 자격면허분야내용 : qftntLicnsPovncCtnt */
    public String  getQftntLicnsPovncCtnt() { return (String )get( ATTR_QFTNTLICNSPOVNCCTNT );}
    /** set 시행기관명 : efmnIstutNm */
    public void setEfmnIstutNm(String  efmnIstutNm) { set( ATTR_EFMNISTUTNM ,efmnIstutNm);}
    /** get 시행기관명 : efmnIstutNm */
    public String  getEfmnIstutNm() { return (String )get( ATTR_EFMNISTUTNM );}
    /** set 자격면허번호 : qftntLicnsNum */
    public void setQftntLicnsNum(String  qftntLicnsNum) { set( ATTR_QFTNTLICNSNUM ,qftntLicnsNum);}
    /** get 자격면허번호 : qftntLicnsNum */
    public String  getQftntLicnsNum() { return (String )get( ATTR_QFTNTLICNSNUM );}
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
