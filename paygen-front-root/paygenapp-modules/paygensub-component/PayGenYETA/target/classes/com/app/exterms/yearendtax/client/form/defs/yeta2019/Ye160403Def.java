/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2019;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye160403BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160403Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye160403Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160403ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160403ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe160403ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160403BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160403BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160403BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160403BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 지급년월 : elctYymm */
		listColumnDefs.add(new ColumnDef("지급년월", Ye160403BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_A01_비과세 : taxmSa01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_A01_비과세", Ye160403BM.ATTR_TAXMSA01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_B01_비과세 : taxmSb01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_B01_비과세", Ye160403BM.ATTR_TAXMSB01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_C01_비과세 : taxmSc01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_C01_비과세", Ye160403BM.ATTR_TAXMSC01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_D01_비과세 : taxmSd01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_D01_비과세", Ye160403BM.ATTR_TAXMSD01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E01_비과세 : taxmSe01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_E01_비과세", Ye160403BM.ATTR_TAXMSE01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E02_비과세 : taxmSe02Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_E02_비과세", Ye160403BM.ATTR_TAXMSE02BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E10_비과세 : taxmSe10Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_E10_비과세", Ye160403BM.ATTR_TAXMSE10BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_F01_비과세 : taxmSf01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_F01_비과세", Ye160403BM.ATTR_TAXMSF01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_G01_비과세 : taxmSg01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_G01_비과세", Ye160403BM.ATTR_TAXMSG01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H01_비과세 : taxmSh01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H01_비과세", Ye160403BM.ATTR_TAXMSH01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H02_비과세 : taxmSh02Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H02_비과세", Ye160403BM.ATTR_TAXMSH02BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H03_비과세 : taxmSh03Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H03_비과세", Ye160403BM.ATTR_TAXMSH03BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H04_비과세 : taxmSh04Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H04_비과세", Ye160403BM.ATTR_TAXMSH04BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H05_비과세 : taxmSh05Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H05_비과세", Ye160403BM.ATTR_TAXMSH05BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H06_비과세 : taxmSh06Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H06_비과세", Ye160403BM.ATTR_TAXMSH06BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H07_비과세 : taxmSh07Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H07_비과세", Ye160403BM.ATTR_TAXMSH07BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H08_비과세 : taxmSh08Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H08_비과세", Ye160403BM.ATTR_TAXMSH08BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H09_비과세 : taxmSh09Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H09_비과세", Ye160403BM.ATTR_TAXMSH09BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H10_비과세 : taxmSh10Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H10_비과세", Ye160403BM.ATTR_TAXMSH10BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H14_비과세 : taxmSh14Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H14_비과세", Ye160403BM.ATTR_TAXMSH14BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H15_비과세 : taxmSh15Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H15_비과세", Ye160403BM.ATTR_TAXMSH15BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H11_비과세 : taxmSh11Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H11_비과세", Ye160403BM.ATTR_TAXMSH11BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H12_비과세 : taxmSh12Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H12_비과세", Ye160403BM.ATTR_TAXMSH12BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H13_비과세 : taxmSh13Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H13_비과세", Ye160403BM.ATTR_TAXMSH13BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H16_비과세 : taxmSh16Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_H16_비과세", Ye160403BM.ATTR_TAXMSH16BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_I01_비과세 : taxmSi01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_I01_비과세", Ye160403BM.ATTR_TAXMSI01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J01_비과세 : taxmSj01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_J01_비과세", Ye160403BM.ATTR_TAXMSJ01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J10_비과세 : taxmSj10Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_J10_비과세", Ye160403BM.ATTR_TAXMSJ10BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_K01_비과세 : taxmSk01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_K01_비과세", Ye160403BM.ATTR_TAXMSK01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_L01_비과세 : taxmSl01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_L01_비과세", Ye160403BM.ATTR_TAXMSL01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M01_비과세 : taxmSm01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_M01_비과세", Ye160403BM.ATTR_TAXMSM01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M02_비과세 : taxmSm02Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_M02_비과세", Ye160403BM.ATTR_TAXMSM02BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M03_비과세 : taxmSm03Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_M03_비과세", Ye160403BM.ATTR_TAXMSM03BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_N01_비과세 : taxmSn01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_N01_비과세", Ye160403BM.ATTR_TAXMSN01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_O01_비과세 : taxmSo01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_O01_비과세", Ye160403BM.ATTR_TAXMSO01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P01_비과세 : taxmSp01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_P01_비과세", Ye160403BM.ATTR_TAXMSP01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P02_비과세 : taxmSp02Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_P02_비과세", Ye160403BM.ATTR_TAXMSP02BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Q01_비과세 : taxmSq01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Q01_비과세", Ye160403BM.ATTR_TAXMSQ01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R01_비과세 : taxmSr01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_R01_비과세", Ye160403BM.ATTR_TAXMSR01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R10_비과세 : taxmSr10Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_R10_비과세", Ye160403BM.ATTR_TAXMSR10BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_S01_비과세 : taxmSs01Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_S01_비과세", Ye160403BM.ATTR_TAXMSS01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y02_비과세 : taxmSy02Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Y02_비과세", Ye160403BM.ATTR_TAXMSY02BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y03_비과세 : taxmSy03Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Y03_비과세", Ye160403BM.ATTR_TAXMSY03BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y04_비과세 : taxmSy04Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Y04_비과세", Ye160403BM.ATTR_TAXMSY04BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y21_비과세 : taxmSy21Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Y21_비과세", Ye160403BM.ATTR_TAXMSY21BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y22_비과세 : taxmSy22Bi */
		listColumnDefs.add(new ColumnDef("비과세소득_Y22_비과세", Ye160403BM.ATTR_TAXMSY22BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T01_비과세 : taxmSt01Bi */
		listColumnDefs.add(new ColumnDef("감면소득_T01_비과세", Ye160403BM.ATTR_TAXMST01BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T10_비과세 : taxmSt10Bi */
		listColumnDefs.add(new ColumnDef("감면소득_T10_비과세", Ye160403BM.ATTR_TAXMST10BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T11_비과세 : taxmSt11Bi */
		listColumnDefs.add(new ColumnDef("감면소득_T11_비과세", Ye160403BM.ATTR_TAXMST11BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T12_비과세 : taxmSt12Bi */
		listColumnDefs.add(new ColumnDef("감면소득_T12_비과세", Ye160403BM.ATTR_TAXMST12BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T20_비과세 : taxmSt20Bi */
		listColumnDefs.add(new ColumnDef("감면소득_T20_비과세", Ye160403BM.ATTR_TAXMST20BI, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160403BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160403BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160403BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160403BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160403BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160403BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

//		private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//		private TextField<String> elctYymm;   /** column 지급년월 : elctYymm */
//
//		private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//		private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//		private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//		private TextField<String> taxmSa01Bi;   /** column 비과세소득_A01_비과세 : taxmSa01Bi */
//
//		private TextField<String> taxmSb01Bi;   /** column 비과세소득_B01_비과세 : taxmSb01Bi */
//
//		private TextField<String> taxmSc01Bi;   /** column 비과세소득_C01_비과세 : taxmSc01Bi */
//
//		private TextField<String> taxmSd01Bi;   /** column 비과세소득_D01_비과세 : taxmSd01Bi */
//
//		private TextField<String> taxmSe01Bi;   /** column 비과세소득_E01_비과세 : taxmSe01Bi */
//
//		private TextField<String> taxmSe02Bi;   /** column 비과세소득_E02_비과세 : taxmSe02Bi */
//
//		private TextField<String> taxmSe10Bi;   /** column 비과세소득_E10_비과세 : taxmSe10Bi */
//
//		private TextField<String> taxmSf01Bi;   /** column 비과세소득_F01_비과세 : taxmSf01Bi */
//
//		private TextField<String> taxmSg01Bi;   /** column 비과세소득_G01_비과세 : taxmSg01Bi */
//
//		private TextField<String> taxmSh01Bi;   /** column 비과세소득_H01_비과세 : taxmSh01Bi */
//
//		private TextField<String> taxmSh02Bi;   /** column 비과세소득_H02_비과세 : taxmSh02Bi */
//
//		private TextField<String> taxmSh03Bi;   /** column 비과세소득_H03_비과세 : taxmSh03Bi */
//
//		private TextField<String> taxmSh04Bi;   /** column 비과세소득_H04_비과세 : taxmSh04Bi */
//
//		private TextField<String> taxmSh05Bi;   /** column 비과세소득_H05_비과세 : taxmSh05Bi */
//
//		private TextField<String> taxmSh06Bi;   /** column 비과세소득_H06_비과세 : taxmSh06Bi */
//
//		private TextField<String> taxmSh07Bi;   /** column 비과세소득_H07_비과세 : taxmSh07Bi */
//
//		private TextField<String> taxmSh08Bi;   /** column 비과세소득_H08_비과세 : taxmSh08Bi */
//
//		private TextField<String> taxmSh09Bi;   /** column 비과세소득_H09_비과세 : taxmSh09Bi */
//
//		private TextField<String> taxmSh10Bi;   /** column 비과세소득_H10_비과세 : taxmSh10Bi */
//
//		private TextField<String> taxmSh14Bi;   /** column 비과세소득_H14_비과세 : taxmSh14Bi */
//
//		private TextField<String> taxmSh15Bi;   /** column 비과세소득_H15_비과세 : taxmSh15Bi */
//
//		private TextField<String> taxmSh11Bi;   /** column 비과세소득_H11_비과세 : taxmSh11Bi */
//
//		private TextField<String> taxmSh12Bi;   /** column 비과세소득_H12_비과세 : taxmSh12Bi */
//
//		private TextField<String> taxmSh13Bi;   /** column 비과세소득_H13_비과세 : taxmSh13Bi */
//
//		private TextField<String> taxmSh16Bi;   /** column 비과세소득_H16_비과세 : taxmSh16Bi */
//
//		private TextField<String> taxmSi01Bi;   /** column 비과세소득_I01_비과세 : taxmSi01Bi */
//
//		private TextField<String> taxmSj01Bi;   /** column 비과세소득_J01_비과세 : taxmSj01Bi */
//
//		private TextField<String> taxmSj10Bi;   /** column 비과세소득_J10_비과세 : taxmSj10Bi */
//
//		private TextField<String> taxmSk01Bi;   /** column 비과세소득_K01_비과세 : taxmSk01Bi */
//
//		private TextField<String> taxmSl01Bi;   /** column 비과세소득_L01_비과세 : taxmSl01Bi */
//
//		private TextField<String> taxmSm01Bi;   /** column 비과세소득_M01_비과세 : taxmSm01Bi */
//
//		private TextField<String> taxmSm02Bi;   /** column 비과세소득_M02_비과세 : taxmSm02Bi */
//
//		private TextField<String> taxmSm03Bi;   /** column 비과세소득_M03_비과세 : taxmSm03Bi */
//
//		private TextField<String> taxmSn01Bi;   /** column 비과세소득_N01_비과세 : taxmSn01Bi */
//
//		private TextField<String> taxmSo01Bi;   /** column 비과세소득_O01_비과세 : taxmSo01Bi */
//
//		private TextField<String> taxmSp01Bi;   /** column 비과세소득_P01_비과세 : taxmSp01Bi */
//
//		private TextField<String> taxmSp02Bi;   /** column 비과세소득_P02_비과세 : taxmSp02Bi */
//
//		private TextField<String> taxmSq01Bi;   /** column 비과세소득_Q01_비과세 : taxmSq01Bi */
//
//		private TextField<String> taxmSr01Bi;   /** column 비과세소득_R01_비과세 : taxmSr01Bi */
//
//		private TextField<String> taxmSr10Bi;   /** column 비과세소득_R10_비과세 : taxmSr10Bi */
//
//		private TextField<String> taxmSs01Bi;   /** column 비과세소득_S01_비과세 : taxmSs01Bi */
//
//		private TextField<String> taxmSy02Bi;   /** column 비과세소득_Y02_비과세 : taxmSy02Bi */
//
//		private TextField<String> taxmSy03Bi;   /** column 비과세소득_Y03_비과세 : taxmSy03Bi */
//
//		private TextField<String> taxmSy04Bi;   /** column 비과세소득_Y04_비과세 : taxmSy04Bi */
//
//		private TextField<String> taxmSy21Bi;   /** column 비과세소득_Y21_비과세 : taxmSy21Bi */
//
//		private TextField<String> taxmSy22Bi;   /** column 비과세소득_Y22_비과세 : taxmSy22Bi */
//
//		private TextField<String> taxmSt01Bi;   /** column 감면소득_T01_비과세 : taxmSt01Bi */
//
//		private TextField<String> taxmSt10Bi;   /** column 감면소득_T10_비과세 : taxmSt10Bi */
//
//		private TextField<String> taxmSt11Bi;   /** column 감면소득_T11_비과세 : taxmSt11Bi */
//
//		private TextField<String> taxmSt12Bi;   /** column 감면소득_T12_비과세 : taxmSt12Bi */
//
//		private TextField<String> taxmSt20Bi;   /** column 감면소득_T20_비과세 : taxmSt20Bi */
//
//		private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//		private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//		private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//		private TextField<String> ismt;   /** column 수정자 : ismt */
//
//		private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//		private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */

		return listColumnDefs;
	}
    


}
