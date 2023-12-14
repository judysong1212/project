package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0520VO.java
 * @Description : Payr0520 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0520VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PAY_YR */
    private java.lang.String payYr;
    
    
    public java.lang.String getPayYr() {
		return payYr;
	}

	public void setPayYr(java.lang.String payYr) {
		this.payYr = payYr;
	}

	/** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    
    public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PYMT_DDUC_ITEM_SIL_NUM */
    private BigDecimal pymtDducItemSilNum;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String pymtDducDivCd;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String PayExtpyCd;
    
    
    public java.lang.String getPayExtpyCd() {
		return PayExtpyCd;
	}

	public void setPayExtpyCd(java.lang.String payExtpyCd) {
		PayExtpyCd = payExtpyCd;
	}
	
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String payDducCd;
    

	public java.lang.String getPayDducCd() {
		return payDducCd;
	}

	public void setPayDducCd(java.lang.String payDducCd) {
		this.payDducCd = payDducCd;
	}

	/** PYMT_DDUC_SUM */
    private BigDecimal pymtDducSum;
    
    /** PYMT_DDUC_RATE */
    private BigDecimal pymtDducRate;
    
    /** PYMT_DDUC_FREE_DTY_SUM */
    private BigDecimal pymtDducFreeDtySum;
    
    /** PYMT_DDUC_ITEM_CRETN_DIV_CD */
    private java.lang.String pymtDducItemCretnDivCd;
    
    /** PYMT_DDUC_ITEM_NOTE_CTNT */
    private java.lang.String pymtDducItemNoteCtnt;
    
    /** PYMT_DDUC_ITEM_BGNN_DT */
    private java.lang.String pymtDducItemBgnnDt;
    
    /** PYMT_DDUC_ITEM_END_DT */
    private java.lang.String pymtDducItemEndDt;
    
    /** PYMT_DDUC_ITEM_DEL_YN */
    private java.lang.String pymtDducItemDelYn;
    
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
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public BigDecimal getPymtDducItemSilNum() {
        return this.pymtDducItemSilNum;
    }
    
    public void setPymtDducItemSilNum(BigDecimal pymtDducItemSilNum) {
        this.pymtDducItemSilNum = pymtDducItemSilNum;
    }
    
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    public BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public BigDecimal getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(BigDecimal pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public BigDecimal getPymtDducFreeDtySum() {
        return this.pymtDducFreeDtySum;
    }
    
    public void setPymtDducFreeDtySum(BigDecimal pymtDducFreeDtySum) {
        this.pymtDducFreeDtySum = pymtDducFreeDtySum;
    }
    
    public java.lang.String getPymtDducItemCretnDivCd() {
        return this.pymtDducItemCretnDivCd;
    }
    
    public void setPymtDducItemCretnDivCd(java.lang.String pymtDducItemCretnDivCd) {
        this.pymtDducItemCretnDivCd = pymtDducItemCretnDivCd;
    }
    
    public java.lang.String getPymtDducItemNoteCtnt() {
        return this.pymtDducItemNoteCtnt;
    }
    
    public void setPymtDducItemNoteCtnt(java.lang.String pymtDducItemNoteCtnt) {
        this.pymtDducItemNoteCtnt = pymtDducItemNoteCtnt;
    }
    
    public java.lang.String getPymtDducItemBgnnDt() {
        return this.pymtDducItemBgnnDt;
    }
    
    public void setPymtDducItemBgnnDt(java.lang.String pymtDducItemBgnnDt) {
        this.pymtDducItemBgnnDt = pymtDducItemBgnnDt;
    }
    
    public java.lang.String getPymtDducItemEndDt() {
        return this.pymtDducItemEndDt;
    }
    
    public void setPymtDducItemEndDt(java.lang.String pymtDducItemEndDt) {
        this.pymtDducItemEndDt = pymtDducItemEndDt;
    }
    
    public java.lang.String getPymtDducItemDelYn() {
        return this.pymtDducItemDelYn;
    }
    
    public void setPymtDducItemDelYn(java.lang.String pymtDducItemDelYn) {
        this.pymtDducItemDelYn = pymtDducItemDelYn;
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
    
    private java.lang.String checkIU;


	public java.lang.String getCheckIU() {
		return checkIU;
	}

	public void setCheckIU(java.lang.String checkIU) {
		this.checkIU = checkIU;
	}
    	
}
