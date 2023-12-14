package com.app.exterms.personal.client.dto;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Psnl0133DTO extends BaseModel{

	private static final long serialVersionUID = 1L;
	
	public Psnl0133DTO(){}
	
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

	/** set 근무상황일련번호 : dutySittnSeilNum */
	public void setDutySittnSeilNum(String  dutySittnSeilNum) { set( "dutySittnSeilNum" ,dutySittnSeilNum);}
	/** get 근무상황일련번호 : dutySittnSeilNum */
	public String  getDutySittnSeilNum() { return (String )get("dutySittnSeilNum" );}

	/** set 근무상황제목 : dutySittnTtl */
	public void setDutySittnTtl(String  dutySittnTtl) { set( "dutySittnTtl" ,dutySittnTtl);}
	/** get 근무상황제목 : dutySittnTtl */
	public String  getDutySittnTtl() { return (String )get("dutySittnTtl" );}

	/** set 근무상황작성일자 : dutySittnCmptnDt */
	public void setDutySittnCmptnDt(Date  dutySittnCmptnDt) { set( "dutySittnCmptnDt" ,dutySittnCmptnDt);}
	/** get 근무상황작성일자 : dutySittnCmptnDt */
	public Date  getDutySittnCmptnDt() { return (Date )get("dutySittnCmptnDt" );}
	
	/** set 근무상황부서 : dutyDeptCd */
	public void setDutyDeptCd(String  dutyDeptCd) { set( "dutyDeptCd" ,dutyDeptCd);}
	/** get 근무상황부서 : dutyDeptCd */
	public String  getDutyDeptCd() { return (String )get("dutyDeptCd" );}
	
	/** set 근무상황부서 : dutyDeptNm */
	public void setDutyDeptNm(String  dutyDeptNm) { set( "dutyDeptNm" ,dutyDeptNm);}
	/** get 근무상황부서 : dutyDeptNm */
	public String  getDutyDeptNm() { return (String )get("dutyDeptNm" );}

	/** set 근무상황작성자 : dutySittnPpgPern */
	public void setDutySittnPpgPern(String  dutySittnPpgPern) { set( "dutySittnPpgPern" ,dutySittnPpgPern);}
	/** get 근무상황작성자 : dutySittnPpgPern */
	public String  getDutySittnPpgPern() { return (String)get("dutySittnPpgPern" );}

	/** set 근무상황내용 : dutySittnCtnt */
	public void setDutySittnCtnt(String  dutySittnCtnt) { set( "dutySittnCtnt" ,dutySittnCtnt);}
	/** get 근무상황내용 : dutySittnCtnt */
	public String  getDutySittnCtnt() { return (String )get("dutySittnCtnt" );}

	/** set 근무상황특이사항 : dutySittnSgctrt */
	public void setDutySittnSgctrt(String  dutySittnSgctrt) { set( "dutySittnSgctrt" ,dutySittnSgctrt);}
	/** get 근무상황특이사항 : dutySittnSgctrt */
	public String  getDutySittnSgctrt() { return (String )get("dutySittnSgctrt" );}

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
	

}
