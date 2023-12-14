package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0302DefaultVO.java
 * @Description : Payr0302 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0302SrhVO implements Serializable {
	 
    
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
    
	 /** DPOB_CD */
    private java.lang.String dpobCd; 
    
    /** PYMT_YR_MNTH */
    private java.lang.String pymtYrMnth;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    /** PAYR_SEIL_NUM */
    private BigDecimal payrSeilNum;
    
    /** PAY_ITEM_SEIL_NUM */
    private BigDecimal payItemSeilNum;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String pymtDducDivCd;
    
       
	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getPayrMangDeptCd() {
		return payrMangDeptCd;
	}

	public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
		this.payrMangDeptCd = payrMangDeptCd;
	}

	public BigDecimal getPayrSeilNum() {
		return payrSeilNum;
	}

	public void setPayrSeilNum(BigDecimal payrSeilNum) {
		this.payrSeilNum = payrSeilNum;
	}

	public BigDecimal getPayItemSeilNum() {
		return payItemSeilNum;
	}

	public void setPayItemSeilNum(BigDecimal payItemSeilNum) {
		this.payItemSeilNum = payItemSeilNum;
	}

	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
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
