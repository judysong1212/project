package com.app.exterms.personal.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0101BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 기준고용일련번호 : psnlBseSeilNum */
    public static final String ATTR_PSNLBSESEILNUM = "psnlBseSeilNum";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

    /** set 최초고용일자 : frstBseEmymtDt */
    public static final String ATTR_FRSTBSEEMYMTDT = "frstBseEmymtDt";

    /** set 국가코드 : natnCd */
    public static final String ATTR_NATNCD = "natnCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";

    /** set 현소속부서코드 : currAffnDeptCd */
    public static final String ATTR_CURRAFFNDEPTCD = "currAffnDeptCd";

    /** set 담당업무구분코드 : repbtyBusinDivCd */
    public static final String ATTR_REPBTYBUSINDIVCD = "repbtyBusinDivCd";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

    /** set 직책코드 : odtyCd */
    public static final String ATTR_ODTYCD = "odtyCd";

    /** set 고용시작일자 : emymtBgnnDt */
    public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

    /** set 고용종료일자 : emymtEndDt */
    public static final String ATTR_EMYMTENDDT = "emymtEndDt";

    /** set 호봉코드 : pyspCd */
    public static final String ATTR_PYSPCD = "pyspCd";

    /** set 재직상태코드 : hdofcCodtnCd */
    public static final String ATTR_HDOFCCODTNCD = "hdofcCodtnCd";

    /** set 퇴직일자 : retryDt */
    public static final String ATTR_RETRYDT = "retryDt";

    /** set 퇴직사유내용 : retryReasCtnt */
    public static final String ATTR_RETRYREASCTNT = "retryReasCtnt";

    /** set 외국인구분코드 : frgnrDivCd */
    public static final String ATTR_FRGNRDIVCD = "frgnrDivCd";

    /** set 여권번호 : psptNum */
    public static final String ATTR_PSPTNUM = "psptNum";

    /** set 체류시작일자 : styBgnnDt */
    public static final String ATTR_STYBGNNDT = "styBgnnDt";

    /** set 체류종료일자 : styEndDt */
    public static final String ATTR_STYENDDT = "styEndDt";

    /** set 최종학교 : endSchl */
    public static final String ATTR_ENDSCHL = "endSchl";

    /** set 최종학위구분코드 : endDegrDivCd */
    public static final String ATTR_ENDDEGRDIVCD = "endDegrDivCd";

    /** set 승진예정일자 : pmtnScduDt */
    public static final String ATTR_PMTNSCDUDT = "pmtnScduDt";

    /** set 호봉승급예정일자 : pyspPrmtnScduDt */
    public static final String ATTR_PYSPPRMTNSCDUDT = "pyspPrmtnScduDt";

    /** set 재고용예정일자 : reymnScduDt */
    public static final String ATTR_REYMNSCDUDT = "reymnScduDt";

    /** set 근속년수코드 : logSvcYrNumCd */
    public static final String ATTR_LOGSVCYRNUMCD = "logSvcYrNumCd";

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";

    /** set 현_호봉발령일자 : currPyspAppmtDt */
    public static final String ATTR_CURRPYSPAPPMTDT = "currPyspAppmtDt";

    /** set 현_부서발령일자 : currDeptAppmtDt */
    public static final String ATTR_CURRDEPTAPPMTDT = "currDeptAppmtDt";

    /** set 인사비고내용 : pernNoteCtnt */
    public static final String ATTR_PERNNOTECTNT = "pernNoteCtnt";

    /** set 호봉등급코드 : pyspGrdeCd */
    public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";

    /** set 담당업무명 : repbtyBusinNm */
    public static final String ATTR_REPBTYBUSINNM = "repbtyBusinNm";

    /** set null : secResnNum */
    public static final String ATTR_SECRESNNUM = "secResnNum";

    /** set null : orgResnNum */
    public static final String ATTR_ORGRESNNUM = "orgResnNum";

    /** set 노조가입여부 : unnMbspSttYn */
    public static final String ATTR_UNNMBSPSTTYN = "unnMbspSttYn";

    /** set 근속일수 : logSvcDys */
    public static final String ATTR_LOGSVCDYS = "logSvcDys";

    /** set 원근속년수코드 : orgLogSvcYrCd */
    public static final String ATTR_ORGLOGSVCYRCD = "orgLogSvcYrCd";

    /** set 원근속월수코드 : orgLogSvcMnthCd */
    public static final String ATTR_ORGLOGSVCMNTHCD = "orgLogSvcMnthCd";

    /** set 원근속일수 : orgLogSvcDys */
    public static final String ATTR_ORGLOGSVCDYS = "orgLogSvcDys";

    /** set 재획정일자 : reMrkDt */
    public static final String ATTR_REMRKDT = "reMrkDt";

    /** set 근속기준일자 : logStdDt */
    public static final String ATTR_LOGSTDDT = "logStdDt";

    /** set 총근속일수 : totLogSvcDys */
    public static final String ATTR_TOTLOGSVCDYS = "totLogSvcDys";

    /** set 원총근속일수 : orgTotLogSvcDys */
    public static final String ATTR_ORGTOTLOGSVCDYS = "orgTotLogSvcDys";

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
     public Psnl0101BM() { super(); } 

    /** 일괄등록 처리   */
     public Psnl0101BM(
    		 String  dpobCd 
    		, String  systemkey 
    		, BigDecimal  psnlBseSeilNum 
    		, String  emymtDivCd 
    		, String  frstBseEmymtDt 
    		, String  natnCd 
    		, String  deptCd 
    		, String  businCd 
    		, String  currAffnDeptCd 
    		, String  repbtyBusinDivCd 
    		, String  typOccuCd 
    		, String  odtyCd 
    		, String  emymtBgnnDt 
    		, String  emymtEndDt 
    		, String  pyspCd 
    		, String  hdofcCodtnCd 
    		, String  retryDt 
    		, String  retryReasCtnt 
    		, String  frgnrDivCd 
    		, String  psptNum 
    		, String  styBgnnDt 
    		, String  styEndDt 
    		, String  endSchl 
    		, String  endDegrDivCd 
    		, String  pmtnScduDt 
    		, String  pyspPrmtnScduDt 
    		, String  reymnScduDt 
    		, String  logSvcYrNumCd 
    		, String  logSvcMnthIcmCd 
    		, String  currPyspAppmtDt 
    		, String  currDeptAppmtDt 
    		, String  pernNoteCtnt 
    		, String  pyspGrdeCd 
    		, String  dtilOccuClsDivCd 
    		, String  dtilOccuInttnCd 
    		, String  repbtyBusinNm 
    		, String  secResnNum 
    		, String  orgResnNum 
    		, String  unnMbspSttYn 
    		, BigDecimal  logSvcDys 
    		, String  orgLogSvcYrCd 
    		, String  orgLogSvcMnthCd 
    		, BigDecimal  orgLogSvcDys 
    		, String  reMrkDt 
    		, String  logStdDt 
    		, BigDecimal  totLogSvcDys 
    		, BigDecimal  orgTotLogSvcDys 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_PSNLBSESEILNUM,psnlBseSeilNum);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_FRSTBSEEMYMTDT,frstBseEmymtDt);
     	values.put(ATTR_NATNCD,natnCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_CURRAFFNDEPTCD,currAffnDeptCd);
     	values.put(ATTR_REPBTYBUSINDIVCD,repbtyBusinDivCd);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
     	values.put(ATTR_ODTYCD,odtyCd);
     	values.put(ATTR_EMYMTBGNNDT,emymtBgnnDt);
     	values.put(ATTR_EMYMTENDDT,emymtEndDt);
     	values.put(ATTR_PYSPCD,pyspCd);
     	values.put(ATTR_HDOFCCODTNCD,hdofcCodtnCd);
     	values.put(ATTR_RETRYDT,retryDt);
     	values.put(ATTR_RETRYREASCTNT,retryReasCtnt);
     	values.put(ATTR_FRGNRDIVCD,frgnrDivCd);
     	values.put(ATTR_PSPTNUM,psptNum);
     	values.put(ATTR_STYBGNNDT,styBgnnDt);
     	values.put(ATTR_STYENDDT,styEndDt);
     	values.put(ATTR_ENDSCHL,endSchl);
     	values.put(ATTR_ENDDEGRDIVCD,endDegrDivCd);
     	values.put(ATTR_PMTNSCDUDT,pmtnScduDt);
     	values.put(ATTR_PYSPPRMTNSCDUDT,pyspPrmtnScduDt);
     	values.put(ATTR_REYMNSCDUDT,reymnScduDt);
     	values.put(ATTR_LOGSVCYRNUMCD,logSvcYrNumCd);
     	values.put(ATTR_LOGSVCMNTHICMCD,logSvcMnthIcmCd);
     	values.put(ATTR_CURRPYSPAPPMTDT,currPyspAppmtDt);
     	values.put(ATTR_CURRDEPTAPPMTDT,currDeptAppmtDt);
     	values.put(ATTR_PERNNOTECTNT,pernNoteCtnt);
     	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
     	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd);
     	values.put(ATTR_DTILOCCUINTTNCD,dtilOccuInttnCd);
     	values.put(ATTR_REPBTYBUSINNM,repbtyBusinNm);
     	values.put(ATTR_SECRESNNUM,secResnNum);
     	values.put(ATTR_ORGRESNNUM,orgResnNum);
     	values.put(ATTR_UNNMBSPSTTYN,unnMbspSttYn);
     	values.put(ATTR_LOGSVCDYS,logSvcDys);
     	values.put(ATTR_ORGLOGSVCYRCD,orgLogSvcYrCd);
     	values.put(ATTR_ORGLOGSVCMNTHCD,orgLogSvcMnthCd);
     	values.put(ATTR_ORGLOGSVCDYS,orgLogSvcDys);
     	values.put(ATTR_REMRKDT,reMrkDt);
     	values.put(ATTR_LOGSTDDT,logStdDt);
     	values.put(ATTR_TOTLOGSVCDYS,totLogSvcDys);
     	values.put(ATTR_ORGTOTLOGSVCDYS,orgTotLogSvcDys);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( "dpobCd" ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get("dpobCd" );}

    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( "systemkey" ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get("systemkey" );}

    /** set 기준고용일련번호 : psnlBseSeilNum */
    public void setPsnlBseSeilNum(BigDecimal  psnlBseSeilNum) { set( "psnlBseSeilNum" ,psnlBseSeilNum);}
    /** get 기준고용일련번호 : psnlBseSeilNum */
    public BigDecimal  getPsnlBseSeilNum() { return (BigDecimal )get("psnlBseSeilNum" );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( "emymtDivCd" ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get("emymtDivCd" );}

    /** set 최초고용일자 : frstBseEmymtDt */
    public void setFrstBseEmymtDt(String  frstBseEmymtDt) { set( "frstBseEmymtDt" ,frstBseEmymtDt);}
    /** get 최초고용일자 : frstBseEmymtDt */
    public String  getFrstBseEmymtDt() { return (String )get("frstBseEmymtDt" );}

    /** set 국가코드 : natnCd */
    public void setNatnCd(String  natnCd) { set( "natnCd" ,natnCd);}
    /** get 국가코드 : natnCd */
    public String  getNatnCd() { return (String )get("natnCd" );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( "deptCd" ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get("deptCd" );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( "businCd" ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get("businCd" );}

    /** set 현소속부서코드 : currAffnDeptCd */
    public void setCurrAffnDeptCd(String  currAffnDeptCd) { set( "currAffnDeptCd" ,currAffnDeptCd);}
    /** get 현소속부서코드 : currAffnDeptCd */
    public String  getCurrAffnDeptCd() { return (String )get("currAffnDeptCd" );}

    /** set 담당업무구분코드 : repbtyBusinDivCd */
    public void setRepbtyBusinDivCd(String  repbtyBusinDivCd) { set( "repbtyBusinDivCd" ,repbtyBusinDivCd);}
    /** get 담당업무구분코드 : repbtyBusinDivCd */
    public String  getRepbtyBusinDivCd() { return (String )get("repbtyBusinDivCd" );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( "typOccuCd" ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get("typOccuCd" );}

    /** set 직책코드 : odtyCd */
    public void setOdtyCd(String  odtyCd) { set( "odtyCd" ,odtyCd);}
    /** get 직책코드 : odtyCd */
    public String  getOdtyCd() { return (String )get("odtyCd" );}

    /** set 고용시작일자 : emymtBgnnDt */
    public void setEmymtBgnnDt(String  emymtBgnnDt) { set( "emymtBgnnDt" ,emymtBgnnDt);}
    /** get 고용시작일자 : emymtBgnnDt */
    public String  getEmymtBgnnDt() { return (String )get("emymtBgnnDt" );}

    /** set 고용종료일자 : emymtEndDt */
    public void setEmymtEndDt(String  emymtEndDt) { set( "emymtEndDt" ,emymtEndDt);}
    /** get 고용종료일자 : emymtEndDt */
    public String  getEmymtEndDt() { return (String )get("emymtEndDt" );}

    /** set 호봉코드 : pyspCd */
    public void setPyspCd(String  pyspCd) { set( "pyspCd" ,pyspCd);}
    /** get 호봉코드 : pyspCd */
    public String  getPyspCd() { return (String )get("pyspCd" );}

    /** set 재직상태코드 : hdofcCodtnCd */
    public void setHdofcCodtnCd(String  hdofcCodtnCd) { set( "hdofcCodtnCd" ,hdofcCodtnCd);}
    /** get 재직상태코드 : hdofcCodtnCd */
    public String  getHdofcCodtnCd() { return (String )get("hdofcCodtnCd" );}

    /** set 퇴직일자 : retryDt */
    public void setRetryDt(String  retryDt) { set( "retryDt" ,retryDt);}
    /** get 퇴직일자 : retryDt */
    public String  getRetryDt() { return (String )get("retryDt" );}

    /** set 퇴직사유내용 : retryReasCtnt */
    public void setRetryReasCtnt(String  retryReasCtnt) { set( "retryReasCtnt" ,retryReasCtnt);}
    /** get 퇴직사유내용 : retryReasCtnt */
    public String  getRetryReasCtnt() { return (String )get("retryReasCtnt" );}

    /** set 외국인구분코드 : frgnrDivCd */
    public void setFrgnrDivCd(String  frgnrDivCd) { set( "frgnrDivCd" ,frgnrDivCd);}
    /** get 외국인구분코드 : frgnrDivCd */
    public String  getFrgnrDivCd() { return (String )get("frgnrDivCd" );}

    /** set 여권번호 : psptNum */
    public void setPsptNum(String  psptNum) { set( "psptNum" ,psptNum);}
    /** get 여권번호 : psptNum */
    public String  getPsptNum() { return (String )get("psptNum" );}

    /** set 체류시작일자 : styBgnnDt */
    public void setStyBgnnDt(String  styBgnnDt) { set( "styBgnnDt" ,styBgnnDt);}
    /** get 체류시작일자 : styBgnnDt */
    public String  getStyBgnnDt() { return (String )get("styBgnnDt" );}

    /** set 체류종료일자 : styEndDt */
    public void setStyEndDt(String  styEndDt) { set( "styEndDt" ,styEndDt);}
    /** get 체류종료일자 : styEndDt */
    public String  getStyEndDt() { return (String )get("styEndDt" );}

    /** set 최종학교 : endSchl */
    public void setEndSchl(String  endSchl) { set( "endSchl" ,endSchl);}
    /** get 최종학교 : endSchl */
    public String  getEndSchl() { return (String )get("endSchl" );}

    /** set 최종학위구분코드 : endDegrDivCd */
    public void setEndDegrDivCd(String  endDegrDivCd) { set( "endDegrDivCd" ,endDegrDivCd);}
    /** get 최종학위구분코드 : endDegrDivCd */
    public String  getEndDegrDivCd() { return (String )get("endDegrDivCd" );}

    /** set 승진예정일자 : pmtnScduDt */
    public void setPmtnScduDt(String  pmtnScduDt) { set( "pmtnScduDt" ,pmtnScduDt);}
    /** get 승진예정일자 : pmtnScduDt */
    public String  getPmtnScduDt() { return (String )get("pmtnScduDt" );}

    /** set 호봉승급예정일자 : pyspPrmtnScduDt */
    public void setPyspPrmtnScduDt(String  pyspPrmtnScduDt) { set( "pyspPrmtnScduDt" ,pyspPrmtnScduDt);}
    /** get 호봉승급예정일자 : pyspPrmtnScduDt */
    public String  getPyspPrmtnScduDt() { return (String )get("pyspPrmtnScduDt" );}

    /** set 재고용예정일자 : reymnScduDt */
    public void setReymnScduDt(String  reymnScduDt) { set( "reymnScduDt" ,reymnScduDt);}
    /** get 재고용예정일자 : reymnScduDt */
    public String  getReymnScduDt() { return (String )get("reymnScduDt" );}

    /** set 근속년수코드 : logSvcYrNumCd */
    public void setLogSvcYrNumCd(String  logSvcYrNumCd) { set( "logSvcYrNumCd" ,logSvcYrNumCd);}
    /** get 근속년수코드 : logSvcYrNumCd */
    public String  getLogSvcYrNumCd() { return (String )get("logSvcYrNumCd" );}

    /** set 근속월수코드 : logSvcMnthIcmCd */
    public void setLogSvcMnthIcmCd(String  logSvcMnthIcmCd) { set( "logSvcMnthIcmCd" ,logSvcMnthIcmCd);}
    /** get 근속월수코드 : logSvcMnthIcmCd */
    public String  getLogSvcMnthIcmCd() { return (String )get("logSvcMnthIcmCd" );}

    /** set 현_호봉발령일자 : currPyspAppmtDt */
    public void setCurrPyspAppmtDt(String  currPyspAppmtDt) { set( "currPyspAppmtDt" ,currPyspAppmtDt);}
    /** get 현_호봉발령일자 : currPyspAppmtDt */
    public String  getCurrPyspAppmtDt() { return (String )get("currPyspAppmtDt" );}

    /** set 현_부서발령일자 : currDeptAppmtDt */
    public void setCurrDeptAppmtDt(String  currDeptAppmtDt) { set( "currDeptAppmtDt" ,currDeptAppmtDt);}
    /** get 현_부서발령일자 : currDeptAppmtDt */
    public String  getCurrDeptAppmtDt() { return (String )get("currDeptAppmtDt" );}

    /** set 인사비고내용 : pernNoteCtnt */
    public void setPernNoteCtnt(String  pernNoteCtnt) { set( "pernNoteCtnt" ,pernNoteCtnt);}
    /** get 인사비고내용 : pernNoteCtnt */
    public String  getPernNoteCtnt() { return (String )get("pernNoteCtnt" );}

    /** set 호봉등급코드 : pyspGrdeCd */
    public void setPyspGrdeCd(String  pyspGrdeCd) { set( "pyspGrdeCd" ,pyspGrdeCd);}
    /** get 호봉등급코드 : pyspGrdeCd */
    public String  getPyspGrdeCd() { return (String )get("pyspGrdeCd" );}

    /** set 직종세구분코드 : dtilOccuClsDivCd */
    public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( "dtilOccuClsDivCd" ,dtilOccuClsDivCd);}
    /** get 직종세구분코드 : dtilOccuClsDivCd */
    public String  getDtilOccuClsDivCd() { return (String )get("dtilOccuClsDivCd" );}

    /** set 직종세통합코드 : dtilOccuInttnCd */
    public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( "dtilOccuInttnCd" ,dtilOccuInttnCd);}
    /** get 직종세통합코드 : dtilOccuInttnCd */
    public String  getDtilOccuInttnCd() { return (String )get("dtilOccuInttnCd" );}

    /** set 담당업무명 : repbtyBusinNm */
    public void setRepbtyBusinNm(String  repbtyBusinNm) { set( "repbtyBusinNm" ,repbtyBusinNm);}
    /** get 담당업무명 : repbtyBusinNm */
    public String  getRepbtyBusinNm() { return (String )get("repbtyBusinNm" );}

    /** set null : secResnNum */
    public void setSecResnNum(String  secResnNum) { set( "secResnNum" ,secResnNum);}
    /** get null : secResnNum */
    public String  getSecResnNum() { return (String )get("secResnNum" );}

    /** set null : orgResnNum */
    public void setOrgResnNum(String  orgResnNum) { set( "orgResnNum" ,orgResnNum);}
    /** get null : orgResnNum */
    public String  getOrgResnNum() { return (String )get("orgResnNum" );}

    /** set 노조가입여부 : unnMbspSttYn */
    public void setUnnMbspSttYn(String  unnMbspSttYn) { set( "unnMbspSttYn" ,unnMbspSttYn);}
    /** get 노조가입여부 : unnMbspSttYn */
    public String  getUnnMbspSttYn() { return (String )get("unnMbspSttYn" );}

    /** set 근속일수 : logSvcDys */
    public void setLogSvcDys(BigDecimal  logSvcDys) { set( "logSvcDys" ,logSvcDys);}
    /** get 근속일수 : logSvcDys */
    public BigDecimal  getLogSvcDys() { return (BigDecimal )get("logSvcDys" );}

    /** set 원근속년수코드 : orgLogSvcYrCd */
    public void setOrgLogSvcYrCd(String  orgLogSvcYrCd) { set( "orgLogSvcYrCd" ,orgLogSvcYrCd);}
    /** get 원근속년수코드 : orgLogSvcYrCd */
    public String  getOrgLogSvcYrCd() { return (String )get("orgLogSvcYrCd" );}

    /** set 원근속월수코드 : orgLogSvcMnthCd */
    public void setOrgLogSvcMnthCd(String  orgLogSvcMnthCd) { set( "orgLogSvcMnthCd" ,orgLogSvcMnthCd);}
    /** get 원근속월수코드 : orgLogSvcMnthCd */
    public String  getOrgLogSvcMnthCd() { return (String )get("orgLogSvcMnthCd" );}

    /** set 원근속일수 : orgLogSvcDys */
    public void setOrgLogSvcDys(BigDecimal  orgLogSvcDys) { set( "orgLogSvcDys" ,orgLogSvcDys);}
    /** get 원근속일수 : orgLogSvcDys */
    public BigDecimal  getOrgLogSvcDys() { return (BigDecimal )get("orgLogSvcDys" );}

    /** set 재획정일자 : reMrkDt */
    public void setReMrkDt(String  reMrkDt) { set( "reMrkDt" ,reMrkDt);}
    /** get 재획정일자 : reMrkDt */
    public String  getReMrkDt() { return (String )get("reMrkDt" );}

    /** set 근속기준일자 : logStdDt */
    public void setLogStdDt(String  logStdDt) { set( "logStdDt" ,logStdDt);}
    /** get 근속기준일자 : logStdDt */
    public String  getLogStdDt() { return (String )get("logStdDt" );}

    /** set 총근속일수 : totLogSvcDys */
    public void setTotLogSvcDys(BigDecimal  totLogSvcDys) { set( "totLogSvcDys" ,totLogSvcDys);}
    /** get 총근속일수 : totLogSvcDys */
    public BigDecimal  getTotLogSvcDys() { return (BigDecimal )get("totLogSvcDys" );}

    /** set 원총근속일수 : orgTotLogSvcDys */
    public void setOrgTotLogSvcDys(BigDecimal  orgTotLogSvcDys) { set( "orgTotLogSvcDys" ,orgTotLogSvcDys);}
    /** get 원총근속일수 : orgTotLogSvcDys */
    public BigDecimal  getOrgTotLogSvcDys() { return (BigDecimal )get("orgTotLogSvcDys" );}

    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( "kybdr" ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get("kybdr" );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( "inptDt" ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get("inptDt" );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( "inptAddr" ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get("inptAddr" );}

    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( "ismt" ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get("ismt" );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( "revnDt" ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get("revnDt" );}

    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( "revnAddr" ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get("revnAddr" );}

     
}
