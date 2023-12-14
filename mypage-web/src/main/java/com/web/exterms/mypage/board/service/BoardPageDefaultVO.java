package com.web.exterms.mypage.board.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bord0300DefaultVO.java
 * @Description : Bord0300 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BoardPageDefaultVO implements Serializable {
	
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
    

    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** BULL_BORD_MSGE_SEIL_NUM */
    private java.math.BigDecimal bullBordMsgeSeilNum;
    
    /** BULL_BORD_UID */
    private java.lang.String bullBordUid;
    
    /** BULL_BORD_GRP_ID */
    private java.math.BigDecimal bullBordGrpId;
    
    
        
	public java.lang.String getSysDivCd() {
        return sysDivCd;
    }

    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }

    public java.math.BigDecimal getBullBordMsgeSeilNum() {
        return bullBordMsgeSeilNum;
    }

    public void setBullBordMsgeSeilNum(java.math.BigDecimal bullBordMsgeSeilNum) {
        this.bullBordMsgeSeilNum = bullBordMsgeSeilNum;
    }

    public java.lang.String getBullBordUid() {
        return bullBordUid;
    }

    public void setBullBordUid(java.lang.String bullBordUid) {
        this.bullBordUid = bullBordUid;
    }

    public java.math.BigDecimal getBullBordGrpId() {
        return bullBordGrpId;
    }

    public void setBullBordGrpId(java.math.BigDecimal bullBordGrpId) {
        this.bullBordGrpId = bullBordGrpId;
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
