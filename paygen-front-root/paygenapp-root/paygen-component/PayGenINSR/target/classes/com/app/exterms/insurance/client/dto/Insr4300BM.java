package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr4200VO.java
 * @Description : Insr4200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4300BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 국민연금일련번호 : natPennSeilNum */
	//public static final String ATTR_NATPENNSEILNUM = "natPennSeilNum";
	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";
	
	/** set 연금결정년도 : antyDeinYr */
	public static final String ATTR_ANTYDEINYR = "antyDeinYr";

	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";


	/** set 연금총근무일수 : antyTotDutyNumDys */
	public static final String ATTR_ANTYTOTDUTYNUMDYS = "antyTotDutyNumDys";

	/** set 연금소득총액 : antyIncmTotAmnt */
	public static final String ATTR_ANTYINCMTOTAMNT = "antyIncmTotAmnt";

	/** set 연금기준소득월액 : antyStdIncmMnthAmnt */
	public static final String ATTR_ANTYSTDINCMMNTHAMNT = "antyStdIncmMnthAmnt";

	/** set 연금월보험료 : antyMnthPrmm */
	public static final String ATTR_ANTYMNTHPRMM = "antyMnthPrmm";

	/** set 종전기준소득월액 : bfrStdIncmMnthAmnt */
	public static final String ATTR_BFRSTDINCMMNTHAMNT = "bfrStdIncmMnthAmnt";

	/** set 과세자료결정여부 : txtnDataDeinYn */
	public static final String ATTR_TXTNDATADEINYN = "txtnDataDeinYn";

	/** set 공단직권결정여부 : pbcorpOautyDeinYn */
	public static final String ATTR_PBCORPOAUTYDEINYN = "pbcorpOautyDeinYn";

	/** set 연금급여반영여부 : antyPayRflctnYn */
	public static final String ATTR_ANTYPAYRFLCTNYN = "antyPayRflctnYn";

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

	/** 생성자 */
	 public Insr4300BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr4300BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  natPennSeilNum 
			, String  antyDeinYr 
			, String  hanNm 
			, String  resnRegnNum 
			, Long  antyTotDutyNumDys 
			, Long  antyIncmTotAmnt 
			, Long  antyStdIncmMnthAmnt 
			, Long  antyMnthPrmm 
			, Long  bfrStdIncmMnthAmnt 
			, String  txtnDataDeinYn 
			, String  pbcorpOautyDeinYn 
			, String  antyPayRflctnYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	//values.put(ATTR_NATPENNSEILNUM,natPennSeilNum);
	 	values.put(ATTR_ANTYDEINYR,antyDeinYr);
	 	values.put(ATTR_HANNM,hanNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_ANTYTOTDUTYNUMDYS,antyTotDutyNumDys);
	 	values.put(ATTR_ANTYINCMTOTAMNT,antyIncmTotAmnt);
	 	values.put(ATTR_ANTYSTDINCMMNTHAMNT,antyStdIncmMnthAmnt);
	 	values.put(ATTR_ANTYMNTHPRMM,antyMnthPrmm);
	 	values.put(ATTR_BFRSTDINCMMNTHAMNT,bfrStdIncmMnthAmnt);
	 	values.put(ATTR_TXTNDATADEINYN,txtnDataDeinYn);
	 	values.put(ATTR_PBCORPOAUTYDEINYN,pbcorpOautyDeinYn);
	 	values.put(ATTR_ANTYPAYRFLCTNYN,antyPayRflctnYn);
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

