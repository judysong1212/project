package com.app.exterms.payroll.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

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
public class Payr0500DTO  implements  IsSerializable {
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
    private Boolean wmnYn;

    /** set 퇴직정산여부 : retryClutYn */
    private Boolean retryClutYn;

    /** set 급여대상자여부 : payRcptYn */
    private Boolean payRcptYn;

    /** set 배우자유무 : spueYn */
    private Boolean spueYn;

    /** set 건강보험적용여부 : hlthInsrApptnYn */
    private Boolean hlthInsrApptnYn;

    /** set 국민연금적용여부 : natPennApptnYn */
    private Boolean natPennApptnYn;

    /** set 고용보험적용여부 : umytInsrApptnYn */
    private Boolean umytInsrApptnYn;

    /** set 산재보험적용여부 : idtlAccdtInsurApptnYn */
    private Boolean idtlAccdtInsurApptnYn;

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    private Long suprtFamyNumTwenChDn;

    /** set 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
    private Boolean suprtFamyNumTreOvrChdnYn;

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    private Long suprtFamyNumEtc;

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    private Boolean chdnSchlExpnAdmclYn;

    /** set 근속수당적용여부 : logSvcExtpyApptnYn */
    private Boolean logSvcExtpyApptnYn;

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
    private Long mnthPayDlywagSum;
    
    private Boolean dayWorkYn; /**  column 일용직구분 : dayWorkYn */ 
   
     
    /** set 사회보험년도 : soctyInsurYr */
    private java.lang.String soctyInsurYr;

    /** set 건강보험변동일자 : hlthInsurFlucDt */
    private java.lang.String hlthInsurFlucDt;

    /** set 건강보험보수총액 : hlthInsrPayTotAmnt */
    private Long hlthInsrPayTotAmnt;

    /** set 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
    private Long hlthInsrMnthRuntnAmnt;

    /** set 건강보험등급 : hlthInsrGrde */
    private java.lang.String hlthInsrGrde;

    /** set 건강보험증번호 : hlthInsrCertNum */
    private java.lang.String hlthInsrCertNum;

    /** set 국민연금변동일자 : natPennInsurFlucDt */
    private java.lang.String natPennInsurFlucDt;

    /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
    private Long natPennStdIncmMnthAmnt;

    /** set 국민연금등급 : natPennGrde */
    private java.lang.String natPennGrde;
 
    /** set 고용보험변동일자 : umytInsrFlucDt */
    private java.lang.String umytInsrFlucDt;

    /** set 고용보험보수총액 : umytInsrPayTotAmnt */
    private Long umytInsrPayTotAmnt;

    /** set 고용보험보수월액 : umytInsrPayMnthAmnt */
    private Long umytInsrPayMnthAmnt;

    /** set 산재보험변동일자 : idtlAccdtFlucDt */
    private java.lang.String idtlAccdtFlucDt;

    /** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
    private Long idtlAccdtPayTotAmnt;

    /** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
    private Long idtlAccdtPayMnthAmnt;
    
    /**  column 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd  ;          
    /**  column 근속월수코드 : logSvcYrNumNm */
    private java.lang.String  logSvcMnthIcmCd  ;   
    
     


    /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    private java.lang.String addIncmTxApptnRtoCd;

    /** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
    private java.lang.String addIncmTxApptnYrMnth;

    /** set 추가소득세적용여부 : addIncmTxApptnYn */
    private String addIncmTxApptnYn;
    
    
    /** set 이전 추가소득세적용비율코드 : befIncmTxApptnRtoCd */
    private java.lang.String befIncmTxApptnRtoCd;

    /** set 이전 추가소득세적용년월 : befIncmTxApptnYrMnth */
    private java.lang.String befIncmTxApptnYrMnth;

    /** set 이전 추가소득세적용여부 : befIncmTxApptnYn */
    private String befIncmTxApptnYn;
     
    /** set 해당년도 추가소득세적용갯수 : addIncmTxApptnCnt */
    private Long addIncmTxApptnCnt;
    
    
    /** set 호봉	 : pyspCd */
    private java.lang.String pyspCd;
    
    /** set 노조가입여부	 : unnMbspSttYn */
    private java.lang.String unnMbspSttYn;
    
