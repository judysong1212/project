package com.app.exterms.retirement.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Remt2200VO.java
 * @Description : Remt2200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt2200DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
    private Long sevePayDtlPatrNum;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 수당그룹코드 : extpyGrpCd */
    private java.lang.String extpyGrpCd;

    /** set 퇴직금산정시간 : sevePayCmpttnTm */
    private java.lang.String sevePayCmpttnTm;

    /** set 지급금액 : pymtSum */
    private Long pymtSum;

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



    
    public java.lang.String getSevePayCmpttnTm() {
		return sevePayCmpttnTm;
	}

	public void setSevePayCmpttnTm(java.lang.String sevePayCmpttnTm) {
		this.sevePayCmpttnTm = sevePayCmpttnTm;
	}

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
    
    public java.lang.String getClutYrMnth() {
        return this.clutYrMnth;
    }
    
    public void setClutYrMnth(java.lang.String clutYrMnth) {
        this.clutYrMnth = clutYrMnth;
    }
    
    public java.lang.String getCalcSevePayPsnDivCd() {
        return this.calcSevePayPsnDivCd;
    }
    
    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
    }
    
    public Long getSevePayDtlPatrNum() {
        return this.sevePayDtlPatrNum;
    }
    
    public void setSevePayDtlPatrNum(Long sevePayDtlPatrNum) {
        this.sevePayDtlPatrNum = sevePayDtlPatrNum;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getExtpyGrpCd() {
        return this.extpyGrpCd;
    }
    
    public void setExtpyGrpCd(java.lang.String extpyGrpCd) {
        this.extpyGrpCd = extpyGrpCd;
    }
    
    public Long getPymtSum() {
        return this.pymtSum;
    }
    
    public void setPymtSum(Long pymtSum) {
        this.pymtSum = pymtSum;
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
