package com.app.exterms.personal.client.dto;


import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Psnl0118DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	
	public Psnl0118DTO(){}
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	
	//자격면허일련번호 : qftntLicnsSeilNum
	public void setQftntLicnsSeilNum(String qftntLicnsSeilNum) { set("qftntLicnsSeilNum",qftntLicnsSeilNum);}
	public String getQftntLicnsSeilNum() { return (String)get("qftntLicnsSeilNum");}
	
	//취득일자 : aqtnDt
	public void setAqtnDt(Date aqtnDt) { set("aqtnDt",aqtnDt);}
	public Date getAqtnDt() { return get("aqtnDt");}
	
	//자격면허코드 : qftntLicnsCd
	public void setQftntLicnsCd(String qftntLicnsCd) { set("qftntLicnsCd",qftntLicnsCd);}
	public String getQftntLicnsCd() { return (String)get("qftntLicnsCd");}
	
	public void setQftntLicnsCdNm(String qftntLicnsCdNm) { set("qftntLicnsCdNm",qftntLicnsCdNm);}
	public String getQftntLicnsCdNm() { return (String)get("qftntLicnsCdNm");}
	
	//자격면허분야내용 : qftntLicnsPovncCtnt
	public void setQftntLicnsPovncCtnt(String qftntLicnsPovncCtnt) { set("qftntLicnsPovncCtnt",qftntLicnsPovncCtnt);}
	public String getQftntLicnsPovncCtnt() { return (String)get("qftntLicnsPovncCtnt");}
	
	//시행기관명 : efmnIstutNm
	public void setEfmnIstutNm(String efmnIstutNm) { set("efmnIstutNm",efmnIstutNm);}
	public String getEfmnIstutNm() { return (String)get("efmnIstutNm");}
	
	//자격면허번호 : qftntLicnsNum
	public void setQftntLicnsNum(String qftntLicnsNum) { set("qftntLicnsNum",qftntLicnsNum);}
	public String getQftntLicnsNum() { return (String)get("qftntLicnsNum");}
	
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
