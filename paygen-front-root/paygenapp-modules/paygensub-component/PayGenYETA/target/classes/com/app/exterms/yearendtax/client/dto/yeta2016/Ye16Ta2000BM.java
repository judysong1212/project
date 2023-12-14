package com.app.exterms.yearendtax.client.dto.yeta2016;



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
public class Ye16Ta2000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final Long serialVersionUID = 1L;
     

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */            
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd";
    
    /** set 정산구분 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 연말정산마감일련번호 : edacSeilNum */
    public static final String ATTR_EDACSEILNUM = "edacSeilNum";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 부서명 : deptNm */
 	public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
    
    /** set 직종세통합코드명 : dtilOccuInttnNm */
    public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";

    /** set 최초고용일자 : frstEmymtDt */
    public static final String ATTR_FRSTEMYMTDT = "frstEmymtDt";

    /** set 고용시작일자 : emymtBgnnDt */
    public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

    /** set 고용종료일자 : emymtEndDt */
    public static final String ATTR_EMYMTENDDT = "emymtEndDt";

    /** set 재직구분코드 : hdofcDivCd */
    public static final String ATTR_HDOFCDIVCD = "hdofcDivCd";
    
    /** set 재직구분 : hdofcDivNm */
    public static final String ATTR_HDOFCDIVNM = "hdofcDivNm";

    /** set 퇴직일자 : retryDt */
    public static final String ATTR_RETRYDT = "retryDt";

    /** set 연말정산적용년월 : yrtxApptnYrMnth */
    public static final String ATTR_YRTXAPPTNYRMNTH = "yrtxApptnYrMnth";

    /** set 연말정산처리일자 : yrtxPrcsDt */
    public static final String ATTR_YRTXPRCSDT = "yrtxPrcsDt";

    /** set 연말정산처리여부 : yrtxPrcsYn */
    public static final String ATTR_YRTXPRCSYN = "yrtxPrcsYn";

    /** set 분할납부구분코드 : divdPymtDivCd */
    public static final String ATTR_DIVDPYMTDIVCD = "divdPymtDivCd";

    /** set 분할납부횟수 : divdPymt */
    public static final String ATTR_DIVDPYMT = "divdPymt";

    /** set 세대주여부 : gnanSgtf */
    public static final String ATTR_GNANSGTF = "gnanSgtf";

    /** set 외국인구분코드 : frnrYeno */
    public static final String ATTR_FRNRYENO = "frnrYeno";

    /** set 귀속년월_FROM : reymStdt */
    public static final String ATTR_REYMSTDT = "reymStdt";

    /** set 귀속년월_TO : reymEddt */
    public static final String ATTR_REYMEDDT = "reymEddt";

    /** set 감면기간_TO : rutrEddt */
    public static final String ATTR_RUTREDDT = "rutrEddt";

    /** set 감면기간_FROM : rutrStdt */
    public static final String ATTR_RUTRSTDT = "rutrStdt";

    /** set 거주구분여부 : resdFlag */
    public static final String ATTR_RESDFLAG = "resdFlag";

    /** set 국적코드 : natnGbcd */
    public static final String ATTR_NATNGBCD = "natnGbcd";
    
    /** set 국적코드 : NatnItem */
    public static final String ATTR_NATNITEM = "natnItem";
    
    /** set 국적명 : natnName */
    public static final String ATTR_NATNNAME = "natnName";

    /** set 거주지국코드 : redtGbcd */
    public static final String ATTR_REDTGBCD = "redtGbcd";

    /** set 거주지국명 : redtName */
    public static final String ATTR_REDTNAME = "redtName";
    
    /** set 거주지국코드(11자리) : redtName */
    public static final String ATTR_REDTITEM = "redtItem";
    
    /** set 인적공제항목변동여부 : humnCgue */
    public static final String ATTR_HUMNCGUE = "humnCgue";

    /** set 외국인단일세율적용여부 : frnrSgyn */
    public static final String ATTR_FRNRSGYN = "frnrSgyn";

    /** set 기본공제_배우자유무 : baseWiyn */
    public static final String ATTR_BASEWIYN = "baseWiyn";

    /** set 기본공제_부양가족수 : baseFmly */
    public static final String ATTR_BASEFMLY = "baseFmly";

    /** set 추가공제_경로우대_70세이상수 : addrCt70 */
    public static final String ATTR_ADDRCT70 = "addrCt70";

    /** set 추가공제_장애인수 : addrHdrc */
    public static final String ATTR_ADDRHDRC = "addrHdrc";

    /** set 추가공제_부녀자수 : addrFdsu */
    public static final String ATTR_ADDRFDSU = "addrFdsu";

    /** set 추가공제_자녀양육비양육수 : addrClct */
    public static final String ATTR_ADDRCLCT = "addrClct";

    /** set 추가공제_출산자녀양육수 : addrBhct */
    public static final String ATTR_ADDRBHCT = "addrBhct";

    /** set 추가공제_한부모수 : pantOnsu */
    public static final String ATTR_PANTONSU = "pantOnsu";

    /** set 추가공제_다자녀인원수 : addrMrct */
    public static final String ATTR_ADDRMRCT = "addrMrct";

    /** set 종근무지_국민연금보험료 : bnatPsnf */
    public static final String ATTR_BNATPSNF = "bnatPsnf";

    /** set 주근무지_국민연금보험료 : jnatPsnf */
    public static final String ATTR_JNATPSNF = "jnatPsnf";

    /** set 종근무지_국민연금외교직원연금 : bpssTech */
    public static final String ATTR_BPSSTECH = "bpssTech";

    /** set 종근무지_국민연금외공무원연금 : bpssPulc */
    public static final String ATTR_BPSSPULC = "bpssPulc";

    /** set 종근무지_국민연금외별정우체국 : bpssFect */
    public static final String ATTR_BPSSFECT = "bpssFect";

    /** set 종근무지_국민연금외군인연금 : bpssSold */
    public static final String ATTR_BPSSSOLD = "bpssSold";

    /** set 주근무지_국민연금외공무원연금 : jpssPulc */
    public static final String ATTR_JPSSPULC = "jpssPulc";

    /** set 주근무지_국민연금외군인연금 : jpssSold */
    public static final String ATTR_JPSSSOLD = "jpssSold";

    /** set 주근무지_국인연금외교직원연금 : jpssTech */
    public static final String ATTR_JPSSTECH = "jpssTech";

    /** set 주근무지_국민연금외별정우체국 : jpssFect */
    public static final String ATTR_JPSSFECT = "jpssFect";

    /** set 종근무지_종_근로자퇴직보장법 : brtrPsct */
    public static final String ATTR_BRTRPSCT = "brtrPsct";

    /** set 종근무지_종_과학기술인공제 : brtrCict */
    public static final String ATTR_BRTRCICT = "brtrCict";

    /** set 종근무지_연금계좌_연금저축 : brtrAnsv */
    public static final String ATTR_BRTRANSV = "brtrAnsv";

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrCict */
    public static final String ATTR_JRTRCICT = "jrtrCict";

    /** set 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
    public static final String ATTR_JRTRCTAR = "jrtrCtar";

    /** set 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
    public static final String ATTR_JRTRPSCT = "jrtrPsct";

    /** set 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
    public static final String ATTR_JRTRPTAR = "jrtrPtar";

    /** set 주근무지_연금계좌_연금저축 : jrtrAnsv */
    public static final String ATTR_JRTRANSV = "jrtrAnsv";

    /** set 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
    public static final String ATTR_JRTRATAR = "jrtrAtar";

    /** set 연금보험료계 : rrptAmnt */
    public static final String ATTR_RRPTAMNT = "rrptAmnt";

    /** set 특별공제_종건강보험료 : spciBhlh */
    public static final String ATTR_SPCIBHLH = "spciBhlh";

    /** set 특별공제_주건강보험료 : spciHhlh */
    public static final String ATTR_SPCIHHLH = "spciHhlh";

    /** set 특별공제_종고용보험료 : spciBepf */
    public static final String ATTR_SPCIBEPF = "spciBepf";

    /** set 특별공제_주고용보험료 : spciJepf */
    public static final String ATTR_SPCIJEPF = "spciJepf";

    /** set 특별공제_일반보장성보험료 : spciGurt */
    public static final String ATTR_SPCIGURT = "spciGurt";

    /** set 특별공제_장애인전용보험료 : spciHdrc */
    public static final String ATTR_SPCIHDRC = "spciHdrc";

    /** set 특별공제_보장성보험료공제대상금액 : spciRttg */
    public static final String ATTR_SPCIRTTG = "spciRttg";

    /** set 특별공제_보험료계 : spciIuam */
    public static final String ATTR_SPCIIUAM = "spciIuam";

    /** set 특별공제_의료비_본인 : spciSelf */
    public static final String ATTR_SPCISELF = "spciSelf";

    /** set 특별공제_의료비_경로65세이상 : spciAe65 */
    public static final String ATTR_SPCIAE65 = "spciAe65";

    /** set 특별공제_의료비_장애인 : spciDbps */
    public static final String ATTR_SPCIDBPS = "spciDbps";

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public static final String ATTR_SPCIDETC = "spciDetc";

    /** set 특별공제_의료비세액공제대상금액 : spciDtar */
    public static final String ATTR_SPCIDTAR = "spciDtar";

    /** set 특별공제_의료비계 : spciEtam */
    public static final String ATTR_SPCIETAM = "spciEtam";

    /** set 특별공제_교육비_본인 : spedSelf */
    public static final String ATTR_SPEDSELF = "spedSelf";

    /** set 특별공제_교육비_취학전아동수 : spedEdsu */
    public static final String ATTR_SPEDEDSU = "spedEdsu";

    /** set 특별공제_교육비_취학전아동 : spedEdam */
    public static final String ATTR_SPEDEDAM = "spedEdam";

    /** set 특별공제_교육비_초중고자녀수 : spedGdsu */
    public static final String ATTR_SPEDGDSU = "spedGdsu";

    /** set 특별공제_교육비_초중고 : spedGdam */
    public static final String ATTR_SPEDGDAM = "spedGdam";

    /** set 특별공제_교육비_대학생수 : spedCvsu */
    public static final String ATTR_SPEDCVSU = "spedCvsu";

    /** set 특별공제_교육비_대학교 : spedCvam */
    public static final String ATTR_SPEDCVAM = "spedCvam";

    /** set 특별공제_장애인수 : spciScsu */
    public static final String ATTR_SPCISCSU = "spciScsu";

    /** set 특별공제_장애인특수교육비 : spciScam */
    public static final String ATTR_SPCISCAM = "spciScam";

    /** set 특별공제_교육비공제대상금액 : spedEtar */
    public static final String ATTR_SPEDETAR = "spedEtar";

    /** set 특별공제_교육비계 : siedToam */
    public static final String ATTR_SIEDTOAM = "siedToam";

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public static final String ATTR_SPCIREFN = "spciRefn";

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public static final String ATTR_SPCIRESF = "spciResf";

    /** set 특별공제_주택자금_월세금액 : spciHtam */
    public static final String ATTR_SPCIHTAM = "spciHtam";

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    public static final String ATTR_SPCHREFN = "spchRefn";

    /** set 특별공제_11장기주택저당차입금15 : spchRe06 */
    public static final String ATTR_SPCHRE06 = "spchRe06";

    /** set 특별공제_11장기주택저당차입금29 : spchRe10 */
    public static final String ATTR_SPCHRE10 = "spchRe10";

    /** set 특별공제_11장기주택저당차입금30 : spchRe20 */
    public static final String ATTR_SPCHRE20 = "spchRe20";

    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public static final String ATTR_SPCHREFX = "spchRefx";

    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    public static final String ATTR_SPCHREEC = "spchReec";

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
    public static final String ATTR_SPCH15FX = "spch15fx";

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
    public static final String ATTR_SPCH15FB = "spch15fb";

    /** set 특별공제_15장기주택저당_15기타대출 : spch15ec */
    public static final String ATTR_SPCH15EC = "spch15ec";

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
    public static final String ATTR_SPCH10FB = "spch10fb";

    /** set 특별공제_15장기주택저당_10기타대출 : spch10ec */
    public static final String ATTR_SPCH10EC = "spch10ec";

    /** set 세액공제_기부정치자금금액 : taxdPltc */
    public static final String ATTR_TAXDPLTC = "taxdPltc";

    /** set 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
    public static final String ATTR_TAXD10TG = "taxd10tg";

    /** set 특별공제_기부금_정치 : spciPltc */
    public static final String ATTR_SPCIPLTC = "spciPltc";

    /** set 특별공제_기부금_정치10초과대상금액 : spciPltg */
    public static final String ATTR_SPCIPLTG = "spciPltg";

    /** set 특별공제_기부금_법정 : spciFbam */
    public static final String ATTR_SPCIFBAM = "spciFbam";
    

