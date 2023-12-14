package com.app.exterms.insurance.client.dto;

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
public class Insr6200DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum; 

	/** set 산재보험정산년도 : idtlAccdtInsurClutYr */
	private java.lang.String idtlAccdtInsurClutYr;

	/** set 보험료부과구분코드 : prmmIposDivCd */
	private java.lang.String prmmIposDivCd;

	/** set 산재보험취득일자 : idtlAccdtInsurAqtnDt */
	private java.lang.String idtlAccdtInsurAqtnDt;

	/** set 산재보험상실일자 : idtlAccdtInsurLssDt */
	private java.lang.String idtlAccdtInsurLssDt;

	/** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
	private java.math.BigDecimal idtlAccdtPayTotAmnt;

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
