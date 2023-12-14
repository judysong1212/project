package com.app.exterms.retirement.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Remt9000VO.java
 * @Description : Remt9000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt9000DTO  implements IsSerializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
    private java.lang.String sevePayClutMangeNum;

    /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
    private java.lang.String calcSevePayPsnBlggYr;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set 입사일자 : icncDt */
    private java.lang.String icncDt;

    /** set 기산일자 : rkfcdDt */
    private java.lang.String rkfcdDt;

    /** set 퇴사일자 : rsgtnDt */
    private java.lang.String rsgtnDt;

    /** set 지급일자 : pymtDt */
    private java.lang.String pymtDt;

    /** set 제외월수_2012이전 : eepnMnthIcm2012Bfr */
    private Long eepnMnthIcm2012Bfr;

    /** set 제외월수_2013이후 : eepnMnthIcm2013Aft */
    private Long eepnMnthIcm2013Aft;

    /** set 가산월수_2012이전 : addMnthIcm2012Bfr */
    private Long addMnthIcm2012Bfr;

    /** set 가산월수_2013이후 : addMnthIcm2013Aft */
    private Long addMnthIcm2013Aft;

    /** set 퇴직급여액 : retryPayQnty */
    private Long retryPayQnty;

    /** set 비과세퇴직급여액 : freeDtyRetryPayQnty */
    private Long freeDtyRetryPayQnty;

    /** set 기납부소득세 : alpayTxAmnt */
    private Long alpayTxAmnt;

    /** set 지방소득세 : locIncmTxAmt */
    private Long locIncmTxAmt;

    /** set 차인지급액 : pernPymtSum */
    private Long pernPymtSum;

    /** set 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
    private java.lang.String sevePayCtrClutNoteCtnt;

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
    

/** set 군경력정산포함여부 : amcrrClutInsnYn */
private Boolean amcrrClutInsnYn;
  

    
    public Boolean getAmcrrClutInsnYn() {
	return amcrrClutInsnYn;
}

public void setAmcrrClutInsnYn(Boolean amcrrClutInsnYn) {
	this.amcrrClutInsnYn = amcrrClutInsnYn;
}

	public Long getEepnMnthIcm2012Bfr() {
		return eepnMnthIcm2012Bfr;
	}

	public void setEepnMnthIcm2012Bfr(Long eepnMnthIcm2012Bfr) {
		this.eepnMnthIcm2012Bfr = eepnMnthIcm2012Bfr;
	}

	public Long getEepnMnthIcm2013Aft() {
		return eepnMnthIcm2013Aft;
	}

	public void setEepnMnthIcm2013Aft(Long eepnMnthIcm2013Aft) {
		this.eepnMnthIcm2013Aft = eepnMnthIcm2013Aft;
	}

	public Long getAddMnthIcm2012Bfr() {
		return addMnthIcm2012Bfr;
	}

	public void setAddMnthIcm2012Bfr(Long addMnthIcm2012Bfr) {
		this.addMnthIcm2012Bfr = addMnthIcm2012Bfr;
	}

	public Long getAddMnthIcm2013Aft() {
		return addMnthIcm2013Aft;
	}

	public void setAddMnthIcm2013Aft(Long addMnthIcm2013Aft) {
		this.addMnthIcm2013Aft = addMnthIcm2013Aft;
	}

	public Long getRetryPayQnty() {
		return retryPayQnty;
	}

	public void setRetryPayQnty(Long retryPayQnty) {
		this.retryPayQnty = retryPayQnty;
	}

	public Long getFreeDtyRetryPayQnty() {
		return freeDtyRetryPayQnty;
	}

	public void setFreeDtyRetryPayQnty(Long freeDtyRetryPayQnty) {
		this.freeDtyRetryPayQnty = freeDtyRetryPayQnty;
	}

	public Long getAlpayTxAmnt() {
		return alpayTxAmnt;
	}

	public void setAlpayTxAmnt(Long alpayTxAmnt) {
		this.alpayTxAmnt = alpayTxAmnt;
	}

	public Long getLocIncmTxAmt() {
		return locIncmTxAmt;
	}

	public void setLocIncmTxAmt(Long locIncmTxAmt) {
		this.locIncmTxAmt = locIncmTxAmt;
	}

	public Long getPernPymtSum() {
		return pernPymtSum;
	}

	public void setPernPymtSum(Long pernPymtSum) {
		this.pernPymtSum = pernPymtSum;
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
    
    public java.lang.String getSevePayClutMangeNum() {
        return this.sevePayClutMangeNum;
    }
    
    public void setSevePayClutMangeNum(java.lang.String sevePayClutMangeNum) {
        this.sevePayClutMangeNum = sevePayClutMangeNum;
    }
    
    public java.lang.String getCalcSevePayPsnBlggYr() {
        return this.calcSevePayPsnBlggYr;
    }
    
    public void setCalcSevePayPsnBlggYr(java.lang.String calcSevePayPsnBlggYr) {
        this.calcSevePayPsnBlggYr = calcSevePayPsnBlggYr;
    }
    
    public java.lang.String getCalcSevePayPsnDivCd() {
        return this.calcSevePayPsnDivCd;
    }
    
    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
    }
    
    public java.lang.String getIcncDt() {
        return this.icncDt;
    }
    
    public void setIcncDt(java.lang.String icncDt) {
        this.icncDt = icncDt;
    }
    
    public java.lang.String getRkfcdDt() {
        return this.rkfcdDt;
    }
    
    public void setRkfcdDt(java.lang.String rkfcdDt) {
        this.rkfcdDt = rkfcdDt;
    }
    
    public java.lang.String getRsgtnDt() {
        return this.rsgtnDt;
    }
    
    public void setRsgtnDt(java.lang.String rsgtnDt) {
        this.rsgtnDt = rsgtnDt;
    }
    
    public java.lang.String getPymtDt() {
        return this.pymtDt;
    }
    
    public void setPymtDt(java.lang.String pymtDt) {
        this.pymtDt = pymtDt;
    }
     
    
    public java.lang.String getSevePayCtrClutNoteCtnt() {
        return this.sevePayCtrClutNoteCtnt;
    }
    
    public void setSevePayCtrClutNoteCtnt(java.lang.String sevePayCtrClutNoteCtnt) {
        this.sevePayCtrClutNoteCtnt = sevePayCtrClutNoteCtnt;
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
