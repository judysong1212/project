package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Sysm0120VO.java
 * @Description : Sysm0120 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfSysm0120VO  implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** USR_ERR_LGN_CNT */
    private java.math.BigDecimal usrErrLgnCnt;
    
    /** USR_ERR_LGN_DTTM */
    private java.lang.String usrErrLgnDttm;
    
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
    
    /** USR_LGN_SESN */
    private java.lang.String usrLgnSesn;
    
    /** USR_LGN_CHK_DTTM */
    private java.lang.String usrLgnChkDttm;
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.math.BigDecimal getUsrErrLgnCnt() {
        return this.usrErrLgnCnt;
    }
    
    public void setUsrErrLgnCnt(java.math.BigDecimal usrErrLgnCnt) {
        this.usrErrLgnCnt = usrErrLgnCnt;
    }
    
    public java.lang.String getUsrErrLgnDttm() {
        return this.usrErrLgnDttm;
    }
    
    public void setUsrErrLgnDttm(java.lang.String usrErrLgnDttm) {
        this.usrErrLgnDttm = usrErrLgnDttm;
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
    
    public java.lang.String getUsrLgnSesn() {
        return this.usrLgnSesn;
    }
    
    public void setUsrLgnSesn(java.lang.String usrLgnSesn) {
        this.usrLgnSesn = usrLgnSesn;
    }
    
    public java.lang.String getUsrLgnChkDttm() {
        return this.usrLgnChkDttm;
    }
    
    public void setUsrLgnChkDttm(java.lang.String usrLgnChkDttm) {
        this.usrLgnChkDttm = usrLgnChkDttm;
    }
    
}
