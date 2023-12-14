package com.app.smrmf.infc.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0350VO.java
 * @Description : Bass0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgBass0350VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
    /** DTIL_OCCU_CLS_NM */
    private java.lang.String dtilOccuClsNm;
    
    /** DTIL_OCCU_CLS_CTNT */
    private java.lang.String dtilOccuClsCtnt;
    
    /** DTIL_OCCU_CLS_USE_YN */
    private java.lang.String dtilOccuClsUseYn;
    
    /** set 정렬순서 : dtilOccuClsOrd */
    private java.lang.String  dtilOccuClsOrd ;
    
    private java.lang.String  chngTgtYn ; 
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    

/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
private java.lang.String dtilOcclsApptnUcstCd;

/** set 직종세적용단가금액 : dtilOcclsApptnUcstSum */
private java.math.BigDecimal dtilOcclsApptnUcstSum;



  public java.lang.String getDtilOcclsApptnUcstCd() {
	return dtilOcclsApptnUcstCd;
}

public void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd) {
	this.dtilOcclsApptnUcstCd = dtilOcclsApptnUcstCd;
}

public java.math.BigDecimal getDtilOcclsApptnUcstSum() {
	return dtilOcclsApptnUcstSum;
}

public void setDtilOcclsApptnUcstSum(java.math.BigDecimal dtilOcclsApptnUcstSum) {
	this.dtilOcclsApptnUcstSum = dtilOcclsApptnUcstSum;
}

	public java.lang.String getChngTgtYn() {
		return chngTgtYn;
	}

	public void setChngTgtYn(java.lang.String chngTgtYn) {
		this.chngTgtYn = chngTgtYn;
	}

	public java.lang.String getDtilOccuClsOrd() {
		return dtilOccuClsOrd;
	}

	public void setDtilOccuClsOrd(java.lang.String dtilOccuClsOrd) {
		this.dtilOccuClsOrd = dtilOccuClsOrd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getDtilOccuClsNm() {
        return this.dtilOccuClsNm;
    }
    
    public void setDtilOccuClsNm(java.lang.String dtilOccuClsNm) {
        this.dtilOccuClsNm = dtilOccuClsNm;
    }
    
    public java.lang.String getDtilOccuClsCtnt() {
        return this.dtilOccuClsCtnt;
    }
    
    public void setDtilOccuClsCtnt(java.lang.String dtilOccuClsCtnt) {
        this.dtilOccuClsCtnt = dtilOccuClsCtnt;
    }
    
    public java.lang.String getDtilOccuClsUseYn() {
        return this.dtilOccuClsUseYn;
    }
    
    public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
        this.dtilOccuClsUseYn = dtilOccuClsUseYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.sql.Date getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.sql.Date inptDt) {
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
    
    public java.sql.Date getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.sql.Date revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
}
