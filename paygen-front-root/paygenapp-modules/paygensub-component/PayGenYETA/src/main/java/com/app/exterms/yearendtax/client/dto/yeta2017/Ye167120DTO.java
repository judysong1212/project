package com.app.exterms.yearendtax.client.dto.yeta2017;

import java.io.Serializable;

/**
 * @Class Name : Ye167120VO.java
 * @Description : Ye167120 VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye167120DTO   implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set 귀속년도 : yrtxBlggYr */
    private java.lang.String yrtxBlggYr;

    /** set 연말정산구분코드 : clutSeptCd */
    private java.lang.String clutSeptCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 퇴직연금구분 : rtpnAccRtpnCl */
    private java.lang.String rtpnAccRtpnCl;

    /** set 퇴직연금금융기관코드 : rtpnFnnOrgnCd */
    private java.lang.String rtpnFnnOrgnCd;

    /** set 금융회사등명 : rtpnAccFnnCmp */
    private java.lang.String rtpnAccFnnCmp;

    /** set 계죄번호_증권번호 : rtpnAccAccno */
    private java.lang.String rtpnAccAccno;

    /** set 퇴직연금납입금액 : rtpnAccPymAmt */
    private java.math.BigDecimal rtpnAccPymAmt;

    /** set 퇴직연금세액공제금액 : rtpnAccTxamtDdcAmt */
    private java.math.BigDecimal rtpnAccTxamtDdcAmt;

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
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getYrtxBlggYr() {
        return this.yrtxBlggYr;
    }
    
    public void setYrtxBlggYr(java.lang.String yrtxBlggYr) {
        this.yrtxBlggYr = yrtxBlggYr;
    }
    
    public java.lang.String getClutSeptCd() {
        return this.clutSeptCd;
    }
    
    public void setClutSeptCd(java.lang.String clutSeptCd) {
        this.clutSeptCd = clutSeptCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getRtpnAccRtpnCl() {
        return this.rtpnAccRtpnCl;
    }
    
    public void setRtpnAccRtpnCl(java.lang.String rtpnAccRtpnCl) {
        this.rtpnAccRtpnCl = rtpnAccRtpnCl;
    }
    
    public java.lang.String getRtpnFnnOrgnCd() {
        return this.rtpnFnnOrgnCd;
    }
    
    public void setRtpnFnnOrgnCd(java.lang.String rtpnFnnOrgnCd) {
        this.rtpnFnnOrgnCd = rtpnFnnOrgnCd;
    }
    
    public java.lang.String getRtpnAccFnnCmp() {
        return this.rtpnAccFnnCmp;
    }
    
    public void setRtpnAccFnnCmp(java.lang.String rtpnAccFnnCmp) {
        this.rtpnAccFnnCmp = rtpnAccFnnCmp;
    }
    
    public java.lang.String getRtpnAccAccno() {
        return this.rtpnAccAccno;
    }
    
    public void setRtpnAccAccno(java.lang.String rtpnAccAccno) {
        this.rtpnAccAccno = rtpnAccAccno;
    }
    
    public java.math.BigDecimal getRtpnAccPymAmt() {
        return this.rtpnAccPymAmt;
    }
    
    public void setRtpnAccPymAmt(java.math.BigDecimal rtpnAccPymAmt) {
        this.rtpnAccPymAmt = rtpnAccPymAmt;
    }
    
    public java.math.BigDecimal getRtpnAccTxamtDdcAmt() {
        return this.rtpnAccTxamtDdcAmt;
    }
    
    public void setRtpnAccTxamtDdcAmt(java.math.BigDecimal rtpnAccTxamtDdcAmt) {
        this.rtpnAccTxamtDdcAmt = rtpnAccTxamtDdcAmt;
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