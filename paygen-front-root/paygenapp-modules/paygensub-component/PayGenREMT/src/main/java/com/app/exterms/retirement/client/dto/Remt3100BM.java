package com.app.exterms.retirement.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
    public static final String ATTR_CALCSEVEPSNBLGGYRMNTH = "calcSevePsnBlggYrMnth";
    
    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set 소득자임원여부 : aimenrEcteYn */
    public static final String ATTR_AIMENRECTEYN = "aimenrEcteYn";
    

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    
/** set 확정급여형가입일자 : fixPayJnDt */
public static final String ATTR_FIXPAYJNDT = "fixPayJnDt";

/** set 퇴직금_20111231금액 : sevePay20111231Sum */
public static final String ATTR_SEVEPAY20111231SUM = "sevePay20111231Sum";


    /** set 외국인구분코드 : frgnrDivCd */
    public static final String ATTR_FRGNRDIVCD = "frgnrDivCd";

    /** set 거주구분여부 : ridnSeptYn */
    public static final String ATTR_RIDNSEPTYN = "ridnSeptYn";

    /** set 거주지국코드 : ridnCd */
    public static final String ATTR_RIDNCD = "ridnCd";

    /** set 거주지국명 : ridnNm */
    public static final String ATTR_RIDNNM = "ridnNm";

    /** set 귀속년도시작일자 : blggYrBgnnDt */
    public static final String ATTR_BLGGYRBGNNDT = "blggYrBgnnDt";

    /** set 귀속년도종료일자 : blggYrEndDt */
    public static final String ATTR_BLGGYRENDDT = "blggYrEndDt";

    /** set 퇴직사유코드 : retryReasCd */
    public static final String ATTR_RETRYREASCD = "retryReasCd";

    /** set 중_사업자등록번호 : ctrBusoprRgstnNum */
    public static final String ATTR_CTRBUSOPRRGSTNNUM = "ctrBusoprRgstnNum";

    /** set 중_근무처명 : ctrPaeWorkNm */
    public static final String ATTR_CTRPAEWORKNM = "ctrPaeWorkNm";

    /** set 중_퇴직급여액 : ctrRetryPayQnty */
    public static final String ATTR_CTRRETRYPAYQNTY = "ctrRetryPayQnty";

    /** set 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
    public static final String ATTR_CTRFREEDTYRETRYPAYQNTY = "ctrFreeDtyRetryPayQnty";

    /** set 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
    public static final String ATTR_CTRTXTNTGTRETRYPAYQNTY = "ctrTxtnTgtRetryPayQnty";

    /** set 종_사업자등록번호 : endBusoprRgstnNum */
    public static final String ATTR_ENDBUSOPRRGSTNNUM = "endBusoprRgstnNum";

    /** set 종_근무처명 : endPaeWorkNm */
    public static final String ATTR_ENDPAEWORKNM = "endPaeWorkNm";

    /** set 종_퇴직급여액 : endRetryPayQnty */
    public static final String ATTR_ENDRETRYPAYQNTY = "endRetryPayQnty";

    /** set 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
    public static final String ATTR_ENDFREEDTYRETRYPAYQNTY = "endFreeDtyRetryPayQnty";

    /** set 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
    public static final String ATTR_ENDTXTNTGTRETRYPAYQNTY = "endTxtnTgtRetryPayQnty";

    /** set 정산_퇴직급여액 : clutRetryPayQnty */
    public static final String ATTR_CLUTRETRYPAYQNTY = "clutRetryPayQnty";

    /** set 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
    public static final String ATTR_CLUTFREEDTYRETRYPAYQNTY = "clutFreeDtyRetryPayQnty";

    /** set 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
    public static final String ATTR_CLUTTXTNTGTRETRYPAYQNTY = "clutTxtnTgtRetryPayQnty";

    /** set 중_입사일자 : ctrIcncDt */
    public static final String ATTR_CTRICNCDT = "ctrIcncDt";

    /** set 중_기산일자 : ctrRkfcdDt */
    public static final String ATTR_CTRRKFCDDT = "ctrRkfcdDt";

    /** set 중_퇴사일자 : ctrRsgtnDt */
    public static final String ATTR_CTRRSGTNDT = "ctrRsgtnDt";

    /** set 중_지급일자 : ctrPymtDt */
    public static final String ATTR_CTRPYMTDT = "ctrPymtDt";

    /** set 중_근속월수 : ctrLogSvcMnthIcm */
    public static final String ATTR_CTRLOGSVCMNTHICM = "ctrLogSvcMnthIcm";

    /** set 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
    public static final String ATTR_CTREEPNMNTH12BFR = "ctrEepnMnth12Bfr";

    /** set 중_제외월수_2013이후 : ctrEepnMnth13Aft */
    public static final String ATTR_CTREEPNMNTH13AFT = "ctrEepnMnth13Aft";

    /** set 중_가산월수_2012이전 : ctrAddMnth12Bfr */
    public static final String ATTR_CTRADDMNTH12BFR = "ctrAddMnth12Bfr";

    /** set 중_가산월수_2013이후 : ctrAddMnth13Aft */
    public static final String ATTR_CTRADDMNTH13AFT = "ctrAddMnth13Aft";

    /** set 중_제외월수 : ctrEepnMnthIcm */
    public static final String ATTR_CTREEPNMNTHICM = "ctrEepnMnthIcm";

    /** set 중_가산월수 : ctrAddMnthIcm */
    public static final String ATTR_CTRADDMNTHICM = "ctrAddMnthIcm";

    /** set 중_중복월수 : ctrDupMnthIcm */
    public static final String ATTR_CTRDUPMNTHICM = "ctrDupMnthIcm";

    /** set 중_근속연수 : ctrLogSvc */
    public static final String ATTR_CTRLOGSVC = "ctrLogSvc";

    /** set 종_입사일자 : endIcncDt */
    public static final String ATTR_ENDICNCDT = "endIcncDt";

    /** set 종_기산일자 : endRkfcdDt */
    public static final String ATTR_ENDRKFCDDT = "endRkfcdDt";

    /** set 종_퇴사일자 : endRsgtnDt */
    public static final String ATTR_ENDRSGTNDT = "endRsgtnDt";

    /** set 종_지급일자 : endPymtDt */
    public static final String ATTR_ENDPYMTDT = "endPymtDt";

    /** set 종_근속월수 : endLogSvcMnthIcm */
    public static final String ATTR_ENDLOGSVCMNTHICM = "endLogSvcMnthIcm";

    /** set 종_제외월수_2012이전 : endEepnMnth12Bfr */
    public static final String ATTR_ENDEEPNMNTH12BFR = "endEepnMnth12Bfr";

    /** set 종_제외월수_2013이후 : endEepnMnth13Aft */
    public static final String ATTR_ENDEEPNMNTH13AFT = "endEepnMnth13Aft";

    /** set 종_가산월수_2012이전 : endAddMnth12Bfr */
    public static final String ATTR_ENDADDMNTH12BFR = "endAddMnth12Bfr";

    /** set 종_가산월수_2013이후 : endAddMnth13Aft */
    public static final String ATTR_ENDADDMNTH13AFT = "endAddMnth13Aft";

    /** set 종_제외월수 : endEepnMnthIcm */
    public static final String ATTR_ENDEEPNMNTHICM = "endEepnMnthIcm";

    /** set 종_가산월수 : endAddMnthIcm */
    public static final String ATTR_ENDADDMNTHICM = "endAddMnthIcm";

    /** set 종_중복월수 : endDupMnthIcm */
    public static final String ATTR_ENDDUPMNTHICM = "endDupMnthIcm";

    /** set 종_근속연수 : endLogSvcYrNum */
    public static final String ATTR_ENDLOGSVCYRNUM = "endLogSvcYrNum";

    /** set 정산_입사일자 : clutIcncDt */
    public static final String ATTR_CLUTICNCDT = "clutIcncDt";

    /** set 정산-기산일자 : clutRkfcdDt */
    public static final String ATTR_CLUTRKFCDDT = "clutRkfcdDt";

    /** set 정산_퇴사일자 : clutRsgtnDt */
    public static final String ATTR_CLUTRSGTNDT = "clutRsgtnDt";

    /** set 정산_지급일자 : clutPymtDt */
    public static final String ATTR_CLUTPYMTDT = "clutPymtDt";

    /** set 정산_근속월수 : clutLogSvcMnthIcm */
    public static final String ATTR_CLUTLOGSVCMNTHICM = "clutLogSvcMnthIcm";

    /** set 정산_제외월수 : clutEepnMnthIcm */
    public static final String ATTR_CLUTEEPNMNTHICM = "clutEepnMnthIcm";

    /** set 정산_가산월수 : clutAddMnthIcm */
    public static final String ATTR_CLUTADDMNTHICM = "clutAddMnthIcm";

    /** set 정산_중복월수 : clutDupMnthIcm */
    public static final String ATTR_CLUTDUPMNTHICM = "clutDupMnthIcm";

    /** set 정산_근속연수 : clutLogSvcYrNum */
    public static final String ATTR_CLUTLOGSVCYRNUM = "clutLogSvcYrNum";

    /** set 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
    public static final String ATTR_LOGPPNL12BEFICNCDT = "logPpnl12befIcncDt";

    /** set 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
    public static final String ATTR_LOGPPNL12BEFRKFCDDT = "logPpnl12befRkfcdDt";

    /** set 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
    public static final String ATTR_LOGPPNL12BEFRSGTNDT = "logPpnl12befRsgtnDt";

    /** set 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
    public static final String ATTR_LOGPPNL12BEFPYMTDT = "logPpnl12befPymtDt";

    /** set 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
    public static final String ATTR_LOGPPNL12BEFLOGMNTHICM = "logPpnl12befLogMnthIcm";

    /** set 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
    public static final String ATTR_LOGPPNL12BEFEEPNMNTHICM = "logPpnl12befEepnMnthIcm";

    /** set 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
    public static final String ATTR_LOGPPNL12BEFADDMNTHICM = "logPpnl12befAddMnthIcm";

    /** set 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
    public static final String ATTR_LOGPPNL12BEFDUPMNTHICM = "logPpnl12befDupMnthIcm";

    /** set 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    public static final String ATTR_LOGPPNL12BEFLOGYRNUM = "logPpnl12befLogYrNum";

    /** set 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
    public static final String ATTR_LOGPPNL13AFRICNCDT = "logPpnl13afrIcncDt";

    /** set 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
    public static final String ATTR_LOGPPNL13AFRRKFCDDT = "logPpnl13afrRkfcdDt";

    /** set 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
    public static final String ATTR_LOGPPNL13AFRRSGTNDT = "logPpnl13afrRsgtnDt";

    /** set 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
    public static final String ATTR_LOGPPNL13AFRPYMTDT = "logPpnl13afrPymtDt";

    /** set 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
    public static final String ATTR_LOGPPNL13AFRLOGMNTHICM = "logPpnl13afrLogMnthIcm";

    /** set 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
    public static final String ATTR_LOGPPNL13AFREEPNMNTHICM = "logPpnl13afrEepnMnthIcm";

    /** set 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
    public static final String ATTR_LOGPPNL13AFRADDMNTHICM = "logPpnl13afrAddMnthIcm";

    /** set 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
    public static final String ATTR_LOGPPNL13AFRDUPMNTHICM = "logPpnl13afrDupMnthIcm";

    /** set 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    public static final String ATTR_LOGPPNL13AFRLOGSVC = "logPpnl13afrLogSvc";

    /** set 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
    public static final String ATTR_RETRYINCMCTRPYMTSUM = "retryIncmCtrPymtSum";

    /** set 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
    public static final String ATTR_RETRYINCMENDPYMTSUM = "retryIncmEndPymtSum";

    /** set 퇴직소득_정산금액 : retryIncmClutSum */
    public static final String ATTR_RETRYINCMCLUTSUM = "retryIncmClutSum";

    /** set 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
    public static final String ATTR_RETRYFXRTDDUCCLUTSUM = "retryFxrtDducClutSum";

    /** set 근속년수공제_정산금액 : logYrDducSum */
    public static final String ATTR_LOGYRDDUCSUM = "logYrDducSum";

    /** set 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    public static final String ATTR_RETRYTXTNSTDCLUTSUM = "retryTxtnStdClutSum";

    /** set 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    public static final String ATTR_TAT12BEFTXTNSTDPPNLSUM = "tat12befTxtnStdPpnlSum";

    /** set 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    public static final String ATTR_TAT12BEFYRAVGTXSTDSUM = "tat12befYravgTxstdSum";

    /** set 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    public static final String ATTR_TAT12BEFCVSNTXTNSTDSUM = "tat12befCvsnTxtnStdSum";

    /** set 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    public static final String ATTR_TAT12BEFCVSNCALCAMNT = "tat12befCvsnCalcAmnt";

    /** set 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    public static final String ATTR_TAT12BEFYRAVGCALCAMNT = "tat12befYrAvgCalcAmnt";

    /** set 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    public static final String ATTR_TAT12BEFCALCTXAMNT = "tat12befCalcTxAmnt";

    /** set 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    public static final String ATTR_TAT12BEFALPAYTXAMNT = "tat12befAlpayTxAmnt";

    /** set 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    public static final String ATTR_TAT12BEFREGTGTTXAMNT = "tat12befRegTgtTxAmnt";

    /** set 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    public static final String ATTR_TAT13AFRTXSTDPPNLSUM = "tat13afrTxstdPpnlSum";

    /** set 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    public static final String ATTR_TAT13AFRYRAVGSTDSUM = "tat13afrYrAvgStdSum";

    /** set 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    public static final String ATTR_TAT13AFRCVSNTXTNSTDSUM = "tat13afrCvsnTxtnStdSum";

    /** set 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    public static final String ATTR_TAT13AFRCVSNCALCTXAMNT = "tat13afrCvsnCalcTxAmnt";

    /** set 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    public static final String ATTR_TAT13AFRYRAVGCALCAMNT = "tat13afrYrAvgCalcAmnt";

    /** set 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
    public static final String ATTR_TAT13AFRCALCTXAMNT = "tat13afrCalcTxAmnt";

    /** set 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    public static final String ATTR_TAT13AFRALPAYTXAMNT = "tat13afrAlpayTxAmnt";

    /** set 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    public static final String ATTR_TAT13AFRREGRSTTGTSUM = "tat13afrRegrstTgtSum";

    /** set 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    public static final String ATTR_TATAGGRTXTNSTDPPNLSUM = "tatAggrTxtnStdPpnlSum";

    /** set 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    public static final String ATTR_TATAGGRYRAVGTXTNSTDSUM = "tatAggrYrAvgTxtnStdSum";

    /** set 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    public static final String ATTR_TATAGGRCVSNTXTNSTDSUM = "tatAggrCvsnTxtnStdSum";

    /** set 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    public static final String ATTR_TATAGGRCVSNCALCTXAMNT = "tatAggrCvsnCalcTxAmnt";

    /** set 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    public static final String ATTR_TATAGGRYRAVGCALCTXAMNT = "tatAggrYrAvgCalcTxAmnt";

    /** set 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    public static final String ATTR_TATAGGRCALCTXAMNT = "tatAggrCalcTxAmnt";

    /** set 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    public static final String ATTR_TATAGGRALPAYTXAMNT = "tatAggrAlpayTxAmnt";

    /** set 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    public static final String ATTR_TATAGGRREGRSTTGTTXAMNT = "tatAggrRegrstTgtTxAmnt";

    /** set 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
    public static final String ATTR_TALREGRSTTGTTXAMNT = "talRegrstTgtTxAmnt";

    /** set 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
    public static final String ATTR_TALACCUDEPITAGGRSUM = "talAccuDepitAggrSum";

    /** set 이연세액_퇴직급여액 : talRetryPayQnty */
    public static final String ATTR_TALRETRYPAYQNTY = "talRetryPayQnty";

    /** set 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
    public static final String ATTR_TALRETRYINCMTXAMNT = "talRetryIncmTxAmnt";

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    public static final String ATTR_PYMTREGTGTINCMTXQNTY = "pymtRegTgtIncmTxQnty";

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    public static final String ATTR_PYMTREGTGTRGONINCMQNTY = "pymtRegTgtRgonIncmQnty";

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    public static final String ATTR_PYMTREGTGTFARVILSPCLQNTY = "pymtRegTgtFarvilSpclQnty";

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    public static final String ATTR_PYMTREGRSTTGTAGGRSUM = "pymtRegrstTgtAggrSum";

    /** set 납부이연_소득세액 : pymtTalcIncmTxQnty */
    public static final String ATTR_PYMTTALCINCMTXQNTY = "pymtTalcIncmTxQnty";

    /** set 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
    public static final String ATTR_PYMTTALCRGONINCMTXQNTY = "pymtTalcRgonIncmTxQnty";

    /** set 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
    public static final String ATTR_PYMTTALCFARVILSPCLQNTY = "pymtTalcFarvilSpclQnty";

    /** set 납부이연_합계금액 : pymtTxAllcAggrSum */
    public static final String ATTR_PYMTTXALLCAGGRSUM = "pymtTxAllcAggrSum";

    /** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
    public static final String ATTR_PYMTSUBTNINCMTXQNTY = "pymtSubtnIncmTxQnty";

    /** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
    public static final String ATTR_PYMTSUBTNRGONINCMTXQNTY = "pymtSubtnRgonIncmTxQnty";

    /** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
    public static final String ATTR_PYMTSUBTNFARVILSPCLQNTY = "pymtSubtnFarvilSpclQnty";

    /** set 납부차감_합계금액 : pymtSubtnAggrSum */
    public static final String ATTR_PYMTSUBTNAGGRSUM = "pymtSubtnAggrSum";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    
    
    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
 

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
    
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
     
    
    /** set 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public static final String ATTR_CALCSEVEPAYPSNDIVNM = "calcSevePayPsnDivNm";
    
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    
    
/** set 직종세통합코드 : dtilOccuInttnCd */
public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
 

    /** 생성자 */
     public Remt3100BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt3100BM(
    		 String  dpobCd 
    		, String  clutYrMnth 
    		, String  calcSevePayPsnDivCd 
    		, String  systemkey 
    		, String  deptCd 
    		, String  hanNm 
    		, String  resnRegnNum 
    		, String  aimenrEcteYn 
    		, String  frgnrDivCd 
    		, String  ridnSeptYn 
    		, String  ridnCd 
    		, String  ridnNm 
    		, String  blggYrBgnnDt 
    		, String  blggYrEndDt 
    		, String  retryReasCd 
    		, String  ctrBusoprRgstnNum 
    		, String  ctrPaeWorkNm 
    		, Long  ctrRetryPayQnty 
    		, Long  ctrFreeDtyRetryPayQnty 
    		, Long  ctrTxtnTgtRetryPayQnty 
    		, String  endBusoprRgstnNum 
    		, String  endPaeWorkNm 
    		, Long  endRetryPayQnty 
    		, Long  endFreeDtyRetryPayQnty 
    		, Long  endTxtnTgtRetryPayQnty 
    		, Long  clutRetryPayQnty 
    		, Long  clutFreeDtyRetryPayQnty 
    		, Long  clutTxtnTgtRetryPayQnty 
    		, String  ctrIcncDt 
    		, String  ctrRkfcdDt 
    		, String  ctrRsgtnDt 
    		, String  ctrPymtDt 
    		, Long  ctrLogSvcMnthIcm 
    		, Long  ctrEepnMnthIcm 
    		, Long  ctrAddMnthIcm 
    		, Long  ctrDupMnthIcm 
    		, Long  ctrLogSvc 
    		, String  endIcncDt 
    		, String  endRkfcdDt 
    		, String  endRsgtnDt 
    		, String  endPymtDt 
    		, Long  endLogSvcMnthIcm 
    		, Long  endEepnMnthIcm 
    		, Long  endAddMnthIcm 
    		, Long  endDupMnthIcm 
    		, Long  endLogSvcYrNum 
    		, String  clutIcncDt 
    		, String  clutRkfcdDt 
    		, String  clutRsgtnDt 
    		, String  clutPymtDt 
    		, Long  clutLogSvcMnthIcm 
    		, Long  clutEepnMnthIcm 
    		, Long  clutAddMnthIcm 
    		, Long  clutDupMnthIcm 
    		, Long  clutLogSvcYrNum 
    		, String  logPpnl12befIcncDt 
    		, String  logPpnl12befRkfcdDt 
    		, String  logPpnl12befRsgtnDt 
    		, String  logPpnl12befPymtDt 
    		, Long  logPpnl12befLogMnthIcm 
    		, Long  logPpnl12befEepnMnthIcm 
    		, Long  logPpnl12befAddMnthIcm 
    		, Long  logPpnl12befDupMnthIcm 
    		, Long  logPpnl12befLogYrNum 
    		, String  logPpnl13afrIcncDt 
    		, String  logPpnl13afrRkfcdDt 
    		, String  logPpnl13afrRsgtnDt 
    		, String  logPpnl13afrPymtDt 
    		, Long  logPpnl13afrLogMnthIcm 
    		, Long  logPpnl13afrEepnMnthIcm 
    		, Long  logPpnl13afrAddMnthIcm 
    		, Long  logPpnl13afrDupMnthIcm 
    		, Long  logPpnl13afrLogSvc 
    		, Long  retryIncmCtrPymtSum 
    		, Long  retryIncmEndPymtSum 
    		, Long  retryIncmClutSum 
    		, Long  retryFxrtDducClutSum 
    		, Long  logYrDducSum 
    		, Long  retryTxtnStdClutSum 
    		, Long  tat12befTxtnStdPpnlSum 
    		, Long  tat12befYravgTxstdSum 
    		, Long  tat12befCvsnTxtnStdSum 
    		, Long  tat12befCvsnCalcAmnt 
    		, Long  tat12befYrAvgCalcAmnt 
    		, Long  tat12befCalcTxAmnt 
    		, Long  tat12befAlpayTxAmnt 
    		, Long  tat12befRegTgtTxAmnt 
    		, Long  tat13afrTxstdPpnlSum 
    		, Long  tat13afrYrAvgStdSum 
    		, Long  tat13afrCvsnTxtnStdSum 
    		, Long  tat13afrCvsnCalcTxAmnt 
    		, Long  tat13afrYrAvgCalcAmnt 
    		, Long  tat13afrCalcTxAmnt 
    		, Long  tat13afrAlpayTxAmnt 
    		, Long  tat13afrRegrstTgtSum 
    		, Long  tatAggrTxtnStdPpnlSum 
    		, Long  tatAggrYrAvgTxtnStdSum 
    		, Long  tatAggrCvsnTxtnStdSum 
    		, Long  tatAggrCvsnCalcTxAmnt 
    		, Long  tatAggrYrAvgCalcTxAmnt 
    		, Long  tatAggrCalcTxAmnt 
    		, Long  tatAggrAlpayTxAmnt 
    		, Long  tatAggrRegrstTgtTxAmnt 
    		, Long  talRegrstTgtTxAmnt 
    		, Long  talAccuDepitAggrSum 
    		, Long  talRetryPayQnty 
    		, Long  talRetryIncmTxAmnt 
    		, Long  pymtRegTgtIncmTxQnty 
    		, Long  pymtRegTgtRgonIncmQnty 
    		, Long  pymtRegTgtFarvilSpclQnty 
    		, Long  pymtRegrstTgtAggrSum 
    		, Long  pymtTalcIncmTxQnty 
    		, Long  pymtTalcRgonIncmTxQnty 
    		, Long  pymtTalcFarvilSpclQnty 
    		, Long  pymtTxAllcAggrSum 
    		, Long  pymtSubtnIncmTxQnty 
    		, Long  pymtSubtnRgonIncmTxQnty 
    		, Long  pymtSubtnFarvilSpclQnty 
    		, Long  pymtSubtnAggrSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
     	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_HANNM,hanNm);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum);
     	values.put(ATTR_AIMENRECTEYN,aimenrEcteYn);
     	values.put(ATTR_FRGNRDIVCD,frgnrDivCd);
     	values.put(ATTR_RIDNSEPTYN,ridnSeptYn);
     	values.put(ATTR_RIDNCD,ridnCd);
     	values.put(ATTR_RIDNNM,ridnNm);
     	values.put(ATTR_BLGGYRBGNNDT,blggYrBgnnDt);
     	values.put(ATTR_BLGGYRENDDT,blggYrEndDt);
     	values.put(ATTR_RETRYREASCD,retryReasCd);
     	values.put(ATTR_CTRBUSOPRRGSTNNUM,ctrBusoprRgstnNum);
     	values.put(ATTR_CTRPAEWORKNM,ctrPaeWorkNm);
     	values.put(ATTR_CTRRETRYPAYQNTY,ctrRetryPayQnty);
     	values.put(ATTR_CTRFREEDTYRETRYPAYQNTY,ctrFreeDtyRetryPayQnty);
     	values.put(ATTR_CTRTXTNTGTRETRYPAYQNTY,ctrTxtnTgtRetryPayQnty);
     	values.put(ATTR_ENDBUSOPRRGSTNNUM,endBusoprRgstnNum);
     	values.put(ATTR_ENDPAEWORKNM,endPaeWorkNm);
     	values.put(ATTR_ENDRETRYPAYQNTY,endRetryPayQnty);
     	values.put(ATTR_ENDFREEDTYRETRYPAYQNTY,endFreeDtyRetryPayQnty);
     	values.put(ATTR_ENDTXTNTGTRETRYPAYQNTY,endTxtnTgtRetryPayQnty);
     	values.put(ATTR_CLUTRETRYPAYQNTY,clutRetryPayQnty);
     	values.put(ATTR_CLUTFREEDTYRETRYPAYQNTY,clutFreeDtyRetryPayQnty);
     	values.put(ATTR_CLUTTXTNTGTRETRYPAYQNTY,clutTxtnTgtRetryPayQnty);
     	values.put(ATTR_CTRICNCDT,ctrIcncDt);
     	values.put(ATTR_CTRRKFCDDT,ctrRkfcdDt);
     	values.put(ATTR_CTRRSGTNDT,ctrRsgtnDt);
     	values.put(ATTR_CTRPYMTDT,ctrPymtDt);
     	values.put(ATTR_CTRLOGSVCMNTHICM,ctrLogSvcMnthIcm);
     	values.put(ATTR_CTREEPNMNTHICM,ctrEepnMnthIcm);
     	values.put(ATTR_CTRADDMNTHICM,ctrAddMnthIcm);
     	values.put(ATTR_CTRDUPMNTHICM,ctrDupMnthIcm);
     	values.put(ATTR_CTRLOGSVC,ctrLogSvc);
     	values.put(ATTR_ENDICNCDT,endIcncDt);
     	values.put(ATTR_ENDRKFCDDT,endRkfcdDt);
     	values.put(ATTR_ENDRSGTNDT,endRsgtnDt);
     	values.put(ATTR_ENDPYMTDT,endPymtDt);
     	values.put(ATTR_ENDLOGSVCMNTHICM,endLogSvcMnthIcm);
     	values.put(ATTR_ENDEEPNMNTHICM,endEepnMnthIcm);
     	values.put(ATTR_ENDADDMNTHICM,endAddMnthIcm);
     	values.put(ATTR_ENDDUPMNTHICM,endDupMnthIcm);
     	values.put(ATTR_ENDLOGSVCYRNUM,endLogSvcYrNum);
     	values.put(ATTR_CLUTICNCDT,clutIcncDt);
     	values.put(ATTR_CLUTRKFCDDT,clutRkfcdDt);
     	values.put(ATTR_CLUTRSGTNDT,clutRsgtnDt);
     	values.put(ATTR_CLUTPYMTDT,clutPymtDt);
     	values.put(ATTR_CLUTLOGSVCMNTHICM,clutLogSvcMnthIcm);
     	values.put(ATTR_CLUTEEPNMNTHICM,clutEepnMnthIcm);
     	values.put(ATTR_CLUTADDMNTHICM,clutAddMnthIcm);
     	values.put(ATTR_CLUTDUPMNTHICM,clutDupMnthIcm);
     	values.put(ATTR_CLUTLOGSVCYRNUM,clutLogSvcYrNum);
     	values.put(ATTR_LOGPPNL12BEFICNCDT,logPpnl12befIcncDt);
     	values.put(ATTR_LOGPPNL12BEFRKFCDDT,logPpnl12befRkfcdDt);
     	values.put(ATTR_LOGPPNL12BEFRSGTNDT,logPpnl12befRsgtnDt);
     	values.put(ATTR_LOGPPNL12BEFPYMTDT,logPpnl12befPymtDt);
     	values.put(ATTR_LOGPPNL12BEFLOGMNTHICM,logPpnl12befLogMnthIcm);
     	values.put(ATTR_LOGPPNL12BEFEEPNMNTHICM,logPpnl12befEepnMnthIcm);
     	values.put(ATTR_LOGPPNL12BEFADDMNTHICM,logPpnl12befAddMnthIcm);
     	values.put(ATTR_LOGPPNL12BEFDUPMNTHICM,logPpnl12befDupMnthIcm);
     	values.put(ATTR_LOGPPNL12BEFLOGYRNUM,logPpnl12befLogYrNum);
     	values.put(ATTR_LOGPPNL13AFRICNCDT,logPpnl13afrIcncDt);
     	values.put(ATTR_LOGPPNL13AFRRKFCDDT,logPpnl13afrRkfcdDt);
     	values.put(ATTR_LOGPPNL13AFRRSGTNDT,logPpnl13afrRsgtnDt);
     	values.put(ATTR_LOGPPNL13AFRPYMTDT,logPpnl13afrPymtDt);
     	values.put(ATTR_LOGPPNL13AFRLOGMNTHICM,logPpnl13afrLogMnthIcm);
     	values.put(ATTR_LOGPPNL13AFREEPNMNTHICM,logPpnl13afrEepnMnthIcm);
     	values.put(ATTR_LOGPPNL13AFRADDMNTHICM,logPpnl13afrAddMnthIcm);
     	values.put(ATTR_LOGPPNL13AFRDUPMNTHICM,logPpnl13afrDupMnthIcm);
     	values.put(ATTR_LOGPPNL13AFRLOGSVC,logPpnl13afrLogSvc);
     	values.put(ATTR_RETRYINCMCTRPYMTSUM,retryIncmCtrPymtSum);
     	values.put(ATTR_RETRYINCMENDPYMTSUM,retryIncmEndPymtSum);
     	values.put(ATTR_RETRYINCMCLUTSUM,retryIncmClutSum);
     	values.put(ATTR_RETRYFXRTDDUCCLUTSUM,retryFxrtDducClutSum);
     	values.put(ATTR_LOGYRDDUCSUM,logYrDducSum);
     	values.put(ATTR_RETRYTXTNSTDCLUTSUM,retryTxtnStdClutSum);
     	values.put(ATTR_TAT12BEFTXTNSTDPPNLSUM,tat12befTxtnStdPpnlSum);
     	values.put(ATTR_TAT12BEFYRAVGTXSTDSUM,tat12befYravgTxstdSum);
     	values.put(ATTR_TAT12BEFCVSNTXTNSTDSUM,tat12befCvsnTxtnStdSum);
     	values.put(ATTR_TAT12BEFCVSNCALCAMNT,tat12befCvsnCalcAmnt);
     	values.put(ATTR_TAT12BEFYRAVGCALCAMNT,tat12befYrAvgCalcAmnt);
     	values.put(ATTR_TAT12BEFCALCTXAMNT,tat12befCalcTxAmnt);
     	values.put(ATTR_TAT12BEFALPAYTXAMNT,tat12befAlpayTxAmnt);
     	values.put(ATTR_TAT12BEFREGTGTTXAMNT,tat12befRegTgtTxAmnt);
     	values.put(ATTR_TAT13AFRTXSTDPPNLSUM,tat13afrTxstdPpnlSum);
     	values.put(ATTR_TAT13AFRYRAVGSTDSUM,tat13afrYrAvgStdSum);
     	values.put(ATTR_TAT13AFRCVSNTXTNSTDSUM,tat13afrCvsnTxtnStdSum);
     	values.put(ATTR_TAT13AFRCVSNCALCTXAMNT,tat13afrCvsnCalcTxAmnt);
     	values.put(ATTR_TAT13AFRYRAVGCALCAMNT,tat13afrYrAvgCalcAmnt);
     	values.put(ATTR_TAT13AFRCALCTXAMNT,tat13afrCalcTxAmnt);
     	values.put(ATTR_TAT13AFRALPAYTXAMNT,tat13afrAlpayTxAmnt);
     	values.put(ATTR_TAT13AFRREGRSTTGTSUM,tat13afrRegrstTgtSum);
     	values.put(ATTR_TATAGGRTXTNSTDPPNLSUM,tatAggrTxtnStdPpnlSum);
     	values.put(ATTR_TATAGGRYRAVGTXTNSTDSUM,tatAggrYrAvgTxtnStdSum);
     	values.put(ATTR_TATAGGRCVSNTXTNSTDSUM,tatAggrCvsnTxtnStdSum);
     	values.put(ATTR_TATAGGRCVSNCALCTXAMNT,tatAggrCvsnCalcTxAmnt);
     	values.put(ATTR_TATAGGRYRAVGCALCTXAMNT,tatAggrYrAvgCalcTxAmnt);
     	values.put(ATTR_TATAGGRCALCTXAMNT,tatAggrCalcTxAmnt);
     	values.put(ATTR_TATAGGRALPAYTXAMNT,tatAggrAlpayTxAmnt);
     	values.put(ATTR_TATAGGRREGRSTTGTTXAMNT,tatAggrRegrstTgtTxAmnt);
     	values.put(ATTR_TALREGRSTTGTTXAMNT,talRegrstTgtTxAmnt);
     	values.put(ATTR_TALACCUDEPITAGGRSUM,talAccuDepitAggrSum);
     	values.put(ATTR_TALRETRYPAYQNTY,talRetryPayQnty);
     	values.put(ATTR_TALRETRYINCMTXAMNT,talRetryIncmTxAmnt);
     	values.put(ATTR_PYMTREGTGTINCMTXQNTY,pymtRegTgtIncmTxQnty);
     	values.put(ATTR_PYMTREGTGTRGONINCMQNTY,pymtRegTgtRgonIncmQnty);
     	values.put(ATTR_PYMTREGTGTFARVILSPCLQNTY,pymtRegTgtFarvilSpclQnty);
     	values.put(ATTR_PYMTREGRSTTGTAGGRSUM,pymtRegrstTgtAggrSum);
     	values.put(ATTR_PYMTTALCINCMTXQNTY,pymtTalcIncmTxQnty);
     	values.put(ATTR_PYMTTALCRGONINCMTXQNTY,pymtTalcRgonIncmTxQnty);
     	values.put(ATTR_PYMTTALCFARVILSPCLQNTY,pymtTalcFarvilSpclQnty);
     	values.put(ATTR_PYMTTXALLCAGGRSUM,pymtTxAllcAggrSum);
     	values.put(ATTR_PYMTSUBTNINCMTXQNTY,pymtSubtnIncmTxQnty);
     	values.put(ATTR_PYMTSUBTNRGONINCMTXQNTY,pymtSubtnRgonIncmTxQnty);
     	values.put(ATTR_PYMTSUBTNFARVILSPCLQNTY,pymtSubtnFarvilSpclQnty);
     	values.put(ATTR_PYMTSUBTNAGGRSUM,pymtSubtnAggrSum);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 


