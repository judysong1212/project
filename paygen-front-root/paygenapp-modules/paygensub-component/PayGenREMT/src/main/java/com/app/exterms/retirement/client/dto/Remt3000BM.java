package com.app.exterms.retirement.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Remt3000BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public static final String ATTR_CALCSEVEPSNBLGGYRMNTH = "calcSevePsnBlggYrMnth";
    /** set 정산년월 : clutYrMnth */
    public static final String ATTR_CLUTYRMNTH = "clutYrMnth";

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public static final String ATTR_CALCSEVEPAYPSNDIVCD = "calcSevePayPsnDivCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";
    
    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";
    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";
    /** set 주민등록번호 : secRegnNum */
    public static final String ATTR_SECREGNNUM = "secRegnNum";

    /** set 영수일자 : reipDt */
    public static final String ATTR_REIPDT = "reipDt";

    /** set 마감여부 : ddlneYn */
    public static final String ATTR_DDLNEYN = "ddlneYn";

    /** set 마감일자 : ddlneDt */
    public static final String ATTR_DDLNEDT = "ddlneDt";

    /** set 퇴직정산제출일자 : calcSevePayPsnSumtDt */
    public static final String ATTR_CALCSEVEPAYPSNSUMTDT = "calcSevePayPsnSumtDt";

    /** set 대표자성명 : degtrNm */
    public static final String ATTR_DEGTRNM = "degtrNm";

  
    /** set 법인명_상호 : corpNmFmnm */
    public static final String ATTR_CORPNMFMNM = "corpNmFmnm";

    /** set 사업자등록번호 : busoprRgstnNum */
    public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_DEGTRRESNREGNNUM = "degtrResnRegnNum";

	/** 대표자주민번호원본 : degtrSecRegnNum */
	public static final String ATTR_DEGTRSECREGNNUM = "degtrSecRegnNum";
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

    /** set 징수의무자구분코드 : cllnDebrDivCd */
    public static final String ATTR_CLLNDEBRDIVCD = "cllnDebrDivCd";

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
    

    /** set 퇴직정산구분코드 : calcSevePayPsnDivNm */
    public static final String ATTR_CALCSEVEPAYPSNDIVNM = "calcSevePayPsnDivNm";
     
     
    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd"; 
     

    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";
    
    /** set 고용구분 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 직책코드 : odtyNm */
    public static final String ATTR_ODTYNM = "odtyNm";

 
    /** set 호봉등급코드 : pyspGrdeNm */
    public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

 
    /** 생성자 */
     public Remt3000BM() { super(); } 

    /** 일괄등록 처리   */
     public Remt3000BM(
    		 String  dpobCd 
    		, String  clutYrMnth 
    		, String  calcSevePayPsnDivCd 
    		, String  systemkey 
    		, String  reipDt 
    		, String  ddlneYn 
    		, String  ddlneDt 
    		, String  calcSevePayPsnSumtDt 
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
    		, String  cllnDebrDivCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_CLUTYRMNTH,clutYrMnth);
     	values.put(ATTR_CALCSEVEPAYPSNDIVCD,calcSevePayPsnDivCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_REIPDT,reipDt);
     	values.put(ATTR_DDLNEYN,ddlneYn);
     	values.put(ATTR_DDLNEDT,ddlneDt);
     	values.put(ATTR_CALCSEVEPAYPSNSUMTDT,calcSevePayPsnSumtDt);
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
     	values.put(ATTR_CLLNDEBRDIVCD,cllnDebrDivCd);
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
    
    /** set 정산년월 : clutYrMnth */
	public void setClutYrMnth(String  clutYrMnth) { set( ATTR_CLUTYRMNTH ,clutYrMnth);}
	/** get 정산년월 : clutYrMnth */
	public String  getClutYrMnth() { return (String )get( ATTR_CLUTYRMNTH );}

