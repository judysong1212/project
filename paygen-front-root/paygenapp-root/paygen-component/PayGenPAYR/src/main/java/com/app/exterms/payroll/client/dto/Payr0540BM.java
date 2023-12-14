package com.app.exterms.payroll.client.dto;

 
import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0540VO.java
 * @Description : Payr0540 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0540BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 예외처리일련번호 : exptnPrcsSeilNum */
    public static final String ATTR_EXPTNPRCSSEILNUM = "exptnPrcsSeilNum";

    /** set 예외구분코드 : exptnDivCd */
    public static final String ATTR_EXPTNDIVCD = "exptnDivCd";
    
    /** set 예외구분 : exptnDivNm */
    public static final String ATTR_EXPTNDIVNM = "exptnDivNm";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
    

    /** set 지급공제구분 : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";

    /** set 면제여부 : exmtnYn */
    public static final String ATTR_EXMTNYN = "exmtnYn";

    /** set 예외처리지급금액 : exptnPrcsPymtSum */
    public static final String ATTR_EXPTNPRCSPYMTSUM = "exptnPrcsPymtSum";

    /** set 예외처리지급비율 : exptnPrcsPymtRto */
    public static final String ATTR_EXPTNPRCSPYMTRTO = "exptnPrcsPymtRto";

    /** set 예외처리시작일자 : exptnPrcsBgnnDt */
    public static final String ATTR_EXPTNPRCSBGNNDT = "exptnPrcsBgnnDt";

    /** set 예외처리종료일자 : exptnPrcsEndDt */
    public static final String ATTR_EXPTNPRCSENDDT = "exptnPrcsEndDt";

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
    
    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 예외처리내용 : exptnPrcsNoteCtnt */
    public static final String ATTR_EXPTNPRCSNOTECTNT = "exptnPrcsNoteCtnt";


    /** 생성자 */
     public Payr0540BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0540BM(
    		 String  systemkey 
    		, Long  exptnPrcsSeilNum 
    		, String  exptnDivCd 
    		, String  pymtDducDivCd 
    		, String  exmtnYn 
    		, Long  exptnPrcsPymtSum 
    		, Long  exptnPrcsPymtRto 
    		, String  exptnPrcsBgnnDt 
    		, String  exptnPrcsEndDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr
    		, String  payItemCd 
            , String  exptnPrcsNoteCtnt ) { 
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_EXPTNPRCSSEILNUM,exptnPrcsSeilNum);
     	values.put(ATTR_EXPTNDIVCD,exptnDivCd);
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
     	values.put(ATTR_EXMTNYN,exmtnYn);
     	values.put(ATTR_EXPTNPRCSPYMTSUM,exptnPrcsPymtSum);
     	values.put(ATTR_EXPTNPRCSPYMTRTO,exptnPrcsPymtRto);
     	values.put(ATTR_EXPTNPRCSBGNNDT,exptnPrcsBgnnDt);
     	values.put(ATTR_EXPTNPRCSENDDT,exptnPrcsEndDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); 
     	values.put(ATTR_PAYITEMCD,payItemCd);
        values.put(ATTR_EXPTNPRCSNOTECTNT,exptnPrcsNoteCtnt);} 


     /** set 사업장코드 : dpobCd */
     public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
     /** get 사업장코드 : dpobCd */
     public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

     
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 예외처리일련번호 : exptnPrcsSeilNum */
    public void setExptnPrcsSeilNum(Long  exptnPrcsSeilNum) { set( ATTR_EXPTNPRCSSEILNUM ,exptnPrcsSeilNum);}
    /** get 예외처리일련번호 : exptnPrcsSeilNum */
    public Long  getExptnPrcsSeilNum() { return (Long )get( ATTR_EXPTNPRCSSEILNUM );}

    /** set 예외구분코드 : exptnDivCd */
    public void setExptnDivCd(String  exptnDivCd) { set( ATTR_EXPTNDIVCD ,exptnDivCd);}
    /** get 예외구분코드 : exptnDivCd */
    public String  getExptnDivCd() { return (String )get( ATTR_EXPTNDIVCD );}
    

    /** set 예외구분 : exptnDivNm */
    public void setExptnDivNm(String  exptnDivNm) { set( ATTR_EXPTNDIVNM ,exptnDivNm);}
    /** get 예외구분코드 : exptnDivNm */
    public String  getExptnDivNm() { return (String )get( ATTR_EXPTNDIVNM );}

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}


    /** set 지급공제구분 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제구분 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}

    
    /** set 면제여부 : exmtnYn */
    public void setExmtnYn(String  exmtnYn) { set( ATTR_EXMTNYN ,exmtnYn);}
    /** get 면제여부 : exmtnYn */
    public String  getExmtnYn() { return (String )get( ATTR_EXMTNYN );}

    /** set 예외처리지급금액 : exptnPrcsPymtSum */
    public void setExptnPrcsPymtSum(Long  exptnPrcsPymtSum) { set( ATTR_EXPTNPRCSPYMTSUM ,exptnPrcsPymtSum);}
    /** get 예외처리지급금액 : exptnPrcsPymtSum */
    public Long  getExptnPrcsPymtSum() { return (Long )get( ATTR_EXPTNPRCSPYMTSUM );}

    /** set 예외처리지급비율 : exptnPrcsPymtRto */
    public void setExptnPrcsPymtRto(Double  exptnPrcsPymtRto) { set( ATTR_EXPTNPRCSPYMTRTO ,exptnPrcsPymtRto);}
    /** get 예외처리지급비율 : exptnPrcsPymtRto */
    public Double  getExptnPrcsPymtRto() { return (Double )get( ATTR_EXPTNPRCSPYMTRTO );}

    /** set 예외처리시작일자 : exptnPrcsBgnnDt */
    public void setExptnPrcsBgnnDt(String  exptnPrcsBgnnDt) { set( ATTR_EXPTNPRCSBGNNDT ,exptnPrcsBgnnDt);}
    /** get 예외처리시작일자 : exptnPrcsBgnnDt */
    public String  getExptnPrcsBgnnDt() { return (String )get( ATTR_EXPTNPRCSBGNNDT );}

    /** set 예외처리종료일자 : exptnPrcsEndDt */
    public void setExptnPrcsEndDt(String  exptnPrcsEndDt) { set( ATTR_EXPTNPRCSENDDT ,exptnPrcsEndDt);}
    /** get 예외처리종료일자 : exptnPrcsEndDt */
    public String  getExptnPrcsEndDt() { return (String )get( ATTR_EXPTNPRCSENDDT );}

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


/** set 급여항목코드 : payItemCd */
public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
/** get 급여항목코드 : payItemCd */
public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}

/** set 예외처리내용 : exptnPrcsNoteCtnt */
public void setExptnPrcsNoteCtnt(String  exptnPrcsNoteCtnt) { set( ATTR_EXPTNPRCSNOTECTNT ,exptnPrcsNoteCtnt);}
/** get 예외처리내용 : exptnPrcsNoteCtnt */
public String  getExptnPrcsNoteCtnt() { return (String )get( ATTR_EXPTNPRCSNOTECTNT );}
}
