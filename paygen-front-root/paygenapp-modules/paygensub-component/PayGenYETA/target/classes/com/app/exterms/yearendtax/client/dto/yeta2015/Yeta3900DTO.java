package com.app.exterms.yearendtax.client.dto.yeta2015;

import java.io.Serializable;

/**
 * @Class Name : Yeta3900VO.java
 * @Description : Yeta3900VO class
 * @Modification Information
 *
 * @author HyunMin
 * @since 2016.01.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */


public class Yeta3900DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** set 사업장코드 : dpobCd */
	private java.lang.String dpobCd;

	/** set 지급년월 : pymtYrMnth */
	private java.lang.String pymtYrMnth;

	/** set 급여구분코드 : payCd */
	private java.lang.String payCd;

	/** set 급여항목코드 : payItemCd */
	private java.lang.String payItemCd;

	/** set 급여항목일련번호 : payItemSeilNum */
	private Long payItemSeilNum;

	/** set SYSTEMKEY : systemkey */
	private java.lang.String systemkey;

	/** set 지급공제구분코드 : pymtDducDivCd */
	private java.lang.String pymtDducDivCd;

	/** set 지급공제금액 : pymtDducSum */
	private Long pymtDducSum;

	/** set 지급공제과세금액 : pymtDducTxtnAmnt */
	private Long pymtDducTxtnAmnt;

	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
	private Long pymtDducFreeDtySum;

	/** set 급여지급일자 : payPymtDt */
	private java.lang.String payPymtDt;

	/** set 급여항목명 : payItemNm */
	private java.lang.String payItemNm;

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

	public java.lang.String getPymtYrMnth() {
		return pymtYrMnth;
	}

	public void setPymtYrMnth(java.lang.String pymtYrMnth) {
		this.pymtYrMnth = pymtYrMnth;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}
	
	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public Long getPayItemSeilNum() {
		return payItemSeilNum;
	}

	public void setPayItemSeilNum(Long payItemSeilNum) {
		this.payItemSeilNum = payItemSeilNum;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
		this.pymtDducDivCd = pymtDducDivCd;
	}

	public Long getPymtDducSum() {
		return pymtDducSum;
	}

	public void setPymtDducSum(Long pymtDducSum) {
		this.pymtDducSum = pymtDducSum;
	}

	public Long getPymtDducTxtnAmnt() {
		return pymtDducTxtnAmnt;
	}

	public void setPymtDducTxtnAmnt(Long pymtDducTxtnAmnt) {
		this.pymtDducTxtnAmnt = pymtDducTxtnAmnt;
	}

	public Long getPymtDducFreeDtySum() {
		return pymtDducFreeDtySum;
	}

	public void setPymtDducFreeDtySum(Long pymtDducFreeDtySum) {
		this.pymtDducFreeDtySum = pymtDducFreeDtySum;
	}

	public java.lang.String getPayPymtDt() {
		return payPymtDt;
	}

	public void setPayPymtDt(java.lang.String payPymtDt) {
		this.payPymtDt = payPymtDt;
	}

	public java.lang.String getPayItemNm() {
		return payItemNm;
	}

	public void setPayItemNm(java.lang.String payItemNm) {
		this.payItemNm = payItemNm;
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
	
	
	//---- PSNL0100
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;
    
    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    /** set 부서코드 : deptCd */
    private java.lang.String deptCd;

    /** set 사업코드 : businCd */
    private java.lang.String businCd;
    
    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getDeptCd() {
		return deptCd;
	}

	public void setDeptCd(java.lang.String deptCd) {
		this.deptCd = deptCd;
	}

	public java.lang.String getBusinCd() {
		return businCd;
	}

	public void setBusinCd(java.lang.String businCd) {
		this.businCd = businCd;
	}

	public java.lang.String getTypOccuCd() {
		return typOccuCd;
	}

	public void setTypOccuCd(java.lang.String typOccuCd) {
		this.typOccuCd = typOccuCd;
	}

   // private List<Yeta3900VO> yeta3900List = new ArrayList<Yeta3900VO>();	

	//public List<Yeta3900VO> getYeta3900List() {
	//	return yeta3900List;
	//}

	//public void setYeta3900List(List<Yeta3900VO> yeta3900List) {
	//	this.yeta3900List = yeta3900List;
	//}

	
	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	@Override
	public String toString() {
		return "Yeta3900VO [dpobCd=" + dpobCd + ", pymtYrMnth=" + pymtYrMnth
				+ ", payCd=" + payCd + ", resnRegnNum=" + resnRegnNum
				+ ", payItemCd=" + payItemCd + ", payItemSeilNum="
				+ payItemSeilNum + ", systemkey=" + systemkey
				+ ", pymtDducDivCd=" + pymtDducDivCd + ", pymtDducSum="
				+ pymtDducSum + ", pymtDducTxtnAmnt=" + pymtDducTxtnAmnt
				+ ", pymtDducFreeDtySum=" + pymtDducFreeDtySum + ", payPymtDt="
				+ payPymtDt + ", payItemNm=" + payItemNm + ", kybdr=" + kybdr
				+ ", inptDt=" + inptDt + ", inptAddr=" + inptAddr + ", ismt="
				+ ismt + ", revnDt=" + revnDt + ", revnAddr=" + revnAddr + "]";
	}
}