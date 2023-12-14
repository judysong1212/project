package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class InfcPkgInsr4200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 공제년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 고용일련번호 : emymtSeilNum */
    private java.math.BigDecimal emymtSeilNum;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set 신고소득총액 : regrstIncmTotAmnt */
    private java.math.BigDecimal regrstIncmTotAmnt;

    /** set 결정기준소득월액 : deinStdIncmMnthAmnt */
    private java.math.BigDecimal deinStdIncmMnthAmnt;

    /** set 결정월보험료 : deinMnthPrmm */
    private java.math.BigDecimal deinMnthPrmm;

    /** set 본인부담액 : indvBrdnSum */
    private java.math.BigDecimal indvBrdnSum;

    /** set 본인소급보험료 : reattyQnty */
    private java.math.BigDecimal reattyQnty;

    /** set 본인정산보험료 : hmlfClutPrmm */
    private java.math.BigDecimal hmlfClutPrmm;

    /** set 본인보험료계 : hmlfPrmmAggr */
    private java.math.BigDecimal hmlfPrmmAggr;

    /** set 사업장부담액 : dpobBrdnSum */
    private java.math.BigDecimal dpobBrdnSum;

    /** set 사업자정산보험료 : busoprClutPrmm */
    private java.math.BigDecimal busoprClutPrmm;

    /** set 사업자소급보험료 : busoprReattyPrmm */
    private java.math.BigDecimal busoprReattyPrmm;

    /** set 사업자보험료계 : busoprPrmmAggr */
    private java.math.BigDecimal busoprPrmmAggr;

    /** set 본인납부보험료계 : aggr */
    private java.math.BigDecimal aggr;

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
    private java.math.BigDecimal natInsrPrmmSrd;

    /** set 분할납부구분코드 : divdPymtDivCd */
    private java.lang.String divdPymtDivCd;

    /** set 분할납부회수 : divdPymt */
    private java.math.BigDecimal divdPymt;


    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum; 
      
      private java.math.BigDecimal  natPennSymNum; 
      
      private java.math.BigDecimal   natPennPayCalcSum; 
      
     
    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getNatPennSymNum()
	 * @brief date:2017 2017. 4. 21. user:paygen
	 * @return the natPennSymNum get
	 */
	public java.math.BigDecimal getNatPennSymNum() {
		return natPennSymNum;
	}

	/**
	 * Comment : 
	 *@fn void setNatPennSymNum(java.math.BigDecimal natPennSymNum)
	 *@brief date:2017 2017. 4. 21. user:paygen
	 *@param natPennSymNum the natPennSymNum to set
	 */
	public void setNatPennSymNum(java.math.BigDecimal natPennSymNum) {
		this.natPennSymNum = natPennSymNum;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getNatPennPayCalcSum()
	 * @brief date:2017 2017. 4. 21. user:paygen
	 * @return the natPennPayCalcSum get
	 */
	public java.math.BigDecimal getNatPennPayCalcSum() {
		return natPennPayCalcSum;
	}

	/**
	 * Comment : 
	 *@fn void setNatPennPayCalcSum(java.math.BigDecimal natPennPayCalcSum)
	 *@brief date:2017 2017. 4. 21. user:paygen
	 *@param natPennPayCalcSum the natPennPayCalcSum to set
	 */
	public void setNatPennPayCalcSum(java.math.BigDecimal natPennPayCalcSum) {
		this.natPennPayCalcSum = natPennPayCalcSum;
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
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
    }
    
//    public java.math.BigDecimal getNatPennSeilNum() {
//        return this.natPennSeilNum;
//    }
//    
//    public void setNatPennSeilNum(java.math.BigDecimal natPennSeilNum) {
//        this.natPennSeilNum = natPennSeilNum;
//    }
    
    
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    /**
	 * Comment : 고용일련번호 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 고용일련번호 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
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
    
    public java.math.BigDecimal getRegrstIncmTotAmnt() {
        return this.regrstIncmTotAmnt;
    }
    
    public void setRegrstIncmTotAmnt(java.math.BigDecimal regrstIncmTotAmnt) {
        this.regrstIncmTotAmnt = regrstIncmTotAmnt;
    }
    
    public java.math.BigDecimal getDeinStdIncmMnthAmnt() {
        return this.deinStdIncmMnthAmnt;
    }
    
    public void setDeinStdIncmMnthAmnt(java.math.BigDecimal deinStdIncmMnthAmnt) {
        this.deinStdIncmMnthAmnt = deinStdIncmMnthAmnt;
    }
    
    public java.math.BigDecimal getDeinMnthPrmm() {
        return this.deinMnthPrmm;
    }
    
    public void setDeinMnthPrmm(java.math.BigDecimal deinMnthPrmm) {
        this.deinMnthPrmm = deinMnthPrmm;
    }
    
    public java.math.BigDecimal getIndvBrdnSum() {
        return this.indvBrdnSum;
    }
    
    public void setIndvBrdnSum(java.math.BigDecimal indvBrdnSum) {
        this.indvBrdnSum = indvBrdnSum;
    }
    
    public java.math.BigDecimal getReattyQnty() {
        return this.reattyQnty;
    }
    
    public void setReattyQnty(java.math.BigDecimal reattyQnty) {
        this.reattyQnty = reattyQnty;
    }
    
    public java.math.BigDecimal getHmlfClutPrmm() {
        return this.hmlfClutPrmm;
    }
    
    public void setHmlfClutPrmm(java.math.BigDecimal hmlfClutPrmm) {
        this.hmlfClutPrmm = hmlfClutPrmm;
    }
    
    public java.math.BigDecimal getHmlfPrmmAggr() {
        return this.hmlfPrmmAggr;
    }
    
    public void setHmlfPrmmAggr(java.math.BigDecimal hmlfPrmmAggr) {
        this.hmlfPrmmAggr = hmlfPrmmAggr;
    }
    
    public java.math.BigDecimal getDpobBrdnSum() {
        return this.dpobBrdnSum;
    }
    
    public void setDpobBrdnSum(java.math.BigDecimal dpobBrdnSum) {
        this.dpobBrdnSum = dpobBrdnSum;
    }
    
    public java.math.BigDecimal getBusoprClutPrmm() {
        return this.busoprClutPrmm;
    }
    
    public void setBusoprClutPrmm(java.math.BigDecimal busoprClutPrmm) {
        this.busoprClutPrmm = busoprClutPrmm;
    }
    
    public java.math.BigDecimal getBusoprReattyPrmm() {
        return this.busoprReattyPrmm;
    }
    
    public void setBusoprReattyPrmm(java.math.BigDecimal busoprReattyPrmm) {
        this.busoprReattyPrmm = busoprReattyPrmm;
    }
    
    public java.math.BigDecimal getBusoprPrmmAggr() {
        return this.busoprPrmmAggr;
    }
    
    public void setBusoprPrmmAggr(java.math.BigDecimal busoprPrmmAggr) {
        this.busoprPrmmAggr = busoprPrmmAggr;
    }
    
    public java.math.BigDecimal getAggr() {
        return this.aggr;
    }
    
    public void setAggr(java.math.BigDecimal aggr) {
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
	 * Comment : 원본 주민등록번호 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 원본 주민등록번호 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatPayrDducYrMnth()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the natPayrDducYrMnth get
	 */
	public java.lang.String getNatPayrDducYrMnth() {
		return natPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 *@fn void setNatPayrDducYrMnth(java.lang.String natPayrDducYrMnth)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param natPayrDducYrMnth the natPayrDducYrMnth to set
	 */
	public void setNatPayrDducYrMnth(java.lang.String natPayrDducYrMnth) {
		this.natPayrDducYrMnth = natPayrDducYrMnth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatInsrPrcsDt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the natInsrPrcsDt get
	 */
	public java.lang.String getNatInsrPrcsDt() {
		return natInsrPrcsDt;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrcsDt(java.lang.String natInsrPrcsDt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param natInsrPrcsDt the natInsrPrcsDt to set
	 */
	public void setNatInsrPrcsDt(java.lang.String natInsrPrcsDt) {
		this.natInsrPrcsDt = natInsrPrcsDt;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getNatInsrPrcsYn()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the natInsrPrcsYn get
	 */
	public java.lang.String getNatInsrPrcsYn() {
		return natInsrPrcsYn;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrcsYn(java.lang.String natInsrPrcsYn)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param natInsrPrcsYn the natInsrPrcsYn to set
	 */
	public void setNatInsrPrcsYn(java.lang.String natInsrPrcsYn) {
		this.natInsrPrcsYn = natInsrPrcsYn;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getNatInsrPrmmSrd()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the natInsrPrmmSrd get
	 */
	public java.math.BigDecimal getNatInsrPrmmSrd() {
		return natInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 *@fn void setNatInsrPrmmSrd(java.math.BigDecimal natInsrPrmmSrd)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param natInsrPrmmSrd the natInsrPrmmSrd to set
	 */
	public void setNatInsrPrmmSrd(java.math.BigDecimal natInsrPrmmSrd) {
		this.natInsrPrmmSrd = natInsrPrmmSrd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDivdPymtDivCd()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the divdPymtDivCd get
	 */
	public java.lang.String getDivdPymtDivCd() {
		return divdPymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymtDivCd(java.lang.String divdPymtDivCd)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param divdPymtDivCd the divdPymtDivCd to set
	 */
	public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
		this.divdPymtDivCd = divdPymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getDivdPymt()
	 * @brief date:2017 2017. 4. 11. user:paygen
	 * @return the divdPymt get
	 */
	public java.math.BigDecimal getDivdPymt() {
		return divdPymt;
	}

	/**
	 * Comment : 
	 *@fn void setDivdPymt(java.math.BigDecimal divdPymt)
	 *@brief date:2017 2017. 4. 11. user:paygen
	 *@param divdPymt the divdPymt to set
	 */
	public void setDivdPymt(java.math.BigDecimal divdPymt) {
		this.divdPymt = divdPymt;
	}
    
    
    
}
