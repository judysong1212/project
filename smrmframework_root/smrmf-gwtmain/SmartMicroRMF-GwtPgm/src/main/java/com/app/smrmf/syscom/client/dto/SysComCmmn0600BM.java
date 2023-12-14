package com.app.smrmf.syscom.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Cmmn0320BM.java
 * @Description : Cmmn0320  BaseModel class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysComCmmn0600BM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    
    /** set 법정동코드 : cutdogCd */
    public static final String ATTR_CUTDOGCD = "cutdogCd";

    /** set 도로명시도 : roadNmCtapv */
    public static final String ATTR_ROADNMCTAPV = "roadNmCtapv";

    /** set 도로명시군구 : roadNmCtatgu */
    public static final String ATTR_ROADNMCTATGU = "roadNmCtatgu";

    /** set 도로명읍면 : roadNmTat */
    public static final String ATTR_ROADNMTAT = "roadNmTat";

    /** set 도로명리 : roadNmLi */
    public static final String ATTR_ROADNMLI = "roadNmLi";

    /** set 도로명산구분 : roadNmSan */
    public static final String ATTR_ROADNMSAN = "roadNmSan";

    /** set 도로명지번본번 : roadNmLtnumBobn */
    public static final String ATTR_ROADNMLTNUMBOBN = "roadNmLtnumBobn";

    /** set 도로명지번부번 : roadNmLtnumBubn */
    public static final String ATTR_ROADNMLTNUMBUBN = "roadNmLtnumBubn";

    /** set 도로명코드 : roadNmCd */
    public static final String ATTR_ROADNMCD = "roadNmCd";

    /** set 도로명 : roadNm */
    public static final String ATTR_ROADNM = "roadNm";

    /** set 도로명지하구분 : roadNmUngr */
    public static final String ATTR_ROADNMUNGR = "roadNmUngr";

    /** set 건물번호본번 : buildNumBobn */
    public static final String ATTR_BUILDNUMBOBN = "buildNumBobn";

    /** set 건물번호부본 : buildNumBubn */
    public static final String ATTR_BUILDNUMBUBN = "buildNumBubn";

    /** set 건물명 : buildNm */
    public static final String ATTR_BUILDNM = "buildNm";

    /** set 상세건물명 : dtlPatrBuildNm */
    public static final String ATTR_DTLPATRBUILDNM = "dtlPatrBuildNm";

    /** set 건물관리번호 : buildMangeNum */
    public static final String ATTR_BUILDMANGENUM = "buildMangeNum";

    /** set 읍면동일련번호 : tatdSeilNum */
    public static final String ATTR_TATDSEILNUM = "tatdSeilNum";

    /** set 행정동코드 : adsttDongCd */
    public static final String ATTR_ADSTTDONGCD = "adsttDongCd";

    /** set 행정동명 : adsttDongNm */
    public static final String ATTR_ADSTTDONGNM = "adsttDongNm";

    /** set 우편번호 : zpcd */
    public static final String ATTR_ZPCD = "zpcd";

    /** set 우편번호일련번호 : zpcdSeilNum */
    public static final String ATTR_ZPCDSEILNUM = "zpcdSeilNum";

    /** set 다량배달처명 : lotDsttnNm */
    public static final String ATTR_LOTDSTTNNM = "lotDsttnNm";

    /** set 이동사유코드 : mvReasCd */
    public static final String ATTR_MVREASCD = "mvReasCd";

    /** set 변경일자 : chngDt */
    public static final String ATTR_CHNGDT = "chngDt";

    /** set 변경전도로명주소 : chngBfrRoadNmAddr */
    public static final String ATTR_CHNGBFRROADNMADDR = "chngBfrRoadNmAddr";

    /** set 시군구용건물명 : ctatguBuildNm */
    public static final String ATTR_CTATGUBUILDNM = "ctatguBuildNm";

    /** set 공동주택구분 : jonHus */
    public static final String ATTR_JONHUS = "jonHus";

    /** set 기초구역번호 : baseArNum */
    public static final String ATTR_BASEARNUM = "baseArNum";

    /** set 상세주소여부 : dtlAddrYn */
    public static final String ATTR_DTLADDRYN = "dtlAddrYn";

    /** set 비고1 : postCtnt01 */
    public static final String ATTR_POSTCTNT01 = "postCtnt01";

    /** set 비고2 : postCtnt02 */
    public static final String ATTR_POSTCTNT02 = "postCtnt02";

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
    
   
    
    /** 기본주소뷰 */
    public static final String ATTR_FNDTNADDRVIEW = "fnDtnAddrView";
    
    
    /** 기본주소 */
    public static final String ATTR_FNDTNADDR = "fnDtnAddr";
    
    /** 상세주소 */
    public static final String ATTR_DTLPATRADDR = "dtlPatrAddr"; 
    

    /** 생성자 */
     public SysComCmmn0600BM() { super(); } 

    /** 일괄등록 처리   */
     public SysComCmmn0600BM( 
            String  zpcd 
            , String  zpcdSeilNum 
            , String  buildMangeNum 
            , String  cutdogCd 
            , String  roadNmCtapv 
            , String  roadNmCtatgu 
            , String  roadNmTat 
            , String  roadNmLi 
            , String  roadNmSan 
            , Long  roadNmLtnumBobn 
            , Long  roadNmLtnumBubn 
            , String  roadNmCd 
            , String  roadNm 
            , String  roadNmUngr 
            , String  buildNumBobn 
            , String  buildNumBubn 
            , String  buildNm 
            , String  dtlPatrBuildNm 
            , String  tatdSeilNum 
            , String  adsttDongCd 
            , String  adsttDongNm 
            , String  lotDsttnNm 
            , String  mvReasCd 
            , String  chngDt 
            , String  chngBfrRoadNmAddr 
            , String  ctatguBuildNm 
            , String  jonHus 
            , String  kybdr 
            , String  inptDt 
            , String  inptAddr 
            , String  ismt 
            , String  revnDt 
            , String  revnAddr ) {  
        values.put(ATTR_ZPCD,zpcd);
        values.put(ATTR_ZPCDSEILNUM,zpcdSeilNum);
        values.put(ATTR_BUILDMANGENUM,buildMangeNum);
        values.put(ATTR_CUTDOGCD,cutdogCd);
        values.put(ATTR_ROADNMCTAPV,roadNmCtapv);
        values.put(ATTR_ROADNMCTATGU,roadNmCtatgu);
        values.put(ATTR_ROADNMTAT,roadNmTat);
        values.put(ATTR_ROADNMLI,roadNmLi);
        values.put(ATTR_ROADNMSAN,roadNmSan);
        values.put(ATTR_ROADNMLTNUMBOBN,roadNmLtnumBobn);
        values.put(ATTR_ROADNMLTNUMBUBN,roadNmLtnumBubn);
        values.put(ATTR_ROADNMCD,roadNmCd);
        values.put(ATTR_ROADNM,roadNm);
        values.put(ATTR_ROADNMUNGR,roadNmUngr);
        values.put(ATTR_BUILDNUMBOBN,buildNumBobn);
        values.put(ATTR_BUILDNUMBUBN,buildNumBubn);
        values.put(ATTR_BUILDNM,buildNm);
        values.put(ATTR_DTLPATRBUILDNM,dtlPatrBuildNm);
        values.put(ATTR_TATDSEILNUM,tatdSeilNum);
        values.put(ATTR_ADSTTDONGCD,adsttDongCd);
        values.put(ATTR_ADSTTDONGNM,adsttDongNm);
        values.put(ATTR_LOTDSTTNNM,lotDsttnNm);
        values.put(ATTR_MVREASCD,mvReasCd);
        values.put(ATTR_CHNGDT,chngDt);
        values.put(ATTR_CHNGBFRROADNMADDR,chngBfrRoadNmAddr);
        values.put(ATTR_CTATGUBUILDNM,ctatguBuildNm);
        values.put(ATTR_JONHUS,jonHus);
        values.put(ATTR_KYBDR,kybdr);
        values.put(ATTR_INPTDT,inptDt);
        values.put(ATTR_INPTADDR,inptAddr);
        values.put(ATTR_ISMT,ismt);
        values.put(ATTR_REVNDT,revnDt);
        values.put(ATTR_REVNADDR,revnAddr); } 
 
     

