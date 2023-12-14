package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0410VO.java
 * @Description : Payr0410 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0410BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";
 
    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    public static final String ATTR_TYPOCCUGRDEMPPGSEILNUM = "typOccuGrdeMppgSeilNum";

    /** set 급여항목일련번호 : payrItemSeilNum */
    public static final String ATTR_PAYRITEMSEILNUM = "payrItemSeilNum";
     

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";
    

    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";
    

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    

    /** set 직종 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    

    /** set 급여항목코드 : payrImcd */
    public static final String ATTR_PAYRIMCD = "payrImcd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    

    /** set 호봉등급 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    

    /** set 직종세코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
    

    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    

    /** set 항목명 : itemNm */
    public static final String ATTR_ITEMNM = "itemNm";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";

    /** set 지급공제유형코드 : pymtDducFrmCd */
    public static final String ATTR_PYMTDDUCFRMCD = "pymtDducFrmCd";
    

    /** set 지급공제구분 : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";

    /** set 지급공제유형 : pymtDducFrmNm */
    public static final String ATTR_PYMTDDUCFRMNM = "pymtDducFrmNm";
    

    /** set 지급공제율 : pymtDducRate */
    public static final String ATTR_PYMTDDUCRATE = "pymtDducRate";

    /** set 지급공제액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 과세구분코드 : txtnDivCd */
    public static final String ATTR_TXTNDIVCD = "txtnDivCd";
    

    /** set 과세구분 : txtnDivNm */
    public static final String ATTR_TXTNDIVNM = "txtnDivNm";
    

    /** set 비과세율 : freeDtyRate */
    public static final String ATTR_FREEDTYRATE = "freeDtyRate";

    /** set 비과세금액 : freeDtySum */
    public static final String ATTR_FREEDTYSUM = "freeDtySum";

    /** set 1월 : jan */
    public static final String ATTR_JAN = "jan";

    /** set 2월 : feb */
    public static final String ATTR_FEB = "feb";

    /** set 3월 : mar */
    public static final String ATTR_MAR = "mar";

    /** set 4월 : apr */
    public static final String ATTR_APR = "apr";

    /** set 5월 : may */
    public static final String ATTR_MAY = "may";

    /** set 6월 : jun */
    public static final String ATTR_JUN = "jun";

    /** set 7월 : jul */
    public static final String ATTR_JUL = "jul";

    /** set 8월 : aug */
    public static final String ATTR_AUG = "aug";

    /** set 9월 : sep */
    public static final String ATTR_SEP = "sep";

    /** set 10월 : oct */
    public static final String ATTR_OCT = "oct";

    /** set 11월 : nov */
    public static final String ATTR_NOV = "nov";

    /** set 12월 : dec */
    public static final String ATTR_DEC = "dec";

    /** set 정렬순서 : rngeOrd */
    public static final String ATTR_RNGEORD = "rngeOrd";

    /** set 급여항목사용여부 : payItemUseYn */
    public static final String ATTR_PAYITEMUSEYN = "payItemUseYn";

    /** set 항목적용시작일자 : itemApptnBgnnDt */
    public static final String ATTR_ITEMAPPTNBGNNDT = "itemApptnBgnnDt";

    /** set 항목적용종료일자 : itemApptnEndDt */
    public static final String ATTR_ITEMAPPTNENDDT = "itemApptnEndDt";

    /** set 일월액구분코드 : dayMnthAmntDivCd */
    public static final String ATTR_DAYMNTHAMNTDIVCD = "dayMnthAmntDivCd";

    /** set 계산기준구분코드 : calcStdDivCd */
    public static final String ATTR_CALCSTDDIVCD = "calcStdDivCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    

    /** set 일월액구분 : dayMnthAmntDivNm */
    public static final String ATTR_DAYMNTHAMNTDIVNM = "dayMnthAmntDivNm";

    /** set 계산기준구분 : calcStdDivNm */
    public static final String ATTR_CALCSTDDIVNM = "calcStdDivNm";

    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";
    

    /** set 통상임금여부 : usalyAmntYn */
    public static final String ATTR_USALYAMNTYN = "usalyAmntYn";

    /** set 급여항목비고내용 : payItemNoteCtnt */
    public static final String ATTR_PAYITEMNOTECTNT = "payItemNoteCtnt";

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
 

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 급여관리부서 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";


    /** set 계산수식내용 : calcStdFunc */
    public static final String ATTR_CALCSTDFUNC = "calcStdFunc";
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
                        
