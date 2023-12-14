package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr5100VO.java
 * @Description : Insr5100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";
 

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 사대보험공제방식코드 : socInsrDducEthdCd */
	public static final String ATTR_SOCINSRDDUCETHDCD = "socInsrDducEthdCd";

	/** set 사대보험공제방식코드 : socInsrDducEthdNm */
	public static final String ATTR_SOCINSRDDUCETHDNM = "socInsrDducEthdNm";

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public static final String ATTR_UMYTINSRAQTNDT = "umytInsrAqtnDt";

	/** set 고용보험상실일자 : umytInsrLssDt */
	public static final String ATTR_UMYTINSRLSSDT = "umytInsrLssDt";

	/** set 고용보험제외여부 : umytInsrEepnYn */
	public static final String ATTR_UMYTINSREEPNYN = "umytInsrEepnYn";

	/** set 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	public static final String ATTR_UMYTINSREEPNREASCTNT = "umytInsrEepnReasCtnt";

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
    
/** set 고용보험변동일자 : umytInsrFlucDt */
public static final String ATTR_UMYTINSRFLUCDT = "umytInsrFlucDt";

/** set 고용보험보수총액 : umytInsrPayTotAmnt */
public static final String ATTR_UMYTINSRPAYTOTAMNT = "umytInsrPayTotAmnt";

/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
public static final String ATTR_UMYTINSRPAYMNTHAMNT = "umytInsrPayMnthAmnt";


/** set 월고용보험료 : umytInsrMnthAmnt */
public static final String ATTR_UMYTINSRMNTHAMNT = "umytInsrMnthAmnt";


/** set 고용보험적용여부 : umytInsrApptnYn */
public static final String ATTR_UMYTINSRAPPTNYN = "umytInsrApptnYn";


/** set 보험료 : PYMT_DDUC_D0160100 */
public static final String ATTR_PYMTDDUCD0160100 = "pymtDducD0160100";


/** set 정산보험료 : PYMT_DDUC_D0160200 */
public static final String ATTR_PYMTDDUCD0160200 = "pymtDducD0160200";


/** set 소급보험료 : PYMT_DDUC_D0160300 */
public static final String ATTR_PYMTDDUCD0160300 = "pymtDducD0160300";


/** set 합계 : PYMT_DDUC_SUM */
public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

 

	/** 생성자 */
	 public Insr5100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr5100BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  emymtSeilNum 
			, String  socInsrDducEthdCd 
			, String  umytInsrAqtnDt 
			, String  umytInsrLssDt 
			, String  umytInsrEepnYn 
			, String  umytInsrEepnReasCtnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_EMYMTSEILNUM,emymtSeilNum);
	 	values.put(ATTR_SOCINSRDDUCETHDCD,socInsrDducEthdCd);
	 	values.put(ATTR_UMYTINSRAQTNDT,umytInsrAqtnDt);
	 	values.put(ATTR_UMYTINSRLSSDT,umytInsrLssDt);
	 	values.put(ATTR_UMYTINSREEPNYN,umytInsrEepnYn);
	 	values.put(ATTR_UMYTINSREEPNREASCTNT,umytInsrEepnReasCtnt);
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


	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}

	/** set 사대보험공제방식코드 : socInsrDducEthdCd */
	public void setSocInsrDducEthdCd(String  socInsrDducEthdCd) { set( ATTR_SOCINSRDDUCETHDCD ,socInsrDducEthdCd);}
	/** get 사대보험공제방식코드 : socInsrDducEthdCd */
	public String  getSocInsrDducEthdCd() { return (String )get( ATTR_SOCINSRDDUCETHDCD );}

	/** set 사대보험공제방식코드 : socInsrDducEthdNm */
	public void setSocInsrDducEthdNm(String  socInsrDducEthdNm) { set( ATTR_SOCINSRDDUCETHDNM ,socInsrDducEthdNm);}
	/** get 사대보험공제방식코드 : socInsrDducEthdNm */
	public String  getSocInsrDducEthdNm() { return (String )get( ATTR_SOCINSRDDUCETHDNM );}
 

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public void setUmytInsrAqtnDt(String  umytInsrAqtnDt) { set( ATTR_UMYTINSRAQTNDT ,umytInsrAqtnDt);}
	/** get 고용보험취득일자 : umytInsrAqtnDt */
	public String  getUmytInsrAqtnDt() { return (String )get( ATTR_UMYTINSRAQTNDT );}

	/** set 고용보험상실일자 : umytInsrLssDt */
	public void setUmytInsrLssDt(String  umytInsrLssDt) { set( ATTR_UMYTINSRLSSDT ,umytInsrLssDt);}
	/** get 고용보험상실일자 : umytInsrLssDt */
	public String  getUmytInsrLssDt() { return (String )get( ATTR_UMYTINSRLSSDT );}

	/** set 고용보험제외여부 : umytInsrEepnYn */
	public void setUmytInsrEepnYn(String  umytInsrEepnYn) { set( ATTR_UMYTINSREEPNYN ,umytInsrEepnYn);}
	/** get 고용보험제외여부 : umytInsrEepnYn */
	public String  getUmytInsrEepnYn() { return (String )get( ATTR_UMYTINSREEPNYN );}

	/** set 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	public void setUmytInsrEepnReasCtnt(String  umytInsrEepnReasCtnt) { set( ATTR_UMYTINSREEPNREASCTNT ,umytInsrEepnReasCtnt);}
	/** get 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	public String  getUmytInsrEepnReasCtnt() { return (String )get( ATTR_UMYTINSREEPNREASCTNT );}

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
  
    

/** set 고용보험변동일자 : umytInsrFlucDt */
public void setUmytInsrFlucDt(String  umytInsrFlucDt) { set( ATTR_UMYTINSRFLUCDT ,umytInsrFlucDt);}
/** get 고용보험변동일자 : umytInsrFlucDt */
public String  getUmytInsrFlucDt() { return (String )get( ATTR_UMYTINSRFLUCDT );}

