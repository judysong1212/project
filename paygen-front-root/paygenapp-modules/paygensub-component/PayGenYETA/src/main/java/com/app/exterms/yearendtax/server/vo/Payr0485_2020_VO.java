package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta1000VO.java
 * @Description : Yeta1000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0485_2020_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
	public Payr0485_2020_VO(String payItemCd, String payItemNm, String payDducSum){
		this.payItemCd= payItemCd;
		this.payItemNm= payItemNm;
		this.payDducSum= payDducSum;
	}
	
	public Payr0485_2020_VO(){
		
	}
	
	
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;
    
    /** set 급여항목코드 : payItemNm */
    private java.lang.String payItemNm;
    
    /** set 급여항목코드 : payDducSum */
    private java.lang.String payDducSum;
    
    
    /** set 회계계정코드 : accAccCd */
    private java.lang.String accAccCd;

    /** set 퇴직적용여부 : sevePayYn */
    private java.lang.String sevePayYn;

    /** set 연말정산_기부금코드 : yrtxDotnCd */
    private java.lang.String yrtxDotnCd;

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    private java.lang.String yrtxFreeDtyReduCd;

    /** set 기간제수당사용여부 : payrTermUseYn */
    private java.lang.String payrTermUseYn;

    /** set 수당공제출력여부 : extptDducDspyYn */
    private java.lang.String extptDducDspyYn;

    /** set 수당공제사용여부 : extptDducUseYn */
    private java.lang.String extptDducUseYn;

    /** set 수당공제정렬순서 : extptDducRngeOrd */
    private java.math.BigDecimal extptDducRngeOrd;

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

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public java.lang.String getAccAccCd() {
		return accAccCd;
	}

	public void setAccAccCd(java.lang.String accAccCd) {
		this.accAccCd = accAccCd;
	}

	public java.lang.String getSevePayYn() {
		return sevePayYn;
	}

	public void setSevePayYn(java.lang.String sevePayYn) {
		this.sevePayYn = sevePayYn;
	}

	public java.lang.String getYrtxDotnCd() {
		return yrtxDotnCd;
	}

	public void setYrtxDotnCd(java.lang.String yrtxDotnCd) {
		this.yrtxDotnCd = yrtxDotnCd;
	}

	public java.lang.String getYrtxFreeDtyReduCd() {
		return yrtxFreeDtyReduCd;
	}

	public void setYrtxFreeDtyReduCd(java.lang.String yrtxFreeDtyReduCd) {
		this.yrtxFreeDtyReduCd = yrtxFreeDtyReduCd;
	}

	public java.lang.String getPayrTermUseYn() {
		return payrTermUseYn;
	}

	public void setPayrTermUseYn(java.lang.String payrTermUseYn) {
		this.payrTermUseYn = payrTermUseYn;
	}

	public java.lang.String getExtptDducDspyYn() {
		return extptDducDspyYn;
	}

	public void setExtptDducDspyYn(java.lang.String extptDducDspyYn) {
		this.extptDducDspyYn = extptDducDspyYn;
	}

	public java.lang.String getExtptDducUseYn() {
		return extptDducUseYn;
	}

	public void setExtptDducUseYn(java.lang.String extptDducUseYn) {
		this.extptDducUseYn = extptDducUseYn;
	}

	public java.math.BigDecimal getExtptDducRngeOrd() {
		return extptDducRngeOrd;
	}

	public void setExtptDducRngeOrd(java.math.BigDecimal extptDducRngeOrd) {
		this.extptDducRngeOrd = extptDducRngeOrd;
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

	public java.lang.String getPayItemNm() {
		return payItemNm;
	}

	public void setPayItemNm(java.lang.String payItemNm) {
		this.payItemNm = payItemNm;
	}

	public java.lang.String getPayDducSum() {
		return payDducSum;
	}

	public void setPayDducSum(java.lang.String payDducSum) {
		this.payDducSum = payDducSum;
	}
    
    
    
}
