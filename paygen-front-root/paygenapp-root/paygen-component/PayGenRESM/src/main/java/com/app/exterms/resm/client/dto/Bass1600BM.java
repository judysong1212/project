package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass1600BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
   
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public static final String ATTR_MANGEUNTBUSINNUM = "mangeUntBusinNum";

    /** set 관리부서_단위사업생성년도 : mangeBusinCretnYr */
    public static final String ATTR_MANGEBUSINCRETNYR = "mangeBusinCretnYr";

    /** set 관리부서_단위사업담당부서코드 : mangeBusinRepbtyDeptCd */
    public static final String ATTR_MANGEBUSINREPBTYDEPTCD = "mangeBusinRepbtyDeptCd";

    /** set 관리부서_단위사업담당자아이디 : mangeBusinPernChrgId */
    public static final String ATTR_MANGEBUSINPERNCHRGID = "mangeBusinPernChrgId";

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

    /** set 과세유형구분코드 : txtnFrmDivCd */
    public static final String ATTR_TXTNFRMDIVCD = "txtnFrmDivCd";

    /** set 단위사업장코드 : untDpobCd */
    public static final String ATTR_UNTDPOBCD = "untDpobCd";

    /** set 사대보험사업장기호통합코드 : socInsrSymInttnCd */
    public static final String ATTR_SOCINSRSYMINTTNCD = "socInsrSymInttnCd";

    /** set 단위사업회계코드 : untBusinAccCd */
    public static final String ATTR_UNTBUSINACCCD = "untBusinAccCd";

    /** set 관리부서_단위사업시작일자 : mangeUntBusinBgnnDt */
    public static final String ATTR_MANGEUNTBUSINBGNNDT = "mangeUntBusinBgnnDt";

    /** set 관리부서_단위사업종료일자 : mangeUntBusinEndDt */
    public static final String ATTR_MANGEUNTBUSINENDDT = "mangeUntBusinEndDt";

    /** set 관리부서_단위사업사용여부 : mangeUntBusinYn */
    public static final String ATTR_MANGEUNTBUSINYN = "mangeUntBusinYn";

    /** set 관리부서_단위사업비고내용 : mangeUntBusinCtnt */
    public static final String ATTR_MANGEUNTBUSINCTNT = "mangeUntBusinCtnt";

    /** set 사업_세부직종공통코드 : busnDtlTypOccuCd */
    public static final String ATTR_BUSNDTLTYPOCCUCD = "busnDtlTypOccuCd";

    /** set 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public static final String ATTR_BUSNSMLRDTLTYPOCCUCD = "busnSmlrDtlTypOccuCd";

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
     public Bass1600BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass1600BM(
    		 String  dpobCd 
    		, String  mangeUntBusinNum 
    		, String  mangeBusinCretnYr 
    		, String  mangeBusinRepbtyDeptCd 
    		, String  mangeBusinPernChrgId 
    		, String  dtilOcclsApptnUcstCd 
    		, String  txtnFrmDivCd 
    		, String  untDpobCd 
    		, String  socInsrSymInttnCd 
    		, String  untBusinAccCd 
    		, String  mangeUntBusinBgnnDt 
    		, String  mangeUntBusinEndDt 
    		, String  mangeUntBusinYn 
    		, String  mangeUntBusinCtnt 
    		, String  busnDtlTypOccuCd 
    		, String  busnSmlrDtlTypOccuCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_MANGEUNTBUSINNUM,mangeUntBusinNum);
     	values.put(ATTR_MANGEBUSINCRETNYR,mangeBusinCretnYr);
     	values.put(ATTR_MANGEBUSINREPBTYDEPTCD,mangeBusinRepbtyDeptCd);
     	values.put(ATTR_MANGEBUSINPERNCHRGID,mangeBusinPernChrgId);
     	values.put(ATTR_DTILOCCLSAPPTNUCSTCD,dtilOcclsApptnUcstCd);
     	values.put(ATTR_TXTNFRMDIVCD,txtnFrmDivCd);
     	values.put(ATTR_UNTDPOBCD,untDpobCd);
     	values.put(ATTR_SOCINSRSYMINTTNCD,socInsrSymInttnCd);
     	values.put(ATTR_UNTBUSINACCCD,untBusinAccCd);
     	values.put(ATTR_MANGEUNTBUSINBGNNDT,mangeUntBusinBgnnDt);
     	values.put(ATTR_MANGEUNTBUSINENDDT,mangeUntBusinEndDt);
     	values.put(ATTR_MANGEUNTBUSINYN,mangeUntBusinYn);
     	values.put(ATTR_MANGEUNTBUSINCTNT,mangeUntBusinCtnt);
     	values.put(ATTR_BUSNDTLTYPOCCUCD,busnDtlTypOccuCd);
     	values.put(ATTR_BUSNSMLRDTLTYPOCCUCD,busnSmlrDtlTypOccuCd);
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

    /** set 관리부서_단위사업번호 : mangeUntBusinNum */
    public void setMangeUntBusinNum(String  mangeUntBusinNum) { set( ATTR_MANGEUNTBUSINNUM ,mangeUntBusinNum);}
    /** get 관리부서_단위사업번호 : mangeUntBusinNum */
    public String  getMangeUntBusinNum() { return (String )get( ATTR_MANGEUNTBUSINNUM );}

    /** set 관리부서_단위사업생성년도 : mangeBusinCretnYr */
    public void setMangeBusinCretnYr(String  mangeBusinCretnYr) { set( ATTR_MANGEBUSINCRETNYR ,mangeBusinCretnYr);}
    /** get 관리부서_단위사업생성년도 : mangeBusinCretnYr */
    public String  getMangeBusinCretnYr() { return (String )get( ATTR_MANGEBUSINCRETNYR );}

    /** set 관리부서_단위사업담당부서코드 : mangeBusinRepbtyDeptCd */
    public void setMangeBusinRepbtyDeptCd(String  mangeBusinRepbtyDeptCd) { set( ATTR_MANGEBUSINREPBTYDEPTCD ,mangeBusinRepbtyDeptCd);}
    /** get 관리부서_단위사업담당부서코드 : mangeBusinRepbtyDeptCd */
    public String  getMangeBusinRepbtyDeptCd() { return (String )get( ATTR_MANGEBUSINREPBTYDEPTCD );}

    /** set 관리부서_단위사업담당자아이디 : mangeBusinPernChrgId */
    public void setMangeBusinPernChrgId(String  mangeBusinPernChrgId) { set( ATTR_MANGEBUSINPERNCHRGID ,mangeBusinPernChrgId);}
    /** get 관리부서_단위사업담당자아이디 : mangeBusinPernChrgId */
    public String  getMangeBusinPernChrgId() { return (String )get( ATTR_MANGEBUSINPERNCHRGID );}

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
    /** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

    /** set 과세유형구분코드 : txtnFrmDivCd */
    public void setTxtnFrmDivCd(String  txtnFrmDivCd) { set( ATTR_TXTNFRMDIVCD ,txtnFrmDivCd);}
    /** get 과세유형구분코드 : txtnFrmDivCd */
    public String  getTxtnFrmDivCd() { return (String )get( ATTR_TXTNFRMDIVCD );}

    /** set 단위사업장코드 : untDpobCd */
    public void setUntDpobCd(String  untDpobCd) { set( ATTR_UNTDPOBCD ,untDpobCd);}
    /** get 단위사업장코드 : untDpobCd */
    public String  getUntDpobCd() { return (String )get( ATTR_UNTDPOBCD );}

    /** set 사대보험사업장기호통합코드 : socInsrSymInttnCd */
    public void setSocInsrSymInttnCd(String  socInsrSymInttnCd) { set( ATTR_SOCINSRSYMINTTNCD ,socInsrSymInttnCd);}
    /** get 사대보험사업장기호통합코드 : socInsrSymInttnCd */
    public String  getSocInsrSymInttnCd() { return (String )get( ATTR_SOCINSRSYMINTTNCD );}

    /** set 단위사업회계코드 : untBusinAccCd */
    public void setUntBusinAccCd(String  untBusinAccCd) { set( ATTR_UNTBUSINACCCD ,untBusinAccCd);}
    /** get 단위사업회계코드 : untBusinAccCd */
    public String  getUntBusinAccCd() { return (String )get( ATTR_UNTBUSINACCCD );}

    /** set 관리부서_단위사업시작일자 : mangeUntBusinBgnnDt */
    public void setMangeUntBusinBgnnDt(String  mangeUntBusinBgnnDt) { set( ATTR_MANGEUNTBUSINBGNNDT ,mangeUntBusinBgnnDt);}
    /** get 관리부서_단위사업시작일자 : mangeUntBusinBgnnDt */
    public String  getMangeUntBusinBgnnDt() { return (String )get( ATTR_MANGEUNTBUSINBGNNDT );}

    /** set 관리부서_단위사업종료일자 : mangeUntBusinEndDt */
    public void setMangeUntBusinEndDt(String  mangeUntBusinEndDt) { set( ATTR_MANGEUNTBUSINENDDT ,mangeUntBusinEndDt);}
    /** get 관리부서_단위사업종료일자 : mangeUntBusinEndDt */
    public String  getMangeUntBusinEndDt() { return (String )get( ATTR_MANGEUNTBUSINENDDT );}

    /** set 관리부서_단위사업사용여부 : mangeUntBusinYn */
    public void setMangeUntBusinYn(String  mangeUntBusinYn) { set( ATTR_MANGEUNTBUSINYN ,mangeUntBusinYn);}
    /** get 관리부서_단위사업사용여부 : mangeUntBusinYn */
    public String  getMangeUntBusinYn() { return (String )get( ATTR_MANGEUNTBUSINYN );}

    /** set 관리부서_단위사업비고내용 : mangeUntBusinCtnt */
    public void setMangeUntBusinCtnt(String  mangeUntBusinCtnt) { set( ATTR_MANGEUNTBUSINCTNT ,mangeUntBusinCtnt);}
    /** get 관리부서_단위사업비고내용 : mangeUntBusinCtnt */
    public String  getMangeUntBusinCtnt() { return (String )get( ATTR_MANGEUNTBUSINCTNT );}

    /** set 사업_세부직종공통코드 : busnDtlTypOccuCd */
    public void setBusnDtlTypOccuCd(String  busnDtlTypOccuCd) { set( ATTR_BUSNDTLTYPOCCUCD ,busnDtlTypOccuCd);}
    /** get 사업_세부직종공통코드 : busnDtlTypOccuCd */
    public String  getBusnDtlTypOccuCd() { return (String )get( ATTR_BUSNDTLTYPOCCUCD );}

    /** set 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public void setBusnSmlrDtlTypOccuCd(String  busnSmlrDtlTypOccuCd) { set( ATTR_BUSNSMLRDTLTYPOCCUCD ,busnSmlrDtlTypOccuCd);}
    /** get 사업_유사세부직종코드 : busnSmlrDtlTypOccuCd */
    public String  getBusnSmlrDtlTypOccuCd() { return (String )get( ATTR_BUSNSMLRDTLTYPOCCUCD );}

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
