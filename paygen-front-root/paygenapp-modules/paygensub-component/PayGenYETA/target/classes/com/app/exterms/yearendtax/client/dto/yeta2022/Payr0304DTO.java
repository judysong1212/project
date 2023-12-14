package com.app.exterms.yearendtax.client.dto.yeta2022;

import java.io.Serializable; 

/**
 * @Class Name : Payr0304VO.java
 * @Description : Payr0304 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0304DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여일련번호 : payrSeilNum */
    private Long payrSeilNum;


    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;


    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;

    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** set 재직구분코드 : hdofcDivCd */
    private java.lang.String hdofcDivCd;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 근속기준일자 : logSvcStdDt */
    private java.lang.String logSvcStdDt;

    /** set 배우자유무 : spueYn */
    private java.lang.String spueYn;

    /** set 부양가족수20_자녀 : suprtFamyNumTwenChDn */
    private Long suprtFamyNumTwenChDn;

    /** set 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
    private Long suprtFamyNumTreOvrChdn;

    /** set 부양가족수_기타 : suprtFamyNumEtc */
    private Long suprtFamyNumEtc;

    /** set 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
    private Long suprtFamy3ChdnExtpySum;

    /** set 자녀학비보조여부 : chdnSchlExpnAdmclYn */
    private java.lang.String chdnSchlExpnAdmclYn;

    /** set 건강보험등급 : hlthInsrGrde */
    private java.lang.String hlthInsrGrde;

    /** set 국민연금등급 : natPennGrde */
    private java.lang.String natPennGrde;

    /** set 월급여일당금액 : mnthPayDlywagSum */
    private Long mnthPayDlywagSum;

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
  
	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	private java.lang.String addIncmTxApptnRtoCd;
	
	/** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
	private java.lang.String addIncmTxApptnYrMnth;
	
	private java.lang.String repbtyBusinDivCd;
	private java.lang.String mangeDeptCd;
	private java.lang.String dtilOccuInttnCd;
	private java.lang.String pymtDducDivCd;
	private java.lang.String payItemCd;
	private java.lang.String deptGpCd;
	
	
	
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

	public java.lang.String getPayCd() {
        return payCd;
    }

    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }

    public Long getPayrSeilNum() {
        return payrSeilNum;
    }

    public void setPayrSeilNum(Long payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

  
    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
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
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
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
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getOdtyCd() {
        return this.odtyCd;
    }
    
    public void setOdtyCd(java.lang.String odtyCd) {
        this.odtyCd = odtyCd;
    }
    
    public java.lang.String getPyspCd() {
        return this.pyspCd;
    }
    
    public void setPyspCd(java.lang.String pyspCd) {
        this.pyspCd = pyspCd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getLogSvcYrNumCd() {
        return this.logSvcYrNumCd;
    }
    
    public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
        this.logSvcYrNumCd = logSvcYrNumCd;
    }
    
    public java.lang.String getLogSvcMnthIcmCd() {
        return this.logSvcMnthIcmCd;
    }
    
    public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
        this.logSvcMnthIcmCd = logSvcMnthIcmCd;
    }
    
    public java.lang.String getFrstEmymtDt() {
        return this.frstEmymtDt;
    }
    
    public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
        this.frstEmymtDt = frstEmymtDt;
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
    
    public java.lang.String getHdofcDivCd() {
        return this.hdofcDivCd;
    }
    
    public void setHdofcDivCd(java.lang.String hdofcDivCd) {
        this.hdofcDivCd = hdofcDivCd;
    }
    
    public java.lang.String getRetryDt() {
        return this.retryDt;
    }
    
    public void setRetryDt(java.lang.String retryDt) {
        this.retryDt = retryDt;
    }
    
    public java.lang.String getLogSvcStdDt() {
        return this.logSvcStdDt;
    }
    
    public void setLogSvcStdDt(java.lang.String logSvcStdDt) {
        this.logSvcStdDt = logSvcStdDt;
    }
    
    public java.lang.String getSpueYn() {
        return this.spueYn;
    }
    
    public void setSpueYn(java.lang.String spueYn) {
        this.spueYn = spueYn;
    }
    
   
    public java.lang.String getChdnSchlExpnAdmclYn() {
        return this.chdnSchlExpnAdmclYn;
    }
    
    public void setChdnSchlExpnAdmclYn(java.lang.String chdnSchlExpnAdmclYn) {
        this.chdnSchlExpnAdmclYn = chdnSchlExpnAdmclYn;
    }
    
    public java.lang.String getHlthInsrGrde() {
        return this.hlthInsrGrde;
    }
    
    public void setHlthInsrGrde(java.lang.String hlthInsrGrde) {
        this.hlthInsrGrde = hlthInsrGrde;
    }
    
    public java.lang.String getNatPennGrde() {
        return this.natPennGrde;
    }
    
    public void setNatPennGrde(java.lang.String natPennGrde) {
        this.natPennGrde = natPennGrde;
    }
    
  
    
    public Long getSuprtFamyNumTwenChDn() {
		return suprtFamyNumTwenChDn;
	}

	public void setSuprtFamyNumTwenChDn(Long suprtFamyNumTwenChDn) {
		this.suprtFamyNumTwenChDn = suprtFamyNumTwenChDn;
	}

	public Long getSuprtFamyNumTreOvrChdn() {
		return suprtFamyNumTreOvrChdn;
	}

	public void setSuprtFamyNumTreOvrChdn(Long suprtFamyNumTreOvrChdn) {
		this.suprtFamyNumTreOvrChdn = suprtFamyNumTreOvrChdn;
	}

	public Long getSuprtFamyNumEtc() {
		return suprtFamyNumEtc;
	}

	public void setSuprtFamyNumEtc(Long suprtFamyNumEtc) {
		this.suprtFamyNumEtc = suprtFamyNumEtc;
	}

	public Long getSuprtFamy3ChdnExtpySum() {
		return suprtFamy3ChdnExtpySum;
	}

	public void setSuprtFamy3ChdnExtpySum(Long suprtFamy3ChdnExtpySum) {
		this.suprtFamy3ChdnExtpySum = suprtFamy3ChdnExtpySum;
	}

	public Long getMnthPayDlywagSum() {
		return mnthPayDlywagSum;
	}

	public void setMnthPayDlywagSum(Long mnthPayDlywagSum) {
		this.mnthPayDlywagSum = mnthPayDlywagSum;
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
	 * @brief date:2016 2016. 6. 26. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 원본 주민등록번호 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 26. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public java.lang.String getDeptGpCd() {
		return deptGpCd;
	}

	public void setDeptGpCd(java.lang.String deptGpCd) {
		this.deptGpCd = deptGpCd;
	}
    
}
