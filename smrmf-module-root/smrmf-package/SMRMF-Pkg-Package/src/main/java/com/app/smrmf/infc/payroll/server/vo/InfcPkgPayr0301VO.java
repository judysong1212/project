package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0301VO.java
 * @Description : Payr0301 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0301VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여일련번호 : payrSeilNum */
    private java.math.BigDecimal payrSeilNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 지급총액 : pymtTotAmnt */
    private java.math.BigDecimal pymtTotAmnt;

    /** set 수당총액 : extpyTotAmnt */
    private java.math.BigDecimal extpyTotAmnt;

    /** set 과세총액 : txtnTotAmnt */
    private java.math.BigDecimal txtnTotAmnt;

    /** set 비과세총액 : freeDtyTotAmnt */
    private java.math.BigDecimal freeDtyTotAmnt;

    /** set 공제총액 : dducTotAmnt */
    private java.math.BigDecimal dducTotAmnt;

    /** set 세금총액 : txTotAmnt */
    private java.math.BigDecimal txTotAmnt;

    /** set 퇴직금지급여부 : sevePayPymtYn */
    private java.lang.String sevePayPymtYn;

    /** set 차인지급액 : pernPymtSum */
    private java.math.BigDecimal pernPymtSum;

    /** set 소득세징수비율 : incmTxCllnRto */
    private java.math.BigDecimal incmTxCllnRto;

    /** set 은행코드 : bnkCd */
    private java.lang.String bnkCd;

    /** set 은행계좌번호 : bnkAccuNum */
    private java.lang.String bnkAccuNum;

    /** set 예금주명 : acntHodrNm */
    private java.lang.String acntHodrNm;

    /** set 급여마감일자 : payDdlneDt */
    private java.lang.String payDdlneDt;

    /** set 급여마감여부 : payDdlneYn */
    private java.lang.String payDdlneYn;

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

     
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd = "";
     
    
    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getPymtYrMnth() {
        return this.pymtYrMnth;
    }
    
    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public BigDecimal getPayrSeilNum() {
        return this.payrSeilNum;
    }
    
    public void setPayrSeilNum(BigDecimal payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }
    
    public BigDecimal getPymtTotAmnt() {
        return this.pymtTotAmnt;
    }
    
    public void setPymtTotAmnt(BigDecimal pymtTotAmnt) {
        this.pymtTotAmnt = pymtTotAmnt;
    }
    
    public BigDecimal getExtpyTotAmnt() {
        return this.extpyTotAmnt;
    }
    
    public void setExtpyTotAmnt(BigDecimal extpyTotAmnt) {
        this.extpyTotAmnt = extpyTotAmnt;
    }
    
    public BigDecimal getTxtnTotAmnt() {
        return this.txtnTotAmnt;
    }
    
    public void setTxtnTotAmnt(BigDecimal txtnTotAmnt) {
        this.txtnTotAmnt = txtnTotAmnt;
    }
    
    public BigDecimal getFreeDtyTotAmnt() {
        return this.freeDtyTotAmnt;
    }
    
    public void setFreeDtyTotAmnt(BigDecimal freeDtyTotAmnt) {
        this.freeDtyTotAmnt = freeDtyTotAmnt;
    }
    
    public BigDecimal getDducTotAmnt() {
        return this.dducTotAmnt;
    }
    
    public void setDducTotAmnt(BigDecimal dducTotAmnt) {
        this.dducTotAmnt = dducTotAmnt;
    }
    
    public BigDecimal getTxTotAmnt() {
        return this.txTotAmnt;
    }
    
    public void setTxTotAmnt(BigDecimal txTotAmnt) {
        this.txTotAmnt = txTotAmnt;
    }
    
    public java.lang.String getSevePayPymtYn() {
        return this.sevePayPymtYn;
    }
    
    public void setSevePayPymtYn(java.lang.String sevePayPymtYn) {
        this.sevePayPymtYn = sevePayPymtYn;
    }
    
    public BigDecimal getPernPymtSum() {
        return this.pernPymtSum;
    }
    
    public void setPernPymtSum(BigDecimal pernPymtSum) {
        this.pernPymtSum = pernPymtSum;
    }
    
    public BigDecimal getIncmTxCllnRto() {
        return this.incmTxCllnRto;
    }
    
    public void setIncmTxCllnRto(BigDecimal incmTxCllnRto) {
        this.incmTxCllnRto = incmTxCllnRto;
    }
    
    public java.lang.String getBnkCd() {
        return this.bnkCd;
    }
    
    public void setBnkCd(java.lang.String bnkCd) {
        this.bnkCd = bnkCd;
    }
    
    public java.lang.String getBnkAccuNum() {
        return this.bnkAccuNum;
    }
    
    public void setBnkAccuNum(java.lang.String bnkAccuNum) {
        this.bnkAccuNum = bnkAccuNum;
    }
    
    public java.lang.String getAcntHodrNm() {
        return this.acntHodrNm;
    }
    
    public void setAcntHodrNm(java.lang.String acntHodrNm) {
        this.acntHodrNm = acntHodrNm;
    }
    
    public java.lang.String getPayDdlneDt() {
        return this.payDdlneDt;
    }
    
    public void setPayDdlneDt(java.lang.String payDdlneDt) {
        this.payDdlneDt = payDdlneDt;
    }
    
    public java.lang.String getPayDdlneYn() {
        return this.payDdlneYn;
    }
    
    public void setPayDdlneYn(java.lang.String payDdlneYn) {
        this.payDdlneYn = payDdlneYn;
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
