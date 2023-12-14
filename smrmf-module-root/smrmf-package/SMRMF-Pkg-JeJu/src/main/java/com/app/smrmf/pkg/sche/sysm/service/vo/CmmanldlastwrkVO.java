package com.app.smrmf.pkg.sche.sysm.service.vo;

/**
 * @Class Name : CmmanldlastwrkVO.java
 * @Description : Cmmanldlastwrk VO class
 * @Modification Information
 *
 * @author atres
 * @since 2018.0123
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class CmmanldlastwrkVO extends CmmanldlastwrkSrhVO{
    private static final long serialVersionUID = 1L;
    
    /** SYS_GBN */
    private java.lang.String sysGbn;
    
    /** LOG_DATE */
    private java.lang.String logDate;
    
    /** LOG_SEQ */
    private java.math.BigDecimal logSeq;
    
    public java.lang.String getSysGbn() {
        return this.sysGbn;
    }
    
    public void setSysGbn(java.lang.String sysGbn) {
        this.sysGbn = sysGbn;
    }
    
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
    
}
