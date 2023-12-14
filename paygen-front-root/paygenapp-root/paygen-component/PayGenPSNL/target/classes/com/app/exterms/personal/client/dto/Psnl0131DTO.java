package com.app.exterms.personal.client.dto;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Psnl0131DTO extends BaseModel{
	
	private static final Long serialVersionUID = 1L;
	
	public Psnl0131DTO(){}
	
	//순번이 필요할경우
	public void setRnum(String rnum) { set("rnum", rnum); }
	public String getRnum(){return (String)get("rnum");}
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
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
	public String  getRefeSeilNum() { return (String)get("refeSeilNum");}
	/** set 관련근거등록일자 : refeIndt */
	public void setRefeIndt(Date  refeIndt) { set("refeIndt", refeIndt);}
	/** get 관련근거등록일자 : refeIndt */
	public Date  getRefeIndt() { return get("refeIndt");}
	/** set 관련근거담당자명 : refePrchNm */
	public void setRefePrchNm(String  refePrchNm) { set("refePrchNm", refePrchNm);}
	/** get 관련근거담당자명 : refePrchNm */
	public String  getRefePrchNm() { return (String )get("refePrchNm");}
	/** set 관련근거담당자명 : refePrchNmTitl */
	public void setRefePrchNmTitl(String  refePrchNmTitl) { set("refePrchNmTitl", refePrchNmTitl);}
	/** get 관련근거담당자명 : refePrchNm */
	public String  getRefePrchNmTitl() { return (String )get("refePrchNmTitl");}
	/** set 관련근거담당전화번호 : refePrchTel */
	public void setRefePrchTel(String  refePrchTel) { set("refePrchTel", refePrchTel);}
	/** get 관련근거담당전화번호 : refePrchTel */
	public String  getRefePrchTel() { return (String )get("refePrchTel");}
	/** set 관련근거구분코드 : refeDivCd */
	public void setRefeDivCd(String  refeDivCd) { set("refeDivCd", refeDivCd);}
	/** get 관련근거구분코드 : refeDivCd */
	public String  getRefeDivCd() { return (String )get("refeDivCd");}
	/** set 관련근거제목 : refeTitl */
	public void setRefeTitl(String  refeTitl) { set("refeTitl", refeTitl);}
	/** get 관련근거제목 : refeTitl */
	public String  getRefeTitl() { return (String )get("refeTitl");}
	/** set 관련근거내용 : refeCtnt */
	public void setRefeCtnt(String  refeCtnt) { set("refeCtnt", refeCtnt);}
	/** get 관련근거내용 : refeCtnt */
	public String  getRefeCtnt() { return (String )get("refeCtnt");}
	/** set null : refeDelFg */
	public void setRefeDelFg(String  refeDelFg) { set("refeDelFg", refeDelFg);}
	/** get null : refeDelFg */
	public String  getRefeDelFg() { return (String )get("refeDelFg");}
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
	
	
	
	// 첨부파일 정보를 가져오기 위해
	/** set 관련근거파일일련번호 : refeFlSeilNum */
	public void setRefeFlSeilNum(String  refeFlSeilNum) { set("refeFlSeilNum", refeFlSeilNum);}
	/** get 관련근거파일일련번호 : refeFlSeilNum1 */
	public String  getRefeFlSeilNum() { return (String )get("refeFlSeilNum");}
	
	
	/** set 관련근거파일일련번호 : refeFlSeilNum */
	public void setRefeFlSeilNum1(String  refeFlSeilNum1) { set("refeFlSeilNum1", refeFlSeilNum1);}
	/** get 관련근거파일일련번호 : refeFlSeilNum1 */
	public String  getRefeFlSeilNum1() { return (String )get("refeFlSeilNum1");}
	
	/** set 관련근거파일일련번호 : refeFlSeilNum */
	public void setRefeFlSeilNum2(String  refeFlSeilNum2) { set("refeFlSeilNum2", refeFlSeilNum2);}
	/** get 관련근거파일일련번호 : refeFlSeilNum1 */
	public String  getRefeFlSeilNum2() { return (String )get("refeFlSeilNum2");}
	
	/** set 관련근거파일일련번호 : refeFlSeilNum */
	public void setRefeFlSeilNum3(String  refeFlSeilNum3) { set("refeFlSeilNum3", refeFlSeilNum3);}
	/** get 관련근거파일일련번호 : refeFlSeilNum1 */
	public String  getRefeFlSeilNum3() { return (String )get("refeFlSeilNum3");}
	
	/** set 관련근거파일명 : refeFlnm */
	public void setRefeFlnm(String  refeFlnm) { set("refeFlnm", refeFlnm);}
	/** get 관련근거파일명 : refeFlnm */
	public String  getRefeFlnm() { return (String )get("refeFlnm");}
	
	
	
	/** set 관련근거파일명 : refeFlnm */
	public void setRefeFlnm1(String  refeFlnm1) { set("refeFlnm1", refeFlnm1);}
	/** get 관련근거파일명 : refeFlnm */
	public String  getRefeFlnm1() { return (String )get("refeFlnm1");}
	
	/** set 관련근거파일명 : refeFlnm */
	public void setRefeFlnm2(String  refeFlnm2) { set("refeFlnm2", refeFlnm2);}
	/** get 관련근거파일명 : refeFlnm */
	public String  getRefeFlnm2() { return (String )get("refeFlnm2");}
	
	/** set 관련근거파일명 : refeFlnm */
	public void setRefeFlnm3(String  refeFlnm3) { set("refeFlnm3", refeFlnm3);}
	/** get 관련근거파일명 : refeFlnm */
	public String  getRefeFlnm3() { return (String )get("refeFlnm3");}
	
	
	
	
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
	
	
	/** set 관련근거원본파일명 : refeOrgFlnm */
	public void setRefeOrgFlnm(String  refeOrgFlnm) { set("refeOrgFlnm", refeOrgFlnm);}
	/** get 관련근거원본파일명 : refeOrgFlnm */
	public String  getRefeOrgFlnm() { return (String )get("refeOrgFlnm");}

}
