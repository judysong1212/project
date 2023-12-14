package com.app.smrmf.pkg.insr.insurance.service;

import java.io.Serializable;
import java.math.BigDecimal;
 
/**
 * 
* <pre>
* 4대 보험 처리에 따른 값을 가지고 있는 VO
* 1. 패키지명 : com.app.smrmf.pkg.insr.insurance.service
* 2. 타입명 : PkgInsrWorkVO.java
* 3. 작성일 : 2016. 12. 26. 오후 9:39:37
* 4. 작성자 : atres-pc
* 5. 설명 :
* </pre>
 */
public class PkgInsrWorkVO implements Serializable {
  
	private static final long serialVersionUID = 1L;
     
    
    //건강보험 HLTH_INSR_PRMM_SRD	9			Y	NUMBER (10)		건강보험보험료차액    D0010100
    java.math.BigDecimal tpHlthInsrPayAmt = BigDecimal.ZERO; 
    //요양 보험 LGTM_RCPTN_INSUR_SRD	10			Y	NUMBER (10)		장기요양보험차액       D0110100
    java.math.BigDecimal tpHlthInsrRcptnPayAmt = BigDecimal.ZERO; 
   // YRTX_PRMM	11			Y	NUMBER (10)		건강보험정산보험료            D0010200
  //  java.math.BigDecimal tpYrtxPrmm = BigDecimal.ZERO;
   // LGTM_RCPTN_YRTX_PRMM	12			Y	NUMBER (10)		장기요양정산보험료     D0110200
  //  java.math.BigDecimal tpLgtmRcptnYrtxPrmm = BigDecimal.ZERO;
   // HLTH_INSR_REFD_ITRT	13			Y	NUMBER (10)		건강보험환급금이자   D0010500
  //  java.math.BigDecimal tpHlthInsrRefdItrt = BigDecimal.ZERO;
   // LGTM_RCPTN_INSUR_REFD_ITRT	14			Y	NUMBER (10)		장기요양보험환급금이자  D0110500
  //  java.math.BigDecimal tpLgtmRcptnInsurRefdItrt = BigDecimal.ZERO;
    
   //건강보험
    private java.lang.String sumChkD0010100;
   //건강요양보험 
    private java.lang.String  sumChkD0110100;
   //국민연금 
    private java.lang.String sumChkD0150100;
    //고용보험 
    private java.lang.String  sumChkD0160100;
    
    
    //국민연금  
    java.math.BigDecimal tpNatPennAmt = BigDecimal.ZERO;
    //고용 보험 
    java.math.BigDecimal tpUmytInsrApptnAmt = BigDecimal.ZERO;
    //과세대상금액 
    java.math.BigDecimal tpWorkIncmTxtnSum =  BigDecimal.ZERO; 
    
  // 과세총액 
    java.math.BigDecimal tpTxtnTotAmnt =  BigDecimal.ZERO; 
    
   // 공제총액 
    java.math.BigDecimal tpDducTotAmnt =  BigDecimal.ZERO; 
    
