package com.app.exterms.yearendtax.client.dto.yeta2019;

import java.io.Serializable;

/**
 * @Class Name : PdfO101yVO.java
 * @Description : PdfO101y VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfO101yDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 건강보험료_주민등록번호 : resid */
    private java.lang.String resid;

    /** set 건강보험료_성명 : name */
    private java.lang.String name;

    /** set 건강보험료총합계금액 : hlthAmtSum */
    private java.math.BigDecimal hlthAmtSum;

    /** set 건강보험연말정산금액 : hiYrs */
    private java.math.BigDecimal hiYrs;

    /** set 장기요양연말정산금액 : ltrmYrs */
    private java.math.BigDecimal ltrmYrs;

    /** set 건강보험_보수월액_고지금액합계 : hiNtf */
    private java.math.BigDecimal hiNtf;

    /** set 장기요양_보수월액_고지금액합계 : ltrmNtf */
    private java.math.BigDecimal ltrmNtf;

    /** set 건강보험_소득월액_납부금액합계 : hiPmt */
    private java.math.BigDecimal hiPmt;

    /** set 장기요양_소득월액_납부금액합계 : ltrmPmt */
    private java.math.BigDecimal ltrmPmt;

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
    
 
    
    /**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDatCd() {
        return this.datCd;
    }
    
    public void setDatCd(java.lang.String datCd) {
        this.datCd = datCd;
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
    
    public java.math.BigDecimal getHlthAmtSum() {
        return this.hlthAmtSum;
    }
    
    public void setHlthAmtSum(java.math.BigDecimal hlthAmtSum) {
        this.hlthAmtSum = hlthAmtSum;
    }
    
    public java.math.BigDecimal getHiYrs() {
        return this.hiYrs;
    }
    
    public void setHiYrs(java.math.BigDecimal hiYrs) {
        this.hiYrs = hiYrs;
    }
    
    public java.math.BigDecimal getLtrmYrs() {
        return this.ltrmYrs;
    }
    
    public void setLtrmYrs(java.math.BigDecimal ltrmYrs) {
        this.ltrmYrs = ltrmYrs;
    }
    
    public java.math.BigDecimal getHiNtf() {
        return this.hiNtf;
    }
    
    public void setHiNtf(java.math.BigDecimal hiNtf) {
        this.hiNtf = hiNtf;
    }
    
    public java.math.BigDecimal getLtrmNtf() {
        return this.ltrmNtf;
    }
    
    public void setLtrmNtf(java.math.BigDecimal ltrmNtf) {
        this.ltrmNtf = ltrmNtf;
    }
    
    public java.math.BigDecimal getHiPmt() {
        return this.hiPmt;
    }
    
    public void setHiPmt(java.math.BigDecimal hiPmt) {
        this.hiPmt = hiPmt;
    }
    
    public java.math.BigDecimal getLtrmPmt() {
        return this.ltrmPmt;
    }
    
    public void setLtrmPmt(java.math.BigDecimal ltrmPmt) {
        this.ltrmPmt = ltrmPmt;
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
