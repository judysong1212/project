package com.app.exterms.yearendtax.client.dto.yeta2018;

import java.io.Serializable;


/**
 * @Class Name : Ye160404DTO.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye160404DTO  implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속연도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
    private java.lang.String whdgDebrBusoprRgstnum;

    /** set D4_종전근무처일련번호 : prcspSeilNum */
    private Long prcspSeilNum;

    /** set D7_소득자주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;

    /** set D8_종전근무처납세조합여부 : prcspTxpyrAsocYn */
    private java.lang.String prcspTxpyrAsocYn;

    /** set D9_종전근무처법인_상호명 : prcspFmnmNm */
    private java.lang.String prcspFmnmNm;

    /** set D10_종전근무처사업자등록번호 : prcspBusoprRgstnum */
    private java.lang.String prcspBusoprRgstnum;

    /** set D11_종전근무처근무시간시작일자 : prcspDutyBgnnDt */
    private java.lang.String prcspDutyBgnnDt;

    /** set D12_종전근무처근무시간종료일자 : prcspDutyEndDt */
    private java.lang.String prcspDutyEndDt;

    /** set D13_종전근무처감면기간시작일자 : prcspReduBgnnDt */
    private java.lang.String prcspReduBgnnDt;

    /** set D14_종전근무처감면기간종료일자 : prcspReduEndDt */
    private java.lang.String prcspReduEndDt;

    /** set D15_종전근무처급여금액 : prcspPaySum */
    private Long prcspPaySum;

    /** set D16_종전근무처상여금액 : prcspAllwBnusSum */
    private Long prcspAllwBnusSum;

    /** set D17_종전근무처인정상여금액 : prcspRcgtnBnusSum */
    private Long prcspRcgtnBnusSum;

    /** set D18_종전근무처주식매수선택권행사이익금액 : prcspStckEvntPrftSum */
    private Long prcspStckEvntPrftSum;

    /** set D19_종전근무처우리사주조합인출금액 : prcspEmpStkscWdrwSum */
    private Long prcspEmpStkscWdrwSum;

    /** set D20_종전근무처임원퇴직소득한도초과금액 : prcspEcteRsgtnExceSum */
    private Long prcspEcteRsgtnExceSum;

    /** set D22_종전근무처합계금액 : prcspAggrSum */
    private Long prcspAggrSum;

    /** set D53_비과세합계금액 : freeDtyAggrSum */
    private Long freeDtyAggrSum;

    /** set D54_감면소득합계금액 : reduIncmAggrSum */
    private Long reduIncmAggrSum;

    /** set D56_종전근무지기납부세액_소득세금액 : prcspIncmTxSum */
    private Long prcspIncmTxSum;

    /** set D57_종전근무지기납부세액_지방소득세금액 : prcspRgonIncmTxSum */
    private Long prcspRgonIncmTxSum;

    /** set D58_종전근무지기납부세액_농특세금액 : prcspNnksSum */
    private Long prcspNnksSum;

    /** set 종전근무지건강보험료금액 : prcspHlthPrmmSum */
    private Long prcspHlthPrmmSum;

    /** set 종전근무지장기요양보험료금액 : prcspLgtmRcptnSum */
    private Long prcspLgtmRcptnSum;

    /** set 종전근무지건강장기요양보험료합계금액 : prcspHlthLgcptnAggr */
    private Long prcspHlthLgcptnAggr;

    /** set 종전근무지건강보험료공제금액 : prcspHlthPrmmDducSum */
    private Long prcspHlthPrmmDducSum;

    /** set 종전근무지고용보험료금액 : prcspEmymtPrmmSum */
    private Long prcspEmymtPrmmSum;

    /** set 종전근무지고용보험료공제금액 : prcspEmytPrmmDducSum */
    private Long prcspEmytPrmmDducSum;

    /** set 종전근무지처리여부 : prcspPrcsYn */
    private java.lang.String prcspPrcsYn;

    /** set 종전근무지원천징수영수증제출여부 : prcspWhdgReipSumtYn */
    private java.lang.String prcspWhdgReipSumtYn;

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
    
    

    /** set 국민연금보험료금액 : natPennPrmmSum */
    private Long natPennPrmmSum;

    /** set 국민연금지역보험료금액 : natPennAraPrmmSum */
    private Long natPennAraPrmmSum;

    /** set 국민연금공제금액 : natPennDducSum */
    private Long natPennDducSum;

    /** set 공적연금_공무원연금금액 : puoferAnty */
    private Long puoferAnty;

    /** set 공적연금_공무원연금공제금액 : puoferAntyDducSum */
    private Long puoferAntyDducSum;

    /** set 공적연금_군인연금금액 : mltymAnty */
    private Long mltymAnty;

    /** set 공적연금_군인연금공제금액 : mltymAntyDducSum */
    private Long mltymAntyDducSum;

    /** set 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
    private Long prtafirSchlFalymmAnty;

    /** set 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
    private Long prtafirSchlDducSum;

    /** set 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
    private Long spildtnPstoficAnty;

    /** set 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
    private Long spildtnPstoficDducSum;
    

	/** set C165_납부특례세액_소득세금액 : prcspYetaC165 */
	private Long prcspYetaC165;
	
	/** set C166_납부특례세액_지방소득세금액 : prcspYetaC166 */
	private Long prcspYetaC166;
	
	/** set C167_납부특례세액_농특세금액 : prcspYetaC167 */
	private Long prcspYetaC167;


	public Long getPrcspYetaC165() {
		return prcspYetaC165;
	}

	public void setPrcspYetaC165(Long prcspYetaC165) {
		this.prcspYetaC165 = prcspYetaC165;
	}

	public Long getPrcspYetaC166() {
		return prcspYetaC166;
	}

	public void setPrcspYetaC166(Long prcspYetaC166) {
		this.prcspYetaC166 = prcspYetaC166;
	}

	public Long getPrcspYetaC167() {
		return prcspYetaC167;
	}

	public void setPrcspYetaC167(Long prcspYetaC167) {
		this.prcspYetaC167 = prcspYetaC167;
	}

	public Long getNatPennPrmmSum() {
		return natPennPrmmSum;
	}

	public void setNatPennPrmmSum(Long natPennPrmmSum) {
		this.natPennPrmmSum = natPennPrmmSum;
	}

	public Long getNatPennAraPrmmSum() {
		return natPennAraPrmmSum;
	}

	public void setNatPennAraPrmmSum(Long natPennAraPrmmSum) {
		this.natPennAraPrmmSum = natPennAraPrmmSum;
	}

	public Long getNatPennDducSum() {
		return natPennDducSum;
	}

	public void setNatPennDducSum(Long natPennDducSum) {
		this.natPennDducSum = natPennDducSum;
	}

	public Long getPuoferAnty() {
		return puoferAnty;
	}

	public void setPuoferAnty(Long puoferAnty) {
		this.puoferAnty = puoferAnty;
	}

	public Long getPuoferAntyDducSum() {
		return puoferAntyDducSum;
	}

	public void setPuoferAntyDducSum(Long puoferAntyDducSum) {
		this.puoferAntyDducSum = puoferAntyDducSum;
	}

	public Long getMltymAnty() {
		return mltymAnty;
	}

	public void setMltymAnty(Long mltymAnty) {
		this.mltymAnty = mltymAnty;
	}

	public Long getMltymAntyDducSum() {
		return mltymAntyDducSum;
	}

	public void setMltymAntyDducSum(Long mltymAntyDducSum) {
		this.mltymAntyDducSum = mltymAntyDducSum;
	}

	public Long getPrtafirSchlFalymmAnty() {
		return prtafirSchlFalymmAnty;
	}

	public void setPrtafirSchlFalymmAnty(Long prtafirSchlFalymmAnty) {
		this.prtafirSchlFalymmAnty = prtafirSchlFalymmAnty;
	}

	public Long getPrtafirSchlDducSum() {
		return prtafirSchlDducSum;
	}

	public void setPrtafirSchlDducSum(Long prtafirSchlDducSum) {
		this.prtafirSchlDducSum = prtafirSchlDducSum;
	}

	public Long getSpildtnPstoficAnty() {
		return spildtnPstoficAnty;
	}

	public void setSpildtnPstoficAnty(Long spildtnPstoficAnty) {
		this.spildtnPstoficAnty = spildtnPstoficAnty;
	}

	public Long getSpildtnPstoficDducSum() {
		return spildtnPstoficDducSum;
	}

	public void setSpildtnPstoficDducSum(Long spildtnPstoficDducSum) {
		this.spildtnPstoficDducSum = spildtnPstoficDducSum;
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

	public java.lang.String getWhdgDebrBusoprRgstnum() {
		return whdgDebrBusoprRgstnum;
	}

	public void setWhdgDebrBusoprRgstnum(java.lang.String whdgDebrBusoprRgstnum) {
		this.whdgDebrBusoprRgstnum = whdgDebrBusoprRgstnum;
	}

	public Long getPrcspSeilNum() {
		return prcspSeilNum;
	}

	public void setPrcspSeilNum(Long prcspSeilNum) {
		this.prcspSeilNum = prcspSeilNum;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getPrcspTxpyrAsocYn() {
		return prcspTxpyrAsocYn;
	}

	public void setPrcspTxpyrAsocYn(java.lang.String prcspTxpyrAsocYn) {
		this.prcspTxpyrAsocYn = prcspTxpyrAsocYn;
	}

	public java.lang.String getPrcspFmnmNm() {
		return prcspFmnmNm;
	}

	public void setPrcspFmnmNm(java.lang.String prcspFmnmNm) {
		this.prcspFmnmNm = prcspFmnmNm;
	}

	public java.lang.String getPrcspBusoprRgstnum() {
		return prcspBusoprRgstnum;
	}

	public void setPrcspBusoprRgstnum(java.lang.String prcspBusoprRgstnum) {
		this.prcspBusoprRgstnum = prcspBusoprRgstnum;
	}

	public java.lang.String getPrcspDutyBgnnDt() {
		return prcspDutyBgnnDt;
	}

	public void setPrcspDutyBgnnDt(java.lang.String prcspDutyBgnnDt) {
		this.prcspDutyBgnnDt = prcspDutyBgnnDt;
	}

	public java.lang.String getPrcspDutyEndDt() {
		return prcspDutyEndDt;
	}

	public void setPrcspDutyEndDt(java.lang.String prcspDutyEndDt) {
		this.prcspDutyEndDt = prcspDutyEndDt;
	}

	public java.lang.String getPrcspReduBgnnDt() {
		return prcspReduBgnnDt;
	}

	public void setPrcspReduBgnnDt(java.lang.String prcspReduBgnnDt) {
		this.prcspReduBgnnDt = prcspReduBgnnDt;
	}

	public java.lang.String getPrcspReduEndDt() {
		return prcspReduEndDt;
	}

	public void setPrcspReduEndDt(java.lang.String prcspReduEndDt) {
		this.prcspReduEndDt = prcspReduEndDt;
	}

	public Long getPrcspPaySum() {
		return prcspPaySum;
	}

	public void setPrcspPaySum(Long prcspPaySum) {
		this.prcspPaySum = prcspPaySum;
	}

	public Long getPrcspAllwBnusSum() {
		return prcspAllwBnusSum;
	}

	public void setPrcspAllwBnusSum(Long prcspAllwBnusSum) {
		this.prcspAllwBnusSum = prcspAllwBnusSum;
	}

	public Long getPrcspRcgtnBnusSum() {
		return prcspRcgtnBnusSum;
	}

	public void setPrcspRcgtnBnusSum(Long prcspRcgtnBnusSum) {
		this.prcspRcgtnBnusSum = prcspRcgtnBnusSum;
	}

	public Long getPrcspStckEvntPrftSum() {
		return prcspStckEvntPrftSum;
	}

	public void setPrcspStckEvntPrftSum(Long prcspStckEvntPrftSum) {
		this.prcspStckEvntPrftSum = prcspStckEvntPrftSum;
	}

	public Long getPrcspEmpStkscWdrwSum() {
		return prcspEmpStkscWdrwSum;
	}

	public void setPrcspEmpStkscWdrwSum(Long prcspEmpStkscWdrwSum) {
		this.prcspEmpStkscWdrwSum = prcspEmpStkscWdrwSum;
	}

	public Long getPrcspEcteRsgtnExceSum() {
		return prcspEcteRsgtnExceSum;
	}

	public void setPrcspEcteRsgtnExceSum(Long prcspEcteRsgtnExceSum) {
		this.prcspEcteRsgtnExceSum = prcspEcteRsgtnExceSum;
	}

	public Long getPrcspAggrSum() {
		return prcspAggrSum;
	}

	public void setPrcspAggrSum(Long prcspAggrSum) {
		this.prcspAggrSum = prcspAggrSum;
	}

	public Long getFreeDtyAggrSum() {
		return freeDtyAggrSum;
	}

	public void setFreeDtyAggrSum(Long freeDtyAggrSum) {
		this.freeDtyAggrSum = freeDtyAggrSum;
	}

	public Long getReduIncmAggrSum() {
		return reduIncmAggrSum;
	}

	public void setReduIncmAggrSum(Long reduIncmAggrSum) {
		this.reduIncmAggrSum = reduIncmAggrSum;
	}

	public Long getPrcspIncmTxSum() {
		return prcspIncmTxSum;
	}

	public void setPrcspIncmTxSum(Long prcspIncmTxSum) {
		this.prcspIncmTxSum = prcspIncmTxSum;
	}

	public Long getPrcspRgonIncmTxSum() {
		return prcspRgonIncmTxSum;
	}

	public void setPrcspRgonIncmTxSum(Long prcspRgonIncmTxSum) {
		this.prcspRgonIncmTxSum = prcspRgonIncmTxSum;
	}

	public Long getPrcspNnksSum() {
		return prcspNnksSum;
	}

	public void setPrcspNnksSum(Long prcspNnksSum) {
		this.prcspNnksSum = prcspNnksSum;
	}

	public Long getPrcspHlthPrmmSum() {
		return prcspHlthPrmmSum;
	}

	public void setPrcspHlthPrmmSum(Long prcspHlthPrmmSum) {
		this.prcspHlthPrmmSum = prcspHlthPrmmSum;
	}

	public Long getPrcspLgtmRcptnSum() {
		return prcspLgtmRcptnSum;
	}

	public void setPrcspLgtmRcptnSum(Long prcspLgtmRcptnSum) {
		this.prcspLgtmRcptnSum = prcspLgtmRcptnSum;
	}

	public Long getPrcspHlthLgcptnAggr() {
		return prcspHlthLgcptnAggr;
	}

	public void setPrcspHlthLgcptnAggr(Long prcspHlthLgcptnAggr) {
		this.prcspHlthLgcptnAggr = prcspHlthLgcptnAggr;
	}

	public Long getPrcspHlthPrmmDducSum() {
		return prcspHlthPrmmDducSum;
	}

	public void setPrcspHlthPrmmDducSum(Long prcspHlthPrmmDducSum) {
		this.prcspHlthPrmmDducSum = prcspHlthPrmmDducSum;
	}

	public Long getPrcspEmymtPrmmSum() {
		return prcspEmymtPrmmSum;
	}

	public void setPrcspEmymtPrmmSum(Long prcspEmymtPrmmSum) {
		this.prcspEmymtPrmmSum = prcspEmymtPrmmSum;
	}

	public Long getPrcspEmytPrmmDducSum() {
		return prcspEmytPrmmDducSum;
	}

	public void setPrcspEmytPrmmDducSum(Long prcspEmytPrmmDducSum) {
		this.prcspEmytPrmmDducSum = prcspEmytPrmmDducSum;
	}

	public java.lang.String getPrcspPrcsYn() {
		return prcspPrcsYn;
	}

	public void setPrcspPrcsYn(java.lang.String prcspPrcsYn) {
		this.prcspPrcsYn = prcspPrcsYn;
	}

	public java.lang.String getPrcspWhdgReipSumtYn() {
		return prcspWhdgReipSumtYn;
	}

	public void setPrcspWhdgReipSumtYn(java.lang.String prcspWhdgReipSumtYn) {
		this.prcspWhdgReipSumtYn = prcspWhdgReipSumtYn;
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
