package com.app.exterms.retirement.client.dto;



import java.math.BigDecimal;

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
public class Remt2400BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
    public static final String ATTR_CALCSEVEPAYPSNBLGGYR = "calcSevePayPsnBlggYr";

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

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";
    /** set 소득자임원여부 : aimenrEcteYn */
    public static final String ATTR_AIMENRECTEYN = "aimenrEcteYn";

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

    /** set 사업자등록번호 : busoprRgstnNum */
    public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";

    /** set 근무처명 : paeWorkNm */
    public static final String ATTR_PAEWORKNM = "paeWorkNm";

    /** set 퇴직급여액 : retryPayQnty */
    public static final String ATTR_RETRYPAYQNTY = "retryPayQnty";

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public static final String ATTR_FREEDTYRETRYPAYQNTY = "freeDtyRetryPayQnty";

    /** set 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
    public static final String ATTR_TXTNTGTRETRYPAYQNTY = "txtnTgtRetryPayQnty";

    /** set 입사일자 : icncDt */
    public static final String ATTR_ICNCDT = "icncDt";

    /** set 기산일자 : rkfcdDt */
    public static final String ATTR_RKFCDDT = "rkfcdDt";

    /** set 퇴사일자 : rsgtnDt */
    public static final String ATTR_RSGTNDT = "rsgtnDt";

    /** set 지급일자 : pymtDt */
    public static final String ATTR_PYMTDT = "pymtDt";

    /** set 근속월수 : logSvcMnthIcm */
    public static final String ATTR_LOGSVCMNTHICM = "logSvcMnthIcm";

    /** set 제외월수 : eepnMnthIcm */
    public static final String ATTR_EEPNMNTHICM = "eepnMnthIcm";

    /** set 가산월수 : addMnthIcm */
    public static final String ATTR_ADDMNTHICM = "addMnthIcm";

    /** set 중복월수 : dupMnthIcm */
    public static final String ATTR_DUPMNTHICM = "dupMnthIcm";

    /** set 근속연수 : logSvcYrNum */
    public static final String ATTR_LOGSVCYRNUM = "logSvcYrNum";

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

    /** set 퇴직소득_지급금액 : retryIncmPymtSum */
    public static final String ATTR_RETRYINCMPYMTSUM = "retryIncmPymtSum";

    /** set 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
    public static final String ATTR_RETRYINCMFXRTDDUCSUM = "retryIncmFxrtDducSum";

    /** set 근속년수공제금액 : logYrDducSum */
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

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    public static final String ATTR_PYMTREGTGTINCMTXQNTY = "pymtRegTgtIncmTxQnty";

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    public static final String ATTR_PYMTREGTGTRGONINCMQNTY = "pymtRegTgtRgonIncmQnty";

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    public static final String ATTR_PYMTREGTGTFARVILSPCLQNTY = "pymtRegTgtFarvilSpclQnty";

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    public static final String ATTR_PYMTREGRSTTGTAGGRSUM = "pymtRegrstTgtAggrSum";

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

    /** 생성자 */
     public Remt2400BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt2400BM(
    		 String  dpobCd 
    		, String  calcSevePayPsnBlggYr 
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
    		, String  busoprRgstnNum 
    		, String  paeWorkNm 
    		, BigDecimal  retryPayQnty 
    		, BigDecimal  freeDtyRetryPayQnty 
    		, BigDecimal  txtnTgtRetryPayQnty 
    		, String  icncDt 
    		, String  rkfcdDt 
    		, String  rsgtnDt 
    		, String  pymtDt 
    		, BigDecimal  logSvcMnthIcm 
    		, BigDecimal  eepnMnthIcm 
    		, BigDecimal  addMnthIcm 
    		, BigDecimal  dupMnthIcm 
    		, BigDecimal  logSvcYrNum 
    		, String  logPpnl12befIcncDt 
    		, String  logPpnl12befRkfcdDt 
    		, String  logPpnl12befRsgtnDt 
    		, String  logPpnl12befPymtDt 
    		, BigDecimal  logPpnl12befLogMnthIcm 
    		, BigDecimal  logPpnl12befEepnMnthIcm 
    		, BigDecimal  logPpnl12befAddMnthIcm 
    		, BigDecimal  logPpnl12befDupMnthIcm 
    		, BigDecimal  logPpnl12befLogYrNum 
    		, String  logPpnl13afrIcncDt 
    		, String  logPpnl13afrRkfcdDt 
    		, String  logPpnl13afrRsgtnDt 
    		, String  logPpnl13afrPymtDt 
    		, BigDecimal  logPpnl13afrLogMnthIcm 
    		, BigDecimal  logPpnl13afrEepnMnthIcm 
    		, BigDecimal  logPpnl13afrAddMnthIcm 
    		, BigDecimal  logPpnl13afrDupMnthIcm 
    		, BigDecimal  logPpnl13afrLogSvc 
    		, BigDecimal  retryIncmPymtSum 
    		, BigDecimal  retryIncmFxrtDducSum 
    		, BigDecimal  logYrDducSum 
    		, BigDecimal  retryTxtnStdClutSum 
    		, BigDecimal  tat12befTxtnStdPpnlSum 
    		, BigDecimal  tat12befYravgTxstdSum 
    		, BigDecimal  tat12befCvsnTxtnStdSum 
    		, BigDecimal  tat12befCvsnCalcAmnt 
    		, BigDecimal  tat12befYrAvgCalcAmnt 
    		, BigDecimal  tat12befCalcTxAmnt 
    		, BigDecimal  tat12befAlpayTxAmnt 
    		, BigDecimal  tat12befRegTgtTxAmnt 
    		, BigDecimal  tat13afrTxstdPpnlSum 
    		, BigDecimal  tat13afrYrAvgStdSum 
    		, BigDecimal  tat13afrCvsnTxtnStdSum 
    		, BigDecimal  tat13afrCvsnCalcTxAmnt 
    		, BigDecimal  tat13afrYrAvgCalcAmnt 
    		, BigDecimal  tat13afrAlpayTxAmnt 
    		, BigDecimal  tat13afrRegrstTgtSum 
    		, BigDecimal  tatAggrTxtnStdPpnlSum 
    		, BigDecimal  tatAggrYrAvgTxtnStdSum 
    		, BigDecimal  tatAggrCvsnTxtnStdSum 
    		, BigDecimal  tatAggrCvsnCalcTxAmnt 
    		, BigDecimal  tatAggrYrAvgCalcTxAmnt 
    		, BigDecimal  tatAggrCalcTxAmnt 
    		, BigDecimal  tatAggrAlpayTxAmnt 
    		, BigDecimal  tatAggrRegrstTgtTxAmnt 
    		, BigDecimal  pymtRegTgtIncmTxQnty 
    		, BigDecimal  pymtRegTgtRgonIncmQnty 
    		, BigDecimal  pymtRegTgtFarvilSpclQnty 
    		, BigDecimal  pymtRegrstTgtAggrSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_CALCSEVEPAYPSNBLGGYR,calcSevePayPsnBlggYr);
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
     	values.put(ATTR_BUSOPRRGSTNNUM,busoprRgstnNum);
     	values.put(ATTR_PAEWORKNM,paeWorkNm);
     	values.put(ATTR_RETRYPAYQNTY,retryPayQnty);
     	values.put(ATTR_FREEDTYRETRYPAYQNTY,freeDtyRetryPayQnty);
     	values.put(ATTR_TXTNTGTRETRYPAYQNTY,txtnTgtRetryPayQnty);
     	values.put(ATTR_ICNCDT,icncDt);
     	values.put(ATTR_RKFCDDT,rkfcdDt);
     	values.put(ATTR_RSGTNDT,rsgtnDt);
     	values.put(ATTR_PYMTDT,pymtDt);
     	values.put(ATTR_LOGSVCMNTHICM,logSvcMnthIcm);
     	values.put(ATTR_EEPNMNTHICM,eepnMnthIcm);
     	values.put(ATTR_ADDMNTHICM,addMnthIcm);
     	values.put(ATTR_DUPMNTHICM,dupMnthIcm);
     	values.put(ATTR_LOGSVCYRNUM,logSvcYrNum);
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
     	values.put(ATTR_RETRYINCMPYMTSUM,retryIncmPymtSum);
     	values.put(ATTR_RETRYINCMFXRTDDUCSUM,retryIncmFxrtDducSum);
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
     	values.put(ATTR_PYMTREGTGTINCMTXQNTY,pymtRegTgtIncmTxQnty);
     	values.put(ATTR_PYMTREGTGTRGONINCMQNTY,pymtRegTgtRgonIncmQnty);
     	values.put(ATTR_PYMTREGTGTFARVILSPCLQNTY,pymtRegTgtFarvilSpclQnty);
     	values.put(ATTR_PYMTREGRSTTGTAGGRSUM,pymtRegrstTgtAggrSum);
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

    /** set 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
    public void setCalcSevePayPsnBlggYr(String  calcSevePayPsnBlggYr) { set( ATTR_CALCSEVEPAYPSNBLGGYR ,calcSevePayPsnBlggYr);}
    /** get 퇴직정산귀속년월 : calcSevePayPsnBlggYr */
    public String  getCalcSevePayPsnBlggYr() { return (String )get( ATTR_CALCSEVEPAYPSNBLGGYR );}

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

    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    /** set 소득자임원여부 : aimenrEcteYn */
    public void setAimenrEcteYn(String  aimenrEcteYn) { set( ATTR_AIMENRECTEYN ,aimenrEcteYn);}
    /** get 소득자임원여부 : aimenrEcteYn */
    public String  getAimenrEcteYn() { return (String )get( ATTR_AIMENRECTEYN );}

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

    /** set 사업자등록번호 : busoprRgstnNum */
    public void setBusoprRgstnNum(String  busoprRgstnNum) { set( ATTR_BUSOPRRGSTNNUM ,busoprRgstnNum);}
    /** get 사업자등록번호 : busoprRgstnNum */
    public String  getBusoprRgstnNum() { return (String )get( ATTR_BUSOPRRGSTNNUM );}

    /** set 근무처명 : paeWorkNm */
    public void setPaeWorkNm(String  paeWorkNm) { set( ATTR_PAEWORKNM ,paeWorkNm);}
    /** get 근무처명 : paeWorkNm */
    public String  getPaeWorkNm() { return (String )get( ATTR_PAEWORKNM );}

    /** set 퇴직급여액 : retryPayQnty */
    public void setRetryPayQnty(BigDecimal  retryPayQnty) { set( ATTR_RETRYPAYQNTY ,retryPayQnty);}
    /** get 퇴직급여액 : retryPayQnty */
    public BigDecimal  getRetryPayQnty() { return (BigDecimal )get( ATTR_RETRYPAYQNTY );}

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public void setFreeDtyRetryPayQnty(BigDecimal  freeDtyRetryPayQnty) { set( ATTR_FREEDTYRETRYPAYQNTY ,freeDtyRetryPayQnty);}
    /** get 비과세퇴직급여액 : freeDtyRetryPayQnty */
    public BigDecimal  getFreeDtyRetryPayQnty() { return (BigDecimal )get( ATTR_FREEDTYRETRYPAYQNTY );}

    /** set 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
    public void setTxtnTgtRetryPayQnty(BigDecimal  txtnTgtRetryPayQnty) { set( ATTR_TXTNTGTRETRYPAYQNTY ,txtnTgtRetryPayQnty);}
    /** get 과세대상퇴직급여액 : txtnTgtRetryPayQnty */
    public BigDecimal  getTxtnTgtRetryPayQnty() { return (BigDecimal )get( ATTR_TXTNTGTRETRYPAYQNTY );}

    /** set 입사일자 : icncDt */
    public void setIcncDt(String  icncDt) { set( ATTR_ICNCDT ,icncDt);}
    /** get 입사일자 : icncDt */
    public String  getIcncDt() { return (String )get( ATTR_ICNCDT );}

    /** set 기산일자 : rkfcdDt */
    public void setRkfcdDt(String  rkfcdDt) { set( ATTR_RKFCDDT ,rkfcdDt);}
    /** get 기산일자 : rkfcdDt */
    public String  getRkfcdDt() { return (String )get( ATTR_RKFCDDT );}

    /** set 퇴사일자 : rsgtnDt */
    public void setRsgtnDt(String  rsgtnDt) { set( ATTR_RSGTNDT ,rsgtnDt);}
    /** get 퇴사일자 : rsgtnDt */
    public String  getRsgtnDt() { return (String )get( ATTR_RSGTNDT );}

    /** set 지급일자 : pymtDt */
    public void setPymtDt(String  pymtDt) { set( ATTR_PYMTDT ,pymtDt);}
    /** get 지급일자 : pymtDt */
    public String  getPymtDt() { return (String )get( ATTR_PYMTDT );}

    /** set 근속월수 : logSvcMnthIcm */
    public void setLogSvcMnthIcm(BigDecimal  logSvcMnthIcm) { set( ATTR_LOGSVCMNTHICM ,logSvcMnthIcm);}
    /** get 근속월수 : logSvcMnthIcm */
    public BigDecimal  getLogSvcMnthIcm() { return (BigDecimal )get( ATTR_LOGSVCMNTHICM );}

    /** set 제외월수 : eepnMnthIcm */
    public void setEepnMnthIcm(BigDecimal  eepnMnthIcm) { set( ATTR_EEPNMNTHICM ,eepnMnthIcm);}
    /** get 제외월수 : eepnMnthIcm */
    public BigDecimal  getEepnMnthIcm() { return (BigDecimal )get( ATTR_EEPNMNTHICM );}

    /** set 가산월수 : addMnthIcm */
    public void setAddMnthIcm(BigDecimal  addMnthIcm) { set( ATTR_ADDMNTHICM ,addMnthIcm);}
    /** get 가산월수 : addMnthIcm */
    public BigDecimal  getAddMnthIcm() { return (BigDecimal )get( ATTR_ADDMNTHICM );}

    /** set 중복월수 : dupMnthIcm */
    public void setDupMnthIcm(BigDecimal  dupMnthIcm) { set( ATTR_DUPMNTHICM ,dupMnthIcm);}
    /** get 중복월수 : dupMnthIcm */
    public BigDecimal  getDupMnthIcm() { return (BigDecimal )get( ATTR_DUPMNTHICM );}

    /** set 근속연수 : logSvcYrNum */
    public void setLogSvcYrNum(BigDecimal  logSvcYrNum) { set( ATTR_LOGSVCYRNUM ,logSvcYrNum);}
    /** get 근속연수 : logSvcYrNum */
    public BigDecimal  getLogSvcYrNum() { return (BigDecimal )get( ATTR_LOGSVCYRNUM );}

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
    public void setLogPpnl12befLogMnthIcm(BigDecimal  logPpnl12befLogMnthIcm) { set( ATTR_LOGPPNL12BEFLOGMNTHICM ,logPpnl12befLogMnthIcm);}
    /** get 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
    public BigDecimal  getLogPpnl12befLogMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL12BEFLOGMNTHICM );}

    /** set 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
    public void setLogPpnl12befEepnMnthIcm(BigDecimal  logPpnl12befEepnMnthIcm) { set( ATTR_LOGPPNL12BEFEEPNMNTHICM ,logPpnl12befEepnMnthIcm);}
    /** get 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
    public BigDecimal  getLogPpnl12befEepnMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL12BEFEEPNMNTHICM );}

    /** set 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
    public void setLogPpnl12befAddMnthIcm(BigDecimal  logPpnl12befAddMnthIcm) { set( ATTR_LOGPPNL12BEFADDMNTHICM ,logPpnl12befAddMnthIcm);}
    /** get 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
    public BigDecimal  getLogPpnl12befAddMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL12BEFADDMNTHICM );}

    /** set 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
    public void setLogPpnl12befDupMnthIcm(BigDecimal  logPpnl12befDupMnthIcm) { set( ATTR_LOGPPNL12BEFDUPMNTHICM ,logPpnl12befDupMnthIcm);}
    /** get 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
    public BigDecimal  getLogPpnl12befDupMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL12BEFDUPMNTHICM );}

    /** set 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    public void setLogPpnl12befLogYrNum(BigDecimal  logPpnl12befLogYrNum) { set( ATTR_LOGPPNL12BEFLOGYRNUM ,logPpnl12befLogYrNum);}
    /** get 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
    public BigDecimal  getLogPpnl12befLogYrNum() { return (BigDecimal )get( ATTR_LOGPPNL12BEFLOGYRNUM );}

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
    public void setLogPpnl13afrLogMnthIcm(BigDecimal  logPpnl13afrLogMnthIcm) { set( ATTR_LOGPPNL13AFRLOGMNTHICM ,logPpnl13afrLogMnthIcm);}
    /** get 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
    public BigDecimal  getLogPpnl13afrLogMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL13AFRLOGMNTHICM );}

    /** set 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
    public void setLogPpnl13afrEepnMnthIcm(BigDecimal  logPpnl13afrEepnMnthIcm) { set( ATTR_LOGPPNL13AFREEPNMNTHICM ,logPpnl13afrEepnMnthIcm);}
    /** get 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
    public BigDecimal  getLogPpnl13afrEepnMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL13AFREEPNMNTHICM );}

    /** set 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
    public void setLogPpnl13afrAddMnthIcm(BigDecimal  logPpnl13afrAddMnthIcm) { set( ATTR_LOGPPNL13AFRADDMNTHICM ,logPpnl13afrAddMnthIcm);}
    /** get 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
    public BigDecimal  getLogPpnl13afrAddMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL13AFRADDMNTHICM );}

    /** set 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
    public void setLogPpnl13afrDupMnthIcm(BigDecimal  logPpnl13afrDupMnthIcm) { set( ATTR_LOGPPNL13AFRDUPMNTHICM ,logPpnl13afrDupMnthIcm);}
    /** get 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
    public BigDecimal  getLogPpnl13afrDupMnthIcm() { return (BigDecimal )get( ATTR_LOGPPNL13AFRDUPMNTHICM );}

    /** set 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    public void setLogPpnl13afrLogSvc(BigDecimal  logPpnl13afrLogSvc) { set( ATTR_LOGPPNL13AFRLOGSVC ,logPpnl13afrLogSvc);}
    /** get 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
    public BigDecimal  getLogPpnl13afrLogSvc() { return (BigDecimal )get( ATTR_LOGPPNL13AFRLOGSVC );}

    /** set 퇴직소득_지급금액 : retryIncmPymtSum */
    public void setRetryIncmPymtSum(BigDecimal  retryIncmPymtSum) { set( ATTR_RETRYINCMPYMTSUM ,retryIncmPymtSum);}
    /** get 퇴직소득_지급금액 : retryIncmPymtSum */
    public BigDecimal  getRetryIncmPymtSum() { return (BigDecimal )get( ATTR_RETRYINCMPYMTSUM );}

    /** set 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
    public void setRetryIncmFxrtDducSum(BigDecimal  retryIncmFxrtDducSum) { set( ATTR_RETRYINCMFXRTDDUCSUM ,retryIncmFxrtDducSum);}
    /** get 퇴직소득정률공제금액 : retryIncmFxrtDducSum */
    public BigDecimal  getRetryIncmFxrtDducSum() { return (BigDecimal )get( ATTR_RETRYINCMFXRTDDUCSUM );}

    /** set 근속년수공제금액 : logYrDducSum */
    public void setLogYrDducSum(BigDecimal  logYrDducSum) { set( ATTR_LOGYRDDUCSUM ,logYrDducSum);}
    /** get 근속년수공제금액 : logYrDducSum */
    public BigDecimal  getLogYrDducSum() { return (BigDecimal )get( ATTR_LOGYRDDUCSUM );}

    /** set 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    public void setRetryTxtnStdClutSum(BigDecimal  retryTxtnStdClutSum) { set( ATTR_RETRYTXTNSTDCLUTSUM ,retryTxtnStdClutSum);}
    /** get 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
    public BigDecimal  getRetryTxtnStdClutSum() { return (BigDecimal )get( ATTR_RETRYTXTNSTDCLUTSUM );}

    /** set 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    public void setTat12befTxtnStdPpnlSum(BigDecimal  tat12befTxtnStdPpnlSum) { set( ATTR_TAT12BEFTXTNSTDPPNLSUM ,tat12befTxtnStdPpnlSum);}
    /** get 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
    public BigDecimal  getTat12befTxtnStdPpnlSum() { return (BigDecimal )get( ATTR_TAT12BEFTXTNSTDPPNLSUM );}

    /** set 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    public void setTat12befYravgTxstdSum(BigDecimal  tat12befYravgTxstdSum) { set( ATTR_TAT12BEFYRAVGTXSTDSUM ,tat12befYravgTxstdSum);}
    /** get 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
    public BigDecimal  getTat12befYravgTxstdSum() { return (BigDecimal )get( ATTR_TAT12BEFYRAVGTXSTDSUM );}

    /** set 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    public void setTat12befCvsnTxtnStdSum(BigDecimal  tat12befCvsnTxtnStdSum) { set( ATTR_TAT12BEFCVSNTXTNSTDSUM ,tat12befCvsnTxtnStdSum);}
    /** get 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
    public BigDecimal  getTat12befCvsnTxtnStdSum() { return (BigDecimal )get( ATTR_TAT12BEFCVSNTXTNSTDSUM );}

    /** set 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    public void setTat12befCvsnCalcAmnt(BigDecimal  tat12befCvsnCalcAmnt) { set( ATTR_TAT12BEFCVSNCALCAMNT ,tat12befCvsnCalcAmnt);}
    /** get 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
    public BigDecimal  getTat12befCvsnCalcAmnt() { return (BigDecimal )get( ATTR_TAT12BEFCVSNCALCAMNT );}

    /** set 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    public void setTat12befYrAvgCalcAmnt(BigDecimal  tat12befYrAvgCalcAmnt) { set( ATTR_TAT12BEFYRAVGCALCAMNT ,tat12befYrAvgCalcAmnt);}
    /** get 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
    public BigDecimal  getTat12befYrAvgCalcAmnt() { return (BigDecimal )get( ATTR_TAT12BEFYRAVGCALCAMNT );}

    /** set 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    public void setTat12befCalcTxAmnt(BigDecimal  tat12befCalcTxAmnt) { set( ATTR_TAT12BEFCALCTXAMNT ,tat12befCalcTxAmnt);}
    /** get 세액_2012전_산출세액 : tat12befCalcTxAmnt */
    public BigDecimal  getTat12befCalcTxAmnt() { return (BigDecimal )get( ATTR_TAT12BEFCALCTXAMNT );}

    /** set 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    public void setTat12befAlpayTxAmnt(BigDecimal  tat12befAlpayTxAmnt) { set( ATTR_TAT12BEFALPAYTXAMNT ,tat12befAlpayTxAmnt);}
    /** get 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
    public BigDecimal  getTat12befAlpayTxAmnt() { return (BigDecimal )get( ATTR_TAT12BEFALPAYTXAMNT );}

    /** set 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    public void setTat12befRegTgtTxAmnt(BigDecimal  tat12befRegTgtTxAmnt) { set( ATTR_TAT12BEFREGTGTTXAMNT ,tat12befRegTgtTxAmnt);}
    /** get 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
    public BigDecimal  getTat12befRegTgtTxAmnt() { return (BigDecimal )get( ATTR_TAT12BEFREGTGTTXAMNT );}

    /** set 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    public void setTat13afrTxstdPpnlSum(BigDecimal  tat13afrTxstdPpnlSum) { set( ATTR_TAT13AFRTXSTDPPNLSUM ,tat13afrTxstdPpnlSum);}
    /** get 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
    public BigDecimal  getTat13afrTxstdPpnlSum() { return (BigDecimal )get( ATTR_TAT13AFRTXSTDPPNLSUM );}

    /** set 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    public void setTat13afrYrAvgStdSum(BigDecimal  tat13afrYrAvgStdSum) { set( ATTR_TAT13AFRYRAVGSTDSUM ,tat13afrYrAvgStdSum);}
    /** get 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
    public BigDecimal  getTat13afrYrAvgStdSum() { return (BigDecimal )get( ATTR_TAT13AFRYRAVGSTDSUM );}

    /** set 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    public void setTat13afrCvsnTxtnStdSum(BigDecimal  tat13afrCvsnTxtnStdSum) { set( ATTR_TAT13AFRCVSNTXTNSTDSUM ,tat13afrCvsnTxtnStdSum);}
    /** get 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
    public BigDecimal  getTat13afrCvsnTxtnStdSum() { return (BigDecimal )get( ATTR_TAT13AFRCVSNTXTNSTDSUM );}

    /** set 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    public void setTat13afrCvsnCalcTxAmnt(BigDecimal  tat13afrCvsnCalcTxAmnt) { set( ATTR_TAT13AFRCVSNCALCTXAMNT ,tat13afrCvsnCalcTxAmnt);}
    /** get 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
    public BigDecimal  getTat13afrCvsnCalcTxAmnt() { return (BigDecimal )get( ATTR_TAT13AFRCVSNCALCTXAMNT );}

    /** set 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    public void setTat13afrYrAvgCalcAmnt(BigDecimal  tat13afrYrAvgCalcAmnt) { set( ATTR_TAT13AFRYRAVGCALCAMNT ,tat13afrYrAvgCalcAmnt);}
    /** get 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
    public BigDecimal  getTat13afrYrAvgCalcAmnt() { return (BigDecimal )get( ATTR_TAT13AFRYRAVGCALCAMNT );}

    /** set 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    public void setTat13afrAlpayTxAmnt(BigDecimal  tat13afrAlpayTxAmnt) { set( ATTR_TAT13AFRALPAYTXAMNT ,tat13afrAlpayTxAmnt);}
    /** get 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
    public BigDecimal  getTat13afrAlpayTxAmnt() { return (BigDecimal )get( ATTR_TAT13AFRALPAYTXAMNT );}

    /** set 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    public void setTat13afrRegrstTgtSum(BigDecimal  tat13afrRegrstTgtSum) { set( ATTR_TAT13AFRREGRSTTGTSUM ,tat13afrRegrstTgtSum);}
    /** get 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
    public BigDecimal  getTat13afrRegrstTgtSum() { return (BigDecimal )get( ATTR_TAT13AFRREGRSTTGTSUM );}

    /** set 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    public void setTatAggrTxtnStdPpnlSum(BigDecimal  tatAggrTxtnStdPpnlSum) { set( ATTR_TATAGGRTXTNSTDPPNLSUM ,tatAggrTxtnStdPpnlSum);}
    /** get 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
    public BigDecimal  getTatAggrTxtnStdPpnlSum() { return (BigDecimal )get( ATTR_TATAGGRTXTNSTDPPNLSUM );}

    /** set 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    public void setTatAggrYrAvgTxtnStdSum(BigDecimal  tatAggrYrAvgTxtnStdSum) { set( ATTR_TATAGGRYRAVGTXTNSTDSUM ,tatAggrYrAvgTxtnStdSum);}
    /** get 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
    public BigDecimal  getTatAggrYrAvgTxtnStdSum() { return (BigDecimal )get( ATTR_TATAGGRYRAVGTXTNSTDSUM );}

    /** set 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    public void setTatAggrCvsnTxtnStdSum(BigDecimal  tatAggrCvsnTxtnStdSum) { set( ATTR_TATAGGRCVSNTXTNSTDSUM ,tatAggrCvsnTxtnStdSum);}
    /** get 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
    public BigDecimal  getTatAggrCvsnTxtnStdSum() { return (BigDecimal )get( ATTR_TATAGGRCVSNTXTNSTDSUM );}

    /** set 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    public void setTatAggrCvsnCalcTxAmnt(BigDecimal  tatAggrCvsnCalcTxAmnt) { set( ATTR_TATAGGRCVSNCALCTXAMNT ,tatAggrCvsnCalcTxAmnt);}
    /** get 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
    public BigDecimal  getTatAggrCvsnCalcTxAmnt() { return (BigDecimal )get( ATTR_TATAGGRCVSNCALCTXAMNT );}

    /** set 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    public void setTatAggrYrAvgCalcTxAmnt(BigDecimal  tatAggrYrAvgCalcTxAmnt) { set( ATTR_TATAGGRYRAVGCALCTXAMNT ,tatAggrYrAvgCalcTxAmnt);}
    /** get 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
    public BigDecimal  getTatAggrYrAvgCalcTxAmnt() { return (BigDecimal )get( ATTR_TATAGGRYRAVGCALCTXAMNT );}

    /** set 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    public void setTatAggrCalcTxAmnt(BigDecimal  tatAggrCalcTxAmnt) { set( ATTR_TATAGGRCALCTXAMNT ,tatAggrCalcTxAmnt);}
    /** get 세액_합계_산출세액 : tatAggrCalcTxAmnt */
    public BigDecimal  getTatAggrCalcTxAmnt() { return (BigDecimal )get( ATTR_TATAGGRCALCTXAMNT );}

    /** set 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    public void setTatAggrAlpayTxAmnt(BigDecimal  tatAggrAlpayTxAmnt) { set( ATTR_TATAGGRALPAYTXAMNT ,tatAggrAlpayTxAmnt);}
    /** get 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
    public BigDecimal  getTatAggrAlpayTxAmnt() { return (BigDecimal )get( ATTR_TATAGGRALPAYTXAMNT );}

    /** set 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    public void setTatAggrRegrstTgtTxAmnt(BigDecimal  tatAggrRegrstTgtTxAmnt) { set( ATTR_TATAGGRREGRSTTGTTXAMNT ,tatAggrRegrstTgtTxAmnt);}
    /** get 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
    public BigDecimal  getTatAggrRegrstTgtTxAmnt() { return (BigDecimal )get( ATTR_TATAGGRREGRSTTGTTXAMNT );}

    /** set 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    public void setPymtRegTgtIncmTxQnty(BigDecimal  pymtRegTgtIncmTxQnty) { set( ATTR_PYMTREGTGTINCMTXQNTY ,pymtRegTgtIncmTxQnty);}
    /** get 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
    public BigDecimal  getPymtRegTgtIncmTxQnty() { return (BigDecimal )get( ATTR_PYMTREGTGTINCMTXQNTY );}

    /** set 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    public void setPymtRegTgtRgonIncmQnty(BigDecimal  pymtRegTgtRgonIncmQnty) { set( ATTR_PYMTREGTGTRGONINCMQNTY ,pymtRegTgtRgonIncmQnty);}
    /** get 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
    public BigDecimal  getPymtRegTgtRgonIncmQnty() { return (BigDecimal )get( ATTR_PYMTREGTGTRGONINCMQNTY );}

    /** set 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    public void setPymtRegTgtFarvilSpclQnty(BigDecimal  pymtRegTgtFarvilSpclQnty) { set( ATTR_PYMTREGTGTFARVILSPCLQNTY ,pymtRegTgtFarvilSpclQnty);}
    /** get 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
    public BigDecimal  getPymtRegTgtFarvilSpclQnty() { return (BigDecimal )get( ATTR_PYMTREGTGTFARVILSPCLQNTY );}

    /** set 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    public void setPymtRegrstTgtAggrSum(BigDecimal  pymtRegrstTgtAggrSum) { set( ATTR_PYMTREGRSTTGTAGGRSUM ,pymtRegrstTgtAggrSum);}
    /** get 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
    public BigDecimal  getPymtRegrstTgtAggrSum() { return (BigDecimal )get( ATTR_PYMTREGRSTTGTAGGRSUM );}

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


}
