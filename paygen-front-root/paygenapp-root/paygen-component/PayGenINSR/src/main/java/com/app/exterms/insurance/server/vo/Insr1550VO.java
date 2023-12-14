package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr1550VO.java
 * @Description : Insr1550 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1550VO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 가족일련번호 : famySeilNum */
	private Long famySeilNum;

	/** set 가족관계구분코드 : famyRelaDivCd */
	private java.lang.String famyRelaDivCd;

	/** set 가족관계 : famyRelaDivNm */
	private java.lang.String famyRelaDivNm;

	/** set 가족성명 : famyNm */
	private java.lang.String famyNm;

	/** set 가족주민등록번호 : famyResnRegnNum */
	private java.lang.String famyResnRegnNum;

    /** set 가족주민등록번호 : famySecRegnNum */
   private java.lang.String famySecRegnNum;
	/** set 관계부호 : relaSgn */
	private java.lang.String relaSgn;

	/** set 관계부호 : relaSgnNm */
	private java.lang.String relaSgnNm;

	/** set 취득상실구분코드 : aqtnDivCd */
	private java.lang.String aqtnDivCd;

	/** set 취득상실구분 : aqtnDivNm */
	private java.lang.String aqtnDivNm;

	/** set 취득일자 : aqtnDt */
	private java.lang.String aqtnDt;

	/** set 취득상실사유코드 : aqtnReasCd */
	private java.lang.String aqtnReasCd;

	/** set 취득상실사유 : aqtnReasNm */
	private java.lang.String aqtnReasNm;

	/** set 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	private java.lang.String dbpsnAssttnSgnCd;

	/** set 장애인_종별부호 : dbpsnAssttnSgnNm */
	private java.lang.String dbpsnAssttnSgnNm;

	/** set 장애인_등급코드 : dbpsnGrdeCd */
	private java.lang.String dbpsnGrdeCd;

	/** set 장애인_등급코드 : dbpsnGrdeNm */
	private java.lang.String dbpsnGrdeNm;

	/** set 장애인_등록일자 : dbpsnRgstnDt */
	private java.lang.String dbpsnRgstnDt;

	/** set 장애인_국적코드 : dbpsnNatnCd */
	private java.lang.String dbpsnNatnCd;

	/** set 장애인_국적 : dbpsnNatnNm */
	private java.lang.String dbpsnNatnNm;

	/** set 외국인_체류자격코드 : frgnrStyQftntCd */
	private java.lang.String frgnrStyQftntCd;

	/** set 외국인_체류자격 : frgnrStyQftntNm */
	private java.lang.String frgnrStyQftntNm;

	/** set 외국인_체류시작일자 : frgnrStyBgnnDt */
	private java.lang.String frgnrStyBgnnDt;

	/** set 외국인_체류종료일자 : frgnrStyEndDt */
	private java.lang.String frgnrStyEndDt;

	/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
	private java.lang.String socrAqtnFamyYn;

	/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
	private java.lang.String socrLssFamyYn;

	/** set 사회보험취득_신고 작성일자 : famyAqtnLssDt */
	private java.lang.String famyAqtnLssDt;

	/** set 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	private Long famyAqtnLssNum;

	private java.lang.String famyQuftDivCd;
	
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

	/** set 건강보험사업장명 : insrDpobNm */
	private java.lang.String insrDpobNm;
	
	/** set 건강보험사업장관리번호 : insrDpobNum */
	private java.lang.String insrDpobNum;
	
	/** set 건강보험사업장전화번호 : insrDpobPhnNum */
	private java.lang.String insrDpobPhnNum;
	
	/** set 건강보험가입자전화번호 : insrUsePhnNum */
	private java.lang.String insrUsePhnNum;
	
	
	private Long socInsrAqtnEmymtNum;
	private java.lang.String soctyInsurCmptnDt;
	private java.lang.String socInsrLssCmptnDt;
	private Long socInsrLssEmymtNum;
    
	private java.lang.String famyQuftDivCdAqtn;
	private java.lang.String famyQuftDivCdLss;
	
	
	
	public java.lang.String getFamyQuftDivCdAqtn() {
		return famyQuftDivCdAqtn;
	}

	public void setFamyQuftDivCdAqtn(java.lang.String famyQuftDivCdAqtn) {
		this.famyQuftDivCdAqtn = famyQuftDivCdAqtn;
	}

	public java.lang.String getFamyQuftDivCdLss() {
		return famyQuftDivCdLss;
	}

	public void setFamyQuftDivCdLss(java.lang.String famyQuftDivCdLss) {
		this.famyQuftDivCdLss = famyQuftDivCdLss;
	}

	public Long getSocInsrAqtnEmymtNum() {
		return socInsrAqtnEmymtNum;
	}

	public void setSocInsrAqtnEmymtNum(Long socInsrAqtnEmymtNum) {
		this.socInsrAqtnEmymtNum = socInsrAqtnEmymtNum;
	}

	public java.lang.String getSoctyInsurCmptnDt() {
		return soctyInsurCmptnDt;
	}

	public void setSoctyInsurCmptnDt(java.lang.String soctyInsurCmptnDt) {
		this.soctyInsurCmptnDt = soctyInsurCmptnDt;
	}

	public java.lang.String getSocInsrLssCmptnDt() {
		return socInsrLssCmptnDt;
	}

	public void setSocInsrLssCmptnDt(java.lang.String socInsrLssCmptnDt) {
		this.socInsrLssCmptnDt = socInsrLssCmptnDt;
	}

	public Long getSocInsrLssEmymtNum() {
		return socInsrLssEmymtNum;
	}

	public void setSocInsrLssEmymtNum(Long socInsrLssEmymtNum) {
		this.socInsrLssEmymtNum = socInsrLssEmymtNum;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public Long getFamySeilNum() {
		return famySeilNum;
	}

	public void setFamySeilNum(Long famySeilNum) {
		this.famySeilNum = famySeilNum;
	}

	public java.lang.String getFamyRelaDivCd() {
		return famyRelaDivCd;
	}

	public void setFamyRelaDivCd(java.lang.String famyRelaDivCd) {
		this.famyRelaDivCd = famyRelaDivCd;
	}

	public java.lang.String getFamyRelaDivNm() {
		return famyRelaDivNm;
	}

	public void setFamyRelaDivNm(java.lang.String famyRelaDivNm) {
		this.famyRelaDivNm = famyRelaDivNm;
	}

	public java.lang.String getFamyNm() {
		return famyNm;
	}

	public void setFamyNm(java.lang.String famyNm) {
		this.famyNm = famyNm;
	}

	public java.lang.String getFamyResnRegnNum() {
		return famyResnRegnNum;
	}

	public void setFamyResnRegnNum(java.lang.String famyResnRegnNum) {
		this.famyResnRegnNum = famyResnRegnNum;
	}

	public java.lang.String getRelaSgn() {
		return relaSgn;
	}

	public void setRelaSgn(java.lang.String relaSgn) {
		this.relaSgn = relaSgn;
	}

	public java.lang.String getRelaSgnNm() {
		return relaSgnNm;
	}

	public void setRelaSgnNm(java.lang.String relaSgnNm) {
		this.relaSgnNm = relaSgnNm;
	}

	public java.lang.String getAqtnDivCd() {
		return aqtnDivCd;
	}

	public void setAqtnDivCd(java.lang.String aqtnDivCd) {
		this.aqtnDivCd = aqtnDivCd;
	}

	public java.lang.String getAqtnDivNm() {
		return aqtnDivNm;
	}

	public void setAqtnDivNm(java.lang.String aqtnDivNm) {
		this.aqtnDivNm = aqtnDivNm;
	}

	public java.lang.String getAqtnDt() {
		return aqtnDt;
	}

	public void setAqtnDt(java.lang.String aqtnDt) {
		this.aqtnDt = aqtnDt;
	}

	public java.lang.String getAqtnReasCd() {
		return aqtnReasCd;
	}

	public void setAqtnReasCd(java.lang.String aqtnReasCd) {
		this.aqtnReasCd = aqtnReasCd;
	}

	public java.lang.String getAqtnReasNm() {
		return aqtnReasNm;
	}

	public void setAqtnReasNm(java.lang.String aqtnReasNm) {
		this.aqtnReasNm = aqtnReasNm;
	}

	public java.lang.String getDbpsnAssttnSgnCd() {
		return dbpsnAssttnSgnCd;
	}

	public void setDbpsnAssttnSgnCd(java.lang.String dbpsnAssttnSgnCd) {
		this.dbpsnAssttnSgnCd = dbpsnAssttnSgnCd;
	}

	public java.lang.String getDbpsnAssttnSgnNm() {
		return dbpsnAssttnSgnNm;
	}

	public void setDbpsnAssttnSgnNm(java.lang.String dbpsnAssttnSgnNm) {
		this.dbpsnAssttnSgnNm = dbpsnAssttnSgnNm;
	}

	public java.lang.String getDbpsnGrdeCd() {
		return dbpsnGrdeCd;
	}

	public void setDbpsnGrdeCd(java.lang.String dbpsnGrdeCd) {
		this.dbpsnGrdeCd = dbpsnGrdeCd;
	}

	public java.lang.String getDbpsnGrdeNm() {
		return dbpsnGrdeNm;
	}

	public void setDbpsnGrdeNm(java.lang.String dbpsnGrdeNm) {
		this.dbpsnGrdeNm = dbpsnGrdeNm;
	}

	public java.lang.String getDbpsnRgstnDt() {
		return dbpsnRgstnDt;
	}

	public void setDbpsnRgstnDt(java.lang.String dbpsnRgstnDt) {
		this.dbpsnRgstnDt = dbpsnRgstnDt;
	}

	public java.lang.String getDbpsnNatnCd() {
		return dbpsnNatnCd;
	}

	public void setDbpsnNatnCd(java.lang.String dbpsnNatnCd) {
		this.dbpsnNatnCd = dbpsnNatnCd;
	}

	public java.lang.String getDbpsnNatnNm() {
		return dbpsnNatnNm;
	}

	public void setDbpsnNatnNm(java.lang.String dbpsnNatnNm) {
		this.dbpsnNatnNm = dbpsnNatnNm;
	}

	public java.lang.String getFrgnrStyQftntCd() {
		return frgnrStyQftntCd;
	}

	public void setFrgnrStyQftntCd(java.lang.String frgnrStyQftntCd) {
		this.frgnrStyQftntCd = frgnrStyQftntCd;
	}

	public java.lang.String getFrgnrStyQftntNm() {
		return frgnrStyQftntNm;
	}

	public void setFrgnrStyQftntNm(java.lang.String frgnrStyQftntNm) {
		this.frgnrStyQftntNm = frgnrStyQftntNm;
	}

	public java.lang.String getFrgnrStyBgnnDt() {
		return frgnrStyBgnnDt;
	}

	public void setFrgnrStyBgnnDt(java.lang.String frgnrStyBgnnDt) {
		this.frgnrStyBgnnDt = frgnrStyBgnnDt;
	}

	public java.lang.String getFrgnrStyEndDt() {
		return frgnrStyEndDt;
	}

	public void setFrgnrStyEndDt(java.lang.String frgnrStyEndDt) {
		this.frgnrStyEndDt = frgnrStyEndDt;
	}

	public java.lang.String getSocrAqtnFamyYn() {
		return socrAqtnFamyYn;
	}

	public void setSocrAqtnFamyYn(java.lang.String socrAqtnFamyYn) {
		this.socrAqtnFamyYn = socrAqtnFamyYn;
	}

	public java.lang.String getSocrLssFamyYn() {
		return socrLssFamyYn;
	}

	public void setSocrLssFamyYn(java.lang.String socrLssFamyYn) {
		this.socrLssFamyYn = socrLssFamyYn;
	}

	public java.lang.String getFamyAqtnLssDt() {
		return famyAqtnLssDt;
	}

	public void setFamyAqtnLssDt(java.lang.String famyAqtnLssDt) {
		this.famyAqtnLssDt = famyAqtnLssDt;
	}

	public Long getFamyAqtnLssNum() {
		return famyAqtnLssNum;
	}

	public void setFamyAqtnLssNum(Long famyAqtnLssNum) {
		this.famyAqtnLssNum = famyAqtnLssNum;
	}

	public java.lang.String getFamyQuftDivCd() {
		return famyQuftDivCd;
	}

	public void setFamyQuftDivCd(java.lang.String famyQuftDivCd) {
		this.famyQuftDivCd = famyQuftDivCd;
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

	public java.lang.String getInsrDpobNm() {
		return insrDpobNm;
	}

	public void setInsrDpobNm(java.lang.String insrDpobNm) {
		this.insrDpobNm = insrDpobNm;
	}

	public java.lang.String getInsrDpobNum() {
		return insrDpobNum;
	}

	public void setInsrDpobNum(java.lang.String insrDpobNum) {
		this.insrDpobNum = insrDpobNum;
	}

	public java.lang.String getInsrDpobPhnNum() {
		return insrDpobPhnNum;
	}

	public void setInsrDpobPhnNum(java.lang.String insrDpobPhnNum) {
		this.insrDpobPhnNum = insrDpobPhnNum;
	}

	public java.lang.String getInsrUsePhnNum() {
		return insrUsePhnNum;
	}

	public void setInsrUsePhnNum(java.lang.String insrUsePhnNum) {
		this.insrUsePhnNum = insrUsePhnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getFamySecRegnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the famySecRegnNum get
	 */
	public java.lang.String getFamySecRegnNum() {
		return famySecRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setFamySecRegnNum(java.lang.String famySecRegnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param famySecRegnNum the famySecRegnNum to set
	 */
	public void setFamySecRegnNum(java.lang.String famySecRegnNum) {
		this.famySecRegnNum = famySecRegnNum;
	}

}

