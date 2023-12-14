package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3300VO.java
 * @Description : Insr3300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr3300VO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 고지년월 : nofctYrMnth */
    private java.lang.String nofctYrMnth;

    /** set 고지차수 : nofctDspty */
    private java.math.BigDecimal nofctDspty;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 건강보험일련번호 : hlthInsrSeilNum */
  //  private java.math.BigDecimal hlthInsrSeilNum;


	/** set 고용일련번호 : emymtSeilNum */
    private BigDecimal  emymtSeilNum;

    /** set 공제년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 건강보험처리일자 : hlthInsrPrcsDt */
    private java.lang.String hlthInsrPrcsDt;

    /** set 건강보험처리여부 : hlthInsrPrcsYn */
    private java.lang.String hlthInsrPrcsYn;

    /** set 건강보험보험료차액 : hlthInsrPrmmSrd */
    private java.math.BigDecimal hlthInsrPrmmSrd;

    /** set 장기요양보험차액 : lgtmRcptnInsurSrd */
    private java.math.BigDecimal lgtmRcptnInsurSrd;

    /** set 건강보험정산보험료 : yrtxPrmm */
    private java.math.BigDecimal yrtxPrmm;

    /** set 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
    private java.math.BigDecimal lgtmRcptnYrtxPrmm;

    /** set 건강보험환급금이자 : hlthInsrRefdItrt */
    private java.math.BigDecimal hlthInsrRefdItrt;

    /** set 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
    private java.math.BigDecimal lgtmRcptnInsurRefdItrt;

    /** set 차액합계 : srdAggrSum */
    private java.math.BigDecimal srdAggrSum;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private java.math.BigDecimal divdPymt;

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
    
    
    public java.math.BigDecimal getYrtxPrmm() {
		return yrtxPrmm;
	}

	public void setYrtxPrmm(java.math.BigDecimal yrtxPrmm) {
		this.yrtxPrmm = yrtxPrmm;
	}

	public java.math.BigDecimal getLgtmRcptnYrtxPrmm() {
		return lgtmRcptnYrtxPrmm;
	}

	public void setLgtmRcptnYrtxPrmm(java.math.BigDecimal lgtmRcptnYrtxPrmm) {
		this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getNofctYrMnth() {
        return this.nofctYrMnth;
    }
    
    public void setNofctYrMnth(java.lang.String nofctYrMnth) {
        this.nofctYrMnth = nofctYrMnth;
    }
    
    public java.math.BigDecimal getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(java.math.BigDecimal nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
//    public java.math.BigDecimal getHlthInsrSeilNum() {
//        return this.hlthInsrSeilNum;
//    }
//    
//    public void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum) {
//        this.hlthInsrSeilNum = hlthInsrSeilNum;
//    }
    
    
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
    public java.lang.String getHlthInsrPrcsDt() {
        return this.hlthInsrPrcsDt;
    }
    
    public void setHlthInsrPrcsDt(java.lang.String hlthInsrPrcsDt) {
        this.hlthInsrPrcsDt = hlthInsrPrcsDt;
    }
    
    public java.lang.String getHlthInsrPrcsYn() {
        return this.hlthInsrPrcsYn;
    }
    
    public void setHlthInsrPrcsYn(java.lang.String hlthInsrPrcsYn) {
        this.hlthInsrPrcsYn = hlthInsrPrcsYn;
    }
    
    public java.math.BigDecimal getHlthInsrPrmmSrd() {
        return this.hlthInsrPrmmSrd;
    }
    
    public void setHlthInsrPrmmSrd(java.math.BigDecimal hlthInsrPrmmSrd) {
        this.hlthInsrPrmmSrd = hlthInsrPrmmSrd;
    }
    
    public java.math.BigDecimal getLgtmRcptnInsurSrd() {
        return this.lgtmRcptnInsurSrd;
    }
    
    public void setLgtmRcptnInsurSrd(java.math.BigDecimal lgtmRcptnInsurSrd) {
        this.lgtmRcptnInsurSrd = lgtmRcptnInsurSrd;
    }
    
    public java.math.BigDecimal getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(java.math.BigDecimal hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public java.math.BigDecimal getLgtmRcptnInsurRefdItrt() {
        return this.lgtmRcptnInsurRefdItrt;
    }
    
    public void setLgtmRcptnInsurRefdItrt(java.math.BigDecimal lgtmRcptnInsurRefdItrt) {
        this.lgtmRcptnInsurRefdItrt = lgtmRcptnInsurRefdItrt;
    }
    
    public java.math.BigDecimal getSrdAggrSum() {
        return this.srdAggrSum;
    }
    
    public void setSrdAggrSum(java.math.BigDecimal srdAggrSum) {
        this.srdAggrSum = srdAggrSum;
    }
    
    public java.lang.String getDivdPymtDivCd() {
        return this.divdPymtDivCd;
    }
    
    public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
        this.divdPymtDivCd = divdPymtDivCd;
    }
    
    public java.math.BigDecimal getDivdPymt() {
        return this.divdPymt;
    }
    
    public void setDivdPymt(java.math.BigDecimal divdPymt) {
        this.divdPymt = divdPymt;
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
