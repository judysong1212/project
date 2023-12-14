package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0440DefaultVO.java
 * @Description : Payr0440 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0440SrhVO implements Serializable {
    
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

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private java.math.BigDecimal typOccuGrdeMppgSeilNum;
 
    /** set 급여항목일련번호 : payrItemSeilNum */
    private java.math.BigDecimal payrItemSeilNum;
 
   /** 급여년도  PAY_YR */
   private java.lang.String payYr;
   
   /** 직종코드 TYP_OCCU_CD */
   private java.lang.String typOccuCd;
   
   /** 호봉등급코드 PYSP_GRDE_CD */
   private java.lang.String pyspGrdeCd;
     
   /** 산정일자 OCCU_CLSS_PAY_CMPTTN_STD */
   private java.lang.String occuClssPayCmpttnStd;
   
   
   /** 직종세코드 DTIL_OCCU_CLS_DIV_CD */
   private java.lang.String dtilOccuClsDivCd;
    

   /** 단위기관코드  PAYR_MANG_DEPT_CD */
   private java.lang.String payrMangDeptCd;
   
   /** 호봉승급코드  pyspLogSvcYrNumCd */
   private java.lang.String pyspLogSvcYrNumCd;
   
   
public java.math.BigDecimal getPayrItemSeilNum() {
    return payrItemSeilNum;
}

public void setPayrItemSeilNum(java.math.BigDecimal payrItemSeilNum) {
    this.payrItemSeilNum = payrItemSeilNum;
}

public java.math.BigDecimal getTypOccuGrdeMppgSeilNum() {
    return typOccuGrdeMppgSeilNum;
}

public void setTypOccuGrdeMppgSeilNum(java.math.BigDecimal typOccuGrdeMppgSeilNum) {
    this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
}

public java.lang.String getPyspLogSvcYrNumCd() {
	return pyspLogSvcYrNumCd;
}

public void setPyspLogSvcYrNumCd(java.lang.String pyspLogSvcYrNumCd) {
	this.pyspLogSvcYrNumCd = pyspLogSvcYrNumCd;
}

	public java.lang.String getPayrMangDeptCd() {
	return payrMangDeptCd;
}

public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
	this.payrMangDeptCd = payrMangDeptCd;
}
 

	public java.lang.String getPayYr() {
	return payYr;
}

public void setPayYr(java.lang.String payYr) {
	this.payYr = payYr;
}

public java.lang.String getTypOccuCd() {
	return typOccuCd;
}

public void setTypOccuCd(java.lang.String typOccuCd) {
	this.typOccuCd = typOccuCd;
}

public java.lang.String getPyspGrdeCd() {
	return pyspGrdeCd;
}

public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
	this.pyspGrdeCd = pyspGrdeCd;
}

public java.lang.String getOccuClssPayCmpttnStd() {
	return occuClssPayCmpttnStd;
}

public void setOccuClssPayCmpttnStd(java.lang.String occuClssPayCmpttnStd) {
	this.occuClssPayCmpttnStd = occuClssPayCmpttnStd;
}

public java.lang.String getDtilOccuClsDivCd() {
	return dtilOccuClsDivCd;
}

public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
	this.dtilOccuClsDivCd = dtilOccuClsDivCd;
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