//	/** set 국민연금일련번호 : natPennSeilNum */
//	public void setNatPennSeilNum(Long  natPennSeilNum) { set( ATTR_NATPENNSEILNUM ,natPennSeilNum);}
//	/** get 국민연금일련번호 : natPennSeilNum */
//	public Long  getNatPennSeilNum() { return (Long )get( ATTR_NATPENNSEILNUM );}

	
	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}
	
	/** set 연금결정년도 : antyDeinYr */
	public void setAntyDeinYr(String  antyDeinYr) { set( ATTR_ANTYDEINYR ,antyDeinYr);}
	/** get 연금결정년도 : antyDeinYr */
	public String  getAntyDeinYr() { return (String )get( ATTR_ANTYDEINYR );}

	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 연금총근무일수 : antyTotDutyNumDys */
	public void setAntyTotDutyNumDys(Long  antyTotDutyNumDys) { set( ATTR_ANTYTOTDUTYNUMDYS ,antyTotDutyNumDys);}
	/** get 연금총근무일수 : antyTotDutyNumDys */
	public Long  getAntyTotDutyNumDys() { return (Long )get( ATTR_ANTYTOTDUTYNUMDYS );}

	/** set 연금소득총액 : antyIncmTotAmnt */
	public void setAntyIncmTotAmnt(Long  antyIncmTotAmnt) { set( ATTR_ANTYINCMTOTAMNT ,antyIncmTotAmnt);}
	/** get 연금소득총액 : antyIncmTotAmnt */
	public Long  getAntyIncmTotAmnt() { return (Long )get( ATTR_ANTYINCMTOTAMNT );}

	/** set 연금기준소득월액 : antyStdIncmMnthAmnt */
	public void setAntyStdIncmMnthAmnt(Long  antyStdIncmMnthAmnt) { set( ATTR_ANTYSTDINCMMNTHAMNT ,antyStdIncmMnthAmnt);}
	/** get 연금기준소득월액 : antyStdIncmMnthAmnt */
	public Long  getAntyStdIncmMnthAmnt() { return (Long )get( ATTR_ANTYSTDINCMMNTHAMNT );}

	/** set 연금월보험료 : antyMnthPrmm */
	public void setAntyMnthPrmm(Long  antyMnthPrmm) { set( ATTR_ANTYMNTHPRMM ,antyMnthPrmm);}
	/** get 연금월보험료 : antyMnthPrmm */
	public Long  getAntyMnthPrmm() { return (Long )get( ATTR_ANTYMNTHPRMM );}

	/** set 종전기준소득월액 : bfrStdIncmMnthAmnt */
	public void setBfrStdIncmMnthAmnt(Long  bfrStdIncmMnthAmnt) { set( ATTR_BFRSTDINCMMNTHAMNT ,bfrStdIncmMnthAmnt);}
	/** get 종전기준소득월액 : bfrStdIncmMnthAmnt */
	public Long  getBfrStdIncmMnthAmnt() { return (Long )get( ATTR_BFRSTDINCMMNTHAMNT );}

	/** set 과세자료결정여부 : txtnDataDeinYn */
	public void setTxtnDataDeinYn(String  txtnDataDeinYn) { set( ATTR_TXTNDATADEINYN ,txtnDataDeinYn);}
	/** get 과세자료결정여부 : txtnDataDeinYn */
	public String  getTxtnDataDeinYn() { return (String )get( ATTR_TXTNDATADEINYN );}

	/** set 공단직권결정여부 : pbcorpOautyDeinYn */
	public void setPbcorpOautyDeinYn(String  pbcorpOautyDeinYn) { set( ATTR_PBCORPOAUTYDEINYN ,pbcorpOautyDeinYn);}
	/** get 공단직권결정여부 : pbcorpOautyDeinYn */
	public String  getPbcorpOautyDeinYn() { return (String )get( ATTR_PBCORPOAUTYDEINYN );}

	/** set 연금급여반영여부 : antyPayRflctnYn */
	public void setAntyPayRflctnYn(String  antyPayRflctnYn) { set( ATTR_ANTYPAYRFLCTNYN ,antyPayRflctnYn);}
	/** get 연금급여반영여부 : antyPayRflctnYn */
	public String  getAntyPayRflctnYn() { return (String )get( ATTR_ANTYPAYRFLCTNYN );}

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



    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
}
