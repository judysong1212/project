package com.app.exterms.payroll.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0305VO.java
 * @Description : Payr0305 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0305DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여일련번호 : payrSeilNum */
    private java.math.BigDecimal payrSeilNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 근로소득과세금액 : workIncmTxtnSum */
    private java.math.BigDecimal workIncmTxtnSum;

    /** set 급여구간중간금액 : paySectiCtrSum */
    private java.math.BigDecimal paySectiCtrSum;

    /** set 연간총급여액 : yrlyTotPayQNty */
    private java.math.BigDecimal yrlyTotPayQNty;

    /** set 근로소득공제금액 : eandIncmDducSum */
    private java.math.BigDecimal eandIncmDducSum;

    /** set 근로소득금액 : eandIncmSum */
    private java.math.BigDecimal eandIncmSum;

    /** set 인적공제인원수 : hmnDducNumPeplNum */
    private java.math.BigDecimal hmnDducNumPeplNum;

    /** set 인적공제20세이하자녀수 : hmnDducTwenSqntsChdnNum */
    private java.math.BigDecimal hmnDducTwenSqntsChdnNum;

    /** set 인적공제금액 : hmnDducSum */
    private java.math.BigDecimal hmnDducSum;

    /** set 연금보험료공제금액 : antyPrmmDducSum */
    private java.math.BigDecimal antyPrmmDducSum;

    /** set 특별소득공제등금액 : spclIncmDducEtcSum */
    private java.math.BigDecimal spclIncmDducEtcSum;

    /** set 과세표준금액 : txtnStdSum */
    private java.math.BigDecimal txtnStdSum;

    /** set 과세표준적용세율 : txtnStdApptnTxrt */
    private java.math.BigDecimal txtnStdApptnTxrt;

    /** set 과세표준누진공제금액 : txtnStdPgivDducSum */
    private java.math.BigDecimal txtnStdPgivDducSum;

    /** set 산출세액 : calcTxAmnt */
    private java.math.BigDecimal calcTxAmnt;

    /** set 근로소득세액공제액 : eandIncmTxAmnt */
    private java.math.BigDecimal eandIncmTxAmnt;

    /** set 결정세액 : deinTxAmnt */
    private java.math.BigDecimal deinTxAmnt;

    /** set 간이세액 : txtbSimfTxs */
    private java.math.BigDecimal txtbSimfTxs;

    /** set 지방소득세 : locIncmTxAmt */
    private java.math.BigDecimal locIncmTxAmt;

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

    /** set 추가소득세율 : addIncmTxRate */
    private Double addIncmTxRate;

    /** set 실소득세액 : turtyIncmTxQnty */
    private  Long turtyIncmTxQnty;

    /** set 수동소득세 : mnlTxtbSimfTxs */
    private Long mnlTxtbSimfTxs;

    /** set 수동지방소득세 : mnlLocTxAmt */
    private Long mnlLocTxAmt;

    /** set 수동소득세여부 : mnlTxtbSimfYn */
    private java.lang.String mnlTxtbSimfYn;
 
     
/** set 단위기관코드 : payrMangDeptCd */
private java.lang.String payrMangDeptCd = "";
  

 
/**
 * Comment : 
 * @fn Long getMnlTxtbSimfTxs()
 * @brief date:2017 2017. 7. 20. user:atres
 * @return the mnlTxtbSimfTxs get
 */
public Long getMnlTxtbSimfTxs() {
	return mnlTxtbSimfTxs;
}

/**
 * Comment : 
 *@fn void setMnlTxtbSimfTxs(Long mnlTxtbSimfTxs)
 *@brief date:2017 2017. 7. 20. user:atres
 *@param mnlTxtbSimfTxs the mnlTxtbSimfTxs to set
 */
public void setMnlTxtbSimfTxs(Long mnlTxtbSimfTxs) {
	this.mnlTxtbSimfTxs = mnlTxtbSimfTxs;
}

/**
 * Comment : 
 * @fn Long getMnlLocTxAmt()
 * @brief date:2017 2017. 7. 20. user:atres
 * @return the mnlLocTxAmt get
 */
public Long getMnlLocTxAmt() {
	return mnlLocTxAmt;
}

/**
 * Comment : 
 *@fn void setMnlLocTxAmt(Long mnlLocTxAmt)
 *@brief date:2017 2017. 7. 20. user:atres
 *@param mnlLocTxAmt the mnlLocTxAmt to set
 */
public void setMnlLocTxAmt(Long mnlLocTxAmt) {
	this.mnlLocTxAmt = mnlLocTxAmt;
}

/**
 * Comment : 
 * @fn java.lang.String getMnlTxtbSimfYn()
 * @brief date:2017 2017. 7. 20. user:atres
 * @return the mnlTxtbSimfYn get
 */
public java.lang.String getMnlTxtbSimfYn() {
	return mnlTxtbSimfYn;
}

/**
 * Comment : 
 *@fn void setMnlTxtbSimfYn(java.lang.String mnlTxtbSimfYn)
 *@brief date:2017 2017. 7. 20. user:atres
 *@param mnlTxtbSimfYn the mnlTxtbSimfYn to set
 */
public void setMnlTxtbSimfYn(java.lang.String mnlTxtbSimfYn) {
	this.mnlTxtbSimfYn = mnlTxtbSimfYn;
}

 

	public Double getAddIncmTxRate() {
	return addIncmTxRate;
}

public void setAddIncmTxRate(Double addIncmTxRate) {
	this.addIncmTxRate = addIncmTxRate;
}

