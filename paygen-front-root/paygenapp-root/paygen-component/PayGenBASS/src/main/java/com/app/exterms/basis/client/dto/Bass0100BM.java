package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class Bass0100BM extends MSFSimpleBaseModel implements IsSerializable {

	/** 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** 사업장명 : dpobNm */
	public static final String ATTR_DPOBNM = "dpobNm";

	/** 대표자주민번호 : degtrResnRegnNum */
	public static final String ATTR_DEGTRRESNREGNNUM = "degtrResnRegnNum";
	
	/** 대표자주민번호원본 : degtrSecRegnNum */
	public static final String ATTR_DEGTRSECREGNNUM = "degtrSecRegnNum";

	/** 대표자명 : degtrNm */
	public static final String ATTR_DEGTRNM = "degtrNm";

	/** 사업자등록번호 : busoprRgstnNum */
	public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";

	/** 법인등록번호 : corpRgstnNum */
	public static final String ATTR_CORPRGSTNNUM = "corpRgstnNum";

	/** 법인구분코드 : corpDivCd */
	public static final String ATTR_CORPDIVCD = "corpDivCd";

	/** 사업장우편번호 : dpobZpcd */
	public static final String ATTR_DPOBZPCD = "dpobZpcd";

	/** 사업장기본주소 : dpobFndtnAddr */
	public static final String ATTR_DPOBFNDTNADDR = "dpobFndtnAddr";

	/** 사업장상세주소 : dpobDtlPatrAddr */
	public static final String ATTR_DPOBDTLPATRADDR = "dpobDtlPatrAddr";

	/** 사업장전화번호 : dpobPhnNum */
	public static final String ATTR_DPOBPHNNUM = "dpobPhnNum";

	/** 사업장팩스번호 : dpobFaxNum */
	public static final String ATTR_DPOBFAXNUM = "dpobFaxNum";

	/** 사업장직인문구명 : dpobSealWrdNm */
	public static final String ATTR_DPOBSEALWRDNM = "dpobSealWrdNm";

	/** 사업장직인경로 : dpobSealRftaNm */
	public static final String ATTR_DPOBSEALRFTANM = "dpobSealRftaNm";

	/** 사업장직인파일명 : dpobSealFlNm */
	public static final String ATTR_DPOBSEALFLNM = "dpobSealFlNm";

	/** 사업장기본사용여부 : dpobFndtnUseYn */
	public static final String ATTR_DPOBFNDTNUSEYN = "dpobFndtnUseYn";

	/** 건강보험기호 : hlthInsrSym */
	public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

	/** 국민연금기호 : natPennSym */
	public static final String ATTR_NATPENNSYM = "natPennSym";

	/** 고용보험기호 : umytInsrSym */
	public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

	/** 산재보험기호 : idtlAccdtInsurSym */
	public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";

	/** 입력자 : kybdr */
	public static final String ATTR_KYBDR = "kybdr";

	/** 입력일자 : inptDt */
	public static final String ATTR_INPTDT = "inptDt";

	/** 입력주소 : inptAddr */
	public static final String ATTR_INPTADDR = "inptAddr";

	/** 수정자 : ismt */
	public static final String ATTR_ISMT = "ismt";

	/** 수정일자 : revnDt */
	public static final String ATTR_REVNDT = "revnDt";

	/** 수정자주소 : revnAddr */
	public static final String ATTR_REVNADDR = "revnAddr";

	/** 시스템플래그(적용시스템) : sysDivCd */
	public static final String ATTR_SYSDIVCD = "sysDivCd";
	
	/** 시스템사업장코드 : sysDpobCd */
	public static final String ATTR_SYSDPOBCD = "sysDpobCd";

	/** 사업자 상위 구분 코드 : tplvlDpobCd */
	public static final String ATTR_TPLVLDPOBCD = "tplvlDpobCd";

	/** 징수의무자 구분 코드: retryCllnDebrDivCd */
	public static final String ATTR_RETRYCLLNDEBRDIVCD = "retryCllnDebrDivCd";

	/** 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
	public static final String ATTR_INSURPRVAFFAGCYISTUTNUM = "insurPrvaffAgcyIstutNum";

	/** 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
	public static final String ATTR_INSURPRVAFFAGCYISTUTNM = "insurPrvaffAgcyIstutNm";

	/** 건강보험영업소기호 : hlthInsrOfceSym */
	public static final String ATTR_HLTHINSROFCESYM = "hlthInsrOfceSym";
	
	/** set 주종사업장구분코드 : mtstBusinDivCd */
	public static final String ATTR_MTSTBUSINDIVCD = "mtstBusinDivCd";


	/** 생성자 */
	public Bass0100BM() {
		super();
	}

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) {
		set(ATTR_DPOBCD, dpobCd);
	}

	/** get 사업장코드 : dpobCd */
	public String getDpobCd() {
		return (String) get(ATTR_DPOBCD);
	}

	/** set 사업장명 : dpobNm */
	public void setDpobNm(String dpobNm) {
		set(ATTR_DPOBNM, dpobNm);
	}

	/** get 사업장명 : dpobNm */
	public String getDpobNm() {
		return (String) get(ATTR_DPOBNM);
	}

	/** set 대표자주민번호 : degtrResnRegnNum */
	public void setDegtrResnRegnNum(String degtrResnRegnNum) {
		set(ATTR_DEGTRRESNREGNNUM, degtrResnRegnNum);
	}

	/** get 대표자주민번호 : degtrResnRegnNum */
	public String getDegtrResnRegnNum() {
		return (String) get(ATTR_DEGTRRESNREGNNUM);
	}
	
	/** set 대표자주민번호 : degtrSecRegnNum */
	public void setDegtrSecRegnNum(String degtrSecRegnNum) {
		set(ATTR_DEGTRSECREGNNUM, degtrSecRegnNum);
	}

	/** get 대표자주민번호 : degtrSecRegnNum */
	public String getDegtrSecRegnNum() {
		return (String) get(ATTR_DEGTRSECREGNNUM);
	} 
	

	/** set 대표자명 : degtrNm */
	public void setDegtrNm(String degtrNm) {
		set(ATTR_DEGTRNM, degtrNm);
	}

	/** get 대표자명 : degtrNm */
	public String getDegtrNm() {
		return (String) get(ATTR_DEGTRNM);
	}

	/** set 사업자등록번호 : busoprRgstnNum */
	public void setBusoprRgstnNum(String busoprRgstnNum) {
		set(ATTR_BUSOPRRGSTNNUM, busoprRgstnNum);
	}

	/** get 사업자등록번호 : busoprRgstnNum */
	public String getBusoprRgstnNum() {
		return (String) get(ATTR_BUSOPRRGSTNNUM);
	}

	/** set 법인등록번호 : corpRgstnNum */
	public void setCorpRgstnNum(String corpRgstnNum) {
		set(ATTR_CORPRGSTNNUM, corpRgstnNum);
	}

	/** get 법인등록번호 : corpRgstnNum */
	public String getCorpRgstnNum() {
		return (String) get(ATTR_CORPRGSTNNUM);
	}

	/** set 법인구분코드 : corpDivCd */
	public void setCorpDivCd(String corpDivCd) {
		set(ATTR_CORPDIVCD, corpDivCd);
	}

	/** get 법인구분코드 : corpDivCd */
	public String getCorpDivCd() {
		return (String) get(ATTR_CORPDIVCD);
	}

	/** set 사업장우편번호 : dpobZpcd */
	public void setDpobZpcd(String dpobZpcd) {
		set(ATTR_DPOBZPCD, dpobZpcd);
	}

	/** get 사업장우편번호 : dpobZpcd */
	public String getDpobZpcd() {
		return (String) get(ATTR_DPOBZPCD);
	}

	/** set 사업장기본주소 : dpobFndtnAddr */
	public void setDpobFndtnAddr(String dpobFndtnAddr) {
		set(ATTR_DPOBFNDTNADDR, dpobFndtnAddr);
	}

	/** get 사업장기본주소 : dpobFndtnAddr */
	public String getDpobFndtnAddr() {
		return (String) get(ATTR_DPOBFNDTNADDR);
	}

	/** set 사업장상세주소 : dpobDtlPatrAddr */
	public void setDpobDtlPatrAddr(String dpobDtlPatrAddr) {
		set(ATTR_DPOBDTLPATRADDR, dpobDtlPatrAddr);
	}

	/** get 사업장상세주소 : dpobDtlPatrAddr */
	public String getDpobDtlPatrAddr() {
		return (String) get(ATTR_DPOBDTLPATRADDR);
	}

	/** set 사업장전화번호 : dpobPhnNum */
	public void setDpobPhnNum(String dpobPhnNum) {
		set(ATTR_DPOBPHNNUM, dpobPhnNum);
	}

	/** get 사업장전화번호 : dpobPhnNum */
	public String getDpobPhnNum() {
		return (String) get(ATTR_DPOBPHNNUM);
	}

	/** set 사업장팩스번호 : dpobFaxNum */
	public void setDpobFaxNum(String dpobFaxNum) {
		set(ATTR_DPOBFAXNUM, dpobFaxNum);
	}

	/** get 사업장팩스번호 : dpobFaxNum */
	public String getDpobFaxNum() {
		return (String) get(ATTR_DPOBFAXNUM);
	}

	/** set 사업장직인문구명 : dpobSealWrdNm */
	public void setDpobSealWrdNm(String dpobSealWrdNm) {
		set(ATTR_DPOBSEALWRDNM, dpobSealWrdNm);
	}

	/** get 사업장직인문구명 : dpobSealWrdNm */
	public String getDpobSealWrdNm() {
		return (String) get(ATTR_DPOBSEALWRDNM);
	}

	/** set 사업장직인경로 : dpobSealRftaNm */
	public void setDpobSealRftaNm(String dpobSealRftaNm) {
		set(ATTR_DPOBSEALRFTANM, dpobSealRftaNm);
	}

	/** get 사업장직인경로 : dpobSealRftaNm */
	public String getDpobSealRftaNm() {
		return (String) get(ATTR_DPOBSEALRFTANM);
	}

	/** set 사업장직인파일명 : dpobSealFlNm */
	public void setDpobSealFlNm(String dpobSealFlNm) {
		set(ATTR_DPOBSEALFLNM, dpobSealFlNm);
	}

	/** get 사업장직인파일명 : dpobSealFlNm */
	public String getDpobSealFlNm() {
		return (String) get(ATTR_DPOBSEALFLNM);
	}

	/** set 사업장기본사용여부 : dpobFndtnUseYn */
	public void setDpobFndtnUseYn(String dpobFndtnUseYn) {
		set(ATTR_DPOBFNDTNUSEYN, dpobFndtnUseYn);
	}

	/** get 사업장기본사용여부 : dpobFndtnUseYn */
	public String getDpobFndtnUseYn() {
		return (String) get(ATTR_DPOBFNDTNUSEYN);
	}

	/** set 건강보험기호 : hlthInsrSym */
	public void setHlthInsrSym(String hlthInsrSym) {
		set(ATTR_HLTHINSRSYM, hlthInsrSym);
	}

	/** get 건강보험기호 : hlthInsrSym */
	public String getHlthInsrSym() {
		return (String) get(ATTR_HLTHINSRSYM);
	}

	/** set 국민연금기호 : natPennSym */
	public void setNatPennSym(String natPennSym) {
		set(ATTR_NATPENNSYM, natPennSym);
	}

	/** get 국민연금기호 : natPennSym */
	public String getNatPennSym() {
		return (String) get(ATTR_NATPENNSYM);
	}

	/** set 고용보험기호 : umytInsrSym */
	public void setUmytInsrSym(String umytInsrSym) {
		set(ATTR_UMYTINSRSYM, umytInsrSym);
	}

	/** get 고용보험기호 : umytInsrSym */
	public String getUmytInsrSym() {
		return (String) get(ATTR_UMYTINSRSYM);
	}

	/** set 산재보험기호 : umytInsrSym */
	public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) {
		set("ATTR_IDTLACCDTINSURSYM", idtlAccdtInsurSym);
	}

	/** get 산재보험기호 : umytInsrSym */
	public String getIdtlAccdtInsurSym() {
		return (String) get("ATTR_IDTLACCDTINSURSYM");
	}

	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) {
		set(ATTR_KYBDR, kybdr);
	}

	/** get 입력자 : kybdr */
	public String getKybdr() {
		return (String) get(ATTR_KYBDR);
	}

	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) {
		set(ATTR_INPTDT, inptDt);
	}

	/** get 입력일자 : inptDt */
	public String getInptDt() {
		return (String) get(ATTR_INPTDT);
	}

	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) {
		set(ATTR_INPTADDR, inptAddr);
	}

	/** get 입력주소 : inptAddr */
	public String getInptAddr() {
		return (String) get(ATTR_INPTADDR);
	}

	/** set 수정자 : ismt */
	public void setIsmt(String ismt) {
		set(ATTR_ISMT, ismt);
	}

	/** get 수정자 : ismt */
	public String getIsmt() {
		return (String) get(ATTR_ISMT);
	}

	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) {
		set(ATTR_REVNDT, revnDt);
	}

	/** get 수정일자 : revnDt */
	public String getRevnDt() {
		return (String) get(ATTR_REVNDT);
	}

	/** set 수정자주소 : revnAddr */
	public void setRevnAddr(String revnAddr) {
		set(ATTR_REVNADDR, revnAddr);
	}

	/** get 수정자주소 : revnAddr */
	public String getRevnAddr() {
		return (String) get(ATTR_REVNADDR);
	}

	/** set null : sysDivCd */
	public void setSysDivCd(String sysDivCd) {
		set(ATTR_SYSDIVCD, sysDivCd);
	}

	/** get null : sysDivCd */
	public String getSysDivCd() {
		return (String) get(ATTR_SYSDIVCD);
	}
	
	
	/** set 시스템사업장코드 : sysDpobCdsysDpobCd */
	public void setSysDpobCd(String sysDpobCd) {
		set(ATTR_SYSDPOBCD, sysDpobCd);
	}

	/** get 시스템사업장코드 : sysDpobCd */
	public String getSysDpobCd() {
		return (String) get(ATTR_SYSDPOBCD);
	}

	/** set null : tplvlDpobCd */
	public void setTplvlDpobCd(String tplvlDpobCd) {
		set(ATTR_TPLVLDPOBCD, tplvlDpobCd);
	}

	/** get null : tplvlDpobCd */
	public String getTplvlDpobCd() {
		return (String) get(ATTR_TPLVLDPOBCD);
	}

	/** set 징수의무자 구분코드 : retryCllnDebrDivCd */
	public void setRetryCllnDebrDivCd(String retryCllnDebrDivCd) {
		set(ATTR_RETRYCLLNDEBRDIVCD, retryCllnDebrDivCd);
	}

	/** get 징수의무자 구분코드 : retryCllnDebrDivCd */
	public String getRetryCllnDebrDivCd() {
		return (String) get(ATTR_RETRYCLLNDEBRDIVCD);
	}

	/** set 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
	public void setInsurPrvaffAgcyIstutNum(String insurPrvaffAgcyIstutNum) {
		set(ATTR_INSURPRVAFFAGCYISTUTNUM, insurPrvaffAgcyIstutNum);
	}

	/** get 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
	public String getInsurPrvaffAgcyIstutNum() {
		return (String) get(ATTR_INSURPRVAFFAGCYISTUTNUM);
	}

	/** set 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
	public void setInsurPrvaffAgcyIstutNm(String insurPrvaffAgcyIstutNm) {
		set(ATTR_INSURPRVAFFAGCYISTUTNM, insurPrvaffAgcyIstutNm);
	}

	/** get 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
	public String getInsurPrvaffAgcyIstutNm() {
		return (String) get(ATTR_INSURPRVAFFAGCYISTUTNM);
	}

	/** set 건강보험영업소기호 : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String hlthInsrOfceSym) {
		set("hlthInsrOfceSym", hlthInsrOfceSym);
	}

	/** get 건강보험영업소기호 : insurPrvaffAgcyIstutNm */
	public String getHlthInsrOfceSym() {
		return (String) get("hlthInsrOfceSym");
	}
	
	/** set 주종사업장구분코드 : mtstBusinDivCd */
	public void setMtstBusinDivCd(String  mtstBusinDivCd) { set( ATTR_MTSTBUSINDIVCD ,mtstBusinDivCd);}
	/** get 주종사업장구분코드 : mtstBusinDivCd */
	public String  getMtstBusinDivCd() { return (String )get( ATTR_MTSTBUSINDIVCD );}

}
