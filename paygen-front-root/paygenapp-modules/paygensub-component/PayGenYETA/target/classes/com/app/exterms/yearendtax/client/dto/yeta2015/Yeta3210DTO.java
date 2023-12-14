package com.app.exterms.yearendtax.client.dto.yeta2015;

import java.io.Serializable;

/**
 * @Class Name : Yeta3210VO.java
 * @Description : Yeta3210 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3210DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 지급년월 : elctYymm */
    private java.lang.String elctYymm;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 급여지급일자 : elctDate */
    private java.lang.String elctDate;

    /** set 급여지급금액_과세 : suprTxam */
    private Long suprTxam;

    /** set 상여금_과세 : buamTxam */
    private Long buamTxam;

    /** set 인정상여금액 : inbsAmnt */
    private Long inbsAmnt;

    /** set 주식행사이익금액 : stckInam */
    private Long stckInam;

    /** set 급여_상여합계금액 : spbmTxam */
    private Long spbmTxam;

    /** set 외국인소득금액_과세 : ecinTxam */
    private Long ecinTxam;

    /** set 외국인소득금액_비과세 : taxmEcin */
    private Long taxmEcin;

    /** set 자가운전보조금_비과세 : taxmEarn */
    private Long taxmEarn;

    /** set 정액급식비_비과세 : taxmEtam */
    private Long taxmEtam;

    /** set 정액급식비_과세 : txetTxam */
    private Long txetTxam;

    /** set 출산보육수당_비과세 : addrBhtx */
    private Long addrBhtx;

    /** set 건강보험료금액 : spciHlth */
    private Long spciHlth;

    /** set 고용보험료금액 : spciEmpf */
    private Long spciEmpf;

    /** set 국민연금금액 : natnPsnf */
    private Long natnPsnf;

    /** set 소득세 : earnTaxn */
    private Long earnTaxn;

    /** set 지방소득세 : ihtxTaxn */
    private Long ihtxTaxn;

    /** set 기타금액_과세 : etccTxam */
    private Long etccTxam;

    /** set 기타금액_비과세 : etccEtam */
    private Long etccEtam;

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
    
    public java.lang.String getElctYymm() {
        return this.elctYymm;
    }
    
    public void setElctYymm(java.lang.String elctYymm) {
        this.elctYymm = elctYymm;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getElctDate() {
        return this.elctDate;
    }
    
    public void setElctDate(java.lang.String elctDate) {
        this.elctDate = elctDate;
    }
    
    public Long getSuprTxam() {
        return this.suprTxam;
    }
    
    public void setSuprTxam(Long suprTxam) {
        this.suprTxam = suprTxam;
    }
    
    public Long getBuamTxam() {
        return this.buamTxam;
    }
    
    public void setBuamTxam(Long buamTxam) {
        this.buamTxam = buamTxam;
    }
    
    public Long getInbsAmnt() {
        return this.inbsAmnt;
    }
    
    public void setInbsAmnt(Long inbsAmnt) {
        this.inbsAmnt = inbsAmnt;
    }
    
    public Long getStckInam() {
        return this.stckInam;
    }
    
    public void setStckInam(Long stckInam) {
        this.stckInam = stckInam;
    }
    
    public Long getSpbmTxam() {
        return this.spbmTxam;
    }
    
    public void setSpbmTxam(Long spbmTxam) {
        this.spbmTxam = spbmTxam;
    }
    
    public Long getEcinTxam() {
        return this.ecinTxam;
    }
    
    public void setEcinTxam(Long ecinTxam) {
        this.ecinTxam = ecinTxam;
    }
    
    public Long getTaxmEcin() {
        return this.taxmEcin;
    }
    
    public void setTaxmEcin(Long taxmEcin) {
        this.taxmEcin = taxmEcin;
    }
    
    public Long getTaxmEarn() {
        return this.taxmEarn;
    }
    
    public void setTaxmEarn(Long taxmEarn) {
        this.taxmEarn = taxmEarn;
    }
    
    public Long getTaxmEtam() {
        return this.taxmEtam;
    }
    
    public void setTaxmEtam(Long taxmEtam) {
        this.taxmEtam = taxmEtam;
    }
    
    public Long getTxetTxam() {
        return this.txetTxam;
    }
    
    public void setTxetTxam(Long txetTxam) {
        this.txetTxam = txetTxam;
    }
    
   
    
    /**
	 * Comment : 
	 * @fn Long getAddrBhtx()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the addrBhtx get
	 */
	public Long getAddrBhtx() {
		return addrBhtx;
	}

	/**
	 * Comment : 
	 *@fn void setAddrBhtx(Long addrBhtx)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param addrBhtx the addrBhtx to set
	 */
	public void setAddrBhtx(Long addrBhtx) {
		this.addrBhtx = addrBhtx;
	}

	public Long getSpciHlth() {
        return this.spciHlth;
    }
    
    public void setSpciHlth(Long spciHlth) {
        this.spciHlth = spciHlth;
    }
    
    public Long getSpciEmpf() {
        return this.spciEmpf;
    }
    
    public void setSpciEmpf(Long spciEmpf) {
        this.spciEmpf = spciEmpf;
    }
    
    public Long getNatnPsnf() {
        return this.natnPsnf;
    }
    
    public void setNatnPsnf(Long natnPsnf) {
        this.natnPsnf = natnPsnf;
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
    
    public Long getEtccTxam() {
        return this.etccTxam;
    }
    
    public void setEtccTxam(Long etccTxam) {
        this.etccTxam = etccTxam;
    }
    
    public Long getEtccEtam() {
        return this.etccEtam;
    }
    
    public void setEtccEtam(Long etccEtam) {
        this.etccEtam = etccEtam;
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
