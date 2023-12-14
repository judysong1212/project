package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

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
public class Insr3300VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 고지년월 : nofctYrMnth */
    private java.lang.String nofctYrMnth;

    /** set 고지차수 : nofctDspty */
    private Long nofctDspty;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** RESN_REGN_NUM 주민등록번호*/
    private java.lang.String resnRegnNum;

	/** set 고용일련번호 : emymtSeilNum */
    private Long  emymtSeilNum;

    /** set 공제년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 건강보험처리일자 : hlthInsrPrcsDt */
    private java.lang.String hlthInsrPrcsDt;

    /** set 건강보험처리여부 : hlthInsrPrcsYn */
    private java.lang.String hlthInsrPrcsYn;

    /** set 건강보험보험료차액 : hlthInsrPrmmSrd */
    private Long hlthInsrPrmmSrd;

    /** set 장기요양보험차액 : lgtmRcptnInsurSrd */
    private Long lgtmRcptnInsurSrd;

    /** set 건강보험정산보험료 : yrtxPrmm */
    private Long yrtxPrmm;

    /** set 장기요양정산보험료 : lgtmRcptnYrtxPrmm */
    private Long lgtmRcptnYrtxPrmm;

    /** set 건강보험환급금이자 : hlthInsrRefdItrt */
    private Long hlthInsrRefdItrt;

    /** set 장기요양보험환급금이자 : lgtmRcptnInsurRefdItrt */
    private Long lgtmRcptnInsurRefdItrt;

    /** set 차액합계 : srdAggrSum */
    private Long srdAggrSum;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private Long divdPymt;

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
    
    
    
    public Long getYrtxPrmm() {
		return yrtxPrmm;
	}

	public void setYrtxPrmm(Long yrtxPrmm) {
		this.yrtxPrmm = yrtxPrmm;
	}

	public Long getLgtmRcptnYrtxPrmm() {
		return lgtmRcptnYrtxPrmm;
	}

	public void setLgtmRcptnYrtxPrmm(Long lgtmRcptnYrtxPrmm) {
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
    
    public Long getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(Long nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
  	public java.lang.String getResnRegnNum() {
  		return resnRegnNum;
  	}

  	public void setResnRegnNum(java.lang.String resnRegnNum) {
  		this.resnRegnNum = resnRegnNum;
  	}   
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    /**
	 * Comment : 
	 * @fn Long getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 27. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(Long emymtSeilNum)
	 *@brief date:2016 2016. 4. 27. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(Long emymtSeilNum) {
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
    
    public Long getHlthInsrPrmmSrd() {
        return this.hlthInsrPrmmSrd;
    }
    
    public void setHlthInsrPrmmSrd(Long hlthInsrPrmmSrd) {
        this.hlthInsrPrmmSrd = hlthInsrPrmmSrd;
    }
    
    public Long getLgtmRcptnInsurSrd() {
        return this.lgtmRcptnInsurSrd;
    }
    
    public void setLgtmRcptnInsurSrd(Long lgtmRcptnInsurSrd) {
        this.lgtmRcptnInsurSrd = lgtmRcptnInsurSrd;
    }
    
    public Long getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(Long hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public Long getLgtmRcptnInsurRefdItrt() {
        return this.lgtmRcptnInsurRefdItrt;
    }
    
    public void setLgtmRcptnInsurRefdItrt(Long lgtmRcptnInsurRefdItrt) {
        this.lgtmRcptnInsurRefdItrt = lgtmRcptnInsurRefdItrt;
    }
    
    public Long getSrdAggrSum() {
        return this.srdAggrSum;
    }
    
    public void setSrdAggrSum(Long srdAggrSum) {
        this.srdAggrSum = srdAggrSum;
    }
    
    public java.lang.String getDivdPymtDivCd() {
        return this.divdPymtDivCd;
    }
    
    public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
        this.divdPymtDivCd = divdPymtDivCd;
    }
    
    public Long getDivdPymt() {
        return this.divdPymt;
    }
    
    public void setDivdPymt(Long divdPymt) {
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
