package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0520DefaultVO.java
 * @Description : Payr0520 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0520SrhVO implements Serializable {
	
	 
    
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
    
    
    /** payYr */
   private java.lang.String payYr;   //기준년도  
    
      
    /** 부서코드 - DEPT_CD */
    private List<String> deptCdArr;
    private java.lang.String payrMangDeptYn ; //단위기관담당자여부 처리를 위한 부분 
    
    private java.lang.String  payrMangDeptCd;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String pymtDducDivCd;
    
    /** 제외여부 포함 (현재일자기준,종료포함) */
    private java.lang.String dataStatus; 
     
    /** 부서코드 - DEPT_CD */
    private java.lang.String deptCd;
    
    /** 관리부서코드 - mangeDeptCd */
    private java.lang.String mangeDeptCd;
    
    /** 고용구분코드 EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** HAN_NM */
    private java.lang.String hanNm;

    /** 직종구분코드 */
    private java.lang.String typOccuCd;
    
    /** BUSIN_APPTN_YR 사업년도 */
    private java.lang.String businApptnYr;
    
    /** 호봉등급코드 */
    private java.lang.String pyspGrdeCd;
    
    /** RESN_REGN_NUM */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** BUSIN_CD 사업코드 */
    private java.lang.String businCd;
    
    /** PYMT_DT 지급일자  */
    private java.lang.String pymtDt;
   

    /**공제코드  DDUC_DIV_CD */
   private java.lang.String dducDivCd;
   

   private java.lang.String  dtilOccuClsDivCd; //직종세
   

   /** TYP_OCCU_CD */
   private List<String> typOccuCdArr;  //스트링 값에 여러건을 넘기기의한 값
   
   /** pyspGrdeCd */
   private List<String> pyspGrdeCdArr; //스트링 값에 여러건을 넘기기의한 값
   
   private List<String> dtilOccuClsDivCdArr; //스트링 값에 여러건을 넘기기의한 값
     
   private List<String> pymtDducDivCdArr; //스트링 값에 여러건을 넘기기의한 값
   
   
    
	public List<String> getPymtDducDivCdArr() {
	return pymtDducDivCdArr;
}

public void setPymtDducDivCdArr(List<String> pymtDducDivCdArr) {
	this.pymtDducDivCdArr = pymtDducDivCdArr;
}

	public java.lang.String getPayYr() {
    return payYr;
}

public void setPayYr(java.lang.String payYr) {
    this.payYr = payYr;
}

    public java.lang.String getPayrMangDeptCd() {
    return payrMangDeptCd;
}

public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
    this.payrMangDeptCd = payrMangDeptCd;
}

    public List<String> getTypOccuCdArr() {
    return typOccuCdArr;
}

public void setTypOccuCdArr(List<String> typOccuCdArr) {
    this.typOccuCdArr = typOccuCdArr;
}

public List<String> getPyspGrdeCdArr() {
    return pyspGrdeCdArr;
}

public void setPyspGrdeCdArr(List<String> pyspGrdeCdArr) {
    this.pyspGrdeCdArr = pyspGrdeCdArr;
}

public List<String> getDtilOccuClsDivCdArr() {
    return dtilOccuClsDivCdArr;
}

public void setDtilOccuClsDivCdArr(List<String> dtilOccuClsDivCdArr) {
    this.dtilOccuClsDivCdArr = dtilOccuClsDivCdArr;
}

    public List<String> getDeptCdArr() {
    return deptCdArr;
}

public void setDeptCdArr(List<String> deptCdArr) {
    this.deptCdArr = deptCdArr;
}

public java.lang.String getPayrMangDeptYn() {
    return payrMangDeptYn;
}

public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
    this.payrMangDeptYn = payrMangDeptYn;
}

    public java.lang.String getDtilOccuClsDivCd() {
    return dtilOccuClsDivCd;
}

public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
    this.dtilOccuClsDivCd = dtilOccuClsDivCd;
}

    public java.lang.String getPayItemCd() {
        return payItemCd;
    }

    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }

    public java.lang.String getDducDivCd() {
        return dducDivCd;
    }

    public void setDducDivCd(java.lang.String dducDivCd) {
        this.dducDivCd = dducDivCd;
    }

    public java.lang.String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(java.lang.String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public java.lang.String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }

    public java.lang.String getMangeDeptCd() {
        return mangeDeptCd;
    }

    public void setMangeDeptCd(java.lang.String mangeDeptCd) {
        this.mangeDeptCd = mangeDeptCd;
    }

    public java.lang.String getEmymtDivCd() {
        return emymtDivCd;
    }

    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }

    public java.lang.String getHanNm() {
        return hanNm;
    }

    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }

    public java.lang.String getTypOccuCd() {
        return typOccuCd;
    }

    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }

    public java.lang.String getBusinApptnYr() {
        return businApptnYr;
    }

    public void setBusinApptnYr(java.lang.String businApptnYr) {
        this.businApptnYr = businApptnYr;
    }

    public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public java.lang.String getResnRegnNum() {
        return resnRegnNum;
    }

    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }

    public java.lang.String getBusinCd() {
        return businCd;
    }

    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }

    public java.lang.String getPymtDt() {
        return pymtDt;
    }

    public void setPymtDt(java.lang.String pymtDt) {
        this.pymtDt = pymtDt;
    }

    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }

    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

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

}
