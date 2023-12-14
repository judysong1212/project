package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3300VO.java
 * @Description : Insr3300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3300BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 고지년월 : nofctYrMnth */
	public static final String ATTR_NOFCTYRMNTH = "nofctYrMnth";

	/** set 고지차수 : nofctDspty */
	public static final String ATTR_NOFCTDSPTY = "nofctDspty";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum"; 

	/** set 공제년월 : dducYrMnth */
	public static final String ATTR_DDUCYRMNTH = "dducYrMnth";

	/** set 건강보험처리일자 : hlthInsrPrcsDt */
	public static final String ATTR_HLTHINSRPRCSDT = "hlthInsrPrcsDt";

	/** set 건강보험처리여부 : hlthInsrPrcsYn */
	public static final String ATTR_HLTHINSRPRCSYN = "hlthInsrPrcsYn";

	/** set 건강보험보험료차액 : hlthInsrPrmmSrd */
	public static final String ATTR_HLTHINSRPRMMSRD = "hlthInsrPrmmSrd";

	/** set 장기요양보험차액 : lgtmRcptnInsurSrd */
	public static final String ATTR_LGTMRCPTNINSURSRD = "lgtmRcptnInsurSrd";
	

/** set 건강보험정산보험료 : yrtxPrmm */
public static final String ATTR_YRTXPRMM = "yrtxPrmm";

