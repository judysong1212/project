package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;



/**
 *
 * @Class Name : Ye161020VO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161020_2020_VO implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 귀속연도 : yrtxBlggYr */
	private java.lang.String yrtxBlggYr;

	/** set 연말정산구분코드 : clutSeptCd */
	private java.lang.String clutSeptCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 소득자성명 : fnm */
	private java.lang.String fnm;

	/** set 주민등록번호 : resnoEncCntn */
	private java.lang.String resnoEncCntn;

	/** set 내외국인구분 : nnfClCd */
	private java.lang.String nnfClCd;

	/** set 근무처명 : tnm */
	private java.lang.String tnm;

	/** set 사업자등록번호 : bsnoEncCntn */
	private java.lang.String bsnoEncCntn;

	/** set 세대주여부 : hshrClCd */
	private java.lang.String hshrClCd;

	/** set 국적 : rsplNtnInfrNm */
	private java.lang.String rsplNtnInfrNm;

	/** set 국적코드 : rsplNtnInfrCd */
	private java.lang.String rsplNtnInfrCd;

	/** set 근무기간시작일자 : dtyStrtDt */
	private java.lang.String dtyStrtDt;

	/** set 근무기간종료일자 : dtyEndDt */
	private java.lang.String dtyEndDt;

	/** set 감면기간시작일자 : reStrtDt */
	private java.lang.String reStrtDt;

	/** set 감면기간종료일자 : reEndDt */
	private java.lang.String reEndDt;

	/** set 거주구분 : rsdtClCd */
	private java.lang.String rsdtClCd;

	/** set 거주지국명 : rsplNtnNm */
	private java.lang.String rsplNtnNm;

	/** set 거주지코드 : rsplNtnCd */
	private java.lang.String rsplNtnCd;

	/** set 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
	private java.lang.String inctxWhtxTxamtMetnCd;

	/** set 분납신청여부 : inpmYn */
	private java.lang.String inpmYn;

	/** set 인적공제항목변동여부 : prifChngYn */
	private java.lang.String prifChngYn;

	/** set 표준세액공제적용여부 : c152StdTxDdcYn */
	private java.lang.String c152StdTxDdcYn;

	/** set 자녀인원수 : child */
	private java.math.BigDecimal child;

	/** set 기본공제인원수 : bscDdcnFpCnt */
	private java.math.BigDecimal bscDdcnFpCnt;

	/** set 경로우대인원수 : sccNfpCnt */
	private java.math.BigDecimal sccNfpCnt;

	/** set 출산입양인원수 : chbtAdopNfpCnt */
	private java.math.BigDecimal chbtAdopNfpCnt;

	/** set 부녀자인원수 : wmnNfpCnt */
	private java.math.BigDecimal wmnNfpCnt;

	/** set 한부모인원수 : snprntNfpCnt */
	private java.math.BigDecimal snprntNfpCnt;

	/** set 장애인인원수 : dsbrNfpCnt */
	private java.math.BigDecimal dsbrNfpCnt;

	/** set 6세이하인원수 : age6ltNfpCnt */
	private java.math.BigDecimal age6ltNfpCnt;

	/** set 소득공제신고전자파일제출여부 : fileSbtYn */
	private java.lang.String fileSbtYn;

	/** set 소득공제신고전자파일적용여부 : fileAppYn */
	private java.lang.String fileAppYn;

	/** set 서식코드 : formCd */
	private java.lang.String formCd;

	/** set 발급일자일련번호 : issDtSeilNum */
	private java.math.BigDecimal issDtSeilNum;

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
	

    /** set D15_종전근무처급여금액 : prcspPaySum */
    private java.math.BigDecimal prcspPaySum;	

    /** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    private java.math.BigDecimal prcspIncmTxSum;

    /** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    private java.math.BigDecimal prcspRgonIncmTxSum;

    /** set C22_주현근무처_급여금액 : yeta0c22 */
    private java.math.BigDecimal yeta0c22;

    /** set C63_정산명세_총급여금액 : yeta0c63 */
    private java.math.BigDecimal yeta0c63;

    /** set C65_정산명세_근로소득금액 : yeta0c65 */
    private java.math.BigDecimal yeta0c65;

    /** set C64_정산명세_근로소득공제금액 : yeta0c64 */
    private java.math.BigDecimal yeta0c64;

    /** set C120_세액공제_근로소득세액공제금액 : yetaC120 */
    private java.math.BigDecimal yetaC120;

    /** set C112_종합소득과세표준금액 : yetaC112 */
    private java.math.BigDecimal yetaC112;

    /** set C113_산출세액 : yetaC113 */
    private java.math.BigDecimal yetaC113;

    /** set C162_주현근무지_기납부세액_소득세금액 : yetaC162 */
    private java.math.BigDecimal yetaC162;

    /** set C163_주현근무지_기납부세액_지방소득세금액 : yetaC163 */
    private java.math.BigDecimal yetaC163;
    
    
	/** set 단위사업장코드 : utDpobCd */
	private java.lang.String utDpobCd;
	
	
    
    
	public java.lang.String getUtDpobCd() {
		return utDpobCd;
	}

	public void setUtDpobCd(java.lang.String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}

	public java.math.BigDecimal getYeta0c64() {
		return yeta0c64;
	}

	public void setYeta0c64(java.math.BigDecimal yeta0c64) {
		this.yeta0c64 = yeta0c64;
	}

	public java.math.BigDecimal getYetaC120() {
		return yetaC120;
	}

	public void setYetaC120(java.math.BigDecimal yetaC120) {
		this.yetaC120 = yetaC120;
	}

	public java.math.BigDecimal getYetaC112() {
		return yetaC112;
	}

	public void setYetaC112(java.math.BigDecimal yetaC112) {
		this.yetaC112 = yetaC112;
	}

	public java.math.BigDecimal getYetaC113() {
		return yetaC113;
	}

	public void setYetaC113(java.math.BigDecimal yetaC113) {
		this.yetaC113 = yetaC113;
	}

	public java.math.BigDecimal getPrcspPaySum() {
		return prcspPaySum;
	}

	public void setPrcspPaySum(java.math.BigDecimal prcspPaySum) {
		this.prcspPaySum = prcspPaySum;
	}

	public java.math.BigDecimal getPrcspIncmTxSum() {
		return prcspIncmTxSum;
	}

	public void setPrcspIncmTxSum(java.math.BigDecimal prcspIncmTxSum) {
		this.prcspIncmTxSum = prcspIncmTxSum;
	}

	public java.math.BigDecimal getPrcspRgonIncmTxSum() {
		return prcspRgonIncmTxSum;
	}

	public void setPrcspRgonIncmTxSum(java.math.BigDecimal prcspRgonIncmTxSum) {
		this.prcspRgonIncmTxSum = prcspRgonIncmTxSum;
	}

	public java.math.BigDecimal getYeta0c22() {
		return yeta0c22;
	}

	public void setYeta0c22(java.math.BigDecimal yeta0c22) {
		this.yeta0c22 = yeta0c22;
	}

	public java.math.BigDecimal getYeta0c63() {
		return yeta0c63;
	}

	public void setYeta0c63(java.math.BigDecimal yeta0c63) {
		this.yeta0c63 = yeta0c63;
	}

	public java.math.BigDecimal getYeta0c65() {
		return yeta0c65;
	}

	public void setYeta0c65(java.math.BigDecimal yeta0c65) {
		this.yeta0c65 = yeta0c65;
	}

	public java.math.BigDecimal getYetaC162() {
		return yetaC162;
	}

	public void setYetaC162(java.math.BigDecimal yetaC162) {
		this.yetaC162 = yetaC162;
	}

	public java.math.BigDecimal getYetaC163() {
		return yetaC163;
	}

	public void setYetaC163(java.math.BigDecimal yetaC163) {
		this.yetaC163 = yetaC163;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getFnm() {
		return fnm;
	}

	public void setFnm(java.lang.String fnm) {
		this.fnm = fnm;
	}

	public java.lang.String getResnoEncCntn() {
		return resnoEncCntn;
	}

	public void setResnoEncCntn(java.lang.String resnoEncCntn) {
		this.resnoEncCntn = resnoEncCntn;
	}

	public java.lang.String getNnfClCd() {
		return nnfClCd;
	}

	public void setNnfClCd(java.lang.String nnfClCd) {
		this.nnfClCd = nnfClCd;
	}

	public java.lang.String getTnm() {
		return tnm;
	}

	public void setTnm(java.lang.String tnm) {
		this.tnm = tnm;
	}

	public java.lang.String getBsnoEncCntn() {
		return bsnoEncCntn;
	}

	public void setBsnoEncCntn(java.lang.String bsnoEncCntn) {
		this.bsnoEncCntn = bsnoEncCntn;
	}

	public java.lang.String getHshrClCd() {
		return hshrClCd;
	}

	public void setHshrClCd(java.lang.String hshrClCd) {
		this.hshrClCd = hshrClCd;
	}

	public java.lang.String getRsplNtnInfrNm() {
		return rsplNtnInfrNm;
	}

	public void setRsplNtnInfrNm(java.lang.String rsplNtnInfrNm) {
		this.rsplNtnInfrNm = rsplNtnInfrNm;
	}

	public java.lang.String getRsplNtnInfrCd() {
		return rsplNtnInfrCd;
	}

	public void setRsplNtnInfrCd(java.lang.String rsplNtnInfrCd) {
		this.rsplNtnInfrCd = rsplNtnInfrCd;
	}

	public java.lang.String getDtyStrtDt() {
		return dtyStrtDt;
	}

	public void setDtyStrtDt(java.lang.String dtyStrtDt) {
		this.dtyStrtDt = dtyStrtDt;
	}

	public java.lang.String getDtyEndDt() {
		return dtyEndDt;
	}

	public void setDtyEndDt(java.lang.String dtyEndDt) {
		this.dtyEndDt = dtyEndDt;
	}

	public java.lang.String getReStrtDt() {
		return reStrtDt;
	}

	public void setReStrtDt(java.lang.String reStrtDt) {
		this.reStrtDt = reStrtDt;
	}

	public java.lang.String getReEndDt() {
		return reEndDt;
	}

	public void setReEndDt(java.lang.String reEndDt) {
		this.reEndDt = reEndDt;
	}

	public java.lang.String getRsdtClCd() {
		return rsdtClCd;
	}

	public void setRsdtClCd(java.lang.String rsdtClCd) {
		this.rsdtClCd = rsdtClCd;
	}

	public java.lang.String getRsplNtnNm() {
		return rsplNtnNm;
	}

	public void setRsplNtnNm(java.lang.String rsplNtnNm) {
		this.rsplNtnNm = rsplNtnNm;
	}

	public java.lang.String getRsplNtnCd() {
		return rsplNtnCd;
	}

	public void setRsplNtnCd(java.lang.String rsplNtnCd) {
		this.rsplNtnCd = rsplNtnCd;
	}

	public java.lang.String getInctxWhtxTxamtMetnCd() {
		return inctxWhtxTxamtMetnCd;
	}

	public void setInctxWhtxTxamtMetnCd(java.lang.String inctxWhtxTxamtMetnCd) {
		this.inctxWhtxTxamtMetnCd = inctxWhtxTxamtMetnCd;
	}

	public java.lang.String getInpmYn() {
		return inpmYn;
	}

	public void setInpmYn(java.lang.String inpmYn) {
		this.inpmYn = inpmYn;
	}

	public java.lang.String getPrifChngYn() {
		return prifChngYn;
	}

	public void setPrifChngYn(java.lang.String prifChngYn) {
		this.prifChngYn = prifChngYn;
	}


	public java.lang.String getC152StdTxDdcYn() {
		return c152StdTxDdcYn;
	}

	public void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn) {
		this.c152StdTxDdcYn = c152StdTxDdcYn;
	}

	public java.math.BigDecimal getChild() {
		return child;
	}

	public void setChild(java.math.BigDecimal child) {
		this.child = child;
	}

	public java.math.BigDecimal getBscDdcnFpCnt() {
		return bscDdcnFpCnt;
	}

	public void setBscDdcnFpCnt(java.math.BigDecimal bscDdcnFpCnt) {
		this.bscDdcnFpCnt = bscDdcnFpCnt;
	}

	public java.math.BigDecimal getSccNfpCnt() {
		return sccNfpCnt;
	}

	public void setSccNfpCnt(java.math.BigDecimal sccNfpCnt) {
		this.sccNfpCnt = sccNfpCnt;
	}

	public java.math.BigDecimal getChbtAdopNfpCnt() {
		return chbtAdopNfpCnt;
	}

	public void setChbtAdopNfpCnt(java.math.BigDecimal chbtAdopNfpCnt) {
		this.chbtAdopNfpCnt = chbtAdopNfpCnt;
	}

	public java.math.BigDecimal getWmnNfpCnt() {
		return wmnNfpCnt;
	}

	public void setWmnNfpCnt(java.math.BigDecimal wmnNfpCnt) {
		this.wmnNfpCnt = wmnNfpCnt;
	}

	public java.math.BigDecimal getSnprntNfpCnt() {
		return snprntNfpCnt;
	}

	public void setSnprntNfpCnt(java.math.BigDecimal snprntNfpCnt) {
		this.snprntNfpCnt = snprntNfpCnt;
	}

	public java.math.BigDecimal getDsbrNfpCnt() {
		return dsbrNfpCnt;
	}

	public void setDsbrNfpCnt(java.math.BigDecimal dsbrNfpCnt) {
		this.dsbrNfpCnt = dsbrNfpCnt;
	}

	public java.math.BigDecimal getAge6ltNfpCnt() {
		return age6ltNfpCnt;
	}

	public void setAge6ltNfpCnt(java.math.BigDecimal age6ltNfpCnt) {
		this.age6ltNfpCnt = age6ltNfpCnt;
	}

	public java.lang.String getFileSbtYn() {
		return fileSbtYn;
	}

	public void setFileSbtYn(java.lang.String fileSbtYn) {
		this.fileSbtYn = fileSbtYn;
	}

	public java.lang.String getFileAppYn() {
		return fileAppYn;
	}

	public void setFileAppYn(java.lang.String fileAppYn) {
		this.fileAppYn = fileAppYn;
	}

	public java.lang.String getFormCd() {
		return formCd;
	}

	public void setFormCd(java.lang.String formCd) {
		this.formCd = formCd;
	}

	public java.math.BigDecimal getIssDtSeilNum() {
		return issDtSeilNum;
	}

	public void setIssDtSeilNum(java.math.BigDecimal issDtSeilNum) {
		this.issDtSeilNum = issDtSeilNum;
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