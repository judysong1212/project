package com.app.smrmf.infc.retirement.server.vo;

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
public class InfcPkgRemt3100VO  implements Serializable {
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
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    /** set 소득자임원여부 : aimenrEcteYn */
    private java.lang.String aimenrEcteYn;
    

/** set 확정급여형가입일자 : fixPayJnDt */
private java.lang.String fixPayJnDt;

/** set 퇴직금_20111231금액 : sevePay20111231Sum */
private java.math.BigDecimal sevePay20111231Sum;


    /** set 외국인구분코드 : frgnrDivCd */
    private java.lang.String frgnrDivCd;

    /** set 거주구분여부 : ridnSeptYn */
    private java.lang.String ridnSeptYn;

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
    private java.math.BigDecimal ctrRetryPayQnty;

    /** set 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
    private java.math.BigDecimal ctrFreeDtyRetryPayQnty;

    /** set 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
    private java.math.BigDecimal ctrTxtnTgtRetryPayQnty;

    /** set 종_사업자등록번호 : endBusoprRgstnNum */
    private java.lang.String endBusoprRgstnNum;

    /** set 종_근무처명 : endPaeWorkNm */
    private java.lang.String endPaeWorkNm;

    /** set 종_퇴직급여액 : endRetryPayQnty */
    private java.math.BigDecimal endRetryPayQnty;

    /** set 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
    private java.math.BigDecimal endFreeDtyRetryPayQnty;

    /** set 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
    private java.math.BigDecimal endTxtnTgtRetryPayQnty;

    /** set 정산_퇴직급여액 : clutRetryPayQnty */
    private java.math.BigDecimal clutRetryPayQnty;

    /** set 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
    private java.math.BigDecimal clutFreeDtyRetryPayQnty;

    /** set 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
    private java.math.BigDecimal clutTxtnTgtRetryPayQnty;

    /** set 중_입사일자 : ctrIcncDt */
    private java.lang.String ctrIcncDt;

    /** set 중_기산일자 : ctrRkfcdDt */
    private java.lang.String ctrRkfcdDt;

    /** set 중_퇴사일자 : ctrRsgtnDt */
    private java.lang.String ctrRsgtnDt;

    /** set 중_지급일자 : ctrPymtDt */
    private java.lang.String ctrPymtDt;

    /** set 중_근속월수 : ctrLogSvcMnthIcm */
    private java.math.BigDecimal ctrLogSvcMnthIcm;

    /** set 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
    private java.math.BigDecimal ctrEepnMnth12Bfr;

    /** set 중_제외월수_2013이후 : ctrEepnMnth13Aft */
    private java.math.BigDecimal ctrEepnMnth13Aft;

    /** set 중_가산월수_2012이전 : ctrAddMnth12Bfr */
    private java.math.BigDecimal ctrAddMnth12Bfr;

    /** set 중_가산월수_2013이후 : ctrAddMnth13Aft */
    private java.math.BigDecimal ctrAddMnth13Aft;

    /** set 중_제외월수 : ctrEepnMnthIcm */
    private java.math.BigDecimal ctrEepnMnthIcm;

    /** set 중_가산월수 : ctrAddMnthIcm */
    private java.math.BigDecimal ctrAddMnthIcm;

    /** set 중_중복월수 : ctrDupMnthIcm */
    private java.math.BigDecimal ctrDupMnthIcm;

    /** set 중_근속연수 : ctrLogSvc */
    private java.math.BigDecimal ctrLogSvc;

    /** set 종_입사일자 : endIcncDt */
    private java.lang.String endIcncDt;

    /** set 종_기산일자 : endRkfcdDt */
    private java.lang.String endRkfcdDt;

    /** set 종_퇴사일자 : endRsgtnDt */
    private java.lang.String endRsgtnDt;

    /** set 종_지급일자 : endPymtDt */
    private java.lang.String endPymtDt;

    /** set 종_근속월수 : endLogSvcMnthIcm */
    private java.math.BigDecimal endLogSvcMnthIcm;

    /** set 종_제외월수_2012이전 : endEepnMnth12Bfr */
    private java.math.BigDecimal endEepnMnth12Bfr;

    /** set 종_제외월수_2013이후 : endEepnMnth13Aft */
    private java.math.BigDecimal endEepnMnth13Aft;

    /** set 종_가산월수_2012이전 : endAddMnth12Bfr */
    private java.math.BigDecimal endAddMnth12Bfr;

    /** set 종_가산월수_2013이후 : endAddMnth13Aft */
    private java.math.BigDecimal endAddMnth13Aft;

    /** set 종_제외월수 : endEepnMnthIcm */
    private java.math.BigDecimal endEepnMnthIcm;

    /** set 종_가산월수 : endAddMnthIcm */
    private java.math.BigDecimal endAddMnthIcm;

    /** set 종_중복월수 : endDupMnthIcm */
    private java.math.BigDecimal endDupMnthIcm;

    /** set 종_근속연수 : endLogSvcYrNum */
    private java.math.BigDecimal endLogSvcYrNum;

    /** set 정산_입사일자 : clutIcncDt */
    private java.lang.String clutIcncDt;

    /** set 정산-기산일자 : clutRkfcdDt */
    private java.lang.String clutRkfcdDt;

    /** set 정산_퇴사일자 : clutRsgtnDt */
    private java.lang.String clutRsgtnDt;

