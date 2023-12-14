package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0119DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	public Psnl0119DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//경력사항일련번호 : carrRsptSeilNum
	public void setCarrRsptSeilNum(String carrRsptSeilNum) { set("carrRsptSeilNum",carrRsptSeilNum);}
	public String getCarrRsptSeilNum() { return (String)get("carrRsptSeilNum");}
	
	//경력시작일자 : carrBgnnDt
	public void setCarrBgnnDt(Date carrBgnnDt) { set("carrBgnnDt",carrBgnnDt);}
	public Date getCarrBgnnDt() { return get("carrBgnnDt");}
	//경력종료일자 : carrEndDt
	public void setCarrEndDt(Date carrEndDt) { set("carrEndDt",carrEndDt);}
	public Date getCarrEndDt() { return get("carrEndDt");}
	
	
	//근무처명 : paeWorkNm
	public void setPaeWorkNm(String paeWorkNm) { set("paeWorkNm",paeWorkNm);}
	public String getPaeWorkNm() { return (String)get("paeWorkNm");}
	//경력구분코드 : carrDivCd
	public void setCarrDivCd(String carrDivCd) { set("carrDivCd",carrDivCd);}
	public String getCarrDivCd() { return (String)get("carrDivCd");}
	//근무부서명 : dutyDeptNm
	public void setDutyDeptNm(String dutyDeptNm) { set("dutyDeptNm",dutyDeptNm);}
	public String getDutyDeptNm() { return (String)get("dutyDeptNm");}
	//담당업무명 : repbtyBusinNm
	public void setRepbtyBusinNm(String repbtyBusinNm) { set("repbtyBusinNm",repbtyBusinNm);}
	public String getRepbtyBusinNm() { return (String)get("repbtyBusinNm");}
	//직책명 : odtyNm
	public void setOdtyNm(String odtyNm) { set("odtyNm",odtyNm);}
	public String getOdtyNm() { return (String)get("odtyNm");}
	//임금일당금액 : amntDlywagSum
	public void setAmntDlywagSum(String amntDlywagSum) { set("amntDlywagSum",amntDlywagSum);}
	public String getAmntDlywagSum() { return (String)get("amntDlywagSum");}
	//경력비고내용 : carrNoteCtnt
	public void setCarrNoteCtnt(String carrNoteCtnt) { set("carrNoteCtnt",carrNoteCtnt);}
	public String getCarrNoteCtnt() { return (String)get("carrNoteCtnt");}
	//근무년수 : dutyYrNum
	public void setDutyYrNum(String dutyYrNum) { set("dutyYrNum",dutyYrNum);}
	public String getDutyYrNum() { return (String)get("dutyYrNum");}
	//근무월수 : dutyMnthIcm
	public void setDutyMnthIcm(String dutyMnthIcm) { set("dutyMnthIcm",dutyMnthIcm);}
	public String getDutyMnthIcm() { return (String)get("dutyMnthIcm");}
	//환산비율 : cvsnRto
	public void setCvsnRto(String cvsnRto) { set("cvsnRto",cvsnRto);}
	public String getCvsnRto() { return (String)get("cvsnRto");}
	//환산비율구분코드 : cvsnRtoDivCd
	public void setCvsnRtoDivCd(String cvsnRtoDivCd) { set("cvsnRtoDivCd",cvsnRtoDivCd);}
	public String getCvsnRtoDivCd() { return (String)get("cvsnRtoDivCd");}
	//가감월수 : ajmtMnthNum
	public void setAjmtMnthNum(String ajmtMnthNum) { set("ajmtMnthNum",ajmtMnthNum);}
	public String getAjmtMnthNum() { return (String)get("ajmtMnthNum");}
	//인정월수 : rcgtnMnthNum
	public void setRcgtnMnthNum(String rcgtnMnthNum) { set("rcgtnMnthNum",rcgtnMnthNum);}
	public String getRcgtnMnthNum() { return (String)get("rcgtnMnthNum");}
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


}
