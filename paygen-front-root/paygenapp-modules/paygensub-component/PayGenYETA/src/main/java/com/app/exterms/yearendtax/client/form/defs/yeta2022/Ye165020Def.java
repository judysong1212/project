package com.app.exterms.yearendtax.client.form.defs.yeta2022;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye165020BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye165020Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye165020Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye165020Def(String chkPayrDef) {

		if ("".equals(chkPayrDef)) {

			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe165020ColumnsList());

		}

	}

    private List<ColumnDef> getYe165020ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165020BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye165020BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165020BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165020BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자관계구분코드 : famRltClCd */
        listColumnDefs.add(new ColumnDef("기부자관계구분코드", Ye165020BM.ATTR_FAMRLTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금총합계 : amtSum */
        listColumnDefs.add(new ColumnDef("기부금총합계", Ye165020BM.ATTR_AMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_법정기부금_10 : amt10 */
        listColumnDefs.add(new ColumnDef("기부금_법정기부금_10", Ye165020BM.ATTR_AMT10, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금_20 : amt20 */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금_20", Ye165020BM.ATTR_AMT20, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_종교단체외지정기부금_40 : amt40 */
        listColumnDefs.add(new ColumnDef("기부금_종교단체외지정기부금_40", Ye165020BM.ATTR_AMT40, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_종교단체지정기부금_41 : amt41 */
        listColumnDefs.add(new ColumnDef("기부금_종교단체지정기부금_41", Ye165020BM.ATTR_AMT41, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_우리사주조합기부금_42 : amt42 */
        listColumnDefs.add(new ColumnDef("기부금_우리사주조합기부금_42", Ye165020BM.ATTR_AMT42, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_공제제외기부금_50 : amt50 */
        listColumnDefs.add(new ColumnDef("기부금_공제제외기부금_50", Ye165020BM.ATTR_AMT50, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165020BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165020BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165020BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165020BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165020BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165020BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

			}
		});

		return listColumnDefs;
	}

}
 
