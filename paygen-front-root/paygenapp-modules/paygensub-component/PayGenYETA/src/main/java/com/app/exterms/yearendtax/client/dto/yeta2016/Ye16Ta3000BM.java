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
public class Ye16Ta3000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
     
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 연말정산귀속년도 : edacRvyy */
    public static final String ATTR_EDACRVYY = "edacRvyy";

    /** set 정산구분코드 : settGbcd */
    public static final String ATTR_SETTGBCD = "settGbcd"; 
    
    /** set 정산구분코명 : settGbnm */
    public static final String ATTR_SETTGBNM = "settGbnm"; 
    
    /** set 정산구분 : itemGubn */
    public static final String ATTR_ITEMGUBN = "itemGubn";
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 종전근무지수 : befoScnt */
    public static final String ATTR_BEFOSCNT = "befoScnt";

    /** set 주근무지_급여총액 : payrTamt */
    public static final String ATTR_PAYRTAMT = "payrTamt";

    /** set 주근무지_상여총액 : bonsToam */
    public static final String ATTR_BONSTOAM = "bonsToam";

    /** set 주근무지_인정상여총액 : dtmnBsam */
    public static final String ATTR_DTMNBSAM = "dtmnBsam";

    /** set 주근무지_주식행사이익 : stckPrft */
    public static final String ATTR_STCKPRFT = "stckPrft";

    /** set 주근무지총급여액 : currTots */
    public static final String ATTR_CURRTOTS = "currTots";

    /** set 비과세_자가운전보조금액_del : taxmSfam */
    public static final String ATTR_TAXMSFAM = "taxmSfam";

    /** set 비과세_급양비금액_del : taxmEtam */
    public static final String ATTR_TAXMETAM = "taxmEtam";

    /** set 비과세_보육수당_del : taxmBoin */
    public static final String ATTR_TAXMBOIN = "taxmBoin";

    /** set 비과세_외국인소득금액_del : txecAmnt */
    public static final String ATTR_TXECAMNT = "txecAmnt";

    /** set 총급여_현_전 : totlSala */
    public static final String ATTR_TOTLSALA = "totlSala";

    /** set 근로소득공제 : wkerDdct */
    public static final String ATTR_WKERDDCT = "wkerDdct";

    /** set 근로소득금액 : wkerAmnt */
    public static final String ATTR_WKERAMNT = "wkerAmnt";

    /** set 기본공제_본인 : baseSelf */
    public static final String ATTR_BASESELF = "baseSelf";

    /** set 기본공제_배우자 : baseWife */
    public static final String ATTR_BASEWIFE = "baseWife";

    /** set 기본공제_부양가족 : baseFyam */
    public static final String ATTR_BASEFYAM = "baseFyam";

    /** set 추가공제_장애인 : addrHdam */
    public static final String ATTR_ADDRHDAM = "addrHdam";

    /** set 추가공제_경로우대70 : addrRpt70 */
    public static final String ATTR_ADDRRPT70 = "addrRpt70";

    /** set 추가공제_부녀자 : addrFame */
    public static final String ATTR_ADDRFAME = "addrFame";

    /** set 추가공제_자녀양육비 : addrChld */
    public static final String ATTR_ADDRCHLD = "addrChld";

    /** set 추가공제_출산자녀양육비 : addrBrth */
    public static final String ATTR_ADDRBRTH = "addrBrth";

    /** set 추가공제_한부모공제금액 : pantOnam */
    public static final String ATTR_PANTONAM = "pantOnam";

    /** set 추가공제_다자녀 : addrMcam */
    public static final String ATTR_ADDRMCAM = "addrMcam";

    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    public static final String ATTR_BNATDDCT = "bnatDdct";

    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    public static final String ATTR_JNATDDCT = "jnatDdct";

    /** set 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public static final String ATTR_BPSSDDCT = "bpssDdct";

    /** set 종근무지_국민연금외군인연금공제 : bpssHsol */
    public static final String ATTR_BPSSHSOL = "bpssHsol";

    /** set 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public static final String ATTR_BPSSHTEC = "bpssHtec";

    /** set 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public static final String ATTR_BPSSHPUL = "bpssHpul";

    /** set 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public static final String ATTR_JPSSDDCT = "jpssDdct";

    /** set 주근무지_국민연금외군인연금공제 : jpssHsol */
    public static final String ATTR_JPSSHSOL = "jpssHsol";

    /** set 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public static final String ATTR_JPSSHTEC = "jpssHtec";

    /** set 주근무지_공무원연금보험료공제 : jpssHpul */
    public static final String ATTR_JPSSHPUL = "jpssHpul";

    /** set 종근무지_퇴직연금과학기술인공제 : brtrHict */
    public static final String ATTR_BRTRHICT = "brtrHict";

    /** set 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
    public static final String ATTR_BRTRPSRN = "brtrPsrn";

    /** set 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
    public static final String ATTR_BRTRHNSV = "brtrHnsv";

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public static final String ATTR_JRTRHICT = "jrtrHict";

    /** set 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public static final String ATTR_JRTRPSRN = "jrtrPsrn";

    /** set 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public static final String ATTR_JRTRHNSV = "jrtrHnsv";

    /** set 연금보험료공제계 : rrptYnam */
    public static final String ATTR_RRPTYNAM = "rrptYnam";

    /** set 특별공제_종건강보험료 : spciBhth */
    public static final String ATTR_SPCIBHTH = "spciBhth";

    /** set 특별공제_주건강보험료 : spciJhth */
    public static final String ATTR_SPCIJHTH = "spciJhth";

    /** set 특별공제_종고용보험료 : spciBepf */
    public static final String ATTR_SPCIBEPF = "spciBepf";

    /** set 특별공제_주고용보험료 : spciJepf */
    public static final String ATTR_SPCIJEPF = "spciJepf";

    /** set 특별공제_일반보장성보험료 : spciGurt */
    public static final String ATTR_SPCIGURT = "spciGurt";

    /** set 특별공제_장애인보장성보험료 : spciHdrc */
    public static final String ATTR_SPCIHDRC = "spciHdrc";

    /** set 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public static final String ATTR_SPCIRTDE = "spciRtde";

    /** set 특별공제_보험료계 : spciHrto */
    public static final String ATTR_SPCIHRTO = "spciHrto";

    /** set 특별공제_의료비_본인 : spciSelf */
    public static final String ATTR_SPCISELF = "spciSelf";

    /** set 특별공제_의료비_경로65세이상 : spciHe65 */
    public static final String ATTR_SPCIHE65 = "spciHe65";

    /** set 특별공제_의료비_장애인 : spciHbps */
    public static final String ATTR_SPCIHBPS = "spciHbps";

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public static final String ATTR_SPCIDETC = "spciDetc";

    /** set 특별공제_의료비세액공제액 : spciTxcr */
    public static final String ATTR_SPCITXCR = "spciTxcr";

    /** set 특별공제_의료비계 : spciMeto */
    public static final String ATTR_SPCIMETO = "spciMeto";

    /** set 특별공제_교육비_본인 : spedSelf */
    public static final String ATTR_SPEDSELF = "spedSelf";

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

    /** set 특별공제_교육비계 : spedToam */
    public static final String ATTR_SPEDTOAM = "spedToam";

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public static final String ATTR_SPCIREFN = "spciRefn";

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public static final String ATTR_SPCIRESF = "spciResf";

    /** set 특별공제_월세세액공제대상금액 : spciTgrt */
    public static final String ATTR_SPCITGRT = "spciTgrt";

    /** set 특별공제_주택자금월세공제액 : spciRtam */
    public static final String ATTR_SPCIRTAM = "spciRtam";

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    public static final String ATTR_SPCHREFN = "spchRefn";

    /** set 특별공제_11장기주택저당차입금15 : spchRe15 */
    public static final String ATTR_SPCHRE15 = "spchRe15";

    /** set 특별공제_11장기주택저당차입금29 : spchRe29 */
    public static final String ATTR_SPCHRE29 = "spchRe29";

    /** set 특별공제_11장기주택저당차입금30 : spchRe30 */
    public static final String ATTR_SPCHRE30 = "spchRe30";

    /** set 특별공제_12장기주택저당차입금_고정 : spciRefx */
    public static final String ATTR_SPCIREFX = "spciRefx";

    /** set 특별공제_12장기주택저당차입금_기타 : spciReec */
    public static final String ATTR_SPCIREEC = "spciReec";

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public static final String ATTR_SPCI15FX = "spci15fx";

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public static final String ATTR_SPCI15FB = "spci15fb";

    /** set 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public static final String ATTR_SPCI15EC = "spci15ec";

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public static final String ATTR_SPCI10FB = "spci10fb";

    /** set 특별공제_15장기주택저당_10기타대출 : spci10ec */
    public static final String ATTR_SPCI10EC = "spci10ec";

    /** set 특별공제_주택자금공제액계 : spchReto */
    public static final String ATTR_SPCHRETO = "spchReto";

    /** set 세액공제_기부정치자금 : taxdPltc */
    public static final String ATTR_TAXDPLTC = "taxdPltc";

    /** set 특별공제_기부금_정치 : spciPltc */
    public static final String ATTR_SPCIPLTC = "spciPltc";

    /** set 특별공제_기부금_법정 : spciFbam */
    public static final String ATTR_SPCIFBAM = "spciFbam";

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public static final String ATTR_SPCIEXAM = "spciExam";

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public static final String ATTR_SPCIUNON = "spciUnon";

    /** set 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public static final String ATTR_SPCIRFAM = "spciRfam";

    /** set 특별공제_기부금_종교단체 : spciYamt */
    public static final String ATTR_SPCIYAMT = "spciYamt";

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public static final String ATTR_SPCINAMT = "spciNamt";

    /** set 특별공제_지정기부금세액공제금액 : spciDgcr */
    public static final String ATTR_SPCIDGCR = "spciDgcr";

    /** set 특별공제_기부금공제액계 : spciSsum */
    public static final String ATTR_SPCISSUM = "spciSsum";

    /** set 특별공제_표준공제 : spciDdct */
    public static final String ATTR_SPCIDDCT = "spciDdct";

    /** set 차감소득금액 : subtEram */
    public static final String ATTR_SUBTERAM = "subtEram";

    /** set 개인연금저축불입액_2000년이전 : etcpPsnv */
    public static final String ATTR_ETCPPSNV = "etcpPsnv";

    /** set 개인연금저축불입액_2001이후_삭제 : etcpNsav */
    public static final String ATTR_ETCPNSAV = "etcpNsav";

    /** set 연금저축공제액계 : prcmToam */
    public static final String ATTR_PRCMTOAM = "prcmToam";

    /** set 기타공제_소기업공제불입금 : etchPrep */
    public static final String ATTR_ETCHPREP = "etchPrep";

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public static final String ATTR_ETCSCOMP = "etcsComp";

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public static final String ATTR_ETWKSBAM = "etwkSbam";

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public static final String ATTR_ETWKSVAM = "etwkSvam";

    /** set 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
    public static final String ATTR_ETWKLGAM = "etwkLgam";

    /** set 기타공제_주택마련저축소득공제계 : etwkBdam */
    public static final String ATTR_ETWKBDAM = "etwkBdam";

    /** set 기타공제_투자조합출자소득공제_2011이전 : etctConc */
    public static final String ATTR_ETCTCONC = "etctConc";

    /** set 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public static final String ATTR_ETGD09AF = "etgd09af";

    /** set 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public static final String ATTR_ETGDH13H = "etgdH13h";

    /** set 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public static final String ATTR_ETGDD14F = "etgdD14f";

    /** set 기타공제_투자조합출자공제액계 : etgdDdam */
    public static final String ATTR_ETGDDDAM = "etgdDdam";

    /** set 기타공제_신용카드등사용액소득공제 : etccCard */
    public static final String ATTR_ETCCCARD = "etccCard";

    /** set 기타공제_우리사주출연금공제 : etckUnon */
    public static final String ATTR_ETCKUNON = "etckUnon";

    /** set 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public static final String ATTR_ETCKUNCR = "etckUncr";

    /** set 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public static final String ATTR_ETEPMSAM = "etepMsam";

    /** set 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public static final String ATTR_ETGDHTRA = "etgdHtra";

    /** set 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public static final String ATTR_ETEPSECR = "etepSecr";

    /** set 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
    public static final String ATTR_ETCLTO01 = "etclTo01";

    /** set 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
    public static final String ATTR_ETCLTO02 = "etclTo02";

    /** set 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
    public static final String ATTR_ETCLTO03 = "etclTo03";

    /** set 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
    public static final String ATTR_ETCLHMTO = "etclHmto";

    /** set 기타공제_공제계 : etcdTsum */
    public static final String ATTR_ETCDTSUM = "etcdTsum";

    /** set 특별공제_종합한도초과금액 : spchExli */
    public static final String ATTR_SPCHEXLI = "spchExli";

    /** set 종합소득과세표준 : stndIncm */
    public static final String ATTR_STNDINCM = "stndIncm";

    /** set 산출세액 : prddTaxn */
    public static final String ATTR_PRDDTAXN = "prddTaxn";

    /** set 세액감면_소득세법 : taxdIcax */
    public static final String ATTR_TAXDICAX = "taxdIcax";

    /** set 세액감면_조세특례법 : taxdSpct */
    public static final String ATTR_TAXDSPCT = "taxdSpct";

    /** set 세액감면_조세특례법제30조 : txlgCl30 */
    public static final String ATTR_TXLGCL30 = "txlgCl30";

    /** set 세액감면_조세조약 : txlgHxtt */
    public static final String ATTR_TXLGHXTT = "txlgHxtt";

    /** set 세액감면_감면세액계 : taxdTsum */
    public static final String ATTR_TAXDTSUM = "taxdTsum";

    /** set 세액공제_근로소득세액공제 : taxdWken */
    public static final String ATTR_TAXDWKEN = "taxdWken";

    /** set 세액공제_납세조합공제 : taxdUnin */
    public static final String ATTR_TAXDUNIN = "taxdUnin";

    /** set 세액공제_주택차입금 : taxdLoan */
    public static final String ATTR_TAXDLOAN = "taxdLoan";

    /** set 세액공제_외국납부 : taxdPaid */
    public static final String ATTR_TAXDPAID = "taxdPaid";

    /** set 세액공제_외국인감면세액 : taxdRedu */
    public static final String ATTR_TAXDREDU = "taxdRedu";

    /** set 세액공제_자녀세액공제금액 : addrMccr */
    public static final String ATTR_ADDRMCCR = "addrMccr";

    /** set 특별세액공제계 : spciDcto */
    public static final String ATTR_SPCIDCTO = "spciDcto";

    /** set 세액공제_공제계 : taxdCsum */
    public static final String ATTR_TAXDCSUM = "taxdCsum";

    /** set 결정세액_소득세 : dcsnIncm */
    public static final String ATTR_DCSNINCM = "dcsnIncm";

    /** set 결정세액_주민세_지방소득세 : dcsnInhb */
    public static final String ATTR_DCSNINHB = "dcsnInhb";

    /** set 결정세액_농특세 : dcsnFafv */
    public static final String ATTR_DCSNFAFV = "dcsnFafv";

    /** set 기납부세액_소득세 : alryPinx */
    public static final String ATTR_ALRYPINX = "alryPinx";

    /** set 기납부세액_주민세_지방소득세 : alryPhbx */
    public static final String ATTR_ALRYPHBX = "alryPhbx";

    /** set 기납부세액_농특세 : alryYvtx */
    public static final String ATTR_ALRYYVTX = "alryYvtx";

    /** set 이전근무지_총급여 : dcsnTots */
    public static final String ATTR_DCSNTOTS = "dcsnTots";

    /** set 이전근무지_소득세 : dcsnItax */
    public static final String ATTR_DCSNITAX = "dcsnItax";

    /** set 이전근무지_주민세_지방소득세 : dcsnBtax */
    public static final String ATTR_DCSNBTAX = "dcsnBtax";

    /** set 이전근무지_농특세 : fafvTaxi */
    public static final String ATTR_FAFVTAXI = "fafvTaxi";

    /** set 차감징수_소득세 : subtEtax */
    public static final String ATTR_SUBTETAX = "subtEtax";

    /** set 차감징수_주민세_지방소득세 : subtInhb */
    public static final String ATTR_SUBTINHB = "subtInhb";

    /** set 차감징수_농특세 : subtFafv */
    public static final String ATTR_SUBTFAFV = "subtFafv";

    /** set 차감징수_세액계 : subtAmsu */
    public static final String ATTR_SUBTAMSU = "subtAmsu";

    /** set 연금계좌세액공제계 : jrtrHnto */
    public static final String ATTR_JRTRHNTO = "jrtrHnto";

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


