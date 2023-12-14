package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr3200VO.java
 * @Description : Insr3200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3200DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 고지년월 : nofctYrMnth */
	private java.lang.String nofctYrMnth;

	/** set 고지차수 : nofctDspty */
	private Long nofctDspty;

	/** set 고용일련번호 : emymtSeilNum */
	private Long  emymtSeilNum; 

	/** set 사업장관리번호 : dpobMangeNum */
	private java.lang.String dpobMangeNum;

	/** set 단위기관코드 : untIstutCd */
	private java.lang.String untIstutCd;

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
	
	/** set 감면사유 : reduReasNm */
	private java.lang.String reduReasNm;

	/** set 건강보험직종코드 : hlthInsrTypOccuCd */
	private java.lang.String hlthInsrTypOccuCd;

	/** set 보수월액등급 : payMnthAmntGrde */
	private java.lang.String payMnthAmntGrde;

	/** set 보수월액 : payMnthAmnt */
	private Long payMnthAmnt;

	/** set 산출보험료 : calcPrmm */
	private Long calcPrmm;

	/** set 정산사유코드 : clutReasCd */
	private java.lang.String clutReasCd;

	/** set 정산적용시작년월 : clutApptnBgnnYrMnth */
	private java.lang.String clutApptnBgnnYrMnth;

	/** set 정산적용종료년월 : clutApptnEndYrMnth */
	private java.lang.String clutApptnEndYrMnth;

	/** set 정산보험료 : clutPrmm */
	private Long clutPrmm;

	/** set 고지보험료 : nofctPrmm */
	private Long nofctPrmm;

	/** set 연말정산보험료 : yrtxPrmm */
	private Long yrtxPrmm;

	/** set 취득일자 : aqtnDt */
	private java.lang.String aqtnDt;

	/** set 상실일자 : lssDt */
	private java.lang.String lssDt;

	/** set 요양산출보험료 : lgtmRcptnCalcPrmm */
	private Long lgtmRcptnCalcPrmm;

	/** set 요양정산사유코드 : lgtmRcptnClutReasCd */
	private java.lang.String lgtmRcptnClutReasCd;

	/** set 요양정산적용시작년월 : lgtmRcptnApptnBgnnYrMnth */
	private java.lang.String lgtmRcptnApptnBgnnYrMnth;

	/** set 요양정산적용종료년월 : lgtmRcptnApptnEndYrMnth */
	private java.lang.String lgtmRcptnApptnEndYrMnth;

	/** set 요양정산보험료 : lgtmRcptnClutPrmm */
	private Long lgtmRcptnClutPrmm;

	/** set 요양고지보험료 : lgtmRcptnNofctPrmm */
	private Long lgtmRcptnNofctPrmm;

	/** set 요양연말정산보험료 : lgtmRcptnYrtxPrmm */
	private Long lgtmRcptnYrtxPrmm;

	/** set 건강_요양산출보험료계 : hlthRcptnCalcPrmm */
	private Long hlthRcptnCalcPrmm;

	/** set 건강_요양정산보험료계 : hlthRcptnClutPrmm */
	private Long hlthRcptnClutPrmm;

	/** set 건강_요양고지보험료계 : hlthRcptnNofctPrmm */
	private Long hlthRcptnNofctPrmm;

	/** set 건강_요양연말정산보험료계 : hlthRcptnYrtxPrmm */
	private Long hlthRcptnYrtxPrmm;

	/** set 건강환급금이자 : hlthInsrRefdItrt */
	private Long hlthInsrRefdItrt;

	/** set 요양환급금이자 : lgtmRcptnRefdItrt */
	private Long lgtmRcptnRefdItrt;

	/** set 총납부보험료 : totPymtPrmm */
	private Long totPymtPrmm;

	/** set 공제년월 : dducYrMnth */
	private java.lang.String dducYrMnth;

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
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getNofctYrMnth() {
        return this.nofctYrMnth;
    }
    
    public void setNofctYrMnth(java.lang.String nofctYrMnth) {
        this.nofctYrMnth = nofctYrMnth;
    }
    
    public Long getNofctDspty() {
        return this.nofctDspty;
    }
    
    public void setNofctDspty(Long nofctDspty) {
        this.nofctDspty = nofctDspty;
    }
    
    
    
    /**
	 * Comment : 
	 * @fn Long getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 26. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public Long getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(Long emymtSeilNum)
	 *@brief date:2016 2016. 4. 26. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(Long emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
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
    
    public java.lang.String getReduReasNm() {
        return this.reduReasNm;
    }
    
    public void setReduReasNm(java.lang.String reduReasNm) {
        this.reduReasNm = reduReasNm;
    }
    
    public java.lang.String getHlthInsrTypOccuCd() {
        return this.hlthInsrTypOccuCd;
    }
    
    public void setHlthInsrTypOccuCd(java.lang.String hlthInsrTypOccuCd) {
        this.hlthInsrTypOccuCd = hlthInsrTypOccuCd;
    }
    
    public java.lang.String getPayMnthAmntGrde() {
        return this.payMnthAmntGrde;
    }
    
    public void setPayMnthAmntGrde(java.lang.String payMnthAmntGrde) {
        this.payMnthAmntGrde = payMnthAmntGrde;
    }
    
    public Long getPayMnthAmnt() {
        return this.payMnthAmnt;
    }
    
    public void setPayMnthAmnt(Long payMnthAmnt) {
        this.payMnthAmnt = payMnthAmnt;
    }
    
    public Long getCalcPrmm() {
        return this.calcPrmm;
    }
    
    public void setCalcPrmm(Long calcPrmm) {
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
    
    public Long getClutPrmm() {
        return this.clutPrmm;
    }
    
    public void setClutPrmm(Long clutPrmm) {
        this.clutPrmm = clutPrmm;
    }
    
    public Long getNofctPrmm() {
        return this.nofctPrmm;
    }
    
    public void setNofctPrmm(Long nofctPrmm) {
        this.nofctPrmm = nofctPrmm;
    }
    
    public Long getYrtxPrmm() {
        return this.yrtxPrmm;
    }
    
    public void setYrtxPrmm(Long yrtxPrmm) {
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
    
    public Long getLgtmRcptnCalcPrmm() {
        return this.lgtmRcptnCalcPrmm;
    }
    
    public void setLgtmRcptnCalcPrmm(Long lgtmRcptnCalcPrmm) {
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
    
    public Long getLgtmRcptnClutPrmm() {
        return this.lgtmRcptnClutPrmm;
    }
    
    public void setLgtmRcptnClutPrmm(Long lgtmRcptnClutPrmm) {
        this.lgtmRcptnClutPrmm = lgtmRcptnClutPrmm;
    }
    
    public Long getLgtmRcptnNofctPrmm() {
        return this.lgtmRcptnNofctPrmm;
    }
    
    public void setLgtmRcptnNofctPrmm(Long lgtmRcptnNofctPrmm) {
        this.lgtmRcptnNofctPrmm = lgtmRcptnNofctPrmm;
    }
    
    public Long getLgtmRcptnYrtxPrmm() {
        return this.lgtmRcptnYrtxPrmm;
    }
    
    public void setLgtmRcptnYrtxPrmm(Long lgtmRcptnYrtxPrmm) {
        this.lgtmRcptnYrtxPrmm = lgtmRcptnYrtxPrmm;
    }
    
    public Long getHlthRcptnCalcPrmm() {
        return this.hlthRcptnCalcPrmm;
    }
    
    public void setHlthRcptnCalcPrmm(Long hlthRcptnCalcPrmm) {
        this.hlthRcptnCalcPrmm = hlthRcptnCalcPrmm;
    }
    
    public Long getHlthRcptnClutPrmm() {
        return this.hlthRcptnClutPrmm;
    }
    
    public void setHlthRcptnClutPrmm(Long hlthRcptnClutPrmm) {
        this.hlthRcptnClutPrmm = hlthRcptnClutPrmm;
    }
    
    public Long getHlthRcptnNofctPrmm() {
        return this.hlthRcptnNofctPrmm;
    }
    
    public void setHlthRcptnNofctPrmm(Long hlthRcptnNofctPrmm) {
        this.hlthRcptnNofctPrmm = hlthRcptnNofctPrmm;
    }
    
    public Long getHlthRcptnYrtxPrmm() {
        return this.hlthRcptnYrtxPrmm;
    }
    
    public void setHlthRcptnYrtxPrmm(Long hlthRcptnYrtxPrmm) {
        this.hlthRcptnYrtxPrmm = hlthRcptnYrtxPrmm;
    }
    
    public Long getHlthInsrRefdItrt() {
        return this.hlthInsrRefdItrt;
    }
    
    public void setHlthInsrRefdItrt(Long hlthInsrRefdItrt) {
        this.hlthInsrRefdItrt = hlthInsrRefdItrt;
    }
    
    public Long getLgtmRcptnRefdItrt() {
        return this.lgtmRcptnRefdItrt;
    }
    
    public void setLgtmRcptnRefdItrt(Long lgtmRcptnRefdItrt) {
        this.lgtmRcptnRefdItrt = lgtmRcptnRefdItrt;
    }
    
    public Long getTotPymtPrmm() {
        return this.totPymtPrmm;
    }
    
    public void setTotPymtPrmm(Long totPymtPrmm) {
        this.totPymtPrmm = totPymtPrmm;
    }
    
    public java.lang.String getDducYrMnth() {
        return this.dducYrMnth;
    }
    
    public void setDducYrMnth(java.lang.String dducYrMnth) {
        this.dducYrMnth = dducYrMnth;
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