/** set 법정동코드 : cutdogCd */
public void setCutdogCd(String  cutdogCd) { set( ATTR_CUTDOGCD ,cutdogCd);}
/** get 법정동코드 : cutdogCd */
public String  getCutdogCd() { return (String )get( ATTR_CUTDOGCD );}

/** set 도로명시도 : roadNmCtapv */
public void setRoadNmCtapv(String  roadNmCtapv) { set( ATTR_ROADNMCTAPV ,roadNmCtapv);}
/** get 도로명시도 : roadNmCtapv */
public String  getRoadNmCtapv() { return (String )get( ATTR_ROADNMCTAPV );}

/** set 도로명시군구 : roadNmCtatgu */
public void setRoadNmCtatgu(String  roadNmCtatgu) { set( ATTR_ROADNMCTATGU ,roadNmCtatgu);}
/** get 도로명시군구 : roadNmCtatgu */
public String  getRoadNmCtatgu() { return (String )get( ATTR_ROADNMCTATGU );}

/** set 도로명읍면 : roadNmTat */
public void setRoadNmTat(String  roadNmTat) { set( ATTR_ROADNMTAT ,roadNmTat);}
/** get 도로명읍면 : roadNmTat */
public String  getRoadNmTat() { return (String )get( ATTR_ROADNMTAT );}

