package com.app.exterms.basis.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;


public class InfcPkgBass0150DTO extends BaseModel{
	 
	private static final long serialVersionUID = 1L;
	
	/** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    
	
	public InfcPkgBass0150DTO(){}
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String)get("dpobCd");}
	
	/** set 단위기관코드 : payrMangDeptCd */
	public void setPayrMangDeptCd(String payrMangDeptCd) { set("payrMangDeptCd",payrMangDeptCd);}
	/** get 단위기관코드 : payrMangDeptCd */
	public String getPayrMangDeptCd() { return (String)get("payrMangDeptCd");}
	
	/** set 단위기관명 : payMangeDeptNm */
	public void setPayMangeDeptNm(String payMangeDeptNm) { set("payMangeDeptNm",payMangeDeptNm);}
	/** get 단위기관명 : payMangeDeptNm */
	public String getPayMangeDeptNm() { return (String)get("payMangeDeptNm");}
	
	/** set 대표자주민번호 : degtrResnRegnNum */
	public void setDegtrResnRegnNum(String degtrResnRegnNum) { set("degtrResnRegnNum",degtrResnRegnNum);}
	/** get 대표자주민번호 : degtrResnRegnNum */
	public String getDegtrResnRegnNum() { return (String)get("degtrResnRegnNum");}
	
	/** set 대표자주민번호 : degtrSecRegnNum */
	public void setDegtrSecRegnNum(String degtrSecRegnNum) {
		set("degtrSecRegnNum", degtrSecRegnNum);
	}

	/** get 대표자주민번호 : degtrSecRegnNum */
	public String getDegtrSecRegnNum() {
		return (String) get("degtrSecRegnNum");
	}
	
	
	/** set 대표자명 : degtrNm */
	public void setDegtrNm(String degtrNm) { set("degtrNm",degtrNm);}
	/** get 대표자명 : degtrNm */
	public String getDegtrNm() { return (String)get("degtrNm");}
	
	/** set 사업자등록번호 : busoprRgstnNum */
	public void setBusoprRgstnNum(String busoprRgstnNum) { set("busoprRgstnNum",busoprRgstnNum);}
	/** get 사업자등록번호 : busoprRgstnNum */
	public String getBusoprRgstnNum() { return (String)get("busoprRgstnNum");}
	
	/** set 법인등록번호 : corpRgstnNum */
	public void setCorpRgstnNum(String corpRgstnNum) { set("corpRgstnNum",corpRgstnNum);}
	/** get 법인등록번호 : corpRgstnNum */
	public String getCorpRgstnNum() { return (String)get("corpRgstnNum");}
	
	/** set 법인구분코드 : corpDivCd */
	public void setCorpDivCd(String corpDivCd) { set("corpDivCd",corpDivCd);}
	/** get 법인구분코드 : corpDivCd */
	public String getCorpDivCd() { return (String)get("corpDivCd");}
	
	/** set 단위기관우편번호 : payMangeDeptZpcd */
	public void setPayMangeDeptZpcd(String payMangeDeptZpcd) { set("payMangeDeptZpcd",payMangeDeptZpcd);}
	/** get 단위기관우편번호 : payMangeDeptZpcd */
	public String getPayMangeDeptZpcd() { return (String)get("payMangeDeptZpcd");}
	
	/** set 단위기관기본주소 : payMangeDeptFNdtnAddr */
	public void setPayMangeDeptFNdtnAddr(String payMangeDeptFNdtnAddr) { set("payMangeDeptFNdtnAddr",payMangeDeptFNdtnAddr);}
	/** get 단위기관기본주소 : payMangeDeptFNdtnAddr */
	public String getPayMangeDeptFNdtnAddr() { return (String)get("payMangeDeptFNdtnAddr");}
	
	/** set 단위기관상세주소 : payMangeDeptDtlPatrAddr */
	public void setPayMangeDeptDtlPatrAddr(String payMangeDeptDtlPatrAddr) { set("payMangeDeptDtlPatrAddr",payMangeDeptDtlPatrAddr);}
	/** get 단위기관상세주소 : payMangeDeptDtlPatrAddr */
	public String getPayMangeDeptDtlPatrAddr() { return (String)get("payMangeDeptDtlPatrAddr");}
	
