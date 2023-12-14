package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr6200VO.java
 * @Description : Insr6200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr6200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
	/** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;

    
    /** IDTL_ACCDT_INSUR_CLUT_YR */
    private java.lang.String idtlAccdtInsurClutYr;
    
    /** PRMM_IPOS_DIV_CD */
    private java.lang.String prmmIposDivCd;
    
    /** IDTL_ACCDT_INSUR_AQTN_DT */
    private java.lang.String idtlAccdtInsurAqtnDt;
    
    /** IDTL_ACCDT_INSUR_LSS_DT */
    private java.lang.String idtlAccdtInsurLssDt;
    
    /** IDTL_ACCDT_PAY_TOT_AMNT */
    private java.math.BigDecimal idtlAccdtPayTotAmnt;
    
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

	public java.lang.String getIdtlAccdtInsurClutYr() {
        return this.idtlAccdtInsurClutYr;
    }
    
    public void setIdtlAccdtInsurClutYr(java.lang.String idtlAccdtInsurClutYr) {
        this.idtlAccdtInsurClutYr = idtlAccdtInsurClutYr;
    }
    
    public java.lang.String getPrmmIposDivCd() {
        return this.prmmIposDivCd;
    }
    
    public void setPrmmIposDivCd(java.lang.String prmmIposDivCd) {
        this.prmmIposDivCd = prmmIposDivCd;
    }
    
    public java.lang.String getIdtlAccdtInsurAqtnDt() {
        return this.idtlAccdtInsurAqtnDt;
    }
    
    public void setIdtlAccdtInsurAqtnDt(java.lang.String idtlAccdtInsurAqtnDt) {
        this.idtlAccdtInsurAqtnDt = idtlAccdtInsurAqtnDt;
    }
    
    public java.lang.String getIdtlAccdtInsurLssDt() {
        return this.idtlAccdtInsurLssDt;
    }
    
    public void setIdtlAccdtInsurLssDt(java.lang.String idtlAccdtInsurLssDt) {
        this.idtlAccdtInsurLssDt = idtlAccdtInsurLssDt;
    }
    
    public java.math.BigDecimal getIdtlAccdtPayTotAmnt() {
        return this.idtlAccdtPayTotAmnt;
    }
    
    public void setIdtlAccdtPayTotAmnt(java.math.BigDecimal idtlAccdtPayTotAmnt) {
        this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
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
