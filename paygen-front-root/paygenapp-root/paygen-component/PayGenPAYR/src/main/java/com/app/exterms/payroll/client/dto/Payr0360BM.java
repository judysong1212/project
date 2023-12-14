package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0350VO.java
 * @Description : Payr0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0360BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 소급년도 : reattyYr */
    public static final String ATTR_REATTYYR = "reattyYr";

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public static final String ATTR_REATTYSTPDSPTYNUM = "reattyStpDsptyNum";

    /** set 소급설정회차번호 : reattyStpDsptyNumDisp */
    public static final String ATTR_REATTYSTPDSPTYNUMDISP = "reattyStpDsptyNuDisp"; 
    
    /** set 소급적용년월 : reattyApptnYrMnth */
    public static final String ATTR_REATTYAPPTNYRMNTH = "reattyApptnYrMnth";

    /** set 소급지급일자 : reattyPymtDt */
    public static final String ATTR_REATTYPYMTDT = "reattyPymtDt";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";


    /** set 호봉코드 : pyspNm */
    public static final String ATTR_PYSPNM = "pyspNm";
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 지급월설정_01 : pymtMnthStp01 */
    public static final String ATTR_PYMTMNTHSTP01 = "pymtMnthStp01";

    /** set 지급월설정_02 : pymtMnthStp02 */
    public static final String ATTR_PYMTMNTHSTP02 = "pymtMnthStp02";

    /** set 지급월설정_03 : pymtMnthStp03 */
    public static final String ATTR_PYMTMNTHSTP03 = "pymtMnthStp03";

    /** set 지급월설정_04 : pymtMnthStp04 */
    public static final String ATTR_PYMTMNTHSTP04 = "pymtMnthStp04";

    /** set 지급월설정_05 : pymtMnthStp05 */
    public static final String ATTR_PYMTMNTHSTP05 = "pymtMnthStp05";

    /** set 지급월설정_06 : pymtMnthStp06 */
    public static final String ATTR_PYMTMNTHSTP06 = "pymtMnthStp06";

    /** set 지급월설정_07 : pymtMnthStp07 */
    public static final String ATTR_PYMTMNTHSTP07 = "pymtMnthStp07";

    /** set 지급월설정_08 : pymtMnthStp08 */
    public static final String ATTR_PYMTMNTHSTP08 = "pymtMnthStp08";

    /** set 지급월설정_09 : pymtMnthStp09 */
    public static final String ATTR_PYMTMNTHSTP09 = "pymtMnthStp09";

    /** set 지급월설정_10 : pymtMnthStp10 */
    public static final String ATTR_PYMTMNTHSTP10 = "pymtMnthStp10";

    /** set 지급월설정_11 : pymtMnthStp11 */
    public static final String ATTR_PYMTMNTHSTP11 = "pymtMnthStp11";

    /** set 지급월설정_12 : pymtMnthStp12 */
    public static final String ATTR_PYMTMNTHSTP12 = "pymtMnthStp12";

    /** set TGT_SYSTEMKEY : tgtSystemkey */
    public static final String ATTR_TGTSYSTEMKEY = "tgtSystemkey";

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
    

	/** set 소급설정내용 : reattyStpNoteCtnt */
	public static final String ATTR_REATTYSTPNOTECTNT = "reattyStpNoteCtnt";

    /** set 지급구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
 

    /** 생성자 */
     public Payr0360BM() { super(); } 


