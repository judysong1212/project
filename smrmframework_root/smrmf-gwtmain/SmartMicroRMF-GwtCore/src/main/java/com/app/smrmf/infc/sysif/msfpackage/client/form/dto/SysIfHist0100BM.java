package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr1100VO.java
 * @Description : Insr1100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@SuppressWarnings("serial")
public class SysIfHist0100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 사용자접속년도 : usrConnectYr */
	public static final String ATTR_USRCONNECTYR = "usrConnectYr";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 사용자접속일련번호 : usrConnectSeilNum */
	public static final String ATTR_USRCONNECTSEILNUM = "usrConnectSeilNum";

	/** set 사용자접속구분코드 : usrConnectDivCd */
	public static final String ATTR_USRCONNECTDIVCD = "usrConnectDivCd";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";
	
	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTNM = "deptNm";

	/** set 사용자구분코드 : usrDivCd */
	public static final String ATTR_USRDIVCD = "usrDivCd";

	/** set 사용자성명 : usrNm */
	public static final String ATTR_USRNM = "usrNm";

	/** set 사용자접속시작일시 : usrConnectBgnnDtntm */
	public static final String ATTR_USRCONNECTBGNNDTNTM = "usrConnectBgnnDtntm";

	/** set 사용자접속종료일시 : usrConnectEndDtntm */
	public static final String ATTR_USRCONNECTENDDTNTM = "usrConnectEndDtntm";

	/** set SESSIONKEY : sessionkey */
	public static final String ATTR_SESSIONKEY = "sessionkey";

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
	 public SysIfHist0100BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfHist0100BM(
			 String  dpobCd 
			, String  usrConnectYr 
			, String  usrId 
			, BigDecimal  usrConnectSeilNum 
			, String  usrConnectDivCd 
			, String  deptCd 
			, String  usrDivCd 
			, String  usrNm 
			, String  usrConnectBgnnDtntm 
			, String  usrConnectEndDtntm 
			, String  sessionkey 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_USRCONNECTYR,usrConnectYr);
	 	values.put(ATTR_USRID,usrId);
	 	values.put(ATTR_USRCONNECTSEILNUM,usrConnectSeilNum);
	 	values.put(ATTR_USRCONNECTDIVCD,usrConnectDivCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_USRDIVCD,usrDivCd);
	 	values.put(ATTR_USRNM,usrNm);
	 	values.put(ATTR_USRCONNECTBGNNDTNTM,usrConnectBgnnDtntm);
	 	values.put(ATTR_USRCONNECTENDDTNTM,usrConnectEndDtntm);
	 	values.put(ATTR_SESSIONKEY,sessionkey);
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
	/** set 사용자접속년도 : usrConnectYr */
	public void setUsrConnectYr(String  usrConnectYr) { set( ATTR_USRCONNECTYR ,usrConnectYr);}
	/** get 사용자접속년도 : usrConnectYr */
	public String  getUsrConnectYr() { return (String )get( ATTR_USRCONNECTYR );}
	/** set 사용자아이디 : usrId */
	public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
	/** get 사용자아이디 : usrId */
	public String  getUsrId() { return (String )get( ATTR_USRID );}
	/** set 사용자접속일련번호 : usrConnectSeilNum */
	public void setUsrConnectSeilNum(BigDecimal  usrConnectSeilNum) { set( ATTR_USRCONNECTSEILNUM ,usrConnectSeilNum);}
	/** get 사용자접속일련번호 : usrConnectSeilNum */
	public BigDecimal  getUsrConnectSeilNum() { return (BigDecimal )get( ATTR_USRCONNECTSEILNUM );}
	/** set 사용자접속구분코드 : usrConnectDivCd */
	public void setUsrConnectDivCd(String  usrConnectDivCd) { set( ATTR_USRCONNECTDIVCD ,usrConnectDivCd);}
	/** get 사용자접속구분코드 : usrConnectDivCd */
	public String  getUsrConnectDivCd() { return (String )get( ATTR_USRCONNECTDIVCD );}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	/** set 부서코드 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서코드 : deptNm */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
	/** set 사용자구분코드 : usrDivCd */
	public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
	/** get 사용자구분코드 : usrDivCd */
	public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}
	/** set 사용자성명 : usrNm */
	public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
	/** get 사용자성명 : usrNm */
	public String  getUsrNm() { return (String )get( ATTR_USRNM );}
	/** set 사용자접속시작일시 : usrConnectBgnnDtntm */
	public void setUsrConnectBgnnDtntm(String  usrConnectBgnnDtntm) { set( ATTR_USRCONNECTBGNNDTNTM ,usrConnectBgnnDtntm);}
	/** get 사용자접속시작일시 : usrConnectBgnnDtntm */
	public String  getUsrConnectBgnnDtntm() { return (String )get( ATTR_USRCONNECTBGNNDTNTM );}
	/** set 사용자접속종료일시 : usrConnectEndDtntm */
	public void setUsrConnectEndDtntm(String  usrConnectEndDtntm) { set( ATTR_USRCONNECTENDDTNTM ,usrConnectEndDtntm);}
	/** get 사용자접속종료일시 : usrConnectEndDtntm */
	public String  getUsrConnectEndDtntm() { return (String )get( ATTR_USRCONNECTENDDTNTM );}
	/** set SESSIONKEY : sessionkey */
	public void setSessionkey(String  sessionkey) { set( ATTR_SESSIONKEY ,sessionkey);}
	/** get SESSIONKEY : sessionkey */
	public String  getSessionkey() { return (String )get( ATTR_SESSIONKEY );}
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
