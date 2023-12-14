package com.app.smrmf.infc.sysif.msfpackage.client.form.dto;


import com.extjs.gxt.ui.client.data.BaseModelData;

public class SysIfPsnl0115DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	
	public SysIfPsnl0115DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	
	//가족일련번호 : famySeilNum
	public void setFamySeilNum(String famySeilNum) { set("famySeilNum",famySeilNum);}
	public String getFamySeilNum() { return (String)get("famySeilNum");}
	
	//가족관계구분코드 : famyRelaDivCd
	public void setFamyRelaDivCd(String famyRelaDivCd) { set("famyRelaDivCd",famyRelaDivCd);}
	public String getFamyRelaDivCd() { return (String)get("famyRelaDivCd");}
	
	//가족성명 : famyNm
	public void setFamyNm(String famyNm) { set("famyNm",famyNm);}
	public String getFamyNm() { return (String)get("famyNm");}
	
	//가족주민등록번호 : famyResnRegnNum
	public void setFamyResnRegnNum(String famyResnRegnNum) { set("famyResnRegnNum",famyResnRegnNum);}
	public String getFamyResnRegnNum() { return (String)get("famyResnRegnNum");}
	
	//가족주민등록번호 : famySecRegnNum
	public void setFamySecRegnNum(String famySecRegnNum) { set("famySecRegnNum",famySecRegnNum);}
	public String getFamySecRegnNum() { return (String)get("famySecRegnNum");}
	
	//생년월일 : yoobhMnthDay
	public void setYoobhMnthDay(String yoobhMnthDay) { set("yoobhMnthDay",yoobhMnthDay);}
	public String getYoobhMnthDay() { return (String)get("yoobhMnthDay");}
	
	//음양구분코드 : sclcDivCd
	public void setSclcDivCd(String sclcDivCd) { set("sclcDivCd",sclcDivCd);}
	public String getSclcDivCd() { return (String)get("sclcDivCd");}
	
	//학력구분코드 : acadAbtyDivCd
	public void setAcadAbtyDivCd(String acadAbtyDivCd) { set("acadAbtyDivCd",acadAbtyDivCd);}
	public String getAcadAbtyDivCd() { return (String)get("acadAbtyDivCd");}
	
	//학교명 : schlNm
	public void setSchlNm(String schlNm) { set("schlNm",schlNm);}
	public String getSchlNm() { return (String)get("schlNm");}
	
	//직업명 : crrCd
	public void setCrrCd(String crrCd) { set("crrCd",crrCd);}
	public String getCrrCd() { return (String)get("crrCd");}
	
	//직장명 : wkOfcNm
	public void setWkOfcNm(String wkOfcNm) { set("wkOfcNm",wkOfcNm);}
	public String getWkOfcNm() { return (String)get("wkOfcNm");}
	
	//직위명 : inbyNm
	public void setInbyNm(String inbyNm) { set("inbyNm",inbyNm);}
	public String getInbyNm() { return (String)get("inbyNm");}
	
	//외국인여부 : frgnrYn
	public void setFrgnrYn(String frgnrYn) { set("frgnrYn",frgnrYn);}
	public String getFrgnrYn() { return (String)get("frgnrYn");}
	
	//장애구분코드 : dabtyDivCd
	public void setDabtyDivCd(String dabtyDivCd) { set("dabtyDivCd",dabtyDivCd);}
	public String getDabtyDivCd() { return (String)get("dabtyDivCd");}
	
	//장애등급코드 : dabtyGrdeCd
	public void setDabtyGrdeCd(String dabtyGrdeCd) { set("dabtyGrdeCd",dabtyGrdeCd);}
	public String getDabtyGrdeCd() { return (String)get("dabtyGrdeCd");}
	
	//가족사항비고내용 : famyPartNoteCtnt
	public void setFamyPartNoteCtnt(String famyPartNoteCtnt) { set("famyPartNoteCtnt",famyPartNoteCtnt);}
	public String getFamyPartNoteCtnt() { return (String)get("famyPartNoteCtnt");}
	
	//국가코드 : natnCd
	public void setNatnCd(String natnCd) { set("natnCd",natnCd);}
	public String getNatnCd() { return (String)get("natnCd");}
	
	//가족동거여부 : famyChbttYn
	public void setFamyChbttYn(String famyChbttYn) { set("famyChbttYn",famyChbttYn);}
	public String getFamyChbttYn() { return (String)get("famyChbttYn");}
	
	//가족수당여부 : famyAllwYn
	public void setFamyAllwYn(String famyAllwYn) { set("famyAllwYn",famyAllwYn);}
	public String getFamyAllwYn() { return (String)get("famyAllwYn");}
	
	//학비보조여부 : schlExpnAdmclYn
	public void setSchlExpnAdmclYn(String schlExpnAdmclYn) { set("schlExpnAdmclYn",schlExpnAdmclYn);}
	public String getSchlExpnAdmclYn() { return (String)get("schlExpnAdmclYn");}
	
	//연말정산여부 : yrtxYn
	public void setYrtxYn(String yrtxYn) { set("yrtxYn",yrtxYn);}
	public String getYrtxYn() { return (String)get("yrtxYn");}
	
	/** set 부양여부 : famySupptYn */
	public void setFamySupptYn(String  famySupptYn) { set( "famySupptYn" ,famySupptYn);}
	/** get 부양여부 : famySupptYn */
	public String  getFamySupptYn() { return (String )get( "famySupptYn" );}
	/** set 연말정산부양관계코드 : famySupptRelaDivCd */
	public void setFamySupptRelaDivCd(String  famySupptRelaDivCd) { set( "famySupptRelaDivCd" ,famySupptRelaDivCd);}
	/** get 연말정산부양관계코드 : famySupptRelaDivCd */
	public String  getFamySupptRelaDivCd() { return (String )get( "famySupptRelaDivCd" );}
	
	
	//연말정산여부 : yrtxYn 체크박스
	public void setYrtxYnChk(boolean yrtxYnChk){set("yrtxYnChk", yrtxYnChk);}
	public boolean getYrtxYnChk(){return (Boolean)get("yrtxYnChk");}
	
	/** set 부양여부 : famySupptYn */
	public void setFamySupptYnChk(boolean famySupptYnChk){set("famySupptYnChk", famySupptYnChk);}
	public boolean getFamySupptYnChk(){return (Boolean)get("famySupptYnChk");}
	
	
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
