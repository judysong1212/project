package com.app.exterms.personal.server.vo;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0100VO extends Psnl0100DefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 영문성명 : engNm */
    private java.lang.String engNm;

    /** set 한문성명 : chinCharNm */
    private java.lang.String chinCharNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    private java.lang.String orgResnNum;  
    
    
    public java.lang.String getOrgResnNum() {
		return orgResnNum;
	}

	public void setOrgResnNum(java.lang.String orgResnNum) {
		this.orgResnNum = orgResnNum;
	}

	/** set 성별구분코드 : sxDivCd */
    private java.lang.String sxDivCd;

    /** set 생년월일 : yoobhMnthDay */
    private java.lang.String yoobhMnthDay;

    /** set 음양구분코드 : sclcDivCd */
    private java.lang.String sclcDivCd;

    /** set 국가코드 : natnCd */
    private java.lang.String natnCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

	/** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;

    /** set 호봉제구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 퇴직사유내용 : retryReasCtnt */
    private java.lang.String retryReasCtnt;

    /** set 외국인구분코드 : frgnrDivCd */
    private java.lang.String frgnrDivCd;

    /** set 여권번호 : psptNum */
    private java.lang.String psptNum;

    /** set 체류시작일자 : styBgnnDt */
    private java.lang.String styBgnnDt;

    /** set 체류종료일자 : styEndDt */
    private java.lang.String styEndDt;

    /** set 최종학교 : endSchl */
    private java.lang.String endSchl;

    /** set 최종학위구분코드 : endDegrDivCd */
    private java.lang.String endDegrDivCd;

    /** set 승진예정일자 : pmtnScduDt */
    private java.lang.String pmtnScduDt;

    /** set 호봉승급예정일자 : pyspPrmtnScduDt */
    private java.lang.String pyspPrmtnScduDt;

    /** set 재고용예정일자 : reymnScduDt */
    private java.lang.String reymnScduDt;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 현_호봉발령일자 : currPyspAppmtDt */
    private java.lang.String currPyspAppmtDt;

    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;

    /** set 인사비고내용 : pernNoteCtnt */
    private java.lang.String pernNoteCtnt;

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

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 담당업무명 : repbtyBusinNm */
    private java.lang.String repbtyBusinNm;
 
 
    /** TYP_OCCU_CD */
    private java.lang.String typComboOccuCd;
    
    
    
    /** set 노조가입여부 : unnMbspSttYn */
    private java.lang.String unnMbspSttYn;
    
    
    private java.math.BigDecimal logSvcDys; 
    private java.lang.String logStdDt;
    private java.math.BigDecimal totLogSvcDys;
    
    private java.lang.String orgLogSvcYrCd;
    private java.lang.String orgLogSvcMnthCd;
    private java.math.BigDecimal orgLogSvcDys; 
    private java.math.BigDecimal orgTotLogSvcDys;
    private java.lang.String reMrkDt;
    
    /** set 호봉제구분코드 : accountDivCd */
    private java.lang.String accountDivCd;
    
    
    
	public java.math.BigDecimal getTotLogSvcDys() {
		return totLogSvcDys;
	}

	public void setTotLogSvcDys(java.math.BigDecimal totLogSvcDys) {
		this.totLogSvcDys = totLogSvcDys;
	}

	public java.lang.String getOrgLogSvcYrCd() {
		return orgLogSvcYrCd;
	}

	public void setOrgLogSvcYrCd(java.lang.String orgLogSvcYrCd) {
		this.orgLogSvcYrCd = orgLogSvcYrCd;
	}

	public java.lang.String getOrgLogSvcMnthCd() {
		return orgLogSvcMnthCd;
	}

	public void setOrgLogSvcMnthCd(java.lang.String orgLogSvcMnthCd) {
		this.orgLogSvcMnthCd = orgLogSvcMnthCd;
	}

	public java.math.BigDecimal getOrgLogSvcDys() {
		return orgLogSvcDys;
	}

	public void setOrgLogSvcDys(java.math.BigDecimal orgLogSvcDys) {
		this.orgLogSvcDys = orgLogSvcDys;
	}

	public java.math.BigDecimal getOrgTotLogSvcDys() {
		return orgTotLogSvcDys;
	}

	public void setOrgTotLogSvcDys(java.math.BigDecimal orgTotLogSvcDys) {
		this.orgTotLogSvcDys = orgTotLogSvcDys;
	}

	public java.lang.String getReMrkDt() {
		return reMrkDt;
	}

	public void setReMrkDt(java.lang.String reMrkDt) {
		this.reMrkDt = reMrkDt;
	}

	public java.lang.String getLogStdDt() {
		return logStdDt;
	}

	public void setLogStdDt(java.lang.String logStdDt) {
		this.logStdDt = logStdDt;
	}

	public java.math.BigDecimal getLogSvcDys() {
		return logSvcDys;
	}

	public void setLogSvcDys(java.math.BigDecimal logSvcDys) {
		this.logSvcDys = logSvcDys;
	}

	public java.lang.String getUnnMbspSttYn() {
		return unnMbspSttYn;
	}

	public void setUnnMbspSttYn(java.lang.String unnMbspSttYn) {
		this.unnMbspSttYn = unnMbspSttYn;
	}

	/**
	 * Comment :  직종세통합코드 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 담당업무명
	 * @fn java.lang.String getRepbtyBusinNm()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the repbtyBusinNm get
	 */
	public java.lang.String getRepbtyBusinNm() {
		return repbtyBusinNm;
	}

	/**
	 * Comment : 담당업무명
	 *@fn void setRepbtyBusinNm(java.lang.String repbtyBusinNm)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
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

    public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public java.lang.String getTypComboOccuCd() {
        return typComboOccuCd;
    }

    public void setTypComboOccuCd(java.lang.String typComboOccuCd) {
        this.typComboOccuCd = typComboOccuCd;
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
    
    public java.lang.String getLogSvcYrNumCd() {
        return logSvcYrNumCd;
    }

    public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
        this.logSvcYrNumCd = logSvcYrNumCd;
    }

    public java.lang.String getLogSvcMnthIcmCd() {
        return logSvcMnthIcmCd;
    }

    public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getAccountDivCd() {
		return accountDivCd;
	}

	public void setAccountDivCd(java.lang.String accountDivCd) {
		this.accountDivCd = accountDivCd;
	}
    
}