	/** set 단위기관전화번호 : payMangeDeptPhnNum */
	public void setPayMangeDeptPhnNum(String payMangeDeptPhnNum) { set("payMangeDeptPhnNum",payMangeDeptPhnNum);}
	/** get 단위기관전화번호 : payMangeDeptPhnNum */
	public String getPayMangeDeptPhnNum() { return (String)get("payMangeDeptPhnNum");}
	
	/** set 단위기관팩스번호 : payMangeDeptFaxNum */
	public void setPayMangeDeptFaxNum(String payMangeDeptFaxNum) { set("payMangeDeptFaxNum",payMangeDeptFaxNum);}
	/** get 단위기관팩스번호 : payMangeDeptFaxNum */
	public String getPayMangeDeptFaxNum() { return (String)get("payMangeDeptFaxNum");}
	
	/** set 단위기관직인문구명 : payMangeDeptSealWrdNm */
	public void setPayMangeDeptSealWrdNm(String payMangeDeptSealWrdNm) { set("payMangeDeptSealWrdNm",payMangeDeptSealWrdNm);}
	/** get 단위기관직인문구명 : payMangeDeptSealWrdNm */
	public String getPayMangeDeptSealWrdNm() { return (String)get("payMangeDeptSealWrdNm");}
	
	/** set 단위기관직인경로 : payMangeDeptSealRftaNm */
	public void setPayMangeDeptSealRftaNm(String payMangeDeptSealRftaNm) { set("payMangeDeptSealRftaNm",payMangeDeptSealRftaNm);}
	/** get 단위기관직인경로 : payMangeDeptSealRftaNm */
	public String getPayMangeDeptSealRftaNm() { return (String)get("payMangeDeptSealRftaNm");}
	
	/** set 단위기관직인파일명 : payMangeDeptSealFlNm */
	public void setPayMangeDeptSealFlNm(String payMangeDeptSealFlNm) { set("payMangeDeptSealFlNm",payMangeDeptSealFlNm);}
	/** get 단위기관직인파일명 : payMangeDeptSealFlNm */
	public String getPayMangeDeptSealFlNm() { return (String)get("payMangeDeptSealFlNm");}
	
	/** set 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
	public void setPayMangeDeptFNdtnUseYn(String payMangeDeptFNdtnUseYn) { set("payMangeDeptFNdtnUseYn",payMangeDeptFNdtnUseYn);}
	/** get 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
	public String getPayMangeDeptFNdtnUseYn() { return (String)get("payMangeDeptFNdtnUseYn");}
	
	/** set 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
	public void setPayMangeDeptWhlePernChrg(String payMangeDeptWhlePernChrg) { set("payMangeDeptWhlePernChrg",payMangeDeptWhlePernChrg);}
	/** get 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
	public String getPayMangeDeptWhlePernChrg() { return (String)get("payMangeDeptWhlePernChrg");}
	
	/** set 단위기관총괄담당자명 : payMangeDeptWhlePernNm */
	public void setPayMangeDeptWhlePernNm(String payMangeDeptWhlePernNm) { set("payMangeDeptWhlePernNm",payMangeDeptWhlePernNm);}
	/** get 단위기관총괄담당자명 : payMangeDeptWhlePernNm */
	public String getPayMangeDeptWhlePernNm() { return (String)get("payMangeDeptWhlePernNm");}
	
	/** set 단위기관분임지출관 : payMangeDeptDivTskOffr */
	public void setPayMangeDeptDivTskOffr(String payMangeDeptDivTskOffr) { set("payMangeDeptDivTskOffr",payMangeDeptDivTskOffr);}
	/** get 단위기관분임지출관 : payMangeDeptDivTskOffr */
	public String getPayMangeDeptDivTskOffr() { return (String)get("payMangeDeptDivTskOffr");}
	
	/** set 회계코드 : accCd */
	public void setAccCd(String accCd) { set("accCd",accCd);}
	/** get 회계코드 : accCd */
	public String getAccCd() { return (String)get("accCd");}
	
