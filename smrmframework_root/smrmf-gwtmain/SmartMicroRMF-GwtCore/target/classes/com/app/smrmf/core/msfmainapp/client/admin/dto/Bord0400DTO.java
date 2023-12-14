package com.app.smrmf.core.msfmainapp.client.admin.dto;

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
public class Bord0400DTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /** set 시스템구분코드 : sysDivCd */
    private java.lang.String sysDivCd;

    /** set 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
    private Long bullBordMsgeAttcFlNum;

    /** set 게시글일련번호 : bullBordMsgeSeilNum */
    private Long bullBordMsgeSeilNum;

    /** set 게시판_UID : bullBordUid */
    private java.lang.String bullBordUid;

    /** set 게시판그룹ID : bullBordGrpId */
    private Long bullBordGrpId;

    /** set 파일 이름 : flNm */
    private java.lang.String flNm;

    /** set 파일 크기 : flSz */
    private java.lang.String flSz;

    /** set 콘텐트 타입 : ctntTyp */
    private java.lang.String ctntTyp;

    /** set 다운로드 수 : dwldNum */
    private Long dwldNum;

    /** set 이미지 크기 넓이 : imgSzEtt */
    private Long imgSzEtt;

    /** set 이미지 크기 높이 : imgSzHeit */
    private Long imgSzHeit;

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

    /** set 게시글파일경로 : flRfta */
    private java.lang.String flRfta;
    
    
    
    public java.lang.String getFlRfta() {
        return flRfta;
    }

    public void setFlRfta(java.lang.String flRfta) {
        this.flRfta = flRfta;
    }

    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
     
    
    public java.lang.String getBullBordUid() {
        return this.bullBordUid;
    }
    
    public void setBullBordUid(java.lang.String bullBordUid) {
        this.bullBordUid = bullBordUid;
    }
    
 
    
    public Long getBullBordMsgeAttcFlNum() {
        return bullBordMsgeAttcFlNum;
    }

    public void setBullBordMsgeAttcFlNum(Long bullBordMsgeAttcFlNum) {
        this.bullBordMsgeAttcFlNum = bullBordMsgeAttcFlNum;
    }

    public Long getBullBordMsgeSeilNum() {
        return bullBordMsgeSeilNum;
    }

    public void setBullBordMsgeSeilNum(Long bullBordMsgeSeilNum) {
        this.bullBordMsgeSeilNum = bullBordMsgeSeilNum;
    }

    public Long getBullBordGrpId() {
        return bullBordGrpId;
    }

    public void setBullBordGrpId(Long bullBordGrpId) {
        this.bullBordGrpId = bullBordGrpId;
    }

    public java.lang.String getFlNm() {
        return this.flNm;
    }
    
    public void setFlNm(java.lang.String flNm) {
        this.flNm = flNm;
    }
    
    public java.lang.String getFlSz() {
        return this.flSz;
    }
    
    public void setFlSz(java.lang.String flSz) {
        this.flSz = flSz;
    }
    
    public java.lang.String getCtntTyp() {
        return this.ctntTyp;
    }
    
    public void setCtntTyp(java.lang.String ctntTyp) {
        this.ctntTyp = ctntTyp;
    }
    
    
    
    public Long getDwldNum() {
        return dwldNum;
    }

    public void setDwldNum(Long dwldNum) {
        this.dwldNum = dwldNum;
    }

    public Long getImgSzEtt() {
        return imgSzEtt;
    }

    public void setImgSzEtt(Long imgSzEtt) {
        this.imgSzEtt = imgSzEtt;
    }

    public Long getImgSzHeit() {
        return imgSzHeit;
    }

    public void setImgSzHeit(Long imgSzHeit) {
        this.imgSzHeit = imgSzHeit;
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