public static final String ATTR_CREATEYN = "createYn";        
	
     
    /** 생성자 */
     public Payr0410BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0410BM(
             String  payYr 
             , String  dpobCd 
             , Long  typOccuGrdeMppgSeilNum 
             , Long  payrItemSeilNum 
    		, String  payCd 
    		, String  typOccuCd 
    		, String  payrImcd 
    		, String  pyspGrdeCd 
    		, String  dtilOccuClsDivCd 
    		, String  itemNm 
    		, String  pymtDducDivCd 
    		, String  pymtDducFrmCd 
    		, BigDecimal  pymtDducRate 
    		, BigDecimal  pymtDducSum 
    		, String  txtnDivCd 
    		, BigDecimal  freeDtyRate 
    		, BigDecimal  freeDtySum 
    		, String  jan 
    		, String  feb 
    		, String  mar 
    		, String  apr 
    		, String  may 
    		, String  jun 
    		, String  jul 
    		, String  aug 
    		, String  sep 
    		, String  oct 
    		, String  nov 
    		, String  dec 
    		, BigDecimal  rngeOrd 
    		, String  payItemUseYn 
    		, String  itemApptnBgnnDt 
    		, String  itemApptnEndDt 
    		, String  dayMnthAmntDivCd 
    		, String  calcStdDivCd 
    		, String  emymtDivCd 
    		, String  usalyAmntYn 
    		, String  payItemNoteCtnt 
    		, String  createYn
    		 ) { 
         values.put(ATTR_PAYYR,payYr);
         values.put(ATTR_DPOBCD,dpobCd);
         values.put(ATTR_TYPOCCUGRDEMPPGSEILNUM,typOccuGrdeMppgSeilNum);
         values.put(ATTR_PAYRITEMSEILNUM,payrItemSeilNum);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_PAYRIMCD,payrImcd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_ITEMNM,itemNm);
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
     	values.put(ATTR_PYMTDDUCFRMCD,pymtDducFrmCd);
     	values.put(ATTR_PYMTDDUCRATE,pymtDducRate);
     	values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
     	values.put(ATTR_TXTNDIVCD,txtnDivCd);
     	values.put(ATTR_FREEDTYRATE,freeDtyRate);
     	values.put(ATTR_FREEDTYSUM,freeDtySum);
     	values.put(ATTR_JAN,jan);
     	values.put(ATTR_FEB,feb);
     	values.put(ATTR_MAR,mar);
     	values.put(ATTR_APR,apr);
     	values.put(ATTR_MAY,may);
     	values.put(ATTR_JUN,jun);
     	values.put(ATTR_JUL,jul);
     	values.put(ATTR_AUG,aug);
     	values.put(ATTR_SEP,sep);
     	values.put(ATTR_OCT,oct);
     	values.put(ATTR_NOV,nov);
     	values.put(ATTR_DEC,dec);
     	values.put(ATTR_RNGEORD,rngeOrd);
     	values.put(ATTR_PAYITEMUSEYN,payItemUseYn);
     	values.put(ATTR_ITEMAPPTNBGNNDT,itemApptnBgnnDt);
     	values.put(ATTR_ITEMAPPTNENDDT,itemApptnEndDt);
     	values.put(ATTR_DAYMNTHAMNTDIVCD,dayMnthAmntDivCd);
     	values.put(ATTR_CALCSTDDIVCD,calcStdDivCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_USALYAMNTYN,usalyAmntYn);
     	values.put(ATTR_PAYITEMNOTECTNT,payItemNoteCtnt);
        values.put(ATTR_CREATEYN,createYn);  } 

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

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}
    

    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}
    

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}


    /** set 직종 : typOccuNm */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종 : typOccuNm */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

    
    /** set 급여항목코드 : payrImcd */
    public void setPayrImcd(String  payrImcd) { set( ATTR_PAYRIMCD ,payrImcd);}
    /** get 급여항목코드 : payrImcd */
    public String  getPayrImcd() { return (String )get( ATTR_PAYRIMCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}


    /** set 호봉등급 : pyspGrdeNm */
    public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
    /** get 호봉등급 : pyspGrdeNm */
    public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
    
    /** set 직종세코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}


    /** set 직종세 : dtilOccuClsDivNm */
    public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** get 직종세 : dtilOccuClsDivNm */
    public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
    
    
    /** set 항목명 : itemNm */
    public void setItemNm(String  itemNm) { set( ATTR_ITEMNM ,itemNm);}
    /** get 항목명 : itemNm */
    public String  getItemNm() { return (String )get( ATTR_ITEMNM );}

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}

    /** set 지급공제유형코드 : pymtDducFrmCd */
    public void setPymtDducFrmCd(String  pymtDducFrmCd) { set( ATTR_PYMTDDUCFRMCD ,pymtDducFrmCd);}
    /** get 지급공제유형코드 : pymtDducFrmCd */
    public String  getPymtDducFrmCd() { return (String )get( ATTR_PYMTDDUCFRMCD );}


    /** set 지급공제구분 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제구분 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}

    /** set 지급공제유형 : pymtDducFrmNm */
    public void setPymtDducFrmNm(String  pymtDducFrmNm) { set( ATTR_PYMTDDUCFRMNM ,pymtDducFrmNm);}
    /** get 지급공제유형 : pymtDducFrmNm */
    public String  getPymtDducFrmNm() { return (String )get( ATTR_PYMTDDUCFRMNM );}

    
    /** set 지급공제율 : pymtDducRate */
    public void setPymtDducRate(BigDecimal  pymtDducRate) { set( ATTR_PYMTDDUCRATE ,pymtDducRate);}
    /** get 지급공제율 : pymtDducRate */
    public BigDecimal  getPymtDducRate() { return (BigDecimal )get( ATTR_PYMTDDUCRATE );}

    /** set 지급공제액 : pymtDducSum */
    public void setPymtDducSum(BigDecimal  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지급공제액 : pymtDducSum */
    public BigDecimal  getPymtDducSum() { return (BigDecimal )get( ATTR_PYMTDDUCSUM );}

    /** set 과세구분코드 : txtnDivCd */
    public void setTxtnDivCd(String  txtnDivCd) { set( ATTR_TXTNDIVCD ,txtnDivCd);}
    /** get 과세구분코드 : txtnDivCd */
    public String  getTxtnDivCd() { return (String )get( ATTR_TXTNDIVCD );}


    /** set 과세구분 : txtnDivNm */
    public void setTxtnDivNm(String  txtnDivNm) { set( ATTR_TXTNDIVNM ,txtnDivNm);}
    /** get 과세구분코드 : txtnDivNm */
    public String  getTxtnDivNm() { return (String )get( ATTR_TXTNDIVNM );}

    
    /** set 비과세율 : freeDtyRate */
    public void setFreeDtyRate(BigDecimal  freeDtyRate) { set( ATTR_FREEDTYRATE ,freeDtyRate);}
    /** get 비과세율 : freeDtyRate */
    public BigDecimal  getFreeDtyRate() { return (BigDecimal )get( ATTR_FREEDTYRATE );}

    /** set 비과세금액 : freeDtySum */
    public void setFreeDtySum(BigDecimal  freeDtySum) { set( ATTR_FREEDTYSUM ,freeDtySum);}
    /** get 비과세금액 : freeDtySum */
    public BigDecimal  getFreeDtySum() { return (BigDecimal )get( ATTR_FREEDTYSUM );}

    /** set 1월 : jan */
    public void setJan(String  jan) { set( ATTR_JAN ,jan);}
    /** get 1월 : jan */
    public String  getJan() { return (String )get( ATTR_JAN );}

    /** set 2월 : feb */
    public void setFeb(String  feb) { set( ATTR_FEB ,feb);}
    /** get 2월 : feb */
    public String  getFeb() { return (String )get( ATTR_FEB );}

    /** set 3월 : mar */
    public void setMar(String  mar) { set( ATTR_MAR ,mar);}
    /** get 3월 : mar */
    public String  getMar() { return (String )get( ATTR_MAR );}

    /** set 4월 : apr */
    public void setApr(String  apr) { set( ATTR_APR ,apr);}
    /** get 4월 : apr */
    public String  getApr() { return (String )get( ATTR_APR );}

    /** set 5월 : may */
    public void setMay(String  may) { set( ATTR_MAY ,may);}
    /** get 5월 : may */
    public String  getMay() { return (String )get( ATTR_MAY );}

    /** set 6월 : jun */
    public void setJun(String  jun) { set( ATTR_JUN ,jun);}
    /** get 6월 : jun */
    public String  getJun() { return (String )get( ATTR_JUN );}

    /** set 7월 : jul */
    public void setJul(String  jul) { set( ATTR_JUL ,jul);}
    /** get 7월 : jul */
    public String  getJul() { return (String )get( ATTR_JUL );}

    /** set 8월 : aug */
    public void setAug(String  aug) { set( ATTR_AUG ,aug);}
    /** get 8월 : aug */
    public String  getAug() { return (String )get( ATTR_AUG );}

    /** set 9월 : sep */
    public void setSep(String  sep) { set( ATTR_SEP ,sep);}
    /** get 9월 : sep */
    public String  getSep() { return (String )get( ATTR_SEP );}

    /** set 10월 : oct */
    public void setOct(String  oct) { set( ATTR_OCT ,oct);}
    /** get 10월 : oct */
    public String  getOct() { return (String )get( ATTR_OCT );}

    /** set 11월 : nov */
    public void setNov(String  nov) { set( ATTR_NOV ,nov);}
    /** get 11월 : nov */
    public String  getNov() { return (String )get( ATTR_NOV );}

    /** set 12월 : dec */
    public void setDec(String  dec) { set( ATTR_DEC ,dec);}
    /** get 12월 : dec */
    public String  getDec() { return (String )get( ATTR_DEC );}

    /** set 정렬순서 : rngeOrd */
    public void setRngeOrd(BigDecimal  rngeOrd) { set( ATTR_RNGEORD ,rngeOrd);}
    /** get 정렬순서 : rngeOrd */
    public BigDecimal  getRngeOrd() { return (BigDecimal )get( ATTR_RNGEORD );}

    /** set 급여항목사용여부 : payItemUseYn */
    public void setPayItemUseYn(String  payItemUseYn) { set( ATTR_PAYITEMUSEYN ,payItemUseYn);}
    /** get 급여항목사용여부 : payItemUseYn */
    public String  getPayItemUseYn() { return (String )get( ATTR_PAYITEMUSEYN );}

    /** set 항목적용시작일자 : itemApptnBgnnDt */
    public void setItemApptnBgnnDt(String  itemApptnBgnnDt) { set( ATTR_ITEMAPPTNBGNNDT ,itemApptnBgnnDt);}
    /** get 항목적용시작일자 : itemApptnBgnnDt */
    public String  getItemApptnBgnnDt() { return (String )get( ATTR_ITEMAPPTNBGNNDT );}

    /** set 항목적용종료일자 : itemApptnEndDt */
    public void setItemApptnEndDt(String  itemApptnEndDt) { set( ATTR_ITEMAPPTNENDDT ,itemApptnEndDt);}
    /** get 항목적용종료일자 : itemApptnEndDt */
    public String  getItemApptnEndDt() { return (String )get( ATTR_ITEMAPPTNENDDT );}

    /** set 일월액구분코드 : dayMnthAmntDivCd */
    public void setDayMnthAmntDivCd(String  dayMnthAmntDivCd) { set( ATTR_DAYMNTHAMNTDIVCD ,dayMnthAmntDivCd);}
    /** get 일월액구분코드 : dayMnthAmntDivCd */
    public String  getDayMnthAmntDivCd() { return (String )get( ATTR_DAYMNTHAMNTDIVCD );}

    /** set 계산기준구분코드 : calcStdDivCd */
    public void setCalcStdDivCd(String  calcStdDivCd) { set( ATTR_CALCSTDDIVCD ,calcStdDivCd);}
    /** get 계산기준구분코드 : calcStdDivCd */
    public String  getCalcStdDivCd() { return (String )get( ATTR_CALCSTDDIVCD );}
    

    /** set 일월액구분 : dayMnthAmntDivNm */
    public void setDayMnthAmntDivNm(String  dayMnthAmntDivNm) { set( ATTR_DAYMNTHAMNTDIVNM ,dayMnthAmntDivNm);}
    /** get 일월액구분 : dayMnthAmntDivNm */
    public String  getDayMnthAmntDivNm() { return (String )get( ATTR_DAYMNTHAMNTDIVNM );}

    /** set 계산기준구분 : calcStdDivNm */
    public void setCalcStdDivNm(String  calcStdDivNm) { set( ATTR_CALCSTDDIVNM ,calcStdDivNm);}
    /** get 계산기준구분 : calcStdDivNm */
    public String  getCalcStdDivNm() { return (String )get( ATTR_CALCSTDDIVNM );}
    


    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    
    /** set 고용구분 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

    /** set 통상임금여부 : usalyAmntYn */
    public void setUsalyAmntYn(String  usalyAmntYn) { set( ATTR_USALYAMNTYN ,usalyAmntYn);}
    /** get 통상임금여부 : usalyAmntYn */
    public String  getUsalyAmntYn() { return (String )get( ATTR_USALYAMNTYN );}

    /** set 급여항목비고내용 : payItemNoteCtnt */
    public void setPayItemNoteCtnt(String  payItemNoteCtnt) { set( ATTR_PAYITEMNOTECTNT ,payItemNoteCtnt);}
    /** get 급여항목비고내용 : payItemNoteCtnt */
    public String  getPayItemNoteCtnt() { return (String )get( ATTR_PAYITEMNOTECTNT );}

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

    
    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}


    /** set 급여관리부서코드 : payrMangDeptNm */
    public void setPayrMangDeptNm(String  payrMangDeptNm) { set( ATTR_PAYRMANGDEPTNM ,payrMangDeptNm);}
    /** get 급여관리부서코드 : payrMangDeptNm */
    public String  getPayrMangDeptNm() { return (String )get( ATTR_PAYRMANGDEPTNM );}
 
    
    /** set 계산수식내용 : calcStdFunc */
    public void setCalcStdFunc(String  calcStdFunc) { set( ATTR_CALCSTDFUNC ,calcStdFunc);}
    /** get 계산수식내용 : calcStdFunc */
    public String  getCalcStdFunc() { return (String )get( ATTR_CALCSTDFUNC );} 
   
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
        
/** set 생성여부 : createYn */
public void setCreateYn(String  createYn) { set( ATTR_CREATEYN ,createYn);}
/** get 생성여부 : createYn */
public String  getCreateYn() { return (String )get( ATTR_CREATEYN );}
    
}
