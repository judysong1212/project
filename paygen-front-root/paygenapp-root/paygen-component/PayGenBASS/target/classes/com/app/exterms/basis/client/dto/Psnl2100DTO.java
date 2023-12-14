package com.app.exterms.basis.client.dto;

import java.io.Serializable;



public class Psnl2100DTO implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	public Psnl2100DTO(){}
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 휴가일수일련번호 : hodyNumDysSeilNum */
	private Long hodyNumDysSeilNum;

	 /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

	/** set 직종코드 : typOccuCd */
	private java.lang.String typOccuCd;

	/** set 호봉등급코드 : pyspGrdeCd */
	private java.lang.String pyspGrdeCd;

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	private java.lang.String dtilOccuClsDivCd;

	/** set 휴가일수이상 : hodyNumDysOvr */
	private Long hodyNumDysOvr;

	/** set 휴가일수미만 : hodyNumDysUdr */
	private Long hodyNumDysUdr;

	/** set 휴가일수유형코드 : hodyNumDysFrmCd */
	private java.lang.String hodyNumDysFrmCd;

	/** set 휴가일수 : hodyNumDys */
	private Long hodyNumDys;

	/** set 휴가일수율 : hodyNumDysRate */
	private Long hodyNumDysRate;

	/** set 휴가일수시작일자 : hodyNumDysBgnnDt */
	private java.lang.String hodyNumDysBgnnDt;

	/** set 휴가일수종료일자 : hodyNumDysEndDt */
	private java.lang.String hodyNumDysEndDt;

	/** set 휴가일수사용여부 : hodyNumDysUseYn */
	private Boolean hodyNumDysUseYn;

	/** set 휴가일수비고내용 : hodyNumDysNoteCtnt */
	private java.lang.String hodyNumDysNoteCtnt;

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
	
	/** set 기본 직종코드 : basicTypOccuCd */
	private java.lang.String basicTypOccuCd;
	
	/** set 기본 직종세코드 : basicDtilOccuClsDivCd */
	private java.lang.String basicDtilOccuClsDivCd;
	
	/** set 대상 직종코드 : targetTypOccuCd */
	private java.lang.String targetTypOccuCd;
	
	/** set 대상 직종세코드 : targetDtilOccuClsDivCd */
	private java.lang.String targetDtilOccuClsDivCd;
	
	/** set 적용일자 : applicationDate */
	private java.lang.String applicationDate;
	
	/**
	 * Comment : 직종세 통합코드 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 22, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 22, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public Long getHodyNumDysSeilNum() {
		return hodyNumDysSeilNum;
	}

	public void setHodyNumDysSeilNum(Long hodyNumDysSeilNum) {
		this.hodyNumDysSeilNum = hodyNumDysSeilNum;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public Long getHodyNumDysOvr() {
		return hodyNumDysOvr;
	}

	public void setHodyNumDysOvr(Long hodyNumDysOvr) {
		this.hodyNumDysOvr = hodyNumDysOvr;
	}

	public Long getHodyNumDysUdr() {
		return hodyNumDysUdr;
	}

	public void setHodyNumDysUdr(Long hodyNumDysUdr) {
		this.hodyNumDysUdr = hodyNumDysUdr;
	}

	public java.lang.String getHodyNumDysFrmCd() {
		return hodyNumDysFrmCd;
	}

	public void setHodyNumDysFrmCd(java.lang.String hodyNumDysFrmCd) {
		this.hodyNumDysFrmCd = hodyNumDysFrmCd;
	}

	public Long getHodyNumDys() {
		return hodyNumDys;
	}

	public void setHodyNumDys(Long hodyNumDys) {
		this.hodyNumDys = hodyNumDys;
	}

	public Long getHodyNumDysRate() {
		return hodyNumDysRate;
	}

	public void setHodyNumDysRate(Long hodyNumDysRate) {
		this.hodyNumDysRate = hodyNumDysRate;
	}

	public java.lang.String getHodyNumDysBgnnDt() {
		return hodyNumDysBgnnDt;
	}

	public void setHodyNumDysBgnnDt(java.lang.String hodyNumDysBgnnDt) {
		this.hodyNumDysBgnnDt = hodyNumDysBgnnDt;
	}

	public java.lang.String getHodyNumDysEndDt() {
		return hodyNumDysEndDt;
	}

	public void setHodyNumDysEndDt(java.lang.String hodyNumDysEndDt) {
		this.hodyNumDysEndDt = hodyNumDysEndDt;
	}

	public Boolean getHodyNumDysUseYn() {
		return hodyNumDysUseYn;
	}

	public void setHodyNumDysUseYn(Boolean hodyNumDysUseYn) {
		this.hodyNumDysUseYn = hodyNumDysUseYn;
	}

	public java.lang.String getHodyNumDysNoteCtnt() {
		return hodyNumDysNoteCtnt;
	}

	public void setHodyNumDysNoteCtnt(java.lang.String hodyNumDysNoteCtnt) {
		this.hodyNumDysNoteCtnt = hodyNumDysNoteCtnt;
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
	
	public java.lang.String getBasicTypOccuCd() {
		return basicTypOccuCd;
	}

	public void setBasicTypOccuCd(java.lang.String basicTypOccuCd) {
		this.basicTypOccuCd = basicTypOccuCd;
	}

	public java.lang.String getBasicDtilOccuClsDivCd() {
		return basicDtilOccuClsDivCd;
	}

	public void setBasicDtilOccuClsDivCd(java.lang.String basicDtilOccuClsDivCd) {
		this.basicDtilOccuClsDivCd = basicDtilOccuClsDivCd;
	}

	public java.lang.String getTargetTypOccuCd() {
		return targetTypOccuCd;
	}

	public void setTargetTypOccuCd(java.lang.String targetTypOccuCd) {
		this.targetTypOccuCd = targetTypOccuCd;
	}

	public java.lang.String getTargetDtilOccuClsDivCd() {
		return targetDtilOccuClsDivCd;
	}

	public void setTargetDtilOccuClsDivCd(java.lang.String targetDtilOccuClsDivCd) {
		this.targetDtilOccuClsDivCd = targetDtilOccuClsDivCd;
	}

	public java.lang.String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(java.lang.String applicationDate) {
		this.applicationDate = applicationDate;
	}
}
