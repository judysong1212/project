package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0415VO.java
 * @Description : Payr0415 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0416BM    extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
 
    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";
    
    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYRDISP = "payYrDisp";

    

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
    public static final String ATTR_DTILOCCUDLYSEILNUM = "dtilOccuDlySeilNum";
    
    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";

    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
    
    /** set 직종세코드 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";

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
    
	//이관여부
	public static final String ATTR_TRANSFER_YN = "transferYn";
	
	public static final String ATTR_CREATEYN = "createYn";    

    /** 생성자 */
     public Payr0416BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0416BM(
    		 String  payYr 
    		, String  dpobCd 
    		, Long  dtilOccuDlySeilNum 
    		, String  typOccuCd 
    		, String  pyspGrdeCd 
    		, String  dtilOccuInttnCd 
    		, String  dtilOccuClsDivCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_PAYYR,payYr);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DTILOCCUDLYSEILNUM,dtilOccuDlySeilNum);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
    public void setDtilOccuDlySeilNum(Long  dtilOccuDlySeilNum) { set( ATTR_DTILOCCUDLYSEILNUM ,dtilOccuDlySeilNum);}
    /** get 직종세단가항목일련번호 : dtilOccuDlySeilNum */
    public Long  getDtilOccuDlySeilNum() { return (Long )get( ATTR_DTILOCCUDLYSEILNUM );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    /** set 직종코드 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종코드 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
    
    /** set 호봉등급코드 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM , pyspGrdeNm);}
    /** get 호봉등급코드 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    
    /** set 직종세통합코드 : dtilOccuInttnNm */
    public void setDtilOccuInttnNm(String  dtilOccuInttnNm) { set( ATTR_DTILOCCUINTTNNM ,dtilOccuInttnNm);}
    /** get 직종세통합코드 : dtilOccuInttnNm */
    public String  getDtilOccuInttnNm() { return (String )get( ATTR_DTILOCCUINTTNNM );}

    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
    
    /** set 직종세코드 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세코드 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
    

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
    
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    
    /** set 부서코드 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서코드 : deptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setTransferYn(String  transferYn) { set( ATTR_TRANSFER_YN ,transferYn);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getTransferYn() { return (String )get( ATTR_TRANSFER_YN );}
    
    /** set 생성여부 : createYn */
    public void setCreateYn(String  createYn) { set( ATTR_CREATEYN ,createYn);}
    /** get 생성여부 : createYn */
    public String  getCreateYn() { return (String )get( ATTR_CREATEYN );}
  
    
    /** set 급여년도 : payYrDisp */
    public void setPayYrDisp(String  payYrDisp) { set( ATTR_PAYYRDISP ,payYrDisp);}
    /** get 급여년도 : payYrDisp */
    public String  getPayYrDisp() { return (String )get( ATTR_PAYYRDISP );}
 

}
