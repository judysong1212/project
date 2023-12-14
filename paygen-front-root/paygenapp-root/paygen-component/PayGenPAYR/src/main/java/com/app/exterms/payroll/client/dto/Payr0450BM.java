package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0450VO.java
 * @Description : Payr0450 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0450BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 항목수당일련번호 : payPymtItemListSeilNum */
    public static final String ATTR_PAYPYMTITEMLISTSEILNUM = "payPymtItemListSeilNum";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 항목수당구분코드 : itemExtpyDivCd */
    public static final String ATTR_ITEMEXTPYDIVCD = "itemExtpyDivCd";
    

    /** set 급여항목 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";

    /** set 항목수당구분 : itemExtpyDivNm */
    public static final String ATTR_ITEMEXTPYDIVNM = "itemExtpyDivNm";

    

    /** set 시작년수 : styrNum */
    public static final String ATTR_STYRNUM = "styrNum";

    /** set 종료년수 : edyrNum */
    public static final String ATTR_EDYRNUM = "edyrNum";

    /** set 지급공제율 : pymtDducRate */
    public static final String ATTR_PYMTDDUCRATE = "pymtDducRate";

    /** set 지급공제금액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 항목별수당삭제여부 : itemListExtpyDelYn */
    public static final String ATTR_ITEMLISTEXTPYDELYN = "itemListExtpyDelYn";

    /** set 항목별수당비고내용 : rmak */
    public static final String ATTR_RMAK = "rmak";

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

    /** set 급여수당코드 : payExtpyCd */
    public static final String ATTR_PAYEXTPYCD = "payExtpyCd";
    

    /** set 급여수당명 : payExtpyNm */
    public static final String ATTR_PAYEXTPYNM = "payExtpyNm";


/** set 직종코드 : typOccuCd */
public static final String ATTR_TYPOCCUCD = "typOccuCd";

/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

