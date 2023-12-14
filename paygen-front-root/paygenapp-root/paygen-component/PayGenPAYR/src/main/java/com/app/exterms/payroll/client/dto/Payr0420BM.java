package com.app.exterms.payroll.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0420VO.java
 * @Description : Payr0420 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0420BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";


/** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
public static final String ATTR_TYPOCCUGRDEMPPGSEILNUM = "typOccuGrdeMppgSeilNum";

/** set 급여항목일련번호 : payrItemSeilNum */
public static final String ATTR_PAYRITEMSEILNUM = "payrItemSeilNum";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";


    /** set 호봉등급 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";
    


    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 항목명 : payItemCd */
    public static final String ATTR_PAYITEMNM = "payItemNm";


    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";
    

    /** set 급여구분코드 : payNm */
    public static final String ATTR_PAYNM = "payNm";
    
    

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public static final String ATTR_OCCUCLSSPAYCMPTTNSTD = "occuClssPayCmpttnStd";

    
    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public static final String ATTR_OCCUCLSSPAYCMPTTNSTDDISP = "occuClssPayCmpttnStdDisp";

     
    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
    

    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";

    /** set 급여산식계산구분코드 : payArithExprCalcDivCd */
    public static final String ATTR_PAYARITHEXPRCALCDIVCD = "payArithExprCalcDivCd";
    
    /** set 급여산식계산구분 : payArithExprCalcDivNm */
    public static final String ATTR_PAYARITHEXPRCALCDIVNM = "payArithExprCalcDivNm";
    

    /** set 산식산정지급항목코드 : arithExprCmpttnPymtItemCd */
    public static final String ATTR_ARITHEXPRCMPTTNPYMTITEMCD = "arithExprCmpttnPymtItemCd";
    

    /** set 산식산정지급항목 : arithExprCmpttnPymtItemNm */
    public static final String ATTR_ARITHEXPRCMPTTNPYMTITEMNM = "arithExprCmpttnPymtItemNm";
    

    /** set 산식산정비율 : arithExprCmpttnRto */
    public static final String ATTR_ARITHEXPRCMPTTNRTO = "arithExprCmpttnRto";

    /** set 산식산정금액 : arithExprCmpttnSum */
    public static final String ATTR_ARITHEXPRCMPTTNSUM = "arithExprCmpttnSum";

    /** set 통상임금여부 : usalyAmntYn */
    public static final String ATTR_USALYAMNTYN = "usalyAmntYn";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    

    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";
    

    /** set 산정기준비고내용 : cmpttnStdNoteCtnt */
    public static final String ATTR_CMPTTNSTDNOTECTNT = "cmpttnStdNoteCtnt";

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

    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
 
    
    /** 생성자 */
     public Payr0420BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0420BM(
    		 String  dpobCd 
    		, String  payYr 
    		, Long  typOccuGrdeMppgSeilNum 
            , Long  payrItemSeilNum 
    		, String  typOccuCd 
    		, String  pyspGrdeCd 
    		, String  payItemCd 
    		, String  payCd 
    		, String  occuClssPayCmpttnStd 
    		, String  dtilOccuClsDivCd 
    		, String  payArithExprCalcDivCd 
    		, String  arithExprCmpttnPymtItemCd 
    		, Double  arithExprCmpttnRto 
    		, Long  arithExprCmpttnSum 
    		, String  usalyAmntYn 
    		, String  emymtDivCd 
    		, String  cmpttnStdNoteCtnt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYYR,payYr);
     	values.put(ATTR_TYPOCCUGRDEMPPGSEILNUM,typOccuGrdeMppgSeilNum);
        values.put(ATTR_PAYRITEMSEILNUM,payrItemSeilNum);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_OCCUCLSSPAYCMPTTNSTD,occuClssPayCmpttnStd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_PAYARITHEXPRCALCDIVCD,payArithExprCalcDivCd);
     	values.put(ATTR_ARITHEXPRCMPTTNPYMTITEMCD,arithExprCmpttnPymtItemCd);
     	values.put(ATTR_ARITHEXPRCMPTTNRTO,arithExprCmpttnRto);
     	values.put(ATTR_ARITHEXPRCMPTTNSUM,arithExprCmpttnSum);
     	values.put(ATTR_USALYAMNTYN,usalyAmntYn);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_CMPTTNSTDNOTECTNT,cmpttnStdNoteCtnt);
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

    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}


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

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}


    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
    
    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    
    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
    

    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
    

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}
    
    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public void setOccuClssPayCmpttnStd(String  occuClssPayCmpttnStd) { set( ATTR_OCCUCLSSPAYCMPTTNSTD ,occuClssPayCmpttnStd);}
    /** get 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    public String  getOccuClssPayCmpttnStd() { return (String )get( ATTR_OCCUCLSSPAYCMPTTNSTD );}


    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStdDisp */
    public void setOccuClssPayCmpttnStdDisp(String  occuClssPayCmpttnStd) { set( ATTR_OCCUCLSSPAYCMPTTNSTDDISP ,occuClssPayCmpttnStd);}
    /** get 직종별급여산정기준일자 : occuClssPayCmpttnStdDisp */
    public String  getOccuClssPayCmpttnStdDisp() { return (String )get( ATTR_OCCUCLSSPAYCMPTTNSTDDISP );}

    
    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}


    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
    
    
    /** set 급여산식계산구분코드 : payArithExprCalcDivCd */
    public void setPayArithExprCalcDivCd(String  payArithExprCalcDivCd) { set( ATTR_PAYARITHEXPRCALCDIVCD ,payArithExprCalcDivCd);}
    /** get 급여산식계산구분코드 : payArithExprCalcDivCd */
    public String  getPayArithExprCalcDivCd() { return (String )get( ATTR_PAYARITHEXPRCALCDIVCD );}


    /** set 급여산식계산구분 : payArithExprCalcDivNm */
    public void setPayArithExprCalcDivNm(String  payArithExprCalcDivNm) { set( ATTR_PAYARITHEXPRCALCDIVNM ,payArithExprCalcDivNm);}
    /** get 급여산식계산구분 : payArithExprCalcDivNm */
    public String  getPayArithExprCalcDivNm() { return (String )get( ATTR_PAYARITHEXPRCALCDIVNM );}

    
    /** set 산식산정지급항목코드 : arithExprCmpttnPymtItemCd */
    public void setArithExprCmpttnPymtItemCd(String  arithExprCmpttnPymtItemCd) { set( ATTR_ARITHEXPRCMPTTNPYMTITEMCD ,arithExprCmpttnPymtItemCd);}
    /** get 산식산정지급항목코드 : arithExprCmpttnPymtItemCd */
    public String  getArithExprCmpttnPymtItemCd() { return (String )get( ATTR_ARITHEXPRCMPTTNPYMTITEMCD );}
    

    /** set 산식산정지급항목 : arithExprCmpttnPymtItemNm */
    public void setArithExprCmpttnPymtItemNm(String  arithExprCmpttnPymtItemNm) { set( ATTR_ARITHEXPRCMPTTNPYMTITEMNM ,arithExprCmpttnPymtItemNm);}
    /** get 산식산정지급항목코드 : arithExprCmpttnPymtItemNm */
    public String  getArithExprCmpttnPymtItemNm() { return (String )get( ATTR_ARITHEXPRCMPTTNPYMTITEMNM );}

    /** set 산식산정비율 : arithExprCmpttnRto */
    public void setArithExprCmpttnRto(Double  arithExprCmpttnRto) { set( ATTR_ARITHEXPRCMPTTNRTO ,arithExprCmpttnRto);}
    /** get 산식산정비율 : arithExprCmpttnRto */
    public Double  getArithExprCmpttnRto() { return (Double )get( ATTR_ARITHEXPRCMPTTNRTO );}

    /** set 산식산정금액 : arithExprCmpttnSum */
    public void setArithExprCmpttnSum(Long  arithExprCmpttnSum) { set( ATTR_ARITHEXPRCMPTTNSUM ,arithExprCmpttnSum);}
    /** get 산식산정금액 : arithExprCmpttnSum */
    public Long  getArithExprCmpttnSum() { return (Long )get( ATTR_ARITHEXPRCMPTTNSUM );}

    /** set 통상임금여부 : usalyAmntYn */
    public void setUsalyAmntYn(String  usalyAmntYn) { set( ATTR_USALYAMNTYN ,usalyAmntYn);}
    /** get 통상임금여부 : usalyAmntYn */
    public String  getUsalyAmntYn() { return (String )get( ATTR_USALYAMNTYN );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    
    /** set 고용구분코드 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분코드 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
    

    /** set 산정기준비고내용 : cmpttnStdNoteCtnt */
    public void setCmpttnStdNoteCtnt(String  cmpttnStdNoteCtnt) { set( ATTR_CMPTTNSTDNOTECTNT ,cmpttnStdNoteCtnt);}
    /** get 산정기준비고내용 : cmpttnStdNoteCtnt */
    public String  getCmpttnStdNoteCtnt() { return (String )get( ATTR_CMPTTNSTDNOTECTNT );}

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

    
	    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

}
