package com.app.exterms.yearendtax.client.dto.yeta2022;

import java.io.Serializable;


/**
 * @Class Name : Ye166010DTO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye166010DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 전통시장사용분공제금액 : tdmrDdcAmt */
    private Long tdmrDdcAmt;

    /** set 대중교통이용분공제금액 : pbtDdcAmt */
    private Long pbtDdcAmt;

    /** set 직불카드등사용분공제금액 : drtpCardDdcAmt */
    private Long drtpCardDdcAmt;

    /** set 신용카드사용분 공제금액 : crdcDdcAmt */
    private Long crdcDdcAmt;
    
    /** set 제로페이사용분 공제금액 : zrtdDdcAmt */
    private Long zrtdDdcAmt;
    
    /** set 공제제외금액계산총급여액 : totaSnwAmt */
    private Long totaSnwAmt;

    /** set 공제제외금액계산최저사용금액 : minmUseAmt */
    private Long minmUseAmt;

    /** set 공제제외금액계산공제제외금액 : ddcExclAmt */
    private Long ddcExclAmt;

    /** set 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
    private Long addDdcrtDdcAmt;

    /** set 공제가능금액 : ddcPsbAmt */
    private Long ddcPsbAmt;

    /** set 공제한도액 : ddcLmtAmt */
    private Long ddcLmtAmt;

    /** set 일반공제금액 : gnrlDdcAmt */
    private Long gnrlDdcAmt;

    /** set 전통시장추가공제금액 : tdmrAddDdcAmt */
    private Long tdmrAddDdcAmt;

    /** set 대중교통추가공제금액 : pbtAddDdcAmt */
    private Long pbtAddDdcAmt;

    /** set 최종공제금액 : lstDdcAmt */
    private Long lstDdcAmt;

    /** set 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
    private Long ftyrPrsCrdcUseAmt;

    /** set 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
    private Long pyrPrsCrdcUseAmt1;

    /** set 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
    private Long ftyrPrsAddDdcrtAmt;

    /** set 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
    private Long tyYrTfhyPrsAddDdcrtAmt;

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
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getYrtxBlggYr() {
		return yrtxBlggYr;
	}

	public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
		this.yrtxBlggYr = yrtxBlggYr;
	}

	public java.lang.String getClutSeptCd() {
		return clutSeptCd;
	}

	public void setClutSeptCd(java.lang.String clutSeptCd) {
		this.clutSeptCd = clutSeptCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public Long getTdmrDdcAmt() {
		return tdmrDdcAmt;
	}

	public void setTdmrDdcAmt(Long tdmrDdcAmt) {
		this.tdmrDdcAmt = tdmrDdcAmt;
	}

	public Long getPbtDdcAmt() {
		return pbtDdcAmt;
	}

	public void setPbtDdcAmt(Long pbtDdcAmt) {
		this.pbtDdcAmt = pbtDdcAmt;
	}

	public Long getDrtpCardDdcAmt() {
		return drtpCardDdcAmt;
	}

	public void setDrtpCardDdcAmt(Long drtpCardDdcAmt) {
		this.drtpCardDdcAmt = drtpCardDdcAmt;
	}

	public Long getCrdcDdcAmt() {
		return crdcDdcAmt;
	}

	public void setCrdcDdcAmt(Long crdcDdcAmt) {
		this.crdcDdcAmt = crdcDdcAmt;
	}
	
	public Long getZrtdDdcAmt() {
		return zrtdDdcAmt;
	}

	public void setZrtdDdcAmt(Long zrtdDdcAmt) {
		this.zrtdDdcAmt = zrtdDdcAmt;
	}

	public Long getTotaSnwAmt() {
		return totaSnwAmt;
	}

	public void setTotaSnwAmt(Long totaSnwAmt) {
		this.totaSnwAmt = totaSnwAmt;
	}

	public Long getMinmUseAmt() {
		return minmUseAmt;
	}

	public void setMinmUseAmt(Long minmUseAmt) {
		this.minmUseAmt = minmUseAmt;
	}

	public Long getDdcExclAmt() {
		return ddcExclAmt;
	}

	public void setDdcExclAmt(Long ddcExclAmt) {
		this.ddcExclAmt = ddcExclAmt;
	}

	public Long getAddDdcrtDdcAmt() {
		return addDdcrtDdcAmt;
	}

	public void setAddDdcrtDdcAmt(Long addDdcrtDdcAmt) {
		this.addDdcrtDdcAmt = addDdcrtDdcAmt;
	}

	public Long getDdcPsbAmt() {
		return ddcPsbAmt;
	}

	public void setDdcPsbAmt(Long ddcPsbAmt) {
		this.ddcPsbAmt = ddcPsbAmt;
	}

	public Long getDdcLmtAmt() {
		return ddcLmtAmt;
	}

	public void setDdcLmtAmt(Long ddcLmtAmt) {
		this.ddcLmtAmt = ddcLmtAmt;
	}

	public Long getGnrlDdcAmt() {
		return gnrlDdcAmt;
	}

	public void setGnrlDdcAmt(Long gnrlDdcAmt) {
		this.gnrlDdcAmt = gnrlDdcAmt;
	}

	public Long getTdmrAddDdcAmt() {
		return tdmrAddDdcAmt;
	}

	public void setTdmrAddDdcAmt(Long tdmrAddDdcAmt) {
		this.tdmrAddDdcAmt = tdmrAddDdcAmt;
	}

	public Long getPbtAddDdcAmt() {
		return pbtAddDdcAmt;
	}

	public void setPbtAddDdcAmt(Long pbtAddDdcAmt) {
		this.pbtAddDdcAmt = pbtAddDdcAmt;
	}

	public Long getLstDdcAmt() {
		return lstDdcAmt;
	}

	public void setLstDdcAmt(Long lstDdcAmt) {
		this.lstDdcAmt = lstDdcAmt;
	}

	public Long getFtyrPrsCrdcUseAmt() {
		return ftyrPrsCrdcUseAmt;
	}

	public void setFtyrPrsCrdcUseAmt(Long ftyrPrsCrdcUseAmt) {
		this.ftyrPrsCrdcUseAmt = ftyrPrsCrdcUseAmt;
	}

	public Long getPyrPrsCrdcUseAmt1() {
		return pyrPrsCrdcUseAmt1;
	}

	public void setPyrPrsCrdcUseAmt1(Long pyrPrsCrdcUseAmt1) {
		this.pyrPrsCrdcUseAmt1 = pyrPrsCrdcUseAmt1;
	}

	public Long getFtyrPrsAddDdcrtAmt() {
		return ftyrPrsAddDdcrtAmt;
	}

	public void setFtyrPrsAddDdcrtAmt(Long ftyrPrsAddDdcrtAmt) {
		this.ftyrPrsAddDdcrtAmt = ftyrPrsAddDdcrtAmt;
	}

	public Long getTyYrTfhyPrsAddDdcrtAmt() {
		return tyYrTfhyPrsAddDdcrtAmt;
	}

	public void setTyYrTfhyPrsAddDdcrtAmt(Long tyYrTfhyPrsAddDdcrtAmt) {
		this.tyYrTfhyPrsAddDdcrtAmt = tyYrTfhyPrsAddDdcrtAmt;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}
    
    
    
}
