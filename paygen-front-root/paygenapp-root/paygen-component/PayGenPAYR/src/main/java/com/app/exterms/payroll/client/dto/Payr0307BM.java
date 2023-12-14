package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0307VO.java
 * @Description : Payr0307 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0307BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    
    /** set 순번 : rnum */
    public static final String ATTR_RNUM = "rnum";
    
    /** set 데이터이상여부 : dataChk */
    public static final String ATTR_DATACHK = "dataChk";   
    
    /** set 성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm"; 
    
    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum"; 
    
    
    /** set 부서명 : deptCdNm */
    public static final String ATTR_DEPTCDNM = "deptCdNm"; 
    
    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd"; 

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

	/** set 지급년월 : pymtYrMnth */
	public static final String ATTR_PYMTYRMNTH = "pymtYrMnth";
	
	/** set 급여구분코드 : payCd */
	public static final String ATTR_PAYCD = "payCd";
	
	/** set 급여구분코드 : payCdNm */
	public static final String ATTR_PAYCDNM = "payCdNm";
	
	
	/** set 급여일련번호 : payrSeilNum */
	public static final String ATTR_PAYRSEILNUM = "payrSeilNum";
	
	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";
	
	/** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
	public static final String ATTR_MNTHPAYADMNTSEILNUM = "mnthPayAdmntSeilNum";
	
	/** set 급여항목코드 : payItemCd */
	public static final String ATTR_PAYITEMCD = "payItemCd";
	
	/** set 급여항목코드 : payItemCdNm */
	public static final String ATTR_PAYITEMCDNM = "payItemCdNm";
	
	/** set 지급공제구분코드 : pymtDducDivCd */
	public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
	
	/** set 지급공제구분코드 : pymtDducDivCdNm */
	public static final String ATTR_PYMTDDUCDIVCDNM = "pymtDducDivCdNm";
	
	/** set 지급공제금액 : pymtDducSum */
	public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";
	
	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
	public static final String ATTR_PYMTDDUCFREEDTYSUM = "pymtDducFreeDtySum";
	
	/** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
	public static final String ATTR_MNTHPAYADMNTASSOBSSCTNT = "mnthPayAdmntAssoBssCtnt";
	
	/** set 월급여소급조정여부 : mnthPayAdmntYn */
	public static final String ATTR_MNTHPAYADMNTYN = "mnthPayAdmntYn";
	
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
	
	/** set null : pymtDducTxtnAmnt */
	public static final String ATTR_PYMTDDUCTXTNAMNT = "pymtDducTxtnAmnt";

    /** set null : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    
    /** set 직종세명 : dtilOccuInttnCdNm */
    public static final String ATTR_DTILOCCUINTTNCDNM = "dtilOccuInttnCdNm";
    
    /** set 직종세 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    
    /** set 사업 : businCdNm */
    public static final String ATTR_BUSINCDNM = "businCdNm";
    
    /** set 사업 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
 

    /** 생성자 */
     public Payr0307BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0307BM(
             String  dpobCd 
             ,  String  pymtYrMnth 
    		, String  payCd 
    		, String  systemkey 
    		, String  payItemCd 
    		, String  pymtDducDivCd 
    		, BigDecimal  pymtDducFreeDtySum 
    		, BigDecimal  pymtDducSum 
    		, String  mnthPayAdmntAssoBssCtnt 
    		, String  mnthPayAdmntYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  payrMangDeptCd 
    		, BigDecimal  payrSeilNum 
    		, BigDecimal  mnthPayAdmntSeilNum 
    		, BigDecimal  pymtDducTxtnAmnt ) { 
         values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PYMTYRMNTH,pymtYrMnth);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
     	values.put(ATTR_PYMTDDUCFREEDTYSUM,pymtDducFreeDtySum);
     	values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
     	values.put(ATTR_MNTHPAYADMNTASSOBSSCTNT,mnthPayAdmntAssoBssCtnt);
     	values.put(ATTR_MNTHPAYADMNTYN,mnthPayAdmntYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_PAYRSEILNUM,payrSeilNum);
     	values.put(ATTR_MNTHPAYADMNTSEILNUM,mnthPayAdmntSeilNum);
     	values.put(ATTR_PYMTDDUCTXTNAMNT,pymtDducTxtnAmnt);} 

        
        /** set 사업장코드 : dpobCd */
        public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
        /** get 사업장코드 : dpobCd */
        public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
        
        
        /** set 지급년월 : pymtYrMnth */
        public void setPymtYrMnth(String  pymtYrMnth) { set( ATTR_PYMTYRMNTH ,pymtYrMnth);}
        /** get 지급년월 : pymtYrMnth */
        public String  getPymtYrMnth() { return (String )get( ATTR_PYMTYRMNTH );}
        
        /** set 급여구분코드 : payCd */
        public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
        /** get 급여구분코드 : payCd */
        public String  getPayCd() { return (String )get( ATTR_PAYCD );}
        
        /** set 급여구분코드 : payCdNm */
        public void setPayCdNm(String  payCdNm) { set( ATTR_PAYCDNM ,payCdNm);}
        /** get 급여구분코드 : payCdNm */
        public String  getPayCdNm() { return (String )get( ATTR_PAYCDNM );}
        
        /** set 급여일련번호 : payrSeilNum */
        public void setPayrSeilNum(BigDecimal  payrSeilNum) { set( ATTR_PAYRSEILNUM ,payrSeilNum);}
        /** get 급여일련번호 : payrSeilNum */
        public BigDecimal  getPayrSeilNum() { return (BigDecimal )get( ATTR_PAYRSEILNUM );}
        
        /** set SYSTEMKEY : systemkey */
        public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
        /** get SYSTEMKEY : systemkey */
        public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
        
        /** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
        public void setMnthPayAdmntSeilNum(BigDecimal  mnthPayAdmntSeilNum) { set( ATTR_MNTHPAYADMNTSEILNUM ,mnthPayAdmntSeilNum);}
        /** get 월급여조정일련번호 : mnthPayAdmntSeilNum */
        public BigDecimal  getMnthPayAdmntSeilNum() { return (BigDecimal )get( ATTR_MNTHPAYADMNTSEILNUM );}
        
        /** set 급여항목코드 : payItemCd */
        public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
        /** get 급여항목코드 : payItemCd */
        public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
        
        /** set 급여항목코드 : payItemCdNm */
        public void setPayItemCdNm(String  payItemCdNm) { set( ATTR_PAYITEMCDNM ,payItemCdNm);}
        /** get 급여항목코드 : payItemCd */
        public String  getPayItemCdNm() { return (String )get( ATTR_PAYITEMCDNM );}
        
        /** set 지급공제구분코드 : pymtDducDivCd */
        public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
        /** get 지급공제구분코드 : pymtDducDivCd */
        public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}
        
        /** set 지급공제구분코드 : pymtDducDivCdNm */
        public void setPymtDducDivCdNm(String  pymtDducDivCdNm) { set( ATTR_PYMTDDUCDIVCDNM ,pymtDducDivCdNm);}
        /** get 지급공제구분코드 : pymtDducDivCdNm */
        public String  getPymtDducDivCdNm() { return (String )get( ATTR_PYMTDDUCDIVCDNM );}
        
        /** set 지급공제금액 : pymtDducSum */
        public void setPymtDducSum(BigDecimal  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
        /** get 지급공제금액 : pymtDducSum */
        public BigDecimal  getPymtDducSum() { return (BigDecimal )get( ATTR_PYMTDDUCSUM );}
        
        /** set 지급공제비과세금액 : pymtDducFreeDtySum */
        public void setPymtDducFreeDtySum(BigDecimal  pymtDducFreeDtySum) { set( ATTR_PYMTDDUCFREEDTYSUM ,pymtDducFreeDtySum);}
        /** get 지급공제비과세금액 : pymtDducFreeDtySum */
        public BigDecimal  getPymtDducFreeDtySum() { return (BigDecimal )get( ATTR_PYMTDDUCFREEDTYSUM );}
        
        /** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
        public void setMnthPayAdmntAssoBssCtnt(String  mnthPayAdmntAssoBssCtnt) { set( ATTR_MNTHPAYADMNTASSOBSSCTNT ,mnthPayAdmntAssoBssCtnt);}
        /** get 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
        public String  getMnthPayAdmntAssoBssCtnt() { return (String )get( ATTR_MNTHPAYADMNTASSOBSSCTNT );}
        
        /** set 월급여소급조정여부 : mnthPayAdmntYn */
        public void setMnthPayAdmntYn(String  mnthPayAdmntYn) { set( ATTR_MNTHPAYADMNTYN ,mnthPayAdmntYn);}
        /** get 월급여소급조정여부 : mnthPayAdmntYn */
        public String  getMnthPayAdmntYn() { return (String )get( ATTR_MNTHPAYADMNTYN );}
        
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
        
        /** set null : pymtDducTxtnAmnt */
        public void setPymtDducTxtnAmnt(BigDecimal  pymtDducTxtnAmnt) { set( ATTR_PYMTDDUCTXTNAMNT ,pymtDducTxtnAmnt);}
        /** get null : pymtDducTxtnAmnt */
        public BigDecimal  getPymtDducTxtnAmnt() { return (BigDecimal )get( ATTR_PYMTDDUCTXTNAMNT );}

	    /** set null : payrMangDeptCd */
	    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
	    /** get null : payrMangDeptCd */
	    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
	    
	    /** set 순번 : rnum */
	    public void setRnum(String  rnum) { set( ATTR_RNUM ,rnum);}
	    /** get 순번 : rnum */
	    public String  getRnum() { return (String )get( ATTR_RNUM );}
	    
	    /** set 데이터이상여부 : dataChk */
	    public void setDataChk(String  dataChk) { set( ATTR_DATACHK ,dataChk);}
	    /** get 데이터이상여부 : dataChk */
	    public String  getDataChk() { return (String )get( ATTR_DATACHK );}
	    
	    /** set 성명 : hanNm */
	    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	    /** get 성명 : dataChk */
	    public String  getHanNm() { return (String )get( ATTR_HANNM );}
	    
	    /** set 주민등록번호 : resnRegnNum */
	    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	    /** get 주민등록번호 : resnRegnNum */
	    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
	    
	    /** set 부서명 : deptCdNm */
	    public void setDeptCdNm(String  deptCdNm) { set( ATTR_DEPTCDNM ,deptCdNm);}
	    /** get 부서명 : deptCdNm */
	    public String  getDeptCdNm() { return (String )get( ATTR_DEPTCDNM );}
	    
	    
	    /** set 부서 : deptCd */
	    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	    /** get 부서 : deptCd */
	    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	    
	    /** set 직종세명 : dtilOccuInttnCdNm */
	    public void setDtilOccuInttnCdNm(String  dtilOccuInttnCdNm) { set( ATTR_DTILOCCUINTTNCDNM ,dtilOccuInttnCdNm);}
	    /** get 직종세명 : dtilOccuInttnCdNm */
	    public String  getDtilOccuInttnCdNm() { return (String )get( ATTR_DTILOCCUINTTNCDNM );} 
	    
	    /** set 직종 : dtilOccuInttnCd */
	    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	    /** get 직종 : dtilOccuInttnCd */
	    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );} 
	    
	    /** set 사업명 : businCdNm */
	    public void setBusinCdNm(String  businCdNm) { set( ATTR_BUSINCDNM ,businCdNm);}
	    /** get 사업명 : businCdNm */
	    public String  getBusinCdNm() { return (String )get( ATTR_BUSINCDNM );} 
	    
	    
	    /** set 사업 : businCd */
	    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	    /** get 사업 : businCd */
	    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );} 
	    
	    
 
}
