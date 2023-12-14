package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0300BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 시스템구분코드 : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";

	/** set 권한그룹일련번호 : authGrpSeilNum */
	public static final String ATTR_AUTHGRPSEILNUM = "authGrpSeilNum";

	/** set 시스템업무구분코드 : businDivCd */
	public static final String ATTR_BUSINDIVCD = "businDivCd";

	/** set 권한그룹명 : authGrpNm */
	public static final String ATTR_AUTHGRPNM = "authGrpNm";

	/** set 등급 : grde */
	public static final String ATTR_GRDE = "grde";

	/** set 권한그룹사용여부 : authGrpUseYn */
	public static final String ATTR_AUTHGRPUSEYN = "authGrpUseYn";

	/** set 그룹설명 : grpEpln */
	public static final String ATTR_GRPEPLN = "grpEpln";

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

	/** 생성자 */
	 public SysIfSysm0300BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfSysm0300BM(
			 String  sysDivCd 
			, BigDecimal  authGrpSeilNum 
			, String  businDivCd 
			, String  authGrpNm 
			, String  grde 
			, String  authGrpUseYn 
			, String  grpEpln  ) { 
	 	values.put(ATTR_SYSDIVCD,sysDivCd);
	 	values.put(ATTR_AUTHGRPSEILNUM,authGrpSeilNum);
	 	values.put(ATTR_BUSINDIVCD,businDivCd);
	 	values.put(ATTR_AUTHGRPNM,authGrpNm);
	 	values.put(ATTR_GRDE,grde);
	 	values.put(ATTR_AUTHGRPUSEYN,authGrpUseYn);
	 	values.put(ATTR_GRPEPLN,grpEpln); } 

	/** set 시스템구분코드 : sysDivCd */
	public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
	/** get 시스템구분코드 : sysDivCd */
	public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

	/** set 권한그룹일련번호 : authGrpSeilNum */
	public void setAuthGrpSeilNum(BigDecimal  authGrpSeilNum) { set( ATTR_AUTHGRPSEILNUM ,authGrpSeilNum);}
	/** get 권한그룹일련번호 : authGrpSeilNum */
	public BigDecimal  getAuthGrpSeilNum() { return (BigDecimal )get( ATTR_AUTHGRPSEILNUM );}

	/** set 시스템업무구분코드 : businDivCd */
	public void setBusinDivCd(String  businDivCd) { set( ATTR_BUSINDIVCD ,businDivCd);}
	/** get 시스템업무구분코드 : businDivCd */
	public String  getBusinDivCd() { return (String )get( ATTR_BUSINDIVCD );}

	/** set 권한그룹명 : authGrpNm */
	public void setAuthGrpNm(String  authGrpNm) { set( ATTR_AUTHGRPNM ,authGrpNm);}
	/** get 권한그룹명 : authGrpNm */
	public String  getAuthGrpNm() { return (String )get( ATTR_AUTHGRPNM );}

	/** set 등급 : grde */
	public void setGrde(String  grde) { set( ATTR_GRDE ,grde);}
	/** get 등급 : grde */
	public String  getGrde() { return (String )get( ATTR_GRDE );}

	/** set 권한그룹사용여부 : authGrpUseYn */
	public void setAuthGrpUseYn(String  authGrpUseYn) { set( ATTR_AUTHGRPUSEYN ,authGrpUseYn);}
	/** get 권한그룹사용여부 : authGrpUseYn */
	public String  getAuthGrpUseYn() { return (String )get( ATTR_AUTHGRPUSEYN );}

	/** set 그룹설명 : grpEpln */
	public void setGrpEpln(String  grpEpln) { set( ATTR_GRPEPLN ,grpEpln);}
	/** get 그룹설명 : grpEpln */
	public String  getGrpEpln() { return (String )get( ATTR_GRPEPLN );}

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



}
