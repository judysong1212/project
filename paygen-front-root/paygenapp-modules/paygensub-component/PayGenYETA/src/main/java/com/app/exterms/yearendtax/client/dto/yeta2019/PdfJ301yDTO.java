package com.app.exterms.yearendtax.client.dto.yeta2019;

import java.io.Serializable;

/**
 * @Class Name : PdfJ301yVO.java
 * @Description : PdfJ301y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfJ301yDTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
   
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 주택마련저축계좌번호 : homeSeilSum */
    private String homeSeilSum;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 주택마련저축주민등록번호 : resid */
    private java.lang.String resid;

    /** set 주택마련저축성명 : name */
    private java.lang.String name;

    /** set 자료코드 : datCd */
    private java.lang.String datCd;

    /** set 주택마련저축사업자등록번호 : busnid */
    private java.lang.String busnid;

    /** set 주택마련저축취급기관명 : tradeNm */
    private java.lang.String tradeNm;

    /** set 주택마련저축저축명 : goodsNm */
    private java.lang.String goodsNm;

    /** set 주택마련저축가입일자 : regDt */
    private java.lang.String regDt;

    /** set 주택마련저축금융회사등코드 : comCd */
    private java.lang.String comCd;

    /** set 주택마련저축납입금액계 : homeAmtSum */
    private java.math.BigDecimal homeAmtSum;

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
   
    
    /**
	 * Comment : 
	 * @fn String getHomeSeilSum()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the homeSeilSum get
	 */
	public String getHomeSeilSum() {
		return homeSeilSum;
	}

	/**
	 * Comment : 
	 *@fn void setHomeSeilSum(String homeSeilSum)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param homeSeilSum the homeSeilSum to set
	 */
	public void setHomeSeilSum(String homeSeilSum) {
		this.homeSeilSum = homeSeilSum;
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
    
    public java.lang.String getRegDt() {
        return this.regDt;
    }
    
    public void setRegDt(java.lang.String regDt) {
        this.regDt = regDt;
    }
    
    public java.lang.String getComCd() {
        return this.comCd;
    }
    
    public void setComCd(java.lang.String comCd) {
        this.comCd = comCd;
    }
    
    public java.math.BigDecimal getHomeAmtSum() {
        return this.homeAmtSum;
    }
    
    public void setHomeAmtSum(java.math.BigDecimal homeAmtSum) {
        this.homeAmtSum = homeAmtSum;
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
