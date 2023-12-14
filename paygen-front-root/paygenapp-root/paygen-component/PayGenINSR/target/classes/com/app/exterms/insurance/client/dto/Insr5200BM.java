package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr5200VO.java
 * @Description : Insr5200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5200BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 납부년월 : dducYrMnth */
	public static final String ATTR_DDUCYRMNTH = "dducYrMnth";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 부과년월 : iposYrMnth */
	public static final String ATTR_IPOSYRMNTH = "iposYrMnth";

	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";

	/** set 고용시작일자 : umytInsrBgnnDt */
	public static final String ATTR_UMYTINSRBGNNDT = "umytInsrBgnnDt";

	/** set 고용종료일자 : umytInsrEndDt */
	public static final String ATTR_UMYTINSRENDDT = "umytInsrEndDt";

	/** set 월평균보수월액 : mnthAvgPayMnthAmnt */
	public static final String ATTR_MNTHAVGPAYMNTHAMNT = "mnthAvgPayMnthAmnt";

	/** set 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
	public static final String ATTR_CMPTTNWKPPUNEPLRTSUM = "cmpttnWkppUneplrtSum";

	/** set 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
	public static final String ATTR_CMPTTNEPLRUNEPLRTSUM = "cmpttnEplrUneplrtSum";

	/** set 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
	public static final String ATTR_CMPTTNEPLRFNCDSNINSURSUM = "cmpttnEplrFncdsnInsurSum";

	/** set 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
	public static final String ATTR_RECPTTNWKPPUNEPLRTSUM = "recpttnWkppUneplrtSum";

	/** set 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
	public static final String ATTR_RECPTTNEPLRUNEPLRTSUM = "recpttnEplrUneplrtSum";

	/** set 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
	public static final String ATTR_RECPTTNEPLRFNCDSNSUM = "recpttnEplrFncdsnSum";

	/** set 정산보수총액 : clutPayTotAmnt */
	public static final String ATTR_CLUTPAYTOTAMNT = "clutPayTotAmnt";

	/** set 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
	public static final String ATTR_CLUTWKPPUNEPLRTSUM = "clutWkppUneplrtSum";

	/** set 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
	public static final String ATTR_CLUTEPLRUNEPLRTSUM = "clutEplrUneplrtSum";

	/** set 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
	public static final String ATTR_CLUTEPLRFNCDSNSUM = "clutEplrFncdsnSum";

	/** set 고용보험요율 : umytInsrApmrt */
	public static final String ATTR_UMYTINSRAPMRT = "umytInsrApmrt";

	/** set 급여산출고용보험금액 : payCalcEmymtInsurSum */
	public static final String ATTR_PAYCALCEMYMTINSURSUM = "payCalcEmymtInsurSum";

	/** set 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
	public static final String ATTR_INDVUNEPLRTPYMTAGGRSUM = "indvUneplrtPymtAggrSum";

	/** set 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
	public static final String ATTR_EPLRUNEPLRTPYMTAGGRSUM = "eplrUneplrtPymtAggrSum";

	/** set 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
	public static final String ATTR_EPLRFNCDSNAGGRSUM = "eplrFncdsnAggrSum";

	/** set 고용보험급여공제년월 : umytPayrDducYrMnth */
	public static final String ATTR_UMYTPAYRDDUCYRMNTH = "umytPayrDducYrMnth";

	/** set 고용보험처리일자 : umytInsrPrcsDt */
	public static final String ATTR_UMYTINSRPRCSDT = "umytInsrPrcsDt";

	/** set 고용보험처리여부 : umytInsrPrcsYn */
	public static final String ATTR_UMYTINSRPRCSYN = "umytInsrPrcsYn";

	/** set 개인실업급여고용보험차액 : umytInsrPrmmSrd */
	public static final String ATTR_UMYTINSRPRMMSRD = "umytInsrPrmmSrd";

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
	 public Insr5200BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr5200BM(
			 String  dpobCd 
			, String  systemkey 
			, String  dducYrMnth 
			, Long  emymtSeilNum 
			, String  iposYrMnth 
			, String  hanNm 
			, String  resnRegnNum 
			, String  umytInsrBgnnDt 
			, String  umytInsrEndDt 
			, Long  mnthAvgPayMnthAmnt 
			, Long  cmpttnWkppUneplrtSum 
			, Long  cmpttnEplrUneplrtSum 
			, Long  cmpttnEplrFncdsnInsurSum 
			, Long  recpttnWkppUneplrtSum 
			, Long  recpttnEplrUneplrtSum 
			, Long  recpttnEplrFncdsnSum 
			, Long  clutPayTotAmnt 
			, Long  clutWkppUneplrtSum 
			, Long  clutEplrUneplrtSum 
			, Long  clutEplrFncdsnSum 
			, Long  umytInsrApmrt 
			, Long  payCalcEmymtInsurSum 
			, Long  indvUneplrtPymtAggrSum 
			, Long  eplrUneplrtPymtAggrSum 
			, Long  eplrFncdsnAggrSum 
			, String  umytPayrDducYrMnth 
			, String  umytInsrPrcsDt 
			, String  umytInsrPrcsYn 
			, Long  umytInsrPrmmSrd 
			, String  divdPymtDivCd 
			, Long  divdPymt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_DDUCYRMNTH,dducYrMnth);
	 	values.put(ATTR_EMYMTSEILNUM,emymtSeilNum);
	 	values.put(ATTR_IPOSYRMNTH,iposYrMnth);
	 	values.put(ATTR_HANNM,hanNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_UMYTINSRBGNNDT,umytInsrBgnnDt);
	 	values.put(ATTR_UMYTINSRENDDT,umytInsrEndDt);
	 	values.put(ATTR_MNTHAVGPAYMNTHAMNT,mnthAvgPayMnthAmnt);
	 	values.put(ATTR_CMPTTNWKPPUNEPLRTSUM,cmpttnWkppUneplrtSum);
	 	values.put(ATTR_CMPTTNEPLRUNEPLRTSUM,cmpttnEplrUneplrtSum);
	 	values.put(ATTR_CMPTTNEPLRFNCDSNINSURSUM,cmpttnEplrFncdsnInsurSum);
	 	values.put(ATTR_RECPTTNWKPPUNEPLRTSUM,recpttnWkppUneplrtSum);
	 	values.put(ATTR_RECPTTNEPLRUNEPLRTSUM,recpttnEplrUneplrtSum);
	 	values.put(ATTR_RECPTTNEPLRFNCDSNSUM,recpttnEplrFncdsnSum);
	 	values.put(ATTR_CLUTPAYTOTAMNT,clutPayTotAmnt);
	 	values.put(ATTR_CLUTWKPPUNEPLRTSUM,clutWkppUneplrtSum);
	 	values.put(ATTR_CLUTEPLRUNEPLRTSUM,clutEplrUneplrtSum);
	 	values.put(ATTR_CLUTEPLRFNCDSNSUM,clutEplrFncdsnSum);
	 	values.put(ATTR_UMYTINSRAPMRT,umytInsrApmrt);
	 	values.put(ATTR_PAYCALCEMYMTINSURSUM,payCalcEmymtInsurSum);
	 	values.put(ATTR_INDVUNEPLRTPYMTAGGRSUM,indvUneplrtPymtAggrSum);
	 	values.put(ATTR_EPLRUNEPLRTPYMTAGGRSUM,eplrUneplrtPymtAggrSum);
	 	values.put(ATTR_EPLRFNCDSNAGGRSUM,eplrFncdsnAggrSum);
	 	values.put(ATTR_UMYTPAYRDDUCYRMNTH,umytPayrDducYrMnth);
	 	values.put(ATTR_UMYTINSRPRCSDT,umytInsrPrcsDt);
	 	values.put(ATTR_UMYTINSRPRCSYN,umytInsrPrcsYn);
	 	values.put(ATTR_UMYTINSRPRMMSRD,umytInsrPrmmSrd);
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
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
	/** set 납부년월 : dducYrMnth */
	public void setDducYrMnth(String  dducYrMnth) { set( ATTR_DDUCYRMNTH ,dducYrMnth);}
	/** get 납부년월 : dducYrMnth */
	public String  getDducYrMnth() { return (String )get( ATTR_DDUCYRMNTH );}
	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}
	/** set 부과년월 : iposYrMnth */
	public void setIposYrMnth(String  iposYrMnth) { set( ATTR_IPOSYRMNTH ,iposYrMnth);}
	/** get 부과년월 : iposYrMnth */
	public String  getIposYrMnth() { return (String )get( ATTR_IPOSYRMNTH );}
	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	/** set 고용시작일자 : umytInsrBgnnDt */
	public void setUmytInsrBgnnDt(String  umytInsrBgnnDt) { set( ATTR_UMYTINSRBGNNDT ,umytInsrBgnnDt);}
	/** get 고용시작일자 : umytInsrBgnnDt */
	public String  getUmytInsrBgnnDt() { return (String )get( ATTR_UMYTINSRBGNNDT );}
	/** set 고용종료일자 : umytInsrEndDt */
	public void setUmytInsrEndDt(String  umytInsrEndDt) { set( ATTR_UMYTINSRENDDT ,umytInsrEndDt);}
	/** get 고용종료일자 : umytInsrEndDt */
	public String  getUmytInsrEndDt() { return (String )get( ATTR_UMYTINSRENDDT );}
	/** set 월평균보수월액 : mnthAvgPayMnthAmnt */
	public void setMnthAvgPayMnthAmnt(Long  mnthAvgPayMnthAmnt) { set( ATTR_MNTHAVGPAYMNTHAMNT ,mnthAvgPayMnthAmnt);}
	/** get 월평균보수월액 : mnthAvgPayMnthAmnt */
	public Long  getMnthAvgPayMnthAmnt() { return (Long )get( ATTR_MNTHAVGPAYMNTHAMNT );}
	/** set 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
	public void setCmpttnWkppUneplrtSum(Long  cmpttnWkppUneplrtSum) { set( ATTR_CMPTTNWKPPUNEPLRTSUM ,cmpttnWkppUneplrtSum);}
	/** get 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
	public Long  getCmpttnWkppUneplrtSum() { return (Long )get( ATTR_CMPTTNWKPPUNEPLRTSUM );}
	/** set 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
	public void setCmpttnEplrUneplrtSum(Long  cmpttnEplrUneplrtSum) { set( ATTR_CMPTTNEPLRUNEPLRTSUM ,cmpttnEplrUneplrtSum);}
	/** get 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
	public Long  getCmpttnEplrUneplrtSum() { return (Long )get( ATTR_CMPTTNEPLRUNEPLRTSUM );}
	/** set 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
	public void setCmpttnEplrFncdsnInsurSum(Long  cmpttnEplrFncdsnInsurSum) { set( ATTR_CMPTTNEPLRFNCDSNINSURSUM ,cmpttnEplrFncdsnInsurSum);}
	/** get 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
	public Long  getCmpttnEplrFncdsnInsurSum() { return (Long )get( ATTR_CMPTTNEPLRFNCDSNINSURSUM );}
	/** set 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
	public void setRecpttnWkppUneplrtSum(Long  recpttnWkppUneplrtSum) { set( ATTR_RECPTTNWKPPUNEPLRTSUM ,recpttnWkppUneplrtSum);}
	/** get 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
	public Long  getRecpttnWkppUneplrtSum() { return (Long )get( ATTR_RECPTTNWKPPUNEPLRTSUM );}
	/** set 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
	public void setRecpttnEplrUneplrtSum(Long  recpttnEplrUneplrtSum) { set( ATTR_RECPTTNEPLRUNEPLRTSUM ,recpttnEplrUneplrtSum);}
	/** get 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
	public Long  getRecpttnEplrUneplrtSum() { return (Long )get( ATTR_RECPTTNEPLRUNEPLRTSUM );}
	/** set 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
	public void setRecpttnEplrFncdsnSum(Long  recpttnEplrFncdsnSum) { set( ATTR_RECPTTNEPLRFNCDSNSUM ,recpttnEplrFncdsnSum);}
	/** get 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
	public Long  getRecpttnEplrFncdsnSum() { return (Long )get( ATTR_RECPTTNEPLRFNCDSNSUM );}
	/** set 정산보수총액 : clutPayTotAmnt */
	public void setClutPayTotAmnt(Long  clutPayTotAmnt) { set( ATTR_CLUTPAYTOTAMNT ,clutPayTotAmnt);}
	/** get 정산보수총액 : clutPayTotAmnt */
	public Long  getClutPayTotAmnt() { return (Long )get( ATTR_CLUTPAYTOTAMNT );}
	/** set 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
	public void setClutWkppUneplrtSum(Long  clutWkppUneplrtSum) { set( ATTR_CLUTWKPPUNEPLRTSUM ,clutWkppUneplrtSum);}
	/** get 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
	public Long  getClutWkppUneplrtSum() { return (Long )get( ATTR_CLUTWKPPUNEPLRTSUM );}
	/** set 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
	public void setClutEplrUneplrtSum(Long  clutEplrUneplrtSum) { set( ATTR_CLUTEPLRUNEPLRTSUM ,clutEplrUneplrtSum);}
	/** get 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
	public Long  getClutEplrUneplrtSum() { return (Long )get( ATTR_CLUTEPLRUNEPLRTSUM );}
	/** set 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
	public void setClutEplrFncdsnSum(Long  clutEplrFncdsnSum) { set( ATTR_CLUTEPLRFNCDSNSUM ,clutEplrFncdsnSum);}
	/** get 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
	public Long  getClutEplrFncdsnSum() { return (Long )get( ATTR_CLUTEPLRFNCDSNSUM );}
	/** set 고용보험요율 : umytInsrApmrt */
	public void setUmytInsrApmrt(Long  umytInsrApmrt) { set( ATTR_UMYTINSRAPMRT ,umytInsrApmrt);}
	/** get 고용보험요율 : umytInsrApmrt */
	public Long  getUmytInsrApmrt() { return (Long )get( ATTR_UMYTINSRAPMRT );}
	/** set 급여산출고용보험금액 : payCalcEmymtInsurSum */
	public void setPayCalcEmymtInsurSum(Long  payCalcEmymtInsurSum) { set( ATTR_PAYCALCEMYMTINSURSUM ,payCalcEmymtInsurSum);}
	/** get 급여산출고용보험금액 : payCalcEmymtInsurSum */
	public Long  getPayCalcEmymtInsurSum() { return (Long )get( ATTR_PAYCALCEMYMTINSURSUM );}
	/** set 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
	public void setIndvUneplrtPymtAggrSum(Long  indvUneplrtPymtAggrSum) { set( ATTR_INDVUNEPLRTPYMTAGGRSUM ,indvUneplrtPymtAggrSum);}
	/** get 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
	public Long  getIndvUneplrtPymtAggrSum() { return (Long )get( ATTR_INDVUNEPLRTPYMTAGGRSUM );}
	/** set 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
	public void setEplrUneplrtPymtAggrSum(Long  eplrUneplrtPymtAggrSum) { set( ATTR_EPLRUNEPLRTPYMTAGGRSUM ,eplrUneplrtPymtAggrSum);}
	/** get 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
	public Long  getEplrUneplrtPymtAggrSum() { return (Long )get( ATTR_EPLRUNEPLRTPYMTAGGRSUM );}
	/** set 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
	public void setEplrFncdsnAggrSum(Long  eplrFncdsnAggrSum) { set( ATTR_EPLRFNCDSNAGGRSUM ,eplrFncdsnAggrSum);}
	/** get 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
	public Long  getEplrFncdsnAggrSum() { return (Long )get( ATTR_EPLRFNCDSNAGGRSUM );}
	/** set 고용보험급여공제년월 : umytPayrDducYrMnth */
	public void setUmytPayrDducYrMnth(String  umytPayrDducYrMnth) { set( ATTR_UMYTPAYRDDUCYRMNTH ,umytPayrDducYrMnth);}
	/** get 고용보험급여공제년월 : umytPayrDducYrMnth */
	public String  getUmytPayrDducYrMnth() { return (String )get( ATTR_UMYTPAYRDDUCYRMNTH );}
	/** set 고용보험처리일자 : umytInsrPrcsDt */
	public void setUmytInsrPrcsDt(String  umytInsrPrcsDt) { set( ATTR_UMYTINSRPRCSDT ,umytInsrPrcsDt);}
	/** get 고용보험처리일자 : umytInsrPrcsDt */
	public String  getUmytInsrPrcsDt() { return (String )get( ATTR_UMYTINSRPRCSDT );}
	/** set 고용보험처리여부 : umytInsrPrcsYn */
	public void setUmytInsrPrcsYn(String  umytInsrPrcsYn) { set( ATTR_UMYTINSRPRCSYN ,umytInsrPrcsYn);}
	/** get 고용보험처리여부 : umytInsrPrcsYn */
	public String  getUmytInsrPrcsYn() { return (String )get( ATTR_UMYTINSRPRCSYN );}
	/** set 개인실업급여고용보험차액 : umytInsrPrmmSrd */
	public void setUmytInsrPrmmSrd(Long  umytInsrPrmmSrd) { set( ATTR_UMYTINSRPRMMSRD ,umytInsrPrmmSrd);}
	/** get 개인실업급여고용보험차액 : umytInsrPrmmSrd */
	public Long  getUmytInsrPrmmSrd() { return (Long )get( ATTR_UMYTINSRPRMMSRD );}
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
    
}
