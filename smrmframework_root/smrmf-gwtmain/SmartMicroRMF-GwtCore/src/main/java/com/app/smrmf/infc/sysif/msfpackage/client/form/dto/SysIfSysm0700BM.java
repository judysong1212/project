package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0700BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	  /** set 직종통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

	/** set 직종세코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";

	/** set 사용자아이디 : usrId */
	public static final String ATTR_USRID = "usrId";

	/** set 사용자성명 : usrNm */
	public static final String ATTR_USRNM = "usrNm";
	
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

	
	/** 선택버튼 : select */
	public static final String ATTR_SELECT = "select";
	
	  
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";



    /** set 직종세명 : dtilOccuClsNm */
    public static final String ATTR_DTILOCCUCLSNM = "dtilOccuClsNm";
    
    /** set 직종세사용여부 : dtilOccuClsUseYn */
    public static final String ATTR_DTILOCCUCLSUSEYN = "dtilOccuClsUseYn";
    

    /** 부서명_단축 : deptNmRtchnt */
    public static final String ATTR_DEPTNMRTCHNT = "deptNmRtchnt";
    

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public static final String ATTR_DTILOCCUJBFMLDIVCD = "dtilOccuJbfmlDivCd";
    

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivNm */
    public static final String ATTR_DTILOCCUJBFMLDIVNM = "dtilOccuJbfmlDivNm";



	/** 생성자 */
	 public SysIfSysm0700BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysIfSysm0700BM(
			 String  dpobCd 
			, String  dtilOccuInttnCd 
			, String  dtilOccuClsDivCd 
			, String  deptCd 
			, String  usrId 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
	 	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_USRID,usrId);
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
 

	/** set 직종세코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

	/** set 사용자아이디 : usrId */
	public void setUsrId(String  usrId) { set( ATTR_USRID ,usrId);}
	/** get 사용자아이디 : usrId */
	public String  getUsrId() { return (String )get( ATTR_USRID );}

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



    /** set 직종명 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종명 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
    
    /** set 부서명_단축 : deptNmRtchnt */
    public void setDeptNmRtchnt(String deptNmRtchnt) { set( ATTR_DEPTNMRTCHNT ,deptNmRtchnt);}
    /** get 부서명_단축 : deptNmRtchnt */
    public String getDeptNmRtchnt() { return (String)get( ATTR_DEPTNMRTCHNT );}

    /** set 직종세사용여부 : dtilOccuClsUseYn */
    public void setDtilOccuClsUseYn(String  dtilOccuClsUseYn) { set( ATTR_DTILOCCUCLSUSEYN ,dtilOccuClsUseYn);}
    /** get 직종세사용여부 : dtilOccuClsUseYn */
    public String  getDtilOccuClsUseYn() { return (String )get( ATTR_DTILOCCUCLSUSEYN );}


    /** set 직종세명 : dtilOccuClsNm */
    public void setDtilOccuClsNm(String  dtilOccuClsNm) { set( ATTR_DTILOCCUCLSNM ,dtilOccuClsNm);}
    /** get 직종세명 : dtilOccuClsNm */
    public String  getDtilOccuClsNm() { return (String )get( ATTR_DTILOCCUCLSNM );}
    
    

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public void setDtilOccuJbfmlDivCd(String  dtilOccuJbfmlDivCd) { set( ATTR_DTILOCCUJBFMLDIVCD ,dtilOccuJbfmlDivCd);}
    /** get 직종세직군구분코드 : dtilOccuJbfmlDivCd */
    public String  getDtilOccuJbfmlDivCd() { return (String )get( ATTR_DTILOCCUJBFMLDIVCD );}
    

    /** set 직종세직군구분코드 : dtilOccuJbfmlDivNm */
    public void setDtilOccuJbfmlDivNm(String  dtilOccuJbfmlDivNm) { set( ATTR_DTILOCCUJBFMLDIVNM ,dtilOccuJbfmlDivNm);}
    /** get 직종세직군구분코드 : dtilOccuJbfmlDivNm */
    public String  getDtilOccuJbfmlDivNm() { return (String )get( ATTR_DTILOCCUJBFMLDIVNM );}
    

	/** set 사용자성명 : usrNm */
	public void setUsrNm(String  usrNm) { set( ATTR_USRNM ,usrNm);}
	/** get 사용자성명 : usrNm */
	public String  getUsrNm() { return (String )get( ATTR_USRNM );}


    /** set 직종통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

}
