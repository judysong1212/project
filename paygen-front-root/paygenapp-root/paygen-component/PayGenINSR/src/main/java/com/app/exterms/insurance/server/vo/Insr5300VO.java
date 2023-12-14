package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr5300VO.java
 * @Description : Insr5300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5300VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;
    
    /** UMYT_INSR_CLUT_YR */
    private java.lang.String umytInsrClutYr;
    
    /** PRMM_IPOS_DIV_CD */
    private java.lang.String prmmIposDivCd;
    
    /** UMYT_INSR_AQTN_DT */
    private java.lang.String umytInsrAqtnDt;
    
    /** UMYT_INSR_LSS_DT */
    private java.lang.String umytInsrLssDt;
    
    /** UMYT_INSR_PAY_TOT_AMNT */
    private java.math.BigDecimal umytInsrPayTotAmnt;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
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
    
     
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 27. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 27. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public java.lang.String getUmytInsrClutYr() {
        return this.umytInsrClutYr;
    }
    
    public void setUmytInsrClutYr(java.lang.String umytInsrClutYr) {
        this.umytInsrClutYr = umytInsrClutYr;
    }
    
    public java.lang.String getPrmmIposDivCd() {
        return this.prmmIposDivCd;
    }
    
    public void setPrmmIposDivCd(java.lang.String prmmIposDivCd) {
        this.prmmIposDivCd = prmmIposDivCd;
    }
    
    public java.lang.String getUmytInsrAqtnDt() {
        return this.umytInsrAqtnDt;
    }
    
    public void setUmytInsrAqtnDt(java.lang.String umytInsrAqtnDt) {
        this.umytInsrAqtnDt = umytInsrAqtnDt;
    }
    
    public java.lang.String getUmytInsrLssDt() {
        return this.umytInsrLssDt;
    }
    
    public void setUmytInsrLssDt(java.lang.String umytInsrLssDt) {
        this.umytInsrLssDt = umytInsrLssDt;
    }
    
    public java.math.BigDecimal getUmytInsrPayTotAmnt() {
        return this.umytInsrPayTotAmnt;
    }
    
    public void setUmytInsrPayTotAmnt(java.math.BigDecimal umytInsrPayTotAmnt) {
        this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
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
