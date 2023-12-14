package org.msf.exterms.xls.service;

import java.io.Serializable;

/**
 * @Class Name : Payr0100VO.java
 * @Description : Payr0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr4200TotVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
      
    private java.lang.String pymtYrMnth;    //지급년
    private java.lang.String deptCd;        //부서코드 
    private java.lang.String deptNm;        //부서명 
    private java.lang.String systemkey;     //시스템키 
    private java.lang.String resnRegnNum;   //주민번호 
    private java.lang.String hanNm;          //한글성명  
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    private java.lang.String emymtDivCd;
    private java.lang.String  emymtDivNm;
    
    private java.lang.String typOccuCd;	         //직종	 	
    
    private java.lang.String dtilOccuClsDivCd; //직종세	 	
    
    private java.lang.String logSvcYrNumCd;    //근속년수 	
    
    private java.lang.String typOccuNm;	         //직종	 	
    
    private java.lang.String dtilOccuClsDivNm; //직종세	 	
    
    private java.lang.String logSvcYrNumNm;    //근속년수 	
    
    private java.lang.String  businCd;
    
    private java.lang.String  businNm;
    
    private java.lang.String  pyspGrdeCd;
    
    private java.lang.String  pyspGrdeNm;
    
    private java.lang.String   logSvcMnthIcmCd;
    
    private java.lang.String   logSvcMnthIcmNm;
     
    /** set 기본급 : pymtBaseAmnt */
    private java.math.BigDecimal pymtBaseAmnt;
    
    /** set 지급총액 : pymtTotAmnt */
    private java.math.BigDecimal pymtTotAmnt;

    /** set 수당총액 : extpyTotAmnt */
    private java.math.BigDecimal extpyTotAmnt;

    /** set 과세총액 : txtnTotAmnt */
    private java.math.BigDecimal txtnTotAmnt;

    /** set 비과세총액 : freeDtyTotAmnt */
    private java.math.BigDecimal freeDtyTotAmnt;
    

    /** set 공제금액 : dducAmnt */
    private java.math.BigDecimal dducAmnt; 

    /** set 공제총액 : dducTotAmnt */
    private java.math.BigDecimal dducTotAmnt;

    /** set 세금총액 : txTotAmnt */
    private java.math.BigDecimal txTotAmnt;
 
    /** set 공제금액-건강보험 : dducAmnt */
    private java.math.BigDecimal dducHlthAmnt;
    
    /** set 공제금액-국민연금 : dducAmnt */
    private java.math.BigDecimal dducNatAmnt;
    
    /** set 공제금액-고용보험 : dducAmnt */
    private java.math.BigDecimal dducUmytAmnt;
    
    /** set 차인지급액 : pernPymtSum */
    private java.math.BigDecimal pernPymtSum;
 
    /** set 급여마감일자 : payDdlneDt */
    private java.lang.String payDdlneDt;

    /** set 급여마감여부 : payDdlneYn */
    private java.lang.String payDdlneYn;

	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
  
   
    
	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 5, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 5, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public java.lang.String getLogSvcMnthIcmCd() {
		return logSvcMnthIcmCd;
	}

	public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
		this.logSvcMnthIcmCd = logSvcMnthIcmCd;
	}

	public java.lang.String getLogSvcMnthIcmNm() {
		return logSvcMnthIcmNm;
	}

	public void setLogSvcMnthIcmNm(java.lang.String logSvcMnthIcmNm) {
		this.logSvcMnthIcmNm = logSvcMnthIcmNm;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
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

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public java.lang.String getLogSvcYrNumNm() {
		return logSvcYrNumNm;
	}

	public void setLogSvcYrNumNm(java.lang.String logSvcYrNumNm) {
		this.logSvcYrNumNm = logSvcYrNumNm;
	}

	public java.math.BigDecimal getPymtBaseAmnt() {
		return pymtBaseAmnt;
	}

	public void setPymtBaseAmnt(java.math.BigDecimal pymtBaseAmnt) {
		this.pymtBaseAmnt = pymtBaseAmnt;
	}

	public java.math.BigDecimal getPymtTotAmnt() {
		return pymtTotAmnt;
	}

	public void setPymtTotAmnt(java.math.BigDecimal pymtTotAmnt) {
		this.pymtTotAmnt = pymtTotAmnt;
	}

	public java.math.BigDecimal getExtpyTotAmnt() {
		return extpyTotAmnt;
	}

	public void setExtpyTotAmnt(java.math.BigDecimal extpyTotAmnt) {
		this.extpyTotAmnt = extpyTotAmnt;
	}

	public java.math.BigDecimal getTxtnTotAmnt() {
		return txtnTotAmnt;
	}

	public void setTxtnTotAmnt(java.math.BigDecimal txtnTotAmnt) {
		this.txtnTotAmnt = txtnTotAmnt;
	}

	public java.math.BigDecimal getFreeDtyTotAmnt() {
		return freeDtyTotAmnt;
	}

	public void setFreeDtyTotAmnt(java.math.BigDecimal freeDtyTotAmnt) {
		this.freeDtyTotAmnt = freeDtyTotAmnt;
	}

	public java.math.BigDecimal getDducAmnt() {
		return dducAmnt;
	}

	public void setDducAmnt(java.math.BigDecimal dducAmnt) {
		this.dducAmnt = dducAmnt;
	}

	public java.math.BigDecimal getDducTotAmnt() {
		return dducTotAmnt;
	}

	public void setDducTotAmnt(java.math.BigDecimal dducTotAmnt) {
		this.dducTotAmnt = dducTotAmnt;
	}

	public java.math.BigDecimal getTxTotAmnt() {
		return txTotAmnt;
	}

	public void setTxTotAmnt(java.math.BigDecimal txTotAmnt) {
		this.txTotAmnt = txTotAmnt;
	}

	public java.math.BigDecimal getDducHlthAmnt() {
		return dducHlthAmnt;
	}

	public void setDducHlthAmnt(java.math.BigDecimal dducHlthAmnt) {
		this.dducHlthAmnt = dducHlthAmnt;
	}

	public java.math.BigDecimal getDducNatAmnt() {
		return dducNatAmnt;
	}

	public void setDducNatAmnt(java.math.BigDecimal dducNatAmnt) {
		this.dducNatAmnt = dducNatAmnt;
	}

	public java.math.BigDecimal getDducUmytAmnt() {
		return dducUmytAmnt;
	}

	public void setDducUmytAmnt(java.math.BigDecimal dducUmytAmnt) {
		this.dducUmytAmnt = dducUmytAmnt;
	}

	public java.math.BigDecimal getPernPymtSum() {
		return pernPymtSum;
	}

	public void setPernPymtSum(java.math.BigDecimal pernPymtSum) {
		this.pernPymtSum = pernPymtSum;
	}

	public java.lang.String getPayDdlneDt() {
		return payDdlneDt;
	}

	public void setPayDdlneDt(java.lang.String payDdlneDt) {
		this.payDdlneDt = payDdlneDt;
	}

	public java.lang.String getPayDdlneYn() {
		return payDdlneYn;
	}

	public void setPayDdlneYn(java.lang.String payDdlneYn) {
		this.payDdlneYn = payDdlneYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

     
    
}
