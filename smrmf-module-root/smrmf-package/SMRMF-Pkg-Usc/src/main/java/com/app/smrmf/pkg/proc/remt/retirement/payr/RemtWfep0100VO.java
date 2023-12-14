/**
 * 최근 3개월간 기본급여 및 제수당 
 */
package com.app.smrmf.pkg.proc.remt.retirement.payr;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Remt2000VO.java
 * @Description : Remt2000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtWfep0100VO  implements Serializable {
    private static final long serialVersionUID = 1L;
  
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;
    
    /** set 지급공제항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 지급공제항목명 : payItemNm */
    private java.lang.String payItemNm;

    /** set 수당그룹코드 : extpyGrpCd */
    private java.lang.String extpyGrpCd;

    /** set 수당그룹명 : extpyGrpNm */
    private java.lang.String extpyGrpNm;
 
    /** set 개월 : itemMonths */
    private  java.lang.String  itemMonths;
 

    /** set 지급금액 :  pymtSum */
    private BigDecimal pymtSum;


	public java.lang.String getDpobCd() {
		return dpobCd;
	}


	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}


	public java.lang.String getSystemkey() {
		return systemkey;
	}


	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}


	public java.lang.String getPayItemCd() {
		return payItemCd;
	}


	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}


	public java.lang.String getPayItemNm() {
		return payItemNm;
	}


	public void setPayItemNm(java.lang.String payItemNm) {
		this.payItemNm = payItemNm;
	}


	public java.lang.String getExtpyGrpCd() {
		return extpyGrpCd;
	}


	public void setExtpyGrpCd(java.lang.String extpyGrpCd) {
		this.extpyGrpCd = extpyGrpCd;
	}


	public java.lang.String getExtpyGrpNm() {
		return extpyGrpNm;
	}


	public void setExtpyGrpNm(java.lang.String extpyGrpNm) {
		this.extpyGrpNm = extpyGrpNm;
	}


	public java.lang.String getItemMonths() {
		return itemMonths;
	}


	public void setItemMonths(java.lang.String itemMonths) {
		this.itemMonths = itemMonths;
	}


	public BigDecimal getPymtSum() {
		return pymtSum;
	}


	public void setPymtSum(BigDecimal pymtSum) {
		this.pymtSum = pymtSum;
	}
    
  
    
}
