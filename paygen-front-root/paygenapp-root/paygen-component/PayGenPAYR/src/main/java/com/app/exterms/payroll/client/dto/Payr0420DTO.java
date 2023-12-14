package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0420VO.java
 * @Description : Payr0420 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0420DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private Long typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private Long payrItemSeilNum;

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    private java.lang.String occuClssPayCmpttnStd;

    /** set 급여산식계산구분코드 : payArithExprCalcDivCd */
    private java.lang.String payArithExprCalcDivCd;

    /** set 산식산정지급항목코드 : arithExprCmpttnPymtItemCd */
    private java.lang.String arithExprCmpttnPymtItemCd;

    /** set 산식산정비율 : arithExprCmpttnRto */
    private Double arithExprCmpttnRto;

    /** set 산식산정금액 : arithExprCmpttnSum */
    private Long arithExprCmpttnSum;

    /** set 통상임금여부 : usalyAmntYn */
    private Boolean usalyAmntYn;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 산정기준비고내용 : cmpttnStdNoteCtnt */
    private java.lang.String cmpttnStdNoteCtnt;

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

     
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
     
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
  
     
    
    public Long getTypOccuGrdeMppgSeilNum() {
        return typOccuGrdeMppgSeilNum;
    }

    public void setTypOccuGrdeMppgSeilNum(Long typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }

    public Long getPayrItemSeilNum() {
        return payrItemSeilNum;
    }

    public void setPayrItemSeilNum(Long payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getOccuClssPayCmpttnStd() {
        return this.occuClssPayCmpttnStd;
    }
    
    public void setOccuClssPayCmpttnStd(java.lang.String occuClssPayCmpttnStd) {
        this.occuClssPayCmpttnStd = occuClssPayCmpttnStd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getPayArithExprCalcDivCd() {
        return this.payArithExprCalcDivCd;
    }
    
    public void setPayArithExprCalcDivCd(java.lang.String payArithExprCalcDivCd) {
        this.payArithExprCalcDivCd = payArithExprCalcDivCd;
    }
    
    public java.lang.String getArithExprCmpttnPymtItemCd() {
        return this.arithExprCmpttnPymtItemCd;
    }
    
    public void setArithExprCmpttnPymtItemCd(java.lang.String arithExprCmpttnPymtItemCd) {
        this.arithExprCmpttnPymtItemCd = arithExprCmpttnPymtItemCd;
    }
     
    public Double getArithExprCmpttnRto() {
        return arithExprCmpttnRto;
    }

    public void setArithExprCmpttnRto(Double arithExprCmpttnRto) {
        this.arithExprCmpttnRto = arithExprCmpttnRto;
    }

    public Long getArithExprCmpttnSum() {
        return arithExprCmpttnSum;
    }

    public void setArithExprCmpttnSum(Long arithExprCmpttnSum) {
        this.arithExprCmpttnSum = arithExprCmpttnSum;
    }

    public Boolean getUsalyAmntYn() {
        return usalyAmntYn;
    }

    public void setUsalyAmntYn(Boolean usalyAmntYn) {
        this.usalyAmntYn = usalyAmntYn;
    }

    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getCmpttnStdNoteCtnt() {
        return this.cmpttnStdNoteCtnt;
    }
    
    public void setCmpttnStdNoteCtnt(java.lang.String cmpttnStdNoteCtnt) {
        this.cmpttnStdNoteCtnt = cmpttnStdNoteCtnt;
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