/** set 도로명리 : roadNmLi */
public void setRoadNmLi(String  roadNmLi) { set( ATTR_ROADNMLI ,roadNmLi);}
/** get 도로명리 : roadNmLi */
public String  getRoadNmLi() { return (String )get( ATTR_ROADNMLI );}

/** set 도로명산구분 : roadNmSan */
public void setRoadNmSan(String  roadNmSan) { set( ATTR_ROADNMSAN ,roadNmSan);}
/** get 도로명산구분 : roadNmSan */
public String  getRoadNmSan() { return (String )get( ATTR_ROADNMSAN );}

/** set 도로명지번본번 : roadNmLtnumBobn */
public void setRoadNmLtnumBobn(Long  roadNmLtnumBobn) { set( ATTR_ROADNMLTNUMBOBN ,roadNmLtnumBobn);}
/** get 도로명지번본번 : roadNmLtnumBobn */
public Long  getRoadNmLtnumBobn() { return (Long )get( ATTR_ROADNMLTNUMBOBN );}

/** set 도로명지번부번 : roadNmLtnumBubn */
public void setRoadNmLtnumBubn(Long  roadNmLtnumBubn) { set( ATTR_ROADNMLTNUMBUBN ,roadNmLtnumBubn);}
/** get 도로명지번부번 : roadNmLtnumBubn */
public Long  getRoadNmLtnumBubn() { return (Long )get( ATTR_ROADNMLTNUMBUBN );}

/** set 도로명코드 : roadNmCd */
public void setRoadNmCd(String  roadNmCd) { set( ATTR_ROADNMCD ,roadNmCd);}
/** get 도로명코드 : roadNmCd */
public String  getRoadNmCd() { return (String )get( ATTR_ROADNMCD );}

/** set 도로명 : roadNm */
public void setRoadNm(String  roadNm) { set( ATTR_ROADNM ,roadNm);}
/** get 도로명 : roadNm */
public String  getRoadNm() { return (String )get( ATTR_ROADNM );}

/** set 도로명지하구분 : roadNmUngr */
public void setRoadNmUngr(String  roadNmUngr) { set( ATTR_ROADNMUNGR ,roadNmUngr);}
/** get 도로명지하구분 : roadNmUngr */
public String  getRoadNmUngr() { return (String )get( ATTR_ROADNMUNGR );}

/** set 건물번호본번 : buildNumBobn */
public void setBuildNumBobn(String  buildNumBobn) { set( ATTR_BUILDNUMBOBN ,buildNumBobn);}
/** get 건물번호본번 : buildNumBobn */
public String  getBuildNumBobn() { return (String )get( ATTR_BUILDNUMBOBN );}

/** set 건물번호부본 : buildNumBubn */
public void setBuildNumBubn(String  buildNumBubn) { set( ATTR_BUILDNUMBUBN ,buildNumBubn);}
/** get 건물번호부본 : buildNumBubn */
public String  getBuildNumBubn() { return (String )get( ATTR_BUILDNUMBUBN );}

/** set 건물명 : buildNm */
public void setBuildNm(String  buildNm) { set( ATTR_BUILDNM ,buildNm);}
/** get 건물명 : buildNm */
public String  getBuildNm() { return (String )get( ATTR_BUILDNM );}

/** set 상세건물명 : dtlPatrBuildNm */
public void setDtlPatrBuildNm(String  dtlPatrBuildNm) { set( ATTR_DTLPATRBUILDNM ,dtlPatrBuildNm);}
/** get 상세건물명 : dtlPatrBuildNm */
public String  getDtlPatrBuildNm() { return (String )get( ATTR_DTLPATRBUILDNM );}

/** set 건물관리번호 : buildMangeNum */
public void setBuildMangeNum(String  buildMangeNum) { set( ATTR_BUILDMANGENUM ,buildMangeNum);}
/** get 건물관리번호 : buildMangeNum */
public String  getBuildMangeNum() { return (String )get( ATTR_BUILDMANGENUM );}

/** set 읍면동일련번호 : tatdSeilNum */
public void setTatdSeilNum(String  tatdSeilNum) { set( ATTR_TATDSEILNUM ,tatdSeilNum);}
/** get 읍면동일련번호 : tatdSeilNum */
public String  getTatdSeilNum() { return (String )get( ATTR_TATDSEILNUM );}

