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
public class Bass0460BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 상위부서그룹코드 : hhrkDeptGrpCd */
    public static final String ATTR_HHRKDEPTGRPCD = "hhrkDeptGrpCd";

    /** set 상위부서그룹명 : hhrkDeptGrpNm */
    public static final String ATTR_HHRKDEPTGRPNM = "hhrkDeptGrpNm";

    /** set 상위부서그룹사용여부 : hhrkDeptGrpUsyn */
    public static final String ATTR_HHRKDEPTGRPUSYN = "hhrkDeptGrpUsyn";

    /** set 부서그룹설명 : hhrkDeptGrpCtnt */
    public static final String ATTR_HHRKDEPTGRPCTNT = "hhrkDeptGrpCtnt";

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
     public Bass0460BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0460BM(
    		 String  dpobCd 
    		, String  hhrkDeptGrpCd 
    		, String  hhrkDeptGrpNm 
    		, String  hhrkDeptGrpUsyn 
    		, String  hhrkDeptGrpCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_HHRKDEPTGRPCD,hhrkDeptGrpCd);
     	values.put(ATTR_HHRKDEPTGRPNM,hhrkDeptGrpNm);
     	values.put(ATTR_HHRKDEPTGRPUSYN,hhrkDeptGrpUsyn);
     	values.put(ATTR_HHRKDEPTGRPCTNT,hhrkDeptGrpCtnt);
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

    /** set 상위부서그룹코드 : hhrkDeptGrpCd */
    public void setHhrkDeptGrpCd(String  hhrkDeptGrpCd) { set( ATTR_HHRKDEPTGRPCD ,hhrkDeptGrpCd);}
    /** get 상위부서그룹코드 : hhrkDeptGrpCd */
    public String  getHhrkDeptGrpCd() { return (String )get( ATTR_HHRKDEPTGRPCD );}

    /** set 상위부서그룹명 : hhrkDeptGrpNm */
    public void setHhrkDeptGrpNm(String  hhrkDeptGrpNm) { set( ATTR_HHRKDEPTGRPNM ,hhrkDeptGrpNm);}
    /** get 상위부서그룹명 : hhrkDeptGrpNm */
    public String  getHhrkDeptGrpNm() { return (String )get( ATTR_HHRKDEPTGRPNM );}

    /** set 상위부서그룹사용여부 : hhrkDeptGrpUsyn */
    public void setHhrkDeptGrpUsyn(String  hhrkDeptGrpUsyn) { set( ATTR_HHRKDEPTGRPUSYN ,hhrkDeptGrpUsyn);}
    /** get 상위부서그룹사용여부 : hhrkDeptGrpUsyn */
    public String  getHhrkDeptGrpUsyn() { return (String )get( ATTR_HHRKDEPTGRPUSYN );}

    /** set 부서그룹설명 : hhrkDeptGrpCtnt */
    public void setHhrkDeptGrpCtnt(String  hhrkDeptGrpCtnt) { set( ATTR_HHRKDEPTGRPCTNT ,hhrkDeptGrpCtnt);}
    /** get 부서그룹설명 : hhrkDeptGrpCtnt */
    public String  getHhrkDeptGrpCtnt() { return (String )get( ATTR_HHRKDEPTGRPCTNT );}

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
