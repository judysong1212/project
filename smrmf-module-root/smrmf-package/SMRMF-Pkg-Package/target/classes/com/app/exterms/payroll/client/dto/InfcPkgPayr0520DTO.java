package com.app.exterms.payroll.client.dto;

import java.io.Serializable;

/**
 * @Class Name : Payr0520VO.java
 * @Description : Payr0520 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *   
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0520DTO implements Serializable  {
    private static final long serialVersionUID = 1L; 
 
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** PAY_ITEM_CD */
    private java.lang.String payItemCd;
    
    /** PYMT_DDUC_ITEM_SIL_NUM */
    private Long pymtDducItemSilNum;
    
    /** PYMT_DDUC_DIV_CD */
    private java.lang.String pymtDducDivCd;
    
    /** PYMT_DDUC_SUM */
    private Long pymtDducSum;
    
    /** PYMT_DDUC_RATE */
    private Double pymtDducRate;
    
    /** PYMT_DDUC_FREE_DTY_SUM */
    private Long pymtDducFreeDtySum;
    
    /** PYMT_DDUC_ITEM_CRETN_DIV_CD */
    private java.lang.String pymtDducItemCretnDivCd;
    
    /** PYMT_DDUC_ITEM_NOTE_CTNT */
    private java.lang.String pymtDducItemNoteCtnt;
    
    /** PYMT_DDUC_ITEM_BGNN_DT */
    private java.lang.String pymtDducItemBgnnDt;
    
    /** PYMT_DDUC_ITEM_END_DT */
    private java.lang.String pymtDducItemEndDt;
    
    /** PYMT_DDUC_ITEM_DEL_YN */
    private Boolean pymtDducItemDelYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    
    
    public java.lang.String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getPayItemCd() {
        return this.payItemCd;
    }
    
    public void setPayItemCd(java.lang.String payItemCd) {
        this.payItemCd = payItemCd;
    }
    
   
    public java.lang.String getPymtDducDivCd() {
        return this.pymtDducDivCd;
    }
    
    public void setPymtDducDivCd(java.lang.String pymtDducDivCd) {
        this.pymtDducDivCd = pymtDducDivCd;
    }
    
    
    
    public void setPymtDducSum(Long pymtDducSum) {
        this.pymtDducSum = pymtDducSum;
    }
    
      
    public java.lang.String getPymtDducItemCretnDivCd() {
        return this.pymtDducItemCretnDivCd;
    }
    
    public void setPymtDducItemCretnDivCd(java.lang.String pymtDducItemCretnDivCd) {
        this.pymtDducItemCretnDivCd = pymtDducItemCretnDivCd;
    }
    
    public java.lang.String getPymtDducItemNoteCtnt() {
        return this.pymtDducItemNoteCtnt;
    }
    
    public void setPymtDducItemNoteCtnt(java.lang.String pymtDducItemNoteCtnt) {
        this.pymtDducItemNoteCtnt = pymtDducItemNoteCtnt;
    }
    
    public java.lang.String getPymtDducItemBgnnDt() {
        return this.pymtDducItemBgnnDt;
    }
    
    public void setPymtDducItemBgnnDt(java.lang.String pymtDducItemBgnnDt) {
        this.pymtDducItemBgnnDt = pymtDducItemBgnnDt;
    }
    
    public java.lang.String getPymtDducItemEndDt() {
        return this.pymtDducItemEndDt;
    }
    
    public void setPymtDducItemEndDt(java.lang.String pymtDducItemEndDt) {
        this.pymtDducItemEndDt = pymtDducItemEndDt;
    }
    
    
    
    public Long getPymtDducItemSilNum() {
        return pymtDducItemSilNum;
    }

    public void setPymtDducItemSilNum(Long pymtDducItemSilNum) {
        this.pymtDducItemSilNum = pymtDducItemSilNum;
    }

    public Double getPymtDducRate() {
        return pymtDducRate;
    }

    public void setPymtDducRate(Double pymtDducRate) {
        this.pymtDducRate = pymtDducRate;
    }

    public Long getPymtDducFreeDtySum() {
        return pymtDducFreeDtySum;
    }

    public void setPymtDducFreeDtySum(Long pymtDducFreeDtySum) {
        this.pymtDducFreeDtySum = pymtDducFreeDtySum;
    }

    public Boolean getPymtDducItemDelYn() {
        return pymtDducItemDelYn;
    }

    public void setPymtDducItemDelYn(Boolean pymtDducItemDelYn) {
        this.pymtDducItemDelYn = pymtDducItemDelYn;
    }

    public Long getPymtDducSum() {
        return pymtDducSum;
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
    
//    public Payr0520DTO(){}
//    /** set 사업장코드 : dpobCd */
//    public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
//    /** get 사업장코드 : dpobCd */
//    public String getDpobCd() { return (String)get("dpobCd");}
//    /** set SYSTEMKEY : systemkey */
//    public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
//    /** get SYSTEMKEY : systemkey */
//    public String getSystemkey() { return (String)get("systemkey");}
//    /** set 급여항목코드 : payItemCd */
//    public void setPayItemCd(String payItemCd) { set("payItemCd",payItemCd);}
//    /** get 급여항목코드 : payItemCd */
//    public String getPayItemCd() { return (String)get("payItemCd");}
//    /** set 개별지급공제항목일련번호 : pymtDducItemSilNum */
//    public void setPymtDducItemSilNum(String pymtDducItemSilNum) { set("pymtDducItemSilNum",pymtDducItemSilNum);}
//    /** get 개별지급공제항목일련번호 : pymtDducItemSilNum */
//    public String getPymtDducItemSilNum() { return (String)get("pymtDducItemSilNum");}
//    /** set 지급공제구분코드 : pymtDducDivCd */
//    public void setPymtDducDivCd(String pymtDducDivCd) { set("pymtDducDivCd",pymtDducDivCd);}
//    /** get 지급공제구분코드 : pymtDducDivCd */
//    public String getPymtDducDivCd() { return (String)get("pymtDducDivCd");}
//    /** set 지금공제금액 : pymtDducSum */
//    public void setPymtDducSum(String pymtDducSum) { set("pymtDducSum",pymtDducSum);}
//    /** get 지금공제금액 : pymtDducSum */
//    public String getPymtDducSum() { return (String)get("pymtDducSum");}
//    /** set 지금공제율 : pymtDducRate */
//    public void setPymtDducRate(String pymtDducRate) { set("pymtDducRate",pymtDducRate);}
//    /** get 지금공제율 : pymtDducRate */
//    public String getPymtDducRate() { return (String)get("pymtDducRate");}
//    /** set 지금공제비과세금액 : pymtDducFreeDtySum */
//    public void setPymtDducFreeDtySum(String pymtDducFreeDtySum) { set("pymtDducFreeDtySum",pymtDducFreeDtySum);}
//    /** get 지금공제비과세금액 : pymtDducFreeDtySum */
//    public String getPymtDducFreeDtySum() { return (String)get("pymtDducFreeDtySum");}
//    /** set 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
//    public void setPymtDducItemCretnDivCd(String pymtDducItemCretnDivCd) { set("pymtDducItemCretnDivCd",pymtDducItemCretnDivCd);}
//    /** get 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
//    public String getPymtDducItemCretnDivCd() { return (String)get("pymtDducItemCretnDivCd");}
//    /** set 지급공제항목비고내용 : pymtDducItemNoteCtnt */
//    public void setPymtDducItemNoteCtnt(String pymtDducItemNoteCtnt) { set("pymtDducItemNoteCtnt",pymtDducItemNoteCtnt);}
//    /** get 지급공제항목비고내용 : pymtDducItemNoteCtnt */
//    public String getPymtDducItemNoteCtnt() { return (String)get("pymtDducItemNoteCtnt");}
//    /** set 지급공제항목시작일자 : pymtDducItemBgnnDt */
//    public void setPymtDducItemBgnnDt(String pymtDducItemBgnnDt) { set("pymtDducItemBgnnDt",pymtDducItemBgnnDt);}
//    /** get 지급공제항목시작일자 : pymtDducItemBgnnDt */
//    public String getPymtDducItemBgnnDt() { return (String)get("pymtDducItemBgnnDt");}
//    /** set 지급공제항목종료일자 : pymtDducItemEndDt */
//    public void setPymtDducItemEndDt(String pymtDducItemEndDt) { set("pymtDducItemEndDt",pymtDducItemEndDt);}
//    /** get 지급공제항목종료일자 : pymtDducItemEndDt */
//    public String getPymtDducItemEndDt() { return (String)get("pymtDducItemEndDt");}
//    /** set 지급공제항목삭제여부 : pymtDducItemDelYn */
//    public void setPymtDducItemDelYn(String pymtDducItemDelYn) { set("pymtDducItemDelYn",pymtDducItemDelYn);}
//    /** get 지급공제항목삭제여부 : pymtDducItemDelYn */
//    public String getPymtDducItemDelYn() { return (String)get("pymtDducItemDelYn");}
//    /** set 입력자 : kybdr */
//    public void setKybdr(String kybdr) { set("kybdr",kybdr);}
//    /** get 입력자 : kybdr */
//    public String getKybdr() { return (String)get("kybdr");}
//    /** set 입력일자 : inptDt */
//    public void setInptDt(String inptDt) { set("inptDt",inptDt);}
//    /** get 입력일자 : inptDt */
//    public String getInptDt() { return (String)get("inptDt");}
//    /** set 입력주소 : inptAddr */
//    public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
//    /** get 입력주소 : inptAddr */
//    public String getInptAddr() { return (String)get("inptAddr");}
//    /** set 수정자 : ismt */
//    public void setIsmt(String ismt) { set("ismt",ismt);}
//    /** get 수정자 : ismt */
//    public String getIsmt() { return (String)get("ismt");}
//    /** set 수정일자 : revnDt */
//    public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
//    /** get 수정일자 : revnDt */
//    public String getRevnDt() { return (String)get("revnDt");}
//    /** set 수정주소 : revnAddr */
//    public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
//    /** get 수정주소 : revnAddr */
//    public String getRevnAddr() { return (String)get("revnAddr");}

    
    
    
}
