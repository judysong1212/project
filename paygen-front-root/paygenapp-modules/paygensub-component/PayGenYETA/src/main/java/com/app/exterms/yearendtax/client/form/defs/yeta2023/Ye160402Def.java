/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2023;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye160402BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160402Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye160402Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160402ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160402ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe160402ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160402BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 지급년월 : elctYymm */
		listColumnDefs.add(new ColumnDef("지급년월", Ye160402BM.ATTR_ELCTYYMM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160402BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160402BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160402BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_A01_과세 : taxmSa01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_A01_과세", Ye160402BM.ATTR_TAXMSA01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_B01_과세 : taxmSb01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_B01_과세", Ye160402BM.ATTR_TAXMSB01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_C01_과세 : taxmSc01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_C01_과세", Ye160402BM.ATTR_TAXMSC01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_D01_과세 : taxmSd01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_D01_과세", Ye160402BM.ATTR_TAXMSD01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E01_과세 : taxmSe01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_E01_과세", Ye160402BM.ATTR_TAXMSE01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E02_과세 : taxmSe02Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_E02_과세", Ye160402BM.ATTR_TAXMSE02KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E10_과세 : taxmSe10Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_E10_과세", Ye160402BM.ATTR_TAXMSE10KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_F01_과세 : taxmSf01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_F01_과세", Ye160402BM.ATTR_TAXMSF01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_G01_과세 : taxmSg01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_G01_과세", Ye160402BM.ATTR_TAXMSG01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H01_과세 : taxmSh01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H01_과세", Ye160402BM.ATTR_TAXMSH01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H02_과세 : taxmSh02Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H02_과세", Ye160402BM.ATTR_TAXMSH02KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H03_과세 : taxmSh03Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H03_과세", Ye160402BM.ATTR_TAXMSH03KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H04_과세 : taxmSh04Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H04_과세", Ye160402BM.ATTR_TAXMSH04KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H05_과세 : taxmSh05Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H05_과세", Ye160402BM.ATTR_TAXMSH05KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H06_과세 : taxmSh06Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H06_과세", Ye160402BM.ATTR_TAXMSH06KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H07_과세 : taxmSh07Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H07_과세", Ye160402BM.ATTR_TAXMSH07KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H08_과세 : taxmSh08Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H08_과세", Ye160402BM.ATTR_TAXMSH08KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H09_과세 : taxmSh09Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H09_과세", Ye160402BM.ATTR_TAXMSH09KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H10_과세 : taxmSh10Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H10_과세", Ye160402BM.ATTR_TAXMSH10KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H14_과세 : taxmSh14Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H14_과세", Ye160402BM.ATTR_TAXMSH14KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H15_과세 : taxmSh15Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H15_과세", Ye160402BM.ATTR_TAXMSH15KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H11_과세 : taxmSh11Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H11_과세", Ye160402BM.ATTR_TAXMSH11KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H12_과세 : taxmSh12Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H12_과세", Ye160402BM.ATTR_TAXMSH12KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H13_과세 : taxmSh13Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H13_과세", Ye160402BM.ATTR_TAXMSH13KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H16_과세 : taxmSh16Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_H16_과세", Ye160402BM.ATTR_TAXMSH16KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_I01_과세 : taxmSi01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_I01_과세", Ye160402BM.ATTR_TAXMSI01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J01_과세 : taxmSj01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_J01_과세", Ye160402BM.ATTR_TAXMSJ01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J10_과세 : taxmSj10Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_J10_과세", Ye160402BM.ATTR_TAXMSJ10KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_K01_과세 : taxmSk01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_K01_과세", Ye160402BM.ATTR_TAXMSK01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_L01_과세 : taxmSl01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_L01_과세", Ye160402BM.ATTR_TAXMSL01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M01_과세 : taxmSm01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_M01_과세", Ye160402BM.ATTR_TAXMSM01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M02_과세 : taxmSm02Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_M02_과세", Ye160402BM.ATTR_TAXMSM02KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M03_과세 : taxmSm03Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_M03_과세", Ye160402BM.ATTR_TAXMSM03KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_N01_과세 : taxmSn01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_N01_과세", Ye160402BM.ATTR_TAXMSN01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_O01_과세 : taxmSo01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_O01_과세", Ye160402BM.ATTR_TAXMSO01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P01_과세 : taxmSp01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_P01_과세", Ye160402BM.ATTR_TAXMSP01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P02_과세 : taxmSp02Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_P02_과세", Ye160402BM.ATTR_TAXMSP02KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Q01_과세 : taxmSq01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Q01_과세", Ye160402BM.ATTR_TAXMSQ01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R01_과세 : taxmSr01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_R01_과세", Ye160402BM.ATTR_TAXMSR01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R10_과세 : taxmSr10Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_R10_과세", Ye160402BM.ATTR_TAXMSR10KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_S01_과세 : taxmSs01Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_S01_과세", Ye160402BM.ATTR_TAXMSS01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y02_과세 : taxmSy02Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Y02_과세", Ye160402BM.ATTR_TAXMSY02KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y03_과세 : taxmSy03Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Y03_과세", Ye160402BM.ATTR_TAXMSY03KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y04_과세 : taxmSy04Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Y04_과세", Ye160402BM.ATTR_TAXMSY04KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y21_과세 : taxmSy21Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Y21_과세", Ye160402BM.ATTR_TAXMSY21KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y22_과세 : taxmSy22Ka */
		listColumnDefs.add(new ColumnDef("비과세소득_Y22_과세", Ye160402BM.ATTR_TAXMSY22KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T01_과세 : taxmSt01Ka */
		listColumnDefs.add(new ColumnDef("감면소득_T01_과세", Ye160402BM.ATTR_TAXMST01KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T10_과세 : taxmSt10Ka */
		listColumnDefs.add(new ColumnDef("감면소득_T10_과세", Ye160402BM.ATTR_TAXMST10KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T11_과세 : taxmSt11Ka */
		listColumnDefs.add(new ColumnDef("감면소득_T11_과세", Ye160402BM.ATTR_TAXMST11KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T12_과세 : taxmSt12Ka */
		listColumnDefs.add(new ColumnDef("감면소득_T12_과세", Ye160402BM.ATTR_TAXMST12KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T20_과세 : taxmSt20Ka */
		listColumnDefs.add(new ColumnDef("감면소득_T20_과세", Ye160402BM.ATTR_TAXMST20KA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160402BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160402BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160402BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160402BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160402BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160402BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//		private TextField<String> taxmSa01Ka;   /** column 비과세소득_A01_과세 : taxmSa01Ka */
//
//		private TextField<String> taxmSb01Ka;   /** column 비과세소득_B01_과세 : taxmSb01Ka */
//
//		private TextField<String> taxmSc01Ka;   /** column 비과세소득_C01_과세 : taxmSc01Ka */
//
//		private TextField<String> taxmSd01Ka;   /** column 비과세소득_D01_과세 : taxmSd01Ka */
//
//		private TextField<String> taxmSe01Ka;   /** column 비과세소득_E01_과세 : taxmSe01Ka */
//
//		private TextField<String> taxmSe02Ka;   /** column 비과세소득_E02_과세 : taxmSe02Ka */
//
//		private TextField<String> taxmSe10Ka;   /** column 비과세소득_E10_과세 : taxmSe10Ka */
//
//		private TextField<String> taxmSf01Ka;   /** column 비과세소득_F01_과세 : taxmSf01Ka */
//
//		private TextField<String> taxmSg01Ka;   /** column 비과세소득_G01_과세 : taxmSg01Ka */
//
//		private TextField<String> taxmSh01Ka;   /** column 비과세소득_H01_과세 : taxmSh01Ka */
//
//		private TextField<String> taxmSh02Ka;   /** column 비과세소득_H02_과세 : taxmSh02Ka */
//
//		private TextField<String> taxmSh03Ka;   /** column 비과세소득_H03_과세 : taxmSh03Ka */
//
//		private TextField<String> taxmSh04Ka;   /** column 비과세소득_H04_과세 : taxmSh04Ka */
//
//		private TextField<String> taxmSh05Ka;   /** column 비과세소득_H05_과세 : taxmSh05Ka */
//
//		private TextField<String> taxmSh06Ka;   /** column 비과세소득_H06_과세 : taxmSh06Ka */
//
//		private TextField<String> taxmSh07Ka;   /** column 비과세소득_H07_과세 : taxmSh07Ka */
//
//		private TextField<String> taxmSh08Ka;   /** column 비과세소득_H08_과세 : taxmSh08Ka */
//
//		private TextField<String> taxmSh09Ka;   /** column 비과세소득_H09_과세 : taxmSh09Ka */
//
//		private TextField<String> taxmSh10Ka;   /** column 비과세소득_H10_과세 : taxmSh10Ka */
//
//		private TextField<String> taxmSh14Ka;   /** column 비과세소득_H14_과세 : taxmSh14Ka */
//
//		private TextField<String> taxmSh15Ka;   /** column 비과세소득_H15_과세 : taxmSh15Ka */
//
//		private TextField<String> taxmSh11Ka;   /** column 비과세소득_H11_과세 : taxmSh11Ka */
//
//		private TextField<String> taxmSh12Ka;   /** column 비과세소득_H12_과세 : taxmSh12Ka */
//
//		private TextField<String> taxmSh13Ka;   /** column 비과세소득_H13_과세 : taxmSh13Ka */
//
//		private TextField<String> taxmSh16Ka;   /** column 비과세소득_H16_과세 : taxmSh16Ka */
//
//		private TextField<String> taxmSi01Ka;   /** column 비과세소득_I01_과세 : taxmSi01Ka */
//
//		private TextField<String> taxmSj01Ka;   /** column 비과세소득_J01_과세 : taxmSj01Ka */
//
//		private TextField<String> taxmSj10Ka;   /** column 비과세소득_J10_과세 : taxmSj10Ka */
//
//		private TextField<String> taxmSk01Ka;   /** column 비과세소득_K01_과세 : taxmSk01Ka */
//
//		private TextField<String> taxmSl01Ka;   /** column 비과세소득_L01_과세 : taxmSl01Ka */
//
//		private TextField<String> taxmSm01Ka;   /** column 비과세소득_M01_과세 : taxmSm01Ka */
//
//		private TextField<String> taxmSm02Ka;   /** column 비과세소득_M02_과세 : taxmSm02Ka */
//
//		private TextField<String> taxmSm03Ka;   /** column 비과세소득_M03_과세 : taxmSm03Ka */
//
//		private TextField<String> taxmSn01Ka;   /** column 비과세소득_N01_과세 : taxmSn01Ka */
//
//		private TextField<String> taxmSo01Ka;   /** column 비과세소득_O01_과세 : taxmSo01Ka */
//
//		private TextField<String> taxmSp01Ka;   /** column 비과세소득_P01_과세 : taxmSp01Ka */
//
//		private TextField<String> taxmSp02Ka;   /** column 비과세소득_P02_과세 : taxmSp02Ka */
//
//		private TextField<String> taxmSq01Ka;   /** column 비과세소득_Q01_과세 : taxmSq01Ka */
//
//		private TextField<String> taxmSr01Ka;   /** column 비과세소득_R01_과세 : taxmSr01Ka */
//
//		private TextField<String> taxmSr10Ka;   /** column 비과세소득_R10_과세 : taxmSr10Ka */
//
//		private TextField<String> taxmSs01Ka;   /** column 비과세소득_S01_과세 : taxmSs01Ka */
//
//		private TextField<String> taxmSy02Ka;   /** column 비과세소득_Y02_과세 : taxmSy02Ka */
//
//		private TextField<String> taxmSy03Ka;   /** column 비과세소득_Y03_과세 : taxmSy03Ka */
//
//		private TextField<String> taxmSy04Ka;   /** column 비과세소득_Y04_과세 : taxmSy04Ka */
//
//		private TextField<String> taxmSy21Ka;   /** column 비과세소득_Y21_과세 : taxmSy21Ka */
//
//		private TextField<String> taxmSy22Ka;   /** column 비과세소득_Y22_과세 : taxmSy22Ka */
//
//		private TextField<String> taxmSt01Ka;   /** column 감면소득_T01_과세 : taxmSt01Ka */
//
//		private TextField<String> taxmSt10Ka;   /** column 감면소득_T10_과세 : taxmSt10Ka */
//
//		private TextField<String> taxmSt11Ka;   /** column 감면소득_T11_과세 : taxmSt11Ka */
//
//		private TextField<String> taxmSt12Ka;   /** column 감면소득_T12_과세 : taxmSt12Ka */
//
//		private TextField<String> taxmSt20Ka;   /** column 감면소득_T20_과세 : taxmSt20Ka */
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