/** set null : tempPrddTaxn */
public static final String ATTR_TEMPPRDDTAXN = "tempPrddTaxn";

/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public static final String ATTR_ETGDD14B = "etgdD14b";

/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
public static final String ATTR_ETGDD15B = "etgdD15b";

/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
public static final String ATTR_ETGDD16F = "etgdD16f";

/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
public static final String ATTR_ETGDD16B = "etgdD16b";

    /** 생성자 */
     public Ye16Ta3000BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye16Ta3000BM(
    		 String  dpobCd 
    		, String  edacRvyy 
    		, String  settGbcd 
    		, String  systemkey 
    		, Long  befoScnt 
    		, Long  payrTamt 
    		, Long  bonsToam 
    		, Long  dtmnBsam 
    		, Long  stckPrft 
    		, Long  currTots 
    		, Long  taxmSfam 
    		, Long  taxmEtam 
    		, Long  taxmBoin 
    		, Long  txecAmnt 
    		, Long  totlSala 
    		, Long  wkerDdct 
    		, Long  wkerAmnt 
    		, Long  baseSelf 
    		, Long  baseWife 
    		, Long  baseFyam 
    		, Long  addrHdam 
    		, Long  addrRpt70 
    		, Long  addrFame 
    		, Long  addrChld 
    		, Long  addrBrth 
    		, Long  pantOnam 
    		, Long  addrMcam 
    		, Long  bnatDdct 
    		, Long  jnatDdct 
    		, Long  bpssDdct 
    		, Long  bpssHsol 
    		, Long  bpssHtec 
    		, Long  bpssHpul 
    		, Long  jpssDdct 
    		, Long  jpssHsol 
    		, Long  jpssHtec 
    		, Long  jpssHpul 
    		, Long  brtrHict 
    		, Long  brtrPsrn 
    		, Long  brtrHnsv 
    		, Long  jrtrHict 
    		, Long  jrtrPsrn 
    		, Long  jrtrHnsv 
    		, Long  rrptYnam 
    		, Long  spciBhth 
    		, Long  spciJhth 
    		, Long  spciBepf 
    		, Long  spciJepf 
    		, Long  spciGurt 
    		, Long  spciHdrc 
    		, Long  spciRtde 
    		, Long  spciHrto 
    		, Long  spciSelf 
    		, Long  spciHe65 
    		, Long  spciHbps 
    		, Long  spciDetc 
    		, Long  spciTxcr 
    		, Long  spciMeto 
    		, Long  spedSelf 
    		, Long  spedGrde 
    		, Long  spedGdto 
    		, Long  spedCldv 
    		, Long  spciSpec 
    		, Long  spedTxcr 
    		, Long  spedToam 
    		, Long  spciRefn 
    		, Long  spciResf 
    		, Long  spciTgrt 
    		, Long  spciRtam 
    		, Long  spchRefn 
    		, Long  spchRe15 
    		, Long  spchRe29 
    		, Long  spchRe30 
    		, Long  spciRefx 
    		, Long  spciReec 
    		, Long  spci15fx 
    		, Long  spci15fb 
    		, Long  spci15ec 
    		, Long  spci10fb 
    		, Long  spci10ec 
    		, Long  spchReto 
    		, Long  taxdPltc 
    		, Long  spciPltc 
    		, Long  spciFbam 
    		, Long  spciExam 
    		, Long  spciUnon 
    		, Long  spciRfam 
    		, Long  spciYamt 
    		, Long  spciNamt 
    		, Long  spciDgcr 
    		, Long  spciSsum 
    		, Long  spciDdct 
    		, Long  subtEram 
    		, Long  etcpPsnv 
    		, Long  etcpNsav 
    		, Long  prcmToam 
    		, Long  etchPrep 
    		, Long  etcsComp 
    		, Long  etwkSbam 
    		, Long  etwkSvam 
    		, Long  etwkLgam 
    		, Long  etwkBdam 
    		, Long  etctConc 
    		, Long  etgd09af 
    		, Long  etgdH13h 
    		, Long  etgdD14f 
    		, Long  etgdDdam 
    		, Long  etccCard 
    		, Long  etckUnon 
    		, Long  etckUncr 
    		, Long  etepMsam 
    		, Long  etgdHtra 
    		, Long  etepSecr 
    		, Long  etclTo01 
    		, Long  etclTo02 
    		, Long  etclTo03 
    		, Long  etclHmto 
    		, Long  etcdTsum 
    		, Long  spchExli 
    		, Long  stndIncm 
    		, Long  prddTaxn 
    		, Long  taxdIcax 
    		, Long  taxdSpct 
    		, Long  txlgCl30 
    		, Long  txlgHxtt 
    		, Long  taxdTsum 
    		, Long  taxdWken 
    		, Long  taxdUnin 
    		, Long  taxdLoan 
    		, Long  taxdPaid 
    		, Long  taxdRedu 
    		, Long  addrMccr 
    		, Long  spciDcto 
    		, Long  taxdCsum 
    		, Long  dcsnIncm 
    		, Long  dcsnInhb 
    		, Long  dcsnFafv 
    		, Long  alryPinx 
    		, Long  alryPhbx 
    		, Long  alryYvtx 
    		, Long  dcsnTots 
    		, Long  dcsnItax 
    		, Long  dcsnBtax 
    		, Long  fafvTaxi 
    		, Long  subtEtax 
    		, Long  subtInhb 
    		, Long  subtFafv 
    		, Long  subtAmsu 
    		, Long  jrtrHnto 
    		, Long  spciOnon 
    		, Long  spciObam 
    		, Long  spciOyam 
    		, Long  spciOnam 
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
     	values.put(ATTR_BEFOSCNT,befoScnt);
     	values.put(ATTR_PAYRTAMT,payrTamt);
     	values.put(ATTR_BONSTOAM,bonsToam);
     	values.put(ATTR_DTMNBSAM,dtmnBsam);
     	values.put(ATTR_STCKPRFT,stckPrft);
     	values.put(ATTR_CURRTOTS,currTots);
     	values.put(ATTR_TAXMSFAM,taxmSfam);
     	values.put(ATTR_TAXMETAM,taxmEtam);
     	values.put(ATTR_TAXMBOIN,taxmBoin);
     	values.put(ATTR_TXECAMNT,txecAmnt);
     	values.put(ATTR_TOTLSALA,totlSala);
     	values.put(ATTR_WKERDDCT,wkerDdct);
     	values.put(ATTR_WKERAMNT,wkerAmnt);
     	values.put(ATTR_BASESELF,baseSelf);
     	values.put(ATTR_BASEWIFE,baseWife);
     	values.put(ATTR_BASEFYAM,baseFyam);
     	values.put(ATTR_ADDRHDAM,addrHdam);
     	values.put(ATTR_ADDRRPT70,addrRpt70);
     	values.put(ATTR_ADDRFAME,addrFame);
     	values.put(ATTR_ADDRCHLD,addrChld);
     	values.put(ATTR_ADDRBRTH,addrBrth);
     	values.put(ATTR_PANTONAM,pantOnam);
     	values.put(ATTR_ADDRMCAM,addrMcam);
     	values.put(ATTR_BNATDDCT,bnatDdct);
     	values.put(ATTR_JNATDDCT,jnatDdct);
     	values.put(ATTR_BPSSDDCT,bpssDdct);
     	values.put(ATTR_BPSSHSOL,bpssHsol);
     	values.put(ATTR_BPSSHTEC,bpssHtec);
     	values.put(ATTR_BPSSHPUL,bpssHpul);
     	values.put(ATTR_JPSSDDCT,jpssDdct);
     	values.put(ATTR_JPSSHSOL,jpssHsol);
     	values.put(ATTR_JPSSHTEC,jpssHtec);
     	values.put(ATTR_JPSSHPUL,jpssHpul);
     	values.put(ATTR_BRTRHICT,brtrHict);
     	values.put(ATTR_BRTRPSRN,brtrPsrn);
     	values.put(ATTR_BRTRHNSV,brtrHnsv);
     	values.put(ATTR_JRTRHICT,jrtrHict);
     	values.put(ATTR_JRTRPSRN,jrtrPsrn);
     	values.put(ATTR_JRTRHNSV,jrtrHnsv);
     	values.put(ATTR_RRPTYNAM,rrptYnam);
     	values.put(ATTR_SPCIBHTH,spciBhth);
     	values.put(ATTR_SPCIJHTH,spciJhth);
     	values.put(ATTR_SPCIBEPF,spciBepf);
     	values.put(ATTR_SPCIJEPF,spciJepf);
     	values.put(ATTR_SPCIGURT,spciGurt);
     	values.put(ATTR_SPCIHDRC,spciHdrc);
     	values.put(ATTR_SPCIRTDE,spciRtde);
     	values.put(ATTR_SPCIHRTO,spciHrto);
     	values.put(ATTR_SPCISELF,spciSelf);
     	values.put(ATTR_SPCIHE65,spciHe65);
     	values.put(ATTR_SPCIHBPS,spciHbps);
     	values.put(ATTR_SPCIDETC,spciDetc);
     	values.put(ATTR_SPCITXCR,spciTxcr);
     	values.put(ATTR_SPCIMETO,spciMeto);
     	values.put(ATTR_SPEDSELF,spedSelf);
     	values.put(ATTR_SPEDGRDE,spedGrde);
     	values.put(ATTR_SPEDGDTO,spedGdto);
     	values.put(ATTR_SPEDCLDV,spedCldv);
     	values.put(ATTR_SPCISPEC,spciSpec);
     	values.put(ATTR_SPEDTXCR,spedTxcr);
     	values.put(ATTR_SPEDTOAM,spedToam);
     	values.put(ATTR_SPCIREFN,spciRefn);
     	values.put(ATTR_SPCIRESF,spciResf);
     	values.put(ATTR_SPCITGRT,spciTgrt);
     	values.put(ATTR_SPCIRTAM,spciRtam);
     	values.put(ATTR_SPCHREFN,spchRefn);
     	values.put(ATTR_SPCHRE15,spchRe15);
     	values.put(ATTR_SPCHRE29,spchRe29);
     	values.put(ATTR_SPCHRE30,spchRe30);
     	values.put(ATTR_SPCIREFX,spciRefx);
     	values.put(ATTR_SPCIREEC,spciReec);
     	values.put(ATTR_SPCI15FX,spci15fx);
     	values.put(ATTR_SPCI15FB,spci15fb);
     	values.put(ATTR_SPCI15EC,spci15ec);
     	values.put(ATTR_SPCI10FB,spci10fb);
     	values.put(ATTR_SPCI10EC,spci10ec);
     	values.put(ATTR_SPCHRETO,spchReto);
     	values.put(ATTR_TAXDPLTC,taxdPltc);
     	values.put(ATTR_SPCIPLTC,spciPltc);
     	values.put(ATTR_SPCIFBAM,spciFbam);
     	values.put(ATTR_SPCIEXAM,spciExam);
     	values.put(ATTR_SPCIUNON,spciUnon);
     	values.put(ATTR_SPCIRFAM,spciRfam);
     	values.put(ATTR_SPCIYAMT,spciYamt);
     	values.put(ATTR_SPCINAMT,spciNamt);
     	values.put(ATTR_SPCIDGCR,spciDgcr);
     	values.put(ATTR_SPCISSUM,spciSsum);
     	values.put(ATTR_SPCIDDCT,spciDdct);
     	values.put(ATTR_SUBTERAM,subtEram);
     	values.put(ATTR_ETCPPSNV,etcpPsnv);
     	values.put(ATTR_ETCPNSAV,etcpNsav);
     	values.put(ATTR_PRCMTOAM,prcmToam);
     	values.put(ATTR_ETCHPREP,etchPrep);
     	values.put(ATTR_ETCSCOMP,etcsComp);
     	values.put(ATTR_ETWKSBAM,etwkSbam);
     	values.put(ATTR_ETWKSVAM,etwkSvam);
     	values.put(ATTR_ETWKLGAM,etwkLgam);
     	values.put(ATTR_ETWKBDAM,etwkBdam);
     	values.put(ATTR_ETCTCONC,etctConc);
     	values.put(ATTR_ETGD09AF,etgd09af);
     	values.put(ATTR_ETGDH13H,etgdH13h);
     	values.put(ATTR_ETGDD14F,etgdD14f);
     	values.put(ATTR_ETGDDDAM,etgdDdam);
     	values.put(ATTR_ETCCCARD,etccCard);
     	values.put(ATTR_ETCKUNON,etckUnon);
     	values.put(ATTR_ETCKUNCR,etckUncr);
     	values.put(ATTR_ETEPMSAM,etepMsam);
     	values.put(ATTR_ETGDHTRA,etgdHtra);
     	values.put(ATTR_ETEPSECR,etepSecr);
     	values.put(ATTR_ETCLTO01,etclTo01);
     	values.put(ATTR_ETCLTO02,etclTo02);
     	values.put(ATTR_ETCLTO03,etclTo03);
     	values.put(ATTR_ETCLHMTO,etclHmto);
     	values.put(ATTR_ETCDTSUM,etcdTsum);
     	values.put(ATTR_SPCHEXLI,spchExli);
     	values.put(ATTR_STNDINCM,stndIncm);
     	values.put(ATTR_PRDDTAXN,prddTaxn);
     	values.put(ATTR_TAXDICAX,taxdIcax);
     	values.put(ATTR_TAXDSPCT,taxdSpct);
     	values.put(ATTR_TXLGCL30,txlgCl30);
     	values.put(ATTR_TXLGHXTT,txlgHxtt);
     	values.put(ATTR_TAXDTSUM,taxdTsum);
     	values.put(ATTR_TAXDWKEN,taxdWken);
     	values.put(ATTR_TAXDUNIN,taxdUnin);
     	values.put(ATTR_TAXDLOAN,taxdLoan);
     	values.put(ATTR_TAXDPAID,taxdPaid);
     	values.put(ATTR_TAXDREDU,taxdRedu);
     	values.put(ATTR_ADDRMCCR,addrMccr);
     	values.put(ATTR_SPCIDCTO,spciDcto);
     	values.put(ATTR_TAXDCSUM,taxdCsum);
     	values.put(ATTR_DCSNINCM,dcsnIncm);
     	values.put(ATTR_DCSNINHB,dcsnInhb);
     	values.put(ATTR_DCSNFAFV,dcsnFafv);
     	values.put(ATTR_ALRYPINX,alryPinx);
     	values.put(ATTR_ALRYPHBX,alryPhbx);
     	values.put(ATTR_ALRYYVTX,alryYvtx);
     	values.put(ATTR_DCSNTOTS,dcsnTots);
     	values.put(ATTR_DCSNITAX,dcsnItax);
     	values.put(ATTR_DCSNBTAX,dcsnBtax);
     	values.put(ATTR_FAFVTAXI,fafvTaxi);
     	values.put(ATTR_SUBTETAX,subtEtax);
     	values.put(ATTR_SUBTINHB,subtInhb);
     	values.put(ATTR_SUBTFAFV,subtFafv);
     	values.put(ATTR_SUBTAMSU,subtAmsu);
     	values.put(ATTR_JRTRHNTO,jrtrHnto);
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
    
    /** set 정산구분명 : settGbnm */
    public void setSettGbnm(String  settGbnm) { set( ATTR_SETTGBNM ,settGbnm);}
    /** get 정산구분명 : settGbnm */
    public String  getSettGbnm() { return (String )get( ATTR_SETTGBNM );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 종전근무지수 : befoScnt */
    public void setBefoScnt(Long  befoScnt) { set( ATTR_BEFOSCNT ,befoScnt);}
    /** get 종전근무지수 : befoScnt */
    public Long  getBefoScnt() { return (Long )get( ATTR_BEFOSCNT );}

    /** set 주근무지_급여총액 : payrTamt */
    public void setPayrTamt(Long  payrTamt) { set( ATTR_PAYRTAMT ,payrTamt);}
    /** get 주근무지_급여총액 : payrTamt */
    public Long  getPayrTamt() { return (Long )get( ATTR_PAYRTAMT );}

    /** set 주근무지_상여총액 : bonsToam */
    public void setBonsToam(Long  bonsToam) { set( ATTR_BONSTOAM ,bonsToam);}
    /** get 주근무지_상여총액 : bonsToam */
    public Long  getBonsToam() { return (Long )get( ATTR_BONSTOAM );}

    /** set 주근무지_인정상여총액 : dtmnBsam */
    public void setDtmnBsam(Long  dtmnBsam) { set( ATTR_DTMNBSAM ,dtmnBsam);}
    /** get 주근무지_인정상여총액 : dtmnBsam */
    public Long  getDtmnBsam() { return (Long )get( ATTR_DTMNBSAM );}

    /** set 주근무지_주식행사이익 : stckPrft */
    public void setStckPrft(Long  stckPrft) { set( ATTR_STCKPRFT ,stckPrft);}
    /** get 주근무지_주식행사이익 : stckPrft */
    public Long  getStckPrft() { return (Long )get( ATTR_STCKPRFT );}

    /** set 주근무지총급여액 : currTots */
    public void setCurrTots(Long  currTots) { set( ATTR_CURRTOTS ,currTots);}
    /** get 주근무지총급여액 : currTots */
    public Long  getCurrTots() { return (Long )get( ATTR_CURRTOTS );}

    /** set 비과세_자가운전보조금액_del : taxmSfam */
    public void setTaxmSfam(Long  taxmSfam) { set( ATTR_TAXMSFAM ,taxmSfam);}
    /** get 비과세_자가운전보조금액_del : taxmSfam */
    public Long  getTaxmSfam() { return (Long )get( ATTR_TAXMSFAM );}

    /** set 비과세_급양비금액_del : taxmEtam */
    public void setTaxmEtam(Long  taxmEtam) { set( ATTR_TAXMETAM ,taxmEtam);}
    /** get 비과세_급양비금액_del : taxmEtam */
    public Long  getTaxmEtam() { return (Long )get( ATTR_TAXMETAM );}

    /** set 비과세_보육수당_del : taxmBoin */
    public void setTaxmBoin(Long  taxmBoin) { set( ATTR_TAXMBOIN ,taxmBoin);}
    /** get 비과세_보육수당_del : taxmBoin */
    public Long  getTaxmBoin() { return (Long )get( ATTR_TAXMBOIN );}

    /** set 비과세_외국인소득금액_del : txecAmnt */
    public void setTxecAmnt(Long  txecAmnt) { set( ATTR_TXECAMNT ,txecAmnt);}
    /** get 비과세_외국인소득금액_del : txecAmnt */
    public Long  getTxecAmnt() { return (Long )get( ATTR_TXECAMNT );}

    /** set 총급여_현_전 : totlSala */
    public void setTotlSala(Long  totlSala) { set( ATTR_TOTLSALA ,totlSala);}
    /** get 총급여_현_전 : totlSala */
    public Long  getTotlSala() { return (Long )get( ATTR_TOTLSALA );}

    /** set 근로소득공제 : wkerDdct */
    public void setWkerDdct(Long  wkerDdct) { set( ATTR_WKERDDCT ,wkerDdct);}
    /** get 근로소득공제 : wkerDdct */
    public Long  getWkerDdct() { return (Long )get( ATTR_WKERDDCT );}

    /** set 근로소득금액 : wkerAmnt */
    public void setWkerAmnt(Long  wkerAmnt) { set( ATTR_WKERAMNT ,wkerAmnt);}
    /** get 근로소득금액 : wkerAmnt */
    public Long  getWkerAmnt() { return (Long )get( ATTR_WKERAMNT );}

    /** set 기본공제_본인 : baseSelf */
    public void setBaseSelf(Long  baseSelf) { set( ATTR_BASESELF ,baseSelf);}
    /** get 기본공제_본인 : baseSelf */
    public Long  getBaseSelf() { return (Long )get( ATTR_BASESELF );}

    /** set 기본공제_배우자 : baseWife */
    public void setBaseWife(Long  baseWife) { set( ATTR_BASEWIFE ,baseWife);}
    /** get 기본공제_배우자 : baseWife */
    public Long  getBaseWife() { return (Long )get( ATTR_BASEWIFE );}

    /** set 기본공제_부양가족 : baseFyam */
    public void setBaseFyam(Long  baseFyam) { set( ATTR_BASEFYAM ,baseFyam);}
    /** get 기본공제_부양가족 : baseFyam */
    public Long  getBaseFyam() { return (Long )get( ATTR_BASEFYAM );}

    /** set 추가공제_장애인 : addrHdam */
    public void setAddrHdam(Long  addrHdam) { set( ATTR_ADDRHDAM ,addrHdam);}
    /** get 추가공제_장애인 : addrHdam */
    public Long  getAddrHdam() { return (Long )get( ATTR_ADDRHDAM );}

    /** set 추가공제_경로우대70 : addrRpt70 */
    public void setAddrRpt70(Long  addrRpt70) { set( ATTR_ADDRRPT70 ,addrRpt70);}
    /** get 추가공제_경로우대70 : addrRpt70 */
    public Long  getAddrRpt70() { return (Long )get( ATTR_ADDRRPT70 );}

    /** set 추가공제_부녀자 : addrFame */
    public void setAddrFame(Long  addrFame) { set( ATTR_ADDRFAME ,addrFame);}
    /** get 추가공제_부녀자 : addrFame */
    public Long  getAddrFame() { return (Long )get( ATTR_ADDRFAME );}

    /** set 추가공제_자녀양육비 : addrChld */
    public void setAddrChld(Long  addrChld) { set( ATTR_ADDRCHLD ,addrChld);}
    /** get 추가공제_자녀양육비 : addrChld */
    public Long  getAddrChld() { return (Long )get( ATTR_ADDRCHLD );}

    /** set 추가공제_출산자녀양육비 : addrBrth */
    public void setAddrBrth(Long  addrBrth) { set( ATTR_ADDRBRTH ,addrBrth);}
    /** get 추가공제_출산자녀양육비 : addrBrth */
    public Long  getAddrBrth() { return (Long )get( ATTR_ADDRBRTH );}

    /** set 추가공제_한부모공제금액 : pantOnam */
    public void setPantOnam(Long  pantOnam) { set( ATTR_PANTONAM ,pantOnam);}
    /** get 추가공제_한부모공제금액 : pantOnam */
    public Long  getPantOnam() { return (Long )get( ATTR_PANTONAM );}

    /** set 추가공제_다자녀 : addrMcam */
    public void setAddrMcam(Long  addrMcam) { set( ATTR_ADDRMCAM ,addrMcam);}
    /** get 추가공제_다자녀 : addrMcam */
    public Long  getAddrMcam() { return (Long )get( ATTR_ADDRMCAM );}

    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    public void setBnatDdct(Long  bnatDdct) { set( ATTR_BNATDDCT ,bnatDdct);}
    /** get 종근무지_국민연금보험료공제 : bnatDdct */
    public Long  getBnatDdct() { return (Long )get( ATTR_BNATDDCT );}

    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    public void setJnatDdct(Long  jnatDdct) { set( ATTR_JNATDDCT ,jnatDdct);}
    /** get 주근무지_국민연금보험료공제 : jnatDdct */
    public Long  getJnatDdct() { return (Long )get( ATTR_JNATDDCT );}

    /** set 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public void setBpssDdct(Long  bpssDdct) { set( ATTR_BPSSDDCT ,bpssDdct);}
    /** get 종근무지_별정우체국연금보험료공제 : bpssDdct */
    public Long  getBpssDdct() { return (Long )get( ATTR_BPSSDDCT );}

    /** set 종근무지_국민연금외군인연금공제 : bpssHsol */
    public void setBpssHsol(Long  bpssHsol) { set( ATTR_BPSSHSOL ,bpssHsol);}
    /** get 종근무지_국민연금외군인연금공제 : bpssHsol */
    public Long  getBpssHsol() { return (Long )get( ATTR_BPSSHSOL );}

    /** set 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public void setBpssHtec(Long  bpssHtec) { set( ATTR_BPSSHTEC ,bpssHtec);}
    /** get 종근무지_국민연금외교직원연금공제 : bpssHtec */
    public Long  getBpssHtec() { return (Long )get( ATTR_BPSSHTEC );}

    /** set 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public void setBpssHpul(Long  bpssHpul) { set( ATTR_BPSSHPUL ,bpssHpul);}
    /** get 종근무지_국민연금외공무원연금공제 : bpssHpul */
    public Long  getBpssHpul() { return (Long )get( ATTR_BPSSHPUL );}

    /** set 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public void setJpssDdct(Long  jpssDdct) { set( ATTR_JPSSDDCT ,jpssDdct);}
    /** get 주근무지_별정우체국연금보험료공제 : jpssDdct */
    public Long  getJpssDdct() { return (Long )get( ATTR_JPSSDDCT );}

    /** set 주근무지_국민연금외군인연금공제 : jpssHsol */
    public void setJpssHsol(Long  jpssHsol) { set( ATTR_JPSSHSOL ,jpssHsol);}
    /** get 주근무지_국민연금외군인연금공제 : jpssHsol */
    public Long  getJpssHsol() { return (Long )get( ATTR_JPSSHSOL );}

    /** set 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public void setJpssHtec(Long  jpssHtec) { set( ATTR_JPSSHTEC ,jpssHtec);}
    /** get 주근무지_국민연금외교직원연금공제 : jpssHtec */
    public Long  getJpssHtec() { return (Long )get( ATTR_JPSSHTEC );}

    /** set 주근무지_공무원연금보험료공제 : jpssHpul */
    public void setJpssHpul(Long  jpssHpul) { set( ATTR_JPSSHPUL ,jpssHpul);}
    /** get 주근무지_공무원연금보험료공제 : jpssHpul */
    public Long  getJpssHpul() { return (Long )get( ATTR_JPSSHPUL );}

    /** set 종근무지_퇴직연금과학기술인공제 : brtrHict */
    public void setBrtrHict(Long  brtrHict) { set( ATTR_BRTRHICT ,brtrHict);}
    /** get 종근무지_퇴직연금과학기술인공제 : brtrHict */
    public Long  getBrtrHict() { return (Long )get( ATTR_BRTRHICT );}

    /** set 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
    public void setBrtrPsrn(Long  brtrPsrn) { set( ATTR_BRTRPSRN ,brtrPsrn);}
    /** get 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
    public Long  getBrtrPsrn() { return (Long )get( ATTR_BRTRPSRN );}

    /** set 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
    public void setBrtrHnsv(Long  brtrHnsv) { set( ATTR_BRTRHNSV ,brtrHnsv);}
    /** get 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
    public Long  getBrtrHnsv() { return (Long )get( ATTR_BRTRHNSV );}

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public void setJrtrHict(Long  jrtrHict) { set( ATTR_JRTRHICT ,jrtrHict);}
    /** get 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    public Long  getJrtrHict() { return (Long )get( ATTR_JRTRHICT );}

    /** set 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public void setJrtrPsrn(Long  jrtrPsrn) { set( ATTR_JRTRPSRN ,jrtrPsrn);}
    /** get 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    public Long  getJrtrPsrn() { return (Long )get( ATTR_JRTRPSRN );}

    /** set 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public void setJrtrHnsv(Long  jrtrHnsv) { set( ATTR_JRTRHNSV ,jrtrHnsv);}
    /** get 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    public Long  getJrtrHnsv() { return (Long )get( ATTR_JRTRHNSV );}

    /** set 연금보험료공제계 : rrptYnam */
    public void setRrptYnam(Long  rrptYnam) { set( ATTR_RRPTYNAM ,rrptYnam);}
    /** get 연금보험료공제계 : rrptYnam */
    public Long  getRrptYnam() { return (Long )get( ATTR_RRPTYNAM );}

    /** set 특별공제_종건강보험료 : spciBhth */
    public void setSpciBhth(Long  spciBhth) { set( ATTR_SPCIBHTH ,spciBhth);}
    /** get 특별공제_종건강보험료 : spciBhth */
    public Long  getSpciBhth() { return (Long )get( ATTR_SPCIBHTH );}

    /** set 특별공제_주건강보험료 : spciJhth */
    public void setSpciJhth(Long  spciJhth) { set( ATTR_SPCIJHTH ,spciJhth);}
    /** get 특별공제_주건강보험료 : spciJhth */
    public Long  getSpciJhth() { return (Long )get( ATTR_SPCIJHTH );}

    /** set 특별공제_종고용보험료 : spciBepf */
    public void setSpciBepf(Long  spciBepf) { set( ATTR_SPCIBEPF ,spciBepf);}
    /** get 특별공제_종고용보험료 : spciBepf */
    public Long  getSpciBepf() { return (Long )get( ATTR_SPCIBEPF );}

    /** set 특별공제_주고용보험료 : spciJepf */
    public void setSpciJepf(Long  spciJepf) { set( ATTR_SPCIJEPF ,spciJepf);}
    /** get 특별공제_주고용보험료 : spciJepf */
    public Long  getSpciJepf() { return (Long )get( ATTR_SPCIJEPF );}

    /** set 특별공제_일반보장성보험료 : spciGurt */
    public void setSpciGurt(Long  spciGurt) { set( ATTR_SPCIGURT ,spciGurt);}
    /** get 특별공제_일반보장성보험료 : spciGurt */
    public Long  getSpciGurt() { return (Long )get( ATTR_SPCIGURT );}

    /** set 특별공제_장애인보장성보험료 : spciHdrc */
    public void setSpciHdrc(Long  spciHdrc) { set( ATTR_SPCIHDRC ,spciHdrc);}
    /** get 특별공제_장애인보장성보험료 : spciHdrc */
    public Long  getSpciHdrc() { return (Long )get( ATTR_SPCIHDRC );}

    /** set 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public void setSpciRtde(Long  spciRtde) { set( ATTR_SPCIRTDE ,spciRtde);}
    /** get 특별공제_보장성보혐료세액공제금액 : spciRtde */
    public Long  getSpciRtde() { return (Long )get( ATTR_SPCIRTDE );}

    /** set 특별공제_보험료계 : spciHrto */
    public void setSpciHrto(Long  spciHrto) { set( ATTR_SPCIHRTO ,spciHrto);}
    /** get 특별공제_보험료계 : spciHrto */
    public Long  getSpciHrto() { return (Long )get( ATTR_SPCIHRTO );}

    /** set 특별공제_의료비_본인 : spciSelf */
    public void setSpciSelf(Long  spciSelf) { set( ATTR_SPCISELF ,spciSelf);}
    /** get 특별공제_의료비_본인 : spciSelf */
    public Long  getSpciSelf() { return (Long )get( ATTR_SPCISELF );}

    /** set 특별공제_의료비_경로65세이상 : spciHe65 */
    public void setSpciHe65(Long  spciHe65) { set( ATTR_SPCIHE65 ,spciHe65);}
    /** get 특별공제_의료비_경로65세이상 : spciHe65 */
    public Long  getSpciHe65() { return (Long )get( ATTR_SPCIHE65 );}

    /** set 특별공제_의료비_장애인 : spciHbps */
    public void setSpciHbps(Long  spciHbps) { set( ATTR_SPCIHBPS ,spciHbps);}
    /** get 특별공제_의료비_장애인 : spciHbps */
    public Long  getSpciHbps() { return (Long )get( ATTR_SPCIHBPS );}

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    public void setSpciDetc(Long  spciDetc) { set( ATTR_SPCIDETC ,spciDetc);}
    /** get 특별공제_의료비_기타공제대상자 : spciDetc */
    public Long  getSpciDetc() { return (Long )get( ATTR_SPCIDETC );}

    /** set 특별공제_의료비세액공제액 : spciTxcr */
    public void setSpciTxcr(Long  spciTxcr) { set( ATTR_SPCITXCR ,spciTxcr);}
    /** get 특별공제_의료비세액공제액 : spciTxcr */
    public Long  getSpciTxcr() { return (Long )get( ATTR_SPCITXCR );}

    /** set 특별공제_의료비계 : spciMeto */
    public void setSpciMeto(Long  spciMeto) { set( ATTR_SPCIMETO ,spciMeto);}
    /** get 특별공제_의료비계 : spciMeto */
    public Long  getSpciMeto() { return (Long )get( ATTR_SPCIMETO );}

    /** set 특별공제_교육비_본인 : spedSelf */
    public void setSpedSelf(Long  spedSelf) { set( ATTR_SPEDSELF ,spedSelf);}
    /** get 특별공제_교육비_본인 : spedSelf */
    public Long  getSpedSelf() { return (Long )get( ATTR_SPEDSELF );}

    /** set 특별공제_교육비_취학전아동 : spedGrde */
    public void setSpedGrde(Long  spedGrde) { set( ATTR_SPEDGRDE ,spedGrde);}
    /** get 특별공제_교육비_취학전아동 : spedGrde */
    public Long  getSpedGrde() { return (Long )get( ATTR_SPEDGRDE );}

    /** set 특별공제_교육비_초중고 : spedGdto */
    public void setSpedGdto(Long  spedGdto) { set( ATTR_SPEDGDTO ,spedGdto);}
    /** get 특별공제_교육비_초중고 : spedGdto */
    public Long  getSpedGdto() { return (Long )get( ATTR_SPEDGDTO );}

    /** set 특별공제_교육비_대학교 : spedCldv */
    public void setSpedCldv(Long  spedCldv) { set( ATTR_SPEDCLDV ,spedCldv);}
    /** get 특별공제_교육비_대학교 : spedCldv */
    public Long  getSpedCldv() { return (Long )get( ATTR_SPEDCLDV );}

    /** set 특별공제_장애인특수교육비 : spciSpec */
    public void setSpciSpec(Long  spciSpec) { set( ATTR_SPCISPEC ,spciSpec);}
    /** get 특별공제_장애인특수교육비 : spciSpec */
    public Long  getSpciSpec() { return (Long )get( ATTR_SPCISPEC );}

    /** set 특별공제_교육비세액공제금액 : spedTxcr */
    public void setSpedTxcr(Long  spedTxcr) { set( ATTR_SPEDTXCR ,spedTxcr);}
    /** get 특별공제_교육비세액공제금액 : spedTxcr */
    public Long  getSpedTxcr() { return (Long )get( ATTR_SPEDTXCR );}

    /** set 특별공제_교육비계 : spedToam */
    public void setSpedToam(Long  spedToam) { set( ATTR_SPEDTOAM ,spedToam);}
    /** get 특별공제_교육비계 : spedToam */
    public Long  getSpedToam() { return (Long )get( ATTR_SPEDTOAM );}

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public void setSpciRefn(Long  spciRefn) { set( ATTR_SPCIREFN ,spciRefn);}
    /** get 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    public Long  getSpciRefn() { return (Long )get( ATTR_SPCIREFN );}

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    public void setSpciResf(Long  spciResf) { set( ATTR_SPCIRESF ,spciResf);}
    /** get 특별공제_차입금원리금상환액_거주자 : spciResf */
    public Long  getSpciResf() { return (Long )get( ATTR_SPCIRESF );}

    /** set 특별공제_월세세액공제대상금액 : spciTgrt */
    public void setSpciTgrt(Long  spciTgrt) { set( ATTR_SPCITGRT ,spciTgrt);}
    /** get 특별공제_월세세액공제대상금액 : spciTgrt */
    public Long  getSpciTgrt() { return (Long )get( ATTR_SPCITGRT );}

    /** set 특별공제_주택자금월세공제액 : spciRtam */
    public void setSpciRtam(Long  spciRtam) { set( ATTR_SPCIRTAM ,spciRtam);}
    /** get 특별공제_주택자금월세공제액 : spciRtam */
    public Long  getSpciRtam() { return (Long )get( ATTR_SPCIRTAM );}

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    public void setSpchRefn(Long  spchRefn) { set( ATTR_SPCHREFN ,spchRefn);}
    /** get 특별공제_장기주택이자상환액 : spchRefn */
    public Long  getSpchRefn() { return (Long )get( ATTR_SPCHREFN );}

    /** set 특별공제_11장기주택저당차입금15 : spchRe15 */
    public void setSpchRe15(Long  spchRe15) { set( ATTR_SPCHRE15 ,spchRe15);}
    /** get 특별공제_11장기주택저당차입금15 : spchRe15 */
    public Long  getSpchRe15() { return (Long )get( ATTR_SPCHRE15 );}

    /** set 특별공제_11장기주택저당차입금29 : spchRe29 */
    public void setSpchRe29(Long  spchRe29) { set( ATTR_SPCHRE29 ,spchRe29);}
    /** get 특별공제_11장기주택저당차입금29 : spchRe29 */
    public Long  getSpchRe29() { return (Long )get( ATTR_SPCHRE29 );}

    /** set 특별공제_11장기주택저당차입금30 : spchRe30 */
    public void setSpchRe30(Long  spchRe30) { set( ATTR_SPCHRE30 ,spchRe30);}
    /** get 특별공제_11장기주택저당차입금30 : spchRe30 */
    public Long  getSpchRe30() { return (Long )get( ATTR_SPCHRE30 );}

    /** set 특별공제_12장기주택저당차입금_고정 : spciRefx */
    public void setSpciRefx(Long  spciRefx) { set( ATTR_SPCIREFX ,spciRefx);}
    /** get 특별공제_12장기주택저당차입금_고정 : spciRefx */
    public Long  getSpciRefx() { return (Long )get( ATTR_SPCIREFX );}

    /** set 특별공제_12장기주택저당차입금_기타 : spciReec */
    public void setSpciReec(Long  spciReec) { set( ATTR_SPCIREEC ,spciReec);}
    /** get 특별공제_12장기주택저당차입금_기타 : spciReec */
    public Long  getSpciReec() { return (Long )get( ATTR_SPCIREEC );}

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public void setSpci15fx(Long  spci15fx) { set( ATTR_SPCI15FX ,spci15fx);}
    /** get 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    public Long  getSpci15fx() { return (Long )get( ATTR_SPCI15FX );}

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public void setSpci15fb(Long  spci15fb) { set( ATTR_SPCI15FB ,spci15fb);}
    /** get 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    public Long  getSpci15fb() { return (Long )get( ATTR_SPCI15FB );}

    /** set 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public void setSpci15ec(Long  spci15ec) { set( ATTR_SPCI15EC ,spci15ec);}
    /** get 특별공제_15장기주택저당_15기타대출 : spci15ec */
    public Long  getSpci15ec() { return (Long )get( ATTR_SPCI15EC );}

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public void setSpci10fb(Long  spci10fb) { set( ATTR_SPCI10FB ,spci10fb);}
    /** get 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    public Long  getSpci10fb() { return (Long )get( ATTR_SPCI10FB );}

    /** set 특별공제_15장기주택저당_10기타대출 : spci10ec */
    public void setSpci10ec(Long  spci10ec) { set( ATTR_SPCI10EC ,spci10ec);}
    /** get 특별공제_15장기주택저당_10기타대출 : spci10ec */
    public Long  getSpci10ec() { return (Long )get( ATTR_SPCI10EC );}

    /** set 특별공제_주택자금공제액계 : spchReto */
    public void setSpchReto(Long  spchReto) { set( ATTR_SPCHRETO ,spchReto);}
    /** get 특별공제_주택자금공제액계 : spchReto */
    public Long  getSpchReto() { return (Long )get( ATTR_SPCHRETO );}

    /** set 세액공제_기부정치자금 : taxdPltc */
    public void setTaxdPltc(Long  taxdPltc) { set( ATTR_TAXDPLTC ,taxdPltc);}
    /** get 세액공제_기부정치자금 : taxdPltc */
    public Long  getTaxdPltc() { return (Long )get( ATTR_TAXDPLTC );}

    /** set 특별공제_기부금_정치 : spciPltc */
    public void setSpciPltc(Long  spciPltc) { set( ATTR_SPCIPLTC ,spciPltc);}
    /** get 특별공제_기부금_정치 : spciPltc */
    public Long  getSpciPltc() { return (Long )get( ATTR_SPCIPLTC );}

    /** set 특별공제_기부금_법정 : spciFbam */
    public void setSpciFbam(Long  spciFbam) { set( ATTR_SPCIFBAM ,spciFbam);}
    /** get 특별공제_기부금_법정 : spciFbam */
    public Long  getSpciFbam() { return (Long )get( ATTR_SPCIFBAM );}

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public void setSpciExam(Long  spciExam) { set( ATTR_SPCIEXAM ,spciExam);}
    /** get 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    public Long  getSpciExam() { return (Long )get( ATTR_SPCIEXAM );}

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public void setSpciUnon(Long  spciUnon) { set( ATTR_SPCIUNON ,spciUnon);}
    /** get 특별공제_기부금_공익법인신탁특례 : spciUnon */
    public Long  getSpciUnon() { return (Long )get( ATTR_SPCIUNON );}

    /** set 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public void setSpciRfam(Long  spciRfam) { set( ATTR_SPCIRFAM ,spciRfam);}
    /** get 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    public Long  getSpciRfam() { return (Long )get( ATTR_SPCIRFAM );}

    /** set 특별공제_기부금_종교단체 : spciYamt */
    public void setSpciYamt(Long  spciYamt) { set( ATTR_SPCIYAMT ,spciYamt);}
    /** get 특별공제_기부금_종교단체 : spciYamt */
    public Long  getSpciYamt() { return (Long )get( ATTR_SPCIYAMT );}

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    public void setSpciNamt(Long  spciNamt) { set( ATTR_SPCINAMT ,spciNamt);}
    /** get 특별공제_기부금_종교단체외 : spciNamt */
    public Long  getSpciNamt() { return (Long )get( ATTR_SPCINAMT );}

    /** set 특별공제_지정기부금세액공제금액 : spciDgcr */
    public void setSpciDgcr(Long  spciDgcr) { set( ATTR_SPCIDGCR ,spciDgcr);}
    /** get 특별공제_지정기부금세액공제금액 : spciDgcr */
    public Long  getSpciDgcr() { return (Long )get( ATTR_SPCIDGCR );}

    /** set 특별공제_기부금공제액계 : spciSsum */
    public void setSpciSsum(Long  spciSsum) { set( ATTR_SPCISSUM ,spciSsum);}
    /** get 특별공제_기부금공제액계 : spciSsum */
    public Long  getSpciSsum() { return (Long )get( ATTR_SPCISSUM );}

    /** set 특별공제_표준공제 : spciDdct */
    public void setSpciDdct(Long  spciDdct) { set( ATTR_SPCIDDCT ,spciDdct);}
    /** get 특별공제_표준공제 : spciDdct */
    public Long  getSpciDdct() { return (Long )get( ATTR_SPCIDDCT );}

    /** set 차감소득금액 : subtEram */
    public void setSubtEram(Long  subtEram) { set( ATTR_SUBTERAM ,subtEram);}
    /** get 차감소득금액 : subtEram */
    public Long  getSubtEram() { return (Long )get( ATTR_SUBTERAM );}

    /** set 개인연금저축불입액_2000년이전 : etcpPsnv */
    public void setEtcpPsnv(Long  etcpPsnv) { set( ATTR_ETCPPSNV ,etcpPsnv);}
    /** get 개인연금저축불입액_2000년이전 : etcpPsnv */
    public Long  getEtcpPsnv() { return (Long )get( ATTR_ETCPPSNV );}

    /** set 개인연금저축불입액_2001이후_삭제 : etcpNsav */
    public void setEtcpNsav(Long  etcpNsav) { set( ATTR_ETCPNSAV ,etcpNsav);}
    /** get 개인연금저축불입액_2001이후_삭제 : etcpNsav */
    public Long  getEtcpNsav() { return (Long )get( ATTR_ETCPNSAV );}

    /** set 연금저축공제액계 : prcmToam */
    public void setPrcmToam(Long  prcmToam) { set( ATTR_PRCMTOAM ,prcmToam);}
    /** get 연금저축공제액계 : prcmToam */
    public Long  getPrcmToam() { return (Long )get( ATTR_PRCMTOAM );}

    /** set 기타공제_소기업공제불입금 : etchPrep */
    public void setEtchPrep(Long  etchPrep) { set( ATTR_ETCHPREP ,etchPrep);}
    /** get 기타공제_소기업공제불입금 : etchPrep */
    public Long  getEtchPrep() { return (Long )get( ATTR_ETCHPREP );}

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    public void setEtcsComp(Long  etcsComp) { set( ATTR_ETCSCOMP ,etcsComp);}
    /** get 기타공제_주택마련저축_청약저축 : etcsComp */
    public Long  getEtcsComp() { return (Long )get( ATTR_ETCSCOMP );}

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public void setEtwkSbam(Long  etwkSbam) { set( ATTR_ETWKSBAM ,etwkSbam);}
    /** get 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    public Long  getEtwkSbam() { return (Long )get( ATTR_ETWKSBAM );}

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public void setEtwkSvam(Long  etwkSvam) { set( ATTR_ETWKSVAM ,etwkSvam);}
    /** get 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    public Long  getEtwkSvam() { return (Long )get( ATTR_ETWKSVAM );}

    /** set 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
    public void setEtwkLgam(Long  etwkLgam) { set( ATTR_ETWKLGAM ,etwkLgam);}
    /** get 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
    public Long  getEtwkLgam() { return (Long )get( ATTR_ETWKLGAM );}

    /** set 기타공제_주택마련저축소득공제계 : etwkBdam */
    public void setEtwkBdam(Long  etwkBdam) { set( ATTR_ETWKBDAM ,etwkBdam);}
    /** get 기타공제_주택마련저축소득공제계 : etwkBdam */
    public Long  getEtwkBdam() { return (Long )get( ATTR_ETWKBDAM );}

    /** set 기타공제_투자조합출자소득공제_2011이전 : etctConc */
    public void setEtctConc(Long  etctConc) { set( ATTR_ETCTCONC ,etctConc);}
    /** get 기타공제_투자조합출자소득공제_2011이전 : etctConc */
    public Long  getEtctConc() { return (Long )get( ATTR_ETCTCONC );}

    /** set 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public void setEtgd09af(Long  etgd09af) { set( ATTR_ETGD09AF ,etgd09af);}
    /** get 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
    public Long  getEtgd09af() { return (Long )get( ATTR_ETGD09AF );}

    /** set 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public void setEtgdH13h(Long  etgdH13h) { set( ATTR_ETGDH13H ,etgdH13h);}
    /** get 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
    public Long  getEtgdH13h() { return (Long )get( ATTR_ETGDH13H );}

    /** set 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public void setEtgdD14f(Long  etgdD14f) { set( ATTR_ETGDD14F ,etgdD14f);}
    /** get 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    public Long  getEtgdD14f() { return (Long )get( ATTR_ETGDD14F );}

    /** set 기타공제_투자조합출자공제액계 : etgdDdam */
    public void setEtgdDdam(Long  etgdDdam) { set( ATTR_ETGDDDAM ,etgdDdam);}
    /** get 기타공제_투자조합출자공제액계 : etgdDdam */
    public Long  getEtgdDdam() { return (Long )get( ATTR_ETGDDDAM );}

    /** set 기타공제_신용카드등사용액소득공제 : etccCard */
    public void setEtccCard(Long  etccCard) { set( ATTR_ETCCCARD ,etccCard);}
    /** get 기타공제_신용카드등사용액소득공제 : etccCard */
    public Long  getEtccCard() { return (Long )get( ATTR_ETCCCARD );}

    /** set 기타공제_우리사주출연금공제 : etckUnon */
    public void setEtckUnon(Long  etckUnon) { set( ATTR_ETCKUNON ,etckUnon);}
    /** get 기타공제_우리사주출연금공제 : etckUnon */
    public Long  getEtckUnon() { return (Long )get( ATTR_ETCKUNON );}

    /** set 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public void setEtckUncr(Long  etckUncr) { set( ATTR_ETCKUNCR ,etckUncr);}
    /** get 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    public Long  getEtckUncr() { return (Long )get( ATTR_ETCKUNCR );}

    /** set 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public void setEtepMsam(Long  etepMsam) { set( ATTR_ETEPMSAM ,etepMsam);}
    /** get 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    public Long  getEtepMsam() { return (Long )get( ATTR_ETEPMSAM );}

    /** set 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public void setEtgdHtra(Long  etgdHtra) { set( ATTR_ETGDHTRA ,etgdHtra);}
    /** get 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    public Long  getEtgdHtra() { return (Long )get( ATTR_ETGDHTRA );}

    /** set 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public void setEtepSecr(Long  etepSecr) { set( ATTR_ETEPSECR ,etepSecr);}
    /** get 기타공제_장기집합투자증권저축공제액 : etepSecr */
    public Long  getEtepSecr() { return (Long )get( ATTR_ETEPSECR );}

    /** set 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
    public void setEtclTo01(Long  etclTo01) { set( ATTR_ETCLTO01 ,etclTo01);}
    /** get 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
    public Long  getEtclTo01() { return (Long )get( ATTR_ETCLTO01 );}

    /** set 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
    public void setEtclTo02(Long  etclTo02) { set( ATTR_ETCLTO02 ,etclTo02);}
    /** get 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
    public Long  getEtclTo02() { return (Long )get( ATTR_ETCLTO02 );}

    /** set 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
    public void setEtclTo03(Long  etclTo03) { set( ATTR_ETCLTO03 ,etclTo03);}
    /** get 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
    public Long  getEtclTo03() { return (Long )get( ATTR_ETCLTO03 );}

    /** set 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
    public void setEtclHmto(Long  etclHmto) { set( ATTR_ETCLHMTO ,etclHmto);}
    /** get 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
    public Long  getEtclHmto() { return (Long )get( ATTR_ETCLHMTO );}

    /** set 기타공제_공제계 : etcdTsum */
    public void setEtcdTsum(Long  etcdTsum) { set( ATTR_ETCDTSUM ,etcdTsum);}
    /** get 기타공제_공제계 : etcdTsum */
    public Long  getEtcdTsum() { return (Long )get( ATTR_ETCDTSUM );}

    /** set 특별공제_종합한도초과금액 : spchExli */
    public void setSpchExli(Long  spchExli) { set( ATTR_SPCHEXLI ,spchExli);}
    /** get 특별공제_종합한도초과금액 : spchExli */
    public Long  getSpchExli() { return (Long )get( ATTR_SPCHEXLI );}

    /** set 종합소득과세표준 : stndIncm */
    public void setStndIncm(Long  stndIncm) { set( ATTR_STNDINCM ,stndIncm);}
    /** get 종합소득과세표준 : stndIncm */
    public Long  getStndIncm() { return (Long )get( ATTR_STNDINCM );}

    /** set 산출세액 : prddTaxn */
    public void setPrddTaxn(Long  prddTaxn) { set( ATTR_PRDDTAXN ,prddTaxn);}
    /** get 산출세액 : prddTaxn */
    public Long  getPrddTaxn() { return (Long )get( ATTR_PRDDTAXN );}

    /** set 세액감면_소득세법 : taxdIcax */
    public void setTaxdIcax(Long  taxdIcax) { set( ATTR_TAXDICAX ,taxdIcax);}
    /** get 세액감면_소득세법 : taxdIcax */
    public Long  getTaxdIcax() { return (Long )get( ATTR_TAXDICAX );}

    /** set 세액감면_조세특례법 : taxdSpct */
    public void setTaxdSpct(Long  taxdSpct) { set( ATTR_TAXDSPCT ,taxdSpct);}
    /** get 세액감면_조세특례법 : taxdSpct */
    public Long  getTaxdSpct() { return (Long )get( ATTR_TAXDSPCT );}

    /** set 세액감면_조세특례법제30조 : txlgCl30 */
    public void setTxlgCl30(Long  txlgCl30) { set( ATTR_TXLGCL30 ,txlgCl30);}
    /** get 세액감면_조세특례법제30조 : txlgCl30 */
    public Long  getTxlgCl30() { return (Long )get( ATTR_TXLGCL30 );}

    /** set 세액감면_조세조약 : txlgHxtt */
    public void setTxlgHxtt(Long  txlgHxtt) { set( ATTR_TXLGHXTT ,txlgHxtt);}
    /** get 세액감면_조세조약 : txlgHxtt */
    public Long  getTxlgHxtt() { return (Long )get( ATTR_TXLGHXTT );}

    /** set 세액감면_감면세액계 : taxdTsum */
    public void setTaxdTsum(Long  taxdTsum) { set( ATTR_TAXDTSUM ,taxdTsum);}
    /** get 세액감면_감면세액계 : taxdTsum */
    public Long  getTaxdTsum() { return (Long )get( ATTR_TAXDTSUM );}

    /** set 세액공제_근로소득세액공제 : taxdWken */
    public void setTaxdWken(Long  taxdWken) { set( ATTR_TAXDWKEN ,taxdWken);}
    /** get 세액공제_근로소득세액공제 : taxdWken */
    public Long  getTaxdWken() { return (Long )get( ATTR_TAXDWKEN );}

    /** set 세액공제_납세조합공제 : taxdUnin */
    public void setTaxdUnin(Long  taxdUnin) { set( ATTR_TAXDUNIN ,taxdUnin);}
    /** get 세액공제_납세조합공제 : taxdUnin */
    public Long  getTaxdUnin() { return (Long )get( ATTR_TAXDUNIN );}

    /** set 세액공제_주택차입금 : taxdLoan */
    public void setTaxdLoan(Long  taxdLoan) { set( ATTR_TAXDLOAN ,taxdLoan);}
    /** get 세액공제_주택차입금 : taxdLoan */
    public Long  getTaxdLoan() { return (Long )get( ATTR_TAXDLOAN );}

    /** set 세액공제_외국납부 : taxdPaid */
    public void setTaxdPaid(Long  taxdPaid) { set( ATTR_TAXDPAID ,taxdPaid);}
    /** get 세액공제_외국납부 : taxdPaid */
    public Long  getTaxdPaid() { return (Long )get( ATTR_TAXDPAID );}

    /** set 세액공제_외국인감면세액 : taxdRedu */
    public void setTaxdRedu(Long  taxdRedu) { set( ATTR_TAXDREDU ,taxdRedu);}
    /** get 세액공제_외국인감면세액 : taxdRedu */
    public Long  getTaxdRedu() { return (Long )get( ATTR_TAXDREDU );}

    /** set 세액공제_자녀세액공제금액 : addrMccr */
    public void setAddrMccr(Long  addrMccr) { set( ATTR_ADDRMCCR ,addrMccr);}
    /** get 세액공제_자녀세액공제금액 : addrMccr */
    public Long  getAddrMccr() { return (Long )get( ATTR_ADDRMCCR );}

    /** set 특별세액공제계 : spciDcto */
    public void setSpciDcto(Long  spciDcto) { set( ATTR_SPCIDCTO ,spciDcto);}
    /** get 특별세액공제계 : spciDcto */
    public Long  getSpciDcto() { return (Long )get( ATTR_SPCIDCTO );}

    /** set 세액공제_공제계 : taxdCsum */
    public void setTaxdCsum(Long  taxdCsum) { set( ATTR_TAXDCSUM ,taxdCsum);}
    /** get 세액공제_공제계 : taxdCsum */
    public Long  getTaxdCsum() { return (Long )get( ATTR_TAXDCSUM );}

    /** set 결정세액_소득세 : dcsnIncm */
    public void setDcsnIncm(Long  dcsnIncm) { set( ATTR_DCSNINCM ,dcsnIncm);}
    /** get 결정세액_소득세 : dcsnIncm */
    public Long  getDcsnIncm() { return (Long )get( ATTR_DCSNINCM );}

    /** set 결정세액_주민세_지방소득세 : dcsnInhb */
    public void setDcsnInhb(Long  dcsnInhb) { set( ATTR_DCSNINHB ,dcsnInhb);}
    /** get 결정세액_주민세_지방소득세 : dcsnInhb */
    public Long  getDcsnInhb() { return (Long )get( ATTR_DCSNINHB );}

    /** set 결정세액_농특세 : dcsnFafv */
    public void setDcsnFafv(Long  dcsnFafv) { set( ATTR_DCSNFAFV ,dcsnFafv);}
    /** get 결정세액_농특세 : dcsnFafv */
    public Long  getDcsnFafv() { return (Long )get( ATTR_DCSNFAFV );}

    /** set 기납부세액_소득세 : alryPinx */
    public void setAlryPinx(Long  alryPinx) { set( ATTR_ALRYPINX ,alryPinx);}
    /** get 기납부세액_소득세 : alryPinx */
    public Long  getAlryPinx() { return (Long )get( ATTR_ALRYPINX );}

    /** set 기납부세액_주민세_지방소득세 : alryPhbx */
    public void setAlryPhbx(Long  alryPhbx) { set( ATTR_ALRYPHBX ,alryPhbx);}
    /** get 기납부세액_주민세_지방소득세 : alryPhbx */
    public Long  getAlryPhbx() { return (Long )get( ATTR_ALRYPHBX );}

    /** set 기납부세액_농특세 : alryYvtx */
    public void setAlryYvtx(Long  alryYvtx) { set( ATTR_ALRYYVTX ,alryYvtx);}
    /** get 기납부세액_농특세 : alryYvtx */
    public Long  getAlryYvtx() { return (Long )get( ATTR_ALRYYVTX );}

    /** set 이전근무지_총급여 : dcsnTots */
    public void setDcsnTots(Long  dcsnTots) { set( ATTR_DCSNTOTS ,dcsnTots);}
    /** get 이전근무지_총급여 : dcsnTots */
    public Long  getDcsnTots() { return (Long )get( ATTR_DCSNTOTS );}

    /** set 이전근무지_소득세 : dcsnItax */
    public void setDcsnItax(Long  dcsnItax) { set( ATTR_DCSNITAX ,dcsnItax);}
    /** get 이전근무지_소득세 : dcsnItax */
    public Long  getDcsnItax() { return (Long )get( ATTR_DCSNITAX );}

    /** set 이전근무지_주민세_지방소득세 : dcsnBtax */
    public void setDcsnBtax(Long  dcsnBtax) { set( ATTR_DCSNBTAX ,dcsnBtax);}
    /** get 이전근무지_주민세_지방소득세 : dcsnBtax */
    public Long  getDcsnBtax() { return (Long )get( ATTR_DCSNBTAX );}

    /** set 이전근무지_농특세 : fafvTaxi */
    public void setFafvTaxi(Long  fafvTaxi) { set( ATTR_FAFVTAXI ,fafvTaxi);}
    /** get 이전근무지_농특세 : fafvTaxi */
    public Long  getFafvTaxi() { return (Long )get( ATTR_FAFVTAXI );}

    /** set 차감징수_소득세 : subtEtax */
    public void setSubtEtax(Long  subtEtax) { set( ATTR_SUBTETAX ,subtEtax);}
    /** get 차감징수_소득세 : subtEtax */
    public Long  getSubtEtax() { return (Long )get( ATTR_SUBTETAX );}

    /** set 차감징수_주민세_지방소득세 : subtInhb */
    public void setSubtInhb(Long  subtInhb) { set( ATTR_SUBTINHB ,subtInhb);}
    /** get 차감징수_주민세_지방소득세 : subtInhb */
    public Long  getSubtInhb() { return (Long )get( ATTR_SUBTINHB );}

    /** set 차감징수_농특세 : subtFafv */
    public void setSubtFafv(Long  subtFafv) { set( ATTR_SUBTFAFV ,subtFafv);}
    /** get 차감징수_농특세 : subtFafv */
    public Long  getSubtFafv() { return (Long )get( ATTR_SUBTFAFV );}

    /** set 차감징수_세액계 : subtAmsu */
    public void setSubtAmsu(Long  subtAmsu) { set( ATTR_SUBTAMSU ,subtAmsu);}
    /** get 차감징수_세액계 : subtAmsu */
    public Long  getSubtAmsu() { return (Long )get( ATTR_SUBTAMSU );}

    /** set 연금계좌세액공제계 : jrtrHnto */
    public void setJrtrHnto(Long  jrtrHnto) { set( ATTR_JRTRHNTO ,jrtrHnto);}
    /** get 연금계좌세액공제계 : jrtrHnto */
    public Long  getJrtrHnto() { return (Long )get( ATTR_JRTRHNTO );}

    /** set 이월특례기부금_공익신탁금액 : spciOnon */
    public void setSpciOnon(Long  spciOnon) { set( ATTR_SPCIONON ,spciOnon);}
    /** get 이월특례기부금_공익신탁금액 : spciOnon */
    public Long  getSpciOnon() { return (Long )get( ATTR_SPCIONON );}

    /** set 이월법정기부금액 : spciObam */
    public void setSpciObam(Long  spciObam) { set( ATTR_SPCIOBAM ,spciObam);}
    /** get 이월법정기부금액 : spciObam */
    public Long  getSpciObam() { return (Long )get( ATTR_SPCIOBAM );}

    /** set 이월종교단체기부금 : spciOyam */
    public void setSpciOyam(Long  spciOyam) { set( ATTR_SPCIOYAM ,spciOyam);}
    /** get 이월종교단체기부금 : spciOyam */
    public Long  getSpciOyam() { return (Long )get( ATTR_SPCIOYAM );}

    /** set 이월종교단체외기부금 : spciOnam */
    public void setSpciOnam(Long  spciOnam) { set( ATTR_SPCIONAM ,spciOnam);}
    /** get 이월종교단체외기부금 : spciOnam */
    public Long  getSpciOnam() { return (Long )get( ATTR_SPCIONAM );}

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


/** set null : tempPrddTaxn */
public void setTempPrddTaxn(Long  tempPrddTaxn) { set( ATTR_TEMPPRDDTAXN ,tempPrddTaxn);}
/** get null : tempPrddTaxn */
public Long  getTempPrddTaxn() { return (Long )get( ATTR_TEMPPRDDTAXN );}

/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public void setEtgdD14b(Long  etgdD14b) { set( ATTR_ETGDD14B ,etgdD14b);}
/** get 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
public Long  getEtgdD14b() { return (Long )get( ATTR_ETGDD14B );}

/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
public void setEtgdD15b(Long  etgdD15b) { set( ATTR_ETGDD15B ,etgdD15b);}
/** get 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
public Long  getEtgdD15b() { return (Long )get( ATTR_ETGDD15B );}

/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
public void setEtgdD16f(Long  etgdD16f) { set( ATTR_ETGDD16F ,etgdD16f);}
/** get 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
public Long  getEtgdD16f() { return (Long )get( ATTR_ETGDD16F );}

/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
public void setEtgdD16b(Long  etgdD16b) { set( ATTR_ETGDD16B ,etgdD16b);}
/** get 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
public Long  getEtgdD16b() { return (Long )get( ATTR_ETGDD16B );}


}
