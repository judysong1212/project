package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0122DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	public Psnl0122DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//징계일련번호 : dsnyActSeilNum
	public void setDsnyActSeilNum(String dsnyActSeilNum) { set("dsnyActSeilNum",dsnyActSeilNum);}
	public String getDsnyActSeilNum() { return (String)get("dsnyActSeilNum");}
	
	//징계처분일자 : dsnyActDsplDt
	public void setDsnyActDsplDt(Date dsnyActDsplDt) { set("dsnyActDsplDt",dsnyActDsplDt);}
	public Date getDsnyActDsplDt() { return get("dsnyActDsplDt");}
	
	//징계구분코드 : dsnyActDivCd
	public void setDsnyActDivCd(String dsnyActDivCd) { set("dsnyActDivCd",dsnyActDivCd);}
	public String getDsnyActDivCd() { return (String)get("dsnyActDivCd");}
	//징계명 : dsnyActNm
	public void setDsnyActNm(String dsnyActNm) { set("dsnyActNm",dsnyActNm);}
	public String getDsnyActNm() { return (String)get("dsnyActNm");}
	//징계사유내용 : dsnyActReasCtnt
	public void setDsnyActReasCtnt(String dsnyActReasCtnt) { set("dsnyActReasCtnt",dsnyActReasCtnt);}
	public String getDsnyActReasCtnt() { return (String)get("dsnyActReasCtnt");}
	//징계수행기관 : dsnyActEctgOrgn
	public void setDsnyActEctgOrgn(String dsnyActEctgOrgn) { set("dsnyActEctgOrgn",dsnyActEctgOrgn);}
	public String getDsnyActEctgOrgn() { return (String)get("dsnyActEctgOrgn");}
	//징계비고내용 : dsnyActNoteCtnt
	public void setDsnyActNoteCtnt(String dsnyActNoteCtnt) { set("dsnyActNoteCtnt",dsnyActNoteCtnt);}
	public String getDsnyActNoteCtnt() { return (String)get("dsnyActNoteCtnt");}
	
	//징계시작일자 : dsnyActBgnnDt
	public void setDsnyActBgnnDt(Date dsnyActBgnnDt) { set("dsnyActBgnnDt",dsnyActBgnnDt);}
	public Date getDsnyActBgnnDt() { return get("dsnyActBgnnDt");}
	//징계종료일자 : dsnyActEndDt
	public void setDsnyActEndDt(Date dsnyActEndDt) { set("dsnyActEndDt",dsnyActEndDt);}
	public Date getDsnyActEndDt() { return get("dsnyActEndDt");}
	
	//징계감봉율 : dsnyActCtwpRate
	public void setDsnyActCtwpRate(String dsnyActCtwpRate) { set("dsnyActCtwpRate",dsnyActCtwpRate);}
	public String getDsnyActCtwpRate() { return (String)get("dsnyActCtwpRate");}
	//징계감봉월수 : dsnyActCtwpMnthIcm
	public void setDsnyActCtwpMnthIcm(String dsnyActCtwpMnthIcm) { set("dsnyActCtwpMnthIcm",dsnyActCtwpMnthIcm);}
	public String getDsnyActCtwpMnthIcm() { return (String)get("dsnyActCtwpMnthIcm");}
	
	//징계사면일자 : dsnyActAnstyDt
	public void setDsnyActAnstyDt(Date dsnyActAnstyDt) { set("dsnyActAnstyDt",dsnyActAnstyDt);}
	public Date getDsnyActAnstyDt() { return get("dsnyActAnstyDt");}
	
	//징계사면구분코드 : dsnyActAnstyDivCd
	public void setDsnyActAnstyDivCd(String dsnyActAnstyDivCd) { set("dsnyActAnstyDivCd",dsnyActAnstyDivCd);}
	public String getDsnyActAnstyDivCd() { return (String)get("dsnyActAnstyDivCd");}
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
