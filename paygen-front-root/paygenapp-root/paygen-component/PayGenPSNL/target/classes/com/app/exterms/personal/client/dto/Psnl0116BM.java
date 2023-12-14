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
public class Psnl0116BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 학력사항일련번호 : acadAbtySeilNum */
    public static final String ATTR_ACADABTYSEILNUM = "acadAbtySeilNum";

    /** set 입학일자 : etncItshlDt */
    public static final String ATTR_ETNCITSHLDT = "etncItshlDt";

    /** set 졸업일자 : grdtnDt */
    public static final String ATTR_GRDTNDT = "grdtnDt";

    /** set 학력구분코드 : acadAbtyDivCd */
    public static final String ATTR_ACADABTYDIVCD = "acadAbtyDivCd";
    /** set 학력구분코드 : acadAbtyDivNm */
    public static final String ATTR_ACADABTYDIVNM = "acadAbtyDivNm";

    /** set 학교코드 : schlCd */
    public static final String ATTR_SCHLCD = "schlCd";
    
    /** set 학교코드 : schlNm */
    public static final String ATTR_SCHLNM = "schlNm";
    

    /** set 학과코드 : deprMajrCd */
    public static final String ATTR_DEPRMAJRCD = "deprMajrCd";

    /** set 전공명 : mjrSpctyNm */
    public static final String ATTR_MJRSPCTYNM = "mjrSpctyNm";

    /** set 부전공명 : mnrNm */
    public static final String ATTR_MNRNM = "mnrNm";

    /** set 국가코드 : natnCd */
    public static final String ATTR_NATNCD = "natnCd";

    /** set 학위명 : degrNm */
    public static final String ATTR_DEGRNM = "degrNm";

    /** set 학위구분코드 : degrDivCd */
    public static final String ATTR_DEGRDIVCD = "degrDivCd";

    /** set 학위취득일자 : degrAqtnDt */
    public static final String ATTR_DEGRAQTNDT = "degrAqtnDt";

    /** set 수업년수코드 : lesnYrNumCd */
    public static final String ATTR_LESNYRNUMCD = "lesnYrNumCd";
    
    /** set 수업년수코드 : lesnYrNumNm */
    public static final String ATTR_LESNYRNUMNM = "lesnYrNumNm";
    

    /** set 학력비고내용 : acadAbtyNoteCtnt */
    public static final String ATTR_ACADABTYNOTECTNT = "acadAbtyNoteCtnt";

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
     public Psnl0116BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0116BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  acadAbtySeilNum 
    		, String  etncItshlDt 
    		, String  grdtnDt 
    		, String  acadAbtyDivCd 
    		, String  schlCd 
    		, String  deprMajrCd 
    		, String  mjrSpctyNm 
    		, String  mnrNm 
    		, String  natnCd 
    		, String  degrNm 
    		, String  degrDivCd 
    		, String  degrAqtnDt 
    		, String  lesnYrNumCd 
    		, String  acadAbtyNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_ACADABTYSEILNUM,acadAbtySeilNum);
     	values.put(ATTR_ETNCITSHLDT,etncItshlDt);
     	values.put(ATTR_GRDTNDT,grdtnDt);
     	values.put(ATTR_ACADABTYDIVCD,acadAbtyDivCd);
     	values.put(ATTR_SCHLCD,schlCd);
     	values.put(ATTR_DEPRMAJRCD,deprMajrCd);
     	values.put(ATTR_MJRSPCTYNM,mjrSpctyNm);
     	values.put(ATTR_MNRNM,mnrNm);
     	values.put(ATTR_NATNCD,natnCd);
     	values.put(ATTR_DEGRNM,degrNm);
     	values.put(ATTR_DEGRDIVCD,degrDivCd);
     	values.put(ATTR_DEGRAQTNDT,degrAqtnDt);
     	values.put(ATTR_LESNYRNUMCD,lesnYrNumCd);
     	values.put(ATTR_ACADABTYNOTECTNT,acadAbtyNoteCtnt);
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
    /** set 학력사항일련번호 : acadAbtySeilNum */
    public void setAcadAbtySeilNum(BigDecimal  acadAbtySeilNum) { set( ATTR_ACADABTYSEILNUM ,acadAbtySeilNum);}
    /** get 학력사항일련번호 : acadAbtySeilNum */
    public BigDecimal  getAcadAbtySeilNum() { return (BigDecimal )get( ATTR_ACADABTYSEILNUM );}
    /** set 입학일자 : etncItshlDt */
    public void setEtncItshlDt(String  etncItshlDt) { set( ATTR_ETNCITSHLDT ,etncItshlDt);}
    /** get 입학일자 : etncItshlDt */
    public String  getEtncItshlDt() { return (String )get( ATTR_ETNCITSHLDT );}
    /** set 졸업일자 : grdtnDt */
    public void setGrdtnDt(String  grdtnDt) { set( ATTR_GRDTNDT ,grdtnDt);}
    /** get 졸업일자 : grdtnDt */
    public String  getGrdtnDt() { return (String )get( ATTR_GRDTNDT );}
    /** set 학력구분코드 : acadAbtyDivCd */
    public void setAcadAbtyDivCd(String  acadAbtyDivCd) { set( ATTR_ACADABTYDIVCD ,acadAbtyDivCd);}
    /** get 학력구분코드 : acadAbtyDivCd */
    public String  getAcadAbtyDivCd() { return (String )get( ATTR_ACADABTYDIVCD );}
    /** set 학력구분코드 : acadAbtyDivNm */
    public void setAcadAbtyDivNm(String  acadAbtyDivNm) { set( ATTR_ACADABTYDIVNM ,acadAbtyDivNm);}
    /** get 학력구분코드 : acadAbtyDivNm */
    public String  getAcadAbtyDivNm() { return (String )get( ATTR_ACADABTYDIVNM );}
    
    
    /** set 학교코드 : schlCd */
    public void setSchlCd(String  schlCd) { set( ATTR_SCHLCD ,schlCd);}
    /** get 학교코드 : schlCd */
    public String  getSchlCd() { return (String )get( ATTR_SCHLCD );}
    
    /** set 학교코드 : schlNm */
    public void setSchlNm(String  schlNm) { set( ATTR_SCHLNM ,schlNm);}
    /** get 학교코드 : schlCd */
    public String  getSchlNm() { return (String )get( ATTR_SCHLNM );}
    
    
    /** set 학과코드 : deprMajrCd */
    public void setDeprMajrCd(String  deprMajrCd) { set( ATTR_DEPRMAJRCD ,deprMajrCd);}
    /** get 학과코드 : deprMajrCd */
    public String  getDeprMajrCd() { return (String )get( ATTR_DEPRMAJRCD );}
    /** set 전공명 : mjrSpctyNm */
    public void setMjrSpctyNm(String  mjrSpctyNm) { set( ATTR_MJRSPCTYNM ,mjrSpctyNm);}
    /** get 전공명 : mjrSpctyNm */
    public String  getMjrSpctyNm() { return (String )get( ATTR_MJRSPCTYNM );}
    /** set 부전공명 : mnrNm */
    public void setMnrNm(String  mnrNm) { set( ATTR_MNRNM ,mnrNm);}
    /** get 부전공명 : mnrNm */
    public String  getMnrNm() { return (String )get( ATTR_MNRNM );}
    /** set 국가코드 : natnCd */
    public void setNatnCd(String  natnCd) { set( ATTR_NATNCD ,natnCd);}
    /** get 국가코드 : natnCd */
    public String  getNatnCd() { return (String )get( ATTR_NATNCD );}
    /** set 학위명 : degrNm */
    public void setDegrNm(String  degrNm) { set( ATTR_DEGRNM ,degrNm);}
    /** get 학위명 : degrNm */
    public String  getDegrNm() { return (String )get( ATTR_DEGRNM );}
    /** set 학위구분코드 : degrDivCd */
    public void setDegrDivCd(String  degrDivCd) { set( ATTR_DEGRDIVCD ,degrDivCd);}
    /** get 학위구분코드 : degrDivCd */
    public String  getDegrDivCd() { return (String )get( ATTR_DEGRDIVCD );}
    /** set 학위취득일자 : degrAqtnDt */
    public void setDegrAqtnDt(String  degrAqtnDt) { set( ATTR_DEGRAQTNDT ,degrAqtnDt);}
    /** get 학위취득일자 : degrAqtnDt */
    public String  getDegrAqtnDt() { return (String )get( ATTR_DEGRAQTNDT );}
    /** set 수업년수코드 : lesnYrNumCd */
    public void setLesnYrNumCd(String  lesnYrNumCd) { set( ATTR_LESNYRNUMCD ,lesnYrNumCd);}
    /** get 수업년수코드 : lesnYrNumCd */
    public String  getLesnYrNumCd() { return (String )get( ATTR_LESNYRNUMCD );}
    
    
    /** set 수업년수코드 : lesnYrNumNm */
    public void setLesnYrNumNm(String  lesnYrNumNm) { set( ATTR_LESNYRNUMNM ,lesnYrNumNm);}
    /** get 수업년수코드 : lesnYrNumNm */
    public String  getLesnYrNumNm() { return (String )get( ATTR_LESNYRNUMNM );}
    
    /** set 학력비고내용 : acadAbtyNoteCtnt */
    public void setAcadAbtyNoteCtnt(String  acadAbtyNoteCtnt) { set( ATTR_ACADABTYNOTECTNT ,acadAbtyNoteCtnt);}
    /** get 학력비고내용 : acadAbtyNoteCtnt */
    public String  getAcadAbtyNoteCtnt() { return (String )get( ATTR_ACADABTYNOTECTNT );}
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
