package com.app.exterms.personal.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0119BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 경력사항일련번호 : carrRsptSeilNum */
    public static final String ATTR_CARRRSPTSEILNUM = "carrRsptSeilNum";

    /** set 경력시작일자 : carrBgnnDt */
    public static final String ATTR_CARRBGNNDT = "carrBgnnDt";

    /** set 경력종료일자 : carrEndDt */
    public static final String ATTR_CARRENDDT = "carrEndDt";

    /** set 근무처명 : paeWorkNm */
    public static final String ATTR_PAEWORKNM = "paeWorkNm";

    /** set 경력구분코드 : carrDivCd */
    public static final String ATTR_CARRDIVCD = "carrDivCd";

    /** set 근무부서명 : dutyDeptNm */
    public static final String ATTR_DUTYDEPTNM = "dutyDeptNm";

    /** set 담당업무명 : repbtyBusinNm */
    public static final String ATTR_REPBTYBUSINNM = "repbtyBusinNm";

    /** set 직책명 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";

    /** set 임금일당금액 : amntDlywagSum */
    public static final String ATTR_AMNTDLYWAGSUM = "amntDlywagSum";

    /** set 경력비고내용 : carrNoteCtnt */
    public static final String ATTR_CARRNOTECTNT = "carrNoteCtnt";

    /** set 근무년수 : dutyYrNum */
    public static final String ATTR_DUTYYRNUM = "dutyYrNum";

    /** set 근무월수 : dutyMnthIcm */
    public static final String ATTR_DUTYMNTHICM = "dutyMnthIcm";

    /** set 환산비율 : cvsnRtoDivCd */
    public static final String ATTR_CVSNRTODIVCD = "cvsnRtoDivCd";

    /** set 가감월수 : ajmtMnthNum */
    public static final String ATTR_AJMTMNTHNUM = "ajmtMnthNum";

    /** set 인정월수 : rcgtnMnthNum */
    public static final String ATTR_RCGTNMNTHNUM = "rcgtnMnthNum";

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
     public Psnl0119BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0119BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  carrRsptSeilNum 
    		, String  carrBgnnDt 
    		, String  carrEndDt 
    		, String  paeWorkNm 
    		, String  carrDivCd 
    		, String  dutyDeptNm 
    		, String  repbtyBusinNm 
    		, String  odtyNm 
    		, BigDecimal  amntDlywagSum 
    		, String  carrNoteCtnt 
    		, BigDecimal  dutyYrNum 
    		, BigDecimal  dutyMnthIcm 
    		, String  cvsnRtoDivCd 
    		, BigDecimal  ajmtMnthNum 
    		, BigDecimal  rcgtnMnthNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_CARRRSPTSEILNUM,carrRsptSeilNum);
     	values.put(ATTR_CARRBGNNDT,carrBgnnDt);
     	values.put(ATTR_CARRENDDT,carrEndDt);
     	values.put(ATTR_PAEWORKNM,paeWorkNm);
     	values.put(ATTR_CARRDIVCD,carrDivCd);
     	values.put(ATTR_DUTYDEPTNM,dutyDeptNm);
     	values.put(ATTR_REPBTYBUSINNM,repbtyBusinNm);
     	values.put(ATTR_ODTYNM,odtyNm);
     	values.put(ATTR_AMNTDLYWAGSUM,amntDlywagSum);
     	values.put(ATTR_CARRNOTECTNT,carrNoteCtnt);
     	values.put(ATTR_DUTYYRNUM,dutyYrNum);
     	values.put(ATTR_DUTYMNTHICM,dutyMnthIcm);
     	values.put(ATTR_CVSNRTODIVCD,cvsnRtoDivCd);
     	values.put(ATTR_AJMTMNTHNUM,ajmtMnthNum);
     	values.put(ATTR_RCGTNMNTHNUM,rcgtnMnthNum);
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
    /** set 경력사항일련번호 : carrRsptSeilNum */
    public void setCarrRsptSeilNum(BigDecimal  carrRsptSeilNum) { set( ATTR_CARRRSPTSEILNUM ,carrRsptSeilNum);}
    /** get 경력사항일련번호 : carrRsptSeilNum */
    public BigDecimal  getCarrRsptSeilNum() { return (BigDecimal )get( ATTR_CARRRSPTSEILNUM );}
    /** set 경력시작일자 : carrBgnnDt */
    public void setCarrBgnnDt(String  carrBgnnDt) { set( ATTR_CARRBGNNDT ,carrBgnnDt);}
    /** get 경력시작일자 : carrBgnnDt */
    public String  getCarrBgnnDt() { return (String )get( ATTR_CARRBGNNDT );}
    /** set 경력종료일자 : carrEndDt */
    public void setCarrEndDt(String  carrEndDt) { set( ATTR_CARRENDDT ,carrEndDt);}
    /** get 경력종료일자 : carrEndDt */
    public String  getCarrEndDt() { return (String )get( ATTR_CARRENDDT );}
    /** set 근무처명 : paeWorkNm */
    public void setPaeWorkNm(String  paeWorkNm) { set( ATTR_PAEWORKNM ,paeWorkNm);}
    /** get 근무처명 : paeWorkNm */
    public String  getPaeWorkNm() { return (String )get( ATTR_PAEWORKNM );}
    /** set 경력구분코드 : carrDivCd */
    public void setCarrDivCd(String  carrDivCd) { set( ATTR_CARRDIVCD ,carrDivCd);}
    /** get 경력구분코드 : carrDivCd */
    public String  getCarrDivCd() { return (String )get( ATTR_CARRDIVCD );}
    /** set 근무부서명 : dutyDeptNm */
    public void setDutyDeptNm(String  dutyDeptNm) { set( ATTR_DUTYDEPTNM ,dutyDeptNm);}
    /** get 근무부서명 : dutyDeptNm */
    public String  getDutyDeptNm() { return (String )get( ATTR_DUTYDEPTNM );}
    /** set 담당업무명 : repbtyBusinNm */
    public void setRepbtyBusinNm(String  repbtyBusinNm) { set( ATTR_REPBTYBUSINNM ,repbtyBusinNm);}
    /** get 담당업무명 : repbtyBusinNm */
    public String  getRepbtyBusinNm() { return (String )get( ATTR_REPBTYBUSINNM );}
    /** set 직책명 : odtyNm */
    public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
    /** get 직책명 : odtyNm */
    public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}
    /** set 임금일당금액 : amntDlywagSum */
    public void setAmntDlywagSum(BigDecimal  amntDlywagSum) { set( ATTR_AMNTDLYWAGSUM ,amntDlywagSum);}
    /** get 임금일당금액 : amntDlywagSum */
    public BigDecimal  getAmntDlywagSum() { return (BigDecimal )get( ATTR_AMNTDLYWAGSUM );}
    /** set 경력비고내용 : carrNoteCtnt */
    public void setCarrNoteCtnt(String  carrNoteCtnt) { set( ATTR_CARRNOTECTNT ,carrNoteCtnt);}
    /** get 경력비고내용 : carrNoteCtnt */
    public String  getCarrNoteCtnt() { return (String )get( ATTR_CARRNOTECTNT );}
    /** set 근무년수 : dutyYrNum */
    public void setDutyYrNum(BigDecimal  dutyYrNum) { set( ATTR_DUTYYRNUM ,dutyYrNum);}
    /** get 근무년수 : dutyYrNum */
    public BigDecimal  getDutyYrNum() { return (BigDecimal )get( ATTR_DUTYYRNUM );}
    /** set 근무월수 : dutyMnthIcm */
    public void setDutyMnthIcm(BigDecimal  dutyMnthIcm) { set( ATTR_DUTYMNTHICM ,dutyMnthIcm);}
    /** get 근무월수 : dutyMnthIcm */
    public BigDecimal  getDutyMnthIcm() { return (BigDecimal )get( ATTR_DUTYMNTHICM );}
    /** set 환산비율 : cvsnRtoDivCd */
    public void setCvsnRtoDivCd(String  cvsnRtoDivCd) { set( ATTR_CVSNRTODIVCD ,cvsnRtoDivCd);}
    /** get 환산비율 : cvsnRtoDivCd */
    public String  getCvsnRtoDivCd() { return (String )get( ATTR_CVSNRTODIVCD );}
    /** set 가감월수 : ajmtMnthNum */
    public void setAjmtMnthNum(BigDecimal  ajmtMnthNum) { set( ATTR_AJMTMNTHNUM ,ajmtMnthNum);}
    /** get 가감월수 : ajmtMnthNum */
    public BigDecimal  getAjmtMnthNum() { return (BigDecimal )get( ATTR_AJMTMNTHNUM );}
    /** set 인정월수 : rcgtnMnthNum */
    public void setRcgtnMnthNum(BigDecimal  rcgtnMnthNum) { set( ATTR_RCGTNMNTHNUM ,rcgtnMnthNum);}
    /** get 인정월수 : rcgtnMnthNum */
    public BigDecimal  getRcgtnMnthNum() { return (BigDecimal )get( ATTR_RCGTNMNTHNUM );}
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
