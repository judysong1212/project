package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Class Name : Yeta1000VO.java
 * @Description : Yeta1000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Pyyt0302Exl_2023_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    ArrayList<Pyyt0302ExlVO> pyyt0302List = new ArrayList<Pyyt0302ExlVO>();
    
    /** set 급여구분코드 : payCd */
    private java.lang.String payCd;
    
    
    
    public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
	private java.lang.String juminCk;
    

	/** set 급여항목코드 : pyytItemCd */
    private java.lang.String pyytItemCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 지급년월 : pyytYrMnth */
    private java.lang.String pyytYrMnth;

    /** set 지급공제구분코드 : pyytPymtDducCd */
    private java.lang.String pyytPymtDducCd;

    /** set 지급공제금액 : pyytPymtDducSum */
    private java.lang.String pyytPymtDducSum;

    /** set 지급공제과세금액 : pyytPyddTxtnAmnt */
    private java.lang.String pyytPyddTxtnAmnt;

    /** set 지급공제비과세금액 : pyytPyddFreeDtySum */
    private java.lang.String pyytPyddFreeDtySum;

    /** set 연말정산_기부금코드 : pyytYrtxDotnCd */
    private java.lang.String pyytYrtxDotnCd;

    /** set 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
    private java.lang.String pyytYtfeDtyReduCd;

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

	public ArrayList<Pyyt0302ExlVO> getPyyt0302List() {
		return pyyt0302List;
	}

	public void setPyyt0302List(ArrayList<Pyyt0302ExlVO> pyyt0302List) {
		this.pyyt0302List = pyyt0302List;
	}

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

	public java.lang.String getPyytItemCd() {
		return pyytItemCd;
	}

	public void setPyytItemCd(java.lang.String pyytItemCd) {
		this.pyytItemCd = pyytItemCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getPyytYrMnth() {
		return pyytYrMnth;
	}

	public void setPyytYrMnth(java.lang.String pyytYrMnth) {
		this.pyytYrMnth = pyytYrMnth;
	}

	public java.lang.String getPyytPymtDducCd() {
		return pyytPymtDducCd;
	}

	public void setPyytPymtDducCd(java.lang.String pyytPymtDducCd) {
		this.pyytPymtDducCd = pyytPymtDducCd;
	}

	public java.lang.String getPyytPymtDducSum() {
		return pyytPymtDducSum;
	}

	public void setPyytPymtDducSum(java.lang.String pyytPymtDducSum) {
		this.pyytPymtDducSum = pyytPymtDducSum;
	}

	public java.lang.String getPyytPyddTxtnAmnt() {
		return pyytPyddTxtnAmnt;
	}

	public void setPyytPyddTxtnAmnt(java.lang.String pyytPyddTxtnAmnt) {
		this.pyytPyddTxtnAmnt = pyytPyddTxtnAmnt;
	}

	public java.lang.String getPyytPyddFreeDtySum() {
		return pyytPyddFreeDtySum;
	}

	public void setPyytPyddFreeDtySum(java.lang.String pyytPyddFreeDtySum) {
		this.pyytPyddFreeDtySum = pyytPyddFreeDtySum;
	}

	public java.lang.String getPyytYrtxDotnCd() {
		return pyytYrtxDotnCd;
	}

	public void setPyytYrtxDotnCd(java.lang.String pyytYrtxDotnCd) {
		this.pyytYrtxDotnCd = pyytYrtxDotnCd;
	}

	public java.lang.String getPyytYtfeDtyReduCd() {
		return pyytYtfeDtyReduCd;
	}

	public void setPyytYtfeDtyReduCd(java.lang.String pyytYtfeDtyReduCd) {
		this.pyytYtfeDtyReduCd = pyytYtfeDtyReduCd;
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

	public java.lang.String getJuminCk() {
		return juminCk;
	}

	public void setJuminCk(java.lang.String juminCk) {
		this.juminCk = juminCk;
	}
    
	

}
