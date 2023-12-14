package com.app.exterms.yearendtax.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : InfcPkgSysm0100BM.java
 * @Description : InfcPkgSysm0100BM VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgSysm0100BM  extends MSFSimpleBaseModel implements IsSerializable {
	
    private static final long serialVersionUID = 1L;
    
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 사용자아이디 : usrId */
    public static final String ATTR_USRID = "usrId";

    /** set 사용자성명 : usrNm */
    public static final String ATTR_USRNM = "usrNm";

    /** set 사용자권한구분코드 : usrDivCd */
    public static final String ATTR_USRDIVCD = "usrDivCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 전화번호 : usrTel */
    public static final String ATTR_USRTEL = "usrTel";

    /** set 이메일 : email */
    public static final String ATTR_EMAIL = "email";

    /** set 패스워드 : pwd */
    public static final String ATTR_PWD = "pwd";

    /** set 사용자사용여부 : useYn */
    public static final String ATTR_USEYN = "useYn";

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

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 사용자권한제외여부 : usrAuthEepnYn */
    public static final String ATTR_USRAUTHEEPNYN = "usrAuthEepnYn";

    /** set 호봉제포함여부 : pyspInsnYn */
    public static final String ATTR_PYSPINSNYN = "pyspInsnYn";

    /** set 비호봉제포함여부 : notPyspInsnYn */
    public static final String ATTR_NOTPYSPINSNYN = "notPyspInsnYn";

    /** set 복무입력처리여부 : servcInptPrcsYn */
    public static final String ATTR_SERVCINPTPRCSYN = "servcInptPrcsYn";

    /** set 연말정산입력처리여부 : yrtxInptPrcsYn */
    public static final String ATTR_YRTXINPTPRCSYN = "yrtxInptPrcsYn";

    /** set 기간제포함여부 : shttmInsnYn */
    public static final String ATTR_SHTTMINSNYN = "shttmInsnYn";

    /** set 사용자권한구분코드 : usrAuthDivCd */
    public static final String ATTR_USRAUTHDIVCD = "usrAuthDivCd";

    /** set 직종세코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 권한적용시작일자 : authInStdt */
    public static final String ATTR_AUTHINSTDT = "authInStdt";

    /** set 권한적용종료일자 : authInEddt */
    public static final String ATTR_AUTHINEDDT = "authInEddt";

    /** set 사용자계정잠김여부 : usrLgnAccLckYn */
    public static final String ATTR_USRLGNACCLCKYN = "usrLgnAccLckYn";

    /** set 단위사업장코드 : untDpobCd */
    public static final String ATTR_UNTDPOBCD = "untDpobCd";

    /** set 단위기관코드 : payMangeDeptCd */
    public static final String ATTR_PAYMANGEDEPTCD = "payMangeDeptCd";
    
	/** 선택버튼 : select */
	public static final String ATTR_SELECT = "select";

    /** 생성자 */
     public InfcPkgSysm0100BM() { super(); } 

    /** 일괄등록 처리   */
     public InfcPkgSysm0100BM(
    		 String  sysDivCd 
    		, String  usrId 
    		, String  usrNm 
    		, String  usrDivCd 
    		, String  systemkey 
    		, String  deptCd 
    		, String  usrTel 
    		, String  email 
    		, String  pwd 
    		, String  useYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  typOccuCd 
    		, String  pyspGrdeCd 
    		, String  usrAuthEepnYn 
    		, String  pyspInsnYn 
    		, String  notPyspInsnYn 
    		, String  servcInptPrcsYn 
    		, String  yrtxInptPrcsYn 
    		, String  shttmInsnYn 
    		, String  usrAuthDivCd 
    		, String  dtilOccuInttnCd 
    		, String  authInStdt 
    		, String  authInEddt 
    		, String  usrLgnAccLckYn 
    		, String  untDpobCd 
    		, String  payMangeDeptCd ) { 
     	values.put(ATTR_SYSDIVCD,sysDivCd);
     	values.put(ATTR_USRID,usrId);
     	values.put(ATTR_USRNM,usrNm);
     	values.put(ATTR_USRDIVCD,usrDivCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_USRTEL,usrTel);
     	values.put(ATTR_EMAIL,email);
     	values.put(ATTR_PWD,pwd);
     	values.put(ATTR_USEYN,useYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_USRAUTHEEPNYN,usrAuthEepnYn);
     	values.put(ATTR_PYSPINSNYN,pyspInsnYn);
     	values.put(ATTR_NOTPYSPINSNYN,notPyspInsnYn);
     	values.put(ATTR_SERVCINPTPRCSYN,servcInptPrcsYn);
     	values.put(ATTR_YRTXINPTPRCSYN,yrtxInptPrcsYn);
     	values.put(ATTR_SHTTMINSNYN,shttmInsnYn);
     	values.put(ATTR_USRAUTHDIVCD,usrAuthDivCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_AUTHINSTDT,authInStdt);
     	values.put(ATTR_AUTHINEDDT,authInEddt);
     	values.put(ATTR_USRLGNACCLCKYN,usrLgnAccLckYn);
     	values.put(ATTR_UNTDPOBCD,untDpobCd);
     	values.put(ATTR_PAYMANGEDEPTCD,payMangeDeptCd); } 

    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}
    /** set 사용자아이디 : usrId */
    public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
    /** get 사용자아이디 : usrId */
    public String  getUsrId() { return (String )get( ATTR_USRID );}
    /** set 사용자성명 : usrNm */
    public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
    /** get 사용자성명 : usrNm */
    public String  getUsrNm() { return (String )get( ATTR_USRNM );}
    /** set 사용자권한구분코드 : usrDivCd */
    public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
    /** get 사용자권한구분코드 : usrDivCd */
    public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    /** set 전화번호 : usrTel */
    public void setUsrTel(String  usrTel) { set( ATTR_USRTEL ,usrTel);}
    /** get 전화번호 : usrTel */
    public String  getUsrTel() { return (String )get( ATTR_USRTEL );}
    /** set 이메일 : email */
    public void setEmail(String  email) { set( ATTR_EMAIL ,email);}
    /** get 이메일 : email */
    public String  getEmail() { return (String )get( ATTR_EMAIL );}
    /** set 패스워드 : pwd */
    public void setPwd(String  pwd) { set( ATTR_PWD ,pwd);}
    /** get 패스워드 : pwd */
    public String  getPwd() { return (String )get( ATTR_PWD );}
    /** set 사용자사용여부 : useYn */
    public void setUseYn(String  useYn) { set( ATTR_USEYN ,useYn);}
    /** get 사용자사용여부 : useYn */
    public String  getUseYn() { return (String )get( ATTR_USEYN );}
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
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
    /** set 사용자권한제외여부 : usrAuthEepnYn */
    public void setUsrAuthEepnYn(String  usrAuthEepnYn) { set( ATTR_USRAUTHEEPNYN ,usrAuthEepnYn);}
    /** get 사용자권한제외여부 : usrAuthEepnYn */
    public String  getUsrAuthEepnYn() { return (String )get( ATTR_USRAUTHEEPNYN );}
    /** set 호봉제포함여부 : pyspInsnYn */
    public void setPyspInsnYn(String  pyspInsnYn) { set( ATTR_PYSPINSNYN ,pyspInsnYn);}
    /** get 호봉제포함여부 : pyspInsnYn */
    public String  getPyspInsnYn() { return (String )get( ATTR_PYSPINSNYN );}
    /** set 비호봉제포함여부 : notPyspInsnYn */
    public void setNotPyspInsnYn(String  notPyspInsnYn) { set( ATTR_NOTPYSPINSNYN ,notPyspInsnYn);}
    /** get 비호봉제포함여부 : notPyspInsnYn */
    public String  getNotPyspInsnYn() { return (String )get( ATTR_NOTPYSPINSNYN );}
    /** set 복무입력처리여부 : servcInptPrcsYn */
    public void setServcInptPrcsYn(String  servcInptPrcsYn) { set( ATTR_SERVCINPTPRCSYN ,servcInptPrcsYn);}
    /** get 복무입력처리여부 : servcInptPrcsYn */
    public String  getServcInptPrcsYn() { return (String )get( ATTR_SERVCINPTPRCSYN );}
    /** set 연말정산입력처리여부 : yrtxInptPrcsYn */
    public void setYrtxInptPrcsYn(String  yrtxInptPrcsYn) { set( ATTR_YRTXINPTPRCSYN ,yrtxInptPrcsYn);}
    /** get 연말정산입력처리여부 : yrtxInptPrcsYn */
    public String  getYrtxInptPrcsYn() { return (String )get( ATTR_YRTXINPTPRCSYN );}
    /** set 기간제포함여부 : shttmInsnYn */
    public void setShttmInsnYn(String  shttmInsnYn) { set( ATTR_SHTTMINSNYN ,shttmInsnYn);}
    /** get 기간제포함여부 : shttmInsnYn */
    public String  getShttmInsnYn() { return (String )get( ATTR_SHTTMINSNYN );}
    /** set 사용자권한구분코드 : usrAuthDivCd */
    public void setUsrAuthDivCd(String  usrAuthDivCd) { set( ATTR_USRAUTHDIVCD ,usrAuthDivCd);}
    /** get 사용자권한구분코드 : usrAuthDivCd */
    public String  getUsrAuthDivCd() { return (String )get( ATTR_USRAUTHDIVCD );}
    /** set 직종세코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    /** set 권한적용시작일자 : authInStdt */
    public void setAuthInStdt(String  authInStdt) { set( ATTR_AUTHINSTDT ,authInStdt);}
    /** get 권한적용시작일자 : authInStdt */
    public String  getAuthInStdt() { return (String )get( ATTR_AUTHINSTDT );}
    /** set 권한적용종료일자 : authInEddt */
    public void setAuthInEddt(String  authInEddt) { set( ATTR_AUTHINEDDT ,authInEddt);}
    /** get 권한적용종료일자 : authInEddt */
    public String  getAuthInEddt() { return (String )get( ATTR_AUTHINEDDT );}
    /** set 사용자계정잠김여부 : usrLgnAccLckYn */
    public void setUsrLgnAccLckYn(String  usrLgnAccLckYn) { set( ATTR_USRLGNACCLCKYN ,usrLgnAccLckYn);}
    /** get 사용자계정잠김여부 : usrLgnAccLckYn */
    public String  getUsrLgnAccLckYn() { return (String )get( ATTR_USRLGNACCLCKYN );}
    /** set 단위사업장코드 : untDpobCd */
    public void setUntDpobCd(String  untDpobCd) { set( ATTR_UNTDPOBCD ,untDpobCd);}
    /** get 단위사업장코드 : untDpobCd */
    public String  getUntDpobCd() { return (String )get( ATTR_UNTDPOBCD );}
    /** set 단위기관코드 : payMangeDeptCd */
    public void setPayMangeDeptCd(String  payMangeDeptCd) { set( ATTR_PAYMANGEDEPTCD ,payMangeDeptCd);}
    /** get 단위기관코드 : payMangeDeptCd */
    public String  getPayMangeDeptCd() { return (String )get( ATTR_PAYMANGEDEPTCD );}
    
	/** set 선택버튼 : select */
	public void setSelect(String  select) { set( ATTR_REVNADDR ,select);}
	/** get 선택버튼 : select */
	public String  getSelect() { return (String )get( ATTR_REVNADDR );}
    
}
