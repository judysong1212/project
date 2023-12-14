package com.app.exterms.payroll.client.dto;


 

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0520VO.java
 * @Description : Payr0520 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0520BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 급여항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";
    

    /** set 급여항목 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";

    /** set 개별지급공제항목일련번호 : pymtDducItemSilNum */
    public static final String ATTR_PYMTDDUCITEMSILNUM = "pymtDducItemSilNum";

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
    

    /** set 지급공제구분 : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";

    /** set 지금공제금액 : pymtDducSum */
    public static final String ATTR_PYMTDDUCSUM = "pymtDducSum";

    /** set 지금공제율 : pymtDducRate */
    public static final String ATTR_PYMTDDUCRATE = "pymtDducRate";

    /** set 지금공제비과세금액 : pymtDducFreeDtySum */
    public static final String ATTR_PYMTDDUCFREEDTYSUM = "pymtDducFreeDtySum";

    /** set 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
    public static final String ATTR_PYMTDDUCITEMCRETNDIVCD = "pymtDducItemCretnDivCd";
    
    /** set 지급공제항목생성구분코드 : pymtDducItemCretnDivNm */
    public static final String ATTR_PYMTDDUCITEMCRETNDIVNM = "pymtDducItemCretnDivNm";
    

    /** set 지급공제항목비고내용 : pymtDducItemNoteCtnt */
    public static final String ATTR_PYMTDDUCITEMNOTECTNT = "pymtDducItemNoteCtnt";

    /** set 지급공제항목시작일자 : pymtDducItemBgnnDt */
    public static final String ATTR_PYMTDDUCITEMBGNNDT = "pymtDducItemBgnnDt";

    /** set 지급공제항목종료일자 : pymtDducItemEndDt */
    public static final String ATTR_PYMTDDUCITEMENDDT = "pymtDducItemEndDt";

    /** set 지급공제항목삭제여부 : pymtDducItemDelYn */
    public static final String ATTR_PYMTDDUCITEMDELYN = "pymtDducItemDelYn";

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
    
    /** set 년도  : payYr */
    public static final String ATTR_PAYYR  = "payYr";
    
    /** set 비고 2 : ucstNoteCtnt */
    public static final String ATTR_UCSTNOTECTNT = "ucstNoteCtnt";
    

    /** 생성자 */
     public InfcPkgPayr0520BM() { super(); } 

    /** 일괄등록 처리   */
     public InfcPkgPayr0520BM(
    		 String  systemkey 
    		, String  payItemCd 
    		, Long  pymtDducItemSilNum 
    		, String  pymtDducDivCd 
    		, Long  pymtDducSum 
    		, Double  pymtDducRate 
    		, Long  pymtDducFreeDtySum 
    		, String  pymtDducItemCretnDivCd 
    		, String  pymtDducItemNoteCtnt 
    		, String  pymtDducItemBgnnDt 
    		, String  pymtDducItemEndDt 
    		, String  pymtDducItemDelYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PAYITEMCD,payItemCd);
     	values.put(ATTR_PYMTDDUCITEMSILNUM,pymtDducItemSilNum);
     	values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd);
     	values.put(ATTR_PYMTDDUCSUM,pymtDducSum);
     	values.put(ATTR_PYMTDDUCRATE,pymtDducRate);
     	values.put(ATTR_PYMTDDUCFREEDTYSUM,pymtDducFreeDtySum);
     	values.put(ATTR_PYMTDDUCITEMCRETNDIVCD,pymtDducItemCretnDivCd);
     	values.put(ATTR_PYMTDDUCITEMNOTECTNT,pymtDducItemNoteCtnt);
     	values.put(ATTR_PYMTDDUCITEMBGNNDT,pymtDducItemBgnnDt);
     	values.put(ATTR_PYMTDDUCITEMENDDT,pymtDducItemEndDt);
     	values.put(ATTR_PYMTDDUCITEMDELYN,pymtDducItemDelYn);
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

     
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 급여항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 급여항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
    
    /** set 급여항목코드 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 급여항목코드 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}

    /** set 개별지급공제항목일련번호 : pymtDducItemSilNum */
    public void setPymtDducItemSilNum(Long  pymtDducItemSilNum) { set( ATTR_PYMTDDUCITEMSILNUM ,pymtDducItemSilNum);}
    /** get 개별지급공제항목일련번호 : pymtDducItemSilNum */
    public Long  getPymtDducItemSilNum() { return (Long )get( ATTR_PYMTDDUCITEMSILNUM );}

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}
    

    /** set 지급공제구분 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제구분 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}

    /** set 지금공제금액 : pymtDducSum */
    public void setPymtDducSum(Long  pymtDducSum) { set( ATTR_PYMTDDUCSUM ,pymtDducSum);}
    /** get 지금공제금액 : pymtDducSum */
    public Long  getPymtDducSum() { return (Long )get( ATTR_PYMTDDUCSUM );}

    /** set 지금공제율 : pymtDducRate */
    public void setPymtDducRate(Double  pymtDducRate) { set( ATTR_PYMTDDUCRATE ,pymtDducRate);}
    /** get 지금공제율 : pymtDducRate */
    public Double  getPymtDducRate() { return (Double )get( ATTR_PYMTDDUCRATE );}

    /** set 지금공제비과세금액 : pymtDducFreeDtySum */
    public void setPymtDducFreeDtySum(Long  pymtDducFreeDtySum) { set( ATTR_PYMTDDUCFREEDTYSUM ,pymtDducFreeDtySum);}
    /** get 지금공제비과세금액 : pymtDducFreeDtySum */
    public Long  getPymtDducFreeDtySum() { return (Long )get( ATTR_PYMTDDUCFREEDTYSUM );}

    /** set 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
    public void setPymtDducItemCretnDivCd(String  pymtDducItemCretnDivCd) { set( ATTR_PYMTDDUCITEMCRETNDIVCD ,pymtDducItemCretnDivCd);}
    /** get 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
    public String  getPymtDducItemCretnDivCd() { return (String )get( ATTR_PYMTDDUCITEMCRETNDIVCD );}
    

    /** set 지급공제항목생성구분 : pymtDducItemCretnDivNm */
    public void setPymtDducItemCretnDivNm(String  pymtDducItemCretnDivNm) { set( ATTR_PYMTDDUCITEMCRETNDIVNM ,pymtDducItemCretnDivNm);}
    /** get 지급공제항목생성구분 : pymtDducItemCretnDivNm */
    public String  getPymtDducItemCretnDivNm() { return (String )get( ATTR_PYMTDDUCITEMCRETNDIVNM );}

    /** set 지급공제항목비고내용 : pymtDducItemNoteCtnt */
    public void setPymtDducItemNoteCtnt(String  pymtDducItemNoteCtnt) { set( ATTR_PYMTDDUCITEMNOTECTNT ,pymtDducItemNoteCtnt);}
    /** get 지급공제항목비고내용 : pymtDducItemNoteCtnt */
    public String  getPymtDducItemNoteCtnt() { return (String )get( ATTR_PYMTDDUCITEMNOTECTNT );}

    /** set 지급공제항목시작일자 : pymtDducItemBgnnDt */
    public void setPymtDducItemBgnnDt(String  pymtDducItemBgnnDt) { set( ATTR_PYMTDDUCITEMBGNNDT ,pymtDducItemBgnnDt);}
    /** get 지급공제항목시작일자 : pymtDducItemBgnnDt */
    public String  getPymtDducItemBgnnDt() { return (String )get( ATTR_PYMTDDUCITEMBGNNDT );}

    /** set 지급공제항목종료일자 : pymtDducItemEndDt */
    public void setPymtDducItemEndDt(String  pymtDducItemEndDt) { set( ATTR_PYMTDDUCITEMENDDT ,pymtDducItemEndDt);}
    /** get 지급공제항목종료일자 : pymtDducItemEndDt */
    public String  getPymtDducItemEndDt() { return (String )get( ATTR_PYMTDDUCITEMENDDT );}

    /** set 지급공제항목삭제여부 : pymtDducItemDelYn */
    public void setPymtDducItemDelYn(String  pymtDducItemDelYn) { set( ATTR_PYMTDDUCITEMDELYN ,pymtDducItemDelYn);}
    /** get 지급공제항목삭제여부 : pymtDducItemDelYn */
    public String  getPymtDducItemDelYn() { return (String )get( ATTR_PYMTDDUCITEMDELYN );}

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

 
    /** set 년도 : payYr */
    public void setPayYr(String  payYr) { set( ATTR_PAYYR ,payYr);}
    /** get 년도 : payYr */
    public String  getPayYr() { return (String )get( ATTR_PAYYR );}

   
    /** set 비고 2 : ucstNoteCtnt  */
    public void setUcstNoteCtnt(String  ucstNoteCtnt) { set( ATTR_UCSTNOTECTNT ,ucstNoteCtnt);}
    /** get 비고 2 : ucstNoteCtnt  */
    public String  getUcstNoteCtnt() { return (String )get( ATTR_UCSTNOTECTNT );}

    
}
