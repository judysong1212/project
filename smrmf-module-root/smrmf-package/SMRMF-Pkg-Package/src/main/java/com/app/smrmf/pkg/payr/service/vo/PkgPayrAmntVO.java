package com.app.smrmf.pkg.payr.service.vo;

import java.io.Serializable;
import java.math.BigDecimal;
 

/**
 * 
* <pre>
*  급여처리 에서 사용되는 공통 vo 
* 1. 패키지명 : com.app.smrmf.pkg.payr.service.vo
* 2. 타입명 : PkgPayrAmntVO.java
* 3. 작성일 : 2017. 4. 12. 오후 4:44:59
* 4. 작성자 : paygen
* 5. 설명 :
* </pre>
 */
public class PkgPayrAmntVO implements Serializable {
  
	private static final long serialVersionUID = 1L;
       
	// int result = 0;
    int iDducCnt = 0;   // 공제 카운트 
    boolean boolInsert = false;   //인서트 여부 
    
    //가족수당 합
    BigDecimal tpFamyExtpySum = BigDecimal.ZERO;
    
    BigDecimal tpFamyFreeExtpySum = BigDecimal.ZERO;
    
    //학비보조금함계
    BigDecimal  tpSchlExpnAdmclExtpySum = BigDecimal.ZERO;
    BigDecimal  tpStdPymtTotAmnt = BigDecimal.ZERO;   //기본
    //pymtTotAmnt 지급총액
    BigDecimal  tpPymtTotAmnt = BigDecimal.ZERO;
    //extpyTotAmnt 수당총액
    BigDecimal  tpExtpyTotAmnt = BigDecimal.ZERO;
    //txtnTotAmnt 과세총액 
    BigDecimal  tpTxtnTotAmnt = BigDecimal.ZERO;
    //freeDtyTotAmnt 비과세총액 
    BigDecimal  tpFreeDtyTotAmnt = BigDecimal.ZERO;
    //dducTotAmnt  공제총액 
    BigDecimal  tpDducTotAmnt = BigDecimal.ZERO;
      
    //기본급정보 
    BigDecimal basePymtAmnt =  BigDecimal.ZERO;
     
    //과세합계(소득세 ,지방소득세 합계) 
    BigDecimal txTotAmnt =  BigDecimal.ZERO;
     
    //월 출력체크 
    String chkMonth = "N" ;

    //노조회비 공제 대상 수당 합계 - 노조회비가 정해진 것이 아닌 다른 수당과 합하여 처리 할경우 사용 함.  
    BigDecimal  ucstSumD9500400 = BigDecimal.ZERO; 
     
    
    
	/**
	 * Comment : 노조회비 공제 대상 수당 
	 * @fn BigDecimal getUcstSumD9500400()
	 * @brief date:2017 2017. 10. 12. user:atres
	 * @return the ucstSumD9500400 get
	 */
	public BigDecimal getUcstSumD9500400() {
		return ucstSumD9500400;
	}

	/**
	 * Comment : 노조회비 공제 대상 수당 
	 *@fn void setUcstSumD9500400(BigDecimal ucstSumD9500400)
	 *@brief date:2017 2017. 10. 12. user:atres
	 *@param ucstSumD9500400 the ucstSumD9500400 to set
	 */
	public void setUcstSumD9500400(BigDecimal ucstSumD9500400) {
		this.ucstSumD9500400 = ucstSumD9500400;
	}

	/**
	 * Comment : 과세총액
	 * @fn BigDecimal getTpTxtnTotAmnt()
	 * @brief date:2017 2017. 10. 11. user:atres
	 * @return the tpTxtnTotAmnt get
	 */
	public BigDecimal getTpTxtnTotAmnt() {
		return tpTxtnTotAmnt;
	}

	/**
	 * Comment : 과세총액
	 *@fn void setTpTxtnTotAmnt(BigDecimal tpTxtnTotAmnt)
	 *@brief date:2017 2017. 10. 11. user:atres
	 *@param tpTxtnTotAmnt the tpTxtnTotAmnt to set
	 */
	public void setTpTxtnTotAmnt(BigDecimal tpTxtnTotAmnt) {
		this.tpTxtnTotAmnt = tpTxtnTotAmnt;
	}

