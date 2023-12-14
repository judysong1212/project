package com.app.exterms.prgm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0480VO.java
 * @Description : Payr0480 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.09.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComP0500BM   extends MSFSimpleBaseModel implements IsSerializable {
    
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 부서코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 급여수당코드 : payExtpyCd */
    public static final String ATTR_PAYEXTPYCD = "payExtpyCd";

    /** set 급여수당그룹코드 : payExtpyGrpCd */
    public static final String ATTR_PAYEXTPYGRPCD = "payExtpyGrpCd";
    

    /** set 급여수당그룹 : payExtpyGrpNm */
    public static final String ATTR_PAYEXTPYGRPNM = "payExtpyGrpNm";


    /** set 급여수당명 : payExtpyNm */
    public static final String ATTR_PAYEXTPYNM = "payExtpyNm";
 
    /** set 급여수당사용여부 : payExtpyUseYn */
    public static final String ATTR_PAYEXTPYUSEYN = "payExtpyUseYn";
 
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

    /** set 지급공제구분코드 : pymtDducDivCd */
    public static final String ATTR_PYMTDDUCDIVCD = "pymtDducDivCd";
    

    /** set 지급공제 : pymtDducDivNm */
    public static final String ATTR_PYMTDDUCDIVNM = "pymtDducDivNm";
    

    /** set 급여수당공제금액 : payExtpySum */
    public static final String ATTR_PAYEXTPYSUM = "payExtpySum";
    
    /** set 급여수당공제비율 : payExtpyRto */
    public static final String ATTR_PAYEXTPYRTO = "payExtpyRto";


    /** 생성자 */
     public PrgmComP0500BM() { super(); } 

    /** 일괄등록 처리   */
     public PrgmComP0500BM(
             String  dpobCd 
            , String  deptCd
            , String  businCd
            , String  payExtpyCd 
            , String  payExtpyGrpCd 
            , String  payExtpyNm  
            , String  payExtpyUseYn  
            , String  pymtDducDivCd ) { 
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_DEPTCD,deptCd);
        values.put(ATTR_BUSINCD,businCd);
        values.put(ATTR_PAYEXTPYCD,payExtpyCd);
        values.put(ATTR_PAYEXTPYGRPCD,payExtpyGrpCd);
        values.put(ATTR_PAYEXTPYNM,payExtpyNm); 
        values.put(ATTR_PAYEXTPYUSEYN,payExtpyUseYn); 
        values.put(ATTR_PYMTDDUCDIVCD,pymtDducDivCd); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    
    /** set 사업코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 사업코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    
    /** set 부서코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 부서코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 급여수당코드 : payExtpyCd */
    public void setPayExtpyCd(String  payExtpyCd) { set( ATTR_PAYEXTPYCD ,payExtpyCd);}
    /** get 급여수당코드 : payExtpyCd */
    public String  getPayExtpyCd() { return (String )get( ATTR_PAYEXTPYCD );}

    /** set 급여수당그룹코드 : payExtpyGrpCd */
    public void setPayExtpyGrpCd(String  payExtpyGrpCd) { set( ATTR_PAYEXTPYGRPCD ,payExtpyGrpCd);}
    /** get 급여수당그룹코드 : payExtpyGrpCd */
    public String  getPayExtpyGrpCd() { return (String )get( ATTR_PAYEXTPYGRPCD );}
    

    /** set 급여수당그룹 : payExtpyGrpNm */
    public void setPayExtpyGrpNm(String  payExtpyGrpNm) { set( ATTR_PAYEXTPYGRPNM ,payExtpyGrpNm);}
    /** get 급여수당그룹 : payExtpyGrpNm */
    public String  getPayExtpyGrpNm() { return (String )get( ATTR_PAYEXTPYGRPNM );}

    /** set 급여수당명 : payExtpyNm */
    public void setPayExtpyNm(String  payExtpyNm) { set( ATTR_PAYEXTPYNM ,payExtpyNm);}
    /** get 급여수당명 : payExtpyNm */
    public String  getPayExtpyNm() { return (String )get( ATTR_PAYEXTPYNM );}
 
    /** set 급여수당사용여부 : payExtpyUseYn */
    public void setPayExtpyUseYn(Boolean  payExtpyUseYn) { set( ATTR_PAYEXTPYUSEYN ,payExtpyUseYn);}
    /** get 급여수당사용여부 : payExtpyUseYn */
    public Boolean  getPayExtpyUseYn() { return (Boolean )get( ATTR_PAYEXTPYUSEYN );}
 

/** set 급여수당공제금액 : payExtpySum */
public void setPayExtpySum(Long  payExtpySum) { set( ATTR_PAYEXTPYSUM ,payExtpySum);}
/** get 급여수당공제금액 : payExtpySum */
public Long  getPayExtpySum() { return (Long )get( ATTR_PAYEXTPYSUM );}

/** set 급여수당공제비율 : payExtpyRto */
public void setPayExtpyRto(Double  payExtpyRto) { set( ATTR_PAYEXTPYRTO ,payExtpyRto);}
/** get 급여수당공제비율 : payExtpyRto */
public Double  getPayExtpyRto() { return (Double )get( ATTR_PAYEXTPYRTO );}


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

    /** set 지급공제구분코드 : pymtDducDivCd */
    public void setPymtDducDivCd(String  pymtDducDivCd) { set( ATTR_PYMTDDUCDIVCD ,pymtDducDivCd);}
    /** get 지급공제구분코드 : pymtDducDivCd */
    public String  getPymtDducDivCd() { return (String )get( ATTR_PYMTDDUCDIVCD );}
    
    /** set 지급공제 : pymtDducDivNm */
    public void setPymtDducDivNm(String  pymtDducDivNm) { set( ATTR_PYMTDDUCDIVNM ,pymtDducDivNm);}
    /** get 지급공제 : pymtDducDivNm */
    public String  getPymtDducDivNm() { return (String )get( ATTR_PYMTDDUCDIVNM );}
    
    
    
}
