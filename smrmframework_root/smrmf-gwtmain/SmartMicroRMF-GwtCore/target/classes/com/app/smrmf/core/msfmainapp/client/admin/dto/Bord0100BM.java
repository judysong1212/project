package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bord0100VO.java
 * @Description : Bord0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bord0100BM  extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 게시판그룹ID : bullBordGrpId */
    public static final String ATTR_BULLBORDGRPID = "bullBordGrpId";

    /** set 게시판 상위그룹ID : bullBordHhrkGrpId */
    public static final String ATTR_BULLBORDHHRKGRPID = "bullBordHhrkGrpId";

    /** set 깊이 : dpth */
    public static final String ATTR_DPTH = "dpth";

    /** set 게시판그룹명 : bullBordGrpNm */
    public static final String ATTR_BULLBORDGRPNM = "bullBordGrpNm";

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
     public Bord0100BM() { super(); } 

    /** 일괄등록 처리   */
     public Bord0100BM(
    		 String  sysDivCd 
    		, BigDecimal  bullBordGrpId 
    		, BigDecimal  bullBordHhrkGrpId 
    		, BigDecimal  dpth 
    		, String  bullBordGrpNm 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_BULLBORDGRPID,bullBordGrpId);
     	values.put(ATTR_BULLBORDHHRKGRPID,bullBordHhrkGrpId);
     	values.put(ATTR_DPTH,dpth);
     	values.put(ATTR_BULLBORDGRPNM,bullBordGrpNm);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

    /** set 게시판그룹ID : bullBordGrpId */
    public void setBullBordGrpId(BigDecimal  bullBordGrpId) { set( ATTR_BULLBORDGRPID ,bullBordGrpId);}
    /** get 게시판그룹ID : bullBordGrpId */
    public BigDecimal  getBullBordGrpId() { return (BigDecimal )get( ATTR_BULLBORDGRPID );}

    /** set 게시판 상위그룹ID : bullBordHhrkGrpId */
    public void setBullBordHhrkGrpId(BigDecimal  bullBordHhrkGrpId) { set( ATTR_BULLBORDHHRKGRPID ,bullBordHhrkGrpId);}
    /** get 게시판 상위그룹ID : bullBordHhrkGrpId */
    public BigDecimal  getBullBordHhrkGrpId() { return (BigDecimal )get( ATTR_BULLBORDHHRKGRPID );}

    /** set 깊이 : dpth */
    public void setDpth(BigDecimal  dpth) { set( ATTR_DPTH ,dpth);}
    /** get 깊이 : dpth */
    public BigDecimal  getDpth() { return (BigDecimal )get( ATTR_DPTH );}

    /** set 게시판그룹명 : bullBordGrpNm */
    public void setBullBordGrpNm(String  bullBordGrpNm) { set( ATTR_BULLBORDGRPNM ,bullBordGrpNm);}
    /** get 게시판그룹명 : bullBordGrpNm */
    public String  getBullBordGrpNm() { return (String )get( ATTR_BULLBORDGRPNM );}

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
