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
public class SysIfHist0200SrhVO implements Serializable {
	
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
    
    // 점검내역 추가_hieju 08.01
    
    private java.lang.String tablespacenm;
    
    private java.lang.String filenm;
    
    private java.lang.String bytesb;
    
    private int bytes;
    
    private java.lang.String free;
    
    private java.lang.String percentage;
    
    private int fileid;
    
    // 끝
    
        
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

    /** set 사용자작업년도 : usrJobYr */
    private java.lang.String usrJobYr;

    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;

    /** set 사용자작업일련번호 : usrJobSeilNum */
    private java.math.BigDecimal usrJobSeilNum;

    /** set 사용자접속구분코드 : usrConnectDivCd */
    private java.lang.String usrConnectDivCd;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사용자구분코드 : usrDivCd */
    private java.lang.String usrDivCd;

    /** set 사용자성명 : usrNm */
    private java.lang.String usrNm;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사용자작업일시 : usrJobDtntm */
    private java.lang.String usrJobDtntm;

    /** set 사용자작업구분코드 : usrJobSeptDivCd */
    private java.lang.String usrJobSeptDivCd;

    /** set 사용자작업메소드명 : usrJobEthdNm */
    private java.lang.String usrJobEthdNm;

    /** set 사용자작업시작일시 : usrJobBgnnTm */
    private java.lang.String usrJobBgnnTm;

    /** set 사용자작업종료일시 : usrJobEndTm */
    private java.lang.String usrJobEndTm;

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



	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getUsrJobYr() {
		return usrJobYr;
	}

	public void setUsrJobYr(java.lang.String usrJobYr) {
		this.usrJobYr = usrJobYr;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.math.BigDecimal getUsrJobSeilNum() {
		return usrJobSeilNum;
	}

	public void setUsrJobSeilNum(java.math.BigDecimal usrJobSeilNum) {
		this.usrJobSeilNum = usrJobSeilNum;
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

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getUsrJobDtntm() {
		return usrJobDtntm;
	}

	public void setUsrJobDtntm(java.lang.String usrJobDtntm) {
		this.usrJobDtntm = usrJobDtntm;
	}

	public java.lang.String getUsrJobSeptDivCd() {
		return usrJobSeptDivCd;
	}

	public void setUsrJobSeptDivCd(java.lang.String usrJobSeptDivCd) {
		this.usrJobSeptDivCd = usrJobSeptDivCd;
	}

	public java.lang.String getUsrJobEthdNm() {
		return usrJobEthdNm;
	}

	public void setUsrJobEthdNm(java.lang.String usrJobEthdNm) {
		this.usrJobEthdNm = usrJobEthdNm;
	}

	public java.lang.String getUsrJobBgnnTm() {
		return usrJobBgnnTm;
	}

	public void setUsrJobBgnnTm(java.lang.String usrJobBgnnTm) {
		this.usrJobBgnnTm = usrJobBgnnTm;
	}

	public java.lang.String getUsrJobEndTm() {
		return usrJobEndTm;
	}

	public void setUsrJobEndTm(java.lang.String usrJobEndTm) {
		this.usrJobEndTm = usrJobEndTm;
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
	
	// 점검내역 추가_hieju 08.01

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public java.lang.String getFree() {
		return free;
	}

	public void setFree(java.lang.String free) {
		this.free = free;
	}

	public java.lang.String getBytesb() {
		return bytesb;
	}

	public void setBytesb(java.lang.String bytesb) {
		this.bytesb = bytesb;
	}

	public java.lang.String getTablespacenm() {
		return tablespacenm;
	}

	public void setTablespacenm(java.lang.String tablespacenm) {
		this.tablespacenm = tablespacenm;
	}

	public java.lang.String getFilenm() {
		return filenm;
	}

	public void setFilenm(java.lang.String filenm) {
		this.filenm = filenm;
	}

	public java.lang.String getPercentage() {
		return percentage;
	}

	public void setPercentage(java.lang.String percentage) {
		this.percentage = percentage;
	}

	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}



}
