package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0116DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	
	public Psnl0116DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//학력사항일련번호 : acadAbtySeilNum
	public void setAcadAbtySeilNum(String acadAbtySeilNum) { set("acadAbtySeilNum",acadAbtySeilNum);}
	public String getAcadAbtySeilNum() { return (String)get("acadAbtySeilNum");}
	
	//입학일자 : etncItshlDt
	public void setEtncItshlDt(Date etncItshlDt) { set("etncItshlDt",etncItshlDt);}
	public Date getEtncItshlDt() { return get("etncItshlDt");}
	//졸업일자 : grdtnDt
	public void setGrdtnDt(Date grdtnDt) { set("grdtnDt",grdtnDt);}
	public Date getGrdtnDt() { return get("grdtnDt");}
	
	//학력구분코드 : acadAbtyDivCd
	public void setAcadAbtyDivCd(String acadAbtyDivCd) { set("acadAbtyDivCd",acadAbtyDivCd);}
	public String getAcadAbtyDivCd() { return (String)get("acadAbtyDivCd");}
	//학교코드 : schlCd
	public void setSchlCdNm(String schlCdNm) { set("schlCdNm",schlCdNm);}
	public String getSchlCdNm() { return (String)get("schlCdNm");}
	//학교코드 : schlCdNm
	public void setSchlCd(String schlCd) { set("schlCd",schlCd);}
	public String getSchlCd() { return (String)get("schlCd");}
	//학과코드 : deprMajrCd
	public void setDeprMajrCd(String deprMajrCd) { set("deprMajrCd",deprMajrCd);}
	public String getDeprMajrCd() { return (String)get("deprMajrCd");}
	//학과 : deprMajrNm
    public void setDeprMajrNm(String deprMajrNm) { set("deprMajrNm",deprMajrNm);}
    public String getDeprMajrNm() { return (String)get("deprMajrNm");}
	//전공명 : mjrSpctyNm
	public void setMjrSpctyNm(String mjrSpctyNm) { set("mjrSpctyNm",mjrSpctyNm);}
	public String getMjrSpctyNm() { return (String)get("mjrSpctyNm");}
	//부전공명 : mnrNm
	public void setMnrNm(String mnrNm) { set("mnrNm",mnrNm);}
	public String getMnrNm() { return (String)get("mnrNm");}
	//국가코드 : natnCd
	public void setNatnCd(String natnCd) { set("natnCd",natnCd);}
	public String getNatnCd() { return (String)get("natnCd");}
	//학위명 : degrNm
	public void setDegrNm(String degrNm) { set("degrNm",degrNm);}
	public String getDegrNm() { return (String)get("degrNm");}
	//학위구분코드 : degrDivCd
	public void setDegrDivCd(String degrDivCd) { set("degrDivCd",degrDivCd);}
	public String getDegrDivCd() { return (String)get("degrDivCd");}
	//학위취득일자 : degrAqtnDt
	public void setDegrAqtnDt(String degrAqtnDt) { set("degrAqtnDt",degrAqtnDt);}
	public String getDegrAqtnDt() { return (String)get("degrAqtnDt");}
	//수업년수코드 : lesnYrNumCd
	public void setLesnYrNumCd(String lesnYrNumCd) { set("lesnYrNumCd",lesnYrNumCd);}
	public String getLesnYrNumCd() { return (String)get("lesnYrNumCd");}
	//학력비고내용 : acadAbtyNoteCtnt
	public void setAcadAbtyNoteCtnt(String acadAbtyNoteCtnt) { set("acadAbtyNoteCtnt",acadAbtyNoteCtnt);}
	public String getAcadAbtyNoteCtnt() { return (String)get("acadAbtyNoteCtnt");}
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
