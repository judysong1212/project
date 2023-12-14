package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0850BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 시스템구분코드 : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";

	/** set 사용자권한구분코드 : usrDivCd */
	public static final String ATTR_USRDIVCD = "usrDivCd";

	/** set 메뉴코드 : mnuCd */
	public static final String ATTR_MNUCD = "mnuCd";
	

	/** set 사용자성명 : usrNm */
	public static final String ATTR_USRNM = "usrNm";
	

	/** set 사용자권한구분 : usrDivNm */
	public static final String ATTR_USRDIVNM = "usrDivNm";
    /** set 메뉴명 : mnuNm */
    public static final String ATTR_MNUNM = "mnuNm";


	/** set 메뉴권한그룹화면조회여부 : mnuAuthGrpScnInqyYn */
	public static final String ATTR_MNUAUTHGRPSCNINQYYN = "mnuAuthGrpScnInqyYn";

	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrpScnInptYn */
	public static final String ATTR_MNUAUTHGRPSCNINPTYN = "mnuAuthGrpScnInptYn";

	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrpScnRevnYn */
	public static final String ATTR_MNUAUTHGRPSCNREVNYN = "mnuAuthGrpScnRevnYn";

	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrpScnDelYn */
	public static final String ATTR_MNUAUTHGRPSCNDELYN = "mnuAuthGrpScnDelYn";

	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrpScnPrtYn */
	public static final String ATTR_MNUAUTHGRPSCNPRTYN = "mnuAuthGrpScnPrtYn";

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
	 public SysIfSysm0850BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfSysm0850BM(
			 String  usrId 
			, String  sysDivCd 
			, String  usrDivCd 
			, String  mnuCd 
			, String  mnuAuthGrpScnInqyYn 
			, String  mnuAuthGrpScnInptYn 
			, String  mnuAuthGrpScnRevnYn 
			, String  mnuAuthGrpScnDelYn 
			, String  mnuAuthGrpScnPrtYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_USRID,usrId);
	 	values.put(ATTR_SYSDIVCD,sysDivCd);
	 	values.put(ATTR_USRDIVCD,usrDivCd);
	 	values.put(ATTR_MNUCD,mnuCd);
	 	values.put(ATTR_MNUAUTHGRPSCNINQYYN,mnuAuthGrpScnInqyYn);
	 	values.put(ATTR_MNUAUTHGRPSCNINPTYN,mnuAuthGrpScnInptYn);
	 	values.put(ATTR_MNUAUTHGRPSCNREVNYN,mnuAuthGrpScnRevnYn);
	 	values.put(ATTR_MNUAUTHGRPSCNDELYN,mnuAuthGrpScnDelYn);
	 	values.put(ATTR_MNUAUTHGRPSCNPRTYN,mnuAuthGrpScnPrtYn);
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

	/** set 시스템구분코드 : sysDivCd */
	public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
	/** get 시스템구분코드 : sysDivCd */
	public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

	/** set 사용자권한구분코드 : usrDivCd */
	public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
	/** get 사용자권한구분코드 : usrDivCd */
	public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}

	/** set 메뉴코드 : mnuCd */
	public void setMnuCd(String  mnuCd) { set( ATTR_MNUCD ,mnuCd);}
	/** get 메뉴코드 : mnuCd */
	public String  getMnuCd() { return (String )get( ATTR_MNUCD );}

	/** set 메뉴권한그룹화면조회여부 : mnuAuthGrpScnInqyYn */
	public void setMnuAuthGrpScnInqyYn(String  mnuAuthGrpScnInqyYn) { set( ATTR_MNUAUTHGRPSCNINQYYN ,mnuAuthGrpScnInqyYn);}
	/** get 메뉴권한그룹화면조회여부 : mnuAuthGrpScnInqyYn */
	public String  getMnuAuthGrpScnInqyYn() { return (String )get( ATTR_MNUAUTHGRPSCNINQYYN );}

	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrpScnInptYn */
	public void setMnuAuthGrpScnInptYn(String  mnuAuthGrpScnInptYn) { set( ATTR_MNUAUTHGRPSCNINPTYN ,mnuAuthGrpScnInptYn);}
	/** get 메뉴권한그룹화면입력여부 : mnuAuthGrpScnInptYn */
	public String  getMnuAuthGrpScnInptYn() { return (String )get( ATTR_MNUAUTHGRPSCNINPTYN );}

	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrpScnRevnYn */
	public void setMnuAuthGrpScnRevnYn(String  mnuAuthGrpScnRevnYn) { set( ATTR_MNUAUTHGRPSCNREVNYN ,mnuAuthGrpScnRevnYn);}
	/** get 메뉴권한그룹화면수정여부 : mnuAuthGrpScnRevnYn */
	public String  getMnuAuthGrpScnRevnYn() { return (String )get( ATTR_MNUAUTHGRPSCNREVNYN );}

	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrpScnDelYn */
	public void setMnuAuthGrpScnDelYn(String  mnuAuthGrpScnDelYn) { set( ATTR_MNUAUTHGRPSCNDELYN ,mnuAuthGrpScnDelYn);}
	/** get 메뉴권한그룹화면삭제여부 : mnuAuthGrpScnDelYn */
	public String  getMnuAuthGrpScnDelYn() { return (String )get( ATTR_MNUAUTHGRPSCNDELYN );}

	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrpScnPrtYn */
	public void setMnuAuthGrpScnPrtYn(String  mnuAuthGrpScnPrtYn) { set( ATTR_MNUAUTHGRPSCNPRTYN ,mnuAuthGrpScnPrtYn);}
	/** get 메뉴권한그룹화면인쇄여부 : mnuAuthGrpScnPrtYn */
	public String  getMnuAuthGrpScnPrtYn() { return (String )get( ATTR_MNUAUTHGRPSCNPRTYN );}

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
	
	/** set 사용자권한구분코드 : usrDivNm */
	public void setUsrDivNm(String  usrDivNm) { set( ATTR_USRDIVNM ,usrDivNm);}
	/** get 사용자권한구분코드 : usrDivNm */
	public String  getUsrDivNm() { return (String )get( ATTR_USRDIVNM );}
	
	

	/** set 사용자성명 : usrNm */
	public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
	/** get 사용자성명 : usrNm */
	public String  getUsrNm() { return (String )get( ATTR_USRNM );}

    /** set 메뉴명 : mnuNm */
    public void setMnuNm(String  mnuNm) { set( ATTR_MNUNM ,mnuNm);}
    /** get 메뉴명 : mnuNm */
    public String  getMnuNm() { return (String )get( ATTR_MNUNM );}


}
