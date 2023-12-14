package com.app.exterms.basis.client.dto;

import java.math.BigDecimal;

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
public class InfcPkgBass0500BM extends MSFSimpleBaseModel implements IsSerializable {
	private static final long serialVersionUID = 1L;

	public static final String ATTR_SELECT = "select";
	
	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	/** set 사업코드 : businCd */
	public static final String ATTR_BUSINCD = "businCd";

	/** set 부서코드 : deptCd */
	public static final String ATTR_DEPTCD = "deptCd";
	
	/** set 부서코드 : deptNm */
	public static final String ATTR_DEPTNM = "deptNm";

	/** set 사업적용년도 : businApptnYr */
	public static final String ATTR_BUSINAPPTNYR = "businApptnYr";

	/** set 급여인사관리부서사용여부 : payMangeDeptUseYn */
	public static final String ATTR_PAYMANGEDEPTUSEYN = "payMangeDeptUseYn";

	/** set 관리부서코드 : mangeDeptCd */
	public static final String ATTR_MANGEDEPTCD = "mangeDeptCd";

	/** set 사업명 : businNm */
	public static final String ATTR_BUSINNM = "businNm";

	/** set null : repbtyBusinDivCd */
	public static final String ATTR_REPBTYBUSINDIVCD = "repbtyBusinDivCd";

	/** set 사업고용직종코드 : businEmymtTypOccuCd */
	public static final String ATTR_BUSINEMYMTTYPOCCUCD = "businEmymtTypOccuCd";

	/** set 사업담당직원번호X : businRepbtyEmpNum */
	public static final String ATTR_BUSINREPBTYEMPNUM = "businRepbtyEmpNum";

	/** set 산재보험적용요율 : idtlAccdtInsurApmrt */
	public static final String ATTR_IDTLACCDTINSURAPMRT = "idtlAccdtInsurApmrt";

	/** set 특기사항내용 : spityCtnt */
	public static final String ATTR_SPITYCTNT = "spityCtnt";

	/** set 국민연금기호X : natPennSym */
	public static final String ATTR_NATPENNSYM = "natPennSym";

	/** set 건강보험기호X : hlthInsrSym */
	public static final String ATTR_HLTHINSRSYM = "hlthInsrSym";

	/** set 고용보험기호X : umytInsrSym */
	public static final String ATTR_UMYTINSRSYM = "umytInsrSym";

	/** set 산재보험기호X : idtlAccdtInsurSym */
	public static final String ATTR_IDTLACCDTINSURSYM = "idtlAccdtInsurSym";

	/** set 사업기간시작일자 : businStdt */
	public static final String ATTR_BUSINSTDT = "businStdt";

	/** set 사업기간종료일자 : businEddt */
	public static final String ATTR_BUSINEDDT = "businEddt";

	/** set 건강보험영업소기호X : hlthInsrOfceSym */
	public static final String ATTR_HLTHINSROFCESYM = "hlthInsrOfceSym";

	/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
	public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

	/** set 고용구분코드 : emymtDivCd */
	public static final String ATTR_EMYMTDIVCD = "emymtDivCd";

	/** set 과세유형구분코드 : txtnFrmDivCd */
	public static final String ATTR_TXTNFRMDIVCD = "txtnFrmDivCd";

	/** set 단위사업장코드 : untDpobCd */
	public static final String ATTR_UNTDPOBCD = "untDpobCd";
	
	/** set 단위사업장명 : utDpobNm */
	public static final String ATTR_UNTDPOBNM = "untDpobNm";

	/** set 사대보험사업장기호통합코드 : socInsrSymInttnCd */
	public static final String ATTR_SOCINSRSYMINTTNCD = "socInsrSymInttnCd";

	/** set 사업회계코드 : businAccCd */
	public static final String ATTR_BUSINACCCD = "businAccCd";

	/** set 상위부서코드01 : hhrkDeptCd01 */
	public static final String ATTR_HHRKDEPTCD01 = "hhrkDeptCd01";

