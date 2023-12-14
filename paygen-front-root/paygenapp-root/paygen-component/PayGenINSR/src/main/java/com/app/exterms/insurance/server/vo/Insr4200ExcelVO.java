package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr4200VO.java
 * @Description : Insr4200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4200ExcelVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 공제년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 고용일련번호 : emymtSeilNum */
    private java.lang.String emymtSeilNum;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 신고소득총액 : regrstIncmTotAmnt */
    private java.lang.String regrstIncmTotAmnt;

    /** set 결정기준소득월액 : deinStdIncmMnthAmnt */
    private java.lang.String deinStdIncmMnthAmnt;

    /** set 결정월보험료 : deinMnthPrmm */
    private java.lang.String deinMnthPrmm;

    /** set 본인부담액 : indvBrdnSum */
    private java.lang.String indvBrdnSum;

    /** set 본인소급보험료 : reattyQnty */
    private java.lang.String reattyQnty;

    /** set 본인정산보험료 : hmlfClutPrmm */
    private java.lang.String hmlfClutPrmm;

    /** set 본인보험료계 : hmlfPrmmAggr */
    private java.lang.String hmlfPrmmAggr;

    /** set 사업장부담액 : dpobBrdnSum */
    private java.lang.String dpobBrdnSum;

    /** set 사업자정산보험료 : busoprClutPrmm */
    private java.lang.String busoprClutPrmm;

    /** set 사업자소급보험료 : busoprReattyPrmm */
    private java.lang.String busoprReattyPrmm;

    /** set 사업자보험료계 : busoprPrmmAggr */
    private java.lang.String busoprPrmmAggr;

    /** set 본인납부보험료계 : aggr */
    private java.lang.String aggr;

    /** set 변동구분 : fluc */
    private java.lang.String fluc;

    /** set 취득월납부여부 : aqtnMnthPymtYn */
    private java.lang.String aqtnMnthPymtYn;

    /** set 변동일자 : flucDt */
    private java.lang.String flucDt;

    /** set 변동사유내용 : flucReasCtnt */
    private java.lang.String flucReasCtnt;

    /** set 공단직권결정여부 : pbcorpOautyDeinYn */
    private java.lang.String pbcorpOautyDeinYn;

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

    /** set 국민연금급여공제년월 : natPayrDducYrMnth */
    private java.lang.String natPayrDducYrMnth;

    /** set 국민연금처리일자 : natInsrPrcsDt */
    private java.lang.String natInsrPrcsDt;

    /** set 국민연금처리여부 : natInsrPrcsYn */
    private java.lang.String natInsrPrcsYn;

    /** set 국민연금차액 : natInsrPrmmSrd */
    private java.lang.String natInsrPrmmSrd;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부회수 : divdPymt */
    private java.lang.String divdPymt;

    /** set 국민연금기호번호 : natPennSymNum */
    private java.lang.String natPennSymNum;

	/** set 연금급여산출보험금액 : natPennPayCalcSum */
    private java.lang.String natPennPayCalcSum;

    
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
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    /**
	 * Comment : 
	 * @fn java.lang.String getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public java.lang.String getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(java.lang.String emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(java.lang.String emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}

	public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getRegrstIncmTotAmnt() {
        return this.regrstIncmTotAmnt;
    }
    
    public void setRegrstIncmTotAmnt(java.lang.String regrstIncmTotAmnt) {
        this.regrstIncmTotAmnt = regrstIncmTotAmnt;
    }
    
    public java.lang.String getDeinStdIncmMnthAmnt() {
        return this.deinStdIncmMnthAmnt;
    }
    
    public void setDeinStdIncmMnthAmnt(java.lang.String deinStdIncmMnthAmnt) {
        this.deinStdIncmMnthAmnt = deinStdIncmMnthAmnt;
    }
    
    public java.lang.String getDeinMnthPrmm() {
        return this.deinMnthPrmm;
    }
    
    public void setDeinMnthPrmm(java.lang.String deinMnthPrmm) {
        this.deinMnthPrmm = deinMnthPrmm;
    }
    
    public java.lang.String getIndvBrdnSum() {
        return this.indvBrdnSum;
    }
    
    public void setIndvBrdnSum(java.lang.String indvBrdnSum) {
        this.indvBrdnSum = indvBrdnSum;
    }
    
    public java.lang.String getReattyQnty() {
        return this.reattyQnty;
    }
    
    public void setReattyQnty(java.lang.String reattyQnty) {
        this.reattyQnty = reattyQnty;
    }
    
    public java.lang.String getHmlfClutPrmm() {
        return this.hmlfClutPrmm;
    }
    
    public void setHmlfClutPrmm(java.lang.String hmlfClutPrmm) {
        this.hmlfClutPrmm = hmlfClutPrmm;
    }
    
    public java.lang.String getHmlfPrmmAggr() {
        return this.hmlfPrmmAggr;
    }
    
    public void setHmlfPrmmAggr(java.lang.String hmlfPrmmAggr) {
        this.hmlfPrmmAggr = hmlfPrmmAggr;
    }
    
    public java.lang.String getDpobBrdnSum() {
        return this.dpobBrdnSum;
    }
    
    public void setDpobBrdnSum(java.lang.String dpobBrdnSum) {
        this.dpobBrdnSum = dpobBrdnSum;
    }
    
    public java.lang.String getBusoprClutPrmm() {
        return this.busoprClutPrmm;
    }
    
    public void setBusoprClutPrmm(java.lang.String busoprClutPrmm) {
        this.busoprClutPrmm = busoprClutPrmm;
    }
    
    public java.lang.String getBusoprReattyPrmm() {
        return this.busoprReattyPrmm;
    }
    
    public void setBusoprReattyPrmm(java.lang.String busoprReattyPrmm) {
        this.busoprReattyPrmm = busoprReattyPrmm;
    }
    
    public java.lang.String getBusoprPrmmAggr() {
        return this.busoprPrmmAggr;
    }
    
    public void setBusoprPrmmAggr(java.lang.String busoprPrmmAggr) {
        this.busoprPrmmAggr = busoprPrmmAggr;
    }
    
    public java.lang.String getAggr() {
        return this.aggr;
    }
    
    public void setAggr(java.lang.String aggr) {
        this.aggr = aggr;
    }
    
    public java.lang.String getFluc() {
        return this.fluc;
    }
    
    public void setFluc(java.lang.String fluc) {
        this.fluc = fluc;
    }
    
    public java.lang.String getAqtnMnthPymtYn() {
        return this.aqtnMnthPymtYn;
    }
    
    public void setAqtnMnthPymtYn(java.lang.String aqtnMnthPymtYn) {
        this.aqtnMnthPymtYn = aqtnMnthPymtYn;
    }
    
    public java.lang.String getFlucDt() {
        return this.flucDt;
    }
    
    public void setFlucDt(java.lang.String flucDt) {
        this.flucDt = flucDt;
    }
    
    public java.lang.String getFlucReasCtnt() {
        return this.flucReasCtnt;
    }
    
    public void setFlucReasCtnt(java.lang.String flucReasCtnt) {
        this.flucReasCtnt = flucReasCtnt;
    }
    
    public java.lang.String getPbcorpOautyDeinYn() {
        return this.pbcorpOautyDeinYn;
    }
    
    public void setPbcorpOautyDeinYn(java.lang.String pbcorpOautyDeinYn) {
        this.pbcorpOautyDeinYn = pbcorpOautyDeinYn;
    }
    
    public java.lang.String getNatPayrDducYrMnth() {
		return natPayrDducYrMnth;
	}

	public void setNatPayrDducYrMnth(java.lang.String natPayrDducYrMnth) {
		this.natPayrDducYrMnth = natPayrDducYrMnth;
	}

	public java.lang.String getNatInsrPrcsDt() {
		return natInsrPrcsDt;
	}

	public void setNatInsrPrcsDt(java.lang.String natInsrPrcsDt) {
		this.natInsrPrcsDt = natInsrPrcsDt;
	}

	public java.lang.String getNatInsrPrcsYn() {
		return natInsrPrcsYn;
	}

	public void setNatInsrPrcsYn(java.lang.String natInsrPrcsYn) {
		this.natInsrPrcsYn = natInsrPrcsYn;
	}

	public java.lang.String getNatInsrPrmmSrd() {
		return natInsrPrmmSrd;
	}

	public void setNatInsrPrmmSrd(java.lang.String natInsrPrmmSrd) {
		this.natInsrPrmmSrd = natInsrPrmmSrd;
	}

	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	public java.lang.String getDivdPymt() {
		return divdPymt;
	}

	public void setDivdPymt(java.lang.String divdPymt) {
		this.divdPymt = divdPymt;
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
    
   public java.lang.String getNatPennSymNum() {
		return natPennSymNum;
	}

	public void setNatPennSymNum(java.lang.String natPennSymNum) {
		this.natPennSymNum = natPennSymNum;
	}

	public java.lang.String getNatPennPayCalcSum() {
		return natPennPayCalcSum;
	}

	public void setNatPennPayCalcSum(java.lang.String natPennPayCalcSum) {
		this.natPennPayCalcSum = natPennPayCalcSum;
	}

}