/** set 행정동코드 : adsttDongCd */
public void setAdsttDongCd(String  adsttDongCd) { set( ATTR_ADSTTDONGCD ,adsttDongCd);}
/** get 행정동코드 : adsttDongCd */
public String  getAdsttDongCd() { return (String )get( ATTR_ADSTTDONGCD );}

/** set 행정동명 : adsttDongNm */
public void setAdsttDongNm(String  adsttDongNm) { set( ATTR_ADSTTDONGNM ,adsttDongNm);}
/** get 행정동명 : adsttDongNm */
public String  getAdsttDongNm() { return (String )get( ATTR_ADSTTDONGNM );}

/** set 우편번호 : zpcd */
public void setZpcd(String  zpcd) { set( ATTR_ZPCD ,zpcd);}
/** get 우편번호 : zpcd */
public String  getZpcd() { return (String )get( ATTR_ZPCD );}

/** set 우편번호일련번호 : zpcdSeilNum */
public void setZpcdSeilNum(String  zpcdSeilNum) { set( ATTR_ZPCDSEILNUM ,zpcdSeilNum);}
/** get 우편번호일련번호 : zpcdSeilNum */
public String  getZpcdSeilNum() { return (String )get( ATTR_ZPCDSEILNUM );}

/** set 다량배달처명 : lotDsttnNm */
public void setLotDsttnNm(String  lotDsttnNm) { set( ATTR_LOTDSTTNNM ,lotDsttnNm);}
/** get 다량배달처명 : lotDsttnNm */
public String  getLotDsttnNm() { return (String )get( ATTR_LOTDSTTNNM );}

/** set 이동사유코드 : mvReasCd */
public void setMvReasCd(String  mvReasCd) { set( ATTR_MVREASCD ,mvReasCd);}
/** get 이동사유코드 : mvReasCd */
public String  getMvReasCd() { return (String )get( ATTR_MVREASCD );}

/** set 변경일자 : chngDt */
public void setChngDt(String  chngDt) { set( ATTR_CHNGDT ,chngDt);}
/** get 변경일자 : chngDt */
public String  getChngDt() { return (String )get( ATTR_CHNGDT );}

/** set 변경전도로명주소 : chngBfrRoadNmAddr */
public void setChngBfrRoadNmAddr(String  chngBfrRoadNmAddr) { set( ATTR_CHNGBFRROADNMADDR ,chngBfrRoadNmAddr);}
/** get 변경전도로명주소 : chngBfrRoadNmAddr */
public String  getChngBfrRoadNmAddr() { return (String )get( ATTR_CHNGBFRROADNMADDR );}

/** set 시군구용건물명 : ctatguBuildNm */
public void setCtatguBuildNm(String  ctatguBuildNm) { set( ATTR_CTATGUBUILDNM ,ctatguBuildNm);}
/** get 시군구용건물명 : ctatguBuildNm */
public String  getCtatguBuildNm() { return (String )get( ATTR_CTATGUBUILDNM );}

/** set 공동주택구분 : jonHus */
public void setJonHus(String  jonHus) { set( ATTR_JONHUS ,jonHus);}
/** get 공동주택구분 : jonHus */
public String  getJonHus() { return (String )get( ATTR_JONHUS );}

/** set 기초구역번호 : baseArNum */
public void setBaseArNum(String  baseArNum) { set( ATTR_BASEARNUM ,baseArNum);}
/** get 기초구역번호 : baseArNum */
public String  getBaseArNum() { return (String )get( ATTR_BASEARNUM );}

/** set 상세주소여부 : dtlAddrYn */
public void setDtlAddrYn(String  dtlAddrYn) { set( ATTR_DTLADDRYN ,dtlAddrYn);}
/** get 상세주소여부 : dtlAddrYn */
public String  getDtlAddrYn() { return (String )get( ATTR_DTLADDRYN );}

/** set 비고1 : postCtnt01 */
public void setPostCtnt01(String  postCtnt01) { set( ATTR_POSTCTNT01 ,postCtnt01);}
/** get 비고1 : postCtnt01 */
public String  getPostCtnt01() { return (String )get( ATTR_POSTCTNT01 );}

/** set 비고2 : postCtnt02 */
public void setPostCtnt02(String  postCtnt02) { set( ATTR_POSTCTNT02 ,postCtnt02);}
/** get 비고2 : postCtnt02 */
public String  getPostCtnt02() { return (String )get( ATTR_POSTCTNT02 );}

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
    
    
}