	/** set 상위부서코드02 : hhrkDeptCd02 */
	public static final String ATTR_HHRKDEPTCD02 = "hhrkDeptCd02";

	/** set 사업사용여부 : businUseYn */
	public static final String ATTR_BUSINUSEYN = "businUseYn";

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

	/** set 수정주소 : revnAddr */
	public static final String ATTR_REVNADDR = "revnAddr";

	/** set 원천세징수유형구분코드 : whdgTxCtypDivCd */
	public static final String ATTR_WHDGTXCTYPDIVCD = "whdgTxCtypDivCd";

	/** 생성자 */
	 public InfcPkgBass0500BM() { super(); } 

	/** 일괄등록 처리   */
	 public InfcPkgBass0500BM(
			 Boolean  select 
			, String  dpobCd 
			, String  businCd 
			, String  deptCd 
			, String  deptNm 
			, String  businApptnYr 
			, String  payMangeDeptUseYn 
			, String  mangeDeptCd 
			, String  businNm 
			, String  repbtyBusinDivCd 
			, String  businEmymtTypOccuCd 
			, String  businRepbtyEmpNum 
			, BigDecimal  idtlAccdtInsurApmrt 
			, String  spityCtnt 
			, String  natPennSym 
			, String  hlthInsrSym 
			, String  umytInsrSym 
			, String  idtlAccdtInsurSym 
			, String  businStdt 
			, String  businEddt 
			, String  hlthInsrOfceSym 
			, String  dtilOcclsApptnUcstCd 
			, String  emymtDivCd 
			, String  txtnFrmDivCd 
			, String  untDpobCd 
			, String  untDpobNm
			, String  socInsrSymInttnCd 
			, String  businAccCd 
			, String  hhrkDeptCd01 
			, String  hhrkDeptCd02 
			, String  businUseYn 
			, String  kybdr 
			, String  inptDt 
			, String  inptAddr 
			, String  ismt 
			, String  revnDt 
			, String  revnAddr 
			, String  whdgTxCtypDivCd ) { 
		values.put(ATTR_SELECT,select);
	 	values.put(ATTR_DPOBCD,dpobCd);
	 	values.put(ATTR_BUSINCD,businCd);
	 	values.put(ATTR_DEPTCD,deptCd);
	 	values.put(ATTR_DEPTNM,deptNm);
	 	values.put(ATTR_BUSINAPPTNYR,businApptnYr);
	 	values.put(ATTR_PAYMANGEDEPTUSEYN,payMangeDeptUseYn);
	 	values.put(ATTR_MANGEDEPTCD,mangeDeptCd);
	 	values.put(ATTR_BUSINNM,businNm);
	 	values.put(ATTR_REPBTYBUSINDIVCD,repbtyBusinDivCd);
	 	values.put(ATTR_BUSINEMYMTTYPOCCUCD,businEmymtTypOccuCd);
	 	values.put(ATTR_BUSINREPBTYEMPNUM,businRepbtyEmpNum);
	 	values.put(ATTR_IDTLACCDTINSURAPMRT,idtlAccdtInsurApmrt);
	 	values.put(ATTR_SPITYCTNT,spityCtnt);
	 	values.put(ATTR_NATPENNSYM,natPennSym);
	 	values.put(ATTR_HLTHINSRSYM,hlthInsrSym);
	 	values.put(ATTR_UMYTINSRSYM,umytInsrSym);
	 	values.put(ATTR_IDTLACCDTINSURSYM,idtlAccdtInsurSym);
	 	values.put(ATTR_BUSINSTDT,businStdt);
	 	values.put(ATTR_BUSINEDDT,businEddt);
	 	values.put(ATTR_HLTHINSROFCESYM,hlthInsrOfceSym);
	 	values.put(ATTR_DTILOCCLSAPPTNUCSTCD,dtilOcclsApptnUcstCd);
	 	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
	 	values.put(ATTR_TXTNFRMDIVCD,txtnFrmDivCd);
	 	values.put(ATTR_UNTDPOBCD,untDpobCd);
	 	values.put(ATTR_UNTDPOBNM,untDpobNm);
	 	values.put(ATTR_SOCINSRSYMINTTNCD,socInsrSymInttnCd);
	 	values.put(ATTR_BUSINACCCD,businAccCd);
	 	values.put(ATTR_HHRKDEPTCD01,hhrkDeptCd01);
	 	values.put(ATTR_HHRKDEPTCD02,hhrkDeptCd02);
	 	values.put(ATTR_BUSINUSEYN,businUseYn);
	 	values.put(ATTR_KYBDR,kybdr);
	 	values.put(ATTR_INPTDT,inptDt);
	 	values.put(ATTR_INPTADDR,inptAddr);
	 	values.put(ATTR_ISMT,ismt);
	 	values.put(ATTR_REVNDT,revnDt);
	 	values.put(ATTR_REVNADDR,revnAddr);
	 	values.put(ATTR_WHDGTXCTYPDIVCD,whdgTxCtypDivCd); } 

