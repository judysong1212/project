package com.app.exterms.personal.client.dto;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Psnl0134DTO extends BaseModel{

	private static final long serialVersionUID = 1L;
	
	public Psnl0134DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	//순번이 필요할경우
	public void setRnum(String rnum) { set("rnum", rnum); }
	public String getRnum(){return (String)get("rnum");}
		
	
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( "dpobCd" ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get("dpobCd" );}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String  systemkey) { set( "systemkey" ,systemkey);}
	/** get SYSTEMKEY : systemkey */
	public String  getSystemkey() { return (String )get("systemkey" );}

	/** set 수행시찰일련번호 : acmpInspnSeilNum */
	public void setAcmpInspnSeilNum(String  acmpInspnSeilNum) { set( "acmpInspnSeilNum" ,acmpInspnSeilNum);}
	/** get 수행시찰일련번호 : acmpInspnSeilNum */
	public String  getAcmpInspnSeilNum() { return (String )get("acmpInspnSeilNum" );}

	/** set 수행시찰구분코드 : acmpInspnDivCd */
	public void setAcmpInspnDivCd(String  acmpInspnDivCd) { set( "acmpInspnDivCd" ,acmpInspnDivCd);}
	/** get 수행시찰구분코드 : acmpInspnDivCd */
	public String  getAcmpInspnDivCd() { return (String )get("acmpInspnDivCd" );}
	
	/** set 수행시찰구분코드 : acmpInspnDivNm */
	public void setAcmpInspnDivNm(String  acmpInspnDivNm) { set( "acmpInspnDivNm" ,acmpInspnDivNm);}
	/** get 수행시찰구분코드 : acmpInspnDivNm */
	public String  getAcmpInspnDivNm() { return (String )get("acmpInspnDivNm" );}
	
	/** set 수행시찰제목 : acmpInspnTtl */
	public void setAcmpInspnTtl(String  acmpInspnTtl) { set( "acmpInspnTtl" ,acmpInspnTtl);}
	/** get 수행시찰제목 : acmpInspnTtl */
	public String  getAcmpInspnTtl() { return (String )get("acmpInspnTtl" );}

	/** set 수행시찰시작일자 : acmpInspnBgnnDt */
	public void setAcmpInspnBgnnDt(Date  acmpInspnBgnnDt) { set( "acmpInspnBgnnDt" ,acmpInspnBgnnDt);}
	/** get 수행시찰시작일자 : acmpInspnBgnnDt */
	public Date  getAcmpInspnBgnnDt() { return (Date )get("acmpInspnBgnnDt" );}

	/** set 수행시찰종료일자 : acmpInspnEndDt */
	public void setAcmpInspnEndDt(Date  acmpInspnEndDt) { set( "acmpInspnEndDt" ,acmpInspnEndDt);}
	/** get 수행시찰종료일자 : acmpInspnEndDt */
	public Date  getAcmpInspnEndDt() { return (Date )get("acmpInspnEndDt" );}
	
	/** set 수행시찰국명 : acmpInspnNmCty */
	public void setAcmpInspnNmCty(String  acmpInspnNmCty) { set( "acmpInspnNmCty" ,acmpInspnNmCty);}
	/** get 수행시찰국명 : acmpInspnNmCty */
	public String  getAcmpInspnNmCty() { return (String )get("acmpInspnNmCty" );}

	/** set 수행시찰목적내용 : acmpInspnPurCtnt */
	public void setAcmpInspnPurCtnt(String  acmpInspnPurCtnt) { set( "acmpInspnPurCtnt" ,acmpInspnPurCtnt);}
	/** get 수행시찰목적내용 : acmpInspnPurCtnt */
	public String  getAcmpInspnPurCtnt() { return (String )get("acmpInspnPurCtnt" );}

	/** set 수행시찰성과내용 : acmpInspnRstCtnt */
	public void setAcmpInspnRstCtnt(String  acmpInspnRstCtnt) { set( "acmpInspnRstCtnt" ,acmpInspnRstCtnt);}
	/** get 수행시찰성과내용 : acmpInspnRstCtnt */
	public String  getAcmpInspnRstCtnt() { return (String )get("acmpInspnRstCtnt" );}

	/** set 수행시찰기타내용 : acmpInspnEtcCtnt */
	public void setAcmpInspnEtcCtnt(String  acmpInspnEtcCtnt) { set( "acmpInspnEtcCtnt" ,acmpInspnEtcCtnt);}
	/** get 수행시찰기타내용 : acmpInspnEtcCtnt */
	public String  getAcmpInspnEtcCtnt() { return (String )get("acmpInspnEtcCtnt" );}

	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set( "kybdr" ,kybdr);}
	/** get 입력자 : kybdr */
	public String  getKybdr() { return (String )get("kybdr" );}

	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set( "inptDt" ,inptDt);}
	/** get 입력일자 : inptDt */
	public String  getInptDt() { return (String )get("inptDt" );}

	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set( "inptAddr" ,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String  getInptAddr() { return (String )get("inptAddr" );}

	/** set 수정일자 : revnDt */
	public void setRevnDt(String  revnDt) { set( "revnDt" ,revnDt);}
	/** get 수정일자 : revnDt */
	public String  getRevnDt() { return (String )get("revnDt" );}

	/** set 수정자 : ismt */
	public void setIsmt(String  ismt) { set( "ismt" ,ismt);}
	/** get 수정자 : ismt */
	public String  getIsmt() { return (String )get("ismt" );}

	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String  revnAddr) { set( "revnAddr" ,revnAddr);}
	/** get 수정주소 : revnAddr */
	public String  getRevnAddr() { return (String )get("revnAddr" );}
	
	/** set 수행시찰기간수 : acmpInspnDys */
	public void setAcmpInspnDys(String  acmpInspnDys) { set( "acmpInspnDys" ,acmpInspnDys);}
	/** get 수행시찰기간수 : acmpInspnDys */
	public String  getAcmpInspnDys() { return (String )get( "acmpInspnDys" );}

	

}
