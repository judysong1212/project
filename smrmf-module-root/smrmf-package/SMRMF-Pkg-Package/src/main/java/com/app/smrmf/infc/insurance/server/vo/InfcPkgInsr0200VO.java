package com.app.smrmf.infc.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr0200VO.java
 * @Description : Insr0200 VO class
 * @Modification Information
 *
 * @author exterms
 * @since 2015.04.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgInsr0200VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 공제년월 : dducYrMnth */
    private java.lang.String dducYrMnth;

    /** set 고지년월 : nofctYrMnth */
    private java.lang.String nofctYrMnth;

    /** set 사업장관리번호 : dpobMangeNum */
    private java.lang.String dpobMangeNum;

    /** set 단위기관코드 : untIstutCd */
    private java.lang.String untIstutCd;

    /** set 고지차수 : nofctDspty */
    private java.math.BigDecimal nofctDspty;

    /** set 회계부호 : accSgn */
    private java.lang.String accSgn;

    /** set 건강보험증번호 : hlthInsrCertNum */
    private java.lang.String hlthInsrCertNum;

    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;

    /** set 감면사유코드 : reduReasCd */
    private java.lang.String reduReasCd;

    /** set 건강보험직종코드 : hlthInsrTypOccuCd */
    private java.lang.String hlthInsrTypOccuCd;

    /** set 보수월액등급 : payMnthAmntGrde */
    private java.math.BigDecimal payMnthAmntGrde;

    /** set 보수월액 : payMnthAmnt */
    private java.math.BigDecimal payMnthAmnt;

    /** set 산출보험료 : calcPrmm */
    private java.math.BigDecimal calcPrmm;

    /** set 정산사유코드 : clutReasCd */
    private java.lang.String clutReasCd;

    /** set 정산적용시작년월 : clutApptnBgnnYrMnth */
    private java.lang.String clutApptnBgnnYrMnth;

    /** set 정산적용종료년월 : clutApptnEndYrMnth */
    private java.lang.String clutApptnEndYrMnth;

    /** set 정산보험료 : clutPrmm */
    private java.math.BigDecimal clutPrmm;

    /** set 고지보험료 : nofctPrmm */
    private java.math.BigDecimal nofctPrmm;

    /** set 연말정산보험료 : yrtxPrmm */
    private java.math.BigDecimal yrtxPrmm;

    /** set 취득일자 : aqtnDt */
    private java.lang.String aqtnDt;

    /** set 상실일자 : lssDt */
    private java.lang.String lssDt;

    /** set 요양산출보험료 : lgtmRcptnCalcPrmm */
    private java.math.BigDecimal lgtmRcptnCalcPrmm;

    /** set 요양정산사유코드 : lgtmRcptnClutReasCd */
    private java.lang.String lgtmRcptnClutReasCd;

    /** set 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
    private java.lang.String lgtmRcptnApptnBgnnYrMnth;

    /** set 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
    private java.lang.String lgtmRcptnApptnEndYrMnth;

    /** set 요양정산보험료 : lgtmRcptnClutPrmm */
    private java.math.BigDecimal lgtmRcptnClutPrmm;

    /** set 요양고지보험료 : lgtmRcptnNofctPrmm */
    private java.math.BigDecimal lgtmRcptnNofctPrmm;

    /** set 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
    private java.math.BigDecimal lgtmRcptnYrtxPrmm;

    /** set 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
    private java.math.BigDecimal hlthRcptnCalcPrmm;

    /** set 건강_요양정산보험료계 : hlthRcptnClutPrmm */
    private java.math.BigDecimal hlthRcptnClutPrmm;

    /** set 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
    private java.math.BigDecimal hlthRcptnNofctPrmm;

    /** set 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
    private java.math.BigDecimal hlthRcptnYrtxPrmm;

    /** set 건강환급금이자 : hlthInsrRefdItrt */
    private java.math.BigDecimal hlthInsrRefdItrt;

    /** set 요양환급금이자 : lgtmRcptnRefdItrt */
    private java.math.BigDecimal lgtmRcptnRefdItrt;

    /** set 총납부보험료 : totPymtPrmm */
    private java.math.BigDecimal totPymtPrmm;

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
    
    public java.lang.String getNofctYrMnth() {
        return this.nofctYrMnth;
    }
    
    public void setNofctYrMnth(java.lang.String nofctYrMnth) {
        this.nofctYrMnth = nofctYrMnth;
    }
    
    public java.lang.String getDpobMangeNum() {
        return this.dpobMangeNum;
    }
    
    public void setDpobMangeNum(java.lang.String dpobMangeNum) {
        this.dpobMangeNum = dpobMangeNum;
    }
    
    public java.lang.String getUntIstutCd() {
        return this.untIstutCd;
    }
    
    public void setUntIstutCd(java.lang.String untIstutCd) {
        this.untIstutCd = untIstutCd;
    }
    
    public java.math.BigDecimal getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(java.math.BigDecimal nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
    public java.lang.String getAccSgn() {
        return this.accSgn;
    }
    
    public void setAccSgn(java.lang.String accSgn) {
        this.accSgn = accSgn;
    }
    
    public java.lang.String getHlthInsrCertNum() {
        return this.hlthInsrCertNum;
    }
    
    public void setHlthInsrCertNum(java.lang.String hlthInsrCertNum) {
        this.hlthInsrCertNum = hlthInsrCertNum;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
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
    
    public java.lang.String getReduReasCd() {
        return this.reduReasCd;
    }
    
    public void setReduReasCd(java.lang.String reduReasCd) {
        this.reduReasCd = reduReasCd;
    }
    
    public java.lang.String getHlthInsrTypOccuCd() {
        return this.hlthInsrTypOccuCd;
    }
    
    public void setHlthInsrTypOccuCd(java.lang.String hlthInsrTypOccuCd) {
        this.hlthInsrTypOccuCd = hlthInsrTypOccuCd;
    }
    
    public java.math.BigDecimal getPayMnthAmntGrde() {
        return this.payMnthAmntGrde;
    }
    
    public void setPayMnthAmntGrde(java.math.BigDecimal payMnthAmntGrde) {
        this.payMnthAmntGrde = payMnthAmntGrde;
    }
    
    public java.math.BigDecimal getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(java.math.BigDecimal payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public java.math.BigDecimal getCalcPrmm() {
        return this.calcPrmm;
    }
    
    public void setCalcPrmm(java.math.BigDecimal calcPrmm) {
        this.calcPrmm = calcPrmm;
    }
    
    public java.lang.String getClutReasCd() {
        return this.clutReasCd;
    }
    
    public void setClutReasCd(java.lang.String clutReasCd) {
        this.clutReasCd = clutReasCd;
    }
    
    public java.lang.String getClutApptnBgnnYrMnth() {
        return this.clutApptnBgnnYrMnth;
    }
    
    public void setClutApptnBgnnYrMnth(java.lang.String clutApptnBgnnYrMnth) {
        this.clutApptnBgnnYrMnth = clutApptnBgnnYrMnth;
    }
    
    public java.lang.String getClutApptnEndYrMnth() {
        return this.clutApptnEndYrMnth;
    }
    
    public void setClutApptnEndYrMnth(java.lang.String clutApptnEndYrMnth) {
        this.clutApptnEndYrMnth = clutApptnEndYrMnth;
    }
    
    public java.math.BigDecimal getClutPrmm() {
        return this.clutPrmm;
    }
    
    public void setClutPrmm(java.math.BigDecimal clutPrmm) {
        this.clutPrmm = clutPrmm;
    }
    
    public java.math.BigDecimal getNofctPrmm() {
        return this.nofctPrmm;
    }
    
    public void setNofctPrmm(java.math.BigDecimal nofctPrmm) {
        this.nofctPrmm = nofctPrmm;
    }
    
    public java.math.BigDecimal getYrtxPrmm() {
        return this.yrtxPrmm;
    }
    
    public void setYrtxPrmm(java.math.BigDecimal yrtxPrmm) {
        this.yrtxPrmm = yrtxPrmm;
    }
    
    public java.lang.String getAqtnDt() {
        return this.aqtnDt;
    }
    
    public void setAqtnDt(java.lang.String aqtnDt) {
        this.aqtnDt = aqtnDt;
    }
    
    public java.lang.String getLssDt() {
        return this.lssDt;
    }
    
    public void setLssDt(java.lang.String lssDt) {
        this.lssDt = lssDt;
    }
    
    public java.math.BigDecimal getLgtmRcptnCalcPrmm() {
        return this.lgtmRcptnCalcPrmm;
    }
    
    public void setLgtmRcptnCalcPrmm(java.math.BigDecimal lgtmRcptnCalcPrmm) {
        this.lgtmRcptnCalcPrmm = lgtmRcptnCalcPrmm;
    }
    
    public java.lang.String getLgtmRcptnClutReasCd() {
        return this.lgtmRcptnClutReasCd;
    }
    
    public void setLgtmRcptnClutReasCd(java.lang.String lgtmRcptnClutReasCd) {
        this.lgtmRcptnClutReasCd = lgtmRcptnClutReasCd;
    }
    
    public java.lang.String getLgtmRcptnApptnBgnnYrMnth() {
        return this.lgtmRcptnApptnBgnnYrMnth;
    }
    
    public void setLgtmRcptnApptnBgnnYrMnth(java.lang.String lgtmRcptnApptnBgnnYrMnth) {
        this.lgtmRcptnApptnBgnnYrMnth = lgtmRcptnApptnBgnnYrMnth;
    }
    
    public java.lang.String getLgtmRcptnApptnEndYrMnth() {
        return this.lgtmRcptnApptnEndYrMnth;
    }
    
    public void setLgtmRcptnApptnEndYrMnth(java.lang.String lgtmRcptnApptnEndYrMnth) {
        this.lgtmRcptnApptnEndYrMnth = lgtmRcptnApptnEndYrMnth;
    }
    
    public java.math.BigDecimal getLgtmRcptnClutPrmm() {
        return this.lgtmRcptnClutPrmm;
    }
    
    public void setLgtmRcptnClutPrmm(java.math.BigDecimal lgtmRcptnClutPrmm) {
        this.lgtmRcptnClutPrmm = lgtmRcptnClutPrmm;
    }
    
    public java.math.BigDecimal getLgtmRcptnNofctPrmm() {
        return this.lgtmRcptnNofctPrmm;
    }
    
    public void setLgtmRcptnNofctPrmm(java.math.BigDecimal lgtmRcptnNofctPrmm) {
        this.lgtmRcptnNofctPrmm = lgtmRcptnNofctPrmm;
    }
    
    public java.math.BigDecimal getLgtmRcptnYrtxPrmm() {
        return this.lgtmRcptnYrtxPrmm;
    }
    
    public void setLgtmRcptnYrtxPrmm(java.math.BigDecimal lgtmRcptnYrtxPrmm) {
        this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnCalcPrmm() {
        return this.hlthRcptnCalcPrmm;
    }
    
    public void setHlthRcptnCalcPrmm(java.math.BigDecimal hlthRcptnCalcPrmm) {
        this.hlthRcptnCalcPrmm = hlthRcptnCalcPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnClutPrmm() {
        return this.hlthRcptnClutPrmm;
    }
    
    public void setHlthRcptnClutPrmm(java.math.BigDecimal hlthRcptnClutPrmm) {
        this.hlthRcptnClutPrmm = hlthRcptnClutPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnNofctPrmm() {
        return this.hlthRcptnNofctPrmm;
    }
    
    public void setHlthRcptnNofctPrmm(java.math.BigDecimal hlthRcptnNofctPrmm) {
        this.hlthRcptnNofctPrmm = hlthRcptnNofctPrmm;
    }
    
    public java.math.BigDecimal getHlthRcptnYrtxPrmm() {
        return this.hlthRcptnYrtxPrmm;
    }
    
    public void setHlthRcptnYrtxPrmm(java.math.BigDecimal hlthRcptnYrtxPrmm) {
        this.hlthRcptnYrtxPrmm = hlthRcptnYrtxPrmm;
    }
    
    public java.math.BigDecimal getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(java.math.BigDecimal hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public java.math.BigDecimal getLgtmRcptnRefdItrt() {
        return this.lgtmRcptnRefdItrt;
    }
    
    public void setLgtmRcptnRefdItrt(java.math.BigDecimal lgtmRcptnRefdItrt) {
        this.lgtmRcptnRefdItrt = lgtmRcptnRefdItrt;
    }
    
    public java.math.BigDecimal getTotPymtPrmm() {
        return this.totPymtPrmm;
    }
    
    public void setTotPymtPrmm(java.math.BigDecimal totPymtPrmm) {
        this.totPymtPrmm = totPymtPrmm;
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
    
    
    
}
