package com.app.smrmf.infc.yearendtax.server.vo.yeta2019;

import java.io.Serializable;
import java.util.List;


/**
 * @Class Name : Yeta3900VO.java
 * @Description : Yeta3900VO class
 * @Modification Information
 *
 * @author HyunMin
 * @since 2016.01.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */


public class InfcPkgYe161020_2019_VO implements Serializable  {
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
	

	/** set 단위사업장코드 : utDpobCd */
	private java.lang.String utDpobCd;
	
	/***********************************************
	 *  검색조건값을 넘김  등 기타조건등 처리를 위한 값.
	 ***********************************************/
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
     
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCdAuth;

    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCdAuth;
    
    
    
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    
    private java.lang.String addCheck;
    
    private java.lang.String creFile; 
    
    private java.lang.String c152StdTxDdcYn; 
     
	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    /** TYP_OCCU_CD */
    private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
    

    /** 사업코드 BUSIN_CD  */
    private List<String> businCdArr; 
    
   
    
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
     
 
 
    private java.lang.String busoprRgstnum;  
    
    /*************************************************
     * 검색조건값을 넘김  등 기타조건등 처리를 위한 값.
     *************************************************/
    
    /*********추후 추가된 내용 ****************************/
    


	/** set 급여관리부서코드 : payrMangDeptCd */
	private java.lang.String payrMangDeptCd;

	/** set 당시_고용구분코드 : emymtDivCd */
	private java.lang.String emymtDivCd;

	/** set 당시_부서코드 : deptCd */
	private java.lang.String deptCd;

	/** set 당시_직종코드 : typOccuCd */
	private java.lang.String typOccuCd;

	/** set 당시_직종세통합코드 : dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;

	/** set 당시_사업코드 : businCd */
	private java.lang.String businCd;
 
