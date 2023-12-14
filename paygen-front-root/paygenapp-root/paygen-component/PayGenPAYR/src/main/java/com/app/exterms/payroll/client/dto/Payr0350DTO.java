package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0350VO.java
 * @Description : Payr0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0350DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 소급년도 : reattyYr */
    private java.lang.String reattyYr;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    private java.lang.String reattyStpDsptyNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 소급적용금액_1월 : reattyApptnSumJan */
    private java.math.BigDecimal reattyApptnSumJan;

    /** set 소급적용금액_2월 : reattyApptnSumFeb */
    private java.math.BigDecimal reattyApptnSumFeb;

    /** set 소급적용금액_3월 : reattyApptnSumMar */
    private java.math.BigDecimal reattyApptnSumMar;

    /** set 소급적용금액_4월 : reattyApptnSumApr */
    private java.math.BigDecimal reattyApptnSumApr;

    /** set 소급적용금액_5월 : reattyApptnSumMay */
    private java.math.BigDecimal reattyApptnSumMay;

    /** set 소급적용금액_6월 : reattyApptnSumJun */
    private java.math.BigDecimal reattyApptnSumJun;

    /** set 소급적용금액_7월 : reattyApptnSumJul */
    private java.math.BigDecimal reattyApptnSumJul;

    /** set 소급적용금액_8월 : reattyApptnSumAug */
    private java.math.BigDecimal reattyApptnSumAug;

    /** set 소급적용금액_9월 : reattyApptnSumSep */
    private java.math.BigDecimal reattyApptnSumSep;

    /** set 소급적용금액_10월 : reattyApptnSumOct */
    private java.math.BigDecimal reattyApptnSumOct;

    /** set 소급적용금액_11월 : reattyApptnSumNov */
    private java.math.BigDecimal reattyApptnSumNov;

    /** set 소급적용금액_12월 : reattyApptnSumDec */
    private java.math.BigDecimal reattyApptnSumDec;

    /** set 소급적용금액합계 : reattyApptnSumAggr */
    private java.math.BigDecimal reattyApptnSumAggr;

    /** set 소급항목비고내용 : reattyItemNoteCtnt */
    private java.lang.String reattyItemNoteCtnt;

    /** set 소급적용년월 : reattyPymtYrMnth */
    private java.lang.String reattyPymtYrMnth;

    /** set 소급지급처리여부 : reattyPymtPrcsYn */
    private java.lang.String reattyPymtPrcsYn;

    /** set 소급마감일자 : reattyDdlneDt */
    private java.lang.String reattyDdlneDt;

    /** set 소급마감여부 : reattyDdlneYn */
    private java.lang.String reattyDdlneYn;

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
    

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
private java.lang.String dtilOcclsApptnUcstCd;

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
private Long dtilOcclsApptnUcstSum;



	/**
 * Comment : 
 * @fn java.lang.String getDtilOcclsApptnUcstCd()
 * @brief date:2016 2016. 12. 13. user:atres-pc
 * @return the dtilOcclsApptnUcstCd get
 */
public java.lang.String getDtilOcclsApptnUcstCd() {
	return dtilOcclsApptnUcstCd;
}

/**
 * Comment : 
 *@fn void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd)
 *@brief date:2016 2016. 12. 13. user:atres-pc
 *@param dtilOcclsApptnUcstCd the dtilOcclsApptnUcstCd to set
 */
public void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd) {
	this.dtilOcclsApptnUcstCd = dtilOcclsApptnUcstCd;
}

/**
 * Comment : 
 * @fn Long getDtilOcclsApptnUcstSum()
 * @brief date:2016 2016. 12. 13. user:atres-pc
 * @return the dtilOcclsApptnUcstSum get
 */
public Long getDtilOcclsApptnUcstSum() {
	return dtilOcclsApptnUcstSum;
}

/**
 * Comment : 
 *@fn void setDtilOcclsApptnUcstSum(Long dtilOcclsApptnUcstSum)
 *@brief date:2016 2016. 12. 13. user:atres-pc
 *@param dtilOcclsApptnUcstSum the dtilOcclsApptnUcstSum to set
 */
