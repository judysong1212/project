package com.app.exterms.yearendtax.client.dto.yeta2016;

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
public class Ye16Ta3220DTO  implements Serializable {
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
    private Boolean baseDdyn;

    /** set 장애인공제 : psclDdyn */
    private java.lang.String  psclDdyn;

    /** set 자녀양육비공제여부 : brddCtyn */
    private Boolean brddCtyn;

    /** set 부녀자공제여부 : faddCtyn */
    private Boolean faddCtyn;

    /** set 경로우대공제여부 : rpctDdyn */
    private Boolean  rpctDdyn;

    /** set 출산입양자공제여부 : bithDdyn */
    private Boolean bithDdyn;

    /** set 한부모공제여부 : pantOnyn */
    private Boolean pantOnyn;

    /** set 보험료_건강고용등국세청 : insuPayr */
    private Long insuPayr;

    /** set 보험료보장성_국세청 : insuRtyr */
    private Long insuRtyr;

    /** set 보험료장애인보장성_국세청 : psclIurr */
    private Long psclIurr;

    /** set 의료비_국세청 : mediCost */
    private Long mediCost;

    /** set 교육비_국세청 : educCost */
    private Long educCost;

    /** set 신용카드등_국세청 : cdteCard */
    private Long cdteCard;

    /** set 현금영수증_국세청 : cashRece */
    private Long cashRece;

    /** set 직불카드등_국세청 : jiblCard */
    private Long jiblCard;

    /** set 지로납부액_대중교통_국세청 : grpyAmnt */
    private Long grpyAmnt;

    /** set 전통시장사용분_국세청 : mgntStvd */
    private Long mgntStvd;

    /** set 기부금액_국세청 : ctrbAmnt */
    private Long ctrbAmnt;

    /** set 보험료_건강고용등외 : insuFetc */
    private Long insuFetc;

    /** set 보험료보장성외 : insuRtet */
    private Long insuRtet;

    /** set 보험료장애인보장성외 : psclIurt */
    private Long psclIurt;

    /** set 의료비외 : mediExps */
    private Long mediExps;

    /** set 교육비외 : educOtec */
    private Long educOtec;

    /** set 신용카드외 : cdteCdec */
    private Long cdteCdec;

    /** set 직불카드외 : jiblCdec */
    private Long jiblCdec;

    /** set 지로납부액_대중교통외 : grpyAtec */
    private Long grpyAtec;

    /** set 전통시장사용분외 : mgntSdec */
    private Long mgntSdec;

    /** set 기부금액외 : ctrbAmec */
    private Long ctrbAmec;

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


	/** set 고용보험_국세청 : insuGopy */
    private Long insuGopy;

    /** set 고용보험_외 : insuGoec */
    private Long insuGoec;

     
    /** set 주민등록번호 : rsnoNumb */
    private java.lang.String beforeJumin;
  
    
    /**
	 * Comment : 
	 * @fn Long getInsuGopy()
	 * @brief date:2017 2017. 2. 1. user:atres-pc
	 * @return the insuGopy get
	 */
	public Long getInsuGopy() {
		return insuGopy;
	}

	/**
	 * Comment : 
	 *@fn void setInsuGopy(Long insuGopy)
	 *@brief date:2017 2017. 2. 1. user:atres-pc
	 *@param insuGopy the insuGopy to set
	 */
	public void setInsuGopy(Long insuGopy) {
		this.insuGopy = insuGopy;
	}

	/**
	 * Comment : 
	 * @fn Long getInsuGoec()
	 * @brief date:2017 2017. 2. 1. user:atres-pc
	 * @return the insuGoec get
	 */
	public Long getInsuGoec() {
		return insuGoec;
	}

