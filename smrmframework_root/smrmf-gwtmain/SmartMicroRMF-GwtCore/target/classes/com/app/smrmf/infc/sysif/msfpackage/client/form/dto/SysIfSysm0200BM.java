package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;


import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;

import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysIfSysm0200BM  extends MSFSimpleBaseModel implements IsSerializable{
	  
    /** set 시스템구분코드 : sysDivCd */
    public static final String ATTR_SYSDIVCD = "sysDivCd";

    /** set 메뉴코드 : mnuCd */
    public static final String ATTR_MNUCD = "mnuCd";

    /** set 상위메뉴코드 : hhrkMnuCd */
    public static final String ATTR_HHRKMNUCD = "hhrkMnuCd";

    /** set 메뉴명 : mnuNm */
    public static final String ATTR_MNUNM = "mnuNm";

    /** set 메뉴아이콘 : mnuIcn */
    public static final String ATTR_MNUICN = "mnuIcn";

    /** set 메뉴썸네일 : mnuTmbl */
    public static final String ATTR_MNUTMBL = "mnuTmbl";

    /** set 메뉴권한유형코드 : mnuAuthFrmCd */
    public static final String ATTR_MNUAUTHFRMCD = "mnuAuthFrmCd";

    /** set 메뉴팁명 : mnuTipNm */
    public static final String ATTR_MNUTIPNM = "mnuTipNm";

    /** set 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
    public static final String ATTR_MNUSCNFRMPKGNM = "mnuScnFrmPkgNm";

    /** set 메뉴출력여부 : mnuPrntYn */
    public static final String ATTR_MNUPRNTYN = "mnuPrntYn";

    /** set 메뉴출력순서 : mnuPrntOrd */
    public static final String ATTR_MNUPRNTORD = "mnuPrntOrd";

    /** set 사용여부 : useYn */
    public static final String ATTR_USEYN = "useYn";

    /** set 메뉴설명 : mnuEpln */
    public static final String ATTR_MNUEPLN = "mnuEpln";

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
     public SysIfSysm0200BM() { super(); } 
      

     /** 일괄등록 처리   */
      public SysIfSysm0200BM(
     		 String  sysDivCd 
     		, String  mnuCd 
     		, String  hhrkMnuCd 
     		, String  mnuNm 
     		, String  mnuIcn 
     		, String  mnuTmbl 
     		, String  mnuAuthFrmCd 
     		, String  mnuTipNm 
     		, String  mnuScnFrmPkgNm 
     		, String  mnuPrntYn 
     		, String  mnuPrntOrd 
     		, String  useYn  
     		, String  mnuEpln 
     		, String  kybdr 
     		, String  inptDt 
     		, String  ismt 
     		, String  revnDt 
     		, String  revnAddr 
     		, String  inptAddr ) { 
      	values.put(ATTR_SYSDIVCD,sysDivCd);
      	values.put(ATTR_MNUCD,mnuCd);
      	values.put(ATTR_HHRKMNUCD,hhrkMnuCd);
      	values.put(ATTR_MNUNM,mnuNm);
      	values.put(ATTR_MNUICN,mnuIcn);
      	values.put(ATTR_MNUTMBL,mnuTmbl);
      	values.put(ATTR_MNUAUTHFRMCD,mnuAuthFrmCd);
      	values.put(ATTR_MNUTIPNM,mnuTipNm);
      	values.put(ATTR_MNUSCNFRMPKGNM,mnuScnFrmPkgNm);
      	values.put(ATTR_MNUPRNTYN,mnuPrntYn);
      	values.put(ATTR_MNUPRNTORD,mnuPrntOrd);
      	values.put(ATTR_USEYN,useYn);
      	values.put(ATTR_MNUEPLN,mnuEpln);
      	values.put(ATTR_KYBDR,kybdr);
      	values.put(ATTR_INPTDT,inptDt);
      	values.put(ATTR_ISMT,ismt);
      	values.put(ATTR_REVNDT,revnDt);
      	values.put(ATTR_REVNADDR,revnAddr);
      	values.put(ATTR_INPTADDR,inptAddr); } 

 	/** 일괄등록 처리   */
 	 public SysIfSysm0200BM(
 			 String   sysDivCd 
 			, String  mnuCd 
 			, String  hhrkMnuCd 
 			, String  mnuNm 
 			, String  mnuIcn 
 			, String  mnuTmbl 
 			, String  mnuAuthFrmCd 
 			, String  mnuTipNm 
 			, String  mnuScnFrmPkgNm 
 			, String  mnuPrntYn 
 			, String  mnuPrntOrd 
 			, String  useYn 
 			, String  mnuEpln 
// 			, Boolean  mnuAuthGrPScnInqyYn 
// 			, Boolean  mnuAuthGrPScnInptYn 
// 			, Boolean  mnuAuthGrPScnRevnYn 
// 			, Boolean  mnuAuthGrPScnDelYn 
// 			, Boolean  mnuAuthGrPScnPrtYn 
 			) { 
 	 	values.put(ATTR_SYSDIVCD,sysDivCd);
 	 	values.put(ATTR_MNUCD,mnuCd);
 	 	values.put(ATTR_HHRKMNUCD,hhrkMnuCd);
 	 	values.put(ATTR_MNUNM,mnuNm);
 	 	values.put(ATTR_MNUICN,mnuIcn);
 	 	values.put(ATTR_MNUTMBL,mnuTmbl);
 	 	values.put(ATTR_MNUAUTHFRMCD,mnuAuthFrmCd);
 	 	values.put(ATTR_MNUTIPNM,mnuTipNm);
 	 	values.put(ATTR_MNUSCNFRMPKGNM,mnuScnFrmPkgNm);
 	 	values.put(ATTR_MNUPRNTYN,mnuPrntYn);
 	 	values.put(ATTR_MNUPRNTORD,mnuPrntOrd);
 	 	values.put(ATTR_USEYN,useYn);
 	 	values.put(ATTR_MNUEPLN,mnuEpln); 
// 	 	values.put(ATTR_MNUAUTHGRPSCNINPTYN , mnuAuthGrPScnInptYn); 
// 	 	values.put(ATTR_MNUAUTHGRPSCNREVNYN ,mnuAuthGrPScnRevnYn); 
// 	 	values.put(ATTR_MNUAUTHGRPSCNDELYN  , mnuAuthGrPScnDelYn);  
// 	 	values.put(ATTR_MNUAUTHGRPSCNINQYYN , mnuAuthGrPScnInqyYn); 
// 	 	values.put(ATTR_MNUAUTHGRPSCNPRTYN  , mnuAuthGrPScnPrtYn);
 	 	} 
  


    /** set 시스템구분코드 : sysDivCd */
    public void setSysDivCd(String  sysDivCd) { set( ATTR_SYSDIVCD ,sysDivCd);}
    /** get 시스템구분코드 : sysDivCd */
    public String  getSysDivCd() { return (String )get( ATTR_SYSDIVCD );}

    /** set 메뉴코드 : mnuCd */
    public void setMnuCd(String  mnuCd) { set( ATTR_MNUCD ,mnuCd);}
    /** get 메뉴코드 : mnuCd */
    public String  getMnuCd() { return (String )get( ATTR_MNUCD );}

    /** set 상위메뉴코드 : hhrkMnuCd */
    public void setHhrkMnuCd(String  hhrkMnuCd) { set( ATTR_HHRKMNUCD ,hhrkMnuCd);}
    /** get 상위메뉴코드 : hhrkMnuCd */
    public String  getHhrkMnuCd() { return (String )get( ATTR_HHRKMNUCD );}

    /** set 메뉴명 : mnuNm */
    public void setMnuNm(String  mnuNm) { set( ATTR_MNUNM ,mnuNm);}
    /** get 메뉴명 : mnuNm */
    public String  getMnuNm() { return (String )get( ATTR_MNUNM );}

    /** set 메뉴아이콘 : mnuIcn */
    public void setMnuIcn(String  mnuIcn) { set( ATTR_MNUICN ,mnuIcn);}
    /** get 메뉴아이콘 : mnuIcn */
    public String  getMnuIcn() { return (String )get( ATTR_MNUICN );}

    /** set 메뉴썸네일 : mnuTmbl */
    public void setMnuTmbl(String  mnuTmbl) { set( ATTR_MNUTMBL ,mnuTmbl);}
    /** get 메뉴썸네일 : mnuTmbl */
    public String  getMnuTmbl() { return (String )get( ATTR_MNUTMBL );}

    /** set 메뉴권한유형코드 : mnuAuthFrmCd */
    public void setMnuAuthFrmCd(String  mnuAuthFrmCd) { set( ATTR_MNUAUTHFRMCD ,mnuAuthFrmCd);}
    /** get 메뉴권한유형코드 : mnuAuthFrmCd */
    public String  getMnuAuthFrmCd() { return (String )get( ATTR_MNUAUTHFRMCD );}

    /** set 메뉴팁명 : mnuTipNm */
    public void setMnuTipNm(String  mnuTipNm) { set( ATTR_MNUTIPNM ,mnuTipNm);}
    /** get 메뉴팁명 : mnuTipNm */
    public String  getMnuTipNm() { return (String )get( ATTR_MNUTIPNM );}

    /** set 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
    public void setMnuScnFrmPkgNm(String  mnuScnFrmPkgNm) { set( ATTR_MNUSCNFRMPKGNM ,mnuScnFrmPkgNm);}
    /** get 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
    public String  getMnuScnFrmPkgNm() { return (String )get( ATTR_MNUSCNFRMPKGNM );}

    /** set 메뉴출력여부 : mnuPrntYn */
    public void setMnuPrntYn(String  mnuPrntYn) { set( ATTR_MNUPRNTYN ,mnuPrntYn);}
    /** get 메뉴출력여부 : mnuPrntYn */
    public String  getMnuPrntYn() { return (String )get( ATTR_MNUPRNTYN );}

    /** set 메뉴출력순서 : mnuPrntOrd */
    public void setMnuPrntOrd(String  mnuPrntOrd) { set( ATTR_MNUPRNTORD ,mnuPrntOrd);}
    /** get 메뉴출력순서 : mnuPrntOrd */
    public String  getMnuPrntOrd() { return (String )get( ATTR_MNUPRNTORD );}

    /** set 사용여부 : useYn */
    public void setUseYn(String  useYn) { set( ATTR_USEYN ,useYn);}
    /** get 사용여부 : useYn */
    public String  getUseYn() { return (String )get( ATTR_USEYN );}

    /** set 메뉴설명 : mnuEpln */
    public void setMnuEpln(String  mnuEpln) { set( ATTR_MNUEPLN ,mnuEpln);}
    /** get 메뉴설명 : mnuEpln */
    public String  getMnuEpln() { return (String )get( ATTR_MNUEPLN );}

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
 
	  
	public static final String ATTR_MNUAUTHGRPSCNINQYYN = "mnuAuthGrPScnInqyYn";

	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
	public static final String ATTR_MNUAUTHGRPSCNINPTYN = "mnuAuthGrPScnInptYn";

	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
	public static final String ATTR_MNUAUTHGRPSCNREVNYN = "mnuAuthGrPScnRevnYn";

	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
	public static final String ATTR_MNUAUTHGRPSCNDELYN = "mnuAuthGrPScnDelYn";

	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
	public static final String ATTR_MNUAUTHGRPSCNPRTYN = "mnuAuthGrPScnPrtYn";
    
	/** set 메뉴권한그룹화면조회여부 : mnuAuthGrPScnInqyYn */
//	public void setMnuAuthGrPScnInqyYn(Boolean  mnuAuthGrPScnInqyYn) { set( ATTR_MNUAUTHGRPSCNINQYYN ,mnuAuthGrPScnInqyYn);}
//	/** get 메뉴권한그룹화면조회여부 : mnuAuthGrPScnInqyYn */
//	public Boolean  getMnuAuthGrPScnInqyYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNINQYYN );}
//
//	/** set 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
//	public void setMnuAuthGrPScnInptYn(Boolean  mnuAuthGrPScnInptYn) { set( ATTR_MNUAUTHGRPSCNINPTYN ,mnuAuthGrPScnInptYn);}
//	/** get 메뉴권한그룹화면입력여부 : mnuAuthGrPScnInptYn */
//	public Boolean  getMnuAuthGrPScnInptYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNINPTYN );}
//
//	/** set 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
//	public void setMnuAuthGrPScnRevnYn(Boolean  mnuAuthGrPScnRevnYn) { set( ATTR_MNUAUTHGRPSCNREVNYN ,mnuAuthGrPScnRevnYn);}
//	/** get 메뉴권한그룹화면수정여부 : mnuAuthGrPScnRevnYn */
//	public Boolean  getMnuAuthGrPScnRevnYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNREVNYN );}
//
//	/** set 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
//	public void setMnuAuthGrPScnDelYn(Boolean  mnuAuthGrPScnDelYn) { set( ATTR_MNUAUTHGRPSCNDELYN ,mnuAuthGrPScnDelYn);}
//	/** get 메뉴권한그룹화면삭제여부 : mnuAuthGrPScnDelYn */
//	public Boolean  getMnuAuthGrPScnDelYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNDELYN );}
//
//	/** set 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
//	public void setMnuAuthGrPScnPrtYn(Boolean  mnuAuthGrPScnPrtYn) { set( ATTR_MNUAUTHGRPSCNPRTYN ,mnuAuthGrPScnPrtYn);}
//	/** get 메뉴권한그룹화면인쇄여부 : mnuAuthGrPScnPrtYn */
//	public Boolean  getMnuAuthGrPScnPrtYn() { return (Boolean )get( ATTR_MNUAUTHGRPSCNPRTYN );}
	

//    private TextField<String> sysDivCd   /** column 시스템구분코드 : sysDivCd */
//
//    private TextField<String> mnuCd   /** column 메뉴코드 : mnuCd */
//
//    private TextField<String> hhrkMnuCd   /** column 상위메뉴코드 : hhrkMnuCd */
//
//    private TextField<String> mnuNm   /** column 메뉴명 : mnuNm */
//
//    private TextField<String> mnuIcn   /** column 메뉴아이콘 : mnuIcn */
//
//    private TextField<String> mnuTmbl   /** column 메뉴썸네일 : mnuTmbl */
//
//    private TextField<String> mnuAuthFrmCd   /** column 메뉴권한유형코드 : mnuAuthFrmCd */
//
//    private TextField<String> mnuTipNm   /** column 메뉴팁명 : mnuTipNm */
//
//    private TextField<String> mnuScnFrmPkgNm   /** column 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
//
//    private TextField<String> mnuPrntYn   /** column 메뉴출력여부 : mnuPrntYn */
//
//    private TextField<String> mnuPrntOrd   /** column 메뉴출력순서 : mnuPrntOrd */
//
//    private TextField<String> useYn   /** column 사용여부 : useYn */
//
//    private TextField<String> mnuEpln   /** column 메뉴설명 : mnuEpln */
//
//    private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//    private TextField<String> ismt   /** column 수정자 : ismt */
//
//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
//
//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//    /** set 시스템구분코드 : sysDivCd */
//    private java.lang.String sysDivCd;
//
//    /** set 메뉴코드 : mnuCd */
//    private java.lang.String mnuCd;
//
//    /** set 상위메뉴코드 : hhrkMnuCd */
//    private java.lang.String hhrkMnuCd;
//
//    /** set 메뉴명 : mnuNm */
//    private java.lang.String mnuNm;
//
//    /** set 메뉴아이콘 : mnuIcn */
//    private java.lang.String mnuIcn;
//
//    /** set 메뉴썸네일 : mnuTmbl */
//    private java.lang.String mnuTmbl;
//
//    /** set 메뉴권한유형코드 : mnuAuthFrmCd */
//    private java.lang.String mnuAuthFrmCd;
//
//    /** set 메뉴팁명 : mnuTipNm */
//    private java.lang.String mnuTipNm;
//
//    /** set 메뉴화면폼패키지명 : mnuScnFrmPkgNm */
//    private java.lang.String mnuScnFrmPkgNm;
//
//    /** set 메뉴출력여부 : mnuPrntYn */
//    private java.lang.String mnuPrntYn;
//
//    /** set 메뉴출력순서 : mnuPrntOrd */
//    private Long mnuPrntOrd;
//
//    /** set 사용여부 : useYn */
//    private java.lang.String useYn;
//
//    /** set 메뉴설명 : mnuEpln */
//    private java.lang.String mnuEpln;
//
//    /** set 입력자 : kybdr */
//    private java.lang.String kybdr;
//
//    /** set 입력일자 : inptDt */
//    private java.lang.String inptDt;
//
//    /** set 수정자 : ismt */
//    private java.lang.String ismt;
//
//    /** set 수정일자 : revnDt */
//    private java.lang.String revnDt;
//
//    /** set 수정주소 : revnAddr */
//    private java.lang.String revnAddr;
//
//    /** set 입력주소 : inptAddr */
//    private java.lang.String inptAddr;
//
//
//    
}
