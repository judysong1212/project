package com.app.smrmf.infc.diligence.server.vo;

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
public class InfcPkgDlgn0200VO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 근태초과근무년월 : dilnlazExceDutyYrMnth */
    private java.lang.String dilnlazExceDutyYrMnth;

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

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set null : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
    private java.lang.String dilnlazPubcHodyDutyTm;

    /** set 근태_휴일총연장근무시간 : dilnlazHodyTotNtotTm */
    private java.lang.String dilnlazHodyTotNtotTm;

    /** set 시분단위적용여부 : hhmiPrcYn */
    private java.lang.String hhmiPrcYn;

    /** DILNLAZ_HODY_DUTY_YN */
    private java.lang.String dilnlazHodyDutyYn;
    
    /** DILNLAZ_HODY_DUTY_TM */
    private java.lang.String dilnlazHodyDutyTm;
       
    /** 관리부서코드  mangeDeptCd */
    private java.lang.String  mangeDeptCd;


	/** set 복무통합구분값 : typOccuBusinVal */
    private java.lang.String typOccuBusinVal;

    /**
	 * Comment : 관리부서코드
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 13. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 관리부서코드
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2018 2018. 3. 13. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	 public java.lang.String getTypOccuBusinVal() {
		return typOccuBusinVal;
	}

	public void setTypOccuBusinVal(java.lang.String typOccuBusinVal) {
		this.typOccuBusinVal = typOccuBusinVal;
	}
	
    
    /**
	 * Comment : 
	 * @fn java.lang.String getDilnlazHodyTotNtotTm()
	 * @brief date:2017 2017. 4. 20. user:paygen
	 * @return the dilnlazHodyTotNtotTm get
	 */
	public java.lang.String getDilnlazHodyTotNtotTm() {
		return dilnlazHodyTotNtotTm;
	}

	/**
	 * Comment : 
	 *@fn void setDilnlazHodyTotNtotTm(java.lang.String dilnlazHodyTotNtotTm)
	 *@brief date:2017 2017. 4. 20. user:paygen
	 *@param dilnlazHodyTotNtotTm the dilnlazHodyTotNtotTm to set
	 */
	public void setDilnlazHodyTotNtotTm(java.lang.String dilnlazHodyTotNtotTm) {
		this.dilnlazHodyTotNtotTm = dilnlazHodyTotNtotTm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHhmiPrcYn()
	 * @brief date:2017 2017. 4. 20. user:paygen
	 * @return the hhmiPrcYn get
	 */
	public java.lang.String getHhmiPrcYn() {
		return hhmiPrcYn;
	}

	/**
	 * Comment : 
	 *@fn void setHhmiPrcYn(java.lang.String hhmiPrcYn)
	 *@brief date:2017 2017. 4. 20. user:paygen
	 *@param hhmiPrcYn the hhmiPrcYn to set
	 */
	public void setHhmiPrcYn(java.lang.String hhmiPrcYn) {
		this.hhmiPrcYn = hhmiPrcYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDilnlazPubcHodyDutyTm()
	 * @brief date:2016 2016. 5. 25. user:Administrator
	 * @return the dilnlazPubcHodyDutyTm get
	 */
	public java.lang.String getDilnlazPubcHodyDutyTm() {
		return dilnlazPubcHodyDutyTm;
	}

	/**
	 * Comment : 
	 *@fn void setDilnlazPubcHodyDutyTm(java.lang.String dilnlazPubcHodyDutyTm)
	 *@brief date:2016 2016. 5. 25. user:Administrator
	 *@param dilnlazPubcHodyDutyTm the dilnlazPubcHodyDutyTm to set
	 */
	public void setDilnlazPubcHodyDutyTm(java.lang.String dilnlazPubcHodyDutyTm) {
		this.dilnlazPubcHodyDutyTm = dilnlazPubcHodyDutyTm;
	}

	
    
     
    /**
	 * Comment : 
	 * @fn java.lang.String getDilnlazHodyDutyYn()
	 * @brief date:2016 2016. 5. 25. user:Administrator
	 * @return the dilnlazHodyDutyYn get
	 */
	public java.lang.String getDilnlazHodyDutyYn() {
		return dilnlazHodyDutyYn;
	}

	/**
	 * Comment : 
	 *@fn void setDilnlazHodyDutyYn(java.lang.String dilnlazHodyDutyYn)
	 *@brief date:2016 2016. 5. 25. user:Administrator
	 *@param dilnlazHodyDutyYn the dilnlazHodyDutyYn to set
	 */
	public void setDilnlazHodyDutyYn(java.lang.String dilnlazHodyDutyYn) {
		this.dilnlazHodyDutyYn = dilnlazHodyDutyYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDilnlazHodyDutyTm()
	 * @brief date:2016 2016. 5. 25. user:Administrator
	 * @return the dilnlazHodyDutyTm get
	 */
	public java.lang.String getDilnlazHodyDutyTm() {
		return dilnlazHodyDutyTm;
	}

	/**
	 * Comment : 
	 *@fn void setDilnlazHodyDutyTm(java.lang.String dilnlazHodyDutyTm)
	 *@brief date:2016 2016. 5. 25. user:Administrator
	 *@param dilnlazHodyDutyTm the dilnlazHodyDutyTm to set
	 */
	public void setDilnlazHodyDutyTm(java.lang.String dilnlazHodyDutyTm) {
		this.dilnlazHodyDutyTm = dilnlazHodyDutyTm;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 4, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 4, 2015 user:leeheuisung
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
