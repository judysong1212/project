package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0121DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	public Psnl0121DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//포상일련번호 : accldSeilNum
	public void setAccldSeilNum(String accldSeilNum) { set("accldSeilNum",accldSeilNum);}
	public String getAccldSeilNum() { return (String)get("accldSeilNum");}
	//포상년도 : accldYr
	public void setAccldYr(String accldYr) { set("accldYr",accldYr);}
	public String getAccldYr() { return (String)get("accldYr");}
	//포상수여일자 : accldPrttDt
	public void setAccldPrttDt(Date accldPrttDt) { set("accldPrttDt",accldPrttDt);}
	public Date getAccldPrttDt() { return get("accldPrttDt");}
	//포상종류코드 : accldKndCd
	public void setAccldKndCd(String accldKndCd) { set("accldKndCd",accldKndCd);}
	public String getAccldKndCd() { return (String)get("accldKndCd");}
	//포상구분코드 : accldDivCd
	public void setAccldDivCd(String accldDivCd) { set("accldDivCd",accldDivCd);}
	public String getAccldDivCd() { return (String)get("accldDivCd");}
	//포상명 : accldNm
	public void setAccldNm(String accldNm) { set("accldNm",accldNm);}
	public String getAccldNm() { return (String)get("accldNm");}
	//포상서훈번호 : accldCfmntNum
	public void setAccldCfmntNum(String accldCfmntNum) { set("accldCfmntNum",accldCfmntNum);}
	public String getAccldCfmntNum() { return (String)get("accldCfmntNum");}
	//시행기관명 : efmnIstutNm
	public void setEfmnIstutNm(String efmnIstutNm) { set("efmnIstutNm",efmnIstutNm);}
	public String getEfmnIstutNm() { return (String)get("efmnIstutNm");}
	//포상주체내용 : accldMnantCtnt
	public void setAccldMnantCtnt(String accldMnantCtnt) { set("accldMnantCtnt",accldMnantCtnt);}
	public String getAccldMnantCtnt() { return (String)get("accldMnantCtnt");}
	//포상비고내용 : accldNoteCtnt
	public void setAccldNoteCtnt(String accldNoteCtnt) { set("accldNoteCtnt",accldNoteCtnt);}
	public String getAccldNoteCtnt() { return (String)get("accldNoteCtnt");}
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
