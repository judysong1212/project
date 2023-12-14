package com.app.exterms.yearendtax.client.dto.yeta2019;

import java.io.Serializable;
import java.util.List;

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
public class Ye161005DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;
    
    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String srhYrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String srhClutSeptCd;
 
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
    
    
    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String srhPayrMangDeptCd;
    
    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String srhEmymtDivCd;
    
    /** set 부서코드 : deptCd */
    private java.lang.String srhDeptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String srhTypOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String srhDtilOccuClsDivCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String srhPyspGrdeCd;

    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String srhDtilOccuInttnCd;

    /** set 사업코드 : businCd */
    private java.lang.String srhBusinCd;
    
    private java.lang.String srhUtDpobCd; 
    
    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth; 
    
    
    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;
    
   

    /** set 대표자성명 : reprName */
    private java.lang.String reprName;
    
    /** set 주민등록번호 : resuNumb */
    private java.lang.String resuNumb;
    
    /** set C171_사업자단위과세자여부 : yetaC171 */
    private Boolean yetaC171;

    /** set C172_종사업장일련번호 : yetaC172 */
    private java.lang.String yetaC172;

    
    /**
	 * Comment : 
	 * @fn java.lang.String getSrhUtDpobCd()
	 * @brief date:2018 2018. 2. 12. user:atres
	 * @return the srhUtDpobCd get
	 */
	public java.lang.String getSrhUtDpobCd() {
		return srhUtDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhUtDpobCd(java.lang.String srhUtDpobCd)
	 *@brief date:2018 2018. 2. 12. user:atres
	 *@param srhUtDpobCd the srhUtDpobCd to set
	 */
	public void setSrhUtDpobCd(java.lang.String srhUtDpobCd) {
		this.srhUtDpobCd = srhUtDpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getReprName()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the reprName get
	 */
	public java.lang.String getReprName() {
		return reprName;
	}

	/**
	 * Comment : 
	 *@fn void setReprName(java.lang.String reprName)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param reprName the reprName to set
	 */
	public void setReprName(java.lang.String reprName) {
		this.reprName = reprName;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getResuNumb()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the resuNumb get
	 */
	public java.lang.String getResuNumb() {
		return resuNumb;
	}

	/**
	 * Comment : 
	 *@fn void setResuNumb(java.lang.String resuNumb)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param resuNumb the resuNumb to set
	 */
	public void setResuNumb(java.lang.String resuNumb) {
		this.resuNumb = resuNumb;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPayrMangDeptCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhPayrMangDeptCd get
	 */
	public java.lang.String getSrhPayrMangDeptCd() {
		return srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhPayrMangDeptCd the srhPayrMangDeptCd to set
	 */
	public void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd) {
		this.srhPayrMangDeptCd = srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhEmymtDivCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhEmymtDivCd get
	 */
	public java.lang.String getSrhEmymtDivCd() {
		return srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhEmymtDivCd the srhEmymtDivCd to set
	 */
	public void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd) {
		this.srhEmymtDivCd = srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDeptCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhDeptCd get
	 */
	public java.lang.String getSrhDeptCd() {
		return srhDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDeptCd(java.lang.String srhDeptCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhDeptCd the srhDeptCd to set
	 */
	public void setSrhDeptCd(java.lang.String srhDeptCd) {
		this.srhDeptCd = srhDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhTypOccuCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhTypOccuCd get
	 */
	public java.lang.String getSrhTypOccuCd() {
		return srhTypOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhTypOccuCd(java.lang.String srhTypOccuCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhTypOccuCd the srhTypOccuCd to set
	 */
	public void setSrhTypOccuCd(java.lang.String srhTypOccuCd) {
		this.srhTypOccuCd = srhTypOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuClsDivCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhDtilOccuClsDivCd get
	 */
	public java.lang.String getSrhDtilOccuClsDivCd() {
		return srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhDtilOccuClsDivCd the srhDtilOccuClsDivCd to set
	 */
	public void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd) {
		this.srhDtilOccuClsDivCd = srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPyspGrdeCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhPyspGrdeCd get
	 */
	public java.lang.String getSrhPyspGrdeCd() {
		return srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhPyspGrdeCd the srhPyspGrdeCd to set
	 */
	public void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd) {
		this.srhPyspGrdeCd = srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuInttnCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhDtilOccuInttnCd get
	 */
	public java.lang.String getSrhDtilOccuInttnCd() {
		return srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhDtilOccuInttnCd the srhDtilOccuInttnCd to set
	 */
	public void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd) {
		this.srhDtilOccuInttnCd = srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhBusinCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the srhBusinCd get
	 */
	public java.lang.String getSrhBusinCd() {
		return srhBusinCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhBusinCd(java.lang.String srhBusinCd)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param srhBusinCd the srhBusinCd to set
	 */
	public void setSrhBusinCd(java.lang.String srhBusinCd) {
		this.srhBusinCd = srhBusinCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSystemkey()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the systemkey get
	 */
	public java.lang.String getSystemkey() {
		return systemkey;
	}

	/**
	 * Comment : 
	 *@fn void setSystemkey(java.lang.String systemkey)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param systemkey the systemkey to set
	 */
	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYrtxBlggYr()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the yrtxBlggYr get
	 */
	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	/**
	 * Comment : 
	 *@fn void setYrtxBlggYr(java.lang.String yrtxBlggYr)
	 *@brief date:2018 2018. 1. 16. user:atres
	 *@param yrtxBlggYr the yrtxBlggYr to set
	 */
	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getClutSeptCd()
	 * @brief date:2018 2018. 1. 16. user:atres
	 * @return the clutSeptCd get
	 */
	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setClutSeptCd(java.lang.String clutSeptCd)
	 *@brief date:2018 2018. 1. 16. user:atres
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

 

	/**
	 * Comment : 
	 * @fn Boolean getYetaC171()
	 * @brief date:2018 2018. 2. 13. user:atres
	 * @return the yetaC171 get
	 */
	public Boolean getYetaC171() {
		return yetaC171;
	}

	/**
	 * Comment : 
	 *@fn void setYetaC171(Boolean yetaC171)
	 *@brief date:2018 2018. 2. 13. user:atres
	 *@param yetaC171 the yetaC171 to set
	 */
	public void setYetaC171(Boolean yetaC171) {
		this.yetaC171 = yetaC171;
	}

	public java.lang.String getYetaC172() {
		return yetaC172;
	}

	public void setYetaC172(java.lang.String yetaC172) {
		this.yetaC172 = yetaC172;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhYrtxBlggYr()
	 * @brief date:2018 2018. 2. 12. user:atres
	 * @return the srhYrtxBlggYr get
	 */
	public java.lang.String getSrhYrtxBlggYr() {
		return srhYrtxBlggYr;
	}

	
	/**
	 * Comment : 
	 *@fn void setSrhYrtxBlggYr(java.lang.String srhYrtxBlggYr)
	 *@brief date:2018 2018. 2. 12. user:atres
	 *@param srhYrtxBlggYr the srhYrtxBlggYr to set
	 */
	public void setSrhYrtxBlggYr(java.lang.String srhYrtxBlggYr) {
		this.srhYrtxBlggYr = srhYrtxBlggYr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhClutSeptCd()
	 * @brief date:2018 2018. 2. 12. user:atres
	 * @return the srhClutSeptCd get
	 */
	public java.lang.String getSrhClutSeptCd() {
		return srhClutSeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhClutSeptCd(java.lang.String srhClutSeptCd)
	 *@brief date:2018 2018. 2. 12. user:atres
	 *@param srhClutSeptCd the srhClutSeptCd to set
	 */
	public void setSrhClutSeptCd(java.lang.String srhClutSeptCd) {
		this.srhClutSeptCd = srhClutSeptCd;
	}
    
    
}
