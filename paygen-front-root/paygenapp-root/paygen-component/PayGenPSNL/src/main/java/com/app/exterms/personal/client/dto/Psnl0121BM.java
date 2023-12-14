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
public class Psnl0121BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 포상일련번호 : accldSeilNum */
    public static final String ATTR_ACCLDSEILNUM = "accldSeilNum";

    /** set 포상년도 : accldYr */
    public static final String ATTR_ACCLDYR = "accldYr";

    /** set 포상수여일자 : accldPrttDt */
    public static final String ATTR_ACCLDPRTTDT = "accldPrttDt";

    /** set 포상종류코드 : accldKndCd */
    public static final String ATTR_ACCLDKNDCD = "accldKndCd";

    /** set 포상구분코드 : accldDivCd */
    public static final String ATTR_ACCLDDIVCD = "accldDivCd";

    /** set 포상명 : accldNm */
    public static final String ATTR_ACCLDNM = "accldNm";

    /** set 포상서훈번호 : accldCfmntNum */
    public static final String ATTR_ACCLDCFMNTNUM = "accldCfmntNum";

    /** set 시행기관명 : efmnIstutNm */
    public static final String ATTR_EFMNISTUTNM = "efmnIstutNm";

    /** set 포상주체내용 : accldMnantCtnt */
    public static final String ATTR_ACCLDMNANTCTNT = "accldMnantCtnt";

    /** set 포상비고내용 : accldNoteCtnt */
    public static final String ATTR_ACCLDNOTECTNT = "accldNoteCtnt";

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
     public Psnl0121BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0121BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  accldSeilNum 
    		, String  accldYr 
    		, String  accldPrttDt 
    		, String  accldKndCd 
    		, String  accldDivCd 
    		, String  accldNm 
    		, String  accldCfmntNum 
    		, String  efmnIstutNm 
    		, String  accldMnantCtnt 
    		, String  accldNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_ACCLDSEILNUM,accldSeilNum);
     	values.put(ATTR_ACCLDYR,accldYr);
     	values.put(ATTR_ACCLDPRTTDT,accldPrttDt);
     	values.put(ATTR_ACCLDKNDCD,accldKndCd);
     	values.put(ATTR_ACCLDDIVCD,accldDivCd);
     	values.put(ATTR_ACCLDNM,accldNm);
     	values.put(ATTR_ACCLDCFMNTNUM,accldCfmntNum);
     	values.put(ATTR_EFMNISTUTNM,efmnIstutNm);
     	values.put(ATTR_ACCLDMNANTCTNT,accldMnantCtnt);
     	values.put(ATTR_ACCLDNOTECTNT,accldNoteCtnt);
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
    /** set 포상일련번호 : accldSeilNum */
    public void setAccldSeilNum(BigDecimal  accldSeilNum) { set( ATTR_ACCLDSEILNUM ,accldSeilNum);}
    /** get 포상일련번호 : accldSeilNum */
    public BigDecimal  getAccldSeilNum() { return (BigDecimal )get( ATTR_ACCLDSEILNUM );}
    /** set 포상년도 : accldYr */
    public void setAccldYr(String  accldYr) { set( ATTR_ACCLDYR ,accldYr);}
    /** get 포상년도 : accldYr */
    public String  getAccldYr() { return (String )get( ATTR_ACCLDYR );}
    /** set 포상수여일자 : accldPrttDt */
    public void setAccldPrttDt(String  accldPrttDt) { set( ATTR_ACCLDPRTTDT ,accldPrttDt);}
    /** get 포상수여일자 : accldPrttDt */
    public String  getAccldPrttDt() { return (String )get( ATTR_ACCLDPRTTDT );}
    /** set 포상종류코드 : accldKndCd */
    public void setAccldKndCd(String  accldKndCd) { set( ATTR_ACCLDKNDCD ,accldKndCd);}
    /** get 포상종류코드 : accldKndCd */
    public String  getAccldKndCd() { return (String )get( ATTR_ACCLDKNDCD );}
    /** set 포상구분코드 : accldDivCd */
    public void setAccldDivCd(String  accldDivCd) { set( ATTR_ACCLDDIVCD ,accldDivCd);}
    /** get 포상구분코드 : accldDivCd */
    public String  getAccldDivCd() { return (String )get( ATTR_ACCLDDIVCD );}
    /** set 포상명 : accldNm */
    public void setAccldNm(String  accldNm) { set( ATTR_ACCLDNM ,accldNm);}
    /** get 포상명 : accldNm */
    public String  getAccldNm() { return (String )get( ATTR_ACCLDNM );}
    /** set 포상서훈번호 : accldCfmntNum */
    public void setAccldCfmntNum(String  accldCfmntNum) { set( ATTR_ACCLDCFMNTNUM ,accldCfmntNum);}
    /** get 포상서훈번호 : accldCfmntNum */
    public String  getAccldCfmntNum() { return (String )get( ATTR_ACCLDCFMNTNUM );}
    /** set 시행기관명 : efmnIstutNm */
    public void setEfmnIstutNm(String  efmnIstutNm) { set( ATTR_EFMNISTUTNM ,efmnIstutNm);}
    /** get 시행기관명 : efmnIstutNm */
    public String  getEfmnIstutNm() { return (String )get( ATTR_EFMNISTUTNM );}
    /** set 포상주체내용 : accldMnantCtnt */
    public void setAccldMnantCtnt(String  accldMnantCtnt) { set( ATTR_ACCLDMNANTCTNT ,accldMnantCtnt);}
    /** get 포상주체내용 : accldMnantCtnt */
    public String  getAccldMnantCtnt() { return (String )get( ATTR_ACCLDMNANTCTNT );}
    /** set 포상비고내용 : accldNoteCtnt */
    public void setAccldNoteCtnt(String  accldNoteCtnt) { set( ATTR_ACCLDNOTECTNT ,accldNoteCtnt);}
    /** get 포상비고내용 : accldNoteCtnt */
    public String  getAccldNoteCtnt() { return (String )get( ATTR_ACCLDNOTECTNT );}
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
