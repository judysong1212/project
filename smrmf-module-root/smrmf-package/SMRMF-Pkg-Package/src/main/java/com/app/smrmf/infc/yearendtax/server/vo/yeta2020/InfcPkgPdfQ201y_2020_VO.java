package com.app.smrmf.infc.yearendtax.server.vo.yeta2020;

import java.io.Serializable;

/**
 * @Class Name : PdfQ201yVO.java
 * @Description : PdfQ201y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPdfQ201y_2020_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DAT_CD */
    private java.lang.String datCd;

    /** FORM_CD */
    private java.lang.String formCd;
    
    /** RESID */
    private java.lang.String resid;
    
    /** NAME */
    private java.lang.String name;
    
    private java.lang.String busnid;
    
    private java.lang.String tradeNm;
    
    private java.lang.String secuNo;
    
    private java.lang.String fundNm;
    
    private java.lang.String regDt;
    
    private java.lang.String vntAsctClCd;
    
    private java.lang.String comCd;
    
    private java.math.BigDecimal vntSum;
    
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

	public java.lang.String getBusnid() {
		return busnid;
	}

	public void setBusnid(java.lang.String busnid) {
		this.busnid = busnid;
	}

	public java.lang.String getTradeNm() {
		return tradeNm;
	}

	public void setTradeNm(java.lang.String tradeNm) {
		this.tradeNm = tradeNm;
	}

	public java.lang.String getSecuNo() {
		return secuNo;
	}

	public void setSecuNo(java.lang.String secuNo) {
		this.secuNo = secuNo;
	}

	public java.lang.String getFundNm() {
		return fundNm;
	}

	public void setFundNm(java.lang.String fundNm) {
		this.fundNm = fundNm;
	}

	public java.lang.String getRegDt() {
		return regDt;
	}

	public void setRegDt(java.lang.String regDt) {
		this.regDt = regDt;
	}

	public java.lang.String getVntAsctClCd() {
		return vntAsctClCd;
	}

	public void setVntAsctClCd(java.lang.String vntAsctClCd) {
		this.vntAsctClCd = vntAsctClCd;
	}

	public java.lang.String getComCd() {
		return comCd;
	}

	public void setComCd(java.lang.String comCd) {
		this.comCd = comCd;
	}

	public java.math.BigDecimal getVntSum() {
		return vntSum;
	}

	public void setVntSum(java.math.BigDecimal vntSum) {
		this.vntSum = vntSum;
	}


    
}