public void setDtilOcclsApptnUcstSum(Long dtilOcclsApptnUcstSum) {
	this.dtilOcclsApptnUcstSum = dtilOcclsApptnUcstSum;
}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getReattyYr() {
		return reattyYr;
	}

	public void setReattyYr(java.lang.String reattyYr) {
		this.reattyYr = reattyYr;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getReattyStpDsptyNum() {
		return reattyStpDsptyNum;
	}

	public void setReattyStpDsptyNum(java.lang.String reattyStpDsptyNum) {
		this.reattyStpDsptyNum = reattyStpDsptyNum;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.math.BigDecimal getReattyApptnSumJan() {
		return reattyApptnSumJan;
	}

	public void setReattyApptnSumJan(java.math.BigDecimal reattyApptnSumJan) {
		this.reattyApptnSumJan = reattyApptnSumJan;
	}

	public java.math.BigDecimal getReattyApptnSumFeb() {
		return reattyApptnSumFeb;
	}

	public void setReattyApptnSumFeb(java.math.BigDecimal reattyApptnSumFeb) {
		this.reattyApptnSumFeb = reattyApptnSumFeb;
	}

	public java.math.BigDecimal getReattyApptnSumMar() {
		return reattyApptnSumMar;
	}

	public void setReattyApptnSumMar(java.math.BigDecimal reattyApptnSumMar) {
		this.reattyApptnSumMar = reattyApptnSumMar;
	}

	public java.math.BigDecimal getReattyApptnSumApr() {
		return reattyApptnSumApr;
	}

	public void setReattyApptnSumApr(java.math.BigDecimal reattyApptnSumApr) {
		this.reattyApptnSumApr = reattyApptnSumApr;
	}

	public java.math.BigDecimal getReattyApptnSumMay() {
		return reattyApptnSumMay;
	}

	public void setReattyApptnSumMay(java.math.BigDecimal reattyApptnSumMay) {
		this.reattyApptnSumMay = reattyApptnSumMay;
	}

	public java.math.BigDecimal getReattyApptnSumJun() {
		return reattyApptnSumJun;
	}

	public void setReattyApptnSumJun(java.math.BigDecimal reattyApptnSumJun) {
		this.reattyApptnSumJun = reattyApptnSumJun;
	}

	public java.math.BigDecimal getReattyApptnSumJul() {
		return reattyApptnSumJul;
	}

	public void setReattyApptnSumJul(java.math.BigDecimal reattyApptnSumJul) {
		this.reattyApptnSumJul = reattyApptnSumJul;
	}

	public java.math.BigDecimal getReattyApptnSumAug() {
		return reattyApptnSumAug;
	}

	public void setReattyApptnSumAug(java.math.BigDecimal reattyApptnSumAug) {
		this.reattyApptnSumAug = reattyApptnSumAug;
	}

	public java.math.BigDecimal getReattyApptnSumSep() {
		return reattyApptnSumSep;
	}

	public void setReattyApptnSumSep(java.math.BigDecimal reattyApptnSumSep) {
		this.reattyApptnSumSep = reattyApptnSumSep;
	}

	public java.math.BigDecimal getReattyApptnSumOct() {
		return reattyApptnSumOct;
	}

	public void setReattyApptnSumOct(java.math.BigDecimal reattyApptnSumOct) {
		this.reattyApptnSumOct = reattyApptnSumOct;
	}

	public java.math.BigDecimal getReattyApptnSumNov() {
		return reattyApptnSumNov;
	}

	public void setReattyApptnSumNov(java.math.BigDecimal reattyApptnSumNov) {
		this.reattyApptnSumNov = reattyApptnSumNov;
	}

	public java.math.BigDecimal getReattyApptnSumDec() {
		return reattyApptnSumDec;
	}

	public void setReattyApptnSumDec(java.math.BigDecimal reattyApptnSumDec) {
		this.reattyApptnSumDec = reattyApptnSumDec;
	}

	public java.math.BigDecimal getReattyApptnSumAggr() {
		return reattyApptnSumAggr;
	}

	public void setReattyApptnSumAggr(java.math.BigDecimal reattyApptnSumAggr) {
		this.reattyApptnSumAggr = reattyApptnSumAggr;
	}

	public java.lang.String getReattyItemNoteCtnt() {
		return reattyItemNoteCtnt;
	}

	public void setReattyItemNoteCtnt(java.lang.String reattyItemNoteCtnt) {
		this.reattyItemNoteCtnt = reattyItemNoteCtnt;
	}

	public java.lang.String getReattyPymtYrMnth() {
		return reattyPymtYrMnth;
	}

	public void setReattyPymtYrMnth(java.lang.String reattyPymtYrMnth) {
		this.reattyPymtYrMnth = reattyPymtYrMnth;
	}

	public java.lang.String getReattyPymtPrcsYn() {
		return reattyPymtPrcsYn;
	}

	public void setReattyPymtPrcsYn(java.lang.String reattyPymtPrcsYn) {
		this.reattyPymtPrcsYn = reattyPymtPrcsYn;
	}

	public java.lang.String getReattyDdlneDt() {
		return reattyDdlneDt;
	}

	public void setReattyDdlneDt(java.lang.String reattyDdlneDt) {
		this.reattyDdlneDt = reattyDdlneDt;
	}

	public java.lang.String getReattyDdlneYn() {
		return reattyDdlneYn;
	}

	public void setReattyDdlneYn(java.lang.String reattyDdlneYn) {
		this.reattyDdlneYn = reattyDdlneYn;
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
