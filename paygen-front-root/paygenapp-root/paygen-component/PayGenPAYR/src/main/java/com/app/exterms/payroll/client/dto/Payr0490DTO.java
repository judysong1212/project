package com.app.exterms.payroll.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

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
public class Payr0490DTO  implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PAY_YR */
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

	/** BUSIN_CD */
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

	/** DEPT_CD */
    private java.lang.String deptCd;
    
    private java.lang.String bfrDeptCd;
    private java.lang.String creDeptCd;
    

	public java.lang.String getBfrDeptCd() {
		return bfrDeptCd;
	}

	public void setBfrDeptCd(java.lang.String bfrDeptCd) {
		this.bfrDeptCd = bfrDeptCd;
	}

	public java.lang.String getCreDeptCd() {
		return creDeptCd;
	}

	public void setCreDeptCd(java.lang.String creDeptCd) {
		this.creDeptCd = creDeptCd;
	}

	/** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** ITEM_NM */
    private java.lang.String itemNm;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String pymtDducDivCd;
    
    /** PYMT_DDUC_FRM_CD */
    private java.lang.String pymtDducFrmCd;
    
    /** PYMT_DDUC_RATE */
    private Double pymtDducRate;
    
    /** PYMT_DDUC_SUM */
    private Long pymtDducSum;
    
    /** TXTN_DIV_CD */
    private java.lang.String txtnDivCd;
    
    /** FREE_DTY_RATE */
    private Double freeDtyRate;
    
    /** FREE_DTY_SUM */
    private Long freeDtySum;
    
    /** JAN */
    private Boolean jan;
    
    /** FEB */
    private Boolean feb;
    
    /** MAR */
    private Boolean mar;
    
    /** APR */
    private Boolean apr;
    
    /** MAY */
    private Boolean may;
    
    /** JUN */
    private Boolean jun;
    
    /** JUL */
    private Boolean jul;
    
    /** AUG */
    private Boolean aug;
    
    /** SEP */
    private Boolean sep;
    
    /** OCT */
    private Boolean oct;
    
    /** NOV */
    private Boolean nov;
    
    /** DEC */
    private Boolean dec;
    
    /** RNGE_ORD */
    private Long rngeOrd;
    
    /** PAY_ITEM_USE_YN */
    private Boolean payItemUseYn;
    
    /** ITEM_APPTN_BGNN_DT */
    private java.lang.String itemApptnBgnnDt;
    
    /** ITEM_APPTN_END_DT */
    private java.lang.String itemApptnEndDt;
    
    /** DAY_MNTH_AMNT_DIV_CD */
    private java.lang.String dayMnthAmntDivCd;
    
    /** CALC_STD_DIV_CD */
    private java.lang.String calcStdDivCd;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** USALY_AMNT_YN */
    private Boolean usalyAmntYn;
    
    /** PAY_ITEM_NOTE_CTNT */
    private java.lang.String payItemNoteCtnt;
    
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
     
    /** set 급여단가표일련번호 : payrUcstDgmSeilNum */
    private Long payrUcstDgmSeilNum;
 
    /** set 계산수식내용 : calcStdFunc */
    private java.lang.String calcStdFunc;

	/** set 대사 부서코드 : targetDeptCd */
    private java.lang.String targetDeptCd;
    
    /** set 대상 사업코드 : targetBudinCd */
    private java.lang.String targetBusinCd;
    
    /** set 대상 지급년도 : targetPayYr */
    private java.lang.String targetPayYr;
    
    public java.lang.String getTargetDeptCd() {
		return targetDeptCd;
	}

	public void setTargetDeptCd(java.lang.String targetDeptCd) {
		this.targetDeptCd = targetDeptCd;
	}

	public java.lang.String getTargetBusinCd() {
		return targetBusinCd;
	}

	public void setTargetBusinCd(java.lang.String targetBusinCd) {
		this.targetBusinCd = targetBusinCd;
	}

	public java.lang.String getTargetPayYr() {
		return targetPayYr;
	}

	public void setTargetPayYr(java.lang.String targetPayYr) {
		this.targetPayYr = targetPayYr;
	}

      
    
    public Long getPayrUcstDgmSeilNum() {
        return payrUcstDgmSeilNum;
    }

    public void setPayrUcstDgmSeilNum(Long payrUcstDgmSeilNum) {
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
    
    public Double getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(Double pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public Long getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(Long pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getTxtnDivCd() {
        return this.txtnDivCd;
    }
    
    public void setTxtnDivCd(java.lang.String txtnDivCd) {
        this.txtnDivCd = txtnDivCd;
    }
    
    public Double getFreeDtyRate() {
        return this.freeDtyRate;
    }
    
    public void setFreeDtyRate(Double freeDtyRate) {
        this.freeDtyRate = freeDtyRate;
    }
    
    public Long getFreeDtySum() {
        return this.freeDtySum;
    }
    
    public void setFreeDtySum(Long freeDtySum) {
        this.freeDtySum = freeDtySum;
    }
    
    public Boolean getJan() {
        return this.jan;
    }
    
    public void setJan(Boolean jan) {
        this.jan = jan;
    }
    
    public Boolean getFeb() {
        return this.feb;
    }
    
    public void setFeb(Boolean feb) {
        this.feb = feb;
    }
    
    public Boolean getMar() {
        return this.mar;
    }
    
    public void setMar(Boolean mar) {
        this.mar = mar;
    }
    
    public Boolean getApr() {
        return this.apr;
    }
    
    public void setApr(Boolean apr) {
        this.apr = apr;
    }
    
    public Boolean getMay() {
        return this.may;
    }
    
    public void setMay(Boolean may) {
        this.may = may;
    }
    
    public Boolean getJun() {
        return this.jun;
    }
    
    public void setJun(Boolean jun) {
        this.jun = jun;
    }
    
    public Boolean getJul() {
        return this.jul;
    }
    
    public void setJul(Boolean jul) {
        this.jul = jul;
    }
    
    public Boolean getAug() {
        return this.aug;
    }
    
    public void setAug(Boolean aug) {
        this.aug = aug;
    }
    
    public Boolean getSep() {
        return this.sep;
    }
    
    public void setSep(Boolean sep) {
        this.sep = sep;
    }
    
    public Boolean getOct() {
        return this.oct;
    }
    
    public void setOct(Boolean oct) {
        this.oct = oct;
    }
    
    public Boolean getNov() {
        return this.nov;
    }
    
    public void setNov(Boolean nov) {
        this.nov = nov;
    }
    
    public Boolean getDec() {
        return this.dec;
    }
    
    public void setDec(Boolean dec) {
        this.dec = dec;
    }
    
    public Long getRngeOrd() {
        return this.rngeOrd;
    }
    
    public void setRngeOrd(Long rngeOrd) {
        this.rngeOrd = rngeOrd;
    }
    
    public Boolean getPayItemUseYn() {
        return this.payItemUseYn;
    }
    
    public void setPayItemUseYn(Boolean payItemUseYn) {
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
    
    public Boolean getUsalyAmntYn() {
        return this.usalyAmntYn;
    }
    
    public void setUsalyAmntYn(Boolean usalyAmntYn) {
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
