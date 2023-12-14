package com.app.exterms.yearendtax.client.dto.yeta2016;

import java.io.Serializable;

/**
 * @Class Name : Yeta3000VO.java
 * @Description : Yeta3000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye16Ta3000DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 종전근무지수 : befoScnt */
    private Long befoScnt;

    /** set 주근무지_급여총액 : payrTamt */
    private Long payrTamt;

    /** set 주근무지_상여총액 : bonsToam */
    private Long bonsToam;

    /** set 주근무지_인정상여총액 : dtmnBsam */
    private Long dtmnBsam;

    /** set 주근무지_주식행사이익 : stckPrft */
    private Long stckPrft;

    /** set 주근무지총급여액 : currTots */
    private Long currTots;

    /** set 비과세_자가운전보조금액_del : taxmSfam */
    private Long taxmSfam;

    /** set 비과세_급양비금액_del : taxmEtam */
    private Long taxmEtam;

    /** set 비과세_보육수당_del : taxmBoin */
    private Long taxmBoin;

    /** set 비과세_외국인소득금액_del : txecAmnt */
    private Long txecAmnt;

    /** set 총급여_현_전 : totlSala */
    private Long totlSala;

    /** set 근로소득공제 : wkerDdct */
    private Long wkerDdct;

    /** set 근로소득금액 : wkerAmnt */
    private Long wkerAmnt;

    /** set 기본공제_본인 : baseSelf */
    private Long baseSelf;

    /** set 기본공제_배우자 : baseWife */
    private Long baseWife;

    /** set 기본공제_부양가족 : baseFyam */
    private Long baseFyam;

    /** set 추가공제_장애인 : addrHdam */
    private Long addrHdam;

    /** set 추가공제_경로우대70 : addrRpt70 */
    private Long addrRpt70;

    /** set 추가공제_부녀자 : addrFame */
    private Long addrFame;

    /** set 추가공제_자녀양육비 : addrChld */
    private Long addrChld;

    /** set 추가공제_출산자녀양육비 : addrBrth */
    private Long addrBrth;

    /** set 추가공제_한부모공제금액 : pantOnam */
    private Long pantOnam;

    /** set 추가공제_다자녀 : addrMcam */
    private Long addrMcam;

    /** set 종근무지_국민연금보험료공제 : bnatDdct */
    private Long bnatDdct;

    /** set 주근무지_국민연금보험료공제 : jnatDdct */
    private Long jnatDdct;

    /** set 종근무지_별정우체국연금보험료공제 : bpssDdct */
    private Long bpssDdct;

    /** set 종근무지_국민연금외군인연금공제 : bpssHsol */
    private Long bpssHsol;

    /** set 종근무지_국민연금외교직원연금공제 : bpssHtec */
    private Long bpssHtec;

    /** set 종근무지_국민연금외공무원연금공제 : bpssHpul */
    private Long bpssHpul;

    /** set 주근무지_별정우체국연금보험료공제 : jpssDdct */
    private Long jpssDdct;

    /** set 주근무지_국민연금외군인연금공제 : jpssHsol */
    private Long jpssHsol;

    /** set 주근무지_국민연금외교직원연금공제 : jpssHtec */
    private Long jpssHtec;

    /** set 주근무지_공무원연금보험료공제 : jpssHpul */
    private Long jpssHpul;

    /** set 종근무지_퇴직연금과학기술인공제 : brtrHict */
    private Long brtrHict;

    /** set 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
    private Long brtrPsrn;

    /** set 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
    private Long brtrHnsv;

    /** set 주근무지_퇴직연금과학기술인공제 : jrtrHict */
    private Long jrtrHict;

    /** set 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
    private Long jrtrPsrn;

    /** set 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
    private Long jrtrHnsv;

    /** set 연금보험료공제계 : rrptYnam */
    private Long rrptYnam;

    /** set 특별공제_종건강보험료 : spciBhth */
    private Long spciBhth;

    /** set 특별공제_주건강보험료 : spciJhth */
    private Long spciJhth;

    /** set 특별공제_종고용보험료 : spciBepf */
    private Long spciBepf;

    /** set 특별공제_주고용보험료 : spciJepf */
    private Long spciJepf;

    /** set 특별공제_일반보장성보험료 : spciGurt */
    private Long spciGurt;

    /** set 특별공제_장애인보장성보험료 : spciHdrc */
    private Long spciHdrc;

    /** set 특별공제_보장성보혐료세액공제금액 : spciRtde */
    private Long spciRtde;

    /** set 특별공제_보험료계 : spciHrto */
    private Long spciHrto;

    /** set 특별공제_의료비_본인 : spciSelf */
    private Long spciSelf;

    /** set 특별공제_의료비_경로65세이상 : spciHe65 */
    private Long spciHe65;

    /** set 특별공제_의료비_장애인 : spciHbps */
    private Long spciHbps;

    /** set 특별공제_의료비_기타공제대상자 : spciDetc */
    private Long spciDetc;

    /** set 특별공제_의료비세액공제액 : spciTxcr */
    private Long spciTxcr;

    /** set 특별공제_의료비계 : spciMeto */
    private Long spciMeto;

    /** set 특별공제_교육비_본인 : spedSelf */
    private Long spedSelf;

    /** set 특별공제_교육비_취학전아동 : spedGrde */
    private Long spedGrde;

    /** set 특별공제_교육비_초중고 : spedGdto */
    private Long spedGdto;

    /** set 특별공제_교육비_대학교 : spedCldv */
    private Long spedCldv;

    /** set 특별공제_장애인특수교육비 : spciSpec */
    private Long spciSpec;

    /** set 특별공제_교육비세액공제금액 : spedTxcr */
    private Long spedTxcr;

    /** set 특별공제_교육비계 : spedToam */
    private Long spedToam;

    /** set 특별공제_차입금원리금상환액_대출기관 : spciRefn */
    private Long spciRefn;

    /** set 특별공제_차입금원리금상환액_거주자 : spciResf */
    private Long spciResf;

    /** set 특별공제_월세세액공제대상금액 : spciTgrt */
    private Long spciTgrt;

    /** set 특별공제_주택자금월세공제액 : spciRtam */
    private Long spciRtam;

    /** set 특별공제_장기주택이자상환액 : spchRefn */
    private Long spchRefn;

    /** set 특별공제_11장기주택저당차입금15 : spchRe15 */
    private Long spchRe15;

    /** set 특별공제_11장기주택저당차입금29 : spchRe29 */
    private Long spchRe29;

    /** set 특별공제_11장기주택저당차입금30 : spchRe30 */
    private Long spchRe30;

    /** set 특별공제_12장기주택저당차입금_고정 : spciRefx */
    private Long spciRefx;

    /** set 특별공제_12장기주택저당차입금_기타 : spciReec */
    private Long spciReec;

    /** set 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
    private Long spci15fx;

    /** set 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
    private Long spci15fb;

    /** set 특별공제_15장기주택저당_15기타대출 : spci15ec */
    private Long spci15ec;

    /** set 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
    private Long spci10fb;

    /** set 특별공제_15장기주택저당_10기타대출 : spci10ec */
    private Long spci10ec;

    /** set 특별공제_주택자금공제액계 : spchReto */
    private Long spchReto;

    /** set 세액공제_기부정치자금 : taxdPltc */
    private Long taxdPltc;

    /** set 특별공제_기부금_정치 : spciPltc */
    private Long spciPltc;

    /** set 특별공제_기부금_법정 : spciFbam */
    private Long spciFbam;

    /** set 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
    private Long spciExam;

    /** set 특별공제_기부금_공익법인신탁특례 : spciUnon */
    private Long spciUnon;

    /** set 특별공제_기부금_우리사주조합2015이후 : spciRfam */
    private Long spciRfam;

    /** set 특별공제_기부금_종교단체 : spciYamt */
    private Long spciYamt;

    /** set 특별공제_기부금_종교단체외 : spciNamt */
    private Long spciNamt;

    /** set 특별공제_지정기부금세액공제금액 : spciDgcr */
    private Long spciDgcr;

    /** set 특별공제_기부금공제액계 : spciSsum */
    private Long spciSsum;

    /** set 특별공제_표준공제 : spciDdct */
    private Long spciDdct;

    /** set 차감소득금액 : subtEram */
    private Long subtEram;

    /** set 개인연금저축불입액_2000년이전 : etcpPsnv */
    private Long etcpPsnv;

    /** set 개인연금저축불입액_2001이후_삭제 : etcpNsav */
    private Long etcpNsav;

    /** set 연금저축공제액계 : prcmToam */
    private Long prcmToam;

    /** set 기타공제_소기업공제불입금 : etchPrep */
    private Long etchPrep;

    /** set 기타공제_주택마련저축_청약저축 : etcsComp */
    private Long etcsComp;

    /** set 기타공제_주택마련저축_주택청약종합저축 : etwkSbam */
    private Long etwkSbam;

    /** set 기타공제_주택마련저축_근로자주택마련저축 : etwkSvam */
    private Long etwkSvam;

    /** set 기타공제_주택마련저축_장기주택마련저축 : etwkLgam */
    private Long etwkLgam;

    /** set 기타공제_주택마련저축소득공제계 : etwkBdam */
    private Long etwkBdam;

    /** set 기타공제_투자조합출자소득공제_2011이전 : etctConc */
    private Long etctConc;

    /** set 기타공제_투자조합출자소득공제_2012년도 : etgd09af */
 //   private Long etgd09af;

    /** set 기타공제_투자조합출자소득공제_2013년도 : etgdH13h */
  //  private Long etgdH13h;

    /** set 기타공제_투자조합출자소득공제_2014년이후 : etgdD14f */
    private Long etgdD14f;

    /** set 기타공제_투자조합출자공제액계 : etgdDdam */
    private Long etgdDdam;

    /** set 기타공제_신용카드등사용액소득공제 : etccCard */
    private Long etccCard;

    /** set 기타공제_우리사주출연금공제 : etckUnon */
    private Long etckUnon;

    /** set 기타공제_우리사주조합기부금공제2014이전 : etckUncr */
    private Long etckUncr;

    /** set 기타공제_고용유지중소기업근로자임금삭감공제액 : etepMsam */
    private Long etepMsam;

    /** set 기타공제_목돈안드는전세이자상환소득공제액 : etgdHtra */
    private Long etgdHtra;

    /** set 기타공제_장기집합투자증권저축공제액 : etepSecr */
    private Long etepSecr;

    /** set 기타공제_장기주식형저축_1년차공제_삭제 : etclTo01 */
    private Long etclTo01;

    /** set 기타공제_장기주식형저축_2년차공제_삭제 : etclTo02 */
    private Long etclTo02;

    /** set 기타공제_장기주식형저축_3년차공제_삭제 : etclTo03 */
    private Long etclTo03;

    /** set 기타공제_장기주식형저축소득공제_삭제 : etclHmto */
    private Long etclHmto;

    /** set 기타공제_공제계 : etcdTsum */
