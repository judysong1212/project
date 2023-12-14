package com.app.exterms.yearendtax.server.vo;

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
public class Yeta3210_2021_VO implements Serializable {
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
    private java.math.BigDecimal suprTxam;

    /** set 상여금_과세 : buamTxam */
    private java.math.BigDecimal buamTxam;

    /** set 인정상여금액 : inbsAmnt */
    private java.math.BigDecimal inbsAmnt;

    /** set 주식행사이익금액 : stckInam */
    private java.math.BigDecimal stckInam;

    /** set 급여_상여합계금액 : spbmTxam */
    private java.math.BigDecimal spbmTxam;

    /** set 외국인소득금액_과세 : ecinTxam */
    private java.math.BigDecimal ecinTxam;

    /** set 외국인소득금액_비과세 : taxmEcin */
    private java.math.BigDecimal taxmEcin;

    /** set 자가운전보조금_비과세 : taxmEarn */
    private java.math.BigDecimal taxmEarn;

    /** set 정액급식비_비과세 : taxmEtam */
    private java.math.BigDecimal taxmEtam;

    /** set 정액급식비_과세 : txetTxam */
    private java.math.BigDecimal txetTxam;

    /** set 출산보육수당_비과세 : addrBhtx */
    private java.math.BigDecimal addrBhtx;

    /** set 건강보험료금액 : spciHlth */
    private java.math.BigDecimal spciHlth;

    /** set 고용보험료금액 : spciEmpf */
    private java.math.BigDecimal spciEmpf;

    /** set 국민연금금액 : natnPsnf */
    private java.math.BigDecimal natnPsnf;

    /** set 소득세 : earnTaxn */
    private java.math.BigDecimal earnTaxn;

    /** set 지방소득세 : ihtxTaxn */
    private java.math.BigDecimal ihtxTaxn;

    /** set 기타금액_과세 : etccTxam */
    private java.math.BigDecimal etccTxam;

    /** set 기타금액_비과세 : etccEtam */
    private java.math.BigDecimal etccEtam;

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

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEdacRvyy()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the edacRvyy get
	 */
	public java.lang.String getEdacRvyy() {
		return edacRvyy;
	}