/** set 사업장코드 : dpobCd */
public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
/** get 사업장코드 : dpobCd */
public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}


/** set 정산년월 : clutYrMnth */
public void setClutYrMnth(String  clutYrMnth) { set( ATTR_CLUTYRMNTH ,clutYrMnth);}
/** get 정산년월 : clutYrMnth */
public String  getClutYrMnth() { return (String )get( ATTR_CLUTYRMNTH );}

/** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
public void setCalcSevePsnBlggYrMnth(String  calcSevePsnBlggYrMnth) { set( ATTR_CALCSEVEPSNBLGGYRMNTH ,calcSevePsnBlggYrMnth);}
/** get 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
public String  getCalcSevePsnBlggYrMnth() { return (String )get( ATTR_CALCSEVEPSNBLGGYRMNTH );}

/** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
/** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}

/** set SYSTEMKEY : systemkey */
public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
/** get SYSTEMKEY : systemkey */
public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

/** set 부서코드 : deptCd */
public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
/** get 부서코드 : deptCd */
public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

/** set 한글성명 : hanNm */
public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
/** get 한글성명 : hanNm */
public String  getHanNm() { return (String )get( ATTR_HANNM );}

/** set 주민등록번호 : resnRegnNum */
public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
/** get 주민등록번호 : resnRegnNum */
public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

