package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0500VO.java
 * @Description : Payr0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0500VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 근속기준일자 : logSvcStdDt */
    private java.lang.String logSvcStdDt;

    /** set 부녀자여부 : wmnYn */
    private java.lang.String wmnYn;

    /** set 퇴직정산여부 : retryClutYn */
    private java.lang.String retryClutYn;

    /** set 급여대상자여부 : payRcptYn */
    private java.lang.String payRcptYn;

    /** set 배우자유무 : spueYn */
    private java.lang.String spueYn;

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    private java.lang.String hlthInsrApptnYn;

    /** set 국민연금적용여부 : natPennApptnYn */
    private java.lang.String natPennApptnYn;

    /** set 고용보험적용여부 : umytInsrApptnYn */
    private java.lang.String umytInsrApptnYn;

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    private java.lang.String idtlAccdtInsurApptnYn;

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    private java.math.BigDecimal suprtFamyNumTwenChDn;

    /** set 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
    private java.lang.String suprtFamyNumTreOvrChdnYn;

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    private java.math.BigDecimal suprtFamyNumEtc;

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    private java.lang.String chdnSchlExpnAdmclYn;

    /** set 근속수당적용여부 : logSvcExtpyApptnYn */
    private java.lang.String logSvcExtpyApptnYn;

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

    /** set 월급여일당금액 : mnthPayDlywagSum */
    private java.math.BigDecimal mnthPayDlywagSum;
    
    private java.lang.String dayWorkYn; //일용직구분 
    
    /** set 급여소득세제외여부  : payrIncmExceYn */
    private String payrIncmExceYn;
    
    /** set 사회보험년도 : soctyInsurYr */
    private java.lang.String soctyInsurYr;

    /** set 건강보험변동일자 : hlthInsurFlucDt */
    private java.lang.String hlthInsurFlucDt;

    /** set 건강보험보수총액 : hlthInsrPayTotAmnt */
    private java.math.BigDecimal hlthInsrPayTotAmnt;

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    private java.math.BigDecimal hlthInsrMnthRuntnAmnt;

    /** set 건강보험등급 : hlthInsrGrde */
    private java.lang.String hlthInsrGrde;

    /** set 건강보험증번호 : hlthInsrCertNum */
    private java.lang.String hlthInsrCertNum;

    /** set 국민연금변동일자 : natPennInsurFlucDt */
    private java.lang.String natPennInsurFlucDt;

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    private java.math.BigDecimal natPennStdIncmMnthAmnt;

    /** set 국민연금등급 : natPennGrde */
    private java.lang.String natPennGrde;
 
    /** set 고용보험변동일자 : umytInsrFlucDt */
    private java.lang.String umytInsrFlucDt;

    /** set 고용보험보수총액 : umytInsrPayTotAmnt */
    private java.math.BigDecimal umytInsrPayTotAmnt;

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    private java.math.BigDecimal umytInsrPayMnthAmnt;

    /** set 산재보험변동일자 : idtlAccdtFlucDt */
    private java.lang.String idtlAccdtFlucDt;

    /** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
    private java.math.BigDecimal idtlAccdtPayTotAmnt;

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    private java.math.BigDecimal idtlAccdtPayMnthAmnt;
   
    /**  column 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd  ;          
    /**  column 근속월수코드 : logSvcYrNumNm */
    private java.lang.String  logSvcMnthIcmCd  ;   
    


    /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    private java.lang.String addIncmTxApptnRtoCd;

    /** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
    private java.lang.String addIncmTxApptnYrMnth;

    /** set 추가소득세적용여부 : addIncmTxApptnYn */
    private java.lang.String addIncmTxApptnYn;
    
    
    
    /** set 이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
    private java.lang.String befIncmTxApptnRtoCd;

    /** set 이전 추가소득세적용년월 : befIncmTxApptnYrMnth */
    private java.lang.String befIncmTxApptnYrMnth;

    /** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
    private String befIncmTxApptnYn;
     
    /** set 해당년도 추가소득세적용갯수 : addIncmTxApptnCnt */
    private String addIncmTxApptnCnt;
    
    private String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    public String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getBefIncmTxApptnRtoCd() {
		return befIncmTxApptnRtoCd;
	}

	public void setBefIncmTxApptnRtoCd(java.lang.String befIncmTxApptnRtoCd) {
		this.befIncmTxApptnRtoCd = befIncmTxApptnRtoCd;
	}

	public java.lang.String getBefIncmTxApptnYrMnth() {
		return befIncmTxApptnYrMnth;
	}

	public void setBefIncmTxApptnYrMnth(java.lang.String befIncmTxApptnYrMnth) {
		this.befIncmTxApptnYrMnth = befIncmTxApptnYrMnth;
	}

	public String getBefIncmTxApptnYn() {
		return befIncmTxApptnYn;
	}

	public void setBefIncmTxApptnYn(String befIncmTxApptnYn) {
		this.befIncmTxApptnYn = befIncmTxApptnYn;
	}

	public String getAddIncmTxApptnCnt() {
		return addIncmTxApptnCnt;
	}

	public void setAddIncmTxApptnCnt(String addIncmTxApptnCnt) {
		this.addIncmTxApptnCnt = addIncmTxApptnCnt;
	}

	public java.lang.String getAddIncmTxApptnRtoCd() {
		return addIncmTxApptnRtoCd;
	}

	public void setAddIncmTxApptnRtoCd(java.lang.String addIncmTxApptnRtoCd) {
		this.addIncmTxApptnRtoCd = addIncmTxApptnRtoCd;
	}

	public java.lang.String getAddIncmTxApptnYrMnth() {
		return addIncmTxApptnYrMnth;
	}

	public void setAddIncmTxApptnYrMnth(java.lang.String addIncmTxApptnYrMnth) {
		this.addIncmTxApptnYrMnth = addIncmTxApptnYrMnth;
	}

	public java.lang.String getAddIncmTxApptnYn() {
		return addIncmTxApptnYn;
	}

	public void setAddIncmTxApptnYn(java.lang.String addIncmTxApptnYn) {
		this.addIncmTxApptnYn = addIncmTxApptnYn;
	}

	public java.lang.String getDayWorkYn() {
        return dayWorkYn;
    }

    public void setDayWorkYn(java.lang.String dayWorkYn) {
        this.dayWorkYn = dayWorkYn;
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
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getLogSvcStdDt() {
        return this.logSvcStdDt;
    }
    
    public void setLogSvcStdDt(java.lang.String logSvcStdDt) {
        this.logSvcStdDt = logSvcStdDt;
    }
    
    public java.lang.String getWmnYn() {
        return this.wmnYn;
    }
    
    public void setWmnYn(java.lang.String wmnYn) {
        this.wmnYn = wmnYn;
    }
    
    public java.lang.String getRetryClutYn() {
        return this.retryClutYn;
    }
    
    public void setRetryClutYn(java.lang.String retryClutYn) {
        this.retryClutYn = retryClutYn;
    }
    
    public java.lang.String getPayRcptYn() {
        return this.payRcptYn;
    }
    
    public void setPayRcptYn(java.lang.String payRcptYn) {
        this.payRcptYn = payRcptYn;
    }
    
    public java.lang.String getSpueYn() {
        return this.spueYn;
    }
    
    public void setSpueYn(java.lang.String spueYn) {
        this.spueYn = spueYn;
    }
    
    public java.lang.String getHlthInsrApptnYn() {
        return this.hlthInsrApptnYn;
    }
    
    public void setHlthInsrApptnYn(java.lang.String hlthInsrApptnYn) {
        this.hlthInsrApptnYn = hlthInsrApptnYn;
    }
    
    public java.lang.String getNatPennApptnYn() {
        return this.natPennApptnYn;
    }
    
    public void setNatPennApptnYn(java.lang.String natPennApptnYn) {
        this.natPennApptnYn = natPennApptnYn;
    }
    
    public java.lang.String getUmytInsrApptnYn() {
        return this.umytInsrApptnYn;
    }
    
    public void setUmytInsrApptnYn(java.lang.String umytInsrApptnYn) {
        this.umytInsrApptnYn = umytInsrApptnYn;
    }
    
    public java.lang.String getIdtlAccdtInsurApptnYn() {
        return this.idtlAccdtInsurApptnYn;
    }
    
    public void setIdtlAccdtInsurApptnYn(java.lang.String idtlAccdtInsurApptnYn) {
        this.idtlAccdtInsurApptnYn = idtlAccdtInsurApptnYn;
    }
    
    public BigDecimal getSuprtFamyNumTwenChDn() {
        return this.suprtFamyNumTwenChDn;
    }
    
    public void setSuprtFamyNumTwenChDn(BigDecimal suprtFamyNumTwenChDn) {
        this.suprtFamyNumTwenChDn = suprtFamyNumTwenChDn;
    }
    
    
    public java.lang.String getSuprtFamyNumTreOvrChdnYn() {
        return suprtFamyNumTreOvrChdnYn;
    }

    public void setSuprtFamyNumTreOvrChdnYn(java.lang.String suprtFamyNumTreOvrChdnYn) {
        this.suprtFamyNumTreOvrChdnYn = suprtFamyNumTreOvrChdnYn;
    }

    public java.math.BigDecimal getMnthPayDlywagSum() {
        return mnthPayDlywagSum;
    }

    public void setMnthPayDlywagSum(java.math.BigDecimal mnthPayDlywagSum) {
        this.mnthPayDlywagSum = mnthPayDlywagSum;
    }

    public java.lang.String getSoctyInsurYr() {
        return soctyInsurYr;
    }

    public void setSoctyInsurYr(java.lang.String soctyInsurYr) {
        this.soctyInsurYr = soctyInsurYr;
    }

    public java.lang.String getHlthInsurFlucDt() {
        return hlthInsurFlucDt;
    }

    public void setHlthInsurFlucDt(java.lang.String hlthInsurFlucDt) {
        this.hlthInsurFlucDt = hlthInsurFlucDt;
    }

    public java.math.BigDecimal getHlthInsrPayTotAmnt() {
        return hlthInsrPayTotAmnt;
    }

    public void setHlthInsrPayTotAmnt(java.math.BigDecimal hlthInsrPayTotAmnt) {
        this.hlthInsrPayTotAmnt = hlthInsrPayTotAmnt;
    }

    public java.math.BigDecimal getHlthInsrMnthRuntnAmnt() {
        return hlthInsrMnthRuntnAmnt;
    }

    public void setHlthInsrMnthRuntnAmnt(java.math.BigDecimal hlthInsrMnthRuntnAmnt) {
        this.hlthInsrMnthRuntnAmnt = hlthInsrMnthRuntnAmnt;
    }

    public java.lang.String getHlthInsrGrde() {
        return hlthInsrGrde;
    }

    public void setHlthInsrGrde(java.lang.String hlthInsrGrde) {
        this.hlthInsrGrde = hlthInsrGrde;
    }

    public java.lang.String getHlthInsrCertNum() {
        return hlthInsrCertNum;
    }

    public void setHlthInsrCertNum(java.lang.String hlthInsrCertNum) {
        this.hlthInsrCertNum = hlthInsrCertNum;
    }

    public java.lang.String getNatPennInsurFlucDt() {
        return natPennInsurFlucDt;
    }

    public void setNatPennInsurFlucDt(java.lang.String natPennInsurFlucDt) {
        this.natPennInsurFlucDt = natPennInsurFlucDt;
    }

    public java.math.BigDecimal getNatPennStdIncmMnthAmnt() {
        return natPennStdIncmMnthAmnt;
    }

    public void setNatPennStdIncmMnthAmnt(java.math.BigDecimal natPennStdIncmMnthAmnt) {
        this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
    }

    public java.lang.String getNatPennGrde() {
        return natPennGrde;
    }

    public void setNatPennGrde(java.lang.String natPennGrde) {
        this.natPennGrde = natPennGrde;
    }

    public java.lang.String getUmytInsrFlucDt() {
        return umytInsrFlucDt;
    }

    public void setUmytInsrFlucDt(java.lang.String umytInsrFlucDt) {
        this.umytInsrFlucDt = umytInsrFlucDt;
    }

    public java.math.BigDecimal getUmytInsrPayTotAmnt() {
        return umytInsrPayTotAmnt;
    }

    public void setUmytInsrPayTotAmnt(java.math.BigDecimal umytInsrPayTotAmnt) {
        this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
    }

    public java.math.BigDecimal getUmytInsrPayMnthAmnt() {
        return umytInsrPayMnthAmnt;
    }

    public void setUmytInsrPayMnthAmnt(java.math.BigDecimal umytInsrPayMnthAmnt) {
        this.umytInsrPayMnthAmnt = umytInsrPayMnthAmnt;
    }

    public java.lang.String getIdtlAccdtFlucDt() {
        return idtlAccdtFlucDt;
    }

    public void setIdtlAccdtFlucDt(java.lang.String idtlAccdtFlucDt) {
        this.idtlAccdtFlucDt = idtlAccdtFlucDt;
    }

    public java.math.BigDecimal getIdtlAccdtPayTotAmnt() {
        return idtlAccdtPayTotAmnt;
    }

    public void setIdtlAccdtPayTotAmnt(java.math.BigDecimal idtlAccdtPayTotAmnt) {
        this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
    }

    public java.math.BigDecimal getIdtlAccdtPayMnthAmnt() {
        return idtlAccdtPayMnthAmnt;
    }

    public void setIdtlAccdtPayMnthAmnt(java.math.BigDecimal idtlAccdtPayMnthAmnt) {
        this.idtlAccdtPayMnthAmnt = idtlAccdtPayMnthAmnt;
    }

    public BigDecimal getSuprtFamyNumEtc() {
        return this.suprtFamyNumEtc;
    }
    
    public void setSuprtFamyNumEtc(BigDecimal suprtFamyNumEtc) {
        this.suprtFamyNumEtc = suprtFamyNumEtc;
    }
    
    public java.lang.String getChdnSchlExpnAdmclYn() {
        return this.chdnSchlExpnAdmclYn;
    }
    
    public void setChdnSchlExpnAdmclYn(java.lang.String chdnSchlExpnAdmclYn) {
        this.chdnSchlExpnAdmclYn = chdnSchlExpnAdmclYn;
    }
    
    public java.lang.String getLogSvcExtpyApptnYn() {
        return this.logSvcExtpyApptnYn;
    }
    
    public void setLogSvcExtpyApptnYn(java.lang.String logSvcExtpyApptnYn) {
        this.logSvcExtpyApptnYn = logSvcExtpyApptnYn;
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

	/**
	 * Comment :  급여소득세제외여부
	 * @fn String getPayrIncmExceYn()
	 * @brief date:2016 2016. 6. 30. user:Administrator
	 * @return the payrIncmExceYn get
	 */
	public String getPayrIncmExceYn() {
		return payrIncmExceYn;
	}

	/**
	 * Comment : 급여소득세제외여부
	 *@fn void setPayrIncmExceYn(String payrIncmExceYn)
	 *@brief date:2016 2016. 6. 30. user:Administrator
	 *@param payrIncmExceYn the payrIncmExceYn to set
	 */
	public void setPayrIncmExceYn(String payrIncmExceYn) {
		this.payrIncmExceYn = payrIncmExceYn;
	}
    
}
