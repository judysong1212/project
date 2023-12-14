package com.app.exterms.prgm.client.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Bass0320VO.java
 * @Description : Bass0320 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PrgmComBass0320DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종명 : typOccuNm */
    private java.lang.String typOccuNm;

    /** set 직종사용여부 : typOccuUseYn */
    private java.lang.String typOccuUseYn;

    /** set 직종내용 : typOccuCtnt */
    private java.lang.String typOccuCtnt;

    /** set 정렬순서 : typOccuOrd */
    private java.math.BigDecimal typOccuOrd;

    /** set 직종직군구분코드 : typOccuJbfmlDivCd */
    private java.lang.String typOccuJbfmlDivCd;

    /** set null : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

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
    
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    /** set 단위기관코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    
    
	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2015 Nov 16, 2015 user:leeheuisung
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2015 Nov 16, 2015 user:leeheuisung
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getTypOccuUseYn() {
		return typOccuUseYn;
	}

	public void setTypOccuUseYn(java.lang.String typOccuUseYn) {
		this.typOccuUseYn = typOccuUseYn;
	}

	public java.lang.String getTypOccuCtnt() {
		return typOccuCtnt;
	}

	public void setTypOccuCtnt(java.lang.String typOccuCtnt) {
		this.typOccuCtnt = typOccuCtnt;
	}

	public java.math.BigDecimal getTypOccuOrd() {
		return typOccuOrd;
	}

	public void setTypOccuOrd(java.math.BigDecimal typOccuOrd) {
		this.typOccuOrd = typOccuOrd;
	}

	public java.lang.String getTypOccuJbfmlDivCd() {
		return typOccuJbfmlDivCd;
	}

	public void setTypOccuJbfmlDivCd(java.lang.String typOccuJbfmlDivCd) {
		this.typOccuJbfmlDivCd = typOccuJbfmlDivCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	} 
    
    
}
