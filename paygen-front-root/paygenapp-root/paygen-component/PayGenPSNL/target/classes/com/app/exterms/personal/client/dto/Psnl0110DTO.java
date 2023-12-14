package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0110DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	public Psnl0110DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	//그리드에서 사용시 DATE가 필요로 하고 등록 수정 할 경우 VARCHAR로 되어있으므로... 임시 필드 추가
	//고용시작일자 : emymtBgnnDtStr (String 형식의 데이터가 필요할 경우)
	public void setEmymtBgnnDtStr(String emymtBgnnDtStr) { set("emymtBgnnDtStr",emymtBgnnDtStr);}
	public String getEmymtBgnnDtStr() { return get("emymtBgnnDtStr");}
		
	//고용종료일자 : emymtEndDtStr (String 형식의 데이터가 필요할 경우)
	public void setEmymtEndDtStr(String emymtEndDtStr) { set("emymtEndDtStr",emymtEndDtStr);}
	public String getEmymtEndDtStr() { return get("emymtEndDtStr");}
	
	//순번이 필요할경우
	public void setRnum(String rnum) { set("rnum", rnum); }
	public String getRnum(){return (String)get("rnum");}
		
	
	public void setDataChk(String dataChk) { set("dataChk", dataChk); }
	public String getDataChk(){return (String)get("dataChk");}
		
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	
	//고용일련번호 : emymtSeilNum
	public void setEmymtSeilNum(String emymtSeilNum) { set("emymtSeilNum",emymtSeilNum);}
	public String getEmymtSeilNum() { return (String)get("emymtSeilNum");}
	
	//고용구분코드 : emymtDivCd
	public void setEmymtDivCd(String emymtDivCd) { set("emymtDivCd",emymtDivCd);}
	public String getEmymtDivCd() { return (String)get("emymtDivCd");}
	
	
	public void setEmymtTypCd(String emymtTypCd) { set("emymtTypCd",emymtTypCd);}
	public String getEmymtTypCd() { return (String)get("emymtTypCd");}
	
	public void setEmymtTypNm(String emymtTypNm) { set("emymtTypNm",emymtTypNm);}
	public String getEmymtTypNm() { return (String)get("emymtTypNm");}
	
	//고용유형코드 : emymtTypCd
	public void setEmymtNewTypCd(String emymtNewTypCd) { set("emymtNewTypCd",emymtNewTypCd);}
	public String getEmymtNewTypCd() { return (String)get("emymtNewTypCd");}
	
	//고용유형코드 : emymtTypCd
	public void setEmymtNewTypNm(String emymtNewTypNm) { set("emymtNewTypNm",emymtNewTypNm);}
	public String getEmymtNewTypNm() { return (String)get("emymtNewTypNm");}
	
	//고용시작일자 : emymtBgnnDt
	public void setEmymtBgnnDt(Date emymtBgnnDt) { set("emymtBgnnDt",emymtBgnnDt);}
	public Date getEmymtBgnnDt() { return get("emymtBgnnDt");}
	
	//부서코드 : deptCd
	public void setDeptCd(String deptCd) { set("deptCd",deptCd);}
	public String getDeptCd() { return (String)get("deptCd");}
	
	//부서 : deptNm
    public void setDeptNm(String deptNm) { set("deptNm",deptNm);}
    public String getDeptNm() { return (String)get("deptNm");}
    
    
	public void setMangeDeptCd(String mangeDeptCd) { set("mangeDeptCd",mangeDeptCd);}
	public String getMangeDeptCd() { return (String)get("mangeDeptCd");}
	
	public void setMangeDeptNm(String mangeDeptNm) { set("mangeDeptNm",mangeDeptNm);}
	public String getMangeDeptNm() { return (String)get("mangeDeptNm");}
	
	public void setCurrAffnDeptCd(String currAffnDeptCd) { set("currAffnDeptCd",currAffnDeptCd);}
	public String getCurrAffnDeptCd() { return (String)get("currAffnDeptCd");}
	
	public void setCurrAffnDeptNm(String currAffnDeptNm) { set("currAffnDeptNm",currAffnDeptNm);}
	public String getCurrAffnDeptNm() { return (String)get("currAffnDeptNm");}
	
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	
	
	/** set 한문성명 : chinCharNm */
	public void setChinCharNm(String chinCharNm) { set("chinCharNm",chinCharNm);}
	/** get 한문성명 : chinCharNm */
	public String getChinCharNm() { return (String)get("chinCharNm");}
	
	
	
	/** set 한글성명 : hanNm */
	public void setHanNm(String hanNm) { set("hanNm",hanNm);}
	/** get 한글성명 : hanNm */
	public String getHanNm() { return (String)get("hanNm");}
	
	
	/** set 사업코드 : businCd */
	public void setBusinNm(String businNm) { set("businNm",businNm);}
	/** get 사업코드 : businCd */
	public String getBusinNm() { return (String)get("businNm");}
	
    
    
	//현근무지명 : currPaeWorkNm
	public void setCurrPaeWorkNm(String currPaeWorkNm) { set("currPaeWorkNm",currPaeWorkNm);}
	public String getCurrPaeWorkNm() { return (String)get("currPaeWorkNm");}
	
	//사업코드 : businCd
	public void setBusinCd(String businCd) { set("businCd",businCd);}
	public String getBusinCd() { return (String)get("businCd");}
	
	//사업코드 : businCd
	public void setBusinApptnYr(String businApptnYr) { set("businApptnYr",businApptnYr);}
	public String getBusinApptnYr() { return (String)get("businApptnYr");}
	
	//직종코드 : typComboOccuCd
    public void setTypComboOccuCd(String typComboOccuCd) { set("typComboOccuCd",typComboOccuCd);}
    public String getTypComboOccuCd() { return (String)get("typComboOccuCd");}
	//직종코드 : typOccuCd
	public void setTypOccuCd(String typOccuCd) { set("typOccuCd",typOccuCd);}
	public String getTypOccuCd() { return (String)get("typOccuCd");}
	
	//직종세구분코드 : dtilOccuClsDivCd
	public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) { set("dtilOccuClsDivCd",dtilOccuClsDivCd);}
	public String getDtilOccuClsDivCd() { return (String)get("dtilOccuClsDivCd");}
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String dtilOccuInttnCd) { set("dtilOccuInttnCd",dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String getDtilOccuInttnCd() { return (String)get("dtilOccuInttnCd");}
	
	//직책코드 : odtyCd
	public void setOdtyCd(String odtyCd) { set("odtyCd",odtyCd);}
	public String getOdtyCd() { return (String)get("odtyCd");}
	//급여지급구분코드 : payPymtDivCd
	public void setPayPymtDivCd(String payPymtDivCd) { set("payPymtDivCd",payPymtDivCd);}
	public String getPayPymtDivCd() { return (String)get("payPymtDivCd");}
	//고용금액 : emymtSum
	public void setEmymtSum(String emymtSum) { set("emymtSum",emymtSum);}
	public String getEmymtSum() { return (String)get("emymtSum");}
	//고용사유내용 : emymtReasCtnt
	public void setEmymtReasCtnt(String emymtReasCtnt) { set("emymtReasCtnt",emymtReasCtnt);}
	public String getEmymtReasCtnt() { return (String)get("emymtReasCtnt");}
	//증번호 : certNumHuhd
	public void setCertNumHuhd(String certNumHuhd) { set("certNumHuhd",certNumHuhd);}
	public String getCertNumHuhd() { return (String)get("certNumHuhd");}
	//경감시작일자 : rducBgnnDt
	public void setRducBgnnDt(String rducBgnnDt) { set("rducBgnnDt",rducBgnnDt);}
	public String getRducBgnnDt() { return (String)get("rducBgnnDt");}
	//입력자 : kybdr
	public void setKybdr(String kybdr) { set("kybdr",kybdr);}
	public String getKybdr() { return (String)get("kybdr");}
	//입력일자 : inptDt
	public void setInptDt(String inptDt) { set("inptDt",inptDt);}
	public String getInptDt() { return (String)get("inptDt");}
	//입력주소 : inptAddr
	public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
	public String getInptAddr() { return (String)get("inptAddr");}
	//수정자 : ismt
	public void setIsmt(String ismt) { set("ismt",ismt);}
	public String getIsmt() { return (String)get("ismt");}
	//수정일자 : revnDt
	public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
	public String getRevnDt() { return (String)get("revnDt");}
	//수정주소 : revnAddr
	public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
	public String getRevnAddr() { return (String)get("revnAddr");}
	//경감종료일자 : rducEndDt
	public void setRducEndDt(String rducEndDt) { set("rducEndDt",rducEndDt);}
	public String getRducEndDt() { return (String)get("rducEndDt");}
	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String pyspGrdeCd) { set("pyspGrdeCd",pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String getPyspGrdeCd() { return (String)get("pyspGrdeCd");}
	
	/** set 직종세통합코드 : tempDtilOccuInttnCd */
	public void setTempDtilOccuInttnCd(String tempDtilOccuInttnCd) { set("tempDtilOccuInttnCd",tempDtilOccuInttnCd);}
	/** get 직종세통합코드 : tempDtilOccuInttnCd */
	public String getTempDtilOccuInttnCd() { return (String)get("tempDtilOccuInttnCd");}
	
	/** set 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	public void setAddIncmTxApptnRtoCd(String  addIncmTxApptnRtoCd) { set( "addIncmTxApptnRtoCd" ,addIncmTxApptnRtoCd);}
	/** get 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
	public String  getAddIncmTxApptnRtoCd() { return (String )get( "addIncmTxApptnRtoCd" );}

	
	//고용종료일자 : emymtEndDt
	public void setEmymtEndDt(Date emymtEndDt) { set("emymtEndDt",emymtEndDt);}
	public Date getEmymtEndDt() { return get("emymtEndDt");}
	
	
	 /** set column 퇴직사유내용 : retryReasCtnt */
	public void setRetryReasCtnt(String  retryReasCtnt) { set( "retryReasCtnt" ,retryReasCtnt);}
	 /**get column 퇴직사유내용 : retryReasCtnt */
	public String  getRetryReasCtnt() { return (String )get( "retryReasCtnt" );}
	
	 /** set column 퇴직이직사유구분코드 : retryDivCd  */
	public void setRetryDivCd(String  retryDivCd) { set( "retryDivCd" ,retryDivCd);}
	 /**get column 퇴직이직사유구분코드 : retryDivCd  */
	public String  getRetryDivCd() { return (String )get( "retryDivCd" );}
	
	
	// psnl0111
	/** set 집도로명우편번호 : husRoadNmZpcd */
	public void setHusRoadNmZpcd(String husRoadNmZpcd) { set("husRoadNmZpcd",husRoadNmZpcd);}
	/** get 집도로명우편번호 : husRoadNmZpcd */
	public String getHusRoadNmZpcd() { return (String)get("husRoadNmZpcd");}
	/** set 집도로명기본주소 : husRoadNmFndtnAddr */
	public void setHusRoadNmFndtnAddr(String husRoadNmFndtnAddr) { set("husRoadNmFndtnAddr",husRoadNmFndtnAddr);}
	/** get 집도로명기본주소 : husRoadNmFndtnAddr */
	public String getHusRoadNmFndtnAddr() { return (String)get("husRoadNmFndtnAddr");}
	/** set 집도로명상세주소 : husRoadNmDtlPatrAddr */
	public void setHusRoadNmDtlPatrAddr(String husRoadNmDtlPatrAddr) { set("husRoadNmDtlPatrAddr",husRoadNmDtlPatrAddr);}
	/** get 집도로명상세주소 : husRoadNmDtlPatrAddr */
	public String getHusRoadNmDtlPatrAddr() { return (String)get("husRoadNmDtlPatrAddr");}
	/** set 집전화번호 : husPhnNum */
	public void setHusPhnNum(String husPhnNum) { set("husPhnNum",husPhnNum);}
	/** get 집전화번호 : husPhnNum */
	public String getHusPhnNum() { return (String)get("husPhnNum");}
	/** set 핸드폰번호 : cellPhneNum */
	public void setCellPhneNum(String cellPhneNum) { set("cellPhneNum",cellPhneNum);}
	/** get 핸드폰번호 : cellPhneNum */
	public String getCellPhneNum() { return (String)get("cellPhneNum");}
	
	// psnl0113
	
	//장애구분코드 : dabtyDivCd
	public void setDabtyDivCd(String dabtyDivCd) { set("dabtyDivCd",dabtyDivCd);}
	public String getDabtyDivCd() { return (String)get("dabtyDivCd");}
	
	//장애등급코드 : dabtyGrdeCd
	public void setDabtyGrdeCd(String dabtyGrdeCd) { set("dabtyGrdeCd",dabtyGrdeCd);}
	public String getDabtyGrdeCd() { return (String)get("dabtyGrdeCd");}

	//장애판정일자 : dabtyAjmtDt
	public void setDabtyAjmtDt(String dabtyAjmtDt) { set("dabtyAjmtDt",dabtyAjmtDt);}
	public String getDabtyAjmtDt() { return (String)get("dabtyAjmtDt");}
	
	//일근로시간 : workHourStandard
	public void setWorkHourStandard(String workHourStandard) { set("workHourStandard",workHourStandard);}
	public String getWorkHourStandard() { return (String)get("workHourStandard");}
}
