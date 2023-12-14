package com.app.exterms.payroll.server.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @Class Name : Payr0600VO.java
 * @Description : Payr0600 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0600VO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /** DPOB_CD :: 사업장코드 */
    private String dpobCd;

    /** DIL_WRKR_INCM_BLGG_YR :: 일용근로소득귀속년도 */
    private String dilWrkrIncmBlggYr;

    /** DIL_WRKR_INCM_BLGG_QATR_DIV_CD :: 일용근로소득귀속분기구분코드 */
    private String dilWrkrIncmBlggQatrDivCd;

    /** DIL_WRKR_INCM_SEIL_NUM :: 일용근로소득일련번호 */
    private BigInteger dilWrkrIncmSeilNum;

    /** PAYR_MANG_DEPT_CD :: 급여관리부서코드 */
    private String payrMangDeptCd;

    /** DEPT_CD :: 부서코드 */
    private String deptCd;

    /** BUSIN_CD :: 사업코드 */
    private String businCd;

    /** DIL_WRKR_SUMT_NUM_PEPL_NUM :: 일용근로자소득제출인원수 */
    private BigInteger dilWrkrSumtNumPeplNum;

    /** DIL_WRKR_INCM_SUMT_DATA_NUM :: 일용근로자소득제출자료건수 */
    private BigInteger dilWrkrIncmSumtDataNum;

    /** DIL_WRKR_TOT_PYMT_AGGR_SUM :: 일용근로자총지급액합계금액 */
    private BigInteger dilWrkrTotPymtAggrSum;

    /** DIL_WRKR_FREE_DTY_TX_AGGR_SUM :: 일용근로자비과세소득합계금액 */
    private BigInteger dilWrkrFreeDtyTxAggrSum;

    /** WHDG_TX_TX_AMNT_TX_AGGR_SUM :: 원천징수세액소득세합계금액 */
    private BigInteger whdgTxTxAmntTxAggrSum;

    /** WHDG_TX_INCM_TX_AGGR_SUM :: 원천징수세액지방소득세합계금액 */
    private BigInteger whdgTxIncmTxAggrSum;

    /** DIL_WRKR_INCM_SUMT_DT :: 일용근로자소득제출일자 */
    private String dilWrkrIncmSumtDt;

    /** DEGTR_NM :: 대표자성명 */
    private String degtrNm;

    /** CORP_NM_FMNM :: 법인명_상호 */
    private String corpNmFmnm;

    /** BUSOPR_RGSTN_NUM :: 사업자등록번호 */
    private String busoprRgstnNum;

    /** BUSOPR_RESN_REGN_NUM :: 사업자주민등록번호 */
    private String busoprResnRegnNum;

    /** CORP_NUM :: 법인번호 */
    private String corpNum;

    /** INCM_REGRST_DEBR_ZPCD :: 소득신고의무자우편번호 */
    private String incmRegrstDebrZpcd;

    /** INCM_REGRST_DEBR_FNDTN_ADDR :: 소득신고의무자기본주소 */
    private String incmRegrstDebrFndtnAddr;

    /** INCM_REGRST_DEBR_DTL_PATR_ADDR :: 소득신고의무자상세주소 */
    private String incmRegrstDebrDtlPatrAddr;

    /** JURI_TX_OFFC_CD :: 관할세무서코드 */
    private String juriTxOffcCd;

    /** PENTR_CD :: 제출자구분코드 */
    private String pentrCd;

    /** TX_DEPTY_NUM :: 세무대리인번호 */
    private String txDeptyNum;

    /** HMTX_ID :: 홈텍스ID */
    private String hmtxId;

    /** TX_PGM_CD :: 세무프로그램코드 */
    private String txPgmCd;

    /** PERN_CHRG_DEPT_NM :: 담당자부서명 */
    private String pernChrgDeptNm;

    /** PERN_CHRG_NM :: 담당자성명 */
    private String pernChrgNm;

    /** PERN_CHRG_PHN_NUM :: 담당자전화번호 */
    private String pernChrgPhnNum;

    /** ECTN_MAIL_ADDR :: 전자우편주소 */
    private String ectnMailAddr;

    /** DIL_WRKR_INCM_SUMT_DDLNE_DT :: 일용근로자소득제출마감일자 */
    private String dilWrkrIncmSumtDdlneDt;

    /** DIL_WRKR_INCM_SUMT_DDLNE_YN :: 일용근로자소득제출마감여부 */
    private String dilWrkrIncmSumtDdlneYn;

    /** KYBDR :: 입력자 */
    private String kybdr;

    /** INPT_DT :: 입력일자 */
    private String inptDt;

    /** INPT_ADDR :: 입력주소 */
    private String inptAddr;

    /** ISMT :: 수정자 */
    private String ismt;

    /** REVN_DT :: 수정일자 */
    private String revnDt;

    /** REVN_ADDR :: 수정주소 */
    private String revnAddr;

    /** secResnNum :: 주민등록번호원본 */
    private String secResnNum;

    /** systemkey :: SYSTEMKEY */
    private String systemkey;

    private String deptNm;

    private String businNm;

    public String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public String getDilWrkrIncmBlggYr() {
        return dilWrkrIncmBlggYr;
    }

    public void setDilWrkrIncmBlggYr(String dilWrkrIncmBlggYr) {
        this.dilWrkrIncmBlggYr = dilWrkrIncmBlggYr;
    }

    public String getDilWrkrIncmBlggQatrDivCd() {
        return dilWrkrIncmBlggQatrDivCd;
    }

    public void setDilWrkrIncmBlggQatrDivCd(String dilWrkrIncmBlggQatrDivCd) {
        this.dilWrkrIncmBlggQatrDivCd = dilWrkrIncmBlggQatrDivCd;
    }

    public BigInteger getDilWrkrIncmSeilNum() {
        return dilWrkrIncmSeilNum;
    }

    public void setDilWrkrIncmSeilNum(BigInteger dilWrkrIncmSeilNum) {
        this.dilWrkrIncmSeilNum = dilWrkrIncmSeilNum;
    }

    public String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getBusinCd() {
        return businCd;
    }

    public void setBusinCd(String businCd) {
        this.businCd = businCd;
    }

    public BigInteger getDilWrkrSumtNumPeplNum() {
        return dilWrkrSumtNumPeplNum;
    }

    public void setDilWrkrSumtNumPeplNum(BigInteger dilWrkrSumtNumPeplNum) {
        this.dilWrkrSumtNumPeplNum = dilWrkrSumtNumPeplNum;
    }

    public BigInteger getDilWrkrIncmSumtDataNum() {
        return dilWrkrIncmSumtDataNum;
    }

    public void setDilWrkrIncmSumtDataNum(BigInteger dilWrkrIncmSumtDataNum) {
        this.dilWrkrIncmSumtDataNum = dilWrkrIncmSumtDataNum;
    }

    public BigInteger getDilWrkrTotPymtAggrSum() {
        return dilWrkrTotPymtAggrSum;
    }

    public void setDilWrkrTotPymtAggrSum(BigInteger dilWrkrTotPymtAggrSum) {
        this.dilWrkrTotPymtAggrSum = dilWrkrTotPymtAggrSum;
    }

    public BigInteger getDilWrkrFreeDtyTxAggrSum() {
        return dilWrkrFreeDtyTxAggrSum;
    }

    public void setDilWrkrFreeDtyTxAggrSum(BigInteger dilWrkrFreeDtyTxAggrSum) {
        this.dilWrkrFreeDtyTxAggrSum = dilWrkrFreeDtyTxAggrSum;
    }

    public BigInteger getWhdgTxTxAmntTxAggrSum() {
        return whdgTxTxAmntTxAggrSum;
    }

    public void setWhdgTxTxAmntTxAggrSum(BigInteger whdgTxTxAmntTxAggrSum) {
        this.whdgTxTxAmntTxAggrSum = whdgTxTxAmntTxAggrSum;
    }

    public BigInteger getWhdgTxIncmTxAggrSum() {
        return whdgTxIncmTxAggrSum;
    }

    public void setWhdgTxIncmTxAggrSum(BigInteger whdgTxIncmTxAggrSum) {
        this.whdgTxIncmTxAggrSum = whdgTxIncmTxAggrSum;
    }

    public String getDilWrkrIncmSumtDt() {
        return dilWrkrIncmSumtDt;
    }

    public void setDilWrkrIncmSumtDt(String dilWrkrIncmSumtDt) {
        this.dilWrkrIncmSumtDt = dilWrkrIncmSumtDt;
    }

    public String getDegtrNm() {
        return degtrNm;
    }

    public void setDegtrNm(String degtrNm) {
        this.degtrNm = degtrNm;
    }

    public String getCorpNmFmnm() {
        return corpNmFmnm;
    }

    public void setCorpNmFmnm(String corpNmFmnm) {
        this.corpNmFmnm = corpNmFmnm;
    }

    public String getBusoprRgstnNum() {
        return busoprRgstnNum;
    }

    public void setBusoprRgstnNum(String busoprRgstnNum) {
        this.busoprRgstnNum = busoprRgstnNum;
    }

    public String getBusoprResnRegnNum() {
        return busoprResnRegnNum;
    }

    public void setBusoprResnRegnNum(String busoprResnRegnNum) {
        this.busoprResnRegnNum = busoprResnRegnNum;
    }

    public String getCorpNum() {
        return corpNum;
    }

    public void setCorpNum(String corpNum) {
        this.corpNum = corpNum;
    }

    public String getIncmRegrstDebrZpcd() {
        return incmRegrstDebrZpcd;
    }

    public void setIncmRegrstDebrZpcd(String incmRegrstDebrZpcd) {
        this.incmRegrstDebrZpcd = incmRegrstDebrZpcd;
    }

    public String getIncmRegrstDebrFndtnAddr() {
        return incmRegrstDebrFndtnAddr;
    }

    public void setIncmRegrstDebrFndtnAddr(String incmRegrstDebrFndtnAddr) {
        this.incmRegrstDebrFndtnAddr = incmRegrstDebrFndtnAddr;
    }

    public String getIncmRegrstDebrDtlPatrAddr() {
        return incmRegrstDebrDtlPatrAddr;
    }

    public void setIncmRegrstDebrDtlPatrAddr(String incmRegrstDebrDtlPatrAddr) {
        this.incmRegrstDebrDtlPatrAddr = incmRegrstDebrDtlPatrAddr;
    }

    public String getJuriTxOffcCd() {
        return juriTxOffcCd;
    }

    public void setJuriTxOffcCd(String juriTxOffcCd) {
        this.juriTxOffcCd = juriTxOffcCd;
    }

    public String getPentrCd() {
        return pentrCd;
    }

    public void setPentrCd(String pentrCd) {
        this.pentrCd = pentrCd;
    }

    public String getTxDeptyNum() {
        return txDeptyNum;
    }

    public void setTxDeptyNum(String txDeptyNum) {
        this.txDeptyNum = txDeptyNum;
    }

    public String getHmtxId() {
        return hmtxId;
    }

    public void setHmtxId(String hmtxId) {
        this.hmtxId = hmtxId;
    }

    public String getTxPgmCd() {
        return txPgmCd;
    }

    public void setTxPgmCd(String txPgmCd) {
        this.txPgmCd = txPgmCd;
    }

    public String getPernChrgDeptNm() {
        return pernChrgDeptNm;
    }

    public void setPernChrgDeptNm(String pernChrgDeptNm) {
        this.pernChrgDeptNm = pernChrgDeptNm;
    }

    public String getPernChrgNm() {
        return pernChrgNm;
    }

    public void setPernChrgNm(String pernChrgNm) {
        this.pernChrgNm = pernChrgNm;
    }

    public String getPernChrgPhnNum() {
        return pernChrgPhnNum;
    }

    public void setPernChrgPhnNum(String pernChrgPhnNum) {
        this.pernChrgPhnNum = pernChrgPhnNum;
    }

    public String getEctnMailAddr() {
        return ectnMailAddr;
    }

    public void setEctnMailAddr(String ectnMailAddr) {
        this.ectnMailAddr = ectnMailAddr;
    }

    public String getDilWrkrIncmSumtDdlneDt() {
        return dilWrkrIncmSumtDdlneDt;
    }

    public void setDilWrkrIncmSumtDdlneDt(String dilWrkrIncmSumtDdlneDt) {
        this.dilWrkrIncmSumtDdlneDt = dilWrkrIncmSumtDdlneDt;
    }

    public String getDilWrkrIncmSumtDdlneYn() {
        return dilWrkrIncmSumtDdlneYn;
    }

    public void setDilWrkrIncmSumtDdlneYn(String dilWrkrIncmSumtDdlneYn) {
        this.dilWrkrIncmSumtDdlneYn = dilWrkrIncmSumtDdlneYn;
    }

    public String getKybdr() {
        return kybdr;
    }

    public void setKybdr(String kybdr) {
        this.kybdr = kybdr;
    }

    public String getInptDt() {
        return inptDt;
    }

    public void setInptDt(String inptDt) {
        this.inptDt = inptDt;
    }

    public String getInptAddr() {
        return inptAddr;
    }

    public void setInptAddr(String inptAddr) {
        this.inptAddr = inptAddr;
    }

    public String getIsmt() {
        return ismt;
    }

    public void setIsmt(String ismt) {
        this.ismt = ismt;
    }

    public String getRevnDt() {
        return revnDt;
    }

    public void setRevnDt(String revnDt) {
        this.revnDt = revnDt;
    }

    public String getRevnAddr() {
        return revnAddr;
    }

    public void setRevnAddr(String revnAddr) {
        this.revnAddr = revnAddr;
    }

    public String getSecResnNum() {
        return secResnNum;
    }

    public void setSecResnNum(String secResnNum) {
        this.secResnNum = secResnNum;
    }

    public String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(String systemkey) {
        this.systemkey = systemkey;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getBusinNm() {
        return businNm;
    }

    public void setBusinNm(String businNm) {
        this.businNm = businNm;
    }
}
