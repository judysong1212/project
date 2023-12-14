package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0302VO.java
 * @Description : Payr0302 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0302VO  implements Serializable {
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

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 급여항목일련번호 : payItemSeilNum */
    private java.math.BigDecimal payItemSeilNum;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    private java.math.BigDecimal pymtDducFreeDtySum;

    /** set 지급공제금액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 급여지급공제처리플래그 : payPymtDducPrcsFlag */
    private java.lang.String payPymtDducPrcsFlag;

    /** set 급여지급공제소급조정값 : payReattyAdmntVal */
    private java.lang.String payReattyAdmntVal;

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

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    private java.math.BigDecimal pymtDducTxtnAmnt;

    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    private java.lang.String pyytYrtxDotnCd;

    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    private java.lang.String pyytYtfeDtyReduCd;
    
    /** set 급여지급공제변경여부 : pymtDducChgYn */
    private java.lang.String pymtDducChgYn; 
 
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd = "";
     
    
    /**
	 * Comment : 급여지급공제변경여부
	 * @fn java.lang.String getPymtDducChgYn()
	 * @brief date:2017 2017. 7. 25. user:atres
	 * @return the pymtDducChgYn get
	 */
	public java.lang.String getPymtDducChgYn() {
		return pymtDducChgYn;
	}

	/**
	 * Comment : 급여지급공제변경여부
	 *@fn void setPymtDducChgYn(java.lang.String pymtDducChgYn)
	 *@brief date:2017 2017. 7. 25. user:atres
	 *@param pymtDducChgYn the pymtDducChgYn to set
	 */
	public void setPymtDducChgYn(java.lang.String pymtDducChgYn) {
		this.pymtDducChgYn = pymtDducChgYn;
	}

	public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.math.BigDecimal getPymtDducTxtnAmnt() {
        return pymtDducTxtnAmnt;
    }

    public void setPymtDducTxtnAmnt(java.math.BigDecimal pymtDducTxtnAmnt) {
        this.pymtDducTxtnAmnt = pymtDducTxtnAmnt;
    }

    public java.lang.String getPymtYrMnth() {
        return this.pymtYrMnth;
    }
    
    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
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
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
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
    
    public BigDecimal getPayItemSeilNum() {
        return this.payItemSeilNum;
    }
    
    public void setPayItemSeilNum(BigDecimal payItemSeilNum) {
        this.payItemSeilNum = payItemSeilNum;
    }
    
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    public BigDecimal getPymtDducFreeDtySum() {
        return this.pymtDducFreeDtySum;
    }
    
    public void setPymtDducFreeDtySum(BigDecimal pymtDducFreeDtySum) {
        this.pymtDducFreeDtySum = pymtDducFreeDtySum;
    }
    
    public BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getPayPymtDducPrcsFlag() {
        return this.payPymtDducPrcsFlag;
    }
    
    public void setPayPymtDducPrcsFlag(java.lang.String payPymtDducPrcsFlag) {
        this.payPymtDducPrcsFlag = payPymtDducPrcsFlag;
    }
    
    public java.lang.String getPayReattyAdmntVal() {
        return this.payReattyAdmntVal;
    }
    
    public void setPayReattyAdmntVal(java.lang.String payReattyAdmntVal) {
        this.payReattyAdmntVal = payReattyAdmntVal;
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
	 * Comment : 
	 * @fn java.lang.String getPyytYrtxDotnCd()
	 * @brief date:2017 2017. 7. 9. user:atres
	 * @return the pyytYrtxDotnCd get
	 */
	public java.lang.String getPyytYrtxDotnCd() {
		return pyytYrtxDotnCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyytYrtxDotnCd(java.lang.String pyytYrtxDotnCd)
	 *@brief date:2017 2017. 7. 9. user:atres
	 *@param pyytYrtxDotnCd the pyytYrtxDotnCd to set
	 */
	public void setPyytYrtxDotnCd(java.lang.String pyytYrtxDotnCd) {
		this.pyytYrtxDotnCd = pyytYrtxDotnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyytYtfeDtyReduCd()
	 * @brief date:2017 2017. 7. 9. user:atres
	 * @return the pyytYtfeDtyReduCd get
	 */
	public java.lang.String getPyytYtfeDtyReduCd() {
		return pyytYtfeDtyReduCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyytYtfeDtyReduCd(java.lang.String pyytYtfeDtyReduCd)
	 *@brief date:2017 2017. 7. 9. user:atres
	 *@param pyytYtfeDtyReduCd the pyytYtfeDtyReduCd to set
	 */
	public void setPyytYtfeDtyReduCd(java.lang.String pyytYtfeDtyReduCd) {
		this.pyytYtfeDtyReduCd = pyytYtfeDtyReduCd;
	}
    
}
