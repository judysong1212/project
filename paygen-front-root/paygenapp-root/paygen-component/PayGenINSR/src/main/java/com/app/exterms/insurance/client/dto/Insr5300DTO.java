package com.app.exterms.insurance.client.dto;

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
public class Insr5300DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum; 

	/** set 고용보험정산년도 : umytInsrClutYr */
	private java.lang.String umytInsrClutYr;

	/** set 보험료부과구분코드 : prmmIposDivCd */
	private java.lang.String prmmIposDivCd;

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	private java.lang.String umytInsrAqtnDt;

	/** set 고용보험상실일자 : umytInsrLssDt */
	private java.lang.String umytInsrLssDt;

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	private java.math.BigDecimal umytInsrPayTotAmnt;

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
