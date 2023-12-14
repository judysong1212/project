package com.app.exterms.retirement.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Remt2400VO.java
 * @Description : Remt2400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt2400DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
    private java.lang.String calcSevePayPsnBlggYr;

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

    /** set 사업자등록번호 : busoprRgstnNum */
    private java.lang.String busoprRgstnNum;

    /** set 근무처명 : paeWorkNm */
    private java.lang.String paeWorkNm;

    /** set 퇴직급여액 : retryPayQnty */
    private java.math.BigDecimal retryPayQnty;

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    private java.math.BigDecimal freeDtyRetryPayQnty;

    /** set 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
    private java.math.BigDecimal txtnTgtRetryPayQnty;

    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;

    /** set 기산일자 : rkfcdDt */
    private java.lang.String rkfcdDt;

    /** set 퇴사일자 : rsgtnDt */
    private java.lang.String rsgtnDt;

    /** set 지급일자 : pymtDt */
    private java.lang.String pymtDt;

    /** set 근속월수 : logSvcMnthIcm */
    private java.math.BigDecimal logSvcMnthIcm;

    /** set 제외월수 : eepnMnthIcm */
    private java.math.BigDecimal eepnMnthIcm;

    /** set 가산월수 : addMnthIcm */
    private java.math.BigDecimal addMnthIcm;

    /** set 중복월수 : dupMnthIcm */
    private java.math.BigDecimal dupMnthIcm;

    /** set 근속연수 : logSvcYrNum */
    private java.math.BigDecimal logSvcYrNum;

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

    /** set 퇴직소득_지급금액 : retryIncmPymtSum */
    private java.math.BigDecimal retryIncmPymtSum;

    /** set 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
    private java.math.BigDecimal retryIncmFxrtDducSum;

    /** set 근속년수공제금액 : logYrDducSum */
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

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    private java.math.BigDecimal pymtRegTgtIncmTxQnty;

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    private java.math.BigDecimal pymtRegTgtRgonIncmQnty;

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    private java.math.BigDecimal pymtRegTgtFarvilSpclQnty;

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    private java.math.BigDecimal pymtRegrstTgtAggrSum;

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

    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getCalcSevePayPsnBlggYr() {
        return this.calcSevePayPsnBlggYr;
    }
    
    public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
        this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
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
    
    public java.lang.String getBusoprRgstnNum() {
        return this.busoprRgstnNum;
    }
    
    public void setBusoprRgstnNum(java.lang.String busoprRgstnNum) {
        this.busoprRgstnNum = busoprRgstnNum;
    }
    
    public java.lang.String getPaeWorkNm() {
        return this.paeWorkNm;
    }
    
    public void setPaeWorkNm(java.lang.String paeWorkNm) {
        this.paeWorkNm = paeWorkNm;
    }
    
    public java.math.BigDecimal getRetryPayQnty() {
        return this.retryPayQnty;
    }
    
    public void setRetryPayQnty(java.math.BigDecimal retryPayQnty) {
        this.retryPayQnty = retryPayQnty;
    }
    
    public java.math.BigDecimal getFreeDtyRetryPayQnty() {
        return this.freeDtyRetryPayQnty;
    }
    
    public void setFreeDtyRetryPayQnty(java.math.BigDecimal freeDtyRetryPayQnty) {
        this.freeDtyRetryPayQnty = freeDtyRetryPayQnty;
    }
    
    public java.math.BigDecimal getTxtnTgtRetryPayQnty() {
        return this.txtnTgtRetryPayQnty;
    }
    
    public void setTxtnTgtRetryPayQnty(java.math.BigDecimal txtnTgtRetryPayQnty) {
        this.txtnTgtRetryPayQnty = txtnTgtRetryPayQnty;
    }
    
    public java.lang.String getIcncDt() {
        return this.icncDt;
    }
    
    public void setIcncDt(java.lang.String icncDt) {
        this.icncDt = icncDt;
    }
    
    public java.lang.String getRkfcdDt() {
        return this.rkfcdDt;
    }
    
    public void setRkfcdDt(java.lang.String rkfcdDt) {
        this.rkfcdDt = rkfcdDt;
    }
    
    public java.lang.String getRsgtnDt() {
        return this.rsgtnDt;
    }
    
    public void setRsgtnDt(java.lang.String rsgtnDt) {
        this.rsgtnDt = rsgtnDt;
    }
    
    public java.lang.String getPymtDt() {
        return this.pymtDt;
    }
    
    public void setPymtDt(java.lang.String pymtDt) {
        this.pymtDt = pymtDt;
    }
    
    public java.math.BigDecimal getLogSvcMnthIcm() {
        return this.logSvcMnthIcm;
    }
    
    public void setLogSvcMnthIcm(java.math.BigDecimal logSvcMnthIcm) {
        this.logSvcMnthIcm = logSvcMnthIcm;
    }
    
    public java.math.BigDecimal getEepnMnthIcm() {
        return this.eepnMnthIcm;
    }
    
    public void setEepnMnthIcm(java.math.BigDecimal eepnMnthIcm) {
        this.eepnMnthIcm = eepnMnthIcm;
    }
    
    public java.math.BigDecimal getAddMnthIcm() {
        return this.addMnthIcm;
    }
    
    public void setAddMnthIcm(java.math.BigDecimal addMnthIcm) {
        this.addMnthIcm = addMnthIcm;
    }
    
    public java.math.BigDecimal getDupMnthIcm() {
        return this.dupMnthIcm;
    }
    
    public void setDupMnthIcm(java.math.BigDecimal dupMnthIcm) {
        this.dupMnthIcm = dupMnthIcm;
    }
    
    public java.math.BigDecimal getLogSvcYrNum() {
        return this.logSvcYrNum;
    }
    
    public void setLogSvcYrNum(java.math.BigDecimal logSvcYrNum) {
        this.logSvcYrNum = logSvcYrNum;
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
    
    public java.math.BigDecimal getRetryIncmPymtSum() {
        return this.retryIncmPymtSum;
    }
    
    public void setRetryIncmPymtSum(java.math.BigDecimal retryIncmPymtSum) {
        this.retryIncmPymtSum = retryIncmPymtSum;
    }
    
    public java.math.BigDecimal getRetryIncmFxrtDducSum() {
        return this.retryIncmFxrtDducSum;
    }
    
    public void setRetryIncmFxrtDducSum(java.math.BigDecimal retryIncmFxrtDducSum) {
        this.retryIncmFxrtDducSum = retryIncmFxrtDducSum;
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
