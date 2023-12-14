package com.app.exterms.diligence.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Dlgn0200VO.java
 * @Description : Dlgn0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0200VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    private java.lang.String dilnlazExceDutyYrMnth;
    
	/** set 근태_휴일총연장근무시간 : dilnlazHodyTotNtotTm */
	private java.lang.String dilnlazHodyTotNtotTm;
	
	/** set 복무통합구분값 : typOccuBusinVal */
	private java.lang.String typOccuBusinVal;

	public java.lang.String getTypOccuBusinVal() {
		return typOccuBusinVal;
	}

	public void setTypOccuBusinVal(java.lang.String typOccuBusinVal) {
		this.typOccuBusinVal = typOccuBusinVal;
	}
    
	
    public java.lang.String getDilnlazHodyTotNtotTm() {
		return dilnlazHodyTotNtotTm;
	}

	public void setDilnlazHodyTotNtotTm(java.lang.String dilnlazHodyTotNtotTm) {
		this.dilnlazHodyTotNtotTm = dilnlazHodyTotNtotTm;
	}
    
    /** DILNLAZ_PUBC_HODY_DUTY_TM */
    private java.lang.String dilnlazPubcHodyDutyTm;
    

    public java.lang.String getDilnlazPubcHodyDutyTm() {
		return dilnlazPubcHodyDutyTm;
	}

	public void setDilnlazPubcHodyDutyTm(java.lang.String dilnlazPubcHodyDutyTm) {
		this.dilnlazPubcHodyDutyTm = dilnlazPubcHodyDutyTm;
	}

	/** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
    private java.lang.String dilnlazExceDutyBgnnDt;

    /** set 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
    private java.lang.String dilnlazExceDutyEndDt;

    /** set 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    private java.lang.String dilnlazPubcHodyDutyNumDys;

    /** set 근태_토요근무일수 : dilnlazSatDutyNumDys */
    private java.lang.String dilnlazSatDutyNumDys;

    /** set 근태_총야근일수 : dilnlazTotNtotNumDys */
    private java.lang.String dilnlazTotNtotNumDys;

    /** set 근태_총야근시간 : dilnlazTotNtotTm */
    private java.lang.String dilnlazTotNtotTm;

    /** set 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
    private java.lang.String dilnlazFndtnTmRstDutyTm;

    /** set 근태_시간외근무시간 : dilnlazTmRstDutyTm */
    private java.lang.String dilnlazTmRstDutyTm;

    /** set 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
    private java.lang.String dilnlazTotTmRstDutyTm;

    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    private java.lang.String dilnlazDdlnePrcsYn;

    /** set 근태_비고내용 : dilnlazNoteCtnt */
    private java.lang.String dilnlazNoteCtnt;

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

	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;


    
    /**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getResnRegnNum() {
        return resnRegnNum;
    }

    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }  
    
    public java.lang.String getDilnlazExceDutyYrMnth() {
        return this.dilnlazExceDutyYrMnth;
    }
    
    public void setDilnlazExceDutyYrMnth(java.lang.String dilnlazExceDutyYrMnth) {
        this.dilnlazExceDutyYrMnth = dilnlazExceDutyYrMnth;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
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
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getDilnlazExceDutyBgnnDt() {
        return this.dilnlazExceDutyBgnnDt;
    }
    
    public void setDilnlazExceDutyBgnnDt(java.lang.String dilnlazExceDutyBgnnDt) {
        this.dilnlazExceDutyBgnnDt = dilnlazExceDutyBgnnDt;
    }
    
    public java.lang.String getDilnlazExceDutyEndDt() {
        return this.dilnlazExceDutyEndDt;
    }
    
    public void setDilnlazExceDutyEndDt(java.lang.String dilnlazExceDutyEndDt) {
        this.dilnlazExceDutyEndDt = dilnlazExceDutyEndDt;
    }
    
    public java.lang.String getDilnlazPubcHodyDutyNumDys() {
        return this.dilnlazPubcHodyDutyNumDys;
    }
    
    public void setDilnlazPubcHodyDutyNumDys(java.lang.String dilnlazPubcHodyDutyNumDys) {
        this.dilnlazPubcHodyDutyNumDys = dilnlazPubcHodyDutyNumDys;
    }
    
    public java.lang.String getDilnlazSatDutyNumDys() {
        return this.dilnlazSatDutyNumDys;
    }
    
    public void setDilnlazSatDutyNumDys(java.lang.String dilnlazSatDutyNumDys) {
        this.dilnlazSatDutyNumDys = dilnlazSatDutyNumDys;
    }
    
    public java.lang.String getDilnlazTotNtotNumDys() {
        return this.dilnlazTotNtotNumDys;
    }
    
    public void setDilnlazTotNtotNumDys(java.lang.String dilnlazTotNtotNumDys) {
        this.dilnlazTotNtotNumDys = dilnlazTotNtotNumDys;
    }
    
    public java.lang.String getDilnlazTotNtotTm() {
        return this.dilnlazTotNtotTm;
    }
    
    public void setDilnlazTotNtotTm(java.lang.String dilnlazTotNtotTm) {
        this.dilnlazTotNtotTm = dilnlazTotNtotTm;
    }
    
    public java.lang.String getDilnlazFndtnTmRstDutyTm() {
        return this.dilnlazFndtnTmRstDutyTm;
    }
    
    public void setDilnlazFndtnTmRstDutyTm(java.lang.String dilnlazFndtnTmRstDutyTm) {
        this.dilnlazFndtnTmRstDutyTm = dilnlazFndtnTmRstDutyTm;
    }
    
    public java.lang.String getDilnlazTmRstDutyTm() {
        return this.dilnlazTmRstDutyTm;
    }
    
    public void setDilnlazTmRstDutyTm(java.lang.String dilnlazTmRstDutyTm) {
        this.dilnlazTmRstDutyTm = dilnlazTmRstDutyTm;
    }
    
    public java.lang.String getDilnlazTotTmRstDutyTm() {
        return this.dilnlazTotTmRstDutyTm;
    }
    
    public void setDilnlazTotTmRstDutyTm(java.lang.String dilnlazTotTmRstDutyTm) {
        this.dilnlazTotTmRstDutyTm = dilnlazTotTmRstDutyTm;
    }
    
    public java.lang.String getDilnlazDdlnePrcsYn() {
        return this.dilnlazDdlnePrcsYn;
    }
    
    public void setDilnlazDdlnePrcsYn(java.lang.String dilnlazDdlnePrcsYn) {
        this.dilnlazDdlnePrcsYn = dilnlazDdlnePrcsYn;
    }
    
    public java.lang.String getDilnlazNoteCtnt() {
        return this.dilnlazNoteCtnt;
    }
    
    public void setDilnlazNoteCtnt(java.lang.String dilnlazNoteCtnt) {
        this.dilnlazNoteCtnt = dilnlazNoteCtnt;
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
