package com.app.smrmf.pkg.insr.insurance.service;

import java.io.Serializable;

/**
 * @Class Name : Bord0400VO.java
 * @Description : Bord0400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PkgPayrInsrStdVO implements Serializable {
    private static final long serialVersionUID = 1L;
     

/** set 건강보험_기준년도 : hlthInsrStdYr */
private java.lang.String hlthInsrStdYr;

/** set 건강보험_최저보수월액 : hlthInsrMinmMnthRuntnAmnt */
private java.math.BigDecimal hlthInsrMinmMnthRuntnAmnt;

/** set 건강보험_최고보수월액 : hlthInsrBstMnthRuntnAmnt */
private java.math.BigDecimal hlthInsrBstMnthRuntnAmnt;
 
/** set 건강보험본인부담요율 : hlthInsrHmlfBrdnApmrt */
private java.math.BigDecimal hlthInsrHmlfBrdnApmrt;
 
/** set 건강보험_요양본인부담요율 : hlthRcptnHmlfBrdnApmrt */
private java.math.BigDecimal hlthRcptnHmlfBrdnApmrt;
 
/** set 국민연금_기준년도 : natPennStdYr */
private java.lang.String natPennStdYr; 

/** set 국민연금최저소득월액 : natPennMinmIncmMnthAmnt */
private java.math.BigDecimal natPennMinmIncmMnthAmnt;

/** set 국민연금최고소득월액 : natPennBstIncmMnthAmnt */
private java.math.BigDecimal natPennBstIncmMnthAmnt;

/** set 국민연금사용자부담요율 : natPennUsrBrdnApmrt */
//private java.math.BigDecimal natPennUsrBrdnApmrt;

/** set 국인연금본인부담요율 : natPennHmlfBrdnApmrt */
private java.math.BigDecimal natPennHmlfBrdnApmrt;
 

/** set 고용보험_기준년도 : umytInsrStdYr */
private java.lang.String umytInsrStdYr;
  
/** set 고용보험_최저보수월액 : umytInsrMinmIncmMnthAmnt */
private java.math.BigDecimal umytInsrMinmIncmMnthAmnt;

/** set 고용보험_최고보수월액 : umytInsrBstIncmMnthAmnt */
private java.math.BigDecimal umytInsrBstIncmMnthAmnt;

/** set 고용보험본인부담요율 : umytInsrHmlfBrdnApmrt */
private java.math.BigDecimal umytInsrHmlfBrdnApmrt;

/** set 고용보험사용자부담요율 : umytInsrUsrBrdnApmrt */
private java.math.BigDecimal umytInsrUsrBrdnApmrt;

/** set 고용보험사용자_고용안정등사업요율 : umytInsrUsrSftyEbisApmrt */
private java.math.BigDecimal umytInsrUsrSftyEbisApmrt;
  
/** set 산재보험_기준년도 : idtlAccdtInsurStdYr */
private java.lang.String idtlAccdtInsurStdYr;
  
/** set 산재보험사용자부담요율 : idtlAccdtInsurUsrApmrt */
private java.math.BigDecimal idtlAccdtInsurUsrApmrt;


public java.lang.String getHlthInsrStdYr() {
	return hlthInsrStdYr;
}

public void setHlthInsrStdYr(java.lang.String hlthInsrStdYr) {
	this.hlthInsrStdYr = hlthInsrStdYr;
}

public java.math.BigDecimal getHlthInsrMinmMnthRuntnAmnt() {
	return hlthInsrMinmMnthRuntnAmnt;
}

public void setHlthInsrMinmMnthRuntnAmnt(
		java.math.BigDecimal hlthInsrMinmMnthRuntnAmnt) {
	this.hlthInsrMinmMnthRuntnAmnt = hlthInsrMinmMnthRuntnAmnt;
}

public java.math.BigDecimal getHlthInsrBstMnthRuntnAmnt() {
	return hlthInsrBstMnthRuntnAmnt;
}

public void setHlthInsrBstMnthRuntnAmnt(
		java.math.BigDecimal hlthInsrBstMnthRuntnAmnt) {
	this.hlthInsrBstMnthRuntnAmnt = hlthInsrBstMnthRuntnAmnt;
}

public java.math.BigDecimal getHlthInsrHmlfBrdnApmrt() {
	return hlthInsrHmlfBrdnApmrt;
}

public void setHlthInsrHmlfBrdnApmrt(java.math.BigDecimal hlthInsrHmlfBrdnApmrt) {
	this.hlthInsrHmlfBrdnApmrt = hlthInsrHmlfBrdnApmrt;
}

