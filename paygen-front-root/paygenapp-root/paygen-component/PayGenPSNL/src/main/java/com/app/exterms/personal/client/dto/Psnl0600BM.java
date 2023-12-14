package com.app.exterms.personal.client.dto;



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
public class Psnl0600BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    
    
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 한글성명 : hanNm */
	public static final String ATTR_HANNM = "hanNm";

	/** set 영문성명 : engNm */
	public static final String ATTR_ENGNM = "engNm";
	
	
	/** set 장애구분 : dabtyDivCd */
	public static final String ATTR_DABTYDIVCD = "dabtyDivCd";
	
	/** set 장애구분 : dabtyDivNm */
	public static final String ATTR_DABTYDIVNM = "dabtyDivNm";
	
	
	/** set 전화번호 : husPhnNum */
	public static final String ATTR_HUSPHNNUM = "husPhnNum";
	
	/** set 이메일 : emailAddr */
	public static final String ATTR_EMAILADDR = "emailAddr";
	
	/** set 핸드폰 : cellPhneNum */
	public static final String ATTR_CELLPHNENUM = "cellPhneNum";
	

	/** set 한문성명 : chinCharNm */
	public static final String ATTR_CHINCHARNM = "chinCharNm";

	/** set 주민등록번호 : resnRegnNum */
	public static final String ATTR_RESNREGNNUM = "resnRegnNum";

	/** set 성별구분코드 : sxDivCd */
	public static final String ATTR_SXDIVCD = "sxDivCd";

	/** set 생년월일 : yoobhMnthDay */
	public static final String ATTR_YOOBHMNTHDAY = "yoobhMnthDay";

	/** set 음양구분코드 : sclcDivCd */
	public static final String ATTR_SCLCDIVCD = "sclcDivCd";

	/** set 국가코드 : natnCd */
	public static final String ATTR_NATNCD = "natnCd";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";

	/** set 사업코드 : businCd */
	public static final String ATTR_BUSINCD = "businCd";

	/** set 현소속부서코드 : currAffnDeptCd */
	public static final String ATTR_CURRAFFNDEPTCD = "currAffnDeptCd";
	
	/** set 현소속부서명 : currAffnDeptNm */
	public static final String ATTR_CURRAFFNDEPTNM = "currAffnDeptNm";

	/** set 담당업무구분코드 : repbtyBusinDivCd */
	public static final String ATTR_REPBTYBUSINDIVCD = "repbtyBusinDivCd";

	/** set 직종코드 : typOccuCd */
	public static final String ATTR_TYPOCCUCD = "typOccuCd";
	
	 
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";
	
	/** set 직종세통합명 : dtilOccuInttnNm */
	public static final String ATTR_DTILOCCUINTTNNM = "dtilOccuInttnNm";
	       

	/** set 직책코드 : odtyCd */
	public static final String ATTR_ODTYCD = "odtyCd";

	/** set 최초고용일자 : frstEmymtDt */
	public static final String ATTR_FRSTEMYMTDT = "frstEmymtDt";

	/** set 고용구분코드 : emymtDivCd */
	public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
	
	/** set 고용구분명: emymtDivNm */
	public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

	/** set 고용시작일자 : emymtBgnnDt */
	public static final String ATTR_EMYMTBGNNDT = "emymtBgnnDt";

	/** set 고용종료일자 : emymtEndDt */
	public static final String ATTR_EMYMTENDDT = "emymtEndDt";

	/** set 호봉코드 : pyspCd */
	public static final String ATTR_PYSPCD = "pyspCd";

	/** set 재직상태코드 : hdofcCodtnCd */
	public static final String ATTR_HDOFCCODTNCD = "hdofcCodtnCd";
	
	/** set 재직상태명 : hdofcCodtnNm */
	public static final String ATTR_HDOFCCODTNNM = "hdofcCodtnNm";

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
	
	/** set 근속년수코드 : logSvcYrNumNm */
	public static final String ATTR_LOGSVCYRNUMNM = "logSvcYrNumNm";

	/** set 근속월수코드 : logSvcMnthIcmCd */
	public static final String ATTR_LOGSVCMNTHICMCD = "logSvcMnthIcmCd";
	
	/** set 근속월수코드 : logSvcMnthIcmNm */
	public static final String ATTR_LOGSVCMNTHICMNM = "logSvcMnthIcmNm";

	/** set 현_호봉발령일자 : currPyspAppmtDt */
	public static final String ATTR_CURRPYSPAPPMTDT = "currPyspAppmtDt";

	/** set 현_부서발령일자 : currDeptAppmtDt */
	public static final String ATTR_CURRDEPTAPPMTDT = "currDeptAppmtDt";

	/** set 도로명 : addr */
	public static final String ATTR_ADDR = "addr";
	
	/** set 인사비고내용 : pernNoteCtnt */
	public static final String ATTR_PERNNOTECTNT = "pernNoteCtnt";

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

	/** set 호봉등급코드 : pyspGrdeCd */
	public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public static final String ATTR_DTILOCCUCLSDIVCD = "dtilOccuClsDivCd";
	
	/** set 담당업무명 : repbtyBusinNm */
	public static final String ATTR_REPBTYBUSINNM = "repbtyBusinNm";

	
	/** 생성자 */
	 public Psnl0600BM() { super(); } 

	/** 일괄등록 처리   */
	 public Psnl0600BM(
			 String  dpobCd 
			, String  systemkey 
			, String  hanNm 
			, String  engNm 
			, String  chinCharNm 
			, String  resnRegnNum 
			, String  sxDivCd 
			, String  yoobhMnthDay 
			, String  sclcDivCd 
			, String  natnCd 
			, String  deptCd 
			, String  businCd 
			, String  currAffnDeptCd 
			, String  repbtyBusinDivCd 
			, String  typOccuCd 
			, String  odtyCd 
			, String  frstEmymtDt 
			, String  emymtDivCd 
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
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr 
			, String  pyspGrdeCd 
			, String  dtilOccuClsDivCd ) { 
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_SYSTEMKEY,systemkey);
	 	values.put(ATTR_HANNM,hanNm);
	 	values.put(ATTR_ENGNM,engNm);
	 	values.put(ATTR_CHINCHARNM,chinCharNm);
	 	values.put(ATTR_RESNREGNNUM,resnRegnNum);
	 	values.put(ATTR_SXDIVCD,sxDivCd);
	 	values.put(ATTR_YOOBHMNTHDAY,yoobhMnthDay);
	 	values.put(ATTR_SCLCDIVCD,sclcDivCd);
	 	values.put(ATTR_NATNCD,natnCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_BUSINCD,businCd);
	 	values.put(ATTR_CURRAFFNDEPTCD,currAffnDeptCd);
	 	values.put(ATTR_REPBTYBUSINDIVCD,repbtyBusinDivCd);
	 	values.put(ATTR_TYPOCCUCD,typOccuCd);
	 	values.put(ATTR_ODTYCD,odtyCd);
	 	values.put(ATTR_FRSTEMYMTDT,frstEmymtDt);
	 	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
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
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr);
	 	values.put(ATTR_PYSPGRDECD,pyspGrdeCd);
	 	values.put(ATTR_DTILOCCUCLSDIVCD,dtilOccuClsDivCd); } 

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}

	/** set 한글성명 : hanNm */
	public void setHanNm(String  hanNm) { set( ATTR_HANNM ,hanNm);}
	/** get 한글성명 : hanNm */
	public String  getHanNm() { return (String )get( ATTR_HANNM );}

	/** set 영문성명 : engNm */
	public void setEngNm(String  engNm) { set( ATTR_ENGNM ,engNm);}
	/** get 영문성명 : engNm */
	public String  getEngNm() { return (String )get( ATTR_ENGNM );}

	/** set 한문성명 : chinCharNm */
	public void setChinCharNm(String  chinCharNm) { set( ATTR_CHINCHARNM ,chinCharNm);}
	/** get 한문성명 : chinCharNm */
	public String  getChinCharNm() { return (String )get( ATTR_CHINCHARNM );}

	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String  resnRegnNum) { set( ATTR_RESNREGNNUM ,resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String  getResnRegnNum() { return (String )get( ATTR_RESNREGNNUM );}

	/** set 성별구분코드 : sxDivCd */
	public void setSxDivCd(String  sxDivCd) { set( ATTR_SXDIVCD ,sxDivCd);}
	/** get 성별구분코드 : sxDivCd */
	public String  getSxDivCd() { return (String )get( ATTR_SXDIVCD );}

	/** set 생년월일 : yoobhMnthDay */
	public void setYoobhMnthDay(String  yoobhMnthDay) { set( ATTR_YOOBHMNTHDAY ,yoobhMnthDay);}
	/** get 생년월일 : yoobhMnthDay */
	public String  getYoobhMnthDay() { return (String )get( ATTR_YOOBHMNTHDAY );}

	/** set 음양구분코드 : sclcDivCd */
	public void setSclcDivCd(String  sclcDivCd) { set( ATTR_SCLCDIVCD ,sclcDivCd);}
	/** get 음양구분코드 : sclcDivCd */
	public String  getSclcDivCd() { return (String )get( ATTR_SCLCDIVCD );}

	/** set 국가코드 : natnCd */
	public void setNatnCd(String  natnCd) { set( ATTR_NATNCD ,natnCd);}
	/** get 국가코드 : natnCd */
	public String  getNatnCd() { return (String )get( ATTR_NATNCD );}

	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}

	/** set 현소속부서코드 : currAffnDeptCd */
	public void setCurrAffnDeptCd(String  currAffnDeptCd) { set( ATTR_CURRAFFNDEPTCD ,currAffnDeptCd);}
	/** get 현소속부서코드 : currAffnDeptCd */
	public String  getCurrAffnDeptCd() { return (String )get( ATTR_CURRAFFNDEPTCD );}
	
	/** set 현소속부서코드 : currAffnDeptNm */
	public void setCurrAffnDeptNm(String  currAffnDeptNm) { set( ATTR_CURRAFFNDEPTNM ,currAffnDeptNm);}
	/** get 현소속부서코드 : currAffnDeptNm */
	public String  getCurrAffnDeptNm() { return (String )get( ATTR_CURRAFFNDEPTNM );}

	/** set 담당업무구분코드 : repbtyBusinDivCd */
	public void setRepbtyBusinDivCd(String  repbtyBusinDivCd) { set( ATTR_REPBTYBUSINDIVCD ,repbtyBusinDivCd);}
	/** get 담당업무구분코드 : repbtyBusinDivCd */
	public String  getRepbtyBusinDivCd() { return (String )get( ATTR_REPBTYBUSINDIVCD );}

	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

	/** set 직책코드 : odtyCd */
	public void setOdtyCd(String  odtyCd) { set( ATTR_ODTYCD ,odtyCd);}
	/** get 직책코드 : odtyCd */
	public String  getOdtyCd() { return (String )get( ATTR_ODTYCD );}

	/** set 최초고용일자 : frstEmymtDt */
	public void setFrstEmymtDt(String  frstEmymtDt) { set( ATTR_FRSTEMYMTDT ,frstEmymtDt);}
	/** get 최초고용일자 : frstEmymtDt */
	public String  getFrstEmymtDt() { return (String )get( ATTR_FRSTEMYMTDT );}

	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
	
	/** set 고용구분명 : emymtDivNm */
	public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM , emymtDivNm);}
	/** get 고용구분명 : emymtDivCd */
	public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}

	/** set 고용시작일자 : emymtBgnnDt */
	public void setEmymtBgnnDt(String  emymtBgnnDt) { set( ATTR_EMYMTBGNNDT ,emymtBgnnDt);}
	/** get 고용시작일자 : emymtBgnnDt */
	public String  getEmymtBgnnDt() { return (String )get( ATTR_EMYMTBGNNDT );}

	/** set 고용종료일자 : emymtEndDt */
	public void setEmymtEndDt(String  emymtEndDt) { set( ATTR_EMYMTENDDT ,emymtEndDt);}
	/** get 고용종료일자 : emymtEndDt */
	public String  getEmymtEndDt() { return (String )get( ATTR_EMYMTENDDT );}

	/** set 호봉코드 : pyspCd */
	public void setPyspCd(String  pyspCd) { set( ATTR_PYSPCD ,pyspCd);}
	/** get 호봉코드 : pyspCd */
	public String  getPyspCd() { return (String )get( ATTR_PYSPCD );}

	/** set 재직상태코드 : hdofcCodtnCd */
	public void setHdofcCodtnCd(String  hdofcCodtnCd) { set( ATTR_HDOFCCODTNCD ,hdofcCodtnCd);}
	/** get 재직상태코드 : hdofcCodtnCd */
	public String  getHdofcCodtnCd() { return (String )get( ATTR_HDOFCCODTNCD );}
	
	/** set 재직상태코드 : hdofcCodtnNm */
	public void setHdofcCodtnNm(String  hdofcCodtnNm) { set( ATTR_HDOFCCODTNNM ,hdofcCodtnNm);}
	/** get 재직상태코드 : hdofcCodtnNm */
	public String  getHdofcCodtnNm() { return (String )get( ATTR_HDOFCCODTNNM );}

	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String  retryDt) { set( ATTR_RETRYDT ,retryDt);}
	/** get 퇴직일자 : retryDt */
	public String  getRetryDt() { return (String )get( ATTR_RETRYDT );}

	/** set 퇴직사유내용 : retryReasCtnt */
	public void setRetryReasCtnt(String  retryReasCtnt) { set( ATTR_RETRYREASCTNT ,retryReasCtnt);}
	/** get 퇴직사유내용 : retryReasCtnt */
	public String  getRetryReasCtnt() { return (String )get( ATTR_RETRYREASCTNT );}

	/** set 외국인구분코드 : frgnrDivCd */
	public void setFrgnrDivCd(String  frgnrDivCd) { set( ATTR_FRGNRDIVCD ,frgnrDivCd);}
	/** get 외국인구분코드 : frgnrDivCd */
	public String  getFrgnrDivCd() { return (String )get( ATTR_FRGNRDIVCD );}

	/** set 여권번호 : psptNum */
	public void setPsptNum(String  psptNum) { set( ATTR_PSPTNUM ,psptNum);}
	/** get 여권번호 : psptNum */
	public String  getPsptNum() { return (String )get( ATTR_PSPTNUM );}

	/** set 체류시작일자 : styBgnnDt */
	public void setStyBgnnDt(String  styBgnnDt) { set( ATTR_STYBGNNDT ,styBgnnDt);}
	/** get 체류시작일자 : styBgnnDt */
	public String  getStyBgnnDt() { return (String )get( ATTR_STYBGNNDT );}

	/** set 체류종료일자 : styEndDt */
	public void setStyEndDt(String  styEndDt) { set( ATTR_STYENDDT ,styEndDt);}
	/** get 체류종료일자 : styEndDt */
	public String  getStyEndDt() { return (String )get( ATTR_STYENDDT );}

	/** set 최종학교 : endSchl */
	public void setEndSchl(String  endSchl) { set( ATTR_ENDSCHL ,endSchl);}
	/** get 최종학교 : endSchl */
	public String  getEndSchl() { return (String )get( ATTR_ENDSCHL );}

	/** set 최종학위구분코드 : endDegrDivCd */
	public void setEndDegrDivCd(String  endDegrDivCd) { set( ATTR_ENDDEGRDIVCD ,endDegrDivCd);}
	/** get 최종학위구분코드 : endDegrDivCd */
	public String  getEndDegrDivCd() { return (String )get( ATTR_ENDDEGRDIVCD );}

	/** set 승진예정일자 : pmtnScduDt */
	public void setPmtnScduDt(String  pmtnScduDt) { set( ATTR_PMTNSCDUDT ,pmtnScduDt);}
	/** get 승진예정일자 : pmtnScduDt */
	public String  getPmtnScduDt() { return (String )get( ATTR_PMTNSCDUDT );}

	/** set 호봉승급예정일자 : pyspPrmtnScduDt */
	public void setPyspPrmtnScduDt(String  pyspPrmtnScduDt) { set( ATTR_PYSPPRMTNSCDUDT ,pyspPrmtnScduDt);}
	/** get 호봉승급예정일자 : pyspPrmtnScduDt */
	public String  getPyspPrmtnScduDt() { return (String )get( ATTR_PYSPPRMTNSCDUDT );}

	/** set 재고용예정일자 : reymnScduDt */
	public void setReymnScduDt(String  reymnScduDt) { set( ATTR_REYMNSCDUDT ,reymnScduDt);}
	/** get 재고용예정일자 : reymnScduDt */
	public String  getReymnScduDt() { return (String )get( ATTR_REYMNSCDUDT );}

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

	/** set 현_호봉발령일자 : currPyspAppmtDt */
	public void setCurrPyspAppmtDt(String  currPyspAppmtDt) { set( ATTR_CURRPYSPAPPMTDT ,currPyspAppmtDt);}
	/** get 현_호봉발령일자 : currPyspAppmtDt */
	public String  getCurrPyspAppmtDt() { return (String )get( ATTR_CURRPYSPAPPMTDT );}

	/** set 현_부서발령일자 : currDeptAppmtDt */
	public void setCurrDeptAppmtDt(String  currDeptAppmtDt) { set( ATTR_CURRDEPTAPPMTDT ,currDeptAppmtDt);}
	/** get 현_부서발령일자 : currDeptAppmtDt */
	public String  getCurrDeptAppmtDt() { return (String )get( ATTR_CURRDEPTAPPMTDT );}

	/** set 인사비고내용 : pernNoteCtnt */
	public void setPernNoteCtnt(String  pernNoteCtnt) { set( ATTR_PERNNOTECTNT ,pernNoteCtnt);}
	/** get 인사비고내용 : pernNoteCtnt */
	public String  getPernNoteCtnt() { return (String )get( ATTR_PERNNOTECTNT );}

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

	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}

	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String  dtilOccuClsDivCd) { set( ATTR_DTILOCCUCLSDIVCD ,dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String  getDtilOccuClsDivCd() { return (String )get( ATTR_DTILOCCUCLSDIVCD );}
	
	
    
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
	
	/** set 직종세통합코드 : dtilOccuInttnNm */
	public void setDtilOccuInttnNm(String  dtilOccuInttnNm) { set( ATTR_DTILOCCUINTTNNM ,dtilOccuInttnNm);}
	/** get 직종세통합코드 : dtilOccuInttnNm */
	public String  getDtilOccuInttnNm() { return (String )get( ATTR_DTILOCCUINTTNNM );}


	//--------------------------------------------------------------------------------------------------------
	/** set 부서 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업명 : businNm */
    public static final String ATTR_BUSINNM = "businNm";
    
    /** set 직종명 : typOccuNm */
    public static final String ATTR_TYPOCCUNM = "typOccuNm";
    
    /** set 직종세 : dtilOccuClsDivNm */
    public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
    
    /** set 부서 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서 : deptNm */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
    
    /** set 사업명 : businNm */
	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** set 사업명 : businNm */
	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
    
    /** set 직종명 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
    /** set 직종명 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
    
    /** set 직종세 : dtilOccuClsDivNm */
	public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
    /** set 직종세 : dtilOccuClsDivNm */
	public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
	
    /** set 장애구분 : dabtyDivCd */
	public void setDabtyDivCd(String  dabtyDivCd) { set( ATTR_DABTYDIVCD ,dabtyDivCd);}
    /** set 장애구분 : dabtyDivCd */
	public String  getDabtyDivCd() { return (String )get( ATTR_DABTYDIVCD );}
    /** set 장애구분 : dabtyDivNm */
	public void setDabtyDivNm(String  dabtyDivNm) { set( ATTR_DABTYDIVNM , dabtyDivNm);}
    /** set 장애구분 : dabtyDivNm */
	public String  getDabtyDivNm() { return (String )get( ATTR_DABTYDIVNM );}
	
    /** set 도로명 : addr */
	public void setAddr(String  addr) { set( ATTR_ADDR , addr);}
    /** set 도로명 : addr */
	public String  getAddr() { return (String )get( ATTR_ADDR );}
	
	
	/** set 전화번호 : husPhnNum */
	public void setHusPhnNum(String  husPhnNum) { set( ATTR_HUSPHNNUM , husPhnNum);}
	/** set 전화번호 : husPhnNum */
	public String  getHusPhnNum() { return (String )get( ATTR_HUSPHNNUM );}
	
	/** set 핸드폰 : cellPhneNum */
	public void setCellPhneNum(String  cellPhneNum) { set( ATTR_CELLPHNENUM , cellPhneNum);}
	/** set 핸드폰 : cellPhneNum */
	public String  getCellPhneNum() { return (String )get( ATTR_CELLPHNENUM );}
	
	
	/** set 이메일 : emailAddr */
	public void setEmailAddr(String  emailAddr) { set( ATTR_EMAILADDR , emailAddr);}
	/** set 이메일 : emailAddr */
	public String  getEmailAddr() { return (String )get( ATTR_EMAILADDR );}
	
	
	
}
