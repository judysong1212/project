package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0126VO.java
 * @Description : Psnl0126 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0126BM  extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;

    /** 사업장 코드 DPOB_CD */
    public static final String ATTR_DPOBCD = "dpobCd";
    
	/** 시스템키 SYSTEMKEY */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    
    /** 휴가적용년도 HODY_APPTN_YR */
    public static final String ATTR_HODYAPPTNYR = "hodyApptnYr";
    
    /** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
    public static final String ATTR_HODYNUMDYSSYSCALC = "hodyNumDysSysCalc";
    
    /** 휴가적용일수 HODY_APPTN_NUM_DYS */
    public static final String ATTR_HODYAPPTNNUMDYS = "hodyApptnNumDys";
    
    /** 휴가사용일수 HODY_USE_NUM_DYS */
    public static final String ATTR_HODYUSENUMDYS = "hodyUseNumDys";
    
    /** 특별휴가사용일수 spclHodyUseDys */
    public static final String ATTR_SPCLHODYUSEDYS = "spclHodyUseDys";
    
    /** 휴가잔여일수 HODY_RST_NUM_DYS */
    public static final String ATTR_HODYRSTNUMDYS = "hodyRstNumDys";
    
    /** 휴가시작일자 HODY_BGNN_DT */
    public static final String ATTR_HODYBGNNDT = "hodyBgnnDt";
    
    /** 휴가종료일자 HODY_END_DT */
    public static final String ATTR_HODYENDDT = "hodyEndDt";
    
    /** 휴가비고내용 HODY_NOTE_CTNT */
    public static final String ATTR_HODYNOTECTNT = "hodyNoteCtnt";
    
    /** 휴가확정여부 HODY_FIX_YN */
    public static final String ATTR_HODYFIXYN = "hodyFixYn";
    
    /** 마감 날짜 HODY_FIX_DT */
    public static final String ATTR_HODYFIXDT = "hodyFixDt";
    
    /** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
    public static final String ATTR_LVSGCOPTNCSTAPPTNYN = "lvsgCoptnCstApptnYn";
    
    /** 연가보상비적용일자 LVSG_COPTN_CST_APPTN_DT */
    public static final String ATTR_LVSGCOPTNCSTAPPTNDT = "lvsgCoptnCstApptnDt";
    
    /** 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";
    
    /** set 특별휴가일수 : spclHodyNumDys */
    public static final String ATTR_SPCLHODYNUMDYS = "spclHodyNumDys";
    
    /** set 대상자 존재여부 : hodyFixYn */
    public static final String ATTR_HODYNUMDYSSYSYN = "hodyNumDysSysYn";
 

    /** 생성자 */
    public Psnl0126BM() { super(); } 

   /** 일괄등록 처리   */
    public Psnl0126BM(
   		 String  dpobCd 
   		, String  systemkey 
   		, String  hodyApptnYr 
   		, String  hodyNumDysSysCalc 
   		, String  hodyApptnNumDys 
   		, String  hodyUseNumDys 
   		, String  hodyRstNumDys 
   		, String  hodyBgnnDt 
   		, String  hodyEndDt 
   		, String  hodyNoteCtnt 
   		, String  hodyFixYn 
   		, String  lvsgCoptnCstApptnYn 
   		, String  lvsgCoptnCstApptnDt 
   		, String  kybdr 
   		, String  inptDt 
   		, String  inptAddr 
   		, String  ismt 
   		, String  revnDt 
   		, String  revnAddr
   		, String  chnNumDys
   		, String  yoobhMnthDay
   		, String  hodyNumDysSysYn) { 
    	values.put(ATTR_DPOBCD,dpobCd);
    	values.put(ATTR_SYSTEMKEY,systemkey);
    	values.put(ATTR_HODYAPPTNYR,hodyApptnYr);
    	values.put(ATTR_HODYNUMDYSSYSCALC,hodyNumDysSysCalc);
    	values.put(ATTR_HODYAPPTNNUMDYS,hodyApptnNumDys); 
    	values.put(ATTR_HODYUSENUMDYS,hodyUseNumDys);
    	values.put(ATTR_HODYRSTNUMDYS,hodyRstNumDys);
    	values.put(ATTR_HODYBGNNDT,hodyBgnnDt);
    	values.put(ATTR_HODYENDDT,hodyEndDt);
    	values.put(ATTR_HODYNOTECTNT,hodyNoteCtnt);
    	values.put(ATTR_HODYFIXYN,hodyFixYn);
    	values.put(ATTR_LVSGCOPTNCSTAPPTNYN,lvsgCoptnCstApptnYn);
    	values.put(ATTR_LVSGCOPTNCSTAPPTNDT,lvsgCoptnCstApptnDt);
    	values.put(ATTR_KYBDR,kybdr);
    	values.put(ATTR_INPTDT,inptDt);
    	values.put(ATTR_INPTADDR,inptAddr);
    	values.put(ATTR_ISMT,ismt);
    	values.put(ATTR_REVNDT,revnDt);
    	values.put(ATTR_REVNADDR,revnAddr);
    	values.put(ATTR_CHNNUMDYS,chnNumDys);
    	values.put(ATTR_YOOBHMNTHDAY,yoobhMnthDay);
    	values.put(ATTR_HODYNUMDYSSYSYN,hodyNumDysSysYn);} 

   /** set 사업장코드 : dpobCd */
   public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
   /** get 사업장코드 : dpobCd */
   public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

   /** set SYSTEMKEY : systemkey */
   public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
   /** get SYSTEMKEY : systemkey */
   public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

   /** set 휴가적용년도 : hodyApptnYr */
   public void setHodyApptnYr(String  hodyApptnYr) { set( ATTR_HODYAPPTNYR ,hodyApptnYr);}
   /** get 휴가적용년도 : hodyApptnYr */
   public String  getHodyApptnYr() { return (String )get( ATTR_HODYAPPTNYR );}

   /** set 휴가일수_시스템계산 : hodyNumDysSysCalc */
   public void setHodyNumDysSysCalc(String  hodyNumDysSysCalc) { set( ATTR_HODYNUMDYSSYSCALC ,hodyNumDysSysCalc);}
   /** get 휴가일수_시스템계산 : hodyNumDysSysCalc */
   public String  getHodyNumDysSysCalc() { return (String )get( ATTR_HODYNUMDYSSYSCALC );}

   /** set 휴가적용일수 : hodyApptnNumDys */
   public void setHodyApptnNumDys(String  hodyApptnNumDys) { set(ATTR_HODYAPPTNNUMDYS, hodyApptnNumDys);}
   /** get 휴가적용일수 : hodyApptnNumDys */
   public String  getHodyApptnNumDys() { return (String)get( ATTR_HODYAPPTNNUMDYS );}

   /** set 휴가사용일수 : hodyUseNumDys */
   public void setHodyUseNumDys(String  hodyUseNumDys) { set( ATTR_HODYUSENUMDYS ,hodyUseNumDys);}
   /** get 휴가사용일수 : hodyUseNumDys */
   public String  getHodyUseNumDys() { return (String )get( ATTR_HODYUSENUMDYS );}
   
   /** set 특별휴가사용일수 : spclHodyUseDys */
   public void setSpclHodyUseDys(String  spclHodyUseDys) { set( ATTR_SPCLHODYUSEDYS ,spclHodyUseDys);}
   /** get 특별휴가사용일수 : spclHodyUseDys */
   public String  getSpclHodyUseDys() { return (String )get( ATTR_SPCLHODYUSEDYS );}
   
   /** set 휴가잔여일수 : hodyRstNumDys */
   public void setHodyRstNumDys(String  hodyRstNumDys) { set( ATTR_HODYRSTNUMDYS ,hodyRstNumDys);}
   /** get 휴가잔여일수 : hodyRstNumDys */
   public String  getHodyRstNumDys() { return (String )get( ATTR_HODYRSTNUMDYS );}

   /** set 휴가시작일자 : hodyBgnnDt */
   public void setHodyBgnnDt(String  hodyBgnnDt) { set( ATTR_HODYBGNNDT ,hodyBgnnDt);}
   /** get 휴가시작일자 : hodyBgnnDt */
   public String  getHodyBgnnDt() { return (String )get( ATTR_HODYBGNNDT );}

   /** set 휴가종료일자 : hodyEndDt */
   public void setHodyEndDt(String  hodyEndDt) { set( ATTR_HODYENDDT ,hodyEndDt);}
   /** get 휴가종료일자 : hodyEndDt */
   public String  getHodyEndDt() { return (String )get( ATTR_HODYENDDT );}

   /** set 휴가비고내용 : hodyNoteCtnt */
   public void setHodyNoteCtnt(String  hodyNoteCtnt) { set( ATTR_HODYNOTECTNT ,hodyNoteCtnt);}
   /** get 휴가비고내용 : hodyNoteCtnt */
   public String  getHodyNoteCtnt() { return (String )get( ATTR_HODYNOTECTNT );}

   /** set 휴가확정여부 : hodyFixYn */
   public void setHodyFixYn(String  hodyFixYn) { set( ATTR_HODYFIXYN ,hodyFixYn);}
   /** get 휴가확정여부 : hodyFixYn */
   public String  getHodyFixYn() { return (String )get( ATTR_HODYFIXYN );}
   
   /** set 휴가확정일자 : hodyFixDt */
   public void setHodyFixDt(String  hodyFixDt) { set( ATTR_HODYFIXDT ,hodyFixDt);}
   /** get 휴가확정일자 : hodyFixDt */
   public String  getHodyFixDt() { return (String )get( ATTR_HODYFIXDT );}

   /** set 연가보상비적용여부 : lvsgCoptnCstApptnYn */
   public void setLvsgCoptnCstApptnYn(String  lvsgCoptnCstApptnYn) { set( ATTR_LVSGCOPTNCSTAPPTNYN ,lvsgCoptnCstApptnYn);}
   /** get 연가보상비적용여부 : lvsgCoptnCstApptnYn */
   public String  getLvsgCoptnCstApptnYn() { return (String )get( ATTR_LVSGCOPTNCSTAPPTNYN );}

   /** set 연가보상비적용일자 : lvsgCoptnCstApptnDt */
   public void setLvsgCoptnCstApptnDt(String  lvsgCoptnCstApptnDt) { set( ATTR_LVSGCOPTNCSTAPPTNDT ,lvsgCoptnCstApptnDt);}
   /** get 연가보상비적용일자 : lvsgCoptnCstApptnDt */
   public String  getLvsgCoptnCstApptnDt() { return (String )get( ATTR_LVSGCOPTNCSTAPPTNDT );}

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
   
   /** set 특별휴가일수 : spclHodyNumDys */
   public void setSpclHodyNumDys(String  spclHodyNumDys) { set( ATTR_SPCLHODYNUMDYS ,spclHodyNumDys);}
   /** get 특별휴가일수 : spclHodyNumDys */
   public String  getSpclHodyNumDys() { return (String )get( ATTR_SPCLHODYNUMDYS );}
   
   /** set 대상자 존재여부 : hodyNumDysSysYn */
   public void setHodyNumDysSysYn(String  hodyNumDysSysYn) { set( ATTR_HODYNUMDYSSYSYN ,hodyNumDysSysYn);}
   /** get 대상자 존재여부 : hodyNumDysSysYn */
   public String  getHodyNumDysSysYn() { return (String )get( ATTR_HODYNUMDYSSYSYN );}
     
   
   //-------PSNL0100
   
   /** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";
	
	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
    /** set 생년월일 : yoobhMnthDay */
    public static final String ATTR_YOOBHMNTHDAY = "yoobhMnthDay";
    
    /** set 조정일수 : chnNumDys */
    public static final String ATTR_CHNNUMDYS = "chnNumDys";
    
    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";
   
	/** set 현소속부서코드 : currAffnDeptCd */
	public static final String ATTR_CURRAFFNDEPTCD = "currAffnDeptCd";
	
	/** set 현소속부서명 : currAffnDeptNm */
	public static final String ATTR_CURRAFFNDEPTNM = "currAffnDeptNm";

	/** set 사업명 : businNm */
   public static final String ATTR_BUSINNM = "businNm";
   
   /** set 직종명 : typOccuNm */
   public static final String ATTR_TYPOCCUNM = "typOccuNm";
   
   /** set 직종세명 : dtilOccuClsDivNm */
   public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
   
   /** set 직종세통합코드명 : dtilOccuInttnNm */
   public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";
   
   /** set 근속년수코드 : logSvcYrNumCd */
	public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

	/** set 근속월수코드 : logSvcMnthIcmCd */
	public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";
	
	/** set 근속년수 : logSvcYrNumNm */
	public static final String ATTR_LOGSVCYRNUMNM = "logSvcYrNumNm";

	/** set 근속월수 : logSvcMnthNm */
	public static final String ATTR_LOGSVCMNTHNM = "logSvcMnthNm";
	
    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
	
   
   /** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}
   
   /** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	
	 /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    /** set 생년월일 : yoobhMnthDay */
    public void setYoobhMnthDay(String  yoobhMnthDay) { set( ATTR_YOOBHMNTHDAY ,yoobhMnthDay);}
    /** get 생년월일 : yoobhMnthDay */
    public String  getYoobhMnthDay() { return (String )get( ATTR_YOOBHMNTHDAY );}
    
    /** set 조정일수 : chnNumDys */
    public void setChnNumDys(String  chnNumDys) { set( ATTR_CHNNUMDYS ,chnNumDys);}
    /** set 조정일수 : chnNumDys */
    public String  getChnNumDys() { return (String )get( ATTR_CHNNUMDYS );}
    
	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";

	/** set 사업코드 : businCd */
	public static final String ATTR_BUSINCD = "businCd";

	/** set 직종코드 : typOccuCd */
	public static final String ATTR_TYPOCCUCD = "typOccuCd";
	
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
	
	
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

   /** set 부서 : deptNm */
  	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
   /** get 부서 : deptNm */
   public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
      
      /** set 사업명 : businNm */
  	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
      /** set 사업명 : businNm */
  	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
      
      /** set 직종명 : typOccuNm */
  	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
      /** set 직종명 : typOccuNm */
  	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
      
      /** set 직종세 : dtilOccuClsDivNm */
  	public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
      /** set 직종세 : dtilOccuClsDivNm */
  	public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
  	
    /** set 직종세통합코드명 : dtilOccuInttnNm */
	public void setDtilOccuInttnNm(String  dtilOccuInttnNm) { set( ATTR_DTILOCCUINTTNNM ,dtilOccuInttnNm);}
    /** set 직종세통합코드명 : dtilOccuClsDivNm */
	public String  getDtilOccuInttnNm() { return (String )get( ATTR_DTILOCCUINTTNNM );}
  	
  	/** set 근속년수코드 : logSvcYrNumCd */
	public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
	/** get 근속년수코드 : logSvcYrNumCd */
	public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}

	/** set 근속월수코드 : logSvcMnthIcmCd */
	public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOGSVCMNTHICMCD ,logSvcMnthIcmCd);}
	/** get 근속월수코드 : logSvcMnthIcmCd */
	public String  getLogSvcMnthIcmCd() { return (String )get( ATTR_LOGSVCMNTHICMCD );}
	
	/** set 근속년수 : logSvcYrNumCd */
	public void setLogSvcYrNumNm(String  logSvcYrNumNm) { set( ATTR_LOGSVCYRNUMNM ,logSvcYrNumNm);}
	/** get 근속년수 : logSvcYrNumCd */
	public String  getLogSvcYrNumNm() { return (String )get( ATTR_LOGSVCYRNUMNM );}

	/** set 근속월수 : logSvcMnthIcmCd */
	public void setLogSvcMnthNm(String  logSvcMnthNm) { set( ATTR_LOGSVCMNTHNM ,logSvcMnthNm);}
	/** get 근속월수 : logSvcMnthIcmCd */
	public String  getLogSvcMnthNm() { return (String )get( ATTR_LOGSVCMNTHNM );}
	
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    
	/** set 현소속부서코드 : currAffnDeptCd */
	public void setCurrAffnDeptCd(String  currAffnDeptCd) { set( ATTR_CURRAFFNDEPTCD ,currAffnDeptCd);}
	/** get 현소속부서코드 : currAffnDeptCd */
	public String  getCurrAffnDeptCd() { return (String )get( ATTR_CURRAFFNDEPTCD );}
	
	/** set 현소속부서코드 : currAffnDeptNm */
	public void setCurrAffnDeptNm(String  currAffnDeptNm) { set( ATTR_CURRAFFNDEPTNM ,currAffnDeptNm);}
	/** get 현소속부서코드 : currAffnDeptNm */
	public String  getCurrAffnDeptNm() { return (String )get( ATTR_CURRAFFNDEPTNM );}
  	
    
}