/** set 추가가산금액 : addPymtDducSum */
public static final String ATTR_ADDPYMTDDUCSUM = "addPymtDducSum";


    /** 생성자 */
     public Payr0450BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0450BM(
    		 BigDecimal  payPymtItemListSeilNum 
    		, String  dpobCd 
    		, String  payYr 
    		, String  payItemCd 
    		, String  itemExtpyDivCd 
    		, BigDecimal  styrNum 
    		, BigDecimal  edyrNum 
    		, BigDecimal  pymtDducRate 
    		, BigDecimal  pymtDducSum 
    		, String  itemListExtpyDelYn 
    		, String  rmak  
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, Long  addPymtDducSum
    		) { 
     	values.put(ATTR_PAYPYMTITEMLISTSEILNUM,payPymtItemListSeilNum);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PAYYR,payYr);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_ITEMEXTPYDIVCD,itemExtpyDivCd);
     	values.put(ATTR_STYRNUM,styrNum);
     	values.put(ATTR_EDYRNUM,edyrNum);
     	values.put(ATTR_PYMTDDUCRATE,pymtDducRate);
     	values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
     	values.put(ATTR_ITEMLISTEXTPYDELYN,itemListExtpyDelYn);
     	values.put(ATTR_RMAK,rmak); 
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_ADDPYMTDDUCSUM,addPymtDducSum);
     	} 


     
     /** set 급여수당코드 : payExtpyCd */
     public void setPayExtpyCd(String  payExtpyCd) { set( ATTR_PAYEXTPYCD ,payExtpyCd);}
     /** get 급여수당코드 : payExtpyCd */
     public String  getPayExtpyCd() { return (String )get( ATTR_PAYEXTPYCD );}
 
     /** set 급여수당명 : payExtpyNm */
     public void setPayExtpyNm(String  payExtpyNm) { set( ATTR_PAYEXTPYNM ,payExtpyNm);}
     /** get 급여수당명 : payExtpyNm */
     public String  getPayExtpyNm() { return (String )get( ATTR_PAYEXTPYNM );}
     
     
    /** set 항목수당일련번호 : payPymtItemListSeilNum */
    public void setPayPymtItemListSeilNum(BigDecimal  payPymtItemListSeilNum) { set( ATTR_PAYPYMTITEMLISTSEILNUM ,payPymtItemListSeilNum);}
    /** get 항목수당일련번호 : payPymtItemListSeilNum */
    public BigDecimal  getPayPymtItemListSeilNum() { return (BigDecimal )get( ATTR_PAYPYMTITEMLISTSEILNUM );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

    /** set 항목수당구분코드 : itemExtpyDivCd */
    public void setItemExtpyDivCd(String  itemExtpyDivCd) { set( ATTR_ITEMEXTPYDIVCD ,itemExtpyDivCd);}
    /** get 항목수당구분코드 : itemExtpyDivCd */
    public String  getItemExtpyDivCd() { return (String )get( ATTR_ITEMEXTPYDIVCD );}


    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}

    /** set 항목수당구분 : itemExtpyDivNm */
    public void setItemExtpyDivNm(String  itemExtpyDivNm) { set( ATTR_ITEMEXTPYDIVNM ,itemExtpyDivNm);}
    /** get 항목수당구분 : itemExtpyDivNm */
    public String  getItemExtpyDivNm() { return (String )get( ATTR_ITEMEXTPYDIVNM );}

    
    /** set 시작년수 : styrNum */
    public void setStyrNum(BigDecimal  styrNum) { set( ATTR_STYRNUM ,styrNum);}
    /** get 시작년수 : styrNum */
    public BigDecimal  getStyrNum() { return (BigDecimal )get( ATTR_STYRNUM );}

    /** set 종료년수 : edyrNum */
    public void setEdyrNum(BigDecimal  edyrNum) { set( ATTR_EDYRNUM ,edyrNum);}
    /** get 종료년수 : edyrNum */
    public BigDecimal  getEdyrNum() { return (BigDecimal )get( ATTR_EDYRNUM );}

    /** set 지급공제율 : pymtDducRate */
    public void setPymtDducRate(BigDecimal  pymtDducRate) { set( ATTR_PYMTDDUCRATE ,pymtDducRate);}
    /** get 지급공제율 : pymtDducRate */
    public BigDecimal  getPymtDducRate() { return (BigDecimal )get( ATTR_PYMTDDUCRATE );}

    /** set 지급공제금액 : pymtDducSum */
    public void setPymtDducSum(BigDecimal  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지급공제금액 : pymtDducSum */
    public BigDecimal  getPymtDducSum() { return (BigDecimal )get( ATTR_PYMTDDUCSUM );}

    /** set 항목별수당삭제여부 : itemListExtpyDelYn */
    public void setItemListExtpyDelYn(String  itemListExtpyDelYn) { set( ATTR_ITEMLISTEXTPYDELYN ,itemListExtpyDelYn);}
    /** get 항목별수당삭제여부 : itemListExtpyDelYn */
    public String  getItemListExtpyDelYn() { return (String )get( ATTR_ITEMLISTEXTPYDELYN );}

    /** set 항목별수당비고내용 : rmak */
    public void setRmak(String  rmak) { set( ATTR_RMAK ,rmak);}
    /** get 항목별수당비고내용 : rmak */
    public String  getRmak() { return (String )get( ATTR_RMAK );}

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


/** set 직종코드 : typOccuCd */
public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
/** get 직종코드 : typOccuCd */
public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

/** set 추가가산금액 : addPymtDducSum */
public void setAddPymtDducSum(BigDecimal  addPymtDducSum) { set( ATTR_ADDPYMTDDUCSUM ,addPymtDducSum);}
/** get 추가가산금액 : addPymtDducSum */
public BigDecimal  getAddPymtDducSum() { return (BigDecimal )get( ATTR_ADDPYMTDDUCSUM );}
  
    
}
