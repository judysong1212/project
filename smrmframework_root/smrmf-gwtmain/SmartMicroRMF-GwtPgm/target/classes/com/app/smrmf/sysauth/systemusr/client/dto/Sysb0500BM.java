package com.app.smrmf.sysauth.systemusr.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Sysb0500BM    extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사용자열람일사 : usrRdgDtntm */
    public static final String ATTR_USRRDGDTNTM = "usrRdgDtntm";

    /** set 사용자열람일련번호 : usrRdgSeilNum */
    public static final String ATTR_USRRDGSEILNUM = "usrRdgSeilNum";

    /** set 사용자열람구분코드 : usrRdgDivCd */
    public static final String ATTR_USRRDGDIVCD = "usrRdgDivCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사용자아이디 : usrId */
    public static final String ATTR_USRID = "usrId";

    /** set 사용자접속아이피 : usrConnId */
    public static final String ATTR_USRCONNID = "usrConnId";

    /** set 사용자열람메서드명 : usrRdgEthdNm */
    public static final String ATTR_USRRDGETHDNM = "usrRdgEthdNm";

    /** set 사용자열람작업구분코드 : usrRdgJobDivCd */
    public static final String ATTR_USRRDGJOBDIVCD = "usrRdgJobDivCd";

    /** set 사용자특정대상자SYSTEMKEY_VAL : usrSpfcRcptSmkeyVal */
    public static final String ATTR_USRSPFCRCPTSMKEYVAL = "usrSpfcRcptSmkeyVal";

    /** set 사용자열람비고내용 : usrRdgNoteCtnt */
    public static final String ATTR_USRRDGNOTECTNT = "usrRdgNoteCtnt";

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
     public Sysb0500BM() { super(); } 

    /** 일괄등록 처리   */
     public Sysb0500BM(
    		 String  dpobCd 
    		, String  usrRdgDtntm 
    		, Long  usrRdgSeilNum 
    		, String  usrRdgDivCd 
    		, String  deptCd 
    		, String  usrId 
    		, String  usrConnId 
    		, String  usrRdgEthdNm 
    		, String  usrRdgJobDivCd 
    		, String  usrSpfcRcptSmkeyVal 
    		, String  usrRdgNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_USRRDGDTNTM,usrRdgDtntm);
     	values.put(ATTR_USRRDGSEILNUM,usrRdgSeilNum);
     	values.put(ATTR_USRRDGDIVCD,usrRdgDivCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_USRID,usrId);
     	values.put(ATTR_USRCONNID,usrConnId);
     	values.put(ATTR_USRRDGETHDNM,usrRdgEthdNm);
     	values.put(ATTR_USRRDGJOBDIVCD,usrRdgJobDivCd);
     	values.put(ATTR_USRSPFCRCPTSMKEYVAL,usrSpfcRcptSmkeyVal);
     	values.put(ATTR_USRRDGNOTECTNT,usrRdgNoteCtnt);
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

    /** set 사용자열람일사 : usrRdgDtntm */
    public void setUsrRdgDtntm(String  usrRdgDtntm) { set( ATTR_USRRDGDTNTM ,usrRdgDtntm);}
    /** get 사용자열람일사 : usrRdgDtntm */
    public String  getUsrRdgDtntm() { return (String )get( ATTR_USRRDGDTNTM );}

    /** set 사용자열람일련번호 : usrRdgSeilNum */
    public void setUsrRdgSeilNum(Long  usrRdgSeilNum) { set( ATTR_USRRDGSEILNUM ,usrRdgSeilNum);}
    /** get 사용자열람일련번호 : usrRdgSeilNum */
    public Long  getUsrRdgSeilNum() { return (Long )get( ATTR_USRRDGSEILNUM );}

    /** set 사용자열람구분코드 : usrRdgDivCd */
    public void setUsrRdgDivCd(String  usrRdgDivCd) { set( ATTR_USRRDGDIVCD ,usrRdgDivCd);}
    /** get 사용자열람구분코드 : usrRdgDivCd */
    public String  getUsrRdgDivCd() { return (String )get( ATTR_USRRDGDIVCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사용자아이디 : usrId */
    public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
    /** get 사용자아이디 : usrId */
    public String  getUsrId() { return (String )get( ATTR_USRID );}

    /** set 사용자접속아이피 : usrConnId */
    public void setUsrConnId(String  usrConnId) { set( ATTR_USRCONNID ,usrConnId);}
    /** get 사용자접속아이피 : usrConnId */
    public String  getUsrConnId() { return (String )get( ATTR_USRCONNID );}

    /** set 사용자열람메서드명 : usrRdgEthdNm */
    public void setUsrRdgEthdNm(String  usrRdgEthdNm) { set( ATTR_USRRDGETHDNM ,usrRdgEthdNm);}
    /** get 사용자열람메서드명 : usrRdgEthdNm */
    public String  getUsrRdgEthdNm() { return (String )get( ATTR_USRRDGETHDNM );}

    /** set 사용자열람작업구분코드 : usrRdgJobDivCd */
    public void setUsrRdgJobDivCd(String  usrRdgJobDivCd) { set( ATTR_USRRDGJOBDIVCD ,usrRdgJobDivCd);}
    /** get 사용자열람작업구분코드 : usrRdgJobDivCd */
    public String  getUsrRdgJobDivCd() { return (String )get( ATTR_USRRDGJOBDIVCD );}

    /** set 사용자특정대상자SYSTEMKEY_VAL : usrSpfcRcptSmkeyVal */
    public void setUsrSpfcRcptSmkeyVal(String  usrSpfcRcptSmkeyVal) { set( ATTR_USRSPFCRCPTSMKEYVAL ,usrSpfcRcptSmkeyVal);}
    /** get 사용자특정대상자SYSTEMKEY_VAL : usrSpfcRcptSmkeyVal */
    public String  getUsrSpfcRcptSmkeyVal() { return (String )get( ATTR_USRSPFCRCPTSMKEYVAL );}

    /** set 사용자열람비고내용 : usrRdgNoteCtnt */
    public void setUsrRdgNoteCtnt(String  usrRdgNoteCtnt) { set( ATTR_USRRDGNOTECTNT ,usrRdgNoteCtnt);}
    /** get 사용자열람비고내용 : usrRdgNoteCtnt */
    public String  getUsrRdgNoteCtnt() { return (String )get( ATTR_USRRDGNOTECTNT );}

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
