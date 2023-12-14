/**
 * 연간 후생복지비
 */
package com.app.exterms.retirement.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Remt2000VO.java
 * @Description : Remt2000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtPayr0100DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
   
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;
    
    /** set 지급공제항목코드 : payItemCd */
    private java.lang.String payItemCd;

    /** set 지급공제항목명 : payItemNm */
    private java.lang.String payItemNm;

    /** set 수당그룹코드 : extpyGrpCd */
    private java.lang.String extpyGrpCd;

    /** set 수당그룹명 : extpyGrpNm */
    private java.lang.String extpyGrpNm;

    /** set item_tm01 : itemTm01 */
    private Double itemTm01;

    /** set item_amnt01 : itemAmnt01 */
    private Long itemAmnt01;

    /** set item_tm02 : itemTm02 */
    private Double itemTm02;

    /** set item_amnt02 : itemAmnt02 */
    private Long itemAmnt02;

    /** set item_tm03 : itemTm03 */
    private Double itemTm03;

    /** set item_amnt03 : itemAmnt03 */
    private Long itemAmnt03;

    /** set item_tm04 : itemTm04 */
    private Double itemTm04;

    /** set item_amnt04 : itemAmnt04 */
    private Long itemAmnt04;

    /** set 퇴직금 급여합계 : item_tot-amnt itemTotAmnt */
    private Long itemTotAmnt;
    
    

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

	public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
	}

	public java.lang.String getCalcSevePayPsnDivCd() {
		return calcSevePayPsnDivCd;
	}

	public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
		this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
	}

	public java.lang.String getPayItemCd() {
		return payItemCd;
	}

	public void setPayItemCd(java.lang.String payItemCd) {
		this.payItemCd = payItemCd;
	}

	public java.lang.String getPayItemNm() {
		return payItemNm;
	}

	public void setPayItemNm(java.lang.String payItemNm) {
		this.payItemNm = payItemNm;
	}

	public java.lang.String getExtpyGrpCd() {
		return extpyGrpCd;
	}

	public void setExtpyGrpCd(java.lang.String extpyGrpCd) {
		this.extpyGrpCd = extpyGrpCd;
	}

	public java.lang.String getExtpyGrpNm() {
		return extpyGrpNm;
	}

	public void setExtpyGrpNm(java.lang.String extpyGrpNm) {
		this.extpyGrpNm = extpyGrpNm;
	}

	public Double getItemTm01() {
		return itemTm01;
	}

	public void setItemTm01(Double itemTm01) {
		this.itemTm01 = itemTm01;
	}

	public Long getItemAmnt01() {
		return itemAmnt01;
	}

	public void setItemAmnt01(Long itemAmnt01) {
		this.itemAmnt01 = itemAmnt01;
	}

	public Double getItemTm02() {
		return itemTm02;
	}

	public void setItemTm02(Double itemTm02) {
		this.itemTm02 = itemTm02;
	}

	public Long getItemAmnt02() {
		return itemAmnt02;
	}

	public void setItemAmnt02(Long itemAmnt02) {
		this.itemAmnt02 = itemAmnt02;
	}

	public Double getItemTm03() {
		return itemTm03;
	}

	public void setItemTm03(Double itemTm03) {
		this.itemTm03 = itemTm03;
	}

	public Long getItemAmnt03() {
		return itemAmnt03;
	}

	public void setItemAmnt03(Long itemAmnt03) {
		this.itemAmnt03 = itemAmnt03;
	}

	public Double getItemTm04() {
		return itemTm04;
	}

	public void setItemTm04(Double itemTm04) {
		this.itemTm04 = itemTm04;
	}

	public Long getItemAmnt04() {
		return itemAmnt04;
	}

	public void setItemAmnt04(Long itemAmnt04) {
		this.itemAmnt04 = itemAmnt04;
	}

	public Long getItemTotAmnt() {
		return itemTotAmnt;
	}

	public void setItemTotAmnt(Long itemTotAmnt) {
		this.itemTotAmnt = itemTotAmnt;
	}
    
    
    
}