/** set 고용보험보수총액 : umytInsrPayTotAmnt */
public void setUmytInsrPayTotAmnt(Long  umytInsrPayTotAmnt) { set( ATTR_UMYTINSRPAYTOTAMNT ,umytInsrPayTotAmnt);}
/** get 고용보험보수총액 : umytInsrPayTotAmnt */
public Long  getUmytInsrPayTotAmnt() { return (Long )get( ATTR_UMYTINSRPAYTOTAMNT );}

/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
public void setUmytInsrPayMnthAmnt(Long  umytInsrPayMnthAmnt) { set( ATTR_UMYTINSRPAYMNTHAMNT ,umytInsrPayMnthAmnt);}
/** get 고용보험보수월액 : umytInsrPayMnthAmnt */
public Long  getUmytInsrPayMnthAmnt() { return (Long )get( ATTR_UMYTINSRPAYMNTHAMNT );}

/** set 고용보험보수월액 : umytInsrMnthAmnt */
public void setUmytInsrMnthAmnt(Long  umytInsrMnthAmnt) { set( ATTR_UMYTINSRMNTHAMNT ,umytInsrMnthAmnt);}
/** get 고용보험보수월액 : umytInsrMnthAmnt */
public Long  getUmytInsrMnthAmnt() { return (Long )get( ATTR_UMYTINSRMNTHAMNT );}

/** set 고용보험적용여부 : umytInsrApptnYn */
public void setUmytInsrApptnYn(String  umytInsrApptnYn) { set( ATTR_UMYTINSRAPPTNYN ,umytInsrApptnYn);}
/** get 고용보험적용여부 : umytInsrApptnYn */
public String  getUmytInsrApptnYn() { return (String )get( ATTR_UMYTINSRAPPTNYN );}


/** set 보험료 : pymtDducD0160100 */
public void setPymtDducD0160100(Long  pymtDducD0160100) { set( ATTR_PYMTDDUCD0160100 ,pymtDducD0160100);}
/** get 보험료 : pymtDducD0160100 */
public Long  getPymtDducD0160100() { return (Long )get( ATTR_PYMTDDUCD0160100 );}
 
/** set 정산보험료 : pymtDducD0160200 */
public void setPymtDducD0160200(Long  pymtDducD0160200) { set( ATTR_PYMTDDUCD0160200 ,pymtDducD0160200);}
/** get 정산보험료 : pymtDducD0160200 */
public Long  getPymtDducD0160200() { return (Long )get( ATTR_PYMTDDUCD0160200 );}
 
/** set 소급보험료 : pymtDducD0160300 */
public void setPymtDducD0160300(Long  pymtDducD0160300) { set( ATTR_PYMTDDUCD0160300 ,pymtDducD0160300);}
/** get 소급보험료 : pymtDducD0160300 */
public Long  getPymtDducD0160300() { return (Long )get( ATTR_PYMTDDUCD0160300 );}
 
/** set  합계 : pymtDducSum */
public void setPymtDducSum(Long  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
/** get  합계 : pymtDducSum */
public Long  getPymtDducSum() { return (Long )get( ATTR_PYMTDDUCSUM );}
    

/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}



/** set 주민등록번호 : secRegnNum */
public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
/** get 주민등록번호 : secRegnNum */
public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}


  
}