/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public static final String ATTR_ETGDD14B = "etgdD14b";

    /** set 특별공제_기부금_법정대상금액 : spciFbtg */
    public static final String ATTR_SPCIFBTG = "spciFbtg";

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public static final String ATTR_SPCIEXAM = "spciExam";

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public static final String ATTR_SPCIUNON = "spciUnon";

    /** set 특별공제_기부금_우리사주조합2015이후 : spciHfam */
    public static final String ATTR_SPCIHFAM = "spciHfam";

    /** set 특별공제_기부금_종교단체 : spciYamt */
    public static final String ATTR_SPCIYAMT = "spciYamt";

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public static final String ATTR_SPCINAMT = "spciNamt";

    /** set 특별공제_지정기부금대상금액 : spciDgtg */
    public static final String ATTR_SPCIDGTG = "spciDgtg";

    /** set 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
    public static final String ATTR_SPCIFNRL = "spciFnrl";

    /** set 개인연금저축불입액_2000년이전 : prvm20be */
    public static final String ATTR_PRVM20BE = "prvm20be";

    /** set 개인연금저축불입액_2001년이후_삭제 : prvm21af */
    public static final String ATTR_PRVM21AF = "prvm21af";

    /** set 기타공제_소기업공제불입금액 : etchPrep */
    public static final String ATTR_ETCHPREP = "etchPrep";

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public static final String ATTR_ETCSCOMP = "etcsComp";

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
    public static final String ATTR_ETWKHSVM = "etwkHsvm";

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
    public static final String ATTR_ETWKHSBM = "etwkHsbm";

    /** set 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
    public static final String ATTR_ETWKHLGM = "etwkHlgm";

    /** set 기타공제_주택마련저축소득금액 : etwkHbdm */
    public static final String ATTR_ETWKHBDM = "etwkHbdm";

    /** set 기타공제_투자조합출자금액_2011이전 : etctConc */
    public static final String ATTR_ETCTCONC = "etctConc";

    /** set 기타공제_투자조합출자금액_2012년도 : etgdH09f */
    public static final String ATTR_ETGDH09F = "etgdH09f";

    /** set 기타공제_투자조합출자금액_2013년도 : etgdH13f */
    public static final String ATTR_ETGDH13F = "etgdH13f";

    /** set 기타공제_투자조합출자금액_2014년도 : etgdH14f */
    public static final String ATTR_ETGDH14F = "etgdH14f";

    /** set 기타공제_투자조합출자금액_2015년이후 : etclH15f */
    public static final String ATTR_ETCLH15F = "etclH15f";

    /** set 기타공제투자조합출자금액계 : etgdHdam */
    public static final String ATTR_ETGDHDAM = "etgdHdam";

    /** set 기타공제_신용카드등사용금액 : etctCard */
    public static final String ATTR_ETCTCARD = "etctCard";

    /** set 기타공제_직불카드등사용금액 : etchBcbs */
    public static final String ATTR_ETCHBCBS = "etchBcbs";

    /** set 기타공제_현금영수증사용금액 : etchUeam */
    public static final String ATTR_ETCHUEAM = "etchUeam";

    /** set 기타공제_전통시장사용분 : etchMgvd */
    public static final String ATTR_ETCHMGVD = "etchMgvd";

    /** set 기타공제_지로납부_대중교통금액 : etchBced */
    public static final String ATTR_ETCHBCED = "etchBced";

    /** set 기타공제_본인신용카드등사용액_2013 : cardEt13 */
    public static final String ATTR_CARDET13 = "cardEt13";

    /** set 기타공제_본인신용카드등사용액_2014 : cardEt14 */
    public static final String ATTR_CARDET14 = "cardEt14";

    /** set 기타공제_본인추가공재율사용액_2013 : etadDd13 */
    public static final String ATTR_ETADDD13 = "etadDd13";

    /** set 기타공제_본인추가공제율사용액_2014하 : etadD14l */
    public static final String ATTR_ETADD14L = "etadD14l";

    /** set 기타공제_신용카드등사용공제계 : etchBcue */
    public static final String ATTR_ETCHBCUE = "etchBcue";

    /** set 기타공제_우리사주출연금액 : etckUnon */
    public static final String ATTR_ETCKUNON = "etckUnon";

    /** set 기타공제_우리사주조합기부금2014이전 : etckUncb */
    public static final String ATTR_ETCKUNCB = "etckUncb";

    /** set 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
    public static final String ATTR_ETEPHSAM = "etepHsam";

    /** set 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
    public static final String ATTR_ETGDCTRA = "etgdCtra";

    /** set 기타공제_장기집합투자증권저축금액 : etepSest */
    public static final String ATTR_ETEPSEST = "etepSest";

    /** set 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
    public static final String ATTR_ETCLHM01 = "etclHm01";

    /** set 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
    public static final String ATTR_ETCLHM02 = "etclHm02";

    /** set 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
    public static final String ATTR_ETCLHM03 = "etclHm03";

    /** set 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
    public static final String ATTR_ETCLHMTA = "etclHmta";

    /** set 기타공제_기타제목 : etclEttl */
    public static final String ATTR_ETCLETTL = "etclEttl";

    /** set 기타공제_기타금액 : etclEtam */
    public static final String ATTR_ETCLETAM = "etclEtam";

    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public static final String ATTR_TAXDINCD = "taxdIncd";
    
    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public static final String ATTR_TAXDINCD1 = "taxdIncd1";
    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public static final String ATTR_TAXDINCD2 = "taxdIncd2";
    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public static final String ATTR_TAXDINCD3 = "taxdIncd3";
    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public static final String ATTR_TAXDINCD4 = "taxdIncd4";

    /** set 세액공제_외국인_근로제공일자 : taxdWkdt */
    public static final String ATTR_TAXDWKDT = "taxdWkdt";

    /** set 세액공제_외국인_감면기간만료일자 : tamaEddt */
    public static final String ATTR_TAMAEDDT = "tamaEddt";

    /** set 세액공제_외국인_감면신청접수일자 : tamaIndt */
    public static final String ATTR_TAMAINDT = "tamaIndt";

    /** set 세액공제_외국인_감면신청제출일자 : tamaOudt */
    public static final String ATTR_TAMAOUDT = "tamaOudt";

    /** set 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
    public static final String ATTR_TXLGFRRD = "txlgFrrd";

    /** set 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
    public static final String ATTR_TXLGFRID = "txlgFrid";

    /** set 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
    public static final String ATTR_TXLGWKID = "txlgWkid";

    /** set 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
    public static final String ATTR_TXLGTXTD = "txlgTxtd";

    /** set 세액공제_중소기업청년감면취업일자 : txlgBscd */
    public static final String ATTR_TXLGBSCD = "txlgBscd";

    /** set 세액공제_중소기업청년감면종료일자 : txlgBcde */
    public static final String ATTR_TXLGBCDE = "txlgBcde";

    /** set 세액감면_소득세법감면세액 : txlgItct */
    public static final String ATTR_TXLGITCT = "txlgItct";

    /** set 세액감면_취업청년감면대상총급여액 : txlgBsta */
    public static final String ATTR_TXLGBSTA = "txlgBsta";

    /** set 세액감면_취업청년감면근로자총급여액 : txlgWkta */
    public static final String ATTR_TXLGWKTA = "txlgWkta";

    /** set 세액감면_계산감면세액금액 : txlgClta */
    public static final String ATTR_TXLGCLTA = "txlgClta";

    /** set 세액감면_외국인기술자감면세액 : txlgFrta */
    public static final String ATTR_TXLGFRTA = "txlgFrta";

    /** set 세액감면_조세조약감면세액 : txlgTxty */
    public static final String ATTR_TXLGTXTY = "txlgTxty";

    /** set 세액공제_외국납부_국외원천소득금액 : txlgInam */
    public static final String ATTR_TXLGINAM = "txlgInam";

    /** set 세액공제_외국납부_외화납세액 : txlgDlam */
    public static final String ATTR_TXLGDLAM = "txlgDlam";

    /** set 세액공제_외국납부_원화납세액 : txlgWnam */
    public static final String ATTR_TXLGWNAM = "txlgWnam";

    /** set 세액공제_외국납부_납세국명 : txlgOtcy */
    public static final String ATTR_TXLGOTCY = "txlgOtcy";

    /** set 세액공제_외국납부_납부일자 : txlgOtdt */
    public static final String ATTR_TXLGOTDT = "txlgOtdt";

    /** set 세액공제_외국납부_신청서제출일자 : txlgApdt */
    public static final String ATTR_TXLGAPDT = "txlgApdt";

    /** set 세액공제_외국납부_국외근무처명 : txlgOuwk */
    public static final String ATTR_TXLGOUWK = "txlgOuwk";

    /** set 세액공제_외국납부_근무시작일자 : txapStdt */
    public static final String ATTR_TXAPSTDT = "txapStdt";

    /** set 세액공제_외국납부_근무종료일자 : txapEddt */
    public static final String ATTR_TXAPEDDT = "txapEddt";

    /** set 세액공제_외국납부_직책 : txapWkdy */
    public static final String ATTR_TXAPWKDY = "txapWkdy";

    /** set 세액공제_납세조합공제 : taxdUnin */
    public static final String ATTR_TAXDUNIN = "taxdUnin";
    
    /** set 세액공제_납세조합공제 : taxdUnin */
    public static final String ATTR_TAXDUNIN01 = "taxdUnin01";

    /** set 세액공제_주택차입금이자상황금액 : taxdLoaa */
    public static final String ATTR_TAXDLOAA = "taxdLoaa";

    /** set 추가서류_연금저축등소득공제제출여부 : addcNtyn */
    public static final String ATTR_ADDCNTYN = "addcNtyn";

    /** set 추가서류_의료비지급명세서제출여부 : addcMdyn */
    public static final String ATTR_ADDCMDYN = "addcMdyn";

    /** set 추가서류_기부금명세서제출여부 : addcCtyn */
    public static final String ATTR_ADDCCTYN = "addcCtyn";

    /** set 추가서류_소득공제증빙서류제출여부 : addcPfyn */
    public static final String ATTR_ADDCPFYN = "addcPfyn";

    /** set 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
    public static final String ATTR_ADDFPVYN = "addfPvyn";

    /** set 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
    public static final String ATTR_SPCIREYN = "spciReyn";

    /** set 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
    public static final String ATTR_TXLGMXTM = "txlgMxtm";

    /** set 소득신고제출일자 : incoOudt */
    public static final String ATTR_INCOOUDT = "incoOudt";

    /** set 소득신고제출여부 : incoOufg */
    public static final String ATTR_INCOOUFG = "incoOufg";

    /** set 파일생성여부 : jdocFile */
    public static final String ATTR_JDOCFILE = "jdocFile";
    
    /** set 파일생성여부 : jdocFile */
    public static final String ATTR_JDOCFNNM = "jdocFnnm";
    

    /** set 연금계좌계 : jrtrAtom */
    public static final String ATTR_JRTRATOM = "jrtrAtom";

    /** set 연금계좌공제대상금액 : jrtrTotr */
    public static final String ATTR_JRTRTOTR = "jrtrTotr";

    /** set 특별공제_장애인보장성대상금액 : spciHdtg */
    public static final String ATTR_SPCIHDTG = "spciHdtg";

    /** set 특별공제_보장성보험료대상금액 : spciDetg */
    public static final String ATTR_SPCIDETG = "spciDetg";

    /** set 특별공제_보장성보험료계 : spciRtto */
    public static final String ATTR_SPCIRTTO = "spciRtto";

    /** set 본인의료비공제대상금액 : spciSftg */
    public static final String ATTR_SPCISFTG = "spciSftg";

    /** set 65세이상자의료비공제대상금액 : spci65tg */
    public static final String ATTR_SPCI65TG = "spci65tg";

    /** set 장애인의료비공제대상금액 : spciPstg */
    public static final String ATTR_SPCIPSTG = "spciPstg";

    /** set 그밖의의료비공제대상금액 : spciEtcg */
    public static final String ATTR_SPCIETCG = "spciEtcg";

    /** set 소득자본인교육비대상금액 : spedSftr */
    public static final String ATTR_SPEDSFTR = "spedSftr";

    /** set 취학전아동교육비대상금액 : spedEdtr */
    public static final String ATTR_SPEDEDTR = "spedEdtr";

    /** set 초중고교육비대상금액 : spedGdtr */
    public static final String ATTR_SPEDGDTR = "spedGdtr";

    /** set 대학생교육비대상금액 : spedCvtr */
    public static final String ATTR_SPEDCVTR = "spedCvtr";

    /** set 특수교육비공제대상금액 : spciSctr */
    public static final String ATTR_SPCISCTR = "spciSctr";

    /** set 특례기부금_공익법인제외대상금액 : spciExtg */
    public static final String ATTR_SPCIEXTG = "spciExtg";

    /** set 공익법인신탁대상금액 : spciUntg */
    public static final String ATTR_SPCIUNTG = "spciUntg";

    /** set 우리사주종합기부대상금액 : spciHftg */
    public static final String ATTR_SPCIHFTG = "spciHftg";

    /** set 종교단체외지정대상금액 : spciNatg */
    public static final String ATTR_SPCINATG = "spciNatg";

    /** set 종교단체지정대상금액 : spciYatg */
    public static final String ATTR_SPCIYATG = "spciYatg";

    /** set 기부금합계금액 : spciDgam */
    public static final String ATTR_SPCIDGAM = "spciDgam";

    /** set 이월특례기부금_공익신탁금액 : spciOnon */
    public static final String ATTR_SPCIONON = "spciOnon";

    /** set 이월법정기부금액 : spciObam */
    public static final String ATTR_SPCIOBAM = "spciObam";

    /** set 이월종교단체기부금 : spciOyam */
    public static final String ATTR_SPCIOYAM = "spciOyam";

    /** set 이월종교단체외기부금 : spciOnam */
    public static final String ATTR_SPCIONAM = "spciOnam";

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
    
    /** set 기타공제_본인신용카등사용액_2015 : cardEt15*/
    public static final String ATTR_CARDET15 = "cardEt15";

    /** set 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
    public static final String ATTR_ETADD15H = "etadD15h";

    /** 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
    public static final String ATTR_ETADD15L = "etadD15l";
     

    /** set 이전근무지_소득세 : dcsnItax */
    public static final String ATTR_DCSNITAX = "dcsnItax";

    /** set 이전근무지_주민세_지방소득세 : dcsnBtax */
    public static final String ATTR_DCSNBTAX = "dcsnBtax";

    /** set 이전근무지_농특세 : fafvTaxi */
    public static final String ATTR_FAFVTAXI = "fafvTaxi";

    /** set 주근무지총급여액 : currTots */
    public static final String ATTR_CURRTOTS = "currTots";
    /** set 종합소득과세표준 : stndIncm */
    public static final String ATTR_STNDINCM = "stndIncm";

    /** set 산출세액 : prddTaxn */
    public static final String ATTR_PRDDTAXN = "prddTaxn";
    
 
    /** set 난임수술비용 : ctifTram */
    public static final String ATTR_CTIFTRAM = "ctifTram";

    /** set 법정기부금2014금액 : spciOb14 */
    public static final String ATTR_SPCIOB14 = "spciOb14";

    /** set 종교단체2014금액 : spciOy14 */
    public static final String ATTR_SPCIOY14 = "spciOy14";

    /** set 종교단체외2014금액 : spciOn14 */
    public static final String ATTR_SPCION14 = "spciOn14";

    /** set 법정기부금2014대상금액 : spciFb14 */
    public static final String ATTR_SPCIFB14 = "spciFb14";

    /** set 종교단체2014대상금액 : spciYa14 */
    public static final String ATTR_SPCIYA14 = "spciYa14";

    /** set 총교단체외2014대상금액 : spciNa14 */
    public static final String ATTR_SPCINA14 = "spciNa14";

    /** set 분납납부금액 : divdPymtAmnt */
    public static final String ATTR_DIVDPYMTAMNT = "divdPymtAmnt";

    /** set 연말정산분할납부신청여부 : yrenSgyn */
    public static final String ATTR_YRENSGYN = "yrenSgyn";

    /** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    public static final String ATTR_ADDINCMTXAPPTNRTOCD = "addIncmTxApptnRtoCd";

    /** set 외국인법인소속파견근로자여부 : frnrRnyn */
    public static final String ATTR_FRNRRNYN = "frnrRnyn";

    /** set 기타공제_투자조합출자금액_14_벤처 : etgdH14b */
    public static final String ATTR_ETGDH14B = "etgdH14b";

    /** set 기타공제_투자조합출자금액_15_벤처 : etclH15b */
    public static final String ATTR_ETCLH15B = "etclH15b";

    /** set 기타공제_투자조합출자금액_16_조합 : etclH16f */
    public static final String ATTR_ETCLH16F = "etclH16f";

    /** set 기타공제_투자조합출자금액_16_벤처 : etclH16b */
    public static final String ATTR_ETCLH16B = "etclH16b";

    /** set 기타공제_본인추가공제율사용액_2016상 : etadD16l */
    public static final String ATTR_ETADD16L = "etadD16l";
 
    /** set 원천징수의무부서코드 : yetaDpcd */
    public static final String ATTR_YETADPCD = "yetaDpcd";
    
    /** set 원천징수의무부서코드 : yetaDpNm */
    public static final String ATTR_YETADPNM = "yetaDpNm";
    

	/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
	public static final String ATTR_ETGDD15B = "etgdD15b";
	
	/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
	public static final String ATTR_ETGDD16F = "etgdD16f";
	
	/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
	public static final String ATTR_ETGDD16B = "etgdD16b";
	
	/** set 마감여부 : closFlag */
	public static final String ATTR_CLOSFLAG = "closFlag";

	/** set 마감일자 : closDate */
	public static final String ATTR_CLOSDATE = "closDate";

	/** set 마감여부 : closFlag */
	public void setClosFlag(String  closFlag) { set( ATTR_CLOSFLAG ,closFlag);}
	/** get 마감여부 : closFlag */
	public String  getClosFlag() { return (String )get( ATTR_CLOSFLAG );}
	/** set 마감일자 : closDate */
	public void setClosDate(String  closDate) { set( ATTR_CLOSDATE ,closDate);}
	/** get 마감일자 : closDate */
	public String  getClosDate() { return (String )get( ATTR_CLOSDATE );}

    /** 생성자 */
     public Ye16Ta2000BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta2000BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, String  edacSeilNum 
    		, String  payrMangDeptCd 
    		, String  emymtDivCd 
    		, String  hanNm 
    		, String  resnRegnNum 
    		, String  deptCd 
    		, String  businCd 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, String  dtilOccuClsDivCd 
    		, String  odtyCd 
    		, String  pyspCd 
    		, String  pyspGrdeCd 
    		, String  logSvcYrNumCd 
    		, String  logSvcMnthIcmCd 
    		, String  frstEmymtDt 
    		, String  emymtBgnnDt 
    		, String  emymtEndDt 
    		, String  hdofcDivCd 
    		, String  retryDt 
    		, String  yrtxApptnYrMnth 
    		, String  yrtxPrcsDt 
    		, String  yrtxPrcsYn 
    		, String  divdPymtDivCd 
    		, String  divdPymt 
    		, String  gnanSgtf 
    		, String  frnrYeno 
    		, String  reymStdt 
    		, String  reymEddt 
    		, String  rutrEddt 
    		, String  rutrStdt 
    		, String  resdFlag 
    		, String  natnGbcd 
    		, String  natnName 
    		, String  redtGbcd 
    		, String  redtName 
    		, String  humnCgue 
    		, String  frnrSgyn 
    		, String  baseWiyn 
    		, String  baseFmly 
    		, String  addrCt70 
    		, String  addrHdrc 
    		, String  addrFdsu 
    		, String  addrClct 
    		, String  addrBhct 
    		, String  pantOnsu 
    		, String  addrMrct 
    		, String  bnatPsnf 
    		, String  jnatPsnf 
    		, String  bpssTech 
    		, String  bpssPulc 
    		, String  bpssFect 
    		, String  bpssSold 
    		, String  jpssPulc 
    		, String  jpssSold 
    		, String  jpssTech 
    		, String  jpssFect 
    		, String  brtrPsct 
    		, String  brtrCict 
    		, String  brtrAnsv 
    		, String  jrtrCict 
    		, String  jrtrCtar 
    		, String  jrtrPsct 
    		, String  jrtrPtar 
    		, String  jrtrAnsv 
    		, String  jrtrAtar 
    		, String  rrptAmnt 
    		, String  spciBhlh 
    		, String  spciHhlh 
    		, String  spciBepf 
    		, String  spciJepf 
    		, String  spciGurt 
    		, String  spciHdrc 
    		, String  spciRttg 
    		, String  spciIuam 
    		, String  spciSelf 
    		, String  spciAe65 
    		, String  spciDbps 
    		, String  spciDetc 
    		, String  spciDtar 
    		, String  spciEtam 
    		, String  spedSelf 
    		, String  spedEdsu 
    		, String  spedEdam 
    		, String  spedGdsu 
    		, String  spedGdam 
    		, String  spedCvsu 
    		, String  spedCvam 
    		, String  spciScsu 
    		, String  spciScam 
    		, String  spedEtar 
    		, String  siedToam 
    		, String  spciRefn 
    		, String  spciResf 
    		, String  spciHtam 
    		, String  spchRefn 
    		, String  spchRe06 
    		, String  spchRe10 
    		, String  spchRe20 
    		, String  spchRefx 
    		, String  spchReec 
    		, String  spch15fx 
    		, String  spch15fb 
    		, String  spch15ec 
    		, String  spch10fb 
    		, String  spch10ec 
    		, String  taxdPltc 
    		, String  taxd10tg 
    		, String  spciPltc 
    		, String  spciPltg 
    		, String  spciFbam 
    		, String  spciFbtg 
    		, String  spciExam 
    		, String  spciUnon 
    		, String  spciHfam 
    		, String  spciYamt 
    		, String  spciNamt 
    		, String  spciDgtg 
    		, String  spciFnrl 
    		, String  prvm20be 
    		, String  prvm21af 
    		, String  etchPrep 
    		, String  etcsComp 
    		, String  etwkHsvm 
    		, String  etwkHsbm 
    		, String  etwkHlgm 
    		, String  etwkHbdm 
    		, String  etctConc 
    		, String  etgdH09f 
    		, String  etgdH13f 
    		, String  etgdH14f 
    		, String  etclH15f 
    		, String  etgdHdam 
    		, String  etctCard 
    		, String  etchBcbs 
    		, String  etchUeam 
    		, String  etchMgvd 
    		, String  etchBced 
    		, String  cardEt13 
    		, String  cardEt14 
    		, String  etadDd13 
    		, String  etadD14l 
    		, String  etchBcue 
    		, String  etckUnon 
    		, String  etckUncb 
    		, String  etepHsam 
    		, String  etgdCtra 
    		, String  etepSest 
    		, String  etclHm01 
    		, String  etclHm02 
    		, String  etclHm03 
    		, String  etclHmta 
    		, String  etclEttl 
    		, String  etclEtam 
    		, String  taxdIncd 
    		, String  taxdWkdt 
    		, String  tamaEddt 
    		, String  tamaIndt 
    		, String  tamaOudt 
    		, String  txlgFrrd 
    		, String  txlgFrid 
    		, String  txlgWkid 
    		, String  txlgTxtd 
    		, String  txlgBscd 
    		, String  txlgBcde 
    		, String  txlgItct 
    		, String  txlgBsta 
    		, String  txlgWkta 
    		, String  txlgClta 
    		, String  txlgFrta 
    		, String  txlgTxty 
    		, String  txlgInam 
    		, String  txlgDlam 
    		, String  txlgWnam 
    		, String  txlgOtcy 
    		, String  txlgOtdt 
    		, String  txlgApdt 
    		, String  txlgOuwk 
    		, String  txapStdt 
    		, String  txapEddt 
    		, String  txapWkdy 
    		, String  taxdUnin 
    		, String  taxdLoaa 
    		, String  addcNtyn 
    		, String  addcMdyn 
    		, String  addcCtyn 
    		, String  addcPfyn 
    		, String  addfPvyn 
    		, String  spciReyn 
    		, String  txlgMxtm 
    		, String  incoOudt 
    		, String  incoOufg 
    		, String  jdocFile 
    		, String  jrtrAtom 
    		, String  jrtrTotr 
    		, String  spciHdtg 
    		, String  spciDetg 
    		, String  spciRtto 
    		, String  spciSftg 
    		, String  spci65tg 
    		, String  spciPstg 
    		, String  spciEtcg 
    		, String  spedSftr 
    		, String  spedEdtr 
    		, String  spedGdtr 
    		, String  spedCvtr 
    		, String  spciSctr 
    		, String  spciExtg 
    		, String  spciUntg 
    		, String  spciHftg 
    		, String  spciNatg 
    		, String  spciYatg 
    		, String  spciDgam 
    		, String  spciOnon 
    		, String  spciObam 
    		, String  spciOyam 
    		, String  spciOnam 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_EDACRVYY,edacRvyy);
     	values.put(ATTR_SETTGBCD,settGbcd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_EDACSEILNUM,edacSeilNum);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_HANNM,hanNm);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_PYSPCD,pyspCd);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_LOGSVCYRNUMCD,logSvcYrNumCd);
     	values.put(ATTR_LOGSVCMNTHICMCD,logSvcMnthIcmCd);
     	values.put(ATTR_FRSTEMYMTDT,frstEmymtDt);
     	values.put(ATTR_EMYMTBGNNDT,emymtBgnnDt);
     	values.put(ATTR_EMYMTENDDT,emymtEndDt);
     	values.put(ATTR_HDOFCDIVCD,hdofcDivCd);
     	values.put(ATTR_RETRYDT,retryDt);
     	values.put(ATTR_YRTXAPPTNYRMNTH,yrtxApptnYrMnth);
     	values.put(ATTR_YRTXPRCSDT,yrtxPrcsDt);
     	values.put(ATTR_YRTXPRCSYN,yrtxPrcsYn);
     	values.put(ATTR_DIVDPYMTDIVCD,divdPymtDivCd);
     	values.put(ATTR_DIVDPYMT,divdPymt);
     	values.put(ATTR_GNANSGTF,gnanSgtf);
     	values.put(ATTR_FRNRYENO,frnrYeno);
     	values.put(ATTR_REYMSTDT,reymStdt);
     	values.put(ATTR_REYMEDDT,reymEddt);
     	values.put(ATTR_RUTREDDT,rutrEddt);
     	values.put(ATTR_RUTRSTDT,rutrStdt);
     	values.put(ATTR_RESDFLAG,resdFlag);
     	values.put(ATTR_NATNGBCD,natnGbcd);
     	values.put(ATTR_NATNNAME,natnName);
     	values.put(ATTR_REDTGBCD,redtGbcd);
     	values.put(ATTR_REDTNAME,redtName);
     	values.put(ATTR_HUMNCGUE,humnCgue);
     	values.put(ATTR_FRNRSGYN,frnrSgyn);
     	values.put(ATTR_BASEWIYN,baseWiyn);
     	values.put(ATTR_BASEFMLY,baseFmly);
     	values.put(ATTR_ADDRCT70,addrCt70);
     	values.put(ATTR_ADDRHDRC,addrHdrc);
     	values.put(ATTR_ADDRFDSU,addrFdsu);
     	values.put(ATTR_ADDRCLCT,addrClct);
     	values.put(ATTR_ADDRBHCT,addrBhct);
     	values.put(ATTR_PANTONSU,pantOnsu);
     	values.put(ATTR_ADDRMRCT,addrMrct);
     	values.put(ATTR_BNATPSNF,bnatPsnf);
     	values.put(ATTR_JNATPSNF,jnatPsnf);
     	values.put(ATTR_BPSSTECH,bpssTech);
     	values.put(ATTR_BPSSPULC,bpssPulc);
     	values.put(ATTR_BPSSFECT,bpssFect);
     	values.put(ATTR_BPSSSOLD,bpssSold);
     	values.put(ATTR_JPSSPULC,jpssPulc);
     	values.put(ATTR_JPSSSOLD,jpssSold);
     	values.put(ATTR_JPSSTECH,jpssTech);
     	values.put(ATTR_JPSSFECT,jpssFect);
     	values.put(ATTR_BRTRPSCT,brtrPsct);
     	values.put(ATTR_BRTRCICT,brtrCict);
     	values.put(ATTR_BRTRANSV,brtrAnsv);
     	values.put(ATTR_JRTRCICT,jrtrCict);
     	values.put(ATTR_JRTRCTAR,jrtrCtar);
     	values.put(ATTR_JRTRPSCT,jrtrPsct);
     	values.put(ATTR_JRTRPTAR,jrtrPtar);
     	values.put(ATTR_JRTRANSV,jrtrAnsv);
     	values.put(ATTR_JRTRATAR,jrtrAtar);
     	values.put(ATTR_RRPTAMNT,rrptAmnt);
     	values.put(ATTR_SPCIBHLH,spciBhlh);
     	values.put(ATTR_SPCIHHLH,spciHhlh);
     	values.put(ATTR_SPCIBEPF,spciBepf);
     	values.put(ATTR_SPCIJEPF,spciJepf);
     	values.put(ATTR_SPCIGURT,spciGurt);
     	values.put(ATTR_SPCIHDRC,spciHdrc);
     	values.put(ATTR_SPCIRTTG,spciRttg);
     	values.put(ATTR_SPCIIUAM,spciIuam);
     	values.put(ATTR_SPCISELF,spciSelf);
     	values.put(ATTR_SPCIAE65,spciAe65);
     	values.put(ATTR_SPCIDBPS,spciDbps);
     	values.put(ATTR_SPCIDETC,spciDetc);
     	values.put(ATTR_SPCIDTAR,spciDtar);
     	values.put(ATTR_SPCIETAM,spciEtam);
     	values.put(ATTR_SPEDSELF,spedSelf);
     	values.put(ATTR_SPEDEDSU,spedEdsu);
     	values.put(ATTR_SPEDEDAM,spedEdam);
     	values.put(ATTR_SPEDGDSU,spedGdsu);
     	values.put(ATTR_SPEDGDAM,spedGdam);
     	values.put(ATTR_SPEDCVSU,spedCvsu);
     	values.put(ATTR_SPEDCVAM,spedCvam);
     	values.put(ATTR_SPCISCSU,spciScsu);
     	values.put(ATTR_SPCISCAM,spciScam);
     	values.put(ATTR_SPEDETAR,spedEtar);
     	values.put(ATTR_SIEDTOAM,siedToam);
     	values.put(ATTR_SPCIREFN,spciRefn);
     	values.put(ATTR_SPCIRESF,spciResf);
     	values.put(ATTR_SPCIHTAM,spciHtam);
     	values.put(ATTR_SPCHREFN,spchRefn);
     	values.put(ATTR_SPCHRE06,spchRe06);
     	values.put(ATTR_SPCHRE10,spchRe10);
     	values.put(ATTR_SPCHRE20,spchRe20);
     	values.put(ATTR_SPCHREFX,spchRefx);
     	values.put(ATTR_SPCHREEC,spchReec);
     	values.put(ATTR_SPCH15FX,spch15fx);
     	values.put(ATTR_SPCH15FB,spch15fb);
     	values.put(ATTR_SPCH15EC,spch15ec);
     	values.put(ATTR_SPCH10FB,spch10fb);
     	values.put(ATTR_SPCH10EC,spch10ec);
     	values.put(ATTR_TAXDPLTC,taxdPltc);
     	values.put(ATTR_TAXD10TG,taxd10tg);
     	values.put(ATTR_SPCIPLTC,spciPltc);
     	values.put(ATTR_SPCIPLTG,spciPltg);
     	values.put(ATTR_SPCIFBAM,spciFbam);
     	values.put(ATTR_SPCIFBTG,spciFbtg);
     	values.put(ATTR_SPCIEXAM,spciExam);
     	values.put(ATTR_SPCIUNON,spciUnon);
     	values.put(ATTR_SPCIHFAM,spciHfam);
     	values.put(ATTR_SPCIYAMT,spciYamt);
     	values.put(ATTR_SPCINAMT,spciNamt);
     	values.put(ATTR_SPCIDGTG,spciDgtg);
     	values.put(ATTR_SPCIFNRL,spciFnrl);
     	values.put(ATTR_PRVM20BE,prvm20be);
     	values.put(ATTR_PRVM21AF,prvm21af);
     	values.put(ATTR_ETCHPREP,etchPrep);
     	values.put(ATTR_ETCSCOMP,etcsComp);
     	values.put(ATTR_ETWKHSVM,etwkHsvm);
     	values.put(ATTR_ETWKHSBM,etwkHsbm);
     	values.put(ATTR_ETWKHLGM,etwkHlgm);
     	values.put(ATTR_ETWKHBDM,etwkHbdm);
     	values.put(ATTR_ETCTCONC,etctConc);
     	values.put(ATTR_ETGDH09F,etgdH09f);
     	values.put(ATTR_ETGDH13F,etgdH13f);
     	values.put(ATTR_ETGDH14F,etgdH14f);
     	values.put(ATTR_ETCLH15F,etclH15f);
     	values.put(ATTR_ETGDHDAM,etgdHdam);
     	values.put(ATTR_ETCTCARD,etctCard);
     	values.put(ATTR_ETCHBCBS,etchBcbs);
     	values.put(ATTR_ETCHUEAM,etchUeam);
     	values.put(ATTR_ETCHMGVD,etchMgvd);
     	values.put(ATTR_ETCHBCED,etchBced);
     	values.put(ATTR_CARDET13,cardEt13);
     	values.put(ATTR_CARDET14,cardEt14);
     	values.put(ATTR_ETADDD13,etadDd13);
     	values.put(ATTR_ETADD14L,etadD14l);
     	values.put(ATTR_ETCHBCUE,etchBcue);
     	values.put(ATTR_ETCKUNON,etckUnon);
     	values.put(ATTR_ETCKUNCB,etckUncb);
     	values.put(ATTR_ETEPHSAM,etepHsam);
     	values.put(ATTR_ETGDCTRA,etgdCtra);
     	values.put(ATTR_ETEPSEST,etepSest);
     	values.put(ATTR_ETCLHM01,etclHm01);
     	values.put(ATTR_ETCLHM02,etclHm02);
     	values.put(ATTR_ETCLHM03,etclHm03);
     	values.put(ATTR_ETCLHMTA,etclHmta);
     	values.put(ATTR_ETCLETTL,etclEttl);
     	values.put(ATTR_ETCLETAM,etclEtam);
     	values.put(ATTR_TAXDINCD,taxdIncd);
     	values.put(ATTR_TAXDWKDT,taxdWkdt);
     	values.put(ATTR_TAMAEDDT,tamaEddt);
     	values.put(ATTR_TAMAINDT,tamaIndt);
     	values.put(ATTR_TAMAOUDT,tamaOudt);
     	values.put(ATTR_TXLGFRRD,txlgFrrd);
     	values.put(ATTR_TXLGFRID,txlgFrid);
     	values.put(ATTR_TXLGWKID,txlgWkid);
     	values.put(ATTR_TXLGTXTD,txlgTxtd);
     	values.put(ATTR_TXLGBSCD,txlgBscd);
     	values.put(ATTR_TXLGBCDE,txlgBcde);
     	values.put(ATTR_TXLGITCT,txlgItct);
     	values.put(ATTR_TXLGBSTA,txlgBsta);
     	values.put(ATTR_TXLGWKTA,txlgWkta);
     	values.put(ATTR_TXLGCLTA,txlgClta);
     	values.put(ATTR_TXLGFRTA,txlgFrta);
     	values.put(ATTR_TXLGTXTY,txlgTxty);
     	values.put(ATTR_TXLGINAM,txlgInam);
     	values.put(ATTR_TXLGDLAM,txlgDlam);
     	values.put(ATTR_TXLGWNAM,txlgWnam);
     	values.put(ATTR_TXLGOTCY,txlgOtcy);
     	values.put(ATTR_TXLGOTDT,txlgOtdt);
     	values.put(ATTR_TXLGAPDT,txlgApdt);
     	values.put(ATTR_TXLGOUWK,txlgOuwk);
     	values.put(ATTR_TXAPSTDT,txapStdt);
     	values.put(ATTR_TXAPEDDT,txapEddt);
     	values.put(ATTR_TXAPWKDY,txapWkdy);
     	values.put(ATTR_TAXDUNIN,taxdUnin);
     	values.put(ATTR_TAXDLOAA,taxdLoaa);
     	values.put(ATTR_ADDCNTYN,addcNtyn);
     	values.put(ATTR_ADDCMDYN,addcMdyn);
     	values.put(ATTR_ADDCCTYN,addcCtyn);
     	values.put(ATTR_ADDCPFYN,addcPfyn);
     	values.put(ATTR_ADDFPVYN,addfPvyn);
     	values.put(ATTR_SPCIREYN,spciReyn);
     	values.put(ATTR_TXLGMXTM,txlgMxtm);
     	values.put(ATTR_INCOOUDT,incoOudt);
     	values.put(ATTR_INCOOUFG,incoOufg);
     	values.put(ATTR_JDOCFILE,jdocFile);
     	values.put(ATTR_JRTRATOM,jrtrAtom);
     	values.put(ATTR_JRTRTOTR,jrtrTotr);
     	values.put(ATTR_SPCIHDTG,spciHdtg);
     	values.put(ATTR_SPCIDETG,spciDetg);
     	values.put(ATTR_SPCIRTTO,spciRtto);
     	values.put(ATTR_SPCISFTG,spciSftg);
     	values.put(ATTR_SPCI65TG,spci65tg);
     	values.put(ATTR_SPCIPSTG,spciPstg);
     	values.put(ATTR_SPCIETCG,spciEtcg);
     	values.put(ATTR_SPEDSFTR,spedSftr);
     	values.put(ATTR_SPEDEDTR,spedEdtr);
     	values.put(ATTR_SPEDGDTR,spedGdtr);
     	values.put(ATTR_SPEDCVTR,spedCvtr);
     	values.put(ATTR_SPCISCTR,spciSctr);
     	values.put(ATTR_SPCIEXTG,spciExtg);
     	values.put(ATTR_SPCIUNTG,spciUntg);
     	values.put(ATTR_SPCIHFTG,spciHftg);
     	values.put(ATTR_SPCINATG,spciNatg);
     	values.put(ATTR_SPCIYATG,spciYatg);
     	values.put(ATTR_SPCIDGAM,spciDgam);
     	values.put(ATTR_SPCIONON,spciOnon);
     	values.put(ATTR_SPCIOBAM,spciObam);
     	values.put(ATTR_SPCIOYAM,spciOyam);
     	values.put(ATTR_SPCIONAM,spciOnam);
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

    /** set 연말정산귀속년도 : edacRvyy */
    public void setEdacRvyy(String  edacRvyy) { set( ATTR_EDACRVYY ,edacRvyy);}
    /** get 연말정산귀속년도 : edacRvyy */
    public String  getEdacRvyy() { return (String )get( ATTR_EDACRVYY );}

    /** set 정산구분코드 : settGbcd */
    public void setSettGbcd(String  settGbcd) { set( ATTR_SETTGBCD ,settGbcd);}
    /** get 정산구분코드 : settGbcd */
    public String  getSettGbcd() { return (String )get( ATTR_SETTGBCD );}
    
    /** set 정산구분 : settGbnm */
    public void setSettGbnm(String  settGbnm) { set( ATTR_SETTGBNM ,settGbnm);}
    /** get 정산구분 : settGbnm */
    public String  getSettGbnm() { return (String )get( ATTR_SETTGBNM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 연말정산마감일련번호 : edacSeilNum */
    public void setEdacSeilNum(String  edacSeilNum) { set( ATTR_EDACSEILNUM ,edacSeilNum);}
    /** get 연말정산마감일련번호 : edacSeilNum */
    public String  getEdacSeilNum() { return (String )get( ATTR_EDACSEILNUM );}

    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

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
    
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}

    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}

    /** set 호봉코드 : pyspCd */
    public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
    /** get 호봉코드 : pyspCd */
    public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

    /** set 근속년수코드 : logSvcYrNumCd */
    public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
    /** get 근속년수코드 : logSvcYrNumCd */
    public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOGSVCMNTHICMCD ,logSvcMnthIcmCd);}
    /** get 근속월수코드 : logSvcMnthIcmCd */
    public String  getLogSvcMnthIcmCd() { return (String )get( ATTR_LOGSVCMNTHICMCD );}

    /** set 최초고용일자 : frstEmymtDt */
    public void setFrstEmymtDt(String  frstEmymtDt) { set( ATTR_FRSTEMYMTDT ,frstEmymtDt);}
    /** get 최초고용일자 : frstEmymtDt */
    public String  getFrstEmymtDt() { return (String )get( ATTR_FRSTEMYMTDT );}

    /** set 고용시작일자 : emymtBgnnDt */
    public void setEmymtBgnnDt(String  emymtBgnnDt) { set( ATTR_EMYMTBGNNDT ,emymtBgnnDt);}
    /** get 고용시작일자 : emymtBgnnDt */
    public String  getEmymtBgnnDt() { return (String )get( ATTR_EMYMTBGNNDT );}

    /** set 고용종료일자 : emymtEndDt */
    public void setEmymtEndDt(String  emymtEndDt) { set( ATTR_EMYMTENDDT ,emymtEndDt);}
    /** get 고용종료일자 : emymtEndDt */
    public String  getEmymtEndDt() { return (String )get( ATTR_EMYMTENDDT );}

    /** set 재직구분코드 : hdofcDivCd */
    public void setHdofcDivCd(String  hdofcDivCd) { set( ATTR_HDOFCDIVCD ,hdofcDivCd);}
    /** get 재직구분코드 : hdofcDivCd */
    public String  getHdofcDivCd() { return (String )get( ATTR_HDOFCDIVCD );}
    
    /** set 재직구분 : hdofcDivNm */
    public void setHdofcDivNm(String  hdofcDivNm) { set( ATTR_HDOFCDIVNM ,hdofcDivNm);}
    /** get 재직구분코드 : hdofcDivNm */
    public String  getHdofcDivNm() { return (String )get( ATTR_HDOFCDIVNM );}

    /** set 퇴직일자 : retryDt */
    public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
    /** get 퇴직일자 : retryDt */
    public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}

    /** set 연말정산적용년월 : yrtxApptnYrMnth */
    public void setYrtxApptnYrMnth(String  yrtxApptnYrMnth) { set( ATTR_YRTXAPPTNYRMNTH ,yrtxApptnYrMnth);}
    /** get 연말정산적용년월 : yrtxApptnYrMnth */
    public String  getYrtxApptnYrMnth() { return (String )get( ATTR_YRTXAPPTNYRMNTH );}

    /** set 연말정산처리일자 : yrtxPrcsDt */
    public void setYrtxPrcsDt(String  yrtxPrcsDt) { set( ATTR_YRTXPRCSDT ,yrtxPrcsDt);}
    /** get 연말정산처리일자 : yrtxPrcsDt */
    public String  getYrtxPrcsDt() { return (String )get( ATTR_YRTXPRCSDT );}

    /** set 연말정산처리여부 : yrtxPrcsYn */
    public void setYrtxPrcsYn(String  yrtxPrcsYn) { set( ATTR_YRTXPRCSYN ,yrtxPrcsYn);}
    /** get 연말정산처리여부 : yrtxPrcsYn */
    public String  getYrtxPrcsYn() { return (String )get( ATTR_YRTXPRCSYN );}

    /** set 분할납부구분코드 : divdPymtDivCd */
    public void setDivdPymtDivCd(String  divdPymtDivCd) { set( ATTR_DIVDPYMTDIVCD ,divdPymtDivCd);}
    /** get 분할납부구분코드 : divdPymtDivCd */
    public String  getDivdPymtDivCd() { return (String )get( ATTR_DIVDPYMTDIVCD );}

    /** set 분할납부횟수 : divdPymt */
    public void setDivdPymt(String  divdPymt) { set( ATTR_DIVDPYMT ,divdPymt);}
    /** get 분할납부횟수 : divdPymt */
    public String  getDivdPymt() { return (String )get( ATTR_DIVDPYMT );}

    /** set 세대주여부 : gnanSgtf */
    public void setGnanSgtf(String  gnanSgtf) { set( ATTR_GNANSGTF ,gnanSgtf);}
    /** get 세대주여부 : gnanSgtf */
    public String  getGnanSgtf() { return (String )get( ATTR_GNANSGTF );}

    /** set 외국인구분코드 : frnrYeno */
    public void setFrnrYeno(String  frnrYeno) { set( ATTR_FRNRYENO ,frnrYeno);}
    /** get 외국인구분코드 : frnrYeno */
    public String  getFrnrYeno() { return (String )get( ATTR_FRNRYENO );}

    /** set 귀속년월_FROM : reymStdt */
    public void setReymStdt(String  reymStdt) { set( ATTR_REYMSTDT ,reymStdt);}
    /** get 귀속년월_FROM : reymStdt */
    public String  getReymStdt() { return (String )get( ATTR_REYMSTDT );}

    /** set 귀속년월_TO : reymEddt */
    public void setReymEddt(String  reymEddt) { set( ATTR_REYMEDDT ,reymEddt);}
    /** get 귀속년월_TO : reymEddt */
    public String  getReymEddt() { return (String )get( ATTR_REYMEDDT );}

    /** set 감면기간_TO : rutrEddt */
    public void setRutrEddt(String  rutrEddt) { set( ATTR_RUTREDDT ,rutrEddt);}
    /** get 감면기간_TO : rutrEddt */
    public String  getRutrEddt() { return (String )get( ATTR_RUTREDDT );}

    /** set 감면기간_FROM : rutrStdt */
    public void setRutrStdt(String  rutrStdt) { set( ATTR_RUTRSTDT ,rutrStdt);}
    /** get 감면기간_FROM : rutrStdt */
    public String  getRutrStdt() { return (String )get( ATTR_RUTRSTDT );}

    /** set 거주구분여부 : resdFlag */
    public void setResdFlag(String  resdFlag) { set( ATTR_RESDFLAG ,resdFlag);}
    /** get 거주구분여부 : resdFlag */
    public String  getResdFlag() { return (String )get( ATTR_RESDFLAG );}

    /** set 국적코드 : natnGbcd */
    public void setNatnGbcd(String  natnGbcd) { set( ATTR_NATNGBCD ,natnGbcd);}
    /** get 국적코드 : natnGbcd */
    public String  getNatnGbcd() { return (String )get( ATTR_NATNGBCD );}
    
    /** set 국적코드 : natnItem */
    public void setNatnItem(String  natnItem) { set( ATTR_NATNITEM ,natnItem);}
    /** get 국적코드 : natnGbcd */
    public String  getNatnItem() { return (String )get( ATTR_NATNITEM );}
    

    /** set 국적명 : natnName */
    public void setNatnName(String  natnName) { set( ATTR_NATNNAME ,natnName);}
    /** get 국적명 : natnName */
    public String  getNatnName() { return (String )get( ATTR_NATNNAME );}

    /** set 거주지국코드 : redtGbcd */
    public void setRedtGbcd(String  redtGbcd) { set( ATTR_REDTGBCD ,redtGbcd);}
    /** get 거주지국코드 : redtGbcd */
    public String  getRedtGbcd() { return (String )get( ATTR_REDTGBCD );}
    
    /** set 거주지국코드 : redtGbcd */
    public void setRedtItem(String  RedtItem) { set( ATTR_REDTITEM,RedtItem);}
    /** get 거주지국코드 : redtGbcd */
    public String  getRedtItem() { return (String )get( ATTR_REDTITEM );}

    /** set 거주지국명 : redtName */
    public void setRedtName(String  redtName) { set( ATTR_REDTNAME ,redtName);}
    /** get 거주지국명 : redtName */
    public String  getRedtName() { return (String )get( ATTR_REDTNAME );}

    /** set 인적공제항목변동여부 : humnCgue */
    public void setHumnCgue(String  humnCgue) { set( ATTR_HUMNCGUE ,humnCgue);}
    /** get 인적공제항목변동여부 : humnCgue */
    public String  getHumnCgue() { return (String )get( ATTR_HUMNCGUE );}

    /** set 외국인단일세율적용여부 : frnrSgyn */
    public void setFrnrSgyn(String  frnrSgyn) { set( ATTR_FRNRSGYN ,frnrSgyn);}
    /** get 외국인단일세율적용여부 : frnrSgyn */
    public String  getFrnrSgyn() { return (String )get( ATTR_FRNRSGYN );}

    /** set 기본공제_배우자유무 : baseWiyn */
    public void setBaseWiyn(String  baseWiyn) { set( ATTR_BASEWIYN ,baseWiyn);}
    /** get 기본공제_배우자유무 : baseWiyn */
    public String  getBaseWiyn() { return (String )get( ATTR_BASEWIYN );}

    /** set 기본공제_부양가족수 : baseFmly */
    public void setBaseFmly(String  baseFmly) { set( ATTR_BASEFMLY ,baseFmly);}
    /** get 기본공제_부양가족수 : baseFmly */
    public String  getBaseFmly() { return (String )get( ATTR_BASEFMLY );}

    /** set 추가공제_경로우대_70세이상수 : addrCt70 */
    public void setAddrCt70(String  addrCt70) { set( ATTR_ADDRCT70 ,addrCt70);}
    /** get 추가공제_경로우대_70세이상수 : addrCt70 */
    public String  getAddrCt70() { return (String )get( ATTR_ADDRCT70 );}

    /** set 추가공제_장애인수 : addrHdrc */
    public void setAddrHdrc(String  addrHdrc) { set( ATTR_ADDRHDRC ,addrHdrc);}
    /** get 추가공제_장애인수 : addrHdrc */
    public String  getAddrHdrc() { return (String )get( ATTR_ADDRHDRC );}

    /** set 추가공제_부녀자수 : addrFdsu */
    public void setAddrFdsu(String  addrFdsu) { set( ATTR_ADDRFDSU ,addrFdsu);}
    /** get 추가공제_부녀자수 : addrFdsu */
    public String  getAddrFdsu() { return (String )get( ATTR_ADDRFDSU );}

    /** set 추가공제_자녀양육비양육수 : addrClct */
    public void setAddrClct(String  addrClct) { set( ATTR_ADDRCLCT ,addrClct);}
    /** get 추가공제_자녀양육비양육수 : addrClct */
    public String  getAddrClct() { return (String )get( ATTR_ADDRCLCT );}

    /** set 추가공제_출산자녀양육수 : addrBhct */
    public void setAddrBhct(String  addrBhct) { set( ATTR_ADDRBHCT ,addrBhct);}
    /** get 추가공제_출산자녀양육수 : addrBhct */
    public String  getAddrBhct() { return (String )get( ATTR_ADDRBHCT );}

    /** set 추가공제_한부모수 : pantOnsu */
    public void setPantOnsu(String  pantOnsu) { set( ATTR_PANTONSU ,pantOnsu);}
    /** get 추가공제_한부모수 : pantOnsu */
    public String  getPantOnsu() { return (String )get( ATTR_PANTONSU );}

    /** set 추가공제_다자녀인원수 : addrMrct */
    public void setAddrMrct(String  addrMrct) { set( ATTR_ADDRMRCT ,addrMrct);}
    /** get 추가공제_다자녀인원수 : addrMrct */
    public String  getAddrMrct() { return (String )get( ATTR_ADDRMRCT );}

    /** set 종근무지_국민연금보험료 : bnatPsnf */
    public void setBnatPsnf(String  bnatPsnf) { set( ATTR_BNATPSNF ,bnatPsnf);}
    /** get 종근무지_국민연금보험료 : bnatPsnf */
    public String  getBnatPsnf() { return (String )get( ATTR_BNATPSNF );}

    /** set 주근무지_국민연금보험료 : jnatPsnf */
    public void setJnatPsnf(String  jnatPsnf) { set( ATTR_JNATPSNF ,jnatPsnf);}
    /** get 주근무지_국민연금보험료 : jnatPsnf */
    public String  getJnatPsnf() { return (String )get( ATTR_JNATPSNF );}

    /** set 종근무지_국민연금외교직원연금 : bpssTech */
    public void setBpssTech(String  bpssTech) { set( ATTR_BPSSTECH ,bpssTech);}
    /** get 종근무지_국민연금외교직원연금 : bpssTech */
    public String  getBpssTech() { return (String )get( ATTR_BPSSTECH );}

    /** set 종근무지_국민연금외공무원연금 : bpssPulc */
    public void setBpssPulc(String  bpssPulc) { set( ATTR_BPSSPULC ,bpssPulc);}
    /** get 종근무지_국민연금외공무원연금 : bpssPulc */
    public String  getBpssPulc() { return (String )get( ATTR_BPSSPULC );}

    /** set 종근무지_국민연금외별정우체국 : bpssFect */
    public void setBpssFect(String  bpssFect) { set( ATTR_BPSSFECT ,bpssFect);}
    /** get 종근무지_국민연금외별정우체국 : bpssFect */
    public String  getBpssFect() { return (String )get( ATTR_BPSSFECT );}

    /** set 종근무지_국민연금외군인연금 : bpssSold */
    public void setBpssSold(String  bpssSold) { set( ATTR_BPSSSOLD ,bpssSold);}
    /** get 종근무지_국민연금외군인연금 : bpssSold */
    public String  getBpssSold() { return (String )get( ATTR_BPSSSOLD );}

    /** set 주근무지_국민연금외공무원연금 : jpssPulc */
    public void setJpssPulc(String  jpssPulc) { set( ATTR_JPSSPULC ,jpssPulc);}
    /** get 주근무지_국민연금외공무원연금 : jpssPulc */
    public String  getJpssPulc() { return (String )get( ATTR_JPSSPULC );}

    /** set 주근무지_국민연금외군인연금 : jpssSold */
    public void setJpssSold(String  jpssSold) { set( ATTR_JPSSSOLD ,jpssSold);}
    /** get 주근무지_국민연금외군인연금 : jpssSold */
    public String  getJpssSold() { return (String )get( ATTR_JPSSSOLD );}

    /** set 주근무지_국인연금외교직원연금 : jpssTech */
    public void setJpssTech(String  jpssTech) { set( ATTR_JPSSTECH ,jpssTech);}
    /** get 주근무지_국인연금외교직원연금 : jpssTech */
    public String  getJpssTech() { return (String )get( ATTR_JPSSTECH );}

    /** set 주근무지_국민연금외별정우체국 : jpssFect */
    public void setJpssFect(String  jpssFect) { set( ATTR_JPSSFECT ,jpssFect);}
    /** get 주근무지_국민연금외별정우체국 : jpssFect */
    public String  getJpssFect() { return (String )get( ATTR_JPSSFECT );}

    /** set 종근무지_종_근로자퇴직보장법 : brtrPsct */
    public void setBrtrPsct(String  brtrPsct) { set( ATTR_BRTRPSCT ,brtrPsct);}
    /** get 종근무지_종_근로자퇴직보장법 : brtrPsct */
    public String  getBrtrPsct() { return (String )get( ATTR_BRTRPSCT );}

    /** set 종근무지_종_과학기술인공제 : brtrCict */
    public void setBrtrCict(String  brtrCict) { set( ATTR_BRTRCICT ,brtrCict);}
    /** get 종근무지_종_과학기술인공제 : brtrCict */
    public String  getBrtrCict() { return (String )get( ATTR_BRTRCICT );}

    /** set 종근무지_연금계좌_연금저축 : brtrAnsv */
    public void setBrtrAnsv(String  brtrAnsv) { set( ATTR_BRTRANSV ,brtrAnsv);}
    /** get 종근무지_연금계좌_연금저축 : brtrAnsv */
    public String  getBrtrAnsv() { return (String )get( ATTR_BRTRANSV );}

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrCict */
    public void setJrtrCict(String  jrtrCict) { set( ATTR_JRTRCICT ,jrtrCict);}
    /** get 주근무지_퇴직연금과학기술인공제 : jrtrCict */
    public String  getJrtrCict() { return (String )get( ATTR_JRTRCICT );}

    /** set 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
    public void setJrtrCtar(String  jrtrCtar) { set( ATTR_JRTRCTAR ,jrtrCtar);}
    /** get 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
    public String  getJrtrCtar() { return (String )get( ATTR_JRTRCTAR );}

    /** set 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
    public void setJrtrPsct(String  jrtrPsct) { set( ATTR_JRTRPSCT ,jrtrPsct);}
    /** get 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
    public String  getJrtrPsct() { return (String )get( ATTR_JRTRPSCT );}

    /** set 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
    public void setJrtrPtar(String  jrtrPtar) { set( ATTR_JRTRPTAR ,jrtrPtar);}
    /** get 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
    public String  getJrtrPtar() { return (String )get( ATTR_JRTRPTAR );}

    /** set 주근무지_연금계좌_연금저축 : jrtrAnsv */
    public void setJrtrAnsv(String  jrtrAnsv) { set( ATTR_JRTRANSV ,jrtrAnsv);}
    /** get 주근무지_연금계좌_연금저축 : jrtrAnsv */
    public String  getJrtrAnsv() { return (String )get( ATTR_JRTRANSV );}

    /** set 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
    public void setJrtrAtar(String  jrtrAtar) { set( ATTR_JRTRATAR ,jrtrAtar);}
    /** get 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
    public String  getJrtrAtar() { return (String )get( ATTR_JRTRATAR );}

    /** set 연금보험료계 : rrptAmnt */
    public void setRrptAmnt(String  rrptAmnt) { set( ATTR_RRPTAMNT ,rrptAmnt);}
    /** get 연금보험료계 : rrptAmnt */
    public String  getRrptAmnt() { return (String )get( ATTR_RRPTAMNT );}

    /** set 특별공제_종건강보험료 : spciBhlh */
    public void setSpciBhlh(String  spciBhlh) { set( ATTR_SPCIBHLH ,spciBhlh);}
    /** get 특별공제_종건강보험료 : spciBhlh */
    public String  getSpciBhlh() { return (String )get( ATTR_SPCIBHLH );}

    /** set 특별공제_주건강보험료 : spciHhlh */
    public void setSpciHhlh(String  spciHhlh) { set( ATTR_SPCIHHLH ,spciHhlh);}
    /** get 특별공제_주건강보험료 : spciHhlh */
    public String  getSpciHhlh() { return (String )get( ATTR_SPCIHHLH );}

    /** set 특별공제_종고용보험료 : spciBepf */
    public void setSpciBepf(String  spciBepf) { set( ATTR_SPCIBEPF ,spciBepf);}
    /** get 특별공제_종고용보험료 : spciBepf */
    public String  getSpciBepf() { return (String )get( ATTR_SPCIBEPF );}

    /** set 특별공제_주고용보험료 : spciJepf */
    public void setSpciJepf(String  spciJepf) { set( ATTR_SPCIJEPF ,spciJepf);}
    /** get 특별공제_주고용보험료 : spciJepf */
    public String  getSpciJepf() { return (String )get( ATTR_SPCIJEPF );}

    /** set 특별공제_일반보장성보험료 : spciGurt */
    public void setSpciGurt(String  spciGurt) { set( ATTR_SPCIGURT ,spciGurt);}
    /** get 특별공제_일반보장성보험료 : spciGurt */
    public String  getSpciGurt() { return (String )get( ATTR_SPCIGURT );}

    /** set 특별공제_장애인전용보험료 : spciHdrc */
    public void setSpciHdrc(String  spciHdrc) { set( ATTR_SPCIHDRC ,spciHdrc);}
    /** get 특별공제_장애인전용보험료 : spciHdrc */
    public String  getSpciHdrc() { return (String )get( ATTR_SPCIHDRC );}

    /** set 특별공제_보장성보험료공제대상금액 : spciRttg */
    public void setSpciRttg(String  spciRttg) { set( ATTR_SPCIRTTG ,spciRttg);}
    /** get 특별공제_보장성보험료공제대상금액 : spciRttg */
    public String  getSpciRttg() { return (String )get( ATTR_SPCIRTTG );}

    /** set 특별공제_보험료계 : spciIuam */
    public void setSpciIuam(String  spciIuam) { set( ATTR_SPCIIUAM ,spciIuam);}
    /** get 특별공제_보험료계 : spciIuam */
    public String  getSpciIuam() { return (String )get( ATTR_SPCIIUAM );}

    /** set 특별공제_의료비_본인 : spciSelf */
    public void setSpciSelf(String  spciSelf) { set( ATTR_SPCISELF ,spciSelf);}
    /** get 특별공제_의료비_본인 : spciSelf */
    public String  getSpciSelf() { return (String )get( ATTR_SPCISELF );}

    /** set 특별공제_의료비_경로65세이상 : spciAe65 */
    public void setSpciAe65(String  spciAe65) { set( ATTR_SPCIAE65 ,spciAe65);}
    /** get 특별공제_의료비_경로65세이상 : spciAe65 */
    public String  getSpciAe65() { return (String )get( ATTR_SPCIAE65 );}

    /** set 특별공제_의료비_장애인 : spciDbps */
    public void setSpciDbps(String  spciDbps) { set( ATTR_SPCIDBPS ,spciDbps);}
    /** get 특별공제_의료비_장애인 : spciDbps */
    public String  getSpciDbps() { return (String )get( ATTR_SPCIDBPS );}

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public void setSpciDetc(String  spciDetc) { set( ATTR_SPCIDETC ,spciDetc);}
    /** get 특별공제_의료비_기타공제대상자 : spciDetc */
    public String  getSpciDetc() { return (String )get( ATTR_SPCIDETC );}

    /** set 특별공제_의료비세액공제대상금액 : spciDtar */
    public void setSpciDtar(String  spciDtar) { set( ATTR_SPCIDTAR ,spciDtar);}
    /** get 특별공제_의료비세액공제대상금액 : spciDtar */
    public String  getSpciDtar() { return (String )get( ATTR_SPCIDTAR );}

    /** set 특별공제_의료비계 : spciEtam */
    public void setSpciEtam(String  spciEtam) { set( ATTR_SPCIETAM ,spciEtam);}
    /** get 특별공제_의료비계 : spciEtam */
    public String  getSpciEtam() { return (String )get( ATTR_SPCIETAM );}

    /** set 특별공제_교육비_본인 : spedSelf */
    public void setSpedSelf(String  spedSelf) { set( ATTR_SPEDSELF ,spedSelf);}
    /** get 특별공제_교육비_본인 : spedSelf */
    public String  getSpedSelf() { return (String )get( ATTR_SPEDSELF );}

    /** set 특별공제_교육비_취학전아동수 : spedEdsu */
    public void setSpedEdsu(String  spedEdsu) { set( ATTR_SPEDEDSU ,spedEdsu);}
    /** get 특별공제_교육비_취학전아동수 : spedEdsu */
    public String  getSpedEdsu() { return (String )get( ATTR_SPEDEDSU );}

    /** set 특별공제_교육비_취학전아동 : spedEdam */
    public void setSpedEdam(String  spedEdam) { set( ATTR_SPEDEDAM ,spedEdam);}
    /** get 특별공제_교육비_취학전아동 : spedEdam */
    public String  getSpedEdam() { return (String )get( ATTR_SPEDEDAM );}

    /** set 특별공제_교육비_초중고자녀수 : spedGdsu */
    public void setSpedGdsu(String  spedGdsu) { set( ATTR_SPEDGDSU ,spedGdsu);}
    /** get 특별공제_교육비_초중고자녀수 : spedGdsu */
    public String  getSpedGdsu() { return (String )get( ATTR_SPEDGDSU );}

    /** set 특별공제_교육비_초중고 : spedGdam */
    public void setSpedGdam(String  spedGdam) { set( ATTR_SPEDGDAM ,spedGdam);}
    /** get 특별공제_교육비_초중고 : spedGdam */
    public String  getSpedGdam() { return (String )get( ATTR_SPEDGDAM );}

    /** set 특별공제_교육비_대학생수 : spedCvsu */
    public void setSpedCvsu(String  spedCvsu) { set( ATTR_SPEDCVSU ,spedCvsu);}
    /** get 특별공제_교육비_대학생수 : spedCvsu */
    public String  getSpedCvsu() { return (String )get( ATTR_SPEDCVSU );}

    /** set 특별공제_교육비_대학교 : spedCvam */
    public void setSpedCvam(String  spedCvam) { set( ATTR_SPEDCVAM ,spedCvam);}
    /** get 특별공제_교육비_대학교 : spedCvam */
    public String  getSpedCvam() { return (String )get( ATTR_SPEDCVAM );}

    /** set 특별공제_장애인수 : spciScsu */
    public void setSpciScsu(String  spciScsu) { set( ATTR_SPCISCSU ,spciScsu);}
    /** get 특별공제_장애인수 : spciScsu */
    public String  getSpciScsu() { return (String )get( ATTR_SPCISCSU );}

    /** set 특별공제_장애인특수교육비 : spciScam */
    public void setSpciScam(String  spciScam) { set( ATTR_SPCISCAM ,spciScam);}
    /** get 특별공제_장애인특수교육비 : spciScam */
    public String  getSpciScam() { return (String )get( ATTR_SPCISCAM );}

    /** set 특별공제_교육비공제대상금액 : spedEtar */
    public void setSpedEtar(String  spedEtar) { set( ATTR_SPEDETAR ,spedEtar);}
    /** get 특별공제_교육비공제대상금액 : spedEtar */
    public String  getSpedEtar() { return (String )get( ATTR_SPEDETAR );}

    /** set 특별공제_교육비계 : siedToam */
    public void setSiedToam(String  siedToam) { set( ATTR_SIEDTOAM ,siedToam);}
    /** get 특별공제_교육비계 : siedToam */
    public String  getSiedToam() { return (String )get( ATTR_SIEDTOAM );}

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public void setSpciRefn(String  spciRefn) { set( ATTR_SPCIREFN ,spciRefn);}
    /** get 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public String  getSpciRefn() { return (String )get( ATTR_SPCIREFN );}

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public void setSpciResf(String  spciResf) { set( ATTR_SPCIRESF ,spciResf);}
    /** get 특별공제_차입금원리금상환액_거주자 : spciResf */
    public String  getSpciResf() { return (String )get( ATTR_SPCIRESF );}

    /** set 특별공제_주택자금_월세금액 : spciHtam */
    public void setSpciHtam(String  spciHtam) { set( ATTR_SPCIHTAM ,spciHtam);}
    /** get 특별공제_주택자금_월세금액 : spciHtam */
    public String  getSpciHtam() { return (String )get( ATTR_SPCIHTAM );}

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    public void setSpchRefn(String  spchRefn) { set( ATTR_SPCHREFN ,spchRefn);}
    /** get 특별공제_장기주택이자상환액 : spchRefn */
    public String  getSpchRefn() { return (String )get( ATTR_SPCHREFN );}

    /** set 특별공제_11장기주택저당차입금15 : spchRe06 */
    public void setSpchRe06(String  spchRe06) { set( ATTR_SPCHRE06 ,spchRe06);}
    /** get 특별공제_11장기주택저당차입금15 : spchRe06 */
    public String  getSpchRe06() { return (String )get( ATTR_SPCHRE06 );}

    /** set 특별공제_11장기주택저당차입금29 : spchRe10 */
    public void setSpchRe10(String  spchRe10) { set( ATTR_SPCHRE10 ,spchRe10);}
    /** get 특별공제_11장기주택저당차입금29 : spchRe10 */
    public String  getSpchRe10() { return (String )get( ATTR_SPCHRE10 );}

    /** set 특별공제_11장기주택저당차입금30 : spchRe20 */
    public void setSpchRe20(String  spchRe20) { set( ATTR_SPCHRE20 ,spchRe20);}
    /** get 특별공제_11장기주택저당차입금30 : spchRe20 */
    public String  getSpchRe20() { return (String )get( ATTR_SPCHRE20 );}

    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public void setSpchRefx(String  spchRefx) { set( ATTR_SPCHREFX ,spchRefx);}
    /** get 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public String  getSpchRefx() { return (String )get( ATTR_SPCHREFX );}

    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    public void setSpchReec(String  spchReec) { set( ATTR_SPCHREEC ,spchReec);}
    /** get 특별공제_12장기주택저당차입금_기타 : spchReec */
    public String  getSpchReec() { return (String )get( ATTR_SPCHREEC );}

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
    public void setSpch15fx(String  spch15fx) { set( ATTR_SPCH15FX ,spch15fx);}
    /** get 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
    public String  getSpch15fx() { return (String )get( ATTR_SPCH15FX );}

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
    public void setSpch15fb(String  spch15fb) { set( ATTR_SPCH15FB ,spch15fb);}
    /** get 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
    public String  getSpch15fb() { return (String )get( ATTR_SPCH15FB );}

    /** set 특별공제_15장기주택저당_15기타대출 : spch15ec */
    public void setSpch15ec(String  spch15ec) { set( ATTR_SPCH15EC ,spch15ec);}
    /** get 특별공제_15장기주택저당_15기타대출 : spch15ec */
    public String  getSpch15ec() { return (String )get( ATTR_SPCH15EC );}

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
    public void setSpch10fb(String  spch10fb) { set( ATTR_SPCH10FB ,spch10fb);}
    /** get 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
    public String  getSpch10fb() { return (String )get( ATTR_SPCH10FB );}

    /** set 특별공제_15장기주택저당_10기타대출 : spch10ec */
    public void setSpch10ec(String  spch10ec) { set( ATTR_SPCH10EC ,spch10ec);}
    /** get 특별공제_15장기주택저당_10기타대출 : spch10ec */
    public String  getSpch10ec() { return (String )get( ATTR_SPCH10EC );}

    /** set 세액공제_기부정치자금금액 : taxdPltc */
    public void setTaxdPltc(String  taxdPltc) { set( ATTR_TAXDPLTC ,taxdPltc);}
    /** get 세액공제_기부정치자금금액 : taxdPltc */
    public String  getTaxdPltc() { return (String )get( ATTR_TAXDPLTC );}

    /** set 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
    public void setTaxd10tg(String  taxd10tg) { set( ATTR_TAXD10TG ,taxd10tg);}
    /** get 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
    public String  getTaxd10tg() { return (String )get( ATTR_TAXD10TG );}

    /** set 특별공제_기부금_정치 : spciPltc */
    public void setSpciPltc(String  spciPltc) { set( ATTR_SPCIPLTC ,spciPltc);}
    /** get 특별공제_기부금_정치 : spciPltc */
    public String  getSpciPltc() { return (String )get( ATTR_SPCIPLTC );}

    /** set 특별공제_기부금_정치10초과대상금액 : spciPltg */
    public void setSpciPltg(String  spciPltg) { set( ATTR_SPCIPLTG ,spciPltg);}
    /** get 특별공제_기부금_정치10초과대상금액 : spciPltg */
    public String  getSpciPltg() { return (String )get( ATTR_SPCIPLTG );}

    /** set 특별공제_기부금_법정 : spciFbam */
    public void setSpciFbam(String  spciFbam) { set( ATTR_SPCIFBAM ,spciFbam);}
    /** get 특별공제_기부금_법정 : spciFbam */
    public String  getSpciFbam() { return (String )get( ATTR_SPCIFBAM );}

    /** set 특별공제_기부금_법정대상금액 : spciFbtg */
    public void setSpciFbtg(String  spciFbtg) { set( ATTR_SPCIFBTG ,spciFbtg);}
    /** get 특별공제_기부금_법정대상금액 : spciFbtg */
    public String  getSpciFbtg() { return (String )get( ATTR_SPCIFBTG );}

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public void setSpciExam(String  spciExam) { set( ATTR_SPCIEXAM ,spciExam);}
    /** get 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public String  getSpciExam() { return (String )get( ATTR_SPCIEXAM );}

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public void setSpciUnon(String  spciUnon) { set( ATTR_SPCIUNON ,spciUnon);}
    /** get 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public String  getSpciUnon() { return (String )get( ATTR_SPCIUNON );}

    /** set 특별공제_기부금_우리사주조합2015이후 : spciHfam */
    public void setSpciHfam(String  spciHfam) { set( ATTR_SPCIHFAM ,spciHfam);}
    /** get 특별공제_기부금_우리사주조합2015이후 : spciHfam */
    public String  getSpciHfam() { return (String )get( ATTR_SPCIHFAM );}

    /** set 특별공제_기부금_종교단체 : spciYamt */
    public void setSpciYamt(String  spciYamt) { set( ATTR_SPCIYAMT ,spciYamt);}
    /** get 특별공제_기부금_종교단체 : spciYamt */
    public String  getSpciYamt() { return (String )get( ATTR_SPCIYAMT );}

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public void setSpciNamt(String  spciNamt) { set( ATTR_SPCINAMT ,spciNamt);}
    /** get 특별공제_기부금_종교단체외 : spciNamt */
    public String  getSpciNamt() { return (String )get( ATTR_SPCINAMT );}

    /** set 특별공제_지정기부금대상금액 : spciDgtg */
    public void setSpciDgtg(String  spciDgtg) { set( ATTR_SPCIDGTG ,spciDgtg);}
    /** get 특별공제_지정기부금대상금액 : spciDgtg */
    public String  getSpciDgtg() { return (String )get( ATTR_SPCIDGTG );}

    /** set 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
    public void setSpciFnrl(String  spciFnrl) { set( ATTR_SPCIFNRL ,spciFnrl);}
    /** get 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
    public String  getSpciFnrl() { return (String )get( ATTR_SPCIFNRL );}

    /** set 개인연금저축불입액_2000년이전 : prvm20be */
    public void setPrvm20be(String  prvm20be) { set( ATTR_PRVM20BE ,prvm20be);}
    /** get 개인연금저축불입액_2000년이전 : prvm20be */
    public String  getPrvm20be() { return (String )get( ATTR_PRVM20BE );}

    /** set 개인연금저축불입액_2001년이후_삭제 : prvm21af */
    public void setPrvm21af(String  prvm21af) { set( ATTR_PRVM21AF ,prvm21af);}
    /** get 개인연금저축불입액_2001년이후_삭제 : prvm21af */
    public String  getPrvm21af() { return (String )get( ATTR_PRVM21AF );}

    /** set 기타공제_소기업공제불입금액 : etchPrep */
    public void setEtchPrep(String  etchPrep) { set( ATTR_ETCHPREP ,etchPrep);}
    /** get 기타공제_소기업공제불입금액 : etchPrep */
    public String  getEtchPrep() { return (String )get( ATTR_ETCHPREP );}

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public void setEtcsComp(String  etcsComp) { set( ATTR_ETCSCOMP ,etcsComp);}
    /** get 기타공제_주택마련저축_청약저축 : etcsComp */
    public String  getEtcsComp() { return (String )get( ATTR_ETCSCOMP );}

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
    public void setEtwkHsvm(String  etwkHsvm) { set( ATTR_ETWKHSVM ,etwkHsvm);}
    /** get 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
    public String  getEtwkHsvm() { return (String )get( ATTR_ETWKHSVM );}

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
    public void setEtwkHsbm(String  etwkHsbm) { set( ATTR_ETWKHSBM ,etwkHsbm);}
    /** get 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
    public String  getEtwkHsbm() { return (String )get( ATTR_ETWKHSBM );}

    /** set 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
    public void setEtwkHlgm(String  etwkHlgm) { set( ATTR_ETWKHLGM ,etwkHlgm);}
    /** get 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
    public String  getEtwkHlgm() { return (String )get( ATTR_ETWKHLGM );}

    /** set 기타공제_주택마련저축소득금액 : etwkHbdm */
    public void setEtwkHbdm(String  etwkHbdm) { set( ATTR_ETWKHBDM ,etwkHbdm);}
    /** get 기타공제_주택마련저축소득금액 : etwkHbdm */
    public String  getEtwkHbdm() { return (String )get( ATTR_ETWKHBDM );}

    /** set 기타공제_투자조합출자금액_2011이전 : etctConc */
    public void setEtctConc(String  etctConc) { set( ATTR_ETCTCONC ,etctConc);}
    /** get 기타공제_투자조합출자금액_2011이전 : etctConc */
    public String  getEtctConc() { return (String )get( ATTR_ETCTCONC );}

    /** set 기타공제_투자조합출자금액_2012년도 : etgdH09f */
    public void setEtgdH09f(String  etgdH09f) { set( ATTR_ETGDH09F ,etgdH09f);}
    /** get 기타공제_투자조합출자금액_2012년도 : etgdH09f */
    public String  getEtgdH09f() { return (String )get( ATTR_ETGDH09F );}

    /** set 기타공제_투자조합출자금액_2013년도 : etgdH13f */
    public void setEtgdH13f(String  etgdH13f) { set( ATTR_ETGDH13F ,etgdH13f);}
    /** get 기타공제_투자조합출자금액_2013년도 : etgdH13f */
    public String  getEtgdH13f() { return (String )get( ATTR_ETGDH13F );}

    /** set 기타공제_투자조합출자금액_2014년도 : etgdH14f */
    public void setEtgdH14f(String  etgdH14f) { set( ATTR_ETGDH14F ,etgdH14f);}
    /** get 기타공제_투자조합출자금액_2014년도 : etgdH14f */
    public String  getEtgdH14f() { return (String )get( ATTR_ETGDH14F );}

    /** set 기타공제_투자조합출자금액_2015년이후 : etclH15f */
    public void setEtclH15f(String  etclH15f) { set( ATTR_ETCLH15F ,etclH15f);}
    /** get 기타공제_투자조합출자금액_2015년이후 : etclH15f */
    public String  getEtclH15f() { return (String )get( ATTR_ETCLH15F );}

    /** set 기타공제투자조합출자금액계 : etgdHdam */
    public void setEtgdHdam(String  etgdHdam) { set( ATTR_ETGDHDAM ,etgdHdam);}
    /** get 기타공제투자조합출자금액계 : etgdHdam */
    public String  getEtgdHdam() { return (String )get( ATTR_ETGDHDAM );}

    /** set 기타공제_신용카드등사용금액 : etctCard */
    public void setEtctCard(String  etctCard) { set( ATTR_ETCTCARD ,etctCard);}
    /** get 기타공제_신용카드등사용금액 : etctCard */
    public String  getEtctCard() { return (String )get( ATTR_ETCTCARD );}

    /** set 기타공제_직불카드등사용금액 : etchBcbs */
    public void setEtchBcbs(String  etchBcbs) { set( ATTR_ETCHBCBS ,etchBcbs);}
    /** get 기타공제_직불카드등사용금액 : etchBcbs */
    public String  getEtchBcbs() { return (String )get( ATTR_ETCHBCBS );}

    /** set 기타공제_현금영수증사용금액 : etchUeam */
    public void setEtchUeam(String  etchUeam) { set( ATTR_ETCHUEAM ,etchUeam);}
    /** get 기타공제_현금영수증사용금액 : etchUeam */
    public String  getEtchUeam() { return (String )get( ATTR_ETCHUEAM );}

    /** set 기타공제_전통시장사용분 : etchMgvd */
    public void setEtchMgvd(String  etchMgvd) { set( ATTR_ETCHMGVD ,etchMgvd);}
    /** get 기타공제_전통시장사용분 : etchMgvd */
    public String  getEtchMgvd() { return (String )get( ATTR_ETCHMGVD );}

    /** set 기타공제_지로납부_대중교통금액 : etchBced */
    public void setEtchBced(String  etchBced) { set( ATTR_ETCHBCED ,etchBced);}
    /** get 기타공제_지로납부_대중교통금액 : etchBced */
    public String  getEtchBced() { return (String )get( ATTR_ETCHBCED );}

    /** set 기타공제_본인신용카드등사용액_2013 : cardEt13 */
    public void setCardEt13(String  cardEt13) { set( ATTR_CARDET13 ,cardEt13);}
    /** get 기타공제_본인신용카드등사용액_2013 : cardEt13 */
    public String  getCardEt13() { return (String )get( ATTR_CARDET13 );}

    /** set 기타공제_본인신용카드등사용액_2014 : cardEt14 */
    public void setCardEt14(String  cardEt14) { set( ATTR_CARDET14 ,cardEt14);}
    /** get 기타공제_본인신용카드등사용액_2014 : cardEt14 */
    public String  getCardEt14() { return (String )get( ATTR_CARDET14 );}

    /** set 기타공제_본인추가공재율사용액_2013 : etadDd13 */
    public void setEtadDd13(String  etadDd13) { set( ATTR_ETADDD13 ,etadDd13);}
    /** get 기타공제_본인추가공재율사용액_2013 : etadDd13 */
    public String  getEtadDd13() { return (String )get( ATTR_ETADDD13 );}

    /** set 기타공제_본인추가공제율사용액_2014하 : etadD14l */
    public void setEtadD14l(String  etadD14l) { set( ATTR_ETADD14L ,etadD14l);}
    /** get 기타공제_본인추가공제율사용액_2014하 : etadD14l */
    public String  getEtadD14l() { return (String )get( ATTR_ETADD14L );}

    /** set 기타공제_신용카드등사용공제계 : etchBcue */
    public void setEtchBcue(String  etchBcue) { set( ATTR_ETCHBCUE ,etchBcue);}
    /** get 기타공제_신용카드등사용공제계 : etchBcue */
    public String  getEtchBcue() { return (String )get( ATTR_ETCHBCUE );}

    /** set 기타공제_우리사주출연금액 : etckUnon */
    public void setEtckUnon(String  etckUnon) { set( ATTR_ETCKUNON ,etckUnon);}
    /** get 기타공제_우리사주출연금액 : etckUnon */
    public String  getEtckUnon() { return (String )get( ATTR_ETCKUNON );}

    /** set 기타공제_우리사주조합기부금2014이전 : etckUncb */
    public void setEtckUncb(String  etckUncb) { set( ATTR_ETCKUNCB ,etckUncb);}
    /** get 기타공제_우리사주조합기부금2014이전 : etckUncb */
    public String  getEtckUncb() { return (String )get( ATTR_ETCKUNCB );}

    /** set 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
    public void setEtepHsam(String  etepHsam) { set( ATTR_ETEPHSAM ,etepHsam);}
    /** get 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
    public String  getEtepHsam() { return (String )get( ATTR_ETEPHSAM );}

    /** set 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
    public void setEtgdCtra(String  etgdCtra) { set( ATTR_ETGDCTRA ,etgdCtra);}
    /** get 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
    public String  getEtgdCtra() { return (String )get( ATTR_ETGDCTRA );}

    /** set 기타공제_장기집합투자증권저축금액 : etepSest */
    public void setEtepSest(String  etepSest) { set( ATTR_ETEPSEST ,etepSest);}
    /** get 기타공제_장기집합투자증권저축금액 : etepSest */
    public String  getEtepSest() { return (String )get( ATTR_ETEPSEST );}

    /** set 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
    public void setEtclHm01(String  etclHm01) { set( ATTR_ETCLHM01 ,etclHm01);}
    /** get 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
    public String  getEtclHm01() { return (String )get( ATTR_ETCLHM01 );}

    /** set 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
    public void setEtclHm02(String  etclHm02) { set( ATTR_ETCLHM02 ,etclHm02);}
    /** get 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
    public String  getEtclHm02() { return (String )get( ATTR_ETCLHM02 );}

    /** set 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
    public void setEtclHm03(String  etclHm03) { set( ATTR_ETCLHM03 ,etclHm03);}
    /** get 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
    public String  getEtclHm03() { return (String )get( ATTR_ETCLHM03 );}

    /** set 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
    public void setEtclHmta(String  etclHmta) { set( ATTR_ETCLHMTA ,etclHmta);}
    /** get 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
    public String  getEtclHmta() { return (String )get( ATTR_ETCLHMTA );}

    /** set 기타공제_기타제목 : etclEttl */
    public void setEtclEttl(String  etclEttl) { set( ATTR_ETCLETTL ,etclEttl);}
    /** get 기타공제_기타제목 : etclEttl */
    public String  getEtclEttl() { return (String )get( ATTR_ETCLETTL );}

    /** set 기타공제_기타금액 : etclEtam */
    public void setEtclEtam(String  etclEtam) { set( ATTR_ETCLETAM ,etclEtam);}
    /** get 기타공제_기타금액 : etclEtam */
    public String  getEtclEtam() { return (String )get( ATTR_ETCLETAM );}

    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    public void setTaxdIncd(String  taxdIncd) { set( ATTR_TAXDINCD ,taxdIncd);}
    /** get 세액공제_외국인_입국목적코드 : taxdIncd */
    public String  getTaxdIncd() { return (String )get( ATTR_TAXDINCD );}
    
    /** set 세액공제_외국인_입국목적코드 : taxdIncd1 */
    public void setTaxdIncd2(String  taxdIncd2) { set( ATTR_TAXDINCD2 ,taxdIncd2);}
    /** get 세액공제_외국인_입국목적코드 : taxdIncd2 */
    public String  getTaxdIncd2() { return (String )get( ATTR_TAXDINCD2 );}
    
    /** set 세액공제_외국인_입국목적코드 : taxdIncd3 */
    public void setTaxdIncd3(String  taxdIncd3) { set( ATTR_TAXDINCD3 ,taxdIncd3);}
    /** get 세액공제_외국인_입국목적코드 : taxdIncd3 */
    public String  getTaxdIncd3() { return (String )get( ATTR_TAXDINCD3 );}
    
    /** set 세액공제_외국인_입국목적코드 : taxdIncd4 */
    public void setTaxdIncd4(String  taxdIncd4) { set( ATTR_TAXDINCD4 ,taxdIncd4);}
    /** get 세액공제_외국인_입국목적코드 : taxdIncd4 */
    public String  getTaxdIncd4() { return (String )get( ATTR_TAXDINCD4 );}
    
    /** set 세액공제_외국인_입국목적코드 : taxdIncd1 */
    public void setTaxdIncd1(String  taxdIncd1) { set( ATTR_TAXDINCD1 ,taxdIncd1);}
    /** get 세액공제_외국인_입국목적코드 : taxdIncd1 */
    public String  getTaxdIncd1() { return (String )get( ATTR_TAXDINCD1 );}

    /** set 세액공제_외국인_근로제공일자 : taxdWkdt */
    public void setTaxdWkdt(String  taxdWkdt) { set( ATTR_TAXDWKDT ,taxdWkdt);}
    /** get 세액공제_외국인_근로제공일자 : taxdWkdt */
    public String  getTaxdWkdt() { return (String )get( ATTR_TAXDWKDT );}

    /** set 세액공제_외국인_감면기간만료일자 : tamaEddt */
    public void setTamaEddt(String  tamaEddt) { set( ATTR_TAMAEDDT ,tamaEddt);}
    /** get 세액공제_외국인_감면기간만료일자 : tamaEddt */
    public String  getTamaEddt() { return (String )get( ATTR_TAMAEDDT );}

    /** set 세액공제_외국인_감면신청접수일자 : tamaIndt */
    public void setTamaIndt(String  tamaIndt) { set( ATTR_TAMAINDT ,tamaIndt);}
    /** get 세액공제_외국인_감면신청접수일자 : tamaIndt */
    public String  getTamaIndt() { return (String )get( ATTR_TAMAINDT );}

    /** set 세액공제_외국인_감면신청제출일자 : tamaOudt */
    public void setTamaOudt(String  tamaOudt) { set( ATTR_TAMAOUDT ,tamaOudt);}
    /** get 세액공제_외국인_감면신청제출일자 : tamaOudt */
    public String  getTamaOudt() { return (String )get( ATTR_TAMAOUDT );}

    /** set 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
    public void setTxlgFrrd(String  txlgFrrd) { set( ATTR_TXLGFRRD ,txlgFrrd);}
    /** get 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
    public String  getTxlgFrrd() { return (String )get( ATTR_TXLGFRRD );}

    /** set 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
    public void setTxlgFrid(String  txlgFrid) { set( ATTR_TXLGFRID ,txlgFrid);}
    /** get 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
    public String  getTxlgFrid() { return (String )get( ATTR_TXLGFRID );}

    /** set 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
    public void setTxlgWkid(String  txlgWkid) { set( ATTR_TXLGWKID ,txlgWkid);}
    /** get 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
    public String  getTxlgWkid() { return (String )get( ATTR_TXLGWKID );}

    /** set 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
    public void setTxlgTxtd(String  txlgTxtd) { set( ATTR_TXLGTXTD ,txlgTxtd);}
    /** get 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
    public String  getTxlgTxtd() { return (String )get( ATTR_TXLGTXTD );}

    /** set 세액공제_중소기업청년감면취업일자 : txlgBscd */
    public void setTxlgBscd(String  txlgBscd) { set( ATTR_TXLGBSCD ,txlgBscd);}
    /** get 세액공제_중소기업청년감면취업일자 : txlgBscd */
    public String  getTxlgBscd() { return (String )get( ATTR_TXLGBSCD );}

    /** set 세액공제_중소기업청년감면종료일자 : txlgBcde */
    public void setTxlgBcde(String  txlgBcde) { set( ATTR_TXLGBCDE ,txlgBcde);}
    /** get 세액공제_중소기업청년감면종료일자 : txlgBcde */
    public String  getTxlgBcde() { return (String )get( ATTR_TXLGBCDE );}

    /** set 세액감면_소득세법감면세액 : txlgItct */
    public void setTxlgItct(String  txlgItct) { set( ATTR_TXLGITCT ,txlgItct);}
    /** get 세액감면_소득세법감면세액 : txlgItct */
    public String  getTxlgItct() { return (String )get( ATTR_TXLGITCT );}

    /** set 세액감면_취업청년감면대상총급여액 : txlgBsta */
    public void setTxlgBsta(String  txlgBsta) { set( ATTR_TXLGBSTA ,txlgBsta);}
    /** get 세액감면_취업청년감면대상총급여액 : txlgBsta */
    public String  getTxlgBsta() { return (String )get( ATTR_TXLGBSTA );}

    /** set 세액감면_취업청년감면근로자총급여액 : txlgWkta */
    public void setTxlgWkta(String  txlgWkta) { set( ATTR_TXLGWKTA ,txlgWkta);}
    /** get 세액감면_취업청년감면근로자총급여액 : txlgWkta */
    public String  getTxlgWkta() { return (String )get( ATTR_TXLGWKTA );}

    /** set 세액감면_계산감면세액금액 : txlgClta */
    public void setTxlgClta(String  txlgClta) { set( ATTR_TXLGCLTA ,txlgClta);}
    /** get 세액감면_계산감면세액금액 : txlgClta */
    public String  getTxlgClta() { return (String )get( ATTR_TXLGCLTA );}

    /** set 세액감면_외국인기술자감면세액 : txlgFrta */
    public void setTxlgFrta(String  txlgFrta) { set( ATTR_TXLGFRTA ,txlgFrta);}
    /** get 세액감면_외국인기술자감면세액 : txlgFrta */
    public String  getTxlgFrta() { return (String )get( ATTR_TXLGFRTA );}

    /** set 세액감면_조세조약감면세액 : txlgTxty */
    public void setTxlgTxty(String  txlgTxty) { set( ATTR_TXLGTXTY ,txlgTxty);}
    /** get 세액감면_조세조약감면세액 : txlgTxty */
    public String  getTxlgTxty() { return (String )get( ATTR_TXLGTXTY );}

    /** set 세액공제_외국납부_국외원천소득금액 : txlgInam */
    public void setTxlgInam(String  txlgInam) { set( ATTR_TXLGINAM ,txlgInam);}
    /** get 세액공제_외국납부_국외원천소득금액 : txlgInam */
    public String  getTxlgInam() { return (String )get( ATTR_TXLGINAM );}

    /** set 세액공제_외국납부_외화납세액 : txlgDlam */
    public void setTxlgDlam(String  txlgDlam) { set( ATTR_TXLGDLAM ,txlgDlam);}
    /** get 세액공제_외국납부_외화납세액 : txlgDlam */
    public String  getTxlgDlam() { return (String )get( ATTR_TXLGDLAM );}

    /** set 세액공제_외국납부_원화납세액 : txlgWnam */
    public void setTxlgWnam(String  txlgWnam) { set( ATTR_TXLGWNAM ,txlgWnam);}
    /** get 세액공제_외국납부_원화납세액 : txlgWnam */
    public String  getTxlgWnam() { return (String )get( ATTR_TXLGWNAM );}

    /** set 세액공제_외국납부_납세국명 : txlgOtcy */
    public void setTxlgOtcy(String  txlgOtcy) { set( ATTR_TXLGOTCY ,txlgOtcy);}
    /** get 세액공제_외국납부_납세국명 : txlgOtcy */
    public String  getTxlgOtcy() { return (String )get( ATTR_TXLGOTCY );}

    /** set 세액공제_외국납부_납부일자 : txlgOtdt */
    public void setTxlgOtdt(String  txlgOtdt) { set( ATTR_TXLGOTDT ,txlgOtdt);}
    /** get 세액공제_외국납부_납부일자 : txlgOtdt */
    public String  getTxlgOtdt() { return (String )get( ATTR_TXLGOTDT );}

    /** set 세액공제_외국납부_신청서제출일자 : txlgApdt */
    public void setTxlgApdt(String  txlgApdt) { set( ATTR_TXLGAPDT ,txlgApdt);}
    /** get 세액공제_외국납부_신청서제출일자 : txlgApdt */
    public String  getTxlgApdt() { return (String )get( ATTR_TXLGAPDT );}

    /** set 세액공제_외국납부_국외근무처명 : txlgOuwk */
    public void setTxlgOuwk(String  txlgOuwk) { set( ATTR_TXLGOUWK ,txlgOuwk);}
    /** get 세액공제_외국납부_국외근무처명 : txlgOuwk */
    public String  getTxlgOuwk() { return (String )get( ATTR_TXLGOUWK );}

    /** set 세액공제_외국납부_근무시작일자 : txapStdt */
    public void setTxapStdt(String  txapStdt) { set( ATTR_TXAPSTDT ,txapStdt);}
    /** get 세액공제_외국납부_근무시작일자 : txapStdt */
    public String  getTxapStdt() { return (String )get( ATTR_TXAPSTDT );}

    /** set 세액공제_외국납부_근무종료일자 : txapEddt */
    public void setTxapEddt(String  txapEddt) { set( ATTR_TXAPEDDT ,txapEddt);}
    /** get 세액공제_외국납부_근무종료일자 : txapEddt */
    public String  getTxapEddt() { return (String )get( ATTR_TXAPEDDT );}

    /** set 세액공제_외국납부_직책 : txapWkdy */
    public void setTxapWkdy(String  txapWkdy) { set( ATTR_TXAPWKDY ,txapWkdy);}
    /** get 세액공제_외국납부_직책 : txapWkdy */
    public String  getTxapWkdy() { return (String)get( ATTR_TXAPWKDY );}

    /** set 세액공제_납세조합공제 : taxdUnin */
    public void setTaxdUnin(String  taxdUnin) { set( ATTR_TAXDUNIN ,taxdUnin);}
    /** get 세액공제_납세조합공제 : taxdUnin */
    public String  getTaxdUnin() { return (String )get( ATTR_TAXDUNIN );}
    
    /** set 세액공제_납세조합공제 : taxdUnin */
    public void setTaxdUnin01(String  taxdUnin01) { set( ATTR_TAXDUNIN01 ,taxdUnin01);}
    /** get 세액공제_납세조합공제 : taxdUnin */
    public String  getTaxdUnin01() { return (String )get( ATTR_TAXDUNIN01 );}

    /** set 세액공제_주택차입금이자상황금액 : taxdLoaa */
    public void setTaxdLoaa(String  taxdLoaa) { set( ATTR_TAXDLOAA ,taxdLoaa);}
    /** get 세액공제_주택차입금이자상황금액 : taxdLoaa */
    public String  getTaxdLoaa() { return (String )get( ATTR_TAXDLOAA );}

    /** set 추가서류_연금저축등소득공제제출여부 : addcNtyn */
    public void setAddcNtyn(String  addcNtyn) { set( ATTR_ADDCNTYN ,addcNtyn);}
    /** get 추가서류_연금저축등소득공제제출여부 : addcNtyn */
    public String  getAddcNtyn() { return (String )get( ATTR_ADDCNTYN );}

    /** set 추가서류_의료비지급명세서제출여부 : addcMdyn */
    public void setAddcMdyn(String  addcMdyn) { set( ATTR_ADDCMDYN ,addcMdyn);}
    /** get 추가서류_의료비지급명세서제출여부 : addcMdyn */
    public String  getAddcMdyn() { return (String )get( ATTR_ADDCMDYN );}

    /** set 추가서류_기부금명세서제출여부 : addcCtyn */
    public void setAddcCtyn(String  addcCtyn) { set( ATTR_ADDCCTYN ,addcCtyn);}
    /** get 추가서류_기부금명세서제출여부 : addcCtyn */
    public String  getAddcCtyn() { return (String )get( ATTR_ADDCCTYN );}

    /** set 추가서류_소득공제증빙서류제출여부 : addcPfyn */
    public void setAddcPfyn(String  addcPfyn) { set( ATTR_ADDCPFYN ,addcPfyn);}
    /** get 추가서류_소득공제증빙서류제출여부 : addcPfyn */
    public String  getAddcPfyn() { return (String )get( ATTR_ADDCPFYN );}

    /** set 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
    public void setAddfPvyn(String  addfPvyn) { set( ATTR_ADDFPVYN ,addfPvyn);}
    /** get 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
    public String  getAddfPvyn() { return (String )get( ATTR_ADDFPVYN );}

    /** set 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
    public void setSpciReyn(String  spciReyn) { set( ATTR_SPCIREYN ,spciReyn);}
    /** get 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
    public String  getSpciReyn() { return (String )get( ATTR_SPCIREYN );}

    /** set 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
    public void setTxlgMxtm(String  txlgMxtm) { set( ATTR_TXLGMXTM ,txlgMxtm);}
    /** get 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
    public String  getTxlgMxtm() { return (String )get( ATTR_TXLGMXTM );}

    /** set 소득신고제출일자 : incoOudt */
    public void setIncoOudt(String  incoOudt) { set( ATTR_INCOOUDT ,incoOudt);}
    /** get 소득신고제출일자 : incoOudt */
    public String  getIncoOudt() { return (String )get( ATTR_INCOOUDT );}

    /** set 소득신고제출여부 : incoOufg */
    public void setIncoOufg(String  incoOufg) { set( ATTR_INCOOUFG ,incoOufg);}
    /** get 소득신고제출여부 : incoOufg */
    public String  getIncoOufg() { return (String )get( ATTR_INCOOUFG );}

    /** set 파일생성여부 : jdocFile */
    public void setJdocFile(String  jdocFile) { set( ATTR_JDOCFILE ,jdocFile);}
    /** get 파일생성여부 : jdocFile */
    public String  getJdocFile() { return (String )get( ATTR_JDOCFILE );}

    /** set 파일생성여부 : jdocFnnm */
    public void setJdocFnnm(String  jdocFnnm) { set( ATTR_JDOCFNNM ,jdocFnnm);}
    /** get 파일생성여부 : jdocFnnm */
    public String  getJdocFnnm() { return (String )get( ATTR_JDOCFNNM );}     
    
    /** set 연금계좌계 : jrtrAtom */
    public void setJrtrAtom(String  jrtrAtom) { set( ATTR_JRTRATOM ,jrtrAtom);}
    /** get 연금계좌계 : jrtrAtom */
    public String  getJrtrAtom() { return (String )get( ATTR_JRTRATOM );}

    /** set 연금계좌공제대상금액 : jrtrTotr */
    public void setJrtrTotr(String  jrtrTotr) { set( ATTR_JRTRTOTR ,jrtrTotr);}
    /** get 연금계좌공제대상금액 : jrtrTotr */
    public String  getJrtrTotr() { return (String )get( ATTR_JRTRTOTR );}

    /** set 특별공제_장애인보장성대상금액 : spciHdtg */
    public void setSpciHdtg(String  spciHdtg) { set( ATTR_SPCIHDTG ,spciHdtg);}
    /** get 특별공제_장애인보장성대상금액 : spciHdtg */
    public String  getSpciHdtg() { return (String )get( ATTR_SPCIHDTG );}

    /** set 특별공제_보장성보험료대상금액 : spciDetg */
    public void setSpciDetg(String  spciDetg) { set( ATTR_SPCIDETG ,spciDetg);}
    /** get 특별공제_보장성보험료대상금액 : spciDetg */
    public String  getSpciDetg() { return (String )get( ATTR_SPCIDETG );}

    /** set 특별공제_보장성보험료계 : spciRtto */
    public void setSpciRtto(String  spciRtto) { set( ATTR_SPCIRTTO ,spciRtto);}
    /** get 특별공제_보장성보험료계 : spciRtto */
    public String  getSpciRtto() { return (String )get( ATTR_SPCIRTTO );}

    /** set 본인의료비공제대상금액 : spciSftg */
    public void setSpciSftg(String  spciSftg) { set( ATTR_SPCISFTG ,spciSftg);}
    /** get 본인의료비공제대상금액 : spciSftg */
    public String  getSpciSftg() { return (String )get( ATTR_SPCISFTG );}

    /** set 65세이상자의료비공제대상금액 : spci65tg */
    public void setSpci65tg(String  spci65tg) { set( ATTR_SPCI65TG ,spci65tg);}
    /** get 65세이상자의료비공제대상금액 : spci65tg */
    public String  getSpci65tg() { return (String )get( ATTR_SPCI65TG );}

    /** set 장애인의료비공제대상금액 : spciPstg */
    public void setSpciPstg(String  spciPstg) { set( ATTR_SPCIPSTG ,spciPstg);}
    /** get 장애인의료비공제대상금액 : spciPstg */
    public String  getSpciPstg() { return (String )get( ATTR_SPCIPSTG );}

    /** set 그밖의의료비공제대상금액 : spciEtcg */
    public void setSpciEtcg(String  spciEtcg) { set( ATTR_SPCIETCG ,spciEtcg);}
    /** get 그밖의의료비공제대상금액 : spciEtcg */
    public String  getSpciEtcg() { return (String )get( ATTR_SPCIETCG );}

    /** set 소득자본인교육비대상금액 : spedSftr */
    public void setSpedSftr(String  spedSftr) { set( ATTR_SPEDSFTR ,spedSftr);}
    /** get 소득자본인교육비대상금액 : spedSftr */
    public String  getSpedSftr() { return (String )get( ATTR_SPEDSFTR );}

    /** set 취학전아동교육비대상금액 : spedEdtr */
    public void setSpedEdtr(String  spedEdtr) { set( ATTR_SPEDEDTR ,spedEdtr);}
    /** get 취학전아동교육비대상금액 : spedEdtr */
    public String  getSpedEdtr() { return (String )get( ATTR_SPEDEDTR );}

    /** set 초중고교육비대상금액 : spedGdtr */
    public void setSpedGdtr(String  spedGdtr) { set( ATTR_SPEDGDTR ,spedGdtr);}
    /** get 초중고교육비대상금액 : spedGdtr */
    public String  getSpedGdtr() { return (String )get( ATTR_SPEDGDTR );}

    /** set 대학생교육비대상금액 : spedCvtr */
    public void setSpedCvtr(String  spedCvtr) { set( ATTR_SPEDCVTR ,spedCvtr);}
    /** get 대학생교육비대상금액 : spedCvtr */
    public String  getSpedCvtr() { return (String )get( ATTR_SPEDCVTR );}

    /** set 특수교육비공제대상금액 : spciSctr */
    public void setSpciSctr(String  spciSctr) { set( ATTR_SPCISCTR ,spciSctr);}
    /** get 특수교육비공제대상금액 : spciSctr */
    public String  getSpciSctr() { return (String )get( ATTR_SPCISCTR );}

    /** set 특례기부금_공익법인제외대상금액 : spciExtg */
    public void setSpciExtg(String  spciExtg) { set( ATTR_SPCIEXTG ,spciExtg);}
    /** get 특례기부금_공익법인제외대상금액 : spciExtg */
    public String  getSpciExtg() { return (String )get( ATTR_SPCIEXTG );}

    /** set 공익법인신탁대상금액 : spciUntg */
    public void setSpciUntg(String  spciUntg) { set( ATTR_SPCIUNTG ,spciUntg);}
    /** get 공익법인신탁대상금액 : spciUntg */
    public String  getSpciUntg() { return (String )get( ATTR_SPCIUNTG );}

    /** set 우리사주종합기부대상금액 : spciHftg */
    public void setSpciHftg(String  spciHftg) { set( ATTR_SPCIHFTG ,spciHftg);}
    /** get 우리사주종합기부대상금액 : spciHftg */
    public String  getSpciHftg() { return (String )get( ATTR_SPCIHFTG );}

    /** set 종교단체외지정대상금액 : spciNatg */
    public void setSpciNatg(String  spciNatg) { set( ATTR_SPCINATG ,spciNatg);}
    /** get 종교단체외지정대상금액 : spciNatg */
    public String  getSpciNatg() { return (String )get( ATTR_SPCINATG );}

    /** set 종교단체지정대상금액 : spciYatg */
    public void setSpciYatg(String  spciYatg) { set( ATTR_SPCIYATG ,spciYatg);}
    /** get 종교단체지정대상금액 : spciYatg */
    public String  getSpciYatg() { return (String )get( ATTR_SPCIYATG );}

    /** set 기부금합계금액 : spciDgam */
    public void setSpciDgam(String  spciDgam) { set( ATTR_SPCIDGAM ,spciDgam);}
    /** get 기부금합계금액 : spciDgam */
    public String  getSpciDgam() { return (String )get( ATTR_SPCIDGAM );}

    /** set 이월특례기부금_공익신탁금액 : spciOnon */
    public void setSpciOnon(String  spciOnon) { set( ATTR_SPCIONON ,spciOnon);}
    /** get 이월특례기부금_공익신탁금액 : spciOnon */
    public String  getSpciOnon() { return (String )get( ATTR_SPCIONON );}

    /** set 이월법정기부금액 : spciObam */
    public void setSpciObam(String  spciObam) { set( ATTR_SPCIOBAM ,spciObam);}
    /** get 이월법정기부금액 : spciObam */
    public String  getSpciObam() { return (String )get( ATTR_SPCIOBAM );}

    /** set 이월종교단체기부금 : spciOyam */
    public void setSpciOyam(String  spciOyam) { set( ATTR_SPCIOYAM ,spciOyam);}
    /** get 이월종교단체기부금 : spciOyam */
    public String  getSpciOyam() { return (String )get( ATTR_SPCIOYAM );}

    /** set 이월종교단체외기부금 : spciOnam */
    public void setSpciOnam(String  spciOnam) { set( ATTR_SPCIONAM ,spciOnam);}
    /** get 이월종교단체외기부금 : spciOnam */
    public String  getSpciOnam() { return (String )get( ATTR_SPCIONAM );}

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

       
    
    /** set 부서명 : deptNm */
  	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
  	/** get 부서명 : deptNm */
  	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    
    /** set 사업명 : businNm */
	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** set 사업명 : businNm */
	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
	
    /** set 직종명 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** set 직종명 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
	
    /** set 직종세통합코드명 : dtilOccuInttnNm */
	public void setDtilOccuInttnNm(String  dtilOccuInttnNm) { set( ATTR_DTILOCCUINTTNNM ,dtilOccuInttnNm);}
	/** set 직종세통합코드명 : dtilOccuClsDivNm */
	public String  getDtilOccuInttnNm() { return (String )get( ATTR_DTILOCCUINTTNNM );}
	
	/** set 기타공제_본인신용카등사용액_2015 : cardEt15 */
	public void setCardEt15(String  cardEt15) { set( ATTR_CARDET15 ,cardEt15);}
	/** get 기타공제_본인신용카등사용액_2015 : cardEt15 */
	public String  getCardEt15() { return (String )get( ATTR_CARDET15 );}
	/** set 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
	public void setEtadD15h(String  etadD15h) { set( ATTR_ETADD15H ,etadD15h);}
	/** get 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
	public String  getEtadD15h() { return (String )get( ATTR_ETADD15H );}
	/** set 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
	public void setEtadD15l(String  etadD15l) { set( ATTR_ETADD15L ,etadD15l);}
	/** get 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
	public String  getEtadD15l() { return (String )get( ATTR_ETADD15L );}
	
	
	
	
	/** set 세액공제_주택차입금 : taxdLoan */
    public static final String ATTR_TAXDLOAN = "taxdLoan";
    
    /** set 세액공제_외국인감면세액 : taxdRedu */
    public static final String ATTR_TAXDREDU = "taxdRedu";
    
    /** set 세액감면_조세조약 : txlgHxtt */
    public static final String ATTR_TXLGHXTT = "txlgHxtt";
    
    /** set 세액감면_소득세법 : taxdIcax */
    public static final String ATTR_TAXDICAX = "taxdIcax";
    
    /** set 세액감면_감면세액계 : taxdTsum */
    public static final String ATTR_TAXDTSUM = "taxdTsum";
    
    /** set 세액공제_기부정치자금 : taxdPltc */
    public static final String ATTR_TAXDPLTC01 = "taxdPltc01";
    
    /** set 특별공제_기부금_정치 : spciPltc */
    public static final String ATTR_SPCIPLTC01 = "spciPltc01";
    
    /** set 특별공제_기부금_법정 : spciFbam */
    public static final String ATTR_SPCIFBAM01 = "spciFbam01";
    
    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public static final String ATTR_SPCIEXAM01 = "spciExam01";
    
    /** set 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public static final String ATTR_SPCIRFAM = "spciRfam";
    
    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public static final String ATTR_SPCINAMT01 = "spciNamt01";
    
    /** set 특별공제_기부금_종교단체 : spciYamt */
    public static final String ATTR_SPCIYAMT01 = "spciYamt01";
    
    /** set 특별공제_지정기부금세액공제금액 : spciDgcr */
    public static final String ATTR_SPCIDGCR = "spciDgcr";
    
    /** set 이월법정기부금액 : spciObam */
    public static final String ATTR_SPCIOBAM01 = "spciObam01";
    
    /** set 이월종교단체기부금 : spciOyam */
    public static final String ATTR_SPCIOYAM01 = "spciOyam01";
    
    /** set 이월종교단체외기부금 : spciOnam */
    public static final String ATTR_SPCIONAM01 = "spciOnam01";
    
    /** set 특별공제_교육비_본인 : spedSelf */
    public static final String ATTR_SPEDSELF01 = "spedSelf01";
    
    /** set 특별공제_교육비_취학전아동 : spedGrde */
    public static final String ATTR_SPEDGRDE = "spedGrde";
    
    /** set 특별공제_교육비_초중고 : spedGdto */
    public static final String ATTR_SPEDGDTO = "spedGdto";
    
    /** set 특별공제_교육비_대학교 : spedCldv */
    public static final String ATTR_SPEDCLDV = "spedCldv";
    
    /** set 특별공제_장애인특수교육비 : spciSpec */
    public static final String ATTR_SPCISPEC = "spciSpec";
    
    /** set 특별공제_교육비세액공제금액 : spedTxcr */
    public static final String ATTR_SPEDTXCR = "spedTxcr";
    
    /** set 특별공제_의료비_본인 : spciSelf */
    public static final String ATTR_SPCISELF01 = "spciSelf01";
    
    /** set 특별공제_의료비_경로65세이상 : spciHe65 */
    public static final String ATTR_SPCIHE65 = "spciHe65";
    
    /** set 특별공제_의료비_장애인 : spciHbps */
    public static final String ATTR_SPCIHBPS = "spciHbps";
    
    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public static final String ATTR_SPCIDETC01 = "spciDetc01";
    
    /** set 특별공제_의료비세액공제액 : spciTxcr */
    public static final String ATTR_SPCITXCR = "spciTxcr";
    
    
    /** set 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public static final String ATTR_JRTRHICT = "jrtrHict";
    
    /** set 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public static final String ATTR_JRTRPSRN = "jrtrPsrn";
    
    /** set 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public static final String ATTR_JRTRHNSV = "jrtrHnsv";
    
    /** set 연금계좌세액공제계 : jrtrHnto */
    public static final String ATTR_JRTRHNTO = "jrtrHnto";
    
    /** set 특별공제_일반보장성보험료 : spciGurt */
    public static final String ATTR_SPCIGURT01 = "spciGurt01";
    
    /** set 특별공제_장애인보장성보험료 : spciHdrc */
    public static final String ATTR_SPCIHDRC01 = "spciHdrc01";
    
    /** set 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public static final String ATTR_SPCIRTDE = "spciRtde";
    
    /** set 기타공제_우리사주출연금공제 : etckUnon */
    public static final String ATTR_ETCKUNON01 = "etckUnon01";
    
    /** set 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public static final String ATTR_ETCKUNCR = "etckUncr";
    
    /** set 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public static final String ATTR_ETEPMSAM = "etepMsam";
    
    /** set 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public static final String ATTR_ETGDHTRA = "etgdHtra";
    
    /** set 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public static final String ATTR_ETEPSECR = "etepSecr";
    
    /** set 기타공제_공제계 : etcdTsum */
    public static final String ATTR_ETCDTSUM = "etcdTsum";
    
    /** set 개인연금저축불입액_2000년이전 : etcpPsnv */
    public static final String ATTR_ETCPPSNV = "etcpPsnv";
    
    /** set 기타공제_소기업공제불입금 : etchPrep */
    public static final String ATTR_ETCHPREP01 = "etchPrep01";
    
    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public static final String ATTR_ETCSCOMP01 = "etcsComp01";
    
    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public static final String ATTR_ETWKSBAM = "etwkSbam";
    
    /** set 기타공제_주택마련저축소득공제계 : etwkBdam */
    public static final String ATTR_ETWKBDAM = "etwkBdam";
    
    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public static final String ATTR_ETWKSVAM = "etwkSvam";
    
    /** set 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public static final String ATTR_ETGD09AF = "etgd09af";
    
    /** set 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public static final String ATTR_ETGDH13H = "etgdH13h";
    
    /** set 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public static final String ATTR_ETGDD14F = "etgdD14f";
    
    /** set 특별공제_기부금공제액계 : spciSsum */
    public static final String ATTR_SPCISSUM = "spciSsum";
    
    /** set 기타공제_신용카드등사용액소득공제 : etccCard */
    public static final String ATTR_ETCCCARD = "etccCard";
    
    /** set 기타공제_투자조합출자공제액계 : etgdDdam */
    public static final String ATTR_ETGDDDAM = "etgdDdam";
    
    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public static final String ATTR_SPCI10FB = "spci10fb";
    
    /** set 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public static final String ATTR_SPCI15EC = "spci15ec";
    
    /** set 특별공제_주택자금공제액계 : spchReto */
    public static final String ATTR_SPCHRETO = "spchReto";
    
    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public static final String ATTR_SPCI15FB = "spci15fb";
    
    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public static final String ATTR_SPCI15FX = "spci15fx";
    
    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    public static final String ATTR_SPCHREEC01 = "spchReec01";
    
    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public static final String ATTR_SPCHREFX01 = "spchRefx01";
    
    /** set 특별공제_11장기주택저당차입금30 : spchRe30 */
    public static final String ATTR_SPCHRE30 = "spchRe30";
    
    /** set 특별공제_11장기주택저당차입금29 : spchRe29 */
    public static final String ATTR_SPCHRE29 = "spchRe29";
    
    /** set 특별공제_11장기주택저당차입금15 : spchRe15 */
    public static final String ATTR_SPCHRE15 = "spchRe15";
    
    /** set 특별공제_주택자금월세공제액 : spciRtam */
    public static final String ATTR_SPCIRTAM = "spciRtam";
    
    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public static final String ATTR_SPCIRESF01 = "spciResf01";
    
    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public static final String ATTR_SPCIREFN01 = "spciRefn01";
    
    /** set 특별공제_종건강보험료 : spciBhth */
    public static final String ATTR_SPCIBHTH = "spciBhth";
    
    /** set 특별공제_주건강보험료 : spciJhth */
    public static final String ATTR_SPCIJHTH = "spciJhth";
    
    /** set 특별공제_종고용보험료 : spciBepf */
    public static final String ATTR_SPCIBEPF01 = "spciBepf01";
    
    /** set 특별공제_주고용보험료 : spciJepf */
    public static final String ATTR_SPCIJEPF01 = "spciJepf01";
    
    /** set 특별공제_보험료계 : spciHrto */
    public static final String ATTR_SPCIHRTO = "spciHrto";
    
    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    public static final String ATTR_BNATDDCT = "bnatDdct";
    
    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    public static final String ATTR_JNATDDCT = "jnatDdct";

    /** set 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public static final String ATTR_BPSSHPUL = "bpssHpul";
    
    /** set 주근무지_공무원연금보험료공제 : jpssHpul */
    public static final String ATTR_JPSSHPUL = "jpssHpul";
    
    /** set 종근무지_국민연금외군인연금공제 : bpssHsol */
    public static final String ATTR_BPSSHSOL = "bpssHsol";
    
    /** set 주근무지_국민연금외군인연금공제 : jpssHsol */
    public static final String ATTR_JPSSHSOL = "jpssHsol";
    
    /** set 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public static final String ATTR_BPSSHTEC = "bpssHtec";
    
    /** set 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public static final String ATTR_JPSSHTEC = "jpssHtec";
    
    /** set 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public static final String ATTR_BPSSDDCT = "bpssDdct";
    
    /** set 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public static final String ATTR_JPSSDDCT = "jpssDdct";
    
    /** set 연금보험료공제계 : rrptYnam */
    public static final String ATTR_RRPTYNAM = "rrptYnam";
    
    /** set 세액공제_자녀세액공제금액 : addrMccr */
    public static final String ATTR_ADDRMCCR = "addrMccr";
    
    /** set 이전근무지_총급여 : dcsnTots */
    public static final String ATTR_DCSNTOTS = "dcsnTots";
    
    /** set 주근무지_급여총액 : payrTamt */
    public static final String ATTR_PAYRTAMT = "payrTamt";
    
    /** set 총급여_현_전 : totlSala */
    public static final String ATTR_TOTLSALA = "totlSala";
    
    /** set 근로소득공제 : wkerDdct */
    public static final String ATTR_WKERDDCT = "wkerDdct";
    
    public static final String ATTR_WKERAMNT = "wkerAmnt";
    
    /** set 결정세액_소득세 : dcsnIncm */
    public static final String ATTR_DCSNINCM = "dcsnIncm";
    
    /** set 결정세액_주민세_지방소득세 : dcsnInhb */
    public static final String ATTR_DCSNINHB = "dcsnInhb";
    
    /** set 세액공제_근로소득세액공제 : taxdWken */
    public static final String ATTR_TAXDWKEN = "taxdWken";
    
    /** set 기납부세액_소득세 : alryPinx */
    public static final String ATTR_ALRYPINX = "alryPinx";
    
    /** set 기납부세액_주민세_지방소득세 : alryPhbx */
    public static final String ATTR_ALRYPHBX = "alryPhbx";
    
    /** set 기타공제_투자조합출자금액_2015년이후 : etgdD15f */
    public static final String ATTR_ETGDD15F = "etgdD15f";
    

    /** set 세액공제_주택차입금 : taxdLoan */
    public void setTaxdLoan(String  taxdLoan) { set( ATTR_TAXDLOAN ,taxdLoan);}
    /** get 세액공제_주택차입금 : taxdLoan */
    public String  getTaxdLoan() { return (String )get( ATTR_TAXDLOAN );}
    
    /** set 세액공제_외국인감면세액 : taxdRedu */
    public void setTaxdRedu(String  taxdRedu) { set( ATTR_TAXDREDU ,taxdRedu);}
    /** get 세액공제_외국인감면세액 : taxdRedu */
    public String  getTaxdRedu() { return (String )get( ATTR_TAXDREDU );}
    
    /** set 세액감면_조세조약 : txlgHxtt */
    public void setTxlgHxtt(String  txlgHxtt) { set( ATTR_TXLGHXTT ,txlgHxtt);}
    /** get 세액감면_조세조약 : txlgHxtt */
    public String  getTxlgHxtt() { return (String )get( ATTR_TXLGHXTT );}
    
    /** set 세액감면_소득세법 : taxdIcax */
    public void setTaxdIcax(String  taxdIcax) { set( ATTR_TAXDICAX ,taxdIcax);}
    /** get 세액감면_소득세법 : taxdIcax */
    public String  getTaxdIcax() { return (String )get( ATTR_TAXDICAX );}
    
    
    /** set 세액감면_감면세액계 : taxdTsum */
    public void setTaxdTsum(String  taxdTsum) { set( ATTR_TAXDTSUM ,taxdTsum);}
    /** get 세액감면_감면세액계 : taxdTsum */
    public String  getTaxdTsum() { return (String )get( ATTR_TAXDTSUM );}
    
    /** set 세액공제_기부정치자금 : taxdPltc */
    public void setTaxdPltc01(String  taxdPltc01) { set( ATTR_TAXDPLTC01 ,taxdPltc01);}
    /** get 세액공제_기부정치자금 : taxdPltc */
    public String  getTaxdPltc01() { return (String )get( ATTR_TAXDPLTC01 );}
    
    
    /** set 특별공제_기부금_정치 : spciPltc */
    public void setSpciPltc01(String  spciPltc01) { set( ATTR_SPCIPLTC01 ,spciPltc01);}
    /** get 특별공제_기부금_정치 : spciPltc */
    public String  getSpciPltc01() { return (String )get( ATTR_SPCIPLTC01 );}
    
    /** set 특별공제_기부금_법정 : spciFbam */
    public void setSpciFbam01(String  spciFbam01) { set( ATTR_SPCIFBAM01 ,spciFbam01);}
    /** get 특별공제_기부금_법정 : spciFbam */
    public String  getSpciFbam01() { return (String )get( ATTR_SPCIFBAM01 );}
	
    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public void setSpciExam01(String  spciExam01) { set( ATTR_SPCIEXAM01 ,spciExam01);}
    /** get 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public String  getSpciExam01() { return (String )get( ATTR_SPCIEXAM01 );}
    
    /** set 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public void setSpciRfam(String  spciRfam) { set( ATTR_SPCIRFAM ,spciRfam);}
    /** get 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public String  getSpciRfam() { return (String )get( ATTR_SPCIRFAM );}
	
    
    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public void setSpciNamt01(String  spciNamt01) { set( ATTR_SPCINAMT01 ,spciNamt01);}
    /** get 특별공제_기부금_종교단체외 : spciNamt */
    public String  getSpciNamt01() { return (String )get( ATTR_SPCINAMT01 );}
    
    /** set 특별공제_기부금_종교단체 : spciYamt */
    public void setSpciYamt01(String  spciYamt01) { set( ATTR_SPCIYAMT01 ,spciYamt01);}
    /** get 특별공제_기부금_종교단체 : spciYamt */
    public String  getSpciYamt01() { return (String )get( ATTR_SPCIYAMT01 );}
    
    /** set 특별공제_지정기부금세액공제금액 : spciDgcr */
    public void setSpciDgcr(String  spciDgcr) { set( ATTR_SPCIDGCR ,spciDgcr);}
    /** get 특별공제_지정기부금세액공제금액 : spciDgcr */
    public String  getSpciDgcr() { return (String )get( ATTR_SPCIDGCR );}
    
    /** set 이월법정기부금액 : spciObam */
    public void setSpciObam01(String  spciObam01) { set( ATTR_SPCIOBAM01 ,spciObam01);}
    /** get 이월법정기부금액 : spciObam */
    public String  getSpciObam01() { return (String )get( ATTR_SPCIOBAM01 );}
    
    /** set 이월종교단체기부금 : spciOyam */
    public void setSpciOyam01(String  spciOyam01) { set( ATTR_SPCIOYAM01 ,spciOyam01);}
    /** get 이월종교단체기부금 : spciOyam */
    public String  getSpciOyam01() { return (String )get( ATTR_SPCIOYAM01 );}
    
    /** set 이월종교단체외기부금 : spciOnam */
    public void setSpciOnam01(String  spciOnam01) { set( ATTR_SPCIONAM01 ,spciOnam01);}
    /** get 이월종교단체외기부금 : spciOnam */
    public String  getSpciOnam01() { return (String )get( ATTR_SPCIONAM01 );}
    
    /** set 특별공제_교육비_본인 : spedSelf */
    public void setSpedSelf01(String  spedSelf01) { set( ATTR_SPEDSELF01 ,spedSelf01);}
    /** get 특별공제_교육비_본인 : spedSelf */
    public String  getSpedSelf01() { return (String )get( ATTR_SPEDSELF01 );}
    
    /** set 특별공제_교육비_취학전아동 : spedGrde */
    public void setSpedGrde(String  spedGrde) { set( ATTR_SPEDGRDE ,spedGrde);}
    /** get 특별공제_교육비_취학전아동 : spedGrde */
    public String  getSpedGrde() { return (String )get( ATTR_SPEDGRDE );}
    
    /** set 특별공제_교육비_초중고 : spedGdto */
    public void setSpedGdto(String  spedGdto) { set( ATTR_SPEDGDTO ,spedGdto);}
    /** get 특별공제_교육비_초중고 : spedGdto */
    public String  getSpedGdto() { return (String )get( ATTR_SPEDGDTO );}
    
    /** set 특별공제_교육비_대학교 : spedCldv */
    public void setSpedCldv(String  spedCldv) { set( ATTR_SPEDCLDV ,spedCldv);}
    /** get 특별공제_교육비_대학교 : spedCldv */
    public String  getSpedCldv() { return (String )get( ATTR_SPEDCLDV );}
    
    /** set 특별공제_장애인특수교육비 : spciSpec */
    public void setSpciSpec(String  spciSpec) { set( ATTR_SPCISPEC ,spciSpec);}
    /** get 특별공제_장애인특수교육비 : spciSpec */
    public String  getSpciSpec() { return (String )get( ATTR_SPCISPEC );}
    
    /** set 특별공제_교육비세액공제금액 : spedTxcr */
    public void setSpedTxcr(String  spedTxcr) { set( ATTR_SPEDTXCR ,spedTxcr);}
    /** get 특별공제_교육비세액공제금액 : spedTxcr */
    public String  getSpedTxcr() { return (String )get( ATTR_SPEDTXCR );}
	
    /** set 특별공제_의료비_본인 : spciSelf */
    public void setSpciSelf01(String  spciSelf01) { set( ATTR_SPCISELF01 ,spciSelf01);}
    /** get 특별공제_의료비_본인 : spciSelf */
    public String  getSpciSelf01() { return (String )get( ATTR_SPCISELF01 );}
    
    /** set 특별공제_의료비_경로65세이상 : spciHe65 */
    public void setSpciHe65(String  spciHe65) { set( ATTR_SPCIHE65 ,spciHe65);}
    /** get 특별공제_의료비_경로65세이상 : spciHe65 */
    public String  getSpciHe65() { return (String )get( ATTR_SPCIHE65 );}
    
    /** set 특별공제_의료비_장애인 : spciHbps */
    public void setSpciHbps(String  spciHbps) { set( ATTR_SPCIHBPS ,spciHbps);}
    /** get 특별공제_의료비_장애인 : spciHbps */
    public String  getSpciHbps() { return (String )get( ATTR_SPCIHBPS );}
    
    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public void setSpciDetc01(String  spciDetc01) { set( ATTR_SPCIDETC01 ,spciDetc01);}
    /** get 특별공제_의료비_기타공제대상자 : spciDetc */
    public String  getSpciDetc01() { return (String )get( ATTR_SPCIDETC01 );}
    
    /** set 특별공제_의료비세액공제액 : spciTxcr */
    public void setSpciTxcr(String  spciTxcr) { set( ATTR_SPCITXCR ,spciTxcr);}
    /** get 특별공제_의료비세액공제액 : spciTxcr */
    public String  getSpciTxcr() { return (String )get( ATTR_SPCITXCR );}
    
    /** set 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public void setJrtrHict(String  jrtrHict) { set( ATTR_JRTRHICT ,jrtrHict);}
    /** get 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public String  getJrtrHict() { return (String )get( ATTR_JRTRHICT );}
    
    /** set 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public void setJrtrPsrn(String  jrtrPsrn) { set( ATTR_JRTRPSRN ,jrtrPsrn);}
    /** get 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public String  getJrtrPsrn() { return (String )get( ATTR_JRTRPSRN );}
    
    /** set 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public void setJrtrHnsv(String  jrtrHnsv) { set( ATTR_JRTRHNSV ,jrtrHnsv);}
    /** get 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public String  getJrtrHnsv() { return (String )get( ATTR_JRTRHNSV );}
    
    /** set 연금계좌세액공제계 : jrtrHnto */
    public void setJrtrHnto(String  jrtrHnto) { set( ATTR_JRTRHNTO ,jrtrHnto);}
    /** get 연금계좌세액공제계 : jrtrHnto */
    public String  getJrtrHnto() { return (String )get( ATTR_JRTRHNTO );}
    
    /** set 특별공제_일반보장성보험료 : spciGurt */
    public void setSpciGurt01(String  spciGurt01) { set( ATTR_SPCIGURT01 ,spciGurt01);}
    /** get 특별공제_일반보장성보험료 : spciGurt */
    public String  getSpciGurt01() { return (String )get( ATTR_SPCIGURT01 );}
    
    /** set 특별공제_장애인보장성보험료 : spciHdrc */
    public void setSpciHdrc01(String  spciHdrc01) { set( ATTR_SPCIHDRC01 ,spciHdrc01);}
    /** get 특별공제_장애인보장성보험료 : spciHdrc */
    public String  getSpciHdrc01() { return (String )get( ATTR_SPCIHDRC01 );}
    
    /** set 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public void setSpciRtde(String  spciRtde) { set( ATTR_SPCIRTDE ,spciRtde);}
    /** get 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public String  getSpciRtde() { return (String )get( ATTR_SPCIRTDE );}
    
    /** set 기타공제_우리사주출연금공제 : etckUnon */
    public void setEtckUnon01(String  etckUnon01) { set( ATTR_ETCKUNON01 ,etckUnon01);}
    /** get 기타공제_우리사주출연금공제 : etckUnon */
    public String  getEtckUnon01() { return (String )get( ATTR_ETCKUNON01 );}
    
    /** set 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public void setEtckUncr(String  etckUncr) { set( ATTR_ETCKUNCR ,etckUncr);}
    /** get 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public String  getEtckUncr() { return (String )get( ATTR_ETCKUNCR );}
    
    /** set 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public void setEtepMsam(String  etepMsam) { set( ATTR_ETEPMSAM ,etepMsam);}
    /** get 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public String  getEtepMsam() { return (String )get( ATTR_ETEPMSAM );}
    
    /** set 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public void setEtgdHtra(String  etgdHtra) { set( ATTR_ETGDHTRA ,etgdHtra);}
    /** get 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public String  getEtgdHtra() { return (String )get( ATTR_ETGDHTRA );}
    
    /** set 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public void setEtepSecr(String  etepSecr) { set( ATTR_ETEPSECR ,etepSecr);}
    /** get 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public String  getEtepSecr() { return (String )get( ATTR_ETEPSECR );}
    
    /** set 기타공제_공제계 : etcdTsum */
    public void setEtcdTsum(String  etcdTsum) { set( ATTR_ETCDTSUM ,etcdTsum);}
    /** get 기타공제_공제계 : etcdTsum */
    public String  getEtcdTsum() { return (String )get( ATTR_ETCDTSUM );}
    
    /** set 개인연금저축불입액_2000년이전 : etcpPsnv */
    public void setEtcpPsnv(String  etcpPsnv) { set( ATTR_ETCPPSNV ,etcpPsnv);}
    /** get 개인연금저축불입액_2000년이전 : etcpPsnv */
    public String  getEtcpPsnv() { return (String )get( ATTR_ETCPPSNV );}
	
    /** set 기타공제_소기업공제불입금 : etchPrep */
    public void setEtchPrep01(String  etchPrep01) { set( ATTR_ETCHPREP01 ,etchPrep01);}
    /** get 기타공제_소기업공제불입금 : etchPrep */
    public String  getEtchPrep01() { return (String )get( ATTR_ETCHPREP01 );}
    
    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public void setEtcsComp01(String  etcsComp01) { set( ATTR_ETCSCOMP01 ,etcsComp01);}
    /** get 기타공제_주택마련저축_청약저축 : etcsComp */
    public String  getEtcsComp01() { return (String )get( ATTR_ETCSCOMP01 );}
    
    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public void setEtwkSbam(String  etwkSbam) { set( ATTR_ETWKSBAM ,etwkSbam);}
    /** get 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public String  getEtwkSbam() { return (String )get( ATTR_ETWKSBAM );}
    
    /** set 기타공제_주택마련저축소득공제계 : etwkBdam */
    public void setEtwkBdam(String  etwkBdam) { set( ATTR_ETWKBDAM ,etwkBdam);}
    /** get 기타공제_주택마련저축소득공제계 : etwkBdam */
    public String  getEtwkBdam() { return (String )get( ATTR_ETWKBDAM );}
    
    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public void setEtwkSvam(String  etwkSvam) { set( ATTR_ETWKSVAM ,etwkSvam);}
    /** get 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public String  getEtwkSvam() { return (String )get( ATTR_ETWKSVAM );}
    
    /** set 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public void setEtgd09af(String  etgd09af) { set( ATTR_ETGD09AF ,etgd09af);}
    /** get 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public String  getEtgd09af() { return (String )get( ATTR_ETGD09AF );}
    
    /** set 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public void setEtgdH13h(String  etgdH13h) { set( ATTR_ETGDH13H ,etgdH13h);}
    /** get 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public String  getEtgdH13h() { return (String )get( ATTR_ETGDH13H );}
    
    /** set 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public void setEtgdD14f(String  etgdD14f) { set( ATTR_ETGDD14F ,etgdD14f);}
    /** get 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public String  getEtgdD14f() { return (String )get( ATTR_ETGDD14F );}
    
    /** set 특별공제_기부금공제액계 : spciSsum */
    public void setSpciSsum(String  spciSsum) { set( ATTR_SPCISSUM ,spciSsum);}
    /** get 특별공제_기부금공제액계 : spciSsum */
    public String  getSpciSsum() { return (String )get( ATTR_SPCISSUM );}
    
    /** set 기타공제_신용카드등사용액소득공제 : etccCard */
    public void setEtccCard(String  etccCard) { set( ATTR_ETCCCARD ,etccCard);}
    /** get 기타공제_신용카드등사용액소득공제 : etccCard */
    public String  getEtccCard() { return (String )get( ATTR_ETCCCARD );}
    
    /** set 기타공제_투자조합출자공제액계 : etgdDdam */
    public void setEtgdDdam(String  etgdDdam) { set( ATTR_ETGDDDAM ,etgdDdam);}
    /** get 기타공제_투자조합출자공제액계 : etgdDdam */
    public String  getEtgdDdam() { return (String )get( ATTR_ETGDDDAM );}
    
    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public void setSpci10fb(String  spci10fb) { set( ATTR_SPCI10FB ,spci10fb);}
    /** get 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public String  getSpci10fb() { return (String )get( ATTR_SPCI10FB );}
    
    /** set 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public void setSpci15ec(String  spci15ec) { set( ATTR_SPCI15EC ,spci15ec);}
    /** get 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public String  getSpci15ec() { return (String )get( ATTR_SPCI15EC );}
    
    /** set 특별공제_주택자금공제액계 : spchReto */
    public void setSpchReto(String  spchReto) { set( ATTR_SPCHRETO ,spchReto);}
    /** get 특별공제_주택자금공제액계 : spchReto */
    public String  getSpchReto() { return (String )get( ATTR_SPCHRETO );}
    
    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public void setSpci15fb(String  spci15fb) { set( ATTR_SPCI15FB ,spci15fb);}
    /** get 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public String  getSpci15fb() { return (String )get( ATTR_SPCI15FB );}
    
    
    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public void setSpci15fx(String  spci15fx) { set( ATTR_SPCI15FX ,spci15fx);}
    /** get 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public String  getSpci15fx() { return (String )get( ATTR_SPCI15FX );}
    
    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    public void setSpchReec01(String  spchReec01) { set( ATTR_SPCHREEC01 ,spchReec01);}
    /** get 특별공제_12장기주택저당차입금_기타 : spchReec */
    public String  getSpchReec01() { return (String )get( ATTR_SPCHREEC01 );}
    
    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public void setSpchRefx01(String  spchRefx01) { set( ATTR_SPCHREFX01 ,spchRefx01);}
    /** get 특별공제_12장기주택저당차입금_고정 : spchRefx */
    public String  getSpchRefx01() { return (String )get( ATTR_SPCHREFX01 );}
    
    /** set 특별공제_11장기주택저당차입금30 : spchRe30 */
    public void setSpchRe30(String  spchRe30) { set( ATTR_SPCHRE30 ,spchRe30);}
    /** get 특별공제_11장기주택저당차입금30 : spchRe30 */
    public String  getSpchRe30() { return (String )get( ATTR_SPCHRE30 );}
    
    /** set 특별공제_11장기주택저당차입금29 : spchRe29 */
    public void setSpchRe29(String  spchRe29) { set( ATTR_SPCHRE29 ,spchRe29);}
    /** get 특별공제_11장기주택저당차입금29 : spchRe29 */
    public String  getSpchRe29() { return (String )get( ATTR_SPCHRE29 );}
    
    /** set 특별공제_11장기주택저당차입금15 : spchRe15 */
    public void setSpchRe15(String  spchRe15) { set( ATTR_SPCHRE15 ,spchRe15);}
    /** get 특별공제_11장기주택저당차입금15 : spchRe15 */
    public String  getSpchRe15() { return (String )get( ATTR_SPCHRE15 );}
    
    /** set 특별공제_주택자금월세공제액 : spciRtam */
    public void setSpciRtam(String  spciRtam) { set( ATTR_SPCIRTAM ,spciRtam);}
    /** get 특별공제_주택자금월세공제액 : spciRtam */
    public String  getSpciRtam() { return (String )get( ATTR_SPCIRTAM );}
    
    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public void setSpciResf01(String  spciResf01) { set( ATTR_SPCIRESF ,spciResf01);}
    /** get 특별공제_차입금원리금상환액_거주자 : spciResf */
    public String  getSpciResf01() { return (String )get( ATTR_SPCIRESF01 );}
    
    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public void setSpciRefn01(String  spciRefn01) { set( ATTR_SPCIREFN01 ,spciRefn01);}
    /** get 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public String  getSpciRefn01() { return (String )get( ATTR_SPCIREFN01 );}
    
    /** set 특별공제_종건강보험료 : spciBhth */
    public void setSpciBhth(String  spciBhth) { set( ATTR_SPCIBHTH ,spciBhth);}
    /** get 특별공제_종건강보험료 : spciBhth */
    public String  getSpciBhth() { return (String )get( ATTR_SPCIBHTH );}
    
    /** set 특별공제_주건강보험료 : spciJhth */
    public void setSpciJhth(String  spciJhth) { set( ATTR_SPCIJHTH ,spciJhth);}
    /** get 특별공제_주건강보험료 : spciJhth */
    public String  getSpciJhth() { return (String )get( ATTR_SPCIJHTH );}
    
    /** set 특별공제_종고용보험료 : spciBepf */
    public void setSpciBepf01(String  spciBepf01) { set( ATTR_SPCIBEPF01 ,spciBepf01);}
    /** get 특별공제_종고용보험료 : spciBepf */
    public String  getSpciBepf01() { return (String )get( ATTR_SPCIBEPF01 );}
    
    /** set 특별공제_주고용보험료 : spciJepf */
    public void setSpciJepf01(String  spciJepf01) { set( ATTR_SPCIJEPF01 ,spciJepf01);}
    /** get 특별공제_주고용보험료 : spciJepf */
    public String  getSpciJepf01() { return (String )get( ATTR_SPCIJEPF01 );}
    
    /** set 특별공제_보험료계 : spciHrto */
    public void setSpciHrto(String  spciHrto) { set( ATTR_SPCIHRTO ,spciHrto);}
    /** get 특별공제_보험료계 : spciHrto */
    public String  getSpciHrto() { return (String )get( ATTR_SPCIHRTO );}
    
    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    public void setBnatDdct(String  bnatDdct) { set( ATTR_BNATDDCT ,bnatDdct);}
    /** get 종근무지_국민연금보험료공제 : bnatDdct */
    public String  getBnatDdct() { return (String )get( ATTR_BNATDDCT );}
    
    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    public void setJnatDdct(String  jnatDdct) { set( ATTR_JNATDDCT ,jnatDdct);}
    /** get 주근무지_국민연금보험료공제 : jnatDdct */
    public String  getJnatDdct() { return (String )get( ATTR_JNATDDCT );}
    
    /** set 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public void setBpssHpul(String  bpssHpul) { set( ATTR_BPSSHPUL ,bpssHpul);}
    /** get 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public String  getBpssHpul() { return (String )get( ATTR_BPSSHPUL );}
    
    /** set 주근무지_공무원연금보험료공제 : jpssHpul */
    public void setJpssHpul(String  jpssHpul) { set( ATTR_JPSSHPUL ,jpssHpul);}
    /** get 주근무지_공무원연금보험료공제 : jpssHpul */
    public String  getJpssHpul() { return (String )get( ATTR_JPSSHPUL );}
    
    /** set 종근무지_국민연금외군인연금공제 : bpssHsol */
    public void setBpssHsol(String  bpssHsol) { set( ATTR_BPSSHSOL ,bpssHsol);}
    /** get 종근무지_국민연금외군인연금공제 : bpssHsol */
    public String  getBpssHsol() { return (String )get( ATTR_BPSSHSOL );}
    
    /** set 주근무지_국민연금외군인연금공제 : jpssHsol */
    public void setJpssHsol(String  jpssHsol) { set( ATTR_JPSSHSOL ,jpssHsol);}
    /** get 주근무지_국민연금외군인연금공제 : jpssHsol */
    public String  getJpssHsol() { return (String )get( ATTR_JPSSHSOL );}
    
    /** set 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public void setBpssHtec(String  bpssHtec) { set( ATTR_BPSSHTEC ,bpssHtec);}
    /** get 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public String  getBpssHtec() { return (String )get( ATTR_BPSSHTEC );}
    
    /** set 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public void setJpssHtec(String  jpssHtec) { set( ATTR_JPSSHTEC ,jpssHtec);}
    /** get 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public String  getJpssHtec() { return (String )get( ATTR_JPSSHTEC );}
    
    /** set 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public void setBpssDdct(String  bpssDdct) { set( ATTR_BPSSDDCT ,bpssDdct);}
    /** get 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public String  getBpssDdct() { return (String )get( ATTR_BPSSDDCT );}
    
    /** set 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public void setJpssDdct(String  jpssDdct) { set( ATTR_JPSSDDCT ,jpssDdct);}
    /** get 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public String  getJpssDdct() { return (String )get( ATTR_JPSSDDCT );}
    
    /** set 연금보험료공제계 : rrptYnam */
    public void setRrptYnam(String  rrptYnam) { set( ATTR_RRPTYNAM ,rrptYnam);}
    /** get 연금보험료공제계 : rrptYnam */
    public String  getRrptYnam() { return (String )get( ATTR_RRPTYNAM );}
    
    /** set 세액공제_자녀세액공제금액 : addrMccr */
    public void setAddrMccr(String  addrMccr) { set( ATTR_ADDRMCCR ,addrMccr);}
    /** get 세액공제_자녀세액공제금액 : addrMccr */
    public String  getAddrMccr() { return (String )get( ATTR_ADDRMCCR );}
    
    /** set 이전근무지_총급여 : dcsnTots */
    public void setDcsnTots(String  dcsnTots) { set( ATTR_DCSNTOTS ,dcsnTots);}
    /** get 이전근무지_총급여 : dcsnTots */
    public String  getDcsnTots() { return (String )get( ATTR_DCSNTOTS );}
    
    /** set 주근무지_급여총액 : payrTamt */
    public void setPayrTamt(String  payrTamt) { set( ATTR_PAYRTAMT ,payrTamt);}
    /** get 주근무지_급여총액 : payrTamt */
    public String  getPayrTamt() { return (String )get( ATTR_PAYRTAMT );}
    
    /** set 총급여_현_전 : totlSala */
    public void setTotlSala(String  totlSala) { set( ATTR_TOTLSALA ,totlSala);}
    /** get 총급여_현_전 : totlSala */
    public String  getTotlSala() { return (String )get( ATTR_TOTLSALA );}
    
    /** set 근로소득공제 : wkerDdct */
    public void setWkerDdct(String  wkerDdct) { set( ATTR_WKERDDCT ,wkerDdct);}
    /** get 근로소득공제 : wkerDdct */
    public String  getWkerDdct() { return (String )get( ATTR_WKERDDCT );}
    
    /** set 근로소득금액 : wkerAmnt */
    public void setWkerAmnt(String  wkerAmnt) { set( ATTR_WKERAMNT ,wkerAmnt);}
    /** get 근로소득금액 : wkerAmnt */
    public String  getWkerAmnt() { return (String )get( ATTR_WKERAMNT );}
    
    /** set 결정세액_소득세 : dcsnIncm */
    public void setDcsnIncm(String  dcsnIncm) { set( ATTR_DCSNINCM ,dcsnIncm);}
    /** get 결정세액_소득세 : dcsnIncm */
    public String  getDcsnIncm() { return (String )get( ATTR_DCSNINCM );}

    /** set 결정세액_주민세_지방소득세 : dcsnInhb */
    public void setDcsnInhb(String  dcsnInhb) { set( ATTR_DCSNINHB ,dcsnInhb);}
    /** get 결정세액_주민세_지방소득세 : dcsnInhb */
    public String  getDcsnInhb() { return (String )get( ATTR_DCSNINHB );}
    
    /** set 세액공제_근로소득세액공제 : taxdWken */
    public void setTaxdWken(String  taxdWken) { set( ATTR_TAXDWKEN ,taxdWken);}
    /** get 세액공제_근로소득세액공제 : taxdWken */
    public String  getTaxdWken() { return (String )get( ATTR_TAXDWKEN );}
    
    /** set 기납부세액_소득세 : alryPinx */
    public void setAlryPinx(String  alryPinx) { set( ATTR_ALRYPINX ,alryPinx);}
    /** get 기납부세액_소득세 : alryPinx */
    public String  getAlryPinx() { return (String )get( ATTR_ALRYPINX );}
    
    /** set 기납부세액_주민세_지방소득세 : alryPhbx */
    public void setAlryPhbx(String  alryPhbx) { set( ATTR_ALRYPHBX ,alryPhbx);}
    /** get 기납부세액_주민세_지방소득세 : alryPhbx */
    public String  getAlryPhbx() { return (String )get( ATTR_ALRYPHBX );}
    
    /** set 기타공제_투자조합출자금액_2015년이후 : etgdD15f */
    public void setEtgdD15f(String  etgdD15f) { set( ATTR_ETGDD15F ,etgdD15f);}
    /** get 기타공제_투자조합출자금액_2015년이후 : etgdD15f */
    public String  getEtgdD15f() { return (String )get( ATTR_ETGDD15F );}
    

    /** set 주근무지총급여액 : currTots */
    public void setCurrTots(String  currTots) { set( ATTR_CURRTOTS ,currTots);}
    /** get 주근무지총급여액 : currTots */
    public String  getCurrTots() { return (String )get( ATTR_CURRTOTS );}
 

    /** set 이전근무지_소득세 : dcsnItax */
    public void setDcsnItax(String  dcsnItax) { set( ATTR_DCSNITAX ,dcsnItax);}
    /** get 이전근무지_소득세 : dcsnItax */
    public String  getDcsnItax() { return (String )get( ATTR_DCSNITAX );}

    /** set 이전근무지_주민세_지방소득세 : dcsnBtax */
    public void setDcsnBtax(String  dcsnBtax) { set( ATTR_DCSNBTAX ,dcsnBtax);}
    /** get 이전근무지_주민세_지방소득세 : dcsnBtax */
    public String  getDcsnBtax() { return (String )get( ATTR_DCSNBTAX );}

    /** set 이전근무지_농특세 : fafvTaxi */
    public void setFafvTaxi(String  fafvTaxi) { set( ATTR_FAFVTAXI ,fafvTaxi);}
    /** get 이전근무지_농특세 : fafvTaxi */
    public String  getFafvTaxi() { return (String )get( ATTR_FAFVTAXI );}
    /** set 종합소득과세표준 : stndIncm */
    public void setStndIncm(String  stndIncm) { set( ATTR_STNDINCM ,stndIncm);}
    /** get 종합소득과세표준 : stndIncm */
    public String  getStndIncm() { return (String )get( ATTR_STNDINCM );}

    /** set 산출세액 : prddTaxn */
    public void setPrddTaxn(String  prddTaxn) { set( ATTR_PRDDTAXN ,prddTaxn);}
    /** get 산출세액 : prddTaxn */
    public String  getPrddTaxn() { return (String)get( ATTR_PRDDTAXN );}
    
 
