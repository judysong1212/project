package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Psnl0101DTO.java
 * @Description : Psnl0101 DTO.class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0101DTO extends BaseModel {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 기준고용일련번호 : psnlBseSeilNum */
    private java.math.BigDecimal psnlBseSeilNum;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 최초고용일자 : frstBseEmymtDt */
    private java.lang.String frstBseEmymtDt;

    /** set 국가코드 : natnCd */
    private java.lang.String natnCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 현소속부서코드 : currAffnDeptCd */
    private java.lang.String currAffnDeptCd;

    /** set 담당업무구분코드 : repbtyBusinDivCd */
    private java.lang.String repbtyBusinDivCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직책코드 : odtyCd */
    private java.lang.String odtyCd;

    /** set 고용시작일자 : emymtBgnnDt */
    private java.lang.String emymtBgnnDt;

    /** set 고용종료일자 : emymtEndDt */
    private java.lang.String emymtEndDt;

    /** set 호봉코드 : pyspCd */
    private java.lang.String pyspCd;

    /** set 재직상태코드 : hdofcCodtnCd */
    private java.lang.String hdofcCodtnCd;

    /** set 퇴직일자 : retryDt */
    private java.lang.String retryDt;

    /** set 퇴직사유내용 : retryReasCtnt */
    private java.lang.String retryReasCtnt;

    /** set 외국인구분코드 : frgnrDivCd */
    private java.lang.String frgnrDivCd;

    /** set 여권번호 : psptNum */
    private java.lang.String psptNum;

    /** set 체류시작일자 : styBgnnDt */
    private java.lang.String styBgnnDt;

    /** set 체류종료일자 : styEndDt */
    private java.lang.String styEndDt;

    /** set 최종학교 : endSchl */
    private java.lang.String endSchl;

    /** set 최종학위구분코드 : endDegrDivCd */
    private java.lang.String endDegrDivCd;

    /** set 승진예정일자 : pmtnScduDt */
    private java.lang.String pmtnScduDt;

    /** set 호봉승급예정일자 : pyspPrmtnScduDt */
    private java.lang.String pyspPrmtnScduDt;

    /** set 재고용예정일자 : reymnScduDt */
    private java.lang.String reymnScduDt;

    /** set 근속년수코드 : logSvcYrNumCd */
    private java.lang.String logSvcYrNumCd;

    /** set 근속월수코드 : logSvcMnthIcmCd */
    private java.lang.String logSvcMnthIcmCd;

    /** set 현_호봉발령일자 : currPyspAppmtDt */
    private java.lang.String currPyspAppmtDt;

    /** set 현_부서발령일자 : currDeptAppmtDt */
    private java.lang.String currDeptAppmtDt;

    /** set 인사비고내용 : pernNoteCtnt */
    private java.lang.String pernNoteCtnt;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 담당업무명 : repbtyBusinNm */
    private java.lang.String repbtyBusinNm;

    /** set null : secResnNum */
    private java.lang.String secResnNum;

    /** set null : orgResnNum */
    private java.lang.String orgResnNum;

    /** set 노조가입여부 : unnMbspSttYn */
    private java.lang.String unnMbspSttYn;

    /** set 근속일수 : logSvcDys */
    private java.math.BigDecimal logSvcDys;

    /** set 원근속년수코드 : orgLogSvcYrCd */
    private java.lang.String orgLogSvcYrCd;

    /** set 원근속월수코드 : orgLogSvcMnthCd */
    private java.lang.String orgLogSvcMnthCd;

    /** set 원근속일수 : orgLogSvcDys */
    private java.math.BigDecimal orgLogSvcDys;

    /** set 재획정일자 : reMrkDt */
    private java.lang.String reMrkDt;

    /** set 근속기준일자 : logStdDt */
    private java.lang.String logStdDt;

    /** set 총근속일수 : totLogSvcDys */
    private java.math.BigDecimal totLogSvcDys;

    /** set 원총근속일수 : orgTotLogSvcDys */
    private java.math.BigDecimal orgTotLogSvcDys;

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

	public java.math.BigDecimal getPsnlBseSeilNum() {
		return psnlBseSeilNum;
	}

	public void setPsnlBseSeilNum(java.math.BigDecimal psnlBseSeilNum) {
		this.psnlBseSeilNum = psnlBseSeilNum;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getFrstBseEmymtDt() {
		return frstBseEmymtDt;
	}

	public void setFrstBseEmymtDt(java.lang.String frstBseEmymtDt) {
		this.frstBseEmymtDt = frstBseEmymtDt;
	}

	public java.lang.String getNatnCd() {
		return natnCd;
	}

	public void setNatnCd(java.lang.String natnCd) {
		this.natnCd = natnCd;
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

	public java.lang.String getCurrAffnDeptCd() {
		return currAffnDeptCd;
	}

	public void setCurrAffnDeptCd(java.lang.String currAffnDeptCd) {
		this.currAffnDeptCd = currAffnDeptCd;
	}

	public java.lang.String getRepbtyBusinDivCd() {
		return repbtyBusinDivCd;
	}

	public void setRepbtyBusinDivCd(java.lang.String repbtyBusinDivCd) {
		this.repbtyBusinDivCd = repbtyBusinDivCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getOdtyCd() {
		return odtyCd;
	}

	public void setOdtyCd(java.lang.String odtyCd) {
		this.odtyCd = odtyCd;
	}

	public java.lang.String getEmymtBgnnDt() {
		return emymtBgnnDt;
	}

	public void setEmymtBgnnDt(java.lang.String emymtBgnnDt) {
		this.emymtBgnnDt = emymtBgnnDt;
	}

	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}

	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}

	public java.lang.String getPyspCd() {
		return pyspCd;
	}

	public void setPyspCd(java.lang.String pyspCd) {
		this.pyspCd = pyspCd;
	}

	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getRetryDt() {
		return retryDt;
	}

	public void setRetryDt(java.lang.String retryDt) {
		this.retryDt = retryDt;
	}

	public java.lang.String getRetryReasCtnt() {
		return retryReasCtnt;
	}

	public void setRetryReasCtnt(java.lang.String retryReasCtnt) {
		this.retryReasCtnt = retryReasCtnt;
	}

	public java.lang.String getFrgnrDivCd() {
		return frgnrDivCd;
	}

	public void setFrgnrDivCd(java.lang.String frgnrDivCd) {
		this.frgnrDivCd = frgnrDivCd;
	}

	public java.lang.String getPsptNum() {
		return psptNum;
	}

	public void setPsptNum(java.lang.String psptNum) {
		this.psptNum = psptNum;
	}

	public java.lang.String getStyBgnnDt() {
		return styBgnnDt;
	}

	public void setStyBgnnDt(java.lang.String styBgnnDt) {
		this.styBgnnDt = styBgnnDt;
	}

	public java.lang.String getStyEndDt() {
		return styEndDt;
	}

	public void setStyEndDt(java.lang.String styEndDt) {
		this.styEndDt = styEndDt;
	}

	public java.lang.String getEndSchl() {
		return endSchl;
	}

	public void setEndSchl(java.lang.String endSchl) {
		this.endSchl = endSchl;
	}

	public java.lang.String getEndDegrDivCd() {
		return endDegrDivCd;
	}

	public void setEndDegrDivCd(java.lang.String endDegrDivCd) {
		this.endDegrDivCd = endDegrDivCd;
	}

	public java.lang.String getPmtnScduDt() {
		return pmtnScduDt;
	}

	public void setPmtnScduDt(java.lang.String pmtnScduDt) {
		this.pmtnScduDt = pmtnScduDt;
	}

	public java.lang.String getPyspPrmtnScduDt() {
		return pyspPrmtnScduDt;
	}

	public void setPyspPrmtnScduDt(java.lang.String pyspPrmtnScduDt) {
		this.pyspPrmtnScduDt = pyspPrmtnScduDt;
	}

	public java.lang.String getReymnScduDt() {
		return reymnScduDt;
	}

	public void setReymnScduDt(java.lang.String reymnScduDt) {
		this.reymnScduDt = reymnScduDt;
	}

	public java.lang.String getLogSvcYrNumCd() {
		return logSvcYrNumCd;
	}

	public void setLogSvcYrNumCd(java.lang.String logSvcYrNumCd) {
		this.logSvcYrNumCd = logSvcYrNumCd;
	}

	public java.lang.String getLogSvcMnthIcmCd() {
		return logSvcMnthIcmCd;
	}

	public void setLogSvcMnthIcmCd(java.lang.String logSvcMnthIcmCd) {
		this.logSvcMnthIcmCd = logSvcMnthIcmCd;
	}

	public java.lang.String getCurrPyspAppmtDt() {
		return currPyspAppmtDt;
	}

	public void setCurrPyspAppmtDt(java.lang.String currPyspAppmtDt) {
		this.currPyspAppmtDt = currPyspAppmtDt;
	}

	public java.lang.String getCurrDeptAppmtDt() {
		return currDeptAppmtDt;
	}

	public void setCurrDeptAppmtDt(java.lang.String currDeptAppmtDt) {
		this.currDeptAppmtDt = currDeptAppmtDt;
	}

	public java.lang.String getPernNoteCtnt() {
		return pernNoteCtnt;
	}

	public void setPernNoteCtnt(java.lang.String pernNoteCtnt) {
		this.pernNoteCtnt = pernNoteCtnt;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getRepbtyBusinNm() {
		return repbtyBusinNm;
	}

	public void setRepbtyBusinNm(java.lang.String repbtyBusinNm) {
		this.repbtyBusinNm = repbtyBusinNm;
	}

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getOrgResnNum() {
		return orgResnNum;
	}

	public void setOrgResnNum(java.lang.String orgResnNum) {
		this.orgResnNum = orgResnNum;
	}

	public java.lang.String getUnnMbspSttYn() {
		return unnMbspSttYn;
	}

	public void setUnnMbspSttYn(java.lang.String unnMbspSttYn) {
		this.unnMbspSttYn = unnMbspSttYn;
	}

	public java.math.BigDecimal getLogSvcDys() {
		return logSvcDys;
	}

	public void setLogSvcDys(java.math.BigDecimal logSvcDys) {
		this.logSvcDys = logSvcDys;
	}

	public java.lang.String getOrgLogSvcYrCd() {
		return orgLogSvcYrCd;
	}

	public void setOrgLogSvcYrCd(java.lang.String orgLogSvcYrCd) {
		this.orgLogSvcYrCd = orgLogSvcYrCd;
	}

	public java.lang.String getOrgLogSvcMnthCd() {
		return orgLogSvcMnthCd;
	}

	public void setOrgLogSvcMnthCd(java.lang.String orgLogSvcMnthCd) {
		this.orgLogSvcMnthCd = orgLogSvcMnthCd;
	}

	public java.math.BigDecimal getOrgLogSvcDys() {
		return orgLogSvcDys;
	}

	public void setOrgLogSvcDys(java.math.BigDecimal orgLogSvcDys) {
		this.orgLogSvcDys = orgLogSvcDys;
	}

	public java.lang.String getReMrkDt() {
		return reMrkDt;
	}

	public void setReMrkDt(java.lang.String reMrkDt) {
		this.reMrkDt = reMrkDt;
	}

	public java.lang.String getLogStdDt() {
		return logStdDt;
	}

	public void setLogStdDt(java.lang.String logStdDt) {
		this.logStdDt = logStdDt;
	}

	public java.math.BigDecimal getTotLogSvcDys() {
		return totLogSvcDys;
	}

	public void setTotLogSvcDys(java.math.BigDecimal totLogSvcDys) {
		this.totLogSvcDys = totLogSvcDys;
	}

	public java.math.BigDecimal getOrgTotLogSvcDys() {
		return orgTotLogSvcDys;
	}

	public void setOrgTotLogSvcDys(java.math.BigDecimal orgTotLogSvcDys) {
		this.orgTotLogSvcDys = orgTotLogSvcDys;
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
