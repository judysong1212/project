package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr2510VO.java
 * @Description : Insr2510 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2510BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public static final String ATTR_SOCINSRLSSEMYMTNUM = "socInsrLssEmymtNum";

	/** set 작성년월 : retryYrMnth */
	public static final String ATTR_RETRYYRMNTH = "retryYrMnth";

	/** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	public static final String ATTR_SEVEPAYDTLPATRNUM = "sevePayDtlPatrNum";

	/** set 임금산정시작일자 : payPymtBgnnDt */
	public static final String ATTR_PAYPYMTBGNNDT = "payPymtBgnnDt";

	/** set 임금산정종료일자 : payPymtEndDt */
	public static final String ATTR_PAYPYMTENDDT = "payPymtEndDt";

	/** set 임금산정일수 : pymtNumDys */
	public static final String ATTR_PYMTNUMDYS = "pymtNumDys";

	/** set 임금_기본급금액 : amntBspySum */
	public static final String ATTR_AMNTBSPYSUM = "amntBspySum";

	/** set 임금_이외수당금액 : amntEtcExtpySum */
	public static final String ATTR_AMNTETCEXTPYSUM = "amntEtcExtpySum";

	/** set 임금_상여금액 : amntAllwBnusSum */
	public static final String ATTR_AMNTALLWBNUSSUM = "amntAllwBnusSum";

	/** set 임금_연차수당금액 : amntAnnlExtpySum */
	public static final String ATTR_AMNTANNLEXTPYSUM = "amntAnnlExtpySum";

	/** set 임금_기타금액 : amntEtcSum */
	public static final String ATTR_AMNTETCSUM = "amntEtcSum";

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
	 public Insr2510BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr2510BM(
			 String  dpobCd 
			, String  systemkey 
			, Long  socInsrLssEmymtNum 
			, String  retryYrMnth 
			, Long  sevePayDtlPatrNum 
			, String  payPymtBgnnDt 
			, String  payPymtEndDt 
			, Long  pymtNumDys 
			, Long  amntBspySum 
			, Long  amntEtcExtpySum 
			, Long  amntAllwBnusSum 
			, Long  amntAnnlExtpySum 
			, Long  amntEtcSum 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_SOCINSRLSSEMYMTNUM,socInsrLssEmymtNum);
	 	values.put(ATTR_RETRYYRMNTH,retryYrMnth);
	 	values.put(ATTR_SEVEPAYDTLPATRNUM,sevePayDtlPatrNum);
	 	values.put(ATTR_PAYPYMTBGNNDT,payPymtBgnnDt);
	 	values.put(ATTR_PAYPYMTENDDT,payPymtEndDt);
	 	values.put(ATTR_PYMTNUMDYS,pymtNumDys);
	 	values.put(ATTR_AMNTBSPYSUM,amntBspySum);
	 	values.put(ATTR_AMNTETCEXTPYSUM,amntEtcExtpySum);
	 	values.put(ATTR_AMNTALLWBNUSSUM,amntAllwBnusSum);
	 	values.put(ATTR_AMNTANNLEXTPYSUM,amntAnnlExtpySum);
	 	values.put(ATTR_AMNTETCSUM,amntEtcSum);
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

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public void setSocInsrLssEmymtNum(Long  socInsrLssEmymtNum) { set( ATTR_SOCINSRLSSEMYMTNUM ,socInsrLssEmymtNum);}
	/** get 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public Long  getSocInsrLssEmymtNum() { return (Long )get( ATTR_SOCINSRLSSEMYMTNUM );}

	/** set 작성년월 : retryYrMnth */
	public void setRetryYrMnth(String  retryYrMnth) { set( ATTR_RETRYYRMNTH ,retryYrMnth);}
	/** get 작성년월 : retryYrMnth */
	public String  getRetryYrMnth() { return (String )get( ATTR_RETRYYRMNTH );}

	/** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	public void setSevePayDtlPatrNum(Long  sevePayDtlPatrNum) { set( ATTR_SEVEPAYDTLPATRNUM ,sevePayDtlPatrNum);}
	/** get 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
	public Long  getSevePayDtlPatrNum() { return (Long )get( ATTR_SEVEPAYDTLPATRNUM );}

	/** set 임금산정시작일자 : payPymtBgnnDt */
	public void setPayPymtBgnnDt(String  payPymtBgnnDt) { set( ATTR_PAYPYMTBGNNDT ,payPymtBgnnDt);}
	/** get 임금산정시작일자 : payPymtBgnnDt */
	public String  getPayPymtBgnnDt() { return (String )get( ATTR_PAYPYMTBGNNDT );}

	/** set 임금산정종료일자 : payPymtEndDt */
	public void setPayPymtEndDt(String  payPymtEndDt) { set( ATTR_PAYPYMTENDDT ,payPymtEndDt);}
	/** get 임금산정종료일자 : payPymtEndDt */
	public String  getPayPymtEndDt() { return (String )get( ATTR_PAYPYMTENDDT );}

	/** set 임금산정일수 : pymtNumDys */
	public void setPymtNumDys(Long  pymtNumDys) { set( ATTR_PYMTNUMDYS ,pymtNumDys);}
	/** get 임금산정일수 : pymtNumDys */
	public Long  getPymtNumDys() { return (Long )get( ATTR_PYMTNUMDYS );}

	/** set 임금_기본급금액 : amntBspySum */
	public void setAmntBspySum(Long  amntBspySum) { set( ATTR_AMNTBSPYSUM ,amntBspySum);}
	/** get 임금_기본급금액 : amntBspySum */
	public Long  getAmntBspySum() { return (Long )get( ATTR_AMNTBSPYSUM );}

	/** set 임금_이외수당금액 : amntEtcExtpySum */
	public void setAmntEtcExtpySum(Long  amntEtcExtpySum) { set( ATTR_AMNTETCEXTPYSUM ,amntEtcExtpySum);}
	/** get 임금_이외수당금액 : amntEtcExtpySum */
	public Long  getAmntEtcExtpySum() { return (Long )get( ATTR_AMNTETCEXTPYSUM );}

	/** set 임금_상여금액 : amntAllwBnusSum */
	public void setAmntAllwBnusSum(Long  amntAllwBnusSum) { set( ATTR_AMNTALLWBNUSSUM ,amntAllwBnusSum);}
	/** get 임금_상여금액 : amntAllwBnusSum */
	public Long  getAmntAllwBnusSum() { return (Long )get( ATTR_AMNTALLWBNUSSUM );}

	/** set 임금_연차수당금액 : amntAnnlExtpySum */
	public void setAmntAnnlExtpySum(Long  amntAnnlExtpySum) { set( ATTR_AMNTANNLEXTPYSUM ,amntAnnlExtpySum);}
	/** get 임금_연차수당금액 : amntAnnlExtpySum */
	public Long  getAmntAnnlExtpySum() { return (Long )get( ATTR_AMNTANNLEXTPYSUM );}

	/** set 임금_기타금액 : amntEtcSum */
	public void setAmntEtcSum(Long  amntEtcSum) { set( ATTR_AMNTETCSUM ,amntEtcSum);}
	/** get 임금_기타금액 : amntEtcSum */
	public Long  getAmntEtcSum() { return (Long )get( ATTR_AMNTETCSUM );}

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
