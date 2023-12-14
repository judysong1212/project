package com.app.exterms.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0250VO.java
 * @Description : Payr0250 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0250VO  implements Serializable {
    private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 작업년월 : jobYrMnth */
    private java.lang.String jobYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 급여스케줄일련번호 : payScduSeilNum */
    private java.math.BigDecimal payScduSeilNum;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 담당직원번호 : pernChrgEmpIdenNum */
    private java.lang.String pernChrgEmpIdenNum;

    /** set 작업명 : jobNm */
    private java.lang.String jobNm;

    /** set 지급일자 : pymtDt */
    private java.lang.String pymtDt;

    /** set 반영시작일자 : rflctnBgnnDt */
    private java.lang.String rflctnBgnnDt;

    /** set 반영종료일자 : rflctnEndDt */
    private java.lang.String rflctnEndDt;

    /** set 급여마감일자 : payDdlneDt */
    private java.lang.String payDdlneDt;

    /** set 지로파일생성일자 : groFlCretnDt */
    private java.lang.String groFlCretnDt;

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

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 부서직종세그룹코드 : deptGpCd */
    private java.lang.String deptGpCd;

    /** set 호봉제구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;
    
 
    /** set 인사관리부서코드 : mangeDeptCd */
    private java.lang.String mangeDeptCd;
    
 
    // 차월지급여부
    private java.lang.String overYn;
     
	/**
	 * Comment : 관리부서코드
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 14. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 관리부서코드
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2018 2018. 3. 14. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

 
	public java.lang.String getOverYn() {
		return overYn;
	}

	public void setOverYn(java.lang.String overYn) {
		this.overYn = overYn;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getJobYrMnth() {
		return jobYrMnth;
	}

	public void setJobYrMnth(java.lang.String jobYrMnth) {
		this.jobYrMnth = jobYrMnth;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.math.BigDecimal getPayScduSeilNum() {
		return payScduSeilNum;
	}

	public void setPayScduSeilNum(java.math.BigDecimal payScduSeilNum) {
		this.payScduSeilNum = payScduSeilNum;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
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

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getPernChrgEmpIdenNum() {
		return pernChrgEmpIdenNum;
	}

	public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
		this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
	}

	public java.lang.String getJobNm() {
		return jobNm;
	}

	public void setJobNm(java.lang.String jobNm) {
		this.jobNm = jobNm;
	}

	public java.lang.String getPymtDt() {
		return pymtDt;
	}

	public void setPymtDt(java.lang.String pymtDt) {
		this.pymtDt = pymtDt;
	}

	public java.lang.String getRflctnBgnnDt() {
		return rflctnBgnnDt;
	}

	public void setRflctnBgnnDt(java.lang.String rflctnBgnnDt) {
		this.rflctnBgnnDt = rflctnBgnnDt;
	}

	public java.lang.String getRflctnEndDt() {
		return rflctnEndDt;
	}

	public void setRflctnEndDt(java.lang.String rflctnEndDt) {
		this.rflctnEndDt = rflctnEndDt;
	}

	public java.lang.String getPayDdlneDt() {
		return payDdlneDt;
	}

	public void setPayDdlneDt(java.lang.String payDdlneDt) {
		this.payDdlneDt = payDdlneDt;
	}

	public java.lang.String getGroFlCretnDt() {
		return groFlCretnDt;
	}

	public void setGroFlCretnDt(java.lang.String groFlCretnDt) {
		this.groFlCretnDt = groFlCretnDt;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getDeptGpCd() {
		return deptGpCd;
	}

	public void setDeptGpCd(java.lang.String deptGpCd) {
		this.deptGpCd = deptGpCd;
	}

	/**
	 * Comment : 호봉제구분코드
	 * @fn java.lang.String getRepbtyBusinDivCd()
	 * @brief date:2018 2018. 3. 15. user:atres
	 * @return the repbtyBusinDivCd get
	 */
	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	/**
	 * Comment : 호봉제구분코드
	 *@fn void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd)
	 *@brief date:2018 2018. 3. 15. user:atres
	 *@param repbtyBusinDivCd the repbtyBusinDivCd to set
	 */
	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

 
     
}
