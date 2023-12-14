package com.app.exterms.insurance.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3150VO.java
 * @Description : Insr3150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.03.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3150DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 건간보험정산귀속년도 : hlthInsrYr */
    private java.lang.String hlthInsrYr;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;

    /** set 차수 : dspty */
    private java.lang.String dspty;

    /** set 사업장관리번호 : dpobMangeNum */
    private java.lang.String dpobMangeNum;

    /** set 회계 : acc */
    private java.lang.String acc;

    /** set 단위사업장코드 : untDpobCd */
    private java.lang.String untDpobCd;

    /** set 증번호 : certNumHuhd */
    private java.lang.String certNumHuhd;

    /** set 성명 : hlthNm */
    private java.lang.String hlthNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;


    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
      
    /** set 건강보험취득일자 : hlthInsrAqtnDt */
    private java.lang.String hlthInsrAqtnDt;

    /** set 보험료부과월수_건강 : iposPrmmMnthHlth */
    private java.math.BigDecimal iposPrmmMnthHlth;

    /** set 보험료부과월수_장기 : iposPrmmMnthRcptn */
    private java.math.BigDecimal iposPrmmMnthRcptn;

    /** set 부과한총보험료_계 : iposTotPrmmAggr */
    private java.math.BigDecimal iposTotPrmmAggr;

    /** set 부과한총보험료_건강 : iposTotPrmmHlth */
    private java.math.BigDecimal iposTotPrmmHlth;

    /** set 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
    private java.math.BigDecimal iposTotPrmmLgtmRcptn;

    /** set 연간보수총액 : yrlyPayTotAmnt */
    private java.math.BigDecimal yrlyPayTotAmnt;

    /** set 근무월수 : dutyMnthIcm */
    private java.math.BigDecimal dutyMnthIcm;

    /** set 고지유예 : nofctSspn */
    private java.lang.String nofctSspn;

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
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getHlthInsrYr() {
        return this.hlthInsrYr;
    }
    
    public void setHlthInsrYr(java.lang.String hlthInsrYr) {
        this.hlthInsrYr = hlthInsrYr;
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

	public java.lang.String getDspty() {
        return this.dspty;
    }
    
    public void setDspty(java.lang.String dspty) {
        this.dspty = dspty;
    }
    
    public java.lang.String getDpobMangeNum() {
        return this.dpobMangeNum;
    }
    
    public void setDpobMangeNum(java.lang.String dpobMangeNum) {
        this.dpobMangeNum = dpobMangeNum;
    }
    
    public java.lang.String getAcc() {
        return this.acc;
    }
    
    public void setAcc(java.lang.String acc) {
        this.acc = acc;
    }
    
    public java.lang.String getUntDpobCd() {
        return this.untDpobCd;
    }
    
    public void setUntDpobCd(java.lang.String untDpobCd) {
        this.untDpobCd = untDpobCd;
    }
    
    public java.lang.String getCertNumHuhd() {
        return this.certNumHuhd;
    }
    
    public void setCertNumHuhd(java.lang.String certNumHuhd) {
        this.certNumHuhd = certNumHuhd;
    }
    
    public java.lang.String getHlthNm() {
        return this.hlthNm;
    }
    
    public void setHlthNm(java.lang.String hlthNm) {
        this.hlthNm = hlthNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getHlthInsrAqtnDt() {
        return this.hlthInsrAqtnDt;
    }
    
    public void setHlthInsrAqtnDt(java.lang.String hlthInsrAqtnDt) {
        this.hlthInsrAqtnDt = hlthInsrAqtnDt;
    }
    
    public java.math.BigDecimal getIposPrmmMnthHlth() {
        return this.iposPrmmMnthHlth;
    }
    
    public void setIposPrmmMnthHlth(java.math.BigDecimal iposPrmmMnthHlth) {
        this.iposPrmmMnthHlth = iposPrmmMnthHlth;
    }
    
    public java.math.BigDecimal getIposPrmmMnthRcptn() {
        return this.iposPrmmMnthRcptn;
    }
    
    public void setIposPrmmMnthRcptn(java.math.BigDecimal iposPrmmMnthRcptn) {
        this.iposPrmmMnthRcptn = iposPrmmMnthRcptn;
    }
    
    public java.math.BigDecimal getIposTotPrmmAggr() {
        return this.iposTotPrmmAggr;
    }
    
    public void setIposTotPrmmAggr(java.math.BigDecimal iposTotPrmmAggr) {
        this.iposTotPrmmAggr = iposTotPrmmAggr;
    }
    
    public java.math.BigDecimal getIposTotPrmmHlth() {
        return this.iposTotPrmmHlth;
    }
    
    public void setIposTotPrmmHlth(java.math.BigDecimal iposTotPrmmHlth) {
        this.iposTotPrmmHlth = iposTotPrmmHlth;
    }
    
    public java.math.BigDecimal getIposTotPrmmLgtmRcptn() {
        return this.iposTotPrmmLgtmRcptn;
    }
    
    public void setIposTotPrmmLgtmRcptn(java.math.BigDecimal iposTotPrmmLgtmRcptn) {
        this.iposTotPrmmLgtmRcptn = iposTotPrmmLgtmRcptn;
    }
    
    public java.math.BigDecimal getYrlyPayTotAmnt() {
        return this.yrlyPayTotAmnt;
    }
    
    public void setYrlyPayTotAmnt(java.math.BigDecimal yrlyPayTotAmnt) {
        this.yrlyPayTotAmnt = yrlyPayTotAmnt;
    }
    
    public java.math.BigDecimal getDutyMnthIcm() {
        return this.dutyMnthIcm;
    }
    
    public void setDutyMnthIcm(java.math.BigDecimal dutyMnthIcm) {
        this.dutyMnthIcm = dutyMnthIcm;
    }
    
    public java.lang.String getNofctSspn() {
        return this.nofctSspn;
    }
    
    public void setNofctSspn(java.lang.String nofctSspn) {
        this.nofctSspn = nofctSspn;
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
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
}
