package com.app.exterms.yearendtax.client.dto.yeta2022;

import java.io.Serializable;


/**
 *
 * @Class Name : Ye161040DTO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161040DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 주민등록번호 : txprDscmNoCntn */
    private java.lang.String txprDscmNoCntn;

    /** set 소득공제명세자료구분코드 : cdVvalKrnCd */
    private java.lang.String cdVvalKrnCd;

    /** set 건강등보험료 : hifeDdcTrgtAmt */
    private Long hifeDdcTrgtAmt;

    /** set 고용보험료 : mcurUiTrgtAmt */
    private Long mcurUiTrgtAmt;

    /** set 보장성보험료 : cvrgInscDdcTrgtAmt */
    private Long cvrgInscDdcTrgtAmt;

    /** set 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
    private Long dsbrDdcTrgtAmt;

    /** set 의료비금액 : mdxpsDdcTrgtAmt */
    private Long mdxpsDdcTrgtAmt;

    /** set 교육비금액 : scxpsDdcTrgtAmt */
    private Long scxpsDdcTrgtAmt;

    /** set 신용카드_전통대중도서제외금액 : crdcDdcTrgtAmt */
    private Long crdcDdcTrgtAmt;

    /** set 직불카드등_전통대중도서제외금액 : drtpCardDdcTrgtAmt */
    private Long drtpCardDdcTrgtAmt;

    /** set 현금영수증_전통대중도서제외금액 : cshptDdcTrgtAmt */
    private Long cshptDdcTrgtAmt;
    
    /** set 제로페이_전통대중도서제외금액 : zrtdDdcTrgtAmt */
    private Long zrtdDdcTrgtAmt;
    
    /** set 전통시작사용금액 : tdmrDdcTrgtAmt */
    private Long tdmrDdcTrgtAmt;

    /** set 대중교통이용금액 : pbtDdcTrgtAmt */
    private Long pbtDdcTrgtAmt;

    /** set 도서이용금액 : bookShowAmt */
    private Long bookShowAmt;
    
    //2022연말정산_추가
    
    private Long totCrdcPreSum;
    
    private Long totCrdcCurrSum;
    
    private Long totTdmrPreSum;
    
    private Long totTdmrCurrSum;
    
    private Long tfhyPbtAmt;
    
    private Long shfyPbtAmt;
    
    //2022연말정산_추가
    
    
    /** set 기부금액 : conbDdcTrgtAmt */
    private Long conbDdcTrgtAmt;

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

    
    
    
    
    
    
	public Long getTotCrdcPreSum() {
		return totCrdcPreSum;
	}

	public void setTotCrdcPreSum(Long totCrdcPreSum) {
		this.totCrdcPreSum = totCrdcPreSum;
	}

	public Long getTotCrdcCurrSum() {
		return totCrdcCurrSum;
	}

	public void setTotCrdcCurrSum(Long totCrdcCurrSum) {
		this.totCrdcCurrSum = totCrdcCurrSum;
	}

	public Long getTotTdmrPreSum() {
		return totTdmrPreSum;
	}

	public void setTotTdmrPreSum(Long totTdmrPreSum) {
		this.totTdmrPreSum = totTdmrPreSum;
	}

	public Long getTotTdmrCurrSum() {
		return totTdmrCurrSum;
	}

	public void setTotTdmrCurrSum(Long totTdmrCurrSum) {
		this.totTdmrCurrSum = totTdmrCurrSum;
	}

	public Long getTfhyPbtAmt() {
		return tfhyPbtAmt;
	}

	public void setTfhyPbtAmt(Long tfhyPbtAmt) {
		this.tfhyPbtAmt = tfhyPbtAmt;
	}

	public Long getShfyPbtAmt() {
		return shfyPbtAmt;
	}

	public void setShfyPbtAmt(Long shfyPbtAmt) {
		this.shfyPbtAmt = shfyPbtAmt;
	}

	public Long getMcurUiTrgtAmt() {
		return mcurUiTrgtAmt;
	}

	public void setMcurUiTrgtAmt(Long mcurUiTrgtAmt) {
		this.mcurUiTrgtAmt = mcurUiTrgtAmt;
	}

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

	public java.lang.String getTxprDscmNoCntn() {
		return txprDscmNoCntn;
	}

	public void setTxprDscmNoCntn(java.lang.String txprDscmNoCntn) {
		this.txprDscmNoCntn = txprDscmNoCntn;
	}

	public java.lang.String getCdVvalKrnCd() {
		return cdVvalKrnCd;
	}

	public void setCdVvalKrnCd(java.lang.String cdVvalKrnCd) {
		this.cdVvalKrnCd = cdVvalKrnCd;
	}

	public Long getHifeDdcTrgtAmt() {
		return hifeDdcTrgtAmt;
	}

	public void setHifeDdcTrgtAmt(Long hifeDdcTrgtAmt) {
		this.hifeDdcTrgtAmt = hifeDdcTrgtAmt;
	}

	public Long getCvrgInscDdcTrgtAmt() {
		return cvrgInscDdcTrgtAmt;
	}

	public void setCvrgInscDdcTrgtAmt(Long cvrgInscDdcTrgtAmt) {
		this.cvrgInscDdcTrgtAmt = cvrgInscDdcTrgtAmt;
	}

	public Long getDsbrDdcTrgtAmt() {
		return dsbrDdcTrgtAmt;
	}

	public void setDsbrDdcTrgtAmt(Long dsbrDdcTrgtAmt) {
		this.dsbrDdcTrgtAmt = dsbrDdcTrgtAmt;
	}

	public Long getMdxpsDdcTrgtAmt() {
		return mdxpsDdcTrgtAmt;
	}

	public void setMdxpsDdcTrgtAmt(Long mdxpsDdcTrgtAmt) {
		this.mdxpsDdcTrgtAmt = mdxpsDdcTrgtAmt;
	}

	public Long getScxpsDdcTrgtAmt() {
		return scxpsDdcTrgtAmt;
	}

	public void setScxpsDdcTrgtAmt(Long scxpsDdcTrgtAmt) {
		this.scxpsDdcTrgtAmt = scxpsDdcTrgtAmt;
	}

	public Long getCrdcDdcTrgtAmt() {
		return crdcDdcTrgtAmt;
	}

	public void setCrdcDdcTrgtAmt(Long crdcDdcTrgtAmt) {
		this.crdcDdcTrgtAmt = crdcDdcTrgtAmt;
	}

	public Long getDrtpCardDdcTrgtAmt() {
		return drtpCardDdcTrgtAmt;
	}

	public void setDrtpCardDdcTrgtAmt(Long drtpCardDdcTrgtAmt) {
		this.drtpCardDdcTrgtAmt = drtpCardDdcTrgtAmt;
	}

	public Long getCshptDdcTrgtAmt() {
		return cshptDdcTrgtAmt;
	}

	public void setCshptDdcTrgtAmt(Long cshptDdcTrgtAmt) {
		this.cshptDdcTrgtAmt = cshptDdcTrgtAmt;
	}
	
	public Long getZrtdDdcTrgtAmt() {
		return zrtdDdcTrgtAmt;
	}

	public void setZrtdDdcTrgtAmt(Long zrtdDdcTrgtAmt) {
		this.zrtdDdcTrgtAmt = zrtdDdcTrgtAmt;
	}

	public Long getTdmrDdcTrgtAmt() {
		return tdmrDdcTrgtAmt;
	}

	public void setTdmrDdcTrgtAmt(Long tdmrDdcTrgtAmt) {
		this.tdmrDdcTrgtAmt = tdmrDdcTrgtAmt;
	}

	public Long getPbtDdcTrgtAmt() {
		return pbtDdcTrgtAmt;
	}

	public void setPbtDdcTrgtAmt(Long pbtDdcTrgtAmt) {
		this.pbtDdcTrgtAmt = pbtDdcTrgtAmt;
	}

	public Long getBookShowAmt() {
		return bookShowAmt;
	}

	public void setBookShowAmt(Long bookShowAmt) {
		this.bookShowAmt = bookShowAmt;
	}

	public Long getConbDdcTrgtAmt() {
		return conbDdcTrgtAmt;
	}

	public void setConbDdcTrgtAmt(Long conbDdcTrgtAmt) {
		this.conbDdcTrgtAmt = conbDdcTrgtAmt;
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
