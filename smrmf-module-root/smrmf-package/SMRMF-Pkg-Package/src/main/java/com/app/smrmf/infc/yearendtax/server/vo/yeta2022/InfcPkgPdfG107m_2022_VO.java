package com.app.smrmf.infc.yearendtax.server.vo.yeta2022;

import java.io.Serializable;

/**
 * @Class Name : PdfG306mVO.java
 * @Description : PdfG306m VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPdfG107m_2022_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;


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
    
    
    private java.lang.String resid;
    
    private java.math.BigDecimal cardAmtSum3;
    
    private java.math.BigDecimal cardAmtSum47;

	private java.math.BigDecimal cardAmtSumOth;
	
	
	private java.math.BigDecimal cardTdmrSum3;
	
	private java.math.BigDecimal cardTdmrSum47;
	
	private java.math.BigDecimal cardTdmrSumOth;
	
	
	private java.math.BigDecimal cardPbtSum3;
	
	private java.math.BigDecimal cardPbtSum47;
	
	private java.math.BigDecimal cardPbtSumOth;
	
	
	private java.math.BigDecimal cardBookSum3;
	
	private java.math.BigDecimal cardBookSum47;
	
	private java.math.BigDecimal cardBookSumOth;
	
	
	//2021연말정산_추가
	private java.math.BigDecimal totPreYearSum;
	
	private java.math.BigDecimal totCurrYearSum;
	
	//2022연말정산_추가
	private java.math.BigDecimal tdmrTotPreYearSum;
	
	private java.math.BigDecimal tdmrTotCurrYearSum;
	
	private java.math.BigDecimal gnrlSum;
	
	private java.math.BigDecimal tdmrSum;
	
	private java.math.BigDecimal trpSum;
	
	private java.math.BigDecimal isldSum;
	
	private java.math.BigDecimal totSum;
	
	private java.math.BigDecimal tfhyGnrlSum;
	
	private java.math.BigDecimal tfhyTdmrSum;
	
	private java.math.BigDecimal tfhyTrpSum;
	
	private java.math.BigDecimal tfhyIsldSum;
	
	private java.math.BigDecimal tfhyTotSum;
	
	private java.math.BigDecimal shfyGnrlSum;
	
	private java.math.BigDecimal shfyTdmrSum;
	
	private java.math.BigDecimal shfyTrpSum;
	
	private java.math.BigDecimal shfyIsldSum;
	
	private java.math.BigDecimal shfyTotSum;
	
	
	
	
	
	
	//2022연말정산_추가
	
	public java.math.BigDecimal getTdmrTotPreYearSum() {
		return tdmrTotPreYearSum;
	}

	public void setTdmrTotPreYearSum(java.math.BigDecimal tdmrTotPreYearSum) {
		this.tdmrTotPreYearSum = tdmrTotPreYearSum;
	}

	public java.math.BigDecimal getTdmrTotCurrYearSum() {
		return tdmrTotCurrYearSum;
	}

	public void setTdmrTotCurrYearSum(java.math.BigDecimal tdmrTotCurrYearSum) {
		this.tdmrTotCurrYearSum = tdmrTotCurrYearSum;
	}

	public java.math.BigDecimal getGnrlSum() {
		return gnrlSum;
	}

	public void setGnrlSum(java.math.BigDecimal gnrlSum) {
		this.gnrlSum = gnrlSum;
	}

	public java.math.BigDecimal getTdmrSum() {
		return tdmrSum;
	}

	public void setTdmrSum(java.math.BigDecimal tdmrSum) {
		this.tdmrSum = tdmrSum;
	}

	public java.math.BigDecimal getTrpSum() {
		return trpSum;
	}

	public void setTrpSum(java.math.BigDecimal trpSum) {
		this.trpSum = trpSum;
	}

	public java.math.BigDecimal getIsldSum() {
		return isldSum;
	}

	public void setIsldSum(java.math.BigDecimal isldSum) {
		this.isldSum = isldSum;
	}

	public java.math.BigDecimal getTotSum() {
		return totSum;
	}

	public void setTotSum(java.math.BigDecimal totSum) {
		this.totSum = totSum;
	}

	public java.math.BigDecimal getTfhyGnrlSum() {
		return tfhyGnrlSum;
	}

	public void setTfhyGnrlSum(java.math.BigDecimal tfhyGnrlSum) {
		this.tfhyGnrlSum = tfhyGnrlSum;
	}

	public java.math.BigDecimal getTfhyTdmrSum() {
		return tfhyTdmrSum;
	}

	public void setTfhyTdmrSum(java.math.BigDecimal tfhyTdmrSum) {
		this.tfhyTdmrSum = tfhyTdmrSum;
	}

	public java.math.BigDecimal getTfhyTrpSum() {
		return tfhyTrpSum;
	}

	public void setTfhyTrpSum(java.math.BigDecimal tfhyTrpSum) {
		this.tfhyTrpSum = tfhyTrpSum;
	}

	public java.math.BigDecimal getTfhyIsldSum() {
		return tfhyIsldSum;
	}

	public void setTfhyIsldSum(java.math.BigDecimal tfhyIsldSum) {
		this.tfhyIsldSum = tfhyIsldSum;
	}

	public java.math.BigDecimal getTfhyTotSum() {
		return tfhyTotSum;
	}

	public void setTfhyTotSum(java.math.BigDecimal tfhyTotSum) {
		this.tfhyTotSum = tfhyTotSum;
	}

	public java.math.BigDecimal getShfyGnrlSum() {
		return shfyGnrlSum;
	}

	public void setShfyGnrlSum(java.math.BigDecimal shfyGnrlSum) {
		this.shfyGnrlSum = shfyGnrlSum;
	}

	public java.math.BigDecimal getShfyTdmrSum() {
		return shfyTdmrSum;
	}

	public void setShfyTdmrSum(java.math.BigDecimal shfyTdmrSum) {
		this.shfyTdmrSum = shfyTdmrSum;
	}

	public java.math.BigDecimal getShfyTrpSum() {
		return shfyTrpSum;
	}

	public void setShfyTrpSum(java.math.BigDecimal shfyTrpSum) {
		this.shfyTrpSum = shfyTrpSum;
	}

	public java.math.BigDecimal getShfyIsldSum() {
		return shfyIsldSum;
	}

	public void setShfyIsldSum(java.math.BigDecimal shfyIsldSum) {
		this.shfyIsldSum = shfyIsldSum;
	}

	public java.math.BigDecimal getShfyTotSum() {
		return shfyTotSum;
	}

	public void setShfyTotSum(java.math.BigDecimal shfyTotSum) {
		this.shfyTotSum = shfyTotSum;
	}
	
	
	//2021연말정산_추가
	public java.math.BigDecimal getTotPreYearSum() {
		return totPreYearSum;
	}

	public void setTotPreYearSum(java.math.BigDecimal totPreYearSum) {
		this.totPreYearSum = totPreYearSum;
	}

	public java.math.BigDecimal getTotCurrYearSum() {
		return totCurrYearSum;
	}

	public void setTotCurrYearSum(java.math.BigDecimal totCurrYearSum) {
		this.totCurrYearSum = totCurrYearSum;
	}
	
	
	
	
	
	
	

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

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

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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
	
	public java.lang.String getResid() {
		return resid;
	}

	public void setResid(java.lang.String resid) {
		this.resid = resid;
	}

	public java.math.BigDecimal getCardAmtSum3() {
		return cardAmtSum3;
	}

	public void setCardAmtSum3(java.math.BigDecimal cardAmtSum3) {
		this.cardAmtSum3 = cardAmtSum3;
	}

	public java.math.BigDecimal getCardAmtSum47() {
		return cardAmtSum47;
	}

	public void setCardAmtSum47(java.math.BigDecimal cardAmtSum47) {
		this.cardAmtSum47 = cardAmtSum47;
	}

	public java.math.BigDecimal getCardAmtSumOth() {
		return cardAmtSumOth;
	}

	public void setCardAmtSumOth(java.math.BigDecimal cardAmtSumOth) {
		this.cardAmtSumOth = cardAmtSumOth;
	}

	public java.math.BigDecimal getCardTdmrSum3() {
		return cardTdmrSum3;
	}

	public void setCardTdmrSum3(java.math.BigDecimal cardTdmrSum3) {
		this.cardTdmrSum3 = cardTdmrSum3;
	}

	public java.math.BigDecimal getCardTdmrSum47() {
		return cardTdmrSum47;
	}

	public void setCardTdmrSum47(java.math.BigDecimal cardTdmrSum47) {
		this.cardTdmrSum47 = cardTdmrSum47;
	}

	public java.math.BigDecimal getCardTdmrSumOth() {
		return cardTdmrSumOth;
	}

	public void setCardTdmrSumOth(java.math.BigDecimal cardTdmrSumOth) {
		this.cardTdmrSumOth = cardTdmrSumOth;
	}

	public java.math.BigDecimal getCardPbtSum3() {
		return cardPbtSum3;
	}

	public void setCardPbtSum3(java.math.BigDecimal cardPbtSum3) {
		this.cardPbtSum3 = cardPbtSum3;
	}

	public java.math.BigDecimal getCardPbtSum47() {
		return cardPbtSum47;
	}

	public void setCardPbtSum47(java.math.BigDecimal cardPbtSum47) {
		this.cardPbtSum47 = cardPbtSum47;
	}

	public java.math.BigDecimal getCardPbtSumOth() {
		return cardPbtSumOth;
	}

	public void setCardPbtSumOth(java.math.BigDecimal cardPbtSumOth) {
		this.cardPbtSumOth = cardPbtSumOth;
	}

	public java.math.BigDecimal getCardBookSum3() {
		return cardBookSum3;
	}

	public void setCardBookSum3(java.math.BigDecimal cardBookSum3) {
		this.cardBookSum3 = cardBookSum3;
	}

	public java.math.BigDecimal getCardBookSum47() {
		return cardBookSum47;
	}

	public void setCardBookSum47(java.math.BigDecimal cardBookSum47) {
		this.cardBookSum47 = cardBookSum47;
	}

	public java.math.BigDecimal getCardBookSumOth() {
		return cardBookSumOth;
	}

	public void setCardBookSumOth(java.math.BigDecimal cardBookSumOth) {
		this.cardBookSumOth = cardBookSumOth;
	}
    
}
