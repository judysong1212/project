package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0114DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	
	public Psnl0114DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//단체일련번호 : opztnSeilNum
	public void setOpztnSeilNum(String opztnSeilNum) { set("opztnSeilNum",opztnSeilNum);}
	public String getOpztnSeilNum() { return (String)get("opztnSeilNum");}
	
	//가입일자 : jnDt
	public void setJnDt(Date jnDt) { set("jnDt",jnDt);}
	public Date getJnDt() { return get("jnDt");}
	
	//가입단체명 : jnOpztnNm
	public void setJnOpztnNm(String jnOpztnNm) { set("jnOpztnNm",jnOpztnNm);}
	public String getJnOpztnNm() { return (String)get("jnOpztnNm");}
	//직책코드 : odtyCd
	public void setOdtyCd(String odtyCd) { set("odtyCd",odtyCd);}
	public String getOdtyCd() { return (String)get("odtyCd");}
	
	public void setOdtyNm(String odtyNm) { set("odtyNm",odtyNm);}
	public String getOdtyNm() { return (String)get("odtyNm");}
	
	//탈퇴일자 : wirlDt
	public void setWirlDt(Date wirlDt) { set("wirlDt",wirlDt);}
	public Date getWirlDt() { return get("wirlDt");}
	
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
	
	//급여공제구분코드 : jnPayrDducDivCd
	public void setJnPayrDducDivCd(String jnPayrDducDivCd) { set("jnPayrDducDivCd",jnPayrDducDivCd);}
	public String getJnPayrDducDivCd() { return (String)get("jnPayrDducDivCd");}
	
	//단체급여공제여부 : jnPayrDducYn
	public void setJnPayrDducYn(String jnPayrDducYn) { set("jnPayrDducYn",jnPayrDducYn);}
	public String getJnPayrDducYn() { return (String)get("jnPayrDducYn");}
	
	public void setJnPayrDducYnChk(boolean jnPayrDducYnChk) { set("jnPayrDducYnChk",jnPayrDducYnChk);}
	public boolean getJnPayrDducYnChk() { return (Boolean)get("jnPayrDducYnChk");}
	
	//기부금공제구분코드 : jnCntbDducDivCd
	public void setJnCntbDducDivCd(String jnCntbDducDivCd) { set("jnCntbDducDivCd",jnCntbDducDivCd);}
	public String getJnCntbDducDivCd() { return (String)get("jnCntbDducDivCd");}
	
	//기부금표기명 : jnCntbMknm
	public void setJnCntbMknm(String jnCntbMknm) { set("jnCntbMknm",jnCntbMknm);}
	public String getJnCntbMknm() { return (String)get("jnCntbMknm");}
	
	//비과세감면구분코드 : txemRducDivCd
	public void setTxemRducDivCd(String txemRducDivCd) { set("txemRducDivCd", txemRducDivCd);}
	public String getTxemRducDivCd() { return (String)get("txemRducDivCd");}
	
	//단체비고내용 : jnCtnt
	public void setJnCtnt(String jnCtnt) { set("jnCtnt", jnCtnt);}
	public String getJnCtnt() { return (String)get("jnCtnt");}

}