/** set 소득자임원여부 : aimenrEcteYn */
public void setAimenrEcteYn(String  aimenrEcteYn) { set( ATTR_AIMENRECTEYN ,aimenrEcteYn);}
/** get 소득자임원여부 : aimenrEcteYn */
public String  getAimenrEcteYn() { return (String )get( ATTR_AIMENRECTEYN );}


/** set 주민등록번호 : secRegnNum */
public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
/** get 주민등록번호 : secRegnNum */
public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}


/** set 확정급여형가입일자 : fixPayJnDt */
public void setFixPayJnDt(String  fixPayJnDt) { set( ATTR_FIXPAYJNDT ,fixPayJnDt);}
/** get 확정급여형가입일자 : fixPayJnDt */
public String  getFixPayJnDt() { return (String )get( ATTR_FIXPAYJNDT );}

/** set 퇴직금_20111231금액 : sevePay20111231Sum */
public void setSevePay20111231Sum(Long  sevePay20111231Sum) { set( ATTR_SEVEPAY20111231SUM ,sevePay20111231Sum);}
/** get 퇴직금_20111231금액 : sevePay20111231Sum */
public Long  getSevePay20111231Sum() { return (Long )get( ATTR_SEVEPAY20111231SUM );}


/** set 외국인구분코드 : frgnrDivCd */
public void setFrgnrDivCd(String  frgnrDivCd) { set( ATTR_FRGNRDIVCD ,frgnrDivCd);}
/** get 외국인구분코드 : frgnrDivCd */
public String  getFrgnrDivCd() { return (String )get( ATTR_FRGNRDIVCD );}

