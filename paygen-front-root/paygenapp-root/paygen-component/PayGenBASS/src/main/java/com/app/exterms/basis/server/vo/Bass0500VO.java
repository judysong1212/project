package com.app.exterms.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0500VO.java
 * @Description : Bass0500 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0500VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** BUSIN_APPTN_YR */
    private java.lang.String businApptnYr;
    
    /** BUSIN_CD */
    private java.lang.String businCd;
    
    /** BUSIN_NM */
    private java.lang.String businNm;
    
    /** BUSIN_EMYMT_TYP_OCCU_CD */
    private java.lang.String businEmymtTypOccuCd;
    
    /** BUSIN_REPBTY_EMP_NUM */
    private java.lang.String businRepbtyEmpNum;
    
    /** IDTL_ACCDT_INSUR_APMRT */
    private java.math.BigDecimal idtlAccdtInsurApmrt;
    
    /** SPITY_CTNT */
    private java.lang.String spityCtnt;
    
    /** NAT_PENN_SYM */
    private java.lang.String natPennSym;
    
    /** HLTH_INSR_SYM */
    private java.lang.String hlthInsrSym;
    
    /** UMYT_INSR_SYM */
    private java.lang.String umytInsrSym;
    
    /** IDTL_ACCDT_INSUR_SYM */
    private java.lang.String idtlAccdtInsurSym;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    
    /** set null : businEddt */
    private java.lang.String businEddt;

    /** set null : businStdt */
    private java.lang.String businStdt;

    /** set 건강보험영업소기호 : hlthInsrOfceSym */
    private java.lang.String hlthInsrOfceSym;

    /** set 근무일수 : businDutyNumDys */
    private java.math.BigDecimal businDutyNumDys;
 
    /** PAY_MANGE_DEPT_USE_YN */
    private java.lang.String payMangeDeptUseYn;
    
    /** MANGE_DEPT_CD */
    private java.lang.String mangeDeptCd;
  
    
    /** REPBTY_BUSIN_DIV_CD */
    private java.lang.String repbtyBusinDivCd;
    
   
    
    /** DTIL_OCCLS_APPTN_UCST_CD */
    private java.lang.String dtilOcclsApptnUcstCd;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** TXTN_FRM_DIV_CD */
    private java.lang.String txtnFrmDivCd;
    
    /** UNT_DPOB_CD */
    private java.lang.String untDpobCd;
    
    /** SOC_INSR_SYM_INTTN_CD */
    private java.lang.String socInsrSymInttnCd;
    
    /** BUSIN_ACC_CD */
    private java.lang.String businAccCd;
    
    /** HHRK_DEPT_CD_01 */
    private java.lang.String hhrkDeptCd01;
    
    /** HHRK_DEPT_CD_02 */
    private java.lang.String hhrkDeptCd02;
    
    /** BUSIN_USE_YN */
    private java.lang.String businUseYn;
    
  //개발_시간외근무 최대 인정시간_20201026
    private String dilnlazTmRstDutyTm;
    
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getPayMangeDeptUseYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the payMangeDeptUseYn get
	 */
	public java.lang.String getPayMangeDeptUseYn() {
		return payMangeDeptUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayMangeDeptUseYn(java.lang.String payMangeDeptUseYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param payMangeDeptUseYn the payMangeDeptUseYn to set
	 */
	public void setPayMangeDeptUseYn(java.lang.String payMangeDeptUseYn) {
		this.payMangeDeptUseYn = payMangeDeptUseYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRepbtyBusinDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the repbtyBusinDivCd get
	 */
	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param repbtyBusinDivCd the repbtyBusinDivCd to set
	 */
	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOcclsApptnUcstCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the dtilOcclsApptnUcstCd get
	 */
	public java.lang.String getDtilOcclsApptnUcstCd() {
		return dtilOcclsApptnUcstCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param dtilOcclsApptnUcstCd the dtilOcclsApptnUcstCd to set
	 */
	public void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd) {
		this.dtilOcclsApptnUcstCd = dtilOcclsApptnUcstCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTxtnFrmDivCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the txtnFrmDivCd get
	 */
	public java.lang.String getTxtnFrmDivCd() {
		return txtnFrmDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setTxtnFrmDivCd(java.lang.String txtnFrmDivCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param txtnFrmDivCd the txtnFrmDivCd to set
	 */
	public void setTxtnFrmDivCd(java.lang.String txtnFrmDivCd) {
		this.txtnFrmDivCd = txtnFrmDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUntDpobCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the untDpobCd get
	 */
	public java.lang.String getUntDpobCd() {
		return untDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setUntDpobCd(java.lang.String untDpobCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param untDpobCd the untDpobCd to set
	 */
	public void setUntDpobCd(java.lang.String untDpobCd) {
		this.untDpobCd = untDpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSocInsrSymInttnCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the socInsrSymInttnCd get
	 */
	public java.lang.String getSocInsrSymInttnCd() {
		return socInsrSymInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setSocInsrSymInttnCd(java.lang.String socInsrSymInttnCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param socInsrSymInttnCd the socInsrSymInttnCd to set
	 */
	public void setSocInsrSymInttnCd(java.lang.String socInsrSymInttnCd) {
		this.socInsrSymInttnCd = socInsrSymInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinAccCd()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the businAccCd get
	 */
	public java.lang.String getBusinAccCd() {
		return businAccCd;
	}

	/**
	 * Comment : 
	 *@fn void setBusinAccCd(java.lang.String businAccCd)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param businAccCd the businAccCd to set
	 */
	public void setBusinAccCd(java.lang.String businAccCd) {
		this.businAccCd = businAccCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHhrkDeptCd01()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the hhrkDeptCd01 get
	 */
	public java.lang.String getHhrkDeptCd01() {
		return hhrkDeptCd01;
	}

	/**
	 * Comment : 
	 *@fn void setHhrkDeptCd01(java.lang.String hhrkDeptCd01)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param hhrkDeptCd01 the hhrkDeptCd01 to set
	 */
	public void setHhrkDeptCd01(java.lang.String hhrkDeptCd01) {
		this.hhrkDeptCd01 = hhrkDeptCd01;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getHhrkDeptCd02()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the hhrkDeptCd02 get
	 */
	public java.lang.String getHhrkDeptCd02() {
		return hhrkDeptCd02;
	}

	/**
	 * Comment : 
	 *@fn void setHhrkDeptCd02(java.lang.String hhrkDeptCd02)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param hhrkDeptCd02 the hhrkDeptCd02 to set
	 */
	public void setHhrkDeptCd02(java.lang.String hhrkDeptCd02) {
		this.hhrkDeptCd02 = hhrkDeptCd02;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinUseYn()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the businUseYn get
	 */
	public java.lang.String getBusinUseYn() {
		return businUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setBusinUseYn(java.lang.String businUseYn)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param businUseYn the businUseYn to set
	 */
	public void setBusinUseYn(java.lang.String businUseYn) {
		this.businUseYn = businUseYn;
	}

	public java.lang.String getBusinEddt() {
		return businEddt;
	}

	public void setBusinEddt(java.lang.String businEddt) {
		this.businEddt = businEddt;
	}

	public java.lang.String getBusinStdt() {
		return businStdt;
	}

	public void setBusinStdt(java.lang.String businStdt) {
		this.businStdt = businStdt;
	}

	public java.lang.String getHlthInsrOfceSym() {
		return hlthInsrOfceSym;
	}

	public void setHlthInsrOfceSym(java.lang.String hlthInsrOfceSym) {
		this.hlthInsrOfceSym = hlthInsrOfceSym;
	}

	public java.math.BigDecimal getBusinDutyNumDys() {
		return businDutyNumDys;
	}

	public void setBusinDutyNumDys(java.math.BigDecimal businDutyNumDys) {
		this.businDutyNumDys = businDutyNumDys;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinApptnYr() {
        return this.businApptnYr;
    }
    
    public void setBusinApptnYr(java.lang.String businApptnYr) {
        this.businApptnYr = businApptnYr;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getBusinNm() {
        return this.businNm;
    }
    
    public void setBusinNm(java.lang.String businNm) {
        this.businNm = businNm;
    }
    
    public java.lang.String getBusinEmymtTypOccuCd() {
        return this.businEmymtTypOccuCd;
    }
    
    public void setBusinEmymtTypOccuCd(java.lang.String businEmymtTypOccuCd) {
        this.businEmymtTypOccuCd = businEmymtTypOccuCd;
    }
    
    public java.lang.String getBusinRepbtyEmpNum() {
        return this.businRepbtyEmpNum;
    }
    
    public void setBusinRepbtyEmpNum(java.lang.String businRepbtyEmpNum) {
        this.businRepbtyEmpNum = businRepbtyEmpNum;
    }
    
    public java.math.BigDecimal getIdtlAccdtInsurApmrt() {
        return this.idtlAccdtInsurApmrt;
    }
    
    public void setIdtlAccdtInsurApmrt(java.math.BigDecimal idtlAccdtInsurApmrt) {
        this.idtlAccdtInsurApmrt = idtlAccdtInsurApmrt;
    }
    
    public java.lang.String getSpityCtnt() {
        return this.spityCtnt;
    }
    
    public void setSpityCtnt(java.lang.String spityCtnt) {
        this.spityCtnt = spityCtnt;
    }
    
    public java.lang.String getNatPennSym() {
        return this.natPennSym;
    }
    
    public void setNatPennSym(java.lang.String natPennSym) {
        this.natPennSym = natPennSym;
    }
    
    public java.lang.String getHlthInsrSym() {
        return this.hlthInsrSym;
    }
    
    public void setHlthInsrSym(java.lang.String hlthInsrSym) {
        this.hlthInsrSym = hlthInsrSym;
    }
    
    public java.lang.String getUmytInsrSym() {
        return this.umytInsrSym;
    }
    
    public void setUmytInsrSym(java.lang.String umytInsrSym) {
        this.umytInsrSym = umytInsrSym;
    }
    
    public java.lang.String getIdtlAccdtInsurSym() {
        return this.idtlAccdtInsurSym;
    }
    
    public void setIdtlAccdtInsurSym(java.lang.String idtlAccdtInsurSym) {
        this.idtlAccdtInsurSym = idtlAccdtInsurSym;
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

	public String getDilnlazTmRstDutyTm() {
		return dilnlazTmRstDutyTm;
	}

	public void setDilnlazTmRstDutyTm(String dilnlazTmRstDutyTm) {
		this.dilnlazTmRstDutyTm = dilnlazTmRstDutyTm;
	}
    
}
