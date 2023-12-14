package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta3180VO.java
 * @Description : Yeta3180 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3180_2023_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 기부내역일련번호 : ctrbSeqn */
    private java.math.BigDecimal ctrbSeqn;

    /** set 기부유형구분코드 : ctrbDdcd */
    private java.lang.String ctrbDdcd;

    /** set 기부유형코드 : ctrbTycd */
    private java.lang.String ctrbTycd;

    /** set 기부내용 : ctrbCont */
    private java.lang.String ctrbCont;

    /** set 기부연도 : ctrbYrmn */
    private java.lang.String ctrbYrmn;

    /** set 기부처명 : ctrbName */
    private java.lang.String ctrbName;

    /** set 기부처사업자번호 : ctrbBsnu */
    private java.lang.String ctrbBsnu;

    /** set 기부금액 : ctrbAmnt */
    private java.math.BigDecimal ctrbAmnt;

    /** set 기부자관계구분코드 : crtbCncd */
    private java.lang.String crtbCncd;

    /** set 기부자내국인구분코드 : crnrFlag */
    private java.lang.String crnrFlag;

    /** set 기부자성명 : cbtgName */
    private java.lang.String cbtgName;

    /** set 주민등록번호 : rsnoNumb */
    private java.lang.String rsnoNumb;

    /** set 기부금유형콤보TEMP : ctrbCtnt */
    private java.lang.String ctrbCtnt;

    /** set 영수증유무 : receRati */
    private java.lang.String receRati;

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

    /** set 기부금건수 : ctrbNcnt */
    private java.math.BigDecimal ctrbNcnt;

    /** set 공제대상기부금액 : ctrbTgam */
    private java.math.BigDecimal ctrbTgam;

    /** set 기부장려신청금액 : ctjaCham */
    private java.math.BigDecimal ctjaCham;


    
    /**
	 * Comment : 
	 * @fn java.math.BigDecimal getCtrbNcnt()
	 * @brief date:2017 2017. 1. 16. user:atres-pc
	 * @return the ctrbNcnt get
	 */
	public java.math.BigDecimal getCtrbNcnt() {
		return ctrbNcnt;
	}

	/**
	 * Comment : 
	 *@fn void setCtrbNcnt(java.math.BigDecimal ctrbNcnt)
	 *@brief date:2017 2017. 1. 16. user:atres-pc
	 *@param ctrbNcnt the ctrbNcnt to set
	 */
	public void setCtrbNcnt(java.math.BigDecimal ctrbNcnt) {
		this.ctrbNcnt = ctrbNcnt;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getCtrbTgam()
	 * @brief date:2017 2017. 1. 16. user:atres-pc
	 * @return the ctrbTgam get
	 */
	public java.math.BigDecimal getCtrbTgam() {
		return ctrbTgam;
	}

	/**
	 * Comment : 
	 *@fn void setCtrbTgam(java.math.BigDecimal ctrbTgam)
	 *@brief date:2017 2017. 1. 16. user:atres-pc
	 *@param ctrbTgam the ctrbTgam to set
	 */
	public void setCtrbTgam(java.math.BigDecimal ctrbTgam) {
		this.ctrbTgam = ctrbTgam;
	}

	/**
	 * Comment : 
	 * @fn java.math.BigDecimal getCtjaCham()
	 * @brief date:2017 2017. 1. 16. user:atres-pc
	 * @return the ctjaCham get
	 */
	public java.math.BigDecimal getCtjaCham() {
		return ctjaCham;
	}

	/**
	 * Comment : 
	 *@fn void setCtjaCham(java.math.BigDecimal ctjaCham)
	 *@brief date:2017 2017. 1. 16. user:atres-pc
	 *@param ctjaCham the ctjaCham to set
	 */
	public void setCtjaCham(java.math.BigDecimal ctjaCham) {
		this.ctjaCham = ctjaCham;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.math.BigDecimal getCtrbSeqn() {
        return this.ctrbSeqn;
    }
    
    public void setCtrbSeqn(java.math.BigDecimal ctrbSeqn) {
        this.ctrbSeqn = ctrbSeqn;
    }
    
    public java.lang.String getCtrbDdcd() {
        return this.ctrbDdcd;
    }
    
    public void setCtrbDdcd(java.lang.String ctrbDdcd) {
        this.ctrbDdcd = ctrbDdcd;
    }
    
    public java.lang.String getCtrbTycd() {
        return this.ctrbTycd;
    }
    
    public void setCtrbTycd(java.lang.String ctrbTycd) {
        this.ctrbTycd = ctrbTycd;
    }
    
    public java.lang.String getCtrbCont() {
        return this.ctrbCont;
    }
    
    public void setCtrbCont(java.lang.String ctrbCont) {
        this.ctrbCont = ctrbCont;
    }
    
    public java.lang.String getCtrbYrmn() {
        return this.ctrbYrmn;
    }
    
    public void setCtrbYrmn(java.lang.String ctrbYrmn) {
        this.ctrbYrmn = ctrbYrmn;
    }
    
    public java.lang.String getCtrbName() {
        return this.ctrbName;
    }
    
    public void setCtrbName(java.lang.String ctrbName) {
        this.ctrbName = ctrbName;
    }
    
    public java.lang.String getCtrbBsnu() {
        return this.ctrbBsnu;
    }
    
    public void setCtrbBsnu(java.lang.String ctrbBsnu) {
        this.ctrbBsnu = ctrbBsnu;
    }
    
    public java.math.BigDecimal getCtrbAmnt() {
        return this.ctrbAmnt;
    }
    
    public void setCtrbAmnt(java.math.BigDecimal ctrbAmnt) {
        this.ctrbAmnt = ctrbAmnt;
    }
    
    public java.lang.String getCrtbCncd() {
        return this.crtbCncd;
    }
    
    public void setCrtbCncd(java.lang.String crtbCncd) {
        this.crtbCncd = crtbCncd;
    }
    
    public java.lang.String getCrnrFlag() {
        return this.crnrFlag;
    }
    
    public void setCrnrFlag(java.lang.String crnrFlag) {
        this.crnrFlag = crnrFlag;
    }
    
    public java.lang.String getCbtgName() {
        return this.cbtgName;
    }
    
    public void setCbtgName(java.lang.String cbtgName) {
        this.cbtgName = cbtgName;
    }
    
    public java.lang.String getRsnoNumb() {
        return this.rsnoNumb;
    }
    
    public void setRsnoNumb(java.lang.String rsnoNumb) {
        this.rsnoNumb = rsnoNumb;
    }
    
    public java.lang.String getCtrbCtnt() {
        return this.ctrbCtnt;
    }
    
    public void setCtrbCtnt(java.lang.String ctrbCtnt) {
        this.ctrbCtnt = ctrbCtnt;
    }
    
    public java.lang.String getReceRati() {
        return this.receRati;
    }
    
    public void setReceRati(java.lang.String receRati) {
        this.receRati = receRati;
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