//    private Long etcdTsum;

    /** set 특별공제_종합한도초과금액 : spchExli */
    private Long spchExli;

    /** set 종합소득과세표준 : stndIncm */
    private Long stndIncm;

    /** set 산출세액 : prddTaxn */
    private Long prddTaxn;

    /** set 세액감면_소득세법 : taxdIcax */
    private Long taxdIcax;

    /** set 세액감면_조세특례법 : taxdSpct */
    private Long taxdSpct;

    /** set 세액감면_조세특례법제30조 : txlgCl30 */
    private Long txlgCl30;

    /** set 세액감면_조세조약 : txlgHxtt */
    private Long txlgHxtt;

    /** set 세액감면_감면세액계 : taxdTsum */
    private Long taxdTsum;

    /** set 세액공제_근로소득세액공제 : taxdWken */
    private Long taxdWken;

    /** set 세액공제_납세조합공제 : taxdUnin */
    private Long taxdUnin;

    /** set 세액공제_주택차입금 : taxdLoan */
    private Long taxdLoan;

    /** set 세액공제_외국납부 : taxdPaid */
    private Long taxdPaid;

    /** set 세액공제_외국인감면세액 : taxdRedu */
    private Long taxdRedu;

    /** set 세액공제_자녀세액공제금액 : addrMccr */
    private Long addrMccr;

    /** set 특별세액공제계 : spciDcto */
    private Long spciDcto;

    /** set 세액공제_공제계 : taxdCsum */
    private Long taxdCsum;

    /** set 결정세액_소득세 : dcsnIncm */
    private Long dcsnIncm;

    /** set 결정세액_주민세_지방소득세 : dcsnInhb */
    private Long dcsnInhb;

    /** set 결정세액_농특세 : dcsnFafv */
    private Long dcsnFafv;

    /** set 기납부세액_소득세 : alryPinx */
    private Long alryPinx;

    /** set 기납부세액_주민세_지방소득세 : alryPhbx */
    private Long alryPhbx;

    /** set 기납부세액_농특세 : alryYvtx */
    private Long alryYvtx;

    /** set 이전근무지_총급여 : dcsnTots */
    private Long dcsnTots;

    /** set 이전근무지_소득세 : dcsnItax */
    private Long dcsnItax;

    /** set 이전근무지_주민세_지방소득세 : dcsnBtax */
    private Long dcsnBtax;

    /** set 이전근무지_농특세 : fafvTaxi */
    private Long fafvTaxi;

    /** set 차감징수_소득세 : subtEtax */
    private Long subtEtax;

    /** set 차감징수_주민세_지방소득세 : subtInhb */
    private Long subtInhb;

    /** set 차감징수_농특세 : subtFafv */
    private Long subtFafv;

    /** set 차감징수_세액계 : subtAmsu */
    private Long subtAmsu;

    /** set 연금계좌세액공제계 : jrtrHnto */
    private Long jrtrHnto;

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


