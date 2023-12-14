package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr3100VO.java
 * @Description : Insr3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3100DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 정산년월 : nofctYrMnthNum */
	private java.lang.String nofctYrMnthNum;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 차수 : dspty */
	private java.lang.String dspty;
	
	/** set 고용일련번호 : emymtSeilNum */
	private Long emymtSeilNum;
	
	/** set 건강보험일련번호 : hlthInsrSeilNum */
	private java.math.BigDecimal hlthInsrSeilNum;
	
	/** set 부서코드 : deptCd */
	private java.lang.String deptCd;
	
	/** set 부서명 : deptNm */
	private java.lang.String deptNm;

	/** set 사업장관리번호 : dpobMangeNum */
	private java.lang.String dpobMangeNum;

	/** set 회계 : acc */
	private java.lang.String acc;

	/** set 단위사업장코드 : untDpobCd */
	private java.lang.String untDpobCd;

	/** set 증번호 : certNumHuhd */
	private java.lang.String certNumHuhd;

	/** set 성명 : nm */
	private java.lang.String nm;

	/** set 주민등록번호 : resnRegnNum */
	private java.lang.String resnRegnNum;
	  /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
	/** set 부과한총보험료_계 : iposTotPrmmAggr */
	private java.math.BigDecimal iposTotPrmmAggr;

	/** set 부과한총보험료_건강 : iposTotPrmmHlth */
	private java.math.BigDecimal iposTotPrmmHlth;

	/** set 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
	private java.math.BigDecimal iposTotPrmmLgtmRcptn;

	/** set 연간보수총액 : yrlyPayTotAmnt */
	private Long yrlyPayTotAmnt;

	/** set 근무월수 : dutyMnthIcm */
	private java.math.BigDecimal dutyMnthIcm;

	/** set 보수월액 : payMnthAmnt */
	private Long payMnthAmnt;

	/** set 연말정산_등급 : yrtxCalcBkdnGrde */
	private java.lang.String yrtxCalcBkdnGrde;

	/** set 표준보수월액 : stdPayMnthAmnt */
	private Long stdPayMnthAmnt;

	/** set 확정보험료_계 : fixPrmmAggr */
	private java.math.BigDecimal fixPrmmAggr;

	/** set 확정보험료_건강 : fixPrmmHlth */
	private java.math.BigDecimal fixPrmmHlth;

	/** set 확정보험료_장기요양 : fixPrmmLgtmRcptn */
	private java.math.BigDecimal fixPrmmLgtmRcptn;

	/** set 정산보험료_계 : clutPrmmAggr */
	private java.math.BigDecimal clutPrmmAggr;

	/** set 정산보험료_건강 : clutPrmmHlth */
	private java.math.BigDecimal clutPrmmHlth;

	/** set 정산보험료_장기요양 : clutPrmmLgtmRcptn */
	private java.math.BigDecimal clutPrmmLgtmRcptn;

	/** set 가입자부담금_계 : mbrAlttAggr */
	private java.math.BigDecimal mbrAlttAggr;

	/** set 가입자부담금_건강 : mbrAlttHlth */
	private java.math.BigDecimal mbrAlttHlth;

	/** set 가입자부담금_장기요양 : mbrAlttLgtmRcptn */
	private java.math.BigDecimal mbrAlttLgtmRcptn;

	/** set 사용자부담금_계 : usrAlttAggr */
	private java.math.BigDecimal usrAlttAggr;

	/** set 사용자부담금_건강 : usrAlttHlth */
	private java.math.BigDecimal usrAlttHlth;

	/** set 사용자부담금_장기요양 : usrAlttLgtmRcptn */
	private java.math.BigDecimal usrAlttLgtmRcptn;

	/** set 고지유예 : nofctSspn */
	private java.lang.String nofctSspn;
	
	/** set 직종코드 : typOccuCd */
	private java.lang.String typOccuCd;
	
	/** set 직종명 : typOccuNm */
	private java.lang.String typOccuNm;
	
	/** set 직종세코드 : dtilOccuClsDivCd */
	private java.lang.String dtilOccuClsDivCd;
	
	/** set 직종세명 : dtilOccuClsNm */
	private java.lang.String dtilOccuClsNm;

	/** set 건강연말정산적용년월 : hlthYrtxApptnYrMnth */
	private java.lang.String hlthYrtxApptnYrMnth;

	/** set 건강연말정산처리일자 : hlthYrtxPrcsDt */
	private java.lang.String hlthYrtxPrcsDt;

	/** set 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
	private java.lang.String hlthInsrYrtxPrcsYn;

	/** set 분할납부구분코드 : divdPymtDivCd */
	private java.lang.String divdPymtDivCd;

	/** set 분할납부횟수 : divdPymt */
	private java.math.BigDecimal divdPymt;

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
    
    public java.lang.String getNofctYrMnthNum() {
        return this.nofctYrMnthNum;
    }
    
    public void setNofctYrMnthNum(java.lang.String nofctYrMnthNum) {
        this.nofctYrMnthNum = nofctYrMnthNum;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDspty() {
        return this.dspty;
    }
    
    public void setDspty(java.lang.String dspty) {
        this.dspty = dspty;
    }
    
    public Long getEmymtSeilNum() {
    	return this.emymtSeilNum;
    }
    
    public void setEmymtSeilNum(Long emymtSeilNum) {
    	this.emymtSeilNum = emymtSeilNum;
    }
    
    public java.math.BigDecimal getHlthInsrSeilNum() {
        return this.hlthInsrSeilNum;
    }
    
    public void setHlthInsrSeilNum(java.math.BigDecimal hlthInsrSeilNum) {
        this.hlthInsrSeilNum = hlthInsrSeilNum;
    }
    
    public java.lang.String getDeptCd() {
    	return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
    	this.deptCd = deptCd;
    }
    
    public java.lang.String getDeptNm() {
    	return this.deptNm;
    }
    
    public void setDeptNm(java.lang.String deptNm) {
    	this.deptNm = deptNm;
    }
    
    public java.lang.String getDpobMangeNum() {
        return this.dpobMangeNum;
    }
    
    public void setDpobMangeNum(java.lang.String dpobMangeNum) {
        this.dpobMangeNum = dpobMangeNum;
    }
    
    public java.lang.String getAcc() {
        return this.acc;
    }
    
    public void setAcc(java.lang.String acc) {
        this.acc = acc;
    }
    
    public java.lang.String getUntDpobCd() {
        return this.untDpobCd;
    }
    
    public void setUntDpobCd(java.lang.String untDpobCd) {
        this.untDpobCd = untDpobCd;
    }
    
    public java.lang.String getCertNumHuhd() {
        return this.certNumHuhd;
    }
    
    public void setCertNumHuhd(java.lang.String certNumHuhd) {
        this.certNumHuhd = certNumHuhd;
    }
    
    public java.lang.String getNm() {
        return this.nm;
    }
    
    public void setNm(java.lang.String nm) {
        this.nm = nm;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.math.BigDecimal getIposTotPrmmAggr() {
        return this.iposTotPrmmAggr;
    }
    
    public void setIposTotPrmmAggr(java.math.BigDecimal iposTotPrmmAggr) {
        this.iposTotPrmmAggr = iposTotPrmmAggr;
    }
    
    public java.math.BigDecimal getIposTotPrmmHlth() {
        return this.iposTotPrmmHlth;
    }
    
    public void setIposTotPrmmHlth(java.math.BigDecimal iposTotPrmmHlth) {
        this.iposTotPrmmHlth = iposTotPrmmHlth;
    }
    
    public java.math.BigDecimal getIposTotPrmmLgtmRcptn() {
        return this.iposTotPrmmLgtmRcptn;
    }
    
    public void setIposTotPrmmLgtmRcptn(java.math.BigDecimal iposTotPrmmLgtmRcptn) {
        this.iposTotPrmmLgtmRcptn = iposTotPrmmLgtmRcptn;
    }
    
    public Long getYrlyPayTotAmnt() {
        return this.yrlyPayTotAmnt;
    }
    
    public void setYrlyPayTotAmnt(Long yrlyPayTotAmnt) {
        this.yrlyPayTotAmnt = yrlyPayTotAmnt;
    }
    
    public java.math.BigDecimal getDutyMnthIcm() {
        return this.dutyMnthIcm;
    }
    
    public void setDutyMnthIcm(java.math.BigDecimal dutyMnthIcm) {
        this.dutyMnthIcm = dutyMnthIcm;
    }
    
    public Long getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(Long payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.lang.String getYrtxCalcBkdnGrde() {
        return this.yrtxCalcBkdnGrde;
    }
    
    public void setYrtxCalcBkdnGrde(java.lang.String yrtxCalcBkdnGrde) {
        this.yrtxCalcBkdnGrde = yrtxCalcBkdnGrde;
    }
    
    public Long getStdPayMnthAmnt() {
        return this.stdPayMnthAmnt;
    }
    
    public void setStdPayMnthAmnt(Long stdPayMnthAmnt) {
        this.stdPayMnthAmnt = stdPayMnthAmnt;
    }
    
    public java.math.BigDecimal getFixPrmmAggr() {
        return this.fixPrmmAggr;
    }
    
    public void setFixPrmmAggr(java.math.BigDecimal fixPrmmAggr) {
        this.fixPrmmAggr = fixPrmmAggr;
    }
    
    public java.math.BigDecimal getFixPrmmHlth() {
        return this.fixPrmmHlth;
    }
    
    public void setFixPrmmHlth(java.math.BigDecimal fixPrmmHlth) {
        this.fixPrmmHlth = fixPrmmHlth;
    }
    
    public java.math.BigDecimal getFixPrmmLgtmRcptn() {
        return this.fixPrmmLgtmRcptn;
    }
    
    public void setFixPrmmLgtmRcptn(java.math.BigDecimal fixPrmmLgtmRcptn) {
        this.fixPrmmLgtmRcptn = fixPrmmLgtmRcptn;
    }
    
    public java.math.BigDecimal getClutPrmmAggr() {
        return this.clutPrmmAggr;
    }
    
    public void setClutPrmmAggr(java.math.BigDecimal clutPrmmAggr) {
        this.clutPrmmAggr = clutPrmmAggr;
    }
    
    public java.math.BigDecimal getClutPrmmHlth() {
        return this.clutPrmmHlth;
    }
    
    public void setClutPrmmHlth(java.math.BigDecimal clutPrmmHlth) {
        this.clutPrmmHlth = clutPrmmHlth;
    }
    
    public java.math.BigDecimal getClutPrmmLgtmRcptn() {
        return this.clutPrmmLgtmRcptn;
    }
    
    public void setClutPrmmLgtmRcptn(java.math.BigDecimal clutPrmmLgtmRcptn) {
        this.clutPrmmLgtmRcptn = clutPrmmLgtmRcptn;
    }
    
    public java.math.BigDecimal getMbrAlttAggr() {
        return this.mbrAlttAggr;
    }
    
    public void setMbrAlttAggr(java.math.BigDecimal mbrAlttAggr) {
        this.mbrAlttAggr = mbrAlttAggr;
    }
    
    public java.math.BigDecimal getMbrAlttHlth() {
        return this.mbrAlttHlth;
    }
    
    public void setMbrAlttHlth(java.math.BigDecimal mbrAlttHlth) {
        this.mbrAlttHlth = mbrAlttHlth;
    }
    
    public java.math.BigDecimal getMbrAlttLgtmRcptn() {
        return this.mbrAlttLgtmRcptn;
    }
    
    public void setMbrAlttLgtmRcptn(java.math.BigDecimal mbrAlttLgtmRcptn) {
        this.mbrAlttLgtmRcptn = mbrAlttLgtmRcptn;
    }
    
    public java.math.BigDecimal getUsrAlttAggr() {
        return this.usrAlttAggr;
    }
    
    public void setUsrAlttAggr(java.math.BigDecimal usrAlttAggr) {
        this.usrAlttAggr = usrAlttAggr;
    }
    
    public java.math.BigDecimal getUsrAlttHlth() {
        return this.usrAlttHlth;
    }
    
    public void setUsrAlttHlth(java.math.BigDecimal usrAlttHlth) {
        this.usrAlttHlth = usrAlttHlth;
    }
    
    public java.math.BigDecimal getUsrAlttLgtmRcptn() {
        return this.usrAlttLgtmRcptn;
    }
    
    public void setUsrAlttLgtmRcptn(java.math.BigDecimal usrAlttLgtmRcptn) {
        this.usrAlttLgtmRcptn = usrAlttLgtmRcptn;
    }
    
    public java.lang.String getNofctSspn() {
        return this.nofctSspn;
    }
    
    public void setNofctSspn(java.lang.String nofctSspn) {
        this.nofctSspn = nofctSspn;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getTypOccuNm() {
        return this.typOccuNm;
    }
    
    public void setTypOccuNm(java.lang.String typOccuNm) {
        this.typOccuNm = typOccuNm;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getDtilOccuClsNm() {
        return this.dtilOccuClsNm;
    }
    
    public void setDtilOccuClsNm(java.lang.String dtilOccuClsNm) {
        this.dtilOccuClsNm = dtilOccuClsNm;
    }
    
    public java.lang.String getHlthYrtxApptnYrMnth() {
        return this.hlthYrtxApptnYrMnth;
    }
    
    public void setHlthYrtxApptnYrMnth(java.lang.String hlthYrtxApptnYrMnth) {
        this.hlthYrtxApptnYrMnth = hlthYrtxApptnYrMnth;
    }
    
    public java.lang.String getHlthYrtxPrcsDt() {
        return this.hlthYrtxPrcsDt;
    }
    
    public void setHlthYrtxPrcsDt(java.lang.String hlthYrtxPrcsDt) {
        this.hlthYrtxPrcsDt = hlthYrtxPrcsDt;
    }
    
    public java.lang.String getHlthInsrYrtxPrcsYn() {
        return this.hlthInsrYrtxPrcsYn;
    }
    
    public void setHlthInsrYrtxPrcsYn(java.lang.String hlthInsrYrtxPrcsYn) {
        this.hlthInsrYrtxPrcsYn = hlthInsrYrtxPrcsYn;
    }
    
    public java.lang.String getDivdPymtDivCd() {
        return this.divdPymtDivCd;
    }
    
    public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
        this.divdPymtDivCd = divdPymtDivCd;
    }
    
    public java.math.BigDecimal getDivdPymt() {
        return this.divdPymt;
    }
    
    public void setDivdPymt(java.math.BigDecimal divdPymt) {
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
}
