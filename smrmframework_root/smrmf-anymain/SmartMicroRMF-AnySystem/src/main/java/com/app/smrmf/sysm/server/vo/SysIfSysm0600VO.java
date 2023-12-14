package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysm0600VO.java
 * @Description : Sysm0600 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0600VO  implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** USR_DIV_CD */
    private java.lang.String usrDivCd;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** USR_AUTH_USE_YN */
    private java.lang.String usrAuthUseYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.lang.String getUsrDivCd() {
        return this.usrDivCd;
    }
    
    public void setUsrDivCd(java.lang.String usrDivCd) {
        this.usrDivCd = usrDivCd;
    }
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.lang.String getUsrAuthUseYn() {
        return this.usrAuthUseYn;
    }
    
    public void setUsrAuthUseYn(java.lang.String usrAuthUseYn) {
        this.usrAuthUseYn = usrAuthUseYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.sql.Date getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.sql.Date inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.sql.Date getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.sql.Date revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
}
