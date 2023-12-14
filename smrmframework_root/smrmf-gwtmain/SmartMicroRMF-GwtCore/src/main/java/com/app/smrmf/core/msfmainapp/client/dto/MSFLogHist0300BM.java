package com.app.smrmf.core.msfmainapp.client.dto;

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
public class MSFLogHist0300BM  extends MSFSimpleBaseModel implements IsSerializable   {
	
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 에러발생년도 : errOccrrncYr */
	public static final String ATTR_ERROCCRRNCYR = "errOccrrncYr";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 에러일련번호 : errSeilNum */
	public static final String ATTR_ERRSEILNUM = "errSeilNum";

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

	/** set 에러발생일시 : errOccrrncDtntm */
	public static final String ATTR_ERROCCRRNCDTNTM = "errOccrrncDtntm";

	/** set 에러메소드명 : errEthdNm */
	public static final String ATTR_ERRETHDNM = "errEthdNm";

	/** set 에러명 : errNm */
	public static final String ATTR_ERRNM = "errNm";

	/** set 에러내용 : errCtnt */
	public static final String ATTR_ERRCTNT = "errCtnt";

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
	 public MSFLogHist0300BM() { super(); } 

	/** 일괄등록 처리   */
	 public MSFLogHist0300BM(
			 String  dpobCd 
			, String  errOccrrncYr 
			, String  usrId 
			, BigDecimal  errSeilNum 
			, String  usrConnectDivCd 
			, String  deptCd 
			, String  usrDivCd 
			, String  usrNm 
			, String  errOccrrncDtntm 
			, String  errEthdNm 
			, String  errNm 
			, String  errCtnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_ERROCCRRNCYR,errOccrrncYr);
	 	values.put(ATTR_USRID,usrId);
	 	values.put(ATTR_ERRSEILNUM,errSeilNum);
	 	values.put(ATTR_USRCONNECTDIVCD,usrConnectDivCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_USRDIVCD,usrDivCd);
	 	values.put(ATTR_USRNM,usrNm);
	 	values.put(ATTR_ERROCCRRNCDTNTM,errOccrrncDtntm);
	 	values.put(ATTR_ERRETHDNM,errEthdNm);
	 	values.put(ATTR_ERRNM,errNm);
	 	values.put(ATTR_ERRCTNT,errCtnt);
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
	/** set 에러발생년도 : errOccrrncYr */
	public void setErrOccrrncYr(String  errOccrrncYr) { set( ATTR_ERROCCRRNCYR ,errOccrrncYr);}
	/** get 에러발생년도 : errOccrrncYr */
	public String  getErrOccrrncYr() { return (String )get( ATTR_ERROCCRRNCYR );}
	/** set 사용자아이디 : usrId */
	public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
	/** get 사용자아이디 : usrId */
	public String  getUsrId() { return (String )get( ATTR_USRID );}
	/** set 에러일련번호 : errSeilNum */
	public void setErrSeilNum(BigDecimal  errSeilNum) { set( ATTR_ERRSEILNUM ,errSeilNum);}
	/** get 에러일련번호 : errSeilNum */
	public BigDecimal  getErrSeilNum() { return (BigDecimal )get( ATTR_ERRSEILNUM );}
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
	/** set 에러발생일시 : errOccrrncDtntm */
	public void setErrOccrrncDtntm(String  errOccrrncDtntm) { set( ATTR_ERROCCRRNCDTNTM ,errOccrrncDtntm);}
	/** get 에러발생일시 : errOccrrncDtntm */
	public String  getErrOccrrncDtntm() { return (String )get( ATTR_ERROCCRRNCDTNTM );}
	/** set 에러메소드명 : errEthdNm */
	public void setErrEthdNm(String  errEthdNm) { set( ATTR_ERRETHDNM ,errEthdNm);}
	/** get 에러메소드명 : errEthdNm */
	public String  getErrEthdNm() { return (String )get( ATTR_ERRETHDNM );}
	/** set 에러명 : errNm */
	public void setErrNm(String  errNm) { set( ATTR_ERRNM ,errNm);}
	/** get 에러명 : errNm */
	public String  getErrNm() { return (String )get( ATTR_ERRNM );}
	/** set 에러내용 : errCtnt */
	public void setErrCtnt(String  errCtnt) { set( ATTR_ERRCTNT ,errCtnt);}
	/** get 에러내용 : errCtnt */
	public String  getErrCtnt() { return (String )get( ATTR_ERRCTNT );}
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
