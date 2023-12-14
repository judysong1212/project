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
public class Bass0505BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set null : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 기간제회계구분코드 : fxtmAccDivCd */
    public static final String ATTR_FXTMACCDIVCD = "fxtmAccDivCd";

    /** set 기간제적용단가일수 : fxtmApptnUcstNumDys */
    public static final String ATTR_FXTMAPPTNUCSTNUMDYS = "fxtmApptnUcstNumDys";

    /** set 기간제일급단가금액 : fxtmPdyUcstSum */
    public static final String ATTR_FXTMPDYUCSTSUM = "fxtmPdyUcstSum";

    /** set 교대근무적용여부 : rotaDutyApptnYn */
    public static final String ATTR_ROTADUTYAPPTNYN = "rotaDutyApptnYn";

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
     public Bass0505BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass0505BM(
    		 String  dpobCd 
    		, String  businCd 
    		, String  deptCd 
    		, String  fxtmAccDivCd 
    		, Double  fxtmApptnUcstNumDys 
    		, Double  fxtmPdyUcstSum 
    		, String  rotaDutyApptnYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_FXTMACCDIVCD,fxtmAccDivCd);
     	values.put(ATTR_FXTMAPPTNUCSTNUMDYS,fxtmApptnUcstNumDys);
     	values.put(ATTR_FXTMPDYUCSTSUM,fxtmPdyUcstSum);
     	values.put(ATTR_ROTADUTYAPPTNYN,rotaDutyApptnYn);
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

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set null : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get null : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 기간제회계구분코드 : fxtmAccDivCd */
    public void setFxtmAccDivCd(String  fxtmAccDivCd) { set( ATTR_FXTMACCDIVCD ,fxtmAccDivCd);}
    /** get 기간제회계구분코드 : fxtmAccDivCd */
    public String  getFxtmAccDivCd() { return (String )get( ATTR_FXTMACCDIVCD );}

    /** set 기간제적용단가일수 : fxtmApptnUcstNumDys */
    public void setFxtmApptnUcstNumDys(Double  fxtmApptnUcstNumDys) { set( ATTR_FXTMAPPTNUCSTNUMDYS ,fxtmApptnUcstNumDys);}
    /** get 기간제적용단가일수 : fxtmApptnUcstNumDys */
    public Double  getFxtmApptnUcstNumDys() { return (Double )get( ATTR_FXTMAPPTNUCSTNUMDYS );}

    /** set 기간제일급단가금액 : fxtmPdyUcstSum */
    public void setFxtmPdyUcstSum(Double  fxtmPdyUcstSum) { set( ATTR_FXTMPDYUCSTSUM ,fxtmPdyUcstSum);}
    /** get 기간제일급단가금액 : fxtmPdyUcstSum */
    public Double  getFxtmPdyUcstSum() { return (Double )get( ATTR_FXTMPDYUCSTSUM );}

    /** set 교대근무적용여부 : rotaDutyApptnYn */
    public void setRotaDutyApptnYn(String  rotaDutyApptnYn) { set( ATTR_ROTADUTYAPPTNYN ,rotaDutyApptnYn);}
    /** get 교대근무적용여부 : rotaDutyApptnYn */
    public String  getRotaDutyApptnYn() { return (String )get( ATTR_ROTADUTYAPPTNYN );}

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
