package com.app.exterms.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Psnl2100VO.java
 * @Description : Psnl2100 VO class
 * @Modification Information
 *
 * @author 다은
 * @since 2015.10.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl2100VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 휴가일수일련번호 : hodyNumDysSeilNum */
	private java.math.BigDecimal hodyNumDysSeilNum;

	/** set 직종코드 : typOccuCd */
	private java.lang.String typOccuCd;

	/** set 호봉등급코드 : pyspGrdeCd */
	private java.lang.String pyspGrdeCd;

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	private java.lang.String dtilOccuClsDivCd;

	/** set 근속년수 이상 : hodyNumDysOvr */
	private java.math.BigDecimal hodyNumDysOvr;

	/** set 근속년수 미만 : hodyNumDysUdr */
	private java.math.BigDecimal hodyNumDysUdr;

	/** set 휴가일수유형코드 : hodyNumDysFrmCd */
	private java.lang.String hodyNumDysFrmCd;

	/** set 휴가일수 : hodyNumDys */
	private java.math.BigDecimal hodyNumDys;

	/** set 휴가일수율 : hodyNumDysRate */
	private java.math.BigDecimal hodyNumDysRate;

	/** set 휴가일수시작일자 : hodyNumDysBgnnDt */
	private java.lang.String hodyNumDysBgnnDt;

	/** set 휴가일수종료일자 : hodyNumDysEndDt */
	private java.lang.String hodyNumDysEndDt;

	/** set 휴가일수사용여부 : hodyNumDysUseYn */
	private java.lang.String hodyNumDysUseYn;

	/** set 휴가일수비고내용 : hodyNumDysNoteCtnt */
	private java.lang.String hodyNumDysNoteCtnt;

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
	
	/** set 기본 직종코드 : basicTypOccuCd */
	private java.lang.String basicTypOccuCd;	
	
	/** set 기본 직종세코드 : basicDtilOccuClsDivCd */
	private java.lang.String basicDtilOccuClsDivCd;
	
	/** set 대상 직종코드 : targetTypOccuCd */
	private java.lang.String targetTypOccuCd;
	
	/** set 대상 직종세코드 : targetDtilOccuClsDivCd */
	private java.lang.String targetDtilOccuClsDivCd;
	
	

    /**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 25, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 25, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.math.BigDecimal getHodyNumDysSeilNum() {
        return this.hodyNumDysSeilNum;
    }
    
    public void setHodyNumDysSeilNum(java.math.BigDecimal hodyNumDysSeilNum) {
        this.hodyNumDysSeilNum = hodyNumDysSeilNum;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.math.BigDecimal getHodyNumDysOvr() {
        return this.hodyNumDysOvr;
    }
    
    public void setHodyNumDysOvr(java.math.BigDecimal hodyNumDysOvr) {
        this.hodyNumDysOvr = hodyNumDysOvr;
    }
    
    public java.math.BigDecimal getHodyNumDysUdr() {
        return this.hodyNumDysUdr;
    }
    
    public void setHodyNumDysUdr(java.math.BigDecimal hodyNumDysUdr) {
        this.hodyNumDysUdr = hodyNumDysUdr;
    }
    
    public java.lang.String getHodyNumDysFrmCd() {
        return this.hodyNumDysFrmCd;
    }
    
    public void setHodyNumDysFrmCd(java.lang.String hodyNumDysFrmCd) {
        this.hodyNumDysFrmCd = hodyNumDysFrmCd;
    }
    
    public java.math.BigDecimal getHodyNumDys() {
        return this.hodyNumDys;
    }
    
    public void setHodyNumDys(java.math.BigDecimal hodyNumDys) {
        this.hodyNumDys = hodyNumDys;
    }
    
    public java.math.BigDecimal getHodyNumDysRate() {
        return this.hodyNumDysRate;
    }
    
    public void setHodyNumDysRate(java.math.BigDecimal hodyNumDysRate) {
        this.hodyNumDysRate = hodyNumDysRate;
    }
    
    public java.lang.String getHodyNumDysBgnnDt() {
        return this.hodyNumDysBgnnDt;
    }
    
    public void setHodyNumDysBgnnDt(java.lang.String hodyNumDysBgnnDt) {
        this.hodyNumDysBgnnDt = hodyNumDysBgnnDt;
    }
    
    public java.lang.String getHodyNumDysEndDt() {
        return this.hodyNumDysEndDt;
    }
    
    public void setHodyNumDysEndDt(java.lang.String hodyNumDysEndDt) {
        this.hodyNumDysEndDt = hodyNumDysEndDt;
    }
    
    public java.lang.String getHodyNumDysUseYn() {
        return this.hodyNumDysUseYn;
    }
    
    public void setHodyNumDysUseYn(java.lang.String hodyNumDysUseYn) {
        this.hodyNumDysUseYn = hodyNumDysUseYn;
    }
    
    public java.lang.String getHodyNumDysNoteCtnt() {
        return this.hodyNumDysNoteCtnt;
    }
    
    public void setHodyNumDysNoteCtnt(java.lang.String hodyNumDysNoteCtnt) {
        this.hodyNumDysNoteCtnt = hodyNumDysNoteCtnt;
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

	public java.lang.String getBasicDtilOccuClsDivCd() {
		return basicDtilOccuClsDivCd;
	}

	public void setBasicDtilOccuClsDivCd(java.lang.String basicDtilOccuClsDivCd) {
		this.basicDtilOccuClsDivCd = basicDtilOccuClsDivCd;
	}
	
	public java.lang.String getBasicTypOccuCd() {
		return basicTypOccuCd;
	}

	public void setBasicTypOccuCd(java.lang.String basicTypOccuCd) {
		this.basicTypOccuCd = basicTypOccuCd;
	}

	public java.lang.String getTargetTypOccuCd() {
		return targetTypOccuCd;
	}

	public void setTargetTypOccuCd(java.lang.String targetTypOccuCd) {
		this.targetTypOccuCd = targetTypOccuCd;
	}

	public java.lang.String getTargetDtilOccuClsDivCd() {
		return targetDtilOccuClsDivCd;
	}

	public void setTargetDtilOccuClsDivCd(java.lang.String targetDtilOccuClsDivCd) {
		this.targetDtilOccuClsDivCd = targetDtilOccuClsDivCd;
	}

    
}
