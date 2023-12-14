package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr4100VO.java
 * @Description : Insr4100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

//	/** set 국민연금일련번호 : natPennSeilNum */
//	public static final String ATTR_NATPENNSEILNUM = "natPennSeilNum";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 국민연금취득일자 : natPennAqtnDt */
	public static final String ATTR_NATPENNAQTNDT = "natPennAqtnDt";

	/** set 국민연금상실일자 : natPennLssDt */
	public static final String ATTR_NATPENNLSSDT = "natPennLssDt";

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
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
 
    
/** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
public static final String ATTR_NATPENNSTDINCMMNTHAMNT = "natPennStdIncmMnthAmnt";

/** set 국민연금등급 : natPennGrde */
public static final String ATTR_NATPENNGRDE = "natPennGrde";


/** set 국민연금보험료 : natPennMnthAmnt */
public static final String ATTR_NATPENNMNTHAMNT = "natPennMnthAmnt";

/** set 국민연금등급보험료  : natPennGrde */
public static final String ATTR_NATPENNGRDEAMNT = "natPennGrdeAmnt";



/** set 국민연금적용여부 : natPennApptnYn */
public static final String ATTR_NATPENNAPPTNYN = "natPennApptnYn";


/** set 국민연금변동일자 : natPennInsurFlucDt */
public static final String ATTR_NATPENNINSURFLUCDT = "natPennInsurFlucDt";
     
/** set 연금보험료 : PYMT_DDUC_D0150100 */
public static final String ATTR_PYMTDDUCD0150100 = "pymtDducD0150100";
    

/** set 정산보험료 : PYMT_DDUC_D0150200 */
public static final String ATTR_PYMTDDUCD0150200 = "pymtDducD0150200";
    

/** set 소급보험료 : PYMT_DDUC_D0150300 */
public static final String ATTR_PYMTDDUCD0150300 = "pymtDducD0150300";
    

/** set 합계 : PYMT_DDUC_SUM */
public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";
    

/** set 연금총근무일수 : antyTotDutyNumDys */
public static final String ATTR_ANTYTOTDUTYNUMDYS = "antyTotDutyNumDys";

/** set 연금소득총액 : antyIncmTotAmnt */
public static final String ATTR_ANTYINCMTOTAMNT = "antyIncmTotAmnt";


	/** 생성자 */
	 public Insr4100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr4100BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  natPennSeilNum 
			, Long  emymtSeilNum 
			, String  natPennAqtnDt 
			, String  natPennLssDt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	// 	values.put(ATTR_NATPENNSEILNUM,natPennSeilNum);
	 	values.put(ATTR_EMYMTSEILNUM,emymtSeilNum);
	 	values.put(ATTR_NATPENNAQTNDT,natPennAqtnDt);
	 	values.put(ATTR_NATPENNLSSDT,natPennLssDt);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr); } 

	 

/** set 국민연금변동일자 : natPennInsurFlucDt */
public void setNatPennInsurFlucDt(String  natPennInsurFlucDt) { set( ATTR_NATPENNINSURFLUCDT ,natPennInsurFlucDt);}
/** get 국민연금변동일자 : natPennInsurFlucDt */
public String  getNatPennInsurFlucDt() { return (String )get( ATTR_NATPENNINSURFLUCDT );}

/** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
public void setNatPennStdIncmMnthAmnt(Long  natPennStdIncmMnthAmnt) { set( ATTR_NATPENNSTDINCMMNTHAMNT ,natPennStdIncmMnthAmnt);}
/** get 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
public Long  getNatPennStdIncmMnthAmnt() { return (Long )get( ATTR_NATPENNSTDINCMMNTHAMNT );}

/** set 국민연금등급 : natPennGrde */
public void setNatPennGrde(String  natPennGrde) { set( ATTR_NATPENNGRDE ,natPennGrde);}
/** get 국민연금등급 : natPennGrde */
public String  getNatPennGrde() { return (String )get( ATTR_NATPENNGRDE );}


