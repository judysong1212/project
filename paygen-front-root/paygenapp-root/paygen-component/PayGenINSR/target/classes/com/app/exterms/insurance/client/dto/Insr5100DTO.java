package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Insr5100VO.java
 * @Description : Insr5100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr5100DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	 

	/** set 고용일련번호 : emymtSeilNum */
	private Long emymtSeilNum;

	/** set 사대보험공제방식코드 : socInsrDducEthdCd */
	private java.lang.String socInsrDducEthdCd;

	/** set 고용보험취득일자 : umytInsrAqtnDt */
	private java.lang.String umytInsrAqtnDt;

	/** set 고용보험상실일자 : umytInsrLssDt */
	private java.lang.String umytInsrLssDt;

	/** set 고용보험제외여부 : umytInsrEepnYn */
	private Boolean umytInsrEepnYn;

	/** set 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	private java.lang.String umytInsrEepnReasCtnt;

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

	/** set 고용보험변동일자 : umytInsrFlucDt */
	private java.lang.String umytInsrFlucDt;

	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	private Long umytInsrPayTotAmnt;

	/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
	private Long umytInsrPayMnthAmnt;

	/** set 고용보험적용여부 : umytInsrApptnYn */
	 private Boolean  umytInsrApptnYn;
    
	 
	 
    public java.lang.String getUmytInsrFlucDt() {
		return umytInsrFlucDt;
	}

	public void setUmytInsrFlucDt(java.lang.String umytInsrFlucDt) {
		this.umytInsrFlucDt = umytInsrFlucDt;
	}

	public Long getUmytInsrPayTotAmnt() {
		return umytInsrPayTotAmnt;
	}

	public void setUmytInsrPayTotAmnt(Long umytInsrPayTotAmnt) {
		this.umytInsrPayTotAmnt = umytInsrPayTotAmnt;
	}

	public Long getUmytInsrPayMnthAmnt() {
		return umytInsrPayMnthAmnt;
	}

	public void setUmytInsrPayMnthAmnt(Long umytInsrPayMnthAmnt) {
		this.umytInsrPayMnthAmnt = umytInsrPayMnthAmnt;
	}

	public Boolean getUmytInsrApptnYn() {
		return umytInsrApptnYn;
	}

	public void setUmytInsrApptnYn(Boolean umytInsrApptnYn) {
		this.umytInsrApptnYn = umytInsrApptnYn;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
     
    
    public Long getEmymtSeilNum() {
        return this.emymtSeilNum;
    }
    
    public void setEmymtSeilNum(Long emymtSeilNum) {
        this.emymtSeilNum = emymtSeilNum;
    }
    
    public java.lang.String getSocInsrDducEthdCd() {
        return this.socInsrDducEthdCd;
    }
    
    public void setSocInsrDducEthdCd(java.lang.String socInsrDducEthdCd) {
        this.socInsrDducEthdCd = socInsrDducEthdCd;
    }
    
    public java.lang.String getUmytInsrAqtnDt() {
        return this.umytInsrAqtnDt;
    }
    
    public void setUmytInsrAqtnDt(java.lang.String umytInsrAqtnDt) {
        this.umytInsrAqtnDt = umytInsrAqtnDt;
    }
    
    public java.lang.String getUmytInsrLssDt() {
        return this.umytInsrLssDt;
    }
    
    public void setUmytInsrLssDt(java.lang.String umytInsrLssDt) {
        this.umytInsrLssDt = umytInsrLssDt;
    }
    
   
    
    public Boolean getUmytInsrEepnYn() {
		return umytInsrEepnYn;
	}

	public void setUmytInsrEepnYn(Boolean umytInsrEepnYn) {
		this.umytInsrEepnYn = umytInsrEepnYn;
	}

	public java.lang.String getUmytInsrEepnReasCtnt() {
        return this.umytInsrEepnReasCtnt;
    }
    
    public void setUmytInsrEepnReasCtnt(java.lang.String umytInsrEepnReasCtnt) {
        this.umytInsrEepnReasCtnt = umytInsrEepnReasCtnt;
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
    
}
