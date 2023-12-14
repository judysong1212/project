package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr1400VO.java
 * @Description : Insr1400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1400BM  extends MSFSimpleBaseModel implements IsSerializable   {
	
	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";
	
	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
	
	//TODO 임시 .. 나중에 확인후 수정
	/** set 전화번호(사업장) : tempComPunNm */
	public static final String ATTR_TEMPCOMPUNNM = "tempComPunNm";
	
	//TODO 임시 .. 나중에 확인후 수정
	/** set 전화번호(가입) : tempHuPunNm */
	public static final String ATTR_TEMPHUPUNNM = "tempHuPunNm";
	
	
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 가족일련번호 : famySeilNum */
	public static final String ATTR_FAMYSEILNUM = "famySeilNum";

	/** set 가족관계구분코드 : famyRelaDivCd */
	public static final String ATTR_FAMYRELADIVCD = "famyRelaDivCd";


    /** set 가족관계 : famyRelaDivNm */
    public static final String ATTR_FAMYRELADIVNM = "famyRelaDivNm";
    
	/** set 가족성명 : famyNm */
	public static final String ATTR_FAMYNM = "famyNm";

	/** set 가족주민등록번호 : famyResnRegnNum */
	public static final String ATTR_FAMYRESNREGNNUM = "famyResnRegnNum";
	
	/** set 가족주민등록번호 : famySecRegnNum */
	public static final String ATTR_FAMYSECREGNNUM = "famySecRegnNum";

	/** set 관계부호 : relaSgn */
	public static final String ATTR_RELASGN = "relaSgn";
	
	/** set 관계부호 : relaSgnNm */
	public static final String ATTR_RELASGNNM = "relaSgnNm";

	/** set 취득상실구분코드 : aqtnLssDivCd */
	public static final String ATTR_AQTNLSSDIVCD = "aqtnLssDivCd";
	
	/** set 취득상실구분 : aqtnLssDivNm */
	public static final String ATTR_AQTNLSSDIVNM = "aqtnLssDivNm";

	/** set 취득일자 : aqtnDt */
	public static final String ATTR_AQTNDT = "aqtnDt";

	/** set 취득상실사유코드 : aqtnLssReasCd */
	public static final String ATTR_AQTNLSSREASCD = "aqtnLssReasCd";
	
	/** set 취득상실사유 : aqtnLssReasNm */
	public static final String ATTR_AQTNLSSREASNM = "aqtnLssReasNm";

	/** set 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public static final String ATTR_DBPSNASSTTNSGNCD = "dbpsnAssttnSgnCd";
	

	/** set 장애인_종별부호 : dbpsnAssttnSgnNm */
	public static final String ATTR_DBPSNASSTTNSGNNM = "dbpsnAssttnSgnNm";

	/** set 장애인_등급코드 : dbpsnGrdeCd */
	public static final String ATTR_DBPSNGRDECD = "dbpsnGrdeCd";
	
	/** set 장애인_등급코드 : dbpsnGrdeNm */
	public static final String ATTR_DBPSNGRDENM = "dbpsnGrdeNm";

	/** set 장애인_등록일자 : dbpsnRgstnDt */
	public static final String ATTR_DBPSNRGSTNDT = "dbpsnRgstnDt";

	/** set 장애인_국적코드 : dbpsnNatnCd */
	public static final String ATTR_DBPSNNATNCD = "dbpsnNatnCd";
	

	/** set 장애인_국적 : dbpsnNatnNm */
	public static final String ATTR_DBPSNNATNNM = "dbpsnNatnNm";

	/** set 외국인_체류자격코드 : frgnrStyQftntCd */
	public static final String ATTR_FRGNRSTYQFTNTCD = "frgnrStyQftntCd";
	
	/** set 외국인_체류자격 : frgnrStyQftntNm */
	public static final String ATTR_FRGNRSTYQFTNTNM = "frgnrStyQftntNm";

	/** set 외국인_체류시작일자 : frgnrStyBgnnDt */
	public static final String ATTR_FRGNRSTYBGNNDT = "frgnrStyBgnnDt";

	/** set 외국인_체류종료일자 : frgnrStyEndDt */
	public static final String ATTR_FRGNRSTYENDDT = "frgnrStyEndDt";

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public static final String ATTR_SOCTYINSURCMPTNDT = "soctyInsurCmptnDt";

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public static final String ATTR_SOCINSRAQTNEMYMTNUM = "socInsrAqtnEmymtNum";

	/** 생성자 */
	 public Insr1400BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr1400BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  famySeilNum 
			, String  famyRelaDivCd 
			, String  famyNm 
			, String  famyResnRegnNum 
			, String  relaSgn 
			, String  aqtnLssDivCd 
			, String  aqtnDt 
			, String  aqtnLssReasCd 
			, String  dbpsnAssttnSgnCd 
			, String  dbpsnGrdeCd 
			, String  dbpsnRgstnDt 
			, String  dbpsnNatnCd 
			, String  frgnrStyQftntCd 
			, String  frgnrStyBgnnDt 
			, String  frgnrStyEndDt 
			, String  soctyInsurCmptnDt 
			, Long  socInsrAqtnEmymtNum ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_FAMYSEILNUM,famySeilNum);
	 	values.put(ATTR_FAMYRELADIVCD,famyRelaDivCd);
	 	values.put(ATTR_FAMYNM,famyNm);
	 	values.put(ATTR_FAMYRESNREGNNUM,famyResnRegnNum);
	 	values.put(ATTR_RELASGN,relaSgn);
	 	values.put(ATTR_AQTNLSSDIVCD,aqtnLssDivCd);
	 	values.put(ATTR_AQTNDT,aqtnDt);
	 	values.put(ATTR_AQTNLSSREASCD,aqtnLssReasCd);
	 	values.put(ATTR_DBPSNASSTTNSGNCD,dbpsnAssttnSgnCd);
	 	values.put(ATTR_DBPSNGRDECD,dbpsnGrdeCd);
	 	values.put(ATTR_DBPSNRGSTNDT,dbpsnRgstnDt);
	 	values.put(ATTR_DBPSNNATNCD,dbpsnNatnCd);
	 	values.put(ATTR_FRGNRSTYQFTNTCD,frgnrStyQftntCd);
	 	values.put(ATTR_FRGNRSTYBGNNDT,frgnrStyBgnnDt);
	 	values.put(ATTR_FRGNRSTYENDDT,frgnrStyEndDt);
	 	values.put(ATTR_SOCTYINSURCMPTNDT,soctyInsurCmptnDt);
	 	values.put(ATTR_SOCINSRAQTNEMYMTNUM,socInsrAqtnEmymtNum); } 

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 가족일련번호 : famySeilNum */
	public void setFamySeilNum(Long  famySeilNum) { set( ATTR_FAMYSEILNUM ,famySeilNum);}
	/** get 가족일련번호 : famySeilNum */
	public Long  getFamySeilNum() { return (Long )get( ATTR_FAMYSEILNUM );}

	/** set 가족관계구분코드 : famyRelaDivCd */
	public void setFamyRelaDivCd(String  famyRelaDivCd) { set( ATTR_FAMYRELADIVCD ,famyRelaDivCd);}
	/** get 가족관계구분코드 : famyRelaDivCd */
	public String  getFamyRelaDivCd() { return (String )get( ATTR_FAMYRELADIVCD );}

	/** set 가족성명 : famyNm */
	public void setFamyNm(String  famyNm) { set( ATTR_FAMYNM ,famyNm);}
	/** get 가족성명 : famyNm */
	public String  getFamyNm() { return (String )get( ATTR_FAMYNM );}

	  /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
	/** set 가족주민등록번호 : famyResnRegnNum */
	public void setFamyResnRegnNum(String  famyResnRegnNum) { set( ATTR_FAMYRESNREGNNUM ,famyResnRegnNum);}
	/** get 가족주민등록번호 : famyResnRegnNum */
	public String  getFamyResnRegnNum() { return (String )get( ATTR_FAMYRESNREGNNUM );}
	
	/** set 가족주민등록번호 : famySecRegnNum */
	public void setFamySecRegnNum(String  famySecRegnNum) { set( ATTR_FAMYSECREGNNUM ,famySecRegnNum);}
	/** get 가족주민등록번호 : famySecRegnNum */
	public String  getFamySecRegnNum() { return (String )get( ATTR_FAMYSECREGNNUM );}

	/** set 관계부호 : relaSgn */
	public void setRelaSgn(String  relaSgn) { set( ATTR_RELASGN ,relaSgn);}
	/** get 관계부호 : relaSgn */
	public String  getRelaSgn() { return (String )get( ATTR_RELASGN );}

	/** set 취득상실구분코드 : aqtnLssDivCd */
	public void setAqtnLssDivCd(String  aqtnLssDivCd) { set( ATTR_AQTNLSSDIVCD ,aqtnLssDivCd);}
	/** get 취득상실구분코드 : aqtnLssDivCd */
	public String  getAqtnLssDivCd() { return (String )get( ATTR_AQTNLSSDIVCD );}

	/** set 취득일자 : aqtnDt */
	public void setAqtnDt(String  aqtnDt) { set( ATTR_AQTNDT ,aqtnDt);}
	/** get 취득일자 : aqtnDt */
	public String  getAqtnDt() { return (String )get( ATTR_AQTNDT );}

	/** set 취득상실사유코드 : aqtnLssReasCd */
	public void setAqtnLssReasCd(String  aqtnLssReasCd) { set( ATTR_AQTNLSSREASCD ,aqtnLssReasCd);}
	/** get 취득상실사유코드 : aqtnLssReasCd */
	public String  getAqtnLssReasCd() { return (String )get( ATTR_AQTNLSSREASCD );}

	/** set 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public void setDbpsnAssttnSgnCd(String  dbpsnAssttnSgnCd) { set( ATTR_DBPSNASSTTNSGNCD ,dbpsnAssttnSgnCd);}
	/** get 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public String  getDbpsnAssttnSgnCd() { return (String )get( ATTR_DBPSNASSTTNSGNCD );}

	/** set 장애인_등급코드 : dbpsnGrdeCd */
	public void setDbpsnGrdeCd(String  dbpsnGrdeCd) { set( ATTR_DBPSNGRDECD ,dbpsnGrdeCd);}
	/** get 장애인_등급코드 : dbpsnGrdeCd */
	public String  getDbpsnGrdeCd() { return (String )get( ATTR_DBPSNGRDECD );}

	/** set 장애인_등록일자 : dbpsnRgstnDt */
	public void setDbpsnRgstnDt(String  dbpsnRgstnDt) { set( ATTR_DBPSNRGSTNDT ,dbpsnRgstnDt);}
	/** get 장애인_등록일자 : dbpsnRgstnDt */
	public String  getDbpsnRgstnDt() { return (String )get( ATTR_DBPSNRGSTNDT );}

	/** set 장애인_국적코드 : dbpsnNatnCd */
	public void setDbpsnNatnCd(String  dbpsnNatnCd) { set( ATTR_DBPSNNATNCD ,dbpsnNatnCd);}
	/** get 장애인_국적코드 : dbpsnNatnCd */
	public String  getDbpsnNatnCd() { return (String )get( ATTR_DBPSNNATNCD );}

	/** set 외국인_체류자격코드 : frgnrStyQftntCd */
	public void setFrgnrStyQftntCd(String  frgnrStyQftntCd) { set( ATTR_FRGNRSTYQFTNTCD ,frgnrStyQftntCd);}
	/** get 외국인_체류자격코드 : frgnrStyQftntCd */
	public String  getFrgnrStyQftntCd() { return (String )get( ATTR_FRGNRSTYQFTNTCD );}

	/** set 외국인_체류시작일자 : frgnrStyBgnnDt */
	public void setFrgnrStyBgnnDt(String  frgnrStyBgnnDt) { set( ATTR_FRGNRSTYBGNNDT ,frgnrStyBgnnDt);}
	/** get 외국인_체류시작일자 : frgnrStyBgnnDt */
	public String  getFrgnrStyBgnnDt() { return (String )get( ATTR_FRGNRSTYBGNNDT );}

	/** set 외국인_체류종료일자 : frgnrStyEndDt */
	public void setFrgnrStyEndDt(String  frgnrStyEndDt) { set( ATTR_FRGNRSTYENDDT ,frgnrStyEndDt);}
	/** get 외국인_체류종료일자 : frgnrStyEndDt */
	public String  getFrgnrStyEndDt() { return (String )get( ATTR_FRGNRSTYENDDT );}

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public void setSoctyInsurCmptnDt(String  soctyInsurCmptnDt) { set( ATTR_SOCTYINSURCMPTNDT ,soctyInsurCmptnDt);}
	/** get 사회보험작성일자 : soctyInsurCmptnDt */
	public String  getSoctyInsurCmptnDt() { return (String )get( ATTR_SOCTYINSURCMPTNDT );}

	/** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public void setSocInsrAqtnEmymtNum(Long  socInsrAqtnEmymtNum) { set( ATTR_SOCINSRAQTNEMYMTNUM ,socInsrAqtnEmymtNum);}
	/** get 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	public Long  getSocInsrAqtnEmymtNum() { return (Long )get( ATTR_SOCINSRAQTNEMYMTNUM );}
	
	
	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}
	
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	
	
	/** set 전화번호(사업장) : tempComPunNm */
	public void setTempComPunNm(String  tempComPunNm) { set( ATTR_TEMPCOMPUNNM , tempComPunNm);}
	/** set 전화번호(사업장) : tempComPunNm */
	public String  getTempComPunNm() { return (String) get( ATTR_TEMPCOMPUNNM );}
	
	/** set 전화번호(가입) : tempHuPunNm */
	public void setTempHuPunNm(String  tempHuPunNm) { set( ATTR_TEMPHUPUNNM , tempHuPunNm);}
	/** set 전화번호(가입) : tempHuPunNm */
	public String  getTempHuPunNm() { return (String) get( ATTR_TEMPHUPUNNM );}
    
}
