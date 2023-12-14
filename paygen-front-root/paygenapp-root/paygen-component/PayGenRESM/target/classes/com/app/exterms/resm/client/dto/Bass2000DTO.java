package com.app.exterms.resm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Yeta2000VO.java
 * @Description : Yeta2000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2000DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

  
    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 연말정산마감일련번호 : edacSeilNum */
    private Long edacSeilNum;

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

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

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

    /** set 연말정산적용년월 : yrtxApptnYrMnth */
    private java.lang.String yrtxApptnYrMnth;

    /** set 연말정산처리일자 : yrtxPrcsDt */
    private java.lang.String yrtxPrcsDt;

    /** set 연말정산처리여부 : yrtxPrcsYn */
    private Boolean yrtxPrcsYn;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부횟수 : divdPymt */
    private java.lang.String divdPymt;

    /** set 세대주여부 : gnanSgtf */
    private java.lang.String gnanSgtf;

    /** set 외국인구분코드 : frnrYeno */
    private java.lang.String frnrYeno;

    /** set 귀속년월_FROM : reymStdt */
    private java.lang.String reymStdt;

    /** set 귀속년월_TO : reymEddt */
    private java.lang.String reymEddt;

    /** set 감면기간_TO : rutrEddt */
    private java.lang.String rutrEddt;

    /** set 감면기간_FROM : rutrStdt */
    private java.lang.String rutrStdt;

    /** set 거주구분여부 : resdFlag */
    private java.lang.String resdFlag;

    /** set 국적코드 : natnGbcd */
    private java.lang.String natnGbcd;

    /** set 국적명 : natnName */
    private java.lang.String natnName;

    /** set 거주지국코드 : redtGbcd */
    private java.lang.String redtGbcd;

    /** set 거주지국명 : redtName */
    private java.lang.String redtName;

    /** set 인적공제항목변동여부 : humnCgue */
    private java.lang.String humnCgue;

    /** set 외국인단일세율적용여부 : frnrSgyn */
    private java.lang.String frnrSgyn;

    /** set 기본공제_배우자유무 : baseWiyn */
    private java.lang.String baseWiyn;

    /** set 기본공제_부양가족수 : baseFmly */
    private Long baseFmly;

    /** set 추가공제_경로우대_70세이상수 : addrCt70 */
    private Long addrCt70;

    /** set 추가공제_장애인수 : addrHdrc */
    private Long addrHdrc;

    /** set 추가공제_부녀자수 : addrFdsu */
    private Long addrFdsu;

    /** set 추가공제_자녀양육비양육수 : addrClct */
    private Long addrClct;

    /** set 추가공제_출산자녀양육수 : addrBhct */
    private Long addrBhct;

    /** set 추가공제_한부모수 : pantOnsu */
    private Long pantOnsu;

    /** set 추가공제_다자녀인원수 : addrMrct */
    private Long addrMrct;

    /** set 종근무지_국민연금보험료 : bnatPsnf */
    private Long bnatPsnf;

    /** set 주근무지_국민연금보험료 : jnatPsnf */
    private Long jnatPsnf;
    
    /** YETA3000 **/
    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    private Long jnatDdct;
    
    /** YETA3000 **/
    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    private Long bnatDdct;

    /** set 종근무지_국민연금외교직원연금 : bpssTech */
    private Long bpssTech;

    /** set 종근무지_국민연금외공무원연금 : bpssPulc */
    private Long bpssPulc;

    /** set 종근무지_국민연금외별정우체국 : bpssFect */
    private Long bpssFect;

    /** set 종근무지_국민연금외군인연금 : bpssSold */
    private Long bpssSold;

    /** set 주근무지_국민연금외공무원연금 : jpssPulc */
    private Long jpssPulc;

    /** set 주근무지_국민연금외군인연금 : jpssSold */
    private Long jpssSold;

    /** set 주근무지_국인연금외교직원연금 : jpssTech */
    private Long jpssTech;

    /** set 주근무지_국민연금외별정우체국 : jpssFect */
    private Long jpssFect;

    /** set 종근무지_종_근로자퇴직보장법 : brtrPsct */
    private Long brtrPsct;

    /** set 종근무지_종_과학기술인공제 : brtrCict */
    private Long brtrCict;

    /** set 종근무지_연금계좌_연금저축 : brtrAnsv */
    private Long brtrAnsv;

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrCict */
    private Long jrtrCict;

    /** set 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
    private Long jrtrCtar;

    /** set 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
    private Long jrtrPsct;

    /** set 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
    private Long jrtrPtar;

    /** set 주근무지_연금계좌_연금저축 : jrtrAnsv */
    private Long jrtrAnsv;

    /** set 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
    private Long jrtrAtar;

    /** set 연금보험료계 : rrptAmnt */
    private Long rrptAmnt;

    /** set 특별공제_종건강보험료 : spciBhlh */
    private Long spciBhlh;

    /** set 특별공제_주건강보험료 : spciHhlh */
    private Long spciHhlh;

    /** set 특별공제_종고용보험료 : spciBepf */
    private Long spciBepf;

    /** set 특별공제_주고용보험료 : spciJepf */
    private Long spciJepf;

    /** set 특별공제_일반보장성보험료 : spciGurt */
    private Long spciGurt;

    /** set 특별공제_장애인전용보험료 : spciHdrc */
    private Long spciHdrc;

    /** set 특별공제_보장성보험료공제대상금액 : spciRttg */
    private Long spciRttg;

    /** set 특별공제_보험료계 : spciIuam */
    private Long spciIuam;

    /** set 특별공제_의료비_본인 : spciSelf */
    private Long spciSelf;

    /** set 특별공제_의료비_경로65세이상 : spciAe65 */
    private Long spciAe65;

    /** set 특별공제_의료비_장애인 : spciDbps */
    private Long spciDbps;

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    private Long spciDetc;

    /** set 특별공제_의료비세액공제대상금액 : spciDtar */
    private Long spciDtar;

    /** set 특별공제_의료비계 : spciEtam */
    private Long spciEtam;

    /** set 특별공제_교육비_본인 : spedSelf */
    private Long spedSelf;

    /** set 특별공제_교육비_취학전아동수 : spedEdsu */
    private Long spedEdsu;

    /** set 특별공제_교육비_취학전아동 : spedEdam */
    private Long spedEdam;

    /** set 특별공제_교육비_초중고자녀수 : spedGdsu */
    private Long spedGdsu;

    /** set 특별공제_교육비_초중고 : spedGdam */
    private Long spedGdam;

    /** set 특별공제_교육비_대학생수 : spedCvsu */
    private Long spedCvsu;

    /** set 특별공제_교육비_대학교 : spedCvam */
    private Long spedCvam;

    /** set 특별공제_장애인수 : spciScsu */
    private Long spciScsu;

    /** set 특별공제_장애인특수교육비 : spciScam */
    private Long spciScam;

    /** set 특별공제_교육비공제대상금액 : spedEtar */
    private Long spedEtar;

    /** set 특별공제_교육비계 : siedToam */
    private Long siedToam;

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    private Long spciRefn;

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    private Long spciResf;

    /** set 특별공제_주택자금_월세금액 : spciHtam */
    private Long spciHtam;

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    private Long spchRefn;

    /** set 특별공제_11장기주택저당차입금15 : spchRe06 */
    private Long spchRe06;

    /** set 특별공제_11장기주택저당차입금29 : spchRe10 */
    private Long spchRe10;

    /** set 특별공제_11장기주택저당차입금30 : spchRe20 */
    private Long spchRe20;

    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    private Long spchRefx;

    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    private Long spchReec;

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
    private Long spch15fx;

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
    private Long spch15fb;

    /** set 특별공제_15장기주택저당_15기타대출 : spch15ec */
    private Long spch15ec;

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
    private Long spch10fb;

    /** set 특별공제_15장기주택저당_10기타대출 : spch10ec */
    private Long spch10ec;

    /** set 세액공제_기부정치자금금액 : taxdPltc */
    private Long taxdPltc;

    /** set 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
    private Long taxd10tg;

    /** set 특별공제_기부금_정치 : spciPltc */
    private Long spciPltc;

    /** set 특별공제_기부금_정치10초과대상금액 : spciPltg */
    private Long spciPltg;

    /** set 특별공제_기부금_법정 : spciFbam */
    private Long spciFbam;

    /** set 특별공제_기부금_법정대상금액 : spciFbtg */
    private Long spciFbtg;

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    private Long spciExam;

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    private Long spciUnon;

    /** set 특별공제_기부금_우리사주조합2015이후 : spciHfam */
    private Long spciHfam;

    /** set 특별공제_기부금_종교단체 : spciYamt */
    private Long spciYamt;

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    private Long spciNamt;

    /** set 특별공제_지정기부금대상금액 : spciDgtg */
    private Long spciDgtg;

    /** set 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
    private Long spciFnrl;

    /** set 개인연금저축불입액_2000년이전 : prvm20be */
    private Long prvm20be;

    /** set 개인연금저축불입액_2001년이후_삭제 : prvm21af */
    private Long prvm21af;

    /** set 기타공제_소기업공제불입금액 : etchPrep */
    private Long etchPrep;

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    private Long etcsComp;

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
    private Long etwkHsvm;

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
    private Long etwkHsbm;

    /** set 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
    private Long etwkHlgm;

    /** set 기타공제_주택마련저축소득금액 : etwkHbdm */
    private Long etwkHbdm;

    /** set 기타공제_투자조합출자금액_2011이전 : etctConc */
    private Long etctConc;

    /** set 기타공제_투자조합출자금액_2012년도 : etgdH09f */
    private Long etgdH09f;

    /** set 기타공제_투자조합출자금액_2013년도 : etgdH13f */
    private Long etgdH13f;

    /** set 기타공제_투자조합출자금액_2014년도 : etgdH14f */
    private Long etgdH14f;

    /** set 기타공제_투자조합출자금액_2015년이후 : etclH15f */
    private Long etclH15f;

    /** set 기타공제투자조합출자금액계 : etgdHdam */
    private Long etgdHdam;

    /** set 기타공제_신용카드등사용금액 : etctCard */
    private Long etctCard;

    /** set 기타공제_직불카드등사용금액 : etchBcbs */
    private Long etchBcbs;

    /** set 기타공제_현금영수증사용금액 : etchUeam */
    private Long etchUeam;

    /** set 기타공제_전통시장사용분 : etchMgvd */
    private Long etchMgvd;

    /** set 기타공제_지로납부_대중교통금액 : etchBced */
    private Long etchBced;

    /** set 기타공제_본인신용카드등사용액_2013 : cardEt13 */
    private Long cardEt13;

    /** set 기타공제_본인신용카드등사용액_2014 : cardEt14 */
    private Long cardEt14;

    /** set 기타공제_본인추가공재율사용액_2013 : etadDd13 */
    private Long etadDd13;

    /** set 기타공제_본인추가공제율사용액_2014하 : etadD14l */
    private Long etadD14l;

    /** set 기타공제_신용카드등사용공제계 : etchBcue */
    private Long etchBcue;

    /** set 기타공제_우리사주출연금액 : etckUnon */
    private Long etckUnon;

    /** set 기타공제_우리사주조합기부금2014이전 : etckUncb */
    private Long etckUncb;

    /** set 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
    private Long etepHsam;

    /** set 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
    private Long etgdCtra;

    /** set 기타공제_장기집합투자증권저축금액 : etepSest */
    private Long etepSest;

    /** set 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
    private Long etclHm01;

    /** set 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
    private Long etclHm02;

    /** set 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
    private Long etclHm03;

    /** set 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
    private Long etclHmta;

    /** set 기타공제_기타제목 : etclEttl */
    private java.lang.String etclEttl;

    /** set 기타공제_기타금액 : etclEtam */
    private Long etclEtam;

    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    private java.lang.String  taxdIncd;
    
    private Boolean  taxdIncd1;
    private Boolean  taxdIncd2;
    private Boolean  taxdIncd3;
    private Boolean  taxdIncd4;
     

    /** set 세액공제_외국인_근로제공일자 : taxdWkdt */
    private java.lang.String taxdWkdt;

    /** set 세액공제_외국인_감면기간만료일자 : tamaEddt */
    private java.lang.String tamaEddt;

    /** set 세액공제_외국인_감면신청접수일자 : tamaIndt */
    private java.lang.String tamaIndt;

    /** set 세액공제_외국인_감면신청제출일자 : tamaOudt */
    private java.lang.String tamaOudt;

    /** set 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
    private java.lang.String txlgFrrd;

    /** set 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
    private java.lang.String txlgFrid;

    /** set 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
    private java.lang.String txlgWkid;

    /** set 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
    private java.lang.String txlgTxtd;

    /** set 세액공제_중소기업청년감면취업일자 : txlgBscd */
    private java.lang.String txlgBscd;

    /** set 세액공제_중소기업청년감면종료일자 : txlgBcde */
    private java.lang.String txlgBcde;

    /** set 세액감면_소득세법감면세액 : txlgItct */
    private Long txlgItct;

    /** set 세액감면_취업청년감면대상총급여액 : txlgBsta */
    private Long txlgBsta;

    /** set 세액감면_취업청년감면근로자총급여액 : txlgWkta */
    private Long txlgWkta;

    /** set 세액감면_계산감면세액금액 : txlgClta */
    private Long txlgClta;

    /** set 세액감면_외국인기술자감면세액 : txlgFrta */
    private Long txlgFrta;

    /** set 세액감면_조세조약감면세액 : txlgTxty */
    private Long txlgTxty;

    /** set 세액공제_외국납부_국외원천소득금액 : txlgInam */
    private Long txlgInam;

    /** set 세액공제_외국납부_외화납세액 : txlgDlam */
    private Long txlgDlam;

    /** set 세액공제_외국납부_원화납세액 : txlgWnam */
    private Long txlgWnam;

    /** set 세액공제_외국납부_납세국명 : txlgOtcy */
    private java.lang.String txlgOtcy;

    /** set 세액공제_외국납부_납부일자 : txlgOtdt */
    private java.lang.String txlgOtdt;

    /** set 세액공제_외국납부_신청서제출일자 : txlgApdt */
    private java.lang.String txlgApdt;

    /** set 세액공제_외국납부_국외근무처명 : txlgOuwk */
    private java.lang.String txlgOuwk;

    /** set 세액공제_외국납부_근무시작일자 : txapStdt */
    private java.lang.String txapStdt;

    /** set 세액공제_외국납부_근무종료일자 : txapEddt */
    private java.lang.String txapEddt;

    /** set 세액공제_외국납부_직책 : txapWkdy */
    private java.lang.String txapWkdy;

    /** set 세액공제_납세조합공제 : taxdUnin */
    private Long taxdUnin;

    /** set 세액공제_주택차입금이자상황금액 : taxdLoaa */
    private Long taxdLoaa;

    /** set 추가서류_연금저축등소득공제제출여부 : addcNtyn */
    private java.lang.String addcNtyn;

    /** set 추가서류_의료비지급명세서제출여부 : addcMdyn */
    private java.lang.String addcMdyn;

    /** set 추가서류_기부금명세서제출여부 : addcCtyn */
    private java.lang.String addcCtyn;

    /** set 추가서류_소득공제증빙서류제출여부 : addcPfyn */
    private java.lang.String addcPfyn;

    /** set 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
    private java.lang.String addfPvyn;

    /** set 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
    private java.lang.String spciReyn;

    /** set 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
    private java.lang.String txlgMxtm;

    /** set 소득신고제출일자 : incoOudt */
    private java.lang.String incoOudt;

    /** set 소득신고제출여부 : incoOufg */
    private java.lang.String incoOufg;

    /** set 파일생성여부 : jdocFile */
    private java.lang.String jdocFile;

    /** set 연금계좌계 : jrtrAtom */
    private Long jrtrAtom;

    /** set 연금계좌공제대상금액 : jrtrTotr */
    private Long jrtrTotr;

    /** set 특별공제_장애인보장성대상금액 : spciHdtg */
    private Long spciHdtg;

    /** set 특별공제_보장성보험료대상금액 : spciDetg */
    private Long spciDetg;

    /** set 특별공제_보장성보험료계 : spciRtto */
    private Long spciRtto;

    /** set 본인의료비공제대상금액 : spciSftg */
    private Long spciSftg;

    /** set 65세이상자의료비공제대상금액 : spci65tg */
    private Long spci65tg;

    /** set 장애인의료비공제대상금액 : spciPstg */
    private Long spciPstg;

    /** set 그밖의의료비공제대상금액 : spciEtcg */
    private Long spciEtcg;

    /** set 소득자본인교육비대상금액 : spedSftr */
    private Long spedSftr;

    /** set 취학전아동교육비대상금액 : spedEdtr */
    private Long spedEdtr;

    /** set 초중고교육비대상금액 : spedGdtr */
    private Long spedGdtr;

    /** set 대학생교육비대상금액 : spedCvtr */
    private Long spedCvtr;

    /** set 특수교육비공제대상금액 : spciSctr */
    private Long spciSctr;

    /** set 특례기부금_공익법인제외대상금액 : spciExtg */
    private Long spciExtg;

    /** set 공익법인신탁대상금액 : spciUntg */
    private Long spciUntg;

    /** set 우리사주종합기부대상금액 : spciHftg */
    private Long spciHftg;

    /** set 종교단체외지정대상금액 : spciNatg */
    private Long spciNatg;

    /** set 종교단체지정대상금액 : spciYatg */
    private Long spciYatg;

    /** set 기부금합계금액 : spciDgam */
    private Long spciDgam;

    /** set 이월특례기부금_공익신탁금액 : spciOnon */
    private Long spciOnon;

    /** set 이월법정기부금액 : spciObam */
    private Long spciObam;

    /** set 이월종교단체기부금 : spciOyam */
    private Long spciOyam;

    /** set 이월종교단체외기부금 : spciOnam */
    private Long spciOnam;

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
    
    /** set 기납부세액_소득세 : alryPinx 
     * TABLE : YETA0300 */
    private Long alryPinx;
    
    /** set 기납부세액_주민세_지방소득세 : alryPhbx 
     * TABLE : YETA0300 */
    private Long alryPhbx;

    private Long  currTots;
    
	/** set 기타공제_본인신용카등사용액_2015 : cardEt15 */
	private Long cardEt15;
	
	/** set 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
	private Long etadD15h;
	
	/** set 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
	private Long etadD15l;

 
	/*** 다른 용도의 dto 임  */
   
    /** set 근로사업번호 : workBusinNum */
    private java.lang.String workBusinNum;

    /** set 근로사업생성년도 : workBusinCretnYr */
    private java.lang.String workBusinCretnYr;

    /** set 근로사업구분코드 : workBusinDivCd */
    private java.lang.String workBusinDivCd;

    /** set 근로사업단계구분코드 : workBusinStgeDivCd */
    private java.lang.String workBusinStgeDivCd;

    /** set 근로사업시작일자 : workBusinBgnnDt */
    private java.lang.String workBusinBgnnDt;

    /** set 근로사업종료일자 : workBusinEndDt */
    private java.lang.String workBusinEndDt;

    /** set 근로사업사용여부 : workBusinUseYn */
    private java.lang.String workBusinUseYn;

    /** set 근로사업비고내용 : workBusinCtnt */
    private java.lang.String workBusinCtnt;

      
    /**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinNum()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinNum get
	 */
	public java.lang.String getWorkBusinNum() {
		return workBusinNum;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinNum(java.lang.String workBusinNum)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinNum the workBusinNum to set
	 */
	public void setWorkBusinNum(java.lang.String workBusinNum) {
		this.workBusinNum = workBusinNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinCretnYr()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinCretnYr get
	 */
	public java.lang.String getWorkBusinCretnYr() {
		return workBusinCretnYr;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinCretnYr(java.lang.String workBusinCretnYr)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinCretnYr the workBusinCretnYr to set
	 */
	public void setWorkBusinCretnYr(java.lang.String workBusinCretnYr) {
		this.workBusinCretnYr = workBusinCretnYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinDivCd get
	 */
	public java.lang.String getWorkBusinDivCd() {
		return workBusinDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinDivCd(java.lang.String workBusinDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinDivCd the workBusinDivCd to set
	 */
	public void setWorkBusinDivCd(java.lang.String workBusinDivCd) {
		this.workBusinDivCd = workBusinDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinStgeDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinStgeDivCd get
	 */
	public java.lang.String getWorkBusinStgeDivCd() {
		return workBusinStgeDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinStgeDivCd(java.lang.String workBusinStgeDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinStgeDivCd the workBusinStgeDivCd to set
	 */
	public void setWorkBusinStgeDivCd(java.lang.String workBusinStgeDivCd) {
		this.workBusinStgeDivCd = workBusinStgeDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinBgnnDt()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinBgnnDt get
	 */
	public java.lang.String getWorkBusinBgnnDt() {
		return workBusinBgnnDt;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinBgnnDt(java.lang.String workBusinBgnnDt)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinBgnnDt the workBusinBgnnDt to set
	 */
	public void setWorkBusinBgnnDt(java.lang.String workBusinBgnnDt) {
		this.workBusinBgnnDt = workBusinBgnnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinEndDt()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinEndDt get
	 */
	public java.lang.String getWorkBusinEndDt() {
		return workBusinEndDt;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinEndDt(java.lang.String workBusinEndDt)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinEndDt the workBusinEndDt to set
	 */
	public void setWorkBusinEndDt(java.lang.String workBusinEndDt) {
		this.workBusinEndDt = workBusinEndDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinUseYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinUseYn get
	 */
	public java.lang.String getWorkBusinUseYn() {
		return workBusinUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinUseYn(java.lang.String workBusinUseYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinUseYn the workBusinUseYn to set
	 */
	public void setWorkBusinUseYn(java.lang.String workBusinUseYn) {
		this.workBusinUseYn = workBusinUseYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getWorkBusinCtnt()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the workBusinCtnt get
	 */
	public java.lang.String getWorkBusinCtnt() {
		return workBusinCtnt;
	}

	/**
	 * Comment : 
	 *@fn void setWorkBusinCtnt(java.lang.String workBusinCtnt)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param workBusinCtnt the workBusinCtnt to set
	 */
	public void setWorkBusinCtnt(java.lang.String workBusinCtnt) {
		this.workBusinCtnt = workBusinCtnt;
	}

	/**
	 * Comment : 
	 * @fn Long getCurrTots()
	 * @brief date:2016 Feb 5, 2016 user:leeheuisung
	 * @return the currTots get
	 */
	public Long getCurrTots() {
		return currTots;
	}

	/**
	 * Comment : 
	 *@fn void setCurrTots(Long currTots)
	 *@brief date:2016 Feb 5, 2016 user:leeheuisung
	 *@param currTots the currTots to set
	 */
	public void setCurrTots(Long currTots) {
		this.currTots = currTots;
	}

	/**
	 * Comment : 
	 * @fn Long getCardEt15()
	 * @brief date:2016 Feb 5, 2016 user:leeheuisung
	 * @return the cardEt15 get
	 */
	public Long getCardEt15() {
		return cardEt15;
	}

	/**
	 * Comment : 
	 * @fn Long getEtadD15h()
	 * @brief date:2016 Feb 5, 2016 user:leeheuisung
	 * @return the etadD15h get
	 */
	public Long getEtadD15h() {
		return etadD15h;
	}

	/**
	 * Comment : 
	 * @fn Long getEtadD15l()
	 * @brief date:2016 Feb 5, 2016 user:leeheuisung
	 * @return the etadD15l get
	 */
	public Long getEtadD15l() {
		return etadD15l;
	}

	/**
	 * Comment : 
	 *@fn void setCardEt15(Long cardEt15)
	 *@brief date:2016 Feb 4, 2016 user:leeheuisung
	 *@param cardEt15 the cardEt15 to set
	 */
	public void setCardEt15(Long cardEt15) {
		this.cardEt15 = cardEt15;
	}

	/**
	 * Comment : 
	 *@fn void setEtadD15h(Long etadD15h)
	 *@brief date:2016 Feb 4, 2016 user:leeheuisung
	 *@param etadD15h the etadD15h to set
	 */
	public void setEtadD15h(Long etadD15h) {
		this.etadD15h = etadD15h;
	}

	/**
	 * Comment : 
	 *@fn void setEtadD15l(Long etadD15l)
	 *@brief date:2016 Feb 4, 2016 user:leeheuisung
	 *@param etadD15l the etadD15l to set
	 */
	public void setEtadD15l(Long etadD15l) {
		this.etadD15l = etadD15l;
	}

	 
	/**
	 * Comment : 
	 * @fn java.lang.String getTaxdIncd()
	 * @brief date:2016 Feb 4, 2016 user:leeheuisung
	 * @return the taxdIncd get
	 */
	public java.lang.String getTaxdIncd() {
		return taxdIncd;
	}

	/**
 * Comment : 
 * @fn Boolean getTaxdIncd1()
 * @brief date:2016 Jan 31, 2016 user:leeheuisung
 * @return the taxdIncd1 get
 */
public Boolean getTaxdIncd1() {
	return taxdIncd1;
}

/**
 * Comment : 
 *@fn void setTaxdIncd1(Boolean taxdIncd1)
 *@brief date:2016 Jan 31, 2016 user:leeheuisung
 *@param taxdIncd1 the taxdIncd1 to set
 */
public void setTaxdIncd1(Boolean taxdIncd1) {
	this.taxdIncd1 = taxdIncd1;
}

/**
 * Comment : 
 * @fn Boolean getTaxdIncd2()
 * @brief date:2016 Jan 31, 2016 user:leeheuisung
 * @return the taxdIncd2 get
 */
public Boolean getTaxdIncd2() {
	return taxdIncd2;
}

/**
 * Comment : 
 *@fn void setTaxdIncd2(Boolean taxdIncd2)
 *@brief date:2016 Jan 31, 2016 user:leeheuisung
 *@param taxdIncd2 the taxdIncd2 to set
 */
public void setTaxdIncd2(Boolean taxdIncd2) {
	this.taxdIncd2 = taxdIncd2;
}

/**
 * Comment : 
 * @fn Boolean getTaxdIncd3()
 * @brief date:2016 Jan 31, 2016 user:leeheuisung
 * @return the taxdIncd3 get
 */
public Boolean getTaxdIncd3() {
	return taxdIncd3;
}

/**
 * Comment : 
 *@fn void setTaxdIncd3(Boolean taxdIncd3)
 *@brief date:2016 Jan 31, 2016 user:leeheuisung
 *@param taxdIncd3 the taxdIncd3 to set
 */
public void setTaxdIncd3(Boolean taxdIncd3) {
	this.taxdIncd3 = taxdIncd3;
}

/**
 * Comment : 
 * @fn Boolean getTaxdIncd4()
 * @brief date:2016 Jan 31, 2016 user:leeheuisung
 * @return the taxdIncd4 get
 */
public Boolean getTaxdIncd4() {
	return taxdIncd4;
}

/**
 * Comment : 
 *@fn void setTaxdIncd4(Boolean taxdIncd4)
 *@brief date:2016 Jan 31, 2016 user:leeheuisung
 *@param taxdIncd4 the taxdIncd4 to set
 */
public void setTaxdIncd4(Boolean taxdIncd4) {
	this.taxdIncd4 = taxdIncd4;
}

/**
 * Comment : 
 *@fn void setTaxdIncd(java.lang.String taxdIncd)
 *@brief date:2016 Jan 31, 2016 user:leeheuisung
 *@param taxdIncd the taxdIncd to set
 */
public void setTaxdIncd(java.lang.String taxdIncd) {
	this.taxdIncd = taxdIncd;
}

 
	public Long getAlryPinx() {
		return alryPinx;
	}

	public void setAlryPinx(Long alryPinx) {
		this.alryPinx = alryPinx;
	}

	public Long getAlryPhbx() {
		return alryPhbx;
	}

	public void setAlryPhbx(Long alryPhbx) {
		this.alryPhbx = alryPhbx;
	}

	/**
	 * Comment : 
	 * @fn Long getEdacSeilNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the edacSeilNum get
	 */
	public Long getEdacSeilNum() {
		return edacSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEdacSeilNum(Long edacSeilNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param edacSeilNum the edacSeilNum to set
	 */
	public void setEdacSeilNum(Long edacSeilNum) {
		this.edacSeilNum = edacSeilNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxApptnYrMnth()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the yrtxApptnYrMnth get
	 */
	public java.lang.String getYrtxApptnYrMnth() {
		return yrtxApptnYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxApptnYrMnth(java.lang.String yrtxApptnYrMnth)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param yrtxApptnYrMnth the yrtxApptnYrMnth to set
	 */
	public void setYrtxApptnYrMnth(java.lang.String yrtxApptnYrMnth) {
		this.yrtxApptnYrMnth = yrtxApptnYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxPrcsDt()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the yrtxPrcsDt get
	 */
	public java.lang.String getYrtxPrcsDt() {
		return yrtxPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrcsDt(java.lang.String yrtxPrcsDt)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param yrtxPrcsDt the yrtxPrcsDt to set
	 */
	public void setYrtxPrcsDt(java.lang.String yrtxPrcsDt) {
		this.yrtxPrcsDt = yrtxPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxPrcsYn()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the yrtxPrcsYn get
	 */
	public Boolean getYrtxPrcsYn() {
		return yrtxPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrcsYn(java.lang.String yrtxPrcsYn)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param yrtxPrcsYn the yrtxPrcsYn to set
	 */
	public void setYrtxPrcsYn(Boolean yrtxPrcsYn) {
		this.yrtxPrcsYn = yrtxPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymtDivCd()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the divdPymtDivCd get
	 */
	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtDivCd(java.lang.String divdPymtDivCd)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param divdPymtDivCd the divdPymtDivCd to set
	 */
	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymt()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the divdPymt get
	 */
	public java.lang.String getDivdPymt() {
		return divdPymt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymt(java.lang.String divdPymt)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param divdPymt the divdPymt to set
	 */
	public void setDivdPymt(java.lang.String divdPymt) {
		this.divdPymt = divdPymt;
	}

	/**
	 * Comment : 
	 * @fn Long getBpssTech()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the bpssTech get
	 */
	public Long getBpssTech() {
		return bpssTech;
	}

	/**
	 * Comment : 
	 *@fn void setBpssTech(Long bpssTech)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param bpssTech the bpssTech to set
	 */
	public void setBpssTech(Long bpssTech) {
		this.bpssTech = bpssTech;
	}

	/**
	 * Comment : 
	 * @fn Long getBpssSold()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the bpssSold get
	 */
	public Long getBpssSold() {
		return bpssSold;
	}

	/**
	 * Comment : 
	 *@fn void setBpssSold(Long bpssSold)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param bpssSold the bpssSold to set
	 */
	public void setBpssSold(Long bpssSold) {
		this.bpssSold = bpssSold;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
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
    
    public java.lang.String getDtilOccuInttnCd() {
        return this.dtilOccuInttnCd;
    }
    
    public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
        this.dtilOccuInttnCd = dtilOccuInttnCd;
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
    
    public java.lang.String getGnanSgtf() {
        return this.gnanSgtf;
    }
    
    public void setGnanSgtf(java.lang.String gnanSgtf) {
        this.gnanSgtf = gnanSgtf;
    }
    
    public java.lang.String getFrnrYeno() {
        return this.frnrYeno;
    }
    
    public void setFrnrYeno(java.lang.String frnrYeno) {
        this.frnrYeno = frnrYeno;
    }
    
    public java.lang.String getReymStdt() {
        return this.reymStdt;
    }
    
    public void setReymStdt(java.lang.String reymStdt) {
        this.reymStdt = reymStdt;
    }
    
    public java.lang.String getReymEddt() {
        return this.reymEddt;
    }
    
    public void setReymEddt(java.lang.String reymEddt) {
        this.reymEddt = reymEddt;
    }
    
    public java.lang.String getRutrEddt() {
        return this.rutrEddt;
    }
    
    public void setRutrEddt(java.lang.String rutrEddt) {
        this.rutrEddt = rutrEddt;
    }
    
    public java.lang.String getRutrStdt() {
        return this.rutrStdt;
    }
    
    public void setRutrStdt(java.lang.String rutrStdt) {
        this.rutrStdt = rutrStdt;
    }
    
    public java.lang.String getResdFlag() {
        return this.resdFlag;
    }
    
    public void setResdFlag(java.lang.String resdFlag) {
        this.resdFlag = resdFlag;
    }
    
    public java.lang.String getNatnGbcd() {
        return this.natnGbcd;
    }
    
    public void setNatnGbcd(java.lang.String natnGbcd) {
        this.natnGbcd = natnGbcd;
    }
    
    public java.lang.String getNatnName() {
        return this.natnName;
    }
    
    public void setNatnName(java.lang.String natnName) {
        this.natnName = natnName;
    }
    
    public java.lang.String getRedtGbcd() {
        return this.redtGbcd;
    }
    
    public void setRedtGbcd(java.lang.String redtGbcd) {
        this.redtGbcd = redtGbcd;
    }
    
    public java.lang.String getRedtName() {
        return this.redtName;
    }
    
    public void setRedtName(java.lang.String redtName) {
        this.redtName = redtName;
    }
    
    public java.lang.String getHumnCgue() {
        return this.humnCgue;
    }
    
    public void setHumnCgue(java.lang.String humnCgue) {
        this.humnCgue = humnCgue;
    }
    
    public java.lang.String getFrnrSgyn() {
        return this.frnrSgyn;
    }
    
    public void setFrnrSgyn(java.lang.String frnrSgyn) {
        this.frnrSgyn = frnrSgyn;
    }
    
    public java.lang.String getBaseWiyn() {
        return this.baseWiyn;
    }
    
    public void setBaseWiyn(java.lang.String baseWiyn) {
        this.baseWiyn = baseWiyn;
    }
    
    public Long getBaseFmly() {
        return this.baseFmly;
    }
    
    public void setBaseFmly(Long baseFmly) {
        this.baseFmly = baseFmly;
    }
    
    public Long getAddrCt70() {
        return this.addrCt70;
    }
    
    public void setAddrCt70(Long addrCt70) {
        this.addrCt70 = addrCt70;
    }
    
    public Long getAddrHdrc() {
        return this.addrHdrc;
    }
    
    public void setAddrHdrc(Long addrHdrc) {
        this.addrHdrc = addrHdrc;
    }
    
    public Long getAddrFdsu() {
        return this.addrFdsu;
    }
    
    public void setAddrFdsu(Long addrFdsu) {
        this.addrFdsu = addrFdsu;
    }
    
    public Long getAddrClct() {
        return this.addrClct;
    }
    
    public void setAddrClct(Long addrClct) {
        this.addrClct = addrClct;
    }
    
    public Long getAddrBhct() {
        return this.addrBhct;
    }
    
    public void setAddrBhct(Long addrBhct) {
        this.addrBhct = addrBhct;
    }
    
    public Long getPantOnsu() {
        return this.pantOnsu;
    }
    
    public void setPantOnsu(Long pantOnsu) {
        this.pantOnsu = pantOnsu;
    }
    
    public Long getAddrMrct() {
        return this.addrMrct;
    }
    
    public void setAddrMrct(Long addrMrct) {
        this.addrMrct = addrMrct;
    }
    
    public Long getBnatPsnf() {
        return this.bnatPsnf;
    }
    
    public void setBnatPsnf(Long bnatPsnf) {
        this.bnatPsnf = bnatPsnf;
    }
    
    public Long getJnatPsnf() {
        return this.jnatPsnf;
    }
    
    public void setJnatPsnf(Long jnatPsnf) {
        this.jnatPsnf = jnatPsnf;
    }
    
    public Long getBpssFect() {
        return this.bpssFect;
    }
    
    public void setBpssFect(Long bpssFect) {
        this.bpssFect = bpssFect;
    }
    
    public Long getBpssPulc() {
        return this.bpssPulc;
    }
    
    public void setBpssPulc(Long bpssPulc) {
        this.bpssPulc = bpssPulc;
    }
    
    public Long getJpssPulc() {
        return this.jpssPulc;
    }
    
    public void setJpssPulc(Long jpssPulc) {
        this.jpssPulc = jpssPulc;
    }
    
    public Long getJpssSold() {
        return this.jpssSold;
    }
    
    public void setJpssSold(Long jpssSold) {
        this.jpssSold = jpssSold;
    }
    
    public Long getJpssTech() {
        return this.jpssTech;
    }
    
    public void setJpssTech(Long jpssTech) {
        this.jpssTech = jpssTech;
    }
    
    public Long getJpssFect() {
        return this.jpssFect;
    }
    
    public void setJpssFect(Long jpssFect) {
        this.jpssFect = jpssFect;
    }
    
    public Long getBrtrPsct() {
        return this.brtrPsct;
    }
    
    public void setBrtrPsct(Long brtrPsct) {
        this.brtrPsct = brtrPsct;
    }
    
    public Long getBrtrCict() {
        return this.brtrCict;
    }
    
    public void setBrtrCict(Long brtrCict) {
        this.brtrCict = brtrCict;
    }
    
    public Long getBrtrAnsv() {
        return this.brtrAnsv;
    }
    
    public void setBrtrAnsv(Long brtrAnsv) {
        this.brtrAnsv = brtrAnsv;
    }
    
    public Long getJrtrCict() {
        return this.jrtrCict;
    }
    
    public void setJrtrCict(Long jrtrCict) {
        this.jrtrCict = jrtrCict;
    }
    
    public Long getJrtrCtar() {
        return this.jrtrCtar;
    }
    
    public void setJrtrCtar(Long jrtrCtar) {
        this.jrtrCtar = jrtrCtar;
    }
    
    public Long getJrtrPsct() {
        return this.jrtrPsct;
    }
    
    public void setJrtrPsct(Long jrtrPsct) {
        this.jrtrPsct = jrtrPsct;
    }
    
    public Long getJrtrPtar() {
        return this.jrtrPtar;
    }
    
    public void setJrtrPtar(Long jrtrPtar) {
        this.jrtrPtar = jrtrPtar;
    }
    
    public Long getJrtrAnsv() {
        return this.jrtrAnsv;
    }
    
    public void setJrtrAnsv(Long jrtrAnsv) {
        this.jrtrAnsv = jrtrAnsv;
    }
    
    public Long getJrtrAtar() {
        return this.jrtrAtar;
    }
    
    public void setJrtrAtar(Long jrtrAtar) {
        this.jrtrAtar = jrtrAtar;
    }
    
    public Long getRrptAmnt() {
        return this.rrptAmnt;
    }
    
    public void setRrptAmnt(Long rrptAmnt) {
        this.rrptAmnt = rrptAmnt;
    }
    
    public Long getSpciBhlh() {
        return this.spciBhlh;
    }
    
    public void setSpciBhlh(Long spciBhlh) {
        this.spciBhlh = spciBhlh;
    }
    
    public Long getSpciHhlh() {
        return this.spciHhlh;
    }
    
    public void setSpciHhlh(Long spciHhlh) {
        this.spciHhlh = spciHhlh;
    }
    
    public Long getSpciBepf() {
        return this.spciBepf;
    }
    
    public void setSpciBepf(Long spciBepf) {
        this.spciBepf = spciBepf;
    }
    
    public Long getSpciJepf() {
        return this.spciJepf;
    }
    
    public void setSpciJepf(Long spciJepf) {
        this.spciJepf = spciJepf;
    }
    
    public Long getSpciGurt() {
        return this.spciGurt;
    }
    
    public void setSpciGurt(Long spciGurt) {
        this.spciGurt = spciGurt;
    }
    
    public Long getSpciHdrc() {
        return this.spciHdrc;
    }
    
    public void setSpciHdrc(Long spciHdrc) {
        this.spciHdrc = spciHdrc;
    }
    
    public Long getSpciRttg() {
        return this.spciRttg;
    }
    
    public void setSpciRttg(Long spciRttg) {
        this.spciRttg = spciRttg;
    }
    
    public Long getSpciIuam() {
        return this.spciIuam;
    }
    
    public void setSpciIuam(Long spciIuam) {
        this.spciIuam = spciIuam;
    }
    
    public Long getSpciSelf() {
        return this.spciSelf;
    }
    
    public void setSpciSelf(Long spciSelf) {
        this.spciSelf = spciSelf;
    }
    
    public Long getSpciAe65() {
        return this.spciAe65;
    }
    
    public void setSpciAe65(Long spciAe65) {
        this.spciAe65 = spciAe65;
    }
    
    public Long getSpciDbps() {
        return this.spciDbps;
    }
    
    public void setSpciDbps(Long spciDbps) {
        this.spciDbps = spciDbps;
    }
    
    public Long getSpciDetc() {
        return this.spciDetc;
    }
    
    public void setSpciDetc(Long spciDetc) {
        this.spciDetc = spciDetc;
    }
    
    public Long getSpciDtar() {
        return this.spciDtar;
    }
    
    public void setSpciDtar(Long spciDtar) {
        this.spciDtar = spciDtar;
    }
    
    public Long getSpciEtam() {
        return this.spciEtam;
    }
    
    public void setSpciEtam(Long spciEtam) {
        this.spciEtam = spciEtam;
    }
    
    public Long getSpedSelf() {
        return this.spedSelf;
    }
    
    public void setSpedSelf(Long spedSelf) {
        this.spedSelf = spedSelf;
    }
    
    public Long getSpedEdsu() {
        return this.spedEdsu;
    }
    
    public void setSpedEdsu(Long spedEdsu) {
        this.spedEdsu = spedEdsu;
    }
    
    public Long getSpedEdam() {
        return this.spedEdam;
    }
    
    public void setSpedEdam(Long spedEdam) {
        this.spedEdam = spedEdam;
    }
    
    public Long getSpedGdsu() {
        return this.spedGdsu;
    }
    
    public void setSpedGdsu(Long spedGdsu) {
        this.spedGdsu = spedGdsu;
    }
    
    public Long getSpedGdam() {
        return this.spedGdam;
    }
    
    public void setSpedGdam(Long spedGdam) {
        this.spedGdam = spedGdam;
    }
    
    public Long getSpedCvsu() {
        return this.spedCvsu;
    }
    
    public void setSpedCvsu(Long spedCvsu) {
        this.spedCvsu = spedCvsu;
    }
    
    public Long getSpedCvam() {
        return this.spedCvam;
    }
    
    public void setSpedCvam(Long spedCvam) {
        this.spedCvam = spedCvam;
    }
    
    public Long getSpciScsu() {
        return this.spciScsu;
    }
    
    public void setSpciScsu(Long spciScsu) {
        this.spciScsu = spciScsu;
    }
    
    public Long getSpciScam() {
        return this.spciScam;
    }
    
    public void setSpciScam(Long spciScam) {
        this.spciScam = spciScam;
    }
    
    public Long getSpedEtar() {
        return this.spedEtar;
    }
    
    public void setSpedEtar(Long spedEtar) {
        this.spedEtar = spedEtar;
    }
    
    public Long getSiedToam() {
        return this.siedToam;
    }
    
    public void setSiedToam(Long siedToam) {
        this.siedToam = siedToam;
    }
    
    public Long getSpciRefn() {
        return this.spciRefn;
    }
    
    public void setSpciRefn(Long spciRefn) {
        this.spciRefn = spciRefn;
    }
    
    public Long getSpciResf() {
        return this.spciResf;
    }
    
    public void setSpciResf(Long spciResf) {
        this.spciResf = spciResf;
    }
    
    public Long getSpciHtam() {
        return this.spciHtam;
    }
    
    public void setSpciHtam(Long spciHtam) {
        this.spciHtam = spciHtam;
    }
    
    public Long getSpchRefn() {
        return this.spchRefn;
    }
    
    public void setSpchRefn(Long spchRefn) {
        this.spchRefn = spchRefn;
    }
    
    public Long getSpchRe06() {
        return this.spchRe06;
    }
    
    public void setSpchRe06(Long spchRe06) {
        this.spchRe06 = spchRe06;
    }
    
    public Long getSpchRe10() {
        return this.spchRe10;
    }
    
    public void setSpchRe10(Long spchRe10) {
        this.spchRe10 = spchRe10;
    }
    
    public Long getSpchRe20() {
        return this.spchRe20;
    }
    
    public void setSpchRe20(Long spchRe20) {
        this.spchRe20 = spchRe20;
    }
    
    public Long getSpchRefx() {
        return this.spchRefx;
    }
    
    public void setSpchRefx(Long spchRefx) {
        this.spchRefx = spchRefx;
    }
    
    public Long getSpchReec() {
        return this.spchReec;
    }
    
    public void setSpchReec(Long spchReec) {
        this.spchReec = spchReec;
    }
    
    public Long getSpch15fx() {
        return this.spch15fx;
    }
    
    public void setSpch15fx(Long spch15fx) {
        this.spch15fx = spch15fx;
    }
    
    public Long getSpch15fb() {
        return this.spch15fb;
    }
    
    public void setSpch15fb(Long spch15fb) {
        this.spch15fb = spch15fb;
    }
    
    public Long getSpch15ec() {
        return this.spch15ec;
    }
    
    public void setSpch15ec(Long spch15ec) {
        this.spch15ec = spch15ec;
    }
    
    public Long getSpch10fb() {
        return this.spch10fb;
    }
    
    public void setSpch10fb(Long spch10fb) {
        this.spch10fb = spch10fb;
    }
    
    public Long getSpch10ec() {
        return this.spch10ec;
    }
    
    public void setSpch10ec(Long spch10ec) {
        this.spch10ec = spch10ec;
    }
    
    public Long getTaxdPltc() {
        return this.taxdPltc;
    }
    
    public void setTaxdPltc(Long taxdPltc) {
        this.taxdPltc = taxdPltc;
    }
    
    public Long getTaxd10tg() {
        return this.taxd10tg;
    }
    
    public void setTaxd10tg(Long taxd10tg) {
        this.taxd10tg = taxd10tg;
    }
    
    public Long getSpciPltc() {
        return this.spciPltc;
    }
    
    public void setSpciPltc(Long spciPltc) {
        this.spciPltc = spciPltc;
    }
    
    public Long getSpciPltg() {
        return this.spciPltg;
    }
    
    public void setSpciPltg(Long spciPltg) {
        this.spciPltg = spciPltg;
    }
    
    public Long getSpciFbam() {
        return this.spciFbam;
    }
    
    public void setSpciFbam(Long spciFbam) {
        this.spciFbam = spciFbam;
    }
    
    public Long getSpciFbtg() {
        return this.spciFbtg;
    }
    
    public void setSpciFbtg(Long spciFbtg) {
        this.spciFbtg = spciFbtg;
    }
    
    public Long getSpciExam() {
        return this.spciExam;
    }
    
    public void setSpciExam(Long spciExam) {
        this.spciExam = spciExam;
    }
    
    public Long getSpciUnon() {
        return this.spciUnon;
    }
    
    public void setSpciUnon(Long spciUnon) {
        this.spciUnon = spciUnon;
    }
    
    public Long getSpciHfam() {
        return this.spciHfam;
    }
    
    public void setSpciHfam(Long spciHfam) {
        this.spciHfam = spciHfam;
    }
    
    public Long getSpciYamt() {
        return this.spciYamt;
    }
    
    public void setSpciYamt(Long spciYamt) {
        this.spciYamt = spciYamt;
    }
    
    public Long getSpciNamt() {
        return this.spciNamt;
    }
    
    public void setSpciNamt(Long spciNamt) {
        this.spciNamt = spciNamt;
    }
    
    public Long getSpciDgtg() {
        return this.spciDgtg;
    }
    
    public void setSpciDgtg(Long spciDgtg) {
        this.spciDgtg = spciDgtg;
    }
    
    public Long getSpciFnrl() {
        return this.spciFnrl;
    }
    
    public void setSpciFnrl(Long spciFnrl) {
        this.spciFnrl = spciFnrl;
    }
    
    public Long getPrvm20be() {
        return this.prvm20be;
    }
    
    public void setPrvm20be(Long prvm20be) {
        this.prvm20be = prvm20be;
    }
    
    public Long getPrvm21af() {
        return this.prvm21af;
    }
    
    public void setPrvm21af(Long prvm21af) {
        this.prvm21af = prvm21af;
    }
    
    public Long getEtchPrep() {
        return this.etchPrep;
    }
    
    public void setEtchPrep(Long etchPrep) {
        this.etchPrep = etchPrep;
    }
    
    public Long getEtcsComp() {
        return this.etcsComp;
    }
    
    public void setEtcsComp(Long etcsComp) {
        this.etcsComp = etcsComp;
    }
    
    public Long getEtwkHsvm() {
        return this.etwkHsvm;
    }
    
    public void setEtwkHsvm(Long etwkHsvm) {
        this.etwkHsvm = etwkHsvm;
    }
    
    public Long getEtwkHsbm() {
        return this.etwkHsbm;
    }
    
    public void setEtwkHsbm(Long etwkHsbm) {
        this.etwkHsbm = etwkHsbm;
    }
    
    public Long getEtwkHlgm() {
        return this.etwkHlgm;
    }
    
    public void setEtwkHlgm(Long etwkHlgm) {
        this.etwkHlgm = etwkHlgm;
    }
    
    public Long getEtwkHbdm() {
        return this.etwkHbdm;
    }
    
    public void setEtwkHbdm(Long etwkHbdm) {
        this.etwkHbdm = etwkHbdm;
    }
    
    public Long getEtctConc() {
        return this.etctConc;
    }
    
    public void setEtctConc(Long etctConc) {
        this.etctConc = etctConc;
    }
    
    public Long getEtgdH09f() {
        return this.etgdH09f;
    }
    
    public void setEtgdH09f(Long etgdH09f) {
        this.etgdH09f = etgdH09f;
    }
    
    public Long getEtgdH13f() {
        return this.etgdH13f;
    }
    
    public void setEtgdH13f(Long etgdH13f) {
        this.etgdH13f = etgdH13f;
    }
    
    public Long getEtgdH14f() {
        return this.etgdH14f;
    }
    
    public void setEtgdH14f(Long etgdH14f) {
        this.etgdH14f = etgdH14f;
    }
    
    public Long getEtclH15f() {
        return this.etclH15f;
    }
    
    public void setEtclH15f(Long etclH15f) {
        this.etclH15f = etclH15f;
    }
    
    public Long getEtgdHdam() {
        return this.etgdHdam;
    }
    
    public void setEtgdHdam(Long etgdHdam) {
        this.etgdHdam = etgdHdam;
    }
    
    public Long getEtctCard() {
        return this.etctCard;
    }
    
    public void setEtctCard(Long etctCard) {
        this.etctCard = etctCard;
    }
    
    public Long getEtchBcbs() {
        return this.etchBcbs;
    }
    
    public void setEtchBcbs(Long etchBcbs) {
        this.etchBcbs = etchBcbs;
    }
    
    public Long getEtchUeam() {
        return this.etchUeam;
    }
    
    public void setEtchUeam(Long etchUeam) {
        this.etchUeam = etchUeam;
    }
    
    public Long getEtchMgvd() {
        return this.etchMgvd;
    }
    
    public void setEtchMgvd(Long etchMgvd) {
        this.etchMgvd = etchMgvd;
    }
    
    public Long getEtchBced() {
        return this.etchBced;
    }
    
    public void setEtchBced(Long etchBced) {
        this.etchBced = etchBced;
    }
    
    public Long getCardEt13() {
        return this.cardEt13;
    }
    
    public void setCardEt13(Long cardEt13) {
        this.cardEt13 = cardEt13;
    }
    
    public Long getCardEt14() {
        return this.cardEt14;
    }
    
    public void setCardEt14(Long cardEt14) {
        this.cardEt14 = cardEt14;
    }
    
    public Long getEtadDd13() {
        return this.etadDd13;
    }
    
    public void setEtadDd13(Long etadDd13) {
        this.etadDd13 = etadDd13;
    }
    
    public Long getEtadD14l() {
        return this.etadD14l;
    }
    
    public void setEtadD14l(Long etadD14l) {
        this.etadD14l = etadD14l;
    }
    
    public Long getEtchBcue() {
        return this.etchBcue;
    }
    
    public void setEtchBcue(Long etchBcue) {
        this.etchBcue = etchBcue;
    }
    
    public Long getEtckUnon() {
        return this.etckUnon;
    }
    
    public void setEtckUnon(Long etckUnon) {
        this.etckUnon = etckUnon;
    }
    
    public Long getEtckUncb() {
        return this.etckUncb;
    }
    
    public void setEtckUncb(Long etckUncb) {
        this.etckUncb = etckUncb;
    }
    
    public Long getEtepHsam() {
        return this.etepHsam;
    }
    
    public void setEtepHsam(Long etepHsam) {
        this.etepHsam = etepHsam;
    }
    
    public Long getEtgdCtra() {
        return this.etgdCtra;
    }
    
    public void setEtgdCtra(Long etgdCtra) {
        this.etgdCtra = etgdCtra;
    }
    
    public Long getEtepSest() {
        return this.etepSest;
    }
    
    public void setEtepSest(Long etepSest) {
        this.etepSest = etepSest;
    }
    
    public Long getEtclHm01() {
        return this.etclHm01;
    }
    
    public void setEtclHm01(Long etclHm01) {
        this.etclHm01 = etclHm01;
    }
    
    public Long getEtclHm02() {
        return this.etclHm02;
    }
    
    public void setEtclHm02(Long etclHm02) {
        this.etclHm02 = etclHm02;
    }
    
    public Long getEtclHm03() {
        return this.etclHm03;
    }
    
    public void setEtclHm03(Long etclHm03) {
        this.etclHm03 = etclHm03;
    }
     
    
    public Long getEtclHmta() {
        return this.etclHmta;
    }
    
    public void setEtclHmta(Long etclHmta) {
        this.etclHmta = etclHmta;
    }
    
    public java.lang.String getEtclEttl() {
        return this.etclEttl;
    }
    
    public void setEtclEttl(java.lang.String etclEttl) {
        this.etclEttl = etclEttl;
    }
    
    public Long getEtclEtam() {
        return this.etclEtam;
    }
    
    public void setEtclEtam(Long etclEtam) {
        this.etclEtam = etclEtam;
    }
    
    public java.lang.String getTaxdWkdt() {
        return this.taxdWkdt;
    }
    
    public void setTaxdWkdt(java.lang.String taxdWkdt) {
        this.taxdWkdt = taxdWkdt;
    }
    
    public java.lang.String getTamaEddt() {
        return this.tamaEddt;
    }
    
    public void setTamaEddt(java.lang.String tamaEddt) {
        this.tamaEddt = tamaEddt;
    }
    
    public java.lang.String getTamaIndt() {
        return this.tamaIndt;
    }
    
    public void setTamaIndt(java.lang.String tamaIndt) {
        this.tamaIndt = tamaIndt;
    }
    
    public java.lang.String getTamaOudt() {
        return this.tamaOudt;
    }
    
    public void setTamaOudt(java.lang.String tamaOudt) {
        this.tamaOudt = tamaOudt;
    }
    
    public java.lang.String getTxlgFrrd() {
        return this.txlgFrrd;
    }
    
    public void setTxlgFrrd(java.lang.String txlgFrrd) {
        this.txlgFrrd = txlgFrrd;
    }
    
    public java.lang.String getTxlgFrid() {
        return this.txlgFrid;
    }
    
    public void setTxlgFrid(java.lang.String txlgFrid) {
        this.txlgFrid = txlgFrid;
    }
    
    public java.lang.String getTxlgWkid() {
        return this.txlgWkid;
    }
    
    public void setTxlgWkid(java.lang.String txlgWkid) {
        this.txlgWkid = txlgWkid;
    }
    
    public java.lang.String getTxlgTxtd() {
        return this.txlgTxtd;
    }
    
    public void setTxlgTxtd(java.lang.String txlgTxtd) {
        this.txlgTxtd = txlgTxtd;
    }
    
    public java.lang.String getTxlgBscd() {
        return this.txlgBscd;
    }
    
    public void setTxlgBscd(java.lang.String txlgBscd) {
        this.txlgBscd = txlgBscd;
    }
    
    public java.lang.String getTxlgBcde() {
        return this.txlgBcde;
    }
    
    public void setTxlgBcde(java.lang.String txlgBcde) {
        this.txlgBcde = txlgBcde;
    }
    
    public Long getTxlgItct() {
        return this.txlgItct;
    }
    
    public void setTxlgItct(Long txlgItct) {
        this.txlgItct = txlgItct;
    }
    
    public Long getTxlgBsta() {
        return this.txlgBsta;
    }
    
    public void setTxlgBsta(Long txlgBsta) {
        this.txlgBsta = txlgBsta;
    }
    
    public Long getTxlgWkta() {
        return this.txlgWkta;
    }
    
    public void setTxlgWkta(Long txlgWkta) {
        this.txlgWkta = txlgWkta;
    }
    
    public Long getTxlgClta() {
        return this.txlgClta;
    }
    
    public void setTxlgClta(Long txlgClta) {
        this.txlgClta = txlgClta;
    }
    
    public Long getTxlgFrta() {
        return this.txlgFrta;
    }
    
    public void setTxlgFrta(Long txlgFrta) {
        this.txlgFrta = txlgFrta;
    }
    
    public Long getTxlgTxty() {
        return this.txlgTxty;
    }
    
    public void setTxlgTxty(Long txlgTxty) {
        this.txlgTxty = txlgTxty;
    }
    
    public Long getTxlgInam() {
        return this.txlgInam;
    }
    
    public void setTxlgInam(Long txlgInam) {
        this.txlgInam = txlgInam;
    }
    
    public Long getTxlgDlam() {
        return this.txlgDlam;
    }
    
    public void setTxlgDlam(Long txlgDlam) {
        this.txlgDlam = txlgDlam;
    }
    
    public Long getTxlgWnam() {
        return this.txlgWnam;
    }
    
    public void setTxlgWnam(Long txlgWnam) {
        this.txlgWnam = txlgWnam;
    }
    
    public java.lang.String getTxlgOtcy() {
        return this.txlgOtcy;
    }
    
    public void setTxlgOtcy(java.lang.String txlgOtcy) {
        this.txlgOtcy = txlgOtcy;
    }
    
    public java.lang.String getTxlgOtdt() {
        return this.txlgOtdt;
    }
    
    public void setTxlgOtdt(java.lang.String txlgOtdt) {
        this.txlgOtdt = txlgOtdt;
    }
    
    public java.lang.String getTxlgApdt() {
        return this.txlgApdt;
    }
    
    public void setTxlgApdt(java.lang.String txlgApdt) {
        this.txlgApdt = txlgApdt;
    }
    
    public java.lang.String getTxlgOuwk() {
        return this.txlgOuwk;
    }
    
    public void setTxlgOuwk(java.lang.String txlgOuwk) {
        this.txlgOuwk = txlgOuwk;
    }
    
    public java.lang.String getTxapStdt() {
        return this.txapStdt;
    }
    
    public void setTxapStdt(java.lang.String txapStdt) {
        this.txapStdt = txapStdt;
    }
    
    public java.lang.String getTxapEddt() {
        return this.txapEddt;
    }
    
    public void setTxapEddt(java.lang.String txapEddt) {
        this.txapEddt = txapEddt;
    }
    
    public java.lang.String getTxapWkdy() {
        return this.txapWkdy;
    }
    
    public void setTxapWkdy(java.lang.String txapWkdy) {
        this.txapWkdy = txapWkdy;
    }
    
    public Long getTaxdUnin() {
        return this.taxdUnin;
    }
    
    public void setTaxdUnin(Long taxdUnin) {
        this.taxdUnin = taxdUnin;
    }
    
    public Long getTaxdLoaa() {
        return this.taxdLoaa;
    }
    
    public void setTaxdLoaa(Long taxdLoaa) {
        this.taxdLoaa = taxdLoaa;
    }
    
    public java.lang.String getAddcNtyn() {
        return this.addcNtyn;
    }
    
    public void setAddcNtyn(java.lang.String addcNtyn) {
        this.addcNtyn = addcNtyn;
    }
    
    public java.lang.String getAddcMdyn() {
        return this.addcMdyn;
    }
    
    public void setAddcMdyn(java.lang.String addcMdyn) {
        this.addcMdyn = addcMdyn;
    }
    
    public java.lang.String getAddcCtyn() {
        return this.addcCtyn;
    }
    
    public void setAddcCtyn(java.lang.String addcCtyn) {
        this.addcCtyn = addcCtyn;
    }
    
    public java.lang.String getAddcPfyn() {
        return this.addcPfyn;
    }
    
    public void setAddcPfyn(java.lang.String addcPfyn) {
        this.addcPfyn = addcPfyn;
    }
    
    public java.lang.String getAddfPvyn() {
        return this.addfPvyn;
    }
    
    public void setAddfPvyn(java.lang.String addfPvyn) {
        this.addfPvyn = addfPvyn;
    }
    
    public java.lang.String getSpciReyn() {
        return this.spciReyn;
    }
    
    public void setSpciReyn(java.lang.String spciReyn) {
        this.spciReyn = spciReyn;
    }
    
    public java.lang.String getTxlgMxtm() {
        return this.txlgMxtm;
    }
    
    public void setTxlgMxtm(java.lang.String txlgMxtm) {
        this.txlgMxtm = txlgMxtm;
    }
    
    public java.lang.String getIncoOudt() {
        return this.incoOudt;
    }
    
    public void setIncoOudt(java.lang.String incoOudt) {
        this.incoOudt = incoOudt;
    }
    
    public java.lang.String getIncoOufg() {
        return this.incoOufg;
    }
    
    public void setIncoOufg(java.lang.String incoOufg) {
        this.incoOufg = incoOufg;
    }
    
    public java.lang.String getJdocFile() {
        return this.jdocFile;
    }
    
    public void setJdocFile(java.lang.String jdocFile) {
        this.jdocFile = jdocFile;
    }
    
    public Long getJrtrAtom() {
        return this.jrtrAtom;
    }
    
    public void setJrtrAtom(Long jrtrAtom) {
        this.jrtrAtom = jrtrAtom;
    }
    
    public Long getJrtrTotr() {
        return this.jrtrTotr;
    }
    
    public void setJrtrTotr(Long jrtrTotr) {
        this.jrtrTotr = jrtrTotr;
    }
    
    public Long getSpciHdtg() {
        return this.spciHdtg;
    }
    
    public void setSpciHdtg(Long spciHdtg) {
        this.spciHdtg = spciHdtg;
    }
    
    public Long getSpciDetg() {
        return this.spciDetg;
    }
    
    public void setSpciDetg(Long spciDetg) {
        this.spciDetg = spciDetg;
    }
    
    public Long getSpciRtto() {
        return this.spciRtto;
    }
    
    public void setSpciRtto(Long spciRtto) {
        this.spciRtto = spciRtto;
    }
    
    public Long getSpciSftg() {
        return this.spciSftg;
    }
    
    public void setSpciSftg(Long spciSftg) {
        this.spciSftg = spciSftg;
    }
    
    public Long getSpci65tg() {
        return this.spci65tg;
    }
    
    public void setSpci65tg(Long spci65tg) {
        this.spci65tg = spci65tg;
    }
    
    public Long getSpciPstg() {
        return this.spciPstg;
    }
    
    public void setSpciPstg(Long spciPstg) {
        this.spciPstg = spciPstg;
    }
    
    public Long getSpciEtcg() {
        return this.spciEtcg;
    }
    
    public void setSpciEtcg(Long spciEtcg) {
        this.spciEtcg = spciEtcg;
    }
    
    public Long getSpedSftr() {
        return this.spedSftr;
    }
    
    public void setSpedSftr(Long spedSftr) {
        this.spedSftr = spedSftr;
    }
    
    public Long getSpedEdtr() {
        return this.spedEdtr;
    }
    
    public void setSpedEdtr(Long spedEdtr) {
        this.spedEdtr = spedEdtr;
    }
    
    public Long getSpedGdtr() {
        return this.spedGdtr;
    }
    
    public void setSpedGdtr(Long spedGdtr) {
        this.spedGdtr = spedGdtr;
    }
    
    public Long getSpedCvtr() {
        return this.spedCvtr;
    }
    
    public void setSpedCvtr(Long spedCvtr) {
        this.spedCvtr = spedCvtr;
    }
    
    public Long getSpciSctr() {
        return this.spciSctr;
    }
    
    public void setSpciSctr(Long spciSctr) {
        this.spciSctr = spciSctr;
    }
    
    public Long getSpciExtg() {
        return this.spciExtg;
    }
    
    public void setSpciExtg(Long spciExtg) {
        this.spciExtg = spciExtg;
    }
    
    public Long getSpciUntg() {
        return this.spciUntg;
    }
    
    public void setSpciUntg(Long spciUntg) {
        this.spciUntg = spciUntg;
    }
    
    public Long getSpciHftg() {
        return this.spciHftg;
    }
    
    public void setSpciHftg(Long spciHftg) {
        this.spciHftg = spciHftg;
    }
    
    public Long getSpciNatg() {
        return this.spciNatg;
    }
    
    public void setSpciNatg(Long spciNatg) {
        this.spciNatg = spciNatg;
    }
    
    public Long getSpciYatg() {
        return this.spciYatg;
    }
    
    public void setSpciYatg(Long spciYatg) {
        this.spciYatg = spciYatg;
    }
    
    public Long getSpciDgam() {
        return this.spciDgam;
    }
    
    public void setSpciDgam(Long spciDgam) {
        this.spciDgam = spciDgam;
    }
    
    public Long getSpciOnon() {
        return this.spciOnon;
    }
    
    public void setSpciOnon(Long spciOnon) {
        this.spciOnon = spciOnon;
    }
    
    public Long getSpciObam() {
        return this.spciObam;
    }
    
    public void setSpciObam(Long spciObam) {
        this.spciObam = spciObam;
    }
    
    public Long getSpciOyam() {
        return this.spciOyam;
    }
    
    public void setSpciOyam(Long spciOyam) {
        this.spciOyam = spciOyam;
    }
    
    public Long getSpciOnam() {
        return this.spciOnam;
    }
    
    public void setSpciOnam(Long spciOnam) {
        this.spciOnam = spciOnam;
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

	public Long getJnatDdct() {
		return jnatDdct;
	}

	public void setJnatDdct(Long jnatDdct) {
		this.jnatDdct = jnatDdct;
	}

	public Long getBnatDdct() {
		return bnatDdct;
	}

	public void setBnatDdct(Long bnatDdct) {
		this.bnatDdct = bnatDdct;
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
