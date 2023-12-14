package com.app.exterms.personal.client.dto;


import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0117DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	
	public Psnl0117DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//전력일련번호 : orcrdSeilNum
	public void setOrcrdSeilNum(String orcrdSeilNum) { set("orcrdSeilNum",orcrdSeilNum);}
	public String getOrcrdSeilNum() { return (String)get("orcrdSeilNum");}
	//전력_근무시작일자 : orcrdDutyBgnnDt
	public void setOrcrdDutyBgnnDt(String orcrdDutyBgnnDt) { set("orcrdDutyBgnnDt",orcrdDutyBgnnDt);}
	public String getOrcrdDutyBgnnDt() { return (String)get("orcrdDutyBgnnDt");}
	//전력_근무종료일자 : orcrdDutyEndDt
	public void setOrcrdDutyEndDt(String orcrdDutyEndDt) { set("orcrdDutyEndDt",orcrdDutyEndDt);}
	public String getOrcrdDutyEndDt() { return (String)get("orcrdDutyEndDt");}
	//전력_근무처명 : orcrdPaeWorkNm
	public void setOrcrdPaeWorkNm(String orcrdPaeWorkNm) { set("orcrdPaeWorkNm",orcrdPaeWorkNm);}
	public String getOrcrdPaeWorkNm() { return (String)get("orcrdPaeWorkNm");}
	//전력_직책명 : orcrdOdtyNm
	public void setOrcrdOdtyNm(String orcrdOdtyNm) { set("orcrdOdtyNm",orcrdOdtyNm);}
	public String getOrcrdOdtyNm() { return (String)get("orcrdOdtyNm");}
	//전력_담당사무 : orcrdRepbtyPrvaff
	public void setOrcrdRepbtyPrvaff(String orcrdRepbtyPrvaff) { set("orcrdRepbtyPrvaff",orcrdRepbtyPrvaff);}
	public String getOrcrdRepbtyPrvaff() { return (String)get("orcrdRepbtyPrvaff");}
	//전력_비고내용 : orcrdNoteCtnt
	public void setOrcrdNoteCtnt(String orcrdNoteCtnt) { set("orcrdNoteCtnt",orcrdNoteCtnt);}
	public String getOrcrdNoteCtnt() { return (String)get("orcrdNoteCtnt");}
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
