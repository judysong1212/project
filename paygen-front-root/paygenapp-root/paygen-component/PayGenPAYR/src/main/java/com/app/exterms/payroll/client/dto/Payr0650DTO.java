package com.app.exterms.payroll.client.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @Class Name : Payr0650VO.java
 * @Description : Payr0650 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *
 *  Copyright (C)  All right reserved.
 */
public class Payr0650DTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DPOB_CD :: 사업장코드
     */
    private String dpobCd;

    /**
     * DIL_WRKR_INCM_BLGG_YR :: 일용근로소득귀속년도
     */
    private String dilWrkrIncmBlggYr;

    /**
     * DIL_WRKR_INCM_BLGG_QATR_DIV_CD :: 일용근로소득귀속분기구분코드
     */
    private String dilWrkrIncmBlggQatrDivCd;

    /**
     * DIL_WRKR_INCM_SEIL_NUM :: 일용근로소득일련번호
     */
    private String dilWrkrIncmSeilNum;

    /**
     * SYSTEMKEY :: SYSTEMKEY
     */
    private String systemkey;

    /**
     * DIL_WRKR_INCM_PYMT_YR_MNTH :: 일용근로소득지급년월
     */
    private String dilWrkrIncmPymtYrMnth;

    /**
     * DIL_WRKR_INCM_DUTY_YR_MNTH :: 일용근로소득근무년월
     */
    private String dilWrkrIncmDutyYrMnth;

    /**
     * AIMENR_NM :: 소득자성명
     */
    private String aimenrNm;

    /**
     * AIMENR_RESN_REGN_NUM :: 소득자주민등록번호
     */
    private String aimenrResnRegnNum;

    /**
     * AIMENR_ZPCD :: 소득자우편번호
     */
    private String aimenrZpcd;

    /**
     * AIMENR_ROAD_NM_FNDTN_ADDR :: 소득자도로명기본주소
     */
    private String aimenrRoadNmFndtnAddr;

    /**
     * AIMENR_ROAD_NM_DTL_PATR_ADDR :: 소득자도로명상세주소
     */
    private String aimenrRoadNmDtlPatrAddr;

    /**
     * AIMENR_PHN_NUM :: 소득자전화번호
     */
    private String aimenrPhnNum;

    /**
     * AIMENR_FRGNR_YN :: 소득자외국인여부
     */
    private String aimenrFrgnrYn;

    /**
     * DIL_WRKR_INCM_DUTY_NUM_DYS :: 일용근로소득근무일수
     */
    private String dilWrkrIncmDutyNumDys;

    /**
     * DIL_WRKR_INCM_TOT_PYMT_SUM :: 일용근로소득총지급금액
     */
    private BigInteger dilWrkrIncmTotPymtSum;

    /**
     * DIL_WRKR_FREE_DTY_INCM_SUM :: 일용근로소득비과세소득금액
     */
    private BigInteger dilWrkrFreeDtyIncmSum;

    /**
     * DIL_WRKR_INCM_INCM_TX_SUM :: 일용근로소득소득세금액
     */
    private BigInteger dilWrkrIncmIncmTxSum;

    /**
     * DIL_WRKR_RGON_INCM_TX_SUM :: 일용근로소득지방소득세금액
     */
    private BigInteger dilWrkrRgonIncmTxSum;

    /**
     * DIL_WRKR_INCM_DATA_ARRGT_DT :: 일용근로소득자료정리일자
     */
    private String dilWrkrIncmDataArrgtDt;

    /**
     * KYBDR :: 입력자
     */
    private String kybdr;

    /**
     * INPT_DT :: 입력일자
     */
    private String inptDt;

    /**
     * INPT_ADDR :: 입력주소
     */
    private String inptAddr;

    /**
     * ISMT :: 수정자
     */
    private String ismt;

    /**
     * REVN_DT :: 수정일자
     */
    private String revnDt;

    /**
     * REVN_ADDR :: 수정주소
     */
    private String revnAddr;

    /**
     * secResnNum :: 주민등록번호원본
     */
    private String secResnNum;

    private String searchCondition;

    /**
     * DIL_WRKR_INCM_BLGG_QATR_DIV_CD_ARR :: 일용근로소득귀속분기구분코드 배열
     */
    private List<String> dilWrkrIncmBlggQatrDivCdArr;

    private String deptCd;

    private String businCd;

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

    public String getDilWrkrIncmSeilNum() {
        return dilWrkrIncmSeilNum;
    }

    public void setDilWrkrIncmSeilNum(String dilWrkrIncmSeilNum) {
        this.dilWrkrIncmSeilNum = dilWrkrIncmSeilNum;
    }

    public String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(String systemkey) {
        this.systemkey = systemkey;
    }

    public String getDilWrkrIncmPymtYrMnth() {
        return dilWrkrIncmPymtYrMnth;
    }

    public void setDilWrkrIncmPymtYrMnth(String dilWrkrIncmPymtYrMnth) {
        this.dilWrkrIncmPymtYrMnth = dilWrkrIncmPymtYrMnth;
    }

    public String getDilWrkrIncmDutyYrMnth() {
        return dilWrkrIncmDutyYrMnth;
    }

    public void setDilWrkrIncmDutyYrMnth(String dilWrkrIncmDutyYrMnth) {
        this.dilWrkrIncmDutyYrMnth = dilWrkrIncmDutyYrMnth;
    }

    public String getAimenrNm() {
        return aimenrNm;
    }

    public void setAimenrNm(String aimenrNm) {
        this.aimenrNm = aimenrNm;
    }

    public String getAimenrResnRegnNum() {
        return aimenrResnRegnNum;
    }

    public void setAimenrResnRegnNum(String aimenrResnRegnNum) {
        this.aimenrResnRegnNum = aimenrResnRegnNum;
    }

    public String getAimenrZpcd() {
        return aimenrZpcd;
    }

    public void setAimenrZpcd(String aimenrZpcd) {
        this.aimenrZpcd = aimenrZpcd;
    }

    public String getAimenrRoadNmFndtnAddr() {
        return aimenrRoadNmFndtnAddr;
    }

    public void setAimenrRoadNmFndtnAddr(String aimenrRoadNmFndtnAddr) {
        this.aimenrRoadNmFndtnAddr = aimenrRoadNmFndtnAddr;
    }

    public String getAimenrRoadNmDtlPatrAddr() {
        return aimenrRoadNmDtlPatrAddr;
    }

    public void setAimenrRoadNmDtlPatrAddr(String aimenrRoadNmDtlPatrAddr) {
        this.aimenrRoadNmDtlPatrAddr = aimenrRoadNmDtlPatrAddr;
    }

    public String getAimenrPhnNum() {
        return aimenrPhnNum;
    }

    public void setAimenrPhnNum(String aimenrPhnNum) {
        this.aimenrPhnNum = aimenrPhnNum;
    }

    public String getAimenrFrgnrYn() {
        return aimenrFrgnrYn;
    }

    public void setAimenrFrgnrYn(String aimenrFrgnrYn) {
        this.aimenrFrgnrYn = aimenrFrgnrYn;
    }

    public String getDilWrkrIncmDutyNumDys() {
        return dilWrkrIncmDutyNumDys;
    }

    public void setDilWrkrIncmDutyNumDys(String dilWrkrIncmDutyNumDys) {
        this.dilWrkrIncmDutyNumDys = dilWrkrIncmDutyNumDys;
    }

    public BigInteger getDilWrkrIncmTotPymtSum() {
        return dilWrkrIncmTotPymtSum;
    }

    public void setDilWrkrIncmTotPymtSum(BigInteger dilWrkrIncmTotPymtSum) {
        this.dilWrkrIncmTotPymtSum = dilWrkrIncmTotPymtSum;
    }

    public BigInteger getDilWrkrFreeDtyIncmSum() {
        return dilWrkrFreeDtyIncmSum;
    }

    public void setDilWrkrFreeDtyIncmSum(BigInteger dilWrkrFreeDtyIncmSum) {
        this.dilWrkrFreeDtyIncmSum = dilWrkrFreeDtyIncmSum;
    }

    public BigInteger getDilWrkrIncmIncmTxSum() {
        return dilWrkrIncmIncmTxSum;
    }

    public void setDilWrkrIncmIncmTxSum(BigInteger dilWrkrIncmIncmTxSum) {
        this.dilWrkrIncmIncmTxSum = dilWrkrIncmIncmTxSum;
    }

    public BigInteger getDilWrkrRgonIncmTxSum() {
        return dilWrkrRgonIncmTxSum;
    }

    public void setDilWrkrRgonIncmTxSum(BigInteger dilWrkrRgonIncmTxSum) {
        this.dilWrkrRgonIncmTxSum = dilWrkrRgonIncmTxSum;
    }

    public String getDilWrkrIncmDataArrgtDt() {
        return dilWrkrIncmDataArrgtDt;
    }

    public void setDilWrkrIncmDataArrgtDt(String dilWrkrIncmDataArrgtDt) {
        this.dilWrkrIncmDataArrgtDt = dilWrkrIncmDataArrgtDt;
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

    public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public List<String> getDilWrkrIncmBlggQatrDivCdArr() {
        return dilWrkrIncmBlggQatrDivCdArr;
    }

    public void setDilWrkrIncmBlggQatrDivCdArr(List<String> dilWrkrIncmBlggQatrDivCdArr) {
        this.dilWrkrIncmBlggQatrDivCdArr = dilWrkrIncmBlggQatrDivCdArr;
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
}