	/** set 주민등록번호 : resnRegnNum */
	private java.lang.String resnRegnNum;
	
	
	

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the payrMangDeptCd get
	 */
	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptCd(java.lang.String payrMangDeptCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param payrMangDeptCd the payrMangDeptCd to set
	 */
	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getEmymtDivCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the emymtDivCd get
	 */
	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtDivCd(java.lang.String emymtDivCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param emymtDivCd the emymtDivCd to set
	 */
	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the deptCd get
	 */
	public java.lang.String getDeptCd() {
		return deptCd;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCd(java.lang.String deptCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param deptCd the deptCd to set
	 */
	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getTypOccuCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the typOccuCd get
	 */
	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCd(java.lang.String typOccuCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param typOccuCd the typOccuCd to set
	 */
	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusinCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the businCd get
	 */
	public java.lang.String getBusinCd() {
		return businCd;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCd(java.lang.String businCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param businCd the businCd to set
	 */
	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getResnRegnNum()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the resnRegnNum get
	 */
	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setResnRegnNum(java.lang.String resnRegnNum)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param resnRegnNum the resnRegnNum to set
	 */
	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getDpobCd() { 
		return dpobCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUtDpobCd()
	 * @brief date:2019 2019. 2. 19. user:atres
	 * @return the utDpobCd get
	 */
	public java.lang.String getUtDpobCd() {
		return utDpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setUtDpobCd(java.lang.String utDpobCd)
	 *@brief date:2019 2019. 2. 19. user:atres
	 *@param utDpobCd the utDpobCd to set
	 */
	public void setUtDpobCd(java.lang.String utDpobCd) {
		this.utDpobCd = utDpobCd;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPayrMangDeptCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhPayrMangDeptCd get
	 */
	public java.lang.String getSrhPayrMangDeptCd() {
		return srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhPayrMangDeptCd the srhPayrMangDeptCd to set
	 */
	public void setSrhPayrMangDeptCd(java.lang.String srhPayrMangDeptCd) {
		this.srhPayrMangDeptCd = srhPayrMangDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhEmymtDivCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhEmymtDivCd get
	 */
	public java.lang.String getSrhEmymtDivCd() {
		return srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhEmymtDivCd the srhEmymtDivCd to set
	 */
	public void setSrhEmymtDivCd(java.lang.String srhEmymtDivCd) {
		this.srhEmymtDivCd = srhEmymtDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDeptCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhDeptCd get
	 */
	public java.lang.String getSrhDeptCd() {
		return srhDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDeptCd(java.lang.String srhDeptCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhDeptCd the srhDeptCd to set
	 */
	public void setSrhDeptCd(java.lang.String srhDeptCd) {
		this.srhDeptCd = srhDeptCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhTypOccuCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhTypOccuCd get
	 */
	public java.lang.String getSrhTypOccuCd() {
		return srhTypOccuCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhTypOccuCd(java.lang.String srhTypOccuCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhTypOccuCd the srhTypOccuCd to set
	 */
	public void setSrhTypOccuCd(java.lang.String srhTypOccuCd) {
		this.srhTypOccuCd = srhTypOccuCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuClsDivCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhDtilOccuClsDivCd get
	 */
	public java.lang.String getSrhDtilOccuClsDivCd() {
		return srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhDtilOccuClsDivCd the srhDtilOccuClsDivCd to set
	 */
	public void setSrhDtilOccuClsDivCd(java.lang.String srhDtilOccuClsDivCd) {
		this.srhDtilOccuClsDivCd = srhDtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhPyspGrdeCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhPyspGrdeCd get
	 */
	public java.lang.String getSrhPyspGrdeCd() {
		return srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhPyspGrdeCd the srhPyspGrdeCd to set
	 */
	public void setSrhPyspGrdeCd(java.lang.String srhPyspGrdeCd) {
		this.srhPyspGrdeCd = srhPyspGrdeCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhDtilOccuInttnCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhDtilOccuInttnCd get
	 */
	public java.lang.String getSrhDtilOccuInttnCd() {
		return srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhDtilOccuInttnCd the srhDtilOccuInttnCd to set
	 */
	public void setSrhDtilOccuInttnCd(java.lang.String srhDtilOccuInttnCd) {
		this.srhDtilOccuInttnCd = srhDtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSrhBusinCd()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the srhBusinCd get
	 */
	public java.lang.String getSrhBusinCd() {
		return srhBusinCd;
	}

	/**
	 * Comment : 
	 *@fn void setSrhBusinCd(java.lang.String srhBusinCd)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param srhBusinCd the srhBusinCd to set
	 */
	public void setSrhBusinCd(java.lang.String srhBusinCd) {
		this.srhBusinCd = srhBusinCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDeptCdAuth()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the deptCdAuth get
	 */
	public java.lang.String getDeptCdAuth() {
		return deptCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param deptCdAuth the deptCdAuth to set
	 */
	public void setDeptCdAuth(java.lang.String deptCdAuth) {
		this.deptCdAuth = deptCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCdAuth()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the dtilOccuInttnCdAuth get
	 */
	public java.lang.String getDtilOccuInttnCdAuth() {
		return dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
	 */
	public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
		this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getPayrMangDeptYn()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the payrMangDeptYn get
	 */
	public java.lang.String getPayrMangDeptYn() {
		return payrMangDeptYn;
	}

	/**
	 * Comment : 
	 *@fn void setPayrMangDeptYn(java.lang.String payrMangDeptYn)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param payrMangDeptYn the payrMangDeptYn to set
	 */
	public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
		this.payrMangDeptYn = payrMangDeptYn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getAddCheck()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the addCheck get
	 */
	public java.lang.String getAddCheck() {
		return addCheck;
	}

	/**
	 * Comment : 
	 *@fn void setAddCheck(java.lang.String addCheck)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param addCheck the addCheck to set
	 */
	public void setAddCheck(java.lang.String addCheck) {
		this.addCheck = addCheck;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getCreFile()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the creFile get
	 */
	public java.lang.String getCreFile() {
		return creFile;
	}

	/**
	 * Comment : 
	 *@fn void setCreFile(java.lang.String creFile)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param creFile the creFile to set
	 */
	public void setCreFile(java.lang.String creFile) {
		this.creFile = creFile;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDeptCdArr()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the deptCdArr get
	 */
	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDeptCdArr(List<String> deptCdArr)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param deptCdArr the deptCdArr to set
	 */
	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getTypOccuCdArr()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the typOccuCdArr get
	 */
	public List<String> getTypOccuCdArr() {
		return typOccuCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setTypOccuCdArr(List<String> typOccuCdArr)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param typOccuCdArr the typOccuCdArr to set
	 */
	public void setTypOccuCdArr(List<String> typOccuCdArr) {
		this.typOccuCdArr = typOccuCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getBusinCdArr()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the businCdArr get
	 */
	public List<String> getBusinCdArr() {
		return businCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setBusinCdArr(List<String> businCdArr)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param businCdArr the businCdArr to set
	 */
	public void setBusinCdArr(List<String> businCdArr) {
		this.businCdArr = businCdArr;
	}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getBusoprRgstnum()
	 * @brief date:2019 2019. 2. 8. user:atres
	 * @return the busoprRgstnum get
	 */
	public java.lang.String getBusoprRgstnum() {
		return busoprRgstnum;
	}

	/**
	 * Comment : 
	 *@fn void setBusoprRgstnum(java.lang.String busoprRgstnum)
	 *@brief date:2019 2019. 2. 8. user:atres
	 *@param busoprRgstnum the busoprRgstnum to set
	 */
	public void setBusoprRgstnum(java.lang.String busoprRgstnum) {
		this.busoprRgstnum = busoprRgstnum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getC152StdTxDdcYn()
	 * @brief date:2019 2019. 2. 9. user:atres
	 * @return the c152StdTxDdcYn get
	 */
	public java.lang.String getC152StdTxDdcYn() {
		return c152StdTxDdcYn;
	}

	/**
	 * Comment : 
	 *@fn void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn)
	 *@brief date:2019 2019. 2. 9. user:atres
	 *@param c152StdTxDdcYn the c152StdTxDdcYn to set
	 */
	public void setC152StdTxDdcYn(java.lang.String c152StdTxDdcYn) {
		this.c152StdTxDdcYn = c152StdTxDdcYn;
	}
	
	
	
	

}