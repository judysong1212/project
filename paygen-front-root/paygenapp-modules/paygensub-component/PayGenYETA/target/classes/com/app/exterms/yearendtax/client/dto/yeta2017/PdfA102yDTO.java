package com.app.exterms.yearendtax.client.dto.yeta2017;

import java.io.Serializable;

/**
 * @Class Name : PdfA102yVO.java
 * @Description : PdfA102y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfA102yDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 증권번호 : accNo */
    private java.lang.String accNo;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 주민등록번호 : resid */
    private java.lang.String resid;

    /** set 성명 : name */
    private java.lang.String name;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 사업자번호 : busnid */
    private java.lang.String busnid;

    /** set 상호명 : tradeNm */
    private java.lang.String tradeNm;

    /** set 보험종류 : goodsNm */
    private java.lang.String goodsNm;

    /** set 주민등록번호_주피보험자 : insu1Resid */
    private java.lang.String insu1Resid;

    /** set 성명_주피보험자 : insu1Nm */
    private java.lang.String insu1Nm;

    /** set 주민등록번호_종피보험자1 : insu2Resid1 */
    private java.lang.String insu2Resid1;

    /** set 성명_종피보험자1 : insu2Nm1 */
    private java.lang.String insu2Nm1;

    /** set 주민등록번호_종피보험자2 : insu2Resid2 */
    private java.lang.String insu2Resid2;

    /** set 성명_종피보험자2 : insu2Nm2 */
    private java.lang.String insu2Nm2;

    /** set 주민등록번호_종피보험자3 : insu2Resid3 */
    private java.lang.String insu2Resid3;

    /** set 성명_종피보험자3 : insu2Nm3 */
    private java.lang.String insu2Nm3;

    /** set 보험료납입금액계 : insuPaySum */
    private java.math.BigDecimal insuPaySum;

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
    
    public java.lang.String getAccNo() {
        return this.accNo;
    }
    
    public void setAccNo(java.lang.String accNo) {
        this.accNo = accNo;
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
    
    public java.lang.String getGoodsNm() {
        return this.goodsNm;
    }
    
    public void setGoodsNm(java.lang.String goodsNm) {
        this.goodsNm = goodsNm;
    }
    
    public java.lang.String getInsu1Resid() {
        return this.insu1Resid;
    }
    
    public void setInsu1Resid(java.lang.String insu1Resid) {
        this.insu1Resid = insu1Resid;
    }
    
    public java.lang.String getInsu1Nm() {
        return this.insu1Nm;
    }
    
    public void setInsu1Nm(java.lang.String insu1Nm) {
        this.insu1Nm = insu1Nm;
    }
    
    public java.lang.String getInsu2Resid1() {
        return this.insu2Resid1;
    }
    
    public void setInsu2Resid1(java.lang.String insu2Resid1) {
        this.insu2Resid1 = insu2Resid1;
    }
    
    public java.lang.String getInsu2Nm1() {
        return this.insu2Nm1;
    }
    
    public void setInsu2Nm1(java.lang.String insu2Nm1) {
        this.insu2Nm1 = insu2Nm1;
    }
    
    public java.lang.String getInsu2Resid2() {
        return this.insu2Resid2;
    }
    
    public void setInsu2Resid2(java.lang.String insu2Resid2) {
        this.insu2Resid2 = insu2Resid2;
    }
    
    public java.lang.String getInsu2Nm2() {
        return this.insu2Nm2;
    }
    
    public void setInsu2Nm2(java.lang.String insu2Nm2) {
        this.insu2Nm2 = insu2Nm2;
    }
    
    public java.lang.String getInsu2Resid3() {
        return this.insu2Resid3;
    }
    
    public void setInsu2Resid3(java.lang.String insu2Resid3) {
        this.insu2Resid3 = insu2Resid3;
    }
    
    public java.lang.String getInsu2Nm3() {
        return this.insu2Nm3;
    }
    
    public void setInsu2Nm3(java.lang.String insu2Nm3) {
        this.insu2Nm3 = insu2Nm3;
    }
    
    public java.math.BigDecimal getInsuPaySum() {
        return this.insuPaySum;
    }
    
    public void setInsuPaySum(java.math.BigDecimal insuPaySum) {
        this.insuPaySum = insuPaySum;
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
