package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Class Name : Psnl0100DefaultVO.java
 * @Description : Psnl0100 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysIfHist0300SrhVO implements Serializable {
	
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
    
    /** rowCount */
    private String rowCount = "";
    
    /** currEntPage */
    private String currEntPage = "";
    
    /** set 화면명 : windowNm */
    private java.lang.String windowNm;

    /** set 화면아이디 : windowId */
    private java.lang.String windowId;
    
    
        
	public java.lang.String getWindowNm() {
		return windowNm;
	}

	public void setWindowNm(java.lang.String windowNm) {
		this.windowNm = windowNm;
	}

	public java.lang.String getWindowId() {
		return windowId;
	}

	public void setWindowId(java.lang.String windowId) {
		this.windowId = windowId;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public String getCurrEntPage() {
		return currEntPage;
	}

	public void setCurrEntPage(String currEntPage) {
		this.currEntPage = currEntPage;
	}

//	public void setUsrId(java.lang.String usrId) {
//		this.usrId = usrId;
//	}

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
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 에러발생년도 : errOccrrncYr */
    private java.lang.String errOccrrncYr;

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;

    /** set 에러일련번호 : errSeilNum */
    private java.math.BigDecimal errSeilNum;

    /** set 사용자접속구분코드 : usrConnectDivCd */
    private java.lang.String usrConnectDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사용자구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 사용자성명 : usrNm */
    private java.lang.String usrNm;

    /** set 에러발생일시 : errOccrrncDtntm */
    private java.lang.String errOccrrncDtntm;
    
    /** set 에러발생일시 : errOccrrncDtntm */
    private java.lang.String errOccrrncDtntmS;
    
    /** set 에러발생일시 : errOccrrncDtntm */
    private java.lang.String errOccrrncDtntmE;
    
    

    public java.lang.String getErrOccrrncDtntmS() {
		return errOccrrncDtntmS;
	}

	public void setErrOccrrncDtntmS(java.lang.String errOccrrncDtntmS) {
		this.errOccrrncDtntmS = errOccrrncDtntmS;
	}

	public java.lang.String getErrOccrrncDtntmE() {
		return errOccrrncDtntmE;
	}

	public void setErrOccrrncDtntmE(java.lang.String errOccrrncDtntmE) {
		this.errOccrrncDtntmE = errOccrrncDtntmE;
	}

	/** set 에러메소드명 : errEthdNm */
    private java.lang.String errEthdNm;

    /** set 에러명 : errNm */
    private java.lang.String errNm;

    /** set 에러내용 : errCtnt */
    private java.lang.String errCtnt;

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

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;


	/** systemkey - systemkey */
    private java.lang.String systemkey;
    
    

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getErrOccrrncYr() {
		return errOccrrncYr;
	}

	public void setErrOccrrncYr(java.lang.String errOccrrncYr) {
		this.errOccrrncYr = errOccrrncYr;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.math.BigDecimal getErrSeilNum() {
		return errSeilNum;
	}

	public void setErrSeilNum(java.math.BigDecimal errSeilNum) {
		this.errSeilNum = errSeilNum;
	}

	public java.lang.String getUsrConnectDivCd() {
		return usrConnectDivCd;
	}

	public void setUsrConnectDivCd(java.lang.String usrConnectDivCd) {
		this.usrConnectDivCd = usrConnectDivCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getUsrDivCd() {
		return usrDivCd;
	}

	public void setUsrDivCd(java.lang.String usrDivCd) {
		this.usrDivCd = usrDivCd;
	}

	public java.lang.String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(java.lang.String usrNm) {
		this.usrNm = usrNm;
	}

	public java.lang.String getErrOccrrncDtntm() {
		return errOccrrncDtntm;
	}

	public void setErrOccrrncDtntm(java.lang.String errOccrrncDtntm) {
		this.errOccrrncDtntm = errOccrrncDtntm;
	}

	public java.lang.String getErrEthdNm() {
		return errEthdNm;
	}

	public void setErrEthdNm(java.lang.String errEthdNm) {
		this.errEthdNm = errEthdNm;
	}

	public java.lang.String getErrNm() {
		return errNm;
	}

	public void setErrNm(java.lang.String errNm) {
		this.errNm = errNm;
	}

	public java.lang.String getErrCtnt() {
		return errCtnt;
	}

	public void setErrCtnt(java.lang.String errCtnt) {
		this.errCtnt = errCtnt;
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

	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

}
