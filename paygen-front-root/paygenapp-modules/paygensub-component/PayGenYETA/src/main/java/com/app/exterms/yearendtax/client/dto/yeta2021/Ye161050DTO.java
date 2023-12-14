package com.app.exterms.yearendtax.client.dto.yeta2021;

import java.io.Serializable;


/**
 * @Class Name : Ye161050DTO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161050DTO   implements Serializable {
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
    private Long npHthrWaInfeeAmt;

    /** set 국민연금보험료_종근무지보험료공제액 : npHthrWaInfeeDdcAmt */
    private Long npHthrWaInfeeDdcAmt;

    /** set 국민연금보험료_주근무지보험료금액 : npHthrMcurWkarInfeeAmt */
    private Long npHthrMcurWkarInfeeAmt;

    /** set 국민연금보험료_주근무지보험료공제액 : npHthrMcurWkarDdcAmt */
    private Long npHthrMcurWkarDdcAmt;

    /** set 국민연금보험료외_공적연금종근무지보험료금액 : hthrPblcPnsnInfeeAmt */
    private Long hthrPblcPnsnInfeeAmt;

    /** set 국민연금보험료외_공적연금종근무지보험료공제액 : hthrPblcPnsnInfeeDdcAmt */
    private Long hthrPblcPnsnInfeeDdcAmt;

    /** set 국민연금보험료외_공적연금주근무지보험료금액 : mcurPblcPnsnInfeeAmt */
    private Long mcurPblcPnsnInfeeAmt;

    /** set 국민연금보험료외_공적연금주근무지보험료공제액 : mcurPblcPnsnInfeeDdcAmt */
    private Long mcurPblcPnsnInfeeDdcAmt;

    /** set 연금보험료보험료합계 : pnsnInfeeUseAmtSum */
    private Long pnsnInfeeUseAmtSum;

    /** set 연금보험료공제액합계 : pnsnInfeeDdcAmtSum */
    private Long pnsnInfeeDdcAmtSum;

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

	public Long getNpHthrWaInfeeAmt() {
		return npHthrWaInfeeAmt;
	}

	public void setNpHthrWaInfeeAmt(Long npHthrWaInfeeAmt) {
		this.npHthrWaInfeeAmt = npHthrWaInfeeAmt;
	}

	public Long getNpHthrWaInfeeDdcAmt() {
		return npHthrWaInfeeDdcAmt;
	}

	public void setNpHthrWaInfeeDdcAmt(Long npHthrWaInfeeDdcAmt) {
		this.npHthrWaInfeeDdcAmt = npHthrWaInfeeDdcAmt;
	}

	public Long getNpHthrMcurWkarInfeeAmt() {
		return npHthrMcurWkarInfeeAmt;
	}

	public void setNpHthrMcurWkarInfeeAmt(
			Long npHthrMcurWkarInfeeAmt) {
		this.npHthrMcurWkarInfeeAmt = npHthrMcurWkarInfeeAmt;
	}

	public Long getNpHthrMcurWkarDdcAmt() {
		return npHthrMcurWkarDdcAmt;
	}

	public void setNpHthrMcurWkarDdcAmt(Long npHthrMcurWkarDdcAmt) {
		this.npHthrMcurWkarDdcAmt = npHthrMcurWkarDdcAmt;
	}

	public Long getHthrPblcPnsnInfeeAmt() {
		return hthrPblcPnsnInfeeAmt;
	}

	public void setHthrPblcPnsnInfeeAmt(Long hthrPblcPnsnInfeeAmt) {
		this.hthrPblcPnsnInfeeAmt = hthrPblcPnsnInfeeAmt;
	}

	public Long getHthrPblcPnsnInfeeDdcAmt() {
		return hthrPblcPnsnInfeeDdcAmt;
	}

	public void setHthrPblcPnsnInfeeDdcAmt(
			Long hthrPblcPnsnInfeeDdcAmt) {
		this.hthrPblcPnsnInfeeDdcAmt = hthrPblcPnsnInfeeDdcAmt;
	}

	public Long getMcurPblcPnsnInfeeAmt() {
		return mcurPblcPnsnInfeeAmt;
	}

	public void setMcurPblcPnsnInfeeAmt(Long mcurPblcPnsnInfeeAmt) {
		this.mcurPblcPnsnInfeeAmt = mcurPblcPnsnInfeeAmt;
	}

	public Long getMcurPblcPnsnInfeeDdcAmt() {
		return mcurPblcPnsnInfeeDdcAmt;
	}

	public void setMcurPblcPnsnInfeeDdcAmt(
			Long mcurPblcPnsnInfeeDdcAmt) {
		this.mcurPblcPnsnInfeeDdcAmt = mcurPblcPnsnInfeeDdcAmt;
	}

	public Long getPnsnInfeeUseAmtSum() {
		return pnsnInfeeUseAmtSum;
	}

	public void setPnsnInfeeUseAmtSum(Long pnsnInfeeUseAmtSum) {
		this.pnsnInfeeUseAmtSum = pnsnInfeeUseAmtSum;
	}

	public Long getPnsnInfeeDdcAmtSum() {
		return pnsnInfeeDdcAmtSum;
	}

	public void setPnsnInfeeDdcAmtSum(Long pnsnInfeeDdcAmtSum) {
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
