package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3000VO.java
 * @Description : Insr3000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3000BM  extends MSFSimpleBaseModel implements IsSerializable   {
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

	/** set 건강보험취득일자 : hlthInsrAqtnDt */
	public static final String ATTR_HLTHINSRAQTNDT = "hlthInsrAqtnDt";

	/** set 건강보험상실일자 : hlthInsrLssDt */
	public static final String ATTR_HLTHINSRLSSDT = "hlthInsrLssDt";

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

    
    /** set 예외처리지급금액 -건강보험 : exptnPrcsPymtSum01 */
    public static final String ATTR_EXPTNPRCSPYMTSUM01 = "exptnPrcsPymtSum01";

    /** set 예외처리지급비율 -건강보험 : exptnPrcsPymtRto01 */
    public static final String ATTR_EXPTNPRCSPYMTRTO01 = "exptnPrcsPymtRto01";
    
    
    /** set 예외처리지급금액 -장기요양보험 : exptnPrcsPymtSum02 */
    public static final String ATTR_EXPTNPRCSPYMTSUM02 = "exptnPrcsPymtSum02";

    /** set 예외처리지급비율 -장기요양보험 : exptnPrcsPymtRto02 */
    public static final String ATTR_EXPTNPRCSPYMTRTO02 = "exptnPrcsPymtRto02";
    
 
    /** set 연금보험료 : pymtDducD0010100 */
    public static final String ATTR_PYMTDDUCD0010100 = "pymtDducD0010100";

    /** set 정산보험료 : pymtDducD0010200 */
    public static final String ATTR_PYMTDDUCD0010200 = "pymtDducD0010200";

    /** set 소급보험료 : pymtDducD0010300 */
    public static final String ATTR_PYMTDDUCD0010300 = "pymtDducD0010300";
        
    /** set 휴직자분할보험료 : pymtDducD0010400 */
    public static final String ATTR_PYMTDDUCD0010400 = "pymtDducD0010400";

    /** set 건강보험환급금이자 : pymtDducD0010500 */
    public static final String ATTR_PYMTDDUCD0010500 = "pymtDducD0010500"; 
        
    

 
/** set 노인장기요양보험 : pymtDducD0110100 */
public static final String ATTR_PYMTDDUCD0110100 = "pymtDducD0110100";

/** set 장기요양보험연말정산 : pymtDducD0110200 */
public static final String ATTR_PYMTDDUCD0110200 = "pymtDducD0110200";

/** set 노인장기요양보험과미납 : pymtDducD0110300 */
public static final String ATTR_PYMTDDUCD0110300 = "pymtDducD0110300";
    
/** set 휴직자분할장기요양보험료 : pymtDducD0110400 */
public static final String ATTR_PYMTDDUCD0110400 = "pymtDducD0110400";

/** set 노인장기요양보험환급금이자 : pymtDducD0110500 */
public static final String ATTR_PYMTDDUCD0110500 = "pymtDducD0110500"; 
    


/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

 

/** set 합계 : PYMT_DDUC_SUM */
public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";
    
    

/** set 건강보험변동일자 : hlthInsurFlucDt */
public static final String ATTR_HLTHINSURFLUCDT = "hlthInsurFlucDt";

/** set 건강보험보수총액 : hlthInsrPayTotAmnt */
public static final String ATTR_HLTHINSRPAYTOTAMNT = "hlthInsrPayTotAmnt";

/** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
public static final String ATTR_HLTHINSRMNTHRUNTNAMNT = "hlthInsrMnthRuntnAmnt";

/** set 건강보험 : hlthInsrMnthAmnt */
public static final String ATTR_HLTHINSRMNTHAMNT = "hlthInsrMnthAmnt";


/** set 장기요양보험료 : HLTH_RCPTN_MNTH_AMNT */
public static final String ATTR_HLTHRCPTNMNTHAMNT = "hlthRcptnMnthAmnt";



/** set 건강보험등급 : hlthInsrGrde */
public static final String ATTR_HLTHINSRGRDE = "hlthInsrGrde";

/** set 건강보험증번호 : hlthInsrCertNum */
public static final String ATTR_HLTHINSRCERTNUM = "hlthInsrCertNum";
 
/** set 건강보험적용여부 : hlthInsrApptnYn */
public static final String ATTR_HLTHINSRAPPTNYN = "hlthInsrApptnYn";

 
	/** set 예외구분코드 : exptnDivCd */
	public static final String ATTR_EXPTNDIVCD = "exptnDivCd";
	
	/** set 예외구분코드 : exptnDivCd01 */
	public static final String ATTR_EXPTNDIVCD01 = "exptnDivCd01";
	

	/** set 예외구분코드 : exptnDivCd02 */
	public static final String ATTR_EXPTNDIVCD02 = "exptnDivCd02";
	
	/** set 예외구분코드 : exptnDivNm01 */
	public static final String ATTR_EXPTNDIVNM01 = "exptnDivNm01";
	

	/** set 예외구분코드 : exptnDivNm02 */
	public static final String ATTR_EXPTNDIVNM02 = "exptnDivNm02";
	
	/** set 예외구분 : exptnDivNm */
	public static final String ATTR_EXPTNDIVNM = "exptnDivNm";
	
	/** set 지급공제구분코드 : pymtDducDivCd */
	public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
	
	
	/** set 지급공제구분 : pymtDducDivNm */
	public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";
	
	/** set 면제여부 : exmtnYn */
	public static final String ATTR_EXMTNYN = "exmtnYn";
	 
	/** set 급여항목코드 : payItemCd */
	public static final String ATTR_PAYITEMCD = "payItemCd";
	
	/** set 예외처리내용 : exptnPrcsNoteCtnt */
	public static final String ATTR_EXPTNPRCSNOTECTNT = "exptnPrcsNoteCtnt"; 
	
	   /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";
	

	/** 생성자 */
	 public Insr3000BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3000BM(
			 String  dpobCd 
			, String  systemkey  
			, Long  emymtSeilNum 
			, String  socInsrDducEthdCd 
			, String  hlthInsrAqtnDt 
			, String  hlthInsrLssDt 
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
	 	values.put(ATTR_HLTHINSRAQTNDT,hlthInsrAqtnDt);
	 	values.put(ATTR_HLTHINSRLSSDT,hlthInsrLssDt);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr); } 

	 

	    /** set 지급년월 : pymtYrMnth */
	    public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
	    /** get 지급년월 : pymtYrMnth */
	    public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}
	    
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
 
	
	/** set 건강보험취득일자 : hlthInsrAqtnDt */
	public void setHlthInsrAqtnDt(String  hlthInsrAqtnDt) { set( ATTR_HLTHINSRAQTNDT ,hlthInsrAqtnDt);}
	/** get 건강보험취득일자 : hlthInsrAqtnDt */
	public String  getHlthInsrAqtnDt() { return (String )get( ATTR_HLTHINSRAQTNDT );}

	/** set 건강보험상실일자 : hlthInsrLssDt */
	public void setHlthInsrLssDt(String  hlthInsrLssDt) { set( ATTR_HLTHINSRLSSDT ,hlthInsrLssDt);}
	/** get 건강보험상실일자 : hlthInsrLssDt */
	public String  getHlthInsrLssDt() { return (String )get( ATTR_HLTHINSRLSSDT );}

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
   

   /** set 주민등록번호 : secRegnNum */
   public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
   /** get 주민등록번호 : secRegnNum */
   public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
   


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
   
   
   /** set 예외처리지급금액 -건강보험 : exptnPrcsPymtSum01 */
   public void setExptnPrcsPymtSum01(Long  exptnPrcsPymtSum01) { set( ATTR_EXPTNPRCSPYMTSUM01 ,exptnPrcsPymtSum01);}
   /** get 예외처리지급금액 - 건강보험 : exptnPrcsPymtSum01 */
   public Long  getExptnPrcsPymtSum01() { return (Long )get( ATTR_EXPTNPRCSPYMTSUM01 );}

   /** set 예외처리지급비율 -건강보험: exptnPrcsPymtRto01 */
   public void setExptnPrcsPymtRto01(Double  exptnPrcsPymtRto01) { set( ATTR_EXPTNPRCSPYMTRTO01 ,exptnPrcsPymtRto01);}
   /** get 예외처리지급비율 -건강보험: exptnPrcsPymtRto01 */
   public Double  getExptnPrcsPymtRto01() { return (Double )get( ATTR_EXPTNPRCSPYMTRTO01 );}
    
   
   /** set 예외처리지급금액 -장기요양보험 : exptnPrcsPymtSum02 */
   public void setExptnPrcsPymtSum02(Long  exptnPrcsPymtSum02) { set( ATTR_EXPTNPRCSPYMTSUM02 ,exptnPrcsPymtSum02);}
   /** get 예외처리지급금액 - 장기요양보험 : exptnPrcsPymtSum02 */
   public Long  getExptnPrcsPymtSum02() { return (Long )get( ATTR_EXPTNPRCSPYMTSUM02 );}

   /** set 예외처리지급비율 -장기요양보험: exptnPrcsPymtRto02 */
   public void setExptnPrcsPymtRto02(Double  exptnPrcsPymtRto02) { set( ATTR_EXPTNPRCSPYMTRTO02 ,exptnPrcsPymtRto02);}
   /** get 예외처리지급비율 -장기요양보험: exptnPrcsPymtRto02 */
   public Double  getExptnPrcsPymtRto02() { return (Double )get( ATTR_EXPTNPRCSPYMTRTO02 );}
    
   

