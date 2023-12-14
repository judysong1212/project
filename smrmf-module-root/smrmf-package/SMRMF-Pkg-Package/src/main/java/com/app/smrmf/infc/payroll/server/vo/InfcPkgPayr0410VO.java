package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0410VO.java
 * @Description : Payr0410 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0410VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 급여년도 : payYr */
    private java.lang.String payYr;
    /** column 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;
    
    /** column SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.math.BigDecimal payrItemSeilNum;

    /** set 급여항목코드 : payrImcd */
    private java.lang.String payrImcd;

    /** set 항목명 : itemNm */
    private java.lang.String itemNm;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 지급공제유형코드 : pymtDducFrmCd */
    private java.lang.String pymtDducFrmCd;

    /** set 지급공제율 : pymtDducRate */
    private java.math.BigDecimal pymtDducRate;

    /** set 지급공제액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 과세구분코드 : txtnDivCd */
    private java.lang.String txtnDivCd;

    /** set 비과세율 : freeDtyRate */
    private java.math.BigDecimal freeDtyRate;

    /** set 비과세금액 : freeDtySum */
    private java.math.BigDecimal freeDtySum;

    /** set 1월 : jan */
    private java.lang.String jan;

    /** set 2월 : feb */
    private java.lang.String feb;

    /** set 3월 : mar */
    private java.lang.String mar;

    /** set 4월 : apr */
    private java.lang.String apr;

    /** set 5월 : may */
    private java.lang.String may;

    /** set 6월 : jun */
    private java.lang.String jun;

    /** set 7월 : jul */
    private java.lang.String jul;

    /** set 8월 : aug */
    private java.lang.String aug;

    /** set 9월 : sep */
    private java.lang.String sep;

    /** set 10월 : oct */
    private java.lang.String oct;

    /** set 11월 : nov */
    private java.lang.String nov;

    /** set 12월 : dec */
    private java.lang.String dec;

    /** set 정렬순서 : rngeOrd */
    private java.math.BigDecimal rngeOrd;

    /** set 급여항목사용여부 : payItemUseYn */
    private java.lang.String payItemUseYn;

    /** set 항목적용시작일자 : itemApptnBgnnDt */
    private java.lang.String itemApptnBgnnDt;

    /** set 항목적용종료일자 : itemApptnEndDt */
    private java.lang.String itemApptnEndDt;

    /** set 일월액구분코드 : dayMnthAmntDivCd */
    private java.lang.String dayMnthAmntDivCd;

    /** set 계산기준구분코드 : calcStdDivCd */
    private java.lang.String calcStdDivCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 통상임금여부 : usalyAmntYn */
    private java.lang.String usalyAmntYn;

    /** set 급여항목비고내용 : payItemNoteCtnt */
    private java.lang.String payItemNoteCtnt;

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
    
    /**  일자    */
    private java.lang.String payrIntoDt;
      
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
     
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
     
    private java.lang.String pyspLogSvcYrNumCd;
    
    /** UCST_SUM */
    private BigDecimal ucstSum;
    
    /** UCST_CALC_DIV_CD */
    private java.lang.String ucstCalcDivCd;
    
    /** UCST_PRNT_ORD */
    private BigDecimal ucstPrntOrd;
    
    /** UCST_DGM_BGNN_DT */
    private java.lang.String ucstDgmBgnnDt;
    
    /** UCST_DGM_END_DT */
    private java.lang.String ucstDgmEndDt;
    
    /** UCST_DGM_USE_YN */
    private java.lang.String ucstDgmUseYn;
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;
 
    /** set 계산수식내용 : calcStdFunc */
    private java.lang.String calcStdFunc;
    
    /** set 월통상임금액 : mnthUsalyAmntWag */
    private java.math.BigDecimal mnthUsalyAmntWag;

    /** set 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
    private java.math.BigDecimal mnthUsalyAmntAllwBnusSum;
    
    /** 입사일자 기준 근속년수 */
    private java.lang.String frstLogSvcYrNumCd;  
     
    /** set 단가금액02 : ucstSum02 */
    private java.math.BigDecimal ucstSum02;
    /** set 단가금액02 : ucstSum02 */
    private java.math.BigDecimal befUcstSum02;
    

    /** set 급여항목구간기준일자 : payrItemTrmStdDt */
    private java.lang.String payrItemTrmStdDt; 
    
    
    
    /**
	 * Comment : 용인 반장 환경미화원 이전근속년수  금액 
	 * @fn java.math.BigDecimal getBefUcstSum02()
	 * @brief date:2017 2017. 11. 8. user:atres
	 * @return the befUcstSum02 get
	 */
	public java.math.BigDecimal getBefUcstSum02() {
		return befUcstSum02;
	}

	/**
	 * Comment : 용인 반장 환경미화원 이전근속년수  금액 
	 *@fn void setBefUcstSum02(java.math.BigDecimal befUcstSum02)
	 *@brief date:2017 2017. 11. 8. user:atres
	 *@param befUcstSum02 the befUcstSum02 to set
	 */
	public void setBefUcstSum02(java.math.BigDecimal befUcstSum02) {
		this.befUcstSum02 = befUcstSum02;
	}

	/**
	 * Comment : 입사일자 기준 근속년수 
	 * @fn java.lang.String getFrstLogSvcYrNumCd()
	 * @brief date:2017 2017. 8. 2. user:atres
	 * @return the frstLogSvcYrNumCd get
	 */
	public java.lang.String getFrstLogSvcYrNumCd() {
		return frstLogSvcYrNumCd;
	}

	/**
	 * Comment : 입사일자 기준 근속년수 
	 *@fn void setFrstLogSvcYrNumCd(java.lang.String frstLogSvcYrNumCd)
	 *@brief date:2017 2017. 8. 2. user:atres
	 *@param frstLogSvcYrNumCd the frstLogSvcYrNumCd to set
	 */
	public void setFrstLogSvcYrNumCd(java.lang.String frstLogSvcYrNumCd) {
		this.frstLogSvcYrNumCd = frstLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrIntoDt()
	 * @brief date:2017 2017. 7. 18. user:atres
	 * @return the payrIntoDt get
	 */
	public java.lang.String getPayrIntoDt() {
		return payrIntoDt;
	}

	/**
	 * Comment : 
	 *@fn void setPayrIntoDt(java.lang.String payrIntoDt)
	 *@brief date:2017 2017. 7. 18. user:atres
	 *@param payrIntoDt the payrIntoDt to set
	 */
	public void setPayrIntoDt(java.lang.String payrIntoDt) {
		this.payrIntoDt = payrIntoDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 7. 18. user:atres
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2017 2017. 5. 30. user:atres
	 * @return the systemkey get
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2017 2017. 5. 30. user:atres
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getBefLogSvcYrNumCd() {
		return befLogSvcYrNumCd;
	}

	public void setBefLogSvcYrNumCd(java.lang.String befLogSvcYrNumCd) {
		this.befLogSvcYrNumCd = befLogSvcYrNumCd;
	}

	public java.lang.String getBefClssPayCmpttnStd() {
		return befClssPayCmpttnStd;
	}

	public void setBefClssPayCmpttnStd(java.lang.String befClssPayCmpttnStd) {
		this.befClssPayCmpttnStd = befClssPayCmpttnStd;
	}

	public java.math.BigDecimal getBefUcstSum() {
		return befUcstSum;
	}

	public void setBefUcstSum(java.math.BigDecimal befUcstSum) {
		this.befUcstSum = befUcstSum;
	}

	/** set 통상임금일급액 : usalyAmntPdyQnty */
    private java.math.BigDecimal usalyAmntPdyQnty;

    /** set 통상임금시급액 : usalyAmntHrwgQnty */
    private java.math.BigDecimal usalyAmntHrwgQnty; 
    
   
	/** set  : befLogSvcYrNumCd */
    private java.lang.String befLogSvcYrNumCd;
    
    /** set  : befClssPayCmpttnStd */
    private java.lang.String befClssPayCmpttnStd;
     
	 /** set   : befUcstSum */
    private java.math.BigDecimal befUcstSum; 
    
    
    public java.lang.String getPyspLogSvcYrNumCd() {
		return pyspLogSvcYrNumCd;
	}

	public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
		this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
	}
 

    public java.math.BigDecimal getMnthUsalyAmntWag() {
        return mnthUsalyAmntWag;
    }

    public void setMnthUsalyAmntWag(java.math.BigDecimal mnthUsalyAmntWag) {
        this.mnthUsalyAmntWag = mnthUsalyAmntWag;
    }

    public java.math.BigDecimal getMnthUsalyAmntAllwBnusSum() {
        return mnthUsalyAmntAllwBnusSum;
    }

    public void setMnthUsalyAmntAllwBnusSum(java.math.BigDecimal mnthUsalyAmntAllwBnusSum) {
        this.mnthUsalyAmntAllwBnusSum = mnthUsalyAmntAllwBnusSum;
    }

    public java.math.BigDecimal getUsalyAmntPdyQnty() {
        return usalyAmntPdyQnty;
    }

    public void setUsalyAmntPdyQnty(java.math.BigDecimal usalyAmntPdyQnty) {
        this.usalyAmntPdyQnty = usalyAmntPdyQnty;
    }

    public java.math.BigDecimal getUsalyAmntHrwgQnty() {
        return usalyAmntHrwgQnty;
    }

    public void setUsalyAmntHrwgQnty(java.math.BigDecimal usalyAmntHrwgQnty) {
        this.usalyAmntHrwgQnty = usalyAmntHrwgQnty;
    }

    public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getCalcStdFunc() {
        return calcStdFunc;
    }

    public void setCalcStdFunc(java.lang.String calcStdFunc) {
        this.calcStdFunc = calcStdFunc;
    }

    /**
	 * Comment : 
	 * @fn java.lang.String getPymtYrMnth()
	 * @brief date:2017 2017. 5. 30. user:atres
	 * @return the pymtYrMnth get
	 */
	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setPymtYrMnth(java.lang.String pymtYrMnth)
	 *@brief date:2017 2017. 5. 30. user:atres
	 *@param pymtYrMnth the pymtYrMnth to set
	 */
	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public BigDecimal getUcstSum() {
		return ucstSum;
	}

	public void setUcstSum(BigDecimal ucstSum) {
		this.ucstSum = ucstSum;
	}

	public java.lang.String getUcstCalcDivCd() {
		return ucstCalcDivCd;
	}

	public void setUcstCalcDivCd(java.lang.String ucstCalcDivCd) {
		this.ucstCalcDivCd = ucstCalcDivCd;
	}

	public BigDecimal getUcstPrntOrd() {
		return ucstPrntOrd;
	}

	public void setUcstPrntOrd(BigDecimal ucstPrntOrd) {
		this.ucstPrntOrd = ucstPrntOrd;
	}

	public java.lang.String getUcstDgmBgnnDt() {
		return ucstDgmBgnnDt;
	}

	public void setUcstDgmBgnnDt(java.lang.String ucstDgmBgnnDt) {
		this.ucstDgmBgnnDt = ucstDgmBgnnDt;
	}

	public java.lang.String getUcstDgmEndDt() {
		return ucstDgmEndDt;
	}

	public void setUcstDgmEndDt(java.lang.String ucstDgmEndDt) {
		this.ucstDgmEndDt = ucstDgmEndDt;
	}

	public java.lang.String getUcstDgmUseYn() {
		return ucstDgmUseYn;
	}

	public void setUcstDgmUseYn(java.lang.String ucstDgmUseYn) {
		this.ucstDgmUseYn = ucstDgmUseYn;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
     
    
    public java.lang.String getPayYr() {
        return payYr;
    }

    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }

    public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
        return typOccuGrdeMppgSeilNum;
    }

    public void setTypOccuGrdeMppgSeilNum(java.math.BigDecimal typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }

    public java.math.BigDecimal getPayrItemSeilNum() {
        return payrItemSeilNum;
    }

    public void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }

    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getPayrImcd() {
        return this.payrImcd;
    }
    
    public void setPayrImcd(java.lang.String payrImcd) {
        this.payrImcd = payrImcd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getItemNm() {
        return this.itemNm;
    }
    
    public void setItemNm(java.lang.String itemNm) {
        this.itemNm = itemNm;
    }
    
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    public java.lang.String getPymtDducFrmCd() {
        return this.pymtDducFrmCd;
    }
    
    public void setPymtDducFrmCd(java.lang.String pymtDducFrmCd) {
        this.pymtDducFrmCd = pymtDducFrmCd;
    }
    
    public BigDecimal getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(BigDecimal pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getTxtnDivCd() {
        return this.txtnDivCd;
    }
    
    public void setTxtnDivCd(java.lang.String txtnDivCd) {
        this.txtnDivCd = txtnDivCd;
    }
    
    public BigDecimal getFreeDtyRate() {
        return this.freeDtyRate;
    }
    
    public void setFreeDtyRate(BigDecimal freeDtyRate) {
        this.freeDtyRate = freeDtyRate;
    }
    
    public BigDecimal getFreeDtySum() {
        return this.freeDtySum;
    }
    
    public void setFreeDtySum(BigDecimal freeDtySum) {
        this.freeDtySum = freeDtySum;
    }
    
    public java.lang.String getJan() {
        return this.jan;
    }
    
    public void setJan(java.lang.String jan) {
        this.jan = jan;
    }
    
    public java.lang.String getFeb() {
        return this.feb;
    }
    
    public void setFeb(java.lang.String feb) {
        this.feb = feb;
    }
    
    public java.lang.String getMar() {
        return this.mar;
    }
    
    public void setMar(java.lang.String mar) {
        this.mar = mar;
    }
    
    public java.lang.String getApr() {
        return this.apr;
    }
    
    public void setApr(java.lang.String apr) {
        this.apr = apr;
    }
    
    public java.lang.String getMay() {
        return this.may;
    }
    
    public void setMay(java.lang.String may) {
        this.may = may;
    }
    
    public java.lang.String getJun() {
        return this.jun;
    }
    
    public void setJun(java.lang.String jun) {
        this.jun = jun;
    }
    
    public java.lang.String getJul() {
        return this.jul;
    }
    
    public void setJul(java.lang.String jul) {
        this.jul = jul;
    }
    
    public java.lang.String getAug() {
        return this.aug;
    }
    
    public void setAug(java.lang.String aug) {
        this.aug = aug;
    }
    
    public java.lang.String getSep() {
        return this.sep;
    }
    
    public void setSep(java.lang.String sep) {
        this.sep = sep;
    }
    
    public java.lang.String getOct() {
        return this.oct;
    }
    
    public void setOct(java.lang.String oct) {
        this.oct = oct;
    }
    
    public java.lang.String getNov() {
        return this.nov;
    }
    
    public void setNov(java.lang.String nov) {
        this.nov = nov;
    }
    
    public java.lang.String getDec() {
        return this.dec;
    }
    
    public void setDec(java.lang.String dec) {
        this.dec = dec;
    }
    
    public BigDecimal getRngeOrd() {
        return this.rngeOrd;
    }
    
    public void setRngeOrd(BigDecimal rngeOrd) {
        this.rngeOrd = rngeOrd;
    }
    
    public java.lang.String getPayItemUseYn() {
        return this.payItemUseYn;
    }
    
    public void setPayItemUseYn(java.lang.String payItemUseYn) {
        this.payItemUseYn = payItemUseYn;
    }
    
    public java.lang.String getItemApptnBgnnDt() {
        return this.itemApptnBgnnDt;
    }
    
    public void setItemApptnBgnnDt(java.lang.String itemApptnBgnnDt) {
        this.itemApptnBgnnDt = itemApptnBgnnDt;
    }
    
    public java.lang.String getItemApptnEndDt() {
        return this.itemApptnEndDt;
    }
    
    public void setItemApptnEndDt(java.lang.String itemApptnEndDt) {
        this.itemApptnEndDt = itemApptnEndDt;
    }
    
    public java.lang.String getDayMnthAmntDivCd() {
        return this.dayMnthAmntDivCd;
    }
    
    public void setDayMnthAmntDivCd(java.lang.String dayMnthAmntDivCd) {
        this.dayMnthAmntDivCd = dayMnthAmntDivCd;
    }
    
    public java.lang.String getCalcStdDivCd() {
        return this.calcStdDivCd;
    }
    
    public void setCalcStdDivCd(java.lang.String calcStdDivCd) {
        this.calcStdDivCd = calcStdDivCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getUsalyAmntYn() {
        return this.usalyAmntYn;
    }
    
    public void setUsalyAmntYn(java.lang.String usalyAmntYn) {
        this.usalyAmntYn = usalyAmntYn;
    }
    
    public java.lang.String getPayItemNoteCtnt() {
        return this.payItemNoteCtnt;
    }
    
    public void setPayItemNoteCtnt(java.lang.String payItemNoteCtnt) {
        this.payItemNoteCtnt = payItemNoteCtnt;
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
	 * Comment : 
	 * @fn java.math.BigDecimal getUcstSum02()
	 * @brief date:2017 2017. 9. 20. user:atres
	 * @return the ucstSum02 get
	 */
	public java.math.BigDecimal getUcstSum02() {
		return ucstSum02;
	}

	/**
	 * Comment : 
	 *@fn void setUcstSum02(java.math.BigDecimal ucstSum02)
	 *@brief date:2017 2017. 9. 20. user:atres
	 *@param ucstSum02 the ucstSum02 to set
	 */
	public void setUcstSum02(java.math.BigDecimal ucstSum02) {
		this.ucstSum02 = ucstSum02;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrItemTrmStdDt()
	 * @brief date:2017 2017. 9. 20. user:atres
	 * @return the payrItemTrmStdDt get
	 */
	public java.lang.String getPayrItemTrmStdDt() {
		return payrItemTrmStdDt;
	}

	/**
	 * Comment : 
	 *@fn void setPayrItemTrmStdDt(java.lang.String payrItemTrmStdDt)
	 *@brief date:2017 2017. 9. 20. user:atres
	 *@param payrItemTrmStdDt the payrItemTrmStdDt to set
	 */
	public void setPayrItemTrmStdDt(java.lang.String payrItemTrmStdDt) {
		this.payrItemTrmStdDt = payrItemTrmStdDt;
	}
    
}
