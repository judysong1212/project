package com.app.exterms.personal.client.dto;


import com.extjs.gxt.ui.client.data.BaseModelData;

public class InfcPkgPsnl0127DTO extends BaseModelData{

	private static final long serialVersionUID = 1L;
	
	
	//삭제여부가 필요할시
	public void setDelChk(boolean delChk){set("delChk",delChk);}
	public boolean getDelChk(){return (Boolean)get("delChk");}
	
	
	public InfcPkgPsnl0127DTO(){}
	//사업장코드 : dpobCd
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	public String getDpobCd() { return (String)get("dpobCd");}
	//SYSTEMKEY : systemkey
	public void setSystemkey(String systemkey) { set("systemkey",systemkey);}
	public String getSystemkey() { return (String)get("systemkey");}
	//사회보험년도 : soctyInsurYr
	public void setSoctyInsurYr(String soctyInsurYr) { set("soctyInsurYr",soctyInsurYr);}
	public String getSoctyInsurYr() { return (String)get("soctyInsurYr");}
	//사회보험변동일자 : hlthInsurFlucDt
	public void setHlthInsurFlucDt(String hlthInsurFlucDt) { set("hlthInsurFlucDt",hlthInsurFlucDt);}
	public String getHlthInsurFlucDt() { return (String)get("hlthInsurFlucDt");}
	//건강보험보수총액 : hlthInsrPayTotAmnt
	public void setHlthInsrPayTotAmnt(String hlthInsrPayTotAmnt) { set("hlthInsrPayTotAmnt",hlthInsrPayTotAmnt);}
	public String getHlthInsrPayTotAmnt() { return (String)get("hlthInsrPayTotAmnt");}
	//건강보험보수월액 : hlthInsrMnthRuntnAmnt
	public void setHlthInsrMnthRuntnAmnt(String hlthInsrMnthRuntnAmnt) { set("hlthInsrMnthRuntnAmnt",hlthInsrMnthRuntnAmnt);}
	public String getHlthInsrMnthRuntnAmnt() { return (String)get("hlthInsrMnthRuntnAmnt");}
	//국민연금기준소득월액 : natPennStdIncmMnthAmnt
	public void setNatPennStdIncmMnthAmnt(String natPennStdIncmMnthAmnt) { set("natPennStdIncmMnthAmnt",natPennStdIncmMnthAmnt);}
	public String getNatPennStdIncmMnthAmnt() { return (String)get("natPennStdIncmMnthAmnt");}
	//건강보험적용여부 : hlthInsrApptnYn
	public void setHlthInsrApptnYn(String hlthInsrApptnYn) { set("hlthInsrApptnYn",hlthInsrApptnYn);}
	public String getHlthInsrApptnYn() { return (String)get("hlthInsrApptnYn");}
	//국민연금적용여부 : natPennApptnYn
	public void setNatPennApptnYn(String natPennApptnYn) { set("natPennApptnYn",natPennApptnYn);}
	public String getNatPennApptnYn() { return (String)get("natPennApptnYn");}
	//고용보험적용여부 : umytInsrApptnYn
	public void setUmytInsrApptnYn(String umytInsrApptnYn) { set("umytInsrApptnYn",umytInsrApptnYn);}
	public String getUmytInsrApptnYn() { return (String)get("umytInsrApptnYn");}
	//산재보험적용여부 : idtlAccdtInsurApptnYn
	public void setIdtlAccdtInsurApptnYn(String idtlAccdtInsurApptnYn) { set("idtlAccdtInsurApptnYn",idtlAccdtInsurApptnYn);}
	public String getIdtlAccdtInsurApptnYn() { return (String)get("idtlAccdtInsurApptnYn");}
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

	
	/** set 건강보험등급 : hlthInsrGrde */
	public void setHlthInsrGrde(String hlthInsrGrde) { set("hlthInsrGrde",hlthInsrGrde);}
	/** get 건강보험등급 : hlthInsrGrde */
	public String getHlthInsrGrde() { return (String)get("hlthInsrGrde");}
	/** set 건강보험증번호 : hlthInsrCertNum */
	public void setHlthInsrCertNum(String hlthInsrCertNum) { set("hlthInsrCertNum",hlthInsrCertNum);}
	/** get 건강보험증번호 : hlthInsrCertNum */
	public String getHlthInsrCertNum() { return (String)get("hlthInsrCertNum");}
	/** set 국민연금변동일자 : natPennInsurFlucDt */
	public void setNatPennInsurFlucDt(String natPennInsurFlucDt) { set("natPennInsurFlucDt",natPennInsurFlucDt);}
	/** get 국민연금변동일자 : natPennInsurFlucDt */
	public String getNatPennInsurFlucDt() { return (String)get("natPennInsurFlucDt");}
	
	/** set 국민연금등급 : natPennGrde */
	public void setNatPennGrde(String natPennGrde) { set("natPennGrde",natPennGrde);}
	/** get 국민연금등급 : natPennGrde */
	public String getNatPennGrde() { return (String)get("natPennGrde");}
	
	/** set 고용보험변동일자 : umytInsrFlucDt */
	public void setUmytInsrFlucDt(String umytInsrFlucDt) { set("umytInsrFlucDt",umytInsrFlucDt);}
	/** get 고용보험변동일자 : umytInsrFlucDt */
	public String getUmytInsrFlucDt() { return (String)get("umytInsrFlucDt");}
	/** set 고용보험보수총액 : umytInsrPayTotAmnt */
	public void setUmytInsrPayTotAmnt(String umytInsrPayTotAmnt) { set("umytInsrPayTotAmnt",umytInsrPayTotAmnt);}
	/** get 고용보험보수총액 : umytInsrPayTotAmnt */
	public String getUmytInsrPayTotAmnt() { return (String)get("umytInsrPayTotAmnt");}
	/** set 고용보험보수월액 : umytInsrPayMnthAmnt */
	public void setUmytInsrPayMnthAmnt(String umytInsrPayMnthAmnt) { set("umytInsrPayMnthAmnt",umytInsrPayMnthAmnt);}
	/** get 고용보험보수월액 : umytInsrPayMnthAmnt */
	public String getUmytInsrPayMnthAmnt() { return (String)get("umytInsrPayMnthAmnt");}
	/** set 산재보험변동일자 : idtlAccdtFlucDt */
	public void setIdtlAccdtFlucDt(String idtlAccdtFlucDt) { set("idtlAccdtFlucDt",idtlAccdtFlucDt);}
	/** get 산재보험변동일자 : idtlAccdtFlucDt */
	public String getIdtlAccdtFlucDt() { return (String)get("idtlAccdtFlucDt");}
	/** set 산재보험보수총액 : idtlAccdtPayTotAmnt */
	public void setIdtlAccdtPayTotAmnt(String idtlAccdtPayTotAmnt) { set("idtlAccdtPayTotAmnt",idtlAccdtPayTotAmnt);}
	/** get 산재보험보수총액 : idtlAccdtPayTotAmnt */
	public String getIdtlAccdtPayTotAmnt() { return (String)get("idtlAccdtPayTotAmnt");}
	/** set 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	public void setIdtlAccdtPayMnthAmnt(String idtlAccdtPayMnthAmnt) { set("idtlAccdtPayMnthAmnt",idtlAccdtPayMnthAmnt);}
	/** get 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	public String getIdtlAccdtPayMnthAmnt() { return (String)get("idtlAccdtPayMnthAmnt");}
	
}
