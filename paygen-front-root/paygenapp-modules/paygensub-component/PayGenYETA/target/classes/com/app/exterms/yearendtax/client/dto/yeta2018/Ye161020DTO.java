package com.app.exterms.yearendtax.client.dto.yeta2018;

import java.io.Serializable;


/**
 *
 * @Class Name : Ye161020DTO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161020DTO  implements Serializable {
	
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
    private java.lang.String rsplNtnInfrItem;
    

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
    private java.lang.String rsplNtnItem;

    /** set 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
    private java.lang.String inctxWhtxTxamtMetnCd;

    /** set 분납신청여부 : inpmYn */
    private java.lang.String inpmYn;

    /** set 인적공제항목변동여부 : prifChngYn */
    private java.lang.String prifChngYn;

    /** set 자녀인원수 : child */
    private Long child;

    /** set 기본공제인원수 : bscDdcnFpCnt */
    private Long bscDdcnFpCnt;

    /** set 경로우대인원수 : sccNfpCnt */
    private Long sccNfpCnt;

    /** set 출산입양인원수 : chbtAdopNfpCnt */
    private Long chbtAdopNfpCnt;

    /** set 부녀자인원수 : wmnNfpCnt */
    private Long wmnNfpCnt;

    /** set 한부모인원수 : snprntNfpCnt */
    private Long snprntNfpCnt;

    /** set 장애인인원수 : dsbrNfpCnt */
    private Long dsbrNfpCnt;

    /** set 6세이하인원수 : age6ltNfpCnt */
    private Long age6ltNfpCnt;

    /** set 소득공제신고전자파일제출여부 : fileSbtYn */
    private java.lang.String fileSbtYn;

    /** set 소득공제신고전자파일적용여부 : fileAppYn */
    private java.lang.String fileAppYn;

    /** set 서식코드 : formCd */
    private java.lang.String formCd;

    /** set 발급일자일련번호 : issDtSeilNum */
    private Long issDtSeilNum;
    
    /** set 표준세액공제적용여부 : c152StdTxDdcYn */
    private java.lang.String c152StdTxDdcYn;
    

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
    
    
	/** set D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
	private java.lang.String whdgDebrBusoprRgstnum;
    
    /** set D15_종전근무처급여금액 : prcspPaySum */
    private Long prcspPaySum;	

    /** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    private Long prcspIncmTxSum;

    /** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    private Long prcspRgonIncmTxSum;

    /** set C22_주현근무처_급여금액 : yeta0c22 */
    private Long yeta0c22;
    
    
    /** set C29_주현근무처_소득합계금액 : yeta0c29 */
    private Long yeta0c29;


    /** set C63_정산명세_총급여금액 : yeta0c63 */
    private Long yeta0c63;

    /** set C65_정산명세_근로소득금액 : yeta0c65 */
    private Long yeta0c65;

    /** set C162_주현근무지_기납부세액_소득세금액 : yetaC162 */
    private Long yetaC162;

    /** set C163_주현근무지_기납부세액_지방소득세금액 : yetaC163 */
    private Long yetaC163;

    /** set C64_정산명세_근로소득공제금액 : yeta0c64 */
    private Long yeta0c64;

    /** set C120_세액공제_근로소득세액공제금액 : yetaC120 */
    private Long yetaC120;

    /** set C112_종합소득과세표준금액 : yetaC112 */
    private Long yetaC112;

    /** set C113_산출세액 : yetaC113 */
    private Long yetaC113;
    
    private Long addrMrct;
    
    
	public java.lang.String getWhdgDebrBusoprRgstnum() {
		return whdgDebrBusoprRgstnum;
	}

	public void setWhdgDebrBusoprRgstnum(java.lang.String whdgDebrBusoprRgstnum) {
		this.whdgDebrBusoprRgstnum = whdgDebrBusoprRgstnum;
	}

	public Long getYeta0c64() {
		return yeta0c64;
	}

	public void setYeta0c64(Long yeta0c64) {
		this.yeta0c64 = yeta0c64;
	}

	public Long getYetaC120() {
		return yetaC120;
	}

	public void setYetaC120(Long yetaC120) {
		this.yetaC120 = yetaC120;
	}

	public Long getYetaC112() {
		return yetaC112;
	}

	public void setYetaC112(Long yetaC112) {
		this.yetaC112 = yetaC112;
	}

	public Long getYetaC113() {
		return yetaC113;
	}

	public void setYetaC113(Long yetaC113) {
		this.yetaC113 = yetaC113;
	}

	public Long getPrcspPaySum() {
		return prcspPaySum;
	}

	public void setPrcspPaySum(Long prcspPaySum) {
		this.prcspPaySum = prcspPaySum;
	}

	public Long getPrcspIncmTxSum() {
		return prcspIncmTxSum;
	}

	public void setPrcspIncmTxSum(Long prcspIncmTxSum) {
		this.prcspIncmTxSum = prcspIncmTxSum;
	}

	public Long getPrcspRgonIncmTxSum() {
		return prcspRgonIncmTxSum;
	}

	public void setPrcspRgonIncmTxSum(Long prcspRgonIncmTxSum) {
		this.prcspRgonIncmTxSum = prcspRgonIncmTxSum;
	}

	public Long getYeta0c22() {
		return yeta0c22;
	}

	public void setYeta0c22(Long yeta0c22) {
		this.yeta0c22 = yeta0c22;
	}

	public Long getYeta0c63() {
		return yeta0c63;
	}

	public void setYeta0c63(Long yeta0c63) {
		this.yeta0c63 = yeta0c63;
	}

	public Long getYeta0c65() {
		return yeta0c65;
	}

	public void setYeta0c65(Long yeta0c65) {
		this.yeta0c65 = yeta0c65;
	}

	public Long getYetaC162() {
		return yetaC162;
	}

	public void setYetaC162(Long yetaC162) {
		this.yetaC162 = yetaC162;
	}

	public Long getYetaC163() {
		return yetaC163;
	}

	public void setYetaC163(Long yetaC163) {
		this.yetaC163 = yetaC163;
	}

	public java.lang.String getC152StdTxDdcYn() {
		return c152StdTxDdcYn;
	}

	public void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn) {
		this.c152StdTxDdcYn = c152StdTxDdcYn;
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


	public Long getChild() {
		return child;
	}

	public void setChild(Long child) {
		this.child = child;
	}

	public Long getBscDdcnFpCnt() {
		return bscDdcnFpCnt;
	}

	public void setBscDdcnFpCnt(Long bscDdcnFpCnt) {
		this.bscDdcnFpCnt = bscDdcnFpCnt;
	}

	public Long getSccNfpCnt() {
		return sccNfpCnt;
	}

	public void setSccNfpCnt(Long sccNfpCnt) {
		this.sccNfpCnt = sccNfpCnt;
	}

	public Long getChbtAdopNfpCnt() {
		return chbtAdopNfpCnt;
	}

	public void setChbtAdopNfpCnt(Long chbtAdopNfpCnt) {
		this.chbtAdopNfpCnt = chbtAdopNfpCnt;
	}

	public Long getWmnNfpCnt() {
		return wmnNfpCnt;
	}

	public void setWmnNfpCnt(Long wmnNfpCnt) {
		this.wmnNfpCnt = wmnNfpCnt;
	}

	public Long getSnprntNfpCnt() {
		return snprntNfpCnt;
	}

	public void setSnprntNfpCnt(Long snprntNfpCnt) {
		this.snprntNfpCnt = snprntNfpCnt;
	}

	public Long getDsbrNfpCnt() {
		return dsbrNfpCnt;
	}

	public void setDsbrNfpCnt(Long dsbrNfpCnt) {
		this.dsbrNfpCnt = dsbrNfpCnt;
	}

	public Long getAge6ltNfpCnt() {
		return age6ltNfpCnt;
	}

	public void setAge6ltNfpCnt(Long age6ltNfpCnt) {
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

	public Long getIssDtSeilNum() {
		return issDtSeilNum;
	}

	public void setIssDtSeilNum(Long issDtSeilNum) {
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

	public java.lang.String getRsplNtnInfrItem() {
		return rsplNtnInfrItem;
	}

	public void setRsplNtnInfrItem(java.lang.String rsplNtnInfrItem) {
		this.rsplNtnInfrItem = rsplNtnInfrItem;
	}

	public java.lang.String getRsplNtnItem() {
		return rsplNtnItem;
	}

	public void setRsplNtnItem(java.lang.String rsplNtnItem) {
		this.rsplNtnItem = rsplNtnItem;
	}

	public Long getAddrMrct() {
		return addrMrct;
	}

	public void setAddrMrct(Long addrMrct) {
		this.addrMrct = addrMrct;
	}

	public Long getYeta0c29() {
		return yeta0c29;
	}

	public void setYeta0c29(Long yeta0c29) {
		this.yeta0c29 = yeta0c29;
	}

	
}