	/** set 건강보험기호 : hlthInsrSym */
	public void setHlthInsrSym(String hlthInsrSym) { set("hlthInsrSym",hlthInsrSym);}
	/** get 건강보험기호 : hlthInsrSym */
	public String getHlthInsrSym() { return (String)get("hlthInsrSym");}
	
	/** set 국민연금기호 : natPennSym */
	public void setNatPennSym(String natPennSym) { set("natPennSym",natPennSym);}
	/** get 국민연금기호 : natPennSym */
	public String getNatPennSym() { return (String)get("natPennSym");}
	
	/** set 고용보험기호 : umytInsrSym */
	public void setUmytInsrSym(String umytInsrSym) { set("umytInsrSym",umytInsrSym);}
	/** get 고용보험기호 : umytInsrSym */
	public String getUmytInsrSym() { return (String)get("umytInsrSym");}
	
	/** set 징수의무자명 : cllnDebrNm */
	public void setCllnDebrNm(String cllnDebrNm) { set("cllnDebrNm",cllnDebrNm);}
	/** get 징수의무자명 : cllnDebrNm */
	public String getCllnDebrNm() { return (String)get("cllnDebrNm");}
	
	/** set 홈텍스ID : hmtxId */
	public void setHmtxId(String hmtxId) { set("hmtxId",hmtxId);}
	/** get 홈텍스ID : hmtxId */
	public String getHmtxId() { return (String)get("hmtxId");}
	
	/** set 세무서코드 : txOffcCd */
	public void setTxOffcCd(String txOffcCd) { set("txOffcCd",txOffcCd);}
	/** get 세무서코드 : txOffcCd */
	public String getTxOffcCd() { return (String)get("txOffcCd");}
	
	/** set 은행코드 : bnkCd */
	public void setBnkCd(String bnkCd) { set("bnkCd",bnkCd);}
	/** get 은행코드 : bnkCd */
	public String getBnkCd() { return (String)get("bnkCd");}
	
	/** set 지로이체코드 : groTnsrCd */
	public void setGroTnsrCd(String groTnsrCd) { set("groTnsrCd",groTnsrCd);}
	/** get 지로이체코드 : groTnsrCd */
	public String getGroTnsrCd() { return (String)get("groTnsrCd");}
	
	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) { set("kybdr",kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String)get("kybdr");}
	
	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) { set("inptDt",inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String)get("inptDt");}
	
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String)get("inptAddr");}
	
	/** set 수정자 : ismt */
	public void setIsmt(String ismt) { set("ismt",ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String)get("ismt");}
	
	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String)get("revnDt");}
	
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String)get("revnAddr");}
	
	/** set 산재보험기호 : umytInsrSym */
	public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) { set("idtlAccdtInsurSym",idtlAccdtInsurSym);}
	/** get 산재보험기호 : umytInsrSym */
	public String getIdtlAccdtInsurSym() { return (String)get("idtlAccdtInsurSym");}
	
	/** set 건강보험영업소기호 : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String hlthInsrOfceSym) { set("hlthInsrOfceSym",hlthInsrOfceSym);}
	/** get 건강보험영업소기호 : insurPrvaffAgcyIstutNm */
	public String getHlthInsrOfceSym() { return (String)get("hlthInsrOfceSym");}
	
	public void setUntDpobFndtnUseYn(String untDpobFndtnUseYn) {set("untDpobFndtnUseYn",untDpobFndtnUseYn);}
	public String getUntDpobFndtnUseYn() {return (String)get("untDpobFndtnUseYn");}
	
	public void setUntDpobCd(String untDpobCd) {set("untDpobCd",untDpobCd);}
	public String getUntDpobCd() {return (String)get("untDpobCd");}

	
	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}
	/**
	 * @return the pageUnit
	 */
	public int getPageUnit() {
		return pageUnit;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}
	/**
	 * @return the lastIndex
	 */
	public int getLastIndex() {
		return lastIndex;
	}
	/**
	 * @return the recordCountPerPage
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @param pageUnit the pageUnit to set
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	/**
	 * @param lastIndex the lastIndex to set
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	/**
	 * @param recordCountPerPage the recordCountPerPage to set
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}


}
