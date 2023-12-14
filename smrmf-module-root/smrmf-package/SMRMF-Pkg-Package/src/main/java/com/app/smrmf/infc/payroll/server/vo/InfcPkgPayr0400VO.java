package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0400VO.java
 * @Description : Payr0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0400VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */
    private java.lang.String typOccuGrdeMppgCtnt;

    /** set 직종_등급맵핑삭제여부 : typOccuGrdeMppgDelYn */
    private java.lang.String typOccuGrdeMppgDelYn;

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

    /** set null : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set commCd : commCd */
    private java.lang.String commCd;
    
    
    
	/**
	 * Comment : 
	 * @fn java.lang.String getCommCd()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the commCd get
	 */
	public java.lang.String getCommCd() {
		return commCd;
	}

	/**
	 * Comment : 
	 *@fn void setCommCd(java.lang.String commCd)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param commCd the commCd to set
	 */
	public void setCommCd(java.lang.String commCd) {
		this.commCd = commCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
		return typOccuGrdeMppgSeilNum;
	}

	public void setTypOccuGrdeMppgSeilNum(
			java.math.BigDecimal typOccuGrdeMppgSeilNum) {
		this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
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

	public java.lang.String getTypOccuGrdeMppgCtnt() {
		return typOccuGrdeMppgCtnt;
	}

	public void setTypOccuGrdeMppgCtnt(java.lang.String typOccuGrdeMppgCtnt) {
		this.typOccuGrdeMppgCtnt = typOccuGrdeMppgCtnt;
	}

	public java.lang.String getTypOccuGrdeMppgDelYn() {
		return typOccuGrdeMppgDelYn;
	}

	public void setTypOccuGrdeMppgDelYn(java.lang.String typOccuGrdeMppgDelYn) {
		this.typOccuGrdeMppgDelYn = typOccuGrdeMppgDelYn;
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

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}
    
}
