package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0450VO.java
 * @Description : Payr0450 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0450DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 항목수당일련번호 : payPymtItemListSeilNum */
    private Long payPymtItemListSeilNum;

    /** set 항목수당구분코드 : itemExtpyDivCd */
    private java.lang.String itemExtpyDivCd;

    /** set 시작년수 : styrNum */
    private Long styrNum;

    /** set 종료년수 : edyrNum */
    private Long edyrNum;

    /** set 지급공제율 : pymtDducRate */
    private Double  pymtDducRate;

    /** set 지급공제금액 : pymtDducSum */
    private Long pymtDducSum;

    /** set 항목별수당삭제여부 : itemListExtpyDelYn */
    private Boolean itemListExtpyDelYn;

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
    private Long addPymtDducSum;
     
    
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
	 * @fn Long getAddPymtDducSum()
	 * @brief date:2016 2016. 12. 13. user:atres-pc
	 * @return the addPymtDducSum get
	 */
	public Long getAddPymtDducSum() {
		return addPymtDducSum;
	}

	/**
	 * Comment : 
	 *@fn void setAddPymtDducSum(Long addPymtDducSum)
	 *@brief date:2016 2016. 12. 13. user:atres-pc
	 *@param addPymtDducSum the addPymtDducSum to set
	 */
	public void setAddPymtDducSum(Long addPymtDducSum) {
		this.addPymtDducSum = addPymtDducSum;
	}

	public Long getPayPymtItemListSeilNum() {
        return this.payPymtItemListSeilNum;
    }
    
    public void setPayPymtItemListSeilNum(Long payPymtItemListSeilNum) {
        this.payPymtItemListSeilNum = payPymtItemListSeilNum;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getItemExtpyDivCd() {
        return this.itemExtpyDivCd;
    }
    
    public void setItemExtpyDivCd(java.lang.String itemExtpyDivCd) {
        this.itemExtpyDivCd = itemExtpyDivCd;
    }
    
    public Long getStyrNum() {
        return this.styrNum;
    }
    
    public void setStyrNum(Long styrNum) {
        this.styrNum = styrNum;
    }
    
    public Long getEdyrNum() {
        return this.edyrNum;
    }
    
    public void setEdyrNum(Long edyrNum) {
        this.edyrNum = edyrNum;
    }
    
    public Double getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(Double pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public Long getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(Long pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public Boolean getItemListExtpyDelYn() {
        return this.itemListExtpyDelYn;
    }
    
    public void setItemListExtpyDelYn(Boolean itemListExtpyDelYn) {
        this.itemListExtpyDelYn = itemListExtpyDelYn;
    }
    
    public java.lang.String getRmak() {
        return this.rmak;
    }
    
    public void setRmak(java.lang.String rmak) {
        this.rmak = rmak;
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
