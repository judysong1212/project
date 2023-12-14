package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class Name : Insr5400VO.java
 * @Description : Insr5400VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5400VO implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Insr5400VO> insr5400List = new ArrayList<Insr5400VO>();

    public List<Insr5400VO> getInsr5400List() {
		return insr5400List;
	}

	public void setInsr5400List(List<Insr5400VO> insr5400List) {
		this.insr5400List = insr5400List;
	}

    /** DPOB_CD */
    private java.lang.String dpobCd;

    /** DEPT_NM */
    private java.lang.String deptNm;

    /** ACNT_HODR_NM */
    private java.lang.String acntHodrNm;

    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;

    /** PRMM_IPOS_DIV_CD */
    private java.lang.String prmmIposDivCd;

    /** IDTL_ACCDT_INSUR_AQTN_DT */
    private java.lang.String idtlAccdtInsurAqtnDt;

    /** IDTL_ACCDT_INSUR_LSS_DT */
    private java.lang.String idtlAccdtInsurLssDt;

    /** IDTL_ACCDT_PAY_TOT_AMNT */
    private java.lang.String idtlAccdtPayTotAmnt;

    /** UMYT_INSR_AQTN_DT */
    private java.lang.String umytInsrAqtnDt;

    /** UMYT_INSR_LSS_DT */
    private java.lang.String umytInsrLssDt;

    /** UMYT_INSR_PAY_TOT_AMNT */
    private java.lang.String umytInsrPayTotAmnt;

    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** TYP_OCCU_NM */
    private java.lang.String typOccuNm;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** PAY_CD_NM */
    private java.lang.String payCdNm;

	/** set 고용일련번호 : emymtSeilNum */
  	private Long  emymtSeilNum;
    
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    

    
    
    
    
    
    
    
    
    
    
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getDeptNm() {
        return this.deptNm;
    }
        
    public void setDeptNm(java.lang.String deptNm) {
        this.deptNm = deptNm;
    }

    public java.lang.String getAcntHodrNm() {
        return this.acntHodrNm;
    }

    public void setAcntHodrNm(java.lang.String acntHodrNm) {
        this.acntHodrNm = acntHodrNm;
    }
    
    

    
    
//    public Long getNatPennSeilNum() {
//        return this.natPennSeilNum;
//    }
//    
//    public void setNatPennSeilNum(Long natPennSeilNum) {
//        this.natPennSeilNum = natPennSeilNum;
//    }
    
    
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }

    public java.lang.String getPrmmIposDivCd() {
        return this.prmmIposDivCd;
    }
    
    public void setPrmmIposDivCd(java.lang.String prmmIposDivCd) {
        this.prmmIposDivCd = prmmIposDivCd;
    }

    public java.lang.String getIdtlAccdtInsurAqtnDt() {
        return this.idtlAccdtInsurAqtnDt;
    }
    
    public void setIdtlAccdtInsurAqtnDt(java.lang.String prmmIposDivCd) {
        this.idtlAccdtInsurAqtnDt = prmmIposDivCd;
    }

    
    public java.lang.String getIdtlAccdtInsurLssDt() {
        return this.idtlAccdtInsurLssDt;
    }
    
    public void setIdtlAccdtInsurLssDt(java.lang.String idtlAccdtInsurLssDt) {
        this.idtlAccdtInsurLssDt = idtlAccdtInsurLssDt;
    }
    
    
    public java.lang.String getIdtlAccdtPayTotAmnt() {
        return this.idtlAccdtPayTotAmnt;
    }
    
    public void setIdtlAccdtPayTotAmnt(java.lang.String idtlAccdtPayTotAmnt) {
        this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
    }
    
    
    public java.lang.String getUmytInsrAqtnDt() {
        return this.umytInsrAqtnDt;
    }
    
    public void setUmytInsrAqtnDt(java.lang.String umytInsrAqtnDt) {
        this.umytInsrAqtnDt = umytInsrAqtnDt;
    }
    
    public java.lang.String getUmytInsrLssDt() {
        return this.umytInsrLssDt;
    }
    
    public void setUmytInsrLssDt(java.lang.String umytInsrLssDt) {
        this.umytInsrLssDt = umytInsrLssDt;
    }
    
    public java.lang.String getUmytInsrPayTotAmnt() {
        return this.umytInsrPayTotAmnt;
    }
    
    public void setUmytInsrPayTotAmnt(java.lang.String umytInsrPayTotAmnt) {
        this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getTypOccuNm() {
        return this.typOccuNm;
    }
    
    public void setTypOccuNm(java.lang.String typOccuNm) {
        this.typOccuCd = typOccuNm;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd =dtilOccuClsDivCd;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd =payCd;
    }
    
    public java.lang.String getPayCdNm() {
        return this.payCdNm;
    }
    
    public void setPayCdNm(java.lang.String payCdNm) {
        this.payCdNm =payCdNm;
    }
    
    /**
	 * Comment : 
	 * @fn Long getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(Long emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(Long emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }  
}
