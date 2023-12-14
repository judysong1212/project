package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass1100VO.java
 * @Description : Bass1100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass1100DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 평일정상근무시간수 : wkdyNorDutyTmNum */
    private Double wkdyNorDutyTmNum;

    /** set 평일근무주근무시간수 : wkdyMnDutyTmNum */
    private Double wkdyMnDutyTmNum;

    /** set 평일근무월통상기준시간수 : wkdyMnthStdTmNum */
    private Double wkdyMnthStdTmNum;

    /** set 평일연장근무한도시간수 : wkdyExtnnBudTmNum */
    private Double wkdyExtnnBudTmNum;

    /** set 휴일정상근무시간수 : pubcHodyNorDutyTmNum */
    private Double pubcHodyNorDutyTmNum;

    /** set 휴일근무일기준시간수 : pubcHodyDayStdTmNum */
    private Double pubcHodyDayStdTmNum;

    /** set 휴일근무월한도일수 : pubcHodyMnthBudNumDys */
    private Double pubcHodyMnthBudNumDys;

    /** set 휴일근무월한도시간수 : pubcHodyMnthBudTmNum */
    private Double pubcHodyMnthBudTmNum;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set null : deptCd */
    private java.lang.String deptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 복무근무시간설정일련번호 : servcDutyTmStpSeilNum */
    private Long servcDutyTmStpSeilNum;

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
    
    public Double getWkdyNorDutyTmNum() {
        return this.wkdyNorDutyTmNum;
    }
    
    public void setWkdyNorDutyTmNum(Double wkdyNorDutyTmNum) {
        this.wkdyNorDutyTmNum = wkdyNorDutyTmNum;
    }
    
    public Double getWkdyMnDutyTmNum() {
        return this.wkdyMnDutyTmNum;
    }
    
    public void setWkdyMnDutyTmNum(Double wkdyMnDutyTmNum) {
        this.wkdyMnDutyTmNum = wkdyMnDutyTmNum;
    }
    
    public Double getWkdyMnthStdTmNum() {
        return this.wkdyMnthStdTmNum;
    }
    
    public void setWkdyMnthStdTmNum(Double wkdyMnthStdTmNum) {
        this.wkdyMnthStdTmNum = wkdyMnthStdTmNum;
    }
    
    public Double getWkdyExtnnBudTmNum() {
        return this.wkdyExtnnBudTmNum;
    }
    
    public void setWkdyExtnnBudTmNum(Double wkdyExtnnBudTmNum) {
        this.wkdyExtnnBudTmNum = wkdyExtnnBudTmNum;
    }
    
    public Double getPubcHodyNorDutyTmNum() {
        return this.pubcHodyNorDutyTmNum;
    }
    
    public void setPubcHodyNorDutyTmNum(Double pubcHodyNorDutyTmNum) {
        this.pubcHodyNorDutyTmNum = pubcHodyNorDutyTmNum;
    }
    
    public Double getPubcHodyDayStdTmNum() {
        return this.pubcHodyDayStdTmNum;
    }
    
    public void setPubcHodyDayStdTmNum(Double pubcHodyDayStdTmNum) {
        this.pubcHodyDayStdTmNum = pubcHodyDayStdTmNum;
    }
    
    public Double getPubcHodyMnthBudNumDys() {
        return this.pubcHodyMnthBudNumDys;
    }
    
    public void setPubcHodyMnthBudNumDys(Double pubcHodyMnthBudNumDys) {
        this.pubcHodyMnthBudNumDys = pubcHodyMnthBudNumDys;
    }
    
    public Double getPubcHodyMnthBudTmNum() {
        return this.pubcHodyMnthBudTmNum;
    }
    
    public void setPubcHodyMnthBudTmNum(Double pubcHodyMnthBudTmNum) {
        this.pubcHodyMnthBudTmNum = pubcHodyMnthBudTmNum;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuInttnCd() {
        return this.dtilOccuInttnCd;
    }
    
    public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
        this.dtilOccuInttnCd = dtilOccuInttnCd;
    }
    
    public Long getServcDutyTmStpSeilNum() {
        return this.servcDutyTmStpSeilNum;
    }
    
    public void setServcDutyTmStpSeilNum(Long servcDutyTmStpSeilNum) {
        this.servcDutyTmStpSeilNum = servcDutyTmStpSeilNum;
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
