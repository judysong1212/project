package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3100VO.java
 * @Description : Insr3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr3100VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** NOFCT_YR_MNTH_NUM */
    private java.lang.String nofctYrMnthNum;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DSPTY */
    private java.lang.String dspty;
    
    /** HLTH_INSR_SEIL_NUM */
    private java.math.BigDecimal hlthInsrSeilNum;
    
    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;
  	
    /** DPOB_MANGE_NUM */
    private java.lang.String dpobMangeNum;
    
    /** ACC */
    private java.lang.String acc;
    
    /** UNT_DPOB_CD */
    private java.lang.String untDpobCd;
    
    /** CERT_NUM_HUHD */
    private java.lang.String certNumHuhd;
    
    /** NM */
    private java.lang.String nm;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    

    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
 
    /** IPOS_TOT_PRMM_AGGR */
    private java.math.BigDecimal iposTotPrmmAggr;
    
    /** IPOS_TOT_PRMM_HLTH */
    private java.math.BigDecimal iposTotPrmmHlth;
    
    /** IPOS_TOT_PRMM_LGTM_RCPTN */
    private java.math.BigDecimal iposTotPrmmLgtmRcptn;
    
    /** YRLY_PAY_TOT_AMNT */
    private java.math.BigDecimal yrlyPayTotAmnt;
    
    /** DUTY_MNTH_ICM */
    private java.math.BigDecimal dutyMnthIcm;
    
    /** PAY_MNTH_AMNT */
    private java.math.BigDecimal payMnthAmnt;
    
    /** YRTX_CALC_BKDN_GRDE */
    private java.lang.String yrtxCalcBkdnGrde;
    
    /** STD_PAY_MNTH_AMNT */
    private java.math.BigDecimal stdPayMnthAmnt;
    
    /** FIX_PRMM_AGGR */
    private java.math.BigDecimal fixPrmmAggr;
    
    /** FIX_PRMM_HLTH */
    private java.math.BigDecimal fixPrmmHlth;
    
    /** FIX_PRMM_LGTM_RCPTN */
    private java.math.BigDecimal fixPrmmLgtmRcptn;
    
    /** CLUT_PRMM_AGGR */
    private java.math.BigDecimal clutPrmmAggr;
    
    /** CLUT_PRMM_HLTH */
    private java.math.BigDecimal clutPrmmHlth;
    
    /** CLUT_PRMM_LGTM_RCPTN */
    private java.math.BigDecimal clutPrmmLgtmRcptn;
    
    /** MBR_ALTT_AGGR */
    private java.math.BigDecimal mbrAlttAggr;
    
    /** MBR_ALTT_HLTH */
    private java.math.BigDecimal mbrAlttHlth;
    
    /** MBR_ALTT_LGTM_RCPTN */
    private java.math.BigDecimal mbrAlttLgtmRcptn;
    
    /** USR_ALTT_AGGR */
    private java.math.BigDecimal usrAlttAggr;
    
    /** USR_ALTT_HLTH */
    private java.math.BigDecimal usrAlttHlth;
    
    /** USR_ALTT_LGTM_RCPTN */
    private java.math.BigDecimal usrAlttLgtmRcptn;
    
    /** NOFCT_SSPN */
    private java.lang.String nofctSspn;
    
    /** HLTH_YRTX_APPTN_YR_MNTH */
    private java.lang.String hlthYrtxApptnYrMnth;
    
    /** HLTH_YRTX_PRCS_DT */
    private java.lang.String hlthYrtxPrcsDt;
    
    /** HLTH_INSR_YRTX_PRCS_YN */
    private java.lang.String hlthInsrYrtxPrcsYn;
    
    /** DIVD_PYMT_DIV_CD */
    private java.lang.String divdPymtDivCd;
    
    /** DIVD_PYMT */
    private java.math.BigDecimal divdPymt;
    
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
    
    public java.lang.String getNofctYrMnthNum() {
        return this.nofctYrMnthNum;
    }
    
    public void setNofctYrMnthNum(java.lang.String nofctYrMnthNum) {
        this.nofctYrMnthNum = nofctYrMnthNum;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDspty() {
        return this.dspty;
    }
    
    public void setDspty(java.lang.String dspty) {
        this.dspty = dspty;
    }
    
    public java.math.BigDecimal getHlthInsrSeilNum() {
        return this.hlthInsrSeilNum;
    }
    
    public void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum) {
        this.hlthInsrSeilNum = hlthInsrSeilNum;
    }
    
    
    
    public java.lang.String getDpobMangeNum() {
        return this.dpobMangeNum;
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
    
    public java.lang.String getNm() {
        return this.nm;
    }
    
    public void setNm(java.lang.String nm) {
        this.nm = nm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
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
    
    public java.math.BigDecimal getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(java.math.BigDecimal payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.lang.String getYrtxCalcBkdnGrde() {
        return this.yrtxCalcBkdnGrde;
    }
    
    public void setYrtxCalcBkdnGrde(java.lang.String yrtxCalcBkdnGrde) {
        this.yrtxCalcBkdnGrde = yrtxCalcBkdnGrde;
    }
    
    public java.math.BigDecimal getStdPayMnthAmnt() {
        return this.stdPayMnthAmnt;
    }
    
    public void setStdPayMnthAmnt(java.math.BigDecimal stdPayMnthAmnt) {
        this.stdPayMnthAmnt = stdPayMnthAmnt;
    }
    
    public java.math.BigDecimal getFixPrmmAggr() {
        return this.fixPrmmAggr;
    }
    
    public void setFixPrmmAggr(java.math.BigDecimal fixPrmmAggr) {
        this.fixPrmmAggr = fixPrmmAggr;
    }
    
    public java.math.BigDecimal getFixPrmmHlth() {
        return this.fixPrmmHlth;
    }
    
    public void setFixPrmmHlth(java.math.BigDecimal fixPrmmHlth) {
        this.fixPrmmHlth = fixPrmmHlth;
    }
    
    public java.math.BigDecimal getFixPrmmLgtmRcptn() {
        return this.fixPrmmLgtmRcptn;
    }
    
    public void setFixPrmmLgtmRcptn(java.math.BigDecimal fixPrmmLgtmRcptn) {
        this.fixPrmmLgtmRcptn = fixPrmmLgtmRcptn;
    }
    
    public java.math.BigDecimal getClutPrmmAggr() {
        return this.clutPrmmAggr;
    }
    
    public void setClutPrmmAggr(java.math.BigDecimal clutPrmmAggr) {
        this.clutPrmmAggr = clutPrmmAggr;
    }
    
    public java.math.BigDecimal getClutPrmmHlth() {
        return this.clutPrmmHlth;
    }
    
    public void setClutPrmmHlth(java.math.BigDecimal clutPrmmHlth) {
        this.clutPrmmHlth = clutPrmmHlth;
    }
    
    public java.math.BigDecimal getClutPrmmLgtmRcptn() {
        return this.clutPrmmLgtmRcptn;
    }
    
    public void setClutPrmmLgtmRcptn(java.math.BigDecimal clutPrmmLgtmRcptn) {
        this.clutPrmmLgtmRcptn = clutPrmmLgtmRcptn;
    }
    
    public java.math.BigDecimal getMbrAlttAggr() {
        return this.mbrAlttAggr;
    }
    
    public void setMbrAlttAggr(java.math.BigDecimal mbrAlttAggr) {
        this.mbrAlttAggr = mbrAlttAggr;
    }
    
    public java.math.BigDecimal getMbrAlttHlth() {
        return this.mbrAlttHlth;
    }
    
    public void setMbrAlttHlth(java.math.BigDecimal mbrAlttHlth) {
        this.mbrAlttHlth = mbrAlttHlth;
    }
    
    public java.math.BigDecimal getMbrAlttLgtmRcptn() {
        return this.mbrAlttLgtmRcptn;
    }
    
    public void setMbrAlttLgtmRcptn(java.math.BigDecimal mbrAlttLgtmRcptn) {
        this.mbrAlttLgtmRcptn = mbrAlttLgtmRcptn;
    }
    
    public java.math.BigDecimal getUsrAlttAggr() {
        return this.usrAlttAggr;
    }
    
    public void setUsrAlttAggr(java.math.BigDecimal usrAlttAggr) {
        this.usrAlttAggr = usrAlttAggr;
    }
    
    public java.math.BigDecimal getUsrAlttHlth() {
        return this.usrAlttHlth;
    }
    
    public void setUsrAlttHlth(java.math.BigDecimal usrAlttHlth) {
        this.usrAlttHlth = usrAlttHlth;
    }
    
    public java.math.BigDecimal getUsrAlttLgtmRcptn() {
        return this.usrAlttLgtmRcptn;
    }
    
    public void setUsrAlttLgtmRcptn(java.math.BigDecimal usrAlttLgtmRcptn) {
        this.usrAlttLgtmRcptn = usrAlttLgtmRcptn;
    }
    
    public java.lang.String getNofctSspn() {
        return this.nofctSspn;
    }
    
    public void setNofctSspn(java.lang.String nofctSspn) {
        this.nofctSspn = nofctSspn;
    }
    
    public java.lang.String getHlthYrtxApptnYrMnth() {
        return this.hlthYrtxApptnYrMnth;
    }
    
    public void setHlthYrtxApptnYrMnth(java.lang.String hlthYrtxApptnYrMnth) {
        this.hlthYrtxApptnYrMnth = hlthYrtxApptnYrMnth;
    }
    
    public java.lang.String getHlthYrtxPrcsDt() {
        return this.hlthYrtxPrcsDt;
    }
    
    public void setHlthYrtxPrcsDt(java.lang.String hlthYrtxPrcsDt) {
        this.hlthYrtxPrcsDt = hlthYrtxPrcsDt;
    }
    
    public java.lang.String getHlthInsrYrtxPrcsYn() {
        return this.hlthInsrYrtxPrcsYn;
    }
    
    public void setHlthInsrYrtxPrcsYn(java.lang.String hlthInsrYrtxPrcsYn) {
        this.hlthInsrYrtxPrcsYn = hlthInsrYrtxPrcsYn;
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
    
    
}
