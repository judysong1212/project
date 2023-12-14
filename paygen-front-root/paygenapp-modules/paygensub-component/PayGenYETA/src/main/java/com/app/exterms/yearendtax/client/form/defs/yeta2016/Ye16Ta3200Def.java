package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3200BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3200Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Ye16Ta3200Def(String chkDef) {
		if("YETAP03009".equals(chkDef)) {
		}
//		setTitle("연말정산대상자 및 내역");
		setTitle("");
        setDaoClass("");
        setCustomListMethod(CLASS_YETAP03008TOYETA3200_DATA_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(false);
	    setColumnsDefinition(getColumnsList()); 
	}

	private List<ColumnDef> getColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
       
/** column 사업장코드 : dpobCd */
listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 연말정산귀속년도 : edacRvyy */
listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3200BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 정산구분코드 : settGbcd */
listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3200BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column SYSTEMKEY : systemkey */
listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 사업자등록번호 : siteNumb */
listColumnDefs.add(new ColumnDef("사업자등록번호", Ye16Ta3200BM.ATTR_SITENUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 비과세소득_A01 : taxmEa01 */
listColumnDefs.add(new ColumnDef("비과세소득_A01", Ye16Ta3200BM.ATTR_TAXMEA01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_B01 : taxmEb01 */
listColumnDefs.add(new ColumnDef("비과세소득_B01", Ye16Ta3200BM.ATTR_TAXMEB01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_C01 : taxmEc01 */
listColumnDefs.add(new ColumnDef("비과세소득_C01", Ye16Ta3200BM.ATTR_TAXMEC01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_D01 : taxmEd01 */
listColumnDefs.add(new ColumnDef("비과세소득_D01", Ye16Ta3200BM.ATTR_TAXMED01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_E01 : taxmEe01 */
listColumnDefs.add(new ColumnDef("비과세소득_E01", Ye16Ta3200BM.ATTR_TAXMEE01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_E02 : taxmEe02 */
listColumnDefs.add(new ColumnDef("비과세소득_E02", Ye16Ta3200BM.ATTR_TAXMEE02, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_E10 : taxmEe10 */
listColumnDefs.add(new ColumnDef("비과세소득_E10", Ye16Ta3200BM.ATTR_TAXMEE10, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_F01 : taxmEf01 */
listColumnDefs.add(new ColumnDef("비과세소득_F01", Ye16Ta3200BM.ATTR_TAXMEF01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_G01 : taxmEg01 */
listColumnDefs.add(new ColumnDef("비과세소득_G01", Ye16Ta3200BM.ATTR_TAXMEG01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H01 : taxmEh01 */
listColumnDefs.add(new ColumnDef("비과세소득_H01", Ye16Ta3200BM.ATTR_TAXMEH01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H02 : taxmEh02 */
listColumnDefs.add(new ColumnDef("비과세소득_H02", Ye16Ta3200BM.ATTR_TAXMEH02, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H03 : taxmEh03 */
listColumnDefs.add(new ColumnDef("비과세소득_H03", Ye16Ta3200BM.ATTR_TAXMEH03, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H04 : taxmEh04 */
listColumnDefs.add(new ColumnDef("비과세소득_H04", Ye16Ta3200BM.ATTR_TAXMEH04, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H05 : taxmEh05 */
listColumnDefs.add(new ColumnDef("비과세소득_H05", Ye16Ta3200BM.ATTR_TAXMEH05, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H06 : taxmEh06 */
listColumnDefs.add(new ColumnDef("비과세소득_H06", Ye16Ta3200BM.ATTR_TAXMEH06, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H07 : taxmEh07 */
listColumnDefs.add(new ColumnDef("비과세소득_H07", Ye16Ta3200BM.ATTR_TAXMEH07, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H08 : taxmEh08 */
listColumnDefs.add(new ColumnDef("비과세소득_H08", Ye16Ta3200BM.ATTR_TAXMEH08, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H09 : taxmEh09 */
listColumnDefs.add(new ColumnDef("비과세소득_H09", Ye16Ta3200BM.ATTR_TAXMEH09, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H10 : taxmEh10 */
listColumnDefs.add(new ColumnDef("비과세소득_H10", Ye16Ta3200BM.ATTR_TAXMEH10, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H14 : taxmEh14 */
listColumnDefs.add(new ColumnDef("비과세소득_H14", Ye16Ta3200BM.ATTR_TAXMEH14, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H15 : taxmEh15 */
listColumnDefs.add(new ColumnDef("비과세소득_H15", Ye16Ta3200BM.ATTR_TAXMEH15, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H11 : taxmEh11 */
listColumnDefs.add(new ColumnDef("비과세소득_H11", Ye16Ta3200BM.ATTR_TAXMEH11, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H12 : taxmEh12 */
listColumnDefs.add(new ColumnDef("비과세소득_H12", Ye16Ta3200BM.ATTR_TAXMEH12, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H13 : taxmEh13 */
listColumnDefs.add(new ColumnDef("비과세소득_H13", Ye16Ta3200BM.ATTR_TAXMEH13, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_H16 : taxmEh16 */
listColumnDefs.add(new ColumnDef("비과세소득_H16", Ye16Ta3200BM.ATTR_TAXMEH16, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_I01 : taxmEi01 */
listColumnDefs.add(new ColumnDef("비과세소득_I01", Ye16Ta3200BM.ATTR_TAXMEI01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_J01 : taxmEj01 */
listColumnDefs.add(new ColumnDef("비과세소득_J01", Ye16Ta3200BM.ATTR_TAXMEJ01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_J10 : taxmEj10 */
listColumnDefs.add(new ColumnDef("비과세소득_J10", Ye16Ta3200BM.ATTR_TAXMEJ10, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_K01 : taxmEk01 */
listColumnDefs.add(new ColumnDef("비과세소득_K01", Ye16Ta3200BM.ATTR_TAXMEK01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_L01 : taxmEl01 */
listColumnDefs.add(new ColumnDef("비과세소득_L01", Ye16Ta3200BM.ATTR_TAXMEL01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_M01 : taxmEm01 */
listColumnDefs.add(new ColumnDef("비과세소득_M01", Ye16Ta3200BM.ATTR_TAXMEM01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_M02 : taxmEm02 */
listColumnDefs.add(new ColumnDef("비과세소득_M02", Ye16Ta3200BM.ATTR_TAXMEM02, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_M03 : taxmEm03 */
listColumnDefs.add(new ColumnDef("비과세소득_M03", Ye16Ta3200BM.ATTR_TAXMEM03, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_N01 : taxmEn01 */
listColumnDefs.add(new ColumnDef("비과세소득_N01", Ye16Ta3200BM.ATTR_TAXMEN01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_O01 : taxmEo01 */
listColumnDefs.add(new ColumnDef("비과세소득_O01", Ye16Ta3200BM.ATTR_TAXMEO01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_P01 : taxmEp01 */
listColumnDefs.add(new ColumnDef("비과세소득_P01", Ye16Ta3200BM.ATTR_TAXMEP01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_P02 : taxmEp02 */
listColumnDefs.add(new ColumnDef("비과세소득_P02", Ye16Ta3200BM.ATTR_TAXMEP02, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_Q01 : taxmEq01 */
listColumnDefs.add(new ColumnDef("비과세소득_Q01", Ye16Ta3200BM.ATTR_TAXMEQ01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_R01 : taxmEr01 */
listColumnDefs.add(new ColumnDef("비과세소득_R01", Ye16Ta3200BM.ATTR_TAXMER01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_R10 : taxmEr10 */
listColumnDefs.add(new ColumnDef("비과세소득_R10", Ye16Ta3200BM.ATTR_TAXMER10, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_S01 : taxmEs01 */
listColumnDefs.add(new ColumnDef("비과세소득_S01", Ye16Ta3200BM.ATTR_TAXMES01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_Y02 : taxmEy02 */
listColumnDefs.add(new ColumnDef("비과세소득_Y02", Ye16Ta3200BM.ATTR_TAXMEY02, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_Y03 : taxmEy03 */
listColumnDefs.add(new ColumnDef("비과세소득_Y03", Ye16Ta3200BM.ATTR_TAXMEY03, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_Y21 : taxmEy21 */
listColumnDefs.add(new ColumnDef("비과세소득_Y21", Ye16Ta3200BM.ATTR_TAXMEY21, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 비과세소득_Y22 : taxmEy22 */
listColumnDefs.add(new ColumnDef("비과세소득_Y22", Ye16Ta3200BM.ATTR_TAXMEY22, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 감면소득_T01 : taxmEt01 */
listColumnDefs.add(new ColumnDef("감면소득_T01", Ye16Ta3200BM.ATTR_TAXMET01, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 감면소득_T10 : taxmEt10 */
listColumnDefs.add(new ColumnDef("감면소득_T10", Ye16Ta3200BM.ATTR_TAXMET10, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 감면소득_T20 : taxmEt20 */
listColumnDefs.add(new ColumnDef("감면소득_T20", Ye16Ta3200BM.ATTR_TAXMET20, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 입력자 : kybdr */
listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력일자 : inptDt */
listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 입력주소 : inptAddr */
listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정자 : ismt */
listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정일자 : revnDt */
listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
/** column 수정주소 : revnAddr */
listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	{

	}
});
 
/** column 비과세소득_Y04 : taxmEy04 */
listColumnDefs.add(new ColumnDef("비과세소득_Y04", Ye16Ta3200BM.ATTR_TAXMEY04, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 감면소득_T11 : taxmEt11 */
listColumnDefs.add(new ColumnDef("감면소득_T11", Ye16Ta3200BM.ATTR_TAXMET11, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});
/** column 감면소득_T12 : taxmEt12 */
listColumnDefs.add(new ColumnDef("감면소득_T12", Ye16Ta3200BM.ATTR_TAXMET12, ColumnDef.TYPE_LONG , 90, true, false, true){
	{

	}
});

          return listColumnDefs;
	}

}