/** set 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
public static final String ATTR_LGTMRCPTNYRTXPRMM = "lgtmRcptnYrtxPrmm";

	/** set 건강보험환급금이자 : hlthInsrRefdItrt */
	public static final String ATTR_HLTHINSRREFDITRT = "hlthInsrRefdItrt";

	/** set 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
	public static final String ATTR_LGTMRCPTNINSURREFDITRT = "lgtmRcptnInsurRefdItrt";

	/** set 차액합계 : srdAggrSum */
	public static final String ATTR_SRDAGGRSUM = "srdAggrSum";

	/** set 분할납부구분코드 : divdPymtDivCd */
	public static final String ATTR_DIVDPYMTDIVCD = "divdPymtDivCd";

	/** set 분할납부횟수 : divdPymt */
	public static final String ATTR_DIVDPYMT = "divdPymt";

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
	 public Insr3300BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3300BM(
			 String  dpobCd 
			, String  nofctYrMnth 
			, Long  nofctDspty 
			, String  systemkey 
			, String  dducYrMnth 
			, String  hlthInsrPrcsDt 
			, String  hlthInsrPrcsYn 
			, Long  hlthInsrPrmmSrd 
			, Long  lgtmRcptnInsurSrd 
			, Long  hlthInsrRefdItrt 
			, Long  lgtmRcptnInsurRefdItrt 
			, Long  srdAggrSum 
			, String  divdPymtDivCd 
			, Long  divdPymt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_NOFCTYRMNTH,nofctYrMnth);
	 	values.put(ATTR_NOFCTDSPTY,nofctDspty);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_DDUCYRMNTH,dducYrMnth);
	 	values.put(ATTR_HLTHINSRPRCSDT,hlthInsrPrcsDt);
	 	values.put(ATTR_HLTHINSRPRCSYN,hlthInsrPrcsYn);
	 	values.put(ATTR_HLTHINSRPRMMSRD,hlthInsrPrmmSrd);
	 	values.put(ATTR_LGTMRCPTNINSURSRD,lgtmRcptnInsurSrd);
	 	values.put(ATTR_HLTHINSRREFDITRT,hlthInsrRefdItrt);
	 	values.put(ATTR_LGTMRCPTNINSURREFDITRT,lgtmRcptnInsurRefdItrt);
	 	values.put(ATTR_SRDAGGRSUM,srdAggrSum);
	 	values.put(ATTR_DIVDPYMTDIVCD,divdPymtDivCd);
	 	values.put(ATTR_DIVDPYMT,divdPymt);
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

	/** set 고지년월 : nofctYrMnth */
	public void setNofctYrMnth(String  nofctYrMnth) { set( ATTR_NOFCTYRMNTH ,nofctYrMnth);}
	/** get 고지년월 : nofctYrMnth */
	public String  getNofctYrMnth() { return (String )get( ATTR_NOFCTYRMNTH );}

	/** set 고지차수 : nofctDspty */
	public void setNofctDspty(Long  nofctDspty) { set( ATTR_NOFCTDSPTY ,nofctDspty);}
	/** get 고지차수 : nofctDspty */
	public Long  getNofctDspty() { return (Long )get( ATTR_NOFCTDSPTY );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );} 

	/** set 공제년월 : dducYrMnth */
	public void setDducYrMnth(String  dducYrMnth) { set( ATTR_DDUCYRMNTH ,dducYrMnth);}
	/** get 공제년월 : dducYrMnth */
	public String  getDducYrMnth() { return (String )get( ATTR_DDUCYRMNTH );}

	/** set 건강보험처리일자 : hlthInsrPrcsDt */
	public void setHlthInsrPrcsDt(String  hlthInsrPrcsDt) { set( ATTR_HLTHINSRPRCSDT ,hlthInsrPrcsDt);}
	/** get 건강보험처리일자 : hlthInsrPrcsDt */
	public String  getHlthInsrPrcsDt() { return (String )get( ATTR_HLTHINSRPRCSDT );}

	/** set 건강보험처리여부 : hlthInsrPrcsYn */
	public void setHlthInsrPrcsYn(String  hlthInsrPrcsYn) { set( ATTR_HLTHINSRPRCSYN ,hlthInsrPrcsYn);}
	/** get 건강보험처리여부 : hlthInsrPrcsYn */
	public String  getHlthInsrPrcsYn() { return (String )get( ATTR_HLTHINSRPRCSYN );}

	/** set 건강보험보험료차액 : hlthInsrPrmmSrd */
	public void setHlthInsrPrmmSrd(Long  hlthInsrPrmmSrd) { set( ATTR_HLTHINSRPRMMSRD ,hlthInsrPrmmSrd);}
	/** get 건강보험보험료차액 : hlthInsrPrmmSrd */
	public Long  getHlthInsrPrmmSrd() { return (Long )get( ATTR_HLTHINSRPRMMSRD );}

	/** set 장기요양보험차액 : lgtmRcptnInsurSrd */
	public void setLgtmRcptnInsurSrd(Long  lgtmRcptnInsurSrd) { set( ATTR_LGTMRCPTNINSURSRD ,lgtmRcptnInsurSrd);}
	/** get 장기요양보험차액 : lgtmRcptnInsurSrd */
	public Long  getLgtmRcptnInsurSrd() { return (Long )get( ATTR_LGTMRCPTNINSURSRD );}

	/** set 건강보험환급금이자 : hlthInsrRefdItrt */
	public void setHlthInsrRefdItrt(Long  hlthInsrRefdItrt) { set( ATTR_HLTHINSRREFDITRT ,hlthInsrRefdItrt);}
	/** get 건강보험환급금이자 : hlthInsrRefdItrt */
	public Long  getHlthInsrRefdItrt() { return (Long )get( ATTR_HLTHINSRREFDITRT );}

	/** set 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
	public void setLgtmRcptnInsurRefdItrt(Long  lgtmRcptnInsurRefdItrt) { set( ATTR_LGTMRCPTNINSURREFDITRT ,lgtmRcptnInsurRefdItrt);}
	/** get 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
	public Long  getLgtmRcptnInsurRefdItrt() { return (Long )get( ATTR_LGTMRCPTNINSURREFDITRT );}

	/** set 차액합계 : srdAggrSum */
	public void setSrdAggrSum(Long  srdAggrSum) { set( ATTR_SRDAGGRSUM ,srdAggrSum);}
	/** get 차액합계 : srdAggrSum */
	public Long  getSrdAggrSum() { return (Long )get( ATTR_SRDAGGRSUM );}

	/** set 분할납부구분코드 : divdPymtDivCd */
	public void setDivdPymtDivCd(String  divdPymtDivCd) { set( ATTR_DIVDPYMTDIVCD ,divdPymtDivCd);}
	/** get 분할납부구분코드 : divdPymtDivCd */
	public String  getDivdPymtDivCd() { return (String )get( ATTR_DIVDPYMTDIVCD );}

	/** set 분할납부횟수 : divdPymt */
	public void setDivdPymt(Long  divdPymt) { set( ATTR_DIVDPYMT ,divdPymt);}
	/** get 분할납부횟수 : divdPymt */
	public Long  getDivdPymt() { return (Long )get( ATTR_DIVDPYMT );}

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


/** set 건강보험정산보험료 : yrtxPrmm */
public void setYrtxPrmm(Long  yrtxPrmm) { set( ATTR_YRTXPRMM ,yrtxPrmm);}
/** get 건강보험정산보험료 : yrtxPrmm */
public Long  getYrtxPrmm() { return (Long )get( ATTR_YRTXPRMM );}

/** set 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
public void setLgtmRcptnYrtxPrmm(Long  lgtmRcptnYrtxPrmm) { set( ATTR_LGTMRCPTNYRTXPRMM ,lgtmRcptnYrtxPrmm);}
/** get 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
public Long  getLgtmRcptnYrtxPrmm() { return (Long )get( ATTR_LGTMRCPTNYRTXPRMM );}

    
}
