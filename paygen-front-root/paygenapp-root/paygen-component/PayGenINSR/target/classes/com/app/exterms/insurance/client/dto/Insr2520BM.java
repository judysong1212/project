package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr2520VO.java
 * @Description : Insr2520 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2520BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 작성년월 : retryYrMnth */
	public static final String ATTR_RETRYYRMNTH = "retryYrMnth";

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public static final String ATTR_SOCINSRLSSEMYMTNUM = "socInsrLssEmymtNum";

	/** set 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
	public static final String ATTR_CMPTTNTGTPRIDSEILNUM = "cmpttnTgtPridSeilNum";

	/** set 산정대상시작일자 : cmpttnTgtBgnnDt */
	public static final String ATTR_CMPTTNTGTBGNNDT = "cmpttnTgtBgnnDt";

	/** set 산정대상종료일자 : cmpttnTgtEndDt */
	public static final String ATTR_CMPTTNTGTENDDT = "cmpttnTgtEndDt";

	/** set 임금지급기초일수 : amntPymtNumDys */
	public static final String ATTR_AMNTPYMTNUMDYS = "amntPymtNumDys";

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
	 public Insr2520BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr2520BM(
			 String  dpobCd 
			, String  systemkey 
			, String  retryYrMnth 
			, Long  socInsrLssEmymtNum 
			, Long  cmpttnTgtPridSeilNum 
			, String  cmpttnTgtBgnnDt 
			, String  cmpttnTgtEndDt 
			, Long  amntPymtNumDys 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_RETRYYRMNTH,retryYrMnth);
	 	values.put(ATTR_SOCINSRLSSEMYMTNUM,socInsrLssEmymtNum);
	 	values.put(ATTR_CMPTTNTGTPRIDSEILNUM,cmpttnTgtPridSeilNum);
	 	values.put(ATTR_CMPTTNTGTBGNNDT,cmpttnTgtBgnnDt);
	 	values.put(ATTR_CMPTTNTGTENDDT,cmpttnTgtEndDt);
	 	values.put(ATTR_AMNTPYMTNUMDYS,amntPymtNumDys);
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

	/** set 작성년월 : retryYrMnth */
	public void setRetryYrMnth(String  retryYrMnth) { set( ATTR_RETRYYRMNTH ,retryYrMnth);}
	/** get 작성년월 : retryYrMnth */
	public String  getRetryYrMnth() { return (String )get( ATTR_RETRYYRMNTH );}

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public void setSocInsrLssEmymtNum(Long  socInsrLssEmymtNum) { set( ATTR_SOCINSRLSSEMYMTNUM ,socInsrLssEmymtNum);}
	/** get 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public Long  getSocInsrLssEmymtNum() { return (Long )get( ATTR_SOCINSRLSSEMYMTNUM );}

	/** set 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
	public void setCmpttnTgtPridSeilNum(Long  cmpttnTgtPridSeilNum) { set( ATTR_CMPTTNTGTPRIDSEILNUM ,cmpttnTgtPridSeilNum);}
	/** get 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
	public Long  getCmpttnTgtPridSeilNum() { return (Long )get( ATTR_CMPTTNTGTPRIDSEILNUM );}

	/** set 산정대상시작일자 : cmpttnTgtBgnnDt */
	public void setCmpttnTgtBgnnDt(String  cmpttnTgtBgnnDt) { set( ATTR_CMPTTNTGTBGNNDT ,cmpttnTgtBgnnDt);}
	/** get 산정대상시작일자 : cmpttnTgtBgnnDt */
	public String  getCmpttnTgtBgnnDt() { return (String )get( ATTR_CMPTTNTGTBGNNDT );}

	/** set 산정대상종료일자 : cmpttnTgtEndDt */
	public void setCmpttnTgtEndDt(String  cmpttnTgtEndDt) { set( ATTR_CMPTTNTGTENDDT ,cmpttnTgtEndDt);}
	/** get 산정대상종료일자 : cmpttnTgtEndDt */
	public String  getCmpttnTgtEndDt() { return (String )get( ATTR_CMPTTNTGTENDDT );}

	/** set 임금지급기초일수 : amntPymtNumDys */
	public void setAmntPymtNumDys(Long  amntPymtNumDys) { set( ATTR_AMNTPYMTNUMDYS ,amntPymtNumDys);}
	/** get 임금지급기초일수 : amntPymtNumDys */
	public Long  getAmntPymtNumDys() { return (Long )get( ATTR_AMNTPYMTNUMDYS );}

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