/** set 건강보험변동일자 : hlthInsurFlucDt */
public void setHlthInsurFlucDt(String  hlthInsurFlucDt) { set( ATTR_HLTHINSURFLUCDT ,hlthInsurFlucDt);}
/** get 건강보험변동일자 : hlthInsurFlucDt */
public String  getHlthInsurFlucDt() { return (String )get( ATTR_HLTHINSURFLUCDT );}

/** set 건강보험보수총액 : hlthInsrPayTotAmnt */
public void setHlthInsrPayTotAmnt(Long  hlthInsrPayTotAmnt) { set( ATTR_HLTHINSRPAYTOTAMNT ,hlthInsrPayTotAmnt);}
/** get 건강보험보수총액 : hlthInsrPayTotAmnt */
public Long  getHlthInsrPayTotAmnt() { return (Long )get( ATTR_HLTHINSRPAYTOTAMNT );}

/** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
public void setHlthInsrMnthRuntnAmnt(Long  hlthInsrMnthRuntnAmnt) { set( ATTR_HLTHINSRMNTHRUNTNAMNT ,hlthInsrMnthRuntnAmnt);}
/** get 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
public Long  getHlthInsrMnthRuntnAmnt() { return (Long )get( ATTR_HLTHINSRMNTHRUNTNAMNT );}


/** set 건강보험료 : hlthInsrMnthAmnt */
public void setHlthInsrMnthAmnt(Long  hlthInsrMnthAmnt) { set( ATTR_HLTHINSRMNTHAMNT ,hlthInsrMnthAmnt);}
/** get 건강보험료 : hlthInsrMnthRuntnAmnt */
public Long  getHlthInsrMnthAmnt() { return (Long )get( ATTR_HLTHINSRMNTHAMNT );}