/** set 난임수술비용 : ctifTram */
public void setCtifTram(Long  ctifTram) { set( ATTR_CTIFTRAM ,ctifTram);}
/** get 난임수술비용 : ctifTram */
public Long  getCtifTram() { return (Long )get( ATTR_CTIFTRAM );}

/** set 법정기부금2014금액 : spciOb14 */
public void setSpciOb14(Long  spciOb14) { set( ATTR_SPCIOB14 ,spciOb14);}
/** get 법정기부금2014금액 : spciOb14 */
public Long  getSpciOb14() { return (Long )get( ATTR_SPCIOB14 );}

/** set 종교단체2014금액 : spciOy14 */
public void setSpciOy14(Long  spciOy14) { set( ATTR_SPCIOY14 ,spciOy14);}
/** get 종교단체2014금액 : spciOy14 */
public Long  getSpciOy14() { return (Long )get( ATTR_SPCIOY14 );}

/** set 종교단체외2014금액 : spciOn14 */
public void setSpciOn14(Long  spciOn14) { set( ATTR_SPCION14 ,spciOn14);}
/** get 종교단체외2014금액 : spciOn14 */
public Long  getSpciOn14() { return (Long )get( ATTR_SPCION14 );}

/** set 법정기부금2014대상금액 : spciFb14 */
public void setSpciFb14(Long  spciFb14) { set( ATTR_SPCIFB14 ,spciFb14);}
/** get 법정기부금2014대상금액 : spciFb14 */
public Long  getSpciFb14() { return (Long )get( ATTR_SPCIFB14 );}

