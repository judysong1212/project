package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass5100VO.java
 * @Description : Bass5100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass5100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public static final String ATTR_SOCTYINSURCMPTNDT = "soctyInsurCmptnDt";

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public static final String ATTR_SOCINSRAQTNEMYMTNUM = "socInsrAqtnEmymtNum";

	/** set 국적코드 : natnCd */
	public static final String ATTR_NATNCD = "natnCd";

	/** set 사회보험대표자여부 : socInsrDegtrYn */
	public static final String ATTR_SOCINSRDEGTRYN = "socInsrDegtrYn";

	/** set 사회보험체류자격코드 : socInsrStyQftntCd */
	public static final String ATTR_SOCINSRSTYQFTNTCD = "socInsrStyQftntCd";
	
	/** column 피부양자여부 : insr1400Yn */
	public static final String ATTR_INSR1400YN = "insr1400Yn";
	
	/** column 피부양자여부 : insr1500Yn */
	public static final String ATTR_INSR1500YN = "insr1500Yn";
	 

	/** set 건강보험신고여부 : hlthInsrRegrstYn */
	public static final String ATTR_HLTHINSRREGRSTYN = "hlthInsrRegrstYn";

	/** set 국민연금신고여부 : natPennRegrstYn */
	public static final String ATTR_NATPENNREGRSTYN = "natPennRegrstYn";

	/** set 고용보험신고여부 : umytInsrRegrstYn */
	public static final String ATTR_UMYTINSRREGRSTYN = "umytInsrRegrstYn";

	/** set 산재보험신고여부 : idtlAccdtRegrstYn */
	public static final String ATTR_IDTLACCDTREGRSTYN = "idtlAccdtRegrstYn";

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
	
	
	/** set 국민_보수월액 : natPennIncome */
	public static final String ATTR_NATPENNINCOME = "natPennIncome";
	/** set 국민_보험료 : natPennPremium */
	public static final String ATTR_NATPENNPREMIUM = "natPennPremium";
	/** set 건강_보수월액 : hlthInsrIncome */
	public static final String ATTR_HLTHINSRINCOME = "hlthInsrIncome";
	/** set 건강_보험료 : hlthInsrPremium */
	public static final String ATTR_HLTHINSRPREMIUM = "hlthInsrPremium";
	/** set 고용_보수월액 : umytInsrIncome */
	public static final String ATTR_UMYTINSRINCOME = "umytInsrIncome";
	/** set 고용_보험료 : umytInsrPremium */
	public static final String ATTR_UMYTINSRPREMIUM = "umytInsrPremium";
	/** set 산재_보수월액 : idtlAccdtIncome */
	public static final String ATTR_IDTLACCDTINCOME = "idtlAccdtIncome";
	/** set 산재_보험료 : idtlAccdtPremium */
	public static final String ATTR_IDTLACCDTPREMIUM = "idtlAccdtPremium";
	
	/** set 국민_본인부담 요율 : natPennHmlfBrdnApmrt */
	public static final String ATTR_NATPENNHMLFBRDNAPMRT = "natPennHmlfBrdnApmrt";
	/** set 건강_본인부담 요율 : hlthInsrHmlfBrdnApmrt */
	public static final String ATTR_HLTHINSRHMLFBRDNAPMRT = "hlthInsrHmlfBrdnApmrt";
	/** set 고용_본인부담 요율 : umytInsrHmlfBrdnApmrt */
	public static final String ATTR_UMYTINSRHMLFBRDNAPMRT = "umytInsrHmlfBrdnApmrt";
	/** set 산재_본인부담 요율 : idtlInsrHmlfBrdnApmrt */
	public static final String ATTR_IDTLINSRHMLFBRDNAPMRT = "idtlInsrHmlfBrdnApmrt";
	 
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
    
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
    /** set 핸드폰번호 : cellPhneNum */
    public static final String ATTR_CELLPHNENUM = "cellPhneNum";
    
    

	/** 생성자 */
	 public Bass5100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Bass5100BM(
			 String  dpobCd 
			, String  systemkey 
			, String  soctyInsurCmptnDt 
			, Long  socInsrAqtnEmymtNum 
			, String  natnCd 
			, String  socInsrDegtrYn 
			, String  socInsrStyQftntCd 
			, String  hlthInsrRegrstYn 
			, String  natPennRegrstYn 
			, String  umytInsrRegrstYn 
			, String  idtlAccdtRegrstYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr
			, String  natPennIncome
			, String  natPennPremium
			, String  hlthInsrIncome
			, String  hlthInsrPremium
			, String  umytInsrIncome
			, String  umytInsrPremium
			, String  idtlAccdtIncome
			, String  idtlAccdtPremium
			) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_SOCTYINSURCMPTNDT,soctyInsurCmptnDt);
	 	values.put(ATTR_SOCINSRAQTNEMYMTNUM,socInsrAqtnEmymtNum);
	 	values.put(ATTR_NATNCD,natnCd);
	 	values.put(ATTR_SOCINSRDEGTRYN,socInsrDegtrYn);
	 	values.put(ATTR_SOCINSRSTYQFTNTCD,socInsrStyQftntCd);
	 	values.put(ATTR_HLTHINSRREGRSTYN,hlthInsrRegrstYn);
	 	values.put(ATTR_NATPENNREGRSTYN,natPennRegrstYn);
	 	values.put(ATTR_UMYTINSRREGRSTYN,umytInsrRegrstYn);
	 	values.put(ATTR_IDTLACCDTREGRSTYN,idtlAccdtRegrstYn);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr); 
	 	values.put(ATTR_NATPENNINCOME,natPennIncome);
	 	values.put(ATTR_NATPENNPREMIUM,natPennPremium);
	 	values.put(ATTR_HLTHINSRINCOME,hlthInsrIncome);
	 	values.put(ATTR_HLTHINSRPREMIUM,hlthInsrPremium);
	 	values.put(ATTR_UMYTINSRINCOME,umytInsrIncome);
	 	values.put(ATTR_UMYTINSRPREMIUM,umytInsrPremium);
	 	values.put(ATTR_IDTLACCDTINCOME,idtlAccdtIncome);
	 	values.put(ATTR_IDTLACCDTPREMIUM,idtlAccdtPremium);
	 } 

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

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public void setSocInsrAqtnEmymtNum(Long  socInsrAqtnEmymtNum) { set( ATTR_SOCINSRAQTNEMYMTNUM ,socInsrAqtnEmymtNum);}
	/** get 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public Long  getSocInsrAqtnEmymtNum() { return (Long )get( ATTR_SOCINSRAQTNEMYMTNUM );}

	/** set 국적코드 : natnCd */
	public void setNatnCd(String  natnCd) { set( ATTR_NATNCD ,natnCd);}
	/** get 국적코드 : natnCd */
	public String  getNatnCd() { return (String )get( ATTR_NATNCD );}

	/** set 사회보험대표자여부 : socInsrDegtrYn */
	public void setSocInsrDegtrYn(String  socInsrDegtrYn) { set( ATTR_SOCINSRDEGTRYN ,socInsrDegtrYn);}
	/** get 사회보험대표자여부 : socInsrDegtrYn */
	public String  getSocInsrDegtrYn() { return (String )get( ATTR_SOCINSRDEGTRYN );}

	/** set 사회보험체류자격코드 : socInsrStyQftntCd */
	public void setSocInsrStyQftntCd(String  socInsrStyQftntCd) { set( ATTR_SOCINSRSTYQFTNTCD ,socInsrStyQftntCd);}
	/** get 사회보험체류자격코드 : socInsrStyQftntCd */
	public String  getSocInsrStyQftntCd() { return (String )get( ATTR_SOCINSRSTYQFTNTCD );}
 
	/** set 피부양자여부 : insr1400Yn */
	public void setInsr1400Yn(Boolean  insr1400Yn) { set( ATTR_INSR1400YN ,insr1400Yn);}
	/** get 피부양자여부 : insr1400Yn */
	public Boolean  getInsr1400Yn() { return (Boolean )get( ATTR_INSR1400YN );}
	
	/** set 피부양자여부 : insr1500Yn */
	public void setInsr1500Yn(Boolean  insr1500Yn) { set( ATTR_INSR1500YN ,insr1500Yn);}
	/** get 피부양자여부 : insr1400Yn */
	public Boolean  getInsr1500Yn() { return (Boolean )get( ATTR_INSR1500YN );}
 
	
	/** set 건강보험신고여부 : hlthInsrRegrstYn */
	public void setHlthInsrRegrstYn(Boolean  hlthInsrRegrstYn) { set( ATTR_HLTHINSRREGRSTYN ,hlthInsrRegrstYn);}
	/** get 건강보험신고여부 : hlthInsrRegrstYn */
	public Boolean  getHlthInsrRegrstYn() { return (Boolean )get( ATTR_HLTHINSRREGRSTYN );}

	/** set 국민연금신고여부 : natPennRegrstYn */
	public void setNatPennRegrstYn(Boolean  natPennRegrstYn) { set( ATTR_NATPENNREGRSTYN ,natPennRegrstYn);}
	/** get 국민연금신고여부 : natPennRegrstYn */
	public Boolean  getNatPennRegrstYn() { return (Boolean )get( ATTR_NATPENNREGRSTYN );}

	/** set 고용보험신고여부 : umytInsrRegrstYn */
	public void setUmytInsrRegrstYn(Boolean  umytInsrRegrstYn) { set( ATTR_UMYTINSRREGRSTYN ,umytInsrRegrstYn);}
	/** get 고용보험신고여부 : umytInsrRegrstYn */
	public Boolean  getUmytInsrRegrstYn() { return (Boolean )get( ATTR_UMYTINSRREGRSTYN );}

	/** set 산재보험신고여부 : idtlAccdtRegrstYn */
	public void setIdtlAccdtRegrstYn(Boolean  idtlAccdtRegrstYn) { set( ATTR_IDTLACCDTREGRSTYN ,idtlAccdtRegrstYn);}
	/** get 산재보험신고여부 : idtlAccdtRegrstYn */
	public Boolean  getIdtlAccdtRegrstYn() { return (Boolean )get( ATTR_IDTLACCDTREGRSTYN );}

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
  
  /** set 핸드폰번호 : cellPhneNum */
  public void setCellPhneNum(String  cellPhneNum) { set( ATTR_CELLPHNENUM ,cellPhneNum);}
  /** get 핸드폰번호 : cellPhneNum */
  public String  getCellPhneNum() { return (String )get( ATTR_CELLPHNENUM );}
  
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



  /** set 호봉등급코드 : pyspGrdeCd */
  public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
  /** get 호봉등급코드 : pyspGrdeCd */
  public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
  
  
  	/** set 국민_보수월액 : natPennIncome */
	public void setNatPennIncome(String  natPennIncome) { set( ATTR_NATPENNINCOME ,natPennIncome);}
	/** get 국민_보수월액 : natPennIncome */
	public String  getNatPennIncome() { return (String )get( ATTR_NATPENNINCOME );}
	
	/** set 국민_보험료 : natPennPremium */
	public void setNatPennPremium(String  natPennPremium) { set( ATTR_NATPENNPREMIUM ,natPennPremium);}
	/** get 국민_보험료 : natPennPremium */
	public String  getNatPennPremium() { return (String )get( ATTR_NATPENNPREMIUM );}
	
	/** set 건강_보수월액 : hlthInsrIncome */
	public void setHlthInsrIncome(String  hlthInsrIncome) { set( ATTR_HLTHINSRINCOME ,hlthInsrIncome);}
	/** get 건강_보수월액 : hlthInsrIncome */
	public String  getHlthInsrIncome() { return (String )get( ATTR_HLTHINSRINCOME );}
	
	/** set 건강_보험료 : hlthInsrPremium */
	public void setHlthInsrPremium(String  hlthInsrPremium) { set( ATTR_HLTHINSRPREMIUM ,hlthInsrPremium);}
	/** get 건강_보험료 : hlthInsrPremium */
	public String  getHlthInsrPremium() { return (String )get( ATTR_HLTHINSRPREMIUM );}
	
	/** set 고용_보수월액 : umytInsrIncome */
	public void setUmytInsrIncome(String  umytInsrIncome) { set( ATTR_UMYTINSRINCOME ,umytInsrIncome);}
	/** get 고용_보수월액 : umytInsrIncome */
	public String  getUmytInsrIncome() { return (String )get( ATTR_UMYTINSRINCOME );}
	
	/** set 고용_보험료 : umytInsrPremium */
	public void setumytInsrPremium(String  umytInsrPremium) { set( ATTR_UMYTINSRPREMIUM ,umytInsrPremium);}
	/** get 고용_보험료 : umytInsrPremium */
	public String  getumytInsrPremium() { return (String )get( ATTR_UMYTINSRPREMIUM );}
	
	/** set 산재_보수월액 : idtlAccdtIncome */
	public void setIdtlAccdtIncome(String  idtlAccdtIncome) { set( ATTR_IDTLACCDTINCOME ,idtlAccdtIncome);}
	/** get 산재_보수월액 : idtlAccdtIncome */
	public String  getIdtlAccdtIncome() { return (String )get( ATTR_IDTLACCDTINCOME );}
	
	/** set 산재_보험료 : idtlAccdtPremium */
	public void setIdtlAccdtPremium(String  idtlAccdtPremium) { set( ATTR_IDTLACCDTPREMIUM ,idtlAccdtPremium);}
	/** get 산재_보험료 : idtlAccdtPremium */
	public String  getIdtlAccdtPremium() { return (String )get( ATTR_IDTLACCDTPREMIUM );}
	

    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
}
