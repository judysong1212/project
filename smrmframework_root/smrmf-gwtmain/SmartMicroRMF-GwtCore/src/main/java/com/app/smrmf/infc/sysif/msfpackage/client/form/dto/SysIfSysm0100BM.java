package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0100BM  extends MSFSimpleBaseModel implements IsSerializable{
	
	
	/** set 시스템구분코드 : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 사용자성명 : usrNm */
	public static final String ATTR_USRNM = "usrNm";

	/** set 사용자구분코드 : usrDivCd */
	public static final String ATTR_USRDIVCD = "usrDivCd";
	
	/** set 사용자구분 : usrDivNm */
	public static final String ATTR_USRDIVNM = "usrDivNm";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";


	/** set 부서 : deptNm */
	public static final String ATTR_DEPTNM = "deptNm";

	
	/** set null : usrTel */
	public static final String ATTR_USRTEL = "usrTel";

	/** set 이메일 : email */
	public static final String ATTR_EMAIL = "email";

	/** set 패스워드 : pwd */
	public static final String ATTR_PWD = "pwd";
	
	/** set 패스워드 : tmpPwd */
	public static final String ATTR_TMPPWD = "tmpPwd";

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
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd"; 

    /** set 호봉등급 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
   

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
    
    // 추가_hieju/05.15
    
    /** set 계정잠금  : lockat */
    public static final String ATTR_LOCKAT = "lockat";
	
	/** set 비밀번호 변경 날짜 : pwddate */
    public static final String ATTR_PWD_DATE = "pwddate"; 
	
	   /** set 로그인 횟수 : logincnt */
    public static final String ATTR_LOGINCNT = "logincnt"; 

    


	/** 생성자 */
	 public SysIfSysm0100BM() { super(); } 

	// 추가 hieju_05.15
	/** 일괄등록 처리   */
	 public SysIfSysm0100BM(
			 String  sysDivCd 
			, String  usrId 
			, String  usrNm 
			, String  usrDivCd 
			, String  systemkey 
			, String  deptCd 
			, String  usrTel 
			, String  email 
			, String  pwd 
			, Boolean  useYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr
			, Boolean  lockat) { 
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
	 	values.put(ATTR_LOCKAT,lockat);
	 	} 

	 

	    /** set 직종코드 : typOccuCd */
	    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	    /** get 직종코드 : typOccuCd */
	    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

	     
	    /** set 직종 : typOccuNm */
	    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
	    /** get 직종 : typOccuNm */
	    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
 
	    /** set 호봉등급코드 : pyspGrdeCd */
	    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	    /** get 호봉등급코드 : pyspGrdeCd */
	    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}


	    /** set 호봉등급 : pyspGrdeNm */
	    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
	    /** get 호봉등급 : pyspGrdeNm */
	    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
	    
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

	/** set 사용자구분코드 : usrDivCd */
	public void setUsrDivCd(String  usrDivCd) { set( ATTR_USRDIVCD ,usrDivCd);}
	/** get 사용자구분코드 : usrDivCd */
	public String  getUsrDivCd() { return (String )get( ATTR_USRDIVCD );}
	

	/** set 사용자구분 : usrDivNm */
	public void setUsrDivNm(String  usrDivNm) { set( ATTR_USRDIVNM ,usrDivNm);}
	/** get 사용자구분 : usrDivNm */
	public String  getUsrDivNm() { return (String )get( ATTR_USRDIVNM );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	
	/** set 부서코드 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서코드 : deptNm */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}


	/** set 내선번호 : usrTel */
	public void setUsrTel(String  usrTel) { set( ATTR_USRTEL ,usrTel);}
	/** get 내선번호 : usrTel */
	public String  getUsrTel() { return (String )get( ATTR_USRTEL );}

	/** set 이메일 : email */
	public void setEmail(String  email) { set( ATTR_EMAIL ,email);}
	/** get 이메일 : email */
	public String  getEmail() { return (String )get( ATTR_EMAIL );}

	/** set 패스워드 : pwd */
	public void setPwd(String  pwd) { set( ATTR_PWD ,pwd);}
	/** get 패스워드 : pwd */
	public String  getPwd() { return (String )get( ATTR_PWD );}

	/** set 패스워드 : tmpPwd */
	public void setTmpPwd(String  tmpPwd) { set( ATTR_TMPPWD ,tmpPwd);}
	/** get 패스워드 : tmpPwd */
	public String  getTmpPwd() { return (String )get( ATTR_TMPPWD );} 
	
	
	/** set 사용자사용여부 : useYn */
	public void setUseYn(Boolean  useYn) { set( ATTR_USEYN ,useYn);}
	/** get 사용자사용여부 : useYn */
	public Boolean  getUseYn() { return (Boolean )get( ATTR_USEYN );}

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

// 추가 hieju_05.15
/** set 계정잠금 : lockat */
public void setLockat(Boolean  lockat) { set( ATTR_LOCKAT ,lockat);}
/** get 계정잠금 : lockat */
public Boolean  getLockat() { return (Boolean )get( ATTR_LOCKAT );}

/** set 비밀번호 변경 날짜 : pwddate */
public void setPwddate(String  pwddate) { set( ATTR_PWD_DATE ,pwddate);}
/** get 비밀번호 변경 날짜 : pwddate */
public String  getPwddate() { return (String )get( ATTR_PWD_DATE );}

/** set 로그인 횟수 : logincnt */
public void setLogincnt(String  logincnt) { set( ATTR_LOGINCNT ,logincnt);}
/** get 로그인 횟수 : logincnt */
public String  getLogincnt() { return (String )get( ATTR_LOGINCNT );}

}
