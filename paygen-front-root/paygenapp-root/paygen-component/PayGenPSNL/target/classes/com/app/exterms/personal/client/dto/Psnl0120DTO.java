package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0120DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	public Psnl0120DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//교육일련번호 : eduSeilNum
	public void setEduSeilNum(String eduSeilNum) { set("eduSeilNum",eduSeilNum);}
	public String getEduSeilNum() { return (String)get("eduSeilNum");}
	
	//교육시작일자 : eduBgnnDt
	public void setEduBgnnDt(Date eduBgnnDt) { set("eduBgnnDt",eduBgnnDt);}
	public Date getEduBgnnDt() { return get("eduBgnnDt");}
	//교육종료일자 : eduEndDt
	public void setEduEndDt(Date eduEndDt) { set("eduEndDt",eduEndDt);}
	public Date getEduEndDt() { return get("eduEndDt");}
	
	//교육이수시간 : eduCmpteTm
	public void setEduCmpteTm(String eduCmpteTm) { set("eduCmpteTm",eduCmpteTm);}
	public String getEduCmpteTm() { return (String)get("eduCmpteTm");}
	//교육종류명 : eduKndNm
	public void setEduKndNm(String eduKndNm) { set("eduKndNm",eduKndNm);}
	public String getEduKndNm() { return (String)get("eduKndNm");}
	//교육기관명 : eduIstutNm
	public void setEduIstutNm(String eduIstutNm) { set("eduIstutNm",eduIstutNm);}
	public String getEduIstutNm() { return (String)get("eduIstutNm");}
	//교육비고내용 : eduNoteCtnt
	public void setEduNoteCtnt(String eduNoteCtnt) { set("eduNoteCtnt",eduNoteCtnt);}
	public String getEduNoteCtnt() { return (String)get("eduNoteCtnt");}
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
	
	/** set 교육시작시간 : eduBgnnTm */
	public void setEduBgnnTm(String  eduBgnnTm) { set( "eduBgnnTm" ,eduBgnnTm);}
	/** get 교육시작시간 : eduBgnnTm */
	public String  getEduBgnnTm() { return (String )get( "eduBgnnTm" );}
	/** set 교육종료시간 : eduEndTm */
	public void setEduEndTm(String  eduEndTm) { set( "eduEndTm" ,eduEndTm);}
	/** get 교육종료시간 : eduEndTm */
	public String  getEduEndTm() { return (String )get("eduEndTm" );}
	
	
	public void setRnum(String rnum){set("rnum", rnum);};
	public String getRnum(){ return (String)get("rnum");}
	
	/** 주민번호  */
	public void setRrn(String rrn){ set("rrn" , rrn);}
	public String getRrn() { return (String)get("rrn");}
	
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum",resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	
	/** set 원본 주민등록번호 : secRegnNum */
	public void setSecRegnNum(String secRegnNum) { set("secRegnNum",secRegnNum);}
	/** get 원본 주민등록번호 : secRegnNum */
	public String getSecRegnNum() { return (String)get("secRegnNum");}
}
