package com.app.exterms.retirement.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Remt3200VO.java
 * @Description : Remt3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3200DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    private java.lang.String calcSevePsnBlggYrMnth;
    
    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 연금계좌일련번호 : antyAccuSeilNum */
    private Long antyAccuSeilNum;

    /** set 연금계좌_사업자등록번호 : antyAccuBusoprNum */
    private java.lang.String antyAccuBusoprNum;

    /** set 연금계좌_사업자명 : antyAccuBusoprNm */
    private java.lang.String antyAccuBusoprNm;

    /** set 연금계좌_계좌번호 : antyAccuAccuNum */
    private java.lang.String antyAccuAccuNum;

    /** set 연금계좌_입금금액 : antyAccuDepitSum */
    private Long antyAccuDepitSum;

    /** set 연금계좌_입금일자 : antyAccuDepitDt */
    private java.lang.String antyAccuDepitDt;

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
    


    
    public java.lang.String getClutYrMnth() {
		return clutYrMnth;
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
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public Long getAntyAccuSeilNum() {
        return this.antyAccuSeilNum;
    }
    
    public void setAntyAccuSeilNum(Long antyAccuSeilNum) {
        this.antyAccuSeilNum = antyAccuSeilNum;
    }
    
    public java.lang.String getAntyAccuBusoprNum() {
        return this.antyAccuBusoprNum;
    }
    
    public void setAntyAccuBusoprNum(java.lang.String antyAccuBusoprNum) {
        this.antyAccuBusoprNum = antyAccuBusoprNum;
    }
    
    public java.lang.String getAntyAccuBusoprNm() {
        return this.antyAccuBusoprNm;
    }
    
    public void setAntyAccuBusoprNm(java.lang.String antyAccuBusoprNm) {
        this.antyAccuBusoprNm = antyAccuBusoprNm;
    }
    
    public java.lang.String getAntyAccuAccuNum() {
        return this.antyAccuAccuNum;
    }
    
    public void setAntyAccuAccuNum(java.lang.String antyAccuAccuNum) {
        this.antyAccuAccuNum = antyAccuAccuNum;
    }
    
    public Long getAntyAccuDepitSum() {
        return this.antyAccuDepitSum;
    }
    
    public void setAntyAccuDepitSum(Long antyAccuDepitSum) {
        this.antyAccuDepitSum = antyAccuDepitSum;
    }
    
    public java.lang.String getAntyAccuDepitDt() {
        return this.antyAccuDepitDt;
    }
    
    public void setAntyAccuDepitDt(java.lang.String antyAccuDepitDt) {
        this.antyAccuDepitDt = antyAccuDepitDt;
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