	/**
	 * Comment : 
	 *@fn void setEdacRvyy(java.lang.String edacRvyy)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param edacRvyy the edacRvyy to set
	 */
	public void setEdacRvyy(java.lang.String edacRvyy) {
		this.edacRvyy = edacRvyy;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSettGbcd()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the settGbcd get
	 */
	public java.lang.String getSettGbcd() {
		return settGbcd;
	}

	/**
	 * Comment : 
	 *@fn void setSettGbcd(java.lang.String settGbcd)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param settGbcd the settGbcd to set
	 */
	public void setSettGbcd(java.lang.String settGbcd) {
		this.settGbcd = settGbcd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getElctYymm()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the elctYymm get
	 */
	public java.lang.String getElctYymm() {
		return elctYymm;
	}

	/**
	 * Comment : 
	 *@fn void setElctYymm(java.lang.String elctYymm)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param elctYymm the elctYymm to set
	 */
	public void setElctYymm(java.lang.String elctYymm) {
		this.elctYymm = elctYymm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getElctDate()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the elctDate get
	 */
	public java.lang.String getElctDate() {
		return elctDate;
	}

	/**
	 * Comment : 
	 *@fn void setElctDate(java.lang.String elctDate)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param elctDate the elctDate to set
	 */
	public void setElctDate(java.lang.String elctDate) {
		this.elctDate = elctDate;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getSuprTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the suprTxam get
	 */
	public java.math.BigDecimal getSuprTxam() {
		return suprTxam;
	}

	/**
	 * Comment : 
	 *@fn void setSuprTxam(java.math.BigDecimal suprTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param suprTxam the suprTxam to set
	 */
	public void setSuprTxam(java.math.BigDecimal suprTxam) {
		this.suprTxam = suprTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getBuamTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the buamTxam get
	 */
	public java.math.BigDecimal getBuamTxam() {
		return buamTxam;
	}

	/**
	 * Comment : 
	 *@fn void setBuamTxam(java.math.BigDecimal buamTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param buamTxam the buamTxam to set
	 */
	public void setBuamTxam(java.math.BigDecimal buamTxam) {
		this.buamTxam = buamTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getInbsAmnt()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the inbsAmnt get
	 */
	public java.math.BigDecimal getInbsAmnt() {
		return inbsAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setInbsAmnt(java.math.BigDecimal inbsAmnt)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param inbsAmnt the inbsAmnt to set
	 */
	public void setInbsAmnt(java.math.BigDecimal inbsAmnt) {
		this.inbsAmnt = inbsAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getStckInam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the stckInam get
	 */
	public java.math.BigDecimal getStckInam() {
		return stckInam;
	}

	/**
	 * Comment : 
	 *@fn void setStckInam(java.math.BigDecimal stckInam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param stckInam the stckInam to set
	 */
	public void setStckInam(java.math.BigDecimal stckInam) {
		this.stckInam = stckInam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getSpbmTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the spbmTxam get
	 */
	public java.math.BigDecimal getSpbmTxam() {
		return spbmTxam;
	}

	/**
	 * Comment : 
	 *@fn void setSpbmTxam(java.math.BigDecimal spbmTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param spbmTxam the spbmTxam to set
	 */
	public void setSpbmTxam(java.math.BigDecimal spbmTxam) {
		this.spbmTxam = spbmTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEcinTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the ecinTxam get
	 */
	public java.math.BigDecimal getEcinTxam() {
		return ecinTxam;
	}

	/**
	 * Comment : 
	 *@fn void setEcinTxam(java.math.BigDecimal ecinTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param ecinTxam the ecinTxam to set
	 */
	public void setEcinTxam(java.math.BigDecimal ecinTxam) {
		this.ecinTxam = ecinTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTaxmEcin()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the taxmEcin get
	 */
	public java.math.BigDecimal getTaxmEcin() {
		return taxmEcin;
	}

	/**
	 * Comment : 
	 *@fn void setTaxmEcin(java.math.BigDecimal taxmEcin)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param taxmEcin the taxmEcin to set
	 */
	public void setTaxmEcin(java.math.BigDecimal taxmEcin) {
		this.taxmEcin = taxmEcin;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTaxmEarn()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the taxmEarn get
	 */
	public java.math.BigDecimal getTaxmEarn() {
		return taxmEarn;
	}

	/**
	 * Comment : 
	 *@fn void setTaxmEarn(java.math.BigDecimal taxmEarn)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param taxmEarn the taxmEarn to set
	 */
	public void setTaxmEarn(java.math.BigDecimal taxmEarn) {
		this.taxmEarn = taxmEarn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTaxmEtam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the taxmEtam get
	 */
	public java.math.BigDecimal getTaxmEtam() {
		return taxmEtam;
	}

	/**
	 * Comment : 
	 *@fn void setTaxmEtam(java.math.BigDecimal taxmEtam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param taxmEtam the taxmEtam to set
	 */
	public void setTaxmEtam(java.math.BigDecimal taxmEtam) {
		this.taxmEtam = taxmEtam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTxetTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the txetTxam get
	 */
	public java.math.BigDecimal getTxetTxam() {
		return txetTxam;
	}

	/**
	 * Comment : 
	 *@fn void setTxetTxam(java.math.BigDecimal txetTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param txetTxam the txetTxam to set
	 */
	public void setTxetTxam(java.math.BigDecimal txetTxam) {
		this.txetTxam = txetTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getAddrBhtx()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the addrBhtx get
	 */
	public java.math.BigDecimal getAddrBhtx() {
		return addrBhtx;
	}

	/**
	 * Comment : 
	 *@fn void setAddrBhtx(java.math.BigDecimal addrBhtx)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param addrBhtx the addrBhtx to set
	 */
	public void setAddrBhtx(java.math.BigDecimal addrBhtx) {
		this.addrBhtx = addrBhtx;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getSpciHlth()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the spciHlth get
	 */
	public java.math.BigDecimal getSpciHlth() {
		return spciHlth;
	}

	/**
	 * Comment : 
	 *@fn void setSpciHlth(java.math.BigDecimal spciHlth)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param spciHlth the spciHlth to set
	 */
	public void setSpciHlth(java.math.BigDecimal spciHlth) {
		this.spciHlth = spciHlth;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getSpciEmpf()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the spciEmpf get
	 */
	public java.math.BigDecimal getSpciEmpf() {
		return spciEmpf;
	}

	/**
	 * Comment : 
	 *@fn void setSpciEmpf(java.math.BigDecimal spciEmpf)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param spciEmpf the spciEmpf to set
	 */
	public void setSpciEmpf(java.math.BigDecimal spciEmpf) {
		this.spciEmpf = spciEmpf;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getNatnPsnf()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the natnPsnf get
	 */
	public java.math.BigDecimal getNatnPsnf() {
		return natnPsnf;
	}

	/**
	 * Comment : 
	 *@fn void setNatnPsnf(java.math.BigDecimal natnPsnf)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param natnPsnf the natnPsnf to set
	 */
	public void setNatnPsnf(java.math.BigDecimal natnPsnf) {
		this.natnPsnf = natnPsnf;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEarnTaxn()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the earnTaxn get
	 */
	public java.math.BigDecimal getEarnTaxn() {
		return earnTaxn;
	}

	/**
	 * Comment : 
	 *@fn void setEarnTaxn(java.math.BigDecimal earnTaxn)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param earnTaxn the earnTaxn to set
	 */
	public void setEarnTaxn(java.math.BigDecimal earnTaxn) {
		this.earnTaxn = earnTaxn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getIhtxTaxn()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the ihtxTaxn get
	 */
	public java.math.BigDecimal getIhtxTaxn() {
		return ihtxTaxn;
	}

	/**
	 * Comment : 
	 *@fn void setIhtxTaxn(java.math.BigDecimal ihtxTaxn)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param ihtxTaxn the ihtxTaxn to set
	 */
	public void setIhtxTaxn(java.math.BigDecimal ihtxTaxn) {
		this.ihtxTaxn = ihtxTaxn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEtccTxam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the etccTxam get
	 */
	public java.math.BigDecimal getEtccTxam() {
		return etccTxam;
	}

	/**
	 * Comment : 
	 *@fn void setEtccTxam(java.math.BigDecimal etccTxam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param etccTxam the etccTxam to set
	 */
	public void setEtccTxam(java.math.BigDecimal etccTxam) {
		this.etccTxam = etccTxam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEtccEtam()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the etccEtam get
	 */
	public java.math.BigDecimal getEtccEtam() {
		return etccEtam;
	}

	/**
	 * Comment : 
	 *@fn void setEtccEtam(java.math.BigDecimal etccEtam)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param etccEtam the etccEtam to set
	 */
	public void setEtccEtam(java.math.BigDecimal etccEtam) {
		this.etccEtam = etccEtam;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getKybdr()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the kybdr get
	 */
	public java.lang.String getKybdr() {
		return kybdr;
	}

	/**
	 * Comment : 
	 *@fn void setKybdr(java.lang.String kybdr)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param kybdr the kybdr to set
	 */
	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptDt()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the inptDt get
	 */
	public java.lang.String getInptDt() {
		return inptDt;
	}

	/**
	 * Comment : 
	 *@fn void setInptDt(java.lang.String inptDt)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param inptDt the inptDt to set
	 */
	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getInptAddr()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the inptAddr get
	 */
	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	/**
	 * Comment : 
	 *@fn void setInptAddr(java.lang.String inptAddr)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param inptAddr the inptAddr to set
	 */
	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIsmt()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the ismt get
	 */
	public java.lang.String getIsmt() {
		return ismt;
	}

	/**
	 * Comment : 
	 *@fn void setIsmt(java.lang.String ismt)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param ismt the ismt to set
	 */
	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnDt()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the revnDt get
	 */
	public java.lang.String getRevnDt() {
		return revnDt;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2016 Jan 13, 2016 user:leeheuisung
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2016 Jan 13, 2016 user:leeheuisung
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

    
}