/** set 국민연금기준소득월액 : natPennMnthAmnt */
public void setNatPennMnthAmnt(Long  natPennMnthAmnt) { set( ATTR_NATPENNMNTHAMNT ,natPennMnthAmnt);}
/** get 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
public Long  getNatPennMnthAmnt() { return (Long )get( ATTR_NATPENNMNTHAMNT );}

/** set 국민연금등급 : natPennGrdeAmnt */
public void setNatPennGrdeAmnt(Long  natPennGrdeAmnt) { set( ATTR_NATPENNGRDEAMNT ,natPennGrdeAmnt);}
/** get 국민연금등급 : natPennGrdeAmnt */
public Long  getNatPennGrdeAmnt() { return (Long )get( ATTR_NATPENNGRDEAMNT );}



/** set 국민연금적용여부 : natPennApptnYn */
public void setNatPennApptnYn(String  natPennApptnYn) { set( ATTR_NATPENNAPPTNYN ,natPennApptnYn);}
/** get 국민연금적용여부 : natPennApptnYn */
public String  getNatPennApptnYn() { return (String )get( ATTR_NATPENNAPPTNYN );}

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

//	/** set 국민연금일련번호 : natPennSeilNum */
//	public void setNatPennSeilNum(Long  natPennSeilNum) { set( ATTR_NATPENNSEILNUM ,natPennSeilNum);}
//	/** get 국민연금일련번호 : natPennSeilNum */
//	public Long  getNatPennSeilNum() { return (Long )get( ATTR_NATPENNSEILNUM );}

	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}

	/** set 국민연금취득일자 : natPennAqtnDt */
	public void setNatPennAqtnDt(String  natPennAqtnDt) { set( ATTR_NATPENNAQTNDT ,natPennAqtnDt);}
	/** get 국민연금취득일자 : natPennAqtnDt */
	public String  getNatPennAqtnDt() { return (String )get( ATTR_NATPENNAQTNDT );}

	/** set 국민연금상실일자 : natPennLssDt */
	public void setNatPennLssDt(String  natPennLssDt) { set( ATTR_NATPENNLSSDT ,natPennLssDt);}
	/** get 국민연금상실일자 : natPennLssDt */
	public String  getNatPennLssDt() { return (String )get( ATTR_NATPENNLSSDT );}

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
    
    

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
     
 
/** set 연금보험료 : pymtDducD0150100 */
public void setPymtDducD0150100(Long  pymtDducD0150100) { set( ATTR_PYMTDDUCD0150100 ,pymtDducD0150100);}
/** get 연금보험료 : pymtDducD0150100 */
public Long  getPymtDducD0150100() { return (Long )get( ATTR_PYMTDDUCD0150100 );}
 
/** set 정산보험료 : pymtDducD0150200 */
public void setPymtDducD0150200(Long  pymtDducD0150200) { set( ATTR_PYMTDDUCD0150200 ,pymtDducD0150200);}
/** get 정산보험료 : pymtDducD0150200 */
public Long  getPymtDducD0150200() { return (Long )get( ATTR_PYMTDDUCD0150200 );}
 
/** set 소급보험료 : pymtDducD0150300 */
public void setPymtDducD0150300(Long  pymtDducD0150300) { set( ATTR_PYMTDDUCD0150300 ,pymtDducD0150300);}
/** get 소급보험료 : pymtDducD0150300 */
public Long  getPymtDducD0150300() { return (Long )get( ATTR_PYMTDDUCD0150300 );}
 
/** set  합계 : pymtDducSum */
public void setPymtDducSum(Long  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
/** get  합계 : pymtDducSum */
public Long  getPymtDducSum() { return (Long )get( ATTR_PYMTDDUCSUM );}
 

/** set 연금총근무일수 : antyTotDutyNumDys */
public void setAntyTotDutyNumDys(Long  antyTotDutyNumDys) { set( ATTR_ANTYTOTDUTYNUMDYS ,antyTotDutyNumDys);}
/** get 연금총근무일수 : antyTotDutyNumDys */
public Long  getAntyTotDutyNumDys() { return (Long )get( ATTR_ANTYTOTDUTYNUMDYS );}

/** set 연금소득총액 : antyIncmTotAmnt */
public void setAntyIncmTotAmnt(Long  antyIncmTotAmnt) { set( ATTR_ANTYINCMTOTAMNT ,antyIncmTotAmnt);}
/** get 연금소득총액 : antyIncmTotAmnt */
public Long  getAntyIncmTotAmnt() { return (Long )get( ATTR_ANTYINCMTOTAMNT );}


/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


/** set 주민등록번호 : secRegnNum */
public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
/** get 주민등록번호 : secRegnNum */
public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}

}
