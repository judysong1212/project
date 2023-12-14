package com.app.smrmf.infc.yearendtax.server.vo.yeta2022;

import java.io.Serializable;

/**
 * @Class Name : Ye161005VO.java
 * @Description : Ye161005 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe161005_2022_VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 원천세신고부서코드 : whdgTxRegrstDeptCd */
    private java.lang.String whdgTxRegrstDeptCd;

    /** set 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
    private java.lang.String hhrkWhdgRegrstDeptCd;

    /** set A3_세무서코드 : txOffcCd */
    private java.lang.String txOffcCd;

    /** set A5_제출자구분 : pentrSeptCd */
    private java.lang.String pentrSeptCd;

    /** set A6_세무대리인관리번호 : txDeptyMangeNum */
    private java.lang.String txDeptyMangeNum;

    /** set A7_홈텍스ID : hmtxId */
    private java.lang.String hmtxId;

    /** set A8_세무프로그램코드 : txPgmCd */
    private java.lang.String txPgmCd;

    /** set A9_사업자등록번호 : busoprRgstnum */
    private java.lang.String busoprRgstnum;

    /** set A10_법인_상호명 : corpFmnmNm */
    private java.lang.String corpFmnmNm;

    /** set A11_담당자부서 : pernChrgDeptNm */
    private java.lang.String pernChrgDeptNm;

    /** set A12_담당자성명 : pernChrgNm */
    private java.lang.String pernChrgNm;

    /** set A13_담당자전화번호 : pernChrgPhnNum */
    private java.lang.String pernChrgPhnNum;

    /** set A15_사용한글코드 : useHanCd */
    private java.lang.String useHanCd;

    /** set B16_제출대상기간코드 : sumtTgtPridCd */
    private java.lang.String sumtTgtPridCd;

    /** set 법인번호 : corpNum */
    private java.lang.String corpNum;

    /** set 소득신고의무자우편번호 : incmPost */
    private java.lang.String incmPost;

    /** set 소득신고의무자기본주소 : incmAddr */
    private java.lang.String incmAddr;

    /** set 소득신고의무자상세주소 : incmAdtl */
    private java.lang.String incmAdtl;

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

    /** set 대표자성명 : reprName */
    private java.lang.String reprName;

    /** set 주민등록번호 : resuNumb */
    private java.lang.String resuNumb;

    /** set C171_사업자단위과세자여부 : yetaC171 */
    private java.lang.String yetaC171;

    /** set C172_종사업장일련번호 : yetaC172 */
    private java.lang.String yetaC172;

    /** set null : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set null : clutSeptCd */
    private java.lang.String clutSeptCd;

    private java.lang.String utDpobCd;
       
    /**
	 * Comment : 
	 * @fn java.lang.String getUtDpobCd()
	 * @brief date:2022 2022. 2. 14. user:atres
	 * @return the utDpobCd get
	 */
	public java.lang.String getUtDpobCd() {
		return utDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setUtDpobCd(java.lang.String utDpobCd)
	 *@brief date:2022 2022. 2. 14. user:atres
	 *@param utDpobCd the utDpobCd to set
	 */
	public void setUtDpobCd(java.lang.String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getReprName()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the reprName get
	 */
	public java.lang.String getReprName() {
		return reprName;
	}

	/**
	 * Comment : 
	 *@fn void setReprName(java.lang.String reprName)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param reprName the reprName to set
	 */
	public void setReprName(java.lang.String reprName) {
		this.reprName = reprName;
	}

	/**
	 * Comment : 주민등록번호
	 * @fn java.lang.String getResuNumb()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the resuNumb get
	 */
	public java.lang.String getResuNumb() {
		return resuNumb;
	}

	/**
	 * Comment : 주민등록번호
	 *@fn void setResuNumb(java.lang.String resuNumb)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param resuNumb the resuNumb to set
	 */
	public void setResuNumb(java.lang.String resuNumb) {
		this.resuNumb = resuNumb;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYetaC171()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the yetaC171 get
	 */
	public java.lang.String getYetaC171() {
		return yetaC171;
	}

	/**
	 * Comment : 
	 *@fn void setYetaC171(java.lang.String yetaC171)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param yetaC171 the yetaC171 to set
	 */
	public void setYetaC171(java.lang.String yetaC171) {
		this.yetaC171 = yetaC171;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYetaC172()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the yetaC172 get
	 */
	public java.lang.String getYetaC172() {
		return yetaC172;
	}

	/**
	 * Comment : 
	 *@fn void setYetaC172(java.lang.String yetaC172)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param yetaC172 the yetaC172 to set
	 */
	public void setYetaC172(java.lang.String yetaC172) {
		this.yetaC172 = yetaC172;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxBlggYr()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the yrtxBlggYr get
	 */
	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxBlggYr(java.lang.String yrtxBlggYr)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param yrtxBlggYr the yrtxBlggYr to set
	 */
	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getClutSeptCd()
	 * @brief date:2022 2022. 2. 8. user:atres
	 * @return the clutSeptCd get
	 */
	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setClutSeptCd(java.lang.String clutSeptCd)
	 *@brief date:2022 2022. 2. 8. user:atres
	 *@param clutSeptCd the clutSeptCd to set
	 */
	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getWhdgTxRegrstDeptCd() {
        return this.whdgTxRegrstDeptCd;
    }
    
    public void setWhdgTxRegrstDeptCd(java.lang.String whdgTxRegrstDeptCd) {
        this.whdgTxRegrstDeptCd = whdgTxRegrstDeptCd;
    }
    
    public java.lang.String getHhrkWhdgRegrstDeptCd() {
        return this.hhrkWhdgRegrstDeptCd;
    }
    
    public void setHhrkWhdgRegrstDeptCd(java.lang.String hhrkWhdgRegrstDeptCd) {
        this.hhrkWhdgRegrstDeptCd = hhrkWhdgRegrstDeptCd;
    }
    
    public java.lang.String getTxOffcCd() {
        return this.txOffcCd;
    }
    
    public void setTxOffcCd(java.lang.String txOffcCd) {
        this.txOffcCd = txOffcCd;
    }
    
    public java.lang.String getPentrSeptCd() {
        return this.pentrSeptCd;
    }
    
    public void setPentrSeptCd(java.lang.String pentrSeptCd) {
        this.pentrSeptCd = pentrSeptCd;
    }
    
    public java.lang.String getTxDeptyMangeNum() {
        return this.txDeptyMangeNum;
    }
    
    public void setTxDeptyMangeNum(java.lang.String txDeptyMangeNum) {
        this.txDeptyMangeNum = txDeptyMangeNum;
    }
    
    public java.lang.String getHmtxId() {
        return this.hmtxId;
    }
    
    public void setHmtxId(java.lang.String hmtxId) {
        this.hmtxId = hmtxId;
    }
    
    public java.lang.String getTxPgmCd() {
        return this.txPgmCd;
    }
    
    public void setTxPgmCd(java.lang.String txPgmCd) {
        this.txPgmCd = txPgmCd;
    }
    
    public java.lang.String getBusoprRgstnum() {
        return this.busoprRgstnum;
    }
    
    public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
        this.busoprRgstnum = busoprRgstnum;
    }
    
    public java.lang.String getCorpFmnmNm() {
        return this.corpFmnmNm;
    }
    
    public void setCorpFmnmNm(java.lang.String corpFmnmNm) {
        this.corpFmnmNm = corpFmnmNm;
    }
    
    public java.lang.String getPernChrgDeptNm() {
        return this.pernChrgDeptNm;
    }
    
    public void setPernChrgDeptNm(java.lang.String pernChrgDeptNm) {
        this.pernChrgDeptNm = pernChrgDeptNm;
    }
    
    public java.lang.String getPernChrgNm() {
        return this.pernChrgNm;
    }
    
    public void setPernChrgNm(java.lang.String pernChrgNm) {
        this.pernChrgNm = pernChrgNm;
    }
    
    public java.lang.String getPernChrgPhnNum() {
        return this.pernChrgPhnNum;
    }
    
    public void setPernChrgPhnNum(java.lang.String pernChrgPhnNum) {
        this.pernChrgPhnNum = pernChrgPhnNum;
    }
    
    public java.lang.String getUseHanCd() {
        return this.useHanCd;
    }
    
    public void setUseHanCd(java.lang.String useHanCd) {
        this.useHanCd = useHanCd;
    }
    
    public java.lang.String getSumtTgtPridCd() {
        return this.sumtTgtPridCd;
    }
    
    public void setSumtTgtPridCd(java.lang.String sumtTgtPridCd) {
        this.sumtTgtPridCd = sumtTgtPridCd;
    }
    
    public java.lang.String getCorpNum() {
        return this.corpNum;
    }
    
    public void setCorpNum(java.lang.String corpNum) {
        this.corpNum = corpNum;
    }
    
    public java.lang.String getIncmPost() {
        return this.incmPost;
    }
    
    public void setIncmPost(java.lang.String incmPost) {
        this.incmPost = incmPost;
    }
    
    public java.lang.String getIncmAddr() {
        return this.incmAddr;
    }
    
    public void setIncmAddr(java.lang.String incmAddr) {
        this.incmAddr = incmAddr;
    }
    
    public java.lang.String getIncmAdtl() {
        return this.incmAdtl;
    }
    
    public void setIncmAdtl(java.lang.String incmAdtl) {
        this.incmAdtl = incmAdtl;
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
    
}
