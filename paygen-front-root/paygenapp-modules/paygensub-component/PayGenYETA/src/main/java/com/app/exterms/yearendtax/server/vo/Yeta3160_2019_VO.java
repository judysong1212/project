package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta3160VO.java
 * @Description : Yeta3160 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3160_2019_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 임대차일련번호 : leasSqno */
    private java.math.BigDecimal leasSqno;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 임대차_임대인성명 : leasName */
    private java.lang.String leasName;

    /** set 임대차_주민번호 : leasRsno */
    private java.lang.String leasRsno;

    /** set 임대차_주택유형코드 : leasTyhu */
    private java.lang.String leasTyhu;

    /** set 임대차_주책계약면적 : leasArea */
    private java.lang.String leasArea;

    /** set 임대차_계약서상주소 : leasAddr */
    private java.lang.String leasAddr;

    /** set 임대차_계약시작일자 : leasStdt */
    private java.lang.String leasStdt;

    /** set 임대차_계약종료일자 : leasEddt */
    private java.lang.String leasEddt;

    /** set 임대차_전세보증금액 : leasDpst */
    private java.math.BigDecimal leasDpst;

   
    
    public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.math.BigDecimal getLeasSqno() {
        return this.leasSqno;
    }
    
    public void setLeasSqno(java.math.BigDecimal leasSqno) {
        this.leasSqno = leasSqno;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getLeasName() {
        return this.leasName;
    }
    
    public void setLeasName(java.lang.String leasName) {
        this.leasName = leasName;
    }
    
    public java.lang.String getLeasRsno() {
        return this.leasRsno;
    }
    
    public void setLeasRsno(java.lang.String leasRsno) {
        this.leasRsno = leasRsno;
    }
    
    public java.lang.String getLeasTyhu() {
        return this.leasTyhu;
    }
    
    public void setLeasTyhu(java.lang.String leasTyhu) {
        this.leasTyhu = leasTyhu;
    }
    
    public java.lang.String getLeasArea() {
        return this.leasArea;
    }
    
    public void setLeasArea(java.lang.String leasArea) {
        this.leasArea = leasArea;
    }
    
    public java.lang.String getLeasAddr() {
        return this.leasAddr;
    }
    
    public void setLeasAddr(java.lang.String leasAddr) {
        this.leasAddr = leasAddr;
    }
    
    public java.lang.String getLeasStdt() {
        return this.leasStdt;
    }
    
    public void setLeasStdt(java.lang.String leasStdt) {
        this.leasStdt = leasStdt;
    }
    
    public java.lang.String getLeasEddt() {
        return this.leasEddt;
    }
    
    public void setLeasEddt(java.lang.String leasEddt) {
        this.leasEddt = leasEddt;
    }
    
    public java.math.BigDecimal getLeasDpst() {
        return this.leasDpst;
    }
    
    public void setLeasDpst(java.math.BigDecimal leasDpst) {
        this.leasDpst = leasDpst;
    }
    
}
