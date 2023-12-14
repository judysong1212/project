package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Payr0490VO.java
 * @Description : Payr0490 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0490VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여년도 : payYr */
    private java.lang.String payYr;
    
    
    /** PAY_YR */
    private java.lang.String payBfrYr;
    
    /** PAY_YR */
    private java.lang.String payCreYr;
    
    
    public java.lang.String getPayBfrYr() {
		return payBfrYr;
	}

	public void setPayBfrYr(java.lang.String payBfrYr) {
		this.payBfrYr = payBfrYr;
	}

	public java.lang.String getPayCreYr() {
		return payCreYr;
	}

	public void setPayCreYr(java.lang.String payCreYr) {
		this.payCreYr = payCreYr;
	}

    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
	/** BUSIN_CD */
    private java.lang.String bfrBusinCd;
    
	/** BUSIN_CD */
    private java.lang.String creBusinCd;
    

    public java.lang.String getBfrBusinCd() {
		return bfrBusinCd;
	}

	public void setBfrBusinCd(java.lang.String bfrBusinCd) {
		this.bfrBusinCd = bfrBusinCd;
	}

	public java.lang.String getCreBusinCd() {
		return creBusinCd;
	}

	public void setCreBusinCd(java.lang.String creBusinCd) {
		this.creBusinCd = creBusinCd;
	}

	/** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 급여단가표일련번호 : payrUcstDgmSeilNum */
    private java.math.BigDecimal payrUcstDgmSeilNum;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 항목명 : itemNm */
    private java.lang.String itemNm;

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

    /** set 계산수식내용 : calcStdFunc */
    private java.lang.String calcStdFunc;

     
    
    
    public java.math.BigDecimal getPayrUcstDgmSeilNum() {
        return payrUcstDgmSeilNum;
    }

    public void setPayrUcstDgmSeilNum(java.math.BigDecimal payrUcstDgmSeilNum) {
        this.payrUcstDgmSeilNum = payrUcstDgmSeilNum;
    }

    public java.lang.String getCalcStdFunc() {
        return calcStdFunc;
    }

    public void setCalcStdFunc(java.lang.String calcStdFunc) {
        this.calcStdFunc = calcStdFunc;
    }

    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getPayYr() {
        return this.payYr;
    }
    
    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
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
    
}
