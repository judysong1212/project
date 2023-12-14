package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0480VO.java
 * @Description : Payr0480 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0480VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 급여수당코드 : payExtpyCd */
    private java.lang.String payExtpyCd;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 급여수당그룹코드 : payExtpyGrpCd */
    private java.lang.String payExtpyGrpCd;

    /** set 급여수당명 : payExtpyNm */
    private java.lang.String payExtpyNm;

    /** set 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
    private java.lang.String payExtpyPymtPrdDivCd;

    /** set 급여수당사용여부 : payExtpyUseYn */
    private java.lang.String payExtpyUseYn;

    /** set 급여수정가능여부 : payRevnPsbyYn */
    private java.lang.String payRevnPsbyYn;

    /** set 회계계정코드 : accAccCd */
    private java.lang.String accAccCd;

    /** set 퇴직적용여부 : sevePayYn */
    private java.lang.String sevePayYn;

    /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
    private java.lang.String yrtxFreeDtyReduCd;

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
     
    
 //   private SysComBass0300DTO sysComBass0300Dto;
     

    
    public java.lang.String getPymtDducDivCd() {
        return pymtDducDivCd;
    }


    public java.lang.String getSevePayYn() {
        return sevePayYn;
    }


    public void setSevePayYn(java.lang.String sevePayYn) {
        this.sevePayYn = sevePayYn;
    }


    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }

    private java.lang.String payExtpyGrpCd$commCd = "";
    
    private java.lang.String payExtpyGrpCd$commCdNm = "";
    

    public java.lang.String getPayExtpyGrpCd$commCdNm() {
		return payExtpyGrpCd$commCdNm;
	}


	public void setPayExtpyGrpCd$commCdNm(
			java.lang.String payExtpyGrpCd$commCdNm) {
		this.payExtpyGrpCd$commCdNm = payExtpyGrpCd$commCdNm;
	}


	public java.lang.String getPayExtpyGrpCd$commCd() {
		return payExtpyGrpCd$commCd;
	}


	public void setPayExtpyGrpCd$commCd(
			java.lang.String payExtpyGrpCd$commCd) {
		this.payExtpyGrpCd$commCd = payExtpyGrpCd$commCd;
	}
	
//    public SysComBass0300DTO getMsfComBass0300Dto() {
//		return sysComBass0300Dto;
//	}
//
//	public void setMsfComBass0300Dto(SysComBass0300DTO sysComBass0300Dto) {
//		this.sysComBass0300Dto = sysComBass0300Dto;
//	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayExtpyCd() {
        return this.payExtpyCd;
    }
    
    public void setPayExtpyCd(java.lang.String payExtpyCd) {
        this.payExtpyCd = payExtpyCd;
    }
    
    public java.lang.String getPayExtpyGrpCd() {
        return this.payExtpyGrpCd;
    }
    
    public void setPayExtpyGrpCd(java.lang.String payExtpyGrpCd) {
        this.payExtpyGrpCd = payExtpyGrpCd;
    }
    
    public java.lang.String getPayExtpyNm() {
        return this.payExtpyNm;
    }
    
    public void setPayExtpyNm(java.lang.String payExtpyNm) {
        this.payExtpyNm = payExtpyNm;
    }
    
    public java.lang.String getPayExtpyPymtPrdDivCd() {
        return this.payExtpyPymtPrdDivCd;
    }
    
    public void setPayExtpyPymtPrdDivCd(java.lang.String payExtpyPymtPrdDivCd) {
        this.payExtpyPymtPrdDivCd = payExtpyPymtPrdDivCd;
    }
    
    public java.lang.String getPayExtpyUseYn() {
        return this.payExtpyUseYn;
    }
    
    public void setPayExtpyUseYn(java.lang.String payExtpyUseYn) {
        this.payExtpyUseYn = payExtpyUseYn;
    }
    
    public java.lang.String getPayRevnPsbyYn() {
        return this.payRevnPsbyYn;
    }
    
    public void setPayRevnPsbyYn(java.lang.String payRevnPsbyYn) {
        this.payRevnPsbyYn = payRevnPsbyYn;
    }
    
    public java.lang.String getAccAccCd() {
        return this.accAccCd;
    }
    
    public void setAccAccCd(java.lang.String accAccCd) {
        this.accAccCd = accAccCd;
    }
    
    public java.lang.String getYrtxFreeDtyReduCd() {
        return this.yrtxFreeDtyReduCd;
    }
    
    public void setYrtxFreeDtyReduCd(java.lang.String yrtxFreeDtyReduCd) {
        this.yrtxFreeDtyReduCd = yrtxFreeDtyReduCd;
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
