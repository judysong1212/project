package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Payr0360VO.java
 * @Description : Payr0360 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.09.22
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0360VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** REATTY_YR */
    private java.lang.String reattyYr;
    
    /** REATTY_STP_DSPTY_NUM */
    private java.lang.String reattyStpDsptyNum;
    
    /** REATTY_APPTN_YR_MNTH */
    private java.lang.String reattyApptnYrMnth;
    
    /** REATTY_PYMT_DT */
    private java.lang.String reattyPymtDt;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** BUSIN_CD */
    private java.lang.String businCd;
    
    /** TYP_OCCU_CD */
    private java.lang.String typOccuCd;
    
    /** DTIL_OCCU_CLS_DIV_CD */
    private java.lang.String dtilOccuClsDivCd;
    
    /** PYMT_MNTH_STP_01 */
    private java.lang.String pymtMnthStp01;
    
    /** PYMT_MNTH_STP_02 */
    private java.lang.String pymtMnthStp02;
    
    /** PYMT_MNTH_STP_03 */
    private java.lang.String pymtMnthStp03;
    
    /** PYMT_MNTH_STP_04 */
    private java.lang.String pymtMnthStp04;
    
    /** PYMT_MNTH_STP_05 */
    private java.lang.String pymtMnthStp05;
    
    /** PYMT_MNTH_STP_06 */
    private java.lang.String pymtMnthStp06;
    
    /** PYMT_MNTH_STP_07 */
    private java.lang.String pymtMnthStp07;
    
    /** PYMT_MNTH_STP_08 */
    private java.lang.String pymtMnthStp08;
    
    /** PYMT_MNTH_STP_09 */
    private java.lang.String pymtMnthStp09;
    
    /** PYMT_MNTH_STP_10 */
    private java.lang.String pymtMnthStp10;
    
    /** PYMT_MNTH_STP_11 */
    private java.lang.String pymtMnthStp11;
    
    /** PYMT_MNTH_STP_12 */
    private java.lang.String pymtMnthStp12;
    
    /** TGT_SYSTEMKEY */
    private java.lang.String tgtSystemkey;
    /** REATTY_STP_NOTE_CTNT */
    private java.lang.String reattyStpNoteCtnt;
    
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
    
    
	 /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;


    /**
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 3, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 3, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getReattyStpNoteCtnt() {
		return reattyStpNoteCtnt;
	}

	public void setReattyStpNoteCtnt(java.lang.String reattyStpNoteCtnt) {
		this.reattyStpNoteCtnt = reattyStpNoteCtnt;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getReattyYr() {
        return this.reattyYr;
    }
    
    public void setReattyYr(java.lang.String reattyYr) {
        this.reattyYr = reattyYr;
    }
    
    public java.lang.String getReattyStpDsptyNum() {
        return this.reattyStpDsptyNum;
    }
    
    public void setReattyStpDsptyNum(java.lang.String reattyStpDsptyNum) {
        this.reattyStpDsptyNum = reattyStpDsptyNum;
    }
    
   
    
    public java.lang.String getReattyApptnYrMnth() {
		return reattyApptnYrMnth;
	}

	public void setReattyApptnYrMnth(java.lang.String reattyApptnYrMnth) {
		this.reattyApptnYrMnth = reattyApptnYrMnth;
	}

	public java.lang.String getReattyPymtDt() {
        return this.reattyPymtDt;
    }
    
    public void setReattyPymtDt(java.lang.String reattyPymtDt) {
        this.reattyPymtDt = reattyPymtDt;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getTypOccuCd() {
        return this.typOccuCd;
    }
    
    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }
    
    public java.lang.String getDtilOccuClsDivCd() {
        return this.dtilOccuClsDivCd;
    }
    
    public void setDtilOccuClsDivCd(java.lang.String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }
    
    public java.lang.String getPymtMnthStp01() {
        return this.pymtMnthStp01;
    }
    
    public void setPymtMnthStp01(java.lang.String pymtMnthStp01) {
        this.pymtMnthStp01 = pymtMnthStp01;
    }
    
    public java.lang.String getPymtMnthStp02() {
        return this.pymtMnthStp02;
    }
    
    public void setPymtMnthStp02(java.lang.String pymtMnthStp02) {
        this.pymtMnthStp02 = pymtMnthStp02;
    }
    
    public java.lang.String getPymtMnthStp03() {
        return this.pymtMnthStp03;
    }
    
    public void setPymtMnthStp03(java.lang.String pymtMnthStp03) {
        this.pymtMnthStp03 = pymtMnthStp03;
    }
    
    public java.lang.String getPymtMnthStp04() {
        return this.pymtMnthStp04;
    }
    
    public void setPymtMnthStp04(java.lang.String pymtMnthStp04) {
        this.pymtMnthStp04 = pymtMnthStp04;
    }
    
    public java.lang.String getPymtMnthStp05() {
        return this.pymtMnthStp05;
    }
    
    public void setPymtMnthStp05(java.lang.String pymtMnthStp05) {
        this.pymtMnthStp05 = pymtMnthStp05;
    }
    
    public java.lang.String getPymtMnthStp06() {
        return this.pymtMnthStp06;
    }
    
    public void setPymtMnthStp06(java.lang.String pymtMnthStp06) {
        this.pymtMnthStp06 = pymtMnthStp06;
    }
    
    public java.lang.String getPymtMnthStp07() {
        return this.pymtMnthStp07;
    }
    
    public void setPymtMnthStp07(java.lang.String pymtMnthStp07) {
        this.pymtMnthStp07 = pymtMnthStp07;
    }
    
    public java.lang.String getPymtMnthStp08() {
        return this.pymtMnthStp08;
    }
    
    public void setPymtMnthStp08(java.lang.String pymtMnthStp08) {
        this.pymtMnthStp08 = pymtMnthStp08;
    }
    
    public java.lang.String getPymtMnthStp09() {
        return this.pymtMnthStp09;
    }
    
    public void setPymtMnthStp09(java.lang.String pymtMnthStp09) {
        this.pymtMnthStp09 = pymtMnthStp09;
    }
    
    public java.lang.String getPymtMnthStp10() {
        return this.pymtMnthStp10;
    }
    
    public void setPymtMnthStp10(java.lang.String pymtMnthStp10) {
        this.pymtMnthStp10 = pymtMnthStp10;
    }
    
    public java.lang.String getPymtMnthStp11() {
        return this.pymtMnthStp11;
    }
    
    public void setPymtMnthStp11(java.lang.String pymtMnthStp11) {
        this.pymtMnthStp11 = pymtMnthStp11;
    }
    
    public java.lang.String getPymtMnthStp12() {
        return this.pymtMnthStp12;
    }
    
    public void setPymtMnthStp12(java.lang.String pymtMnthStp12) {
        this.pymtMnthStp12 = pymtMnthStp12;
    }
    
    public java.lang.String getTgtSystemkey() {
        return this.tgtSystemkey;
    }
    
    public void setTgtSystemkey(java.lang.String tgtSystemkey) {
        this.tgtSystemkey = tgtSystemkey;
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