	/**
	 * Comment : 공제 카운트
	 * @fn int getiDducCnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the iDducCnt get
	 */
	public int getiDducCnt() {
		return iDducCnt;
	}

	/**
	 * Comment : 공제카운트
	 *@fn void setiDducCnt(int iDducCnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param iDducCnt the iDducCnt to set
	 */
	public void setiDducCnt(int iDducCnt) {
		this.iDducCnt = iDducCnt;
	}

	/**
	 * Comment : 인서트 여부
	 * @fn boolean isBoolInsert()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the boolInsert get
	 */
	public boolean isBoolInsert() {
		return boolInsert;
	}

	/**
	 * Comment : 인서트 여부
	 *@fn void setBoolInsert(boolean boolInsert)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param boolInsert the boolInsert to set
	 */
	public void setBoolInsert(boolean boolInsert) {
		this.boolInsert = boolInsert;
	}

	/**
	 * Comment : 가족수당 합
	 * @fn BigDecimal getTpFamyExtpySum()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpFamyExtpySum get
	 */
	public BigDecimal getTpFamyExtpySum() {
		return tpFamyExtpySum;
	}

	/**
	 * Comment : 가족수당 합
	 *@fn void setTpFamyExtpySum(BigDecimal tpFamyExtpySum)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpFamyExtpySum the tpFamyExtpySum to set
	 */
	public void setTpFamyExtpySum(BigDecimal tpFamyExtpySum) {
		this.tpFamyExtpySum = tpFamyExtpySum;
	}

	/**
	 * Comment : 자녀보육공제가 있는 경우 비과세
	 * @fn BigDecimal getTpFamyFreeExtpySum()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpFamyFreeExtpySum get
	 */
	public BigDecimal getTpFamyFreeExtpySum() {
		return tpFamyFreeExtpySum;
	}

	/**
	 * Comment : 자녀보육공제가 있는 경우 비과세
	 *@fn void setTpFamyFreeExtpySum(BigDecimal tpFamyFreeExtpySum)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpFamyFreeExtpySum the tpFamyFreeExtpySum to set
	 */
	public void setTpFamyFreeExtpySum(BigDecimal tpFamyFreeExtpySum) {
		this.tpFamyFreeExtpySum = tpFamyFreeExtpySum;
	}

	/**
	 * Comment : 학비보조수당합계
	 * @fn BigDecimal getTpSchlExpnAdmclExtpySum()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpSchlExpnAdmclExtpySum get
	 */
	public BigDecimal getTpSchlExpnAdmclExtpySum() {
		return tpSchlExpnAdmclExtpySum;
	}

	/**
	 * Comment : 학비보조수당합계
	 *@fn void setTpSchlExpnAdmclExtpySum(BigDecimal tpSchlExpnAdmclExtpySum)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpSchlExpnAdmclExtpySum the tpSchlExpnAdmclExtpySum to set
	 */
	public void setTpSchlExpnAdmclExtpySum(BigDecimal tpSchlExpnAdmclExtpySum) {
		this.tpSchlExpnAdmclExtpySum = tpSchlExpnAdmclExtpySum;
	}

	/**
	 * Comment : 기본급처리 
	 * @fn BigDecimal getTpStdPymtTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpStdPymtTotAmnt get
	 */
	public BigDecimal getTpStdPymtTotAmnt() {
		return tpStdPymtTotAmnt;
	}

	/**
	 * Comment : 기본급처리 
	 *@fn void setTpStdPymtTotAmnt(BigDecimal tpStdPymtTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpStdPymtTotAmnt the tpStdPymtTotAmnt to set
	 */
	public void setTpStdPymtTotAmnt(BigDecimal tpStdPymtTotAmnt) {
		this.tpStdPymtTotAmnt = tpStdPymtTotAmnt;
	}

	/**
	 * Comment : 지급총액
	 * @fn BigDecimal getTpPymtTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpPymtTotAmnt get
	 */
	public BigDecimal getTpPymtTotAmnt() {
		return tpPymtTotAmnt;
	}

