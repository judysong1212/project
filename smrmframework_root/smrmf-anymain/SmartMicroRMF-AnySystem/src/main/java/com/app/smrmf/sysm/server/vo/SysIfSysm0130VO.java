package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysm0130VO.java
 * @Description : Sysm0130 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0130VO  implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** USR_CHG_SEIL_NUM */
    private java.math.BigDecimal usrChgSeilNum;
    
    /** USR_BF_PWD */
    private java.lang.String usrBfPwd;
    
    /** USR_CHG_PWD */
    private java.lang.String usrChgPwd;
    
    /** USR_PWD_CHG_DTTM */
    private java.lang.String usrPwdChgDttm;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.math.BigDecimal getUsrChgSeilNum() {
        return this.usrChgSeilNum;
    }
    
    public void setUsrChgSeilNum(java.math.BigDecimal usrChgSeilNum) {
        this.usrChgSeilNum = usrChgSeilNum;
    }
    
    public java.lang.String getUsrBfPwd() {
        return this.usrBfPwd;
    }
    
    public void setUsrBfPwd(java.lang.String usrBfPwd) {
        this.usrBfPwd = usrBfPwd;
    }
    
    public java.lang.String getUsrChgPwd() {
        return this.usrChgPwd;
    }
    
    public void setUsrChgPwd(java.lang.String usrChgPwd) {
        this.usrChgPwd = usrChgPwd;
    }
    
    public java.lang.String getUsrPwdChgDttm() {
        return this.usrPwdChgDttm;
    }
    
    public void setUsrPwdChgDttm(java.lang.String usrPwdChgDttm) {
        this.usrPwdChgDttm = usrPwdChgDttm;
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
    
}
