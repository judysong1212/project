package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Hpe100BM;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Payr7100Def extends TableDef implements PayrDaoConstants {
	private int row = 0;

	public Payr7100Def() {
		setTitle("");
        setDaoClass("");
        setCustomListMethod(CLASS_PAYR7100_DATA_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(false);
	    setColumnsDefinition(getColumnsList()); 
	}
	
	private List<ColumnDef> getColumnsList() {
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

		//	newColumnDef(TITLE, BM.ATTR_NAME, ColumnDef.TYPE, int WIDTH, Bool isRequired, Bool isVisibleInGrid, Bool isVisibleInForm)
		listColumnDefs.add(new ColumnDef("법인코드", Hpe100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("귀속년도", Hpe100BM.ATTR_YEARYYYY, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("근무시기", Hpe100BM.ATTR_HALFYEAR, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		
		
		listColumnDefs.add(new ColumnDef("부서코드", Hpe100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("사번", Hpe100BM.ATTR_PERSONNUMB, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("주민등록번호", Hpe100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 90, false, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("성명", Hpe100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("전화번호", Hpe100BM.ATTR_CELLPHNENUM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("사업장", Hpe100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("거주구분", Hpe100BM.ATTR_RESIDENTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("국적", Hpe100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("근무시작일", Hpe100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("근무종료일", Hpe100BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("과세금액", Hpe100BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("비과세금액", Hpe100BM.ATTR_FREEDTYTOTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
			{}
		});
		listColumnDefs.add(new ColumnDef("입력자", Hpe100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("입력일", Hpe100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("입력주소", Hpe100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("수정자", Hpe100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("수정일", Hpe100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("수정주소", Hpe100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼1", Hpe100BM.ATTR_TEMPC01, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼2", Hpe100BM.ATTR_TEMPC02, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼3", Hpe100BM.ATTR_TEMPC03, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼4", Hpe100BM.ATTR_TEMPN01, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼5", Hpe100BM.ATTR_TEMPN02, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		listColumnDefs.add(new ColumnDef("임시컬럼6", Hpe100BM.ATTR_TEMPN03, ColumnDef.TYPE_STRING , 90, false, false, false){
			{}
		});
		
		return listColumnDefs;
	}
}
