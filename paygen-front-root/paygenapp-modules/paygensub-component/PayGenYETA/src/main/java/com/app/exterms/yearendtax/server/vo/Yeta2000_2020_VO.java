package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;
import java.util.List;

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
public class Yeta2000_2020_VO implements Serializable {
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
    private java.math.BigDecimal edacSeilNum;

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
    private java.lang.String yrtxPrcsYn;

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
    private java.math.BigDecimal baseFmly;

    /** set 추가공제_경로우대_70세이상수 : addrCt70 */
    private java.math.BigDecimal addrCt70;

    /** set 추가공제_장애인수 : addrHdrc */
    private java.math.BigDecimal addrHdrc;

    /** set 추가공제_부녀자수 : addrFdsu */
    private java.math.BigDecimal addrFdsu;

    /** set 추가공제_자녀양육비양육수 : addrClct */
    private java.math.BigDecimal addrClct;

    /** set 추가공제_출산자녀양육수 : addrBhct */
    private java.math.BigDecimal addrBhct;

    /** set 추가공제_한부모수 : pantOnsu */
    private java.math.BigDecimal pantOnsu;

    /** set 추가공제_다자녀인원수 : addrMrct */
    private java.math.BigDecimal addrMrct;

    /** set 종근무지_국민연금보험료 : bnatPsnf */
    private java.math.BigDecimal bnatPsnf;

    /** set 주근무지_국민연금보험료 : jnatPsnf */
    private java.math.BigDecimal jnatPsnf;

    /** set 종근무지_국민연금외교직원연금 : bpssTech */
    private java.math.BigDecimal bpssTech;

    /** set 종근무지_국민연금외공무원연금 : bpssPulc */
    private java.math.BigDecimal bpssPulc;

    /** set 종근무지_국민연금외별정우체국 : bpssFect */
    private java.math.BigDecimal bpssFect;

    /** set 종근무지_국민연금외군인연금 : bpssSold */
    private java.math.BigDecimal bpssSold;

    /** set 주근무지_국민연금외공무원연금 : jpssPulc */
    private java.math.BigDecimal jpssPulc;

    /** set 주근무지_국민연금외군인연금 : jpssSold */
    private java.math.BigDecimal jpssSold;

    /** set 주근무지_국인연금외교직원연금 : jpssTech */
    private java.math.BigDecimal jpssTech;

    /** set 주근무지_국민연금외별정우체국 : jpssFect */
    private java.math.BigDecimal jpssFect;

    /** set 종근무지_종_근로자퇴직보장법 : brtrPsct */
    private java.math.BigDecimal brtrPsct;

    /** set 종근무지_종_과학기술인공제 : brtrCict */
    private java.math.BigDecimal brtrCict;

    /** set 종근무지_연금계좌_연금저축 : brtrAnsv */
    private java.math.BigDecimal brtrAnsv;

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrCict */
    private java.math.BigDecimal jrtrCict;

    /** set 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
    private java.math.BigDecimal jrtrCtar;

    /** set 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
    private java.math.BigDecimal jrtrPsct;

    /** set 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
    private java.math.BigDecimal jrtrPtar;

    /** set 주근무지_연금계좌_연금저축 : jrtrAnsv */
    private java.math.BigDecimal jrtrAnsv;

    /** set 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
    private java.math.BigDecimal jrtrAtar;

    /** set 연금보험료계 : rrptAmnt */
    private java.math.BigDecimal rrptAmnt;

    /** set 특별공제_종건강보험료 : spciBhlh */
    private java.math.BigDecimal spciBhlh;

    /** set 특별공제_주건강보험료 : spciHhlh */
    private java.math.BigDecimal spciHhlh;

    /** set 특별공제_종고용보험료 : spciBepf */
    private java.math.BigDecimal spciBepf;

    /** set 특별공제_주고용보험료 : spciJepf */
    private java.math.BigDecimal spciJepf;

    /** set 특별공제_일반보장성보험료 : spciGurt */
    private java.math.BigDecimal spciGurt;

    /** set 특별공제_장애인전용보험료 : spciHdrc */
    private java.math.BigDecimal spciHdrc;

    /** set 특별공제_보장성보험료공제대상금액 : spciRttg */
    private java.math.BigDecimal spciRttg;

    /** set 특별공제_보험료계 : spciIuam */
    private java.math.BigDecimal spciIuam;

    /** set 특별공제_의료비_본인 : spciSelf */
    private java.math.BigDecimal spciSelf;

    /** set 특별공제_의료비_경로65세이상 : spciAe65 */
    private java.math.BigDecimal spciAe65;

    /** set 특별공제_의료비_장애인 : spciDbps */
    private java.math.BigDecimal spciDbps;

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    private java.math.BigDecimal spciDetc;

    /** set 특별공제_의료비세액공제대상금액 : spciDtar */
    private java.math.BigDecimal spciDtar;

    /** set 특별공제_의료비계 : spciEtam */
    private java.math.BigDecimal spciEtam;

    /** set 특별공제_교육비_본인 : spedSelf */
    private java.math.BigDecimal spedSelf;

    /** set 특별공제_교육비_취학전아동수 : spedEdsu */
    private java.math.BigDecimal spedEdsu;

    /** set 특별공제_교육비_취학전아동 : spedEdam */
    private java.math.BigDecimal spedEdam;

    /** set 특별공제_교육비_초중고자녀수 : spedGdsu */
    private java.math.BigDecimal spedGdsu;

    /** set 특별공제_교육비_초중고 : spedGdam */
    private java.math.BigDecimal spedGdam;

    /** set 특별공제_교육비_대학생수 : spedCvsu */
    private java.math.BigDecimal spedCvsu;

    /** set 특별공제_교육비_대학교 : spedCvam */
    private java.math.BigDecimal spedCvam;

    /** set 특별공제_장애인수 : spciScsu */
    private java.math.BigDecimal spciScsu;

    /** set 특별공제_장애인특수교육비 : spciScam */
    private java.math.BigDecimal spciScam;

    /** set 특별공제_교육비공제대상금액 : spedEtar */
    private java.math.BigDecimal spedEtar;

    /** set 특별공제_교육비계 : siedToam */
    private java.math.BigDecimal siedToam;

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    private java.math.BigDecimal spciRefn;

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    private java.math.BigDecimal spciResf;

    /** set 특별공제_주택자금_월세금액 : spciHtam */
    private java.math.BigDecimal spciHtam;

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    private java.math.BigDecimal spchRefn;

    /** set 특별공제_11장기주택저당차입금15 : spchRe06 */
    private java.math.BigDecimal spchRe06;

    /** set 특별공제_11장기주택저당차입금29 : spchRe10 */
    private java.math.BigDecimal spchRe10;

    /** set 특별공제_11장기주택저당차입금30 : spchRe20 */
    private java.math.BigDecimal spchRe20;

    /** set 특별공제_12장기주택저당차입금_고정 : spchRefx */
    private java.math.BigDecimal spchRefx;

    /** set 특별공제_12장기주택저당차입금_기타 : spchReec */
    private java.math.BigDecimal spchReec;

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
    private java.math.BigDecimal spch15fx;

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
    private java.math.BigDecimal spch15fb;

    /** set 특별공제_15장기주택저당_15기타대출 : spch15ec */
    private java.math.BigDecimal spch15ec;

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
    private java.math.BigDecimal spch10fb;

    /** set 특별공제_15장기주택저당_10기타대출 : spch10ec */
    private java.math.BigDecimal spch10ec;

    /** set 세액공제_기부정치자금금액 : taxdPltc */
    private java.math.BigDecimal taxdPltc;

    /** set 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
    private java.math.BigDecimal taxd10tg;

    /** set 특별공제_기부금_정치 : spciPltc */
    private java.math.BigDecimal spciPltc;

    /** set 특별공제_기부금_정치10초과대상금액 : spciPltg */
    private java.math.BigDecimal spciPltg;

    /** set 특별공제_기부금_법정 : spciFbam */
    private java.math.BigDecimal spciFbam;

    /** set 특별공제_기부금_법정대상금액 : spciFbtg */
    private java.math.BigDecimal spciFbtg;

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    private java.math.BigDecimal spciExam;

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    private java.math.BigDecimal spciUnon;

    /** set 특별공제_기부금_우리사주조합2015이후 : spciHfam */
    private java.math.BigDecimal spciHfam;

    /** set 특별공제_기부금_종교단체 : spciYamt */
    private java.math.BigDecimal spciYamt;

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    private java.math.BigDecimal spciNamt;

    /** set 특별공제_지정기부금대상금액 : spciDgtg */
    private java.math.BigDecimal spciDgtg;

    /** set 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
    private java.math.BigDecimal spciFnrl;

    /** set 개인연금저축불입액_2000년이전 : prvm20be */
    private java.math.BigDecimal prvm20be;

    /** set 개인연금저축불입액_2001년이후_삭제 : prvm21af */
    private java.math.BigDecimal prvm21af;

    /** set 기타공제_소기업공제불입금액 : etchPrep */
    private java.math.BigDecimal etchPrep;

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    private java.math.BigDecimal etcsComp;

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
    private java.math.BigDecimal etwkHsvm;

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
    private java.math.BigDecimal etwkHsbm;

