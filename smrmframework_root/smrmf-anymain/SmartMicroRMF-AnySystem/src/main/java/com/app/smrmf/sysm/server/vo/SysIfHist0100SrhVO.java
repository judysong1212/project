package com.app.smrmf.sysm.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class SysIfHist0100SrhVO implements Serializable {
	
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

    /** set 사용자접속년도 : usrConnectYr */
    private java.lang.String usrConnectYr;

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
    /** set systemkey : systemkey */
    private java.lang.String systemkey;
    
    

    public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}


	/** set 사용자접속일련번호 : usrConnectSeilNum */
    private java.math.BigDecimal usrConnectSeilNum;

    /** set 사용자접속구분코드 : usrConnectDivCd */
    private java.lang.String usrConnectDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사용자구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 사용자성명 : usrNm */
    private java.lang.String usrNm;

    /** set 사용자접속시작일시 : usrConnectBgnnDtntm */
    private java.lang.String usrConnectBgnnDtntm;

    /** set 사용자접속종료일시 : usrConnectEndDtntm */
    private java.lang.String usrConnectEndDtntm;

    /** set SESSIONKEY : sessionkey */
    private java.lang.String sessionkey;

	/** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    
    


    public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getUsrConnectYr() {
		return usrConnectYr;
	}

	public void setUsrConnectYr(java.lang.String usrConnectYr) {
		this.usrConnectYr = usrConnectYr;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.math.BigDecimal getUsrConnectSeilNum() {
		return usrConnectSeilNum;
	}

	public void setUsrConnectSeilNum(java.math.BigDecimal usrConnectSeilNum) {
		this.usrConnectSeilNum = usrConnectSeilNum;
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

	public java.lang.String getUsrConnectBgnnDtntm() {
		return usrConnectBgnnDtntm;
	}

	public void setUsrConnectBgnnDtntm(java.lang.String usrConnectBgnnDtntm) {
		this.usrConnectBgnnDtntm = usrConnectBgnnDtntm;
	}

	public java.lang.String getUsrConnectEndDtntm() {
		return usrConnectEndDtntm;
	}

	public void setUsrConnectEndDtntm(java.lang.String usrConnectEndDtntm) {
		this.usrConnectEndDtntm = usrConnectEndDtntm;
	}

	public java.lang.String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(java.lang.String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public List<String> getDeptCdArr() {
		return deptCdArr;
	}

	public void setDeptCdArr(List<String> deptCdArr) {
		this.deptCdArr = deptCdArr;
	}

	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