    /** set 정산_지급일자 : clutPymtDt */
    private java.lang.String clutPymtDt;

    /** set 정산_근속월수 : clutLogSvcMnthIcm */
    private java.math.BigDecimal clutLogSvcMnthIcm;

    /** set 정산_제외월수 : clutEepnMnthIcm */
    private java.math.BigDecimal clutEepnMnthIcm;

    /** set 정산_가산월수 : clutAddMnthIcm */
    private java.math.BigDecimal clutAddMnthIcm;

    /** set 정산_중복월수 : clutDupMnthIcm */
    private java.math.BigDecimal clutDupMnthIcm;

    /** set 정산_근속연수 : clutLogSvcYrNum */
    private java.math.BigDecimal clutLogSvcYrNum;

    /** set 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
    private java.lang.String logPpnl12befIcncDt;

    /** set 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
    private java.lang.String logPpnl12befRkfcdDt;

    /** set 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
    private java.lang.String logPpnl12befRsgtnDt;

    /** set 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
    private java.lang.String logPpnl12befPymtDt;

    /** set 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
    private java.math.BigDecimal logPpnl12befLogMnthIcm;

    /** set 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
    private java.math.BigDecimal logPpnl12befEepnMnthIcm;

    /** set 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
    private java.math.BigDecimal logPpnl12befAddMnthIcm;

    /** set 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
    private java.math.BigDecimal logPpnl12befDupMnthIcm;

    /** set 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    private java.math.BigDecimal logPpnl12befLogYrNum;

    /** set 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
    private java.lang.String logPpnl13afrIcncDt;

    /** set 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
    private java.lang.String logPpnl13afrRkfcdDt;

    /** set 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
    private java.lang.String logPpnl13afrRsgtnDt;

    /** set 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
    private java.lang.String logPpnl13afrPymtDt;

    /** set 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
    private java.math.BigDecimal logPpnl13afrLogMnthIcm;

    /** set 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
    private java.math.BigDecimal logPpnl13afrEepnMnthIcm;

    /** set 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
    private java.math.BigDecimal logPpnl13afrAddMnthIcm;

    /** set 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
    private java.math.BigDecimal logPpnl13afrDupMnthIcm;

    /** set 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    private java.math.BigDecimal logPpnl13afrLogSvc;

    /** set 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
    private java.math.BigDecimal retryIncmCtrPymtSum;

    /** set 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
    private java.math.BigDecimal retryIncmEndPymtSum;

    /** set 퇴직소득_정산금액 : retryIncmClutSum */
    private java.math.BigDecimal retryIncmClutSum;

    /** set 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
    private java.math.BigDecimal retryFxrtDducClutSum;

    /** set 근속년수공제_정산금액 : logYrDducSum */
    private java.math.BigDecimal logYrDducSum;

    /** set 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    private java.math.BigDecimal retryTxtnStdClutSum;

    /** set 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    private java.math.BigDecimal tat12befTxtnStdPpnlSum;

    /** set 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    private java.math.BigDecimal tat12befYravgTxstdSum;

    /** set 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    private java.math.BigDecimal tat12befCvsnTxtnStdSum;

    /** set 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    private java.math.BigDecimal tat12befCvsnCalcAmnt;

    /** set 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    private java.math.BigDecimal tat12befYrAvgCalcAmnt;

    /** set 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    private java.math.BigDecimal tat12befCalcTxAmnt;

    /** set 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    private java.math.BigDecimal tat12befAlpayTxAmnt;

    /** set 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    private java.math.BigDecimal tat12befRegTgtTxAmnt;

    /** set 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    private java.math.BigDecimal tat13afrTxstdPpnlSum;

    /** set 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    private java.math.BigDecimal tat13afrYrAvgStdSum;

    /** set 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    private java.math.BigDecimal tat13afrCvsnTxtnStdSum;

    /** set 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    private java.math.BigDecimal tat13afrCvsnCalcTxAmnt;

    /** set 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    private java.math.BigDecimal tat13afrYrAvgCalcAmnt;

    /** set 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
    private java.math.BigDecimal tat13afrCalcTxAmnt;

    /** set 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    private java.math.BigDecimal tat13afrAlpayTxAmnt;

    /** set 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    private java.math.BigDecimal tat13afrRegrstTgtSum;

    /** set 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    private java.math.BigDecimal tatAggrTxtnStdPpnlSum;

    /** set 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    private java.math.BigDecimal tatAggrYrAvgTxtnStdSum;

    /** set 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    private java.math.BigDecimal tatAggrCvsnTxtnStdSum;

    /** set 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    private java.math.BigDecimal tatAggrCvsnCalcTxAmnt;

    /** set 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    private java.math.BigDecimal tatAggrYrAvgCalcTxAmnt;

    /** set 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    private java.math.BigDecimal tatAggrCalcTxAmnt;

    /** set 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    private java.math.BigDecimal tatAggrAlpayTxAmnt;

    /** set 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    private java.math.BigDecimal tatAggrRegrstTgtTxAmnt;

    /** set 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
    private java.math.BigDecimal talRegrstTgtTxAmnt;

    /** set 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
    private java.math.BigDecimal talAccuDepitAggrSum;

    /** set 이연세액_퇴직급여액 : talRetryPayQnty */
    private java.math.BigDecimal talRetryPayQnty;

