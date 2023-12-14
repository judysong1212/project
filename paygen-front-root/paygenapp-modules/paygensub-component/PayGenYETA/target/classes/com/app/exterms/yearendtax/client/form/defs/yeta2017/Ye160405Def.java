/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160405BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160405Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye160405Def(String chkPayrDef) {
		// setTitle(PayrLabel.titlePayr0304());

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160405ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160405ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe160405ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160405BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160405BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
		listColumnDefs.add(new ColumnDef("D5_원천징수의무자사업자등록번호", Ye160405BM.ATTR_WHDGDEBRBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160405BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160405BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_A01_종전 : taxmSa01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_A01_종전", Ye160405BM.ATTR_TAXMSA01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_B01_종전 : taxmSb01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_B01_종전", Ye160405BM.ATTR_TAXMSB01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_C01_종전 : taxmSc01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_C01_종전", Ye160405BM.ATTR_TAXMSC01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_D01_종전 : taxmSd01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_D01_종전", Ye160405BM.ATTR_TAXMSD01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E01_종전 : taxmSe01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_E01_종전", Ye160405BM.ATTR_TAXMSE01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E02_종전 : taxmSe02Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_E02_종전", Ye160405BM.ATTR_TAXMSE02JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_E10_종전 : taxmSe10Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_E10_종전", Ye160405BM.ATTR_TAXMSE10JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_F01_종전 : taxmSf01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_F01_종전", Ye160405BM.ATTR_TAXMSF01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_G01_종전 : taxmSg01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_G01_종전", Ye160405BM.ATTR_TAXMSG01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H01_종전 : taxmSh01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H01_종전", Ye160405BM.ATTR_TAXMSH01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H02_종전 : taxmSh02Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H02_종전", Ye160405BM.ATTR_TAXMSH02JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H03_종전 : taxmSh03Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H03_종전", Ye160405BM.ATTR_TAXMSH03JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H04_종전 : taxmSh04Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H04_종전", Ye160405BM.ATTR_TAXMSH04JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H05_종전 : taxmSh05Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H05_종전", Ye160405BM.ATTR_TAXMSH05JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H06_종전 : taxmSh06Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H06_종전", Ye160405BM.ATTR_TAXMSH06JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H07_종전 : taxmSh07Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H07_종전", Ye160405BM.ATTR_TAXMSH07JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H08_종전 : taxmSh08Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H08_종전", Ye160405BM.ATTR_TAXMSH08JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H09_종전 : taxmSh09Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H09_종전", Ye160405BM.ATTR_TAXMSH09JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H10_종전 : taxmSh10Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H10_종전", Ye160405BM.ATTR_TAXMSH10JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H14_종전 : taxmSh14Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H14_종전", Ye160405BM.ATTR_TAXMSH14JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H15_종전 : taxmSh15Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H15_종전", Ye160405BM.ATTR_TAXMSH15JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H11_종전 : taxmSh11Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H11_종전", Ye160405BM.ATTR_TAXMSH11JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H12_종전 : taxmSh12Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H12_종전", Ye160405BM.ATTR_TAXMSH12JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H13_종전 : taxmSh13Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H13_종전", Ye160405BM.ATTR_TAXMSH13JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_H16_종전 : taxmSh16Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_H16_종전", Ye160405BM.ATTR_TAXMSH16JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_I01_종전 : taxmSi01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_I01_종전", Ye160405BM.ATTR_TAXMSI01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J01_종전 : taxmSj01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_J01_종전", Ye160405BM.ATTR_TAXMSJ01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_J10_종전 : taxmSj10Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_J10_종전", Ye160405BM.ATTR_TAXMSJ10JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_K01_종전 : taxmSk01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_K01_종전", Ye160405BM.ATTR_TAXMSK01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_L01_종전 : taxmSl01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_L01_종전", Ye160405BM.ATTR_TAXMSL01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M01_종전 : taxmSm01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_M01_종전", Ye160405BM.ATTR_TAXMSM01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M02_종전 : taxmSm02Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_M02_종전", Ye160405BM.ATTR_TAXMSM02JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_M03_종전 : taxmSm03Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_M03_종전", Ye160405BM.ATTR_TAXMSM03JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_N01_종전 : taxmSn01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_N01_종전", Ye160405BM.ATTR_TAXMSN01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_O01_종전 : taxmSo01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_O01_종전", Ye160405BM.ATTR_TAXMSO01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P01_종전 : taxmSp01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_P01_종전", Ye160405BM.ATTR_TAXMSP01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_P02_종전 : taxmSp02Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_P02_종전", Ye160405BM.ATTR_TAXMSP02JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Q01_종전 : taxmSq01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Q01_종전", Ye160405BM.ATTR_TAXMSQ01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R01_종전 : taxmSr01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_R01_종전", Ye160405BM.ATTR_TAXMSR01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_R10_종전 : taxmSr10Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_R10_종전", Ye160405BM.ATTR_TAXMSR10JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_S01_종전 : taxmSs01Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_S01_종전", Ye160405BM.ATTR_TAXMSS01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y02_종전 : taxmSy02Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Y02_종전", Ye160405BM.ATTR_TAXMSY02JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y03_종전 : taxmSy03Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Y03_종전", Ye160405BM.ATTR_TAXMSY03JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y04_종전 : taxmSy04Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Y04_종전", Ye160405BM.ATTR_TAXMSY04JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y21_종전 : taxmSy21Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Y21_종전", Ye160405BM.ATTR_TAXMSY21JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 비과세소득_Y22_종전 : taxmSy22Jong */
		listColumnDefs.add(new ColumnDef("비과세소득_Y22_종전", Ye160405BM.ATTR_TAXMSY22JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T01_종전 : taxmSt01Jong */
		listColumnDefs.add(new ColumnDef("감면소득_T01_종전", Ye160405BM.ATTR_TAXMST01JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T10_종전 : taxmSt10Jong */
		listColumnDefs.add(new ColumnDef("감면소득_T10_종전", Ye160405BM.ATTR_TAXMST10JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T11_종전 : taxmSt11Jong */
		listColumnDefs.add(new ColumnDef("감면소득_T11_종전", Ye160405BM.ATTR_TAXMST11JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T12_종전 : taxmSt12Jong */
		listColumnDefs.add(new ColumnDef("감면소득_T12_종전", Ye160405BM.ATTR_TAXMST12JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 감면소득_T20_종전 : taxmSt20Jong */
		listColumnDefs.add(new ColumnDef("감면소득_T20_종전", Ye160405BM.ATTR_TAXMST20JONG, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160405BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160405BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160405BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160405BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160405BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160405BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
    


}
