/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Bass0350BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0350Def extends TableDef implements PayrDaoConstants {

	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;

	public Bass0350Def(String chkDef){

		if ("BASS0350Top".equals(chkDef)) {

			setTitle(lblPayrConst.title_Payr5020());
			setDaoClass("");
			setCustomListMethod(CLASS_PAYR5020_TOP_DATA_LIST);     
			setAutoFillGrid(true);
			setShowFilterToolbar(false);       
			setCheckBoxOnGridRows(true);
			setFilterFormType(FILTER_FORM_SINGLE);
			setColumnsDefinition(getPayr5020ToBass0350Top());

		}else if("BASS0350Bottom".equals(chkDef)){

			setTitle(lblPayrConst.title_Payr5020());
			setDaoClass(""); 
			setCustomListMethod(CLASS_PAYR5020_BOTTOM_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);  
			setCheckBoxOnGridRows(true);
			setFilterFormType(FILTER_FORM_SINGLE);
			setColumnsDefinition(getPayr5020ToBass0350Bottom());
		}
	}

	public List<ColumnDef> getPayr5020ToBass0350Top(){

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Bass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 직군 : dtilOccuJbfmlDivNm */
		listColumnDefs.add(new ColumnDef("직군", Bass0350BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 직종명 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직종세코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Bass0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세명 : dtilOccuClsNm */
		listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
		listColumnDefs.add(new ColumnDef("직종세직군구분코드", Bass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세사용여부 : dtilOccuClsUseYn */
		listColumnDefs.add(new ColumnDef("직종세사용여부", Bass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		/** column 전환대상여부 : chngTgtYn */
		listColumnDefs.add(new ColumnDef("전환대상여부", Bass0350BM.ATTR_CHNGTGTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세내용 : dtilOccuClsCtnt */
		listColumnDefs.add(new ColumnDef("직종세내용", Bass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 정렬순서 : dtilOccuClsOrd */
		listColumnDefs.add(new ColumnDef("정렬순서", Bass0350BM.ATTR_DTILOCCUCLSORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 최대근속년수코드 : bggLogSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("최대근속년수코드", Bass0350BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
		listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세적용단가금액 : dtilOcclsApptnUcstSum */
		listColumnDefs.add(new ColumnDef("직종세적용단가금액", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Bass0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Bass0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Bass0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Bass0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Bass0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Bass0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}

	public List<ColumnDef> getPayr5020ToBass0350Bottom(){

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Bass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 직종명 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직종세코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Bass0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세명 : dtilOccuClsNm */
		listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직군 : dtilOccuJbfmlDivNm */
		listColumnDefs.add(new ColumnDef("직군", Bass0350BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		
		/** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
		listColumnDefs.add(new ColumnDef("직종세직군구분코드", Bass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세사용여부 : dtilOccuClsUseYn */
		listColumnDefs.add(new ColumnDef("직종세사용여부", Bass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		/** column 전환대상여부 : chngTgtYn */
		listColumnDefs.add(new ColumnDef("전환대상여부", Bass0350BM.ATTR_CHNGTGTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세내용 : dtilOccuClsCtnt */
		listColumnDefs.add(new ColumnDef("직종세내용", Bass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 정렬순서 : dtilOccuClsOrd */
		listColumnDefs.add(new ColumnDef("정렬순서", Bass0350BM.ATTR_DTILOCCUCLSORD, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 최대근속년수코드 : bggLogSvcYrNumCd */
		listColumnDefs.add(new ColumnDef("최대근속년수코드", Bass0350BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
		listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 직종세적용단가금액 : dtilOcclsApptnUcstSum */
		listColumnDefs.add(new ColumnDef("직종세적용단가금액", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Bass0350BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Bass0350BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Bass0350BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Bass0350BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Bass0350BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Bass0350BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
}