  //기본
    java.math.BigDecimal tpStdPymtTotAmnt =  BigDecimal.ZERO; 
    
    
    //보수금액 
    java.math.BigDecimal  tpPymtAmnt =   BigDecimal.ZERO; 
    
    
    
//    /**
//	 * Comment : 건강보험정산보험료
//	 * @fn java.math.BigDecimal getTpYrtxPrmm()
//	 * @brief date:2017 2017. 7. 25. user:atres
//	 * @return the tpYrtxPrmm get
//	 */
//	public java.math.BigDecimal getTpYrtxPrmm() {
//		return tpYrtxPrmm;
//	}
//
//	/**
//	 * Comment : 건강보험정산보험료
//	 *@fn void setTpYrtxPrmm(java.math.BigDecimal tpYrtxPrmm)
//	 *@brief date:2017 2017. 7. 25. user:atres
//	 *@param tpYrtxPrmm the tpYrtxPrmm to set
//	 */
//	public void setTpYrtxPrmm(java.math.BigDecimal tpYrtxPrmm) {
//		this.tpYrtxPrmm = tpYrtxPrmm;
//	}
//
//	/**
//	 * Comment : 장기요양정산보험료
//	 * @fn java.math.BigDecimal getTpLgtmRcptnYrtxPrmm()
//	 * @brief date:2017 2017. 7. 25. user:atres
//	 * @return the tpLgtmRcptnYrtxPrmm get
//	 */
//	public java.math.BigDecimal getTpLgtmRcptnYrtxPrmm() {
//		return tpLgtmRcptnYrtxPrmm;
//	}
//
//	/**
//	 * Comment : 장기요양정산보험료
//	 *@fn void setTpLgtmRcptnYrtxPrmm(java.math.BigDecimal tpLgtmRcptnYrtxPrmm)
//	 *@brief date:2017 2017. 7. 25. user:atres
//	 *@param tpLgtmRcptnYrtxPrmm the tpLgtmRcptnYrtxPrmm to set
//	 */
//	public void setTpLgtmRcptnYrtxPrmm(java.math.BigDecimal tpLgtmRcptnYrtxPrmm) {
//		this.tpLgtmRcptnYrtxPrmm = tpLgtmRcptnYrtxPrmm;
//	}
//
//	/**
//	 * Comment : 건강보험환급금이자
//	 * @fn java.math.BigDecimal getTpHlthInsrRefdItrt()
//	 * @brief date:2017 2017. 7. 25. user:atres
//	 * @return the tpHlthInsrRefdItrt get
//	 */
//	public java.math.BigDecimal getTpHlthInsrRefdItrt() {
//		return tpHlthInsrRefdItrt;
//	}
//
//	/**
//	 * Comment : 건강보험환급금이자
//	 *@fn void setTpHlthInsrRefdItrt(java.math.BigDecimal tpHlthInsrRefdItrt)
//	 *@brief date:2017 2017. 7. 25. user:atres
//	 *@param tpHlthInsrRefdItrt the tpHlthInsrRefdItrt to set
//	 */
//	public void setTpHlthInsrRefdItrt(java.math.BigDecimal tpHlthInsrRefdItrt) {
//		this.tpHlthInsrRefdItrt = tpHlthInsrRefdItrt;
//	}
//
//	/**
//	 * Comment : 장기요양보험환급금이자
//	 * @fn java.math.BigDecimal getTpLgtmRcptnInsurRefdItrt()
//	 * @brief date:2017 2017. 7. 25. user:atres
//	 * @return the tpLgtmRcptnInsurRefdItrt get
//	 */
//	public java.math.BigDecimal getTpLgtmRcptnInsurRefdItrt() {
//		return tpLgtmRcptnInsurRefdItrt;
//	}
//
//	/**
//	 * Comment : 장기요양보험환급금이자
//	 *@fn void setTpLgtmRcptnInsurRefdItrt(java.math.BigDecimal tpLgtmRcptnInsurRefdItrt)
//	 *@brief date:2017 2017. 7. 25. user:atres
//	 *@param tpLgtmRcptnInsurRefdItrt the tpLgtmRcptnInsurRefdItrt to set
//	 */
//	public void setTpLgtmRcptnInsurRefdItrt(
//			java.math.BigDecimal tpLgtmRcptnInsurRefdItrt) {
//		this.tpLgtmRcptnInsurRefdItrt = tpLgtmRcptnInsurRefdItrt;
//	}

	/**
	 * Comment : 건강보험 재계산여부 체크 
	 * @fn java.lang.String getSumChkD0010100()
	 * @brief date:2017 2017. 7. 25. user:atres
	 * @return the sumChkD0010100 get
	 */
	public java.lang.String getSumChkD0010100() {
		return sumChkD0010100;
	}

	/**
	 * Comment : 건강보험 재계산여부 체크 
	 *@fn void setSumChkD0010100(java.lang.String sumChkD0010100)
	 *@brief date:2017 2017. 7. 25. user:atres
	 *@param sumChkD0010100 the sumChkD0010100 to set
	 */
	public void setSumChkD0010100(java.lang.String sumChkD0010100) {
		this.sumChkD0010100 = sumChkD0010100;
	}

	/**
	 * Comment : 건강보험요양 재계산여부 체크 
	 * @fn java.lang.String getSumChkD0110100()
	 * @brief date:2017 2017. 7. 25. user:atres
	 * @return the sumChkD0110100 get
	 */
	public java.lang.String getSumChkD0110100() {
		return sumChkD0110100;
	}

