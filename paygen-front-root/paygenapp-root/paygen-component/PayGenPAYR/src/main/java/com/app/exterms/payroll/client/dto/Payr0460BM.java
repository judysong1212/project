package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0460VO.java
 * @Description : Payr0460 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0460BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 급여년도 : payYr */
    public static final String ATTR_PAYYR = "payYr";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 직책_직종세코드 : odtyDtilOccuClsCd */
    public static final String ATTR_ODTYDTILOCCUCLSCD = "odtyDtilOccuClsCd";


    /** set 직책_직종세 : odtyDtilOccuClsCd */
    public static final String ATTR_ODTYDTILOCCUCLSNM = "odtyDtilOccuClsNm";

    
    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";
    

    /** set 급여항목 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";


    /** set 직책_직종세수당금액 : odtyDtilOccuClsSum */
    public static final String ATTR_ODTYDTILOCCUCLSSUM = "odtyDtilOccuClsSum";

    /** set 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
    public static final String ATTR_ODTYDTILOCCUCLSNOTECTNT = "odtyDtilOccuClsNoteCtnt";

    /** set 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
    public static final String ATTR_ODTYDTILOCCUCLSDELYN = "odtyDtilOccuClsDelYn";

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

    
    /** 생성자 */
     public Payr0460BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0460BM(
    		 String  payYr 
    		, String  dpobCd 
    		, String  odtyDtilOccuClsCd 
    		, String  payItemCd 
    		, BigDecimal  odtyDtilOccuClsSum 
    		, String  odtyDtilOccuClsNoteCtnt 
    		, String  odtyDtilOccuClsDelYn  ) { 
     	values.put(ATTR_PAYYR,payYr);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_ODTYDTILOCCUCLSCD,odtyDtilOccuClsCd);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_ODTYDTILOCCUCLSSUM,odtyDtilOccuClsSum);
     	values.put(ATTR_ODTYDTILOCCUCLSNOTECTNT,odtyDtilOccuClsNoteCtnt);
     	values.put(ATTR_ODTYDTILOCCUCLSDELYN,odtyDtilOccuClsDelYn);  } 

     
     /** set 급여수당코드 : payExtpyCd */
     public void setPayExtpyCd(String  payExtpyCd) { set( ATTR_PAYEXTPYCD ,payExtpyCd);}
     /** get 급여수당코드 : payExtpyCd */
     public String  getPayExtpyCd() { return (String )get( ATTR_PAYEXTPYCD );}
 
     /** set 급여수당명 : payExtpyNm */
     public void setPayExtpyNm(String  payExtpyNm) { set( ATTR_PAYEXTPYNM ,payExtpyNm);}
     /** get 급여수당명 : payExtpyNm */
     public String  getPayExtpyNm() { return (String )get( ATTR_PAYEXTPYNM );}
     
    /** set 급여년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 급여년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 직책_직종세코드 : odtyDtilOccuClsCd */
    public void setOdtyDtilOccuClsCd(String  odtyDtilOccuClsCd) { set( ATTR_ODTYDTILOCCUCLSCD ,odtyDtilOccuClsCd);}
    /** get 직책_직종세코드 : odtyDtilOccuClsCd */
    public String  getOdtyDtilOccuClsCd() { return (String )get( ATTR_ODTYDTILOCCUCLSCD );}
    

    /** set 직책_직종세 : odtyDtilOccuClsNm */
    public void setOdtyDtilOccuClsNm(String  odtyDtilOccuClsNm) { set( ATTR_ODTYDTILOCCUCLSNM ,odtyDtilOccuClsNm);}
    /** get 직책_직종세코드 : odtyDtilOccuClsNm */
    public String  getOdtyDtilOccuClsNm() { return (String )get( ATTR_ODTYDTILOCCUCLSNM );}
    

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
    

    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목코드 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
    

    /** set 직책_직종세수당금액 : odtyDtilOccuClsSum */
    public void setOdtyDtilOccuClsSum(BigDecimal  odtyDtilOccuClsSum) { set( ATTR_ODTYDTILOCCUCLSSUM ,odtyDtilOccuClsSum);}
    /** get 직책_직종세수당금액 : odtyDtilOccuClsSum */
    public BigDecimal  getOdtyDtilOccuClsSum() { return (BigDecimal )get( ATTR_ODTYDTILOCCUCLSSUM );}

    /** set 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
    public void setOdtyDtilOccuClsNoteCtnt(String  odtyDtilOccuClsNoteCtnt) { set( ATTR_ODTYDTILOCCUCLSNOTECTNT ,odtyDtilOccuClsNoteCtnt);}
    /** get 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
    public String  getOdtyDtilOccuClsNoteCtnt() { return (String )get( ATTR_ODTYDTILOCCUCLSNOTECTNT );}

    /** set 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
    public void setOdtyDtilOccuClsDelYn(String  odtyDtilOccuClsDelYn) { set( ATTR_ODTYDTILOCCUCLSDELYN ,odtyDtilOccuClsDelYn);}
    /** get 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
    public String  getOdtyDtilOccuClsDelYn() { return (String )get( ATTR_ODTYDTILOCCUCLSDELYN );}

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
