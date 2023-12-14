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
public class Insr3200BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 고지년월 : nofctYrMnth */
	public static final String ATTR_NOFCTYRMNTH = "nofctYrMnth";

	/** set 고지차수 : nofctDspty */
	public static final String ATTR_NOFCTDSPTY = "nofctDspty";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 사업장관리번호 : dpobMangeNum */
	public static final String ATTR_DPOBMANGENUM = "dpobMangeNum";

	/** set 단위기관코드 : untIstutCd */
	public static final String ATTR_UNTISTUTCD = "untIstutCd";

	/** set 회계부호 : accSgn */
	public static final String ATTR_ACCSGN = "accSgn";

	/** set 건강보험증번호 : hlthInsrCertNum */
	public static final String ATTR_HLTHINSRCERTNUM = "hlthInsrCertNum";

	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";
	

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";



	/** set 감면사유코드 : reduReasCd */
	public static final String ATTR_REDUREASCD = "reduReasCd";
	
	/** set 감면사유 : reduReasNm */
	public static final String ATTR_REDUREASNM = "reduReasNm";

	/** set 건강보험직종코드 : hlthInsrTypOccuCd */
	public static final String ATTR_HLTHINSRTYPOCCUCD = "hlthInsrTypOccuCd";

	/** set 보수월액등급 : payMnthAmntGrde */
	public static final String ATTR_PAYMNTHAMNTGRDE = "payMnthAmntGrde";

	/** set 보수월액 : payMnthAmnt */
	public static final String ATTR_PAYMNTHAMNT = "payMnthAmnt";

	/** set 산출보험료 : calcPrmm */
	public static final String ATTR_CALCPRMM = "calcPrmm";

	/** set 산출보험료 : sanCalcPrmm */
	public static final String ATTR_SANCALCPRMM = "sanCalcPrmm"; 
	
	/** set 정산사유코드 : clutReasCd */
	public static final String ATTR_CLUTREASCD = "clutReasCd";

	/** set 정산적용시작년월 : clutApptnBgnnYrMnth */
	public static final String ATTR_CLUTAPPTNBGNNYRMNTH = "clutApptnBgnnYrMnth";

	/** set 정산적용종료년월 : clutApptnEndYrMnth */
	public static final String ATTR_CLUTAPPTNENDYRMNTH = "clutApptnEndYrMnth";

	/** set 정산보험료 : clutPrmm */
	public static final String ATTR_CLUTPRMM = "clutPrmm";

	/** set 고지보험료 : nofctPrmm */
	public static final String ATTR_NOFCTPRMM = "nofctPrmm";

	/** set 연말정산보험료 : yrtxPrmm */
	public static final String ATTR_YRTXPRMM = "yrtxPrmm";

	/** set 취득일자 : aqtnDt */
	public static final String ATTR_AQTNDT = "aqtnDt";

	/** set 상실일자 : lssDt */
	public static final String ATTR_LSSDT = "lssDt";

	/** set 요양산출보험료 : lgtmRcptnCalcPrmm */
	public static final String ATTR_LGTMRCPTNCALCPRMM = "lgtmRcptnCalcPrmm";

	/** set 공단요양산출보험료 : sanLgtmRcptnCalcPrmm */
	public static final String ATTR_SANLGTMRCPTNCALCPRMM = "sanLgtmRcptnCalcPrmm";
	 
	/** set 요양정산사유코드 : lgtmRcptnClutReasCd */
	public static final String ATTR_LGTMRCPTNCLUTREASCD = "lgtmRcptnClutReasCd";

	/** set 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
	public static final String ATTR_LGTMRCPTNAPPTNBGNNYRMNTH = "lgtmRcptnApptnBgnnYrMnth";

	/** set 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
	public static final String ATTR_LGTMRCPTNAPPTNENDYRMNTH = "lgtmRcptnApptnEndYrMnth";

	/** set 요양정산보험료 : lgtmRcptnClutPrmm */
	public static final String ATTR_LGTMRCPTNCLUTPRMM = "lgtmRcptnClutPrmm";

	/** set 요양고지보험료 : lgtmRcptnNofctPrmm */
	public static final String ATTR_LGTMRCPTNNOFCTPRMM = "lgtmRcptnNofctPrmm";

	/** set 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
	public static final String ATTR_LGTMRCPTNYRTXPRMM = "lgtmRcptnYrtxPrmm";

	/** set 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
	public static final String ATTR_HLTHRCPTNCALCPRMM = "hlthRcptnCalcPrmm";

	/** set 건강_요양정산보험료계 : hlthRcptnClutPrmm */
	public static final String ATTR_HLTHRCPTNCLUTPRMM = "hlthRcptnClutPrmm";

	/** set 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
	public static final String ATTR_HLTHRCPTNNOFCTPRMM = "hlthRcptnNofctPrmm";

	/** set 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
	public static final String ATTR_HLTHRCPTNYRTXPRMM = "hlthRcptnYrtxPrmm";

	/** set 건강환급금이자 : hlthInsrRefdItrt */
	public static final String ATTR_HLTHINSRREFDITRT = "hlthInsrRefdItrt";

	/** set 요양환급금이자 : lgtmRcptnRefdItrt */
	public static final String ATTR_LGTMRCPTNREFDITRT = "lgtmRcptnRefdItrt";

	/** set 총납부보험료 : totPymtPrmm */
	public static final String ATTR_TOTPYMTPRMM = "totPymtPrmm";

	/** set 공제년월 : dducYrMnth */
	public static final String ATTR_DDUCYRMNTH = "dducYrMnth";

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

	//부서 , 납부년월금액, 납부전월금액,변동금액, 납부년월금액, 납부전월급액 , 변동금액
	
	public static final String ATTR_DEPTNM = "deptNm";
	
	/** set 납부년월 : pymtYrMnth */
	public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";
	
	
	/** set 건강납부년월금액 : HLTH_INSR_MNTH_AMNT */
	public static final String ATTR_HLTHINSRMNTHAMNT = "hlthInsrMnthAmnt";
	/** set 건강납부전월금액 : BEFORE_HLTH_INSR_MNTH_AMNT */
	public static final String ATTR_BEFOFRHLTHINSRMNTHAMNT = "beforeHlthInsrMnthAmnt";
	/** set 변동금액 : HLTH_INSR_GAP_AMNT */
	public static final String ATTR_HLTHINSRGAPAMNT = "hlthInsrGapAmnt";

	/** set 장기요양납부년월금액 : HLTH_RCPTN_MNTH_AMNT */
	public static final String ATTR_HLTHRCPTNMNTHAMNT = "hlthRcptnMnthAmnt";
	/** set 장기요양납부전월금액 : BEFORE_HLTH_RCPTN_MNTH_AMNT */
	public static final String ATTR_BEFOREHLTHRCPTNMNTHAMNT = "beforeHlthRcptnMnthAmnt";
	/** set 변동금액 : HLTH_RCPTN_GAP_AMNT */
	public static final String ATTR_HLTHRCPTNGAPAMNT = "hlthRcptnGapAmnt";
	
	
	/** 생성자 */
	 public Insr3200BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3200BM(
			 String  systemkey 
			, String  dpobCd 
			, String  nofctYrMnth 
			, Long  nofctDspty 
			, String  dpobMangeNum 
			, String  untIstutCd 
			, String  accSgn 
			, String  hlthInsrCertNum 
			, String  hanNm 
			, String  resnRegnNum 
			, String  reduReasCd
			, String  reduReasNm
			, String  hlthInsrTypOccuCd 
			, String  payMnthAmntGrde 
			, Long  payMnthAmnt 
			, Long  calcPrmm 
			, String  clutReasCd 
			, String  clutApptnBgnnYrMnth 
			, String  clutApptnEndYrMnth 
			, Long  clutPrmm 
			, Long  nofctPrmm 
			, Long  yrtxPrmm 
			, String  aqtnDt 
			, String  lssDt 
			, Long  lgtmRcptnCalcPrmm 
			, String  lgtmRcptnClutReasCd 
			, String  lgtmRcptnApptnBgnnYrMnth 
			, String  lgtmRcptnApptnEndYrMnth 
			, Long  lgtmRcptnClutPrmm 
			, Long  lgtmRcptnNofctPrmm 
			, Long  lgtmRcptnYrtxPrmm 
			, Long  hlthRcptnCalcPrmm 
			, Long  hlthRcptnClutPrmm 
			, Long  hlthRcptnNofctPrmm 
			, Long  hlthRcptnYrtxPrmm 
			, Long  hlthInsrRefdItrt 
			, Long  lgtmRcptnRefdItrt 
			, Long  totPymtPrmm 
			, Long  hlthInsrMnthAmnt
			, Long  beforeHlthInsrMnthAmnt
			, Long  hlthInsrGapAmnt
			, Long  hlthRcptnMnthAmnt
			, Long  beforeHlthRcptnMnthAmnt
			, Long  hlthRcptnGapAmnt
			, String  deptNm
			, String  pymtYrMnth
			, String  dducYrMnth 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_NOFCTYRMNTH,nofctYrMnth);
	 	values.put(ATTR_NOFCTDSPTY,nofctDspty);
	 	values.put(ATTR_DPOBMANGENUM,dpobMangeNum);
	 	values.put(ATTR_UNTISTUTCD,untIstutCd);
	 	values.put(ATTR_ACCSGN,accSgn);
	 	values.put(ATTR_HLTHINSRCERTNUM,hlthInsrCertNum);
	 	values.put(ATTR_HANNM,hanNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_REDUREASCD,reduReasCd);
	 	values.put(ATTR_REDUREASNM,reduReasNm);
	 	values.put(ATTR_HLTHINSRTYPOCCUCD,hlthInsrTypOccuCd);
	 	values.put(ATTR_PAYMNTHAMNTGRDE,payMnthAmntGrde);
	 	values.put(ATTR_PAYMNTHAMNT,payMnthAmnt);
	 	values.put(ATTR_CALCPRMM,calcPrmm);
	 	values.put(ATTR_CLUTREASCD,clutReasCd);
	 	values.put(ATTR_CLUTAPPTNBGNNYRMNTH,clutApptnBgnnYrMnth);
	 	values.put(ATTR_CLUTAPPTNENDYRMNTH,clutApptnEndYrMnth);
	 	values.put(ATTR_CLUTPRMM,clutPrmm);
	 	values.put(ATTR_NOFCTPRMM,nofctPrmm);
	 	values.put(ATTR_YRTXPRMM,yrtxPrmm);
	 	values.put(ATTR_AQTNDT,aqtnDt);
	 	values.put(ATTR_LSSDT,lssDt);
	 	values.put(ATTR_LGTMRCPTNCALCPRMM,lgtmRcptnCalcPrmm);
	 	values.put(ATTR_LGTMRCPTNCLUTREASCD,lgtmRcptnClutReasCd);
	 	values.put(ATTR_LGTMRCPTNAPPTNBGNNYRMNTH,lgtmRcptnApptnBgnnYrMnth);
	 	values.put(ATTR_LGTMRCPTNAPPTNENDYRMNTH,lgtmRcptnApptnEndYrMnth);
	 	values.put(ATTR_LGTMRCPTNCLUTPRMM,lgtmRcptnClutPrmm);
	 	values.put(ATTR_LGTMRCPTNNOFCTPRMM,lgtmRcptnNofctPrmm);
	 	values.put(ATTR_LGTMRCPTNYRTXPRMM,lgtmRcptnYrtxPrmm);
	 	values.put(ATTR_HLTHRCPTNCALCPRMM,hlthRcptnCalcPrmm);
	 	values.put(ATTR_HLTHRCPTNCLUTPRMM,hlthRcptnClutPrmm);
	 	values.put(ATTR_HLTHRCPTNNOFCTPRMM,hlthRcptnNofctPrmm);
	 	values.put(ATTR_HLTHRCPTNYRTXPRMM,hlthRcptnYrtxPrmm);
	 	values.put(ATTR_HLTHINSRREFDITRT,hlthInsrRefdItrt);
	 	values.put(ATTR_LGTMRCPTNREFDITRT,lgtmRcptnRefdItrt);
	 	values.put(ATTR_TOTPYMTPRMM,totPymtPrmm);
	 	values.put(ATTR_DDUCYRMNTH,dducYrMnth);
	 	
	 	values.put(ATTR_DEPTNM,deptNm);
	 	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
	 	values.put(ATTR_HLTHINSRMNTHAMNT,hlthInsrMnthAmnt);
	 	values.put(ATTR_BEFOFRHLTHINSRMNTHAMNT,beforeHlthInsrMnthAmnt);
	 	values.put(ATTR_HLTHINSRGAPAMNT,hlthInsrGapAmnt);
	 	values.put(ATTR_HLTHRCPTNMNTHAMNT,hlthRcptnMnthAmnt);
	 	values.put(ATTR_BEFOREHLTHRCPTNMNTHAMNT,beforeHlthRcptnMnthAmnt);
	 	values.put(ATTR_HLTHRCPTNGAPAMNT,hlthRcptnGapAmnt);
	 	
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr); } 

	 
	/** set 납부년월 : pymtYrMnth */
	public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
	/** get 납부년월 : pymtYrMnth */
	public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );} 
	 
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

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

	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}

	/** set 사업장관리번호 : dpobMangeNum */
	public void setDpobMangeNum(String  dpobMangeNum) { set( ATTR_DPOBMANGENUM ,dpobMangeNum);}
	/** get 사업장관리번호 : dpobMangeNum */
	public String  getDpobMangeNum() { return (String )get( ATTR_DPOBMANGENUM );}

	/** set 단위기관코드 : untIstutCd */
	public void setUntIstutCd(String  untIstutCd) { set( ATTR_UNTISTUTCD ,untIstutCd);}
	/** get 단위기관코드 : untIstutCd */
	public String  getUntIstutCd() { return (String )get( ATTR_UNTISTUTCD );}

	/** set 회계부호 : accSgn */
	public void setAccSgn(String  accSgn) { set( ATTR_ACCSGN ,accSgn);}
	/** get 회계부호 : accSgn */
	public String  getAccSgn() { return (String )get( ATTR_ACCSGN );}

	/** set 건강보험증번호 : hlthInsrCertNum */
	public void setHlthInsrCertNum(String  hlthInsrCertNum) { set( ATTR_HLTHINSRCERTNUM ,hlthInsrCertNum);}
	/** get 건강보험증번호 : hlthInsrCertNum */
	public String  getHlthInsrCertNum() { return (String )get( ATTR_HLTHINSRCERTNUM );}

	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 감면사유코드 : reduReasCd */
	public void setReduReasCd(String  reduReasCd) { set( ATTR_REDUREASCD ,reduReasCd);}
	/** get 감면사유코드 : reduReasCd */
	public String  getReduReasCd() { return (String )get( ATTR_REDUREASCD );}
	
	/** set 감면사유 : reduReasNm */
	public void setReduReasNm(String  reduReasNm) { set( ATTR_REDUREASNM ,reduReasNm);}
	/** get 감면사유 : reduReasCd */
	public String  getReduReasNm() { return (String )get( ATTR_REDUREASNM );}

	/** set 건강보험직종코드 : hlthInsrTypOccuCd */
	public void setHlthInsrTypOccuCd(String  hlthInsrTypOccuCd) { set( ATTR_HLTHINSRTYPOCCUCD ,hlthInsrTypOccuCd);}
	/** get 건강보험직종코드 : hlthInsrTypOccuCd */
	public String  getHlthInsrTypOccuCd() { return (String )get( ATTR_HLTHINSRTYPOCCUCD );}

	/** set 보수월액등급 : payMnthAmntGrde */
	public void setPayMnthAmntGrde(String  payMnthAmntGrde) { set( ATTR_PAYMNTHAMNTGRDE ,payMnthAmntGrde);}
	/** get 보수월액등급 : payMnthAmntGrde */
	public String  getPayMnthAmntGrde() { return (String )get( ATTR_PAYMNTHAMNTGRDE );}

	/** set 보수월액 : payMnthAmnt */
	public void setPayMnthAmnt(Long  payMnthAmnt) { set( ATTR_PAYMNTHAMNT ,payMnthAmnt);}
	/** get 보수월액 : payMnthAmnt */
	public Long  getPayMnthAmnt() { return (Long )get( ATTR_PAYMNTHAMNT );}

	/** set 산출보험료 : calcPrmm */
	public void setCalcPrmm(Long  calcPrmm) { set( ATTR_CALCPRMM ,calcPrmm);}
	/** get 산출보험료 : calcPrmm */
	public Long  getCalcPrmm() { return (Long )get( ATTR_CALCPRMM );}
	
	/** set 공단산출보험료 : sanCalcPrmm */
	public void setSanCalcPrmm(Long  sanCalcPrmm) { set( ATTR_SANCALCPRMM ,sanCalcPrmm);}
	/** get 공단산출보험료 : sanCalcPrmm */
	public Long  getSanCalcPrmm() { return (Long )get( ATTR_SANCALCPRMM );}


	/** set 정산사유코드 : clutReasCd */
	public void setClutReasCd(String  clutReasCd) { set( ATTR_CLUTREASCD ,clutReasCd);}
	/** get 정산사유코드 : clutReasCd */
	public String  getClutReasCd() { return (String )get( ATTR_CLUTREASCD );}

	/** set 정산적용시작년월 : clutApptnBgnnYrMnth */
	public void setClutApptnBgnnYrMnth(String  clutApptnBgnnYrMnth) { set( ATTR_CLUTAPPTNBGNNYRMNTH ,clutApptnBgnnYrMnth);}
	/** get 정산적용시작년월 : clutApptnBgnnYrMnth */
	public String  getClutApptnBgnnYrMnth() { return (String )get( ATTR_CLUTAPPTNBGNNYRMNTH );}

	/** set 정산적용종료년월 : clutApptnEndYrMnth */
	public void setClutApptnEndYrMnth(String  clutApptnEndYrMnth) { set( ATTR_CLUTAPPTNENDYRMNTH ,clutApptnEndYrMnth);}
	/** get 정산적용종료년월 : clutApptnEndYrMnth */
	public String  getClutApptnEndYrMnth() { return (String )get( ATTR_CLUTAPPTNENDYRMNTH );}

	/** set 정산보험료 : clutPrmm */
	public void setClutPrmm(Long  clutPrmm) { set( ATTR_CLUTPRMM ,clutPrmm);}
	/** get 정산보험료 : clutPrmm */
	public Long  getClutPrmm() { return (Long )get( ATTR_CLUTPRMM );}

	/** set 고지보험료 : nofctPrmm */
	public void setNofctPrmm(Long  nofctPrmm) { set( ATTR_NOFCTPRMM ,nofctPrmm);}
	/** get 고지보험료 : nofctPrmm */
	public Long  getNofctPrmm() { return (Long )get( ATTR_NOFCTPRMM );}

	/** set 연말정산보험료 : yrtxPrmm */
	public void setYrtxPrmm(Long  yrtxPrmm) { set( ATTR_YRTXPRMM ,yrtxPrmm);}
	/** get 연말정산보험료 : yrtxPrmm */
	public Long  getYrtxPrmm() { return (Long )get( ATTR_YRTXPRMM );}

	/** set 취득일자 : aqtnDt */
	public void setAqtnDt(String  aqtnDt) { set( ATTR_AQTNDT ,aqtnDt);}
	/** get 취득일자 : aqtnDt */
	public String  getAqtnDt() { return (String )get( ATTR_AQTNDT );}

	/** set 상실일자 : lssDt */
	public void setLssDt(String  lssDt) { set( ATTR_LSSDT ,lssDt);}
	/** get 상실일자 : lssDt */
	public String  getLssDt() { return (String )get( ATTR_LSSDT );}

	/** set 요양산출보험료 : lgtmRcptnCalcPrmm */
	public void setLgtmRcptnCalcPrmm(Long  lgtmRcptnCalcPrmm) { set( ATTR_LGTMRCPTNCALCPRMM ,lgtmRcptnCalcPrmm);}
	/** get 요양산출보험료 : lgtmRcptnCalcPrmm */
	public Long  getLgtmRcptnCalcPrmm() { return (Long )get( ATTR_LGTMRCPTNCALCPRMM );}

	/** set 공단요양산출보험료 : sanLgtmRcptnCalcPrmm */
	public void setSanLgtmRcptnCalcPrmm(Long  sanLgtmRcptnCalcPrmm) { set( ATTR_SANLGTMRCPTNCALCPRMM ,sanLgtmRcptnCalcPrmm);}
	/** get 공단요양산출보험료 : sanLgtmRcptnCalcPrmm */
	public Long  getSanLgtmRcptnCalcPrmm() { return (Long )get( ATTR_SANLGTMRCPTNCALCPRMM );}
 
	
	/** set 요양정산사유코드 : lgtmRcptnClutReasCd */
	public void setLgtmRcptnClutReasCd(String  lgtmRcptnClutReasCd) { set( ATTR_LGTMRCPTNCLUTREASCD ,lgtmRcptnClutReasCd);}
	/** get 요양정산사유코드 : lgtmRcptnClutReasCd */
	public String  getLgtmRcptnClutReasCd() { return (String )get( ATTR_LGTMRCPTNCLUTREASCD );}

	/** set 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
	public void setLgtmRcptnApptnBgnnYrMnth(String  lgtmRcptnApptnBgnnYrMnth) { set( ATTR_LGTMRCPTNAPPTNBGNNYRMNTH ,lgtmRcptnApptnBgnnYrMnth);}
	/** get 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
	public String  getLgtmRcptnApptnBgnnYrMnth() { return (String )get( ATTR_LGTMRCPTNAPPTNBGNNYRMNTH );}

	/** set 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
	public void setLgtmRcptnApptnEndYrMnth(String  lgtmRcptnApptnEndYrMnth) { set( ATTR_LGTMRCPTNAPPTNENDYRMNTH ,lgtmRcptnApptnEndYrMnth);}
	/** get 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
	public String  getLgtmRcptnApptnEndYrMnth() { return (String )get( ATTR_LGTMRCPTNAPPTNENDYRMNTH );}

	/** set 요양정산보험료 : lgtmRcptnClutPrmm */
	public void setLgtmRcptnClutPrmm(Long  lgtmRcptnClutPrmm) { set( ATTR_LGTMRCPTNCLUTPRMM ,lgtmRcptnClutPrmm);}
	/** get 요양정산보험료 : lgtmRcptnClutPrmm */
	public Long  getLgtmRcptnClutPrmm() { return (Long )get( ATTR_LGTMRCPTNCLUTPRMM );}

	/** set 요양고지보험료 : lgtmRcptnNofctPrmm */
	public void setLgtmRcptnNofctPrmm(Long  lgtmRcptnNofctPrmm) { set( ATTR_LGTMRCPTNNOFCTPRMM ,lgtmRcptnNofctPrmm);}
	/** get 요양고지보험료 : lgtmRcptnNofctPrmm */
	public Long  getLgtmRcptnNofctPrmm() { return (Long )get( ATTR_LGTMRCPTNNOFCTPRMM );}

	/** set 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
	public void setLgtmRcptnYrtxPrmm(Long  lgtmRcptnYrtxPrmm) { set( ATTR_LGTMRCPTNYRTXPRMM ,lgtmRcptnYrtxPrmm);}
	/** get 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
	public Long  getLgtmRcptnYrtxPrmm() { return (Long )get( ATTR_LGTMRCPTNYRTXPRMM );}

	/** set 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
	public void setHlthRcptnCalcPrmm(Long  hlthRcptnCalcPrmm) { set( ATTR_HLTHRCPTNCALCPRMM ,hlthRcptnCalcPrmm);}
	/** get 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
	public Long  getHlthRcptnCalcPrmm() { return (Long )get( ATTR_HLTHRCPTNCALCPRMM );}

	/** set 건강_요양정산보험료계 : hlthRcptnClutPrmm */
	public void setHlthRcptnClutPrmm(Long  hlthRcptnClutPrmm) { set( ATTR_HLTHRCPTNCLUTPRMM ,hlthRcptnClutPrmm);}
	/** get 건강_요양정산보험료계 : hlthRcptnClutPrmm */
	public Long  getHlthRcptnClutPrmm() { return (Long )get( ATTR_HLTHRCPTNCLUTPRMM );}

	/** set 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
	public void setHlthRcptnNofctPrmm(Long  hlthRcptnNofctPrmm) { set( ATTR_HLTHRCPTNNOFCTPRMM ,hlthRcptnNofctPrmm);}
	/** get 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
	public Long  getHlthRcptnNofctPrmm() { return (Long )get( ATTR_HLTHRCPTNNOFCTPRMM );}

	/** set 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
	public void setHlthRcptnYrtxPrmm(Long  hlthRcptnYrtxPrmm) { set( ATTR_HLTHRCPTNYRTXPRMM ,hlthRcptnYrtxPrmm);}
	/** get 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
	public Long  getHlthRcptnYrtxPrmm() { return (Long )get( ATTR_HLTHRCPTNYRTXPRMM );}

	/** set 건강환급금이자 : hlthInsrRefdItrt */
	public void setHlthInsrRefdItrt(Long  hlthInsrRefdItrt) { set( ATTR_HLTHINSRREFDITRT ,hlthInsrRefdItrt);}
	/** get 건강환급금이자 : hlthInsrRefdItrt */
	public Long  getHlthInsrRefdItrt() { return (Long )get( ATTR_HLTHINSRREFDITRT );}

	/** set 요양환급금이자 : lgtmRcptnRefdItrt */
	public void setLgtmRcptnRefdItrt(Long  lgtmRcptnRefdItrt) { set( ATTR_LGTMRCPTNREFDITRT ,lgtmRcptnRefdItrt);}
	/** get 요양환급금이자 : lgtmRcptnRefdItrt */
	public Long  getLgtmRcptnRefdItrt() { return (Long )get( ATTR_LGTMRCPTNREFDITRT );}

	/** set 총납부보험료 : totPymtPrmm */
	public void setTotPymtPrmm(Long  totPymtPrmm) { set( ATTR_TOTPYMTPRMM ,totPymtPrmm);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getTotPymtPrmm() { return (Long )get( ATTR_TOTPYMTPRMM );}

	/** set 공제년월 : dducYrMnth */
	public void setDducYrMnth(String  dducYrMnth) { set( ATTR_DDUCYRMNTH ,dducYrMnth);}
	/** get 공제년월 : dducYrMnth */
	public String  getDducYrMnth() { return (String )get( ATTR_DDUCYRMNTH );}

	
	/** set 총납부보험료 : totPymtPrmm */
	public void setHlthInsrMnthAmnt(Long  hlthInsrMnthAmnt) { set( ATTR_HLTHINSRMNTHAMNT ,hlthInsrMnthAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getHlthInsrMnthAmnt() { return (Long )get( ATTR_HLTHINSRMNTHAMNT );}
	
	/** set 총납부보험료 : totPymtPrmm */
	public void setBeforeHlthInsrMnthAmnt(Long  beforeHlthInsrMnthAmnt) { set( ATTR_BEFOFRHLTHINSRMNTHAMNT ,beforeHlthInsrMnthAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getBeforeHlthInsrMnthAmnt() { return (Long )get( ATTR_BEFOFRHLTHINSRMNTHAMNT );}
	
	/** set 총납부보험료 : totPymtPrmm */
	public void setHlthInsrGapAmnt(Long  hlthInsrGapAmnt) { set( ATTR_HLTHINSRGAPAMNT ,hlthInsrGapAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getHlthInsrGapAmnt() { return (Long )get( ATTR_HLTHINSRGAPAMNT );}
	
	/** set 총납부보험료 : totPymtPrmm */
	public void setHlthRcptnMnthAmnt(Long  hlthRcptnMnthAmnt) { set( ATTR_HLTHRCPTNMNTHAMNT ,hlthRcptnMnthAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getHlthRcptnMnthAmnt() { return (Long )get( ATTR_HLTHRCPTNMNTHAMNT );}
	
	/** set 총납부보험료 : totPymtPrmm */
	public void setBeforeHlthRcptnMnthAmnt(Long  beforeHlthRcptnMnthAmnt) { set( ATTR_BEFOREHLTHRCPTNMNTHAMNT ,beforeHlthRcptnMnthAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getBeforeHlthRcptnMnthAmnt() { return (Long )get( ATTR_BEFOREHLTHRCPTNMNTHAMNT );}
	
	/** set 총납부보험료 : totPymtPrmm */
	public void setHlthRcptnGapAmnt(Long  hlthRcptnGapAmnt) { set( ATTR_HLTHRCPTNGAPAMNT ,hlthRcptnGapAmnt);}
	/** get 총납부보험료 : totPymtPrmm */
	public Long  getHlthRcptnGapAmnt() { return (Long )get( ATTR_HLTHRCPTNGAPAMNT );}
	
	
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
