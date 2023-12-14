package com.app.smrmf.infc.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0100VO.java
 * @Description : Bass0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgBass0100VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 사업장명 : dpobNm */
    private java.lang.String dpobNm;

    /** set 대표자주민번호 : degtrResnRegnNum */
    private java.lang.String degtrResnRegnNum;
    

    /** degtrSecResnNum : 주민등록번호 원본*/
    private java.lang.String degtrSecResnNum;

    /** set null : tplvlDpobCd */
    private java.lang.String tplvlDpobCd;

    /** set 대표자명 : degtrNm */
    private java.lang.String degtrNm;

    /** set 사업자등록번호 : busoprRgstnNum */
    private java.lang.String busoprRgstnNum;

    /** set 법인등록번호 : corpRgstnNum */
    private java.lang.String corpRgstnNum;

    /** set 법인구분코드 : corpDivCd */
    private java.lang.String corpDivCd;

    /** set 사업장우편번호 : dpobZpcd */
    private java.lang.String dpobZpcd;

    /** set 사업장기본주소 : dpobFndtnAddr */
    private java.lang.String dpobFndtnAddr;

    /** set 사업장상세주소 : dpobDtlPatrAddr */
    private java.lang.String dpobDtlPatrAddr;

    /** set 사업장전화번호 : dpobPhnNum */
    private java.lang.String dpobPhnNum;

    /** set 사업장팩스번호 : dpobFaxNum */
    private java.lang.String dpobFaxNum;

    /** set 사업장직인문구명 : dpobSealWrdNm */
    private java.lang.String dpobSealWrdNm;

    /** set 사업장직인경로 : dpobSealRftaNm */
    private java.lang.String dpobSealRftaNm;

    /** set 사업장직인파일명 : dpobSealFlNm */
    private java.lang.String dpobSealFlNm;

    /** set 사업장기본사용여부 : dpobFndtnUseYn */
    private java.lang.String dpobFndtnUseYn;

    /** set 건강보험기호 : hlthInsrSym */
    private java.lang.String hlthInsrSym;

    /** set 국민연금기호 : natPennSym */
    private java.lang.String natPennSym;

    /** set 고용보험기호 : umytInsrSym */
    private java.lang.String umytInsrSym;

    /** set 시스템플래그 : sysDivCd */
    private java.lang.String sysDivCd;

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

    /** set 수정자주소 : revnAddr */
    private java.lang.String revnAddr;

    /** set 퇴직징수의무자구분코드 : retryCllnDebrDivCd */
    private java.lang.String retryCllnDebrDivCd;

    /** set 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
    private java.lang.String insurPrvaffAgcyIstutNum;

    /** set 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
    private java.lang.String insurPrvaffAgcyIstutNm;

    /** set 건강보험영업소기호 : hlthInsrOfceSym */
    private java.lang.String hlthInsrOfceSym;

    /** set 산재보험기호 : idtlAccdtInsurSym */
    private java.lang.String idtlAccdtInsurSym;

    

    
    public java.lang.String getTplvlDpobCd() {
		return tplvlDpobCd;
	}

	public void setTplvlDpobCd(java.lang.String tplvlDpobCd) {
		this.tplvlDpobCd = tplvlDpobCd;
	}

	public java.lang.String getRetryCllnDebrDivCd() {
		return retryCllnDebrDivCd;
	}

	public void setRetryCllnDebrDivCd(java.lang.String retryCllnDebrDivCd) {
		this.retryCllnDebrDivCd = retryCllnDebrDivCd;
	}

	public java.lang.String getInsurPrvaffAgcyIstutNum() {
		return insurPrvaffAgcyIstutNum;
	}

	public void setInsurPrvaffAgcyIstutNum(java.lang.String insurPrvaffAgcyIstutNum) {
		this.insurPrvaffAgcyIstutNum = insurPrvaffAgcyIstutNum;
	}

	public java.lang.String getInsurPrvaffAgcyIstutNm() {
		return insurPrvaffAgcyIstutNm;
	}

	public void setInsurPrvaffAgcyIstutNm(java.lang.String insurPrvaffAgcyIstutNm) {
		this.insurPrvaffAgcyIstutNm = insurPrvaffAgcyIstutNm;
	}

	public java.lang.String getHlthInsrOfceSym() {
		return hlthInsrOfceSym;
	}

	public void setHlthInsrOfceSym(java.lang.String hlthInsrOfceSym) {
		this.hlthInsrOfceSym = hlthInsrOfceSym;
	}

	public java.lang.String getIdtlAccdtInsurSym() {
		return idtlAccdtInsurSym;
	}

	public void setIdtlAccdtInsurSym(java.lang.String idtlAccdtInsurSym) {
		this.idtlAccdtInsurSym = idtlAccdtInsurSym;
	}

	public java.lang.String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(java.lang.String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}
	
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDpobNm() {
        return this.dpobNm;
    }
    
    public void setDpobNm(java.lang.String dpobNm) {
        this.dpobNm = dpobNm;
    }
    
    public java.lang.String getDegtrResnRegnNum() {
        return this.degtrResnRegnNum;
    }
    
    public void setDegtrResnRegnNum(java.lang.String degtrResnRegnNum) {
        this.degtrResnRegnNum = degtrResnRegnNum;
    }
    
    public java.lang.String getDegtrNm() {
        return this.degtrNm;
    }
    
    public void setDegtrNm(java.lang.String degtrNm) {
        this.degtrNm = degtrNm;
    }
    
    public java.lang.String getBusoprRgstnNum() {
        return this.busoprRgstnNum;
    }
    
    public void setBusoprRgstnNum(java.lang.String busoprRgstnNum) {
        this.busoprRgstnNum = busoprRgstnNum;
    }
    
    public java.lang.String getCorpRgstnNum() {
        return this.corpRgstnNum;
    }
    
    public void setCorpRgstnNum(java.lang.String corpRgstnNum) {
        this.corpRgstnNum = corpRgstnNum;
    }
    
    public java.lang.String getCorpDivCd() {
        return this.corpDivCd;
    }
    
    public void setCorpDivCd(java.lang.String corpDivCd) {
        this.corpDivCd = corpDivCd;
    }
    
    public java.lang.String getDpobZpcd() {
        return this.dpobZpcd;
    }
    
    public void setDpobZpcd(java.lang.String dpobZpcd) {
        this.dpobZpcd = dpobZpcd;
    }
    
    public java.lang.String getDpobFndtnAddr() {
        return this.dpobFndtnAddr;
    }
    
    public void setDpobFndtnAddr(java.lang.String dpobFndtnAddr) {
        this.dpobFndtnAddr = dpobFndtnAddr;
    }
    
    public java.lang.String getDpobDtlPatrAddr() {
        return this.dpobDtlPatrAddr;
    }
    
    public void setDpobDtlPatrAddr(java.lang.String dpobDtlPatrAddr) {
        this.dpobDtlPatrAddr = dpobDtlPatrAddr;
    }
    
    public java.lang.String getDpobPhnNum() {
        return this.dpobPhnNum;
    }
    
    public void setDpobPhnNum(java.lang.String dpobPhnNum) {
        this.dpobPhnNum = dpobPhnNum;
    }
    
    public java.lang.String getDpobFaxNum() {
        return this.dpobFaxNum;
    }
    
    public void setDpobFaxNum(java.lang.String dpobFaxNum) {
        this.dpobFaxNum = dpobFaxNum;
    }
    
    public java.lang.String getDpobSealWrdNm() {
        return this.dpobSealWrdNm;
    }
    
    public void setDpobSealWrdNm(java.lang.String dpobSealWrdNm) {
        this.dpobSealWrdNm = dpobSealWrdNm;
    }
    
    public java.lang.String getDpobSealRftaNm() {
        return this.dpobSealRftaNm;
    }
    
    public void setDpobSealRftaNm(java.lang.String dpobSealRftaNm) {
        this.dpobSealRftaNm = dpobSealRftaNm;
    }
    
    public java.lang.String getDpobSealFlNm() {
        return this.dpobSealFlNm;
    }
    
    public void setDpobSealFlNm(java.lang.String dpobSealFlNm) {
        this.dpobSealFlNm = dpobSealFlNm;
    }
    
    public java.lang.String getDpobFndtnUseYn() {
        return this.dpobFndtnUseYn;
    }
    
    public void setDpobFndtnUseYn(java.lang.String dpobFndtnUseYn) {
        this.dpobFndtnUseYn = dpobFndtnUseYn;
    }
    
    public java.lang.String getHlthInsrSym() {
        return this.hlthInsrSym;
    }
    
    public void setHlthInsrSym(java.lang.String hlthInsrSym) {
        this.hlthInsrSym = hlthInsrSym;
    }
    
    public java.lang.String getNatPennSym() {
        return this.natPennSym;
    }
    
    public void setNatPennSym(java.lang.String natPennSym) {
        this.natPennSym = natPennSym;
    }
    
    public java.lang.String getUmytInsrSym() {
        return this.umytInsrSym;
    }
    
    public void setUmytInsrSym(java.lang.String umytInsrSym) {
        this.umytInsrSym = umytInsrSym;
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
	 * Comment : 원본 주민등록번호
	 * @fn java.lang.String getDegtrSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the degtrSecResnNum get
	 */
	public java.lang.String getDegtrSecResnNum() {
		return degtrSecResnNum;
	}

	/**
	 * Comment : 원본 주민등록 번호 
	 *@fn void setDegtrSecResnNum(java.lang.String degtrSecResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param degtrSecResnNum the degtrSecResnNum to set
	 */
	public void setDegtrSecResnNum(java.lang.String degtrSecResnNum) {
		this.degtrSecResnNum = degtrSecResnNum;
	}
    
}
