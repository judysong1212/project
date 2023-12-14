package com.app.exterms.yearendtax.client.dto.yeta2023;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Yeta2000VO.java
 * @Description : Yeta2000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye17Ta1005DTO  implements Serializable {
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
    
    
    
    
	/** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    /** 대상자타입 printType */
    private java.lang.String printType;
    
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
 
    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;
    
    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;
    
    /** 성명 HAN_NM */
    private java.lang.String hanNm;
    
    /** 주민번호 RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** 사업코드 BUSIN_CD  */
    private java.lang.String businCd;
    
    private List<String> businCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** 부서코드 DEPT_CD */
    private java.lang.String deptCd;
    
    // 단위기관 담당자 여부
    private java.lang.String  payrMangDeptCd;


	/** 직종코드 TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    
    /** 직종세코드 DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    
    
    

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	public java.lang.String getPrintType() {
		return printType;
	}

	public void setPrintType(java.lang.String printType) {
		this.printType = printType;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	public java.lang.String getSettGbcd() {
		return settGbcd;
	}

	public void setSettGbcd(java.lang.String settGbcd) {
		this.settGbcd = settGbcd;
	}

	public java.lang.String getEdacRvyy() {
		return edacRvyy;
	}

	public void setEdacRvyy(java.lang.String edacRvyy) {
		this.edacRvyy = edacRvyy;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public List<String> getBusinCdArr() {
		return businCdArr;
	}

	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getWhdgTxRegrstDeptCd() {
		return whdgTxRegrstDeptCd;
	}

	public void setWhdgTxRegrstDeptCd(java.lang.String whdgTxRegrstDeptCd) {
		this.whdgTxRegrstDeptCd = whdgTxRegrstDeptCd;
	}

	public java.lang.String getHhrkWhdgRegrstDeptCd() {
		return hhrkWhdgRegrstDeptCd;
	}

	public void setHhrkWhdgRegrstDeptCd(java.lang.String hhrkWhdgRegrstDeptCd) {
		this.hhrkWhdgRegrstDeptCd = hhrkWhdgRegrstDeptCd;
	}

	public java.lang.String getTxOffcCd() {
		return txOffcCd;
	}

	public void setTxOffcCd(java.lang.String txOffcCd) {
		this.txOffcCd = txOffcCd;
	}

	public java.lang.String getPentrSeptCd() {
		return pentrSeptCd;
	}

	public void setPentrSeptCd(java.lang.String pentrSeptCd) {
		this.pentrSeptCd = pentrSeptCd;
	}

	public java.lang.String getTxDeptyMangeNum() {
		return txDeptyMangeNum;
	}

	public void setTxDeptyMangeNum(java.lang.String txDeptyMangeNum) {
		this.txDeptyMangeNum = txDeptyMangeNum;
	}

	public java.lang.String getHmtxId() {
		return hmtxId;
	}

	public void setHmtxId(java.lang.String hmtxId) {
		this.hmtxId = hmtxId;
	}

	public java.lang.String getTxPgmCd() {
		return txPgmCd;
	}

	public void setTxPgmCd(java.lang.String txPgmCd) {
		this.txPgmCd = txPgmCd;
	}

	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}

	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

	public java.lang.String getCorpFmnmNm() {
		return corpFmnmNm;
	}

	public void setCorpFmnmNm(java.lang.String corpFmnmNm) {
		this.corpFmnmNm = corpFmnmNm;
	}

	public java.lang.String getPernChrgDeptNm() {
		return pernChrgDeptNm;
	}

	public void setPernChrgDeptNm(java.lang.String pernChrgDeptNm) {
		this.pernChrgDeptNm = pernChrgDeptNm;
	}

	public java.lang.String getPernChrgNm() {
		return pernChrgNm;
	}

	public void setPernChrgNm(java.lang.String pernChrgNm) {
		this.pernChrgNm = pernChrgNm;
	}

	public java.lang.String getPernChrgPhnNum() {
		return pernChrgPhnNum;
	}

	public void setPernChrgPhnNum(java.lang.String pernChrgPhnNum) {
		this.pernChrgPhnNum = pernChrgPhnNum;
	}

	public java.lang.String getUseHanCd() {
		return useHanCd;
	}

	public void setUseHanCd(java.lang.String useHanCd) {
		this.useHanCd = useHanCd;
	}

	public java.lang.String getSumtTgtPridCd() {
		return sumtTgtPridCd;
	}

	public void setSumtTgtPridCd(java.lang.String sumtTgtPridCd) {
		this.sumtTgtPridCd = sumtTgtPridCd;
	}

	public java.lang.String getCorpNum() {
		return corpNum;
	}

	public void setCorpNum(java.lang.String corpNum) {
		this.corpNum = corpNum;
	}

	public java.lang.String getIncmPost() {
		return incmPost;
	}

	public void setIncmPost(java.lang.String incmPost) {
		this.incmPost = incmPost;
	}

	public java.lang.String getIncmAddr() {
		return incmAddr;
	}

	public void setIncmAddr(java.lang.String incmAddr) {
		this.incmAddr = incmAddr;
	}

	public java.lang.String getIncmAdtl() {
		return incmAdtl;
	}

	public void setIncmAdtl(java.lang.String incmAdtl) {
		this.incmAdtl = incmAdtl;
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

	public java.lang.String getReprName() {
		return reprName;
	}

	public void setReprName(java.lang.String reprName) {
		this.reprName = reprName;
	}

	public java.lang.String getResuNumb() {
		return resuNumb;
	}

	public void setResuNumb(java.lang.String resuNumb) {
		this.resuNumb = resuNumb;
	}
    
    
}
