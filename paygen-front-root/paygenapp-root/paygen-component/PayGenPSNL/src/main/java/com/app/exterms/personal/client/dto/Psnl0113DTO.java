package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0113VO.java
 * @Description : Psnl0113 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0113DTO extends BaseModel implements IsSerializable {
   
	private static final long serialVersionUID = 1L;
    
	public Psnl0113DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	
	//신장 : sttur
	public void setSttur(String sttur) { set("sttur",sttur);}
	public String getSttur() { return (String)get("sttur");}
	
	//체중 : wei
	public void setWei(String wei) { set("wei",wei);}
	public String getWei() { return (String)get("wei");}
	
	//나안시력_좌 : tnkeeVsnLf
	public void setTnkeeVsnLf(String tnkeeVsnLf) { set("tnkeeVsnLf",tnkeeVsnLf);}
	public String getTnkeeVsnLf() { return (String)get("tnkeeVsnLf");}
	
	//나안시력_우 : tnkeeVsnRght
	public void setTnkeeVsnRght(String tnkeeVsnRght) { set("tnkeeVsnRght",tnkeeVsnRght);}
	public String getTnkeeVsnRght() { return (String)get("tnkeeVsnRght");}
	
	//교정시력_좌 : corrVsnLf
	public void setCorrVsnLf(String corrVsnLf) { set("corrVsnLf",corrVsnLf);}
	public String getCorrVsnLf() { return (String)get("corrVsnLf");}
	
	//교정시력_우 : corrVsnRght
	public void setCorrVsnRght(String corrVsnRght) { set("corrVsnRght",corrVsnRght);}
	public String getCorrVsnRght() { return (String)get("corrVsnRght");}
	
	//색맹여부 : prmtsaYn
	public void setPrmtsaYn(String prmtsaYn) { set("prmtsaYn",prmtsaYn);}
	public String getPrmtsaYn() { return (String)get("prmtsaYn");}
	
	//혈액형구분코드 : bldtpDivCd
	public void setBldtpDivCd(String bldtpDivCd) { set("bldtpDivCd",bldtpDivCd);}
	public String getBldtpDivCd() { return (String)get("bldtpDivCd");}
	
	//종교유형코드 : relnFrmCd
	public void setRelnFrmCd(String relnFrmCd) { set("relnFrmCd",relnFrmCd);}
	public String getRelnFrmCd() { return (String)get("relnFrmCd");}
	
	//취미내용 : hbbyCtnt
	public void setHbbyCtnt(String hbbyCtnt) { set("hbbyCtnt",hbbyCtnt);}
	public String getHbbyCtnt() { return (String)get("hbbyCtnt");}
	
	//특기내용 : spityCtnt
	public void setSpityCtnt(String spityCtnt) { set("spityCtnt",spityCtnt);}
	public String getSpityCtnt() { return (String)get("spityCtnt");}
	
	//장애구분코드 : dabtyDivCd
	public void setDabtyDivCd(String dabtyDivCd) { set("dabtyDivCd",dabtyDivCd);}
	public String getDabtyDivCd() { return (String)get("dabtyDivCd");}
	
	//장애등급코드 : dabtyGrdeCd
	public void setDabtyGrdeCd(String dabtyGrdeCd) { set("dabtyGrdeCd",dabtyGrdeCd);}
	public String getDabtyGrdeCd() { return (String)get("dabtyGrdeCd");}
	
	//장애판정일자 : dabtyAjmtDt
	public void setDabtyAjmtDt(String dabtyAjmtDt) { set("dabtyAjmtDt",dabtyAjmtDt);}
	public String getDabtyAjmtDt() { return (String)get("dabtyAjmtDt");}
	
	//보훈구분코드 : pattVetnsDivCd
	public void setPattVetnsDivCd(String pattVetnsDivCd) { set("pattVetnsDivCd",pattVetnsDivCd);}
	public String getPattVetnsDivCd() { return (String)get("pattVetnsDivCd");}
	
	//보훈번호 : pattVetnsNum
	public void setPattVetnsNum(String pattVetnsNum) { set("pattVetnsNum",pattVetnsNum);}
	public String getPattVetnsNum() { return (String)get("pattVetnsNum");}
	
	//보훈여부 : pattVetnsYn
	public void setPattVetnsYn(String pattVetnsYn) { set("pattVetnsYn",pattVetnsYn);}
	public String getPattVetnsYn() { return (String)get("pattVetnsYn");}
	
	//유공자와의관계구분코드 : amomRelaDivCd
	public void setAmomRelaDivCd(String amomRelaDivCd) { set("amomRelaDivCd",amomRelaDivCd);}
	public String getAmomRelaDivCd() { return (String)get("amomRelaDivCd");}
	
	//건강상태내용 : hlthCodtnCtnt
	public void setHlthCodtnCtnt(String hlthCodtnCtnt) { set("hlthCodtnCtnt",hlthCodtnCtnt);}
	public String getHlthCodtnCtnt() { return (String)get("hlthCodtnCtnt");}
	
	//주택구분코드 : husDivCd
	public void setHusDivCd(String husDivCd) { set("husDivCd",husDivCd);}
	public String getHusDivCd() { return (String)get("husDivCd");}
	
	//주택금액 : husSum
	public void setHusSum(String husSum) { set("husSum",husSum);}
	public String getHusSum() { return (String)get("husSum");}
	
	//그외부동산금액 : rstPptySum
	public void setRstPptySum(String rstPptySum) { set("rstPptySum",rstPptySum);}
	public String getRstPptySum() { return (String)get("rstPptySum");}
	
	//동산금액 : mvasstSum
	public void setMvasstSum(String mvasstSum) { set("mvasstSum",mvasstSum);}
	public String getMvasstSum() { return (String)get("mvasstSum");}
	
	//거주구분코드 : ridnDivCd
	public void setRidnDivCd(String ridnDivCd) { set("ridnDivCd",ridnDivCd);}
	public String getRidnDivCd() { return (String)get("ridnDivCd");}
	
	//가족수당적용년월 : famyAllwApptnYrMnth
	public void setFamyAllwApptnYrMnth(String famyAllwApptnYrMnth) { set("famyAllwApptnYrMnth",famyAllwApptnYrMnth);}
	public String getFamyAllwApptnYrMnth() { return (String)get("famyAllwApptnYrMnth");}
	
	//건강보험신고_FLAG : hlthInsrRegrstFlag
	public void setHlthInsrRegrstFlag(String hlthInsrRegrstFlag) { set("hlthInsrRegrstFlag",hlthInsrRegrstFlag);}
	public String getHlthInsrRegrstFlag() { return (String)get("hlthInsrRegrstFlag");}
	
	//국민연금신고_FLAG : natPennRegrstFlag
	public void setNatPennRegrstFlag(String natPennRegrstFlag) { set("natPennRegrstFlag",natPennRegrstFlag);}
	public String getNatPennRegrstFlag() { return (String)get("natPennRegrstFlag");}
	
	//산재보험신고FLAG : idtlAccdtInsurRegrstFlag
	public void setIdtlAccdtInsurRegrstFlag(String idtlAccdtInsurRegrstFlag) { set("idtlAccdtInsurRegrstFlag",idtlAccdtInsurRegrstFlag);}
	public String getIdtlAccdtInsurRegrstFlag() { return (String)get("idtlAccdtInsurRegrstFlag");}
	
	//고용보험신고FLAG : umytInsrRegrstFlag
	public void setUmytInsrRegrstFlag(String umytInsrRegrstFlag) { set("umytInsrRegrstFlag",umytInsrRegrstFlag);}
	public String getUmytInsrRegrstFlag() { return (String)get("umytInsrRegrstFlag");}
	
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
	
	// 생년월일 : resnRegnYMN
	public void setResnRegnYMD(String resnRegnYMD) {set("resnRegnYMD",resnRegnYMD);}
	public String getResnRegnYMD(){return (String)get("resnRegnYMD");};
	
	/** set 주민등록번호 : resnRegnNum */
	public void setResnRegnNum(String resnRegnNum) { set("resnRegnNum", resnRegnNum);}
	/** get 주민등록번호 : resnRegnNum */
	public String getResnRegnNum() { return (String)get("resnRegnNum");}
	/** set 원본 주민등록번호 : secRegnNum */
	public void setSecRegnNum(String secRegnNum) { set("secRegnNum",secRegnNum);}
	/** get 원본 주민등록번호 : secRegnNum */
	public String getSecRegnNum() { return (String)get("secRegnNum");}
	// 생년월일 : resnRegnYMN
//	public void setResnRegnSex(String resnRegnSex) {set("resnRegnSex", resnRegnSex);}
//	public String getResnRegnSex(){return (String)get("resnRegnSex");};
	
	// temp
	public void setTemp(String temp) {set("temp", temp);}
	public String getTemp(){return (String)get("temp");};
	
	//성별
	public void setSxDivCd(String sxDivCd) {set("sxDivCd", sxDivCd);}
	public String getSxDivCd(){return (String)get("sxDivCd");};
	
	//생년월일
	public void setYoobhMnthDay(String yoobhMnthDay) {set("yoobhMnthDay", yoobhMnthDay);}
	public String getYoobhMnthDay(){return (String)get("yoobhMnthDay");};
	
	
	
}
