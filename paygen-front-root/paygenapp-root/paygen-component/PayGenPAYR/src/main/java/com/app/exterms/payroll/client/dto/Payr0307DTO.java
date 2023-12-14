package com.app.exterms.payroll.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0307VO.java
 * @Description : Payr0307 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0307DTO implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    
    
    /** set 순번 : rnum */
    private java.lang.String rnum;
    
    
    public java.lang.String getRnum() {
		return rnum;
	}

	public void setRnum(java.lang.String rnum) {
		this.rnum = rnum;
	}
	
	
    /** set 데이터체크 : dataChk */
    private java.lang.String dataChk;
    
    

	public java.lang.String getDataChk() {
		return dataChk;
	}

	public void setDataChk(java.lang.String dataChk) {
		this.dataChk = dataChk;
	}


	/** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;
    
    /** set 급여구분코드 : payCdNm */
    private java.lang.String payCdNm;
    
    

    public java.lang.String getPayCdNm() {
		return payCdNm;
	}

	public void setPayCdNm(java.lang.String payCdNm) {
		this.payCdNm = payCdNm;
	}


	/** set 급여일련번호 : payrSeilNum */
    private Long payrSeilNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
    private Long mnthPayAdmntSeilNum;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;
    
    /** set 급여항목코드 : payItemCdNm */
    private java.lang.String payItemCdNm;
    

    public java.lang.String getPayItemCdNm() {
		return payItemCdNm;
	}

	public void setPayItemCdNm(java.lang.String payItemCdNm) {
		this.payItemCdNm = payItemCdNm;
	}


	/** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;
    
    /** set 지급공제구분코드 : pymtDducDivCdNm */
    private java.lang.String pymtDducDivCdNm;
    

    public java.lang.String getPymtDducDivCdNm() {
		return pymtDducDivCdNm;
	}

	public void setPymtDducDivCdNm(java.lang.String pymtDducDivCdNm) {
		this.pymtDducDivCdNm = pymtDducDivCdNm;
	}
	
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** secResnNum : 주민등록번호 원본*/
     private java.lang.String secResnNum;

    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;
    
    private java.lang.String deptCdNm;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    private java.lang.String businCdNm;

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    private java.lang.String typOccuCdNm;
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    private java.lang.String dtilOccuInttnCdNm;
    


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

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getDeptCdNm() {
		return deptCdNm;
	}

	public void setDeptCdNm(java.lang.String deptCdNm) {
		this.deptCdNm = deptCdNm;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getBusinCdNm() {
		return businCdNm;
	}

	public void setBusinCdNm(java.lang.String businCdNm) {
		this.businCdNm = businCdNm;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

	public java.lang.String getTypOccuCdNm() {
		return typOccuCdNm;
	}

	public void setTypOccuCdNm(java.lang.String typOccuCdNm) {
		this.typOccuCdNm = typOccuCdNm;
	}

	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getDtilOccuInttnCdNm() {
		return dtilOccuInttnCdNm;
	}

	public void setDtilOccuInttnCdNm(java.lang.String dtilOccuInttnCdNm) {
		this.dtilOccuInttnCdNm = dtilOccuInttnCdNm;
	}


	/** set 지급공제금액 : pymtDducSum */
    private Long pymtDducSum;

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    private Long pymtDducFreeDtySum;

    /** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
    private java.lang.String mnthPayAdmntAssoBssCtnt;

    /** set 월급여소급조정여부 : mnthPayAdmntYn */
    private Boolean mnthPayAdmntYn;
    
    /** set 월급여소급조정여부 : mnthPayAdmntYn */
    private String strMnthPayAdmntYn;
    
    

    public String getStrMnthPayAdmntYn() {
		return strMnthPayAdmntYn;
	}

	public void setStrMnthPayAdmntYn(String strMnthPayAdmntYn) {
		this.strMnthPayAdmntYn = strMnthPayAdmntYn;
	}


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

    /** set null : pymtDducTxtnAmnt */
    private Long pymtDducTxtnAmnt;

     
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
     
    
    
    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public Long getPymtDducTxtnAmnt() {
        return pymtDducTxtnAmnt;
    }

    public void setPymtDducTxtnAmnt(Long pymtDducTxtnAmnt) {
        this.pymtDducTxtnAmnt = pymtDducTxtnAmnt;
    }

    public java.lang.String getPymtYrMnth() {
        return this.pymtYrMnth;
    }
    
    public void setPymtYrMnth(java.lang.String pymtYrMnth) {
        this.pymtYrMnth = pymtYrMnth;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    public Long getPymtDducFreeDtySum() {
        return this.pymtDducFreeDtySum;
    }
    
    public void setPymtDducFreeDtySum(Long pymtDducFreeDtySum) {
        this.pymtDducFreeDtySum = pymtDducFreeDtySum;
    }
    
    public Long getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(Long pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getMnthPayAdmntAssoBssCtnt() {
        return this.mnthPayAdmntAssoBssCtnt;
    }
    
    public void setMnthPayAdmntAssoBssCtnt(java.lang.String mnthPayAdmntAssoBssCtnt) {
        this.mnthPayAdmntAssoBssCtnt = mnthPayAdmntAssoBssCtnt;
    }
    
  
    
    public Boolean getMnthPayAdmntYn() {
        return mnthPayAdmntYn;
    }

    public void setMnthPayAdmntYn(Boolean mnthPayAdmntYn) {
        this.mnthPayAdmntYn = mnthPayAdmntYn;
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
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public Long getPayrSeilNum() {
        return this.payrSeilNum;
    }
    
    public void setPayrSeilNum(Long payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }
    
    public Long getMnthPayAdmntSeilNum() {
        return this.mnthPayAdmntSeilNum;
    }
    
    public void setMnthPayAdmntSeilNum(Long mnthPayAdmntSeilNum) {
        this.mnthPayAdmntSeilNum = mnthPayAdmntSeilNum;
    }
    
}