    /** set 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
    private java.math.BigDecimal talRetryIncmTxAmnt;

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    private java.math.BigDecimal pymtRegTgtIncmTxQnty;

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    private java.math.BigDecimal pymtRegTgtRgonIncmQnty;

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    private java.math.BigDecimal pymtRegTgtFarvilSpclQnty;

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    private java.math.BigDecimal pymtRegrstTgtAggrSum;

    /** set 납부이연_소득세액 : pymtTalcIncmTxQnty */
    private java.math.BigDecimal pymtTalcIncmTxQnty;

    /** set 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
    private java.math.BigDecimal pymtTalcRgonIncmTxQnty;

    /** set 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
    private java.math.BigDecimal pymtTalcFarvilSpclQnty;

    /** set 납부이연_합계금액 : pymtTxAllcAggrSum */
    private java.math.BigDecimal pymtTxAllcAggrSum;

    /** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
    private java.math.BigDecimal pymtSubtnIncmTxQnty;

    /** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
    private java.math.BigDecimal pymtSubtnRgonIncmTxQnty;

    /** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
    private java.math.BigDecimal pymtSubtnFarvilSpclQnty;

    /** set 납부차감_합계금액 : pymtSubtnAggrSum */
    private java.math.BigDecimal pymtSubtnAggrSum;

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

    

    
    public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
	}

	public java.lang.String getFixPayJnDt() {
		return fixPayJnDt;
	}

	public void setFixPayJnDt(java.lang.String fixPayJnDt) {
		this.fixPayJnDt = fixPayJnDt;
	}

	public java.math.BigDecimal getSevePay20111231Sum() {
		return sevePay20111231Sum;
	}

	public void setSevePay20111231Sum(java.math.BigDecimal sevePay20111231Sum) {
		this.sevePay20111231Sum = sevePay20111231Sum;
	}

	public java.math.BigDecimal getCtrEepnMnth12Bfr() {
		return ctrEepnMnth12Bfr;
	}

	public void setCtrEepnMnth12Bfr(java.math.BigDecimal ctrEepnMnth12Bfr) {
		this.ctrEepnMnth12Bfr = ctrEepnMnth12Bfr;
	}

	public java.math.BigDecimal getCtrEepnMnth13Aft() {
		return ctrEepnMnth13Aft;
	}

	public void setCtrEepnMnth13Aft(java.math.BigDecimal ctrEepnMnth13Aft) {
		this.ctrEepnMnth13Aft = ctrEepnMnth13Aft;
	}

	public java.math.BigDecimal getCtrAddMnth12Bfr() {
		return ctrAddMnth12Bfr;
	}

	public void setCtrAddMnth12Bfr(java.math.BigDecimal ctrAddMnth12Bfr) {
		this.ctrAddMnth12Bfr = ctrAddMnth12Bfr;
	}

	public java.math.BigDecimal getCtrAddMnth13Aft() {
		return ctrAddMnth13Aft;
	}

	public void setCtrAddMnth13Aft(java.math.BigDecimal ctrAddMnth13Aft) {
		this.ctrAddMnth13Aft = ctrAddMnth13Aft;
	}

	public java.math.BigDecimal getEndEepnMnth12Bfr() {
		return endEepnMnth12Bfr;
	}

	public void setEndEepnMnth12Bfr(java.math.BigDecimal endEepnMnth12Bfr) {
		this.endEepnMnth12Bfr = endEepnMnth12Bfr;
	}

	public java.math.BigDecimal getEndEepnMnth13Aft() {
		return endEepnMnth13Aft;
	}

	public void setEndEepnMnth13Aft(java.math.BigDecimal endEepnMnth13Aft) {
		this.endEepnMnth13Aft = endEepnMnth13Aft;
	}

	public java.math.BigDecimal getEndAddMnth12Bfr() {
		return endAddMnth12Bfr;
	}

	public void setEndAddMnth12Bfr(java.math.BigDecimal endAddMnth12Bfr) {
		this.endAddMnth12Bfr = endAddMnth12Bfr;
	}

	public java.math.BigDecimal getEndAddMnth13Aft() {
		return endAddMnth13Aft;
	}

	public void setEndAddMnth13Aft(java.math.BigDecimal endAddMnth13Aft) {
		this.endAddMnth13Aft = endAddMnth13Aft;
	}

	public java.math.BigDecimal getTat13afrCalcTxAmnt() {
		return tat13afrCalcTxAmnt;
	}

	public void setTat13afrCalcTxAmnt(java.math.BigDecimal tat13afrCalcTxAmnt) {
		this.tat13afrCalcTxAmnt = tat13afrCalcTxAmnt;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
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
    
    public java.lang.String getAimenrEcteYn() {
        return this.aimenrEcteYn;
    }
    
    public void setAimenrEcteYn(java.lang.String aimenrEcteYn) {
        this.aimenrEcteYn = aimenrEcteYn;
    }
    
    public java.lang.String getFrgnrDivCd() {
        return this.frgnrDivCd;
    }
    
    public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
        this.frgnrDivCd = frgnrDivCd;
    }
    
    public java.lang.String getRidnSeptYn() {
        return this.ridnSeptYn;
    }
    
    public void setRidnSeptYn(java.lang.String ridnSeptYn) {
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
    
    public java.math.BigDecimal getCtrRetryPayQnty() {
        return this.ctrRetryPayQnty;
    }
    
    public void setCtrRetryPayQnty(java.math.BigDecimal ctrRetryPayQnty) {
        this.ctrRetryPayQnty = ctrRetryPayQnty;
    }
    
    public java.math.BigDecimal getCtrFreeDtyRetryPayQnty() {
        return this.ctrFreeDtyRetryPayQnty;
    }
    
    public void setCtrFreeDtyRetryPayQnty(java.math.BigDecimal ctrFreeDtyRetryPayQnty) {
        this.ctrFreeDtyRetryPayQnty = ctrFreeDtyRetryPayQnty;
    }
    
    public java.math.BigDecimal getCtrTxtnTgtRetryPayQnty() {
        return this.ctrTxtnTgtRetryPayQnty;
    }
    
    public void setCtrTxtnTgtRetryPayQnty(java.math.BigDecimal ctrTxtnTgtRetryPayQnty) {
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
    
    public java.math.BigDecimal getEndRetryPayQnty() {
        return this.endRetryPayQnty;
    }
    
    public void setEndRetryPayQnty(java.math.BigDecimal endRetryPayQnty) {
        this.endRetryPayQnty = endRetryPayQnty;
    }
    
    public java.math.BigDecimal getEndFreeDtyRetryPayQnty() {
        return this.endFreeDtyRetryPayQnty;
    }
    
    public void setEndFreeDtyRetryPayQnty(java.math.BigDecimal endFreeDtyRetryPayQnty) {
        this.endFreeDtyRetryPayQnty = endFreeDtyRetryPayQnty;
    }
    
    public java.math.BigDecimal getEndTxtnTgtRetryPayQnty() {
        return this.endTxtnTgtRetryPayQnty;
    }
    
    public void setEndTxtnTgtRetryPayQnty(java.math.BigDecimal endTxtnTgtRetryPayQnty) {
        this.endTxtnTgtRetryPayQnty = endTxtnTgtRetryPayQnty;
    }
    
    public java.math.BigDecimal getClutRetryPayQnty() {
        return this.clutRetryPayQnty;
    }
    
    public void setClutRetryPayQnty(java.math.BigDecimal clutRetryPayQnty) {
        this.clutRetryPayQnty = clutRetryPayQnty;
    }
    
    public java.math.BigDecimal getClutFreeDtyRetryPayQnty() {
        return this.clutFreeDtyRetryPayQnty;
    }
    
    public void setClutFreeDtyRetryPayQnty(java.math.BigDecimal clutFreeDtyRetryPayQnty) {
        this.clutFreeDtyRetryPayQnty = clutFreeDtyRetryPayQnty;
    }
    
    public java.math.BigDecimal getClutTxtnTgtRetryPayQnty() {
        return this.clutTxtnTgtRetryPayQnty;
    }
    
    public void setClutTxtnTgtRetryPayQnty(java.math.BigDecimal clutTxtnTgtRetryPayQnty) {
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
    
    public java.math.BigDecimal getCtrLogSvcMnthIcm() {
        return this.ctrLogSvcMnthIcm;
    }
    
    public void setCtrLogSvcMnthIcm(java.math.BigDecimal ctrLogSvcMnthIcm) {
        this.ctrLogSvcMnthIcm = ctrLogSvcMnthIcm;
    }
    
    public java.math.BigDecimal getCtrEepnMnthIcm() {
        return this.ctrEepnMnthIcm;
    }
    
    public void setCtrEepnMnthIcm(java.math.BigDecimal ctrEepnMnthIcm) {
        this.ctrEepnMnthIcm = ctrEepnMnthIcm;
    }
    
    public java.math.BigDecimal getCtrAddMnthIcm() {
        return this.ctrAddMnthIcm;
    }
    
    public void setCtrAddMnthIcm(java.math.BigDecimal ctrAddMnthIcm) {
        this.ctrAddMnthIcm = ctrAddMnthIcm;
    }
    
    public java.math.BigDecimal getCtrDupMnthIcm() {
        return this.ctrDupMnthIcm;
    }
    
    public void setCtrDupMnthIcm(java.math.BigDecimal ctrDupMnthIcm) {
        this.ctrDupMnthIcm = ctrDupMnthIcm;
    }
    
    public java.math.BigDecimal getCtrLogSvc() {
        return this.ctrLogSvc;
    }
    
    public void setCtrLogSvc(java.math.BigDecimal ctrLogSvc) {
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
    
    public java.math.BigDecimal getEndLogSvcMnthIcm() {
        return this.endLogSvcMnthIcm;
    }
    
    public void setEndLogSvcMnthIcm(java.math.BigDecimal endLogSvcMnthIcm) {
        this.endLogSvcMnthIcm = endLogSvcMnthIcm;
    }
    
    public java.math.BigDecimal getEndEepnMnthIcm() {
        return this.endEepnMnthIcm;
    }
    
    public void setEndEepnMnthIcm(java.math.BigDecimal endEepnMnthIcm) {
        this.endEepnMnthIcm = endEepnMnthIcm;
    }
    
    public java.math.BigDecimal getEndAddMnthIcm() {
        return this.endAddMnthIcm;
    }
    
    public void setEndAddMnthIcm(java.math.BigDecimal endAddMnthIcm) {
        this.endAddMnthIcm = endAddMnthIcm;
    }
    
    public java.math.BigDecimal getEndDupMnthIcm() {
        return this.endDupMnthIcm;
    }
    
    public void setEndDupMnthIcm(java.math.BigDecimal endDupMnthIcm) {
        this.endDupMnthIcm = endDupMnthIcm;
    }
    
    public java.math.BigDecimal getEndLogSvcYrNum() {
        return this.endLogSvcYrNum;
    }
    
    public void setEndLogSvcYrNum(java.math.BigDecimal endLogSvcYrNum) {
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
    
    public java.math.BigDecimal getClutLogSvcMnthIcm() {
        return this.clutLogSvcMnthIcm;
    }
    
    public void setClutLogSvcMnthIcm(java.math.BigDecimal clutLogSvcMnthIcm) {
        this.clutLogSvcMnthIcm = clutLogSvcMnthIcm;
    }
    
    public java.math.BigDecimal getClutEepnMnthIcm() {
        return this.clutEepnMnthIcm;
    }
    
    public void setClutEepnMnthIcm(java.math.BigDecimal clutEepnMnthIcm) {
        this.clutEepnMnthIcm = clutEepnMnthIcm;
    }
    
    public java.math.BigDecimal getClutAddMnthIcm() {
        return this.clutAddMnthIcm;
    }
    
    public void setClutAddMnthIcm(java.math.BigDecimal clutAddMnthIcm) {
        this.clutAddMnthIcm = clutAddMnthIcm;
    }
    
    public java.math.BigDecimal getClutDupMnthIcm() {
        return this.clutDupMnthIcm;
    }
    
    public void setClutDupMnthIcm(java.math.BigDecimal clutDupMnthIcm) {
        this.clutDupMnthIcm = clutDupMnthIcm;
    }
    
    public java.math.BigDecimal getClutLogSvcYrNum() {
        return this.clutLogSvcYrNum;
    }
    
    public void setClutLogSvcYrNum(java.math.BigDecimal clutLogSvcYrNum) {
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
    
    public java.math.BigDecimal getLogPpnl12befLogMnthIcm() {
        return this.logPpnl12befLogMnthIcm;
    }
    
    public void setLogPpnl12befLogMnthIcm(java.math.BigDecimal logPpnl12befLogMnthIcm) {
        this.logPpnl12befLogMnthIcm = logPpnl12befLogMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl12befEepnMnthIcm() {
        return this.logPpnl12befEepnMnthIcm;
    }
    
    public void setLogPpnl12befEepnMnthIcm(java.math.BigDecimal logPpnl12befEepnMnthIcm) {
        this.logPpnl12befEepnMnthIcm = logPpnl12befEepnMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl12befAddMnthIcm() {
        return this.logPpnl12befAddMnthIcm;
    }
    
    public void setLogPpnl12befAddMnthIcm(java.math.BigDecimal logPpnl12befAddMnthIcm) {
        this.logPpnl12befAddMnthIcm = logPpnl12befAddMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl12befDupMnthIcm() {
        return this.logPpnl12befDupMnthIcm;
    }
    
    public void setLogPpnl12befDupMnthIcm(java.math.BigDecimal logPpnl12befDupMnthIcm) {
        this.logPpnl12befDupMnthIcm = logPpnl12befDupMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl12befLogYrNum() {
        return this.logPpnl12befLogYrNum;
    }
    
    public void setLogPpnl12befLogYrNum(java.math.BigDecimal logPpnl12befLogYrNum) {
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
    
    public java.math.BigDecimal getLogPpnl13afrLogMnthIcm() {
        return this.logPpnl13afrLogMnthIcm;
    }
    
    public void setLogPpnl13afrLogMnthIcm(java.math.BigDecimal logPpnl13afrLogMnthIcm) {
        this.logPpnl13afrLogMnthIcm = logPpnl13afrLogMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl13afrEepnMnthIcm() {
        return this.logPpnl13afrEepnMnthIcm;
    }
    
    public void setLogPpnl13afrEepnMnthIcm(java.math.BigDecimal logPpnl13afrEepnMnthIcm) {
        this.logPpnl13afrEepnMnthIcm = logPpnl13afrEepnMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl13afrAddMnthIcm() {
        return this.logPpnl13afrAddMnthIcm;
    }
    
    public void setLogPpnl13afrAddMnthIcm(java.math.BigDecimal logPpnl13afrAddMnthIcm) {
        this.logPpnl13afrAddMnthIcm = logPpnl13afrAddMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl13afrDupMnthIcm() {
        return this.logPpnl13afrDupMnthIcm;
    }
    
    public void setLogPpnl13afrDupMnthIcm(java.math.BigDecimal logPpnl13afrDupMnthIcm) {
        this.logPpnl13afrDupMnthIcm = logPpnl13afrDupMnthIcm;
    }
    
    public java.math.BigDecimal getLogPpnl13afrLogSvc() {
        return this.logPpnl13afrLogSvc;
    }
    
    public void setLogPpnl13afrLogSvc(java.math.BigDecimal logPpnl13afrLogSvc) {
        this.logPpnl13afrLogSvc = logPpnl13afrLogSvc;
    }
    
    public java.math.BigDecimal getRetryIncmCtrPymtSum() {
        return this.retryIncmCtrPymtSum;
    }
    
    public void setRetryIncmCtrPymtSum(java.math.BigDecimal retryIncmCtrPymtSum) {
        this.retryIncmCtrPymtSum = retryIncmCtrPymtSum;
    }
    
    public java.math.BigDecimal getRetryIncmEndPymtSum() {
        return this.retryIncmEndPymtSum;
    }
    
    public void setRetryIncmEndPymtSum(java.math.BigDecimal retryIncmEndPymtSum) {
        this.retryIncmEndPymtSum = retryIncmEndPymtSum;
    }
    
    public java.math.BigDecimal getRetryIncmClutSum() {
        return this.retryIncmClutSum;
    }
    
    public void setRetryIncmClutSum(java.math.BigDecimal retryIncmClutSum) {
        this.retryIncmClutSum = retryIncmClutSum;
    }
    
    public java.math.BigDecimal getRetryFxrtDducClutSum() {
        return this.retryFxrtDducClutSum;
    }
    
    public void setRetryFxrtDducClutSum(java.math.BigDecimal retryFxrtDducClutSum) {
        this.retryFxrtDducClutSum = retryFxrtDducClutSum;
    }
    
    public java.math.BigDecimal getLogYrDducSum() {
        return this.logYrDducSum;
    }
    
    public void setLogYrDducSum(java.math.BigDecimal logYrDducSum) {
        this.logYrDducSum = logYrDducSum;
    }
    
    public java.math.BigDecimal getRetryTxtnStdClutSum() {
        return this.retryTxtnStdClutSum;
    }
    
    public void setRetryTxtnStdClutSum(java.math.BigDecimal retryTxtnStdClutSum) {
        this.retryTxtnStdClutSum = retryTxtnStdClutSum;
    }
    
    public java.math.BigDecimal getTat12befTxtnStdPpnlSum() {
        return this.tat12befTxtnStdPpnlSum;
    }
    
    public void setTat12befTxtnStdPpnlSum(java.math.BigDecimal tat12befTxtnStdPpnlSum) {
        this.tat12befTxtnStdPpnlSum = tat12befTxtnStdPpnlSum;
    }
    
    public java.math.BigDecimal getTat12befYravgTxstdSum() {
        return this.tat12befYravgTxstdSum;
    }
    
    public void setTat12befYravgTxstdSum(java.math.BigDecimal tat12befYravgTxstdSum) {
        this.tat12befYravgTxstdSum = tat12befYravgTxstdSum;
    }
    
    public java.math.BigDecimal getTat12befCvsnTxtnStdSum() {
        return this.tat12befCvsnTxtnStdSum;
    }
    
    public void setTat12befCvsnTxtnStdSum(java.math.BigDecimal tat12befCvsnTxtnStdSum) {
        this.tat12befCvsnTxtnStdSum = tat12befCvsnTxtnStdSum;
    }
    
    public java.math.BigDecimal getTat12befCvsnCalcAmnt() {
        return this.tat12befCvsnCalcAmnt;
    }
    
    public void setTat12befCvsnCalcAmnt(java.math.BigDecimal tat12befCvsnCalcAmnt) {
        this.tat12befCvsnCalcAmnt = tat12befCvsnCalcAmnt;
    }
    
    public java.math.BigDecimal getTat12befYrAvgCalcAmnt() {
        return this.tat12befYrAvgCalcAmnt;
    }
    
    public void setTat12befYrAvgCalcAmnt(java.math.BigDecimal tat12befYrAvgCalcAmnt) {
        this.tat12befYrAvgCalcAmnt = tat12befYrAvgCalcAmnt;
    }
    
    public java.math.BigDecimal getTat12befCalcTxAmnt() {
        return this.tat12befCalcTxAmnt;
    }
    
    public void setTat12befCalcTxAmnt(java.math.BigDecimal tat12befCalcTxAmnt) {
        this.tat12befCalcTxAmnt = tat12befCalcTxAmnt;
    }
    
    public java.math.BigDecimal getTat12befAlpayTxAmnt() {
        return this.tat12befAlpayTxAmnt;
    }
    
    public void setTat12befAlpayTxAmnt(java.math.BigDecimal tat12befAlpayTxAmnt) {
        this.tat12befAlpayTxAmnt = tat12befAlpayTxAmnt;
    }
    
    public java.math.BigDecimal getTat12befRegTgtTxAmnt() {
        return this.tat12befRegTgtTxAmnt;
    }
    
    public void setTat12befRegTgtTxAmnt(java.math.BigDecimal tat12befRegTgtTxAmnt) {
        this.tat12befRegTgtTxAmnt = tat12befRegTgtTxAmnt;
    }
    
    public java.math.BigDecimal getTat13afrTxstdPpnlSum() {
        return this.tat13afrTxstdPpnlSum;
    }
    
    public void setTat13afrTxstdPpnlSum(java.math.BigDecimal tat13afrTxstdPpnlSum) {
        this.tat13afrTxstdPpnlSum = tat13afrTxstdPpnlSum;
    }
    
    public java.math.BigDecimal getTat13afrYrAvgStdSum() {
        return this.tat13afrYrAvgStdSum;
    }
    
    public void setTat13afrYrAvgStdSum(java.math.BigDecimal tat13afrYrAvgStdSum) {
        this.tat13afrYrAvgStdSum = tat13afrYrAvgStdSum;
    }
    
    public java.math.BigDecimal getTat13afrCvsnTxtnStdSum() {
        return this.tat13afrCvsnTxtnStdSum;
    }
    
    public void setTat13afrCvsnTxtnStdSum(java.math.BigDecimal tat13afrCvsnTxtnStdSum) {
        this.tat13afrCvsnTxtnStdSum = tat13afrCvsnTxtnStdSum;
    }
    
    public java.math.BigDecimal getTat13afrCvsnCalcTxAmnt() {
        return this.tat13afrCvsnCalcTxAmnt;
    }
    
    public void setTat13afrCvsnCalcTxAmnt(java.math.BigDecimal tat13afrCvsnCalcTxAmnt) {
        this.tat13afrCvsnCalcTxAmnt = tat13afrCvsnCalcTxAmnt;
    }
    
    public java.math.BigDecimal getTat13afrYrAvgCalcAmnt() {
        return this.tat13afrYrAvgCalcAmnt;
    }
    
    public void setTat13afrYrAvgCalcAmnt(java.math.BigDecimal tat13afrYrAvgCalcAmnt) {
        this.tat13afrYrAvgCalcAmnt = tat13afrYrAvgCalcAmnt;
    }
    
    public java.math.BigDecimal getTat13afrAlpayTxAmnt() {
        return this.tat13afrAlpayTxAmnt;
    }
    
    public void setTat13afrAlpayTxAmnt(java.math.BigDecimal tat13afrAlpayTxAmnt) {
        this.tat13afrAlpayTxAmnt = tat13afrAlpayTxAmnt;
    }
    
    public java.math.BigDecimal getTat13afrRegrstTgtSum() {
        return this.tat13afrRegrstTgtSum;
    }
    
    public void setTat13afrRegrstTgtSum(java.math.BigDecimal tat13afrRegrstTgtSum) {
        this.tat13afrRegrstTgtSum = tat13afrRegrstTgtSum;
    }
    
    public java.math.BigDecimal getTatAggrTxtnStdPpnlSum() {
        return this.tatAggrTxtnStdPpnlSum;
    }
    
    public void setTatAggrTxtnStdPpnlSum(java.math.BigDecimal tatAggrTxtnStdPpnlSum) {
        this.tatAggrTxtnStdPpnlSum = tatAggrTxtnStdPpnlSum;
    }
    
    public java.math.BigDecimal getTatAggrYrAvgTxtnStdSum() {
        return this.tatAggrYrAvgTxtnStdSum;
    }
    
    public void setTatAggrYrAvgTxtnStdSum(java.math.BigDecimal tatAggrYrAvgTxtnStdSum) {
        this.tatAggrYrAvgTxtnStdSum = tatAggrYrAvgTxtnStdSum;
    }
    
    public java.math.BigDecimal getTatAggrCvsnTxtnStdSum() {
        return this.tatAggrCvsnTxtnStdSum;
    }
    
    public void setTatAggrCvsnTxtnStdSum(java.math.BigDecimal tatAggrCvsnTxtnStdSum) {
        this.tatAggrCvsnTxtnStdSum = tatAggrCvsnTxtnStdSum;
    }
    
    public java.math.BigDecimal getTatAggrCvsnCalcTxAmnt() {
        return this.tatAggrCvsnCalcTxAmnt;
    }
    
    public void setTatAggrCvsnCalcTxAmnt(java.math.BigDecimal tatAggrCvsnCalcTxAmnt) {
        this.tatAggrCvsnCalcTxAmnt = tatAggrCvsnCalcTxAmnt;
    }
    
    public java.math.BigDecimal getTatAggrYrAvgCalcTxAmnt() {
        return this.tatAggrYrAvgCalcTxAmnt;
    }
    
    public void setTatAggrYrAvgCalcTxAmnt(java.math.BigDecimal tatAggrYrAvgCalcTxAmnt) {
        this.tatAggrYrAvgCalcTxAmnt = tatAggrYrAvgCalcTxAmnt;
    }
    
    public java.math.BigDecimal getTatAggrCalcTxAmnt() {
        return this.tatAggrCalcTxAmnt;
    }
    
    public void setTatAggrCalcTxAmnt(java.math.BigDecimal tatAggrCalcTxAmnt) {
        this.tatAggrCalcTxAmnt = tatAggrCalcTxAmnt;
    }
    
    public java.math.BigDecimal getTatAggrAlpayTxAmnt() {
        return this.tatAggrAlpayTxAmnt;
    }
    
    public void setTatAggrAlpayTxAmnt(java.math.BigDecimal tatAggrAlpayTxAmnt) {
        this.tatAggrAlpayTxAmnt = tatAggrAlpayTxAmnt;
    }
    
    public java.math.BigDecimal getTatAggrRegrstTgtTxAmnt() {
        return this.tatAggrRegrstTgtTxAmnt;
    }
    
    public void setTatAggrRegrstTgtTxAmnt(java.math.BigDecimal tatAggrRegrstTgtTxAmnt) {
        this.tatAggrRegrstTgtTxAmnt = tatAggrRegrstTgtTxAmnt;
    }
    
    public java.math.BigDecimal getTalRegrstTgtTxAmnt() {
        return this.talRegrstTgtTxAmnt;
    }
    
    public void setTalRegrstTgtTxAmnt(java.math.BigDecimal talRegrstTgtTxAmnt) {
        this.talRegrstTgtTxAmnt = talRegrstTgtTxAmnt;
    }
    
    public java.math.BigDecimal getTalAccuDepitAggrSum() {
        return this.talAccuDepitAggrSum;
    }
    
    public void setTalAccuDepitAggrSum(java.math.BigDecimal talAccuDepitAggrSum) {
        this.talAccuDepitAggrSum = talAccuDepitAggrSum;
    }
    
    public java.math.BigDecimal getTalRetryPayQnty() {
        return this.talRetryPayQnty;
    }
    
    public void setTalRetryPayQnty(java.math.BigDecimal talRetryPayQnty) {
        this.talRetryPayQnty = talRetryPayQnty;
    }
    
    public java.math.BigDecimal getTalRetryIncmTxAmnt() {
        return this.talRetryIncmTxAmnt;
    }
    
    public void setTalRetryIncmTxAmnt(java.math.BigDecimal talRetryIncmTxAmnt) {
        this.talRetryIncmTxAmnt = talRetryIncmTxAmnt;
    }
    
    public java.math.BigDecimal getPymtRegTgtIncmTxQnty() {
        return this.pymtRegTgtIncmTxQnty;
    }
    
    public void setPymtRegTgtIncmTxQnty(java.math.BigDecimal pymtRegTgtIncmTxQnty) {
        this.pymtRegTgtIncmTxQnty = pymtRegTgtIncmTxQnty;
    }
    
    public java.math.BigDecimal getPymtRegTgtRgonIncmQnty() {
        return this.pymtRegTgtRgonIncmQnty;
    }
    
    public void setPymtRegTgtRgonIncmQnty(java.math.BigDecimal pymtRegTgtRgonIncmQnty) {
        this.pymtRegTgtRgonIncmQnty = pymtRegTgtRgonIncmQnty;
    }
    
    public java.math.BigDecimal getPymtRegTgtFarvilSpclQnty() {
        return this.pymtRegTgtFarvilSpclQnty;
    }
    
    public void setPymtRegTgtFarvilSpclQnty(java.math.BigDecimal pymtRegTgtFarvilSpclQnty) {
        this.pymtRegTgtFarvilSpclQnty = pymtRegTgtFarvilSpclQnty;
    }
    
    public java.math.BigDecimal getPymtRegrstTgtAggrSum() {
        return this.pymtRegrstTgtAggrSum;
    }
    
    public void setPymtRegrstTgtAggrSum(java.math.BigDecimal pymtRegrstTgtAggrSum) {
        this.pymtRegrstTgtAggrSum = pymtRegrstTgtAggrSum;
    }
    
    public java.math.BigDecimal getPymtTalcIncmTxQnty() {
        return this.pymtTalcIncmTxQnty;
    }
    
    public void setPymtTalcIncmTxQnty(java.math.BigDecimal pymtTalcIncmTxQnty) {
        this.pymtTalcIncmTxQnty = pymtTalcIncmTxQnty;
    }
    
    public java.math.BigDecimal getPymtTalcRgonIncmTxQnty() {
        return this.pymtTalcRgonIncmTxQnty;
    }
    
    public void setPymtTalcRgonIncmTxQnty(java.math.BigDecimal pymtTalcRgonIncmTxQnty) {
        this.pymtTalcRgonIncmTxQnty = pymtTalcRgonIncmTxQnty;
    }
    
    public java.math.BigDecimal getPymtTalcFarvilSpclQnty() {
        return this.pymtTalcFarvilSpclQnty;
    }
    
    public void setPymtTalcFarvilSpclQnty(java.math.BigDecimal pymtTalcFarvilSpclQnty) {
        this.pymtTalcFarvilSpclQnty = pymtTalcFarvilSpclQnty;
    }
    
    public java.math.BigDecimal getPymtTxAllcAggrSum() {
        return this.pymtTxAllcAggrSum;
    }
    
    public void setPymtTxAllcAggrSum(java.math.BigDecimal pymtTxAllcAggrSum) {
        this.pymtTxAllcAggrSum = pymtTxAllcAggrSum;
    }
    
    public java.math.BigDecimal getPymtSubtnIncmTxQnty() {
        return this.pymtSubtnIncmTxQnty;
    }
    
    public void setPymtSubtnIncmTxQnty(java.math.BigDecimal pymtSubtnIncmTxQnty) {
        this.pymtSubtnIncmTxQnty = pymtSubtnIncmTxQnty;
    }
    
    public java.math.BigDecimal getPymtSubtnRgonIncmTxQnty() {
        return this.pymtSubtnRgonIncmTxQnty;
    }
    
    public void setPymtSubtnRgonIncmTxQnty(java.math.BigDecimal pymtSubtnRgonIncmTxQnty) {
        this.pymtSubtnRgonIncmTxQnty = pymtSubtnRgonIncmTxQnty;
    }
    
    public java.math.BigDecimal getPymtSubtnFarvilSpclQnty() {
        return this.pymtSubtnFarvilSpclQnty;
    }
    
    public void setPymtSubtnFarvilSpclQnty(java.math.BigDecimal pymtSubtnFarvilSpclQnty) {
        this.pymtSubtnFarvilSpclQnty = pymtSubtnFarvilSpclQnty;
    }
    
    public java.math.BigDecimal getPymtSubtnAggrSum() {
        return this.pymtSubtnAggrSum;
    }
    
    public void setPymtSubtnAggrSum(java.math.BigDecimal pymtSubtnAggrSum) {
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
