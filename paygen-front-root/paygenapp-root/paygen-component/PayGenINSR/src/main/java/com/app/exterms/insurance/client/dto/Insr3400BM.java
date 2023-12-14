package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr3400VO.java
 * @Description : Insr3400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3400BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 정산년월 : nofctYrMnthNum */
	public static final String ATTR_NOFCTYRMNTHNUM = "nofctYrMnthNum";
	
	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";
	
	/** set 휴퇴직정산일련번호 : levfAbncRetryClutNum */
	public static final String ATTR_LEVFABNCRETRYCLUTNUM = "levfAbncRetryClutNum";
	
	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";
	
	/** set 정산시작일자 : clutBgnnDt */
	public static final String ATTR_CLUTBGNNDT = "clutBgnnDt";

	/** set 퇴직일자 : retryDt */
	public static final String ATTR_RETRYDT = "retryDt";

	/** set 근무월수 : dutyMnthIcm */
	public static final String ATTR_DUTYMNTHICM = "dutyMnthIcm";

	/** set 건강보수총액 : hlthNumCpisTotAmnt */
	public static final String ATTR_HLTHNUMCPISTOTAMNT = "hlthNumCpisTotAmnt";

	/** set 건강보수월액 : hlthPayMnthAmnt */
	public static final String ATTR_HLTHPAYMNTHAMNT = "hlthPayMnthAmnt";

	/** set 기납부_건강보험료 : alpayHlthPrmm */
	public static final String ATTR_ALPAYHLTHPRMM = "alpayHlthPrmm";

	/** set 기납부_장기요양보험료 : alpayLgtmRcptnPrmm */
	public static final String ATTR_ALPAYLGTMRCPTNPRMM = "alpayLgtmRcptnPrmm";

	/** set 기납부_합계 : alpayAggrSum */
	public static final String ATTR_ALPAYAGGRSUM = "alpayAggrSum";

	/** set 건강확정보험료 : hlthFixPrmm */
	public static final String ATTR_HLTHFIXPRMM = "hlthFixPrmm";

	/** set 감면월수 : reduMnthIcm */
	public static final String ATTR_REDUMNTHICM = "reduMnthIcm";

	/** set 건강_감면_조정보험료 : hlthReduAdmntPrmm */
	public static final String ATTR_HLTHREDUADMNTPRMM = "hlthReduAdmntPrmm";

	/** set 실근무일수 : turtyDutyMnthIcm */
	public static final String ATTR_TURTYDUTYMNTHICM = "turtyDutyMnthIcm";

	/** set 건강산정보험료 : hlthCmpttnPrmm */
	public static final String ATTR_HLTHCMPTTNPRMM = "hlthCmpttnPrmm";

	/** set 건강정산보험료 : hlthClutPrmm */
	public static final String ATTR_HLTHCLUTPRMM = "hlthClutPrmm";

	/** set 분할납부구분코드 : divdPymtDivCd */
	public static final String ATTR_DIVDPYMTDIVCD = "divdPymtDivCd";

	/** set 분할납부횟수 : divdPymt */
	public static final String ATTR_DIVDPYMT = "divdPymt";
	
	/** set 공제년월 : dducYrMnth */
	public static final String ATTR_DDUCYRMNTH = "dducYrMnth";
	
	/** set 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public static final String ATTR_HLTHYRTXPRCSDT = "hlthYrtxPrcsDt";
	
	/** set 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public static final String ATTR_HLTHINSRYRTXPRCSYN = "hlthInsrYrtxPrcsYn";

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
	 public Insr3400BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr3400BM(
			  String dpobCd
			, String nofctYrMnthNum
			, String systemkey
			, Long	 levfAbncRetryClutNum
			, String clutBgnnDt
			, String retryDt
			, Long   dutyMnthIcm 
			, Long   hlthNumCpisTotAmnt 
			, Long   hlthPayMnthAmnt 
			, Long   alpayHlthPrmm 
			, Long   alpayLgtmRcptnPrmm 
			, Long   alpayAggrSum 
			, Long   hlthFixPrmm 
			, Long   reduMnthIcm 
			, Long   hlthReduAdmntPrmm 
			, Long   turtyDutyMnthIcm 
			, Long   hlthCmpttnPrmm 
			, Long   hlthClutPrmm 
			, String divdPymtDivCd 
			, Long   divdPymt
			, String dducYrMnth
			, String hlthYrtxPrcsDt
			, String hlthInsrYrtxPrcsYn
			, String kybdr 
			, String inptDt 
			, String inptAddr 
			, String ismt 
			, String revnDt 
			, String revnAddr ) {
	 	values.put(ATTR_DPOBCD,				  dpobCd);
	 	values.put(ATTR_NOFCTYRMNTHNUM,		  nofctYrMnthNum);
	 	values.put(ATTR_SYSTEMKEY,			  systemkey);
	 	values.put(ATTR_LEVFABNCRETRYCLUTNUM, levfAbncRetryClutNum);
	 	values.put(ATTR_CLUTBGNNDT,			  clutBgnnDt);
	 	values.put(ATTR_RETRYDT,			  retryDt);
	 	values.put(ATTR_DUTYMNTHICM,		  dutyMnthIcm);
	 	values.put(ATTR_HLTHNUMCPISTOTAMNT,	  hlthNumCpisTotAmnt);
	 	values.put(ATTR_HLTHPAYMNTHAMNT,	  hlthPayMnthAmnt);
	 	values.put(ATTR_ALPAYHLTHPRMM,		  alpayHlthPrmm);
	 	values.put(ATTR_ALPAYLGTMRCPTNPRMM,	  alpayLgtmRcptnPrmm);
	 	values.put(ATTR_ALPAYAGGRSUM,		  alpayAggrSum);
	 	values.put(ATTR_HLTHFIXPRMM,		  hlthFixPrmm);
	 	values.put(ATTR_REDUMNTHICM,		  reduMnthIcm);
	 	values.put(ATTR_HLTHREDUADMNTPRMM,	  hlthReduAdmntPrmm);
	 	values.put(ATTR_TURTYDUTYMNTHICM,	  turtyDutyMnthIcm);
	 	values.put(ATTR_HLTHCMPTTNPRMM,		  hlthCmpttnPrmm);
	 	values.put(ATTR_HLTHCLUTPRMM,		  hlthClutPrmm);
	 	values.put(ATTR_DIVDPYMTDIVCD,		  divdPymtDivCd);
	 	values.put(ATTR_DIVDPYMT,			  divdPymt);
	 	values.put(ATTR_DDUCYRMNTH,			  dducYrMnth);
	 	values.put(ATTR_HLTHYRTXPRCSDT,		  hlthYrtxPrcsDt);
	 	values.put(ATTR_HLTHINSRYRTXPRCSYN,	  hlthInsrYrtxPrcsYn);
	 	values.put(ATTR_KYBDR,				  kybdr);
	 	values.put(ATTR_INPTDT,				  inptDt);
	 	values.put(ATTR_INPTADDR,			  inptAddr);
	 	values.put(ATTR_ISMT,				  ismt);
	 	values.put(ATTR_REVNDT,				  revnDt);
	 	values.put(ATTR_REVNADDR,			  revnAddr);
	 	}

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set 정산년월 : nofctYrMnthNum */
	public void setNofctYrMnthNum(String nofctYrMnthNum) { set(ATTR_NOFCTYRMNTHNUM, nofctYrMnthNum); }
	/** get 정산년월 : nofctYrMnthNum */
	public String getNofctYrMnthNum() { return (String)get(ATTR_NOFCTYRMNTHNUM); }
	
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
	
	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}

	/** set 휴퇴직정산일련번호 : levfAbncRetryClutNum */
	public void setLevfAbncRetryClutNum(Long  levfAbncRetryClutNum) { set( ATTR_LEVFABNCRETRYCLUTNUM ,levfAbncRetryClutNum);}
	/** get 휴퇴직정산일련번호 : levfAbncRetryClutNum */
	public Long  getLevfAbncRetryClutNum() { return (Long )get( ATTR_LEVFABNCRETRYCLUTNUM );}

	/** set 정산시작일자 : clutBgnnDt */
	public void setClutBgnnDt(String  clutBgnnDt) { set( ATTR_CLUTBGNNDT ,clutBgnnDt);}
	/** get 정산시작일자 : clutBgnnDt */
	public String  getClutBgnnDt() { return (String )get( ATTR_CLUTBGNNDT );}

	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
	/** get 퇴직일자 : retryDt */
	public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}

	/** set 근무월수 : dutyMnthIcm */
	public void setDutyMnthIcm(Long  dutyMnthIcm) { set( ATTR_DUTYMNTHICM ,dutyMnthIcm);}
	/** get 근무월수 : dutyMnthIcm */
	public Long  getDutyMnthIcm() { return (Long )get( ATTR_DUTYMNTHICM );}

	/** set 건강보수총액 : hlthNumCpisTotAmnt */
	public void setHlthNumCpisTotAmnt(Long  hlthNumCpisTotAmnt) { set( ATTR_HLTHNUMCPISTOTAMNT ,hlthNumCpisTotAmnt);}
	/** get 건강보수총액 : hlthNumCpisTotAmnt */
	public Long  getHlthNumCpisTotAmnt() { return (Long )get( ATTR_HLTHNUMCPISTOTAMNT );}

	/** set 건강보수월액 : hlthPayMnthAmnt */
	public void setHlthPayMnthAmnt(Long  hlthPayMnthAmnt) { set( ATTR_HLTHPAYMNTHAMNT ,hlthPayMnthAmnt);}
	/** get 건강보수월액 : hlthPayMnthAmnt */
	public Long  getHlthPayMnthAmnt() { return (Long )get( ATTR_HLTHPAYMNTHAMNT );}

	/** set 기납부_건강보험료 : alpayHlthPrmm */
	public void setAlpayHlthPrmm(Long  alpayHlthPrmm) { set( ATTR_ALPAYHLTHPRMM ,alpayHlthPrmm);}
	/** get 기납부_건강보험료 : alpayHlthPrmm */
	public Long  getAlpayHlthPrmm() { return (Long )get( ATTR_ALPAYHLTHPRMM );}

	/** set 기납부_장기요양보험료 : alpayLgtmRcptnPrmm */
	public void setAlpayLgtmRcptnPrmm(Long  alpayLgtmRcptnPrmm) { set( ATTR_ALPAYLGTMRCPTNPRMM ,alpayLgtmRcptnPrmm);}
	/** get 기납부_장기요양보험료 : alpayLgtmRcptnPrmm */
	public Long  getAlpayLgtmRcptnPrmm() { return (Long )get( ATTR_ALPAYLGTMRCPTNPRMM );}

	/** set 기납부_합계 : alpayAggrSum */
	public void setAlpayAggrSum(Long  alpayAggrSum) { set( ATTR_ALPAYAGGRSUM ,alpayAggrSum);}
	/** get 기납부_합계 : alpayAggrSum */
	public Long  getAlpayAggrSum() { return (Long )get( ATTR_ALPAYAGGRSUM );}

	/** set 건강확정보험료 : hlthFixPrmm */
	public void setHlthFixPrmm(Long  hlthFixPrmm) { set( ATTR_HLTHFIXPRMM ,hlthFixPrmm);}
	/** get 건강확정보험료 : hlthFixPrmm */
	public Long  getHlthFixPrmm() { return (Long )get( ATTR_HLTHFIXPRMM );}

	/** set 감면월수 : reduMnthIcm */
	public void setReduMnthIcm(Long  reduMnthIcm) { set( ATTR_REDUMNTHICM ,reduMnthIcm);}
	/** get 감면월수 : reduMnthIcm */
	public Long  getReduMnthIcm() { return (Long )get( ATTR_REDUMNTHICM );}

	/** set 건강_감면_조정보험료 : hlthReduAdmntPrmm */
	public void setHlthReduAdmntPrmm(Long  hlthReduAdmntPrmm) { set( ATTR_HLTHREDUADMNTPRMM ,hlthReduAdmntPrmm);}
	/** get 건강_감면_조정보험료 : hlthReduAdmntPrmm */
	public Long  getHlthReduAdmntPrmm() { return (Long )get( ATTR_HLTHREDUADMNTPRMM );}

	/** set 실근무일수 : turtyDutyMnthIcm */
	public void setTurtyDutyMnthIcm(Long  turtyDutyMnthIcm) { set( ATTR_TURTYDUTYMNTHICM ,turtyDutyMnthIcm);}
	/** get 실근무일수 : turtyDutyMnthIcm */
	public Long  getTurtyDutyMnthIcm() { return (Long )get( ATTR_TURTYDUTYMNTHICM );}

	/** set 건강산정보험료 : hlthCmpttnPrmm */
	public void setHlthCmpttnPrmm(Long  hlthCmpttnPrmm) { set( ATTR_HLTHCMPTTNPRMM ,hlthCmpttnPrmm);}
	/** get 건강산정보험료 : hlthCmpttnPrmm */
	public Long  getHlthCmpttnPrmm() { return (Long )get( ATTR_HLTHCMPTTNPRMM );}

	/** set 건강정산보험료 : hlthClutPrmm */
	public void setHlthClutPrmm(Long  hlthClutPrmm) { set( ATTR_HLTHCLUTPRMM ,hlthClutPrmm);}
	/** get 건강정산보험료 : hlthClutPrmm */
	public Long  getHlthClutPrmm() { return (Long )get( ATTR_HLTHCLUTPRMM );}

	/** set 분할납부구분코드 : divdPymtDivCd */
	public void setDivdPymtDivCd(String  divdPymtDivCd) { set( ATTR_DIVDPYMTDIVCD ,divdPymtDivCd);}
	/** get 분할납부구분코드 : divdPymtDivCd */
	public String  getDivdPymtDivCd() { return (String )get( ATTR_DIVDPYMTDIVCD );}

	/** set 분할납부횟수 : divdPymt */
	public void setDivdPymt(Long  divdPymt) { set( ATTR_DIVDPYMT ,divdPymt);}
	/** get 분할납부횟수 : divdPymt */
	public Long  getDivdPymt() { return (Long )get( ATTR_DIVDPYMT );}
	
	/** set 공제년월 : dducYrMnth */
	public void setDducYrMnth(String  dducYrMnth) { set( ATTR_DDUCYRMNTH ,dducYrMnth);}
	/** get 공제년월 : dducYrMnth */
	public String  getDducYrMnth() { return (String )get( ATTR_DDUCYRMNTH );}
	
	/** set 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public void setHlthYrtxPrcsDt(String hlthYrtxPrcsDt) { set(ATTR_HLTHYRTXPRCSDT, hlthYrtxPrcsDt); }
	/** get 건강연말정산처리일자 : hlthYrtxPrcsDt */
	public String getHlthYrtxPrcsDt() { return (String)get(ATTR_HLTHYRTXPRCSDT); }
	
	/** set 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public void setHlthInsrYrtxPrcsYn(String hlthInsrYrtxPrcsYn) { set(ATTR_HLTHINSRYRTXPRCSYN, hlthInsrYrtxPrcsYn); }
	/** get 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	public String getHlthInsrYrtxPrcsYn() { return (String)get(ATTR_HLTHINSRYRTXPRCSYN); }
	
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