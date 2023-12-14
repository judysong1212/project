package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr3200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** NOFCT_YR_MNTH */
    private java.lang.String nofctYrMnth;
    
    /** NOFCT_DSPTY */
    private java.math.BigDecimal nofctDspty;
    
//    /** HLTH_INSR_SEIL_NUM */
//    private java.math.BigDecimal hlthInsrSeilNum;
    
    /** set 고용일련번호 : emymtSeilNum */
  	private BigDecimal  emymtSeilNum;
  	
    /** DPOB_MANGE_NUM */
    private java.lang.String dpobMangeNum;
    
    /** UNT_ISTUT_CD */
    private java.lang.String untIstutCd;
    
    /** ACC_SGN */
    private java.lang.String accSgn;
    
    /** HLTH_INSR_CERT_NUM */
    private java.lang.String hlthInsrCertNum;
    
    /** HAN_NM */
    private java.lang.String hanNm;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    

    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
    
    /** REDU_REAS_CD */
    private java.lang.String reduReasCd;
    
    /** HLTH_INSR_TYP_OCCU_CD */
    private java.lang.String hlthInsrTypOccuCd;
    
    /** PAY_MNTH_AMNT_GRDE */
    private java.math.BigDecimal payMnthAmntGrde;
    
    /** PAY_MNTH_AMNT */
    private java.math.BigDecimal payMnthAmnt;
    
    /** CALC_PRMM */
    private java.math.BigDecimal calcPrmm;
    
    /** CLUT_REAS_CD */
    private java.lang.String clutReasCd;
    
    /** CLUT_APPTN_BGNN_YR_MNTH */
    private java.lang.String clutApptnBgnnYrMnth;
    
    /** CLUT_APPTN_END_YR_MNTH */
    private java.lang.String clutApptnEndYrMnth;
    
    /** CLUT_PRMM */
    private java.math.BigDecimal clutPrmm;
    
    /** NOFCT_PRMM */
    private java.math.BigDecimal nofctPrmm;
    
    /** YRTX_PRMM */
    private java.math.BigDecimal yrtxPrmm;
    
    /** AQTN_DT */
    private java.lang.String aqtnDt;
    
    /** LSS_DT */
    private java.lang.String lssDt;
    
    /** LGTM_RCPTN_CALC_PRMM */
    private java.math.BigDecimal lgtmRcptnCalcPrmm;
    
    /** LGTM_RCPTN_CLUT_REAS_CD */
    private java.lang.String lgtmRcptnClutReasCd;
    
    /** LGTM_RCPTN_APPTN_BGNN_YR_MNTH */
    private java.lang.String lgtmRcptnApptnBgnnYrMnth;
    
    /** LGTM_RCPTN_APPTN_END_YR_MNTH */
    private java.lang.String lgtmRcptnApptnEndYrMnth;
    
    /** LGTM_RCPTN_CLUT_PRMM */
    private java.math.BigDecimal lgtmRcptnClutPrmm;
    
    /** LGTM_RCPTN_NOFCT_PRMM */
    private java.math.BigDecimal lgtmRcptnNofctPrmm;
    
    /** LGTM_RCPTN_YRTX_PRMM */
    private java.math.BigDecimal lgtmRcptnYrtxPrmm;
    
    /** HLTH_RCPTN_CALC_PRMM */
    private java.math.BigDecimal hlthRcptnCalcPrmm;
    
    /** HLTH_RCPTN_CLUT_PRMM */
    private java.math.BigDecimal hlthRcptnClutPrmm;
    
    /** HLTH_RCPTN_NOFCT_PRMM */
    private java.math.BigDecimal hlthRcptnNofctPrmm;
    
    /** HLTH_RCPTN_YRTX_PRMM */
    private java.math.BigDecimal hlthRcptnYrtxPrmm;
    
    /** HLTH_INSR_REFD_ITRT */
    private java.math.BigDecimal hlthInsrRefdItrt;
    
    /** LGTM_RCPTN_REFD_ITRT */
    private java.math.BigDecimal lgtmRcptnRefdItrt;
    
    /** TOT_PYMT_PRMM */
    private java.math.BigDecimal totPymtPrmm;
    
    /** DDUC_YR_MNTH */
    private java.lang.String dducYrMnth;
    
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
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
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
    
