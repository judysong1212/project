package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0500BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	  
	/** set 시스템구분코드 : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 사용자권한구분코드 : usrDivCd */
	public static final String ATTR_USRDIVCD = "usrDivCd";
	
	public static final String ATTR_USRNM = "usrNm";

	/** set 사용자권한구분 : usrDivNm */
	public static final String ATTR_USRDIVNM = "usrDivNm";
	 
	/** set 사용자권한사용여부 : usrAuthUseYn */
	public static final String ATTR_USRAUTHUSEYN = "usrAuthUseYn";

	/** set 입력자 : kybdr */
	public static final String ATTR_KYBDR = "kybdr";

	/** set 입력일자 : inptDt */
	public static final String ATTR_INPTDT = "inptDt";

	/** set 수정자 : ismt */
	public static final String ATTR_ISMT = "ismt";

	/** set 수정일자 : revnDt */
	public static final String ATTR_REVNDT = "revnDt";

	/** set 수정주소 : revnAddr */
	public static final String ATTR_REVNADDR = "revnAddr";

	/** set 입력주소 : inptAddr */
	public static final String ATTR_INPTADDR = "inptAddr";
	
 
	/** set 권한그룹일련번호 : authGrpSeilNum */
	public static final String ATTR_AUTHGRPSEILNUM = "authGrpSeilNum";
 

	/** set 권한그룹명 : authGrpNm */
	public static final String ATTR_AUTHGRPNM = "authGrpNm";


	/** 생성자 */
	 public SysIfSysm0500BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfSysm0500BM(
			 String  sysDivCd 
			, String  usrId 
			, String  usrDivCd 
			, String  usrAuthUseYn 
			, String  kybdr 
			, String  inptDt 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr 
			, String  inptAddr ) { 
	 	values.put(ATTR_SYSDIVCD,sysDivCd);
	 	values.put(ATTR_USRID,usrId);
	 	values.put(ATTR_USRDIVCD,usrDivCd);
	 	values.put(ATTR_USRAUTHUSEYN,usrAuthUseYn);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr);
	 	values.put(ATTR_INPTADDR,inptAddr); } 

	/** set 시스템구분코드 : sysDivCd */
	public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
	/** get 시스템구분코드 : sysDivCd */
	public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

	/** set 사용자아이디 : usrId */
	public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
	/** get 사용자아이디 : usrId */
	public String  getUsrId() { return (String )get( ATTR_USRID );}

	/** set 사용자권한구분코드 : usrDivCd */
	public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
	/** get 사용자권한구분코드 : usrDivCd */
	public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}
	
	/** set 사용자아이디 : usrNm */
	public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
	/** get 사용자아이디 : usrNm */
	public String  getUsrNm() { return (String )get( ATTR_USRNM );}

	/** set 사용자권한구분코드 : usrDivNm */
	public void setUsrDivNm(String  usrDivNm) { set( ATTR_USRDIVNM ,usrDivNm);}
	/** get 사용자권한구분코드 : usrDivNm */
	public String  getUsrDivNm() { return (String )get( ATTR_USRDIVNM );}
	 
	/** set 사용자권한사용여부 : usrAuthUseYn */
	public void setUsrAuthUseYn(String  usrAuthUseYn) { set( ATTR_USRAUTHUSEYN ,usrAuthUseYn);}
	/** get 사용자권한사용여부 : usrAuthUseYn */
	public String  getUsrAuthUseYn() { return (String )get( ATTR_USRAUTHUSEYN );}

	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
	/** get 입력자 : kybdr */
	public String  getKybdr() { return (String )get( ATTR_KYBDR );}

	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
	/** get 입력일자 : inptDt */
	public String  getInptDt() { return (String )get( ATTR_INPTDT );}

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

	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}
	
	/** set 권한그룹일련번호 : authGrpSeilNum */
	public void setAuthGrpSeilNum(BigDecimal  authGrpSeilNum) { set( ATTR_AUTHGRPSEILNUM ,authGrpSeilNum);}
	/** get 권한그룹일련번호 : authGrpSeilNum */
	public BigDecimal  getAuthGrpSeilNum() { return (BigDecimal )get( ATTR_AUTHGRPSEILNUM );}
 
	/** set 권한그룹명 : authGrpNm */
	public void setAuthGrpNm(String  authGrpNm) { set( ATTR_AUTHGRPNM ,authGrpNm);}
	/** get 권한그룹명 : authGrpNm */
	public String  getAuthGrpNm() { return (String )get( ATTR_AUTHGRPNM );}


}
