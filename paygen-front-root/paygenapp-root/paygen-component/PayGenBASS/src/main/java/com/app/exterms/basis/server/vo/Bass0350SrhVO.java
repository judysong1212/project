package com.app.exterms.basis.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Bass0350DefaultVO.java
 * @Description : Bass0350 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0350SrhVO implements Serializable {

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
    
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** DTIL_OCCU_CLS_NM */
    private String dtilOccuClsNm;    
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCd;   

	/** DPOB_CD : 최상위코드 */
    private java.lang.String dpobCd;    
    
    /** DEPT_CD : 부서코드 */
    private java.lang.String deptCd;  
    
    private java.lang.String usrId;
    
    private java.lang.String dtilOccuClsUseYn;
    
    

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public String getDtilOccuClsNm() {
		return dtilOccuClsNm;
	}

	public void setDtilOccuClsNm(String dtilOccuClsNm) {
		this.dtilOccuClsNm = dtilOccuClsNm;
	}

	public java.lang.String getUsrId() {
		return usrId;
	}

	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	public java.lang.String getDtilOccuClsUseYn() {
		return dtilOccuClsUseYn;
	}

	public void setDtilOccuClsUseYn(java.lang.String dtilOccuClsUseYn) {
		this.dtilOccuClsUseYn = dtilOccuClsUseYn;
	}


}
