package com.app.exterms.insurance.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Insr2500VO.java
 * @Description : Insr2500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr2500BM  extends MSFSimpleBaseModel implements IsSerializable   {
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 작성년월 : retryYrMnth */
	public static final String ATTR_RETRYYRMNTH = "retryYrMnth";

	/** set 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
	public static final String ATTR_SOCINSRLSSEMYMTNUM = "socInsrLssEmymtNum";

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public static final String ATTR_SOCTYINSURCMPTNDT = "soctyInsurCmptnDt";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";

	/** set 성명 : nm */
	public static final String ATTR_NM = "nm";

	/** set 입사일자 : icncDt */
	public static final String ATTR_ICNCDT = "icncDt";

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public static final String ATTR_UMYTINSRAQTNDT = "umytInsrAqtnDt";

	/** set 퇴직일자 : retryDt */
	public static final String ATTR_RETRYDT = "retryDt";

	/** set 고용보험이직사유코드 : umytInsrChgjbReasCd */
	public static final String ATTR_UMYTINSRCHGJBREASCD = "umytInsrChgjbReasCd";

	/** set 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
	public static final String ATTR_UMYTINSRSPECRESNCTNT = "umytInsrSpecResnCtnt";

	/** set 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
	public static final String ATTR_USALYTISEDUNTPRIDNUMDYS = "usalyTisedUntPridNumDys";

	/** set 평균임금계산총일수 : avgAmntCalcTotNumDys */
	public static final String ATTR_AVGAMNTCALCTOTNUMDYS = "avgAmntCalcTotNumDys";

	/** set 평균임금기본금금액 : avgAmntFndtnSum */
	public static final String ATTR_AVGAMNTFNDTNSUM = "avgAmntFndtnSum";

	/** set 평균임금이외수당금액 : avgAmntEtcExtpySum */
	public static final String ATTR_AVGAMNTETCEXTPYSUM = "avgAmntEtcExtpySum";

	/** set 평균임금상여금금액 : avgAmntAllwBnusSum */
	public static final String ATTR_AVGAMNTALLWBNUSSUM = "avgAmntAllwBnusSum";

	/** set 평균임금연차수당금액 : avgAmntAnnlExtpySum */
	public static final String ATTR_AVGAMNTANNLEXTPYSUM = "avgAmntAnnlExtpySum";

	/** set 평균임금기타금액 : avgAmntEtcSum */
	public static final String ATTR_AVGAMNTETCSUM = "avgAmntEtcSum";

	/** set 평균임금액 : avgAmntQnty */
	public static final String ATTR_AVGAMNTQNTY = "avgAmntQnty";

	/** set 통상임금액 : usalyAmntWag */
	public static final String ATTR_USALYAMNTWAG = "usalyAmntWag";

	/** set 기준임금액 : stdAmntWag */
	public static final String ATTR_STDAMNTWAG = "stdAmntWag";

	/** set 1일소정근로시간 : dayFxdWorkTmNum */
	public static final String ATTR_DAYFXDWORKTMNUM = "dayFxdWorkTmNum";

	/** set 퇴직금수령금액 : sevePayReipSum */
	public static final String ATTR_SEVEPAYREIPSUM = "sevePayReipSum";

	/** set 퇴직금외기타금액 : sevePayRstEtcSum */
	public static final String ATTR_SEVEPAYRSTETCSUM = "sevePayRstEtcSum";

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
	 public Insr2500BM() { super(); } 

	/** 일괄등록 처리   */
	 public Insr2500BM(
			 String  dpobCd 
			, String  systemkey 
			, String  retryYrMnth 
			, Long  socInsrLssEmymtNum 
			, String  soctyInsurCmptnDt 
			, String  deptCd 
			, String  nm 
			, String  icncDt 
			, String  umytInsrAqtnDt 
			, String  retryDt 
			, String  umytInsrChgjbReasCd 
			, String  umytInsrSpecResnCtnt 
			, Long  usalyTisedUntPridNumDys 
			, Long  avgAmntCalcTotNumDys 
			, Long  avgAmntFndtnSum 
			, Long  avgAmntEtcExtpySum 
			, Long  avgAmntAllwBnusSum 
			, Long  avgAmntAnnlExtpySum 
			, Long  avgAmntEtcSum 
			, Long  avgAmntQnty 
			, Long  usalyAmntWag 
			, Long  stdAmntWag 
			, String  dayFxdWorkTmNum 
			, Long  sevePayReipSum 
			, Long  sevePayRstEtcSum 
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
	 	values.put(ATTR_SOCTYINSURCMPTNDT,soctyInsurCmptnDt);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_NM,nm);
	 	values.put(ATTR_ICNCDT,icncDt);
	 	values.put(ATTR_UMYTINSRAQTNDT,umytInsrAqtnDt);
	 	values.put(ATTR_RETRYDT,retryDt);
	 	values.put(ATTR_UMYTINSRCHGJBREASCD,umytInsrChgjbReasCd);
	 	values.put(ATTR_UMYTINSRSPECRESNCTNT,umytInsrSpecResnCtnt);
	 	values.put(ATTR_USALYTISEDUNTPRIDNUMDYS,usalyTisedUntPridNumDys);
	 	values.put(ATTR_AVGAMNTCALCTOTNUMDYS,avgAmntCalcTotNumDys);
	 	values.put(ATTR_AVGAMNTFNDTNSUM,avgAmntFndtnSum);
	 	values.put(ATTR_AVGAMNTETCEXTPYSUM,avgAmntEtcExtpySum);
	 	values.put(ATTR_AVGAMNTALLWBNUSSUM,avgAmntAllwBnusSum);
	 	values.put(ATTR_AVGAMNTANNLEXTPYSUM,avgAmntAnnlExtpySum);
	 	values.put(ATTR_AVGAMNTETCSUM,avgAmntEtcSum);
	 	values.put(ATTR_AVGAMNTQNTY,avgAmntQnty);
	 	values.put(ATTR_USALYAMNTWAG,usalyAmntWag);
	 	values.put(ATTR_STDAMNTWAG,stdAmntWag);
	 	values.put(ATTR_DAYFXDWORKTMNUM,dayFxdWorkTmNum);
	 	values.put(ATTR_SEVEPAYREIPSUM,sevePayReipSum);
	 	values.put(ATTR_SEVEPAYRSTETCSUM,sevePayRstEtcSum);
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

	/** set 사회보험작성일자 : soctyInsurCmptnDt */
	public void setSoctyInsurCmptnDt(String  soctyInsurCmptnDt) { set( ATTR_SOCTYINSURCMPTNDT ,soctyInsurCmptnDt);}
	/** get 사회보험작성일자 : soctyInsurCmptnDt */
	public String  getSoctyInsurCmptnDt() { return (String )get( ATTR_SOCTYINSURCMPTNDT );}

	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

	/** set 성명 : nm */
	public void setNm(String  nm) { set( ATTR_NM ,nm);}
	/** get 성명 : nm */
	public String  getNm() { return (String )get( ATTR_NM );}

	/** set 입사일자 : icncDt */
	public void setIcncDt(String  icncDt) { set( ATTR_ICNCDT ,icncDt);}
	/** get 입사일자 : icncDt */
	public String  getIcncDt() { return (String )get( ATTR_ICNCDT );}

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	public void setUmytInsrAqtnDt(String  umytInsrAqtnDt) { set( ATTR_UMYTINSRAQTNDT ,umytInsrAqtnDt);}
	/** get 고용보험취득일자 : umytInsrAqtnDt */
	public String  getUmytInsrAqtnDt() { return (String )get( ATTR_UMYTINSRAQTNDT );}

	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
	/** get 퇴직일자 : retryDt */
	public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}

	/** set 고용보험이직사유코드 : umytInsrChgjbReasCd */
	public void setUmytInsrChgjbReasCd(String  umytInsrChgjbReasCd) { set( ATTR_UMYTINSRCHGJBREASCD ,umytInsrChgjbReasCd);}
	/** get 고용보험이직사유코드 : umytInsrChgjbReasCd */
	public String  getUmytInsrChgjbReasCd() { return (String )get( ATTR_UMYTINSRCHGJBREASCD );}

	/** set 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
	public void setUmytInsrSpecResnCtnt(String  umytInsrSpecResnCtnt) { set( ATTR_UMYTINSRSPECRESNCTNT ,umytInsrSpecResnCtnt);}
	/** get 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
	public String  getUmytInsrSpecResnCtnt() { return (String )get( ATTR_UMYTINSRSPECRESNCTNT );}

	/** set 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
	public void setUsalyTisedUntPridNumDys(Long  usalyTisedUntPridNumDys) { set( ATTR_USALYTISEDUNTPRIDNUMDYS ,usalyTisedUntPridNumDys);}
	/** get 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
	public Long  getUsalyTisedUntPridNumDys() { return (Long )get( ATTR_USALYTISEDUNTPRIDNUMDYS );}

	/** set 평균임금계산총일수 : avgAmntCalcTotNumDys */
	public void setAvgAmntCalcTotNumDys(Long  avgAmntCalcTotNumDys) { set( ATTR_AVGAMNTCALCTOTNUMDYS ,avgAmntCalcTotNumDys);}
	/** get 평균임금계산총일수 : avgAmntCalcTotNumDys */
	public Long  getAvgAmntCalcTotNumDys() { return (Long )get( ATTR_AVGAMNTCALCTOTNUMDYS );}

	/** set 평균임금기본금금액 : avgAmntFndtnSum */
	public void setAvgAmntFndtnSum(Long  avgAmntFndtnSum) { set( ATTR_AVGAMNTFNDTNSUM ,avgAmntFndtnSum);}
	/** get 평균임금기본금금액 : avgAmntFndtnSum */
	public Long  getAvgAmntFndtnSum() { return (Long )get( ATTR_AVGAMNTFNDTNSUM );}

	/** set 평균임금이외수당금액 : avgAmntEtcExtpySum */
	public void setAvgAmntEtcExtpySum(Long  avgAmntEtcExtpySum) { set( ATTR_AVGAMNTETCEXTPYSUM ,avgAmntEtcExtpySum);}
	/** get 평균임금이외수당금액 : avgAmntEtcExtpySum */
	public Long  getAvgAmntEtcExtpySum() { return (Long )get( ATTR_AVGAMNTETCEXTPYSUM );}

	/** set 평균임금상여금금액 : avgAmntAllwBnusSum */
	public void setAvgAmntAllwBnusSum(Long  avgAmntAllwBnusSum) { set( ATTR_AVGAMNTALLWBNUSSUM ,avgAmntAllwBnusSum);}
	/** get 평균임금상여금금액 : avgAmntAllwBnusSum */
	public Long  getAvgAmntAllwBnusSum() { return (Long )get( ATTR_AVGAMNTALLWBNUSSUM );}

	/** set 평균임금연차수당금액 : avgAmntAnnlExtpySum */
	public void setAvgAmntAnnlExtpySum(Long  avgAmntAnnlExtpySum) { set( ATTR_AVGAMNTANNLEXTPYSUM ,avgAmntAnnlExtpySum);}
	/** get 평균임금연차수당금액 : avgAmntAnnlExtpySum */
	public Long  getAvgAmntAnnlExtpySum() { return (Long )get( ATTR_AVGAMNTANNLEXTPYSUM );}

	/** set 평균임금기타금액 : avgAmntEtcSum */
	public void setAvgAmntEtcSum(Long  avgAmntEtcSum) { set( ATTR_AVGAMNTETCSUM ,avgAmntEtcSum);}
	/** get 평균임금기타금액 : avgAmntEtcSum */
	public Long  getAvgAmntEtcSum() { return (Long )get( ATTR_AVGAMNTETCSUM );}

	/** set 평균임금액 : avgAmntQnty */
	public void setAvgAmntQnty(Long  avgAmntQnty) { set( ATTR_AVGAMNTQNTY ,avgAmntQnty);}
	/** get 평균임금액 : avgAmntQnty */
	public Long  getAvgAmntQnty() { return (Long )get( ATTR_AVGAMNTQNTY );}

	/** set 통상임금액 : usalyAmntWag */
	public void setUsalyAmntWag(Long  usalyAmntWag) { set( ATTR_USALYAMNTWAG ,usalyAmntWag);}
	/** get 통상임금액 : usalyAmntWag */
	public Long  getUsalyAmntWag() { return (Long )get( ATTR_USALYAMNTWAG );}

	/** set 기준임금액 : stdAmntWag */
	public void setStdAmntWag(Long  stdAmntWag) { set( ATTR_STDAMNTWAG ,stdAmntWag);}
	/** get 기준임금액 : stdAmntWag */
	public Long  getStdAmntWag() { return (Long )get( ATTR_STDAMNTWAG );}

	/** set 1일소정근로시간 : dayFxdWorkTmNum */
	public void setDayFxdWorkTmNum(String  dayFxdWorkTmNum) { set( ATTR_DAYFXDWORKTMNUM ,dayFxdWorkTmNum);}
	/** get 1일소정근로시간 : dayFxdWorkTmNum */
	public String  getDayFxdWorkTmNum() { return (String )get( ATTR_DAYFXDWORKTMNUM );}

	/** set 퇴직금수령금액 : sevePayReipSum */
	public void setSevePayReipSum(Long  sevePayReipSum) { set( ATTR_SEVEPAYREIPSUM ,sevePayReipSum);}
	/** get 퇴직금수령금액 : sevePayReipSum */
	public Long  getSevePayReipSum() { return (Long )get( ATTR_SEVEPAYREIPSUM );}

	/** set 퇴직금외기타금액 : sevePayRstEtcSum */
	public void setSevePayRstEtcSum(Long  sevePayRstEtcSum) { set( ATTR_SEVEPAYRSTETCSUM ,sevePayRstEtcSum);}
	/** get 퇴직금외기타금액 : sevePayRstEtcSum */
	public Long  getSevePayRstEtcSum() { return (Long )get( ATTR_SEVEPAYRSTETCSUM );}

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