//    public java.math.BigDecimal getHlthInsrSeilNum() {
//        return this.hlthInsrSeilNum;
//    }
//    
//    public void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum) {
//        this.hlthInsrSeilNum = hlthInsrSeilNum;
//    }
    
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
    
    public java.lang.String getUntIstutCd() {
        return this.untIstutCd;
    }
    
    public void setUntIstutCd(java.lang.String untIstutCd) {
        this.untIstutCd = untIstutCd;
    }
    
    public java.lang.String getAccSgn() {
        return this.accSgn;
    }
    
    public void setAccSgn(java.lang.String accSgn) {
        this.accSgn = accSgn;
    }
    
    public java.lang.String getHlthInsrCertNum() {
        return this.hlthInsrCertNum;
    }
    
    public void setHlthInsrCertNum(java.lang.String hlthInsrCertNum) {
        this.hlthInsrCertNum = hlthInsrCertNum;
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
    
    public java.lang.String getReduReasCd() {
        return this.reduReasCd;
    }
    
    public void setReduReasCd(java.lang.String reduReasCd) {
        this.reduReasCd = reduReasCd;
    }
    
    public java.lang.String getHlthInsrTypOccuCd() {
        return this.hlthInsrTypOccuCd;
    }
    
    public void setHlthInsrTypOccuCd(java.lang.String hlthInsrTypOccuCd) {
        this.hlthInsrTypOccuCd = hlthInsrTypOccuCd;
    }
    
    public java.math.BigDecimal getPayMnthAmntGrde() {
        return this.payMnthAmntGrde;
    }
    
    public void setPayMnthAmntGrde(java.math.BigDecimal payMnthAmntGrde) {
        this.payMnthAmntGrde = payMnthAmntGrde;
    }
    
    public java.math.BigDecimal getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(java.math.BigDecimal payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.math.BigDecimal getCalcPrmm() {
        return this.calcPrmm;
    }
    
    public void setCalcPrmm(java.math.BigDecimal calcPrmm) {
        this.calcPrmm = calcPrmm;
    }
    
    public java.lang.String getClutReasCd() {
        return this.clutReasCd;
    }
    
    public void setClutReasCd(java.lang.String clutReasCd) {
        this.clutReasCd = clutReasCd;
    }
    
    public java.lang.String getClutApptnBgnnYrMnth() {
        return this.clutApptnBgnnYrMnth;
    }
    
    public void setClutApptnBgnnYrMnth(java.lang.String clutApptnBgnnYrMnth) {
        this.clutApptnBgnnYrMnth = clutApptnBgnnYrMnth;
    }
    
    public java.lang.String getClutApptnEndYrMnth() {
        return this.clutApptnEndYrMnth;
    }
    
    public void setClutApptnEndYrMnth(java.lang.String clutApptnEndYrMnth) {
        this.clutApptnEndYrMnth = clutApptnEndYrMnth;
    }
    
    public java.math.BigDecimal getClutPrmm() {
        return this.clutPrmm;
    }
    
    public void setClutPrmm(java.math.BigDecimal clutPrmm) {
        this.clutPrmm = clutPrmm;
    }
    
    public java.math.BigDecimal getNofctPrmm() {
        return this.nofctPrmm;
    }
    
    public void setNofctPrmm(java.math.BigDecimal nofctPrmm) {
        this.nofctPrmm = nofctPrmm;
    }
    
    public java.math.BigDecimal getYrtxPrmm() {
        return this.yrtxPrmm;
    }
    
    public void setYrtxPrmm(java.math.BigDecimal yrtxPrmm) {
        this.yrtxPrmm = yrtxPrmm;
    }
    
    public java.lang.String getAqtnDt() {
        return this.aqtnDt;
    }
    
    public void setAqtnDt(java.lang.String aqtnDt) {
        this.aqtnDt = aqtnDt;
    }
    
    public java.lang.String getLssDt() {
        return this.lssDt;
    }
    
    public void setLssDt(java.lang.String lssDt) {
        this.lssDt = lssDt;
    }
    
    public java.math.BigDecimal getLgtmRcptnCalcPrmm() {
        return this.lgtmRcptnCalcPrmm;
    }
    
    public void setLgtmRcptnCalcPrmm(java.math.BigDecimal lgtmRcptnCalcPrmm) {
        this.lgtmRcptnCalcPrmm = lgtmRcptnCalcPrmm;
    }
    
    public java.lang.String getLgtmRcptnClutReasCd() {
        return this.lgtmRcptnClutReasCd;
    }
    
    public void setLgtmRcptnClutReasCd(java.lang.String lgtmRcptnClutReasCd) {
        this.lgtmRcptnClutReasCd = lgtmRcptnClutReasCd;
    }
    
    public java.lang.String getLgtmRcptnApptnBgnnYrMnth() {
        return this.lgtmRcptnApptnBgnnYrMnth;
    }
    
    public void setLgtmRcptnApptnBgnnYrMnth(java.lang.String lgtmRcptnApptnBgnnYrMnth) {
        this.lgtmRcptnApptnBgnnYrMnth = lgtmRcptnApptnBgnnYrMnth;
    }
    
    public java.lang.String getLgtmRcptnApptnEndYrMnth() {
        return this.lgtmRcptnApptnEndYrMnth;
    }
    
    public void setLgtmRcptnApptnEndYrMnth(java.lang.String lgtmRcptnApptnEndYrMnth) {
        this.lgtmRcptnApptnEndYrMnth = lgtmRcptnApptnEndYrMnth;
    }
    
    public java.math.BigDecimal getLgtmRcptnClutPrmm() {
        return this.lgtmRcptnClutPrmm;
    }
    
    public void setLgtmRcptnClutPrmm(java.math.BigDecimal lgtmRcptnClutPrmm) {
        this.lgtmRcptnClutPrmm = lgtmRcptnClutPrmm;
    }
    
    public java.math.BigDecimal getLgtmRcptnNofctPrmm() {
        return this.lgtmRcptnNofctPrmm;
    }
    
    public void setLgtmRcptnNofctPrmm(java.math.BigDecimal lgtmRcptnNofctPrmm) {
        this.lgtmRcptnNofctPrmm = lgtmRcptnNofctPrmm;
    }
    
    public java.math.BigDecimal getLgtmRcptnYrtxPrmm() {
        return this.lgtmRcptnYrtxPrmm;
    }
    
    public void setLgtmRcptnYrtxPrmm(java.math.BigDecimal lgtmRcptnYrtxPrmm) {
        this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnCalcPrmm() {
        return this.hlthRcptnCalcPrmm;
    }
    
    public void setHlthRcptnCalcPrmm(java.math.BigDecimal hlthRcptnCalcPrmm) {
        this.hlthRcptnCalcPrmm = hlthRcptnCalcPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnClutPrmm() {
        return this.hlthRcptnClutPrmm;
    }
    
    public void setHlthRcptnClutPrmm(java.math.BigDecimal hlthRcptnClutPrmm) {
        this.hlthRcptnClutPrmm = hlthRcptnClutPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnNofctPrmm() {
        return this.hlthRcptnNofctPrmm;
    }
    
    public void setHlthRcptnNofctPrmm(java.math.BigDecimal hlthRcptnNofctPrmm) {
        this.hlthRcptnNofctPrmm = hlthRcptnNofctPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnYrtxPrmm() {
        return this.hlthRcptnYrtxPrmm;
    }
    
    public void setHlthRcptnYrtxPrmm(java.math.BigDecimal hlthRcptnYrtxPrmm) {
        this.hlthRcptnYrtxPrmm = hlthRcptnYrtxPrmm;
    }
    
    public java.math.BigDecimal getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(java.math.BigDecimal hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public java.math.BigDecimal getLgtmRcptnRefdItrt() {
        return this.lgtmRcptnRefdItrt;
    }
    
    public void setLgtmRcptnRefdItrt(java.math.BigDecimal lgtmRcptnRefdItrt) {
        this.lgtmRcptnRefdItrt = lgtmRcptnRefdItrt;
    }
    
    public java.math.BigDecimal getTotPymtPrmm() {
        return this.totPymtPrmm;
    }
    
    public void setTotPymtPrmm(java.math.BigDecimal totPymtPrmm) {
        this.totPymtPrmm = totPymtPrmm;
    }
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
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
