package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0123DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	public Psnl0123DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//휴직일련번호 : levfAbncSeilNum
	public void setLevfAbncSeilNum(String levfAbncSeilNum) { set("levfAbncSeilNum",levfAbncSeilNum);}
	public String getLevfAbncSeilNum() { return (String)get("levfAbncSeilNum");}
	//휴직구분코드 : levfAbncDivCd
	public void setLevfAbncDivCd(String levfAbncDivCd) { set("levfAbncDivCd",levfAbncDivCd);}
	public String getLevfAbncDivCd() { return (String)get("levfAbncDivCd");}
	
	//휴직시작일자 : levfAbncBgnnDt
	public void setLevfAbncBgnnDt(Date levfAbncBgnnDt) { set("levfAbncBgnnDt",levfAbncBgnnDt);}
	public Date getLevfAbncBgnnDt() { return get("levfAbncBgnnDt");}
	//휴직종료일자 : levfAbncEndDt
	public void setLevfAbncEndDt(Date levfAbncEndDt) { set("levfAbncEndDt",levfAbncEndDt);}
	public Date getLevfAbncEndDt() { return get("levfAbncEndDt");}
	//실제복직일자 : turtyRntmntDt
	public void setTurtyRntmntDt(Date turtyRntmntDt) { set("turtyRntmntDt",turtyRntmntDt);}
	public Date getTurtyRntmntDt() { return get("turtyRntmntDt");}
	
	//휴직비고내용 : levfAbncNoteCtnt
	public void setLevfAbncNoteCtnt(String levfAbncNoteCtnt) { set("levfAbncNoteCtnt",levfAbncNoteCtnt);}
	public String getLevfAbncNoteCtnt() { return (String)get("levfAbncNoteCtnt");}
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