    /** set 급여소득세제외여부  : payrIncmExceYn */
    private Boolean payrIncmExceYn; 
    
    

	/**
	 * Comment : 급여소득세제외여부
	 * @fn java.lang.String getPayrIncmExceYn()
	 * @brief date:2016 2016. 6. 30. user:Administrator
	 * @return the payrIncmExceYn get
	 */
	public Boolean getPayrIncmExceYn() {
		return payrIncmExceYn;
	}

	/**
	 * Comment : 급여소득세제외여부
	 *@fn void setPayrIncmExceYn(java.lang.String payrIncmExceYn)
	 *@brief date:2016 2016. 6. 30. user:Administrator
	 *@param payrIncmExceYn the payrIncmExceYn to set
	 */
	public void setPayrIncmExceYn(Boolean payrIncmExceYn) {
		this.payrIncmExceYn = payrIncmExceYn;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getUnnMbspSttYn() {
		return unnMbspSttYn;
	}

	public void setUnnMbspSttYn(java.lang.String unnMbspSttYn) {
		this.unnMbspSttYn = unnMbspSttYn;
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

 

	public Long getAddIncmTxApptnCnt() {
		return addIncmTxApptnCnt;
	}

	public void setAddIncmTxApptnCnt(Long addIncmTxApptnCnt) {
		this.addIncmTxApptnCnt = addIncmTxApptnCnt;
	}

	public String getAddIncmTxApptnYn() {
		return addIncmTxApptnYn;
	}

	public void setAddIncmTxApptnYn(String addIncmTxApptnYn) {
		this.addIncmTxApptnYn = addIncmTxApptnYn;
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
 

	public Boolean getDayWorkYn() {
        return dayWorkYn;
    }

    public void setDayWorkYn(Boolean dayWorkYn) {
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

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getEmymtDivCd() {
        return emymtDivCd;
    }

    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }

    public java.lang.String getLogSvcStdDt() {
        return logSvcStdDt;
    }

    public void setLogSvcStdDt(java.lang.String logSvcStdDt) {
        this.logSvcStdDt = logSvcStdDt;
    }

    public Boolean getWmnYn() {
        return wmnYn;
    }

    public void setWmnYn(Boolean wmnYn) {
        this.wmnYn = wmnYn;
    }

    public Boolean getRetryClutYn() {
        return retryClutYn;
    }

    public void setRetryClutYn(Boolean retryClutYn) {
        this.retryClutYn = retryClutYn;
    }

    public Boolean getPayRcptYn() {
        return payRcptYn;
    }

    public void setPayRcptYn(Boolean payRcptYn) {
        this.payRcptYn = payRcptYn;
    }

    public Boolean getSpueYn() {
        return spueYn;
    }

    public void setSpueYn(Boolean spueYn) {
        this.spueYn = spueYn;
    }

    public Boolean getHlthInsrApptnYn() {
        return hlthInsrApptnYn;
    }

    public void setHlthInsrApptnYn(Boolean hlthInsrApptnYn) {
        this.hlthInsrApptnYn = hlthInsrApptnYn;
    }

    public Boolean getNatPennApptnYn() {
        return natPennApptnYn;
    }

    public void setNatPennApptnYn(Boolean natPennApptnYn) {
        this.natPennApptnYn = natPennApptnYn;
    }

    public Boolean getUmytInsrApptnYn() {
        return umytInsrApptnYn;
    }

    public void setUmytInsrApptnYn(Boolean umytInsrApptnYn) {
        this.umytInsrApptnYn = umytInsrApptnYn;
    }

    public Boolean getIdtlAccdtInsurApptnYn() {
        return idtlAccdtInsurApptnYn;
    }

    public void setIdtlAccdtInsurApptnYn(Boolean idtlAccdtInsurApptnYn) {
        this.idtlAccdtInsurApptnYn = idtlAccdtInsurApptnYn;
    }

    public Long getSuprtFamyNumTwenChDn() {
        return suprtFamyNumTwenChDn;
    }

    public void setSuprtFamyNumTwenChDn(Long suprtFamyNumTwenChDn) {
        this.suprtFamyNumTwenChDn = suprtFamyNumTwenChDn;
    }

    public Boolean getSuprtFamyNumTreOvrChdnYn() {
        return suprtFamyNumTreOvrChdnYn;
    }

    public void setSuprtFamyNumTreOvrChdnYn(Boolean suprtFamyNumTreOvrChdnYn) {
        this.suprtFamyNumTreOvrChdnYn = suprtFamyNumTreOvrChdnYn;
    }

    public Long getSuprtFamyNumEtc() {
        return suprtFamyNumEtc;
    }

    public void setSuprtFamyNumEtc(Long suprtFamyNumEtc) {
        this.suprtFamyNumEtc = suprtFamyNumEtc;
    }

    public Boolean getChdnSchlExpnAdmclYn() {
        return chdnSchlExpnAdmclYn;
    }

    public void setChdnSchlExpnAdmclYn(Boolean chdnSchlExpnAdmclYn) {
        this.chdnSchlExpnAdmclYn = chdnSchlExpnAdmclYn;
    }

    public Boolean getLogSvcExtpyApptnYn() {
        return logSvcExtpyApptnYn;
    }

    public void setLogSvcExtpyApptnYn(Boolean logSvcExtpyApptnYn) {
        this.logSvcExtpyApptnYn = logSvcExtpyApptnYn;
    }

    public java.lang.String getKybdr() {
        return kybdr;
    }

    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }

    public java.lang.String getInptDt() {
        return inptDt;
    }

    public void setInptDt(java.lang.String inptDt) {
        this.inptDt = inptDt;
    }

    public java.lang.String getInptAddr() {
        return inptAddr;
    }

    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }

    public java.lang.String getIsmt() {
        return ismt;
    }

    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }

