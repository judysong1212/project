package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0460VO.java
 * @Description : Payr0460 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0460VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 항목수당일련번호 : payPymtItemListSeilNum */
    private java.math.BigDecimal payPymtItemListSeilNum;

    /** set 항목수당구분코드 : itemExtpyDivCd */
    private java.lang.String itemExtpyDivCd;

    /** set 시작년수 : styrNum */
    private java.lang.String styrNum;

    /** set 종료년수 : edyrNum */
    private java.lang.String edyrNum;

    /** set 지급공제율 : pymtDducRate */
    private java.math.BigDecimal pymtDducRate;

    /** set 지급공제금액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 항목별수당삭제여부 : itemListExtpyDelYn */
    private java.lang.String itemListExtpyDelYn;

    /** set 항목별수당비고내용 : rmak */
    private java.lang.String rmak;

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

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 추가가산금액 : addPymtDducSum */
    private java.math.BigDecimal addPymtDducSum;
 
    
    /** ODTY_DTIL_OCCU_CLS_CD */
    private java.lang.String odtyDtilOccuClsCd;
     
    
    /** ODTY_DTIL_OCCU_CLS_SUM */
    private BigDecimal odtyDtilOccuClsSum;
    
    /** ODTY_DTIL_OCCU_CLS_NOTE_CTNT */
    private java.lang.String odtyDtilOccuClsNoteCtnt;
    
    /** ODTY_DTIL_OCCU_CLS_DEL_YN */
    private java.lang.String odtyDtilOccuClsDelYn;
     
    
    
    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getPayPymtItemListSeilNum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the payPymtItemListSeilNum get
	 */
	public java.math.BigDecimal getPayPymtItemListSeilNum() {
		return payPymtItemListSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setPayPymtItemListSeilNum(java.math.BigDecimal payPymtItemListSeilNum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param payPymtItemListSeilNum the payPymtItemListSeilNum to set
	 */
	public void setPayPymtItemListSeilNum(
			java.math.BigDecimal payPymtItemListSeilNum) {
		this.payPymtItemListSeilNum = payPymtItemListSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getItemExtpyDivCd()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the itemExtpyDivCd get
	 */
	public java.lang.String getItemExtpyDivCd() {
		return itemExtpyDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setItemExtpyDivCd(java.lang.String itemExtpyDivCd)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param itemExtpyDivCd the itemExtpyDivCd to set
	 */
	public void setItemExtpyDivCd(java.lang.String itemExtpyDivCd) {
		this.itemExtpyDivCd = itemExtpyDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getStyrNum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the styrNum get
	 */
	public java.lang.String getStyrNum() {
		return styrNum;
	}

	/**
	 * Comment : 
	 *@fn void setStyrNum(java.lang.String styrNum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param styrNum the styrNum to set
	 */
	public void setStyrNum(java.lang.String styrNum) {
		this.styrNum = styrNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEdyrNum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the edyrNum get
	 */
	public java.lang.String getEdyrNum() {
		return edyrNum;
	}

	/**
	 * Comment : 
	 *@fn void setEdyrNum(java.lang.String edyrNum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param edyrNum the edyrNum to set
	 */
	public void setEdyrNum(java.lang.String edyrNum) {
		this.edyrNum = edyrNum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPymtDducRate()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the pymtDducRate get
	 */
	public java.math.BigDecimal getPymtDducRate() {
		return pymtDducRate;
	}

	/**
	 * Comment : 
	 *@fn void setPymtDducRate(java.math.BigDecimal pymtDducRate)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param pymtDducRate the pymtDducRate to set
	 */
	public void setPymtDducRate(java.math.BigDecimal pymtDducRate) {
		this.pymtDducRate = pymtDducRate;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getPymtDducSum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the pymtDducSum get
	 */
	public java.math.BigDecimal getPymtDducSum() {
		return pymtDducSum;
	}

	/**
	 * Comment : 
	 *@fn void setPymtDducSum(java.math.BigDecimal pymtDducSum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param pymtDducSum the pymtDducSum to set
	 */
	public void setPymtDducSum(java.math.BigDecimal pymtDducSum) {
		this.pymtDducSum = pymtDducSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getItemListExtpyDelYn()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the itemListExtpyDelYn get
	 */
	public java.lang.String getItemListExtpyDelYn() {
		return itemListExtpyDelYn;
	}

	/**
	 * Comment : 
	 *@fn void setItemListExtpyDelYn(java.lang.String itemListExtpyDelYn)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param itemListExtpyDelYn the itemListExtpyDelYn to set
	 */
	public void setItemListExtpyDelYn(java.lang.String itemListExtpyDelYn) {
		this.itemListExtpyDelYn = itemListExtpyDelYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRmak()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the rmak get
	 */
	public java.lang.String getRmak() {
		return rmak;
	}

	/**
	 * Comment : 
	 *@fn void setRmak(java.lang.String rmak)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param rmak the rmak to set
	 */
	public void setRmak(java.lang.String rmak) {
		this.rmak = rmak;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getAddPymtDducSum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the addPymtDducSum get
	 */
	public java.math.BigDecimal getAddPymtDducSum() {
		return addPymtDducSum;
	}

	/**
	 * Comment : 
	 *@fn void setAddPymtDducSum(java.math.BigDecimal addPymtDducSum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param addPymtDducSum the addPymtDducSum to set
	 */
	public void setAddPymtDducSum(java.math.BigDecimal addPymtDducSum) {
		this.addPymtDducSum = addPymtDducSum;
	}

	public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getOdtyDtilOccuClsCd() {
        return this.odtyDtilOccuClsCd;
    }
    
    public void setOdtyDtilOccuClsCd(java.lang.String odtyDtilOccuClsCd) {
        this.odtyDtilOccuClsCd = odtyDtilOccuClsCd;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public BigDecimal getOdtyDtilOccuClsSum() {
        return this.odtyDtilOccuClsSum;
    }
    
    public void setOdtyDtilOccuClsSum(BigDecimal odtyDtilOccuClsSum) {
        this.odtyDtilOccuClsSum = odtyDtilOccuClsSum;
    }
    
    public java.lang.String getOdtyDtilOccuClsNoteCtnt() {
        return this.odtyDtilOccuClsNoteCtnt;
    }
    
    public void setOdtyDtilOccuClsNoteCtnt(java.lang.String odtyDtilOccuClsNoteCtnt) {
        this.odtyDtilOccuClsNoteCtnt = odtyDtilOccuClsNoteCtnt;
    }
    
    public java.lang.String getOdtyDtilOccuClsDelYn() {
        return this.odtyDtilOccuClsDelYn;
    }
    
    public void setOdtyDtilOccuClsDelYn(java.lang.String odtyDtilOccuClsDelYn) {
        this.odtyDtilOccuClsDelYn = odtyDtilOccuClsDelYn;
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
