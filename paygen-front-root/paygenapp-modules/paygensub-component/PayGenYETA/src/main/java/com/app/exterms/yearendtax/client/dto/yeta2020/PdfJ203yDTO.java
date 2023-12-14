package com.app.exterms.yearendtax.client.dto.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfJ203yVO.java
 * @Description : PdfJ203y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfJ203yDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 장기주택저당차입금일련번호 : loanSeilNum */
    private java.lang.Long loanSeilNum;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 장기주택저당차입금주민등록번호 : resid */
    private java.lang.String resid;

    /** set 장기주택저당차입금성명 : name */
    private java.lang.String name;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 장기주택저당차입금사업자등록번호 : busnid */
    private java.lang.String busnid;

    /** set 장기주택저당차입금취급기관명 : tradeNm */
    private java.lang.String tradeNm;

    /** set 장기주택저당차입금계좌번호 : accNo */
    private java.lang.String accNo;

    /** set 장기주택저당차입금대출종류 : lendKd */
    private java.lang.String lendKd;

    /** set 장기주택저당차입금주택취득일자 : houseTakeDt */
    private java.lang.String houseTakeDt;

    /** set 장기주택저당차입금저당권설정일자 : mortSetupDt */
    private java.lang.String mortSetupDt;

    /** set 장기주택저당차입금최초차입일자 : startDt */
    private java.lang.String startDt;

    /** set 장기주택저당차입금최종상환예정일자 : endDt */
    private java.lang.String endDt;

    /** set 장기주택저당차입금상환기간연수 : repayYears */
    private java.math.BigDecimal repayYears;

    /** set 장기주택저당차입금상품명 : lendGoodsNm */
    private java.lang.String lendGoodsNm;

    /** set 장기주택저당차입금금액 : debt */
    private java.math.BigDecimal debt;

    /** set 장기주택저당차입금고정금리차입금 : fixedRateDebt */
    private java.math.BigDecimal fixedRateDebt;

    /** set 장기주택저당차입금비거치식상환차입금액 : notDeferDebt */
    private java.math.BigDecimal notDeferDebt;

    /** set 장기주택저당차입금당해년원금상환액 : thisYearRedeAmt */
    private java.math.BigDecimal thisYearRedeAmt;

    /** set 장기주택저당차입금소득공제대상금액 : sumDdct */
    private java.math.BigDecimal sumDdct;

    /** set 장기주택저당차입금연간합계금액 : yearSumDdct */
    private java.math.BigDecimal yearSumDdct;

    /** set pdf 소득공제자료적용여부 : pdfDatAppYn */
    private java.lang.String pdfDatAppYn;
    
    /** set PDF_소득공제적용일자 : pdfDatAppCmplDt */
    private java.lang.String pdfDatAppCmplDt;

    /** set PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
    private java.lang.String pdfDatAppExcCtnt;

    public java.lang.String getPdfDatAppCmplDt() {
		return pdfDatAppCmplDt;
	}

	public void setPdfDatAppCmplDt(java.lang.String pdfDatAppCmplDt) {
		this.pdfDatAppCmplDt = pdfDatAppCmplDt;
	}

	public java.lang.String getPdfDatAppExcCtnt() {
		return pdfDatAppExcCtnt;
	}

	public void setPdfDatAppExcCtnt(java.lang.String pdfDatAppExcCtnt) {
		this.pdfDatAppExcCtnt = pdfDatAppExcCtnt;
	}


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
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getYrtxBlggYr() {
        return this.yrtxBlggYr;
    }
    
    public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
        this.yrtxBlggYr = yrtxBlggYr;
    }
    
    public java.lang.String getClutSeptCd() {
        return this.clutSeptCd;
    }
    
    public void setClutSeptCd(java.lang.String clutSeptCd) {
        this.clutSeptCd = clutSeptCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.Long getLoanSeilNum() {
        return this.loanSeilNum;
    }
    
    public void setLoanSeilNum(java.lang.Long loanSeilNum) {
        this.loanSeilNum = loanSeilNum;
    }
    
    public java.lang.String getFormCd() {
        return this.formCd;
    }
    
    public void setFormCd(java.lang.String formCd) {
        this.formCd = formCd;
    }
    
    public java.lang.String getResid() {
        return this.resid;
    }
    
    public void setResid(java.lang.String resid) {
        this.resid = resid;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getDatCd() {
        return this.datCd;
    }
    
    public void setDatCd(java.lang.String datCd) {
        this.datCd = datCd;
    }
    
    public java.lang.String getBusnid() {
        return this.busnid;
    }
    
    public void setBusnid(java.lang.String busnid) {
        this.busnid = busnid;
    }
    
    public java.lang.String getTradeNm() {
        return this.tradeNm;
    }
    
    public void setTradeNm(java.lang.String tradeNm) {
        this.tradeNm = tradeNm;
    }
    
    public java.lang.String getAccNo() {
        return this.accNo;
    }
    
    public void setAccNo(java.lang.String accNo) {
        this.accNo = accNo;
    }
    
    public java.lang.String getLendKd() {
        return this.lendKd;
    }
    
    public void setLendKd(java.lang.String lendKd) {
        this.lendKd = lendKd;
    }
    
    public java.lang.String getHouseTakeDt() {
        return this.houseTakeDt;
    }
    
    public void setHouseTakeDt(java.lang.String houseTakeDt) {
        this.houseTakeDt = houseTakeDt;
    }
    
    public java.lang.String getMortSetupDt() {
        return this.mortSetupDt;
    }
    
    public void setMortSetupDt(java.lang.String mortSetupDt) {
        this.mortSetupDt = mortSetupDt;
    }
    
    public java.lang.String getStartDt() {
        return this.startDt;
    }
    
    public void setStartDt(java.lang.String startDt) {
        this.startDt = startDt;
    }
    
    public java.lang.String getEndDt() {
        return this.endDt;
    }
    
    public void setEndDt(java.lang.String endDt) {
        this.endDt = endDt;
    }
    
    public java.math.BigDecimal getRepayYears() {
        return this.repayYears;
    }
    
    public void setRepayYears(java.math.BigDecimal repayYears) {
        this.repayYears = repayYears;
    }
    
    public java.lang.String getLendGoodsNm() {
        return this.lendGoodsNm;
    }
    
    public void setLendGoodsNm(java.lang.String lendGoodsNm) {
        this.lendGoodsNm = lendGoodsNm;
    }
    
    public java.math.BigDecimal getDebt() {
        return this.debt;
    }
    
    public void setDebt(java.math.BigDecimal debt) {
        this.debt = debt;
    }
    
    public java.math.BigDecimal getFixedRateDebt() {
        return this.fixedRateDebt;
    }
    
    public void setFixedRateDebt(java.math.BigDecimal fixedRateDebt) {
        this.fixedRateDebt = fixedRateDebt;
    }
    
    public java.math.BigDecimal getNotDeferDebt() {
        return this.notDeferDebt;
    }
    
    public void setNotDeferDebt(java.math.BigDecimal notDeferDebt) {
        this.notDeferDebt = notDeferDebt;
    }
    
    public java.math.BigDecimal getThisYearRedeAmt() {
        return this.thisYearRedeAmt;
    }
    
    public void setThisYearRedeAmt(java.math.BigDecimal thisYearRedeAmt) {
        this.thisYearRedeAmt = thisYearRedeAmt;
    }
    
    public java.math.BigDecimal getSumDdct() {
        return this.sumDdct;
    }
    
    public void setSumDdct(java.math.BigDecimal sumDdct) {
        this.sumDdct = sumDdct;
    }
    
    public java.math.BigDecimal getYearSumDdct() {
        return this.yearSumDdct;
    }
    
    public void setYearSumDdct(java.math.BigDecimal yearSumDdct) {
        this.yearSumDdct = yearSumDdct;
    }
    
    public java.lang.String getPdfDatAppYn() {
        return this.pdfDatAppYn;
    }
    
    public void setPdfDatAppYn(java.lang.String pdfDatAppYn) {
        this.pdfDatAppYn = pdfDatAppYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
