package com.app.exterms.yearendtax.client.form.defs.yeta2015;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3200BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta3200Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	
	public Yeta3200Def(String chkDef) {
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
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta3200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Yeta3200BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Yeta3200BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급년월 : elctYymm */
        listColumnDefs.add(new ColumnDef("지급년월", Yeta3200BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Yeta3200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : siteNumb */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Yeta3200BM.ATTR_SITENUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_A01 : taxmEa01 */
        listColumnDefs.add(new ColumnDef("비과세소득_A01", Yeta3200BM.ATTR_TAXMEA01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_B01 : taxmEb01 */
        listColumnDefs.add(new ColumnDef("비과세소득_B01", Yeta3200BM.ATTR_TAXMEB01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_C01 : taxmEc01 */
        listColumnDefs.add(new ColumnDef("비과세소득_C01", Yeta3200BM.ATTR_TAXMEC01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_D01 : taxmEd01 */
        listColumnDefs.add(new ColumnDef("비과세소득_D01", Yeta3200BM.ATTR_TAXMED01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E01 : taxmEe01 */
        listColumnDefs.add(new ColumnDef("비과세소득_E01", Yeta3200BM.ATTR_TAXMEE01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E02 : taxmEe02 */
        listColumnDefs.add(new ColumnDef("비과세소득_E02", Yeta3200BM.ATTR_TAXMEE02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_E10 : taxmEe10 */
        listColumnDefs.add(new ColumnDef("비과세소득_E10", Yeta3200BM.ATTR_TAXMEE10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_F01 : taxmEf01 */
        listColumnDefs.add(new ColumnDef("비과세소득_F01", Yeta3200BM.ATTR_TAXMEF01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_G01 : taxmEg01 */
        listColumnDefs.add(new ColumnDef("비과세소득_G01", Yeta3200BM.ATTR_TAXMEG01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H01 : taxmEh01 */
        listColumnDefs.add(new ColumnDef("비과세소득_H01", Yeta3200BM.ATTR_TAXMEH01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H02 : taxmEh02 */
        listColumnDefs.add(new ColumnDef("비과세소득_H02", Yeta3200BM.ATTR_TAXMEH02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H03 : taxmEh03 */
        listColumnDefs.add(new ColumnDef("비과세소득_H03", Yeta3200BM.ATTR_TAXMEH03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H04 : taxmEh04 */
        listColumnDefs.add(new ColumnDef("비과세소득_H04", Yeta3200BM.ATTR_TAXMEH04, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H05 : taxmEh05 */
        listColumnDefs.add(new ColumnDef("비과세소득_H05", Yeta3200BM.ATTR_TAXMEH05, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H06 : taxmEh06 */
        listColumnDefs.add(new ColumnDef("비과세소득_H06", Yeta3200BM.ATTR_TAXMEH06, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H07 : taxmEh07 */
        listColumnDefs.add(new ColumnDef("비과세소득_H07", Yeta3200BM.ATTR_TAXMEH07, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H08 : taxmEh08 */
        listColumnDefs.add(new ColumnDef("비과세소득_H08", Yeta3200BM.ATTR_TAXMEH08, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H09 : taxmEh09 */
        listColumnDefs.add(new ColumnDef("비과세소득_H09", Yeta3200BM.ATTR_TAXMEH09, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H10 : taxmEh10 */
        listColumnDefs.add(new ColumnDef("비과세소득_H10", Yeta3200BM.ATTR_TAXMEH10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H14 : taxmEh14 */
        listColumnDefs.add(new ColumnDef("비과세소득_H14", Yeta3200BM.ATTR_TAXMEH14, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H15 : taxmEh15 */
        listColumnDefs.add(new ColumnDef("비과세소득_H15", Yeta3200BM.ATTR_TAXMEH15, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H11 : taxmEh11 */
        listColumnDefs.add(new ColumnDef("비과세소득_H11", Yeta3200BM.ATTR_TAXMEH11, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H12 : taxmEh12 */
        listColumnDefs.add(new ColumnDef("비과세소득_H12", Yeta3200BM.ATTR_TAXMEH12, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H13 : taxmEh13 */
        listColumnDefs.add(new ColumnDef("비과세소득_H13", Yeta3200BM.ATTR_TAXMEH13, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_H16 : taxmEh16 */
        listColumnDefs.add(new ColumnDef("비과세소득_H16", Yeta3200BM.ATTR_TAXMEH16, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_I01 : taxmEi01 */
        listColumnDefs.add(new ColumnDef("비과세소득_I01", Yeta3200BM.ATTR_TAXMEI01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_J01 : taxmEj01 */
        listColumnDefs.add(new ColumnDef("비과세소득_J01", Yeta3200BM.ATTR_TAXMEJ01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_J10 : taxmEj10 */
        listColumnDefs.add(new ColumnDef("비과세소득_J10", Yeta3200BM.ATTR_TAXMEJ10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_K01 : taxmEk01 */
        listColumnDefs.add(new ColumnDef("비과세소득_K01", Yeta3200BM.ATTR_TAXMEK01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_L01 : taxmEl01 */
        listColumnDefs.add(new ColumnDef("비과세소득_L01", Yeta3200BM.ATTR_TAXMEL01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M01 : taxmEm01 */
        listColumnDefs.add(new ColumnDef("비과세소득_M01", Yeta3200BM.ATTR_TAXMEM01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M02 : taxmEm02 */
        listColumnDefs.add(new ColumnDef("비과세소득_M02", Yeta3200BM.ATTR_TAXMEM02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_M03 : taxmEm03 */
        listColumnDefs.add(new ColumnDef("비과세소득_M03", Yeta3200BM.ATTR_TAXMEM03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_N01 : taxmEn01 */
        listColumnDefs.add(new ColumnDef("비과세소득_N01", Yeta3200BM.ATTR_TAXMEN01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_O01 : taxmEo01 */
        listColumnDefs.add(new ColumnDef("비과세소득_O01", Yeta3200BM.ATTR_TAXMEO01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_P01 : taxmEp01 */
        listColumnDefs.add(new ColumnDef("비과세소득_P01", Yeta3200BM.ATTR_TAXMEP01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_P02 : taxmEp02 */
        listColumnDefs.add(new ColumnDef("비과세소득_P02", Yeta3200BM.ATTR_TAXMEP02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Q01 : taxmEq01 */
        listColumnDefs.add(new ColumnDef("비과세소득_Q01", Yeta3200BM.ATTR_TAXMEQ01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_R01 : taxmEr01 */
        listColumnDefs.add(new ColumnDef("비과세소득_R01", Yeta3200BM.ATTR_TAXMER01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_R10 : taxmEr10 */
        listColumnDefs.add(new ColumnDef("비과세소득_R10", Yeta3200BM.ATTR_TAXMER10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_S01 : taxmEs01 */
        listColumnDefs.add(new ColumnDef("비과세소득_S01", Yeta3200BM.ATTR_TAXMES01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y02 : taxmEy02 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y02", Yeta3200BM.ATTR_TAXMEY02, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y03 : taxmEy03 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y03", Yeta3200BM.ATTR_TAXMEY03, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y21 : taxmEy21 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y21", Yeta3200BM.ATTR_TAXMEY21, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 비과세소득_Y22 : taxmEy22 */
        listColumnDefs.add(new ColumnDef("비과세소득_Y22", Yeta3200BM.ATTR_TAXMEY22, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T01 : taxmEt01 */
        listColumnDefs.add(new ColumnDef("감면소득_T01", Yeta3200BM.ATTR_TAXMET01, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T10 : taxmEt10 */
        listColumnDefs.add(new ColumnDef("감면소득_T10", Yeta3200BM.ATTR_TAXMET10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 감면소득_T20 : taxmEt20 */
        listColumnDefs.add(new ColumnDef("감면소득_T20", Yeta3200BM.ATTR_TAXMET20, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta3200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta3200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta3200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta3200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta3200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta3200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> edacRvyy;   /** column 연말정산귀속년도 : edacRvyy */
//
//        private TextField<String> settGbcd;   /** column 정산구분코드 : settGbcd */
//
//        private TextField<String> elctYymm;   /** column 지급년월 : elctYymm */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> siteNumb;   /** column 사업자등록번호 : siteNumb */
//
//        private TextField<String> taxmEa01;   /** column 비과세소득_A01 : taxmEa01 */
//
//        private TextField<String> taxmEb01;   /** column 비과세소득_B01 : taxmEb01 */
//
//        private TextField<String> taxmEc01;   /** column 비과세소득_C01 : taxmEc01 */
//
//        private TextField<String> taxmEd01;   /** column 비과세소득_D01 : taxmEd01 */
//
//        private TextField<String> taxmEe01;   /** column 비과세소득_E01 : taxmEe01 */
//
//        private TextField<String> taxmEe02;   /** column 비과세소득_E02 : taxmEe02 */
//
//        private TextField<String> taxmEe10;   /** column 비과세소득_E10 : taxmEe10 */
//
//        private TextField<String> taxmEf01;   /** column 비과세소득_F01 : taxmEf01 */
//
//        private TextField<String> taxmEg01;   /** column 비과세소득_G01 : taxmEg01 */
//
//        private TextField<String> taxmEh01;   /** column 비과세소득_H01 : taxmEh01 */
//
//        private TextField<String> taxmEh02;   /** column 비과세소득_H02 : taxmEh02 */
//
//        private TextField<String> taxmEh03;   /** column 비과세소득_H03 : taxmEh03 */
//
//        private TextField<String> taxmEh04;   /** column 비과세소득_H04 : taxmEh04 */
//
//        private TextField<String> taxmEh05;   /** column 비과세소득_H05 : taxmEh05 */
//
//        private TextField<String> taxmEh06;   /** column 비과세소득_H06 : taxmEh06 */
//
//        private TextField<String> taxmEh07;   /** column 비과세소득_H07 : taxmEh07 */
//
//        private TextField<String> taxmEh08;   /** column 비과세소득_H08 : taxmEh08 */
//
//        private TextField<String> taxmEh09;   /** column 비과세소득_H09 : taxmEh09 */
//
//        private TextField<String> taxmEh10;   /** column 비과세소득_H10 : taxmEh10 */
//
//        private TextField<String> taxmEh14;   /** column 비과세소득_H14 : taxmEh14 */
//
//        private TextField<String> taxmEh15;   /** column 비과세소득_H15 : taxmEh15 */
//
//        private TextField<String> taxmEh11;   /** column 비과세소득_H11 : taxmEh11 */
//
//        private TextField<String> taxmEh12;   /** column 비과세소득_H12 : taxmEh12 */
//
//        private TextField<String> taxmEh13;   /** column 비과세소득_H13 : taxmEh13 */
//
//        private TextField<String> taxmEh16;   /** column 비과세소득_H16 : taxmEh16 */
//
//        private TextField<String> taxmEi01;   /** column 비과세소득_I01 : taxmEi01 */
//
//        private TextField<String> taxmEj01;   /** column 비과세소득_J01 : taxmEj01 */
//
//        private TextField<String> taxmEj10;   /** column 비과세소득_J10 : taxmEj10 */
//
//        private TextField<String> taxmEk01;   /** column 비과세소득_K01 : taxmEk01 */
//
//        private TextField<String> taxmEl01;   /** column 비과세소득_L01 : taxmEl01 */
//
//        private TextField<String> taxmEm01;   /** column 비과세소득_M01 : taxmEm01 */
//
//        private TextField<String> taxmEm02;   /** column 비과세소득_M02 : taxmEm02 */
//
//        private TextField<String> taxmEm03;   /** column 비과세소득_M03 : taxmEm03 */
//
//        private TextField<String> taxmEn01;   /** column 비과세소득_N01 : taxmEn01 */
//
//        private TextField<String> taxmEo01;   /** column 비과세소득_O01 : taxmEo01 */
//
//        private TextField<String> taxmEp01;   /** column 비과세소득_P01 : taxmEp01 */
//
//        private TextField<String> taxmEp02;   /** column 비과세소득_P02 : taxmEp02 */
//
//        private TextField<String> taxmEq01;   /** column 비과세소득_Q01 : taxmEq01 */
//
//        private TextField<String> taxmEr01;   /** column 비과세소득_R01 : taxmEr01 */
//
//        private TextField<String> taxmEr10;   /** column 비과세소득_R10 : taxmEr10 */
//
//        private TextField<String> taxmEs01;   /** column 비과세소득_S01 : taxmEs01 */
//
//        private TextField<String> taxmEy02;   /** column 비과세소득_Y02 : taxmEy02 */
//
//        private TextField<String> taxmEy03;   /** column 비과세소득_Y03 : taxmEy03 */
//
//        private TextField<String> taxmEy21;   /** column 비과세소득_Y21 : taxmEy21 */
//
//        private TextField<String> taxmEy22;   /** column 비과세소득_Y22 : taxmEy22 */
//
//        private TextField<String> taxmEt01;   /** column 감면소득_T01 : taxmEt01 */
//
//        private TextField<String> taxmEt10;   /** column 감면소득_T10 : taxmEt10 */
//
//        private TextField<String> taxmEt20;   /** column 감면소득_T20 : taxmEt20 */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//      
          
          return listColumnDefs;
	}

}