	/**
	 * Comment : 건강보험 요양 재계산여부 체크 
	 *@fn void setSumChkD0110100(java.lang.String sumChkD0110100)
	 *@brief date:2017 2017. 7. 25. user:atres
	 *@param sumChkD0110100 the sumChkD0110100 to set
	 */
	public void setSumChkD0110100(java.lang.String sumChkD0110100) {
		this.sumChkD0110100 = sumChkD0110100;
	}

	/**
	 * Comment : 국민연금 재계산여부 
	 * @fn java.lang.String getSumChkD0150100()
	 * @brief date:2017 2017. 7. 25. user:atres
	 * @return the sumChkD0150100 get
	 */
	public java.lang.String getSumChkD0150100() {
		return sumChkD0150100;
	}

	/**
	 * Comment : 국민연금 재계산여부 
	 *@fn void setSumChkD0150100(java.lang.String sumChkD0150100)
	 *@brief date:2017 2017. 7. 25. user:atres
	 *@param sumChkD0150100 the sumChkD0150100 to set
	 */
	public void setSumChkD0150100(java.lang.String sumChkD0150100) {
		this.sumChkD0150100 = sumChkD0150100;
	}

	/**
	 * Comment : 고용보험 재계산 여부 체크 
	 * @fn java.lang.String getSumChkD0160100()
	 * @brief date:2017 2017. 7. 25. user:atres
	 * @return the sumChkD0160100 get
	 */
	public java.lang.String getSumChkD0160100() {
		return sumChkD0160100;
	}

