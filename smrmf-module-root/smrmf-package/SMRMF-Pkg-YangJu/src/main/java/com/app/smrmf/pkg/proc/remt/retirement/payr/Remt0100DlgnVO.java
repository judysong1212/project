package com.app.smrmf.pkg.proc.remt.retirement.payr;

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
public class Remt0100DlgnVO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    //PSNL0100
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

    /** set 담당업무구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 최초고용일자 : frstEmymtDt */
    private java.lang.String frstEmymtDt;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;


	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	private java.lang.String addIncmTxApptnRtoCd;
	
	/** set 추가소득세적용비율 : addIncmTxApptnRto */
	private java.math.BigDecimal addIncmTxApptnRto;
	
	/** set 추가소득세적용년월 : addIncmTxApptnYrMnth */
	private java.lang.String addIncmTxApptnYrMnth;
	
    /** set 추가소득세적용여부 : addIncmTxApptnYn */
    private java.lang.String addIncmTxApptnYn;


    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
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
    
    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String pernNoteCtnt;
    
    //PANL0127 
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
	 

    /** 건강보험적용여부 HLTH_INSR_APPTN_YN */
    private java.lang.String hlthInsrApptnYn;
    
    /** 국 민연금적용여부 NAT_PENN_APPTN_YN */
    private java.lang.String natPennApptnYn;
    
    /** 고용보험적용여부 UMYT_INSR_APPTN_YN */
    private java.lang.String umytInsrApptnYn;
    
    /** 산재보험적용여부 IDTL_ACCDT_INSUR_APPTN_YN */
    private java.lang.String idtlAccdtInsurApptnYn;
	//건강보험 
	private java.math.BigDecimal hlthInsrPayAmt;
	//요양 
	private java.math.BigDecimal hlthInsrRcptnPayAmt;
	 //국민연금  
	private java.math.BigDecimal natPennAmt;
	
	
        
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

	//PAYR0500
    /** 단위기관코드 PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
     
    /** 근속기준일자 LOG_SVC_STD_DT */
    private java.lang.String logSvcStdDt;
    
    /** 부녀자여부 WMN_YN */
    private java.lang.String wmnYn;
    
    /**  퇴직정산여부 RETRY_CLUT_YN */
    private java.lang.String retryClutYn;
    
    /** 급여대상자여부 PAY_RCPT_YN */
    private java.lang.String payRcptYn;
    
    /** 배우자유무 SPUE_YN */
    private java.lang.String spueYn;
    
    
    /** 부양가족수 20미만 자녀수 SUPRT_FAMY_NUM_TWEN_CH_DN */
    private BigDecimal suprtFamyNumTwenChDn;
    
    /** 부양가족수 3인이상자녀 SUPRT_FAMY_NUM_TRE_OVR_CHDN_YN */
    private java.lang.String  suprtFamyNumTreOvrChdnYn;
    
    //3인이상가족수당금액 
    private BigDecimal suprtFamy3ChdnExtpySum;
    
    /** 부양가족수 기타 SUPRT_FAMY_NUM_ETC */
    private BigDecimal suprtFamyNumEtc;
    
    /** 자녀학비보조여부 CHDN_SCHL_EXPN_ADMCL_YN */
    private java.lang.String chdnSchlExpnAdmclYn;
    
    /** 근속수당적용여부 LOG_SVC_EXTPY_APPTN_YN */
    private java.lang.String logSvcExtpyApptnYn;
    
    
    private java.lang.String dayWorkYn; //일용직구분 
      

    private java.lang.String payrIncmExceYn; //급여소득세제외여부 
    
    
    //PSNL123

	/** set 휴직일련번호 : levfAbncSeilNum */
	private java.math.BigDecimal levfAbncSeilNum;
	
	/** set 휴직구분코드 : levfAbncDivCd */
	private java.lang.String levfAbncDivCd;
	
	/** set 휴직시작일자 : levfAbncBgnnDt */
	private java.lang.String levfAbncBgnnDt;
	
	/** set 휴직종료일자 : levfAbncEndDt */
	private java.lang.String levfAbncEndDt;
	
	/** set 실제복직일자 : turtyRntmntDt */
	private java.lang.String turtyRntmntDt;
 
    
    //PSNL130

	/** set 급여구분코드 : payCd */
	private java.lang.String payCd;
	
	/** set 은행코드 : bnkCd */
	private java.lang.String bnkCd;
	
	/** set 은행계좌번호 : bnkAccuNum */
	private java.lang.String bnkAccuNum;
	
	/** set 예금주명 : acntHodrNm */
	private java.lang.String acntHodrNm;
	
	/** set 대표계좌여부 : rpsttvAccuYn */
	private java.lang.String rpsttvAccuYn;
	

    //DLGN0100
 
	/** set 근태년월 : dilnlazYrMnth */
	private java.lang.String dilnlazYrMnth; 

	/** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
	private java.lang.String dilnlazDutyBgnnDt;
	
	/** set 근태_근무종료일자 : dilnlazDutyEndDt */
	private java.lang.String dilnlazDutyEndDt;
	
	/** set 근태_근무일수 : dilnlazDutyNumDys */
	private java.lang.String dilnlazDutyNumDys;
	
	/** set 근태_연가일수 : dilnlazLvsgNumDys */
	private java.lang.String dilnlazLvsgNumDys;
	
	/** set 근태_결근일수 : dilnlazAbnceNumDys */
	private java.lang.String dilnlazAbnceNumDys;
	
	/** set 근태_병가일수 : dilnlazSckleaNumDys */
	private java.lang.String dilnlazSckleaNumDys;
	
	/** set 근태_공가일수 : dilnlazOffvaNumDys */
	private java.lang.String dilnlazOffvaNumDys;
	
	/** set 근태_경조사일수 : dilnlazFmlyEvntNumDys */
	private java.lang.String dilnlazFmlyEvntNumDys;
	
	/** set 근태_보건일수 : dilnlazHlthCreNumDys */
	private java.lang.String dilnlazHlthCreNumDys;
	
	/** set 근태_총근무일수 : dilnlazTotDutyNumDys */
	private java.lang.String dilnlazTotDutyNumDys;
	
	/** set 근태_주휴일수 : dilnlazWklyHldyNumDys */
	private java.lang.String dilnlazWklyHldyNumDys;
	
	/** set 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
	private java.lang.String dilnlazPaidPubcHodyNum;
	 
	/** set 근태_결근인정일수  : dilnlazAbnceDutyRcgtnDys */
    private java.lang.String dilnlazAbnceDutyRcgtnDys;
      
    /** set 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
    private java.lang.String dilnlazSpclHodyNumDys;
       
    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    private java.lang.String dilnlazDdlnePrcsYn;
  
    /** set 근태_총근무시간 : dilnlazTotDutyTm */
    private java.lang.String dilnlazTotDutyTm;

    /** set 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
    private java.lang.String dilnlazPaidHodyNumDys;

    /** set 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
    private java.lang.String dilnlazTfcAssCstNumDys;
    
   //DLGN0200
	private java.lang.String dilnlazDdlnePrcsYn01;   
  	private java.lang.String dilnlazExceDutyYrMnth; 
  	private java.lang.String dilnlazExceDutyBgnnDt; 
  	private java.lang.String dilnlazExceDutyEndDt; 
  	private java.lang.String dilnlazPubcHodyDutyNumDys; 
  	private java.lang.String dilnlazPubcHodyDutyTm; 
  	private java.lang.String dilnlazSatDutyNumDys; 
  	private java.lang.String dilnlazTotNtotNumDys; 
  	private java.lang.String dilnlazTotNtotTm; 
  	private java.lang.String dilnlazFndtnTmRstDutyTm; 
  	private java.lang.String dilnlazTmRstDutyTm; 
  	private java.lang.String dilnlazTotTmRstDutyTm; 
  	private java.lang.String dilnlazDdlnePrcsYn02; 
  	private java.lang.String dilnlazNoteCtnt; 
  	private java.lang.String dilnlazHodyTotNtotTm;  
  	
  	    
	/** 지급년월  */
	private java.lang.String pymtYrMnth;
	 
	  /** set 급여지급시작일자 : payPymtBgnnDt */
    private java.lang.String payPymtBgnnDt;

    /** set 급여지급종료일자 : payPymtEndDt */
    private java.lang.String payPymtEndDt;
     
    
	
    /**
	 * Comment : 
	 * @fn java.lang.String getDilnlazHodyTotNtotTm()
	 * @brief date:2017 2017. 6. 30. user:atres
	 * @return the dilnlazHodyTotNtotTm get
	 */
	public java.lang.String getDilnlazHodyTotNtotTm() {
		return dilnlazHodyTotNtotTm;
	}


	/**
	 * Comment : 
	 *@fn void setDilnlazHodyTotNtotTm(java.lang.String dilnlazHodyTotNtotTm)
	 *@brief date:2017 2017. 6. 30. user:atres
	 *@param dilnlazHodyTotNtotTm the dilnlazHodyTotNtotTm to set
	 */
	public void setDilnlazHodyTotNtotTm(java.lang.String dilnlazHodyTotNtotTm) {
		this.dilnlazHodyTotNtotTm = dilnlazHodyTotNtotTm;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getDilnlazPubcHodyDutyTm()
	 * @brief date:2016 2016. 5. 25. user:Administrator
	 * @return the dilnlazPubcHodyDutyTm get
	 */
	public java.lang.String getDilnlazPubcHodyDutyTm() {
		return dilnlazPubcHodyDutyTm;
	}


	/**
	 * Comment : 
	 *@fn void setDilnlazPubcHodyDutyTm(java.lang.String dilnlazPubcHodyDutyTm)
	 *@brief date:2016 2016. 5. 25. user:Administrator
	 *@param dilnlazPubcHodyDutyTm the dilnlazPubcHodyDutyTm to set
	 */
	public void setDilnlazPubcHodyDutyTm(java.lang.String dilnlazPubcHodyDutyTm) {
		this.dilnlazPubcHodyDutyTm = dilnlazPubcHodyDutyTm;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}


	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}


	public java.lang.String getPayPymtBgnnDt() {
		return payPymtBgnnDt;
	}


	public void setPayPymtBgnnDt(java.lang.String payPymtBgnnDt) {
		this.payPymtBgnnDt = payPymtBgnnDt;
	}


	public java.lang.String getPayPymtEndDt() {
		return payPymtEndDt;
	}


	public void setPayPymtEndDt(java.lang.String payPymtEndDt) {
		this.payPymtEndDt = payPymtEndDt;
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


	public java.math.BigDecimal getAddIncmTxApptnRto() {
		return addIncmTxApptnRto;
	}


	public void setAddIncmTxApptnRto(java.math.BigDecimal addIncmTxApptnRto) {
		this.addIncmTxApptnRto = addIncmTxApptnRto;
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

    public java.lang.String getDilnlazDdlnePrcsYn() {
        return dilnlazDdlnePrcsYn;
    }

    public void setDilnlazDdlnePrcsYn(java.lang.String dilnlazDdlnePrcsYn) {
        this.dilnlazDdlnePrcsYn = dilnlazDdlnePrcsYn;
    }

    public java.lang.String getDilnlazTotDutyTm() {
        return dilnlazTotDutyTm;
    }

    public void setDilnlazTotDutyTm(java.lang.String dilnlazTotDutyTm) {
        this.dilnlazTotDutyTm = dilnlazTotDutyTm;
    }

    public java.lang.String getDilnlazPaidHodyNumDys() {
        return dilnlazPaidHodyNumDys;
    }

    public void setDilnlazPaidHodyNumDys(java.lang.String dilnlazPaidHodyNumDys) {
        this.dilnlazPaidHodyNumDys = dilnlazPaidHodyNumDys;
    }

    public java.lang.String getDilnlazTfcAssCstNumDys() {
        return dilnlazTfcAssCstNumDys;
    }

    public void setDilnlazTfcAssCstNumDys(java.lang.String dilnlazTfcAssCstNumDys) {
        this.dilnlazTfcAssCstNumDys = dilnlazTfcAssCstNumDys;
    }

    public java.lang.String getDilnlazAbnceDutyRcgtnDys() {
        return dilnlazAbnceDutyRcgtnDys;
    }

    public void setDilnlazAbnceDutyRcgtnDys(java.lang.String dilnlazAbnceDutyRcgtnDys) {
        this.dilnlazAbnceDutyRcgtnDys = dilnlazAbnceDutyRcgtnDys;
    }

    public java.lang.String getDilnlazSpclHodyNumDys() {
        return dilnlazSpclHodyNumDys;
    }

    public void setDilnlazSpclHodyNumDys(java.lang.String dilnlazSpclHodyNumDys) {
        this.dilnlazSpclHodyNumDys = dilnlazSpclHodyNumDys;
    }

    public java.lang.String getDilnlazDdlnePrcsYn01() {
        return dilnlazDdlnePrcsYn01;
    }

    public void setDilnlazDdlnePrcsYn01(java.lang.String dilnlazDdlnePrcsYn01) {
        this.dilnlazDdlnePrcsYn01 = dilnlazDdlnePrcsYn01;
    }

    public java.lang.String getDilnlazExceDutyYrMnth() {
        return dilnlazExceDutyYrMnth;
    }

    public void setDilnlazExceDutyYrMnth(java.lang.String dilnlazExceDutyYrMnth) {
        this.dilnlazExceDutyYrMnth = dilnlazExceDutyYrMnth;
    }

    public java.lang.String getDilnlazExceDutyBgnnDt() {
        return dilnlazExceDutyBgnnDt;
    }

    public void setDilnlazExceDutyBgnnDt(java.lang.String dilnlazExceDutyBgnnDt) {
        this.dilnlazExceDutyBgnnDt = dilnlazExceDutyBgnnDt;
    }

    public java.lang.String getDilnlazExceDutyEndDt() {
        return dilnlazExceDutyEndDt;
    }

    public void setDilnlazExceDutyEndDt(java.lang.String dilnlazExceDutyEndDt) {
        this.dilnlazExceDutyEndDt = dilnlazExceDutyEndDt;
    }

    public java.lang.String getDilnlazPubcHodyDutyNumDys() {
        return dilnlazPubcHodyDutyNumDys;
    }

    public void setDilnlazPubcHodyDutyNumDys(java.lang.String dilnlazPubcHodyDutyNumDys) {
        this.dilnlazPubcHodyDutyNumDys = dilnlazPubcHodyDutyNumDys;
    }

    public java.lang.String getDilnlazSatDutyNumDys() {
        return dilnlazSatDutyNumDys;
    }

    public void setDilnlazSatDutyNumDys(java.lang.String dilnlazSatDutyNumDys) {
        this.dilnlazSatDutyNumDys = dilnlazSatDutyNumDys;
    }

    public java.lang.String getDilnlazTotNtotNumDys() {
        return dilnlazTotNtotNumDys;
    }

    public void setDilnlazTotNtotNumDys(java.lang.String dilnlazTotNtotNumDys) {
        this.dilnlazTotNtotNumDys = dilnlazTotNtotNumDys;
    }

    public java.lang.String getDilnlazTotNtotTm() {
        return dilnlazTotNtotTm;
    }

    public void setDilnlazTotNtotTm(java.lang.String dilnlazTotNtotTm) {
        this.dilnlazTotNtotTm = dilnlazTotNtotTm;
    }

    public java.lang.String getDilnlazFndtnTmRstDutyTm() {
        return dilnlazFndtnTmRstDutyTm;
    }

    public void setDilnlazFndtnTmRstDutyTm(java.lang.String dilnlazFndtnTmRstDutyTm) {
        this.dilnlazFndtnTmRstDutyTm = dilnlazFndtnTmRstDutyTm;
    }

    public java.lang.String getDilnlazTmRstDutyTm() {
        return dilnlazTmRstDutyTm;
    }

    public void setDilnlazTmRstDutyTm(java.lang.String dilnlazTmRstDutyTm) {
        this.dilnlazTmRstDutyTm = dilnlazTmRstDutyTm;
    }

    public java.lang.String getDilnlazTotTmRstDutyTm() {
        return dilnlazTotTmRstDutyTm;
    }

    public void setDilnlazTotTmRstDutyTm(java.lang.String dilnlazTotTmRstDutyTm) {
        this.dilnlazTotTmRstDutyTm = dilnlazTotTmRstDutyTm;
    }

    public java.lang.String getDilnlazDdlnePrcsYn02() {
        return dilnlazDdlnePrcsYn02;
    }

    public void setDilnlazDdlnePrcsYn02(java.lang.String dilnlazDdlnePrcsYn02) {
        this.dilnlazDdlnePrcsYn02 = dilnlazDdlnePrcsYn02;
    }

    public java.lang.String getDilnlazNoteCtnt() {
        return dilnlazNoteCtnt;
    }

    public void setDilnlazNoteCtnt(java.lang.String dilnlazNoteCtnt) {
        this.dilnlazNoteCtnt = dilnlazNoteCtnt;
    }

    public java.lang.String getPernNoteCtnt() {
        return pernNoteCtnt;
    }

    public void setPernNoteCtnt(java.lang.String pernNoteCtnt) {
        this.pernNoteCtnt = pernNoteCtnt;
    }

    public java.math.BigDecimal getHlthInsrPayAmt() {
		return hlthInsrPayAmt;
	}

	public void setHlthInsrPayAmt(java.math.BigDecimal hlthInsrPayAmt) {
		this.hlthInsrPayAmt = hlthInsrPayAmt;
	}

	public java.math.BigDecimal getHlthInsrRcptnPayAmt() {
		return hlthInsrRcptnPayAmt;
	}

	public void setHlthInsrRcptnPayAmt(java.math.BigDecimal hlthInsrRcptnPayAmt) {
		this.hlthInsrRcptnPayAmt = hlthInsrRcptnPayAmt;
	}

	public java.math.BigDecimal getNatPennAmt() {
		return natPennAmt;
	}

	public void setNatPennAmt(java.math.BigDecimal natPennAmt) {
		this.natPennAmt = natPennAmt;
	}
 
	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
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

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getEngNm() {
		return engNm;
	}

	public void setEngNm(java.lang.String engNm) {
		this.engNm = engNm;
	}

	public java.lang.String getChinCharNm() {
		return chinCharNm;
	}

	public void setChinCharNm(java.lang.String chinCharNm) {
		this.chinCharNm = chinCharNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getSxDivCd() {
		return sxDivCd;
	}

	public void setSxDivCd(java.lang.String sxDivCd) {
		this.sxDivCd = sxDivCd;
	}

	public java.lang.String getYoobhMnthDay() {
		return yoobhMnthDay;
	}

	public void setYoobhMnthDay(java.lang.String yoobhMnthDay) {
		this.yoobhMnthDay = yoobhMnthDay;
	}

	public java.lang.String getSclcDivCd() {
		return sclcDivCd;
	}

	public void setSclcDivCd(java.lang.String sclcDivCd) {
		this.sclcDivCd = sclcDivCd;
	}

	public java.lang.String getNatnCd() {
		return natnCd;
	}

	public void setNatnCd(java.lang.String natnCd) {
		this.natnCd = natnCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}

	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getEmymtBgnnDt() {
		return emymtBgnnDt;
	}

	public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
		this.emymtBgnnDt = emymtBgnnDt;
	}

	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}

	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	public java.lang.String getRetryReasCtnt() {
		return retryReasCtnt;
	}

	public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
		this.retryReasCtnt = retryReasCtnt;
	}

	public java.lang.String getFrgnrDivCd() {
		return frgnrDivCd;
	}

	public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
		this.frgnrDivCd = frgnrDivCd;
	}

	public java.lang.String getPsptNum() {
		return psptNum;
	}

	public void setPsptNum(java.lang.String psptNum) {
		this.psptNum = psptNum;
	}

	public java.lang.String getStyBgnnDt() {
		return styBgnnDt;
	}

	public void setStyBgnnDt(java.lang.String styBgnnDt) {
		this.styBgnnDt = styBgnnDt;
	}

	public java.lang.String getStyEndDt() {
		return styEndDt;
	}

	public void setStyEndDt(java.lang.String styEndDt) {
		this.styEndDt = styEndDt;
	}

	public java.lang.String getEndSchl() {
		return endSchl;
	}

	public void setEndSchl(java.lang.String endSchl) {
		this.endSchl = endSchl;
	}

	public java.lang.String getEndDegrDivCd() {
		return endDegrDivCd;
	}

	public void setEndDegrDivCd(java.lang.String endDegrDivCd) {
		this.endDegrDivCd = endDegrDivCd;
	}

	public java.lang.String getPmtnScduDt() {
		return pmtnScduDt;
	}

	public void setPmtnScduDt(java.lang.String pmtnScduDt) {
		this.pmtnScduDt = pmtnScduDt;
	}

	public java.lang.String getPyspPrmtnScduDt() {
		return pyspPrmtnScduDt;
	}

	public void setPyspPrmtnScduDt(java.lang.String pyspPrmtnScduDt) {
		this.pyspPrmtnScduDt = pyspPrmtnScduDt;
	}

	public java.lang.String getReymnScduDt() {
		return reymnScduDt;
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
		return currPyspAppmtDt;
	}

	public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
		this.currPyspAppmtDt = currPyspAppmtDt;
	}

	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}

	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
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

	public void setNatPennStdIncmMnthAmnt(
			java.math.BigDecimal natPennStdIncmMnthAmnt) {
		this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
	}

	public java.lang.String getNatPennGrde() {
		return natPennGrde;
	}

	public void setNatPennGrde(java.lang.String natPennGrde) {
		this.natPennGrde = natPennGrde;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getLogSvcStdDt() {
		return logSvcStdDt;
	}

	public void setLogSvcStdDt(java.lang.String logSvcStdDt) {
		this.logSvcStdDt = logSvcStdDt;
	}

	public java.lang.String getWmnYn() {
		return wmnYn;
	}

	public void setWmnYn(java.lang.String wmnYn) {
		this.wmnYn = wmnYn;
	}

	public java.lang.String getRetryClutYn() {
		return retryClutYn;
	}

	public void setRetryClutYn(java.lang.String retryClutYn) {
		this.retryClutYn = retryClutYn;
	}

	public java.lang.String getPayRcptYn() {
		return payRcptYn;
	}

	public void setPayRcptYn(java.lang.String payRcptYn) {
		this.payRcptYn = payRcptYn;
	}

	public java.lang.String getSpueYn() {
		return spueYn;
	}

	public void setSpueYn(java.lang.String spueYn) {
		this.spueYn = spueYn;
	}

	public java.lang.String getHlthInsrApptnYn() {
		return hlthInsrApptnYn;
	}

	public void setHlthInsrApptnYn(java.lang.String hlthInsrApptnYn) {
		this.hlthInsrApptnYn = hlthInsrApptnYn;
	}

	public java.lang.String getNatPennApptnYn() {
		return natPennApptnYn;
	}

	public void setNatPennApptnYn(java.lang.String natPennApptnYn) {
		this.natPennApptnYn = natPennApptnYn;
	}

	public java.lang.String getUmytInsrApptnYn() {
		return umytInsrApptnYn;
	}

	public void setUmytInsrApptnYn(java.lang.String umytInsrApptnYn) {
		this.umytInsrApptnYn = umytInsrApptnYn;
	}

	public java.lang.String getIdtlAccdtInsurApptnYn() {
		return idtlAccdtInsurApptnYn;
	}

	public void setIdtlAccdtInsurApptnYn(java.lang.String idtlAccdtInsurApptnYn) {
		this.idtlAccdtInsurApptnYn = idtlAccdtInsurApptnYn;
	}

	public BigDecimal getSuprtFamyNumTwenChDn() {
		return suprtFamyNumTwenChDn;
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

    public BigDecimal getSuprtFamy3ChdnExtpySum() {
		return suprtFamy3ChdnExtpySum;
	}

	public void setSuprtFamy3ChdnExtpySum(BigDecimal suprtFamy3ChdnExtpySum) {
		this.suprtFamy3ChdnExtpySum = suprtFamy3ChdnExtpySum;
	}

	public BigDecimal getSuprtFamyNumEtc() {
		return suprtFamyNumEtc;
	}

	public void setSuprtFamyNumEtc(BigDecimal suprtFamyNumEtc) {
		this.suprtFamyNumEtc = suprtFamyNumEtc;
	}

	public java.lang.String getChdnSchlExpnAdmclYn() {
		return chdnSchlExpnAdmclYn;
	}

	public void setChdnSchlExpnAdmclYn(java.lang.String chdnSchlExpnAdmclYn) {
		this.chdnSchlExpnAdmclYn = chdnSchlExpnAdmclYn;
	}

	public java.lang.String getLogSvcExtpyApptnYn() {
		return logSvcExtpyApptnYn;
	}

	public void setLogSvcExtpyApptnYn(java.lang.String logSvcExtpyApptnYn) {
		this.logSvcExtpyApptnYn = logSvcExtpyApptnYn;
	}

	public java.math.BigDecimal getLevfAbncSeilNum() {
		return levfAbncSeilNum;
	}

	public void setLevfAbncSeilNum(java.math.BigDecimal levfAbncSeilNum) {
		this.levfAbncSeilNum = levfAbncSeilNum;
	}

	public java.lang.String getLevfAbncDivCd() {
		return levfAbncDivCd;
	}

	public void setLevfAbncDivCd(java.lang.String levfAbncDivCd) {
		this.levfAbncDivCd = levfAbncDivCd;
	}

	public java.lang.String getLevfAbncBgnnDt() {
		return levfAbncBgnnDt;
	}

	public void setLevfAbncBgnnDt(java.lang.String levfAbncBgnnDt) {
		this.levfAbncBgnnDt = levfAbncBgnnDt;
	}

	public java.lang.String getLevfAbncEndDt() {
		return levfAbncEndDt;
	}

	public void setLevfAbncEndDt(java.lang.String levfAbncEndDt) {
		this.levfAbncEndDt = levfAbncEndDt;
	}

	public java.lang.String getTurtyRntmntDt() {
		return turtyRntmntDt;
	}

	public void setTurtyRntmntDt(java.lang.String turtyRntmntDt) {
		this.turtyRntmntDt = turtyRntmntDt;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getBnkCd() {
		return bnkCd;
	}

	public void setBnkCd(java.lang.String bnkCd) {
		this.bnkCd = bnkCd;
	}

	public java.lang.String getBnkAccuNum() {
		return bnkAccuNum;
	}

	public void setBnkAccuNum(java.lang.String bnkAccuNum) {
		this.bnkAccuNum = bnkAccuNum;
	}

	public java.lang.String getAcntHodrNm() {
		return acntHodrNm;
	}

	public void setAcntHodrNm(java.lang.String acntHodrNm) {
		this.acntHodrNm = acntHodrNm;
	}

	public java.lang.String getRpsttvAccuYn() {
		return rpsttvAccuYn;
	}

	public void setRpsttvAccuYn(java.lang.String rpsttvAccuYn) {
		this.rpsttvAccuYn = rpsttvAccuYn;
	}

	public java.lang.String getDilnlazYrMnth() {
		return dilnlazYrMnth;
	}

	public void setDilnlazYrMnth(java.lang.String dilnlazYrMnth) {
		this.dilnlazYrMnth = dilnlazYrMnth;
	}

	public java.lang.String getDilnlazDutyBgnnDt() {
		return dilnlazDutyBgnnDt;
	}

	public void setDilnlazDutyBgnnDt(java.lang.String dilnlazDutyBgnnDt) {
		this.dilnlazDutyBgnnDt = dilnlazDutyBgnnDt;
	}

	public java.lang.String getDilnlazDutyEndDt() {
		return dilnlazDutyEndDt;
	}

	public void setDilnlazDutyEndDt(java.lang.String dilnlazDutyEndDt) {
		this.dilnlazDutyEndDt = dilnlazDutyEndDt;
	}

	public java.lang.String getDilnlazDutyNumDys() {
		return dilnlazDutyNumDys;
	}

	public void setDilnlazDutyNumDys(java.lang.String dilnlazDutyNumDys) {
		this.dilnlazDutyNumDys = dilnlazDutyNumDys;
	}

	public java.lang.String getDilnlazLvsgNumDys() {
		return dilnlazLvsgNumDys;
	}

	public void setDilnlazLvsgNumDys(java.lang.String dilnlazLvsgNumDys) {
		this.dilnlazLvsgNumDys = dilnlazLvsgNumDys;
	}

	public java.lang.String getDilnlazAbnceNumDys() {
		return dilnlazAbnceNumDys;
	}

	public void setDilnlazAbnceNumDys(java.lang.String dilnlazAbnceNumDys) {
		this.dilnlazAbnceNumDys = dilnlazAbnceNumDys;
	}

	public java.lang.String getDilnlazSckleaNumDys() {
		return dilnlazSckleaNumDys;
	}

	public void setDilnlazSckleaNumDys(java.lang.String dilnlazSckleaNumDys) {
		this.dilnlazSckleaNumDys = dilnlazSckleaNumDys;
	}

	public java.lang.String getDilnlazOffvaNumDys() {
		return dilnlazOffvaNumDys;
	}

	public void setDilnlazOffvaNumDys(java.lang.String dilnlazOffvaNumDys) {
		this.dilnlazOffvaNumDys = dilnlazOffvaNumDys;
	}

	public java.lang.String getDilnlazFmlyEvntNumDys() {
		return dilnlazFmlyEvntNumDys;
	}

	public void setDilnlazFmlyEvntNumDys(java.lang.String dilnlazFmlyEvntNumDys) {
		this.dilnlazFmlyEvntNumDys = dilnlazFmlyEvntNumDys;
	}

	public java.lang.String getDilnlazHlthCreNumDys() {
		return dilnlazHlthCreNumDys;
	}

	public void setDilnlazHlthCreNumDys(java.lang.String dilnlazHlthCreNumDys) {
		this.dilnlazHlthCreNumDys = dilnlazHlthCreNumDys;
	}

	public java.lang.String getDilnlazTotDutyNumDys() {
		return dilnlazTotDutyNumDys;
	}

	public void setDilnlazTotDutyNumDys(java.lang.String dilnlazTotDutyNumDys) {
		this.dilnlazTotDutyNumDys = dilnlazTotDutyNumDys;
	}

	public java.lang.String getDilnlazWklyHldyNumDys() {
		return dilnlazWklyHldyNumDys;
	}

	public void setDilnlazWklyHldyNumDys(java.lang.String dilnlazWklyHldyNumDys) {
		this.dilnlazWklyHldyNumDys = dilnlazWklyHldyNumDys;
	}

	public java.lang.String getDilnlazPaidPubcHodyNum() {
		return dilnlazPaidPubcHodyNum;
	}

	public void setDilnlazPaidPubcHodyNum(java.lang.String dilnlazPaidPubcHodyNum) {
		this.dilnlazPaidPubcHodyNum = dilnlazPaidPubcHodyNum;
	}


	/**
	 * Comment : 
	 * @fn java.lang.String getPayrIncmExceYn()
	 * @brief date:2016 2016. 6. 30. user:Administrator
	 * @return the payrIncmExceYn get
	 */
	public java.lang.String getPayrIncmExceYn() {
		return payrIncmExceYn;
	}


	/**
	 * Comment : 
	 *@fn void setPayrIncmExceYn(java.lang.String payrIncmExceYn)
	 *@brief date:2016 2016. 6. 30. user:Administrator
	 *@param payrIncmExceYn the payrIncmExceYn to set
	 */
	public void setPayrIncmExceYn(java.lang.String payrIncmExceYn) {
		this.payrIncmExceYn = payrIncmExceYn;
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
	 
	 
	 
    
}
