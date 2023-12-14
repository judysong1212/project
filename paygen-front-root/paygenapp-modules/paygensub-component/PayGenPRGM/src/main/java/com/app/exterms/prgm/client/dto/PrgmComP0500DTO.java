package com.app.exterms.prgm.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0480VO.java
 * @Description : Payr0480 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.09.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComP0500DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;
    
    /** set 사업코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 부서코드 : businCd */
    private java.lang.String businCd;

    /** set 급여수당코드 : payExtpyCd */
    private java.lang.String payExtpyCd;

    /** set 급여수당그룹코드 : payExtpyGrpCd */
    private java.lang.String payExtpyGrpCd;

    /** set 급여수당명 : payExtpyNm */
    private java.lang.String payExtpyNm; 

    /** set 급여수당사용여부 : payExtpyUseYn */
    private java.lang.String payExtpyUseYn; 

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd; 

    /** set 급여수당공제금액 : payExtpySum */
    private Long payExtpySum ;

    /** set 급여수당공제비율 : payExtpyRto */
    private Double payExtpyRto ; 
 
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

    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getPayExtpyCd() {
        return this.payExtpyCd;
    }
    
    public void setPayExtpyCd(java.lang.String payExtpyCd) {
        this.payExtpyCd = payExtpyCd;
    }
    
    public java.lang.String getPayExtpyGrpCd() {
        return this.payExtpyGrpCd;
    }
    
    public void setPayExtpyGrpCd(java.lang.String payExtpyGrpCd) {
        this.payExtpyGrpCd = payExtpyGrpCd;
    }
    
    public java.lang.String getPayExtpyNm() {
        return this.payExtpyNm;
    }
    
    public void setPayExtpyNm(java.lang.String payExtpyNm) {
        this.payExtpyNm = payExtpyNm;
    }
     
    
    public java.lang.String getPayExtpyUseYn() {
        return this.payExtpyUseYn;
    }
    
    public void setPayExtpyUseYn(java.lang.String payExtpyUseYn) {
        this.payExtpyUseYn = payExtpyUseYn;
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

    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

    public Long getPayExtpySum() {
        return payExtpySum;
    }

    public void setPayExtpySum(Long payExtpySum) {
        this.payExtpySum = payExtpySum;
    }

    public Double getPayExtpyRto() {
        return payExtpyRto;
    }

    public void setPayExtpyRto(Double payExtpyRto) {
        this.payExtpyRto = payExtpyRto;
    }
    
}