/** set 거주구분여부 : ridnSeptYn */
public void setRidnSeptYn(String  ridnSeptYn) { set( ATTR_RIDNSEPTYN ,ridnSeptYn);}
/** get 거주구분여부 : ridnSeptYn */
public String  getRidnSeptYn() { return (String )get( ATTR_RIDNSEPTYN );}

/** set 거주지국코드 : ridnCd */
public void setRidnCd(String  ridnCd) { set( ATTR_RIDNCD ,ridnCd);}
/** get 거주지국코드 : ridnCd */
public String  getRidnCd() { return (String )get( ATTR_RIDNCD );}

/** set 거주지국명 : ridnNm */
public void setRidnNm(String  ridnNm) { set( ATTR_RIDNNM ,ridnNm);}
/** get 거주지국명 : ridnNm */
public String  getRidnNm() { return (String )get( ATTR_RIDNNM );}

/** set 귀속년도시작일자 : blggYrBgnnDt */
public void setBlggYrBgnnDt(String  blggYrBgnnDt) { set( ATTR_BLGGYRBGNNDT ,blggYrBgnnDt);}
/** get 귀속년도시작일자 : blggYrBgnnDt */
public String  getBlggYrBgnnDt() { return (String )get( ATTR_BLGGYRBGNNDT );}

/** set 귀속년도종료일자 : blggYrEndDt */
public void setBlggYrEndDt(String  blggYrEndDt) { set( ATTR_BLGGYRENDDT ,blggYrEndDt);}
/** get 귀속년도종료일자 : blggYrEndDt */
public String  getBlggYrEndDt() { return (String )get( ATTR_BLGGYRENDDT );}

/** set 퇴직사유코드 : retryReasCd */
public void setRetryReasCd(String  retryReasCd) { set( ATTR_RETRYREASCD ,retryReasCd);}
/** get 퇴직사유코드 : retryReasCd */
public String  getRetryReasCd() { return (String )get( ATTR_RETRYREASCD );}

/** set 중_사업자등록번호 : ctrBusoprRgstnNum */
public void setCtrBusoprRgstnNum(String  ctrBusoprRgstnNum) { set( ATTR_CTRBUSOPRRGSTNNUM ,ctrBusoprRgstnNum);}
/** get 중_사업자등록번호 : ctrBusoprRgstnNum */
public String  getCtrBusoprRgstnNum() { return (String )get( ATTR_CTRBUSOPRRGSTNNUM );}

/** set 중_근무처명 : ctrPaeWorkNm */
public void setCtrPaeWorkNm(String  ctrPaeWorkNm) { set( ATTR_CTRPAEWORKNM ,ctrPaeWorkNm);}
/** get 중_근무처명 : ctrPaeWorkNm */
public String  getCtrPaeWorkNm() { return (String )get( ATTR_CTRPAEWORKNM );}

/** set 중_퇴직급여액 : ctrRetryPayQnty */
public void setCtrRetryPayQnty(Long  ctrRetryPayQnty) { set( ATTR_CTRRETRYPAYQNTY ,ctrRetryPayQnty);}
/** get 중_퇴직급여액 : ctrRetryPayQnty */
public Long  getCtrRetryPayQnty() { return (Long )get( ATTR_CTRRETRYPAYQNTY );}

/** set 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
public void setCtrFreeDtyRetryPayQnty(Long  ctrFreeDtyRetryPayQnty) { set( ATTR_CTRFREEDTYRETRYPAYQNTY ,ctrFreeDtyRetryPayQnty);}
/** get 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
public Long  getCtrFreeDtyRetryPayQnty() { return (Long )get( ATTR_CTRFREEDTYRETRYPAYQNTY );}

/** set 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
public void setCtrTxtnTgtRetryPayQnty(Long  ctrTxtnTgtRetryPayQnty) { set( ATTR_CTRTXTNTGTRETRYPAYQNTY ,ctrTxtnTgtRetryPayQnty);}
/** get 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
public Long  getCtrTxtnTgtRetryPayQnty() { return (Long )get( ATTR_CTRTXTNTGTRETRYPAYQNTY );}

/** set 종_사업자등록번호 : endBusoprRgstnNum */
public void setEndBusoprRgstnNum(String  endBusoprRgstnNum) { set( ATTR_ENDBUSOPRRGSTNNUM ,endBusoprRgstnNum);}
/** get 종_사업자등록번호 : endBusoprRgstnNum */
public String  getEndBusoprRgstnNum() { return (String )get( ATTR_ENDBUSOPRRGSTNNUM );}

/** set 종_근무처명 : endPaeWorkNm */
public void setEndPaeWorkNm(String  endPaeWorkNm) { set( ATTR_ENDPAEWORKNM ,endPaeWorkNm);}
/** get 종_근무처명 : endPaeWorkNm */
public String  getEndPaeWorkNm() { return (String )get( ATTR_ENDPAEWORKNM );}

