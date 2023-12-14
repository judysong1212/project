package com.app.exterms.insurance.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Insr4100VO.java
 * @Description : Insr4100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr4100VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
  	private String  dpobCd;

  	/** set SYSTEMKEY : systemkey */
  	private String  systemkey;

  	/** set 국민연금일련번호 : natPennSeilNum */
  	//private BigDecimal  natPennSeilNum;

  	/** set 고용일련번호 : emymtSeilNum */
  	private Long  emymtSeilNum;

  	/** set 국민연금취득일자 : natPennAqtnDt */
  	private String  natPennAqtnDt;

  	/** set 국민연금상실일자 : natPennLssDt */
  	private String  natPennLssDt;

  	/** set 입력자 : kybdr */
  	private String  kybdr;

  	/** set 입력일자 : inptDt */
  	private String  inptDt;

  	/** set 입력주소 : inptAddr */
  	private String  inptAddr;

  	/** set 수정자 : ismt */
  	private String  ismt;

  	/** set 수정일자 : revnDt */
  	private String  revnDt;

  	/** set 수정주소 : revnAddr */
  	private String  revnAddr;
  	

      /** set 고용구분코드 : emymtDivCd */
      private String  emymtDivCd;

      /** set 부서코드 : deptCd */
      private String  deptCd;

      /** set 사업코드 : businCd */
      private String  businCd;

      /** set 직종코드 : typOccuCd */
      private String  typOccuCd;

      /** set 직종세구분코드 : dtilOccuClsDivCd */
      private String  dtilOccuClsDivCd;

      /** set 호봉등급코드 : pyspGrdeCd */
      private String  pyspGrdeCd;
   

      /** set 단위기관코드 : payrMangDeptCd */
      private String  payrMangDeptCd;
      

      /** set 단위기관 : payrMangDeptNm */
      private String  payrMangDeptNm;
      
      /** set 고용구분 : emymtDivNm */
      private String  emymtDivNm;

      /** set 부서 : deptNm */
      private String  deptNm;

      /** set 사업명 : businNm */
      private String  businNm;
      
      /** set 직종명 : typOccuNm */
      private String  typOccuNm;
      
      /** set 직종세 : dtilOccuClsDivNm */
      private String  dtilOccuClsDivNm;
      
      /** set 직책코드 : odtyNm */
      private String  odtyNm;

   
      /** set 호봉등급코드 : pyspGrdeNm */
      private String  pyspGrdeNm;
      

      /** set 한글성명 : hanNm */
      private String  hanNm;

      /** set 주민등록번호 : resnRegnNum */
      private String  resnRegnNum;
      
      

  /** set 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
  private Long  natPennStdIncmMnthAmnt;

  /** set 국민연금등급 : natPennGrde */
  private String  natPennGrde;


  /** set 국민연금보험료 : natPennMnthAmnt */
  private Long  natPennMnthAmnt;

  /** set 국민연금등급보험료  : natPennGrdeAmnt */
  private Long  natPennGrdeAmnt;



  /** set 국민연금적용여부 : natPennApptnYn */
  private String  natPennApptnYn;


  /** set 국민연금변동일자 : natPennInsurFlucDt */
  private String  natPennInsurFlucDt;
       
  /** set 연금보험료 : PYMT_DDUC_D0150100 */
  private Long  pymtDducD0150100;
      

  /** set 정산보험료 : PYMT_DDUC_D0150200 */
  private Long  pymtDducD0150200;
      

  /** set 소급보험료 : PYMT_DDUC_D0150300 */
  private Long  pymtDducD0150300;
      

  /** set 합계 : PYMT_DDUC_SUM */
  private Long  pymtDducSum;
      

  /** set 연금총근무일수 : antyTotDutyNumDys */
  private Long  antyTotDutyNumDys;

  /** set 연금소득총액 : antyIncmTotAmnt */
  private Long  antyIncmTotAmnt;

  public String getDpobCd() {
  	return dpobCd;
  }

  public void setDpobCd(String dpobCd) {
  	this.dpobCd = dpobCd;
  }

  public String getSystemkey() {
  	return systemkey;
  }

  public void setSystemkey(String systemkey) {
  	this.systemkey = systemkey;
  }