	/**
	 * Comment : 
	 *@fn void setInsuGoec(Long insuGoec)
	 *@brief date:2017 2017. 2. 1. user:atres-pc
	 *@param insuGoec the insuGoec to set
	 */
	public void setInsuGoec(Long insuGoec) {
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

	/** set 추가공제_다자녀인원수 : addrMrct */
    private Long addrMrct;

	/** set 인적공제항목변동여부 : humnCgue */
    private java.lang.String humnCgue;
   
    
    public Long getAddrMrct() {
		return addrMrct;
	}

	public void setAddrMrct(Long addrMrct) {
		this.addrMrct = addrMrct;
	}

	public java.lang.String getHumnCgue() {
		return humnCgue;
	}

	public void setHumnCgue(java.lang.String humnCgue) {
		this.humnCgue = humnCgue;
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
    
    public Boolean getBaseDdyn() {
        return this.baseDdyn;
    }
    
    public void setBaseDdyn(Boolean baseDdyn) {
        this.baseDdyn = baseDdyn;
    }
    
    public java.lang.String getPsclDdyn() {
        return this.psclDdyn;
    }
    
    public void setPsclDdyn(java.lang.String psclDdyn) {
        this.psclDdyn = psclDdyn;
    }
    
    public Boolean getBrddCtyn() {
        return this.brddCtyn;
    }
    
    public void setBrddCtyn(Boolean brddCtyn) {
        this.brddCtyn = brddCtyn;
    }
    
    public Boolean getFaddCtyn() {
        return this.faddCtyn;
    }
    
    public void setFaddCtyn(Boolean faddCtyn) {
        this.faddCtyn = faddCtyn;
    }
    
    public Boolean getRpctDdyn() {
        return this.rpctDdyn;
    }
    
    public void setRpctDdyn(Boolean rpctDdyn) {
        this.rpctDdyn = rpctDdyn;
    }
    
    public Boolean getBithDdyn() {
        return this.bithDdyn;
    }
    
    public void setBithDdyn(Boolean bithDdyn) {
        this.bithDdyn = bithDdyn;
    }
    
    public Boolean getPantOnyn() {
        return this.pantOnyn;
    }
    
    public void setPantOnyn(Boolean pantOnyn) {
        this.pantOnyn = pantOnyn;
    }
    
    public Long getInsuPayr() {
        return this.insuPayr;
    }
    
    public void setInsuPayr(Long insuPayr) {
        this.insuPayr = insuPayr;
    }
    
    public Long getInsuRtyr() {
        return this.insuRtyr;
    }
    
    public void setInsuRtyr(Long insuRtyr) {
        this.insuRtyr = insuRtyr;
    }
    
    public Long getPsclIurr() {
        return this.psclIurr;
    }
    
    public void setPsclIurr(Long psclIurr) {
        this.psclIurr = psclIurr;
    }
    
    public Long getMediCost() {
        return this.mediCost;
    }
    
    public void setMediCost(Long mediCost) {
        this.mediCost = mediCost;
    }
    
    public Long getEducCost() {
        return this.educCost;
    }
    
    public void setEducCost(Long educCost) {
        this.educCost = educCost;
    }
    
    public Long getCdteCard() {
        return this.cdteCard;
    }
    
    public void setCdteCard(Long cdteCard) {
        this.cdteCard = cdteCard;
    }
    
    public Long getCashRece() {
        return this.cashRece;
    }
    
    public void setCashRece(Long cashRece) {
        this.cashRece = cashRece;
    }
    
    public Long getJiblCard() {
        return this.jiblCard;
    }
    
    public void setJiblCard(Long jiblCard) {
        this.jiblCard = jiblCard;
    }
    
    public Long getGrpyAmnt() {
        return this.grpyAmnt;
    }
    
    public void setGrpyAmnt(Long grpyAmnt) {
        this.grpyAmnt = grpyAmnt;
    }
    
    public Long getMgntStvd() {
        return this.mgntStvd;
    }
    
    public void setMgntStvd(Long mgntStvd) {
        this.mgntStvd = mgntStvd;
    }
    
    public Long getCtrbAmnt() {
        return this.ctrbAmnt;
    }
    
    public void setCtrbAmnt(Long ctrbAmnt) {
        this.ctrbAmnt = ctrbAmnt;
    }
    
    public Long getInsuFetc() {
        return this.insuFetc;
    }
    
    public void setInsuFetc(Long insuFetc) {
        this.insuFetc = insuFetc;
    }
    
    public Long getInsuRtet() {
        return this.insuRtet;
    }
    
    public void setInsuRtet(Long insuRtet) {
        this.insuRtet = insuRtet;
    }
    
    public Long getPsclIurt() {
        return this.psclIurt;
    }
    
    public void setPsclIurt(Long psclIurt) {
        this.psclIurt = psclIurt;
    }
    
    public Long getMediExps() {
        return this.mediExps;
    }
    
    public void setMediExps(Long mediExps) {
        this.mediExps = mediExps;
    }
    
    public Long getEducOtec() {
        return this.educOtec;
    }
    
    public void setEducOtec(Long educOtec) {
        this.educOtec = educOtec;
    }
    
    public Long getCdteCdec() {
        return this.cdteCdec;
    }
    
    public void setCdteCdec(Long cdteCdec) {
        this.cdteCdec = cdteCdec;
    }
    
    public Long getJiblCdec() {
        return this.jiblCdec;
    }
    
    public void setJiblCdec(Long jiblCdec) {
        this.jiblCdec = jiblCdec;
    }
    
    public Long getGrpyAtec() {
        return this.grpyAtec;
    }
    
    public void setGrpyAtec(Long grpyAtec) {
        this.grpyAtec = grpyAtec;
    }
    
    public Long getMgntSdec() {
        return this.mgntSdec;
    }
    
    public void setMgntSdec(Long mgntSdec) {
        this.mgntSdec = mgntSdec;
    }
    
    public Long getCtrbAmec() {
        return this.ctrbAmec;
    }
    
    public void setCtrbAmec(Long ctrbAmec) {
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
