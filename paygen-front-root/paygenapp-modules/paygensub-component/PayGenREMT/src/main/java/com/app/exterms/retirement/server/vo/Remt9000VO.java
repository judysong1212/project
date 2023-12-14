package com.app.exterms.retirement.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Remt9000VO.java
 * @Description : Remt9000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt9000VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    private java.lang.String sevePayClutMangeNum;

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    private java.lang.String calcSevePayPsnBlggYr;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;
    
    // Psnl0100 
    /** set 이름 : hanNm */
    private java.lang.String hanNm;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;
    // Psnl0100 

    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;

    /** set 기산일자 : rkfcdDt */
    private java.lang.String rkfcdDt;

    /** set 퇴사일자 : rsgtnDt */
    private java.lang.String rsgtnDt;

    /** set 지급일자 : pymtDt */
    private java.lang.String pymtDt;

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    private java.math.BigDecimal eepnMnthIcm2012Bfr;

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    private java.math.BigDecimal eepnMnthIcm2013Aft;

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    private java.math.BigDecimal addMnthIcm2012Bfr;

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    private java.math.BigDecimal addMnthIcm2013Aft;

    /** set 퇴직급여액 : retryPayQnty */
    private java.math.BigDecimal retryPayQnty;

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    private java.math.BigDecimal freeDtyRetryPayQnty;

    /** set 기납부소득세 : alpayTxAmnt */
    private java.math.BigDecimal alpayTxAmnt;

    /** set 지방소득세 : locIncmTxAmt */
    private java.math.BigDecimal locIncmTxAmt;

    /** set 차인지급액 : pernPymtSum */
    private java.math.BigDecimal pernPymtSum;

    /** set 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
    private java.lang.String sevePayCtrClutNoteCtnt;

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
    

/** set 군경력정산포함여부 : amcrrClutInsnYn */
private java.lang.String amcrrClutInsnYn;

private java.lang.String juminCk;


    
    public java.lang.String getAmcrrClutInsnYn() {
	return amcrrClutInsnYn;
}

public void setAmcrrClutInsnYn(java.lang.String amcrrClutInsnYn) {
	this.amcrrClutInsnYn = amcrrClutInsnYn;
}

	public java.math.BigDecimal getLocIncmTxAmt() {
		return locIncmTxAmt;
	}

	public void setLocIncmTxAmt(java.math.BigDecimal locIncmTxAmt) {
		this.locIncmTxAmt = locIncmTxAmt;
	}

	public java.math.BigDecimal getPernPymtSum() {
		return pernPymtSum;
	}

	public void setPernPymtSum(java.math.BigDecimal pernPymtSum) {
		this.pernPymtSum = pernPymtSum;
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
    
    public java.lang.String getSevePayClutMangeNum() {
        return this.sevePayClutMangeNum;
    }
    
    public void setSevePayClutMangeNum(java.lang.String sevePayClutMangeNum) {
        this.sevePayClutMangeNum = sevePayClutMangeNum;
    }
    
    public java.lang.String getCalcSevePayPsnBlggYr() {
        return this.calcSevePayPsnBlggYr;
    }
    
    public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
        this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
    }
    
    public java.lang.String getCalcSevePayPsnDivCd() {
        return this.calcSevePayPsnDivCd;
    }
    
    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
    }
    
    public java.lang.String getIcncDt() {
        return this.icncDt;
    }
    
    public void setIcncDt(java.lang.String icncDt) {
        this.icncDt = icncDt;
    }
    
    public java.lang.String getRkfcdDt() {
        return this.rkfcdDt;
    }
    
    public void setRkfcdDt(java.lang.String rkfcdDt) {
        this.rkfcdDt = rkfcdDt;
    }
    
    public java.lang.String getRsgtnDt() {
        return this.rsgtnDt;
    }
    
    public void setRsgtnDt(java.lang.String rsgtnDt) {
        this.rsgtnDt = rsgtnDt;
    }
    
    public java.lang.String getPymtDt() {
        return this.pymtDt;
    }
    
    public void setPymtDt(java.lang.String pymtDt) {
        this.pymtDt = pymtDt;
    }
    
    public java.math.BigDecimal getEepnMnthIcm2012Bfr() {
        return this.eepnMnthIcm2012Bfr;
    }
    
    public void setEepnMnthIcm2012Bfr(java.math.BigDecimal eepnMnthIcm2012Bfr) {
        this.eepnMnthIcm2012Bfr = eepnMnthIcm2012Bfr;
    }
    
    public java.math.BigDecimal getEepnMnthIcm2013Aft() {
        return this.eepnMnthIcm2013Aft;
    }
    
    public void setEepnMnthIcm2013Aft(java.math.BigDecimal eepnMnthIcm2013Aft) {
        this.eepnMnthIcm2013Aft = eepnMnthIcm2013Aft;
    }
    
    public java.math.BigDecimal getAddMnthIcm2012Bfr() {
        return this.addMnthIcm2012Bfr;
    }
    
    public void setAddMnthIcm2012Bfr(java.math.BigDecimal addMnthIcm2012Bfr) {
        this.addMnthIcm2012Bfr = addMnthIcm2012Bfr;
    }
    
    public java.math.BigDecimal getAddMnthIcm2013Aft() {
        return this.addMnthIcm2013Aft;
    }
    
    public void setAddMnthIcm2013Aft(java.math.BigDecimal addMnthIcm2013Aft) {
        this.addMnthIcm2013Aft = addMnthIcm2013Aft;
    }
    
    public java.math.BigDecimal getRetryPayQnty() {
        return this.retryPayQnty;
    }
    
    public void setRetryPayQnty(java.math.BigDecimal retryPayQnty) {
        this.retryPayQnty = retryPayQnty;
    }
    
    public java.math.BigDecimal getFreeDtyRetryPayQnty() {
        return this.freeDtyRetryPayQnty;
    }
    
    public void setFreeDtyRetryPayQnty(java.math.BigDecimal freeDtyRetryPayQnty) {
        this.freeDtyRetryPayQnty = freeDtyRetryPayQnty;
    }
    
    public java.math.BigDecimal getAlpayTxAmnt() {
        return this.alpayTxAmnt;
    }
    
    public void setAlpayTxAmnt(java.math.BigDecimal alpayTxAmnt) {
        this.alpayTxAmnt = alpayTxAmnt;
    }
    
    public java.lang.String getSevePayCtrClutNoteCtnt() {
        return this.sevePayCtrClutNoteCtnt;
    }
    
    public void setSevePayCtrClutNoteCtnt(java.lang.String sevePayCtrClutNoteCtnt) {
        this.sevePayCtrClutNoteCtnt = sevePayCtrClutNoteCtnt;
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

    // Psnl0100 
	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}


	// Psnl0100 
}
