package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr1550VO.java
 * @Description : Insr1550 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1550BM  extends MSFSimpleBaseModel implements IsSerializable   {
	
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

	/** set 취득상실구분코드 : aqtnDivCd */
	public static final String ATTR_AQTNDIVCD = "aqtnDivCd";
	
	/** set 취득상실구분 : aqtnDivNm */
	public static final String ATTR_AQTNDIVNM = "aqtnDivNm";

	/** set 취득일자 : aqtnDt */
	public static final String ATTR_AQTNDT = "aqtnDt";

	/** set 취득상실사유코드 : aqtnReasCd */
	public static final String ATTR_AQTNREASCD = "aqtnReasCd";
	
	/** set 취득상실사유 : aqtnReasNm */
	public static final String ATTR_AQTNREASNM = "aqtnReasNm";

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
	
	/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
	public static final String ATTR_SOCRAQTNFAMYYN = "socrAqtnFamyYn";
	
	/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
	public static final String ATTR_SOCRLSSFAMYYN = "socrLssFamyYn";

	/** set 사회보험취득_신고 작성일자 : famyAqtnLssDt */
	public static final String ATTR_FAMYAQTNLSSDT = "famyAqtnLssDt";

	/** set 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	public static final String ATTR_FAMYAQTNLSSNUM = "famyAqtnLssNum";
	
	/** set 가입자 이름 : useHanNm */
	public static final String ATTR_USEHANNM = "useHanNm";
	
	/** set 가입자 주민번호 : useResnRegnNum */
	public static final String ATTR_USERESNREGNNUM = "useResnRegnNum";
	
	/** set 가입자 주민번호 : useSecRegnNum */
	public static final String ATTR_USESECREGNNUM = "useSecRegnNum";
	
	/** set 사업장 전화번호 : insrdpobphnnum */
	public static final String ATTR_INSRDPOBPHNNUM = "insrDpobPhnNum";
	
	/** set 가입자 전화번호 : insrusephnnum */
	public static final String ATTR_INSRUSEPHNNUM = "insrUsePhnNum";
	
	
	/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
	public static final String ATTR_SOCRAQTNLSSFAMYYN = "socrAqtnLssFamyYn";
	
	
	/** 생성자 */
	 public Insr1550BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr1550BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  famySeilNum 
			, String  famyRelaDivCd 
			, String  famyNm 
			, String  famyResnRegnNum 
			, String  relaSgn 
			, String  aqtnDivCd 
			, String  aqtnDt 
			, String  aqtnReasCd 
			, String  dbpsnAssttnSgnCd 
			, String  dbpsnGrdeCd 
			, String  dbpsnRgstnDt 
			, String  dbpsnNatnCd 
			, String  frgnrStyQftntCd 
			, String  frgnrStyBgnnDt 
			, String  frgnrStyEndDt 
			, String  socrAqtnFamyYn
			, String  socrLssFamyYn
			, String  famyAqtnLssDt 
			, Long    famyAqtnLssNum
			, String  socrAqtnLssFamyYn) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	
	 	values.put(ATTR_FAMYSEILNUM,famySeilNum);
	 	values.put(ATTR_FAMYRELADIVCD,famyRelaDivCd);
	 	values.put(ATTR_FAMYNM,famyNm);
	 	values.put(ATTR_FAMYRESNREGNNUM,famyResnRegnNum);
	 	values.put(ATTR_RELASGN,relaSgn);
	 	values.put(ATTR_AQTNDIVCD,aqtnDivCd);
	 	values.put(ATTR_AQTNDT,aqtnDt);
	 	values.put(ATTR_AQTNREASCD,aqtnReasCd);
	 	values.put(ATTR_DBPSNASSTTNSGNCD,dbpsnAssttnSgnCd);
	 	values.put(ATTR_DBPSNGRDECD,dbpsnGrdeCd);
	 	values.put(ATTR_DBPSNRGSTNDT,dbpsnRgstnDt);
	 	values.put(ATTR_DBPSNNATNCD,dbpsnNatnCd);
	 	values.put(ATTR_FRGNRSTYQFTNTCD,frgnrStyQftntCd);
	 	values.put(ATTR_FRGNRSTYBGNNDT,frgnrStyBgnnDt);
	 	values.put(ATTR_FRGNRSTYENDDT,frgnrStyEndDt);
	 	values.put(ATTR_SOCRAQTNFAMYYN,socrAqtnFamyYn);
	 	values.put(ATTR_SOCRLSSFAMYYN,socrLssFamyYn);
	 	values.put(ATTR_FAMYAQTNLSSDT,famyAqtnLssDt);
	 	values.put(ATTR_FAMYAQTNLSSNUM,famyAqtnLssNum); 
	 	values.put(ATTR_SOCRAQTNLSSFAMYYN,socrAqtnLssFamyYn);} 

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

	/** set 가족주민등록번호 : famyResnRegnNum */
	public void setFamyResnRegnNum(String  famyResnRegnNum) { set( ATTR_FAMYRESNREGNNUM ,famyResnRegnNum);}
	/** get 가족주민등록번호 : famyResnRegnNum */
	public String  getFamyResnRegnNum() { return (String )get( ATTR_FAMYRESNREGNNUM );}

	/** set 관계부호 : relaSgn */
	public void setRelaSgn(String  relaSgn) { set( ATTR_RELASGN ,relaSgn);}
	/** get 관계부호 : relaSgn */
	public String  getRelaSgn() { return (String )get( ATTR_RELASGN );}

	/** set 취득상실구분코드 : aqtnLssDivCd */
	public void setAqtnDivCd(String  aqtnDivCd) { set( ATTR_AQTNDIVCD ,aqtnDivCd);}
	/** get 취득상실구분코드 : aqtnLssDivCd */
	public String  getAqtnDivCd() { return (String )get( ATTR_AQTNDIVCD );}
	
	/** set 취득상실구분코드 : aqtnLssDivCd */
	public void setAqtnDivNm(String  aqtnDivNm) { set( ATTR_AQTNDIVNM ,aqtnDivNm);}
	/** get 취득상실구분코드 : aqtnLssDivCd */
	public String  getAqtnDivNm() { return (String )get( ATTR_AQTNDIVNM );}

	/** set 취득일자 : aqtnDt */
	public void setAqtnDt(String  aqtnDt) { set( ATTR_AQTNDT ,aqtnDt);}
	/** get 취득일자 : aqtnDt */
	public String  getAqtnDt() { return (String )get( ATTR_AQTNDT );}

	/** set 취득상실사유코드 : aqtnReasCd */
	public void setAqtnReasCd(String  aqtnReasCd) { set( ATTR_AQTNREASCD ,aqtnReasCd);}
	/** get 취득상실사유코드 : aqtnReasCd */
	public String  getAqtnReasCd() { return (String )get( ATTR_AQTNREASCD );}
	
	/** set 취득상실사유코드 : aqtnReasNm */
	public void setAqtnReasNm(String  aqtnReasNm) { set( ATTR_AQTNREASNM ,aqtnReasNm);}
	/** get 취득상실사유코드 : aqtnReasNm */
	public String  getAqtnReasNm() { return (String )get( ATTR_AQTNREASNM );}

	/** set 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public void setDbpsnAssttnSgnCd(String  dbpsnAssttnSgnCd) { set( ATTR_DBPSNASSTTNSGNCD ,dbpsnAssttnSgnCd);}
	/** get 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public String  getDbpsnAssttnSgnCd() { return (String )get( ATTR_DBPSNASSTTNSGNCD );}
	
	/** set 장애인_종별부호코드 : dbpsnAssttnSgnNm */
	public void setDbpsnAssttnSgnNm(String  dbpsnAssttnSgnNm) { set( ATTR_DBPSNASSTTNSGNNM ,dbpsnAssttnSgnNm);}
	/** get 장애인_종별부호코드 : dbpsnAssttnSgnNm */
	public String  getDbpsnAssttnSgnNm() { return (String )get( ATTR_DBPSNASSTTNSGNNM );}

	/** set 장애인_등급코드 : dbpsnGrdeCd */
	public void setDbpsnGrdeCd(String  dbpsnGrdeCd) { set( ATTR_DBPSNGRDECD ,dbpsnGrdeCd);}
	/** get 장애인_등급코드 : dbpsnGrdeCd */
	public String  getDbpsnGrdeCd() { return (String )get( ATTR_DBPSNGRDECD );}
	
	/** set 장애인_등급코드 : dbpsnGrdeNm */
	public void setDbpsnGrdeNm(String  dbpsnGrdeNm) { set( ATTR_DBPSNGRDENM ,dbpsnGrdeNm);}
	/** get 장애인_등급코드 : dbpsnGrdeNm */
	public String  getDbpsnGrdeNm() { return (String )get( ATTR_DBPSNGRDENM );}

	/** set 장애인_등록일자 : dbpsnRgstnDt */
	public void setDbpsnRgstnDt(String  dbpsnRgstnDt) { set( ATTR_DBPSNRGSTNDT ,dbpsnRgstnDt);}
	/** get 장애인_등록일자 : dbpsnRgstnDt */
	public String  getDbpsnRgstnDt() { return (String )get( ATTR_DBPSNRGSTNDT );}
	
	/** set 장애인_국적코드 : dbpsnNatnCd */
	public void setDbpsnNatnCd(String  dbpsnNatnCd) { set( ATTR_DBPSNNATNCD ,dbpsnNatnCd);}
	/** get 장애인_국적코드 : dbpsnNatnCd */
	public String  getDbpsnNatnCd() { return (String )get( ATTR_DBPSNNATNCD );}
	
	/** set 장애인_국적코드 : dbpsnNatnNm */
	public void setDbpsnNatnNm(String  dbpsnNatnNm) { set( ATTR_DBPSNNATNNM ,dbpsnNatnNm);}
	/** get 장애인_국적코드 : dbpsnNatnNm */
	public String  getDbpsnNatnNm() { return (String )get( ATTR_DBPSNNATNNM );}

	/** set 외국인_체류자격코드 : frgnrStyQftntCd */
	public void setFrgnrStyQftntCd(String  frgnrStyQftntCd) { set( ATTR_FRGNRSTYQFTNTCD ,frgnrStyQftntCd);}
	/** get 외국인_체류자격코드 : frgnrStyQftntCd */
	public String  getFrgnrStyQftntCd() { return (String )get( ATTR_FRGNRSTYQFTNTCD );}
	
	/** set 외국인_체류자격코드 : frgnrStyQftntNm */
	public void setFrgnrStyQftntNm(String  frgnrStyQftntNm) { set( ATTR_FRGNRSTYQFTNTNM ,frgnrStyQftntNm);}
	/** get 외국인_체류자격코드 : frgnrStyQftntNm */
	public String  getFrgnrStyQftntNm() { return (String )get( ATTR_FRGNRSTYQFTNTNM );}

	/** set 외국인_체류시작일자 : frgnrStyBgnnDt */
	public void setFrgnrStyBgnnDt(String  frgnrStyBgnnDt) { set( ATTR_FRGNRSTYBGNNDT ,frgnrStyBgnnDt);}
	/** get 외국인_체류시작일자 : frgnrStyBgnnDt */
	public String  getFrgnrStyBgnnDt() { return (String )get( ATTR_FRGNRSTYBGNNDT );}

	/** set 사회보험 취득가족신고여부 : socrLssFamyYn */
	public void setSocrAqtnFamyYn(String  socrAqtnFamyYn) { set( ATTR_SOCRAQTNFAMYYN ,socrAqtnFamyYn);}
	/** set 사회보험 취득가족신고여부 : socrLssFamyYn */
	public String  getSocrAqtnFamyYn() { return (String )get( ATTR_SOCRAQTNFAMYYN );}
	
	/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
	public void setSocrLssFamyYn(String  socrLssFamyYn) { set( ATTR_SOCRLSSFAMYYN ,socrLssFamyYn);}
	/** set 사회보험 상실가족신고여부 : soctyInsurCmptnDt */
	public String  getSocrLssFamyYn() { return (String )get( ATTR_SOCRLSSFAMYYN );}
	
	/** set 사회보험취득_신고 작성일자 : famyAqtnLssDt */
	public void setFamyAqtnLssDt(String  famyAqtnLssDt) { set( ATTR_FAMYAQTNLSSDT ,famyAqtnLssDt);}
	/** get 사회보험취득_신고 작성일자 : famyAqtnLssDt */
	public String  getFamyAqtnLssDt() { return (String )get( ATTR_FAMYAQTNLSSDT );}

	/** set 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	public void setFamyAqtnLssNum(String  famyAqtnLssNum) { set( ATTR_FAMYAQTNLSSNUM ,famyAqtnLssNum);}
	/** get 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	public String  getFamyAqtnLssNum() { return (String )get( ATTR_FAMYAQTNLSSNUM );}
    
	/** set 가입자 이름 : useHanNm */
	public void setUseHanNm(String  useHanNm) { set( ATTR_USEHANNM ,useHanNm);}
	/** get 가입자 이름 : useHanNm */
	public String  getUseHanNm() { return (String )get( ATTR_USEHANNM );}

	/** set 가족주민등록번호 : famySecRegnNum */
	public void setFamySecRegnNum(String  famySecRegnNum) { set( ATTR_FAMYSECREGNNUM ,famySecRegnNum);}
	/** get 가족주민등록번호 : famySecRegnNum */
	public String  getFamySecRegnNum() { return (String )get( ATTR_FAMYSECREGNNUM );}
	
	
	/** set 가입자 주민번호 : useResnRegnNum */
	public void setUseResnRegnNum(String  useResnRegnNum) { set( ATTR_USERESNREGNNUM ,useResnRegnNum);}
	/** get 가입자 주민번호 : useResnRegnNum */
	public String getUseResnRegnNum() { return (String )get( ATTR_USERESNREGNNUM );}
	

	/** set 가입자 주민번호 : useSecRegnNum */
	public void setUseSecRegnNum(String  useSecRegnNum) { set( ATTR_USESECREGNNUM ,useSecRegnNum);}
	/** get 가입자 주민번호 : useSecRegnNum */
	public String getUseSecRegnNum() { return (String )get( ATTR_USESECREGNNUM );}
	
	/** set 사업장 전화번호 : insrDpobPhnNum */
	public void setInsrDpobPhnNum(String  insrDpobPhnNum) { set( ATTR_INSRDPOBPHNNUM ,insrDpobPhnNum);}
	/** get 사업장 전화번호 : insrDpobPhnNum */
	public String  getInsrDpobPhnNum() { return (String )get( ATTR_INSRDPOBPHNNUM );}
	
	/** set 가입자 전화번호 : insrUsePhnNum */
	public void setInsrUsePhnNum(String  insrUsePhnNum) { set( ATTR_INSRUSEPHNNUM ,insrUsePhnNum);}
	/** get 가입자 전화번호 : insrUsePhnNum */
	public String  getInsrUsePhnNum() { return (String )get( ATTR_INSRUSEPHNNUM );}


	/** set 사회보험 취득/상실 가족신고여부 : socrAqtnLssFamyYn */
	public void setSocrAqtnLssFamyYn(String  socrAqtnLssFamyYn) { set( ATTR_SOCRAQTNLSSFAMYYN ,socrAqtnLssFamyYn);}
	/** set 사회보험 취득/상실 가족신고여부 : socrAqtnLssFamyYn */
	public String  getSocrAqtnLssFamyYn() { return (String )get( ATTR_SOCRAQTNLSSFAMYYN );}
}