/** set 종_퇴직급여액 : endRetryPayQnty */
public void setEndRetryPayQnty(Long  endRetryPayQnty) { set( ATTR_ENDRETRYPAYQNTY ,endRetryPayQnty);}
/** get 종_퇴직급여액 : endRetryPayQnty */
public Long  getEndRetryPayQnty() { return (Long )get( ATTR_ENDRETRYPAYQNTY );}

/** set 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
public void setEndFreeDtyRetryPayQnty(Long  endFreeDtyRetryPayQnty) { set( ATTR_ENDFREEDTYRETRYPAYQNTY ,endFreeDtyRetryPayQnty);}
/** get 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
public Long  getEndFreeDtyRetryPayQnty() { return (Long )get( ATTR_ENDFREEDTYRETRYPAYQNTY );}

/** set 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
public void setEndTxtnTgtRetryPayQnty(Long  endTxtnTgtRetryPayQnty) { set( ATTR_ENDTXTNTGTRETRYPAYQNTY ,endTxtnTgtRetryPayQnty);}
/** get 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
public Long  getEndTxtnTgtRetryPayQnty() { return (Long )get( ATTR_ENDTXTNTGTRETRYPAYQNTY );}

/** set 정산_퇴직급여액 : clutRetryPayQnty */
public void setClutRetryPayQnty(Long  clutRetryPayQnty) { set( ATTR_CLUTRETRYPAYQNTY ,clutRetryPayQnty);}
/** get 정산_퇴직급여액 : clutRetryPayQnty */
public Long  getClutRetryPayQnty() { return (Long )get( ATTR_CLUTRETRYPAYQNTY );}

/** set 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
public void setClutFreeDtyRetryPayQnty(Long  clutFreeDtyRetryPayQnty) { set( ATTR_CLUTFREEDTYRETRYPAYQNTY ,clutFreeDtyRetryPayQnty);}
/** get 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
public Long  getClutFreeDtyRetryPayQnty() { return (Long )get( ATTR_CLUTFREEDTYRETRYPAYQNTY );}

/** set 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
public void setClutTxtnTgtRetryPayQnty(Long  clutTxtnTgtRetryPayQnty) { set( ATTR_CLUTTXTNTGTRETRYPAYQNTY ,clutTxtnTgtRetryPayQnty);}
/** get 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
public Long  getClutTxtnTgtRetryPayQnty() { return (Long )get( ATTR_CLUTTXTNTGTRETRYPAYQNTY );}

/** set 중_입사일자 : ctrIcncDt */
public void setCtrIcncDt(String  ctrIcncDt) { set( ATTR_CTRICNCDT ,ctrIcncDt);}
/** get 중_입사일자 : ctrIcncDt */
public String  getCtrIcncDt() { return (String )get( ATTR_CTRICNCDT );}

/** set 중_기산일자 : ctrRkfcdDt */
public void setCtrRkfcdDt(String  ctrRkfcdDt) { set( ATTR_CTRRKFCDDT ,ctrRkfcdDt);}
/** get 중_기산일자 : ctrRkfcdDt */
public String  getCtrRkfcdDt() { return (String )get( ATTR_CTRRKFCDDT );}

/** set 중_퇴사일자 : ctrRsgtnDt */
public void setCtrRsgtnDt(String  ctrRsgtnDt) { set( ATTR_CTRRSGTNDT ,ctrRsgtnDt);}
/** get 중_퇴사일자 : ctrRsgtnDt */
public String  getCtrRsgtnDt() { return (String )get( ATTR_CTRRSGTNDT );}

/** set 중_지급일자 : ctrPymtDt */
public void setCtrPymtDt(String  ctrPymtDt) { set( ATTR_CTRPYMTDT ,ctrPymtDt);}
/** get 중_지급일자 : ctrPymtDt */
public String  getCtrPymtDt() { return (String )get( ATTR_CTRPYMTDT );}

/** set 중_근속월수 : ctrLogSvcMnthIcm */
public void setCtrLogSvcMnthIcm(Long  ctrLogSvcMnthIcm) { set( ATTR_CTRLOGSVCMNTHICM ,ctrLogSvcMnthIcm);}
/** get 중_근속월수 : ctrLogSvcMnthIcm */
public Long  getCtrLogSvcMnthIcm() { return (Long )get( ATTR_CTRLOGSVCMNTHICM );}

/** set 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
public void setCtrEepnMnth12Bfr(Long  ctrEepnMnth12Bfr) { set( ATTR_CTREEPNMNTH12BFR ,ctrEepnMnth12Bfr);}
/** get 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
public Long  getCtrEepnMnth12Bfr() { return (Long )get( ATTR_CTREEPNMNTH12BFR );}

/** set 중_제외월수_2013이후 : ctrEepnMnth13Aft */
public void setCtrEepnMnth13Aft(Long  ctrEepnMnth13Aft) { set( ATTR_CTREEPNMNTH13AFT ,ctrEepnMnth13Aft);}
/** get 중_제외월수_2013이후 : ctrEepnMnth13Aft */
public Long  getCtrEepnMnth13Aft() { return (Long )get( ATTR_CTREEPNMNTH13AFT );}

/** set 중_가산월수_2012이전 : ctrAddMnth12Bfr */
public void setCtrAddMnth12Bfr(Long  ctrAddMnth12Bfr) { set( ATTR_CTRADDMNTH12BFR ,ctrAddMnth12Bfr);}
/** get 중_가산월수_2012이전 : ctrAddMnth12Bfr */
public Long  getCtrAddMnth12Bfr() { return (Long )get( ATTR_CTRADDMNTH12BFR );}

/** set 중_가산월수_2013이후 : ctrAddMnth13Aft */
public void setCtrAddMnth13Aft(Long  ctrAddMnth13Aft) { set( ATTR_CTRADDMNTH13AFT ,ctrAddMnth13Aft);}
/** get 중_가산월수_2013이후 : ctrAddMnth13Aft */
public Long  getCtrAddMnth13Aft() { return (Long )get( ATTR_CTRADDMNTH13AFT );}

/** set 중_제외월수 : ctrEepnMnthIcm */
public void setCtrEepnMnthIcm(Long  ctrEepnMnthIcm) { set( ATTR_CTREEPNMNTHICM ,ctrEepnMnthIcm);}
/** get 중_제외월수 : ctrEepnMnthIcm */
public Long  getCtrEepnMnthIcm() { return (Long )get( ATTR_CTREEPNMNTHICM );}

/** set 중_가산월수 : ctrAddMnthIcm */
public void setCtrAddMnthIcm(Long  ctrAddMnthIcm) { set( ATTR_CTRADDMNTHICM ,ctrAddMnthIcm);}
/** get 중_가산월수 : ctrAddMnthIcm */
public Long  getCtrAddMnthIcm() { return (Long )get( ATTR_CTRADDMNTHICM );}

/** set 중_중복월수 : ctrDupMnthIcm */
public void setCtrDupMnthIcm(Long  ctrDupMnthIcm) { set( ATTR_CTRDUPMNTHICM ,ctrDupMnthIcm);}
/** get 중_중복월수 : ctrDupMnthIcm */
public Long  getCtrDupMnthIcm() { return (Long )get( ATTR_CTRDUPMNTHICM );}

/** set 중_근속연수 : ctrLogSvc */
public void setCtrLogSvc(Long  ctrLogSvc) { set( ATTR_CTRLOGSVC ,ctrLogSvc);}
/** get 중_근속연수 : ctrLogSvc */
public Long  getCtrLogSvc() { return (Long )get( ATTR_CTRLOGSVC );}

/** set 종_입사일자 : endIcncDt */
public void setEndIcncDt(String  endIcncDt) { set( ATTR_ENDICNCDT ,endIcncDt);}
/** get 종_입사일자 : endIcncDt */
public String  getEndIcncDt() { return (String )get( ATTR_ENDICNCDT );}

/** set 종_기산일자 : endRkfcdDt */
public void setEndRkfcdDt(String  endRkfcdDt) { set( ATTR_ENDRKFCDDT ,endRkfcdDt);}
/** get 종_기산일자 : endRkfcdDt */
public String  getEndRkfcdDt() { return (String )get( ATTR_ENDRKFCDDT );}

/** set 종_퇴사일자 : endRsgtnDt */
public void setEndRsgtnDt(String  endRsgtnDt) { set( ATTR_ENDRSGTNDT ,endRsgtnDt);}
/** get 종_퇴사일자 : endRsgtnDt */
public String  getEndRsgtnDt() { return (String )get( ATTR_ENDRSGTNDT );}

/** set 종_지급일자 : endPymtDt */
public void setEndPymtDt(String  endPymtDt) { set( ATTR_ENDPYMTDT ,endPymtDt);}
/** get 종_지급일자 : endPymtDt */
public String  getEndPymtDt() { return (String )get( ATTR_ENDPYMTDT );}

/** set 종_근속월수 : endLogSvcMnthIcm */
public void setEndLogSvcMnthIcm(Long  endLogSvcMnthIcm) { set( ATTR_ENDLOGSVCMNTHICM ,endLogSvcMnthIcm);}
/** get 종_근속월수 : endLogSvcMnthIcm */
public Long  getEndLogSvcMnthIcm() { return (Long )get( ATTR_ENDLOGSVCMNTHICM );}

/** set 종_제외월수_2012이전 : endEepnMnth12Bfr */
public void setEndEepnMnth12Bfr(Long  endEepnMnth12Bfr) { set( ATTR_ENDEEPNMNTH12BFR ,endEepnMnth12Bfr);}
/** get 종_제외월수_2012이전 : endEepnMnth12Bfr */
public Long  getEndEepnMnth12Bfr() { return (Long )get( ATTR_ENDEEPNMNTH12BFR );}

/** set 종_제외월수_2013이후 : endEepnMnth13Aft */
public void setEndEepnMnth13Aft(Long  endEepnMnth13Aft) { set( ATTR_ENDEEPNMNTH13AFT ,endEepnMnth13Aft);}
/** get 종_제외월수_2013이후 : endEepnMnth13Aft */
public Long  getEndEepnMnth13Aft() { return (Long )get( ATTR_ENDEEPNMNTH13AFT );}

/** set 종_가산월수_2012이전 : endAddMnth12Bfr */
public void setEndAddMnth12Bfr(Long  endAddMnth12Bfr) { set( ATTR_ENDADDMNTH12BFR ,endAddMnth12Bfr);}
/** get 종_가산월수_2012이전 : endAddMnth12Bfr */
public Long  getEndAddMnth12Bfr() { return (Long )get( ATTR_ENDADDMNTH12BFR );}

/** set 종_가산월수_2013이후 : endAddMnth13Aft */
public void setEndAddMnth13Aft(Long  endAddMnth13Aft) { set( ATTR_ENDADDMNTH13AFT ,endAddMnth13Aft);}
/** get 종_가산월수_2013이후 : endAddMnth13Aft */
public Long  getEndAddMnth13Aft() { return (Long )get( ATTR_ENDADDMNTH13AFT );}