	public void setSelect(String  select) { set( ATTR_SELECT ,select);}
	public String  getSelect() { return (String )get( ATTR_SELECT);}
	 
	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
	/** set 사업코드 : businCd */
	public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
	/** get 사업코드 : businCd */
	public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}
	/** set 부서코드 : deptCd */
	public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
	/** get 부서코드 : deptCd */
	public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}
	/** set 부서명 : deptNm */
	public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
	/** get 부서명 : deptNm */
	public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}
	/** set 사업적용년도 : businApptnYr */
	public void setBusinApptnYr(String  businApptnYr) { set( ATTR_BUSINAPPTNYR ,businApptnYr);}
	/** get 사업적용년도 : businApptnYr */
	public String  getBusinApptnYr() { return (String )get( ATTR_BUSINAPPTNYR );}
	/** set 급여인사관리부서사용여부 : payMangeDeptUseYn */
	public void setPayMangeDeptUseYn(String  payMangeDeptUseYn) { set( ATTR_PAYMANGEDEPTUSEYN ,payMangeDeptUseYn);}
	/** get 급여인사관리부서사용여부 : payMangeDeptUseYn */
	public String  getPayMangeDeptUseYn() { return (String )get( ATTR_PAYMANGEDEPTUSEYN );}
	/** set 관리부서코드 : mangeDeptCd */
	public void setMangeDeptCd(String  mangeDeptCd) { set( ATTR_MANGEDEPTCD ,mangeDeptCd);}
	/** get 관리부서코드 : mangeDeptCd */
	public String  getMangeDeptCd() { return (String )get( ATTR_MANGEDEPTCD );}
	/** set 사업명 : businNm */
	public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
	/** get 사업명 : businNm */
	public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
	/** set null : repbtyBusinDivCd */
	public void setRepbtyBusinDivCd(String  repbtyBusinDivCd) { set( ATTR_REPBTYBUSINDIVCD ,repbtyBusinDivCd);}
	/** get null : repbtyBusinDivCd */
	public String  getRepbtyBusinDivCd() { return (String )get( ATTR_REPBTYBUSINDIVCD );}
	/** set 사업고용직종코드 : businEmymtTypOccuCd */
	public void setBusinEmymtTypOccuCd(String  businEmymtTypOccuCd) { set( ATTR_BUSINEMYMTTYPOCCUCD ,businEmymtTypOccuCd);}
	/** get 사업고용직종코드 : businEmymtTypOccuCd */
	public String  getBusinEmymtTypOccuCd() { return (String )get( ATTR_BUSINEMYMTTYPOCCUCD );}
	/** set 사업담당직원번호X : businRepbtyEmpNum */
	public void setBusinRepbtyEmpNum(String  businRepbtyEmpNum) { set( ATTR_BUSINREPBTYEMPNUM ,businRepbtyEmpNum);}
	/** get 사업담당직원번호X : businRepbtyEmpNum */
	public String  getBusinRepbtyEmpNum() { return (String )get( ATTR_BUSINREPBTYEMPNUM );}
	/** set 산재보험적용요율 : idtlAccdtInsurApmrt */
	public void setIdtlAccdtInsurApmrt(BigDecimal  idtlAccdtInsurApmrt) { set( ATTR_IDTLACCDTINSURAPMRT ,idtlAccdtInsurApmrt);}
	/** get 산재보험적용요율 : idtlAccdtInsurApmrt */
	public BigDecimal  getIdtlAccdtInsurApmrt() { return (BigDecimal )get( ATTR_IDTLACCDTINSURAPMRT );}
	/** set 특기사항내용 : spityCtnt */
	public void setSpityCtnt(String  spityCtnt) { set( ATTR_SPITYCTNT ,spityCtnt);}
	/** get 특기사항내용 : spityCtnt */
	public String  getSpityCtnt() { return (String )get( ATTR_SPITYCTNT );}
	/** set 국민연금기호X : natPennSym */
	public void setNatPennSym(String  natPennSym) { set( ATTR_NATPENNSYM ,natPennSym);}
	/** get 국민연금기호X : natPennSym */
	public String  getNatPennSym() { return (String )get( ATTR_NATPENNSYM );}
	/** set 건강보험기호X : hlthInsrSym */
	public void setHlthInsrSym(String  hlthInsrSym) { set( ATTR_HLTHINSRSYM ,hlthInsrSym);}
	/** get 건강보험기호X : hlthInsrSym */
	public String  getHlthInsrSym() { return (String )get( ATTR_HLTHINSRSYM );}
	/** set 고용보험기호X : umytInsrSym */
	public void setUmytInsrSym(String  umytInsrSym) { set( ATTR_UMYTINSRSYM ,umytInsrSym);}
	/** get 고용보험기호X : umytInsrSym */
	public String  getUmytInsrSym() { return (String )get( ATTR_UMYTINSRSYM );}
	/** set 산재보험기호X : idtlAccdtInsurSym */
	public void setIdtlAccdtInsurSym(String  idtlAccdtInsurSym) { set( ATTR_IDTLACCDTINSURSYM ,idtlAccdtInsurSym);}
	/** get 산재보험기호X : idtlAccdtInsurSym */
	public String  getIdtlAccdtInsurSym() { return (String )get( ATTR_IDTLACCDTINSURSYM );}
	/** set 사업기간시작일자 : businStdt */
	public void setBusinStdt(String  businStdt) { set( ATTR_BUSINSTDT ,businStdt);}
	/** get 사업기간시작일자 : businStdt */
	public String  getBusinStdt() { return (String )get( ATTR_BUSINSTDT );}
	/** set 사업기간종료일자 : businEddt */
	public void setBusinEddt(String  businEddt) { set( ATTR_BUSINEDDT ,businEddt);}
	/** get 사업기간종료일자 : businEddt */
	public String  getBusinEddt() { return (String )get( ATTR_BUSINEDDT );}
	/** set 건강보험영업소기호X : hlthInsrOfceSym */
	public void setHlthInsrOfceSym(String  hlthInsrOfceSym) { set( ATTR_HLTHINSROFCESYM ,hlthInsrOfceSym);}
	/** get 건강보험영업소기호X : hlthInsrOfceSym */
	public String  getHlthInsrOfceSym() { return (String )get( ATTR_HLTHINSROFCESYM );}
	/** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
	public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
	/** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
	public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}
	/** set 고용구분코드 : emymtDivCd */
	public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
	/** get 고용구분코드 : emymtDivCd */
	public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}
	/** set 과세유형구분코드 : txtnFrmDivCd */
	public void setTxtnFrmDivCd(String  txtnFrmDivCd) { set( ATTR_TXTNFRMDIVCD ,txtnFrmDivCd);}
	/** get 과세유형구분코드 : txtnFrmDivCd */
	public String  getTxtnFrmDivCd() { return (String )get( ATTR_TXTNFRMDIVCD );}
	/** set 단위사업장코드 : untDpobCd */
	public void setUntDpobCd(String  untDpobCd) { set( ATTR_UNTDPOBCD ,untDpobCd);}
	/** get 단위사업장코드 : untDpobCd */
	public String  getUntDpobCd() { return (String )get( ATTR_UNTDPOBCD );}
	/** set 단위사업장명 : utDpobNm */
	public void setUntDpobNm(String  untDpobNm) { set( ATTR_UNTDPOBNM ,untDpobNm);}
	/** get 단위사업장명 : utDpobNm */
	public String  getUntDpobNm() { return (String )get( ATTR_UNTDPOBNM );}
	/** set 사대보험사업장기호통합코드 : socInsrSymInttnCd */
	public void setSocInsrSymInttnCd(String  socInsrSymInttnCd) { set( ATTR_SOCINSRSYMINTTNCD ,socInsrSymInttnCd);}
	/** get 사대보험사업장기호통합코드 : socInsrSymInttnCd */
	public String  getSocInsrSymInttnCd() { return (String )get( ATTR_SOCINSRSYMINTTNCD );}
	/** set 사업회계코드 : businAccCd */
	public void setBusinAccCd(String  businAccCd) { set( ATTR_BUSINACCCD ,businAccCd);}
	/** get 사업회계코드 : businAccCd */
	public String  getBusinAccCd() { return (String )get( ATTR_BUSINACCCD );}
	/** set 상위부서코드01 : hhrkDeptCd01 */
	public void setHhrkDeptCd01(String  hhrkDeptCd01) { set( ATTR_HHRKDEPTCD01 ,hhrkDeptCd01);}
	/** get 상위부서코드01 : hhrkDeptCd01 */
	public String  getHhrkDeptCd01() { return (String )get( ATTR_HHRKDEPTCD01 );}
	/** set 상위부서코드02 : hhrkDeptCd02 */
	public void setHhrkDeptCd02(String  hhrkDeptCd02) { set( ATTR_HHRKDEPTCD02 ,hhrkDeptCd02);}
	/** get 상위부서코드02 : hhrkDeptCd02 */
	public String  getHhrkDeptCd02() { return (String )get( ATTR_HHRKDEPTCD02 );}
	/** set 사업사용여부 : businUseYn */
	public void setBusinUseYn(String  businUseYn) { set( ATTR_BUSINUSEYN ,businUseYn);}
	/** get 사업사용여부 : businUseYn */
	public String  getBusinUseYn() { return (String )get( ATTR_BUSINUSEYN );}
	/** set 입력자 : kybdr */
	public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
	/** get 입력자 : kybdr */
	public String  getKybdr() { return (String )get( ATTR_KYBDR );}
	/** set 입력일자 : inptDt */
	public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
	/** get 입력일자 : inptDt */
	public String  getInptDt() { return (String )get( ATTR_INPTDT );}
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}
	/** set 수정자 : ismt */
	public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
	/** get 수정자 : ismt */
	public String  getIsmt() { return (String )get( ATTR_ISMT );}
	/** set 수정일자 : revnDt */
	public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
	/** get 수정일자 : revnDt */
	public String  getRevnDt() { return (String )get( ATTR_REVNDT );}
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
	/** get 수정주소 : revnAddr */
	public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}
	/** set 원천세징수유형구분코드 : whdgTxCtypDivCd */
	public void setWhdgTxCtypDivCd(String  whdgTxCtypDivCd) { set( ATTR_WHDGTXCTYPDIVCD ,whdgTxCtypDivCd);}
	/** get 원천세징수유형구분코드 : whdgTxCtypDivCd */
	public String  getWhdgTxCtypDivCd() { return (String )get( ATTR_WHDGTXCTYPDIVCD );}
}
