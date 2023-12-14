package com.web.exterms.mypage.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Class Name : BoardPageVO.java
 * @Description : BoardPage VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BoardPageVO extends BoardPageDefaultVO{
    private static final long serialVersionUID = 1L;

    /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** BULL_BORD_MSGE_SEIL_NUM */
    private java.math.BigDecimal bullBordMsgeSeilNum;
    
    /** BULL_BORD_UID */
    private java.lang.String bullBordUid;
    
    /** BULL_BORD_GRP_ID */
    private java.math.BigDecimal bullBordGrpId;
    
    /** TPLVL_WRTN_INFO */
    private java.math.BigDecimal tplvlWrtnInfo;
    
    /** WRTN_ASWR_STGE */
    private java.math.BigDecimal wrtnAswrStge;
    
    /** WRTN_RGSTN_ORD */
    private java.math.BigDecimal wrtnRgstnOrd;
    
    /** ASWR_WRTN_NUM */
    private java.math.BigDecimal aswrWrtnNum;
    
    /** PPG_PERN_NM */
    private java.lang.String ppgPernNm;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** BULL_BORD_MSGE_TTL */
    private java.lang.String bullBordMsgeTtl;
    
    /** BULL_BORD_MSGE_CTNT java.sql.Clob*/
    private java.lang.String bullBordMsgeCtnt;
    
    /** WRTN_SECR_NUM */
    private java.lang.String wrtnSecrNum;
    
    /** PPG_PERN_EMAIL */
    private java.lang.String ppgPernEmail;
    
    /** INQY_NUM */
    private java.math.BigDecimal inqyNum;
    
    /** HTML_USE_YN */
    private java.lang.String htmlUseYn;
    
    /** BULL_BORD_MSGE_DEL_YN */
    private java.lang.String bullBordMsgeDelYn;
    
    /** NOTI_BGNN_DT */
    private java.lang.String notiBgnnDt;
    
    /** NOTI_END_DT */
    private java.lang.String notiEndDt;
    
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
    
    
    private MultipartFile file;
    

    public MultipartFile getFile() {
        return file;
    }
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.math.BigDecimal getBullBordMsgeSeilNum() {
        return this.bullBordMsgeSeilNum;
    }
    
    public void setBullBordMsgeSeilNum(java.math.BigDecimal bullBordMsgeSeilNum) {
        this.bullBordMsgeSeilNum = bullBordMsgeSeilNum;
    }
    
    public java.lang.String getBullBordUid() {
        return this.bullBordUid;
    }
    
    public void setBullBordUid(java.lang.String bullBordUid) {
        this.bullBordUid = bullBordUid;
    }
    
    public java.math.BigDecimal getBullBordGrpId() {
        return this.bullBordGrpId;
    }
    
    public void setBullBordGrpId(java.math.BigDecimal bullBordGrpId) {
        this.bullBordGrpId = bullBordGrpId;
    }
    
    public java.math.BigDecimal getTplvlWrtnInfo() {
        return this.tplvlWrtnInfo;
    }
    
    public void setTplvlWrtnInfo(java.math.BigDecimal tplvlWrtnInfo) {
        this.tplvlWrtnInfo = tplvlWrtnInfo;
    }
    
    public java.math.BigDecimal getWrtnAswrStge() {
        return this.wrtnAswrStge;
    }
    
    public void setWrtnAswrStge(java.math.BigDecimal wrtnAswrStge) {
        this.wrtnAswrStge = wrtnAswrStge;
    }
    
    public java.math.BigDecimal getWrtnRgstnOrd() {
        return this.wrtnRgstnOrd;
    }
    
    public void setWrtnRgstnOrd(java.math.BigDecimal wrtnRgstnOrd) {
        this.wrtnRgstnOrd = wrtnRgstnOrd;
    }
    
    public java.math.BigDecimal getAswrWrtnNum() {
        return this.aswrWrtnNum;
    }
    
    public void setAswrWrtnNum(java.math.BigDecimal aswrWrtnNum) {
        this.aswrWrtnNum = aswrWrtnNum;
    }
    
    public java.lang.String getPpgPernNm() {
        return this.ppgPernNm;
    }
    
    public void setPpgPernNm(java.lang.String ppgPernNm) {
        this.ppgPernNm = ppgPernNm;
    }
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.lang.String getBullBordMsgeTtl() {
        return this.bullBordMsgeTtl;
    }
    
    public void setBullBordMsgeTtl(java.lang.String bullBordMsgeTtl) {
        this.bullBordMsgeTtl = bullBordMsgeTtl;
    }
  
    public java.lang.String getBullBordMsgeCtnt() {
        return bullBordMsgeCtnt;
    }

    public void setBullBordMsgeCtnt(java.lang.String bullBordMsgeCtnt) {
        this.bullBordMsgeCtnt = bullBordMsgeCtnt;
    }

    public java.lang.String getWrtnSecrNum() {
        return this.wrtnSecrNum;
    }
    
    public void setWrtnSecrNum(java.lang.String wrtnSecrNum) {
        this.wrtnSecrNum = wrtnSecrNum;
    }
    
    public java.lang.String getPpgPernEmail() {
        return this.ppgPernEmail;
    }
    
    public void setPpgPernEmail(java.lang.String ppgPernEmail) {
        this.ppgPernEmail = ppgPernEmail;
    }
    
    public java.math.BigDecimal getInqyNum() {
        return this.inqyNum;
    }
    
    public void setInqyNum(java.math.BigDecimal inqyNum) {
        this.inqyNum = inqyNum;
    }
    
    public java.lang.String getHtmlUseYn() {
        return this.htmlUseYn;
    }
    
    public void setHtmlUseYn(java.lang.String htmlUseYn) {
        this.htmlUseYn = htmlUseYn;
    }
    
    public java.lang.String getBullBordMsgeDelYn() {
        return this.bullBordMsgeDelYn;
    }
    
    public void setBullBordMsgeDelYn(java.lang.String bullBordMsgeDelYn) {
        this.bullBordMsgeDelYn = bullBordMsgeDelYn;
    }
    
    public java.lang.String getNotiBgnnDt() {
        return this.notiBgnnDt;
    }
    
    public void setNotiBgnnDt(java.lang.String notiBgnnDt) {
        this.notiBgnnDt = notiBgnnDt;
    }
    
    public java.lang.String getNotiEndDt() {
        return this.notiEndDt;
    }
    
    public void setNotiEndDt(java.lang.String notiEndDt) {
        this.notiEndDt = notiEndDt;
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

    public String getUpDir() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
