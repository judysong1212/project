package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr1200VO.java
 * @Description : Insr1200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1200DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사회보험작성일자 : soctyInsurCmptnDt */
    private java.lang.String soctyInsurCmptnDt;

    /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
    private Long socInsrAqtnEmymtNum;
    
    /** set 건강보험신고여부 : hlthInsrRegrstYn */
    private Boolean hlthInsrRegrstYn;

    /** set 국민연금신고여부 : natPennRegrstYn */
    private Boolean natPennRegrstYn;

    /** set 고용보험신고여부 : umytInsrRegrstYn */
    private Boolean umytInsrRegrstYn;

    /** set 산재보험신고여부 : idtlAccdtRegrstYn */
    private Boolean idtlAccdtRegrstYn;
    
    private java.lang.String socnsrAqtnRegVal01;    /** column 공단구분 : socnsrAqtnRegVal01 */
 
    private java.lang.String socnsrAqtnRegVal02;    /** column 성명 : socnsrAqtnRegVal02 */
    private java.lang.String socnsrAqtnRegVal03;    /** column 주민등록번호 : socnsrAqtnRegVal03 */
    private java.lang.String socnsrAqtnRegVal04;    /** column 국적 : socnsrAqtnRegVal04 */
    private java.lang.String socnsrAqtnRegVal04Nm; /** column 국적 : socnsrAqtnRegVal04Nm */
    private java.lang.String socnsrAqtnRegVal05;    /** column 체류자격 : socnsrAqtnRegVal05 */
    private Boolean socnsrAqtnRegVal06;    /** column 대표자여부 : socnsrAqtnRegVal06 */
    private Long socnsrAqtnRegVal07;    /** column 연금_소득월액 : socnsrAqtnRegVal07 */
    private Boolean socnsrAqtnRegVal08;    /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */
    private java.lang.String socnsrAqtnRegVal09;    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
    private java.lang.String socnsrAqtnRegVal10;    /** column 연금_자격취득일 : socnsrAqtnRegVal10 */
    private java.lang.String socnsrAqtnRegVal11;    /** column 연금_특수직종 : socnsrAqtnRegVal11 */
    private java.lang.String socnsrAqtnRegVal12;    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
    private java.lang.String socnsrAqtnRegVal13;    /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
    private java.lang.String socnsrAqtnRegVal14;    /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
    private Long socnsrAqtnRegVal15;    /** column 건강_보수월액 : socnsrAqtnRegVal15 */
    private java.lang.String socnsrAqtnRegVal16;    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
    private java.lang.String socnsrAqtnRegVal17;    /** column 건강_자격취득일 : socnsrAqtnRegVal17 */
    private java.lang.String socnsrAqtnRegVal18;    /** column 건강_감면 : socnsrAqtnRegVal18 */
    private Boolean socnsrAqtnRegVal19;    /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */
    private java.lang.String socnsrAqtnRegVal20;    /** column 건강_회계 : socnsrAqtnRegVal20 */
    private java.lang.String socnsrAqtnRegVal21;    /** column 건강_직종 : socnsrAqtnRegVal21 */
    private java.lang.String socnsrAqtnRegVal22;    /** column 고용_자격취득일 : socnsrAqtnRegVal22 */
    private java.lang.String socnsrAqtnRegVal23;    /** column 고용_직종 : socnsrAqtnRegVal23 */
    private java.lang.String socnsrAqtnRegVal23Nm; /** column 고용_직종 : socnsrAqtnRegVal23Nm */
    private Double socnsrAqtnRegVal24;    /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */
    private Boolean socnsrAqtnRegVal25;    /** column 고용_계약직여부 : socnsrAqtnRegVal25 */
    private java.lang.String socnsrAqtnRegVal26;    /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */
    private Long socnsrAqtnRegVal27;    /** column 고용_월평균보수 : socnsrAqtnRegVal27 */
    private java.lang.String socnsrAqtnRegVal28;    /** column 고용_비고 : socnsrAqtnRegVal28 */
    private java.lang.String socnsrAqtnRegVal29;    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
    private java.lang.String socnsrAqtnRegVal30;    /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
    private java.lang.String socnsrAqtnRegVal31;    /** column 산재_자격취득일 : socnsrAqtnRegVal31 */
    private java.lang.String socnsrAqtnRegVal32;    /** column 산재_직종 : socnsrAqtnRegVal32 */
    private java.lang.String socnsrAqtnRegVal32Nm; /** column 산재_직종 : socnsrAqtnRegVal32Nm */
    private Double socnsrAqtnRegVal33;    /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */
    private Boolean socnsrAqtnRegVal34;    /** column 산재_계약직여부 : socnsrAqtnRegVal34 */
    private java.lang.String socnsrAqtnRegVal35;    /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */
    private Long socnsrAqtnRegVal36;    /** column 산재_월평균보수 : socnsrAqtnRegVal36 */
    private java.lang.String socnsrAqtnRegVal37;    /** column 산재_비고 : socnsrAqtnRegVal37 */
    private java.lang.String socnsrAqtnRegVal38;    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
    private java.lang.String socnsrAqtnRegVal39;    /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
    private java.lang.String socnsrAqtnRegVal40;    /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
    private java.lang.String socnsrAqtnRegVal41;    /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
    private java.lang.String socnsrAqtnRegVal42;    /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
    private java.lang.String socnsrAqtnRegVal43;    /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
    private java.lang.String socnsrAqtnRegVal44;    /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
    private java.lang.String socnsrAqtnRegVal45;    /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
    private java.lang.String socnsrAqtnRegVal46;    /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
    private java.lang.String socnsrAqtnRegVal47;    /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
    private java.lang.String socnsrAqtnRegVal48;    /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
    private java.lang.String socnsrAqtnRegVal49;    /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
    private java.lang.String socnsrAqtnRegVal50;    /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
    private java.lang.String socnsrAqtnRegVal51;    /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
    private java.lang.String socnsrAqtnRegVal52;    /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
    private java.lang.String socnsrAqtnRegVal53;    /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
    private java.lang.String socnsrAqtnRegVal54;    /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
    private java.lang.String socnsrAqtnRegVal55;    /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
    private java.lang.String socnsrAqtnRegVal56;    /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
    private java.lang.String socnsrAqtnRegVal57;    /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
    private java.lang.String socnsrAqtnRegVal58;    /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
    private java.lang.String socnsrAqtnRegVal59;    /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
    private java.lang.String socnsrAqtnRegVal60;    /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
    private java.lang.String socnsrAqtnRegVal61;    /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
    private java.lang.String socnsrAqtnRegVal62;    /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
    private java.lang.String socnsrAqtnRegVal63;    /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
    private java.lang.String socnsrAqtnRegVal64;    /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
    private java.lang.String socnsrAqtnRegVal65;    /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
    private java.lang.String socnsrAqtnRegVal66;    /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
    private java.lang.String socnsrAqtnRegVal67;    /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
    private java.lang.String socnsrAqtnRegVal68;    /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
    private java.lang.String socnsrAqtnRegVal69;    /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
    private java.lang.String socnsrAqtnRegVal70;    /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
    private java.lang.String socnsrAqtnRegVal71;    /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
    private java.lang.String socnsrAqtnRegVal72;    /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
    private java.lang.String socnsrAqtnRegVal73;    /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
    private java.lang.String socnsrAqtnRegVal74;    /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
    private java.lang.String socnsrAqtnRegVal75;    /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
    private java.lang.String socnsrAqtnRegVal76;    /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
    private java.lang.String socnsrAqtnRegVal77;    /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
    private java.lang.String socnsrAqtnRegVal78;    /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
    private java.lang.String socnsrAqtnRegVal79;    /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
    private java.lang.String socnsrAqtnRegVal80;    /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */ 

    /** set 입력자 : kybdr */
    private java.lang.String kybdr;

    /** set 입력일자 : inptDt */
    private java.lang.String inptDt;

    /** set 수정자 : ismt */
    private java.lang.String ismt;

    /** set 입력주소 : inptAddr */
    private java.lang.String inptAddr;

    /** set 수정일자 : revnDt */
    private java.lang.String revnDt;

    /** set 수정주소 : revnAddr */
    private java.lang.String revnAddr;
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 고용구분 : emymtDivNm */
    private java.lang.String emymtDivNm;
 
    /** set 부서코드 : deptNm */
    private java.lang.String deptNm;
 

    /** set 직종 : typOccuNm */
    private java.lang.String typOccuNm;
 
    /** set 호봉등급 : pyspGrdeNm */
    private java.lang.String pyspGrdeNm;

    
    /** set 직종세구분 : dtilOccuClsDivNm */
    private java.lang.String dtilOccuClsDivNm;
 
    /** set 사업 : businNm */
    private java.lang.String businNm;
    
    /** set 일괄적용 구분자 :  */
    private java.lang.String batchDiv;
    
    
    /** set 건강보험사업장명 : insrDpobNm */
	private java.lang.String insrDpobNm;
	
	/** set 건강보험사업장관리번호 : insrDpobNum */
	private java.lang.String insrDpobNum;
	
	/** set 건강보험사업장전화번호 : insrDpobPhnNum */
	private java.lang.String insrDpobPhnNum;
	
	/** set 건강보험가입자전화번호 : insrUsePhnNum */
	private java.lang.String insrUsePhnNum;
    
     
	public java.lang.String getInsrDpobNm() {
		return insrDpobNm;
	}

	public void setInsrDpobNm(java.lang.String insrDpobNm) {
		this.insrDpobNm = insrDpobNm;
	}

	public java.lang.String getInsrDpobNum() {
		return insrDpobNum;
	}

	public void setInsrDpobNum(java.lang.String insrDpobNum) {
		this.insrDpobNum = insrDpobNum;
	}

	public java.lang.String getInsrDpobPhnNum() {
		return insrDpobPhnNum;
	}

	public void setInsrDpobPhnNum(java.lang.String insrDpobPhnNum) {
		this.insrDpobPhnNum = insrDpobPhnNum;
	}

	public java.lang.String getInsrUsePhnNum() {
		return insrUsePhnNum;
	}

	public void setInsrUsePhnNum(java.lang.String insrUsePhnNum) {
		this.insrUsePhnNum = insrUsePhnNum;
	}

	public java.lang.String getBatchDiv() {
		return batchDiv;
	}

	public void setBatchDiv(java.lang.String batchDiv) {
		this.batchDiv = batchDiv;
	}

	/**
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 4, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 4, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
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

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
		this.pyspGrdeCd = pyspGrdeCd;
	}

	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getEmymtDivNm() {
		return emymtDivNm;
	}

	public void setEmymtDivNm(java.lang.String emymtDivNm) {
		this.emymtDivNm = emymtDivNm;
	}

	public java.lang.String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(java.lang.String deptNm) {
		this.deptNm = deptNm;
	}

	public java.lang.String getTypOccuNm() {
		return typOccuNm;
	}

	public void setTypOccuNm(java.lang.String typOccuNm) {
		this.typOccuNm = typOccuNm;
	}

	public java.lang.String getPyspGrdeNm() {
		return pyspGrdeNm;
	}

	public void setPyspGrdeNm(java.lang.String pyspGrdeNm) {
		this.pyspGrdeNm = pyspGrdeNm;
	}

	public java.lang.String getDtilOccuClsDivNm() {
		return dtilOccuClsDivNm;
	}

	public void setDtilOccuClsDivNm(java.lang.String dtilOccuClsDivNm) {
		this.dtilOccuClsDivNm = dtilOccuClsDivNm;
	}

	public java.lang.String getBusinNm() {
		return businNm;
	}

	public void setBusinNm(java.lang.String businNm) {
		this.businNm = businNm;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getSoctyInsurCmptnDt() {
		return soctyInsurCmptnDt;
	}

	public void setSoctyInsurCmptnDt(java.lang.String soctyInsurCmptnDt) {
		this.soctyInsurCmptnDt = soctyInsurCmptnDt;
	}

	public Long getSocInsrAqtnEmymtNum() {
		return socInsrAqtnEmymtNum;
	}

	public void setSocInsrAqtnEmymtNum(Long socInsrAqtnEmymtNum) {
		this.socInsrAqtnEmymtNum = socInsrAqtnEmymtNum;
	}

	public Boolean getHlthInsrRegrstYn() {
		return hlthInsrRegrstYn;
	}

	public void setHlthInsrRegrstYn(Boolean hlthInsrRegrstYn) {
		this.hlthInsrRegrstYn = hlthInsrRegrstYn;
	}

	public Boolean getNatPennRegrstYn() {
		return natPennRegrstYn;
	}

	public void setNatPennRegrstYn(Boolean natPennRegrstYn) {
		this.natPennRegrstYn = natPennRegrstYn;
	}

	public Boolean getUmytInsrRegrstYn() {
		return umytInsrRegrstYn;
	}

	public void setUmytInsrRegrstYn(Boolean umytInsrRegrstYn) {
		this.umytInsrRegrstYn = umytInsrRegrstYn;
	}

	public Boolean getIdtlAccdtRegrstYn() {
		return idtlAccdtRegrstYn;
	}

	public void setIdtlAccdtRegrstYn(Boolean idtlAccdtRegrstYn) {
		this.idtlAccdtRegrstYn = idtlAccdtRegrstYn;
	}

	public java.lang.String getSocnsrAqtnRegVal01() {
		return socnsrAqtnRegVal01;
	}

	public void setSocnsrAqtnRegVal01(java.lang.String socnsrAqtnRegVal01) {
		this.socnsrAqtnRegVal01 = socnsrAqtnRegVal01;
	}

	public java.lang.String getSocnsrAqtnRegVal02() {
		return socnsrAqtnRegVal02;
	}

	public void setSocnsrAqtnRegVal02(java.lang.String socnsrAqtnRegVal02) {
		this.socnsrAqtnRegVal02 = socnsrAqtnRegVal02;
	}

	public java.lang.String getSocnsrAqtnRegVal03() {
		return socnsrAqtnRegVal03;
	}

	public void setSocnsrAqtnRegVal03(java.lang.String socnsrAqtnRegVal03) {
		this.socnsrAqtnRegVal03 = socnsrAqtnRegVal03;
	}

	public java.lang.String getSocnsrAqtnRegVal04() {
		return socnsrAqtnRegVal04;
	}

	public void setSocnsrAqtnRegVal04(java.lang.String socnsrAqtnRegVal04) {
		this.socnsrAqtnRegVal04 = socnsrAqtnRegVal04;
	}

	public java.lang.String getSocnsrAqtnRegVal05() {
		return socnsrAqtnRegVal05;
	}

	public void setSocnsrAqtnRegVal05(java.lang.String socnsrAqtnRegVal05) {
		this.socnsrAqtnRegVal05 = socnsrAqtnRegVal05;
	}

	public Boolean getSocnsrAqtnRegVal06() {
		return socnsrAqtnRegVal06;
	}

	public void setSocnsrAqtnRegVal06(Boolean socnsrAqtnRegVal06) {
		this.socnsrAqtnRegVal06 = socnsrAqtnRegVal06;
	}

	public Long getSocnsrAqtnRegVal07() {
		return socnsrAqtnRegVal07;
	}

	public void setSocnsrAqtnRegVal07(Long socnsrAqtnRegVal07) {
		this.socnsrAqtnRegVal07 = socnsrAqtnRegVal07;
	}

	public Boolean getSocnsrAqtnRegVal08() {
		return socnsrAqtnRegVal08;
	}

	public void setSocnsrAqtnRegVal08(Boolean socnsrAqtnRegVal08) {
		this.socnsrAqtnRegVal08 = socnsrAqtnRegVal08;
	}

	public java.lang.String getSocnsrAqtnRegVal09() {
		return socnsrAqtnRegVal09;
	}

	public void setSocnsrAqtnRegVal09(java.lang.String socnsrAqtnRegVal09) {
		this.socnsrAqtnRegVal09 = socnsrAqtnRegVal09;
	}

	public java.lang.String getSocnsrAqtnRegVal10() {
		return socnsrAqtnRegVal10;
	}

	public void setSocnsrAqtnRegVal10(java.lang.String socnsrAqtnRegVal10) {
		this.socnsrAqtnRegVal10 = socnsrAqtnRegVal10;
	}

	public java.lang.String getSocnsrAqtnRegVal11() {
		return socnsrAqtnRegVal11;
	}

	public void setSocnsrAqtnRegVal11(java.lang.String socnsrAqtnRegVal11) {
		this.socnsrAqtnRegVal11 = socnsrAqtnRegVal11;
	}

	public java.lang.String getSocnsrAqtnRegVal12() {
		return socnsrAqtnRegVal12;
	}

	public void setSocnsrAqtnRegVal12(java.lang.String socnsrAqtnRegVal12) {
		this.socnsrAqtnRegVal12 = socnsrAqtnRegVal12;
	}

	public java.lang.String getSocnsrAqtnRegVal13() {
		return socnsrAqtnRegVal13;
	}

	public void setSocnsrAqtnRegVal13(java.lang.String socnsrAqtnRegVal13) {
		this.socnsrAqtnRegVal13 = socnsrAqtnRegVal13;
	}

	public java.lang.String getSocnsrAqtnRegVal14() {
		return socnsrAqtnRegVal14;
	}

	public void setSocnsrAqtnRegVal14(java.lang.String socnsrAqtnRegVal14) {
		this.socnsrAqtnRegVal14 = socnsrAqtnRegVal14;
	}

	public Long getSocnsrAqtnRegVal15() {
		return socnsrAqtnRegVal15;
	}

	public void setSocnsrAqtnRegVal15(Long socnsrAqtnRegVal15) {
		this.socnsrAqtnRegVal15 = socnsrAqtnRegVal15;
	}

	public java.lang.String getSocnsrAqtnRegVal16() {
		return socnsrAqtnRegVal16;
	}

	public void setSocnsrAqtnRegVal16(java.lang.String socnsrAqtnRegVal16) {
		this.socnsrAqtnRegVal16 = socnsrAqtnRegVal16;
	}

	public java.lang.String getSocnsrAqtnRegVal17() {
		return socnsrAqtnRegVal17;
	}

	public void setSocnsrAqtnRegVal17(java.lang.String socnsrAqtnRegVal17) {
		this.socnsrAqtnRegVal17 = socnsrAqtnRegVal17;
	}

	public java.lang.String getSocnsrAqtnRegVal18() {
		return socnsrAqtnRegVal18;
	}

	public void setSocnsrAqtnRegVal18(java.lang.String socnsrAqtnRegVal18) {
		this.socnsrAqtnRegVal18 = socnsrAqtnRegVal18;
	}

	public Boolean getSocnsrAqtnRegVal19() {
		return socnsrAqtnRegVal19;
	}

	public void setSocnsrAqtnRegVal19(Boolean socnsrAqtnRegVal19) {
		this.socnsrAqtnRegVal19 = socnsrAqtnRegVal19;
	}

	public java.lang.String getSocnsrAqtnRegVal20() {
		return socnsrAqtnRegVal20;
	}

	public void setSocnsrAqtnRegVal20(java.lang.String socnsrAqtnRegVal20) {
		this.socnsrAqtnRegVal20 = socnsrAqtnRegVal20;
	}

	public java.lang.String getSocnsrAqtnRegVal21() {
		return socnsrAqtnRegVal21;
	}

	public void setSocnsrAqtnRegVal21(java.lang.String socnsrAqtnRegVal21) {
		this.socnsrAqtnRegVal21 = socnsrAqtnRegVal21;
	}

	public java.lang.String getSocnsrAqtnRegVal22() {
		return socnsrAqtnRegVal22;
	}

	public void setSocnsrAqtnRegVal22(java.lang.String socnsrAqtnRegVal22) {
		this.socnsrAqtnRegVal22 = socnsrAqtnRegVal22;
	}

	public java.lang.String getSocnsrAqtnRegVal23() {
		return socnsrAqtnRegVal23;
	}

	public void setSocnsrAqtnRegVal23(java.lang.String socnsrAqtnRegVal23) {
		this.socnsrAqtnRegVal23 = socnsrAqtnRegVal23;
	}

	public Double getSocnsrAqtnRegVal24() {
		return socnsrAqtnRegVal24;
	}

	public void setSocnsrAqtnRegVal24(Double socnsrAqtnRegVal24) {
		this.socnsrAqtnRegVal24 = socnsrAqtnRegVal24;
	}

	public Boolean getSocnsrAqtnRegVal25() {
		return socnsrAqtnRegVal25;
	}

	public void setSocnsrAqtnRegVal25(Boolean socnsrAqtnRegVal25) {
		this.socnsrAqtnRegVal25 = socnsrAqtnRegVal25;
	}

	public java.lang.String getSocnsrAqtnRegVal26() {
		return socnsrAqtnRegVal26;
	}

	public void setSocnsrAqtnRegVal26(java.lang.String socnsrAqtnRegVal26) {
		this.socnsrAqtnRegVal26 = socnsrAqtnRegVal26;
	}

	public Long getSocnsrAqtnRegVal27() {
		return socnsrAqtnRegVal27;
	}

	public void setSocnsrAqtnRegVal27(Long socnsrAqtnRegVal27) {
		this.socnsrAqtnRegVal27 = socnsrAqtnRegVal27;
	}

	public java.lang.String getSocnsrAqtnRegVal28() {
		return socnsrAqtnRegVal28;
	}

	public void setSocnsrAqtnRegVal28(java.lang.String socnsrAqtnRegVal28) {
		this.socnsrAqtnRegVal28 = socnsrAqtnRegVal28;
	}

	public java.lang.String getSocnsrAqtnRegVal29() {
		return socnsrAqtnRegVal29;
	}

	public void setSocnsrAqtnRegVal29(java.lang.String socnsrAqtnRegVal29) {
		this.socnsrAqtnRegVal29 = socnsrAqtnRegVal29;
	}

	public java.lang.String getSocnsrAqtnRegVal30() {
		return socnsrAqtnRegVal30;
	}

	public void setSocnsrAqtnRegVal30(java.lang.String socnsrAqtnRegVal30) {
		this.socnsrAqtnRegVal30 = socnsrAqtnRegVal30;
	}

	public java.lang.String getSocnsrAqtnRegVal31() {
		return socnsrAqtnRegVal31;
	}

	public void setSocnsrAqtnRegVal31(java.lang.String socnsrAqtnRegVal31) {
		this.socnsrAqtnRegVal31 = socnsrAqtnRegVal31;
	}

	public java.lang.String getSocnsrAqtnRegVal32() {
		return socnsrAqtnRegVal32;
	}

	public void setSocnsrAqtnRegVal32(java.lang.String socnsrAqtnRegVal32) {
		this.socnsrAqtnRegVal32 = socnsrAqtnRegVal32;
	}

	public Double getSocnsrAqtnRegVal33() {
		return socnsrAqtnRegVal33;
	}

	public void setSocnsrAqtnRegVal33(Double socnsrAqtnRegVal33) {
		this.socnsrAqtnRegVal33 = socnsrAqtnRegVal33;
	}

	public Boolean getSocnsrAqtnRegVal34() {
		return socnsrAqtnRegVal34;
	}

	public void setSocnsrAqtnRegVal34(Boolean socnsrAqtnRegVal34) {
		this.socnsrAqtnRegVal34 = socnsrAqtnRegVal34;
	}

	public java.lang.String getSocnsrAqtnRegVal35() {
		return socnsrAqtnRegVal35;
	}

	public void setSocnsrAqtnRegVal35(java.lang.String socnsrAqtnRegVal35) {
		this.socnsrAqtnRegVal35 = socnsrAqtnRegVal35;
	}

	public Long getSocnsrAqtnRegVal36() {
		return socnsrAqtnRegVal36;
	}

	public void setSocnsrAqtnRegVal36(Long socnsrAqtnRegVal36) {
		this.socnsrAqtnRegVal36 = socnsrAqtnRegVal36;
	}

	public java.lang.String getSocnsrAqtnRegVal37() {
		return socnsrAqtnRegVal37;
	}

	public void setSocnsrAqtnRegVal37(java.lang.String socnsrAqtnRegVal37) {
		this.socnsrAqtnRegVal37 = socnsrAqtnRegVal37;
	}

	public java.lang.String getSocnsrAqtnRegVal38() {
		return socnsrAqtnRegVal38;
	}

	public void setSocnsrAqtnRegVal38(java.lang.String socnsrAqtnRegVal38) {
		this.socnsrAqtnRegVal38 = socnsrAqtnRegVal38;
	}

	public java.lang.String getSocnsrAqtnRegVal39() {
		return socnsrAqtnRegVal39;
	}

	public void setSocnsrAqtnRegVal39(java.lang.String socnsrAqtnRegVal39) {
		this.socnsrAqtnRegVal39 = socnsrAqtnRegVal39;
	}

	public java.lang.String getSocnsrAqtnRegVal40() {
		return socnsrAqtnRegVal40;
	}

	public void setSocnsrAqtnRegVal40(java.lang.String socnsrAqtnRegVal40) {
		this.socnsrAqtnRegVal40 = socnsrAqtnRegVal40;
	}

	public java.lang.String getSocnsrAqtnRegVal41() {
		return socnsrAqtnRegVal41;
	}

	public void setSocnsrAqtnRegVal41(java.lang.String socnsrAqtnRegVal41) {
		this.socnsrAqtnRegVal41 = socnsrAqtnRegVal41;
	}

	public java.lang.String getSocnsrAqtnRegVal42() {
		return socnsrAqtnRegVal42;
	}

	public void setSocnsrAqtnRegVal42(java.lang.String socnsrAqtnRegVal42) {
		this.socnsrAqtnRegVal42 = socnsrAqtnRegVal42;
	}

	public java.lang.String getSocnsrAqtnRegVal43() {
		return socnsrAqtnRegVal43;
	}

	public void setSocnsrAqtnRegVal43(java.lang.String socnsrAqtnRegVal43) {
		this.socnsrAqtnRegVal43 = socnsrAqtnRegVal43;
	}

	public java.lang.String getSocnsrAqtnRegVal44() {
		return socnsrAqtnRegVal44;
	}

	public void setSocnsrAqtnRegVal44(java.lang.String socnsrAqtnRegVal44) {
		this.socnsrAqtnRegVal44 = socnsrAqtnRegVal44;
	}

	public java.lang.String getSocnsrAqtnRegVal45() {
		return socnsrAqtnRegVal45;
	}

	public void setSocnsrAqtnRegVal45(java.lang.String socnsrAqtnRegVal45) {
		this.socnsrAqtnRegVal45 = socnsrAqtnRegVal45;
	}

	public java.lang.String getSocnsrAqtnRegVal46() {
		return socnsrAqtnRegVal46;
	}

	public void setSocnsrAqtnRegVal46(java.lang.String socnsrAqtnRegVal46) {
		this.socnsrAqtnRegVal46 = socnsrAqtnRegVal46;
	}

	public java.lang.String getSocnsrAqtnRegVal47() {
		return socnsrAqtnRegVal47;
	}

	public void setSocnsrAqtnRegVal47(java.lang.String socnsrAqtnRegVal47) {
		this.socnsrAqtnRegVal47 = socnsrAqtnRegVal47;
	}

	public java.lang.String getSocnsrAqtnRegVal48() {
		return socnsrAqtnRegVal48;
	}

	public void setSocnsrAqtnRegVal48(java.lang.String socnsrAqtnRegVal48) {
		this.socnsrAqtnRegVal48 = socnsrAqtnRegVal48;
	}

	public java.lang.String getSocnsrAqtnRegVal49() {
		return socnsrAqtnRegVal49;
	}

	public void setSocnsrAqtnRegVal49(java.lang.String socnsrAqtnRegVal49) {
		this.socnsrAqtnRegVal49 = socnsrAqtnRegVal49;
	}

	public java.lang.String getSocnsrAqtnRegVal50() {
		return socnsrAqtnRegVal50;
	}

	public void setSocnsrAqtnRegVal50(java.lang.String socnsrAqtnRegVal50) {
		this.socnsrAqtnRegVal50 = socnsrAqtnRegVal50;
	}

	public java.lang.String getSocnsrAqtnRegVal51() {
		return socnsrAqtnRegVal51;
	}

	public void setSocnsrAqtnRegVal51(java.lang.String socnsrAqtnRegVal51) {
		this.socnsrAqtnRegVal51 = socnsrAqtnRegVal51;
	}

	public java.lang.String getSocnsrAqtnRegVal52() {
		return socnsrAqtnRegVal52;
	}

	public void setSocnsrAqtnRegVal52(java.lang.String socnsrAqtnRegVal52) {
		this.socnsrAqtnRegVal52 = socnsrAqtnRegVal52;
	}

	public java.lang.String getSocnsrAqtnRegVal53() {
		return socnsrAqtnRegVal53;
	}

	public void setSocnsrAqtnRegVal53(java.lang.String socnsrAqtnRegVal53) {
		this.socnsrAqtnRegVal53 = socnsrAqtnRegVal53;
	}

	public java.lang.String getSocnsrAqtnRegVal54() {
		return socnsrAqtnRegVal54;
	}

	public void setSocnsrAqtnRegVal54(java.lang.String socnsrAqtnRegVal54) {
		this.socnsrAqtnRegVal54 = socnsrAqtnRegVal54;
	}

	public java.lang.String getSocnsrAqtnRegVal55() {
		return socnsrAqtnRegVal55;
	}

	public void setSocnsrAqtnRegVal55(java.lang.String socnsrAqtnRegVal55) {
		this.socnsrAqtnRegVal55 = socnsrAqtnRegVal55;
	}

	public java.lang.String getSocnsrAqtnRegVal56() {
		return socnsrAqtnRegVal56;
	}

	public void setSocnsrAqtnRegVal56(java.lang.String socnsrAqtnRegVal56) {
		this.socnsrAqtnRegVal56 = socnsrAqtnRegVal56;
	}

	public java.lang.String getSocnsrAqtnRegVal57() {
		return socnsrAqtnRegVal57;
	}

	public void setSocnsrAqtnRegVal57(java.lang.String socnsrAqtnRegVal57) {
		this.socnsrAqtnRegVal57 = socnsrAqtnRegVal57;
	}

	public java.lang.String getSocnsrAqtnRegVal58() {
		return socnsrAqtnRegVal58;
	}

	public void setSocnsrAqtnRegVal58(java.lang.String socnsrAqtnRegVal58) {
		this.socnsrAqtnRegVal58 = socnsrAqtnRegVal58;
	}

	public java.lang.String getSocnsrAqtnRegVal59() {
		return socnsrAqtnRegVal59;
	}

	public void setSocnsrAqtnRegVal59(java.lang.String socnsrAqtnRegVal59) {
		this.socnsrAqtnRegVal59 = socnsrAqtnRegVal59;
	}

	public java.lang.String getSocnsrAqtnRegVal60() {
		return socnsrAqtnRegVal60;
	}

	public void setSocnsrAqtnRegVal60(java.lang.String socnsrAqtnRegVal60) {
		this.socnsrAqtnRegVal60 = socnsrAqtnRegVal60;
	}

	public java.lang.String getSocnsrAqtnRegVal61() {
		return socnsrAqtnRegVal61;
	}

	public void setSocnsrAqtnRegVal61(java.lang.String socnsrAqtnRegVal61) {
		this.socnsrAqtnRegVal61 = socnsrAqtnRegVal61;
	}

	public java.lang.String getSocnsrAqtnRegVal62() {
		return socnsrAqtnRegVal62;
	}

	public void setSocnsrAqtnRegVal62(java.lang.String socnsrAqtnRegVal62) {
		this.socnsrAqtnRegVal62 = socnsrAqtnRegVal62;
	}

	public java.lang.String getSocnsrAqtnRegVal63() {
		return socnsrAqtnRegVal63;
	}

	public void setSocnsrAqtnRegVal63(java.lang.String socnsrAqtnRegVal63) {
		this.socnsrAqtnRegVal63 = socnsrAqtnRegVal63;
	}

	public java.lang.String getSocnsrAqtnRegVal64() {
		return socnsrAqtnRegVal64;
	}

	public void setSocnsrAqtnRegVal64(java.lang.String socnsrAqtnRegVal64) {
		this.socnsrAqtnRegVal64 = socnsrAqtnRegVal64;
	}

	public java.lang.String getSocnsrAqtnRegVal65() {
		return socnsrAqtnRegVal65;
	}

	public void setSocnsrAqtnRegVal65(java.lang.String socnsrAqtnRegVal65) {
		this.socnsrAqtnRegVal65 = socnsrAqtnRegVal65;
	}

	public java.lang.String getSocnsrAqtnRegVal66() {
		return socnsrAqtnRegVal66;
	}

	public void setSocnsrAqtnRegVal66(java.lang.String socnsrAqtnRegVal66) {
		this.socnsrAqtnRegVal66 = socnsrAqtnRegVal66;
	}

	public java.lang.String getSocnsrAqtnRegVal67() {
		return socnsrAqtnRegVal67;
	}

	public void setSocnsrAqtnRegVal67(java.lang.String socnsrAqtnRegVal67) {
		this.socnsrAqtnRegVal67 = socnsrAqtnRegVal67;
	}

	public java.lang.String getSocnsrAqtnRegVal68() {
		return socnsrAqtnRegVal68;
	}

	public void setSocnsrAqtnRegVal68(java.lang.String socnsrAqtnRegVal68) {
		this.socnsrAqtnRegVal68 = socnsrAqtnRegVal68;
	}

	public java.lang.String getSocnsrAqtnRegVal69() {
		return socnsrAqtnRegVal69;
	}

	public void setSocnsrAqtnRegVal69(java.lang.String socnsrAqtnRegVal69) {
		this.socnsrAqtnRegVal69 = socnsrAqtnRegVal69;
	}

	public java.lang.String getSocnsrAqtnRegVal70() {
		return socnsrAqtnRegVal70;
	}

	public void setSocnsrAqtnRegVal70(java.lang.String socnsrAqtnRegVal70) {
		this.socnsrAqtnRegVal70 = socnsrAqtnRegVal70;
	}

	public java.lang.String getSocnsrAqtnRegVal71() {
		return socnsrAqtnRegVal71;
	}

	public void setSocnsrAqtnRegVal71(java.lang.String socnsrAqtnRegVal71) {
		this.socnsrAqtnRegVal71 = socnsrAqtnRegVal71;
	}

	public java.lang.String getSocnsrAqtnRegVal72() {
		return socnsrAqtnRegVal72;
	}

	public void setSocnsrAqtnRegVal72(java.lang.String socnsrAqtnRegVal72) {
		this.socnsrAqtnRegVal72 = socnsrAqtnRegVal72;
	}

	public java.lang.String getSocnsrAqtnRegVal73() {
		return socnsrAqtnRegVal73;
	}

	public void setSocnsrAqtnRegVal73(java.lang.String socnsrAqtnRegVal73) {
		this.socnsrAqtnRegVal73 = socnsrAqtnRegVal73;
	}

	public java.lang.String getSocnsrAqtnRegVal74() {
		return socnsrAqtnRegVal74;
	}

	public void setSocnsrAqtnRegVal74(java.lang.String socnsrAqtnRegVal74) {
		this.socnsrAqtnRegVal74 = socnsrAqtnRegVal74;
	}

	public java.lang.String getSocnsrAqtnRegVal75() {
		return socnsrAqtnRegVal75;
	}

	public void setSocnsrAqtnRegVal75(java.lang.String socnsrAqtnRegVal75) {
		this.socnsrAqtnRegVal75 = socnsrAqtnRegVal75;
	}

	public java.lang.String getSocnsrAqtnRegVal76() {
		return socnsrAqtnRegVal76;
	}

	public void setSocnsrAqtnRegVal76(java.lang.String socnsrAqtnRegVal76) {
		this.socnsrAqtnRegVal76 = socnsrAqtnRegVal76;
	}

	public java.lang.String getSocnsrAqtnRegVal77() {
		return socnsrAqtnRegVal77;
	}

	public void setSocnsrAqtnRegVal77(java.lang.String socnsrAqtnRegVal77) {
		this.socnsrAqtnRegVal77 = socnsrAqtnRegVal77;
	}

	public java.lang.String getSocnsrAqtnRegVal78() {
		return socnsrAqtnRegVal78;
	}

	public void setSocnsrAqtnRegVal78(java.lang.String socnsrAqtnRegVal78) {
		this.socnsrAqtnRegVal78 = socnsrAqtnRegVal78;
	}

	public java.lang.String getSocnsrAqtnRegVal79() {
		return socnsrAqtnRegVal79;
	}

	public void setSocnsrAqtnRegVal79(java.lang.String socnsrAqtnRegVal79) {
		this.socnsrAqtnRegVal79 = socnsrAqtnRegVal79;
	}

	public java.lang.String getSocnsrAqtnRegVal80() {
		return socnsrAqtnRegVal80;
	}

	public void setSocnsrAqtnRegVal80(java.lang.String socnsrAqtnRegVal80) {
		this.socnsrAqtnRegVal80 = socnsrAqtnRegVal80;
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

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
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

	public java.lang.String getSocnsrAqtnRegVal04Nm() {
		return socnsrAqtnRegVal04Nm;
	}

	public void setSocnsrAqtnRegVal04Nm(java.lang.String socnsrAqtnRegVal04Nm) {
		this.socnsrAqtnRegVal04Nm = socnsrAqtnRegVal04Nm;
	}

	public java.lang.String getSocnsrAqtnRegVal23Nm() {
		return socnsrAqtnRegVal23Nm;
	}

	public void setSocnsrAqtnRegVal23Nm(java.lang.String socnsrAqtnRegVal23Nm) {
		this.socnsrAqtnRegVal23Nm = socnsrAqtnRegVal23Nm;
	}

	public java.lang.String getSocnsrAqtnRegVal32Nm() {
		return socnsrAqtnRegVal32Nm;
	}

	public void setSocnsrAqtnRegVal32Nm(java.lang.String socnsrAqtnRegVal32Nm) {
		this.socnsrAqtnRegVal32Nm = socnsrAqtnRegVal32Nm;
	}

	 
     
}
