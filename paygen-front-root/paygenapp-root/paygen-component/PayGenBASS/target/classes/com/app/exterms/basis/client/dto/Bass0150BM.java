package com.app.exterms.basis.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public class Bass0150BM  extends MSFSimpleBaseModel implements IsSerializable{
	
	public static final String ATTR_DPOBCD = "dpobCd";
	public static final String ATTR_DPOBNM = "dpobNm";
	public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";			
	public static final String ATTR_PAYMANGEDEPTNM = "payMangeDeptNm";	
	public static final String ATTR_DEGTRRESNREGNNUM = "degtrResnRegnNum";		

	/** 대표자주민번호원본 : degtrSecRegnNum */
	public static final String ATTR_DEGTRSECREGNNUM = "degtrSecRegnNum";


	public static final String ATTR_DEGTRNM = "degtrNm";			
	public static final String ATTR_BUSOPRRGSTNNUM = "busoprRgstnNum";			
	public static final String ATTR_CORPRGSTNNUM = "corpRgstnNum";			
	public static final String ATTR_CORPDIVCD = "corpDivCd";			
	public static final String ATTR_PAYMANGEDEPTZPCD = "payMangeDeptZpcd";			
	public static final String ATTR_PAYMANGEDEPTFNDTNADDR = "payMangeDeptFNdtnAddr";			
	public static final String ATTR_PAYMANGEDEPTDTLPATRADDR = "payMangeDeptDtlPatrAddr";			
	public static final String ATTR_PAYMANGEDEPTPHNNUM = "payMangeDeptPhnNum";			
	public static final String ATTR_PAYMANGEDEPTFAXNUM = "payMangeDeptFaxNum";			
	public static final String ATTR_PAYMANGEDEPTSEALWRDNM = "payMangeDeptSealWrdNm";			
	public static final String ATTR_PAYMANGEDEPTSEALRFTANM = "payMangeDeptSealRftaNm";			
	public static final String ATTR_PAYMANGEDEPTSEALFLNM = "payMangeDeptSealFlNm";			
	public static final String ATTR_PAYMANGEDEPTFNDTNUSEYN = "payMangeDeptFNdtnUseYn";			
	public static final String ATTR_PAYMANGEDEPTWHLEPERNCHRG = "payMangeDeptWhlePernChrg";
	public static final String ATTR_PAYMANGEDEPTWHLEPERNNM = "payMangeDeptWhlePernNm";
	public static final String ATTR_PAYMANGEDEPTDIVTSKOFFR = "payMangeDeptDivTskOffr";	
	public static final String ATTR_PAYMANGEDEPTDIVTSKNM = "payMangeDeptDivTskNm";	
	public static final String ATTR_ACCCD = "accCd";			
	public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";			
	public static final String ATTR_NATPENNSYM = "natPennSym";			
	public static final String ATTR_UMYTINSRSYM = "umytInsrSym";			
	public static final String ATTR_CLLNDEBRNM = "cllnDebrNm";			
	public static final String ATTR_HMTXID = "hmtxId";			
	public static final String ATTR_TXOFFCCD = "txOffcCd";			
	public static final String ATTR_BNKCD = "bnkCd";			
	public static final String ATTR_GROTNSRCD = "groTnsrCd";			
	public static final String ATTR_KYBDR = "kybdr";			
	public static final String ATTR_INPTDT = "inptDt";			
	public static final String ATTR_INPTADDR = "inptAddr";			
	public static final String ATTR_ISMT = "ismt";			
	public static final String ATTR_REVNDT = "revnDt";			
	public static final String ATTR_REVNADDR = "revnAddr";	
	public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";
	public static final String ATTR_HLTHINSROFCESYM = "hlthInsrOfceSym"; 
	
	/** 생성자 */
	public Bass0150BM() { super(); } 
	
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) { set(ATTR_DPOBCD,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String)get(ATTR_DPOBCD);}
	
	
	/** set 사업장코드 : dpobNm */
	public void setDpobNm(String dpobNm) { set(ATTR_DPOBNM,dpobNm);}
	/** get 사업장코드 : dpobNm */
	public String getDpobNm() { return (String)get(ATTR_DPOBNM);}
	
	/** set 단위기관코드 : payrMangDeptCd */
	public void setPayrMangDeptCd(String payrMangDeptCd) { set(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);}
	/** get 단위기관코드 : payrMangDeptCd */
	public String getPayrMangDeptCd() { return (String)get(ATTR_PAYRMANGDEPTCD);}
	
	/** set 단위기관명 : payMangeDeptNm */
	public void setPayMangeDeptNm(String payMangeDeptNm) { set(ATTR_PAYMANGEDEPTNM,payMangeDeptNm);}
	/** get 단위기관명 : payMangeDeptNm */
	public String getPayMangeDeptNm() { return (String)get(ATTR_PAYMANGEDEPTNM);}
	
	/** set 대표자주민번호 : degtrResnRegnNum */
	public void setDegtrResnRegnNum(String degtrResnRegnNum) { set(ATTR_DEGTRRESNREGNNUM,degtrResnRegnNum);}
	/** get 대표자주민번호 : degtrResnRegnNum */
	public String getDegtrResnRegnNum() { return (String)get(ATTR_DEGTRRESNREGNNUM);}
	
	/** set 대표자명 : degtrNm */
	public void setDegtrNm(String degtrNm) { set(ATTR_DEGTRNM,degtrNm);}
	/** get 대표자명 : degtrNm */
	public String getDegtrNm() { return (String)get(ATTR_DEGTRNM);}
	
	/** set 사업자등록번호 : busoprRgstnNum */
	public void setBusoprRgstnNum(String busoprRgstnNum) { set(ATTR_BUSOPRRGSTNNUM,busoprRgstnNum);}
	/** get 사업자등록번호 : busoprRgstnNum */
	public String getBusoprRgstnNum() { return (String)get(ATTR_BUSOPRRGSTNNUM);}
	
	/** set 법인등록번호 : corpRgstnNum */
	public void setCorpRgstnNum(String corpRgstnNum) { set(ATTR_CORPRGSTNNUM,corpRgstnNum);}
	/** get 법인등록번호 : corpRgstnNum */
	public String getCorpRgstnNum() { return (String)get(ATTR_CORPRGSTNNUM);}
	
	/** set 법인구분코드 : corpDivCd */
	public void setCorpDivCd(String corpDivCd) { set(ATTR_CORPDIVCD,corpDivCd);}
	/** get 법인구분코드 : corpDivCd */
	public String getCorpDivCd() { return (String)get(ATTR_CORPDIVCD);}
	
	/** set 단위기관우편번호 : payMangeDeptZpcd */
	public void setPayMangeDeptZpcd(String payMangeDeptZpcd) { set(ATTR_PAYMANGEDEPTZPCD,payMangeDeptZpcd);}
	/** get 단위기관우편번호 : payMangeDeptZpcd */
	public String getPayMangeDeptZpcd() { return (String)get(ATTR_PAYMANGEDEPTZPCD);}
	
	/** set 단위기관기본주소 : payMangeDeptFNdtnAddr */
	public void setPayMangeDeptFNdtnAddr(String payMangeDeptFNdtnAddr) { set(ATTR_PAYMANGEDEPTFNDTNADDR,payMangeDeptFNdtnAddr);}
	/** get 단위기관기본주소 : payMangeDeptFNdtnAddr */
	public String getPayMangeDeptFNdtnAddr() { return (String)get(ATTR_PAYMANGEDEPTFNDTNADDR);}
	
	/** set 단위기관상세주소 : payMangeDeptDtlPatrAddr */
	public void setPayMangeDeptDtlPatrAddr(String payMangeDeptDtlPatrAddr) { set(ATTR_PAYMANGEDEPTDTLPATRADDR,payMangeDeptDtlPatrAddr);}
	/** get 단위기관상세주소 : payMangeDeptDtlPatrAddr */
	public String getPayMangeDeptDtlPatrAddr() { return (String)get(ATTR_PAYMANGEDEPTDTLPATRADDR);}
	
	/** set 단위기관전화번호 : payMangeDeptPhnNum */
	public void setPayMangeDeptPhnNum(String payMangeDeptPhnNum) { set(ATTR_PAYMANGEDEPTPHNNUM,payMangeDeptPhnNum);}
	/** get 단위기관전화번호 : payMangeDeptPhnNum */
	public String getPayMangeDeptPhnNum() { return (String)get(ATTR_PAYMANGEDEPTPHNNUM);}
	
	/** set 단위기관팩스번호 : payMangeDeptFaxNum */
	public void setPayMangeDeptFaxNum(String payMangeDeptFaxNum) { set(ATTR_PAYMANGEDEPTFAXNUM,payMangeDeptFaxNum);}
	/** get 단위기관팩스번호 : payMangeDeptFaxNum */
	public String getPayMangeDeptFaxNum() { return (String)get(ATTR_PAYMANGEDEPTFAXNUM);}
	
	/** set 단위기관직인문구명 : payMangeDeptSealWrdNm */
	public void setPayMangeDeptSealWrdNm(String payMangeDeptSealWrdNm) { set(ATTR_PAYMANGEDEPTSEALWRDNM,payMangeDeptSealWrdNm);}
	/** get 단위기관직인문구명 : payMangeDeptSealWrdNm */
	public String getPayMangeDeptSealWrdNm() { return (String)get(ATTR_PAYMANGEDEPTSEALWRDNM);}
	
	/** set 단위기관직인경로 : payMangeDeptSealRftaNm */
	public void setPayMangeDeptSealRftaNm(String payMangeDeptSealRftaNm) { set(ATTR_PAYMANGEDEPTSEALRFTANM,payMangeDeptSealRftaNm);}
	/** get 단위기관직인경로 : payMangeDeptSealRftaNm */
	public String getPayMangeDeptSealRftaNm() { return (String)get(ATTR_PAYMANGEDEPTSEALRFTANM);}
	
	/** set 단위기관직인파일명 : payMangeDeptSealFlNm */
	public void setPayMangeDeptSealFlNm(String payMangeDeptSealFlNm) { set(ATTR_PAYMANGEDEPTSEALFLNM,payMangeDeptSealFlNm);}
	/** get 단위기관직인파일명 : payMangeDeptSealFlNm */
	public String getPayMangeDeptSealFlNm() { return (String)get(ATTR_PAYMANGEDEPTSEALFLNM);}
	
	/** set 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
	public void setPayMangeDeptFNdtnUseYn(String payMangeDeptFNdtnUseYn) { set(ATTR_PAYMANGEDEPTFNDTNUSEYN,payMangeDeptFNdtnUseYn);}
	/** get 단위기관기본사용여부 : payMangeDeptFNdtnUseYn */
	public String getPayMangeDeptFNdtnUseYn() { return (String)get(ATTR_PAYMANGEDEPTFNDTNUSEYN);}
	
	/** set 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
	public void setPayMangeDeptWhlePernChrg(String payMangeDeptWhlePernChrg) { set(ATTR_PAYMANGEDEPTWHLEPERNCHRG,payMangeDeptWhlePernChrg);}
	/** get 단위기관총괄담당자 : payMangeDeptWhlePernChrg */
	public String getPayMangeDeptWhlePernChrg() { return (String)get(ATTR_PAYMANGEDEPTWHLEPERNCHRG);}
	
	/** set 단위기관총괄담당자명 : payMangeDeptWhlePernNm */
	public void setPayMangeDeptWhlePernNm(String payMangeDeptWhlePernNm) { set(ATTR_PAYMANGEDEPTWHLEPERNNM,payMangeDeptWhlePernNm);}
	/** get 단위기관총괄담당자명 : payMangeDeptWhlePernNm */
	public String getPayMangeDeptWhlePernNm() { return (String)get(ATTR_PAYMANGEDEPTWHLEPERNNM);}
	
	
	/** set 단위기관분임지출관 : payMangeDeptDivTskOffr */
	public void setPayMangeDeptDivTskOffr(String payMangeDeptDivTskOffr) { set(ATTR_PAYMANGEDEPTDIVTSKOFFR,payMangeDeptDivTskOffr);}
	/** get 단위기관분임지출관 : payMangeDeptDivTskOffr */
	public String getPayMangeDeptDivTskOffr() { return (String)get(ATTR_PAYMANGEDEPTDIVTSKOFFR);}
	
	/** set 단위기관분임지출관명 : payMangeDeptDivTskOffr */
	public void setPayMangeDeptDivTskNm(String payMangeDeptDivTskNm) { set(ATTR_PAYMANGEDEPTDIVTSKNM,payMangeDeptDivTskNm);}
	/** get 단위기관분임지출관명 : payMangeDeptDivTskOffr */
	public String getPayMangeDeptDivTskNm() { return (String)get(ATTR_PAYMANGEDEPTDIVTSKNM);}
	
	/** set 회계코드 : accCd */
	public void setAccCd(String accCd) { set(ATTR_ACCCD,accCd);}
	/** get 회계코드 : accCd */
	public String getAccCd() { return (String)get(ATTR_ACCCD);}
	
	/** set 건강보험기호 : hlthInsrSym */
	public void setHlthInsrSym(String hlthInsrSym) { set(ATTR_HLTHINSRSYM,hlthInsrSym);}
	/** get 건강보험기호 : hlthInsrSym */
	public String getHlthInsrSym() { return (String)get(ATTR_HLTHINSRSYM);}
	
	/** set 국민연금기호 : natPennSym */
	public void setNatPennSym(String natPennSym) { set(ATTR_NATPENNSYM,natPennSym);}
	/** get 국민연금기호 : natPennSym */
	public String getNatPennSym() { return (String)get(ATTR_NATPENNSYM);}
	
	/** set 고용보험기호 : umytInsrSym */
	public void setUmytInsrSym(String umytInsrSym) { set(ATTR_UMYTINSRSYM,umytInsrSym);}
	/** get 고용보험기호 : umytInsrSym */
	public String getUmytInsrSym() { return (String)get(ATTR_UMYTINSRSYM);}
	
	/** set 징수의무자명 : cllnDebrNm */
	public void setCllnDebrNm(String cllnDebrNm) { set(ATTR_CLLNDEBRNM,cllnDebrNm);}
	/** get 징수의무자명 : cllnDebrNm */
	public String getCllnDebrNm() { return (String)get(ATTR_CLLNDEBRNM);}
	
	/** set 홈텍스ID : hmtxId */
	public void setHmtxId(String hmtxId) { set(ATTR_HMTXID,hmtxId);}
	/** get 홈텍스ID : hmtxId */
	public String getHmtxId() { return (String)get(ATTR_HMTXID);}
	
	/** set 세무서코드 : txOffcCd */
	public void setTxOffcCd(String txOffcCd) { set(ATTR_TXOFFCCD,txOffcCd);}
	/** get 세무서코드 : txOffcCd */
	public String getTxOffcCd() { return (String)get(ATTR_TXOFFCCD);}
	
	/** set 은행코드 : bnkCd */
	public void setBnkCd(String bnkCd) { set(ATTR_BNKCD,bnkCd);}
	/** get 은행코드 : bnkCd */
	public String getBnkCd() { return (String)get(ATTR_BNKCD);}
	
	/** set 지로이체코드 : groTnsrCd */
	public void setGroTnsrCd(String groTnsrCd) { set(ATTR_GROTNSRCD,groTnsrCd);}
	/** get 지로이체코드 : groTnsrCd */
	public String getGroTnsrCd() { return (String)get(ATTR_GROTNSRCD);}
	
	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) { set(ATTR_KYBDR,kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String)get(ATTR_KYBDR);}
	
	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) { set(ATTR_INPTDT,inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String)get(ATTR_INPTDT);}
	
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) { set(ATTR_INPTADDR,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String)get(ATTR_INPTADDR);}
	
	/** set 수정자 : ismt */
	public void setIsmt(String ismt) { set(ATTR_ISMT,ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String)get(ATTR_ISMT);}
	
	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) { set(ATTR_REVNDT,revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String)get(ATTR_REVNDT);}
	
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set(ATTR_REVNADDR,revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String)get(ATTR_REVNADDR);}
	
	/** set 산재보험기호 : umytInsrSym */
	public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) { set("ATTR_IDTLACCDTINSURSYM",idtlAccdtInsurSym);}
	/** get 산재보험기호 : umytInsrSym */
	public String getIdtlAccdtInsurSym() { return (String)get("ATTR_IDTLACCDTINSURSYM");}
	
	/** set 건강보험영업소기호 : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String hlthInsrOfceSym) { set("ATTR_HLTHINSROFCESYM",hlthInsrOfceSym);}
	/** get 건강보험영업소기호 : insurPrvaffAgcyIstutNm */
	public String getHlthInsrOfceSym() { return (String)get("ATTR_HLTHINSROFCESYM");}
	
	/** set 대표자주민번호 : degtrSecRegnNum */
	public void setDegtrSecRegnNum(String degtrSecRegnNum) {
		set(ATTR_DEGTRSECREGNNUM, degtrSecRegnNum);
	}

	/** get 대표자주민번호 : degtrSecRegnNum */
	public String getDegtrSecRegnNum() {
		return (String) get(ATTR_DEGTRSECREGNNUM);
	}
	 
	
	
}