/** set 건강보험등급 : hlthInsrGrde */
public void setHlthInsrGrde(String  hlthInsrGrde) { set( ATTR_HLTHINSRGRDE ,hlthInsrGrde);}
/** get 건강보험등급 : hlthInsrGrde */
public String  getHlthInsrGrde() { return (String )get( ATTR_HLTHINSRGRDE );}

/** set 건강보험증번호 : hlthInsrCertNum */
public void setHlthInsrCertNum(String  hlthInsrCertNum) { set( ATTR_HLTHINSRCERTNUM ,hlthInsrCertNum);}
/** get 건강보험증번호 : hlthInsrCertNum */
public String  getHlthInsrCertNum() { return (String )get( ATTR_HLTHINSRCERTNUM );}
 
/** set 건강보험적용여부 : hlthInsrApptnYn */
public void setHlthInsrApptnYn(String  hlthInsrApptnYn) { set( ATTR_HLTHINSRAPPTNYN ,hlthInsrApptnYn);}
/** get 건강보험적용여부 : hlthInsrApptnYn */
public String  getHlthInsrApptnYn() { return (String )get( ATTR_HLTHINSRAPPTNYN );}



/** set 장기요양보험료 : hlthInsrMnthAmnt */
public void setHlthRcptnMnthAmnt(Long  hlthRcptnMnthAmnt) { set( ATTR_HLTHRCPTNMNTHAMNT ,hlthRcptnMnthAmnt);}
/** get 장기요양보험료 : hlthInsrMnthRuntnAmnt */
public Long  getHlthRcptnMnthAmnt() { return (Long )get( ATTR_HLTHRCPTNMNTHAMNT );}

  
/** set 예외구분코드 : exptnDivCd */
public void setExptnDivCd(String  exptnDivCd) { set( ATTR_EXPTNDIVCD ,exptnDivCd);}
/** get 예외구분코드 : exptnDivCd */
public String  getExptnDivCd() { return (String )get( ATTR_EXPTNDIVCD );}



