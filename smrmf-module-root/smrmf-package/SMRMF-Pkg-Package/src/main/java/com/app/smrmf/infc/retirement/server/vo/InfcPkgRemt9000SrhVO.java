package com.app.smrmf.infc.retirement.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Remt9000DefaultVO.java
 * @Description : Remt9000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgRemt9000SrhVO implements Serializable {
	 
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
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    private java.lang.String sevePayClutMangeNum;
 
    
   /** calcSevePayPsnDivCd */
   private java.lang.String calcSevePayPsnDivCd;
   
   /** EMYMT_DIV_CD */
   private java.lang.String emymtDivCd;
    

   /** TYP_OCCU_CD */
   private java.lang.String typOccuCd;
   
   /** PYSP_GRDE_CD */
   private java.lang.String pyspGrdeCd;
    
   /** DEPT_CD */
   private java.lang.String deptCd;
   
   /** BUSIN_CD */
   private java.lang.String businCd;
    
   /**  작업년 calcSevePayPsnBlggYr */
   private java.lang.String calcSevePayPsnBlggYr;
    
   
   /** HAN_NM */
   private java.lang.String hanNm;

   /** RESN_REGN_NUM */
   private java.lang.String resnRegnNum;
    
   /** secResnNum : 주민등록번호 원본*/
   private java.lang.String secResnNum;
   
   
        
	/**
 * Comment : 
 * @fn java.lang.String getSecResnNum()
 * @brief date:2016 2016. 6. 24. user:Administrator
 * @return the secResnNum get
 */
public java.lang.String getSecResnNum() {
	return secResnNum;
}

/**
 * Comment : 
 *@fn void setSecResnNum(java.lang.String secResnNum)
 *@brief date:2016 2016. 6. 24. user:Administrator
 *@param secResnNum the secResnNum to set
 */
public void setSecResnNum(java.lang.String secResnNum) {
	this.secResnNum = secResnNum;
}

	public java.lang.String getCalcSevePayPsnDivCd() {
    return calcSevePayPsnDivCd;
}

public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
    this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
}

public java.lang.String getEmymtDivCd() {
    return emymtDivCd;
}

public void setEmymtDivCd(java.lang.String emymtDivCd) {
    this.emymtDivCd = emymtDivCd;
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

public java.lang.String getDeptCd() {
    return deptCd;
}

public void setDeptCd(java.lang.String deptCd) {
    this.deptCd = deptCd;
}

public java.lang.String getBusinCd() {
    return businCd;
}

public void setBusinCd(java.lang.String businCd) {
    this.businCd = businCd;
}

public java.lang.String getCalcSevePayPsnBlggYr() {
    return calcSevePayPsnBlggYr;
}

public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
    this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
}

public java.lang.String getHanNm() {
    return hanNm;
}

public void setHanNm(java.lang.String hanNm) {
    this.hanNm = hanNm;
}

public java.lang.String getResnRegnNum() {
    return resnRegnNum;
}

public void setResnRegnNum(java.lang.String resnRegnNum) {
    this.resnRegnNum = resnRegnNum;
}

    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    public java.lang.String getSevePayClutMangeNum() {
        return sevePayClutMangeNum;
    }

    public void setSevePayClutMangeNum(java.lang.String sevePayClutMangeNum) {
        this.sevePayClutMangeNum = sevePayClutMangeNum;
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
