package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta3220VO.java
 * @Description : Yeta3220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3220_2018_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 주민등록번호 : rsnoNumb */
    private java.lang.String rsnoNumb;

    /** set 관계 : relhCode */
    private java.lang.String relhCode;

    /** set 성명 : kornName */
    private java.lang.String kornName;

    /** set 내외국인구분코드 : frnrCode */
    private java.lang.String frnrCode;

    /** set 기본공제여부 : baseDdyn */
    private java.lang.String baseDdyn;

    /** set 장애인공제여부 : psclDdyn */
    private java.lang.String psclDdyn;

    /** set 자녀양육비공제여부 : brddCtyn */
    private java.lang.String brddCtyn;

    /** set 부녀자공제여부 : faddCtyn */
    private java.lang.String faddCtyn;

    /** set 경로우대공제여부 : rpctDdyn */
    private java.lang.String rpctDdyn;

    /** set 출산입양자공제여부 : bithDdyn */
    private java.lang.String bithDdyn;

    /** set 한부모공제여부 : pantOnyn */
    private java.lang.String pantOnyn;

    /** set 보험료_건강고용등국세청 : insuPayr */
    private java.math.BigDecimal insuPayr;

    /** set 보험료보장성_국세청 : insuRtyr */
    private java.math.BigDecimal insuRtyr;

    /** set 보험료장애인보장성_국세청 : psclIurr */
    private java.math.BigDecimal psclIurr;

    /** set 의료비_국세청 : mediCost */
    private java.math.BigDecimal mediCost;

    /** set 교육비_국세청 : educCost */
    private java.math.BigDecimal educCost;

    /** set 신용카드등_국세청 : cdteCard */
    private java.math.BigDecimal cdteCard;

    /** set 현금영수증_국세청 : cashRece */
    private java.math.BigDecimal cashRece;

    /** set 직불카드등_국세청 : jiblCard */
    private java.math.BigDecimal jiblCard;

    /** set 지로납부액_대중교통_국세청 : grpyAmnt */
    private java.math.BigDecimal grpyAmnt;

    /** set 전통시장사용분_국세청 : mgntStvd */
    private java.math.BigDecimal mgntStvd;

    /** set 기부금액_국세청 : ctrbAmnt */
    private java.math.BigDecimal ctrbAmnt;

    /** set 보험료_건강고용등외 : insuFetc */
    private java.math.BigDecimal insuFetc;

    /** set 보험료보장성외 : insuRtet */
    private java.math.BigDecimal insuRtet;

    /** set 보험료장애인보장성외 : psclIurt */
    private java.math.BigDecimal psclIurt;

    /** set 의료비외 : mediExps */
    private java.math.BigDecimal mediExps;

    /** set 교육비외 : educOtec */
    private java.math.BigDecimal educOtec;

    /** set 신용카드외 : cdteCdec */
    private java.math.BigDecimal cdteCdec;

    /** set 직불카드외 : jiblCdec */
    private java.math.BigDecimal jiblCdec;

    /** set 지로납부액_대중교통외 : grpyAtec */
    private java.math.BigDecimal grpyAtec;

    /** set 전통시장사용분외 : mgntSdec */
    private java.math.BigDecimal mgntSdec;

    /** set 기부금액외 : ctrbAmec */
    private java.math.BigDecimal ctrbAmec;

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

    /** set 연말정산부양관계코드 : famySupptRelaDivCd */
    private java.lang.String famySupptRelaDivCd;
  
    /** RSNO_NUMB */
    private java.lang.String beforeJumin;

	/** set 고용보험_국세청 : insuGopy */
    private java.math.BigDecimal insuGopy;

    /** set 고용보험_외 : insuGoec */
    private java.math.BigDecimal insuGoec;

    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getInsuGopy()
	 * @brief date:2017 2017. 2. 1. user:atres-pc
	 * @return the insuGopy get
	 */
	public java.math.BigDecimal getInsuGopy() {
		return insuGopy;
	}

	/**
	 * Comment : 
	 *@fn void setInsuGopy(java.math.BigDecimal insuGopy)
	 *@brief date:2017 2017. 2. 1. user:atres-pc
	 *@param insuGopy the insuGopy to set
	 */
	public void setInsuGopy(java.math.BigDecimal insuGopy) {
		this.insuGopy = insuGopy;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getInsuGoec()
	 * @brief date:2017 2017. 2. 1. user:atres-pc
	 * @return the insuGoec get
	 */
	public java.math.BigDecimal getInsuGoec() {
		return insuGoec;
	}

	/**
	 * Comment : 
	 *@fn void setInsuGoec(java.math.BigDecimal insuGoec)
	 *@brief date:2017 2017. 2. 1. user:atres-pc
	 *@param insuGoec the insuGoec to set
	 */
	public void setInsuGoec(java.math.BigDecimal insuGoec) {
		this.insuGoec = insuGoec;
	}

  
    /**
	 * Comment : 
	 * @fn java.lang.String getFamySupptRelaDivCd()
	 * @brief date:2017 2017. 1. 18. user:atres-pc
	 * @return the famySupptRelaDivCd get
	 */
	public java.lang.String getFamySupptRelaDivCd() {
		return famySupptRelaDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setFamySupptRelaDivCd(java.lang.String famySupptRelaDivCd)
	 *@brief date:2017 2017. 1. 18. user:atres-pc
	 *@param famySupptRelaDivCd the famySupptRelaDivCd to set
	 */
	public void setFamySupptRelaDivCd(java.lang.String famySupptRelaDivCd) {
		this.famySupptRelaDivCd = famySupptRelaDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBeforeJumin()
	 * @brief date:2017 2017. 1. 18. user:atres-pc
	 * @return the beforeJumin get
	 */
	public java.lang.String getBeforeJumin() {
		return beforeJumin;
	}

	/**
	 * Comment : 
	 *@fn void setBeforeJumin(java.lang.String beforeJumin)
	 *@brief date:2017 2017. 1. 18. user:atres-pc
	 *@param beforeJumin the beforeJumin to set
	 */
	public void setBeforeJumin(java.lang.String beforeJumin) {
		this.beforeJumin = beforeJumin;
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
    
    public java.lang.String getRsnoNumb() {
        return this.rsnoNumb;
    }
    
    public void setRsnoNumb(java.lang.String rsnoNumb) {
        this.rsnoNumb = rsnoNumb;
    }
    
    public java.lang.String getRelhCode() {
        return this.relhCode;
    }
    
    public void setRelhCode(java.lang.String relhCode) {
        this.relhCode = relhCode;
    }
    
    public java.lang.String getKornName() {
        return this.kornName;
    }
    
    public void setKornName(java.lang.String kornName) {
        this.kornName = kornName;
    }
    
    public java.lang.String getFrnrCode() {
        return this.frnrCode;
    }
    
    public void setFrnrCode(java.lang.String frnrCode) {
        this.frnrCode = frnrCode;
    }
    
    public java.lang.String getBaseDdyn() {
        return this.baseDdyn;
    }
    
    public void setBaseDdyn(java.lang.String baseDdyn) {
        this.baseDdyn = baseDdyn;
    }
    
    public java.lang.String getPsclDdyn() {
        return this.psclDdyn;
    }
    
    public void setPsclDdyn(java.lang.String psclDdyn) {
        this.psclDdyn = psclDdyn;
    }
    
    public java.lang.String getBrddCtyn() {
        return this.brddCtyn;
    }
    
    public void setBrddCtyn(java.lang.String brddCtyn) {
        this.brddCtyn = brddCtyn;
    }
    
    public java.lang.String getFaddCtyn() {
        return this.faddCtyn;
    }
    
    public void setFaddCtyn(java.lang.String faddCtyn) {
        this.faddCtyn = faddCtyn;
    }
    
    public java.lang.String getRpctDdyn() {
        return this.rpctDdyn;
    }
    
    public void setRpctDdyn(java.lang.String rpctDdyn) {
        this.rpctDdyn = rpctDdyn;
    }
    
    public java.lang.String getBithDdyn() {
        return this.bithDdyn;
    }
    
    public void setBithDdyn(java.lang.String bithDdyn) {
        this.bithDdyn = bithDdyn;
    }
    
    public java.lang.String getPantOnyn() {
        return this.pantOnyn;
    }
    
    public void setPantOnyn(java.lang.String pantOnyn) {
        this.pantOnyn = pantOnyn;
    }
    
    public java.math.BigDecimal getInsuPayr() {
        return this.insuPayr;
    }
    
    public void setInsuPayr(java.math.BigDecimal insuPayr) {
        this.insuPayr = insuPayr;
    }
    
    public java.math.BigDecimal getInsuRtyr() {
        return this.insuRtyr;
    }
    
    public void setInsuRtyr(java.math.BigDecimal insuRtyr) {
        this.insuRtyr = insuRtyr;
    }
    
    public java.math.BigDecimal getPsclIurr() {
        return this.psclIurr;
    }
    
    public void setPsclIurr(java.math.BigDecimal psclIurr) {
        this.psclIurr = psclIurr;
    }
    
    public java.math.BigDecimal getMediCost() {
        return this.mediCost;
    }
    
    public void setMediCost(java.math.BigDecimal mediCost) {
        this.mediCost = mediCost;
    }
    
    public java.math.BigDecimal getEducCost() {
        return this.educCost;
    }
    
    public void setEducCost(java.math.BigDecimal educCost) {
        this.educCost = educCost;
    }
    
    public java.math.BigDecimal getCdteCard() {
        return this.cdteCard;
    }
    
    public void setCdteCard(java.math.BigDecimal cdteCard) {
        this.cdteCard = cdteCard;
    }
    
    public java.math.BigDecimal getCashRece() {
        return this.cashRece;
    }
    
    public void setCashRece(java.math.BigDecimal cashRece) {
        this.cashRece = cashRece;
    }
    
    public java.math.BigDecimal getJiblCard() {
        return this.jiblCard;
    }
    
    public void setJiblCard(java.math.BigDecimal jiblCard) {
        this.jiblCard = jiblCard;
    }
    
    public java.math.BigDecimal getGrpyAmnt() {
        return this.grpyAmnt;
    }
    
    public void setGrpyAmnt(java.math.BigDecimal grpyAmnt) {
        this.grpyAmnt = grpyAmnt;
    }
    
    public java.math.BigDecimal getMgntStvd() {
        return this.mgntStvd;
    }
    
    public void setMgntStvd(java.math.BigDecimal mgntStvd) {
        this.mgntStvd = mgntStvd;
    }
    
    public java.math.BigDecimal getCtrbAmnt() {
        return this.ctrbAmnt;
    }
    
    public void setCtrbAmnt(java.math.BigDecimal ctrbAmnt) {
        this.ctrbAmnt = ctrbAmnt;
    }
    
    public java.math.BigDecimal getInsuFetc() {
        return this.insuFetc;
    }
    
    public void setInsuFetc(java.math.BigDecimal insuFetc) {
        this.insuFetc = insuFetc;
    }
    
    public java.math.BigDecimal getInsuRtet() {
        return this.insuRtet;
    }
    
    public void setInsuRtet(java.math.BigDecimal insuRtet) {
        this.insuRtet = insuRtet;
    }
    
    public java.math.BigDecimal getPsclIurt() {
        return this.psclIurt;
    }
    
    public void setPsclIurt(java.math.BigDecimal psclIurt) {
        this.psclIurt = psclIurt;
    }
    
    public java.math.BigDecimal getMediExps() {
        return this.mediExps;
    }
    
    public void setMediExps(java.math.BigDecimal mediExps) {
        this.mediExps = mediExps;
    }
    
    public java.math.BigDecimal getEducOtec() {
        return this.educOtec;
    }
    
    public void setEducOtec(java.math.BigDecimal educOtec) {
        this.educOtec = educOtec;
    }
    
    public java.math.BigDecimal getCdteCdec() {
        return this.cdteCdec;
    }
    
    public void setCdteCdec(java.math.BigDecimal cdteCdec) {
        this.cdteCdec = cdteCdec;
    }
    
    public java.math.BigDecimal getJiblCdec() {
        return this.jiblCdec;
    }
    
    public void setJiblCdec(java.math.BigDecimal jiblCdec) {
        this.jiblCdec = jiblCdec;
    }
    
    public java.math.BigDecimal getGrpyAtec() {
        return this.grpyAtec;
    }
    
    public void setGrpyAtec(java.math.BigDecimal grpyAtec) {
        this.grpyAtec = grpyAtec;
    }
    
    public java.math.BigDecimal getMgntSdec() {
        return this.mgntSdec;
    }
    
    public void setMgntSdec(java.math.BigDecimal mgntSdec) {
        this.mgntSdec = mgntSdec;
    }
    
    public java.math.BigDecimal getCtrbAmec() {
        return this.ctrbAmec;
    }
    
    public void setCtrbAmec(java.math.BigDecimal ctrbAmec) {
        this.ctrbAmec = ctrbAmec;
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
