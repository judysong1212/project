package com.app.smrmf.infc.yearendtax.server.vo.yeta2017;

import java.io.Serializable;

/**
 * @Class Name : Ye162510VO.java
 * @Description : Ye162510VO.class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe162510VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 연말정산귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set 월세일련번호 : mnthRntQntySeilNum */
    private java.math.BigDecimal mnthRntQntySeilNum;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 월세_임대인성명 : mnthRnttyLehdrNm */
    private java.lang.String mnthRnttyLehdrNm;

    /** set 월세_주민번호 : mnthRnttyBurRgsum */
    private java.lang.String mnthRnttyBurRgsum;

    /** set 월세_주택유형코드 : mnthRnttyHusFrmCd */
    private java.lang.String mnthRnttyHusFrmCd;

    /** set 월세주택계약면적 : mnthRnttyHusCnttArea */
    private java.lang.String mnthRnttyHusCnttArea;

    /** set 월세_계약서상주소 : mnthRnttyRntlAddr */
    private java.lang.String mnthRnttyRntlAddr;

    /** set 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
    private java.lang.String mnthRnttyRntlBgnnDt;

    /** set 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
    private java.lang.String mnthRnttyRntlEndDt;

    /** set 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
    private java.math.BigDecimal mnthRnttyYrlyMnthSum;

    /** set 월세_월세세액공제금액 : mnthRnttyTxDducSum */
    private java.math.BigDecimal mnthRnttyTxDducSum;
    
    private java.math.BigDecimal mnthRnttyYrlyTgtSum;

    
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
    
    /** set 전자파일이관여부 : ectnFlTrnrCtlYn */
    private java.lang.String ectnFlTrnrCtlYn;

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.math.BigDecimal getMnthRntQntySeilNum() {
		return mnthRntQntySeilNum;
	}

	public void setMnthRntQntySeilNum(java.math.BigDecimal mnthRntQntySeilNum) {
		this.mnthRntQntySeilNum = mnthRntQntySeilNum;
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

	public java.lang.String getMnthRnttyLehdrNm() {
		return mnthRnttyLehdrNm;
	}

	public void setMnthRnttyLehdrNm(java.lang.String mnthRnttyLehdrNm) {
		this.mnthRnttyLehdrNm = mnthRnttyLehdrNm;
	}

	public java.lang.String getMnthRnttyBurRgsum() {
		return mnthRnttyBurRgsum;
	}

	public void setMnthRnttyBurRgsum(java.lang.String mnthRnttyBurRgsum) {
		this.mnthRnttyBurRgsum = mnthRnttyBurRgsum;
	}

	public java.lang.String getMnthRnttyHusFrmCd() {
		return mnthRnttyHusFrmCd;
	}

	public void setMnthRnttyHusFrmCd(java.lang.String mnthRnttyHusFrmCd) {
		this.mnthRnttyHusFrmCd = mnthRnttyHusFrmCd;
	}

	public java.lang.String getMnthRnttyHusCnttArea() {
		return mnthRnttyHusCnttArea;
	}

	public void setMnthRnttyHusCnttArea(java.lang.String mnthRnttyHusCnttArea) {
		this.mnthRnttyHusCnttArea = mnthRnttyHusCnttArea;
	}

	public java.lang.String getMnthRnttyRntlAddr() {
		return mnthRnttyRntlAddr;
	}

	public void setMnthRnttyRntlAddr(java.lang.String mnthRnttyRntlAddr) {
		this.mnthRnttyRntlAddr = mnthRnttyRntlAddr;
	}

	public java.lang.String getMnthRnttyRntlBgnnDt() {
		return mnthRnttyRntlBgnnDt;
	}

	public void setMnthRnttyRntlBgnnDt(java.lang.String mnthRnttyRntlBgnnDt) {
		this.mnthRnttyRntlBgnnDt = mnthRnttyRntlBgnnDt;
	}

	public java.lang.String getMnthRnttyRntlEndDt() {
		return mnthRnttyRntlEndDt;
	}

	public void setMnthRnttyRntlEndDt(java.lang.String mnthRnttyRntlEndDt) {
		this.mnthRnttyRntlEndDt = mnthRnttyRntlEndDt;
	}

	public java.math.BigDecimal getMnthRnttyYrlyMnthSum() {
		return mnthRnttyYrlyMnthSum;
	}

	public void setMnthRnttyYrlyMnthSum(java.math.BigDecimal mnthRnttyYrlyMnthSum) {
		this.mnthRnttyYrlyMnthSum = mnthRnttyYrlyMnthSum;
	}

	public java.math.BigDecimal getMnthRnttyTxDducSum() {
		return mnthRnttyTxDducSum;
	}

	public void setMnthRnttyTxDducSum(java.math.BigDecimal mnthRnttyTxDducSum) {
		this.mnthRnttyTxDducSum = mnthRnttyTxDducSum;
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

	public java.lang.String getEctnFlTrnrCtlYn() {
		return ectnFlTrnrCtlYn;
	}

	public void setEctnFlTrnrCtlYn(java.lang.String ectnFlTrnrCtlYn) {
		this.ectnFlTrnrCtlYn = ectnFlTrnrCtlYn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getMnthRnttyYrlyTgtSum()
	 * @brief date:2018 2018. 2. 10. user:atres
	 * @return the mnthRnttyYrlyTgtSum get
	 */
	public java.math.BigDecimal getMnthRnttyYrlyTgtSum() {
		return mnthRnttyYrlyTgtSum;
	}

	/**
	 * Comment : 
	 *@fn void setMnthRnttyYrlyTgtSum(java.math.BigDecimal mnthRnttyYrlyTgtSum)
	 *@brief date:2018 2018. 2. 10. user:atres
	 *@param mnthRnttyYrlyTgtSum the mnthRnttyYrlyTgtSum to set
	 */
	public void setMnthRnttyYrlyTgtSum(java.math.BigDecimal mnthRnttyYrlyTgtSum) {
		this.mnthRnttyYrlyTgtSum = mnthRnttyYrlyTgtSum;
	}
    
    
}
