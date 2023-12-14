package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0350VO.java
 * @Description : Payr0350 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0360DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 소급년도 : reattyYr */
    private java.lang.String reattyYr;

    /** set 소급설정회차번호 : reattyStpDsptyNum */
    private java.lang.String reattyStpDsptyNum;

    /** set 소급적용년월 : reattyApptnYrMnth */
    private java.lang.String reattyApptnYrMnth;
    
    /** set 소급적용년 : reattyApptnYr */
    private java.lang.String reattyApptnYr;
    
    /** set 소급적용월 : reattyApptnMnth */
    private java.lang.String reattyApptnMnth;

    /** set 소급지급일자 : reattyPymtDt */
    private java.lang.String reattyPymtDt;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;

    
    private java.lang.String mangeDeptCd;  
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 지급월설정_01 : pymtMnthStp01 */
    private Boolean pymtMnthStp01;

    /** set 지급월설정_02 : pymtMnthStp02 */
    private Boolean pymtMnthStp02;

    /** set 지급월설정_03 : pymtMnthStp03 */
    private Boolean pymtMnthStp03;

    /** set 지급월설정_04 : pymtMnthStp04 */
    private Boolean pymtMnthStp04;

    /** set 지급월설정_05 : pymtMnthStp05 */
    private Boolean pymtMnthStp05;

    /** set 지급월설정_06 : pymtMnthStp06 */
    private Boolean pymtMnthStp06;

    /** set 지급월설정_07 : pymtMnthStp07 */
    private Boolean pymtMnthStp07;

    /** set 지급월설정_08 : pymtMnthStp08 */
    private Boolean pymtMnthStp08;

    /** set 지급월설정_09 : pymtMnthStp09 */
    private Boolean pymtMnthStp09;

    /** set 지급월설정_10 : pymtMnthStp10 */
    private Boolean pymtMnthStp10;

    /** set 지급월설정_11 : pymtMnthStp11 */
    private Boolean pymtMnthStp11;

    /** set 지급월설정_12 : pymtMnthStp12 */
    private Boolean pymtMnthStp12;

    /** set TGT_SYSTEMKEY : tgtSystemkey */
    private java.lang.String tgtSystemkey;

    /** set 소급설정내용 : reattyStpNoteCtnt */
    private java.lang.String reattyStpNoteCtnt;

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


	 /** 직종세통합코드 dtilOccuInttnCd */
private java.lang.String dtilOccuInttnCd;


    
    
	/**
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 24, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 24, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getReattyApptnYr() {
		return reattyApptnYr;
	}

	public void setReattyApptnYr(java.lang.String reattyApptnYr) {
		this.reattyApptnYr = reattyApptnYr;
	}

	public java.lang.String getReattyApptnMnth() {
		return reattyApptnMnth;
	}

	public void setReattyApptnMnth(java.lang.String reattyApptnMnth) {
		this.reattyApptnMnth = reattyApptnMnth;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getReattyYr() {
		return reattyYr;
	}

	public void setReattyYr(java.lang.String reattyYr) {
		this.reattyYr = reattyYr;
	}

	public java.lang.String getReattyStpDsptyNum() {
		return reattyStpDsptyNum;
	}

	public void setReattyStpDsptyNum(java.lang.String reattyStpDsptyNum) {
		this.reattyStpDsptyNum = reattyStpDsptyNum;
	}

 
	public java.lang.String getReattyApptnYrMnth() {
		return reattyApptnYrMnth;
	}

	public void setReattyApptnYrMnth(java.lang.String reattyApptnYrMnth) {
		this.reattyApptnYrMnth = reattyApptnYrMnth;
	}

	public java.lang.String getReattyPymtDt() {
		return reattyPymtDt;
	}

	public void setReattyPymtDt(java.lang.String reattyPymtDt) {
		this.reattyPymtDt = reattyPymtDt;
	}

	public java.lang.String getEmymtDivCd() {
		return emymtDivCd;
	}

	public void setEmymtDivCd(java.lang.String emymtDivCd) {
		this.emymtDivCd = emymtDivCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
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

	public Boolean getPymtMnthStp01() {
		return pymtMnthStp01;
	}

	public void setPymtMnthStp01(Boolean pymtMnthStp01) {
		this.pymtMnthStp01 = pymtMnthStp01;
	}

	public Boolean getPymtMnthStp02() {
		return pymtMnthStp02;
	}

	public void setPymtMnthStp02(Boolean pymtMnthStp02) {
		this.pymtMnthStp02 = pymtMnthStp02;
	}

	public Boolean getPymtMnthStp03() {
		return pymtMnthStp03;
	}

	public void setPymtMnthStp03(Boolean pymtMnthStp03) {
		this.pymtMnthStp03 = pymtMnthStp03;
	}

	public Boolean getPymtMnthStp04() {
		return pymtMnthStp04;
	}

	public void setPymtMnthStp04(Boolean pymtMnthStp04) {
		this.pymtMnthStp04 = pymtMnthStp04;
	}

	public Boolean getPymtMnthStp05() {
		return pymtMnthStp05;
	}

	public void setPymtMnthStp05(Boolean pymtMnthStp05) {
		this.pymtMnthStp05 = pymtMnthStp05;
	}

	public Boolean getPymtMnthStp06() {
		return pymtMnthStp06;
	}

	public void setPymtMnthStp06(Boolean pymtMnthStp06) {
		this.pymtMnthStp06 = pymtMnthStp06;
	}

	public Boolean getPymtMnthStp07() {
		return pymtMnthStp07;
	}

	public void setPymtMnthStp07(Boolean pymtMnthStp07) {
		this.pymtMnthStp07 = pymtMnthStp07;
	}

	public Boolean getPymtMnthStp08() {
		return pymtMnthStp08;
	}

	public void setPymtMnthStp08(Boolean pymtMnthStp08) {
		this.pymtMnthStp08 = pymtMnthStp08;
	}

	public Boolean getPymtMnthStp09() {
		return pymtMnthStp09;
	}

	public void setPymtMnthStp09(Boolean pymtMnthStp09) {
		this.pymtMnthStp09 = pymtMnthStp09;
	}

	public Boolean getPymtMnthStp10() {
		return pymtMnthStp10;
	}

	public void setPymtMnthStp10(Boolean pymtMnthStp10) {
		this.pymtMnthStp10 = pymtMnthStp10;
	}

	public Boolean getPymtMnthStp11() {
		return pymtMnthStp11;
	}

	public void setPymtMnthStp11(Boolean pymtMnthStp11) {
		this.pymtMnthStp11 = pymtMnthStp11;
	}

	public Boolean getPymtMnthStp12() {
		return pymtMnthStp12;
	}

	public void setPymtMnthStp12(Boolean pymtMnthStp12) {
		this.pymtMnthStp12 = pymtMnthStp12;
	}

	public java.lang.String getTgtSystemkey() {
		return tgtSystemkey;
	}

	public void setTgtSystemkey(java.lang.String tgtSystemkey) {
		this.tgtSystemkey = tgtSystemkey;
	}

	public java.lang.String getReattyStpNoteCtnt() {
		return reattyStpNoteCtnt;
	}

	public void setReattyStpNoteCtnt(java.lang.String reattyStpNoteCtnt) {
		this.reattyStpNoteCtnt = reattyStpNoteCtnt;
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
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 9. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2018 2018. 3. 9. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	} 
    
	
}
