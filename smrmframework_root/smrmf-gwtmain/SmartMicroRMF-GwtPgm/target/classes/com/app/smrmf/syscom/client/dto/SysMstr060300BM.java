package com.app.smrmf.syscom.client.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : SysMstr060300VO.java
 * @Description : SysMstr060300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysMstr060300BM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 휴직구분코드 : levfAbncDivCd */
    public static final String ATTR_LEVFABNCDIVCD = "levfAbncDivCd";

    /** set 휴직급여지급개월수 : levfAbncPayPymtMnth */
    public static final String ATTR_LEVFABNCPAYPYMTMNTH = "levfAbncPayPymtMnth";

    /** set 급여항목그룹코드 : payItemGrpCd */
    public static final String ATTR_PAYITEMGRPCD = "payItemGrpCd";

    /** set 휴직급여지급율 : levfAbncPayPymtRate */
    public static final String ATTR_LEVFABNCPAYPYMTRATE = "levfAbncPayPymtRate";

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
     public SysMstr060300BM() { super(); } 

    /** 일괄등록 처리   */
     public SysMstr060300BM(
    		 String  dpobCd 
    		, String  levfAbncDivCd 
    		, String  levfAbncPayPymtMnth 
    		, String  payItemGrpCd 
    		, BigDecimal  levfAbncPayPymtRate 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_LEVFABNCDIVCD,levfAbncDivCd);
     	values.put(ATTR_LEVFABNCPAYPYMTMNTH,levfAbncPayPymtMnth);
     	values.put(ATTR_PAYITEMGRPCD,payItemGrpCd);
     	values.put(ATTR_LEVFABNCPAYPYMTRATE,levfAbncPayPymtRate);
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

    /** set 휴직구분코드 : levfAbncDivCd */
    public void setLevfAbncDivCd(String  levfAbncDivCd) { set( ATTR_LEVFABNCDIVCD ,levfAbncDivCd);}
    /** get 휴직구분코드 : levfAbncDivCd */
    public String  getLevfAbncDivCd() { return (String )get( ATTR_LEVFABNCDIVCD );}

    /** set 휴직급여지급개월수 : levfAbncPayPymtMnth */
    public void setLevfAbncPayPymtMnth(String  levfAbncPayPymtMnth) { set( ATTR_LEVFABNCPAYPYMTMNTH ,levfAbncPayPymtMnth);}
    /** get 휴직급여지급개월수 : levfAbncPayPymtMnth */
    public String  getLevfAbncPayPymtMnth() { return (String )get( ATTR_LEVFABNCPAYPYMTMNTH );}

    /** set 급여항목그룹코드 : payItemGrpCd */
    public void setPayItemGrpCd(String  payItemGrpCd) { set( ATTR_PAYITEMGRPCD ,payItemGrpCd);}
    /** get 급여항목그룹코드 : payItemGrpCd */
    public String  getPayItemGrpCd() { return (String )get( ATTR_PAYITEMGRPCD );}

    /** set 휴직급여지급율 : levfAbncPayPymtRate */
    public void setLevfAbncPayPymtRate(BigDecimal  levfAbncPayPymtRate) { set( ATTR_LEVFABNCPAYPYMTRATE ,levfAbncPayPymtRate);}
    /** get 휴직급여지급율 : levfAbncPayPymtRate */
    public BigDecimal  getLevfAbncPayPymtRate() { return (BigDecimal )get( ATTR_LEVFABNCPAYPYMTRATE );}

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
