package com.app.exterms.payroll.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0440VO.java
 * @Description : Payr0440 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0440BM   extends MSFSimpleBaseModel implements IsSerializable   {
	
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    

	/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
	public static final String ATTR_TYPOCCUGRDEMPPGSEILNUM = "typOccuGrdeMppgSeilNum";
	
	/** set 급여항목일련번호 : payrItemSeilNum */
	public static final String ATTR_PAYRITEMSEILNUM = "payrItemSeilNum";


    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";
    
    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";
    
    

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public static final String ATTR_PYSPLOGSVCYRNUMCD = "pyspLogSvcYrNumCd";
    

    /** set 호봉근속년수 : pyspLogSvcYrNumNm */
    public static final String ATTR_PYSPLOGSVCYRNUMNM = "pyspLogSvcYrNumNm";
    

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";


    /** set 호봉등급 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";


    /** set 항목명 : payItemCd */
    public static final String ATTR_PAYITEMNM = "payItemNm";

     

    /** set 단가표적용일자 : occuClssPayCmpttnStdDisp */
    public static final String ATTR_OCCUCLSSPAYCMPTTNSTDDISP = "occuClssPayCmpttnStdDisp";

    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";


    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";
    

    /** set 급여년도 : payYrDisp */
    public static final String ATTR_PAYYRDISP = "payYrDisp";

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public static final String ATTR_OCCUCLSSPAYCMPTTNSTD = "occuClssPayCmpttnStd";

    /** set 단가금액 : ucstSum */
    public static final String ATTR_UCSTSUM = "ucstSum";

    /** set 단가계산구분코드 : ucstCalcDivCd */
    public static final String ATTR_UCSTCALCDIVCD = "ucstCalcDivCd";

    /** set 단가계산구분 : ucstCalcDivNm */
    public static final String ATTR_UCSTCALCDIVNM = "ucstCalcDivNm";
 
    /** set 단가출력순서 : ucstPrntOrd */
    public static final String ATTR_UCSTPRNTORD = "ucstPrntOrd";

    /** set 단가표시작일자 : ucstDgmBgnnDt */
    public static final String ATTR_UCSTDGMBGNNDT = "ucstDgmBgnnDt";

    /** set 단가표종료일자 : ucstDgmEndDt */
    public static final String ATTR_UCSTDGMENDDT = "ucstDgmEndDt";

    /** set 단가표사용여부 : ucstDgmUseYn */
    public static final String ATTR_UCSTDGMUSEYN = "ucstDgmUseYn";

    /** set 단가비고내용 : ucstNoteCtnt */
    public static final String ATTR_UCSTNOTECTNT = "ucstNoteCtnt";

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

    /** set 단위기관코드   : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    
    /** set 단위기관  : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
 

/** set 급여적용시점일자 : payrIntoDt */
public static final String ATTR_PAYRINTODT = "payrIntoDt";

/** set 단가금액02 : ucstSum02 */
public static final String ATTR_UCSTSUM02 = "ucstSum02";

/** set 급여항목구간기준일자 : payrItemTrmStdDt */
public static final String ATTR_PAYRITEMTRMSTDDT = "payrItemTrmStdDt";


    /** 생성자 */
     public Payr0440BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0440BM(
    		 String  dpobCd 
    		 , Long  typOccuGrdeMppgSeilNum 
    	        , Long  payrItemSeilNum 
    		, String  typOccuCd 
    		, String  payCd 
    		, String  pyspLogSvcYrNumCd 
    		, String  pyspGrdeCd 
    		, String  payItemCd 
    		, String  ucstDgmApptnDt 
    		, String  dtilOccuClsDivCd 
    		, String  payYr 
    		, String  occuClssPayCmpttnStd 
    		, Long  ucstSum 
    		, String  ucstCalcDivCd 
    		, Long  ucstPrntOrd 
    		, String  ucstDgmBgnnDt 
    		, String  ucstDgmEndDt 
    		, Boolean  ucstDgmUseYn 
    		, String  ucstNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  payrMangDeptCd ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_TYPOCCUGRDEMPPGSEILNUM,typOccuGrdeMppgSeilNum);
        values.put(ATTR_PAYRITEMSEILNUM,payrItemSeilNum);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_PYSPLOGSVCYRNUMCD,pyspLogSvcYrNumCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_PAYITEMCD,payItemCd); 
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_PAYYR,payYr);
     	values.put(ATTR_OCCUCLSSPAYCMPTTNSTD,occuClssPayCmpttnStd);
     	values.put(ATTR_UCSTSUM,ucstSum);
     	values.put(ATTR_UCSTCALCDIVCD,ucstCalcDivCd);
     	values.put(ATTR_UCSTPRNTORD,ucstPrntOrd);
     	values.put(ATTR_UCSTDGMBGNNDT,ucstDgmBgnnDt);
     	values.put(ATTR_UCSTDGMENDDT,ucstDgmEndDt);
     	values.put(ATTR_UCSTDGMUSEYN,ucstDgmUseYn);
     	values.put(ATTR_UCSTNOTECTNT,ucstNoteCtnt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}