/** set null : tempPrddTaxn */
private Long tempPrddTaxn;

/** set 기타공제_투자조합출자소득공제_2014_벤처 : etgdD14b */
private Long etgdD14b;

/** set 기타공제_투자조합출자소득공제_2015_벤처 : etgdD15b */
private Long etgdD15b;

/** set 기타공제_투자조합출자소득공제_2016_조합 : etgdD16f */
private Long etgdD16f;

/** set 기타공제_투자조합출자소득공제_2016_벤처 : etgdD16b */
private Long etgdD16b;

    
    /**
 * Comment : 
 * @fn Long getTempPrddTaxn()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the tempPrddTaxn get
 */
public Long getTempPrddTaxn() {
	return tempPrddTaxn;
}

/**
 * Comment : 
 *@fn void setTempPrddTaxn(Long tempPrddTaxn)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param tempPrddTaxn the tempPrddTaxn to set
 */
public void setTempPrddTaxn(Long tempPrddTaxn) {
	this.tempPrddTaxn = tempPrddTaxn;
}

/**
 * Comment : 
 * @fn Long getEtgdD14b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD14b get
 */
public Long getEtgdD14b() {
	return etgdD14b;
}

/**
 * Comment : 
 *@fn void setEtgdD14b(Long etgdD14b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD14b the etgdD14b to set
 */
public void setEtgdD14b(Long etgdD14b) {
	this.etgdD14b = etgdD14b;
}

