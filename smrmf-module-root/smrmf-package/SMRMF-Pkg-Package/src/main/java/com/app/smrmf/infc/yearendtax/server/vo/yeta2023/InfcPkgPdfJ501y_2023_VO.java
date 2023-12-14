package com.app.smrmf.infc.yearendtax.server.vo.yeta2023;

import java.io.Serializable;

/**
 * @Class Name : PdfJ501yVO.java
 * @Description : PdfJ501y VO class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPdfJ501y_2023_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** YRTX_BLGG_YR */
    private java.lang.String yrtxBlggYr;
    
    /** CLUT_SEPT_CD */
    private java.lang.String clutSeptCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** MAN_SEIL_NUM */
    private java.math.BigDecimal manSeilNum;
    
    /** FORM_CD */
    private java.lang.String formCd;
    
    /** RESID */
    private java.lang.String resid;
    
    /** NAME */
    private java.lang.String name;
    
    /** DAT_CD */
    private java.lang.String datCd;
    
    private java.lang.String lsorNo;
    
    private java.lang.String lsorNm;
    
    private java.lang.String rentalSt;
    
    private java.lang.String rentalDt;
    
    private java.lang.String rentalAdr;
    
    private java.lang.String rentalArea;
    
    private java.lang.String rentalCd;
    
    private java.math.BigDecimal rentalAmtSum;
    
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

	public java.lang.String getLsorNo() {
		return lsorNo;
	}

	public void setLsorNo(java.lang.String lsorNo) {
		this.lsorNo = lsorNo;
	}

	public java.lang.String getLsorNm() {
		return lsorNm;
	}

	public void setLsorNm(java.lang.String lsorNm) {
		this.lsorNm = lsorNm;
	}

	public java.lang.String getRentalSt() {
		return rentalSt;
	}

	public void setRentalSt(java.lang.String rentalSt) {
		this.rentalSt = rentalSt;
	}

	public java.lang.String getRentalDt() {
		return rentalDt;
	}

	public void setRentalDt(java.lang.String rentalDt) {
		this.rentalDt = rentalDt;
	}

	public java.lang.String getRentalAdr() {
		return rentalAdr;
	}

	public void setRentalAdr(java.lang.String rentalAdr) {
		this.rentalAdr = rentalAdr;
	}

	public java.math.BigDecimal getRentalAmtSum() {
		return rentalAmtSum;
	}

	public void setRentalAmtSum(java.math.BigDecimal rentalAmtSum) {
		this.rentalAmtSum = rentalAmtSum;
	}

	public java.lang.String getRentalArea() {
		return rentalArea;
	}

	public void setRentalArea(java.lang.String rentalArea) {
		this.rentalArea = rentalArea;
	}

	public java.lang.String getRentalCd() {
		return rentalCd;
	}

	public void setRentalCd(java.lang.String rentalCd) {
		this.rentalCd = rentalCd;
	}

	public java.math.BigDecimal getManSeilNum() {
		return manSeilNum;
	}

	public void setManSeilNum(java.math.BigDecimal manSeilNum) {
		this.manSeilNum = manSeilNum;
	}

    
}