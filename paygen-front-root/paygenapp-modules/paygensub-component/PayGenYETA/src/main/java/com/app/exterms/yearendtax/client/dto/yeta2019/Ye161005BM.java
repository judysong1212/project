package com.app.exterms.yearendtax.client.dto.yeta2019;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Ye161005BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 원천세신고부서코드 : whdgTxRegrstDeptCd */
    public static final String ATTR_WHDGTXREGRSTDEPTCD = "whdgTxRegrstDeptCd";
    
    
    /** set 원천세신고부서코드 : whdgTxRegrstDeptNm */
    public static final String ATTR_WHDGTXREGRSTDEPTNM = "whdgTxRegrstDeptNm";
    

    /** set 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
    public static final String ATTR_HHRKWHDGREGRSTDEPTCD = "hhrkWhdgRegrstDeptCd";

    /** set A3_세무서코드 : txOffcCd */
    public static final String ATTR_TXOFFCCD = "txOffcCd";

    /** set A5_제출자구분 : pentrSeptCd */
    public static final String ATTR_PENTRSEPTCD = "pentrSeptCd";

    /** set A6_세무대리인관리번호 : txDeptyMangeNum */
    public static final String ATTR_TXDEPTYMANGENUM = "txDeptyMangeNum";

    /** set A7_홈텍스ID : hmtxId */
    public static final String ATTR_HMTXID = "hmtxId";

    /** set A8_세무프로그램코드 : txPgmCd */
    public static final String ATTR_TXPGMCD = "txPgmCd";

    /** set A9_사업자등록번호 : busoprRgstnum */
    public static final String ATTR_BUSOPRRGSTNUM = "busoprRgstnum";

    /** set A10_법인_상호명 : corpFmnmNm */
    public static final String ATTR_CORPFMNMNM = "corpFmnmNm";

    /** set A11_담당자부서 : pernChrgDeptNm */
    public static final String ATTR_PERNCHRGDEPTNM = "pernChrgDeptNm";

    /** set A12_담당자성명 : pernChrgNm */
    public static final String ATTR_PERNCHRGNM = "pernChrgNm";

    /** set A13_담당자전화번호 : pernChrgPhnNum */
    public static final String ATTR_PERNCHRGPHNNUM = "pernChrgPhnNum";

    /** set A15_사용한글코드 : useHanCd */
    public static final String ATTR_USEHANCD = "useHanCd";

    /** set B16_제출대상기간코드 : sumtTgtPridCd */
    public static final String ATTR_SUMTTGTPRIDCD = "sumtTgtPridCd";

    /** set 법인번호 : corpNum */
    public static final String ATTR_CORPNUM = "corpNum";

    /** set 소득신고의무자우편번호 : incmPost */
    public static final String ATTR_INCMPOST = "incmPost";

    /** set 소득신고의무자기본주소 : incmAddr */
    public static final String ATTR_INCMADDR = "incmAddr";

    /** set 소득신고의무자상세주소 : incmAdtl */
    public static final String ATTR_INCMADTL = "incmAdtl";

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

    
    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";
    
    /** set 연말정산구분코드 : clutSeptNm */
    public static final String ATTR_CLUTSEPTNM = "clutSeptNm";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 대표자성명 : reprName */
    public static final String ATTR_REPRNAME = "reprName";
    
    /** set 주민등록번호 : resuNumb */
    public static final String ATTR_RESUNUMB = "resuNumb";
    
    

    /** set C171_사업자단위과세자여부 : yetaC171 */
    public static final String ATTR_YETAC171 = "yetaC171";

    /** set C172_종사업장일련번호 : yetaC172 */
    public static final String ATTR_YETAC172 = "yetaC172";

 
    
      //신고 해당 부서,사업, 원천징수 상위징수 구분 필요함. 
    
    /** 생성자 */
     public Ye161005BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161005BM(
    		 String  dpobCd 
    		, String  whdgTxRegrstDeptCd 
    		, String  hhrkWhdgRegrstDeptCd 
    		, String  txOffcCd 
    		, String  pentrSeptCd 
    		, String  txDeptyMangeNum 
    		, String  hmtxId 
    		, String  txPgmCd 
    		, String  busoprRgstnum 
    		, String  corpFmnmNm 
    		, String  pernChrgDeptNm 
    		, String  pernChrgNm 
    		, String  pernChrgPhnNum 
    		, String  useHanCd 
    		, String  sumtTgtPridCd 
    		, String  corpNum 
    		, String  incmPost 
    		, String  incmAddr 
    		, String  incmAdtl 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_WHDGTXREGRSTDEPTCD,whdgTxRegrstDeptCd);
     	values.put(ATTR_HHRKWHDGREGRSTDEPTCD,hhrkWhdgRegrstDeptCd);
     	values.put(ATTR_TXOFFCCD,txOffcCd);
     	values.put(ATTR_PENTRSEPTCD,pentrSeptCd);
     	values.put(ATTR_TXDEPTYMANGENUM,txDeptyMangeNum);
     	values.put(ATTR_HMTXID,hmtxId);
     	values.put(ATTR_TXPGMCD,txPgmCd);
     	values.put(ATTR_BUSOPRRGSTNUM,busoprRgstnum);
     	values.put(ATTR_CORPFMNMNM,corpFmnmNm);
     	values.put(ATTR_PERNCHRGDEPTNM,pernChrgDeptNm);
     	values.put(ATTR_PERNCHRGNM,pernChrgNm);
     	values.put(ATTR_PERNCHRGPHNNUM,pernChrgPhnNum);
     	values.put(ATTR_USEHANCD,useHanCd);
     	values.put(ATTR_SUMTTGTPRIDCD,sumtTgtPridCd);
     	values.put(ATTR_CORPNUM,corpNum);
     	values.put(ATTR_INCMPOST,incmPost);
     	values.put(ATTR_INCMADDR,incmAddr);
     	values.put(ATTR_INCMADTL,incmAdtl);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 원천세신고부서코드 : whdgTxRegrstDeptCd */
    public void setWhdgTxRegrstDeptCd(String  whdgTxRegrstDeptCd) { set( ATTR_WHDGTXREGRSTDEPTCD ,whdgTxRegrstDeptCd);}
    /** get 원천세신고부서코드 : whdgTxRegrstDeptCd */
    public String  getWhdgTxRegrstDeptCd() { return (String )get( ATTR_WHDGTXREGRSTDEPTCD );}
    
    /** set 원천세신고부서코드 : whdgTxRegrstDeptNm */
    public void setWhdgTxRegrstDeptNm(String  whdgTxRegrstDeptNm) { set( ATTR_WHDGTXREGRSTDEPTNM ,whdgTxRegrstDeptNm);}
    /** get 원천세신고부서코드 : whdgTxRegrstDeptNm */
    public String  getWhdgTxRegrstDeptNm() { return (String )get( ATTR_WHDGTXREGRSTDEPTNM );}
    
    /** set 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
    public void setHhrkWhdgRegrstDeptCd(String  hhrkWhdgRegrstDeptCd) { set( ATTR_HHRKWHDGREGRSTDEPTCD ,hhrkWhdgRegrstDeptCd);}
    /** get 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
    public String  getHhrkWhdgRegrstDeptCd() { return (String )get( ATTR_HHRKWHDGREGRSTDEPTCD );}

    /** set A3_세무서코드 : txOffcCd */
    public void setTxOffcCd(String  txOffcCd) { set( ATTR_TXOFFCCD ,txOffcCd);}
    /** get A3_세무서코드 : txOffcCd */
    public String  getTxOffcCd() { return (String )get( ATTR_TXOFFCCD );}

    /** set A5_제출자구분 : pentrSeptCd */
    public void setPentrSeptCd(String  pentrSeptCd) { set( ATTR_PENTRSEPTCD ,pentrSeptCd);}
    /** get A5_제출자구분 : pentrSeptCd */
    public String  getPentrSeptCd() { return (String )get( ATTR_PENTRSEPTCD );}

    /** set A6_세무대리인관리번호 : txDeptyMangeNum */
    public void setTxDeptyMangeNum(String  txDeptyMangeNum) { set( ATTR_TXDEPTYMANGENUM ,txDeptyMangeNum);}
    /** get A6_세무대리인관리번호 : txDeptyMangeNum */
    public String  getTxDeptyMangeNum() { return (String )get( ATTR_TXDEPTYMANGENUM );}

    /** set A7_홈텍스ID : hmtxId */
    public void setHmtxId(String  hmtxId) { set( ATTR_HMTXID ,hmtxId);}
    /** get A7_홈텍스ID : hmtxId */
    public String  getHmtxId() { return (String )get( ATTR_HMTXID );}

    /** set A8_세무프로그램코드 : txPgmCd */
    public void setTxPgmCd(String  txPgmCd) { set( ATTR_TXPGMCD ,txPgmCd);}
    /** get A8_세무프로그램코드 : txPgmCd */
    public String  getTxPgmCd() { return (String )get( ATTR_TXPGMCD );}

    /** set A9_사업자등록번호 : busoprRgstnum */
    public void setBusoprRgstnum(String  busoprRgstnum) { set( ATTR_BUSOPRRGSTNUM ,busoprRgstnum);}
    /** get A9_사업자등록번호 : busoprRgstnum */
    public String  getBusoprRgstnum() { return (String )get( ATTR_BUSOPRRGSTNUM );}

    /** set A10_법인_상호명 : corpFmnmNm */
    public void setCorpFmnmNm(String  corpFmnmNm) { set( ATTR_CORPFMNMNM ,corpFmnmNm);}
    /** get A10_법인_상호명 : corpFmnmNm */
    public String  getCorpFmnmNm() { return (String )get( ATTR_CORPFMNMNM );}

    /** set A11_담당자부서 : pernChrgDeptNm */
    public void setPernChrgDeptNm(String  pernChrgDeptNm) { set( ATTR_PERNCHRGDEPTNM ,pernChrgDeptNm);}
    /** get A11_담당자부서 : pernChrgDeptNm */
    public String  getPernChrgDeptNm() { return (String )get( ATTR_PERNCHRGDEPTNM );}

    /** set A12_담당자성명 : pernChrgNm */
    public void setPernChrgNm(String  pernChrgNm) { set( ATTR_PERNCHRGNM ,pernChrgNm);}
    /** get A12_담당자성명 : pernChrgNm */
    public String  getPernChrgNm() { return (String )get( ATTR_PERNCHRGNM );}

    /** set A13_담당자전화번호 : pernChrgPhnNum */
    public void setPernChrgPhnNum(String  pernChrgPhnNum) { set( ATTR_PERNCHRGPHNNUM ,pernChrgPhnNum);}
    /** get A13_담당자전화번호 : pernChrgPhnNum */
    public String  getPernChrgPhnNum() { return (String )get( ATTR_PERNCHRGPHNNUM );}

    /** set A15_사용한글코드 : useHanCd */
    public void setUseHanCd(String  useHanCd) { set( ATTR_USEHANCD ,useHanCd);}
    /** get A15_사용한글코드 : useHanCd */
    public String  getUseHanCd() { return (String )get( ATTR_USEHANCD );}

    /** set B16_제출대상기간코드 : sumtTgtPridCd */
    public void setSumtTgtPridCd(String  sumtTgtPridCd) { set( ATTR_SUMTTGTPRIDCD ,sumtTgtPridCd);}
    /** get B16_제출대상기간코드 : sumtTgtPridCd */
    public String  getSumtTgtPridCd() { return (String )get( ATTR_SUMTTGTPRIDCD );}

    /** set 법인번호 : corpNum */
    public void setCorpNum(String  corpNum) { set( ATTR_CORPNUM ,corpNum);}
    /** get 법인번호 : corpNum */
    public String  getCorpNum() { return (String )get( ATTR_CORPNUM );}

    /** set 소득신고의무자우편번호 : incmPost */
    public void setIncmPost(String  incmPost) { set( ATTR_INCMPOST ,incmPost);}
    /** get 소득신고의무자우편번호 : incmPost */
    public String  getIncmPost() { return (String )get( ATTR_INCMPOST );}

    /** set 소득신고의무자기본주소 : incmAddr */
    public void setIncmAddr(String  incmAddr) { set( ATTR_INCMADDR ,incmAddr);}
    /** get 소득신고의무자기본주소 : incmAddr */
    public String  getIncmAddr() { return (String )get( ATTR_INCMADDR );}

    /** set 소득신고의무자상세주소 : incmAdtl */
    public void setIncmAdtl(String  incmAdtl) { set( ATTR_INCMADTL ,incmAdtl);}
    /** get 소득신고의무자상세주소 : incmAdtl */
    public String  getIncmAdtl() { return (String )get( ATTR_INCMADTL );}

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

    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    /** set 연말정산구분코드 : clutSeptNm */
    public void setClutSeptNm(String  clutSeptNm) { set( ATTR_CLUTSEPTNM ,clutSeptNm);}
    /** get 연말정산구분코드 : clutSeptNm */
    public String  getClutSeptNm() { return (String )get( ATTR_CLUTSEPTNM );}
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 대표자성명 : reprName */
    public void setReprName(String  reprName) { set( ATTR_REPRNAME ,reprName);}
    /** get 대표자성명 : reprName */
    public String  getReprName() { return (String )get( ATTR_REPRNAME );}
    
    /** set 주민등록번호 : resuNumb */
    public void setResuNumb(String  resuNumb) { set( ATTR_RESUNUMB ,resuNumb);}
    /** get 주민등록번호 : resuNumb */
    public String  getResuNumb() { return (String )get( ATTR_RESUNUMB );}
    

/** set C171_사업자단위과세자여부 : yetaC171 */
public void setYetaC171(String  yetaC171) { set( ATTR_YETAC171 ,yetaC171);}
/** get C171_사업자단위과세자여부 : yetaC171 */
public String  getYetaC171() { return (String )get( ATTR_YETAC171 );}

/** set C172_종사업장일련번호 : yetaC172 */
public void setYetaC172(String  yetaC172) { set( ATTR_YETAC172 ,yetaC172);}
/** get C172_종사업장일련번호 : yetaC172 */
public String  getYetaC172() { return (String )get( ATTR_YETAC172 );}


}
