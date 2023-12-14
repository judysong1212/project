package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr3100VO.java
 * @Description : Insr3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5400DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 고용시작일(귀속년도) : srhHlthInsrYr */
	private java.lang.String srhHlthInsrYr;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 부서명 : deptNm */
	private java.lang.String deptNm;

	/** set 성명 : acntHodrNm */
	private java.lang.String acntHodrNm;

	/** set 주민등록번호 : resnRegnNum */
	private java.lang.String resnRegnNum;

	/** set 보험료부과구분 : prmmIposDivCd */
	private java.lang.String prmmIposDivCd;

	/** set 산재보험사업장코드 : idtlDpobCd */
	private java.lang.String idtlDpobCd;

	/** set 산재보험정산년도 : idtlAccdtInsurClutYr */
	private java.lang.String idtlAccdtInsurClutYr;

	/** set 산재보험시스템키 : idtlSystemkey */
	private java.lang.String idtlSystemkey;

	/** set 산재보험고용일련번호 : emymtSeilNum1 */
	private java.lang.String emymtSeilNum1;

	/** set 산재취득일자 : idtlAccdtInsurAqtnDt */
	private java.lang.String idtlAccdtInsurAqtnDt;

	/** set 산재상실일자 : idtlAccdtInsurLssDt */
	private java.lang.String idtlAccdtInsurLssDt;

	/** set 산재보수총액 : idtlAccdtPayTotAmnt */
	//private Long idtlAccdtPayTotAmnt;
	private java.lang.String idtlAccdtPayTotAmnt;

	/** set 고용보험사업장코드 : umytDpobCd */
	private java.lang.String umytDpobCd;

	/** set 고용보험정산년도 : umytInsrClutYr */
	private java.lang.String umytInsrClutYr;

	/** set 고용보험시스템키 : umytSystemkey */
	private java.lang.String umytSystemkey;

	/** set 고용보험고용일련번호 : emymtSeilNum2 */
	private java.lang.String emymtSeilNum2;

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	private java.lang.String umytInsrAqtnDt;

	/** set 고용보험상실일자 : umytInsrLssDt */
	private java.lang.String umytInsrLssDt;

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	//private Long umytInsrPayTotAmnt;
	private java.lang.String umytInsrPayTotAmnt;

	private java.lang.String  typOccuCd;
	private java.lang.String typOccuNm;
	private java.lang.String  dtilOccuClsDivCd; 







	/** set 사업장코드 : dpobCd */
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    /** set 귀속년도 : hlthInsrYr */
    public java.lang.String getSrhHlthInsrYr() {
        return this.srhHlthInsrYr;
    }
    
    public void setSrhHlthInsrYr(java.lang.String srhHlthInsrYr) {
        this.srhHlthInsrYr = srhHlthInsrYr;
    }

    /** set SYSTEMKEY : systemkey */
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    /** set 부서명 : deptNm */
    public java.lang.String getDeptNm() {
    	return this.deptNm;
    }
    
    public void setDeptNm(java.lang.String deptNm) {
    	this.deptNm = deptNm;
    }

    /** set 성명 : acntHodrNm */
    public java.lang.String geTacntHodrNm() {
    	return this.acntHodrNm;
    }
    
    public void seTacntHodrNm(java.lang.String acntHodrNm) {
    	this.acntHodrNm = acntHodrNm;
    }

    /** set 주민등록번호 : resnRegnNum */
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }

    /** set 보험료부과구분 : prmmIposDivCd */
    public java.lang.String getPrmmIposDivCd() {
        return this.prmmIposDivCd;
    }
    
    public void setPrmmIposDivCd(java.lang.String prmmIposDivCd) {
        this.prmmIposDivCd = prmmIposDivCd;
    }

    /** set 고용보험사업장코드 : umytDpobCd */
    public java.lang.String getUmytDpobCd() {
        return this.umytDpobCd;
    }
    
    public void setUmytDpobCd(java.lang.String umytDpobCd) {
        this.umytDpobCd = umytDpobCd;
    }

    /** set 고용보험정산년도 : umytInsrClutYr */
    public java.lang.String getUmytInsrClutYr() {
        return this.umytInsrClutYr;
    }
    
    public void setUmytInsrClutYr(java.lang.String umytInsrClutYr) {
        this.umytInsrClutYr = umytInsrClutYr;
    }

    /** set 고용보험시스템키 : umytSystemkey */
    public java.lang.String getUmytSystemkey() {
        return this.umytSystemkey;
    }
    
    public void setUmytSystemkey(java.lang.String umytSystemkey) {
        this.umytSystemkey = umytSystemkey;
    }
    
    /** set 고용보험고용일련번호 : emymtSeilNum2 */
    public java.lang.String getEmymtSeilNum2() {
        return this.emymtSeilNum2;
    }
    
    public void setEmymtSeilNum2(java.lang.String emymtSeilNum2) {
        this.emymtSeilNum2 = emymtSeilNum2;
    }

    /** set 고용보험취득일자 : umytInsrAqtnDt */
    public java.lang.String getUmytInsrAqtnDt() {
        return this.umytInsrAqtnDt;
    }
    
    public void setUmytInsrAqtnDt(java.lang.String umytInsrAqtnDt) {
        this.umytInsrAqtnDt = umytInsrAqtnDt;
    }

    /** set 고용보험상실일자 : umytInsrLssDt */
    public java.lang.String getUmytInsrLssDt() {
        return this.umytInsrLssDt;
    }
    
    public void setUmytInsrLssDt(java.lang.String umytInsrLssDt) {
        this.umytInsrLssDt = umytInsrLssDt;
    }

    /** set 고용보험보수총액 : umytInsrLssDt */
    //public Long getUmytInsrPayTotAmnt() {
    public java.lang.String getUmytInsrPayTotAmnt() {
        return this.umytInsrPayTotAmnt;
    }
    
    //public void setUmytInsrPayTotAmnt(Long umytInsrPayTotAmnt) {
    public void setUmytInsrPayTotAmnt(java.lang.String umytInsrPayTotAmnt) {
        this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
    }
    
    /** set 산재보험사업장코드 : idtlDpobCd */
    public java.lang.String getIdtlDpobCd() {
        return this.idtlDpobCd;
    }
    
    public void setIdtlDpobCd(java.lang.String idtlDpobCd) {
        this.idtlDpobCd = idtlDpobCd;
    }

    /** set 산재보험정산년도 : idtlAccdtInsurClutYr */
    public java.lang.String getIdtlAccdtInsurClutYr() {
        return this.idtlAccdtInsurClutYr;
    }
    
    public void setIdtlAccdtInsurClutYr(java.lang.String idtlAccdtInsurClutYr) {
        this.idtlAccdtInsurClutYr = idtlAccdtInsurClutYr;
    }

    /** set 산재보험시스템키 : idtlSystemkey */
    public java.lang.String getIdtlSystemkey() {
        return this.idtlSystemkey;
    }
    
    public void setIdtlSystemkey(java.lang.String idtlSystemkey) {
        this.idtlSystemkey = idtlSystemkey;
    }

    /** set 산재보험고용일련번호 : emymtSeilNum1 */
    public java.lang.String getEmymtSeilNum1() {
        return this.emymtSeilNum1;
    }
    
    public void setEmymtSeilNum1(java.lang.String emymtSeilNum1) {
        this.emymtSeilNum1 = emymtSeilNum1;
    }

    /** set 산재취득일자 : idtlAccdtInsurAqtnDt */
    public java.lang.String getIdtlAccdtInsurAqtnDt() {
        return this.idtlAccdtInsurAqtnDt;
    }
    
    public void setIdtlAccdtInsurAqtnDt(java.lang.String idtlAccdtInsurAqtnDt) {
        this.idtlAccdtInsurAqtnDt = idtlAccdtInsurAqtnDt;
    }

    /** set 산재상실일자 : idtlAccdtInsurLssDt */
    public java.lang.String getIdtlAccdtInsurLssDt() {
        return this.idtlAccdtInsurLssDt;
    }
    
    public void setIdtlAccdtInsurLssDt(java.lang.String idtlAccdtInsurLssDt) {
        this.idtlAccdtInsurLssDt = idtlAccdtInsurLssDt;
    }

    /** set 산재보수총액 : idtlAccdtPayTotAmnt */
    //public Long getIdtlAccdtPayTotAmnt() {
    public java.lang.String getIdtlAccdtPayTotAmnt() {
        return this.idtlAccdtPayTotAmnt;
    }
    
    //public void setIdtlAccdtPayTotAmnt(Long idtlAccdtPayTotAmnt) {
    public void setIdtlAccdtPayTotAmnt(java.lang.String idtlAccdtPayTotAmnt) {
        this.idtlAccdtPayTotAmnt = idtlAccdtPayTotAmnt;
    }

    /** set  : typOccuCd */
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }

    /** set  : typOccuNm */
    public java.lang.String getTypOccuNm() {
        return this.typOccuNm;
    }
    
    public void setTypOccuNm(java.lang.String typOccuNm) {
        this.typOccuNm = typOccuNm;
    }

    /** set  : dtilOccuClsDivCd */
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
}