	/**
	 * Comment : 지급총액
	 *@fn void setTpPymtTotAmnt(BigDecimal tpPymtTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpPymtTotAmnt the tpPymtTotAmnt to set
	 */
	public void setTpPymtTotAmnt(BigDecimal tpPymtTotAmnt) {
		this.tpPymtTotAmnt = tpPymtTotAmnt;
	}

	/**
	 * Comment : 수당총액
	 * @fn BigDecimal getTpExtpyTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpExtpyTotAmnt get
	 */
	public BigDecimal getTpExtpyTotAmnt() {
		return tpExtpyTotAmnt;
	}

	/**
	 * Comment : 수당총액
	 *@fn void setTpExtpyTotAmnt(BigDecimal tpExtpyTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpExtpyTotAmnt the tpExtpyTotAmnt to set
	 */
	public void setTpExtpyTotAmnt(BigDecimal tpExtpyTotAmnt) {
		this.tpExtpyTotAmnt = tpExtpyTotAmnt;
	}

	/**
	 * Comment : 비과세총액
	 * @fn BigDecimal getTpFreeDtyTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpFreeDtyTotAmnt get
	 */
	public BigDecimal getTpFreeDtyTotAmnt() {
		return tpFreeDtyTotAmnt;
	}

	/**
	 * Comment : 비과세총액
	 *@fn void setTpFreeDtyTotAmnt(BigDecimal tpFreeDtyTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpFreeDtyTotAmnt the tpFreeDtyTotAmnt to set
	 */
	public void setTpFreeDtyTotAmnt(BigDecimal tpFreeDtyTotAmnt) {
		this.tpFreeDtyTotAmnt = tpFreeDtyTotAmnt;
	}

	/**
	 * Comment : 공제총액
	 * @fn BigDecimal getTpDducTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the tpDducTotAmnt get
	 */
	public BigDecimal getTpDducTotAmnt() {
		return tpDducTotAmnt;
	}

	/**
	 * Comment : 공제총액
	 *@fn void setTpDducTotAmnt(BigDecimal tpDducTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param tpDducTotAmnt the tpDducTotAmnt to set
	 */
	public void setTpDducTotAmnt(BigDecimal tpDducTotAmnt) {
		this.tpDducTotAmnt = tpDducTotAmnt;
	}

	/**
	 * Comment : 기본급정보 -전체
	 * @fn BigDecimal getBasePymtAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the basePymtAmnt get
	 */
	public BigDecimal getBasePymtAmnt() {
		return basePymtAmnt;
	}

	/**
	 * Comment : 기본급정보-전체
	 *@fn void setBasePymtAmnt(BigDecimal basePymtAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param basePymtAmnt the basePymtAmnt to set
	 */
	public void setBasePymtAmnt(BigDecimal basePymtAmnt) {
		this.basePymtAmnt = basePymtAmnt;
	}

	/**
	 * Comment : 과세합계
	 * @fn BigDecimal getTxTotAmnt()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the txTotAmnt get
	 */
	public BigDecimal getTxTotAmnt() {
		return txTotAmnt;
	}

	/**
	 * Comment : 과세합계
	 *@fn void setTxTotAmnt(BigDecimal txTotAmnt)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param txTotAmnt the txTotAmnt to set
	 */
	public void setTxTotAmnt(BigDecimal txTotAmnt) {
		this.txTotAmnt = txTotAmnt;
	}

	/**
	 * Comment : 월 출력체크
	 * @fn String getChkMonth()
	 * @brief date:2017 2017. 4. 12. user:paygen
	 * @return the chkMonth get
	 */
	public String getChkMonth() {
		return chkMonth;
	}

	/**
	 * Comment : 월 출력 체크 
	 *@fn void setChkMonth(String chkMonth)
	 *@brief date:2017 2017. 4. 12. user:paygen
	 *@param chkMonth the chkMonth to set
	 */
	public void setChkMonth(String chkMonth) {
		this.chkMonth = chkMonth;
	}
   

}