public java.math.BigDecimal getHlthRcptnHmlfBrdnApmrt() {
	return hlthRcptnHmlfBrdnApmrt;
}

public void setHlthRcptnHmlfBrdnApmrt(
		java.math.BigDecimal hlthRcptnHmlfBrdnApmrt) {
	this.hlthRcptnHmlfBrdnApmrt = hlthRcptnHmlfBrdnApmrt;
}

public java.lang.String getNatPennStdYr() {
	return natPennStdYr;
}

public void setNatPennStdYr(java.lang.String natPennStdYr) {
	this.natPennStdYr = natPennStdYr;
}

public java.math.BigDecimal getNatPennMinmIncmMnthAmnt() {
	return natPennMinmIncmMnthAmnt;
}

public void setNatPennMinmIncmMnthAmnt(
		java.math.BigDecimal natPennMinmIncmMnthAmnt) {
	this.natPennMinmIncmMnthAmnt = natPennMinmIncmMnthAmnt;
}

public java.math.BigDecimal getNatPennBstIncmMnthAmnt() {
	return natPennBstIncmMnthAmnt;
}

public void setNatPennBstIncmMnthAmnt(
		java.math.BigDecimal natPennBstIncmMnthAmnt) {
	this.natPennBstIncmMnthAmnt = natPennBstIncmMnthAmnt;
}

public java.math.BigDecimal getNatPennHmlfBrdnApmrt() {
	return natPennHmlfBrdnApmrt;
}

public void setNatPennHmlfBrdnApmrt(java.math.BigDecimal natPennHmlfBrdnApmrt) {
	this.natPennHmlfBrdnApmrt = natPennHmlfBrdnApmrt;
}

public java.lang.String getUmytInsrStdYr() {
	return umytInsrStdYr;
}

public void setUmytInsrStdYr(java.lang.String umytInsrStdYr) {
	this.umytInsrStdYr = umytInsrStdYr;
}

public java.math.BigDecimal getUmytInsrMinmIncmMnthAmnt() {
	return umytInsrMinmIncmMnthAmnt;
}

public void setUmytInsrMinmIncmMnthAmnt(
		java.math.BigDecimal umytInsrMinmIncmMnthAmnt) {
	this.umytInsrMinmIncmMnthAmnt = umytInsrMinmIncmMnthAmnt;
}

public java.math.BigDecimal getUmytInsrBstIncmMnthAmnt() {
	return umytInsrBstIncmMnthAmnt;
}

public void setUmytInsrBstIncmMnthAmnt(
		java.math.BigDecimal umytInsrBstIncmMnthAmnt) {
	this.umytInsrBstIncmMnthAmnt = umytInsrBstIncmMnthAmnt;
}

public java.math.BigDecimal getUmytInsrHmlfBrdnApmrt() {
	return umytInsrHmlfBrdnApmrt;
}

public void setUmytInsrHmlfBrdnApmrt(java.math.BigDecimal umytInsrHmlfBrdnApmrt) {
	this.umytInsrHmlfBrdnApmrt = umytInsrHmlfBrdnApmrt;
}

public java.math.BigDecimal getUmytInsrUsrBrdnApmrt() {
	return umytInsrUsrBrdnApmrt;
}

public void setUmytInsrUsrBrdnApmrt(java.math.BigDecimal umytInsrUsrBrdnApmrt) {
	this.umytInsrUsrBrdnApmrt = umytInsrUsrBrdnApmrt;
}

public java.math.BigDecimal getUmytInsrUsrSftyEbisApmrt() {
	return umytInsrUsrSftyEbisApmrt;
}

public void setUmytInsrUsrSftyEbisApmrt(
		java.math.BigDecimal umytInsrUsrSftyEbisApmrt) {
	this.umytInsrUsrSftyEbisApmrt = umytInsrUsrSftyEbisApmrt;
}

public java.lang.String getIdtlAccdtInsurStdYr() {
	return idtlAccdtInsurStdYr;
}

public void setIdtlAccdtInsurStdYr(java.lang.String idtlAccdtInsurStdYr) {
	this.idtlAccdtInsurStdYr = idtlAccdtInsurStdYr;
}

public java.math.BigDecimal getIdtlAccdtInsurUsrApmrt() {
	return idtlAccdtInsurUsrApmrt;
}

public void setIdtlAccdtInsurUsrApmrt(
		java.math.BigDecimal idtlAccdtInsurUsrApmrt) {
	this.idtlAccdtInsurUsrApmrt = idtlAccdtInsurUsrApmrt;
}


 
}
