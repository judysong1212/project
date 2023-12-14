package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr5300VO.java
 * @Description : Insr5300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5300BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 고용일련번호 : emymtSeilNum */
	public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

	/** set 고용보험정산년도 : umytInsrClutYr */
	public static final String ATTR_UMYTINSRCLUTYR = "umytInsrClutYr";

	/** set 보험료부과구분코드 : prmmIposDivCd */
	public static final String ATTR_PRMMIPOSDIVCD = "prmmIposDivCd";

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public static final String ATTR_UMYTINSRAQTNDT = "umytInsrAqtnDt";

	/** set 고용보험상실일자 : umytInsrLssDt */
	public static final String ATTR_UMYTINSRLSSDT = "umytInsrLssDt";

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public static final String ATTR_UMYTINSRPAYTOTAMNT = "umytInsrPayTotAmnt";

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
	 public Insr5300BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr5300BM(
			 String  dpobCd 
			, String  systemkey 
			, String  umytInsrClutYr 
			, String  prmmIposDivCd 
			, String  umytInsrAqtnDt 
			, String  umytInsrLssDt 
			, Long  umytInsrPayTotAmnt 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_UMYTINSRCLUTYR,umytInsrClutYr);
	 	values.put(ATTR_PRMMIPOSDIVCD,prmmIposDivCd);
	 	values.put(ATTR_UMYTINSRAQTNDT,umytInsrAqtnDt);
	 	values.put(ATTR_UMYTINSRLSSDT,umytInsrLssDt);
	 	values.put(ATTR_UMYTINSRPAYTOTAMNT,umytInsrPayTotAmnt);
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

	/** set 고용일련번호 : emymtSeilNum */
	public void setEmymtSeilNum(Long  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
	/** get 고용일련번호 : emymtSeilNum */
	public Long  getEmymtSeilNum() { return (Long )get( ATTR_EMYMTSEILNUM );}

	/** set 고용보험정산년도 : umytInsrClutYr */
	public void setUmytInsrClutYr(String  umytInsrClutYr) { set( ATTR_UMYTINSRCLUTYR ,umytInsrClutYr);}
	/** get 고용보험정산년도 : umytInsrClutYr */
	public String  getUmytInsrClutYr() { return (String )get( ATTR_UMYTINSRCLUTYR );}

	/** set 보험료부과구분코드 : prmmIposDivCd */
	public void setPrmmIposDivCd(String  prmmIposDivCd) { set( ATTR_PRMMIPOSDIVCD ,prmmIposDivCd);}
	/** get 보험료부과구분코드 : prmmIposDivCd */
	public String  getPrmmIposDivCd() { return (String )get( ATTR_PRMMIPOSDIVCD );}

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public void setUmytInsrAqtnDt(String  umytInsrAqtnDt) { set( ATTR_UMYTINSRAQTNDT ,umytInsrAqtnDt);}
	/** get 고용보험취득일자 : umytInsrAqtnDt */
	public String  getUmytInsrAqtnDt() { return (String )get( ATTR_UMYTINSRAQTNDT );}

	/** set 고용보험상실일자 : umytInsrLssDt */
	public void setUmytInsrLssDt(String  umytInsrLssDt) { set( ATTR_UMYTINSRLSSDT ,umytInsrLssDt);}
	/** get 고용보험상실일자 : umytInsrLssDt */
	public String  getUmytInsrLssDt() { return (String )get( ATTR_UMYTINSRLSSDT );}

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public void setUmytInsrPayTotAmnt(Long  umytInsrPayTotAmnt) { set( ATTR_UMYTINSRPAYTOTAMNT ,umytInsrPayTotAmnt);}
	/** get 고용보험보수총액 : umytInsrPayTotAmnt */
	public Long  getUmytInsrPayTotAmnt() { return (Long )get( ATTR_UMYTINSRPAYTOTAMNT );}

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
