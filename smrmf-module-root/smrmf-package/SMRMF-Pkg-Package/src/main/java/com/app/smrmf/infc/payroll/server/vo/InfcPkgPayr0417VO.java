package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0417VO.java
 * @Description : Payr0417 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.12.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0417VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여일용단가항목일련번호 : itemDlySeilNum */
    private java.math.BigDecimal itemDlySeilNum;

    /** set 직종세단가항목일련번호 : dtilOccuDlySeilNum */
    private java.math.BigDecimal dtilOccuDlySeilNum;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

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

    /** set 금액타항목동일적용여부 : sumOhrItemApptnYn */
    private java.lang.String sumOhrItemApptnYn;

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

    /** set 계산수식내용 : calcStdFunc */
    private java.lang.String calcStdFunc;

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
  
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
     
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
     
    private java.lang.String pyspLogSvcYrNumCd;
    
    /** UCST_SUM */
    private BigDecimal ucstSum = BigDecimal.ZERO;
    
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
     
    
    /** set 월통상임금액 : mnthUsalyAmntWag */
    private java.math.BigDecimal mnthUsalyAmntWag;

    /** set 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
    private java.math.BigDecimal mnthUsalyAmntAllwBnusSum;

    /** 일용직 기본급게산 값   */
    private java.math.BigDecimal basePymtAmnt;
    
    private java.lang.String dtilOcclsApptnUcstCd;
    

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
    
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getDtilOcclsApptnUcstCd()
	 * @brief date:2017 2017. 5. 12. user:paygen
	 * @return the dtilOcclsApptnUcstCd get
	 */
	public java.lang.String getDtilOcclsApptnUcstCd() {
		return dtilOcclsApptnUcstCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd)
	 *@brief date:2017 2017. 5. 12. user:paygen
	 *@param dtilOcclsApptnUcstCd the dtilOcclsApptnUcstCd to set
	 */
	public void setDtilOcclsApptnUcstCd(java.lang.String dtilOcclsApptnUcstCd) {
		this.dtilOcclsApptnUcstCd = dtilOcclsApptnUcstCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getUsalyAmntPdyQnty()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the usalyAmntPdyQnty get
	 */
	public java.math.BigDecimal getUsalyAmntPdyQnty() {
		return usalyAmntPdyQnty;
	}

	/**
	 * Comment : 
	 *@fn void setUsalyAmntPdyQnty(java.math.BigDecimal usalyAmntPdyQnty)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param usalyAmntPdyQnty the usalyAmntPdyQnty to set
	 */
	public void setUsalyAmntPdyQnty(java.math.BigDecimal usalyAmntPdyQnty) {
		this.usalyAmntPdyQnty = usalyAmntPdyQnty;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getUsalyAmntHrwgQnty()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the usalyAmntHrwgQnty get
	 */
	public java.math.BigDecimal getUsalyAmntHrwgQnty() {
		return usalyAmntHrwgQnty;
	}

	/**
	 * Comment : 
	 *@fn void setUsalyAmntHrwgQnty(java.math.BigDecimal usalyAmntHrwgQnty)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param usalyAmntHrwgQnty the usalyAmntHrwgQnty to set
	 */
	public void setUsalyAmntHrwgQnty(java.math.BigDecimal usalyAmntHrwgQnty) {
		this.usalyAmntHrwgQnty = usalyAmntHrwgQnty;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBefLogSvcYrNumCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the befLogSvcYrNumCd get
	 */
	public java.lang.String getBefLogSvcYrNumCd() {
		return befLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 *@fn void setBefLogSvcYrNumCd(java.lang.String befLogSvcYrNumCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param befLogSvcYrNumCd the befLogSvcYrNumCd to set
	 */
	public void setBefLogSvcYrNumCd(java.lang.String befLogSvcYrNumCd) {
		this.befLogSvcYrNumCd = befLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBefClssPayCmpttnStd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the befClssPayCmpttnStd get
	 */
	public java.lang.String getBefClssPayCmpttnStd() {
		return befClssPayCmpttnStd;
	}

	/**
	 * Comment : 
	 *@fn void setBefClssPayCmpttnStd(java.lang.String befClssPayCmpttnStd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param befClssPayCmpttnStd the befClssPayCmpttnStd to set
	 */
	public void setBefClssPayCmpttnStd(java.lang.String befClssPayCmpttnStd) {
		this.befClssPayCmpttnStd = befClssPayCmpttnStd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getBefUcstSum()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the befUcstSum get
	 */
	public java.math.BigDecimal getBefUcstSum() {
		return befUcstSum;
	}

	/**
	 * Comment : 
	 *@fn void setBefUcstSum(java.math.BigDecimal befUcstSum)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param befUcstSum the befUcstSum to set
	 */
	public void setBefUcstSum(java.math.BigDecimal befUcstSum) {
		this.befUcstSum = befUcstSum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getBasePymtAmnt()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the basePymtAmnt get
	 */
	public java.math.BigDecimal getBasePymtAmnt() {
		return basePymtAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setBasePymtAmnt(java.math.BigDecimal basePymtAmnt)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param basePymtAmnt the basePymtAmnt to set
	 */
	public void setBasePymtAmnt(java.math.BigDecimal basePymtAmnt) {
		this.basePymtAmnt = basePymtAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspGrdeCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the pyspGrdeCd get
	 */
	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspGrdeCd(java.lang.String pyspGrdeCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param pyspGrdeCd the pyspGrdeCd to set
	 */
	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPyspLogSvcYrNumCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the pyspLogSvcYrNumCd get
	 */
	public java.lang.String getPyspLogSvcYrNumCd() {
		return pyspLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 *@fn void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param pyspLogSvcYrNumCd the pyspLogSvcYrNumCd to set
	 */
	public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
		this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getUcstSum()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstSum get
	 */
	public BigDecimal getUcstSum() {
		return ucstSum;
	}

	/**
	 * Comment : 
	 *@fn void setUcstSum(BigDecimal ucstSum)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstSum the ucstSum to set
	 */
	public void setUcstSum(BigDecimal ucstSum) {
		this.ucstSum = ucstSum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUcstCalcDivCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstCalcDivCd get
	 */
	public java.lang.String getUcstCalcDivCd() {
		return ucstCalcDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setUcstCalcDivCd(java.lang.String ucstCalcDivCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstCalcDivCd the ucstCalcDivCd to set
	 */
	public void setUcstCalcDivCd(java.lang.String ucstCalcDivCd) {
		this.ucstCalcDivCd = ucstCalcDivCd;
	}

	/**
	 * Comment : 
	 * @fn BigDecimal getUcstPrntOrd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstPrntOrd get
	 */
	public BigDecimal getUcstPrntOrd() {
		return ucstPrntOrd;
	}

	/**
	 * Comment : 
	 *@fn void setUcstPrntOrd(BigDecimal ucstPrntOrd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstPrntOrd the ucstPrntOrd to set
	 */
	public void setUcstPrntOrd(BigDecimal ucstPrntOrd) {
		this.ucstPrntOrd = ucstPrntOrd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUcstDgmBgnnDt()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstDgmBgnnDt get
	 */
	public java.lang.String getUcstDgmBgnnDt() {
		return ucstDgmBgnnDt;
	}

	/**
	 * Comment : 
	 *@fn void setUcstDgmBgnnDt(java.lang.String ucstDgmBgnnDt)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstDgmBgnnDt the ucstDgmBgnnDt to set
	 */
	public void setUcstDgmBgnnDt(java.lang.String ucstDgmBgnnDt) {
		this.ucstDgmBgnnDt = ucstDgmBgnnDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUcstDgmEndDt()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstDgmEndDt get
	 */
	public java.lang.String getUcstDgmEndDt() {
		return ucstDgmEndDt;
	}

	/**
	 * Comment : 
	 *@fn void setUcstDgmEndDt(java.lang.String ucstDgmEndDt)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstDgmEndDt the ucstDgmEndDt to set
	 */
	public void setUcstDgmEndDt(java.lang.String ucstDgmEndDt) {
		this.ucstDgmEndDt = ucstDgmEndDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUcstDgmUseYn()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the ucstDgmUseYn get
	 */
	public java.lang.String getUcstDgmUseYn() {
		return ucstDgmUseYn;
	}

	/**
	 * Comment : 
	 *@fn void setUcstDgmUseYn(java.lang.String ucstDgmUseYn)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param ucstDgmUseYn the ucstDgmUseYn to set
	 */
	public void setUcstDgmUseYn(java.lang.String ucstDgmUseYn) {
		this.ucstDgmUseYn = ucstDgmUseYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getMnthUsalyAmntWag()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the mnthUsalyAmntWag get
	 */
	public java.math.BigDecimal getMnthUsalyAmntWag() {
		return mnthUsalyAmntWag;
	}

	/**
	 * Comment : 
	 *@fn void setMnthUsalyAmntWag(java.math.BigDecimal mnthUsalyAmntWag)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param mnthUsalyAmntWag the mnthUsalyAmntWag to set
	 */
	public void setMnthUsalyAmntWag(java.math.BigDecimal mnthUsalyAmntWag) {
		this.mnthUsalyAmntWag = mnthUsalyAmntWag;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getMnthUsalyAmntAllwBnusSum()
	 * @brief date:2017 2017. 5. 11. user:paygen
	 * @return the mnthUsalyAmntAllwBnusSum get
	 */
	public java.math.BigDecimal getMnthUsalyAmntAllwBnusSum() {
		return mnthUsalyAmntAllwBnusSum;
	}

	/**
	 * Comment : 
	 *@fn void setMnthUsalyAmntAllwBnusSum(java.math.BigDecimal mnthUsalyAmntAllwBnusSum)
	 *@brief date:2017 2017. 5. 11. user:paygen
	 *@param mnthUsalyAmntAllwBnusSum the mnthUsalyAmntAllwBnusSum to set
	 */
	public void setMnthUsalyAmntAllwBnusSum(
			java.math.BigDecimal mnthUsalyAmntAllwBnusSum) {
		this.mnthUsalyAmntAllwBnusSum = mnthUsalyAmntAllwBnusSum;
	}

	public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.math.BigDecimal getItemDlySeilNum() {
        return this.itemDlySeilNum;
    }
    
    public void setItemDlySeilNum(java.math.BigDecimal itemDlySeilNum) {
        this.itemDlySeilNum = itemDlySeilNum;
    }
    
    public java.math.BigDecimal getDtilOccuDlySeilNum() {
        return this.dtilOccuDlySeilNum;
    }
    
    public void setDtilOccuDlySeilNum(java.math.BigDecimal dtilOccuDlySeilNum) {
        this.dtilOccuDlySeilNum = dtilOccuDlySeilNum;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getPayrImcd() {
        return this.payrImcd;
    }
    
    public void setPayrImcd(java.lang.String payrImcd) {
        this.payrImcd = payrImcd;
    }
    
    public java.lang.String getItemNm() {
        return this.itemNm;
    }
    
    public void setItemNm(java.lang.String itemNm) {
        this.itemNm = itemNm;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
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
    
    public java.math.BigDecimal getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(java.math.BigDecimal pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public java.math.BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(java.math.BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getTxtnDivCd() {
        return this.txtnDivCd;
    }
    
    public void setTxtnDivCd(java.lang.String txtnDivCd) {
        this.txtnDivCd = txtnDivCd;
    }
    
    public java.math.BigDecimal getFreeDtyRate() {
        return this.freeDtyRate;
    }
    
    public void setFreeDtyRate(java.math.BigDecimal freeDtyRate) {
        this.freeDtyRate = freeDtyRate;
    }
    
    public java.math.BigDecimal getFreeDtySum() {
        return this.freeDtySum;
    }
    
    public void setFreeDtySum(java.math.BigDecimal freeDtySum) {
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
    
    public java.math.BigDecimal getRngeOrd() {
        return this.rngeOrd;
    }
    
    public void setRngeOrd(java.math.BigDecimal rngeOrd) {
        this.rngeOrd = rngeOrd;
    }
    
    public java.lang.String getSumOhrItemApptnYn() {
        return this.sumOhrItemApptnYn;
    }
    
    public void setSumOhrItemApptnYn(java.lang.String sumOhrItemApptnYn) {
        this.sumOhrItemApptnYn = sumOhrItemApptnYn;
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
    
    public java.lang.String getCalcStdFunc() {
        return this.calcStdFunc;
    }
    
    public void setCalcStdFunc(java.lang.String calcStdFunc) {
        this.calcStdFunc = calcStdFunc;
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
    
}
