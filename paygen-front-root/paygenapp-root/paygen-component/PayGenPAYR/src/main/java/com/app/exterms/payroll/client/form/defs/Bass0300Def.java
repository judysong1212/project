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

import com.app.exterms.payroll.client.dto.Bass0300BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


public class Bass0300Def extends TableDef implements PayrDaoConstants {

	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;

	public Bass0300Def(String chkDef){

		if ("PAYR5010".equals(chkDef)) {

			setTitle(lblPayrConst.title_Payr5010());
			setDaoClass("");
			setCustomListMethod(CLASS_PAYR5010_DATA_LIST);     
			setAutoFillGrid(true);
			setShowFilterToolbar(false);    
			setFilterFormType(FILTER_FORM_SINGLE);
			setColumnsDefinition(getPayr5010ToBass0300());

		}else if("PAYR5020".equals(chkDef)){

			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_PAYR5020_DATA_LIST);     
			setAutoFillGrid(true);
			setShowFilterToolbar(false);    
			setFilterFormType(FILTER_FORM_SINGLE);
			setColumnsDefinition(getPayr5020ToBass0300());
		}
	}

	public List<ColumnDef> getPayr5010ToBass0300(){

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Bass0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 공통코드 : commCd */
		listColumnDefs.add(new ColumnDef("공통코드", Bass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 대표코드 : rpsttvCd */
		listColumnDefs.add(new ColumnDef("대표코드", Bass0300BM.ATTR_RPSTTVCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 세부코드 : dtlCd */
		listColumnDefs.add(new ColumnDef("직군코드", Bass0300BM.ATTR_DTLCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 공통코드명 : commCdNm */
		listColumnDefs.add(new ColumnDef("직군명", Bass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 약어명 : abbrNm */
		listColumnDefs.add(new ColumnDef("약어명", Bass0300BM.ATTR_ABBRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 영문명 : engNm */
		listColumnDefs.add(new ColumnDef("영문명", Bass0300BM.ATTR_ENGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목01 : mangeItem01 */
		listColumnDefs.add(new ColumnDef("관리항목01", Bass0300BM.ATTR_MANGEITEM01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목02 : mangeItem02 */
		listColumnDefs.add(new ColumnDef("관리항목02", Bass0300BM.ATTR_MANGEITEM02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목03 : mangeItem03 */
		listColumnDefs.add(new ColumnDef("관리항목03", Bass0300BM.ATTR_MANGEITEM03, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목04 : mangeItem04 */
		listColumnDefs.add(new ColumnDef("관리항목04", Bass0300BM.ATTR_MANGEITEM04, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목05 : mangeItem05 */
		listColumnDefs.add(new ColumnDef("관리항목05", Bass0300BM.ATTR_MANGEITEM05, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목06 : mangeItem06 */
		listColumnDefs.add(new ColumnDef("관리항목06", Bass0300BM.ATTR_MANGEITEM06, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목07 : mangeItem07 */
		listColumnDefs.add(new ColumnDef("관리항목07", Bass0300BM.ATTR_MANGEITEM07, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목08 : mangeItem08 */
		listColumnDefs.add(new ColumnDef("관리항목08", Bass0300BM.ATTR_MANGEITEM08, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목09 : mangeItem09 */
		listColumnDefs.add(new ColumnDef("관리항목09", Bass0300BM.ATTR_MANGEITEM09, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목10 : mangeItem10 */
		listColumnDefs.add(new ColumnDef("관리항목10", Bass0300BM.ATTR_MANGEITEM10, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목11 : mangeItem11 */
		listColumnDefs.add(new ColumnDef("관리항목11", Bass0300BM.ATTR_MANGEITEM11, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목12 : mangeItem12 */
		listColumnDefs.add(new ColumnDef("관리항목12", Bass0300BM.ATTR_MANGEITEM12, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목13 : mangeItem13 */
		listColumnDefs.add(new ColumnDef("관리항목13", Bass0300BM.ATTR_MANGEITEM13, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목14 : mangeItem14 */
		listColumnDefs.add(new ColumnDef("관리항목14", Bass0300BM.ATTR_MANGEITEM14, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목15 : mangeItem15 */
		listColumnDefs.add(new ColumnDef("관리항목15", Bass0300BM.ATTR_MANGEITEM15, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목16 : mangeItem16 */
		listColumnDefs.add(new ColumnDef("관리항목16", Bass0300BM.ATTR_MANGEITEM16, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목17 : mangeItem17 */
		listColumnDefs.add(new ColumnDef("관리항목17", Bass0300BM.ATTR_MANGEITEM17, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목18 : mangeItem18 */
		listColumnDefs.add(new ColumnDef("관리항목18", Bass0300BM.ATTR_MANGEITEM18, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목19 : mangeItem19 */
		listColumnDefs.add(new ColumnDef("관리항목19", Bass0300BM.ATTR_MANGEITEM19, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목20 : mangeItem20 */
		listColumnDefs.add(new ColumnDef("관리항목20", Bass0300BM.ATTR_MANGEITEM20, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 코드TREE레벨 : cdTreeLvl */
		listColumnDefs.add(new ColumnDef("코드TREE레벨", Bass0300BM.ATTR_CDTREELVL, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 순서 : ord */
		listColumnDefs.add(new ColumnDef("순서", Bass0300BM.ATTR_ORD, ColumnDef.TYPE_LONG , 90, true, true, true){
			{

			}
		});
		/** column 오픈여부 : opnYn */
		listColumnDefs.add(new ColumnDef("오픈여부", Bass0300BM.ATTR_OPNYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		/** column 사용여부 : useYn */
		listColumnDefs.add(new ColumnDef("사용여부", Bass0300BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		/** column 비고 : note */
		listColumnDefs.add(new ColumnDef("비고", Bass0300BM.ATTR_NOTE, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Bass0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Bass0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Bass0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Bass0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Bass0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정자주소", Bass0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		return listColumnDefs;
	}

	public List<ColumnDef> getPayr5020ToBass0300(){

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Bass0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 공통코드 : commCd */
		listColumnDefs.add(new ColumnDef("공통코드", Bass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 대표코드 : rpsttvCd */
		listColumnDefs.add(new ColumnDef("대표코드", Bass0300BM.ATTR_RPSTTVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 세부코드 : dtlCd */
		listColumnDefs.add(new ColumnDef("직군코드", Bass0300BM.ATTR_DTLCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 공통코드명 : commCdNm */
		listColumnDefs.add(new ColumnDef("직군명", Bass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 약어명 : abbrNm */
		listColumnDefs.add(new ColumnDef("약어명", Bass0300BM.ATTR_ABBRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 영문명 : engNm */
		listColumnDefs.add(new ColumnDef("영문명", Bass0300BM.ATTR_ENGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목01 : mangeItem01 */
		listColumnDefs.add(new ColumnDef("관리항목01", Bass0300BM.ATTR_MANGEITEM01, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목02 : mangeItem02 */
		listColumnDefs.add(new ColumnDef("관리항목02", Bass0300BM.ATTR_MANGEITEM02, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목03 : mangeItem03 */
		listColumnDefs.add(new ColumnDef("관리항목03", Bass0300BM.ATTR_MANGEITEM03, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목04 : mangeItem04 */
		listColumnDefs.add(new ColumnDef("관리항목04", Bass0300BM.ATTR_MANGEITEM04, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목05 : mangeItem05 */
		listColumnDefs.add(new ColumnDef("관리항목05", Bass0300BM.ATTR_MANGEITEM05, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목06 : mangeItem06 */
		listColumnDefs.add(new ColumnDef("관리항목06", Bass0300BM.ATTR_MANGEITEM06, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목07 : mangeItem07 */
		listColumnDefs.add(new ColumnDef("관리항목07", Bass0300BM.ATTR_MANGEITEM07, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목08 : mangeItem08 */
		listColumnDefs.add(new ColumnDef("관리항목08", Bass0300BM.ATTR_MANGEITEM08, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목09 : mangeItem09 */
		listColumnDefs.add(new ColumnDef("관리항목09", Bass0300BM.ATTR_MANGEITEM09, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목10 : mangeItem10 */
		listColumnDefs.add(new ColumnDef("관리항목10", Bass0300BM.ATTR_MANGEITEM10, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목11 : mangeItem11 */
		listColumnDefs.add(new ColumnDef("관리항목11", Bass0300BM.ATTR_MANGEITEM11, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목12 : mangeItem12 */
		listColumnDefs.add(new ColumnDef("관리항목12", Bass0300BM.ATTR_MANGEITEM12, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목13 : mangeItem13 */
		listColumnDefs.add(new ColumnDef("관리항목13", Bass0300BM.ATTR_MANGEITEM13, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목14 : mangeItem14 */
		listColumnDefs.add(new ColumnDef("관리항목14", Bass0300BM.ATTR_MANGEITEM14, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목15 : mangeItem15 */
		listColumnDefs.add(new ColumnDef("관리항목15", Bass0300BM.ATTR_MANGEITEM15, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목16 : mangeItem16 */
		listColumnDefs.add(new ColumnDef("관리항목16", Bass0300BM.ATTR_MANGEITEM16, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목17 : mangeItem17 */
		listColumnDefs.add(new ColumnDef("관리항목17", Bass0300BM.ATTR_MANGEITEM17, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목18 : mangeItem18 */
		listColumnDefs.add(new ColumnDef("관리항목18", Bass0300BM.ATTR_MANGEITEM18, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목19 : mangeItem19 */
		listColumnDefs.add(new ColumnDef("관리항목19", Bass0300BM.ATTR_MANGEITEM19, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 관리항목20 : mangeItem20 */
		listColumnDefs.add(new ColumnDef("관리항목20", Bass0300BM.ATTR_MANGEITEM20, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 코드TREE레벨 : cdTreeLvl */
		listColumnDefs.add(new ColumnDef("코드TREE레벨", Bass0300BM.ATTR_CDTREELVL, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 순서 : ord */
		listColumnDefs.add(new ColumnDef("순서", Bass0300BM.ATTR_ORD, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});
		/** column 오픈여부 : opnYn */
		listColumnDefs.add(new ColumnDef("오픈여부", Bass0300BM.ATTR_OPNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 사용여부 : useYn */
		listColumnDefs.add(new ColumnDef("사용여부", Bass0300BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		/** column 비고 : note */
		listColumnDefs.add(new ColumnDef("비고", Bass0300BM.ATTR_NOTE, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Bass0300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Bass0300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Bass0300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Bass0300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Bass0300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정자주소", Bass0300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		return listColumnDefs;
	}
}
