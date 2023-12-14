package com.app.exterms.personal.server.vo;

/**
 * @Class Name : Psnl0120VO.java
 * @Description : Psnl0120 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0120VO extends Psnl0120DefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 교육일련번호 : eduSeilNum */
    private java.math.BigDecimal eduSeilNum;

    /** set 교육시작일자 : eduBgnnDt */
    private java.lang.String eduBgnnDt;

    /** set 교육종료일자 : eduEndDt */
    private java.lang.String eduEndDt;

    /** set 교육이수시간 : eduCmpteTm */
    private java.lang.String eduCmpteTm;

    /** set 교육종류명 : eduKndNm */
    private java.lang.String eduKndNm;

    /** set 교육기관명 : eduIstutNm */
    private java.lang.String eduIstutNm;

    /** set 교육비고내용 : eduNoteCtnt */
    private java.lang.String eduNoteCtnt;

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
    
    /** set 교육시작시간 : eduBgnnTm */
    private java.lang.String eduBgnnTm;

    /** set 교육종료시간 : eduEndTm */
    private java.lang.String eduEndTm;
    
    
    public java.lang.String getEduBgnnTm() {
		return eduBgnnTm;
	}

	public void setEduBgnnTm(java.lang.String eduBgnnTm) {
		this.eduBgnnTm = eduBgnnTm;
	}

	public java.lang.String getEduEndTm() {
		return eduEndTm;
	}

	public void setEduEndTm(java.lang.String eduEndTm) {
		this.eduEndTm = eduEndTm;
	}

	// --- insert시 조건절에서 사용함... 그래서  추가
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
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

	public java.math.BigDecimal getEduSeilNum() {
		return eduSeilNum;
	}

	public void setEduSeilNum(java.math.BigDecimal eduSeilNum) {
		this.eduSeilNum = eduSeilNum;
	}

	public java.lang.String getEduBgnnDt() {
		return eduBgnnDt;
	}

	public void setEduBgnnDt(java.lang.String eduBgnnDt) {
		this.eduBgnnDt = eduBgnnDt;
	}

	public java.lang.String getEduEndDt() {
		return eduEndDt;
	}

	public void setEduEndDt(java.lang.String eduEndDt) {
		this.eduEndDt = eduEndDt;
	}

	public java.lang.String getEduCmpteTm() {
		return eduCmpteTm;
	}

	public void setEduCmpteTm(java.lang.String eduCmpteTm) {
		this.eduCmpteTm = eduCmpteTm;
	}

	public java.lang.String getEduKndNm() {
		return eduKndNm;
	}

	public void setEduKndNm(java.lang.String eduKndNm) {
		this.eduKndNm = eduKndNm;
	}

	public java.lang.String getEduIstutNm() {
		return eduIstutNm;
	}

	public void setEduIstutNm(java.lang.String eduIstutNm) {
		this.eduIstutNm = eduIstutNm;
	}

	public java.lang.String getEduNoteCtnt() {
		return eduNoteCtnt;
	}

	public void setEduNoteCtnt(java.lang.String eduNoteCtnt) {
		this.eduNoteCtnt = eduNoteCtnt;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
    
}
