package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

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
public class Payr0650BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;

    /** set check : delCheck */
    public static final String ATTR_DELCHECK = "delCheck";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
    public static final String ATTR_DILWRKRINCMBLGGYR = "dilWrkrIncmBlggYr";

    /** set 일용근로소득귀속분기구분코드 : dilWrkrIncmBlggQatrDivCd */
    public static final String ATTR_DILWRKRINCMBLGGQATRDIVCD = "dilWrkrIncmBlggQatrDivCd";

    /** set 일용근로소득귀속분기구분코드 : dilWrkrIncmBlggQatrDivCdArr */
    public static final String ATTR_DILWRKRINCMBLGGQATRDIVCDARR = "dilWrkrIncmBlggQatrDivCdArr";

    /** set 일용근로소득귀속분기 : dilWrkrIncmBlggQatrDivNm */
    public static final String ATTR_DILWRKRINCMBLGGQATRDIVNM = "dilWrkrIncmBlggQatrDivNm";

    /** set 일용근로소득일련번호 : dilWrkrIncmSeilNum */
    public static final String ATTR_DILWRKRINCMSEILNUM = "dilWrkrIncmSeilNum";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 일용근로소득지급년월 : dilWrkrIncmPymtYrMnth */
    public static final String ATTR_DILWRKRINCMPYMTYRMNTH = "dilWrkrIncmPymtYrMnth";

    /** set 일용근로소득근무년월 : dilWrkrIncmDutyYrMnth */
    public static final String ATTR_DILWRKRINCMDUTYYRMNTH = "dilWrkrIncmDutyYrMnth";

    /** set 소득자성명 : aimenrNm */
    public static final String ATTR_AIMENRNM = "aimenrNm";

    /** set 소득자주민등록번호 : aimenrResnRegnNum */
    public static final String ATTR_AIMENRRESNREGNNUM = "aimenrResnRegnNum";

    /** set 소득자우편번호 : aimenrZpcd */
    public static final String ATTR_AIMENRZPCD = "aimenrZpcd";

    /** set 소득자도로명기본주소 : aimenrRoadNmFndtnAddr */
    public static final String ATTR_AIMENRROADNMFNDTNADDR = "aimenrRoadNmFndtnAddr";

    /** set 소득자도로명상세주소 : aimenrRoadNmDtlPatrAddr */
    public static final String ATTR_AIMENRROADNMDTLPATRADDR = "aimenrRoadNmDtlPatrAddr";

    /** set 소득자전화번호 : aimenrPhnNum */
    public static final String ATTR_AIMENRPHNNUM = "aimenrPhnNum";

    /** set 소득자외국인여부 : aimenrFrgnrYn */
    public static final String ATTR_AIMENRFRGNRYN = "aimenrFrgnrYn";

    /** set 일용근로소득근무일수 : dilWrkrIncmDutyNumDys */
    public static final String ATTR_DILWRKRINCMDUTYNUMDYS = "dilWrkrIncmDutyNumDys";

    /** set 일용근로소득총지급금액 : dilWrkrIncmTotPymtSum */
    public static final String ATTR_DILWRKRINCMTOTPYMTSUM = "dilWrkrIncmTotPymtSum";

    /** set 일용근로소득비과세소득금액 : dilWrkrFreeDtyIncmSum */
    public static final String ATTR_DILWRKRFREEDTYINCMSUM = "dilWrkrFreeDtyIncmSum";

    /** set 일용근로소득소득세금액 : dilWrkrIncmIncmTxSum */
    public static final String ATTR_DILWRKRINCMINCMTXSUM = "dilWrkrIncmIncmTxSum";

    /** set 일용근로소득지방소득세금액 : dilWrkrRgonIncmTxSum */
    public static final String ATTR_DILWRKRRGONINCMTXSUM = "dilWrkrRgonIncmTxSum";

    /** set 일용근로소득자료정리일자 : dilWrkrIncmDataArrgtDt */
    public static final String ATTR_DILWRKRINCMDATAARRGTDT = "dilWrkrIncmDataArrgtDt";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** set 소득자도로명주소 : aimenrRoadNmAddr */
    public static final String ATTR_AIMENRROADNMADDR = "aimenrRoadNmAddr";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 부서명 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

    public static final String ATTR_DEGTRNM = "degtrNm";
    public static final String ATTR_CORPNMFMNM = "corpNmFmnm";
    public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";
    public static final String ATTR_BUSOPRRESNREGNNUM = "busoprResnRegnNum";
    public static final String ATTR_CORPNUM = "corpNum";
    public static final String ATTR_INCMREGRSTDEBRZPCD = "incmRegrstDebrZpcd";
    public static final String ATTR_INCMREGRSTDEBRFNDTNADDR = "incmRegrstDebrFndtnAddr";
    public static final String ATTR_INCMREGRSTDEBRDTLPATRADDR = "incmRegrstDebrDtlPatrAddr";
    public static final String ATTR_JURITXOFFCCD = "juriTxOffcCd";
    public static final String ATTR_PENTRCD = "pentrCd";
    public static final String ATTR_TXDEPTYNUM = "txDeptyNum";
    public static final String ATTR_HMTXID = "hmtxId";
    public static final String ATTR_TXPGMCD = "txPgmCd";
    public static final String ATTR_PERNCHRGDEPTNM = "pernChrgDeptNm";
    public static final String ATTR_PERNCHRGNM = "pernChrgNm";
    public static final String ATTR_PERNCHRGPHNNUM = "pernChrgPhnNum";
    public static final String ATTR_ECTNMAILADDR = "ectnMailAddr";



    /** 생성자 */
     public Payr0650BM() { super(); } 

    /** 일괄등록 처리   */
    public Payr0650BM(
            String dpobCd
            , String dilWrkrIncmBlggYr
            , String dilWrkrIncmBlggQatrDivCd
            , String dilWrkrIncmBlggQatrDivCdArr
            , String dilWrkrIncmBlggQatrDivNm
            , String dilWrkrIncmSeilNum
            , String systemkey
            , String dilWrkrIncmPymtYrMnth
            , String dilWrkrIncmDutyYrMnth
            , String aimenrNm
            , String aimenrResnRegnNum
            , String aimenrZpcd
            , String aimenrRoadNmFndtnAddr
            , String aimenrRoadNmDtlPatrAddr
            , String aimenrPhnNum
            , String aimenrFrgnrYn
            , BigDecimal dilWrkrIncmDutyNumDys
            , BigDecimal dilWrkrIncmTotPymtSum
            , BigDecimal dilWrkrFreeDtyIncmSum
            , BigDecimal dilWrkrIncmIncmTxSum
            , BigDecimal dilWrkrRgonIncmTxSum
            , String dilWrkrIncmDataArrgtDt
            , String kybdr
            , String inptDt
            , String inptAddr
            , String ismt
            , String revnDt
            , String revnAddr
            , String aimenrRoadNmAddr
            , String deptCd
            , String businCd
            , String payrMangDeptCd
            , String deptNm
            , String businNm
    ){
        values.put(ATTR_DPOBCD,dpobCd);
        values.put(ATTR_DILWRKRINCMBLGGYR,dilWrkrIncmBlggYr);
        values.put(ATTR_DILWRKRINCMBLGGQATRDIVCD, dilWrkrIncmBlggQatrDivCd);
        values.put(ATTR_DILWRKRINCMBLGGQATRDIVCDARR,dilWrkrIncmBlggQatrDivCdArr);
        values.put(ATTR_DILWRKRINCMBLGGQATRDIVNM,dilWrkrIncmBlggQatrDivNm);
        values.put(ATTR_DILWRKRINCMSEILNUM,dilWrkrIncmSeilNum);
        values.put(ATTR_SYSTEMKEY,systemkey);
        values.put(ATTR_DILWRKRINCMPYMTYRMNTH,dilWrkrIncmPymtYrMnth);
        values.put(ATTR_DILWRKRINCMDUTYYRMNTH,dilWrkrIncmDutyYrMnth);
        values.put(ATTR_AIMENRNM,aimenrNm);
        values.put(ATTR_AIMENRRESNREGNNUM  , aimenrResnRegnNum );
        values.put(ATTR_AIMENRZPCD,aimenrZpcd);
        values.put(ATTR_AIMENRROADNMFNDTNADDR,aimenrRoadNmFndtnAddr);
        values.put(ATTR_AIMENRROADNMDTLPATRADDR,aimenrRoadNmDtlPatrAddr);
        values.put(ATTR_AIMENRPHNNUM,aimenrPhnNum);
        values.put(ATTR_AIMENRFRGNRYN,aimenrFrgnrYn);
        values.put(ATTR_DILWRKRINCMDUTYNUMDYS,dilWrkrIncmDutyNumDys);
        values.put(ATTR_DILWRKRINCMTOTPYMTSUM,dilWrkrIncmTotPymtSum);
        values.put(ATTR_DILWRKRFREEDTYINCMSUM,dilWrkrFreeDtyIncmSum);
        values.put(ATTR_DILWRKRINCMINCMTXSUM,dilWrkrIncmIncmTxSum);
        values.put(ATTR_DILWRKRRGONINCMTXSUM,dilWrkrRgonIncmTxSum);
        values.put(ATTR_DILWRKRINCMDATAARRGTDT,dilWrkrIncmDataArrgtDt);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr);
        values.put(ATTR_AIMENRROADNMADDR,aimenrRoadNmAddr);
        values.put(ATTR_DEPTCD,deptCd);
        values.put(ATTR_BUSINCD,businCd);
        values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
        values.put(ATTR_DEPTNM,deptNm);
        values.put(ATTR_BUSINNM,businNm);
    }

    public String getDpobCd(){ return (String)get(ATTR_DPOBCD);}
    public String getDilWrkrIncmBlggYr(){ return (String)get(ATTR_DILWRKRINCMBLGGYR);}
    public String getDilWrkrIncmBlggQatrDivCd(){ return (String)get(ATTR_DILWRKRINCMBLGGQATRDIVCD);}
    public String getDilWrkrIncmBlggQatrDivCdArr(){ return (String)get(ATTR_DILWRKRINCMBLGGQATRDIVCD);}
    public String getDilWrkrIncmBlggQatrDivNm(){ return (String)get(ATTR_DILWRKRINCMBLGGQATRDIVCDARR);}
    public String getDilWrkrIncmSeilNum(){ return (String)get(ATTR_DILWRKRINCMSEILNUM);}
    public String getSystemkey(){ return (String)get(ATTR_SYSTEMKEY);}
    public String getDilWrkrIncmPymtYrMnth(){ return (String)get(ATTR_DILWRKRINCMPYMTYRMNTH);}
    public String getDilWrkrIncmDutyYrMnth(){ return (String)get(ATTR_DILWRKRINCMDUTYYRMNTH);}
    public String getAimenrNm(){ return (String)get(ATTR_AIMENRNM);}
    public String getAimenrResnRegnNum(){ return (String)get(ATTR_AIMENRRESNREGNNUM);}
    public String getAimenrZpcd(){ return (String)get(ATTR_AIMENRZPCD);}
    public String getAimenrRoadNmFndtnAddr(){ return (String)get(ATTR_AIMENRROADNMFNDTNADDR);}
    public String getAimenrRoadNmDtlPatrAddr(){ return (String)get(ATTR_AIMENRROADNMFNDTNADDR);}
    public String getAimenrPhnNum(){ return (String)get(ATTR_AIMENRPHNNUM);}
    public String getAimenrFrgnrYn(){ return (String)get(ATTR_AIMENRFRGNRYN);}
    public BigDecimal getDilWrkrIncmDutyNumDys(){ return (BigDecimal)get(ATTR_DILWRKRINCMDUTYYRMNTH);}
    public BigDecimal getDilWrkrIncmTotPymtSum(){ return (BigDecimal)get(ATTR_DILWRKRINCMTOTPYMTSUM);}
    public BigDecimal getDilWrkrFreeDtyIncmSum(){ return (BigDecimal)get(ATTR_DILWRKRFREEDTYINCMSUM);}
    public BigDecimal getDilWrkrIncmIncmTxSum(){ return (BigDecimal)get(ATTR_DILWRKRINCMINCMTXSUM);}
    public BigDecimal getDilWrkrRgonIncmTxSum(){ return (BigDecimal)get(ATTR_DILWRKRRGONINCMTXSUM);}
    public String getDilWrkrIncmDataArrgtDt(){ return (String)get(ATTR_DILWRKRINCMDATAARRGTDT);}
    public String getKybdr(){ return (String)get(ATTR_KYBDR);}
    public String getInptDt(){ return (String)get(ATTR_INPTDT);}
    public String getInptAddr(){ return (String)get(ATTR_INPTADDR);}
    public String getIsmt(){ return (String)get(ATTR_ISMT);}
    public String getRevnDt(){ return (String)get(ATTR_REVNDT);}
    public String getRevnAddr(){ return (String)get(ATTR_REVNADDR);}
    public String getAimenrRoadNmAddr(){ return (String)get(ATTR_AIMENRROADNMADDR);}
    public String getDeptCd(){ return (String)get(ATTR_DEPTCD);}
    public String getBusinCd(){ return (String)get(ATTR_BUSINCD);}
    public String getPayrMangDeptCd(){ return (String)get(ATTR_PAYRMANGDEPTCD);}
    public String getDeptNm(){ return (String)get(ATTR_DEPTNM);}
    public String getBusinNm(){ return (String)get(ATTR_BUSINNM);}

    public String getDegtrNm() { return (String)get(ATTR_DEGTRNM); }
    public String getCorpNmFmnm() { return (String)get(ATTR_CORPNMFMNM); }
    public String getBusoprRgstnNum() { return (String)get(ATTR_BUSOPRRGSTNNUM); }
    public String getBusoprResnRegnNum() { return (String)get(ATTR_BUSOPRRESNREGNNUM); }
    public String getCorpNum() { return (String)get(ATTR_CORPNUM); }
    public String getIncmRegrstDebrZpcd() { return (String)get(ATTR_INCMREGRSTDEBRZPCD); }
    public String getIncmRegrstDebrFndtnAddr() { return (String)get(ATTR_INCMREGRSTDEBRFNDTNADDR); }
    public String getIncmRegrstDebrDtlPatrAddr() { return (String)get(ATTR_INCMREGRSTDEBRDTLPATRADDR); }
    public String getJuriTxOffcCd() { return (String)get(ATTR_JURITXOFFCCD); }
    public String getPentrCd() { return (String)get(ATTR_PENTRCD); }
    public String getTxDeptyNum() { return (String)get(ATTR_TXDEPTYNUM); }
    public String getHmtxId() { return (String)get(ATTR_HMTXID); }
    public String getTxPgmCd() { return (String)get(ATTR_TXPGMCD); }
    public String getPernChrgDeptNm() { return (String)get(ATTR_PERNCHRGDEPTNM); }
    public String getPernChrgNm() { return (String)get(ATTR_PERNCHRGNM); }
    public String getPernChrgPhnNum() { return (String)get(ATTR_PERNCHRGPHNNUM); }
    public String getEctnMailAddr() { return (String)get(ATTR_ECTNMAILADDR); }


    public void setDpobCd(String dpobCd){ set(ATTR_DPOBCD, dpobCd);}
    public void setDilWrkrIncmBlggYr(String dilWrkrIncmBlggYr){  set(ATTR_DILWRKRINCMBLGGYR, dilWrkrIncmBlggYr);}
    public void setDilWrkrIncmBlggQatrDivCd(String dilWrkrIncmBlggQatrDivCd){  set(ATTR_DILWRKRINCMBLGGQATRDIVCD, dilWrkrIncmBlggQatrDivCd);}
    public void setDilWrkrIncmBlggQatrDivCdArr(String dilWrkrIncmBlggQatrDivCdArr){  set(ATTR_DILWRKRINCMBLGGQATRDIVCD, dilWrkrIncmBlggQatrDivCdArr);}
    public void setDilWrkrIncmBlggQatrDivNm(String dilWrkrIncmBlggQatrDivNm){  set(ATTR_DILWRKRINCMBLGGQATRDIVCDARR, dilWrkrIncmBlggQatrDivNm);}
    public void setDilWrkrIncmSeilNum(String dilWrkrIncmSeilNum){  set(ATTR_DILWRKRINCMSEILNUM, dilWrkrIncmSeilNum);}
    public void setSystemkey(String systemkey){  set(ATTR_SYSTEMKEY, systemkey);}
    public void setDilWrkrIncmPymtYrMnth(String dilWrkrIncmPymtYrMnth){  set(ATTR_DILWRKRINCMPYMTYRMNTH, dilWrkrIncmPymtYrMnth );}
    public void setDilWrkrIncmDutyYrMnth(String dilWrkrIncmDutyYrMnth){  set(ATTR_DILWRKRINCMDUTYYRMNTH, dilWrkrIncmDutyYrMnth );}
    public void setAimenrNm(String aimenrNm){  set(ATTR_AIMENRNM, aimenrNm);}
    public void setAimenrResnRegnNum(String aimenrResnRegnNum){  set(ATTR_AIMENRRESNREGNNUM,aimenrResnRegnNum );}
    public void setAimenrZpcd(String aimenrZpcd){  set(ATTR_AIMENRZPCD, aimenrZpcd);}
    public void setAimenrRoadNmFndtnAddr(String aimenrRoadNmFndtnAddr){  set(ATTR_AIMENRROADNMFNDTNADDR, aimenrRoadNmFndtnAddr);}
    public void setAimenrRoadNmDtlPatrAddr(String aimenrRoadNmDtlPatrAddr){  set(ATTR_AIMENRROADNMFNDTNADDR,aimenrRoadNmDtlPatrAddr );}
    public void setAimenrPhnNum(String aimenrPhnNum){  set(ATTR_AIMENRPHNNUM, aimenrPhnNum);}
    public void setAimenrFrgnrYn(String aimenrFrgnrYn){  set(ATTR_AIMENRFRGNRYN, aimenrFrgnrYn);}
    public void setDilWrkrIncmDutyNumDys(String dilWrkrIncmDutyNumDys){  set(ATTR_DILWRKRINCMDUTYYRMNTH, dilWrkrIncmDutyNumDys);}
    public void setDilWrkrIncmTotPymtSum(BigDecimal dilWrkrIncmTotPymtSum){  set(ATTR_DILWRKRINCMTOTPYMTSUM,dilWrkrIncmTotPymtSum );}
    public void setDilWrkrFreeDtyIncmSum(BigDecimal dilWrkrFreeDtyIncmSum){  set(ATTR_DILWRKRFREEDTYINCMSUM, dilWrkrFreeDtyIncmSum );}
    public void setDilWrkrIncmIncmTxSum(BigDecimal dilWrkrIncmIncmTxSum){  set(ATTR_DILWRKRINCMINCMTXSUM, dilWrkrIncmIncmTxSum);}
    public void setDilWrkrRgonIncmTxSum(BigDecimal dilWrkrRgonIncmTxSum){  set(ATTR_DILWRKRRGONINCMTXSUM, dilWrkrRgonIncmTxSum);}
    public void setDilWrkrIncmDataArrgtDt(String dilWrkrIncmDataArrgtDt){  set(ATTR_DILWRKRINCMDATAARRGTDT, dilWrkrIncmDataArrgtDt);}
    public void setKybdr(String kybdr){  set(ATTR_KYBDR, kybdr );}
    public void setInptDt(String inptDt){  set(ATTR_INPTDT, inptDt);}
    public void setInptAddr(String inptAddr){  set(ATTR_INPTADDR, inptAddr);}
    public void setIsmt(String ismt){  set(ATTR_ISMT, ismt);}
    public void setRevnDt(String revnDt){  set(ATTR_REVNDT, revnDt);}
    public void setRevnAddr(String revnAddr){  set(ATTR_REVNADDR, revnAddr);}
    public void setAimenrRoadNmAddr(String aimenrRoadNmAddr){  set(ATTR_AIMENRROADNMADDR,aimenrRoadNmAddr );}
    public void setDeptCd(String deptCd ){  set(ATTR_DEPTCD, deptCd);}
    public void setBusinCd(String businCd){  set(ATTR_BUSINCD,businCd );}
    public void setPayrMangDeptCd(String payrMangDeptCd ){  set(ATTR_PAYRMANGDEPTCD, payrMangDeptCd);}
    public void setDeptNm(String deptNm ){  set(ATTR_DEPTNM, deptNm);}
    public void setBusinNm(String businNm){  set(ATTR_BUSINNM, businNm);}


    public void setDegtrNm(String degtrNm) {set(ATTR_DEGTRNM, degtrNm); }
    public void setCorpNmFmnm(String corpNmFmnm) {set(ATTR_CORPNMFMNM, corpNmFmnm); }
    public void setBusoprRgstnNum(String busoprRgstnNum) {set(ATTR_BUSOPRRGSTNNUM, busoprRgstnNum); }
    public void setBusoprResnRegnNum(String busoprResnRegnNum) {set(ATTR_BUSOPRRESNREGNNUM, busoprResnRegnNum); }
    public void setCorpNum(String corpNum) {set(ATTR_CORPNUM, corpNum); }
    public void setIncmRegrstDebrZpcd(String incmRegrstDebrZpcd) {set(ATTR_INCMREGRSTDEBRZPCD, incmRegrstDebrZpcd); }
    public void setIncmRegrstDebrFndtnAddr(String incmRegrstDebrFndtnAddr) {set(ATTR_INCMREGRSTDEBRFNDTNADDR, incmRegrstDebrFndtnAddr); }
    public void setIncmRegrstDebrDtlPatrAddr(String incmRegrstDebrDtlPatrAddr) {set(ATTR_INCMREGRSTDEBRDTLPATRADDR, incmRegrstDebrDtlPatrAddr); }
    public void setJuriTxOffcCd(String juriTxOffcCd) {set(ATTR_JURITXOFFCCD, juriTxOffcCd); }
    public void setPentrCd(String pentrCd) {set(ATTR_PENTRCD, pentrCd); }
    public void setTxDeptyNum(String txDeptyNum) {set(ATTR_TXDEPTYNUM, txDeptyNum); }
    public void setHmtxId(String hmtxId) {set(ATTR_HMTXID, hmtxId); }
    public void setTxPgmCd(String txPgmCd) {set(ATTR_TXPGMCD, txPgmCd); }
    public void setPernChrgDeptNm(String pernChrgDeptNm) {set(ATTR_PERNCHRGDEPTNM, pernChrgDeptNm); }
    public void setPernChrgNm(String pernChrgNm) {set(ATTR_PERNCHRGNM, pernChrgNm); }
    public void setPernChrgPhnNum(String pernChrgPhnNum) {set(ATTR_PERNCHRGPHNNUM, pernChrgPhnNum); }
    public void setEctnMailAddr(String ectnMailAddr) {set(ATTR_ECTNMAILADDR, ectnMailAddr); }




}
