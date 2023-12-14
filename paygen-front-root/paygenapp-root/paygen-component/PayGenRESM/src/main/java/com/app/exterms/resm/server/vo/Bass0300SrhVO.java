package com.app.exterms.resm.server.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : Payr0900DefaultVO.java
 * @Description : Payr0900 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0300SrhVO implements Serializable {
	 
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
   
    /** DPOB_CD */
    private java.lang.String dpobCd; 

    /** set 공통코드 : commCd */
    private java.lang.String commCd;

    /** set 대표코드 : rpsttvCd */
    private java.lang.String rpsttvCd;

    /** set 세부코드 : dtlCd */
    private java.lang.String dtlCd;

    /** set 공통코드명 : commCdNm */
    private java.lang.String commCdNm;

    /** set 약어명 : abbrNm */
    private java.lang.String abbrNm;

    /** set 영문명 : engNm */
    private java.lang.String engNm;

    /** set 관리항목01 : mangeItem01 */
    private java.lang.String mangeItem01;

    /** set 관리항목02 : mangeItem02 */
    private java.lang.String mangeItem02;

    /** set 관리항목03 : mangeItem03 */
    private java.lang.String mangeItem03;

    /** set 관리항목04 : mangeItem04 */
    private java.lang.String mangeItem04;

    /** set 관리항목05 : mangeItem05 */
    private java.lang.String mangeItem05;

    /** set 관리항목06 : mangeItem06 */
    private java.lang.String mangeItem06;

    /** set 관리항목07 : mangeItem07 */
    private java.lang.String mangeItem07;

    /** set 관리항목08 : mangeItem08 */
    private java.lang.String mangeItem08;

    /** set 관리항목09 : mangeItem09 */
    private java.lang.String mangeItem09;

    /** set 관리항목10 : mangeItem10 */
    private java.lang.String mangeItem10;

    /** set 관리항목11 : mangeItem11 */
    private java.lang.String mangeItem11;

    /** set 관리항목12 : mangeItem12 */
    private java.lang.String mangeItem12;

    /** set 관리항목13 : mangeItem13 */
    private java.lang.String mangeItem13;

    /** set 관리항목14 : mangeItem14 */
    private java.lang.String mangeItem14;

    /** set 관리항목15 : mangeItem15 */
    private java.lang.String mangeItem15;

    /** set 관리항목16 : mangeItem16 */
    private java.lang.String mangeItem16;

    /** set 관리항목17 : mangeItem17 */
    private java.lang.String mangeItem17;

    /** set 관리항목18 : mangeItem18 */
    private java.lang.String mangeItem18;

    /** set 관리항목19 : mangeItem19 */
    private java.lang.String mangeItem19;

    /** set 관리항목20 : mangeItem20 */
    private java.lang.String mangeItem20;

    /** set 코드TREE레벨 : cdTreeLvl */
    private java.lang.String cdTreeLvl;

    /** set 순서 : ord */
    private java.math.BigDecimal ord;

    /** set 오픈여부 : opnYn */
    private java.lang.String opnYn;

    /** set 사용여부 : useYn */
    private java.lang.String useYn;

    /** set 비고 : note */
    private java.lang.String note;

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

    /** set 수정자주소 : revnAddr */
    private java.lang.String revnAddr;   
    
    
    
	public java.lang.String getCommCd() {
		return commCd;
	}

	public void setCommCd(java.lang.String commCd) {
		this.commCd = commCd;
	}

	public java.lang.String getRpsttvCd() {
		return rpsttvCd;
	}

	public void setRpsttvCd(java.lang.String rpsttvCd) {
		this.rpsttvCd = rpsttvCd;
	}

	public java.lang.String getDtlCd() {
		return dtlCd;
	}

	public void setDtlCd(java.lang.String dtlCd) {
		this.dtlCd = dtlCd;
	}

	public java.lang.String getCommCdNm() {
		return commCdNm;
	}

	public void setCommCdNm(java.lang.String commCdNm) {
		this.commCdNm = commCdNm;
	}

	public java.lang.String getAbbrNm() {
		return abbrNm;
	}

	public void setAbbrNm(java.lang.String abbrNm) {
		this.abbrNm = abbrNm;
	}

	public java.lang.String getEngNm() {
		return engNm;
	}

	public void setEngNm(java.lang.String engNm) {
		this.engNm = engNm;
	}

	public java.lang.String getMangeItem01() {
		return mangeItem01;
	}

	public void setMangeItem01(java.lang.String mangeItem01) {
		this.mangeItem01 = mangeItem01;
	}

	public java.lang.String getMangeItem02() {
		return mangeItem02;
	}

	public void setMangeItem02(java.lang.String mangeItem02) {
		this.mangeItem02 = mangeItem02;
	}

	public java.lang.String getMangeItem03() {
		return mangeItem03;
	}

	public void setMangeItem03(java.lang.String mangeItem03) {
		this.mangeItem03 = mangeItem03;
	}

	public java.lang.String getMangeItem04() {
		return mangeItem04;
	}

	public void setMangeItem04(java.lang.String mangeItem04) {
		this.mangeItem04 = mangeItem04;
	}

	public java.lang.String getMangeItem05() {
		return mangeItem05;
	}

	public void setMangeItem05(java.lang.String mangeItem05) {
		this.mangeItem05 = mangeItem05;
	}

	public java.lang.String getMangeItem06() {
		return mangeItem06;
	}

	public void setMangeItem06(java.lang.String mangeItem06) {
		this.mangeItem06 = mangeItem06;
	}

	public java.lang.String getMangeItem07() {
		return mangeItem07;
	}

	public void setMangeItem07(java.lang.String mangeItem07) {
		this.mangeItem07 = mangeItem07;
	}

	public java.lang.String getMangeItem08() {
		return mangeItem08;
	}

	public void setMangeItem08(java.lang.String mangeItem08) {
		this.mangeItem08 = mangeItem08;
	}

	public java.lang.String getMangeItem09() {
		return mangeItem09;
	}

	public void setMangeItem09(java.lang.String mangeItem09) {
		this.mangeItem09 = mangeItem09;
	}

	public java.lang.String getMangeItem10() {
		return mangeItem10;
	}

	public void setMangeItem10(java.lang.String mangeItem10) {
		this.mangeItem10 = mangeItem10;
	}

	public java.lang.String getMangeItem11() {
		return mangeItem11;
	}

	public void setMangeItem11(java.lang.String mangeItem11) {
		this.mangeItem11 = mangeItem11;
	}

	public java.lang.String getMangeItem12() {
		return mangeItem12;
	}

	public void setMangeItem12(java.lang.String mangeItem12) {
		this.mangeItem12 = mangeItem12;
	}

	public java.lang.String getMangeItem13() {
		return mangeItem13;
	}

	public void setMangeItem13(java.lang.String mangeItem13) {
		this.mangeItem13 = mangeItem13;
	}

	public java.lang.String getMangeItem14() {
		return mangeItem14;
	}

	public void setMangeItem14(java.lang.String mangeItem14) {
		this.mangeItem14 = mangeItem14;
	}

	public java.lang.String getMangeItem15() {
		return mangeItem15;
	}

	public void setMangeItem15(java.lang.String mangeItem15) {
		this.mangeItem15 = mangeItem15;
	}

	public java.lang.String getMangeItem16() {
		return mangeItem16;
	}

	public void setMangeItem16(java.lang.String mangeItem16) {
		this.mangeItem16 = mangeItem16;
	}

	public java.lang.String getMangeItem17() {
		return mangeItem17;
	}

	public void setMangeItem17(java.lang.String mangeItem17) {
		this.mangeItem17 = mangeItem17;
	}

	public java.lang.String getMangeItem18() {
		return mangeItem18;
	}

	public void setMangeItem18(java.lang.String mangeItem18) {
		this.mangeItem18 = mangeItem18;
	}

	public java.lang.String getMangeItem19() {
		return mangeItem19;
	}

	public void setMangeItem19(java.lang.String mangeItem19) {
		this.mangeItem19 = mangeItem19;
	}

	public java.lang.String getMangeItem20() {
		return mangeItem20;
	}

	public void setMangeItem20(java.lang.String mangeItem20) {
		this.mangeItem20 = mangeItem20;
	}

	public java.lang.String getCdTreeLvl() {
		return cdTreeLvl;
	}

	public void setCdTreeLvl(java.lang.String cdTreeLvl) {
		this.cdTreeLvl = cdTreeLvl;
	}

	public java.math.BigDecimal getOrd() {
		return ord;
	}

	public void setOrd(java.math.BigDecimal ord) {
		this.ord = ord;
	}

	public java.lang.String getOpnYn() {
		return opnYn;
	}

	public void setOpnYn(java.lang.String opnYn) {
		this.opnYn = opnYn;
	}

	public java.lang.String getUseYn() {
		return useYn;
	}

	public void setUseYn(java.lang.String useYn) {
		this.useYn = useYn;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
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

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}
        
	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	 

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
