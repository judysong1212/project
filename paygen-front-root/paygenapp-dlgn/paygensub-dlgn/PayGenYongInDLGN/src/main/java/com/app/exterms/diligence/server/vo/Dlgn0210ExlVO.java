package com.app.exterms.diligence.server.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Class Name : Dlgn0210VO.java
 * @Description : Dlgn0210 VO class
 * @Modification Information
 *
 * @author admin
 * @since 2016.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0210ExlVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    ArrayList<Dlgn0210ExlVO> dlgn0210List = new ArrayList<Dlgn0210ExlVO>();
    
    public ArrayList<Dlgn0210ExlVO> getDlgn0210List() {
		return dlgn0210List;
	}

	public void setDlgn0210List(ArrayList<Dlgn0210ExlVO> dlgn0210List) {
		this.dlgn0210List = dlgn0210List;
	}
	
	/** 
	 * 시간외근무 엑셀 업로드를 위한 구분자 
	 * */
	 private java.lang.String dlgnFlag;
	 
    
	public java.lang.String getDlgnFlag() {
		return dlgnFlag;
	}

	public void setDlgnFlag(java.lang.String dlgnFlag) {
		this.dlgnFlag = dlgnFlag;
	}
    
	/** set 사업장코드 : DPOB_CD */
    private java.lang.String dpobCd;
    
    /** set SYSTEMKEY : SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** set 근태년월 : DILNLAZ_YR_MNTH */
    private java.lang.String dilnlazYrMnth;
    
    /** set 급여구분코드 : PAY_CD */
    private java.lang.String payCd;

    /** set 근태_적용일자 : DILNLAZ_APPTN_DT */
    private java.lang.String dilnlazApptnDt;
    
    /** set 입력자 : KYBDR */
    private java.lang.String kybdr;
    
    /** set 입력일자 : INPT_DT */
    private java.lang.String inptDt;
    
    /** set 입력주소 : INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** set 수정자 : ISMT */
    private java.lang.String ismt;
    
    /** set 수정일자 : REVN_DT */
    private java.lang.String revnDt;
    
    /** set 수정주소 : REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    private java.lang.String dilnlazDutyBgnnDt;

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    private java.lang.String dilnlazDutyEndDt;
    
    
    /** set 근태_초과근무여부 : DILNLAZ_DUTY_YN */
    private java.lang.String dilnlazDutyYn;
    
    /** set 근태_초과근무시간 : DILNLAZ_DUTY_TM */
    private java.lang.String dilnlazDutyTm;
    
    /** set 근태_야근여부 : DILNLAZ_NTOT_YN */
    private java.lang.String dilnlazNtotYn;
    
    /** set 근태_야근시간 : DILNLAZ_NTOT_TM */
    private java.lang.String dilnlazNtotTm;
    
    /** set 근태_시간외근무여부 : DILNLAZ_TM_RST_DUTY_YN */
    private java.lang.String dilnlazTmRstDutyYn;
    
    /** set 근태_시간외근무시간 : DILNLAZ_TM_RST_DUTY_TM */
    private java.lang.String dilnlazTmRstDutyTm;
    
    /** set 근태_휴일근무여부 : DILNLAZ_HODY_DUTY_YN */
    private java.lang.String dilnlazHodyDutyYn;
    
    /** set 근태_휴일근무시간 : DILNLAZ_HODY_DUTY_TM */
    private java.lang.String dilnlazHodyDutyTm;
    
    /** set 근태_휴일연장근무시간 : DILNLAZ_HODY_NTOT_TM */
    private java.lang.String dilnlazHodyNtotTm;

    /** set 근태_초과근무년월 : DILNLAZ_EXCE_DUTY_YR_MNTH */
    private java.lang.String dilnlazExceDutyYrMnth;
    
    /** set 근태_시간외출근시간 : DILNLAZ_DUTY_ST_TM */
    private java.lang.String dilnlazDutyStTm;
    
    /** set 근태_시간외퇴근시간 : DILNLAZ_DUTY_ED_TM */
    private java.lang.String dilnlazDutyEdTm;
    
    /** set 근태_시간외근무시간(분단위) : DILNLAZ_TM_RST_DUTY_MIN */
    private java.lang.String dilnlazTmRstDutyMin;
    



	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
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

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getDilnlazYrMnth() {
		return dilnlazYrMnth;
	}

	public void setDilnlazYrMnth(java.lang.String dilnlazYrMnth) {
		this.dilnlazYrMnth = dilnlazYrMnth;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getDilnlazApptnDt() {
		return dilnlazApptnDt;
	}

	public void setDilnlazApptnDt(java.lang.String dilnlazApptnDt) {
		this.dilnlazApptnDt = dilnlazApptnDt;
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

	public java.lang.String getDilnlazDutyBgnnDt() {
		return dilnlazDutyBgnnDt;
	}

	public void setDilnlazDutyBgnnDt(java.lang.String dilnlazDutyBgnnDt) {
		this.dilnlazDutyBgnnDt = dilnlazDutyBgnnDt;
	}

	public java.lang.String getDilnlazDutyEndDt() {
		return dilnlazDutyEndDt;
	}

	public void setDilnlazDutyEndDt(java.lang.String dilnlazDutyEndDt) {
		this.dilnlazDutyEndDt = dilnlazDutyEndDt;
	}

	public java.lang.String getDilnlazDutyYn() {
		return dilnlazDutyYn;
	}

	public void setDilnlazDutyYn(java.lang.String dilnlazDutyYn) {
		this.dilnlazDutyYn = dilnlazDutyYn;
	}

	public java.lang.String getDilnlazDutyTm() {
		return dilnlazDutyTm;
	}

	public void setDilnlazDutyTm(java.lang.String dilnlazDutyTm) {
		this.dilnlazDutyTm = dilnlazDutyTm;
	}

	public java.lang.String getDilnlazNtotYn() {
		return dilnlazNtotYn;
	}

	public void setDilnlazNtotYn(java.lang.String dilnlazNtotYn) {
		this.dilnlazNtotYn = dilnlazNtotYn;
	}

	public java.lang.String getDilnlazNtotTm() {
		return dilnlazNtotTm;
	}

	public void setDilnlazNtotTm(java.lang.String dilnlazNtotTm) {
		this.dilnlazNtotTm = dilnlazNtotTm;
	}

	public java.lang.String getDilnlazTmRstDutyYn() {
		return dilnlazTmRstDutyYn;
	}

	public void setDilnlazTmRstDutyYn(java.lang.String dilnlazTmRstDutyYn) {
		this.dilnlazTmRstDutyYn = dilnlazTmRstDutyYn;
	}

	public java.lang.String getDilnlazTmRstDutyTm() {
		return dilnlazTmRstDutyTm;
	}

	public void setDilnlazTmRstDutyTm(java.lang.String dilnlazTmRstDutyTm) {
		this.dilnlazTmRstDutyTm = dilnlazTmRstDutyTm;
	}

	public java.lang.String getDilnlazHodyDutyYn() {
		return dilnlazHodyDutyYn;
	}

	public void setDilnlazHodyDutyYn(java.lang.String dilnlazHodyDutyYn) {
		this.dilnlazHodyDutyYn = dilnlazHodyDutyYn;
	}

	public java.lang.String getDilnlazHodyDutyTm() {
		return dilnlazHodyDutyTm;
	}

	public void setDilnlazHodyDutyTm(java.lang.String dilnlazHodyDutyTm) {
		this.dilnlazHodyDutyTm = dilnlazHodyDutyTm;
	}

	public java.lang.String getDilnlazExceDutyYrMnth() {
		return dilnlazExceDutyYrMnth;
	}

	public void setDilnlazExceDutyYrMnth(java.lang.String dilnlazExceDutyYrMnth) {
		this.dilnlazExceDutyYrMnth = dilnlazExceDutyYrMnth;
	}

	public java.lang.String getDilnlazDutyStTm() {
		return dilnlazDutyStTm;
	}

	public void setDilnlazDutyStTm(java.lang.String dilnlazDutyStTm) {
		this.dilnlazDutyStTm = dilnlazDutyStTm;
	}

	public java.lang.String getDilnlazDutyEdTm() {
		return dilnlazDutyEdTm;
	}

	public void setDilnlazDutyEdTm(java.lang.String dilnlazDutyEdTm) {
		this.dilnlazDutyEdTm = dilnlazDutyEdTm;
	}

	public java.lang.String getDilnlazTmRstDutyMin() {
		return dilnlazTmRstDutyMin;
	}

	public void setDilnlazTmRstDutyMin(java.lang.String dilnlazTmRstDutyMin) {
		this.dilnlazTmRstDutyMin = dilnlazTmRstDutyMin;
	}

	public java.lang.String getDilnlazHodyNtotTm() {
		return dilnlazHodyNtotTm;
	}

	public void setDilnlazHodyNtotTm(java.lang.String dilnlazHodyNtotTm) {
		this.dilnlazHodyNtotTm = dilnlazHodyNtotTm;
	}
	
	
	
}
