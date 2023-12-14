package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Psnl0123VO.java
 * @Description : Psnl0123 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0123DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 휴직일련번호 : levfAbncSeilNum */
    private Long levfAbncSeilNum;

    /** set 휴직구분코드 : levfAbncDivCd */
    private java.lang.String levfAbncDivCd;

    /** set 휴직시작일자 : levfAbncBgnnDt */
    private java.lang.String levfAbncBgnnDt;

    /** set 휴직종료일자 : levfAbncEndDt */
    private java.lang.String levfAbncEndDt;

    /** set 실제복직일자 : turtyRntmntDt */
    private java.lang.String turtyRntmntDt;

    /** set 휴직비고내용 : levfAbncNoteCtnt */
    private java.lang.String levfAbncNoteCtnt;

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;
 
    
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
    
    public Long getLevfAbncSeilNum() {
        return this.levfAbncSeilNum;
    }
    
    public void setLevfAbncSeilNum(Long levfAbncSeilNum) {
        this.levfAbncSeilNum = levfAbncSeilNum;
    }
    
    public java.lang.String getLevfAbncDivCd() {
        return this.levfAbncDivCd;
    }
    
    public void setLevfAbncDivCd(java.lang.String levfAbncDivCd) {
        this.levfAbncDivCd = levfAbncDivCd;
    }
    
    public java.lang.String getLevfAbncBgnnDt() {
        return this.levfAbncBgnnDt;
    }
    
    public void setLevfAbncBgnnDt(java.lang.String levfAbncBgnnDt) {
        this.levfAbncBgnnDt = levfAbncBgnnDt;
    }
    
    public java.lang.String getLevfAbncEndDt() {
        return this.levfAbncEndDt;
    }
    
    public void setLevfAbncEndDt(java.lang.String levfAbncEndDt) {
        this.levfAbncEndDt = levfAbncEndDt;
    }
    
    public java.lang.String getTurtyRntmntDt() {
        return this.turtyRntmntDt;
    }
    
    public void setTurtyRntmntDt(java.lang.String turtyRntmntDt) {
        this.turtyRntmntDt = turtyRntmntDt;
    }
    
    public java.lang.String getLevfAbncNoteCtnt() {
        return this.levfAbncNoteCtnt;
    }
    
    public void setLevfAbncNoteCtnt(java.lang.String levfAbncNoteCtnt) {
        this.levfAbncNoteCtnt = levfAbncNoteCtnt;
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
    
}