/** set 종_제외월수 : endEepnMnthIcm */
public void setEndEepnMnthIcm(Long  endEepnMnthIcm) { set( ATTR_ENDEEPNMNTHICM ,endEepnMnthIcm);}
/** get 종_제외월수 : endEepnMnthIcm */
public Long  getEndEepnMnthIcm() { return (Long )get( ATTR_ENDEEPNMNTHICM );}

/** set 종_가산월수 : endAddMnthIcm */
public void setEndAddMnthIcm(Long  endAddMnthIcm) { set( ATTR_ENDADDMNTHICM ,endAddMnthIcm);}
/** get 종_가산월수 : endAddMnthIcm */
public Long  getEndAddMnthIcm() { return (Long )get( ATTR_ENDADDMNTHICM );}

/** set 종_중복월수 : endDupMnthIcm */
public void setEndDupMnthIcm(Long  endDupMnthIcm) { set( ATTR_ENDDUPMNTHICM ,endDupMnthIcm);}
/** get 종_중복월수 : endDupMnthIcm */
public Long  getEndDupMnthIcm() { return (Long )get( ATTR_ENDDUPMNTHICM );}

/** set 종_근속연수 : endLogSvcYrNum */
public void setEndLogSvcYrNum(Long  endLogSvcYrNum) { set( ATTR_ENDLOGSVCYRNUM ,endLogSvcYrNum);}
/** get 종_근속연수 : endLogSvcYrNum */
public Long  getEndLogSvcYrNum() { return (Long )get( ATTR_ENDLOGSVCYRNUM );}

/** set 정산_입사일자 : clutIcncDt */
public void setClutIcncDt(String  clutIcncDt) { set( ATTR_CLUTICNCDT ,clutIcncDt);}
/** get 정산_입사일자 : clutIcncDt */
public String  getClutIcncDt() { return (String )get( ATTR_CLUTICNCDT );}

/** set 정산-기산일자 : clutRkfcdDt */
public void setClutRkfcdDt(String  clutRkfcdDt) { set( ATTR_CLUTRKFCDDT ,clutRkfcdDt);}
/** get 정산-기산일자 : clutRkfcdDt */
public String  getClutRkfcdDt() { return (String )get( ATTR_CLUTRKFCDDT );}

/** set 정산_퇴사일자 : clutRsgtnDt */
public void setClutRsgtnDt(String  clutRsgtnDt) { set( ATTR_CLUTRSGTNDT ,clutRsgtnDt);}
/** get 정산_퇴사일자 : clutRsgtnDt */
public String  getClutRsgtnDt() { return (String )get( ATTR_CLUTRSGTNDT );}

/** set 정산_지급일자 : clutPymtDt */
public void setClutPymtDt(String  clutPymtDt) { set( ATTR_CLUTPYMTDT ,clutPymtDt);}
/** get 정산_지급일자 : clutPymtDt */
public String  getClutPymtDt() { return (String )get( ATTR_CLUTPYMTDT );}

/** set 정산_근속월수 : clutLogSvcMnthIcm */
public void setClutLogSvcMnthIcm(Long  clutLogSvcMnthIcm) { set( ATTR_CLUTLOGSVCMNTHICM ,clutLogSvcMnthIcm);}
/** get 정산_근속월수 : clutLogSvcMnthIcm */
public Long  getClutLogSvcMnthIcm() { return (Long )get( ATTR_CLUTLOGSVCMNTHICM );}

/** set 정산_제외월수 : clutEepnMnthIcm */
public void setClutEepnMnthIcm(Long  clutEepnMnthIcm) { set( ATTR_CLUTEEPNMNTHICM ,clutEepnMnthIcm);}
/** get 정산_제외월수 : clutEepnMnthIcm */
public Long  getClutEepnMnthIcm() { return (Long )get( ATTR_CLUTEEPNMNTHICM );}

/** set 정산_가산월수 : clutAddMnthIcm */
public void setClutAddMnthIcm(Long  clutAddMnthIcm) { set( ATTR_CLUTADDMNTHICM ,clutAddMnthIcm);}
/** get 정산_가산월수 : clutAddMnthIcm */
public Long  getClutAddMnthIcm() { return (Long )get( ATTR_CLUTADDMNTHICM );}

/** set 정산_중복월수 : clutDupMnthIcm */
public void setClutDupMnthIcm(Long  clutDupMnthIcm) { set( ATTR_CLUTDUPMNTHICM ,clutDupMnthIcm);}
/** get 정산_중복월수 : clutDupMnthIcm */
public Long  getClutDupMnthIcm() { return (Long )get( ATTR_CLUTDUPMNTHICM );}

/** set 정산_근속연수 : clutLogSvcYrNum */
public void setClutLogSvcYrNum(Long  clutLogSvcYrNum) { set( ATTR_CLUTLOGSVCYRNUM ,clutLogSvcYrNum);}
/** get 정산_근속연수 : clutLogSvcYrNum */
public Long  getClutLogSvcYrNum() { return (Long )get( ATTR_CLUTLOGSVCYRNUM );}

/** set 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
public void setLogPpnl12befIcncDt(String  logPpnl12befIcncDt) { set( ATTR_LOGPPNL12BEFICNCDT ,logPpnl12befIcncDt);}
/** get 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
public String  getLogPpnl12befIcncDt() { return (String )get( ATTR_LOGPPNL12BEFICNCDT );}

/** set 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
public void setLogPpnl12befRkfcdDt(String  logPpnl12befRkfcdDt) { set( ATTR_LOGPPNL12BEFRKFCDDT ,logPpnl12befRkfcdDt);}
/** get 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
public String  getLogPpnl12befRkfcdDt() { return (String )get( ATTR_LOGPPNL12BEFRKFCDDT );}

/** set 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
public void setLogPpnl12befRsgtnDt(String  logPpnl12befRsgtnDt) { set( ATTR_LOGPPNL12BEFRSGTNDT ,logPpnl12befRsgtnDt);}
/** get 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
public String  getLogPpnl12befRsgtnDt() { return (String )get( ATTR_LOGPPNL12BEFRSGTNDT );}

/** set 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
public void setLogPpnl12befPymtDt(String  logPpnl12befPymtDt) { set( ATTR_LOGPPNL12BEFPYMTDT ,logPpnl12befPymtDt);}
/** get 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
public String  getLogPpnl12befPymtDt() { return (String )get( ATTR_LOGPPNL12BEFPYMTDT );}

/** set 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
public void setLogPpnl12befLogMnthIcm(Long  logPpnl12befLogMnthIcm) { set( ATTR_LOGPPNL12BEFLOGMNTHICM ,logPpnl12befLogMnthIcm);}
/** get 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
public Long  getLogPpnl12befLogMnthIcm() { return (Long )get( ATTR_LOGPPNL12BEFLOGMNTHICM );}

/** set 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
public void setLogPpnl12befEepnMnthIcm(Long  logPpnl12befEepnMnthIcm) { set( ATTR_LOGPPNL12BEFEEPNMNTHICM ,logPpnl12befEepnMnthIcm);}
/** get 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
public Long  getLogPpnl12befEepnMnthIcm() { return (Long )get( ATTR_LOGPPNL12BEFEEPNMNTHICM );}

/** set 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
public void setLogPpnl12befAddMnthIcm(Long  logPpnl12befAddMnthIcm) { set( ATTR_LOGPPNL12BEFADDMNTHICM ,logPpnl12befAddMnthIcm);}
/** get 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
public Long  getLogPpnl12befAddMnthIcm() { return (Long )get( ATTR_LOGPPNL12BEFADDMNTHICM );}

/** set 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
public void setLogPpnl12befDupMnthIcm(Long  logPpnl12befDupMnthIcm) { set( ATTR_LOGPPNL12BEFDUPMNTHICM ,logPpnl12befDupMnthIcm);}
/** get 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
public Long  getLogPpnl12befDupMnthIcm() { return (Long )get( ATTR_LOGPPNL12BEFDUPMNTHICM );}

/** set 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
public void setLogPpnl12befLogYrNum(Long  logPpnl12befLogYrNum) { set( ATTR_LOGPPNL12BEFLOGYRNUM ,logPpnl12befLogYrNum);}
/** get 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
public Long  getLogPpnl12befLogYrNum() { return (Long )get( ATTR_LOGPPNL12BEFLOGYRNUM );}

/** set 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
public void setLogPpnl13afrIcncDt(String  logPpnl13afrIcncDt) { set( ATTR_LOGPPNL13AFRICNCDT ,logPpnl13afrIcncDt);}
/** get 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
public String  getLogPpnl13afrIcncDt() { return (String )get( ATTR_LOGPPNL13AFRICNCDT );}

/** set 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
public void setLogPpnl13afrRkfcdDt(String  logPpnl13afrRkfcdDt) { set( ATTR_LOGPPNL13AFRRKFCDDT ,logPpnl13afrRkfcdDt);}
/** get 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
public String  getLogPpnl13afrRkfcdDt() { return (String )get( ATTR_LOGPPNL13AFRRKFCDDT );}

/** set 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
public void setLogPpnl13afrRsgtnDt(String  logPpnl13afrRsgtnDt) { set( ATTR_LOGPPNL13AFRRSGTNDT ,logPpnl13afrRsgtnDt);}
/** get 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
public String  getLogPpnl13afrRsgtnDt() { return (String )get( ATTR_LOGPPNL13AFRRSGTNDT );}

/** set 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
public void setLogPpnl13afrPymtDt(String  logPpnl13afrPymtDt) { set( ATTR_LOGPPNL13AFRPYMTDT ,logPpnl13afrPymtDt);}
/** get 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
public String  getLogPpnl13afrPymtDt() { return (String )get( ATTR_LOGPPNL13AFRPYMTDT );}

/** set 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
public void setLogPpnl13afrLogMnthIcm(Long  logPpnl13afrLogMnthIcm) { set( ATTR_LOGPPNL13AFRLOGMNTHICM ,logPpnl13afrLogMnthIcm);}
/** get 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
public Long  getLogPpnl13afrLogMnthIcm() { return (Long )get( ATTR_LOGPPNL13AFRLOGMNTHICM );}

/** set 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
public void setLogPpnl13afrEepnMnthIcm(Long  logPpnl13afrEepnMnthIcm) { set( ATTR_LOGPPNL13AFREEPNMNTHICM ,logPpnl13afrEepnMnthIcm);}
/** get 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
public Long  getLogPpnl13afrEepnMnthIcm() { return (Long )get( ATTR_LOGPPNL13AFREEPNMNTHICM );}

/** set 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
public void setLogPpnl13afrAddMnthIcm(Long  logPpnl13afrAddMnthIcm) { set( ATTR_LOGPPNL13AFRADDMNTHICM ,logPpnl13afrAddMnthIcm);}
/** get 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
public Long  getLogPpnl13afrAddMnthIcm() { return (Long )get( ATTR_LOGPPNL13AFRADDMNTHICM );}

/** set 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
public void setLogPpnl13afrDupMnthIcm(Long  logPpnl13afrDupMnthIcm) { set( ATTR_LOGPPNL13AFRDUPMNTHICM ,logPpnl13afrDupMnthIcm);}
/** get 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
public Long  getLogPpnl13afrDupMnthIcm() { return (Long )get( ATTR_LOGPPNL13AFRDUPMNTHICM );}

/** set 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
public void setLogPpnl13afrLogSvc(Long  logPpnl13afrLogSvc) { set( ATTR_LOGPPNL13AFRLOGSVC ,logPpnl13afrLogSvc);}
/** get 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
public Long  getLogPpnl13afrLogSvc() { return (Long )get( ATTR_LOGPPNL13AFRLOGSVC );}

/** set 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
public void setRetryIncmCtrPymtSum(Long  retryIncmCtrPymtSum) { set( ATTR_RETRYINCMCTRPYMTSUM ,retryIncmCtrPymtSum);}
/** get 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
public Long  getRetryIncmCtrPymtSum() { return (Long )get( ATTR_RETRYINCMCTRPYMTSUM );}

/** set 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
public void setRetryIncmEndPymtSum(Long  retryIncmEndPymtSum) { set( ATTR_RETRYINCMENDPYMTSUM ,retryIncmEndPymtSum);}
/** get 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
public Long  getRetryIncmEndPymtSum() { return (Long )get( ATTR_RETRYINCMENDPYMTSUM );}

/** set 퇴직소득_정산금액 : retryIncmClutSum */
public void setRetryIncmClutSum(Long  retryIncmClutSum) { set( ATTR_RETRYINCMCLUTSUM ,retryIncmClutSum);}
/** get 퇴직소득_정산금액 : retryIncmClutSum */
public Long  getRetryIncmClutSum() { return (Long )get( ATTR_RETRYINCMCLUTSUM );}

