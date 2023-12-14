package com.app.exterms.insurance.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Class Name : Insr3400VO.java
 * @Description : Insr3400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3400VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 정산년월 : nofctYrMnthNum */
	private java.lang.String nofctYrMnthNum;
	
	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;
	
	/** set 휴퇴직정산일련번호 : levfAbncRetryClutNum */
	private java.math.BigDecimal levfAbncRetryClutNum;
	
	/** set 고용일련번호 : emymtSeilNum */
	private BigDecimal  emymtSeilNum;
	
	/** set 정산시작일자 : clutBgnnDt */
	private java.lang.String clutBgnnDt;

	/** set 퇴직일자 : retryDt */
	private java.lang.String retryDt;

	/** set 근무월수 : dutyMnthIcm */
	private java.math.BigDecimal dutyMnthIcm;

	/** set 건강보수총액 : hlthNumCpisTotAmnt */
	private java.math.BigDecimal hlthNumCpisTotAmnt;

	/** set 건강보수월액 : hlthPayMnthAmnt */
	private java.math.BigDecimal hlthPayMnthAmnt;

	/** set 기납부_건강보험료 : alpayHlthPrmm */
	private java.math.BigDecimal alpayHlthPrmm;

	/** set 기납부_장기요양보험료 : alpayLgtmRcptnPrmm */
	private java.math.BigDecimal alpayLgtmRcptnPrmm;

	/** set 기납부_합계 : alpayAggrSum */
	private java.math.BigDecimal alpayAggrSum;

	/** set 건강확정보험료 : hlthFixPrmm */
	private java.math.BigDecimal hlthFixPrmm;

	/** set 감면월수 : reduMnthIcm */
	private java.math.BigDecimal reduMnthIcm;

	/** set 건강_감면_조정보험료 : hlthReduAdmntPrmm */
	private java.math.BigDecimal hlthReduAdmntPrmm;

	/** set 실근무월수 : turtyDutyMnthIcm */
	private java.math.BigDecimal turtyDutyMnthIcm;

	/** set 건강산정보험료 : hlthCmpttnPrmm */
	private java.math.BigDecimal hlthCmpttnPrmm;

	/** set 건강정산보험료 : hlthClutPrmm */
	private java.math.BigDecimal hlthClutPrmm;

	/** set 분할납부구분코드 : divdPymtDivCd */
	private java.lang.String divdPymtDivCd;

	/** set 분할납부횟수 : divdPymt */
	private java.math.BigDecimal divdPymt;

	/** set 공제년월 : dducYrMnth */
	private java.lang.String dducYrMnth;
	
	/** set 건강연말정산처리일자 hlthYrtxPrcsDt */
	private java.lang.String hlthYrtxPrcsDt;
	
	/** set 건강보험연말정산처리여부 hlthInsrYrtxPrcsYn */
	private java.lang.String hlthInsrYrtxPrcsYn;
	
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

	private java.lang.String hdofcCodtnCd;

	private java.lang.String emymtEndDt;
	
	


	public java.lang.String getHdofcCodtnCd() {
		return hdofcCodtnCd;
	}

	public void setHdofcCodtnCd(java.lang.String hdofcCodtnCd) {
		this.hdofcCodtnCd = hdofcCodtnCd;
	}

	public java.lang.String getEmymtEndDt() {
		return emymtEndDt;
	}

	public void setEmymtEndDt(java.lang.String emymtEndDt) {
		this.emymtEndDt = emymtEndDt;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getNofctYrMnthNum() {
        return this.nofctYrMnthNum;
    }
    
    public void setNofctYrMnthNum(java.lang.String nofctYrMnthNum) {
        this.nofctYrMnthNum = nofctYrMnthNum;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
	public java.math.BigDecimal getLevfAbncRetryClutNum() {
        return this.levfAbncRetryClutNum;
    }
    
    public void setLevfAbncRetryClutNum(java.math.BigDecimal levfAbncRetryClutNum) {
        this.levfAbncRetryClutNum = levfAbncRetryClutNum;
    }
    
    
   
    
    /**
	 * Comment : 
	 * @fn BigDecimal getEmymtSeilNum()
	 * @brief date:2016 2016. 4. 27. user:Administrator
	 * @return the emymtSeilNum get
	 */
	public BigDecimal getEmymtSeilNum() {
		return emymtSeilNum;
	}

	/**
	 * Comment : 
	 *@fn void setEmymtSeilNum(BigDecimal emymtSeilNum)
	 *@brief date:2016 2016. 4. 27. user:Administrator
	 *@param emymtSeilNum the emymtSeilNum to set
	 */
	public void setEmymtSeilNum(BigDecimal emymtSeilNum) {
		this.emymtSeilNum = emymtSeilNum;
	}
    
    public java.lang.String getClutBgnnDt() {
        return this.clutBgnnDt;
    }
    
    public void setClutBgnnDt(java.lang.String clutBgnnDt) {
        this.clutBgnnDt = clutBgnnDt;
    }
    
    public java.lang.String getRetryDt() {
        return this.retryDt;
    }
    
    public void setRetryDt(java.lang.String retryDt) {
        this.retryDt = retryDt;
    }
    
    public java.math.BigDecimal getDutyMnthIcm() {
        return this.dutyMnthIcm;
    }
    
    public void setDutyMnthIcm(java.math.BigDecimal dutyMnthIcm) {
        this.dutyMnthIcm = dutyMnthIcm;
    }
    
    public java.math.BigDecimal getHlthNumCpisTotAmnt() {
        return this.hlthNumCpisTotAmnt;
    }
    
    public void setHlthNumCpisTotAmnt(java.math.BigDecimal hlthNumCpisTotAmnt) {
        this.hlthNumCpisTotAmnt = hlthNumCpisTotAmnt;
    }
    
    public java.math.BigDecimal getHlthPayMnthAmnt() {
        return this.hlthPayMnthAmnt;
    }
    
    public void setHlthPayMnthAmnt(java.math.BigDecimal hlthPayMnthAmnt) {
        this.hlthPayMnthAmnt = hlthPayMnthAmnt;
    }
    
    public java.math.BigDecimal getAlpayHlthPrmm() {
        return this.alpayHlthPrmm;
    }
    
    public void setAlpayHlthPrmm(java.math.BigDecimal alpayHlthPrmm) {
        this.alpayHlthPrmm = alpayHlthPrmm;
    }
    
    public java.math.BigDecimal getAlpayLgtmRcptnPrmm() {
        return this.alpayLgtmRcptnPrmm;
    }
    
    public void setAlpayLgtmRcptnPrmm(java.math.BigDecimal alpayLgtmRcptnPrmm) {
        this.alpayLgtmRcptnPrmm = alpayLgtmRcptnPrmm;
    }
    
    public java.math.BigDecimal getAlpayAggrSum() {
        return this.alpayAggrSum;
    }
    
    public void setAlpayAggrSum(java.math.BigDecimal alpayAggrSum) {
        this.alpayAggrSum = alpayAggrSum;
    }
    
    public java.math.BigDecimal getHlthFixPrmm() {
        return this.hlthFixPrmm;
    }
    
    public void setHlthFixPrmm(java.math.BigDecimal hlthFixPrmm) {
        this.hlthFixPrmm = hlthFixPrmm;
    }
    
    public java.math.BigDecimal getReduMnthIcm() {
        return this.reduMnthIcm;
    }
    
    public void setReduMnthIcm(java.math.BigDecimal reduMnthIcm) {
        this.reduMnthIcm = reduMnthIcm;
    }
    
    public java.math.BigDecimal getHlthReduAdmntPrmm() {
        return this.hlthReduAdmntPrmm;
    }
    
    public void setHlthReduAdmntPrmm(java.math.BigDecimal hlthReduAdmntPrmm) {
        this.hlthReduAdmntPrmm = hlthReduAdmntPrmm;
    }
    
    public java.math.BigDecimal getTurtyDutyMnthIcm() {
        return this.turtyDutyMnthIcm;
    }
    
    public void setTurtyDutyMnthIcm(java.math.BigDecimal turtyDutyMnthIcm) {
        this.turtyDutyMnthIcm = turtyDutyMnthIcm;
    }
    
    public java.math.BigDecimal getHlthCmpttnPrmm() {
        return this.hlthCmpttnPrmm;
    }
    
    public void setHlthCmpttnPrmm(java.math.BigDecimal hlthCmpttnPrmm) {
        this.hlthCmpttnPrmm = hlthCmpttnPrmm;
    }
    
    public java.math.BigDecimal getHlthClutPrmm() {
        return this.hlthClutPrmm;
    }
    
    public void setHlthClutPrmm(java.math.BigDecimal hlthClutPrmm) {
        this.hlthClutPrmm = hlthClutPrmm;
    }
    
    public java.lang.String getDivdPymtDivCd() {
        return this.divdPymtDivCd;
    }
    
    public void setDivdPymtDivCd(java.lang.String divdPymtDivCd) {
        this.divdPymtDivCd = divdPymtDivCd;
    }
    
    public java.math.BigDecimal getDivdPymt() {
        return this.divdPymt;
    }
    
    public void setDivdPymt(java.math.BigDecimal divdPymt) {
        this.divdPymt = divdPymt;
    }
    
    public java.lang.String getDducYrMnth() {
		return dducYrMnth;
	}

	public void setDducYrMnth(java.lang.String dducYrMnth) {
		this.dducYrMnth = dducYrMnth;
	}
    
    public java.lang.String getHlthYrtxPrcsDt() {
        return this.hlthYrtxPrcsDt;
    }
    
    public void setHlthYrtxPrcsDt(java.lang.String hlthYrtxPrcsDt) {
        this.hlthYrtxPrcsDt = hlthYrtxPrcsDt;
    }
    
    public java.lang.String getHlthInsrYrtxPrcsYn() {
        return this.hlthInsrYrtxPrcsYn;
    }
    
    public void setHlthInsrYrtxPrcsYn(java.lang.String hlthInsrYrtxPrcsYn) {
        this.hlthInsrYrtxPrcsYn = hlthInsrYrtxPrcsYn;
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
