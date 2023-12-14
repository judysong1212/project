package com.app.smrmf.infc.yearendtax.server.vo.yeta2017;

import java.io.Serializable;

/**
 * @Class Name : Ye161050VO.java
 * @Description : Ye161050 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe161050VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 국민연금보험료_종근무지보험료금액 : npHthrWaInfeeAmt */
    private java.math.BigDecimal npHthrWaInfeeAmt;

    /** set 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
    private java.math.BigDecimal npHthrWaInfeeDdcAmt;

    /** set 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
    private java.math.BigDecimal npHthrMcurWkarInfeeAmt;

    /** set 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
    private java.math.BigDecimal npHthrMcurWkarDdcAmt;

    /** set 국민연금보험료_지역보험료금액 : npHthrAreaInfeeAmt */
    private java.math.BigDecimal npHthrAreaInfeeAmt;

    /** set 국민연금보험료-지역보험료공제액 : npHthrAreaDdcAmt */
    private java.math.BigDecimal npHthrAreaDdcAmt;

    /** set 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
    private java.math.BigDecimal hthrPblcPnsnInfeeAmt;

    /** set 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
    private java.math.BigDecimal hthrPblcPnsnInfeeDdcAmt;

    /** set 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
    private java.math.BigDecimal mcurPblcPnsnInfeeAmt;

    /** set 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
    private java.math.BigDecimal mcurPblcPnsnInfeeDdcAmt;

    /** set 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
    private java.math.BigDecimal pnsnInfeeUseAmtSum;

    /** set 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
    private java.math.BigDecimal pnsnInfeeDdcAmtSum;

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
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.math.BigDecimal getNpHthrWaInfeeAmt() {
		return npHthrWaInfeeAmt;
	}

	public void setNpHthrWaInfeeAmt(java.math.BigDecimal npHthrWaInfeeAmt) {
		this.npHthrWaInfeeAmt = npHthrWaInfeeAmt;
	}

	public java.math.BigDecimal getNpHthrWaInfeeDdcAmt() {
		return npHthrWaInfeeDdcAmt;
	}

	public void setNpHthrWaInfeeDdcAmt(java.math.BigDecimal npHthrWaInfeeDdcAmt) {
		this.npHthrWaInfeeDdcAmt = npHthrWaInfeeDdcAmt;
	}

	public java.math.BigDecimal getNpHthrMcurWkarInfeeAmt() {
		return npHthrMcurWkarInfeeAmt;
	}

	public void setNpHthrMcurWkarInfeeAmt(
			java.math.BigDecimal npHthrMcurWkarInfeeAmt) {
		this.npHthrMcurWkarInfeeAmt = npHthrMcurWkarInfeeAmt;
	}

	public java.math.BigDecimal getNpHthrMcurWkarDdcAmt() {
		return npHthrMcurWkarDdcAmt;
	}

	public void setNpHthrMcurWkarDdcAmt(java.math.BigDecimal npHthrMcurWkarDdcAmt) {
		this.npHthrMcurWkarDdcAmt = npHthrMcurWkarDdcAmt;
	}

	public java.math.BigDecimal getNpHthrAreaInfeeAmt() {
		return npHthrAreaInfeeAmt;
	}

	public void setNpHthrAreaInfeeAmt(java.math.BigDecimal npHthrAreaInfeeAmt) {
		this.npHthrAreaInfeeAmt = npHthrAreaInfeeAmt;
	}

	public java.math.BigDecimal getNpHthrAreaDdcAmt() {
		return npHthrAreaDdcAmt;
	}

	public void setNpHthrAreaDdcAmt(java.math.BigDecimal npHthrAreaDdcAmt) {
		this.npHthrAreaDdcAmt = npHthrAreaDdcAmt;
	}

	public java.math.BigDecimal getHthrPblcPnsnInfeeAmt() {
		return hthrPblcPnsnInfeeAmt;
	}

	public void setHthrPblcPnsnInfeeAmt(java.math.BigDecimal hthrPblcPnsnInfeeAmt) {
		this.hthrPblcPnsnInfeeAmt = hthrPblcPnsnInfeeAmt;
	}

	public java.math.BigDecimal getHthrPblcPnsnInfeeDdcAmt() {
		return hthrPblcPnsnInfeeDdcAmt;
	}

	public void setHthrPblcPnsnInfeeDdcAmt(
			java.math.BigDecimal hthrPblcPnsnInfeeDdcAmt) {
		this.hthrPblcPnsnInfeeDdcAmt = hthrPblcPnsnInfeeDdcAmt;
	}

	public java.math.BigDecimal getMcurPblcPnsnInfeeAmt() {
		return mcurPblcPnsnInfeeAmt;
	}

	public void setMcurPblcPnsnInfeeAmt(java.math.BigDecimal mcurPblcPnsnInfeeAmt) {
		this.mcurPblcPnsnInfeeAmt = mcurPblcPnsnInfeeAmt;
	}

	public java.math.BigDecimal getMcurPblcPnsnInfeeDdcAmt() {
		return mcurPblcPnsnInfeeDdcAmt;
	}

	public void setMcurPblcPnsnInfeeDdcAmt(
			java.math.BigDecimal mcurPblcPnsnInfeeDdcAmt) {
		this.mcurPblcPnsnInfeeDdcAmt = mcurPblcPnsnInfeeDdcAmt;
	}

	public java.math.BigDecimal getPnsnInfeeUseAmtSum() {
		return pnsnInfeeUseAmtSum;
	}

	public void setPnsnInfeeUseAmtSum(java.math.BigDecimal pnsnInfeeUseAmtSum) {
		this.pnsnInfeeUseAmtSum = pnsnInfeeUseAmtSum;
	}

	public java.math.BigDecimal getPnsnInfeeDdcAmtSum() {
		return pnsnInfeeDdcAmtSum;
	}

	public void setPnsnInfeeDdcAmtSum(java.math.BigDecimal pnsnInfeeDdcAmtSum) {
		this.pnsnInfeeDdcAmtSum = pnsnInfeeDdcAmtSum;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

    
    
}
