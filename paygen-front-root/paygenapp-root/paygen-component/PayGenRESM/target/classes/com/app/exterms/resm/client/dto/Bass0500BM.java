package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0500VO.java
 * @Description : Bass0500 VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class Bass0500BM extends MSFSimpleBaseModel implements IsSerializable {
	private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	public static final String ATTR_DPOBNM = "dpobNm";
	
	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";
	public static final String ATTR_DEPTNM = "deptNm";

	/** set 사업적용년도 : businApptnYr */
	public static final String ATTR_BUSINAPPTNYR = "businApptnYr";

	/** set 사업코드 : businCd */
	public static final String ATTR_BUSINCD = "businCd";

	/** set 사업명 : businNm */
	public static final String ATTR_BUSINNM = "businNm";

	/** set 사업고용직종코드 : businEmymtTypOccuCd */
	public static final String ATTR_BUSINEMYMTTYPOCCUCD = "businEmymtTypOccuCd";

	public static final String ATTR_BUSINEMYMTTYPOCCUNM = "businEmymtTypOccuNm";

	/** set 사업담당직원번호 : businRepbtyEmpNum */
	public static final String ATTR_BUSINREPBTYEMPNUM = "businRepbtyEmpNum";

	/** set 산재보험요율 : idtlAccdtInsurApmrt */
	public static final String ATTR_IDTLACCDTINSURAPMRT = "idtlAccdtInsurApmrt";

	/** set 특기사항내용 : spityCtnt */
	public static final String ATTR_SPITYCTNT = "spityCtnt";

	/** set 국민연금기호 : natPennSym */
	public static final String ATTR_NATPENNSYM = "natPennSym";

	/** set 건강보험기호 : hlthInsrSym */
	public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

	/** set 고용보험기호 : umytInsrSym */
	public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

	/** set 산재보험기호 : idtlAccdtInsurSym */
	public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";

	/** set 입력자 : kybdr */
	public static final String ATTR_KYBDR = "kybdr";

	/** set 입력일자 : inptDt */
	public static final String ATTR_INPTDT = "inptDt";

	/** set 입력주소 : inptAddr */
	public static final String ATTR_INPTADDR = "inptAddr";

	/** set 수정자 : ismt */
	public static final String ATTR_ISMT = "ismt";

	/** set 수정일자 : revnDt */
	public static final String ATTR_REVNDT = "revnDt";

	/** set 수정자주소 : revnAddr */
	public static final String ATTR_REVNADDR = "revnAddr";
    
    /** set 건강보험영업소기호 : hlthInsrOfceSym */
    public static final String ATTR_HLTHINSROFCESYM = "hlthInsrOfceSym"; 

	/** set 근무일수 : businDutyNumDys */
	public static final String ATTR_BUSINDUTYNUMDYS = "businDutyNumDys";

	public static final String BUSIN_STDT = "businStdt";

	public static final String BUSIN_EDDT = "businEddt";

	/** 생성자 */
	public Bass0500BM() {
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

	/** set 부서코드 : deptCd */
	public void setDeptCd(String deptCd) {
		set(ATTR_DEPTCD, deptCd);
	}

	/** get 부서코드 : deptCd */
	public String getDeptCd() {
		return (String) get(ATTR_DEPTCD);
	}

	/** set 부서코드 : deptNm */
	public void setDeptNm(String deptNm) {
		set(ATTR_DEPTNM, deptNm);
	}

	/** get 부서코드 : deptNm */
	public String getDeptNm() {
		return (String) get(ATTR_DEPTNM);
	}

	/** set 사업적용년도 : businApptnYr */
	public void setBusinApptnYr(String businApptnYr) {
		set(ATTR_BUSINAPPTNYR, businApptnYr);
	}

	/** get 사업적용년도 : businApptnYr */
	public String getBusinApptnYr() {
		return (String) get(ATTR_BUSINAPPTNYR);
	}

	/** set 사업코드 : businCd */
	public void setBusinCd(String businCd) {
		set(ATTR_BUSINCD, businCd);
	}

	/** get 사업코드 : businCd */
	public String getBusinCd() {
		return (String) get(ATTR_BUSINCD);
	}

	/** set 사업명 : businNm */
	public void setBusinNm(String businNm) {
		set(ATTR_BUSINNM, businNm);
	}

	/** get 사업명 : businNm */
	public String getBusinNm() {
		return (String) get(ATTR_BUSINNM);
	}

	/** set 사업고용직종코드 : businEmymtTypOccuCd */
	public void setBusinEmymtTypOccuCd(String businEmymtTypOccuCd) {
		set(ATTR_BUSINEMYMTTYPOCCUCD, businEmymtTypOccuCd);
	}

	/** get 사업고용직종코드 : businEmymtTypOccuCd */
	public String getBusinEmymtTypOccuCd() {
		return (String) get(ATTR_BUSINEMYMTTYPOCCUCD);
	}
    
    /** set 건강보험영업소기호 : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String hlthInsrOfceSym) { set("ATTR_HLTHINSROFCESYM",hlthInsrOfceSym);}
	/** get 건강보험영업소기호 : hlthInsrOfceSym */
	public String getHlthInsrOfceSym() { return (String)get("ATTR_HLTHINSROFCESYM");}

	/** set 사업고용직종코드 : businEmymtTypOccuNm */
	public void setBusinEmymtTypOccuNm(String businEmymtTypOccuNm) {
		set(ATTR_BUSINEMYMTTYPOCCUNM, businEmymtTypOccuNm);
	}

	/** get 사업고용직종코드 : businEmymtTypOccuNm */
	public String getBusinEmymtTypOccuNm() {
		return (String) get(ATTR_BUSINEMYMTTYPOCCUNM);
	}

	/** set 사업담당직원번호 : businRepbtyEmpNum */
	public void setBusinRepbtyEmpNum(String businRepbtyEmpNum) {
		set(ATTR_BUSINREPBTYEMPNUM, businRepbtyEmpNum);
	}

	/** get 사업담당직원번호 : businRepbtyEmpNum */
	public String getBusinRepbtyEmpNum() {
		return (String) get(ATTR_BUSINREPBTYEMPNUM);
	}

	/** set 산재보험요율 : idtlAccdtInsurApmrt */
	public void setIdtlAccdtInsurApmrt(String idtlAccdtInsurApmrt) {
		set(ATTR_IDTLACCDTINSURAPMRT, idtlAccdtInsurApmrt);
	}

	/** get 산재보험요율 : idtlAccdtInsurApmrt */
	public String getIdtlAccdtInsurApmrt() {
		return (String) get(ATTR_IDTLACCDTINSURAPMRT);
	}

	/** set 특기사항내용 : spityCtnt */
	public void setSpityCtnt(String spityCtnt) {
		set(ATTR_SPITYCTNT, spityCtnt);
	}

	/** get 특기사항내용 : spityCtnt */
	public String getSpityCtnt() {
		return (String) get(ATTR_SPITYCTNT);
	}

	/** set 국민연금기호 : natPennSym */
	public void setNatPennSym(String natPennSym) {
		set(ATTR_NATPENNSYM, natPennSym);
	}

	/** get 국민연금기호 : natPennSym */
	public String getNatPennSym() {
		return (String) get(ATTR_NATPENNSYM);
	}

	/** set 건강보험기호 : hlthInsrSym */
	public void setHlthInsrSym(String hlthInsrSym) {
		set(ATTR_HLTHINSRSYM, hlthInsrSym);
	}

	/** get 건강보험기호 : hlthInsrSym */
	public String getHlthInsrSym() {
		return (String) get(ATTR_HLTHINSRSYM);
	}

	/** set 고용보험기호 : umytInsrSym */
	public void setUmytInsrSym(String umytInsrSym) {
		set(ATTR_UMYTINSRSYM, umytInsrSym);
	}

	/** get 고용보험기호 : umytInsrSym */
	public String getUmytInsrSym() {
		return (String) get(ATTR_UMYTINSRSYM);
	}

	/** set 산재보험기호 : idtlAccdtInsurSym */
	public void setIdtlAccdtInsurSym(String idtlAccdtInsurSym) {
		set(ATTR_IDTLACCDTINSURSYM, idtlAccdtInsurSym);
	}

	/** get 산재보험기호 : idtlAccdtInsurSym */
	public String getIdtlAccdtInsurSym() {
		return (String) get(ATTR_IDTLACCDTINSURSYM);
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

	/** set 근무일수 : businDutyNumDys */
	public void setBusinDutyNumDys(String businDutyNumDys) {
		set(ATTR_BUSINDUTYNUMDYS, businDutyNumDys);
	}

	/** get 근무일수 : businDutyNumDys */
	public String getBusinDutyNumDys() {
		return (String) get(ATTR_BUSINDUTYNUMDYS);
	}

	public void setBusinStdt(String businStdt) {
		set(BUSIN_STDT, businStdt);
	}

	public String getBusinStdt() {
		return (String) get(BUSIN_STDT);
	}

	public void setBusinEddt(String businEddt) {
		set(BUSIN_EDDT, businEddt);
	}

	public String getBusinEddt() {
		return (String) get(BUSIN_EDDT);
	}

	

	/** set 사업장코드 : dpobNm */
	public void setDpobNm(String dpobNm) { set(ATTR_DPOBNM,dpobNm);}
	/** get 사업장코드 : dpobNm */
	public String getDpobNm() { return (String)get(ATTR_DPOBNM);}
	
}
