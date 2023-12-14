package com.app.exterms.yearendtax.client.dto.yeta2016;

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
public class Ye16Ta3110DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 사업자등록번호 : siteNumb */
    private java.lang.String siteNumb;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

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
    private Long payrTotl;

    /** set 상여합계금액 : bonsAmnt */
    private Long bonsAmnt;

    /** set 인정상여합계금액 : dtmnBtam */
    private Long dtmnBtam;

    /** set 주식행사이익 : stckPrft */
    private Long stckPrft;

    /** set 우리사주조합인출금액 : unonAmnt */
    private Long unonAmnt;

    /** set 임원퇴직소득금액한도초과액 : ofrrExli */
    private Long ofrrExli;

    /** set 비과세합계금액 : taxeTotl */
    private Long taxeTotl;

    /** set 연구보조비합계금액 : reseSmam */
    private Long reseSmam;

    /** set 소득세 : earnTaxn */
    private Long earnTaxn;

    /** set 지방소득세 : ihtxTaxn */
    private Long ihtxTaxn;

    /** set 농특세 : farmTaxn */
    private Long farmTaxn;

    /** set 국민연금보험료금액 : annuMuam */
    private Long annuMuam;

    /** set 국민연금보험료공제액 : annuDdam */
    private Long annuDdam;

    /** set 국민연금외공무원연금 : auetMuam */
    private Long auetMuam;

    /** set 국민연금외군인연금 : auetSold */
    private Long auetSold;

    /** set 국민연금외교직원연금 : auetTech */
    private Long auetTech;

    /** set 국민연금외별정우체국 : auetFect */
    private Long auetFect;

    /** set 국민연금외공무원연금공제액 : auetDdam */
    private Long auetDdam;

    /** set 국민연금외군인연금공제액 : auetDold */
    private Long auetDold;

    /** set 국민연금외교직원연금공제액 : auetDech */
    private Long auetDech;

    /** set 국민연금외별정우체국공제액 : auetDect */
    private Long auetDect;

    /** set 퇴직연금과학기술인금액 : rtreMuam */
    private Long rtreMuam;

    /** set 퇴직연금근로자퇴직급여보장법 : rtrePsct */
    private Long rtrePsct;

    /** set 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
    private Long rtreAnsv;

    /** set 퇴직연금과학기술인공제액 : rtreDdam */
    private Long rtreDdam;

    /** set 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
    private Long rtreDsct;

    /** set 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
    private Long rtreDnsv;

    /** set 국민건강보험료금액 : hlthDbam */
    private Long hlthDbam;

    /** set 국민건강보험료공제액 : hlthMuam */
    private Long hlthMuam;

    /** set 고용보험금액 : upisJuam */
    private Long upisJuam;

    /** set 고용보험공제액 : upisMuam */
    private Long upisMuam;

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
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getSiteNumb() {
        return this.siteNumb;
    }
    
    public void setSiteNumb(java.lang.String siteNumb) {
        this.siteNumb = siteNumb;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getJeymStdt() {
        return this.jeymStdt;
    }
    
    public void setJeymStdt(java.lang.String jeymStdt) {
        this.jeymStdt = jeymStdt;
    }
    
    public java.lang.String getJeymEddt() {
        return this.jeymEddt;
    }
    
    public void setJeymEddt(java.lang.String jeymEddt) {
        this.jeymEddt = jeymEddt;
    }
    
    public java.lang.String getJutrEddt() {
        return this.jutrEddt;
    }
    
    public void setJutrEddt(java.lang.String jutrEddt) {
        this.jutrEddt = jutrEddt;
    }
    
    public java.lang.String getJutrStdt() {
        return this.jutrStdt;
    }
    
    public void setJutrStdt(java.lang.String jutrStdt) {
        this.jutrStdt = jutrStdt;
    }
    
    public java.lang.String getSiteCtnt() {
        return this.siteCtnt;
    }
    
    public void setSiteCtnt(java.lang.String siteCtnt) {
        this.siteCtnt = siteCtnt;
    }
    
    public Long getPayrTotl() {
        return this.payrTotl;
    }
    
    public void setPayrTotl(Long payrTotl) {
        this.payrTotl = payrTotl;
    }
    
    public Long getBonsAmnt() {
        return this.bonsAmnt;
    }
    
    public void setBonsAmnt(Long bonsAmnt) {
        this.bonsAmnt = bonsAmnt;
    }
    
    public Long getDtmnBtam() {
        return this.dtmnBtam;
    }
    
    public void setDtmnBtam(Long dtmnBtam) {
        this.dtmnBtam = dtmnBtam;
    }
    
    public Long getStckPrft() {
        return this.stckPrft;
    }
    
    public void setStckPrft(Long stckPrft) {
        this.stckPrft = stckPrft;
    }
    
    public Long getUnonAmnt() {
        return this.unonAmnt;
    }
    
    public void setUnonAmnt(Long unonAmnt) {
        this.unonAmnt = unonAmnt;
    }
    
    public Long getOfrrExli() {
        return this.ofrrExli;
    }
    
    public void setOfrrExli(Long ofrrExli) {
        this.ofrrExli = ofrrExli;
    }
    
    public Long getTaxeTotl() {
        return this.taxeTotl;
    }
    
    public void setTaxeTotl(Long taxeTotl) {
        this.taxeTotl = taxeTotl;
    }
    
    public Long getReseSmam() {
        return this.reseSmam;
    }
    
    public void setReseSmam(Long reseSmam) {
        this.reseSmam = reseSmam;
    }
    
    public Long getEarnTaxn() {
        return this.earnTaxn;
    }
    
    public void setEarnTaxn(Long earnTaxn) {
        this.earnTaxn = earnTaxn;
    }
    
    public Long getIhtxTaxn() {
        return this.ihtxTaxn;
    }
    
    public void setIhtxTaxn(Long ihtxTaxn) {
        this.ihtxTaxn = ihtxTaxn;
    }
    
    public Long getFarmTaxn() {
        return this.farmTaxn;
    }
    
    public void setFarmTaxn(Long farmTaxn) {
        this.farmTaxn = farmTaxn;
    }
    
    public Long getAnnuMuam() {
        return this.annuMuam;
    }
    
    public void setAnnuMuam(Long annuMuam) {
        this.annuMuam = annuMuam;
    }
    
    public Long getAnnuDdam() {
        return this.annuDdam;
    }
    
    public void setAnnuDdam(Long annuDdam) {
        this.annuDdam = annuDdam;
    }
    
    public Long getAuetMuam() {
        return this.auetMuam;
    }
    
    public void setAuetMuam(Long auetMuam) {
        this.auetMuam = auetMuam;
    }
    
    public Long getAuetSold() {
        return this.auetSold;
    }
    
    public void setAuetSold(Long auetSold) {
        this.auetSold = auetSold;
    }
    
    public Long getAuetTech() {
        return this.auetTech;
    }
    
    public void setAuetTech(Long auetTech) {
        this.auetTech = auetTech;
    }
    
    public Long getAuetFect() {
        return this.auetFect;
    }
    
    public void setAuetFect(Long auetFect) {
        this.auetFect = auetFect;
    }
    
    public Long getAuetDdam() {
        return this.auetDdam;
    }
    
    public void setAuetDdam(Long auetDdam) {
        this.auetDdam = auetDdam;
    }
    
    public Long getAuetDold() {
        return this.auetDold;
    }
    
    public void setAuetDold(Long auetDold) {
        this.auetDold = auetDold;
    }
    
    public Long getAuetDech() {
        return this.auetDech;
    }
    
    public void setAuetDech(Long auetDech) {
        this.auetDech = auetDech;
    }
    
    public Long getAuetDect() {
        return this.auetDect;
    }
    
    public void setAuetDect(Long auetDect) {
        this.auetDect = auetDect;
    }
    
    public Long getRtreMuam() {
        return this.rtreMuam;
    }
    
    public void setRtreMuam(Long rtreMuam) {
        this.rtreMuam = rtreMuam;
    }
    
    public Long getRtrePsct() {
        return this.rtrePsct;
    }
    
    public void setRtrePsct(Long rtrePsct) {
        this.rtrePsct = rtrePsct;
    }
    
    public Long getRtreAnsv() {
        return this.rtreAnsv;
    }
    
    public void setRtreAnsv(Long rtreAnsv) {
        this.rtreAnsv = rtreAnsv;
    }
    
    public Long getRtreDdam() {
        return this.rtreDdam;
    }
    
    public void setRtreDdam(Long rtreDdam) {
        this.rtreDdam = rtreDdam;
    }
    
    public Long getRtreDsct() {
        return this.rtreDsct;
    }
    
    public void setRtreDsct(Long rtreDsct) {
        this.rtreDsct = rtreDsct;
    }
    
    public Long getRtreDnsv() {
        return this.rtreDnsv;
    }
    
    public void setRtreDnsv(Long rtreDnsv) {
        this.rtreDnsv = rtreDnsv;
    }
    
    public Long getHlthDbam() {
        return this.hlthDbam;
    }
    
    public void setHlthDbam(Long hlthDbam) {
        this.hlthDbam = hlthDbam;
    }
    
    public Long getHlthMuam() {
        return this.hlthMuam;
    }
    
    public void setHlthMuam(Long hlthMuam) {
        this.hlthMuam = hlthMuam;
    }
    
    public Long getUpisJuam() {
        return this.upisJuam;
    }
    
    public void setUpisJuam(Long upisJuam) {
        this.upisJuam = upisJuam;
    }
    
    public Long getUpisMuam() {
        return this.upisMuam;
    }
    
    public void setUpisMuam(Long upisMuam) {
        this.upisMuam = upisMuam;
    }
    
    public java.lang.String getMangGbyn() {
        return this.mangGbyn;
    }
    
    public void setMangGbyn(java.lang.String mangGbyn) {
        this.mangGbyn = mangGbyn;
    }
    
    public java.lang.String getWthdSbyn() {
        return this.wthdSbyn;
    }
    
    public void setWthdSbyn(java.lang.String wthdSbyn) {
        this.wthdSbyn = wthdSbyn;
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
