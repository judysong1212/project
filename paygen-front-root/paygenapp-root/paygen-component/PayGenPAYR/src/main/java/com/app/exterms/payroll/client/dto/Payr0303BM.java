package com.app.exterms.payroll.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0303VO.java
 * @Description : Payr0303 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0303BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 소급년도 : reattyYr */
    public static final String ATTR_REATTYYR = "reattyYr";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** set 지급년월 : pymtYrMnth */
    public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";

    
    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public static final String ATTR_REATTYSTPDSPTYNUM = "reattyStpDsptyNum";
     
    /** set 소급적용년월 : reattyApptnYrMnth */
    public static final String ATTR_REATTYAPPTNYRMNTH = "reattyApptnYrMnth";
 

	/** set 근태일_시간수 : dilnlazDutyTmDys */
	public static final String ATTR_DILNLAZDUTYTMDYS = "dilnlazDutyTmDys";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";
    
    /** set 급여항목코드 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";
 

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";

    /** set 이전지급공제금액 : bfrPymtDducSum */
    public static final String ATTR_BFRPYMTDDUCSUM = "bfrPymtDducSum";

    /** set 지급공제금액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 소급지급공제차액 : reattyPymtDducSrd */
    public static final String ATTR_REATTYPYMTDDUCSRD = "reattyPymtDducSrd";

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    public static final String ATTR_PYMTDDUCTXTNAMNT = "pymtDducTxtnAmnt";

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    public static final String ATTR_PYMTDDUCFREEDTYSUM = "pymtDducFreeDtySum";

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
    
    /** set 단가금액 : ucstSum */
    public static final String ATTR_UCSTSUM = "ucstSum";


    /** 생성자 */
     public Payr0303BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0303BM(
    		 String  dpobCd 
    		, String  reattyYr 
    		, String  payCd 
    		, String  reattyStpDsptyNum 
    		, String  payItemCd 
    		, String  systemkey 
    		, String  pymtDducDivCd 
    		, Long  bfrPymtDducSum 
    		, Long  pymtDducSum 
    		, Long  reattyPymtDducSrd 
    		, Long  pymtDducTxtnAmnt 
    		, Long  pymtDducFreeDtySum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_REATTYYR,reattyYr);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_REATTYSTPDSPTYNUM,reattyStpDsptyNum);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
     	values.put(ATTR_BFRPYMTDDUCSUM,bfrPymtDducSum);
     	values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
     	values.put(ATTR_REATTYPYMTDDUCSRD,reattyPymtDducSrd);
     	values.put(ATTR_PYMTDDUCTXTNAMNT,pymtDducTxtnAmnt);
     	values.put(ATTR_PYMTDDUCFREEDTYSUM,pymtDducFreeDtySum);
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

    /** set 소급년도 : reattyYr */
    public void setReattyYr(String  reattyYr) { set( ATTR_REATTYYR ,reattyYr);}
    /** get 소급년도 : reattyYr */
    public String  getReattyYr() { return (String )get( ATTR_REATTYYR );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    public void setReattyStpDsptyNum(String  reattyStpDsptyNum) { set( ATTR_REATTYSTPDSPTYNUM ,reattyStpDsptyNum);}
    /** get 소급설정회차번호 : reattyStpDsptyNum */
    public String  getReattyStpDsptyNum() { return (String )get( ATTR_REATTYSTPDSPTYNUM );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}

    /** set 이전지급공제금액 : bfrPymtDducSum */
    public void setBfrPymtDducSum(Long  bfrPymtDducSum) { set( ATTR_BFRPYMTDDUCSUM ,bfrPymtDducSum);}
    /** get 이전지급공제금액 : bfrPymtDducSum */
    public Long  getBfrPymtDducSum() { return (Long )get( ATTR_BFRPYMTDDUCSUM );}

    /** set 지급공제금액 : pymtDducSum */
    public void setPymtDducSum(Long  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지급공제금액 : pymtDducSum */
    public Long  getPymtDducSum() { return (Long )get( ATTR_PYMTDDUCSUM );}

    /** set 소급지급공제차액 : reattyPymtDducSrd */
    public void setReattyPymtDducSrd(Long  reattyPymtDducSrd) { set( ATTR_REATTYPYMTDDUCSRD ,reattyPymtDducSrd);}
    /** get 소급지급공제차액 : reattyPymtDducSrd */
    public Long  getReattyPymtDducSrd() { return (Long )get( ATTR_REATTYPYMTDDUCSRD );}

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    public void setPymtDducTxtnAmnt(Long  pymtDducTxtnAmnt) { set( ATTR_PYMTDDUCTXTNAMNT ,pymtDducTxtnAmnt);}
    /** get 지급공제과세금액 : pymtDducTxtnAmnt */
    public Long  getPymtDducTxtnAmnt() { return (Long )get( ATTR_PYMTDDUCTXTNAMNT );}

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    public void setPymtDducFreeDtySum(Long  pymtDducFreeDtySum) { set( ATTR_PYMTDDUCFREEDTYSUM ,pymtDducFreeDtySum);}
    /** get 지급공제비과세금액 : pymtDducFreeDtySum */
    public Long  getPymtDducFreeDtySum() { return (Long )get( ATTR_PYMTDDUCFREEDTYSUM );}

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

    /** set 급여항목 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목코드 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
   
    /** set 단가금액 : ucstSum */
    public void setUcstSum(Long  ucstSum) { set( ATTR_UCSTSUM ,ucstSum);}
    /** get 단가금액 : ucstSum */
    public Long  getUcstSum() { return (Long )get( ATTR_UCSTSUM );}
    
    /** set 소급적용년월 : reattyApptnYrMnth */
    public void setReattyApptnYrMnth(String  reattyApptnYrMnth) { set( ATTR_REATTYAPPTNYRMNTH ,reattyApptnYrMnth);}
    /** get 소급적용년월 : reattyApptnYrMnth */
    public String  getReattyApptnYrMnth() { return (String )get( ATTR_REATTYAPPTNYRMNTH );}
	     
	/** set 지급년월 : pymtYrMnth */
	public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
	/** get 지급년월 : pymtYrMnth */
	public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}

	/** set 근태일_시간수 : dilnlazDutyTmDys */
	public void setDilnlazDutyTmDys(String  dilnlazDutyTmDys) { set( ATTR_DILNLAZDUTYTMDYS ,dilnlazDutyTmDys);}
	/** get 근태일_시간수 : dilnlazDutyTmDys */
	public String  getDilnlazDutyTmDys() { return (String )get( ATTR_DILNLAZDUTYTMDYS );}
	
}