//    /** set 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public void setCalcSevePsnBlggYrMnth(String  calcSevePsnBlggYrMnth) { set( ATTR_CALCSEVEPSNBLGGYRMNTH ,calcSevePsnBlggYrMnth);}
//    /** get 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
//    public String  getCalcSevePsnBlggYrMnth() { return (String )get( ATTR_CALCSEVEPSNBLGGYRMNTH );}

    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public void setCalcSevePayPsnDivCd(String  calcSevePayPsnDivCd) { set( ATTR_CALCSEVEPAYPSNDIVCD ,calcSevePayPsnDivCd);}
    /** get 퇴직정산구분코드 : calcSevePayPsnDivCd */
    public String  getCalcSevePayPsnDivCd() { return (String )get( ATTR_CALCSEVEPAYPSNDIVCD );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

    /** set 영수일자 : reipDt */
    public void setReipDt(String  reipDt) { set( ATTR_REIPDT ,reipDt);}
    /** get 영수일자 : reipDt */
    public String  getReipDt() { return (String )get( ATTR_REIPDT );}

    /** set 마감여부 : ddlneYn */
    public void setDdlneYn(String  ddlneYn) { set( ATTR_DDLNEYN ,ddlneYn);}
    /** get 마감여부 : ddlneYn */
    public String  getDdlneYn() { return (String )get( ATTR_DDLNEYN );}

    /** set 마감일자 : ddlneDt */
    public void setDdlneDt(String  ddlneDt) { set( ATTR_DDLNEDT ,ddlneDt);}
    /** get 마감일자 : ddlneDt */
    public String  getDdlneDt() { return (String )get( ATTR_DDLNEDT );}

    /** set 퇴직정산제출일자 : calcSevePayPsnSumtDt */
    public void setCalcSevePayPsnSumtDt(String  calcSevePayPsnSumtDt) { set( ATTR_CALCSEVEPAYPSNSUMTDT ,calcSevePayPsnSumtDt);}
    /** get 퇴직정산제출일자 : calcSevePayPsnSumtDt */
    public String  getCalcSevePayPsnSumtDt() { return (String )get( ATTR_CALCSEVEPAYPSNSUMTDT );}

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
    /** set 주민등록번호 : secRegnNum */
    public void setSecRegnNum(String  secRegnNum) { set( ATTR_SECREGNNUM ,secRegnNum);}
    /** get 주민등록번호 : secRegnNum */
    public String  getSecRegnNum() { return (String )get( ATTR_SECREGNNUM );}
    
    /** set 주민등록번호 : degtrResnRegnNum */
    public void setDegtrResnRegnNum(String  degtrResnRegnNum) { set( ATTR_DEGTRRESNREGNNUM ,degtrResnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getDegtrResnRegnNum() { return (String )get( ATTR_DEGTRRESNREGNNUM );}

	/** set 대표자주민번호 : degtrSecRegnNum */
public void setDegtrSecRegnNum(String degtrSecRegnNum) {
	set(ATTR_DEGTRSECREGNNUM, degtrSecRegnNum);
}

/** get 대표자주민번호 : degtrSecRegnNum */
public String getDegtrSecRegnNum() {
	return (String) get(ATTR_DEGTRSECREGNNUM);
}
 
     
    
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

    /** set 징수의무자구분코드 : cllnDebrDivCd */
    public void setCllnDebrDivCd(String  cllnDebrDivCd) { set( ATTR_CLLNDEBRDIVCD ,cllnDebrDivCd);}
    /** get 징수의무자구분코드 : cllnDebrDivCd */
    public String  getCllnDebrDivCd() { return (String )get( ATTR_CLLNDEBRDIVCD );}

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


	
	/** set 퇴직정산구분 : calcSevePayPsnDivNm */
	public void setCalcSevePayPsnDivNm(String  calcSevePayPsnDivNm) { set( ATTR_CALCSEVEPAYPSNDIVNM ,calcSevePayPsnDivNm);}
	/** get 퇴직정산구분 : calcSevePayPsnDivNm */
	public String  getCalcSevePayPsnDivNm() { return (String )get( ATTR_CALCSEVEPAYPSNDIVNM );}
	
	
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
	
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
	
	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
	
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
	
	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
	 
	
	/** set 고용구분 : emymtDivNm */
	public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
	/** get 고용구분 : emymtDivNm */
	public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
	
	
	/** set 부서 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서 : deptNm  */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
	
	/** set 사업 : businNm */
	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
	/** get 사업 : businNm */
	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
	
	/** set 직종 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
	/** get 직종 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
	
	/** set 직종세 : dtilOccuClsDivNm */
	public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
	/** get 직종세 : dtilOccuClsDivNm */
	public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
	
	/** set 직책 : odtyNm */
	public void setOdtyNm(String  odtyNm) { set( ATTR_ODTYNM ,odtyNm);}
	/** get 직책 : odtyNm */
	public String  getOdtyNm() { return (String )get( ATTR_ODTYNM );}
	
	
	/** set 호봉등급 : pyspGrdeNm */
	public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
	/** get 호봉등급 : pyspGrdeNm */
	public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}



}
