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
public class InfcPkgPdfG307m_2022_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 직불카드일련번호 : dirCardSeilNum */
    private java.math.BigDecimal dirCardSeilNum;

    /** set 직불카드_공제대상월 : dirCardAmtMn */
    private java.lang.String dirCardAmtMn;

    /** set 직불카드월별공제대상금액 : dirCardMmAmt */
    private java.math.BigDecimal dirCardMmAmt;

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
    
    //2022연말정산_추가
    private java.math.BigDecimal totPreYearSum;
    
    private java.math.BigDecimal totCurrYearSum;
    
    private java.lang.String resid;
    
    
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

	public java.lang.String getResid() {
		return resid;
	}

	public void setResid(java.lang.String resid) {
		this.resid = resid;
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

	public java.math.BigDecimal getDirCardSeilNum() {
		return dirCardSeilNum;
	}

	public void setDirCardSeilNum(java.math.BigDecimal dirCardSeilNum) {
		this.dirCardSeilNum = dirCardSeilNum;
	}

	public java.lang.String getDirCardAmtMn() {
		return dirCardAmtMn;
	}

	public void setDirCardAmtMn(java.lang.String dirCardAmtMn) {
		this.dirCardAmtMn = dirCardAmtMn;
	}

	public java.math.BigDecimal getDirCardMmAmt() {
		return dirCardMmAmt;
	}

	public void setDirCardMmAmt(java.math.BigDecimal dirCardMmAmt) {
		this.dirCardMmAmt = dirCardMmAmt;
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
