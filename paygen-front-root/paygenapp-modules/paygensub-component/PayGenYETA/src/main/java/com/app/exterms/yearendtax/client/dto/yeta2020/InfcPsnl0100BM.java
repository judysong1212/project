package com.app.exterms.yearendtax.client.dto.yeta2020;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPsnl0100BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    
	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 고용일련번호 : emymtSeilNum */
    public static final String ATTR_EMYMTSEILNUM = "emymtSeilNum";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    
    /** set 고용구분코드 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 고용유형코드 : emymtTypCd */
    public static final String ATTR_EMYMTTYPCD = "emymtTypCd";

    /** set 고용시작일자 : emymtBgnnDt */
    public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

    /** set 고용종료일자 : emymtEndDt */
    public static final String ATTR_EMYMTENDDT = "emymtEndDt";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 부서코드 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 현근무지명 : currPaeWorkNm */
    public static final String ATTR_CURRPAEWORKNM = "currPaeWorkNm";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 사업코드 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종코드 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
    
    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 급여지급구분코드 : payPymtDivCd */
    public static final String ATTR_PAYPYMTDIVCD = "payPymtDivCd";

    /** set 고용금액 : emymtSum */
    public static final String ATTR_EMYMTSUM = "emymtSum";

    /** set 고용사유내용 : emymtReasCtnt */
    public static final String ATTR_EMYMTREASCTNT = "emymtReasCtnt";

    /** set 증번호 : certNumHuhd */
    public static final String ATTR_CERTNUMHUHD = "certNumHuhd";

    /** set 경감시작일자 : rducBgnnDt */
    public static final String ATTR_RDUCBGNNDT = "rducBgnnDt";

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

    /** set 경감종료일자 : rducEndDt */
    public static final String ATTR_RDUCENDDT = "rducEndDt";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 환산비율구분코드 : cvsnRtoDivCd */
    public static final String ATTR_CVSNRTODIVCD = "cvsnRtoDivCd";

    /** set 근속년수 : dutyYrNum */
    public static final String ATTR_DUTYYRNUM = "dutyYrNum";

    /** set 근속월수 : dutyMnthIcm */
    public static final String ATTR_DUTYMNTHICM = "dutyMnthIcm";

    /** set 근속일수 : dutyDayNum */
    public static final String ATTR_DUTYDAYNUM = "dutyDayNum";

    /** set 근속전체일수 : dutyTotDayNum */
    public static final String ATTR_DUTYTOTDAYNUM = "dutyTotDayNum";
    
	/** set 직종세통합명 : dtilOccuInttnNm */
	public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";
	
	/** set 최초고용일자 : frstEmymtDt */
	public static final String ATTR_FRSTEMYMTDT = "frstEmymtDt";
	
	/** set 재직상태코드 : hdofcCodtnCd */
	public static final String ATTR_HDOFCCODTNCD = "hdofcCodtnCd";
	
	/** set 재직상태명 : hdofcCodtnNm */
	public static final String ATTR_HDOFCCODTNNM = "hdofcCodtnNm";
	
	/** set 국가코드 : natnCd */
	public static final String ATTR_NATNCD = "natnCd";
	
	/** set 국가코드 : natnNm */
	public static final String ATTR_NATNNM = "natnNm";
	
	/** set 호주성명 : hfmlyNm */
	public static final String ATTR_HFMLYNM = "hfmlyNm";

	/** set 호주와의관계코드 : hfmlyRelaCd */
	public static final String ATTR_HFMLYRELACD = "hfmlyRelaCd";
	
	/** set 생년월일 : yoobhMnthDay */
	public static final String ATTR_YOOBHMNTHDAY = "yoobhMnthDay";

    /** 생성자 */
     public InfcPsnl0100BM() { super(); } 

    /** 일괄등록 처리   */
     public InfcPsnl0100BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  emymtSeilNum 
    		, String  emymtDivCd 
    		, String  emymtTypCd 
    		, String  emymtBgnnDt 
    		, String  emymtEndDt 
    		, String  deptCd 
    		, String  currPaeWorkNm 
    		, String  businCd 
    		, String  typOccuCd 
    		, String  dtilOccuClsDivCd 
    		, String  odtyCd 
    		, String  payPymtDivCd 
    		, BigDecimal  emymtSum 
    		, String  emymtReasCtnt 
    		, String  certNumHuhd 
    		, String  rducBgnnDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  rducEndDt 
    		, String  pyspGrdeCd 
    		, String  dtilOccuInttnCd 
    		, String  cvsnRtoDivCd 
    		, BigDecimal  dutyYrNum 
    		, BigDecimal  dutyMnthIcm 
    		, BigDecimal  dutyDayNum 
    		, BigDecimal  dutyTotDayNum
    		, String yoobhMnthDay) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_EMYMTSEILNUM,emymtSeilNum);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_EMYMTTYPCD,emymtTypCd);
     	values.put(ATTR_EMYMTBGNNDT,emymtBgnnDt);
     	values.put(ATTR_EMYMTENDDT,emymtEndDt);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_CURRPAEWORKNM,currPaeWorkNm);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_PAYPYMTDIVCD,payPymtDivCd);
     	values.put(ATTR_EMYMTSUM,emymtSum);
     	values.put(ATTR_EMYMTREASCTNT,emymtReasCtnt);
     	values.put(ATTR_CERTNUMHUHD,certNumHuhd);
     	values.put(ATTR_RDUCBGNNDT,rducBgnnDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_RDUCENDDT,rducEndDt);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_CVSNRTODIVCD,cvsnRtoDivCd);
     	values.put(ATTR_DUTYYRNUM,dutyYrNum);
     	values.put(ATTR_DUTYMNTHICM,dutyMnthIcm);
     	values.put(ATTR_DUTYDAYNUM,dutyDayNum);
     	values.put(ATTR_DUTYTOTDAYNUM,dutyTotDayNum); 
     values.put(ATTR_YOOBHMNTHDAY,yoobhMnthDay); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 고용일련번호 : emymtSeilNum */
    public void setEmymtSeilNum(BigDecimal  emymtSeilNum) { set( ATTR_EMYMTSEILNUM ,emymtSeilNum);}
    /** get 고용일련번호 : emymtSeilNum */
    public BigDecimal  getEmymtSeilNum() { return (BigDecimal )get( ATTR_EMYMTSEILNUM );}
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    
    /** set 고용구분코드 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM,emymtDivNm);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
    
    /** set 고용유형코드 : emymtTypCd */
    public void setEmymtTypCd(String  emymtTypCd) { set( ATTR_EMYMTTYPCD ,emymtTypCd);}
    /** get 고용유형코드 : emymtTypCd */
    public String  getEmymtTypCd() { return (String )get( ATTR_EMYMTTYPCD );}
    /** set 고용시작일자 : emymtBgnnDt */
    public void setEmymtBgnnDt(String  emymtBgnnDt) { set( ATTR_EMYMTBGNNDT ,emymtBgnnDt);}
    /** get 고용시작일자 : emymtBgnnDt */
    public String  getEmymtBgnnDt() { return (String )get( ATTR_EMYMTBGNNDT );}
    /** set 고용종료일자 : emymtEndDt */
    public void setEmymtEndDt(String  emymtEndDt) { set( ATTR_EMYMTENDDT ,emymtEndDt);}
    /** get 고용종료일자 : emymtEndDt */
    public String  getEmymtEndDt() { return (String )get( ATTR_EMYMTENDDT );}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    /** set 부서코드 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서코드 : deptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    /** set 현근무지명 : currPaeWorkNm */
    public void setCurrPaeWorkNm(String  currPaeWorkNm) { set( ATTR_CURRPAEWORKNM ,currPaeWorkNm);}
    /** get 현근무지명 : currPaeWorkNm */
    public String  getCurrPaeWorkNm() { return (String )get( ATTR_CURRPAEWORKNM );}
    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
    /** set 사업코드 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업코드 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}   
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    /** set 직종코드 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종코드 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
    
    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}
    /** set 급여지급구분코드 : payPymtDivCd */
    public void setPayPymtDivCd(String  payPymtDivCd) { set( ATTR_PAYPYMTDIVCD ,payPymtDivCd);}
    /** get 급여지급구분코드 : payPymtDivCd */
    public String  getPayPymtDivCd() { return (String )get( ATTR_PAYPYMTDIVCD );}
    /** set 고용금액 : emymtSum */
    public void setEmymtSum(BigDecimal  emymtSum) { set( ATTR_EMYMTSUM ,emymtSum);}
    /** get 고용금액 : emymtSum */
    public BigDecimal  getEmymtSum() { return (BigDecimal )get( ATTR_EMYMTSUM );}
    /** set 고용사유내용 : emymtReasCtnt */
    public void setEmymtReasCtnt(String  emymtReasCtnt) { set( ATTR_EMYMTREASCTNT ,emymtReasCtnt);}
    /** get 고용사유내용 : emymtReasCtnt */
    public String  getEmymtReasCtnt() { return (String )get( ATTR_EMYMTREASCTNT );}
    /** set 증번호 : certNumHuhd */
    public void setCertNumHuhd(String  certNumHuhd) { set( ATTR_CERTNUMHUHD ,certNumHuhd);}
    /** get 증번호 : certNumHuhd */
    public String  getCertNumHuhd() { return (String )get( ATTR_CERTNUMHUHD );}
    /** set 경감시작일자 : rducBgnnDt */
    public void setRducBgnnDt(String  rducBgnnDt) { set( ATTR_RDUCBGNNDT ,rducBgnnDt);}
    /** get 경감시작일자 : rducBgnnDt */
    public String  getRducBgnnDt() { return (String )get( ATTR_RDUCBGNNDT );}
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
    /** set 경감종료일자 : rducEndDt */
    public void setRducEndDt(String  rducEndDt) { set( ATTR_RDUCENDDT ,rducEndDt);}
    /** get 경감종료일자 : rducEndDt */
    public String  getRducEndDt() { return (String )get( ATTR_RDUCENDDT );}
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
    /** set 직종통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    /** set 환산비율구분코드 : cvsnRtoDivCd */
    public void setCvsnRtoDivCd(String  cvsnRtoDivCd) { set( ATTR_CVSNRTODIVCD ,cvsnRtoDivCd);}
    /** get 환산비율구분코드 : cvsnRtoDivCd */
    public String  getCvsnRtoDivCd() { return (String )get( ATTR_CVSNRTODIVCD );}
    /** set 근속년수 : dutyYrNum */
    public void setDutyYrNum(BigDecimal  dutyYrNum) { set( ATTR_DUTYYRNUM ,dutyYrNum);}
    /** get 근속년수 : dutyYrNum */
    public BigDecimal  getDutyYrNum() { return (BigDecimal )get( ATTR_DUTYYRNUM );}
    /** set 근속월수 : dutyMnthIcm */
    public void setDutyMnthIcm(BigDecimal  dutyMnthIcm) { set( ATTR_DUTYMNTHICM ,dutyMnthIcm);}
    /** get 근속월수 : dutyMnthIcm */
    public BigDecimal  getDutyMnthIcm() { return (BigDecimal )get( ATTR_DUTYMNTHICM );}
    /** set 근속일수 : dutyDayNum */
    public void setDutyDayNum(BigDecimal  dutyDayNum) { set( ATTR_DUTYDAYNUM ,dutyDayNum);}
    /** get 근속일수 : dutyDayNum */
    public BigDecimal  getDutyDayNum() { return (BigDecimal )get( ATTR_DUTYDAYNUM );}
    /** set 근속전체일수 : dutyTotDayNum */
    public void setDutyTotDayNum(BigDecimal  dutyTotDayNum) { set( ATTR_DUTYTOTDAYNUM ,dutyTotDayNum);}
    /** get 근속전체일수 : dutyTotDayNum */
    public BigDecimal  getDutyTotDayNum() { return (BigDecimal )get( ATTR_DUTYTOTDAYNUM );}
	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	/** set 급여관리부서코드 : payrMangDeptCd */
	public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
	/** get 급여관리부서코드 : payrMangDeptCd */
	public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
	/** set 직종세통합코드 : dtilOccuInttnNm */
	public void setDtilOccuInttnNm(String dtilOccuInttnNm) {set(ATTR_DTILOCCUINTTNNM, dtilOccuInttnNm);}
	/** get 직종세통합코드 : dtilOccuInttnNm */
	public String getDtilOccuInttnNm() {return (String) get(ATTR_DTILOCCUINTTNNM);}
	
	/** set 최초고용일자 : frstEmymtDt */
	public void setFrstEmymtDt(String frstEmymtDt) {
		set(ATTR_FRSTEMYMTDT, frstEmymtDt);
	}

	/** get 최초고용일자 : frstEmymtDt */
	public String getFrstEmymtDt() {
		return (String) get(ATTR_FRSTEMYMTDT);
	}
	
	/** set 재직상태코드 : hdofcCodtnCd */
	public void setHdofcCodtnCd(String hdofcCodtnCd) {
		set(ATTR_HDOFCCODTNCD, hdofcCodtnCd);
	}

	/** get 재직상태코드 : hdofcCodtnCd */
	public String getHdofcCodtnCd() {
		return (String) get(ATTR_HDOFCCODTNCD);
	}

	/** set 재직상태코드 : hdofcCodtnNm */
	public void setHdofcCodtnNm(String hdofcCodtnNm) {
		set(ATTR_HDOFCCODTNNM, hdofcCodtnNm);
	}

	/** get 재직상태코드 : hdofcCodtnNm */
	public String getHdofcCodtnNm() {
		return (String) get(ATTR_HDOFCCODTNNM);
	}
	
	/** set 국가코드 : natnCd */
	public void setNatnCd(String  natnCd) { set( ATTR_NATNCD ,natnCd);}
	/** get 국가코드 : natnCd */
	public String  getNatnCd() { return (String )get( ATTR_NATNCD );}
	
	/** set 국가코드 : natnNm */
	public void setNatnNm(String  natnNm) { set( ATTR_NATNNM ,natnNm);}
	/** get 국가코드 : natnNm */
	public String  getNatnNm() { return (String )get( ATTR_NATNNM );}
	
	
	/** set 호주성명 : hfmlyNm */
	public void setHfmlyNm(String  hfmlyNm) { set( ATTR_HFMLYNM ,hfmlyNm);}
	/** get 호주성명 : hfmlyNm */
	public String  getHfmlyNm() { return (String )get( ATTR_HFMLYNM );}
	/** set 호주와의관계코드 : hfmlyRelaCd */
	public void setHfmlyRelaCd(String  hfmlyRelaCd) { set( ATTR_HFMLYRELACD ,hfmlyRelaCd);}
	/** get 호주와의관계코드 : hfmlyRelaCd */
	public String  getHfmlyRelaCd() { return (String )get( ATTR_HFMLYRELACD );}
	
	/** set 생년월일 : yoobhMnthDay */
    public void setYoobhMnthDay(String  yoobhMnthDay) { set( ATTR_YOOBHMNTHDAY ,yoobhMnthDay);}
    /** get 생년월일 : yoobhMnthDay */
    public String  getYoobhMnthDay() { return (String )get( ATTR_YOOBHMNTHDAY );}
}
