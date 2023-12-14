package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;


/**
 * @Class Name : Ye161070VO.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161070VO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
    private java.math.BigDecimal yr2000PnsnSvngUseAmt;

    /** set 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
    private java.math.BigDecimal yr2000PnsnSvngDdcAmt;

    /** set 소기업소상인공제부금납입금액 : smceSbizUseAmt */
    private java.math.BigDecimal smceSbizUseAmt;

    /** set 소기업소상인공제부금공제액 : smceSbizDdcAmt */
    private java.math.BigDecimal smceSbizDdcAmt;

    /** set 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
    private java.math.BigDecimal sbcSvngUseAmt;

    /** set 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
    private java.math.BigDecimal sbcSvngDdcAmt;

    /** set 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
    private java.math.BigDecimal lbrrPrptSvngUseAmt;

    /** set 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
    private java.math.BigDecimal lbrrPrptSvngDdcAmt;

    /** set 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
    private java.math.BigDecimal hsngSvngUseAmt;

    /** set 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
    private java.math.BigDecimal hsngSvngDdcAmt;

    /** set 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
    private java.math.BigDecimal hsngIncUseAmtSum;

    /** set 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
    private java.math.BigDecimal hsngIncDdcAmtSum;

    /** set 출자투자금액_조합등_2014납입금액 : cpiv14AsctUseAmt */
    private java.math.BigDecimal cpiv14AsctUseAmt;

    /** set 출자투자금액_조합등_2014공제액 : cpiv14AsctDdcAmt */
    private java.math.BigDecimal cpiv14AsctDdcAmt;

    /** set 출자투자금액_벤처등_2014납입금액 : cpiv14VntUseAmt */
    private java.math.BigDecimal cpiv14VntUseAmt;

    /** set 출자투자금액_벤처등_2014공제액 : cpiv14VntDdcAmt */
    private java.math.BigDecimal cpiv14VntDdcAmt;

    /** set 출자투자금액_조합등_2015납입금액 : cpiv15AsctUseAmt */
    private java.math.BigDecimal cpiv15AsctUseAmt;

    /** set 출자투자금액_조합등_2015공제액 : cpiv15AsctDdcAmt */
    private java.math.BigDecimal cpiv15AsctDdcAmt;

    /** set 출자투자금액_벤처등_2015납입금액 : cpiv15VntUseAmt */
    private java.math.BigDecimal cpiv15VntUseAmt;

    /** set 출자투자금액_벤처등_2015공제액 : cpiv15VntDdcAmt */
    private java.math.BigDecimal cpiv15VntDdcAmt;

    /** set 출자투자금액_조합등_2016납입금 : cpiv16AsctUseAmt */
    private java.math.BigDecimal cpiv16AsctUseAmt;

    /** set 출자투자금액 조합등_2016공제액 : cpiv16AsctDdcAmt */
    private java.math.BigDecimal cpiv16AsctDdcAmt;

    /** set 출자투자금액벤처등_2016납입금액 : cpiv16VntUseAmt */
    private java.math.BigDecimal cpiv16VntUseAmt;

    /** set 출자투자금액벤처등_2016공제액 : cpiv16VntDdcAmt */
    private java.math.BigDecimal cpiv16VntDdcAmt;

    /** set 출자투자금액_조합등_2017납입금 : cpiv17AsctUseAmt */
    private java.math.BigDecimal cpiv17AsctUseAmt;

    /** set 출자투자금액 조합등_2017공제액 : cpiv17AsctDdcAmt */
    private java.math.BigDecimal cpiv17AsctDdcAmt;

    /** set 출자투자금액벤처등_2017납입금액 : cpiv17VntUseAmt */
    private java.math.BigDecimal cpiv17VntUseAmt;

    /** set 출자투자금액벤처등_2017공제액 : cpiv17VntDdcAmt */
    private java.math.BigDecimal cpiv17VntDdcAmt;

    /** set 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
    private java.math.BigDecimal ivcpInvmUseAmtSum;

    /** set 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
    private java.math.BigDecimal ivcpInvmDdcAmtSum;

    /** set 신용카드_전통대중제외사용금액 : crdcUseAmt */
    private java.math.BigDecimal crdcUseAmt;

    /** set 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
    private java.math.BigDecimal drtpCardUseAmt;

    /** set 현금영수증_전통대중제외사용금액 : cshptUseAmt */
    private java.math.BigDecimal cshptUseAmt;

    /** set 전통시장사용금액 : tdmrUseAmt */
    private java.math.BigDecimal tdmrUseAmt;

    /** set 대중교통이용금액 : pbtUseAmt */
    private java.math.BigDecimal pbtUseAmt;

    /** set 신용카드등사용액합계 : crdcSumUseAmt */
    private java.math.BigDecimal crdcSumUseAmt;

    /** set 신용카드등사용공제액합계 : rdcSumDdcAmt */
    private java.math.BigDecimal rdcSumDdcAmt;

    /** set 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
    private java.math.BigDecimal prsCrdcUseAmt1;

    /** set 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
    private java.math.BigDecimal tyYrPrsCrdcUseAmt;

    /** set 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
    private java.math.BigDecimal pyrPrsAddDdcrtUseAmt;

    /** set 본인추가공제율사용분_2016_상반기 : tyShfyPrsAddDdcrtUseAmt */
    private java.math.BigDecimal tyShfyPrsAddDdcrtUseAmt;

    /** set 우리사주조합출연금액 : emstAsctCntrUseAmt */
    private java.math.BigDecimal emstAsctCntrUseAmt;

    /** set 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
    private java.math.BigDecimal emstAsctCntrDdcAmt;

    /** set 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
    private java.math.BigDecimal empMntnSnmcUseAmt;

    /** set 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
    private java.math.BigDecimal empMntnSnmcDdcAmt;

    /** set 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
    private java.math.BigDecimal ltrmCniSsUseAmt;

    /** set 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */
    private java.math.BigDecimal ltrmCniSsDdcAmt;

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

	public java.math.BigDecimal getYr2000PnsnSvngUseAmt() {
		return yr2000PnsnSvngUseAmt;
	}

	public void setYr2000PnsnSvngUseAmt(java.math.BigDecimal yr2000PnsnSvngUseAmt) {
		this.yr2000PnsnSvngUseAmt = yr2000PnsnSvngUseAmt;
	}

	public java.math.BigDecimal getYr2000PnsnSvngDdcAmt() {
		return yr2000PnsnSvngDdcAmt;
	}

	public void setYr2000PnsnSvngDdcAmt(java.math.BigDecimal yr2000PnsnSvngDdcAmt) {
		this.yr2000PnsnSvngDdcAmt = yr2000PnsnSvngDdcAmt;
	}

	public java.math.BigDecimal getSmceSbizUseAmt() {
		return smceSbizUseAmt;
	}

	public void setSmceSbizUseAmt(java.math.BigDecimal smceSbizUseAmt) {
		this.smceSbizUseAmt = smceSbizUseAmt;
	}

	public java.math.BigDecimal getSmceSbizDdcAmt() {
		return smceSbizDdcAmt;
	}

	public void setSmceSbizDdcAmt(java.math.BigDecimal smceSbizDdcAmt) {
		this.smceSbizDdcAmt = smceSbizDdcAmt;
	}

	public java.math.BigDecimal getSbcSvngUseAmt() {
		return sbcSvngUseAmt;
	}

	public void setSbcSvngUseAmt(java.math.BigDecimal sbcSvngUseAmt) {
		this.sbcSvngUseAmt = sbcSvngUseAmt;
	}

	public java.math.BigDecimal getSbcSvngDdcAmt() {
		return sbcSvngDdcAmt;
	}

	public void setSbcSvngDdcAmt(java.math.BigDecimal sbcSvngDdcAmt) {
		this.sbcSvngDdcAmt = sbcSvngDdcAmt;
	}

	public java.math.BigDecimal getLbrrPrptSvngUseAmt() {
		return lbrrPrptSvngUseAmt;
	}

	public void setLbrrPrptSvngUseAmt(java.math.BigDecimal lbrrPrptSvngUseAmt) {
		this.lbrrPrptSvngUseAmt = lbrrPrptSvngUseAmt;
	}

	public java.math.BigDecimal getLbrrPrptSvngDdcAmt() {
		return lbrrPrptSvngDdcAmt;
	}

	public void setLbrrPrptSvngDdcAmt(java.math.BigDecimal lbrrPrptSvngDdcAmt) {
		this.lbrrPrptSvngDdcAmt = lbrrPrptSvngDdcAmt;
	}

	public java.math.BigDecimal getHsngSvngUseAmt() {
		return hsngSvngUseAmt;
	}

	public void setHsngSvngUseAmt(java.math.BigDecimal hsngSvngUseAmt) {
		this.hsngSvngUseAmt = hsngSvngUseAmt;
	}

	public java.math.BigDecimal getHsngSvngDdcAmt() {
		return hsngSvngDdcAmt;
	}

	public void setHsngSvngDdcAmt(java.math.BigDecimal hsngSvngDdcAmt) {
		this.hsngSvngDdcAmt = hsngSvngDdcAmt;
	}

	public java.math.BigDecimal getHsngIncUseAmtSum() {
		return hsngIncUseAmtSum;
	}

	public void setHsngIncUseAmtSum(java.math.BigDecimal hsngIncUseAmtSum) {
		this.hsngIncUseAmtSum = hsngIncUseAmtSum;
	}

	public java.math.BigDecimal getHsngIncDdcAmtSum() {
		return hsngIncDdcAmtSum;
	}

	public void setHsngIncDdcAmtSum(java.math.BigDecimal hsngIncDdcAmtSum) {
		this.hsngIncDdcAmtSum = hsngIncDdcAmtSum;
	}

	public java.math.BigDecimal getCpiv14AsctUseAmt() {
		return cpiv14AsctUseAmt;
	}

	public void setCpiv14AsctUseAmt(java.math.BigDecimal cpiv14AsctUseAmt) {
		this.cpiv14AsctUseAmt = cpiv14AsctUseAmt;
	}

	public java.math.BigDecimal getCpiv14AsctDdcAmt() {
		return cpiv14AsctDdcAmt;
	}

	public void setCpiv14AsctDdcAmt(java.math.BigDecimal cpiv14AsctDdcAmt) {
		this.cpiv14AsctDdcAmt = cpiv14AsctDdcAmt;
	}

	public java.math.BigDecimal getCpiv14VntUseAmt() {
		return cpiv14VntUseAmt;
	}

	public void setCpiv14VntUseAmt(java.math.BigDecimal cpiv14VntUseAmt) {
		this.cpiv14VntUseAmt = cpiv14VntUseAmt;
	}

	public java.math.BigDecimal getCpiv14VntDdcAmt() {
		return cpiv14VntDdcAmt;
	}

	public void setCpiv14VntDdcAmt(java.math.BigDecimal cpiv14VntDdcAmt) {
		this.cpiv14VntDdcAmt = cpiv14VntDdcAmt;
	}

	public java.math.BigDecimal getCpiv15AsctUseAmt() {
		return cpiv15AsctUseAmt;
	}

	public void setCpiv15AsctUseAmt(java.math.BigDecimal cpiv15AsctUseAmt) {
		this.cpiv15AsctUseAmt = cpiv15AsctUseAmt;
	}

	public java.math.BigDecimal getCpiv15AsctDdcAmt() {
		return cpiv15AsctDdcAmt;
	}

	public void setCpiv15AsctDdcAmt(java.math.BigDecimal cpiv15AsctDdcAmt) {
		this.cpiv15AsctDdcAmt = cpiv15AsctDdcAmt;
	}

	public java.math.BigDecimal getCpiv15VntUseAmt() {
		return cpiv15VntUseAmt;
	}

	public void setCpiv15VntUseAmt(java.math.BigDecimal cpiv15VntUseAmt) {
		this.cpiv15VntUseAmt = cpiv15VntUseAmt;
	}

	public java.math.BigDecimal getCpiv15VntDdcAmt() {
		return cpiv15VntDdcAmt;
	}

	public void setCpiv15VntDdcAmt(java.math.BigDecimal cpiv15VntDdcAmt) {
		this.cpiv15VntDdcAmt = cpiv15VntDdcAmt;
	}

	public java.math.BigDecimal getCpiv16AsctUseAmt() {
		return cpiv16AsctUseAmt;
	}

	public void setCpiv16AsctUseAmt(java.math.BigDecimal cpiv16AsctUseAmt) {
		this.cpiv16AsctUseAmt = cpiv16AsctUseAmt;
	}

	public java.math.BigDecimal getCpiv16AsctDdcAmt() {
		return cpiv16AsctDdcAmt;
	}

	public void setCpiv16AsctDdcAmt(java.math.BigDecimal cpiv16AsctDdcAmt) {
		this.cpiv16AsctDdcAmt = cpiv16AsctDdcAmt;
	}

	public java.math.BigDecimal getCpiv16VntUseAmt() {
		return cpiv16VntUseAmt;
	}

	public void setCpiv16VntUseAmt(java.math.BigDecimal cpiv16VntUseAmt) {
		this.cpiv16VntUseAmt = cpiv16VntUseAmt;
	}

	public java.math.BigDecimal getCpiv16VntDdcAmt() {
		return cpiv16VntDdcAmt;
	}

	public void setCpiv16VntDdcAmt(java.math.BigDecimal cpiv16VntDdcAmt) {
		this.cpiv16VntDdcAmt = cpiv16VntDdcAmt;
	}

	public java.math.BigDecimal getCpiv17AsctUseAmt() {
		return cpiv17AsctUseAmt;
	}

	public void setCpiv17AsctUseAmt(java.math.BigDecimal cpiv17AsctUseAmt) {
		this.cpiv17AsctUseAmt = cpiv17AsctUseAmt;
	}

	public java.math.BigDecimal getCpiv17AsctDdcAmt() {
		return cpiv17AsctDdcAmt;
	}

	public void setCpiv17AsctDdcAmt(java.math.BigDecimal cpiv17AsctDdcAmt) {
		this.cpiv17AsctDdcAmt = cpiv17AsctDdcAmt;
	}

	public java.math.BigDecimal getCpiv17VntUseAmt() {
		return cpiv17VntUseAmt;
	}

	public void setCpiv17VntUseAmt(java.math.BigDecimal cpiv17VntUseAmt) {
		this.cpiv17VntUseAmt = cpiv17VntUseAmt;
	}

	public java.math.BigDecimal getCpiv17VntDdcAmt() {
		return cpiv17VntDdcAmt;
	}

	public void setCpiv17VntDdcAmt(java.math.BigDecimal cpiv17VntDdcAmt) {
		this.cpiv17VntDdcAmt = cpiv17VntDdcAmt;
	}

	public java.math.BigDecimal getIvcpInvmUseAmtSum() {
		return ivcpInvmUseAmtSum;
	}

	public void setIvcpInvmUseAmtSum(java.math.BigDecimal ivcpInvmUseAmtSum) {
		this.ivcpInvmUseAmtSum = ivcpInvmUseAmtSum;
	}

	public java.math.BigDecimal getIvcpInvmDdcAmtSum() {
		return ivcpInvmDdcAmtSum;
	}

	public void setIvcpInvmDdcAmtSum(java.math.BigDecimal ivcpInvmDdcAmtSum) {
		this.ivcpInvmDdcAmtSum = ivcpInvmDdcAmtSum;
	}

	public java.math.BigDecimal getCrdcUseAmt() {
		return crdcUseAmt;
	}

	public void setCrdcUseAmt(java.math.BigDecimal crdcUseAmt) {
		this.crdcUseAmt = crdcUseAmt;
	}

	public java.math.BigDecimal getDrtpCardUseAmt() {
		return drtpCardUseAmt;
	}

	public void setDrtpCardUseAmt(java.math.BigDecimal drtpCardUseAmt) {
		this.drtpCardUseAmt = drtpCardUseAmt;
	}

	public java.math.BigDecimal getCshptUseAmt() {
		return cshptUseAmt;
	}

	public void setCshptUseAmt(java.math.BigDecimal cshptUseAmt) {
		this.cshptUseAmt = cshptUseAmt;
	}

	public java.math.BigDecimal getTdmrUseAmt() {
		return tdmrUseAmt;
	}

	public void setTdmrUseAmt(java.math.BigDecimal tdmrUseAmt) {
		this.tdmrUseAmt = tdmrUseAmt;
	}

	public java.math.BigDecimal getPbtUseAmt() {
		return pbtUseAmt;
	}

	public void setPbtUseAmt(java.math.BigDecimal pbtUseAmt) {
		this.pbtUseAmt = pbtUseAmt;
	}

	public java.math.BigDecimal getCrdcSumUseAmt() {
		return crdcSumUseAmt;
	}

	public void setCrdcSumUseAmt(java.math.BigDecimal crdcSumUseAmt) {
		this.crdcSumUseAmt = crdcSumUseAmt;
	}

	public java.math.BigDecimal getRdcSumDdcAmt() {
		return rdcSumDdcAmt;
	}

	public void setRdcSumDdcAmt(java.math.BigDecimal rdcSumDdcAmt) {
		this.rdcSumDdcAmt = rdcSumDdcAmt;
	}

	public java.math.BigDecimal getPrsCrdcUseAmt1() {
		return prsCrdcUseAmt1;
	}

	public void setPrsCrdcUseAmt1(java.math.BigDecimal prsCrdcUseAmt1) {
		this.prsCrdcUseAmt1 = prsCrdcUseAmt1;
	}

	public java.math.BigDecimal getTyYrPrsCrdcUseAmt() {
		return tyYrPrsCrdcUseAmt;
	}

	public void setTyYrPrsCrdcUseAmt(java.math.BigDecimal tyYrPrsCrdcUseAmt) {
		this.tyYrPrsCrdcUseAmt = tyYrPrsCrdcUseAmt;
	}

	public java.math.BigDecimal getPyrPrsAddDdcrtUseAmt() {
		return pyrPrsAddDdcrtUseAmt;
	}

	public void setPyrPrsAddDdcrtUseAmt(java.math.BigDecimal pyrPrsAddDdcrtUseAmt) {
		this.pyrPrsAddDdcrtUseAmt = pyrPrsAddDdcrtUseAmt;
	}

	public java.math.BigDecimal getTyShfyPrsAddDdcrtUseAmt() {
		return tyShfyPrsAddDdcrtUseAmt;
	}

	public void setTyShfyPrsAddDdcrtUseAmt(
			java.math.BigDecimal tyShfyPrsAddDdcrtUseAmt) {
		this.tyShfyPrsAddDdcrtUseAmt = tyShfyPrsAddDdcrtUseAmt;
	}

	public java.math.BigDecimal getEmstAsctCntrUseAmt() {
		return emstAsctCntrUseAmt;
	}

	public void setEmstAsctCntrUseAmt(java.math.BigDecimal emstAsctCntrUseAmt) {
		this.emstAsctCntrUseAmt = emstAsctCntrUseAmt;
	}

	public java.math.BigDecimal getEmstAsctCntrDdcAmt() {
		return emstAsctCntrDdcAmt;
	}

	public void setEmstAsctCntrDdcAmt(java.math.BigDecimal emstAsctCntrDdcAmt) {
		this.emstAsctCntrDdcAmt = emstAsctCntrDdcAmt;
	}

	public java.math.BigDecimal getEmpMntnSnmcUseAmt() {
		return empMntnSnmcUseAmt;
	}

	public void setEmpMntnSnmcUseAmt(java.math.BigDecimal empMntnSnmcUseAmt) {
		this.empMntnSnmcUseAmt = empMntnSnmcUseAmt;
	}

	public java.math.BigDecimal getEmpMntnSnmcDdcAmt() {
		return empMntnSnmcDdcAmt;
	}

	public void setEmpMntnSnmcDdcAmt(java.math.BigDecimal empMntnSnmcDdcAmt) {
		this.empMntnSnmcDdcAmt = empMntnSnmcDdcAmt;
	}

	public java.math.BigDecimal getLtrmCniSsUseAmt() {
		return ltrmCniSsUseAmt;
	}

	public void setLtrmCniSsUseAmt(java.math.BigDecimal ltrmCniSsUseAmt) {
		this.ltrmCniSsUseAmt = ltrmCniSsUseAmt;
	}

	public java.math.BigDecimal getLtrmCniSsDdcAmt() {
		return ltrmCniSsDdcAmt;
	}

	public void setLtrmCniSsDdcAmt(java.math.BigDecimal ltrmCniSsDdcAmt) {
		this.ltrmCniSsDdcAmt = ltrmCniSsDdcAmt;
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
