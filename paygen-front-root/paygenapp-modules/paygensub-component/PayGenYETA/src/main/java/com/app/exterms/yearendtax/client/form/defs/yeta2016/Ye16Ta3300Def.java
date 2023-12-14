package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3300BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3300Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Ye16Ta3300Def(String string) {
//		setTitle("연말정산대상자 및 내역");
		setTitle("");
        setDaoClass("");
        setCustomListMethod("");
//        setCustomListMethod(CLASS_YETA0100_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(false);
	    setColumnsDefinition(getColumnsList()); 
	}

	private List<ColumnDef> getColumnsList() {
		row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3300BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3300BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Ye16Ta3300BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3300BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_A01 : taxmSa01 */
        listColumnDefs.add(new ColumnDef("비과세소득_A01", Ye16Ta3300BM.ATTR_TAXMSA01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_B01 : taxmSb01 */
        listColumnDefs.add(new ColumnDef("비과세소득_B01", Ye16Ta3300BM.ATTR_TAXMSB01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_C01 : taxmSc01 */
        listColumnDefs.add(new ColumnDef("비과세소득_C01", Ye16Ta3300BM.ATTR_TAXMSC01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_D01 : taxmSd01 */
        listColumnDefs.add(new ColumnDef("비과세소득_D01", Ye16Ta3300BM.ATTR_TAXMSD01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E01 : taxmSe01 */
        listColumnDefs.add(new ColumnDef("비과세소득_E01", Ye16Ta3300BM.ATTR_TAXMSE01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E02 : taxmSe02 */
        listColumnDefs.add(new ColumnDef("비과세소득_E02", Ye16Ta3300BM.ATTR_TAXMSE02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E10 : taxmSe10 */
        listColumnDefs.add(new ColumnDef("비과세소득_E10", Ye16Ta3300BM.ATTR_TAXMSE10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_F01 : taxmSf01 */
        listColumnDefs.add(new ColumnDef("비과세소득_F01", Ye16Ta3300BM.ATTR_TAXMSF01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_G01 : taxmSg01 */
        listColumnDefs.add(new ColumnDef("비과세소득_G01", Ye16Ta3300BM.ATTR_TAXMSG01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H01 : taxmSh01 */
        listColumnDefs.add(new ColumnDef("비과세소득_H01", Ye16Ta3300BM.ATTR_TAXMSH01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H02 : taxmSh02 */
        listColumnDefs.add(new ColumnDef("비과세소득_H02", Ye16Ta3300BM.ATTR_TAXMSH02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H03 : taxmSh03 */
        listColumnDefs.add(new ColumnDef("비과세소득_H03", Ye16Ta3300BM.ATTR_TAXMSH03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H04 : taxmSh04 */
        listColumnDefs.add(new ColumnDef("비과세소득_H04", Ye16Ta3300BM.ATTR_TAXMSH04, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H05 : taxmSh05 */
        listColumnDefs.add(new ColumnDef("비과세소득_H05", Ye16Ta3300BM.ATTR_TAXMSH05, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H06 : taxmSh06 */
        listColumnDefs.add(new ColumnDef("비과세소득_H06", Ye16Ta3300BM.ATTR_TAXMSH06, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H07 : taxmSh07 */
        listColumnDefs.add(new ColumnDef("비과세소득_H07", Ye16Ta3300BM.ATTR_TAXMSH07, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H08 : taxmSh08 */
        listColumnDefs.add(new ColumnDef("비과세소득_H08", Ye16Ta3300BM.ATTR_TAXMSH08, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H09 : taxmSh09 */
        listColumnDefs.add(new ColumnDef("비과세소득_H09", Ye16Ta3300BM.ATTR_TAXMSH09, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H10 : taxmSh10 */
        listColumnDefs.add(new ColumnDef("비과세소득_H10", Ye16Ta3300BM.ATTR_TAXMSH10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H14 : taxmSh14 */
        listColumnDefs.add(new ColumnDef("비과세소득_H14", Ye16Ta3300BM.ATTR_TAXMSH14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H15 : taxmSh15 */
        listColumnDefs.add(new ColumnDef("비과세소득_H15", Ye16Ta3300BM.ATTR_TAXMSH15, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H11 : taxmSh11 */
        listColumnDefs.add(new ColumnDef("비과세소득_H11", Ye16Ta3300BM.ATTR_TAXMSH11, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H12 : taxmSh12 */
        listColumnDefs.add(new ColumnDef("비과세소득_H12", Ye16Ta3300BM.ATTR_TAXMSH12, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H13 : taxmSh13 */
        listColumnDefs.add(new ColumnDef("비과세소득_H13", Ye16Ta3300BM.ATTR_TAXMSH13, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H16 : taxmSh16 */
        listColumnDefs.add(new ColumnDef("비과세소득_H16", Ye16Ta3300BM.ATTR_TAXMSH16, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_I01 : taxmSi01 */
        listColumnDefs.add(new ColumnDef("비과세소득_I01", Ye16Ta3300BM.ATTR_TAXMSI01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_J01 : taxmSj01 */
        listColumnDefs.add(new ColumnDef("비과세소득_J01", Ye16Ta3300BM.ATTR_TAXMSJ01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_J10 : taxmSj10 */
        listColumnDefs.add(new ColumnDef("비과세소득_J10", Ye16Ta3300BM.ATTR_TAXMSJ10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_K01 : taxmSk01 */
        listColumnDefs.add(new ColumnDef("비과세소득_K01", Ye16Ta3300BM.ATTR_TAXMSK01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_L01 : taxmSl01 */
        listColumnDefs.add(new ColumnDef("비과세소득_L01", Ye16Ta3300BM.ATTR_TAXMSL01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M01 : taxmSm01 */
        listColumnDefs.add(new ColumnDef("비과세소득_M01", Ye16Ta3300BM.ATTR_TAXMSM01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M02 : taxmSm02 */
        listColumnDefs.add(new ColumnDef("비과세소득_M02", Ye16Ta3300BM.ATTR_TAXMSM02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M03 : taxmSm03 */
        listColumnDefs.add(new ColumnDef("비과세소득_M03", Ye16Ta3300BM.ATTR_TAXMSM03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_N01 : taxmSn01 */
        listColumnDefs.add(new ColumnDef("비과세소득_N01", Ye16Ta3300BM.ATTR_TAXMSN01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_O01 : taxmSo01 */
        listColumnDefs.add(new ColumnDef("비과세소득_O01", Ye16Ta3300BM.ATTR_TAXMSO01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_P01 : taxmSp01 */
        listColumnDefs.add(new ColumnDef("비과세소득_P01", Ye16Ta3300BM.ATTR_TAXMSP01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_P02 : taxmSp02 */
        listColumnDefs.add(new ColumnDef("비과세소득_P02", Ye16Ta3300BM.ATTR_TAXMSP02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Q01 : taxmSq01 */
        listColumnDefs.add(new ColumnDef("비과세소득_Q01", Ye16Ta3300BM.ATTR_TAXMSQ01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_R01 : taxmSr01 */
        listColumnDefs.add(new ColumnDef("비과세소득_R01", Ye16Ta3300BM.ATTR_TAXMSR01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_R10 : taxmSr10 */
        listColumnDefs.add(new ColumnDef("비과세소득_R10", Ye16Ta3300BM.ATTR_TAXMSR10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_S01 : taxmSs01 */
        listColumnDefs.add(new ColumnDef("비과세소득_S01", Ye16Ta3300BM.ATTR_TAXMSS01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y02 : taxmSy02 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y02", Ye16Ta3300BM.ATTR_TAXMSY02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y03 : taxmSy03 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y03", Ye16Ta3300BM.ATTR_TAXMSY03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y21 : taxmSy21 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y21", Ye16Ta3300BM.ATTR_TAXMSY21, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y22 : taxmSy22 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y22", Ye16Ta3300BM.ATTR_TAXMSY22, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T01 : taxmSt01 */
        listColumnDefs.add(new ColumnDef("감면소득_T01", Ye16Ta3300BM.ATTR_TAXMST01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T10 : taxmSt10 */
        listColumnDefs.add(new ColumnDef("감면소득_T10", Ye16Ta3300BM.ATTR_TAXMST10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T20 : taxmSt20 */
        listColumnDefs.add(new ColumnDef("감면소득_T20", Ye16Ta3300BM.ATTR_TAXMST20, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3300BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3300BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3300BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3300BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3300BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3300BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 비과세소득_Y04 : taxmSy04 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y04", Ye16Ta3300BM.ATTR_TAXMSY04, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T11 : taxmSt11 */
        listColumnDefs.add(new ColumnDef("감면소득_T11", Ye16Ta3300BM.ATTR_TAXMST11, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T12 : taxmSt12 */
        listColumnDefs.add(new ColumnDef("감면소득_T12", Ye16Ta3300BM.ATTR_TAXMST12, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });

    
          return listColumnDefs;
	}

}
