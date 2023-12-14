package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr1550VO.java
 * @Description : Payr1550 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1550DTO  implements Serializable {
    
	private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	public java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	public java.lang.String systemkey;

	/** set 가족일련번호 : famySeilNum */
	public Long famySeilNum;

	/** set 가족관계구분코드 : famyRelaDivCd */
	public java.lang.String famyRelaDivCd;

	/** set 가족관계 : famyRelaDivNm */
	public java.lang.String famyRelaDivNm;

	/** set 가족성명 : famyNm */
	public java.lang.String famyNm;

	/** set 가족주민등록번호 : famyResnRegnNum */
	public java.lang.String famyResnRegnNum;
	

    /** set 가족주민등록번호 : famySecRegnNum */
   private java.lang.String famySecRegnNum;

	/** set 관계부호 : relaSgn */
	public java.lang.String relaSgn;

	/** set 관계부호 : relaSgnNm */
	public java.lang.String relaSgnNm;

	/** set 취득상실구분코드 : aqtnDivCd */
	public java.lang.String aqtnDivCd;

	/** set 취득상실구분 : aqtnDivNm */
	public java.lang.String aqtnDivNm;

	/** set 취득일자 : aqtnDt */
	public java.lang.String aqtnDt;

	/** set 취득상실사유코드 : aqtnReasCd */
	public java.lang.String aqtnReasCd;

	/** set 취득상실사유 : aqtnReasNm */
	public java.lang.String aqtnReasNm;

	/** set 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	public java.lang.String dbpsnAssttnSgnCd;

	/** set 장애인_종별부호 : dbpsnAssttnSgnNm */
	public java.lang.String dbpsnAssttnSgnNm;

	/** set 장애인_등급코드 : dbpsnGrdeCd */
	public java.lang.String dbpsnGrdeCd;

	/** set 장애인_등급코드 : dbpsnGrdeNm */
	public java.lang.String dbpsnGrdeNm;

	/** set 장애인_등록일자 : dbpsnRgstnDt */
	public java.lang.String dbpsnRgstnDt;

	/** set 장애인_국적코드 : dbpsnNatnCd */
	public java.lang.String dbpsnNatnCd;

	/** set 장애인_국적 : dbpsnNatnNm */
	public java.lang.String dbpsnNatnNm;

	/** set 외국인_체류자격코드 : frgnrStyQftntCd */
	public java.lang.String frgnrStyQftntCd;

	/** set 외국인_체류자격 : frgnrStyQftntNm */
	public java.lang.String frgnrStyQftntNm;

	/** set 외국인_체류시작일자 : frgnrStyBgnnDt */
	public java.lang.String frgnrStyBgnnDt;

	/** set 외국인_체류종료일자 : frgnrStyEndDt */
	public java.lang.String frgnrStyEndDt;

	/** set 사회보험 취득가족신고여부 : socrAqtnFamyYn */
	public java.lang.String socrAqtnFamyYn;

	/** set 사회보험 상실가족신고여부 : socrLssFamyYn */
	public java.lang.String socrLssFamyYn;

	/** set 사회보험취득_신고 작성일자 : famyAqtnLssDt */
	public java.lang.String famyAqtnLssDt;

	/** set 사회보험취득_고용_일련번호 : famyAqtnLssNum */
	public Long famyAqtnLssNum;

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

	/** set 이름 : hanNm */
	private java.lang.String hanNm;
	
	/** set resnRegnNum */
	private java.lang.String resnRegnNum;
	

	  /** secResnNum : 주민등록번호 원본*/
	    private java.lang.String secResnNum;

	    
	/** set natnCd */
	private java.lang.String natnCd;
	
	/** set natnNm */
	private java.lang.String natnNm;
	
	/** set useResnRegnNum */
	private java.lang.String useResnRegnNum;
	
	/** set useSecRegnNum */
	private java.lang.String useSecRegnNum;
	
	/** set emymtDivCd */
	private java.lang.String emymtDivCd;
	
	/** set emymtDivNm */
	private java.lang.String emymtDivNm;
	
	/** set deptCd */
	private java.lang.String deptCd;
	
	/** set deptNm */
	private java.lang.String deptNm;
	
	/** set typOccuCd */
	private java.lang.String typOccuCd;
	
	/** set typOccuNm */
	private java.lang.String typOccuNm;
	
	/** set pyspGrdeCd */
	private java.lang.String pyspGrdeCd;
	
	/** set pyspGrdeNm */
	private java.lang.String pyspGrdeNm;
	
	/** set businCd */
	private java.lang.String businCd;
	
	/** set businNm */
	private java.lang.String businNm;

	/** set dtilOccuClsDivCd */
	private java.lang.String dtilOccuClsDivCd;
	
	/** set dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;
	
	/** set dtilOccuClsDivNm */
	private java.lang.String dtilOccuClsDivNm;
	
	
	private Long socInsrAqtnEmymtNum;
	private java.lang.String soctyInsurCmptnDt;
	private java.lang.String socInsrLssCmptnDt;
	private Long socInsrLssEmymtNum;
	
	
	private java.lang.String famyQuftDivCd;
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

	public java.lang.String getFamyQuftDivCd() {
		return famyQuftDivCd;
	}

	public void setFamyQuftDivCd(java.lang.String famyQuftDivCd) {
		this.famyQuftDivCd = famyQuftDivCd;
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

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
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

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getNatnCd() {
		return natnCd;
	}

	public void setNatnCd(java.lang.String natnCd) {
		this.natnCd = natnCd;
	}

	public java.lang.String getNatnNm() {
		return natnNm;
	}

	public void setNatnNm(java.lang.String natnNm) {
		this.natnNm = natnNm;
	}

	public java.lang.String getUseResnRegnNum() {
		return useResnRegnNum;
	}

	public void setUseResnRegnNum(java.lang.String useResnRegnNum) {
		this.useResnRegnNum = useResnRegnNum;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUseSecRegnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the useSecRegnNum get
	 */
	public java.lang.String getUseSecRegnNum() {
		return useSecRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setUseSecRegnNum(java.lang.String useSecRegnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param useSecRegnNum the useSecRegnNum to set
	 */
	public void setUseSecRegnNum(java.lang.String useSecRegnNum) {
		this.useSecRegnNum = useSecRegnNum;
	}
	
	
}
