package com.app.exterms.yearendtax.client.dto.yeta2017;



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
public class Pyyt0304BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 지급년월 : pyytYrMnth */
    public static final String ATTR_PYYTYRMNTH = "pyytYrMnth";

    /** set 급여관리부서코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 한글성명 : hanNm */
    public static final String ATTR_HANNM = "hanNm";

    /** set 주민등록번호 : resnRegnNum */
    public static final String ATTR_RESNREGNNUM = "resnRegnNum";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    /** set 부서코드 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINNM = "businNm";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";
    
    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";
    
    /** set 근속년수코드 : logSvcYrNumNm */
    public static final String ATTR_LOGSVCYRNUMNM = "logSvcYrNumNm";

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";
    
    /** set 근속월수코드 : logSvcMnthIcmNm */
    public static final String ATTR_LOGSVCMNTHICMNM = "logSvcMnthIcmNm";

    /** set 최초고용일자 : frstEmymtDt */
    public static final String ATTR_FRSTEMYMTDT = "frstEmymtDt";

    /** set 고용시작일자 : emymtBgnnDt */
    public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

    /** set 고용종료일자 : emymtEndDt */
    public static final String ATTR_EMYMTENDDT = "emymtEndDt";

    /** set 재직구분코드 : hdofcDivCd */
    public static final String ATTR_HDOFCDIVCD = "hdofcDivCd";

    /** set 퇴직일자 : retryDt */
    public static final String ATTR_RETRYDT = "retryDt";

    /** set 지급총액 : pyytPymtTotAmnt */
    public static final String ATTR_PYYTPYMTTOTAMNT = "pyytPymtTotAmnt";

    /** set 수당총액 : pyytExtpyTotAmnt */
    public static final String ATTR_PYYTEXTPYTOTAMNT = "pyytExtpyTotAmnt";

    /** set 과세총액 : pyytTxtnTotAmnt */
    public static final String ATTR_PYYTTXTNTOTAMNT = "pyytTxtnTotAmnt";

    /** set 비과세총액 : pyytFreeDtyTotAmnt */
    public static final String ATTR_PYYTFREEDTYTOTAMNT = "pyytFreeDtyTotAmnt";

    /** set 공제총액 : pyytDducTotAmnt */
    public static final String ATTR_PYYTDDUCTOTAMNT = "pyytDducTotAmnt";

    /** set 세금총액 : pyytTxTotAmnt */
    public static final String ATTR_PYYTTXTOTAMNT = "pyytTxTotAmnt";

    /** set 퇴직금지급여부 : pyytSevePayPymtYn */
    public static final String ATTR_PYYTSEVEPAYPYMTYN = "pyytSevePayPymtYn";

    /** set 차인지급액 : pyytPernPymtSum */
    public static final String ATTR_PYYTPERNPYMTSUM = "pyytPernPymtSum";

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
    
    /** column 기본급 : pyytB10100Sum */
    public static final String ATTR_PYYTB10100SUM = "pyytB10100Sum";
    
    /** column 소득세 : pyytT10100Sum */
    public static final String ATTR_PYYTT10100SUM = "pyytT10100Sum";
      
    /** column 주민세  : pyytT20100Sum */
    public static final String ATTR_PYYTT20100SUM = "pyytT20100Sum";
    
    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";

    /** 생성자 */
     public Pyyt0304BM() { super(); } 

    /** 일괄등록 처리   */
     public Pyyt0304BM(
    		 String  systemkey 
    		, String  dpobCd 
    		, String  pyytYrMnth 
    		, String  payrMangDeptCd 
    		, String  emymtDivCd 
    		, String  hanNm 
    		, String  resnRegnNum 
    		, String  deptCd 
    		, String  businCd 
    		, String  typOccuCd 
    		, String  dtilOccuInttnCd 
    		, String  odtyCd 
    		, String  pyspCd 
    		, String  logSvcYrNumCd 
    		, String  logSvcMnthIcmCd 
    		, String  frstEmymtDt 
    		, String  emymtBgnnDt 
    		, String  emymtEndDt 
    		, String  hdofcDivCd 
    		, String  retryDt 
    		, Long  pyytPymtTotAmnt 
    		, Long  pyytExtpyTotAmnt 
    		, Long  pyytTxtnTotAmnt 
    		, Long  pyytFreeDtyTotAmnt 
    		, Long  pyytDducTotAmnt 
    		, Long  pyytTxTotAmnt 
    		, String  pyytSevePayPymtYn 
    		, Long  pyytPernPymtSum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_PYYTYRMNTH,pyytYrMnth);
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_HANNM,hanNm);
     	values.put(ATTR_RESNREGNNUM,resnRegnNum);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_PYSPCD,pyspCd);
     	values.put(ATTR_LOGSVCYRNUMCD,logSvcYrNumCd);
     	values.put(ATTR_LOGSVCMNTHICMCD,logSvcMnthIcmCd);
     	values.put(ATTR_FRSTEMYMTDT,frstEmymtDt);
     	values.put(ATTR_EMYMTBGNNDT,emymtBgnnDt);
     	values.put(ATTR_EMYMTENDDT,emymtEndDt);
     	values.put(ATTR_HDOFCDIVCD,hdofcDivCd);
     	values.put(ATTR_RETRYDT,retryDt);
     	values.put(ATTR_PYYTPYMTTOTAMNT,pyytPymtTotAmnt);
     	values.put(ATTR_PYYTEXTPYTOTAMNT,pyytExtpyTotAmnt);
     	values.put(ATTR_PYYTTXTNTOTAMNT,pyytTxtnTotAmnt);
     	values.put(ATTR_PYYTFREEDTYTOTAMNT,pyytFreeDtyTotAmnt);
     	values.put(ATTR_PYYTDDUCTOTAMNT,pyytDducTotAmnt);
     	values.put(ATTR_PYYTTXTOTAMNT,pyytTxTotAmnt);
     	values.put(ATTR_PYYTSEVEPAYPYMTYN,pyytSevePayPymtYn);
     	values.put(ATTR_PYYTPERNPYMTSUM,pyytPernPymtSum);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 지급년월 : pyytYrMnth */
    public void setPyytYrMnth(String  pyytYrMnth) { set( ATTR_PYYTYRMNTH ,pyytYrMnth);}
    /** get 지급년월 : pyytYrMnth */
    public String  getPyytYrMnth() { return (String )get( ATTR_PYYTYRMNTH );}
    /** set 급여관리부서코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 급여관리부서코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
    /** set 한글성명 : hanNm */
    public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
    /** get 한글성명 : hanNm */
    public String  getHanNm() { return (String )get( ATTR_HANNM );}
    /** set 주민등록번호 : resnRegnNum */
    public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
    /** get 주민등록번호 : resnRegnNum */
    public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}
    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
    /** set 부서코드 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서코드 : deptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
    
    /** set 사업코드 : businCd */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업코드 : businCd */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
    
    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
    
    /** set 직종코드 : typOccuCd */
    public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
    
    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}
    /** set 호봉코드 : pyspCd */
    public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
    /** get 호봉코드 : pyspCd */
    public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}
    /** set 근속년수코드 : logSvcYrNumCd */
    public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( ATTR_LOGSVCYRNUMCD ,logSvcYrNumCd);}
    /** get 근속년수코드 : logSvcYrNumCd */
    public String  getLogSvcYrNumCd() { return (String )get( ATTR_LOGSVCYRNUMCD );}
    
    /** set 근속년수코드 : logSvcYrNumNm */
    public void setLogSvcYrNumNm(String  logSvcYrNumNm) { set( ATTR_LOGSVCYRNUMNM ,logSvcYrNumNm);}
    /** get 근속년수코드 : logSvcYrNumNm */
    public String  getLogSvcYrNumNm() { return (String )get( ATTR_LOGSVCYRNUMNM );}   
    /** set 근속월수코드 : logSvcMnthIcmCd */
    public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( ATTR_LOGSVCMNTHICMCD ,logSvcMnthIcmCd);}
    /** get 근속월수코드 : logSvcMnthIcmCd */
    public String  getLogSvcMnthIcmCd() { return (String )get( ATTR_LOGSVCMNTHICMCD );}
    
    /** set 근속월수코드 : logSvcMnthIcmNm */
    public void setLogSvcMnthIcmNm(String  logSvcMnthIcmNm) { set( ATTR_LOGSVCMNTHICMNM ,logSvcMnthIcmNm);}
    /** get 근속월수코드 : logSvcMnthIcmNm */
    public String  getLogSvcMnthIcmNm() { return (String )get( ATTR_LOGSVCMNTHICMNM );}  
    
    /** set 최초고용일자 : frstEmymtDt */
    public void setFrstEmymtDt(String  frstEmymtDt) { set( ATTR_FRSTEMYMTDT ,frstEmymtDt);}
    /** get 최초고용일자 : frstEmymtDt */
    public String  getFrstEmymtDt() { return (String )get( ATTR_FRSTEMYMTDT );}
    /** set 고용시작일자 : emymtBgnnDt */
    public void setEmymtBgnnDt(String  emymtBgnnDt) { set( ATTR_EMYMTBGNNDT ,emymtBgnnDt);}
    /** get 고용시작일자 : emymtBgnnDt */
    public String  getEmymtBgnnDt() { return (String )get( ATTR_EMYMTBGNNDT );}
    /** set 고용종료일자 : emymtEndDt */
    public void setEmymtEndDt(String  emymtEndDt) { set( ATTR_EMYMTENDDT ,emymtEndDt);}
    /** get 고용종료일자 : emymtEndDt */
    public String  getEmymtEndDt() { return (String )get( ATTR_EMYMTENDDT );}
    /** set 재직구분코드 : hdofcDivCd */
    public void setHdofcDivCd(String  hdofcDivCd) { set( ATTR_HDOFCDIVCD ,hdofcDivCd);}
    /** get 재직구분코드 : hdofcDivCd */
    public String  getHdofcDivCd() { return (String )get( ATTR_HDOFCDIVCD );}
    /** set 퇴직일자 : retryDt */
    public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
    /** get 퇴직일자 : retryDt */
    public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}
    /** set 지급총액 : pyytPymtTotAmnt */
    public void setPyytPymtTotAmnt(String  pyytPymtTotAmnt) { set( ATTR_PYYTPYMTTOTAMNT ,pyytPymtTotAmnt);}
    /** get 지급총액 : pyytPymtTotAmnt */
    public String  getPyytPymtTotAmnt() { return (String )get( ATTR_PYYTPYMTTOTAMNT );}
    /** set 수당총액 : pyytExtpyTotAmnt */
    public void setPyytExtpyTotAmnt(String  pyytExtpyTotAmnt) { set( ATTR_PYYTEXTPYTOTAMNT ,pyytExtpyTotAmnt);}
    /** get 수당총액 : pyytExtpyTotAmnt */
    public String  getPyytExtpyTotAmnt() { return (String )get( ATTR_PYYTEXTPYTOTAMNT );}
    /** set 과세총액 : pyytTxtnTotAmnt */
    public void setPyytTxtnTotAmnt(String  pyytTxtnTotAmnt) { set( ATTR_PYYTTXTNTOTAMNT ,pyytTxtnTotAmnt);}
    /** get 과세총액 : pyytTxtnTotAmnt */
    public String  getPyytTxtnTotAmnt() { return (String)get( ATTR_PYYTTXTNTOTAMNT );}
    /** set 비과세총액 : pyytFreeDtyTotAmnt */
    public void setPyytFreeDtyTotAmnt(String  pyytFreeDtyTotAmnt) { set( ATTR_PYYTFREEDTYTOTAMNT ,pyytFreeDtyTotAmnt);}
    /** get 비과세총액 : pyytFreeDtyTotAmnt */
    public String  getPyytFreeDtyTotAmnt() { return (String )get( ATTR_PYYTFREEDTYTOTAMNT );}
    /** set 공제총액 : pyytDducTotAmnt */
    public void setPyytDducTotAmnt(String  pyytDducTotAmnt) { set( ATTR_PYYTDDUCTOTAMNT ,pyytDducTotAmnt);}
    /** get 공제총액 : pyytDducTotAmnt */
    public String  getPyytDducTotAmnt() { return (String )get( ATTR_PYYTDDUCTOTAMNT );}
    /** set 세금총액 : pyytTxTotAmnt */
    public void setPyytTxTotAmnt(String  pyytTxTotAmnt) { set( ATTR_PYYTTXTOTAMNT ,pyytTxTotAmnt);}
    /** get 세금총액 : pyytTxTotAmnt */
    public String  getPyytTxTotAmnt() { return (String )get( ATTR_PYYTTXTOTAMNT );}
    /** set 퇴직금지급여부 : pyytSevePayPymtYn */
    public void setPyytSevePayPymtYn(String  pyytSevePayPymtYn) { set( ATTR_PYYTSEVEPAYPYMTYN ,pyytSevePayPymtYn);}
    /** get 퇴직금지급여부 : pyytSevePayPymtYn */
    public String  getPyytSevePayPymtYn() { return (String )get( ATTR_PYYTSEVEPAYPYMTYN );}
    /** set 차인지급액 : pyytPernPymtSum */
    public void setPyytPernPymtSum(String  pyytPernPymtSum) { set( ATTR_PYYTPERNPYMTSUM ,pyytPernPymtSum);}
    /** get 차인지급액 : pyytPernPymtSum */
    public String  getPyytPernPymtSum() { return (String )get( ATTR_PYYTPERNPYMTSUM );}
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
    
    /** set 기본급 : pyytB10100Sum */
    public void setPyytB10100Sum(String  pyytB10100Sum) { set( ATTR_PYYTB10100SUM ,pyytB10100Sum);}
    /** get 기본급 : pyytB10100Sum */
    public String  getPyytB10100Sum() { return (String )get( ATTR_PYYTB10100SUM );}
     
    /** set 소득세 : pyytT10100Sum */
    public void setPyytT10100Sum(String  pyytT10100Sum) { set( ATTR_PYYTT10100SUM ,pyytT10100Sum);}
    /** get 소득세 : pyytT10100Sum */
    public String  getPyytT10100Sum() { return (String )get( ATTR_PYYTT10100SUM );}
     
    /** set 주민세 : pyytT20100Sum */
    public void setPyytT20100Sum(String  pyytT20100Sum) { set( ATTR_PYYTT20100SUM ,pyytT20100Sum);}
    /** get 주민세 : pyytT20100Sum */
    public String  getPyytT20100Sum() { return (String )get( ATTR_PYYTT20100SUM );}
    
    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}

}
