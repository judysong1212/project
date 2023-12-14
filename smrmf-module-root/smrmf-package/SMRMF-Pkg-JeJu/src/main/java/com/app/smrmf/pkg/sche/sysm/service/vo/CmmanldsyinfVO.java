package com.app.smrmf.pkg.sche.sysm.service.vo;

/**
 * @Class Name : CmmanldsyinfVO.java
 * @Description : Cmmanldsyinf VO class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CmmanldsyinfVO extends CmmanldsyinfSrhVO{
    private static final long serialVersionUID = 1L;
    
    /** LOG_DATE */
    private java.lang.String logDate;
    
    /** LOG_SEQ */
    private java.math.BigDecimal logSeq;
    
    /** USER_GB */
    private java.lang.String userGb;
    
    /** DN */
    private java.lang.String dn;
    
    /** CODE */
    private java.lang.String code;
    
    /** TYPE */
    private java.lang.String type;
    
    public java.lang.String getLogDate() {
        return this.logDate;
    }
    
    public void setLogDate(java.lang.String logDate) {
        this.logDate = logDate;
    }
    
    public java.math.BigDecimal getLogSeq() {
        return this.logSeq;
    }
    
    public void setLogSeq(java.math.BigDecimal logSeq) {
        this.logSeq = logSeq;
    }
    
    public java.lang.String getUserGb() {
        return this.userGb;
    }
    
    public void setUserGb(java.lang.String userGb) {
        this.userGb = userGb;
    }
    
    public java.lang.String getDn() {
        return this.dn;
    }
    
    public void setDn(java.lang.String dn) {
        this.dn = dn;
    }
    
    public java.lang.String getCode() {
        return this.code;
    }
    
    public void setCode(java.lang.String code) {
        this.code = code;
    }
    
    public java.lang.String getType() {
        return this.type;
    }
    
    public void setType(java.lang.String type) {
        this.type = type;
    }
    
}
