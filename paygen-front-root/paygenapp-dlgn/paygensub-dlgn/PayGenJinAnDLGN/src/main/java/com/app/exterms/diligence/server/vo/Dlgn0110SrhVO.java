package com.app.exterms.diligence.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Dlgn0100VO.java
 * @Description : Dlgn0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0110SrhVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 근태년월 : dilnlazYrMnth */
    private java.lang.String dilnlazYrMnth;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    private java.lang.String dtilOccuClsDivCd;

    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    private java.lang.String dilnlazDutyBgnnDt;

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    private java.lang.String dilnlazDutyEndDt;

    /** set 근태_근무일수 : dilnlazDutyNumDys */
    private java.lang.String dilnlazDutyNumDys;

    /** set 근태_연가일수 : dilnlazLvsgNumDys */
    private java.lang.String dilnlazLvsgNumDys;

    /** set 근태_결근일수 : dilnlazAbnceNumDys */
    private java.lang.String dilnlazAbnceNumDys;

    /** set 근태_병가일수 : dilnlazSckleaNumDys */
    private java.lang.String dilnlazSckleaNumDys;

    /** set 근태_공가일수 : dilnlazOffvaNumDys */
    private java.lang.String dilnlazOffvaNumDys;

    /** set 근태_경조사일수 : dilnlazFmlyEvntNumDys */
    private java.lang.String dilnlazFmlyEvntNumDys;

    /** set 근태_보건일수 : dilnlazHlthCreNumDys */
    private java.lang.String dilnlazHlthCreNumDys;

    /** set 근태_총근무일수 : dilnlazTotDutyNumDys */
    private java.lang.String dilnlazTotDutyNumDys;

    /** set 근태_주휴일수 : dilnlazWklyHldyNumDys */
    private java.lang.String dilnlazWklyHldyNumDys;

    /** set 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
    private java.lang.String dilnlazPaidPubcHodyNum;

    /** set 근태_마감처리여부 : dilnlazDdlnePrcsYn */
    private java.lang.String dilnlazDdlnePrcsYn;

    /** set 근태_비고내용 : dilnlazNoteCtnt */
    private java.lang.String dilnlazNoteCtnt;
    
	 /** 직종세통합코드 dtilOccuInttnCd */
     private java.lang.String dtilOccuInttnCd;

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

    /** set 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
    private java.lang.String dilnlazSpclHodyNumDys;

    /** set 총토요근무일수 : dilnlazSatDutyNumDys */
    private java.lang.String dilnlazSatDutyNumDys;

    /** set 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
    private java.lang.String dilnlazPubcHodyDutyNumDys;

    /** set 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
    private java.lang.String dilnlazAbnceDutyRcgtnDys;

    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;

    /** set 근태_총근무시간 : dilnlazTotDutyTm */
    private java.lang.String dilnlazTotDutyTm;

    /** set 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
    private java.lang.String dilnlazPaidHodyNumDys;

    /** set 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
    private java.lang.String dilnlazTfcAssCstNumDys;

    /** set 근태일 */
    private java.lang.String dilnlazApptnDt;

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

	public java.lang.String getDilnlazPaidHodyNumDys() {
        return dilnlazPaidHodyNumDys;
    }

    public void setDilnlazPaidHodyNumDys(java.lang.String dilnlazPaidHodyNumDys) {
        this.dilnlazPaidHodyNumDys = dilnlazPaidHodyNumDys;
    }

    public java.lang.String getDilnlazTfcAssCstNumDys() {
        return dilnlazTfcAssCstNumDys;
    }

    public void setDilnlazTfcAssCstNumDys(java.lang.String dilnlazTfcAssCstNumDys) {
        this.dilnlazTfcAssCstNumDys = dilnlazTfcAssCstNumDys;
    }

    public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public java.lang.String getDilnlazTotDutyTm() {
        return dilnlazTotDutyTm;
    }

    public void setDilnlazTotDutyTm(java.lang.String dilnlazTotDutyTm) {
        this.dilnlazTotDutyTm = dilnlazTotDutyTm;
    }

    public java.lang.String getDilnlazAbnceDutyRcgtnDys() {
        return dilnlazAbnceDutyRcgtnDys;
    }

    public void setDilnlazAbnceDutyRcgtnDys(java.lang.String dilnlazAbnceDutyRcgtnDys) {
        this.dilnlazAbnceDutyRcgtnDys = dilnlazAbnceDutyRcgtnDys;
    }

    public java.lang.String getDilnlazPubcHodyDutyNumDys() {
        return dilnlazPubcHodyDutyNumDys;
    }

    public void setDilnlazPubcHodyDutyNumDys(java.lang.String dilnlazPubcHodyDutyNumDys) {
        this.dilnlazPubcHodyDutyNumDys = dilnlazPubcHodyDutyNumDys;
    }

    public java.lang.String getDilnlazSatDutyNumDys() {
        return dilnlazSatDutyNumDys;
    }

    public void setDilnlazSatDutyNumDys(java.lang.String dilnlazSatDutyNumDys) {
        this.dilnlazSatDutyNumDys = dilnlazSatDutyNumDys;
    }

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDilnlazYrMnth() {
        return this.dilnlazYrMnth;
    }
    
    public void setDilnlazYrMnth(java.lang.String dilnlazYrMnth) {
        this.dilnlazYrMnth = dilnlazYrMnth;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getDilnlazDutyBgnnDt() {
        return this.dilnlazDutyBgnnDt;
    }
    
    public void setDilnlazDutyBgnnDt(java.lang.String dilnlazDutyBgnnDt) {
        this.dilnlazDutyBgnnDt = dilnlazDutyBgnnDt;
    }
    
    public java.lang.String getDilnlazDutyEndDt() {
        return this.dilnlazDutyEndDt;
    }
    
    public void setDilnlazDutyEndDt(java.lang.String dilnlazDutyEndDt) {
        this.dilnlazDutyEndDt = dilnlazDutyEndDt;
    }
    
    public java.lang.String getDilnlazDutyNumDys() {
        return this.dilnlazDutyNumDys;
    }
    
    public void setDilnlazDutyNumDys(java.lang.String dilnlazDutyNumDys) {
        this.dilnlazDutyNumDys = dilnlazDutyNumDys;
    }
    
    public java.lang.String getDilnlazLvsgNumDys() {
        return this.dilnlazLvsgNumDys;
    }
    
    public void setDilnlazLvsgNumDys(java.lang.String dilnlazLvsgNumDys) {
        this.dilnlazLvsgNumDys = dilnlazLvsgNumDys;
    }
    
    public java.lang.String getDilnlazAbnceNumDys() {
        return this.dilnlazAbnceNumDys;
    }
    
    public void setDilnlazAbnceNumDys(java.lang.String dilnlazAbnceNumDys) {
        this.dilnlazAbnceNumDys = dilnlazAbnceNumDys;
    }
    
    public java.lang.String getDilnlazSckleaNumDys() {
        return this.dilnlazSckleaNumDys;
    }
    
    public void setDilnlazSckleaNumDys(java.lang.String dilnlazSckleaNumDys) {
        this.dilnlazSckleaNumDys = dilnlazSckleaNumDys;
    }
    
    public java.lang.String getDilnlazOffvaNumDys() {
        return this.dilnlazOffvaNumDys;
    }
    
    public void setDilnlazOffvaNumDys(java.lang.String dilnlazOffvaNumDys) {
        this.dilnlazOffvaNumDys = dilnlazOffvaNumDys;
    }
    
    public java.lang.String getDilnlazFmlyEvntNumDys() {
        return this.dilnlazFmlyEvntNumDys;
    }
    
    public void setDilnlazFmlyEvntNumDys(java.lang.String dilnlazFmlyEvntNumDys) {
        this.dilnlazFmlyEvntNumDys = dilnlazFmlyEvntNumDys;
    }
    
    public java.lang.String getDilnlazHlthCreNumDys() {
        return this.dilnlazHlthCreNumDys;
    }
    
    public void setDilnlazHlthCreNumDys(java.lang.String dilnlazHlthCreNumDys) {
        this.dilnlazHlthCreNumDys = dilnlazHlthCreNumDys;
    }
    
    public java.lang.String getDilnlazTotDutyNumDys() {
        return this.dilnlazTotDutyNumDys;
    }
    
    public void setDilnlazTotDutyNumDys(java.lang.String dilnlazTotDutyNumDys) {
        this.dilnlazTotDutyNumDys = dilnlazTotDutyNumDys;
    }
    
    public java.lang.String getDilnlazWklyHldyNumDys() {
        return this.dilnlazWklyHldyNumDys;
    }
    
    public void setDilnlazWklyHldyNumDys(java.lang.String dilnlazWklyHldyNumDys) {
        this.dilnlazWklyHldyNumDys = dilnlazWklyHldyNumDys;
    }
    
    public java.lang.String getDilnlazPaidPubcHodyNum() {
        return this.dilnlazPaidPubcHodyNum;
    }
    
    public void setDilnlazPaidPubcHodyNum(java.lang.String dilnlazPaidPubcHodyNum) {
        this.dilnlazPaidPubcHodyNum = dilnlazPaidPubcHodyNum;
    }
    
    public java.lang.String getDilnlazDdlnePrcsYn() {
        return this.dilnlazDdlnePrcsYn;
    }
    
    public void setDilnlazDdlnePrcsYn(java.lang.String dilnlazDdlnePrcsYn) {
        this.dilnlazDdlnePrcsYn = dilnlazDdlnePrcsYn;
    }
    
    public java.lang.String getDilnlazNoteCtnt() {
        return this.dilnlazNoteCtnt;
    }
    
    public void setDilnlazNoteCtnt(java.lang.String dilnlazNoteCtnt) {
        this.dilnlazNoteCtnt = dilnlazNoteCtnt;
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
    
    public java.lang.String getDilnlazSpclHodyNumDys() {
        return this.dilnlazSpclHodyNumDys;
    }
    
    public void setDilnlazSpclHodyNumDys(java.lang.String dilnlazSpclHodyNumDys) {
        this.dilnlazSpclHodyNumDys = dilnlazSpclHodyNumDys;
    }

	public java.lang.String getDilnlazApptnDt() {
		return dilnlazApptnDt;
	}

	public void setDilnlazApptnDt(java.lang.String dilnlazApptnDt) {
		this.dilnlazApptnDt = dilnlazApptnDt;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
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
    
    
    
}
