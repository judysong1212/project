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
public class Psnl0122BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 징계일련번호 : dsnyActSeilNum */
    public static final String ATTR_DSNYACTSEILNUM = "dsnyActSeilNum";

    /** set 징계처분일자 : dsnyActDsplDt */
    public static final String ATTR_DSNYACTDSPLDT = "dsnyActDsplDt";

    /** set 징계구분코드 : dsnyActDivCd */
    public static final String ATTR_DSNYACTDIVCD = "dsnyActDivCd";
    
    /** set 징계구분코드 : dsnyActDivNm */
    public static final String ATTR_DSNYACTDIVNM = "dsnyActDivNm";

    /** set 징계명 : dsnyActNm */
    public static final String ATTR_DSNYACTNM = "dsnyActNm";

    /** set 징계사유내용 : dsnyActReasCtnt */
    public static final String ATTR_DSNYACTREASCTNT = "dsnyActReasCtnt";

    /** set 징계수행기관 : dsnyActEctgOrgn */
    public static final String ATTR_DSNYACTECTGORGN = "dsnyActEctgOrgn";

    /** set 징계비고내용 : dsnyActNoteCtnt */
    public static final String ATTR_DSNYACTNOTECTNT = "dsnyActNoteCtnt";

    /** set 징계시작일자 : dsnyActBgnnDt */
    public static final String ATTR_DSNYACTBGNNDT = "dsnyActBgnnDt";

    /** set 징계종료일자 : dsnyActEndDt */
    public static final String ATTR_DSNYACTENDDT = "dsnyActEndDt";

    /** set 징계감봉율 : dsnyActCtwpRate */
    public static final String ATTR_DSNYACTCTWPRATE = "dsnyActCtwpRate";

    /** set 징계감봉월수 : dsnyActCtwpMnthIcm */
    public static final String ATTR_DSNYACTCTWPMNTHICM = "dsnyActCtwpMnthIcm";

    /** set 징계사면일자 : dsnyActAnstyDt */
    public static final String ATTR_DSNYACTANSTYDT = "dsnyActAnstyDt";

    /** set 징계사면구분코드 : dsnyActAnstyDivCd */
    public static final String ATTR_DSNYACTANSTYDIVCD = "dsnyActAnstyDivCd";
    
    /** set 징계사면구분코드 : dsnyActAnstyDivNm */
    public static final String ATTR_DSNYACTANSTYDIVNM = "dsnyActAnstyDivNm";

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
     public Psnl0122BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0122BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  dsnyActSeilNum 
    		, String  dsnyActDsplDt 
    		, String  dsnyActDivCd 
    		, String  dsnyActNm 
    		, String  dsnyActReasCtnt 
    		, String  dsnyActEctgOrgn 
    		, String  dsnyActNoteCtnt 
    		, String  dsnyActBgnnDt 
    		, String  dsnyActEndDt 
    		, BigDecimal  dsnyActCtwpRate 
    		, BigDecimal  dsnyActCtwpMnthIcm 
    		, String  dsnyActAnstyDt 
    		, String  dsnyActAnstyDivCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DSNYACTSEILNUM,dsnyActSeilNum);
     	values.put(ATTR_DSNYACTDSPLDT,dsnyActDsplDt);
     	values.put(ATTR_DSNYACTDIVCD,dsnyActDivCd);
     	values.put(ATTR_DSNYACTNM,dsnyActNm);
     	values.put(ATTR_DSNYACTREASCTNT,dsnyActReasCtnt);
     	values.put(ATTR_DSNYACTECTGORGN,dsnyActEctgOrgn);
     	values.put(ATTR_DSNYACTNOTECTNT,dsnyActNoteCtnt);
     	values.put(ATTR_DSNYACTBGNNDT,dsnyActBgnnDt);
     	values.put(ATTR_DSNYACTENDDT,dsnyActEndDt);
     	values.put(ATTR_DSNYACTCTWPRATE,dsnyActCtwpRate);
     	values.put(ATTR_DSNYACTCTWPMNTHICM,dsnyActCtwpMnthIcm);
     	values.put(ATTR_DSNYACTANSTYDT,dsnyActAnstyDt);
     	values.put(ATTR_DSNYACTANSTYDIVCD,dsnyActAnstyDivCd);
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
    /** set 징계일련번호 : dsnyActSeilNum */
    public void setDsnyActSeilNum(BigDecimal  dsnyActSeilNum) { set( ATTR_DSNYACTSEILNUM ,dsnyActSeilNum);}
    /** get 징계일련번호 : dsnyActSeilNum */
    public BigDecimal  getDsnyActSeilNum() { return (BigDecimal )get( ATTR_DSNYACTSEILNUM );}
    /** set 징계처분일자 : dsnyActDsplDt */
    public void setDsnyActDsplDt(String  dsnyActDsplDt) { set( ATTR_DSNYACTDSPLDT ,dsnyActDsplDt);}
    /** get 징계처분일자 : dsnyActDsplDt */
    public String  getDsnyActDsplDt() { return (String )get( ATTR_DSNYACTDSPLDT );}
    /** set 징계구분코드 : dsnyActDivCd */
    public void setDsnyActDivCd(String  dsnyActDivCd) { set( ATTR_DSNYACTDIVCD ,dsnyActDivCd);}
    /** get 징계구분코드 : dsnyActDivCd */
    public String  getDsnyActDivCd() { return (String )get( ATTR_DSNYACTDIVCD );}
    
    /** set 징계구분코드 : dsnyActDivNm */
    public void setDsnyActDivNm(String  dsnyActDivNm) { set( ATTR_DSNYACTDIVNM ,dsnyActDivNm);}
    /** get 징계구분코드 : dsnyActDivNm */
    public String  getDsnyActDivNm() { return (String )get( ATTR_DSNYACTDIVNM );}
    
    /** set 징계명 : dsnyActNm */
    public void setDsnyActNm(String  dsnyActNm) { set( ATTR_DSNYACTNM ,dsnyActNm);}
    /** get 징계명 : dsnyActNm */
    public String  getDsnyActNm() { return (String )get( ATTR_DSNYACTNM );}
    /** set 징계사유내용 : dsnyActReasCtnt */
    public void setDsnyActReasCtnt(String  dsnyActReasCtnt) { set( ATTR_DSNYACTREASCTNT ,dsnyActReasCtnt);}
    /** get 징계사유내용 : dsnyActReasCtnt */
    public String  getDsnyActReasCtnt() { return (String )get( ATTR_DSNYACTREASCTNT );}
    /** set 징계수행기관 : dsnyActEctgOrgn */
    public void setDsnyActEctgOrgn(String  dsnyActEctgOrgn) { set( ATTR_DSNYACTECTGORGN ,dsnyActEctgOrgn);}
    /** get 징계수행기관 : dsnyActEctgOrgn */
    public String  getDsnyActEctgOrgn() { return (String )get( ATTR_DSNYACTECTGORGN );}
    /** set 징계비고내용 : dsnyActNoteCtnt */
    public void setDsnyActNoteCtnt(String  dsnyActNoteCtnt) { set( ATTR_DSNYACTNOTECTNT ,dsnyActNoteCtnt);}
    /** get 징계비고내용 : dsnyActNoteCtnt */
    public String  getDsnyActNoteCtnt() { return (String )get( ATTR_DSNYACTNOTECTNT );}
    /** set 징계시작일자 : dsnyActBgnnDt */
    public void setDsnyActBgnnDt(String  dsnyActBgnnDt) { set( ATTR_DSNYACTBGNNDT ,dsnyActBgnnDt);}
    /** get 징계시작일자 : dsnyActBgnnDt */
    public String  getDsnyActBgnnDt() { return (String )get( ATTR_DSNYACTBGNNDT );}
    /** set 징계종료일자 : dsnyActEndDt */
    public void setDsnyActEndDt(String  dsnyActEndDt) { set( ATTR_DSNYACTENDDT ,dsnyActEndDt);}
    /** get 징계종료일자 : dsnyActEndDt */
    public String  getDsnyActEndDt() { return (String )get( ATTR_DSNYACTENDDT );}
    /** set 징계감봉율 : dsnyActCtwpRate */
    public void setDsnyActCtwpRate(BigDecimal  dsnyActCtwpRate) { set( ATTR_DSNYACTCTWPRATE ,dsnyActCtwpRate);}
    /** get 징계감봉율 : dsnyActCtwpRate */
    public BigDecimal  getDsnyActCtwpRate() { return (BigDecimal )get( ATTR_DSNYACTCTWPRATE );}
    /** set 징계감봉월수 : dsnyActCtwpMnthIcm */
    public void setDsnyActCtwpMnthIcm(BigDecimal  dsnyActCtwpMnthIcm) { set( ATTR_DSNYACTCTWPMNTHICM ,dsnyActCtwpMnthIcm);}
    /** get 징계감봉월수 : dsnyActCtwpMnthIcm */
    public BigDecimal  getDsnyActCtwpMnthIcm() { return (BigDecimal )get( ATTR_DSNYACTCTWPMNTHICM );}
    /** set 징계사면일자 : dsnyActAnstyDt */
    public void setDsnyActAnstyDt(String  dsnyActAnstyDt) { set( ATTR_DSNYACTANSTYDT ,dsnyActAnstyDt);}
    /** get 징계사면일자 : dsnyActAnstyDt */
    public String  getDsnyActAnstyDt() { return (String )get( ATTR_DSNYACTANSTYDT );}
    /** set 징계사면구분코드 : dsnyActAnstyDivCd */
    public void setDsnyActAnstyDivCd(String  dsnyActAnstyDivCd) { set( ATTR_DSNYACTANSTYDIVCD ,dsnyActAnstyDivCd);}
    /** get 징계사면구분코드 : dsnyActAnstyDivCd */
    public String  getDsnyActAnstyDivCd() { return (String )get( ATTR_DSNYACTANSTYDIVCD );}
    
    /** set 징계사면구분코드 : dsnyActAnstyDivNm */
    public void setDsnyActAnstyDivNm(String  dsnyActAnstyDivNm) { set( ATTR_DSNYACTANSTYDIVNM ,dsnyActAnstyDivNm);}
    /** get 징계사면구분코드 : dsnyActAnstyDivNm */
    public String  getDsnyActAnstyDivNm() { return (String )get( ATTR_DSNYACTANSTYDIVNM );}
    
    
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
