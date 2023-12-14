package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0112VO.java
 * @Description : Psnl0112 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0112DTO extends BaseModel implements IsSerializable {
    
	private static final long serialVersionUID = 1L;
    
	public Psnl0112DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//입대일자 : enrlntDt
	public void setEnrlntDt(String enrlntDt) { set("enrlntDt",enrlntDt);}
	public String getEnrlntDt() { return (String)get("enrlntDt");}
	//제대일자 : dsageDt
	public void setDsageDt(String dsageDt) { set("dsageDt",dsageDt);}
	public String getDsageDt() { return (String)get("dsageDt");}
	//복무인정기간코드 : servcRcgtnPridCd
	public void setServcRcgtnPridCd(String servcRcgtnPridCd) { set("servcRcgtnPridCd",servcRcgtnPridCd);}
	public String getServcRcgtnPridCd() { return (String)get("servcRcgtnPridCd");}
	//역종코드 : srvssCd
	public void setSrvssCd(String srvssCd) { set("srvssCd",srvssCd);}
	public String getSrvssCd() { return (String)get("srvssCd");}
	//군별코드 : baggrpCd
	public void setBaggrpCd(String baggrpCd) { set("baggrpCd",baggrpCd);}
	public String getBaggrpCd() { return (String)get("baggrpCd");}
	//병과코드 : abotsCd
	public void setAbotsCd(String abotsCd) { set("abotsCd",abotsCd);}
	public String getAbotsCd() { return (String)get("abotsCd");}
	//계급코드 : clsCd
	public void setClsCd(String clsCd) { set("clsCd",clsCd);}
	public String getClsCd() { return (String)get("clsCd");}
	//군번 : mitySilnum
	public void setMitySilnum(String mitySilnum) { set("mitySilnum",mitySilnum);}
	public String getMitySilnum() { return (String)get("mitySilnum");}
	//MOS : mos
	public void setMos(String mos) { set("mos",mos);}
	public String getMos() { return (String)get("mos");}
	//제대구분코드 : dsageDivCd
	public void setDsageDivCd(String dsageDivCd) { set("dsageDivCd",dsageDivCd);}
	public String getDsageDivCd() { return (String)get("dsageDivCd");}
	//면제사유코드 : exmtnReasCd
	public void setExmtnReasCd(String exmtnReasCd) { set("exmtnReasCd",exmtnReasCd);}
	public String getExmtnReasCd() { return (String)get("exmtnReasCd");}
	//면제사유내용 : exmtnReasCtnt
	public void setExmtnReasCtnt(String exmtnReasCtnt) { set("exmtnReasCtnt",exmtnReasCtnt);}
	public String getExmtnReasCtnt() { return (String)get("exmtnReasCtnt");}
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