//  public Long getNatPennSeilNum() {
//  	return natPennSeilNum;
//  }
//
//  public void setNatPennSeilNum(Long natPennSeilNum) {
//  	this.natPennSeilNum = natPennSeilNum;
//  }

  public Long getEmymtSeilNum() {
  	return emymtSeilNum;
  }

  public void setEmymtSeilNum(Long emymtSeilNum) {
  	this.emymtSeilNum = emymtSeilNum;
  }

  public String getNatPennAqtnDt() {
  	return natPennAqtnDt;
  }

  public void setNatPennAqtnDt(String natPennAqtnDt) {
  	this.natPennAqtnDt = natPennAqtnDt;
  }

  public String getNatPennLssDt() {
  	return natPennLssDt;
  }

  public void setNatPennLssDt(String natPennLssDt) {
  	this.natPennLssDt = natPennLssDt;
  }

  public String getKybdr() {
  	return kybdr;
  }

  public void setKybdr(String kybdr) {
  	this.kybdr = kybdr;
  }

  public String getInptDt() {
  	return inptDt;
  }

  public void setInptDt(String inptDt) {
  	this.inptDt = inptDt;
  }

  public String getInptAddr() {
  	return inptAddr;
  }

  public void setInptAddr(String inptAddr) {
  	this.inptAddr = inptAddr;
  }

  public String getIsmt() {
  	return ismt;
  }

  public void setIsmt(String ismt) {
  	this.ismt = ismt;
  }

  public String getRevnDt() {
  	return revnDt;
  }

  public void setRevnDt(String revnDt) {
  	this.revnDt = revnDt;
  }

  public String getRevnAddr() {
  	return revnAddr;
  }

  public void setRevnAddr(String revnAddr) {
  	this.revnAddr = revnAddr;
  }

  public String getEmymtDivCd() {
  	return emymtDivCd;
  }

  public void setEmymtDivCd(String emymtDivCd) {
  	this.emymtDivCd = emymtDivCd;
  }

  public String getDeptCd() {
  	return deptCd;
  }

  public void setDeptCd(String deptCd) {
  	this.deptCd = deptCd;
  }

  public String getBusinCd() {
  	return businCd;
  }

  public void setBusinCd(String businCd) {
  	this.businCd = businCd;
  }

  public String getTypOccuCd() {
  	return typOccuCd;
  }

  public void setTypOccuCd(String typOccuCd) {
  	this.typOccuCd = typOccuCd;
  }

  public String getDtilOccuClsDivCd() {
  	return dtilOccuClsDivCd;
  }

  public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) {
  	this.dtilOccuClsDivCd = dtilOccuClsDivCd;
  }

  public String getPyspGrdeCd() {
  	return pyspGrdeCd;
  }

  public void setPyspGrdeCd(String pyspGrdeCd) {
  	this.pyspGrdeCd = pyspGrdeCd;
  }

  public String getPayrMangDeptCd() {
  	return payrMangDeptCd;
  }

  public void setPayrMangDeptCd(String payrMangDeptCd) {
  	this.payrMangDeptCd = payrMangDeptCd;
  }

  public String getPayrMangDeptNm() {
  	return payrMangDeptNm;
  }

  public void setPayrMangDeptNm(String payrMangDeptNm) {
  	this.payrMangDeptNm = payrMangDeptNm;
  }

  public String getEmymtDivNm() {
  	return emymtDivNm;
  }

  public void setEmymtDivNm(String emymtDivNm) {
  	this.emymtDivNm = emymtDivNm;
  }

  public String getDeptNm() {
  	return deptNm;
  }

  public void setDeptNm(String deptNm) {
  	this.deptNm = deptNm;
  }

  public String getBusinNm() {
  	return businNm;
  }

  public void setBusinNm(String businNm) {
  	this.businNm = businNm;
  }

  public String getTypOccuNm() {
  	return typOccuNm;
  }

  public void setTypOccuNm(String typOccuNm) {
  	this.typOccuNm = typOccuNm;
  }

  public String getDtilOccuClsDivNm() {
  	return dtilOccuClsDivNm;
  }

  public void setDtilOccuClsDivNm(String dtilOccuClsDivNm) {
  	this.dtilOccuClsDivNm = dtilOccuClsDivNm;
  }

  public String getOdtyNm() {
  	return odtyNm;
  }

  public void setOdtyNm(String odtyNm) {
  	this.odtyNm = odtyNm;
  }

  public String getPyspGrdeNm() {
  	return pyspGrdeNm;
  }

  public void setPyspGrdeNm(String pyspGrdeNm) {
  	this.pyspGrdeNm = pyspGrdeNm;
  }

  public String getHanNm() {
  	return hanNm;
  }

  public void setHanNm(String hanNm) {
  	this.hanNm = hanNm;
  }

  public String getResnRegnNum() {
  	return resnRegnNum;
  }

  public void setResnRegnNum(String resnRegnNum) {
  	this.resnRegnNum = resnRegnNum;
  }

  public Long getNatPennStdIncmMnthAmnt() {
  	return natPennStdIncmMnthAmnt;
  }

  public void setNatPennStdIncmMnthAmnt(Long natPennStdIncmMnthAmnt) {
  	this.natPennStdIncmMnthAmnt = natPennStdIncmMnthAmnt;
  }

  public String getNatPennGrde() {
  	return natPennGrde;
  }

  public void setNatPennGrde(String natPennGrde) {
  	this.natPennGrde = natPennGrde;
  }

  public Long getNatPennMnthAmnt() {
  	return natPennMnthAmnt;
  }

  public void setNatPennMnthAmnt(Long natPennMnthAmnt) {
  	this.natPennMnthAmnt = natPennMnthAmnt;
  }

  public Long getNatPennGrdeAmnt() {
  	return natPennGrdeAmnt;
  }

  public void setNatPennGrdeAmnt(Long natPennGrdeAmnt) {
  	this.natPennGrdeAmnt = natPennGrdeAmnt;
  }

  public String getNatPennApptnYn() {
  	return natPennApptnYn;
  }

  public void setNatPennApptnYn(String natPennApptnYn) {
  	this.natPennApptnYn = natPennApptnYn;
  }

  public String getNatPennInsurFlucDt() {
  	return natPennInsurFlucDt;
  }

  public void setNatPennInsurFlucDt(String natPennInsurFlucDt) {
  	this.natPennInsurFlucDt = natPennInsurFlucDt;
  }

  public Long getPymtDducD0150100() {
  	return pymtDducD0150100;
  }

  public void setPymtDducD0150100(Long pymtDducD0150100) {
  	this.pymtDducD0150100 = pymtDducD0150100;
  }

  public Long getPymtDducD0150200() {
  	return pymtDducD0150200;
  }

  public void setPymtDducD0150200(Long pymtDducD0150200) {
  	this.pymtDducD0150200 = pymtDducD0150200;
  }

  public Long getPymtDducD0150300() {
  	return pymtDducD0150300;
  }

  public void setPymtDducD0150300(Long pymtDducD0150300) {
  	this.pymtDducD0150300 = pymtDducD0150300;
  }

  public Long getPymtDducSum() {
  	return pymtDducSum;
  }

  public void setPymtDducSum(Long pymtDducSum) {
  	this.pymtDducSum = pymtDducSum;
  }

  public Long getAntyTotDutyNumDys() {
  	return antyTotDutyNumDys;
  }

  public void setAntyTotDutyNumDys(Long antyTotDutyNumDys) {
  	this.antyTotDutyNumDys = antyTotDutyNumDys;
  }

  public Long getAntyIncmTotAmnt() {
  	return antyIncmTotAmnt;
  }

  public void setAntyIncmTotAmnt(Long antyIncmTotAmnt) {
  	this.antyIncmTotAmnt = antyIncmTotAmnt;
  }


    
}
