package com.app.exterms.retirement.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Remt1000VO.java
 * @Description : Remt1000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt1000VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
    private java.math.BigDecimal sevePayAddRateSeilNum;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
    private java.lang.String sevePayAddRateFrmCd;

    /** set 퇴직금가산이상 : sevePayAddOvr */
    private java.lang.String sevePayAddOvr;

    /** set 퇴직금가산미만 : sevePayAddUdr */
    private java.lang.String sevePayAddUdr;

    /** set 퇴직금가산금액 : sevePayAddSum */
    private java.math.BigDecimal sevePayAddSum;

    /** set 퇴직금가산율 : sevePayAddRate */
    private java.lang.String sevePayAddRate;

    /** set 퇴직금비고내용 : sevePayNoteCtnt */
    private java.lang.String sevePayNoteCtnt;

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
    
    /** set 퇴직금가산시작일자 : sevePayAddBgnnDt */
    private java.lang.String sevePayAddBgnnDt;

    /** set 퇴직금가산종료일자 : sevePayAddEndDt */
    private java.lang.String sevePayAddEndDt;

    /** set 퇴직금가산사용여부 : sevePayAddUseYn */
    private java.lang.String sevePayAddUseYn;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;
    
    
    /**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuClsDivCd()
	 * @brief date:2015 Dec 13, 2015 user:leeheuisung
	 * @return the dtilOccuClsDivCd get
	 */
	public java.lang.String getDtilOccuClsDivCd() {
		return dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd)
	 *@brief date:2015 Dec 13, 2015 user:leeheuisung
	 *@param dtilOccuClsDivCd the dtilOccuClsDivCd to set
	 */
	public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
		this.dtilOccuClsDivCd = dtilOccuClsDivCd;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getSevePayAddBgnnDt() {
		return sevePayAddBgnnDt;
	}

	public void setSevePayAddBgnnDt(java.lang.String sevePayAddBgnnDt) {
		this.sevePayAddBgnnDt = sevePayAddBgnnDt;
	}

	public java.lang.String getSevePayAddEndDt() {
		return sevePayAddEndDt;
	}

	public void setSevePayAddEndDt(java.lang.String sevePayAddEndDt) {
		this.sevePayAddEndDt = sevePayAddEndDt;
	}

	public java.lang.String getSevePayAddUseYn() {
		return sevePayAddUseYn;
	}

	public void setSevePayAddUseYn(java.lang.String sevePayAddUseYn) {
		this.sevePayAddUseYn = sevePayAddUseYn;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.math.BigDecimal getSevePayAddRateSeilNum() {
        return this.sevePayAddRateSeilNum;
    }
    
    public void setSevePayAddRateSeilNum(java.math.BigDecimal sevePayAddRateSeilNum) {
        this.sevePayAddRateSeilNum = sevePayAddRateSeilNum;
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
    
    public java.lang.String getSevePayAddRateFrmCd() {
        return this.sevePayAddRateFrmCd;
    }
    
    public void setSevePayAddRateFrmCd(java.lang.String sevePayAddRateFrmCd) {
        this.sevePayAddRateFrmCd = sevePayAddRateFrmCd;
    }
    
    public java.lang.String getSevePayAddOvr() {
        return this.sevePayAddOvr;
    }
    
    public void setSevePayAddOvr(java.lang.String sevePayAddOvr) {
        this.sevePayAddOvr = sevePayAddOvr;
    }
    
    public java.lang.String getSevePayAddUdr() {
        return this.sevePayAddUdr;
    }
    
    public void setSevePayAddUdr(java.lang.String sevePayAddUdr) {
        this.sevePayAddUdr = sevePayAddUdr;
    }
    
    public java.math.BigDecimal getSevePayAddSum() {
        return this.sevePayAddSum;
    }
    
    public void setSevePayAddSum(java.math.BigDecimal sevePayAddSum) {
        this.sevePayAddSum = sevePayAddSum;
    }
    
    public java.lang.String getSevePayAddRate() {
        return this.sevePayAddRate;
    }
    
    public void setSevePayAddRate(java.lang.String sevePayAddRate) {
        this.sevePayAddRate = sevePayAddRate;
    }
    
    public java.lang.String getSevePayNoteCtnt() {
        return this.sevePayNoteCtnt;
    }
    
    public void setSevePayNoteCtnt(java.lang.String sevePayNoteCtnt) {
        this.sevePayNoteCtnt = sevePayNoteCtnt;
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
    
}
