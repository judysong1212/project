package com.app.smrmf.infc.yearendtax.server.vo.yeta2018;

import java.io.Serializable;

/**
 * @Class Name : Ye165030VO.java
 * @Description : Ye165030 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe165030_2018_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 기부금조정일련번호 : conbSeilNum */
    private java.math.BigDecimal conbSeilNum;

    /** set 기부금유형구분코드 : conbCddl */
    private java.lang.String conbCddl;

    /** set 기부년도 : attrYr */
    private java.lang.String attrYr;

    /** set 기부금액 : useAmt */
    private java.math.BigDecimal useAmt;

    /** set 전년도공제된금액 : pyrDdcAmt */
    private java.math.BigDecimal pyrDdcAmt;

    /** set 기부금공제대상금액 : ddcTrgtAmt */
    private java.math.BigDecimal ddcTrgtAmt;

    /** set 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
    private java.math.BigDecimal thcYrDdcAmtNdXps;

    /** set 해당연도공제금액세액공제금액 : thcYrDdcAmt */
    private java.math.BigDecimal thcYrDdcAmt;

    /** set 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
    private java.math.BigDecimal thcYrNducExtnAmt;

    /** set 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
    private java.math.BigDecimal thcYrNducCrfwAmt;

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

    /** set 기부금유형신고코드 : ctrbTycd */
    private java.lang.String ctrbTycd;

    /* 방어로직추가 */
    private java.lang.String tgtCheck;
    /* 방어로직추가 */

	private java.lang.String spciDdctCheck;
	 
    
    /**
	 * Comment : 
	 * @fn java.lang.String getSpciDdctCheck()
	 * @brief date:2018 2018. 3. 9. user:atres
	 * @return the spciDdctCheck get
	 */
	public java.lang.String getSpciDdctCheck() {
		return spciDdctCheck;
	}

	/**
	 * Comment : 
	 *@fn void setSpciDdctCheck(java.lang.String spciDdctCheck)
	 *@brief date:2018 2018. 3. 9. user:atres
	 *@param spciDdctCheck the spciDdctCheck to set
	 */
	public void setSpciDdctCheck(java.lang.String spciDdctCheck) {
		this.spciDdctCheck = spciDdctCheck;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTgtCheck()
	 * @brief date:2018 2018. 3. 2. user:atres
	 * @return the tgtCheck get
	 */
	public java.lang.String getTgtCheck() {
		return tgtCheck;
	}

	/**
	 * Comment : 
	 *@fn void setTgtCheck(java.lang.String tgtCheck)
	 *@brief date:2018 2018. 3. 2. user:atres
	 *@param tgtCheck the tgtCheck to set
	 */
	public void setTgtCheck(java.lang.String tgtCheck) {
		this.tgtCheck = tgtCheck;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getYrtxBlggYr() {
        return this.yrtxBlggYr;
    }
    
    public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
        this.yrtxBlggYr = yrtxBlggYr;
    }
    
    public java.lang.String getClutSeptCd() {
        return this.clutSeptCd;
    }
    
    public void setClutSeptCd(java.lang.String clutSeptCd) {
        this.clutSeptCd = clutSeptCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.math.BigDecimal getConbSeilNum() {
        return this.conbSeilNum;
    }
    
    public void setConbSeilNum(java.math.BigDecimal conbSeilNum) {
        this.conbSeilNum = conbSeilNum;
    }
    
    public java.lang.String getConbCddl() {
        return this.conbCddl;
    }
    
    public void setConbCddl(java.lang.String conbCddl) {
        this.conbCddl = conbCddl;
    }
    
    public java.lang.String getAttrYr() {
        return this.attrYr;
    }
    
    public void setAttrYr(java.lang.String attrYr) {
        this.attrYr = attrYr;
    }
    
    public java.math.BigDecimal getUseAmt() {
        return this.useAmt;
    }
    
    public void setUseAmt(java.math.BigDecimal useAmt) {
        this.useAmt = useAmt;
    }
    
    public java.math.BigDecimal getPyrDdcAmt() {
        return this.pyrDdcAmt;
    }
    
    public void setPyrDdcAmt(java.math.BigDecimal pyrDdcAmt) {
        this.pyrDdcAmt = pyrDdcAmt;
    }
    
    public java.math.BigDecimal getDdcTrgtAmt() {
        return this.ddcTrgtAmt;
    }
    
    public void setDdcTrgtAmt(java.math.BigDecimal ddcTrgtAmt) {
        this.ddcTrgtAmt = ddcTrgtAmt;
    }
    
    public java.math.BigDecimal getThcYrDdcAmtNdXps() {
        return this.thcYrDdcAmtNdXps;
    }
    
    public void setThcYrDdcAmtNdXps(java.math.BigDecimal thcYrDdcAmtNdXps) {
        this.thcYrDdcAmtNdXps = thcYrDdcAmtNdXps;
    }
    
    public java.math.BigDecimal getThcYrDdcAmt() {
        return this.thcYrDdcAmt;
    }
    
    public void setThcYrDdcAmt(java.math.BigDecimal thcYrDdcAmt) {
        this.thcYrDdcAmt = thcYrDdcAmt;
    }
    
    public java.math.BigDecimal getThcYrNducExtnAmt() {
        return this.thcYrNducExtnAmt;
    }
    
    public void setThcYrNducExtnAmt(java.math.BigDecimal thcYrNducExtnAmt) {
        this.thcYrNducExtnAmt = thcYrNducExtnAmt;
    }
    
    public java.math.BigDecimal getThcYrNducCrfwAmt() {
        return this.thcYrNducCrfwAmt;
    }
    
    public void setThcYrNducCrfwAmt(java.math.BigDecimal thcYrNducCrfwAmt) {
        this.thcYrNducCrfwAmt = thcYrNducCrfwAmt;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getCtrbTycd()
	 * @brief date:2018 2018. 2. 2. user:atres
	 * @return the ctrbTycd get
	 */
	public java.lang.String getCtrbTycd() {
		return ctrbTycd;
	}

	/**
	 * Comment : 
	 *@fn void setCtrbTycd(java.lang.String ctrbTycd)
	 *@brief date:2018 2018. 2. 2. user:atres
	 *@param ctrbTycd the ctrbTycd to set
	 */
	public void setCtrbTycd(java.lang.String ctrbTycd) {
		this.ctrbTycd = ctrbTycd;
	}
    
    
}