/** set 예외구분코드 -건강보험 : exptnDivCd01 */
public void setExptnDivCd01(String  exptnDivCd01) { set( ATTR_EXPTNDIVCD01 ,exptnDivCd01);}
/** get 예외구분코드 -건강보험 : exptnDivCd01 */
public String  getExptnDivCd01() { return (String )get( ATTR_EXPTNDIVCD01 );}


/** set 예외구분코드 -장기요양 : exptnDivCd02 */
public void setExptnDivCd02(String  exptnDivCd02) { set( ATTR_EXPTNDIVCD02 ,exptnDivCd02);}
/** get 예외구분코드 - 장기요양: exptnDivCd02 */
public String  getExptnDivCd02() { return (String )get( ATTR_EXPTNDIVCD02 );}
 

/** set 예외구분코드 -건강보험 : exptnDivNm01 */
public void setExptnDivNm01(String  exptnDivNm01) { set( ATTR_EXPTNDIVNM01 ,exptnDivNm01);}
/** get 예외구분코드 -건강보험 : exptnDivCd01 */
public String  getExptnDivNm01() { return (String )get( ATTR_EXPTNDIVNM01 );}


/** set 예외구분코드 -장기요양 : exptnDivNm02 */
public void setExptnDivNm02(String  exptnDivNm02) { set( ATTR_EXPTNDIVNM02 ,exptnDivNm02);}
/** get 예외구분코드 - 장기요양: exptnDivCd02 */
public String  getExptnDivNm02() { return (String )get( ATTR_EXPTNDIVNM02 );} 


/** set 예외구분 : exptnDivNm */
public void setExptnDivNm(String  exptnDivNm) { set( ATTR_EXPTNDIVNM ,exptnDivNm);}
/** get 예외구분코드 : exptnDivNm */
public String  getExptnDivNm() { return (String )get( ATTR_EXPTNDIVNM );}

/** set 지급공제구분코드 : pymtDducDivCd */
public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
/** get 지급공제구분코드 : pymtDducDivCd */
public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}


/** set 지급공제구분 : pymtDducDivNm */
public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
/** get 지급공제구분 : pymtDducDivNm */
public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}


/** set 면제여부 : exmtnYn */
public void setExmtnYn(String  exmtnYn) { set( ATTR_EXMTNYN ,exmtnYn);}
/** get 면제여부 : exmtnYn */
public String  getExmtnYn() { return (String )get( ATTR_EXMTNYN );}
 
/** set 급여항목코드 : payItemCd */
public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
/** get 급여항목코드 : payItemCd */
public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

/** set 예외처리내용 : exptnPrcsNoteCtnt */
public void setExptnPrcsNoteCtnt(String  exptnPrcsNoteCtnt) { set( ATTR_EXPTNPRCSNOTECTNT ,exptnPrcsNoteCtnt);}
/** get 예외처리내용 : exptnPrcsNoteCtnt */
public String  getExptnPrcsNoteCtnt() { return (String )get( ATTR_EXPTNPRCSNOTECTNT );}


