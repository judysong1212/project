package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta3110VO.java
 * @Description : Yeta3110 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3110_2018_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 사업자등록번호 : siteNumb */
    private java.lang.String siteNumb;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 귀속년월_FROM : jeymStdt */
    private java.lang.String jeymStdt;

    /** set 귀속년월_TO : jeymEddt */
    private java.lang.String jeymEddt;

    /** set 감면기간_TO : jutrEddt */
    private java.lang.String jutrEddt;

    /** set 감면기간_FROM : jutrStdt */
    private java.lang.String jutrStdt;

    /** set 근무지명 : siteCtnt */
    private java.lang.String siteCtnt;

    /** set 급여합계금액 : payrTotl */
    private java.math.BigDecimal payrTotl;

    /** set 상여합계금액 : bonsAmnt */
    private java.math.BigDecimal bonsAmnt;

    /** set 인정상여합계금액 : dtmnBtam */
    private java.math.BigDecimal dtmnBtam;

    /** set 주식행사이익 : stckPrft */
    private java.math.BigDecimal stckPrft;

    /** set 우리사주조합인출금액 : unonAmnt */
    private java.math.BigDecimal unonAmnt;

    /** set 임원퇴직소득금액한도초과액 : ofrrExli */
    private java.math.BigDecimal ofrrExli;

    /** set 비과세합계금액 : taxeTotl */
    private java.math.BigDecimal taxeTotl;

    /** set 연구보조비합계금액 : reseSmam */
    private java.math.BigDecimal reseSmam;

    /** set 소득세 : earnTaxn */
    private java.math.BigDecimal earnTaxn;

    /** set 지방소득세 : ihtxTaxn */
    private java.math.BigDecimal ihtxTaxn;

    /** set 농특세 : farmTaxn */
    private java.math.BigDecimal farmTaxn;

    /** set 국민연금보험료금액 : annuMuam */
    private java.math.BigDecimal annuMuam;

    /** set 국민연금보험료공제액 : annuDdam */
    private java.math.BigDecimal annuDdam;

    /** set 국민연금외공무원연금 : auetMuam */
    private java.math.BigDecimal auetMuam;

    /** set 국민연금외군인연금 : auetSold */
    private java.math.BigDecimal auetSold;

    /** set 국민연금외교직원연금 : auetTech */
    private java.math.BigDecimal auetTech;

    /** set 국민연금외별정우체국 : auetFect */
    private java.math.BigDecimal auetFect;

    /** set 국민연금외공무원연금공제액 : auetDdam */
    private java.math.BigDecimal auetDdam;

    /** set 국민연금외군인연금공제액 : auetDold */
    private java.math.BigDecimal auetDold;

    /** set 국민연금외교직원연금공제액 : auetDech */
    private java.math.BigDecimal auetDech;

    /** set 국민연금외별정우체국공제액 : auetDect */
    private java.math.BigDecimal auetDect;

    /** set 퇴직연금과학기술인금액 : rtreMuam */
    private java.math.BigDecimal rtreMuam;

    /** set 퇴직연금근로자퇴직급여보장법 : rtrePsct */
    private java.math.BigDecimal rtrePsct;

    /** set 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
    private java.math.BigDecimal rtreAnsv;

    /** set 퇴직연금과학기술인공제액 : rtreDdam */
    private java.math.BigDecimal rtreDdam;

    /** set 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
    private java.math.BigDecimal rtreDsct;

    /** set 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
    private java.math.BigDecimal rtreDnsv;

    /** set 국민건강보험료금액 : hlthDbam */
    private java.math.BigDecimal hlthDbam;

    /** set 국민건강보험료공제액 : hlthMuam */
    private java.math.BigDecimal hlthMuam;

    /** set 고용보험금액 : upisJuam */
    private java.math.BigDecimal upisJuam;

    /** set 고용보험공제액 : upisMuam */
    private java.math.BigDecimal upisMuam;

    /** set 처리구분여부 : mangGbyn */
    private java.lang.String mangGbyn;

    /** set 원천징수영수증제출여부 : wthdSbyn */
    private java.lang.String wthdSbyn;

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

	public java.lang.String getEdacRvyy() {
		return edacRvyy;
	}

	public void setEdacRvyy(java.lang.String edacRvyy) {
		this.edacRvyy = edacRvyy;
	}

	public java.lang.String getSettGbcd() {
		return settGbcd;
	}

	public void setSettGbcd(java.lang.String settGbcd) {
		this.settGbcd = settGbcd;
	}

	public java.lang.String getSiteNumb() {
		return siteNumb;
	}

	public void setSiteNumb(java.lang.String siteNumb) {
		this.siteNumb = siteNumb;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getJeymStdt() {
		return jeymStdt;
	}

	public void setJeymStdt(java.lang.String jeymStdt) {
		this.jeymStdt = jeymStdt;
	}

	public java.lang.String getJeymEddt() {
		return jeymEddt;
	}

	public void setJeymEddt(java.lang.String jeymEddt) {
		this.jeymEddt = jeymEddt;
	}

	public java.lang.String getJutrEddt() {
		return jutrEddt;
	}

	public void setJutrEddt(java.lang.String jutrEddt) {
		this.jutrEddt = jutrEddt;
	}

	public java.lang.String getJutrStdt() {
		return jutrStdt;
	}

	public void setJutrStdt(java.lang.String jutrStdt) {
		this.jutrStdt = jutrStdt;
	}

	public java.lang.String getSiteCtnt() {
		return siteCtnt;
	}

	public void setSiteCtnt(java.lang.String siteCtnt) {
		this.siteCtnt = siteCtnt;
	}

	public java.math.BigDecimal getPayrTotl() {
		return payrTotl;
	}

	public void setPayrTotl(java.math.BigDecimal payrTotl) {
		this.payrTotl = payrTotl;
	}

	public java.math.BigDecimal getBonsAmnt() {
		return bonsAmnt;
	}

	public void setBonsAmnt(java.math.BigDecimal bonsAmnt) {
		this.bonsAmnt = bonsAmnt;
	}

	public java.math.BigDecimal getDtmnBtam() {
		return dtmnBtam;
	}

	public void setDtmnBtam(java.math.BigDecimal dtmnBtam) {
		this.dtmnBtam = dtmnBtam;
	}

	public java.math.BigDecimal getStckPrft() {
		return stckPrft;
	}

	public void setStckPrft(java.math.BigDecimal stckPrft) {
		this.stckPrft = stckPrft;
	}

	public java.math.BigDecimal getUnonAmnt() {
		return unonAmnt;
	}

	public void setUnonAmnt(java.math.BigDecimal unonAmnt) {
		this.unonAmnt = unonAmnt;
	}

	public java.math.BigDecimal getOfrrExli() {
		return ofrrExli;
	}

	public void setOfrrExli(java.math.BigDecimal ofrrExli) {
		this.ofrrExli = ofrrExli;
	}

	public java.math.BigDecimal getTaxeTotl() {
		return taxeTotl;
	}

	public void setTaxeTotl(java.math.BigDecimal taxeTotl) {
		this.taxeTotl = taxeTotl;
	}

	public java.math.BigDecimal getReseSmam() {
		return reseSmam;
	}

	public void setReseSmam(java.math.BigDecimal reseSmam) {
		this.reseSmam = reseSmam;
	}

	public java.math.BigDecimal getEarnTaxn() {
		return earnTaxn;
	}

	public void setEarnTaxn(java.math.BigDecimal earnTaxn) {
		this.earnTaxn = earnTaxn;
	}

	public java.math.BigDecimal getIhtxTaxn() {
		return ihtxTaxn;
	}

	public void setIhtxTaxn(java.math.BigDecimal ihtxTaxn) {
		this.ihtxTaxn = ihtxTaxn;
	}

	public java.math.BigDecimal getFarmTaxn() {
		return farmTaxn;
	}

	public void setFarmTaxn(java.math.BigDecimal farmTaxn) {
		this.farmTaxn = farmTaxn;
	}

	public java.math.BigDecimal getAnnuMuam() {
		return annuMuam;
	}

	public void setAnnuMuam(java.math.BigDecimal annuMuam) {
		this.annuMuam = annuMuam;
	}

	public java.math.BigDecimal getAnnuDdam() {
		return annuDdam;
	}

	public void setAnnuDdam(java.math.BigDecimal annuDdam) {
		this.annuDdam = annuDdam;
	}

	public java.math.BigDecimal getAuetMuam() {
		return auetMuam;
	}

	public void setAuetMuam(java.math.BigDecimal auetMuam) {
		this.auetMuam = auetMuam;
	}

	public java.math.BigDecimal getAuetSold() {
		return auetSold;
	}

	public void setAuetSold(java.math.BigDecimal auetSold) {
		this.auetSold = auetSold;
	}

	public java.math.BigDecimal getAuetTech() {
		return auetTech;
	}

	public void setAuetTech(java.math.BigDecimal auetTech) {
		this.auetTech = auetTech;
	}

	public java.math.BigDecimal getAuetFect() {
		return auetFect;
	}

	public void setAuetFect(java.math.BigDecimal auetFect) {
		this.auetFect = auetFect;
	}

	public java.math.BigDecimal getAuetDdam() {
		return auetDdam;
	}

	public void setAuetDdam(java.math.BigDecimal auetDdam) {
		this.auetDdam = auetDdam;
	}

	public java.math.BigDecimal getAuetDold() {
		return auetDold;
	}

	public void setAuetDold(java.math.BigDecimal auetDold) {
		this.auetDold = auetDold;
	}

	public java.math.BigDecimal getAuetDech() {
		return auetDech;
	}

	public void setAuetDech(java.math.BigDecimal auetDech) {
		this.auetDech = auetDech;
	}

	public java.math.BigDecimal getAuetDect() {
		return auetDect;
	}

	public void setAuetDect(java.math.BigDecimal auetDect) {
		this.auetDect = auetDect;
	}

	public java.math.BigDecimal getRtreMuam() {
		return rtreMuam;
	}

	public void setRtreMuam(java.math.BigDecimal rtreMuam) {
		this.rtreMuam = rtreMuam;
	}

	public java.math.BigDecimal getRtrePsct() {
		return rtrePsct;
	}

	public void setRtrePsct(java.math.BigDecimal rtrePsct) {
		this.rtrePsct = rtrePsct;
	}

	public java.math.BigDecimal getRtreAnsv() {
		return rtreAnsv;
	}

	public void setRtreAnsv(java.math.BigDecimal rtreAnsv) {
		this.rtreAnsv = rtreAnsv;
	}

	public java.math.BigDecimal getRtreDdam() {
		return rtreDdam;
	}

	public void setRtreDdam(java.math.BigDecimal rtreDdam) {
		this.rtreDdam = rtreDdam;
	}

	public java.math.BigDecimal getRtreDsct() {
		return rtreDsct;
	}

	public void setRtreDsct(java.math.BigDecimal rtreDsct) {
		this.rtreDsct = rtreDsct;
	}

	public java.math.BigDecimal getRtreDnsv() {
		return rtreDnsv;
	}

	public void setRtreDnsv(java.math.BigDecimal rtreDnsv) {
		this.rtreDnsv = rtreDnsv;
	}

	public java.math.BigDecimal getHlthDbam() {
		return hlthDbam;
	}

	public void setHlthDbam(java.math.BigDecimal hlthDbam) {
		this.hlthDbam = hlthDbam;
	}

	public java.math.BigDecimal getHlthMuam() {
		return hlthMuam;
	}

	public void setHlthMuam(java.math.BigDecimal hlthMuam) {
		this.hlthMuam = hlthMuam;
	}

	public java.math.BigDecimal getUpisJuam() {
		return upisJuam;
	}

	public void setUpisJuam(java.math.BigDecimal upisJuam) {
		this.upisJuam = upisJuam;
	}

	public java.math.BigDecimal getUpisMuam() {
		return upisMuam;
	}

	public void setUpisMuam(java.math.BigDecimal upisMuam) {
		this.upisMuam = upisMuam;
	}

	public java.lang.String getMangGbyn() {
		return mangGbyn;
	}

	public void setMangGbyn(java.lang.String mangGbyn) {
		this.mangGbyn = mangGbyn;
	}

	public java.lang.String getWthdSbyn() {
		return wthdSbyn;
	}

	public void setWthdSbyn(java.lang.String wthdSbyn) {
		this.wthdSbyn = wthdSbyn;
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