/** 일괄등록 처리   */
 public Payr0360BM(
		 String  dpobCd 
		, String  payCd 
		, String  reattyYr 
		, String  reattyStpDsptyNum 
		, String  reattyApptnYrMnth 
		, String  reattyPymtDt 
		, String  emymtDivCd 
		, String  payrMangDeptCd 
		, String  deptCd 
		, String  businCd 
		, String  typOccuCd 
		, String  dtilOccuClsDivCd 
		, String  pymtMnthStp01 
		, String  pymtMnthStp02 
		, String  pymtMnthStp03 
		, String  pymtMnthStp04 
		, String  pymtMnthStp05 
		, String  pymtMnthStp06 
		, String  pymtMnthStp07 
		, String  pymtMnthStp08 
		, String  pymtMnthStp09 
		, String  pymtMnthStp10 
		, String  pymtMnthStp11 
		, String  pymtMnthStp12 
		, String  tgtSystemkey 
		, String  reattyStpNoteCtnt 
		, String  kybdr 
		, String  inptDt 
		, String  inptAddr 
		, String  ismt 
		, String  revnDt 
		, String  revnAddr ) { 
 	values.put(ATTR_DPOBCD,dpobCd);
 	values.put(ATTR_PAYCD,payCd);
 	values.put(ATTR_REATTYYR,reattyYr);
 	values.put(ATTR_REATTYSTPDSPTYNUM,reattyStpDsptyNum);
 	values.put(ATTR_REATTYAPPTNYRMNTH,reattyApptnYrMnth);
 	values.put(ATTR_REATTYPYMTDT,reattyPymtDt);
 	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
 	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
 	values.put(ATTR_DEPTCD,deptCd);
 	values.put(ATTR_BUSINCD,businCd);
 	values.put(ATTR_TYPOCCUCD,typOccuCd);
 	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
 	values.put(ATTR_PYMTMNTHSTP01,pymtMnthStp01);
 	values.put(ATTR_PYMTMNTHSTP02,pymtMnthStp02);
 	values.put(ATTR_PYMTMNTHSTP03,pymtMnthStp03);
 	values.put(ATTR_PYMTMNTHSTP04,pymtMnthStp04);
 	values.put(ATTR_PYMTMNTHSTP05,pymtMnthStp05);
 	values.put(ATTR_PYMTMNTHSTP06,pymtMnthStp06);
 	values.put(ATTR_PYMTMNTHSTP07,pymtMnthStp07);
 	values.put(ATTR_PYMTMNTHSTP08,pymtMnthStp08);
 	values.put(ATTR_PYMTMNTHSTP09,pymtMnthStp09);
 	values.put(ATTR_PYMTMNTHSTP10,pymtMnthStp10);
 	values.put(ATTR_PYMTMNTHSTP11,pymtMnthStp11);
 	values.put(ATTR_PYMTMNTHSTP12,pymtMnthStp12);
 	values.put(ATTR_TGTSYSTEMKEY,tgtSystemkey);
 	values.put(ATTR_REATTYSTPNOTECTNT,reattyStpNoteCtnt);
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

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 소급년도 : reattyYr */
    public void setReattyYr(String  reattyYr) { set( ATTR_REATTYYR ,reattyYr);}
    /** get 소급년도 : reattyYr */
    public String  getReattyYr() { return (String )get( ATTR_REATTYYR );}

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public void setReattyStpDsptyNum(String  reattyStpDsptyNum) { set( ATTR_REATTYSTPDSPTYNUM ,reattyStpDsptyNum);}
    /** get 소급설정회차번호 : reattyStpDsptyNum */
    public String  getReattyStpDsptyNum() { return (String )get( ATTR_REATTYSTPDSPTYNUM );}
    
    /** set 소급설정회차번호 : reattyStpDsptyNumDisp */
    public void setReattyStpDsptyNumDisp(String  reattyStpDsptyNumDisp) { set( ATTR_REATTYSTPDSPTYNUMDISP ,reattyStpDsptyNumDisp);}
    /** get 소급설정회차번호 : reattyStpDsptyNum */
    public String  getReattyStpDsptyNumDisp() { return (String )get( ATTR_REATTYSTPDSPTYNUMDISP );}

    /** set 소급적용년월 : reattyApptnYrMnth */
    public void setReattyApptnYrMnth(String  reattyApptnYrMnth) { set( ATTR_REATTYAPPTNYRMNTH ,reattyApptnYrMnth);}
    /** get 소급적용년월 : reattyApptnYrMnth */
    public String  getReattyApptnYrMnth() { return (String )get( ATTR_REATTYAPPTNYRMNTH );}

    /** set 소급지급일자 : reattyPymtDt */
    public void setReattyPymtDt(String  reattyPymtDt) { set( ATTR_REATTYPYMTDT ,reattyPymtDt);}
    /** get 소급지급일자 : reattyPymtDt */
    public String  getReattyPymtDt() { return (String )get( ATTR_REATTYPYMTDT );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 지급월설정_01 : pymtMnthStp01 */
    public void setPymtMnthStp01(String  pymtMnthStp01) { set( ATTR_PYMTMNTHSTP01 ,pymtMnthStp01);}
    /** get 지급월설정_01 : pymtMnthStp01 */
    public String  getPymtMnthStp01() { return (String )get( ATTR_PYMTMNTHSTP01 );}

    /** set 지급월설정_02 : pymtMnthStp02 */
    public void setPymtMnthStp02(String  pymtMnthStp02) { set( ATTR_PYMTMNTHSTP02 ,pymtMnthStp02);}
    /** get 지급월설정_02 : pymtMnthStp02 */
    public String  getPymtMnthStp02() { return (String )get( ATTR_PYMTMNTHSTP02 );}

    /** set 지급월설정_03 : pymtMnthStp03 */
    public void setPymtMnthStp03(String  pymtMnthStp03) { set( ATTR_PYMTMNTHSTP03 ,pymtMnthStp03);}
    /** get 지급월설정_03 : pymtMnthStp03 */
    public String  getPymtMnthStp03() { return (String )get( ATTR_PYMTMNTHSTP03 );}

    /** set 지급월설정_04 : pymtMnthStp04 */
    public void setPymtMnthStp04(String  pymtMnthStp04) { set( ATTR_PYMTMNTHSTP04 ,pymtMnthStp04);}
    /** get 지급월설정_04 : pymtMnthStp04 */
    public String  getPymtMnthStp04() { return (String )get( ATTR_PYMTMNTHSTP04 );}

    /** set 지급월설정_05 : pymtMnthStp05 */
    public void setPymtMnthStp05(String  pymtMnthStp05) { set( ATTR_PYMTMNTHSTP05 ,pymtMnthStp05);}
    /** get 지급월설정_05 : pymtMnthStp05 */
    public String  getPymtMnthStp05() { return (String )get( ATTR_PYMTMNTHSTP05 );}

    /** set 지급월설정_06 : pymtMnthStp06 */
    public void setPymtMnthStp06(String  pymtMnthStp06) { set( ATTR_PYMTMNTHSTP06 ,pymtMnthStp06);}
    /** get 지급월설정_06 : pymtMnthStp06 */
    public String  getPymtMnthStp06() { return (String )get( ATTR_PYMTMNTHSTP06 );}

    /** set 지급월설정_07 : pymtMnthStp07 */
    public void setPymtMnthStp07(String  pymtMnthStp07) { set( ATTR_PYMTMNTHSTP07 ,pymtMnthStp07);}
    /** get 지급월설정_07 : pymtMnthStp07 */
    public String  getPymtMnthStp07() { return (String )get( ATTR_PYMTMNTHSTP07 );}

    /** set 지급월설정_08 : pymtMnthStp08 */
    public void setPymtMnthStp08(String  pymtMnthStp08) { set( ATTR_PYMTMNTHSTP08 ,pymtMnthStp08);}
    /** get 지급월설정_08 : pymtMnthStp08 */
    public String  getPymtMnthStp08() { return (String )get( ATTR_PYMTMNTHSTP08 );}

    /** set 지급월설정_09 : pymtMnthStp09 */
    public void setPymtMnthStp09(String  pymtMnthStp09) { set( ATTR_PYMTMNTHSTP09 ,pymtMnthStp09);}
    /** get 지급월설정_09 : pymtMnthStp09 */
    public String  getPymtMnthStp09() { return (String )get( ATTR_PYMTMNTHSTP09 );}

    /** set 지급월설정_10 : pymtMnthStp10 */
    public void setPymtMnthStp10(String  pymtMnthStp10) { set( ATTR_PYMTMNTHSTP10 ,pymtMnthStp10);}
    /** get 지급월설정_10 : pymtMnthStp10 */
    public String  getPymtMnthStp10() { return (String )get( ATTR_PYMTMNTHSTP10 );}

    /** set 지급월설정_11 : pymtMnthStp11 */
    public void setPymtMnthStp11(String  pymtMnthStp11) { set( ATTR_PYMTMNTHSTP11 ,pymtMnthStp11);}
    /** get 지급월설정_11 : pymtMnthStp11 */
    public String  getPymtMnthStp11() { return (String )get( ATTR_PYMTMNTHSTP11 );}

    /** set 지급월설정_12 : pymtMnthStp12 */
    public void setPymtMnthStp12(String  pymtMnthStp12) { set( ATTR_PYMTMNTHSTP12 ,pymtMnthStp12);}
    /** get 지급월설정_12 : pymtMnthStp12 */
    public String  getPymtMnthStp12() { return (String )get( ATTR_PYMTMNTHSTP12 );}

    /** set TGT_SYSTEMKEY : tgtSystemkey */
    public void setTgtSystemkey(String  tgtSystemkey) { set( ATTR_TGTSYSTEMKEY ,tgtSystemkey);}
    /** get TGT_SYSTEMKEY : tgtSystemkey */
    public String  getTgtSystemkey() { return (String )get( ATTR_TGTSYSTEMKEY );}

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

    /** set 고용구분 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

    
    /** set 부서 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서 : deptNm  */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

    /** set 사업 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}

    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}

    /** set 직책 : odtyNm */
    public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
    /** get 직책 : odtyNm */
    public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}

    /** set 호봉 : pyspNm */
    public void setPyspNm(String  pyspNm) { set( ATTR_PYSPNM ,pyspNm);}
    /** get 호봉 : pyspNm */
    public String  getPyspNm() { return (String )get( ATTR_PYSPNM );}

    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

	/** set 소급설정내용 : reattyStpNoteCtnt */
	public void setReattyStpNoteCtnt(String  reattyStpNoteCtnt) { set( ATTR_REATTYSTPNOTECTNT ,reattyStpNoteCtnt);}
	/** get 소급설정내용 : reattyStpNoteCtnt */
	public String  getReattyStpNoteCtnt() { return (String )get( ATTR_REATTYSTPNOTECTNT );}


    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


}
