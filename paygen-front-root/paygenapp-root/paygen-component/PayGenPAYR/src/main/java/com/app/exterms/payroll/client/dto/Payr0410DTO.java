package com.app.exterms.payroll.client.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0410VO.java
 * @Description : Payr0410 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0410DTO  implements IsSerializable {
    private static final long serialVersionUID = 1L; 

    /** set 급여년도 : payYr */
    private java.lang.String payYr;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
    private Long typOccuGrdeMppgSeilNum;

    /** set 급여항목일련번호 : payrItemSeilNum */
    private Long payrItemSeilNum;

    /** set 급여항목코드 : payrImcd */
    private java.lang.String payrImcd;

    /** set 항목명 : itemNm */
    private java.lang.String itemNm;

    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;

    /** set 지급공제구분코드 : pymtDducDivCd */
    private java.lang.String pymtDducDivCd;

    /** set 지급공제유형코드 : pymtDducFrmCd */
    private java.lang.String pymtDducFrmCd;

    /** set 지급공제율 : pymtDducRate */
    private Double pymtDducRate;

    /** set 지급공제액 : pymtDducSum */
    private Long pymtDducSum;

    /** set 과세구분코드 : txtnDivCd */
    private java.lang.String txtnDivCd;

    /** set 비과세율 : freeDtyRate */
    private Double freeDtyRate;

    /** set 비과세금액 : freeDtySum */
    private Long freeDtySum;

    /** set 1월 : jan */
    private Boolean jan;

    /** set 2월 : feb */
    private Boolean feb;

    /** set 3월 : mar */
    private Boolean mar;

    /** set 4월 : apr */
    private Boolean apr;

    /** set 5월 : may */
    private Boolean may;

    /** set 6월 : jun */
    private Boolean jun;

    /** set 7월 : jul */
    private Boolean jul;

    /** set 8월 : aug */
    private Boolean aug;

    /** set 9월 : sep */
    private Boolean sep;

    /** set 10월 : oct */
    private Boolean oct;

    /** set 11월 : nov */
    private Boolean nov;

    /** set 12월 : dec */
    private Boolean dec;

    /** set 정렬순서 : rngeOrd */
    private Long rngeOrd;

    /** set 급여항목사용여부 : payItemUseYn */
    private Boolean payItemUseYn;

    /** set 항목적용시작일자 : itemApptnBgnnDt */
    private java.lang.String itemApptnBgnnDt;

    /** set 항목적용종료일자 : itemApptnEndDt */
    private java.lang.String itemApptnEndDt;

    /** set 일월액구분코드 : dayMnthAmntDivCd */
    private java.lang.String dayMnthAmntDivCd;

    /** set 계산기준구분코드 : calcStdDivCd */
    private java.lang.String calcStdDivCd;

    /** set 고용구분코드 : emymtDivCd */
    private java.lang.String emymtDivCd;

    /** set 통상임금여부 : usalyAmntYn */
    private Boolean usalyAmntYn;

    /** set 급여항목비고내용 : payItemNoteCtnt */
    private java.lang.String payItemNoteCtnt;

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
      

    /** set 급여관리부서코드 : payrMangDeptCd */
    private java.lang.String payrMangDeptCd;
 
    /** set 계산수식내용 : calcStdFunc */
    private java.lang.String calcStdFunc;
    
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
     
    
    /** PYSP_GRDE_CD */
    private java.lang.String pyspGrdeCd;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
      
	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    
    
      
    /**
	 * Comment : 
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Nov 23, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Nov 23, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public java.lang.String getCalcStdFunc() {
        return calcStdFunc;
    }

    public void setCalcStdFunc(java.lang.String calcStdFunc) {
        this.calcStdFunc = calcStdFunc;
    }

    public java.lang.String getPayYr() {
        return payYr;
    }

    public void setPayYr(java.lang.String payYr) {
        this.payYr = payYr;
    }

    public Long getTypOccuGrdeMppgSeilNum() {
        return typOccuGrdeMppgSeilNum;
    }

    public void setTypOccuGrdeMppgSeilNum(Long typOccuGrdeMppgSeilNum) {
        this.typOccuGrdeMppgSeilNum = typOccuGrdeMppgSeilNum;
    }

    public Long getPayrItemSeilNum() {
        return payrItemSeilNum;
    }

    public void setPayrItemSeilNum(Long payrItemSeilNum) {
        this.payrItemSeilNum = payrItemSeilNum;
    }

    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
     
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getPayrImcd() {
        return this.payrImcd;
    }
    
    public void setPayrImcd(java.lang.String payrImcd) {
        this.payrImcd = payrImcd;
    }
    
    public java.lang.String getPyspGrdeCd() {
        return this.pyspGrdeCd;
    }
    
    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getItemNm() {
        return this.itemNm;
    }
    
    public void setItemNm(java.lang.String itemNm) {
        this.itemNm = itemNm;
    }
    
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    public java.lang.String getPymtDducFrmCd() {
        return this.pymtDducFrmCd;
    }
    
    public void setPymtDducFrmCd(java.lang.String pymtDducFrmCd) {
        this.pymtDducFrmCd = pymtDducFrmCd;
    }
    
    public Double getPymtDducRate() {
        return this.pymtDducRate;
    }
    
    public void setPymtDducRate(Double pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }
    
    public Long getPymtDducSum() {
        return this.pymtDducSum;
    }
    
    public void setPymtDducSum(Long pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
    public java.lang.String getTxtnDivCd() {
        return this.txtnDivCd;
    }
    
    public void setTxtnDivCd(java.lang.String txtnDivCd) {
        this.txtnDivCd = txtnDivCd;
    }
    
    public Double getFreeDtyRate() {
        return this.freeDtyRate;
    }
    
    public void setFreeDtyRate(Double freeDtyRate) {
        this.freeDtyRate = freeDtyRate;
    }
    
    public Long getFreeDtySum() {
        return this.freeDtySum;
    }
    
    public void setFreeDtySum(Long freeDtySum) {
        this.freeDtySum = freeDtySum;
    }
    
    public Boolean getJan() {
        return this.jan;
    }
    
    public void setJan(Boolean jan) {
        this.jan = jan;
    }
    
    public Boolean getFeb() {
        return this.feb;
    }
    
    public void setFeb(Boolean feb) {
        this.feb = feb;
    }
    
    public Boolean getMar() {
        return this.mar;
    }
    
    public void setMar(Boolean mar) {
        this.mar = mar;
    }
    
    public Boolean getApr() {
        return this.apr;
    }
    
    public void setApr(Boolean apr) {
        this.apr = apr;
    }
    
    public Boolean getMay() {
        return this.may;
    }
    
    public void setMay(Boolean may) {
        this.may = may;
    }
    
    public Boolean getJun() {
        return this.jun;
    }
    
    public void setJun(Boolean jun) {
        this.jun = jun;
    }
    
    public Boolean getJul() {
        return this.jul;
    }
    
    public void setJul(Boolean jul) {
        this.jul = jul;
    }
    
    public Boolean getAug() {
        return this.aug;
    }
    
    public void setAug(Boolean aug) {
        this.aug = aug;
    }
    
    public Boolean getSep() {
        return this.sep;
    }
    
    public void setSep(Boolean sep) {
        this.sep = sep;
    }
    
    public Boolean getOct() {
        return this.oct;
    }
    
    public void setOct(Boolean oct) {
        this.oct = oct;
    }
    
    public Boolean getNov() {
        return this.nov;
    }
    
    public void setNov(Boolean nov) {
        this.nov = nov;
    }
    
    public Boolean getDec() {
        return this.dec;
    }
    
    public void setDec(Boolean dec) {
        this.dec = dec;
    }
    
    public Long getRngeOrd() {
        return this.rngeOrd;
    }
    
    public void setRngeOrd(Long rngeOrd) {
        this.rngeOrd = rngeOrd;
    }
    
    public Boolean getPayItemUseYn() {
        return this.payItemUseYn;
    }
    
    public void setPayItemUseYn(Boolean payItemUseYn) {
        this.payItemUseYn = payItemUseYn;
    }
    
    public java.lang.String getItemApptnBgnnDt() {
        return this.itemApptnBgnnDt;
    }
    
    public void setItemApptnBgnnDt(java.lang.String itemApptnBgnnDt) {
        this.itemApptnBgnnDt = itemApptnBgnnDt;
    }
    
    public java.lang.String getItemApptnEndDt() {
        return this.itemApptnEndDt;
    }
    
    public void setItemApptnEndDt(java.lang.String itemApptnEndDt) {
        this.itemApptnEndDt = itemApptnEndDt;
    }
    
    public java.lang.String getDayMnthAmntDivCd() {
        return this.dayMnthAmntDivCd;
    }
    
    public void setDayMnthAmntDivCd(java.lang.String dayMnthAmntDivCd) {
        this.dayMnthAmntDivCd = dayMnthAmntDivCd;
    }
    
    public java.lang.String getCalcStdDivCd() {
        return this.calcStdDivCd;
    }
    
    public void setCalcStdDivCd(java.lang.String calcStdDivCd) {
        this.calcStdDivCd = calcStdDivCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public Boolean getUsalyAmntYn() {
        return this.usalyAmntYn;
    }
    
    public void setUsalyAmntYn(Boolean usalyAmntYn) {
        this.usalyAmntYn = usalyAmntYn;
    }
    
    public java.lang.String getPayItemNoteCtnt() {
        return this.payItemNoteCtnt;
    }
    
    public void setPayItemNoteCtnt(java.lang.String payItemNoteCtnt) {
        this.payItemNoteCtnt = payItemNoteCtnt;
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