    /** set 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
    private java.math.BigDecimal etwkHlgm;

    /** set 기타공제_주택마련저축소득금액 : etwkHbdm */
    private java.math.BigDecimal etwkHbdm;

    /** set 기타공제_투자조합출자금액_2011이전 : etctConc */
    private java.math.BigDecimal etctConc;

    /** set 기타공제_투자조합출자금액_2012년도 : etgdH09f */
    private java.math.BigDecimal etgdH09f;

    /** set 기타공제_투자조합출자금액_2013년도 : etgdH13f */
    private java.math.BigDecimal etgdH13f;

    /** set 기타공제_투자조합출자금액_2014년도 : etgdH14f */
    private java.math.BigDecimal etgdH14f;

    /** set 기타공제_투자조합출자금액_2015년이후 : etclH15f */
    private java.math.BigDecimal etclH15f;

    /** set 기타공제투자조합출자금액계 : etgdHdam */
    private java.math.BigDecimal etgdHdam;

    /** set 기타공제_신용카드등사용금액 : etctCard */
    private java.math.BigDecimal etctCard;

    /** set 기타공제_직불카드등사용금액 : etchBcbs */
    private java.math.BigDecimal etchBcbs;

    /** set 기타공제_현금영수증사용금액 : etchUeam */
    private java.math.BigDecimal etchUeam;

    /** set 기타공제_전통시장사용분 : etchMgvd */
    private java.math.BigDecimal etchMgvd;

    /** set 기타공제_지로납부_대중교통금액 : etchBced */
    private java.math.BigDecimal etchBced;

    /** set 기타공제_본인신용카드등사용액_2013 : cardEt13 */
    private java.math.BigDecimal cardEt13;

    /** set 기타공제_본인신용카드등사용액_2014 : cardEt14 */
    private java.math.BigDecimal cardEt14;

    /** set 기타공제_본인추가공재율사용액_2013 : etadDd13 */
    private java.math.BigDecimal etadDd13;

    /** set 기타공제_본인추가공제율사용액_2014하 : etadD14l */
    private java.math.BigDecimal etadD14l;

    /** set 기타공제_신용카드등사용공제계 : etchBcue */
    private java.math.BigDecimal etchBcue;

    /** set 기타공제_우리사주출연금액 : etckUnon */
    private java.math.BigDecimal etckUnon;

    /** set 기타공제_우리사주조합기부금2014이전 : etckUncb */
    private java.math.BigDecimal etckUncb;

    /** set 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
    private java.math.BigDecimal etepHsam;

    /** set 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
    private java.math.BigDecimal etgdCtra;

    /** set 기타공제_장기집합투자증권저축금액 : etepSest */
    private java.math.BigDecimal etepSest;

    /** set 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
    private java.math.BigDecimal etclHm01;

    /** set 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
    private java.math.BigDecimal etclHm02;

    /** set 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
    private java.math.BigDecimal etclHm03;

    /** set 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
    private java.math.BigDecimal etclHmta;

    /** set 기타공제_기타제목 : etclEttl */
    private java.lang.String etclEttl;

    /** set 기타공제_기타금액 : etclEtam */
    private java.math.BigDecimal etclEtam;

    /** set 세액공제_외국인_입국목적코드 : taxdIncd */
    private java.lang.String taxdIncd;

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
    private java.math.BigDecimal txlgItct;

    /** set 세액감면_취업청년감면대상총급여액 : txlgBsta */
    private java.math.BigDecimal txlgBsta;

    /** set 세액감면_취업청년감면근로자총급여액 : txlgWkta */
    private java.math.BigDecimal txlgWkta;

    /** set 세액감면_계산감면세액금액 : txlgClta */
    private java.math.BigDecimal txlgClta;

    /** set 세액감면_외국인기술자감면세액 : txlgFrta */
    private java.math.BigDecimal txlgFrta;

    /** set 세액감면_조세조약감면세액 : txlgTxty */
    private java.math.BigDecimal txlgTxty;

    /** set 세액공제_외국납부_국외원천소득금액 : txlgInam */
    private java.math.BigDecimal txlgInam;

    /** set 세액공제_외국납부_외화납세액 : txlgDlam */
    private java.math.BigDecimal txlgDlam;

    /** set 세액공제_외국납부_원화납세액 : txlgWnam */
    private java.math.BigDecimal txlgWnam;

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
    private java.math.BigDecimal taxdUnin;

    /** set 세액공제_주택차입금이자상황금액 : taxdLoaa */
    private java.math.BigDecimal taxdLoaa;

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
    private java.math.BigDecimal jrtrAtom;

    /** set 연금계좌공제대상금액 : jrtrTotr */
    private java.math.BigDecimal jrtrTotr;

    /** set 특별공제_장애인보장성대상금액 : spciHdtg */
    private java.math.BigDecimal spciHdtg;

    /** set 특별공제_보장성보험료대상금액 : spciDetg */
    private java.math.BigDecimal spciDetg;

    /** set 특별공제_보장성보험료계 : spciRtto */
    private java.math.BigDecimal spciRtto;

    /** set 본인의료비공제대상금액 : spciSftg */
    private java.math.BigDecimal spciSftg;

    /** set 65세이상자의료비공제대상금액 : spci65tg */
    private java.math.BigDecimal spci65tg;

    /** set 장애인의료비공제대상금액 : spciPstg */
    private java.math.BigDecimal spciPstg;

    /** set 그밖의의료비공제대상금액 : spciEtcg */
    private java.math.BigDecimal spciEtcg;

    /** set 소득자본인교육비대상금액 : spedSftr */
    private java.math.BigDecimal spedSftr;

    /** set 취학전아동교육비대상금액 : spedEdtr */
    private java.math.BigDecimal spedEdtr;

    /** set 초중고교육비대상금액 : spedGdtr */
    private java.math.BigDecimal spedGdtr;

    /** set 대학생교육비대상금액 : spedCvtr */
    private java.math.BigDecimal spedCvtr;

    /** set 특수교육비공제대상금액 : spciSctr */
    private java.math.BigDecimal spciSctr;

    /** set 특례기부금_공익법인제외대상금액 : spciExtg */
    private java.math.BigDecimal spciExtg;

    /** set 공익법인신탁대상금액 : spciUntg */
    private java.math.BigDecimal spciUntg;

    /** set 우리사주종합기부대상금액 : spciHftg */
    private java.math.BigDecimal spciHftg;

    /** set 종교단체외지정대상금액 : spciNatg */
    private java.math.BigDecimal spciNatg;

    /** set 종교단체지정대상금액 : spciYatg */
    private java.math.BigDecimal spciYatg;

    /** set 기부금합계금액 : spciDgam */
    private java.math.BigDecimal spciDgam;

    /** set 이월특례기부금_공익신탁금액 : spciOnon */
    private java.math.BigDecimal spciOnon;

    /** set 이월법정기부금액 : spciObam */
    private java.math.BigDecimal spciObam;

    /** set 이월종교단체기부금 : spciOyam */
    private java.math.BigDecimal spciOyam;

    /** set 이월종교단체외기부금 : spciOnam */
    private java.math.BigDecimal spciOnam;

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


/** set 기타공제_본인신용카등사용액_2015 : cardEt15 */
private java.math.BigDecimal cardEt15;

/** set 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
private java.math.BigDecimal etadD15h;

/** set 기타공제_본인추가공제율사용액2015하반기 : etadD15l */
private java.math.BigDecimal etadD15l;
 
/** set 난임수술비용 : ctifTram */
private java.math.BigDecimal ctifTram;

/** set 법정기부금2014금액 : spciOb14 */
private java.math.BigDecimal spciOb14;

/** set 종교단체2014금액 : spciOy14 */
private java.math.BigDecimal spciOy14;

/** set 종교단체외2014금액 : spciOn14 */
private java.math.BigDecimal spciOn14;

/** set 법정기부금2014대상금액 : spciFb14 */
private java.math.BigDecimal spciFb14;

/** set 종교단체2014대상금액 : spciYa14 */
private java.math.BigDecimal spciYa14;

/** set 총교단체외2014대상금액 : spciNa14 */
private java.math.BigDecimal spciNa14;

/** set 분납납부금액 : divdPymtAmnt */
private java.math.BigDecimal divdPymtAmnt;

/** set 연말정산분할납부신청여부 : yrenSgyn */
private java.lang.String yrenSgyn;

/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
private java.lang.String addIncmTxApptnRtoCd;

/** set 외국인법인소속파견근로자여부 : frnrRnyn */
private java.lang.String frnrRnyn;

/** set 기타공제_투자조합출자금액_14_벤처 : etgdH14b */
private java.math.BigDecimal etgdH14b;

/** set 기타공제_투자조합출자금액_15_벤처 : etclH15b */
private java.math.BigDecimal etclH15b;

/** set 기타공제_투자조합출자금액_16_조합 : etclH16f */
private java.math.BigDecimal etclH16f;

/** set 기타공제_투자조합출자금액_16_벤처 : etclH16b */
private java.math.BigDecimal etclH16b;

/** set 기타공제_본인추가공제율사용액_2016상 : etadD16l */
private java.math.BigDecimal etadD16l;


/** set 원천징수의무부서코드 : yetaDpcd */
private java.lang.String yetaDpcd;

/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
private java.math.BigDecimal etgdD14b;

/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
private java.math.BigDecimal etgdD15b;

/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
private java.math.BigDecimal etgdD16f;

/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
private java.math.BigDecimal etgdD16b;


/** set 마감여부 : closFlag */
private java.lang.String closFlag;

/** set 마감일자 : closDate */
private java.lang.String closDate;


/** TYP_OCCU_CD */
private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값

/** 사업코드 BUSIN_CD  */
private List<String> businCdArr; 

private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값

/** set A9_사업자등록번호 : busoprRgstnum */
private java.lang.String busoprRgstnum;

/** 부서코드 - DEPT_CD */
private java.lang.String deptCdAuth;

/** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCdAuth;

private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 




/** 부서코드 - DEPT_CD */
private List<String> deptCdArr;

/** set 사용자아이디 : usrId */
private java.lang.String usrId;



