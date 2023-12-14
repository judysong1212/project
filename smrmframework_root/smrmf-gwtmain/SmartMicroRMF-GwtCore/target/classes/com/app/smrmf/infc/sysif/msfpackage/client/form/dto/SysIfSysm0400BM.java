package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0400BM  extends BaseModel implements IsSerializable{
	 
	/** set 시스템구분코드 : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";

	/** set 그룹일련번호 : authGrpSeilNum */
	public static final String ATTR_AUTHGRPSEILNUM = "authGrpSeilNum";

	/** set 메뉴코드 : mnuCd */
	public static final String ATTR_MNUCD = "mnuCd";
	

	/** set 메뉴명: mnuNm */
	public static final String ATTR_MNUNM = "mnuNm";
	

	/** set 상위메뉴: hhrkMnuCd */
	public static final String ATTR_HHRKMNUCD = "hhrkMnuCd";
	
	
	/** set 메뉴사용여부: mnuUseYn */
	public static final String ATTR_MNUUSEYN = "mnuUseYn";

	
	/** set 메뉴권한그룹화면조회여부 : mnuAuthGrPScnInqyYn */
	public static final String ATTR_MNUAUTHGRPSCNINQYYN = "mnuAuthGrPScnInqyYn";

	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
	public static final String ATTR_MNUAUTHGRPSCNINPTYN = "mnuAuthGrPScnInptYn";

	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
	public static final String ATTR_MNUAUTHGRPSCNREVNYN = "mnuAuthGrPScnRevnYn";

	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
	public static final String ATTR_MNUAUTHGRPSCNDELYN = "mnuAuthGrPScnDelYn";

	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
	public static final String ATTR_MNUAUTHGRPSCNPRTYN = "mnuAuthGrPScnPrtYn";

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
	 public SysIfSysm0400BM() { super(); } 
 
	/** 일괄등록 처리   */
	 public SysIfSysm0400BM(
			 String  sysDivCd 
			, Long  authGrpSeilNum 
			, String  mnuCd 
			, String  mnuNm
			, String  hhrkMnuCd
			, Boolean mnuUseYn
			, Boolean  mnuAuthGrPScnInqyYn 
			, Boolean  mnuAuthGrPScnInptYn 
			, Boolean  mnuAuthGrPScnRevnYn 
			, Boolean  mnuAuthGrPScnDelYn 
			, Boolean  mnuAuthGrPScnPrtYn  ) { 
	 	set(ATTR_SYSDIVCD,sysDivCd);
	 	set(ATTR_AUTHGRPSEILNUM,authGrpSeilNum);
	 	set(ATTR_MNUCD,mnuCd);
	 	set(ATTR_MNUNM,mnuNm);
		set(ATTR_MNUUSEYN,mnuUseYn);
	 	set(ATTR_MNUAUTHGRPSCNINQYYN,mnuAuthGrPScnInqyYn);
	 	set(ATTR_MNUAUTHGRPSCNINPTYN,mnuAuthGrPScnInptYn);
	 	set(ATTR_MNUAUTHGRPSCNREVNYN,mnuAuthGrPScnRevnYn);
	 	set(ATTR_MNUAUTHGRPSCNDELYN,mnuAuthGrPScnDelYn);
	 	set(ATTR_MNUAUTHGRPSCNPRTYN,mnuAuthGrPScnPrtYn);  } 

 

	/** set 시스템구분코드 : sysDivCd */
	public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
	/** get 시스템구분코드 : sysDivCd */
	public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

	/** set 그룹일련번호 : authGrpSeilNum */
	public void setAuthGrpSeilNum(Long  authGrpSeilNum) { set( ATTR_AUTHGRPSEILNUM ,authGrpSeilNum);}
	/** get 그룹일련번호 : authGrpSeilNum */
	public Long  getAuthGrpSeilNum() { return (Long )get( ATTR_AUTHGRPSEILNUM );}

	/** set 메뉴코드 : mnuCd */
	public void setMnuCd(String  mnuCd) { set( ATTR_MNUCD ,mnuCd);}
	/** get 메뉴코드 : mnuCd */
	public String  getMnuCd() { return (String )get( ATTR_MNUCD );}
	 

	/** set 메뉴코드 : mnuNm */
	public void setMnuNm(String  mnuNm) { set( ATTR_MNUNM ,mnuNm);}
	/** get 메뉴코드 : mnuNm */
	public String  getMnuNm() { return (String )get( ATTR_MNUNM );} 
  
	/** set 메뉴코드 : hhrkMnuCd */
	public void setHhrkMnuCd(String  hhrkMnuCd) { set( ATTR_HHRKMNUCD ,hhrkMnuCd);}
	/** get 메뉴코드 : hhrkMnuCd */
	public String  getHhrkMnuCd() { return (String )get( ATTR_HHRKMNUCD );} 
	  
	
	/** set 메뉴 여부 : mnuUseYn */
	public void setMnuUseYn(Boolean  mnuUseYn) { set( ATTR_MNUUSEYN ,mnuUseYn);}
	/** get 메뉴 여부 : mnuUseYn */
	public Boolean  getMnuUseYn() { return (Boolean )get( ATTR_MNUUSEYN );}
	
	
	/** set 메뉴권한그룹화면조회여부 : mnuAuthGrPScnInqyYn */
	public void setMnuAuthGrPScnInqyYn(Boolean  mnuAuthGrPScnInqyYn) { set( ATTR_MNUAUTHGRPSCNINQYYN ,mnuAuthGrPScnInqyYn);}
	/** get 메뉴권한그룹화면조회여부 : mnuAuthGrPScnInqyYn */
	public Boolean  getMnuAuthGrPScnInqyYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNINQYYN );}

	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
	public void setMnuAuthGrPScnInptYn(Boolean  mnuAuthGrPScnInptYn) { set( ATTR_MNUAUTHGRPSCNINPTYN ,mnuAuthGrPScnInptYn);}
	/** get 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
	public Boolean  getMnuAuthGrPScnInptYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNINPTYN );}

	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
	public void setMnuAuthGrPScnRevnYn(Boolean  mnuAuthGrPScnRevnYn) { set( ATTR_MNUAUTHGRPSCNREVNYN ,mnuAuthGrPScnRevnYn);}
	/** get 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
	public Boolean  getMnuAuthGrPScnRevnYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNREVNYN );}

	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
	public void setMnuAuthGrPScnDelYn(Boolean  mnuAuthGrPScnDelYn) { set( ATTR_MNUAUTHGRPSCNDELYN ,mnuAuthGrPScnDelYn);}
	/** get 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
	public Boolean  getMnuAuthGrPScnDelYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNDELYN );}

	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
	public void setMnuAuthGrPScnPrtYn(Boolean  mnuAuthGrPScnPrtYn) { set( ATTR_MNUAUTHGRPSCNPRTYN ,mnuAuthGrPScnPrtYn);}
	/** get 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
	public Boolean  getMnuAuthGrPScnPrtYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNPRTYN );}

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
