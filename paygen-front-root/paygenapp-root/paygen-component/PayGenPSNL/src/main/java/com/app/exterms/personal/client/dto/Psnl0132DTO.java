package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Psnl0132DTO extends BaseModel{
	
	private static final Long serialVersionUID = 1L;
	
	public Psnl0132DTO(){}
	
	
	//순번이 필요할경우
	public void setRnum(String rnum) { set("rnum", rnum); }
	public String getRnum(){return (String)get("rnum");}
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	/** set 관련근거파일일련번호 : refeFlSeilNum */
	public void setRefeFlSeilNum(String  refeFlSeilNum) { set("refeFlSeilNum", refeFlSeilNum);}
	/** get 관련근거파일일련번호 : refeFlSeilNum */
	public String  getRefeFlSeilNum() { return (String )get("refeFlSeilNum");}
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set("dpobCd", dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get("dpobCd");}
	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set("systemkey", systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get("systemkey");}
	/** set 관련근거일련번호 : refeSeilNum */
	public void setRefeSeilNum(String  refeSeilNum) { set("refeSeilNum", refeSeilNum);}
	/** get 관련근거일련번호 : refeSeilNum */
	public String  getRefeSeilNum() { return (String )get("refeSeilNum");}
	/** set 관련근거파일명 : refeFlnm */
	public void setRefeFlnm(String  refeFlnm) { set("refeFlnm", refeFlnm);}
	/** get 관련근거파일명 : refeFlnm */
	public String  getRefeFlnm() { return (String )get("refeFlnm");}
	/** set 관련근거원본파일명 : refeOrgFlnm */
	public void setRefeOrgFlnm(String  refeOrgFlnm) { set("refeOrgFlnm", refeOrgFlnm);}
	/** get 관련근거원본파일명 : refeOrgFlnm */
	public String  getRefeOrgFlnm() { return (String )get("refeOrgFlnm");}
	/** set 관련근거파일경로 : refeFlcos */
	public void setRefeFlcos(String  refeFlcos) { set("refeFlcos", refeFlcos);}
	/** get 관련근거파일경로 : refeFlcos */
	public String  getRefeFlcos() { return (String )get("refeFlcos");}
	/** set 관련근거파일크기 : refeFlsz */
	public void setRefeFlsz(String  refeFlsz) { set("refeFlsz", refeFlsz);}
	/** get 관련근거파일크기 : refeFlsz */
	public String  getRefeFlsz() { return (String )get("refeFlsz");}
	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set("kybdr", kybdr);}
	/** get 입력자 : kybdr */
	public String  getKybdr() { return (String )get("kybdr");}
	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set("inptDt", inptDt);}
	/** get 입력일자 : inptDt */
	public String  getInptDt() { return (String )get("inptDt");}
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set("inptAddr", inptAddr);}
	/** get 입력주소 : inptAddr */
	public String  getInptAddr() { return (String )get("inptAddr");}
	/** set 수정자 : ismt */
	public void setIsmt(String  ismt) { set("ismt", ismt);}
	/** get 수정자 : ismt */
	public String  getIsmt() { return (String )get("ismt");}
	/** set 수정일자 : revnDt */
	public void setRevnDt(String  revnDt) { set("revnDt", revnDt);}
	/** get 수정일자 : revnDt */
	public String  getRevnDt() { return (String )get("revnDt");}
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String  revnAddr) { set("revnAddr", revnAddr);}
	/** get 수정주소 : revnAddr */
	public String  getRevnAddr() { return (String )get("revnAddr");}
	
	/** set 관련근거원본파일명 : refeOrgFlnm */
	public void setRefeOrgFlnm1(String  refeOrgFlnm1) { set("refeOrgFlnm1", refeOrgFlnm1);}
	/** get 관련근거원본파일명 : refeOrgFlnm */
	public String  getRefeOrgFlnm1() { return (String )get("refeOrgFlnm1");}
	
	/** set 관련근거원본파일명 : refeOrgFlnm */
	public void setRefeOrgFlnm2(String  refeOrgFlnm2) { set("refeOrgFlnm2", refeOrgFlnm2);}
	/** get 관련근거원본파일명 : refeOrgFlnm */
	public String  getRefeOrgFlnm2() { return (String )get("refeOrgFlnm2");}
	
	/** set 관련근거원본파일명 : refeOrgFlnm */
	public void setRefeOrgFlnm3(String  refeOrgFlnm3) { set("refeOrgFlnm3", refeOrgFlnm3);}
	/** get 관련근거원본파일명 : refeOrgFlnm */
	public String  getRefeOrgFlnm3() { return (String )get("refeOrgFlnm3");}
	

}