/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public void setTypOccuGrdeMppgSeilNum(Long  typOccuGrdeMppgSeilNum) { set( ATTR_TYPOCCUGRDEMPPGSEILNUM ,typOccuGrdeMppgSeilNum);}
/** get 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public Long  getTypOccuGrdeMppgSeilNum() { return (Long )get( ATTR_TYPOCCUGRDEMPPGSEILNUM );}

/** set 급여항목일련번호 : payrItemSeilNum */
public void setPayrItemSeilNum(Long  payrItemSeilNum) { set( ATTR_PAYRITEMSEILNUM ,payrItemSeilNum);}
/** get 급여항목일련번호 : payrItemSeilNum */
public Long  getPayrItemSeilNum() { return (Long )get( ATTR_PAYRITEMSEILNUM );}
 

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    
    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    
    
    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}


    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    
    
    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public void setPyspLogSvcYrNumCd(String  pyspLogSvcYrNumCd) { set( ATTR_PYSPLOGSVCYRNUMCD ,pyspLogSvcYrNumCd);}
    /** get 호봉근속년수코드 : pyspLogSvcYrNumCd */
    public String  getPyspLogSvcYrNumCd() { return (String )get( ATTR_PYSPLOGSVCYRNUMCD );}


    /** set 호봉근속년수 : pyspLogSvcYrNumNm */
    public void setPyspLogSvcYrNumNm(String  pyspLogSvcYrNumNm) { set( ATTR_PYSPLOGSVCYRNUMNM ,pyspLogSvcYrNumNm);}
    /** get 호봉근속년수코드 : pyspLogSvcYrNumNm */
    public String  getPyspLogSvcYrNumNm() { return (String )get( ATTR_PYSPLOGSVCYRNUMNM );}

     
    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}


    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
    
    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}


    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
     
    
    /** set 단가표적용일자 : occuClssPayCmpttnStdDisp */
    public void setOccuClssPayCmpttnStdDisp(String  occuClssPayCmpttnStdDisp) { set( ATTR_OCCUCLSSPAYCMPTTNSTDDISP ,occuClssPayCmpttnStdDisp);}
    /** get 단가표적용일자 : occuClssPayCmpttnStdDisp */
    public String  getOccuClssPayCmpttnStdDisp() { return (String )get( ATTR_OCCUCLSSPAYCMPTTNSTDDISP );}

    
    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
    
    
    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}
    

    /** set 급여년도 : payYrDisp */
    public void setPayYrDisp(String  payYrDisp) { set( ATTR_PAYYRDISP ,payYrDisp);}
    /** get 급여년도 : payYrDisp */
    public String  getPayYrDisp() { return (String )get( ATTR_PAYYRDISP );}

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public void setOccuClssPayCmpttnStd(String  occuClssPayCmpttnStd) { set( ATTR_OCCUCLSSPAYCMPTTNSTD ,occuClssPayCmpttnStd);}
    /** get 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public String  getOccuClssPayCmpttnStd() { return (String )get( ATTR_OCCUCLSSPAYCMPTTNSTD );}

    /** set 단가금액 : ucstSum */
    public void setUcstSum(Double  ucstSum) { set( ATTR_UCSTSUM ,ucstSum);}
    /** get 단가금액 : ucstSum */
    public Double  getUcstSum() { return (Double )get( ATTR_UCSTSUM );}

    /** set 단가계산구분코드 : ucstCalcDivCd */
    public void setUcstCalcDivCd(String  ucstCalcDivCd) { set( ATTR_UCSTCALCDIVCD ,ucstCalcDivCd);}
    /** get 단가계산구분코드 : ucstCalcDivCd */
    public String  getUcstCalcDivCd() { return (String )get( ATTR_UCSTCALCDIVCD );}
    
    /** set 단가계산구분 : ucstCalcDivNm */
    public void setUcstCalcDivNm(String  ucstCalcDivNm) { set( ATTR_UCSTCALCDIVNM ,ucstCalcDivNm);}
    /** get 단가계산구분 : ucstCalcDivNm */
    public String  getUcstCalcDivNm() { return (String )get( ATTR_UCSTCALCDIVNM );}
    

    /** set 단가출력순서 : ucstPrntOrd */
    public void setUcstPrntOrd(Long  ucstPrntOrd) { set( ATTR_UCSTPRNTORD ,ucstPrntOrd);}
    /** get 단가출력순서 : ucstPrntOrd */
    public Long  getUcstPrntOrd() { return (Long )get( ATTR_UCSTPRNTORD );}

    /** set 단가표시작일자 : ucstDgmBgnnDt */
    public void setUcstDgmBgnnDt(String  ucstDgmBgnnDt) { set( ATTR_UCSTDGMBGNNDT ,ucstDgmBgnnDt);}
    /** get 단가표시작일자 : ucstDgmBgnnDt */
    public String  getUcstDgmBgnnDt() { return (String )get( ATTR_UCSTDGMBGNNDT );}

    /** set 단가표종료일자 : ucstDgmEndDt */
    public void setUcstDgmEndDt(String  ucstDgmEndDt) { set( ATTR_UCSTDGMENDDT ,ucstDgmEndDt);}
    /** get 단가표종료일자 : ucstDgmEndDt */
    public String  getUcstDgmEndDt() { return (String )get( ATTR_UCSTDGMENDDT );}

    /** set 단가표사용여부 : ucstDgmUseYn */
    public void setUcstDgmUseYn(Boolean  ucstDgmUseYn) { set( ATTR_UCSTDGMUSEYN ,ucstDgmUseYn);}
    /** get 단가표사용여부 : ucstDgmUseYn */
    public Boolean  getUcstDgmUseYn() { return (Boolean )get( ATTR_UCSTDGMUSEYN );}

    /** set 단가비고내용 : ucstNoteCtnt */
    public void setUcstNoteCtnt(String  ucstNoteCtnt) { set( ATTR_UCSTNOTECTNT ,ucstNoteCtnt);}
    /** get 단가비고내용 : ucstNoteCtnt */
    public String  getUcstNoteCtnt() { return (String )get( ATTR_UCSTNOTECTNT );}

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

    /** set 단위기관코드  : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 단위기관  : payrMangDeptNm */
    public void setPayrMangDeptNm(String  payrMangDeptNm) { set( ATTR_PAYRMANGDEPTNM ,payrMangDeptNm);}
    /** get 단위기관 : payrMangDeptNm */
    public String  getPayrMangDeptNm() { return (String )get( ATTR_PAYRMANGDEPTNM );}

	    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}


/** set 급여적용시점일자 : payrIntoDt */
public void setPayrIntoDt(String  payrIntoDt) { set( ATTR_PAYRINTODT ,payrIntoDt);}
/** get 급여적용시점일자 : payrIntoDt */
public String  getPayrIntoDt() { return (String )get( ATTR_PAYRINTODT );}

/** set 단가금액02 : ucstSum02 */
public void setUcstSum02(Double  ucstSum02) { set( ATTR_UCSTSUM02 ,ucstSum02);}
/** get 단가금액02 : ucstSum02 */
public Double  getUcstSum02() { return (Double )get( ATTR_UCSTSUM02 );}

/** set 급여항목구간기준일자 : payrItemTrmStdDt */
public void setPayrItemTrmStdDt(String  payrItemTrmStdDt) { set( ATTR_PAYRITEMTRMSTDDT ,payrItemTrmStdDt);}
/** get 급여항목구간기준일자 : payrItemTrmStdDt */
public String  getPayrItemTrmStdDt() { return (String )get( ATTR_PAYRITEMTRMSTDDT );}

    
}
