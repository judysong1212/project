package com.app.exterms.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0100VO.java
 * @Description : Payr0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass5510VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
//  public List<Psnl0126VO> psnl0126List = new ArrayList<Psnl0126VO>();
//
//	public List<Psnl0126VO> getPsnl0126List() {
//		return psnl0126List;
//	}
//
//	public void setPsnl0126List(List<Psnl0126VO> psnl0126List) {
//		this.psnl0126List = psnl0126List;
//	}
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 적용년도 : apptnYr */
    private java.lang.String apptnYr;
    
    /** set 적용년도 : apptnYr */
    private java.lang.String tempApptnYr;
    
    

    public java.lang.String getTempApptnYr() {
		return tempApptnYr;
	}

	public void setTempApptnYr(java.lang.String tempApptnYr) {
		this.tempApptnYr = tempApptnYr;
	}

	/** set 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
    private java.math.BigDecimal eandIncmTxtbSimfTxsNum;
    
    /** set null : eandIncmBaseDt */
    private java.lang.String eandIncmBaseDt;

    /** set 적용기준시작일자 : apptnStdBgnnDt */
    private java.lang.String apptnStdBgnnDt;

    /** set 적용기준종료일자 : apptnStdEndDt */
    private java.lang.String apptnStdEndDt;
    
    /** set 임시 적용기준종료일자 : apptnStdEndDt */
    private java.lang.String tempApptnStdEndDt;
    

    public java.lang.String getTempApptnStdEndDt() {
		return tempApptnStdEndDt;
	}

	public void setTempApptnStdEndDt(java.lang.String tempApptnStdEndDt) {
		this.tempApptnStdEndDt = tempApptnStdEndDt;
	}

	/** set 이상 : ovr */
    private java.math.BigDecimal ovr;

    /** set 미만 : udr */
    private java.math.BigDecimal udr;

    /** set 1인 : oneOfPepl */
    private java.math.BigDecimal oneOfPepl;

    /** set 2인 : twoOfPepl */
    private java.math.BigDecimal twoOfPepl;

    /** set 3인일반 : treOfGerl */
    private java.math.BigDecimal treOfGerl;

    /** set 3인다자녀 : treOfMlchd */
    private java.math.BigDecimal treOfMlchd;

    /** set 4인일반 : furOfGerl */
    private java.math.BigDecimal furOfGerl;

    /** set 4인다자녀 : furOfMlchd */
    private java.math.BigDecimal furOfMlchd;

    /** set 5인일반 : fveOfGerl */
    private java.math.BigDecimal fveOfGerl;

    /** set 5인다자녀 : fveOfMlchd */
    private java.math.BigDecimal fveOfMlchd;

    /** set 6인일반 : sixOfGerl */
    private java.math.BigDecimal sixOfGerl;

    /** set 6인다자녀 : sixOfMlchd */
    private java.math.BigDecimal sixOfMlchd;

    /** set 7인일반 : svnOfGerl */
    private java.math.BigDecimal svnOfGerl;

    /** set 7인다자녀 : svnOfMlchd */
    private java.math.BigDecimal svnOfMlchd;

    /** set 8인일반 : egtOfGerl */
    private java.math.BigDecimal egtOfGerl;

    /** set 8인다자녀 : egtOfMlchd */
    private java.math.BigDecimal egtOfMlchd;

    /** set 9인일반 : nineOfGerl */
    private java.math.BigDecimal nineOfGerl;

    /** set 9인다자녀 : nineOfMlchd */
    private java.math.BigDecimal nineOfMlchd;

    /** set 10인일반 : tenOfGerl */
    private java.math.BigDecimal tenOfGerl;

    /** set 10인다자녀 : tenOfMlchd */
    private java.math.BigDecimal tenOfMlchd;

    /** set 11인일반 : evthOfGerl */
    private java.math.BigDecimal evthOfGerl;

    /** set 11인다자녀 : evthOfMlchd */
    private java.math.BigDecimal evthOfMlchd;

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
    
    /** set null : eandIncmBaseYn */
    private java.lang.String eandIncmBaseYn;


	public java.lang.String getEandIncmBaseDt() {
		return eandIncmBaseDt;
	}

	public void setEandIncmBaseDt(java.lang.String eandIncmBaseDt) {
		this.eandIncmBaseDt = eandIncmBaseDt;
	}

	public java.lang.String getEandIncmBaseYn() {
		return eandIncmBaseYn;
	}

	public void setEandIncmBaseYn(java.lang.String eandIncmBaseYn) {
		this.eandIncmBaseYn = eandIncmBaseYn;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getApptnYr() {
		return apptnYr;
	}

	public void setApptnYr(java.lang.String apptnYr) {
		this.apptnYr = apptnYr;
	}

	public java.math.BigDecimal getEandIncmTxtbSimfTxsNum() {
		return eandIncmTxtbSimfTxsNum;
	}

	public void setEandIncmTxtbSimfTxsNum(
			java.math.BigDecimal eandIncmTxtbSimfTxsNum) {
		this.eandIncmTxtbSimfTxsNum = eandIncmTxtbSimfTxsNum;
	}

	public java.lang.String getApptnStdBgnnDt() {
		return apptnStdBgnnDt;
	}

	public void setApptnStdBgnnDt(java.lang.String apptnStdBgnnDt) {
		this.apptnStdBgnnDt = apptnStdBgnnDt;
	}

	public java.lang.String getApptnStdEndDt() {
		return apptnStdEndDt;
	}

	public void setApptnStdEndDt(java.lang.String apptnStdEndDt) {
		this.apptnStdEndDt = apptnStdEndDt;
	}

	public java.math.BigDecimal getOvr() {
		return ovr;
	}

	public void setOvr(java.math.BigDecimal ovr) {
		this.ovr = ovr;
	}

	public java.math.BigDecimal getUdr() {
		return udr;
	}

	public void setUdr(java.math.BigDecimal udr) {
		this.udr = udr;
	}

	public java.math.BigDecimal getOneOfPepl() {
		return oneOfPepl;
	}

	public void setOneOfPepl(java.math.BigDecimal oneOfPepl) {
		this.oneOfPepl = oneOfPepl;
	}

	public java.math.BigDecimal getTwoOfPepl() {
		return twoOfPepl;
	}

	public void setTwoOfPepl(java.math.BigDecimal twoOfPepl) {
		this.twoOfPepl = twoOfPepl;
	}

	public java.math.BigDecimal getTreOfGerl() {
		return treOfGerl;
	}

	public void setTreOfGerl(java.math.BigDecimal treOfGerl) {
		this.treOfGerl = treOfGerl;
	}

	public java.math.BigDecimal getTreOfMlchd() {
		return treOfMlchd;
	}

	public void setTreOfMlchd(java.math.BigDecimal treOfMlchd) {
		this.treOfMlchd = treOfMlchd;
	}

	public java.math.BigDecimal getFurOfGerl() {
		return furOfGerl;
	}

	public void setFurOfGerl(java.math.BigDecimal furOfGerl) {
		this.furOfGerl = furOfGerl;
	}

	public java.math.BigDecimal getFurOfMlchd() {
		return furOfMlchd;
	}

	public void setFurOfMlchd(java.math.BigDecimal furOfMlchd) {
		this.furOfMlchd = furOfMlchd;
	}

	public java.math.BigDecimal getFveOfGerl() {
		return fveOfGerl;
	}

	public void setFveOfGerl(java.math.BigDecimal fveOfGerl) {
		this.fveOfGerl = fveOfGerl;
	}

	public java.math.BigDecimal getFveOfMlchd() {
		return fveOfMlchd;
	}

	public void setFveOfMlchd(java.math.BigDecimal fveOfMlchd) {
		this.fveOfMlchd = fveOfMlchd;
	}

	public java.math.BigDecimal getSixOfGerl() {
		return sixOfGerl;
	}

	public void setSixOfGerl(java.math.BigDecimal sixOfGerl) {
		this.sixOfGerl = sixOfGerl;
	}

	public java.math.BigDecimal getSixOfMlchd() {
		return sixOfMlchd;
	}

	public void setSixOfMlchd(java.math.BigDecimal sixOfMlchd) {
		this.sixOfMlchd = sixOfMlchd;
	}

	public java.math.BigDecimal getSvnOfGerl() {
		return svnOfGerl;
	}

	public void setSvnOfGerl(java.math.BigDecimal svnOfGerl) {
		this.svnOfGerl = svnOfGerl;
	}

	public java.math.BigDecimal getSvnOfMlchd() {
		return svnOfMlchd;
	}

	public void setSvnOfMlchd(java.math.BigDecimal svnOfMlchd) {
		this.svnOfMlchd = svnOfMlchd;
	}

	public java.math.BigDecimal getEgtOfGerl() {
		return egtOfGerl;
	}

	public void setEgtOfGerl(java.math.BigDecimal egtOfGerl) {
		this.egtOfGerl = egtOfGerl;
	}

	public java.math.BigDecimal getEgtOfMlchd() {
		return egtOfMlchd;
	}

	public void setEgtOfMlchd(java.math.BigDecimal egtOfMlchd) {
		this.egtOfMlchd = egtOfMlchd;
	}

	public java.math.BigDecimal getNineOfGerl() {
		return nineOfGerl;
	}

	public void setNineOfGerl(java.math.BigDecimal nineOfGerl) {
		this.nineOfGerl = nineOfGerl;
	}

	public java.math.BigDecimal getNineOfMlchd() {
		return nineOfMlchd;
	}

	public void setNineOfMlchd(java.math.BigDecimal nineOfMlchd) {
		this.nineOfMlchd = nineOfMlchd;
	}

	public java.math.BigDecimal getTenOfGerl() {
		return tenOfGerl;
	}

	public void setTenOfGerl(java.math.BigDecimal tenOfGerl) {
		this.tenOfGerl = tenOfGerl;
	}

	public java.math.BigDecimal getTenOfMlchd() {
		return tenOfMlchd;
	}

	public void setTenOfMlchd(java.math.BigDecimal tenOfMlchd) {
		this.tenOfMlchd = tenOfMlchd;
	}

	public java.math.BigDecimal getEvthOfGerl() {
		return evthOfGerl;
	}

	public void setEvthOfGerl(java.math.BigDecimal evthOfGerl) {
		this.evthOfGerl = evthOfGerl;
	}

	public java.math.BigDecimal getEvthOfMlchd() {
		return evthOfMlchd;
	}

	public void setEvthOfMlchd(java.math.BigDecimal evthOfMlchd) {
		this.evthOfMlchd = evthOfMlchd;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