/** set 종교단체2014대상금액 : spciYa14 */
public void setSpciYa14(Long  spciYa14) { set( ATTR_SPCIYA14 ,spciYa14);}
/** get 종교단체2014대상금액 : spciYa14 */
public Long  getSpciYa14() { return (Long )get( ATTR_SPCIYA14 );}

/** set 총교단체외2014대상금액 : spciNa14 */
public void setSpciNa14(Long  spciNa14) { set( ATTR_SPCINA14 ,spciNa14);}
/** get 총교단체외2014대상금액 : spciNa14 */
public Long  getSpciNa14() { return (Long )get( ATTR_SPCINA14 );}

/** set 분납납부금액 : divdPymtAmnt */
public void setDivdPymtAmnt(Long  divdPymtAmnt) { set( ATTR_DIVDPYMTAMNT ,divdPymtAmnt);}
/** get 분납납부금액 : divdPymtAmnt */
public Long  getDivdPymtAmnt() { return (Long )get( ATTR_DIVDPYMTAMNT );}

/** set 연말정산분할납부신청여부 : yrenSgyn */
public void setYrenSgyn(String  yrenSgyn) { set( ATTR_YRENSGYN ,yrenSgyn);}
/** get 연말정산분할납부신청여부 : yrenSgyn */
public String  getYrenSgyn() { return (String )get( ATTR_YRENSGYN );}

