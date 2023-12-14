package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0440VO.java
 * @Description : Payr0440 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0440VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.math.BigDecimal payrItemSeilNum;

    /** set 호봉근속년수코드 : pyspLogSvcYrNumCd */
    private java.lang.String pyspLogSvcYrNumCd;
 
    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 직종별급여산정기준일자 : occuClssPayCmpttnStd */
    private java.lang.String occuClssPayCmpttnStd;

    /** set 단가금액 : ucstSum */
    private java.math.BigDecimal ucstSum;

    /** set 단가계산구분코드 : ucstCalcDivCd */
    private java.lang.String ucstCalcDivCd;

    /** set 단가출력순서 : ucstPrntOrd */
    private java.math.BigDecimal ucstPrntOrd;

    /** set 단가표시작일자 : ucstDgmBgnnDt */
    private java.lang.String ucstDgmBgnnDt;

    /** set 단가표종료일자 : ucstDgmEndDt */
    private java.lang.String ucstDgmEndDt;

    /** set 단가표사용여부 : ucstDgmUseYn */
    private java.lang.String ucstDgmUseYn;

    /** set 단가비고내용 : ucstNoteCtnt */
    private java.lang.String ucstNoteCtnt;

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
    
    /** set 지급항목코드 : payrItemCd */
    private java.lang.String payrItemCd;
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** set 급여적용시점일자 : payrIntoDt */
    private java.lang.String payrIntoDt;

    /** set 단가금액02 : ucstSum02 */
    private java.math.BigDecimal ucstSum02;

    /** set 급여항목구간기준일자 : payrItemTrmStdDt */
    private java.lang.String payrItemTrmStdDt;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
     
    /**
	 * Comment : 직종세통합코드 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 6, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment :직종세통합코드 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 6, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPayrItemCd() {
        return payrItemCd;
    }

    public void setPayrItemCd(java.lang.String payrItemCd) {
        this.payrItemCd = payrItemCd;
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

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getPyspLogSvcYrNumCd() {
        return this.pyspLogSvcYrNumCd;
    }
    
    public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
        this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
     
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getOccuClssPayCmpttnStd() {
        return this.occuClssPayCmpttnStd;
    }
    
    public void setOccuClssPayCmpttnStd(java.lang.String occuClssPayCmpttnStd) {
        this.occuClssPayCmpttnStd = occuClssPayCmpttnStd;
    }
    
    public BigDecimal getUcstSum() {
        return this.ucstSum;
    }
    
    public void setUcstSum(BigDecimal ucstSum) {
        this.ucstSum = ucstSum;
    }
    
    public java.lang.String getUcstCalcDivCd() {
        return this.ucstCalcDivCd;
    }
    
    public void setUcstCalcDivCd(java.lang.String ucstCalcDivCd) {
        this.ucstCalcDivCd = ucstCalcDivCd;
    }
    
    public BigDecimal getUcstPrntOrd() {
        return this.ucstPrntOrd;
    }
    
    public void setUcstPrntOrd(BigDecimal ucstPrntOrd) {
        this.ucstPrntOrd = ucstPrntOrd;
    }
    
    public java.lang.String getUcstDgmBgnnDt() {
        return this.ucstDgmBgnnDt;
    }
    
    public void setUcstDgmBgnnDt(java.lang.String ucstDgmBgnnDt) {
        this.ucstDgmBgnnDt = ucstDgmBgnnDt;
    }
    
    public java.lang.String getUcstDgmEndDt() {
        return this.ucstDgmEndDt;
    }
    
    public void setUcstDgmEndDt(java.lang.String ucstDgmEndDt) {
        this.ucstDgmEndDt = ucstDgmEndDt;
    }
    
    public java.lang.String getUcstDgmUseYn() {
        return this.ucstDgmUseYn;
    }
    
    public void setUcstDgmUseYn(java.lang.String ucstDgmUseYn) {
        this.ucstDgmUseYn = ucstDgmUseYn;
    }
    
    public java.lang.String getUcstNoteCtnt() {
        return this.ucstNoteCtnt;
    }
    
    public void setUcstNoteCtnt(java.lang.String ucstNoteCtnt) {
        this.ucstNoteCtnt = ucstNoteCtnt;
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
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrIntoDt()
	 * @brief date:2017 2017. 9. 20. user:atres
	 * @return the payrIntoDt get
	 */
	public java.lang.String getPayrIntoDt() {
		return payrIntoDt;
	}

	/**
	 * Comment : 
	 *@fn void setPayrIntoDt(java.lang.String payrIntoDt)
	 *@brief date:2017 2017. 9. 20. user:atres
	 *@param payrIntoDt the payrIntoDt to set
	 */
	public void setPayrIntoDt(java.lang.String payrIntoDt) {
		this.payrIntoDt = payrIntoDt;
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
