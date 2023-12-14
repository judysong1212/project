package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Payr0307VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pymtYrMnth */
    private java.lang.String pymtYrMnth;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;
    
    /** set 급여구분코드 : payCd */
    private java.lang.String payCdNm;
    

    public java.lang.String getPayCdNm() {
		return payCdNm;
	}

	public void setPayCdNm(java.lang.String payCdNm) {
		this.payCdNm = payCdNm;
	}


	/** set 급여일련번호 : payrSeilNum */
    private java.math.BigDecimal payrSeilNum;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
    private java.math.BigDecimal mnthPayAdmntSeilNum;

    /** set 급여항목코드 : payItemCd */
    private java.lang.String payItemCd;
    
    private java.lang.String payItemCdNm;
    

    public java.lang.String getPayItemCdNm() {
		return payItemCdNm;
	}

	public void setPayItemCdNm(java.lang.String payItemCdNm) {
		this.payItemCdNm = payItemCdNm;
	}


	/** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;
    
    private java.lang.String pymtDducDivCdNm;
    
    

    public java.lang.String getPymtDducDivCdNm() {
		return pymtDducDivCdNm;
	}

	public void setPymtDducDivCdNm(java.lang.String pymtDducDivCdNm) {
		this.pymtDducDivCdNm = pymtDducDivCdNm;
	}


	/** set 지급공제금액 : pymtDducSum */
    private java.math.BigDecimal pymtDducSum;

    /** set 지급공제비과세금액 : pymtDducFreeDtySum */
    private java.math.BigDecimal pymtDducFreeDtySum;

    /** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
    private java.lang.String mnthPayAdmntAssoBssCtnt;

    /** set 월급여소급조정여부 : mnthPayAdmntYn */
    private java.lang.String mnthPayAdmntYn;

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

    /** set 지급공제과세금액 : pymtDducTxtnAmnt */
    private java.math.BigDecimal pymtDducTxtnAmnt;

     
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    
    
    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.math.BigDecimal getPymtDducTxtnAmnt() {
        return pymtDducTxtnAmnt;
    }

    public void setPymtDducTxtnAmnt(java.math.BigDecimal pymtDducTxtnAmnt) {
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
    
    public BigDecimal getPymtDducFreeDtySum() {
        return this.pymtDducFreeDtySum;
    }
    
    public void setPymtDducFreeDtySum(BigDecimal pymtDducFreeDtySum) {
        this.pymtDducFreeDtySum = pymtDducFreeDtySum;
    }
    
    public BigDecimal getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(BigDecimal pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getMnthPayAdmntAssoBssCtnt() {
        return this.mnthPayAdmntAssoBssCtnt;
    }
    
    public void setMnthPayAdmntAssoBssCtnt(java.lang.String mnthPayAdmntAssoBssCtnt) {
        this.mnthPayAdmntAssoBssCtnt = mnthPayAdmntAssoBssCtnt;
    }
    
    public java.lang.String getMnthPayAdmntYn() {
        return this.mnthPayAdmntYn;
    }
    
    public void setMnthPayAdmntYn(java.lang.String mnthPayAdmntYn) {
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
    
    public BigDecimal getPayrSeilNum() {
        return this.payrSeilNum;
    }
    
    public void setPayrSeilNum(BigDecimal payrSeilNum) {
        this.payrSeilNum = payrSeilNum;
    }
    
    public BigDecimal getMnthPayAdmntSeilNum() {
        return this.mnthPayAdmntSeilNum;
    }
    
    public void setMnthPayAdmntSeilNum(BigDecimal mnthPayAdmntSeilNum) {
        this.mnthPayAdmntSeilNum = mnthPayAdmntSeilNum;
    }
    
    
    //Payr304
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

    
}
