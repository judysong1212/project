package com.app.exterms.budget.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bugt0050VO.java
 * @Description : Bugt0050 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bugt0050BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 회계단위코드 : accUntCd */
    public static final String ATTR_ACCUNTCD = "accUntCd";

    /** set 회계년도 : accYr */
    public static final String ATTR_ACCYR = "accYr";

    /** set 회계단위_세목코드 : accUntTxItemCd */
    public static final String ATTR_ACCUNTTXITEMCD = "accUntTxItemCd";

    /** set 회계단위_세목명 : accUntTxItemNm */
    public static final String ATTR_ACCUNTTXITEMNM = "accUntTxItemNm";

    /** set 회계단위_세목예산금액 : accUntTxItemBugtSum */
    public static final String ATTR_ACCUNTTXITEMBUGTSUM = "accUntTxItemBugtSum";

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
     public Bugt0050BM() { super(); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String getDpobCd() { return (String)get( ATTR_DPOBCD );}

    /** set 회계단위코드 : accUntCd */
    public void setAccUntCd(String accUntCd) { set( ATTR_ACCUNTCD ,accUntCd);}
    /** get 회계단위코드 : accUntCd */
    public String getAccUntCd() { return (String)get( ATTR_ACCUNTCD );}

    /** set 회계년도 : accYr */
    public void setAccYr(String accYr) { set( ATTR_ACCYR ,accYr);}
    /** get 회계년도 : accYr */
    public String getAccYr() { return (String)get( ATTR_ACCYR );}

    /** set 회계단위_세목코드 : accUntTxItemCd */
    public void setAccUntTxItemCd(String accUntTxItemCd) { set( ATTR_ACCUNTTXITEMCD ,accUntTxItemCd);}
    /** get 회계단위_세목코드 : accUntTxItemCd */
    public String getAccUntTxItemCd() { return (String)get( ATTR_ACCUNTTXITEMCD );}

    /** set 회계단위_세목명 : accUntTxItemNm */
    public void setAccUntTxItemNm(String accUntTxItemNm) { set( ATTR_ACCUNTTXITEMNM ,accUntTxItemNm);}
    /** get 회계단위_세목명 : accUntTxItemNm */
    public String getAccUntTxItemNm() { return (String)get( ATTR_ACCUNTTXITEMNM );}

    /** set 회계단위_세목예산금액 : accUntTxItemBugtSum */
    public void setAccUntTxItemBugtSum(String accUntTxItemBugtSum) { set( ATTR_ACCUNTTXITEMBUGTSUM ,accUntTxItemBugtSum);}
    /** get 회계단위_세목예산금액 : accUntTxItemBugtSum */
    public String getAccUntTxItemBugtSum() { return (String)get( ATTR_ACCUNTTXITEMBUGTSUM );}

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