    public java.lang.String getRevnDt() {
        return revnDt;
    }

    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }

    public java.lang.String getRevnAddr() {
        return revnAddr;
    }

    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }

    public Long getMnthPayDlywagSum() {
        return mnthPayDlywagSum;
    }

    public void setMnthPayDlywagSum(Long mnthPayDlywagSum) {
        this.mnthPayDlywagSum = mnthPayDlywagSum;
    }

    public Long getHlthInsrPayTotAmnt() {
        return hlthInsrPayTotAmnt;
    }

    public void setHlthInsrPayTotAmnt(Long hlthInsrPayTotAmnt) {
        this.hlthInsrPayTotAmnt = hlthInsrPayTotAmnt;
    }

    public Long getHlthInsrMnthRuntnAmnt() {
        return hlthInsrMnthRuntnAmnt;
    }

    public void setHlthInsrMnthRuntnAmnt(Long hlthInsrMnthRuntnAmnt) {
        this.hlthInsrMnthRuntnAmnt = hlthInsrMnthRuntnAmnt;
    }

    public Long getNatPennStdIncmMnthAmnt() {
        return natPennStdIncmMnthAmnt;
    }

    public void setNatPennStdIncmMnthAmnt(Long natPennStdIncmMnthAmnt) {
        this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
    }

    public Long getUmytInsrPayTotAmnt() {
        return umytInsrPayTotAmnt;
    }

    public void setUmytInsrPayTotAmnt(Long umytInsrPayTotAmnt) {
        this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
    }

    public Long getUmytInsrPayMnthAmnt() {
        return umytInsrPayMnthAmnt;
    }

    public void setUmytInsrPayMnthAmnt(Long umytInsrPayMnthAmnt) {
        this.umytInsrPayMnthAmnt = umytInsrPayMnthAmnt;
    }

    public java.lang.String getIdtlAccdtFlucDt() {
        return idtlAccdtFlucDt;
    }

    public void setIdtlAccdtFlucDt(java.lang.String idtlAccdtFlucDt) {
        this.idtlAccdtFlucDt = idtlAccdtFlucDt;
    }

    public Long getIdtlAccdtPayTotAmnt() {
        return idtlAccdtPayTotAmnt;
    }

    public void setIdtlAccdtPayTotAmnt(Long idtlAccdtPayTotAmnt) {
        this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
    }

    public Long getIdtlAccdtPayMnthAmnt() {
        return idtlAccdtPayMnthAmnt;
    }

    public void setIdtlAccdtPayMnthAmnt(Long idtlAccdtPayMnthAmnt) {
        this.idtlAccdtPayMnthAmnt = idtlAccdtPayMnthAmnt;
    }

    
    
}
