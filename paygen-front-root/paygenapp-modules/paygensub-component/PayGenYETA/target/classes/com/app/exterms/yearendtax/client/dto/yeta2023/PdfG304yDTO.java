package com.app.exterms.yearendtax.client.dto.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : PdfG304yVO.java
 * @Description : PdfG304y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfG304yDTO  implements Serializable {
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

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 직불카드주민등록번호 : resid */
    private java.lang.String resid;

    /** set 직불카드성명 : name */
    private java.lang.String name;

    /** set 직불카드전전년도일반공제대상금액합계 : ftyrTotAmt */
    private java.math.BigDecimal ftyrTotAmt;

    /** set 직불카드전전년도전통시장공제대상금액합계 : ftyrMarketTotAmt */
    private java.math.BigDecimal ftyrMarketTotAmt;

    /** set 직불카드전전년도대중교통공제대상금액합계 : ftyrTmoneyTotAmt */
    private java.math.BigDecimal ftyrTmoneyTotAmt;

    /** set 직불카드직전년도일반공제대상금액합계 : preTotAmt */
    private java.math.BigDecimal preTotAmt;

    /** set 직불카드직전년도전통시장공제대상금액합계 : preMarketTotAmt */
    private java.math.BigDecimal preMarketTotAmt;

    /** set 직불카드직전년도대중교통공제대상금액합계 : preTmoneyTotAmt */
    private java.math.BigDecimal preTmoneyTotAmt;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 직불카드사업자등록번호 : busnid */
    private java.lang.String busnid;

    /** set 직불카드상호명 : tradeNm */
    private java.lang.String tradeNm;

    /** set 직불카드종류코드 : usePlaceCd */
    private java.lang.String usePlaceCd;

    /** set 직불카드귀속년도_상_대상금액합계 : firstTotAmt */
    private java.math.BigDecimal firstTotAmt;

    /** set 직불카드귀속년도_하_대상금액합계 : secondTotAmt */
    private java.math.BigDecimal secondTotAmt;

    /** set 직불카드귀속년도상반기대상금액합계 : firstYearTotAmt */
    private java.math.BigDecimal firstYearTotAmt;

    /** set 직불카드귀속년도하반기대상금액합계 : secondYearTotAmt */
    private java.math.BigDecimal secondYearTotAmt;

    /** set 직불카드조회기간시작월 : inqrStrtMm */
    private java.lang.String inqrStrtMm;

    /** set 직불카드조회기간종료월 : inqrEndMm */
    private java.lang.String inqrEndMm;

    /** set 직불카드공제대상금액합계 : dirCardAmtSum */
    private java.math.BigDecimal dirCardAmtSum;

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
    
    public java.math.BigDecimal getDirCardSeilNum() {
        return this.dirCardSeilNum;
    }
    
    public void setDirCardSeilNum(java.math.BigDecimal dirCardSeilNum) {
        this.dirCardSeilNum = dirCardSeilNum;
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
    
    public java.math.BigDecimal getFtyrTotAmt() {
        return this.ftyrTotAmt;
    }
    
    public void setFtyrTotAmt(java.math.BigDecimal ftyrTotAmt) {
        this.ftyrTotAmt = ftyrTotAmt;
    }
    
    public java.math.BigDecimal getFtyrMarketTotAmt() {
        return this.ftyrMarketTotAmt;
    }
    
    public void setFtyrMarketTotAmt(java.math.BigDecimal ftyrMarketTotAmt) {
        this.ftyrMarketTotAmt = ftyrMarketTotAmt;
    }
    
    public java.math.BigDecimal getFtyrTmoneyTotAmt() {
        return this.ftyrTmoneyTotAmt;
    }
    
    public void setFtyrTmoneyTotAmt(java.math.BigDecimal ftyrTmoneyTotAmt) {
        this.ftyrTmoneyTotAmt = ftyrTmoneyTotAmt;
    }
    
    public java.math.BigDecimal getPreTotAmt() {
        return this.preTotAmt;
    }
    
    public void setPreTotAmt(java.math.BigDecimal preTotAmt) {
        this.preTotAmt = preTotAmt;
    }
    
    public java.math.BigDecimal getPreMarketTotAmt() {
        return this.preMarketTotAmt;
    }
    
    public void setPreMarketTotAmt(java.math.BigDecimal preMarketTotAmt) {
        this.preMarketTotAmt = preMarketTotAmt;
    }
    
    public java.math.BigDecimal getPreTmoneyTotAmt() {
        return this.preTmoneyTotAmt;
    }
    
    public void setPreTmoneyTotAmt(java.math.BigDecimal preTmoneyTotAmt) {
        this.preTmoneyTotAmt = preTmoneyTotAmt;
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
    
    public java.lang.String getUsePlaceCd() {
        return this.usePlaceCd;
    }
    
    public void setUsePlaceCd(java.lang.String usePlaceCd) {
        this.usePlaceCd = usePlaceCd;
    }
    
    public java.math.BigDecimal getFirstTotAmt() {
        return this.firstTotAmt;
    }
    
    public void setFirstTotAmt(java.math.BigDecimal firstTotAmt) {
        this.firstTotAmt = firstTotAmt;
    }
    
    public java.math.BigDecimal getSecondTotAmt() {
        return this.secondTotAmt;
    }
    
    public void setSecondTotAmt(java.math.BigDecimal secondTotAmt) {
        this.secondTotAmt = secondTotAmt;
    }
    
    public java.math.BigDecimal getFirstYearTotAmt() {
        return this.firstYearTotAmt;
    }
    
    public void setFirstYearTotAmt(java.math.BigDecimal firstYearTotAmt) {
        this.firstYearTotAmt = firstYearTotAmt;
    }
    
    public java.math.BigDecimal getSecondYearTotAmt() {
        return this.secondYearTotAmt;
    }
    
    public void setSecondYearTotAmt(java.math.BigDecimal secondYearTotAmt) {
        this.secondYearTotAmt = secondYearTotAmt;
    }
    
    public java.lang.String getInqrStrtMm() {
        return this.inqrStrtMm;
    }
    
    public void setInqrStrtMm(java.lang.String inqrStrtMm) {
        this.inqrStrtMm = inqrStrtMm;
    }
    
    public java.lang.String getInqrEndMm() {
        return this.inqrEndMm;
    }
    
    public void setInqrEndMm(java.lang.String inqrEndMm) {
        this.inqrEndMm = inqrEndMm;
    }
    
    public java.math.BigDecimal getDirCardAmtSum() {
        return this.dirCardAmtSum;
    }
    
    public void setDirCardAmtSum(java.math.BigDecimal dirCardAmtSum) {
        this.dirCardAmtSum = dirCardAmtSum;
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
