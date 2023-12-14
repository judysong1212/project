package com.app.smrmf.infc.yearendtax.server.vo.yeta2022;

import java.io.Serializable;

/**
 * @Class Name : Yeta1000DefaultVO.java
 * @Description : Yeta1000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgYe161020Srh_2022_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
 
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

    /** set 자애인인원수 : dsbrNfpCnt */
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

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
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



}