	/**
	 * Comment : 고용보험 재계산 여부 체크 
	 *@fn void setSumChkD0160100(java.lang.String sumChkD0160100)
	 *@brief date:2017 2017. 7. 25. user:atres
	 *@param sumChkD0160100 the sumChkD0160100 to set
	 */
	public void setSumChkD0160100(java.lang.String sumChkD0160100) {
		this.sumChkD0160100 = sumChkD0160100;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTpPymtAmnt()
	 * @brief date:2016 2016. 12. 26. user:atres-pc
	 * @return the tpPymtAmnt get
	 */
	public java.math.BigDecimal getTpPymtAmnt() {
		return tpPymtAmnt;
	}

	/**
	 * Comment : 
	 *@fn void setTpPymtAmnt(java.math.BigDecimal tpPymtAmnt)
	 *@brief date:2016 2016. 12. 26. user:atres-pc
	 *@param tpPymtAmnt the tpPymtAmnt to set
	 */
	public void setTpPymtAmnt(java.math.BigDecimal tpPymtAmnt) {
		this.tpPymtAmnt = tpPymtAmnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getTpNatPennAmt()
	 * @brief date:2016 2016. 12. 26. user:atres-pc
	 * @return the tpNatPennAmt get
	 */
	public java.math.BigDecimal getTpNatPennAmt() {
		return tpNatPennAmt;
	}

	/**
	 * Comment : 
	 *@fn void setTpNatPennAmt(java.math.BigDecimal tpNatPennAmt)
	 *@brief date:2016 2016. 12. 26. user:atres-pc
	 *@param tpNatPennAmt the tpNatPennAmt to set
	 */
	public void setTpNatPennAmt(java.math.BigDecimal tpNatPennAmt) {
		this.tpNatPennAmt = tpNatPennAmt;
	}

	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpHlthInsrPayAmt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpHlthInsrPayAmt get
  	 */
  	public java.math.BigDecimal getTpHlthInsrPayAmt() {
  		return tpHlthInsrPayAmt;
  	}

  	/**
  	 * Comment : 건강보험 
  	 *@fn void setTpHlthInsrPayAmt(java.math.BigDecimal tpHlthInsrPayAmt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpHlthInsrPayAmt the tpHlthInsrPayAmt to set
  	 */
  	public void setTpHlthInsrPayAmt(java.math.BigDecimal tpHlthInsrPayAmt) {
  		this.tpHlthInsrPayAmt = tpHlthInsrPayAmt;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpHlthInsrRcptnPayAmt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpHlthInsrRcptnPayAmt get
  	 */
  	public java.math.BigDecimal getTpHlthInsrRcptnPayAmt() {
  		return tpHlthInsrRcptnPayAmt;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpHlthInsrRcptnPayAmt(java.math.BigDecimal tpHlthInsrRcptnPayAmt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpHlthInsrRcptnPayAmt the tpHlthInsrRcptnPayAmt to set
  	 */
  	public void setTpHlthInsrRcptnPayAmt(java.math.BigDecimal tpHlthInsrRcptnPayAmt) {
  		this.tpHlthInsrRcptnPayAmt = tpHlthInsrRcptnPayAmt;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpUmytInsrApptnAmt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpUmytInsrApptnAmt get
  	 */
  	public java.math.BigDecimal getTpUmytInsrApptnAmt() {
  		return tpUmytInsrApptnAmt;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpUmytInsrApptnAmt(java.math.BigDecimal tpUmytInsrApptnAmt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpUmytInsrApptnAmt the tpUmytInsrApptnAmt to set
  	 */
  	public void setTpUmytInsrApptnAmt(java.math.BigDecimal tpUmytInsrApptnAmt) {
  		this.tpUmytInsrApptnAmt = tpUmytInsrApptnAmt;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpWorkIncmTxtnSum()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpWorkIncmTxtnSum get
  	 */
  	public java.math.BigDecimal getTpWorkIncmTxtnSum() {
  		return tpWorkIncmTxtnSum;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpWorkIncmTxtnSum(java.math.BigDecimal tpWorkIncmTxtnSum)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpWorkIncmTxtnSum the tpWorkIncmTxtnSum to set
  	 */
  	public void setTpWorkIncmTxtnSum(java.math.BigDecimal tpWorkIncmTxtnSum) {
  		this.tpWorkIncmTxtnSum = tpWorkIncmTxtnSum;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpTxtnTotAmnt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpTxtnTotAmnt get
  	 */
  	public java.math.BigDecimal getTpTxtnTotAmnt() {
  		return tpTxtnTotAmnt;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpTxtnTotAmnt(java.math.BigDecimal tpTxtnTotAmnt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpTxtnTotAmnt the tpTxtnTotAmnt to set
  	 */
  	public void setTpTxtnTotAmnt(java.math.BigDecimal tpTxtnTotAmnt) {
  		this.tpTxtnTotAmnt = tpTxtnTotAmnt;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpDducTotAmnt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpDducTotAmnt get
  	 */
  	public java.math.BigDecimal getTpDducTotAmnt() {
  		return tpDducTotAmnt;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpDducTotAmnt(java.math.BigDecimal tpDducTotAmnt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpDducTotAmnt the tpDducTotAmnt to set
  	 */
  	public void setTpDducTotAmnt(java.math.BigDecimal tpDducTotAmnt) {
  		this.tpDducTotAmnt = tpDducTotAmnt;
  	}

  	/**
  	 * Comment : 
  	 * @fn java.math.BigDecimal getTpStdPymtTotAmnt()
  	 * @brief date:2016 2016. 12. 26. user:atres-pc
  	 * @return the tpStdPymtTotAmnt get
  	 */
  	public java.math.BigDecimal getTpStdPymtTotAmnt() {
  		return tpStdPymtTotAmnt;
  	}

  	/**
  	 * Comment : 
  	 *@fn void setTpStdPymtTotAmnt(java.math.BigDecimal tpStdPymtTotAmnt)
  	 *@brief date:2016 2016. 12. 26. user:atres-pc
  	 *@param tpStdPymtTotAmnt the tpStdPymtTotAmnt to set
  	 */
  	public void setTpStdPymtTotAmnt(java.math.BigDecimal tpStdPymtTotAmnt) {
  		this.tpStdPymtTotAmnt = tpStdPymtTotAmnt;
  	}

 
//  	 public class BaseObject implements Serializable {
//  		 
//  	     public String toString() {
//  	         // ToStringBuilder.relfectionToString 을 통해 내부 멤버변수의 값을 모두 찍어준다.
//  	         return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//  	     }
//  	     
//  	     public boolean equals(Object o) {
//  	         return EqualsBuilder.reflectionEquals(this,    0);
//  	     }
//  	     
//  	     public int hashCode() {
//  	         return HashCodeBuilder.reflectionHashCode(this);
//  	     }
//  	     
//  	 }

}