/** set 건강보험료 : pymtDducD0010100 */ 
public void setPymtDducD0010100(Long  pymtDducD0010100) { set( ATTR_PYMTDDUCD0010100 ,pymtDducD0010100);}
/** get 건강보험료 : pymtDducD0010100 */ 
public Long  getPymtDducD0010100() { return (Long )get( ATTR_PYMTDDUCD0010100 );}

/** set 정산보험료 : pymtDducD0010200 */ 
public void setPymtDducD0010200(Long  pymtDducD0010200) { set( ATTR_PYMTDDUCD0010200 ,pymtDducD0010200);}
/** get 소급보험료 : pymtDducD0150300 */
public Long  getPymtDducD0010200() { return (Long )get( ATTR_PYMTDDUCD0010200 );}

/** set 소급보험료 : pymtDducD0010300 */ 
public void setPymtDducD0010300(Long  pymtDducD0010300) { set( ATTR_PYMTDDUCD0010300 ,pymtDducD0010300);}
/** get 소급보험료 : pymtDducD0010300 */ 
public Long  getPymtDducD0010300() { return (Long )get( ATTR_PYMTDDUCD0010300 );}

/** set 휴직자분할보험료 : pymtDducD0010400 */ 
public void setPymtDducD0010400(Long  pymtDducD0010400) { set( ATTR_PYMTDDUCD0010400 ,pymtDducD0010400);}
/** get 휴직자분할보험료 : pymtDducD0010400 */ 
public Long  getPymtDducD0010400() { return (Long )get( ATTR_PYMTDDUCD0010400 );}

/** set 건강보험환급금이자 : pymtDducD0010500 */ 
public void setPymtDducD0010500(Long  pymtDducD0010500) { set( ATTR_PYMTDDUCD0010500 ,pymtDducD0010500);}
/** get 건강보험환급금이자 : pymtDducD0010500 */ 
public Long  getPymtDducD0010500() { return (Long )get( ATTR_PYMTDDUCD0010500 );}

/** set 노인장기요양보험 : pymtDducD0110100 */ 
public void setPymtDducD0110100(Long  pymtDducD0110100) { set( ATTR_PYMTDDUCD0110100 ,pymtDducD0110100);}
/** get 노인장기요양보험 : pymtDducD0110100 */ 
public Long  getPymtDducD0110100() { return (Long )get( ATTR_PYMTDDUCD0110100 );}

/** set 장기요양보험연말정산 : pymtDducD0110200 */ 
public void setPymtDducymtDducD0110200(Long  pymtDducD0110200) { set( ATTR_PYMTDDUCD0110200 ,pymtDducD0110200);}
/** get 장기요양보험연말정산 : pymtDducD0110200 */ 
public Long  getPymtDducD0110200() { return (Long )get( ATTR_PYMTDDUCD0110200 );}

/** set 노인장기요양보험과미납 : pymtDducD0110300 */ 
public void setPymtDducD0110300(Long  pymtDducD0110300) { set( ATTR_PYMTDDUCD0110300 ,pymtDducD0110300);}
/** get 노인장기요양보험과미납 : pymtDducD0110300 */ 
public Long  getPymtDducD0110300() { return (Long )get( ATTR_PYMTDDUCD0110300 );}

/** set 휴직자분할장기요양보험료 : pymtDducD0110400 */
public void setPymtDducD0110400(Long  pymtDducD0110400) { set( ATTR_PYMTDDUCD0110400 ,pymtDducD0110400);}
/** get 휴직자분할장기요양보험료 : pymtDducD0110400 */
public Long  getPymtDducD0110400() { return (Long )get( ATTR_PYMTDDUCD0110400 );}


/** set 노인장기요양보험환급금이자 : pymtDducD0110500 */ 
public void setPymtDducD0110500(Long  pymtDducD0110500) { set( ATTR_PYMTDDUCD0110500 ,pymtDducD0110500);}
/** get 노인장기요양보험환급금이자 : pymtDducD0110500 */ 
public Long  getPymtDducD0110500() { return (Long )get( ATTR_PYMTDDUCD0110500 );}


/** set  합계 : pymtDducSum */
public void setPymtDducSum(Long  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
/** get  합계 : pymtDducSum */
public Long  getPymtDducSum() { return (Long )get( ATTR_PYMTDDUCSUM );}



/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

}
