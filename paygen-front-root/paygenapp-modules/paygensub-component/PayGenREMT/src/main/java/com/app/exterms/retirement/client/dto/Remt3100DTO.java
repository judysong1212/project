package com.app.exterms.retirement.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Remt3100VO.java
 * @Description : Remt3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3100DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;


    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;
    
    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
    private java.lang.String calcSevePsnBlggYrMnth;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 소득자임원여부 : aimenrEcteYn */
    private Boolean aimenrEcteYn;
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;


/** set 확정급여형가입일자 : fixPayJnDt */
private java.lang.String fixPayJnDt;

/** set 퇴직금_20111231금액 : sevePay20111231Sum */
private  Long sevePay20111231Sum;


    /** set 외국인구분코드 : frgnrDivCd */
    private java.lang.String frgnrDivCd;

    /** set 거주구분여부 : ridnSeptYn */
    private Boolean ridnSeptYn;

    /** set 거주지국코드 : ridnCd */
    private java.lang.String ridnCd;

    /** set 거주지국명 : ridnNm */
    private java.lang.String ridnNm;

    /** set 귀속년도시작일자 : blggYrBgnnDt */
    private java.lang.String blggYrBgnnDt;

    /** set 귀속년도종료일자 : blggYrEndDt */
    private java.lang.String blggYrEndDt;

    /** set 퇴직사유코드 : retryReasCd */
    private java.lang.String retryReasCd;

    /** set 중_사업자등록번호 : ctrBusoprRgstnNum */
    private java.lang.String ctrBusoprRgstnNum;

    /** set 중_근무처명 : ctrPaeWorkNm */
    private java.lang.String ctrPaeWorkNm;

    /** set 중_퇴직급여액 : ctrRetryPayQnty */
    private Long ctrRetryPayQnty;

    /** set 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
    private Long ctrFreeDtyRetryPayQnty;

    /** set 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
    private Long ctrTxtnTgtRetryPayQnty;

    /** set 종_사업자등록번호 : endBusoprRgstnNum */
    private java.lang.String endBusoprRgstnNum;

    /** set 종_근무처명 : endPaeWorkNm */
    private java.lang.String endPaeWorkNm;

    /** set 종_퇴직급여액 : endRetryPayQnty */
    private Long endRetryPayQnty;

    /** set 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
    private Long endFreeDtyRetryPayQnty;

    /** set 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
    private Long endTxtnTgtRetryPayQnty;

    /** set 정산_퇴직급여액 : clutRetryPayQnty */
    private Long clutRetryPayQnty;

    /** set 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
    private Long clutFreeDtyRetryPayQnty;

    /** set 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
    private Long clutTxtnTgtRetryPayQnty;

    /** set 중_입사일자 : ctrIcncDt */
    private java.lang.String ctrIcncDt;

    /** set 중_기산일자 : ctrRkfcdDt */
    private java.lang.String ctrRkfcdDt;

    /** set 중_퇴사일자 : ctrRsgtnDt */
    private java.lang.String ctrRsgtnDt;

    /** set 중_지급일자 : ctrPymtDt */
    private java.lang.String ctrPymtDt;

    /** set 중_근속월수 : ctrLogSvcMnthIcm */
    private Long ctrLogSvcMnthIcm;

    /** set 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
    private Long ctrEepnMnth12Bfr;

    /** set 중_제외월수_2013이후 : ctrEepnMnth13Aft */
    private Long ctrEepnMnth13Aft;

    /** set 중_가산월수_2012이전 : ctrAddMnth12Bfr */
    private Long ctrAddMnth12Bfr;

    /** set 중_가산월수_2013이후 : ctrAddMnth13Aft */
    private Long ctrAddMnth13Aft;

    /** set 중_제외월수 : ctrEepnMnthIcm */
    private Long ctrEepnMnthIcm;

    /** set 중_가산월수 : ctrAddMnthIcm */
    private Long ctrAddMnthIcm;

    /** set 중_중복월수 : ctrDupMnthIcm */
    private Long ctrDupMnthIcm;

    /** set 중_근속연수 : ctrLogSvc */
    private Long ctrLogSvc;

    /** set 종_입사일자 : endIcncDt */
    private java.lang.String endIcncDt;

    /** set 종_기산일자 : endRkfcdDt */
    private java.lang.String endRkfcdDt;

    /** set 종_퇴사일자 : endRsgtnDt */
    private java.lang.String endRsgtnDt;

    /** set 종_지급일자 : endPymtDt */
    private java.lang.String endPymtDt;

    /** set 종_근속월수 : endLogSvcMnthIcm */
    private Long endLogSvcMnthIcm;

    /** set 종_제외월수_2012이전 : endEepnMnth12Bfr */
    private Long endEepnMnth12Bfr;

    /** set 종_제외월수_2013이후 : endEepnMnth13Aft */
    private Long endEepnMnth13Aft;

    /** set 종_가산월수_2012이전 : endAddMnth12Bfr */
    private Long endAddMnth12Bfr;

    /** set 종_가산월수_2013이후 : endAddMnth13Aft */
    private Long endAddMnth13Aft;

    /** set 종_제외월수 : endEepnMnthIcm */
    private Long endEepnMnthIcm;

    /** set 종_가산월수 : endAddMnthIcm */
    private Long endAddMnthIcm;

    /** set 종_중복월수 : endDupMnthIcm */
    private Long endDupMnthIcm;

    /** set 종_근속연수 : endLogSvcYrNum */
    private Long endLogSvcYrNum;

    /** set 정산_입사일자 : clutIcncDt */
    private java.lang.String clutIcncDt;

    /** set 정산-기산일자 : clutRkfcdDt */
    private java.lang.String clutRkfcdDt;

    /** set 정산_퇴사일자 : clutRsgtnDt */
    private java.lang.String clutRsgtnDt;

    /** set 정산_지급일자 : clutPymtDt */
    private java.lang.String clutPymtDt;

    /** set 정산_근속월수 : clutLogSvcMnthIcm */
    private Long clutLogSvcMnthIcm;

    /** set 정산_제외월수 : clutEepnMnthIcm */
    private Long clutEepnMnthIcm;

    /** set 정산_가산월수 : clutAddMnthIcm */
    private Long clutAddMnthIcm;

    /** set 정산_중복월수 : clutDupMnthIcm */
    private Long clutDupMnthIcm;

    /** set 정산_근속연수 : clutLogSvcYrNum */
    private Long clutLogSvcYrNum;

    /** set 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
    private java.lang.String logPpnl12befIcncDt;

    /** set 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
    private java.lang.String logPpnl12befRkfcdDt;

    /** set 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
    private java.lang.String logPpnl12befRsgtnDt;

    /** set 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
    private java.lang.String logPpnl12befPymtDt;

    /** set 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
    private Long logPpnl12befLogMnthIcm;

    /** set 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
    private Long logPpnl12befEepnMnthIcm;

    /** set 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
    private Long logPpnl12befAddMnthIcm;

    /** set 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
    private Long logPpnl12befDupMnthIcm;

    /** set 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    private Long logPpnl12befLogYrNum;

    /** set 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
    private java.lang.String logPpnl13afrIcncDt;

    /** set 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
    private java.lang.String logPpnl13afrRkfcdDt;

    /** set 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
    private java.lang.String logPpnl13afrRsgtnDt;

    /** set 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
    private java.lang.String logPpnl13afrPymtDt;

    /** set 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
    private Long logPpnl13afrLogMnthIcm;

    /** set 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
    private Long logPpnl13afrEepnMnthIcm;

    /** set 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
    private Long logPpnl13afrAddMnthIcm;

    /** set 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
    private Long logPpnl13afrDupMnthIcm;

    /** set 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    private Long logPpnl13afrLogSvc;

    /** set 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
    private Long retryIncmCtrPymtSum;

    /** set 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
    private Long retryIncmEndPymtSum;

    /** set 퇴직소득_정산금액 : retryIncmClutSum */
    private Long retryIncmClutSum;

    /** set 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
    private Long retryFxrtDducClutSum;

    /** set 근속년수공제_정산금액 : logYrDducSum */
    private Long logYrDducSum;

    /** set 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    private Long retryTxtnStdClutSum;

    /** set 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    private Long tat12befTxtnStdPpnlSum;

    /** set 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    private Long tat12befYravgTxstdSum;

    /** set 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    private Long tat12befCvsnTxtnStdSum;

    /** set 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    private Long tat12befCvsnCalcAmnt;

    /** set 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    private Long tat12befYrAvgCalcAmnt;

    /** set 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    private Long tat12befCalcTxAmnt;

    /** set 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    private Long tat12befAlpayTxAmnt;

    /** set 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    private Long tat12befRegTgtTxAmnt;

    /** set 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    private Long tat13afrTxstdPpnlSum;

    /** set 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    private Long tat13afrYrAvgStdSum;

    /** set 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    private Long tat13afrCvsnTxtnStdSum;

    /** set 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    private Long tat13afrCvsnCalcTxAmnt;

    /** set 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    private Long tat13afrYrAvgCalcAmnt;

    /** set 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
    private Long tat13afrCalcTxAmnt;

    /** set 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    private Long tat13afrAlpayTxAmnt;

    /** set 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    private Long tat13afrRegrstTgtSum;

    /** set 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    private Long tatAggrTxtnStdPpnlSum;

    /** set 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    private Long tatAggrYrAvgTxtnStdSum;

    /** set 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    private Long tatAggrCvsnTxtnStdSum;

    /** set 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    private Long tatAggrCvsnCalcTxAmnt;

    /** set 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    private Long tatAggrYrAvgCalcTxAmnt;

    /** set 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    private Long tatAggrCalcTxAmnt;

    /** set 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    private Long tatAggrAlpayTxAmnt;

    /** set 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    private Long tatAggrRegrstTgtTxAmnt;

    /** set 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
    private Long talRegrstTgtTxAmnt;

    /** set 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
    private Long talAccuDepitAggrSum;

    /** set 이연세액_퇴직급여액 : talRetryPayQnty */
    private Long talRetryPayQnty;

    /** set 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
    private Long talRetryIncmTxAmnt;

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    private Long pymtRegTgtIncmTxQnty;

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    private Long pymtRegTgtRgonIncmQnty;

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    private Long pymtRegTgtFarvilSpclQnty;

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    private Long pymtRegrstTgtAggrSum;

    /** set 납부이연_소득세액 : pymtTalcIncmTxQnty */
    private Long pymtTalcIncmTxQnty;

    /** set 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
    private Long pymtTalcRgonIncmTxQnty;

    /** set 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
    private Long pymtTalcFarvilSpclQnty;

    /** set 납부이연_합계금액 : pymtTxAllcAggrSum */
    private Long pymtTxAllcAggrSum;

    /** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
    private Long pymtSubtnIncmTxQnty;

    /** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
    private Long pymtSubtnRgonIncmTxQnty;

    /** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
    private Long pymtSubtnFarvilSpclQnty;

    /** set 납부차감_합계금액 : pymtSubtnAggrSum */
    private Long pymtSubtnAggrSum;

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
 
    /** set 영수일자 : reipDt */
    private java.lang.String reipDt; 
    
    public java.lang.String getReipDt() {
		return reipDt;
	}

	public void setReipDt(java.lang.String reipDt) {
		this.reipDt = reipDt;
	}

	public java.lang.String getFixPayJnDt() {
		return fixPayJnDt;
	}

	public void setFixPayJnDt(java.lang.String fixPayJnDt) {
		this.fixPayJnDt = fixPayJnDt;
	}

	public Long getSevePay20111231Sum() {
		return sevePay20111231Sum;
	}

	public void setSevePay20111231Sum(Long sevePay20111231Sum) {
		this.sevePay20111231Sum = sevePay20111231Sum;
	}

	public Long getCtrEepnMnth12Bfr() {
		return ctrEepnMnth12Bfr;
	}

	public void setCtrEepnMnth12Bfr(Long ctrEepnMnth12Bfr) {
		this.ctrEepnMnth12Bfr = ctrEepnMnth12Bfr;
	}

	public Long getCtrEepnMnth13Aft() {
		return ctrEepnMnth13Aft;
	}

	public void setCtrEepnMnth13Aft(Long ctrEepnMnth13Aft) {
		this.ctrEepnMnth13Aft = ctrEepnMnth13Aft;
	}

	public Long getCtrAddMnth12Bfr() {
		return ctrAddMnth12Bfr;
	}

	public void setCtrAddMnth12Bfr(Long ctrAddMnth12Bfr) {
		this.ctrAddMnth12Bfr = ctrAddMnth12Bfr;
	}

	public Long getCtrAddMnth13Aft() {
		return ctrAddMnth13Aft;
	}

	public void setCtrAddMnth13Aft(Long ctrAddMnth13Aft) {
		this.ctrAddMnth13Aft = ctrAddMnth13Aft;
	}

	public Long getEndEepnMnth12Bfr() {
		return endEepnMnth12Bfr;
	}

	public void setEndEepnMnth12Bfr(Long endEepnMnth12Bfr) {
		this.endEepnMnth12Bfr = endEepnMnth12Bfr;
	}

	public Long getEndEepnMnth13Aft() {
		return endEepnMnth13Aft;
	}

	public void setEndEepnMnth13Aft(Long endEepnMnth13Aft) {
		this.endEepnMnth13Aft = endEepnMnth13Aft;
	}

	public Long getEndAddMnth12Bfr() {
		return endAddMnth12Bfr;
	}

	public void setEndAddMnth12Bfr(Long endAddMnth12Bfr) {
		this.endAddMnth12Bfr = endAddMnth12Bfr;
	}

	public Long getEndAddMnth13Aft() {
		return endAddMnth13Aft;
	}

	public void setEndAddMnth13Aft(Long endAddMnth13Aft) {
		this.endAddMnth13Aft = endAddMnth13Aft;
	}

	public Long getTat13afrCalcTxAmnt() {
		return tat13afrCalcTxAmnt;
	}

	public void setTat13afrCalcTxAmnt(Long tat13afrCalcTxAmnt) {
		this.tat13afrCalcTxAmnt = tat13afrCalcTxAmnt;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    
    
    public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
	}

	public java.lang.String getCalcSevePsnBlggYrMnth() {
        return this.calcSevePsnBlggYrMnth;
    }
    
    public void setCalcSevePsnBlggYrMnth(java.lang.String calcSevePsnBlggYrMnth) {
        this.calcSevePsnBlggYrMnth = calcSevePsnBlggYrMnth;
    }
    
    public java.lang.String getCalcSevePayPsnDivCd() {
        return this.calcSevePayPsnDivCd;
    }
    
    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
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
    
    public Boolean getAimenrEcteYn() {
        return this.aimenrEcteYn;
    }
    
    public void setAimenrEcteYn(Boolean aimenrEcteYn) {
        this.aimenrEcteYn = aimenrEcteYn;
    }
    
    public java.lang.String getFrgnrDivCd() {
        return this.frgnrDivCd;
    }
    
    public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
        this.frgnrDivCd = frgnrDivCd;
    }
    
    public Boolean getRidnSeptYn() {
        return this.ridnSeptYn;
    }
    
    public void setRidnSeptYn(Boolean ridnSeptYn) {
        this.ridnSeptYn = ridnSeptYn;
    }
    
    public java.lang.String getRidnCd() {
        return this.ridnCd;
    }
    
    public void setRidnCd(java.lang.String ridnCd) {
        this.ridnCd = ridnCd;
    }
    
    public java.lang.String getRidnNm() {
        return this.ridnNm;
    }
    
    public void setRidnNm(java.lang.String ridnNm) {
        this.ridnNm = ridnNm;
    }
    
    public java.lang.String getBlggYrBgnnDt() {
        return this.blggYrBgnnDt;
    }
    
    public void setBlggYrBgnnDt(java.lang.String blggYrBgnnDt) {
        this.blggYrBgnnDt = blggYrBgnnDt;
    }
    
    public java.lang.String getBlggYrEndDt() {
        return this.blggYrEndDt;
    }
    
    public void setBlggYrEndDt(java.lang.String blggYrEndDt) {
        this.blggYrEndDt = blggYrEndDt;
    }
    
    public java.lang.String getRetryReasCd() {
        return this.retryReasCd;
    }
    
    public void setRetryReasCd(java.lang.String retryReasCd) {
        this.retryReasCd = retryReasCd;
    }
    
    public java.lang.String getCtrBusoprRgstnNum() {
        return this.ctrBusoprRgstnNum;
    }
    
    public void setCtrBusoprRgstnNum(java.lang.String ctrBusoprRgstnNum) {
        this.ctrBusoprRgstnNum = ctrBusoprRgstnNum;
    }
    
    public java.lang.String getCtrPaeWorkNm() {
        return this.ctrPaeWorkNm;
    }
    
    public void setCtrPaeWorkNm(java.lang.String ctrPaeWorkNm) {
        this.ctrPaeWorkNm = ctrPaeWorkNm;
    }
    
    public Long getCtrRetryPayQnty() {
        return this.ctrRetryPayQnty;
    }
    
    public void setCtrRetryPayQnty(Long ctrRetryPayQnty) {
        this.ctrRetryPayQnty = ctrRetryPayQnty;
    }
    
    public Long getCtrFreeDtyRetryPayQnty() {
        return this.ctrFreeDtyRetryPayQnty;
    }
    
    public void setCtrFreeDtyRetryPayQnty(Long ctrFreeDtyRetryPayQnty) {
        this.ctrFreeDtyRetryPayQnty = ctrFreeDtyRetryPayQnty;
    }
    
    public Long getCtrTxtnTgtRetryPayQnty() {
        return this.ctrTxtnTgtRetryPayQnty;
    }
    
    public void setCtrTxtnTgtRetryPayQnty(Long ctrTxtnTgtRetryPayQnty) {
        this.ctrTxtnTgtRetryPayQnty = ctrTxtnTgtRetryPayQnty;
    }
    
    public java.lang.String getEndBusoprRgstnNum() {
        return this.endBusoprRgstnNum;
    }
    
    public void setEndBusoprRgstnNum(java.lang.String endBusoprRgstnNum) {
        this.endBusoprRgstnNum = endBusoprRgstnNum;
    }
    
    public java.lang.String getEndPaeWorkNm() {
        return this.endPaeWorkNm;
    }
    
    public void setEndPaeWorkNm(java.lang.String endPaeWorkNm) {
        this.endPaeWorkNm = endPaeWorkNm;
    }
    
    public Long getEndRetryPayQnty() {
        return this.endRetryPayQnty;
    }
    
    public void setEndRetryPayQnty(Long endRetryPayQnty) {
        this.endRetryPayQnty = endRetryPayQnty;
    }
    
    public Long getEndFreeDtyRetryPayQnty() {
        return this.endFreeDtyRetryPayQnty;
    }
    
    public void setEndFreeDtyRetryPayQnty(Long endFreeDtyRetryPayQnty) {
        this.endFreeDtyRetryPayQnty = endFreeDtyRetryPayQnty;
    }
    
    public Long getEndTxtnTgtRetryPayQnty() {
        return this.endTxtnTgtRetryPayQnty;
    }
    
    public void setEndTxtnTgtRetryPayQnty(Long endTxtnTgtRetryPayQnty) {
        this.endTxtnTgtRetryPayQnty = endTxtnTgtRetryPayQnty;
    }
    
    public Long getClutRetryPayQnty() {
        return this.clutRetryPayQnty;
    }
    
    public void setClutRetryPayQnty(Long clutRetryPayQnty) {
        this.clutRetryPayQnty = clutRetryPayQnty;
    }
    
    public Long getClutFreeDtyRetryPayQnty() {
        return this.clutFreeDtyRetryPayQnty;
    }
    
    public void setClutFreeDtyRetryPayQnty(Long clutFreeDtyRetryPayQnty) {
        this.clutFreeDtyRetryPayQnty = clutFreeDtyRetryPayQnty;
    }
    
    public Long getClutTxtnTgtRetryPayQnty() {
        return this.clutTxtnTgtRetryPayQnty;
    }
    
    public void setClutTxtnTgtRetryPayQnty(Long clutTxtnTgtRetryPayQnty) {
        this.clutTxtnTgtRetryPayQnty = clutTxtnTgtRetryPayQnty;
    }
    
    public java.lang.String getCtrIcncDt() {
        return this.ctrIcncDt;
    }
    
    public void setCtrIcncDt(java.lang.String ctrIcncDt) {
        this.ctrIcncDt = ctrIcncDt;
    }
    
    public java.lang.String getCtrRkfcdDt() {
        return this.ctrRkfcdDt;
    }
    
    public void setCtrRkfcdDt(java.lang.String ctrRkfcdDt) {
        this.ctrRkfcdDt = ctrRkfcdDt;
    }
    
    public java.lang.String getCtrRsgtnDt() {
        return this.ctrRsgtnDt;
    }
    
    public void setCtrRsgtnDt(java.lang.String ctrRsgtnDt) {
        this.ctrRsgtnDt = ctrRsgtnDt;
    }
    
    public java.lang.String getCtrPymtDt() {
        return this.ctrPymtDt;
    }
    
    public void setCtrPymtDt(java.lang.String ctrPymtDt) {
        this.ctrPymtDt = ctrPymtDt;
    }
    
    public Long getCtrLogSvcMnthIcm() {
        return this.ctrLogSvcMnthIcm;
    }
    
    public void setCtrLogSvcMnthIcm(Long ctrLogSvcMnthIcm) {
        this.ctrLogSvcMnthIcm = ctrLogSvcMnthIcm;
    }
    
    public Long getCtrEepnMnthIcm() {
        return this.ctrEepnMnthIcm;
    }
    
    public void setCtrEepnMnthIcm(Long ctrEepnMnthIcm) {
        this.ctrEepnMnthIcm = ctrEepnMnthIcm;
    }
    
    public Long getCtrAddMnthIcm() {
        return this.ctrAddMnthIcm;
    }
    
    public void setCtrAddMnthIcm(Long ctrAddMnthIcm) {
        this.ctrAddMnthIcm = ctrAddMnthIcm;
    }
    
    public Long getCtrDupMnthIcm() {
        return this.ctrDupMnthIcm;
    }
    
    public void setCtrDupMnthIcm(Long ctrDupMnthIcm) {
        this.ctrDupMnthIcm = ctrDupMnthIcm;
    }
    
    public Long getCtrLogSvc() {
        return this.ctrLogSvc;
    }
    
    public void setCtrLogSvc(Long ctrLogSvc) {
        this.ctrLogSvc = ctrLogSvc;
    }
    
    public java.lang.String getEndIcncDt() {
        return this.endIcncDt;
    }
    
    public void setEndIcncDt(java.lang.String endIcncDt) {
        this.endIcncDt = endIcncDt;
    }
    
    public java.lang.String getEndRkfcdDt() {
        return this.endRkfcdDt;
    }
    
    public void setEndRkfcdDt(java.lang.String endRkfcdDt) {
        this.endRkfcdDt = endRkfcdDt;
    }
    
    public java.lang.String getEndRsgtnDt() {
        return this.endRsgtnDt;
    }
    
    public void setEndRsgtnDt(java.lang.String endRsgtnDt) {
        this.endRsgtnDt = endRsgtnDt;
    }
    
    public java.lang.String getEndPymtDt() {
        return this.endPymtDt;
    }
    
    public void setEndPymtDt(java.lang.String endPymtDt) {
        this.endPymtDt = endPymtDt;
    }
    
    public Long getEndLogSvcMnthIcm() {
        return this.endLogSvcMnthIcm;
    }
    
    public void setEndLogSvcMnthIcm(Long endLogSvcMnthIcm) {
        this.endLogSvcMnthIcm = endLogSvcMnthIcm;
    }
    
    public Long getEndEepnMnthIcm() {
        return this.endEepnMnthIcm;
    }
    
    public void setEndEepnMnthIcm(Long endEepnMnthIcm) {
        this.endEepnMnthIcm = endEepnMnthIcm;
    }
    
    public Long getEndAddMnthIcm() {
        return this.endAddMnthIcm;
    }
    
    public void setEndAddMnthIcm(Long endAddMnthIcm) {
        this.endAddMnthIcm = endAddMnthIcm;
    }
    
    public Long getEndDupMnthIcm() {
        return this.endDupMnthIcm;
    }
    
    public void setEndDupMnthIcm(Long endDupMnthIcm) {
        this.endDupMnthIcm = endDupMnthIcm;
    }
    
    public Long getEndLogSvcYrNum() {
        return this.endLogSvcYrNum;
    }
    
    public void setEndLogSvcYrNum(Long endLogSvcYrNum) {
        this.endLogSvcYrNum = endLogSvcYrNum;
    }
    
    public java.lang.String getClutIcncDt() {
        return this.clutIcncDt;
    }
    
    public void setClutIcncDt(java.lang.String clutIcncDt) {
        this.clutIcncDt = clutIcncDt;
    }
    
    public java.lang.String getClutRkfcdDt() {
        return this.clutRkfcdDt;
    }
    
    public void setClutRkfcdDt(java.lang.String clutRkfcdDt) {
        this.clutRkfcdDt = clutRkfcdDt;
    }
    
    public java.lang.String getClutRsgtnDt() {
        return this.clutRsgtnDt;
    }
    
    public void setClutRsgtnDt(java.lang.String clutRsgtnDt) {
        this.clutRsgtnDt = clutRsgtnDt;
    }
    
    public java.lang.String getClutPymtDt() {
        return this.clutPymtDt;
    }
    
    public void setClutPymtDt(java.lang.String clutPymtDt) {
        this.clutPymtDt = clutPymtDt;
    }
    
    public Long getClutLogSvcMnthIcm() {
        return this.clutLogSvcMnthIcm;
    }
    
    public void setClutLogSvcMnthIcm(Long clutLogSvcMnthIcm) {
        this.clutLogSvcMnthIcm = clutLogSvcMnthIcm;
    }
    
    public Long getClutEepnMnthIcm() {
        return this.clutEepnMnthIcm;
    }
    
    public void setClutEepnMnthIcm(Long clutEepnMnthIcm) {
        this.clutEepnMnthIcm = clutEepnMnthIcm;
    }
    
    public Long getClutAddMnthIcm() {
        return this.clutAddMnthIcm;
    }
    
    public void setClutAddMnthIcm(Long clutAddMnthIcm) {
        this.clutAddMnthIcm = clutAddMnthIcm;
    }
    
    public Long getClutDupMnthIcm() {
        return this.clutDupMnthIcm;
    }
    
    public void setClutDupMnthIcm(Long clutDupMnthIcm) {
        this.clutDupMnthIcm = clutDupMnthIcm;
    }
    
    public Long getClutLogSvcYrNum() {
        return this.clutLogSvcYrNum;
    }
    
    public void setClutLogSvcYrNum(Long clutLogSvcYrNum) {
        this.clutLogSvcYrNum = clutLogSvcYrNum;
    }
    
    public java.lang.String getLogPpnl12befIcncDt() {
        return this.logPpnl12befIcncDt;
    }
    
    public void setLogPpnl12befIcncDt(java.lang.String logPpnl12befIcncDt) {
        this.logPpnl12befIcncDt = logPpnl12befIcncDt;
    }
    
    public java.lang.String getLogPpnl12befRkfcdDt() {
        return this.logPpnl12befRkfcdDt;
    }
    
    public void setLogPpnl12befRkfcdDt(java.lang.String logPpnl12befRkfcdDt) {
        this.logPpnl12befRkfcdDt = logPpnl12befRkfcdDt;
    }
    
    public java.lang.String getLogPpnl12befRsgtnDt() {
        return this.logPpnl12befRsgtnDt;
    }
    
    public void setLogPpnl12befRsgtnDt(java.lang.String logPpnl12befRsgtnDt) {
        this.logPpnl12befRsgtnDt = logPpnl12befRsgtnDt;
    }
    
    public java.lang.String getLogPpnl12befPymtDt() {
        return this.logPpnl12befPymtDt;
    }
    
    public void setLogPpnl12befPymtDt(java.lang.String logPpnl12befPymtDt) {
        this.logPpnl12befPymtDt = logPpnl12befPymtDt;
    }
    
    public Long getLogPpnl12befLogMnthIcm() {
        return this.logPpnl12befLogMnthIcm;
    }
    
    public void setLogPpnl12befLogMnthIcm(Long logPpnl12befLogMnthIcm) {
        this.logPpnl12befLogMnthIcm = logPpnl12befLogMnthIcm;
    }
    
    public Long getLogPpnl12befEepnMnthIcm() {
        return this.logPpnl12befEepnMnthIcm;
    }
    
    public void setLogPpnl12befEepnMnthIcm(Long logPpnl12befEepnMnthIcm) {
        this.logPpnl12befEepnMnthIcm = logPpnl12befEepnMnthIcm;
    }
    
    public Long getLogPpnl12befAddMnthIcm() {
        return this.logPpnl12befAddMnthIcm;
    }
    
    public void setLogPpnl12befAddMnthIcm(Long logPpnl12befAddMnthIcm) {
        this.logPpnl12befAddMnthIcm = logPpnl12befAddMnthIcm;
    }
    
    public Long getLogPpnl12befDupMnthIcm() {
        return this.logPpnl12befDupMnthIcm;
    }
    
    public void setLogPpnl12befDupMnthIcm(Long logPpnl12befDupMnthIcm) {
        this.logPpnl12befDupMnthIcm = logPpnl12befDupMnthIcm;
    }
    
    public Long getLogPpnl12befLogYrNum() {
        return this.logPpnl12befLogYrNum;
    }
    
    public void setLogPpnl12befLogYrNum(Long logPpnl12befLogYrNum) {
        this.logPpnl12befLogYrNum = logPpnl12befLogYrNum;
    }
    
    public java.lang.String getLogPpnl13afrIcncDt() {
        return this.logPpnl13afrIcncDt;
    }
    
    public void setLogPpnl13afrIcncDt(java.lang.String logPpnl13afrIcncDt) {
        this.logPpnl13afrIcncDt = logPpnl13afrIcncDt;
    }
    
    public java.lang.String getLogPpnl13afrRkfcdDt() {
        return this.logPpnl13afrRkfcdDt;
    }
    
    public void setLogPpnl13afrRkfcdDt(java.lang.String logPpnl13afrRkfcdDt) {
        this.logPpnl13afrRkfcdDt = logPpnl13afrRkfcdDt;
    }
    
    public java.lang.String getLogPpnl13afrRsgtnDt() {
        return this.logPpnl13afrRsgtnDt;
    }
    
    public void setLogPpnl13afrRsgtnDt(java.lang.String logPpnl13afrRsgtnDt) {
        this.logPpnl13afrRsgtnDt = logPpnl13afrRsgtnDt;
    }
    
    public java.lang.String getLogPpnl13afrPymtDt() {
        return this.logPpnl13afrPymtDt;
    }
    
    public void setLogPpnl13afrPymtDt(java.lang.String logPpnl13afrPymtDt) {
        this.logPpnl13afrPymtDt = logPpnl13afrPymtDt;
    }
    
    public Long getLogPpnl13afrLogMnthIcm() {
        return this.logPpnl13afrLogMnthIcm;
    }
    
    public void setLogPpnl13afrLogMnthIcm(Long logPpnl13afrLogMnthIcm) {
        this.logPpnl13afrLogMnthIcm = logPpnl13afrLogMnthIcm;
    }
    
    public Long getLogPpnl13afrEepnMnthIcm() {
        return this.logPpnl13afrEepnMnthIcm;
    }
    
    public void setLogPpnl13afrEepnMnthIcm(Long logPpnl13afrEepnMnthIcm) {
        this.logPpnl13afrEepnMnthIcm = logPpnl13afrEepnMnthIcm;
    }
    
    public Long getLogPpnl13afrAddMnthIcm() {
        return this.logPpnl13afrAddMnthIcm;
    }
    
    public void setLogPpnl13afrAddMnthIcm(Long logPpnl13afrAddMnthIcm) {
        this.logPpnl13afrAddMnthIcm = logPpnl13afrAddMnthIcm;
    }
    
    public Long getLogPpnl13afrDupMnthIcm() {
        return this.logPpnl13afrDupMnthIcm;
    }
    
    public void setLogPpnl13afrDupMnthIcm(Long logPpnl13afrDupMnthIcm) {
        this.logPpnl13afrDupMnthIcm = logPpnl13afrDupMnthIcm;
    }
    
    public Long getLogPpnl13afrLogSvc() {
        return this.logPpnl13afrLogSvc;
    }
    
    public void setLogPpnl13afrLogSvc(Long logPpnl13afrLogSvc) {
        this.logPpnl13afrLogSvc = logPpnl13afrLogSvc;
    }
    
    public Long getRetryIncmCtrPymtSum() {
        return this.retryIncmCtrPymtSum;
    }
    
    public void setRetryIncmCtrPymtSum(Long retryIncmCtrPymtSum) {
        this.retryIncmCtrPymtSum = retryIncmCtrPymtSum;
    }
    
    public Long getRetryIncmEndPymtSum() {
        return this.retryIncmEndPymtSum;
    }
    
    public void setRetryIncmEndPymtSum(Long retryIncmEndPymtSum) {
        this.retryIncmEndPymtSum = retryIncmEndPymtSum;
    }
    
    public Long getRetryIncmClutSum() {
        return this.retryIncmClutSum;
    }
    
    public void setRetryIncmClutSum(Long retryIncmClutSum) {
        this.retryIncmClutSum = retryIncmClutSum;
    }
    
    public Long getRetryFxrtDducClutSum() {
        return this.retryFxrtDducClutSum;
    }
    
    public void setRetryFxrtDducClutSum(Long retryFxrtDducClutSum) {
        this.retryFxrtDducClutSum = retryFxrtDducClutSum;
    }
    
    public Long getLogYrDducSum() {
        return this.logYrDducSum;
    }
    
    public void setLogYrDducSum(Long logYrDducSum) {
        this.logYrDducSum = logYrDducSum;
    }
    
    public Long getRetryTxtnStdClutSum() {
        return this.retryTxtnStdClutSum;
    }
    
    public void setRetryTxtnStdClutSum(Long retryTxtnStdClutSum) {
        this.retryTxtnStdClutSum = retryTxtnStdClutSum;
    }
    
    public Long getTat12befTxtnStdPpnlSum() {
        return this.tat12befTxtnStdPpnlSum;
    }
    
    public void setTat12befTxtnStdPpnlSum(Long tat12befTxtnStdPpnlSum) {
        this.tat12befTxtnStdPpnlSum = tat12befTxtnStdPpnlSum;
    }
    
    public Long getTat12befYravgTxstdSum() {
        return this.tat12befYravgTxstdSum;
    }
    
    public void setTat12befYravgTxstdSum(Long tat12befYravgTxstdSum) {
        this.tat12befYravgTxstdSum = tat12befYravgTxstdSum;
    }
    
    public Long getTat12befCvsnTxtnStdSum() {
        return this.tat12befCvsnTxtnStdSum;
    }
    
    public void setTat12befCvsnTxtnStdSum(Long tat12befCvsnTxtnStdSum) {
        this.tat12befCvsnTxtnStdSum = tat12befCvsnTxtnStdSum;
    }
    
    public Long getTat12befCvsnCalcAmnt() {
        return this.tat12befCvsnCalcAmnt;
    }
    
    public void setTat12befCvsnCalcAmnt(Long tat12befCvsnCalcAmnt) {
        this.tat12befCvsnCalcAmnt = tat12befCvsnCalcAmnt;
    }
    
    public Long getTat12befYrAvgCalcAmnt() {
        return this.tat12befYrAvgCalcAmnt;
    }
    
    public void setTat12befYrAvgCalcAmnt(Long tat12befYrAvgCalcAmnt) {
        this.tat12befYrAvgCalcAmnt = tat12befYrAvgCalcAmnt;
    }
    
    public Long getTat12befCalcTxAmnt() {
        return this.tat12befCalcTxAmnt;
    }
    
    public void setTat12befCalcTxAmnt(Long tat12befCalcTxAmnt) {
        this.tat12befCalcTxAmnt = tat12befCalcTxAmnt;
    }
    
    public Long getTat12befAlpayTxAmnt() {
        return this.tat12befAlpayTxAmnt;
    }
    
    public void setTat12befAlpayTxAmnt(Long tat12befAlpayTxAmnt) {
        this.tat12befAlpayTxAmnt = tat12befAlpayTxAmnt;
    }
    
    public Long getTat12befRegTgtTxAmnt() {
        return this.tat12befRegTgtTxAmnt;
    }
    
    public void setTat12befRegTgtTxAmnt(Long tat12befRegTgtTxAmnt) {
        this.tat12befRegTgtTxAmnt = tat12befRegTgtTxAmnt;
    }
    
    public Long getTat13afrTxstdPpnlSum() {
        return this.tat13afrTxstdPpnlSum;
    }
    
    public void setTat13afrTxstdPpnlSum(Long tat13afrTxstdPpnlSum) {
        this.tat13afrTxstdPpnlSum = tat13afrTxstdPpnlSum;
    }
    
    public Long getTat13afrYrAvgStdSum() {
        return this.tat13afrYrAvgStdSum;
    }
    
    public void setTat13afrYrAvgStdSum(Long tat13afrYrAvgStdSum) {
        this.tat13afrYrAvgStdSum = tat13afrYrAvgStdSum;
    }
    
    public Long getTat13afrCvsnTxtnStdSum() {
        return this.tat13afrCvsnTxtnStdSum;
    }
    
    public void setTat13afrCvsnTxtnStdSum(Long tat13afrCvsnTxtnStdSum) {
        this.tat13afrCvsnTxtnStdSum = tat13afrCvsnTxtnStdSum;
    }
    
    public Long getTat13afrCvsnCalcTxAmnt() {
        return this.tat13afrCvsnCalcTxAmnt;
    }
    
    public void setTat13afrCvsnCalcTxAmnt(Long tat13afrCvsnCalcTxAmnt) {
        this.tat13afrCvsnCalcTxAmnt = tat13afrCvsnCalcTxAmnt;
    }
    
    public Long getTat13afrYrAvgCalcAmnt() {
        return this.tat13afrYrAvgCalcAmnt;
    }
    
    public void setTat13afrYrAvgCalcAmnt(Long tat13afrYrAvgCalcAmnt) {
        this.tat13afrYrAvgCalcAmnt = tat13afrYrAvgCalcAmnt;
    }
    
    public Long getTat13afrAlpayTxAmnt() {
        return this.tat13afrAlpayTxAmnt;
    }
    
    public void setTat13afrAlpayTxAmnt(Long tat13afrAlpayTxAmnt) {
        this.tat13afrAlpayTxAmnt = tat13afrAlpayTxAmnt;
    }
    
    public Long getTat13afrRegrstTgtSum() {
        return this.tat13afrRegrstTgtSum;
    }
    
    public void setTat13afrRegrstTgtSum(Long tat13afrRegrstTgtSum) {
        this.tat13afrRegrstTgtSum = tat13afrRegrstTgtSum;
    }
    
    public Long getTatAggrTxtnStdPpnlSum() {
        return this.tatAggrTxtnStdPpnlSum;
    }
    
    public void setTatAggrTxtnStdPpnlSum(Long tatAggrTxtnStdPpnlSum) {
        this.tatAggrTxtnStdPpnlSum = tatAggrTxtnStdPpnlSum;
    }
    
    public Long getTatAggrYrAvgTxtnStdSum() {
        return this.tatAggrYrAvgTxtnStdSum;
    }
    
    public void setTatAggrYrAvgTxtnStdSum(Long tatAggrYrAvgTxtnStdSum) {
        this.tatAggrYrAvgTxtnStdSum = tatAggrYrAvgTxtnStdSum;
    }
    
    public Long getTatAggrCvsnTxtnStdSum() {
        return this.tatAggrCvsnTxtnStdSum;
    }
    
    public void setTatAggrCvsnTxtnStdSum(Long tatAggrCvsnTxtnStdSum) {
        this.tatAggrCvsnTxtnStdSum = tatAggrCvsnTxtnStdSum;
    }
    
    public Long getTatAggrCvsnCalcTxAmnt() {
        return this.tatAggrCvsnCalcTxAmnt;
    }
    
    public void setTatAggrCvsnCalcTxAmnt(Long tatAggrCvsnCalcTxAmnt) {
        this.tatAggrCvsnCalcTxAmnt = tatAggrCvsnCalcTxAmnt;
    }
    
    public Long getTatAggrYrAvgCalcTxAmnt() {
        return this.tatAggrYrAvgCalcTxAmnt;
    }
    
    public void setTatAggrYrAvgCalcTxAmnt(Long tatAggrYrAvgCalcTxAmnt) {
        this.tatAggrYrAvgCalcTxAmnt = tatAggrYrAvgCalcTxAmnt;
    }
    
    public Long getTatAggrCalcTxAmnt() {
        return this.tatAggrCalcTxAmnt;
    }
    
    public void setTatAggrCalcTxAmnt(Long tatAggrCalcTxAmnt) {
        this.tatAggrCalcTxAmnt = tatAggrCalcTxAmnt;
    }
    
    public Long getTatAggrAlpayTxAmnt() {
        return this.tatAggrAlpayTxAmnt;
    }
    
    public void setTatAggrAlpayTxAmnt(Long tatAggrAlpayTxAmnt) {
        this.tatAggrAlpayTxAmnt = tatAggrAlpayTxAmnt;
    }
    
    public Long getTatAggrRegrstTgtTxAmnt() {
        return this.tatAggrRegrstTgtTxAmnt;
    }
    
    public void setTatAggrRegrstTgtTxAmnt(Long tatAggrRegrstTgtTxAmnt) {
        this.tatAggrRegrstTgtTxAmnt = tatAggrRegrstTgtTxAmnt;
    }
    
    public Long getTalRegrstTgtTxAmnt() {
        return this.talRegrstTgtTxAmnt;
    }
    
    public void setTalRegrstTgtTxAmnt(Long talRegrstTgtTxAmnt) {
        this.talRegrstTgtTxAmnt = talRegrstTgtTxAmnt;
    }
    
    public Long getTalAccuDepitAggrSum() {
        return this.talAccuDepitAggrSum;
    }
    
    public void setTalAccuDepitAggrSum(Long talAccuDepitAggrSum) {
        this.talAccuDepitAggrSum = talAccuDepitAggrSum;
    }
    
    public Long getTalRetryPayQnty() {
        return this.talRetryPayQnty;
    }
    
    public void setTalRetryPayQnty(Long talRetryPayQnty) {
        this.talRetryPayQnty = talRetryPayQnty;
    }
    
    public Long getTalRetryIncmTxAmnt() {
        return this.talRetryIncmTxAmnt;
    }
    
    public void setTalRetryIncmTxAmnt(Long talRetryIncmTxAmnt) {
        this.talRetryIncmTxAmnt = talRetryIncmTxAmnt;
    }
    
    public Long getPymtRegTgtIncmTxQnty() {
        return this.pymtRegTgtIncmTxQnty;
    }
    
    public void setPymtRegTgtIncmTxQnty(Long pymtRegTgtIncmTxQnty) {
        this.pymtRegTgtIncmTxQnty = pymtRegTgtIncmTxQnty;
    }
    
    public Long getPymtRegTgtRgonIncmQnty() {
        return this.pymtRegTgtRgonIncmQnty;
    }
    
    public void setPymtRegTgtRgonIncmQnty(Long pymtRegTgtRgonIncmQnty) {
        this.pymtRegTgtRgonIncmQnty = pymtRegTgtRgonIncmQnty;
    }
    
    public Long getPymtRegTgtFarvilSpclQnty() {
        return this.pymtRegTgtFarvilSpclQnty;
    }
    
    public void setPymtRegTgtFarvilSpclQnty(Long pymtRegTgtFarvilSpclQnty) {
        this.pymtRegTgtFarvilSpclQnty = pymtRegTgtFarvilSpclQnty;
    }
    
    public Long getPymtRegrstTgtAggrSum() {
        return this.pymtRegrstTgtAggrSum;
    }
    
    public void setPymtRegrstTgtAggrSum(Long pymtRegrstTgtAggrSum) {
        this.pymtRegrstTgtAggrSum = pymtRegrstTgtAggrSum;
    }
    
    public Long getPymtTalcIncmTxQnty() {
        return this.pymtTalcIncmTxQnty;
    }
    
    public void setPymtTalcIncmTxQnty(Long pymtTalcIncmTxQnty) {
        this.pymtTalcIncmTxQnty = pymtTalcIncmTxQnty;
    }
    
    public Long getPymtTalcRgonIncmTxQnty() {
        return this.pymtTalcRgonIncmTxQnty;
    }
    
    public void setPymtTalcRgonIncmTxQnty(Long pymtTalcRgonIncmTxQnty) {
        this.pymtTalcRgonIncmTxQnty = pymtTalcRgonIncmTxQnty;
    }
    
    public Long getPymtTalcFarvilSpclQnty() {
        return this.pymtTalcFarvilSpclQnty;
    }
    
    public void setPymtTalcFarvilSpclQnty(Long pymtTalcFarvilSpclQnty) {
        this.pymtTalcFarvilSpclQnty = pymtTalcFarvilSpclQnty;
    }
    
    public Long getPymtTxAllcAggrSum() {
        return this.pymtTxAllcAggrSum;
    }
    
    public void setPymtTxAllcAggrSum(Long pymtTxAllcAggrSum) {
        this.pymtTxAllcAggrSum = pymtTxAllcAggrSum;
    }
    
    public Long getPymtSubtnIncmTxQnty() {
        return this.pymtSubtnIncmTxQnty;
    }
    
    public void setPymtSubtnIncmTxQnty(Long pymtSubtnIncmTxQnty) {
        this.pymtSubtnIncmTxQnty = pymtSubtnIncmTxQnty;
    }
    
    public Long getPymtSubtnRgonIncmTxQnty() {
        return this.pymtSubtnRgonIncmTxQnty;
    }
    
    public void setPymtSubtnRgonIncmTxQnty(Long pymtSubtnRgonIncmTxQnty) {
        this.pymtSubtnRgonIncmTxQnty = pymtSubtnRgonIncmTxQnty;
    }
    
    public Long getPymtSubtnFarvilSpclQnty() {
        return this.pymtSubtnFarvilSpclQnty;
    }
    
    public void setPymtSubtnFarvilSpclQnty(Long pymtSubtnFarvilSpclQnty) {
        this.pymtSubtnFarvilSpclQnty = pymtSubtnFarvilSpclQnty;
    }
    
    public Long getPymtSubtnAggrSum() {
        return this.pymtSubtnAggrSum;
    }
    
    public void setPymtSubtnAggrSum(Long pymtSubtnAggrSum) {
        this.pymtSubtnAggrSum = pymtSubtnAggrSum;
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
    
}