/**
 * Comment : 
 * @fn Long getEtgdD15b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD15b get
 */
public Long getEtgdD15b() {
	return etgdD15b;
}

/**
 * Comment : 
 *@fn void setEtgdD15b(Long etgdD15b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD15b the etgdD15b to set
 */
public void setEtgdD15b(Long etgdD15b) {
	this.etgdD15b = etgdD15b;
}

/**
 * Comment : 
 * @fn Long getEtgdD16f()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD16f get
 */
public Long getEtgdD16f() {
	return etgdD16f;
}

/**
 * Comment : 
 *@fn void setEtgdD16f(Long etgdD16f)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD16f the etgdD16f to set
 */
public void setEtgdD16f(Long etgdD16f) {
	this.etgdD16f = etgdD16f;
}

/**
 * Comment : 
 * @fn Long getEtgdD16b()
 * @brief date:2017 2017. 1. 16. user:atres-pc
 * @return the etgdD16b get
 */
public Long getEtgdD16b() {
	return etgdD16b;
}

/**
 * Comment : 
 *@fn void setEtgdD16b(Long etgdD16b)
 *@brief date:2017 2017. 1. 16. user:atres-pc
 *@param etgdD16b the etgdD16b to set
 */
public void setEtgdD16b(Long etgdD16b) {
	this.etgdD16b = etgdD16b;
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
    
    public Long getBefoScnt() {
        return this.befoScnt;
    }
    
    public void setBefoScnt(Long befoScnt) {
        this.befoScnt = befoScnt;
    }
    
    public Long getPayrTamt() {
        return this.payrTamt;
    }
    
    public void setPayrTamt(Long payrTamt) {
        this.payrTamt = payrTamt;
    }
    
    public Long getBonsToam() {
        return this.bonsToam;
    }
    
    public void setBonsToam(Long bonsToam) {
        this.bonsToam = bonsToam;
    }
    
    public Long getDtmnBsam() {
        return this.dtmnBsam;
    }
    
    public void setDtmnBsam(Long dtmnBsam) {
        this.dtmnBsam = dtmnBsam;
    }
    
    public Long getStckPrft() {
        return this.stckPrft;
    }
    
    public void setStckPrft(Long stckPrft) {
        this.stckPrft = stckPrft;
    }
    
    public Long getCurrTots() {
        return this.currTots;
    }
    
    public void setCurrTots(Long currTots) {
        this.currTots = currTots;
    }
    
    public Long getTaxmSfam() {
        return this.taxmSfam;
    }
    
    public void setTaxmSfam(Long taxmSfam) {
        this.taxmSfam = taxmSfam;
    }
    
    public Long getTaxmEtam() {
        return this.taxmEtam;
    }
    
    public void setTaxmEtam(Long taxmEtam) {
        this.taxmEtam = taxmEtam;
    }
    
    public Long getTaxmBoin() {
        return this.taxmBoin;
    }
    
    public void setTaxmBoin(Long taxmBoin) {
        this.taxmBoin = taxmBoin;
    }
    
    public Long getTxecAmnt() {
        return this.txecAmnt;
    }
    
    public void setTxecAmnt(Long txecAmnt) {
        this.txecAmnt = txecAmnt;
    }
    
    public Long getTotlSala() {
        return this.totlSala;
    }
    
    public void setTotlSala(Long totlSala) {
        this.totlSala = totlSala;
    }
    
    public Long getWkerDdct() {
        return this.wkerDdct;
    }
    
    public void setWkerDdct(Long wkerDdct) {
        this.wkerDdct = wkerDdct;
    }
    
    public Long getWkerAmnt() {
        return this.wkerAmnt;
    }
    
    public void setWkerAmnt(Long wkerAmnt) {
        this.wkerAmnt = wkerAmnt;
    }
    
    public Long getBaseSelf() {
        return this.baseSelf;
    }
    
    public void setBaseSelf(Long baseSelf) {
        this.baseSelf = baseSelf;
    }
    
    public Long getBaseWife() {
        return this.baseWife;
    }
    
    public void setBaseWife(Long baseWife) {
        this.baseWife = baseWife;
    }
    
    public Long getBaseFyam() {
        return this.baseFyam;
    }
    
    public void setBaseFyam(Long baseFyam) {
        this.baseFyam = baseFyam;
    }
    
    public Long getAddrHdam() {
        return this.addrHdam;
    }
    
    public void setAddrHdam(Long addrHdam) {
        this.addrHdam = addrHdam;
    }
    
    public Long getAddrRpt70() {
        return this.addrRpt70;
    }
    
    public void setAddrRpt70(Long addrRpt70) {
        this.addrRpt70 = addrRpt70;
    }
    
    public Long getAddrFame() {
        return this.addrFame;
    }
    
    public void setAddrFame(Long addrFame) {
        this.addrFame = addrFame;
    }
    
    public Long getAddrChld() {
        return this.addrChld;
    }
    
    public void setAddrChld(Long addrChld) {
        this.addrChld = addrChld;
    }
    
    public Long getAddrBrth() {
        return this.addrBrth;
    }
    
    public void setAddrBrth(Long addrBrth) {
        this.addrBrth = addrBrth;
    }
    
    public Long getPantOnam() {
        return this.pantOnam;
    }
    
    public void setPantOnam(Long pantOnam) {
        this.pantOnam = pantOnam;
    }
    
    public Long getAddrMcam() {
        return this.addrMcam;
    }
    
    public void setAddrMcam(Long addrMcam) {
        this.addrMcam = addrMcam;
    }
    
    public Long getBnatDdct() {
        return this.bnatDdct;
    }
    
    public void setBnatDdct(Long bnatDdct) {
        this.bnatDdct = bnatDdct;
    }
    
    public Long getJnatDdct() {
        return this.jnatDdct;
    }
    
    public void setJnatDdct(Long jnatDdct) {
        this.jnatDdct = jnatDdct;
    }
    
    public Long getBpssDdct() {
        return this.bpssDdct;
    }
    
    public void setBpssDdct(Long bpssDdct) {
        this.bpssDdct = bpssDdct;
    }
    
    public Long getBpssHsol() {
        return this.bpssHsol;
    }
    
    public void setBpssHsol(Long bpssHsol) {
        this.bpssHsol = bpssHsol;
    }
    
    public Long getBpssHtec() {
        return this.bpssHtec;
    }
    
    public void setBpssHtec(Long bpssHtec) {
        this.bpssHtec = bpssHtec;
    }
    
    public Long getBpssHpul() {
        return this.bpssHpul;
    }
    
    public void setBpssHpul(Long bpssHpul) {
        this.bpssHpul = bpssHpul;
    }
    
    public Long getJpssDdct() {
        return this.jpssDdct;
    }
    
    public void setJpssDdct(Long jpssDdct) {
        this.jpssDdct = jpssDdct;
    }
    
    public Long getJpssHsol() {
        return this.jpssHsol;
    }
    
    public void setJpssHsol(Long jpssHsol) {
        this.jpssHsol = jpssHsol;
    }
    
    public Long getJpssHtec() {
        return this.jpssHtec;
    }
    
    public void setJpssHtec(Long jpssHtec) {
        this.jpssHtec = jpssHtec;
    }
    
    public Long getJpssHpul() {
        return this.jpssHpul;
    }
    
    public void setJpssHpul(Long jpssHpul) {
        this.jpssHpul = jpssHpul;
    }
    
    public Long getBrtrHict() {
        return this.brtrHict;
    }
    
    public void setBrtrHict(Long brtrHict) {
        this.brtrHict = brtrHict;
    }
    
    public Long getBrtrPsrn() {
        return this.brtrPsrn;
    }
    
    public void setBrtrPsrn(Long brtrPsrn) {
        this.brtrPsrn = brtrPsrn;
    }
    
    public Long getBrtrHnsv() {
        return this.brtrHnsv;
    }
    
    public void setBrtrHnsv(Long brtrHnsv) {
        this.brtrHnsv = brtrHnsv;
    }
    
    public Long getJrtrHict() {
        return this.jrtrHict;
    }
    
    public void setJrtrHict(Long jrtrHict) {
        this.jrtrHict = jrtrHict;
    }
    
    public Long getJrtrPsrn() {
        return this.jrtrPsrn;
    }
    
    public void setJrtrPsrn(Long jrtrPsrn) {
        this.jrtrPsrn = jrtrPsrn;
    }
    
    public Long getJrtrHnsv() {
        return this.jrtrHnsv;
    }
    
    public void setJrtrHnsv(Long jrtrHnsv) {
        this.jrtrHnsv = jrtrHnsv;
    }
    
    public Long getRrptYnam() {
        return this.rrptYnam;
    }
    
    public void setRrptYnam(Long rrptYnam) {
        this.rrptYnam = rrptYnam;
    }
    
    public Long getSpciBhth() {
        return this.spciBhth;
    }
    
    public void setSpciBhth(Long spciBhth) {
        this.spciBhth = spciBhth;
    }
    
    public Long getSpciJhth() {
        return this.spciJhth;
    }
    
    public void setSpciJhth(Long spciJhth) {
        this.spciJhth = spciJhth;
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
    
    public Long getSpciRtde() {
        return this.spciRtde;
    }
    
    public void setSpciRtde(Long spciRtde) {
        this.spciRtde = spciRtde;
    }
    
    public Long getSpciHrto() {
        return this.spciHrto;
    }
    
    public void setSpciHrto(Long spciHrto) {
        this.spciHrto = spciHrto;
    }
    
    public Long getSpciSelf() {
        return this.spciSelf;
    }
    
    public void setSpciSelf(Long spciSelf) {
        this.spciSelf = spciSelf;
    }
    
    public Long getSpciHe65() {
        return this.spciHe65;
    }
    
    public void setSpciHe65(Long spciHe65) {
        this.spciHe65 = spciHe65;
    }
    
    public Long getSpciHbps() {
        return this.spciHbps;
    }
    
    public void setSpciHbps(Long spciHbps) {
        this.spciHbps = spciHbps;
    }
    
    public Long getSpciDetc() {
        return this.spciDetc;
    }
    
    public void setSpciDetc(Long spciDetc) {
        this.spciDetc = spciDetc;
    }
    
    public Long getSpciTxcr() {
        return this.spciTxcr;
    }
    
    public void setSpciTxcr(Long spciTxcr) {
        this.spciTxcr = spciTxcr;
    }
    
    public Long getSpciMeto() {
        return this.spciMeto;
    }
    
    public void setSpciMeto(Long spciMeto) {
        this.spciMeto = spciMeto;
    }
    
    public Long getSpedSelf() {
        return this.spedSelf;
    }
    
    public void setSpedSelf(Long spedSelf) {
        this.spedSelf = spedSelf;
    }
    
    public Long getSpedGrde() {
        return this.spedGrde;
    }
    
    public void setSpedGrde(Long spedGrde) {
        this.spedGrde = spedGrde;
    }
    
    public Long getSpedGdto() {
        return this.spedGdto;
    }
    
    public void setSpedGdto(Long spedGdto) {
        this.spedGdto = spedGdto;
    }
    
    public Long getSpedCldv() {
        return this.spedCldv;
    }
    
    public void setSpedCldv(Long spedCldv) {
        this.spedCldv = spedCldv;
    }
    
    public Long getSpciSpec() {
        return this.spciSpec;
    }
    
    public void setSpciSpec(Long spciSpec) {
        this.spciSpec = spciSpec;
    }
    
    public Long getSpedTxcr() {
        return this.spedTxcr;
    }
    
    public void setSpedTxcr(Long spedTxcr) {
        this.spedTxcr = spedTxcr;
    }
    
    public Long getSpedToam() {
        return this.spedToam;
    }
    
    public void setSpedToam(Long spedToam) {
        this.spedToam = spedToam;
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
    
    public Long getSpciTgrt() {
        return this.spciTgrt;
    }
    
    public void setSpciTgrt(Long spciTgrt) {
        this.spciTgrt = spciTgrt;
    }
    
    public Long getSpciRtam() {
        return this.spciRtam;
    }
    
    public void setSpciRtam(Long spciRtam) {
        this.spciRtam = spciRtam;
    }
    
    public Long getSpchRefn() {
        return this.spchRefn;
    }
    
    public void setSpchRefn(Long spchRefn) {
        this.spchRefn = spchRefn;
    }
    
    public Long getSpchRe15() {
        return this.spchRe15;
    }
    
    public void setSpchRe15(Long spchRe15) {
        this.spchRe15 = spchRe15;
    }
    
    public Long getSpchRe29() {
        return this.spchRe29;
    }
    
    public void setSpchRe29(Long spchRe29) {
        this.spchRe29 = spchRe29;
    }
    
    public Long getSpchRe30() {
        return this.spchRe30;
    }
    
    public void setSpchRe30(Long spchRe30) {
        this.spchRe30 = spchRe30;
    }
    
    public Long getSpciRefx() {
        return this.spciRefx;
    }
    
    public void setSpciRefx(Long spciRefx) {
        this.spciRefx = spciRefx;
    }
    
    public Long getSpciReec() {
        return this.spciReec;
    }
    
    public void setSpciReec(Long spciReec) {
        this.spciReec = spciReec;
    }
    
    public Long getSpci15fx() {
        return this.spci15fx;
    }
    
    public void setSpci15fx(Long spci15fx) {
        this.spci15fx = spci15fx;
    }
    
    public Long getSpci15fb() {
        return this.spci15fb;
    }
    
    public void setSpci15fb(Long spci15fb) {
        this.spci15fb = spci15fb;
    }
    
    public Long getSpci15ec() {
        return this.spci15ec;
    }
    
    public void setSpci15ec(Long spci15ec) {
        this.spci15ec = spci15ec;
    }
    
    public Long getSpci10fb() {
        return this.spci10fb;
    }
    
    public void setSpci10fb(Long spci10fb) {
        this.spci10fb = spci10fb;
    }
    
    public Long getSpci10ec() {
        return this.spci10ec;
    }
    
    public void setSpci10ec(Long spci10ec) {
        this.spci10ec = spci10ec;
    }
    
    public Long getSpchReto() {
        return this.spchReto;
    }
    
    public void setSpchReto(Long spchReto) {
        this.spchReto = spchReto;
    }
    
    public Long getTaxdPltc() {
        return this.taxdPltc;
    }
    
    public void setTaxdPltc(Long taxdPltc) {
        this.taxdPltc = taxdPltc;
    }
    
    public Long getSpciPltc() {
        return this.spciPltc;
    }
    
    public void setSpciPltc(Long spciPltc) {
        this.spciPltc = spciPltc;
    }
    
    public Long getSpciFbam() {
        return this.spciFbam;
    }
    
    public void setSpciFbam(Long spciFbam) {
        this.spciFbam = spciFbam;
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
    
    public Long getSpciRfam() {
        return this.spciRfam;
    }
    
    public void setSpciRfam(Long spciRfam) {
        this.spciRfam = spciRfam;
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
    
    public Long getSpciDgcr() {
        return this.spciDgcr;
    }
    
    public void setSpciDgcr(Long spciDgcr) {
        this.spciDgcr = spciDgcr;
    }
    
    public Long getSpciSsum() {
        return this.spciSsum;
    }
    
    public void setSpciSsum(Long spciSsum) {
        this.spciSsum = spciSsum;
    }
    
    public Long getSpciDdct() {
        return this.spciDdct;
    }
    
    public void setSpciDdct(Long spciDdct) {
        this.spciDdct = spciDdct;
    }
    
    public Long getSubtEram() {
        return this.subtEram;
    }
    
    public void setSubtEram(Long subtEram) {
        this.subtEram = subtEram;
    }
    
    public Long getEtcpPsnv() {
        return this.etcpPsnv;
    }
    
    public void setEtcpPsnv(Long etcpPsnv) {
        this.etcpPsnv = etcpPsnv;
    }
    
    public Long getEtcpNsav() {
        return this.etcpNsav;
    }
    
    public void setEtcpNsav(Long etcpNsav) {
        this.etcpNsav = etcpNsav;
    }
    
    public Long getPrcmToam() {
        return this.prcmToam;
    }
    
    public void setPrcmToam(Long prcmToam) {
        this.prcmToam = prcmToam;
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
    
    public Long getEtwkSbam() {
        return this.etwkSbam;
    }
    
    public void setEtwkSbam(Long etwkSbam) {
        this.etwkSbam = etwkSbam;
    }
    
    public Long getEtwkSvam() {
        return this.etwkSvam;
    }
    
    public void setEtwkSvam(Long etwkSvam) {
        this.etwkSvam = etwkSvam;
    }
    
    public Long getEtwkLgam() {
        return this.etwkLgam;
    }
    
    public void setEtwkLgam(Long etwkLgam) {
        this.etwkLgam = etwkLgam;
    }
    
    public Long getEtwkBdam() {
        return this.etwkBdam;
    }
    
    public void setEtwkBdam(Long etwkBdam) {
        this.etwkBdam = etwkBdam;
    }
    
    public Long getEtctConc() {
        return this.etctConc;
    }
    
    public void setEtctConc(Long etctConc) {
        this.etctConc = etctConc;
    }
    
     
    
    public Long getEtgdD14f() {
        return this.etgdD14f;
    }
    
    public void setEtgdD14f(Long etgdD14f) {
        this.etgdD14f = etgdD14f;
    }
    
    public Long getEtgdDdam() {
        return this.etgdDdam;
    }
    
    public void setEtgdDdam(Long etgdDdam) {
        this.etgdDdam = etgdDdam;
    }
    
    public Long getEtccCard() {
        return this.etccCard;
    }
    
    public void setEtccCard(Long etccCard) {
        this.etccCard = etccCard;
    }
    
    public Long getEtckUnon() {
        return this.etckUnon;
    }
    
    public void setEtckUnon(Long etckUnon) {
        this.etckUnon = etckUnon;
    }
    
    public Long getEtckUncr() {
        return this.etckUncr;
    }
    
    public void setEtckUncr(Long etckUncr) {
        this.etckUncr = etckUncr;
    }
    
    public Long getEtepMsam() {
        return this.etepMsam;
    }
    
    public void setEtepMsam(Long etepMsam) {
        this.etepMsam = etepMsam;
    }
    
    public Long getEtgdHtra() {
        return this.etgdHtra;
    }
    
    public void setEtgdHtra(Long etgdHtra) {
        this.etgdHtra = etgdHtra;
    }
    
    public Long getEtepSecr() {
        return this.etepSecr;
    }
    
    public void setEtepSecr(Long etepSecr) {
        this.etepSecr = etepSecr;
    }
    
    public Long getEtclTo01() {
        return this.etclTo01;
    }
    
    public void setEtclTo01(Long etclTo01) {
        this.etclTo01 = etclTo01;
    }
    
    public Long getEtclTo02() {
        return this.etclTo02;
    }
    
    public void setEtclTo02(Long etclTo02) {
        this.etclTo02 = etclTo02;
    }
    
    public Long getEtclTo03() {
        return this.etclTo03;
    }
    
    public void setEtclTo03(Long etclTo03) {
        this.etclTo03 = etclTo03;
    }
    
    public Long getEtclHmto() {
        return this.etclHmto;
    }
    
    public void setEtclHmto(Long etclHmto) {
        this.etclHmto = etclHmto;
    }
     
    public Long getSpchExli() {
        return this.spchExli;
    }
    
    public void setSpchExli(Long spchExli) {
        this.spchExli = spchExli;
    }
    
    public Long getStndIncm() {
        return this.stndIncm;
    }
    
    public void setStndIncm(Long stndIncm) {
        this.stndIncm = stndIncm;
    }
    
    public Long getPrddTaxn() {
        return this.prddTaxn;
    }
    
    public void setPrddTaxn(Long prddTaxn) {
        this.prddTaxn = prddTaxn;
    }
    
    public Long getTaxdIcax() {
        return this.taxdIcax;
    }
    
    public void setTaxdIcax(Long taxdIcax) {
        this.taxdIcax = taxdIcax;
    }
    
    public Long getTaxdSpct() {
        return this.taxdSpct;
    }
    
    public void setTaxdSpct(Long taxdSpct) {
        this.taxdSpct = taxdSpct;
    }
    
    public Long getTxlgCl30() {
        return this.txlgCl30;
    }
    
    public void setTxlgCl30(Long txlgCl30) {
        this.txlgCl30 = txlgCl30;
    }
    
    public Long getTxlgHxtt() {
        return this.txlgHxtt;
    }
    
    public void setTxlgHxtt(Long txlgHxtt) {
        this.txlgHxtt = txlgHxtt;
    }
    
    public Long getTaxdTsum() {
        return this.taxdTsum;
    }
    
    public void setTaxdTsum(Long taxdTsum) {
        this.taxdTsum = taxdTsum;
    }
    
    public Long getTaxdWken() {
        return this.taxdWken;
    }
    
    public void setTaxdWken(Long taxdWken) {
        this.taxdWken = taxdWken;
    }
    
    public Long getTaxdUnin() {
        return this.taxdUnin;
    }
    
    public void setTaxdUnin(Long taxdUnin) {
        this.taxdUnin = taxdUnin;
    }
    
    public Long getTaxdLoan() {
        return this.taxdLoan;
    }
    
    public void setTaxdLoan(Long taxdLoan) {
        this.taxdLoan = taxdLoan;
    }
    
    public Long getTaxdPaid() {
        return this.taxdPaid;
    }
    
    public void setTaxdPaid(Long taxdPaid) {
        this.taxdPaid = taxdPaid;
    }
    
    public Long getTaxdRedu() {
        return this.taxdRedu;
    }
    
    public void setTaxdRedu(Long taxdRedu) {
        this.taxdRedu = taxdRedu;
    }
    
    public Long getAddrMccr() {
        return this.addrMccr;
    }
    
    public void setAddrMccr(Long addrMccr) {
        this.addrMccr = addrMccr;
    }
    
    public Long getSpciDcto() {
        return this.spciDcto;
    }
    
    public void setSpciDcto(Long spciDcto) {
        this.spciDcto = spciDcto;
    }
    
    public Long getTaxdCsum() {
        return this.taxdCsum;
    }
    
    public void setTaxdCsum(Long taxdCsum) {
        this.taxdCsum = taxdCsum;
    }
    
    public Long getDcsnIncm() {
        return this.dcsnIncm;
    }
    
    public void setDcsnIncm(Long dcsnIncm) {
        this.dcsnIncm = dcsnIncm;
    }
    
    public Long getDcsnInhb() {
        return this.dcsnInhb;
    }
    
    public void setDcsnInhb(Long dcsnInhb) {
        this.dcsnInhb = dcsnInhb;
    }
    
    public Long getDcsnFafv() {
        return this.dcsnFafv;
    }
    
    public void setDcsnFafv(Long dcsnFafv) {
        this.dcsnFafv = dcsnFafv;
    }
    
    public Long getAlryPinx() {
        return this.alryPinx;
    }
    
    public void setAlryPinx(Long alryPinx) {
        this.alryPinx = alryPinx;
    }
    
    public Long getAlryPhbx() {
        return this.alryPhbx;
    }
    
    public void setAlryPhbx(Long alryPhbx) {
        this.alryPhbx = alryPhbx;
    }
    
    public Long getAlryYvtx() {
        return this.alryYvtx;
    }
    
    public void setAlryYvtx(Long alryYvtx) {
        this.alryYvtx = alryYvtx;
    }
    
    public Long getDcsnTots() {
        return this.dcsnTots;
    }
    
    public void setDcsnTots(Long dcsnTots) {
        this.dcsnTots = dcsnTots;
    }
    
    public Long getDcsnItax() {
        return this.dcsnItax;
    }
    
    public void setDcsnItax(Long dcsnItax) {
        this.dcsnItax = dcsnItax;
    }
    
    public Long getDcsnBtax() {
        return this.dcsnBtax;
    }
    
    public void setDcsnBtax(Long dcsnBtax) {
        this.dcsnBtax = dcsnBtax;
    }
    
    public Long getFafvTaxi() {
        return this.fafvTaxi;
    }
    
    public void setFafvTaxi(Long fafvTaxi) {
        this.fafvTaxi = fafvTaxi;
    }
    
    public Long getSubtEtax() {
        return this.subtEtax;
    }
    
    public void setSubtEtax(Long subtEtax) {
        this.subtEtax = subtEtax;
    }
    
    public Long getSubtInhb() {
        return this.subtInhb;
    }
    
    public void setSubtInhb(Long subtInhb) {
        this.subtInhb = subtInhb;
    }
    
    public Long getSubtFafv() {
        return this.subtFafv;
    }
    
    public void setSubtFafv(Long subtFafv) {
        this.subtFafv = subtFafv;
    }
    
    public Long getSubtAmsu() {
        return this.subtAmsu;
    }
    
    public void setSubtAmsu(Long subtAmsu) {
        this.subtAmsu = subtAmsu;
    }
    
    public Long getJrtrHnto() {
        return this.jrtrHnto;
    }
    
    public void setJrtrHnto(Long jrtrHnto) {
        this.jrtrHnto = jrtrHnto;
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
    
}
