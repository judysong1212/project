package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

public class InfcPkgPsnl0100DTO extends BaseModel{
	
	private static final long serialVersionUID = 1L;
	
	public InfcPkgPsnl0100DTO(){}
	
	//순번이 필요할경우
	public void setRnum(String rnum) { set("rnum", rnum); }
	public String getRnum(){return (String)get("rnum");}
	
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String)get("dpobCd");}
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String getSystemkey() { return (String)get("systemkey");}
	/** set 한글성명 : hanNm */
	public void setHanNm(String hanNm) { set("hanNm",hanNm);}
	/** get 한글성명 : hanNm */
	public String getHanNm() { return (String)get("hanNm");}
	/** set 영문성명 : engNm */
	public void setEngNm(String engNm) { set("engNm",engNm);}
	/** get 영문성명 : engNm */
	public String getEngNm() { return (String)get("engNm");}
	/** set 한문성명 : chinCharNm */
	public void setChinCharNm(String chinCharNm) { set("chinCharNm",chinCharNm);}
	/** get 한문성명 : chinCharNm */
	public String getChinCharNm() { return (String)get("chinCharNm");}
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	
	/** set 원본 주민등록번호 : secRegnNum */
	public void setSecRegnNum(String secRegnNum) { set("secRegnNum",secRegnNum);}
	/** get 원본 주민등록번호 : secRegnNum */
	public String getSecRegnNum() { return (String)get("secRegnNum");}
	
	/** set 성별구분코드 : sxDivCd */
	public void setSxDivCd(String sxDivCd) { set("sxDivCd",sxDivCd);}
	/** get 성별구분코드 : sxDivCd */
	public String getSxDivCd() { return (String)get("sxDivCd");}
	/** set 생년월일 : yoobhMnthDay */
	public void setYoobhMnthDay(String yoobhMnthDay) { set("yoobhMnthDay",yoobhMnthDay);}
	/** get 생년월일 : yoobhMnthDay */
	public String getYoobhMnthDay() { return (String)get("yoobhMnthDay");}
	/** set 음양구분코드 : sclcDivCd */
	public void setSclcDivCd(String sclcDivCd) { set("sclcDivCd",sclcDivCd);}
	/** get 음양구분코드 : sclcDivCd */
	public String getSclcDivCd() { return (String)get("sclcDivCd");}
	/** set 국가코드 : natnCd */
	public void setNatnCd(String natnCd) { set("natnCd",natnCd);}
	/** get 국가코드 : natnCd */
	public String getNatnCd() { return (String)get("natnCd");}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
	/** get 부서코드 : deptCd */
	public String getDeptCd() { return (String)get("deptCd");}
	/** set 부서코드 : deptNm */
    public void setDeptNm(String deptNm) { set("deptNm",deptNm);}
    /** get 부서코드 : deptNm */
    public String getDeptNm() { return (String)get("deptNm");}
    
	/** set 사업코드 : businCd */
	public void setBusinCd(String businCd) { set("businCd",businCd);}
	/** get 사업코드 : businCd */
	public String getBusinCd() { return (String)get("businCd");}
	/** set 현소속부서코드 : currAffnDeptCd */
	public void setCurrAffnDeptCd(String currAffnDeptCd) { set("currAffnDeptCd",currAffnDeptCd);}
	/** get 현소속부서코드 : currAffnDeptCd */
	public String getCurrAffnDeptCd() { return (String)get("currAffnDeptCd");}
	/** set 현소속부서코드 : currAffnDeptNm */
    public void setCurrAffnDeptNm(String currAffnDeptNm) { set("currAffnDeptNm",currAffnDeptNm);}
    /** get 현소속부서코드 : currAffnDeptNm */
    public String getCurrAffnDeptNm() { return (String)get("currAffnDeptNm");}
	/** set 담당업무구분코드 : repbtyBusinDivCd */
	public void setRepbtyBusinDivCd(String repbtyBusinDivCd) { set("repbtyBusinDivCd",repbtyBusinDivCd);}
	/** get 담당업무구분코드 : repbtyBusinDivCd */
	public String getRepbtyBusinDivCd() { return (String)get("repbtyBusinDivCd");}
	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String typOccuCd) { set("typOccuCd",typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String getTypOccuCd() { return (String)get("typOccuCd");}
    //직종코드 : typComboOccuCd
  public void setTypComboOccuCd(String typComboOccuCd) { set("typComboOccuCd",typComboOccuCd);}
  public String getTypComboOccuCd() { return (String)get("typComboOccuCd");}
	/** set 직책코드 : odtyCd */
	public void setOdtyCd(String odtyCd) { set("odtyCd",odtyCd);}
	/** get 직책코드 : odtyCd */
	public String getOdtyCd() { return (String)get("odtyCd");}
	/** set 최초고용일자 : frstEmymtDt */
	public void setFrstEmymtDt(String frstEmymtDt) { set("frstEmymtDt",frstEmymtDt);}
	/** get 최초고용일자 : frstEmymtDt */
	public String getFrstEmymtDt() { return (String)get("frstEmymtDt");}
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String emymtDivCd) { set("emymtDivCd",emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String getEmymtDivCd() { return (String)get("emymtDivCd");}
	/** set 고용시작일자 : emymtBgnnDt */
	public void setEmymtBgnnDt(String emymtBgnnDt) { set("emymtBgnnDt",emymtBgnnDt);}
	/** get 고용시작일자 : emymtBgnnDt */
	public String getEmymtBgnnDt() { return (String)get("emymtBgnnDt");}
	/** set 고용종료일자 : emymtEndDt */
	public void setEmymtEndDt(String emymtEndDt) { set("emymtEndDt",emymtEndDt);}
	/** get 고용종료일자 : emymtEndDt */
	public String getEmymtEndDt() { return (String)get("emymtEndDt");}
	/** set 호봉코드 : pyspCd */
	public void setPyspCd(String pyspCd) { set("pyspCd",pyspCd);}
	/** get 호봉코드 : pyspCd */
	public String getPyspCd() { return (String)get("pyspCd");}
	/** set 재직상태코드 : hdofcCodtnCd */
	public void setHdofcCodtnCd(String hdofcCodtnCd) { set("hdofcCodtnCd",hdofcCodtnCd);}
	/** get 재직상태코드 : hdofcCodtnCd */
	public String getHdofcCodtnCd() { return (String)get("hdofcCodtnCd");}
	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String retryDt) { set("retryDt",retryDt);}
	/** get 퇴직일자 : retryDt */
	public String getRetryDt() { return (String)get("retryDt");}
	/** set 퇴직사유내용 : retryReasCtnt */
	public void setRetryReasCtnt(String retryReasCtnt) { set("retryReasCtnt",retryReasCtnt);}
	/** get 퇴직사유내용 : retryReasCtnt */
	public String getRetryReasCtnt() { return (String)get("retryReasCtnt");}
	/** set 외국인구분코드 : frgnrDivCd */
	public void setFrgnrDivCd(String frgnrDivCd) { set("frgnrDivCd",frgnrDivCd);}
	/** get 외국인구분코드 : frgnrDivCd */
	public String getFrgnrDivCd() { return (String)get("frgnrDivCd");}
	/** set 여권번호 : psptNum */
	public void setPsptNum(String psptNum) { set("psptNum",psptNum);}
	/** get 여권번호 : psptNum */
	public String getPsptNum() { return (String)get("psptNum");}
	/** set 체류시작일자 : styBgnnDt */
	public void setStyBgnnDt(String styBgnnDt) { set("styBgnnDt",styBgnnDt);}
	/** get 체류시작일자 : styBgnnDt */
	public String getStyBgnnDt() { return (String)get("styBgnnDt");}
	/** set 체류종료일자 : styEndDt */
	public void setStyEndDt(String styEndDt) { set("styEndDt",styEndDt);}
	/** get 체류종료일자 : styEndDt */
	public String getStyEndDt() { return (String)get("styEndDt");}
	/** set 최종학교 : endSchl */
	public void setEndSchl(String endSchl) { set("endSchl",endSchl);}
	/** get 최종학교 : endSchl */
	public String getEndSchl() { return (String)get("endSchl");}
	/** set 최종학위구분코드 : endDegrDivCd */
	public void setEndDegrDivCd(String endDegrDivCd) { set("endDegrDivCd",endDegrDivCd);}
	/** get 최종학위구분코드 : endDegrDivCd */
	public String getEndDegrDivCd() { return (String)get("endDegrDivCd");}
	/** set 승진예정일자 : pmtnScduDt */
	public void setPmtnScduDt(String pmtnScduDt) { set("pmtnScduDt",pmtnScduDt);}
	/** get 승진예정일자 : pmtnScduDt */
	public String getPmtnScduDt() { return (String)get("pmtnScduDt");}
	/** set 호봉승급예정일자 : pyspPrmtnScduDt */
	public void setPyspPrmtnScduDt(String pyspPrmtnScduDt) { set("pyspPrmtnScduDt",pyspPrmtnScduDt);}
	/** get 호봉승급예정일자 : pyspPrmtnScduDt */
	public String getPyspPrmtnScduDt() { return (String)get("pyspPrmtnScduDt");}
	/** set 재고용예정일자 : reymnScduDt */
	public void setReymnScduDt(String reymnScduDt) { set("reymnScduDt",reymnScduDt);}
	/** get 재고용예정일자 : reymnScduDt */
	public String getReymnScduDt() { return (String)get("reymnScduDt");}
	/** set 근속년수 : logSvcYrNumCd */
	public void setLogSvcYrNumCd(String logSvcYrNumCd) { set("logSvcYrNumCd",logSvcYrNumCd);}
	/** get 근속년수 : logSvcYrNumCd */
	public String getLogSvcYrNumCd() { return (String)get("logSvcYrNumCd");}
	/** set 근속월수 : logSvcMnthIcmCd */
	public void setLogSvcMnthIcmCd(String logSvcMnthIcmCd) { set("logSvcMnthIcmCd",logSvcMnthIcmCd);}
	/** get 근속월수 : logSvcMnthIcmCd */
	public String getLogSvcMnthIcmCd() { return (String)get("logSvcMnthIcmCd");}
	/** set 현_호봉발령일자 : currPyspAppmtDt */
	public void setCurrPyspAppmtDt(String currPyspAppmtDt) { set("currPyspAppmtDt",currPyspAppmtDt);}
	/** get 현_호봉발령일자 : currPyspAppmtDt */
	public String getCurrPyspAppmtDt() { return (String)get("currPyspAppmtDt");}
	/** set 현_부서발령일자 : currDeptAppmtDt */
	public void setCurrDeptAppmtDt(String currDeptAppmtDt) { set("currDeptAppmtDt",currDeptAppmtDt);}
	/** get 현_부서발령일자 : currDeptAppmtDt */
	public String getCurrDeptAppmtDt() { return (String)get("currDeptAppmtDt");}
	/** set 인사비고내용 : pernNoteCtnt */
	public void setPernNoteCtnt(String pernNoteCtnt) { set("pernNoteCtnt",pernNoteCtnt);}
	/** get 인사비고내용 : pernNoteCtnt */
	public String getPernNoteCtnt() { return (String)get("pernNoteCtnt");}
	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) { set("kybdr",kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String)get("kybdr");}
	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) { set("inptDt",inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String)get("inptDt");}
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String)get("inptAddr");}
	/** set 수정자 : ismt */
	public void setIsmt(String ismt) { set("ismt",ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String)get("ismt");}
	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String)get("revnDt");}
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String)get("revnAddr");}
	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String pyspGrdeCd) { set("pyspGrdeCd",pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String getPyspGrdeCd() { return (String)get("pyspGrdeCd");}
	/** set 직종세구분코드 : dtilOccuClsDivCd */
	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) { set("dtilOccuClsDivCd",dtilOccuClsDivCd);}
	/** get 직종세구분코드 : dtilOccuClsDivCd */
	public String getDtilOccuClsDivCd() { return (String)get("dtilOccuClsDivCd");}
	
	
	/** set 사업코드 : businCd */
	public void setBusinNm(String businNm) { set("businNm",businNm);}
	/** get 사업코드 : businCd */
	public String getBusinNm() { return (String)get("businNm");}
	
	//PSNL0110 
	/** set 현근무지 */
	public void setCurrPaeWorkNm(String currPaeWorkNm) {set("currPaeWorkNm",currPaeWorkNm);}
	/** get 현근무지 */
	public String getCurrPaeWorkNm(){return (String)get("currPaeWorkNm");};
	
	
	public void setWorkym(String workym) { set("workym", workym);}
	public String getWorkym(){return (String)get("workym");};
	
	//PSNL0125
	/** 파일등록을 파일명 */
	public void setPicFlnm(String picFlnm) {set("picFlnm",picFlnm);}
	/** 파일등록을 파일명 */
	public String getPicFlnm(){return (String)get("picFlnm");};
}
