package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2400BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public static final String ATTR_BUSNDTLTYPOCCUCD = "busnDtlTypOccuCd";

    /** set 사업직종세단가적용년도 : busnDtilOccuClsUcstYr */
    public static final String ATTR_BUSNDTILOCCUCLSUCSTYR = "busnDtilOccuClsUcstYr";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 항목명 : itemNm */
    public static final String ATTR_ITEMNM = "itemNm";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";

    /** set 지급공제유형코드 : pymtDducFrmCd */
    public static final String ATTR_PYMTDDUCFRMCD = "pymtDducFrmCd";

    /** set 지급공제율 : pymtDducRate */
    public static final String ATTR_PYMTDDUCRATE = "pymtDducRate";

    /** set 지급공제액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 과세구분코드 : txtnDivCd */
    public static final String ATTR_TXTNDIVCD = "txtnDivCd";

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

    /** set 통상임금여부 : usalyAmntYn */
    public static final String ATTR_USALYAMNTYN = "usalyAmntYn";

    /** set 상여금여부 : allwBnusAmntYn */
    public static final String ATTR_ALLWBNUSAMNTYN = "allwBnusAmntYn";

    /** set 급여항목비고내용 : payItemNoteCtnt */
    public static final String ATTR_PAYITEMNOTECTNT = "payItemNoteCtnt";

    /** set 회계처리구분코드 : accPrcsDivCd */
    public static final String ATTR_ACCPRCSDIVCD = "accPrcsDivCd";

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
     public Bass2400BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2400BM(
    		 String  dpobCd 
    		, String  busnDtlTypOccuCd 
    		, String  busnDtilOccuClsUcstYr 
    		, String  payItemCd 
    		, String  payrMangDeptCd 
    		, String  payCd 
    		, String  itemNm 
    		, String  pymtDducDivCd 
    		, String  pymtDducFrmCd 
    		, Double  pymtDducRate 
    		, Double  pymtDducSum 
    		, String  txtnDivCd 
    		, Double  freeDtyRate 
    		, Double  freeDtySum 
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
    		, Long  rngeOrd 
    		, String  payItemUseYn 
    		, String  itemApptnBgnnDt 
    		, String  itemApptnEndDt 
    		, String  dayMnthAmntDivCd 
    		, String  calcStdDivCd 
    		, String  emymtDivCd 
    		, String  usalyAmntYn 
    		, String  allwBnusAmntYn 
    		, String  payItemNoteCtnt 
    		, String  accPrcsDivCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSNDTLTYPOCCUCD,busnDtlTypOccuCd);
     	values.put(ATTR_BUSNDTILOCCUCLSUCSTYR,busnDtilOccuClsUcstYr);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_PAYCD,payCd);
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
     	values.put(ATTR_ALLWBNUSAMNTYN,allwBnusAmntYn);
     	values.put(ATTR_PAYITEMNOTECTNT,payItemNoteCtnt);
     	values.put(ATTR_ACCPRCSDIVCD,accPrcsDivCd);
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

    /** set 사업_세부직종코드 : busnDtlTypOccuCd */
    public void setBusnDtlTypOccuCd(String  busnDtlTypOccuCd) { set( ATTR_BUSNDTLTYPOCCUCD ,busnDtlTypOccuCd);}
    /** get 사업_세부직종코드 : busnDtlTypOccuCd */
    public String  getBusnDtlTypOccuCd() { return (String )get( ATTR_BUSNDTLTYPOCCUCD );}

    /** set 사업직종세단가적용년도 : busnDtilOccuClsUcstYr */
    public void setBusnDtilOccuClsUcstYr(String  busnDtilOccuClsUcstYr) { set( ATTR_BUSNDTILOCCUCLSUCSTYR ,busnDtilOccuClsUcstYr);}
    /** get 사업직종세단가적용년도 : busnDtilOccuClsUcstYr */
    public String  getBusnDtilOccuClsUcstYr() { return (String )get( ATTR_BUSNDTILOCCUCLSUCSTYR );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

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

    /** set 지급공제율 : pymtDducRate */
    public void setPymtDducRate(Double  pymtDducRate) { set( ATTR_PYMTDDUCRATE ,pymtDducRate);}
    /** get 지급공제율 : pymtDducRate */
    public Double  getPymtDducRate() { return (Double )get( ATTR_PYMTDDUCRATE );}

    /** set 지급공제액 : pymtDducSum */
    public void setPymtDducSum(Double  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지급공제액 : pymtDducSum */
    public Double  getPymtDducSum() { return (Double )get( ATTR_PYMTDDUCSUM );}

    /** set 과세구분코드 : txtnDivCd */
    public void setTxtnDivCd(String  txtnDivCd) { set( ATTR_TXTNDIVCD ,txtnDivCd);}
    /** get 과세구분코드 : txtnDivCd */
    public String  getTxtnDivCd() { return (String )get( ATTR_TXTNDIVCD );}

    /** set 비과세율 : freeDtyRate */
    public void setFreeDtyRate(Double  freeDtyRate) { set( ATTR_FREEDTYRATE ,freeDtyRate);}
    /** get 비과세율 : freeDtyRate */
    public Double  getFreeDtyRate() { return (Double )get( ATTR_FREEDTYRATE );}

    /** set 비과세금액 : freeDtySum */
    public void setFreeDtySum(Double  freeDtySum) { set( ATTR_FREEDTYSUM ,freeDtySum);}
    /** get 비과세금액 : freeDtySum */
    public Double  getFreeDtySum() { return (Double )get( ATTR_FREEDTYSUM );}

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
    public void setRngeOrd(Long  rngeOrd) { set( ATTR_RNGEORD ,rngeOrd);}
    /** get 정렬순서 : rngeOrd */
    public Long  getRngeOrd() { return (Long )get( ATTR_RNGEORD );}

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

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 통상임금여부 : usalyAmntYn */
    public void setUsalyAmntYn(String  usalyAmntYn) { set( ATTR_USALYAMNTYN ,usalyAmntYn);}
    /** get 통상임금여부 : usalyAmntYn */
    public String  getUsalyAmntYn() { return (String )get( ATTR_USALYAMNTYN );}

    /** set 상여금여부 : allwBnusAmntYn */
    public void setAllwBnusAmntYn(String  allwBnusAmntYn) { set( ATTR_ALLWBNUSAMNTYN ,allwBnusAmntYn);}
    /** get 상여금여부 : allwBnusAmntYn */
    public String  getAllwBnusAmntYn() { return (String )get( ATTR_ALLWBNUSAMNTYN );}

    /** set 급여항목비고내용 : payItemNoteCtnt */
    public void setPayItemNoteCtnt(String  payItemNoteCtnt) { set( ATTR_PAYITEMNOTECTNT ,payItemNoteCtnt);}
    /** get 급여항목비고내용 : payItemNoteCtnt */
    public String  getPayItemNoteCtnt() { return (String )get( ATTR_PAYITEMNOTECTNT );}

    /** set 회계처리구분코드 : accPrcsDivCd */
    public void setAccPrcsDivCd(String  accPrcsDivCd) { set( ATTR_ACCPRCSDIVCD ,accPrcsDivCd);}
    /** get 회계처리구분코드 : accPrcsDivCd */
    public String  getAccPrcsDivCd() { return (String )get( ATTR_ACCPRCSDIVCD );}

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
