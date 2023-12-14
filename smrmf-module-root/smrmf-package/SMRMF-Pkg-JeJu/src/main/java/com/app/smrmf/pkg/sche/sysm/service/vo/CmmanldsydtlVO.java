package com.app.smrmf.pkg.sche.sysm.service.vo;

/**
 * @Class Name : CmmanldsydtlVO.java
 * @Description : Cmmanldsydtl VO class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CmmanldsydtlVO extends CmmanldsydtlSrhVO{
    private static final long serialVersionUID = 1L;
    
    /** LOG_DATE */
    private java.lang.String logDate;
    
    /** LOG_SEQ */
    private java.math.BigDecimal logSeq;
    
    /** ATTR_NAME */
    private java.lang.String attrName;
    
    /** ATTR_VAL */
    private java.lang.String attrVal;
    
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
    
    public java.lang.String getAttrName() {
        return this.attrName;
    }
    
    public void setAttrName(java.lang.String attrName) {
        this.attrName = attrName;
    }
    
    public java.lang.String getAttrVal() {
        return this.attrVal;
    }
    
    public void setAttrVal(java.lang.String attrVal) {
        this.attrVal = attrVal;
    }
    
}
