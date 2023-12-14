/**
 * 공통화면 팝업 
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2022;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye160406BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Ye160406Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

	public Ye160406Def(String chkPayrDef) {

		if ("Ye161020Def".equals(chkPayrDef)) {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160406ColumnsList());

		} else {
			// setTitle(PayrLabel.titlePayr0304());
			setDaoClass("");
			setCustomListMethod(CLASS_YETA1900_TO_PYYT0304_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getYe160406ColumnsList());
		}

	}
    
    

	private List<ColumnDef> getYe160406ColumnsList() {

		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
	
	    
		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Ye160406BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 귀속연도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속연도", Ye160406BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye160406BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye160406BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
		listColumnDefs.add(new ColumnDef("원천징수의무자사업자등록번호", Ye160406BM.ATTR_WHDGDEBRBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 국민연금보험료금액 : natPennPrmmSum */
		listColumnDefs.add(new ColumnDef("국민연금보험료금액", Ye160406BM.ATTR_NATPENNPRMMSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 국민연금지역보험료금액 : natPennAraPrmmSum */
		listColumnDefs.add(new ColumnDef("국민연금지역보험료금액", Ye160406BM.ATTR_NATPENNARAPRMMSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 국민연금공제금액 : natPennDducSum */
		listColumnDefs.add(new ColumnDef("국민연금공제금액", Ye160406BM.ATTR_NATPENNDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_공무원연금금액 : puoferAnty */
		listColumnDefs.add(new ColumnDef("공적연금_공무원연금금액", Ye160406BM.ATTR_PUOFERANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_공무원연금공제금액 : puoferAntyDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_공무원연금공제금액", Ye160406BM.ATTR_PUOFERANTYDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_군인연금금액 : mltymAnty */
		listColumnDefs.add(new ColumnDef("공적연금_군인연금금액", Ye160406BM.ATTR_MLTYMANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_군인연금공제금액 : mltymAntyDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_군인연금공제금액", Ye160406BM.ATTR_MLTYMANTYDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_사립학교교직원연금금액 : prtafirSchlFalymmAnty */
		listColumnDefs.add(new ColumnDef("공적연금_사립학교교직원연금금액", Ye160406BM.ATTR_PRTAFIRSCHLFALYMMANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_사립학교직원연금공제금액 : prtafirSchlDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_사립학교직원연금공제금액", Ye160406BM.ATTR_PRTAFIRSCHLDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_별정우체국연금금액 : spildtnPstoficAnty */
		listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금금액", Ye160406BM.ATTR_SPILDTNPSTOFICANTY, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 공적연금_별정우체국연금공제금액 : spildtnPstoficDducSum */
		listColumnDefs.add(new ColumnDef("공적연금_별정우체국연금공제금액", Ye160406BM.ATTR_SPILDTNPSTOFICDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", Ye160406BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", Ye160406BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", Ye160406BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", Ye160406BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", Ye160406BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", Ye160406BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
    


}
