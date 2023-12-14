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
public class SysIfHist0200BM  extends MSFSimpleBaseModel implements IsSerializable   {
	
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 사용자작업년도 : usrJobYr */
	public static final String ATTR_USRJOBYR = "usrJobYr";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 사용자작업일련번호 : usrJobSeilNum */
	public static final String ATTR_USRJOBSEILNUM = "usrJobSeilNum";

	/** set 사용자접속구분코드 : usrConnectDivCd */
	public static final String ATTR_USRCONNECTDIVCD = "usrConnectDivCd";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";
	
	/** set 부서코드 : deptNm */
	public static final String ATTR_DEPTNM = "deptNm";

	/** set 사용자구분코드 : usrDivCd */
	public static final String ATTR_USRDIVCD = "usrDivCd";

	/** set 사용자성명 : usrNm */
	public static final String ATTR_USRNM = "usrNm";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 사용자작업일시 : usrJobDtntm */
	public static final String ATTR_USRJOBDTNTM = "usrJobDtntm";

	/** set 사용자작업구분코드 : usrJobSeptDivCd */
	public static final String ATTR_USRJOBSEPTDIVCD = "usrJobSeptDivCd";

	/** set 사용자작업메소드명 : usrJobEthdNm */
	public static final String ATTR_USRJOBETHDNM = "usrJobEthdNm";

	/** set 사용자작업시작일시 : usrJobBgnnTm */
	public static final String ATTR_USRJOBBGNNTM = "usrJobBgnnTm";

	/** set 사용자작업종료일시 : usrJobEndTm */
	public static final String ATTR_USRJOBENDTM = "usrJobEndTm";

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
	 public SysIfHist0200BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfHist0200BM(
			 String  dpobCd 
			, String  usrJobYr 
			, String  usrId 
			, BigDecimal  usrJobSeilNum 
			, String  usrConnectDivCd 
			, String  deptCd 
			, String  usrDivCd 
			, String  usrNm 
			, String  systemkey 
			, String  usrJobDtntm 
			, String  usrJobSeptDivCd 
			, String  usrJobEthdNm 
			, String  usrJobBgnnTm 
			, String  usrJobEndTm 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_USRJOBYR,usrJobYr);
	 	values.put(ATTR_USRID,usrId);
	 	values.put(ATTR_USRJOBSEILNUM,usrJobSeilNum);
	 	values.put(ATTR_USRCONNECTDIVCD,usrConnectDivCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_USRDIVCD,usrDivCd);
	 	values.put(ATTR_USRNM,usrNm);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_USRJOBDTNTM,usrJobDtntm);
	 	values.put(ATTR_USRJOBSEPTDIVCD,usrJobSeptDivCd);
	 	values.put(ATTR_USRJOBETHDNM,usrJobEthdNm);
	 	values.put(ATTR_USRJOBBGNNTM,usrJobBgnnTm);
	 	values.put(ATTR_USRJOBENDTM,usrJobEndTm);
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
	/** set 사용자작업년도 : usrJobYr */
	public void setUsrJobYr(String  usrJobYr) { set( ATTR_USRJOBYR ,usrJobYr);}
	/** get 사용자작업년도 : usrJobYr */
	public String  getUsrJobYr() { return (String )get( ATTR_USRJOBYR );}
	/** set 사용자아이디 : usrId */
	public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
	/** get 사용자아이디 : usrId */
	public String  getUsrId() { return (String )get( ATTR_USRID );}
	/** set 사용자작업일련번호 : usrJobSeilNum */
	public void setUsrJobSeilNum(BigDecimal  usrJobSeilNum) { set( ATTR_USRJOBSEILNUM ,usrJobSeilNum);}
	/** get 사용자작업일련번호 : usrJobSeilNum */
	public BigDecimal  getUsrJobSeilNum() { return (BigDecimal )get( ATTR_USRJOBSEILNUM );}
	/** set 사용자접속구분코드 : usrConnectDivCd */
	public void setUsrConnectDivCd(String  usrConnectDivCd) { set( ATTR_USRCONNECTDIVCD ,usrConnectDivCd);}
	/** get 사용자접속구분코드 : usrConnectDivCd */
	public String  getUsrConnectDivCd() { return (String )get( ATTR_USRCONNECTDIVCD );}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	
	
	/** set 부서코드 : deptCd */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서코드 : deptCd */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
	
	/** set 사용자구분코드 : usrDivCd */
	public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
	/** get 사용자구분코드 : usrDivCd */
	public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}
	/** set 사용자성명 : usrNm */
	public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
	/** get 사용자성명 : usrNm */
	public String  getUsrNm() { return (String )get( ATTR_USRNM );}
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
	/** set 사용자작업일시 : usrJobDtntm */
	public void setUsrJobDtntm(String  usrJobDtntm) { set( ATTR_USRJOBDTNTM ,usrJobDtntm);}
	/** get 사용자작업일시 : usrJobDtntm */
	public String  getUsrJobDtntm() { return (String )get( ATTR_USRJOBDTNTM );}
	/** set 사용자작업구분코드 : usrJobSeptDivCd */
	public void setUsrJobSeptDivCd(String  usrJobSeptDivCd) { set( ATTR_USRJOBSEPTDIVCD ,usrJobSeptDivCd);}
	/** get 사용자작업구분코드 : usrJobSeptDivCd */
	public String  getUsrJobSeptDivCd() { return (String )get( ATTR_USRJOBSEPTDIVCD );}
	/** set 사용자작업메소드명 : usrJobEthdNm */
	public void setUsrJobEthdNm(String  usrJobEthdNm) { set( ATTR_USRJOBETHDNM ,usrJobEthdNm);}
	/** get 사용자작업메소드명 : usrJobEthdNm */
	public String  getUsrJobEthdNm() { return (String )get( ATTR_USRJOBETHDNM );}
	/** set 사용자작업시작일시 : usrJobBgnnTm */
	public void setUsrJobBgnnTm(String  usrJobBgnnTm) { set( ATTR_USRJOBBGNNTM ,usrJobBgnnTm);}
	/** get 사용자작업시작일시 : usrJobBgnnTm */
	public String  getUsrJobBgnnTm() { return (String )get( ATTR_USRJOBBGNNTM );}
	/** set 사용자작업종료일시 : usrJobEndTm */
	public void setUsrJobEndTm(String  usrJobEndTm) { set( ATTR_USRJOBENDTM ,usrJobEndTm);}
	/** get 사용자작업종료일시 : usrJobEndTm */
	public String  getUsrJobEndTm() { return (String )get( ATTR_USRJOBENDTM );}
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
