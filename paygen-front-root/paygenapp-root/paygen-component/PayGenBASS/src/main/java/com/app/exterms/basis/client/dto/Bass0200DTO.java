package com.app.exterms.basis.client.dto;

import java.io.Serializable;

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
public class Bass0200DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;

    /** pubcHodyDt */
    private java.lang.String pubcHodyDt;
    
//    /** YEAR */
//    private java.lang.String year;
//    
//    /** MNTH */
//    private java.lang.String mnth;
//    
//    /** DAY */
//    private java.lang.String day;
    
    /** DOTW_CD */
    private java.lang.String dotwCd;
    
    /** PUBC_HODY_CTNT */
    private java.lang.String pubcHodyCtnt;
    
    /** PUBC_HODY_YN */
    private Boolean pubcHodyYn;
    
    /** PAID_PUBC_HODY_YN */
    private Boolean paidPubcHodyYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** default constructor */
    public Bass0200DTO() {
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
  
    
    public java.lang.String getDotwCd() {
        return this.dotwCd;
    }
    
    public void setDotwCd(java.lang.String dotwCd) {
        this.dotwCd = dotwCd;
    }
    
    public java.lang.String getPubcHodyCtnt() {
        return this.pubcHodyCtnt;
    }
    
    public void setPubcHodyCtnt(java.lang.String pubcHodyCtnt) {
        this.pubcHodyCtnt = pubcHodyCtnt;
    }
    
    public Boolean getPubcHodyYn() {
        return this.pubcHodyYn;
    }
    
    public void setPubcHodyYn(Boolean pubcHodyYn) {
        this.pubcHodyYn = pubcHodyYn;
    }
    
    public Boolean getPaidPubcHodyYn() {
        return this.paidPubcHodyYn;
    }
    
    public void setPaidPubcHodyYn(Boolean paidPubcHodyYn) {
        this.paidPubcHodyYn = paidPubcHodyYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }

	public java.lang.String getPubcHodyDt() {
		return pubcHodyDt;
	}

	public void setPubcHodyDt(java.lang.String pubcHodyDt) {
		this.pubcHodyDt = pubcHodyDt;
	}

    
}
