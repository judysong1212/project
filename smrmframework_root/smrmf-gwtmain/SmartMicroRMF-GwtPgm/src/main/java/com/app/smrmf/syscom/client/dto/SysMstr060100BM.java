package com.app.smrmf.syscom.client.dto;

import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : SysMstr060100VO.java
 * @Description : SysMstr060100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysMstr060100BM  extends MSFSimpleBaseModel implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 가족수당가산자녀수_이상 : famyAllwAddChdQntyOvr */
    public static final String ATTR_FAMYALLWADDCHDQNTYOVR = "famyAllwAddChdQntyOvr";

    /** set 급여채권압류최저압류금지금액 : payBondFrclrMinPhbnSum */
    public static final String ATTR_PAYBONDFRCLRMINPHBNSUM = "payBondFrclrMinPhbnSum";

    /** set 급여채권압류계산적용월금액 : payBondFrclrCalcMnthSum */
    public static final String ATTR_PAYBONDFRCLRCALCMNTHSUM = "payBondFrclrCalcMnthSum";

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
     public SysMstr060100BM() { super(); } 

    /** 일괄등록 처리   */
     public SysMstr060100BM(
    		 String  dpobCd 
    		, BigDecimal  famyAllwAddChdQntyOvr 
    		, BigDecimal  payBondFrclrMinPhbnSum 
    		, BigDecimal  payBondFrclrCalcMnthSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_FAMYALLWADDCHDQNTYOVR,famyAllwAddChdQntyOvr);
     	values.put(ATTR_PAYBONDFRCLRMINPHBNSUM,payBondFrclrMinPhbnSum);
     	values.put(ATTR_PAYBONDFRCLRCALCMNTHSUM,payBondFrclrCalcMnthSum);
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

    /** set 가족수당가산자녀수_이상 : famyAllwAddChdQntyOvr */
    public void setFamyAllwAddChdQntyOvr(BigDecimal  famyAllwAddChdQntyOvr) { set( ATTR_FAMYALLWADDCHDQNTYOVR ,famyAllwAddChdQntyOvr);}
    /** get 가족수당가산자녀수_이상 : famyAllwAddChdQntyOvr */
    public BigDecimal  getFamyAllwAddChdQntyOvr() { return (BigDecimal )get( ATTR_FAMYALLWADDCHDQNTYOVR );}

    /** set 급여채권압류최저압류금지금액 : payBondFrclrMinPhbnSum */
    public void setPayBondFrclrMinPhbnSum(BigDecimal  payBondFrclrMinPhbnSum) { set( ATTR_PAYBONDFRCLRMINPHBNSUM ,payBondFrclrMinPhbnSum);}
    /** get 급여채권압류최저압류금지금액 : payBondFrclrMinPhbnSum */
    public BigDecimal  getPayBondFrclrMinPhbnSum() { return (BigDecimal )get( ATTR_PAYBONDFRCLRMINPHBNSUM );}

    /** set 급여채권압류계산적용월금액 : payBondFrclrCalcMnthSum */
    public void setPayBondFrclrCalcMnthSum(BigDecimal  payBondFrclrCalcMnthSum) { set( ATTR_PAYBONDFRCLRCALCMNTHSUM ,payBondFrclrCalcMnthSum);}
    /** get 급여채권압류계산적용월금액 : payBondFrclrCalcMnthSum */
    public BigDecimal  getPayBondFrclrCalcMnthSum() { return (BigDecimal )get( ATTR_PAYBONDFRCLRCALCMNTHSUM );}

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