/** set 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
public void setRetryFxrtDducClutSum(Long  retryFxrtDducClutSum) { set( ATTR_RETRYFXRTDDUCCLUTSUM ,retryFxrtDducClutSum);}
/** get 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
public Long  getRetryFxrtDducClutSum() { return (Long )get( ATTR_RETRYFXRTDDUCCLUTSUM );}

/** set 근속년수공제_정산금액 : logYrDducSum */
public void setLogYrDducSum(Long  logYrDducSum) { set( ATTR_LOGYRDDUCSUM ,logYrDducSum);}
/** get 근속년수공제_정산금액 : logYrDducSum */
public Long  getLogYrDducSum() { return (Long )get( ATTR_LOGYRDDUCSUM );}

/** set 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
public void setRetryTxtnStdClutSum(Long  retryTxtnStdClutSum) { set( ATTR_RETRYTXTNSTDCLUTSUM ,retryTxtnStdClutSum);}
/** get 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
public Long  getRetryTxtnStdClutSum() { return (Long )get( ATTR_RETRYTXTNSTDCLUTSUM );}

/** set 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
public void setTat12befTxtnStdPpnlSum(Long  tat12befTxtnStdPpnlSum) { set( ATTR_TAT12BEFTXTNSTDPPNLSUM ,tat12befTxtnStdPpnlSum);}
/** get 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
public Long  getTat12befTxtnStdPpnlSum() { return (Long )get( ATTR_TAT12BEFTXTNSTDPPNLSUM );}

/** set 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
public void setTat12befYravgTxstdSum(Long  tat12befYravgTxstdSum) { set( ATTR_TAT12BEFYRAVGTXSTDSUM ,tat12befYravgTxstdSum);}
/** get 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
public Long  getTat12befYravgTxstdSum() { return (Long )get( ATTR_TAT12BEFYRAVGTXSTDSUM );}

/** set 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
public void setTat12befCvsnTxtnStdSum(Long  tat12befCvsnTxtnStdSum) { set( ATTR_TAT12BEFCVSNTXTNSTDSUM ,tat12befCvsnTxtnStdSum);}
/** get 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
public Long  getTat12befCvsnTxtnStdSum() { return (Long )get( ATTR_TAT12BEFCVSNTXTNSTDSUM );}

/** set 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
public void setTat12befCvsnCalcAmnt(Long  tat12befCvsnCalcAmnt) { set( ATTR_TAT12BEFCVSNCALCAMNT ,tat12befCvsnCalcAmnt);}
/** get 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
public Long  getTat12befCvsnCalcAmnt() { return (Long )get( ATTR_TAT12BEFCVSNCALCAMNT );}

/** set 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
public void setTat12befYrAvgCalcAmnt(Long  tat12befYrAvgCalcAmnt) { set( ATTR_TAT12BEFYRAVGCALCAMNT ,tat12befYrAvgCalcAmnt);}
/** get 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
public Long  getTat12befYrAvgCalcAmnt() { return (Long )get( ATTR_TAT12BEFYRAVGCALCAMNT );}

/** set 세액_2012전_산출세액 : tat12befCalcTxAmnt */
public void setTat12befCalcTxAmnt(Long  tat12befCalcTxAmnt) { set( ATTR_TAT12BEFCALCTXAMNT ,tat12befCalcTxAmnt);}
/** get 세액_2012전_산출세액 : tat12befCalcTxAmnt */
public Long  getTat12befCalcTxAmnt() { return (Long )get( ATTR_TAT12BEFCALCTXAMNT );}

/** set 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
public void setTat12befAlpayTxAmnt(Long  tat12befAlpayTxAmnt) { set( ATTR_TAT12BEFALPAYTXAMNT ,tat12befAlpayTxAmnt);}
/** get 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
public Long  getTat12befAlpayTxAmnt() { return (Long )get( ATTR_TAT12BEFALPAYTXAMNT );}

/** set 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
public void setTat12befRegTgtTxAmnt(Long  tat12befRegTgtTxAmnt) { set( ATTR_TAT12BEFREGTGTTXAMNT ,tat12befRegTgtTxAmnt);}
/** get 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
public Long  getTat12befRegTgtTxAmnt() { return (Long )get( ATTR_TAT12BEFREGTGTTXAMNT );}

/** set 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
public void setTat13afrTxstdPpnlSum(Long  tat13afrTxstdPpnlSum) { set( ATTR_TAT13AFRTXSTDPPNLSUM ,tat13afrTxstdPpnlSum);}
/** get 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
public Long  getTat13afrTxstdPpnlSum() { return (Long )get( ATTR_TAT13AFRTXSTDPPNLSUM );}

/** set 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
public void setTat13afrYrAvgStdSum(Long  tat13afrYrAvgStdSum) { set( ATTR_TAT13AFRYRAVGSTDSUM ,tat13afrYrAvgStdSum);}
/** get 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
public Long  getTat13afrYrAvgStdSum() { return (Long )get( ATTR_TAT13AFRYRAVGSTDSUM );}

/** set 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
public void setTat13afrCvsnTxtnStdSum(Long  tat13afrCvsnTxtnStdSum) { set( ATTR_TAT13AFRCVSNTXTNSTDSUM ,tat13afrCvsnTxtnStdSum);}
/** get 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
public Long  getTat13afrCvsnTxtnStdSum() { return (Long )get( ATTR_TAT13AFRCVSNTXTNSTDSUM );}

/** set 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
public void setTat13afrCvsnCalcTxAmnt(Long  tat13afrCvsnCalcTxAmnt) { set( ATTR_TAT13AFRCVSNCALCTXAMNT ,tat13afrCvsnCalcTxAmnt);}
/** get 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
public Long  getTat13afrCvsnCalcTxAmnt() { return (Long )get( ATTR_TAT13AFRCVSNCALCTXAMNT );}

/** set 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
public void setTat13afrYrAvgCalcAmnt(Long  tat13afrYrAvgCalcAmnt) { set( ATTR_TAT13AFRYRAVGCALCAMNT ,tat13afrYrAvgCalcAmnt);}
/** get 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
public Long  getTat13afrYrAvgCalcAmnt() { return (Long )get( ATTR_TAT13AFRYRAVGCALCAMNT );}

/** set 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
public void setTat13afrCalcTxAmnt(Long  tat13afrCalcTxAmnt) { set( ATTR_TAT13AFRCALCTXAMNT ,tat13afrCalcTxAmnt);}
/** get 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
public Long  getTat13afrCalcTxAmnt() { return (Long )get( ATTR_TAT13AFRCALCTXAMNT );}

/** set 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
public void setTat13afrAlpayTxAmnt(Long  tat13afrAlpayTxAmnt) { set( ATTR_TAT13AFRALPAYTXAMNT ,tat13afrAlpayTxAmnt);}
/** get 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
public Long  getTat13afrAlpayTxAmnt() { return (Long )get( ATTR_TAT13AFRALPAYTXAMNT );}

/** set 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
public void setTat13afrRegrstTgtSum(Long  tat13afrRegrstTgtSum) { set( ATTR_TAT13AFRREGRSTTGTSUM ,tat13afrRegrstTgtSum);}
/** get 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
public Long  getTat13afrRegrstTgtSum() { return (Long )get( ATTR_TAT13AFRREGRSTTGTSUM );}

/** set 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
public void setTatAggrTxtnStdPpnlSum(Long  tatAggrTxtnStdPpnlSum) { set( ATTR_TATAGGRTXTNSTDPPNLSUM ,tatAggrTxtnStdPpnlSum);}
/** get 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
public Long  getTatAggrTxtnStdPpnlSum() { return (Long )get( ATTR_TATAGGRTXTNSTDPPNLSUM );}

/** set 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
public void setTatAggrYrAvgTxtnStdSum(Long  tatAggrYrAvgTxtnStdSum) { set( ATTR_TATAGGRYRAVGTXTNSTDSUM ,tatAggrYrAvgTxtnStdSum);}
/** get 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
public Long  getTatAggrYrAvgTxtnStdSum() { return (Long )get( ATTR_TATAGGRYRAVGTXTNSTDSUM );}

/** set 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
public void setTatAggrCvsnTxtnStdSum(Long  tatAggrCvsnTxtnStdSum) { set( ATTR_TATAGGRCVSNTXTNSTDSUM ,tatAggrCvsnTxtnStdSum);}
/** get 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
public Long  getTatAggrCvsnTxtnStdSum() { return (Long )get( ATTR_TATAGGRCVSNTXTNSTDSUM );}

/** set 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
public void setTatAggrCvsnCalcTxAmnt(Long  tatAggrCvsnCalcTxAmnt) { set( ATTR_TATAGGRCVSNCALCTXAMNT ,tatAggrCvsnCalcTxAmnt);}
/** get 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
public Long  getTatAggrCvsnCalcTxAmnt() { return (Long )get( ATTR_TATAGGRCVSNCALCTXAMNT );}

/** set 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
public void setTatAggrYrAvgCalcTxAmnt(Long  tatAggrYrAvgCalcTxAmnt) { set( ATTR_TATAGGRYRAVGCALCTXAMNT ,tatAggrYrAvgCalcTxAmnt);}
/** get 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
public Long  getTatAggrYrAvgCalcTxAmnt() { return (Long )get( ATTR_TATAGGRYRAVGCALCTXAMNT );}

/** set 세액_합계_산출세액 : tatAggrCalcTxAmnt */
public void setTatAggrCalcTxAmnt(Long  tatAggrCalcTxAmnt) { set( ATTR_TATAGGRCALCTXAMNT ,tatAggrCalcTxAmnt);}
/** get 세액_합계_산출세액 : tatAggrCalcTxAmnt */
public Long  getTatAggrCalcTxAmnt() { return (Long )get( ATTR_TATAGGRCALCTXAMNT );}