	public java.lang.String getUsrId() {
	return usrId;
}

public void setUsrId(java.lang.String usrId) {
	this.usrId = usrId;
}

	public java.lang.String getPayrMangDeptYn() {
	return payrMangDeptYn;
}

public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
	this.payrMangDeptYn = payrMangDeptYn;
}

	public java.lang.String getDeptCdAuth() {
	return deptCdAuth;
}

public void setDeptCdAuth(java.lang.String deptCdAuth) {
	this.deptCdAuth = deptCdAuth;
}

public java.lang.String getDtilOccuInttnCdAuth() {
	return dtilOccuInttnCdAuth;
}

public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
	this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
}

public List<String> getDeptCdArr() {
	return deptCdArr;
}

public void setDeptCdArr(List<String> deptCdArr) {
	this.deptCdArr = deptCdArr;
}

	public java.lang.String getBusoprRgstnum() {
	return busoprRgstnum;
}

public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
	this.busoprRgstnum = busoprRgstnum;
}

	public List<String> getDtilOccuInttnCdArr() {
	return dtilOccuInttnCdArr;
}

public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
	this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
}

	public List<String> getTypOccuCdArr() {
	return typOccuCdArr;
}

public void setTypOccuCdArr(List<String> typOccuCdArr) {
	this.typOccuCdArr = typOccuCdArr;
}

public List<String> getBusinCdArr() {
	return businCdArr;
}

public void setBusinCdArr(List<String> businCdArr) {
	this.businCdArr = businCdArr;
}

	public java.lang.String getClosFlag() {
	return closFlag;
}

public void setClosFlag(java.lang.String closFlag) {
	this.closFlag = closFlag;
}

public java.lang.String getClosDate() {
	return closDate;
}

public void setClosDate(java.lang.String closDate) {
	this.closDate = closDate;
}

	/**
 * Comment : 
 * @fn java.math.BigDecimal getEtgdD14b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD14b get
 */
public java.math.BigDecimal getEtgdD14b() {
	return etgdD14b;
}

/**
 * Comment : 
 *@fn void setEtgdD14b(java.math.BigDecimal etgdD14b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD14b the etgdD14b to set
 */
