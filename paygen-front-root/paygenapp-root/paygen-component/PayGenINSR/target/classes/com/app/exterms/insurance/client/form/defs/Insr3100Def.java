package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr3100BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr3100VO.java
 * @Description : Insr3100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr3100Def  extends TableDef implements InsrDaoConstants {
	private int row = 0;
	private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	
	public Insr3100Def(String chkDef) {
		if("INSR4500".equals(chkDef)) {
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_INSR4500TOINSR3100_DAO_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setEditFieldGrid(false);
			//setCellModel(true);
			setColumnsDefinition(getInsr4500ToInsr3100ColumnsList());
		} else {
			setTitle("");
			setDaoClass("");
			setCustomListMethod("");
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(false);
			setFilterFormType(FILTER_FORM_SINGLE);
		}
	}

	private List<ColumnDef> getInsr4500ToInsr3100ColumnsList() {
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
		
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Insr3100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 정산년월 : nofctYrMnthNum */
		listColumnDefs.add(new ColumnDef("정산년월", Insr3100BM.ATTR_NOFCTYRMNTHNUM, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr3100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 고용일련번호 : emymtSeilNum */
		listColumnDefs.add(new ColumnDef("고용일련번호", Insr3100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 건강보험일련번호 : hlthInsrSeilNum */
		listColumnDefs.add(new ColumnDef("건강보험일련번호", Insr3100BM.ATTR_HLTHINSRSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 사업장관리번호 : dpobMangeNum */
		listColumnDefs.add(new ColumnDef("사업장관리번호", Insr3100BM.ATTR_DPOBMANGENUM, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 차수 : dspty */
		listColumnDefs.add(new ColumnDef("차수", Insr3100BM.ATTR_DSPTY, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 회계 : acc */
		listColumnDefs.add(new ColumnDef("회계", Insr3100BM.ATTR_ACC, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 단위사업장코드 : untDpobCd */
		listColumnDefs.add(new ColumnDef("단위사업장", Insr3100BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Insr3100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 성명 : nm */
		listColumnDefs.add(new ColumnDef("성명", Insr3100BM.ATTR_NM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 주민등록번호 : resnRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 주민등록번호 : secRegnNum */
		listColumnDefs.add(new ColumnDef("주민등록번호", Insr3100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false) {
			{
				
			}
		});
		/** column 증번호 : certNumHuhd */
		listColumnDefs.add(new ColumnDef("증번호", Insr3100BM.ATTR_CERTNUMHUHD, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 건강연말정산적용년월 : hlthYrtxApptnYrMnth */
		listColumnDefs.add(new ColumnDef("반영년월", Insr3100BM.ATTR_HLTHYRTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 건강보험연말정산처리여부 : hlthInsrYrtxPrcsYn */
		listColumnDefs.add(new ColumnDef("급여반영", Insr3100BM.ATTR_HLTHINSRYRTXPRCSYN, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 분할납부구분코드 : divdPymtDivCd */
		listColumnDefs.add(new ColumnDef("분할납부구분코드", Insr3100BM.ATTR_DIVDPYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 분할납부횟수 : divdPymt */
		listColumnDefs.add(new ColumnDef("분할납부횟수", Insr3100BM.ATTR_DIVDPYMT, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 부과한총보험료_계 : iposTotPrmmAggr */
		listColumnDefs.add(new ColumnDef("계", Insr3100BM.ATTR_IPOSTOTPRMMAGGR, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 부과한총보험료_건강 : iposTotPrmmHlth */
		listColumnDefs.add(new ColumnDef("건강", Insr3100BM.ATTR_IPOSTOTPRMMHLTH, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 부과한총보험료_장기요양 : iposTotPrmmLgtmRcptn */
		listColumnDefs.add(new ColumnDef("장기요양", Insr3100BM.ATTR_IPOSTOTPRMMLGTMRCPTN, ColumnDef.TYPE_LONG , 90, true, true, true)	{
			{
				
			}
		});
		/** column 연간보수총액 : yrlyPayTotAmnt */
		listColumnDefs.add(new ColumnDef("연간보수총액", Insr3100BM.ATTR_YRLYPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 근무월수 : dutyMnthIcm */
		listColumnDefs.add(new ColumnDef("근무월수", Insr3100BM.ATTR_DUTYMNTHICM, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 보수월액 : payMnthAmnt */
		listColumnDefs.add(new ColumnDef("보수월액", Insr3100BM.ATTR_PAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 연말정산_등급 : yrtxCalcBkdnGrde */
		listColumnDefs.add(new ColumnDef("등급", Insr3100BM.ATTR_YRTXCALCBKDNGRDE, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 표준보수월액 : stdPayMnthAmnt */
		listColumnDefs.add(new ColumnDef("표준보수월액", Insr3100BM.ATTR_STDPAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 확정보험료_계 : fixPrmmAggr */
		listColumnDefs.add(new ColumnDef("계", Insr3100BM.ATTR_FIXPRMMAGGR, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 확정보험료_건강 : fixPrmmHlth */
		listColumnDefs.add(new ColumnDef("건강", Insr3100BM.ATTR_FIXPRMMHLTH, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 확정보험료_장기요양 : fixPrmmLgtmRcptn */
		listColumnDefs.add(new ColumnDef("장기요양", Insr3100BM.ATTR_FIXPRMMLGTMRCPTN, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 정산보험료_계 : clutPrmmAggr */
		listColumnDefs.add(new ColumnDef("계", Insr3100BM.ATTR_CLUTPRMMAGGR, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 정산보험료_건강 : clutPrmmHlth */
		listColumnDefs.add(new ColumnDef("건강", Insr3100BM.ATTR_CLUTPRMMHLTH, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 정산보험료_장기요양 : clutPrmmLgtmRcptn */
		listColumnDefs.add(new ColumnDef("장기요양", Insr3100BM.ATTR_CLUTPRMMLGTMRCPTN, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 가입자부담금_계 : mbrAlttAggr */
		listColumnDefs.add(new ColumnDef("계", Insr3100BM.ATTR_MBRALTTAGGR, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 가입자부담금_건강 : mbrAlttHlth */
		listColumnDefs.add(new ColumnDef("건강", Insr3100BM.ATTR_MBRALTTHLTH, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 가입자부담금_장기요양 : mbrAlttLgtmRcptn */
		listColumnDefs.add(new ColumnDef("장기요양", Insr3100BM.ATTR_MBRALTTLGTMRCPTN, ColumnDef.TYPE_LONG , 90, true, true, true) {
			{
				
			}
		});
		/** column 사용자부담금_계 : usrAlttAggr */
		listColumnDefs.add(new ColumnDef("계", Insr3100BM.ATTR_USRALTTAGGR, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 사용자부담금_건강 : usrAlttHlth */
		listColumnDefs.add(new ColumnDef("건강", Insr3100BM.ATTR_USRALTTHLTH, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 사용자부담금_장기요양 : usrAlttLgtmRcptn */
		listColumnDefs.add(new ColumnDef("장기요양", Insr3100BM.ATTR_USRALTTLGTMRCPTN, ColumnDef.TYPE_LONG , 90, true, false, true) {
			{
				
			}
		});
		/** column 고지유예 : nofctSspn */
		listColumnDefs.add(new ColumnDef("고지유예", Insr3100BM.ATTR_NOFCTSSPN, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Insr3100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 직종명 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종", Insr3100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 직종세코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세코드", Insr3100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 직종세명 : dtilOccuClsNm */
		listColumnDefs.add(new ColumnDef("직종세", Insr3100BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING , 90, true, true, true) {
			{
				
			}
		});
		/** column 건강연말정산처리일자 : hlthYrtxPrcsDt */
		listColumnDefs.add(new ColumnDef("건강연말정산처리일자", Insr3100BM.ATTR_HLTHYRTXPRCSDT, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Insr3100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Insr3100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Insr3100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Insr3100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Insr3100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Insr3100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true) {
			{
				
			}
		});
		return listColumnDefs;
	}
}