/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
public void setAddIncmTxApptnRtoCd(String  addIncmTxApptnRtoCd) { set( ATTR_ADDINCMTXAPPTNRTOCD ,addIncmTxApptnRtoCd);}
/** get 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
public String  getAddIncmTxApptnRtoCd() { return (String )get( ATTR_ADDINCMTXAPPTNRTOCD );}

/** set 외국인법인소속파견근로자여부 : frnrRnyn */
public void setFrnrRnyn(Boolean  frnrRnyn) { set( ATTR_FRNRRNYN ,frnrRnyn);}
/** get 외국인법인소속파견근로자여부 : frnrRnyn */
public String  getFrnrRnyn() { return (String )get( ATTR_FRNRRNYN );}

/** set 기타공제_투자조합출자금액_14_벤처 : etgdH14b */
public void setEtgdH14b(Long  etgdH14b) { set( ATTR_ETGDH14B ,etgdH14b);}
/** get 기타공제_투자조합출자금액_14_벤처 : etgdH14b */
public String  getEtgdH14b() { return (String )get( ATTR_ETGDH14B );}

/** set 기타공제_투자조합출자금액_15_벤처 : etclH15b */
public void setEtclH15b(Long  etclH15b) { set( ATTR_ETCLH15B ,etclH15b);}
/** get 기타공제_투자조합출자금액_15_벤처 : etclH15b */
public Long  getEtclH15b() { return (Long )get( ATTR_ETCLH15B );}