public Long getTurtyIncmTxQnty() {
	return turtyIncmTxQnty;
}

public void setTurtyIncmTxQnty(Long turtyIncmTxQnty) {
	this.turtyIncmTxQnty = turtyIncmTxQnty;
}

	public java.lang.String getDpobCd() {
    return dpobCd;
}

public void setDpobCd(java.lang.String dpobCd) {
    this.dpobCd = dpobCd;
}

    public java.math.BigDecimal getEandIncmSum() {
	return eandIncmSum;
}

public void setEandIncmSum(java.math.BigDecimal eandIncmSum) {
	this.eandIncmSum = eandIncmSum;
}

public java.math.BigDecimal getLocIncmTxAmt() {
	return locIncmTxAmt;
}

public void setLocIncmTxAmt(java.math.BigDecimal locIncmTxAmt) {
	this.locIncmTxAmt = locIncmTxAmt;
}

	public java.lang.String getPymtYrMnth() {
        return this.pymtYrMnth;
    }
    
    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public BigDecimal getPayrSeilNum() {
        return this.payrSeilNum;
    }
    
    public void setPayrSeilNum(BigDecimal payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }
    
    public BigDecimal getWorkIncmTxtnSum() {
        return this.workIncmTxtnSum;
    }
    
    public void setWorkIncmTxtnSum(BigDecimal workIncmTxtnSum) {
        this.workIncmTxtnSum = workIncmTxtnSum;
    }
    
    public BigDecimal getPaySectiCtrSum() {
        return this.paySectiCtrSum;
    }
    
    public void setPaySectiCtrSum(BigDecimal paySectiCtrSum) {
        this.paySectiCtrSum = paySectiCtrSum;
    }
    
    public BigDecimal getYrlyTotPayQNty() {
        return this.yrlyTotPayQNty;
    }
    
    public void setYrlyTotPayQNty(BigDecimal yrlyTotPayQNty) {
        this.yrlyTotPayQNty = yrlyTotPayQNty;
    }
    
    public BigDecimal getEandIncmDducSum() {
        return this.eandIncmDducSum;
    }
    
    public void setEandIncmDducSum(BigDecimal eandIncmDducSum) {
        this.eandIncmDducSum = eandIncmDducSum;
    }
    
    public BigDecimal getHmnDducNumPeplNum() {
        return this.hmnDducNumPeplNum;
    }
    
    public void setHmnDducNumPeplNum(BigDecimal hmnDducNumPeplNum) {
        this.hmnDducNumPeplNum = hmnDducNumPeplNum;
    }
    
    public BigDecimal getHmnDducTwenSqntsChdnNum() {
        return this.hmnDducTwenSqntsChdnNum;
    }
    
    public void setHmnDducTwenSqntsChdnNum(BigDecimal hmnDducTwenSqntsChdnNum) {
        this.hmnDducTwenSqntsChdnNum = hmnDducTwenSqntsChdnNum;
    }
    
    public BigDecimal getHmnDducSum() {
        return this.hmnDducSum;
    }
    
    public void setHmnDducSum(BigDecimal hmnDducSum) {
        this.hmnDducSum = hmnDducSum;
    }
    
    public BigDecimal getAntyPrmmDducSum() {
        return this.antyPrmmDducSum;
    }
    
    public void setAntyPrmmDducSum(BigDecimal antyPrmmDducSum) {
        this.antyPrmmDducSum = antyPrmmDducSum;
    }
    
    public BigDecimal getSpclIncmDducEtcSum() {
        return this.spclIncmDducEtcSum;
    }
    
    public void setSpclIncmDducEtcSum(BigDecimal spclIncmDducEtcSum) {
        this.spclIncmDducEtcSum = spclIncmDducEtcSum;
    }
    
    public BigDecimal getTxtnStdSum() {
        return this.txtnStdSum;
    }
    
    public void setTxtnStdSum(BigDecimal txtnStdSum) {
        this.txtnStdSum = txtnStdSum;
    }
    
    public BigDecimal getTxtnStdApptnTxrt() {
        return this.txtnStdApptnTxrt;
    }
    
    public void setTxtnStdApptnTxrt(BigDecimal txtnStdApptnTxrt) {
        this.txtnStdApptnTxrt = txtnStdApptnTxrt;
    }
    
    public BigDecimal getTxtnStdPgivDducSum() {
        return this.txtnStdPgivDducSum;
    }
    
    public void setTxtnStdPgivDducSum(BigDecimal txtnStdPgivDducSum) {
        this.txtnStdPgivDducSum = txtnStdPgivDducSum;
    }
    
    public BigDecimal getCalcTxAmnt() {
        return this.calcTxAmnt;
    }
    
    public void setCalcTxAmnt(BigDecimal calcTxAmnt) {
        this.calcTxAmnt = calcTxAmnt;
    }
    
    public BigDecimal getEandIncmTxAmnt() {
        return this.eandIncmTxAmnt;
    }
    
    public void setEandIncmTxAmnt(BigDecimal eandIncmTxAmnt) {
        this.eandIncmTxAmnt = eandIncmTxAmnt;
    }
    
    public BigDecimal getDeinTxAmnt() {
        return this.deinTxAmnt;
    }
    
    public void setDeinTxAmnt(BigDecimal deinTxAmnt) {
        this.deinTxAmnt = deinTxAmnt;
    }
    
    public BigDecimal getTxtbSimfTxs() {
        return this.txtbSimfTxs;
    }
    
    public void setTxtbSimfTxs(BigDecimal txtbSimfTxs) {
        this.txtbSimfTxs = txtbSimfTxs;
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
