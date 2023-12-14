package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

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
public class Payr0600BM   extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
    public static final String ATTR_DILWRKRINCMBLGGYR = "dilWrkrIncmBlggYr";
    
    /** set 일용근로소득귀속년도 : dilWrkrIncmBlggYrDisp */
    public static final String ATTR_DILWRKRINCMBLGGYRDISP = "dilWrkrIncmBlggYrDisp";
    

    /** set 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
    public static final String ATTR_DILWRKRBLGGQATRDIVCD = "dilWrkrBlggQatrDivCd";

    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 일용근로자소득제출자료건수 : dilWrkrIncmSumtDataNum */
    public static final String ATTR_DILWRKRINCMSUMTDATANUM = "dilWrkrIncmSumtDataNum";

    /** set 일용근로자소득제출일자 : dilWrkrIncmSumtDt */
    public static final String ATTR_DILWRKRINCMSUMTDT = "dilWrkrIncmSumtDt";

    /** set 대표자성명 : degtrNm */
    public static final String ATTR_DEGTRNM = "degtrNm";

    /** set 법인명_상호 : corpNmFmnm */
    public static final String ATTR_CORPNMFMNM = "corpNmFmnm";

    /** set 사업자등록번호 : busoprRgstnNum */
    public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";

    /** set 법인번호 : corpNum */
    public static final String ATTR_CORPNUM = "corpNum";

    /** set 소득신고의무자우편번호 : incmRegrstDebrZpcd */
    public static final String ATTR_INCMREGRSTDEBRZPCD = "incmRegrstDebrZpcd";

    /** set 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
    public static final String ATTR_INCMREGRSTDEBRFNDTNADDR = "incmRegrstDebrFndtnAddr";

    /** set 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
    public static final String ATTR_INCMREGRSTDEBRDTLPATRADDR = "incmRegrstDebrDtlPatrAddr";

    /** set 관할세무서코드 : juriTxOffcCd */
    public static final String ATTR_JURITXOFFCCD = "juriTxOffcCd";

    /** set 제출자구분코드 : pentrCd */
    public static final String ATTR_PENTRCD = "pentrCd";

    /** set 세무대리인번호 : txDeptyNum */
    public static final String ATTR_TXDEPTYNUM = "txDeptyNum";

    /** set 홈텍스ID : hmtxId */
    public static final String ATTR_HMTXID = "hmtxId";

    /** set 세무프로그램코드 : txPgmCd */
    public static final String ATTR_TXPGMCD = "txPgmCd";

    /** set 담당자부서명 : pernChrgDeptNm */
    public static final String ATTR_PERNCHRGDEPTNM = "pernChrgDeptNm";

    /** set 담당자성명 : pernChrgNm */
    public static final String ATTR_PERNCHRGNM = "pernChrgNm";

    /** set 담당자전화번호 : pernChrgPhnNum */
    public static final String ATTR_PERNCHRGPHNNUM = "pernChrgPhnNum";

    /** set 일용근로자소득제출마감일자 : dilWrkrIncmSumtDdlneDt */
    public static final String ATTR_DILWRKRINCMSUMTDDLNEDT = "dilWrkrIncmSumtDdlneDt";

    /** set 일용근로자소득제출마감여부 : dilWrkrIncmSumtDdlneYn */
    public static final String ATTR_DILWRKRINCMSUMTDDLNEYN = "dilWrkrIncmSumtDdlneYn";

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

    /** 생성자 */
     public Payr0600BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0600BM(
    		 String  dilWrkrIncmBlggYr 
    		, String  dilWrkrBlggQatrDivCd 
    		, String  payrMangDeptCd 
    		, String  dpobCd 
    		, BigDecimal  dilWrkrIncmSumtDataNum 
    		, String  dilWrkrIncmSumtDt 
    		, String  degtrNm 
    		, String  corpNmFmnm 
    		, String  busoprRgstnNum 
    		, String  resnRegnNum 
    		, String  corpNum 
    		, String  incmRegrstDebrZpcd 
    		, String  incmRegrstDebrFndtnAddr 
    		, String  incmRegrstDebrDtlPatrAddr 
    		, String  juriTxOffcCd 
    		, String  pentrCd 
    		, String  txDeptyNum 
    		, String  hmtxId 
    		, String  txPgmCd 
    		, String  pernChrgDeptNm 
    		, String  pernChrgNm 
    		, String  pernChrgPhnNum 
    		, String  dilWrkrIncmSumtDdlneDt 
    		, String  dilWrkrIncmSumtDdlneYn 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DILWRKRINCMBLGGYR,dilWrkrIncmBlggYr);
     	values.put(ATTR_DILWRKRBLGGQATRDIVCD,dilWrkrBlggQatrDivCd);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DILWRKRINCMSUMTDATANUM,dilWrkrIncmSumtDataNum);
     	values.put(ATTR_DILWRKRINCMSUMTDT,dilWrkrIncmSumtDt);
     	values.put(ATTR_DEGTRNM,degtrNm);
     	values.put(ATTR_CORPNMFMNM,corpNmFmnm);
     	values.put(ATTR_BUSOPRRGSTNNUM,busoprRgstnNum);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum);
     	values.put(ATTR_CORPNUM,corpNum);
     	values.put(ATTR_INCMREGRSTDEBRZPCD,incmRegrstDebrZpcd);
     	values.put(ATTR_INCMREGRSTDEBRFNDTNADDR,incmRegrstDebrFndtnAddr);
     	values.put(ATTR_INCMREGRSTDEBRDTLPATRADDR,incmRegrstDebrDtlPatrAddr);
     	values.put(ATTR_JURITXOFFCCD,juriTxOffcCd);
     	values.put(ATTR_PENTRCD,pentrCd);
     	values.put(ATTR_TXDEPTYNUM,txDeptyNum);
     	values.put(ATTR_HMTXID,hmtxId);
     	values.put(ATTR_TXPGMCD,txPgmCd);
     	values.put(ATTR_PERNCHRGDEPTNM,pernChrgDeptNm);
     	values.put(ATTR_PERNCHRGNM,pernChrgNm);
     	values.put(ATTR_PERNCHRGPHNNUM,pernChrgPhnNum);
     	values.put(ATTR_DILWRKRINCMSUMTDDLNEDT,dilWrkrIncmSumtDdlneDt);
     	values.put(ATTR_DILWRKRINCMSUMTDDLNEYN,dilWrkrIncmSumtDdlneYn);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
    public void setDilWrkrIncmBlggYr(String  dilWrkrIncmBlggYr) { set( ATTR_DILWRKRINCMBLGGYR ,dilWrkrIncmBlggYr);}
    /** get 일용근로소득귀속년도 : dilWrkrIncmBlggYr */
    public String  getDilWrkrIncmBlggYr() { return (String )get( ATTR_DILWRKRINCMBLGGYR );}
    

    /** set 일용근로소득귀속년도 : dilWrkrIncmBlggYrDisp */
    public void setDilWrkrIncmBlggYrDisp(String  dilWrkrIncmBlggYrDisp) { set( ATTR_DILWRKRINCMBLGGYRDISP ,dilWrkrIncmBlggYrDisp);}
    /** get 일용근로소득귀속년도 : dilWrkrIncmBlggYrDisp */
    public String  getDilWrkrIncmBlggYrDisp() { return (String )get( ATTR_DILWRKRINCMBLGGYRDISP );}
    

    /** set 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
    public void setDilWrkrBlggQatrDivCd(String  dilWrkrBlggQatrDivCd) { set( ATTR_DILWRKRBLGGQATRDIVCD ,dilWrkrBlggQatrDivCd);}
    /** get 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
    public String  getDilWrkrBlggQatrDivCd() { return (String )get( ATTR_DILWRKRBLGGQATRDIVCD );}

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 일용근로자소득제출자료건수 : dilWrkrIncmSumtDataNum */
    public void setDilWrkrIncmSumtDataNum(BigDecimal  dilWrkrIncmSumtDataNum) { set( ATTR_DILWRKRINCMSUMTDATANUM ,dilWrkrIncmSumtDataNum);}
    /** get 일용근로자소득제출자료건수 : dilWrkrIncmSumtDataNum */
    public BigDecimal  getDilWrkrIncmSumtDataNum() { return (BigDecimal )get( ATTR_DILWRKRINCMSUMTDATANUM );}

    /** set 일용근로자소득제출일자 : dilWrkrIncmSumtDt */
    public void setDilWrkrIncmSumtDt(String  dilWrkrIncmSumtDt) { set( ATTR_DILWRKRINCMSUMTDT ,dilWrkrIncmSumtDt);}
    /** get 일용근로자소득제출일자 : dilWrkrIncmSumtDt */
    public String  getDilWrkrIncmSumtDt() { return (String )get( ATTR_DILWRKRINCMSUMTDT );}

    /** set 대표자성명 : degtrNm */
    public void setDegtrNm(String  degtrNm) { set( ATTR_DEGTRNM ,degtrNm);}
    /** get 대표자성명 : degtrNm */
    public String  getDegtrNm() { return (String )get( ATTR_DEGTRNM );}

    /** set 법인명_상호 : corpNmFmnm */
    public void setCorpNmFmnm(String  corpNmFmnm) { set( ATTR_CORPNMFMNM ,corpNmFmnm);}
    /** get 법인명_상호 : corpNmFmnm */
    public String  getCorpNmFmnm() { return (String )get( ATTR_CORPNMFMNM );}

    /** set 사업자등록번호 : busoprRgstnNum */
    public void setBusoprRgstnNum(String  busoprRgstnNum) { set( ATTR_BUSOPRRGSTNNUM ,busoprRgstnNum);}
    /** get 사업자등록번호 : busoprRgstnNum */
    public String  getBusoprRgstnNum() { return (String )get( ATTR_BUSOPRRGSTNNUM );}

    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

    /** set 법인번호 : corpNum */
    public void setCorpNum(String  corpNum) { set( ATTR_CORPNUM ,corpNum);}
    /** get 법인번호 : corpNum */
    public String  getCorpNum() { return (String )get( ATTR_CORPNUM );}

    /** set 소득신고의무자우편번호 : incmRegrstDebrZpcd */
    public void setIncmRegrstDebrZpcd(String  incmRegrstDebrZpcd) { set( ATTR_INCMREGRSTDEBRZPCD ,incmRegrstDebrZpcd);}
    /** get 소득신고의무자우편번호 : incmRegrstDebrZpcd */
    public String  getIncmRegrstDebrZpcd() { return (String )get( ATTR_INCMREGRSTDEBRZPCD );}

    /** set 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
    public void setIncmRegrstDebrFndtnAddr(String  incmRegrstDebrFndtnAddr) { set( ATTR_INCMREGRSTDEBRFNDTNADDR ,incmRegrstDebrFndtnAddr);}
    /** get 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
    public String  getIncmRegrstDebrFndtnAddr() { return (String )get( ATTR_INCMREGRSTDEBRFNDTNADDR );}

    /** set 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
    public void setIncmRegrstDebrDtlPatrAddr(String  incmRegrstDebrDtlPatrAddr) { set( ATTR_INCMREGRSTDEBRDTLPATRADDR ,incmRegrstDebrDtlPatrAddr);}
    /** get 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
    public String  getIncmRegrstDebrDtlPatrAddr() { return (String )get( ATTR_INCMREGRSTDEBRDTLPATRADDR );}

    /** set 관할세무서코드 : juriTxOffcCd */
    public void setJuriTxOffcCd(String  juriTxOffcCd) { set( ATTR_JURITXOFFCCD ,juriTxOffcCd);}
    /** get 관할세무서코드 : juriTxOffcCd */
    public String  getJuriTxOffcCd() { return (String )get( ATTR_JURITXOFFCCD );}

    /** set 제출자구분코드 : pentrCd */
    public void setPentrCd(String  pentrCd) { set( ATTR_PENTRCD ,pentrCd);}
    /** get 제출자구분코드 : pentrCd */
    public String  getPentrCd() { return (String )get( ATTR_PENTRCD );}

    /** set 세무대리인번호 : txDeptyNum */
    public void setTxDeptyNum(String  txDeptyNum) { set( ATTR_TXDEPTYNUM ,txDeptyNum);}
    /** get 세무대리인번호 : txDeptyNum */
    public String  getTxDeptyNum() { return (String )get( ATTR_TXDEPTYNUM );}

    /** set 홈텍스ID : hmtxId */
    public void setHmtxId(String  hmtxId) { set( ATTR_HMTXID ,hmtxId);}
    /** get 홈텍스ID : hmtxId */
    public String  getHmtxId() { return (String )get( ATTR_HMTXID );}

    /** set 세무프로그램코드 : txPgmCd */
    public void setTxPgmCd(String  txPgmCd) { set( ATTR_TXPGMCD ,txPgmCd);}
    /** get 세무프로그램코드 : txPgmCd */
    public String  getTxPgmCd() { return (String )get( ATTR_TXPGMCD );}

    /** set 담당자부서명 : pernChrgDeptNm */
    public void setPernChrgDeptNm(String  pernChrgDeptNm) { set( ATTR_PERNCHRGDEPTNM ,pernChrgDeptNm);}
    /** get 담당자부서명 : pernChrgDeptNm */
    public String  getPernChrgDeptNm() { return (String )get( ATTR_PERNCHRGDEPTNM );}

    /** set 담당자성명 : pernChrgNm */
    public void setPernChrgNm(String  pernChrgNm) { set( ATTR_PERNCHRGNM ,pernChrgNm);}
    /** get 담당자성명 : pernChrgNm */
    public String  getPernChrgNm() { return (String )get( ATTR_PERNCHRGNM );}

    /** set 담당자전화번호 : pernChrgPhnNum */
    public void setPernChrgPhnNum(String  pernChrgPhnNum) { set( ATTR_PERNCHRGPHNNUM ,pernChrgPhnNum);}
    /** get 담당자전화번호 : pernChrgPhnNum */
    public String  getPernChrgPhnNum() { return (String )get( ATTR_PERNCHRGPHNNUM );}

    /** set 일용근로자소득제출마감일자 : dilWrkrIncmSumtDdlneDt */
    public void setDilWrkrIncmSumtDdlneDt(String  dilWrkrIncmSumtDdlneDt) { set( ATTR_DILWRKRINCMSUMTDDLNEDT ,dilWrkrIncmSumtDdlneDt);}
    /** get 일용근로자소득제출마감일자 : dilWrkrIncmSumtDdlneDt */
    public String  getDilWrkrIncmSumtDdlneDt() { return (String )get( ATTR_DILWRKRINCMSUMTDDLNEDT );}

    /** set 일용근로자소득제출마감여부 : dilWrkrIncmSumtDdlneYn */
    public void setDilWrkrIncmSumtDdlneYn(String  dilWrkrIncmSumtDdlneYn) { set( ATTR_DILWRKRINCMSUMTDDLNEYN ,dilWrkrIncmSumtDdlneYn);}
    /** get 일용근로자소득제출마감여부 : dilWrkrIncmSumtDdlneYn */
    public String  getDilWrkrIncmSumtDdlneYn() { return (String )get( ATTR_DILWRKRINCMSUMTDDLNEYN );}

    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}

    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}
    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
  
    
}
