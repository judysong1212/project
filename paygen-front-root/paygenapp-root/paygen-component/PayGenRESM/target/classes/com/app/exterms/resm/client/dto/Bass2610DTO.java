package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass2610VO.java
 * @Description : Bass2610 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2610DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 평일정상근무시간수 : wkdyNorDutyTmNum */
    private java.math.BigDecimal wkdyNorDutyTmNum;

    /** set 평일근무주근무시간수 : wkdyMnDutyTmNum */
    private java.math.BigDecimal wkdyMnDutyTmNum;

    /** set 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
    private java.math.BigDecimal wkdyMnthStdTmNum;

    /** set 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
    private java.math.BigDecimal wkdyExtnnBudTmNum;

    /** set 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
    private java.math.BigDecimal pubcHodyNorDutyTmNum;

    /** set 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
    private java.math.BigDecimal pubcHodyDayStdTmNum;

    /** set 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
    private java.math.BigDecimal pubcHodyMnthBudNumDys;

    /** set 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
    private java.math.BigDecimal pubcHodyMnthBudTmNum;

    /** set 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
    private java.math.BigDecimal servcDutyTmStpSeilNum;

    /** set 근로사업번호 : workBusinNum */
    private java.lang.String workBusinNum;

    /** set 근로사업_단위사업번호 : workUntBusinNum */
    private java.lang.String workUntBusinNum;

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    private java.lang.String mangeUntBusinNum;

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
    
    public java.lang.String getStpInttnSeptVal() {
        return this.stpInttnSeptVal;
    }
    
    public void setStpInttnSeptVal(java.lang.String stpInttnSeptVal) {
        this.stpInttnSeptVal = stpInttnSeptVal;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.math.BigDecimal getWkdyNorDutyTmNum() {
        return this.wkdyNorDutyTmNum;
    }
    
    public void setWkdyNorDutyTmNum(java.math.BigDecimal wkdyNorDutyTmNum) {
        this.wkdyNorDutyTmNum = wkdyNorDutyTmNum;
    }
    
    public java.math.BigDecimal getWkdyMnDutyTmNum() {
        return this.wkdyMnDutyTmNum;
    }
    
    public void setWkdyMnDutyTmNum(java.math.BigDecimal wkdyMnDutyTmNum) {
        this.wkdyMnDutyTmNum = wkdyMnDutyTmNum;
    }
    
    public java.math.BigDecimal getWkdyMnthStdTmNum() {
        return this.wkdyMnthStdTmNum;
    }
    
    public void setWkdyMnthStdTmNum(java.math.BigDecimal wkdyMnthStdTmNum) {
        this.wkdyMnthStdTmNum = wkdyMnthStdTmNum;
    }
    
    public java.math.BigDecimal getWkdyExtnnBudTmNum() {
        return this.wkdyExtnnBudTmNum;
    }
    
    public void setWkdyExtnnBudTmNum(java.math.BigDecimal wkdyExtnnBudTmNum) {
        this.wkdyExtnnBudTmNum = wkdyExtnnBudTmNum;
    }
    
    public java.math.BigDecimal getPubcHodyNorDutyTmNum() {
        return this.pubcHodyNorDutyTmNum;
    }
    
    public void setPubcHodyNorDutyTmNum(java.math.BigDecimal pubcHodyNorDutyTmNum) {
        this.pubcHodyNorDutyTmNum = pubcHodyNorDutyTmNum;
    }
    
    public java.math.BigDecimal getPubcHodyDayStdTmNum() {
        return this.pubcHodyDayStdTmNum;
    }
    
    public void setPubcHodyDayStdTmNum(java.math.BigDecimal pubcHodyDayStdTmNum) {
        this.pubcHodyDayStdTmNum = pubcHodyDayStdTmNum;
    }
    
    public java.math.BigDecimal getPubcHodyMnthBudNumDys() {
        return this.pubcHodyMnthBudNumDys;
    }
    
    public void setPubcHodyMnthBudNumDys(java.math.BigDecimal pubcHodyMnthBudNumDys) {
        this.pubcHodyMnthBudNumDys = pubcHodyMnthBudNumDys;
    }
    
    public java.math.BigDecimal getPubcHodyMnthBudTmNum() {
        return this.pubcHodyMnthBudTmNum;
    }
    
    public void setPubcHodyMnthBudTmNum(java.math.BigDecimal pubcHodyMnthBudTmNum) {
        this.pubcHodyMnthBudTmNum = pubcHodyMnthBudTmNum;
    }
    
    public java.math.BigDecimal getServcDutyTmStpSeilNum() {
        return this.servcDutyTmStpSeilNum;
    }
    
    public void setServcDutyTmStpSeilNum(java.math.BigDecimal servcDutyTmStpSeilNum) {
        this.servcDutyTmStpSeilNum = servcDutyTmStpSeilNum;
    }
    
    public java.lang.String getWorkBusinNum() {
        return this.workBusinNum;
    }
    
    public void setWorkBusinNum(java.lang.String workBusinNum) {
        this.workBusinNum = workBusinNum;
    }
    
    public java.lang.String getWorkUntBusinNum() {
        return this.workUntBusinNum;
    }
    
    public void setWorkUntBusinNum(java.lang.String workUntBusinNum) {
        this.workUntBusinNum = workUntBusinNum;
    }
    
    public java.lang.String getMangeUntBusinNum() {
        return this.mangeUntBusinNum;
    }
    
    public void setMangeUntBusinNum(java.lang.String mangeUntBusinNum) {
        this.mangeUntBusinNum = mangeUntBusinNum;
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
