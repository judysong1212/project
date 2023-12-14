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
public class Sysb0100BM    extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사용자아이디 : usrId */
    public static final String ATTR_USRID = "usrId";

    /** set 사용자정보변경일시 : usrInfoChngDtntm */
    public static final String ATTR_USRINFOCHNGDTNTM = "usrInfoChngDtntm";

    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 권한부여아이디 : authId */
    public static final String ATTR_AUTHID = "authId";

    /** set 사용자등록구분플래그 : usrRgstnSeptFlag */
    public static final String ATTR_USRRGSTNSEPTFLAG = "usrRgstnSeptFlag";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사용자성명 : usrNm */
    public static final String ATTR_USRNM = "usrNm";

    /** set 사용자권한구분코드 : usrDivCd */
    public static final String ATTR_USRDIVCD = "usrDivCd";

    /** set 이메일 : email */
    public static final String ATTR_EMAIL = "email";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 전화번호 : phnNum */
    public static final String ATTR_PHNNUM = "phnNum";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 권한적용시작일자 : authApptnBgnnDt */
    public static final String ATTR_AUTHAPPTNBGNNDT = "authApptnBgnnDt";

    /** set 권한적용종료일자 : authApptnEndDt */
    public static final String ATTR_AUTHAPPTNENDDT = "authApptnEndDt";

    /** set 사용자말소일자 : usrEaueDt */
    public static final String ATTR_USREAUEDT = "usrEaueDt";

    /** set 사용자사용여부 : usrUseYn */
    public static final String ATTR_USRUSEYN = "usrUseYn";

    /** set 사용자권한제외여부x : usrAuthEepnYn */
    public static final String ATTR_USRAUTHEEPNYN = "usrAuthEepnYn";

    /** set 호봉제포함여부x : pyspInsnYn */
    public static final String ATTR_PYSPINSNYN = "pyspInsnYn";

    /** set 비호봉제포함여부x : notPyspInsnYn */
    public static final String ATTR_NOTPYSPINSNYN = "notPyspInsnYn";

    /** set 기간제포함여부x : shttmInsnYn */
    public static final String ATTR_SHTTMINSNYN = "shttmInsnYn";

    /** set 복무입력처리여부 : servcInptPrcsYn */
    public static final String ATTR_SERVCINPTPRCSYN = "servcInptPrcsYn";

    /** set 연말정산입력처리여부 : yrtxInptPrcsYn */
    public static final String ATTR_YRTXINPTPRCSYN = "yrtxInptPrcsYn";

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
     public Sysb0100BM() { super(); } 

    /** 일괄등록 처리   */
     public Sysb0100BM(
    		 String  usrId 
    		, String  usrInfoChngDtntm 
    		, String  sysDivCd 
    		, String  authId 
    		, String  usrRgstnSeptFlag 
    		, String  deptCd 
    		, String  usrNm 
    		, String  usrDivCd 
    		, String  email 
    		, String  systemkey 
    		, String  phnNum 
    		, String  typOccuCd 
    		, String  pyspGrdeCd 
    		, String  dtilOccuInttnCd 
    		, String  authApptnBgnnDt 
    		, String  authApptnEndDt 
    		, String  usrEaueDt 
    		, String  usrUseYn 
    		, String  usrAuthEepnYn 
    		, String  pyspInsnYn 
    		, String  notPyspInsnYn 
    		, String  shttmInsnYn 
    		, String  servcInptPrcsYn 
    		, String  yrtxInptPrcsYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_USRID,usrId);
     	values.put(ATTR_USRINFOCHNGDTNTM,usrInfoChngDtntm);
     	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_AUTHID,authId);
     	values.put(ATTR_USRRGSTNSEPTFLAG,usrRgstnSeptFlag);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_USRNM,usrNm);
     	values.put(ATTR_USRDIVCD,usrDivCd);
     	values.put(ATTR_EMAIL,email);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PHNNUM,phnNum);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_AUTHAPPTNBGNNDT,authApptnBgnnDt);
     	values.put(ATTR_AUTHAPPTNENDDT,authApptnEndDt);
     	values.put(ATTR_USREAUEDT,usrEaueDt);
     	values.put(ATTR_USRUSEYN,usrUseYn);
     	values.put(ATTR_USRAUTHEEPNYN,usrAuthEepnYn);
     	values.put(ATTR_PYSPINSNYN,pyspInsnYn);
     	values.put(ATTR_NOTPYSPINSNYN,notPyspInsnYn);
     	values.put(ATTR_SHTTMINSNYN,shttmInsnYn);
     	values.put(ATTR_SERVCINPTPRCSYN,servcInptPrcsYn);
     	values.put(ATTR_YRTXINPTPRCSYN,yrtxInptPrcsYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사용자아이디 : usrId */
    public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
    /** get 사용자아이디 : usrId */
    public String  getUsrId() { return (String )get( ATTR_USRID );}

    /** set 사용자정보변경일시 : usrInfoChngDtntm */
    public void setUsrInfoChngDtntm(String  usrInfoChngDtntm) { set( ATTR_USRINFOCHNGDTNTM ,usrInfoChngDtntm);}
    /** get 사용자정보변경일시 : usrInfoChngDtntm */
    public String  getUsrInfoChngDtntm() { return (String )get( ATTR_USRINFOCHNGDTNTM );}

    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

    /** set 권한부여아이디 : authId */
    public void setAuthId(String  authId) { set( ATTR_AUTHID ,authId);}
    /** get 권한부여아이디 : authId */
    public String  getAuthId() { return (String )get( ATTR_AUTHID );}

    /** set 사용자등록구분플래그 : usrRgstnSeptFlag */
    public void setUsrRgstnSeptFlag(String  usrRgstnSeptFlag) { set( ATTR_USRRGSTNSEPTFLAG ,usrRgstnSeptFlag);}
    /** get 사용자등록구분플래그 : usrRgstnSeptFlag */
    public String  getUsrRgstnSeptFlag() { return (String )get( ATTR_USRRGSTNSEPTFLAG );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사용자성명 : usrNm */
    public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
    /** get 사용자성명 : usrNm */
    public String  getUsrNm() { return (String )get( ATTR_USRNM );}

    /** set 사용자권한구분코드 : usrDivCd */
    public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
    /** get 사용자권한구분코드 : usrDivCd */
    public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}

    /** set 이메일 : email */
    public void setEmail(String  email) { set( ATTR_EMAIL ,email);}
    /** get 이메일 : email */
    public String  getEmail() { return (String )get( ATTR_EMAIL );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 전화번호 : phnNum */
    public void setPhnNum(String  phnNum) { set( ATTR_PHNNUM ,phnNum);}
    /** get 전화번호 : phnNum */
    public String  getPhnNum() { return (String )get( ATTR_PHNNUM );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 권한적용시작일자 : authApptnBgnnDt */
    public void setAuthApptnBgnnDt(String  authApptnBgnnDt) { set( ATTR_AUTHAPPTNBGNNDT ,authApptnBgnnDt);}
    /** get 권한적용시작일자 : authApptnBgnnDt */
    public String  getAuthApptnBgnnDt() { return (String )get( ATTR_AUTHAPPTNBGNNDT );}

    /** set 권한적용종료일자 : authApptnEndDt */
    public void setAuthApptnEndDt(String  authApptnEndDt) { set( ATTR_AUTHAPPTNENDDT ,authApptnEndDt);}
    /** get 권한적용종료일자 : authApptnEndDt */
    public String  getAuthApptnEndDt() { return (String )get( ATTR_AUTHAPPTNENDDT );}

    /** set 사용자말소일자 : usrEaueDt */
    public void setUsrEaueDt(String  usrEaueDt) { set( ATTR_USREAUEDT ,usrEaueDt);}
    /** get 사용자말소일자 : usrEaueDt */
    public String  getUsrEaueDt() { return (String )get( ATTR_USREAUEDT );}

    /** set 사용자사용여부 : usrUseYn */
    public void setUsrUseYn(String  usrUseYn) { set( ATTR_USRUSEYN ,usrUseYn);}
    /** get 사용자사용여부 : usrUseYn */
    public String  getUsrUseYn() { return (String )get( ATTR_USRUSEYN );}

    /** set 사용자권한제외여부x : usrAuthEepnYn */
    public void setUsrAuthEepnYn(String  usrAuthEepnYn) { set( ATTR_USRAUTHEEPNYN ,usrAuthEepnYn);}
    /** get 사용자권한제외여부x : usrAuthEepnYn */
    public String  getUsrAuthEepnYn() { return (String )get( ATTR_USRAUTHEEPNYN );}

    /** set 호봉제포함여부x : pyspInsnYn */
    public void setPyspInsnYn(String  pyspInsnYn) { set( ATTR_PYSPINSNYN ,pyspInsnYn);}
    /** get 호봉제포함여부x : pyspInsnYn */
    public String  getPyspInsnYn() { return (String )get( ATTR_PYSPINSNYN );}

    /** set 비호봉제포함여부x : notPyspInsnYn */
    public void setNotPyspInsnYn(String  notPyspInsnYn) { set( ATTR_NOTPYSPINSNYN ,notPyspInsnYn);}
    /** get 비호봉제포함여부x : notPyspInsnYn */
    public String  getNotPyspInsnYn() { return (String )get( ATTR_NOTPYSPINSNYN );}

    /** set 기간제포함여부x : shttmInsnYn */
    public void setShttmInsnYn(String  shttmInsnYn) { set( ATTR_SHTTMINSNYN ,shttmInsnYn);}
    /** get 기간제포함여부x : shttmInsnYn */
    public String  getShttmInsnYn() { return (String )get( ATTR_SHTTMINSNYN );}

    /** set 복무입력처리여부 : servcInptPrcsYn */
    public void setServcInptPrcsYn(String  servcInptPrcsYn) { set( ATTR_SERVCINPTPRCSYN ,servcInptPrcsYn);}
    /** get 복무입력처리여부 : servcInptPrcsYn */
    public String  getServcInptPrcsYn() { return (String )get( ATTR_SERVCINPTPRCSYN );}

    /** set 연말정산입력처리여부 : yrtxInptPrcsYn */
    public void setYrtxInptPrcsYn(String  yrtxInptPrcsYn) { set( ATTR_YRTXINPTPRCSYN ,yrtxInptPrcsYn);}
    /** get 연말정산입력처리여부 : yrtxInptPrcsYn */
    public String  getYrtxInptPrcsYn() { return (String )get( ATTR_YRTXINPTPRCSYN );}

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