/** set 기타공제_투자조합출자금액_16_조합 : etclH16f */
public void setEtclH16f(Long  etclH16f) { set( ATTR_ETCLH16F ,etclH16f);}
/** get 기타공제_투자조합출자금액_16_조합 : etclH16f */
public String  getEtclH16f() { return (String )get( ATTR_ETCLH16F );}

/** set 기타공제_투자조합출자금액_16_벤처 : etclH16b */
public void setEtclH16b(Long  etclH16b) { set( ATTR_ETCLH16B ,etclH16b);}
/** get 기타공제_투자조합출자금액_16_벤처 : etclH16b */
public String  getEtclH16b() { return (String)get( ATTR_ETCLH16B );}

/** set 기타공제_본인추가공제율사용액_2016상 : etadD16l */
public void setEtadD16l(Long  etadD16l) { set( ATTR_ETADD16L ,etadD16l);}
/** get 기타공제_본인추가공제율사용액_2016상 : etadD16l */
public String  getEtadD16l() { return (String )get( ATTR_ETADD16L );}


/** set 원천징수의무부서코드 : yetaDpcd */
public void setYetaDpcd(String  yetaDpcd) { set( ATTR_YETADPCD ,yetaDpcd);}
/** get 원천징수의무부서코드 : yetaDpcd */
public String  getYetaDpcd() { return (String )get( ATTR_YETADPCD );}

/** set 원천징수의무부서코드 : yetaDpNm */
public void setYetaDpNm(String  yetaDpNm) { set( ATTR_YETADPNM ,yetaDpNm);}
/** get 원천징수의무부서코드 : yetaDpNm */
public String  getYetaDpNm() { return (String )get( ATTR_YETADPNM );}




/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public void setEtgdD14b(Long  etgdD14b) { set( ATTR_ETGDD14B ,etgdD14b);}
/** get 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public String  getEtgdD14b() { return (String )get( ATTR_ETGDD14B );}


/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
public void setEtgdD15b(Long  etgdD15b) { set( ATTR_ETGDD15B ,etgdD15b);}
/** get 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
public String  getEtgdD15b() { return (String )get( ATTR_ETGDD15B );}

/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
public void setEtgdD16f(Long  etgdD16f) { set( ATTR_ETGDD16F ,etgdD16f);}
/** get 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
public String  getEtgdD16f() { return (String)get( ATTR_ETGDD16F );}

/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
public void setEtgdD16b(Long  etgdD16b) { set( ATTR_ETGDD16B ,etgdD16b);}
/** get 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
public String  getEtgdD16b() { return (String )get( ATTR_ETGDD16B );}

}
