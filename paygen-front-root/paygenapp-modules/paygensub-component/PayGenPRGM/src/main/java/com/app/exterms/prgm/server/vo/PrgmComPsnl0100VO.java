package com.app.exterms.prgm.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComPsnl0100VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM */
    private java.lang.String hanNm;
    
    /** ENG_NM */
    private java.lang.String engNm;
    
    /** CHIN_CHAR_NM */
    private java.lang.String chinCharNm;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** SX_DIV_CD */
    private java.lang.String sxDivCd;
    
    /** YOOBH_MNTH_DAY */
    private java.lang.String yoobhMnthDay;
    
    /** SCLC_DIV_CD */
    private java.lang.String sclcDivCd;
    
    /** NATN_CD */
    private java.lang.String natnCd;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** BUSIN_CD */
    private java.lang.String businCd;
    
    /** CURR_AFFN_DEPT_CD */
    private java.lang.String currAffnDeptCd;
    
    /** REPBTY_BUSIN_DIV_CD */
    private java.lang.String repbtyBusinDivCd;
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** ODTY_CD */
    private java.lang.String odtyCd;
    
    /** FRST_EMYMT_DT */
    private java.lang.String frstEmymtDt;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** EMYMT_BGNN_DT */
    private java.lang.String emymtBgnnDt;
    
    /** EMYMT_END_DT */
    private java.lang.String emymtEndDt;
    
    /** PYSP_CD */
    private java.lang.String pyspCd;
    
    /** HDOFC_CODTN_CD */
    private java.lang.String hdofcCodtnCd;
    
    /** RETRY_DT */
    private java.lang.String retryDt;
    
    /** RETRY_REAS_CTNT */
    private java.lang.String retryReasCtnt;
    
    /** FRGNR_DIV_CD */
    private java.lang.String frgnrDivCd;
    
    /** PSPT_NUM */
    private java.lang.String psptNum;
    
    /** STY_BGNN_DT */
    private java.lang.String styBgnnDt;
    
    /** STY_END_DT */
    private java.lang.String styEndDt;
    
    /** END_SCHL */
    private java.lang.String endSchl;
    
    /** END_DEGR_DIV_CD */
    private java.lang.String endDegrDivCd;
    
    /** PMTN_SCDU_DT */
    private java.lang.String pmtnScduDt;
    
    /** PYSP_PRMTN_SCDU_DT */
    private java.lang.String pyspPrmtnScduDt;
    
    /** REYMN_SCDU_DT */
    private java.lang.String reymnScduDt;
    
    /** LOG_SVC_YR_NUM */
    private java.math.BigDecimal logSvcYrNumCd;
    
    /** LOG_SVC_MNTH_ICM */
    private java.math.BigDecimal logSvcMnthIcmCd;
    
    /** CURR_PYSP_APPMT_DT */
    private java.lang.String currPyspAppmtDt;
    
    /** CURR_DEPT_APPMT_DT */
    private java.lang.String currDeptAppmtDt;
    
    /** PERN_NOTE_CTNT */
    private java.lang.String pernNoteCtnt;
    
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
  

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 담당업무명 : repbtyBusinNm */
    private java.lang.String repbtyBusinNm;
    
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2015 Dec 22, 2015 user:leeheuisung
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2015 Dec 22, 2015 user:leeheuisung
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 22, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 22, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRepbtyBusinNm()
	 * @brief date:2015 Dec 22, 2015 user:leeheuisung
	 * @return the repbtyBusinNm get
	 */
	public java.lang.String getRepbtyBusinNm() {
		return repbtyBusinNm;
	}

	/**
	 * Comment : 
	 *@fn void setRepbtyBusinNm(java.lang.String repbtyBusinNm)
	 *@brief date:2015 Dec 22, 2015 user:leeheuisung
	 *@param repbtyBusinNm the repbtyBusinNm to set
	 */
	public void setRepbtyBusinNm(java.lang.String repbtyBusinNm) {
		this.repbtyBusinNm = repbtyBusinNm;
	}

	public java.lang.String getDtilOccuClsDivCd() {
        return dtilOccuClsDivCd;
    }

    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }

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
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getEngNm() {
        return this.engNm;
    }
    
    public void setEngNm(java.lang.String engNm) {
        this.engNm = engNm;
    }
    
    public java.lang.String getChinCharNm() {
        return this.chinCharNm;
    }
    
    public void setChinCharNm(java.lang.String chinCharNm) {
        this.chinCharNm = chinCharNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getSxDivCd() {
        return this.sxDivCd;
    }
    
    public void setSxDivCd(java.lang.String sxDivCd) {
        this.sxDivCd = sxDivCd;
    }
    
    public java.lang.String getYoobhMnthDay() {
        return this.yoobhMnthDay;
    }
    
    public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
        this.yoobhMnthDay = yoobhMnthDay;
    }
    
    public java.lang.String getSclcDivCd() {
        return this.sclcDivCd;
    }
    
    public void setSclcDivCd(java.lang.String sclcDivCd) {
        this.sclcDivCd = sclcDivCd;
    }
    
    public java.lang.String getNatnCd() {
        return this.natnCd;
    }
    
    public void setNatnCd(java.lang.String natnCd) {
        this.natnCd = natnCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getCurrAffnDeptCd() {
        return this.currAffnDeptCd;
    }
    
    public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
        this.currAffnDeptCd = currAffnDeptCd;
    }
    
    public java.lang.String getRepbtyBusinDivCd() {
        return this.repbtyBusinDivCd;
    }
    
    public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
        this.repbtyBusinDivCd = repbtyBusinDivCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getOdtyCd() {
        return this.odtyCd;
    }
    
    public void setOdtyCd(java.lang.String odtyCd) {
        this.odtyCd = odtyCd;
    }
    
    public java.lang.String getFrstEmymtDt() {
        return this.frstEmymtDt;
    }
    
    public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
        this.frstEmymtDt = frstEmymtDt;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getEmymtBgnnDt() {
        return this.emymtBgnnDt;
    }
    
    public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
        this.emymtBgnnDt = emymtBgnnDt;
    }
    
    public java.lang.String getEmymtEndDt() {
        return this.emymtEndDt;
    }
    
    public void setEmymtEndDt(java.lang.String emymtEndDt) {
        this.emymtEndDt = emymtEndDt;
    }
    
    public java.lang.String getPyspCd() {
        return this.pyspCd;
    }
    
    public void setPyspCd(java.lang.String pyspCd) {
        this.pyspCd = pyspCd;
    }
    
    public java.lang.String getHdofcCodtnCd() {
        return this.hdofcCodtnCd;
    }
    
    public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
        this.hdofcCodtnCd = hdofcCodtnCd;
    }
    
    public java.lang.String getRetryDt() {
        return this.retryDt;
    }
    
    public void setRetryDt(java.lang.String retryDt) {
        this.retryDt = retryDt;
    }
    
    public java.lang.String getRetryReasCtnt() {
        return this.retryReasCtnt;
    }
    
    public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
        this.retryReasCtnt = retryReasCtnt;
    }
    
    public java.lang.String getFrgnrDivCd() {
        return this.frgnrDivCd;
    }
    
    public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
        this.frgnrDivCd = frgnrDivCd;
    }
    
    public java.lang.String getPsptNum() {
        return this.psptNum;
    }
    
    public void setPsptNum(java.lang.String psptNum) {
        this.psptNum = psptNum;
    }
    
    public java.lang.String getStyBgnnDt() {
        return this.styBgnnDt;
    }
    
    public void setStyBgnnDt(java.lang.String styBgnnDt) {
        this.styBgnnDt = styBgnnDt;
    }
    
    public java.lang.String getStyEndDt() {
        return this.styEndDt;
    }
    
    public void setStyEndDt(java.lang.String styEndDt) {
        this.styEndDt = styEndDt;
    }
    
    public java.lang.String getEndSchl() {
        return this.endSchl;
    }
    
    public void setEndSchl(java.lang.String endSchl) {
        this.endSchl = endSchl;
    }
    
    public java.lang.String getEndDegrDivCd() {
        return this.endDegrDivCd;
    }
    
    public void setEndDegrDivCd(java.lang.String endDegrDivCd) {
        this.endDegrDivCd = endDegrDivCd;
    }
    
    public java.lang.String getPmtnScduDt() {
        return this.pmtnScduDt;
    }
    
    public void setPmtnScduDt(java.lang.String pmtnScduDt) {
        this.pmtnScduDt = pmtnScduDt;
    }
    
    public java.lang.String getPyspPrmtnScduDt() {
        return this.pyspPrmtnScduDt;
    }
    
    public void setPyspPrmtnScduDt(java.lang.String pyspPrmtnScduDt) {
        this.pyspPrmtnScduDt = pyspPrmtnScduDt;
    }
    
    public java.lang.String getReymnScduDt() {
        return this.reymnScduDt;
    }
    
    public void setReymnScduDt(java.lang.String reymnScduDt) {
        this.reymnScduDt = reymnScduDt;
    }
    
    public java.math.BigDecimal getLogSvcYrNumCd() {
        return this.logSvcYrNumCd;
    }
    
    public void setLogSvcYrNumCd(java.math.BigDecimal logSvcYrNumCd) {
        this.logSvcYrNumCd = logSvcYrNumCd;
    }
    
    public java.math.BigDecimal getLogSvcMnthIcmCd() {
        return this.logSvcMnthIcmCd;
    }
    
    public void setLogSvcMnthIcmCd(java.math.BigDecimal logSvcMnthIcmCd) {
        this.logSvcMnthIcmCd = logSvcMnthIcmCd;
    }
    
    public java.lang.String getCurrPyspAppmtDt() {
        return this.currPyspAppmtDt;
    }
    
    public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
        this.currPyspAppmtDt = currPyspAppmtDt;
    }
    
    public java.lang.String getCurrDeptAppmtDt() {
        return this.currDeptAppmtDt;
    }
    
    public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
        this.currDeptAppmtDt = currDeptAppmtDt;
    }
    
    public java.lang.String getPernNoteCtnt() {
        return this.pernNoteCtnt;
    }
    
    public void setPernNoteCtnt(java.lang.String pernNoteCtnt) {
        this.pernNoteCtnt = pernNoteCtnt;
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
