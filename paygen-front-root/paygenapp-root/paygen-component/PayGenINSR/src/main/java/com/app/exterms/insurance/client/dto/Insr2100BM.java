package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr2100VO.java
 * @Description : Insr2100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public static final String ATTR_SOCTYINSURCMPTNDT = "soctyInsurCmptnDt";

	/** set 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public static final String ATTR_SOCINSRLSSEMYMTNUM = "socInsrLssEmymtNum";

	/** set 사회보험가입자전화번호 : socInsrMbrPhnNum */
	public static final String ATTR_SOCINSRMBRPHNNUM = "socInsrMbrPhnNum";

	/** set 건강보험신고여부 : hlthInsrRegrstYn */
	public static final String ATTR_HLTHINSRREGRSTYN = "hlthInsrRegrstYn";

	/** set 국민연금신고여부 : natPennRegrstYn */
	public static final String ATTR_NATPENNREGRSTYN = "natPennRegrstYn";

	/** set 고용보험신고여부 : umytInsrRegrstYn */
	public static final String ATTR_UMYTINSRREGRSTYN = "umytInsrRegrstYn";

	/** set 산재보험신고여부 : idtlAccdtRegrstYn */
	public static final String ATTR_IDTLACCDTREGRSTYN = "idtlAccdtRegrstYn";

	/** set 사회보험상실일자 : soctyInsurLssDt */
	public static final String ATTR_SOCTYINSURLSSDT = "soctyInsurLssDt";

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
	
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
	 
    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
 

    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";

 
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 원본 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";	

	/** 생성자 */
	 public Insr2100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr2100BM(
			 String  dpobCd 
			, String  systemkey 
			, String  soctyInsurCmptnDt 
			, Long  socInsrLssEmymtNum 
			, String  socInsrMbrPhnNum 
			, String  hlthInsrRegrstYn 
			, String  natPennRegrstYn 
			, String  umytInsrRegrstYn 
			, String  idtlAccdtRegrstYn 
			, String  soctyInsurLssDt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_SOCTYINSURCMPTNDT,soctyInsurCmptnDt);
	 	values.put(ATTR_SOCINSRLSSEMYMTNUM,socInsrLssEmymtNum);
	 	values.put(ATTR_SOCINSRMBRPHNNUM,socInsrMbrPhnNum);
	 	values.put(ATTR_HLTHINSRREGRSTYN,hlthInsrRegrstYn);
	 	values.put(ATTR_NATPENNREGRSTYN,natPennRegrstYn);
	 	values.put(ATTR_UMYTINSRREGRSTYN,umytInsrRegrstYn);
	 	values.put(ATTR_IDTLACCDTREGRSTYN,idtlAccdtRegrstYn);
	 	values.put(ATTR_SOCTYINSURLSSDT,soctyInsurLssDt);
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

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public void setSoctyInsurCmptnDt(String  soctyInsurCmptnDt) { set( ATTR_SOCTYINSURCMPTNDT ,soctyInsurCmptnDt);}
	/** get 사회보험작성일자 : soctyInsurCmptnDt */
	public String  getSoctyInsurCmptnDt() { return (String )get( ATTR_SOCTYINSURCMPTNDT );}

	/** set 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public void setSocInsrLssEmymtNum(Long  socInsrLssEmymtNum) { set( ATTR_SOCINSRLSSEMYMTNUM ,socInsrLssEmymtNum);}
	/** get 사회보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public Long  getSocInsrLssEmymtNum() { return (Long )get( ATTR_SOCINSRLSSEMYMTNUM );}

	/** set 사회보험가입자전화번호 : socInsrMbrPhnNum */
	public void setSocInsrMbrPhnNum(String  socInsrMbrPhnNum) { set( ATTR_SOCINSRMBRPHNNUM ,socInsrMbrPhnNum);}
	/** get 사회보험가입자전화번호 : socInsrMbrPhnNum */
	public String  getSocInsrMbrPhnNum() { return (String )get( ATTR_SOCINSRMBRPHNNUM );}

	/** set 건강보험신고여부 : hlthInsrRegrstYn */
	public void setHlthInsrRegrstYn(String  hlthInsrRegrstYn) { set( ATTR_HLTHINSRREGRSTYN ,hlthInsrRegrstYn);}
	/** get 건강보험신고여부 : hlthInsrRegrstYn */
	public String  getHlthInsrRegrstYn() { return (String )get( ATTR_HLTHINSRREGRSTYN );}

	/** set 국민연금신고여부 : natPennRegrstYn */
	public void setNatPennRegrstYn(String  natPennRegrstYn) { set( ATTR_NATPENNREGRSTYN ,natPennRegrstYn);}
	/** get 국민연금신고여부 : natPennRegrstYn */
	public String  getNatPennRegrstYn() { return (String )get( ATTR_NATPENNREGRSTYN );}

	/** set 고용보험신고여부 : umytInsrRegrstYn */
	public void setUmytInsrRegrstYn(String  umytInsrRegrstYn) { set( ATTR_UMYTINSRREGRSTYN ,umytInsrRegrstYn);}
	/** get 고용보험신고여부 : umytInsrRegrstYn */
	public String  getUmytInsrRegrstYn() { return (String )get( ATTR_UMYTINSRREGRSTYN );}

	/** set 산재보험신고여부 : idtlAccdtRegrstYn */
	public void setIdtlAccdtRegrstYn(String  idtlAccdtRegrstYn) { set( ATTR_IDTLACCDTREGRSTYN ,idtlAccdtRegrstYn);}
	/** get 산재보험신고여부 : idtlAccdtRegrstYn */
	public String  getIdtlAccdtRegrstYn() { return (String )get( ATTR_IDTLACCDTREGRSTYN );}

	/** set 사회보험상실일자 : soctyInsurLssDt */
	public void setSoctyInsurLssDt(String  soctyInsurLssDt) { set( ATTR_SOCTYINSURLSSDT ,soctyInsurLssDt);}
	/** get 사회보험상실일자 : soctyInsurLssDt */
	public String  getSoctyInsurLssDt() { return (String )get( ATTR_SOCTYINSURLSSDT );}

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
	
 /** set 고용구분 : emymtDivNm */
  public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
  /** get 고용구분 : emymtDivNm */
  public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

  
  /** set 부서 : deptNm */
  public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
  /** get 부서 : deptNm  */
  public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

  /** set 사업 : businNm */
  public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
  /** get 사업 : businNm */
  public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}

  /** set 직종 : typOccuNm */
  public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
  /** get 직종 : typOccuNm */
  public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

  /** set 직종세 : dtilOccuClsDivNm */
  public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
  /** get 직종세 : dtilOccuClsDivNm */
  public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}

  /** set 직책 : odtyNm */
  public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
  /** get 직책 : odtyNm */
  public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}

  
  /** set 호봉등급 : pyspGrdeNm */
  public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
  /** get 호봉등급 : pyspGrdeNm */
  public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
  
  /** set 한글성명 : hanNm */
  public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
  /** get 한글성명 : hanNm */
  public String  getHanNm() { return (String )get( ATTR_HANNM );}

  /** set 주민등록번호 : resnRegnNum */
  public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
  /** get 주민등록번호 : resnRegnNum */
  public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
  

  /** set 고용구분코드 : emymtDivCd */
  public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
  /** get 고용구분코드 : emymtDivCd */
  public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

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

  /** set 주민등록번호 : secRegnNum */
  public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
  /** get 주민등록번호 : secRegnNum */
  public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
  
  /** set 호봉등급코드 : pyspGrdeCd */
  public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
  /** get 호봉등급코드 : pyspGrdeCd */
  public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
}
