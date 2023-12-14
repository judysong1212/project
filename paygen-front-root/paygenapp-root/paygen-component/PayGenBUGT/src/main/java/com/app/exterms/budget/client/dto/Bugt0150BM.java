package com.app.exterms.budget.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bugt0150VO.java
 * @Description : Bugt0150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bugt0150BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 회계년도 : accYr */
    public static final String ATTR_ACCYR = "accYr";

    /** set 부서결산일련번호 : deptSttmtAccSeilNum */
    public static final String ATTR_DEPTSTTMTACCSEILNUM = "deptSttmtAccSeilNum";

    /** set 회계단위코드 : accUntCd */
    public static final String ATTR_ACCUNTCD = "accUntCd";

    /** set 회계단위_세목코드 : accUntTxItemCd */
    public static final String ATTR_ACCUNTTXITEMCD = "accUntTxItemCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 적요내용 : smpCtnt */
    public static final String ATTR_SMPCTNT = "smpCtnt";

    /** set 산출근거내용 : calcBssCtnt */
    public static final String ATTR_CALCBSSCTNT = "calcBssCtnt";

    /** set 부서지출금액 : deptExpnsSum */
    public static final String ATTR_DEPTEXPNSSUM = "deptExpnsSum";

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

    /** set IP주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** 생성자 */
     public Bugt0150BM() { super(); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

    /** set 회계년도 : accYr */
    public void setAccYr(String accYr) { set( ATTR_ACCYR ,accYr);}
    /** get 회계년도 : accYr */
    public String getAccYr() { return (String)get( ATTR_ACCYR );}

    /** set 부서결산일련번호 : deptSttmtAccSeilNum */
    public void setDeptSttmtAccSeilNum(String deptSttmtAccSeilNum) { set( ATTR_DEPTSTTMTACCSEILNUM ,deptSttmtAccSeilNum);}
    /** get 부서결산일련번호 : deptSttmtAccSeilNum */
    public String getDeptSttmtAccSeilNum() { return (String)get( ATTR_DEPTSTTMTACCSEILNUM );}

    /** set 회계단위코드 : accUntCd */
    public void setAccUntCd(String accUntCd) { set( ATTR_ACCUNTCD ,accUntCd);}
    /** get 회계단위코드 : accUntCd */
    public String getAccUntCd() { return (String)get( ATTR_ACCUNTCD );}

    /** set 회계단위_세목코드 : accUntTxItemCd */
    public void setAccUntTxItemCd(String accUntTxItemCd) { set( ATTR_ACCUNTTXITEMCD ,accUntTxItemCd);}
    /** get 회계단위_세목코드 : accUntTxItemCd */
    public String getAccUntTxItemCd() { return (String)get( ATTR_ACCUNTTXITEMCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String getDeptCd() { return (String)get( ATTR_DEPTCD );}

    /** set 적요내용 : smpCtnt */
    public void setSmpCtnt(String smpCtnt) { set( ATTR_SMPCTNT ,smpCtnt);}
    /** get 적요내용 : smpCtnt */
    public String getSmpCtnt() { return (String)get( ATTR_SMPCTNT );}

    /** set 산출근거내용 : calcBssCtnt */
    public void setCalcBssCtnt(String calcBssCtnt) { set( ATTR_CALCBSSCTNT ,calcBssCtnt);}
    /** get 산출근거내용 : calcBssCtnt */
    public String getCalcBssCtnt() { return (String)get( ATTR_CALCBSSCTNT );}

    /** set 부서지출금액 : deptExpnsSum */
    public void setDeptExpnsSum(String deptExpnsSum) { set( ATTR_DEPTEXPNSSUM ,deptExpnsSum);}
    /** get 부서지출금액 : deptExpnsSum */
    public String getDeptExpnsSum() { return (String)get( ATTR_DEPTEXPNSSUM );}

    /** set 입력자 : kybdr */
    public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String getKybdr() { return (String)get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String getInptDt() { return (String)get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String getIsmt() { return (String)get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String getRevnDt() { return (String)get( ATTR_REVNDT );}

    /** set IP주소 : revnAddr */
    public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get IP주소 : revnAddr */
    public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}

 
}
