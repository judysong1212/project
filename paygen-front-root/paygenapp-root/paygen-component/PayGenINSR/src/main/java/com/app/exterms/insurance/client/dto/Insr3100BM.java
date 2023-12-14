package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3100VO.java
 * @Description : Insr3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3100BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 정산년월 : nofctYrMnthNum */
	public static final String ATTR_NOFCTYRMNTHNUM = "nofctYrMnthNum";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 차수 : dspty */
	public static final String ATTR_DSPTY = "dspty";
	
	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";
	
	/** set 건강보험일련번호 : hlthInsrSeilNum */
	public static final String ATTR_HLTHINSRSEILNUM = "hlthInsrSeilNum";
	
	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";
	
	/** set 부서명 : deptNm */
	public static final String ATTR_DEPTNM = "deptNm";
	
	/** set 사업장관리번호 : dpobMangeNum */
	public static final String ATTR_DPOBMANGENUM = "dpobMangeNum";

	/** set 회계 : acc */
	public static final String ATTR_ACC = "acc";

	/** set 단위사업장코드 : untDpobCd */
	public static final String ATTR_UNTDPOBCD = "untDpobCd";

	/** set 증번호 : certNumHuhd */
	public static final String ATTR_CERTNUMHUHD = "certNumHuhd";

	/** set 성명 : nm */
	public static final String ATTR_NM = "nm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";

	   /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
	/** set 부과한총보험료_계 : iposTotPrmmAggr */
	public static final String ATTR_IPOSTOTPRMMAGGR = "iposTotPrmmAggr";

	/** set 부과한총보험료_건강 : iposTotPrmmHlth */
	public static final String ATTR_IPOSTOTPRMMHLTH = "iposTotPrmmHlth";

	/** set 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
	public static final String ATTR_IPOSTOTPRMMLGTMRCPTN = "iposTotPrmmLgtmRcptn";

	/** set 연간보수총액 : yrlyPayTotAmnt */
	public static final String ATTR_YRLYPAYTOTAMNT = "yrlyPayTotAmnt";

	/** set 근무월수 : dutyMnthIcm */
	public static final String ATTR_DUTYMNTHICM = "dutyMnthIcm";

	/** set 보수월액 : payMnthAmnt */
	public static final String ATTR_PAYMNTHAMNT = "payMnthAmnt";

	/** set 연말정산_등급 : yrtxCalcBkdnGrde */
	public static final String ATTR_YRTXCALCBKDNGRDE = "yrtxCalcBkdnGrde";

	/** set 표준보수월액 : stdPayMnthAmnt */
	public static final String ATTR_STDPAYMNTHAMNT = "stdPayMnthAmnt";

	/** set 확정보험료_계 : fixPrmmAggr */
	public static final String ATTR_FIXPRMMAGGR = "fixPrmmAggr";

	/** set 확정보험료_건강 : fixPrmmHlth */
	public static final String ATTR_FIXPRMMHLTH = "fixPrmmHlth";

	/** set 확정보험료_장기요양 : fixPrmmLgtmRcptn */
	public static final String ATTR_FIXPRMMLGTMRCPTN = "fixPrmmLgtmRcptn";

	/** set 정산보험료_계 : clutPrmmAggr */
	public static final String ATTR_CLUTPRMMAGGR = "clutPrmmAggr";

	/** set 정산보험료_건강 : clutPrmmHlth */
	public static final String ATTR_CLUTPRMMHLTH = "clutPrmmHlth";

	/** set 정산보험료_장기요양 : clutPrmmLgtmRcptn */
	public static final String ATTR_CLUTPRMMLGTMRCPTN = "clutPrmmLgtmRcptn";

	/** set 가입자부담금_계 : mbrAlttAggr */
	public static final String ATTR_MBRALTTAGGR = "mbrAlttAggr";

	/** set 가입자부담금_건강 : mbrAlttHlth */
	public static final String ATTR_MBRALTTHLTH = "mbrAlttHlth";

	/** set 가입자부담금_장기요양 : mbrAlttLgtmRcptn */
	public static final String ATTR_MBRALTTLGTMRCPTN = "mbrAlttLgtmRcptn";

	/** set 사용자부담금_계 : usrAlttAggr */
	public static final String ATTR_USRALTTAGGR = "usrAlttAggr";

	/** set 사용자부담금_건강 : usrAlttHlth */
	public static final String ATTR_USRALTTHLTH = "usrAlttHlth";

	/** set 사용자부담금_장기요양 : usrAlttLgtmRcptn */
	public static final String ATTR_USRALTTLGTMRCPTN = "usrAlttLgtmRcptn";

	/** set 고지유예 : nofctSspn */
	public static final String ATTR_NOFCTSSPN = "nofctSspn";
	
	/** set 직종코드 : typOccCd */
	public static final String ATTR_TYPOCCUCD = "typOccuCd";
	
	/** set 직종명 : typOccuNm */
	public static final String ATTR_TYPOCCUNM = "typOccuNm";
	
	/** set 직종세코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
	
	/** set 직종세명 : dtilOccuClsNm */
	public static final String ATTR_DTILOCCUCLSNM = "dtilOccuClsNm";

	/** set 건강연말정산적용년월 : hlthYrtxApptnYrMnth */
	public static final String ATTR_HLTHYRTXAPPTNYRMNTH = "hlthYrtxApptnYrMnth";

	/** set 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public static final String ATTR_HLTHYRTXPRCSDT = "hlthYrtxPrcsDt";

	/** set 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public static final String ATTR_HLTHINSRYRTXPRCSYN = "hlthInsrYrtxPrcsYn";

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
	 public Insr3100BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3100BM(
			 String  dpobCd 
			, String  nofctYrMnthNum 
			, String  systemkey 
			, String  dspty
			, Long	  emymtSeilNum
			, Long    hlthInsrSeilNum 
			, String  dpobMangeNum 
			, String  acc 
			, String  untDpobCd 
			, String  certNumHuhd 
			, String  nm 
			, String  resnRegnNum 
			, Long  iposTotPrmmAggr 
			, Long  iposTotPrmmHlth 
			, Long  iposTotPrmmLgtmRcptn 
			, Long  yrlyPayTotAmnt 
			, Long  dutyMnthIcm 
			, Long  payMnthAmnt 
			, String  yrtxCalcBkdnGrde 
			, Long  stdPayMnthAmnt 
			, Long  fixPrmmAggr 
			, Long  fixPrmmHlth 
			, Long  fixPrmmLgtmRcptn 
			, Long  clutPrmmAggr 
			, Long  clutPrmmHlth 
			, Long  clutPrmmLgtmRcptn 
			, Long  mbrAlttAggr 
			, Long  mbrAlttHlth 
			, Long  mbrAlttLgtmRcptn 
			, Long  usrAlttAggr 
			, Long  usrAlttHlth 
			, Long  usrAlttLgtmRcptn 
			, String  nofctSspn 
			, String  hlthYrtxApptnYrMnth 
			, String  hlthYrtxPrcsDt 
			, String  hlthInsrYrtxPrcsYn 
			, String  divdPymtDivCd 
			, Long  divdPymt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_NOFCTYRMNTHNUM,nofctYrMnthNum);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_DSPTY,dspty);
	 	values.put(ATTR_EMYMTSEILNUM, emymtSeilNum);
	 	values.put(ATTR_HLTHINSRSEILNUM,hlthInsrSeilNum);
	 	values.put(ATTR_DPOBMANGENUM,dpobMangeNum);
	 	values.put(ATTR_ACC,acc);
	 	values.put(ATTR_UNTDPOBCD,untDpobCd);
	 	values.put(ATTR_CERTNUMHUHD,certNumHuhd);
	 	values.put(ATTR_NM,nm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_IPOSTOTPRMMAGGR,iposTotPrmmAggr);
	 	values.put(ATTR_IPOSTOTPRMMHLTH,iposTotPrmmHlth);
	 	values.put(ATTR_IPOSTOTPRMMLGTMRCPTN,iposTotPrmmLgtmRcptn);
	 	values.put(ATTR_YRLYPAYTOTAMNT,yrlyPayTotAmnt);
	 	values.put(ATTR_DUTYMNTHICM,dutyMnthIcm);
	 	values.put(ATTR_PAYMNTHAMNT,payMnthAmnt);
	 	values.put(ATTR_YRTXCALCBKDNGRDE,yrtxCalcBkdnGrde);
	 	values.put(ATTR_STDPAYMNTHAMNT,stdPayMnthAmnt);
	 	values.put(ATTR_FIXPRMMAGGR,fixPrmmAggr);
	 	values.put(ATTR_FIXPRMMHLTH,fixPrmmHlth);
	 	values.put(ATTR_FIXPRMMLGTMRCPTN,fixPrmmLgtmRcptn);
	 	values.put(ATTR_CLUTPRMMAGGR,clutPrmmAggr);
	 	values.put(ATTR_CLUTPRMMHLTH,clutPrmmHlth);
	 	values.put(ATTR_CLUTPRMMLGTMRCPTN,clutPrmmLgtmRcptn);
	 	values.put(ATTR_MBRALTTAGGR,mbrAlttAggr);
	 	values.put(ATTR_MBRALTTHLTH,mbrAlttHlth);
	 	values.put(ATTR_MBRALTTLGTMRCPTN,mbrAlttLgtmRcptn);
	 	values.put(ATTR_USRALTTAGGR,usrAlttAggr);
	 	values.put(ATTR_USRALTTHLTH,usrAlttHlth);
	 	values.put(ATTR_USRALTTLGTMRCPTN,usrAlttLgtmRcptn);
	 	values.put(ATTR_NOFCTSSPN,nofctSspn);
	 	values.put(ATTR_HLTHYRTXAPPTNYRMNTH,hlthYrtxApptnYrMnth);
	 	values.put(ATTR_HLTHYRTXPRCSDT,hlthYrtxPrcsDt);
	 	values.put(ATTR_HLTHINSRYRTXPRCSYN,hlthInsrYrtxPrcsYn);
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

	/** set 정산년월 : nofctYrMnthNum */
	public void setNofctYrMnthNum(String  nofctYrMnthNum) { set( ATTR_NOFCTYRMNTHNUM ,nofctYrMnthNum);}
	/** get 정산년월 : nofctYrMnthNum */
	public String  getNofctYrMnthNum() { return (String )get( ATTR_NOFCTYRMNTHNUM );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 차수 : dspty */
	public void setDspty(String  dspty) { set( ATTR_DSPTY ,dspty);}
	/** get 차수 : dspty */
	public String  getDspty() { return (String )get( ATTR_DSPTY );}
	
	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long emymtSeilNum) { set( ATTR_EMYMTSEILNUM, emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long getEmymtSeilNum() { return (Long)get(ATTR_EMYMTSEILNUM);}
	
	/** set 건강보험일련번호 : hlthInsrSeilNum */
	public void setHlthInsrSeilNum(Long  hlthInsrSeilNum) { set( ATTR_HLTHINSRSEILNUM ,hlthInsrSeilNum);}
	/** get 건강보험일련번호 : hlthInsrSeilNum */
	public Long  getHlthInsrSeilNum() { return (Long )get( ATTR_HLTHINSRSEILNUM );}
	
	/** set 부서 : deptNm */
	public void setDeptNm(String deptNm) { set( ATTR_DEPTNM, deptNm);}
	/** get 부서 : deptNm */
	public static String getDeptNm() { return ATTR_DEPTNM;}

	/** set 사업장관리번호 : dpobMangeNum */
	public void setDpobMangeNum(String  dpobMangeNum) { set( ATTR_DPOBMANGENUM ,dpobMangeNum);}
	/** get 사업장관리번호 : dpobMangeNum */
	public String  getDpobMangeNum() { return (String )get( ATTR_DPOBMANGENUM );}

	/** set 회계 : acc */
	public void setAcc(String  acc) { set( ATTR_ACC ,acc);}
	/** get 회계 : acc */
	public String  getAcc() { return (String )get( ATTR_ACC );}

	/** set 단위사업장코드 : untDpobCd */
	public void setUntDpobCd(String  untDpobCd) { set( ATTR_UNTDPOBCD ,untDpobCd);}
	/** get 단위사업장코드 : untDpobCd */
	public String  getUntDpobCd() { return (String )get( ATTR_UNTDPOBCD );}

	/** set 증번호 : certNumHuhd */
	public void setCertNumHuhd(String  certNumHuhd) { set( ATTR_CERTNUMHUHD ,certNumHuhd);}
	/** get 증번호 : certNumHuhd */
	public String  getCertNumHuhd() { return (String )get( ATTR_CERTNUMHUHD );}

	/** set 성명 : nm */
	public void setNm(String  nm) { set( ATTR_NM ,nm);}
	/** get 성명 : nm */
	public String  getNm() { return (String )get( ATTR_NM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 부과한총보험료_계 : iposTotPrmmAggr */
	public void setIposTotPrmmAggr(Long  iposTotPrmmAggr) { set( ATTR_IPOSTOTPRMMAGGR ,iposTotPrmmAggr);}
	/** get 부과한총보험료_계 : iposTotPrmmAggr */
	public Long  getIposTotPrmmAggr() { return (Long )get( ATTR_IPOSTOTPRMMAGGR );}

	/** set 부과한총보험료_건강 : iposTotPrmmHlth */
	public void setIposTotPrmmHlth(Long  iposTotPrmmHlth) { set( ATTR_IPOSTOTPRMMHLTH ,iposTotPrmmHlth);}
	/** get 부과한총보험료_건강 : iposTotPrmmHlth */
	public Long  getIposTotPrmmHlth() { return (Long )get( ATTR_IPOSTOTPRMMHLTH );}

	/** set 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
	public void setIposTotPrmmLgtmRcptn(Long  iposTotPrmmLgtmRcptn) { set( ATTR_IPOSTOTPRMMLGTMRCPTN ,iposTotPrmmLgtmRcptn);}
	/** get 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
	public Long  getIposTotPrmmLgtmRcptn() { return (Long )get( ATTR_IPOSTOTPRMMLGTMRCPTN );}

	/** set 연간보수총액 : yrlyPayTotAmnt */
	public void setYrlyPayTotAmnt(Long  yrlyPayTotAmnt) { set( ATTR_YRLYPAYTOTAMNT ,yrlyPayTotAmnt);}
	/** get 연간보수총액 : yrlyPayTotAmnt */
	public Long  getYrlyPayTotAmnt() { return (Long )get( ATTR_YRLYPAYTOTAMNT );}

	/** set 근무월수 : dutyMnthIcm */
	public void setDutyMnthIcm(Long  dutyMnthIcm) { set( ATTR_DUTYMNTHICM ,dutyMnthIcm);}
	/** get 근무월수 : dutyMnthIcm */
	public Long  getDutyMnthIcm() { return (Long )get( ATTR_DUTYMNTHICM );}

	/** set 보수월액 : payMnthAmnt */
	public void setPayMnthAmnt(Long  payMnthAmnt) { set( ATTR_PAYMNTHAMNT ,payMnthAmnt);}
	/** get 보수월액 : payMnthAmnt */
	public Long  getPayMnthAmnt() { return (Long )get( ATTR_PAYMNTHAMNT );}

	/** set 연말정산_등급 : yrtxCalcBkdnGrde */
	public void setYrtxCalcBkdnGrde(String  yrtxCalcBkdnGrde) { set( ATTR_YRTXCALCBKDNGRDE ,yrtxCalcBkdnGrde);}
	/** get 연말정산_등급 : yrtxCalcBkdnGrde */
	public String  getYrtxCalcBkdnGrde() { return (String )get( ATTR_YRTXCALCBKDNGRDE );}

	/** set 표준보수월액 : stdPayMnthAmnt */
	public void setStdPayMnthAmnt(Long  stdPayMnthAmnt) { set( ATTR_STDPAYMNTHAMNT ,stdPayMnthAmnt);}
	/** get 표준보수월액 : stdPayMnthAmnt */
	public Long  getStdPayMnthAmnt() { return (Long )get( ATTR_STDPAYMNTHAMNT );}

	/** set 확정보험료_계 : fixPrmmAggr */
	public void setFixPrmmAggr(Long  fixPrmmAggr) { set( ATTR_FIXPRMMAGGR ,fixPrmmAggr);}
	/** get 확정보험료_계 : fixPrmmAggr */
	public Long  getFixPrmmAggr() { return (Long )get( ATTR_FIXPRMMAGGR );}

	/** set 확정보험료_건강 : fixPrmmHlth */
	public void setFixPrmmHlth(Long  fixPrmmHlth) { set( ATTR_FIXPRMMHLTH ,fixPrmmHlth);}
	/** get 확정보험료_건강 : fixPrmmHlth */
	public Long  getFixPrmmHlth() { return (Long )get( ATTR_FIXPRMMHLTH );}

	/** set 확정보험료_장기요양 : fixPrmmLgtmRcptn */
	public void setFixPrmmLgtmRcptn(Long  fixPrmmLgtmRcptn) { set( ATTR_FIXPRMMLGTMRCPTN ,fixPrmmLgtmRcptn);}
	/** get 확정보험료_장기요양 : fixPrmmLgtmRcptn */
	public Long  getFixPrmmLgtmRcptn() { return (Long )get( ATTR_FIXPRMMLGTMRCPTN );}

	/** set 정산보험료_계 : clutPrmmAggr */
	public void setClutPrmmAggr(Long  clutPrmmAggr) { set( ATTR_CLUTPRMMAGGR ,clutPrmmAggr);}
	/** get 정산보험료_계 : clutPrmmAggr */
	public Long  getClutPrmmAggr() { return (Long )get( ATTR_CLUTPRMMAGGR );}

	/** set 정산보험료_건강 : clutPrmmHlth */
	public void setClutPrmmHlth(Long  clutPrmmHlth) { set( ATTR_CLUTPRMMHLTH ,clutPrmmHlth);}
	/** get 정산보험료_건강 : clutPrmmHlth */
	public Long  getClutPrmmHlth() { return (Long )get( ATTR_CLUTPRMMHLTH );}

	/** set 정산보험료_장기요양 : clutPrmmLgtmRcptn */
	public void setClutPrmmLgtmRcptn(Long  clutPrmmLgtmRcptn) { set( ATTR_CLUTPRMMLGTMRCPTN ,clutPrmmLgtmRcptn);}
	/** get 정산보험료_장기요양 : clutPrmmLgtmRcptn */
	public Long  getClutPrmmLgtmRcptn() { return (Long )get( ATTR_CLUTPRMMLGTMRCPTN );}

	/** set 가입자부담금_계 : mbrAlttAggr */
	public void setMbrAlttAggr(Long  mbrAlttAggr) { set( ATTR_MBRALTTAGGR ,mbrAlttAggr);}
	/** get 가입자부담금_계 : mbrAlttAggr */
	public Long  getMbrAlttAggr() { return (Long )get( ATTR_MBRALTTAGGR );}

	/** set 가입자부담금_건강 : mbrAlttHlth */
	public void setMbrAlttHlth(Long  mbrAlttHlth) { set( ATTR_MBRALTTHLTH ,mbrAlttHlth);}
	/** get 가입자부담금_건강 : mbrAlttHlth */
	public Long  getMbrAlttHlth() { return (Long )get( ATTR_MBRALTTHLTH );}

	/** set 가입자부담금_장기요양 : mbrAlttLgtmRcptn */
	public void setMbrAlttLgtmRcptn(Long  mbrAlttLgtmRcptn) { set( ATTR_MBRALTTLGTMRCPTN ,mbrAlttLgtmRcptn);}
	/** get 가입자부담금_장기요양 : mbrAlttLgtmRcptn */
	public Long  getMbrAlttLgtmRcptn() { return (Long )get( ATTR_MBRALTTLGTMRCPTN );}

	/** set 사용자부담금_계 : usrAlttAggr */
	public void setUsrAlttAggr(Long  usrAlttAggr) { set( ATTR_USRALTTAGGR ,usrAlttAggr);}
	/** get 사용자부담금_계 : usrAlttAggr */
	public Long  getUsrAlttAggr() { return (Long )get( ATTR_USRALTTAGGR );}

	/** set 사용자부담금_건강 : usrAlttHlth */
	public void setUsrAlttHlth(Long  usrAlttHlth) { set( ATTR_USRALTTHLTH ,usrAlttHlth);}
	/** get 사용자부담금_건강 : usrAlttHlth */
	public Long  getUsrAlttHlth() { return (Long )get( ATTR_USRALTTHLTH );}

	/** set 사용자부담금_장기요양 : usrAlttLgtmRcptn */
	public void setUsrAlttLgtmRcptn(Long  usrAlttLgtmRcptn) { set( ATTR_USRALTTLGTMRCPTN ,usrAlttLgtmRcptn);}
	/** get 사용자부담금_장기요양 : usrAlttLgtmRcptn */
	public Long  getUsrAlttLgtmRcptn() { return (Long )get( ATTR_USRALTTLGTMRCPTN );}

	/** set 고지유예 : nofctSspn */
	public void setNofctSspn(String  nofctSspn) { set( ATTR_NOFCTSSPN ,nofctSspn);}
	/** get 고지유예 : nofctSspn */
	public String  getNofctSspn() { return (String )get( ATTR_NOFCTSSPN );}
	
	/** set 직종 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM, typOccuNm);}
	/** get 직종 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
	
	/** set 직종세 : dtilOccuClsNm */
	public void setDtilOccuClsNm(String  dtilOccuClsNm) { set( ATTR_DTILOCCUCLSNM, dtilOccuClsNm);}
	/** get 직종세 : dtilOccuClsNm */
	public String  getDtilOccuClsNm() { return (String )get( ATTR_DTILOCCUCLSNM );}
	
	/** set 건강연말정산적용년월 : hlthYrtxApptnYrMnth */
	public void setHlthYrtxApptnYrMnth(String  hlthYrtxApptnYrMnth) { set( ATTR_HLTHYRTXAPPTNYRMNTH ,hlthYrtxApptnYrMnth);}
	/** get 건강연말정산적용년월 : hlthYrtxApptnYrMnth */
	public String  getHlthYrtxApptnYrMnth() { return (String )get( ATTR_HLTHYRTXAPPTNYRMNTH );}

	/** set 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public void setHlthYrtxPrcsDt(String  hlthYrtxPrcsDt) { set( ATTR_HLTHYRTXPRCSDT ,hlthYrtxPrcsDt);}
	/** get 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public String  getHlthYrtxPrcsDt() { return (String )get( ATTR_HLTHYRTXPRCSDT );}

	/** set 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public void setHlthInsrYrtxPrcsYn(String  hlthInsrYrtxPrcsYn) { set( ATTR_HLTHINSRYRTXPRCSYN ,hlthInsrYrtxPrcsYn);}
	/** get 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public String  getHlthInsrYrtxPrcsYn() { return (String )get( ATTR_HLTHINSRYRTXPRCSYN );}

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

    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    


}
