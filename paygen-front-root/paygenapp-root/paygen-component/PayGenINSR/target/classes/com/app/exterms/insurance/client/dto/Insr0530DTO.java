package com.app.exterms.insurance.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0530VO.java
 * @Description : Payr0530 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr0530DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 급여가족사항일련번호 : payFamyRsptSeilNum */
    private Long payFamyRsptSeilNum;

    /** set 급여가족주민번호 : payFamyResnRegnNum */
    private java.lang.String payFamyResnRegnNum;

    /** set 가족주민등록번호 : famySecRegnNum */
   private java.lang.String famySecRegnNum;
   
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 가족관계구분코드 : famyRelaDivCd */
    private java.lang.String famyRelaDivCd;

    /** set 가족수당지급여부 : famyAllwPymtYn */
    private Boolean famyAllwPymtYn;

    /** set 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
    private Boolean chdnChdRrgEpnsPymtYn;

    /** set 기본공제여부 : fndtnDducYn */
    private Boolean fndtnDducYn;

    /** set 배우자공제여부 : spueDducYn */
    private Boolean spueDducYn;

    /** set 부녀자공제여부 : wmnDducYn */
    private Boolean wmnDducYn;

    /** set 경로우대공제여부 : rftaGvstDducYn */
    private Boolean rftaGvstDducYn;

    /** set 장애자공제여부 : dabpnDducYn */
    private Boolean dabpnDducYn;

    /** set 한가족공제여부 : sgpnFmlyDducYn */
    private Boolean sgpnFmlyDducYn;

    /** set 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
    private Boolean chdnChdRrgEpnsDducYn;

    /** set 가족수당구분코드 : famyExtpyDivCd */
    private java.lang.String famyExtpyDivCd;

    /** set 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
    private java.lang.String schlExpnAdmclExtpyDivCd;

    /** set 학비보조수당금액 : schlExpnAdmclExtpySum */
    private Long schlExpnAdmclExtpySum;

    /** set 가족수당금액 : famyExtpySum */
    private Long famyExtpySum;

    /** set 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
    private java.lang.String schlExpnExtpyPymtBgnnDt;

    /** set 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
    private java.lang.String schlExpnExtpyPymtEndDt;

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
     
    
    public java.lang.String getPayFamyResnRegnNum() {
        return this.payFamyResnRegnNum;
    }
    
    public void setPayFamyResnRegnNum(java.lang.String payFamyResnRegnNum) {
        this.payFamyResnRegnNum = payFamyResnRegnNum;
    }
    
    public java.lang.String getHanNm() {
        return this.hanNm;
    }
    
    public void setHanNm(java.lang.String hanNm) {
        this.hanNm = hanNm;
    }
    
    public java.lang.String getFamyRelaDivCd() {
        return this.famyRelaDivCd;
    }
    
    public void setFamyRelaDivCd(java.lang.String famyRelaDivCd) {
        this.famyRelaDivCd = famyRelaDivCd;
    }
    
   
    
    public java.lang.String getFamyExtpyDivCd() {
        return this.famyExtpyDivCd;
    }
    
    public void setFamyExtpyDivCd(java.lang.String famyExtpyDivCd) {
        this.famyExtpyDivCd = famyExtpyDivCd;
    }
    
    public java.lang.String getSchlExpnAdmclExtpyDivCd() {
        return this.schlExpnAdmclExtpyDivCd;
    }
    
    public void setSchlExpnAdmclExtpyDivCd(java.lang.String schlExpnAdmclExtpyDivCd) {
        this.schlExpnAdmclExtpyDivCd = schlExpnAdmclExtpyDivCd;
    }
    
   
    
    public Long getPayFamyRsptSeilNum() {
        return payFamyRsptSeilNum;
    }

    public void setPayFamyRsptSeilNum(Long payFamyRsptSeilNum) {
        this.payFamyRsptSeilNum = payFamyRsptSeilNum;
    }

    public Boolean getFamyAllwPymtYn() {
        return famyAllwPymtYn;
    }

    public void setFamyAllwPymtYn(Boolean famyAllwPymtYn) {
        this.famyAllwPymtYn = famyAllwPymtYn;
    }

    public Boolean getChdnChdRrgEpnsPymtYn() {
        return chdnChdRrgEpnsPymtYn;
    }

    public void setChdnChdRrgEpnsPymtYn(Boolean chdnChdRrgEpnsPymtYn) {
        this.chdnChdRrgEpnsPymtYn = chdnChdRrgEpnsPymtYn;
    }

    public Boolean getFndtnDducYn() {
        return fndtnDducYn;
    }

    public void setFndtnDducYn(Boolean fndtnDducYn) {
        this.fndtnDducYn = fndtnDducYn;
    }

    public Boolean getSpueDducYn() {
        return spueDducYn;
    }

    public void setSpueDducYn(Boolean spueDducYn) {
        this.spueDducYn = spueDducYn;
    }

    public Boolean getWmnDducYn() {
        return wmnDducYn;
    }

    public void setWmnDducYn(Boolean wmnDducYn) {
        this.wmnDducYn = wmnDducYn;
    }

    public Boolean getRftaGvstDducYn() {
        return rftaGvstDducYn;
    }

    public void setRftaGvstDducYn(Boolean rftaGvstDducYn) {
        this.rftaGvstDducYn = rftaGvstDducYn;
    }

    public Boolean getDabpnDducYn() {
        return dabpnDducYn;
    }

    public void setDabpnDducYn(Boolean dabpnDducYn) {
        this.dabpnDducYn = dabpnDducYn;
    }

    public Boolean getSgpnFmlyDducYn() {
        return sgpnFmlyDducYn;
    }

    public void setSgpnFmlyDducYn(Boolean sgpnFmlyDducYn) {
        this.sgpnFmlyDducYn = sgpnFmlyDducYn;
    }

    public Boolean getChdnChdRrgEpnsDducYn() {
        return chdnChdRrgEpnsDducYn;
    }

    public void setChdnChdRrgEpnsDducYn(Boolean chdnChdRrgEpnsDducYn) {
        this.chdnChdRrgEpnsDducYn = chdnChdRrgEpnsDducYn;
    }

    public Long getSchlExpnAdmclExtpySum() {
        return schlExpnAdmclExtpySum;
    }

    public void setSchlExpnAdmclExtpySum(Long schlExpnAdmclExtpySum) {
        this.schlExpnAdmclExtpySum = schlExpnAdmclExtpySum;
    }

    public Long getFamyExtpySum() {
        return famyExtpySum;
    }

    public void setFamyExtpySum(Long famyExtpySum) {
        this.famyExtpySum = famyExtpySum;
    }

    public java.lang.String getSchlExpnExtpyPymtBgnnDt() {
        return this.schlExpnExtpyPymtBgnnDt;
    }
    
    public void setSchlExpnExtpyPymtBgnnDt(java.lang.String schlExpnExtpyPymtBgnnDt) {
        this.schlExpnExtpyPymtBgnnDt = schlExpnExtpyPymtBgnnDt;
    }
    
    public java.lang.String getSchlExpnExtpyPymtEndDt() {
        return this.schlExpnExtpyPymtEndDt;
    }
    
    public void setSchlExpnExtpyPymtEndDt(java.lang.String schlExpnExtpyPymtEndDt) {
        this.schlExpnExtpyPymtEndDt = schlExpnExtpyPymtEndDt;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getFamySecRegnNum()
	 * @brief date:2016 2016. 6. 24. user:Administrator
	 * @return the famySecRegnNum get
	 */
	public java.lang.String getFamySecRegnNum() {
		return famySecRegnNum;
	}

	/**
	 * Comment : 
	 *@fn void setFamySecRegnNum(java.lang.String famySecRegnNum)
	 *@brief date:2016 2016. 6. 24. user:Administrator
	 *@param famySecRegnNum the famySecRegnNum to set
	 */
	public void setFamySecRegnNum(java.lang.String famySecRegnNum) {
		this.famySecRegnNum = famySecRegnNum;
	}
    
}
