package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr5200VO.java
 * @Description : Insr5200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr5200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 납부년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 고용일련번호 : emymtSeilNum */
    private java.math.BigDecimal emymtSeilNum;

    /** set 부과년월 : iposYrMnth */
    private java.lang.String iposYrMnth;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 고용시작일자 : umytInsrBgnnDt */
    private java.lang.String umytInsrBgnnDt;

    /** set 고용종료일자 : umytInsrEndDt */
    private java.lang.String umytInsrEndDt;

    /** set 월평균보수월액 : mnthAvgPayMnthAmnt */
    private java.math.BigDecimal mnthAvgPayMnthAmnt;

    /** set 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
    private java.math.BigDecimal cmpttnWkppUneplrtSum;

    /** set 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
    private java.math.BigDecimal cmpttnEplrUneplrtSum;

    /** set 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
    private java.math.BigDecimal cmpttnEplrFncdsnInsurSum;

    /** set 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
    private java.math.BigDecimal recpttnWkppUneplrtSum;

    /** set 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
    private java.math.BigDecimal recpttnEplrUneplrtSum;

    /** set 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
    private java.math.BigDecimal recpttnEplrFncdsnSum;

    /** set 정산보수총액 : clutPayTotAmnt */
    private java.math.BigDecimal clutPayTotAmnt;

    /** set 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
    private java.math.BigDecimal clutWkppUneplrtSum;

    /** set 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
    private java.math.BigDecimal clutEplrUneplrtSum;

    /** set 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
    private java.math.BigDecimal clutEplrFncdsnSum;

    /** set 고용보험요율 : umytInsrApmrt */
    private java.math.BigDecimal umytInsrApmrt;

    /** set 급여산출고용보험금액 : payCalcEmymtInsurSum */
    private java.math.BigDecimal payCalcEmymtInsurSum;

    /** set 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
    private java.math.BigDecimal indvUneplrtPymtAggrSum;

    /** set 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
    private java.math.BigDecimal eplrUneplrtPymtAggrSum;

    /** set 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
    private java.math.BigDecimal eplrFncdsnAggrSum;

    /** set 고용보험급여공제년월 : umytPayrDducYrMnth */
    private java.lang.String umytPayrDducYrMnth;

    /** set 고용보험처리일자 : umytInsrPrcsDt */
    private java.lang.String umytInsrPrcsDt;

    /** set 고용보험처리여부 : umytInsrPrcsYn */
    private java.lang.String umytInsrPrcsYn;

    /** set 개인실업급여고용보험차액 : umytInsrPrmmSrd */
    private java.math.BigDecimal umytInsrPrmmSrd;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private java.math.BigDecimal divdPymt;

   
    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
    
    /** PAY_MNTH_AMNT */
    private java.math.BigDecimal payMnthAmnt;
    
    
    
    /** INDV_PYMT_SUM */
    private java.math.BigDecimal indvPymtSum;
    
    /** DPOB_BRDN_SUM */
    private java.math.BigDecimal dpobBrdnSum;
    
    /** PYMT_SUM */
    private java.math.BigDecimal pymtSum;
    
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
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    
    
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 27. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 27. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.math.BigDecimal getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(java.math.BigDecimal payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.math.BigDecimal getUmytInsrApmrt() {
        return this.umytInsrApmrt;
    }
    
    public void setUmytInsrApmrt(java.math.BigDecimal umytInsrApmrt) {
        this.umytInsrApmrt = umytInsrApmrt;
    }
    
    public java.math.BigDecimal getIndvPymtSum() {
        return this.indvPymtSum;
    }
    
    public void setIndvPymtSum(java.math.BigDecimal indvPymtSum) {
        this.indvPymtSum = indvPymtSum;
    }
    
    public java.math.BigDecimal getDpobBrdnSum() {
        return this.dpobBrdnSum;
    }
    
    public void setDpobBrdnSum(java.math.BigDecimal dpobBrdnSum) {
        this.dpobBrdnSum = dpobBrdnSum;
    }
    
    public java.math.BigDecimal getPymtSum() {
        return this.pymtSum;
    }
    
    public void setPymtSum(java.math.BigDecimal pymtSum) {
        this.pymtSum = pymtSum;
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

	/**
	 * Comment : 원본 주민등록번호
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 원본 주민등록번호 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getIposYrMnth()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the iposYrMnth get
	 */
	public java.lang.String getIposYrMnth() {
		return iposYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setIposYrMnth(java.lang.String iposYrMnth)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param iposYrMnth the iposYrMnth to set
	 */
	public void setIposYrMnth(java.lang.String iposYrMnth) {
		this.iposYrMnth = iposYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrBgnnDt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytInsrBgnnDt get
	 */
	public java.lang.String getUmytInsrBgnnDt() {
		return umytInsrBgnnDt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrBgnnDt(java.lang.String umytInsrBgnnDt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytInsrBgnnDt the umytInsrBgnnDt to set
	 */
	public void setUmytInsrBgnnDt(java.lang.String umytInsrBgnnDt) {
		this.umytInsrBgnnDt = umytInsrBgnnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrEndDt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytInsrEndDt get
	 */
	public java.lang.String getUmytInsrEndDt() {
		return umytInsrEndDt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrEndDt(java.lang.String umytInsrEndDt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytInsrEndDt the umytInsrEndDt to set
	 */
	public void setUmytInsrEndDt(java.lang.String umytInsrEndDt) {
		this.umytInsrEndDt = umytInsrEndDt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getMnthAvgPayMnthAmnt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the mnthAvgPayMnthAmnt get
	 */
	public java.math.BigDecimal getMnthAvgPayMnthAmnt() {
		return mnthAvgPayMnthAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setMnthAvgPayMnthAmnt(java.math.BigDecimal mnthAvgPayMnthAmnt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param mnthAvgPayMnthAmnt the mnthAvgPayMnthAmnt to set
	 */
	public void setMnthAvgPayMnthAmnt(java.math.BigDecimal mnthAvgPayMnthAmnt) {
		this.mnthAvgPayMnthAmnt = mnthAvgPayMnthAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getCmpttnWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the cmpttnWkppUneplrtSum get
	 */
	public java.math.BigDecimal getCmpttnWkppUneplrtSum() {
		return cmpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnWkppUneplrtSum(java.math.BigDecimal cmpttnWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param cmpttnWkppUneplrtSum the cmpttnWkppUneplrtSum to set
	 */
	public void setCmpttnWkppUneplrtSum(java.math.BigDecimal cmpttnWkppUneplrtSum) {
		this.cmpttnWkppUneplrtSum = cmpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getCmpttnEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the cmpttnEplrUneplrtSum get
	 */
	public java.math.BigDecimal getCmpttnEplrUneplrtSum() {
		return cmpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnEplrUneplrtSum(java.math.BigDecimal cmpttnEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param cmpttnEplrUneplrtSum the cmpttnEplrUneplrtSum to set
	 */
	public void setCmpttnEplrUneplrtSum(java.math.BigDecimal cmpttnEplrUneplrtSum) {
		this.cmpttnEplrUneplrtSum = cmpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getCmpttnEplrFncdsnInsurSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the cmpttnEplrFncdsnInsurSum get
	 */
	public java.math.BigDecimal getCmpttnEplrFncdsnInsurSum() {
		return cmpttnEplrFncdsnInsurSum;
	}

	/**
	 * Comment : 
	 *@fn void setCmpttnEplrFncdsnInsurSum(java.math.BigDecimal cmpttnEplrFncdsnInsurSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param cmpttnEplrFncdsnInsurSum the cmpttnEplrFncdsnInsurSum to set
	 */
	public void setCmpttnEplrFncdsnInsurSum(
			java.math.BigDecimal cmpttnEplrFncdsnInsurSum) {
		this.cmpttnEplrFncdsnInsurSum = cmpttnEplrFncdsnInsurSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getRecpttnWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the recpttnWkppUneplrtSum get
	 */
	public java.math.BigDecimal getRecpttnWkppUneplrtSum() {
		return recpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnWkppUneplrtSum(java.math.BigDecimal recpttnWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param recpttnWkppUneplrtSum the recpttnWkppUneplrtSum to set
	 */
	public void setRecpttnWkppUneplrtSum(java.math.BigDecimal recpttnWkppUneplrtSum) {
		this.recpttnWkppUneplrtSum = recpttnWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getRecpttnEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the recpttnEplrUneplrtSum get
	 */
	public java.math.BigDecimal getRecpttnEplrUneplrtSum() {
		return recpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnEplrUneplrtSum(java.math.BigDecimal recpttnEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param recpttnEplrUneplrtSum the recpttnEplrUneplrtSum to set
	 */
	public void setRecpttnEplrUneplrtSum(java.math.BigDecimal recpttnEplrUneplrtSum) {
		this.recpttnEplrUneplrtSum = recpttnEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getRecpttnEplrFncdsnSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the recpttnEplrFncdsnSum get
	 */
	public java.math.BigDecimal getRecpttnEplrFncdsnSum() {
		return recpttnEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 *@fn void setRecpttnEplrFncdsnSum(java.math.BigDecimal recpttnEplrFncdsnSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param recpttnEplrFncdsnSum the recpttnEplrFncdsnSum to set
	 */
	public void setRecpttnEplrFncdsnSum(java.math.BigDecimal recpttnEplrFncdsnSum) {
		this.recpttnEplrFncdsnSum = recpttnEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getClutPayTotAmnt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the clutPayTotAmnt get
	 */
	public java.math.BigDecimal getClutPayTotAmnt() {
		return clutPayTotAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setClutPayTotAmnt(java.math.BigDecimal clutPayTotAmnt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param clutPayTotAmnt the clutPayTotAmnt to set
	 */
	public void setClutPayTotAmnt(java.math.BigDecimal clutPayTotAmnt) {
		this.clutPayTotAmnt = clutPayTotAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getClutWkppUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the clutWkppUneplrtSum get
	 */
	public java.math.BigDecimal getClutWkppUneplrtSum() {
		return clutWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutWkppUneplrtSum(java.math.BigDecimal clutWkppUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param clutWkppUneplrtSum the clutWkppUneplrtSum to set
	 */
	public void setClutWkppUneplrtSum(java.math.BigDecimal clutWkppUneplrtSum) {
		this.clutWkppUneplrtSum = clutWkppUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getClutEplrUneplrtSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the clutEplrUneplrtSum get
	 */
	public java.math.BigDecimal getClutEplrUneplrtSum() {
		return clutEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutEplrUneplrtSum(java.math.BigDecimal clutEplrUneplrtSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param clutEplrUneplrtSum the clutEplrUneplrtSum to set
	 */
	public void setClutEplrUneplrtSum(java.math.BigDecimal clutEplrUneplrtSum) {
		this.clutEplrUneplrtSum = clutEplrUneplrtSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getClutEplrFncdsnSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the clutEplrFncdsnSum get
	 */
	public java.math.BigDecimal getClutEplrFncdsnSum() {
		return clutEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 *@fn void setClutEplrFncdsnSum(java.math.BigDecimal clutEplrFncdsnSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param clutEplrFncdsnSum the clutEplrFncdsnSum to set
	 */
	public void setClutEplrFncdsnSum(java.math.BigDecimal clutEplrFncdsnSum) {
		this.clutEplrFncdsnSum = clutEplrFncdsnSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPayCalcEmymtInsurSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the payCalcEmymtInsurSum get
	 */
	public java.math.BigDecimal getPayCalcEmymtInsurSum() {
		return payCalcEmymtInsurSum;
	}

	/**
	 * Comment : 
	 *@fn void setPayCalcEmymtInsurSum(java.math.BigDecimal payCalcEmymtInsurSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param payCalcEmymtInsurSum the payCalcEmymtInsurSum to set
	 */
	public void setPayCalcEmymtInsurSum(java.math.BigDecimal payCalcEmymtInsurSum) {
		this.payCalcEmymtInsurSum = payCalcEmymtInsurSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getIndvUneplrtPymtAggrSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the indvUneplrtPymtAggrSum get
	 */
	public java.math.BigDecimal getIndvUneplrtPymtAggrSum() {
		return indvUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setIndvUneplrtPymtAggrSum(java.math.BigDecimal indvUneplrtPymtAggrSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param indvUneplrtPymtAggrSum the indvUneplrtPymtAggrSum to set
	 */
	public void setIndvUneplrtPymtAggrSum(
			java.math.BigDecimal indvUneplrtPymtAggrSum) {
		this.indvUneplrtPymtAggrSum = indvUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEplrUneplrtPymtAggrSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the eplrUneplrtPymtAggrSum get
	 */
	public java.math.BigDecimal getEplrUneplrtPymtAggrSum() {
		return eplrUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setEplrUneplrtPymtAggrSum(java.math.BigDecimal eplrUneplrtPymtAggrSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param eplrUneplrtPymtAggrSum the eplrUneplrtPymtAggrSum to set
	 */
	public void setEplrUneplrtPymtAggrSum(
			java.math.BigDecimal eplrUneplrtPymtAggrSum) {
		this.eplrUneplrtPymtAggrSum = eplrUneplrtPymtAggrSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEplrFncdsnAggrSum()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the eplrFncdsnAggrSum get
	 */
	public java.math.BigDecimal getEplrFncdsnAggrSum() {
		return eplrFncdsnAggrSum;
	}

	/**
	 * Comment : 
	 *@fn void setEplrFncdsnAggrSum(java.math.BigDecimal eplrFncdsnAggrSum)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param eplrFncdsnAggrSum the eplrFncdsnAggrSum to set
	 */
	public void setEplrFncdsnAggrSum(java.math.BigDecimal eplrFncdsnAggrSum) {
		this.eplrFncdsnAggrSum = eplrFncdsnAggrSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytPayrDducYrMnth()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytPayrDducYrMnth get
	 */
	public java.lang.String getUmytPayrDducYrMnth() {
		return umytPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setUmytPayrDducYrMnth(java.lang.String umytPayrDducYrMnth)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytPayrDducYrMnth the umytPayrDducYrMnth to set
	 */
	public void setUmytPayrDducYrMnth(java.lang.String umytPayrDducYrMnth) {
		this.umytPayrDducYrMnth = umytPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrPrcsDt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytInsrPrcsDt get
	 */
	public java.lang.String getUmytInsrPrcsDt() {
		return umytInsrPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrcsDt(java.lang.String umytInsrPrcsDt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytInsrPrcsDt the umytInsrPrcsDt to set
	 */
	public void setUmytInsrPrcsDt(java.lang.String umytInsrPrcsDt) {
		this.umytInsrPrcsDt = umytInsrPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUmytInsrPrcsYn()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytInsrPrcsYn get
	 */
	public java.lang.String getUmytInsrPrcsYn() {
		return umytInsrPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrcsYn(java.lang.String umytInsrPrcsYn)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytInsrPrcsYn the umytInsrPrcsYn to set
	 */
	public void setUmytInsrPrcsYn(java.lang.String umytInsrPrcsYn) {
		this.umytInsrPrcsYn = umytInsrPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getUmytInsrPrmmSrd()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the umytInsrPrmmSrd get
	 */
	public java.math.BigDecimal getUmytInsrPrmmSrd() {
		return umytInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 *@fn void setUmytInsrPrmmSrd(java.math.BigDecimal umytInsrPrmmSrd)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param umytInsrPrmmSrd the umytInsrPrmmSrd to set
	 */
	public void setUmytInsrPrmmSrd(java.math.BigDecimal umytInsrPrmmSrd) {
		this.umytInsrPrmmSrd = umytInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymtDivCd()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the divdPymtDivCd get
	 */
	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtDivCd(java.lang.String divdPymtDivCd)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param divdPymtDivCd the divdPymtDivCd to set
	 */
	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getDivdPymt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the divdPymt get
	 */
	public java.math.BigDecimal getDivdPymt() {
		return divdPymt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymt(java.math.BigDecimal divdPymt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param divdPymt the divdPymt to set
	 */
	public void setDivdPymt(java.math.BigDecimal divdPymt) {
		this.divdPymt = divdPymt;
	}
	
	
    
}
