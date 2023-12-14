package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Bass2600VO.java
 * @Description : Bass2600 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2600DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 설정통합구분값 : stpInttnSeptVal */
    private java.lang.String stpInttnSeptVal;

    /** set 조기출근집계여부 : eryGtwkTotYn */
    private java.lang.String eryGtwkTotYn;

    /** set 근태공제급여차감여부 : dilnlazDducPaySubtnYn */
    private java.lang.String dilnlazDducPaySubtnYn;

    /** set 주휴수당처리여부 : wklyHldyExtpyPrcsYn */
    private java.lang.String wklyHldyExtpyPrcsYn;

    /** set 평일정상근무시간절삭구분코드 : wkdyNorTmCttgDivCd */
    private java.lang.String wkdyNorTmCttgDivCd;

    /** set 평일연장근무절삭구분코드 : wkdyExtnnCttgDivCd */
    private java.lang.String wkdyExtnnCttgDivCd;

    /** set 평일야간근무절삭구분코드 : wkdyNgtCttgDivCd */
    private java.lang.String wkdyNgtCttgDivCd;

    /** set 휴일정상근무시간절삭구분코드 : pubcHodyNorTmCttgCd */
    private java.lang.String pubcHodyNorTmCttgCd;

    /** set 휴일연장근무시간절삭구분코드 : pubcHodyExtnnTmCttgCd */
    private java.lang.String pubcHodyExtnnTmCttgCd;

    /** set 평일정상근무표시구분코드 : wkdyNorDutyMrkDivCd */
    private java.lang.String wkdyNorDutyMrkDivCd;

    /** set 평일연장근무표시구분코드 : wkdyExtnnMrkDivCd */
    private java.lang.String wkdyExtnnMrkDivCd;

    /** set 평일야간근무표시구분코드 : wkdyNgtMrkDivCd */
    private java.lang.String wkdyNgtMrkDivCd;

    /** set 휴일정상근무표시구분코드 : pubcHodyNorMrkDivCd */
    private java.lang.String pubcHodyNorMrkDivCd;

    /** set 휴일연장근무표시구분코드 : pubcHodyExtnnMrkCd */
    private java.lang.String pubcHodyExtnnMrkCd;

    /** set 휴일야간근무표시구분코드 : pubcHodyNgtMrkDivCd */
    private java.lang.String pubcHodyNgtMrkDivCd;

    /** set 복무공통설정일련번호 : servcCommSeilNum */
    private java.math.BigDecimal servcCommSeilNum;

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
    
    public java.lang.String getEryGtwkTotYn() {
        return this.eryGtwkTotYn;
    }
    
    public void setEryGtwkTotYn(java.lang.String eryGtwkTotYn) {
        this.eryGtwkTotYn = eryGtwkTotYn;
    }
    
    public java.lang.String getDilnlazDducPaySubtnYn() {
        return this.dilnlazDducPaySubtnYn;
    }
    
    public void setDilnlazDducPaySubtnYn(java.lang.String dilnlazDducPaySubtnYn) {
        this.dilnlazDducPaySubtnYn = dilnlazDducPaySubtnYn;
    }
    
    public java.lang.String getWklyHldyExtpyPrcsYn() {
        return this.wklyHldyExtpyPrcsYn;
    }
    
    public void setWklyHldyExtpyPrcsYn(java.lang.String wklyHldyExtpyPrcsYn) {
        this.wklyHldyExtpyPrcsYn = wklyHldyExtpyPrcsYn;
    }
    
    public java.lang.String getWkdyNorTmCttgDivCd() {
        return this.wkdyNorTmCttgDivCd;
    }
    
    public void setWkdyNorTmCttgDivCd(java.lang.String wkdyNorTmCttgDivCd) {
        this.wkdyNorTmCttgDivCd = wkdyNorTmCttgDivCd;
    }
    
    public java.lang.String getWkdyExtnnCttgDivCd() {
        return this.wkdyExtnnCttgDivCd;
    }
    
    public void setWkdyExtnnCttgDivCd(java.lang.String wkdyExtnnCttgDivCd) {
        this.wkdyExtnnCttgDivCd = wkdyExtnnCttgDivCd;
    }
    
    public java.lang.String getWkdyNgtCttgDivCd() {
        return this.wkdyNgtCttgDivCd;
    }
    
    public void setWkdyNgtCttgDivCd(java.lang.String wkdyNgtCttgDivCd) {
        this.wkdyNgtCttgDivCd = wkdyNgtCttgDivCd;
    }
    
    public java.lang.String getPubcHodyNorTmCttgCd() {
        return this.pubcHodyNorTmCttgCd;
    }
    
    public void setPubcHodyNorTmCttgCd(java.lang.String pubcHodyNorTmCttgCd) {
        this.pubcHodyNorTmCttgCd = pubcHodyNorTmCttgCd;
    }
    
    public java.lang.String getPubcHodyExtnnTmCttgCd() {
        return this.pubcHodyExtnnTmCttgCd;
    }
    
    public void setPubcHodyExtnnTmCttgCd(java.lang.String pubcHodyExtnnTmCttgCd) {
        this.pubcHodyExtnnTmCttgCd = pubcHodyExtnnTmCttgCd;
    }
    
    public java.lang.String getWkdyNorDutyMrkDivCd() {
        return this.wkdyNorDutyMrkDivCd;
    }
    
    public void setWkdyNorDutyMrkDivCd(java.lang.String wkdyNorDutyMrkDivCd) {
        this.wkdyNorDutyMrkDivCd = wkdyNorDutyMrkDivCd;
    }
    
    public java.lang.String getWkdyExtnnMrkDivCd() {
        return this.wkdyExtnnMrkDivCd;
    }
    
    public void setWkdyExtnnMrkDivCd(java.lang.String wkdyExtnnMrkDivCd) {
        this.wkdyExtnnMrkDivCd = wkdyExtnnMrkDivCd;
    }
    
    public java.lang.String getWkdyNgtMrkDivCd() {
        return this.wkdyNgtMrkDivCd;
    }
    
    public void setWkdyNgtMrkDivCd(java.lang.String wkdyNgtMrkDivCd) {
        this.wkdyNgtMrkDivCd = wkdyNgtMrkDivCd;
    }
    
    public java.lang.String getPubcHodyNorMrkDivCd() {
        return this.pubcHodyNorMrkDivCd;
    }
    
    public void setPubcHodyNorMrkDivCd(java.lang.String pubcHodyNorMrkDivCd) {
        this.pubcHodyNorMrkDivCd = pubcHodyNorMrkDivCd;
    }
    
    public java.lang.String getPubcHodyExtnnMrkCd() {
        return this.pubcHodyExtnnMrkCd;
    }
    
    public void setPubcHodyExtnnMrkCd(java.lang.String pubcHodyExtnnMrkCd) {
        this.pubcHodyExtnnMrkCd = pubcHodyExtnnMrkCd;
    }
    
    public java.lang.String getPubcHodyNgtMrkDivCd() {
        return this.pubcHodyNgtMrkDivCd;
    }
    
    public void setPubcHodyNgtMrkDivCd(java.lang.String pubcHodyNgtMrkDivCd) {
        this.pubcHodyNgtMrkDivCd = pubcHodyNgtMrkDivCd;
    }
    
    public java.math.BigDecimal getServcCommSeilNum() {
        return this.servcCommSeilNum;
    }
    
    public void setServcCommSeilNum(java.math.BigDecimal servcCommSeilNum) {
        this.servcCommSeilNum = servcCommSeilNum;
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
