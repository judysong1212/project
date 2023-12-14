package com.app.exterms.retirement.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Remt3000VO.java
 * @Description : Remt3000 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3000VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    private java.lang.String calcSevePsnBlggYrMnth;

    /** set 정산년월 : clutYrMnth */
    private java.lang.String clutYrMnth;

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    private java.lang.String calcSevePayPsnDivCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 영수일자 : reipDt */
    private java.lang.String reipDt;

    /** set 마감여부 : ddlneYn */
    private java.lang.String ddlneYn;

    /** set 마감일자 : ddlneDt */
    private java.lang.String ddlneDt;

    /** set 퇴직정산제출일자 : calcSevePayPsnSumtDt */
    private java.lang.String calcSevePayPsnSumtDt;

    /** set 대표자성명 : degtrNm */
    private java.lang.String degtrNm;

    /** set 법인명_상호 : corpNmFmnm */
    private java.lang.String corpNmFmnm;

    /** set 사업자등록번호 : busoprRgstnNum */
    private java.lang.String busoprRgstnNum;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;


    /** secResnNum : 주민등록번호 원본*/
      private java.lang.String secResnNum;
      
    /** set 법인번호 : corpNum */
    private java.lang.String corpNum;

    /** set 소득신고의무자우편번호 : incmRegrstDebrZpcd */
    private java.lang.String incmRegrstDebrZpcd;

    /** set 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
    private java.lang.String incmRegrstDebrFndtnAddr;

    /** set 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
    private java.lang.String incmRegrstDebrDtlPatrAddr;

    /** set 관할세무서코드 : juriTxOffcCd */
    private java.lang.String juriTxOffcCd;

    /** set 제출자구분코드 : pentrCd */
    private java.lang.String pentrCd;

    /** set 세무대리인번호 : txDeptyNum */
    private java.lang.String txDeptyNum;

    /** set 홈텍스ID : hmtxId */
    private java.lang.String hmtxId;

    /** set 세무프로그램코드 : txPgmCd */
    private java.lang.String txPgmCd;

    /** set 담당자부서명 : pernChrgDeptNm */
    private java.lang.String pernChrgDeptNm;

    /** set 담당자성명 : pernChrgNm */
    private java.lang.String pernChrgNm;

    /** set 담당자전화번호 : pernChrgPhnNum */
    private java.lang.String pernChrgPhnNum;

    /** set 징수의무자구분코드 : cllnDebrDivCd */
    private java.lang.String cllnDebrDivCd;

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
    
    
    
    public java.lang.String getClutYrMnth() {
		return clutYrMnth;
	}

	public void setClutYrMnth(java.lang.String clutYrMnth) {
		this.clutYrMnth = clutYrMnth;
	}

	public java.lang.String getCalcSevePayPsnDivCd() {
        return this.calcSevePayPsnDivCd;
    }
    
    public void setCalcSevePayPsnDivCd(java.lang.String calcSevePayPsnDivCd) {
        this.calcSevePayPsnDivCd = calcSevePayPsnDivCd;
    }
    
    public java.lang.String getReipDt() {
        return this.reipDt;
    }
    
    public void setReipDt(java.lang.String reipDt) {
        this.reipDt = reipDt;
    }
    
    public java.lang.String getDdlneYn() {
        return this.ddlneYn;
    }
    
    public void setDdlneYn(java.lang.String ddlneYn) {
        this.ddlneYn = ddlneYn;
    }
    
   
    
    public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getDdlneDt() {
        return this.ddlneDt;
    }
    
    public void setDdlneDt(java.lang.String ddlneDt) {
        this.ddlneDt = ddlneDt;
    }
    
    public java.lang.String getCalcSevePayPsnSumtDt() {
        return this.calcSevePayPsnSumtDt;
    }
    
    public void setCalcSevePayPsnSumtDt(java.lang.String calcSevePayPsnSumtDt) {
        this.calcSevePayPsnSumtDt = calcSevePayPsnSumtDt;
    }
    
    public java.lang.String getDegtrNm() {
        return this.degtrNm;
    }
    
    public void setDegtrNm(java.lang.String degtrNm) {
        this.degtrNm = degtrNm;
    }
    
    public java.lang.String getCorpNmFmnm() {
        return this.corpNmFmnm;
    }
    
    public void setCorpNmFmnm(java.lang.String corpNmFmnm) {
        this.corpNmFmnm = corpNmFmnm;
    }
    
    public java.lang.String getBusoprRgstnNum() {
        return this.busoprRgstnNum;
    }
    
    public void setBusoprRgstnNum(java.lang.String busoprRgstnNum) {
        this.busoprRgstnNum = busoprRgstnNum;
    }
    
    public java.lang.String getResnRegnNum() {
        return this.resnRegnNum;
    }
    
    public void setResnRegnNum(java.lang.String resnRegnNum) {
        this.resnRegnNum = resnRegnNum;
    }
    
    public java.lang.String getCorpNum() {
        return this.corpNum;
    }
    
    public void setCorpNum(java.lang.String corpNum) {
        this.corpNum = corpNum;
    }
    
    public java.lang.String getIncmRegrstDebrZpcd() {
        return this.incmRegrstDebrZpcd;
    }
    
    public void setIncmRegrstDebrZpcd(java.lang.String incmRegrstDebrZpcd) {
        this.incmRegrstDebrZpcd = incmRegrstDebrZpcd;
    }
    
    public java.lang.String getIncmRegrstDebrFndtnAddr() {
        return this.incmRegrstDebrFndtnAddr;
    }
    
    public void setIncmRegrstDebrFndtnAddr(java.lang.String incmRegrstDebrFndtnAddr) {
        this.incmRegrstDebrFndtnAddr = incmRegrstDebrFndtnAddr;
    }
    
    public java.lang.String getIncmRegrstDebrDtlPatrAddr() {
        return this.incmRegrstDebrDtlPatrAddr;
    }
    
    public void setIncmRegrstDebrDtlPatrAddr(java.lang.String incmRegrstDebrDtlPatrAddr) {
        this.incmRegrstDebrDtlPatrAddr = incmRegrstDebrDtlPatrAddr;
    }
    
    public java.lang.String getJuriTxOffcCd() {
        return this.juriTxOffcCd;
    }
    
    public void setJuriTxOffcCd(java.lang.String juriTxOffcCd) {
        this.juriTxOffcCd = juriTxOffcCd;
    }
    
    public java.lang.String getPentrCd() {
        return this.pentrCd;
    }
    
    public void setPentrCd(java.lang.String pentrCd) {
        this.pentrCd = pentrCd;
    }
    
    public java.lang.String getTxDeptyNum() {
        return this.txDeptyNum;
    }
    
    public void setTxDeptyNum(java.lang.String txDeptyNum) {
        this.txDeptyNum = txDeptyNum;
    }
    
    public java.lang.String getHmtxId() {
        return this.hmtxId;
    }
    
    public void setHmtxId(java.lang.String hmtxId) {
        this.hmtxId = hmtxId;
    }
    
    public java.lang.String getTxPgmCd() {
        return this.txPgmCd;
    }
    
    public void setTxPgmCd(java.lang.String txPgmCd) {
        this.txPgmCd = txPgmCd;
    }
    
    public java.lang.String getPernChrgDeptNm() {
        return this.pernChrgDeptNm;
    }
    
    public void setPernChrgDeptNm(java.lang.String pernChrgDeptNm) {
        this.pernChrgDeptNm = pernChrgDeptNm;
    }
    
    public java.lang.String getPernChrgNm() {
        return this.pernChrgNm;
    }
    
    public void setPernChrgNm(java.lang.String pernChrgNm) {
        this.pernChrgNm = pernChrgNm;
    }
    
    public java.lang.String getPernChrgPhnNum() {
        return this.pernChrgPhnNum;
    }
    
    public void setPernChrgPhnNum(java.lang.String pernChrgPhnNum) {
        this.pernChrgPhnNum = pernChrgPhnNum;
    }
    
    public java.lang.String getCllnDebrDivCd() {
        return this.cllnDebrDivCd;
    }
    
    public void setCllnDebrDivCd(java.lang.String cllnDebrDivCd) {
        this.cllnDebrDivCd = cllnDebrDivCd;
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

	/**
	 * Comment : 
	 * @fn java.lang.String getSecResnNum()
	 * @brief date:2016 2016. 7. 3. user:Administrator
	 * @return the secResnNum get
	 */
	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	/**
	 * Comment : 
	 *@fn void setSecResnNum(java.lang.String secResnNum)
	 *@brief date:2016 2016. 7. 3. user:Administrator
	 *@param secResnNum the secResnNum to set
	 */
	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}
    
}
