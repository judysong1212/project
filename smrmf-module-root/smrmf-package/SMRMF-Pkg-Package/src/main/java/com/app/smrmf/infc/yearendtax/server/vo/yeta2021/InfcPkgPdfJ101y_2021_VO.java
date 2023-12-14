package com.app.smrmf.infc.yearendtax.server.vo.yeta2021;

import java.io.Serializable;

/**
 * @Class Name : PdfJ101yVO.java
 * @Description : PdfJ101y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPdfJ101y_2021_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    

    /** set 주택임차차입금일련번호 : tradeSeilNum */
    private java.math.BigDecimal tradeSeilNum;
  
    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** FORM_CD */
    private java.lang.String formCd;
    
    /** RESID */
    private java.lang.String resid;
    
    /** NAME */
    private java.lang.String name;
    
    /** DAT_CD */
    private java.lang.String datCd;
    
    /** BUSNID */
    private java.lang.String busnid;
    
    /** TRADE_NM */
    private java.lang.String tradeNm;
    
    /** ACC_NO */
    private java.lang.String accNo;
    
    /** GOODS_NM */
    private java.lang.String goodsNm;
    
    /** LEND_DT */
    private java.lang.String lendDt;
    
    /** LS_AMT_NUM */
    private java.math.BigDecimal lsAmtNum;
    
    /** PDF_DAT_APP_YN */
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
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
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
 
    
    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getTradeSeilNum()
	 * @brief date:2017 2017. 1. 7. user:atres-pc
	 * @return the tradeSeilNum get
	 */
	public java.math.BigDecimal getTradeSeilNum() {
		return tradeSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setTradeSeilNum(java.math.BigDecimal tradeSeilNum)
	 *@brief date:2017 2017. 1. 7. user:atres-pc
	 *@param tradeSeilNum the tradeSeilNum to set
	 */
	public void setTradeSeilNum(java.math.BigDecimal tradeSeilNum) {
		this.tradeSeilNum = tradeSeilNum;
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
    
    public java.lang.String getGoodsNm() {
        return this.goodsNm;
    }
    
    public void setGoodsNm(java.lang.String goodsNm) {
        this.goodsNm = goodsNm;
    }
    
    public java.lang.String getLendDt() {
        return this.lendDt;
    }
    
    public void setLendDt(java.lang.String lendDt) {
        this.lendDt = lendDt;
    }
    
    public java.math.BigDecimal getLsAmtNum() {
        return this.lsAmtNum;
    }
    
    public void setLsAmtNum(java.math.BigDecimal lsAmtNum) {
        this.lsAmtNum = lsAmtNum;
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