public void setEtgdD14b(java.math.BigDecimal etgdD14b) {
	this.etgdD14b = etgdD14b;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtgdD15b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD15b get
 */
public java.math.BigDecimal getEtgdD15b() {
	return etgdD15b;
}

/**
 * Comment : 
 *@fn void setEtgdD15b(java.math.BigDecimal etgdD15b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD15b the etgdD15b to set
 */
public void setEtgdD15b(java.math.BigDecimal etgdD15b) {
	this.etgdD15b = etgdD15b;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtgdD16f()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD16f get
 */
public java.math.BigDecimal getEtgdD16f() {
	return etgdD16f;
}

/**
 * Comment : 
 *@fn void setEtgdD16f(java.math.BigDecimal etgdD16f)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD16f the etgdD16f to set
 */
public void setEtgdD16f(java.math.BigDecimal etgdD16f) {
	this.etgdD16f = etgdD16f;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtgdD16b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD16b get
 */
public java.math.BigDecimal getEtgdD16b() {
	return etgdD16b;
}

/**
 * Comment : 
 *@fn void setEtgdD16b(java.math.BigDecimal etgdD16b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD16b the etgdD16b to set
 */
public void setEtgdD16b(java.math.BigDecimal etgdD16b) {
	this.etgdD16b = etgdD16b;
}

	/**
 * Comment : 
 * @fn java.lang.String getYetaDpcd()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the yetaDpcd get
 */
public java.lang.String getYetaDpcd() {
	return yetaDpcd;
}

/**
 * Comment : 
 *@fn void setYetaDpcd(java.lang.String yetaDpcd)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param yetaDpcd the yetaDpcd to set
 */
public void setYetaDpcd(java.lang.String yetaDpcd) {
	this.yetaDpcd = yetaDpcd;
}

	/**
 * Comment : 
 * @fn java.math.BigDecimal getCtifTram()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the ctifTram get
 */
public java.math.BigDecimal getCtifTram() {
	return ctifTram;
}

/**
 * Comment : 
 *@fn void setCtifTram(java.math.BigDecimal ctifTram)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param ctifTram the ctifTram to set
 */
public void setCtifTram(java.math.BigDecimal ctifTram) {
	this.ctifTram = ctifTram;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciOb14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciOb14 get
 */
public java.math.BigDecimal getSpciOb14() {
	return spciOb14;
}

/**
 * Comment : 
 *@fn void setSpciOb14(java.math.BigDecimal spciOb14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciOb14 the spciOb14 to set
 */
public void setSpciOb14(java.math.BigDecimal spciOb14) {
	this.spciOb14 = spciOb14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciOy14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciOy14 get
 */
public java.math.BigDecimal getSpciOy14() {
	return spciOy14;
}

/**
 * Comment : 
 *@fn void setSpciOy14(java.math.BigDecimal spciOy14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciOy14 the spciOy14 to set
 */
public void setSpciOy14(java.math.BigDecimal spciOy14) {
	this.spciOy14 = spciOy14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciOn14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciOn14 get
 */
public java.math.BigDecimal getSpciOn14() {
	return spciOn14;
}

/**
 * Comment : 
 *@fn void setSpciOn14(java.math.BigDecimal spciOn14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciOn14 the spciOn14 to set
 */
public void setSpciOn14(java.math.BigDecimal spciOn14) {
	this.spciOn14 = spciOn14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciFb14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciFb14 get
 */
public java.math.BigDecimal getSpciFb14() {
	return spciFb14;
}

/**
 * Comment : 
 *@fn void setSpciFb14(java.math.BigDecimal spciFb14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciFb14 the spciFb14 to set
 */
public void setSpciFb14(java.math.BigDecimal spciFb14) {
	this.spciFb14 = spciFb14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciYa14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciYa14 get
 */
public java.math.BigDecimal getSpciYa14() {
	return spciYa14;
}

/**
 * Comment : 
 *@fn void setSpciYa14(java.math.BigDecimal spciYa14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciYa14 the spciYa14 to set
 */
public void setSpciYa14(java.math.BigDecimal spciYa14) {
	this.spciYa14 = spciYa14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getSpciNa14()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the spciNa14 get
 */
public java.math.BigDecimal getSpciNa14() {
	return spciNa14;
}

/**
 * Comment : 
 *@fn void setSpciNa14(java.math.BigDecimal spciNa14)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param spciNa14 the spciNa14 to set
 */
public void setSpciNa14(java.math.BigDecimal spciNa14) {
	this.spciNa14 = spciNa14;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getDivdPymtAmnt()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the divdPymtAmnt get
 */
public java.math.BigDecimal getDivdPymtAmnt() {
	return divdPymtAmnt;
}

/**
 * Comment : 
 *@fn void setDivdPymtAmnt(java.math.BigDecimal divdPymtAmnt)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param divdPymtAmnt the divdPymtAmnt to set
 */
public void setDivdPymtAmnt(java.math.BigDecimal divdPymtAmnt) {
	this.divdPymtAmnt = divdPymtAmnt;
}

/**
 * Comment : 
 * @fn java.lang.String getYrenSgyn()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the yrenSgyn get
 */
public java.lang.String getYrenSgyn() {
	return yrenSgyn;
}

/**
 * Comment : 
 *@fn void setYrenSgyn(java.lang.String yrenSgyn)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param yrenSgyn the yrenSgyn to set
 */
public void setYrenSgyn(java.lang.String yrenSgyn) {
	this.yrenSgyn = yrenSgyn;
}

/**
 * Comment : 
 * @fn java.lang.String getAddIncmTxApptnRtoCd()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the addIncmTxApptnRtoCd get
 */
public java.lang.String getAddIncmTxApptnRtoCd() {
	return addIncmTxApptnRtoCd;
}

/**
 * Comment : 
 *@fn void setAddIncmTxApptnRtoCd(java.lang.String addIncmTxApptnRtoCd)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param addIncmTxApptnRtoCd the addIncmTxApptnRtoCd to set
 */
public void setAddIncmTxApptnRtoCd(java.lang.String addIncmTxApptnRtoCd) {
	this.addIncmTxApptnRtoCd = addIncmTxApptnRtoCd;
}

/**
 * Comment : 
 * @fn java.lang.String getFrnrRnyn()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the frnrRnyn get
 */
public java.lang.String getFrnrRnyn() {
	return frnrRnyn;
}

/**
 * Comment : 
 *@fn void setFrnrRnyn(java.lang.String frnrRnyn)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param frnrRnyn the frnrRnyn to set
 */
public void setFrnrRnyn(java.lang.String frnrRnyn) {
	this.frnrRnyn = frnrRnyn;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtgdH14b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdH14b get
 */
public java.math.BigDecimal getEtgdH14b() {
	return etgdH14b;
}

/**
 * Comment : 
 *@fn void setEtgdH14b(java.math.BigDecimal etgdH14b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdH14b the etgdH14b to set
 */
public void setEtgdH14b(java.math.BigDecimal etgdH14b) {
	this.etgdH14b = etgdH14b;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtclH15b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etclH15b get
 */
public java.math.BigDecimal getEtclH15b() {
	return etclH15b;
}

/**
 * Comment : 
 *@fn void setEtclH15b(java.math.BigDecimal etclH15b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etclH15b the etclH15b to set
 */
public void setEtclH15b(java.math.BigDecimal etclH15b) {
	this.etclH15b = etclH15b;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtclH16f()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etclH16f get
 */
public java.math.BigDecimal getEtclH16f() {
	return etclH16f;
}

/**
 * Comment : 
 *@fn void setEtclH16f(java.math.BigDecimal etclH16f)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etclH16f the etclH16f to set
 */
public void setEtclH16f(java.math.BigDecimal etclH16f) {
	this.etclH16f = etclH16f;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtclH16b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etclH16b get
 */
public java.math.BigDecimal getEtclH16b() {
	return etclH16b;
}

/**
 * Comment : 
 *@fn void setEtclH16b(java.math.BigDecimal etclH16b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etclH16b the etclH16b to set
 */
public void setEtclH16b(java.math.BigDecimal etclH16b) {
	this.etclH16b = etclH16b;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtadD16l()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etadD16l get
 */
public java.math.BigDecimal getEtadD16l() {
	return etadD16l;
}

/**
 * Comment : 
 *@fn void setEtadD16l(java.math.BigDecimal etadD16l)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etadD16l the etadD16l to set
 */
public void setEtadD16l(java.math.BigDecimal etadD16l) {
	this.etadD16l = etadD16l;
}

	/**
 * Comment : 
 * @fn java.math.BigDecimal getCardEt15()
 * @brief date:2016 Jan 29, 2016 user:leeheuisung
 * @return the cardEt15 get
 */
public java.math.BigDecimal getCardEt15() {
	return cardEt15;
}

/**
 * Comment : 
 *@fn void setCardEt15(java.math.BigDecimal cardEt15)
 *@brief date:2016 Jan 29, 2016 user:leeheuisung
 *@param cardEt15 the cardEt15 to set
 */
public void setCardEt15(java.math.BigDecimal cardEt15) {
	this.cardEt15 = cardEt15;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtadD15h()
 * @brief date:2016 Jan 29, 2016 user:leeheuisung
 * @return the etadD15h get
 */
public java.math.BigDecimal getEtadD15h() {
	return etadD15h;
}

/**
 * Comment : 
 *@fn void setEtadD15h(java.math.BigDecimal etadD15h)
 *@brief date:2016 Jan 29, 2016 user:leeheuisung
 *@param etadD15h the etadD15h to set
 */
public void setEtadD15h(java.math.BigDecimal etadD15h) {
	this.etadD15h = etadD15h;
}

/**
 * Comment : 
 * @fn java.math.BigDecimal getEtadD15l()
 * @brief date:2016 Jan 29, 2016 user:leeheuisung
 * @return the etadD15l get
 */
public java.math.BigDecimal getEtadD15l() {
	return etadD15l;
}

/**
 * Comment : 
 *@fn void setEtadD15l(java.math.BigDecimal etadD15l)
 *@brief date:2016 Jan 29, 2016 user:leeheuisung
 *@param etadD15l the etadD15l to set
 */
public void setEtadD15l(java.math.BigDecimal etadD15l) {
	this.etadD15l = etadD15l;
}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getEdacSeilNum()
	 * @brief date:2016 Jan 20, 2016 user:leeheuisung
	 * @return the edacSeilNum get
	 */
	public java.math.BigDecimal getEdacSeilNum() {
		return edacSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEdacSeilNum(java.math.BigDecimal edacSeilNum)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param edacSeilNum the edacSeilNum to set
	 */
	public void setEdacSeilNum(java.math.BigDecimal edacSeilNum) {
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
	public java.lang.String getYrtxPrcsYn() {
		return yrtxPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxPrcsYn(java.lang.String yrtxPrcsYn)
	 *@brief date:2016 Jan 20, 2016 user:leeheuisung
	 *@param yrtxPrcsYn the yrtxPrcsYn to set
	 */
	public void setYrtxPrcsYn(java.lang.String yrtxPrcsYn) {
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getEdacRvyy() {
		return edacRvyy;
	}

	public void setEdacRvyy(java.lang.String edacRvyy) {
		this.edacRvyy = edacRvyy;
	}

	public java.lang.String getSettGbcd() {
		return settGbcd;
	}

	public void setSettGbcd(java.lang.String settGbcd) {
		this.settGbcd = settGbcd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
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

	public java.lang.String getFrstEmymtDt() {
		return frstEmymtDt;
	}

	public void setFrstEmymtDt(java.lang.String frstEmymtDt) {
		this.frstEmymtDt = frstEmymtDt;
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

	public java.lang.String getHdofcDivCd() {
		return hdofcDivCd;
	}

	public void setHdofcDivCd(java.lang.String hdofcDivCd) {
		this.hdofcDivCd = hdofcDivCd;
	}

	public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	public java.lang.String getGnanSgtf() {
		return gnanSgtf;
	}

	public void setGnanSgtf(java.lang.String gnanSgtf) {
		this.gnanSgtf = gnanSgtf;
	}

	public java.lang.String getFrnrYeno() {
		return frnrYeno;
	}

	public void setFrnrYeno(java.lang.String frnrYeno) {
		this.frnrYeno = frnrYeno;
	}

	public java.lang.String getReymStdt() {
		return reymStdt;
	}

	public void setReymStdt(java.lang.String reymStdt) {
		this.reymStdt = reymStdt;
	}

	public java.lang.String getReymEddt() {
		return reymEddt;
	}

	public void setReymEddt(java.lang.String reymEddt) {
		this.reymEddt = reymEddt;
	}

	public java.lang.String getRutrEddt() {
		return rutrEddt;
	}

	public void setRutrEddt(java.lang.String rutrEddt) {
		this.rutrEddt = rutrEddt;
	}

	public java.lang.String getRutrStdt() {
		return rutrStdt;
	}

	public void setRutrStdt(java.lang.String rutrStdt) {
		this.rutrStdt = rutrStdt;
	}

	public java.lang.String getResdFlag() {
		return resdFlag;
	}

	public void setResdFlag(java.lang.String resdFlag) {
		this.resdFlag = resdFlag;
	}

	public java.lang.String getNatnGbcd() {
		return natnGbcd;
	}

	public void setNatnGbcd(java.lang.String natnGbcd) {
		this.natnGbcd = natnGbcd;
	}

	public java.lang.String getNatnName() {
		return natnName;
	}

	public void setNatnName(java.lang.String natnName) {
		this.natnName = natnName;
	}

	public java.lang.String getRedtGbcd() {
		return redtGbcd;
	}

	public void setRedtGbcd(java.lang.String redtGbcd) {
		this.redtGbcd = redtGbcd;
	}

	public java.lang.String getRedtName() {
		return redtName;
	}

	public void setRedtName(java.lang.String redtName) {
		this.redtName = redtName;
	}

	public java.lang.String getHumnCgue() {
		return humnCgue;
	}

	public void setHumnCgue(java.lang.String humnCgue) {
		this.humnCgue = humnCgue;
	}

	public java.lang.String getFrnrSgyn() {
		return frnrSgyn;
	}

	public void setFrnrSgyn(java.lang.String frnrSgyn) {
		this.frnrSgyn = frnrSgyn;
	}

	public java.lang.String getBaseWiyn() {
		return baseWiyn;
	}

	public void setBaseWiyn(java.lang.String baseWiyn) {
		this.baseWiyn = baseWiyn;
	}

	public java.math.BigDecimal getBaseFmly() {
		return baseFmly;
	}

	public void setBaseFmly(java.math.BigDecimal baseFmly) {
		this.baseFmly = baseFmly;
	}

	public java.math.BigDecimal getAddrCt70() {
		return addrCt70;
	}

	public void setAddrCt70(java.math.BigDecimal addrCt70) {
		this.addrCt70 = addrCt70;
	}

	public java.math.BigDecimal getAddrHdrc() {
		return addrHdrc;
	}

	public void setAddrHdrc(java.math.BigDecimal addrHdrc) {
		this.addrHdrc = addrHdrc;
	}

	public java.math.BigDecimal getAddrFdsu() {
		return addrFdsu;
	}

	public void setAddrFdsu(java.math.BigDecimal addrFdsu) {
		this.addrFdsu = addrFdsu;
	}

	public java.math.BigDecimal getAddrClct() {
		return addrClct;
	}

	public void setAddrClct(java.math.BigDecimal addrClct) {
		this.addrClct = addrClct;
	}

	public java.math.BigDecimal getAddrBhct() {
		return addrBhct;
	}

	public void setAddrBhct(java.math.BigDecimal addrBhct) {
		this.addrBhct = addrBhct;
	}

	public java.math.BigDecimal getPantOnsu() {
		return pantOnsu;
	}

	public void setPantOnsu(java.math.BigDecimal pantOnsu) {
		this.pantOnsu = pantOnsu;
	}

	public java.math.BigDecimal getAddrMrct() {
		return addrMrct;
	}

	public void setAddrMrct(java.math.BigDecimal addrMrct) {
		this.addrMrct = addrMrct;
	}

	public java.math.BigDecimal getBnatPsnf() {
		return bnatPsnf;
	}

	public void setBnatPsnf(java.math.BigDecimal bnatPsnf) {
		this.bnatPsnf = bnatPsnf;
	}

	public java.math.BigDecimal getJnatPsnf() {
		return jnatPsnf;
	}

	public void setJnatPsnf(java.math.BigDecimal jnatPsnf) {
		this.jnatPsnf = jnatPsnf;
	}

	public java.math.BigDecimal getBpssTech() {
		return bpssTech;
	}

	public void setBpssTech(java.math.BigDecimal bpssTech) {
		this.bpssTech = bpssTech;
	}

	public java.math.BigDecimal getBpssPulc() {
		return bpssPulc;
	}

	public void setBpssPulc(java.math.BigDecimal bpssPulc) {
		this.bpssPulc = bpssPulc;
	}

	public java.math.BigDecimal getBpssFect() {
		return bpssFect;
	}

	public void setBpssFect(java.math.BigDecimal bpssFect) {
		this.bpssFect = bpssFect;
	}

	public java.math.BigDecimal getBpssSold() {
		return bpssSold;
	}

	public void setBpssSold(java.math.BigDecimal bpssSold) {
		this.bpssSold = bpssSold;
	}

	public java.math.BigDecimal getJpssPulc() {
		return jpssPulc;
	}

	public void setJpssPulc(java.math.BigDecimal jpssPulc) {
		this.jpssPulc = jpssPulc;
	}

	public java.math.BigDecimal getJpssSold() {
		return jpssSold;
	}

	public void setJpssSold(java.math.BigDecimal jpssSold) {
		this.jpssSold = jpssSold;
	}

	public java.math.BigDecimal getJpssTech() {
		return jpssTech;
	}

	public void setJpssTech(java.math.BigDecimal jpssTech) {
		this.jpssTech = jpssTech;
	}

	public java.math.BigDecimal getJpssFect() {
		return jpssFect;
	}

	public void setJpssFect(java.math.BigDecimal jpssFect) {
		this.jpssFect = jpssFect;
	}

	public java.math.BigDecimal getBrtrPsct() {
		return brtrPsct;
	}

	public void setBrtrPsct(java.math.BigDecimal brtrPsct) {
		this.brtrPsct = brtrPsct;
	}

	public java.math.BigDecimal getBrtrCict() {
		return brtrCict;
	}

	public void setBrtrCict(java.math.BigDecimal brtrCict) {
		this.brtrCict = brtrCict;
	}

	public java.math.BigDecimal getBrtrAnsv() {
		return brtrAnsv;
	}

	public void setBrtrAnsv(java.math.BigDecimal brtrAnsv) {
		this.brtrAnsv = brtrAnsv;
	}

	public java.math.BigDecimal getJrtrCict() {
		return jrtrCict;
	}

	public void setJrtrCict(java.math.BigDecimal jrtrCict) {
		this.jrtrCict = jrtrCict;
	}

	public java.math.BigDecimal getJrtrCtar() {
		return jrtrCtar;
	}

	public void setJrtrCtar(java.math.BigDecimal jrtrCtar) {
		this.jrtrCtar = jrtrCtar;
	}

	public java.math.BigDecimal getJrtrPsct() {
		return jrtrPsct;
	}

	public void setJrtrPsct(java.math.BigDecimal jrtrPsct) {
		this.jrtrPsct = jrtrPsct;
	}

	public java.math.BigDecimal getJrtrPtar() {
		return jrtrPtar;
	}

	public void setJrtrPtar(java.math.BigDecimal jrtrPtar) {
		this.jrtrPtar = jrtrPtar;
	}

	public java.math.BigDecimal getJrtrAnsv() {
		return jrtrAnsv;
	}

	public void setJrtrAnsv(java.math.BigDecimal jrtrAnsv) {
		this.jrtrAnsv = jrtrAnsv;
	}

	public java.math.BigDecimal getJrtrAtar() {
		return jrtrAtar;
	}

	public void setJrtrAtar(java.math.BigDecimal jrtrAtar) {
		this.jrtrAtar = jrtrAtar;
	}

	public java.math.BigDecimal getRrptAmnt() {
		return rrptAmnt;
	}

	public void setRrptAmnt(java.math.BigDecimal rrptAmnt) {
		this.rrptAmnt = rrptAmnt;
	}

	public java.math.BigDecimal getSpciBhlh() {
		return spciBhlh;
	}

	public void setSpciBhlh(java.math.BigDecimal spciBhlh) {
		this.spciBhlh = spciBhlh;
	}

	public java.math.BigDecimal getSpciHhlh() {
		return spciHhlh;
	}

	public void setSpciHhlh(java.math.BigDecimal spciHhlh) {
		this.spciHhlh = spciHhlh;
	}

	public java.math.BigDecimal getSpciBepf() {
		return spciBepf;
	}

	public void setSpciBepf(java.math.BigDecimal spciBepf) {
		this.spciBepf = spciBepf;
	}

	public java.math.BigDecimal getSpciJepf() {
		return spciJepf;
	}

	public void setSpciJepf(java.math.BigDecimal spciJepf) {
		this.spciJepf = spciJepf;
	}

	public java.math.BigDecimal getSpciGurt() {
		return spciGurt;
	}

	public void setSpciGurt(java.math.BigDecimal spciGurt) {
		this.spciGurt = spciGurt;
	}

	public java.math.BigDecimal getSpciHdrc() {
		return spciHdrc;
	}

	public void setSpciHdrc(java.math.BigDecimal spciHdrc) {
		this.spciHdrc = spciHdrc;
	}

	public java.math.BigDecimal getSpciRttg() {
		return spciRttg;
	}

	public void setSpciRttg(java.math.BigDecimal spciRttg) {
		this.spciRttg = spciRttg;
	}

	public java.math.BigDecimal getSpciIuam() {
		return spciIuam;
	}

	public void setSpciIuam(java.math.BigDecimal spciIuam) {
		this.spciIuam = spciIuam;
	}

	public java.math.BigDecimal getSpciSelf() {
		return spciSelf;
	}

	public void setSpciSelf(java.math.BigDecimal spciSelf) {
		this.spciSelf = spciSelf;
	}

	public java.math.BigDecimal getSpciAe65() {
		return spciAe65;
	}

	public void setSpciAe65(java.math.BigDecimal spciAe65) {
		this.spciAe65 = spciAe65;
	}

	public java.math.BigDecimal getSpciDbps() {
		return spciDbps;
	}

	public void setSpciDbps(java.math.BigDecimal spciDbps) {
		this.spciDbps = spciDbps;
	}

	public java.math.BigDecimal getSpciDetc() {
		return spciDetc;
	}

	public void setSpciDetc(java.math.BigDecimal spciDetc) {
		this.spciDetc = spciDetc;
	}

	public java.math.BigDecimal getSpciDtar() {
		return spciDtar;
	}

	public void setSpciDtar(java.math.BigDecimal spciDtar) {
		this.spciDtar = spciDtar;
	}

	public java.math.BigDecimal getSpciEtam() {
		return spciEtam;
	}

	public void setSpciEtam(java.math.BigDecimal spciEtam) {
		this.spciEtam = spciEtam;
	}

	public java.math.BigDecimal getSpedSelf() {
		return spedSelf;
	}

	public void setSpedSelf(java.math.BigDecimal spedSelf) {
		this.spedSelf = spedSelf;
	}

	public java.math.BigDecimal getSpedEdsu() {
		return spedEdsu;
	}

	public void setSpedEdsu(java.math.BigDecimal spedEdsu) {
		this.spedEdsu = spedEdsu;
	}

	public java.math.BigDecimal getSpedEdam() {
		return spedEdam;
	}

	public void setSpedEdam(java.math.BigDecimal spedEdam) {
		this.spedEdam = spedEdam;
	}

	public java.math.BigDecimal getSpedGdsu() {
		return spedGdsu;
	}

	public void setSpedGdsu(java.math.BigDecimal spedGdsu) {
		this.spedGdsu = spedGdsu;
	}

	public java.math.BigDecimal getSpedGdam() {
		return spedGdam;
	}

	public void setSpedGdam(java.math.BigDecimal spedGdam) {
		this.spedGdam = spedGdam;
	}

	public java.math.BigDecimal getSpedCvsu() {
		return spedCvsu;
	}

	public void setSpedCvsu(java.math.BigDecimal spedCvsu) {
		this.spedCvsu = spedCvsu;
	}

	public java.math.BigDecimal getSpedCvam() {
		return spedCvam;
	}

	public void setSpedCvam(java.math.BigDecimal spedCvam) {
		this.spedCvam = spedCvam;
	}

	public java.math.BigDecimal getSpciScsu() {
		return spciScsu;
	}

	public void setSpciScsu(java.math.BigDecimal spciScsu) {
		this.spciScsu = spciScsu;
	}

	public java.math.BigDecimal getSpciScam() {
		return spciScam;
	}

	public void setSpciScam(java.math.BigDecimal spciScam) {
		this.spciScam = spciScam;
	}

	public java.math.BigDecimal getSpedEtar() {
		return spedEtar;
	}

	public void setSpedEtar(java.math.BigDecimal spedEtar) {
		this.spedEtar = spedEtar;
	}

	public java.math.BigDecimal getSiedToam() {
		return siedToam;
	}

	public void setSiedToam(java.math.BigDecimal siedToam) {
		this.siedToam = siedToam;
	}

	public java.math.BigDecimal getSpciRefn() {
		return spciRefn;
	}

	public void setSpciRefn(java.math.BigDecimal spciRefn) {
		this.spciRefn = spciRefn;
	}

	public java.math.BigDecimal getSpciResf() {
		return spciResf;
	}

	public void setSpciResf(java.math.BigDecimal spciResf) {
		this.spciResf = spciResf;
	}

	public java.math.BigDecimal getSpciHtam() {
		return spciHtam;
	}

	public void setSpciHtam(java.math.BigDecimal spciHtam) {
		this.spciHtam = spciHtam;
	}

	public java.math.BigDecimal getSpchRefn() {
		return spchRefn;
	}

	public void setSpchRefn(java.math.BigDecimal spchRefn) {
		this.spchRefn = spchRefn;
	}

	public java.math.BigDecimal getSpchRe06() {
		return spchRe06;
	}

	public void setSpchRe06(java.math.BigDecimal spchRe06) {
		this.spchRe06 = spchRe06;
	}

	public java.math.BigDecimal getSpchRe10() {
		return spchRe10;
	}

	public void setSpchRe10(java.math.BigDecimal spchRe10) {
		this.spchRe10 = spchRe10;
	}

	public java.math.BigDecimal getSpchRe20() {
		return spchRe20;
	}

	public void setSpchRe20(java.math.BigDecimal spchRe20) {
		this.spchRe20 = spchRe20;
	}

	public java.math.BigDecimal getSpchRefx() {
		return spchRefx;
	}

	public void setSpchRefx(java.math.BigDecimal spchRefx) {
		this.spchRefx = spchRefx;
	}

	public java.math.BigDecimal getSpchReec() {
		return spchReec;
	}

	public void setSpchReec(java.math.BigDecimal spchReec) {
		this.spchReec = spchReec;
	}

	public java.math.BigDecimal getSpch15fx() {
		return spch15fx;
	}

	public void setSpch15fx(java.math.BigDecimal spch15fx) {
		this.spch15fx = spch15fx;
	}

	public java.math.BigDecimal getSpch15fb() {
		return spch15fb;
	}

	public void setSpch15fb(java.math.BigDecimal spch15fb) {
		this.spch15fb = spch15fb;
	}

	public java.math.BigDecimal getSpch15ec() {
		return spch15ec;
	}

	public void setSpch15ec(java.math.BigDecimal spch15ec) {
		this.spch15ec = spch15ec;
	}

	public java.math.BigDecimal getSpch10fb() {
		return spch10fb;
	}

	public void setSpch10fb(java.math.BigDecimal spch10fb) {
		this.spch10fb = spch10fb;
	}

	public java.math.BigDecimal getSpch10ec() {
		return spch10ec;
	}

	public void setSpch10ec(java.math.BigDecimal spch10ec) {
		this.spch10ec = spch10ec;
	}

	public java.math.BigDecimal getTaxdPltc() {
		return taxdPltc;
	}

	public void setTaxdPltc(java.math.BigDecimal taxdPltc) {
		this.taxdPltc = taxdPltc;
	}

	public java.math.BigDecimal getTaxd10tg() {
		return taxd10tg;
	}

	public void setTaxd10tg(java.math.BigDecimal taxd10tg) {
		this.taxd10tg = taxd10tg;
	}

	public java.math.BigDecimal getSpciPltc() {
		return spciPltc;
	}

	public void setSpciPltc(java.math.BigDecimal spciPltc) {
		this.spciPltc = spciPltc;
	}

	public java.math.BigDecimal getSpciPltg() {
		return spciPltg;
	}

	public void setSpciPltg(java.math.BigDecimal spciPltg) {
		this.spciPltg = spciPltg;
	}

	public java.math.BigDecimal getSpciFbam() {
		return spciFbam;
	}

	public void setSpciFbam(java.math.BigDecimal spciFbam) {
		this.spciFbam = spciFbam;
	}

	public java.math.BigDecimal getSpciFbtg() {
		return spciFbtg;
	}

	public void setSpciFbtg(java.math.BigDecimal spciFbtg) {
		this.spciFbtg = spciFbtg;
	}

	public java.math.BigDecimal getSpciExam() {
		return spciExam;
	}

	public void setSpciExam(java.math.BigDecimal spciExam) {
		this.spciExam = spciExam;
	}

	public java.math.BigDecimal getSpciUnon() {
		return spciUnon;
	}

	public void setSpciUnon(java.math.BigDecimal spciUnon) {
		this.spciUnon = spciUnon;
	}

	public java.math.BigDecimal getSpciHfam() {
		return spciHfam;
	}

	public void setSpciHfam(java.math.BigDecimal spciHfam) {
		this.spciHfam = spciHfam;
	}

	public java.math.BigDecimal getSpciYamt() {
		return spciYamt;
	}

	public void setSpciYamt(java.math.BigDecimal spciYamt) {
		this.spciYamt = spciYamt;
	}

	public java.math.BigDecimal getSpciNamt() {
		return spciNamt;
	}

	public void setSpciNamt(java.math.BigDecimal spciNamt) {
		this.spciNamt = spciNamt;
	}

	public java.math.BigDecimal getSpciDgtg() {
		return spciDgtg;
	}

	public void setSpciDgtg(java.math.BigDecimal spciDgtg) {
		this.spciDgtg = spciDgtg;
	}

	public java.math.BigDecimal getSpciFnrl() {
		return spciFnrl;
	}

	public void setSpciFnrl(java.math.BigDecimal spciFnrl) {
		this.spciFnrl = spciFnrl;
	}

	public java.math.BigDecimal getPrvm20be() {
		return prvm20be;
	}

	public void setPrvm20be(java.math.BigDecimal prvm20be) {
		this.prvm20be = prvm20be;
	}

	public java.math.BigDecimal getPrvm21af() {
		return prvm21af;
	}

	public void setPrvm21af(java.math.BigDecimal prvm21af) {
		this.prvm21af = prvm21af;
	}

	public java.math.BigDecimal getEtchPrep() {
		return etchPrep;
	}

	public void setEtchPrep(java.math.BigDecimal etchPrep) {
		this.etchPrep = etchPrep;
	}

	public java.math.BigDecimal getEtcsComp() {
		return etcsComp;
	}

	public void setEtcsComp(java.math.BigDecimal etcsComp) {
		this.etcsComp = etcsComp;
	}

	public java.math.BigDecimal getEtwkHsvm() {
		return etwkHsvm;
	}

	public void setEtwkHsvm(java.math.BigDecimal etwkHsvm) {
		this.etwkHsvm = etwkHsvm;
	}

	public java.math.BigDecimal getEtwkHsbm() {
		return etwkHsbm;
	}

	public void setEtwkHsbm(java.math.BigDecimal etwkHsbm) {
		this.etwkHsbm = etwkHsbm;
	}

	public java.math.BigDecimal getEtwkHlgm() {
		return etwkHlgm;
	}

	public void setEtwkHlgm(java.math.BigDecimal etwkHlgm) {
		this.etwkHlgm = etwkHlgm;
	}

	public java.math.BigDecimal getEtwkHbdm() {
		return etwkHbdm;
	}

	public void setEtwkHbdm(java.math.BigDecimal etwkHbdm) {
		this.etwkHbdm = etwkHbdm;
	}

	public java.math.BigDecimal getEtctConc() {
		return etctConc;
	}

	public void setEtctConc(java.math.BigDecimal etctConc) {
		this.etctConc = etctConc;
	}

	public java.math.BigDecimal getEtgdH09f() {
		return etgdH09f;
	}

	public void setEtgdH09f(java.math.BigDecimal etgdH09f) {
		this.etgdH09f = etgdH09f;
	}

	public java.math.BigDecimal getEtgdH13f() {
		return etgdH13f;
	}

	public void setEtgdH13f(java.math.BigDecimal etgdH13f) {
		this.etgdH13f = etgdH13f;
	}

	public java.math.BigDecimal getEtgdH14f() {
		return etgdH14f;
	}

	public void setEtgdH14f(java.math.BigDecimal etgdH14f) {
		this.etgdH14f = etgdH14f;
	}

	public java.math.BigDecimal getEtclH15f() {
		return etclH15f;
	}

	public void setEtclH15f(java.math.BigDecimal etclH15f) {
		this.etclH15f = etclH15f;
	}

	public java.math.BigDecimal getEtgdHdam() {
		return etgdHdam;
	}

	public void setEtgdHdam(java.math.BigDecimal etgdHdam) {
		this.etgdHdam = etgdHdam;
	}

	public java.math.BigDecimal getEtctCard() {
		return etctCard;
	}

	public void setEtctCard(java.math.BigDecimal etctCard) {
		this.etctCard = etctCard;
	}

	public java.math.BigDecimal getEtchBcbs() {
		return etchBcbs;
	}

	public void setEtchBcbs(java.math.BigDecimal etchBcbs) {
		this.etchBcbs = etchBcbs;
	}

	public java.math.BigDecimal getEtchUeam() {
		return etchUeam;
	}

	public void setEtchUeam(java.math.BigDecimal etchUeam) {
		this.etchUeam = etchUeam;
	}

	public java.math.BigDecimal getEtchMgvd() {
		return etchMgvd;
	}

	public void setEtchMgvd(java.math.BigDecimal etchMgvd) {
		this.etchMgvd = etchMgvd;
	}

	public java.math.BigDecimal getEtchBced() {
		return etchBced;
	}

	public void setEtchBced(java.math.BigDecimal etchBced) {
		this.etchBced = etchBced;
	}

	public java.math.BigDecimal getCardEt13() {
		return cardEt13;
	}

	public void setCardEt13(java.math.BigDecimal cardEt13) {
		this.cardEt13 = cardEt13;
	}

	public java.math.BigDecimal getCardEt14() {
		return cardEt14;
	}

	public void setCardEt14(java.math.BigDecimal cardEt14) {
		this.cardEt14 = cardEt14;
	}

	public java.math.BigDecimal getEtadDd13() {
		return etadDd13;
	}

	public void setEtadDd13(java.math.BigDecimal etadDd13) {
		this.etadDd13 = etadDd13;
	}

	public java.math.BigDecimal getEtadD14l() {
		return etadD14l;
	}

	public void setEtadD14l(java.math.BigDecimal etadD14l) {
		this.etadD14l = etadD14l;
	}

	public java.math.BigDecimal getEtchBcue() {
		return etchBcue;
	}

	public void setEtchBcue(java.math.BigDecimal etchBcue) {
		this.etchBcue = etchBcue;
	}

	public java.math.BigDecimal getEtckUnon() {
		return etckUnon;
	}

	public void setEtckUnon(java.math.BigDecimal etckUnon) {
		this.etckUnon = etckUnon;
	}

	public java.math.BigDecimal getEtckUncb() {
		return etckUncb;
	}

	public void setEtckUncb(java.math.BigDecimal etckUncb) {
		this.etckUncb = etckUncb;
	}

	public java.math.BigDecimal getEtepHsam() {
		return etepHsam;
	}

	public void setEtepHsam(java.math.BigDecimal etepHsam) {
		this.etepHsam = etepHsam;
	}

	public java.math.BigDecimal getEtgdCtra() {
		return etgdCtra;
	}

	public void setEtgdCtra(java.math.BigDecimal etgdCtra) {
		this.etgdCtra = etgdCtra;
	}

	public java.math.BigDecimal getEtepSest() {
		return etepSest;
	}

	public void setEtepSest(java.math.BigDecimal etepSest) {
		this.etepSest = etepSest;
	}

	public java.math.BigDecimal getEtclHm01() {
		return etclHm01;
	}

	public void setEtclHm01(java.math.BigDecimal etclHm01) {
		this.etclHm01 = etclHm01;
	}

	public java.math.BigDecimal getEtclHm02() {
		return etclHm02;
	}

	public void setEtclHm02(java.math.BigDecimal etclHm02) {
		this.etclHm02 = etclHm02;
	}

	public java.math.BigDecimal getEtclHm03() {
		return etclHm03;
	}

	public void setEtclHm03(java.math.BigDecimal etclHm03) {
		this.etclHm03 = etclHm03;
	}

	public java.math.BigDecimal getEtclHmta() {
		return etclHmta;
	}

	public void setEtclHmta(java.math.BigDecimal etclHmta) {
		this.etclHmta = etclHmta;
	}

	public java.lang.String getEtclEttl() {
		return etclEttl;
	}

	public void setEtclEttl(java.lang.String etclEttl) {
		this.etclEttl = etclEttl;
	}

	public java.math.BigDecimal getEtclEtam() {
		return etclEtam;
	}

	public void setEtclEtam(java.math.BigDecimal etclEtam) {
		this.etclEtam = etclEtam;
	}

	 

	/**
	 * Comment : 
	 * @fn java.lang.String getTaxdIncd()
	 * @brief date:2016 Jan 31, 2016 user:leeheuisung
	 * @return the taxdIncd get
	 */
	public java.lang.String getTaxdIncd() {
		return taxdIncd;
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

	public java.lang.String getTaxdWkdt() {
		return taxdWkdt;
	}

	public void setTaxdWkdt(java.lang.String taxdWkdt) {
		this.taxdWkdt = taxdWkdt;
	}

	public java.lang.String getTamaEddt() {
		return tamaEddt;
	}

	public void setTamaEddt(java.lang.String tamaEddt) {
		this.tamaEddt = tamaEddt;
	}

	public java.lang.String getTamaIndt() {
		return tamaIndt;
	}

	public void setTamaIndt(java.lang.String tamaIndt) {
		this.tamaIndt = tamaIndt;
	}

	public java.lang.String getTamaOudt() {
		return tamaOudt;
	}

	public void setTamaOudt(java.lang.String tamaOudt) {
		this.tamaOudt = tamaOudt;
	}

	public java.lang.String getTxlgFrrd() {
		return txlgFrrd;
	}

	public void setTxlgFrrd(java.lang.String txlgFrrd) {
		this.txlgFrrd = txlgFrrd;
	}

	public java.lang.String getTxlgFrid() {
		return txlgFrid;
	}

	public void setTxlgFrid(java.lang.String txlgFrid) {
		this.txlgFrid = txlgFrid;
	}

	public java.lang.String getTxlgWkid() {
		return txlgWkid;
	}

	public void setTxlgWkid(java.lang.String txlgWkid) {
		this.txlgWkid = txlgWkid;
	}

	public java.lang.String getTxlgTxtd() {
		return txlgTxtd;
	}

	public void setTxlgTxtd(java.lang.String txlgTxtd) {
		this.txlgTxtd = txlgTxtd;
	}

	public java.lang.String getTxlgBscd() {
		return txlgBscd;
	}

	public void setTxlgBscd(java.lang.String txlgBscd) {
		this.txlgBscd = txlgBscd;
	}

	public java.lang.String getTxlgBcde() {
		return txlgBcde;
	}

	public void setTxlgBcde(java.lang.String txlgBcde) {
		this.txlgBcde = txlgBcde;
	}

	public java.math.BigDecimal getTxlgItct() {
		return txlgItct;
	}

	public void setTxlgItct(java.math.BigDecimal txlgItct) {
		this.txlgItct = txlgItct;
	}

	public java.math.BigDecimal getTxlgBsta() {
		return txlgBsta;
	}

	public void setTxlgBsta(java.math.BigDecimal txlgBsta) {
		this.txlgBsta = txlgBsta;
	}

	public java.math.BigDecimal getTxlgWkta() {
		return txlgWkta;
	}

	public void setTxlgWkta(java.math.BigDecimal txlgWkta) {
		this.txlgWkta = txlgWkta;
	}

	public java.math.BigDecimal getTxlgClta() {
		return txlgClta;
	}

	public void setTxlgClta(java.math.BigDecimal txlgClta) {
		this.txlgClta = txlgClta;
	}

	public java.math.BigDecimal getTxlgFrta() {
		return txlgFrta;
	}

	public void setTxlgFrta(java.math.BigDecimal txlgFrta) {
		this.txlgFrta = txlgFrta;
	}

	public java.math.BigDecimal getTxlgTxty() {
		return txlgTxty;
	}

	public void setTxlgTxty(java.math.BigDecimal txlgTxty) {
		this.txlgTxty = txlgTxty;
	}

	public java.math.BigDecimal getTxlgInam() {
		return txlgInam;
	}

	public void setTxlgInam(java.math.BigDecimal txlgInam) {
		this.txlgInam = txlgInam;
	}

	public java.math.BigDecimal getTxlgDlam() {
		return txlgDlam;
	}

	public void setTxlgDlam(java.math.BigDecimal txlgDlam) {
		this.txlgDlam = txlgDlam;
	}

	public java.math.BigDecimal getTxlgWnam() {
		return txlgWnam;
	}

	public void setTxlgWnam(java.math.BigDecimal txlgWnam) {
		this.txlgWnam = txlgWnam;
	}

	public java.lang.String getTxlgOtcy() {
		return txlgOtcy;
	}

	public void setTxlgOtcy(java.lang.String txlgOtcy) {
		this.txlgOtcy = txlgOtcy;
	}

	public java.lang.String getTxlgOtdt() {
		return txlgOtdt;
	}

	public void setTxlgOtdt(java.lang.String txlgOtdt) {
		this.txlgOtdt = txlgOtdt;
	}

	public java.lang.String getTxlgApdt() {
		return txlgApdt;
	}

	public void setTxlgApdt(java.lang.String txlgApdt) {
		this.txlgApdt = txlgApdt;
	}

	public java.lang.String getTxlgOuwk() {
		return txlgOuwk;
	}

	public void setTxlgOuwk(java.lang.String txlgOuwk) {
		this.txlgOuwk = txlgOuwk;
	}

	public java.lang.String getTxapStdt() {
		return txapStdt;
	}

	public void setTxapStdt(java.lang.String txapStdt) {
		this.txapStdt = txapStdt;
	}

	public java.lang.String getTxapEddt() {
		return txapEddt;
	}

	public void setTxapEddt(java.lang.String txapEddt) {
		this.txapEddt = txapEddt;
	}

	public java.lang.String getTxapWkdy() {
		return txapWkdy;
	}

	public void setTxapWkdy(java.lang.String txapWkdy) {
		this.txapWkdy = txapWkdy;
	}

	public java.math.BigDecimal getTaxdUnin() {
		return taxdUnin;
	}

	public void setTaxdUnin(java.math.BigDecimal taxdUnin) {
		this.taxdUnin = taxdUnin;
	}

	public java.math.BigDecimal getTaxdLoaa() {
		return taxdLoaa;
	}

	public void setTaxdLoaa(java.math.BigDecimal taxdLoaa) {
		this.taxdLoaa = taxdLoaa;
	}

	public java.lang.String getAddcNtyn() {
		return addcNtyn;
	}

	public void setAddcNtyn(java.lang.String addcNtyn) {
		this.addcNtyn = addcNtyn;
	}

	public java.lang.String getAddcMdyn() {
		return addcMdyn;
	}

	public void setAddcMdyn(java.lang.String addcMdyn) {
		this.addcMdyn = addcMdyn;
	}

	public java.lang.String getAddcCtyn() {
		return addcCtyn;
	}

	public void setAddcCtyn(java.lang.String addcCtyn) {
		this.addcCtyn = addcCtyn;
	}

	public java.lang.String getAddcPfyn() {
		return addcPfyn;
	}

	public void setAddcPfyn(java.lang.String addcPfyn) {
		this.addcPfyn = addcPfyn;
	}

	public java.lang.String getAddfPvyn() {
		return addfPvyn;
	}

	public void setAddfPvyn(java.lang.String addfPvyn) {
		this.addfPvyn = addfPvyn;
	}

	public java.lang.String getSpciReyn() {
		return spciReyn;
	}

	public void setSpciReyn(java.lang.String spciReyn) {
		this.spciReyn = spciReyn;
	}

	public java.lang.String getTxlgMxtm() {
		return txlgMxtm;
	}

	public void setTxlgMxtm(java.lang.String txlgMxtm) {
		this.txlgMxtm = txlgMxtm;
	}

	public java.lang.String getIncoOudt() {
		return incoOudt;
	}

	public void setIncoOudt(java.lang.String incoOudt) {
		this.incoOudt = incoOudt;
	}

	public java.lang.String getIncoOufg() {
		return incoOufg;
	}

	public void setIncoOufg(java.lang.String incoOufg) {
		this.incoOufg = incoOufg;
	}

	public java.lang.String getJdocFile() {
		return jdocFile;
	}

	public void setJdocFile(java.lang.String jdocFile) {
		this.jdocFile = jdocFile;
	}

	public java.math.BigDecimal getJrtrAtom() {
		return jrtrAtom;
	}

	public void setJrtrAtom(java.math.BigDecimal jrtrAtom) {
		this.jrtrAtom = jrtrAtom;
	}

	public java.math.BigDecimal getJrtrTotr() {
		return jrtrTotr;
	}

	public void setJrtrTotr(java.math.BigDecimal jrtrTotr) {
		this.jrtrTotr = jrtrTotr;
	}

	public java.math.BigDecimal getSpciHdtg() {
		return spciHdtg;
	}

	public void setSpciHdtg(java.math.BigDecimal spciHdtg) {
		this.spciHdtg = spciHdtg;
	}

	public java.math.BigDecimal getSpciDetg() {
		return spciDetg;
	}

	public void setSpciDetg(java.math.BigDecimal spciDetg) {
		this.spciDetg = spciDetg;
	}

	public java.math.BigDecimal getSpciRtto() {
		return spciRtto;
	}

	public void setSpciRtto(java.math.BigDecimal spciRtto) {
		this.spciRtto = spciRtto;
	}

	public java.math.BigDecimal getSpciSftg() {
		return spciSftg;
	}

	public void setSpciSftg(java.math.BigDecimal spciSftg) {
		this.spciSftg = spciSftg;
	}

	public java.math.BigDecimal getSpci65tg() {
		return spci65tg;
	}

	public void setSpci65tg(java.math.BigDecimal spci65tg) {
		this.spci65tg = spci65tg;
	}

	public java.math.BigDecimal getSpciPstg() {
		return spciPstg;
	}

	public void setSpciPstg(java.math.BigDecimal spciPstg) {
		this.spciPstg = spciPstg;
	}

	public java.math.BigDecimal getSpciEtcg() {
		return spciEtcg;
	}

	public void setSpciEtcg(java.math.BigDecimal spciEtcg) {
		this.spciEtcg = spciEtcg;
	}

	public java.math.BigDecimal getSpedSftr() {
		return spedSftr;
	}

	public void setSpedSftr(java.math.BigDecimal spedSftr) {
		this.spedSftr = spedSftr;
	}

	public java.math.BigDecimal getSpedEdtr() {
		return spedEdtr;
	}

	public void setSpedEdtr(java.math.BigDecimal spedEdtr) {
		this.spedEdtr = spedEdtr;
	}

	public java.math.BigDecimal getSpedGdtr() {
		return spedGdtr;
	}

	public void setSpedGdtr(java.math.BigDecimal spedGdtr) {
		this.spedGdtr = spedGdtr;
	}

	public java.math.BigDecimal getSpedCvtr() {
		return spedCvtr;
	}

	public void setSpedCvtr(java.math.BigDecimal spedCvtr) {
		this.spedCvtr = spedCvtr;
	}

	public java.math.BigDecimal getSpciSctr() {
		return spciSctr;
	}

	public void setSpciSctr(java.math.BigDecimal spciSctr) {
		this.spciSctr = spciSctr;
	}

	public java.math.BigDecimal getSpciExtg() {
		return spciExtg;
	}

	public void setSpciExtg(java.math.BigDecimal spciExtg) {
		this.spciExtg = spciExtg;
	}

	public java.math.BigDecimal getSpciUntg() {
		return spciUntg;
	}

	public void setSpciUntg(java.math.BigDecimal spciUntg) {
		this.spciUntg = spciUntg;
	}

	public java.math.BigDecimal getSpciHftg() {
		return spciHftg;
	}

	public void setSpciHftg(java.math.BigDecimal spciHftg) {
		this.spciHftg = spciHftg;
	}

	public java.math.BigDecimal getSpciNatg() {
		return spciNatg;
	}

	public void setSpciNatg(java.math.BigDecimal spciNatg) {
		this.spciNatg = spciNatg;
	}

	public java.math.BigDecimal getSpciYatg() {
		return spciYatg;
	}

	public void setSpciYatg(java.math.BigDecimal spciYatg) {
		this.spciYatg = spciYatg;
	}

	public java.math.BigDecimal getSpciDgam() {
		return spciDgam;
	}

	public void setSpciDgam(java.math.BigDecimal spciDgam) {
		this.spciDgam = spciDgam;
	}

	public java.math.BigDecimal getSpciOnon() {
		return spciOnon;
	}

	public void setSpciOnon(java.math.BigDecimal spciOnon) {
		this.spciOnon = spciOnon;
	}

	public java.math.BigDecimal getSpciObam() {
		return spciObam;
	}

	public void setSpciObam(java.math.BigDecimal spciObam) {
		this.spciObam = spciObam;
	}

	public java.math.BigDecimal getSpciOyam() {
		return spciOyam;
	}

	public void setSpciOyam(java.math.BigDecimal spciOyam) {
		this.spciOyam = spciOyam;
	}

	public java.math.BigDecimal getSpciOnam() {
		return spciOnam;
	}

	public void setSpciOnam(java.math.BigDecimal spciOnam) {
		this.spciOnam = spciOnam;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
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