/** set 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
public void setTatAggrAlpayTxAmnt(Long  tatAggrAlpayTxAmnt) { set( ATTR_TATAGGRALPAYTXAMNT ,tatAggrAlpayTxAmnt);}
/** get 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
public Long  getTatAggrAlpayTxAmnt() { return (Long )get( ATTR_TATAGGRALPAYTXAMNT );}

/** set 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
public void setTatAggrRegrstTgtTxAmnt(Long  tatAggrRegrstTgtTxAmnt) { set( ATTR_TATAGGRREGRSTTGTTXAMNT ,tatAggrRegrstTgtTxAmnt);}
/** get 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
public Long  getTatAggrRegrstTgtTxAmnt() { return (Long )get( ATTR_TATAGGRREGRSTTGTTXAMNT );}

/** set 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
public void setTalRegrstTgtTxAmnt(Long  talRegrstTgtTxAmnt) { set( ATTR_TALREGRSTTGTTXAMNT ,talRegrstTgtTxAmnt);}
/** get 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
public Long  getTalRegrstTgtTxAmnt() { return (Long )get( ATTR_TALREGRSTTGTTXAMNT );}

/** set 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
public void setTalAccuDepitAggrSum(Long  talAccuDepitAggrSum) { set( ATTR_TALACCUDEPITAGGRSUM ,talAccuDepitAggrSum);}
/** get 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
public Long  getTalAccuDepitAggrSum() { return (Long )get( ATTR_TALACCUDEPITAGGRSUM );}

/** set 이연세액_퇴직급여액 : talRetryPayQnty */
public void setTalRetryPayQnty(Long  talRetryPayQnty) { set( ATTR_TALRETRYPAYQNTY ,talRetryPayQnty);}
/** get 이연세액_퇴직급여액 : talRetryPayQnty */
public Long  getTalRetryPayQnty() { return (Long )get( ATTR_TALRETRYPAYQNTY );}

/** set 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
public void setTalRetryIncmTxAmnt(Long  talRetryIncmTxAmnt) { set( ATTR_TALRETRYINCMTXAMNT ,talRetryIncmTxAmnt);}
/** get 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
public Long  getTalRetryIncmTxAmnt() { return (Long )get( ATTR_TALRETRYINCMTXAMNT );}

/** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
public void setPymtRegTgtIncmTxQnty(Long  pymtRegTgtIncmTxQnty) { set( ATTR_PYMTREGTGTINCMTXQNTY ,pymtRegTgtIncmTxQnty);}
/** get 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
public Long  getPymtRegTgtIncmTxQnty() { return (Long )get( ATTR_PYMTREGTGTINCMTXQNTY );}

/** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
public void setPymtRegTgtRgonIncmQnty(Long  pymtRegTgtRgonIncmQnty) { set( ATTR_PYMTREGTGTRGONINCMQNTY ,pymtRegTgtRgonIncmQnty);}
/** get 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
public Long  getPymtRegTgtRgonIncmQnty() { return (Long )get( ATTR_PYMTREGTGTRGONINCMQNTY );}

/** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
public void setPymtRegTgtFarvilSpclQnty(Long  pymtRegTgtFarvilSpclQnty) { set( ATTR_PYMTREGTGTFARVILSPCLQNTY ,pymtRegTgtFarvilSpclQnty);}
/** get 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
public Long  getPymtRegTgtFarvilSpclQnty() { return (Long )get( ATTR_PYMTREGTGTFARVILSPCLQNTY );}

/** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
public void setPymtRegrstTgtAggrSum(Long  pymtRegrstTgtAggrSum) { set( ATTR_PYMTREGRSTTGTAGGRSUM ,pymtRegrstTgtAggrSum);}
/** get 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
public Long  getPymtRegrstTgtAggrSum() { return (Long )get( ATTR_PYMTREGRSTTGTAGGRSUM );}

/** set 납부이연_소득세액 : pymtTalcIncmTxQnty */
public void setPymtTalcIncmTxQnty(Long  pymtTalcIncmTxQnty) { set( ATTR_PYMTTALCINCMTXQNTY ,pymtTalcIncmTxQnty);}
/** get 납부이연_소득세액 : pymtTalcIncmTxQnty */
public Long  getPymtTalcIncmTxQnty() { return (Long )get( ATTR_PYMTTALCINCMTXQNTY );}

/** set 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
public void setPymtTalcRgonIncmTxQnty(Long  pymtTalcRgonIncmTxQnty) { set( ATTR_PYMTTALCRGONINCMTXQNTY ,pymtTalcRgonIncmTxQnty);}
/** get 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
public Long  getPymtTalcRgonIncmTxQnty() { return (Long )get( ATTR_PYMTTALCRGONINCMTXQNTY );}

/** set 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
public void setPymtTalcFarvilSpclQnty(Long  pymtTalcFarvilSpclQnty) { set( ATTR_PYMTTALCFARVILSPCLQNTY ,pymtTalcFarvilSpclQnty);}
/** get 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
public Long  getPymtTalcFarvilSpclQnty() { return (Long )get( ATTR_PYMTTALCFARVILSPCLQNTY );}

/** set 납부이연_합계금액 : pymtTxAllcAggrSum */
public void setPymtTxAllcAggrSum(Long  pymtTxAllcAggrSum) { set( ATTR_PYMTTXALLCAGGRSUM ,pymtTxAllcAggrSum);}
/** get 납부이연_합계금액 : pymtTxAllcAggrSum */
public Long  getPymtTxAllcAggrSum() { return (Long )get( ATTR_PYMTTXALLCAGGRSUM );}

/** set 납부차감_소득세액 : pymtSubtnIncmTxQnty */
public void setPymtSubtnIncmTxQnty(Long  pymtSubtnIncmTxQnty) { set( ATTR_PYMTSUBTNINCMTXQNTY ,pymtSubtnIncmTxQnty);}
/** get 납부차감_소득세액 : pymtSubtnIncmTxQnty */
public Long  getPymtSubtnIncmTxQnty() { return (Long )get( ATTR_PYMTSUBTNINCMTXQNTY );}

/** set 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
public void setPymtSubtnRgonIncmTxQnty(Long  pymtSubtnRgonIncmTxQnty) { set( ATTR_PYMTSUBTNRGONINCMTXQNTY ,pymtSubtnRgonIncmTxQnty);}
/** get 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
public Long  getPymtSubtnRgonIncmTxQnty() { return (Long )get( ATTR_PYMTSUBTNRGONINCMTXQNTY );}

/** set 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
public void setPymtSubtnFarvilSpclQnty(Long  pymtSubtnFarvilSpclQnty) { set( ATTR_PYMTSUBTNFARVILSPCLQNTY ,pymtSubtnFarvilSpclQnty);}
/** get 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
public Long  getPymtSubtnFarvilSpclQnty() { return (Long )get( ATTR_PYMTSUBTNFARVILSPCLQNTY );}

/** set 납부차감_합계금액 : pymtSubtnAggrSum */
public void setPymtSubtnAggrSum(Long  pymtSubtnAggrSum) { set( ATTR_PYMTSUBTNAGGRSUM ,pymtSubtnAggrSum);}
/** get 납부차감_합계금액 : pymtSubtnAggrSum */
public Long  getPymtSubtnAggrSum() { return (Long )get( ATTR_PYMTSUBTNAGGRSUM );}

/** set 입력자 : kybdr */
public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
/** get 입력자 : kybdr */
public String  getKybdr() { return (String )get( ATTR_KYBDR );}

/** set 입력일자 : inptDt */
public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
/** get 입력일자 : inptDt */
public String  getInptDt() { return (String )get( ATTR_INPTDT );}

/** set 입력주소 : inptAddr */
public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
/** get 입력주소 : inptAddr */
public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}

/** set 수정자 : ismt */
public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
/** get 수정자 : ismt */
public String  getIsmt() { return (String )get( ATTR_ISMT );}

/** set 수정일자 : revnDt */
public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
/** get 수정일자 : revnDt */
public String  getRevnDt() { return (String )get( ATTR_REVNDT );}

/** set 수정주소 : revnAddr */
public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
/** get 수정주소 : revnAddr */
public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}



	 /** set 고용구분 : emymtDivNm */
  public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
  /** get 고용구분 : emymtDivNm */
  public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

  
  /** set 부서 : deptNm */
  public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
  /** get 부서 : deptNm  */
  public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

  /** set 사업 : businNm */
  public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
  /** get 사업 : businNm */
  public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}

  /** set 직종 : typOccuNm */
  public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
  /** get 직종 : typOccuNm */
  public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}

  /** set 직종세 : dtilOccuClsDivNm */
  public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
  /** get 직종세 : dtilOccuClsDivNm */
  public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
 
  
  /** set 호봉등급 : pyspGrdeNm */
  public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
  /** get 호봉등급 : pyspGrdeNm */
  public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
   
  /** set 고용구분코드 : emymtDivCd */
  public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
  /** get 고용구분코드 : emymtDivCd */
  public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
 

  /** set 사업코드 : businCd */
  public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
  /** get 사업코드 : businCd */
  public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

  /** set 직종코드 : typOccuCd */
  public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
  /** get 직종코드 : typOccuCd */
  public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

  /** set 직종세구분코드 : dtilOccuClsDivCd */
  public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
  /** get 직종세구분코드 : dtilOccuClsDivCd */
  public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
  
   

  /** set 호봉등급코드 : pyspGrdeCd */
  public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
  /** get 호봉등급코드 : pyspGrdeCd */
  public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
   

	/** set 퇴직정산구분 : calcSevePayPsnDivNm */
	public void setCalcSevePayPsnDivNm(String  calcSevePayPsnDivNm) { set( ATTR_CALCSEVEPAYPSNDIVNM ,calcSevePayPsnDivNm);}
	/** get 퇴직정산구분 : calcSevePayPsnDivNm */
	public String  getCalcSevePayPsnDivNm() { return (String )get( ATTR_CALCSEVEPAYPSNDIVNM );}


    
/** set 직종세통합코드 : dtilOccuInttnCd */
public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
/** get 직종세통합코드 : dtilOccuInttnCd */
public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}



}
