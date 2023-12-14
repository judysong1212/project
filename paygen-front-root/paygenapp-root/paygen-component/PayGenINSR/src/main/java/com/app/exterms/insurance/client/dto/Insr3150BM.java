package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3150BM  extends MSFSimpleBaseModel implements IsSerializable   {
	 
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 건간보험정산귀속년도 : hlthInsrYr */
	public static final String ATTR_HLTHINSRYR = "hlthInsrYr";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 차수 : dspty */
	public static final String ATTR_DSPTY = "dspty";

	/** set 사업장관리번호 : dpobMangeNum */
	public static final String ATTR_DPOBMANGENUM = "dpobMangeNum";

	/** set 회계 : acc */
	public static final String ATTR_ACC = "acc";

	/** set 단위사업장코드 : untDpobCd */
	public static final String ATTR_UNTDPOBCD = "untDpobCd";

	/** set 증번호 : certNumHuhd */
	public static final String ATTR_CERTNUMHUHD = "certNumHuhd";

	/** set 성명 : hlthNm */
	public static final String ATTR_HLTHNM = "hlthNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";

	/** set 건강보험취득일자 : hlthInsrAqtnDt */
	public static final String ATTR_HLTHINSRAQTNDT = "hlthInsrAqtnDt";

	/** set 보험료부과월수_건강 : iposPrmmMnthHlth */
	public static final String ATTR_IPOSPRMMMNTHHLTH = "iposPrmmMnthHlth";

	/** set 보험료부과월수_장기 : iposPrmmMnthRcptn */
	public static final String ATTR_IPOSPRMMMNTHRCPTN = "iposPrmmMnthRcptn";

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

	/** set 고지유예 : nofctSspn */
	public static final String ATTR_NOFCTSSPN = "nofctSspn";

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
	 public Insr3150BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3150BM(
			 String  dpobCd 
			, String  hlthInsrYr 
			, String  systemkey  
			, String  dspty 
			, String  dpobMangeNum 
			, String  acc 
			, String  untDpobCd 
			, String  certNumHuhd 
			, String  hlthNm 
			, String  resnRegnNum 
			, String  hlthInsrAqtnDt 
			, Long  iposPrmmMnthHlth 
			, Long  iposPrmmMnthRcptn 
			, Long  iposTotPrmmAggr 
			, Long  iposTotPrmmHlth 
			, Long  iposTotPrmmLgtmRcptn 
			, Long  yrlyPayTotAmnt 
			, Long  dutyMnthIcm 
			, String  nofctSspn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_HLTHINSRYR,hlthInsrYr);
	 	values.put(ATTR_SYSTEMKEY,systemkey); 
	 	values.put(ATTR_DSPTY,dspty);
	 	values.put(ATTR_DPOBMANGENUM,dpobMangeNum);
	 	values.put(ATTR_ACC,acc);
	 	values.put(ATTR_UNTDPOBCD,untDpobCd);
	 	values.put(ATTR_CERTNUMHUHD,certNumHuhd);
	 	values.put(ATTR_HLTHNM,hlthNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_HLTHINSRAQTNDT,hlthInsrAqtnDt);
	 	values.put(ATTR_IPOSPRMMMNTHHLTH,iposPrmmMnthHlth);
	 	values.put(ATTR_IPOSPRMMMNTHRCPTN,iposPrmmMnthRcptn);
	 	values.put(ATTR_IPOSTOTPRMMAGGR,iposTotPrmmAggr);
	 	values.put(ATTR_IPOSTOTPRMMHLTH,iposTotPrmmHlth);
	 	values.put(ATTR_IPOSTOTPRMMLGTMRCPTN,iposTotPrmmLgtmRcptn);
	 	values.put(ATTR_YRLYPAYTOTAMNT,yrlyPayTotAmnt);
	 	values.put(ATTR_DUTYMNTHICM,dutyMnthIcm);
	 	values.put(ATTR_NOFCTSSPN,nofctSspn);
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

	/** set 건간보험정산귀속년도 : hlthInsrYr */
	public void setHlthInsrYr(String  hlthInsrYr) { set( ATTR_HLTHINSRYR ,hlthInsrYr);}
	/** get 건간보험정산귀속년도 : hlthInsrYr */
	public String  getHlthInsrYr() { return (String )get( ATTR_HLTHINSRYR );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}




	/** set 차수 : dspty */
	public void setDspty(String  dspty) { set( ATTR_DSPTY ,dspty);}
	/** get 차수 : dspty */
	public String  getDspty() { return (String )get( ATTR_DSPTY );}

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

	/** set 성명 : hlthNm */
	public void setHlthNm(String  hlthNm) { set( ATTR_HLTHNM ,hlthNm);}
	/** get 성명 : hlthNm */
	public String  getHlthNm() { return (String )get( ATTR_HLTHNM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 건강보험취득일자 : hlthInsrAqtnDt */
	public void setHlthInsrAqtnDt(String  hlthInsrAqtnDt) { set( ATTR_HLTHINSRAQTNDT ,hlthInsrAqtnDt);}
	/** get 건강보험취득일자 : hlthInsrAqtnDt */
	public String  getHlthInsrAqtnDt() { return (String )get( ATTR_HLTHINSRAQTNDT );}

	/** set 보험료부과월수_건강 : iposPrmmMnthHlth */
	public void setIposPrmmMnthHlth(Long  iposPrmmMnthHlth) { set( ATTR_IPOSPRMMMNTHHLTH ,iposPrmmMnthHlth);}
	/** get 보험료부과월수_건강 : iposPrmmMnthHlth */
	public Long  getIposPrmmMnthHlth() { return (Long )get( ATTR_IPOSPRMMMNTHHLTH );}

	/** set 보험료부과월수_장기 : iposPrmmMnthRcptn */
	public void setIposPrmmMnthRcptn(Long  iposPrmmMnthRcptn) { set( ATTR_IPOSPRMMMNTHRCPTN ,iposPrmmMnthRcptn);}
	/** get 보험료부과월수_장기 : iposPrmmMnthRcptn */
	public Long  getIposPrmmMnthRcptn() { return (Long )get( ATTR_IPOSPRMMMNTHRCPTN );}

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

	/** set 고지유예 : nofctSspn */
	public void setNofctSspn(String  nofctSspn) { set( ATTR_NOFCTSSPN ,nofctSspn);}
	/** get 고지유예 : nofctSspn */
	public String  getNofctSspn() { return (String )get( ATTR_NOFCTSSPN );}

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
